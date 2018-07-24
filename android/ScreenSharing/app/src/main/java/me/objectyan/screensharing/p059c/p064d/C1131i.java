package com.baidu.carlife.p059c.p064d;

import java.util.HashMap;

/* compiled from: ViewModelStore */
/* renamed from: com.baidu.carlife.c.d.i */
public class C1131i {
    /* renamed from: a */
    private final HashMap<String, C1108f> f2919a = new HashMap();

    /* renamed from: a */
    final void m3803a(String key, C1108f viewModel) {
        C1108f oldViewModel = (C1108f) this.f2919a.get(key);
        if (oldViewModel != null) {
            oldViewModel.mo1628b();
        }
        this.f2919a.put(key, viewModel);
    }

    /* renamed from: a */
    final C1108f m3801a(String key) {
        return (C1108f) this.f2919a.get(key);
    }

    /* renamed from: a */
    public final void m3802a() {
        for (C1108f vm : this.f2919a.values()) {
            vm.mo1628b();
        }
        this.f2919a.clear();
    }
}
