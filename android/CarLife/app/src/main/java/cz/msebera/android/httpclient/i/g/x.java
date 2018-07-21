package cz.msebera.android.httpclient.i.g;

import cz.msebera.android.httpclient.ae;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.j.g;
import cz.msebera.android.httpclient.j.h;
import cz.msebera.android.httpclient.o.b;
import cz.msebera.android.httpclient.o.d;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;

@NotThreadSafe
public class x
  implements cz.msebera.android.httpclient.j.a, h
{
  private final u a;
  private final byte[] b;
  private final cz.msebera.android.httpclient.o.c c;
  private final int d;
  private final cz.msebera.android.httpclient.d.c e;
  private final CharsetDecoder f;
  private InputStream g;
  private int h;
  private int i;
  private CharBuffer j;
  
  public x(u paramu, int paramInt)
  {
    this(paramu, paramInt, paramInt, null, null);
  }
  
  public x(u paramu, int paramInt1, int paramInt2, cz.msebera.android.httpclient.d.c paramc, CharsetDecoder paramCharsetDecoder)
  {
    cz.msebera.android.httpclient.o.a.a(paramu, "HTTP transport metrcis");
    cz.msebera.android.httpclient.o.a.a(paramInt1, "Buffer size");
    this.a = paramu;
    this.b = new byte[paramInt1];
    this.h = 0;
    this.i = 0;
    if (paramInt2 >= 0)
    {
      this.d = paramInt2;
      if (paramc == null) {
        break label86;
      }
    }
    for (;;)
    {
      this.e = paramc;
      this.c = new cz.msebera.android.httpclient.o.c(paramInt1);
      this.f = paramCharsetDecoder;
      return;
      paramInt2 = 512;
      break;
      label86:
      paramc = cz.msebera.android.httpclient.d.c.a;
    }
  }
  
  private int a(d paramd, int paramInt)
    throws IOException
  {
    int m = this.h;
    this.h = (paramInt + 1);
    int k = paramInt;
    if (paramInt > m)
    {
      k = paramInt;
      if (this.b[(paramInt - 1)] == 13) {
        k = paramInt - 1;
      }
    }
    paramInt = k - m;
    if (this.f == null)
    {
      paramd.a(this.b, m, paramInt);
      return paramInt;
    }
    return a(paramd, ByteBuffer.wrap(this.b, m, paramInt));
  }
  
  private int a(d paramd, ByteBuffer paramByteBuffer)
    throws IOException
  {
    if (!paramByteBuffer.hasRemaining()) {
      return 0;
    }
    if (this.j == null) {
      this.j = CharBuffer.allocate(1024);
    }
    this.f.reset();
    int k = 0;
    while (paramByteBuffer.hasRemaining()) {
      k += a(this.f.decode(paramByteBuffer, this.j, true), paramd, paramByteBuffer);
    }
    int m = a(this.f.flush(this.j), paramd, paramByteBuffer);
    this.j.clear();
    return k + m;
  }
  
  private int a(CoderResult paramCoderResult, d paramd, ByteBuffer paramByteBuffer)
    throws IOException
  {
    if (paramCoderResult.isError()) {
      paramCoderResult.throwException();
    }
    this.j.flip();
    int k = this.j.remaining();
    while (this.j.hasRemaining()) {
      paramd.a(this.j.get());
    }
    this.j.compact();
    return k;
  }
  
  private int b(d paramd)
    throws IOException
  {
    int n = this.c.d();
    int k = n;
    if (n > 0)
    {
      int m = n;
      if (this.c.b(n - 1) == 10) {
        m = n - 1;
      }
      k = m;
      if (m > 0)
      {
        k = m;
        if (this.c.b(m - 1) == 13) {
          k = m - 1;
        }
      }
    }
    if (this.f == null) {
      paramd.a(this.c, 0, k);
    }
    for (;;)
    {
      this.c.a();
      return k;
      k = a(paramd, ByteBuffer.wrap(this.c.e(), 0, k));
    }
  }
  
  private int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    b.a(this.g, "Input stream");
    return this.g.read(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  private int k()
  {
    int k = this.h;
    while (k < this.i)
    {
      if (this.b[k] == 10) {
        return k;
      }
      k += 1;
    }
    return -1;
  }
  
  public int a()
    throws IOException
  {
    while (!i()) {
      if (e() == -1) {
        return -1;
      }
    }
    byte[] arrayOfByte = this.b;
    int k = this.h;
    this.h = (k + 1);
    return arrayOfByte[k] & 0xFF;
  }
  
  public int a(d paramd)
    throws IOException
  {
    int i2 = -1;
    cz.msebera.android.httpclient.o.a.a(paramd, "Char array buffer");
    int n = 0;
    int m = 1;
    int i1;
    int k;
    if (m != 0)
    {
      i1 = k();
      if (i1 != -1) {
        if (this.c.f()) {
          k = a(paramd, i1);
        }
      }
    }
    do
    {
      return k;
      k = 0;
      m = this.h;
      this.c.a(this.b, this.h, i1 + 1 - m);
      this.h = (i1 + 1);
      i1 = n;
      for (;;)
      {
        int i3 = this.e.a();
        n = i1;
        m = k;
        if (i3 <= 0) {
          break;
        }
        n = i1;
        m = k;
        if (this.c.d() < i3) {
          break;
        }
        throw new ae("Maximum line length limit exceeded");
        if (i())
        {
          k = this.i;
          n = this.h;
          this.c.a(this.b, this.h, k - n);
          this.h = this.i;
        }
        n = e();
        i1 = n;
        k = m;
        if (n == -1)
        {
          k = 0;
          i1 = n;
        }
      }
      if (n != -1) {
        break label230;
      }
      k = i2;
    } while (this.c.f());
    label230:
    return b(paramd);
  }
  
  public int a(byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramArrayOfByte == null) {
      return 0;
    }
    return a(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if (paramArrayOfByte == null) {
      return 0;
    }
    if (i())
    {
      paramInt2 = Math.min(paramInt2, this.i - this.h);
      System.arraycopy(this.b, this.h, paramArrayOfByte, paramInt1, paramInt2);
      this.h += paramInt2;
      return paramInt2;
    }
    if (paramInt2 > this.d)
    {
      paramInt1 = b(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 > 0) {
        this.a.b(paramInt1);
      }
      return paramInt1;
    }
    while (!i()) {
      if (e() == -1) {
        return -1;
      }
    }
    paramInt2 = Math.min(paramInt2, this.i - this.h);
    System.arraycopy(this.b, this.h, paramArrayOfByte, paramInt1, paramInt2);
    this.h += paramInt2;
    return paramInt2;
  }
  
  public void a(InputStream paramInputStream)
  {
    this.g = paramInputStream;
  }
  
  public boolean a(int paramInt)
    throws IOException
  {
    return i();
  }
  
  public String b()
    throws IOException
  {
    d locald = new d(64);
    if (a(locald) != -1) {
      return locald.toString();
    }
    return null;
  }
  
  public g c()
  {
    return this.a;
  }
  
  public boolean d()
  {
    return this.g != null;
  }
  
  public int e()
    throws IOException
  {
    if (this.h > 0)
    {
      k = this.i - this.h;
      if (k > 0) {
        System.arraycopy(this.b, this.h, this.b, 0, k);
      }
      this.h = 0;
      this.i = k;
    }
    int k = this.i;
    int m = this.b.length;
    m = b(this.b, k, m - k);
    if (m == -1) {
      return -1;
    }
    this.i = (k + m);
    this.a.b(m);
    return m;
  }
  
  public int f()
  {
    return this.b.length;
  }
  
  public int g()
  {
    return this.i - this.h;
  }
  
  public int h()
  {
    return f() - g();
  }
  
  public boolean i()
  {
    return this.h < this.i;
  }
  
  public void j()
  {
    this.h = 0;
    this.i = 0;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/g/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */