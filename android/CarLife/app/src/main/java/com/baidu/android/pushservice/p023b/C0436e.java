package com.baidu.android.pushservice.p023b;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.p025d.C0472c;
import com.baidu.android.pushservice.p025d.C0473d;
import com.baidu.android.pushservice.p031j.C0562b;
import com.baidu.android.pushservice.p031j.C0578p;
import com.baidu.android.pushservice.p031j.C0579q;
import com.baidu.android.pushservice.p032k.C0582b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.baidu.android.pushservice.b.e */
public abstract class C0436e {
    /* renamed from: a */
    protected ArrayList<C0431a> f1372a = new ArrayList();
    /* renamed from: b */
    protected Context f1373b;
    /* renamed from: c */
    protected C0433c f1374c;

    public C0436e(Context context, C0433c c0433c) {
        this.f1373b = context.getApplicationContext();
        this.f1374c = c0433c;
        m1896a();
    }

    /* renamed from: a */
    private void m1891a(String str, ArrayList<C0431a> arrayList) {
        String str2 = this.f1373b.getPackageName() + ".push_sync";
        for (ResolveInfo resolveInfo : C0578p.m2502F(this.f1373b) ? C0578p.m2588o(this.f1373b) : C0578p.m2587n(this.f1373b)) {
            try {
                Object e = "com.baidu.push.sdkr".equals(str) ? C0473d.m2048e(this.f1373b, resolveInfo.activityInfo.packageName) : null;
                if (!TextUtils.isEmpty(e)) {
                    ArrayList a = mo1282a(C0436e.m1892c(e));
                    if (a != null) {
                        Iterator it = a.iterator();
                        while (it.hasNext()) {
                            Object obj;
                            C0431a c0431a = (C0431a) it.next();
                            Iterator it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                C0431a c0431a2 = (C0431a) it2.next();
                                if (!TextUtils.equals(c0431a.f1356c, c0431a2.f1356c)) {
                                    if (TextUtils.equals(c0431a.f1354a, c0431a2.f1354a)) {
                                    }
                                }
                                obj = 1;
                            }
                            obj = null;
                            if (obj == null) {
                                arrayList.add(c0431a);
                            }
                        }
                    }
                }
            } catch (Exception e2) {
            }
        }
        if (arrayList.size() > 0) {
            String d = m1899d(mo1281a((List) arrayList));
            if ("com.baidu.push.sdkr".equals(str)) {
                C0472c.m2033c(this.f1373b, d);
            }
            if (C0578p.m2501E(this.f1373b)) {
                C0579q.m2613a(this.f1373b, str2, str, d);
            }
        }
    }

    /* renamed from: c */
    public static String m1892c(String str) {
        String str2 = "";
        try {
            byte[] a = C0582b.m2630a(str.getBytes());
            String str3 = (a == null || a.length <= 0) ? str2 : new String(BaiduAppSSOJni.decryptAES(a, a.length, 0));
            return str3;
        } catch (Exception e) {
            return str2;
        } catch (UnsatisfiedLinkError e2) {
            return str2;
        }
    }

    /* renamed from: a */
    public String m1893a(C0431a c0431a, boolean z) {
        Object obj = 1;
        synchronized (this.f1372a) {
            String str;
            Iterator it;
            C0431a c0431a2;
            if (TextUtils.isEmpty(c0431a.m1861a())) {
                if (this.f1374c != C0433c.SDK_CLIENT) {
                    it = this.f1372a.iterator();
                    while (it.hasNext()) {
                        c0431a2 = (C0431a) it.next();
                        if (TextUtils.isEmpty(c0431a.m1864b()) || !TextUtils.equals(c0431a2.m1864b(), c0431a.m1864b())) {
                            if (TextUtils.isEmpty(c0431a2.m1861a())) {
                                break;
                            }
                        }
                        break;
                    }
                }
                it = this.f1372a.iterator();
                while (it.hasNext()) {
                    c0431a2 = (C0431a) it.next();
                    if (!TextUtils.isEmpty(c0431a.m1864b()) && TextUtils.equals(c0431a2.m1864b(), c0431a.m1864b()) && !TextUtils.isEmpty(c0431a.m1867c()) && TextUtils.equals(c0431a2.m1867c(), c0431a.m1867c())) {
                        break;
                    }
                }
                obj = null;
            } else {
                Object obj2;
                it = this.f1372a.iterator();
                while (it.hasNext()) {
                    c0431a2 = (C0431a) it.next();
                    if (TextUtils.isEmpty(c0431a.m1864b()) || !TextUtils.equals(c0431a2.m1864b(), c0431a.m1864b())) {
                        if (c0431a.m1861a().equals(c0431a2.m1861a())) {
                        }
                    }
                    this.f1372a.remove(c0431a2);
                    if (z) {
                        this.f1372a.add(c0431a);
                    }
                    obj2 = 1;
                    obj = obj2;
                }
                obj2 = null;
                obj = obj2;
            }
            if (obj == null && z) {
                this.f1372a.add(c0431a);
            }
            String a = mo1281a(this.f1372a);
            String str2 = "";
            switch (this.f1374c) {
                case SDK_CLIENT:
                    str = "com.baidu.push.sdkr";
                    break;
                case PUSH_CLIENT:
                    str = str2;
                    break;
                default:
                    str = str2;
                    break;
            }
            try {
                str2 = C0582b.m2629a(BaiduAppSSOJni.encryptAES(a, 0), "utf-8");
                C0562b.m2422a(this.f1373b, str, str2);
                return str2;
            } catch (Exception e) {
                return "";
            } catch (UnsatisfiedLinkError e2) {
                return "";
            }
        }
    }

    /* renamed from: a */
    protected String mo1281a(List<C0431a> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            C0431a c0431a = (C0431a) list.get(i);
            stringBuffer.append(c0431a.m1864b());
            stringBuffer.append(",");
            stringBuffer.append(c0431a.m1861a());
            if (i != list.size() - 1) {
                stringBuffer.append(";");
            }
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    protected ArrayList<C0431a> mo1282a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<C0431a> arrayList = new ArrayList();
        for (String trim : str.trim().split(";")) {
            String[] split = trim.trim().trim().split(",");
            if (split.length == 1 || split.length == 2) {
                C0431a c0431a = new C0431a(split[0]);
                if (split.length == 2) {
                    c0431a.m1863a(split[1]);
                }
                arrayList.add(c0431a);
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    protected void m1896a() {
        String str;
        String str2 = "";
        switch (this.f1374c) {
            case SDK_CLIENT:
                str = "com.baidu.push.sdkr";
                break;
            case PUSH_CLIENT:
                str = str2;
                break;
            default:
                str = str2;
                break;
        }
        Object obj = null;
        if (C0578p.m2501E(this.f1373b)) {
            obj = C0562b.m2419a(this.f1373b, str);
        }
        if (TextUtils.isEmpty(obj) && "com.baidu.push.sdkr".equals(str)) {
            obj = C0472c.m2037e(this.f1373b);
        }
        if (!TextUtils.isEmpty(obj)) {
            try {
                ArrayList a = mo1282a(C0436e.m1892c(obj));
                if (a != null) {
                    Iterator it = a.iterator();
                    while (it.hasNext()) {
                        this.f1372a.add((C0431a) it.next());
                    }
                }
                m1891a(str, this.f1372a);
            } catch (Exception e) {
            } catch (UnsatisfiedLinkError e2) {
            }
        }
    }

    /* renamed from: a */
    public synchronized void m1897a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Collection a = mo1282a(C0436e.m1892c(str2));
            String str3 = "";
            if (a != null) {
                ArrayList arrayList = new ArrayList();
                Iterator it = a.iterator();
                while (it.hasNext()) {
                    arrayList.add(((C0431a) it.next()).f1356c);
                }
                int i = 0;
                while (i < this.f1372a.size()) {
                    int i2;
                    if (arrayList.contains(((C0431a) this.f1372a.get(i)).f1356c)) {
                        this.f1372a.remove(i);
                        i2 = i - 1;
                    } else {
                        i2 = i;
                    }
                    i = i2 + 1;
                }
                this.f1372a.addAll(a);
                try {
                    str3 = m1899d(mo1281a(this.f1372a));
                    if ("com.baidu.push.sdkr".equals(str)) {
                        C0472c.m2033c(this.f1373b, str3);
                    }
                    if (C0578p.m2501E(this.f1373b)) {
                        C0579q.m2613a(this.f1373b, this.f1373b.getPackageName() + ".push_sync", str, str3);
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    /* renamed from: b */
    public C0431a m1898b(String str) {
        Iterator it = this.f1372a.iterator();
        while (it.hasNext()) {
            C0431a c0431a = (C0431a) it.next();
            if (!TextUtils.isEmpty(c0431a.m1864b()) && c0431a.m1864b().equals(str)) {
                return c0431a;
            }
        }
        return null;
    }

    /* renamed from: d */
    public String m1899d(String str) {
        String str2 = "";
        try {
            str2 = C0582b.m2629a(BaiduAppSSOJni.encryptAES(str, 0), "utf-8");
        } catch (Exception e) {
        } catch (UnsatisfiedLinkError e2) {
        }
        return str2;
    }
}
