package com.baidu.tts.p218b.p219a;

import com.baidu.tts.p218b.p219a.p222a.C4984d;
import com.baidu.tts.p218b.p219a.p222a.C4989c;
import com.baidu.tts.p218b.p219a.p223b.C4995b;
import com.baidu.tts.p218b.p219a.p223b.C5001d;
import com.baidu.tts.p218b.p219a.p223b.C5008e;
import com.baidu.tts.p218b.p219a.p223b.C5013f;
import com.baidu.tts.p233f.C5088f;

/* compiled from: EngineFactory */
/* renamed from: com.baidu.tts.b.a.a */
public class C4994a {
    /* renamed from: a */
    private static volatile C4994a f20708a = null;

    private C4994a() {
    }

    /* renamed from: a */
    public static C4994a m16719a() {
        if (f20708a == null) {
            synchronized (C4994a.class) {
                if (f20708a == null) {
                    f20708a = new C4994a();
                }
            }
        }
        return f20708a;
    }

    /* renamed from: a */
    public C4984d m16723a(C5088f c5088f) {
        switch (c5088f) {
            case ONLINE:
                return m16720b();
            case OFFLINE:
                return m16721c();
            case MIX:
                return m16722d();
            default:
                return null;
        }
    }

    /* renamed from: b */
    private C4984d m16720b() {
        return m16718a(new C5013f());
    }

    /* renamed from: c */
    private C4984d m16721c() {
        return m16718a(new C5008e());
    }

    /* renamed from: d */
    private C4984d m16722d() {
        return m16718a(new C5001d());
    }

    /* renamed from: a */
    private C4984d m16718a(C4995b c4995b) {
        C4984d c4989c = new C4989c();
        c4989c.mo3827a(c4995b);
        return c4989c;
    }
}
