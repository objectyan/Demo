package com.baidu.navisdk.ui.routeguide.fsm;

import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.model.RGMultiRouteModel;
import com.baidu.navisdk.util.common.LogUtil;

public class RGStateHUD extends RGState {
    protected void onActionUI() {
        if (RGMultiRouteModel.getInstance().isSwitchButtonShowing) {
            RGMultiRouteModel.getInstance().isSwitchButtonShowing = false;
            BNMapController.getInstance().recoveryHighLightRoute();
        }
        RGControlPanelModel.mIsMenuVisible = false;
        RGViewController.getInstance().showHUDDialog(false);
    }

    protected void onActionNaviEngine() {
        RGEngineControl.getInstance().disableManuSound();
        BNRouteGuider.getInstance().setHUDEnabled(true);
    }

    protected void onActionLayers() {
    }

    protected void onActionMapStatus() {
    }

    public void enter() {
        RGViewController.getInstance().initHUDView(false);
        super.enter();
    }

    public void excute() {
        super.excute();
        LogUtil.m15791e(ModuleName.ROUTEGUIDE, "excute by reflection");
    }

    public void exit() {
        BNRouteGuider.getInstance().setHUDEnabled(false);
        RGViewController.getInstance().hideHUDDialog();
        super.exit();
    }
}
