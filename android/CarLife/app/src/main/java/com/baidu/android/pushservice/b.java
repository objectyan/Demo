package com.baidu.android.pushservice;

import android.content.Context;
import com.baidu.android.pushservice.h.q;
import com.baidu.android.pushservice.j.p;

class b
  implements Thread.UncaughtExceptionHandler
{
  private String a = "DefaultExceptionHandler";
  private Context b = null;
  
  public b(Context paramContext)
  {
    this.b = paramContext;
  }
  
  private void a(Throwable paramThrowable)
  {
    paramThrowable = q.b(this.b, paramThrowable);
    p.b("exception " + paramThrowable + " at Time " + System.currentTimeMillis(), this.b.getApplicationContext());
    q.b(this.b, paramThrowable);
  }
  
  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    a(paramThrowable);
    p.f(this.b, this.b.getPackageName());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */