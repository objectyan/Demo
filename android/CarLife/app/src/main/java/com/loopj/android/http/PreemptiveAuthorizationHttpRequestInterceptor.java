package com.loopj.android.http;

import cz.msebera.android.httpclient.a.h;
import cz.msebera.android.httpclient.i.a.b;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.w;
import java.io.IOException;

public class PreemptiveAuthorizationHttpRequestInterceptor
  implements w
{
  public void process(u paramu, g paramg)
    throws p, IOException
  {
    paramu = (cz.msebera.android.httpclient.a.i)paramg.a("http.auth.target-scope");
    cz.msebera.android.httpclient.b.i locali = (cz.msebera.android.httpclient.b.i)paramg.a("http.auth.credentials-provider");
    paramg = (r)paramg.a("http.target_host");
    if (paramu.c() == null)
    {
      paramg = locali.a(new h(paramg.a(), paramg.b()));
      if (paramg != null)
      {
        paramu.a(new b());
        paramu.a(paramg);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/loopj/android/http/PreemptiveAuthorizationHttpRequestInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */