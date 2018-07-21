package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.ag;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.f.b;
import cz.msebera.android.httpclient.f.l;
import cz.msebera.android.httpclient.k.r;
import cz.msebera.android.httpclient.k.x;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.d;
import cz.msebera.android.httpclient.o.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

@NotThreadSafe
public class m
  extends p
{
  private static final String[] a = { "EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z" };
  private final String[] b;
  
  public m()
  {
    this(null, n.a.a);
  }
  
  public m(String[] paramArrayOfString)
  {
    this(paramArrayOfString, n.a.a);
  }
  
  public m(String[] paramArrayOfString, n.a parama)
  {
    if (paramArrayOfString != null) {}
    for (this.b = ((String[])paramArrayOfString.clone());; this.b = a) {
      switch (2.a[parama.ordinal()])
      {
      default: 
        throw new RuntimeException("Unknown security level");
      }
    }
    a("path", new i());
    for (;;)
    {
      a("domain", new f());
      a("max-age", new h());
      a("secure", new j());
      a("comment", new e());
      a("expires", new g(this.b));
      a("version", new o());
      return;
      a("path", new i()
      {
        public void a(b paramAnonymousb, cz.msebera.android.httpclient.f.e paramAnonymouse)
          throws l
        {}
      });
    }
  }
  
  private static boolean c(String paramString)
  {
    return (paramString != null) && (paramString.startsWith("\"")) && (paramString.endsWith("\""));
  }
  
  public int a()
  {
    return 0;
  }
  
  public List<b> a(cz.msebera.android.httpclient.f paramf, cz.msebera.android.httpclient.f.e parame)
    throws l
  {
    a.a(paramf, "Header");
    a.a(parame, "Cookie origin");
    if (!paramf.c().equalsIgnoreCase("Set-Cookie")) {
      throw new l("Unrecognized cookie header '" + paramf.toString() + "'");
    }
    Object localObject1 = paramf.e();
    int k = 0;
    int i = 0;
    int m = localObject1.length;
    int j = 0;
    Object localObject2;
    while (j < m)
    {
      localObject2 = localObject1[j];
      if (((cz.msebera.android.httpclient.g)localObject2).a("version") != null) {
        k = 1;
      }
      if (((cz.msebera.android.httpclient.g)localObject2).a("expires") != null) {
        i = 1;
      }
      j += 1;
    }
    if ((i != 0) || (k == 0))
    {
      v localv = v.a;
      if ((paramf instanceof cz.msebera.android.httpclient.e))
      {
        localObject2 = ((cz.msebera.android.httpclient.e)paramf).a();
        localObject1 = new x(((cz.msebera.android.httpclient.e)paramf).b(), ((d)localObject2).e());
        paramf = (cz.msebera.android.httpclient.f)localObject2;
      }
      for (;;)
      {
        localObject1 = localv.a(paramf, (x)localObject1);
        paramf = ((cz.msebera.android.httpclient.g)localObject1).a();
        localObject2 = ((cz.msebera.android.httpclient.g)localObject1).b();
        if ((paramf != null) && (!k.b(paramf))) {
          break;
        }
        throw new l("Cookie name may not be empty");
        localObject1 = paramf.d();
        if (localObject1 == null) {
          throw new l("Header value is null");
        }
        paramf = new d(((String)localObject1).length());
        paramf.a((String)localObject1);
        localObject1 = new x(0, paramf.e());
      }
      paramf = new c(paramf, (String)localObject2);
      paramf.f(a(parame));
      paramf.e(b(parame));
      parame = ((cz.msebera.android.httpclient.g)localObject1).c();
      j = parame.length - 1;
      while (j >= 0)
      {
        localObject1 = parame[j];
        localObject2 = ((ag)localObject1).a().toLowerCase(Locale.ENGLISH);
        paramf.a((String)localObject2, ((ag)localObject1).b());
        localObject2 = a((String)localObject2);
        if (localObject2 != null) {
          ((cz.msebera.android.httpclient.f.c)localObject2).a(paramf, ((ag)localObject1).b());
        }
        j -= 1;
      }
      if (i != 0) {
        paramf.a(0);
      }
      return Collections.singletonList(paramf);
    }
    return a((cz.msebera.android.httpclient.g[])localObject1, parame);
  }
  
  public List<cz.msebera.android.httpclient.f> a(List<b> paramList)
  {
    a.a(paramList, "List of cookies");
    d locald = new d(paramList.size() * 20);
    locald.a("Cookie");
    locald.a(": ");
    int i = 0;
    if (i < paramList.size())
    {
      b localb = (b)paramList.get(i);
      if (i > 0) {
        locald.a("; ");
      }
      String str1 = localb.a();
      String str2 = localb.b();
      if ((localb.k() > 0) && (!c(str2))) {
        cz.msebera.android.httpclient.k.f.b.a(locald, new cz.msebera.android.httpclient.k.c(str1, str2), false);
      }
      for (;;)
      {
        i += 1;
        break;
        locald.a(str1);
        locald.a("=");
        if (str2 != null) {
          locald.a(str2);
        }
      }
    }
    paramList = new ArrayList(1);
    paramList.add(new r(locald));
    return paramList;
  }
  
  public cz.msebera.android.httpclient.f b()
  {
    return null;
  }
  
  public String toString()
  {
    return "compatibility";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */