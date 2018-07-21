package com.loopj.android.http;

import cz.msebera.android.httpclient.b.d.f;
import java.net.URI;

public final class HttpGet
  extends f
{
  public static final String METHOD_NAME = "GET";
  
  public HttpGet() {}
  
  public HttpGet(String paramString)
  {
    setURI(URI.create(paramString));
  }
  
  public HttpGet(URI paramURI)
  {
    setURI(paramURI);
  }
  
  public String getMethod()
  {
    return "GET";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/loopj/android/http/HttpGet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */