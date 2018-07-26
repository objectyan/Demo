package com.baidu.platform.comapi.dataengine;

import android.os.Message;
import com.baidu.mapframework.nirvana.looper.MainLooperHandler;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;

class MapDataEngine$1 extends MainLooperHandler {
    /* renamed from: a */
    final /* synthetic */ MapDataEngine f19804a;

    MapDataEngine$1(MapDataEngine this$0, Module arg0, ScheduleConfig arg1) {
        this.f19804a = this$0;
        super(arg0, arg1);
    }

    public void onMessage(Message msg) {
        if (MapDataEngine.a(this.f19804a) != null) {
            MapDataEngine.a(this.f19804a).m15843a(msg);
        }
    }
}
