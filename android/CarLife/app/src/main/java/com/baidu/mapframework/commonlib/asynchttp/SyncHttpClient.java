package com.baidu.mapframework.commonlib.asynchttp;

import android.content.Context;
import com.baidu.mapframework.commonlib.http.DNSProxy;
import java.net.URI;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

public class SyncHttpClient
  extends AsyncHttpClient
{
  public SyncHttpClient()
  {
    super(false, 80, 443);
  }
  
  public SyncHttpClient(int paramInt)
  {
    super(false, paramInt, 443);
  }
  
  public SyncHttpClient(int paramInt1, int paramInt2)
  {
    super(false, paramInt1, paramInt2);
  }
  
  public SyncHttpClient(SchemeRegistry paramSchemeRegistry)
  {
    super(paramSchemeRegistry);
  }
  
  public SyncHttpClient(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(paramBoolean, paramInt1, paramInt2);
  }
  
  protected RequestHandle sendRequest(DefaultHttpClient paramDefaultHttpClient, HttpContext paramHttpContext, HttpUriRequest paramHttpUriRequest, String paramString, ResponseHandlerInterface paramResponseHandlerInterface, Context paramContext)
  {
    if (paramString != null) {
      paramHttpUriRequest.addHeader("Content-Type", paramString);
    }
    paramResponseHandlerInterface.setUseSynchronousMode(true);
    Object localObject = paramHttpUriRequest.getURI();
    String str1 = ((URI)localObject).toString();
    localObject = ((URI)localObject).getHost();
    if (sDNS_PROXY != null)
    {
      String str2 = sDNS_PROXY.getIP((String)localObject);
      if ((str2 != null) && (!str2.equals("")))
      {
        sDNS_PROXY.putIP2DomainsRecord(str2, (String)localObject);
        str1 = str1.replace((CharSequence)localObject, str2);
        if ((paramHttpUriRequest instanceof HttpRequestBase)) {
          ((HttpRequestBase)paramHttpUriRequest).setURI(URI.create(str1));
        }
        paramHttpUriRequest.setHeader("_org_host_", (String)localObject);
      }
    }
    newAsyncHttpRequest(paramDefaultHttpClient, paramHttpContext, paramHttpUriRequest, paramString, paramResponseHandlerInterface, paramContext).run();
    return new RequestHandle(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/asynchttp/SyncHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */