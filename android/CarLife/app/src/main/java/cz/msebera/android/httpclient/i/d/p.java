package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.ag;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.f.e;
import cz.msebera.android.httpclient.f.l;
import cz.msebera.android.httpclient.f.n;
import cz.msebera.android.httpclient.g;
import cz.msebera.android.httpclient.o.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

@NotThreadSafe
public abstract class p
  extends b
{
  protected static String a(e parame)
  {
    String str = parame.b();
    int j = str.lastIndexOf('/');
    parame = str;
    if (j >= 0)
    {
      int i = j;
      if (j == 0) {
        i = 1;
      }
      parame = str.substring(0, i);
    }
    return parame;
  }
  
  protected static String b(e parame)
  {
    return parame.a();
  }
  
  protected List<cz.msebera.android.httpclient.f.b> a(g[] paramArrayOfg, e parame)
    throws l
  {
    ArrayList localArrayList = new ArrayList(paramArrayOfg.length);
    int k = paramArrayOfg.length;
    int i = 0;
    while (i < k)
    {
      Object localObject2 = paramArrayOfg[i];
      Object localObject1 = ((g)localObject2).a();
      String str = ((g)localObject2).b();
      if ((localObject1 == null) || (((String)localObject1).length() == 0)) {
        throw new l("Cookie name may not be empty");
      }
      localObject1 = new c((String)localObject1, str);
      ((c)localObject1).f(a(parame));
      ((c)localObject1).e(b(parame));
      localObject2 = ((g)localObject2).c();
      int j = localObject2.length - 1;
      while (j >= 0)
      {
        str = localObject2[j];
        Object localObject3 = str.a().toLowerCase(Locale.ENGLISH);
        ((c)localObject1).a((String)localObject3, str.b());
        localObject3 = a((String)localObject3);
        if (localObject3 != null) {
          ((cz.msebera.android.httpclient.f.c)localObject3).a((n)localObject1, str.b());
        }
        j -= 1;
      }
      localArrayList.add(localObject1);
      i += 1;
    }
    return localArrayList;
  }
  
  public void a(cz.msebera.android.httpclient.f.b paramb, e parame)
    throws l
  {
    a.a(paramb, "Cookie");
    a.a(parame, "Cookie origin");
    Iterator localIterator = c().iterator();
    while (localIterator.hasNext()) {
      ((cz.msebera.android.httpclient.f.c)localIterator.next()).a(paramb, parame);
    }
  }
  
  public boolean b(cz.msebera.android.httpclient.f.b paramb, e parame)
  {
    a.a(paramb, "Cookie");
    a.a(parame, "Cookie origin");
    Iterator localIterator = c().iterator();
    while (localIterator.hasNext()) {
      if (!((cz.msebera.android.httpclient.f.c)localIterator.next()).b(paramb, parame)) {
        return false;
      }
    }
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */