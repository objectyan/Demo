package cz.msebera.android.httpclient.l;

import cz.msebera.android.httpclient.ac;
import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.n.f;
import cz.msebera.android.httpclient.o.a;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;

@Deprecated
public final class m
  implements d
{
  public static String a(j paramj)
  {
    a.a(paramj, "HTTP parameters");
    String str = (String)paramj.a("http.protocol.element-charset");
    paramj = str;
    if (str == null) {
      paramj = f.u.name();
    }
    return paramj;
  }
  
  public static void a(j paramj, ak paramak)
  {
    a.a(paramj, "HTTP parameters");
    paramj.a("http.protocol.version", paramak);
  }
  
  public static void a(j paramj, String paramString)
  {
    a.a(paramj, "HTTP parameters");
    paramj.a("http.protocol.element-charset", paramString);
  }
  
  public static void a(j paramj, CodingErrorAction paramCodingErrorAction)
  {
    a.a(paramj, "HTTP parameters");
    paramj.a("http.malformed.input.action", paramCodingErrorAction);
  }
  
  public static void a(j paramj, boolean paramBoolean)
  {
    a.a(paramj, "HTTP parameters");
    paramj.b("http.protocol.expect-continue", paramBoolean);
  }
  
  public static String b(j paramj)
  {
    a.a(paramj, "HTTP parameters");
    String str = (String)paramj.a("http.protocol.content-charset");
    paramj = str;
    if (str == null) {
      paramj = f.t.name();
    }
    return paramj;
  }
  
  public static void b(j paramj, String paramString)
  {
    a.a(paramj, "HTTP parameters");
    paramj.a("http.protocol.content-charset", paramString);
  }
  
  public static void b(j paramj, CodingErrorAction paramCodingErrorAction)
  {
    a.a(paramj, "HTTP parameters");
    paramj.a("http.unmappable.input.action", paramCodingErrorAction);
  }
  
  public static ak c(j paramj)
  {
    a.a(paramj, "HTTP parameters");
    paramj = paramj.a("http.protocol.version");
    if (paramj == null) {
      return ac.d;
    }
    return (ak)paramj;
  }
  
  public static void c(j paramj, String paramString)
  {
    a.a(paramj, "HTTP parameters");
    paramj.a("http.useragent", paramString);
  }
  
  public static String d(j paramj)
  {
    a.a(paramj, "HTTP parameters");
    return (String)paramj.a("http.useragent");
  }
  
  public static boolean e(j paramj)
  {
    a.a(paramj, "HTTP parameters");
    return paramj.a("http.protocol.expect-continue", false);
  }
  
  public static CodingErrorAction f(j paramj)
  {
    a.a(paramj, "HTTP parameters");
    paramj = paramj.a("http.malformed.input.action");
    if (paramj == null) {
      return CodingErrorAction.REPORT;
    }
    return (CodingErrorAction)paramj;
  }
  
  public static CodingErrorAction g(j paramj)
  {
    a.a(paramj, "HTTP parameters");
    paramj = paramj.a("http.unmappable.input.action");
    if (paramj == null) {
      return CodingErrorAction.REPORT;
    }
    return (CodingErrorAction)paramj;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/l/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */