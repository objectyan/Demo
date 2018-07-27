package com.baidu.carlife.p059c.p064d;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.baidu.carlife.p059c.p064d.C1128g.C1127c;
import java.lang.reflect.InvocationTargetException;

/* compiled from: ViewModelProviders */
/* renamed from: com.baidu.carlife.c.d.h */
public class C1130h {
    @SuppressLint({"StaticFieldLeak"})
    /* renamed from: a */
    private static C1129a f2918a;

    /* compiled from: ViewModelProviders */
    /* renamed from: com.baidu.carlife.c.d.h$a */
    public static class C1129a extends C1127c {
        /* renamed from: a */
        private Application f2917a;

        public C1129a(@NonNull Application application) {
            this.f2917a = application;
        }

        @NonNull
        /* renamed from: a */
        public <T extends C1108f> T mo1423a(@NonNull Class<T> modelClass) {
            if (!C1109a.class.isAssignableFrom(modelClass)) {
                return super.mo1423a(modelClass);
            }
            try {
                return (C1108f) modelClass.getConstructor(new Class[]{Application.class}).newInstance(new Object[]{this.f2917a});
            } catch (NoSuchMethodException e) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e2);
            } catch (InstantiationException e3) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e3);
            } catch (InvocationTargetException e4) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e4);
            }
        }
    }

    /* renamed from: a */
    private static void m3799a(Application application) {
        if (f2918a == null) {
            f2918a = new C1129a(application);
        }
    }

    /* renamed from: a */
    private static Application m3796a(Activity activity) {
        Application application = activity.getApplication();
        if (application != null) {
            return application;
        }
        throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
    }

    /* renamed from: b */
    private static Activity m3800b(Fragment fragment) {
        Activity activity = fragment.getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Can't create ViewModelProvider for detached fragment");
    }

    @MainThread
    /* renamed from: a */
    public static C1128g m3797a(@NonNull Fragment fragment) {
        C1130h.m3799a(C1130h.m3796a(C1130h.m3800b(fragment)));
        return new C1128g(new C1131i(), f2918a);
    }

    @MainThread
    /* renamed from: a */
    public static C1128g m3798a(@NonNull FragmentActivity activity) {
        C1130h.m3799a(C1130h.m3796a((Activity) activity));
        return new C1128g(new C1131i(), f2918a);
    }
}
