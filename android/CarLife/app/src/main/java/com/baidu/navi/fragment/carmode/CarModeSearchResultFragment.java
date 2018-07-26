package com.baidu.navi.fragment.carmode;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils.TruncateAt;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.baidumaps.p042f.p043a.p044a.C0705a;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C0936j;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.presentation.p071a.C1307e;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.custom.C1343b;
import com.baidu.carlife.fragment.WebViewFragment;
import com.baidu.carlife.logic.C1765g;
import com.baidu.carlife.p077e.C1435a;
import com.baidu.carlife.p078f.C1436a;
import com.baidu.carlife.p078f.C1438c;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.util.C2178i;
import com.baidu.carlife.util.C2201w;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.navi.adapter.SearchResultAdapter.OnClickOnlineSearch;
import com.baidu.navi.adapter.carmode.CarmodeSearchResultAdapter;
import com.baidu.navi.controller.FavoriteDestinationController;
import com.baidu.navi.controller.NameSearchHelper;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.controller.SearchStrategyHelper;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.ContentFragmentManager;
import com.baidu.navi.fragment.NameSearchFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.logic.model.UIModel;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.view.xpulltorefresh.XListView;
import com.baidu.navi.view.xpulltorefresh.XListView.IXListViewListener;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.base.BNSubject;
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
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.SearchCircle;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.widget.BNNetworkingDialog;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

public class CarModeSearchResultFragment extends ContentFragment {
    public static final String DISTRICT_ID = "district_id";
    public static final int INCOMING_CATALOG_SEARCH = 33;
    public static final int INCOMING_QUICK_ROUTE_PLAN = 34;
    public static final String INCOMING_TYPE = "incoming_type";
    public static final int INCOMING_VOICE_COMMAND = 35;
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
    private static BNNetworkingDialog mNetworkingDialog;
    private int comeFrom;
    private boolean isCityResultMode = false;
    private boolean isFromCatalogSearch = false;
    private boolean isFromOnekeyToOil = false;
    private boolean isFromVoiceCommand = false;
    private boolean isSetHomeComp = false;
    private boolean isSetPointMode = false;
    private boolean isVoiceCommandResponsed = false;
    private BNMapObserver mBNMapObserver = new BNMapObserver() {
        public void update(BNSubject o, int type, int event, Object arg) {
            if (2 == type) {
                switch (event) {
                    case 517:
                        C1260i.e("POI", "BNMapObserver.EventGesture.EVENT_LONGPRESS");
                        MotionEvent motionEvent = (MotionEvent) arg;
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
                        return;
                    case 265:
                        CarModeSearchResultFragment.this.handleClickPoiBkgLayer((MapItem) arg);
                        return;
                    case 276:
                        return;
                    case 277:
                        C1260i.e("POI", "BNMapObserver.EventGesture.EVENT_CLICKED_POI_LAYER");
                        return;
                    default:
                        return;
                }
            }
        }
    };
    private ImageView mBackImg;
    private int[] mChildCnt = new int[200];
    private int[] mChildIndex = new int[200];
    private ListView mCityListview;
    private View mCityResultView;
    private ImageView mCloseSortingIv;
    private int mCurrentDistrictId;
    private GeoPoint mCurrentGeoPoint;
    private DistrictInfo mDistrictInfo;
    private C1443g mFocusAreaUp;
    private C1443g mFocusAreaUpCityResult;
    private C1438c mFocusList;
    private C1438c mFocusListCityResult;
    private ViewGroup mGroupView;
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            boolean isOnline = true;
            if (!CarModeSearchResultFragment.this.isDetached() && !CarModeSearchResultFragment.this.isRemoving()) {
                RspData rsp = msg.obj;
                if (msg.what == 1005) {
                    C1307e.a().c();
                    CarModeSearchResultFragment.this.mResultListView.stopLoadMore();
                    SearchPoiPager searchPoiPager = rsp.mData;
                    if (searchPoiPager == null) {
                        C1260i.e("PoiSearch", "search with pager fail");
                        TipTool.onCreateToastDialog(CarModeSearchResultFragment.this.getContext(), (int) C0965R.string.search_result_toast_failed);
                        if (CarModeSearchResultFragment.this.mResultAdapter == null) {
                            CarModeSearchResultFragment.this.back(null);
                        }
                    } else if (msg.arg1 == 0) {
                        List<SearchPoi> poiList = searchPoiPager.getPoiList();
                        if (poiList == null || poiList.size() == 0) {
                            C1260i.e("PoiSearch", "search with pager fail");
                            TipTool.onCreateToastDialog(CarModeSearchResultFragment.this.getContext(), (int) C0965R.string.search_result_toast_failed);
                            if (CarModeSearchResultFragment.this.mResultAdapter == null) {
                                CarModeSearchResultFragment.this.back(null);
                            }
                        } else if (((SearchPoi) poiList.get(0)).mType == 1) {
                            if (searchPoiPager.getNetMode() != 1) {
                                isOnline = false;
                            }
                            CarModeSearchResultFragment.this.showCityList(poiList, isOnline);
                        } else {
                            CarModeSearchResultFragment.this.mSearchPoiPager = searchPoiPager;
                            CarModeSearchResultFragment.this.updateSortView();
                            if (CarModeSearchResultFragment.this.mResultAdapter != null) {
                                CarModeSearchResultFragment.this.mResultAdapter.setSearchPager(CarModeSearchResultFragment.this.mSearchPoiPager);
                            } else {
                                CarModeSearchResultFragment.this.mResultAdapter = new CarmodeSearchResultAdapter(BaseFragment.mActivity, CarModeSearchResultFragment.this.mSearchPoiPager, CarModeSearchResultFragment.this.getNaviFragmentManager(), CarModeSearchResultFragment.this.isSetPointMode, CarModeSearchResultFragment.this);
                                CarModeSearchResultFragment.this.mResultAdapter.setOnlineSearchListener(CarModeSearchResultFragment.this.mOnlineClickListener);
                                CarModeSearchResultFragment.this.mResultAdapter.setShowBundle(CarModeSearchResultFragment.this.mShowBundle);
                                CarModeSearchResultFragment.this.mResultListView.setItemsCanFocus(true);
                                CarModeSearchResultFragment.this.mResultListView.setAdapter(CarModeSearchResultFragment.this.mResultAdapter);
                                CarModeSearchResultFragment.this.mResultListView.setOnItemClickListener(CarModeSearchResultFragment.this.getOnItemClickListener());
                            }
                            CarModeSearchResultFragment.this.updateListView();
                            CarModeSearchResultFragment.this.updateMapView();
                            CarModeSearchResultFragment.this.mPreSearchCityList = null;
                        }
                    } else if (CommandResult.isNetworkErr(msg.arg1)) {
                        C1260i.e("PoiSearch", "search with pager fail");
                        TipTool.onCreateToastDialog(CarModeSearchResultFragment.this.getContext(), (int) C0965R.string.search_result_toast_failed);
                        CarModeSearchResultFragment.this.mPreSearchCityList = null;
                        if (CarModeSearchResultFragment.this.mResultAdapter == null) {
                            CarModeSearchResultFragment.this.back(null);
                        }
                    } else {
                        C1260i.e("PoiSearch", "search with pager fail");
                        TipTool.onCreateToastDialog(CarModeSearchResultFragment.this.getContext(), (int) C0965R.string.search_result_toast_failed);
                        CarModeSearchResultFragment.this.mPreSearchCityList = null;
                        if (CarModeSearchResultFragment.this.mResultAdapter == null) {
                            CarModeSearchResultFragment.this.back(null);
                        }
                    }
                }
            }
        }
    };
    private IXListViewListener mIXListViewListener = new IXListViewListener() {

        /* renamed from: com.baidu.navi.fragment.carmode.CarModeSearchResultFragment$10$1 */
        class C39231 implements Runnable {
            C39231() {
            }

            public void run() {
                CarModeSearchResultFragment.this.mResultListView.stopRefresh();
                SearchPoiPager searchPoiPager = CarModeSearchResultFragment.this.mSearchPoiPager.getPrevPager();
                if (searchPoiPager != null) {
                    CarModeSearchResultFragment.this.mSearchPoiPager = searchPoiPager;
                    CarModeSearchResultFragment.this.mResultAdapter.setSearchPager(CarModeSearchResultFragment.this.mSearchPoiPager);
                    CarModeSearchResultFragment.this.updateListView();
                    CarModeSearchResultFragment.this.updateMapView();
                }
            }
        }

        /* renamed from: com.baidu.navi.fragment.carmode.CarModeSearchResultFragment$10$2 */
        class C39242 implements Runnable {
            C39242() {
            }

            public void run() {
                CarModeSearchResultFragment.this.mResultListView.stopLoadMore();
                SearchPoiPager searchPoiPager = CarModeSearchResultFragment.this.mSearchPoiPager.getNextPager();
                if (searchPoiPager != null) {
                    CarModeSearchResultFragment.this.mSearchPoiPager = searchPoiPager;
                    CarModeSearchResultFragment.this.mResultAdapter.setSearchPager(searchPoiPager);
                    CarModeSearchResultFragment.this.updateListView();
                    CarModeSearchResultFragment.this.updateMapView();
                }
            }
        }

        public void onRefresh() {
            CarModeSearchResultFragment.this.mHandler.postDelayed(new C39231(), 1000);
        }

        public void onLoadMore() {
            SearchPoiPager nextPager = CarModeSearchResultFragment.this.mSearchPoiPager.getNextPager();
            if (nextPager == null || nextPager.getPoiList() == null || nextPager.getPoiList().size() <= 0) {
                SearchPoiPager searchPoiPager = CarModeSearchResultFragment.this.mSearchPoiPager.createNextPager();
                if (searchPoiPager == null || !CarModeSearchResultFragment.this.checkCanSearchByNetMode(searchPoiPager.getNetMode())) {
                    CarModeSearchResultFragment.this.mResultListView.stopLoadMore();
                    return;
                }
                BNPoiSearcher.getInstance().setNetMode(searchPoiPager.getNetMode());
                BNPoiSearcher.getInstance().asynSearchWithPager(searchPoiPager, CarModeSearchResultFragment.this.mHandler);
                return;
            }
            CarModeSearchResultFragment.this.mHandler.postDelayed(new C39242(), 1000);
        }
    };
    private TextView mJybBtn;
    private int mLastOrientation = 0;
    private View mListviewLayout;
    private View mMapbtn;
    private OnKeyListener mOnKeyListener = new OnKeyListener() {
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (event != null && event.getAction() == 0) {
                switch (keyCode) {
                    case 300:
                        if (CarModeSearchResultFragment.this.mSearchPoiPager != null && CarModeSearchResultFragment.this.mSearchPoiPager.isLastPager() && CarModeSearchResultFragment.this.mResultListView != null && CarModeSearchResultFragment.this.mResultListView.getSelectedItemPosition() > CarModeSearchResultFragment.this.mSearchPoiPager.getPoiList().size()) {
                            return true;
                        }
                    case 301:
                        if (CarModeSearchResultFragment.this.mResultListView != null && CarModeSearchResultFragment.this.mResultListView.getSelectedItemPosition() == 1) {
                            return true;
                        }
                }
            }
            return false;
        }
    };
    private OnClickOnlineSearch mOnlineClickListener = new C39339();
    private View mPoiConfirmText;
    private ArrayList<SearchPoi> mPoiList;
    private List<SearchPoi> mPreSearchCityList;
    private CarmodeSearchResultAdapter mResultAdapter;
    private XListView mResultListView;
    private C0672b mSearchDialogCancelListener = new C0672b() {
        public void onClick() {
            if (CarModeSearchResultFragment.this.mResultAdapter == null) {
                CarModeSearchResultFragment.this.onBackPressed();
            }
            BNPoiSearcher.getInstance().cancelQuery();
        }
    };
    private String mSearchKey;
    private SearchPoiPager mSearchPoiPager;
    private RelativeLayout mSortByDistance;
    private ImageView mSortByDistanceIv;
    private RelativeLayout mSortByKey;
    private ImageView mSortByKeyIv;
    private RelativeLayout mSortingRl;
    private View mViewMapLayput;
    protected C0936j myHandler = new C0936j() {
        public void careAbout() {
            addMsg(1002);
            addMsg(1004);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1002:
                    CarModeSearchResultFragment.this.updateJybButtonState();
                    return;
                case 1004:
                    CarModeSearchResultFragment.this.updateJybButtonState();
                    return;
                default:
                    return;
            }
        }
    };
    private int netMode = 1;
    private int voiceCommandSubType = -1;
    private int voiceCommandTopType = -1;

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeSearchResultFragment$1 */
    class C39251 implements OnClickListener {
        C39251() {
        }

        public void onClick(View v) {
            CarModeSearchResultFragment.this.onBackPressed();
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeSearchResultFragment$2 */
    class C39262 implements OnClickListener {
        C39262() {
        }

        public void onClick(View v) {
            CarModeSearchResultFragment.this.backFromMap();
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeSearchResultFragment$3 */
    class C39273 implements OnClickListener {
        C39273() {
        }

        public void onClick(View v) {
            CarModeSearchResultFragment.this.onBackPressed();
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeSearchResultFragment$4 */
    class C39284 implements OnTouchListener {
        C39284() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeSearchResultFragment$5 */
    class C39295 implements OnClickListener {
        C39295() {
        }

        public void onClick(View v) {
            if (CarModeSearchResultFragment.this.mResultAdapter == null) {
                CarModeSearchResultFragment.this.onBackPressed();
                return;
            }
            CarModeSearchResultFragment.this.mCityResultView.setVisibility(8);
            CarModeSearchResultFragment.this.mResultListView.setVisibility(0);
            if (CarModeSearchResultFragment.this.isPoiComfirmPage()) {
                CarModeSearchResultFragment.this.mPoiConfirmText.setVisibility(0);
            } else {
                CarModeSearchResultFragment.this.mPoiConfirmText.setVisibility(8);
            }
            CarModeSearchResultFragment.this.initFocusChain(CarModeSearchResultFragment.this.mGroupView);
            CarModeSearchResultFragment.this.mPreSearchCityList = null;
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeSearchResultFragment$6 */
    class C39306 implements OnTouchListener {
        C39306() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            return true;
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeSearchResultFragment$7 */
    class C39317 implements OnClickListener {
        C39317() {
        }

        public void onClick(View v) {
            if (CarModeSearchResultFragment.this.isJybEnable()) {
                StatisticManager.onEvent(StatisticConstants.DISCOVER_JYB_0001);
                CarModeSearchResultFragment.this.openWebView(2, NaviFragmentManager.TYPE_HOME_DISCOVER_JYB, CarModeSearchResultFragment.this.getStringUtil(C0965R.string.home_discovery_jyb_title), WebViewFragment.f4869i);
                return;
            }
            C2201w.a("暂不支持该服务", 0);
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeSearchResultFragment$8 */
    class C39328 implements OnClickListener {
        C39328() {
        }

        public void onClick(View v) {
            CarModeSearchResultFragment.this.onBackPressed();
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeSearchResultFragment$9 */
    class C39339 implements OnClickOnlineSearch {
        C39339() {
        }

        public void onNormalOnlineSearch() {
            if (NetworkUtils.getConnectStatus()) {
                SearchPoiPager srcPager = CarModeSearchResultFragment.this.mSearchPoiPager;
                while (true) {
                    SearchPoiPager pager = srcPager.getPrevPager();
                    if (pager == null) {
                        pager = srcPager.copy();
                        pager.setNetMode(1);
                        C1307e.a().a(CarModeSearchResultFragment.this.getResources().getString(C0965R.string.progress_searching), CarModeSearchResultFragment.this.mSearchDialogCancelListener);
                        ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchPoiPagerList().clear();
                        BNPoiSearcher.getInstance().setNetMode(pager.getNetMode());
                        BNPoiSearcher.getInstance().asynSearchWithPager(pager, CarModeSearchResultFragment.this.mHandler);
                        return;
                    }
                    srcPager = pager;
                }
            } else {
                TipTool.onCreateToastDialog(CarModeSearchResultFragment.this.getContext(), (int) C0965R.string.network_not_use);
            }
        }

        public void onCountrywideOnlineSearch() {
            if (NetworkUtils.getConnectStatus()) {
                SearchPoiPager srcPager = CarModeSearchResultFragment.this.mSearchPoiPager;
                while (true) {
                    SearchPoiPager pager = srcPager.getPrevPager();
                    if (pager == null) {
                        pager = srcPager.copy();
                        pager.setNetMode(1);
                        pager.setDistrict(BNPoiSearcher.getInstance().getDistrictById(0));
                        C1307e.a().a(CarModeSearchResultFragment.this.getResources().getString(C0965R.string.progress_searching), CarModeSearchResultFragment.this.mSearchDialogCancelListener);
                        ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchPoiPagerList().clear();
                        BNPoiSearcher.getInstance().setNetMode(pager.getNetMode());
                        BNPoiSearcher.getInstance().asynSearchWithPager(pager, CarModeSearchResultFragment.this.mHandler);
                        return;
                    }
                    srcPager = pager;
                }
            } else {
                TipTool.onCreateToastDialog(CarModeSearchResultFragment.this.getContext(), (int) C0965R.string.network_not_use);
            }
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mLastOrientation = getResources().getConfiguration().orientation;
        this.mGroupView = (ViewGroup) inflater.inflate(C0965R.layout.car_mode_frag_search_result, null);
        this.mPoiConfirmText = this.mGroupView.findViewById(C0965R.id.poi_confirm_title_view);
        if (isPoiComfirmPage()) {
            this.mPoiConfirmText.setVisibility(0);
        } else {
            this.mPoiConfirmText.setVisibility(8);
        }
        setCommonTitleBar(this.mGroupView.findViewById(C0965R.id.listview_layout), null);
        this.mResultListView = (XListView) this.mGroupView.findViewById(C0965R.id.lv_search_result);
        this.mViewMapLayput = this.mGroupView.findViewById(C0965R.id.view_map_layout);
        this.mListviewLayout = this.mGroupView.findViewById(C0965R.id.listview_layout);
        this.mListviewLayout.findViewById(C0965R.id.ib_left).setOnClickListener(new C39251());
        this.mGroupView.findViewById(C0965R.id.iv_back_to_resultlist).setOnClickListener(new C39262());
        this.mCityResultView = this.mGroupView.findViewById(C0965R.id.city_result_view);
        this.mCityResultView.findViewById(C0965R.id.ib_left).setOnClickListener(new C39273());
        this.mCityResultView.findViewById(C0965R.id.ib_left).setBackground(C2251b.a(mActivity));
        this.mCityResultView.setOnTouchListener(new C39284());
        this.mGroupView.findViewById(C0965R.id.iv_close_city_result).setOnClickListener(new C39295());
        addTitleBarContent(inflater);
        this.mResultListView.setAutoLoadEnable(false);
        this.mResultListView.setXListViewListener(this.mIXListViewListener);
        this.mResultListView.setPullRefreshEnable(false);
        this.mSortingRl = (RelativeLayout) this.mGroupView.findViewById(C0965R.id.sr_cover_sorting);
        this.mSortingRl.setVisibility(8);
        this.mSortingRl.setOnTouchListener(new C39306());
        this.mCloseSortingIv = (ImageView) this.mGroupView.findViewById(C0965R.id.iv_close_sorting);
        this.mSortByKey = (RelativeLayout) this.mGroupView.findViewById(C0965R.id.rl_sort_by_key);
        this.mSortByDistance = (RelativeLayout) this.mGroupView.findViewById(C0965R.id.rl_sort_by_distance);
        this.mSortByKeyIv = (ImageView) this.mGroupView.findViewById(C0965R.id.iv_sort_by_key);
        this.mSortByDistanceIv = (ImageView) this.mGroupView.findViewById(C0965R.id.iv_sort_by_distance);
        this.mCloseSortingIv.setOnClickListener(getOnClickListener());
        this.mSortByKey.setOnClickListener(getOnClickListener());
        this.mSortByDistance.setOnClickListener(getOnClickListener());
        this.mCityListview = (ListView) this.mCityResultView.findViewById(C0965R.id.city_listview);
        this.mJybBtn = (TextView) this.mGroupView.findViewById(C0965R.id.search_result_btn_jyb);
        this.mJybBtn.setBackground(C2251b.a(getActivity()));
        this.mJybBtn.setOnClickListener(new C39317());
        C1261k.a(this.myHandler);
        return this.mGroupView;
    }

    private void addTitleBarContent(LayoutInflater inflater) {
        LinearLayout rightLayout = (LinearLayout) inflater.inflate(C0965R.layout.carmode_com_title_bar_search_result_right_button, null);
        this.mMapbtn = rightLayout.findViewById(C0965R.id.tv_rightbutton_map);
        this.mMapbtn.setOnClickListener(getOnClickListener());
        rightLayout.findViewById(C0965R.id.tv_rightbutton_sort).setOnClickListener(getOnClickListener());
        setTitleBarLeftBack(inflater);
    }

    private void setTitleBarLeftBack(LayoutInflater inflater) {
        this.mBackImg = (ImageView) ((LinearLayout) inflater.inflate(C0965R.layout.carmode_com_title_bar_back, null)).findViewById(C0965R.id.img_carmode_bar_back);
        this.mBackImg.setOnClickListener(getOnClickListener());
    }

    public void updateSortView() {
        this.mSortByKeyIv.setVisibility(0);
        this.mSortByDistanceIv.setVisibility(8);
        switch (this.mSearchPoiPager.getSearchType()) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                this.mSortByKeyIv.setVisibility(0);
                this.mSortByDistanceIv.setVisibility(8);
                this.mSearchPoiPager.setSortType(1);
                return;
            case 6:
                this.mSortByKeyIv.setVisibility(8);
                this.mSortByDistanceIv.setVisibility(0);
                this.mSearchPoiPager.setSortType(2);
                return;
            default:
                return;
        }
    }

    protected void onInitView() {
        getBundle();
        this.mResultListView.setTextColor(StyleManager.getColor(C0965R.color.carmode_common_second_text));
        updateJybButtonState();
    }

    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey(ContentFragmentManager.KEY_BACK_BUNDLE)) {
            this.mBackBundle = bundle.getBundle(ContentFragmentManager.KEY_BACK_BUNDLE);
        }
        if (this.mBackBundle != null && this.mBackBundle.getInt(WebViewFragment.f4863c, 0) == 2) {
            trySearchSpaceKey(getStringUtil(C0965R.string.home_discovery_qjy_title));
            this.mBackBundle = null;
        }
    }

    public void onResume() {
        boolean z = true;
        super.onResume();
        if (this.isFromVoiceCommand && !this.isVoiceCommandResponsed) {
            this.isVoiceCommandResponsed = true;
            if (!(this.mSearchPoiPager == null || this.mSearchPoiPager.getPoiList() == null)) {
                responsePoiResultCountToVoiceCommand(this.mSearchPoiPager.getPoiList().size());
            }
        }
        BNMapController.getInstance().updateLayer(3);
        if (!this.isCityResultMode) {
            updateMapView();
        }
        BNMapController.getInstance().addObserver(this.mBNMapObserver);
        if (NavMapManager.getInstance().getNaviMapMode() != 5) {
            C0705a.a().d();
            C0705a.a().a(false, null);
            NavMapManager.getInstance().set3DGestureEnable(false);
            BNMapController instance = BNMapController.getInstance();
            if (BNStyleManager.getRealDayStyle()) {
                z = false;
            }
            instance.setNightMode(z);
        }
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
    }

    public boolean onBackPressed() {
        if (this.mSortingRl != null && this.mSortingRl.getVisibility() == 0) {
            this.mSortingRl.setVisibility(8);
        } else if (this.mCityResultView == null || this.mCityResultView.getVisibility() != 0 || this.mResultAdapter == null) {
            pageBack(this.mModuleFrom);
        } else {
            this.mCityResultView.setVisibility(8);
            this.mResultListView.setVisibility(0);
            if (isPoiComfirmPage()) {
                this.mPoiConfirmText.setVisibility(0);
            } else {
                this.mPoiConfirmText.setVisibility(8);
            }
            this.mPreSearchCityList = null;
            onInitFocusAreas();
        }
        return true;
    }

    private void getBundle() {
        boolean isOnline = false;
        if (this.mShowBundle != null) {
            this.comeFrom = this.mShowBundle.getInt(NameSearchFragment.COME_FROM);
            this.mSearchKey = this.mShowBundle.getString("search_key");
            setCommonTitleBar(this.mGroupView, null);
            if (this.mListviewLayout != null) {
                this.mListviewLayout.findViewById(C0965R.id.ib_left).setOnClickListener(new C39328());
            }
            TextView textView = new TextView(mActivity);
            textView.setGravity(17);
            textView.setSingleLine(true);
            textView.setEllipsize(TruncateAt.END);
            textView.setTextColor(StyleManager.getColor(C0965R.color.carmode_common_main_text));
            textView.setTextSize(2, 20.0f);
            textView.setText(this.mSearchKey);
            PoiSearchModel poiSearchModel = (PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH);
            if (this.mShowBundle.containsKey("district_id")) {
                this.mCurrentDistrictId = this.mShowBundle.getInt("district_id");
            }
            if (this.mShowBundle.getInt("incoming_type") == 33) {
                this.isFromCatalogSearch = true;
            } else {
                this.isFromCatalogSearch = false;
            }
            if (this.mShowBundle.getInt("incoming_type") == 5) {
                this.isFromOnekeyToOil = true;
            } else {
                this.isFromOnekeyToOil = false;
            }
            if (this.mShowBundle.getInt("incoming_type") == 35) {
                this.isFromVoiceCommand = true;
                this.isVoiceCommandResponsed = false;
                this.voiceCommandTopType = this.mShowBundle.getInt(BNVoiceCommandParams.Key_Bundle_VC_Top_Type, -1);
                this.voiceCommandSubType = this.mShowBundle.getInt(BNVoiceCommandParams.Key_Bundle_VC_Sub_Type, -1);
            } else {
                this.isFromVoiceCommand = false;
            }
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
                C1260i.e("PoiSearch", "isSetHomeComp =" + this.isSetHomeComp);
            } else {
                this.isSetHomeComp = false;
            }
            if (this.mShowBundle.containsKey("poi_data")) {
                this.mResultAdapter = new CarmodeSearchResultAdapter(getContext(), (ArrayList) this.mShowBundle.getSerializable("poi_data"), getNaviFragmentManager(), false);
                this.mResultListView.setItemsCanFocus(true);
                this.mResultListView.setPullLoadEnable(false, false);
                this.mResultListView.setAdapter(this.mResultAdapter);
                this.mResultListView.setOnItemClickListener(getOnItemClickListener());
                this.isCityResultMode = false;
                this.mShowBundle.remove("poi_data");
                return;
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
                    this.mResultAdapter = new CarmodeSearchResultAdapter(getContext(), this.mSearchPoiPager, getNaviFragmentManager(), this.isSetPointMode, this);
                    this.mResultAdapter.setShowBundle(this.mShowBundle);
                    this.mResultAdapter.setOnlineSearchListener(this.mOnlineClickListener);
                    this.mResultListView.setItemsCanFocus(true);
                    this.mResultListView.setAdapter(this.mResultAdapter);
                    this.mResultListView.setOnItemClickListener(getOnItemClickListener());
                    updateListView();
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
            this.mResultListView.setSelection(1);
        }
    }

    public boolean checkCanSearchByNetMode(int netMode) {
        if (netMode == 0 || NetworkUtils.isNetworkAvailable(getContext())) {
            return true;
        }
        TipTool.onCreateToastDialog(getContext(), (int) C0965R.string.space_search_network_unavailable);
        return false;
    }

    private OnItemClickListener getOnItemClickListener() {
        return new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                int size = 0;
                if (!(CarModeSearchResultFragment.this.mSearchPoiPager == null || CarModeSearchResultFragment.this.mSearchPoiPager.getPoiList() == null)) {
                    size = CarModeSearchResultFragment.this.mSearchPoiPager.getPoiList().size();
                }
                if (position > size) {
                    if (view.findViewById(C0965R.id.search_btn) != null && CarModeSearchResultFragment.this.mResultAdapter != null) {
                        CarModeSearchResultFragment.this.mResultAdapter.clickSearchBtn();
                    } else if (CarModeSearchResultFragment.this.mIXListViewListener != null) {
                        CarModeSearchResultFragment.this.mIXListViewListener.onLoadMore();
                    }
                } else if (position != 0) {
                    SearchPoi searchPoi = (SearchPoi) CarModeSearchResultFragment.this.mSearchPoiPager.getPoiList().get(position - 1);
                    if (searchPoi == null) {
                        return;
                    }
                    if (!CarModeSearchResultFragment.this.isSetPointMode) {
                        if (CarModeSearchResultFragment.this.comeFrom == 8) {
                            StatisticManager.onEvent(StatisticConstants.DISCOVER_QJY_0002, StatisticConstants.DISCOVER_QJY_0002);
                        }
                        PoiController.getInstance().startCalcRoute(searchPoi, CarModeSearchResultFragment.this);
                    } else if (CarModeSearchResultFragment.this.mShowBundle.getInt(BundleKey.SELECT_POINT_ACTION) == 1) {
                        FavoriteDestinationController.getInstance().addFavoriteDestFromDB(FavoriteDestinationController.getInstance().createRoutePlanNode(searchPoi), null);
                        CarModeSearchResultFragment.this.backTo(CarModeSearchResultFragment.this.mShowBundle.getInt(BundleKey.FROM_FRAGMENT), null);
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putInt(BundleKey.SELECT_POINT_ACTION, CarModeSearchResultFragment.this.mShowBundle.getInt(BundleKey.SELECT_POINT_ACTION));
                        UIModel.settingAddress(searchPoi, CarModeSearchResultFragment.this.getContext(), bundle);
                        int moudleFrom = CarModeSearchResultFragment.this.mShowBundle.getInt(ContentFragmentManager.MODULE_FROM);
                        if (moudleFrom == 1 || moudleFrom == 4 || moudleFrom == 2) {
                            BaseFragment.getNaviActivity().onBackPressed();
                        } else {
                            CarModeSearchResultFragment.this.backTo(CarModeSearchResultFragment.this.mShowBundle.getInt(BundleKey.FROM_FRAGMENT), null);
                        }
                    }
                }
            }
        };
    }

    private OnClickListener getOnClickListener() {
        return new OnClickListener() {
            public void onClick(View v) {
                int id = v.getId();
                if (id == C0965R.id.left_imageview) {
                    if (CarModeSearchResultFragment.this.isFromCatalogSearch) {
                        CarModeSearchResultFragment.this.back(null);
                        return;
                    }
                    CarModeSearchResultFragment.this.back(null);
                    CarModeSearchResultFragment.this.back(null);
                } else if (id == C0965R.id.right_imageview) {
                    CarModeSearchResultFragment.this.mSortingRl.setVisibility(0);
                    C2178i.a(CarModeSearchResultFragment.this.mCloseSortingIv).a();
                } else if (id == C0965R.id.iv_close_sorting) {
                    CarModeSearchResultFragment.this.mSortingRl.setVisibility(8);
                } else if (id == C0965R.id.rl_sort_by_key) {
                    CarModeSearchResultFragment.this.mSearchPoiPager.setSortType(1);
                    CarModeSearchResultFragment.this.mSortingRl.setVisibility(8);
                    CarModeSearchResultFragment.this.sortListByRule();
                    CarModeSearchResultFragment.this.mSortByKeyIv.setVisibility(0);
                    CarModeSearchResultFragment.this.mSortByDistanceIv.setVisibility(8);
                    PoiController.getInstance().updatePoiBkgLayer(CarModeSearchResultFragment.this.mSearchPoiPager.getPoiList());
                } else if (id == C0965R.id.rl_sort_by_distance) {
                    GeoPoint center = BNLocationManagerProxy.getInstance().getLastValidLocation();
                    if (center == null || !center.isValid()) {
                        TipTool.onCreateToastDialog(CarModeSearchResultFragment.this.getContext(), (int) C0965R.string.carmode_searchresult_sort_fail);
                        return;
                    }
                    CarModeSearchResultFragment.this.mSearchPoiPager.setSortType(2);
                    CarModeSearchResultFragment.this.mSortingRl.setVisibility(8);
                    CarModeSearchResultFragment.this.sortListByRule();
                    CarModeSearchResultFragment.this.mSortByKeyIv.setVisibility(8);
                    CarModeSearchResultFragment.this.mSortByDistanceIv.setVisibility(0);
                    PoiController.getInstance().updatePoiBkgLayer(CarModeSearchResultFragment.this.mSearchPoiPager.getPoiList());
                } else if (id == C0965R.id.right_content) {
                } else {
                    if (id == C0965R.id.tv_rightbutton_map) {
                        if (CarModeSearchResultFragment.this.isSetHomeComp) {
                            CarModeSearchResultFragment.this.viewMap();
                        } else if (CarModeSearchResultFragment.this.mResultAdapter != null) {
                            CarModeSearchResultFragment.this.mResultAdapter.interPoidetail();
                        }
                    } else if (id == C0965R.id.tv_rightbutton_sort) {
                        CarModeSearchResultFragment.this.mSortingRl.setVisibility(0);
                    } else if (id == C0965R.id.img_carmode_bar_back) {
                        CarModeSearchResultFragment.this.pageBack(CarModeSearchResultFragment.this.mModuleFrom);
                    } else if (id == C0965R.id.ib_left) {
                        CarModeSearchResultFragment.this.onBackPressed();
                    }
                }
            }
        };
    }

    protected void sortListByRule() {
        this.mResultAdapter.setSearchPager(this.mSearchPoiPager);
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

    private void responsePoiResultCountToVoiceCommand(int count) {
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
        C1260i.b("PoiSearch", "CarModeSearchResult onVoiceCommand: " + strCommand);
        return false;
    }

    public boolean onVoiceCommand(int selectIndex) {
        C1260i.b("PoiSearch", "CarModeSearchResult onVoiceCommand: " + selectIndex);
        if (selectIndex < 0 || this.mResultListView == null) {
            return false;
        }
        OnItemClickListener itemClickListener = this.mResultListView.getOnItemClickListener();
        if (itemClickListener == null) {
            return false;
        }
        itemClickListener.onItemClick(this.mResultListView, this.mGroupView, selectIndex + 1, 0);
        return true;
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

    private void updateMapView() {
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
        this.mResultListView.setVisibility(8);
        this.mCityResultView.setVisibility(0);
        this.mPoiConfirmText.setVisibility(8);
        initFocusChain(this.mGroupView);
        ListView listView = (ListView) this.mCityResultView.findViewById(C0965R.id.city_listview);
        ArrayAdapter<String> adapter = new ArrayAdapter(mActivity, C0965R.layout.car_mode_city_result, C0965R.id.city_tv);
        for (i = 0; i < list.size(); i++) {
            SearchPoi temPoi = (SearchPoi) list.get(i);
            if (isOnline) {
                adapter.add(temPoi.mName + "(" + (temPoi.mWeight == 0 ? 1 : temPoi.mWeight) + ")");
            } else {
                adapter.add(temPoi.mName);
            }
        }
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                DistrictInfo districtInfo;
                CarModeSearchResultFragment.this.mCityResultView.setVisibility(8);
                CarModeSearchResultFragment.this.mResultListView.setVisibility(0);
                if (CarModeSearchResultFragment.this.isPoiComfirmPage()) {
                    CarModeSearchResultFragment.this.mPoiConfirmText.setVisibility(0);
                } else {
                    CarModeSearchResultFragment.this.mPoiConfirmText.setVisibility(8);
                }
                CarModeSearchResultFragment.this.initFocusChain(CarModeSearchResultFragment.this.mGroupView);
                SearchPoi searchPoi = (SearchPoi) list.get(position);
                if ((searchPoi.mDistrictId & -65536) <= 0 || (searchPoi.mDistrictId & 65535) != 0) {
                    districtInfo = BNPoiSearcher.getInstance().getDistrictById(searchPoi.mDistrictId);
                } else {
                    districtInfo = BNPoiSearcher.getInstance().getDistrictById(searchPoi.mDistrictId >> 16);
                }
                SearchPoiPager searchPoiPager = new SearchPoiPager(CarModeSearchResultFragment.this.mSearchPoiPager.getSearchKey(), districtInfo, 10, CarModeSearchResultFragment.this.mSearchPoiPager.getNetMode());
                C1307e.a().a(CarModeSearchResultFragment.this.getResources().getString(C0965R.string.progress_searching), CarModeSearchResultFragment.this.mSearchDialogCancelListener);
                ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchPoiPagerList().clear();
                BNPoiSearcher.getInstance().setNetMode(searchPoiPager.getNetMode());
                BNPoiSearcher.getInstance().asynSearchWithPager(searchPoiPager, CarModeSearchResultFragment.this.mHandler);
                CarModeSearchResultFragment.this.mPreSearchCityList = list;
            }
        });
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

    private void viewMap() {
        this.mListviewLayout.setVisibility(8);
        this.mViewMapLayput.setVisibility(0);
        this.mViewMapLayput.requestFocus();
    }

    private void backFromMap() {
        if (isPoiComfirmPage()) {
            this.mPoiConfirmText.setVisibility(0);
        } else {
            this.mPoiConfirmText.setVisibility(8);
        }
        this.mListviewLayout.setVisibility(0);
        this.mViewMapLayput.setVisibility(8);
        this.mViewMapLayput.requestFocus();
    }

    public void onInitFocusAreas() {
        initFocusChain(this.mGroupView);
    }

    public void initFocusChain(View root) {
        if (getCurrentFragmentType() == 35) {
            if (this.mFocusAreaUp == null) {
                this.mFocusAreaUp = new C1443g(root.findViewById(C0965R.id.title_bar1), 2);
                this.mFocusAreaUp.d(root.findViewById(C0965R.id.title_bar1).findViewById(C0965R.id.ib_left));
            }
            if (this.mFocusAreaUpCityResult == null) {
                this.mFocusAreaUpCityResult = new C1443g(root.findViewById(C0965R.id.title_bar2), 2);
                this.mFocusAreaUpCityResult.d(root.findViewById(C0965R.id.title_bar2).findViewById(C0965R.id.ib_left));
            }
            if (this.mFocusList == null) {
                this.mFocusList = new C1438c(this.mResultListView, 6);
                this.mFocusList.a(this.mOnKeyListener);
            }
            if (this.mResultListView != null && this.mResultListView.getSelectedItemPosition() == 0) {
                this.mResultListView.setSelection(1);
            }
            if (this.mFocusListCityResult == null) {
                this.mFocusListCityResult = new C1438c(this.mCityListview, 6);
            }
            if (this.mCityResultView.getVisibility() != 0) {
                C1440d.a().b(new C1436a[]{this.mFocusAreaUp, this.mFocusList});
                C1440d.a().h(this.mFocusList);
                return;
            }
            C1440d.a().b(new C1436a[]{this.mFocusAreaUpCityResult, this.mFocusListCityResult});
            C1440d.a().h(this.mFocusListCityResult);
        }
    }

    private boolean isPoiComfirmPage() {
        int action = this.mShowBundle.getInt(BundleKey.SELECT_POINT_ACTION);
        if (action == 1 || action == 5 || action == 4) {
            return true;
        }
        return false;
    }

    public void driving() {
        C1260i.b("yftech", "CarModeSearchResultFragment driving = " + this.mModuleFrom);
        dismissSearchNetworkingDialog();
        if (!C1343b.a().b()) {
            backTo(17, null);
        } else if (this.comeFrom == 8) {
            pageBack(this.mModuleFrom);
        } else {
            backTo(17, null);
        }
        C1342a.a().d();
    }

    public void stopDriving() {
    }

    public void onDestroy() {
        C1261k.b(this.myHandler);
        super.onDestroy();
    }

    private boolean isJybEnable() {
        if (this.comeFrom == 8 && C1435a.a().h() && !C1765g.a().c()) {
            return true;
        }
        return false;
    }

    private void updateJybButtonState() {
        if (this.mJybBtn != null) {
            if (isJybEnable()) {
                this.mJybBtn.setVisibility(0);
                if (C1663a.a().N()) {
                    this.mJybBtn.setVisibility(8);
                    return;
                }
                return;
            }
            this.mJybBtn.setVisibility(8);
        }
    }

    private void trySearchSpaceId(int searchId) {
        this.mDistrictInfo = GeoLocateModel.getInstance().getDistrictByManMade();
        if (this.mDistrictInfo == null) {
            this.mDistrictInfo = GeoLocateModel.getInstance().getCurrentDistrict();
        }
        this.mCurrentGeoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
        if (BNLocationManagerProxy.getInstance().isLocationValid()) {
            this.netMode = SearchStrategyHelper.getInstance(mActivity).getNetModeByPoint(this.mCurrentGeoPoint);
            this.netMode = NameSearchHelper.getInstance().getFinalNetMode(this.netMode);
            searchSpace(searchId);
            return;
        }
        TipTool.onCreateToastDialog(mActivity, (int) C0965R.string.space_search_center_error);
    }

    private void trySearchSpaceKey(String searchKey) {
        this.mDistrictInfo = GeoLocateModel.getInstance().getDistrictByManMade();
        if (this.mDistrictInfo == null) {
            this.mDistrictInfo = GeoLocateModel.getInstance().getCurrentDistrict();
        }
        this.mCurrentGeoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
        if (BNLocationManagerProxy.getInstance().isLocationValid()) {
            this.netMode = SearchStrategyHelper.getInstance(mActivity).getNetModeByPoint(this.mCurrentGeoPoint);
            this.netMode = NameSearchHelper.getInstance().getFinalNetMode(this.netMode);
            searchSpace(searchKey);
            return;
        }
        TipTool.onCreateToastDialog(mActivity, (int) C0965R.string.space_search_center_error);
    }

    private void searchSpace(int id) {
        SearchCircle cricle = new SearchCircle(this.mCurrentGeoPoint, 5000);
        if (SearchStrategyHelper.getInstance(mActivity).checkCanSearchByNetMode(this.netMode)) {
            SearchPoiPager searchPoiPager = new SearchPoiPager(id, this.mDistrictInfo, cricle, 10, this.netMode);
            C1307e.a().a(getResources().getString(C0965R.string.progress_searching), this.mSearchDialogCancelListener);
            BNPoiSearcher.getInstance().asynSearchWithPager(searchPoiPager, this.mHandler);
        }
    }

    private void searchSpace(String searchKey) {
        SearchCircle circle = new SearchCircle(this.mCurrentGeoPoint, 5000);
        if (SearchStrategyHelper.getInstance(mActivity).checkCanSearchByNetMode(this.netMode)) {
            SearchPoiPager searchPoiPager = new SearchPoiPager(searchKey, this.mDistrictInfo, circle, 10, this.netMode);
            C1307e.a().a(getResources().getString(C0965R.string.progress_searching), this.mSearchDialogCancelListener);
            ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchPoiPagerList().clear();
            BNPoiSearcher.getInstance().setNetMode(searchPoiPager.getNetMode());
            BNPoiSearcher.getInstance().asynSearchWithPager(searchPoiPager, this.mHandler);
        }
    }
}
