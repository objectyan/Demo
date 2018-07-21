package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.ac;
import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.g;
import cz.msebera.android.httpclient.h.b;
import cz.msebera.android.httpclient.u;

@Immutable
class m
{
  public b a = new b(getClass());
  
  public boolean a(u paramu)
  {
    Object localObject = paramu.getRequestLine().a();
    ak localak = paramu.getRequestLine().b();
    if (ac.d.b(localak) != 0)
    {
      this.a.e("non-HTTP/1.1 request was not serveable from cache");
      return false;
    }
    if (!((String)localObject).equals("GET"))
    {
      this.a.e("non-GET request was not serveable from cache");
      return false;
    }
    if (paramu.getHeaders("Pragma").length > 0)
    {
      this.a.e("request with Pragma header was not serveable from cache");
      return false;
    }
    paramu = paramu.getHeaders("Cache-Control");
    int k = paramu.length;
    int i = 0;
    while (i < k)
    {
      localObject = paramu[i].e();
      int m = localObject.length;
      int j = 0;
      while (j < m)
      {
        localak = localObject[j];
        if ("no-store".equalsIgnoreCase(localak.a()))
        {
          this.a.e("Request with no-store was not serveable from cache");
          return false;
        }
        if ("no-cache".equalsIgnoreCase(localak.a()))
        {
          this.a.e("Request with no-cache was not serveable from cache");
          return false;
        }
        j += 1;
      }
      i += 1;
    }
    this.a.e("Request was serveable from cache");
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */