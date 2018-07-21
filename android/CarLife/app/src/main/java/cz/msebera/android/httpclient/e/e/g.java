package cz.msebera.android.httpclient.e.e;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509KeyManager;
import javax.net.ssl.X509TrustManager;

@NotThreadSafe
public class g
{
  static final String a = "TLS";
  static final String b = "SSL";
  private String c;
  private Set<KeyManager> d = new HashSet();
  private Set<TrustManager> e = new HashSet();
  private SecureRandom f;
  
  public g a()
  {
    this.c = "TLS";
    return this;
  }
  
  public g a(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public g a(KeyStore paramKeyStore)
    throws NoSuchAlgorithmException, KeyStoreException
  {
    return a(paramKeyStore, null);
  }
  
  public g a(KeyStore paramKeyStore, m paramm)
    throws NoSuchAlgorithmException, KeyStoreException
  {
    TrustManagerFactory localTrustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    localTrustManagerFactory.init(paramKeyStore);
    paramKeyStore = localTrustManagerFactory.getTrustManagers();
    if (paramKeyStore != null)
    {
      if (paramm != null)
      {
        i = 0;
        while (i < paramKeyStore.length)
        {
          localTrustManagerFactory = paramKeyStore[i];
          if ((localTrustManagerFactory instanceof X509TrustManager)) {
            paramKeyStore[i] = new b((X509TrustManager)localTrustManagerFactory, paramm);
          }
          i += 1;
        }
      }
      int j = paramKeyStore.length;
      int i = 0;
      while (i < j)
      {
        paramm = paramKeyStore[i];
        this.e.add(paramm);
        i += 1;
      }
    }
    return this;
  }
  
  public g a(KeyStore paramKeyStore, char[] paramArrayOfChar)
    throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException
  {
    a(paramKeyStore, paramArrayOfChar, null);
    return this;
  }
  
  public g a(KeyStore paramKeyStore, char[] paramArrayOfChar, e parame)
    throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException
  {
    KeyManagerFactory localKeyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
    localKeyManagerFactory.init(paramKeyStore, paramArrayOfChar);
    paramKeyStore = localKeyManagerFactory.getKeyManagers();
    if (paramKeyStore != null)
    {
      if (parame != null)
      {
        i = 0;
        while (i < paramKeyStore.length)
        {
          paramArrayOfChar = paramKeyStore[i];
          if ((paramArrayOfChar instanceof X509KeyManager)) {
            paramKeyStore[i] = new a((X509KeyManager)paramArrayOfChar, parame);
          }
          i += 1;
        }
      }
      int j = paramKeyStore.length;
      int i = 0;
      while (i < j)
      {
        paramArrayOfChar = paramKeyStore[i];
        this.d.add(paramArrayOfChar);
        i += 1;
      }
    }
    return this;
  }
  
  public g a(SecureRandom paramSecureRandom)
  {
    this.f = paramSecureRandom;
    return this;
  }
  
  public g b()
  {
    this.c = "SSL";
    return this;
  }
  
  public SSLContext c()
    throws NoSuchAlgorithmException, KeyManagementException
  {
    Object localObject;
    SSLContext localSSLContext;
    if (this.c != null)
    {
      localObject = this.c;
      localSSLContext = SSLContext.getInstance((String)localObject);
      if (this.d.isEmpty()) {
        break label109;
      }
      localObject = (KeyManager[])this.d.toArray(new KeyManager[this.d.size()]);
      label54:
      if (this.e.isEmpty()) {
        break label114;
      }
    }
    label109:
    label114:
    for (TrustManager[] arrayOfTrustManager = (TrustManager[])this.e.toArray(new TrustManager[this.e.size()]);; arrayOfTrustManager = null)
    {
      localSSLContext.init((KeyManager[])localObject, arrayOfTrustManager, this.f);
      return localSSLContext;
      localObject = "TLS";
      break;
      localObject = null;
      break label54;
    }
  }
  
  static class a
    implements X509KeyManager
  {
    private final X509KeyManager a;
    private final e b;
    
    a(X509KeyManager paramX509KeyManager, e parame)
    {
      this.a = paramX509KeyManager;
      this.b = parame;
    }
    
    public String chooseClientAlias(String[] paramArrayOfString, Principal[] paramArrayOfPrincipal, Socket paramSocket)
    {
      HashMap localHashMap = new HashMap();
      int k = paramArrayOfString.length;
      int i = 0;
      while (i < k)
      {
        String str1 = paramArrayOfString[i];
        String[] arrayOfString = this.a.getClientAliases(str1, paramArrayOfPrincipal);
        if (arrayOfString != null)
        {
          int m = arrayOfString.length;
          int j = 0;
          while (j < m)
          {
            String str2 = arrayOfString[j];
            localHashMap.put(str2, new d(str1, this.a.getCertificateChain(str2)));
            j += 1;
          }
        }
        i += 1;
      }
      return this.b.a(localHashMap, paramSocket);
    }
    
    public String chooseServerAlias(String paramString, Principal[] paramArrayOfPrincipal, Socket paramSocket)
    {
      HashMap localHashMap = new HashMap();
      paramArrayOfPrincipal = this.a.getServerAliases(paramString, paramArrayOfPrincipal);
      if (paramArrayOfPrincipal != null)
      {
        int j = paramArrayOfPrincipal.length;
        int i = 0;
        while (i < j)
        {
          Principal localPrincipal = paramArrayOfPrincipal[i];
          localHashMap.put(localPrincipal, new d(paramString, this.a.getCertificateChain(localPrincipal)));
          i += 1;
        }
      }
      return this.b.a(localHashMap, paramSocket);
    }
    
    public X509Certificate[] getCertificateChain(String paramString)
    {
      return this.a.getCertificateChain(paramString);
    }
    
    public String[] getClientAliases(String paramString, Principal[] paramArrayOfPrincipal)
    {
      return this.a.getClientAliases(paramString, paramArrayOfPrincipal);
    }
    
    public PrivateKey getPrivateKey(String paramString)
    {
      return this.a.getPrivateKey(paramString);
    }
    
    public String[] getServerAliases(String paramString, Principal[] paramArrayOfPrincipal)
    {
      return this.a.getServerAliases(paramString, paramArrayOfPrincipal);
    }
  }
  
  static class b
    implements X509TrustManager
  {
    private final X509TrustManager a;
    private final m b;
    
    b(X509TrustManager paramX509TrustManager, m paramm)
    {
      this.a = paramX509TrustManager;
      this.b = paramm;
    }
    
    public void checkClientTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {
      this.a.checkClientTrusted(paramArrayOfX509Certificate, paramString);
    }
    
    public void checkServerTrusted(X509Certificate[] paramArrayOfX509Certificate, String paramString)
      throws CertificateException
    {
      if (!this.b.a(paramArrayOfX509Certificate, paramString)) {
        this.a.checkServerTrusted(paramArrayOfX509Certificate, paramString);
      }
    }
    
    public X509Certificate[] getAcceptedIssuers()
    {
      return this.a.getAcceptedIssuers();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/e/e/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */