package com.baidu.mapframework.common.a;

import android.os.Message;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

class b
  implements l
{
  private final f a;
  private final String b;
  private final DateFormat c;
  private d d;
  private c e;
  private boolean f = false;
  
  public b(f paramf, String paramString)
  {
    this.a = paramf;
    this.b = paramString;
    this.c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.getDefault());
    a();
  }
  
  private void a(f paramf, String paramString, Object... paramVarArgs)
  {
    if ((a(paramf)) && (!this.f)) {
      f(paramString, paramVarArgs);
    }
  }
  
  private boolean a(Date paramDate)
  {
    return System.currentTimeMillis() - paramDate.getTime() <= 0L;
  }
  
  private void f(String paramString, Object... paramVarArgs)
  {
    Message localMessage = this.e.obtainMessage();
    i locali = new i();
    locali.b = this.a;
    locali.c = this.b;
    locali.f = Thread.currentThread().getName();
    locali.d = System.currentTimeMillis();
    locali.a = this.c;
    try
    {
      locali.e = String.format(paramString, paramVarArgs);
      localMessage.obj = locali;
      this.e.sendMessage(localMessage);
      return;
    }
    catch (Exception paramVarArgs)
    {
      for (;;)
      {
        locali.e = paramString;
      }
    }
  }
  
  public void a()
  {
    if (this.d == null)
    {
      this.d = new d("AsyncLogger", 5);
      this.d.start();
    }
    if (this.e == null) {
      this.e = new c(this.d.getLooper());
    }
    this.f = false;
  }
  
  public void a(String paramString)
  {
    a(f.a, paramString, new Object[0]);
  }
  
  public void a(String paramString, Object... paramVarArgs)
  {
    a(f.a, paramString, paramVarArgs);
  }
  
  public boolean a(f paramf)
  {
    return paramf.compareTo(this.a) >= 0;
  }
  
  public void b()
  {
    this.f = true;
    if (this.d != null)
    {
      this.d.quit();
      this.d = null;
    }
    if (this.e != null)
    {
      this.e.a();
      this.e = null;
    }
  }
  
  public void b(String paramString)
  {
    a(f.b, paramString, new Object[0]);
  }
  
  public void b(String paramString, Object... paramVarArgs)
  {
    a(f.b, paramString, paramVarArgs);
  }
  
  public f c()
  {
    return this.a;
  }
  
  public void c(String paramString)
  {
    a(f.c, paramString, new Object[0]);
  }
  
  public void c(String paramString, Object... paramVarArgs)
  {
    a(f.c, paramString, paramVarArgs);
  }
  
  public String d()
  {
    return this.b;
  }
  
  public void d(String paramString)
  {
    a(f.d, paramString, new Object[0]);
  }
  
  public void d(String paramString, Object... paramVarArgs)
  {
    a(f.d, paramString, paramVarArgs);
  }
  
  public void e(String paramString)
  {
    a(f.e, paramString, new Object[0]);
  }
  
  public void e(String paramString, Object... paramVarArgs)
  {
    a(f.e, paramString, paramVarArgs);
  }
  
  public boolean e()
  {
    return a(f.a);
  }
  
  public boolean f()
  {
    return a(f.b);
  }
  
  public boolean g()
  {
    return a(f.c);
  }
  
  public boolean h()
  {
    return a(f.d);
  }
  
  public boolean i()
  {
    return a(f.e);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/common/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */