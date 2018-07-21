package b.a.h;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class d<T>
{
  private final Class<?> a;
  private final String b;
  private final Class[] c;
  
  public d(Class<?> paramClass, String paramString, Class... paramVarArgs)
  {
    this.a = paramClass;
    this.b = paramString;
    this.c = paramVarArgs;
  }
  
  private Method a(Class<?> paramClass)
  {
    Class<?> localClass = null;
    if (this.b != null)
    {
      paramClass = a(paramClass, this.b, this.c);
      localClass = paramClass;
      if (paramClass != null)
      {
        localClass = paramClass;
        if (this.a != null)
        {
          localClass = paramClass;
          if (!this.a.isAssignableFrom(paramClass.getReturnType())) {
            localClass = null;
          }
        }
      }
    }
    return localClass;
  }
  
  private static Method a(Class<?> paramClass, String paramString, Class[] paramArrayOfClass)
  {
    Class<?> localClass = null;
    try
    {
      paramClass = paramClass.getMethod(paramString, paramArrayOfClass);
      localClass = paramClass;
      int i = paramClass.getModifiers();
      if ((i & 0x1) == 0) {
        paramClass = null;
      }
      return paramClass;
    }
    catch (NoSuchMethodException paramClass) {}
    return localClass;
  }
  
  public Object a(T paramT, Object... paramVarArgs)
    throws InvocationTargetException
  {
    Method localMethod = a(paramT.getClass());
    if (localMethod == null) {
      return null;
    }
    try
    {
      paramT = localMethod.invoke(paramT, paramVarArgs);
      return paramT;
    }
    catch (IllegalAccessException paramT) {}
    return null;
  }
  
  public boolean a(T paramT)
  {
    return a(paramT.getClass()) != null;
  }
  
  public Object b(T paramT, Object... paramVarArgs)
  {
    try
    {
      paramT = a(paramT, paramVarArgs);
      return paramT;
    }
    catch (InvocationTargetException paramT)
    {
      paramT = paramT.getTargetException();
      if ((paramT instanceof RuntimeException)) {
        throw ((RuntimeException)paramT);
      }
      paramVarArgs = new AssertionError("Unexpected exception");
      paramVarArgs.initCause(paramT);
      throw paramVarArgs;
    }
  }
  
  public Object c(T paramT, Object... paramVarArgs)
    throws InvocationTargetException
  {
    Method localMethod = a(paramT.getClass());
    if (localMethod == null) {
      throw new AssertionError("Method " + this.b + " not supported for object " + paramT);
    }
    try
    {
      paramT = localMethod.invoke(paramT, paramVarArgs);
      return paramT;
    }
    catch (IllegalAccessException paramT)
    {
      paramVarArgs = new AssertionError("Unexpectedly could not call: " + localMethod);
      paramVarArgs.initCause(paramT);
      throw paramVarArgs;
    }
  }
  
  public Object d(T paramT, Object... paramVarArgs)
  {
    try
    {
      paramT = c(paramT, paramVarArgs);
      return paramT;
    }
    catch (InvocationTargetException paramT)
    {
      paramT = paramT.getTargetException();
      if ((paramT instanceof RuntimeException)) {
        throw ((RuntimeException)paramT);
      }
      paramVarArgs = new AssertionError("Unexpected exception");
      paramVarArgs.initCause(paramT);
      throw paramVarArgs;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/h/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */