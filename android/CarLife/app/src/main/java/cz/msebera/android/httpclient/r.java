package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.i;
import java.io.Serializable;
import java.net.InetAddress;
import java.util.Locale;

@Immutable
public final class r
  implements Serializable, Cloneable
{
  public static final String a = "http";
  private static final long g = -7529410654042457626L;
  protected final String b;
  protected final String c;
  protected final int d;
  protected final String e;
  protected final InetAddress f;
  
  public r(r paramr)
  {
    a.a(paramr, "HTTP host");
    this.b = paramr.b;
    this.c = paramr.c;
    this.e = paramr.e;
    this.d = paramr.d;
    this.f = paramr.f;
  }
  
  public r(String paramString)
  {
    this(paramString, -1, null);
  }
  
  public r(String paramString, int paramInt)
  {
    this(paramString, paramInt, null);
  }
  
  public r(String paramString1, int paramInt, String paramString2)
  {
    this.b = ((String)a.b(paramString1, "Host name"));
    this.c = paramString1.toLowerCase(Locale.ENGLISH);
    if (paramString2 != null) {}
    for (this.e = paramString2.toLowerCase(Locale.ENGLISH);; this.e = "http")
    {
      this.d = paramInt;
      this.f = null;
      return;
    }
  }
  
  public r(InetAddress paramInetAddress)
  {
    this(paramInetAddress, -1, null);
  }
  
  public r(InetAddress paramInetAddress, int paramInt)
  {
    this(paramInetAddress, paramInt, null);
  }
  
  public r(InetAddress paramInetAddress, int paramInt, String paramString)
  {
    this.f = ((InetAddress)a.a(paramInetAddress, "Inet address"));
    this.b = paramInetAddress.getHostAddress();
    this.c = this.b.toLowerCase(Locale.ENGLISH);
    if (paramString != null) {}
    for (this.e = paramString.toLowerCase(Locale.ENGLISH);; this.e = "http")
    {
      this.d = paramInt;
      return;
    }
  }
  
  public String a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public String c()
  {
    return this.e;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  public InetAddress d()
  {
    return this.f;
  }
  
  public String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.e);
    localStringBuilder.append("://");
    localStringBuilder.append(this.b);
    if (this.d != -1)
    {
      localStringBuilder.append(':');
      localStringBuilder.append(Integer.toString(this.d));
    }
    return localStringBuilder.toString();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof r)) {
        break;
      }
      paramObject = (r)paramObject;
    } while ((this.c.equals(((r)paramObject).c)) && (this.d == ((r)paramObject).d) && (this.e.equals(((r)paramObject).e)));
    return false;
    return false;
  }
  
  public String f()
  {
    if (this.d != -1)
    {
      StringBuilder localStringBuilder = new StringBuilder(this.b.length() + 6);
      localStringBuilder.append(this.b);
      localStringBuilder.append(":");
      localStringBuilder.append(Integer.toString(this.d));
      return localStringBuilder.toString();
    }
    return this.b;
  }
  
  public int hashCode()
  {
    return i.a(i.a(i.a(17, this.c), this.d), this.e);
  }
  
  public String toString()
  {
    return e();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */