package com.baidu.mapframework.nirvana.concurrent;

import com.baidu.mapframework.nirvana.C3480g;

public abstract class ScheduleTask extends C3480g implements Runnable {
    /* renamed from: a */
    private long f19152a;

    public ScheduleTask(long delay) {
        this.f19152a = delay;
    }

    public long getDelay() {
        return this.f19152a;
    }
}
