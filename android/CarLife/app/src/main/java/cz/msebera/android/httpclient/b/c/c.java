package cz.msebera.android.httpclient.b.c;

import java.io.IOException;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

public class c
  extends InputStream
{
  private InputStream a;
  
  public c(InputStream paramInputStream)
    throws IOException
  {
    byte[] arrayOfByte1 = new byte[6];
    PushbackInputStream localPushbackInputStream = new PushbackInputStream(paramInputStream, arrayOfByte1.length);
    int i = localPushbackInputStream.read(arrayOfByte1);
    if (i == -1) {
      throw new IOException("Unable to read the response");
    }
    byte[] arrayOfByte3 = new byte[1];
    paramInputStream = new Inflater();
    for (;;)
    {
      try
      {
        j = paramInputStream.inflate(arrayOfByte3);
        if (j == 0) {
          if (paramInputStream.finished()) {
            throw new IOException("Unable to read the response");
          }
        }
      }
      catch (DataFormatException localDataFormatException)
      {
        int j;
        localPushbackInputStream.unread(arrayOfByte1, 0, i);
        this.a = new a(localPushbackInputStream, new Inflater(true));
        return;
        if (paramInputStream.needsDictionary())
        {
          if (j != -1) {
            break;
          }
          throw new IOException("Unable to read the response");
        }
      }
      finally
      {
        paramInputStream.end();
      }
      if (paramInputStream.needsInput()) {
        paramInputStream.setInput(arrayOfByte2);
      }
    }
    localPushbackInputStream.unread(arrayOfByte2, 0, i);
    this.a = new a(localPushbackInputStream, new Inflater());
    paramInputStream.end();
  }
  
  public int available()
    throws IOException
  {
    return this.a.available();
  }
  
  public void close()
    throws IOException
  {
    this.a.close();
  }
  
  public void mark(int paramInt)
  {
    this.a.mark(paramInt);
  }
  
  public boolean markSupported()
  {
    return this.a.markSupported();
  }
  
  public int read()
    throws IOException
  {
    return this.a.read();
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return this.a.read(paramArrayOfByte);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return this.a.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void reset()
    throws IOException
  {
    this.a.reset();
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    return this.a.skip(paramLong);
  }
  
  static class a
    extends InflaterInputStream
  {
    private boolean a = false;
    
    public a(InputStream paramInputStream, Inflater paramInflater)
    {
      super(paramInflater);
    }
    
    public void close()
      throws IOException
    {
      if (this.a) {
        return;
      }
      this.a = true;
      this.inf.end();
      super.close();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/c/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */