package com.baidu.location.p191d;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.baidu.location.C3377f;

/* renamed from: com.baidu.location.d.i */
public class C3304i {
    /* renamed from: a */
    private static Object f17930a = new Object();
    /* renamed from: b */
    private static C3304i f17931b = null;
    /* renamed from: c */
    private SharedPreferences f17932c = null;

    public C3304i() {
        if (this.f17932c == null) {
            this.f17932c = C3377f.getServiceContext().getSharedPreferences("MapCoreServicePreIA", 0);
        }
    }

    /* renamed from: a */
    public static C3304i m13904a() {
        C3304i c3304i;
        synchronized (f17930a) {
            if (f17931b == null) {
                f17931b = new C3304i();
            }
            c3304i = f17931b;
        }
        return c3304i;
    }

    /* renamed from: a */
    public synchronized int m13905a(String str, int i) {
        if (this.f17932c != null) {
            try {
                i = this.f17932c.getInt(str, i);
            } catch (Exception e) {
            }
        }
        return i;
    }

    /* renamed from: a */
    public synchronized long m13906a(String str, long j) {
        if (this.f17932c != null) {
            try {
                j = this.f17932c.getLong(str, j);
            } catch (Exception e) {
            }
        }
        return j;
    }

    /* renamed from: a */
    public synchronized String m13907a(String str, String str2) {
        if (this.f17932c != null) {
            try {
                str2 = this.f17932c.getString(str, str2);
            } catch (Exception e) {
            }
        }
        return str2;
    }

    /* renamed from: b */
    public synchronized void m13908b(String str, int i) {
        if (this.f17932c != null) {
            try {
                Editor edit = this.f17932c.edit();
                edit.putInt(str, i);
                edit.commit();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: b */
    public synchronized void m13909b(String str, long j) {
        if (this.f17932c != null) {
            try {
                Editor edit = this.f17932c.edit();
                edit.putLong(str, j);
                edit.commit();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: b */
    public synchronized void m13910b(String str, String str2) {
        if (this.f17932c != null) {
            try {
                Editor edit = this.f17932c.edit();
                edit.putString(str, str2);
                edit.commit();
            } catch (Exception e) {
            }
        }
    }
}
