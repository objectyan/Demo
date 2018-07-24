package com.baidu.carlife.logic;

import android.content.Context;
import android.media.AudioRecord;
import android.os.Message;
import com.baidu.carlife.bluetooth.BtDeviceManager;
import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.CarlifeUtil;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.connect.CarlifeCmdMessage;
import com.baidu.carlife.core.connect.config.IConfigSyncDone;
import com.baidu.carlife.logic.voice.C1912n;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.protobuf.CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode;
import com.baidu.carlife.protobuf.CarlifeCarHardKeyCodeProto.CarlifeCarHardKeyCode.Builder;
import com.baidu.carlife.protobuf.CarlifeFeatureConfigListProto.CarlifeFeatureConfigList;
import com.baidu.carlife.protobuf.CarlifeFeatureConfigProto.CarlifeFeatureConfig;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: FeatureConfigManager */
/* renamed from: com.baidu.carlife.logic.g */
public class C1765g implements IConfigSyncDone {
    /* renamed from: C */
    private static final Object f5334C = new Object();
    /* renamed from: D */
    private static C1765g f5335D = null;
    /* renamed from: a */
    public static final String f5336a = "VOICE_MIC";
    /* renamed from: b */
    public static final String f5337b = "VOICE_WAKEUP";
    /* renamed from: c */
    public static final String f5338c = "BLUETOOTH_AUTO_PAIR";
    /* renamed from: d */
    public static final String f5339d = "BLUETOOTH_INTERNAL_UI";
    /* renamed from: e */
    public static final String f5340e = "FOCUS_UI";
    /* renamed from: f */
    public static final String f5341f = "MEDIA_SAMPLE_RATE";
    /* renamed from: g */
    public static final String f5342g = "AUDIO_TRANSMISSION_MODE";
    /* renamed from: h */
    public static final String f5343h = "CONTENT_ENCRYPTION";
    /* renamed from: i */
    public static final String f5344i = "ENGINE_TYPE";
    /* renamed from: j */
    public static final String f5345j = "INPUT_DISABLE";
    /* renamed from: k */
    public static final int f5346k = 0;
    /* renamed from: l */
    public static final int f5347l = 1;
    /* renamed from: m */
    public static final int f5348m = 2;
    /* renamed from: n */
    public static final int f5349n = 1;
    /* renamed from: o */
    public static final int f5350o = 0;
    /* renamed from: p */
    public static final int f5351p = 0;
    /* renamed from: q */
    public static final int f5352q = 1;
    /* renamed from: r */
    public static int f5353r = 0;
    /* renamed from: s */
    public static int f5354s = 1;
    /* renamed from: t */
    public static int f5355t = 0;
    /* renamed from: u */
    public static int f5356u = 1;
    /* renamed from: v */
    public static final int f5357v = -1;
    /* renamed from: x */
    public static int f5358x = 1000;
    /* renamed from: y */
    private static final String f5359y = "FeatureConfigManager";
    /* renamed from: A */
    private Timer f5360A = null;
    /* renamed from: B */
    private TimerTask f5361B = null;
    /* renamed from: E */
    private Context f5362E = null;
    /* renamed from: F */
    private List<CarlifeFeatureConfig> f5363F = null;
    /* renamed from: G */
    private MsgBaseHandler f5364G = new C17622(this);
    /* renamed from: w */
    public boolean f5365w = false;
    /* renamed from: z */
    private boolean f5366z = true;

    /* compiled from: FeatureConfigManager */
    /* renamed from: com.baidu.carlife.logic.g$1 */
    class C17611 extends TimerTask {
        /* renamed from: a */
        final /* synthetic */ C1765g f5330a;

        C17611(C1765g this$0) {
            this.f5330a = this$0;
        }

        public void run() {
            if (this.f5330a.f5360A != null) {
                this.f5330a.m6435k();
                MsgHandlerCenter.m4461b(1008);
                this.f5330a.m6440b(true);
            }
        }
    }

    /* compiled from: FeatureConfigManager */
    /* renamed from: com.baidu.carlife.logic.g$2 */
    class C17622 extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ C1765g f5331a;

        C17622(C1765g this$0) {
            this.f5331a = this$0;
        }

        public void careAbout() {
            addMsg(CommonParams.aY);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CommonParams.aY /*98386*/:
                    this.f5331a.f5363F = this.f5331a.m6425a((CarlifeCmdMessage) msg.obj);
                    this.f5331a.m6433i();
                    this.f5331a.m6435k();
                    if (C1663a.m5979a().m6000U()) {
                        LogUtil.d(C1765g.f5359y, "[configure] encrypt: on");
                        C1663a.m5979a().m6011a(this.f5331a);
                        return;
                    }
                    LogUtil.d(C1765g.f5359y, "[configure] encrypt: off");
                    MsgHandlerCenter.m4461b(1007);
                    this.f5331a.m6440b(true);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: FeatureConfigManager */
    /* renamed from: com.baidu.carlife.logic.g$3 */
    class C17633 extends Thread {
        /* renamed from: a */
        final /* synthetic */ C1765g f5332a;

        C17633(C1765g this$0) {
            this.f5332a = this$0;
        }

        public void run() {
            this.f5332a.m6446h();
        }
    }

    /* compiled from: FeatureConfigManager */
    /* renamed from: com.baidu.carlife.logic.g$4 */
    class C17644 extends Thread {
        /* renamed from: a */
        final /* synthetic */ C1765g f5333a;

        C17644(C1765g this$0) {
            this.f5333a = this$0;
        }

        public void run() {
            LogUtil.d("CarLifeVoice", "request mic permission");
            MsgHandlerCenter.m4453a((int) CommonParams.gV, 400);
            this.f5333a.m6446h();
            MsgHandlerCenter.m4452a((int) CommonParams.gV);
            MsgHandlerCenter.m4461b((int) CommonParams.gW);
        }
    }

    private C1765g() {
    }

    /* renamed from: a */
    public static C1765g m6424a() {
        if (f5335D == null) {
            synchronized (f5334C) {
                if (f5335D == null) {
                    f5335D = new C1765g();
                }
            }
        }
        return f5335D;
    }

    /* renamed from: a */
    public void m6437a(Context context) {
        this.f5362E = context;
        MsgHandlerCenter.m4460a(this.f5364G);
    }

    /* renamed from: b */
    public void m6439b() {
        C1663a.m5979a().m6026c((int) CommonParams.aX);
        m6434j();
        m6440b(false);
    }

    /* renamed from: a */
    private List<CarlifeFeatureConfig> m6425a(CarlifeCmdMessage cmd) {
        List<CarlifeFeatureConfig> list = null;
        try {
            CarlifeFeatureConfigList list2 = CarlifeFeatureConfigList.parseFrom(cmd.m4205f());
            if (list2 != null) {
                list = list2.getFeatureConfigList();
            }
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
        return list;
    }

    /* renamed from: a */
    public int m6436a(String key) {
        if (this.f5363F == null || this.f5363F.isEmpty()) {
            return -1;
        }
        for (CarlifeFeatureConfig config : this.f5363F) {
            if (key.equals(config.getKey())) {
                return config.getValue();
            }
        }
        return -1;
    }

    /* renamed from: c */
    public boolean m6442c() {
        return m6436a(f5340e) == 1;
    }

    /* renamed from: d */
    public boolean m6443d() {
        return this.f5366z;
    }

    /* renamed from: i */
    private void m6433i() {
        if (this.f5363F != null && !this.f5363F.isEmpty()) {
            try {
                for (CarlifeFeatureConfig config : this.f5363F) {
                    LogUtil.d(f5359y, "------key:" + config.getKey() + "----value:" + config.getValue());
                    if (f5338c.equals(config.getKey())) {
                        BtDeviceManager.m3360a().m3378a(config.getKey(), config.getValue());
                    } else if (f5339d.equals(config.getKey())) {
                        BtDeviceManager.m3360a().m3378a(config.getKey(), config.getValue());
                    } else if (f5340e.equals(config.getKey())) {
                        if (config.getValue() == 1) {
                            C1765g.m6429a(24);
                            C1765g.m6429a(23);
                        }
                    } else if (f5341f.equals(config.getKey())) {
                        C1663a.m5979a().m6020b(config.getValue());
                        LogUtil.d(f5359y, "KEY_MEDIA_SAMPLE_RATE = " + config.getValue());
                    } else if (f5336a.equals(config.getKey())) {
                        C1772k.m6480a().m6485a(6, config.getValue());
                        C1912n.m7270a().m7319r();
                    } else if (f5337b.equals(config.getKey())) {
                        C1912n.m7270a().m7302c(config.getValue() == 1);
                    } else if (f5342g.equals(config.getKey())) {
                        C1663a.m5979a().m6004a(config.getValue());
                        LogUtil.d(f5359y, "KEY_AUDIO_TRANSMISSION_MODE = " + config.getValue());
                    } else if (f5343h.equals(config.getKey())) {
                        boolean encryptConfigSwitch;
                        if (config.getValue() == 1) {
                            encryptConfigSwitch = true;
                        } else {
                            encryptConfigSwitch = false;
                        }
                        C1663a.m5979a().m6037f(encryptConfigSwitch);
                    } else if (f5344i.equals(config.getKey())) {
                        LogUtil.d(f5359y, "engine type: " + config.getValue());
                    } else if (f5345j.equals(config.getKey())) {
                        if (config.getValue() == f5354s) {
                            this.f5366z = true;
                        } else {
                            this.f5366z = false;
                        }
                        LogUtil.d(f5359y, "####### KEY_INPUT_DISABLE:" + config.getValue());
                    } else {
                        LogUtil.m4445e(f5359y, "the key is error:" + config.getKey());
                    }
                }
            } catch (Exception ex) {
                LogUtil.m4445e(f5359y, "feature config get exception");
                ex.printStackTrace();
            }
        }
    }

    /* renamed from: e */
    public void m6444e() {
        this.f5363F = null;
        this.f5366z = true;
    }

    /* renamed from: j */
    private void m6434j() {
        try {
            LogUtil.d(f5359y, "Wait for Feature Config Timer Start");
            this.f5360A = new Timer();
            this.f5361B = new C17611(this);
            this.f5360A.schedule(this.f5361B, (long) f5358x);
        } catch (Exception ex) {
            LogUtil.d(f5359y, "startTimer get exception");
            ex.printStackTrace();
        }
    }

    /* renamed from: k */
    private void m6435k() {
        LogUtil.m4445e(f5359y, "Wait for Feature Config Stop");
        if (this.f5360A != null) {
            this.f5360A.cancel();
            this.f5360A = null;
        }
        if (this.f5361B != null) {
            this.f5361B.cancel();
            this.f5361B = null;
        }
    }

    /* renamed from: f */
    public boolean m6445f() {
        return this.f5365w;
    }

    /* renamed from: b */
    public void m6440b(boolean is) {
        this.f5365w = is;
        CarlifeUtil.m4358a();
        CarlifeUtil.m4366c(is);
    }

    /* renamed from: a */
    public static void m6429a(int keycode) {
        CarlifeCmdMessage carlifeMsg = new CarlifeCmdMessage(true);
        carlifeMsg.m4201c(CommonParams.bL);
        Builder builder = CarlifeCarHardKeyCode.newBuilder();
        builder.setKeycode(keycode);
        CarlifeCarHardKeyCode keyCode = builder.build();
        carlifeMsg.m4199b(keyCode.toByteArray());
        carlifeMsg.m4203d(keyCode.getSerializedSize());
        MsgHandlerCenter.m4457a(CommonParams.bL, 0, 0, carlifeMsg, 500);
    }

    /* renamed from: g */
    public static void m6432g() {
        if (C1765g.m6424a().m6442c()) {
            C1765g.m6429a(24);
            C1765g.m6429a(23);
        }
    }

    /* renamed from: c */
    public void m6441c(boolean isFirestRequest) {
        if (isFirestRequest) {
            new C17633(this).start();
        } else if (C1765g.m6424a().m6445f() && C1765g.m6424a().m6436a(f5336a) == 1) {
            new C17644(this).start();
        }
    }

    /* renamed from: h */
    public void m6446h() {
        AudioRecord mRecordInstance;
        IllegalStateException e;
        IllegalArgumentException e2;
        try {
            mRecordInstance = new AudioRecord(6, 16000, 16, 2, 65536);
            try {
                mRecordInstance.startRecording();
                mRecordInstance.stop();
            } catch (IllegalStateException e3) {
                e = e3;
                e.printStackTrace();
                if (mRecordInstance != null) {
                    mRecordInstance.release();
                }
            } catch (IllegalArgumentException e4) {
                e2 = e4;
                e2.printStackTrace();
                if (mRecordInstance != null) {
                    mRecordInstance.release();
                }
            }
        } catch (IllegalStateException e5) {
            e = e5;
            mRecordInstance = null;
            e.printStackTrace();
            if (mRecordInstance != null) {
                mRecordInstance.release();
            }
        } catch (IllegalArgumentException e6) {
            e2 = e6;
            mRecordInstance = null;
            e2.printStackTrace();
            if (mRecordInstance != null) {
                mRecordInstance.release();
            }
        }
        if (mRecordInstance != null) {
            mRecordInstance.release();
        }
    }

    /* renamed from: a */
    public void mo1641a(boolean flag) {
        if (flag) {
            C1663a.m5979a().m6026c((int) CommonParams.bm);
            m6440b(true);
            MsgHandlerCenter.m4461b(1007);
            return;
        }
        C1663a.m5979a().m5994O();
    }
}
