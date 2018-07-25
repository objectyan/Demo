package com.baidu.carlife.core.screen.video;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.hardware.display.VirtualDisplay;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjection.Callback;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.Surface;
import com.baidu.carlife.core.AppContext;
import com.baidu.carlife.core.CarlifeScreenUtil;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.connect.CarlifeCmdMessage;
import com.baidu.carlife.core.connect.ConnectClient;
import com.baidu.carlife.core.connect.ConnectManager;
import com.baidu.carlife.core.connect.config.AESManager;
import com.baidu.carlife.core.connect.config.EncryptSetupManager;
import com.baidu.carlife.core.config.CarlifeConfig;
import com.baidu.carlife.core.screen.OnStatusChangeListener;
import com.baidu.carlife.core.screen.presentation.view.CarlifeMaskView;
import com.baidu.carlife.protobuf.CarlifeConnectExceptionProto.CarlifeConnectException;
import com.baidu.carlife.protobuf.CarlifeConnectExceptionProto.CarlifeConnectException.Builder;
import com.baidu.navisdk.BNaviModuleManager.AppSourceDefine;
import com.facebook.imagepipeline.memory.C5628c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Locale;

/* compiled from: Recorder */
/* renamed from: com.baidu.carlife.core.screen.video.e */
public class Recorder {
    /* renamed from: a */
    static final String f3860a = "Recorder";
    /* renamed from: b */
    static int f3861b = 832;
    /* renamed from: c */
    static int f3862c = 480;
    /* renamed from: d */
    static int f3863d = 30;
    /* renamed from: e */
    public static int f3864e = (1000 / f3863d);
    /* renamed from: i */
    private static final String f3865i = "needRectifyColor";
    /* renamed from: j */
    private static final int f3866j = 832;
    /* renamed from: k */
    private static final int f3867k = 480;
    /* renamed from: l */
    private static final int f3868l = 800;
    /* renamed from: m */
    private static final int f3869m = 832;
    /* renamed from: n */
    private static final int f3870n = 768;
    /* renamed from: o */
    private static final int f3871o = 448;
    /* renamed from: p */
    private static final int f3872p = 1024;
    /* renamed from: q */
    private static final long f3873q = 50000;
    /* renamed from: r */
    private static final int f3874r = 15;
    /* renamed from: s */
    private static final int f3875s = 66;
    /* renamed from: t */
    private static final int f3876t = 1;
    /* renamed from: u */
    private static Recorder f3877u;
    /* renamed from: w */
    private static final int[] f3878w = new int[]{6, 7, 15, 21, 16, 19};
    /* renamed from: A */
    private long f3879A = 0;
    /* renamed from: B */
    private MediaCodec f3880B;
    /* renamed from: C */
    private BaseReceiverAndConverterThread f3881C;
    /* renamed from: D */
    private VideoOutputThread f3882D;
    /* renamed from: E */
    private byte[] f3883E = new byte[12];
    /* renamed from: F */
    private boolean f3884F = false;
    /* renamed from: G */
    private boolean f3885G = false;
    /* renamed from: H */
    private boolean f3886H = false;
    /* renamed from: I */
    private boolean f3887I = true;
    /* renamed from: J */
    private boolean f3888J = true;
    /* renamed from: K */
    private boolean f3889K = false;
    /* renamed from: L */
    private boolean f3890L = false;
    /* renamed from: M */
    private boolean f3891M = false;
    /* renamed from: N */
    private boolean f3892N = true;
    /* renamed from: O */
    private boolean f3893O = false;
    /* renamed from: P */
    private boolean f3894P = false;
    /* renamed from: Q */
    private boolean f3895Q = false;
    /* renamed from: R */
    private boolean f3896R = false;
    /* renamed from: S */
    private final Object f3897S = new Object();
    /* renamed from: T */
    private final Object f3898T = new Object();
    /* renamed from: U */
    private final Object f3899U = new Object();
    /* renamed from: V */
    private long f3900V = 0;
    /* renamed from: W */
    private VideoMsgHandler f3901W;
    /* renamed from: X */
    private SharedPreferences f3902X = null;
    /* renamed from: Y */
    private Editor f3903Y = null;
    /* renamed from: Z */
    private AESManager f3904Z = new AESManager();
    private Handler aa = new C13341(this);
    private int ab;
    private int ac = f3861b;
    private int ad = f3862c;
    private int ae = f3861b;
    private int af = f3862c;
    private boolean ag;
    private boolean ah = false;
    private boolean ai = false;
    private MediaProjectionManager aj;
    private MediaProjection ak;
    private VirtualDisplay al;
    private Surface am;
    /* renamed from: f */
    public Bitmap f3905f;
    /* renamed from: g */
    byte[] f3906g;
    /* renamed from: h */
    ByteBuffer f3907h;
    /* renamed from: v */
    private OnStatusChangeListener f3908v;
    /* renamed from: x */
    private int f3909x = 0;
    /* renamed from: y */
    private int f3910y = 0;
    /* renamed from: z */
    private int f3911z = 0;

    /* compiled from: Recorder */
    /* renamed from: com.baidu.carlife.core.screen.video.e$1 */
    class C13341 extends Handler {
        /* renamed from: a */
        final /* synthetic */ Recorder f3856a;

        C13341(Recorder this$0) {
            this.f3856a = this$0;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    this.f3856a.m4814T();
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: Recorder */
    /* renamed from: com.baidu.carlife.core.screen.video.e$2 */
    class C13352 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ Recorder f3857a;

        C13352(Recorder this$0) {
            this.f3857a = this$0;
        }

        public void run() {
            if (this.f3857a.m4884o()) {
                this.f3857a.m4855a(3);
            }
        }
    }

    /* compiled from: Recorder */
    /* renamed from: com.baidu.carlife.core.screen.video.e$3 */
    class C13363 extends Thread {
        /* renamed from: a */
        final /* synthetic */ Recorder f3858a;

        C13363(Recorder this$0) {
            this.f3858a = this$0;
        }

        public void run() {
            synchronized (this.f3858a.f3897S) {
                synchronized (this.f3858a.f3898T) {
                    try {
                        this.f3858a.f3880B.stop();
                        LogUtil.d(Recorder.f3860a, "Recorder mEncoder.stop()");
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    }
                    try {
                        this.f3858a.f3880B.release();
                        LogUtil.d(Recorder.f3860a, "Recorder mEncoder.release");
                    } catch (IllegalStateException e2) {
                        e2.printStackTrace();
                    }
                    try {
                        this.f3858a.f3880B = null;
                        this.f3858a.f3893O = false;
                        if (this.f3858a.am != null) {
                            this.f3858a.am.release();
                            this.f3858a.am = null;
                            LogUtil.d(Recorder.f3860a, "Recorder mEncSurface.release");
                        }
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
    }

    /* compiled from: Recorder */
    /* renamed from: com.baidu.carlife.core.screen.video.e$a */
    private class C1337a extends Callback {
        /* renamed from: a */
        final /* synthetic */ Recorder f3859a;

        private C1337a(Recorder recorder) {
            this.f3859a = recorder;
        }

        public void onStop() {
            this.f3859a.ak = null;
            this.f3859a.m4819Y();
        }
    }

    private Recorder() {
        this.ag = VERSION.SDK_INT >= 21;
        this.f3901W = new VideoMsgHandler();
        if (!this.ag) {
            this.f3902X = AppContext.getAppContext().getSharedPreferences(CommonParams.CAR_LIFE_TEMP, 0);
            this.f3903Y = this.f3902X.edit();
            switch (this.f3902X.getInt(f3865i, -1)) {
                case 0:
                    this.f3886H = false;
                    this.f3885G = true;
                    return;
                case 1:
                    this.f3886H = true;
                    this.f3885G = true;
                    return;
                default:
                    this.f3886H = false;
                    this.f3885G = false;
                    m4816V();
                    return;
            }
        }
    }

    /* renamed from: a */
    public Surface m4854a() {
        return this.am;
    }

    /* renamed from: b */
    public static Recorder m4826b() {
        if (f3877u == null) {
            synchronized (Recorder.class) {
                if (f3877u == null) {
                    f3877u = new Recorder();
                }
            }
        }
        return f3877u;
    }

    /* renamed from: c */
    public static int m4828c() {
        return f3861b;
    }

    /* renamed from: d */
    public static int m4830d() {
        return f3862c;
    }

    /* renamed from: e */
    public boolean m4870e() {
        return this.f3889K;
    }

    /* renamed from: a */
    public void m4859a(boolean isNeedCheckIDRCnt) {
        this.f3884F = isNeedCheckIDRCnt;
    }

    /* renamed from: f */
    void m4871f() {
        this.f3890L = true;
        this.f3889K = true;
    }

    /* renamed from: g */
    void m4873g() {
        this.f3890L = false;
        if (this.f3882D != null) {
            this.f3882D.m4925a(true);
        }
        m4813S();
    }

    /* renamed from: h */
    public void m4875h() {
        this.f3891M = true;
        this.f3889K = true;
    }

    /* renamed from: i */
    public void m4877i() {
        if (this.f3896R) {
            m4849P();
        }
        this.f3891M = false;
        if (this.f3882D != null) {
            this.f3882D.m4925a(true);
        }
        m4813S();
    }

    /* renamed from: j */
    public boolean m4879j() {
        return this.f3894P;
    }

    /* renamed from: b */
    public void m4864b(boolean isJPEGMode) {
        this.f3894P = isJPEGMode;
    }

    /* renamed from: c */
    public void m4866c(boolean isStart) {
        if (f3863d >= 15 && !this.f3894P) {
            if (isStart) {
                this.aa.removeMessages(1);
                try {
                    if (CarlifeConfig.m4065a()) {
                        if (this.f3882D != null) {
                            this.f3882D.m4924a(f3864e / 2);
                        }
                    } else if (this.f3881C != null) {
                        this.f3881C.mo1524a(f3863d);
                    }
                } catch (NullPointerException e) {
                }
            } else if (this.aa != null) {
                this.aa.sendEmptyMessageDelayed(1, 2000);
            }
        }
    }

    /* renamed from: a */
    public boolean m4862a(MotionEvent ev) {
        switch (ev.getAction()) {
            case 0:
                m4866c(true);
                break;
            case 1:
            case 3:
                m4866c(false);
                break;
        }
        return false;
    }

    /* renamed from: a */
    public void m4857a(OnStatusChangeListener listener) {
        this.f3908v = listener;
        this.f3901W.m4911a(listener);
    }

    /* renamed from: k */
    public boolean m4880k() {
        if (!this.f3894P && ConnectClient.newInstance().m4225c()) {
            return this.f3885G;
        }
        return false;
    }

    /* renamed from: l */
    public boolean m4881l() {
        return this.f3886H;
    }

    /* renamed from: d */
    public void m4868d(boolean isNeedChangeColor) {
        if (this.f3886H != isNeedChangeColor && this.f3903Y != null) {
            this.f3886H = isNeedChangeColor;
            if (isNeedChangeColor) {
                this.f3903Y.putInt(f3865i, 1);
                this.f3903Y.commit();
            } else {
                this.f3903Y.putInt(f3865i, 0);
                this.f3903Y.commit();
            }
            if (this.f3910y != 0) {
                JniMethod.prepare(this.f3910y, f3861b, f3862c, isNeedChangeColor);
            }
        }
    }

    /* renamed from: a */
    public void m4855a(int type) {
        CarlifeCmdMessage command = new CarlifeCmdMessage(true);
        command.setServiceType(CommonParams.aE);
        Builder builder = CarlifeConnectException.newBuilder();
        builder.setExceptionType(type);
        CarlifeConnectException info = builder.build();
        command.setData(info.toByteArray());
        command.setLength(info.getSerializedSize());
        ConnectClient.newInstance().m4223a(Message.obtain(null, command.getServiceType(), 1001, 0, command));
    }

    /* renamed from: m */
    public void m4882m() {
        if (CarlifeConfig.m4065a()) {
            LogUtil.d(f3860a, " onActivityPause internal screen capture ");
        } else {
            LogUtil.d(f3860a, " onActivityPause fullscreen capture, Invoke's Recorder pauseFromMobile() ");
            m4866c(false);
            m4875h();
        }
        if (m4884o() && this.aa != null) {
            this.aa.postDelayed(new C13352(this), 300);
        }
    }

    /* renamed from: n */
    public boolean m4883n() {
        if (CarlifeConfig.m4065a() || !this.ag || this.ak != null || m4879j()) {
            return true;
        }
        return false;
    }

    /* renamed from: o */
    public boolean m4884o() {
        return this.ah;
    }

    /* renamed from: e */
    public void m4869e(boolean mIsPauseBy50) {
        this.ah = mIsPauseBy50;
    }

    /* renamed from: p */
    public void m4885p() {
        m4815U();
        m4841H();
    }

    /* renamed from: q */
    int m4886q() {
        return this.f3910y;
    }

    /* renamed from: r */
    boolean m4887r() {
        return this.f3887I;
    }

    /* renamed from: f */
    void m4872f(boolean isFirstEncodeFrame) {
        this.f3887I = isFirstEncodeFrame;
    }

    /* renamed from: s */
    boolean m4888s() {
        return this.f3892N;
    }

    /* renamed from: g */
    void m4874g(boolean isFirstPausingFrame) {
        this.f3892N = isFirstPausingFrame;
    }

    /* renamed from: t */
    int m4889t() {
        return this.f3911z;
    }

    /* renamed from: u */
    long m4890u() {
        return this.f3879A;
    }

    /* renamed from: v */
    void m4891v() {
        LogUtil.d(f3860a, "setInputThreadNull...");
        this.f3881C = null;
    }

    /* renamed from: a */
    void m4858a(Object hehe) {
        this.f3882D = null;
    }

    /* renamed from: w */
    MediaCodec m4892w() {
        return this.f3880B;
    }

    /* renamed from: x */
    Object m4893x() {
        return this.f3897S;
    }

    /* renamed from: y */
    Object m4894y() {
        return this.f3898T;
    }

    /* renamed from: z */
    long m4895z() {
        this.f3900V += 300000;
        return this.f3900V;
    }

    /* renamed from: A */
    void m4834A() {
        if (this.f3882D == null) {
            this.f3882D = new VideoOutputThread();
            this.f3882D.start();
        }
    }

    /* renamed from: B */
    void m4835B() {
        if (this.f3881C != null) {
            this.f3881C.mo1523a();
        }
    }

    /* renamed from: C */
    void m4836C() {
        if (this.f3882D != null) {
            this.f3882D.m4923a();
        }
    }

    /* renamed from: D */
    boolean m4837D() {
        return this.f3888J;
    }

    /* renamed from: E */
    boolean m4838E() {
        return this.f3884F;
    }

    /* renamed from: h */
    void m4876h(boolean isFirstConnect) {
        this.f3888J = isFirstConnect;
    }

    /* renamed from: F */
    void m4839F() {
    }

    /* renamed from: G */
    boolean m4840G() {
        if (this.f3880B == null) {
            return false;
        }
        int dataLength;
        switch (this.f3910y) {
            case 6:
            case 7:
                dataLength = (f3861b * f3862c) * 2;
                break;
            case 15:
            case 16:
                dataLength = (f3861b * f3862c) * 4;
                break;
            case 19:
            case 21:
                dataLength = ((f3861b * f3862c) * 3) / 2;
                break;
            default:
                return false;
        }
        try {
            ByteBuffer[] byteBuffer = this.f3880B.getInputBuffers();
            if (byteBuffer.length != 0 && byteBuffer[0].capacity() >= dataLength) {
                return true;
            }
            this.f3895Q = true;
            return m4817W();
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return m4817W();
        }
    }

    /* renamed from: H */
    boolean m4841H() {
        if (this.f3880B == null || this.f3893O) {
            return false;
        }
        LogUtil.d(f3860a, "Recorder releaseVideoEncoder");
        this.f3893O = true;
        new C13363(this).start();
        return true;
    }

    /* renamed from: I */
    boolean m4842I() {
        if (this.f3880B == null || this.f3893O) {
            return false;
        }
        this.f3893O = true;
        synchronized (this.f3897S) {
            synchronized (this.f3898T) {
                try {
                    this.f3880B.stop();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
                try {
                    this.f3880B.release();
                } catch (IllegalStateException e2) {
                    e2.printStackTrace();
                }
                try {
                    this.f3880B = null;
                    this.f3893O = false;
                    if (this.am != null) {
                        this.am.release();
                        this.am = null;
                    }
                    if (CarlifeConfig.m4065a()) {
                        m4860a(f3861b, f3862c);
                    } else {
                        m4865b(f3861b, f3862c, 0);
                    }
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        return true;
    }

    /* renamed from: J */
    boolean m4843J() {
        return this.f3893O;
    }

    /* renamed from: S */
    private void m4813S() {
        if (!this.f3891M && !this.f3890L) {
            this.f3889K = false;
        }
    }

    /* renamed from: b */
    void m4863b(int newRate) {
        if (newRate >= 3 && newRate <= 30) {
            f3863d = newRate;
            f3864e = 1000 / newRate;
            if (f3863d <= 15) {
                try {
                    if (CarlifeConfig.m4065a()) {
                        if (this.f3882D != null) {
                            this.f3882D.m4924a(f3864e / 2);
                        }
                    } else if (this.f3881C != null) {
                        this.f3881C.mo1524a(f3863d);
                    }
                } catch (NullPointerException e) {
                }
            }
        }
    }

    /* renamed from: T */
    private void m4814T() {
        if (f3863d >= 15) {
            try {
                if (!CarlifeConfig.m4065a() && this.f3881C != null) {
                    this.f3881C.mo1524a(15);
                }
            } catch (NullPointerException e) {
            }
        }
    }

    /* renamed from: K */
    int m4844K() {
        m4866c(true);
        m4866c(false);
        if (this.f3894P) {
            if (this.f3881C == null) {
                if (CarlifeConfig.m4065a()) {
                    this.f3881C = new ReceiverAndConverter50Thread();
                } else {
                    this.f3881C = new ReceiverAndConverterThread();
                }
                this.f3881C.start();
                return 0;
            }
            LogUtil.e(f3860a, "The RecordThread didnt close last time");
            return -1;
        } else if (CarlifeConfig.m4065a()) {
            LogUtil.d(f3860a, "startThread internal screen capture.");
            m4818X();
            return 0;
        } else if (this.ag) {
            m4818X();
            return 0;
        } else {
            LogUtil.d(f3860a, "startThread full screen capture.");
            if (this.f3881C != null) {
                return -1;
            }
            this.f3881C = new ReceiverAndConverterThread();
            this.f3881C.start();
            return 0;
        }
    }

    /* renamed from: U */
    private void m4815U() {
        LogUtil.d(f3860a, "Recorder  ==============================> begin stopThread()");
        if ((CarlifeConfig.m4065a() || this.ag) && !this.f3894P) {
            if (!CarlifeConfig.m4065a()) {
                aa();
                if (this.am != null) {
                    this.am.release();
                }
            } else if (this.f3882D != null) {
                this.f3882D.m4923a();
            }
        } else if (this.f3881C != null) {
            this.f3881C.mo1523a();
        }
        if (this.f3882D != null) {
            this.f3882D.m4923a();
        }
        LogUtil.d(f3860a, "Recorder  ==============================> end stopThread()");
    }

    /* renamed from: V */
    private void m4816V() {
        if (this.f3903Y != null) {
            if (Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).contains("samsung")) {
                if (Build.DEVICE.contains("t03g") || Build.DEVICE.contains("m0")) {
                    this.f3885G = true;
                    this.f3886H = false;
                    this.f3903Y.putInt(f3865i, 0);
                    this.f3903Y.commit();
                }
                if (Build.DEVICE.equals("t03gchn") || Build.DEVICE.equals("m0") || Build.DEVICE.equals("t03gcmcc")) {
                    JniMethod.prepare(this.f3910y, f3861b, f3862c, true);
                    this.f3886H = true;
                    this.f3903Y.putInt(f3865i, 1);
                    this.f3903Y.commit();
                }
            } else if (Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).contains(AppSourceDefine.HUAWEI_SOURCE)) {
                if (Build.DEVICE.contains("hwp6") || Build.DEVICE.contains("hwmt1")) {
                    this.f3885G = true;
                    this.f3886H = false;
                    this.f3903Y.putInt(f3865i, 0);
                    this.f3903Y.commit();
                }
                if (Build.DEVICE.equals("hwmt1-u06") || Build.DEVICE.equals("hwp6-u06") || Build.DEVICE.equals("hwp6-t00") || Build.DEVICE.equals("hwp6s-u06") || Build.DEVICE.equals("hwp6s-t00")) {
                    JniMethod.prepare(this.f3910y, f3861b, f3862c, true);
                    this.f3886H = true;
                    this.f3903Y.putInt(f3865i, 1);
                    this.f3903Y.commit();
                }
            }
        }
    }

    /* renamed from: a */
    boolean m4861a(int destWidth, int destHeight, int destFrameRate) {
        if (destWidth <= 0 || destHeight <= 0) {
            destWidth = 832;
            destHeight = f3862c;
        }
        CarlifeScreenUtil carlifeScreenUtil = CarlifeScreenUtil.m4331a();
        int displayWidth = carlifeScreenUtil.m4351h();
        int displayHeight = carlifeScreenUtil.m4352i();
        if (displayWidth > destWidth) {
            this.ae = destWidth;
            if (displayHeight > destHeight) {
                this.af = destHeight;
            } else {
                this.af = displayHeight;
            }
        } else {
            this.ae = displayWidth;
            this.af = displayHeight;
        }
        f3861b = this.ae;
        f3862c = this.af;
        if (destFrameRate >= 15) {
            destFrameRate = 10;
        }
        if (destFrameRate > 2) {
            f3863d = destFrameRate;
            f3864e = 1000 / destFrameRate;
        }
        return true;
    }

    /* renamed from: b */
    boolean m4865b(int destWidth, int destHeight, int destFrameRate) {
        if (this.f3880B != null) {
            return true;
        }
        if (destWidth <= 0 || destHeight <= 0) {
            destWidth = 832;
            destHeight = f3862c;
        }
        if (destWidth < 800) {
            int wRemain = destWidth % 64;
            if (wRemain >= 32) {
                destWidth = (destWidth + 64) - wRemain;
            } else {
                destWidth -= wRemain;
            }
            f3861b = destWidth;
        }
        CarlifeScreenUtil carlifeScreenUtil = CarlifeScreenUtil.m4331a();
        int displayWidth = carlifeScreenUtil.m4351h();
        int displayHeight = carlifeScreenUtil.m4352i();
        if (displayWidth > f3861b) {
            this.ae = f3861b;
            this.af = (this.ae * displayHeight) / displayWidth;
            this.af -= this.af % 32;
        } else {
            this.ae = displayWidth;
            this.af = displayHeight;
            this.ae -= this.ae % 64;
            this.af -= this.af % 32;
            if (this.af > displayHeight) {
                this.af -= 32;
            }
        }
        f3861b = this.ae;
        f3862c = this.af;
        if (destFrameRate > 2) {
            f3863d = destFrameRate;
            f3864e = 1000 / destFrameRate;
        }
        LogUtil.e(f3860a, "mContainerWidth = " + f3861b + ", mContainerHeight = " + f3862c);
        try {
            this.f3880B = MediaCodec.createEncoderByType("video/avc");
        } catch (Exception e) {
            e.printStackTrace();
        }
        MediaFormat mediaFormat = MediaFormat.createVideoFormat("video/avc", f3861b, f3862c);
        mediaFormat.setInteger("bitrate", 4000000);
        mediaFormat.setInteger("frame-rate", 15);
        mediaFormat.setInteger("i-frame-interval", 1);
        if (this.f3895Q) {
            this.f3909x++;
        }
        this.f3895Q = false;
        while (this.f3909x < f3878w.length) {
            this.f3910y = f3878w[this.f3909x];
            boolean isConfigSuccess = true;
            try {
                mediaFormat.setInteger("color-format", this.f3910y);
                mediaFormat.setInteger("profile", 1);
                mediaFormat.setInteger("level", 256);
                this.f3880B.configure(mediaFormat, null, null, 1);
            } catch (Exception e2) {
                isConfigSuccess = false;
                e2.printStackTrace();
            }
            if (isConfigSuccess) {
                LogUtil.e(f3860a, "with level 3.0 mColorFormat=" + this.f3910y);
                break;
            }
            try {
                mediaFormat = MediaFormat.createVideoFormat("video/avc", f3861b, f3862c);
                mediaFormat.setInteger("bitrate", 4000000);
                mediaFormat.setInteger("frame-rate", 15);
                mediaFormat.setInteger("i-frame-interval", 1);
                mediaFormat.setInteger("color-format", this.f3910y);
                this.f3880B.configure(mediaFormat, null, null, 1);
                LogUtil.e(f3860a, "mColorFormat=" + this.f3910y);
                break;
            } catch (Exception e22) {
                e22.printStackTrace();
                this.f3909x++;
            }
        }
        boolean needErgodic = this.f3909x >= f3878w.length;
        if (needErgodic) {
            this.f3909x = 0;
            this.f3910y = 0;
        }
        while (needErgodic) {
            switch (this.f3909x) {
                case 43:
                    this.f3910y = 2130706688;
                    break;
                case 44:
                    this.f3910y = 2141391872;
                    break;
                case 45:
                    this.f3910y = 2130708361;
                    break;
                default:
                    this.f3910y++;
                    break;
            }
            try {
                mediaFormat.setInteger("color-format", this.f3910y);
                this.f3880B.configure(mediaFormat, null, null, 1);
            } catch (Exception e222) {
                e222.printStackTrace();
                if (this.f3909x < 46) {
                    this.f3909x++;
                }
            }
            if (this.f3909x != 45 || this.f3909x == 46) {
                LogUtil.e(f3860a, "没有合适的参数可完成初始化 n = " + this.f3909x);
                this.f3880B = null;
                return false;
            }
            try {
                this.f3880B.start();
                JniMethod.prepare(this.f3910y, f3861b, f3862c, false);
                if (this.f3885G) {
                    JniMethod.prepare(this.f3910y, f3861b, f3862c, this.f3886H);
                }
                LogUtil.d(f3860a, "initMediaCodec mColorFormat=" + this.f3910y);
                if (CarlifeConfig.m4065a()) {
                }
                return true;
            } catch (IllegalStateException e3) {
                try {
                    this.f3880B.release();
                } catch (IllegalStateException e1) {
                    e1.printStackTrace();
                }
                this.f3880B = null;
                return false;
            }
        }
        if (this.f3909x != 45) {
        }
        LogUtil.e(f3860a, "没有合适的参数可完成初始化 n = " + this.f3909x);
        this.f3880B = null;
        return false;
    }

    /* renamed from: a */
    int m4852a(byte[] input) {
        synchronized (this.f3897S) {
            if (this.f3880B == null) {
                LogUtil.e(f3860a, "还没完成初始化, 或已经被释放");
                return -2;
            }
            try {
                ByteBuffer[] inputBuffers = this.f3880B.getInputBuffers();
                int inputBufferIndex = this.f3880B.dequeueInputBuffer(f3873q);
                if (inputBufferIndex >= 0) {
                    ByteBuffer inputBuffer = inputBuffers[inputBufferIndex];
                    inputBuffer.clear();
                    inputBuffer.put(input);
                    this.f3900V += 300000;
                    this.f3880B.queueInputBuffer(inputBufferIndex, 0, input.length, this.f3900V, 0);
                    return 0;
                }
                LogUtil.m4443d(f3860a, "input2Encoder -1;sendEmptyPacket");
                m4845L();
                return -1;
            } catch (Throwable t) {
                t.printStackTrace();
            }
        }
    }

    /* renamed from: L */
    int m4845L() {
        int a;
        synchronized (this.f3899U) {
            this.f3883E[0] = (byte) 0;
            this.f3883E[1] = (byte) 0;
            this.f3883E[2] = (byte) 0;
            this.f3883E[3] = (byte) 0;
            long timeStamp = System.currentTimeMillis();
            this.f3883E[4] = (byte) ((int) ((2130706432 & timeStamp) >> 24));
            this.f3883E[5] = (byte) ((int) ((16711680 & timeStamp) >> 16));
            this.f3883E[6] = (byte) ((int) ((65280 & timeStamp) >> 8));
            this.f3883E[7] = (byte) ((int) (255 & timeStamp));
            this.f3883E[8] = (byte) 0;
            this.f3883E[9] = (byte) 2;
            this.f3883E[10] = (byte) 0;
            this.f3883E[11] = (byte) 1;
            a = ConnectManager.newInstance().m4236a(this.f3883E, 12);
        }
        return a;
    }

    /* renamed from: M */
    int m4846M() {
        int a;
        synchronized (this.f3899U) {
            this.f3883E[0] = (byte) 0;
            this.f3883E[1] = (byte) 0;
            this.f3883E[2] = (byte) 0;
            this.f3883E[3] = (byte) 0;
            long timeStamp = System.currentTimeMillis();
            this.f3883E[4] = (byte) ((int) ((2130706432 & timeStamp) >> 24));
            this.f3883E[5] = (byte) ((int) ((16711680 & timeStamp) >> 16));
            this.f3883E[6] = (byte) ((int) ((65280 & timeStamp) >> 8));
            this.f3883E[7] = (byte) ((int) (255 & timeStamp));
            this.f3883E[8] = (byte) 0;
            this.f3883E[9] = (byte) 2;
            this.f3883E[10] = (byte) 0;
            this.f3883E[11] = (byte) 2;
            a = ConnectManager.newInstance().m4236a(this.f3883E, 12);
        }
        return a;
    }

    /* renamed from: a */
    int m4853a(byte[] videoData, int length) {
        int a;
        byte[] sendDtata = videoData;
        int sendLen = length;
        if (EncryptSetupManager.newInstance().getFlag() && length > 0) {
            sendDtata = this.f3904Z.m4112a(videoData, length);
            if (sendDtata == null) {
                LogUtil.e(f3860a, "encrypt failed!");
                return -1;
            }
            sendLen = sendDtata.length;
        }
        long timeFlag = System.currentTimeMillis();
        if (timeFlag - this.f3879A > 980) {
            this.f3879A = timeFlag;
            this.f3911z = 1;
        } else {
            this.f3911z++;
        }
        synchronized (this.f3899U) {
            this.f3883E[0] = (byte) ((-16777216 & sendLen) >> 24);
            this.f3883E[1] = (byte) ((16711680 & sendLen) >> 16);
            this.f3883E[2] = (byte) ((65280 & sendLen) >> 8);
            this.f3883E[3] = (byte) (sendLen & 255);
            long timeStamp = System.currentTimeMillis();
            this.f3883E[4] = (byte) ((int) ((-16777216 & timeStamp) >> 24));
            this.f3883E[5] = (byte) ((int) ((16711680 & timeStamp) >> 16));
            this.f3883E[6] = (byte) ((int) ((65280 & timeStamp) >> 8));
            this.f3883E[7] = (byte) ((int) (255 & timeStamp));
            this.f3883E[8] = (byte) 0;
            this.f3883E[9] = (byte) 2;
            this.f3883E[10] = (byte) 0;
            this.f3883E[11] = (byte) 1;
            ConnectManager.newInstance().m4236a(this.f3883E, 12);
            a = ConnectManager.newInstance().m4236a(sendDtata, sendLen);
        }
        return a;
    }

    /* renamed from: W */
    private boolean m4817W() {
        m4841H();
        int i = 3;
        while (i > 0) {
            Thread.sleep(300);
            i--;
            if (this.f3891M) {
                m4846M();
            } else {
                try {
                    m4845L();
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
        if (this.f3893O) {
            this.f3880B = null;
            return false;
        } else if (CarlifeConfig.m4065a()) {
            return false;
        } else {
            m4865b(f3861b, f3862c, 0);
            if (this.f3880B != null) {
                return m4840G();
            }
            return false;
        }
    }

    /* renamed from: a */
    boolean m4860a(int destWidth, int destHeight) {
        if (this.aj != null) {
            return true;
        }
        m4836C();
        synchronized (this.f3897S) {
            synchronized (this.f3898T) {
                if (!(this.f3880B == null || this.am == null)) {
                    try {
                        this.f3880B.stop();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    }
                    try {
                        this.f3880B.release();
                        this.f3880B = null;
                    } catch (IllegalStateException e2) {
                        e2.printStackTrace();
                    }
                    if (this.am != null) {
                        this.am.release();
                        this.am = null;
                    }
                }
                try {
                    this.f3880B = MediaCodec.createEncoderByType("video/avc");
                    CarlifeScreenUtil carlifeScreenUtil = CarlifeScreenUtil.m4331a();
                    if (destWidth >= 800 || carlifeScreenUtil.m4351h() < 768) {
                        if (destWidth >= 800) {
                            if (carlifeScreenUtil.m4351h() >= 832) {
                                this.ae = 832;
                                this.af = 480;
                            }
                        }
                        this.ae = carlifeScreenUtil.m4351h();
                        this.af = carlifeScreenUtil.m4352i();
                        if (this.ae % 64 != 0) {
                            this.ae -= this.ae % 64;
                        }
                        if (this.af % 32 != 0) {
                            this.af -= this.af % 32;
                        }
                    } else {
                        this.ae = 768;
                        this.af = f3871o;
                    }
                    if (CarlifeScreenUtil.m4334m()) {
                        this.ae = 1024;
                        this.af = C5628c.f22756b;
                        LogUtil.d(f3860a, "####### Adapte Video size");
                    }
                    LogUtil.d(f3860a, "####### set vidoe size[" + this.ae + " : " + this.af + "]");
                    if (!(f3861b == this.ae && f3862c == this.af)) {
                        LogUtil.d(f3860a, "####### set setFirstEncodeFrame size[" + this.ae + " : " + this.af + "]");
                        m4872f(true);
                        VideoOutputThread.m4916c();
                    }
                    f3861b = this.ae;
                    f3862c = this.af;
                    if (carlifeScreenUtil.m4354k() == carlifeScreenUtil.m4351h()) {
                        this.ac = this.ae;
                        this.ad = this.af;
                    } else if (carlifeScreenUtil.m4354k() > 0) {
                        this.ac = (this.ae * carlifeScreenUtil.m4354k()) / carlifeScreenUtil.m4351h();
                        this.ac++;
                        this.ad = (this.ac * carlifeScreenUtil.m4355l()) / carlifeScreenUtil.m4354k();
                        if (this.ad > this.af) {
                            this.ad = this.af;
                        }
                    } else {
                        this.ac = this.ae;
                        this.ad = this.af;
                    }
                    boolean isConfigSuccess = true;
                    MediaFormat mediaFormat = MediaFormat.createVideoFormat("video/avc", this.ae, this.af);
                    mediaFormat.setInteger("bitrate", 4000000);
                    mediaFormat.setInteger("frame-rate", 10);
                    mediaFormat.setInteger("i-frame-interval", 1);
                    mediaFormat.setInteger("capture-rate", 10);
                    mediaFormat.setLong("repeat-previous-frame-after", 100000);
                    mediaFormat.setLong("durationUs", 100000);
                    this.f3910y = 2130708361;
                    try {
                        mediaFormat.setInteger("color-format", this.f3910y);
                        mediaFormat.setInteger("profile", 1);
                        mediaFormat.setInteger("level", 256);
                        this.f3880B.configure(mediaFormat, null, null, 1);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        isConfigSuccess = false;
                    }
                    if (!isConfigSuccess) {
                        mediaFormat = MediaFormat.createVideoFormat("video/avc", this.ae, this.af);
                        mediaFormat.setInteger("bitrate", 4000000);
                        mediaFormat.setInteger("frame-rate", 10);
                        mediaFormat.setInteger("i-frame-interval", 1);
                        mediaFormat.setInteger("capture-rate", 10);
                        mediaFormat.setLong("repeat-previous-frame-after", 100000);
                        mediaFormat.setLong("durationUs", 100000);
                        this.f3910y = 2130708361;
                        try {
                            mediaFormat.setInteger("color-format", this.f3910y);
                            this.f3880B.configure(mediaFormat, null, null, 1);
                        } catch (Exception e32) {
                            e32.printStackTrace();
                            return false;
                        }
                    }
                    if (this.am != null) {
                        this.am.release();
                    }
                    this.am = this.f3880B.createInputSurface();
                    CarlifeMaskView.m4741a(this.am);
                    this.f3880B.start();
                } catch (IOException e1) {
                    e1.printStackTrace();
                    return false;
                } catch (IllegalArgumentException e22) {
                    e22.printStackTrace();
                    return false;
                }
            }
        }
        return true;
    }

    /* renamed from: X */
    private void m4818X() {
        if (this.f3882D == null) {
            this.f3882D = new VideoOutputThread();
            this.f3882D.start();
        }
    }

    /* renamed from: c */
    boolean m4867c(int destWidth, int destHeight, int destFrameRate) {
        if (this.f3905f != null) {
            LogUtil.e(f3860a, "重复调用了initMediaCodec50TextureView");
        } else {
            m4861a(destWidth, destHeight, destFrameRate);
            this.f3905f = Bitmap.createBitmap(f3861b, f3862c, Config.ARGB_8888);
        }
        return true;
    }

    /* renamed from: N */
    boolean m4847N() {
        return this.ag;
    }

    /* renamed from: i */
    void m4878i(boolean delayInitScreenShare) {
        this.f3896R = delayInitScreenShare;
    }

    /* renamed from: O */
    public boolean m4848O() {
        return this.f3896R;
    }

    /* renamed from: P */
    public void m4849P() {
        this.f3896R = false;
        if (this.aj == null) {
            Context context = AppContext.getAppContext();
            this.ab = CarlifeScreenUtil.m4331a().m4350g();
            this.aj = (MediaProjectionManager) context.getSystemService("media_projection");
        }
        if (this.ak == null) {
            this.f3908v.mo1347a(this.aj.createScreenCaptureIntent(), 4353);
            this.ah = true;
        }
    }

    /* renamed from: a */
    public void m4856a(int requestCode, int resultCode, Intent data) {
        if (requestCode == 4353) {
            m4869e(false);
            if (resultCode != -1) {
                m4855a(2);
            } else if (this.aj != null) {
                if (this.ak == null) {
                    this.ak = this.aj.getMediaProjection(resultCode, data);
                    this.ak.registerCallback(new C1337a(), null);
                    this.al = m4820Z();
                }
                this.ai = true;
            }
        }
    }

    /* renamed from: Q */
    boolean m4850Q() {
        return this.ai;
    }

    /* renamed from: Y */
    private void m4819Y() {
        if (this.al != null) {
            this.al.release();
            this.al = null;
        }
    }

    /* renamed from: R */
    void m4851R() {
        if (this.ak != null && this.al == null) {
            this.al = m4820Z();
        }
    }

    /* renamed from: Z */
    private VirtualDisplay m4820Z() {
        return this.ak.createVirtualDisplay("ScreenSharingDemo", this.ac, this.ad, this.ab, 25, this.am, null, null);
    }

    private void aa() {
        if (this.ak != null) {
            this.ak.stop();
            this.ak = null;
        }
    }
}
