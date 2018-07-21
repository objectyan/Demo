package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.a.h;
import cz.msebera.android.httpclient.a.n;
import cz.msebera.android.httpclient.a.q;
import cz.msebera.android.httpclient.a.s;
import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.o.a;
import java.net.Authenticator;
import java.net.Authenticator.RequestorType;
import java.net.PasswordAuthentication;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ThreadSafe
public class aw
  implements cz.msebera.android.httpclient.b.i
{
  private static final Map<String, String> a = new ConcurrentHashMap();
  private final i b = new i();
  
  static
  {
    a.put("Basic".toUpperCase(Locale.ENGLISH), "Basic");
    a.put("Digest".toUpperCase(Locale.ENGLISH), "Digest");
    a.put("NTLM".toUpperCase(Locale.ENGLISH), "NTLM");
    a.put("negotiate".toUpperCase(Locale.ENGLISH), "SPNEGO");
    a.put("Kerberos".toUpperCase(Locale.ENGLISH), "Kerberos");
  }
  
  private static String a(String paramString)
  {
    Object localObject;
    if (paramString == null) {
      localObject = null;
    }
    String str;
    do
    {
      return (String)localObject;
      str = (String)a.get(paramString);
      localObject = str;
    } while (str != null);
    return paramString;
  }
  
  private static PasswordAuthentication a(h paramh, Authenticator.RequestorType paramRequestorType)
  {
    String str2 = paramh.a();
    int i = paramh.b();
    if (i == 443) {}
    for (String str1 = "https";; str1 = "http") {
      return Authenticator.requestPasswordAuthentication(str2, null, i, str1, null, a(paramh.d()), null, paramRequestorType);
    }
  }
  
  public n a(h paramh)
  {
    a.a(paramh, "Auth scope");
    Object localObject1 = this.b.a(paramh);
    if (localObject1 != null) {
      return (n)localObject1;
    }
    if (paramh.a() != null)
    {
      Object localObject2 = a(paramh, Authenticator.RequestorType.SERVER);
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = a(paramh, Authenticator.RequestorType.PROXY);
      }
      if (localObject1 != null)
      {
        localObject2 = System.getProperty("http.auth.ntlm.domain");
        if (localObject2 != null) {
          return new q(((PasswordAuthentication)localObject1).getUserName(), new String(((PasswordAuthentication)localObject1).getPassword()), null, (String)localObject2);
        }
        if ("NTLM".equalsIgnoreCase(paramh.d())) {
          return new q(((PasswordAuthentication)localObject1).getUserName(), new String(((PasswordAuthentication)localObject1).getPassword()), null, null);
        }
        return new s(((PasswordAuthentication)localObject1).getUserName(), new String(((PasswordAuthentication)localObject1).getPassword()));
      }
    }
    return null;
  }
  
  public void a()
  {
    this.b.a();
  }
  
  public void a(h paramh, n paramn)
  {
    this.b.a(paramh, paramn);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/aw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */