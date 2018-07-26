package com.baidu.carlife.core.connect.p070a;

import android.os.Message;
import com.baidu.carlife.core.C0936j;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.connect.C1212c;
import com.baidu.carlife.core.connect.C1215d;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.protobuf.CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse;
import com.baidu.carlife.protobuf.CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest;
import com.baidu.carlife.protobuf.CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest.Builder;
import com.google.protobuf.InvalidProtocolBufferException;
import java.security.PublicKey;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: EncryptSetupManager */
/* renamed from: com.baidu.carlife.core.connect.a.e */
public class C1208e {
    /* renamed from: h */
    private static C1208e f3252h;
    /* renamed from: a */
    private boolean f3253a = false;
    /* renamed from: b */
    private boolean f3254b = false;
    /* renamed from: c */
    private C1207a f3255c = new C1207a();
    /* renamed from: d */
    private boolean f3256d = false;
    /* renamed from: e */
    private Object f3257e = new Object();
    /* renamed from: f */
    private Timer f3258f;
    /* renamed from: g */
    private C1209f f3259g = new C1209f();
    /* renamed from: i */
    private String f3260i;

    /* compiled from: EncryptSetupManager */
    /* renamed from: com.baidu.carlife.core.connect.a.e$2 */
    class C12062 extends TimerTask {
        /* renamed from: a */
        final /* synthetic */ C1208e f3250a;

        C12062(C1208e this$0) {
            this.f3250a = this$0;
        }

        public void run() {
            synchronized (this.f3250a.f3257e) {
                this.f3250a.f3257e.notifyAll();
            }
        }
    }

    /* compiled from: EncryptSetupManager */
    /* renamed from: com.baidu.carlife.core.connect.a.e$a */
    private class C1207a extends C0936j {
        /* renamed from: a */
        final /* synthetic */ C1208e f3251a;

        private C1207a(C1208e c1208e) {
            this.f3251a = c1208e;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case C1253f.bj /*98411*/:
                    C1203c.m4115a().m4117a("[receive] MSG_CMD_HU_RSA_PUBLIC_KEY_RESPONSE");
                    CarlifeHuRsaPublicKeyResponse rsaResponse = null;
                    try {
                        rsaResponse = CarlifeHuRsaPublicKeyResponse.parseFrom(msg.obj.m4205f());
                    } catch (InvalidProtocolBufferException e) {
                        e.printStackTrace();
                    }
                    if (rsaResponse == null) {
                        synchronized (this.f3251a.f3257e) {
                            this.f3251a.f3257e.notifyAll();
                        }
                        return;
                    }
                    this.f3251a.m4131a(rsaResponse.getRsaPublicKey());
                    C1203c.m4115a().m4117a("[send] MSG_CMD_MD_AES_KEY_SEND_REQUEST");
                    this.f3251a.m4129i();
                    return;
                case C1253f.bl /*98413*/:
                    C1203c.m4115a().m4117a("[receive] MSG_CMD_HU_AES_REC_RESPONSE");
                    this.f3251a.m4128h();
                    C1208e.m4120a().m4133b(this.f3251a.m4134b());
                    this.f3251a.f3256d = true;
                    synchronized (this.f3251a.f3257e) {
                        this.f3251a.f3257e.notifyAll();
                    }
                    return;
                default:
                    return;
            }
        }

        public void careAbout() {
            addMsg(C1253f.bj);
            addMsg(C1253f.bl);
        }
    }

    /* renamed from: a */
    public static C1208e m4120a() {
        if (f3252h == null) {
            f3252h = new C1208e();
        }
        return f3252h;
    }

    private C1208e() {
        C1261k.m4460a(this.f3255c);
    }

    /* renamed from: a */
    public void m4130a(final C1199a syncDone) {
        if (syncDone != null) {
            new Thread(this) {
                /* renamed from: b */
                final /* synthetic */ C1208e f3249b;

                public void run() {
                    if (this.f3249b.m4126f()) {
                        syncDone.mo1641a(true);
                    } else {
                        syncDone.mo1641a(false);
                    }
                }
            }.start();
        }
    }

    /* renamed from: a */
    public void m4132a(boolean flag) {
        this.f3253a = flag;
    }

    /* renamed from: b */
    public boolean m4134b() {
        return this.f3253a;
    }

    /* renamed from: b */
    public void m4133b(boolean flag) {
        this.f3254b = flag;
    }

    /* renamed from: c */
    public boolean m4135c() {
        return this.f3254b;
    }

    /* renamed from: a */
    public void m4131a(String key) {
        this.f3260i = key;
    }

    /* renamed from: d */
    public String m4136d() {
        return this.f3260i;
    }

    /* renamed from: e */
    public void m4137e() {
        m4132a(false);
        m4133b(false);
    }

    /* renamed from: f */
    private boolean m4126f() {
        m4127g();
        C1203c.m4115a().m4117a("[send] MSG_CMD_MD_RSA_PUBLIC_KEY_REQUEST");
        C1663a.m5979a().m6026c((int) C1253f.bi);
        synchronized (this.f3257e) {
            try {
                this.f3257e.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.f3256d;
    }

    /* renamed from: g */
    private void m4127g() {
        this.f3258f = new Timer();
        this.f3258f.schedule(new C12062(this), (long) C1204d.f3243c);
    }

    /* renamed from: h */
    private void m4128h() {
        if (this.f3258f != null) {
            this.f3258f.cancel();
        }
    }

    /* renamed from: i */
    private int m4129i() {
        PublicKey publicKey = this.f3259g.m4139a(C1208e.m4120a().m4136d());
        if (publicKey == null) {
            return -1;
        }
        String encryptedAesKey = this.f3259g.m4138a(C1204d.m4118a().m4119b(), publicKey);
        Builder builder = CarlifeMdAesKeyRequest.newBuilder();
        builder.setAesKey(encryptedAesKey);
        CarlifeMdAesKeyRequest aesKeyRequest = builder.build();
        C1212c msg = new C1212c(true);
        msg.m4201c(C1253f.bk);
        msg.m4199b(aesKeyRequest.toByteArray());
        msg.m4203d(aesKeyRequest.getSerializedSize());
        C1215d.m4207a().m4223a(Message.obtain(null, msg.m4202d(), 1001, 0, msg));
        return 0;
    }
}
