package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.o.a;
import java.io.Serializable;

@Immutable
public class ak
  implements Serializable, Cloneable
{
  private static final long a = 8950662842175091068L;
  protected final String e;
  protected final int f;
  protected final int g;
  
  public ak(String paramString, int paramInt1, int paramInt2)
  {
    this.e = ((String)a.a(paramString, "Protocol name"));
    this.f = a.b(paramInt1, "Protocol minor version");
    this.g = a.b(paramInt2, "Protocol minor version");
  }
  
  public ak a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == this.f) && (paramInt2 == this.g)) {
      return this;
    }
    return new ak(this.e, paramInt1, paramInt2);
  }
  
  public final String a()
  {
    return this.e;
  }
  
  public boolean a(ak paramak)
  {
    return (paramak != null) && (this.e.equals(paramak.e));
  }
  
  public final int b()
  {
    return this.f;
  }
  
  public int b(ak paramak)
  {
    a.a(paramak, "Protocol version");
    a.a(this.e.equals(paramak.e), "Versions for different protocols cannot be compared: %s %s", new Object[] { this, paramak });
    int j = b() - paramak.b();
    int i = j;
    if (j == 0) {
      i = c() - paramak.c();
    }
    return i;
  }
  
  public final int c()
  {
    return this.g;
  }
  
  public final boolean c(ak paramak)
  {
    return (a(paramak)) && (b(paramak) >= 0);
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    return super.clone();
  }
  
  public final boolean d(ak paramak)
  {
    return (a(paramak)) && (b(paramak) <= 0);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof ak)) {
        return false;
      }
      paramObject = (ak)paramObject;
    } while ((this.e.equals(((ak)paramObject).e)) && (this.f == ((ak)paramObject).f) && (this.g == ((ak)paramObject).g));
    return false;
  }
  
  public final int hashCode()
  {
    return this.e.hashCode() ^ this.f * 100000 ^ this.g;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.e);
    localStringBuilder.append('/');
    localStringBuilder.append(Integer.toString(this.f));
    localStringBuilder.append('.');
    localStringBuilder.append(Integer.toString(this.g));
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/ak.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */