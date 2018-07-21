package cz.msebera.android.httpclient.o;

import java.lang.reflect.Method;

@Deprecated
public final class h
{
  private static final Method a = ;
  
  private static Method a()
  {
    try
    {
      Method localMethod = Throwable.class.getMethod("initCause", new Class[] { Throwable.class });
      return localMethod;
    }
    catch (NoSuchMethodException localNoSuchMethodException) {}
    return null;
  }
  
  public static void a(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    if (a != null) {}
    try
    {
      a.invoke(paramThrowable1, new Object[] { paramThrowable2 });
      return;
    }
    catch (Exception paramThrowable1) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/o/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */