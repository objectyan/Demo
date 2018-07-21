package cz.msebera.android.httpclient.g.a;

import cz.msebera.android.httpclient.g.g;

public class b
{
  private final String a;
  private final c b;
  private final cz.msebera.android.httpclient.g.a.a.c c;
  
  public b(String paramString, cz.msebera.android.httpclient.g.a.a.c paramc)
  {
    cz.msebera.android.httpclient.o.a.a(paramString, "Name");
    cz.msebera.android.httpclient.o.a.a(paramc, "Body");
    this.a = paramString;
    this.c = paramc;
    this.b = new c();
    a(paramc);
    b(paramc);
    c(paramc);
  }
  
  public String a()
  {
    return this.a;
  }
  
  protected void a(cz.msebera.android.httpclient.g.a.a.c paramc)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("form-data; name=\"");
    localStringBuilder.append(a());
    localStringBuilder.append("\"");
    if (paramc.f() != null)
    {
      localStringBuilder.append("; filename=\"");
      localStringBuilder.append(paramc.f());
      localStringBuilder.append("\"");
    }
    a("Content-Disposition", localStringBuilder.toString());
  }
  
  public void a(String paramString1, String paramString2)
  {
    cz.msebera.android.httpclient.o.a.a(paramString1, "Field name");
    this.b.a(new i(paramString1, paramString2));
  }
  
  public cz.msebera.android.httpclient.g.a.a.c b()
  {
    return this.c;
  }
  
  protected void b(cz.msebera.android.httpclient.g.a.a.c paramc)
  {
    if ((paramc instanceof cz.msebera.android.httpclient.g.a.a.a)) {}
    for (Object localObject = ((cz.msebera.android.httpclient.g.a.a.a)paramc).a(); localObject != null; localObject = null)
    {
      a("Content-Type", ((g)localObject).toString());
      return;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramc.b());
    if (paramc.e() != null)
    {
      ((StringBuilder)localObject).append("; charset=");
      ((StringBuilder)localObject).append(paramc.e());
    }
    a("Content-Type", ((StringBuilder)localObject).toString());
  }
  
  public c c()
  {
    return this.b;
  }
  
  protected void c(cz.msebera.android.httpclient.g.a.a.c paramc)
  {
    a("Content-Transfer-Encoding", paramc.g());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/g/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */