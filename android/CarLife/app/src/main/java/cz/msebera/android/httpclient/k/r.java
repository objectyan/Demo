package cz.msebera.android.httpclient.k;

import cz.msebera.android.httpclient.ai;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.e;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.d;
import java.io.Serializable;

@NotThreadSafe
public class r
  implements e, Serializable, Cloneable
{
  private static final long a = -2768352615787625448L;
  private final String b;
  private final d c;
  private final int d;
  
  public r(d paramd)
    throws ai
  {
    a.a(paramd, "Char array buffer");
    int i = paramd.d(58);
    if (i == -1) {
      throw new ai("Invalid header: " + paramd.toString());
    }
    String str = paramd.b(0, i);
    if (str.length() == 0) {
      throw new ai("Invalid header: " + paramd.toString());
    }
    this.c = paramd;
    this.b = str;
    this.d = (i + 1);
  }
  
  public d a()
  {
    return this.c;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  public String d()
  {
    return this.c.b(this.d, this.c.e());
  }
  
  public cz.msebera.android.httpclient.g[] e()
    throws ai
  {
    x localx = new x(0, this.c.e());
    localx.a(this.d);
    return g.b.a(this.c, localx);
  }
  
  public String toString()
  {
    return this.c.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/k/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */