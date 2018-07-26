package com.baidu.mobstat;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class bg implements ActivityLifecycleCallbacks {
    /* renamed from: a */
    final /* synthetic */ bf f19446a;

    bg(bf bfVar) {
        this.f19446a = bfVar;
    }

    public void onActivityResumed(Activity activity) {
        ch.m15571a().m15588a(activity.getApplicationContext(), System.currentTimeMillis());
        if (this.f19446a.f19444c) {
            this.f19446a.m15444a(activity, true);
            this.f19446a.m15440a(activity);
        }
        ch.m15571a().m15604f();
    }

    public void onActivityPaused(Activity activity) {
        ch.m15571a().m15599b(activity.getApplicationContext(), System.currentTimeMillis());
        if (this.f19446a.f19444c) {
            this.f19446a.m15444a(activity, false);
        }
        ch.m15571a().m15587a(activity.getApplicationContext());
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityStarted(Activity activity) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
        String name = activity.getClass().getName();
        synchronized (this.f19446a.f19443a) {
            this.f19446a.f19443a.remove(name);
        }
    }
}
