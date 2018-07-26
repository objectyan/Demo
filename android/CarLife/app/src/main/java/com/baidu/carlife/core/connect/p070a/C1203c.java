package com.baidu.carlife.core.connect.p070a;

import android.content.Context;
import android.os.Message;
import android.widget.Toast;
import com.baidu.carlife.core.C0936j;
import com.baidu.carlife.core.C1261k;

/* compiled from: DebugLogUtil */
/* renamed from: com.baidu.carlife.core.connect.a.c */
public class C1203c {
    /* renamed from: a */
    private static final boolean f3235a = false;
    /* renamed from: b */
    private static C1203c f3236b = null;
    /* renamed from: c */
    private static final int f3237c = 2222222;
    /* renamed from: d */
    private static final String f3238d = "key";
    /* renamed from: e */
    private Context f3239e;
    /* renamed from: f */
    private C1202a f3240f = new C1202a();

    /* compiled from: DebugLogUtil */
    /* renamed from: com.baidu.carlife.core.connect.a.c$a */
    private class C1202a extends C0936j {
        /* renamed from: a */
        final /* synthetic */ C1203c f3234a;

        private C1202a(C1203c c1203c) {
            this.f3234a = c1203c;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case C1203c.f3237c /*2222222*/:
                    Toast.makeText(this.f3234a.f3239e, msg.getData().getString("key"), 0).show();
                    return;
                default:
                    return;
            }
        }

        public void careAbout() {
            addMsg(C1203c.f3237c);
        }
    }

    private C1203c() {
        C1261k.m4460a(this.f3240f);
    }

    /* renamed from: a */
    public static C1203c m4115a() {
        if (f3236b == null) {
            f3236b = new C1203c();
        }
        return f3236b;
    }

    /* renamed from: a */
    public void m4116a(Context context) {
        this.f3239e = context;
    }

    /* renamed from: a */
    public void m4117a(String str) {
    }
}
