package cz.msebera.android.httpclient.b.g;

import cz.msebera.android.httpclient.annotation.Immutable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Immutable
public class a
{
  public static <T> T a(T paramT)
    throws CloneNotSupportedException
  {
    if (paramT == null) {
      return null;
    }
    if ((paramT instanceof Cloneable))
    {
      Object localObject = paramT.getClass();
      try
      {
        localObject = ((Class)localObject).getMethod("clone", (Class[])null);
        throw new CloneNotSupportedException();
      }
      catch (NoSuchMethodException paramT)
      {
        try
        {
          paramT = ((Method)localObject).invoke(paramT, (Object[])null);
          return paramT;
        }
        catch (InvocationTargetException paramT)
        {
          paramT = paramT.getCause();
          if (!(paramT instanceof CloneNotSupportedException)) {
            break label72;
          }
          throw ((CloneNotSupportedException)paramT);
          throw new Error("Unexpected exception", paramT);
        }
        catch (IllegalAccessException paramT)
        {
          throw new IllegalAccessError(paramT.getMessage());
        }
        paramT = paramT;
        throw new NoSuchMethodError(paramT.getMessage());
      }
    }
  }
  
  public static Object b(Object paramObject)
    throws CloneNotSupportedException
  {
    return a(paramObject);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */