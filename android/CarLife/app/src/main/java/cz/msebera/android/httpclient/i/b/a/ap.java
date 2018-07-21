package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.x;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@NotThreadSafe
class ap
  implements InvocationHandler
{
  private static final Method a;
  private final x b;
  
  static
  {
    try
    {
      a = Closeable.class.getMethod("close", new Class[0]);
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new Error(localNoSuchMethodException);
    }
  }
  
  ap(x paramx)
  {
    this.b = paramx;
  }
  
  public void a()
    throws IOException
  {
    ae.a(this.b.b());
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
    throws Throwable
  {
    if (paramMethod.equals(a))
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/ap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */