package com.facebook.common.i;

public class a
{
  private static volatile b a = new a();
  
  public static void a()
  {
    a(new b()
    {
      public void a(String paramAnonymousString) {}
    });
  }
  
  public static void a(b paramb)
  {
    if (paramb == null) {
      throw new NullPointerException("Handler cannot be null");
    }
    a = paramb;
  }
  
  public static void a(String paramString)
  {
    a.a(paramString);
  }
  
  public static class a
    implements a.b
  {
    public void a(String paramString)
    {
      System.loadLibrary(paramString);
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(String paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/common/i/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */