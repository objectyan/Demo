package b.a.d;

import b.ab;
import b.u;
import java.net.Proxy.Type;

public final class i
{
  public static String a(ab paramab, Proxy.Type paramType)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramab.b());
    localStringBuilder.append(' ');
    if (b(paramab, paramType)) {
      localStringBuilder.append(paramab.a());
    }
    for (;;)
    {
      localStringBuilder.append(" HTTP/1.1");
      return localStringBuilder.toString();
      localStringBuilder.append(a(paramab.a()));
    }
  }
  
  public static String a(u paramu)
  {
    String str1 = paramu.l();
    String str2 = paramu.o();
    paramu = str1;
    if (str2 != null) {
      paramu = str1 + '?' + str2;
    }
    return paramu;
  }
  
  private static boolean b(ab paramab, Proxy.Type paramType)
  {
    return (!paramab.h()) && (paramType == Proxy.Type.HTTP);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/d/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */