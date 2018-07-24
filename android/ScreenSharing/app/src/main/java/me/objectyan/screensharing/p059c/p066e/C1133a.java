package com.baidu.carlife.p059c.p066e;

import com.baidu.carlife.p059c.C1102b.C1096a;
import com.baidu.carlife.p059c.p061f.C1139a.C1132a;
import com.baidu.carlife.p059c.p061f.C1140b.C1134a;

/* compiled from: BaseItemPresenter */
/* renamed from: com.baidu.carlife.c.e.a */
public abstract class C1133a<T> implements C1132a<T> {
    /* renamed from: a */
    private C1096a f2920a;
    /* renamed from: b */
    private C1134a f2921b;
    /* renamed from: c */
    private int f2922c;
    /* renamed from: d */
    private T f2923d;

    /* renamed from: b */
    protected abstract void mo1623b(T t);

    /* renamed from: a */
    public void mo1426a(C1096a viewHolder) {
        this.f2920a = viewHolder;
    }

    /* renamed from: a */
    public void mo1427a(C1134a listPresenter) {
        this.f2921b = listPresenter;
    }

    /* renamed from: a */
    public void mo1425a(int position) {
        this.f2922c = position;
    }

    /* renamed from: b */
    public C1096a mo1429b() {
        return this.f2920a;
    }

    /* renamed from: c */
    public C1134a m3816c() {
        return this.f2921b;
    }

    /* renamed from: d */
    public int m3817d() {
        return this.f2922c;
    }

    /* renamed from: e */
    public T m3818e() {
        return this.f2923d;
    }

    /* renamed from: a */
    public void mo1428a(T data) {
        this.f2923d = data;
        mo1623b(data);
    }

    /* renamed from: a */
    public void mo1424a() {
    }
}
