package b.a.h;

import android.util.Log;
import b.a.c;
import b.a.i.b;
import b.z;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

class a
  extends e
{
  private static final int a = 4000;
  private final Class<?> b;
  private final d<Socket> e;
  private final d<Socket> f;
  private final d<Socket> g;
  private final d<Socket> h;
  private final b i = b.a();
  
  public a(Class<?> paramClass, d<Socket> paramd1, d<Socket> paramd2, d<Socket> paramd3, d<Socket> paramd4)
  {
    this.b = paramClass;
    this.e = paramd1;
    this.f = paramd2;
    this.g = paramd3;
    this.h = paramd4;
  }
  
  public static e a()
  {
    try
    {
      localClass = Class.forName("com.android.org.conscrypt.SSLParametersImpl");
      try
      {
        locald5 = new d(null, "setUseSessionTickets", new Class[] { Boolean.TYPE });
        locald6 = new d(null, "setHostname", new Class[] { String.class });
        locald4 = null;
        locald3 = null;
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        d locald5;
        d locald6;
        d locald3;
        d locald1;
        label97:
        return null;
      }
      try
      {
        Class.forName("android.net.Network");
        locald1 = new d(byte[].class, "getAlpnSelectedProtocol", new Class[0]);
      }
      catch (ClassNotFoundException localClassNotFoundException3)
      {
        d locald2 = locald4;
        break label97;
      }
      try
      {
        locald4 = new d(null, "setAlpnProtocols", new Class[] { byte[].class });
        locald3 = locald4;
      }
      catch (ClassNotFoundException localClassNotFoundException4)
      {
        break label97;
      }
      return new a(localClass, locald5, locald6, locald1, locald3);
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      for (;;)
      {
        Class localClass = Class.forName("org.apache.harmony.xnet.provider.jsse.SSLParametersImpl");
      }
    }
  }
  
  public b a(X509TrustManager paramX509TrustManager)
  {
    try
    {
      Object localObject = Class.forName("android.net.http.X509TrustManagerExtensions");
      localObject = new a(((Class)localObject).getConstructor(new Class[] { X509TrustManager.class }).newInstance(new Object[] { paramX509TrustManager }), ((Class)localObject).getMethod("checkServerTrusted", new Class[] { X509Certificate[].class, String.class, String.class }));
      return (b)localObject;
    }
    catch (Exception localException) {}
    return super.a(paramX509TrustManager);
  }
  
  public Object a(String paramString)
  {
    return this.i.a(paramString);
  }
  
  public String a(SSLSocket paramSSLSocket)
  {
    if (this.g == null) {}
    while (!this.g.a(paramSSLSocket)) {
      return null;
    }
    paramSSLSocket = (byte[])this.g.d(paramSSLSocket, new Object[0]);
    if (paramSSLSocket != null) {}
    for (paramSSLSocket = new String(paramSSLSocket, c.e);; paramSSLSocket = null) {
      return paramSSLSocket;
    }
  }
  
  public X509TrustManager a(SSLSocketFactory paramSSLSocketFactory)
  {
    Object localObject2 = a(paramSSLSocketFactory, this.b, "sslParameters");
    Object localObject1 = localObject2;
    if (localObject2 == null) {}
    try
    {
      localObject1 = a(paramSSLSocketFactory, Class.forName("com.google.android.gms.org.conscrypt.SSLParametersImpl", false, paramSSLSocketFactory.getClass().getClassLoader()), "sslParameters");
      paramSSLSocketFactory = (X509TrustManager)a(localObject1, X509TrustManager.class, "x509TrustManager");
      if (paramSSLSocketFactory != null) {
        return paramSSLSocketFactory;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      return super.a(paramSSLSocketFactory);
    }
    return (X509TrustManager)a(localClassNotFoundException, X509TrustManager.class, "trustManager");
  }
  
  public void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    int j = 5;
    String str;
    int n;
    label52:
    int k;
    if (paramInt == 5)
    {
      str = paramString;
      if (paramThrowable != null) {
        str = paramString + '\n' + Log.getStackTraceString(paramThrowable);
      }
      paramInt = 0;
      n = str.length();
      if (paramInt >= n) {
        return;
      }
      k = str.indexOf('\n', paramInt);
      if (k == -1) {
        break label126;
      }
    }
    for (;;)
    {
      int m = Math.min(k, paramInt + 4000);
      Log.println(j, "OkHttp", str.substring(paramInt, m));
      paramInt = m;
      if (m >= k)
      {
        paramInt = m + 1;
        break label52;
        j = 3;
        break;
        label126:
        k = n;
      }
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    if (!this.i.a(paramObject)) {
      a(5, paramString, null);
    }
  }
  
  public void a(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
    throws IOException
  {
    try
    {
      paramSocket.connect(paramInetSocketAddress, paramInt);
      return;
    }
    catch (AssertionError paramSocket)
    {
      if (c.a(paramSocket)) {
        throw new IOException(paramSocket);
      }
      throw paramSocket;
    }
    catch (SecurityException paramSocket)
    {
      paramInetSocketAddress = new IOException("Exception in connect");
      paramInetSocketAddress.initCause(paramSocket);
      throw paramInetSocketAddress;
    }
  }
  
  public void a(SSLSocket paramSSLSocket, String paramString, List<z> paramList)
  {
    if (paramString != null)
    {
      this.e.b(paramSSLSocket, new Object[] { Boolean.valueOf(true) });
      this.f.b(paramSSLSocket, new Object[] { paramString });
    }
    if ((this.h != null) && (this.h.a(paramSSLSocket)))
    {
      paramString = b(paramList);
      this.h.d(paramSSLSocket, new Object[] { paramString });
    }
  }
  
  public boolean b(String paramString)
  {
    try
    {
      Class localClass = Class.forName("android.security.NetworkSecurityPolicy");
      Object localObject = localClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
      boolean bool = ((Boolean)localClass.getMethod("isCleartextTrafficPermitted", new Class[] { String.class }).invoke(localObject, new Object[] { paramString })).booleanValue();
      return bool;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      return super.b(paramString);
    }
    catch (IllegalAccessException paramString)
    {
      throw new AssertionError();
    }
    catch (IllegalArgumentException paramString)
    {
      for (;;) {}
    }
    catch (InvocationTargetException paramString)
    {
      for (;;) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
  }
  
  static final class a
    extends b
  {
    private final Object a;
    private final Method b;
    
    a(Object paramObject, Method paramMethod)
    {
      this.a = paramObject;
      this.b = paramMethod;
    }
    
    public List<Certificate> a(List<Certificate> paramList, String paramString)
      throws SSLPeerUnverifiedException
    {
      try
      {
        paramList = (X509Certificate[])paramList.toArray(new X509Certificate[paramList.size()]);
        paramList = (List)this.b.invoke(this.a, new Object[] { paramList, "RSA", paramString });
        return paramList;
      }
      catch (InvocationTargetException paramList)
      {
        paramString = new SSLPeerUnverifiedException(paramList.getMessage());
        paramString.initCause(paramList);
        throw paramString;
      }
      catch (IllegalAccessException paramList)
      {
        throw new AssertionError(paramList);
      }
    }
    
    public boolean equals(Object paramObject)
    {
      return paramObject instanceof a;
    }
    
    public int hashCode()
    {
      return 0;
    }
  }
  
  static final class b
  {
    private final Method a;
    private final Method b;
    private final Method c;
    
    b(Method paramMethod1, Method paramMethod2, Method paramMethod3)
    {
      this.a = paramMethod1;
      this.b = paramMethod2;
      this.c = paramMethod3;
    }
    
    static b a()
    {
      try
      {
        localObject2 = Class.forName("dalvik.system.CloseGuard");
        Method localMethod1 = ((Class)localObject2).getMethod("get", new Class[0]);
        localMethod2 = ((Class)localObject2).getMethod("open", new Class[] { String.class });
        localObject2 = ((Class)localObject2).getMethod("warnIfOpen", new Class[0]);
        return new b(localMethod1, localMethod2, (Method)localObject2);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject1 = null;
          Method localMethod2 = null;
          Object localObject2 = null;
        }
      }
    }
    
    Object a(String paramString)
    {
      if (this.a != null) {
        try
        {
          Object localObject = this.a.invoke(null, new Object[0]);
          this.b.invoke(localObject, new Object[] { paramString });
          return localObject;
        }
        catch (Exception paramString) {}
      }
      return null;
    }
    
    boolean a(Object paramObject)
    {
      boolean bool = false;
      if (paramObject != null) {}
      try
      {
        this.c.invoke(paramObject, new Object[0]);
        bool = true;
        return bool;
      }
      catch (Exception paramObject) {}
      return false;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/h/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */