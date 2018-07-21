package b;

import b.a.a.b;
import b.a.a.d;
import b.a.a.d.a;
import b.a.a.d.c;
import b.a.d.k;
import b.a.g.a;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ForwardingSink;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class c
  implements Closeable, Flushable
{
  private static final int e = 201105;
  private static final int f = 0;
  private static final int g = 1;
  private static final int h = 2;
  final b.a.a.f a = new b.a.a.f()
  {
    public b a(ad paramAnonymousad)
      throws IOException
    {
      return c.this.a(paramAnonymousad);
    }
    
    public ad a(ab paramAnonymousab)
      throws IOException
    {
      return c.this.a(paramAnonymousab);
    }
    
    public void a()
    {
      c.this.k();
    }
    
    public void a(b.a.a.c paramAnonymousc)
    {
      c.this.a(paramAnonymousc);
    }
    
    public void a(ad paramAnonymousad1, ad paramAnonymousad2)
    {
      c.this.a(paramAnonymousad1, paramAnonymousad2);
    }
    
    public void b(ab paramAnonymousab)
      throws IOException
    {
      c.this.b(paramAnonymousab);
    }
  };
  final d b;
  int c;
  int d;
  private int i;
  private int j;
  private int k;
  
  public c(File paramFile, long paramLong)
  {
    this(paramFile, paramLong, a.a);
  }
  
  c(File paramFile, long paramLong, a parama)
  {
    this.b = d.a(parama, paramFile, 201105, 2, paramLong);
  }
  
  static int a(BufferedSource paramBufferedSource)
    throws IOException
  {
    long l;
    try
    {
      l = paramBufferedSource.readDecimalLong();
      paramBufferedSource = paramBufferedSource.readUtf8LineStrict();
      if ((l < 0L) || (l > 2147483647L) || (!paramBufferedSource.isEmpty())) {
        throw new IOException("expected an int but was \"" + l + paramBufferedSource + "\"");
      }
    }
    catch (NumberFormatException paramBufferedSource)
    {
      throw new IOException(paramBufferedSource.getMessage());
    }
    return (int)l;
  }
  
  public static String a(u paramu)
  {
    return ByteString.encodeUtf8(paramu.toString()).md5().hex();
  }
  
  private void a(d.a parama)
  {
    if (parama != null) {}
    try
    {
      parama.c();
      return;
    }
    catch (IOException parama) {}
  }
  
  b a(ad paramad)
  {
    Object localObject = paramad.a().b();
    if (b.a.d.f.a(paramad.a().b())) {}
    for (;;)
    {
      try
      {
        b(paramad.a());
        return null;
      }
      catch (IOException paramad) {}
      if ((((String)localObject).equals("GET")) && (!b.a.d.e.b(paramad)))
      {
        c localc = new c(paramad);
        localObject = null;
        try
        {
          paramad = this.b.b(a(paramad.a().a()));
          if (paramad != null)
          {
            localObject = paramad;
            localc.a(paramad);
            localObject = paramad;
            paramad = new a(paramad);
            return paramad;
          }
        }
        catch (IOException paramad)
        {
          a((d.a)localObject);
          return null;
        }
      }
    }
    return null;
  }
  
  ad a(ab paramab)
  {
    Object localObject = a(paramab.a());
    for (;;)
    {
      try
      {
        localObject = this.b.a((String)localObject);
        if (localObject == null)
        {
          localObject = null;
          return (ad)localObject;
        }
      }
      catch (IOException paramab)
      {
        return null;
      }
      try
      {
        c localc = new c(((d.c)localObject).a(0));
        ad localad = localc.a((d.c)localObject);
        localObject = localad;
        if (!localc.a(paramab, localad))
        {
          b.a.c.a(localad.h());
          return null;
        }
      }
      catch (IOException paramab)
      {
        b.a.c.a((Closeable)localObject);
      }
    }
    return null;
  }
  
  public void a()
    throws IOException
  {
    this.b.a();
  }
  
  /* Error */
  void a(b.a.a.c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 212	b/c:k	I
    //   7: iconst_1
    //   8: iadd
    //   9: putfield 212	b/c:k	I
    //   12: aload_1
    //   13: getfield 217	b/a/a/c:a	Lb/ab;
    //   16: ifnull +16 -> 32
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 219	b/c:i	I
    //   24: iconst_1
    //   25: iadd
    //   26: putfield 219	b/c:i	I
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_1
    //   33: getfield 222	b/a/a/c:b	Lb/ad;
    //   36: ifnull -7 -> 29
    //   39: aload_0
    //   40: aload_0
    //   41: getfield 224	b/c:j	I
    //   44: iconst_1
    //   45: iadd
    //   46: putfield 224	b/c:j	I
    //   49: goto -20 -> 29
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	c
    //   0	57	1	paramc	b.a.a.c
    // Exception table:
    //   from	to	target	type
    //   2	29	52	finally
    //   32	49	52	finally
  }
  
  void a(ad paramad1, ad paramad2)
  {
    c localc = new c(paramad2);
    paramad2 = ((b)paramad1.h()).a;
    paramad1 = null;
    try
    {
      paramad2 = paramad2.b();
      if (paramad2 != null)
      {
        paramad1 = paramad2;
        localc.a(paramad2);
        paramad1 = paramad2;
        paramad2.b();
      }
      return;
    }
    catch (IOException paramad2)
    {
      a(paramad1);
    }
  }
  
  public void b()
    throws IOException
  {
    this.b.i();
  }
  
  void b(ab paramab)
    throws IOException
  {
    this.b.c(a(paramab.a()));
  }
  
  public void c()
    throws IOException
  {
    this.b.j();
  }
  
  public void close()
    throws IOException
  {
    this.b.close();
  }
  
  public Iterator<String> d()
    throws IOException
  {
    new Iterator()
    {
      final Iterator<d.c> a = c.this.b.k();
      String b;
      boolean c;
      
      public String a()
      {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        String str = this.b;
        this.b = null;
        this.c = true;
        return str;
      }
      
      public boolean hasNext()
      {
        if (this.b != null) {
          return true;
        }
        this.c = false;
        while (this.a.hasNext())
        {
          d.c localc = (d.c)this.a.next();
          try
          {
            this.b = Okio.buffer(localc.a(0)).readUtf8LineStrict();
            localc.close();
            return true;
          }
          catch (IOException localIOException)
          {
            localIOException = localIOException;
            localc.close();
          }
          finally
          {
            localObject = finally;
            localc.close();
            throw ((Throwable)localObject);
          }
        }
        return false;
      }
      
      public void remove()
      {
        if (!this.c) {
          throw new IllegalStateException("remove() before next()");
        }
        this.a.remove();
      }
    };
  }
  
  public int e()
  {
    try
    {
      int m = this.d;
      return m;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int f()
  {
    try
    {
      int m = this.c;
      return m;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void flush()
    throws IOException
  {
    this.b.flush();
  }
  
  public long g()
    throws IOException
  {
    return this.b.e();
  }
  
  public long h()
  {
    return this.b.d();
  }
  
  public File i()
  {
    return this.b.c();
  }
  
  public boolean j()
  {
    return this.b.g();
  }
  
  void k()
  {
    try
    {
      this.j += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int l()
  {
    try
    {
      int m = this.i;
      return m;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int m()
  {
    try
    {
      int m = this.j;
      return m;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int n()
  {
    try
    {
      int m = this.k;
      return m;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private final class a
    implements b
  {
    boolean a;
    private final d.a c;
    private Sink d;
    private Sink e;
    
    public a(final d.a parama)
    {
      this.c = parama;
      this.d = parama.b(1);
      this.e = new ForwardingSink(this.d)
      {
        public void close()
          throws IOException
        {
          synchronized (c.this)
          {
            if (c.a.this.a) {
              return;
            }
            c.a.this.a = true;
            c localc2 = c.this;
            localc2.c += 1;
            super.close();
            parama.b();
            return;
          }
        }
      };
    }
    
    public void a()
    {
      synchronized (c.this)
      {
        if (this.a) {
          return;
        }
        this.a = true;
        c localc2 = c.this;
        localc2.d += 1;
        b.a.c.a(this.d);
        try
        {
          this.c.c();
          return;
        }
        catch (IOException localIOException) {}
      }
    }
    
    public Sink b()
    {
      return this.e;
    }
  }
  
  private static class b
    extends ae
  {
    final d.c a;
    private final BufferedSource b;
    private final String c;
    private final String d;
    
    public b(final d.c paramc, String paramString1, String paramString2)
    {
      this.a = paramc;
      this.c = paramString1;
      this.d = paramString2;
      this.b = Okio.buffer(new ForwardingSource(paramc.a(1))
      {
        public void close()
          throws IOException
        {
          paramc.close();
          super.close();
        }
      });
    }
    
    public w a()
    {
      if (this.c != null) {
        return w.a(this.c);
      }
      return null;
    }
    
    public long b()
    {
      long l = -1L;
      try
      {
        if (this.d != null) {
          l = Long.parseLong(this.d);
        }
        return l;
      }
      catch (NumberFormatException localNumberFormatException) {}
      return -1L;
    }
    
    public BufferedSource c()
    {
      return this.b;
    }
  }
  
  private static final class c
  {
    private static final String a = b.a.h.e.b().c() + "-Sent-Millis";
    private static final String b = b.a.h.e.b().c() + "-Received-Millis";
    private final String c;
    private final t d;
    private final String e;
    private final z f;
    private final int g;
    private final String h;
    private final t i;
    private final s j;
    private final long k;
    private final long l;
    
    public c(ad paramad)
    {
      this.c = paramad.a().a().toString();
      this.d = b.a.d.e.c(paramad);
      this.e = paramad.a().b();
      this.f = paramad.b();
      this.g = paramad.c();
      this.h = paramad.e();
      this.i = paramad.g();
      this.j = paramad.f();
      this.k = paramad.p();
      this.l = paramad.q();
    }
    
    public c(Source paramSource)
      throws IOException
    {
      for (;;)
      {
        try
        {
          BufferedSource localBufferedSource1 = Okio.buffer(paramSource);
          this.c = localBufferedSource1.readUtf8LineStrict();
          this.e = localBufferedSource1.readUtf8LineStrict();
          localObject1 = new t.a();
          int n = c.a(localBufferedSource1);
          int m = 0;
          if (m < n)
          {
            ((t.a)localObject1).a(localBufferedSource1.readUtf8LineStrict());
            m += 1;
            continue;
          }
          this.d = ((t.a)localObject1).a();
          localObject1 = k.a(localBufferedSource1.readUtf8LineStrict());
          this.f = ((k)localObject1).d;
          this.g = ((k)localObject1).e;
          this.h = ((k)localObject1).f;
          localObject1 = new t.a();
          n = c.a(localBufferedSource1);
          m = 0;
          if (m < n)
          {
            ((t.a)localObject1).a(localBufferedSource1.readUtf8LineStrict());
            m += 1;
            continue;
          }
          localObject2 = ((t.a)localObject1).d(a);
          localObject3 = ((t.a)localObject1).d(b);
          ((t.a)localObject1).c(a);
          ((t.a)localObject1).c(b);
          if (localObject2 != null)
          {
            l1 = Long.parseLong((String)localObject2);
            this.k = l1;
            if (localObject3 == null) {
              break label321;
            }
            l1 = Long.parseLong((String)localObject3);
            this.l = l1;
            this.i = ((t.a)localObject1).a();
            if (!a()) {
              break label405;
            }
            localObject1 = localBufferedSource1.readUtf8LineStrict();
            if (((String)localObject1).length() <= 0) {
              break;
            }
            throw new IOException("expected \"\" but was \"" + (String)localObject1 + "\"");
          }
        }
        finally
        {
          paramSource.close();
        }
        long l1 = 0L;
        continue;
        label321:
        l1 = 0L;
      }
      Object localObject1 = i.a(localBufferedSource2.readUtf8LineStrict());
      Object localObject2 = a(localBufferedSource2);
      Object localObject3 = a(localBufferedSource2);
      ag localag;
      if (!localBufferedSource2.exhausted()) {
        localag = ag.a(localBufferedSource2.readUtf8LineStrict());
      }
      label405:
      for (this.j = s.a(localag, (i)localObject1, (List)localObject2, (List)localObject3);; this.j = null)
      {
        paramSource.close();
        return;
        localag = null;
        break;
      }
    }
    
    /* Error */
    private List<Certificate> a(BufferedSource paramBufferedSource)
      throws IOException
    {
      // Byte code:
      //   0: aload_1
      //   1: invokestatic 138	b/c:a	(Lokio/BufferedSource;)I
      //   4: istore_3
      //   5: iload_3
      //   6: iconst_m1
      //   7: if_icmpne +11 -> 18
      //   10: invokestatic 215	java/util/Collections:emptyList	()Ljava/util/List;
      //   13: astore 4
      //   15: aload 4
      //   17: areturn
      //   18: ldc -39
      //   20: invokestatic 223	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
      //   23: astore 6
      //   25: new 225	java/util/ArrayList
      //   28: dup
      //   29: iload_3
      //   30: invokespecial 228	java/util/ArrayList:<init>	(I)V
      //   33: astore 5
      //   35: iconst_0
      //   36: istore_2
      //   37: aload 5
      //   39: astore 4
      //   41: iload_2
      //   42: iload_3
      //   43: if_icmpge -28 -> 15
      //   46: aload_1
      //   47: invokeinterface 132 1 0
      //   52: astore 4
      //   54: new 230	okio/Buffer
      //   57: dup
      //   58: invokespecial 231	okio/Buffer:<init>	()V
      //   61: astore 7
      //   63: aload 7
      //   65: aload 4
      //   67: invokestatic 237	okio/ByteString:decodeBase64	(Ljava/lang/String;)Lokio/ByteString;
      //   70: invokevirtual 241	okio/Buffer:write	(Lokio/ByteString;)Lokio/Buffer;
      //   73: pop
      //   74: aload 5
      //   76: aload 6
      //   78: aload 7
      //   80: invokevirtual 245	okio/Buffer:inputStream	()Ljava/io/InputStream;
      //   83: invokevirtual 249	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
      //   86: invokeinterface 255 2 0
      //   91: pop
      //   92: iload_2
      //   93: iconst_1
      //   94: iadd
      //   95: istore_2
      //   96: goto -59 -> 37
      //   99: astore_1
      //   100: new 121	java/io/IOException
      //   103: dup
      //   104: aload_1
      //   105: invokevirtual 258	java/security/cert/CertificateException:getMessage	()Ljava/lang/String;
      //   108: invokespecial 180	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   111: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	112	0	this	c
      //   0	112	1	paramBufferedSource	BufferedSource
      //   36	60	2	m	int
      //   4	40	3	n	int
      //   13	53	4	localObject	Object
      //   33	42	5	localArrayList	java.util.ArrayList
      //   23	54	6	localCertificateFactory	java.security.cert.CertificateFactory
      //   61	18	7	localBuffer	okio.Buffer
      // Exception table:
      //   from	to	target	type
      //   18	35	99	java/security/cert/CertificateException
      //   46	92	99	java/security/cert/CertificateException
    }
    
    private void a(BufferedSink paramBufferedSink, List<Certificate> paramList)
      throws IOException
    {
      try
      {
        paramBufferedSink.writeDecimalLong(paramList.size()).writeByte(10);
        int m = 0;
        int n = paramList.size();
        while (m < n)
        {
          paramBufferedSink.writeUtf8(ByteString.of(((Certificate)paramList.get(m)).getEncoded()).base64()).writeByte(10);
          m += 1;
        }
        return;
      }
      catch (CertificateEncodingException paramBufferedSink)
      {
        throw new IOException(paramBufferedSink.getMessage());
      }
    }
    
    private boolean a()
    {
      return this.c.startsWith("https://");
    }
    
    public ad a(d.c paramc)
    {
      String str1 = this.i.a("Content-Type");
      String str2 = this.i.a("Content-Length");
      ab localab = new ab.a().a(this.c).a(this.e, null).a(this.d).d();
      return new ad.a().a(localab).a(this.f).a(this.g).a(this.h).a(this.i).a(new c.b(paramc, str1, str2)).a(this.j).a(this.k).b(this.l).a();
    }
    
    public void a(d.a parama)
      throws IOException
    {
      parama = Okio.buffer(parama.b(0));
      parama.writeUtf8(this.c).writeByte(10);
      parama.writeUtf8(this.e).writeByte(10);
      parama.writeDecimalLong(this.d.a()).writeByte(10);
      int m = 0;
      int n = this.d.a();
      while (m < n)
      {
        parama.writeUtf8(this.d.a(m)).writeUtf8(": ").writeUtf8(this.d.b(m)).writeByte(10);
        m += 1;
      }
      parama.writeUtf8(new k(this.f, this.g, this.h).toString()).writeByte(10);
      parama.writeDecimalLong(this.i.a() + 2).writeByte(10);
      m = 0;
      n = this.i.a();
      while (m < n)
      {
        parama.writeUtf8(this.i.a(m)).writeUtf8(": ").writeUtf8(this.i.b(m)).writeByte(10);
        m += 1;
      }
      parama.writeUtf8(a).writeUtf8(": ").writeDecimalLong(this.k).writeByte(10);
      parama.writeUtf8(b).writeUtf8(": ").writeDecimalLong(this.l).writeByte(10);
      if (a())
      {
        parama.writeByte(10);
        parama.writeUtf8(this.j.b().a()).writeByte(10);
        a(parama, this.j.c());
        a(parama, this.j.e());
        if (this.j.a() != null) {
          parama.writeUtf8(this.j.a().a()).writeByte(10);
        }
      }
      parama.close();
    }
    
    public boolean a(ab paramab, ad paramad)
    {
      return (this.c.equals(paramab.a().toString())) && (this.e.equals(paramab.b())) && (b.a.d.e.a(paramad, this.d, paramab));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */