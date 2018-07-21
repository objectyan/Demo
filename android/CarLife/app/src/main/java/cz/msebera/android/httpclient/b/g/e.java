package cz.msebera.android.httpclient.b.g;

import cz.msebera.android.httpclient.annotation.Immutable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Immutable
public class e
  implements d
{
  private final Method a;
  
  public e()
    throws ClassNotFoundException
  {
    Class localClass = Class.forName("java.net.IDN");
    try
    {
      this.a = localClass.getMethod("toUnicode", new Class[] { String.class });
      return;
    }
    catch (SecurityException localSecurityException)
    {
      throw new IllegalStateException(localSecurityException.getMessage(), localSecurityException);
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      throw new IllegalStateException(localNoSuchMethodException.getMessage(), localNoSuchMethodException);
    }
  }
  
  public String a(String paramString)
  {
    try
    {
      paramString = (String)this.a.invoke(null, new Object[] { paramString });
      return paramString;
    }
    catch (IllegalAccessException paramString)
    {
      throw new IllegalStateException(paramString.getMessage(), paramString);
    }
    catch (InvocationTargetException paramString)
    {
      paramString = paramString.getCause();
      throw new RuntimeException(paramString.getMessage(), paramString);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/g/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */