package com.baidu.navi.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.baidunavis.control.NavPoiController;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.logic.C1868q;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navi.fragment.ContentFragmentManager;
import com.baidu.navi.fragment.RoutePlanFragment;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.SearchParamKey;
import com.baidu.navi.util.ShareTools;
import com.baidu.navi.utils.StatisticUtils;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.userdata.BNFavoriteManager;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.map.ItemizedOverlayUtil;
import com.baidu.platform.comapi.map.MapStatus;
import java.util.ArrayList;

public class PoiController {
    private static final int K_TIMEOUT = 8000;
    private static final String TAG = "PoiController";
    private Context mContext;
    private int mDistrictId;
    private int mId;
    private int mModuleFrom;
    private Handler mRPHandler;
    private String mSearchKey;
    private int mSearchRsultNetMode;
    private ShareTools mShareTool;
    private SearchPoi mStreetViewPoi;
    private Handler mUIHandler;
    private Handler mWorkHandler;

    public interface AntiGeoCallBack {
        void onFail();

        void onRevSearchPoi(SearchPoi searchPoi);

        void onStart();
    }

    class FavoriteJob implements Runnable {
        public static final int ADD_EVENT = 0;
        public static final int CANCLE_EVENT = 2;
        public static final int CHECK_EVENT = 1;
        private int mEvent = -1;
        private FavoriteResultCallBack mFavoriteResultCallBack;
        private GeoPoint mPoint;
        private SearchPoi mSearchPoi;

        /* renamed from: com.baidu.navi.controller.PoiController$FavoriteJob$1 */
        class C37161 implements Runnable {
            C37161() {
            }

            public void run() {
                FavoriteJob.this.mFavoriteResultCallBack.onFavoritEventStart();
            }
        }

        public FavoriteJob(GeoPoint point, FavoriteResultCallBack favoriteResultCallBack) {
            this.mFavoriteResultCallBack = favoriteResultCallBack;
            this.mPoint = point;
        }

        public FavoriteJob(SearchPoi searchPoi, FavoriteResultCallBack favoriteResultCallBack) {
            this.mFavoriteResultCallBack = favoriteResultCallBack;
            this.mSearchPoi = searchPoi;
        }

        public FavoriteJob setEvent(int event) {
            this.mEvent = event;
            return this;
        }

        public void run() {
            if (this.mFavoriteResultCallBack != null) {
                PoiController.this.mUIHandler.post(new C37161());
                switch (this.mEvent) {
                    case 0:
                        boolean isAddSuccess = false;
                        switch (BNFavoriteManager.getInstance().addNewPoiToFavorite(this.mSearchPoi)) {
                            case -2:
                                TipTool.onCreateToastDialog(PoiController.this.mContext, PoiController.this.mContext.getString(C0965R.string.detail_fav_full));
                                break;
                            case -1:
                                TipTool.onCreateToastDialog(PoiController.this.mContext, PoiController.this.mContext.getString(C0965R.string.detail_fav_add_duplicate_or_null));
                                break;
                            case 0:
                                TipTool.onCreateToastDialog(PoiController.this.mContext, PoiController.this.mContext.getString(C0965R.string.detail_fav_fail));
                                break;
                            case 1:
                                TipTool.onCreateToastDialog(PoiController.this.mContext, PoiController.this.mContext.getString(C0965R.string.detail_favorite));
                                BNMapController.getInstance().updateLayer(16);
                                isAddSuccess = true;
                                break;
                        }
                        final boolean addSuccess = isAddSuccess;
                        PoiController.this.mUIHandler.post(new Runnable() {
                            public void run() {
                                FavoriteJob.this.mFavoriteResultCallBack.onAddResult(addSuccess);
                            }
                        });
                        return;
                    case 1:
                        boolean isFavorite;
                        if (this.mPoint == null) {
                            isFavorite = BNFavoriteManager.getInstance().isPoiExistInFavByPoint(this.mSearchPoi);
                        } else {
                            isFavorite = BNFavoriteManager.getInstance().isPoiExistInFavByPoint(this.mPoint);
                        }
                        final boolean favoriteRet = isFavorite;
                        PoiController.this.mUIHandler.post(new Runnable() {
                            public void run() {
                                FavoriteJob.this.mFavoriteResultCallBack.onCheckResult(favoriteRet);
                            }
                        });
                        return;
                    case 2:
                        boolean favSuccess = BNFavoriteManager.getInstance().removePoiFromFavorite(this.mSearchPoi);
                        if (favSuccess) {
                            BNMapController.getInstance().updateLayer(16);
                            TipTool.onCreateToastDialog(PoiController.this.mContext, PoiController.this.mContext.getString(C0965R.string.detail_fav_cancle));
                        } else {
                            TipTool.onCreateToastDialog(PoiController.this.mContext, PoiController.this.mContext.getString(C0965R.string.detail_fav_cancle_fail));
                        }
                        final boolean isSuccess = favSuccess;
                        PoiController.this.mUIHandler.post(new Runnable() {
                            public void run() {
                                FavoriteJob.this.mFavoriteResultCallBack.onRemoveResult(isSuccess);
                            }
                        });
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public interface FavoriteResultCallBack {
        void onAddResult(boolean z);

        void onCheckResult(boolean z);

        void onFavoritEventStart();

        void onRemoveResult(boolean z);
    }

    static class InnerHolder {
        static PoiController mInstance = new PoiController();

        InnerHolder() {
        }
    }

    public interface ShareEventCallBack {
        void onEnd();

        void onStart();
    }

    public interface StreetSearchCallBack {
        void onFail();

        void onRevStreetId(String str);

        void onStart();
    }

    private PoiController() {
        this.mSearchRsultNetMode = 1;
        this.mShareTool = null;
        this.mRPHandler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 4:
                        Bundle bundle = new Bundle();
                        bundle.putInt(ContentFragmentManager.MODULE_FROM, PoiController.this.mModuleFrom);
                        C1328h.a().showFragment(52, bundle);
                        BNRoutePlaner.getInstance().removeRouteResultHandler(PoiController.this.mRPHandler);
                        return;
                    case 7:
                        BNRoutePlaner.getInstance().removeRouteResultHandler(PoiController.this.mRPHandler);
                        return;
                    case 8:
                        StatisticUtils.statSetDestFromPoi();
                        return;
                    case 32:
                        BNRoutePlaner.getInstance().removeRouteResultHandler(PoiController.this.mRPHandler);
                        return;
                    default:
                        return;
                }
            }
        };
        this.mUIHandler = new Handler(Looper.getMainLooper());
        this.mContext = BaiduNaviApplication.getInstance();
        FavoriteDestinationController.getInstance().queryAllFavoriteDestFromDB(null);
    }

    public static PoiController getInstance() {
        return InnerHolder.mInstance;
    }

    public void setSearchKey(String key) {
        this.mSearchKey = key;
    }

    public SearchPoi getStreetViewPoi() {
        return this.mStreetViewPoi;
    }

    public String getDistance2CurrentPoint(SearchPoi searchPoi) {
        if (searchPoi == null) {
            return StyleManager.getString(C0965R.string.search_empty_data);
        }
        return getDistance2CurrentPoint(searchPoi.mViewPoint);
    }

    public String getDistance2CurrentPoint(GeoPoint point) {
        if (point == null || !point.isValid()) {
            return "";
        }
        GeoPoint center = BNLocationManagerProxy.getInstance().getLastValidLocation();
        if (center == null || !center.isValid()) {
            return "";
        }
        return StringUtils.getDistance((double) (point.getLongitudeE6() - center.getLongitudeE6()), (double) (point.getLatitudeE6() - center.getLatitudeE6()));
    }

    public void backFragment() {
        C1328h.a().back();
    }

    public void checkFavorite(GeoPoint point, FavoriteResultCallBack favoriteResultCallBack) {
    }

    public void checkFavorite(SearchPoi point, FavoriteResultCallBack favoriteResultCallBack) {
    }

    public void removeFavorite(SearchPoi point, FavoriteResultCallBack favoriteResultCallBack) {
    }

    public void addFavorite(SearchPoi point, FavoriteResultCallBack favoriteResultCallBack) {
    }

    public void setSearchNetMode(int searchNetMode) {
        this.mSearchRsultNetMode = searchNetMode;
    }

    public int getSearchNetMode() {
        return this.mSearchRsultNetMode;
    }

    public void updatePoiBkgLayer(ArrayList<SearchPoi> searchPois) {
        if (searchPois != null) {
            BNPoiSearcher.getInstance().clearBkgCache();
            ArrayList<GeoPoint> geoList = new ArrayList(searchPois.size());
            for (int i = 0; i < searchPois.size(); i++) {
                SearchPoi poi = (SearchPoi) searchPois.get(i);
                if (poi != null) {
                    geoList.add(poi.mViewPoint);
                }
            }
            BNPoiSearcher.getInstance().updateBkgCache(geoList, -1);
            BNMapController.getInstance().updateLayer(4);
            BNMapController.getInstance().updateLayer(3);
        }
    }

    public void focusPoi(SearchPoi poi) {
        if (poi != null) {
            focusPoi(poi.mViewPoint);
        }
    }

    public void focusPoi(ArrayList<SearchPoi> mPoiList, int id) {
        if (mPoiList != null) {
            this.mId = id;
            BNPoiSearcher.getInstance().clearPoiCache();
            BNPoiSearcher.getInstance().updatePoiCacheWithList(mPoiList);
            BNMapController.getInstance().showLayer(3, true);
            BNMapController.getInstance().updateLayer(3);
        }
    }

    public void focusPoi(GeoPoint geoPoint) {
        if (geoPoint != null && geoPoint.isValid()) {
            this.mId = 0;
            BNPoiSearcher.getInstance().clearPoiCache();
            BNPoiSearcher.getInstance().updatePoiCache(geoPoint);
            BNMapController.getInstance().showLayer(3, true);
            BNMapController.getInstance().updateLayer(3);
            ItemizedOverlayUtil.getInstance().removeAllItems();
            Bundle mBundle = CoordinateTransformUtil.LL2MC(((double) geoPoint.getLongitudeE6()) / 100000.0d, ((double) geoPoint.getLatitudeE6()) / 100000.0d);
            GeoPoint pointMc = null;
            if (mBundle != null) {
                pointMc = new GeoPoint(mBundle.getInt("MCx"), mBundle.getInt("MCy"));
            }
            ItemizedOverlayUtil.getInstance().addMapItem(ItemizedOverlayUtil.getInstance().getOverlayItem(pointMc, StyleManager.getDrawable(C0965R.drawable.bnav_pick_in_map_centerpoint)));
            ItemizedOverlayUtil.getInstance().show();
            ItemizedOverlayUtil.getInstance().refresh();
            ItemizedOverlayUtil.getInstance().setOnTapListener(null);
        }
    }

    public void focusItem(boolean focusFlag) {
        BNMapController.getInstance().focusItem(3, this.mId, focusFlag);
    }

    public void clearPoiCache() {
        ItemizedOverlayUtil.getInstance().removeAllItems();
        ItemizedOverlayUtil.getInstance().hide();
        ItemizedOverlayUtil.getInstance().refresh();
    }

    public void setMapffset(long xOffset, long yOffset) {
        MapStatus curMapStatus = MapViewFactory.getInstance().getMapView().getMapStatus();
        if (curMapStatus != null) {
            curMapStatus.xOffset = (float) xOffset;
            curMapStatus.yOffset = (float) yOffset;
            MapViewFactory.getInstance().getMapView().animateTo(curMapStatus, 0);
        }
    }

    public void animationByFrogleap(GeoPoint geopoint) {
        if (geopoint != null && geopoint.isValid()) {
            MapStatus curMapStatus = MapViewFactory.getInstance().getMapView().getMapStatus();
            Bundle b = CoordinateTransformUtil.LLE62MC(geopoint.getLongitudeE6(), geopoint.getLatitudeE6());
            curMapStatus.centerPtX = (double) b.getInt("MCx");
            curMapStatus.centerPtY = (double) b.getInt("MCy");
            MapViewFactory.getInstance().getMapView().animateTo(curMapStatus, 0);
        }
    }

    public void animationByFrogleap(SearchPoi searchPoi) {
        if (searchPoi != null) {
            animationByFrogleap(searchPoi.mViewPoint);
        }
    }

    public void setDistrictId(int districtid) {
        this.mDistrictId = districtid;
    }

    public int getDistrictId() {
        return this.mDistrictId;
    }

    public void animationTo(GeoPoint geopoint) {
        if (geopoint != null && geopoint.isValid()) {
            MapStatus curMapStatus = MapViewFactory.getInstance().getMapView().getMapStatus();
            Bundle b = CoordinateTransformUtil.LLE62MC(geopoint.getLongitudeE6(), geopoint.getLatitudeE6());
            if (curMapStatus != null && b != null) {
                curMapStatus.centerPtX = (double) b.getInt("MCx");
                curMapStatus.centerPtY = (double) b.getInt("MCy");
                MapViewFactory.getInstance().getMapView().animateTo(curMapStatus, 0);
            }
        }
    }

    public void animationTo(GeoPoint geopoint, long xOffset, long yOffset, int level) {
        animationTo(geopoint, xOffset, yOffset, level, true);
    }

    public void animationTo(GeoPoint geopoint, long xOffset, long yOffset, int level, boolean anim) {
        if (geopoint != null && geopoint.isValid()) {
            MapStatus curMapStatus = MapViewFactory.getInstance().getMapView().getMapStatus();
            if (curMapStatus != null) {
                Bundle b = CoordinateTransformUtil.LLE62MC(geopoint.getLongitudeE6(), geopoint.getLatitudeE6());
                curMapStatus.centerPtX = (double) b.getInt("MCx");
                curMapStatus.centerPtY = (double) b.getInt("MCy");
                curMapStatus.xOffset = (float) xOffset;
                curMapStatus.yOffset = (float) yOffset;
                if (level > 0) {
                    curMapStatus.level = (float) level;
                }
                MapViewFactory.getInstance().getMapView().animateTo(curMapStatus, 0);
            }
        }
    }

    public void animationTo(GeoPoint geopoint, long xOffset, long yOffset) {
        animationTo(geopoint, xOffset, yOffset, -1);
    }

    public void animationTo(SearchPoi searchPoi, long xOffset, long yOffset) {
        if (searchPoi != null) {
            animationTo(searchPoi.mViewPoint, xOffset, yOffset, -1);
        }
    }

    public void animationTo(SearchPoi searchPoi, long xOffset, long yOffset, int level) {
        if (searchPoi != null) {
            animationTo(searchPoi.mViewPoint, xOffset, yOffset, level);
        }
    }

    public void animationTo(SearchPoi searchPoi) {
        if (searchPoi != null) {
            animationTo(searchPoi.mViewPoint);
        }
    }

    public void searchSpace(SearchPoi poi) {
        if (poi != null) {
            Bundle bundle = new Bundle();
            bundle.putInt("incoming_type", 1);
            ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).setSpaceSearchPoi(poi);
            C1328h.a().showFragment(38, bundle);
        }
    }

    public void callPhone(SearchPoi poi) {
        if (poi != null) {
            C1868q.f().a(this.mContext, poi.mPhone);
        }
    }

    public void setEnd(SearchPoi node) {
        if (node != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(RoutePlanFragment.KEY_FROM_POI_DETAIL, true);
            bundle.putInt(RoutePlanFragment.KEY_SET_POI_TYPE, 2);
            ((RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN)).setPointPoiDetail(createRoutePlanNode(node));
            C1328h.a().showFragment(50, bundle);
        }
    }

    public void setStart(SearchPoi node) {
        if (node != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(RoutePlanFragment.KEY_FROM_POI_DETAIL, true);
            bundle.putInt(RoutePlanFragment.KEY_SET_POI_TYPE, 0);
            ((RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN)).setPointPoiDetail(createRoutePlanNode(node));
            C1328h.a().showFragment(50, bundle);
        }
    }

    public void setVia(SearchPoi node) {
        if (node != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(RoutePlanFragment.KEY_FROM_POI_DETAIL, true);
            bundle.putInt(RoutePlanFragment.KEY_SET_POI_TYPE, 1);
            ((RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN)).setPointPoiDetail(createRoutePlanNode(node));
            C1328h.a().showFragment(50, bundle);
        }
    }

    public void viewStreet(SearchPoi poi, Context context, C1277e listener) {
    }

    public void startRef(SearchPoi poi) {
        if (poi != null) {
            if (NetworkUtils.getConnectStatus()) {
                RoutePlanNode startNode = BNLocationManagerProxy.getInstance().getCurLocationNode();
                if (startNode == null || !BNLocationManagerProxy.getInstance().isLocationValid()) {
                    TipTool.onCreateToastDialog(this.mContext, (int) C0965R.string.wait_for_loacte);
                    return;
                }
                RoutePlanNode endNode = createRoutePlanNode(poi);
                ArrayList<RoutePlanNode> nodeList = new ArrayList(2);
                nodeList.add(startNode);
                nodeList.add(endNode);
                return;
            }
            TipTool.onCreateToastDialog(this.mContext, (int) C0965R.string.its_switch_to_history);
        }
    }

    private RoutePlanNode createRoutePlanNode(SearchPoi node) {
        return new RoutePlanNode(node.mGuidePoint, node.mViewPoint, 8, node.mName, node.mAddress, node.mOriginUID);
    }

    public void startCalcRoute(SearchPoi poi, C1277e listener) {
        NavPoiController.getInstance().startCalcRoute(poi);
    }

    public boolean antiGeo(SearchPoi poi, int netMode, Handler handler) {
        if (poi == null) {
            return false;
        }
        return BNPoiSearcher.getInstance().asynGetPoiByPoint(poi.mViewPoint, netMode, 10000, handler);
    }

    public void sharePoi(Context context, SearchPoi poi, String shortUrl, Activity activity, ShareEventCallBack shareEventCallBack) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", "分享");
        intent.putExtra("android.intent.extra.TEXT", poi.mName);
        intent.setFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
        context.startActivity(Intent.createChooser(intent, "分享方式"));
    }

    public void sharePoi(SearchPoi poi, String shortUrl, Activity activity, ShareEventCallBack shareEventCallBack) {
        if (poi != null && !TextUtils.isEmpty(poi.mName) && activity != null && !activity.isFinishing()) {
            if (shareEventCallBack != null) {
                shareEventCallBack.onStart();
            }
            String shareContent = poi.mName + "\r\n";
            if (this.mShareTool == null) {
                this.mShareTool = new ShareTools(activity, 2);
            }
            this.mShareTool.share(getOpenSharePoiBundle(poi, shortUrl));
        }
    }

    public void handleSinaCallback(Context context, int requestCode, int resultCode, Intent data) {
        if (this.mShareTool == null) {
            this.mShareTool = new ShareTools(context, 2);
        }
        this.mShareTool.onSinaAuthorizeCallback(requestCode, resultCode, data);
    }

    public void sharePoiGetShortUrl(SearchPoi poi, Handler handler) {
    }

    public void sharePoiParseShortUrl(String shortUri, Handler handler) {
    }

    public int getAntiPoiNetMode(GeoPoint geopoint) {
        int finalNetMode = -1;
        if (geopoint == null || !geopoint.isValid()) {
            return -1;
        }
        boolean hasDownloadData = false;
        if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
            DistrictInfo childDistrictInfo = BNPoiSearcher.getInstance().getDistrictByPoint(geopoint, 0);
            if (childDistrictInfo != null) {
                DistrictInfo parentDistrict = BNPoiSearcher.getInstance().getParentDistrict(childDistrictInfo.mId);
                if (parentDistrict != null) {
                    hasDownloadData = BNOfflineDataManager.getInstance().isProvinceDataDownload(parentDistrict.mId);
                }
            }
        }
        if (hasDownloadData) {
            finalNetMode = 0;
        } else if (NetworkUtils.getConnectStatus()) {
            finalNetMode = 1;
        }
        return finalNetMode;
    }

    private Bundle getOpenSharePoiBundle(SearchPoi poiDetail, String shortUrl) {
        String shareUrl = shortUrl;
        if (shareUrl == null) {
            return null;
        }
        StringBuffer sb = new StringBuffer(128);
        Bundle shareBundle = new Bundle();
        String subject = "百度导航";
        String filepath = "";
        sb.append("这里是：");
        if (poiDetail != null) {
            sb.append(poiDetail.mName);
            int i = poiDetail.mType;
            shareBundle.putString(SearchParamKey.POI_NAME, poiDetail.mName);
            shareBundle.putString("uid", poiDetail.mOriginUID);
        }
        String address = poiDetail.mAddress;
        if (!TextUtils.isEmpty(address)) {
            if (!sb.toString().equals("这里是：")) {
                sb.append("，");
            }
            sb.append(address);
        }
        sb.append("，详情：");
        sb.append(shareUrl);
        sb.append(" -[百度导航]");
        shareBundle.putString(SearchParamKey.POI_ADDR, address);
        shareBundle.putString(ShareTools.BUNDLE_KEY_SUBJECT, subject);
        shareBundle.putString("content", sb.toString());
        shareBundle.putString(ShareTools.BUNDLE_KEY_FILEPATH, filepath);
        shareBundle.putString(ShareTools.BUNDLE_KEY_IMG_URL, ShareTools.DEFAULT_POI_WEIXIN_IMG);
        shareBundle.putString(ShareTools.BUNDLE_KEY_SHARE_URL, shareUrl);
        shareBundle.putString(SearchParamKey.TEL, poiDetail.mPhone);
        shareBundle.putInt(SearchParamKey.POI_GEO_X, poiDetail.mViewPoint.getLatitudeE6());
        shareBundle.putInt(SearchParamKey.POI_GEO_Y, poiDetail.mViewPoint.getLongitudeE6());
        return shareBundle;
    }
}
