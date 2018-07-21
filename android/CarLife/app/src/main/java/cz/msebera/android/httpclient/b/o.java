package cz.msebera.android.httpclient.b;

import cz.msebera.android.httpclient.aj;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.x;
import java.net.URI;

@Deprecated
public abstract interface o
{
  public abstract URI getLocationURI(x paramx, g paramg)
    throws aj;
  
  public abstract boolean isRedirectRequested(x paramx, g paramg);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/b/o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */