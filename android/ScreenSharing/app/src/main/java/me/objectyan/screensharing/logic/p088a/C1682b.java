package com.baidu.carlife.logic.p088a;

import java.util.HashMap;

/* compiled from: ComponentCenter */
/* renamed from: com.baidu.carlife.logic.a.b */
public abstract class C1682b<T> {
    /* renamed from: a */
    private HashMap<String, T> f5178a = new HashMap();

    /* renamed from: a */
    public T m6137a(String key) {
        if (this.f5178a == null || this.f5178a.isEmpty()) {
            return null;
        }
        return this.f5178a.get(key);
    }

    /* renamed from: a */
    public void m6139a(String key, T component) {
        this.f5178a.put(key, component);
    }

    /* renamed from: b */
    public void m6140b(String key) {
        this.f5178a.remove(key);
    }

    /* renamed from: a */
    public void m6138a() {
        this.f5178a.clear();
    }
}
