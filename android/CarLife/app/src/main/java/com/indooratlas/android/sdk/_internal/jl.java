package com.indooratlas.android.sdk._internal;

import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class jl
  implements jj
{
  public static int a;
  public static boolean b;
  public static final List<jo> c;
  public SelectionKey d;
  public ByteChannel e;
  public final BlockingQueue<ByteBuffer> f;
  public final BlockingQueue<ByteBuffer> g;
  public volatile boolean h = false;
  public int i = jj.a.a;
  public final jm j;
  public jo k = null;
  public int l;
  public ByteBuffer m = ByteBuffer.allocate(0);
  public kf n = null;
  public String o = null;
  private List<jo> q;
  private kd.a r = null;
  private String s = null;
  private Integer t = null;
  private Boolean u = null;
  
  static
  {
    if (!jl.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      p = bool;
      a = 16384;
      b = false;
      ArrayList localArrayList = new ArrayList(4);
      c = localArrayList;
      localArrayList.add(new jq());
      c.add(new jp());
      c.add(new js());
      c.add(new jr());
      return;
    }
  }
  
  public jl(jm paramjm, jo paramjo)
  {
    if ((paramjm == null) || ((paramjo == null) && (this.l == jj.b.b))) {
      throw new IllegalArgumentException("parameters must not be null");
    }
    this.f = new LinkedBlockingQueue();
    this.g = new LinkedBlockingQueue();
    this.j = paramjm;
    this.l = jj.b.a;
    if (paramjo != null) {
      this.k = paramjo.c();
    }
  }
  
  private void a(int paramInt)
  {
    b(paramInt, "", true);
  }
  
  private void a(ju paramju)
  {
    a(paramju.a, paramju.getMessage(), false);
  }
  
  private void a(kk paramkk)
  {
    if (b) {
      System.out.println("open using draft: " + this.k.getClass().getSimpleName());
    }
    this.i = jj.a.c;
    try
    {
      this.j.a(paramkk);
      return;
    }
    catch (RuntimeException paramkk)
    {
      this.j.b(paramkk);
    }
  }
  
  /* Error */
  private void c(int paramInt, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 89	com/indooratlas/android/sdk/_internal/jl:h	Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: iload_1
    //   18: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   21: putfield 112	com/indooratlas/android/sdk/_internal/jl:t	Ljava/lang/Integer;
    //   24: aload_0
    //   25: aload_2
    //   26: putfield 110	com/indooratlas/android/sdk/_internal/jl:s	Ljava/lang/String;
    //   29: aload_0
    //   30: iload_3
    //   31: invokestatic 212	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   34: putfield 114	com/indooratlas/android/sdk/_internal/jl:u	Ljava/lang/Boolean;
    //   37: aload_0
    //   38: iconst_1
    //   39: putfield 89	com/indooratlas/android/sdk/_internal/jl:h	Z
    //   42: aload_0
    //   43: getfield 138	com/indooratlas/android/sdk/_internal/jl:j	Lcom/indooratlas/android/sdk/_internal/jm;
    //   46: aload_0
    //   47: iload_1
    //   48: aload_2
    //   49: iload_3
    //   50: invokeinterface 215 5 0
    //   55: aload_0
    //   56: getfield 96	com/indooratlas/android/sdk/_internal/jl:k	Lcom/indooratlas/android/sdk/_internal/jo;
    //   59: ifnull +10 -> 69
    //   62: aload_0
    //   63: getfield 96	com/indooratlas/android/sdk/_internal/jl:k	Lcom/indooratlas/android/sdk/_internal/jo;
    //   66: invokevirtual 217	com/indooratlas/android/sdk/_internal/jo:a	()V
    //   69: aload_0
    //   70: aconst_null
    //   71: putfield 108	com/indooratlas/android/sdk/_internal/jl:n	Lcom/indooratlas/android/sdk/_internal/kf;
    //   74: goto -61 -> 13
    //   77: astore_2
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_2
    //   81: athrow
    //   82: astore_2
    //   83: aload_0
    //   84: getfield 138	com/indooratlas/android/sdk/_internal/jl:j	Lcom/indooratlas/android/sdk/_internal/jm;
    //   87: aload_2
    //   88: invokeinterface 201 2 0
    //   93: goto -38 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	jl
    //   0	96	1	paramInt	int
    //   0	96	2	paramString	String
    //   0	96	3	paramBoolean	boolean
    //   6	3	4	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	8	77	finally
    //   16	42	77	finally
    //   42	55	77	finally
    //   55	69	77	finally
    //   69	74	77	finally
    //   83	93	77	finally
    //   42	55	82	java/lang/RuntimeException
  }
  
  private void c(ByteBuffer paramByteBuffer)
  {
    PrintStream localPrintStream;
    StringBuilder localStringBuilder;
    if (b)
    {
      localPrintStream = System.out;
      localStringBuilder = new StringBuilder("write(").append(paramByteBuffer.remaining()).append("): {");
      if (paramByteBuffer.remaining() <= 1000) {
        break label76;
      }
    }
    label76:
    for (String str = "too big to display";; str = new String(paramByteBuffer.array()))
    {
      localPrintStream.println(str + "}");
      this.f.add(paramByteBuffer);
      return;
    }
  }
  
  public final void a()
  {
    if (this.i == jj.a.a)
    {
      a(-1);
      return;
    }
    if (this.h)
    {
      b(this.t.intValue(), this.s, this.u.booleanValue());
      return;
    }
    if (this.k.b() == jo.a.a)
    {
      a(1000);
      return;
    }
    if ((this.k.b() == jo.a.b) && (this.l != jj.b.b))
    {
      a(1000);
      return;
    }
    a(1006);
  }
  
  public final void a(int paramInt, String paramString, boolean paramBoolean)
  {
    if ((this.i != jj.a.d) && (this.i != jj.a.e))
    {
      if (this.i != jj.a.c) {
        break label157;
      }
      if (paramInt == 1006)
      {
        if ((!p) && (paramBoolean)) {
          throw new AssertionError();
        }
        this.i = jj.a.d;
        c(paramInt, paramString, false);
      }
    }
    else
    {
      return;
    }
    if (this.k.b() != jo.a.a) {}
    for (;;)
    {
      try
      {
        b(new kb(paramInt, paramString));
        c(paramInt, paramString, paramBoolean);
        if (paramInt == 1002) {
          c(paramInt, paramString, paramBoolean);
        }
        this.i = jj.a.d;
        this.m = null;
        return;
      }
      catch (ju localju)
      {
        this.j.b(localju);
        c(1006, "generated frame is invalid", false);
        continue;
      }
      label157:
      if (paramInt == -3)
      {
        if ((!p) && (!paramBoolean)) {
          throw new AssertionError();
        }
        c(-3, paramString, true);
      }
      else
      {
        c(-1, paramString, false);
      }
    }
  }
  
  public final void a(Collection<kd> paramCollection)
  {
    if (!d()) {
      throw new jz();
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      b((kd)paramCollection.next());
    }
  }
  
  public final void a(List<ByteBuffer> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      c((ByteBuffer)paramList.next());
    }
  }
  
  public final boolean a(ByteBuffer paramByteBuffer)
  {
    ByteBuffer localByteBuffer;
    if (this.m.capacity() == 0) {
      localByteBuffer = paramByteBuffer;
    }
    for (;;)
    {
      localByteBuffer.mark();
      try
      {
        if (this.k == null)
        {
          localByteBuffer.mark();
          if (localByteBuffer.limit() > jo.c.length)
          {
            i1 = jo.b.b;
            i2 = jo.b.a;
            if (i1 != i2) {
              break label308;
            }
          }
        }
      }
      catch (jt localjt)
      {
        for (;;)
        {
          int i1;
          int i2;
          try
          {
            c(ByteBuffer.wrap(kp.a(this.j.a(this))));
            a(-3, "", false);
            return false;
            if (this.m.remaining() < paramByteBuffer.remaining())
            {
              localByteBuffer = ByteBuffer.allocate(this.m.capacity() + paramByteBuffer.remaining());
              this.m.flip();
              localByteBuffer.put(this.m);
              this.m = localByteBuffer;
            }
            this.m.put(paramByteBuffer);
            this.m.flip();
            localByteBuffer = this.m;
            break;
            if (localByteBuffer.limit() < jo.c.length)
            {
              throw new jt(jo.c.length);
              localjt = localjt;
              if (this.m.capacity() != 0) {
                break label785;
              }
              localByteBuffer.reset();
              i2 = localjt.a;
              if (i2 == 0)
              {
                i1 = localByteBuffer.capacity() + 16;
                this.m = ByteBuffer.allocate(i1);
                this.m.put(paramByteBuffer);
                label247:
                return false;
              }
            }
            else
            {
              i1 = 0;
              if (localByteBuffer.hasRemaining())
              {
                if (jo.c[i1] == localByteBuffer.get()) {
                  break label823;
                }
                localByteBuffer.reset();
                i1 = jo.b.b;
                continue;
              }
              i1 = jo.b.a;
            }
          }
          catch (ju localju1)
          {
            a(1006, "remote peer closed connection before flashpolicy could be transmitted", true);
            continue;
          }
          for (;;)
          {
            try
            {
              label308:
              if (this.l == jj.b.b) {
                if (this.k == null)
                {
                  localObject1 = this.q.iterator();
                  if (((Iterator)localObject1).hasNext()) {
                    localjo = ((jo)((Iterator)localObject1).next()).c();
                  }
                }
              }
            }
            catch (jw localjw1)
            {
              Object localObject1;
              jo localjo;
              Object localObject2;
              a(localjw1);
            }
            try
            {
              localjo.b(this.l);
              localByteBuffer.reset();
              localObject2 = localjo.b(localByteBuffer);
              if (!(localObject2 instanceof kf))
              {
                c(1002, "wrong http function", false);
                return false;
              }
              localObject2 = (kf)localObject2;
              if (localjo.a((kf)localObject2) != jo.b.a) {
                continue;
              }
              this.o = ((kf)localObject2).a();
              try
              {
                kn localkn = this.j.g();
                a(jo.b(localjo.a((kf)localObject2, localkn)));
                this.k = localjo;
                a((kk)localObject2);
                return true;
              }
              catch (ju localju2)
              {
                c(localju2.a, localju2.getMessage(), false);
                return false;
              }
              catch (RuntimeException localRuntimeException)
              {
                this.j.b(localRuntimeException);
                c(-1, localRuntimeException.getMessage(), false);
                return false;
              }
              if (this.k != null) {
                break label830;
              }
              a(1002, "no draft matches", false);
            }
            catch (jw localjw2) {}
            localObject1 = this.k.b(localByteBuffer);
            if (!(localObject1 instanceof kf))
            {
              c(1002, "wrong http function", false);
              return false;
            }
            localObject1 = (kf)localObject1;
            if (this.k.a((kf)localObject1) == jo.b.a)
            {
              a((kk)localObject1);
              return true;
            }
            a(1002, "the handshake did finaly not match", false);
            return false;
            if (this.l != jj.b.a) {
              break label247;
            }
            this.k.b(this.l);
            localObject1 = this.k.b(localByteBuffer);
            if (!(localObject1 instanceof km))
            {
              c(1002, "wrong http function", false);
              return false;
            }
            localObject1 = (km)localObject1;
            if (this.k.a(this.n, (km)localObject1) == jo.b.a)
            {
              a((kk)localObject1);
              return true;
            }
            a(1002, "draft " + this.k + " refuses handshake", false);
            break label247;
            break label247;
            i1 = i2;
            if (p) {
              break;
            }
            i1 = i2;
            if (localjw1.a >= localByteBuffer.remaining()) {
              break;
            }
            throw new AssertionError();
            label785:
            this.m.position(this.m.limit());
            this.m.limit(this.m.capacity());
            break label247;
          }
          label823:
          i1 += 1;
        }
      }
    }
    label830:
    return false;
  }
  
  /* Error */
  public final void b(int paramInt, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 94	com/indooratlas/android/sdk/_internal/jl:i	I
    //   6: istore 4
    //   8: getstatic 263	com/indooratlas/android/sdk/_internal/jj$a:e	I
    //   11: istore 5
    //   13: iload 4
    //   15: iload 5
    //   17: if_icmpne +6 -> 23
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 420	com/indooratlas/android/sdk/_internal/jl:d	Ljava/nio/channels/SelectionKey;
    //   27: ifnull +10 -> 37
    //   30: aload_0
    //   31: getfield 420	com/indooratlas/android/sdk/_internal/jl:d	Ljava/nio/channels/SelectionKey;
    //   34: invokevirtual 425	java/nio/channels/SelectionKey:cancel	()V
    //   37: aload_0
    //   38: getfield 427	com/indooratlas/android/sdk/_internal/jl:e	Ljava/nio/channels/ByteChannel;
    //   41: astore 6
    //   43: aload 6
    //   45: ifnull +12 -> 57
    //   48: aload_0
    //   49: getfield 427	com/indooratlas/android/sdk/_internal/jl:e	Ljava/nio/channels/ByteChannel;
    //   52: invokeinterface 432 1 0
    //   57: aload_0
    //   58: getfield 138	com/indooratlas/android/sdk/_internal/jl:j	Lcom/indooratlas/android/sdk/_internal/jm;
    //   61: iload_1
    //   62: aload_2
    //   63: iload_3
    //   64: invokeinterface 433 4 0
    //   69: aload_0
    //   70: getfield 96	com/indooratlas/android/sdk/_internal/jl:k	Lcom/indooratlas/android/sdk/_internal/jo;
    //   73: ifnull +10 -> 83
    //   76: aload_0
    //   77: getfield 96	com/indooratlas/android/sdk/_internal/jl:k	Lcom/indooratlas/android/sdk/_internal/jo;
    //   80: invokevirtual 217	com/indooratlas/android/sdk/_internal/jo:a	()V
    //   83: aload_0
    //   84: aconst_null
    //   85: putfield 108	com/indooratlas/android/sdk/_internal/jl:n	Lcom/indooratlas/android/sdk/_internal/kf;
    //   88: aload_0
    //   89: getstatic 263	com/indooratlas/android/sdk/_internal/jj$a:e	I
    //   92: putfield 94	com/indooratlas/android/sdk/_internal/jl:i	I
    //   95: aload_0
    //   96: getfield 134	com/indooratlas/android/sdk/_internal/jl:f	Ljava/util/concurrent/BlockingQueue;
    //   99: invokeinterface 436 1 0
    //   104: goto -84 -> 20
    //   107: astore_2
    //   108: aload_0
    //   109: monitorexit
    //   110: aload_2
    //   111: athrow
    //   112: astore 6
    //   114: aload_0
    //   115: getfield 138	com/indooratlas/android/sdk/_internal/jl:j	Lcom/indooratlas/android/sdk/_internal/jm;
    //   118: aload 6
    //   120: invokeinterface 201 2 0
    //   125: goto -68 -> 57
    //   128: astore_2
    //   129: aload_0
    //   130: getfield 138	com/indooratlas/android/sdk/_internal/jl:j	Lcom/indooratlas/android/sdk/_internal/jm;
    //   133: aload_2
    //   134: invokeinterface 201 2 0
    //   139: goto -70 -> 69
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	jl
    //   0	142	1	paramInt	int
    //   0	142	2	paramString	String
    //   0	142	3	paramBoolean	boolean
    //   6	12	4	i1	int
    //   11	7	5	i2	int
    //   41	3	6	localByteChannel	ByteChannel
    //   112	7	6	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   2	13	107	finally
    //   23	37	107	finally
    //   37	43	107	finally
    //   48	57	107	finally
    //   57	69	107	finally
    //   69	83	107	finally
    //   83	104	107	finally
    //   114	125	107	finally
    //   129	139	107	finally
    //   48	57	112	java/io/IOException
    //   57	69	128	java/lang/RuntimeException
  }
  
  public final void b(kd paramkd)
  {
    if (b) {
      System.out.println("send frame: " + paramkd);
    }
    c(this.k.a(paramkd));
  }
  
  public final void b(ByteBuffer paramByteBuffer)
  {
    for (;;)
    {
      Object localObject;
      boolean bool;
      int i1;
      try
      {
        Iterator localIterator = this.k.a(paramByteBuffer).iterator();
        if (localIterator.hasNext())
        {
          paramByteBuffer = (kd)localIterator.next();
          if (b) {
            System.out.println("matched frame: " + paramByteBuffer);
          }
          localObject = paramByteBuffer.f();
          bool = paramByteBuffer.d();
          if (localObject != kd.a.f) {
            break label184;
          }
          if (!(paramByteBuffer instanceof ka)) {
            break label487;
          }
          paramByteBuffer = (ka)paramByteBuffer;
          i1 = paramByteBuffer.a();
          paramByteBuffer = paramByteBuffer.b();
          if (this.i == jj.a.d) {
            b(i1, paramByteBuffer, true);
          }
        }
        else
        {
          return;
        }
      }
      catch (ju paramByteBuffer)
      {
        this.j.b(paramByteBuffer);
        a(paramByteBuffer);
      }
      if (this.k.b() == jo.a.c)
      {
        a(i1, paramByteBuffer, true);
      }
      else
      {
        c(i1, paramByteBuffer, false);
        continue;
        label184:
        if (localObject == kd.a.d)
        {
          this.j.a(this, paramByteBuffer);
        }
        else if (localObject == kd.a.e)
        {
          this.j.b(this, paramByteBuffer);
        }
        else
        {
          if ((!bool) || (localObject == kd.a.a))
          {
            if (localObject != kd.a.a)
            {
              if (this.r != null) {
                throw new ju(1002, "Previous continuous frame sequence not completed.");
              }
              this.r = ((kd.a)localObject);
            }
            label335:
            do
            {
              for (;;)
              {
                try
                {
                  this.j.c(paramByteBuffer);
                }
                catch (RuntimeException paramByteBuffer)
                {
                  this.j.b(paramByteBuffer);
                }
                break;
                if (!bool) {
                  break label335;
                }
                if (this.r == null) {
                  throw new ju(1002, "Continuous frame sequence was not started.");
                }
                this.r = null;
              }
            } while (this.r != null);
            throw new ju(1002, "Continuous frame sequence was not started.");
          }
          if (this.r != null) {
            throw new ju(1002, "Continuous frame sequence not completed.");
          }
          kd.a locala = kd.a.b;
          if (localObject == locala)
          {
            try
            {
              localObject = this.j;
              kp.a(paramByteBuffer.c());
              ((jm)localObject).h();
            }
            catch (RuntimeException paramByteBuffer)
            {
              this.j.b(paramByteBuffer);
            }
          }
          else
          {
            locala = kd.a.c;
            if (localObject == locala)
            {
              try
              {
                this.j.b(paramByteBuffer.c());
              }
              catch (RuntimeException paramByteBuffer)
              {
                this.j.b(paramByteBuffer);
              }
            }
            else
            {
              throw new ju(1002, "non control or continious frame expected");
              label487:
              paramByteBuffer = "";
              i1 = 1005;
            }
          }
        }
      }
    }
  }
  
  public final InetSocketAddress c()
  {
    return this.j.i();
  }
  
  public final boolean d()
  {
    if ((!p) && (this.i == jj.a.c) && (this.h)) {
      throw new AssertionError();
    }
    return this.i == jj.a.c;
  }
  
  public final boolean e()
  {
    return this.i == jj.a.d;
  }
  
  public final boolean f()
  {
    return this.i == jj.a.e;
  }
  
  public int hashCode()
  {
    return super.hashCode();
  }
  
  public String toString()
  {
    return super.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/_internal/jl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */