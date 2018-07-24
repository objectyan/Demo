package com.baidu.carlife.core;

import android.os.Message;
import java.util.ArrayList;
import java.util.List;

/* compiled from: MsgHandlerCenter */
/* renamed from: com.baidu.carlife.core.k */
public class MsgHandlerCenter implements KeepClass {
    /* renamed from: a */
    private static final int f3626a = -1;
    /* renamed from: b */
    private static List<MsgBaseHandler> f3627b = new ArrayList();

    /* renamed from: a */
    public static void m4460a(MsgBaseHandler handler) {
        if (handler != null && !f3627b.contains(handler)) {
            f3627b.add(handler);
        }
    }

    /* renamed from: b */
    public static void m4464b(MsgBaseHandler handler) {
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
                MsgBaseHandler h = (MsgBaseHandler) f3627b.get(i);
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
                MsgBaseHandler h = (MsgBaseHandler) f3627b.get(i);
                if (h != null && h.isAdded(what)) {
                    h.sendMessageDelayed(Message.obtain(h, what, arg1, arg2, b), (long) delay);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m4453a(int what, int delay) {
        MsgHandlerCenter.m4457a(what, -1, -1, null, delay);
    }

    /* renamed from: a */
    public static void m4454a(int what, int arg1, int delay) {
        MsgHandlerCenter.m4457a(what, arg1, -1, null, delay);
    }

    /* renamed from: a */
    public static void m4455a(int what, int arg1, int arg2, int delay) {
        MsgHandlerCenter.m4457a(what, arg1, arg2, null, delay);
    }

    /* renamed from: a */
    public static void m4456a(int what, int arg1, int arg2, Object b) {
        MsgHandlerCenter.m4457a(what, arg1, arg2, b, 0);
    }

    /* renamed from: b */
    public static void m4461b(int what) {
        MsgHandlerCenter.m4456a(what, -1, -1, null);
    }

    /* renamed from: b */
    public static void m4462b(int what, int arg1) {
        MsgHandlerCenter.m4456a(what, arg1, -1, null);
    }

    /* renamed from: a */
    public static void m4458a(int what, int arg1, Object b) {
        MsgHandlerCenter.m4456a(what, arg1, -1, b);
    }

    /* renamed from: b */
    public static void m4463b(int what, int arg1, int arg2) {
        MsgHandlerCenter.m4456a(what, arg1, arg2, null);
    }

    /* renamed from: a */
    public static void m4459a(int what, Object b) {
        MsgHandlerCenter.m4456a(what, -1, -1, b);
    }
}
