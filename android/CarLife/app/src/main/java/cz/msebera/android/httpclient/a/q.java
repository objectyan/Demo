package cz.msebera.android.httpclient.a;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.i;
import java.io.Serializable;
import java.security.Principal;
import java.util.Locale;

@Immutable
public class q
  implements n, Serializable
{
  private static final long a = -7385699315228907265L;
  private final r b;
  private final String c;
  private final String d;
  
  public q(String paramString)
  {
    a.a(paramString, "Username:password string");
    int i = paramString.indexOf(':');
    if (i >= 0)
    {
      String str = paramString.substring(0, i);
      this.c = paramString.substring(i + 1);
      paramString = str;
      i = paramString.indexOf('/');
      if (i < 0) {
        break label97;
      }
    }
    label97:
    for (this.b = new r(paramString.substring(0, i).toUpperCase(Locale.ENGLISH), paramString.substring(i + 1));; this.b = new r(null, paramString.substring(i + 1)))
    {
      this.d = null;
      return;
      this.c = null;
      break;
    }
  }
  
  public q(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    a.a(paramString1, "User name");
    this.b = new r(paramString4, paramString1);
    this.c = paramString2;
    if (paramString3 != null)
    {
      this.d = paramString3.toUpperCase(Locale.ENGLISH);
      return;
    }
    this.d = null;
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
    return this.b.b();
  }
  
  public String d()
  {
    return this.b.a();
  }
  
  public String e()
  {
    return this.d;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof q)) {
        break;
      }
      paramObject = (q)paramObject;
    } while ((i.a(this.b, ((q)paramObject).b)) && (i.a(this.d, ((q)paramObject).d)));
    return false;
  }
  
  public int hashCode()
  {
    return i.a(i.a(17, this.b), this.d);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[principal: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("][workstation: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/a/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */