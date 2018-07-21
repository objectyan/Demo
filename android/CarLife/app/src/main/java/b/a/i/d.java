package b.a.i;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

public final class d
  implements HostnameVerifier
{
  public static final d a = new d();
  private static final int b = 2;
  private static final int c = 7;
  
  public static List<String> a(X509Certificate paramX509Certificate)
  {
    List localList = a(paramX509Certificate, 7);
    paramX509Certificate = a(paramX509Certificate, 2);
    ArrayList localArrayList = new ArrayList(localList.size() + paramX509Certificate.size());
    localArrayList.addAll(localList);
    localArrayList.addAll(paramX509Certificate);
    return localArrayList;
  }
  
  private static List<String> a(X509Certificate paramX509Certificate, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramX509Certificate = paramX509Certificate.getSubjectAlternativeNames();
      if (paramX509Certificate == null) {
        return Collections.emptyList();
      }
      Iterator localIterator = paramX509Certificate.iterator();
      for (;;)
      {
        paramX509Certificate = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        paramX509Certificate = (List)localIterator.next();
        if ((paramX509Certificate != null) && (paramX509Certificate.size() >= 2))
        {
          Integer localInteger = (Integer)paramX509Certificate.get(0);
          if ((localInteger != null) && (localInteger.intValue() == paramInt))
          {
            paramX509Certificate = (String)paramX509Certificate.get(1);
            if (paramX509Certificate != null) {
              localArrayList.add(paramX509Certificate);
            }
          }
        }
      }
      return paramX509Certificate;
    }
    catch (CertificateParsingException paramX509Certificate)
    {
      paramX509Certificate = Collections.emptyList();
    }
  }
  
  private boolean a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString1.length() == 0) || (paramString1.startsWith(".")) || (paramString1.endsWith(".."))) {}
    String str;
    int i;
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
          } while ((paramString2 == null) || (paramString2.length() == 0) || (paramString2.startsWith(".")) || (paramString2.endsWith("..")));
          str = paramString1;
          if (!paramString1.endsWith(".")) {
            str = paramString1 + '.';
          }
          paramString1 = paramString2;
          if (!paramString2.endsWith(".")) {
            paramString1 = paramString2 + '.';
          }
          paramString1 = paramString1.toLowerCase(Locale.US);
          if (!paramString1.contains("*")) {
            return str.equals(paramString1);
          }
        } while ((!paramString1.startsWith("*.")) || (paramString1.indexOf('*', 1) != -1) || (str.length() < paramString1.length()) || ("*.".equals(paramString1)));
        paramString1 = paramString1.substring(1);
      } while (!str.endsWith(paramString1));
      i = str.length() - paramString1.length();
    } while ((i > 0) && (str.lastIndexOf('.', i - 1) != -1));
    return true;
  }
  
  private boolean b(String paramString, X509Certificate paramX509Certificate)
  {
    paramX509Certificate = a(paramX509Certificate, 7);
    int i = 0;
    int j = paramX509Certificate.size();
    while (i < j)
    {
      if (paramString.equalsIgnoreCase((String)paramX509Certificate.get(i))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private boolean c(String paramString, X509Certificate paramX509Certificate)
  {
    paramString = paramString.toLowerCase(Locale.US);
    int j = 0;
    List localList = a(paramX509Certificate, 2);
    int i = 0;
    int k = localList.size();
    while (i < k)
    {
      j = 1;
      if (a(paramString, (String)localList.get(i))) {
        return true;
      }
      i += 1;
    }
    if (j == 0)
    {
      paramX509Certificate = new c(paramX509Certificate.getSubjectX500Principal()).a("cn");
      if (paramX509Certificate != null) {
        return a(paramString, paramX509Certificate);
      }
    }
    return false;
  }
  
  public boolean a(String paramString, X509Certificate paramX509Certificate)
  {
    if (b.a.c.c(paramString)) {
      return b(paramString, paramX509Certificate);
    }
    return c(paramString, paramX509Certificate);
  }
  
  public boolean verify(String paramString, SSLSession paramSSLSession)
  {
    try
    {
      boolean bool = a(paramString, (X509Certificate)paramSSLSession.getPeerCertificates()[0]);
      return bool;
    }
    catch (SSLException paramString) {}
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/i/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */