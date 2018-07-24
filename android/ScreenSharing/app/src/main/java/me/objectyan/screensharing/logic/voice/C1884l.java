package com.baidu.carlife.logic.voice;

import android.os.Looper;
import android.os.Message;
import com.baidu.carlife.core.MsgBaseHandler;

/* compiled from: VoiceMessageReceiver */
/* renamed from: com.baidu.carlife.logic.voice.l */
public abstract class C1884l extends MsgBaseHandler {
    public C1884l(Looper looper) {
        super(looper);
    }

    public void careAbout() {
        addMsg(4101);
        addMsg(4100);
        addMsg(4159);
        addMsg(4103);
        addMsg(2004);
        addMsg(2009);
        addMsg(2002);
    }

    public void handleMessage(Message msg) {
        switch (msg.what) {
            case 2002:
                mo1703a();
                return;
            case 2004:
                mo1703a();
                return;
            case 2009:
                mo1704b();
                return;
            case 4100:
                mo1708f();
                return;
            case 4101:
                mo1706d();
                return;
            case 4103:
                mo1705c();
                return;
            case 4159:
                mo1707e();
                return;
            default:
                return;
        }
    }

    /* renamed from: c */
    void mo1705c() {
    }

    /* renamed from: d */
    void mo1706d() {
    }

    /* renamed from: e */
    void mo1707e() {
    }

    /* renamed from: f */
    void mo1708f() {
    }

    /* renamed from: a */
    void mo1703a() {
    }

    /* renamed from: b */
    void mo1704b() {
    }
}
