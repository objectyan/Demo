package b.a.h;

import b.y;
import b.z;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okio.Buffer;

public class e
{
  private static final e a = ;
  private static final Logger b = Logger.getLogger(y.class.getName());
  public static final int c = 4;
  public static final int d = 5;
  
  private static e a()
  {
    Object localObject = a.a();
    if (localObject != null) {
      return (e)localObject;
    }
    localObject = b.a();
    if (localObject != null) {
      return (e)localObject;
    }
    localObject = c.a();
    if (localObject != null) {
      return (e)localObject;
    }
    return new e();
  }
  
  static <T> T a(Object paramObject, Class<T> paramClass, String paramString)
  {
    Object localObject3 = null;
    Class localClass = paramObject.getClass();
    while (localClass != Object.class) {
      try
      {
        Object localObject1 = localClass.getDeclaredField(paramString);
        ((Field)localObject1).setAccessible(true);
        Object localObject4 = ((Field)localObject1).get(paramObject);
        localObject1 = localObject3;
        if (localObject4 == null) {
          break label123;
        }
        if (!paramClass.isInstance(localObject4)) {
          return null;
        }
        localObject1 = paramClass.cast(localObject4);
        return (T)localObject1;
      }
      catch (IllegalAccessException paramObject)
      {
        throw new AssertionError();
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localClass = localClass.getSuperclass();
      }
    }
    Object localObject2 = localObject3;
    if (!paramString.equals("delegate"))
    {
      paramObject = a(paramObject, Object.class, "delegate");
      localObject2 = localObject3;
      if (paramObject != null) {
        localObject2 = a(paramObject, paramClass, paramString);
      }
    }
    label123:
    return (T)localObject2;
  }
  
  public static List<String> a(List<z> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    int i = 0;
    int j = paramList.size();
    if (i < j)
    {
      z localz = (z)paramList.get(i);
      if (localz == z.a) {}
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(localz.toString());
      }
    }
    return localArrayList;
  }
  
  public static e b()
  {
    return a;
  }
  
  static byte[] b(List<z> paramList)
  {
    Buffer localBuffer = new Buffer();
    int i = 0;
    int j = paramList.size();
    if (i < j)
    {
      z localz = (z)paramList.get(i);
      if (localz == z.a) {}
      for (;;)
      {
        i += 1;
        break;
        localBuffer.writeByte(localz.toString().length());
        localBuffer.writeUtf8(localz.toString());
      }
    }
    return localBuffer.readByteArray();
  }
  
  public b.a.i.b a(X509TrustManager paramX509TrustManager)
  {
    return new b.a.i.a(b.a.i.e.a(paramX509TrustManager));
  }
  
  public Object a(String paramString)
  {
    if (b.isLoggable(Level.FINE)) {
      return new Throwable(paramString);
    }
    return null;
  }
  
  public String a(SSLSocket paramSSLSocket)
  {
    return null;
  }
  
  public X509TrustManager a(SSLSocketFactory paramSSLSocketFactory)
  {
    try
    {
      paramSSLSocketFactory = a(paramSSLSocketFactory, Class.forName("sun.security.ssl.SSLContextImpl"), "context");
      if (paramSSLSocketFactory == null) {
        return null;
      }
      paramSSLSocketFactory = (X509TrustManager)a(paramSSLSocketFactory, X509TrustManager.class, "trustManager");
      return paramSSLSocketFactory;
    }
    catch (ClassNotFoundException paramSSLSocketFactory) {}
    return null;
  }
  
  public void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    if (paramInt == 5) {}
    for (Level localLevel = Level.WARNING;; localLevel = Level.INFO)
    {
      b.log(localLevel, paramString, paramThrowable);
      return;
    }
  }
  
  public void a(String paramString, Object paramObject)
  {
    String str = paramString;
    if (paramObject == null) {
      str = paramString + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
    }
    a(5, str, (Throwable)paramObject);
  }
  
  public void a(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
    throws IOException
  {
    paramSocket.connect(paramInetSocketAddress, paramInt);
  }
  
  public void a(SSLSocket paramSSLSocket, String paramString, List<z> paramList) {}
  
  public void b(SSLSocket paramSSLSocket) {}
  
  public boolean b(String paramString)
  {
    return true;
  }
  
  public String c()
  {
    return "OkHttp";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/h/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */