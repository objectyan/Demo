package cz.msebera.android.httpclient.l;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Deprecated
@ThreadSafe
public class b
  extends a
  implements Serializable, Cloneable
{
  private static final long a = -7086398485908701455L;
  private final Map<String, Object> b = new ConcurrentHashMap();
  
  public j a(String paramString, Object paramObject)
  {
    if (paramString == null) {
      return this;
    }
    if (paramObject != null)
    {
      this.b.put(paramString, paramObject);
      return this;
    }
    this.b.remove(paramString);
    return this;
  }
  
  public Object a(String paramString)
  {
    return this.b.get(paramString);
  }
  
  public void a()
  {
    this.b.clear();
  }
  
  public void a(j paramj)
  {
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramj.a((String)localEntry.getKey(), localEntry.getValue());
    }
  }
  
  public void a(String[] paramArrayOfString, Object paramObject)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      a(paramArrayOfString[i], paramObject);
      i += 1;
    }
  }
  
  public boolean b(String paramString)
  {
    if (this.b.containsKey(paramString))
    {
      this.b.remove(paramString);
      return true;
    }
    return false;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    b localb = (b)super.clone();
    a(localb);
    return localb;
  }
  
  public j e()
  {
    try
    {
      j localj = (j)clone();
      return localj;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new UnsupportedOperationException("Cloning not supported");
    }
  }
  
  public boolean e(String paramString)
  {
    return a(paramString) != null;
  }
  
  public Set<String> f()
  {
    return new HashSet(this.b.keySet());
  }
  
  public boolean f(String paramString)
  {
    return this.b.get(paramString) != null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/l/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */