package com.baidu.mobstat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import java.io.Closeable;
import java.util.ArrayList;

/* renamed from: com.baidu.mobstat.x */
abstract class C3586x implements Closeable {
    /* renamed from: a */
    private af f19384a;

    /* renamed from: a */
    public abstract long mo2722a(String str, String str2);

    /* renamed from: a */
    public abstract ArrayList<C3608w> mo2723a(int i, int i2);

    /* renamed from: b */
    public abstract boolean mo2724b(long j);

    public C3586x(String str, String str2) {
        Context aeVar = new ae();
        this.f19384a = new af(aeVar, str);
        if (aeVar.getDatabasePath(".confd") != null) {
            m15306a(str2);
        }
    }

    /* renamed from: a */
    private void m15306a(String str) {
        this.f19384a.m15303a(str);
    }

    /* renamed from: a */
    public synchronized boolean m15312a() {
        boolean a;
        try {
            a = this.f19384a.m15304a();
        } catch (Throwable e) {
            bd.m15432b(e);
            a = false;
        }
        return a;
    }

    public synchronized void close() {
        try {
            this.f19384a.close();
        } catch (Throwable e) {
            bd.m15432b(e);
        }
    }

    /* renamed from: b */
    protected int m15314b() {
        return this.f19384a.m15305b();
    }

    /* renamed from: a */
    protected Cursor m15309a(String str, int i, int i2) {
        return this.f19384a.m15302a(null, null, null, null, null, str + " desc", i2 + ", " + i);
    }

    /* renamed from: a */
    protected Cursor m15310a(String str, String str2, String str3, int i) {
        String str4 = str + "=? ";
        String[] strArr = new String[]{str2};
        return this.f19384a.m15302a(null, str4, strArr, null, null, str3 + " desc", i + "");
    }

    /* renamed from: a */
    protected long m15307a(ContentValues contentValues) {
        return this.f19384a.m15301a(null, contentValues);
    }

    /* renamed from: a */
    protected boolean m15313a(long j) {
        String[] strArr = new String[]{j + ""};
        if (this.f19384a.m15300a("_id=? ", strArr) > 0) {
            return true;
        }
        return false;
    }
}
