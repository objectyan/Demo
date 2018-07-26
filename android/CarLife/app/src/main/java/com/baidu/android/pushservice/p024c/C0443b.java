package com.baidu.android.pushservice.p024c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.p032k.C0582b;
import java.io.File;

/* renamed from: com.baidu.android.pushservice.c.b */
public class C0443b {
    /* renamed from: a */
    protected Context f1385a;
    /* renamed from: b */
    protected String f1386b;
    /* renamed from: c */
    protected String f1387c;

    protected C0443b(Context context) {
        this.f1385a = context;
    }

    /* renamed from: a */
    public boolean m1912a() {
        Object a = new File(this.f1387c).exists() ? C0442a.m1909a(this.f1387c) : C0442a.m1908a();
        if (!TextUtils.isEmpty(a)) {
            try {
                byte[] a2 = C0582b.m2630a(a.getBytes());
                if (a2 != null && a2.length > 0) {
                    this.f1386b = new String(BaiduAppSSOJni.decryptAES(a2, a2.length, 0));
                }
            } catch (Exception e) {
            } catch (UnsatisfiedLinkError e2) {
            }
        }
        return !TextUtils.isEmpty(this.f1386b);
    }

    /* renamed from: a */
    public boolean m1913a(String str) {
        return C0442a.m1910a(this.f1387c, str);
    }
}
