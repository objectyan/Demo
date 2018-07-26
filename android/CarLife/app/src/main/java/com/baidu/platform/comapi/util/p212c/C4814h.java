package com.baidu.platform.comapi.util.p212c;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: InfoList */
/* renamed from: com.baidu.platform.comapi.util.c.h */
public class C4814h implements C4800g {
    /* renamed from: a */
    private LinkedList<C4800g> f19941a = new LinkedList();

    /* renamed from: a */
    public void mo3723a(Context context) {
        Iterator it = this.f19941a.iterator();
        while (it.hasNext()) {
            ((C4800g) it.next()).mo3723a(context);
        }
    }

    /* renamed from: a */
    public C4814h m15978a(C4800g info) {
        this.f19941a.add(info);
        return this;
    }
}
