package cz.msebera.android.httpclient.i.g;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.j.h;
import java.io.IOException;
import java.io.InputStream;

@NotThreadSafe
public class g
  extends InputStream
{
  private static final int a = 2048;
  private final long b;
  private long c = 0L;
  private boolean d = false;
  private h e = null;
  
  public g(h paramh, long paramLong)
  {
    this.e = ((h)cz.msebera.android.httpclient.o.a.a(paramh, "Session input buffer"));
    this.b = cz.msebera.android.httpclient.o.a.b(paramLong, "Content length");
  }
  
  public int available()
    throws IOException
  {
    if ((this.e instanceof cz.msebera.android.httpclient.j.a)) {
      return Math.min(((cz.msebera.android.httpclient.j.a)this.e).g(), (int)(this.b - this.c));
    }
    return 0;
  }
  
  public void close()
    throws IOException
  {
    if (!this.d) {}
    try
    {
      if (this.c < this.b)
      {
        byte[] arrayOfByte = new byte['ࠀ'];
        int i;
        do
        {
          i = read(arrayOfByte);
        } while (i >= 0);
      }
      return;
    }
    finally
    {
      this.d = true;
    }
  }
  
  public int read()
    throws IOException
  {
    if (this.d) {
      throw new IOException("Attempted read from closed stream.");
    }
    int i;
    if (this.c >= this.b) {
      i = -1;
    }
    do
    {
      return i;
      i = this.e.a();
      if (i != -1) {
        break;
      }
    } while (this.c >= this.b);
    throw new cz.msebera.android.httpclient.a("Premature end of Content-Length delimited message body (expected: " + this.b + "; received: " + this.c);
    this.c += 1L;
    return i;
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.d) {
      throw new IOException("Attempted read from closed stream.");
    }
    if (this.c >= this.b) {
      paramInt1 = -1;
    }
    do
    {
      return paramInt1;
      int i = paramInt2;
      if (this.c + paramInt2 > this.b) {
        i = (int)(this.b - this.c);
      }
      paramInt2 = this.e.a(paramArrayOfByte, paramInt1, i);
      if ((paramInt2 == -1) && (this.c < this.b)) {
        throw new cz.msebera.android.httpclient.a("Premature end of Content-Length delimited message body (expected: " + this.b + "; received: " + this.c);
      }
      paramInt1 = paramInt2;
    } while (paramInt2 <= 0);
    this.c += paramInt2;
    return paramInt2;
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    long l2;
    if (paramLong <= 0L)
    {
      l2 = 0L;
      return l2;
    }
    byte[] arrayOfByte = new byte['ࠀ'];
    long l1 = Math.min(paramLong, this.b - this.c);
    paramLong = 0L;
    for (;;)
    {
      l2 = paramLong;
      if (l1 <= 0L) {
        break;
      }
      int i = read(arrayOfByte, 0, (int)Math.min(2048L, l1));
      l2 = paramLong;
      if (i == -1) {
        break;
      }
      paramLong += i;
      l1 -= i;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/g/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */