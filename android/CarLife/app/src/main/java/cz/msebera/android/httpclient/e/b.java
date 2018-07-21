package cz.msebera.android.httpclient.e;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.o.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

@Deprecated
@NotThreadSafe
public class b
  extends cz.msebera.android.httpclient.g.j
  implements j, n
{
  protected t a;
  protected final boolean b;
  
  public b(cz.msebera.android.httpclient.n paramn, t paramt, boolean paramBoolean)
  {
    super(paramn);
    a.a(paramt, "Connection");
    this.a = paramt;
    this.b = paramBoolean;
  }
  
  /* Error */
  private void d()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	cz/msebera/android/httpclient/e/b:a	Lcz/msebera/android/httpclient/e/t;
    //   4: ifnonnull +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 30	cz/msebera/android/httpclient/e/b:b	Z
    //   12: ifeq +24 -> 36
    //   15: aload_0
    //   16: getfield 39	cz/msebera/android/httpclient/e/b:wrappedEntity	Lcz/msebera/android/httpclient/n;
    //   19: invokestatic 43	cz/msebera/android/httpclient/o/g:b	(Lcz/msebera/android/httpclient/n;)V
    //   22: aload_0
    //   23: getfield 28	cz/msebera/android/httpclient/e/b:a	Lcz/msebera/android/httpclient/e/t;
    //   26: invokeinterface 48 1 0
    //   31: aload_0
    //   32: invokevirtual 51	cz/msebera/android/httpclient/e/b:c	()V
    //   35: return
    //   36: aload_0
    //   37: getfield 28	cz/msebera/android/httpclient/e/b:a	Lcz/msebera/android/httpclient/e/t;
    //   40: invokeinterface 54 1 0
    //   45: goto -14 -> 31
    //   48: astore_1
    //   49: aload_0
    //   50: invokevirtual 51	cz/msebera/android/httpclient/e/b:c	()V
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	b
    //   48	6	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   8	31	48	finally
    //   36	45	48	finally
  }
  
  /* Error */
  public boolean a(InputStream paramInputStream)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 28	cz/msebera/android/httpclient/e/b:a	Lcz/msebera/android/httpclient/e/t;
    //   4: ifnull +23 -> 27
    //   7: aload_0
    //   8: getfield 30	cz/msebera/android/httpclient/e/b:b	Z
    //   11: ifeq +22 -> 33
    //   14: aload_1
    //   15: invokevirtual 61	java/io/InputStream:close	()V
    //   18: aload_0
    //   19: getfield 28	cz/msebera/android/httpclient/e/b:a	Lcz/msebera/android/httpclient/e/t;
    //   22: invokeinterface 48 1 0
    //   27: aload_0
    //   28: invokevirtual 51	cz/msebera/android/httpclient/e/b:c	()V
    //   31: iconst_0
    //   32: ireturn
    //   33: aload_0
    //   34: getfield 28	cz/msebera/android/httpclient/e/b:a	Lcz/msebera/android/httpclient/e/t;
    //   37: invokeinterface 54 1 0
    //   42: goto -15 -> 27
    //   45: astore_1
    //   46: aload_0
    //   47: invokevirtual 51	cz/msebera/android/httpclient/e/b:c	()V
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	b
    //   0	52	1	paramInputStream	InputStream
    // Exception table:
    //   from	to	target	type
    //   0	27	45	finally
    //   33	42	45	finally
  }
  
  public void b()
    throws IOException
  {
    if (this.a != null) {}
    try
    {
      this.a.b();
      return;
    }
    finally
    {
      this.a = null;
    }
  }
  
  public boolean b(InputStream paramInputStream)
    throws IOException
  {
    for (;;)
    {
      try
      {
        boolean bool;
        if (this.a != null)
        {
          if (this.b) {
            bool = this.a.c();
          }
        }
        else {
          try
          {
            paramInputStream.close();
            this.a.o();
            return false;
          }
          catch (SocketException paramInputStream)
          {
            if (!bool) {
              continue;
            }
            throw paramInputStream;
          }
        }
        this.a.p();
      }
      finally
      {
        c();
      }
    }
  }
  
  protected void c()
    throws IOException
  {
    if (this.a != null) {}
    try
    {
      this.a.i_();
      return;
    }
    finally
    {
      this.a = null;
    }
  }
  
  public boolean c(InputStream paramInputStream)
    throws IOException
  {
    if (this.a != null) {
      this.a.b();
    }
    return false;
  }
  
  @Deprecated
  public void consumeContent()
    throws IOException
  {
    d();
  }
  
  public InputStream getContent()
    throws IOException
  {
    return new m(this.wrappedEntity.getContent(), this);
  }
  
  public void i_()
    throws IOException
  {
    d();
  }
  
  public boolean isRepeatable()
  {
    return false;
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    super.writeTo(paramOutputStream);
    d();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/e/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */