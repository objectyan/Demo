package com.baidu.navi.controller;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import com.baidu.carlife.core.C0936j;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.core.screen.presentation.p071a.C1309g;
import com.baidu.carlife.util.C2201w;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.ISDKNaviStatusListener;

public class BottomTabDisplayController {
    private static final int DELAY_HIDE_TIME = 10000;
    private static final int MSG_HIDE_BOTTOM_TAB = 100;
    private static final int MSG_SHOW_BOTTOM_TAB = 200;
    private static BottomTabDisplayController mInstance;
    private static boolean mIsFunctionOn = true;
    private BottomTabHandler mBottomTabHandler = new BottomTabHandler();
    private Handler mHandler = new C36791();
    private ISDKNaviStatusListener mISDKNaviStatusListener = new MySDKNaviStatusListener();
    private boolean mIsDebugLogOn = false;
    private int mPanelShowNum = 0;
    private Object mPanelShowNumLock = new Object();

    /* renamed from: com.baidu.navi.controller.BottomTabDisplayController$1 */
    class C36791 extends Handler {
        C36791() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 100:
                    if (BottomTabDisplayController.this.isHideViable()) {
                        BottomTabDisplayController.this.hideTab();
                        return;
                    }
                    return;
                case 200:
                    if (BottomTabDisplayController.this.isShowViable()) {
                        BottomTabDisplayController.this.showTab();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private class BottomTabHandler extends C0936j {
        private BottomTabHandler() {
        }

        public void handleMessage(Message msg) {
            if (msg.what == 1004) {
                BottomTabDisplayController.this.delayHide();
            }
            if (msg.what == 1002) {
                BottomTabDisplayController.this.delayHide();
            }
        }

        public void careAbout() {
            addMsg(1004);
            addMsg(1002);
        }
    }

    class MySDKNaviStatusListener implements ISDKNaviStatusListener {
        MySDKNaviStatusListener() {
        }

        public void onSetingBtnClick() {
            BottomTabDisplayController.this.delayHide();
        }

        public void onFullViewBtnClick() {
            BottomTabDisplayController.this.delayHide();
        }

        public void onResumeBtnClick() {
            BottomTabDisplayController.this.delayHide();
        }

        public void onLocationBtnClick() {
            BottomTabDisplayController.this.delayHide();
        }

        public void onViaPointBtnClick() {
            BottomTabDisplayController.this.delayHide();
        }

        public void onZoomInBtnClick() {
            BottomTabDisplayController.this.delayHide();
        }

        public void onZoomOutBtnClick() {
            BottomTabDisplayController.this.delayHide();
        }

        public void onMoreMenuClick() {
            if (BottomTabDisplayController.this.mIsDebugLogOn) {
                C2201w.a("onMoreMenuClick", 0);
            }
        }

        public void onRouteSwitchClick() {
            BottomTabDisplayController.this.delayHide();
        }

        public void onResumeNavigatorClick() {
            BottomTabDisplayController.this.delayHide();
        }

        public void onMASwitchClick() {
            BottomTabDisplayController.this.delayHide();
        }

        public void onBridgeSwitchClick() {
            BottomTabDisplayController.this.delayHide();
        }

        public void onEmptyPoiClick() {
            BottomTabDisplayController.this.delayHide();
        }

        public void onFocusMoreMenu() {
            BottomTabDisplayController.this.showThenDelayDismiss();
        }

        public void onRoutePlanYawing() {
            if (BottomTabDisplayController.this.mIsDebugLogOn) {
                C2201w.a("onRoutePlanYawing");
            }
            BottomTabDisplayController.this.panelShow();
        }

        public void onReRouteComplete() {
            if (BottomTabDisplayController.this.mIsDebugLogOn) {
                C2201w.a("onReRouteComplete");
            }
            BottomTabDisplayController.this.panelHide();
        }

        public void onMainAuxiliaryShow() {
            if (BottomTabDisplayController.this.mIsDebugLogOn) {
                C2201w.a("onMainAuxiliaryShow");
            }
            BottomTabDisplayController.this.panelShow();
        }

        public void onMainAuxiliaryHide() {
            if (BottomTabDisplayController.this.mIsDebugLogOn) {
                C2201w.a("onMainAuxiliaryHide");
            }
            BottomTabDisplayController.this.panelHide();
        }

        public void onEnlargeRoadMapViewShow() {
            if (BottomTabDisplayController.this.mIsDebugLogOn) {
                C2201w.a("onEnlargeRoadMapViewShow", 0);
            }
            BottomTabDisplayController.this.panelShow();
        }

        public void onEnlargeRoadMapViewHide() {
            if (BottomTabDisplayController.this.mIsDebugLogOn) {
                C2201w.a("onEnlargeRoadMapViewHide", 0);
            }
            BottomTabDisplayController.this.panelHide();
        }

        public void onNaviLeftPanelTouch() {
            BottomTabDisplayController.this.showThenDelayDismiss();
        }

        public void onZoomInGetFocus() {
            BottomTabDisplayController.this.delayHide();
        }

        public void onZoomOutGetFocus() {
            BottomTabDisplayController.this.delayHide();
        }

        public void onFocusMoreMenuGetFocus() {
            BottomTabDisplayController.this.delayHide();
        }

        public void onFullOrResumeGetFocus() {
            BottomTabDisplayController.this.delayHide();
        }

        public void onLocationGetFocus() {
            BottomTabDisplayController.this.delayHide();
        }

        public void onQuitGetFocus() {
            BottomTabDisplayController.this.delayHide();
        }

        public void onSetingGetFocus() {
            BottomTabDisplayController.this.delayHide();
        }

        public void onViaPointGetFocus() {
            BottomTabDisplayController.this.delayHide();
        }

        public void onResumeNavigatorGetFocus() {
            BottomTabDisplayController.this.delayHide();
        }

        public void onRouteSwitchGetFocus() {
            BottomTabDisplayController.this.delayHide();
        }

        public void onEmptyPoiGetFocus() {
            BottomTabDisplayController.this.delayHide();
        }

        public void onMASwitchGetFocus() {
            BottomTabDisplayController.this.delayHide();
        }

        public void onBridgeSwitchGetFocus() {
            BottomTabDisplayController.this.delayHide();
        }
    }

    public static BottomTabDisplayController getInstance() {
        if (mInstance == null) {
            mInstance = new BottomTabDisplayController();
        }
        return mInstance;
    }

    public void onNaviRGFragmentVisiable() {
        delayHide();
        setSDKNaviStatusListener();
        if (VERSION.SDK_INT >= 21) {
            C1261k.a(this.mBottomTabHandler);
        }
    }

    public void onNaviRGFragmentInvisiable() {
        if (VERSION.SDK_INT >= 21) {
            C1261k.b(this.mBottomTabHandler);
        }
        if (!C1328h.a().g(C1328h.a().getNextFragmentType())) {
            show();
        }
    }

    public void delayHide() {
        if (isHideViable()) {
            this.mHandler.removeMessages(100);
            this.mHandler.sendEmptyMessageDelayed(100, BNOffScreenParams.MIN_ENTER_INTERVAL);
        }
    }

    public void show() {
        if (isShowViable()) {
            this.mHandler.removeMessages(100);
            this.mHandler.sendEmptyMessage(200);
        }
    }

    public void showThenDelayDismiss() {
        show();
        delayHide();
    }

    public void panelShow() {
        setPanelStatus(Boolean.valueOf(true));
    }

    public void panelHide() {
        setPanelStatus(Boolean.valueOf(false));
        delayHide();
    }

    private void setSDKNaviStatusListener() {
        BNavigator.getInstance().addSDKNaviStatusListener(this.mISDKNaviStatusListener);
    }

    private void removeSDKNaviStatusListener() {
        BNavigator.getInstance().removeSDKNaviStatusListener();
    }

    private BottomTabDisplayController() {
    }

    private void setPanelStatus(Boolean isShow) {
        synchronized (this.mPanelShowNumLock) {
            if (isShow.booleanValue()) {
                this.mPanelShowNum++;
            } else {
                this.mPanelShowNum--;
            }
            if (this.mPanelShowNum < 0) {
                this.mPanelShowNum = 0;
            }
        }
    }

    private Boolean isPanelShowing() {
        return Boolean.valueOf(false);
    }

    private boolean isShowViable() {
        return true;
    }

    private boolean isHideViable() {
        if (C1328h.a().getCurrentFragmentType() == 113 && !isPanelShowing().booleanValue()) {
            return true;
        }
        return false;
    }

    private void showTab() {
        if (mIsFunctionOn) {
            C1309g.a().b().setBottomBarStatus(true);
        }
    }

    private void hideTab() {
        if (mIsFunctionOn) {
            C1309g.a().b().setBottomBarStatus(false);
        }
    }
}
