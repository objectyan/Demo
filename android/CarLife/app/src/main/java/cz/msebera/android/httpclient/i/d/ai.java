package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.f.b;
import cz.msebera.android.httpclient.f.c;
import cz.msebera.android.httpclient.f.e;
import cz.msebera.android.httpclient.f.l;
import cz.msebera.android.httpclient.f.n;
import cz.msebera.android.httpclient.g;
import cz.msebera.android.httpclient.k.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@NotThreadSafe
public class ai
  extends ab
{
  public ai()
  {
    this(null, false);
  }
  
  public ai(String[] paramArrayOfString, boolean paramBoolean)
  {
    super(paramArrayOfString, paramBoolean);
    a("domain", new ag());
    a("port", new ah());
    a("commenturl", new ae());
    a("discard", new af());
    a("version", new ak());
  }
  
  private List<b> b(g[] paramArrayOfg, e parame)
    throws l
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfg.length);
    int k = paramArrayOfg.length;
    int i = 0;
    while (i < k)
    {
      Object localObject2 = paramArrayOfg[i];
      Object localObject1 = ((g)localObject2).a();
      Object localObject3 = ((g)localObject2).b();
      if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
        throw new l("Cookie name may not be empty");
      }
      localObject1 = new d((String)localObject1, (String)localObject3);
      ((d)localObject1).f(a(parame));
      ((d)localObject1).e(b(parame));
      ((d)localObject1).a(new int[] { parame.c() });
      localObject2 = ((g)localObject2).c();
      localObject3 = new HashMap(localObject2.length);
      int j = localObject2.length - 1;
      Object localObject4;
      while (j >= 0)
      {
        localObject4 = localObject2[j];
        ((Map)localObject3).put(((cz.msebera.android.httpclient.ag)localObject4).a().toLowerCase(Locale.ENGLISH), localObject4);
        j -= 1;
      }
      localObject2 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (cz.msebera.android.httpclient.ag)((Map.Entry)((Iterator)localObject2).next()).getValue();
        localObject4 = ((cz.msebera.android.httpclient.ag)localObject3).a().toLowerCase(Locale.ENGLISH);
        ((d)localObject1).a((String)localObject4, ((cz.msebera.android.httpclient.ag)localObject3).b());
        localObject4 = a((String)localObject4);
        if (localObject4 != null) {
          ((c)localObject4).a((n)localObject1, ((cz.msebera.android.httpclient.ag)localObject3).b());
        }
      }
      localArrayList.add(localObject1);
      i += 1;
    }
    return localArrayList;
  }
  
  private static e c(e parame)
  {
    String str = parame.a();
    int k = 1;
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < str.length())
      {
        j = str.charAt(i);
        if ((j == 46) || (j == 58)) {
          j = 0;
        }
      }
      else
      {
        e locale = parame;
        if (j != 0) {
          locale = new e(str + ".local", parame.c(), parame.b(), parame.d());
        }
        return locale;
      }
      i += 1;
    }
  }
  
  public int a()
  {
    return 1;
  }
  
  public List<b> a(f paramf, e parame)
    throws l
  {
    cz.msebera.android.httpclient.o.a.a(paramf, "Header");
    cz.msebera.android.httpclient.o.a.a(parame, "Cookie origin");
    if (!paramf.c().equalsIgnoreCase("Set-Cookie2")) {
      throw new l("Unrecognized cookie header '" + paramf.toString() + "'");
    }
    return b(paramf.e(), c(parame));
  }
  
  protected List<b> a(g[] paramArrayOfg, e parame)
    throws l
  {
    return b(paramArrayOfg, c(parame));
  }
  
  public void a(b paramb, e parame)
    throws l
  {
    cz.msebera.android.httpclient.o.a.a(paramb, "Cookie");
    cz.msebera.android.httpclient.o.a.a(parame, "Cookie origin");
    super.a(paramb, c(parame));
  }
  
  protected void a(cz.msebera.android.httpclient.o.d paramd, b paramb, int paramInt)
  {
    super.a(paramd, paramb, paramInt);
    if ((paramb instanceof cz.msebera.android.httpclient.f.a))
    {
      String str = ((cz.msebera.android.httpclient.f.a)paramb).a("port");
      if (str != null)
      {
        paramd.a("; $Port");
        paramd.a("=\"");
        if (str.trim().length() > 0)
        {
          paramb = paramb.i();
          if (paramb != null)
          {
            int i = paramb.length;
            paramInt = 0;
            while (paramInt < i)
            {
              if (paramInt > 0) {
                paramd.a(",");
              }
              paramd.a(Integer.toString(paramb[paramInt]));
              paramInt += 1;
            }
          }
        }
        paramd.a("\"");
      }
    }
  }
  
  public f b()
  {
    cz.msebera.android.httpclient.o.d locald = new cz.msebera.android.httpclient.o.d(40);
    locald.a("Cookie2");
    locald.a(": ");
    locald.a("$Version=");
    locald.a(Integer.toString(a()));
    return new r(locald);
  }
  
  public boolean b(b paramb, e parame)
  {
    cz.msebera.android.httpclient.o.a.a(paramb, "Cookie");
    cz.msebera.android.httpclient.o.a.a(parame, "Cookie origin");
    return super.b(paramb, c(parame));
  }
  
  public String toString()
  {
    return "rfc2965";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */