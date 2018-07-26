package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public class RouteLabelOverlay extends InnerOverlay {
    public RouteLabelOverlay() {
        super(31);
    }

    public RouteLabelOverlay(AppBaseMap baseMap) {
        super(31, baseMap);
    }
}
