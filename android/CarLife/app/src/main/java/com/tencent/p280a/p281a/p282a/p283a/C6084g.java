package com.tencent.p280a.p281a.p282a.p283a;

import android.content.Context;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.tencent.a.a.a.a.g */
public final class C6084g {
    /* renamed from: d */
    private static C6084g f24741d = null;
    /* renamed from: a */
    private Map<Integer, C6079f> f24742a = null;
    /* renamed from: b */
    private int f24743b = 0;
    /* renamed from: c */
    private Context f24744c = null;

    private C6084g(Context context) {
        this.f24744c = context.getApplicationContext();
        this.f24742a = new HashMap(3);
        this.f24742a.put(Integer.valueOf(1), new C6083e(context));
        this.f24742a.put(Integer.valueOf(2), new C6080b(context));
        this.f24742a.put(Integer.valueOf(4), new C6082d(context));
    }

    /* renamed from: a */
    private C6081c m21658a(List<Integer> list) {
        if (list.size() >= 0) {
            for (Integer num : list) {
                C6079f c6079f = (C6079f) this.f24742a.get(num);
                if (c6079f != null) {
                    C6081c c = c6079f.m21645c();
                    if (c != null && C6085h.m21668b(c.f24739c)) {
                        return c;
                    }
                }
            }
        }
        return new C6081c();
    }

    /* renamed from: a */
    public static synchronized C6084g m21659a(Context context) {
        C6084g c6084g;
        synchronized (C6084g.class) {
            if (f24741d == null) {
                f24741d = new C6084g(context);
            }
            c6084g = f24741d;
        }
        return c6084g;
    }

    /* renamed from: a */
    public final C6081c m21660a() {
        return m21658a(new ArrayList(Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(4)})));
    }

    /* renamed from: a */
    public final void m21661a(String str) {
        C6081c a = m21660a();
        a.f24739c = str;
        if (!C6085h.m21666a(a.f24737a)) {
            a.f24737a = C6085h.m21662a(this.f24744c);
        }
        if (!C6085h.m21666a(a.f24738b)) {
            a.f24738b = C6085h.m21667b(this.f24744c);
        }
        a.f24740d = System.currentTimeMillis();
        for (Entry value : this.f24742a.entrySet()) {
            ((C6079f) value.getValue()).m21641a(a);
        }
    }
}
