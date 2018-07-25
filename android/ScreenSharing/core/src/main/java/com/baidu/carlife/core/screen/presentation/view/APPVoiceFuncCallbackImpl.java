package com.baidu.carlife.core.screen.presentation.view;

import android.content.Context;
import android.os.Bundle;
import com.baidu.baidunavis.control.NavPoiController;
import com.baidu.carlife.protobuf.R;
import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.screen.OnBtnClickListener;
import com.baidu.carlife.core.screen.OnDialogListener;
import com.baidu.carlife.core.screen.presentation.FragmentManagerCallbackProxy;
import com.baidu.carlife.protobuf.p052m.C1915a;
import com.baidu.carlife.protobuf.view.dialog.C1953c;
import com.baidu.navi.ActivityStack;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.controller.NameSearchHelper;
import com.baidu.navi.controller.QuickFragmentListener;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.ContentFragmentManager;
import com.baidu.navi.fragment.MapContentFragment;
import com.baidu.navi.fragment.NameSearchFragment;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams.BundleKey;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.voicecommand.APPVoiceFuncCallback;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandParams;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.ui.cruise.BCruiser;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;

/* compiled from: APPVoiceFuncCallbackImpl */
/* renamed from: com.baidu.carlife.core.screen.presentation.a.a */
public class APPVoiceFuncCallbackImpl implements APPVoiceFuncCallback {
    /* renamed from: a */
    private CarlifePresenter f3732a;
    /* renamed from: b */
    private Context f3733b;
    /* renamed from: c */
    private OnDialogListener f3734c;
    /* renamed from: d */
    private C1953c f3735d = null;
    /* renamed from: e */
    private QuickFragmentListener f3736e = new C12971(this);

    /* compiled from: APPVoiceFuncCallbackImpl */
    /* renamed from: com.baidu.carlife.core.screen.presentation.a.a$1 */
    class C12971 implements QuickFragmentListener {
        /* renamed from: a */
        final /* synthetic */ APPVoiceFuncCallbackImpl f3731a;

        /* compiled from: APPVoiceFuncCallbackImpl */
        /* renamed from: com.baidu.carlife.core.screen.presentation.a.a$1$1 */
        class C12951 implements OnBtnClickListener {
            /* renamed from: a */
            final /* synthetic */ C12971 f3729a;

            C12951(C12971 this$1) {
                this.f3729a = this$1;
            }

            public void onClick() {
                this.f3729a.f3731a.m4624a(4);
            }
        }

        /* compiled from: APPVoiceFuncCallbackImpl */
        /* renamed from: com.baidu.carlife.core.screen.presentation.a.a$1$2 */
        class C12962 implements OnBtnClickListener {
            /* renamed from: a */
            final /* synthetic */ C12971 f3730a;

            C12962(C12971 this$1) {
                this.f3730a = this$1;
            }

            public void onClick() {
                this.f3730a.f3731a.m4624a(5);
            }
        }

        C12971(APPVoiceFuncCallbackImpl this$0) {
            this.f3731a = this$0;
        }

        public void showToast(int resId) {
        }

        public void showSetHomeAddrDialog() {
            C1953c commonDialog = new C1953c(this.f3731a.f3733b).m7442b((int) R.string.alert_notification).m7435a((int) R.string.select_node_home_notset).m7447c((int) R.string.alert_setting).m7458q().m7450d((int) R.string.alert_cancel);
            commonDialog.m7438a(new C12951(this));
            this.f3731a.f3734c.showDialog(commonDialog);
        }

        public void showSetCompAddrDialog() {
            C1953c commonDialog = new C1953c(this.f3731a.f3733b).m7442b((int) R.string.alert_notification).m7435a((int) R.string.select_node_comp_notset).m7447c((int) R.string.alert_setting).m7458q().m7450d((int) R.string.alert_cancel);
            commonDialog.m7438a(new C12962(this));
            this.f3731a.f3734c.showDialog(commonDialog);
        }

        public void onRefreshHistoryList() {
        }
    }

    public APPVoiceFuncCallbackImpl(CarlifePresenter presenter, OnDialogListener listener) {
        this.f3732a = presenter;
        this.f3733b = AppContext.getAppContext();
        this.f3734c = listener;
    }

    public boolean exitAPP() {
        ActivityStack.exitApp(true);
        return true;
    }

    public boolean switchDayNightMode(int mode) {
        BNSettingManager.setNaviDayAndNightMode(mode);
        return true;
    }

    public boolean nameSearch(String key) {
        LogUtil.d("CarlifeActivity", "nameSearch key is " + key);
        Bundle bd = new Bundle();
        bd.putInt("incoming_type", 3);
        bd.putBoolean("poi_center_mode", false);
        bd.putString(NameSearchFragment.VOICE_SEARCH_KEY, key);
        bd.putInt(BNVoiceCommandParams.Key_Bundle_VC_Top_Type, BNVoiceCommandController.getInstance().getLastestVCTopType());
        bd.putInt(BNVoiceCommandParams.Key_Bundle_VC_Sub_Type, BNVoiceCommandController.getInstance().getLastestVCSubType());
        FragmentManagerCallbackProxy fragmentManagerCallbackProxy = FragmentManagerCallbackProxy.m4757a();
        int type = fragmentManagerCallbackProxy.m4768d();
        if (type == 4001) {
            type = 1;
        } else if (type == 4004) {
            type = 4;
        } else if (type == 4002) {
            type = 2;
        } else {
            type = 3;
        }
        bd.putInt(ContentFragmentManager.MODULE_FROM, type);
        if (fragmentManagerCallbackProxy == null) {
            return false;
        }
        this.f3732a.m4680e();
        if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
            BaiduNaviSDKManager.getInstance().quitNavi();
        }
        if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
            BaiduNaviSDKManager.getInstance().quitCruise();
        }
        fragmentManagerCallbackProxy.backTo(17, null);
        NameSearchHelper.getInstance().search(BaseFragment.getNaviActivity(), fragmentManagerCallbackProxy.getCurrentFragment(), key, type, true, false);
        return true;
    }

    public boolean spaceSearch(String key) {
        LogUtil.d("CarlifeActivity", "search around key is " + key);
        Bundle bd = new Bundle();
        bd.putInt("incoming_type", 3);
        bd.putBoolean("poi_center_mode", true);
        bd.putString(NameSearchFragment.VOICE_SEARCH_KEY, key);
        bd.putInt(BNVoiceCommandParams.Key_Bundle_VC_Top_Type, BNVoiceCommandController.getInstance().getLastestVCTopType());
        bd.putInt(BNVoiceCommandParams.Key_Bundle_VC_Sub_Type, BNVoiceCommandController.getInstance().getLastestVCSubType());
        FragmentManagerCallbackProxy fragmentManagerCallbackProxy = FragmentManagerCallbackProxy.m4757a();
        int type = fragmentManagerCallbackProxy.m4768d();
        if (type == 4001) {
            type = 1;
        } else if (type == 4004) {
            type = 4;
        } else if (type == 4002) {
            type = 2;
        } else {
            type = 3;
        }
        bd.putInt(ContentFragmentManager.MODULE_FROM, type);
        if (fragmentManagerCallbackProxy == null) {
            return false;
        }
        this.f3732a.m4680e();
        if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
            BaiduNaviSDKManager.getInstance().quitNavi();
        }
        if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
            BaiduNaviSDKManager.getInstance().quitCruise();
        }
        fragmentManagerCallbackProxy.backTo(17, null);
        NameSearchHelper.getInstance().search(BaseFragment.getNaviActivity(), fragmentManagerCallbackProxy.getCurrentFragment(), key, type, true, true);
        return true;
    }

    public boolean goHome() {
        LogUtil.d("CarlifeActivity", "======go home=====");
        if (AddressSettingModel.hasSetHomeAddr(this.f3733b)) {
            this.f3732a.m4680e();
            if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
                BaiduNaviSDKManager.getInstance().quitNavi();
            }
            if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
                BaiduNaviSDKManager.getInstance().quitCruise();
            }
            FragmentManagerCallbackProxy.m4757a().backTo(17, null);
            NavPoiController.getInstance().startCalcRoute(AddressSettingModel.getHomeAddrNode(this.f3733b));
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 1);
        } else if (BNavigator.getInstance().isNaviBegin() || BCruiser.getInstance().isRouteCruiseBegin()) {
            C1915a.m7321a().m7328b("您未设置家的地址", 1);
        } else {
            this.f3736e.showSetHomeAddrDialog();
        }
        MsgHandlerCenter.dispatchMessage(4160, CommonParams.io);
        return true;
    }

    public boolean goOffice() {
        LogUtil.d("CarlifeActivity", "======go office=====");
        if (AddressSettingModel.hasSetCompAddr(this.f3733b)) {
            this.f3732a.m4680e();
            if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
                BaiduNaviSDKManager.getInstance().quitNavi();
            }
            if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
                BaiduNaviSDKManager.getInstance().quitCruise();
            }
            FragmentManagerCallbackProxy.m4757a().backTo(17, null);
            NavPoiController.getInstance().startCalcRoute(AddressSettingModel.getCompAddrNode(this.f3733b));
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 1);
        } else if (BNavigator.getInstance().isNaviBegin() || BCruiser.getInstance().isRouteCruiseBegin()) {
            C1915a.m7321a().m7328b("您未设置公司的地址", 1);
        } else {
            this.f3736e.showSetCompAddrDialog();
        }
        MsgHandlerCenter.dispatchMessage(4160, CommonParams.io);
        return true;
    }

    public boolean onFullview() {
        RGEngineControl.getInstance().enableManualSound();
        BNRouteGuider.getInstance().SetFullViewState(true);
        BNRouteGuider.getInstance().setBrowseStatus(true);
        if (1 == this.f3733b.getResources().getConfiguration().orientation) {
            BNRouteGuider.getInstance().ZoomToFullView(1);
        } else {
            BNRouteGuider.getInstance().ZoomToFullView(3);
        }
        return true;
    }

    public String myLoc() {
        int ret = 3;
        ContentFragment currFrag = FragmentManagerCallbackProxy.m4757a().getCurrentFragment();
        if (currFrag instanceof MapContentFragment) {
            ((MapContentFragment) currFrag).onVoiceCmdMyLocation();
            ret = 1;
        }
        BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), ret);
        return "done";
    }

    public boolean changeLocationMode(int mode) {
        return true;
    }

    public boolean washCar() {
        return true;
    }

    public boolean weather() {
        return true;
    }

    public boolean limitLine() {
        return true;
    }

    public void poiDataNotNew() {
    }

    public int getPageType() {
        return FragmentManagerCallbackProxy.m4757a().getCurrentFragmentType();
    }

    public void showVoiceHelp() {
    }

    public boolean onOtherVoiceFunc(int topType, int subType, int arg1, int arg2) {
        return false;
    }

    /* renamed from: a */
    public void m4624a(int action) {
        FragmentManagerCallbackProxy fragmentManagerCallbackProxy = FragmentManagerCallbackProxy.m4757a();
        this.f3732a.m4680e();
        Bundle bundle = new Bundle();
        bundle.putInt(BundleKey.FROM_FRAGMENT, fragmentManagerCallbackProxy.getCurrentFragmentType());
        bundle.putInt(BundleKey.SELECT_POINT_ACTION, action);
        bundle.putInt(ContentFragmentManager.MODULE_FROM, 3);
        fragmentManagerCallbackProxy.showFragment(49, bundle);
    }
}
