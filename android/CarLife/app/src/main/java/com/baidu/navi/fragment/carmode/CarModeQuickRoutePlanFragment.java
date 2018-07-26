package com.baidu.navi.fragment.carmode;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.baidu.baidumaps.p042f.p043a.p044a.C0705a;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.baidunavis.control.NavPoiController;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C0936j;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.p069b.C1190a;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.presentation.p071a.C1307e;
import com.baidu.carlife.custom.C1342a;
import com.baidu.carlife.logic.C1765g;
import com.baidu.carlife.logic.voice.C1912n;
import com.baidu.carlife.p078f.C1436a;
import com.baidu.carlife.p078f.C1438c;
import com.baidu.carlife.p078f.C1440d;
import com.baidu.carlife.p078f.C1443g;
import com.baidu.carlife.view.C2252a;
import com.baidu.carlife.view.C2252a.C2245a;
import com.baidu.carlife.view.C2252a.C2248c;
import com.baidu.carlife.view.C2252a.C2249d;
import com.baidu.carlife.view.KeyboardEditText;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.carlife.view.dialog.C2283g;
import com.baidu.carlife.view.p104a.C2251b;
import com.baidu.navi.FavoritePoiManager;
import com.baidu.navi.FavoritePoiManager.FavCallBack;
import com.baidu.navi.FavoritePoiManager.FavorItem;
import com.baidu.navi.adapter.NameSearchAdapter;
import com.baidu.navi.adapter.NameSearchAdapter.NameSearchEntity;
import com.baidu.navi.adapter.NameSearchAdapter.NameSearchEntity.Type;
import com.baidu.navi.cache.RouteInfoCache;
import com.baidu.navi.controller.FavoriteDestinationController;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.controller.QuickRoutePlanController;
import com.baidu.navi.controller.SearchStrategyHelper;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.ContentFragmentManager;
import com.baidu.navi.logic.model.UIModel;
import com.baidu.navi.protocol.model.SearchByTypeDataStruct;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams.BundleKey;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandParams;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.SearchCircle;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.model.datastruct.SearchSugData;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener.ActionTypeSearchParams;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.db.model.SearchNameHistroyModel;
import com.baidu.navisdk.util.db.object.SearchNameDBObject;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

public class CarModeQuickRoutePlanFragment extends ContentFragment implements OnClickListener, C2248c {
    public static final String INCOMING_TYPE = "incoming_type";
    private static final int K_TIMEOUT_SUG = 3000;
    private static final int OVER_TIME_LONG = 30000;
    private static final int OVER_TIME_SHORT = 5000;
    private static final String TAG = "CarModeQuickRoutePlanFragment";
    private boolean canSugShow = false;
    private int cityId = 0;
    private View companyView;
    private View favoriteView;
    private boolean hasData = false;
    private View homeView;
    private boolean isFromVoice = false;
    private boolean isPoiSearchMod = false;
    private boolean isSearchEnable = false;
    private boolean isShowHeader = false;
    private boolean isSpaceSearchMode = false;
    private C1953c mAlertDlg;
    private ImageButton mBackBtn;
    private GeoPoint mCurrentGeoPoint;
    private SearchPoi mCurrentPoi;
    private NameSearchAdapter mDataAdapter;
    private List<NameSearchEntity> mDataList;
    private DistrictInfo mDistrictInfo;
    private boolean mEdViewHasFocus = false;
    private View mEditLine;
    private LinearLayout mEditTextContentLayout;
    private C1443g mFocusAreaTop;
    private C1443g mFocusAreaUp;
    private C1443g mFocusDownArea;
    private C1438c mFocusList;
    private View mFooterView;
    private C0936j mHandler = new C39229();
    private View mHeaderView;
    private ListView mListView;
    private QuickRoutePlanController mQuickRoutePlanController;
    private ImageButton mRightImageButton;
    private C0672b mSearchDialogCancelListener = new C39164();
    private KeyboardEditText mSearchEditText;
    private String mSearchKey = "";
    private ArrayList<SearchSugData> mSugDataList;
    private Handler mUIHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1003:
                    if (msg.arg1 == 0) {
                        SearchPoi poi = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getAntiGeoPoi();
                        if (CarModeQuickRoutePlanFragment.this.mShowBundle.getInt(BundleKey.SELECT_POINT_ACTION) == 1) {
                            FavoriteDestinationController.getInstance().addFavoriteDestFromDB(new RoutePlanNode(poi.mGuidePoint, poi.mViewPoint, 8, poi.mName, poi.mAddress, poi.mOriginUID), null);
                        } else {
                            Bundle bundle = new Bundle();
                            bundle.putInt(BundleKey.SELECT_POINT_ACTION, CarModeQuickRoutePlanFragment.this.mShowBundle.getInt(BundleKey.SELECT_POINT_ACTION));
                            UIModel.settingAddress(poi, C1157a.a(), bundle);
                        }
                        CarModeQuickRoutePlanFragment.this.backTo(CarModeQuickRoutePlanFragment.this.mShowBundle.getInt(BundleKey.FROM_FRAGMENT), null);
                        if (CarModeQuickRoutePlanFragment.this.newBundle != null) {
                            CarModeQuickRoutePlanFragment.this.newBundle = null;
                            CarModeQuickRoutePlanFragment.this.mShowBundle = CarModeQuickRoutePlanFragment.this.oldBundle;
                            CarModeQuickRoutePlanFragment.this.updateHeadView();
                            CarModeQuickRoutePlanFragment.this.searchHeadItemView.setVisibility(0);
                            CarModeQuickRoutePlanFragment.this.getBundle();
                            CarModeQuickRoutePlanFragment.this.updateListView();
                            return;
                        }
                        return;
                    }
                    TipTool.onCreateToastDialog(C1157a.a(), (int) C0965R.string.locate_failed);
                    return;
                default:
                    return;
            }
        }
    };
    private ViewGroup mViewGroup;
    private int netMode = 3;
    private Bundle newBundle;
    private Bundle oldBundle;
    private RoutePlanNode oldNode;
    private int overTime = 0;
    private View searchHeadItemView;
    private View searchNearView;
    private int sugNetMode = 3;
    private TextView tvCompanySetting;
    private TextView tvHomeSetting;

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeQuickRoutePlanFragment$1 */
    class C39111 implements OnFocusChangeListener {
        C39111() {
        }

        public void onFocusChange(View v, boolean hasFocus) {
            boolean iskeyboardShow = C2252a.a().b();
            if (hasFocus && iskeyboardShow) {
                C2252a.a().d();
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeQuickRoutePlanFragment$2 */
    class C39122 implements Runnable {
        C39122() {
        }

        public void run() {
            if (BaseFragment.getNaviActivity() != null && BaseFragment.getNaviActivity().u() != null) {
                BaseFragment.getNaviActivity().u().a();
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeQuickRoutePlanFragment$3 */
    class C39153 implements OnItemClickListener {

        /* renamed from: com.baidu.navi.fragment.carmode.CarModeQuickRoutePlanFragment$3$1 */
        class C39131 implements C0672b {
            C39131() {
            }

            public void onClick() {
                SearchNameHistroyModel.getInstance().clear();
                CarModeQuickRoutePlanFragment.this.updateListView();
            }
        }

        /* renamed from: com.baidu.navi.fragment.carmode.CarModeQuickRoutePlanFragment$3$2 */
        class C39142 implements C0672b {
            C39142() {
            }

            public void onClick() {
                CarModeQuickRoutePlanFragment.this.dismissTwoBtnDialog();
            }
        }

        C39153() {
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            int headerViewsCount = CarModeQuickRoutePlanFragment.this.mListView.getHeaderViewsCount();
            if (headerViewsCount == 1 && position == 0) {
                CarModeQuickRoutePlanFragment.this.setPointSelectNode();
                return;
            }
            position -= headerViewsCount;
            if (CarModeQuickRoutePlanFragment.this.mListView.getFooterViewsCount() == 1 && position == CarModeQuickRoutePlanFragment.this.mDataAdapter.getCount()) {
                CarModeQuickRoutePlanFragment.this.showTwoBtnDialog(C0965R.string.search_alert_clear_history_all, new C39131(), new C39142());
                return;
            }
            NameSearchEntity item = CarModeQuickRoutePlanFragment.this.mDataAdapter.getItem(position);
            if (item == null) {
                return;
            }
            if ((item.getType() == Type.HOME || item.getType() == Type.COMPANY) && item.getNode() != null) {
                CarModeQuickRoutePlanFragment.this.mQuickRoutePlanController.startRoutePlan(item.getNode());
                return;
            }
            String key = item.getName();
            String address = CarModeQuickRoutePlanFragment.this.mDataAdapter.getItem(position).getAddress();
            if (!TextUtils.isEmpty(address)) {
                key = key + " " + address;
            }
            if (CarModeQuickRoutePlanFragment.this.isSpaceSearchMode) {
                CarModeQuickRoutePlanFragment.this.trySearchSpace(key);
            } else {
                CarModeQuickRoutePlanFragment.this.trySearch(key);
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeQuickRoutePlanFragment$4 */
    class C39164 implements C0672b {
        C39164() {
        }

        public void onClick() {
            BNPoiSearcher.getInstance().cancelQuery();
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeQuickRoutePlanFragment$5 */
    class C39175 implements OnScrollListener {
        C39175() {
        }

        public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        }

        public void onScrollStateChanged(AbsListView view, int scrollState) {
            CarModeQuickRoutePlanFragment.this.hideSoftInputMethod();
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeQuickRoutePlanFragment$6 */
    class C39186 implements OnEditorActionListener {
        C39186() {
        }

        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == 3) {
                CarModeQuickRoutePlanFragment.this.onClickFinish();
            }
            return false;
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeQuickRoutePlanFragment$7 */
    class C39197 implements C2249d {
        C39197() {
        }

        public void onFocusChange(View v, boolean hasFocus) {
            if (hasFocus) {
                CarModeQuickRoutePlanFragment.this.mEditLine.setBackgroundColor(CarModeQuickRoutePlanFragment.this.getResources().getColor(C0965R.color.cl_other_c));
            } else {
                CarModeQuickRoutePlanFragment.this.mEditLine.setBackgroundColor(CarModeQuickRoutePlanFragment.this.getResources().getColor(C0965R.color.cl_line_a5));
                CarModeQuickRoutePlanFragment.this.hideSoftInputMethod();
            }
            CarModeQuickRoutePlanFragment.this.mEdViewHasFocus = hasFocus;
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeQuickRoutePlanFragment$8 */
    class C39218 implements TextWatcher {

        /* renamed from: com.baidu.navi.fragment.carmode.CarModeQuickRoutePlanFragment$8$1 */
        class C39201 implements FavCallBack {
            C39201() {
            }

            public void callUpdate() {
                CarModeQuickRoutePlanFragment.this.updateListView();
            }
        }

        C39218() {
        }

        public void afterTextChanged(Editable s) {
            CarModeQuickRoutePlanFragment.this.mSearchKey = CarModeQuickRoutePlanFragment.this.mSearchEditText.getText().toString().trim();
            if (StringUtils.isEmpty(CarModeQuickRoutePlanFragment.this.mSearchKey)) {
                CarModeQuickRoutePlanFragment.this.mRightImageButton.setTag("");
                CarModeQuickRoutePlanFragment.this.mRightImageButton.setVisibility(8);
                if (CarModeQuickRoutePlanFragment.this.isSearchEnable) {
                    CarModeQuickRoutePlanFragment.this.isSearchEnable = false;
                    CarModeQuickRoutePlanFragment.this.canSugShow = false;
                }
            } else {
                CarModeQuickRoutePlanFragment.this.mRightImageButton.setImageResource(C0965R.drawable.com_ic_input_delete);
                CarModeQuickRoutePlanFragment.this.mRightImageButton.setTag("delete");
                CarModeQuickRoutePlanFragment.this.mRightImageButton.setVisibility(0);
                if (!CarModeQuickRoutePlanFragment.this.isSearchEnable) {
                    CarModeQuickRoutePlanFragment.this.isSearchEnable = true;
                }
                FavoritePoiManager.getInstance().startGetTask(CarModeQuickRoutePlanFragment.this.mSearchKey, new C39201());
                BNPoiSearcher.getInstance().asynGetInputSug(CarModeQuickRoutePlanFragment.this.mSearchKey, CarModeQuickRoutePlanFragment.this.sugNetMode, 3000, CarModeQuickRoutePlanFragment.this.mHandler);
                C1260i.e(CarModeQuickRoutePlanFragment.TAG, "asynGetInputSug key = " + CarModeQuickRoutePlanFragment.this.mSearchKey);
            }
            CarModeQuickRoutePlanFragment.this.updateListView();
        }

        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    }

    /* renamed from: com.baidu.navi.fragment.carmode.CarModeQuickRoutePlanFragment$9 */
    class C39229 extends C0936j {
        C39229() {
        }

        public void careAbout() {
            addMsg(1002);
            addMsg(C1253f.hJ);
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1002) {
                CarModeQuickRoutePlanFragment.this.reAddEditTextView();
            } else if (CarModeQuickRoutePlanFragment.this.canProcessUI()) {
                RspData rsp = msg.obj;
                if (msg.what == 1005) {
                    C1307e.a().c();
                    SearchPoiPager searchPoiPager = rsp.mData;
                    if (searchPoiPager != null) {
                        searchPoiPager.setNetMode(BNPoiSearcher.getInstance().getNetModeOfLastResult());
                        switch (searchPoiPager.getSearchType()) {
                            case 1:
                                if (msg.arg1 != 0) {
                                    C1260i.e(CarModeQuickRoutePlanFragment.TAG, "Name Search fail");
                                    TipTool.onCreateToastDialog(CarModeQuickRoutePlanFragment.this.getContext(), (int) C0965R.string.search_result_toast_failed);
                                    break;
                                }
                                CarModeQuickRoutePlanFragment.this.handleNameSearchSuc(searchPoiPager);
                                break;
                            case 3:
                                if (msg.arg1 != 0) {
                                    C1260i.e(CarModeQuickRoutePlanFragment.TAG, "Space Search fail");
                                    TipTool.onCreateToastDialog(CarModeQuickRoutePlanFragment.this.getContext(), (int) C0965R.string.search_result_toast_failed);
                                    break;
                                }
                                C1260i.e(CarModeQuickRoutePlanFragment.TAG, "onSearchCatalogSucc()");
                                CarModeQuickRoutePlanFragment.this.handleSpaceKeySearchSuc(searchPoiPager);
                                return;
                            case 5:
                                if (msg.arg1 != 0) {
                                    C1260i.e(CarModeQuickRoutePlanFragment.TAG, "Space Search fail");
                                    TipTool.onCreateToastDialog(CarModeQuickRoutePlanFragment.this.getContext(), (int) C0965R.string.search_space_result_failed);
                                    break;
                                }
                                C1260i.e(CarModeQuickRoutePlanFragment.TAG, "onSearchCatalogSucc()");
                                CarModeQuickRoutePlanFragment.this.handleSpaceCatalogSearchSuc(searchPoiPager);
                                break;
                        }
                        if (CarModeQuickRoutePlanFragment.this.isFromVoice && msg.arg1 != 0) {
                            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
                        }
                    } else if (CarModeQuickRoutePlanFragment.this.netMode == 1 && CarModeQuickRoutePlanFragment.this.hasData) {
                        CarModeQuickRoutePlanFragment.this.handleTimeout((SearchPoiPager) rsp.mReq.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_PAGER));
                        CarModeQuickRoutePlanFragment.this.hasData = false;
                    } else {
                        C1260i.e(CarModeQuickRoutePlanFragment.TAG, "search with pager fail");
                        if (CarModeQuickRoutePlanFragment.this.isFromVoice) {
                            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
                        }
                        TipTool.onCreateToastDialog(CarModeQuickRoutePlanFragment.this.getContext(), (int) C0965R.string.search_result_toast_failed);
                    }
                } else if (msg.what != 1004) {
                } else {
                    if (msg.arg1 == 0) {
                        C1260i.e(CarModeQuickRoutePlanFragment.TAG, "Sug sucess!!!");
                        CarModeQuickRoutePlanFragment.this.canSugShow = true;
                        CarModeQuickRoutePlanFragment.this.updateListView();
                    } else if (msg.arg1 != -2) {
                        C1260i.e(CarModeQuickRoutePlanFragment.TAG, "Sug fail!!!");
                    }
                }
            }
        }
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mQuickRoutePlanController = new QuickRoutePlanController(mActivity, null, getNaviFragmentManager(), this);
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mViewGroup = (ViewGroup) inflater.inflate(C0965R.layout.carmode_frag_quick_route_plan, null);
        this.mEditTextContentLayout = (LinearLayout) this.mViewGroup.findViewById(C0965R.id.edittext_content_layout);
        this.mBackBtn = (ImageButton) this.mViewGroup.findViewById(C0965R.id.carmode_frag_quick_route_plan_back);
        this.mBackBtn.setOnClickListener(this);
        this.searchHeadItemView = this.mViewGroup.findViewById(C0965R.id.view_sug_grid_item);
        this.homeView = this.mViewGroup.findViewById(C0965R.id.ll_go_home);
        this.companyView = this.mViewGroup.findViewById(C0965R.id.ll_go_company);
        this.favoriteView = this.mViewGroup.findViewById(C0965R.id.ll_favorite);
        this.searchNearView = this.mViewGroup.findViewById(C0965R.id.ll_search_near);
        this.tvHomeSetting = (TextView) this.mViewGroup.findViewById(C0965R.id.tv_home_setting);
        this.tvCompanySetting = (TextView) this.mViewGroup.findViewById(C0965R.id.tv_company_setting);
        this.homeView.setOnClickListener(this);
        this.companyView.setOnClickListener(this);
        this.favoriteView.setOnClickListener(this);
        this.searchNearView.setOnClickListener(this);
        this.mSearchEditText = (KeyboardEditText) this.mViewGroup.findViewById(C0965R.id.carmode_frag_quick_route_plan_edit);
        this.mSearchEditText.addTextChangedListener(getTextChangedListener());
        this.mSearchEditText.setOnEditorActionListener(getOnEditorActionListener());
        KeyboardEditText keyboardEditText = this.mSearchEditText;
        C2252a a = C2252a.a();
        a.getClass();
        keyboardEditText.setOnTouchListener(new C2245a(a, this.mSearchEditText, 3, this, getFocusChangeListener()));
        this.mEditLine = this.mViewGroup.findViewById(C0965R.id.carmode_frag_quick_route_plan_edit_line);
        this.mRightImageButton = (ImageButton) this.mViewGroup.findViewById(C0965R.id.carmode_frag_quick_route_plan_right);
        this.mRightImageButton.setTag("");
        this.mRightImageButton.setOnClickListener(this);
        this.mListView = (ListView) this.mViewGroup.findViewById(C0965R.id.carmode_frag_quick_route_plan_listview);
        this.mListView.setOnItemClickListener(getOnItemClickListener());
        this.mListView.setOnScrollListener(getOnScrollListener());
        this.mHeaderView = inflater.inflate(C0965R.layout.carmode_name_search_header, this.mListView, false);
        this.mFooterView = inflater.inflate(C0965R.layout.carmode_name_search_footer, this.mListView, false);
        this.mDataList = new ArrayList();
        this.mSugDataList = new ArrayList();
        C1261k.a(this.mHandler);
        this.mListView.setOnFocusChangeListener(new C39111());
        if (!PreferenceHelper.getInstance(BaseFragment.getNaviActivity()).getBoolean(C1253f.jH, false)) {
            BaseFragment.getNaviActivity().u().a(getStringUtil(C0965R.string.home_search_tip));
            PreferenceHelper.getInstance(BaseFragment.getNaviActivity()).putBoolean(C1253f.jH, true);
            this.mHandler.postDelayed(new C39122(), 8000);
        }
        return this.mViewGroup;
    }

    public void reAddEditTextView() {
        if (C1190a.a() && this.mEditTextContentLayout != null && this.mSearchEditText != null && this.mSearchKey != null) {
            View view = LayoutInflater.from(mActivity).inflate(C0965R.layout.quick_route_plan_edit_text_view, null);
            LayoutParams lp = new LayoutParams(-1, ScreenUtil.getInstance().dip2px(48));
            this.mEditTextContentLayout.removeAllViews();
            this.mEditTextContentLayout.addView(view, lp);
            if (this.mSearchEditText != null) {
                this.mSearchEditText.setEnabled(false);
                this.mSearchEditText = (KeyboardEditText) view.findViewById(C0965R.id.carmode_frag_quick_route_plan_edit);
                this.mSearchEditText.setEnabled(true);
                this.mSearchEditText.addTextChangedListener(getTextChangedListener());
                this.mSearchEditText.setOnEditorActionListener(getOnEditorActionListener());
                KeyboardEditText keyboardEditText = this.mSearchEditText;
                C2252a a = C2252a.a();
                a.getClass();
                keyboardEditText.setOnTouchListener(new C2245a(a, this.mSearchEditText, 3, this, getFocusChangeListener()));
                try {
                    if (!this.mSearchKey.isEmpty()) {
                        this.mSearchEditText.getEditableText().append(this.mSearchKey);
                    }
                } catch (Exception e) {
                }
                C2252a.a().a(this.mSearchEditText);
                this.mFocusAreaTop = null;
            }
        }
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case C0965R.id.carmode_frag_quick_route_plan_back:
                if (this.newBundle != null) {
                    this.newBundle = null;
                    this.mShowBundle = this.oldBundle;
                    updateHeadView();
                    this.searchHeadItemView.setVisibility(0);
                    getBundle();
                    updateListView();
                    return;
                }
                pageBack(this.mModuleFrom);
                return;
            case C0965R.id.carmode_frag_quick_route_plan_right:
                if (TextUtils.equals((String) view.getTag(), "delete")) {
                    this.mSearchEditText.setText("");
                    return;
                }
                return;
            case C0965R.id.ll_go_home:
                this.oldNode = getHomeAddress();
                if (this.oldNode != null) {
                    this.mQuickRoutePlanController.startRoutePlan(this.oldNode);
                    return;
                }
                this.mShowBundle = new Bundle();
                this.mShowBundle.putInt(BundleKey.FROM_FRAGMENT, 49);
                this.mShowBundle.putInt(BundleKey.SELECT_POINT_ACTION, 4);
                this.newBundle = this.mShowBundle;
                getBundle();
                updateListView();
                return;
            case C0965R.id.ll_go_company:
                this.oldNode = getCompanyAddress();
                if (this.oldNode != null) {
                    this.mQuickRoutePlanController.startRoutePlan(this.oldNode);
                    return;
                }
                this.mShowBundle = new Bundle();
                this.mShowBundle.putInt(BundleKey.FROM_FRAGMENT, 49);
                this.mShowBundle.putInt(BundleKey.SELECT_POINT_ACTION, 5);
                this.newBundle = this.mShowBundle;
                getBundle();
                updateListView();
                return;
            case C0965R.id.ll_favorite:
                showFragment(306, null);
                return;
            case C0965R.id.ll_search_near:
                showFragment(34, null);
                return;
            default:
                return;
        }
    }

    public void onInitFocusAreas() {
        super.onInitFocusAreas();
        initFocusChain(this.mViewGroup);
    }

    public boolean onBackPressed() {
        if (this.newBundle != null) {
            this.newBundle = null;
            this.mShowBundle = this.oldBundle;
            updateHeadView();
            this.searchHeadItemView.setVisibility(0);
            getBundle();
            updateListView();
        } else {
            pageBack(this.mModuleFrom);
        }
        return true;
    }

    private void getBundle() {
        this.isShowHeader = false;
        if (this.mShowBundle != null && this.mShowBundle.containsKey(BundleKey.FROM_FRAGMENT) && (this.mShowBundle.getInt(BundleKey.FROM_FRAGMENT) == 304 || this.mShowBundle.getInt(BundleKey.FROM_FRAGMENT) == 49)) {
            this.isShowHeader = true;
        }
        if (this.isShowHeader) {
            this.mListView.setAdapter(null);
            this.mListView.addHeaderView(this.mHeaderView);
            this.mListView.setAdapter(this.mDataAdapter);
        }
    }

    private OnItemClickListener getOnItemClickListener() {
        return new C39153();
    }

    private void trySearch(String key) {
        if (ActionTypeSearchParams.Gas_Station.equals(key)) {
            trySearchSpace((int) SearchByTypeDataStruct.TYPE_GAS);
        } else if (ActionTypeSearchParams.Toilet.equals(key) || "洗手间".equals(key)) {
            trySearchSpace((int) SearchByTypeDataStruct.TYPE_WC);
        } else if (ActionTypeSearchParams.Park.equals(key)) {
            trySearchSpace((int) SearchByTypeDataStruct.TYPE_PARK);
        } else if ("ATM".equals(key.toUpperCase()) || ActionTypeSearchParams.Bank.equals(key)) {
            trySearchSpace((int) SearchByTypeDataStruct.TYPE_BANK);
        } else {
            this.mCurrentGeoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
            NavPoiController.getInstance().setMyPositionGeo(this.mCurrentGeoPoint);
            this.netMode = SearchStrategyHelper.getInstance(getContext()).getNetModeBySet(this.mDistrictInfo);
            int settingMode = BNSettingManager.getPrefSearchMode();
            this.netMode = getFinalNetMode(this.netMode);
            search(key);
        }
    }

    private void search(String key) {
        SearchStrategyHelper.getInstance(getContext()).reloadSearchEngine();
        if (SearchStrategyHelper.getInstance(getContext()).checkCanSearchByNetMode(this.netMode)) {
            if (BNPoiSearcher.getInstance().asynSearchWithPager(new SearchPoiPager(key, this.mDistrictInfo, 10, this.netMode), this.mHandler)) {
                C1307e.a().a(getResources().getString(C0965R.string.progress_searching), this.mSearchDialogCancelListener);
            }
        } else if (this.isFromVoice) {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
        }
    }

    private void trySearchSpace(String key) {
        this.mCurrentGeoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
        if (BNLocationManagerProxy.getInstance().isLocationValid() || this.isPoiSearchMod) {
            if (this.isPoiSearchMod && this.mCurrentPoi != null) {
                this.mCurrentGeoPoint = this.mCurrentPoi.mViewPoint;
            }
            NavPoiController.getInstance().setMyPositionGeo(this.mCurrentGeoPoint);
            this.netMode = SearchStrategyHelper.getInstance(getContext()).getNetModeByPoint(this.mCurrentGeoPoint);
            int settingMode = BNSettingManager.getPrefSearchMode();
            this.netMode = getFinalNetMode(this.netMode);
            searchSpace(key);
            return;
        }
        if (this.isFromVoice) {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
        }
        TipTool.onCreateToastDialog(getContext(), (int) C0965R.string.space_search_center_error);
    }

    private void searchSpace(String key) {
        SearchStrategyHelper.getInstance(getContext()).reloadSearchEngine();
        SearchCircle circle = new SearchCircle(this.mCurrentGeoPoint, 5000);
        if (SearchStrategyHelper.getInstance(getContext()).checkCanSearchByNetMode(this.netMode)) {
            if (BNPoiSearcher.getInstance().asynSearchWithPager(new SearchPoiPager(key, this.mDistrictInfo, circle, 10, this.netMode), this.mHandler)) {
                C1307e.a().a(getResources().getString(C0965R.string.progress_searching), this.mSearchDialogCancelListener);
            }
        } else if (this.isFromVoice) {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
        }
    }

    private void trySearchSpace(int id) {
        this.mCurrentGeoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
        if (BNLocationManagerProxy.getInstance().isLocationValid() || this.isPoiSearchMod) {
            if (this.isPoiSearchMod && this.mCurrentPoi != null) {
                this.mCurrentGeoPoint = this.mCurrentPoi.mViewPoint;
            }
            NavPoiController.getInstance().setMyPositionGeo(this.mCurrentGeoPoint);
            this.netMode = SearchStrategyHelper.getInstance(getContext()).getNetModeByPoint(this.mCurrentGeoPoint);
            int settingMode = BNSettingManager.getPrefSearchMode();
            this.netMode = getFinalNetMode(this.netMode);
            searchSpace(id);
            return;
        }
        if (this.isFromVoice) {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
        }
        TipTool.onCreateToastDialog(getContext(), (int) C0965R.string.space_search_center_error);
    }

    private void searchSpace(int id) {
        SearchStrategyHelper.getInstance(getContext()).reloadSearchEngine();
        SearchCircle cricle = new SearchCircle(this.mCurrentGeoPoint, 5000);
        if (SearchStrategyHelper.getInstance(mActivity).checkCanSearchByNetMode(this.netMode)) {
            if (BNPoiSearcher.getInstance().asynSearchWithPager(new SearchPoiPager(id, this.mDistrictInfo, cricle, 10, this.netMode), this.mHandler)) {
                C1307e.a().a(getResources().getString(C0965R.string.progress_searching), this.mSearchDialogCancelListener);
            }
        } else if (this.isFromVoice) {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
        }
    }

    private OnScrollListener getOnScrollListener() {
        return new C39175();
    }

    private OnEditorActionListener getOnEditorActionListener() {
        return new C39186();
    }

    private C2249d getFocusChangeListener() {
        return new C39197();
    }

    private TextWatcher getTextChangedListener() {
        return new C39218();
    }

    private void updateDistrict() {
        SearchStrategyHelper.getInstance(getContext()).hasDataDownloadedBySet();
        this.mDistrictInfo = GeoLocateModel.getInstance().getDistrictByManMade();
        if (this.mDistrictInfo == null) {
            this.mDistrictInfo = GeoLocateModel.getInstance().getCurrentDistrict();
        }
    }

    protected void onInitView() {
        this.oldBundle = this.mShowBundle;
        getBundle();
    }

    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (hidden) {
            BaseFragment.getNaviActivity().u().a();
            return;
        }
        BNPoiSearcher.getInstance().setNetMode(BNSettingManager.getPrefSearchMode());
        if (getNaviFragmentManager().isDriving()) {
            dismissAllDialog();
            pageBack(this.mModuleFrom);
            C1260i.b("yftech", "CarModeQuickRoutePlanFragment onHiddenChanged " + this.mModuleFrom);
            C1342a.a().d();
        }
    }

    public void onResume() {
        boolean isDataDownloaded;
        super.onResume();
        updateHeadView();
        updateDistrict();
        if (BNLocationManagerProxy.getInstance().isLocationValid()) {
            clearLastResult();
        } else {
            clearLastResult();
        }
        if (this.isSpaceSearchMode) {
            this.mCurrentGeoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
            isDataDownloaded = SearchStrategyHelper.getInstance(getContext()).hasDataDownloadedByPoint(this.mCurrentGeoPoint);
        } else {
            isDataDownloaded = SearchStrategyHelper.getInstance(getContext()).hasDataDownloadedBySet();
        }
        if (isDataDownloaded) {
            this.sugNetMode = 0;
        } else {
            this.sugNetMode = 1;
        }
        this.sugNetMode = getFinalNetMode(this.sugNetMode);
        BNPoiSearcher.getInstance().setNetMode(BNSettingManager.getPrefSearchMode());
        BNPoiSearcher.getInstance().initInputSug(this.mDistrictInfo);
        if (NavMapManager.getInstance().getNaviMapMode() == 5) {
            C0705a.a().e();
            C0705a.a().g();
            NavMapManager.getInstance().handleMapOverlays(0);
            NavMapManager.getInstance().setNaviMapMode(0);
            NavMapManager.getInstance().showCarResultLayer(false);
        }
        if (this.oldNode == null && !((getHomeAddress() == null && getCompanyAddress() == null) || this.newBundle == null || this.newBundle.getInt(BundleKey.FROM_FRAGMENT) != 49)) {
            this.newBundle = null;
            this.mShowBundle = this.oldBundle;
            getBundle();
        }
        if (TextUtils.isEmpty(this.mSearchKey)) {
            this.canSugShow = false;
        } else {
            this.canSugShow = true;
        }
        updateListView();
        C1260i.b(TAG);
    }

    private void updateHeadView() {
        RoutePlanNode homeNode = getHomeAddress();
        RoutePlanNode companyNode = getCompanyAddress();
        this.tvHomeSetting.setVisibility(8);
        this.tvCompanySetting.setVisibility(8);
        if (homeNode == null) {
            this.tvHomeSetting.setVisibility(0);
        }
        if (companyNode == null) {
            this.tvCompanySetting.setVisibility(0);
        }
    }

    private int getFinalNetMode(int mode) {
        int finalNetMode;
        int settingMode = BNSettingManager.getPrefSearchMode();
        if (mode == 0) {
            this.hasData = true;
        } else {
            this.hasData = false;
        }
        if (settingMode == 2) {
            if (this.hasData) {
                finalNetMode = 0;
            } else {
                finalNetMode = 1;
            }
        } else if (NetworkUtils.isNetworkAvailable(getContext()) || !this.hasData) {
            finalNetMode = 1;
        } else {
            finalNetMode = 0;
        }
        if (this.hasData || finalNetMode != 1) {
            this.overTime = 5000;
        } else {
            this.overTime = 30000;
        }
        return finalNetMode;
    }

    protected void hideSoftInputMethod() {
        ((InputMethodManager) mActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.mSearchEditText.getWindowToken(), 0);
    }

    protected void showSoftInputMethod() {
        ((InputMethodManager) mActivity.getSystemService("input_method")).toggleSoftInput(0, 2);
    }

    private void handleTimeout(SearchPoiPager searchPoiPager) {
        if (this.hasData && this.netMode == 1) {
            this.netMode = 0;
            if (searchPoiPager != null) {
                searchPoiPager.setNetMode(this.netMode);
                BNPoiSearcher.getInstance().asynSearchWithPager(searchPoiPager, this.overTime, this.mHandler);
                C1307e.a().a(getResources().getString(C0965R.string.progress_searching), this.mSearchDialogCancelListener);
                return;
            }
            return;
        }
        if (this.isFromVoice) {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
        }
        TipTool.onCreateToastDialog(getContext(), (int) C0965R.string.search_result_toast_failed);
    }

    private void handleSpaceKeySearchSuc(SearchPoiPager searchPoiPager) {
        List<SearchPoiPager> searchPoiPagers = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchPoiPagerList();
        if (searchPoiPagers.size() != 1) {
            resultEmpty(searchPoiPager);
            return;
        }
        List<SearchPoi> poiList = ((SearchPoiPager) searchPoiPagers.get(0)).getPoiList();
        if (poiList == null || poiList.size() == 0) {
            resultEmpty(searchPoiPager);
            return;
        }
        SearchNameHistroyModel.getInstance().addSearchName(searchPoiPager.getSearchKey());
        Bundle bundle = this.mShowBundle;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("search_key", searchPoiPager.getSearchKey());
        bundle.putInt("district_id", this.cityId);
        bundle.putInt("search_mode", this.netMode);
        bundle.putInt("search_type", 18);
        if (mActivity != null && !mActivity.isFinishing()) {
            showFragment(35, bundle);
        }
    }

    private void handleNameSearchSuc(SearchPoiPager searchPoiPager) {
        List<SearchPoiPager> searchPoiPagers = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchPoiPagerList();
        if (searchPoiPagers.size() != 1) {
            resultEmpty(searchPoiPager);
            return;
        }
        List<SearchPoi> poiList = ((SearchPoiPager) searchPoiPagers.get(0)).getPoiList();
        if (poiList == null || poiList.size() == 0) {
            resultEmpty(searchPoiPager);
            return;
        }
        SearchNameHistroyModel.getInstance().addSearchName(searchPoiPager.getSearchKey());
        Bundle bundle = this.mShowBundle;
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("search_key", searchPoiPager.getSearchKey());
        bundle.putInt("search_mode", this.netMode);
        bundle.putInt("search_type", 17);
        bundle.putInt("district_id", this.mDistrictInfo.mId);
        bundle.putInt(ContentFragmentManager.MODULE_FROM, this.mModuleFrom);
        if (this.isFromVoice) {
            bundle.putInt("incoming_type", 35);
            bundle.putInt(BNVoiceCommandParams.Key_Bundle_VC_Top_Type, this.mShowBundle.getInt(BNVoiceCommandParams.Key_Bundle_VC_Top_Type, -1));
            bundle.putInt(BNVoiceCommandParams.Key_Bundle_VC_Sub_Type, this.mShowBundle.getInt(BNVoiceCommandParams.Key_Bundle_VC_Sub_Type, -1));
        }
        if (mActivity != null && !mActivity.isFinishing()) {
            showFragment(35, bundle);
        }
    }

    private boolean resultEmpty(final SearchPoiPager searchPoiPager) {
        if (this.netMode == 0 && this.hasData) {
            showTwoBtnDialog(C0965R.string.search_result_empty_offline, new C0672b() {
                public void onClick() {
                    CarModeQuickRoutePlanFragment.this.dismissTwoBtnDialog();
                    CarModeQuickRoutePlanFragment.this.netMode = 1;
                    if (SearchStrategyHelper.getInstance(CarModeQuickRoutePlanFragment.this.getContext()).checkCanSearchByNetMode(CarModeQuickRoutePlanFragment.this.netMode)) {
                        searchPoiPager.setNetMode(CarModeQuickRoutePlanFragment.this.netMode);
                        BNPoiSearcher.getInstance().asynSearchWithPager(searchPoiPager, CarModeQuickRoutePlanFragment.this.overTime, CarModeQuickRoutePlanFragment.this.mHandler);
                        C1307e.a().a(CarModeQuickRoutePlanFragment.this.getResources().getString(C0965R.string.progress_searching), CarModeQuickRoutePlanFragment.this.mSearchDialogCancelListener);
                    }
                }
            }, new C0672b() {
                public void onClick() {
                    CarModeQuickRoutePlanFragment.this.dismissTwoBtnDialog();
                }
            });
            return true;
        } else if (this.netMode == 1) {
            if (this.hasData) {
                this.hasData = false;
                this.netMode = 0;
                searchPoiPager.setNetMode(this.netMode);
                BNPoiSearcher.getInstance().asynSearchWithPager(searchPoiPager, this.overTime, this.mHandler);
            } else {
                if (this.isFromVoice) {
                    BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
                }
                if (NetworkUtils.isNetworkAvailable(getContext())) {
                    TipTool.onCreateToastDialog(getContext(), (int) C0965R.string.search_result_toast_failed);
                } else {
                    TipTool.onCreateToastDialog(getContext(), (int) C0965R.string.space_search_network_unavailable);
                }
            }
            return false;
        } else {
            if (this.isFromVoice) {
                BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
            }
            TipTool.onCreateToastDialog(getContext(), (int) C0965R.string.search_result_toast_failed);
            return true;
        }
    }

    private void handleSpaceCatalogSearchSuc(SearchPoiPager searchPoiPager) {
        List<SearchPoiPager> searchPoiPagers = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchPoiPagerList();
        if (searchPoiPagers.size() != 1) {
            resultEmpty(searchPoiPager);
            return;
        }
        List<SearchPoi> poiList = ((SearchPoiPager) searchPoiPagers.get(0)).getPoiList();
        if (poiList == null || poiList.size() == 0) {
            resultEmpty(searchPoiPager);
            return;
        }
        SearchNameHistroyModel.getInstance().addSearchName(searchPoiPager.getSearchKey());
        Bundle bundle = this.mShowBundle;
        if (bundle == null) {
            bundle = new Bundle();
        }
        if (this.isPoiSearchMod) {
            bundle.putBoolean("poi_center_mode", true);
        }
        bundle.putString("search_key", this.mSearchKey);
        bundle.putInt("search_mode", this.netMode);
        bundle.putInt("incoming_type", 33);
        bundle.putInt("search_type", 19);
        bundle.putInt("district_id", this.mDistrictInfo.mId);
        if (mActivity != null && !mActivity.isFinishing()) {
            showFragment(35, bundle);
        }
    }

    public void updateListView() {
        String keyword;
        int i;
        this.searchHeadItemView.setVisibility(0);
        if (!this.isShowHeader || this.canSugShow) {
            this.mListView.removeHeaderView(this.mHeaderView);
        }
        if (this.isShowHeader && this.mListView.getHeaderViewsCount() == 0 && !this.canSugShow) {
            this.mListView.addHeaderView(this.mHeaderView);
        }
        if (this.isShowHeader) {
            this.searchHeadItemView.setVisibility(8);
        }
        if (this.mListView.getAdapter() instanceof HeaderViewListAdapter) {
            this.mListView.removeFooterView(this.mFooterView);
        }
        this.mDataList.clear();
        if (TextUtils.isEmpty(this.mSearchKey)) {
            keyword = "";
        } else {
            keyword = this.mSearchKey.replaceAll("\\s*", "");
        }
        List<SearchNameDBObject> searchNameDBObjects = SearchNameHistroyModel.getInstance().mSearchNameDBObjects;
        if (searchNameDBObjects != null && searchNameDBObjects.size() > 0) {
            i = 0;
            while (i < 10 && i < searchNameDBObjects.size()) {
                SearchNameDBObject historyObj = (SearchNameDBObject) searchNameDBObjects.get(i);
                if (TextUtils.isEmpty(keyword) || (!TextUtils.isEmpty(keyword) && historyObj.getName().contains(keyword))) {
                    this.mDataList.add(new NameSearchEntity(historyObj.getName(), "", Type.HISTORY, historyObj.getId()));
                }
                i++;
            }
            if (!this.canSugShow) {
                this.mListView.addFooterView(this.mFooterView);
            }
        }
        if (this.canSugShow) {
            this.searchHeadItemView.setVisibility(8);
            PoiSearchModel poiSearchModel = (PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH);
            synchronized (this.mSugDataList) {
                if (poiSearchModel != null) {
                    this.mSugDataList.clear();
                    this.mSugDataList.addAll(poiSearchModel.getSugList());
                }
                for (i = 0; i < this.mSugDataList.size(); i++) {
                    if (this.mSugDataList.get(i) != null) {
                        this.mDataList.add(new NameSearchEntity(((SearchSugData) this.mSugDataList.get(i)).getName(), ((SearchSugData) this.mSugDataList.get(i)).getAddress(), Type.SUG));
                    }
                }
            }
            this.mDataList.addAll(getFavDataFromDB(this.mSearchKey));
        }
        if (this.mDataAdapter == null) {
            this.mDataAdapter = new NameSearchAdapter(getContext(), this.mDataList, keyword);
            this.mListView.setAdapter(this.mDataAdapter);
        } else {
            this.mDataAdapter.setData(this.mDataList, keyword);
            this.mDataAdapter.notifyDataSetChanged();
        }
        initFocusChain(this.mViewGroup);
    }

    private void clearLastResult() {
        ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchPoiPagerList().clear();
    }

    public void onDestroy() {
        C1261k.b(this.mHandler);
        RouteInfoCache.getInstance().setCallback(null);
        FavoritePoiManager.getInstance().cancelTask();
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        BaseFragment.getNaviActivity().u().a();
        C1307e.a().c();
        BNPoiSearcher.getInstance().setNetMode(BNSettingManager.getPrefSearchMode());
        BNPoiSearcher.getInstance().releaseInputSug(this.sugNetMode);
        hideSoftInputMethod();
        C2252a.a().d();
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
        if (this.mBackBtn != null) {
            this.mBackBtn.setBackground(C2251b.a(getContext()));
        }
    }

    public void showToast(int rid) {
        TipTool.onCreateToastDialog(getContext(), StyleManager.getString(rid));
    }

    public void initFocusChain(View root) {
        if (getCurrentFragmentType() == 49) {
            if (this.mFocusAreaTop == null) {
                this.mFocusAreaTop = new C1443g(root, 0);
                this.mFocusAreaTop.d(this.mBackBtn).d(this.mSearchEditText).d(this.mRightImageButton);
                this.mFocusAreaTop.b(this.mSearchEditText);
                C1440d.a().b(this.mFocusAreaTop);
            }
            if (this.mFocusAreaUp == null) {
                this.mFocusAreaUp = new C1443g(this.searchHeadItemView, 2);
                this.mFocusAreaUp.d(this.homeView).d(this.companyView).d(this.favoriteView).d(this.searchNearView);
                this.mFocusAreaUp.b(this.homeView);
            } else if (this.searchHeadItemView.getVisibility() != 0) {
                this.mFocusAreaUp = null;
            }
            if (!C2252a.a().b()) {
                View rootView = mActivity.u().g();
                if (this.mFocusDownArea == null) {
                    this.mFocusDownArea = new C1443g(rootView, 6);
                    this.mFocusDownArea.d(rootView.findViewById(C0965R.id.iv_home)).d(rootView.findViewById(C0965R.id.iv_phone_book)).d(rootView.findViewById(C0965R.id.iv_voice_focus_bg)).d(rootView.findViewById(C0965R.id.iv_navi)).d(rootView.findViewById(C0965R.id.iv_music));
                }
                this.mFocusDownArea.b(true);
                this.mFocusDownArea.b(rootView.findViewById(C0965R.id.iv_voice_focus_bg));
                if (this.mFocusList == null) {
                    this.mFocusList = new C1438c(this.mListView, 4);
                }
                if (this.mListView.getAdapter() == null || this.mListView.getAdapter().getCount() <= 0) {
                    C1440d.a().b(new C1436a[]{this.mFocusAreaTop, this.mFocusAreaUp, this.mFocusDownArea});
                } else {
                    C1440d.a().b(new C1436a[]{this.mFocusAreaTop, this.mFocusAreaUp, this.mFocusList, this.mFocusDownArea});
                }
                C1440d.a().h(this.mFocusDownArea);
            }
        }
    }

    public void showTwoBtnDialog(int contentStr, C0672b confirmListener, C0672b cancleListener) {
        dismissTwoBtnDialog();
        if (this.mAlertDlg == null) {
            this.mAlertDlg = new C2283g(mActivity).a(contentStr).g(17).c(C0965R.string.alert_cancel).r().d(C0965R.string.nsdk_string_common_alert_confirm);
            this.mAlertDlg.a(cancleListener);
            this.mAlertDlg.b(confirmListener);
        }
        showDialog(this.mAlertDlg);
    }

    public boolean dismissTwoBtnDialog() {
        dismissDialog(this.mAlertDlg);
        this.mAlertDlg = null;
        return true;
    }

    public RoutePlanNode getHomeAddress() {
        if (AddressSettingModel.hasSetHomeAddr(BNaviModuleManager.getContext())) {
            return AddressSettingModel.getHomeAddrNode(BNaviModuleManager.getContext());
        }
        return null;
    }

    public RoutePlanNode getCompanyAddress() {
        if (AddressSettingModel.hasSetCompAddr(BNaviModuleManager.getContext())) {
            return AddressSettingModel.getCompAddrNode(BNaviModuleManager.getContext());
        }
        return null;
    }

    private void setPointSelectNode() {
        GeoPoint geoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
        if (geoPoint == null || !geoPoint.isValid()) {
            TipTool.onCreateToastDialog(getContext(), (int) C0965R.string.route_plan_toast_loc_invalid);
            return;
        }
        SearchPoi poi = new SearchPoi();
        poi.mViewPoint = geoPoint;
        poi.mGuidePoint = geoPoint;
        this.mCurrentPoi = poi;
        PoiController poiController = PoiController.getInstance();
        poiController.clearPoiCache();
        int netMode = poiController.getAntiPoiNetMode(geoPoint);
        if (netMode == -1) {
            TipTool.onCreateToastDialog(getContext(), (int) C0965R.string.track_sync_net_error);
        } else {
            poiController.antiGeo(this.mCurrentPoi, netMode, this.mUIHandler);
        }
    }

    public void onClickFinish() {
        if (this.isSearchEnable) {
            String key = this.mSearchEditText.getText().toString().trim();
            C1260i.e(TAG, "mSearchKey:" + key);
            if (this.isSpaceSearchMode) {
                trySearchSpace(key);
                return;
            }
            trySearch(key);
            if ("openlog".equals(key)) {
                C1253f.jp = 3;
                C1912n.a().d(true);
            } else if ("openlogfile".equals(key)) {
                C1253f.jp = 3;
                C1253f.ju = true;
                C1260i.a().b();
            }
        }
    }

    public void driving() {
        C1260i.b("yftech", "CarModeQuickRoutePlanFragment driving " + this.mModuleFrom);
        dismissAllDialog();
        backTo(17, null);
        C1342a.a().d();
    }

    public void stopDriving() {
    }

    private void dismissAllDialog() {
        if (!(mActivity == null || mActivity.isFinishing())) {
            C1307e.a().c();
        }
        dismissTwoBtnDialog();
    }

    public void speedOverForbidSoftKeyboardInput() {
        if (C1765g.a().c() && this.mFocusAreaTop != null) {
            C1440d.a().b(new C1436a[]{this.mFocusAreaTop, this.mFocusList});
            this.mFocusAreaTop.c(this.mBackBtn);
            C1440d.a().h(this.mFocusAreaTop);
        }
    }

    private ArrayList<NameSearchEntity> getFavDataFromDB(String key) {
        List<FavorItem> allItems = FavoritePoiManager.getInstance().dbFavorItems;
        ArrayList<NameSearchEntity> datas = new ArrayList();
        if (allItems.size() > 0) {
            for (FavorItem item : allItems) {
                if (item.name.contains(key)) {
                    datas.add(new NameSearchEntity(item.name + " " + item.address, Type.FAVORITE));
                }
            }
        }
        return datas;
    }
}
