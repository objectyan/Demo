package com.baidu.carlife.view;

import com.baidu.carlife.core.C1260i;
import java.util.Calendar;

/* compiled from: OnPreventFastSoftInputKeyListener */
/* renamed from: com.baidu.carlife.view.e */
public abstract class C2323e implements C2322f {
    /* renamed from: a */
    private static final String f7607a = "CarlifeTouchManager#KeyListener";
    /* renamed from: b */
    private static final int f7608b = 300;
    /* renamed from: c */
    private long f7609c = 0;

    /* renamed from: b */
    public abstract void mo1823b(String str);

    /* renamed from: a */
    public void mo1822a(String nameString) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        if (currentTime - this.f7609c > 300) {
            C1260i.m4435b(f7607a, "...........onKey key=" + nameString);
            this.f7609c = currentTime;
            mo1823b(nameString);
            return;
        }
        C1260i.m4445e(f7607a, "you click too fast, need to throw away, key=" + nameString);
    }
}
