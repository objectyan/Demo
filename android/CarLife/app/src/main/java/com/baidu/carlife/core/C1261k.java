package com.baidu.carlife.core;

import android.os.Message;

import java.util.ArrayList;
import java.util.List;

/* compiled from: MsgHandlerCenter */
/* renamed from: com.baidu.carlife.core.k */
public class C1261k implements C0689h {
    /* renamed from: a */
    private static final int f3626a = -1;
    /* renamed from: b */
    private static List<C0936j> f3627b = new ArrayList();

    /* renamed from: a */
    public static void m4460a(C0936j handler) {
        if (handler != null && !f3627b.contains(handler)) {
            f3627b.add(handler);
        }
    }

    /* renamed from: b */
    public static void m4464b(C0936j handler) {
        if (handler != null && f3627b.contains(handler)) {
            f3627b.remove(handler);
        }
    }

    /* renamed from: a */
    public static void m4451a() {
        if (f3627b != null) {
            f3627b.clear();
        }
    }

    /* renamed from: a */
    public static void m4452a(int what) {
        if (f3627b != null && !f3627b.isEmpty()) {
            for (int i = 0; i < f3627b.size(); i++) {
                C0936j h = (C0936j) f3627b.get(i);
                if (h != null && h.isAdded(what)) {
                    h.removeMessages(what);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m4457a(int what, int arg1, int arg2, Object b, int delay) {
        if (f3627b != null && !f3627b.isEmpty()) {
            for (int i = 0; i < f3627b.size(); i++) {
                C0936j h = (C0936j) f3627b.get(i);
                if (h != null && h.isAdded(what)) {
                    h.sendMessageDelayed(Message.obtain(h, what, arg1, arg2, b), (long) delay);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m4453a(int what, int delay) {
        C1261k.m4457a(what, -1, -1, null, delay);
    }

    /* renamed from: a */
    public static void m4454a(int what, int arg1, int delay) {
        C1261k.m4457a(what, arg1, -1, null, delay);
    }

    /* renamed from: a */
    public static void m4455a(int what, int arg1, int arg2, int delay) {
        C1261k.m4457a(what, arg1, arg2, null, delay);
    }

    /* renamed from: a */
    public static void m4456a(int what, int arg1, int arg2, Object b) {
        C1261k.m4457a(what, arg1, arg2, b, 0);
    }

    /* renamed from: b */
    public static void m4461b(int what) {
        C1261k.m4456a(what, -1, -1, null);
    }

    /* renamed from: b */
    public static void m4462b(int what, int arg1) {
        C1261k.m4456a(what, arg1, -1, null);
    }

    /* renamed from: a */
    public static void m4458a(int what, int arg1, Object b) {
        C1261k.m4456a(what, arg1, -1, b);
    }

    /* renamed from: b */
    public static void m4463b(int what, int arg1, int arg2) {
        C1261k.m4456a(what, arg1, arg2, null);
    }

    /* renamed from: a */
    public static void m4459a(int what, Object b) {
        C1261k.m4456a(what, -1, -1, b);
    }
}
