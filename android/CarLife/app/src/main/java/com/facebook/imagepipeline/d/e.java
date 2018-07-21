package com.facebook.imagepipeline.d;

import com.facebook.common.e.a;
import com.facebook.common.internal.k;
import com.facebook.imagepipeline.memory.ac;
import com.facebook.imagepipeline.memory.z;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public class e
{
  private static final Class<?> a = e.class;
  private final com.facebook.b.b.j b;
  private final z c;
  private final ac d;
  private final Executor e;
  private final Executor f;
  private final u g;
  private final n h;
  
  public e(com.facebook.b.b.j paramj, z paramz, ac paramac, Executor paramExecutor1, Executor paramExecutor2, n paramn)
  {
    this.b = paramj;
    this.c = paramz;
    this.d = paramac;
    this.e = paramExecutor1;
    this.f = paramExecutor2;
    this.h = paramn;
    this.g = u.a();
  }
  
  private a.j<com.facebook.imagepipeline.i.d> b(com.facebook.b.a.d paramd, com.facebook.imagepipeline.i.d paramd1)
  {
    a.a(a, "Found image for %s in staging area", paramd.toString());
    this.h.g();
    return a.j.a(paramd1);
  }
  
  private a.j<com.facebook.imagepipeline.i.d> b(final com.facebook.b.a.d paramd, final AtomicBoolean paramAtomicBoolean)
  {
    try
    {
      paramAtomicBoolean = a.j.a(new Callable()
      {
        /* Error */
        public com.facebook.imagepipeline.i.d a()
          throws Exception
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 23	com/facebook/imagepipeline/d/e$2:a	Ljava/util/concurrent/atomic/AtomicBoolean;
          //   4: invokevirtual 38	java/util/concurrent/atomic/AtomicBoolean:get	()Z
          //   7: ifeq +11 -> 18
          //   10: new 40	java/util/concurrent/CancellationException
          //   13: dup
          //   14: invokespecial 41	java/util/concurrent/CancellationException:<init>	()V
          //   17: athrow
          //   18: aload_0
          //   19: getfield 21	com/facebook/imagepipeline/d/e$2:c	Lcom/facebook/imagepipeline/d/e;
          //   22: invokestatic 44	com/facebook/imagepipeline/d/e:a	(Lcom/facebook/imagepipeline/d/e;)Lcom/facebook/imagepipeline/d/u;
          //   25: aload_0
          //   26: getfield 25	com/facebook/imagepipeline/d/e$2:b	Lcom/facebook/b/a/d;
          //   29: invokevirtual 49	com/facebook/imagepipeline/d/u:b	(Lcom/facebook/b/a/d;)Lcom/facebook/imagepipeline/i/d;
          //   32: astore_1
          //   33: aload_1
          //   34: ifnull +62 -> 96
          //   37: invokestatic 52	com/facebook/imagepipeline/d/e:b	()Ljava/lang/Class;
          //   40: ldc 54
          //   42: aload_0
          //   43: getfield 25	com/facebook/imagepipeline/d/e$2:b	Lcom/facebook/b/a/d;
          //   46: invokeinterface 60 1 0
          //   51: invokestatic 65	com/facebook/common/e/a:a	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
          //   54: aload_0
          //   55: getfield 21	com/facebook/imagepipeline/d/e$2:c	Lcom/facebook/imagepipeline/d/e;
          //   58: invokestatic 68	com/facebook/imagepipeline/d/e:b	(Lcom/facebook/imagepipeline/d/e;)Lcom/facebook/imagepipeline/d/n;
          //   61: invokeinterface 73 1 0
          //   66: invokestatic 78	java/lang/Thread:interrupted	()Z
          //   69: ifeq +97 -> 166
          //   72: invokestatic 52	com/facebook/imagepipeline/d/e:b	()Ljava/lang/Class;
          //   75: ldc 80
          //   77: invokestatic 83	com/facebook/common/e/a:a	(Ljava/lang/Class;Ljava/lang/String;)V
          //   80: aload_1
          //   81: ifnull +7 -> 88
          //   84: aload_1
          //   85: invokevirtual 88	com/facebook/imagepipeline/i/d:close	()V
          //   88: new 90	java/lang/InterruptedException
          //   91: dup
          //   92: invokespecial 91	java/lang/InterruptedException:<init>	()V
          //   95: athrow
          //   96: invokestatic 52	com/facebook/imagepipeline/d/e:b	()Ljava/lang/Class;
          //   99: ldc 93
          //   101: aload_0
          //   102: getfield 25	com/facebook/imagepipeline/d/e$2:b	Lcom/facebook/b/a/d;
          //   105: invokeinterface 60 1 0
          //   110: invokestatic 65	com/facebook/common/e/a:a	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
          //   113: aload_0
          //   114: getfield 21	com/facebook/imagepipeline/d/e$2:c	Lcom/facebook/imagepipeline/d/e;
          //   117: invokestatic 68	com/facebook/imagepipeline/d/e:b	(Lcom/facebook/imagepipeline/d/e;)Lcom/facebook/imagepipeline/d/n;
          //   120: invokeinterface 96 1 0
          //   125: aload_0
          //   126: getfield 21	com/facebook/imagepipeline/d/e$2:c	Lcom/facebook/imagepipeline/d/e;
          //   129: aload_0
          //   130: getfield 25	com/facebook/imagepipeline/d/e$2:b	Lcom/facebook/b/a/d;
          //   133: invokestatic 99	com/facebook/imagepipeline/d/e:b	(Lcom/facebook/imagepipeline/d/e;Lcom/facebook/b/a/d;)Lcom/facebook/imagepipeline/memory/y;
          //   136: invokestatic 104	com/facebook/common/h/a:a	(Ljava/io/Closeable;)Lcom/facebook/common/h/a;
          //   139: astore_2
          //   140: new 85	com/facebook/imagepipeline/i/d
          //   143: dup
          //   144: aload_2
          //   145: invokespecial 107	com/facebook/imagepipeline/i/d:<init>	(Lcom/facebook/common/h/a;)V
          //   148: astore_1
          //   149: aload_2
          //   150: invokestatic 109	com/facebook/common/h/a:c	(Lcom/facebook/common/h/a;)V
          //   153: goto -87 -> 66
          //   156: astore_1
          //   157: aload_2
          //   158: invokestatic 109	com/facebook/common/h/a:c	(Lcom/facebook/common/h/a;)V
          //   161: aload_1
          //   162: athrow
          //   163: astore_1
          //   164: aconst_null
          //   165: areturn
          //   166: aload_1
          //   167: areturn
          //   168: astore_1
          //   169: goto -5 -> 164
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	172	0	this	2
          //   32	117	1	locald	com.facebook.imagepipeline.i.d
          //   156	6	1	localObject	Object
          //   163	4	1	localException1	Exception
          //   168	1	1	localException2	Exception
          //   139	19	2	locala	com.facebook.common.h.a
          // Exception table:
          //   from	to	target	type
          //   140	149	156	finally
          //   125	140	163	java/lang/Exception
          //   157	163	163	java/lang/Exception
          //   149	153	168	java/lang/Exception
        }
      }, this.e);
      return paramAtomicBoolean;
    }
    catch (Exception paramAtomicBoolean)
    {
      a.d(a, paramAtomicBoolean, "Failed to schedule disk-cache read for %s", new Object[] { paramd.toString() });
    }
    return a.j.a(paramAtomicBoolean);
  }
  
  private void c(com.facebook.b.a.d paramd, final com.facebook.imagepipeline.i.d paramd1)
  {
    a.a(a, "About to write to disk-cache for key %s", paramd.toString());
    try
    {
      this.b.a(paramd, new com.facebook.b.a.j()
      {
        public void a(OutputStream paramAnonymousOutputStream)
          throws IOException
        {
          e.d(e.this).a(paramd1.d(), paramAnonymousOutputStream);
        }
      });
      a.a(a, "Successful disk-cache write for key %s", paramd.toString());
      return;
    }
    catch (IOException paramd1)
    {
      a.d(a, paramd1, "Failed to write to disk-cache for key %s", new Object[] { paramd.toString() });
    }
  }
  
  private a.j<Boolean> e(final com.facebook.b.a.d paramd)
  {
    try
    {
      a.j localj = a.j.a(new Callable()
      {
        public Boolean a()
          throws Exception
        {
          return Boolean.valueOf(e.a(e.this, paramd));
        }
      }, this.e);
      return localj;
    }
    catch (Exception localException)
    {
      a.d(a, localException, "Failed to schedule disk-cache read for %s", new Object[] { paramd.toString() });
      return a.j.a(localException);
    }
  }
  
  private boolean f(com.facebook.b.a.d paramd)
  {
    com.facebook.imagepipeline.i.d locald = this.g.b(paramd);
    if (locald != null)
    {
      locald.close();
      a.a(a, "Found image for %s in staging area", paramd.toString());
      this.h.g();
      return true;
    }
    a.a(a, "Did not find image for %s in staging area", paramd.toString());
    this.h.h();
    try
    {
      boolean bool = this.b.e(paramd);
      return bool;
    }
    catch (Exception paramd) {}
    return false;
  }
  
  /* Error */
  private com.facebook.imagepipeline.memory.y g(com.facebook.b.a.d paramd)
    throws IOException
  {
    // Byte code:
    //   0: getstatic 36	com/facebook/imagepipeline/d/e:a	Ljava/lang/Class;
    //   3: ldc -98
    //   5: aload_1
    //   6: invokeinterface 78 1 0
    //   11: invokestatic 83	com/facebook/common/e/a:a	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   14: aload_0
    //   15: getfield 43	com/facebook/imagepipeline/d/e:b	Lcom/facebook/b/b/j;
    //   18: aload_1
    //   19: invokeinterface 161 2 0
    //   24: astore_3
    //   25: aload_3
    //   26: ifnonnull +28 -> 54
    //   29: getstatic 36	com/facebook/imagepipeline/d/e:a	Ljava/lang/Class;
    //   32: ldc -93
    //   34: aload_1
    //   35: invokeinterface 78 1 0
    //   40: invokestatic 83	com/facebook/common/e/a:a	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   43: aload_0
    //   44: getfield 53	com/facebook/imagepipeline/d/e:h	Lcom/facebook/imagepipeline/d/n;
    //   47: invokeinterface 166 1 0
    //   52: aconst_null
    //   53: areturn
    //   54: getstatic 36	com/facebook/imagepipeline/d/e:a	Ljava/lang/Class;
    //   57: ldc -88
    //   59: aload_1
    //   60: invokeinterface 78 1 0
    //   65: invokestatic 83	com/facebook/common/e/a:a	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   68: aload_0
    //   69: getfield 53	com/facebook/imagepipeline/d/e:h	Lcom/facebook/imagepipeline/d/n;
    //   72: invokeinterface 171 1 0
    //   77: aload_3
    //   78: invokeinterface 176 1 0
    //   83: astore_2
    //   84: aload_0
    //   85: getfield 45	com/facebook/imagepipeline/d/e:c	Lcom/facebook/imagepipeline/memory/z;
    //   88: aload_2
    //   89: aload_3
    //   90: invokeinterface 179 1 0
    //   95: l2i
    //   96: invokeinterface 184 3 0
    //   101: astore_3
    //   102: aload_2
    //   103: invokevirtual 187	java/io/InputStream:close	()V
    //   106: getstatic 36	com/facebook/imagepipeline/d/e:a	Ljava/lang/Class;
    //   109: ldc -67
    //   111: aload_1
    //   112: invokeinterface 78 1 0
    //   117: invokestatic 83	com/facebook/common/e/a:a	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   120: aload_3
    //   121: areturn
    //   122: astore_2
    //   123: getstatic 36	com/facebook/imagepipeline/d/e:a	Ljava/lang/Class;
    //   126: aload_2
    //   127: ldc -65
    //   129: iconst_1
    //   130: anewarray 4	java/lang/Object
    //   133: dup
    //   134: iconst_0
    //   135: aload_1
    //   136: invokeinterface 78 1 0
    //   141: aastore
    //   142: invokestatic 108	com/facebook/common/e/a:d	(Ljava/lang/Class;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   145: aload_0
    //   146: getfield 53	com/facebook/imagepipeline/d/e:h	Lcom/facebook/imagepipeline/d/n;
    //   149: invokeinterface 194 1 0
    //   154: aload_2
    //   155: athrow
    //   156: astore_3
    //   157: aload_2
    //   158: invokevirtual 187	java/io/InputStream:close	()V
    //   161: aload_3
    //   162: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	e
    //   0	163	1	paramd	com.facebook.b.a.d
    //   83	20	2	localInputStream	java.io.InputStream
    //   122	36	2	localIOException	IOException
    //   24	97	3	localObject1	Object
    //   156	6	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	25	122	java/io/IOException
    //   29	52	122	java/io/IOException
    //   54	84	122	java/io/IOException
    //   102	120	122	java/io/IOException
    //   157	163	122	java/io/IOException
    //   84	102	156	finally
  }
  
  public a.j<Void> a()
  {
    this.g.b();
    try
    {
      a.j localj = a.j.a(new Callable()
      {
        public Void a()
          throws Exception
        {
          e.a(e.this).b();
          e.c(e.this).e();
          return null;
        }
      }, this.f);
      return localj;
    }
    catch (Exception localException)
    {
      a.d(a, localException, "Failed to schedule disk-cache clear", new Object[0]);
      return a.j.a(localException);
    }
  }
  
  public a.j<com.facebook.imagepipeline.i.d> a(com.facebook.b.a.d paramd, AtomicBoolean paramAtomicBoolean)
  {
    com.facebook.imagepipeline.i.d locald = this.g.b(paramd);
    if (locald != null) {
      return b(paramd, locald);
    }
    return b(paramd, paramAtomicBoolean);
  }
  
  public void a(final com.facebook.b.a.d paramd, com.facebook.imagepipeline.i.d paramd1)
  {
    k.a(paramd);
    k.a(com.facebook.imagepipeline.i.d.e(paramd1));
    this.g.a(paramd, paramd1);
    final com.facebook.imagepipeline.i.d locald = com.facebook.imagepipeline.i.d.a(paramd1);
    try
    {
      this.f.execute(new Runnable()
      {
        public void run()
        {
          try
          {
            e.a(e.this, paramd, locald);
            return;
          }
          finally
          {
            e.a(e.this).b(paramd, locald);
            com.facebook.imagepipeline.i.d.d(locald);
          }
        }
      });
      return;
    }
    catch (Exception localException)
    {
      a.d(a, localException, "Failed to schedule disk-cache write for %s", new Object[] { paramd.toString() });
      this.g.b(paramd, paramd1);
      com.facebook.imagepipeline.i.d.d(locald);
    }
  }
  
  public boolean a(com.facebook.b.a.d paramd)
  {
    return (this.g.c(paramd)) || (this.b.d(paramd));
  }
  
  public a.j<Boolean> b(com.facebook.b.a.d paramd)
  {
    if (a(paramd)) {
      return a.j.a(Boolean.valueOf(true));
    }
    return e(paramd);
  }
  
  public boolean c(com.facebook.b.a.d paramd)
  {
    if (a(paramd)) {
      return true;
    }
    return f(paramd);
  }
  
  public a.j<Void> d(final com.facebook.b.a.d paramd)
  {
    k.a(paramd);
    this.g.a(paramd);
    try
    {
      a.j localj = a.j.a(new Callable()
      {
        public Void a()
          throws Exception
        {
          e.a(e.this).a(paramd);
          e.c(e.this).c(paramd);
          return null;
        }
      }, this.f);
      return localj;
    }
    catch (Exception localException)
    {
      a.d(a, localException, "Failed to schedule disk-cache remove for %s", new Object[] { paramd.toString() });
      return a.j.a(localException);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/d/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */