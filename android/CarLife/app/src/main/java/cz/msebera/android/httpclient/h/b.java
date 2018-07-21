package cz.msebera.android.httpclient.h;

import android.util.Log;

public class b
{
  private String a;
  private boolean b;
  private boolean c;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public b(Object paramObject)
  {
    this.a = paramObject.toString();
    this.b = false;
    this.c = false;
    this.d = false;
    this.e = false;
    this.f = false;
  }
  
  public void a(Object paramObject)
  {
    if (a()) {
      Log.d(this.a, paramObject.toString());
    }
  }
  
  public void a(Object paramObject, Throwable paramThrowable)
  {
    if (a()) {
      Log.d(this.a, paramObject.toString(), paramThrowable);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b(Object paramObject)
  {
    if (b()) {
      Log.e(this.a, paramObject.toString());
    }
  }
  
  public void b(Object paramObject, Throwable paramThrowable)
  {
    if (b()) {
      Log.e(this.a, paramObject.toString(), paramThrowable);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public void c(Object paramObject)
  {
    if (c()) {
      Log.w(this.a, paramObject.toString());
    }
  }
  
  public void c(Object paramObject, Throwable paramThrowable)
  {
    if (c()) {
      Log.w(this.a, paramObject.toString(), paramThrowable);
    }
  }
  
  public void c(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public boolean c()
  {
    return this.e;
  }
  
  public void d(Object paramObject)
  {
    if (d()) {
      Log.i(this.a, paramObject.toString());
    }
  }
  
  public void d(Object paramObject, Throwable paramThrowable)
  {
    if (d()) {
      Log.i(this.a, paramObject.toString(), paramThrowable);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  public boolean d()
  {
    return this.f;
  }
  
  public void e(Object paramObject)
  {
    if (e()) {
      Log.i(this.a, paramObject.toString());
    }
  }
  
  public void e(Object paramObject, Throwable paramThrowable)
  {
    if (e()) {
      Log.i(this.a, paramObject.toString(), paramThrowable);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public boolean e()
  {
    return this.d;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/h/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */