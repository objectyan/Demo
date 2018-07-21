package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.annotation.GuardedBy;
import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.b.o;
import cz.msebera.android.httpclient.b.p;
import cz.msebera.android.httpclient.b.q;
import cz.msebera.android.httpclient.i.a.e;
import cz.msebera.android.httpclient.i.c.ai;
import cz.msebera.android.httpclient.i.d.ac;
import cz.msebera.android.httpclient.i.d.aj;
import cz.msebera.android.httpclient.n.a;
import cz.msebera.android.httpclient.z;

@Deprecated
@ThreadSafe
public abstract class c
  extends m
{
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  @GuardedBy("this")
  private cz.msebera.android.httpclient.l.j c;
  @GuardedBy("this")
  private cz.msebera.android.httpclient.n.m d;
  @GuardedBy("this")
  private cz.msebera.android.httpclient.e.c e;
  @GuardedBy("this")
  private cz.msebera.android.httpclient.b f;
  @GuardedBy("this")
  private cz.msebera.android.httpclient.e.h g;
  @GuardedBy("this")
  private cz.msebera.android.httpclient.f.k h;
  @GuardedBy("this")
  private cz.msebera.android.httpclient.a.g i;
  @GuardedBy("this")
  private cz.msebera.android.httpclient.n.b j;
  @GuardedBy("this")
  private cz.msebera.android.httpclient.n.u k;
  @GuardedBy("this")
  private cz.msebera.android.httpclient.b.k l;
  @GuardedBy("this")
  private p m;
  @GuardedBy("this")
  private cz.msebera.android.httpclient.b.c n;
  @GuardedBy("this")
  private cz.msebera.android.httpclient.b.c o;
  @GuardedBy("this")
  private cz.msebera.android.httpclient.b.h p;
  @GuardedBy("this")
  private cz.msebera.android.httpclient.b.i q;
  @GuardedBy("this")
  private cz.msebera.android.httpclient.e.b.d r;
  @GuardedBy("this")
  private cz.msebera.android.httpclient.b.t s;
  @GuardedBy("this")
  private cz.msebera.android.httpclient.b.g t;
  @GuardedBy("this")
  private cz.msebera.android.httpclient.b.d u;
  
  protected c(cz.msebera.android.httpclient.e.c paramc, cz.msebera.android.httpclient.l.j paramj)
  {
    this.c = paramj;
    this.e = paramc;
  }
  
  private cz.msebera.android.httpclient.n.k S()
  {
    try
    {
      if (this.k == null)
      {
        localObject1 = N();
        int i2 = ((cz.msebera.android.httpclient.n.b)localObject1).a();
        cz.msebera.android.httpclient.w[] arrayOfw = new cz.msebera.android.httpclient.w[i2];
        int i1 = 0;
        while (i1 < i2)
        {
          arrayOfw[i1] = ((cz.msebera.android.httpclient.n.b)localObject1).a(i1);
          i1 += 1;
        }
        i2 = ((cz.msebera.android.httpclient.n.b)localObject1).c();
        z[] arrayOfz = new z[i2];
        i1 = 0;
        while (i1 < i2)
        {
          arrayOfz[i1] = ((cz.msebera.android.httpclient.n.b)localObject1).b(i1);
          i1 += 1;
        }
        this.k = new cz.msebera.android.httpclient.n.u(arrayOfw, arrayOfz);
      }
      Object localObject1 = this.k;
      return (cz.msebera.android.httpclient.n.k)localObject1;
    }
    finally {}
  }
  
  public final cz.msebera.android.httpclient.b A()
  {
    try
    {
      if (this.f == null) {
        this.f = j();
      }
      cz.msebera.android.httpclient.b localb = this.f;
      return localb;
    }
    finally {}
  }
  
  public final cz.msebera.android.httpclient.e.h B()
  {
    try
    {
      if (this.g == null) {
        this.g = k();
      }
      cz.msebera.android.httpclient.e.h localh = this.g;
      return localh;
    }
    finally {}
  }
  
  public final cz.msebera.android.httpclient.b.k C()
  {
    try
    {
      if (this.l == null) {
        this.l = l();
      }
      cz.msebera.android.httpclient.b.k localk = this.l;
      return localk;
    }
    finally {}
  }
  
  @Deprecated
  public final o D()
  {
    try
    {
      o localo = m();
      return localo;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final p E()
  {
    try
    {
      if (this.m == null) {
        this.m = new w();
      }
      p localp = this.m;
      return localp;
    }
    finally {}
  }
  
  @Deprecated
  public final cz.msebera.android.httpclient.b.b F()
  {
    try
    {
      cz.msebera.android.httpclient.b.b localb = o();
      return localb;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final cz.msebera.android.httpclient.b.c G()
  {
    try
    {
      if (this.n == null) {
        this.n = n();
      }
      cz.msebera.android.httpclient.b.c localc = this.n;
      return localc;
    }
    finally {}
  }
  
  @Deprecated
  public final cz.msebera.android.httpclient.b.b H()
  {
    try
    {
      cz.msebera.android.httpclient.b.b localb = q();
      return localb;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final cz.msebera.android.httpclient.b.c I()
  {
    try
    {
      if (this.o == null) {
        this.o = p();
      }
      cz.msebera.android.httpclient.b.c localc = this.o;
      return localc;
    }
    finally {}
  }
  
  public final cz.msebera.android.httpclient.b.h J()
  {
    try
    {
      if (this.p == null) {
        this.p = r();
      }
      cz.msebera.android.httpclient.b.h localh = this.p;
      return localh;
    }
    finally {}
  }
  
  public final cz.msebera.android.httpclient.b.i K()
  {
    try
    {
      if (this.q == null) {
        this.q = s();
      }
      cz.msebera.android.httpclient.b.i locali = this.q;
      return locali;
    }
    finally {}
  }
  
  public final cz.msebera.android.httpclient.e.b.d L()
  {
    try
    {
      if (this.r == null) {
        this.r = t();
      }
      cz.msebera.android.httpclient.e.b.d locald = this.r;
      return locald;
    }
    finally {}
  }
  
  public final cz.msebera.android.httpclient.b.t M()
  {
    try
    {
      if (this.s == null) {
        this.s = u();
      }
      cz.msebera.android.httpclient.b.t localt = this.s;
      return localt;
    }
    finally {}
  }
  
  protected final cz.msebera.android.httpclient.n.b N()
  {
    try
    {
      if (this.j == null) {
        this.j = d();
      }
      cz.msebera.android.httpclient.n.b localb = this.j;
      return localb;
    }
    finally {}
  }
  
  public int O()
  {
    try
    {
      int i1 = N().c();
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int P()
  {
    try
    {
      int i1 = N().a();
      return i1;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void Q()
  {
    try
    {
      N().d();
      this.k = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void R()
  {
    try
    {
      N().b();
      this.k = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @Deprecated
  protected q a(cz.msebera.android.httpclient.n.m paramm, cz.msebera.android.httpclient.e.c paramc, cz.msebera.android.httpclient.b paramb, cz.msebera.android.httpclient.e.h paramh, cz.msebera.android.httpclient.e.b.d paramd, cz.msebera.android.httpclient.n.k paramk, cz.msebera.android.httpclient.b.k paramk1, o paramo, cz.msebera.android.httpclient.b.b paramb1, cz.msebera.android.httpclient.b.b paramb2, cz.msebera.android.httpclient.b.t paramt, cz.msebera.android.httpclient.l.j paramj)
  {
    return new y(paramm, paramc, paramb, paramh, paramd, paramk, paramk1, paramo, paramb1, paramb2, paramt, paramj);
  }
  
  @Deprecated
  protected q a(cz.msebera.android.httpclient.n.m paramm, cz.msebera.android.httpclient.e.c paramc, cz.msebera.android.httpclient.b paramb, cz.msebera.android.httpclient.e.h paramh, cz.msebera.android.httpclient.e.b.d paramd, cz.msebera.android.httpclient.n.k paramk, cz.msebera.android.httpclient.b.k paramk1, p paramp, cz.msebera.android.httpclient.b.b paramb1, cz.msebera.android.httpclient.b.b paramb2, cz.msebera.android.httpclient.b.t paramt, cz.msebera.android.httpclient.l.j paramj)
  {
    return new y(this.a, paramm, paramc, paramb, paramh, paramd, paramk, paramk1, paramp, paramb1, paramb2, paramt, paramj);
  }
  
  protected q a(cz.msebera.android.httpclient.n.m paramm, cz.msebera.android.httpclient.e.c paramc, cz.msebera.android.httpclient.b paramb, cz.msebera.android.httpclient.e.h paramh, cz.msebera.android.httpclient.e.b.d paramd, cz.msebera.android.httpclient.n.k paramk, cz.msebera.android.httpclient.b.k paramk1, p paramp, cz.msebera.android.httpclient.b.c paramc1, cz.msebera.android.httpclient.b.c paramc2, cz.msebera.android.httpclient.b.t paramt, cz.msebera.android.httpclient.l.j paramj)
  {
    return new y(this.a, paramm, paramc, paramb, paramh, paramd, paramk, paramk1, paramp, paramc1, paramc2, paramt, paramj);
  }
  
  public final cz.msebera.android.httpclient.l.j a()
  {
    try
    {
      if (this.c == null) {
        this.c = c();
      }
      cz.msebera.android.httpclient.l.j localj = this.c;
      return localj;
    }
    finally {}
  }
  
  protected cz.msebera.android.httpclient.l.j a(cz.msebera.android.httpclient.u paramu)
  {
    return new k(null, a(), paramu.getParams(), null);
  }
  
  public z a(int paramInt)
  {
    try
    {
      z localz = N().b(paramInt);
      return localz;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void a(cz.msebera.android.httpclient.a.g paramg)
  {
    try
    {
      this.i = paramg;
      return;
    }
    finally
    {
      paramg = finally;
      throw paramg;
    }
  }
  
  @Deprecated
  public void a(cz.msebera.android.httpclient.b.b paramb)
  {
    try
    {
      this.n = new d(paramb);
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public void a(cz.msebera.android.httpclient.b.c paramc)
  {
    try
    {
      this.n = paramc;
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public void a(cz.msebera.android.httpclient.b.d paramd)
  {
    try
    {
      this.u = paramd;
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public void a(cz.msebera.android.httpclient.b.g paramg)
  {
    try
    {
      this.t = paramg;
      return;
    }
    finally
    {
      paramg = finally;
      throw paramg;
    }
  }
  
  public void a(cz.msebera.android.httpclient.b.h paramh)
  {
    try
    {
      this.p = paramh;
      return;
    }
    finally
    {
      paramh = finally;
      throw paramh;
    }
  }
  
  public void a(cz.msebera.android.httpclient.b.i parami)
  {
    try
    {
      this.q = parami;
      return;
    }
    finally
    {
      parami = finally;
      throw parami;
    }
  }
  
  public void a(cz.msebera.android.httpclient.b.k paramk)
  {
    try
    {
      this.l = paramk;
      return;
    }
    finally
    {
      paramk = finally;
      throw paramk;
    }
  }
  
  @Deprecated
  public void a(o paramo)
  {
    try
    {
      this.m = new x(paramo);
      return;
    }
    finally
    {
      paramo = finally;
      throw paramo;
    }
  }
  
  public void a(p paramp)
  {
    try
    {
      this.m = paramp;
      return;
    }
    finally
    {
      paramp = finally;
      throw paramp;
    }
  }
  
  public void a(cz.msebera.android.httpclient.b.t paramt)
  {
    try
    {
      this.s = paramt;
      return;
    }
    finally
    {
      paramt = finally;
      throw paramt;
    }
  }
  
  public void a(cz.msebera.android.httpclient.b paramb)
  {
    try
    {
      this.f = paramb;
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public void a(cz.msebera.android.httpclient.e.b.d paramd)
  {
    try
    {
      this.r = paramd;
      return;
    }
    finally
    {
      paramd = finally;
      throw paramd;
    }
  }
  
  public void a(cz.msebera.android.httpclient.e.h paramh)
  {
    try
    {
      this.g = paramh;
      return;
    }
    finally
    {
      paramh = finally;
      throw paramh;
    }
  }
  
  public void a(cz.msebera.android.httpclient.f.k paramk)
  {
    try
    {
      this.h = paramk;
      return;
    }
    finally
    {
      paramk = finally;
      throw paramk;
    }
  }
  
  public void a(cz.msebera.android.httpclient.l.j paramj)
  {
    try
    {
      this.c = paramj;
      return;
    }
    finally
    {
      paramj = finally;
      throw paramj;
    }
  }
  
  public void a(cz.msebera.android.httpclient.w paramw)
  {
    try
    {
      N().b(paramw);
      this.k = null;
      return;
    }
    finally
    {
      paramw = finally;
      throw paramw;
    }
  }
  
  public void a(cz.msebera.android.httpclient.w paramw, int paramInt)
  {
    try
    {
      N().b(paramw, paramInt);
      this.k = null;
      return;
    }
    finally
    {
      paramw = finally;
      throw paramw;
    }
  }
  
  public void a(z paramz)
  {
    try
    {
      N().b(paramz);
      this.k = null;
      return;
    }
    finally
    {
      paramz = finally;
      throw paramz;
    }
  }
  
  public void a(z paramz, int paramInt)
  {
    try
    {
      N().b(paramz, paramInt);
      this.k = null;
      return;
    }
    finally
    {
      paramz = finally;
      throw paramz;
    }
  }
  
  public void a(Class<? extends z> paramClass)
  {
    try
    {
      N().b(paramClass);
      this.k = null;
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  /* Error */
  protected final cz.msebera.android.httpclient.b.d.c b(cz.msebera.android.httpclient.r paramr, cz.msebera.android.httpclient.u paramu, cz.msebera.android.httpclient.n.g paramg)
    throws java.io.IOException, cz.msebera.android.httpclient.b.f
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc_w 278
    //   4: invokestatic 283	cz/msebera/android/httpclient/o/a:a	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   7: pop
    //   8: aload_0
    //   9: monitorenter
    //   10: aload_0
    //   11: invokevirtual 286	cz/msebera/android/httpclient/i/b/c:e	()Lcz/msebera/android/httpclient/n/g;
    //   14: astore 4
    //   16: aload_3
    //   17: ifnonnull +165 -> 182
    //   20: aload 4
    //   22: astore_3
    //   23: aload_0
    //   24: aload_2
    //   25: invokevirtual 288	cz/msebera/android/httpclient/i/b/c:a	(Lcz/msebera/android/httpclient/u;)Lcz/msebera/android/httpclient/l/j;
    //   28: astore 4
    //   30: aload_3
    //   31: ldc_w 290
    //   34: aload 4
    //   36: invokestatic 295	cz/msebera/android/httpclient/b/e/f:a	(Lcz/msebera/android/httpclient/l/j;)Lcz/msebera/android/httpclient/b/b/c;
    //   39: invokeinterface 300 3 0
    //   44: aload_0
    //   45: aload_0
    //   46: invokevirtual 304	cz/msebera/android/httpclient/i/b/c:v	()Lcz/msebera/android/httpclient/n/m;
    //   49: aload_0
    //   50: invokevirtual 307	cz/msebera/android/httpclient/i/b/c:b	()Lcz/msebera/android/httpclient/e/c;
    //   53: aload_0
    //   54: invokevirtual 309	cz/msebera/android/httpclient/i/b/c:A	()Lcz/msebera/android/httpclient/b;
    //   57: aload_0
    //   58: invokevirtual 311	cz/msebera/android/httpclient/i/b/c:B	()Lcz/msebera/android/httpclient/e/h;
    //   61: aload_0
    //   62: invokevirtual 313	cz/msebera/android/httpclient/i/b/c:L	()Lcz/msebera/android/httpclient/e/b/d;
    //   65: aload_0
    //   66: invokespecial 315	cz/msebera/android/httpclient/i/b/c:S	()Lcz/msebera/android/httpclient/n/k;
    //   69: aload_0
    //   70: invokevirtual 317	cz/msebera/android/httpclient/i/b/c:C	()Lcz/msebera/android/httpclient/b/k;
    //   73: aload_0
    //   74: invokevirtual 319	cz/msebera/android/httpclient/i/b/c:E	()Lcz/msebera/android/httpclient/b/p;
    //   77: aload_0
    //   78: invokevirtual 321	cz/msebera/android/httpclient/i/b/c:G	()Lcz/msebera/android/httpclient/b/c;
    //   81: aload_0
    //   82: invokevirtual 323	cz/msebera/android/httpclient/i/b/c:I	()Lcz/msebera/android/httpclient/b/c;
    //   85: aload_0
    //   86: invokevirtual 325	cz/msebera/android/httpclient/i/b/c:M	()Lcz/msebera/android/httpclient/b/t;
    //   89: aload 4
    //   91: invokevirtual 327	cz/msebera/android/httpclient/i/b/c:a	(Lcz/msebera/android/httpclient/n/m;Lcz/msebera/android/httpclient/e/c;Lcz/msebera/android/httpclient/b;Lcz/msebera/android/httpclient/e/h;Lcz/msebera/android/httpclient/e/b/d;Lcz/msebera/android/httpclient/n/k;Lcz/msebera/android/httpclient/b/k;Lcz/msebera/android/httpclient/b/p;Lcz/msebera/android/httpclient/b/c;Lcz/msebera/android/httpclient/b/c;Lcz/msebera/android/httpclient/b/t;Lcz/msebera/android/httpclient/l/j;)Lcz/msebera/android/httpclient/b/q;
    //   94: astore 7
    //   96: aload_0
    //   97: invokevirtual 313	cz/msebera/android/httpclient/i/b/c:L	()Lcz/msebera/android/httpclient/e/b/d;
    //   100: astore 8
    //   102: aload_0
    //   103: invokevirtual 331	cz/msebera/android/httpclient/i/b/c:x	()Lcz/msebera/android/httpclient/b/g;
    //   106: astore 5
    //   108: aload_0
    //   109: invokevirtual 335	cz/msebera/android/httpclient/i/b/c:z	()Lcz/msebera/android/httpclient/b/d;
    //   112: astore 6
    //   114: aload_0
    //   115: monitorexit
    //   116: aload 5
    //   118: ifnull +202 -> 320
    //   121: aload 6
    //   123: ifnull +197 -> 320
    //   126: aload_1
    //   127: ifnull +74 -> 201
    //   130: aload_1
    //   131: astore 4
    //   133: aload 8
    //   135: aload 4
    //   137: aload_2
    //   138: aload_3
    //   139: invokeinterface 340 4 0
    //   144: astore 4
    //   146: aload 7
    //   148: aload_1
    //   149: aload_2
    //   150: aload_3
    //   151: invokeinterface 345 4 0
    //   156: invokestatic 350	cz/msebera/android/httpclient/i/b/n:a	(Lcz/msebera/android/httpclient/x;)Lcz/msebera/android/httpclient/b/d/c;
    //   159: astore_1
    //   160: aload 5
    //   162: aload_1
    //   163: invokeinterface 355 2 0
    //   168: ifeq +141 -> 309
    //   171: aload 6
    //   173: aload 4
    //   175: invokeinterface 360 2 0
    //   180: aload_1
    //   181: areturn
    //   182: new 362	cz/msebera/android/httpclient/n/d
    //   185: dup
    //   186: aload_3
    //   187: aload 4
    //   189: invokespecial 365	cz/msebera/android/httpclient/n/d:<init>	(Lcz/msebera/android/httpclient/n/g;Lcz/msebera/android/httpclient/n/g;)V
    //   192: astore_3
    //   193: goto -170 -> 23
    //   196: astore_1
    //   197: aload_0
    //   198: monitorexit
    //   199: aload_1
    //   200: athrow
    //   201: aload_0
    //   202: aload_2
    //   203: invokevirtual 288	cz/msebera/android/httpclient/i/b/c:a	(Lcz/msebera/android/httpclient/u;)Lcz/msebera/android/httpclient/l/j;
    //   206: ldc_w 367
    //   209: invokeinterface 372 2 0
    //   214: checkcast 374	cz/msebera/android/httpclient/r
    //   217: astore 4
    //   219: goto -86 -> 133
    //   222: astore_1
    //   223: aload 5
    //   225: aload_1
    //   226: invokeinterface 377 2 0
    //   231: ifeq +12 -> 243
    //   234: aload 6
    //   236: aload 4
    //   238: invokeinterface 360 2 0
    //   243: aload_1
    //   244: athrow
    //   245: astore_1
    //   246: new 270	cz/msebera/android/httpclient/b/f
    //   249: dup
    //   250: aload_1
    //   251: invokespecial 380	cz/msebera/android/httpclient/b/f:<init>	(Ljava/lang/Throwable;)V
    //   254: athrow
    //   255: astore_1
    //   256: aload 5
    //   258: aload_1
    //   259: invokeinterface 377 2 0
    //   264: ifeq +12 -> 276
    //   267: aload 6
    //   269: aload 4
    //   271: invokeinterface 360 2 0
    //   276: aload_1
    //   277: instanceof 272
    //   280: ifeq +8 -> 288
    //   283: aload_1
    //   284: checkcast 272	cz/msebera/android/httpclient/p
    //   287: athrow
    //   288: aload_1
    //   289: instanceof 268
    //   292: ifeq +8 -> 300
    //   295: aload_1
    //   296: checkcast 268	java/io/IOException
    //   299: athrow
    //   300: new 382	java/lang/reflect/UndeclaredThrowableException
    //   303: dup
    //   304: aload_1
    //   305: invokespecial 383	java/lang/reflect/UndeclaredThrowableException:<init>	(Ljava/lang/Throwable;)V
    //   308: athrow
    //   309: aload 6
    //   311: aload 4
    //   313: invokeinterface 385 2 0
    //   318: aload_1
    //   319: areturn
    //   320: aload 7
    //   322: aload_1
    //   323: aload_2
    //   324: aload_3
    //   325: invokeinterface 345 4 0
    //   330: invokestatic 350	cz/msebera/android/httpclient/i/b/n:a	(Lcz/msebera/android/httpclient/x;)Lcz/msebera/android/httpclient/b/d/c;
    //   333: astore_1
    //   334: aload_1
    //   335: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	this	c
    //   0	336	1	paramr	cz.msebera.android.httpclient.r
    //   0	336	2	paramu	cz.msebera.android.httpclient.u
    //   0	336	3	paramg	cz.msebera.android.httpclient.n.g
    //   14	298	4	localObject	Object
    //   106	151	5	localg	cz.msebera.android.httpclient.b.g
    //   112	198	6	locald	cz.msebera.android.httpclient.b.d
    //   94	227	7	localq	q
    //   100	34	8	locald1	cz.msebera.android.httpclient.e.b.d
    // Exception table:
    //   from	to	target	type
    //   10	16	196	finally
    //   23	116	196	finally
    //   182	193	196	finally
    //   197	199	196	finally
    //   146	160	222	java/lang/RuntimeException
    //   133	146	245	cz/msebera/android/httpclient/p
    //   146	160	245	cz/msebera/android/httpclient/p
    //   160	180	245	cz/msebera/android/httpclient/p
    //   201	219	245	cz/msebera/android/httpclient/p
    //   223	243	245	cz/msebera/android/httpclient/p
    //   243	245	245	cz/msebera/android/httpclient/p
    //   256	276	245	cz/msebera/android/httpclient/p
    //   276	288	245	cz/msebera/android/httpclient/p
    //   288	300	245	cz/msebera/android/httpclient/p
    //   300	309	245	cz/msebera/android/httpclient/p
    //   309	318	245	cz/msebera/android/httpclient/p
    //   320	334	245	cz/msebera/android/httpclient/p
    //   146	160	255	java/lang/Exception
  }
  
  public final cz.msebera.android.httpclient.e.c b()
  {
    try
    {
      if (this.e == null) {
        this.e = f();
      }
      cz.msebera.android.httpclient.e.c localc = this.e;
      return localc;
    }
    finally {}
  }
  
  public cz.msebera.android.httpclient.w b(int paramInt)
  {
    try
    {
      cz.msebera.android.httpclient.w localw = N().a(paramInt);
      return localw;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @Deprecated
  public void b(cz.msebera.android.httpclient.b.b paramb)
  {
    try
    {
      this.o = new d(paramb);
      return;
    }
    finally
    {
      paramb = finally;
      throw paramb;
    }
  }
  
  public void b(cz.msebera.android.httpclient.b.c paramc)
  {
    try
    {
      this.o = paramc;
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public void b(Class<? extends cz.msebera.android.httpclient.w> paramClass)
  {
    try
    {
      N().a(paramClass);
      this.k = null;
      return;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  protected abstract cz.msebera.android.httpclient.l.j c();
  
  public void close()
  {
    b().c();
  }
  
  protected abstract cz.msebera.android.httpclient.n.b d();
  
  protected cz.msebera.android.httpclient.n.g e()
  {
    a locala = new a();
    locala.a("http.scheme-registry", b().a());
    locala.a("http.authscheme-registry", w());
    locala.a("http.cookiespec-registry", y());
    locala.a("http.cookie-store", J());
    locala.a("http.auth.credentials-provider", K());
    return locala;
  }
  
  protected cz.msebera.android.httpclient.e.c f()
  {
    cz.msebera.android.httpclient.e.c.j localj = ai.a();
    cz.msebera.android.httpclient.l.j localj1 = a();
    cz.msebera.android.httpclient.e.d locald = null;
    String str = (String)localj1.a("http.connection-manager.factory-class-name");
    if (str != null) {}
    try
    {
      locald = (cz.msebera.android.httpclient.e.d)Class.forName(str).newInstance();
      if (locald != null) {
        return locald.a(localj1, localj);
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new IllegalStateException("Invalid class name: " + str);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new IllegalAccessError(localIllegalAccessException.getMessage());
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new InstantiationError(localInstantiationException.getMessage());
    }
    return new cz.msebera.android.httpclient.i.c.d(localj);
  }
  
  protected cz.msebera.android.httpclient.a.g g()
  {
    cz.msebera.android.httpclient.a.g localg = new cz.msebera.android.httpclient.a.g();
    localg.a("Basic", new cz.msebera.android.httpclient.i.a.c());
    localg.a("Digest", new e());
    localg.a("NTLM", new cz.msebera.android.httpclient.i.a.l());
    return localg;
  }
  
  protected cz.msebera.android.httpclient.f.k h()
  {
    cz.msebera.android.httpclient.f.k localk = new cz.msebera.android.httpclient.f.k();
    localk.a("best-match", new cz.msebera.android.httpclient.i.d.l());
    localk.a("compatibility", new cz.msebera.android.httpclient.i.d.n());
    localk.a("netscape", new cz.msebera.android.httpclient.i.d.x());
    localk.a("rfc2109", new ac());
    localk.a("rfc2965", new aj());
    localk.a("ignoreCookies", new cz.msebera.android.httpclient.i.d.t());
    return localk;
  }
  
  protected cz.msebera.android.httpclient.n.m i()
  {
    return new cz.msebera.android.httpclient.n.m();
  }
  
  protected cz.msebera.android.httpclient.b j()
  {
    return new cz.msebera.android.httpclient.i.i();
  }
  
  protected cz.msebera.android.httpclient.e.h k()
  {
    return new r();
  }
  
  protected cz.msebera.android.httpclient.b.k l()
  {
    return new t();
  }
  
  @Deprecated
  protected o m()
  {
    return new v();
  }
  
  protected cz.msebera.android.httpclient.b.c n()
  {
    return new ay();
  }
  
  @Deprecated
  protected cz.msebera.android.httpclient.b.b o()
  {
    return new aa();
  }
  
  protected cz.msebera.android.httpclient.b.c p()
  {
    return new ap();
  }
  
  @Deprecated
  protected cz.msebera.android.httpclient.b.b q()
  {
    return new u();
  }
  
  protected cz.msebera.android.httpclient.b.h r()
  {
    return new h();
  }
  
  protected cz.msebera.android.httpclient.b.i s()
  {
    return new i();
  }
  
  protected cz.msebera.android.httpclient.e.b.d t()
  {
    return new cz.msebera.android.httpclient.i.c.n(b().a());
  }
  
  protected cz.msebera.android.httpclient.b.t u()
  {
    return new ab();
  }
  
  public final cz.msebera.android.httpclient.n.m v()
  {
    try
    {
      if (this.d == null) {
        this.d = i();
      }
      cz.msebera.android.httpclient.n.m localm = this.d;
      return localm;
    }
    finally {}
  }
  
  public final cz.msebera.android.httpclient.a.g w()
  {
    try
    {
      if (this.i == null) {
        this.i = g();
      }
      cz.msebera.android.httpclient.a.g localg = this.i;
      return localg;
    }
    finally {}
  }
  
  public final cz.msebera.android.httpclient.b.g x()
  {
    try
    {
      cz.msebera.android.httpclient.b.g localg = this.t;
      return localg;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final cz.msebera.android.httpclient.f.k y()
  {
    try
    {
      if (this.h == null) {
        this.h = h();
      }
      cz.msebera.android.httpclient.f.k localk = this.h;
      return localk;
    }
    finally {}
  }
  
  public final cz.msebera.android.httpclient.b.d z()
  {
    try
    {
      cz.msebera.android.httpclient.b.d locald = this.u;
      return locald;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */