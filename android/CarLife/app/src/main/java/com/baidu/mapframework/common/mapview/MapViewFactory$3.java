package com.baidu.mapframework.common.mapview;

import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.mapframework.common.util.StorageSettings;
import com.baidu.platform.comapi.util.C2911f;
import java.util.concurrent.Callable;

class MapViewFactory$3 implements Callable {
    /* renamed from: a */
    final /* synthetic */ MapViewFactory f18785a;

    MapViewFactory$3(MapViewFactory this$0) {
        this.f18785a = this$0;
    }

    public Object call() throws Exception {
        StorageSettings.getInstance().initialize(BaiduNaviApplication.getInstance());
        MapViewFactory.c(this.f18785a);
        MapViewFactory.b(this.f18785a).onResume();
        C2911f.e("MapView", "initMapController");
        return MapViewFactory.b(this.f18785a);
    }
}
