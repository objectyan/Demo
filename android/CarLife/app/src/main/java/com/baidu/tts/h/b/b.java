package com.baidu.tts.h.b;

import android.content.Context;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.f.g;
import java.lang.ref.WeakReference;
import java.util.Hashtable;

public class b
  implements com.baidu.tts.j.b
{
  private static volatile b a = null;
  private Hashtable<WeakReference<Context>, a> b = new Hashtable();
  private WeakReference<Context> c;
  private Hashtable<String, Object> d = new Hashtable();
  
  private b()
  {
    this.d.put(g.Y.a(), "10");
    this.d.put(g.aa.a(), "V2.3.0");
  }
  
  public static b a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new b();
      }
      return a;
    }
    finally {}
  }
  
  public a a(WeakReference<Context> paramWeakReference)
  {
    if (paramWeakReference == null) {
      localObject = null;
    }
    a locala;
    do
    {
      return (a)localObject;
      locala = (a)this.b.get(paramWeakReference);
      localObject = locala;
    } while (locala != null);
    Object localObject = new a(paramWeakReference);
    this.b.put(paramWeakReference, localObject);
    return (a)localObject;
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = (String)this.d.get(paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public void a(Context paramContext)
  {
    this.c = new WeakReference(paramContext);
  }
  
  public TtsError b()
  {
    return null;
  }
  
  public void c() {}
  
  public void d() {}
  
  public void e() {}
  
  public void f()
  {
    if (this.b != null) {
      this.b.clear();
    }
    this.c = null;
  }
  
  public a g()
  {
    return a(this.c);
  }
  
  public Context h()
  {
    return (Context)this.c.get();
  }
  
  public String i()
  {
    try
    {
      Object localObject = g();
      if (localObject == null) {
        return null;
      }
      localObject = ((a)localObject).a();
      return (String)localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public String j()
  {
    return a(g.aa.a());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/h/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */