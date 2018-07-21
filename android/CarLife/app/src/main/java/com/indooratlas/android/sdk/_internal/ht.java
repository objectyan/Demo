package com.indooratlas.android.sdk._internal;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public final class ht
  implements hx
{
  private static final iq a = iq.a("connection");
  private static final iq b = iq.a("host");
  private static final iq c = iq.a("keep-alive");
  private static final iq d = iq.a("proxy-connection");
  private static final iq e = iq.a("transfer-encoding");
  private static final iq f = iq.a("te");
  private static final iq g = iq.a("encoding");
  private static final iq h = iq.a("upgrade");
  private static final List<iq> i = gy.a(new iq[] { a, b, c, d, e, he.b, he.c, he.d, he.e, he.f, he.g });
  private static final List<iq> j = gy.a(new iq[] { a, b, c, d, e });
  private static final List<iq> k = gy.a(new iq[] { a, b, c, d, f, e, g, h, he.b, he.c, he.d, he.e, he.f, he.g });
  private static final List<iq> l = gy.a(new iq[] { a, b, c, d, f, e, g, h });
  private final ig m;
  private final hc n;
  private hv o;
  private hd p;
  
  public ht(ig paramig, hc paramhc)
  {
    this.m = paramig;
    this.n = paramhc;
  }
  
  private static gm.a a(List<he> paramList)
    throws IOException
  {
    Object localObject1 = null;
    Object localObject2 = "HTTP/1.1";
    gd.a locala = new gd.a();
    int i5 = paramList.size();
    int i1 = 0;
    while (i1 < i5)
    {
      iq localiq = ((he)paramList.get(i1)).h;
      String str2 = ((he)paramList.get(i1)).i.a();
      int i2 = 0;
      if (i2 < str2.length())
      {
        int i4 = str2.indexOf(0, i2);
        int i3 = i4;
        if (i4 == -1) {
          i3 = str2.length();
        }
        String str1 = str2.substring(i2, i3);
        if (localiq.equals(he.a)) {
          localObject1 = str1;
        }
        for (;;)
        {
          i2 = i3 + 1;
          break;
          if (localiq.equals(he.g)) {
            localObject2 = str1;
          } else if (!j.contains(localiq)) {
            locala.a(localiq.a(), str1);
          }
        }
      }
      i1 += 1;
    }
    if (localObject1 == null) {
      throw new ProtocolException("Expected ':status' header not present");
    }
    paramList = if.a((String)localObject2 + " " + (String)localObject1);
    localObject1 = new gm.a();
    ((gm.a)localObject1).b = gi.c;
    ((gm.a)localObject1).c = paramList.b;
    ((gm.a)localObject1).d = paramList.c;
    return ((gm.a)localObject1).a(locala.a());
  }
  
  private static List<he> b(gk paramgk)
  {
    gd localgd = paramgk.c;
    ArrayList localArrayList = new ArrayList(localgd.a.length / 2 + 5);
    localArrayList.add(new he(he.b, paramgk.b));
    localArrayList.add(new he(he.c, ib.a(paramgk.a)));
    localArrayList.add(new he(he.g, "HTTP/1.1"));
    localArrayList.add(new he(he.f, gy.a(paramgk.a)));
    localArrayList.add(new he(he.d, paramgk.a.a));
    paramgk = new LinkedHashSet();
    int i3 = localgd.a.length / 2;
    int i1 = 0;
    if (i1 < i3)
    {
      iq localiq = iq.a(localgd.a(i1).toLowerCase(Locale.US));
      String str;
      if (!i.contains(localiq))
      {
        str = localgd.b(i1);
        if (!paramgk.add(localiq)) {
          break label241;
        }
        localArrayList.add(new he(localiq, str));
      }
      label241:
      label338:
      for (;;)
      {
        i1 += 1;
        break;
        int i2 = 0;
        for (;;)
        {
          if (i2 >= localArrayList.size()) {
            break label338;
          }
          if (((he)localArrayList.get(i2)).h.equals(localiq))
          {
            localArrayList.set(i2, new he(localiq, ((he)localArrayList.get(i2)).i.a() + '\000' + str));
            break;
          }
          i2 += 1;
        }
      }
    }
    return localArrayList;
  }
  
  public final gn a(gm paramgm)
    throws IOException
  {
    a locala = new a(this.p.f);
    return new hz(paramgm.f, ix.a(locala));
  }
  
  public final jc a(gk paramgk, long paramLong)
    throws IOException
  {
    return this.p.d();
  }
  
  public final void a()
  {
    if (this.p != null) {
      this.p.b(gz.l);
    }
  }
  
  public final void a(gk paramgk)
    throws IOException
  {
    if (this.p != null) {
      return;
    }
    this.o.a();
    boolean bool = hv.a(paramgk);
    if (this.n.a == gi.d)
    {
      gd localgd = paramgk.c;
      ArrayList localArrayList = new ArrayList(localgd.a.length / 2 + 4);
      localArrayList.add(new he(he.b, paramgk.b));
      localArrayList.add(new he(he.c, ib.a(paramgk.a)));
      localArrayList.add(new he(he.e, gy.a(paramgk.a)));
      localArrayList.add(new he(he.d, paramgk.a.a));
      int i1 = 0;
      int i2 = localgd.a.length / 2;
      for (;;)
      {
        paramgk = localArrayList;
        if (i1 >= i2) {
          break;
        }
        paramgk = iq.a(localgd.a(i1).toLowerCase(Locale.US));
        if (!k.contains(paramgk)) {
          localArrayList.add(new he(paramgk, localgd.b(i1)));
        }
        i1 += 1;
      }
    }
    paramgk = b(paramgk);
    this.p = this.n.a(paramgk, bool);
    this.p.h.a(this.o.b.w, TimeUnit.MILLISECONDS);
    this.p.i.a(this.o.b.x, TimeUnit.MILLISECONDS);
  }
  
  public final void a(hv paramhv)
  {
    this.o = paramhv;
  }
  
  public final void a(ic paramic)
    throws IOException
  {
    paramic.a(this.p.d());
  }
  
  public final gm.a b()
    throws IOException
  {
    if (this.n.a == gi.d)
    {
      List localList = this.p.c();
      Object localObject1 = null;
      gd.a locala = new gd.a();
      int i2 = localList.size();
      int i1 = 0;
      if (i1 < i2)
      {
        iq localiq = ((he)localList.get(i1)).h;
        localObject2 = ((he)localList.get(i1)).i.a();
        if (localiq.equals(he.a)) {
          localObject1 = localObject2;
        }
        for (;;)
        {
          i1 += 1;
          break;
          if (!l.contains(localiq)) {
            locala.a(localiq.a(), (String)localObject2);
          }
        }
      }
      if (localObject1 == null) {
        throw new ProtocolException("Expected ':status' header not present");
      }
      localObject1 = if.a("HTTP/1.1 " + (String)localObject1);
      Object localObject2 = new gm.a();
      ((gm.a)localObject2).b = gi.d;
      ((gm.a)localObject2).c = ((if)localObject1).b;
      ((gm.a)localObject2).d = ((if)localObject1).c;
      return ((gm.a)localObject2).a(locala.a());
    }
    return a(this.p.c());
  }
  
  public final void c()
    throws IOException
  {
    this.p.d().close();
  }
  
  final class a
    extends is
  {
    public a(jd paramjd)
    {
      super();
    }
    
    public final void close()
      throws IOException
    {
      ht.a(ht.this).a(false, ht.this);
      super.close();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ht.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */