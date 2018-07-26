package com.baidu.android.pushservice.message;

import android.content.Context;

/* renamed from: com.baidu.android.pushservice.message.a */
public class C0615a {
    /* renamed from: a */
    private Context f1929a;

    public C0615a(Context context) {
        this.f1929a = context;
    }

    /* renamed from: a */
    public C0616c m2710a(C0622h c0622h) {
        switch (c0622h) {
            case MSG_ID_HANDSHAKE:
                return new C0617b(this.f1929a);
            case MSG_ID_HEARTBEAT_SERVER:
            case MSG_ID_TINY_HEARTBEAT_SERVER:
                return new C0627l(this.f1929a);
            case MSG_ID_PUSH_MSG:
                return new C0625j(this.f1929a);
            default:
                return null;
        }
    }
}
