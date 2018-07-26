package com.facebook.common.p257e;

/* compiled from: FLog */
/* renamed from: com.facebook.common.e.a */
public class C5320a {
    /* renamed from: a */
    public static final int f21893a = 2;
    /* renamed from: b */
    public static final int f21894b = 3;
    /* renamed from: c */
    public static final int f21895c = 4;
    /* renamed from: d */
    public static final int f21896d = 5;
    /* renamed from: e */
    public static final int f21897e = 6;
    /* renamed from: f */
    public static final int f21898f = 7;
    /* renamed from: g */
    private static C5321c f21899g = C5322b.m18212a();

    /* renamed from: a */
    public static void m18121a(C5321c delegate) {
        if (delegate == null) {
            throw new IllegalArgumentException();
        }
        f21899g = delegate;
    }

    /* renamed from: a */
    public static boolean m18138a(int level) {
        return f21899g.mo4006b(level);
    }

    /* renamed from: b */
    public static void m18139b(int level) {
        f21899g.mo3999a(level);
    }

    /* renamed from: a */
    public static int m18118a() {
        return f21899g.mo4003b();
    }

    /* renamed from: a */
    public static void m18130a(String tag, String msg) {
        if (f21899g.mo4006b(2)) {
            f21899g.mo4001a(tag, msg);
        }
    }

    /* renamed from: a */
    public static void m18131a(String tag, String msg, Object arg1) {
        if (f21899g.mo4006b(2)) {
            f21899g.mo4001a(tag, C5320a.m18120a(msg, arg1));
        }
    }

    /* renamed from: a */
    public static void m18132a(String tag, String msg, Object arg1, Object arg2) {
        if (f21899g.mo4006b(2)) {
            f21899g.mo4001a(tag, C5320a.m18120a(msg, arg1, arg2));
        }
    }

    /* renamed from: a */
    public static void m18133a(String tag, String msg, Object arg1, Object arg2, Object arg3) {
        if (f21899g.mo4006b(2)) {
            f21899g.mo4001a(tag, C5320a.m18120a(msg, arg1, arg2, arg3));
        }
    }

    /* renamed from: a */
    public static void m18134a(String tag, String msg, Object arg1, Object arg2, Object arg3, Object arg4) {
        if (f21899g.mo4006b(2)) {
            f21899g.mo4001a(tag, C5320a.m18120a(msg, arg1, arg2, arg3, arg4));
        }
    }

    /* renamed from: a */
    public static void m18122a(Class<?> cls, String msg) {
        if (f21899g.mo4006b(2)) {
            f21899g.mo4001a(C5320a.m18119a((Class) cls), msg);
        }
    }

    /* renamed from: a */
    public static void m18123a(Class<?> cls, String msg, Object arg1) {
        if (f21899g.mo4006b(2)) {
            f21899g.mo4001a(C5320a.m18119a((Class) cls), C5320a.m18120a(msg, arg1));
        }
    }

    /* renamed from: a */
    public static void m18124a(Class<?> cls, String msg, Object arg1, Object arg2) {
        if (f21899g.mo4006b(2)) {
            f21899g.mo4001a(C5320a.m18119a((Class) cls), C5320a.m18120a(msg, arg1, arg2));
        }
    }

    /* renamed from: a */
    public static void m18125a(Class<?> cls, String msg, Object arg1, Object arg2, Object arg3) {
        if (C5320a.m18138a(2)) {
            C5320a.m18122a((Class) cls, C5320a.m18120a(msg, arg1, arg2, arg3));
        }
    }

    /* renamed from: a */
    public static void m18126a(Class<?> cls, String msg, Object arg1, Object arg2, Object arg3, Object arg4) {
        if (f21899g.mo4006b(2)) {
            f21899g.mo4001a(C5320a.m18119a((Class) cls), C5320a.m18120a(msg, arg1, arg2, arg3, arg4));
        }
    }

    /* renamed from: a */
    public static void m18136a(String tag, String msg, Object... args) {
        if (f21899g.mo4006b(2)) {
            f21899g.mo4001a(tag, C5320a.m18120a(msg, args));
        }
    }

    /* renamed from: a */
    public static void m18137a(String tag, Throwable tr, String msg, Object... args) {
        if (f21899g.mo4006b(2)) {
            f21899g.mo4002a(tag, C5320a.m18120a(msg, args), tr);
        }
    }

    /* renamed from: a */
    public static void m18128a(Class<?> cls, String msg, Object... args) {
        if (f21899g.mo4006b(2)) {
            f21899g.mo4001a(C5320a.m18119a((Class) cls), C5320a.m18120a(msg, args));
        }
    }

    /* renamed from: a */
    public static void m18129a(Class<?> cls, Throwable tr, String msg, Object... args) {
        if (f21899g.mo4006b(2)) {
            f21899g.mo4002a(C5320a.m18119a((Class) cls), C5320a.m18120a(msg, args), tr);
        }
    }

    /* renamed from: a */
    public static void m18135a(String tag, String msg, Throwable tr) {
        if (f21899g.mo4006b(2)) {
            f21899g.mo4002a(tag, msg, tr);
        }
    }

    /* renamed from: a */
    public static void m18127a(Class<?> cls, String msg, Throwable tr) {
        if (f21899g.mo4006b(2)) {
            f21899g.mo4002a(C5320a.m18119a((Class) cls), msg, tr);
        }
    }

    /* renamed from: b */
    public static void m18148b(String tag, String msg) {
        if (f21899g.mo4006b(3)) {
            f21899g.mo4004b(tag, msg);
        }
    }

    /* renamed from: b */
    public static void m18149b(String tag, String msg, Object arg1) {
        if (f21899g.mo4006b(3)) {
            f21899g.mo4004b(tag, C5320a.m18120a(msg, arg1));
        }
    }

    /* renamed from: b */
    public static void m18150b(String tag, String msg, Object arg1, Object arg2) {
        if (f21899g.mo4006b(3)) {
            f21899g.mo4004b(tag, C5320a.m18120a(msg, arg1, arg2));
        }
    }

    /* renamed from: b */
    public static void m18151b(String tag, String msg, Object arg1, Object arg2, Object arg3) {
        if (f21899g.mo4006b(3)) {
            f21899g.mo4004b(tag, C5320a.m18120a(msg, arg1, arg2, arg3));
        }
    }

    /* renamed from: b */
    public static void m18152b(String tag, String msg, Object arg1, Object arg2, Object arg3, Object arg4) {
        if (f21899g.mo4006b(3)) {
            f21899g.mo4004b(tag, C5320a.m18120a(msg, arg1, arg2, arg3, arg4));
        }
    }

    /* renamed from: b */
    public static void m18140b(Class<?> cls, String msg) {
        if (f21899g.mo4006b(3)) {
            f21899g.mo4004b(C5320a.m18119a((Class) cls), msg);
        }
    }

    /* renamed from: b */
    public static void m18141b(Class<?> cls, String msg, Object arg1) {
        if (f21899g.mo4006b(3)) {
            f21899g.mo4004b(C5320a.m18119a((Class) cls), C5320a.m18120a(msg, arg1));
        }
    }

    /* renamed from: b */
    public static void m18142b(Class<?> cls, String msg, Object arg1, Object arg2) {
        if (f21899g.mo4006b(3)) {
            f21899g.mo4004b(C5320a.m18119a((Class) cls), C5320a.m18120a(msg, arg1, arg2));
        }
    }

    /* renamed from: b */
    public static void m18143b(Class<?> cls, String msg, Object arg1, Object arg2, Object arg3) {
        if (f21899g.mo4006b(3)) {
            f21899g.mo4004b(C5320a.m18119a((Class) cls), C5320a.m18120a(msg, arg1, arg2, arg3));
        }
    }

    /* renamed from: b */
    public static void m18144b(Class<?> cls, String msg, Object arg1, Object arg2, Object arg3, Object arg4) {
        if (f21899g.mo4006b(3)) {
            f21899g.mo4004b(C5320a.m18119a((Class) cls), C5320a.m18120a(msg, arg1, arg2, arg3, arg4));
        }
    }

    /* renamed from: b */
    public static void m18154b(String tag, String msg, Object... args) {
        if (f21899g.mo4006b(3)) {
            C5320a.m18148b(tag, C5320a.m18120a(msg, args));
        }
    }

    /* renamed from: b */
    public static void m18155b(String tag, Throwable tr, String msg, Object... args) {
        if (f21899g.mo4006b(3)) {
            C5320a.m18153b(tag, C5320a.m18120a(msg, args), tr);
        }
    }

    /* renamed from: b */
    public static void m18146b(Class<?> cls, String msg, Object... args) {
        if (f21899g.mo4006b(3)) {
            f21899g.mo4004b(C5320a.m18119a((Class) cls), C5320a.m18120a(msg, args));
        }
    }

    /* renamed from: b */
    public static void m18147b(Class<?> cls, Throwable tr, String msg, Object... args) {
        if (f21899g.mo4006b(3)) {
            f21899g.mo4005b(C5320a.m18119a((Class) cls), C5320a.m18120a(msg, args), tr);
        }
    }

    /* renamed from: b */
    public static void m18153b(String tag, String msg, Throwable tr) {
        if (f21899g.mo4006b(3)) {
            f21899g.mo4005b(tag, msg, tr);
        }
    }

    /* renamed from: b */
    public static void m18145b(Class<?> cls, String msg, Throwable tr) {
        if (f21899g.mo4006b(3)) {
            f21899g.mo4005b(C5320a.m18119a((Class) cls), msg, tr);
        }
    }

    /* renamed from: c */
    public static void m18164c(String tag, String msg) {
        if (f21899g.mo4006b(4)) {
            f21899g.mo4007c(tag, msg);
        }
    }

    /* renamed from: c */
    public static void m18165c(String tag, String msg, Object arg1) {
        if (f21899g.mo4006b(4)) {
            f21899g.mo4007c(tag, C5320a.m18120a(msg, arg1));
        }
    }

    /* renamed from: c */
    public static void m18166c(String tag, String msg, Object arg1, Object arg2) {
        if (f21899g.mo4006b(4)) {
            f21899g.mo4007c(tag, C5320a.m18120a(msg, arg1, arg2));
        }
    }

    /* renamed from: c */
    public static void m18167c(String tag, String msg, Object arg1, Object arg2, Object arg3) {
        if (f21899g.mo4006b(4)) {
            f21899g.mo4007c(tag, C5320a.m18120a(msg, arg1, arg2, arg3));
        }
    }

    /* renamed from: c */
    public static void m18168c(String tag, String msg, Object arg1, Object arg2, Object arg3, Object arg4) {
        if (f21899g.mo4006b(4)) {
            f21899g.mo4007c(tag, C5320a.m18120a(msg, arg1, arg2, arg3, arg4));
        }
    }

    /* renamed from: c */
    public static void m18156c(Class<?> cls, String msg) {
        if (f21899g.mo4006b(4)) {
            f21899g.mo4007c(C5320a.m18119a((Class) cls), msg);
        }
    }

    /* renamed from: c */
    public static void m18157c(Class<?> cls, String msg, Object arg1) {
        if (f21899g.mo4006b(4)) {
            f21899g.mo4007c(C5320a.m18119a((Class) cls), C5320a.m18120a(msg, arg1));
        }
    }

    /* renamed from: c */
    public static void m18158c(Class<?> cls, String msg, Object arg1, Object arg2) {
        if (f21899g.mo4006b(4)) {
            f21899g.mo4007c(C5320a.m18119a((Class) cls), C5320a.m18120a(msg, arg1, arg2));
        }
    }

    /* renamed from: c */
    public static void m18159c(Class<?> cls, String msg, Object arg1, Object arg2, Object arg3) {
        if (f21899g.mo4006b(4)) {
            f21899g.mo4007c(C5320a.m18119a((Class) cls), C5320a.m18120a(msg, arg1, arg2, arg3));
        }
    }

    /* renamed from: c */
    public static void m18160c(Class<?> cls, String msg, Object arg1, Object arg2, Object arg3, Object arg4) {
        if (f21899g.mo4006b(4)) {
            f21899g.mo4007c(C5320a.m18119a((Class) cls), C5320a.m18120a(msg, arg1, arg2, arg3, arg4));
        }
    }

    /* renamed from: c */
    public static void m18170c(String tag, String msg, Object... args) {
        if (f21899g.mo4006b(4)) {
            f21899g.mo4007c(tag, C5320a.m18120a(msg, args));
        }
    }

    /* renamed from: c */
    public static void m18171c(String tag, Throwable tr, String msg, Object... args) {
        if (f21899g.mo4006b(4)) {
            f21899g.mo4008c(tag, C5320a.m18120a(msg, args), tr);
        }
    }

    /* renamed from: c */
    public static void m18162c(Class<?> cls, String msg, Object... args) {
        if (f21899g.mo4006b(4)) {
            f21899g.mo4007c(C5320a.m18119a((Class) cls), C5320a.m18120a(msg, args));
        }
    }

    /* renamed from: c */
    public static void m18163c(Class<?> cls, Throwable tr, String msg, Object... args) {
        if (C5320a.m18138a(4)) {
            f21899g.mo4008c(C5320a.m18119a((Class) cls), C5320a.m18120a(msg, args), tr);
        }
    }

    /* renamed from: c */
    public static void m18169c(String tag, String msg, Throwable tr) {
        if (f21899g.mo4006b(4)) {
            f21899g.mo4008c(tag, msg, tr);
        }
    }

    /* renamed from: c */
    public static void m18161c(Class<?> cls, String msg, Throwable tr) {
        if (f21899g.mo4006b(4)) {
            f21899g.mo4008c(C5320a.m18119a((Class) cls), msg, tr);
        }
    }

    /* renamed from: d */
    public static void m18176d(String tag, String msg) {
        if (f21899g.mo4006b(5)) {
            f21899g.mo4009d(tag, msg);
        }
    }

    /* renamed from: d */
    public static void m18172d(Class<?> cls, String msg) {
        if (f21899g.mo4006b(5)) {
            f21899g.mo4009d(C5320a.m18119a((Class) cls), msg);
        }
    }

    /* renamed from: d */
    public static void m18178d(String tag, String msg, Object... args) {
        if (f21899g.mo4006b(5)) {
            f21899g.mo4009d(tag, C5320a.m18120a(msg, args));
        }
    }

    /* renamed from: d */
    public static void m18179d(String tag, Throwable tr, String msg, Object... args) {
        if (f21899g.mo4006b(5)) {
            f21899g.mo4010d(tag, C5320a.m18120a(msg, args), tr);
        }
    }

    /* renamed from: d */
    public static void m18174d(Class<?> cls, String msg, Object... args) {
        if (f21899g.mo4006b(5)) {
            f21899g.mo4009d(C5320a.m18119a((Class) cls), C5320a.m18120a(msg, args));
        }
    }

    /* renamed from: d */
    public static void m18175d(Class<?> cls, Throwable tr, String msg, Object... args) {
        if (C5320a.m18138a(5)) {
            C5320a.m18173d((Class) cls, C5320a.m18120a(msg, args), tr);
        }
    }

    /* renamed from: d */
    public static void m18177d(String tag, String msg, Throwable tr) {
        if (f21899g.mo4006b(5)) {
            f21899g.mo4010d(tag, msg, tr);
        }
    }

    /* renamed from: d */
    public static void m18173d(Class<?> cls, String msg, Throwable tr) {
        if (f21899g.mo4006b(5)) {
            f21899g.mo4010d(C5320a.m18119a((Class) cls), msg, tr);
        }
    }

    /* renamed from: e */
    public static void m18184e(String tag, String msg) {
        if (f21899g.mo4006b(6)) {
            f21899g.mo4011e(tag, msg);
        }
    }

    /* renamed from: e */
    public static void m18180e(Class<?> cls, String msg) {
        if (f21899g.mo4006b(6)) {
            f21899g.mo4011e(C5320a.m18119a((Class) cls), msg);
        }
    }

    /* renamed from: e */
    public static void m18186e(String tag, String msg, Object... args) {
        if (f21899g.mo4006b(6)) {
            f21899g.mo4011e(tag, C5320a.m18120a(msg, args));
        }
    }

    /* renamed from: e */
    public static void m18187e(String tag, Throwable tr, String msg, Object... args) {
        if (f21899g.mo4006b(6)) {
            f21899g.mo4012e(tag, C5320a.m18120a(msg, args), tr);
        }
    }

    /* renamed from: e */
    public static void m18182e(Class<?> cls, String msg, Object... args) {
        if (f21899g.mo4006b(6)) {
            f21899g.mo4011e(C5320a.m18119a((Class) cls), C5320a.m18120a(msg, args));
        }
    }

    /* renamed from: e */
    public static void m18183e(Class<?> cls, Throwable tr, String msg, Object... args) {
        if (f21899g.mo4006b(6)) {
            f21899g.mo4012e(C5320a.m18119a((Class) cls), C5320a.m18120a(msg, args), tr);
        }
    }

    /* renamed from: e */
    public static void m18185e(String tag, String msg, Throwable tr) {
        if (f21899g.mo4006b(6)) {
            f21899g.mo4012e(tag, msg, tr);
        }
    }

    /* renamed from: e */
    public static void m18181e(Class<?> cls, String msg, Throwable tr) {
        if (f21899g.mo4006b(6)) {
            f21899g.mo4012e(C5320a.m18119a((Class) cls), msg, tr);
        }
    }

    /* renamed from: f */
    public static void m18192f(String tag, String msg) {
        if (f21899g.mo4006b(6)) {
            f21899g.mo4013f(tag, msg);
        }
    }

    /* renamed from: f */
    public static void m18188f(Class<?> cls, String msg) {
        if (f21899g.mo4006b(6)) {
            f21899g.mo4013f(C5320a.m18119a((Class) cls), msg);
        }
    }

    /* renamed from: f */
    public static void m18194f(String tag, String msg, Object... args) {
        if (f21899g.mo4006b(6)) {
            f21899g.mo4013f(tag, C5320a.m18120a(msg, args));
        }
    }

    /* renamed from: f */
    public static void m18195f(String tag, Throwable tr, String msg, Object... args) {
        if (f21899g.mo4006b(6)) {
            f21899g.mo4014f(tag, C5320a.m18120a(msg, args), tr);
        }
    }

    /* renamed from: f */
    public static void m18190f(Class<?> cls, String msg, Object... args) {
        if (f21899g.mo4006b(6)) {
            f21899g.mo4013f(C5320a.m18119a((Class) cls), C5320a.m18120a(msg, args));
        }
    }

    /* renamed from: f */
    public static void m18191f(Class<?> cls, Throwable tr, String msg, Object... args) {
        if (f21899g.mo4006b(6)) {
            f21899g.mo4014f(C5320a.m18119a((Class) cls), C5320a.m18120a(msg, args), tr);
        }
    }

    /* renamed from: f */
    public static void m18193f(String tag, String msg, Throwable tr) {
        if (f21899g.mo4006b(6)) {
            f21899g.mo4014f(tag, msg, tr);
        }
    }

    /* renamed from: f */
    public static void m18189f(Class<?> cls, String msg, Throwable tr) {
        if (f21899g.mo4006b(6)) {
            f21899g.mo4014f(C5320a.m18119a((Class) cls), msg, tr);
        }
    }

    /* renamed from: a */
    private static String m18120a(String str, Object... args) {
        return String.format(null, str, args);
    }

    /* renamed from: a */
    private static String m18119a(Class<?> clazz) {
        return clazz.getSimpleName();
    }
}
