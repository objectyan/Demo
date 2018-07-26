package com.baidu.navisdk.ui.routeguide.fsm;

import android.os.Bundle;

public abstract class RGState {
    public static final String CLASS_PREFIX = RGState.class.getSimpleName();
    public static final String METHOD_NAME_ENTER = "enter";
    public static final String METHOD_NAME_EXCUTE = "excute";
    public static final String METHOD_NAME_EXIT = "exit";
    public static final String PACKAGE_NAME = RGState.class.getPackage().getName();
    protected Bundle enterParams = null;

    protected abstract void onActionLayers();

    protected abstract void onActionMapStatus();

    protected abstract void onActionNaviEngine();

    protected abstract void onActionUI();

    public void enter() {
        enter(null);
    }

    public void enter(Bundle enterParams) {
        this.enterParams = enterParams;
    }

    public void excute() {
        excute(null);
    }

    public void excute(Bundle enterParams) {
        this.enterParams = enterParams;
        onActionUI();
        onActionNaviEngine();
        onActionLayers();
        onActionMapStatus();
    }

    public void exit() {
    }
}
