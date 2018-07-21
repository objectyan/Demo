package com.baidu.carlife.c.d;

import android.support.annotation.MainThread;
import android.support.annotation.NonNull;

public class g
{
  private static final String a = "android.arch.lifecycle.ViewModelProvider.DefaultKey";
  private final a b;
  private final i c;
  
  public g(@NonNull i parami, @NonNull a parama)
  {
    this.b = parama;
    this.c = parami;
  }
  
  public static g a()
  {
    return b.a();
  }
  
  @NonNull
  public <T extends f> T a(@NonNull Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str == null) {
      throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
    return a("android.arch.lifecycle.ViewModelProvider.DefaultKey:" + str, paramClass);
  }
  
  @MainThread
  @NonNull
  public <T extends f> T a(@NonNull String paramString, @NonNull Class<T> paramClass)
  {
    f localf = this.c.a(paramString);
    if (paramClass.isInstance(localf)) {
      return localf;
    }
    if (localf != null) {}
    paramClass = this.b.a(paramClass);
    this.c.a(paramString, paramClass);
    return paramClass;
  }
  
  public static abstract interface a
  {
    @NonNull
    public abstract <T extends f> T a(@NonNull Class<T> paramClass);
  }
  
  private static final class b
  {
    private static final g a = new g(new i(), new g.c());
  }
  
  public static class c
    implements g.a
  {
    @NonNull
    public <T extends f> T a(@NonNull Class<T> paramClass)
    {
      try
      {
        f localf = (f)paramClass.newInstance();
        return localf;
      }
      catch (InstantiationException localInstantiationException)
      {
        throw new RuntimeException("Cannot create an instance of " + paramClass, localInstantiationException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException("Cannot create an instance of " + paramClass, localIllegalAccessException);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/c/d/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */