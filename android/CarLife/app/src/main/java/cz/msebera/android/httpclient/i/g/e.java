package cz.msebera.android.httpclient.i.g;

import cz.msebera.android.httpclient.ad;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.ap;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.j.h;
import cz.msebera.android.httpclient.o.d;
import cz.msebera.android.httpclient.p;
import java.io.IOException;
import java.io.InputStream;

@NotThreadSafe
public class e
  extends InputStream
{
  private static final int a = 1;
  private static final int b = 2;
  private static final int c = 3;
  private static final int d = 2048;
  private final h e;
  private final d f;
  private int g;
  private int h;
  private int i;
  private boolean j = false;
  private boolean k = false;
  private f[] l = new f[0];
  
  public e(h paramh)
  {
    this.e = ((h)cz.msebera.android.httpclient.o.a.a(paramh, "Session input buffer"));
    this.i = 0;
    this.f = new d(16);
    this.g = 1;
  }
  
  private void b()
    throws IOException
  {
    this.h = c();
    if (this.h < 0) {
      throw new ad("Negative chunk size");
    }
    this.g = 2;
    this.i = 0;
    if (this.h == 0)
    {
      this.j = true;
      d();
    }
  }
  
  private int c()
    throws IOException
  {
    switch (this.g)
    {
    case 2: 
    default: 
      throw new IllegalStateException("Inconsistent codec state");
    case 3: 
      this.f.a();
      if (this.e.a(this.f) != -1) {
        break;
      }
    }
    do
    {
      return 0;
      if (!this.f.f()) {
        throw new ad("Unexpected content at the end of chunk");
      }
      this.g = 1;
      this.f.a();
    } while (this.e.a(this.f) == -1);
    int n = this.f.d(59);
    int m = n;
    if (n < 0) {
      m = this.f.e();
    }
    try
    {
      m = Integer.parseInt(this.f.b(0, m), 16);
      return m;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new ad("Bad chunk header");
    }
  }
  
  private void d()
    throws IOException
  {
    try
    {
      this.l = a.a(this.e, -1, -1, null);
      return;
    }
    catch (p localp)
    {
      ad localad = new ad("Invalid footer: " + localp.getMessage());
      localad.initCause(localp);
      throw localad;
    }
  }
  
  public f[] a()
  {
    return (f[])this.l.clone();
  }
  
  public int available()
    throws IOException
  {
    if ((this.e instanceof cz.msebera.android.httpclient.j.a)) {
      return Math.min(((cz.msebera.android.httpclient.j.a)this.e).g(), this.h - this.i);
    }
    return 0;
  }
  
  public void close()
    throws IOException
  {
    if (!this.k) {}
    try
    {
      if (!this.j)
      {
        byte[] arrayOfByte = new byte['ࠀ'];
        int m;
        do
        {
          m = read(arrayOfByte);
        } while (m >= 0);
      }
      return;
    }
    finally
    {
      this.j = true;
      this.k = true;
    }
  }
  
  public int read()
    throws IOException
  {
    if (this.k) {
      throw new IOException("Attempted read from closed stream.");
    }
    int m;
    if (this.j) {
      m = -1;
    }
    int n;
    do
    {
      do
      {
        return m;
        if (this.g != 2)
        {
          b();
          if (this.j) {
            return -1;
          }
        }
        n = this.e.a();
        m = n;
      } while (n == -1);
      this.i += 1;
      m = n;
    } while (this.i < this.h);
    this.g = 3;
    return n;
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.k) {
      throw new IOException("Attempted read from closed stream.");
    }
    if (this.j) {
      paramInt1 = -1;
    }
    do
    {
      return paramInt1;
      if (this.g != 2)
      {
        b();
        if (this.j) {
          return -1;
        }
      }
      paramInt2 = this.e.a(paramArrayOfByte, paramInt1, Math.min(paramInt2, this.h - this.i));
      if (paramInt2 == -1) {
        break;
      }
      this.i += paramInt2;
      paramInt1 = paramInt2;
    } while (this.i < this.h);
    this.g = 3;
    return paramInt2;
    this.j = true;
    throw new ap("Truncated chunk ( expected size: " + this.h + "; actual size: " + this.i + ")");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/g/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */