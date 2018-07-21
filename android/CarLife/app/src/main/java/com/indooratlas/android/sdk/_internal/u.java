package com.indooratlas.android.sdk._internal;

public abstract class u
  implements ab
{
  protected w a;
  public String b;
  public String c;
  private String d;
  
  public u(String paramString, w paramw)
  {
    this.d = eg.a(paramString, "endpoint must be non empty", new Object[0]);
    this.a = ((w)eg.a(paramw, "errorHandler must be non null", new Object[0]));
  }
  
  public final ah a(ah.a parama)
  {
    String str = this.d;
    ah localah = new ah();
    localah.a = str;
    localah.b = parama;
    return localah;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    this.b = eg.a(paramString1, "apiKey must be non empty", new Object[0]);
    this.c = eg.a(paramString2, "apiSecret must be non empty", new Object[0]);
  }
  
  public final boolean a()
  {
    return (!ei.a(this.b)) && (!ei.a(this.c));
  }
  
  public final void b()
    throws IllegalStateException
  {
    if (!a()) {
      throw new IllegalStateException("client is not authenticated");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */