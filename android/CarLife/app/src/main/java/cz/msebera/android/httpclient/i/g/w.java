package cz.msebera.android.httpclient.i.g;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.j.i;
import cz.msebera.android.httpclient.o.a;
import java.io.IOException;
import java.io.OutputStream;

@NotThreadSafe
public class w
  extends OutputStream
{
  private final i a;
  private boolean b = false;
  
  public w(i parami)
  {
    this.a = ((i)a.a(parami, "Session output buffer"));
  }
  
  public void close()
    throws IOException
  {
    if (!this.b)
    {
      this.b = true;
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
    if (this.b) {
      throw new IOException("Attempted write to closed stream.");
    }
    this.a.a(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.b) {
      throw new IOException("Attempted write to closed stream.");
    }
    this.a.a(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/g/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */