package com.baidu.mapframework.common.mapview;

import com.baidu.mapframework.common.config.GlobalConfig;
import com.baidu.mapframework.nirvana.looper.LooperTask;

class MapViewFactory$1 extends LooperTask {
    /* renamed from: a */
    final /* synthetic */ MapViewFactory f18780a;

    MapViewFactory$1(MapViewFactory this$0) {
        this.f18780a = this$0;
    }

    public void run() {
        if (!MapViewFactory.a(this.f18780a) && MapViewFactory.a() != null) {
            MapViewFactory.b(this.f18780a).set3DGestureEnable(GlobalConfig.getInstance().isOpen3D());
            MapViewFactory.b(this.f18780a).setOverlookGestureEnable(GlobalConfig.getInstance().isOpenOverlook());
            MapViewFactory.a(this.f18780a, MapViewFactory.a());
            MapViewFactory.a(this.f18780a, true);
        }
    }
}
