package cz.msebera.android.httpclient.i.g;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.j.g;
import cz.msebera.android.httpclient.j.i;
import cz.msebera.android.httpclient.o.b;
import cz.msebera.android.httpclient.o.c;
import cz.msebera.android.httpclient.o.d;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;

@NotThreadSafe
public class y
  implements cz.msebera.android.httpclient.j.a, i
{
  private static final byte[] a = { 13, 10 };
  private final u b;
  private final c c;
  private final int d;
  private final CharsetEncoder e;
  private OutputStream f;
  private ByteBuffer g;
  
  public y(u paramu, int paramInt)
  {
    this(paramu, paramInt, paramInt, null);
  }
  
  public y(u paramu, int paramInt1, int paramInt2, CharsetEncoder paramCharsetEncoder)
  {
    cz.msebera.android.httpclient.o.a.a(paramInt1, "Buffer size");
    cz.msebera.android.httpclient.o.a.a(paramu, "HTTP transport metrcis");
    this.b = paramu;
    this.c = new c(paramInt1);
    if (paramInt2 >= 0) {}
    for (;;)
    {
      this.d = paramInt2;
      this.e = paramCharsetEncoder;
      return;
      paramInt2 = 0;
    }
  }
  
  private void a(CharBuffer paramCharBuffer)
    throws IOException
  {
    if (!paramCharBuffer.hasRemaining()) {
      return;
    }
    if (this.g == null) {
      this.g = ByteBuffer.allocate(1024);
    }
    this.e.reset();
    while (paramCharBuffer.hasRemaining()) {
      a(this.e.encode(paramCharBuffer, this.g, true));
    }
    a(this.e.flush(this.g));
    this.g.clear();
  }
  
  private void a(CoderResult paramCoderResult)
    throws IOException
  {
    if (paramCoderResult.isError()) {
      paramCoderResult.throwException();
    }
    this.g.flip();
    while (this.g.hasRemaining()) {
      a(this.g.get());
    }
    this.g.compact();
  }
  
  private void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    b.a(this.f, "Output stream");
    this.f.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private void d()
    throws IOException
  {
    if (this.f != null) {
      this.f.flush();
    }
  }
  
  private void e()
    throws IOException
  {
    int i = this.c.d();
    if (i > 0)
    {
      b(this.c.e(), 0, i);
      this.c.a();
      this.b.b(i);
    }
  }
  
  public void a()
    throws IOException
  {
    e();
    d();
  }
  
  public void a(int paramInt)
    throws IOException
  {
    if (this.d > 0)
    {
      if (this.c.g()) {
        e();
      }
      this.c.a(paramInt);
      return;
    }
    e();
    this.f.write(paramInt);
  }
  
  public void a(d paramd)
    throws IOException
  {
    if (paramd == null) {
      return;
    }
    if (this.e == null)
    {
      int j = 0;
      int i = paramd.e();
      while (i > 0)
      {
        int k = Math.min(this.c.c() - this.c.d(), i);
        if (k > 0) {
          this.c.a(paramd, j, k);
        }
        if (this.c.g()) {
          e();
        }
        j += k;
        i -= k;
      }
    }
    a(CharBuffer.wrap(paramd.c(), 0, paramd.e()));
    a(a);
  }
  
  public void a(OutputStream paramOutputStream)
  {
    this.f = paramOutputStream;
  }
  
  public void a(String paramString)
    throws IOException
  {
    if (paramString == null) {
      return;
    }
    if (paramString.length() > 0)
    {
      if (this.e == null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          a(paramString.charAt(i));
          i += 1;
        }
      }
      a(CharBuffer.wrap(paramString));
    }
    a(a);
  }
  
  public void a(byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte == null) {
      return;
    }
    a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramArrayOfByte == null) {
      return;
    }
    if ((paramInt2 > this.d) || (paramInt2 > this.c.c()))
    {
      e();
      b(paramArrayOfByte, paramInt1, paramInt2);
      this.b.b(paramInt2);
      return;
    }
    if (paramInt2 > this.c.c() - this.c.d()) {
      e();
    }
    this.c.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public g b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    return this.f != null;
  }
  
  public int f()
  {
    return this.c.c();
  }
  
  public int g()
  {
    return this.c.d();
  }
  
  public int h()
  {
    return f() - g();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/g/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */