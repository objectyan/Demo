package cz.msebera.android.httpclient.e;

import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.r;
import java.io.IOException;
import java.net.InetAddress;

@Deprecated
public abstract interface e
{
  public abstract w a();
  
  public abstract void a(w paramw, r paramr, g paramg, j paramj)
    throws IOException;
  
  public abstract void a(w paramw, r paramr, InetAddress paramInetAddress, g paramg, j paramj)
    throws IOException;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */