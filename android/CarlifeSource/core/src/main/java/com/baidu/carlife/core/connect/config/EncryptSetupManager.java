package com.baidu.carlife.core.connect.config;

import android.os.Message;

import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.connect.CarlifeCmdMessage;
import com.baidu.carlife.core.connect.ConnectClient;
import com.baidu.carlife.p087l.CarlifeCoreSDK;
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
    private boolean mFlag = false;
    /* renamed from: c */
    private EncryptSetupMsgBaseManager mEncryptSetupMsgBaseManager = new EncryptSetupMsgBaseManager(this);
    /* renamed from: d */
    private boolean f3256d = false;
    /* renamed from: e */
    private Object mObject = new Object();
    /* renamed from: f */
    private Timer mTimer;
    /* renamed from: g */
    private RSAManager mRSAManager = new RSAManager();
    /* renamed from: i */
    private String mKey;

    /* compiled from: EncryptSetupManager */
    /* renamed from: com.baidu.carlife.core.connect.a.e$2 */
    class EncryptSetupManagerTask extends TimerTask {
        /* renamed from: a */
        final /* synthetic */ EncryptSetupManager mEncryptSetupManager;

        EncryptSetupManagerTask(EncryptSetupManager this$0) {
            this.mEncryptSetupManager = this$0;
        }

        public void run() {
            synchronized (this.mEncryptSetupManager.mObject) {
                this.mEncryptSetupManager.mObject.notifyAll();
            }
        }
    }

    /* compiled from: EncryptSetupManager EncryptSetupMsgBaseManager */
    /* renamed from: com.baidu.carlife.core.connect.a.e$a */
    private class EncryptSetupMsgBaseManager extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ EncryptSetupManager mEncryptSetupManager;

        private EncryptSetupMsgBaseManager(EncryptSetupManager encryptSetupManager) {
            this.mEncryptSetupManager = encryptSetupManager;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 98411:
                    DebugLogUtil.newInstance().m4117a("[receive] MSG_CMD_HU_RSA_PUBLIC_KEY_RESPONSE");
                    CarlifeHuRsaPublicKeyResponse rsaResponse = null;
                    try {
                        CarlifeCmdMessage aesKey = (CarlifeCmdMessage) msg.obj;
                        rsaResponse = CarlifeHuRsaPublicKeyResponse.parseFrom(aesKey.getData());
                    } catch (InvalidProtocolBufferException e) {
                        e.printStackTrace();
                    }
                    if (rsaResponse == null) {
                        synchronized (this.mEncryptSetupManager.mObject) {
                            this.mEncryptSetupManager.mObject.notifyAll();
                        }
                        return;
                    }
                    this.mEncryptSetupManager.setKet(rsaResponse.getRsaPublicKey());
                    DebugLogUtil.newInstance().m4117a("[send] MSG_CMD_MD_AES_KEY_SEND_REQUEST");
                    this.mEncryptSetupManager.m4129i();
                    return;
                case 98413:
                    DebugLogUtil.newInstance().m4117a("[receive] MSG_CMD_HU_AES_REC_RESPONSE");
                    this.mEncryptSetupManager.m4128h();
                    EncryptSetupManager.newInstance().setFlag(this.mEncryptSetupManager.m4134b());
                    this.mEncryptSetupManager.f3256d = true;
                    synchronized (this.mEncryptSetupManager.mObject) {
                        this.mEncryptSetupManager.mObject.notifyAll();
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
        MsgHandlerCenter.registerMessageHandler(this.mEncryptSetupMsgBaseManager);
    }

    /* renamed from: a */
    public void m4130a(final IConfigSyncDone syncDone) {
        if (syncDone != null) {
            new Thread((Runnable) this) {
                /* renamed from: b */
                final /* synthetic */ EncryptSetupManager mEncryptSetupManager = null;

                public void run() {
                    if (this.mEncryptSetupManager.m4126f()) {
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
    public void setFlag(boolean flag) {
        this.mFlag = flag;
    }

    /* renamed from: c */
    public boolean getFlag() {
        return this.mFlag;
    }

    /* renamed from: a */
    public void setKet(String key) {
        this.mKey = key;
    }

    /* renamed from: d */
    public String getKey() {
        return this.mKey;
    }

    /* renamed from: e */
    public void m4137e() {
        m4132a(false);
        setFlag(false);
    }

    /* renamed from: f */
    private boolean m4126f() {
        m4127g();
        DebugLogUtil.newInstance().m4117a("[send] MSG_CMD_MD_RSA_PUBLIC_KEY_REQUEST");
        CarlifeCoreSDK.newInstance().disconnected((int) CommonParams.bi);
        synchronized (this.mObject) {
            try {
                this.mObject.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return this.f3256d;
    }

    /* renamed from: g */
    private void m4127g() {
        this.mTimer = new Timer();
        this.mTimer.schedule(new EncryptSetupManagerTask(this), (long) EncryptConfig.f3243c);
    }

    /* renamed from: h */
    private void m4128h() {
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
    }

    /* renamed from: i */
    private int m4129i() {
        PublicKey publicKey = this.mRSAManager.getPublicKey(EncryptSetupManager.newInstance().getKey());
        if (publicKey == null) {
            return -1;
        }
        String encryptedAesKey = this.mRSAManager.getRst(EncryptConfig.newInstance().getAecSeed(), publicKey);
        Builder builder = CarlifeMdAesKeyRequest.newBuilder();
        builder.setAesKey(encryptedAesKey);
        CarlifeMdAesKeyRequest aesKeyRequest = builder.build();
        CarlifeCmdMessage msg = new CarlifeCmdMessage(true);
        msg.setServiceType(CommonParams.bk);
        msg.setData(aesKeyRequest.toByteArray());
        msg.setLength(aesKeyRequest.getSerializedSize());
        ConnectClient.newInstance().sendMsgToService(Message.obtain(null, msg.getServiceType(), 1001, 0, msg));
        return 0;
    }
}
