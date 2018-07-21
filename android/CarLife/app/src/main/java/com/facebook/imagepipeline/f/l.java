package com.facebook.imagepipeline.f;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.facebook.imagepipeline.h.c;
import com.facebook.imagepipeline.l.aa;
import com.facebook.imagepipeline.l.ab;
import com.facebook.imagepipeline.l.ad;
import com.facebook.imagepipeline.l.ae;
import com.facebook.imagepipeline.l.af;
import com.facebook.imagepipeline.l.ag;
import com.facebook.imagepipeline.l.ah;
import com.facebook.imagepipeline.l.ai;
import com.facebook.imagepipeline.l.an;
import com.facebook.imagepipeline.l.aq;
import com.facebook.imagepipeline.l.ar;
import com.facebook.imagepipeline.l.as;
import com.facebook.imagepipeline.l.at;
import com.facebook.imagepipeline.l.au;
import com.facebook.imagepipeline.l.av;
import com.facebook.imagepipeline.l.ax;
import com.facebook.imagepipeline.l.g;
import com.facebook.imagepipeline.l.h;
import com.facebook.imagepipeline.l.i;
import com.facebook.imagepipeline.l.k;
import com.facebook.imagepipeline.l.n;
import com.facebook.imagepipeline.l.q;
import com.facebook.imagepipeline.l.u;
import com.facebook.imagepipeline.l.v;
import com.facebook.imagepipeline.l.w;
import com.facebook.imagepipeline.l.x;
import com.facebook.imagepipeline.memory.y;

public class l
{
  private ContentResolver a;
  private Resources b;
  private AssetManager c;
  private final com.facebook.imagepipeline.memory.f d;
  private final com.facebook.imagepipeline.h.b e;
  private final c f;
  private final boolean g;
  private final boolean h;
  private final boolean i;
  private final e j;
  private final com.facebook.imagepipeline.memory.z k;
  private final com.facebook.imagepipeline.d.e l;
  private final com.facebook.imagepipeline.d.e m;
  private final com.facebook.imagepipeline.d.p<com.facebook.b.a.d, y> n;
  private final com.facebook.imagepipeline.d.p<com.facebook.b.a.d, com.facebook.imagepipeline.i.b> o;
  private final com.facebook.imagepipeline.d.f p;
  private final int q;
  private final com.facebook.imagepipeline.c.e r;
  
  public l(Context paramContext, com.facebook.imagepipeline.memory.f paramf, com.facebook.imagepipeline.h.b paramb, c paramc, boolean paramBoolean1, boolean paramBoolean2, e parame, com.facebook.imagepipeline.memory.z paramz, com.facebook.imagepipeline.d.p<com.facebook.b.a.d, com.facebook.imagepipeline.i.b> paramp, com.facebook.imagepipeline.d.p<com.facebook.b.a.d, y> paramp1, com.facebook.imagepipeline.d.e parame1, com.facebook.imagepipeline.d.e parame2, com.facebook.imagepipeline.d.f paramf1, com.facebook.imagepipeline.c.e parame3, boolean paramBoolean3, int paramInt)
  {
    this.q = paramInt;
    this.a = paramContext.getApplicationContext().getContentResolver();
    this.b = paramContext.getApplicationContext().getResources();
    this.c = paramContext.getApplicationContext().getAssets();
    this.d = paramf;
    this.e = paramb;
    this.f = paramc;
    this.g = paramBoolean1;
    this.h = paramBoolean2;
    this.j = parame;
    this.k = paramz;
    this.o = paramp;
    this.n = paramp1;
    this.l = parame1;
    this.m = parame2;
    this.p = paramf1;
    this.r = parame3;
    this.i = paramBoolean3;
  }
  
  public static com.facebook.imagepipeline.l.a a(ai<com.facebook.imagepipeline.i.d> paramai)
  {
    return new com.facebook.imagepipeline.l.a(paramai);
  }
  
  public static i a(ai<com.facebook.imagepipeline.i.d> paramai1, ai<com.facebook.imagepipeline.i.d> paramai2)
  {
    return new i(paramai1, paramai2);
  }
  
  public static <T> af<T> i()
  {
    return new af();
  }
  
  public static <T> aq<T> l(ai<T> paramai)
  {
    return new aq(paramai);
  }
  
  public ad a(ae paramae)
  {
    return new ad(this.k, this.d, paramae);
  }
  
  public <T> ar<T> a(ai<T> paramai, as paramas)
  {
    return new ar(paramai, paramas);
  }
  
  public <T> at<T> a(int paramInt, ai<T> paramai)
  {
    return new at(paramInt, this.j.e(), paramai);
  }
  
  public au a(av<com.facebook.imagepipeline.i.d>[] paramArrayOfav)
  {
    return new au(paramArrayOfav);
  }
  
  public k a()
  {
    return new k(this.k, this.i);
  }
  
  public com.facebook.imagepipeline.l.f b(ai<com.facebook.common.h.a<com.facebook.imagepipeline.i.b>> paramai)
  {
    return new com.facebook.imagepipeline.l.f(this.o, this.p, paramai);
  }
  
  public u b()
  {
    return new u(this.j.a(), this.k, this.c, this.i);
  }
  
  public g c(ai<com.facebook.common.h.a<com.facebook.imagepipeline.i.b>> paramai)
  {
    return new g(this.p, paramai);
  }
  
  public v c()
  {
    return new v(this.j.a(), this.k, this.a, this.i);
  }
  
  public h d(ai<com.facebook.common.h.a<com.facebook.imagepipeline.i.b>> paramai)
  {
    return new h(this.o, this.p, paramai);
  }
  
  public w d()
  {
    return new w(this.j.a(), this.k, this.a, this.i);
  }
  
  public com.facebook.imagepipeline.l.l e(ai<com.facebook.imagepipeline.i.d> paramai)
  {
    return new com.facebook.imagepipeline.l.l(this.d, this.j.c(), this.e, this.f, this.g, this.h, paramai);
  }
  
  public x e()
  {
    return new x(this.j.a(), this.k, this.a);
  }
  
  public n f(ai<com.facebook.imagepipeline.i.d> paramai)
  {
    return new n(this.l, this.m, this.p, paramai, this.q);
  }
  
  public com.facebook.imagepipeline.l.z f()
  {
    return new com.facebook.imagepipeline.l.z(this.j.a(), this.k, this.i);
  }
  
  public aa g()
  {
    return new aa(this.j.a(), this.k, this.b, this.i);
  }
  
  public com.facebook.imagepipeline.l.p g(ai<com.facebook.imagepipeline.i.d> paramai)
  {
    return new com.facebook.imagepipeline.l.p(this.p, paramai);
  }
  
  public ab h()
  {
    return new ab(this.j.a());
  }
  
  public q h(ai<com.facebook.imagepipeline.i.d> paramai)
  {
    return new q(this.n, this.p, paramai);
  }
  
  public ag i(ai<com.facebook.common.h.a<com.facebook.imagepipeline.i.b>> paramai)
  {
    return new ag(this.o, this.p, paramai);
  }
  
  public ah j(ai<com.facebook.common.h.a<com.facebook.imagepipeline.i.b>> paramai)
  {
    return new ah(paramai, this.r, this.j.d());
  }
  
  public an k(ai<com.facebook.imagepipeline.i.d> paramai)
  {
    return new an(this.j.d(), this.k, paramai);
  }
  
  public ax m(ai<com.facebook.imagepipeline.i.d> paramai)
  {
    return new ax(this.j.d(), this.k, paramai);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/f/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */