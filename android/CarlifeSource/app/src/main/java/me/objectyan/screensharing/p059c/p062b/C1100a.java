package com.baidu.carlife.p059c.p062b;

import com.baidu.carlife.p059c.p063c.C1103a;
import com.baidu.carlife.p059c.p067g.C1148b;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/* compiled from: BaseDataRepository */
/* renamed from: com.baidu.carlife.c.b.a */
public abstract class C1100a<T extends C1103a> extends Observable implements C1099b<T> {
    /* renamed from: a */
    private List<T> f2878a = new ArrayList();

    /* compiled from: BaseDataRepository */
    /* renamed from: com.baidu.carlife.c.b.a$1 */
    class C10981 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C1100a f2877a;

        /* compiled from: BaseDataRepository */
        /* renamed from: com.baidu.carlife.c.b.a$1$1 */
        class C10971 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C10981 f2876a;

            C10971(C10981 this$1) {
                this.f2876a = this$1;
            }

            public void run() {
                this.f2876a.f2877a.notifyObservers();
            }
        }

        C10981(C1100a this$0) {
            this.f2877a = this$0;
        }

        public void run() {
            this.f2877a.f2878a = this.f2877a.mo1620c();
            C1148b.m3848a().m3849a(new C10971(this));
        }
    }

    /* renamed from: c */
    public abstract List<T> mo1620c();

    /* renamed from: b */
    public /* synthetic */ Object mo1414b(int i) {
        return m3716a(i);
    }

    /* renamed from: a */
    public int mo1412a() {
        return this.f2878a.size();
    }

    /* renamed from: a */
    public T m3716a(int position) {
        return (C1103a) this.f2878a.get(position);
    }

    /* renamed from: a */
    public void m3717a(int index, T element) {
        this.f2878a.set(index, element);
        notifyObservers(element);
    }

    /* renamed from: b */
    public void mo1415b() {
        C1148b.m3848a().m3851c(new C10981(this));
    }
}
