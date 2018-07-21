package cz.msebera.android.httpclient.k;

import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.d;
import java.io.Serializable;

@Immutable
public class p
  implements an, Serializable, Cloneable
{
  private static final long a = -2443303766890459269L;
  private final ak b;
  private final int c;
  private final String d;
  
  public p(ak paramak, int paramInt, String paramString)
  {
    this.b = ((ak)a.a(paramak, "Version"));
    this.c = a.b(paramInt, "Status code");
    this.d = paramString;
  }
  
  public ak a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  public String toString()
  {
    return k.b.a(null, this).toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/k/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */