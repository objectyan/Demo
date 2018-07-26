package com.baidu.baidunavis.control;

import android.os.Message;
import com.baidu.mapframework.nirvana.C3541e;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.p205b.C3533c;
import com.baidu.mapframework.nirvana.schedule.DataTaskType;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.mapframework.nirvana.schedule.ScheduleTag;
import com.baidu.navisdk.util.worker.loop.IBNPerformceFramework;

public class NavPerformanceFramework implements IBNPerformceFramework {
    private static final String TAG = NavPerformanceFramework.class.getSimpleName();
    private ScheduleConfig config = new ScheduleConfig(DataTaskType.forUpdateData(), ScheduleTag.NULL);
    private Module module = Module.NAV_MODULE;

    public void runInLooperBuffer(Runnable runnable) {
        C3541e.c().run(runnable);
    }

    public void markSubmit(Message message) {
        C3541e.b().a(C3533c.f19138c, message, this.module, this.config);
    }

    public void markRunning(Message message) {
        C3541e.b().a(message);
    }

    public void markFinish(Message message) {
        C3541e.b().b(message);
    }
}
