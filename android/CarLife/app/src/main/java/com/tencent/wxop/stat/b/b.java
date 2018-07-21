package com.tencent.wxop.stat.b;

import android.util.Log;
import com.tencent.wxop.stat.au;
import com.tencent.wxop.stat.f;

public final class b
{
  private String a = "default";
  private boolean b = true;
  private int c = 2;
  
  public b() {}
  
  public b(String paramString)
  {
    this.a = paramString;
  }
  
  private String c()
  {
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    if (arrayOfStackTraceElement == null) {}
    for (;;)
    {
      return null;
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        StackTraceElement localStackTraceElement = arrayOfStackTraceElement[i];
        if ((!localStackTraceElement.isNativeMethod()) && (!localStackTraceElement.getClassName().equals(Thread.class.getName())) && (!localStackTraceElement.getClassName().equals(getClass().getName()))) {
          return "[" + Thread.currentThread().getName() + "(" + Thread.currentThread().getId() + "): " + localStackTraceElement.getFileName() + ":" + localStackTraceElement.getLineNumber() + "]";
        }
        i += 1;
      }
    }
  }
  
  public final void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final void a(Object paramObject)
  {
    Object localObject;
    if (this.c <= 4)
    {
      localObject = c();
      if (localObject != null) {
        break label47;
      }
    }
    label47:
    for (paramObject = paramObject.toString();; paramObject = (String)localObject + " - " + paramObject)
    {
      Log.i(this.a, (String)paramObject);
      localObject = f.A();
      if (localObject != null) {
        ((au)localObject).a(paramObject);
      }
      return;
    }
  }
  
  public final void a(String paramString)
  {
    this.a = paramString;
  }
  
  public final void a(Throwable paramThrowable)
  {
    if (this.c <= 6)
    {
      Log.e(this.a, "", paramThrowable);
      au localau = f.A();
      if (localau != null) {
        localau.d(paramThrowable);
      }
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.b;
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public final void b(Object paramObject)
  {
    if (a()) {
      a(paramObject);
    }
  }
  
  public final void b(Throwable paramThrowable)
  {
    if (a()) {
      a(paramThrowable);
    }
  }
  
  public final void c(Object paramObject)
  {
    Object localObject;
    if (this.c <= 2)
    {
      localObject = c();
      if (localObject != null) {
        break label47;
      }
    }
    label47:
    for (paramObject = paramObject.toString();; paramObject = (String)localObject + " - " + paramObject)
    {
      Log.v(this.a, (String)paramObject);
      localObject = f.A();
      if (localObject != null) {
        ((au)localObject).b(paramObject);
      }
      return;
    }
  }
  
  public final void d(Object paramObject)
  {
    if (a()) {
      c(paramObject);
    }
  }
  
  public final void e(Object paramObject)
  {
    Object localObject;
    if (this.c <= 5)
    {
      localObject = c();
      if (localObject != null) {
        break label47;
      }
    }
    label47:
    for (paramObject = paramObject.toString();; paramObject = (String)localObject + " - " + paramObject)
    {
      Log.w(this.a, (String)paramObject);
      localObject = f.A();
      if (localObject != null) {
        ((au)localObject).c(paramObject);
      }
      return;
    }
  }
  
  public final void f(Object paramObject)
  {
    if (a()) {
      e(paramObject);
    }
  }
  
  public final void g(Object paramObject)
  {
    Object localObject;
    if (this.c <= 6)
    {
      localObject = c();
      if (localObject != null) {
        break label48;
      }
    }
    label48:
    for (paramObject = paramObject.toString();; paramObject = (String)localObject + " - " + paramObject)
    {
      Log.e(this.a, (String)paramObject);
      localObject = f.A();
      if (localObject != null) {
        ((au)localObject).d(paramObject);
      }
      return;
    }
  }
  
  public final void h(Object paramObject)
  {
    if (a()) {
      g(paramObject);
    }
  }
  
  public final void i(Object paramObject)
  {
    Object localObject;
    if (this.c <= 3)
    {
      localObject = c();
      if (localObject != null) {
        break label47;
      }
    }
    label47:
    for (paramObject = paramObject.toString();; paramObject = (String)localObject + " - " + paramObject)
    {
      Log.d(this.a, (String)paramObject);
      localObject = f.A();
      if (localObject != null) {
        ((au)localObject).e(paramObject);
      }
      return;
    }
  }
  
  public final void j(Object paramObject)
  {
    if (a()) {
      i(paramObject);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/wxop/stat/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */