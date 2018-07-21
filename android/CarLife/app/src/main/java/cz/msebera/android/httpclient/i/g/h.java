package cz.msebera.android.httpclient.i.g;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.j.i;
import cz.msebera.android.httpclient.o.a;
import java.io.IOException;
import java.io.OutputStream;

@NotThreadSafe
public class h
  extends OutputStream
{
  private final i a;
  private final long b;
  private long c = 0L;
  private boolean d = false;
  
  public h(i parami, long paramLong)
  {
    this.a = ((i)a.a(parami, "Session output buffer"));
    this.b = a.b(paramLong, "Content length");
  }
  
  public void close()
    throws IOException
  {
    if (!this.d)
    {
      this.d = true;
      this.a.a();
    }
  }
  
  public void flush()
    throws IOException
  {
    this.a.a();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    if (this.d) {
      throw new IOException("Attempted write to closed stream.");
    }
    if (this.c < this.b)
    {
      this.a.a(paramInt);
      this.c += 1L;
    }
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.d) {
      throw new IOException("Attempted write to closed stream.");
    }
    if (this.c < this.b)
    {
      long l = this.b - this.c;
      int i = paramInt2;
      if (paramInt2 > l) {
        i = (int)l;
      }
      this.a.a(paramArrayOfByte, paramInt1, i);
      this.c += i;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/g/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */