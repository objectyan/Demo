package com.baidu.carlife.logic;

import android.content.Context;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.logic.voice.C1912n;
import com.baidu.carlife.p087l.CarlifeCoreSDK;
import com.baidu.che.codriver.p122h.C2537a;
import com.baidu.navisdk.util.common.AudioUtils;

/* compiled from: AudioFocusManager */
/* renamed from: com.baidu.carlife.logic.b */
public class C1746b {
    /* renamed from: a */
    private static final String f5277a = "CarLifeMusic";
    /* renamed from: e */
    private static C1746b f5278e;
    /* renamed from: f */
    private static final Object f5279f = new Object();
    /* renamed from: b */
    private HandlerThread f5280b;
    /* renamed from: c */
    private MsgBaseHandler f5281c;
    /* renamed from: d */
    private Context f5282d;
    /* renamed from: g */
    private C1712b f5283g;

    /* compiled from: AudioFocusManager */
    /* renamed from: com.baidu.carlife.logic.b$a */
    private class C1711a extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ C1746b f5231a;
        /* renamed from: b */
        private int f5232b = 0;

        public C1711a(C1746b c1746b, Looper looper) {
            this.f5231a = c1746b;
            super(looper);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 270:
                    switch (msg.arg1) {
                        case -3:
                            LogUtil.d("CarLifeMusic", "---AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK-----");
                            if (!C1765g.m6424a().m6445f() || CarlifeCoreSDK.m5979a().m5989J()) {
                                this.f5231a.f5283g.mo1664b();
                                return;
                            }
                            return;
                        case -2:
                            LogUtil.d("CarLifeMusic", "---AUDIOFOCUS_LOSS_TRANSIENT-----");
                            this.f5231a.f5283g.mo1665b(false);
                            return;
                        case -1:
                            LogUtil.d("CarLifeMusic", "---AUDIOFOCUS_LOSS-----");
                            this.f5231a.f5283g.mo1665b(false);
                            return;
                        case 1:
                            LogUtil.d("CarLifeMusic", "---AUDIOFOCUS_GAIN-----retry:" + this.f5232b);
                            if (C1912n.m7270a().m7313l()) {
                                int i = this.f5232b;
                                this.f5232b = i + 1;
                                if (i < 10) {
                                    sendMessageDelayed(Message.obtain(msg), 100);
                                    return;
                                } else {
                                    this.f5232b = 0;
                                    return;
                                }
                            }
                            this.f5231a.f5283g.mo1663a(false);
                            if (!C1765g.m6424a().m6445f() || CarlifeCoreSDK.m5979a().m5989J()) {
                                this.f5231a.f5283g.mo1662a();
                                return;
                            }
                            return;
                        default:
                            return;
                    }
                case 1002:
                    this.f5231a.f5283g.mo1665b(true);
                    this.f5231a.f5283g.mo1662a();
                    return;
                case 2002:
                    LogUtil.d("CarLifeMusic", "---MSG_TELE_STATE_CHANGE_OFFHOOK-----");
                    this.f5231a.f5283g.mo1665b(false);
                    AudioUtils.pauseTTS(this.f5231a.f5282d);
                    AudioUtils.pauseTTS(this.f5231a.f5282d);
                    return;
                case 2004:
                    LogUtil.d("CarLifeMusic", "---MSG_TELE_STATE_CHANGE_RINGING-----");
                    this.f5231a.f5283g.mo1665b(false);
                    AudioUtils.pauseTTS(this.f5231a.f5282d);
                    AudioUtils.pauseTTS(this.f5231a.f5282d);
                    return;
                case 2009:
                    LogUtil.d("CarLifeMusic", "---MSG_TELE_STATE_CHANGE_IDLE-----");
                    AudioUtils.resumeTTS(this.f5231a.f5282d);
                    this.f5231a.f5283g.mo1663a(false);
                    return;
                default:
                    return;
            }
        }

        public void careAbout() {
            addMsg(270);
            addMsg(2004);
            addMsg(2009);
            addMsg(2002);
            addMsg(1002);
            addMsg(1004);
        }
    }

    /* compiled from: AudioFocusManager */
    /* renamed from: com.baidu.carlife.logic.b$b */
    public interface C1712b {
        /* renamed from: a */
        void mo1662a();

        /* renamed from: a */
        void mo1663a(boolean z);

        /* renamed from: b */
        void mo1664b();

        /* renamed from: b */
        void mo1665b(boolean z);

        /* renamed from: c */
        void mo1666c();
    }

    /* renamed from: a */
    public static C1746b m6334a() {
        if (f5278e == null) {
            synchronized (f5279f) {
                if (f5278e == null) {
                    f5278e = new C1746b();
                }
            }
        }
        return f5278e;
    }

    /* renamed from: a */
    public void m6336a(Context context, C1712b callBack) {
        this.f5282d = context;
        this.f5283g = callBack;
        this.f5280b = new HandlerThread(C2537a.f8326a);
        this.f5280b.start();
        this.f5281c = new C1711a(this, this.f5280b.getLooper());
        MsgHandlerCenter.m4460a(this.f5281c);
    }
}
