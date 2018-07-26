package com.tencent.wxop.stat;

import android.content.Context;
import com.tencent.wxop.stat.p291b.C6144m;
import java.util.Timer;
import java.util.TimerTask;

public class ar {
    /* renamed from: b */
    private static volatile ar f24853b = null;
    /* renamed from: a */
    private Timer f24854a = null;
    /* renamed from: c */
    private Context f24855c = null;

    private ar(Context context) {
        this.f24855c = context.getApplicationContext();
        this.f24854a = new Timer(false);
    }

    /* renamed from: a */
    public static ar m21801a(Context context) {
        if (f24853b == null) {
            synchronized (ar.class) {
                if (f24853b == null) {
                    f24853b = new ar(context);
                }
            }
        }
        return f24853b;
    }

    /* renamed from: a */
    public void m21802a() {
        if (C6156f.m21971a() == C6158h.PERIOD) {
            long m = (long) ((C6156f.m22034m() * 60) * 1000);
            if (C6156f.m21997b()) {
                C6144m.m21872b().m21825b("setupPeriodTimer delay:" + m);
            }
            m21803a(new as(this), m);
        }
    }

    /* renamed from: a */
    public void m21803a(TimerTask timerTask, long j) {
        if (this.f24854a != null) {
            if (C6156f.m21997b()) {
                C6144m.m21872b().m21825b("setupPeriodTimer schedule delay:" + j);
            }
            this.f24854a.schedule(timerTask, j);
        } else if (C6156f.m21997b()) {
            C6144m.m21872b().m21830f("setupPeriodTimer schedule timer == null");
        }
    }
}
