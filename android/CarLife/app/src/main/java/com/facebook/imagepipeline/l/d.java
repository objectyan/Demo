package com.facebook.imagepipeline.l;

import com.facebook.imagepipeline.m.c.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class d
  implements aj
{
  private final com.facebook.imagepipeline.m.c a;
  private final String b;
  private final al c;
  private final Object d;
  private final c.b e;
  @GuardedBy("this")
  private boolean f;
  @GuardedBy("this")
  private com.facebook.imagepipeline.e.c g;
  @GuardedBy("this")
  private boolean h;
  @GuardedBy("this")
  private boolean i;
  @GuardedBy("this")
  private final List<ak> j;
  
  public d(com.facebook.imagepipeline.m.c paramc, String paramString, al paramal, Object paramObject, c.b paramb, boolean paramBoolean1, boolean paramBoolean2, com.facebook.imagepipeline.e.c paramc1)
  {
    this.a = paramc;
    this.b = paramString;
    this.c = paramal;
    this.d = paramObject;
    this.e = paramb;
    this.f = paramBoolean1;
    this.g = paramc1;
    this.h = paramBoolean2;
    this.i = false;
    this.j = new ArrayList();
  }
  
  public static void a(@Nullable List<ak> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((ak)paramList.next()).a();
      }
    }
  }
  
  public static void b(@Nullable List<ak> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((ak)paramList.next()).b();
      }
    }
  }
  
  public static void c(@Nullable List<ak> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((ak)paramList.next()).c();
      }
    }
  }
  
  public static void d(@Nullable List<ak> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((ak)paramList.next()).d();
      }
    }
  }
  
  public com.facebook.imagepipeline.m.c a()
  {
    return this.a;
  }
  
  /* Error */
  @Nullable
  public List<ak> a(com.facebook.imagepipeline.e.c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 47	com/facebook/imagepipeline/l/d:g	Lcom/facebook/imagepipeline/e/c;
    //   6: astore_2
    //   7: aload_1
    //   8: aload_2
    //   9: if_acmpne +9 -> 18
    //   12: aconst_null
    //   13: astore_1
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_1
    //   17: areturn
    //   18: aload_0
    //   19: aload_1
    //   20: putfield 47	com/facebook/imagepipeline/l/d:g	Lcom/facebook/imagepipeline/e/c;
    //   23: new 53	java/util/ArrayList
    //   26: dup
    //   27: aload_0
    //   28: getfield 56	com/facebook/imagepipeline/l/d:j	Ljava/util/List;
    //   31: invokespecial 93	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   34: astore_1
    //   35: goto -21 -> 14
    //   38: astore_1
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_1
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	d
    //   0	43	1	paramc	com.facebook.imagepipeline.e.c
    //   6	3	2	localc	com.facebook.imagepipeline.e.c
    // Exception table:
    //   from	to	target	type
    //   2	7	38	finally
    //   18	35	38	finally
  }
  
  /* Error */
  @Nullable
  public List<ak> a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 45	com/facebook/imagepipeline/l/d:f	Z
    //   6: istore_2
    //   7: iload_1
    //   8: iload_2
    //   9: if_icmpne +9 -> 18
    //   12: aconst_null
    //   13: astore_3
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_3
    //   17: areturn
    //   18: aload_0
    //   19: iload_1
    //   20: putfield 45	com/facebook/imagepipeline/l/d:f	Z
    //   23: new 53	java/util/ArrayList
    //   26: dup
    //   27: aload_0
    //   28: getfield 56	com/facebook/imagepipeline/l/d:j	Ljava/util/List;
    //   31: invokespecial 93	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   34: astore_3
    //   35: goto -21 -> 14
    //   38: astore_3
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_3
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	d
    //   0	43	1	paramBoolean	boolean
    //   6	4	2	bool	boolean
    //   13	22	3	localObject1	Object
    //   38	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	38	finally
    //   18	35	38	finally
  }
  
  public void a(ak paramak)
  {
    int k = 0;
    try
    {
      this.j.add(paramak);
      if (this.i) {
        k = 1;
      }
      if (k != 0) {
        paramak.a();
      }
      return;
    }
    finally {}
  }
  
  public String b()
  {
    return this.b;
  }
  
  /* Error */
  @Nullable
  public List<ak> b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	com/facebook/imagepipeline/l/d:h	Z
    //   6: istore_2
    //   7: iload_1
    //   8: iload_2
    //   9: if_icmpne +9 -> 18
    //   12: aconst_null
    //   13: astore_3
    //   14: aload_0
    //   15: monitorexit
    //   16: aload_3
    //   17: areturn
    //   18: aload_0
    //   19: iload_1
    //   20: putfield 49	com/facebook/imagepipeline/l/d:h	Z
    //   23: new 53	java/util/ArrayList
    //   26: dup
    //   27: aload_0
    //   28: getfield 56	com/facebook/imagepipeline/l/d:j	Ljava/util/List;
    //   31: invokespecial 93	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   34: astore_3
    //   35: goto -21 -> 14
    //   38: astore_3
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_3
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	d
    //   0	43	1	paramBoolean	boolean
    //   6	4	2	bool	boolean
    //   13	22	3	localObject1	Object
    //   38	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	38	finally
    //   18	35	38	finally
  }
  
  public al c()
  {
    return this.c;
  }
  
  public Object d()
  {
    return this.d;
  }
  
  public c.b e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    try
    {
      boolean bool = this.f;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public com.facebook.imagepipeline.e.c g()
  {
    try
    {
      com.facebook.imagepipeline.e.c localc = this.g;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean h()
  {
    try
    {
      boolean bool = this.h;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean i()
  {
    try
    {
      boolean bool = this.i;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void j()
  {
    a(k());
  }
  
  /* Error */
  @Nullable
  public List<ak> k()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 51	com/facebook/imagepipeline/l/d:i	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +9 -> 17
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_2
    //   16: areturn
    //   17: aload_0
    //   18: iconst_1
    //   19: putfield 51	com/facebook/imagepipeline/l/d:i	Z
    //   22: new 53	java/util/ArrayList
    //   25: dup
    //   26: aload_0
    //   27: getfield 56	com/facebook/imagepipeline/l/d:j	Ljava/util/List;
    //   30: invokespecial 93	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   33: astore_2
    //   34: goto -21 -> 13
    //   37: astore_2
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_2
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	d
    //   6	2	1	bool	boolean
    //   12	22	2	localObject1	Object
    //   37	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	37	finally
    //   17	34	37	finally
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/facebook/imagepipeline/l/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */