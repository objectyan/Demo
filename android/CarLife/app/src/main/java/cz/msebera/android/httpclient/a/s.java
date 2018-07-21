package cz.msebera.android.httpclient.a;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.i;
import java.io.Serializable;
import java.security.Principal;

@Immutable
public class s
  implements n, Serializable
{
  private static final long a = 243343858802739403L;
  private final k b;
  private final String c;
  
  public s(String paramString)
  {
    a.a(paramString, "Username:password string");
    int i = paramString.indexOf(':');
    if (i >= 0)
    {
      this.b = new k(paramString.substring(0, i));
      this.c = paramString.substring(i + 1);
      return;
    }
    this.b = new k(paramString);
    this.c = null;
  }
  
  public s(String paramString1, String paramString2)
  {
    a.a(paramString1, "Username");
    this.b = new k(paramString1);
    this.c = paramString2;
  }
  
  public Principal a()
  {
    return this.b;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public String c()
  {
    return this.b.getName();
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof s)) {
        break;
      }
      paramObject = (s)paramObject;
    } while (i.a(this.b, ((s)paramObject).b));
    return false;
  }
  
  public int hashCode()
  {
    return this.b.hashCode();
  }
  
  public String toString()
  {
    return this.b.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/a/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */