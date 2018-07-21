package cz.msebera.android.httpclient.d;

import cz.msebera.android.httpclient.o.a;

public class c
  implements Cloneable
{
  public static final c a = new a().a();
  private final int b;
  private final int c;
  
  c(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  public static a a(c paramc)
  {
    a.a(paramc, "Message constraints");
    return new a().b(paramc.b()).a(paramc.a());
  }
  
  public static c a(int paramInt)
  {
    return new c(a.b(paramInt, "Max line length"), -1);
  }
  
  public static a d()
  {
    return new a();
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.c;
  }
  
  protected c c()
    throws CloneNotSupportedException
  {
    return (c)super.clone();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[maxLineLength=").append(this.b).append(", maxHeaderCount=").append(this.c).append("]");
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    private int a = -1;
    private int b = -1;
    
    public a a(int paramInt)
    {
      this.a = paramInt;
      return this;
    }
    
    public c a()
    {
      return new c(this.a, this.b);
    }
    
    public a b(int paramInt)
    {
      this.b = paramInt;
      return this;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/d/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */