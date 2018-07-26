package com.baidu.platform.comapi.map;

import com.baidu.platform.comjni.map.basemap.AppBaseMap;

public class FavoriteOverlay extends InnerOverlay {
    public FavoriteOverlay() {
        super(15);
    }

    public FavoriteOverlay(AppBaseMap baseMap) {
        super(15, baseMap);
    }
}
