package cz.msebera.android.httpclient.n;

import cz.msebera.android.httpclient.annotation.GuardedBy;
import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.o.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@ThreadSafe
public class ah<T>
{
  @GuardedBy("this")
  private final Map<String, T> a = new HashMap();
  
  @Deprecated
  public Map<String, T> a()
  {
    try
    {
      Map localMap = this.a;
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    for (;;)
    {
      return;
      try
      {
        this.a.remove(paramString);
      }
      finally {}
    }
  }
  
  public void a(String paramString, T paramT)
  {
    try
    {
      a.a(paramString, "URI request pattern");
      this.a.put(paramString, paramT);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  @Deprecated
  public void a(Map<String, T> paramMap)
  {
    try
    {
      a.a(paramMap, "Map of handlers");
      this.a.clear();
      this.a.putAll(paramMap);
      return;
    }
    finally
    {
      paramMap = finally;
      throw paramMap;
    }
  }
  
  protected boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    if (paramString1.equals("*")) {
      return true;
    }
    boolean bool1;
    if ((!paramString1.endsWith("*")) || (!paramString2.startsWith(paramString1.substring(0, paramString1.length() - 1))))
    {
      bool1 = bool2;
      if (paramString1.startsWith("*"))
      {
        bool1 = bool2;
        if (!paramString2.endsWith(paramString1.substring(1, paramString1.length()))) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public T b(String paramString)
  {
    try
    {
      a.a(paramString, "Request path");
      Object localObject1 = this.a.get(paramString);
      Object localObject3 = localObject1;
      if (localObject1 == null)
      {
        Object localObject2 = null;
        Iterator localIterator = this.a.keySet().iterator();
        for (;;)
        {
          localObject3 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject3 = (String)localIterator.next();
          if ((a((String)localObject3, paramString)) && ((localObject2 == null) || (((String)localObject2).length() < ((String)localObject3).length()) || ((((String)localObject2).length() == ((String)localObject3).length()) && (((String)localObject3).endsWith("*")))))
          {
            localObject1 = this.a.get(localObject3);
            localObject2 = localObject3;
          }
        }
      }
      return (T)localObject3;
    }
    finally {}
  }
  
  @Deprecated
  public void b(Map<String, T> paramMap)
  {
    try
    {
      a.a(paramMap, "Map of handlers");
      this.a.clear();
      this.a.putAll(paramMap);
      return;
    }
    finally
    {
      paramMap = finally;
      throw paramMap;
    }
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/n/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */