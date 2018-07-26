package com.baidu.navisdk.lightnavi.controller;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.base.BNLogicController;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.lightnavi.LightNaviParams;
import com.baidu.navisdk.lightnavi.listener.LightGuideRGListener;
import com.baidu.navisdk.lightnavi.utils.LightNaviPageJumpHelper;
import com.baidu.navisdk.model.params.MsgDefine;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.navisdk.vi.VMsgDispatcher;
import com.baidu.platform.comapi.UIMsg;
import java.util.ArrayList;
import java.util.List;

public class BNLightNaviManager extends BNLogicController {
    public static final int BRIGHT_TYPE = 2;
    public static final int LOCK_TYPE = 1;
    private static final String TAG = BNLightNaviManager.class.getSimpleName();
    private static volatile BNLightNaviManager mInstance;
    public static int pRGViewMode = 1;
    private boolean isSwitching = false;
    private int mAutoRefresh = -1;
    public Activity mDetailActivity = null;
    private MsgHandler mHandler = new MsgHandler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            boolean z = true;
            switch (msg.what) {
                case 32:
                    LogUtil.m15791e("wangyang", "RP_PROCCESS_CANCLE");
                    if (BNLightNaviManager.this.isNaving()) {
                        BNaviModuleManager.removeIPO();
                    }
                    BNRouteGuider.getInstance().setNaviMode(1);
                    return;
                case 37:
                    LogUtil.m15791e("wangyang", "BN_RoutePlan_MSG.RP_IPO_SUCCESS_NORMAL=" + BNaviModuleManager.getContext());
                    LightNaviPageJumpHelper.getInstance().onPageJump(2, null);
                    return;
                case 38:
                    if (BNLightNaviManager.this.isNaving()) {
                        BNLightNaviManager.this.quitLightNavi();
                        return;
                    }
                    Context context = BNaviModuleManager.getContext();
                    BNRouteGuider.getInstance().setNaviMode(1);
                    BNMapController.getInstance().updateLayer(13);
                    TipTool.onCreateToastDialog(context, UIMsg.UI_TIP_BUS_SERVER_FAILD);
                    return;
                case 4098:
                    switch (msg.arg1) {
                        case 1:
                            if (BNLightNaviManager.this.mRGListener != null) {
                                BNLightNaviManager.this.mRGListener.zoomToFullView();
                                return;
                            }
                            return;
                        case 2:
                            if (BNLightNaviManager.this.mRGListener != null) {
                                BNLightNaviManager.this.mRGListener.onYawingRerouting(msg);
                                return;
                            }
                            return;
                        case 3:
                            if (BNLightNaviManager.this.mRGListener != null) {
                                BNLightNaviManager.this.mRGListener.onYawingRerouteSuccess(msg);
                                return;
                            }
                            return;
                        case 6:
                            if (BNLightNaviManager.this.mRGListener != null) {
                                BNLightNaviManager.this.mRGListener.onArriveDest(msg);
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                case 4100:
                case 4113:
                    LogUtil.m15791e("wangyang", "MSG_NAVI_SHOW_SIMPLE_GUIDE_INFO " + msg.arg1);
                    if (BNLightNaviManager.this.mRGListener != null) {
                        BNLightNaviManager.this.mRGListener.onUpdateSimpleGuide(msg);
                        return;
                    }
                    return;
                case 4104:
                    if (BNLightNaviManager.this.mRGListener != null) {
                        BNLightNaviManager.this.mRGListener.onUpdateSpeed(true, msg);
                        return;
                    }
                    return;
                case 4105:
                    if (BNLightNaviManager.this.mRGListener != null) {
                        BNLightNaviManager.this.mRGListener.onUpdateSpeed(true, msg);
                        return;
                    }
                    return;
                case 4106:
                    if (BNLightNaviManager.this.mRGListener != null) {
                        BNLightNaviManager.this.mRGListener.onUpdateSpeed(false, msg);
                        return;
                    }
                    return;
                case 4107:
                    if (BNLightNaviManager.this.mRGListener != null) {
                        BNLightNaviManager.this.mRGListener.onRemainInfoUpdate(msg);
                        return;
                    }
                    return;
                case 4116:
                    boolean z2;
                    String str = "BNLightNaviManager";
                    StringBuilder append = new StringBuilder().append("handleMessage: --> MSG_NAVI_GPS_STATUS_CHANGE, fixed = ");
                    if (msg.arg1 == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    LogUtil.m15791e(str, append.append(z2).toString());
                    if (BNLightNaviManager.this.mRGListener != null) {
                        LightGuideRGListener access$000 = BNLightNaviManager.this.mRGListener;
                        if (msg.arg1 != 1) {
                            z = false;
                        }
                        access$000.onGpsStatusChange(z);
                        return;
                    }
                    return;
                case 4152:
                    LogUtil.m15791e("BNLightNaviManager", "handleMessage: --> MSG_NAVI_Satellite_Fixing_Update");
                    if (BNLightNaviManager.this.mRGListener != null) {
                        BNLightNaviManager.this.mRGListener.onGpsStatusChange(false);
                        return;
                    }
                    return;
                case 4153:
                    LogUtil.m15791e("BNLightNaviManager", "handleMessage: --> MSG_NAVI_Satellite_Fix_Success_Update");
                    if (BNLightNaviManager.this.mRGListener != null) {
                        BNLightNaviManager.this.mRGListener.onGpsStatusChange(true);
                        return;
                    }
                    return;
                case MsgDefine.MSG_NAVI_PostAvoidRouteAppear /*4169*/:
                    if (BNLightNaviManager.this.mRGListener != null) {
                        BNLightNaviManager.this.mRGListener.avoidTrafficJam(msg);
                        return;
                    }
                    return;
                case MsgDefine.MSG_NAVI_CHECK_OTHER_ROUTE /*4172*/:
                    if (BNLightNaviManager.this.mRGListener != null) {
                        BNLightNaviManager.this.mRGListener.onOtherRoute(msg);
                        return;
                    }
                    return;
                case MsgDefine.MSG_NAVI_TYPE_IPO_ROADCONDITION_UPDATE /*4211*/:
                    if (BNLightNaviManager.this.mRGListener != null) {
                        BNLightNaviManager.this.mRGListener.onIPORoadConditionUpdate(msg);
                        return;
                    }
                    return;
                case MsgDefine.MSG_NAVI_TYPE_IPO_ROADCONDITION_HIDE /*4212*/:
                    if (BNLightNaviManager.this.mRGListener != null) {
                        BNLightNaviManager.this.mRGListener.onIPORoadConditionHide(msg);
                        return;
                    }
                    return;
                case MsgDefine.MSG_NAVI_TYPE_SWITCH_NAVI_ROUTE /*4216*/:
                    if (BNLightNaviManager.this.mRGListener != null && BNLightNaviManager.this.mSwitchType == 1) {
                        BNLightNaviManager.this.mRGListener.onSwithSLightToNavi(msg);
                    }
                    if (BNLightNaviManager.this.mSwitchType == 2) {
                        BNLightNaviSwitchManager.getInstance().onSwitchNormalNaviToSLight(msg);
                    }
                    int subType = msg.arg1;
                    LogUtil.m15791e("wangyang", "onSwithSLightToNavi type = " + subType + " mSwitchType=" + BNLightNaviManager.this.mSwitchType);
                    if (subType != 2) {
                        BNLightNaviSwitchManager.getInstance().setIsSwitching(false);
                        BNLightNaviSwitchManager.getInstance().setIsRefreashRoute(false);
                        return;
                    }
                    return;
                case MsgDefine.MSG_NAVI_TYPE_IPO_AutoRefresh /*4402*/:
                    BNLightNaviManager.this.mAutoRefresh = msg.arg1;
                    LogUtil.m15791e("wangyang", "onAutoRefresh type =" + BNLightNaviManager.this.mAutoRefresh);
                    return;
                case MsgDefine.MSG_NAVI_TYPE_DrivingRoute_HasHide /*4404*/:
                    if (BNLightNaviManager.this.mRGListener != null) {
                        BNLightNaviManager.this.mRGListener.isYellowBarHide(msg);
                        return;
                    }
                    return;
                case MsgDefine.MSG_NAVI_SLIGHT_LOCK_SCREEN /*4612*/:
                    if (BNLightNaviManager.this.mRGListener != null) {
                        BNLightNaviManager.this.mRGListener.onIPOLockScreen(msg);
                        return;
                    }
                    return;
                case MsgDefine.MSG_NAVI_SLIGHT_ADDRESS_SCREEN /*4613*/:
                    if (BNLightNaviManager.this.mRGListener != null) {
                        BNLightNaviManager.this.mRGListener.onIPOAddressScreen(msg);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public void careAbout() {
            observe((int) MsgDefine.MSG_NAVI_SLIGHT_LOCK_SCREEN);
            observe((int) MsgDefine.MSG_NAVI_SLIGHT_ADDRESS_SCREEN);
            observe((int) MsgDefine.MSG_NAVI_TYPE_IPO_ROADCONDITION_UPDATE);
            observe((int) MsgDefine.MSG_NAVI_TYPE_IPO_ROADCONDITION_HIDE);
            observe(4107);
            observe(4098);
            observe((int) MsgDefine.MSG_NAVI_CHECK_OTHER_ROUTE);
            observe((int) MsgDefine.MSG_NAVI_TYPE_SWITCH_NAVI_ROUTE);
            observe(4100);
            observe(4113);
            observe(4104);
            observe(4105);
            observe(4106);
            observe((int) MsgDefine.MSG_NAVI_TYPE_DrivingRoute_HasHide);
            observe(4152);
            observe(4153);
            observe(4116);
        }
    };
    private boolean mIsLightNaviView = false;
    private boolean mIsNaving = false;
    private JNIGuidanceControl mJniGuideControl;
    private Activity mLightNaviBrightActivity = null;
    private String mPackageName = LightNaviParams.DEFAULT_PACKAGE_NAME;
    private LightGuideRGListener mRGListener;
    private int mSwitchType = 0;
    private volatile int mType = 2;

    public int getAutoRefresh() {
        return this.mAutoRefresh;
    }

    public void setAutoRefresh(int autoRefresh) {
        this.mAutoRefresh = autoRefresh;
    }

    public void setPackageName(String packageName) {
        this.mPackageName = packageName;
    }

    public synchronized boolean isNaving() {
        return this.mIsNaving;
    }

    public synchronized void setIsNaving(boolean mIsNaving) {
        this.mIsNaving = mIsNaving;
    }

    public Activity getDetailActivity() {
        return this.mDetailActivity;
    }

    public void setDetailActivity(Activity mDetailActivity) {
        this.mDetailActivity = mDetailActivity;
    }

    public synchronized int getType() {
        return this.mType;
    }

    public synchronized void setType(int type) {
        boolean flag = true;
        if (this.mType != type) {
            this.mType = type;
            if (this.mRGListener != null) {
                this.mRGListener.switchScrennType();
            }
            flag = false;
        }
        if (flag && type == 1 && this.mRGListener != null) {
            this.mRGListener.calcOtherRoute();
            this.mRGListener.refreshScreenShot();
        }
    }

    public Activity getLightNaviBrightActivity() {
        return this.mLightNaviBrightActivity;
    }

    public void setLightNaviBrightActivity(Activity mLightNaviBrightActivity) {
        this.mLightNaviBrightActivity = mLightNaviBrightActivity;
    }

    public void setListener(LightGuideRGListener rgListener) {
        this.mRGListener = rgListener;
    }

    public MsgHandler getHandler() {
        return this.mHandler;
    }

    private BNLightNaviManager() {
        VMsgDispatcher.registerMsgHandler(this.mHandler);
        BNRoutePlaner.getInstance().addRouteResultHandler(this.mHandler);
        this.mJniGuideControl = JNIGuidanceControl.getInstance();
    }

    public static BNLightNaviManager getInstance() {
        if (mInstance == null) {
            synchronized (BNLightNaviManager.class) {
                if (mInstance == null) {
                    mInstance = new BNLightNaviManager();
                }
            }
        }
        return mInstance;
    }

    public void getRemianDisAndTime(Bundle bundle) {
        if (this.mJniGuideControl != null) {
            this.mJniGuideControl.getRemainRouteInfo(bundle);
        }
    }

    public void quitLightNavi() {
        if (this.mRGListener != null) {
            this.mRGListener.onQuitNavi();
        }
    }

    public void init(LightGuideRGListener ipoRGListener, Activity activity) {
        setListener(ipoRGListener);
        setLightNaviBrightActivity(activity);
        setIsNaving(true);
    }

    public void uninit() {
        this.mType = 2;
        this.mLightNaviBrightActivity = null;
        this.mIsNaving = false;
        this.mRGListener = null;
        BNRoutePlaner.getInstance().removeRouteResultHandler(this.mHandler);
        VMsgDispatcher.unregisterMsgHandler(this.mHandler);
        mInstance = null;
    }

    public void refreshScrennShot() {
        if (this.mRGListener != null) {
            this.mRGListener.refreshScreenShot();
        }
    }

    public void hideAvoidTrafficJamView() {
        if (this.mRGListener != null) {
            this.mRGListener.hideAvoidTrafficJamView();
        }
    }

    public void showSafetyGuide(boolean show) {
        if (this.mRGListener != null) {
            this.mRGListener.showSafetyGuide(show);
        }
    }

    public void startUnLockScreen() {
        UserOPController.getInstance().add(UserOPParams.LIGHTGUIDE_4_6_1);
        if (!getInstance().isNaving()) {
            quitLightNavi();
        }
        getInstance().setType(2);
    }

    public boolean isHome() {
        List<String> strs = getHomes();
        if (strs == null || strs.size() <= 0) {
            return false;
        }
        return strs.contains(this.mPackageName);
    }

    private List<String> getHomes() {
        List<String> names = new ArrayList();
        PackageManager packageManager = this.mLightNaviBrightActivity.getPackageManager();
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        for (ResolveInfo ri : packageManager.queryIntentActivities(intent, 65536)) {
            names.add(ri.activityInfo.packageName);
        }
        return names;
    }

    private void openApp() {
        PackageInfo pi = null;
        try {
            pi = this.mLightNaviBrightActivity.getPackageManager().getPackageInfo(this.mPackageName, 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        Intent resolveIntent = new Intent("android.intent.action.MAIN", null);
        resolveIntent.addCategory("android.intent.category.LAUNCHER");
        resolveIntent.setPackage(pi.packageName);
        List<ResolveInfo> apps = this.mLightNaviBrightActivity.getPackageManager().queryIntentActivities(resolveIntent, 0);
        if (apps.iterator().hasNext()) {
            ResolveInfo ri = (ResolveInfo) apps.iterator().next();
            if (ri != null) {
                String packageName1 = ri.activityInfo.packageName;
                String className = ri.activityInfo.name;
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.addCategory("android.intent.category.LAUNCHER");
                intent.setComponent(new ComponentName(packageName1, className));
                this.mLightNaviBrightActivity.startActivity(intent);
            }
        }
    }

    public void naviSwitchingCalcRoute(int type) {
        this.mSwitchType = type;
        BNLightNaviSwitchManager.getInstance().naviSwitchingCalcRoute(type);
    }

    public void cancelNaviModeSwitch() {
    }

    public void switch2AlternativeRoute(int type) {
        BNLightNaviSwitchManager.getInstance().switch2AlternativeRoute(type);
    }

    public boolean getIsLightNaviView() {
        return this.mIsLightNaviView;
    }

    public void setIsLightNaviView(boolean mIsLightNaviView) {
        this.mIsLightNaviView = mIsLightNaviView;
    }

    public boolean isSwitching() {
        return this.isSwitching;
    }

    public void setSwitching(boolean switching) {
        this.isSwitching = switching;
        LogUtil.m15791e(TAG, "setSwitching: switching --> " + switching);
    }
}
