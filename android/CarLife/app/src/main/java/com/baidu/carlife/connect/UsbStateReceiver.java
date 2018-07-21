package com.baidu.carlife.connect;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TextView;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.b;
import com.baidu.carlife.core.screen.presentation.a.g;
import com.baidu.carlife.l.a;
import com.baidu.carlife.view.dialog.c;
import java.util.Timer;
import java.util.TimerTask;

public class UsbStateReceiver
  extends BroadcastReceiver
{
  private static final String a = "UsbConnectStateReceiver";
  private static final String b = "android.hardware.usb.action.USB_STATE";
  private static UsbStateReceiver c = null;
  private static final int h = 10000;
  private Context d = null;
  private boolean e = false;
  private Timer f = null;
  private TimerTask g = null;
  private c i = null;
  private com.baidu.carlife.core.screen.e j = null;
  
  public static UsbStateReceiver a()
  {
    if (c == null) {}
    try
    {
      if (c == null) {
        c = new UsbStateReceiver();
      }
      return c;
    }
    finally {}
  }
  
  private void e()
  {
    f();
    final Handler localHandler = new Handler();
    try
    {
      i.b("UsbConnectStateReceiver", "startTimer for usb debug switch");
      this.f = new Timer();
      this.g = new TimerTask()
      {
        public void run()
        {
          if (UsbStateReceiver.a(UsbStateReceiver.this) != null)
          {
            UsbStateReceiver.b(UsbStateReceiver.this);
            if ((a.a().S() == 1) && (!com.baidu.carlife.core.e.a().x())) {
              localHandler.post(new Runnable()
              {
                public void run()
                {
                  UsbStateReceiver.c(UsbStateReceiver.this);
                }
              });
            }
          }
          else
          {
            return;
          }
          localHandler.post(new Runnable()
          {
            public void run()
            {
              UsbStateReceiver.this.d();
            }
          });
        }
      };
      this.f.schedule(this.g, 10000L);
      return;
    }
    catch (Exception localException)
    {
      i.b("UsbConnectStateReceiver", "startTimer get exception for usb debug switch");
      localException.printStackTrace();
    }
  }
  
  private void f()
  {
    i.b("UsbConnectStateReceiver", "stopTimer for usb debug switch");
    if (this.f != null)
    {
      this.f.cancel();
      this.f = null;
    }
    if (this.g != null)
    {
      this.g.cancel();
      this.g = null;
    }
  }
  
  private void g()
  {
    if (this.i == null)
    {
      this.i = new c(this.d).b(2131296392).a(2131296390).c(2131296391).a(new b()
      {
        public void onClick()
        {
          UsbStateReceiver.d(UsbStateReceiver.this);
          if (UsbStateReceiver.e(UsbStateReceiver.this) != null) {
            UsbStateReceiver.e(UsbStateReceiver.this).dismissDialog(UsbStateReceiver.f(UsbStateReceiver.this));
          }
        }
      });
      this.i.getContentView().setCompoundDrawablesWithIntrinsicBounds(0, 2130838336, 0, 0);
      ImageButton localImageButton = this.i.getTitlebntRight();
      localImageButton.setVisibility(0);
      localImageButton.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          UsbStateReceiver.this.d();
        }
      });
    }
    if (this.j != null) {
      this.j.showDialog(this.i);
    }
  }
  
  private void h()
  {
    try
    {
      this.d.startActivity(new Intent("android.settings.APPLICATION_DEVELOPMENT_SETTINGS"));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a(Context paramContext)
  {
    this.d = paramContext;
    b();
  }
  
  public void b()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.hardware.usb.action.USB_STATE");
    this.d.registerReceiver(this, localIntentFilter);
  }
  
  public void c()
  {
    this.d.unregisterReceiver(this);
  }
  
  public void d()
  {
    if (this.j != null) {
      this.j.dismissDialog(this.i);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.j = g.a().b();
    paramContext = paramIntent.getAction();
    Message localMessage = new Message();
    localMessage.what = 1031;
    if (paramContext.equals("android.hardware.usb.action.USB_STATE"))
    {
      if (paramIntent.getExtras().getBoolean("connected"))
      {
        i.b("UsbConnectStateReceiver", "usb connect is changed: connected");
        localMessage.arg1 = 1032;
        if (!this.e) {
          e();
        }
        this.e = true;
      }
    }
    else {
      return;
    }
    i.b("UsbConnectStateReceiver", "usb connect is changed: disconnected");
    localMessage.arg1 = 1033;
    this.e = false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/connect/UsbStateReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */