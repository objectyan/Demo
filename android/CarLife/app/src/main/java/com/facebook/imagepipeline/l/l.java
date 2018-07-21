package com.facebook.imagepipeline.l;

import android.graphics.Bitmap;
import com.facebook.common.internal.k;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public class l
  implements ai<com.facebook.common.h.a<com.facebook.imagepipeline.i.b>>
{
  public static final String a = "DecodeProducer";
  private static final String b = "bitmapSize";
  private static final String c = "hasGoodQuality";
  private static final String d = "imageType";
  private static final String e = "isFinal";
  private final com.facebook.imagepipeline.memory.f f;
  private final Executor g;
  private final com.facebook.imagepipeline.h.b h;
  private final com.facebook.imagepipeline.h.c i;
  private final ai<com.facebook.imagepipeline.i.d> j;
  private final boolean k;
  private final boolean l;
  
  public l(com.facebook.imagepipeline.memory.f paramf, Executor paramExecutor, com.facebook.imagepipeline.h.b paramb, com.facebook.imagepipeline.h.c paramc, boolean paramBoolean1, boolean paramBoolean2, ai<com.facebook.imagepipeline.i.d> paramai)
  {
    this.f = ((com.facebook.imagepipeline.memory.f)k.a(paramf));
    this.g = ((Executor)k.a(paramExecutor));
    this.h = ((com.facebook.imagepipeline.h.b)k.a(paramb));
    this.i = ((com.facebook.imagepipeline.h.c)k.a(paramc));
    this.k = paramBoolean1;
    this.l = paramBoolean2;
    this.j = ((ai)k.a(paramai));
  }
  
  public void a(j<com.facebook.common.h.a<com.facebook.imagepipeline.i.b>> paramj, aj paramaj)
  {
    if (!com.facebook.common.m.g.a(paramaj.a().b())) {}
    for (paramj = new a(paramj, paramaj);; paramj = new b(paramj, paramaj, new com.facebook.imagepipeline.h.d(this.f), this.i))
    {
      this.j.a(paramj, paramaj);
      return;
    }
  }
  
  private class a
    extends l.c
  {
    public a(aj paramaj)
    {
      super(paramaj, localaj);
    }
    
    protected int a(com.facebook.imagepipeline.i.d paramd)
    {
      return paramd.j();
    }
    
    protected boolean a(com.facebook.imagepipeline.i.d paramd, boolean paramBoolean)
    {
      if (!paramBoolean) {
        paramBoolean = false;
      }
      for (;;)
      {
        return paramBoolean;
        try
        {
          paramBoolean = super.a(paramd, paramBoolean);
        }
        finally {}
      }
    }
    
    protected com.facebook.imagepipeline.i.g c()
    {
      return com.facebook.imagepipeline.i.f.a(0, false, false);
    }
  }
  
  private class b
    extends l.c
  {
    private final com.facebook.imagepipeline.h.d c;
    private final com.facebook.imagepipeline.h.c d;
    private int e;
    
    public b(aj paramaj, com.facebook.imagepipeline.h.d paramd, com.facebook.imagepipeline.h.c paramc)
    {
      super(paramaj, paramd);
      this.c = ((com.facebook.imagepipeline.h.d)k.a(paramc));
      Object localObject;
      this.d = ((com.facebook.imagepipeline.h.c)k.a(localObject));
      this.e = 0;
    }
    
    protected int a(com.facebook.imagepipeline.i.d paramd)
    {
      return this.c.b();
    }
    
    protected boolean a(com.facebook.imagepipeline.i.d paramd, boolean paramBoolean)
    {
      for (;;)
      {
        try
        {
          boolean bool2 = super.a(paramd, paramBoolean);
          boolean bool1 = bool2;
          if (!paramBoolean)
          {
            bool1 = bool2;
            if (com.facebook.imagepipeline.i.d.e(paramd))
            {
              paramBoolean = this.c.a(paramd);
              if (paramBoolean) {
                continue;
              }
              bool1 = false;
            }
          }
          return bool1;
          int i = this.c.c();
          if ((i > this.e) && (i >= this.d.a(this.e)))
          {
            this.e = i;
            bool1 = bool2;
          }
          else
          {
            bool1 = false;
          }
        }
        finally {}
      }
    }
    
    protected com.facebook.imagepipeline.i.g c()
    {
      return this.d.b(this.c.c());
    }
  }
  
  private abstract class c
    extends m<com.facebook.imagepipeline.i.d, com.facebook.common.h.a<com.facebook.imagepipeline.i.b>>
  {
    private final aj a;
    private final al c;
    private final com.facebook.imagepipeline.e.a d;
    @GuardedBy("this")
    private boolean e;
    private final t f;
    
    public c(aj paramaj)
    {
      super();
      final aj localaj;
      this.a = localaj;
      this.c = localaj.c();
      this.d = localaj.a().f();
      this.e = false;
      paramaj = new t.a()
      {
        public void a(com.facebook.imagepipeline.i.d paramAnonymousd, boolean paramAnonymousBoolean)
        {
          if (paramAnonymousd != null)
          {
            if (l.a(l.this))
            {
              com.facebook.imagepipeline.m.c localc = localaj.a();
              if ((l.b(l.this)) || (!com.facebook.common.m.g.a(localc.b()))) {
                paramAnonymousd.d(o.a(localc, paramAnonymousd));
              }
            }
            l.c.a(l.c.this, paramAnonymousd, paramAnonymousBoolean);
          }
        }
      };
      this.f = new t(l.c(l.this), paramaj, this.d.a);
      this.a.a(new e()
      {
        public void c()
        {
          if (l.c.a(l.c.this).h()) {
            l.c.b(l.c.this).b();
          }
        }
      });
    }
    
    private Map<String, String> a(@Nullable com.facebook.imagepipeline.i.b paramb, long paramLong, com.facebook.imagepipeline.i.g paramg, boolean paramBoolean)
    {
      if (!this.c.b(this.a.b())) {
        return null;
      }
      String str1 = String.valueOf(paramLong);
      paramg = String.valueOf(paramg.b());
      String str2 = String.valueOf(paramBoolean);
      String str3 = String.valueOf(this.a.a().a());
      if ((paramb instanceof com.facebook.imagepipeline.i.c))
      {
        paramb = ((com.facebook.imagepipeline.i.c)paramb).a();
        return com.facebook.common.internal.g.a("bitmapSize", paramb.getWidth() + "x" + paramb.getHeight(), "queueTime", str1, "hasGoodQuality", paramg, "isFinal", str2, "imageType", str3);
      }
      return com.facebook.common.internal.g.a("queueTime", str1, "hasGoodQuality", paramg, "isFinal", str2, "imageType", str3);
    }
    
    private void a(com.facebook.imagepipeline.i.b paramb, boolean paramBoolean)
    {
      paramb = com.facebook.common.h.a.a(paramb);
      try
      {
        a(paramBoolean);
        d().b(paramb, paramBoolean);
        return;
      }
      finally
      {
        com.facebook.common.h.a.c(paramb);
      }
    }
    
    private void a(boolean paramBoolean)
    {
      if (paramBoolean) {}
      try
      {
        if (this.e) {
          return;
        }
        d().b(1.0F);
        this.e = true;
        this.f.a();
        return;
      }
      finally {}
    }
    
    /* Error */
    private void c(com.facebook.imagepipeline.i.d paramd, boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 197	com/facebook/imagepipeline/l/l$c:e	()Z
      //   4: ifne +10 -> 14
      //   7: aload_1
      //   8: invokestatic 202	com/facebook/imagepipeline/i/d:e	(Lcom/facebook/imagepipeline/i/d;)Z
      //   11: ifne +4 -> 15
      //   14: return
      //   15: aload_0
      //   16: getfield 72	com/facebook/imagepipeline/l/l$c:f	Lcom/facebook/imagepipeline/l/t;
      //   19: invokevirtual 205	com/facebook/imagepipeline/l/t:c	()J
      //   22: lstore 4
      //   24: iload_2
      //   25: ifeq +104 -> 129
      //   28: aload_1
      //   29: invokevirtual 208	com/facebook/imagepipeline/i/d:j	()I
      //   32: istore_3
      //   33: iload_2
      //   34: ifeq +104 -> 138
      //   37: getstatic 213	com/facebook/imagepipeline/i/f:a	Lcom/facebook/imagepipeline/i/g;
      //   40: astore 6
      //   42: aload_0
      //   43: getfield 42	com/facebook/imagepipeline/l/l$c:c	Lcom/facebook/imagepipeline/l/al;
      //   46: aload_0
      //   47: getfield 35	com/facebook/imagepipeline/l/l$c:a	Lcom/facebook/imagepipeline/l/aj;
      //   50: invokeinterface 87 1 0
      //   55: ldc -41
      //   57: invokeinterface 218 3 0
      //   62: aload_0
      //   63: getfield 30	com/facebook/imagepipeline/l/l$c:b	Lcom/facebook/imagepipeline/l/l;
      //   66: invokestatic 221	com/facebook/imagepipeline/l/l:d	(Lcom/facebook/imagepipeline/l/l;)Lcom/facebook/imagepipeline/h/b;
      //   69: aload_1
      //   70: iload_3
      //   71: aload 6
      //   73: aload_0
      //   74: getfield 52	com/facebook/imagepipeline/l/l$c:d	Lcom/facebook/imagepipeline/e/a;
      //   77: invokevirtual 226	com/facebook/imagepipeline/h/b:a	(Lcom/facebook/imagepipeline/i/d;ILcom/facebook/imagepipeline/i/g;Lcom/facebook/imagepipeline/e/a;)Lcom/facebook/imagepipeline/i/b;
      //   80: astore 7
      //   82: aload_0
      //   83: aload 7
      //   85: lload 4
      //   87: aload 6
      //   89: iload_2
      //   90: invokespecial 228	com/facebook/imagepipeline/l/l$c:a	(Lcom/facebook/imagepipeline/i/b;JLcom/facebook/imagepipeline/i/g;Z)Ljava/util/Map;
      //   93: astore 6
      //   95: aload_0
      //   96: getfield 42	com/facebook/imagepipeline/l/l$c:c	Lcom/facebook/imagepipeline/l/al;
      //   99: aload_0
      //   100: getfield 35	com/facebook/imagepipeline/l/l$c:a	Lcom/facebook/imagepipeline/l/aj;
      //   103: invokeinterface 87 1 0
      //   108: ldc -41
      //   110: aload 6
      //   112: invokeinterface 231 4 0
      //   117: aload_0
      //   118: aload 7
      //   120: iload_2
      //   121: invokespecial 233	com/facebook/imagepipeline/l/l$c:a	(Lcom/facebook/imagepipeline/i/b;Z)V
      //   124: aload_1
      //   125: invokestatic 236	com/facebook/imagepipeline/i/d:d	(Lcom/facebook/imagepipeline/i/d;)V
      //   128: return
      //   129: aload_0
      //   130: aload_1
      //   131: invokevirtual 239	com/facebook/imagepipeline/l/l$c:a	(Lcom/facebook/imagepipeline/i/d;)I
      //   134: istore_3
      //   135: goto -102 -> 33
      //   138: aload_0
      //   139: invokevirtual 242	com/facebook/imagepipeline/l/l$c:c	()Lcom/facebook/imagepipeline/i/g;
      //   142: astore 6
      //   144: goto -102 -> 42
      //   147: astore 7
      //   149: aload_0
      //   150: aconst_null
      //   151: lload 4
      //   153: aload 6
      //   155: iload_2
      //   156: invokespecial 228	com/facebook/imagepipeline/l/l$c:a	(Lcom/facebook/imagepipeline/i/b;JLcom/facebook/imagepipeline/i/g;Z)Ljava/util/Map;
      //   159: astore 6
      //   161: aload_0
      //   162: getfield 42	com/facebook/imagepipeline/l/l$c:c	Lcom/facebook/imagepipeline/l/al;
      //   165: aload_0
      //   166: getfield 35	com/facebook/imagepipeline/l/l$c:a	Lcom/facebook/imagepipeline/l/aj;
      //   169: invokeinterface 87 1 0
      //   174: ldc -41
      //   176: aload 7
      //   178: aload 6
      //   180: invokeinterface 245 5 0
      //   185: aload_0
      //   186: aload 7
      //   188: invokespecial 248	com/facebook/imagepipeline/l/l$c:c	(Ljava/lang/Throwable;)V
      //   191: aload_1
      //   192: invokestatic 236	com/facebook/imagepipeline/i/d:d	(Lcom/facebook/imagepipeline/i/d;)V
      //   195: return
      //   196: astore 6
      //   198: aload_1
      //   199: invokestatic 236	com/facebook/imagepipeline/i/d:d	(Lcom/facebook/imagepipeline/i/d;)V
      //   202: aload 6
      //   204: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	205	0	this	c
      //   0	205	1	paramd	com.facebook.imagepipeline.i.d
      //   0	205	2	paramBoolean	boolean
      //   32	103	3	i	int
      //   22	130	4	l	long
      //   40	139	6	localObject1	Object
      //   196	7	6	localObject2	Object
      //   80	39	7	localb	com.facebook.imagepipeline.i.b
      //   147	40	7	localException	Exception
      // Exception table:
      //   from	to	target	type
      //   62	82	147	java/lang/Exception
      //   15	24	196	finally
      //   28	33	196	finally
      //   37	42	196	finally
      //   42	62	196	finally
      //   62	82	196	finally
      //   82	124	196	finally
      //   129	135	196	finally
      //   138	144	196	finally
      //   149	191	196	finally
    }
    
    private void c(Throwable paramThrowable)
    {
      a(true);
      d().b(paramThrowable);
    }
    
    private boolean e()
    {
      try
      {
        boolean bool = this.e;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    private void f()
    {
      a(true);
      d().b();
    }
    
    protected abstract int a(com.facebook.imagepipeline.i.d paramd);
    
    public void a()
    {
      f();
    }
    
    protected void a(float paramFloat)
    {
      super.a(0.99F * paramFloat);
    }
    
    public void a(Throwable paramThrowable)
    {
      c(paramThrowable);
    }
    
    protected boolean a(com.facebook.imagepipeline.i.d paramd, boolean paramBoolean)
    {
      return this.f.a(paramd, paramBoolean);
    }
    
    public void b(com.facebook.imagepipeline.i.d paramd, boolean paramBoolean)
    {
      if ((paramBoolean) && (!com.facebook.imagepipeline.i.d.e(paramd))) {
        c(new NullPointerException("Encoded image is not valid."));
      }
      while ((!a(paramd, paramBoolean)) || ((!paramBoolean) && (!this.a.h()))) {
        return;
      }
      this.f.b();
    }
    
    protected abstract com.facebook.imagepipeline.i.g c();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */