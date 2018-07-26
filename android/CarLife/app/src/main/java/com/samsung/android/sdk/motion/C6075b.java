package com.samsung.android.sdk.motion;

import android.hardware.scontext.SContextActivityNotification;
import android.hardware.scontext.SContextEvent;
import android.hardware.scontext.SContextListener;
import com.samsung.android.sdk.motion.SmotionActivityNotification.ChangeListener;

/* renamed from: com.samsung.android.sdk.motion.b */
final class C6075b implements SContextListener {
    /* renamed from: a */
    private /* synthetic */ SmotionActivityNotification f24731a;
    /* renamed from: b */
    private final /* synthetic */ ChangeListener f24732b;

    C6075b(SmotionActivityNotification smotionActivityNotification, ChangeListener changeListener) {
        this.f24731a = smotionActivityNotification;
        this.f24732b = changeListener;
    }

    public final void onSContextChanged(SContextEvent sContextEvent) {
        if (sContextEvent.scontext.getType() == 27) {
            SContextActivityNotification activityNotificationContext = sContextEvent.getActivityNotificationContext();
            int status = activityNotificationContext.getStatus();
            int accuracy = activityNotificationContext.getAccuracy();
            this.f24732b.onChanged(SmotionActivityNotification.m21619a(this.f24731a, activityNotificationContext.getTimeStamp(), status, accuracy));
        }
    }
}
