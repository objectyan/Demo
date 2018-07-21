package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.f.b;
import cz.msebera.android.httpclient.f.l;
import cz.msebera.android.httpclient.k.r;
import cz.msebera.android.httpclient.o.d;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

@NotThreadSafe
public class ab
  extends p
{
  private static final cz.msebera.android.httpclient.f.f a = new cz.msebera.android.httpclient.f.f();
  private static final String[] b = { "EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy" };
  private final String[] c;
  private final boolean d;
  
  public ab()
  {
    this(null, false);
  }
  
  public ab(String[] paramArrayOfString, boolean paramBoolean)
  {
    if (paramArrayOfString != null) {}
    for (this.c = ((String[])paramArrayOfString.clone());; this.c = b)
    {
      this.d = paramBoolean;
      a("version", new ad());
      a("path", new i());
      a("domain", new aa());
      a("max-age", new h());
      a("secure", new j());
      a("comment", new e());
      a("expires", new g(this.c));
      return;
    }
  }
  
  private List<cz.msebera.android.httpclient.f> b(List<b> paramList)
  {
    int i = Integer.MAX_VALUE;
    Object localObject = paramList.iterator();
    b localb;
    while (((Iterator)localObject).hasNext())
    {
      localb = (b)((Iterator)localObject).next();
      if (localb.k() < i) {
        i = localb.k();
      }
    }
    localObject = new d(paramList.size() * 40);
    ((d)localObject).a("Cookie");
    ((d)localObject).a(": ");
    ((d)localObject).a("$Version=");
    ((d)localObject).a(Integer.toString(i));
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      localb = (b)paramList.next();
      ((d)localObject).a("; ");
      a((d)localObject, localb, i);
    }
    paramList = new ArrayList(1);
    paramList.add(new r((d)localObject));
    return paramList;
  }
  
  private List<cz.msebera.android.httpclient.f> c(List<b> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      b localb = (b)paramList.next();
      int i = localb.k();
      d locald = new d(40);
      locald.a("Cookie: ");
      locald.a("$Version=");
      locald.a(Integer.toString(i));
      locald.a("; ");
      a(locald, localb, i);
      localArrayList.add(new r(locald));
    }
    return localArrayList;
  }
  
  public int a()
  {
    return 1;
  }
  
  public List<b> a(cz.msebera.android.httpclient.f paramf, cz.msebera.android.httpclient.f.e parame)
    throws l
  {
    cz.msebera.android.httpclient.o.a.a(paramf, "Header");
    cz.msebera.android.httpclient.o.a.a(parame, "Cookie origin");
    if (!paramf.c().equalsIgnoreCase("Set-Cookie")) {
      throw new l("Unrecognized cookie header '" + paramf.toString() + "'");
    }
    return a(paramf.e(), parame);
  }
  
  public List<cz.msebera.android.httpclient.f> a(List<b> paramList)
  {
    cz.msebera.android.httpclient.o.a.a(paramList, "List of cookies");
    if (paramList.size() > 1)
    {
      paramList = new ArrayList(paramList);
      Collections.sort(paramList, a);
    }
    while (this.d) {
      return b(paramList);
    }
    return c(paramList);
  }
  
  public void a(b paramb, cz.msebera.android.httpclient.f.e parame)
    throws l
  {
    cz.msebera.android.httpclient.o.a.a(paramb, "Cookie");
    String str = paramb.a();
    if (str.indexOf(' ') != -1) {
      throw new cz.msebera.android.httpclient.f.g("Cookie name may not contain blanks");
    }
    if (str.startsWith("$")) {
      throw new cz.msebera.android.httpclient.f.g("Cookie name may not start with $");
    }
    super.a(paramb, parame);
  }
  
  protected void a(d paramd, b paramb, int paramInt)
  {
    a(paramd, paramb.a(), paramb.b(), paramInt);
    if ((paramb.h() != null) && ((paramb instanceof cz.msebera.android.httpclient.f.a)) && (((cz.msebera.android.httpclient.f.a)paramb).b("path")))
    {
      paramd.a("; ");
      a(paramd, "$Path", paramb.h(), paramInt);
    }
    if ((paramb.g() != null) && ((paramb instanceof cz.msebera.android.httpclient.f.a)) && (((cz.msebera.android.httpclient.f.a)paramb).b("domain")))
    {
      paramd.a("; ");
      a(paramd, "$Domain", paramb.g(), paramInt);
    }
  }
  
  protected void a(d paramd, String paramString1, String paramString2, int paramInt)
  {
    paramd.a(paramString1);
    paramd.a("=");
    if (paramString2 != null)
    {
      if (paramInt > 0)
      {
        paramd.a('"');
        paramd.a(paramString2);
        paramd.a('"');
      }
    }
    else {
      return;
    }
    paramd.a(paramString2);
  }
  
  public cz.msebera.android.httpclient.f b()
  {
    return null;
  }
  
  public String toString()
  {
    return "rfc2109";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/ab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */