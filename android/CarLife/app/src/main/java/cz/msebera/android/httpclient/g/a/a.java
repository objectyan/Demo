package cz.msebera.android.httpclient.g.a;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;

abstract class a
{
  private static final cz.msebera.android.httpclient.o.c b = a(h.f, ": ");
  private static final cz.msebera.android.httpclient.o.c c = a(h.f, "\r\n");
  private static final cz.msebera.android.httpclient.o.c d = a(h.f, "--");
  protected final Charset a;
  private final String e;
  private final String f;
  
  public a(String paramString1, String paramString2)
  {
    this(paramString1, null, paramString2);
  }
  
  public a(String paramString1, Charset paramCharset, String paramString2)
  {
    cz.msebera.android.httpclient.o.a.a(paramString1, "Multipart subtype");
    cz.msebera.android.httpclient.o.a.a(paramString2, "Multipart boundary");
    this.e = paramString1;
    if (paramCharset != null) {}
    for (;;)
    {
      this.a = paramCharset;
      this.f = paramString2;
      return;
      paramCharset = h.f;
    }
  }
  
  private static cz.msebera.android.httpclient.o.c a(Charset paramCharset, String paramString)
  {
    paramCharset = paramCharset.encode(CharBuffer.wrap(paramString));
    paramString = new cz.msebera.android.httpclient.o.c(paramCharset.remaining());
    paramString.a(paramCharset.array(), paramCharset.position(), paramCharset.remaining());
    return paramString;
  }
  
  protected static void a(i parami, OutputStream paramOutputStream)
    throws IOException
  {
    a(parami.a(), paramOutputStream);
    a(b, paramOutputStream);
    a(parami.b(), paramOutputStream);
    a(c, paramOutputStream);
  }
  
  protected static void a(i parami, Charset paramCharset, OutputStream paramOutputStream)
    throws IOException
  {
    a(parami.a(), paramCharset, paramOutputStream);
    a(b, paramOutputStream);
    a(parami.b(), paramCharset, paramOutputStream);
    a(c, paramOutputStream);
  }
  
  private static void a(cz.msebera.android.httpclient.o.c paramc, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream.write(paramc.e(), 0, paramc.d());
  }
  
  private static void a(String paramString, OutputStream paramOutputStream)
    throws IOException
  {
    a(a(h.f, paramString), paramOutputStream);
  }
  
  private static void a(String paramString, Charset paramCharset, OutputStream paramOutputStream)
    throws IOException
  {
    a(a(paramCharset, paramString), paramOutputStream);
  }
  
  public String a()
  {
    return this.e;
  }
  
  protected abstract void a(b paramb, OutputStream paramOutputStream)
    throws IOException;
  
  public void a(OutputStream paramOutputStream)
    throws IOException
  {
    a(paramOutputStream, true);
  }
  
  void a(OutputStream paramOutputStream, boolean paramBoolean)
    throws IOException
  {
    cz.msebera.android.httpclient.o.c localc = a(this.a, d());
    Iterator localIterator = c().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      a(d, paramOutputStream);
      a(localc, paramOutputStream);
      a(c, paramOutputStream);
      a(localb, paramOutputStream);
      a(c, paramOutputStream);
      if (paramBoolean) {
        localb.b().a(paramOutputStream);
      }
      a(c, paramOutputStream);
    }
    a(d, paramOutputStream);
    a(localc, paramOutputStream);
    a(d, paramOutputStream);
    a(c, paramOutputStream);
  }
  
  public Charset b()
  {
    return this.a;
  }
  
  public abstract List<b> c();
  
  public String d()
  {
    return this.f;
  }
  
  public long e()
  {
    long l3 = -1L;
    long l1 = 0L;
    Object localObject = c().iterator();
    long l2;
    while (((Iterator)localObject).hasNext())
    {
      long l4 = ((b)((Iterator)localObject).next()).b().h();
      l2 = l3;
      if (l4 < 0L) {
        break label96;
      }
      l1 += l4;
    }
    localObject = new ByteArrayOutputStream();
    try
    {
      a((OutputStream)localObject, false);
      int i = ((ByteArrayOutputStream)localObject).toByteArray().length;
      l2 = i + l1;
      label96:
      return l2;
    }
    catch (IOException localIOException) {}
    return -1L;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/g/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */