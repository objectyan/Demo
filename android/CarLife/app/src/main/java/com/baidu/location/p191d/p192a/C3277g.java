package com.baidu.location.p191d.p192a;

import android.content.Context;
import com.baidu.location.C3377f;
import com.baidu.location.p191d.p192a.C3259b.C3258a;
import com.baidu.location.p191d.p192a.C3263c.C3262a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.baidu.location.d.a.g */
public class C3277g {
    /* renamed from: a */
    private static boolean f17777a = false;
    /* renamed from: b */
    private static C3259b f17778b;
    /* renamed from: c */
    private static C3258a f17779c = new C32751();
    /* renamed from: d */
    private static C3254a f17780d;
    /* renamed from: e */
    private static C3277g f17781e = null;
    /* renamed from: f */
    private static Context f17782f = null;
    /* renamed from: g */
    private static C3263c f17783g = null;
    /* renamed from: h */
    private static List<Integer> f17784h = new ArrayList();
    /* renamed from: i */
    private static boolean f17785i = false;
    /* renamed from: j */
    private static C3262a f17786j = new C32762();

    /* renamed from: com.baidu.location.d.a.g$a */
    public interface C3254a {
        /* renamed from: a */
        void mo2501a(int i);
    }

    /* renamed from: com.baidu.location.d.a.g$1 */
    static class C32751 implements C3258a {
        C32751() {
        }

        /* renamed from: a */
        public void mo2502a(int i) {
            if (i == 100) {
                C3277g.f17777a = true;
            }
        }
    }

    /* renamed from: com.baidu.location.d.a.g$2 */
    static class C32762 implements C3262a {
        C32762() {
        }

        /* renamed from: a */
        public void mo2503a(int i) {
            if (C3277g.f17783g.m13666c()) {
                C3277g.f17784h.add(Integer.valueOf(i));
                int i2;
                int i3;
                int i4;
                int i5;
                if (C3277g.f17785i) {
                    if (C3277g.f17785i && i == 999) {
                        boolean z;
                        C3277g.f17778b.m13649b();
                        if (C3277g.f17777a) {
                            z = true;
                        } else {
                            i2 = 0;
                            i3 = 0;
                            i4 = 0;
                            for (Integer num : C3277g.f17784h) {
                                if (num.intValue() >= 1000) {
                                    i5 = i2;
                                    i2 = i3;
                                    i3 = i4 + 1;
                                } else if (num.intValue() == 0) {
                                    i5 = i2;
                                    i2 = i3 + 1;
                                    i3 = i4;
                                } else if (num.intValue() == 1) {
                                    i5 = i2 + 1;
                                    i2 = i3;
                                    i3 = i4;
                                } else {
                                    i5 = i2;
                                    i2 = i3;
                                    i3 = i4;
                                }
                                i4 = i3;
                                i3 = i2;
                                i2 = i5;
                            }
                            z = i4 >= 5;
                        }
                        if (z) {
                            C3277g.f17783g.m13665b();
                            C3277g.f17784h.clear();
                            C3277g.f17785i = false;
                            C3277g.f17777a = false;
                            C3277g.f17783g.m13663a();
                            return;
                        }
                        C3277g.f17783g.m13665b();
                        C3277g.f17784h.clear();
                        C3277g.f17785i = false;
                        C3277g.f17777a = false;
                        C3277g.f17780d.mo2501a(0);
                    }
                } else if (C3277g.f17784h.size() >= 2 && ((Integer) C3277g.f17784h.get(C3277g.f17784h.size() - 1)).intValue() == 0 && ((Integer) C3277g.f17784h.get(C3277g.f17784h.size() - 2)).intValue() == 0) {
                    if (C3277g.f17784h.size() == 2) {
                        C3277g.f17784h.clear();
                        C3277g.f17780d.mo2501a(0);
                        C3277g.f17783g.m13665b();
                        return;
                    }
                    C3277g.f17777a = false;
                    C3277g.f17785i = true;
                    C3277g.f17784h.clear();
                    C3277g.f17783g.m13667d();
                    C3277g.f17778b.m13648a();
                } else if (i == 888) {
                    i2 = 0;
                    i3 = 0;
                    i4 = 0;
                    for (Integer num2 : C3277g.f17784h) {
                        if (num2.intValue() >= 1000) {
                            i5 = i2;
                            i2 = i3;
                            i3 = i4 + 1;
                        } else if (num2.intValue() == 0) {
                            i5 = i2;
                            i2 = i3 + 1;
                            i3 = i4;
                        } else if (num2.intValue() == 1) {
                            i5 = i2 + 1;
                            i2 = i3;
                            i3 = i4;
                        } else {
                            i5 = i2;
                            i2 = i3;
                            i3 = i4;
                        }
                        i4 = i3;
                        i3 = i2;
                        i2 = i5;
                    }
                    if (i4 >= 5) {
                        C3277g.f17780d.mo2501a(1);
                        return;
                    }
                    if (C3277g.f17784h.size() > 0) {
                        C3277g.f17784h.clear();
                    }
                    C3277g.f17780d.mo2501a(0);
                    C3277g.f17783g.m13665b();
                }
            }
        }
    }

    /* renamed from: a */
    public static C3277g m13705a() {
        if (f17781e == null) {
            f17781e = new C3277g();
            f17782f = C3377f.getServiceContext();
            f17783g = new C3263c(f17782f, f17786j);
            f17778b = C3259b.m13642a(f17782f, f17779c);
        }
        return f17781e;
    }

    /* renamed from: a */
    public void m13714a(int i) {
        f17777a = false;
        f17785i = false;
        if (f17784h.size() > 0) {
            f17784h.clear();
        }
        f17783g.m13664a(i);
    }

    /* renamed from: a */
    public void m13715a(C3254a c3254a) {
        f17780d = c3254a;
    }

    /* renamed from: b */
    public void m13716b() {
        f17777a = false;
        f17785i = false;
        if (f17784h.size() > 0) {
            f17784h.clear();
        }
        f17783g.m13665b();
        f17778b.m13649b();
    }
}
