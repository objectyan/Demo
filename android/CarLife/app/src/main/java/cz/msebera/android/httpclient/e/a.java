package cz.msebera.android.httpclient.e;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import java.io.IOException;
import java.io.InputStream;

@Deprecated
@NotThreadSafe
public class a
  implements n
{
  protected final t a;
  protected final boolean b;
  
  public a(t paramt, boolean paramBoolean)
  {
    cz.msebera.android.httpclient.o.a.a(paramt, "Connection");
    this.a = paramt;
    this.b = paramBoolean;
  }
  
  public boolean a(InputStream paramInputStream)
    throws IOException
  {
    try
    {
      if (this.b)
      {
        paramInputStream.close();
        this.a.o();
      }
      return false;
    }
    finally
    {
      this.a.i_();
    }
  }
  
  public boolean b(InputStream paramInputStream)
    throws IOException
  {
    try
    {
      if (this.b)
      {
        paramInputStream.close();
        this.a.o();
      }
      return false;
    }
    finally
    {
      this.a.i_();
    }
  }
  
  public boolean c(InputStream paramInputStream)
    throws IOException
  {
    this.a.b();
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */