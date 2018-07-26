package com.baidu.platform.comapi.map;

import android.os.Bundle;

public class NaviNodeOverlayer extends InnerOverlay {
    static NaviNodeOverlayer naviNodeOverlayer = null;

    public NaviNodeOverlayer(int emapNaviNode) {
        super(emapNaviNode);
    }

    public static InnerOverlay getInstance() {
        if (naviNodeOverlayer == null) {
            naviNodeOverlayer = new NaviNodeOverlayer(25);
        }
        return naviNodeOverlayer;
    }

    public void setData(String strJson) {
    }

    public String getData() {
        return null;
    }

    public Bundle getParam() {
        return null;
    }

    public void clear() {
    }
}
