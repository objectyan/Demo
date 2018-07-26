package com.baidu.mapframework.common.mapview;

import com.baidu.mapframework.nirvana.concurrent.ConcurrentTask;
import com.baidu.platform.comapi.map.MapGLSurfaceView;

class MapViewFactory$2 extends ConcurrentTask {
    /* renamed from: a */
    final /* synthetic */ MapGLSurfaceView f18781a;
    /* renamed from: b */
    final /* synthetic */ int f18782b;
    /* renamed from: c */
    final /* synthetic */ int f18783c;
    /* renamed from: d */
    final /* synthetic */ MapViewFactory f18784d;

    MapViewFactory$2(MapViewFactory this$0, MapGLSurfaceView mapGLSurfaceView, int i, int i2) {
        this.f18784d = this$0;
        this.f18781a = mapGLSurfaceView;
        this.f18782b = i;
        this.f18783c = i2;
    }

    public void run() {
        MapViewFactory.a(this.f18784d, this.f18781a, this.f18782b, this.f18783c);
    }
}
