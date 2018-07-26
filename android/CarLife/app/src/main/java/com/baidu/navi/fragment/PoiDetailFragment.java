package com.baidu.navi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.baidu.carlife.C0965R;
import com.baidu.mapframework.common.mapview.MapViewConfig.PositionStatus;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.view.MapTitleBar;
import com.baidu.navi.view.PoiDetailView;
import com.baidu.navi.view.PoiListView;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.geolocate.BNGeoLocateManager;
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
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.map.MapController;
import java.util.ArrayList;

public class PoiDetailFragment extends MapContentFragment {
    public static final int INCOMING_BROWSE_MAP_ANTIGEO = 81;
    public static final int INCOMING_BROWSE_MAP_POIPICK = 82;
    public static final int INCOMING_FAVORITE = 85;
    public static final int INCOMING_INTENT_API = 87;
    public static final int INCOMING_SEARCH_RESULT = 83;
    public static final int INCOMING_STREETSCAPE = 84;
    public static final String INCOMING_TYPE = "incoming_type";
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
    private BNMapObserver mBNMapObserver = new C38213();
    private int[] mChildCnt = new int[200];
    private int[] mChildIndex = new int[200];
    private int mFCType = -1;
    private ViewGroup mGroupView;
    private PoiDetailView mPoiDetailView;
    private ArrayList<SearchPoi> mPoiList;
    private PoiListView mPoiListView;
    private int mSearchRsultNetMode = 0;
    private MapTitleBar mTitleBar;

    /* renamed from: com.baidu.navi.fragment.PoiDetailFragment$1 */
    class C38191 implements OnTouchListener {
        C38191() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }

    /* renamed from: com.baidu.navi.fragment.PoiDetailFragment$2 */
    class C38202 implements OnClickListener {
        C38202() {
        }

        public void onClick(View v) {
            StatisticManager.onEvent(StatisticConstants.POIDETAIL_RETURN, StatisticConstants.POIDETAIL_RETURN);
            PoiDetailFragment.this.onBackPressed();
        }
    }

    /* renamed from: com.baidu.navi.fragment.PoiDetailFragment$3 */
    class C38213 implements BNMapObserver {
        C38213() {
        }

        public void update(BNSubject o, int type, int event, Object arg) {
            if (2 == type) {
                switch (event) {
                    case 517:
                        LogUtil.m15791e("POI", "BNMapObserver.EventGesture.EVENT_LONGPRESS");
                        PoiDetailFragment.this.handleLongPress((MotionEvent) arg);
                        return;
                    default:
                        return;
                }
            } else if (1 == type) {
                switch (event) {
                    case 257:
                        LogUtil.m15791e("POI", "BNMapObserver.EventGesture.EVENT_CLICKED_POI_FINISHED");
                        PoiController.getInstance().focusItem(true);
                        return;
                    case 264:
                        LogUtil.m15791e("POI", "BNMapObserver.EventGesture.EVENT_CLICKED_BASE_POI_LAYER");
                        PoiDetailFragment.this.handleClickBasePoiLayer((MapItem) arg);
                        return;
                    case 265:
                        PoiDetailFragment.this.handleClickPoiBkgLayer((MapItem) arg);
                        return;
                    case 276:
                        PoiDetailFragment.this.handleClickFavPoiLayer((MapItem) arg);
                        return;
                    case 277:
                        LogUtil.m15791e("POI", "BNMapObserver.EventGesture.EVENT_CLICKED_POI_LAYER");
                        PoiDetailFragment.this.handleClickPoiLayer((MapItem) arg);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        loadMapCtrlPanel(true);
        this.mGroupView = (ViewGroup) inflater.inflate(C0965R.layout.frag_poi_detail, null);
        this.mTitleBar = (MapTitleBar) this.mGroupView.findViewById(C0965R.id.title_bar);
        this.mPoiListView = (PoiListView) this.mGroupView.findViewById(C0965R.id.poilistview);
        this.mGroupView.findViewById(C0965R.id.poilayout).setOnTouchListener(new C38191());
        this.mPoiDetailView = (PoiDetailView) this.mGroupView.findViewById(C0965R.id.poidetailview);
        return this.mGroupView;
    }

    protected void onInitView() {
        LogUtil.m15791e("PoiSearch", "@移动统计 @搜周边-POI详情页-进入次数");
        LogUtil.m15791e("PoiSearch", "getBundle()");
        this.mPoiListView.setController(PoiController.getInstance());
        this.mPoiListView.setOnDialogListener(this);
        this.mPoiDetailView.setController(PoiController.getInstance());
        this.mPoiDetailView.setSupportDragon(true);
        getBundle();
        this.mTitleBar.setLeftOnClickedListener(getBackBtnOnclickListner());
    }

    protected void onInitMap() {
        setMapLayerMode(1);
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
        super.onUpdateStyle(dayStyle);
        this.mTitleBar.onUpdateStyle(dayStyle);
        if (this.mPoiDetailView != null) {
            this.mPoiDetailView.updateStyle();
        }
        if (this.mPoiListView != null) {
            this.mPoiListView.updateStyle();
        }
    }

    public void onResume() {
        super.onResume();
        BNMapController.getInstance().addObserver(this.mBNMapObserver);
        ArrayList<SearchPoi> poiList = (ArrayList) ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getPoiList();
        ArrayList<SearchPoi> mUpdatePoiList = null;
        if (this.mChildIndex != null && this.mChildIndex[0] > 0 && poiList != null && poiList.size() > this.mChildIndex[0]) {
            mUpdatePoiList = new ArrayList(this.mChildIndex[0]);
            for (int i = 0; i < this.mChildIndex[0]; i++) {
                mUpdatePoiList.add(poiList.get(i));
            }
        }
        PoiController.getInstance().updatePoiBkgLayer(mUpdatePoiList);
        if (this.ParChildPoi != null && this.ParChildPoi.size() > 1 && this.id > 0) {
            PoiController.getInstance().focusPoi(this.ParChildPoi, this.mPoiListView.getCurretnIndex() + 1);
        }
        if (this.mShowBundle == null || this.mShowBundle.getInt("incoming_type") != 85) {
            BNMapController.getInstance().showLayer(4, true);
            BNMapController.getInstance().updateLayer(4);
        }
        BNMapController.getInstance().showLayer(6, true);
        BNMapController.getInstance().showLayer(7, true);
        BNMapController.getInstance().showLayer(3, true);
        BNMapController.getInstance().updateLayer(3);
        PoiController.getInstance().animationTo(getCurrentPoi(), 0, (long) ((getViewHeight() - ScreenUtil.getInstance().getStatusBarHeight()) / 2), 15);
    }

    private SearchPoi getCurrentPoi() {
        if (this.mPoiDetailView.getVisibility() == 0) {
            return this.mPoiDetailView.getSearchPoi();
        }
        return this.mPoiListView.getCurrentSearchPoi();
    }

    private boolean isDragonOut() {
        if (this.mPoiDetailView.getVisibility() == 0) {
            return this.mPoiDetailView.isOut();
        }
        return this.mPoiListView.isOut();
    }

    private int getViewHeight() {
        if (this.mPoiDetailView.getVisibility() == 0) {
            return this.mPoiDetailView.getViewHeight();
        }
        return this.mPoiListView.getViewHeight();
    }

    public void onPause() {
        BNMapController.getInstance().deleteObserver(this.mBNMapObserver);
        PoiController.getInstance().focusItem(false);
        BNPoiSearcher.getInstance().clearBkgCache();
        BNPoiSearcher.getInstance().clearPoiCache();
        BNMapController.getInstance().showLayer(4, false);
        BNMapController.getInstance().showLayer(3, false);
        BNMapController.getInstance().updateLayer(4);
        BNMapController.getInstance().updateLayer(3);
        super.onPause();
    }

    public boolean onBackPressed() {
        if (this.mPoiList == null || this.mPoiList.size() <= 1 || this.mPoiListView.getVisibility() == 0) {
            Bundle bundle = null;
            if (this.mPoiDetailView != null && this.mPoiDetailView.checkIsReGetAllFavPois()) {
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
                handleComeFromSearchResult();
                return;
            case 82:
                onBackPressed();
                return;
            case 83:
                handleComeFromSearchResult();
                return;
            case 84:
                LogUtil.m15791e("PoiSearch", "from streetscape");
                onBackPressed();
                return;
            case 85:
                LogUtil.m15791e("PoiSearch", "from favorite");
                handleComeFromFavorite();
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
            this.mPoiDetailView.antiPoi(geoPt, 0, this.mPoiDetailView.getHeight() / 2);
            this.mPoiDetailView.setVisibility(0);
            this.mPoiListView.setVisibility(8);
        } else if (this.mShowBundle.containsKey("short_uri")) {
            String shortUri = this.mShowBundle.getString("short_uri");
            this.mPoiListView.setVisibility(8);
            this.mPoiDetailView.handleShortUri(shortUri);
        }
    }

    private void handleComeFromFavorite() {
        SearchPoi poi = FavoriteModel.getInstance().getFavoriteSearchPoi();
        if (poi == null) {
            onBackPressed();
            return;
        }
        PoiController.getInstance().setSearchNetMode(0);
        this.mPoiDetailView.setSearchPoi(poi);
        this.mPoiDetailView.checkStreetId();
        this.mPoiDetailView.setVisibility(0);
        this.mPoiListView.setVisibility(8);
        PoiController.getInstance().focusPoi(poi);
    }

    private void handleComeFromSearchResult() {
        LogUtil.m15791e("PoiSearch", "from search  result");
        int mCurrentBkgIndex = this.mShowBundle.getInt("current_poi");
        ArrayList<SearchPoi> poiList = (ArrayList) ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getPoiList();
        int Parentsize = 0;
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
            if (mParentIndex < poiList.size()) {
                this.ParChildPoi.add(poiList.get(mParentIndex));
            }
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
        LogUtil.m15791e("PoiSearch", "searchRsultNetMode = " + mSearchRsultNetMode);
        if (this.mShowBundle.containsKey("district_id")) {
            PoiController.getInstance().setDistrictId(this.mShowBundle.getInt("district_id"));
        }
        if (this.mShowBundle.containsKey("search_key")) {
            PoiController.getInstance().setSearchKey(this.mShowBundle.getString("search_key"));
        }
        if (this.mFCType == 0) {
            if (this.mPoiList.size() == 1) {
                this.mPoiDetailView.setSearchPoi((SearchPoi) this.mPoiList.get(0));
                this.mPoiDetailView.setVisibility(0);
                this.mPoiListView.setCurrentIndex(mCurrentBkgIndex, this.ParChildPoi, this.id);
                this.mPoiListView.setVisibility(8);
                this.mPoiDetailView.checkStreetId();
                PoiController.getInstance().focusPoi(this.ParChildPoi, 0);
                return;
            }
            this.mPoiListView.setSearchPoiList(this.mPoiList);
            this.mPoiListView.setChildIndex(this.mChildIndex);
            this.mPoiListView.setChildCnt(this.mChildCnt);
            this.mPoiListView.setCurrentIndex(mCurrentBkgIndex, this.ParChildPoi, this.id);
            this.mPoiDetailView.setVisibility(4);
            this.mPoiListView.setVisibility(0);
        } else if (this.mPoiList.size() == 1) {
            this.mPoiDetailView.setSearchPoi((SearchPoi) this.mPoiList.get(0));
            this.mPoiDetailView.setVisibility(0);
            this.mPoiListView.setCurrentIndex(mCurrentBkgIndex - mStartIndex, this.ParChildPoi, this.id);
            this.mPoiListView.setVisibility(8);
            this.mPoiDetailView.checkStreetId();
            PoiController.getInstance().focusPoi(this.ParChildPoi, this.id);
        } else {
            this.mPoiListView.setSearchPoiList(this.mPoiList);
            this.mPoiListView.setCurrentIndex(mCurrentBkgIndex - mStartIndex, this.ParChildPoi, this.id);
            this.mPoiDetailView.setVisibility(4);
            this.mPoiListView.setVisibility(0);
        }
    }

    private OnClickListener getBackBtnOnclickListner() {
        return new C38202();
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
                PoiController.getInstance().animationTo(favGeoPoint, 0, (long) (this.mPoiDetailView.getHeight() / 2));
                this.mPoiDetailView.setFavSearchPoi(poi);
                showPoidetailView();
            }
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

    private void handleClickBasePoiLayer(MapItem item) {
        if (item != null && !MapController.mMultiTouch.mTwoTouch) {
            GeoPoint point = new GeoPoint(item.mLongitude, item.mLatitude);
            SearchPoi poi = new SearchPoi();
            if (item.mTitle != null) {
                poi.mName = item.mTitle.replace("\\", "");
            }
            this.mPoiDetailView.setMyPositionMode(false);
            poi.mViewPoint = point;
            poi.mGuidePoint = point;
            this.mPoiDetailView.pickPoi(poi, 0, this.mPoiDetailView.getHeight() / 2);
            showPoidetailView();
        }
    }

    protected void handleClickPoiBkgLayer(MapItem arg) {
        if (arg != null) {
            this.mPoiDetailView.setMyPositionMode(false);
            int idSearcher = BNPoiSearcher.getInstance().parseBkgLayerId(arg.mUid);
            int mCurrentId = this.mPoiListView.getCurretnId();
            ArrayList<SearchPoi> poiList = (ArrayList) ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getPoiList();
            if (poiList != null && poiList.size() > idSearcher) {
                if (mCurrentId == 0) {
                    int mSearcherChild = this.mChildCnt[idSearcher];
                    ArrayList<SearchPoi> mSearchPoiList = new ArrayList(mSearcherChild + 1);
                    mSearchPoiList.add(poiList.get(idSearcher));
                    if (poiList.size() == 1) {
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
        this.mPoiDetailView.antiPoi(geoPt, 0, this.mPoiDetailView.getHeight() / 2);
    }

    private void showPoidetailView() {
        this.mPoiListView.setVisibility(8);
        this.mPoiDetailView.updateLayoutParams();
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
            GeoPoint geoPoint = BNGeoLocateManager.getInstance().getLastValidLocation();
            LogUtil.m15791e("PoiSearch", "onLocationBtnClicked: " + geoPoint);
            if (geoPoint != null && geoPoint.isValid()) {
                this.mPoiDetailView.setMyPositionMode(true);
                this.mPoiDetailView.antiPoi(geoPoint, 0, this.mPoiDetailView.getHeight() / 2);
                this.mPoiDetailView.setVisibility(0);
                this.mPoiListView.setVisibility(8);
                this.mPoiDetailView.checkStreetId();
                PoiController.getInstance().clearPoiCache();
            }
        }
    }
}
