package com.baidu.carlife.core.connect;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.baidu.carlife.core.i;
import java.util.LinkedList;
import java.util.List;

public class ConnectService
  extends Service
{
  public static final int a = -1;
  private static final String b = "ConnectService";
  private static final int c = 100;
  private HandlerThread d = new HandlerThread("MsgHandlerThread");
  private a e;
  private Messenger f;
  private f g = null;
  private Handler h = null;
  private List<Message> i = new LinkedList();
  private e j = null;
  
  private void a()
  {
    try
    {
      if ((this.g == null) || (this.h == null))
      {
        this.g = new f(this);
        this.h = this.g.a();
      }
      if (this.i.size() > 0)
      {
        Message localMessage = (Message)this.i.remove(0);
        this.e.sendMessage(localMessage);
      }
      this.j = e.a();
      this.j.c();
      this.j.h();
      return;
    }
    catch (Throwable localThrowable)
    {
      this.g = null;
      this.h = null;
      localThrowable.printStackTrace();
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    i.b("ConnectService", "ConnectService onBind()");
    return this.f.getBinder();
  }
  
  public void onCreate()
  {
    i.b("ConnectService", "ConnectService onCreate()");
    super.onCreate();
    this.d.start();
    this.e = new a(this.d.getLooper());
    this.f = new Messenger(this.e);
    a();
  }
  
  public void onDestroy()
  {
    i.b("ConnectService", "ConnectService onDestroy()");
    if (this.j != null)
    {
      this.j.d();
      this.j = null;
    }
    super.onDestroy();
  }
  
  public void onRebind(Intent paramIntent)
  {
    i.b("ConnectService", "ConnectService onRebind()");
    super.onRebind(paramIntent);
  }
  
  public void onStart(Intent paramIntent, int paramInt)
  {
    i.b("ConnectService", "ConnectService onStart(), startId = " + paramInt);
  }
  
  public int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    i.b("ConnectService", "ConnectService onStartCommand()");
    return super.onStartCommand(paramIntent, paramInt1, paramInt2);
  }
  
  public boolean onUnbind(Intent paramIntent)
  {
    i.b("ConnectService", "ConnectService onUnbind()");
    return super.onUnbind(paramIntent);
  }
  
  private class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (ConnectService.a(ConnectService.this) != null)
      {
        ConnectService.a(ConnectService.this).handleMessage(paramMessage);
        if (ConnectService.b(ConnectService.this).size() > 0)
        {
          paramMessage = (Message)ConnectService.b(ConnectService.this).remove(0);
          ConnectService.c(ConnectService.this).sendMessage(paramMessage);
        }
        return;
      }
      Message localMessage1;
      Message localMessage2;
      if (ConnectService.b(ConnectService.this).size() >= 100)
      {
        localMessage1 = (Message)ConnectService.b(ConnectService.this).remove(0);
        localMessage2 = Message.obtain(null, -1, localMessage1);
      }
      try
      {
        i.e("ConnectService", "Send MSG_SEND_DISCARD, oldMsg what = " + Integer.toString(localMessage1.what));
        localMessage1.replyTo.send(localMessage2);
        paramMessage = Message.obtain(paramMessage);
        ConnectService.b(ConnectService.this).add(paramMessage);
        ConnectService.d(ConnectService.this);
        return;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          i.e("ConnectService", "Send MSG_SEND_DISCARD Error");
          localThrowable.printStackTrace();
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/connect/ConnectService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */