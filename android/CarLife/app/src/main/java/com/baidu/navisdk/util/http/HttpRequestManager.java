package com.baidu.navisdk.util.http;

import android.os.Bundle;
import com.baidu.navisdk.BNaviEngineManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import java.net.URI;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.conn.ssl.SSLSocketFactory;

public class HttpRequestManager
{
  private static volatile HttpRequestManager mInstance;
  private Map<String, Set<String>> ip2HostsMap = new ConcurrentHashMap();
  
  private void doDnsProxy(HttpRequestBase paramHttpRequestBase)
  {
    Object localObject = paramHttpRequestBase.getURI();
    String str1 = ((URI)localObject).toString();
    String str2 = ((URI)localObject).getHost();
    String str3 = BNaviEngineManager.getInstance().getIPByHost(str2);
    localObject = str1;
    if (!StringUtils.isEmpty(str3))
    {
      localObject = new Bundle();
      ((Bundle)localObject).putString("IP", str3);
      ((Bundle)localObject).putString("HOST", str2);
      BNaviModuleManager.putIP2DomainsRecord((Bundle)localObject);
      localObject = str1.replace(str2, str3);
      paramHttpRequestBase.setURI(URI.create((String)localObject));
      paramHttpRequestBase.addHeader("Host", str2);
    }
    LogUtil.e("HttpRequestManager", "  doDnsProxy  url: " + (String)localObject + "    request: " + str3);
  }
  
  public static HttpRequestManager getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null) {
        mInstance = new HttpRequestManager();
      }
      return mInstance;
    }
    finally {}
  }
  
  public void clear()
  {
    this.ip2HostsMap.clear();
  }
  
  public Set<String> getDomains(String paramString)
  {
    return (Set)this.ip2HostsMap.get(paramString);
  }
  
  public HttpGet getHttpGet(String paramString)
  {
    try
    {
      paramString = new HttpGet(paramString);
      doDnsProxy(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public HttpPost getHttpPost(String paramString)
  {
    try
    {
      paramString = new HttpPost(paramString);
      doDnsProxy(paramString);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public SSLSocketFactory getSSLSocketFactory()
  {
    SSLSocketFactory localSSLSocketFactory = SSLSocketFactory.getSocketFactory();
    localSSLSocketFactory.setHostnameVerifier(new NavDNSProxyCompatX509HostnameVerifier(localSSLSocketFactory.getHostnameVerifier()));
    return localSSLSocketFactory;
  }
  
  public void putIP2DomainsRecord(String paramString1, String paramString2)
  {
    Set localSet = (Set)this.ip2HostsMap.get(paramString1);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.ip2HostsMap.put(paramString1, localObject);
    }
    ((Set)localObject).add(paramString2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/http/HttpRequestManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */