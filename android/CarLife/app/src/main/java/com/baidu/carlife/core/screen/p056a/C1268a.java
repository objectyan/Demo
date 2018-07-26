package com.baidu.carlife.core.screen.p056a;

import android.app.Activity;
import android.os.Message;
import android.provider.Settings.System;
import com.baidu.carlife.core.C0689h;
import com.baidu.carlife.core.C0936j;
import com.baidu.carlife.core.C1192c;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1261k;
import com.baidu.carlife.core.screen.C1280h;
import com.baidu.navisdk.util.common.HttpsClient;

/* compiled from: LightnessControlManager */
/* renamed from: com.baidu.carlife.core.screen.a.a */
public class C1268a implements C0689h {
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
    private static C1268a f3650f = null;
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
    private C1280h f3660p;
    /* renamed from: q */
    private C0939b f3661q;

    /* compiled from: LightnessControlManager */
    /* renamed from: com.baidu.carlife.core.screen.a.a$a */
    private class C1267a extends C0936j {
        /* renamed from: a */
        final /* synthetic */ C1268a f3644a;

        private C1267a(C1268a c1268a) {
            this.f3644a = c1268a;
        }

        public void careAbout() {
            addMsg(4200);
            addMsg(4201);
            addMsg(4202);
            addMsg(C1253f.hw);
            addMsg(C1253f.hy);
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
                case C1253f.hw /*4250*/:
                    if (this.f3644a.f3660p != null && C1192c.m4069a().m4095m()) {
                        this.f3644a.f3660p.mo1480b();
                        return;
                    }
                    return;
                case C1253f.hy /*4252*/:
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

    public C1268a() {
        this.f3653i = null;
        this.f3654j = true;
        this.f3655k = false;
        this.f3656l = false;
        this.f3657m = false;
        this.f3658n = false;
        this.f3659o = -10;
        this.f3653i = new C1267a();
        C1261k.m4460a(this.f3653i);
    }

    /* renamed from: a */
    public void m4484a() {
        C1260i.m4435b(f3651g, "Access to the brightness of the screen");
    }

    /* renamed from: b */
    public static C1268a m4481b() {
        if (f3650f == null) {
            synchronized (f3652h) {
                if (f3650f == null) {
                    f3650f = new C1268a();
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
        C1260i.m4437b(f3651g, "brightnessValue is %d", Integer.valueOf(brightnessValue));
        return brightnessValue;
    }

    /* renamed from: a */
    public void m4485a(int value) {
        try {
            C1260i.m4437b(f3651g, "change screen brightness value = %d", Integer.valueOf(value));
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
            C1260i.m4435b(f3651g, "usb is disconnect, the phone will not change");
        } catch (Exception e) {
            C1260i.m4435b(f3651g, "Can not change bright");
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m4486a(int msgType, boolean delay, int delayTime) {
        C1260i.m4437b(f3651g, "sendMessageDelayed msgType = %d delayTime = %d", Integer.valueOf(msgType), Integer.valueOf(delayTime));
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
        C1260i.m4437b(f3651g, "cancleMsgBrightOff msgType = %d", Integer.valueOf(msgType));
        switch (msgType) {
            case 4201:
                C1260i.m4435b(f3651g, "Cancle messge bright off");
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
        C1260i.m4435b(f3651g, "====vehicleTouchmanage====");
        if (true == this.f3656l) {
            m4490b(4202);
        }
        m4486a(4202, true, 1000);
        m4492c(true);
    }

    /* renamed from: j */
    public void m4502j() {
        C1260i.m4435b(f3651g, "====brightTouchEvent====");
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
        this.f3653i.removeMessages(C1253f.hw);
    }

    /* renamed from: l */
    public void m4504l() {
        this.f3653i.sendEmptyMessageDelayed(C1253f.hw, HttpsClient.CONN_MGR_TIMEOUT);
    }

    /* renamed from: a */
    public void m4488a(C1280h listener) {
        this.f3660p = listener;
    }

    /* renamed from: a */
    public void m4487a(C0939b listener) {
        this.f3661q = listener;
    }
}
