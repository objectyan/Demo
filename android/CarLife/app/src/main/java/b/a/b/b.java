package b.a.b;

import b.a.c;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

final class b
{
  static final ByteString a = ByteString.encodeUtf8("OkHttp cache v1\n");
  static final ByteString b = ByteString.encodeUtf8("OkHttp DIRTY :(\n");
  private static final int l = 1;
  private static final int m = 2;
  private static final long n = 32L;
  RandomAccessFile c;
  Thread d;
  Source e;
  final Buffer f = new Buffer();
  long g;
  boolean h;
  final Buffer i = new Buffer();
  final long j;
  int k;
  private final ByteString o;
  
  private b(RandomAccessFile paramRandomAccessFile, Source paramSource, long paramLong1, ByteString paramByteString, long paramLong2)
  {
    this.c = paramRandomAccessFile;
    this.e = paramSource;
    if (paramSource == null) {}
    for (boolean bool = true;; bool = false)
    {
      this.h = bool;
      this.g = paramLong1;
      this.o = paramByteString;
      this.j = paramLong2;
      return;
    }
  }
  
  public static b a(File paramFile)
    throws IOException
  {
    paramFile = new RandomAccessFile(paramFile, "rw");
    a locala = new a(paramFile.getChannel());
    Buffer localBuffer = new Buffer();
    locala.b(0L, localBuffer, 32L);
    if (!localBuffer.readByteString(a.size()).equals(a)) {
      throw new IOException("unreadable cache file");
    }
    long l1 = localBuffer.readLong();
    long l2 = localBuffer.readLong();
    localBuffer = new Buffer();
    locala.b(32L + l1, localBuffer, l2);
    return new b(paramFile, null, l1, localBuffer.readByteString(), 0L);
  }
  
  public static b a(File paramFile, Source paramSource, ByteString paramByteString, long paramLong)
    throws IOException
  {
    paramFile = new RandomAccessFile(paramFile, "rw");
    paramSource = new b(paramFile, paramSource, 0L, paramByteString, paramLong);
    paramFile.setLength(0L);
    paramSource.a(b, -1L, -1L);
    return paramSource;
  }
  
  private void a(ByteString paramByteString, long paramLong1, long paramLong2)
    throws IOException
  {
    Buffer localBuffer = new Buffer();
    localBuffer.write(paramByteString);
    localBuffer.writeLong(paramLong1);
    localBuffer.writeLong(paramLong2);
    if (localBuffer.size() != 32L) {
      throw new IllegalArgumentException();
    }
    new a(this.c.getChannel()).a(0L, localBuffer, 32L);
  }
  
  private void b(long paramLong)
    throws IOException
  {
    Buffer localBuffer = new Buffer();
    localBuffer.write(this.o);
    new a(this.c.getChannel()).a(32L + paramLong, localBuffer, this.o.size());
  }
  
  void a(long paramLong)
    throws IOException
  {
    b(paramLong);
    this.c.getChannel().force(false);
    a(a, paramLong, this.o.size());
    this.c.getChannel().force(false);
    try
    {
      this.h = true;
      c.a(this.e);
      this.e = null;
      return;
    }
    finally {}
  }
  
  boolean a()
  {
    return this.c == null;
  }
  
  public ByteString b()
  {
    return this.o;
  }
  
  public Source c()
  {
    try
    {
      if (this.c == null) {
        return null;
      }
      this.k += 1;
      return new a();
    }
    finally {}
  }
  
  class a
    implements Source
  {
    private final Timeout b = new Timeout();
    private a c = new a(b.this.c.getChannel());
    private long d;
    
    a() {}
    
    public void close()
      throws IOException
    {
      if (this.c == null) {}
      for (;;)
      {
        return;
        this.c = null;
        RandomAccessFile localRandomAccessFile = null;
        synchronized (b.this)
        {
          b localb2 = b.this;
          localb2.k -= 1;
          if (b.this.k == 0)
          {
            localRandomAccessFile = b.this.c;
            b.this.c = null;
          }
          if (localRandomAccessFile == null) {
            continue;
          }
          c.a(localRandomAccessFile);
          return;
        }
      }
    }
    
    /* Error */
    public long read(Buffer arg1, long paramLong)
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 44	b/a/b/b$a:c	Lb/a/b/a;
      //   4: ifnonnull +13 -> 17
      //   7: new 62	java/lang/IllegalStateException
      //   10: dup
      //   11: ldc 64
      //   13: invokespecial 67	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   16: athrow
      //   17: aload_0
      //   18: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   21: astore 9
      //   23: aload 9
      //   25: monitorenter
      //   26: aload_0
      //   27: getfield 69	b/a/b/b$a:d	J
      //   30: lstore 7
      //   32: aload_0
      //   33: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   36: getfield 72	b/a/b/b:g	J
      //   39: lstore 5
      //   41: lload 7
      //   43: lload 5
      //   45: lcmp
      //   46: ifne +113 -> 159
      //   49: aload_0
      //   50: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   53: getfield 76	b/a/b/b:h	Z
      //   56: ifeq +10 -> 66
      //   59: aload 9
      //   61: monitorexit
      //   62: ldc2_w 77
      //   65: lreturn
      //   66: aload_0
      //   67: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   70: getfield 81	b/a/b/b:d	Ljava/lang/Thread;
      //   73: ifnull +23 -> 96
      //   76: aload_0
      //   77: getfield 28	b/a/b/b$a:b	Lokio/Timeout;
      //   80: aload_0
      //   81: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   84: invokevirtual 85	okio/Timeout:waitUntilNotified	(Ljava/lang/Object;)V
      //   87: goto -61 -> 26
      //   90: astore_1
      //   91: aload 9
      //   93: monitorexit
      //   94: aload_1
      //   95: athrow
      //   96: aload_0
      //   97: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   100: invokestatic 91	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   103: putfield 81	b/a/b/b:d	Ljava/lang/Thread;
      //   106: iconst_1
      //   107: istore 4
      //   109: aload 9
      //   111: monitorexit
      //   112: iload 4
      //   114: iconst_2
      //   115: if_icmpne +125 -> 240
      //   118: lload_2
      //   119: lload 5
      //   121: aload_0
      //   122: getfield 69	b/a/b/b$a:d	J
      //   125: lsub
      //   126: invokestatic 97	java/lang/Math:min	(JJ)J
      //   129: lstore_2
      //   130: aload_0
      //   131: getfield 44	b/a/b/b$a:c	Lb/a/b/a;
      //   134: ldc2_w 98
      //   137: aload_0
      //   138: getfield 69	b/a/b/b$a:d	J
      //   141: ladd
      //   142: aload_1
      //   143: lload_2
      //   144: invokevirtual 102	b/a/b/a:b	(JLokio/Buffer;J)V
      //   147: aload_0
      //   148: aload_0
      //   149: getfield 69	b/a/b/b$a:d	J
      //   152: lload_2
      //   153: ladd
      //   154: putfield 69	b/a/b/b$a:d	J
      //   157: lload_2
      //   158: lreturn
      //   159: lload 5
      //   161: aload_0
      //   162: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   165: getfield 106	b/a/b/b:i	Lokio/Buffer;
      //   168: invokevirtual 112	okio/Buffer:size	()J
      //   171: lsub
      //   172: lstore 7
      //   174: aload_0
      //   175: getfield 69	b/a/b/b$a:d	J
      //   178: lload 7
      //   180: lcmp
      //   181: ifge +12 -> 193
      //   184: iconst_2
      //   185: istore 4
      //   187: aload 9
      //   189: monitorexit
      //   190: goto -78 -> 112
      //   193: lload_2
      //   194: lload 5
      //   196: aload_0
      //   197: getfield 69	b/a/b/b$a:d	J
      //   200: lsub
      //   201: invokestatic 97	java/lang/Math:min	(JJ)J
      //   204: lstore_2
      //   205: aload_0
      //   206: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   209: getfield 106	b/a/b/b:i	Lokio/Buffer;
      //   212: aload_1
      //   213: aload_0
      //   214: getfield 69	b/a/b/b$a:d	J
      //   217: lload 7
      //   219: lsub
      //   220: lload_2
      //   221: invokevirtual 116	okio/Buffer:copyTo	(Lokio/Buffer;JJ)Lokio/Buffer;
      //   224: pop
      //   225: aload_0
      //   226: aload_0
      //   227: getfield 69	b/a/b/b$a:d	J
      //   230: lload_2
      //   231: ladd
      //   232: putfield 69	b/a/b/b$a:d	J
      //   235: aload 9
      //   237: monitorexit
      //   238: lload_2
      //   239: lreturn
      //   240: aload_0
      //   241: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   244: getfield 120	b/a/b/b:e	Lokio/Source;
      //   247: aload_0
      //   248: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   251: getfield 123	b/a/b/b:f	Lokio/Buffer;
      //   254: aload_0
      //   255: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   258: getfield 126	b/a/b/b:j	J
      //   261: invokeinterface 128 4 0
      //   266: lstore 7
      //   268: lload 7
      //   270: ldc2_w 77
      //   273: lcmp
      //   274: ifne +47 -> 321
      //   277: aload_0
      //   278: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   281: lload 5
      //   283: invokevirtual 131	b/a/b/b:a	(J)V
      //   286: aload_0
      //   287: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   290: astore_1
      //   291: aload_1
      //   292: monitorenter
      //   293: aload_0
      //   294: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   297: aconst_null
      //   298: putfield 81	b/a/b/b:d	Ljava/lang/Thread;
      //   301: aload_0
      //   302: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   305: invokevirtual 134	java/lang/Object:notifyAll	()V
      //   308: aload_1
      //   309: monitorexit
      //   310: ldc2_w 77
      //   313: lreturn
      //   314: astore 9
      //   316: aload_1
      //   317: monitorexit
      //   318: aload 9
      //   320: athrow
      //   321: lload 7
      //   323: lload_2
      //   324: invokestatic 97	java/lang/Math:min	(JJ)J
      //   327: lstore_2
      //   328: aload_0
      //   329: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   332: getfield 123	b/a/b/b:f	Lokio/Buffer;
      //   335: aload_1
      //   336: lconst_0
      //   337: lload_2
      //   338: invokevirtual 116	okio/Buffer:copyTo	(Lokio/Buffer;JJ)Lokio/Buffer;
      //   341: pop
      //   342: aload_0
      //   343: aload_0
      //   344: getfield 69	b/a/b/b$a:d	J
      //   347: lload_2
      //   348: ladd
      //   349: putfield 69	b/a/b/b$a:d	J
      //   352: aload_0
      //   353: getfield 44	b/a/b/b$a:c	Lb/a/b/a;
      //   356: ldc2_w 98
      //   359: lload 5
      //   361: ladd
      //   362: aload_0
      //   363: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   366: getfield 123	b/a/b/b:f	Lokio/Buffer;
      //   369: invokevirtual 138	okio/Buffer:clone	()Lokio/Buffer;
      //   372: lload 7
      //   374: invokevirtual 140	b/a/b/a:a	(JLokio/Buffer;J)V
      //   377: aload_0
      //   378: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   381: astore_1
      //   382: aload_1
      //   383: monitorenter
      //   384: aload_0
      //   385: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   388: getfield 106	b/a/b/b:i	Lokio/Buffer;
      //   391: aload_0
      //   392: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   395: getfield 123	b/a/b/b:f	Lokio/Buffer;
      //   398: lload 7
      //   400: invokevirtual 144	okio/Buffer:write	(Lokio/Buffer;J)V
      //   403: aload_0
      //   404: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   407: getfield 106	b/a/b/b:i	Lokio/Buffer;
      //   410: invokevirtual 112	okio/Buffer:size	()J
      //   413: aload_0
      //   414: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   417: getfield 126	b/a/b/b:j	J
      //   420: lcmp
      //   421: ifle +31 -> 452
      //   424: aload_0
      //   425: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   428: getfield 106	b/a/b/b:i	Lokio/Buffer;
      //   431: aload_0
      //   432: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   435: getfield 106	b/a/b/b:i	Lokio/Buffer;
      //   438: invokevirtual 112	okio/Buffer:size	()J
      //   441: aload_0
      //   442: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   445: getfield 126	b/a/b/b:j	J
      //   448: lsub
      //   449: invokevirtual 147	okio/Buffer:skip	(J)V
      //   452: aload_0
      //   453: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   456: astore 9
      //   458: aload 9
      //   460: aload 9
      //   462: getfield 72	b/a/b/b:g	J
      //   465: lload 7
      //   467: ladd
      //   468: putfield 72	b/a/b/b:g	J
      //   471: aload_1
      //   472: monitorexit
      //   473: aload_0
      //   474: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   477: astore_1
      //   478: aload_1
      //   479: monitorenter
      //   480: aload_0
      //   481: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   484: aconst_null
      //   485: putfield 81	b/a/b/b:d	Ljava/lang/Thread;
      //   488: aload_0
      //   489: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   492: invokevirtual 134	java/lang/Object:notifyAll	()V
      //   495: aload_1
      //   496: monitorexit
      //   497: lload_2
      //   498: lreturn
      //   499: astore 9
      //   501: aload_1
      //   502: monitorexit
      //   503: aload 9
      //   505: athrow
      //   506: astore 9
      //   508: aload_0
      //   509: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   512: astore_1
      //   513: aload_1
      //   514: monitorenter
      //   515: aload_0
      //   516: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   519: aconst_null
      //   520: putfield 81	b/a/b/b:d	Ljava/lang/Thread;
      //   523: aload_0
      //   524: getfield 20	b/a/b/b$a:a	Lb/a/b/b;
      //   527: invokevirtual 134	java/lang/Object:notifyAll	()V
      //   530: aload_1
      //   531: monitorexit
      //   532: aload 9
      //   534: athrow
      //   535: astore 9
      //   537: aload_1
      //   538: monitorexit
      //   539: aload 9
      //   541: athrow
      //   542: astore 9
      //   544: aload_1
      //   545: monitorexit
      //   546: aload 9
      //   548: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	549	0	this	a
      //   0	549	2	paramLong	long
      //   107	79	4	i	int
      //   39	321	5	l1	long
      //   30	436	7	l2	long
      //   21	215	9	localb1	b
      //   314	5	9	localObject1	Object
      //   456	5	9	localb2	b
      //   499	5	9	localObject2	Object
      //   506	27	9	localObject3	Object
      //   535	5	9	localObject4	Object
      //   542	5	9	localObject5	Object
      // Exception table:
      //   from	to	target	type
      //   26	41	90	finally
      //   49	62	90	finally
      //   66	87	90	finally
      //   91	94	90	finally
      //   96	106	90	finally
      //   109	112	90	finally
      //   159	184	90	finally
      //   187	190	90	finally
      //   193	238	90	finally
      //   293	310	314	finally
      //   316	318	314	finally
      //   384	452	499	finally
      //   452	473	499	finally
      //   501	503	499	finally
      //   240	268	506	finally
      //   277	286	506	finally
      //   321	384	506	finally
      //   503	506	506	finally
      //   480	497	535	finally
      //   537	539	535	finally
      //   515	532	542	finally
      //   544	546	542	finally
    }
    
    public Timeout timeout()
    {
      return this.b;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */