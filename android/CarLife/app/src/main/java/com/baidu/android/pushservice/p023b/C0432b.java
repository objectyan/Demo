package com.baidu.android.pushservice.p023b;

import android.content.Context;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.baidu.android.pushservice.jni.BaiduAppSSOJni;
import com.baidu.android.pushservice.p025d.C0472c;
import com.baidu.android.pushservice.p025d.C0473d;
import com.baidu.android.pushservice.p026e.C0491g;
import com.baidu.android.pushservice.p029h.C0553q;
import com.baidu.android.pushservice.p031j.C0574m;
import com.baidu.android.pushservice.p031j.C0578p;
import com.baidu.android.pushservice.p031j.C0579q;
import com.baidu.android.pushservice.p032k.C0582b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.baidu.android.pushservice.b.b */
public final class C0432b {
    /* renamed from: b */
    private static volatile C0432b f1359b;
    /* renamed from: a */
    public ArrayList<C0437f> f1360a = new ArrayList();
    /* renamed from: c */
    private Context f1361c;
    /* renamed from: d */
    private HashMap<String, C0491g> f1362d = new HashMap();

    private C0432b(Context context) {
        int i;
        this.f1361c = context.getApplicationContext();
        String f = C0472c.m2039f(context);
        if (TextUtils.isEmpty(f) && C0578p.m2501E(this.f1361c)) {
            f = C0579q.m2612a(this.f1361c, this.f1361c.getPackageName() + ".push_sync", "r_v2");
        }
        if (!TextUtils.isEmpty(f)) {
            try {
                ArrayList e = C0432b.m1875e(C0432b.m1871a(f));
                if (e != null) {
                    Iterator it = e.iterator();
                    while (it.hasNext()) {
                        this.f1360a.add((C0437f) it.next());
                    }
                }
            } catch (Exception e2) {
            }
        }
        int b = C0574m.m2471b(this.f1361c, "com.baidu.push.sync.vn", -1);
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e3) {
            i = 0;
        }
        if (b < i) {
            m1873a();
            C0574m.m2466a(this.f1361c, "com.baidu.push.sync.vn", i);
        }
    }

    /* renamed from: a */
    public static synchronized C0432b m1870a(Context context) {
        C0432b c0432b;
        synchronized (C0432b.class) {
            if (f1359b == null) {
                f1359b = new C0432b(context);
            }
            c0432b = f1359b;
        }
        return c0432b;
    }

    /* renamed from: a */
    public static String m1871a(String str) {
        String str2 = "";
        try {
            String str3;
            if (!TextUtils.isEmpty(str)) {
                byte[] a = C0582b.m2630a(str.getBytes());
                if (a != null && a.length > 0) {
                    str3 = new String(BaiduAppSSOJni.decryptAES(a, a.length, 0));
                    return str3;
                }
            }
            str3 = str2;
            return str3;
        } catch (Exception e) {
            return str2;
        } catch (UnsatisfiedLinkError e2) {
            return str2;
        }
    }

    /* renamed from: a */
    private String m1872a(List<C0437f> list) {
        StringBuffer stringBuffer;
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuffer stringBuffer2 = null;
        try {
            stringBuffer = new StringBuffer();
            int i = 0;
            while (i < list.size()) {
                try {
                    C0437f c0437f = (C0437f) list.get(i);
                    if (c0437f != null) {
                        stringBuffer.append(c0437f.c);
                        stringBuffer.append(",");
                        stringBuffer.append(c0437f.a);
                        stringBuffer.append(",");
                        stringBuffer.append(c0437f.f1375f);
                        stringBuffer.append(",");
                        if (c0437f.f1376g) {
                            stringBuffer.append("true");
                        } else {
                            stringBuffer.append("false");
                        }
                        stringBuffer.append(",");
                        stringBuffer.append(c0437f.e);
                        if (i != list.size() - 1) {
                            stringBuffer.append(";");
                        }
                    }
                    i++;
                } catch (Exception e) {
                    stringBuffer2 = stringBuffer;
                }
            }
        } catch (Exception e2) {
            stringBuffer = stringBuffer2;
            return stringBuffer == null ? "" : stringBuffer.toString();
        }
        if (stringBuffer == null) {
        }
    }

    /* renamed from: a */
    private void m1873a() {
        m1874a("r_v2", this.f1360a);
    }

    /* renamed from: a */
    private void m1874a(String str, ArrayList<C0437f> arrayList) {
        String str2;
        String str3 = this.f1361c.getPackageName() + ".push_sync";
        for (ResolveInfo resolveInfo : C0578p.m2502F(this.f1361c) ? C0578p.m2588o(this.f1361c) : C0578p.m2587n(this.f1361c)) {
            try {
                CharSequence a;
                CharSequence a2;
                String f;
                ArrayList e;
                Iterator it;
                C0437f c0437f;
                Iterator it2;
                C0437f c0437f2;
                Object obj;
                Iterator it3;
                Object obj2;
                String str4 = resolveInfo.activityInfo.packageName;
                if (C0578p.m2501E(this.f1361c)) {
                    Context v = C0578p.m2602v(this.f1361c, resolveInfo.activityInfo.packageName);
                    if (v != null) {
                        a = C0579q.m2612a(v, resolveInfo.activityInfo.packageName + ".push_sync", str);
                        a2 = C0579q.m2612a(v, resolveInfo.activityInfo.packageName + ".self_push_sync", "bindinfo");
                        if ((!TextUtils.isEmpty(a) || TextUtils.isEmpty(a2)) && C0578p.m2584m(this.f1361c, str4) > 50) {
                            f = C0473d.m2049f(this.f1361c, str4);
                            str4 = C0473d.m2050g(this.f1361c, str4);
                            str2 = f;
                        } else {
                            CharSequence charSequence = a2;
                            a2 = a;
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            e = C0432b.m1875e(C0432b.m1871a(str2));
                            if (e != null) {
                                it = e.iterator();
                                while (it.hasNext()) {
                                    c0437f = (C0437f) it.next();
                                    it2 = arrayList.iterator();
                                    while (it2.hasNext()) {
                                        c0437f2 = (C0437f) it2.next();
                                        if (!TextUtils.equals(c0437f.c, c0437f2.c)) {
                                            if (TextUtils.equals(c0437f.a, c0437f2.a)) {
                                            }
                                        }
                                        arrayList.remove(c0437f2);
                                        arrayList.add(c0437f);
                                        obj = 1;
                                    }
                                    obj = null;
                                    if (obj == null) {
                                        arrayList.add(c0437f);
                                    }
                                }
                            }
                        }
                        if (!TextUtils.isEmpty(str4)) {
                            c0437f2 = m1876h(C0432b.m1871a(str4));
                            it3 = arrayList.iterator();
                            while (it3.hasNext()) {
                                c0437f = (C0437f) it3.next();
                                if (TextUtils.equals(c0437f2.c, c0437f.c)) {
                                    arrayList.remove(c0437f);
                                    arrayList.add(c0437f2);
                                    obj2 = 1;
                                    break;
                                }
                            }
                            obj2 = null;
                            if (obj2 == null) {
                                arrayList.add(c0437f2);
                            }
                        }
                    }
                }
                a2 = null;
                a = null;
                if (TextUtils.isEmpty(a)) {
                }
                f = C0473d.m2049f(this.f1361c, str4);
                str4 = C0473d.m2050g(this.f1361c, str4);
                str2 = f;
                if (TextUtils.isEmpty(str2)) {
                    e = C0432b.m1875e(C0432b.m1871a(str2));
                    if (e != null) {
                        it = e.iterator();
                        while (it.hasNext()) {
                            c0437f = (C0437f) it.next();
                            it2 = arrayList.iterator();
                            while (it2.hasNext()) {
                                c0437f2 = (C0437f) it2.next();
                                if (!TextUtils.equals(c0437f.c, c0437f2.c)) {
                                    if (TextUtils.equals(c0437f.a, c0437f2.a)) {
                                    }
                                }
                                arrayList.remove(c0437f2);
                                arrayList.add(c0437f);
                                obj = 1;
                            }
                            obj = null;
                            if (obj == null) {
                                arrayList.add(c0437f);
                            }
                        }
                    }
                }
                if (!TextUtils.isEmpty(str4)) {
                    c0437f2 = m1876h(C0432b.m1871a(str4));
                    it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        c0437f = (C0437f) it3.next();
                        if (TextUtils.equals(c0437f2.c, c0437f.c)) {
                            arrayList.remove(c0437f);
                            arrayList.add(c0437f2);
                            obj2 = 1;
                            break;
                        }
                    }
                    obj2 = null;
                    if (obj2 == null) {
                        arrayList.add(c0437f2);
                    }
                }
            } catch (Throwable e2) {
                C0553q.m2362a(this.f1361c, e2);
            }
        }
        if (arrayList.size() > 0) {
            str2 = m1882b(m1872a((List) arrayList));
            C0472c.m2036d(this.f1361c, str2);
            if (C0578p.m2501E(this.f1361c)) {
                C0579q.m2613a(this.f1361c, str3, str, str2);
            }
        }
    }

    /* renamed from: e */
    public static ArrayList<C0437f> m1875e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList<C0437f> arrayList = new ArrayList();
        try {
            for (String trim : str.trim().split(";")) {
                String[] split = trim.trim().split(",");
                if (split.length >= 3) {
                    C0437f c0437f = new C0437f();
                    c0437f.c = split[0].trim();
                    c0437f.a = split[1].trim();
                    c0437f.f1375f = split[2].trim();
                    if (split.length > 3) {
                        c0437f.f1376g = split[3].trim().equals("true");
                        if (split.length > 4) {
                            c0437f.e = Integer.parseInt(split[4].trim());
                        }
                    }
                    arrayList.add(c0437f);
                }
            }
            return arrayList;
        } catch (Exception e) {
            return arrayList;
        }
    }

    /* renamed from: h */
    private C0437f m1876h(String str) {
        C0437f c0437f = new C0437f();
        try {
            if (!TextUtils.isEmpty(str)) {
                String[] split = str.trim().split(",");
                if (!(split == null || split.length < 3 || TextUtils.isEmpty(split[0]))) {
                    c0437f.c = split[0].trim();
                    c0437f.a = split[1].trim();
                    c0437f.f1375f = split[2].trim();
                    if (split.length <= 3) {
                        return c0437f;
                    }
                    c0437f.f1376g = split[3].trim().equals("true");
                    if (split.length <= 4) {
                        return c0437f;
                    }
                    c0437f.e = Integer.parseInt(split[4].trim());
                    return c0437f;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    /* renamed from: a */
    public C0437f m1877a(int i, boolean z) {
        Iterator it = this.f1360a.iterator();
        while (it.hasNext()) {
            C0437f c0437f = (C0437f) it.next();
            if (c0437f.d >= i && ((!z || c0437f.f1376g) && C0578p.m2558c(this.f1361c, c0437f.m1867c()))) {
                return c0437f;
            }
        }
        return null;
    }

    /* renamed from: a */
    public String m1878a(C0437f c0437f, boolean z) {
        return m1879a(c0437f, z, this.f1360a, "r_v2");
    }

    /* renamed from: a */
    public String m1879a(C0437f c0437f, boolean z, ArrayList<C0437f> arrayList, String str) {
        String b;
        synchronized (arrayList) {
            Object obj;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                C0437f c0437f2 = (C0437f) it.next();
                if (!c0437f2.c.equals(c0437f.c)) {
                    if (c0437f2.a.equals(c0437f.a)) {
                    }
                }
                arrayList.remove(c0437f2);
                if (z) {
                    arrayList.add(c0437f);
                }
                obj = 1;
                if (obj == null && z) {
                    arrayList.add(c0437f);
                }
                b = m1882b(m1872a((List) arrayList));
                C0472c.m2036d(this.f1361c, b);
                if (C0578p.m2501E(this.f1361c)) {
                    C0579q.m2613a(this.f1361c, this.f1361c.getPackageName() + ".push_sync", str, b);
                }
            }
            obj = null;
            arrayList.add(c0437f);
            b = m1882b(m1872a((List) arrayList));
            C0472c.m2036d(this.f1361c, b);
            if (C0578p.m2501E(this.f1361c)) {
                C0579q.m2613a(this.f1361c, this.f1361c.getPackageName() + ".push_sync", str, b);
            }
        }
        return b;
    }

    /* renamed from: a */
    public void m1880a(String str, C0491g c0491g) {
        this.f1362d.put(str, c0491g);
    }

    /* renamed from: a */
    public synchronized void m1881a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            Collection e = C0432b.m1875e(C0432b.m1871a(str2));
            String str3 = "";
            if (!(f1359b == null || e == null)) {
                try {
                    if (str.equals("r_v2")) {
                        ArrayList arrayList = new ArrayList();
                        Iterator it = e.iterator();
                        while (it.hasNext()) {
                            arrayList.add(((C0437f) it.next()).c);
                        }
                        int i = 0;
                        while (i < f1359b.f1360a.size()) {
                            int i2;
                            if (arrayList.contains(((C0437f) f1359b.f1360a.get(i)).c)) {
                                f1359b.f1360a.remove(i);
                                i2 = i - 1;
                            } else {
                                i2 = i;
                            }
                            i = i2 + 1;
                        }
                        f1359b.f1360a.addAll(e);
                        str3 = m1872a(f1359b.f1360a);
                    }
                    str3 = m1882b(str3);
                    C0472c.m2036d(this.f1361c, str3);
                    if (C0578p.m2501E(this.f1361c)) {
                        C0579q.m2613a(this.f1361c, this.f1361c.getPackageName() + ".push_sync", str, str3);
                    }
                } catch (Exception e2) {
                }
            }
        }
    }

    /* renamed from: b */
    public String m1882b(String str) {
        String str2 = "";
        try {
            str2 = C0582b.m2629a(BaiduAppSSOJni.encryptAES(str, 0), "utf-8");
        } catch (Exception e) {
        } catch (UnsatisfiedLinkError e2) {
        }
        return str2;
    }

    /* renamed from: b */
    public synchronized void m1883b(Context context) {
        Collection collection;
        String f = C0472c.m2039f(context);
        if (TextUtils.isEmpty(f)) {
            C0578p.m2546b("ClientManager*BBind* selfbindinfo is null", context);
            if (C0578p.m2501E(this.f1361c)) {
                f = C0579q.m2612a(this.f1361c, this.f1361c.getPackageName() + ".push_sync", "r_v2");
            }
        }
        if (TextUtils.isEmpty(f)) {
            collection = null;
        } else {
            String a = C0432b.m1871a(f);
            C0578p.m2546b("ClientManager*BBind* clients=" + a, context);
            collection = C0432b.m1875e(a);
        }
        if (!(f1359b == null || collection == null)) {
            ArrayList arrayList = new ArrayList();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(((C0437f) it.next()).c);
            }
            int i = 0;
            while (i < f1359b.f1360a.size()) {
                int i2;
                if (arrayList.contains(((C0437f) f1359b.f1360a.get(i)).c)) {
                    f1359b.f1360a.remove(i);
                    i2 = i - 1;
                } else {
                    i2 = i;
                }
                i = i2 + 1;
            }
            f1359b.f1360a.addAll(collection);
            C0578p.m2546b("ClientManager*BBind* sInstance.mClientsV2.size=" + f1359b.f1360a.size(), context);
        }
    }

    /* renamed from: b */
    public boolean m1884b(String str, String str2) {
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) ? false : this.f1362d.containsKey(str) && str2.equals(((C0491g) this.f1362d.get(str)).m2085a());
    }

    /* renamed from: c */
    public C0437f m1885c(String str) {
        if (!(this.f1360a == null || TextUtils.isEmpty(str))) {
            Iterator it = this.f1360a.iterator();
            while (it.hasNext()) {
                C0437f c0437f = (C0437f) it.next();
                if (c0437f.c.equals(str)) {
                    return c0437f;
                }
            }
        }
        return null;
    }

    /* renamed from: d */
    public C0437f m1886d(String str) {
        String a;
        if (!TextUtils.isEmpty(str)) {
            C0437f c0437f;
            Iterator it = this.f1360a.iterator();
            while (it.hasNext()) {
                c0437f = (C0437f) it.next();
                if (!TextUtils.isEmpty(c0437f.a) && c0437f.a.equals(str)) {
                    return c0437f;
                }
            }
            C0578p.m2546b("ClientManager*BBind* isRegisteredClientByAppid return not by mClientsV2!", this.f1361c);
            try {
                List<ResolveInfo> o = C0578p.m2502F(this.f1361c) ? C0578p.m2588o(this.f1361c) : C0578p.m2587n(this.f1361c);
                if (o == null || o.isEmpty()) {
                    C0578p.m2546b("ClientManager*BBind* getFriendPackages is null!", this.f1361c);
                } else {
                    String a2;
                    CharSequence charSequence = null;
                    for (ResolveInfo resolveInfo : o) {
                        try {
                            if (C0578p.m2501E(this.f1361c)) {
                                Context v = C0578p.m2602v(this.f1361c, resolveInfo.activityInfo.packageName);
                                if (v != null) {
                                    a2 = C0579q.m2612a(v, resolveInfo.activityInfo.packageName + ".push_sync", "r_v2");
                                }
                            }
                            if (TextUtils.isEmpty(charSequence)) {
                                charSequence = C0473d.m2049f(this.f1361c, resolveInfo.activityInfo.packageName);
                            }
                            if (!TextUtils.isEmpty(a2)) {
                                a = C0432b.m1871a(a2);
                                if (a.contains(str)) {
                                    ArrayList e = C0432b.m1875e(a);
                                    if (!(e == null || e.isEmpty())) {
                                        Iterator it2 = e.iterator();
                                        while (it2.hasNext()) {
                                            c0437f = (C0437f) it2.next();
                                            if (!TextUtils.isEmpty(c0437f.a) && c0437f.a.equals(str)) {
                                                this.f1360a.add(c0437f);
                                                return c0437f;
                                            }
                                        }
                                        continue;
                                    }
                                } else {
                                    continue;
                                }
                            }
                        } catch (Exception e2) {
                            a = a2;
                        }
                    }
                    a = a2;
                    C0578p.m2546b("ClientManager*BBind* isRegisteredClientByAppid return null!" + a, this.f1361c);
                    return null;
                }
            } catch (Exception e3) {
                a = null;
            }
        }
        a = null;
        C0578p.m2546b("ClientManager*BBind* isRegisteredClientByAppid return null!" + a, this.f1361c);
        return null;
    }

    /* renamed from: f */
    public String m1887f(String str) {
        return this.f1362d.get(str) != null ? ((C0491g) this.f1362d.get(str)).m2086b() : "";
    }

    /* renamed from: g */
    public void m1888g(String str) {
        if (this.f1362d.containsKey(str)) {
            this.f1362d.remove(str);
        }
    }
}
