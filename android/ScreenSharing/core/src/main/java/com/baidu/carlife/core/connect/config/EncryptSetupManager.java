package com.baidu.carlife.core.connect.config;

import android.os.Message;

import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.connect.CarlifeCmdMessage;
import com.baidu.carlife.core.connect.ConnectClient;
import com.baidu.carlife.protobuf.CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse;
import com.baidu.carlife.protobuf.CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest;
import com.baidu.carlife.protobuf.CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest.Builder;
import com.google.protobuf.InvalidProtocolBufferException;

import java.security.PublicKey;
import java.util.Timer;
import java.util.TimerTask;

public class EncryptSetupManager {
    /* renamed from: h */
    private static EncryptSetupManager mInstance;
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
    private RSAManager mRSAManager = new RSAManager();
    /* renamed from: i */
    private String f3260i;

    /* compiled from: EncryptSetupManager */
    /* renamed from: com.baidu.carlife.core.connect.a.e$2 */
    class C12062 extends TimerTask {
        /* renamed from: a */
        final /* synthetic */ EncryptSetupManager f3250a;

        C12062(EncryptSetupManager this$0) {
            this.f3250a = this$0;
        }

        public void run() {
            synchronized (this.f3250a.f3257e) {
                this.f3250a.f3257e.notifyAll();
            }
        }
    }

    /* compiled from: EncryptSetupManager c1207a */
    /* renamed from: com.baidu.carlife.core.connect.a.e$a */
    private class EncryptSetupMsgBaseManager extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ EncryptSetupManager f3251a;

        private EncryptSetupMsgBaseManager(EncryptSetupManager encryptSetupManager) {
            this.f3251a = encryptSetupManager;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 98411:
                    DebugLogUtil.m4115a().m4117a("[receive] MSG_CMD_HU_RSA_PUBLIC_KEY_RESPONSE");
                    CarlifeHuRsaPublicKeyResponse rsaResponse = null;
                    try {
                        CarlifeCmdMessage aesKey = (CarlifeCmdMessage) msg.obj;
                        rsaResponse = CarlifeHuRsaPublicKeyResponse.parseFrom(aesKey.getData());
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
                    DebugLogUtil.m4115a().m4117a("[send] MSG_CMD_MD_AES_KEY_SEND_REQUEST");
                    this.f3251a.m4129i();
                    return;
                case 98413:
                    DebugLogUtil.m4115a().m4117a("[receive] MSG_CMD_HU_AES_REC_RESPONSE");
                    this.f3251a.m4128h();
                    EncryptSetupManager.m4120a().m4133b(this.f3251a.m4134b());
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
            addMsg(CommonParams.bj);
            addMsg(CommonParams.bl);
        }
    }

    /* renamed from: a m4120a */
    public static EncryptSetupManager newInstance() {
        if (mInstance == null) {
            mInstance = new EncryptSetupManager();
        }
        return mInstance;
    }

    private EncryptSetupManager() {
        MsgHandlerCenter.m4460a(this.f3255c);
    }

    /* renamed from: a */
    public void m4130a(final IConfigSyncDone syncDone) {
        if (syncDone != null) {
            new Thread(this) {
                /* renamed from: b */
                final /* synthetic */ EncryptSetupManager f3249b = null;

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
        DebugLogUtil.m4115a().m4117a("[send] MSG_CMD_MD_RSA_PUBLIC_KEY_REQUEST");
//        C1663a.m5979a().m6026c((int) CommonParams.bi);
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
        this.f3258f.schedule(new C12062(this), (long) EncryptConfig.f3243c);
    }

    /* renamed from: h */
    private void m4128h() {
        if (this.f3258f != null) {
            this.f3258f.cancel();
        }
    }

    /* renamed from: i */
    private int m4129i() {
        PublicKey publicKey = this.mRSAManager.m4139a(EncryptSetupManager.m4120a().m4136d());
        if (publicKey == null) {
            return -1;
        }
        String encryptedAesKey = this.mRSAManager.m4138a(EncryptConfig.m4118a().m4119b(), publicKey);
        Builder builder = CarlifeMdAesKeyRequest.newBuilder();
        builder.setAesKey(encryptedAesKey);
        CarlifeMdAesKeyRequest aesKeyRequest = builder.build();
        CarlifeCmdMessage msg = new CarlifeCmdMessage(true);
        msg.setServiceType(CommonParams.bk);
        msg.setData(aesKeyRequest.toByteArray());
        msg.setLength(aesKeyRequest.getSerializedSize());
        ConnectClient.m4207a().m4223a(Message.obtain(null, msg.getServiceType(), 1001, 0, msg));
        return 0;
    }
}
