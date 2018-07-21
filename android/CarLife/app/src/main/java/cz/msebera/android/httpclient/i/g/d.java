package cz.msebera.android.httpclient.i.g;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.j.g;
import cz.msebera.android.httpclient.j.i;
import cz.msebera.android.httpclient.l.j;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;

@Deprecated
@NotThreadSafe
public abstract class d
  implements cz.msebera.android.httpclient.j.a, i
{
  private static final byte[] a = { 13, 10 };
  private OutputStream b;
  private cz.msebera.android.httpclient.o.c c;
  private Charset d;
  private boolean e;
  private int f;
  private u g;
  private CodingErrorAction h;
  private CodingErrorAction i;
  private CharsetEncoder j;
  private ByteBuffer k;
  
  public d() {}
  
  protected d(OutputStream paramOutputStream, int paramInt1, Charset paramCharset, int paramInt2, CodingErrorAction paramCodingErrorAction1, CodingErrorAction paramCodingErrorAction2)
  {
    cz.msebera.android.httpclient.o.a.a(paramOutputStream, "Input stream");
    cz.msebera.android.httpclient.o.a.b(paramInt1, "Buffer size");
    this.b = paramOutputStream;
    this.c = new cz.msebera.android.httpclient.o.c(paramInt1);
    if (paramCharset != null)
    {
      this.d = paramCharset;
      this.e = this.d.equals(cz.msebera.android.httpclient.c.f);
      this.j = null;
      if (paramInt2 < 0) {
        break label112;
      }
      label68:
      this.f = paramInt2;
      this.g = c();
      if (paramCodingErrorAction1 == null) {
        break label120;
      }
      label87:
      this.h = paramCodingErrorAction1;
      if (paramCodingErrorAction2 == null) {
        break label128;
      }
    }
    for (;;)
    {
      this.i = paramCodingErrorAction2;
      return;
      paramCharset = cz.msebera.android.httpclient.c.f;
      break;
      label112:
      paramInt2 = 512;
      break label68;
      label120:
      paramCodingErrorAction1 = CodingErrorAction.REPORT;
      break label87;
      label128:
      paramCodingErrorAction2 = CodingErrorAction.REPORT;
    }
  }
  
  private void a(CharBuffer paramCharBuffer)
    throws IOException
  {
    if (!paramCharBuffer.hasRemaining()) {
      return;
    }
    if (this.j == null)
    {
      this.j = this.d.newEncoder();
      this.j.onMalformedInput(this.h);
      this.j.onUnmappableCharacter(this.i);
    }
    if (this.k == null) {
      this.k = ByteBuffer.allocate(1024);
    }
    this.j.reset();
    while (paramCharBuffer.hasRemaining()) {
      a(this.j.encode(paramCharBuffer, this.k, true));
    }
    a(this.j.flush(this.k));
    this.k.clear();
  }
  
  private void a(CoderResult paramCoderResult)
    throws IOException
  {
    if (paramCoderResult.isError()) {
      paramCoderResult.throwException();
    }
    this.k.flip();
    while (this.k.hasRemaining()) {
      a(this.k.get());
    }
    this.k.compact();
  }
  
  public void a()
    throws IOException
  {
    d();
    this.b.flush();
  }
  
  public void a(int paramInt)
    throws IOException
  {
    if (this.c.g()) {
      d();
    }
    this.c.a(paramInt);
  }
  
  public void a(cz.msebera.android.httpclient.o.d paramd)
    throws IOException
  {
    if (paramd == null) {
      return;
    }
    if (this.e)
    {
      int n = 0;
      int m = paramd.e();
      while (m > 0)
      {
        int i1 = Math.min(this.c.c() - this.c.d(), m);
        if (i1 > 0) {
          this.c.a(paramd, n, i1);
        }
        if (this.c.g()) {
          d();
        }
        n += i1;
        m -= i1;
      }
    }
    a(CharBuffer.wrap(paramd.c(), 0, paramd.e()));
    a(a);
  }
  
  protected void a(OutputStream paramOutputStream, int paramInt, j paramj)
  {
    cz.msebera.android.httpclient.o.a.a(paramOutputStream, "Input stream");
    cz.msebera.android.httpclient.o.a.b(paramInt, "Buffer size");
    cz.msebera.android.httpclient.o.a.a(paramj, "HTTP parameters");
    this.b = paramOutputStream;
    this.c = new cz.msebera.android.httpclient.o.c(paramInt);
    paramOutputStream = (String)paramj.a("http.protocol.element-charset");
    if (paramOutputStream != null)
    {
      paramOutputStream = Charset.forName(paramOutputStream);
      this.d = paramOutputStream;
      this.e = this.d.equals(cz.msebera.android.httpclient.c.f);
      this.j = null;
      this.f = paramj.a("http.connection.min-chunk-limit", 512);
      this.g = c();
      paramOutputStream = (CodingErrorAction)paramj.a("http.malformed.input.action");
      if (paramOutputStream == null) {
        break label156;
      }
      label122:
      this.h = paramOutputStream;
      paramOutputStream = (CodingErrorAction)paramj.a("http.unmappable.input.action");
      if (paramOutputStream == null) {
        break label163;
      }
    }
    for (;;)
    {
      this.i = paramOutputStream;
      return;
      paramOutputStream = cz.msebera.android.httpclient.c.f;
      break;
      label156:
      paramOutputStream = CodingErrorAction.REPORT;
      break label122;
      label163:
      paramOutputStream = CodingErrorAction.REPORT;
    }
  }
  
  public void a(String paramString)
    throws IOException
  {
    if (paramString == null) {
      return;
    }
    if (paramString.length() > 0)
    {
      if (this.e)
      {
        int m = 0;
        while (m < paramString.length())
        {
          a(paramString.charAt(m));
          m += 1;
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
    if ((paramInt2 > this.f) || (paramInt2 > this.c.c()))
    {
      d();
      this.b.write(paramArrayOfByte, paramInt1, paramInt2);
      this.g.b(paramInt2);
      return;
    }
    if (paramInt2 > this.c.c() - this.c.d()) {
      d();
    }
    this.c.a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public g b()
  {
    return this.g;
  }
  
  protected u c()
  {
    return new u();
  }
  
  protected void d()
    throws IOException
  {
    int m = this.c.d();
    if (m > 0)
    {
      this.b.write(this.c.e(), 0, m);
      this.c.a();
      this.g.b(m);
    }
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/g/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */