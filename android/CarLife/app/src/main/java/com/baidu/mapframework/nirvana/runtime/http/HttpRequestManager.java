package com.baidu.mapframework.nirvana.runtime.http;

import android.text.TextUtils;
import com.baidu.mapframework.commonlib.asynchttp.AsyncHttpClient;
import com.baidu.mapframework.commonlib.asynchttp.RequestParams;
import com.baidu.mapframework.commonlib.asynchttp.ResponseHandlerInterface;
import com.baidu.mapframework.commonlib.asynchttp.SyncHttpClient;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicHeader;

public class HttpRequestManager
{
  private int a = 10000;
  private String b;
  private final byte[] c = new byte[0];
  private AsyncHttpClient d;
  private SyncHttpClient e;
  private CookieStore f = new BasicCookieStore();
  
  public HttpRequestManager(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
  }
  
  private void a(boolean paramBoolean)
  {
    synchronized (this.c)
    {
      if (Utils.isOnUiThread())
      {
        if (this.d == null) {
          this.d = new AsyncHttpClient();
        }
        this.d.setTimeout(this.a);
        if (!TextUtils.isEmpty(this.b)) {
          HttpClientParams.setCookiePolicy(this.d.getHttpClient().getParams(), this.b);
        }
      }
      do
      {
        return;
        if (this.e == null) {
          this.e = new SyncHttpClient();
        }
        this.e.setTimeout(this.a);
      } while (TextUtils.isEmpty(this.b));
      HttpClientParams.setCookiePolicy(this.e.getHttpClient().getParams(), this.b);
    }
  }
  
  private void a(boolean paramBoolean, String paramString, Header[] paramArrayOfHeader, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    if (paramBoolean) {
      Utils.assertNotOnUiThread();
    }
    a(paramBoolean);
    if (!Utils.isOnUiThread())
    {
      this.e.post(null, paramString, paramArrayOfHeader, paramRequestParams, null, paramResponseHandlerInterface);
      return;
    }
    this.d.post(null, paramString, paramArrayOfHeader, paramRequestParams, null, paramResponseHandlerInterface);
  }
  
  private Header[] a(HashMap<String, String> paramHashMap)
  {
    if (b(paramHashMap)) {
      paramHashMap.remove("Cookie");
    }
    Object localObject = null;
    if (paramHashMap != null)
    {
      Header[] arrayOfHeader = new Header[paramHashMap.size()];
      localObject = paramHashMap.keySet();
      int i = 0;
      Iterator localIterator = ((Set)localObject).iterator();
      for (;;)
      {
        localObject = arrayOfHeader;
        if (!localIterator.hasNext()) {
          break;
        }
        localObject = (String)localIterator.next();
        arrayOfHeader[i] = new BasicHeader((String)localObject, (String)paramHashMap.get(localObject));
        i += 1;
      }
    }
    return (Header[])localObject;
  }
  
  private void b(boolean paramBoolean, String paramString, Header[] paramArrayOfHeader, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    if (paramBoolean) {
      Utils.assertNotOnUiThread();
    }
    a(paramBoolean);
    if (!Utils.isOnUiThread())
    {
      this.e.get(null, paramString, paramArrayOfHeader, paramRequestParams, paramResponseHandlerInterface);
      return;
    }
    this.d.get(null, paramString, paramArrayOfHeader, paramRequestParams, paramResponseHandlerInterface);
  }
  
  private boolean b(HashMap<String, String> paramHashMap)
  {
    Object localObject = "";
    if (paramHashMap != null) {
      localObject = (String)paramHashMap.get("Cookie");
    }
    if ((localObject != null) && (!((String)localObject).isEmpty()))
    {
      paramHashMap = ((String)localObject).split(";");
      if ((paramHashMap != null) && (paramHashMap.length > 0))
      {
        this.f.clear();
        int j = paramHashMap.length;
        int i = 0;
        while (i < j)
        {
          localObject = paramHashMap[i].split("=", 2);
          if ((localObject != null) && (localObject.length == 2))
          {
            BasicClientCookie localBasicClientCookie = new BasicClientCookie(localObject[0], localObject[1]);
            localBasicClientCookie.setDomain(".baidu.com");
            localBasicClientCookie.setPath("/");
            localBasicClientCookie.setVersion(0);
            this.f.addCookie(localBasicClientCookie);
            localObject = new BasicClientCookie(localObject[0], localObject[1]);
            ((BasicClientCookie)localObject).setDomain(".nuomi.com");
            ((BasicClientCookie)localObject).setPath("/");
            ((BasicClientCookie)localObject).setVersion(0);
            this.f.addCookie((Cookie)localObject);
          }
          i += 1;
        }
        setCookieStore(this.f);
      }
      return true;
    }
    return false;
  }
  
  private void c(boolean paramBoolean, String paramString, Header[] paramArrayOfHeader, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    if (paramBoolean) {
      Utils.assertNotOnUiThread();
    }
    a(paramBoolean);
    if (!Utils.isOnUiThread())
    {
      localObject = null;
      try
      {
        paramRequestParams = paramRequestParams.getEntity(paramResponseHandlerInterface);
        this.e.put(null, paramString, paramArrayOfHeader, paramRequestParams, null, paramResponseHandlerInterface);
        return;
      }
      catch (IOException paramRequestParams)
      {
        for (;;)
        {
          paramRequestParams.printStackTrace();
          paramRequestParams = (RequestParams)localObject;
        }
      }
    }
    Object localObject = null;
    try
    {
      paramRequestParams = paramRequestParams.getEntity(paramResponseHandlerInterface);
      this.d.put(null, paramString, paramArrayOfHeader, paramRequestParams, null, paramResponseHandlerInterface);
      return;
    }
    catch (IOException paramRequestParams)
    {
      for (;;)
      {
        paramRequestParams.printStackTrace();
        paramRequestParams = (RequestParams)localObject;
      }
    }
  }
  
  private void d(boolean paramBoolean, String paramString, Header[] paramArrayOfHeader, RequestParams paramRequestParams, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    if (paramBoolean) {
      Utils.assertNotOnUiThread();
    }
    a(paramBoolean);
    if (!Utils.isOnUiThread())
    {
      this.e.delete(null, paramString, paramArrayOfHeader, paramRequestParams, paramResponseHandlerInterface);
      return;
    }
    this.d.delete(null, paramString, paramArrayOfHeader, paramRequestParams, paramResponseHandlerInterface);
  }
  
  public void cancelAllRequests(boolean paramBoolean)
  {
    if (this.d != null) {
      this.d.cancelAllRequests(paramBoolean);
    }
    if (this.e != null) {
      this.e.cancelAllRequests(paramBoolean);
    }
  }
  
  public void deleteRequest(boolean paramBoolean, String paramString, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    d(paramBoolean, paramString, a(paramHashMap1), new RequestParams(paramHashMap2), paramResponseHandlerInterface);
  }
  
  public void getRequest(String paramString, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    getRequest(false, paramString, paramHashMap1, paramHashMap2, paramResponseHandlerInterface);
  }
  
  public void getRequest(boolean paramBoolean, String paramString, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    paramHashMap2 = new RequestParams(paramHashMap2);
    b(paramBoolean, paramString, a(paramHashMap1), paramHashMap2, paramResponseHandlerInterface);
  }
  
  public void postRequest(String paramString, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    postRequest(false, paramString, paramHashMap1, paramHashMap2, null, null, paramResponseHandlerInterface);
  }
  
  public void postRequest(String paramString, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, HashMap<String, File> paramHashMap, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    postRequest(false, paramString, paramHashMap1, paramHashMap2, paramHashMap, null, paramResponseHandlerInterface);
  }
  
  public void postRequest(boolean paramBoolean, String paramString, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, HashMap<String, File> paramHashMap, HashMap<String, InputStream> paramHashMap3, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    paramHashMap2 = new RequestParams(paramHashMap2);
    if ((paramHashMap != null) && (!paramHashMap.isEmpty()))
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        try
        {
          paramHashMap2.put((String)localEntry.getKey(), (File)localEntry.getValue());
        }
        catch (FileNotFoundException localFileNotFoundException) {}
      }
    }
    if ((paramHashMap3 != null) && (!paramHashMap3.isEmpty()))
    {
      paramHashMap = paramHashMap3.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        paramHashMap3 = (Map.Entry)paramHashMap.next();
        try
        {
          paramHashMap2.put((String)paramHashMap3.getKey(), (InputStream)paramHashMap3.getValue());
        }
        catch (Exception paramHashMap3) {}
      }
    }
    a(paramBoolean, paramString, a(paramHashMap1), paramHashMap2, paramResponseHandlerInterface);
  }
  
  public void postRequest(boolean paramBoolean, String paramString, HashMap<String, String> paramHashMap, HttpEntity paramHttpEntity, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    if (paramBoolean) {
      Utils.assertNotOnUiThread();
    }
    a(paramBoolean);
    paramHashMap = a(paramHashMap);
    if (!Utils.isOnUiThread())
    {
      this.e.post(null, paramString, paramHashMap, paramHttpEntity, null, paramResponseHandlerInterface);
      return;
    }
    this.d.post(null, paramString, paramHashMap, paramHttpEntity, null, paramResponseHandlerInterface);
  }
  
  public void putRequest(boolean paramBoolean, String paramString, HashMap<String, String> paramHashMap1, HashMap<String, String> paramHashMap2, HashMap<String, File> paramHashMap, HashMap<String, InputStream> paramHashMap3, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    paramHashMap1 = a(paramHashMap1);
    paramHashMap2 = new RequestParams(paramHashMap2);
    if ((paramHashMap != null) && (!paramHashMap.isEmpty()))
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramHashMap.next();
        try
        {
          paramHashMap2.put((String)localEntry.getKey(), (File)localEntry.getValue());
        }
        catch (FileNotFoundException localFileNotFoundException) {}
      }
    }
    if ((paramHashMap3 != null) && (!paramHashMap3.isEmpty()))
    {
      paramHashMap = paramHashMap3.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        paramHashMap3 = (Map.Entry)paramHashMap.next();
        try
        {
          paramHashMap2.put((String)paramHashMap3.getKey(), (InputStream)paramHashMap3.getValue());
        }
        catch (Exception paramHashMap3) {}
      }
    }
    c(paramBoolean, paramString, paramHashMap1, paramHashMap2, paramResponseHandlerInterface);
  }
  
  public void putRequest(boolean paramBoolean, String paramString, HashMap<String, String> paramHashMap, HttpEntity paramHttpEntity, ResponseHandlerInterface paramResponseHandlerInterface)
  {
    if (paramBoolean) {
      Utils.assertNotOnUiThread();
    }
    a(paramBoolean);
    paramHashMap = a(paramHashMap);
    if (!Utils.isOnUiThread())
    {
      this.e.put(null, paramString, paramHashMap, paramHttpEntity, null, paramResponseHandlerInterface);
      return;
    }
    this.d.put(null, paramString, paramHashMap, paramHttpEntity, null, paramResponseHandlerInterface);
  }
  
  public void setCookieStore(CookieStore paramCookieStore)
  {
    if (paramCookieStore != null)
    {
      a(false);
      if (this.d != null) {
        this.d.setCookieStore(paramCookieStore);
      }
      if (this.e != null) {
        this.e.setCookieStore(paramCookieStore);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/runtime/http/HttpRequestManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */