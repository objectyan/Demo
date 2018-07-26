package com.baidu.navi.fragment.carmode;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.baidumaps.p042f.p043a.p044a.C0705a;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.p078f.C1436a;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.mapframework.common.mapview.MapViewConfig.PositionStatus;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.fragment.MapContentFragment;
import com.baidu.navi.fragment.NameSearchFragment;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.view.CarmodePoiDetailView;
import com.baidu.navi.view.CarmodePoiListView;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams.BundleKey;
import com.baidu.navisdk.comapi.userdata.BNFavoriteManager;
import com.baidu.navisdk.comapi.userdata.FavoriteParams.Key;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import com.baidu.navisdk.model.datastruct.FavoritePoiInfo;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.FavoriteModel;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.map.MapController;
import java.util.ArrayList;
import java.util.List;

public class CarModePoiDetailFragment extends MapContentFragment {
    public static final int INCOMING_BROWSE_FAVORITE = 86;
    public static final int INCOMING_BROWSE_MAP_ANTIGEO = 81;
    public static final int INCOMING_BROWSE_MAP_POIPICK = 82;
    public static final int INCOMING_FAVORITE = 85;
    public static final int INCOMING_INTENT_API = 87;
    public static final int INCOMING_SEARCH_RESULT = 83;
    public static final int INCOMING_STREETSCAPE = 84;
    public static final String INCOMING_TYPE = "incoming_type";
    public static final String ISFAVPOI = "ISFAVPOI";
    public static final String ISMYPOSITION = "ISMYPOSITION";
    public static final String KEY_CHILD_COUNT_ARRAY = "child_count_array";
    public static final String KEY_CHILD_START_ARRAY = "child_start_array";
    public static final String KEY_CHILD_START_POI = "child_start_poi";
    public static final String KEY_CURRENT_CHILD_COUNT = "current_child_count";
    public static final String KEY_CURRENT_PARENT_POSITION = "current_parent_position";
    public static final String KEY_CURRENT_POI = "current_poi";
    public static final String KEY_FC_TYPE = "fc_type";
    public static final String KEY_LATITUDE_E6 = "lat";
    public static final String KEY_LONGITUDE_E6 = "lon";
    public static final String KEY_PARENT_POSITION_ARRAY = "parent_position_array";
    public static final String KEY_SHORT_URI = "short_uri";
    public static final String SEACHR_POI_DETAIL_NEWER_GUIDE_KEY = "search_poi_detail_newer_key";
    public static final String SEARCH_RESULT_MODE = "search_result_mode";
    private static final String TAG = "PoiSearch";
    private ArrayList<SearchPoi> ParChildPoi;
    private int id = 0;
    private BNMapObserver mBNMapObserver = new C39103();
    private View mBack;
    private int[] mChildCnt = new int[200];
    private int[] mChildIndex = new int[200];
    private int mFCType = -1;
    private ImageView mIvBack;
    private View mLocation;
    private C1443g mMiddleFocusArea;
    private CarmodePoiDetailView mPoiDetailView;
    private ArrayList<SearchPoi> mPoiList;
    private CarmodePoiListView mPoiListView;
    private C1443g mRightFocusArea;
    private int mSearchRsultNetMode = 0;
    private ViewGroup mViewGroup;
    private ImageView mZoomInBtnView;
    private ImageView mZoomOutBtnView;
    private long xOffset = ((long) (ScreenUtil.getInstance().dip2px(-250) / 2));
    private long yOffset = ((long) (ScreenUtil.getInstance().dip2px(0) / 2));

    /* renamed from: com.baidu.navi.fragment.carmode.CarModePoiDetailFragment$1 */
    class C39081 implements OnTouchListener {
        C39081() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModePoiDetailFragment$2 */
    class C39092 implements OnClickListener {
        C39092() {
        }

        public void onClick(View v) {
            CarModePoiDetailFragment.this.onBackPressed();
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModePoiDetailFragment$3 */
    class C39103 implements BNMapObserver {
        C39103() {
        }

        public void update(BNSubject o, int type, int event, Object arg) {
            if (2 == type) {
                switch (event) {
                    case 517:
                        C1260i.e("POI", "BNMapObserver.EventGesture.EVENT_LONGPRESS");
                        CarModePoiDetailFragment.this.handleLongPress((MotionEvent) arg);
                        return;
                    default:
                        return;
                }
            } else if (1 == type) {
                switch (event) {
                    case 257:
                        C1260i.e("POI", "BNMapObserver.EventGesture.EVENT_CLICKED_POI_FINISHED");
                        PoiController.getInstance().focusItem(true);
                        return;
                    case 264:
                        C1260i.e("POI", "BNMapObserver.EventGesture.EVENT_CLICKED_BASE_POI_LAYER");
                        CarModePoiDetailFragment.this.handleClickBasePoiLayer((MapItem) arg);
                        return;
                    case 265:
                        CarModePoiDetailFragment.this.handleClickPoiBkgLayer((MapItem) arg);
                        return;
                    case 276:
                        CarModePoiDetailFragment.this.handleClickFavPoiLayer((MapItem) arg);
                        return;
                    case 277:
                        C1260i.e("POI", "BNMapObserver.EventGesture.EVENT_CLICKED_POI_LAYER");
                        CarModePoiDetailFragment.this.handleClickPoiLayer((MapItem) arg);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        boolean z = false;
        if (NavMapManager.getInstance().getNaviMapMode() != 5) {
            C0705a.a().d();
            C0705a.a().a(false, null);
            NavMapManager.getInstance().set3DGestureEnable(false);
            BNMapController instance = BNMapController.getInstance();
            if (!BNStyleManager.getRealDayStyle()) {
                z = true;
            }
            instance.setNightMode(z);
        }
        loadMapCtrlPanel(true);
        this.mViewGroup = (ViewGroup) inflater.inflate(C0965R.layout.car_mode_frag_poi_detail, null);
        this.mViewGroup.findViewById(C0965R.id.poilayout).setOnTouchListener(new C39081());
        this.mBack = this.mViewGroup.findViewById(C0965R.id.layout_back);
        this.mIvBack = (ImageView) this.mViewGroup.findViewById(C0965R.id.left_imageview);
        this.mPoiListView = (CarmodePoiListView) this.mViewGroup.findViewById(C0965R.id.poilistview);
        this.mPoiDetailView = (CarmodePoiDetailView) this.mViewGroup.findViewById(C0965R.id.poidetailview);
        this.mPoiDetailView.setOnDialogListener(this);
        this.mPoiListView.setOnDialogListener(this);
        return this.mViewGroup;
    }

    protected void onInitView() {
        C1260i.e("PoiSearch", "@移动统计 @搜周边-POI详情页-进入次数");
        C1260i.e("PoiSearch", "getBundle()");
        this.mPoiListView.setController(PoiController.getInstance());
        this.mPoiDetailView.setController(PoiController.getInstance());
        getBundle();
        this.mBack.setOnClickListener(getBackBtnOnclickListner());
    }

    protected void onInitMap() {
        setMapLayerMode(1);
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
        super.onUpdateStyle(dayStyle);
        if (this.mIvBack != null) {
            this.mIvBack.setBackground(StyleManager.getDrawable(C0965R.drawable.map_bg_btn_selector));
        }
    }

    public void onResume() {
        super.onResume();
        initMapLayer();
        setMapFocusViewVisible(false);
        hideMapCtrlPanel();
        if (this.mMapControlPanel != null) {
            this.mMapControlPanel.hideLayerView();
        }
        BNMapController.getInstance().addObserver(this.mBNMapObserver);
        ArrayList<SearchPoi> poiList = (ArrayList) ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getPoiList();
        ArrayList<SearchPoi> searchPois = null;
        if (poiList != null) {
            searchPois = new ArrayList();
            int i = 0;
            while (i < poiList.size() && i < 10) {
                searchPois.add(poiList.get(i));
                i++;
            }
        }
        PoiController.getInstance().updatePoiBkgLayer(searchPois);
        PoiController.getInstance().focusPoi(getCurrentPoi());
        if (this.mShowBundle.getInt("incoming_type") != 85) {
            BNMapController.getInstance().showLayer(4, true);
            BNMapController.getInstance().updateLayer(4);
        }
        BNMapController.getInstance().showLayer(3, true);
        BNMapController.getInstance().showLayer(6, true);
        BNMapController.getInstance().showLayer(7, true);
        BNMapController.getInstance().updateLayer(3);
        int xOffset = ScreenUtil.getInstance().dip2px(-250) / 2;
        PoiController.getInstance().animationTo(getCurrentPoi(), (long) xOffset, (long) (ScreenUtil.getInstance().dip2px(0) / 2), 15);
    }

    private void initMapLayer() {
        BNMapController.getInstance().setMapDrawScreenRect(new Rect(0, ScreenUtil.getInstance().getStatusBarHeight(), ScreenUtil.getInstance().getHeightPixels(), ScreenUtil.getInstance().getWidthPixels()));
        NavMapManager.getInstance().showCarResultLayer(false);
    }

    private SearchPoi getCurrentPoi() {
        if (this.mPoiDetailView.getVisibility() == 0) {
            return this.mPoiDetailView.getSearchPoi();
        }
        return this.mPoiListView.getCurrentSearchPoi();
    }

    public void onPause() {
        BNMapController.getInstance().deleteObserver(this.mBNMapObserver);
        PoiController.getInstance().focusItem(false);
        BNPoiSearcher.getInstance().clearBkgCache();
        BNPoiSearcher.getInstance().clearPoiCache();
        BNMapController.getInstance().showLayer(4, false);
        BNMapController.getInstance().updateLayer(4);
        BNMapController.getInstance().updateLayer(3);
        PoiController.getInstance().clearPoiCache();
        super.onPause();
    }

    public boolean onBackPressed() {
        if (this.mPoiList == null || this.mPoiList.size() <= 1 || this.mPoiListView.getVisibility() == 0) {
            Bundle bundle = null;
            if (this.mPoiDetailView != null) {
                bundle = new Bundle();
                bundle.putInt(BundleKey.FROM_FRAGMENT, 33);
                bundle.putInt(Key.FAVORITE_ACTION_KEY, 2);
            }
            back(bundle);
        } else {
            showPoiListlView();
            this.mPoiListView.setCurrentIndex(this.mPoiListView.getCurretnIndex(), this.mPoiListView.getCurrentPoiList(), this.mPoiListView.getCurretnId());
        }
        return true;
    }

    private void getBundle() {
        switch (this.mShowBundle.getInt("incoming_type")) {
            case 81:
                handleComeFromBrowsermapAntigeo();
                return;
            case 82:
                handleComeFromBrowsermapPickpoint();
                return;
            case 83:
                handleComeFromSearchResult();
                return;
            case 84:
                C1260i.e("PoiSearch", "from streetscape");
                onBackPressed();
                return;
            case 85:
                C1260i.e("PoiSearch", "from favorite");
                handleComeFromFavorite();
                return;
            case 86:
                handleBrowseFavPoi();
                return;
            case 87:
                handleComeFromIntentApi();
                return;
            default:
                onBackPressed();
                return;
        }
    }

    private void handleComeFromIntentApi() {
        if (this.mShowBundle.containsKey("lat") && this.mShowBundle.containsKey("lon")) {
            int latitudeE6 = this.mShowBundle.getInt("lat");
            int longitudeE6 = this.mShowBundle.getInt("lon");
            GeoPoint geoPt = new GeoPoint();
            geoPt.setLatitudeE6(latitudeE6);
            geoPt.setLongitudeE6(longitudeE6);
            this.mPoiDetailView.setMyPositionMode(false);
            this.mPoiDetailView.antiPoi(geoPt, 0, (long) (this.mPoiDetailView.getHeight() / 2));
            this.mPoiDetailView.setVisibility(0);
            this.mPoiListView.setVisibility(8);
        } else if (this.mShowBundle.containsKey("short_uri")) {
            String shortUri = this.mShowBundle.getString("short_uri");
            this.mPoiListView.setVisibility(8);
            this.mPoiDetailView.handleShortUri(shortUri);
        }
    }

    private void handleComeFromFavorite() {
        boolean isMyPosition = this.mShowBundle.getBoolean(ISMYPOSITION);
        SearchPoi poi = FavoriteModel.getInstance().getFavoriteSearchPoi();
        if (poi == null) {
            onBackPressed();
            return;
        }
        PoiController.getInstance().setSearchNetMode(0);
        this.mPoiDetailView.setSearchPoi(poi);
        this.mPoiDetailView.setMyPositionMode(isMyPosition);
        this.mPoiDetailView.setVisibility(0);
        this.mPoiListView.setVisibility(8);
        this.mBack.setVisibility(0);
        PoiController.getInstance().focusPoi(poi);
    }

    private void handleBrowseFavPoi() {
        List<SearchPoi> poiList = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getPoiList();
        if (poiList == null || poiList.size() != 1 || poiList.get(0) == null) {
            back(null);
            return;
        }
        this.mPoiDetailView.setMyPositionMode(false);
        PoiController.getInstance().focusPoi((SearchPoi) poiList.get(0));
        PoiController.getInstance().animationTo((SearchPoi) poiList.get(0), this.xOffset, this.yOffset);
        this.mPoiDetailView.setFavSearchPoi((SearchPoi) poiList.get(0));
        this.mPoiDetailView.setVisibility(0);
        this.mPoiListView.setVisibility(8);
        this.mPoiDetailView.setFromBrowseMapFragment(true, getNaviFragmentManager());
    }

    private void handleComeFromBrowsermapAntigeo() {
        boolean isMyPosition = this.mShowBundle.getBoolean(ISMYPOSITION);
        C1260i.e("PoiSearch", "from handleComeFromBrowsermap");
        List<SearchPoi> poiList = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getPoiList();
        if (poiList == null || poiList.size() != 1 || poiList.get(0) == null) {
            back(null);
            return;
        }
        this.mPoiDetailView.setMyPositionMode(isMyPosition);
        this.mPoiDetailView.antiPoi(((SearchPoi) poiList.get(0)).mViewPoint, this.xOffset, this.yOffset);
        this.mPoiDetailView.setVisibility(0);
        this.mPoiListView.setVisibility(8);
        PoiController.getInstance().focusPoi((SearchPoi) poiList.get(0));
        this.mPoiDetailView.setFromBrowseMapFragment(true, getNaviFragmentManager());
    }

    private void handleComeFromBrowsermapPickpoint() {
        boolean isMyPosition = this.mShowBundle.getBoolean(ISMYPOSITION);
        C1260i.e("PoiSearch", "from handleComeFromBrowsermap");
        List<SearchPoi> poiList = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getPoiList();
        if (poiList == null || poiList.size() != 1 || poiList.get(0) == null) {
            back(null);
            return;
        }
        this.mPoiDetailView.setMyPositionMode(isMyPosition);
        this.mPoiDetailView.pickPoi((SearchPoi) poiList.get(0), this.xOffset, this.yOffset);
        this.mPoiDetailView.setVisibility(0);
        this.mPoiListView.setVisibility(8);
        PoiController.getInstance().focusPoi((SearchPoi) poiList.get(0));
        this.mPoiDetailView.setFromBrowseMapFragment(true, getNaviFragmentManager());
    }

    private void handleComeFromSearchResult() {
        C1260i.e("PoiSearch", "from search  result");
        int mCurrentBkgIndex = this.mShowBundle.getInt("current_poi");
        List<SearchPoi> poiList = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getPoiList();
        int Parentsize = 0;
        this.mPoiListView.setComeFrom(this.mShowBundle.getInt(NameSearchFragment.COME_FROM, 0));
        this.mPoiDetailView.setComeFrom(this.mShowBundle.getInt(NameSearchFragment.COME_FROM, 0));
        this.mFCType = this.mShowBundle.getInt("fc_type", 0);
        int mChildNum = this.mShowBundle.getInt("current_child_count", 0);
        int mStartIndex = this.mShowBundle.getInt("child_start_poi", 0);
        int mParentIndex = this.mShowBundle.getInt("current_parent_position", 0);
        this.mChildCnt = this.mShowBundle.getIntArray("child_count_array");
        this.mChildIndex = this.mShowBundle.getIntArray("child_start_array");
        this.ParChildPoi = new ArrayList(mChildNum + 1);
        int i;
        if (this.mFCType == 1) {
            int Childsize = mChildNum;
            this.id = (mCurrentBkgIndex - mStartIndex) + 1;
            this.ParChildPoi.add(poiList.get(mParentIndex));
            this.mPoiList = new ArrayList(Childsize);
            for (i = 0; i < Childsize; i++) {
                this.mPoiList.add(poiList.get(i + mStartIndex));
                this.ParChildPoi.add(poiList.get(i + mStartIndex));
            }
            if (mCurrentBkgIndex - mStartIndex >= this.mPoiList.size() || mCurrentBkgIndex < 0) {
                back(null);
                return;
            }
        }
        if (this.mChildIndex != null && this.mChildIndex[0] > 0) {
            Parentsize = poiList.size() > this.mChildIndex[0] ? this.mChildIndex[0] : poiList.size();
        }
        this.mPoiList = new ArrayList(Parentsize);
        this.id = 0;
        for (i = 0; i < Parentsize; i++) {
            this.mPoiList.add(poiList.get(i));
        }
        this.ParChildPoi.add(poiList.get(mCurrentBkgIndex));
        if (!(this.mChildCnt == null || this.mChildIndex == null || this.mChildCnt[mCurrentBkgIndex] <= 0)) {
            for (int j = 0; j < this.mChildCnt[mCurrentBkgIndex]; j++) {
                this.ParChildPoi.add(poiList.get(this.mChildIndex[mCurrentBkgIndex] + j));
            }
        }
        if (mCurrentBkgIndex >= this.mPoiList.size() || mCurrentBkgIndex < 0) {
            back(null);
            return;
        }
        int mSearchRsultNetMode = this.mShowBundle.getInt("search_result_mode");
        PoiController.getInstance().setSearchNetMode(mSearchRsultNetMode);
        C1260i.e("PoiSearch", "searchRsultNetMode = " + mSearchRsultNetMode);
        if (this.mShowBundle.containsKey("district_id")) {
            PoiController.getInstance().setDistrictId(this.mShowBundle.getInt("district_id"));
        }
        if (this.mShowBundle.containsKey("search_key")) {
            PoiController.getInstance().setSearchKey(this.mShowBundle.getString("search_key"));
        }
        if (this.mFCType == 0) {
            if (this.mPoiList.size() == 1) {
                this.mPoiDetailView.setSearchPoi((SearchPoi) this.mPoiList.get(0));
                this.mPoiListView.setCurrentIndex(mCurrentBkgIndex, this.ParChildPoi, this.id);
                this.mPoiDetailView.setVisibility(0);
                this.mPoiListView.setVisibility(8);
                PoiController.getInstance().focusPoi(this.ParChildPoi, 0);
            } else {
                this.mPoiListView.setSearchPoiList(this.mPoiList);
                this.mPoiListView.setChildIndex(this.mChildIndex);
                this.mPoiListView.setChildCnt(this.mChildCnt);
                this.mPoiListView.setCurrentIndex(mCurrentBkgIndex, this.ParChildPoi, this.id);
                this.mPoiDetailView.setVisibility(4);
                this.mPoiListView.setVisibility(0);
            }
        } else if (this.mPoiList.size() == 1) {
            this.mPoiDetailView.setSearchPoi((SearchPoi) this.mPoiList.get(0));
            this.mPoiListView.setCurrentIndex(mCurrentBkgIndex - mStartIndex, this.ParChildPoi, this.id);
            this.mPoiDetailView.setVisibility(0);
            this.mPoiListView.setVisibility(8);
            PoiController.getInstance().focusPoi(this.ParChildPoi, this.id);
        } else {
            this.mPoiListView.setSearchPoiList(this.mPoiList);
            this.mPoiListView.setCurrentIndex(mCurrentBkgIndex - mStartIndex, this.ParChildPoi, this.id);
            this.mPoiDetailView.setVisibility(4);
            this.mPoiListView.setVisibility(0);
        }
        this.mBack.setVisibility(0);
    }

    public void onDestroy() {
        ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getPoiList().clear();
        super.onDestroy();
    }

    private OnClickListener getBackBtnOnclickListner() {
        return new C39092();
    }

    private void handleClickFavPoiLayer(MapItem item) {
        if (!MapController.mMultiTouch.mTwoTouch) {
            GeoPoint favGeoPoint = new GeoPoint(item.mLongitude, item.mLatitude);
            FavoritePoiInfo favData = BNFavoriteManager.getInstance().getFavPoiInfoByGeoPoint(favGeoPoint);
            SearchPoi poi = new SearchPoi();
            if (favData != null) {
                poi.mName = favData.mFavName;
                poi.mAddress = favData.mFavAddr;
                poi.mPhone = favData.mPhone;
                poi.mViewPoint = favGeoPoint;
                poi.mGuidePoint = favGeoPoint;
                this.mPoiDetailView.setMyPositionMode(false);
                PoiController.getInstance().focusPoi(favGeoPoint);
                PoiController.getInstance().animationTo(favGeoPoint, this.xOffset, this.yOffset);
                this.mPoiDetailView.setFavSearchPoi(poi);
                showPoidetailView();
            }
        }
    }

    private void handleClickBasePoiLayer(MapItem item) {
        if (item != null && !MapController.mMultiTouch.mTwoTouch) {
            GeoPoint point = new GeoPoint(item.mLongitude, item.mLatitude);
            SearchPoi poi = new SearchPoi();
            if (item.mTitle != null) {
                poi.mName = item.mTitle.replace("\\", "");
            }
            poi.mViewPoint = point;
            poi.mGuidePoint = point;
            poi.mOriginUID = item.mUid;
            this.mPoiDetailView.pickPoi(poi, this.xOffset, this.yOffset);
            this.mPoiDetailView.setMyPositionMode(false);
            showPoidetailView();
        }
    }

    private void handleClickPoiLayer(MapItem item) {
        if (item != null && !MapController.mMultiTouch.mTwoTouch) {
            int idSearcher;
            if (this.id != 0) {
                idSearcher = item.mItemID - 1;
                if (this.mPoiList.size() == 1) {
                    this.mPoiDetailView.setSearchPoi((SearchPoi) this.mPoiList.get(0));
                    PoiController.getInstance().animationByFrogleap((SearchPoi) this.mPoiList.get(0));
                    PoiController.getInstance().focusPoi(this.ParChildPoi, item.mItemID);
                    this.mPoiDetailView.setVisibility(0);
                    this.mPoiListView.setVisibility(8);
                    return;
                }
                this.mPoiDetailView.setMyPositionMode(false);
                this.mPoiListView.setCurrentIndex(idSearcher, this.ParChildPoi, item.mItemID);
                this.mPoiDetailView.setVisibility(4);
                this.mPoiListView.setVisibility(0);
                return;
            }
            idSearcher = item.mItemID;
            this.mPoiDetailView.setMyPositionMode(false);
            ArrayList<SearchPoi> CurrentPoiList = this.mPoiListView.getCurrentPoiList();
            if (CurrentPoiList != null && idSearcher < CurrentPoiList.size()) {
                SearchPoi focusPoi = (SearchPoi) CurrentPoiList.get(idSearcher);
                PoiController.getInstance().focusPoi(CurrentPoiList, idSearcher);
                PoiController.getInstance().animationByFrogleap(focusPoi);
                this.mPoiDetailView.setFavSearchPoi(focusPoi);
                showPoidetailView();
            }
        }
    }

    protected void handleClickPoiBkgLayer(MapItem arg) {
        if (arg != null) {
            this.mPoiDetailView.setMyPositionMode(false);
            int idSearcher = BNPoiSearcher.getInstance().parseBkgLayerId(arg.mUid);
            int mCurrentId = this.mPoiListView.getCurretnId();
            ArrayList<SearchPoi> poiList = (ArrayList) ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getPoiList();
            if (poiList != null && this.mChildIndex != null && this.mChildCnt != null && poiList.size() > idSearcher) {
                if (mCurrentId == 0) {
                    int mSearcherChild = this.mChildCnt[idSearcher];
                    ArrayList<SearchPoi> mSearchPoiList = new ArrayList(mSearcherChild + 1);
                    mSearchPoiList.add(poiList.get(idSearcher));
                    if (poiList.size() == 1) {
                        this.mPoiDetailView.setSearchPoi((SearchPoi) poiList.get(0));
                        showPoidetailView();
                        PoiController.getInstance().focusPoi((SearchPoi) poiList.get(0));
                        PoiController.getInstance().animationByFrogleap((SearchPoi) poiList.get(0));
                        PoiController.getInstance().focusItem(true);
                        return;
                    }
                    if (mSearcherChild > 0 && poiList.size() >= this.mChildIndex[idSearcher] + mSearcherChild) {
                        for (int i = 0; i < mSearcherChild; i++) {
                            mSearchPoiList.add(poiList.get(this.mChildIndex[idSearcher] + i));
                        }
                    }
                    if (mSearchPoiList.size() > 1) {
                        this.mPoiListView.setCurrentIndex(idSearcher, mSearchPoiList, 0);
                    } else {
                        this.mPoiListView.setCurrentIndex(idSearcher);
                    }
                    PoiController.getInstance().focusItem(true);
                    showPoiListlView();
                    return;
                }
                SearchPoi focusPoi = (SearchPoi) poiList.get(idSearcher);
                ArrayList<SearchPoi> CurrentPoiList = this.mPoiListView.getCurrentPoiList();
                CurrentPoiList.set(0, focusPoi);
                PoiController.getInstance().focusPoi(CurrentPoiList, 0);
                PoiController.getInstance().animationByFrogleap(focusPoi);
                this.mPoiDetailView.setFavSearchPoi(focusPoi);
                showPoidetailView();
            }
        }
    }

    private void handleLongPress(MotionEvent e) {
        GeoPoint geoPt = BNMapController.getInstance().getGeoPosByScreenPos((int) e.getX(), (int) e.getY());
        ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).setAntiGeoPoint(geoPt);
        showPoidetailView();
        this.mPoiDetailView.setMyPositionMode(false);
        this.mPoiDetailView.antiPoi(geoPt, this.xOffset, this.yOffset);
    }

    private void showPoidetailView() {
        this.mPoiListView.setVisibility(8);
        this.mPoiDetailView.setVisibility(0);
    }

    private void showPoiListlView() {
        this.mPoiListView.setVisibility(0);
        this.mPoiDetailView.setVisibility(8);
    }

    public boolean onVoiceCommand(int type, int subType, int arg1, Object arg2, boolean needResponse) {
        if (3 == type && 4 == subType) {
            PoiController.getInstance().startCalcRoute(getCurrentPoi(), this);
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 1);
        }
        return super.onVoiceCommand(type, subType, arg1, arg2, needResponse);
    }

    protected void onLocationBtnClicked(PositionStatus curLocMode) {
        super.onLocationBtnClicked(curLocMode);
        if (curLocMode == PositionStatus.NORMAL) {
            GeoPoint geoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
            C1260i.e("PoiSearch", "onLocationBtnClicked: " + geoPoint);
            if (geoPoint != null && !geoPoint.isValid()) {
            }
        }
    }

    protected void showTrafficMap(boolean show) {
        BNMapController.getInstance().switchITSMode(true);
        BNMapController.getInstance().showTrafficMap(true);
    }

    public void initFocusChain(View root) {
        if (this.mMiddleFocusArea == null && this.mMapControlPanel != null) {
            this.mZoomInBtnView = this.mMapControlPanel.getZoomInBtnView();
            this.mZoomOutBtnView = this.mMapControlPanel.getZoomOutBtnView();
            this.mLocation = this.mMapControlPanel.getLocationView();
            this.mMiddleFocusArea = new C1443g(this.mViewGroup.findViewById(C0965R.id.layout_map_control_panel), 4, true);
            this.mMiddleFocusArea.d(this.mBack).d(this.mZoomInBtnView);
            this.mMiddleFocusArea.d(this.mZoomOutBtnView).d(this.mLocation);
        }
        if (this.mPoiList != null && this.mPoiList.size() > 0) {
            if (this.mPoiList.size() == 1) {
                this.mRightFocusArea = new C1443g(this.mPoiDetailView, 5);
                this.mRightFocusArea.d(this.mPoiDetailView.findViewById(C0965R.id.carmode_map_poi_panel_right_place_layout));
                this.mRightFocusArea.d(this.mPoiDetailView.findViewById(C0965R.id.carmode_map_poi_panel_right_phone_layout));
                this.mRightFocusArea.d(this.mPoiDetailView.findViewById(C0965R.id.carmode_map_poi_panel_right_distance_layout));
                this.mRightFocusArea.c(null);
                this.mRightFocusArea.b(this.mPoiDetailView.findViewById(C0965R.id.carmode_map_poi_panel_right_distance_layout));
            } else {
                this.mRightFocusArea = new C1443g(this.mPoiListView, 5);
                this.mRightFocusArea.d(this.mPoiListView.findViewById(C0965R.id.carmode_map_poi_panel_right_place_layout));
                this.mRightFocusArea.d(this.mPoiListView.findViewById(C0965R.id.carmode_map_poi_panel_right_phone_layout));
                this.mRightFocusArea.d(this.mPoiListView.findViewById(C0965R.id.carmode_map_poi_panel_right_distance_layout));
                this.mRightFocusArea.d(this.mPoiListView.findViewById(C0965R.id.carmode_map_poi_panel_right_up));
                this.mRightFocusArea.d(this.mPoiListView.findViewById(C0965R.id.carmode_map_poi_panel_right_down));
                this.mRightFocusArea.c(null);
                this.mRightFocusArea.b(this.mPoiListView.findViewById(C0965R.id.carmode_map_poi_panel_right_distance_layout));
            }
        }
        C1440d.a().b(new C1436a[]{this.mMiddleFocusArea, this.mRightFocusArea});
        C1440d.a().h(this.mMiddleFocusArea);
    }

    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden) {
            initFocusChain(null);
        }
    }

    public void driving() {
        backTo(17, null);
        C1342a.a().d();
    }

    public void stopDriving() {
    }
}
