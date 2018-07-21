package cz.msebera.android.httpclient.i.c;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import java.io.IOException;
import java.io.OutputStream;

@NotThreadSafe
class aa
  extends OutputStream
{
  private final OutputStream a;
  private final am b;
  
  public aa(OutputStream paramOutputStream, am paramam)
  {
    this.a = paramOutputStream;
    this.b = paramam;
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
      this.b.a("[close] I/O error: " + localIOException.getMessage());
      throw localIOException;
    }
  }
  
  public void flush()
    throws IOException
  {
    try
    {
      this.a.flush();
      return;
    }
    catch (IOException localIOException)
    {
      this.b.a("[flush] I/O error: " + localIOException.getMessage());
      throw localIOException;
    }
  }
  
  public void write(int paramInt)
    throws IOException
  {
    try
    {
      this.b.a(paramInt);
      return;
    }
    catch (IOException localIOException)
    {
      this.b.a("[write] I/O error: " + localIOException.getMessage());
      throw localIOException;
    }
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      this.b.a(paramArrayOfByte);
      this.a.write(paramArrayOfByte);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      this.b.a("[write] I/O error: " + paramArrayOfByte.getMessage());
      throw paramArrayOfByte;
    }
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    try
    {
      this.b.a(paramArrayOfByte, paramInt1, paramInt2);
      this.a.write(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    catch (IOException paramArrayOfByte)
    {
      this.b.a("[write] I/O error: " + paramArrayOfByte.getMessage());
      throw paramArrayOfByte;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/c/aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */