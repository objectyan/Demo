package cz.msebera.android.httpclient.i.h;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.j;
import cz.msebera.android.httpclient.m.e;
import cz.msebera.android.httpclient.r;
import java.io.IOException;

@ThreadSafe
public class c
  extends e<r, j>
{
  public c(String paramString, r paramr, j paramj)
  {
    super(paramString, paramr, paramj);
  }
  
  public boolean e()
  {
    return !((j)i()).c();
  }
  
  public void f()
  {
    try
    {
      ((j)i()).close();
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/h/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */