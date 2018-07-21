package cz.msebera.android.httpclient.e.e;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.h.b;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.security.auth.x500.X500Principal;

@Immutable
public abstract class a
  implements n
{
  private static final String[] b = { "ac", "co", "com", "ed", "edu", "go", "gouv", "gov", "info", "lg", "ne", "net", "or", "org" };
  public b a = new b(getClass());
  
  static
  {
    Arrays.sort(b);
  }
  
  @Deprecated
  public static boolean a(String paramString)
  {
    paramString = paramString.split("\\.");
    if ((paramString.length != 3) || (paramString[2].length() != 2)) {}
    while (Arrays.binarySearch(b, paramString[1]) < 0) {
      return true;
    }
    return false;
  }
  
  public static String[] a(X509Certificate paramX509Certificate)
  {
    paramX509Certificate = paramX509Certificate.getSubjectX500Principal().toString();
    try
    {
      paramX509Certificate = c(paramX509Certificate);
      return paramX509Certificate;
    }
    catch (SSLException paramX509Certificate) {}
    return null;
  }
  
  private static String[] a(X509Certificate paramX509Certificate, String paramString)
  {
    int i;
    if (e(paramString)) {
      i = 7;
    }
    for (;;)
    {
      LinkedList localLinkedList = new LinkedList();
      paramString = null;
      try
      {
        paramX509Certificate = paramX509Certificate.getSubjectAlternativeNames();
        if (paramX509Certificate != null)
        {
          paramX509Certificate = paramX509Certificate.iterator();
          for (;;)
          {
            if (paramX509Certificate.hasNext())
            {
              paramString = (List)paramX509Certificate.next();
              if (((Integer)paramString.get(0)).intValue() == i)
              {
                localLinkedList.add((String)paramString.get(1));
                continue;
                i = 2;
                break;
              }
            }
          }
        }
        if (!localLinkedList.isEmpty())
        {
          paramX509Certificate = new String[localLinkedList.size()];
          localLinkedList.toArray(paramX509Certificate);
          return paramX509Certificate;
        }
        return null;
      }
      catch (CertificateParsingException paramX509Certificate)
      {
        for (;;)
        {
          paramX509Certificate = paramString;
        }
      }
    }
  }
  
  public static String[] b(X509Certificate paramX509Certificate)
  {
    return a(paramX509Certificate, null);
  }
  
  static String[] c(String paramString)
    throws SSLException
  {
    if (paramString == null) {}
    LinkedList localLinkedList;
    do
    {
      return null;
      localLinkedList = new LinkedList();
      paramString = new StringTokenizer(paramString, ",");
      while (paramString.hasMoreTokens())
      {
        String str = paramString.nextToken();
        int i = str.indexOf("CN=");
        if (i >= 0) {
          localLinkedList.add(str.substring(i + 3));
        }
      }
    } while (localLinkedList.isEmpty());
    paramString = new String[localLinkedList.size()];
    localLinkedList.toArray(paramString);
    return paramString;
  }
  
  public static int d(String paramString)
  {
    int j = 0;
    int i = 0;
    while (i < paramString.length())
    {
      int k = j;
      if (paramString.charAt(i) == '.') {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    return j;
  }
  
  private static boolean e(String paramString)
  {
    return (paramString != null) && ((cz.msebera.android.httpclient.e.f.a.a(paramString)) || (cz.msebera.android.httpclient.e.f.a.e(paramString)));
  }
  
  private String f(String paramString)
  {
    if ((paramString == null) || (!cz.msebera.android.httpclient.e.f.a.e(paramString))) {
      return paramString;
    }
    try
    {
      String str = InetAddress.getByName(paramString).getHostAddress();
      return str;
    }
    catch (UnknownHostException localUnknownHostException)
    {
      this.a.b("Unexpected error converting " + paramString, localUnknownHostException);
    }
    return paramString;
  }
  
  public final void a(String paramString, X509Certificate paramX509Certificate)
    throws SSLException
  {
    a(paramString, a(paramX509Certificate), a(paramX509Certificate, paramString));
  }
  
  public final void a(String paramString, SSLSocket paramSSLSocket)
    throws IOException
  {
    if (paramString == null) {
      throw new NullPointerException("host to verify is null");
    }
    SSLSession localSSLSession2 = paramSSLSocket.getSession();
    SSLSession localSSLSession1 = localSSLSession2;
    if (localSSLSession2 == null)
    {
      paramSSLSocket.getInputStream().available();
      localSSLSession2 = paramSSLSocket.getSession();
      localSSLSession1 = localSSLSession2;
      if (localSSLSession2 == null)
      {
        paramSSLSocket.startHandshake();
        localSSLSession1 = paramSSLSocket.getSession();
      }
    }
    a(paramString, (X509Certificate)localSSLSession1.getPeerCertificates()[0]);
  }
  
  public final void a(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2, boolean paramBoolean)
    throws SSLException
  {
    Object localObject1 = new LinkedList();
    if ((paramArrayOfString1 != null) && (paramArrayOfString1.length > 0) && (paramArrayOfString1[0] != null)) {
      ((LinkedList)localObject1).add(paramArrayOfString1[0]);
    }
    int i;
    if (paramArrayOfString2 != null)
    {
      int j = paramArrayOfString2.length;
      i = 0;
      while (i < j)
      {
        paramArrayOfString1 = paramArrayOfString2[i];
        if (paramArrayOfString1 != null) {
          ((LinkedList)localObject1).add(paramArrayOfString1);
        }
        i += 1;
      }
    }
    if (((LinkedList)localObject1).isEmpty()) {
      throw new SSLException("Certificate for <" + paramString + "> doesn't contain CN or DNS subjectAlt");
    }
    paramArrayOfString1 = new StringBuilder();
    paramArrayOfString2 = f(paramString.trim().toLowerCase(Locale.ENGLISH));
    boolean bool2 = false;
    localObject1 = ((LinkedList)localObject1).iterator();
    boolean bool1 = bool2;
    String str1;
    if (((Iterator)localObject1).hasNext())
    {
      str1 = ((String)((Iterator)localObject1).next()).toLowerCase(Locale.ENGLISH);
      paramArrayOfString1.append(" <");
      paramArrayOfString1.append(str1);
      paramArrayOfString1.append('>');
      if (((Iterator)localObject1).hasNext()) {
        paramArrayOfString1.append(" OR");
      }
      Object localObject2 = str1.split("\\.");
      if ((localObject2.length < 3) || (!localObject2[0].endsWith("*")) || (!b(str1)) || (e(paramString))) {
        break label436;
      }
      i = 1;
      label271:
      if (i == 0) {
        break label469;
      }
      String str2 = localObject2[0];
      if (str2.length() <= 1) {
        break label448;
      }
      localObject2 = str2.substring(0, str2.length() - 1);
      str2 = str1.substring(str2.length());
      String str3 = paramArrayOfString2.substring(((String)localObject2).length());
      if ((!paramArrayOfString2.startsWith((String)localObject2)) || (!str3.endsWith(str2))) {
        break label442;
      }
      bool2 = true;
      label351:
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (paramBoolean)
        {
          if (d(paramArrayOfString2) != d(str1)) {
            break label463;
          }
          bool1 = true;
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (!bool1) {
        break;
      }
      if (bool1) {
        return;
      }
      throw new SSLException("hostname in certificate didn't match: <" + paramString + "> !=" + paramArrayOfString1);
      label436:
      i = 0;
      break label271;
      label442:
      bool2 = false;
      break label351;
      label448:
      bool2 = paramArrayOfString2.endsWith(str1.substring(1));
      break label351;
      label463:
      bool1 = false;
      continue;
      label469:
      bool1 = paramArrayOfString2.equals(f(str1));
    }
  }
  
  boolean b(String paramString)
  {
    paramString = paramString.split("\\.");
    if ((paramString.length != 3) || (paramString[2].length() != 2)) {}
    while (Arrays.binarySearch(b, paramString[1]) < 0) {
      return true;
    }
    return false;
  }
  
  public final boolean verify(String paramString, SSLSession paramSSLSession)
  {
    try
    {
      a(paramString, (X509Certificate)paramSSLSession.getPeerCertificates()[0]);
      return true;
    }
    catch (SSLException paramString) {}
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */