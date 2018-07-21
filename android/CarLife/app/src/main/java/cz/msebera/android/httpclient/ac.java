package cz.msebera.android.httpclient;

import cz.msebera.android.httpclient.annotation.Immutable;
import java.io.Serializable;

@Immutable
public final class ac
  extends ak
  implements Serializable
{
  public static final String a = "HTTP";
  public static final ac b = new ac(0, 9);
  public static final ac c = new ac(1, 0);
  public static final ac d = new ac(1, 1);
  private static final long h = -5856653513894415344L;
  
  public ac(int paramInt1, int paramInt2)
  {
    super("HTTP", paramInt1, paramInt2);
  }
  
  public ak a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == this.f) && (paramInt2 == this.g)) {
      return this;
    }
    if (paramInt1 == 1)
    {
      if (paramInt2 == 0) {
        return c;
      }
      if (paramInt2 == 1) {
        return d;
      }
    }
    if ((paramInt1 == 0) && (paramInt2 == 9)) {
      return b;
    }
    return new ac(paramInt1, paramInt2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/ac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */