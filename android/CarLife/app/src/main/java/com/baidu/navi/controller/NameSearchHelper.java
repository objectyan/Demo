package com.baidu.navi.controller;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.C1157a;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.screen.BaseDialog.C1265a;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.core.screen.presentation.p071a.C1307e;
import com.baidu.carlife.logic.voice.C1912n;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragmentManager;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import com.baidu.navisdk.logic.CommandConst;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.SearchCircle;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.db.model.SearchNameHistroyModel;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.List;

public final class NameSearchHelper {
    public static final String BUNDLE_KEY_INCOMING_TYPE = "incoming_type";
    public static final String BUNDLE_KEY_POI_CENTER_MODE = "poi_center_mode";
    public static final int INCOMING_CARLIFE_MAP_PAGE = 6;
    public static final int INCOMING_INTENT_API_COMMAND = 4;
    public static final int INCOMING_MORE_CATALOG_SEARCH = 1;
    public static final int INCOMING_NAME_SEARCH = 2;
    public static final int INCOMING_REMAIN_OIL_COMMAND = 5;
    public static final int INCOMING_ROUTE_PLAN_NODE_PAGE = 7;
    public static final int INCOMING_VOICE_COMMAND = 3;
    private static final NameSearchHelper INSTANCE = new NameSearchHelper();
    private static final String TAG = "PoiSearch";
    private C1328h fragmentManagerCallbackProxy;
    private boolean hasData = false;
    private CarlifeActivity mActivity;
    private BaseFragment mBaseFragment;
    private GeoPoint mCurrentGeoPoint;
    private SearchPoi mCurrentPoi;
    private C1953c mDeleteAlertDlg = null;
    private DistrictInfo mDistrictInfo;
    private Handler mHandler = new C37111();
    private boolean mIsFromVoice;
    private boolean mIsPoiSearchMod = false;
    private int mModuleFrom;
    private C0672b mSearchDialogCancelListener = new C37144();
    private String mSearchKey;
    private int netMode = 3;

    /* renamed from: com.baidu.navi.controller.NameSearchHelper$1 */
    class C37111 extends Handler {
        C37111() {
        }

        public void handleMessage(Message msg) {
            RspData rsp = msg.obj;
            if (msg.what == 1005) {
                C1307e.a().c();
                SearchPoiPager searchPoiPager = rsp.mData;
                if (searchPoiPager != null) {
                    searchPoiPager.setNetMode(BNPoiSearcher.getInstance().getNetModeOfLastResult());
                    switch (searchPoiPager.getSearchType()) {
                        case 1:
                            if (msg.arg1 != 0) {
                                LogUtil.m15791e("PoiSearch", "Name Search fail");
                                TipTool.onCreateToastDialog(NameSearchHelper.this.mActivity, (int) C0965R.string.search_result_toast_failed);
                                if (C1912n.a().l()) {
                                    C1261k.b(4162);
                                    break;
                                }
                            }
                            NameSearchHelper.this.handleNameSearchSuc(searchPoiPager);
                            C1261k.b(4160);
                            break;
                            break;
                        case 3:
                            if (msg.arg1 != 0) {
                                LogUtil.m15791e("PoiSearch", "Space Search fail");
                                TipTool.onCreateToastDialog(NameSearchHelper.this.mActivity, (int) C0965R.string.search_result_toast_failed);
                                if (C1912n.a().l()) {
                                    C1261k.b(4162);
                                    break;
                                }
                            }
                            LogUtil.m15791e("PoiSearch", "onSearchCatalogSucc()");
                            NameSearchHelper.this.handleSpaceKeySearchSuc(searchPoiPager);
                            C1261k.b(4160);
                            return;
                            break;
                        case 5:
                            if (msg.arg1 != 0) {
                                LogUtil.m15791e("PoiSearch", "Space Search fail");
                                TipTool.onCreateToastDialog(NameSearchHelper.this.mActivity, (int) C0965R.string.search_space_result_failed);
                                break;
                            }
                            LogUtil.m15791e("PoiSearch", "onSearchCatalogSucc()");
                            NameSearchHelper.this.handleSpaceCatalogSearchSuc(searchPoiPager);
                            C1261k.b(4160);
                            break;
                    }
                    if (NameSearchHelper.this.mIsFromVoice && msg.arg1 != 0) {
                        BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
                    }
                } else if (NameSearchHelper.this.netMode == 1 && NameSearchHelper.this.hasData) {
                    NameSearchHelper.this.handleTimeout((SearchPoiPager) rsp.mReq.mParams.get(CommandConst.K_COMMAND_PARAM_KEY_SEARCH_PAGER));
                    NameSearchHelper.this.hasData = false;
                } else {
                    LogUtil.m15791e("PoiSearch", "search with pager fail");
                    if (NameSearchHelper.this.mIsFromVoice) {
                        BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
                    }
                    TipTool.onCreateToastDialog(NameSearchHelper.this.mActivity, (int) C0965R.string.search_result_toast_failed);
                    if (C1912n.a().l()) {
                        C1261k.b(4162);
                    }
                }
            }
        }
    }

    /* renamed from: com.baidu.navi.controller.NameSearchHelper$3 */
    class C37133 implements C0672b {
        C37133() {
        }

        public void onClick() {
            NameSearchHelper.this.dismissTwoBtnDialog();
        }
    }

    /* renamed from: com.baidu.navi.controller.NameSearchHelper$4 */
    class C37144 implements C0672b {
        C37144() {
        }

        public void onClick() {
            BNPoiSearcher.getInstance().cancelQuery();
            C1261k.b(4165);
        }
    }

    private NameSearchHelper() {
    }

    public static NameSearchHelper getInstance() {
        return INSTANCE;
    }

    private void init(CarlifeActivity activity, BaseFragment fragment, String searchKey, int moduleFrom, boolean isFromVoice, boolean isPoiSearchMod) {
        this.mActivity = activity;
        this.mBaseFragment = fragment;
        this.mSearchKey = searchKey;
        this.mModuleFrom = moduleFrom;
        this.mIsFromVoice = isFromVoice;
        this.mIsPoiSearchMod = isPoiSearchMod;
        this.netMode = 3;
        this.hasData = false;
        this.mCurrentGeoPoint = null;
        this.fragmentManagerCallbackProxy = C1328h.a();
        if (isPoiSearchMod) {
            this.mCurrentPoi = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSpaceSearchPoi();
        } else {
            this.mCurrentPoi = null;
        }
        this.mDistrictInfo = GeoLocateModel.getInstance().getDistrictByManMade();
        if (this.mDistrictInfo == null) {
            this.mDistrictInfo = GeoLocateModel.getInstance().getCurrentDistrict();
        }
        SearchStrategyHelper.getInstance(activity.getBaseContext()).reloadSearchEngine();
    }

    public void search(CarlifeActivity activity, BaseFragment fragment, String searchKey, int searchId, int moduleFrom, boolean isFromVoice, boolean isPoiSearchMod) {
        init(AddressSettingModel, fragment, searchKey, moduleFrom, isFromVoice, isPoiSearchMod);
        trySearchId(searchId);
    }

    public void search(CarlifeActivity activity, BaseFragment fragment, String searchKey, int moduleFrom, boolean isFromVoice, boolean isPoiSearchMod) {
        init(activity, fragment, searchKey, moduleFrom, isFromVoice, isPoiSearchMod);
        trySearchKey(searchKey);
    }

    private void trySearchId(int searchId) {
        this.mCurrentGeoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
        if (BNLocationManagerProxy.getInstance().isLocationValid() || this.mIsPoiSearchMod) {
            if (this.mIsPoiSearchMod && this.mCurrentPoi != null) {
                this.mCurrentGeoPoint = this.mCurrentPoi.mViewPoint;
            }
            this.netMode = SearchStrategyHelper.getInstance(this.mActivity).getNetModeByPoint(this.mCurrentGeoPoint);
            int settingMode = BNSettingManager.getPrefSearchMode();
            this.netMode = getFinalNetMode(this.netMode);
            searchSpace(searchId);
            return;
        }
        if (this.mIsFromVoice) {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
        }
        TipTool.onCreateToastDialog(this.mActivity, (int) C0965R.string.space_search_center_error);
    }

    private void trySearchKey(String searchKey) {
        this.mCurrentGeoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
        if (BNLocationManagerProxy.getInstance().isLocationValid() || this.mIsPoiSearchMod) {
            if (this.mIsPoiSearchMod && this.mCurrentPoi != null) {
                this.mCurrentGeoPoint = this.mCurrentPoi.mViewPoint;
            }
            this.netMode = SearchStrategyHelper.getInstance(this.mActivity).getNetModeByPoint(this.mCurrentGeoPoint);
            int settingMode = BNSettingManager.getPrefSearchMode();
            this.netMode = getFinalNetMode(this.netMode);
            if (this.mIsPoiSearchMod) {
                searchSpace(searchKey);
                return;
            } else {
                nameSearch(searchKey);
                return;
            }
        }
        if (this.mIsFromVoice) {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
        }
        TipTool.onCreateToastDialog(this.mActivity, (int) C0965R.string.space_search_center_error);
    }

    private void searchSpace(int id) {
        SearchCircle cricle = new SearchCircle(this.mCurrentGeoPoint, 5000);
        if (SearchStrategyHelper.getInstance(this.mActivity).checkCanSearchByNetMode(this.netMode)) {
            SearchPoiPager searchPoiPager = new SearchPoiPager(id, this.mDistrictInfo, cricle, 10, this.netMode);
            C1307e.a().a(C1157a.a().getString(C0965R.string.progress_searching), this.mSearchDialogCancelListener);
            BNPoiSearcher.getInstance().asynSearchWithPager(searchPoiPager, this.mHandler);
        } else if (this.mIsFromVoice) {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
        }
    }

    private void searchSpace(String searchKey) {
        SearchCircle circle = new SearchCircle(this.mCurrentGeoPoint, 5000);
        if (SearchStrategyHelper.getInstance(this.mActivity).checkCanSearchByNetMode(this.netMode)) {
            SearchPoiPager searchPoiPager = new SearchPoiPager(searchKey, this.mDistrictInfo, circle, 10, this.netMode);
            C1307e.a().a(C1157a.a().getString(C0965R.string.progress_searching), this.mSearchDialogCancelListener);
            BNPoiSearcher.getInstance().asynSearchWithPager(searchPoiPager, this.mHandler);
        } else if (this.mIsFromVoice) {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
        }
    }

    private void nameSearch(String searchKey) {
        if (SearchStrategyHelper.getInstance(this.mActivity).checkCanSearchByNetMode(this.netMode)) {
            SearchPoiPager searchPoiPager = new SearchPoiPager(searchKey, this.mDistrictInfo, 10, this.netMode);
            C1307e.a().a(C1157a.a().getString(C0965R.string.progress_searching), this.mSearchDialogCancelListener);
            BNPoiSearcher.getInstance().asynSearchWithPager(searchPoiPager, this.mHandler);
        } else if (this.mIsFromVoice) {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
        }
    }

    private boolean isActivityEnable() {
        return (this.mActivity == null || this.mActivity.isFinishing()) ? false : true;
    }

    public int getFinalNetMode(int mode) {
        int settingMode = BNSettingManager.getPrefSearchMode();
        if (mode == 0) {
            this.hasData = true;
        } else {
            this.hasData = false;
        }
        if (settingMode == 2) {
            if (this.hasData) {
                return 0;
            }
            return 1;
        } else if (NetworkUtils.isNetworkAvailable(this.mActivity) || !this.hasData) {
            return 1;
        } else {
            return 0;
        }
    }

    private void handleTimeout(SearchPoiPager searchPoiPager) {
        if (this.hasData && this.netMode == 1) {
            this.netMode = 0;
            if (searchPoiPager != null) {
                searchPoiPager.setNetMode(this.netMode);
                BNPoiSearcher.getInstance().asynSearchWithPager(searchPoiPager, this.mHandler);
                C1307e.a().a(C1157a.a().getString(C0965R.string.progress_searching), this.mSearchDialogCancelListener);
                return;
            }
            return;
        }
        if (this.mIsFromVoice) {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
        }
        TipTool.onCreateToastDialog(this.mActivity, (int) C0965R.string.search_result_toast_failed);
        if (C1912n.a().l()) {
            C1261k.b(4162);
        }
    }

    private void handleSpaceCatalogSearchSuc(SearchPoiPager searchPoiPager) {
        C1260i.b("PoiSearch", "handleSpaceCatalogSearchSuc");
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
        Bundle bundle = null;
        if (null == null) {
            bundle = new Bundle();
        }
        if (this.mIsPoiSearchMod) {
            bundle.putBoolean("poi_center_mode", true);
        }
        bundle.putString("search_key", this.mSearchKey);
        bundle.putInt("search_mode", this.netMode);
        if (bundle.getInt("incoming_type") != 5) {
            bundle.putInt("incoming_type", 33);
        }
        bundle.putInt("incoming_type", 33);
        bundle.putInt("search_type", 19);
        bundle.putInt("district_id", this.mDistrictInfo.mId);
        if (isActivityEnable()) {
            this.fragmentManagerCallbackProxy.showFragment(35, bundle);
        }
    }

    private boolean resultEmpty(final SearchPoiPager searchPoiPager) {
        if (this.netMode == 0 && this.hasData) {
            showTwoBtnDialog(C0965R.string.search_result_empty_offline, new C0672b() {
                public void onClick() {
                    NameSearchHelper.this.dismissTwoBtnDialog();
                    NameSearchHelper.this.netMode = 1;
                    if (SearchStrategyHelper.getInstance(NameSearchHelper.this.mActivity).checkCanSearchByNetMode(NameSearchHelper.this.netMode)) {
                        searchPoiPager.setNetMode(NameSearchHelper.this.netMode);
                        BNPoiSearcher.getInstance().asynSearchWithPager(searchPoiPager, NameSearchHelper.this.mHandler);
                        C1307e.a().a(C1157a.a().getString(C0965R.string.progress_searching), NameSearchHelper.this.mSearchDialogCancelListener);
                    }
                }
            }, new C37133());
            return true;
        } else if (this.netMode == 1) {
            if (this.hasData) {
                this.hasData = false;
                this.netMode = 0;
                searchPoiPager.setNetMode(this.netMode);
                BNPoiSearcher.getInstance().asynSearchWithPager(searchPoiPager, this.mHandler);
            } else {
                if (this.mIsFromVoice) {
                    BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
                }
                if (NetworkUtils.isNetworkAvailable(this.mActivity)) {
                    TipTool.onCreateToastDialog(this.mActivity, (int) C0965R.string.search_result_toast_failed);
                    if (C1912n.a().l()) {
                        C1261k.b(4162);
                    }
                } else {
                    TipTool.onCreateToastDialog(this.mActivity, (int) C0965R.string.space_search_network_unavailable);
                    if (C1912n.a().l()) {
                        C1261k.b(4162);
                    }
                }
            }
            return false;
        } else {
            if (this.mIsFromVoice) {
                BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
            }
            TipTool.onCreateToastDialog(this.mActivity, (int) C0965R.string.search_result_toast_failed);
            if (!C1912n.a().l()) {
                return true;
            }
            C1261k.b(4162);
            return true;
        }
    }

    public void showTwoBtnDialog(int contentStr, C0672b confirmListener, C0672b cancleListener) {
        dismissTwoBtnDialog();
        if (this.mDeleteAlertDlg == null) {
            this.mDeleteAlertDlg = new C1953c(this.mActivity).a(contentStr).g(17).c(C0965R.string.alert_confirm).q().d(C0965R.string.alert_cancel);
            this.mDeleteAlertDlg.b(confirmListener);
            this.mDeleteAlertDlg.a(cancleListener);
        }
        this.mBaseFragment.showDialog(this.mDeleteAlertDlg, C1265a.Center);
    }

    public boolean dismissTwoBtnDialog() {
        this.mBaseFragment.dismissDialog(this.mDeleteAlertDlg);
        this.mDeleteAlertDlg = null;
        return true;
    }

    private void handleNameSearchSuc(SearchPoiPager searchPoiPager) {
        C1260i.b("PoiSearch", "handleNameSearchSuc");
        Bundle bundle = new Bundle();
        bundle.putInt("search_type", 17);
        handleSearchSuc(searchPoiPager, bundle);
    }

    private void handleSpaceKeySearchSuc(SearchPoiPager searchPoiPager) {
        C1260i.b("PoiSearch", "handleSpaceKeySearchSuc");
        Bundle bundle = new Bundle();
        bundle.putInt("search_type", 18);
        handleSearchSuc(searchPoiPager, bundle);
    }

    private void handleSearchSuc(SearchPoiPager searchPoiPager, Bundle bundle) {
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
        bundle.putString("search_key", searchPoiPager.getSearchKey());
        bundle.putInt("district_id", this.mDistrictInfo.mId);
        bundle.putInt("search_mode", this.netMode);
        bundle.putInt(ContentFragmentManager.MODULE_FROM, this.mModuleFrom);
        if (this.mIsPoiSearchMod) {
            bundle.putBoolean("poi_center_mode", true);
        }
        if (this.mIsFromVoice) {
            bundle.putInt("incoming_type", 35);
        }
        if (isActivityEnable()) {
            this.fragmentManagerCallbackProxy.showFragment(35, bundle);
        }
    }
}
