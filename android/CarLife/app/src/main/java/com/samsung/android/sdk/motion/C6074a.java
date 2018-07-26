package com.samsung.android.sdk.motion;

import android.hardware.scontext.SContext;
import android.hardware.scontext.SContextActivityBatch;
import android.hardware.scontext.SContextActivityTracker;
import android.hardware.scontext.SContextEvent;
import android.hardware.scontext.SContextListener;
import com.samsung.android.sdk.motion.SmotionActivity.ChangeListener;
import com.samsung.android.sdk.motion.SmotionActivity.Info;

/* renamed from: com.samsung.android.sdk.motion.a */
final class C6074a implements SContextListener {
    /* renamed from: a */
    private /* synthetic */ SmotionActivity f24729a;
    /* renamed from: b */
    private final /* synthetic */ ChangeListener f24730b;

    C6074a(SmotionActivity smotionActivity, ChangeListener changeListener) {
        this.f24729a = smotionActivity;
        this.f24730b = changeListener;
    }

    public final void onSContextChanged(SContextEvent sContextEvent) {
        int i = 0;
        SContext sContext = sContextEvent.scontext;
        if (sContext.getType() == 25) {
            SContextActivityTracker activityTrackerContext = sContextEvent.getActivityTrackerContext();
            int status = activityTrackerContext.getStatus();
            int accuracy = activityTrackerContext.getAccuracy();
            this.f24729a.f24669a = SmotionActivity.m21604a(this.f24729a, activityTrackerContext.getTimeStamp(), status, accuracy);
            this.f24730b.onChanged(1, new Info[]{this.f24729a.f24669a});
            if (!this.f24729a.f24677j) {
                this.f24729a.f24677j = true;
            }
            this.f24729a.f24678k = true;
        } else if (sContext.getType() == 26) {
            SContextActivityBatch activityBatchContext = sContextEvent.getActivityBatchContext();
            int[] status2 = activityBatchContext.getStatus();
            int[] accuracy2 = activityBatchContext.getAccuracy();
            long[] timeStamp = activityBatchContext.getTimeStamp();
            if (status2 != null && accuracy2 != null) {
                int length = status2.length;
                int i2 = 0;
                while (i2 < length) {
                    if (timeStamp[i2] > this.f24729a.f24671c) {
                        break;
                    }
                    i2++;
                }
                i2 = 0;
                length = status2.length - i2;
                Info[] infoArr = new Info[length];
                while (i < length) {
                    infoArr[i] = SmotionActivity.m21604a(this.f24729a, timeStamp[i + i2], status2[i + i2], accuracy2[i + i2]);
                    i++;
                }
                this.f24730b.onChanged(2, infoArr);
            }
        }
    }
}
