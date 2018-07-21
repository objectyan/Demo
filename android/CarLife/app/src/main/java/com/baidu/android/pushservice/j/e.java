package com.baidu.android.pushservice.j;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.a;
import com.baidu.android.pushservice.message.g;

public class e
{
  private static int c = 1000;
  private static final Object f = new Object();
  private long a = System.currentTimeMillis();
  private c b;
  private Context d;
  private Intent e;
  private Intent g;
  
  public e(Context paramContext, Intent paramIntent)
  {
    this.d = paramContext;
    this.e = paramIntent;
  }
  
  long a()
  {
    return this.a;
  }
  
  public void a(Intent arg1)
  {
    if (this.b != null) {
      this.b.a(0, ???);
    }
    this.g = ???;
    synchronized (f)
    {
      f.notifyAll();
      return;
    }
  }
  
  public g b()
  {
    this.e.putExtra("bd.cross.request.SOURCE_PACKAGE", this.d.getPackageName());
    this.e.putExtra("bd.cross.request.ID", this.a);
    this.e.putExtra("bd.cross.request.NEED_CALLBACK", true);
    this.e.putExtra("bd.cross.request.SENDING", true);
    d.a(this);
    try
    {
      this.d.startService(this.e);
      g localg1 = new g();
      ??? = new com.baidu.android.pushservice.i.c("timeOutRunnable-" + this.a, (short)50)
      {
        public void a()
        {
          try
          {
            Thread.sleep(e.d());
            synchronized (e.e())
            {
              e.e().notifyAll();
              return;
            }
            return;
          }
          catch (InterruptedException localInterruptedException) {}
        }
      };
      com.baidu.android.pushservice.i.d.a().a((com.baidu.android.pushservice.i.c)???);
      if (this.b == null) {}
      try
      {
        synchronized (f)
        {
          f.wait();
          c();
          if (this.g != null)
          {
            if ((a.b() > 0) && (this.g.getBooleanExtra("bd.message.rate.MH", false)))
            {
              this.g.putExtra("bd.message.rate.END", System.currentTimeMillis());
              j.a(this.d, this.e, this.g);
            }
            localg1.a(this.g.getIntExtra("bd.cross.request.RESULT_CODE", 10));
            if (this.g.hasExtra("bd.cross.request.RESULT_DATA"))
            {
              ??? = this.g.getStringExtra("bd.cross.request.RESULT_DATA");
              if (!TextUtils.isEmpty((CharSequence)???)) {
                localg1.a(((String)???).getBytes());
              }
            }
            return localg1;
          }
        }
        if ((a.b() > 0) && (this.e.getBooleanExtra("bd.message.rate.MH", false)))
        {
          this.e.putExtra("bd.message.rate.TIMEOUT", System.currentTimeMillis());
          j.a(this.d, this.e, null);
        }
        localg2.a(11);
        return localg2;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
    }
    catch (Exception localException1)
    {
      for (;;) {}
    }
  }
  
  void c()
  {
    try
    {
      this.b = null;
      this.d = null;
      d.a(this.a);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/j/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */