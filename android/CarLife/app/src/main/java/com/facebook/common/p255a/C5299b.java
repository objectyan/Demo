package com.facebook.common.p255a;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import com.facebook.common.internal.C5350k;
import java.lang.ref.WeakReference;

/* compiled from: ActivityListenerManager */
/* renamed from: com.facebook.common.a.b */
public class C5299b {

    /* compiled from: ActivityListenerManager */
    /* renamed from: com.facebook.common.a.b$a */
    private static class C5298a extends C5297c {
        /* renamed from: a */
        private final WeakReference<C5296a> f21871a;

        public C5298a(C5296a activityListener) {
            this.f21871a = new WeakReference(activityListener);
        }

        /* renamed from: a */
        public void mo3987a(Activity activity) {
            C5296a activityVisibilityListener = m18072g(activity);
            if (activityVisibilityListener != null) {
                activityVisibilityListener.mo3987a(activity);
            }
        }

        /* renamed from: f */
        public void mo3992f(Activity activity) {
            C5296a activityVisibilityListener = m18072g(activity);
            if (activityVisibilityListener != null) {
                activityVisibilityListener.mo3992f(activity);
            }
        }

        /* renamed from: b */
        public void mo3988b(Activity activity) {
            C5296a activityVisibilityListener = m18072g(activity);
            if (activityVisibilityListener != null) {
                activityVisibilityListener.mo3988b(activity);
            }
        }

        /* renamed from: e */
        public void mo3991e(Activity activity) {
            C5296a activityVisibilityListener = m18072g(activity);
            if (activityVisibilityListener != null) {
                activityVisibilityListener.mo3991e(activity);
            }
        }

        /* renamed from: c */
        public void mo3989c(Activity activity) {
            C5296a activityVisibilityListener = m18072g(activity);
            if (activityVisibilityListener != null) {
                activityVisibilityListener.mo3989c(activity);
            }
        }

        /* renamed from: d */
        public void mo3990d(Activity activity) {
            C5296a activityVisibilityListener = m18072g(activity);
            if (activityVisibilityListener != null) {
                activityVisibilityListener.mo3990d(activity);
            }
        }

        /* renamed from: g */
        private C5296a m18072g(Activity activity) {
            C5296a activityVisibilityListener = (C5296a) this.f21871a.get();
            if (activityVisibilityListener == null) {
                C5350k.m18315a(activity instanceof C5300d);
                ((C5300d) activity).m18081b(this);
            }
            return activityVisibilityListener;
        }
    }

    /* renamed from: a */
    public static void m18079a(C5296a activityListener, Context context) {
        if (!(context instanceof C5300d) && (context instanceof ContextWrapper)) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context instanceof C5300d) {
            ((C5300d) context).m18080a(new C5298a(activityListener));
        }
    }
}
