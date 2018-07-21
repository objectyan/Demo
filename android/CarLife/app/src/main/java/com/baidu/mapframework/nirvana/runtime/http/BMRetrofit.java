package com.baidu.mapframework.nirvana.runtime.http;

public class BMRetrofit
{
  String a;
  private HttpRequestManager b;
  private int c = 10000;
  
  public HttpRequestManager build()
  {
    try
    {
      if (this.b == null) {
        this.b = new HttpRequestManager(this.c, this.a);
      }
      HttpRequestManager localHttpRequestManager = this.b;
      return localHttpRequestManager;
    }
    finally {}
  }
  
  public BMRetrofit cancelAllRequests(boolean paramBoolean)
  {
    if (this.b != null) {
      this.b.cancelAllRequests(paramBoolean);
    }
    return this;
  }
  
  public BMRetrofit setCookiePolicy(String paramString)
  {
    this.a = paramString;
    return this;
  }
  
  public BMRetrofit setTimeout(int paramInt)
  {
    this.c = paramInt;
    return this;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/runtime/http/BMRetrofit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */