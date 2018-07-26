package com.samsung.android.sdk.motion;

import android.hardware.scontext.SContextEvent;
import android.hardware.scontext.SContextListener;
import android.hardware.scontext.SContextPedometer;
import com.samsung.android.sdk.motion.SmotionPedometer.ChangeListener;
import com.samsung.android.sdk.motion.SmotionPedometer.Info;

/* renamed from: com.samsung.android.sdk.motion.d */
final class C6077d implements SContextListener {
    /* renamed from: a */
    private /* synthetic */ SmotionPedometer f24734a;
    /* renamed from: b */
    private final /* synthetic */ ChangeListener f24735b;

    C6077d(SmotionPedometer smotionPedometer, ChangeListener changeListener) {
        this.f24734a = smotionPedometer;
        this.f24735b = changeListener;
    }

    public final void onSContextChanged(SContextEvent sContextEvent) {
        int i = 3;
        if (sContextEvent.scontext.getType() == 2) {
            Info info = new Info();
            long nanoTime = System.nanoTime();
            SContextPedometer pedometerContext = sContextEvent.getPedometerContext();
            info.f24712l = nanoTime;
            info.f24709i = pedometerContext.getCumulativeDistance();
            info.f24710j = pedometerContext.getCumulativeCalorie();
            info.f24708h = pedometerContext.getSpeed();
            Info.m21627a(info, 0, pedometerContext.getCumulativeTotalStepCount());
            Info.m21627a(info, 5, pedometerContext.getCumulativeRunDownStepCount());
            Info.m21627a(info, 4, pedometerContext.getCumulativeRunUpStepCount());
            Info.m21627a(info, 6, pedometerContext.getCumulativeRunStepCount());
            Info.m21627a(info, 2, pedometerContext.getCumulativeWalkDownStepCount());
            Info.m21627a(info, 1, pedometerContext.getCumulativeWalkUpStepCount());
            Info.m21627a(info, 3, pedometerContext.getCumulativeWalkStepCount());
            switch (pedometerContext.getStepStatus()) {
                case -1:
                    i = -1;
                    break;
                case 0:
                    i = 0;
                    break;
                case 3:
                    break;
                case 4:
                    i = 6;
                    break;
                case 6:
                    i = 1;
                    break;
                case 7:
                    i = 2;
                    break;
                case 8:
                    i = 4;
                    break;
                case 9:
                    i = 5;
                    break;
                default:
                    i = -1;
                    break;
            }
            info.f24711k = i;
            this.f24734a.f24717a = info;
            this.f24734a.f24725j = true;
            this.f24735b.onChanged(info);
            this.f24734a.f24724i = true;
        }
    }
}
