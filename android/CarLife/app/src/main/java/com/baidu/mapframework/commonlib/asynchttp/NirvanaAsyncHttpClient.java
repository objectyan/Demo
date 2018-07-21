package com.baidu.mapframework.commonlib.asynchttp;

import android.content.Context;
import java.net.URI;
import java.util.concurrent.ExecutorService;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;

public class NirvanaAsyncHttpClient
  extends AsyncHttpClient
{
  public RequestHandle get(Context paramContext, String paramString, NirvanaResponseHandlerInterface paramNirvanaResponseHandlerInterface)
  {
    return get(paramContext, paramString, null, paramNirvanaResponseHandlerInterface);
  }
  
  public RequestHandle get(Context paramContext, String paramString, RequestParams paramRequestParams, NirvanaResponseHandlerInterface paramNirvanaResponseHandlerInterface)
  {
    return sendNirvanaRequest(this.httpClient, this.httpContext, new org.apache.http.client.methods.HttpGet(getUrlWithQueryString(this.b, paramString, paramRequestParams)), null, paramNirvanaResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle get(Context paramContext, String paramString1, HttpEntity paramHttpEntity, String paramString2, NirvanaResponseHandlerInterface paramNirvanaResponseHandlerInterface)
  {
    return sendNirvanaRequest(this.httpClient, this.httpContext, a(new HttpGet(URI.create(paramString1).normalize()), paramHttpEntity), paramString2, paramNirvanaResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle get(Context paramContext, String paramString, Header[] paramArrayOfHeader, RequestParams paramRequestParams, NirvanaResponseHandlerInterface paramNirvanaResponseHandlerInterface)
  {
    paramString = new org.apache.http.client.methods.HttpGet(getUrlWithQueryString(this.b, paramString, paramRequestParams));
    if (paramArrayOfHeader != null) {
      paramString.setHeaders(paramArrayOfHeader);
    }
    return sendNirvanaRequest(this.httpClient, this.httpContext, paramString, null, paramNirvanaResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle get(String paramString, NirvanaResponseHandlerInterface paramNirvanaResponseHandlerInterface)
  {
    return get(null, paramString, null, paramNirvanaResponseHandlerInterface);
  }
  
  public RequestHandle get(String paramString, RequestParams paramRequestParams, NirvanaResponseHandlerInterface paramNirvanaResponseHandlerInterface)
  {
    return get(null, paramString, paramRequestParams, paramNirvanaResponseHandlerInterface);
  }
  
  protected ExecutorService getDefaultThreadPool()
  {
    return super.getDefaultThreadPool();
  }
  
  public ExecutorService getThreadPool()
  {
    return super.getThreadPool();
  }
  
  public RequestHandle post(Context paramContext, String paramString, RequestParams paramRequestParams, NirvanaResponseHandlerInterface paramNirvanaResponseHandlerInterface)
  {
    return post(paramContext, paramString, a(paramRequestParams, paramNirvanaResponseHandlerInterface), null, paramNirvanaResponseHandlerInterface);
  }
  
  public RequestHandle post(Context paramContext, String paramString1, HttpEntity paramHttpEntity, String paramString2, NirvanaResponseHandlerInterface paramNirvanaResponseHandlerInterface)
  {
    return sendRequest(this.httpClient, this.httpContext, a(new HttpPost(getURI(paramString1)), paramHttpEntity), paramString2, paramNirvanaResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle post(Context paramContext, String paramString1, Header[] paramArrayOfHeader, RequestParams paramRequestParams, String paramString2, NirvanaResponseHandlerInterface paramNirvanaResponseHandlerInterface)
  {
    paramString1 = new HttpPost(getURI(paramString1));
    if (paramRequestParams != null) {
      paramString1.setEntity(a(paramRequestParams, paramNirvanaResponseHandlerInterface));
    }
    if (paramArrayOfHeader != null) {
      paramString1.setHeaders(paramArrayOfHeader);
    }
    return sendRequest(this.httpClient, this.httpContext, paramString1, paramString2, paramNirvanaResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle post(Context paramContext, String paramString1, Header[] paramArrayOfHeader, HttpEntity paramHttpEntity, String paramString2, NirvanaResponseHandlerInterface paramNirvanaResponseHandlerInterface)
  {
    paramString1 = a(new HttpPost(getURI(paramString1)), paramHttpEntity);
    if (paramArrayOfHeader != null) {
      paramString1.setHeaders(paramArrayOfHeader);
    }
    return sendRequest(this.httpClient, this.httpContext, paramString1, paramString2, paramNirvanaResponseHandlerInterface, paramContext);
  }
  
  public RequestHandle post(String paramString, NirvanaResponseHandlerInterface paramNirvanaResponseHandlerInterface)
  {
    return post(null, paramString, null, paramNirvanaResponseHandlerInterface);
  }
  
  public RequestHandle post(String paramString, RequestParams paramRequestParams, NirvanaResponseHandlerInterface paramNirvanaResponseHandlerInterface)
  {
    return post(null, paramString, paramRequestParams, paramNirvanaResponseHandlerInterface);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/commonlib/asynchttp/NirvanaAsyncHttpClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */