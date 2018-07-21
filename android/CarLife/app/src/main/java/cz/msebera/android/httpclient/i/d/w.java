package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.f.b;
import cz.msebera.android.httpclient.f.l;
import cz.msebera.android.httpclient.k.r;
import cz.msebera.android.httpclient.k.x;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.d;
import java.util.ArrayList;
import java.util.List;

@NotThreadSafe
public class w
  extends p
{
  protected static final String a = "EEE, dd-MMM-yy HH:mm:ss z";
  private final String[] b;
  
  public w()
  {
    this(null);
  }
  
  public w(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null) {}
    for (this.b = ((String[])paramArrayOfString.clone());; this.b = new String[] { "EEE, dd-MMM-yy HH:mm:ss z" })
    {
      a("path", new i());
      a("domain", new u());
      a("secure", new j());
      a("comment", new e());
      a("expires", new g(this.b));
      return;
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public List<b> a(f paramf, cz.msebera.android.httpclient.f.e parame)
    throws l
  {
    a.a(paramf, "Header");
    a.a(parame, "Cookie origin");
    if (!paramf.c().equalsIgnoreCase("Set-Cookie")) {
      throw new l("Unrecognized cookie header '" + paramf.toString() + "'");
    }
    v localv = v.a;
    Object localObject;
    if ((paramf instanceof cz.msebera.android.httpclient.e))
    {
      d locald = ((cz.msebera.android.httpclient.e)paramf).a();
      localObject = new x(((cz.msebera.android.httpclient.e)paramf).b(), locald.e());
      paramf = locald;
    }
    for (;;)
    {
      return a(new cz.msebera.android.httpclient.g[] { localv.a(paramf, (x)localObject) }, parame);
      localObject = paramf.d();
      if (localObject == null) {
        throw new l("Header value is null");
      }
      paramf = new d(((String)localObject).length());
      paramf.a((String)localObject);
      localObject = new x(0, paramf.e());
    }
  }
  
  public List<f> a(List<b> paramList)
  {
    a.a(paramList, "List of cookies");
    d locald = new d(paramList.size() * 20);
    locald.a("Cookie");
    locald.a(": ");
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject = (b)paramList.get(i);
      if (i > 0) {
        locald.a("; ");
      }
      locald.a(((b)localObject).a());
      localObject = ((b)localObject).b();
      if (localObject != null)
      {
        locald.a("=");
        locald.a((String)localObject);
      }
      i += 1;
    }
    paramList = new ArrayList(1);
    paramList.add(new r(locald));
    return paramList;
  }
  
  public f b()
  {
    return null;
  }
  
  public String toString()
  {
    return "netscape";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */