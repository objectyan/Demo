package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.b.d.c;
import cz.msebera.android.httpclient.o.g;
import cz.msebera.android.httpclient.x;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@NotThreadSafe
class n
  implements InvocationHandler
{
  private static final Constructor<?> a;
  private final x b;
  
  static
  {
    try
    {
      a = Proxy.getProxyClass(n.class.getClassLoader(), new Class[] { c.class }).getConstructor(new Class[] { InvocationHandler.class });
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new IllegalStateException(localNoSuchMethodException);
    }
  }
  
  n(x paramx)
  {
    this.b = paramx;
  }
  
  public static c a(x paramx)
  {
    try
    {
      paramx = (c)a.newInstance(new Object[] { new n(paramx) });
      return paramx;
    }
    catch (InstantiationException paramx)
    {
      throw new IllegalStateException(paramx);
    }
    catch (InvocationTargetException paramx)
    {
      throw new IllegalStateException(paramx);
    }
    catch (IllegalAccessException paramx)
    {
      throw new IllegalStateException(paramx);
    }
  }
  
  public void a()
    throws IOException
  {
    g.b(this.b.b());
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    throws Throwable
  {
    if (paramMethod.getName().equals("close"))
    {
      a();
      return null;
    }
    try
    {
      paramObject = paramMethod.invoke(this.b, paramArrayOfObject);
      return paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      paramMethod = ((InvocationTargetException)paramObject).getCause();
      if (paramMethod != null) {
        throw paramMethod;
      }
      throw ((Throwable)paramObject);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */