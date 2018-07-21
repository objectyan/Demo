package com.baidu.platform.comapi.c;

import com.baidu.mapframework.commonlib.http.DNSProxy;
import com.baidu.platform.comjni.engine.NAEngine;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class a
  implements DNSProxy
{
  private Map<String, Set<String>> a = new ConcurrentHashMap();
  
  public static a a()
  {
    return a.a();
  }
  
  public void b()
  {
    this.a.clear();
  }
  
  public Set<String> getDomains(String paramString)
  {
    return (Set)this.a.get(paramString);
  }
  
  public String getIP(String paramString)
  {
    try
    {
      paramString = NAEngine.getIP(paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return null;
  }
  
  public void putIP2DomainsRecord(String paramString1, String paramString2)
  {
    Set localSet = (Set)this.a.get(paramString1);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.a.put(paramString1, localObject);
    }
    ((Set)localObject).add(paramString2);
  }
  
  private static class a
  {
    private static final a a = new a(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/c/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */