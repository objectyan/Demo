package cz.msebera.android.httpclient.e;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.o.a;
import java.io.IOException;
import java.io.InputStream;

@NotThreadSafe
public class m
  extends InputStream
  implements j
{
  protected InputStream a;
  private boolean b;
  private final n c;
  
  public m(InputStream paramInputStream, n paramn)
  {
    a.a(paramInputStream, "Wrapped stream");
    this.a = paramInputStream;
    this.b = false;
    this.c = paramn;
  }
  
  protected void a(int paramInt)
    throws IOException
  {
    boolean bool;
    if ((this.a != null) && (paramInt < 0)) {
      bool = true;
    }
    try
    {
      if (this.c != null) {
        bool = this.c.a(this.a);
      }
      if (bool) {
        this.a.close();
      }
      return;
    }
    finally
    {
      this.a = null;
    }
  }
  
  public int available()
    throws IOException
  {
    int i = 0;
    if (e()) {}
    try
    {
      i = this.a.available();
      return i;
    }
    catch (IOException localIOException)
    {
      g();
      throw localIOException;
    }
  }
  
  public void b()
    throws IOException
  {
    this.b = true;
    g();
  }
  
  boolean c()
  {
    return this.b;
  }
  
  public void close()
    throws IOException
  {
    this.b = true;
    f();
  }
  
  InputStream d()
  {
    return this.a;
  }
  
  protected boolean e()
    throws IOException
  {
    if (this.b) {
      throw new IOException("Attempted read on closed stream.");
    }
    return this.a != null;
  }
  
  protected void f()
    throws IOException
  {
    boolean bool;
    if (this.a != null) {
      bool = true;
    }
    try
    {
      if (this.c != null) {
        bool = this.c.b(this.a);
      }
      if (bool) {
        this.a.close();
      }
      return;
    }
    finally
    {
      this.a = null;
    }
  }
  
  protected void g()
    throws IOException
  {
    boolean bool;
    if (this.a != null) {
      bool = true;
    }
    try
    {
      if (this.c != null) {
        bool = this.c.c(this.a);
      }
      if (bool) {
        this.a.close();
      }
      return;
    }
    finally
    {
      this.a = null;
    }
  }
  
  public void i_()
    throws IOException
  {
    close();
  }
  
  public int read()
    throws IOException
  {
    int i = -1;
    if (e()) {}
    try
    {
      i = this.a.read();
      a(i);
      return i;
    }
    catch (IOException localIOException)
    {
      g();
      throw localIOException;
    }
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = -1;
    if (e()) {}
    try
    {
      i = this.a.read(paramArrayOfByte, paramInt1, paramInt2);
      a(i);
      return i;
    }
    catch (IOException paramArrayOfByte)
    {
      g();
      throw paramArrayOfByte;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/e/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */