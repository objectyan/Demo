package cz.msebera.android.httpclient.b.d;

import cz.msebera.android.httpclient.u;
import java.net.URI;

public abstract interface q
  extends u
{
  public abstract void abort()
    throws UnsupportedOperationException;
  
  public abstract String getMethod();
  
  public abstract URI getURI();
  
  public abstract boolean isAborted();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/d/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */