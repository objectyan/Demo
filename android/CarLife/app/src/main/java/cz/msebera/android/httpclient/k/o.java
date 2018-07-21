package cz.msebera.android.httpclient.k;

import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.d;
import java.io.Serializable;

@Immutable
public class o
  implements am, Serializable, Cloneable
{
  private static final long a = 2810581718468737193L;
  private final ak b;
  private final String c;
  private final String d;
  
  public o(String paramString1, String paramString2, ak paramak)
  {
    this.c = ((String)a.a(paramString1, "Method"));
    this.d = ((String)a.a(paramString2, "URI"));
    this.b = ((ak)a.a(paramak, "Version"));
  }
  
  public String a()
  {
    return this.c;
  }
  
  public ak b()
  {
    return this.b;
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/k/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */