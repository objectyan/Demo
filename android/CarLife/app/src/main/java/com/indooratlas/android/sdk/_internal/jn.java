package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public abstract class jn
  extends jk
  implements jj, Runnable
{
  private InputStream a;
  private OutputStream b;
  private Proxy c = Proxy.NO_PROXY;
  private jo d;
  protected URI e = null;
  public jl f = null;
  public Socket g = null;
  public Thread h;
  private Map<String, String> j;
  private CountDownLatch k = new CountDownLatch(1);
  private CountDownLatch l = new CountDownLatch(1);
  private int m = 0;
  
  static
  {
    if (!jn.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      i = bool;
      return;
    }
  }
  
  public jn(URI paramURI, jo paramjo)
  {
    if (paramURI == null) {
      throw new IllegalArgumentException();
    }
    if (paramjo == null) {
      throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
    }
    this.e = paramURI;
    this.d = paramjo;
    this.j = null;
    this.m = 30000;
    this.f = new jl(this, paramjo);
  }
  
  private int b()
  {
    int i1 = this.e.getPort();
    int n = i1;
    String str;
    if (i1 == -1)
    {
      str = this.e.getScheme();
      if (str.equals("wss")) {
        n = 443;
      }
    }
    else
    {
      return n;
    }
    if (str.equals("ws")) {
      return 80;
    }
    throw new RuntimeException("unkonow scheme" + str);
  }
  
  private void j()
    throws jw
  {
    Object localObject2 = this.e.getPath();
    Object localObject3 = this.e.getQuery();
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject1 = "/";
    }
    localObject2 = localObject1;
    if (localObject3 != null) {
      localObject2 = (String)localObject1 + "?" + (String)localObject3;
    }
    int n = b();
    localObject3 = new StringBuilder().append(this.e.getHost());
    if (n != 80) {}
    for (Object localObject1 = ":" + n;; localObject1 = "")
    {
      localObject3 = (String)localObject1;
      localObject1 = new ki();
      ((ki)localObject1).a((String)localObject2);
      ((ki)localObject1).a("Host", (String)localObject3);
      if (this.j == null) {
        break;
      }
      localObject2 = this.j.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((ki)localObject1).a((String)((Map.Entry)localObject3).getKey(), (String)((Map.Entry)localObject3).getValue());
      }
    }
    localObject2 = this.f;
    if ((!jl.p) && (((jl)localObject2).i == jj.a.b)) {
      throw new AssertionError("shall only be called once");
    }
    ((jl)localObject2).n = ((jl)localObject2).k.a((kg)localObject1);
    ((jl)localObject2).o = ((kg)localObject1).a();
    if ((!jl.p) && (((jl)localObject2).o == null)) {
      throw new AssertionError();
    }
    try
    {
      ((jl)localObject2).j.a((jj)localObject2, ((jl)localObject2).n);
      localObject1 = ((jl)localObject2).k;
      localObject1 = ((jl)localObject2).n;
      n = ((jl)localObject2).l;
      ((jl)localObject2).a(jo.b((kk)localObject1));
      return;
    }
    catch (ju localju)
    {
      throw new jw("Handshake data rejected by client.");
    }
    catch (RuntimeException localRuntimeException)
    {
      ((jl)localObject2).j.b(localRuntimeException);
      throw new jw("rejected because of" + localRuntimeException);
    }
  }
  
  public abstract void a();
  
  public abstract void a(int paramInt, String paramString, boolean paramBoolean);
  
  public void a(jj paramjj, int paramInt, String paramString, boolean paramBoolean) {}
  
  public void a(kd paramkd) {}
  
  public final void a(kk paramkk)
  {
    this.k.countDown();
    a((km)paramkk);
  }
  
  public abstract void a(km paramkm);
  
  public abstract void a(Exception paramException);
  
  public void a(ByteBuffer paramByteBuffer) {}
  
  public final void b(int paramInt, String paramString, boolean paramBoolean)
  {
    this.k.countDown();
    this.l.countDown();
    if (this.h != null) {
      this.h.interrupt();
    }
    try
    {
      if (this.g != null) {
        this.g.close();
      }
      a(paramInt, paramString, paramBoolean);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        a(localIOException);
      }
    }
  }
  
  public final void b(kd paramkd)
  {
    this.f.b(paramkd);
  }
  
  public final void b(Exception paramException)
  {
    a(paramException);
  }
  
  public final void b(ByteBuffer paramByteBuffer)
  {
    a(paramByteBuffer);
  }
  
  public final InetSocketAddress c()
  {
    return this.f.c();
  }
  
  public final void c(kd paramkd)
  {
    a(paramkd);
  }
  
  public final boolean d()
  {
    return this.f.d();
  }
  
  public final boolean e()
  {
    return this.f.e();
  }
  
  public final boolean f()
  {
    return this.f.f();
  }
  
  public final void h()
  {
    a();
  }
  
  public final InetSocketAddress i()
  {
    if (this.g != null) {
      return (InetSocketAddress)this.g.getLocalSocketAddress();
    }
    return null;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 57	com/indooratlas/android/sdk/_internal/jn:g	Ljava/net/Socket;
    //   4: ifnonnull +208 -> 212
    //   7: aload_0
    //   8: new 289	java/net/Socket
    //   11: dup
    //   12: aload_0
    //   13: getfield 64	com/indooratlas/android/sdk/_internal/jn:c	Ljava/net/Proxy;
    //   16: invokespecial 325	java/net/Socket:<init>	(Ljava/net/Proxy;)V
    //   19: putfield 57	com/indooratlas/android/sdk/_internal/jn:g	Ljava/net/Socket;
    //   22: aload_0
    //   23: getfield 57	com/indooratlas/android/sdk/_internal/jn:g	Ljava/net/Socket;
    //   26: invokevirtual 328	java/net/Socket:isBound	()Z
    //   29: ifne +32 -> 61
    //   32: aload_0
    //   33: getfield 57	com/indooratlas/android/sdk/_internal/jn:g	Ljava/net/Socket;
    //   36: new 319	java/net/InetSocketAddress
    //   39: dup
    //   40: aload_0
    //   41: getfield 53	com/indooratlas/android/sdk/_internal/jn:e	Ljava/net/URI;
    //   44: invokevirtual 155	java/net/URI:getHost	()Ljava/lang/String;
    //   47: aload_0
    //   48: invokespecial 152	com/indooratlas/android/sdk/_internal/jn:b	()I
    //   51: invokespecial 331	java/net/InetSocketAddress:<init>	(Ljava/lang/String;I)V
    //   54: aload_0
    //   55: getfield 75	com/indooratlas/android/sdk/_internal/jn:m	I
    //   58: invokevirtual 335	java/net/Socket:connect	(Ljava/net/SocketAddress;I)V
    //   61: aload_0
    //   62: aload_0
    //   63: getfield 57	com/indooratlas/android/sdk/_internal/jn:g	Ljava/net/Socket;
    //   66: invokevirtual 339	java/net/Socket:getInputStream	()Ljava/io/InputStream;
    //   69: putfield 341	com/indooratlas/android/sdk/_internal/jn:a	Ljava/io/InputStream;
    //   72: aload_0
    //   73: aload_0
    //   74: getfield 57	com/indooratlas/android/sdk/_internal/jn:g	Ljava/net/Socket;
    //   77: invokevirtual 345	java/net/Socket:getOutputStream	()Ljava/io/OutputStream;
    //   80: putfield 132	com/indooratlas/android/sdk/_internal/jn:b	Ljava/io/OutputStream;
    //   83: aload_0
    //   84: invokespecial 347	com/indooratlas/android/sdk/_internal/jn:j	()V
    //   87: aload_0
    //   88: new 284	java/lang/Thread
    //   91: dup
    //   92: new 10	com/indooratlas/android/sdk/_internal/jn$a
    //   95: dup
    //   96: aload_0
    //   97: iconst_0
    //   98: invokespecial 350	com/indooratlas/android/sdk/_internal/jn$a:<init>	(Lcom/indooratlas/android/sdk/_internal/jn;B)V
    //   101: invokespecial 353	java/lang/Thread:<init>	(Ljava/lang/Runnable;)V
    //   104: putfield 282	com/indooratlas/android/sdk/_internal/jn:h	Ljava/lang/Thread;
    //   107: aload_0
    //   108: getfield 282	com/indooratlas/android/sdk/_internal/jn:h	Ljava/lang/Thread;
    //   111: invokevirtual 356	java/lang/Thread:start	()V
    //   114: getstatic 358	com/indooratlas/android/sdk/_internal/jl:a	I
    //   117: newarray <illegal type>
    //   119: astore_3
    //   120: aload_0
    //   121: getfield 55	com/indooratlas/android/sdk/_internal/jn:f	Lcom/indooratlas/android/sdk/_internal/jl;
    //   124: invokevirtual 311	com/indooratlas/android/sdk/_internal/jl:f	()Z
    //   127: ifne +391 -> 518
    //   130: aload_0
    //   131: getfield 341	com/indooratlas/android/sdk/_internal/jn:a	Ljava/io/InputStream;
    //   134: aload_3
    //   135: invokevirtual 364	java/io/InputStream:read	([B)I
    //   138: istore_1
    //   139: iload_1
    //   140: iconst_m1
    //   141: if_icmpeq +377 -> 518
    //   144: aload_0
    //   145: getfield 55	com/indooratlas/android/sdk/_internal/jn:f	Lcom/indooratlas/android/sdk/_internal/jl;
    //   148: astore 4
    //   150: aload_3
    //   151: iconst_0
    //   152: iload_1
    //   153: invokestatic 370	java/nio/ByteBuffer:wrap	([BII)Ljava/nio/ByteBuffer;
    //   156: astore 5
    //   158: getstatic 204	com/indooratlas/android/sdk/_internal/jl:p	Z
    //   161: ifne +89 -> 250
    //   164: aload 5
    //   166: invokevirtual 373	java/nio/ByteBuffer:hasRemaining	()Z
    //   169: ifne +81 -> 250
    //   172: new 212	java/lang/AssertionError
    //   175: dup
    //   176: invokespecial 237	java/lang/AssertionError:<init>	()V
    //   179: athrow
    //   180: astore_2
    //   181: aload_0
    //   182: getfield 55	com/indooratlas/android/sdk/_internal/jn:f	Lcom/indooratlas/android/sdk/_internal/jl;
    //   185: invokevirtual 374	com/indooratlas/android/sdk/_internal/jl:a	()V
    //   188: getstatic 46	com/indooratlas/android/sdk/_internal/jn:i	Z
    //   191: ifne +58 -> 249
    //   194: aload_0
    //   195: getfield 57	com/indooratlas/android/sdk/_internal/jn:g	Ljava/net/Socket;
    //   198: invokevirtual 377	java/net/Socket:isClosed	()Z
    //   201: ifne +48 -> 249
    //   204: new 212	java/lang/AssertionError
    //   207: dup
    //   208: invokespecial 237	java/lang/AssertionError:<init>	()V
    //   211: athrow
    //   212: aload_0
    //   213: getfield 57	com/indooratlas/android/sdk/_internal/jn:g	Ljava/net/Socket;
    //   216: invokevirtual 377	java/net/Socket:isClosed	()Z
    //   219: ifeq -197 -> 22
    //   222: new 280	java/io/IOException
    //   225: dup
    //   226: invokespecial 378	java/io/IOException:<init>	()V
    //   229: athrow
    //   230: astore_2
    //   231: aload_0
    //   232: aload_2
    //   233: invokevirtual 296	com/indooratlas/android/sdk/_internal/jn:a	(Ljava/lang/Exception;)V
    //   236: aload_0
    //   237: getfield 55	com/indooratlas/android/sdk/_internal/jn:f	Lcom/indooratlas/android/sdk/_internal/jl;
    //   240: iconst_m1
    //   241: aload_2
    //   242: invokevirtual 381	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   245: iconst_0
    //   246: invokevirtual 383	com/indooratlas/android/sdk/_internal/jl:b	(ILjava/lang/String;Z)V
    //   249: return
    //   250: getstatic 385	com/indooratlas/android/sdk/_internal/jl:b	Z
    //   253: ifeq +69 -> 322
    //   256: getstatic 391	java/lang/System:out	Ljava/io/PrintStream;
    //   259: astore 6
    //   261: new 118	java/lang/StringBuilder
    //   264: dup
    //   265: ldc_w 393
    //   268: invokespecial 121	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   271: aload 5
    //   273: invokevirtual 396	java/nio/ByteBuffer:remaining	()I
    //   276: invokevirtual 160	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   279: ldc_w 398
    //   282: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: astore 7
    //   287: aload 5
    //   289: invokevirtual 396	java/nio/ByteBuffer:remaining	()I
    //   292: sipush 1000
    //   295: if_icmple +107 -> 402
    //   298: ldc_w 400
    //   301: astore_2
    //   302: aload 6
    //   304: aload 7
    //   306: aload_2
    //   307: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: ldc_w 402
    //   313: invokevirtual 125	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: invokevirtual 128	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   319: invokevirtual 407	java/io/PrintStream:println	(Ljava/lang/String;)V
    //   322: aload 4
    //   324: getfield 206	com/indooratlas/android/sdk/_internal/jl:i	I
    //   327: getstatic 408	com/indooratlas/android/sdk/_internal/jj$a:a	I
    //   330: if_icmpeq +98 -> 428
    //   333: aload 4
    //   335: aload 5
    //   337: invokevirtual 410	com/indooratlas/android/sdk/_internal/jl:b	(Ljava/nio/ByteBuffer;)V
    //   340: getstatic 204	com/indooratlas/android/sdk/_internal/jl:p	Z
    //   343: ifne -223 -> 120
    //   346: aload 4
    //   348: invokevirtual 309	com/indooratlas/android/sdk/_internal/jl:e	()Z
    //   351: ifne -231 -> 120
    //   354: aload 4
    //   356: getfield 412	com/indooratlas/android/sdk/_internal/jl:h	Z
    //   359: ifne -239 -> 120
    //   362: aload 5
    //   364: invokevirtual 373	java/nio/ByteBuffer:hasRemaining	()Z
    //   367: ifeq -247 -> 120
    //   370: new 212	java/lang/AssertionError
    //   373: dup
    //   374: invokespecial 237	java/lang/AssertionError:<init>	()V
    //   377: athrow
    //   378: astore_2
    //   379: aload_0
    //   380: aload_2
    //   381: invokevirtual 296	com/indooratlas/android/sdk/_internal/jn:a	(Ljava/lang/Exception;)V
    //   384: aload_0
    //   385: getfield 55	com/indooratlas/android/sdk/_internal/jn:f	Lcom/indooratlas/android/sdk/_internal/jl;
    //   388: sipush 1006
    //   391: aload_2
    //   392: invokevirtual 413	java/lang/RuntimeException:getMessage	()Ljava/lang/String;
    //   395: iconst_0
    //   396: invokevirtual 383	com/indooratlas/android/sdk/_internal/jl:b	(ILjava/lang/String;Z)V
    //   399: goto -211 -> 188
    //   402: new 108	java/lang/String
    //   405: dup
    //   406: aload 5
    //   408: invokevirtual 417	java/nio/ByteBuffer:array	()[B
    //   411: aload 5
    //   413: invokevirtual 420	java/nio/ByteBuffer:position	()I
    //   416: aload 5
    //   418: invokevirtual 396	java/nio/ByteBuffer:remaining	()I
    //   421: invokespecial 423	java/lang/String:<init>	([BII)V
    //   424: astore_2
    //   425: goto -123 -> 302
    //   428: aload 4
    //   430: aload 5
    //   432: invokevirtual 426	com/indooratlas/android/sdk/_internal/jl:a	(Ljava/nio/ByteBuffer;)Z
    //   435: ifeq -95 -> 340
    //   438: getstatic 204	com/indooratlas/android/sdk/_internal/jl:p	Z
    //   441: ifne +35 -> 476
    //   444: aload 4
    //   446: getfield 429	com/indooratlas/android/sdk/_internal/jl:m	Ljava/nio/ByteBuffer;
    //   449: invokevirtual 373	java/nio/ByteBuffer:hasRemaining	()Z
    //   452: aload 5
    //   454: invokevirtual 373	java/nio/ByteBuffer:hasRemaining	()Z
    //   457: if_icmpne +19 -> 476
    //   460: aload 5
    //   462: invokevirtual 373	java/nio/ByteBuffer:hasRemaining	()Z
    //   465: ifeq +11 -> 476
    //   468: new 212	java/lang/AssertionError
    //   471: dup
    //   472: invokespecial 237	java/lang/AssertionError:<init>	()V
    //   475: athrow
    //   476: aload 5
    //   478: invokevirtual 373	java/nio/ByteBuffer:hasRemaining	()Z
    //   481: ifeq +13 -> 494
    //   484: aload 4
    //   486: aload 5
    //   488: invokevirtual 410	com/indooratlas/android/sdk/_internal/jl:b	(Ljava/nio/ByteBuffer;)V
    //   491: goto -151 -> 340
    //   494: aload 4
    //   496: getfield 429	com/indooratlas/android/sdk/_internal/jl:m	Ljava/nio/ByteBuffer;
    //   499: invokevirtual 373	java/nio/ByteBuffer:hasRemaining	()Z
    //   502: ifeq -162 -> 340
    //   505: aload 4
    //   507: aload 4
    //   509: getfield 429	com/indooratlas/android/sdk/_internal/jl:m	Ljava/nio/ByteBuffer;
    //   512: invokevirtual 410	com/indooratlas/android/sdk/_internal/jl:b	(Ljava/nio/ByteBuffer;)V
    //   515: goto -175 -> 340
    //   518: aload_0
    //   519: getfield 55	com/indooratlas/android/sdk/_internal/jn:f	Lcom/indooratlas/android/sdk/_internal/jl;
    //   522: invokevirtual 374	com/indooratlas/android/sdk/_internal/jl:a	()V
    //   525: goto -337 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	528	0	this	jn
    //   138	15	1	n	int
    //   180	1	2	localIOException	IOException
    //   230	12	2	localException	Exception
    //   301	6	2	str1	String
    //   378	14	2	localRuntimeException	RuntimeException
    //   424	1	2	str2	String
    //   119	32	3	arrayOfByte	byte[]
    //   148	360	4	localjl	jl
    //   156	331	5	localByteBuffer	ByteBuffer
    //   259	44	6	localPrintStream	java.io.PrintStream
    //   285	20	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   120	139	180	java/io/IOException
    //   144	180	180	java/io/IOException
    //   250	298	180	java/io/IOException
    //   302	322	180	java/io/IOException
    //   322	340	180	java/io/IOException
    //   340	378	180	java/io/IOException
    //   402	425	180	java/io/IOException
    //   428	476	180	java/io/IOException
    //   476	491	180	java/io/IOException
    //   494	515	180	java/io/IOException
    //   518	525	180	java/io/IOException
    //   0	22	230	java/lang/Exception
    //   22	61	230	java/lang/Exception
    //   61	87	230	java/lang/Exception
    //   212	230	230	java/lang/Exception
    //   120	139	378	java/lang/RuntimeException
    //   144	180	378	java/lang/RuntimeException
    //   250	298	378	java/lang/RuntimeException
    //   302	322	378	java/lang/RuntimeException
    //   322	340	378	java/lang/RuntimeException
    //   340	378	378	java/lang/RuntimeException
    //   402	425	378	java/lang/RuntimeException
    //   428	476	378	java/lang/RuntimeException
    //   476	491	378	java/lang/RuntimeException
    //   494	515	378	java/lang/RuntimeException
    //   518	525	378	java/lang/RuntimeException
  }
  
  final class a
    implements Runnable
  {
    private a() {}
    
    public final void run()
    {
      Thread.currentThread().setName("WebsocketWriteThread");
      try
      {
        while (!Thread.interrupted())
        {
          ByteBuffer localByteBuffer = (ByteBuffer)jn.a(jn.this).f.take();
          jn.b(jn.this).write(localByteBuffer.array(), 0, localByteBuffer.limit());
          jn.b(jn.this).flush();
        }
        return;
      }
      catch (IOException localIOException)
      {
        jn.a(jn.this).a();
        return;
      }
      catch (InterruptedException localInterruptedException) {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/jn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */