package cz.msebera.android.httpclient.e;

import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.s;
import java.io.IOException;
import java.net.Socket;

@Deprecated
public abstract interface w
  extends cz.msebera.android.httpclient.j, s
{
  public abstract void a(Socket paramSocket, r paramr)
    throws IOException;
  
  public abstract void a(Socket paramSocket, r paramr, boolean paramBoolean, cz.msebera.android.httpclient.l.j paramj)
    throws IOException;
  
  public abstract void a(boolean paramBoolean, cz.msebera.android.httpclient.l.j paramj)
    throws IOException;
  
  public abstract r l();
  
  public abstract boolean m();
  
  public abstract Socket t();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */