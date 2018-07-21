package com.indooratlas.android.sdk._internal;

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

public final class ik
  implements HostnameVerifier
{
  public static final ik a = new ik();
  
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
    localArrayList = new ArrayList();
    try
    {
      paramX509Certificate = paramX509Certificate.getSubjectAlternativeNames();
      if (paramX509Certificate == null) {
        return Collections.emptyList();
      }
      paramX509Certificate = paramX509Certificate.iterator();
      while (paramX509Certificate.hasNext())
      {
        Object localObject = (List)paramX509Certificate.next();
        if ((localObject != null) && (((List)localObject).size() >= 2))
        {
          Integer localInteger = (Integer)((List)localObject).get(0);
          if ((localInteger != null) && (localInteger.intValue() == paramInt))
          {
            localObject = (String)((List)localObject).get(1);
            if (localObject != null) {
              localArrayList.add(localObject);
            }
          }
        }
      }
      return localArrayList;
    }
    catch (CertificateParsingException paramX509Certificate)
    {
      return Collections.emptyList();
    }
  }
  
  private static boolean a(String paramString1, String paramString2)
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
  
  public final boolean verify(String paramString, SSLSession paramSSLSession)
  {
    try
    {
      paramSSLSession = (X509Certificate)paramSSLSession.getPeerCertificates()[0];
      int j;
      int i;
      label89:
      ij localij;
      if (gy.b(paramString))
      {
        paramSSLSession = a(paramSSLSession, 7);
        j = paramSSLSession.size();
        i = 0;
        if (i >= j) {
          break label717;
        }
        if (paramString.equalsIgnoreCase((String)paramSSLSession.get(i))) {
          return true;
        }
      }
      else
      {
        String str = paramString.toLowerCase(Locale.US);
        paramString = a(paramSSLSession, 2);
        int k = paramString.size();
        j = 0;
        i = 0;
        if (j < k)
        {
          if (!a(str, (String)paramString.get(j))) {
            break label719;
          }
          return true;
        }
        if (i == 0)
        {
          localij = new ij(paramSSLSession.getSubjectX500Principal());
          localij.c = 0;
          localij.d = 0;
          localij.e = 0;
          localij.f = 0;
          localij.g = localij.a.toCharArray();
          paramSSLSession = localij.a();
          if (paramSSLSession != null) {
            break label707;
          }
          paramString = null;
          while (paramString != null)
          {
            return a(str, paramString);
            label194:
            paramString = "";
            if (localij.c == localij.b) {
              paramString = null;
            } else {
              switch (localij.g[localij.c])
              {
              }
            }
          }
        }
      }
      for (;;)
      {
        paramString = localij.c();
        while (!"cn".equalsIgnoreCase(paramSSLSession))
        {
          if (localij.c < localij.b) {
            break label579;
          }
          paramString = null;
          break;
          localij.c += 1;
          localij.d = localij.c;
          localij.e = localij.d;
          if (localij.c == localij.b) {
            throw new IllegalStateException("Unexpected end of DN: " + localij.a);
          }
          if (localij.g[localij.c] == '"') {
            for (localij.c += 1; (localij.c < localij.b) && (localij.g[localij.c] == ' '); localij.c += 1) {}
          }
          if (localij.g[localij.c] == '\\') {
            localij.g[localij.e] = localij.d();
          }
          for (;;)
          {
            localij.c += 1;
            localij.e += 1;
            break;
            localij.g[localij.e] = localij.g[localij.c];
          }
          paramString = new String(localij.g, localij.d, localij.e - localij.d);
          continue;
          paramString = localij.b();
        }
        label579:
        if ((localij.g[localij.c] != ',') && (localij.g[localij.c] != ';') && (localij.g[localij.c] != '+')) {
          throw new IllegalStateException("Malformed DN: " + localij.a);
        }
        localij.c += 1;
        paramSSLSession = localij.a();
        if (paramSSLSession == null)
        {
          throw new IllegalStateException("Malformed DN: " + localij.a);
          return false;
          label707:
          break label194;
          i += 1;
          break;
          label717:
          return false;
          label719:
          j += 1;
          i = 1;
          break label89;
        }
        break label194;
      }
      return false;
    }
    catch (SSLException paramString) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ik.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */