package cz.msebera.android.httpclient.i.g;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.j.i;
import java.io.IOException;
import java.io.OutputStream;

@NotThreadSafe
public class f
  extends OutputStream
{
  private final i a;
  private final byte[] b;
  private int c = 0;
  private boolean d = false;
  private boolean e = false;
  
  public f(int paramInt, i parami)
  {
    this.b = new byte[paramInt];
    this.a = parami;
  }
  
  @Deprecated
  public f(i parami)
    throws IOException
  {
    this(2048, parami);
  }
  
  @Deprecated
  public f(i parami, int paramInt)
    throws IOException
  {
    this(paramInt, parami);
  }
  
  protected void a()
    throws IOException
  {
    if (this.c > 0)
    {
      this.a.a(Integer.toHexString(this.c));
      this.a.a(this.b, 0, this.c);
      this.a.a("");
      this.c = 0;
    }
  }
  
  protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    this.a.a(Integer.toHexString(this.c + paramInt2));
    this.a.a(this.b, 0, this.c);
    this.a.a(paramArrayOfByte, paramInt1, paramInt2);
    this.a.a("");
    this.c = 0;
  }
  
  protected void b()
    throws IOException
  {
    this.a.a("0");
    this.a.a("");
  }
  
  public void c()
    throws IOException
  {
    if (!this.d)
    {
      a();
      b();
      this.d = true;
    }
  }
  
  public void close()
    throws IOException
  {
    if (!this.e)
    {
      this.e = true;
      c();
      this.a.a();
    }
  }
  
  public void flush()
    throws IOException
  {
    a();
    this.a.a();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    if (this.e) {
      throw new IOException("Attempted write to closed stream.");
    }
    this.b[this.c] = ((byte)paramInt);
    this.c += 1;
    if (this.c == this.b.length) {
      a();
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
    if (this.e) {
      throw new IOException("Attempted write to closed stream.");
    }
    if (paramInt2 >= this.b.length - this.c)
    {
      a(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    System.arraycopy(paramArrayOfByte, paramInt1, this.b, this.c, paramInt2);
    this.c += paramInt2;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/g/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */