package com.baidu.carlife.core.screen.lightness;

import android.app.Activity;
import android.os.Message;
import android.provider.Settings.System;
import com.baidu.carlife.core.KeepClass;
import com.baidu.carlife.core.MsgBaseHandler;
import com.baidu.carlife.core.CarLifeSettings;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.MsgHandlerCenter;
import com.baidu.carlife.core.screen.OnLightnessCoverListener;
import com.baidu.navisdk.util.common.HttpsClient;

/* compiled from: LightnessControlManager */
/* renamed from: com.baidu.carlife.core.screen.a.a */
public class LightnessControlManager implements KeepClass {
    /* renamed from: a */
    public static final int f3645a = 255;
    /* renamed from: b */
    public static final int f3646b = 1;
    /* renamed from: c */
    public static final int f3647c = 10000;
    /* renamed from: d */
    public static final int f3648d = 30000;
    /* renamed from: e */
    public static final int f3649e = 1000;
    /* renamed from: f */
    private static LightnessControlManager f3650f = null;
    /* renamed from: g */
    private static final String f3651g = "LightnessControlManager";
    /* renamed from: h */
    private static final Object f3652h = new Object();
    /* renamed from: i */
    private C1267a f3653i;
    /* renamed from: j */
    private boolean f3654j;
    /* renamed from: k */
    private boolean f3655k;
    /* renamed from: l */
    private boolean f3656l;
    /* renamed from: m */
    private boolean f3657m;
    /* renamed from: n */
    private boolean f3658n;
    /* renamed from: o */
    private int f3659o;
    /* renamed from: p */
    private OnLightnessCoverListener f3660p;
    /* renamed from: q */
    private WindowLightnessChangeListener f3661q;

    /* compiled from: LightnessControlManager */
    /* renamed from: com.baidu.carlife.core.screen.a.a$a */
    private class C1267a extends MsgBaseHandler {
        /* renamed from: a */
        final /* synthetic */ LightnessControlManager f3644a;

        private C1267a(LightnessControlManager lightnessControlManager) {
            this.f3644a = lightnessControlManager;
        }

        public void careAbout() {
            addMsg(4200);
            addMsg(4201);
            addMsg(4202);
            addMsg(CommonParams.hw);
            addMsg(CommonParams.hy);
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 4200:
                    this.f3644a.m4485a(this.f3644a.f3659o);
                    return;
                case 4201:
                    if (true == this.f3644a.f3655k) {
                        this.f3644a.m4491b(false);
                    }
                    this.f3644a.m4485a(1);
                    return;
                case 4202:
                    this.f3644a.m4492c(false);
                    return;
                case CommonParams.hw /*4250*/:
                    if (this.f3644a.f3660p != null && CarLifeSettings.m4069a().m4095m()) {
                        this.f3644a.f3660p.mo1480b();
                        return;
                    }
                    return;
                case CommonParams.hy /*4252*/:
                    if (this.f3644a.f3660p != null) {
                        this.f3644a.f3660p.mo1479a(false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public LightnessControlManager() {
        this.f3653i = null;
        this.f3654j = true;
        this.f3655k = false;
        this.f3656l = false;
        this.f3657m = false;
        this.f3658n = false;
        this.f3659o = -10;
        this.f3653i = new C1267a();
        MsgHandlerCenter.registerMessageHandler(this.f3653i);
    }

    /* renamed from: a */
    public void m4484a() {
        LogUtil.d(f3651g, "Access to the brightness of the screen");
    }

    /* renamed from: b */
    public static LightnessControlManager m4481b() {
        if (f3650f == null) {
            synchronized (f3652h) {
                if (f3650f == null) {
                    f3650f = new LightnessControlManager();
                }
            }
        }
        return f3650f;
    }

    /* renamed from: a */
    public void m4489a(boolean state) {
        this.f3654j = state;
    }

    /* renamed from: c */
    public boolean m4493c() {
        return this.f3654j;
    }

    /* renamed from: b */
    public void m4491b(boolean state) {
        this.f3655k = state;
    }

    /* renamed from: d */
    public boolean m4495d() {
        return this.f3655k;
    }

    /* renamed from: c */
    public void m4492c(boolean vehicleState) {
        this.f3656l = vehicleState;
    }

    /* renamed from: e */
    public boolean m4497e() {
        return this.f3656l;
    }

    /* renamed from: d */
    public void m4494d(boolean touchMsgState) {
        this.f3657m = touchMsgState;
    }

    /* renamed from: f */
    public boolean m4498f() {
        return this.f3657m;
    }

    /* renamed from: e */
    public void m4496e(boolean state) {
        this.f3658n = state;
    }

    /* renamed from: g */
    public boolean m4499g() {
        return this.f3658n;
    }

    /* renamed from: h */
    public int m4500h() {
        return this.f3659o;
    }

    /* renamed from: a */
    private int m4479a(Activity activity) {
        int brightnessValue = 0;
        try {
            brightnessValue = System.getInt(activity.getContentResolver(), "screen_brightness");
        } catch (Exception e) {
            e.printStackTrace();
        }
        LogUtil.m4437b(f3651g, "brightnessValue is %d", Integer.valueOf(brightnessValue));
        return brightnessValue;
    }

    /* renamed from: a */
    public void m4485a(int value) {
        try {
            LogUtil.m4437b(f3651g, "change screen brightness value = %d", Integer.valueOf(value));
            if (1 != value || this.f3658n) {
                float screenBrightness = ((float) value) / 255.0f;
                boolean screenOn = false;
                if (1 == value) {
                    m4489a(false);
                } else {
                    m4489a(true);
                }
                if (((float) value) != 0.0f) {
                    screenOn = true;
                }
                if (this.f3661q != null) {
                    this.f3661q.mo1345a(screenBrightness, screenOn);
                    return;
                }
                return;
            }
            LogUtil.d(f3651g, "usb is disconnect, the phone will not change");
        } catch (Exception e) {
            LogUtil.d(f3651g, "Can not change bright");
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m4486a(int msgType, boolean delay, int delayTime) {
        LogUtil.m4437b(f3651g, "sendMessageDelayed msgType = %d delayTime = %d", Integer.valueOf(msgType), Integer.valueOf(delayTime));
        if (true == delay) {
            switch (msgType) {
                case 4201:
                    this.f3653i.sendEmptyMessageDelayed(msgType, (long) delayTime);
                    if (!this.f3655k) {
                        m4491b(true);
                        return;
                    }
                    return;
                case 4202:
                    this.f3653i.sendEmptyMessageDelayed(msgType, (long) delayTime);
                    if (!this.f3657m) {
                        m4492c(true);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
        this.f3653i.sendEmptyMessage(msgType);
    }

    /* renamed from: b */
    public void m4490b(int msgType) {
        LogUtil.m4437b(f3651g, "cancleMsgBrightOff msgType = %d", Integer.valueOf(msgType));
        switch (msgType) {
            case 4201:
                LogUtil.d(f3651g, "Cancle messge bright off");
                this.f3653i.removeMessages(msgType);
                m4491b(false);
                return;
            case 4202:
                this.f3653i.removeMessages(msgType);
                m4492c(false);
                return;
            default:
                return;
        }
    }

    /* renamed from: i */
    public void m4501i() {
        LogUtil.d(f3651g, "====vehicleTouchmanage====");
        if (true == this.f3656l) {
            m4490b(4202);
        }
        m4486a(4202, true, 1000);
        m4492c(true);
    }

    /* renamed from: j */
    public void m4502j() {
        LogUtil.d(f3651g, "====brightTouchEvent====");
        if (true == this.f3655k) {
            m4490b(4201);
        }
        if (!this.f3654j) {
            m4485a(this.f3659o);
        }
        m4486a(4201, true, 30000);
    }

    /* renamed from: k */
    public void m4503k() {
        this.f3653i.removeMessages(CommonParams.hw);
    }

    /* renamed from: l */
    public void m4504l() {
        this.f3653i.sendEmptyMessageDelayed(CommonParams.hw, HttpsClient.CONN_MGR_TIMEOUT);
    }

    /* renamed from: a */
    public void m4488a(OnLightnessCoverListener listener) {
        this.f3660p = listener;
    }

    /* renamed from: a */
    public void m4487a(WindowLightnessChangeListener listener) {
        this.f3661q = listener;
    }
}
