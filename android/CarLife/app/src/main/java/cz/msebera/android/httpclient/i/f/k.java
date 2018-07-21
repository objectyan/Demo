package cz.msebera.android.httpclient.i.f;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.e.m;
import cz.msebera.android.httpclient.g.j;
import cz.msebera.android.httpclient.x;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@NotThreadSafe
class k
  extends j
  implements cz.msebera.android.httpclient.e.n
{
  private final c a;
  
  k(cz.msebera.android.httpclient.n paramn, c paramc)
  {
    super(paramn);
    this.a = paramc;
  }
  
  public static void a(x paramx, c paramc)
  {
    cz.msebera.android.httpclient.n localn = paramx.b();
    if ((localn != null) && (localn.isStreaming()) && (paramc != null)) {
      paramx.a(new k(localn, paramc));
    }
  }
  
  private void b()
  {
    if (this.a != null) {
      this.a.b();
    }
  }
  
  public void a()
    throws IOException
  {
    if (this.a != null) {}
    try
    {
      if (this.a.c()) {
        this.a.i_();
      }
      return;
    }
    finally
    {
      b();
    }
  }
  
  public boolean a(InputStream paramInputStream)
    throws IOException
  {
    try
    {
      paramInputStream.close();
      a();
      return false;
    }
    finally
    {
      b();
    }
  }
  
  /* Error */
  public boolean b(InputStream paramInputStream)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 16	cz/msebera/android/httpclient/i/f/k:a	Lcz/msebera/android/httpclient/i/f/c;
    //   4: ifnull +31 -> 35
    //   7: aload_0
    //   8: getfield 16	cz/msebera/android/httpclient/i/f/k:a	Lcz/msebera/android/httpclient/i/f/c;
    //   11: invokevirtual 62	cz/msebera/android/httpclient/i/f/c:f	()Z
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +19 -> 35
    //   19: iconst_1
    //   20: istore_2
    //   21: aload_1
    //   22: invokevirtual 55	java/io/InputStream:close	()V
    //   25: aload_0
    //   26: invokevirtual 57	cz/msebera/android/httpclient/i/f/k:a	()V
    //   29: aload_0
    //   30: invokespecial 48	cz/msebera/android/httpclient/i/f/k:b	()V
    //   33: iconst_0
    //   34: ireturn
    //   35: iconst_0
    //   36: istore_2
    //   37: goto -16 -> 21
    //   40: astore_1
    //   41: iload_2
    //   42: ifeq -13 -> 29
    //   45: aload_1
    //   46: athrow
    //   47: astore_1
    //   48: aload_0
    //   49: invokespecial 48	cz/msebera/android/httpclient/i/f/k:b	()V
    //   52: aload_1
    //   53: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	54	0	this	k
    //   0	54	1	paramInputStream	InputStream
    //   20	22	2	i	int
    //   14	2	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   21	29	40	java/net/SocketException
    //   0	15	47	finally
    //   21	29	47	finally
    //   45	47	47	finally
  }
  
  public boolean c(InputStream paramInputStream)
    throws IOException
  {
    b();
    return false;
  }
  
  @Deprecated
  public void consumeContent()
    throws IOException
  {
    a();
  }
  
  public InputStream getContent()
    throws IOException
  {
    return new m(this.wrappedEntity.getContent(), this);
  }
  
  public boolean isRepeatable()
  {
    return false;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("ResponseEntityProxy{");
    localStringBuilder.append(this.wrappedEntity);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    try
    {
      this.wrappedEntity.writeTo(paramOutputStream);
      a();
      return;
    }
    finally
    {
      b();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/f/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */