package com.baidu.android.pushservice.p023b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.p031j.C0562b;
import com.baidu.android.pushservice.p031j.C0578p;
import com.baidu.android.pushservice.p032k.C0582b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.baidu.android.pushservice.b.h */
public class C0439h extends C0436e {
    /* renamed from: d */
    private static volatile C0439h f1377d;
    /* renamed from: e */
    private static String f1378e = "SDKClientManager";

    private C0439h(Context context) {
        super(context, C0433c.SDK_CLIENT);
    }

    /* renamed from: a */
    private C0438g m1901a(String str, ArrayList<C0431a> arrayList) {
        C0438g c0438g = null;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            C0431a c0431a = (C0431a) it.next();
            if (!TextUtils.isEmpty(c0431a.m1861a()) && c0431a.m1861a().equals(str) && C0578p.m2558c(this.b, c0431a.m1867c())) {
                if (c0438g == null || c0438g.m1868d() < c0431a.m1868d()) {
                    C0438g c0438g2 = (C0438g) c0431a;
                    this.a.add(c0438g2);
                    return c0438g2;
                }
            }
        }
        return c0438g;
    }

    /* renamed from: a */
    public static synchronized C0439h m1902a(Context context) {
        C0439h c0439h;
        synchronized (C0439h.class) {
            if (f1377d == null) {
                f1377d = new C0439h(context);
            } else {
                f1377d.b = context.getApplicationContext();
            }
            c0439h = f1377d;
        }
        return c0439h;
    }

    /* renamed from: a */
    public String m1903a(C0438g c0438g) {
        synchronized (this.a) {
            Object obj;
            if (!TextUtils.isEmpty(c0438g.m1861a())) {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    C0431a c0431a = (C0431a) it.next();
                    if (c0431a.m1864b().equals(c0438g.m1864b())) {
                        c0431a.m1866b(c0438g.c);
                        c0431a.m1863a(c0438g.m1861a());
                        obj = 1;
                        break;
                    }
                }
            }
            obj = null;
            if (obj != null) {
                try {
                    String a = C0582b.m2629a(BaiduAppSSOJni.encryptAES(mo1281a(this.a), 0), "utf-8");
                    C0562b.m2422a(this.b, "com.baidu.push.sdkr", a);
                    return a;
                } catch (Exception e) {
                    return null;
                } catch (UnsatisfiedLinkError e2) {
                    return null;
                }
            }
        }
    }

    /* renamed from: a */
    public String mo1281a(List<C0431a> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            C0431a c0431a = (C0431a) list.get(i);
            stringBuffer.append(c0431a.m1864b());
            stringBuffer.append(",");
            stringBuffer.append(c0431a.m1867c());
            stringBuffer.append(",");
            stringBuffer.append(c0431a.m1868d());
            stringBuffer.append(",");
            stringBuffer.append(c0431a.m1861a());
            if (i != list.size() - 1) {
                stringBuffer.append(";");
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public ArrayList<C0431a> mo1282a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<C0431a> arrayList = new ArrayList();
        if (TextUtils.isEmpty(str)) {
            return arrayList;
        }
        for (String trim : str.trim().split(";")) {
            String[] split = trim.trim().trim().split(",");
            if (split.length >= 2) {
                C0438g c0438g = new C0438g(split[0], split[1]);
                try {
                    if (split.length == 3) {
                        c0438g.m1862a(Integer.parseInt(split[2]));
                    } else if (split.length == 4) {
                        c0438g.m1862a(Integer.parseInt(split[2]));
                        c0438g.m1863a(split[3]);
                    }
                } catch (Exception e) {
                }
                arrayList.add(c0438g);
            }
        }
        return arrayList;
    }

    /* renamed from: e */
    public C0438g m1906e(String str) {
        C0438g a = m1901a(str, this.a);
        if (a == null) {
            try {
                Object a2 = C0562b.m2419a(this.b, "com.baidu.push.sdkr");
                if (!TextUtils.isEmpty(a2)) {
                    byte[] a3 = C0582b.m2630a(a2.getBytes());
                    a = m1901a(str, mo1282a(new String(BaiduAppSSOJni.decryptAES(a3, a3.length, 0))));
                }
            } catch (Exception e) {
            } catch (UnsatisfiedLinkError e2) {
            }
        }
        return a;
    }
}
