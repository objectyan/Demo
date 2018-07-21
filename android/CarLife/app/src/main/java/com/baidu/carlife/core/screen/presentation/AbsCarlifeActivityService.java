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
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NotificationCompat.Builder;
import android.support.v4.app.OnFragmentListener;
import android.support.v4.app.Service;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager.InvalidDisplayException;
import com.baidu.carlife.core.h;
import com.baidu.carlife.core.m;
import com.baidu.carlife.core.screen.k;
import com.baidu.carlife.core.screen.video.e;

@TargetApi(19)
public class AbsCarlifeActivityService
  extends Service
  implements h, k
{
  public static final int a = 20001;
  private static final String b = "CarlifeActivity#Service";
  private static boolean c = true;
  private b d;
  private a e;
  private VirtualDisplay f;
  private VirtualDisplay g;
  private i h;
  private final IBinder i = new a(null);
  private final DialogInterface.OnDismissListener j = new DialogInterface.OnDismissListener()
  {
    public void onDismiss(DialogInterface paramAnonymousDialogInterface)
    {
      if (paramAnonymousDialogInterface == AbsCarlifeActivityService.a(AbsCarlifeActivityService.this)) {
        AbsCarlifeActivityService.a(AbsCarlifeActivityService.this, null);
      }
      while (paramAnonymousDialogInterface != AbsCarlifeActivityService.b(AbsCarlifeActivityService.this)) {
        return;
      }
      if (AbsCarlifeActivityService.a(AbsCarlifeActivityService.this) != null)
      {
        AbsCarlifeActivityService.a(AbsCarlifeActivityService.this, AbsCarlifeActivityService.c(AbsCarlifeActivityService.this));
        return;
      }
      AbsCarlifeActivityService.a(AbsCarlifeActivityService.this, null);
    }
  };
  private Handler k = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      com.baidu.carlife.core.i.c("CarlifeActivity#Service", "handleMessage=" + paramAnonymousMessage.what);
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        return;
        if (AbsCarlifeActivityService.this.getSupportFragmentManager().isPendingActionWillExecuteOrExecuting())
        {
          com.baidu.carlife.core.i.c("CarlifeActivity#Service", "MSG_DELAY_VEHICLE_CONNECT what=" + paramAnonymousMessage.what);
          AbsCarlifeActivityService.d(AbsCarlifeActivityService.this).sendEmptyMessageDelayed(20001, 1000L);
          return;
        }
        com.baidu.carlife.core.i.c("CarlifeActivity#Service", " will execute showPresentationImp.");
      } while (AbsCarlifeActivityService.a(AbsCarlifeActivityService.this) == null);
      AbsCarlifeActivityService.e(AbsCarlifeActivityService.this);
    }
  };
  
  public static boolean a()
  {
    return c;
  }
  
  private void c(i parami)
  {
    this.h = parami;
    if (this.f == null)
    {
      this.f = m.a().a(parami, "CarlifeFakePresentation");
      if (this.f != null) {
        break label112;
      }
      com.baidu.carlife.core.i.e("CarlifeActivity#Service", "Can not make FakeVD");
      a("FakeVD创建失败");
    }
    label112:
    do
    {
      return;
      if ((this.e != null) && (this.e.getDisplay() == this.f.getDisplay())) {
        try
        {
          this.e.show();
          return;
        }
        catch (WindowManager.InvalidDisplayException parami)
        {
          this.e = null;
          this.f.release();
          this.f = null;
          a("第一层复用时异常：InvalidDisplayException");
          com.baidu.carlife.core.i.e("CarlifeActivity#Service", parami.getMessage());
          return;
        }
      }
      if ((this.e != null) && (this.e.getDisplay() != this.f.getDisplay()))
      {
        this.e.dismiss();
        this.e = null;
      }
    } while ((this.e != null) || (this.f.getDisplay() == null));
    this.e = a(this, this.f.getDisplay(), this);
    this.e.setOnDismissListener(this.j);
    try
    {
      this.e.show();
      return;
    }
    catch (WindowManager.InvalidDisplayException parami)
    {
      this.e = null;
      this.f.release();
      this.f = null;
      a("第一层异常：InvalidDisplayException");
      com.baidu.carlife.core.i.e("CarlifeActivity#Service", parami.getMessage());
    }
  }
  
  private void d()
  {
    setFragmentWindow(this.d.getWindow());
    bindDialog(this.d);
  }
  
  private void d(i parami)
  {
    if (this.g != null) {
      this.g.release();
    }
    this.g = m.a().a(parami, "CarlifePresentation");
    if (this.d != null)
    {
      if (this.d.getDisplay() != this.g.getDisplay())
      {
        this.d.dismiss();
        this.d = null;
      }
    }
    else
    {
      if ((this.d == null) && (this.g.getDisplay() != null))
      {
        this.d = a(this, this.g.getDisplay());
        this.d.setOnDismissListener(this.j);
        int m = 0;
        if (getSupportFragmentManager().isPendingActionWillExecuteOrExecuting()) {
          m = 1000;
        }
        this.k.sendEmptyMessageDelayed(20001, m);
      }
      return;
    }
    this.d.show();
  }
  
  private void e()
  {
    com.baidu.carlife.core.i.c("CarlifeActivity#Service", "showPresentationImp  attachHost()");
    attachHost();
    d();
    try
    {
      if (this.d != null) {
        this.d.show();
      }
      return;
    }
    catch (WindowManager.InvalidDisplayException localInvalidDisplayException)
    {
      this.d = null;
      a("第二层异常：InvalidDisplayException");
      if (this.g != null) {
        this.g.release();
      }
      com.baidu.carlife.core.i.e("CarlifeActivity#Service", localInvalidDisplayException.getMessage());
    }
  }
  
  public a a(Context paramContext, Display paramDisplay, k paramk)
  {
    return new a(paramContext, paramDisplay, paramk);
  }
  
  public b a(AbsCarlifeActivityService paramAbsCarlifeActivityService, Display paramDisplay)
  {
    new b(paramAbsCarlifeActivityService, paramDisplay)
    {
      public c a(Window paramAnonymousWindow)
      {
        new c(paramAnonymousWindow)
        {
          public void a() {}
        };
      }
    };
  }
  
  public void a(OnFragmentListener paramOnFragmentListener) {}
  
  public void a(i parami)
  {
    com.baidu.carlife.core.i.b("CarlifeActivity#Service", "CarlifeActivityService-onSurfaceCreated Fake surface. spec=" + parami);
    d(parami);
  }
  
  public void a(String paramString) {}
  
  public void b()
  {
    this.k.removeMessages(20001);
    c = true;
    Object localObject;
    if (this.d != null)
    {
      localObject = this.d;
      this.d = null;
      ((Presentation)localObject).dismiss();
    }
    try
    {
      this.g.release();
      this.g = null;
      if (this.e != null)
      {
        localObject = this.e;
        this.e = null;
        ((Presentation)localObject).dismiss();
        this.f.release();
        this.f = null;
      }
      e.b().p();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        com.baidu.carlife.core.i.b("CarlifeActivity#Service", "mVD.release error:" + localException.getMessage());
      }
    }
  }
  
  public boolean b(i parami)
  {
    c = false;
    a(this);
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(this);
    localBuilder.setSmallIcon(com.baidu.carlife.core.screen.presentation.a.b.b().g()).setWhen(System.currentTimeMillis());
    startForeground(1000, localBuilder.build());
    ((NotificationManager)getSystemService("notification")).notify(1000, new Notification());
    c(parami);
    return true;
  }
  
  public Notification c()
  {
    return new Notification();
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    super.onBind(paramIntent);
    return this.i;
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    com.baidu.carlife.core.i.b("CarlifeActivity#Service", "CarlifeActivityService-onDestroy=" + this);
  }
  
  public void onRebind(Intent paramIntent)
  {
    super.onRebind(paramIntent);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    com.baidu.carlife.core.i.b("CarlifeActivity#Service", "CarlifeActivityService-onUnbind");
    return super.onUnbind(paramIntent);
  }
  
  public class a
    extends Binder
  {
    private a() {}
    
    public AbsCarlifeActivityService a()
    {
      return AbsCarlifeActivityService.this;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/presentation/AbsCarlifeActivityService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */