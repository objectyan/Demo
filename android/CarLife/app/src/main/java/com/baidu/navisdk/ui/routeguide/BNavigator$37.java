package com.baidu.navisdk.ui.routeguide;

import android.os.Bundle;
import android.os.Message;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviSwitchManager;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviSwitchManager.NormalNaviSwitchSlightListener;
import com.baidu.navisdk.lightnavi.utils.LightNaviPageJumpHelper;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

class BNavigator$37 implements NormalNaviSwitchSlightListener {
    final /* synthetic */ BNavigator this$0;

    BNavigator$37(BNavigator this$0) {
        this.this$0 = this$0;
    }

    public void onSwitchNormalNaviToSLight(Message msg) {
        int subType = msg.arg1;
        LogUtil.m15791e("wangyang", "onSwithSLightToNavi type = " + subType);
        if (subType == 2) {
            BNLightNaviManager.getInstance().switch2AlternativeRoute(2);
            RGMapModeViewController.getInstance().removeSlightSwitchMsg();
            RGMapModeViewController.getInstance().setSwitchProgressDialogCloseGone();
        } else if (subType == 3) {
            RGMapModeViewController.getInstance().dismissSwitchProgressDialog();
            TipTool.onCreateToastDialog(BNavigator.access$000(this.this$0), JarUtils.getResources().getString(C4048R.string.ipo_navi_switch_fail));
        } else if (subType == 4) {
            RGMapModeViewController.getInstance().dismissSwitchProgressDialog();
            TipTool.onCreateToastDialog(BNavigator.access$000(this.this$0), JarUtils.getResources().getString(C4048R.string.ipo_navi_switch_fail));
        } else if (subType == 0) {
            RGMapModeViewController.getInstance().dismissSwitchProgressDialog();
            BNLightNaviSwitchManager.getInstance().setHaveSwitched(true);
            if (this.this$0.mRGSubViewListener != null) {
                LogUtil.m15791e("wangyang", "onSwitchNormalNaviToSLight onQuitNaviGuide");
                this.this$0.mRGSubViewListener.onQuitNaviGuide(false, true);
                return;
            }
            LogUtil.m15791e("wangyang", "onSwitchNormalNaviToSLight showStatusBar");
            BNRoutePlaner.getInstance().SetCalcRouteNetMode(1);
            BNLightNaviManager.getInstance().setSwitching(true);
            Bundle bundle = new Bundle();
            bundle.putBoolean("switch", true);
            LightNaviPageJumpHelper.getInstance().onPageJump(2, bundle);
        } else if (subType == 1) {
            RGMapModeViewController.getInstance().dismissSwitchProgressDialog();
            TipTool.onCreateToastDialog(BNavigator.access$000(this.this$0), JarUtils.getResources().getString(C4048R.string.ipo_navi_switch_fail));
        }
    }
}
