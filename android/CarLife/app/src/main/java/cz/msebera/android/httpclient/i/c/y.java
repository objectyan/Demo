package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import java.io.IOException;
import java.io.InputStream;

@NotThreadSafe
class y
  extends InputStream
{
  private final InputStream a;
  private final am b;
  
  public y(InputStream paramInputStream, am paramam)
  {
    this.a = paramInputStream;
    this.b = paramam;
  }
  
  public int available()
    throws IOException
  {
    try
    {
      int i = this.a.available();
      return i;
    }
    catch (IOException localIOException)
    {
      this.b.b("[available] I/O error : " + localIOException.getMessage());
      throw localIOException;
    }
  }
  
  public void close()
    throws IOException
  {
    try
    {
      this.a.close();
      return;
    }
    catch (IOException localIOException)
    {
      this.b.b("[close] I/O error: " + localIOException.getMessage());
      throw localIOException;
    }
  }
  
  public void mark(int paramInt)
  {
    super.mark(paramInt);
  }
  
  public boolean markSupported()
  {
    return false;
  }
  
  public int read()
    throws IOException
  {
    try
    {
      int i = this.a.read();
      if (i == -1)
      {
        this.b.b("end of stream");
        return i;
      }
      this.b.b(i);
      return i;
    }
    catch (IOException localIOException)
    {
      this.b.b("[read] I/O error: " + localIOException.getMessage());
      throw localIOException;
    }
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    int i;
    try
    {
      i = this.a.read(paramArrayOfByte);
      if (i == -1)
      {
        this.b.b("end of stream");
        return i;
      }
      if (i > 0)
      {
        this.b.b(paramArrayOfByte, 0, i);
        return i;
      }
    }
    catch (IOException paramArrayOfByte)
    {
      this.b.b("[read] I/O error: " + paramArrayOfByte.getMessage());
      throw paramArrayOfByte;
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      paramInt2 = this.a.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt2 == -1)
      {
        this.b.b("end of stream");
        return paramInt2;
      }
      if (paramInt2 > 0)
      {
        this.b.b(paramArrayOfByte, paramInt1, paramInt2);
        return paramInt2;
      }
    }
    catch (IOException paramArrayOfByte)
    {
      this.b.b("[read] I/O error: " + paramArrayOfByte.getMessage());
      throw paramArrayOfByte;
    }
    return paramInt2;
  }
  
  public void reset()
    throws IOException
  {
    super.reset();
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    try
    {
      paramLong = super.skip(paramLong);
      return paramLong;
    }
    catch (IOException localIOException)
    {
      this.b.b("[skip] I/O error: " + localIOException.getMessage());
      throw localIOException;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/c/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */