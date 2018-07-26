package com.baidu.navi.fragment;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1192c;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.presentation.p071a.C1307e;
import com.baidu.carlife.view.dialog.C2287n;
import com.baidu.navi.adapter.SearchResultAdapter;
import com.baidu.navi.adapter.SearchResultAdapter.OnClickOnlineSearch;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.logic.model.UIModel;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.view.MapTitleBar;
import com.baidu.navi.view.xpulltorefresh.XListView;
import com.baidu.navi.view.xpulltorefresh.XListView.IXListViewListener;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.geolocate.BNGeoLocateManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams.BundleKey;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandParams;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNNetworkingDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

public class SearchResultFragment extends MapContentFragment {
    public static final String DISTRICT_ID = "district_id";
    public static final int INCOMING_CATALOG_SEARCH = 33;
    public static final int INCOMING_QUICK_ROUTE_PLAN = 34;
    public static final String INCOMING_TYPE = "incoming_type";
    public static final int INCOMING_VOICE_COMMAND = 35;
    private static int MARGINTOP_NORMAL = ((ScreenUtil.getInstance().getHeightPixels() - ScreenUtil.getInstance().getStatusBarHeight()) - ScreenUtil.getInstance().dip2px(100));
    private static int Middle_TOP_NORMAL = ScreenUtil.getInstance().dip2px(250);
    private static final float OFFSET_RADIO = 1.8f;
    private static final int PULL_LOAD_MORE_DELTA = 50;
    private static final int SCROLL_DURATION = 400;
    public static final String SEACHRESULT_SHOW_NEWER_GUIDE_KEY = "searchresult_show_newer_key";
    public static final int SEARCH_CIRCLE_1000 = 1000;
    public static final int SEARCH_CIRCLE_2000 = 2000;
    public static final int SEARCH_CIRCLE_500 = 500;
    public static final int SEARCH_CIRCLE_5000 = 5000;
    public static final int SEARCH_CIRCLE_DEAFAULT = 5000;
    public static final String SEARCH_ID = "search_id";
    public static final String SEARCH_KEY = "search_key";
    public static final String SEARCH_NET_MODE = "search_mode";
    public static final String SEARCH_TYPE = "search_type";
    public static final int SEARCH_TYPE_NAME = 17;
    public static final int SEARCH_TYPE_SPACE_CATALOG = 19;
    public static final int SEARCH_TYPE_SPACE_KEY = 18;
    private static final String TAG = "PoiSearch";
    private static int TITLEBAR_HEIGHT;
    private static BNNetworkingDialog mNetworkingDialog;
    private static float mStartY;
    private boolean isCityResultMode = false;
    private boolean isFromCatalogSearch = false;
    private boolean isFromVoiceCommand = false;
    private boolean isListSort = false;
    private boolean isSetHomeComp = false;
    private boolean isSetPointMode = false;
    private boolean isVoiceCommandResponsed = false;
    private BNMapObserver mBNMapObserver = new C38455();
    private int[] mChildCnt = new int[200];
    private int[] mChildIndex = new int[200];
    private C2287n mCityListDialog;
    private ImageView mCloseSortingIv;
    private int mCurrentDistrictId;
    private LinearLayout mDrawingLayout;
    private C2287n mFilterRuleDialog;
    private ViewGroup mGroupView;
    private ImageView mHandleView;
    private Handler mHandler = new C38402();
    private IXListViewListener mIXListViewListener = new C38444();
    private int mLastOrientation = 0;
    private float mLastY = -1.0f;
    private RelativeLayout mNewerGuideLayout;
    private OnClickOnlineSearch mOnlineClickListener = new C38413();
    private ArrayList<SearchPoi> mPoiList;
    private List<SearchPoi> mPreSearchCityList;
    private SearchResultAdapter mResultAdapter;
    private XListView mResultListView;
    private C0672b mSearchDialogCancelListener = new C38391();
    private String mSearchKey;
    private SearchPoiPager mSearchPoiPager;
    private SearchResultViewPagerAdapter mSearchResultViewPagerAdapter;
    private RelativeLayout mSortByDistance;
    private ImageView mSortByDistanceIv;
    private TextView mSortByDistanceTv;
    private RelativeLayout mSortByKey;
    private ImageView mSortByKeyIv;
    private TextView mSortByKeyTv;
    private RelativeLayout mSortingRl;
    private MapTitleBar mTitleBar;
    private OnTouchListener mTouchListener = new C38466();
    private ViewPager mViewPager;
    private int netMode = 1;
    private int searchType = 0;
    private int voiceCommandSubType = -1;
    private int voiceCommandTopType = -1;

    /* renamed from: com.baidu.navi.fragment.SearchResultFragment$1 */
    class C38391 implements C0672b {
        C38391() {
        }

        public void onClick() {
            if (SearchResultFragment.this.mResultAdapter == null) {
                SearchResultFragment.this.onBackPressed();
            }
            SearchResultFragment.this.mPreSearchCityList = null;
            BNPoiSearcher.getInstance().cancelQuery();
        }
    }

    /* renamed from: com.baidu.navi.fragment.SearchResultFragment$2 */
    class C38402 extends Handler {
        C38402() {
        }

        public void handleMessage(Message msg) {
            if (!SearchResultFragment.this.isDetached() && !SearchResultFragment.this.isRemoving()) {
                RspData rsp = msg.obj;
                if (msg.what == 1005) {
                    C1307e.a().c();
                    SearchResultFragment.this.mResultListView.stopLoadMore();
                    SearchPoiPager searchPoiPager = rsp.mData;
                    if (searchPoiPager == null) {
                        LogUtil.m15791e("PoiSearch", "search with pager fail");
                        TipTool.onCreateToastDialog(SearchResultFragment.this.getContext(), (int) C0965R.string.search_result_toast_failed);
                        if (SearchResultFragment.this.mResultAdapter == null) {
                            SearchResultFragment.this.onBackPressed();
                        }
                    } else if (msg.arg1 == 0) {
                        List<SearchPoi> poiList = searchPoiPager.getPoiList();
                        if (poiList == null || poiList.size() == 0) {
                            LogUtil.m15791e("PoiSearch", "search with pager fail");
                            TipTool.onCreateToastDialog(SearchResultFragment.this.getContext(), (int) C0965R.string.search_result_toast_failed);
                            if (SearchResultFragment.this.mResultAdapter == null) {
                                SearchResultFragment.this.onBackPressed();
                            }
                        } else if (((SearchPoi) poiList.get(0)).mType == 1) {
                            SearchResultFragment.this.showCityList(poiList, searchPoiPager.getNetMode() == 1);
                        } else {
                            SearchResultFragment.this.mSearchPoiPager = searchPoiPager;
                            if (SearchResultFragment.this.mResultAdapter != null) {
                                SearchResultFragment.this.mResultAdapter.setSearchPager(SearchResultFragment.this.mSearchPoiPager);
                            } else {
                                SearchResultFragment.this.mResultAdapter = new SearchResultAdapter(BaseFragment.mActivity, SearchResultFragment.this.mSearchPoiPager, SearchResultFragment.this.getNaviFragmentManager(), SearchResultFragment.this.isSetPointMode, SearchResultFragment.this);
                                SearchResultFragment.this.mResultAdapter.setOnlineSearchListener(SearchResultFragment.this.mOnlineClickListener);
                                SearchResultFragment.this.mResultAdapter.setShowBundle(SearchResultFragment.this.mShowBundle);
                                SearchResultFragment.this.mResultListView.setAdapter(SearchResultFragment.this.mResultAdapter);
                                int parCnt = SearchResultFragment.this.mSearchPoiPager.getCountPerPager();
                                ArrayList<SearchPoi> mResultPoiList = new ArrayList(parCnt);
                                for (int i = 0; i < parCnt; i++) {
                                    mResultPoiList.add(SearchResultFragment.this.mSearchPoiPager.getPoiList().get(i));
                                }
                                SearchResultFragment.this.mSearchResultViewPagerAdapter = new SearchResultViewPagerAdapter(mResultPoiList);
                                SearchResultFragment.this.mViewPager.setAdapter(SearchResultFragment.this.mSearchResultViewPagerAdapter);
                                SearchResultFragment.this.mViewPager.setCurrentItem(0);
                            }
                            SearchResultFragment.this.updateListView();
                            SearchResultFragment.this.updateMapView(SearchResultFragment.Middle_TOP_NORMAL);
                            SearchResultFragment.this.mPreSearchCityList = null;
                        }
                    } else if (CommandResult.isNetworkErr(msg.arg1)) {
                        LogUtil.m15791e("PoiSearch", "search with pager fail");
                        TipTool.onCreateToastDialog(SearchResultFragment.this.getContext(), (int) C0965R.string.search_result_toast_failed);
                        SearchResultFragment.this.mPreSearchCityList = null;
                        if (SearchResultFragment.this.mResultAdapter == null) {
                            SearchResultFragment.this.onBackPressed();
                        }
                    } else {
                        LogUtil.m15791e("PoiSearch", "search with pager fail");
                        TipTool.onCreateToastDialog(SearchResultFragment.this.getContext(), (int) C0965R.string.search_result_toast_failed);
                        SearchResultFragment.this.mPreSearchCityList = null;
                        if (SearchResultFragment.this.mResultAdapter == null) {
                            SearchResultFragment.this.onBackPressed();
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.SearchResultFragment$3 */
    class C38413 implements OnClickOnlineSearch {
        C38413() {
        }

        public void onNormalOnlineSearch() {
            if (NetworkUtils.getConnectStatus()) {
                SearchPoiPager srcPager = SearchResultFragment.this.mSearchPoiPager;
                while (true) {
                    SearchPoiPager pager = srcPager.getPrevPager();
                    if (pager == null) {
                        pager = srcPager.copy();
                        pager.setNetMode(1);
                        C1307e.a().a("", SearchResultFragment.this.mSearchDialogCancelListener);
                        ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchPoiPagerList().clear();
                        BNPoiSearcher.getInstance().setNetMode(pager.getNetMode());
                        BNPoiSearcher.getInstance().asynSearchWithPager(pager, SearchResultFragment.this.mHandler);
                        return;
                    }
                    srcPager = pager;
                }
            } else {
                TipTool.onCreateToastDialog(SearchResultFragment.this.getContext(), (int) C0965R.string.network_not_use);
            }
        }

        public void onCountrywideOnlineSearch() {
            if (NetworkUtils.getConnectStatus()) {
                SearchPoiPager srcPager = SearchResultFragment.this.mSearchPoiPager;
                while (true) {
                    SearchPoiPager pager = srcPager.getPrevPager();
                    if (pager == null) {
                        pager = srcPager.copy();
                        pager.setNetMode(1);
                        pager.setDistrict(BNPoiSearcher.getInstance().getDistrictById(0));
                        C1307e.a().a("", SearchResultFragment.this.mSearchDialogCancelListener);
                        ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchPoiPagerList().clear();
                        BNPoiSearcher.getInstance().setNetMode(pager.getNetMode());
                        BNPoiSearcher.getInstance().asynSearchWithPager(pager, SearchResultFragment.this.mHandler);
                        return;
                    }
                    srcPager = pager;
                }
            } else {
                TipTool.onCreateToastDialog(SearchResultFragment.this.getContext(), (int) C0965R.string.network_not_use);
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.SearchResultFragment$4 */
    class C38444 implements IXListViewListener {

        /* renamed from: com.baidu.navi.fragment.SearchResultFragment$4$1 */
        class C38421 implements Runnable {
            C38421() {
            }

            public void run() {
                SearchResultFragment.this.mResultListView.stopRefresh();
                SearchPoiPager searchPoiPager = SearchResultFragment.this.mSearchPoiPager.getPrevPager();
                if (searchPoiPager != null) {
                    SearchResultFragment.this.mSearchPoiPager = searchPoiPager;
                    SearchResultFragment.this.mResultAdapter.setSearchPager(SearchResultFragment.this.mSearchPoiPager);
                    SearchResultFragment.this.updateListView();
                    SearchResultFragment.this.updateMapView(SearchResultFragment.Middle_TOP_NORMAL);
                    SearchResultFragment.this.mSearchResultViewPagerAdapter.setPoiList(searchPoiPager.getPoiList());
                    SearchResultFragment.this.mSearchResultViewPagerAdapter.notifyDataSetChanged();
                }
            }
        }

        /* renamed from: com.baidu.navi.fragment.SearchResultFragment$4$2 */
        class C38432 implements Runnable {
            C38432() {
            }

            public void run() {
                SearchResultFragment.this.mResultListView.stopLoadMore();
                SearchPoiPager searchPoiPager = SearchResultFragment.this.mSearchPoiPager.getNextPager();
                if (searchPoiPager != null) {
                    SearchResultFragment.this.mSearchPoiPager = searchPoiPager;
                    SearchResultFragment.this.mResultAdapter.setSearchPager(searchPoiPager);
                    SearchResultFragment.this.updateListView();
                    SearchResultFragment.this.updateMapView(SearchResultFragment.Middle_TOP_NORMAL);
                    SearchResultFragment.this.mSearchResultViewPagerAdapter.setPoiList(searchPoiPager.getPoiList());
                    SearchResultFragment.this.mSearchResultViewPagerAdapter.notifyDataSetChanged();
                }
            }
        }

        C38444() {
        }

        public void onRefresh() {
            SearchResultFragment.this.mHandler.postDelayed(new C38421(), 1000);
        }

        public void onLoadMore() {
            SearchPoiPager nextPager = SearchResultFragment.this.mSearchPoiPager.getNextPager();
            if (nextPager == null || nextPager.getPoiList() == null || nextPager.getPoiList().size() <= 0) {
                SearchPoiPager searchPoiPager = SearchResultFragment.this.mSearchPoiPager.createNextPager();
                if (searchPoiPager != null) {
                    BNPoiSearcher.getInstance().setNetMode(searchPoiPager.getNetMode());
                    BNPoiSearcher.getInstance().asynSearchWithPager(searchPoiPager, SearchResultFragment.this.mHandler);
                    return;
                }
                SearchResultFragment.this.mResultListView.stopLoadMore();
                return;
            }
            SearchResultFragment.this.mHandler.postDelayed(new C38432(), 1000);
        }
    }

    /* renamed from: com.baidu.navi.fragment.SearchResultFragment$5 */
    class C38455 implements BNMapObserver {
        C38455() {
        }

        public void update(BNSubject o, int type, int event, Object arg) {
            if (2 == type) {
                switch (event) {
                    case 517:
                        LogUtil.m15791e("POI", "BNMapObserver.EventGesture.EVENT_LONGPRESS");
                        MotionEvent motionEvent = (MotionEvent) arg;
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
                        return;
                    case 265:
                        StatisticManager.onEvent("410136", "410136");
                        SearchResultFragment.this.handleClickPoiBkgLayer((MapItem) arg);
                        return;
                    case 276:
                        return;
                    case 277:
                        LogUtil.m15791e("POI", "BNMapObserver.EventGesture.EVENT_CLICKED_POI_LAYER");
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.SearchResultFragment$6 */
    class C38466 implements OnTouchListener {
        C38466() {
        }

        public boolean onTouch(View v, MotionEvent ev) {
            if (SearchResultFragment.this.mLastY == -1.0f) {
                SearchResultFragment.this.mLastY = ev.getRawY();
            }
            switch (ev.getAction()) {
                case 0:
                    SearchResultFragment.this.mLastY = ev.getRawY();
                    SearchResultFragment.mStartY = ev.getRawY();
                    break;
                case 2:
                    float deltaY = ev.getRawY() - SearchResultFragment.this.mLastY;
                    SearchResultFragment.this.mLastY = ev.getRawY();
                    if (SearchResultFragment.this.getTopMargin() <= SearchResultFragment.this.mTitleBar.getHeight()) {
                        deltaY /= SearchResultFragment.OFFSET_RADIO;
                    }
                    SearchResultFragment.this.updateTopMargin(deltaY);
                    break;
                default:
                    LogUtil.m15791e("wywywy", "reset");
                    float startDel = ev.getRawY() - SearchResultFragment.mStartY;
                    int topMarginFinal = SearchResultFragment.this.getTopMargin();
                    if (Math.abs(startDel) >= 50.0f) {
                        if (topMarginFinal >= SearchResultFragment.MARGINTOP_NORMAL) {
                            SearchResultFragment.this.setListViewMargin(SearchResultFragment.MARGINTOP_NORMAL);
                            SearchResultFragment.this.mViewPager.setVisibility(0);
                            SearchResultFragment.this.mResultListView.setVisibility(8);
                            SearchResultFragment.this.updateMapView(SearchResultFragment.MARGINTOP_NORMAL);
                        } else if (topMarginFinal < SearchResultFragment.this.mTitleBar.getHeight()) {
                            if (SearchResultFragment.this.mViewPager.getVisibility() == 0) {
                                SearchResultFragment.this.mViewPager.setVisibility(8);
                                SearchResultFragment.this.mResultListView.setVisibility(0);
                            }
                            SearchResultFragment.this.setListViewMargin(SearchResultFragment.this.mTitleBar.getHeight());
                        } else {
                            if (SearchResultFragment.this.mViewPager.getVisibility() == 0) {
                                SearchResultFragment.this.mViewPager.setVisibility(8);
                                SearchResultFragment.this.mResultListView.setVisibility(0);
                                SearchResultFragment.this.updateMapView(SearchResultFragment.Middle_TOP_NORMAL);
                            }
                            SearchResultFragment.this.setListViewMargin(SearchResultFragment.Middle_TOP_NORMAL);
                        }
                        SearchResultFragment.this.mLastY = -1.0f;
                        break;
                    }
                    if (Math.abs(topMarginFinal - SearchResultFragment.Middle_TOP_NORMAL) < 3) {
                        SearchResultFragment.this.setListViewMargin(SearchResultFragment.Middle_TOP_NORMAL);
                    } else if (Math.abs(topMarginFinal - SearchResultFragment.this.mTitleBar.getHeight()) < 3) {
                        SearchResultFragment.this.setListViewMargin(SearchResultFragment.this.mTitleBar.getHeight());
                    }
                    SearchResultFragment.this.mLastY = -1.0f;
                    break;
            }
            return true;
        }
    }

    /* renamed from: com.baidu.navi.fragment.SearchResultFragment$7 */
    class C38477 implements OnTouchListener {
        C38477() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }

    /* renamed from: com.baidu.navi.fragment.SearchResultFragment$8 */
    class C38488 implements OnTouchListener {
        C38488() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }

    /* renamed from: com.baidu.navi.fragment.SearchResultFragment$9 */
    class C38499 implements OnClickListener {
        C38499() {
        }

        public void onClick(View v) {
            int id = v.getId();
            if (id == C0965R.id.left_imageview) {
                StatisticManager.onEvent("410132", "410132");
                if (SearchResultFragment.this.isFromCatalogSearch) {
                    SearchResultFragment.this.back(null);
                    return;
                }
                SearchResultFragment.this.back(null);
                SearchResultFragment.this.back(null);
            } else if (id == C0965R.id.right_imageview) {
                SearchResultFragment.this.mSortingRl.setVisibility(0);
            } else if (id == C0965R.id.iv_close_sorting) {
                SearchResultFragment.this.mSortingRl.setVisibility(8);
            } else if (id == C0965R.id.rl_sort_by_key) {
                StatisticManager.onEvent("410133", "410133");
                SearchResultFragment.this.mSearchPoiPager.setSortType(1);
                SearchResultFragment.this.mSortingRl.setVisibility(8);
                SearchResultFragment.this.sortListByRule();
                SearchResultFragment.this.mSortByKeyIv.setVisibility(0);
                SearchResultFragment.this.mSortByDistanceIv.setVisibility(8);
                SearchResultFragment.this.mSortByKeyTv.setTextColor(StyleManager.getColor(C0965R.color.search_sort_selected_text_color));
                SearchResultFragment.this.mSortByDistanceTv.setTextColor(StyleManager.getColor(C0965R.color.search_sort_unselected_text_color));
                PoiController.getInstance().updatePoiBkgLayer(SearchResultFragment.this.mSearchPoiPager.getPoiList());
            } else if (id == C0965R.id.rl_sort_by_distance) {
                StatisticManager.onEvent("410134", "410134");
                GeoPoint center = BNGeoLocateManager.getInstance().getLastValidLocation();
                if (center == null || !center.isValid()) {
                    TipTool.onCreateToastDialog(SearchResultFragment.this.getContext(), (int) C0965R.string.carmode_searchresult_sort_fail);
                    return;
                }
                SearchResultFragment.this.mSearchPoiPager.setSortType(2);
                SearchResultFragment.this.mSortingRl.setVisibility(8);
                SearchResultFragment.this.sortListByRule();
                SearchResultFragment.this.mSortByKeyIv.setVisibility(8);
                SearchResultFragment.this.mSortByDistanceIv.setVisibility(0);
                SearchResultFragment.this.mSortByKeyTv.setTextColor(StyleManager.getColor(C0965R.color.search_sort_unselected_text_color));
                SearchResultFragment.this.mSortByDistanceTv.setTextColor(StyleManager.getColor(C0965R.color.search_sort_selected_text_color));
                PoiController.getInstance().updatePoiBkgLayer(SearchResultFragment.this.mSearchPoiPager.getPoiList());
            }
        }
    }

    public class SearchResultViewPagerAdapter extends PagerAdapter {
        View convertView;
        List<SearchPoi> mPoiList;

        public SearchResultViewPagerAdapter(List<SearchPoi> mPoiList) {
            this.mPoiList = mPoiList;
        }

        public void setPoiList(List<SearchPoi> mPoiList) {
            this.mPoiList = mPoiList;
        }

        public void destroyItem(View arg0, int arg1, Object object) {
            ((ViewPager) arg0).removeView((View) object);
        }

        public void finishUpdate(View arg0) {
        }

        public int getCount() {
            return this.mPoiList.size();
        }

        public Object instantiateItem(View arg0, int position) {
            View convertView = LayoutInflater.from(SearchResultFragment.this.getContext()).inflate(C0965R.layout.search_result_list_item, null);
            ViewHodler viewHodler = new ViewHodler();
            viewHodler.mVerDiverderA = convertView.findViewById(C0965R.id.line_poi_vertical_a);
            viewHodler.mBtnStartNavi = convertView.findViewById(C0965R.id.btn_poi_gonavi);
            viewHodler.mBtnNameAddr = convertView.findViewById(C0965R.id.poi_name_addr_layout);
            viewHodler.mTvName = (TextView) convertView.findViewById(C0965R.id.tv_poi_title);
            viewHodler.mTvAddr = (TextView) convertView.findViewById(C0965R.id.tv_poi_addr);
            viewHodler.mTvStartNavi = (TextView) convertView.findViewById(C0965R.id.tv_poi_gonavi);
            viewHodler.mTvDistance = (TextView) convertView.findViewById(C0965R.id.tv_poi_distance);
            viewHodler.mTvNum = (TextView) convertView.findViewById(C0965R.id.tv_num);
            viewHodler.mDivider = convertView.findViewById(C0965R.id.ls_divider);
            viewHodler.mIcResult = (ImageView) convertView.findViewById(C0965R.id.ic_result);
            viewHodler.mLayoutChildBottom = (LinearLayout) convertView.findViewById(C0965R.id.layout_child_bottom);
            viewHodler.mPoiParent = (RelativeLayout) convertView.findViewById(C0965R.id.btn_poi_parent);
            convertView.setTag(viewHodler);
            convertView.setLayoutParams(new LayoutParams(-1, ScreenUtil.getInstance().dip2px(70)));
            viewHodler.mVerDiverderA.setBackgroundColor(StyleManager.getColor(C0965R.color.poi_line));
            viewHodler.mBtnStartNavi.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_bg_pressed_mask_selector));
            viewHodler.mBtnNameAddr.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_bg_pressed_mask_selector));
            viewHodler.mTvName.setTextColor(StyleManager.getColor(C0965R.color.poi_name));
            viewHodler.mTvAddr.setTextColor(StyleManager.getColor(C0965R.color.poi_addr));
            viewHodler.mTvStartNavi.setTextColor(StyleManager.getColor(C0965R.color.poi_gonavi));
            viewHodler.mTvDistance.setTextColor(StyleManager.getColor(C0965R.color.poi_distance));
            viewHodler.mDivider.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.divide_list));
            viewHodler.mLayoutChildBottom.setBackgroundColor(StyleManager.getColor(C0965R.color.bnav_common_child_bg));
            viewHodler.mPoiParent.setBackgroundColor(StyleManager.getColor(C0965R.color.bnav_common_bg));
            viewHodler.mDivider.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.divide_list));
            viewHodler.mLayoutChildBottom.setBackgroundColor(StyleManager.getColor(C0965R.color.bnav_common_child_bg));
            viewHodler.mTvNum.setTextColor(StyleManager.getColor(C0965R.color.poi_num));
            viewHodler.mTvNum.setText((position + 1) + "");
            SearchPoi searchPoi = (SearchPoi) this.mPoiList.get(position);
            if (searchPoi != null) {
                viewHodler.mTvName.setText(searchPoi.mName);
                viewHodler.mTvAddr.setText(searchPoi.mAddress);
                viewHodler.mTvDistance.setText(PoiController.getInstance().getDistance2CurrentPoint(searchPoi));
            }
            viewHodler.mBtnStartNavi.setTag(searchPoi);
            viewHodler.mBtnNameAddr.setTag(Integer.valueOf(position));
            viewHodler.mBtnNameAddr.setOnClickListener(SearchResultFragment.this.mResultAdapter.getNameSearchResultListener());
            viewHodler.mBtnStartNavi.setOnClickListener(SearchResultFragment.this.mResultAdapter.getNameSearchResultListener());
            ((ViewPager) arg0).addView(convertView, 0);
            return convertView;
        }

        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        public void restoreState(Parcelable arg0, ClassLoader arg1) {
        }

        public Parcelable saveState() {
            return null;
        }

        public void startUpdate(View arg0) {
        }

        public int getItemPosition(Object object) {
            return -2;
        }
    }

    static class ViewHodler {
        View mBtnNameAddr;
        View mBtnStartNavi;
        GridView mChildGrideList;
        View mDivider;
        ImageView mIcResult;
        LinearLayout mLayoutChildBottom;
        RelativeLayout mPoiParent;
        TextView mTvAddr;
        TextView mTvDistance;
        TextView mTvName;
        TextView mTvNum;
        TextView mTvStartNavi;
        View mVerDiverderA;

        ViewHodler() {
        }
    }

    public static void showSearchNetworkingDialog(Activity activity, int contentResId, int confirmResId, OnClickListener confirmListener, OnClickListener downloadListener, OnClickListener cancleListener) {
        dismissSearchNetworkingDialog();
        if (mNetworkingDialog == null) {
            mNetworkingDialog = new BNNetworkingDialog(activity).setTwoButtonMode(true);
            mNetworkingDialog.setNetworkingContentMessage(StyleManager.getString(C0965R.string.search_net_connect_tips));
            mNetworkingDialog.setConfirmNetworkingListener(confirmListener);
            mNetworkingDialog.setCancleListener(cancleListener);
        }
        mNetworkingDialog.show();
    }

    public static boolean dismissSearchNetworkingDialog() {
        if (mNetworkingDialog != null && mNetworkingDialog.isShowing()) {
            mNetworkingDialog.dismiss();
        }
        mNetworkingDialog = null;
        return true;
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mLastOrientation = getResources().getConfiguration().orientation;
        this.mGroupView = (ViewGroup) inflater.inflate(C0965R.layout.frag_search_result, null);
        this.mTitleBar = (MapTitleBar) this.mGroupView.findViewById(C0965R.id.title_bar);
        this.mResultListView = (XListView) this.mGroupView.findViewById(C0965R.id.lv_search_result);
        this.mDrawingLayout = (LinearLayout) this.mGroupView.findViewById(C0965R.id.slide_drawer);
        this.mHandleView = (ImageView) this.mGroupView.findViewById(C0965R.id.pull_handle);
        this.mHandleView.setOnTouchListener(this.mTouchListener);
        this.mTitleBar.setRightButtonBackground(StyleManager.getDrawable(C0965R.drawable.sort_default));
        this.mTitleBar.setRightButtonVisible(true);
        this.mTitleBar.setLeftOnClickedListener(getOnClickListener());
        this.mTitleBar.setRightOnClickedListener(getOnClickListener());
        this.mResultListView.setAutoLoadEnable(false);
        this.mResultListView.setDividerHeight(0);
        this.mResultListView.setXListViewListener(this.mIXListViewListener);
        this.mResultListView.setPullRefreshEnable(false);
        this.mSortingRl = (RelativeLayout) this.mGroupView.findViewById(C0965R.id.sr_cover_sorting);
        this.mSortingRl.setVisibility(8);
        this.mSortingRl.setOnTouchListener(new C38477());
        this.mCloseSortingIv = (ImageView) this.mGroupView.findViewById(C0965R.id.iv_close_sorting);
        this.mSortByKey = (RelativeLayout) this.mGroupView.findViewById(C0965R.id.rl_sort_by_key);
        this.mSortByDistance = (RelativeLayout) this.mGroupView.findViewById(C0965R.id.rl_sort_by_distance);
        this.mSortByKeyTv = (TextView) this.mGroupView.findViewById(C0965R.id.tv_sort_by_key);
        this.mSortByDistanceTv = (TextView) this.mGroupView.findViewById(C0965R.id.tv_sort_by_distance);
        this.mSortByKeyIv = (ImageView) this.mGroupView.findViewById(C0965R.id.iv_sort_by_key);
        this.mSortByDistanceIv = (ImageView) this.mGroupView.findViewById(C0965R.id.iv_sort_by_distance);
        this.mCloseSortingIv.setOnClickListener(getOnClickListener());
        this.mSortByKey.setOnClickListener(getOnClickListener());
        this.mSortByDistance.setOnClickListener(getOnClickListener());
        this.mViewPager = (ViewPager) this.mGroupView.findViewById(C0965R.id.vp_search_result);
        return this.mGroupView;
    }

    private void updateSortView() {
        switch (this.mSearchPoiPager.getSearchType()) {
            case 1:
                this.mSortByKeyIv.setVisibility(0);
                this.mSortByDistanceIv.setVisibility(8);
                this.mSortByKeyTv.setTextColor(StyleManager.getColor(C0965R.color.search_sort_selected_text_color));
                this.mSortByDistanceTv.setTextColor(StyleManager.getColor(C0965R.color.search_sort_unselected_text_color));
                this.mSearchPoiPager.setSortType(1);
                return;
            case 2:
            case 3:
            case 4:
            case 5:
                this.mSortByKeyIv.setVisibility(8);
                this.mSortByDistanceIv.setVisibility(0);
                this.mSortByKeyTv.setTextColor(StyleManager.getColor(C0965R.color.search_sort_unselected_text_color));
                this.mSortByDistanceTv.setTextColor(StyleManager.getColor(C0965R.color.search_sort_selected_text_color));
                this.mSearchPoiPager.setSortType(2);
                return;
            default:
                return;
        }
    }

    protected void onInitView() {
        getBundle();
        this.mDrawingLayout.setOnTouchListener(new C38488());
    }

    public void onResume() {
        super.onResume();
        if (this.isFromVoiceCommand && !this.isVoiceCommandResponsed) {
            this.isVoiceCommandResponsed = true;
            if (!(this.mSearchPoiPager == null || this.mSearchPoiPager.getPoiList() == null)) {
                responsePoiResultCountToVoiceCommand(this.mSearchPoiPager.getPoiList().size());
            }
        }
        setMapLayerMode(2);
        BNMapController.getInstance().showLayer(3, false);
        BNMapController.getInstance().updateLayer(3);
        PoiController.getInstance().setMapffset(0, (long) (ScreenUtil.getInstance().getHeightPixels() - ScreenUtil.getInstance().dip2px(250)));
        updateMapView(Middle_TOP_NORMAL);
        BNMapController.getInstance().addObserver(this.mBNMapObserver);
    }

    public void onPause() {
        super.onPause();
        BNPoiSearcher.getInstance().setNetMode(BNSettingManager.getPrefSearchMode());
        BNMapController.getInstance().deleteObserver(this.mBNMapObserver);
        PoiController.getInstance().focusItem(false);
    }

    protected void onUpdateOrientation(int orientation) {
        if (orientation != this.mLastOrientation) {
            this.mLastOrientation = orientation;
        }
    }

    protected void onUpdateStyle(boolean dayStyle) {
        this.mTitleBar.onUpdateStyle(dayStyle);
        this.mHandleView.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_btn_poi_dragon_selector));
        if (this.mResultAdapter != null) {
            this.mResultAdapter.notifyDataSetChanged();
        }
        this.mResultListView.setBackgroundColor(StyleManager.getColor(C0965R.color.bnav_common_bg));
        this.mResultListView.setTextColor(StyleManager.getColor(C0965R.color.poi_detail_addr));
        this.mHandleView.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_poi_list_drag));
    }

    public boolean onBackPressed() {
        if (this.mSortingRl != null && this.mSortingRl.getVisibility() == 0) {
            this.mSortingRl.setVisibility(8);
        } else if (this.mNewerGuideLayout != null) {
            try {
                this.mGroupView.removeView(this.mNewerGuideLayout);
                this.mNewerGuideLayout = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (this.isFromCatalogSearch) {
            back(null);
        } else {
            back(null);
        }
        return true;
    }

    private void getBundle() {
        boolean isOnline = false;
        if (this.mShowBundle != null) {
            this.mSearchKey = this.mShowBundle.getString("search_key");
            this.mTitleBar.setMiddleText(null);
            PoiSearchModel poiSearchModel = (PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH);
            if (this.mShowBundle.containsKey("district_id")) {
                this.mCurrentDistrictId = this.mShowBundle.getInt("district_id");
            }
            if (this.mShowBundle.getInt("incoming_type") == 33) {
                this.isFromCatalogSearch = true;
            } else {
                this.isFromCatalogSearch = false;
            }
            if (this.mShowBundle.getInt("incoming_type") == 35) {
                this.isFromVoiceCommand = true;
                this.isVoiceCommandResponsed = false;
                this.voiceCommandTopType = this.mShowBundle.getInt(BNVoiceCommandParams.Key_Bundle_VC_Top_Type, -1);
                this.voiceCommandSubType = this.mShowBundle.getInt(BNVoiceCommandParams.Key_Bundle_VC_Sub_Type, -1);
            } else {
                this.isFromVoiceCommand = false;
            }
            this.searchType = this.mShowBundle.getInt("search_type");
            if (this.mShowBundle.getInt("search_mode") == 1) {
                this.netMode = 1;
            } else if (this.mShowBundle.getInt("search_mode") == 0) {
                this.netMode = 0;
            }
            if (this.mShowBundle.containsKey(BundleKey.SELECT_POINT_ACTION)) {
                this.isSetPointMode = true;
            } else {
                this.isSetPointMode = false;
            }
            int setPointMode = this.mShowBundle.getInt(BundleKey.SELECT_POINT_ACTION);
            if (setPointMode == 5 || setPointMode == 4) {
                this.isSetHomeComp = true;
                LogUtil.m15791e("PoiSearch", "isSetHomeComp =" + this.isSetHomeComp);
            } else {
                this.isSetHomeComp = false;
            }
            List<SearchPoiPager> searchPoiPagers = poiSearchModel.getSearchPoiPagerList();
            if (searchPoiPagers.size() > 0) {
                this.mSearchPoiPager = (SearchPoiPager) searchPoiPagers.get(0);
                updateSortView();
                List<SearchPoi> listPoi = this.mSearchPoiPager.getPoiList();
                if (listPoi == null || listPoi.size() <= 0) {
                    back(null);
                    return;
                } else if (((SearchPoi) listPoi.get(0)).mType == 1) {
                    if (this.mSearchPoiPager.getNetMode() == 1) {
                        isOnline = true;
                    }
                    showCityList(listPoi, isOnline);
                    this.isCityResultMode = true;
                    BNVoiceCommandController.getInstance().commonVoiceCommandResponse(this.voiceCommandTopType, 2);
                    return;
                } else {
                    this.mResultAdapter = new SearchResultAdapter(mActivity, this.mSearchPoiPager, getNaviFragmentManager(), this.isSetPointMode, this);
                    this.mResultAdapter.setShowBundle(this.mShowBundle);
                    this.mResultAdapter.setOnlineSearchListener(this.mOnlineClickListener);
                    this.mResultListView.setAdapter(this.mResultAdapter);
                    updateListView();
                    int parCnt = this.mSearchPoiPager.getCountPerPager();
                    ArrayList<SearchPoi> mResultPoiList = new ArrayList(parCnt);
                    for (int i = 0; i < parCnt; i++) {
                        mResultPoiList.add(this.mSearchPoiPager.getPoiList().get(i));
                    }
                    this.mSearchResultViewPagerAdapter = new SearchResultViewPagerAdapter(mResultPoiList);
                    this.mViewPager.setAdapter(this.mSearchResultViewPagerAdapter);
                    this.mViewPager.setCurrentItem(0);
                    this.isCityResultMode = false;
                    return;
                }
            }
            back(null);
        }
    }

    private void updateListView() {
        if (this.mSearchPoiPager != null) {
            if (this.mSearchPoiPager.getPrevPager() != null) {
                this.mResultListView.setPullRefreshEnable(true);
            } else {
                this.mResultListView.setPullRefreshEnable(false);
            }
            if (this.mSearchPoiPager.isLastPager()) {
                this.mResultListView.setPullLoadEnable(false);
            } else {
                this.mResultListView.setPullLoadEnable(true);
            }
            this.mResultListView.setSelection(0);
        }
    }

    private void updateViewWithOrientation(int orientation, boolean dayStyle) {
    }

    private OnClickListener getOnClickListener() {
        return new C38499();
    }

    protected void sortListByDistance() {
        boolean dayStyle = C1192c.a().f();
        GeoPoint mCenter = BNGeoLocateManager.getInstance().getLastValidLocation();
        if (mCenter != null && mCenter.getLatitudeE6() == Integer.MIN_VALUE && mCenter.getLongitudeE6() == Integer.MIN_VALUE) {
            TipTool.onCreateToastDialog(getContext(), (int) C0965R.string.space_search_center_error);
            dismissDialog(this.mFilterRuleDialog);
            return;
        }
        BNPoiSearcher.getInstance().quickSortByDistance(mCenter, this.mPoiList);
        this.isListSort = !this.isListSort;
        updateViewWithOrientation(this.mLastOrientation, dayStyle);
    }

    protected void sortListByRule() {
        this.mResultAdapter.setSearchPager(this.mSearchPoiPager);
    }

    protected void onInitMap() {
    }

    private void responsePoiResultCountToVoiceCommand(int count) {
        if (this.voiceCommandTopType == -1 || this.voiceCommandSubType == -1) {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(5, 2);
        } else {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(this.voiceCommandTopType, 1, "为您搜索到" + count + "条结果");
        }
    }

    public boolean onVoiceCommand(int type, int subType, int arg1, Object arg2, boolean needResponse) {
        if (3 == type && 3 == subType && arg1 >= 21 && arg1 <= 30) {
            if (onVoiceCommandToClickPoiResultItem(arg1 - 21)) {
                BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 1);
            } else {
                BNVoiceCommandController.getInstance().commonVoiceCommandResponse(type, 3);
            }
        }
        return super.onVoiceCommand(type, subType, arg1, arg2, needResponse);
    }

    public boolean onVoiceCommand(String strCommand, String strIntent) {
        return false;
    }

    private boolean onVoiceCommandToClickPoiResultItem(int index) {
        if (this.isCityResultMode) {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(this.voiceCommandTopType, 2);
            return false;
        }
        if (this.mPoiList != null && index >= 0 && index < this.mPoiList.size()) {
            SearchPoi sp = (SearchPoi) this.mPoiList.get(index);
            if (sp != null) {
                if (BNVoiceCommandController.getInstance().isSettingHome()) {
                    BNVoiceCommandController.getInstance().setIsSettingHome(false);
                    AddressSettingModel.setHomeAddress(mActivity, sp.mAddress, sp.mName, sp.mGuidePoint.getLongitudeE6(), sp.mGuidePoint.getLatitudeE6(), sp.mOriginUID);
                } else if (BNVoiceCommandController.getInstance().isSettingOffice()) {
                    BNVoiceCommandController.getInstance().setIsSettingOffice(false);
                    AddressSettingModel.setCompAddress(mActivity, sp.mAddress, sp.mName, sp.mGuidePoint.getLongitudeE6(), sp.mGuidePoint.getLatitudeE6(), sp.mOriginUID);
                }
            }
        }
        return onClickPoiResult(index);
    }

    private boolean onClickPoiResult(int index) {
        if (this.mSearchPoiPager == null) {
            return false;
        }
        List<SearchPoi> mPoiList = this.mSearchPoiPager.getPoiList();
        if (mPoiList == null || index < 0 || index >= mPoiList.size()) {
            return false;
        }
        ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).setPoiList(mPoiList);
        Bundle bundle = new Bundle();
        bundle = this.mShowBundle;
        bundle.putInt("incoming_type", 83);
        bundle.putInt("search_result_mode", this.netMode);
        bundle.putInt("current_poi", index);
        bundle.putString("search_key", this.mSearchKey);
        bundle.putInt("district_id", this.mCurrentDistrictId);
        if (!(mActivity == null || mActivity.isFinishing())) {
            showFragment(33, bundle);
        }
        return true;
    }

    private void updateMapView(int bottom) {
        int size = 10;
        PoiController.getInstance().clearPoiCache();
        if (this.mSearchPoiPager != null && this.mSearchPoiPager.getPoiList() != null) {
            if (this.mSearchPoiPager.getPoiList().size() < 10) {
                size = this.mSearchPoiPager.getPoiList().size();
            }
            ArrayList<SearchPoi> searchPois = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                searchPois.add(this.mSearchPoiPager.getPoiList().get(i));
            }
            PoiController.getInstance().updatePoiBkgLayer(searchPois);
            Rect rect = new Rect();
            rect.left = 0;
            rect.top = ScreenUtil.getInstance().getHeightPixels() - ScreenUtil.getInstance().getStatusBarHeight();
            rect.right = ScreenUtil.getInstance().getWidthPixels();
            rect.bottom = rect.top - bottom;
            BNMapController.getInstance().updateMapView(searchPois, rect, true);
        }
    }

    private void showCityList(final List<SearchPoi> list, boolean isOnline) {
        int i;
        if (this.mPreSearchCityList != null && this.mPreSearchCityList.size() == list.size()) {
            i = 0;
            while (i < this.mPreSearchCityList.size()) {
                SearchPoi preTemp = (SearchPoi) this.mPreSearchCityList.get(i);
                SearchPoi temp = (SearchPoi) list.get(i);
                if (preTemp == null || temp == null || preTemp.mId != temp.mId) {
                    break;
                }
                i++;
            }
            if (i == this.mPreSearchCityList.size()) {
                TipTool.onCreateToastDialog(getContext().getApplicationContext(), (int) C0965R.string.search_result_toast_failed);
                onBackPressed();
                return;
            }
        }
        dismissDialog(this.mCityListDialog);
        this.mCityListDialog = new C2287n(mActivity).i(StyleManager.getString(C0965R.string.select_city_title)).a(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                DistrictInfo districtInfo;
                SearchResultFragment.this.dismissDialog(SearchResultFragment.this.mCityListDialog);
                SearchPoi searchPoi = (SearchPoi) list.get(position);
                if ((searchPoi.mDistrictId & -65536) <= 0 || (searchPoi.mDistrictId & 65535) != 0) {
                    districtInfo = BNPoiSearcher.getInstance().getDistrictById(searchPoi.mDistrictId);
                } else {
                    districtInfo = BNPoiSearcher.getInstance().getDistrictById(searchPoi.mDistrictId >> 16);
                }
                SearchPoiPager searchPoiPager = new SearchPoiPager(SearchResultFragment.this.mSearchPoiPager.getSearchKey(), districtInfo, 10, SearchResultFragment.this.mSearchPoiPager.getNetMode());
                C1307e.a().a("", SearchResultFragment.this.mSearchDialogCancelListener);
                ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchPoiPagerList().clear();
                BNPoiSearcher.getInstance().setNetMode(searchPoiPager.getNetMode());
                BNPoiSearcher.getInstance().asynSearchWithPager(searchPoiPager, SearchResultFragment.this.mHandler);
                SearchResultFragment.this.mPreSearchCityList = list;
            }
        });
        ArrayList<String> mDataList = new ArrayList();
        for (i = 0; i < list.size(); i++) {
            SearchPoi tempPoi = (SearchPoi) list.get(i);
            if (isOnline) {
                mDataList.add(tempPoi.mName + "(" + (tempPoi.mWeight == 0 ? 1 : tempPoi.mWeight) + ")");
            } else {
                mDataList.add(tempPoi.mName);
            }
        }
        this.mCityListDialog.setListAdapter(mDataList);
        showDialog(this.mCityListDialog);
    }

    protected void handleClickPoiBkgLayer(MapItem arg) {
        if (arg != null) {
            int id = BNPoiSearcher.getInstance().parseBkgLayerId(arg.mUid);
            Bundle bundle;
            if (this.isSetPointMode) {
                if (id >= 0 && id < this.mSearchPoiPager.getPoiList().size()) {
                    SearchPoi searchPoi = (SearchPoi) this.mSearchPoiPager.getPoiList().get(id);
                    if (this.mShowBundle.getInt(BundleKey.SELECT_POINT_ACTION) == 1) {
                        ((RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN)).setPointSelectNode(searchPoi);
                        backTo(this.mShowBundle.getInt(BundleKey.FROM_FRAGMENT), null);
                        return;
                    }
                    bundle = new Bundle();
                    bundle.putInt(BundleKey.SELECT_POINT_ACTION, this.mShowBundle.getInt(BundleKey.SELECT_POINT_ACTION));
                    UIModel.settingAddress(searchPoi, mActivity, bundle);
                    backTo(this.mShowBundle.getInt(BundleKey.FROM_FRAGMENT), null);
                }
            } else if (id >= 0 && id < this.mSearchPoiPager.getPoiList().size()) {
                ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).setPoiList(this.mSearchPoiPager.getPoiList());
                this.mChildCnt = this.mResultAdapter.getChildCnt();
                this.mChildIndex = this.mResultAdapter.getChildIndex();
                bundle = new Bundle();
                bundle.putInt("incoming_type", 83);
                bundle.putInt("search_result_mode", this.mSearchPoiPager.getNetMode());
                bundle.putInt("current_poi", id);
                bundle.putIntArray("child_count_array", this.mChildCnt);
                bundle.putIntArray("child_start_array", this.mChildIndex);
                showFragment(33, bundle);
            }
        }
    }

    private int getTopMargin() {
        return ((RelativeLayout.LayoutParams) this.mDrawingLayout.getLayoutParams()).topMargin;
    }

    private int updateTopMargin(float deltaY) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mDrawingLayout.getLayoutParams();
        layoutParams.topMargin = (int) (((float) layoutParams.topMargin) + deltaY);
        this.mDrawingLayout.setLayoutParams(layoutParams);
        return layoutParams.topMargin;
    }

    private void setListViewMargin(int margin) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mDrawingLayout.getLayoutParams();
        layoutParams.topMargin = margin;
        this.mDrawingLayout.setLayoutParams(layoutParams);
    }
}
