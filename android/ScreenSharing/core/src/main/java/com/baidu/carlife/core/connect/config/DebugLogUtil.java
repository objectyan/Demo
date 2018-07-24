package com.baidu.carlife.core.connect.config;

import android.content.Context;
import android.os.Message;
import android.widget.Toast;
import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.MsgHandlerCenter;

/* compiled from: DebugLogUtil */
/* renamed from: com.baidu.carlife.core.connect.a.c */
public class DebugLogUtil {
    /* renamed from: a */
    private static final boolean f3235a = false;
    /* renamed from: b */
    private static DebugLogUtil f3236b = null;
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
    private class C1202a extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ DebugLogUtil f3234a;

        private C1202a(DebugLogUtil debugLogUtil) {
            this.f3234a = debugLogUtil;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case DebugLogUtil.f3237c /*2222222*/:
                    Toast.makeText(this.f3234a.f3239e, msg.getData().getString("key"), 0).show();
                    return;
                default:
                    return;
            }
        }

        public void careAbout() {
            addMsg(DebugLogUtil.f3237c);
        }
    }

    private DebugLogUtil() {
        MsgHandlerCenter.m4460a(this.f3240f);
    }

    /* renamed from: a */
    public static DebugLogUtil m4115a() {
        if (f3236b == null) {
            f3236b = new DebugLogUtil();
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
