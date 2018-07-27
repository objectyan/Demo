package me.objectyan.screensharing.core.screen.presentation.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import me.objectyan.screensharing.core.AppContext;
import me.objectyan.screensharing.core.CommonParams;
import me.objectyan.screensharing.core.LogUtil;
import me.objectyan.screensharing.core.MsgHandlerCenter;
import me.objectyan.screensharing.core.screen.OnDialogListener;
import me.objectyan.screensharing.core.screen.presentation.FragmentManagerCallbackProxy;

//import com.baidu.baidunavis.control.NavPoiController;
//import me.objectyan.screensharing.protobuf.R;
//import me.objectyan.screensharing.protobuf.p052m.C1915a;
//import me.objectyan.screensharing.protobuf.view.dialog.C1953c;
//import com.baidu.navi.ActivityStack;
//import com.baidu.navi.BaiduNaviSDKManager;
//import com.baidu.navi.controller.NameSearchHelper;
//import com.baidu.navi.controller.QuickFragmentListener;
//import com.baidu.navi.fragment.BaseFragment;
//import com.baidu.navi.fragment.ContentFragment;
//import com.baidu.navi.fragment.ContentFragmentManager;
//import com.baidu.navi.fragment.MapContentFragment;
//import com.baidu.navi.fragment.NameSearchFragment;
//import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
//import com.baidu.navisdk.comapi.routeplan.RoutePlanParams.BundleKey;
//import com.baidu.navisdk.comapi.setting.BNSettingManager;
//import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
//import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandParams;
//import com.baidu.navisdk.model.AddressSettingModel;
//import com.baidu.navisdk.ui.cruise.BCruiser;
//import com.baidu.navisdk.ui.routeguide.BNavigator;
//import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;


public class APPVoiceFuncCallbackImpl implements APPVoiceFuncCallback {

    private CarlifePresenter mCarlifePresenter;

    private Context mContext;

    private OnDialogListener mOnDialogListener;

//    private C1953c f3735d = null;
//
//    private QuickFragmentListener f3736e = new C12971(this);


//    class C12971 implements QuickFragmentListener {
//
//        final  APPVoiceFuncCallbackImpl f3731a;
//
//                //
//        class C12951 implements OnBtnClickListener {
//
//            final  C12971 f3729a;
//
//            C12951(C12971 this$1) {
//                this.f3729a = this$1;
//            }
//
//            public void onClick() {
//                this.f3729a.f3731a.showFragment(4);
//            }
//        }
//
//                //
//        class C12962 implements OnBtnClickListener {
//
//            final  C12971 f3730a;
//
//            C12962(C12971 this$1) {
//                this.f3730a = this$1;
//            }
//
//            public void onClick() {
//                this.f3730a.f3731a.showFragment(5);
//            }
//        }
//
//        C12971(APPVoiceFuncCallbackImpl this$0) {
//            this.f3731a = this$0;
//        }
//
//        public void showToast(int resId) {
//        }
//
//        public void showSetHomeAddrDialog() {
//            C1953c commonDialog = new C1953c(this.f3731a.mContext).m7442b((int) R.string.alert_notification).m7435a((int) R.string.select_node_home_notset).m7447c((int) R.string.alert_setting).m7458q().m7450d((int) R.string.alert_cancel);
//            commonDialog.m7438a(new C12951(this));
//            this.f3731a.mOnDialogListener.showDialog(commonDialog);
//        }
//
//        public void showSetCompAddrDialog() {
//            C1953c commonDialog = new C1953c(this.f3731a.mContext).m7442b((int) R.string.alert_notification).m7435a((int) R.string.select_node_comp_notset).m7447c((int) R.string.alert_setting).m7458q().m7450d((int) R.string.alert_cancel);
//            commonDialog.m7438a(new C12962(this));
//            this.f3731a.mOnDialogListener.showDialog(commonDialog);
//        }
//
//        public void onRefreshHistoryList() {
//        }
//    }

    public APPVoiceFuncCallbackImpl(CarlifePresenter presenter, OnDialogListener listener) {
        this.mCarlifePresenter = presenter;
        this.mContext = AppContext.getAppContext();
        this.mOnDialogListener = listener;
    }

    public boolean exitAPP() {
//        ActivityStack.exitApp(true);
        return true;
    }

    public boolean switchDayNightMode(int mode) {
//        BNSettingManager.setNaviDayAndNightMode(mode);
        return true;
    }

    public boolean nameSearch(String key) {
        Log.d("CarlifeActivity", "nameSearch key is " + key);
        Bundle bd = new Bundle();
        bd.putInt("incoming_type", 3);
        bd.putBoolean("poi_center_mode", false);
        bd.putString("voice_key", key);
        bd.putInt("Key_Bundle_VC_Top_Type", -1);
        bd.putInt("Key_Bundle_VC_Sub_Type", -1);
        FragmentManagerCallbackProxy fragmentManagerCallbackProxy = FragmentManagerCallbackProxy.m4757a();
//        int type = fragmentManagerCallbackProxy.m4768d();
//        if (type == 4001) {
//            type = 1;
//        } else if (type == 4004) {
//            type = 4;
//        } else if (type == 4002) {
//            type = 2;
//        } else {
//            type = 3;
//        }
//        bd.putInt("module_from", type);
        if (fragmentManagerCallbackProxy == null) {
            return false;
        }
        this.mCarlifePresenter.initNavi1();
//        if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
//            BaiduNaviSDKManager.getInstance().quitNavi();
//        }
//        if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
//            BaiduNaviSDKManager.getInstance().quitCruise();
//        }
        fragmentManagerCallbackProxy.backTo(17, null);
//        NameSearchHelper.getInstance().search(BaseFragment.getNaviActivity(), fragmentManagerCallbackProxy.getCurrentFragment(), key, type, true, false);
        return true;
    }

    public boolean spaceSearch(String key) {
        Log.d("CarlifeActivity", "search around key is " + key);
        Bundle bd = new Bundle();
        bd.putInt("incoming_type", 3);
        bd.putBoolean("poi_center_mode", true);
        bd.putString("voice_key", key);
        bd.putInt("Key_Bundle_VC_Top_Type", -1);
        bd.putInt("Key_Bundle_VC_Sub_Type", -1);
        FragmentManagerCallbackProxy fragmentManagerCallbackProxy = FragmentManagerCallbackProxy.m4757a();
//        int type = fragmentManagerCallbackProxy.m4768d();
//        if (type == 4001) {
//            type = 1;
//        } else if (type == 4004) {
//            type = 4;
//        } else if (type == 4002) {
//            type = 2;
//        } else {
//            type = 3;
//        }
//        bd.putInt("module_from", type);
        if (fragmentManagerCallbackProxy == null) {
            return false;
        }
        this.mCarlifePresenter.initNavi1();
//        if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
//            BaiduNaviSDKManager.getInstance().quitNavi();
//        }
//        if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
//            BaiduNaviSDKManager.getInstance().quitCruise();
//        }
        fragmentManagerCallbackProxy.backTo(17, null);
//        NameSearchHelper.getInstance().search(BaseFragment.getNaviActivity(), fragmentManagerCallbackProxy.getCurrentFragment(), key, type, true, true);
        return true;
    }

    public boolean goHome() {
        Log.d("CarlifeActivity", "======go home=====");
//        if (AddressSettingModel.hasSetHomeAddr(this.mContext)) {
//            this.mCarlifePresenter.initNavi1();
//            if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
//                BaiduNaviSDKManager.getInstance().quitNavi();
//            }
//            if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
//                BaiduNaviSDKManager.getInstance().quitCruise();
//            }
//            FragmentManagerCallbackProxy.m4757a().backTo(17, null);
//            NavPoiController.getInstance().startCalcRoute(AddressSettingModel.getHomeAddrNode(this.mContext));
//            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 1);
//        } else if (BNavigator.getInstance().isNaviBegin() || BCruiser.getInstance().isRouteCruiseBegin()) {
//            C1915a.m7321a().m7328b("您未设置家的地址", 1);
//        } else {
//            this.f3736e.showSetHomeAddrDialog();
//        }
        MsgHandlerCenter.dispatchMessage(4160, CommonParams.io);
        return true;
    }

    public boolean goOffice() {
        Log.d("CarlifeActivity", "======go office=====");
//        if (AddressSettingModel.hasSetCompAddr(this.mContext)) {
//            this.mCarlifePresenter.initNavi1();
//            if (BaiduNaviSDKManager.getInstance().isNaviBegin()) {
//                BaiduNaviSDKManager.getInstance().quitNavi();
//            }
//            if (BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
//                BaiduNaviSDKManager.getInstance().quitCruise();
//            }
//            FragmentManagerCallbackProxy.m4757a().backTo(17, null);
//            NavPoiController.getInstance().startCalcRoute(AddressSettingModel.getCompAddrNode(this.mContext));
//            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 1);
//        } else if (BNavigator.getInstance().isNaviBegin() || BCruiser.getInstance().isRouteCruiseBegin()) {
//            C1915a.m7321a().m7328b("您未设置公司的地址", 1);
//        } else {
//            this.f3736e.showSetCompAddrDialog();
//        }
        MsgHandlerCenter.dispatchMessage(4160, CommonParams.io);
        return true;
    }

    public boolean onFullview() {
//        RGEngineControl.getInstance().enableManualSound();
//        BNRouteGuider.getInstance().SetFullViewState(true);
//        BNRouteGuider.getInstance().setBrowseStatus(true);
//        if (1 == this.mContext.getResources().getConfiguration().orientation) {
//            BNRouteGuider.getInstance().ZoomToFullView(1);
//        } else {
//            BNRouteGuider.getInstance().ZoomToFullView(3);
//        }
        return true;
    }

    public String myLoc() {
//        int ret = 3;
//        ContentFragment currFrag = FragmentManagerCallbackProxy.m4757a().getCurrentFragment();
//        if (currFrag instanceof MapContentFragment) {
//            ((MapContentFragment) currFrag).onVoiceCmdMyLocation();
//            ret = 1;
//        }
//        BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), ret);
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


    public void showFragment(int action) {
        FragmentManagerCallbackProxy fragmentManagerCallbackProxy = FragmentManagerCallbackProxy.m4757a();
        this.mCarlifePresenter.initNavi1();
        Bundle bundle = new Bundle();
        bundle.putInt("from_Fragment", fragmentManagerCallbackProxy.getCurrentFragmentType());
        bundle.putInt("select_point_action", action);
        bundle.putInt("module_from", 3);
        fragmentManagerCallbackProxy.showFragment(49, bundle);
    }
}
