package cz.msebera.android.httpclient.a;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.i;
import java.io.Serializable;
import java.security.Principal;

@Immutable
public final class k
  implements Serializable, Principal
{
  private static final long a = -2266305184969850467L;
  private final String b;
  
  public k(String paramString)
  {
    a.a(paramString, "User name");
    this.b = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof k)) {
        break;
      }
      paramObject = (k)paramObject;
    } while (i.a(this.b, ((k)paramObject).b));
    return false;
  }
  
  public String getName()
  {
    return this.b;
  }
  
  public int hashCode()
  {
    return i.a(17, this.b);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[principal: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */