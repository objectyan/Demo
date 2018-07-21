package com.facebook.imagepipeline.l;

import com.facebook.common.h.a;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.d.f;
import com.facebook.imagepipeline.d.p;
import com.facebook.imagepipeline.m.c;
import com.facebook.imagepipeline.m.c.b;
import com.facebook.imagepipeline.memory.y;

public class q
  implements ai<com.facebook.imagepipeline.i.d>
{
  @VisibleForTesting
  static final String a = "EncodedMemoryCacheProducer";
  @VisibleForTesting
  static final String b = "cached_value_found";
  private final p<com.facebook.b.a.d, y> c;
  private final f d;
  private final ai<com.facebook.imagepipeline.i.d> e;
  
  public q(p<com.facebook.b.a.d, y> paramp, f paramf, ai<com.facebook.imagepipeline.i.d> paramai)
  {
    this.c = paramp;
    this.d = paramf;
    this.e = paramai;
  }
  
  public void a(j<com.facebook.imagepipeline.i.d> paramj, aj paramaj)
  {
    Object localObject1 = null;
    com.facebook.imagepipeline.i.d locald = null;
    m local1 = null;
    String str = paramaj.b();
    al localal = paramaj.c();
    localal.a(str, "EncodedMemoryCacheProducer");
    Object localObject2 = paramaj.a();
    final com.facebook.b.a.d locald1 = this.d.c((c)localObject2, paramaj.d());
    localObject2 = this.c.a(locald1);
    if (localObject2 != null) {
      try
      {
        locald = new com.facebook.imagepipeline.i.d((a)localObject2);
        paramaj = local1;
        try
        {
          if (localal.b(str)) {
            paramaj = g.a("cached_value_found", "true");
          }
          localal.a(str, "EncodedMemoryCacheProducer", paramaj);
          paramj.b(1.0F);
          paramj.b(locald, true);
          com.facebook.imagepipeline.i.d.d(locald);
          return;
        }
        finally
        {
          com.facebook.imagepipeline.i.d.d(locald);
        }
        if (paramaj.e().a() < c.b.c.a()) {
          break label235;
        }
      }
      finally
      {
        a.c((a)localObject2);
      }
    }
    paramaj = (aj)localObject1;
    if (localal.b(str)) {
      paramaj = g.a("cached_value_found", "false");
    }
    localal.a(str, "EncodedMemoryCacheProducer", paramaj);
    paramj.b(null, true);
    a.c((a)localObject2);
    return;
    label235:
    local1 = new m(paramj)
    {
      public void a(com.facebook.imagepipeline.i.d paramAnonymousd, boolean paramAnonymousBoolean)
      {
        if ((!paramAnonymousBoolean) || (paramAnonymousd == null))
        {
          d().b(paramAnonymousd, paramAnonymousBoolean);
          return;
        }
        Object localObject = paramAnonymousd.c();
        if (localObject != null) {
          try
          {
            a locala = q.a(q.this).a(locald1, (a)localObject);
            a.c((a)localObject);
            if (locala != null) {}
            d().b(paramAnonymousd, true);
          }
          finally
          {
            try
            {
              localObject = new com.facebook.imagepipeline.i.d(locala);
              ((com.facebook.imagepipeline.i.d)localObject).b(paramAnonymousd);
              a.c(locala);
            }
            finally
            {
              a.c(locala);
            }
            try
            {
              d().b(1.0F);
              d().b(localObject, true);
              com.facebook.imagepipeline.i.d.d((com.facebook.imagepipeline.i.d)localObject);
              return;
            }
            finally
            {
              com.facebook.imagepipeline.i.d.d((com.facebook.imagepipeline.i.d)localObject);
            }
            paramAnonymousd = finally;
            a.c((a)localObject);
          }
        }
      }
    };
    paramj = locald;
    if (localal.b(str)) {
      paramj = g.a("cached_value_found", "false");
    }
    localal.a(str, "EncodedMemoryCacheProducer", paramj);
    this.e.a(local1, paramaj);
    a.c((a)localObject2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */