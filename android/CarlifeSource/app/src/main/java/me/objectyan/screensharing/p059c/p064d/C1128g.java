package com.baidu.carlife.p059c.p064d;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

/* compiled from: ViewModelProvider */
/* renamed from: com.baidu.carlife.c.d.g */
public class C1128g {
    /* renamed from: a */
    private static final String f2914a = "android.arch.lifecycle.ViewModelProvider.DefaultKey";
    /* renamed from: b */
    private final C1125a f2915b;
    /* renamed from: c */
    private final C1131i f2916c;

    /* compiled from: ViewModelProvider */
    /* renamed from: com.baidu.carlife.c.d.g$a */
    public interface C1125a {
        @NonNull
        /* renamed from: a */
        <T extends C1108f> T mo1423a(@NonNull Class<T> cls);
    }

    /* compiled from: ViewModelProvider */
    /* renamed from: com.baidu.carlife.c.d.g$b */
    private static final class C1126b {
        /* renamed from: a */
        private static final C1128g f2913a = new C1128g(new C1131i(), new C1127c());

        private C1126b() {
        }
    }

    /* compiled from: ViewModelProvider */
    /* renamed from: com.baidu.carlife.c.d.g$c */
    public static class C1127c implements C1125a {
        @NonNull
        /* renamed from: a */
        public <T extends C1108f> T mo1423a(@NonNull Class<T> modelClass) {
            try {
                return (C1108f) modelClass.newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e);
            } catch (IllegalAccessException e2) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e2);
            }
        }
    }

    /* renamed from: a */
    public static C1128g m3792a() {
        return C1126b.f2913a;
    }

    public C1128g(@NonNull C1131i store, @NonNull C1125a factory) {
        this.f2915b = factory;
        this.f2916c = store;
    }

    @NonNull
    /* renamed from: a */
    public <T extends C1108f> T m3793a(@NonNull Class<T> modelClass) {
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName != null) {
            return m3794a("android.arch.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, modelClass);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @MainThread
    @NonNull
    /* renamed from: a */
    public <T extends C1108f> T m3794a(@NonNull String key, @NonNull Class<T> modelClass) {
        C1108f viewModel = this.f2916c.m3801a(key);
        if (modelClass.isInstance(viewModel)) {
            return viewModel;
        }
        if (viewModel != null) {
            viewModel = this.f2915b.mo1423a(modelClass);
            this.f2916c.m3803a(key, viewModel);
        } else {
            viewModel = this.f2915b.mo1423a(modelClass);
            this.f2916c.m3803a(key, viewModel);
        }
        return viewModel;
    }
}
