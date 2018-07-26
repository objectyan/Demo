package com.baidu.mobstat;

import java.util.Comparator;

/* renamed from: com.baidu.mobstat.h */
class C3594h implements Comparator<C3595i> {
    /* renamed from: a */
    final /* synthetic */ C3593g f19640a;

    C3594h(C3593g c3593g) {
        this.f19640a = c3593g;
    }

    /* renamed from: a */
    public int m15746a(C3595i c3595i, C3595i c3595i2) {
        int i = c3595i2.f19642b - c3595i.f19642b;
        return i == 0 ? (c3595i.f19644d && c3595i2.f19644d) ? 0 : c3595i.f19644d ? -1 : c3595i2.f19644d ? 1 : i : i;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m15746a((C3595i) obj, (C3595i) obj2);
    }
}
