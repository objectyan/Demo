package cz.msebera.android.httpclient.k;

import cz.msebera.android.httpclient.ag;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.i;
import java.io.Serializable;

@Immutable
public class n
  implements ag, Serializable, Cloneable
{
  private static final long a = -6437800749411518984L;
  private final String b;
  private final String c;
  
  public n(String paramString1, String paramString2)
  {
    this.b = ((String)a.a(paramString1, "Name"));
    this.c = paramString2;
  }
  
  public String a()
  {
    return this.b;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof ag)) {
        break;
      }
      paramObject = (n)paramObject;
    } while ((this.b.equals(((n)paramObject).b)) && (i.a(this.c, ((n)paramObject).c)));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    return i.a(i.a(17, this.b), this.c);
  }
  
  public String toString()
  {
    if (this.c == null) {
      return this.b;
    }
    StringBuilder localStringBuilder = new StringBuilder(this.b.length() + 1 + this.c.length());
    localStringBuilder.append(this.b);
    localStringBuilder.append("=");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/k/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */