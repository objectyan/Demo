package b;

import b.a.c;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

public final class x
  extends ac
{
  public static final w a = w.a("multipart/mixed");
  public static final w b = w.a("multipart/alternative");
  public static final w c = w.a("multipart/digest");
  public static final w d = w.a("multipart/parallel");
  public static final w e = w.a("multipart/form-data");
  private static final byte[] f = { 58, 32 };
  private static final byte[] g = { 13, 10 };
  private static final byte[] h = { 45, 45 };
  private final ByteString i;
  private final w j;
  private final w k;
  private final List<b> l;
  private long m = -1L;
  
  x(ByteString paramByteString, w paramw, List<b> paramList)
  {
    this.i = paramByteString;
    this.j = paramw;
    this.k = w.a(paramw + "; boundary=" + paramByteString.utf8());
    this.l = c.a(paramList);
  }
  
  private long a(BufferedSink paramBufferedSink, boolean paramBoolean)
    throws IOException
  {
    long l1 = 0L;
    Buffer localBuffer = null;
    if (paramBoolean)
    {
      localBuffer = new Buffer();
      paramBufferedSink = localBuffer;
    }
    int n = 0;
    int i2 = this.l.size();
    if (n < i2)
    {
      Object localObject2 = (b)this.l.get(n);
      Object localObject1 = ((b)localObject2).a;
      localObject2 = ((b)localObject2).b;
      paramBufferedSink.write(h);
      paramBufferedSink.write(this.i);
      paramBufferedSink.write(g);
      if (localObject1 != null)
      {
        int i1 = 0;
        int i3 = ((t)localObject1).a();
        while (i1 < i3)
        {
          paramBufferedSink.writeUtf8(((t)localObject1).a(i1)).write(f).writeUtf8(((t)localObject1).b(i1)).write(g);
          i1 += 1;
        }
      }
      localObject1 = ((ac)localObject2).b();
      if (localObject1 != null) {
        paramBufferedSink.writeUtf8("Content-Type: ").writeUtf8(((w)localObject1).toString()).write(g);
      }
      l2 = ((ac)localObject2).c();
      if (l2 != -1L)
      {
        paramBufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(l2).write(g);
        label253:
        paramBufferedSink.write(g);
        if (!paramBoolean) {
          break label304;
        }
        l1 += l2;
      }
      for (;;)
      {
        paramBufferedSink.write(g);
        n += 1;
        break;
        if (!paramBoolean) {
          break label253;
        }
        localBuffer.clear();
        return -1L;
        label304:
        ((ac)localObject2).a(paramBufferedSink);
      }
    }
    paramBufferedSink.write(h);
    paramBufferedSink.write(this.i);
    paramBufferedSink.write(h);
    paramBufferedSink.write(g);
    long l2 = l1;
    if (paramBoolean)
    {
      l2 = l1 + localBuffer.size();
      localBuffer.clear();
    }
    return l2;
  }
  
  static StringBuilder a(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('"');
    int n = 0;
    int i1 = paramString.length();
    if (n < i1)
    {
      char c1 = paramString.charAt(n);
      switch (c1)
      {
      default: 
        paramStringBuilder.append(c1);
      }
      for (;;)
      {
        n += 1;
        break;
        paramStringBuilder.append("%0A");
        continue;
        paramStringBuilder.append("%0D");
        continue;
        paramStringBuilder.append("%22");
      }
    }
    paramStringBuilder.append('"');
    return paramStringBuilder;
  }
  
  public w a()
  {
    return this.j;
  }
  
  public b a(int paramInt)
  {
    return (b)this.l.get(paramInt);
  }
  
  public void a(BufferedSink paramBufferedSink)
    throws IOException
  {
    a(paramBufferedSink, false);
  }
  
  public w b()
  {
    return this.k;
  }
  
  public long c()
    throws IOException
  {
    long l1 = this.m;
    if (l1 != -1L) {
      return l1;
    }
    l1 = a(null, true);
    this.m = l1;
    return l1;
  }
  
  public String d()
  {
    return this.i.utf8();
  }
  
  public int e()
  {
    return this.l.size();
  }
  
  public List<b> f()
  {
    return this.l;
  }
  
  public static final class a
  {
    private final ByteString a;
    private w b = x.a;
    private final List<x.b> c = new ArrayList();
    
    public a()
    {
      this(UUID.randomUUID().toString());
    }
    
    public a(String paramString)
    {
      this.a = ByteString.encodeUtf8(paramString);
    }
    
    public a a(ac paramac)
    {
      return a(x.b.a(paramac));
    }
    
    public a a(t paramt, ac paramac)
    {
      return a(x.b.a(paramt, paramac));
    }
    
    public a a(w paramw)
    {
      if (paramw == null) {
        throw new NullPointerException("type == null");
      }
      if (!paramw.a().equals("multipart")) {
        throw new IllegalArgumentException("multipart != " + paramw);
      }
      this.b = paramw;
      return this;
    }
    
    public a a(x.b paramb)
    {
      if (paramb == null) {
        throw new NullPointerException("part == null");
      }
      this.c.add(paramb);
      return this;
    }
    
    public a a(String paramString1, String paramString2)
    {
      return a(x.b.a(paramString1, paramString2));
    }
    
    public a a(String paramString1, String paramString2, ac paramac)
    {
      return a(x.b.a(paramString1, paramString2, paramac));
    }
    
    public x a()
    {
      if (this.c.isEmpty()) {
        throw new IllegalStateException("Multipart body must have at least one part.");
      }
      return new x(this.a, this.b, this.c);
    }
  }
  
  public static final class b
  {
    final t a;
    final ac b;
    
    private b(t paramt, ac paramac)
    {
      this.a = paramt;
      this.b = paramac;
    }
    
    public static b a(ac paramac)
    {
      return a(null, paramac);
    }
    
    public static b a(t paramt, ac paramac)
    {
      if (paramac == null) {
        throw new NullPointerException("body == null");
      }
      if ((paramt != null) && (paramt.a("Content-Type") != null)) {
        throw new IllegalArgumentException("Unexpected header: Content-Type");
      }
      if ((paramt != null) && (paramt.a("Content-Length") != null)) {
        throw new IllegalArgumentException("Unexpected header: Content-Length");
      }
      return new b(paramt, paramac);
    }
    
    public static b a(String paramString1, String paramString2)
    {
      return a(paramString1, null, ac.a(null, paramString2));
    }
    
    public static b a(String paramString1, String paramString2, ac paramac)
    {
      if (paramString1 == null) {
        throw new NullPointerException("name == null");
      }
      StringBuilder localStringBuilder = new StringBuilder("form-data; name=");
      x.a(localStringBuilder, paramString1);
      if (paramString2 != null)
      {
        localStringBuilder.append("; filename=");
        x.a(localStringBuilder, paramString2);
      }
      return a(t.a(new String[] { "Content-Disposition", localStringBuilder.toString() }), paramac);
    }
    
    public t a()
    {
      return this.a;
    }
    
    public ac b()
    {
      return this.b;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */