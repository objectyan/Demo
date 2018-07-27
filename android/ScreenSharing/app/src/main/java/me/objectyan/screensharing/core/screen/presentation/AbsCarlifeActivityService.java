package me.objectyan.screensharing.core.screen.presentation;

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
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Log;
import android.view.ActionMode;
import android.view.Display;
import android.view.SearchEvent;
import android.view.Window;
import android.view.WindowManager.InvalidDisplayException;

import me.objectyan.screensharing.core.DisplayUtils;

import me.objectyan.screensharing.core.LogUtil;
import me.objectyan.screensharing.core.screen.OnSurfaceListener;
import me.objectyan.screensharing.core.screen.presentation.view.CarLifePresentationController;
import me.objectyan.screensharing.core.screen.video.Recorder;

@TargetApi(19)
public class AbsCarlifeActivityService extends FragmentActivity implements OnSurfaceListener {

    public static final int f3717a = 20001;

    private static final String Tag = "CarlifeActivity#Service";

    private static boolean f3719c = true;

    private AbsCarlifePresentation mAbsCarlifePresentation;

    private AbsCarlifeFakePresentation mAbsCarlifeFakePresentation;

    private VirtualDisplay mVirtualDisplay;

    private VirtualDisplay mVirtualDisplay1;

    private DisplaySpec mDisplaySpec;

    private final IBinder f3725i = new AbsCarlifeActivityServiceBinder(this);

    private final OnDismissListener mOnDismissListener = new ServiceOnDismissListener(this);

    private Handler mHandler = new ServiceHandler(this);

    //
    class ServiceOnDismissListener implements OnDismissListener {

        final AbsCarlifeActivityService mAbsCarlifeActivityService;

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

    //
    class ServiceHandler extends Handler {

        final AbsCarlifeActivityService mAbsCarlifeActivityService;

        ServiceHandler(AbsCarlifeActivityService this$0) {
            this.mAbsCarlifeActivityService = this$0;
        }

        public void handleMessage(Message msg) {
            Log.i(AbsCarlifeActivityService.Tag, "handleMessage=" + msg.what);
            switch (msg.what) {
                case AbsCarlifeActivityService.f3717a /*20001*/:
                    if (this.mAbsCarlifeActivityService.getSupportFragmentManager().executePendingTransactions()) {
                        Log.i(AbsCarlifeActivityService.Tag, "MSG_DELAY_VEHICLE_CONNECT what=" + msg.what);
                        this.mAbsCarlifeActivityService.mHandler.sendEmptyMessageDelayed(AbsCarlifeActivityService.f3717a, 1000);
                        return;
                    }
                    Log.i(AbsCarlifeActivityService.Tag, " will execute showPresentationImp.");
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

    //
    public class AbsCarlifeActivityServiceBinder extends Binder {

        final AbsCarlifeActivityService mAbsCarlifeActivityService;

        private AbsCarlifeActivityServiceBinder(AbsCarlifeActivityService this$0) {
            this.mAbsCarlifeActivityService = this$0;
        }


        public AbsCarlifeActivityService getCarlifeService() {
            return this.mAbsCarlifeActivityService;
        }
    }


    public void mo1462a(String lable) {
    }


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
        Log.d(Tag, "CarlifeActivityService-onUnbind");
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
        Log.d(Tag, "CarlifeActivityService-onDestroy=" + this);
    }


    public void bindServiceForDisplaySpec(DisplaySpec spec) {
        Log.d(Tag, "CarlifeActivityService-onSurfaceCreated Fake surface. spec=" + spec);
        m4607d(spec);
    }


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
                Log.d(Tag, "mVD.release error:" + e.getMessage());
            }
            this.mVirtualDisplay1 = null;
        }
        if (this.mAbsCarlifeFakePresentation != null) {
            Presentation tempPresentation = this.mAbsCarlifeFakePresentation;
            this.mAbsCarlifeFakePresentation = null;
            tempPresentation.dismiss();
            this.mVirtualDisplay.release();
            this.mVirtualDisplay = null;
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Recorder.newInstance().m4885p();
        }
    }


    private void m4604c(DisplaySpec spec) {
        this.mDisplaySpec = spec;
        if (this.mVirtualDisplay == null) {
            this.mVirtualDisplay = DisplayUtils.m4466a().m4468a(spec, "CarlifeFakePresentation");
            if (this.mVirtualDisplay == null) {
                Log.e(Tag, "Can not make FakeVD");
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
                Log.e(Tag, ex.getMessage());
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
                Log.e(Tag, ex2.getMessage());
            }
        }
    }


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


    private void m4606d() {

//        setFragmentWindow(this.mAbsCarlifePresentation.getWindow());
//        bindDialog(this.mAbsCarlifePresentation);
    }


    private void m4608e() {
        Log.i(Tag, "showPresentationImp  attachHost()");
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
            Log.e(Tag, ex.getMessage());
        }
    }


    public AbsCarlifePresentation mo1460a(AbsCarlifeActivityService outerContext, Display display) {
        return new AbsCarlifePresentation(this, outerContext, display) {

            final AbsCarlifeActivityService mAbsCarlifeActivityService = null;


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

//                    final  C12923 f3713a;


                    public void mo1450a() {
                    }
                };
            }
        };
    }


    public AbsCarlifeFakePresentation mo1459a(Context outerContext, Display display, OnSurfaceListener listener) {
        return new AbsCarlifeFakePresentation(outerContext, display, listener);
    }


//    public void mo1461a(OnFragmentListener listener) {
//    }


    public Notification m4617c() {
        return new Notification();
    }
}
