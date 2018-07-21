package com.facebook.imagepipeline.i;

import android.util.Pair;
import com.facebook.common.internal.k;
import com.facebook.common.internal.m;
import com.facebook.f.c;
import com.facebook.imagepipeline.memory.aa;
import com.facebook.imagepipeline.memory.y;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@Immutable
public class d
  implements Closeable
{
  public static final int a = -1;
  public static final int b = -1;
  public static final int c = -1;
  public static final int d = -1;
  public static final int e = 1;
  @Nullable
  private final com.facebook.common.h.a<y> f;
  @Nullable
  private final m<FileInputStream> g;
  private com.facebook.f.b h = com.facebook.f.b.j;
  private int i = -1;
  private int j = -1;
  private int k = -1;
  private int l = 1;
  private int m = -1;
  
  public d(com.facebook.common.h.a<y> parama)
  {
    k.a(com.facebook.common.h.a.a(parama));
    this.f = parama.b();
    this.g = null;
  }
  
  public d(m<FileInputStream> paramm)
  {
    k.a(paramm);
    this.f = null;
    this.g = paramm;
  }
  
  public d(m<FileInputStream> paramm, int paramInt)
  {
    this(paramm);
    this.m = paramInt;
  }
  
  public static d a(d paramd)
  {
    if (paramd != null) {
      return paramd.a();
    }
    return null;
  }
  
  public static boolean c(d paramd)
  {
    return (paramd.i >= 0) && (paramd.j >= 0) && (paramd.k >= 0);
  }
  
  public static void d(@Nullable d paramd)
  {
    if (paramd != null) {
      paramd.close();
    }
  }
  
  public static boolean e(@Nullable d paramd)
  {
    return (paramd != null) && (paramd.b());
  }
  
  /* Error */
  public d a()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 67	com/facebook/imagepipeline/i/d:g	Lcom/facebook/common/internal/m;
    //   4: ifnull +30 -> 34
    //   7: new 2	com/facebook/imagepipeline/i/d
    //   10: dup
    //   11: aload_0
    //   12: getfield 67	com/facebook/imagepipeline/i/d:g	Lcom/facebook/common/internal/m;
    //   15: aload_0
    //   16: getfield 50	com/facebook/imagepipeline/i/d:m	I
    //   19: invokespecial 94	com/facebook/imagepipeline/i/d:<init>	(Lcom/facebook/common/internal/m;I)V
    //   22: astore_1
    //   23: aload_1
    //   24: ifnull +8 -> 32
    //   27: aload_1
    //   28: aload_0
    //   29: invokevirtual 96	com/facebook/imagepipeline/i/d:b	(Lcom/facebook/imagepipeline/i/d;)V
    //   32: aload_1
    //   33: areturn
    //   34: aload_0
    //   35: getfield 65	com/facebook/imagepipeline/i/d:f	Lcom/facebook/common/h/a;
    //   38: invokestatic 99	com/facebook/common/h/a:b	(Lcom/facebook/common/h/a;)Lcom/facebook/common/h/a;
    //   41: astore_2
    //   42: aload_2
    //   43: ifnonnull +12 -> 55
    //   46: aconst_null
    //   47: astore_1
    //   48: aload_2
    //   49: invokestatic 101	com/facebook/common/h/a:c	(Lcom/facebook/common/h/a;)V
    //   52: goto -29 -> 23
    //   55: new 2	com/facebook/imagepipeline/i/d
    //   58: dup
    //   59: aload_2
    //   60: invokespecial 103	com/facebook/imagepipeline/i/d:<init>	(Lcom/facebook/common/h/a;)V
    //   63: astore_1
    //   64: goto -16 -> 48
    //   67: astore_1
    //   68: aload_2
    //   69: invokestatic 101	com/facebook/common/h/a:c	(Lcom/facebook/common/h/a;)V
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	d
    //   22	42	1	locald	d
    //   67	6	1	localObject	Object
    //   41	28	2	locala	com.facebook.common.h.a
    // Exception table:
    //   from	to	target	type
    //   55	64	67	finally
  }
  
  public void a(int paramInt)
  {
    this.k = paramInt;
  }
  
  public void a(com.facebook.f.b paramb)
  {
    this.h = paramb;
  }
  
  public void b(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void b(d paramd)
  {
    this.h = paramd.e();
    this.j = paramd.g();
    this.k = paramd.h();
    this.i = paramd.f();
    this.l = paramd.i();
    this.m = paramd.j();
  }
  
  /* Error */
  public boolean b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 65	com/facebook/imagepipeline/i/d:f	Lcom/facebook/common/h/a;
    //   6: invokestatic 55	com/facebook/common/h/a:a	(Lcom/facebook/common/h/a;)Z
    //   9: ifne +12 -> 21
    //   12: aload_0
    //   13: getfield 67	com/facebook/imagepipeline/i/d:g	Lcom/facebook/common/internal/m;
    //   16: astore_2
    //   17: aload_2
    //   18: ifnull +9 -> 27
    //   21: iconst_1
    //   22: istore_1
    //   23: aload_0
    //   24: monitorexit
    //   25: iload_1
    //   26: ireturn
    //   27: iconst_0
    //   28: istore_1
    //   29: goto -6 -> 23
    //   32: astore_2
    //   33: aload_0
    //   34: monitorexit
    //   35: aload_2
    //   36: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	37	0	this	d
    //   22	7	1	bool	boolean
    //   16	2	2	localm	m
    //   32	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	32	finally
  }
  
  public com.facebook.common.h.a<y> c()
  {
    return com.facebook.common.h.a.b(this.f);
  }
  
  public void c(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void close()
  {
    com.facebook.common.h.a.c(this.f);
  }
  
  public InputStream d()
  {
    if (this.g != null) {
      return (InputStream)this.g.b();
    }
    com.facebook.common.h.a locala = com.facebook.common.h.a.b(this.f);
    if (locala != null) {
      try
      {
        aa localaa = new aa((y)locala.a());
        return localaa;
      }
      finally
      {
        com.facebook.common.h.a.c(locala);
      }
    }
    return null;
  }
  
  public void d(int paramInt)
  {
    this.l = paramInt;
  }
  
  public com.facebook.f.b e()
  {
    return this.h;
  }
  
  public void e(int paramInt)
  {
    this.m = paramInt;
  }
  
  public int f()
  {
    return this.i;
  }
  
  public boolean f(int paramInt)
  {
    if (this.h != com.facebook.f.b.f) {}
    y localy;
    do
    {
      do
      {
        return true;
      } while (this.g != null);
      k.a(this.f);
      localy = (y)this.f.a();
    } while ((localy.a(paramInt - 2) == -1) && (localy.a(paramInt - 1) == -39));
    return false;
  }
  
  public int g()
  {
    return this.j;
  }
  
  public int h()
  {
    return this.k;
  }
  
  public int i()
  {
    return this.l;
  }
  
  public int j()
  {
    if ((this.f != null) && (this.f.a() != null)) {
      return ((y)this.f.a()).a();
    }
    return this.m;
  }
  
  public void k()
  {
    com.facebook.f.b localb = c.b(d());
    this.h = localb;
    if (!com.facebook.f.b.a(localb))
    {
      Pair localPair = com.facebook.h.a.a(d());
      if (localPair != null)
      {
        this.j = ((Integer)localPair.first).intValue();
        this.k = ((Integer)localPair.second).intValue();
        if (localb != com.facebook.f.b.f) {
          break label90;
        }
        if (this.i == -1) {
          this.i = com.facebook.h.b.a(com.facebook.h.b.a(d()));
        }
      }
    }
    return;
    label90:
    this.i = 0;
  }
  
  /* Error */
  @com.facebook.common.internal.VisibleForTesting
  public com.facebook.common.h.d<y> l()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 65	com/facebook/imagepipeline/i/d:f	Lcom/facebook/common/h/a;
    //   6: ifnull +15 -> 21
    //   9: aload_0
    //   10: getfield 65	com/facebook/imagepipeline/i/d:f	Lcom/facebook/common/h/a;
    //   13: invokevirtual 186	com/facebook/common/h/a:e	()Lcom/facebook/common/h/d;
    //   16: astore_1
    //   17: aload_0
    //   18: monitorexit
    //   19: aload_1
    //   20: areturn
    //   21: aconst_null
    //   22: astore_1
    //   23: goto -6 -> 17
    //   26: astore_1
    //   27: aload_0
    //   28: monitorexit
    //   29: aload_1
    //   30: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	31	0	this	d
    //   16	7	1	locald	com.facebook.common.h.d
    //   26	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	17	26	finally
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/imagepipeline/i/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */