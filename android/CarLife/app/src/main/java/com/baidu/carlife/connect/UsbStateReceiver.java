package com.baidu.carlife.connect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1251e;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.screen.C0672b;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.carlife.core.screen.presentation.p071a.C1309g;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.carlife.view.dialog.C1953c;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import java.util.Timer;
import java.util.TimerTask;

public class UsbStateReceiver extends BroadcastReceiver {
    /* renamed from: a */
    private static final String f2956a = "UsbConnectStateReceiver";
    /* renamed from: b */
    private static final String f2957b = "android.hardware.usb.action.USB_STATE";
    /* renamed from: c */
    private static UsbStateReceiver f2958c = null;
    /* renamed from: h */
    private static final int f2959h = 10000;
    /* renamed from: d */
    private Context f2960d = null;
    /* renamed from: e */
    private boolean f2961e = false;
    /* renamed from: f */
    private Timer f2962f = null;
    /* renamed from: g */
    private TimerTask f2963g = null;
    /* renamed from: i */
    private C1953c f2964i = null;
    /* renamed from: j */
    private C1277e f2965j = null;

    /* renamed from: com.baidu.carlife.connect.UsbStateReceiver$2 */
    class C11532 implements C0672b {
        /* renamed from: a */
        final /* synthetic */ UsbStateReceiver f2954a;

        C11532(UsbStateReceiver this$0) {
            this.f2954a = this$0;
        }

        public void onClick() {
            this.f2954a.m3867h();
            if (this.f2954a.f2965j != null) {
                this.f2954a.f2965j.dismissDialog(this.f2954a.f2964i);
            }
        }
    }

    /* renamed from: com.baidu.carlife.connect.UsbStateReceiver$3 */
    class C11543 implements OnClickListener {
        /* renamed from: a */
        final /* synthetic */ UsbStateReceiver f2955a;

        C11543(UsbStateReceiver this$0) {
            this.f2955a = this$0;
        }

        public void onClick(View v) {
            this.f2955a.m3871d();
        }
    }

    /* renamed from: a */
    public static UsbStateReceiver m3857a() {
        if (f2958c == null) {
            synchronized (UsbStateReceiver.class) {
                if (f2958c == null) {
                    f2958c = new UsbStateReceiver();
                }
            }
        }
        return f2958c;
    }

    /* renamed from: a */
    public void m3868a(Context context) {
        this.f2960d = context;
        m3869b();
    }

    /* renamed from: b */
    public void m3869b() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(f2957b);
        this.f2960d.registerReceiver(this, filter);
    }

    /* renamed from: c */
    public void m3870c() {
        this.f2960d.unregisterReceiver(this);
    }

    public void onReceive(Context context, Intent intent) {
        this.f2965j = C1309g.m4699a().m4701b();
        String action = intent.getAction();
        Message msg = new Message();
        msg.what = 1031;
        if (!action.equals(f2957b)) {
            return;
        }
        if (intent.getExtras().getBoolean("connected")) {
            C1260i.m4435b(f2956a, "usb connect is changed: connected");
            msg.arg1 = C1253f.fe;
            if (!this.f2961e) {
                m3863e();
            }
            this.f2961e = true;
            return;
        }
        C1260i.m4435b(f2956a, "usb connect is changed: disconnected");
        msg.arg1 = C1253f.ff;
        this.f2961e = false;
    }

    /* renamed from: e */
    private void m3863e() {
        m3865f();
        final Handler mHandlerTimer = new Handler();
        try {
            C1260i.m4435b(f2956a, "startTimer for usb debug switch");
            this.f2962f = new Timer();
            this.f2963g = new TimerTask(this) {
                /* renamed from: b */
                final /* synthetic */ UsbStateReceiver f2953b;

                /* renamed from: com.baidu.carlife.connect.UsbStateReceiver$1$1 */
                class C11501 implements Runnable {
                    /* renamed from: a */
                    final /* synthetic */ C11521 f2950a;

                    C11501(C11521 this$1) {
                        this.f2950a = this$1;
                    }

                    public void run() {
                        this.f2950a.f2953b.m3866g();
                    }
                }

                /* renamed from: com.baidu.carlife.connect.UsbStateReceiver$1$2 */
                class C11512 implements Runnable {
                    /* renamed from: a */
                    final /* synthetic */ C11521 f2951a;

                    C11512(C11521 this$1) {
                        this.f2951a = this$1;
                    }

                    public void run() {
                        this.f2951a.f2953b.m3871d();
                    }
                }

                public void run() {
                    if (this.f2953b.f2962f != null) {
                        this.f2953b.m3865f();
                        if (C1663a.m5979a().m5998S() != 1 || C1251e.m4358a().m4402x()) {
                            mHandlerTimer.post(new C11512(this));
                        } else {
                            mHandlerTimer.post(new C11501(this));
                        }
                    }
                }
            };
            this.f2962f.schedule(this.f2963g, BNOffScreenParams.MIN_ENTER_INTERVAL);
        } catch (Exception e) {
            C1260i.m4435b(f2956a, "startTimer get exception for usb debug switch");
            e.printStackTrace();
        }
    }

    /* renamed from: f */
    private void m3865f() {
        C1260i.m4435b(f2956a, "stopTimer for usb debug switch");
        if (this.f2962f != null) {
            this.f2962f.cancel();
            this.f2962f = null;
        }
        if (this.f2963g != null) {
            this.f2963g.cancel();
            this.f2963g = null;
        }
    }

    /* renamed from: g */
    private void m3866g() {
        if (this.f2964i == null) {
            this.f2964i = new C1953c(this.f2960d).m7442b((int) C0965R.string.connectguide_dialog_title).m7435a((int) C0965R.string.connectguide_dialog_hint).m7447c((int) C0965R.string.connectguide_dialog_ok).m7438a(new C11532(this));
            this.f2964i.getContentView().setCompoundDrawablesWithIntrinsicBounds(0, C0965R.drawable.com_ic_usb_debug, 0, 0);
            ImageButton cancelButton = this.f2964i.getTitlebntRight();
            cancelButton.setVisibility(0);
            cancelButton.setOnClickListener(new C11543(this));
        }
        if (this.f2965j != null) {
            this.f2965j.showDialog(this.f2964i);
        }
    }

    /* renamed from: d */
    public void m3871d() {
        if (this.f2965j != null) {
            this.f2965j.dismissDialog(this.f2964i);
        }
    }

    /* renamed from: h */
    private void m3867h() {
        try {
            this.f2960d.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
