package com.baidu.mapframework.commonlib.http;

import java.util.Set;

public abstract interface DNSProxy
{
  public abstract Set<String> getDomains(String paramString);
  
  public abstract String getIP(String paramString);
  
  public abstract void putIP2DomainsRecord(String paramString1, String paramString2);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/http/DNSProxy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */