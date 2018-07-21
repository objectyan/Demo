package com.loopj.android.http;

import cz.msebera.android.httpclient.b.d.f;
import java.net.URI;

public final class HttpDelete
  extends f
{
  public static final String METHOD_NAME = "DELETE";
  
  public HttpDelete() {}
  
  public HttpDelete(String paramString)
  {
    setURI(URI.create(paramString));
  }
  
  public HttpDelete(URI paramURI)
  {
    setURI(paramURI);
  }
  
  public String getMethod()
  {
    return "DELETE";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/loopj/android/http/HttpDelete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */