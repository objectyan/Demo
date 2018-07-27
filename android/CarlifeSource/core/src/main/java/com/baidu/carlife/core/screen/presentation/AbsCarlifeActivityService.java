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
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat.Builder;
import android.view.ActionMode;
import android.view.Display;
import android.view.SearchEvent;
import android.view.Window;
import android.view.WindowManager.InvalidDisplayException;

import com.baidu.carlife.core.DisplayUtils;
import com.baidu.carlife.core.KeepClass;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.core.screen.OnSurfaceListener;
import com.baidu.carlife.core.screen.presentation.view.CarLifePresentationController;
import com.baidu.carlife.core.screen.video.Recorder;

@TargetApi(19)
public class AbsCarlifeActivityService extends FragmentActivity implements KeepClass, OnSurfaceListener {
    /* renamed from: a */
    public static final int f3717a = 20001;
    /* renamed from: b */
    private static final String Tag = "CarlifeActivity#Service";
    /* renamed from: c */
    private static boolean f3719c = true;
    /* renamed from: d */
    private AbsCarlifePresentation mAbsCarlifePresentation;
    /* renamed from: e */
    private AbsCarlifeFakePresentation mAbsCarlifeFakePresentation;
    /* renamed from: f */
    private VirtualDisplay mVirtualDisplay;
    /* renamed from: g */
    private VirtualDisplay mVirtualDisplay1;
    /* renamed from: h */
    private DisplaySpec mDisplaySpec;
    /* renamed from: i */
    private final IBinder f3725i = new AbsCarlifeActivityServiceBinder(this);
    /* renamed from: j */
    private final OnDismissListener mOnDismissListener = new ServiceOnDismissListener(this);
    /* renamed from: k */
    private Handler mHandler = new ServiceHandler(this);

    /* renamed from: com.baidu.carlife.core.screen.presentation.AbsCarlifeActivityService$1 */
    class ServiceOnDismissListener implements OnDismissListener {
        /* renamed from: a */
        final /* synthetic */ AbsCarlifeActivityService mAbsCarlifeActivityService;

        ServiceOnDismissListener(AbsCarlifeActivityService this$0) {
            this.mAbsCarlifeActivityService = this$0;
        }

        public void onDismiss(DialogInterface dialog) {
            if (dialog == this.mAbsCarlifeActivityService.mAbsCarlifePresentation) {
                this.mAbsCarlifeActivityService.mAbsCarlifePresentation = null;
            } else if (dialog != this.mAbsCarlifeActivityService.mAbsCarlifeFakePresentation) {
            } else {
                if (this.mAbsCarlifeActivityService.mAbsCarlifePresentation != null) {
                    this.mAbsCarlifeActivityService.m4604c(this.mAbsCarlifeActivityService.mDisplaySpec);
                } else {
                    this.mAbsCarlifeActivityService.mAbsCarlifeFakePresentation = null;
                }
            }
        }
    }

    /* renamed from: com.baidu.carlife.core.screen.presentation.AbsCarlifeActivityService$2 */
    class ServiceHandler extends Handler {
        /* renamed from: a */
        final /* synthetic */ AbsCarlifeActivityService mAbsCarlifeActivityService;

        ServiceHandler(AbsCarlifeActivityService this$0) {
            this.mAbsCarlifeActivityService = this$0;
        }

        public void handleMessage(Message msg) {
            LogUtil.m4440c(AbsCarlifeActivityService.Tag, "handleMessage=" + msg.what);
            switch (msg.what) {
                case AbsCarlifeActivityService.f3717a /*20001*/:
                    if (this.mAbsCarlifeActivityService.getSupportFragmentManager().executePendingTransactions()) {
                        LogUtil.m4440c(AbsCarlifeActivityService.Tag, "MSG_DELAY_VEHICLE_CONNECT what=" + msg.what);
                        this.mAbsCarlifeActivityService.mHandler.sendEmptyMessageDelayed(AbsCarlifeActivityService.f3717a, 1000);
                        return;
                    }
                    LogUtil.m4440c(AbsCarlifeActivityService.Tag, " will execute showPresentationImp.");
                    if (this.mAbsCarlifeActivityService.mAbsCarlifePresentation != null) {
                        this.mAbsCarlifeActivityService.m4608e();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.carlife.core.screen.presentation.AbsCarlifeActivityService$a */
    public class AbsCarlifeActivityServiceBinder extends Binder {
        /* renamed from: a */
        final /* synthetic */ AbsCarlifeActivityService mAbsCarlifeActivityService;

        private AbsCarlifeActivityServiceBinder(AbsCarlifeActivityService this$0) {
            this.mAbsCarlifeActivityService = this$0;
        }

        /* renamed from: a */
        public AbsCarlifeActivityService getCarlifeService() {
            return this.mAbsCarlifeActivityService;
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
//        super.onBind(intent);
        return this.f3725i;
    }

    public void onRebind(Intent intent) {
//        super.onRebind(intent);
    }

    public boolean onUnbind(Intent intent) {
        LogUtil.d(Tag, "CarlifeActivityService-onUnbind");
//        return super.onUnbind(intent);
        return false;
    }

    public void onCreate() {
//        super.onCreate();
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
//        return super.onStartCommand(intent, flags, startId);
        return 0;
    }

    public void onDestroy() {
        super.onDestroy();
        LogUtil.d(Tag, "CarlifeActivityService-onDestroy=" + this);
    }

    /* renamed from: a */
    public void bindServiceForDisplaySpec(DisplaySpec spec) {
        LogUtil.d(Tag, "CarlifeActivityService-onSurfaceCreated Fake surface. spec=" + spec);
        m4607d(spec);
    }

    /* renamed from: b */
    public boolean m4616b(DisplaySpec spec) {
        f3719c = false;
//        mo1461a((OnFragmentListener) this);
        Builder builder = new Builder(this);
        builder.setSmallIcon(CarLifePresentationController.newInstance().getLaunchIconId()).setWhen(System.currentTimeMillis());
//        startForeground(1000, builder.build());
        ((NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE)).notify(1000, new Notification());
        m4604c(spec);
        return true;
    }

    /* renamed from: b */
    public void m4615b() {
        this.mHandler.removeMessages(f3717a);
        f3719c = true;
        if (this.mAbsCarlifePresentation != null) {
            Presentation tempPresentation = this.mAbsCarlifePresentation;
            this.mAbsCarlifePresentation = null;
            tempPresentation.dismiss();
            try {
                this.mVirtualDisplay1.release();
            } catch (Exception e) {
                LogUtil.d(Tag, "mVD.release error:" + e.getMessage());
            }
            this.mVirtualDisplay1 = null;
        }
        if (this.mAbsCarlifeFakePresentation != null) {
//            tempPresentation = this.mAbsCarlifeFakePresentation;
            this.mAbsCarlifeFakePresentation = null;
//            tempPresentation.dismiss();
            this.mVirtualDisplay.release();
            this.mVirtualDisplay = null;
        }
        Recorder.newInstance().m4885p();
    }

    /* renamed from: c */
    private void m4604c(DisplaySpec spec) {
        this.mDisplaySpec = spec;
        if (this.mVirtualDisplay == null) {
            this.mVirtualDisplay = DisplayUtils.m4466a().m4468a(spec, "CarlifeFakePresentation");
            if (this.mVirtualDisplay == null) {
                LogUtil.e(Tag, "Can not make FakeVD");
                mo1462a("FakeVD创建失败");
                return;
            }
        } else if (this.mAbsCarlifeFakePresentation != null && this.mAbsCarlifeFakePresentation.getDisplay() == this.mVirtualDisplay.getDisplay()) {
            try {
                this.mAbsCarlifeFakePresentation.show();
                return;
            } catch (InvalidDisplayException ex) {
                this.mAbsCarlifeFakePresentation = null;
                this.mVirtualDisplay.release();
                this.mVirtualDisplay = null;
                mo1462a("第一层复用时异常：InvalidDisplayException");
                LogUtil.e(Tag, ex.getMessage());
                return;
            }
        }
        if (!(this.mAbsCarlifeFakePresentation == null || this.mAbsCarlifeFakePresentation.getDisplay() == this.mVirtualDisplay.getDisplay())) {
            this.mAbsCarlifeFakePresentation.dismiss();
            this.mAbsCarlifeFakePresentation = null;
        }
        if (this.mAbsCarlifeFakePresentation == null && this.mVirtualDisplay.getDisplay() != null) {
            this.mAbsCarlifeFakePresentation = mo1459a(this, this.mVirtualDisplay.getDisplay(), this);
            this.mAbsCarlifeFakePresentation.setOnDismissListener(this.mOnDismissListener);
            try {
                this.mAbsCarlifeFakePresentation.show();
            } catch (InvalidDisplayException ex2) {
                this.mAbsCarlifeFakePresentation = null;
                this.mVirtualDisplay.release();
                this.mVirtualDisplay = null;
                mo1462a("第一层异常：InvalidDisplayException");
                LogUtil.e(Tag, ex2.getMessage());
            }
        }
    }

    /* renamed from: d */
    private void m4607d(DisplaySpec spec) {
        if (this.mVirtualDisplay1 != null) {
            this.mVirtualDisplay1.release();
        }
        this.mVirtualDisplay1 = DisplayUtils.m4466a().m4468a(spec, "CarlifePresentation");
        if (this.mAbsCarlifePresentation != null) {
            if (this.mAbsCarlifePresentation.getDisplay() != this.mVirtualDisplay1.getDisplay()) {
                this.mAbsCarlifePresentation.dismiss();
                this.mAbsCarlifePresentation = null;
            } else {
                this.mAbsCarlifePresentation.show();
                return;
            }
        }
        if (this.mAbsCarlifePresentation == null && this.mVirtualDisplay1.getDisplay() != null) {
            this.mAbsCarlifePresentation = mo1460a(this, this.mVirtualDisplay1.getDisplay());
            this.mAbsCarlifePresentation.setOnDismissListener(this.mOnDismissListener);
            int delay = 0;
            if (getSupportFragmentManager().executePendingTransactions()) {
                delay = 1000;
            }
            this.mHandler.sendEmptyMessageDelayed(f3717a, (long) delay);
        }
    }

    /* renamed from: d */
    private void m4606d() {

//        setFragmentWindow(this.mAbsCarlifePresentation.getWindow());
//        bindDialog(this.mAbsCarlifePresentation);
    }

    /* renamed from: e */
    private void m4608e() {
        LogUtil.m4440c(Tag, "showPresentationImp  attachHost()");
//        attachHost();
        m4606d();
        try {
            if (this.mAbsCarlifePresentation != null) {
                this.mAbsCarlifePresentation.show();
            }
        } catch (InvalidDisplayException ex) {
            this.mAbsCarlifePresentation = null;
            mo1462a("第二层异常：InvalidDisplayException");
            if (this.mVirtualDisplay1 != null) {
                this.mVirtualDisplay1.release();
            }
            LogUtil.e(Tag, ex.getMessage());
        }
    }

    /* renamed from: a */
    public AbsCarlifePresentation mo1460a(AbsCarlifeActivityService outerContext, Display display) {
        return new AbsCarlifePresentation(this, outerContext, display) {
            /* renamed from: a */
            final /* synthetic */ AbsCarlifeActivityService mAbsCarlifeActivityService = null;

            /* renamed from: a */
            public AbsCarlifeWindowCallback mo1452a(Window window) {
                return new AbsCarlifeWindowCallback(this, window) {
                    @Override
                    public boolean onSearchRequested(SearchEvent searchEvent) {
                        return false;
                    }

                    @Nullable
                    @Override
                    public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
                        return null;
                    }
                    /* renamed from: a */
//                    final /* synthetic */ C12923 f3713a;

                    /* renamed from: a */
                    public void mo1450a() {
                    }
                };
            }
        };
    }

    /* renamed from: a */
    public AbsCarlifeFakePresentation mo1459a(Context outerContext, Display display, OnSurfaceListener listener) {
        return new AbsCarlifeFakePresentation(outerContext, display, listener);
    }

    /* renamed from: a */
//    public void mo1461a(OnFragmentListener listener) {
//    }

    /* renamed from: c */
    public Notification m4617c() {
        return new Notification();
    }
}
