package b.a.a;

import b.a.c;
import b.a.g.a;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class d
  implements Closeable, Flushable
{
  static final String a = "journal";
  static final String b = "journal.tmp";
  static final String c = "journal.bkp";
  static final String d = "libcore.io.DiskLruCache";
  static final String e = "1";
  static final long f = -1L;
  static final Pattern g;
  private static final String t = "CLEAN";
  private static final String u = "DIRTY";
  private static final String v = "REMOVE";
  private static final String w = "READ";
  private final int A;
  private long B;
  private long C = 0L;
  private long D = 0L;
  private final Executor E;
  private final Runnable F = new Runnable()
  {
    public void run()
    {
      int i = 1;
      synchronized (d.this)
      {
        if (!d.this.o)
        {
          if ((i | d.this.p) == 0) {}
        }
        else {
          i = 0;
        }
      }
      try
      {
        d.this.h();
      }
      catch (IOException localIOException1)
      {
        try
        {
          for (;;)
          {
            if (d.this.f())
            {
              d.this.b();
              d.this.m = 0;
            }
            return;
            localObject = finally;
            throw ((Throwable)localObject);
            localIOException1 = localIOException1;
            d.this.q = true;
          }
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            d.this.r = true;
            d.this.k = Okio.buffer(Okio.blackhole());
          }
        }
      }
    }
  };
  final a h;
  final File i;
  final int j;
  BufferedSink k;
  final LinkedHashMap<String, b> l = new LinkedHashMap(0, 0.75F, true);
  int m;
  boolean n;
  boolean o;
  boolean p;
  boolean q;
  boolean r;
  private final File x;
  private final File y;
  private final File z;
  
  static
  {
    if (!d.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      s = bool;
      g = Pattern.compile("[a-z0-9_-]{1,120}");
      return;
    }
  }
  
  d(a parama, File paramFile, int paramInt1, int paramInt2, long paramLong, Executor paramExecutor)
  {
    this.h = parama;
    this.i = paramFile;
    this.A = paramInt1;
    this.x = new File(paramFile, "journal");
    this.y = new File(paramFile, "journal.tmp");
    this.z = new File(paramFile, "journal.bkp");
    this.j = paramInt2;
    this.B = paramLong;
    this.E = paramExecutor;
  }
  
  public static d a(a parama, File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("maxSize <= 0");
    }
    if (paramInt2 <= 0) {
      throw new IllegalArgumentException("valueCount <= 0");
    }
    return new d(parama, paramFile, paramInt1, paramInt2, paramLong, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), c.a("OkHttp DiskLruCache", true)));
  }
  
  private void d(String paramString)
    throws IOException
  {
    int i1 = paramString.indexOf(' ');
    if (i1 == -1) {
      throw new IOException("unexpected journal line: " + paramString);
    }
    int i2 = i1 + 1;
    int i3 = paramString.indexOf(' ', i2);
    Object localObject2;
    Object localObject1;
    if (i3 == -1)
    {
      localObject2 = paramString.substring(i2);
      localObject1 = localObject2;
      if (i1 != "REMOVE".length()) {
        break label111;
      }
      localObject1 = localObject2;
      if (!paramString.startsWith("REMOVE")) {
        break label111;
      }
      this.l.remove(localObject2);
    }
    label111:
    do
    {
      return;
      localObject1 = paramString.substring(i2, i3);
      b localb = (b)this.l.get(localObject1);
      localObject2 = localb;
      if (localb == null)
      {
        localObject2 = new b((String)localObject1);
        this.l.put(localObject1, localObject2);
      }
      if ((i3 != -1) && (i1 == "CLEAN".length()) && (paramString.startsWith("CLEAN")))
      {
        paramString = paramString.substring(i3 + 1).split(" ");
        ((b)localObject2).e = true;
        ((b)localObject2).f = null;
        ((b)localObject2).a(paramString);
        return;
      }
      if ((i3 == -1) && (i1 == "DIRTY".length()) && (paramString.startsWith("DIRTY")))
      {
        ((b)localObject2).f = new a((b)localObject2);
        return;
      }
    } while ((i3 == -1) && (i1 == "READ".length()) && (paramString.startsWith("READ")));
    throw new IOException("unexpected journal line: " + paramString);
  }
  
  private void e(String paramString)
  {
    if (!g.matcher(paramString).matches()) {
      throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + paramString + "\"");
    }
  }
  
  private void l()
    throws IOException
  {
    BufferedSource localBufferedSource = Okio.buffer(this.h.a(this.x));
    label241:
    try
    {
      String str1 = localBufferedSource.readUtf8LineStrict();
      String str2 = localBufferedSource.readUtf8LineStrict();
      String str3 = localBufferedSource.readUtf8LineStrict();
      String str4 = localBufferedSource.readUtf8LineStrict();
      String str5 = localBufferedSource.readUtf8LineStrict();
      if ((!"libcore.io.DiskLruCache".equals(str1)) || (!"1".equals(str2)) || (!Integer.toString(this.A).equals(str3)) || (!Integer.toString(this.j).equals(str4)) || (!"".equals(str5))) {
        throw new IOException("unexpected journal header: [" + str1 + ", " + str2 + ", " + str4 + ", " + str5 + "]");
      }
    }
    finally
    {
      c.a(localBufferedSource);
      throw ((Throwable)localObject);
      int i1 = 0;
      try
      {
        for (;;)
        {
          d(localBufferedSource.readUtf8LineStrict());
          i1 += 1;
        }
        b();
      }
      catch (EOFException localEOFException)
      {
        this.m = (i1 - this.l.size());
        if (localBufferedSource.exhausted()) {
          break label241;
        }
      }
      c.a(localBufferedSource);
      return;
    }
  }
  
  private BufferedSink m()
    throws FileNotFoundException
  {
    Okio.buffer(new e(this.h.c(this.x))
    {
      static
      {
        if (!d.class.desiredAssertionStatus()) {}
        for (boolean bool = true;; bool = false)
        {
          a = bool;
          return;
        }
      }
      
      protected void a(IOException paramAnonymousIOException)
      {
        if ((!a) && (!Thread.holdsLock(d.this))) {
          throw new AssertionError();
        }
        d.this.n = true;
      }
    });
  }
  
  private void n()
    throws IOException
  {
    this.h.d(this.y);
    Iterator localIterator = this.l.values().iterator();
    while (localIterator.hasNext())
    {
      b localb = (b)localIterator.next();
      int i1;
      if (localb.f == null)
      {
        i1 = 0;
        while (i1 < this.j)
        {
          this.C += localb.b[i1];
          i1 += 1;
        }
      }
      else
      {
        localb.f = null;
        i1 = 0;
        while (i1 < this.j)
        {
          this.h.d(localb.c[i1]);
          this.h.d(localb.d[i1]);
          i1 += 1;
        }
        localIterator.remove();
      }
    }
  }
  
  private void o()
  {
    try
    {
      if (g()) {
        throw new IllegalStateException("cache is closed");
      }
    }
    finally {}
  }
  
  a a(String paramString, long paramLong)
    throws IOException
  {
    Object localObject2 = null;
    for (;;)
    {
      b localb;
      try
      {
        a();
        o();
        e(paramString);
        localb = (b)this.l.get(paramString);
        if (paramLong != -1L)
        {
          localObject1 = localObject2;
          if (localb != null)
          {
            long l1 = localb.g;
            if (l1 != paramLong) {
              localObject1 = localObject2;
            }
          }
          else
          {
            return (a)localObject1;
          }
        }
        if (localb != null)
        {
          localObject1 = localObject2;
          if (localb.f != null) {
            continue;
          }
        }
        if ((this.q) || (this.r))
        {
          this.E.execute(this.F);
          localObject1 = localObject2;
          continue;
        }
        this.k.writeUtf8("DIRTY").writeByte(32).writeUtf8(paramString).writeByte(10);
      }
      finally {}
      this.k.flush();
      Object localObject1 = localObject2;
      if (!this.n)
      {
        localObject1 = localb;
        if (localb == null)
        {
          localObject1 = new b(paramString);
          this.l.put(paramString, localObject1);
        }
        paramString = new a((b)localObject1);
        ((b)localObject1).f = paramString;
        localObject1 = paramString;
      }
    }
  }
  
  /* Error */
  public c a(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 378	b/a/a/d:a	()V
    //   6: aload_0
    //   7: invokespecial 380	b/a/a/d:o	()V
    //   10: aload_0
    //   11: aload_1
    //   12: invokespecial 382	b/a/a/d:e	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield 121	b/a/a/d:l	Ljava/util/LinkedHashMap;
    //   19: aload_1
    //   20: invokevirtual 233	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 21	b/a/a/d$b
    //   26: astore_3
    //   27: aload_3
    //   28: ifnull +12 -> 40
    //   31: aload_3
    //   32: getfield 248	b/a/a/d$b:e	Z
    //   35: istore_2
    //   36: iload_2
    //   37: ifne +9 -> 46
    //   40: aconst_null
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: aload_3
    //   47: invokevirtual 413	b/a/a/d$b:a	()Lb/a/a/d$c;
    //   50: astore_3
    //   51: aload_3
    //   52: ifnonnull +8 -> 60
    //   55: aconst_null
    //   56: astore_1
    //   57: goto -15 -> 42
    //   60: aload_0
    //   61: aload_0
    //   62: getfield 315	b/a/a/d:m	I
    //   65: iconst_1
    //   66: iadd
    //   67: putfield 315	b/a/a/d:m	I
    //   70: aload_0
    //   71: getfield 325	b/a/a/d:k	Lokio/BufferedSink;
    //   74: ldc 58
    //   76: invokeinterface 400 2 0
    //   81: bipush 32
    //   83: invokeinterface 404 2 0
    //   88: aload_1
    //   89: invokeinterface 400 2 0
    //   94: bipush 10
    //   96: invokeinterface 404 2 0
    //   101: pop
    //   102: aload_3
    //   103: astore_1
    //   104: aload_0
    //   105: invokevirtual 415	b/a/a/d:f	()Z
    //   108: ifeq -66 -> 42
    //   111: aload_0
    //   112: getfield 151	b/a/a/d:E	Ljava/util/concurrent/Executor;
    //   115: aload_0
    //   116: getfield 128	b/a/a/d:F	Ljava/lang/Runnable;
    //   119: invokeinterface 394 2 0
    //   124: aload_3
    //   125: astore_1
    //   126: goto -84 -> 42
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	d
    //   0	134	1	paramString	String
    //   35	2	2	bool	boolean
    //   26	99	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	27	129	finally
    //   31	36	129	finally
    //   46	51	129	finally
    //   60	102	129	finally
    //   104	124	129	finally
  }
  
  public void a()
    throws IOException
  {
    try
    {
      if ((!s) && (!Thread.holdsLock(this))) {
        throw new AssertionError();
      }
    }
    finally {}
    boolean bool = this.o;
    if (bool) {
      return;
    }
    if (this.h.e(this.z))
    {
      if (!this.h.e(this.x)) {
        break label191;
      }
      this.h.d(this.z);
    }
    for (;;)
    {
      bool = this.h.e(this.x);
      if (bool) {
        try
        {
          l();
          n();
          this.o = true;
        }
        catch (IOException localIOException)
        {
          b.a.h.e.b().a(5, "DiskLruCache " + this.i + " is corrupt: " + localIOException.getMessage() + ", removing", localIOException);
          i();
          this.p = false;
        }
      }
      b();
      this.o = true;
      break;
      label191:
      this.h.a(this.z, this.x);
    }
  }
  
  public void a(long paramLong)
  {
    try
    {
      this.B = paramLong;
      if (this.o) {
        this.E.execute(this.F);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void a(a parama, boolean paramBoolean)
    throws IOException
  {
    b localb;
    try
    {
      localb = parama.a;
      if (localb.f != parama) {
        throw new IllegalStateException();
      }
    }
    finally {}
    if ((paramBoolean) && (!localb.e))
    {
      i1 = 0;
      while (i1 < this.j)
      {
        if (parama.b[i1] == 0)
        {
          parama.c();
          throw new IllegalStateException("Newly created entry didn't create value for index " + i1);
        }
        if (!this.h.e(localb.d[i1]))
        {
          parama.c();
          return;
        }
        i1 += 1;
      }
    }
    int i1 = 0;
    for (;;)
    {
      long l1;
      if (i1 < this.j)
      {
        parama = localb.d[i1];
        if (paramBoolean)
        {
          if (this.h.e(parama))
          {
            File localFile = localb.c[i1];
            this.h.a(parama, localFile);
            l1 = localb.b[i1];
            long l2 = this.h.f(localFile);
            localb.b[i1] = l2;
            this.C = (this.C - l1 + l2);
          }
        }
        else {
          this.h.d(parama);
        }
      }
      else
      {
        this.m += 1;
        localb.f = null;
        if ((localb.e | paramBoolean))
        {
          localb.e = true;
          this.k.writeUtf8("CLEAN").writeByte(32);
          this.k.writeUtf8(localb.a);
          localb.a(this.k);
          this.k.writeByte(10);
          if (paramBoolean)
          {
            l1 = this.D;
            this.D = (1L + l1);
            localb.g = l1;
          }
        }
        for (;;)
        {
          this.k.flush();
          if ((this.C <= this.B) && (!f())) {
            break;
          }
          this.E.execute(this.F);
          break;
          this.l.remove(localb.a);
          this.k.writeUtf8("REMOVE").writeByte(32);
          this.k.writeUtf8(localb.a);
          this.k.writeByte(10);
        }
      }
      i1 += 1;
    }
  }
  
  boolean a(b paramb)
    throws IOException
  {
    if (paramb.f != null) {
      paramb.f.a();
    }
    int i1 = 0;
    while (i1 < this.j)
    {
      this.h.d(paramb.c[i1]);
      this.C -= paramb.b[i1];
      paramb.b[i1] = 0L;
      i1 += 1;
    }
    this.m += 1;
    this.k.writeUtf8("REMOVE").writeByte(32).writeUtf8(paramb.a).writeByte(10);
    this.l.remove(paramb.a);
    if (f()) {
      this.E.execute(this.F);
    }
    return true;
  }
  
  public a b(String paramString)
    throws IOException
  {
    return a(paramString, -1L);
  }
  
  void b()
    throws IOException
  {
    for (;;)
    {
      b localb;
      try
      {
        if (this.k != null) {
          this.k.close();
        }
        BufferedSink localBufferedSink1 = Okio.buffer(this.h.b(this.y));
        try
        {
          localBufferedSink1.writeUtf8("libcore.io.DiskLruCache").writeByte(10);
          localBufferedSink1.writeUtf8("1").writeByte(10);
          localBufferedSink1.writeDecimalLong(this.A).writeByte(10);
          localBufferedSink1.writeDecimalLong(this.j).writeByte(10);
          localBufferedSink1.writeByte(10);
          Iterator localIterator = this.l.values().iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          localb = (b)localIterator.next();
          if (localb.f != null)
          {
            localBufferedSink1.writeUtf8("DIRTY").writeByte(32);
            localBufferedSink1.writeUtf8(localb.a);
            localBufferedSink1.writeByte(10);
            continue;
            localBufferedSink2 = finally;
          }
        }
        finally
        {
          localBufferedSink1.close();
        }
        localBufferedSink2.writeUtf8("CLEAN").writeByte(32);
      }
      finally {}
      localBufferedSink2.writeUtf8(localb.a);
      localb.a(localBufferedSink2);
      localBufferedSink2.writeByte(10);
    }
    localBufferedSink2.close();
    if (this.h.e(this.x)) {
      this.h.a(this.x, this.z);
    }
    this.h.a(this.y, this.x);
    this.h.d(this.z);
    this.k = m();
    this.n = false;
    this.r = false;
  }
  
  public File c()
  {
    return this.i;
  }
  
  /* Error */
  public boolean c(String paramString)
    throws IOException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: invokevirtual 378	b/a/a/d:a	()V
    //   8: aload_0
    //   9: invokespecial 380	b/a/a/d:o	()V
    //   12: aload_0
    //   13: aload_1
    //   14: invokespecial 382	b/a/a/d:e	(Ljava/lang/String;)V
    //   17: aload_0
    //   18: getfield 121	b/a/a/d:l	Ljava/util/LinkedHashMap;
    //   21: aload_1
    //   22: invokevirtual 233	java/util/LinkedHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 21	b/a/a/d$b
    //   28: astore_1
    //   29: aload_1
    //   30: ifnonnull +7 -> 37
    //   33: aload_0
    //   34: monitorexit
    //   35: iload_2
    //   36: ireturn
    //   37: aload_0
    //   38: aload_1
    //   39: invokevirtual 500	b/a/a/d:a	(Lb/a/a/d$b;)Z
    //   42: istore_3
    //   43: iload_3
    //   44: istore_2
    //   45: iload_3
    //   46: ifeq -13 -> 33
    //   49: iload_3
    //   50: istore_2
    //   51: aload_0
    //   52: getfield 113	b/a/a/d:C	J
    //   55: aload_0
    //   56: getfield 149	b/a/a/d:B	J
    //   59: lcmp
    //   60: ifgt -27 -> 33
    //   63: aload_0
    //   64: iconst_0
    //   65: putfield 386	b/a/a/d:q	Z
    //   68: iload_3
    //   69: istore_2
    //   70: goto -37 -> 33
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	d
    //   0	78	1	paramString	String
    //   1	69	2	bool1	boolean
    //   42	27	3	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   4	29	73	finally
    //   37	43	73	finally
    //   51	68	73	finally
  }
  
  public void close()
    throws IOException
  {
    for (;;)
    {
      try
      {
        if ((!this.o) || (this.p))
        {
          this.p = true;
          return;
        }
        b[] arrayOfb = (b[])this.l.values().toArray(new b[this.l.size()]);
        int i2 = arrayOfb.length;
        int i1 = 0;
        if (i1 < i2)
        {
          b localb = arrayOfb[i1];
          if (localb.f != null) {
            localb.f.c();
          }
        }
        else
        {
          h();
          this.k.close();
          this.k = null;
          this.p = true;
          continue;
        }
        i1 += 1;
      }
      finally {}
    }
  }
  
  public long d()
  {
    try
    {
      long l1 = this.B;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long e()
    throws IOException
  {
    try
    {
      a();
      long l1 = this.C;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  boolean f()
  {
    return (this.m >= 2000) && (this.m >= this.l.size());
  }
  
  /* Error */
  public void flush()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 425	b/a/a/d:o	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokespecial 380	b/a/a/d:o	()V
    //   18: aload_0
    //   19: invokevirtual 508	b/a/a/d:h	()V
    //   22: aload_0
    //   23: getfield 325	b/a/a/d:k	Lokio/BufferedSink;
    //   26: invokeinterface 407 1 0
    //   31: goto -20 -> 11
    //   34: astore_2
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_2
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	d
    //   6	2	1	bool	boolean
    //   34	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	34	finally
    //   14	31	34	finally
  }
  
  public boolean g()
  {
    try
    {
      boolean bool = this.p;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void h()
    throws IOException
  {
    while (this.C > this.B) {
      a((b)this.l.values().iterator().next());
    }
    this.q = false;
  }
  
  public void i()
    throws IOException
  {
    close();
    this.h.g(this.i);
  }
  
  public void j()
    throws IOException
  {
    int i1 = 0;
    try
    {
      a();
      b[] arrayOfb = (b[])this.l.values().toArray(new b[this.l.size()]);
      int i2 = arrayOfb.length;
      while (i1 < i2)
      {
        a(arrayOfb[i1]);
        i1 += 1;
      }
      this.q = false;
      return;
    }
    finally {}
  }
  
  public Iterator<c> k()
    throws IOException
  {
    try
    {
      a();
      Iterator local3 = new Iterator()
      {
        final Iterator<d.b> a = new ArrayList(d.this.l.values()).iterator();
        d.c b;
        d.c c;
        
        public d.c a()
        {
          if (!hasNext()) {
            throw new NoSuchElementException();
          }
          this.c = this.b;
          this.b = null;
          return this.c;
        }
        
        public boolean hasNext()
        {
          if (this.b != null) {
            return true;
          }
          synchronized (d.this)
          {
            if (d.this.p) {
              return false;
            }
            while (this.a.hasNext())
            {
              d.c localc = ((d.b)this.a.next()).a();
              if (localc != null)
              {
                this.b = localc;
                return true;
              }
            }
          }
          return false;
        }
        
        public void remove()
        {
          if (this.c == null) {
            throw new IllegalStateException("remove() before next()");
          }
          try
          {
            d.this.c(d.c.a(this.c));
            this.c = null;
            return;
          }
          catch (IOException localIOException)
          {
            localIOException = localIOException;
            this.c = null;
            return;
          }
          finally
          {
            localObject = finally;
            this.c = null;
            throw ((Throwable)localObject);
          }
        }
      };
      return local3;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final class a
  {
    final d.b a;
    final boolean[] b;
    private boolean d;
    
    a(d.b paramb)
    {
      this.a = paramb;
      if (paramb.e) {}
      for (this$1 = null;; this$1 = new boolean[d.this.j])
      {
        this.b = d.this;
        return;
      }
    }
    
    public Source a(int paramInt)
    {
      synchronized (d.this)
      {
        if (this.d) {
          throw new IllegalStateException();
        }
      }
      if ((!this.a.e) || (this.a.f != this)) {
        return null;
      }
      try
      {
        Source localSource = d.this.h.a(this.a.c[paramInt]);
        return localSource;
      }
      catch (FileNotFoundException localFileNotFoundException) {}
      return null;
    }
    
    void a()
    {
      int i;
      if (this.a.f == this) {
        i = 0;
      }
      for (;;)
      {
        if (i < d.this.j) {}
        try
        {
          d.this.h.d(this.a.d[i]);
          i += 1;
          continue;
          this.a.f = null;
          return;
        }
        catch (IOException localIOException)
        {
          for (;;) {}
        }
      }
    }
    
    public Sink b(int paramInt)
    {
      synchronized (d.this)
      {
        if (this.d) {
          throw new IllegalStateException();
        }
      }
      if (this.a.f != this)
      {
        localObject2 = Okio.blackhole();
        return (Sink)localObject2;
      }
      if (!this.a.e) {
        this.b[paramInt] = true;
      }
      Object localObject2 = this.a.d[paramInt];
      try
      {
        localObject2 = d.this.h.b((File)localObject2);
        localObject2 = new e((Sink)localObject2)
        {
          protected void a(IOException arg1)
          {
            synchronized (d.this)
            {
              d.a.this.a();
              return;
            }
          }
        };
        return (Sink)localObject2;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        Sink localSink = Okio.blackhole();
        return localSink;
      }
    }
    
    public void b()
      throws IOException
    {
      synchronized (d.this)
      {
        if (this.d) {
          throw new IllegalStateException();
        }
      }
      if (this.a.f == this) {
        d.this.a(this, true);
      }
      this.d = true;
    }
    
    public void c()
      throws IOException
    {
      synchronized (d.this)
      {
        if (this.d) {
          throw new IllegalStateException();
        }
      }
      if (this.a.f == this) {
        d.this.a(this, false);
      }
      this.d = true;
    }
    
    public void d()
    {
      synchronized (d.this)
      {
        if (!this.d)
        {
          a locala = this.a.f;
          if (locala != this) {}
        }
      }
      try
      {
        d.this.a(this, false);
        return;
        localObject = finally;
        throw ((Throwable)localObject);
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
    }
  }
  
  private final class b
  {
    final String a;
    final long[] b;
    final File[] c;
    final File[] d;
    boolean e;
    d.a f;
    long g;
    
    b(String paramString)
    {
      this.a = paramString;
      this.b = new long[d.this.j];
      this.c = new File[d.this.j];
      this.d = new File[d.this.j];
      paramString = new StringBuilder(paramString).append('.');
      int j = paramString.length();
      int i = 0;
      while (i < d.this.j)
      {
        paramString.append(i);
        this.c[i] = new File(d.this.i, paramString.toString());
        paramString.append(".tmp");
        this.d[i] = new File(d.this.i, paramString.toString());
        paramString.setLength(j);
        i += 1;
      }
    }
    
    private IOException b(String[] paramArrayOfString)
      throws IOException
    {
      throw new IOException("unexpected journal line: " + Arrays.toString(paramArrayOfString));
    }
    
    d.c a()
    {
      if (!Thread.holdsLock(d.this)) {
        throw new AssertionError();
      }
      Source[] arrayOfSource = new Source[d.this.j];
      Object localObject = (long[])this.b.clone();
      int i = 0;
      try
      {
        while (i < d.this.j)
        {
          arrayOfSource[i] = d.this.h.a(this.c[i]);
          i += 1;
        }
        localObject = new d.c(d.this, this.a, this.g, arrayOfSource, (long[])localObject);
        return (d.c)localObject;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        i = 0;
        while ((i < d.this.j) && (arrayOfSource[i] != null))
        {
          c.a(arrayOfSource[i]);
          i += 1;
        }
      }
      try
      {
        d.this.a(this);
        return null;
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
    }
    
    void a(BufferedSink paramBufferedSink)
      throws IOException
    {
      long[] arrayOfLong = this.b;
      int j = arrayOfLong.length;
      int i = 0;
      while (i < j)
      {
        long l = arrayOfLong[i];
        paramBufferedSink.writeByte(32).writeDecimalLong(l);
        i += 1;
      }
    }
    
    void a(String[] paramArrayOfString)
      throws IOException
    {
      if (paramArrayOfString.length != d.this.j) {
        throw b(paramArrayOfString);
      }
      int i = 0;
      try
      {
        while (i < paramArrayOfString.length)
        {
          this.b[i] = Long.parseLong(paramArrayOfString[i]);
          i += 1;
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw b(paramArrayOfString);
      }
    }
  }
  
  public final class c
    implements Closeable
  {
    private final String b;
    private final long c;
    private final Source[] d;
    private final long[] e;
    
    c(String paramString, long paramLong, Source[] paramArrayOfSource, long[] paramArrayOfLong)
    {
      this.b = paramString;
      this.c = paramLong;
      this.d = paramArrayOfSource;
      this.e = paramArrayOfLong;
    }
    
    public String a()
    {
      return this.b;
    }
    
    public Source a(int paramInt)
    {
      return this.d[paramInt];
    }
    
    public long b(int paramInt)
    {
      return this.e[paramInt];
    }
    
    public d.a b()
      throws IOException
    {
      return d.this.a(this.b, this.c);
    }
    
    public void close()
    {
      Source[] arrayOfSource = this.d;
      int j = arrayOfSource.length;
      int i = 0;
      while (i < j)
      {
        c.a(arrayOfSource[i]);
        i += 1;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */