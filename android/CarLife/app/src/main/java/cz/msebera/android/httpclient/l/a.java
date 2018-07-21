package cz.msebera.android.httpclient.l;

import java.util.Set;

@Deprecated
public abstract class a
  implements j, k
{
  public double a(String paramString, double paramDouble)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return paramDouble;
    }
    return ((Double)paramString).doubleValue();
  }
  
  public int a(String paramString, int paramInt)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return paramInt;
    }
    return ((Integer)paramString).intValue();
  }
  
  public long a(String paramString, long paramLong)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return paramLong;
    }
    return ((Long)paramString).longValue();
  }
  
  public boolean a(String paramString, boolean paramBoolean)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return paramBoolean;
    }
    return ((Boolean)paramString).booleanValue();
  }
  
  public j b(String paramString, double paramDouble)
  {
    a(paramString, Double.valueOf(paramDouble));
    return this;
  }
  
  public j b(String paramString, int paramInt)
  {
    a(paramString, Integer.valueOf(paramInt));
    return this;
  }
  
  public j b(String paramString, long paramLong)
  {
    a(paramString, Long.valueOf(paramLong));
    return this;
  }
  
  public j b(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (Boolean localBoolean = Boolean.TRUE;; localBoolean = Boolean.FALSE)
    {
      a(paramString, localBoolean);
      return this;
    }
  }
  
  public boolean c(String paramString)
  {
    return a(paramString, false);
  }
  
  public boolean d(String paramString)
  {
    boolean bool = false;
    if (!a(paramString, false)) {
      bool = true;
    }
    return bool;
  }
  
  public Set<String> f()
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/l/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */