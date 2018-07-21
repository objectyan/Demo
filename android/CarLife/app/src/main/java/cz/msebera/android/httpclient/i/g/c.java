package cz.msebera.android.httpclient.i.g;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.j.g;
import cz.msebera.android.httpclient.j.h;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.o.d;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

@Deprecated
@NotThreadSafe
public abstract class c
  implements cz.msebera.android.httpclient.j.a, h
{
  private InputStream a;
  private byte[] b;
  private cz.msebera.android.httpclient.o.c c;
  private Charset d;
  private boolean e;
  private int f;
  private int g;
  private u h;
  private CodingErrorAction i;
  private CodingErrorAction j;
  private int k;
  private int l;
  private CharsetDecoder m;
  private CharBuffer n;
  
  private int a(d paramd, int paramInt)
    throws IOException
  {
    int i2 = this.k;
    this.k = (paramInt + 1);
    int i1 = paramInt;
    if (paramInt > i2)
    {
      i1 = paramInt;
      if (this.b[(paramInt - 1)] == 13) {
        i1 = paramInt - 1;
      }
    }
    paramInt = i1 - i2;
    if (this.e)
    {
      paramd.a(this.b, i2, paramInt);
      return paramInt;
    }
    return a(paramd, ByteBuffer.wrap(this.b, i2, paramInt));
  }
  
  private int a(d paramd, ByteBuffer paramByteBuffer)
    throws IOException
  {
    if (!paramByteBuffer.hasRemaining()) {
      return 0;
    }
    if (this.m == null)
    {
      this.m = this.d.newDecoder();
      this.m.onMalformedInput(this.i);
      this.m.onUnmappableCharacter(this.j);
    }
    if (this.n == null) {
      this.n = CharBuffer.allocate(1024);
    }
    this.m.reset();
    int i1 = 0;
    while (paramByteBuffer.hasRemaining()) {
      i1 += a(this.m.decode(paramByteBuffer, this.n, true), paramd, paramByteBuffer);
    }
    int i2 = a(this.m.flush(this.n), paramd, paramByteBuffer);
    this.n.clear();
    return i1 + i2;
  }
  
  private int a(CoderResult paramCoderResult, d paramd, ByteBuffer paramByteBuffer)
    throws IOException
  {
    if (paramCoderResult.isError()) {
      paramCoderResult.throwException();
    }
    this.n.flip();
    int i1 = this.n.remaining();
    while (this.n.hasRemaining()) {
      paramd.a(this.n.get());
    }
    this.n.compact();
    return i1;
  }
  
  private int b(d paramd)
    throws IOException
  {
    int i3 = this.c.d();
    int i1 = i3;
    if (i3 > 0)
    {
      int i2 = i3;
      if (this.c.b(i3 - 1) == 10) {
        i2 = i3 - 1;
      }
      i1 = i2;
      if (i2 > 0)
      {
        i1 = i2;
        if (this.c.b(i2 - 1) == 13) {
          i1 = i2 - 1;
        }
      }
    }
    if (this.e) {
      paramd.a(this.c, 0, i1);
    }
    for (;;)
    {
      this.c.a();
      return i1;
      i1 = a(paramd, ByteBuffer.wrap(this.c.e(), 0, i1));
    }
  }
  
  private int d()
  {
    int i1 = this.k;
    while (i1 < this.l)
    {
      if (this.b[i1] == 10) {
        return i1;
      }
      i1 += 1;
    }
    return -1;
  }
  
  public int a()
    throws IOException
  {
    while (!j()) {
      if (i() == -1) {
        return -1;
      }
    }
    byte[] arrayOfByte = this.b;
    int i1 = this.k;
    this.k = (i1 + 1);
    return arrayOfByte[i1] & 0xFF;
  }
  
  public int a(d paramd)
    throws IOException
  {
    int i5 = -1;
    cz.msebera.android.httpclient.o.a.a(paramd, "Char array buffer");
    int i3 = 0;
    int i2 = 1;
    int i4;
    int i1;
    if (i2 != 0)
    {
      i4 = d();
      if (i4 != -1) {
        if (this.c.f()) {
          i1 = a(paramd, i4);
        }
      }
    }
    do
    {
      return i1;
      i1 = 0;
      i2 = this.k;
      this.c.a(this.b, this.k, i4 + 1 - i2);
      this.k = (i4 + 1);
      i4 = i3;
      for (;;)
      {
        i3 = i4;
        i2 = i1;
        if (this.f <= 0) {
          break;
        }
        i3 = i4;
        i2 = i1;
        if (this.c.d() < this.f) {
          break;
        }
        throw new IOException("Maximum line length limit exceeded");
        if (j())
        {
          i1 = this.l;
          i3 = this.k;
          this.c.a(this.b, this.k, i1 - i3);
          this.k = this.l;
        }
        i3 = i();
        i4 = i3;
        i1 = i2;
        if (i3 == -1)
        {
          i1 = 0;
          i4 = i3;
        }
      }
      if (i3 != -1) {
        break label225;
      }
      i1 = i5;
    } while (this.c.f());
    label225:
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
    if (j())
    {
      paramInt2 = Math.min(paramInt2, this.l - this.k);
      System.arraycopy(this.b, this.k, paramArrayOfByte, paramInt1, paramInt2);
      this.k += paramInt2;
      return paramInt2;
    }
    if (paramInt2 > this.g)
    {
      paramInt1 = this.a.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 > 0) {
        this.h.b(paramInt1);
      }
      return paramInt1;
    }
    while (!j()) {
      if (i() == -1) {
        return -1;
      }
    }
    paramInt2 = Math.min(paramInt2, this.l - this.k);
    System.arraycopy(this.b, this.k, paramArrayOfByte, paramInt1, paramInt2);
    this.k += paramInt2;
    return paramInt2;
  }
  
  protected void a(InputStream paramInputStream, int paramInt, j paramj)
  {
    cz.msebera.android.httpclient.o.a.a(paramInputStream, "Input stream");
    cz.msebera.android.httpclient.o.a.b(paramInt, "Buffer size");
    cz.msebera.android.httpclient.o.a.a(paramj, "HTTP parameters");
    this.a = paramInputStream;
    this.b = new byte[paramInt];
    this.k = 0;
    this.l = 0;
    this.c = new cz.msebera.android.httpclient.o.c(paramInt);
    paramInputStream = (String)paramj.a("http.protocol.element-charset");
    if (paramInputStream != null)
    {
      paramInputStream = Charset.forName(paramInputStream);
      this.d = paramInputStream;
      this.e = this.d.equals(cz.msebera.android.httpclient.c.f);
      this.m = null;
      this.f = paramj.a("http.connection.max-line-length", -1);
      this.g = paramj.a("http.connection.min-chunk-limit", 512);
      this.h = e();
      paramInputStream = (CodingErrorAction)paramj.a("http.malformed.input.action");
      if (paramInputStream == null) {
        break label190;
      }
      label155:
      this.i = paramInputStream;
      paramInputStream = (CodingErrorAction)paramj.a("http.unmappable.input.action");
      if (paramInputStream == null) {
        break label197;
      }
    }
    for (;;)
    {
      this.j = paramInputStream;
      return;
      paramInputStream = cz.msebera.android.httpclient.c.f;
      break;
      label190:
      paramInputStream = CodingErrorAction.REPORT;
      break label155;
      label197:
      paramInputStream = CodingErrorAction.REPORT;
    }
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
    return this.h;
  }
  
  protected u e()
  {
    return new u();
  }
  
  public int f()
  {
    return this.b.length;
  }
  
  public int g()
  {
    return this.l - this.k;
  }
  
  public int h()
  {
    return f() - g();
  }
  
  protected int i()
    throws IOException
  {
    if (this.k > 0)
    {
      i1 = this.l - this.k;
      if (i1 > 0) {
        System.arraycopy(this.b, this.k, this.b, 0, i1);
      }
      this.k = 0;
      this.l = i1;
    }
    int i1 = this.l;
    int i2 = this.b.length;
    i2 = this.a.read(this.b, i1, i2 - i1);
    if (i2 == -1) {
      return -1;
    }
    this.l = (i1 + i2);
    this.h.b(i2);
    return i2;
  }
  
  protected boolean j()
  {
    return this.k < this.l;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/g/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */