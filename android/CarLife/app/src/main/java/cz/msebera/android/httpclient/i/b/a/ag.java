package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.g.i;
import cz.msebera.android.httpclient.e.b.e;
import java.net.URI;
import java.net.URISyntaxException;

@Immutable
class ag
{
  public static URI a(URI paramURI, e parame)
    throws URISyntaxException
  {
    if (paramURI == null) {
      return null;
    }
    if ((parame.e() != null) && (!parame.g()))
    {
      if (!paramURI.isAbsolute()) {
        return i.a(paramURI, parame.a(), true);
      }
      return i.a(paramURI);
    }
    if (paramURI.isAbsolute()) {
      return i.a(paramURI, null, true);
    }
    return i.a(paramURI);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */