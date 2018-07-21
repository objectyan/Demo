package cz.msebera.android.httpclient.d;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.o.a;

@Immutable
public class f
  implements Cloneable
{
  public static final f a = new a().a();
  private final int b;
  private final boolean c;
  private final int d;
  private final boolean e;
  private final boolean f;
  
  f(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.b = paramInt1;
    this.c = paramBoolean1;
    this.d = paramInt2;
    this.e = paramBoolean2;
    this.f = paramBoolean3;
  }
  
  public static a a(f paramf)
  {
    a.a(paramf, "Socket config");
    return new a().a(paramf.a()).a(paramf.b()).b(paramf.c()).b(paramf.d()).c(paramf.e());
  }
  
  public static a g()
  {
    return new a();
  }
  
  public int a()
  {
    return this.b;
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.d;
  }
  
  public boolean d()
  {
    return this.e;
  }
  
  public boolean e()
  {
    return this.f;
  }
  
  protected f f()
    throws CloneNotSupportedException
  {
    return (f)super.clone();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[soTimeout=").append(this.b).append(", soReuseAddress=").append(this.c).append(", soLinger=").append(this.d).append(", soKeepAlive=").append(this.e).append(", tcpNoDelay=").append(this.f).append("]");
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    private int a;
    private boolean b;
    private int c = -1;
    private boolean d;
    private boolean e = true;
    
    public a a(int paramInt)
    {
      this.a = paramInt;
      return this;
    }
    
    public a a(boolean paramBoolean)
    {
      this.b = paramBoolean;
      return this;
    }
    
    public f a()
    {
      return new f(this.a, this.b, this.c, this.d, this.e);
    }
    
    public a b(int paramInt)
    {
      this.c = paramInt;
      return this;
    }
    
    public a b(boolean paramBoolean)
    {
      this.d = paramBoolean;
      return this;
    }
    
    public a c(boolean paramBoolean)
    {
      this.e = paramBoolean;
      return this;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/d/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */