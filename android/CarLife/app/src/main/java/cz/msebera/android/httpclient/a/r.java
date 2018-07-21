package cz.msebera.android.httpclient.a;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.i;
import java.io.Serializable;
import java.security.Principal;
import java.util.Locale;

@Immutable
public class r
  implements Serializable, Principal
{
  private static final long a = -6870169797924406894L;
  private final String b;
  private final String c;
  private final String d;
  
  public r(String paramString1, String paramString2)
  {
    a.a(paramString2, "User name");
    this.b = paramString2;
    if (paramString1 != null) {}
    for (this.c = paramString1.toUpperCase(Locale.ENGLISH); (this.c != null) && (this.c.length() > 0); this.c = null)
    {
      paramString1 = new StringBuilder();
      paramString1.append(this.c);
      paramString1.append('\\');
      paramString1.append(this.b);
      this.d = paramString1.toString();
      return;
    }
    this.d = this.b;
  }
  
  public String a()
  {
    return this.c;
  }
  
  public String b()
  {
    return this.b;
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
    } while ((i.a(this.b, ((r)paramObject).b)) && (i.a(this.c, ((r)paramObject).c)));
    return false;
  }
  
  public String getName()
  {
    return this.d;
  }
  
  public int hashCode()
  {
    return i.a(i.a(17, this.b), this.c);
  }
  
  public String toString()
  {
    return this.d;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/a/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */