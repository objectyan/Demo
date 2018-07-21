package cz.msebera.android.httpclient.i.a;

import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;

class g
  extends OutputStream
{
  private final MessageDigest a;
  private boolean b;
  private byte[] c;
  
  g(MessageDigest paramMessageDigest)
  {
    this.a = paramMessageDigest;
    this.a.reset();
  }
  
  public byte[] a()
  {
    return this.c;
  }
  
  public void close()
    throws IOException
  {
    if (this.b) {
      return;
    }
    this.b = true;
    this.c = this.a.digest();
    super.close();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    if (this.b) {
      throw new IOException("Stream has been already closed");
    }
    this.a.update((byte)paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (this.b) {
      throw new IOException("Stream has been already closed");
    }
    this.a.update(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */