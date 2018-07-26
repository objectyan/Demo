package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public class PoiBkgOverlay extends InnerOverlay {
    public PoiBkgOverlay() {
        super(16);
    }

    public PoiBkgOverlay(AppBaseMap baseMap) {
        super(16, baseMap);
    }
}
