package com.facebook.imagepipeline.l;

import com.facebook.common.internal.k;
import com.facebook.common.m.f;
import com.facebook.imagepipeline.i.d;
import com.facebook.imagepipeline.memory.ab;
import com.facebook.imagepipeline.memory.z;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class ax
  implements ai<d>
{
  private static final String a = "WebpTranscodeProducer";
  private static final int b = 80;
  private final Executor c;
  private final z d;
  private final ai<d> e;
  
  public ax(Executor paramExecutor, z paramz, ai<d> paramai)
  {
    this.c = ((Executor)k.a(paramExecutor));
    this.d = ((z)k.a(paramz));
    this.e = ((ai)k.a(paramai));
  }
  
  private void a(final d paramd, j<d> paramj, aj paramaj)
  {
    k.a(paramd);
    paramd = d.a(paramd);
    paramd = new ap(paramj, paramaj.c(), "WebpTranscodeProducer", paramaj.b())
    {
      protected void a(d paramAnonymousd)
      {
        d.d(paramAnonymousd);
      }
      
      protected void a(Exception paramAnonymousException)
      {
        d.d(paramd);
        super.a(paramAnonymousException);
      }
      
      protected void b()
      {
        d.d(paramd);
        super.b();
      }
      
      protected void b(d paramAnonymousd)
      {
        d.d(paramd);
        super.a(paramAnonymousd);
      }
      
      /* Error */
      protected d d()
        throws Exception
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 18	com/facebook/imagepipeline/l/ax$1:h	Lcom/facebook/imagepipeline/l/ax;
        //   4: invokestatic 55	com/facebook/imagepipeline/l/ax:a	(Lcom/facebook/imagepipeline/l/ax;)Lcom/facebook/imagepipeline/memory/z;
        //   7: invokeinterface 60 1 0
        //   12: astore_1
        //   13: aload_0
        //   14: getfield 20	com/facebook/imagepipeline/l/ax$1:g	Lcom/facebook/imagepipeline/i/d;
        //   17: aload_1
        //   18: invokestatic 63	com/facebook/imagepipeline/l/ax:a	(Lcom/facebook/imagepipeline/i/d;Lcom/facebook/imagepipeline/memory/ab;)V
        //   21: aload_1
        //   22: invokevirtual 68	com/facebook/imagepipeline/memory/ab:c	()Lcom/facebook/imagepipeline/memory/y;
        //   25: invokestatic 73	com/facebook/common/h/a:a	(Ljava/io/Closeable;)Lcom/facebook/common/h/a;
        //   28: astore_2
        //   29: new 27	com/facebook/imagepipeline/i/d
        //   32: dup
        //   33: aload_2
        //   34: invokespecial 76	com/facebook/imagepipeline/i/d:<init>	(Lcom/facebook/common/h/a;)V
        //   37: astore_3
        //   38: aload_3
        //   39: aload_0
        //   40: getfield 20	com/facebook/imagepipeline/l/ax$1:g	Lcom/facebook/imagepipeline/i/d;
        //   43: invokevirtual 77	com/facebook/imagepipeline/i/d:b	(Lcom/facebook/imagepipeline/i/d;)V
        //   46: aload_2
        //   47: invokestatic 79	com/facebook/common/h/a:c	(Lcom/facebook/common/h/a;)V
        //   50: aload_1
        //   51: invokevirtual 82	com/facebook/imagepipeline/memory/ab:close	()V
        //   54: aload_3
        //   55: areturn
        //   56: astore_3
        //   57: aload_2
        //   58: invokestatic 79	com/facebook/common/h/a:c	(Lcom/facebook/common/h/a;)V
        //   61: aload_3
        //   62: athrow
        //   63: astore_2
        //   64: aload_1
        //   65: invokevirtual 82	com/facebook/imagepipeline/memory/ab:close	()V
        //   68: aload_2
        //   69: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	70	0	this	1
        //   12	53	1	localab	ab
        //   28	30	2	locala	com.facebook.common.h.a
        //   63	6	2	localObject1	Object
        //   37	18	3	locald	d
        //   56	6	3	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   29	46	56	finally
        //   13	29	63	finally
        //   46	50	63	finally
        //   57	63	63	finally
      }
    };
    this.c.execute(paramd);
  }
  
  private static f b(d paramd)
  {
    k.a(paramd);
    paramd = com.facebook.f.c.b(paramd.d());
    switch (2.a[paramd.ordinal()])
    {
    default: 
      return f.b;
    case 1: 
    case 2: 
    case 3: 
    case 4: 
      com.facebook.imagepipeline.nativecode.b localb = com.facebook.imagepipeline.nativecode.c.a();
      if (localb == null) {
        return f.b;
      }
      if (!localb.a(paramd)) {}
      for (boolean bool = true;; bool = false) {
        return f.a(bool);
      }
    }
    return f.c;
  }
  
  private static void b(d paramd, ab paramab)
    throws Exception
  {
    paramd = paramd.d();
    com.facebook.f.b localb = com.facebook.f.c.b(paramd);
    switch (2.a[localb.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Wrong image format");
    case 1: 
    case 3: 
      com.facebook.imagepipeline.nativecode.c.a().a(paramd, paramab, 80);
      return;
    }
    com.facebook.imagepipeline.nativecode.c.a().a(paramd, paramab);
  }
  
  public void a(j<d> paramj, aj paramaj)
  {
    this.e.a(new a(paramj, paramaj), paramaj);
  }
  
  private class a
    extends m<d, d>
  {
    private final aj b;
    private f c;
    
    public a(aj paramaj)
    {
      super();
      aj localaj;
      this.b = localaj;
      this.c = f.c;
    }
    
    protected void a(@Nullable d paramd, boolean paramBoolean)
    {
      if ((this.c == f.c) && (paramd != null)) {
        this.c = ax.a(paramd);
      }
      if (this.c == f.b) {
        d().b(paramd, paramBoolean);
      }
      while (!paramBoolean) {
        return;
      }
      if ((this.c == f.a) && (paramd != null))
      {
        ax.a(ax.this, paramd, d(), this.b);
        return;
      }
      d().b(paramd, paramBoolean);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/ax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */