package com.facebook.imagepipeline.d;

import com.facebook.common.e.a;
import com.facebook.common.internal.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

public class u
{
  private static final Class<?> a = u.class;
  @GuardedBy("this")
  private Map<com.facebook.b.a.d, com.facebook.imagepipeline.i.d> b = new HashMap();
  
  public static u a()
  {
    return new u();
  }
  
  private void c()
  {
    try
    {
      a.a(a, "Count = %d", Integer.valueOf(this.b.size()));
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(com.facebook.b.a.d paramd, com.facebook.imagepipeline.i.d paramd1)
  {
    try
    {
      k.a(paramd);
      k.a(com.facebook.imagepipeline.i.d.e(paramd1));
      com.facebook.imagepipeline.i.d.d((com.facebook.imagepipeline.i.d)this.b.put(paramd, com.facebook.imagepipeline.i.d.a(paramd1)));
      c();
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public boolean a(com.facebook.b.a.d paramd)
  {
    k.a(paramd);
    try
    {
      paramd = (com.facebook.imagepipeline.i.d)this.b.remove(paramd);
      if (paramd == null) {
        return false;
      }
    }
    finally {}
    try
    {
      boolean bool = paramd.b();
      return bool;
    }
    finally
    {
      paramd.close();
    }
  }
  
  /* Error */
  public com.facebook.imagepipeline.i.d b(com.facebook.b.a.d paramd)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 54	com/facebook/common/internal/k:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: getfield 26	com/facebook/imagepipeline/d/u:b	Ljava/util/Map;
    //   11: aload_1
    //   12: invokeinterface 90 2 0
    //   17: checkcast 56	com/facebook/imagepipeline/i/d
    //   20: astore_3
    //   21: aload_3
    //   22: astore_2
    //   23: aload_3
    //   24: ifnull +95 -> 119
    //   27: aload_3
    //   28: monitorenter
    //   29: aload_3
    //   30: invokestatic 60	com/facebook/imagepipeline/i/d:e	(Lcom/facebook/imagepipeline/i/d;)Z
    //   33: ifne +63 -> 96
    //   36: aload_0
    //   37: getfield 26	com/facebook/imagepipeline/d/u:b	Ljava/util/Map;
    //   40: aload_1
    //   41: invokeinterface 80 2 0
    //   46: pop
    //   47: getstatic 17	com/facebook/imagepipeline/d/u:a	Ljava/lang/Class;
    //   50: ldc 92
    //   52: iconst_3
    //   53: anewarray 4	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: aload_3
    //   59: invokestatic 98	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   62: invokestatic 43	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   65: aastore
    //   66: dup
    //   67: iconst_1
    //   68: aload_1
    //   69: invokeinterface 104 1 0
    //   74: aastore
    //   75: dup
    //   76: iconst_2
    //   77: aload_1
    //   78: invokestatic 98	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   81: invokestatic 43	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   84: aastore
    //   85: invokestatic 107	com/facebook/common/e/a:d	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V
    //   88: aconst_null
    //   89: astore_1
    //   90: aload_3
    //   91: monitorexit
    //   92: aload_0
    //   93: monitorexit
    //   94: aload_1
    //   95: areturn
    //   96: aload_3
    //   97: invokestatic 66	com/facebook/imagepipeline/i/d:a	(Lcom/facebook/imagepipeline/i/d;)Lcom/facebook/imagepipeline/i/d;
    //   100: astore_2
    //   101: aload_3
    //   102: monitorexit
    //   103: goto +16 -> 119
    //   106: aload_3
    //   107: monitorexit
    //   108: aload_1
    //   109: athrow
    //   110: astore_1
    //   111: aload_0
    //   112: monitorexit
    //   113: aload_1
    //   114: athrow
    //   115: astore_1
    //   116: goto -10 -> 106
    //   119: aload_2
    //   120: astore_1
    //   121: goto -29 -> 92
    //   124: astore_1
    //   125: goto -19 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	u
    //   0	128	1	paramd	com.facebook.b.a.d
    //   22	98	2	locald1	com.facebook.imagepipeline.i.d
    //   20	87	3	locald2	com.facebook.imagepipeline.i.d
    // Exception table:
    //   from	to	target	type
    //   2	21	110	finally
    //   27	29	110	finally
    //   108	110	110	finally
    //   101	103	115	finally
    //   106	108	115	finally
    //   29	88	124	finally
    //   90	92	124	finally
    //   96	101	124	finally
  }
  
  public void b()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.b.values());
      this.b.clear();
      int i = 0;
      while (i < localArrayList.size())
      {
        com.facebook.imagepipeline.i.d locald = (com.facebook.imagepipeline.i.d)localArrayList.get(i);
        if (locald != null) {
          locald.close();
        }
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean b(com.facebook.b.a.d paramd, com.facebook.imagepipeline.i.d paramd1)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_1
    //   5: invokestatic 54	com/facebook/common/internal/k:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   8: pop
    //   9: aload_2
    //   10: invokestatic 54	com/facebook/common/internal/k:a	(Ljava/lang/Object;)Ljava/lang/Object;
    //   13: pop
    //   14: aload_2
    //   15: invokestatic 60	com/facebook/imagepipeline/i/d:e	(Lcom/facebook/imagepipeline/i/d;)Z
    //   18: invokestatic 63	com/facebook/common/internal/k:a	(Z)V
    //   21: aload_0
    //   22: getfield 26	com/facebook/imagepipeline/d/u:b	Ljava/util/Map;
    //   25: aload_1
    //   26: invokeinterface 90 2 0
    //   31: checkcast 56	com/facebook/imagepipeline/i/d
    //   34: astore 4
    //   36: aload 4
    //   38: ifnonnull +7 -> 45
    //   41: aload_0
    //   42: monitorexit
    //   43: iload_3
    //   44: ireturn
    //   45: aload 4
    //   47: invokevirtual 129	com/facebook/imagepipeline/i/d:c	()Lcom/facebook/common/h/a;
    //   50: astore 5
    //   52: aload_2
    //   53: invokevirtual 129	com/facebook/imagepipeline/i/d:c	()Lcom/facebook/common/h/a;
    //   56: astore_2
    //   57: aload 5
    //   59: ifnull +27 -> 86
    //   62: aload_2
    //   63: ifnull +23 -> 86
    //   66: aload 5
    //   68: invokevirtual 134	com/facebook/common/h/a:a	()Ljava/lang/Object;
    //   71: astore 6
    //   73: aload_2
    //   74: invokevirtual 134	com/facebook/common/h/a:a	()Ljava/lang/Object;
    //   77: astore 7
    //   79: aload 6
    //   81: aload 7
    //   83: if_acmpeq +25 -> 108
    //   86: aload_2
    //   87: invokestatic 137	com/facebook/common/h/a:c	(Lcom/facebook/common/h/a;)V
    //   90: aload 5
    //   92: invokestatic 137	com/facebook/common/h/a:c	(Lcom/facebook/common/h/a;)V
    //   95: aload 4
    //   97: invokestatic 74	com/facebook/imagepipeline/i/d:d	(Lcom/facebook/imagepipeline/i/d;)V
    //   100: goto -59 -> 41
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    //   108: aload_0
    //   109: getfield 26	com/facebook/imagepipeline/d/u:b	Ljava/util/Map;
    //   112: aload_1
    //   113: invokeinterface 80 2 0
    //   118: pop
    //   119: aload_2
    //   120: invokestatic 137	com/facebook/common/h/a:c	(Lcom/facebook/common/h/a;)V
    //   123: aload 5
    //   125: invokestatic 137	com/facebook/common/h/a:c	(Lcom/facebook/common/h/a;)V
    //   128: aload 4
    //   130: invokestatic 74	com/facebook/imagepipeline/i/d:d	(Lcom/facebook/imagepipeline/i/d;)V
    //   133: aload_0
    //   134: invokespecial 76	com/facebook/imagepipeline/d/u:c	()V
    //   137: iconst_1
    //   138: istore_3
    //   139: goto -98 -> 41
    //   142: astore_1
    //   143: aload_2
    //   144: invokestatic 137	com/facebook/common/h/a:c	(Lcom/facebook/common/h/a;)V
    //   147: aload 5
    //   149: invokestatic 137	com/facebook/common/h/a:c	(Lcom/facebook/common/h/a;)V
    //   152: aload 4
    //   154: invokestatic 74	com/facebook/imagepipeline/i/d:d	(Lcom/facebook/imagepipeline/i/d;)V
    //   157: aload_1
    //   158: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	159	0	this	u
    //   0	159	1	paramd	com.facebook.b.a.d
    //   0	159	2	paramd1	com.facebook.imagepipeline.i.d
    //   1	138	3	bool	boolean
    //   34	119	4	locald	com.facebook.imagepipeline.i.d
    //   50	98	5	locala	com.facebook.common.h.a
    //   71	9	6	localObject1	Object
    //   77	5	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   4	36	103	finally
    //   45	57	103	finally
    //   86	100	103	finally
    //   119	137	103	finally
    //   143	159	103	finally
    //   66	79	142	finally
    //   108	119	142	finally
  }
  
  public boolean c(com.facebook.b.a.d paramd)
  {
    boolean bool1 = false;
    for (;;)
    {
      try
      {
        k.a(paramd);
        boolean bool2 = this.b.containsKey(paramd);
        if (!bool2) {
          return bool1;
        }
        synchronized ((com.facebook.imagepipeline.i.d)this.b.get(paramd))
        {
          if (!com.facebook.imagepipeline.i.d.e(???))
          {
            this.b.remove(paramd);
            a.d(a, "Found closed reference %d for key %s (%d)", new Object[] { Integer.valueOf(System.identityHashCode(???)), paramd.toString(), Integer.valueOf(System.identityHashCode(paramd)) });
          }
        }
      }
      finally {}
      bool1 = true;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/d/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */