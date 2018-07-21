package com.facebook.imagepipeline.l;

import com.facebook.b.a.d;
import com.facebook.common.h.a;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.d.p;
import com.facebook.imagepipeline.i.b;
import com.facebook.imagepipeline.m.c;
import com.facebook.imagepipeline.m.e;

public class ag
  implements ai<a<b>>
{
  @VisibleForTesting
  static final String a = "PostprocessedBitmapMemoryCacheProducer";
  @VisibleForTesting
  static final String b = "cached_value_found";
  private final p<d, b> c;
  private final com.facebook.imagepipeline.d.f d;
  private final ai<a<b>> e;
  
  public ag(p<d, b> paramp, com.facebook.imagepipeline.d.f paramf, ai<a<b>> paramai)
  {
    this.c = paramp;
    this.d = paramf;
    this.e = paramai;
  }
  
  protected String a()
  {
    return "PostprocessedBitmapMemoryCacheProducer";
  }
  
  public void a(j<a<b>> paramj, aj paramaj)
  {
    String str1 = null;
    a locala = null;
    al localal = paramaj.c();
    String str2 = paramaj.b();
    Object localObject1 = paramaj.a();
    Object localObject2 = paramaj.d();
    e locale = ((c)localObject1).n();
    if ((locale == null) || (locale.b() == null))
    {
      this.e.a(paramj, paramaj);
      return;
    }
    localal.a(str2, a());
    localObject2 = this.d.b((c)localObject1, localObject2);
    localObject1 = this.c.a(localObject2);
    if (localObject1 != null)
    {
      str1 = a();
      paramaj = locala;
      if (localal.b(str2)) {
        paramaj = g.a("cached_value_found", "true");
      }
      localal.a(str2, str1, paramaj);
      paramj.b(1.0F);
      paramj.b(localObject1, true);
      ((a)localObject1).close();
      return;
    }
    locala = new a(paramj, (d)localObject2, locale instanceof com.facebook.imagepipeline.m.f, this.c);
    localObject1 = a();
    paramj = str1;
    if (localal.b(str2)) {
      paramj = g.a("cached_value_found", "false");
    }
    localal.a(str2, (String)localObject1, paramj);
    this.e.a(locala, paramaj);
  }
  
  public static class a
    extends m<a<b>, a<b>>
  {
    private final d a;
    private final boolean b;
    private final p<d, b> c;
    
    public a(j<a<b>> paramj, d paramd, boolean paramBoolean, p<d, b> paramp)
    {
      super();
      this.a = paramd;
      this.b = paramBoolean;
      this.c = paramp;
    }
    
    protected void a(a<b> parama, boolean paramBoolean)
    {
      if (parama == null) {
        if (paramBoolean) {
          d().b(null, true);
        }
      }
      while ((!paramBoolean) && (!this.b)) {
        return;
      }
      a locala = this.c.a(this.a, parama);
      try
      {
        d().b(1.0F);
        j localj = d();
        if (locala != null) {
          parama = locala;
        }
        localj.b(parama, paramBoolean);
        return;
      }
      finally
      {
        a.c(locala);
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */