package com.baidu.navisdk.ui.routeguide.control;

import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;

public class RGViewController {
    public static RGMapModeViewController getInstance() {
        return RGMapModeViewController.getInstance();
    }

    public static void destory() {
        RGMapModeViewController.destory();
    }
}
