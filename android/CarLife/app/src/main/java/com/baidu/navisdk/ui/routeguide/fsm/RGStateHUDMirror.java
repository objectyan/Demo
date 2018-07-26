package com.baidu.navisdk.ui.routeguide.fsm;

import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.util.common.LogUtil;

public class RGStateHUDMirror extends RGState {
    protected void onActionUI() {
        RGViewController.getInstance().showHUDDialog(true);
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
        RGViewController.getInstance().initHUDView(true);
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
