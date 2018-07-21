package cz.msebera.android.httpclient.i.g;

import cz.msebera.android.httpclient.ae;
import cz.msebera.android.httpclient.ai;
import cz.msebera.android.httpclient.aj;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.j.h;
import cz.msebera.android.httpclient.k.l;
import cz.msebera.android.httpclient.k.w;
import cz.msebera.android.httpclient.l.i;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.o.d;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.t;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@NotThreadSafe
public abstract class a<T extends t>
  implements cz.msebera.android.httpclient.j.c<T>
{
  private static final int a = 0;
  private static final int c = 1;
  protected final w b;
  private final h d;
  private final cz.msebera.android.httpclient.d.c e;
  private final List<d> f;
  private int g;
  private T h;
  
  public a(h paramh, w paramw, cz.msebera.android.httpclient.d.c paramc)
  {
    this.d = ((h)cz.msebera.android.httpclient.o.a.a(paramh, "Session input buffer"));
    if (paramw != null)
    {
      this.b = paramw;
      if (paramc == null) {
        break label59;
      }
    }
    for (;;)
    {
      this.e = paramc;
      this.f = new ArrayList();
      this.g = 0;
      return;
      paramw = l.b;
      break;
      label59:
      paramc = cz.msebera.android.httpclient.d.c.a;
    }
  }
  
  @Deprecated
  public a(h paramh, w paramw, j paramj)
  {
    cz.msebera.android.httpclient.o.a.a(paramh, "Session input buffer");
    cz.msebera.android.httpclient.o.a.a(paramj, "HTTP parameters");
    this.d = paramh;
    this.e = i.b(paramj);
    if (paramw != null) {}
    for (;;)
    {
      this.b = paramw;
      this.f = new ArrayList();
      this.g = 0;
      return;
      paramw = l.b;
    }
  }
  
  public static f[] a(h paramh, int paramInt1, int paramInt2, w paramw)
    throws p, IOException
  {
    ArrayList localArrayList = new ArrayList();
    if (paramw != null) {}
    for (;;)
    {
      return a(paramh, paramInt1, paramInt2, paramw, localArrayList);
      paramw = l.b;
    }
  }
  
  public static f[] a(h paramh, int paramInt1, int paramInt2, w paramw, List<d> paramList)
    throws p, IOException
  {
    cz.msebera.android.httpclient.o.a.a(paramh, "Session input buffer");
    cz.msebera.android.httpclient.o.a.a(paramw, "Line parser");
    cz.msebera.android.httpclient.o.a.a(paramList, "Header line list");
    Object localObject2 = null;
    Object localObject3 = null;
    if (localObject2 == null) {}
    for (Object localObject1 = new d(64); (paramh.a((d)localObject1) == -1) || (((d)localObject1).e() < 1); localObject1 = localObject2)
    {
      paramh = new f[paramList.size()];
      paramInt1 = 0;
      while (paramInt1 < paramList.size())
      {
        localObject1 = (d)paramList.get(paramInt1);
        try
        {
          paramh[paramInt1] = paramw.a((d)localObject1);
          paramInt1 += 1;
        }
        catch (ai paramh)
        {
          int i;
          Object localObject4;
          throw new aj(paramh.getMessage());
        }
      }
      ((d)localObject2).a();
    }
    if (((((d)localObject1).a(0) == ' ') || (((d)localObject1).a(0) == '\t')) && (localObject3 != null))
    {
      i = 0;
      for (;;)
      {
        if (i < ((d)localObject1).e())
        {
          int j = ((d)localObject1).a(i);
          if ((j == 32) || (j == 9)) {}
        }
        else
        {
          if ((paramInt2 <= 0) || (((d)localObject3).e() + 1 + ((d)localObject1).e() - i <= paramInt2)) {
            break;
          }
          throw new ae("Maximum line length limit exceeded");
        }
        i += 1;
      }
      ((d)localObject3).a(' ');
      ((d)localObject3).a((d)localObject1, i, ((d)localObject1).e() - i);
      localObject4 = localObject3;
    }
    for (;;)
    {
      localObject2 = localObject1;
      localObject3 = localObject4;
      if (paramInt1 <= 0) {
        break;
      }
      localObject2 = localObject1;
      localObject3 = localObject4;
      if (paramList.size() < paramInt1) {
        break;
      }
      throw new ae("Maximum header count exceeded");
      paramList.add(localObject1);
      localObject4 = localObject1;
      localObject1 = null;
    }
    return paramh;
  }
  
  public T a()
    throws IOException, p
  {
    switch (this.g)
    {
    default: 
      throw new IllegalStateException("Inconsistent parser state");
    }
    try
    {
      this.h = b(this.d);
      this.g = 1;
      Object localObject = a(this.d, this.e.b(), this.e.a(), this.b, this.f);
      this.h.setHeaders((f[])localObject);
      localObject = this.h;
      this.h = null;
      this.f.clear();
      this.g = 0;
      return (T)localObject;
    }
    catch (ai localai)
    {
      throw new aj(localai.getMessage(), localai);
    }
  }
  
  protected abstract T b(h paramh)
    throws IOException, p, ai;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */