package com.baidu.carlife.core.screen.presentation;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Presentation;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.hardware.display.VirtualDisplay;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.OnFragmentListener;
import android.support.v4.app.Service;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager.InvalidDisplayException;
import com.baidu.carlife.core.C0689h;
import com.baidu.carlife.core.C1260i;
import com.baidu.carlife.core.C1263m;
import com.baidu.carlife.core.screen.C1282k;
import com.baidu.carlife.core.screen.presentation.p071a.C1299b;
import com.baidu.carlife.core.screen.video.C1338e;

@TargetApi(19)
public class AbsCarlifeActivityService extends Service implements C0689h, C1282k {
    /* renamed from: a */
    public static final int f3717a = 20001;
    /* renamed from: b */
    private static final String f3718b = "CarlifeActivity#Service";
    /* renamed from: c */
    private static boolean f3719c = true;
    /* renamed from: d */
    private C1291b f3720d;
    /* renamed from: e */
    private C1322a f3721e;
    /* renamed from: f */
    private VirtualDisplay f3722f;
    /* renamed from: g */
    private VirtualDisplay f3723g;
    /* renamed from: h */
    private C1329i f3724h;
    /* renamed from: i */
    private final IBinder f3725i = new C1293a();
    /* renamed from: j */
    private final OnDismissListener f3726j = new C12871(this);
    /* renamed from: k */
    private Handler f3727k = new C12882(this);

    /* renamed from: com.baidu.carlife.core.screen.presentation.AbsCarlifeActivityService$1 */
    class C12871 implements OnDismissListener {
        /* renamed from: a */
        final /* synthetic */ AbsCarlifeActivityService f3709a;

        C12871(AbsCarlifeActivityService this$0) {
            this.f3709a = this$0;
        }

        public void onDismiss(DialogInterface dialog) {
            if (dialog == this.f3709a.f3720d) {
                this.f3709a.f3720d = null;
            } else if (dialog != this.f3709a.f3721e) {
            } else {
                if (this.f3709a.f3720d != null) {
                    this.f3709a.m4604c(this.f3709a.f3724h);
                } else {
                    this.f3709a.f3721e = null;
                }
            }
        }
    }

    /* renamed from: com.baidu.carlife.core.screen.presentation.AbsCarlifeActivityService$2 */
    class C12882 extends Handler {
        /* renamed from: a */
        final /* synthetic */ AbsCarlifeActivityService f3710a;

        C12882(AbsCarlifeActivityService this$0) {
            this.f3710a = this$0;
        }

        public void handleMessage(Message msg) {
            C1260i.m4440c(AbsCarlifeActivityService.f3718b, "handleMessage=" + msg.what);
            switch (msg.what) {
                case AbsCarlifeActivityService.f3717a /*20001*/:
                    if (this.f3710a.getSupportFragmentManager().isPendingActionWillExecuteOrExecuting()) {
                        C1260i.m4440c(AbsCarlifeActivityService.f3718b, "MSG_DELAY_VEHICLE_CONNECT what=" + msg.what);
                        this.f3710a.f3727k.sendEmptyMessageDelayed(AbsCarlifeActivityService.f3717a, 1000);
                        return;
                    }
                    C1260i.m4440c(AbsCarlifeActivityService.f3718b, " will execute showPresentationImp.");
                    if (this.f3710a.f3720d != null) {
                        this.f3710a.m4608e();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.carlife.core.screen.presentation.AbsCarlifeActivityService$a */
    public class C1293a extends Binder {
        /* renamed from: a */
        final /* synthetic */ AbsCarlifeActivityService f3716a;

        private C1293a(AbsCarlifeActivityService this$0) {
            this.f3716a = this$0;
        }

        /* renamed from: a */
        public AbsCarlifeActivityService m4596a() {
            return this.f3716a;
        }
    }

    /* renamed from: a */
    public void mo1462a(String lable) {
    }

    /* renamed from: a */
    public static boolean m4601a() {
        return f3719c;
    }

    public IBinder onBind(Intent intent) {
        super.onBind(intent);
        return this.f3725i;
    }

    public void onRebind(Intent intent) {
        super.onRebind(intent);
    }

    public boolean onUnbind(Intent intent) {
        C1260i.m4435b(f3718b, "CarlifeActivityService-onUnbind");
        return super.onUnbind(intent);
    }

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    public void onDestroy() {
        super.onDestroy();
        C1260i.m4435b(f3718b, "CarlifeActivityService-onDestroy=" + this);
    }

    /* renamed from: a */
    public void mo1453a(C1329i spec) {
        C1260i.m4435b(f3718b, "CarlifeActivityService-onSurfaceCreated Fake surface. spec=" + spec);
        m4607d(spec);
    }

    /* renamed from: b */
    public boolean m4616b(C1329i spec) {
        f3719c = false;
        mo1461a((OnFragmentListener) this);
        Builder builder = new Builder(this);
        builder.setSmallIcon(C1299b.m4626b().m4639g()).setWhen(System.currentTimeMillis());
        startForeground(1000, builder.build());
        ((NotificationManager) getSystemService("notification")).notify(1000, new Notification());
        m4604c(spec);
        return true;
    }

    /* renamed from: b */
    public void m4615b() {
        this.f3727k.removeMessages(f3717a);
        f3719c = true;
        if (this.f3720d != null) {
            Presentation tempPresentation = this.f3720d;
            this.f3720d = null;
            tempPresentation.dismiss();
            try {
                this.f3723g.release();
            } catch (Exception e) {
                C1260i.m4435b(f3718b, "mVD.release error:" + e.getMessage());
            }
            this.f3723g = null;
        }
        if (this.f3721e != null) {
            tempPresentation = this.f3721e;
            this.f3721e = null;
            tempPresentation.dismiss();
            this.f3722f.release();
            this.f3722f = null;
        }
        C1338e.m4826b().m4885p();
    }

    /* renamed from: c */
    private void m4604c(C1329i spec) {
        this.f3724h = spec;
        if (this.f3722f == null) {
            this.f3722f = C1263m.m4466a().m4468a(spec, "CarlifeFakePresentation");
            if (this.f3722f == null) {
                C1260i.m4445e(f3718b, "Can not make FakeVD");
                mo1462a("FakeVD创建失败");
                return;
            }
        } else if (this.f3721e != null && this.f3721e.getDisplay() == this.f3722f.getDisplay()) {
            try {
                this.f3721e.show();
                return;
            } catch (InvalidDisplayException ex) {
                this.f3721e = null;
                this.f3722f.release();
                this.f3722f = null;
                mo1462a("第一层复用时异常：InvalidDisplayException");
                C1260i.m4445e(f3718b, ex.getMessage());
                return;
            }
        }
        if (!(this.f3721e == null || this.f3721e.getDisplay() == this.f3722f.getDisplay())) {
            this.f3721e.dismiss();
            this.f3721e = null;
        }
        if (this.f3721e == null && this.f3722f.getDisplay() != null) {
            this.f3721e = mo1459a(this, this.f3722f.getDisplay(), this);
            this.f3721e.setOnDismissListener(this.f3726j);
            try {
                this.f3721e.show();
            } catch (InvalidDisplayException ex2) {
                this.f3721e = null;
                this.f3722f.release();
                this.f3722f = null;
                mo1462a("第一层异常：InvalidDisplayException");
                C1260i.m4445e(f3718b, ex2.getMessage());
            }
        }
    }

    /* renamed from: d */
    private void m4607d(C1329i spec) {
        if (this.f3723g != null) {
            this.f3723g.release();
        }
        this.f3723g = C1263m.m4466a().m4468a(spec, "CarlifePresentation");
        if (this.f3720d != null) {
            if (this.f3720d.getDisplay() != this.f3723g.getDisplay()) {
                this.f3720d.dismiss();
                this.f3720d = null;
            } else {
                this.f3720d.show();
                return;
            }
        }
        if (this.f3720d == null && this.f3723g.getDisplay() != null) {
            this.f3720d = mo1460a(this, this.f3723g.getDisplay());
            this.f3720d.setOnDismissListener(this.f3726j);
            int delay = 0;
            if (getSupportFragmentManager().isPendingActionWillExecuteOrExecuting()) {
                delay = 1000;
            }
            this.f3727k.sendEmptyMessageDelayed(f3717a, (long) delay);
        }
    }

    /* renamed from: d */
    private void m4606d() {
        setFragmentWindow(this.f3720d.getWindow());
        bindDialog(this.f3720d);
    }

    /* renamed from: e */
    private void m4608e() {
        C1260i.m4440c(f3718b, "showPresentationImp  attachHost()");
        attachHost();
        m4606d();
        try {
            if (this.f3720d != null) {
                this.f3720d.show();
            }
        } catch (InvalidDisplayException ex) {
            this.f3720d = null;
            mo1462a("第二层异常：InvalidDisplayException");
            if (this.f3723g != null) {
                this.f3723g.release();
            }
            C1260i.m4445e(f3718b, ex.getMessage());
        }
    }

    /* renamed from: a */
    public C1291b mo1460a(AbsCarlifeActivityService outerContext, Display display) {
        return new C1291b(this, outerContext, display) {
            /* renamed from: a */
            final /* synthetic */ AbsCarlifeActivityService f3715a;

            /* renamed from: a */
            public C1289c mo1452a(Window window) {
                return new C1289c(this, window) {
                    /* renamed from: a */
                    final /* synthetic */ C12923 f3713a;

                    /* renamed from: a */
                    public void mo1450a() {
                    }
                };
            }
        };
    }

    /* renamed from: a */
    public C1322a mo1459a(Context outerContext, Display display, C1282k listener) {
        return new C1322a(outerContext, display, listener);
    }

    /* renamed from: a */
    public void mo1461a(OnFragmentListener listener) {
    }

    /* renamed from: c */
    public Notification m4617c() {
        return new Notification();
    }
}
