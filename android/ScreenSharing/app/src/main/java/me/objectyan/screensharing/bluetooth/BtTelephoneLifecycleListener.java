package com.baidu.carlife.bluetooth;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.logic.C1868q;
import com.baidu.carlife.logic.C1868q.C1060g;
import com.baidu.carlife.p087l.CarlifeCoreSDK;

/* compiled from: BtTelephoneLifecycleListener */
/* renamed from: com.baidu.carlife.bluetooth.h */
public class BtTelephoneLifecycleListener extends LifecycleListener {
    /* renamed from: a */
    public static final int f2820a = 3000;
    /* renamed from: b */
    public static final int f2821b = 400;
    /* renamed from: c */
    public static final int f2822c = 1500;
    /* renamed from: e */
    private static final String f2823e = BtTelephoneLifecycleListener.class.getSimpleName();
    /* renamed from: d */
    public Handler f2824d = new C10721(this);
    /* renamed from: f */
    private boolean f2825f = false;
    /* renamed from: g */
    private boolean f2826g = false;
    /* renamed from: h */
    private C1060g f2827h = new C10774(this);

    /* compiled from: BtTelephoneLifecycleListener */
    /* renamed from: com.baidu.carlife.bluetooth.h$1 */
    class C10721 extends Handler {
        /* renamed from: a */
        final /* synthetic */ BtTelephoneLifecycleListener f2814a;

        C10721(BtTelephoneLifecycleListener this$0) {
            this.f2814a = this$0;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case CommonParams.hD /*4304*/:
                    LogUtil.d(BtTelephoneLifecycleListener.f2823e, "Dont see telephone changing event, just send background message");
                    BtHfpProtocolHelper.m3441a(false);
                    C1868q.m7089f().m7114b(this.f2814a.f2827h);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: BtTelephoneLifecycleListener */
    /* renamed from: com.baidu.carlife.bluetooth.h$2 */
    class C10732 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ BtTelephoneLifecycleListener f2815a;

        C10732(BtTelephoneLifecycleListener this$0) {
            this.f2815a = this$0;
        }

        public void run() {
            BtHfpManager.m3397a().m3430l();
            this.f2815a.f2826g = true;
        }
    }

    /* compiled from: BtTelephoneLifecycleListener */
    /* renamed from: com.baidu.carlife.bluetooth.h$3 */
    class C10743 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ BtTelephoneLifecycleListener f2816a;

        C10743(BtTelephoneLifecycleListener this$0) {
            this.f2816a = this$0;
        }

        public void run() {
            CarlifeCoreSDK.m5979a().m6039g();
        }
    }

    /* compiled from: BtTelephoneLifecycleListener */
    /* renamed from: com.baidu.carlife.bluetooth.h$4 */
    class C10774 implements C1060g {
        /* renamed from: a */
        final /* synthetic */ BtTelephoneLifecycleListener f2819a;

        /* compiled from: BtTelephoneLifecycleListener */
        /* renamed from: com.baidu.carlife.bluetooth.h$4$1 */
        class C10751 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C10774 f2817a;

            C10751(C10774 this$1) {
                this.f2817a = this$1;
            }

            public void run() {
                BtHfpManager.m3397a().m3430l();
                this.f2817a.f2819a.f2826g = true;
            }
        }

        /* compiled from: BtTelephoneLifecycleListener */
        /* renamed from: com.baidu.carlife.bluetooth.h$4$2 */
        class C10762 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C10774 f2818a;

            C10762(C10774 this$1) {
                this.f2818a = this$1;
            }

            public void run() {
                BtHfpManager.m3397a().m3430l();
                this.f2818a.f2819a.f2826g = true;
            }
        }

        C10774(BtTelephoneLifecycleListener this$0) {
            this.f2819a = this$0;
        }

        /* renamed from: a */
        public void mo1390a(boolean isBTConnected) {
            LogUtil.d(BtTelephoneLifecycleListener.f2823e, "on PhoneStateIDLE");
        }

        /* renamed from: b */
        public void mo1391b(boolean isBTConnected) {
            LogUtil.d(BtTelephoneLifecycleListener.f2823e, "on PhoneCallRinging");
            if (isBTConnected) {
                LogUtil.d(BtTelephoneLifecycleListener.f2823e, "Telephone event is ongoing, stop send background");
                this.f2819a.f2824d.removeMessages(CommonParams.hD);
                C1868q.m7089f().m7114b(this.f2819a.f2827h);
                this.f2819a.f2824d.postDelayed(new C10751(this), 400);
            }
        }

        /* renamed from: c */
        public void mo1392c(boolean isBTConnected) {
            LogUtil.d(BtTelephoneLifecycleListener.f2823e, "on PhoneStateOffhook");
            if (isBTConnected) {
                LogUtil.d(BtTelephoneLifecycleListener.f2823e, "Telephone event is ongoing, stop send background");
                this.f2819a.f2824d.removeMessages(CommonParams.hD);
                C1868q.m7089f().m7114b(this.f2819a.f2827h);
                this.f2819a.f2824d.postDelayed(new C10762(this), 400);
            }
        }

        /* renamed from: a */
        public void mo1389a() {
            LogUtil.d(BtTelephoneLifecycleListener.f2823e, "on PhoneStateActive");
        }

        /* renamed from: d */
        public void mo1393d(boolean isMultiCall) {
        }
    }

    /* renamed from: a */
    public void mo1394a() {
        LogUtil.d(f2823e, "onStart: ");
    }

    /* renamed from: b */
    public void mo1396b() {
        LogUtil.d(f2823e, "onStop: ");
        this.f2825f = true;
        if (BtHfpManager.m3397a().m3429k()) {
            BtHfpManager.m3397a().m3414a(false);
            this.f2826g = false;
            if (C1868q.m7089f().m7116c() != 0) {
                this.f2824d.postDelayed(new C10732(this), 400);
                LogUtil.d(f2823e, "Telephone is ongoing, stop send background message");
                return;
            }
            LogUtil.d(f2823e, "Delay 1s to see telephone changed");
            C1868q.m7089f().m7111a(this.f2827h);
            Message msg = new Message();
            msg.what = CommonParams.hD;
            this.f2824d.sendMessageDelayed(msg, 1500);
            return;
        }
        BtHfpProtocolHelper.m3441a(false);
    }

    /* renamed from: c */
    public void mo1397c() {
        LogUtil.d(f2823e, "onPause: ");
    }

    /* renamed from: d */
    public void mo1398d() {
        LogUtil.d(f2823e, "onResume: ");
        if (this.f2826g) {
            LogUtil.d(f2823e, "Telephone cause switching and bring carlife to foreground, resume video after 2s");
            new Handler().postDelayed(new C10743(this), 3000);
            this.f2826g = false;
            return;
        }
        LogUtil.d(f2823e, "Resume video at once");
        CarlifeCoreSDK.m5979a().m6039g();
        BtHfpManager.m3397a().m3414a(true);
    }

    /* renamed from: e */
    public void mo1399e() {
        if (this.f2825f) {
            LogUtil.d(f2823e, "onConfigurationChanged:do nothing");
        } else {
            LogUtil.d(f2823e, "onConfigurationChanged:exe onstop");
            mo1396b();
        }
        this.f2825f = false;
    }

    /* renamed from: a */
    public void mo1395a(Intent intent) {
    }
}
