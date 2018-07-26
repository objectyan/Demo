package com.baidu.android.pushservice.message.p033a;

import android.content.Context;
import com.baidu.android.pushservice.p031j.C0578p;

/* renamed from: com.baidu.android.pushservice.message.a.k */
public class C0611k {
    /* renamed from: a */
    private Context f1910a;

    public C0611k(Context context) {
        this.f1910a = context;
    }

    /* renamed from: a */
    public C0596c m2704a(C0612l c0612l) {
        switch (c0612l) {
            case MSG_TYPE_SINGLE_PRIVATE:
            case MSG_TYPE_MULTI_PRIVATE:
                return new C0605g(this.f1910a);
            case MSG_TYPE_PRIVATE_MESSAGE:
                return new C0607h(this.f1910a);
            case MSG_TYPE_SINGLE_PUBLIC:
            case MSG_TYPE_MULTI_PUBLIC:
                return new C0608i(this.f1910a);
            case MSG_TYPE_MULTI_PRIVATE_NOTIFICATION:
                return new C0602e(this.f1910a);
            case MSG_TYPE_RICH_MEDIA:
                return new C0613m(this.f1910a);
            case MSG_TYPE_BAIDU_SUPPER:
                return new C0598b(this.f1910a);
            case MSG_TYPE_INNERBIND:
                return new C0600d(this.f1910a);
            case MSG_TYPE_ALARM_MESSAGE:
            case MSG_TYPE_ALARM_NOTIFICATION:
            case MSG_TYPE_ALARM_AD_NOTIFICATION:
                return new C0597a(this.f1910a);
            case MSG_TYPE_ULTRON_COMMAND:
                return new C0614n(this.f1910a);
            default:
                C0578p.m2546b(">>> Unknown msg_type : " + c0612l, this.f1910a);
                return null;
        }
    }
}
