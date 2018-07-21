package cz.msebera.android.httpclient.f;

import cz.msebera.android.httpclient.annotation.Immutable;
import java.io.Serializable;
import java.util.Comparator;

@Immutable
public class f
  implements Serializable, Comparator<b>
{
  private static final long a = 7523645369616405818L;
  
  private String a(b paramb)
  {
    Object localObject = paramb.h();
    paramb = (b)localObject;
    if (localObject == null) {
      paramb = "/";
    }
    localObject = paramb;
    if (!paramb.endsWith("/")) {
      localObject = paramb + '/';
    }
    return (String)localObject;
  }
  
  public int a(b paramb1, b paramb2)
  {
    paramb1 = a(paramb1);
    paramb2 = a(paramb2);
    if (paramb1.equals(paramb2)) {}
    do
    {
      return 0;
      if (paramb1.startsWith(paramb2)) {
        return -1;
      }
    } while (!paramb2.startsWith(paramb1));
    return 1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/f/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */