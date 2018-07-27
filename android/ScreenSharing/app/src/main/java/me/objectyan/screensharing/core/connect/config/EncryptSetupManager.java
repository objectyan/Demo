package me.objectyan.screensharing.core.connect.config;

import android.os.Message;

import me.objectyan.screensharing.core.CommonParams;
import me.objectyan.screensharing.core.MsgBaseHandler;
import me.objectyan.screensharing.core.MsgHandlerCenter;
import me.objectyan.screensharing.core.connect.CarlifeCmdMessage;
import me.objectyan.screensharing.core.connect.ConnectClient;
import me.objectyan.screensharing.util.CarlifeCoreSDK;
import me.objectyan.screensharing.protobuf.CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse;
import me.objectyan.screensharing.protobuf.CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest;
import me.objectyan.screensharing.protobuf.CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest.Builder;
import com.google.protobuf.InvalidProtocolBufferException;

import java.security.PublicKey;
import java.util.Timer;
import java.util.TimerTask;

public class EncryptSetupManager {

    private static EncryptSetupManager mInstance;

    private boolean f3253a = false;

    private boolean mFlag = false;

    private EncryptSetupMsgBaseManager mEncryptSetupMsgBaseManager = new EncryptSetupMsgBaseManager(this);

    private boolean f3256d = false;

    private Object mObject = new Object();

    private Timer mTimer;

    private RSAManager mRSAManager = new RSAManager();

    private String mKey;


    class EncryptSetupManagerTask extends TimerTask {

        final  EncryptSetupManager mEncryptSetupManager;

        EncryptSetupManagerTask(EncryptSetupManager this$0) {
            this.mEncryptSetupManager = this$0;
        }

        public void run() {
            synchronized (this.mEncryptSetupManager.mObject) {
                this.mEncryptSetupManager.mObject.notifyAll();
            }
        }
    }

    /*  EncryptSetupMsgBaseManager */
    //
    private class EncryptSetupMsgBaseManager extends MsgBaseHandler {

        final  EncryptSetupManager mEncryptSetupManager;

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

    /*  m4120a */
    public static EncryptSetupManager newInstance() {
        if (mInstance == null) {
            mInstance = new EncryptSetupManager();
        }
        return mInstance;
    }

    private EncryptSetupManager() {
        MsgHandlerCenter.registerMessageHandler(this.mEncryptSetupMsgBaseManager);
    }


    public void m4130a(final IConfigSyncDone syncDone) {
        if (syncDone != null) {
            new Thread((Runnable) this) {

                final  EncryptSetupManager mEncryptSetupManager = null;

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


    public void m4132a(boolean flag) {
        this.f3253a = flag;
    }


    public boolean m4134b() {
        return this.f3253a;
    }


    public void setFlag(boolean flag) {
        this.mFlag = flag;
    }


    public boolean getFlag() {
        return this.mFlag;
    }


    public void setKet(String key) {
        this.mKey = key;
    }


    public String getKey() {
        return this.mKey;
    }


    public void m4137e() {
        m4132a(false);
        setFlag(false);
    }


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


    private void m4127g() {
        this.mTimer = new Timer();
        this.mTimer.schedule(new EncryptSetupManagerTask(this), (long) EncryptConfig.f3243c);
    }


    private void m4128h() {
        if (this.mTimer != null) {
            this.mTimer.cancel();
        }
    }


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
