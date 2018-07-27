package com.baidu.carlife.p059c.p066e;

import com.baidu.carlife.p059c.p061f.C1140b.C1101b;
import com.baidu.carlife.p059c.p061f.C1140b.C1134a;
import com.baidu.carlife.p059c.p062b.C1099b;
import com.baidu.carlife.p059c.p063c.C1103a;
import java.util.Observable;
import java.util.Observer;

/* compiled from: BaseListPresenter */
/* renamed from: com.baidu.carlife.c.e.b */
public abstract class C1135b<T extends C1103a> implements C1134a<T>, Observer {
    /* renamed from: a */
    private C1099b<T> f2924a;
    /* renamed from: b */
    private C1101b f2925b;

    /* renamed from: c */
    public /* synthetic */ Object mo1432c(int i) {
        return m3824a(i);
    }

    /* renamed from: b */
    public C1099b<T> m3831b() {
        return this.f2924a;
    }

    /* renamed from: a */
    public void m3828a(C1099b<T> dataRepository) {
        this.f2924a = dataRepository;
    }

    /* renamed from: c */
    public C1101b m3832c() {
        return this.f2925b;
    }

    /* renamed from: a */
    public void m3829a(C1101b view) {
        this.f2925b = view;
    }

    /* renamed from: a */
    public T m3824a(int position) {
        return (C1103a) this.f2924a.mo1414b(position);
    }

    /* renamed from: d */
    public int mo1433d() {
        return this.f2924a.mo1412a();
    }

    /* renamed from: a */
    public void mo1424a() {
        this.f2924a.mo1415b();
    }

    /* renamed from: a */
    public void m3826a(int position, T element) {
        this.f2924a.mo1413a(position, element);
    }

    /* renamed from: b */
    public int mo1431b(int position) {
        return ((Integer) ((C1103a) this.f2924a.mo1414b(position)).mo1621a().m3762b()).intValue();
    }

    public void update(Observable observable, Object data) {
        this.f2925b.mo1416a(data);
    }
}
