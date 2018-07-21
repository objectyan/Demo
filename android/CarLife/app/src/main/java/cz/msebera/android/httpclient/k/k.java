package cz.msebera.android.httpclient.k;

import cz.msebera.android.httpclient.ak;
import cz.msebera.android.httpclient.am;
import cz.msebera.android.httpclient.an;
import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.e;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.d;

@Immutable
public class k
  implements v
{
  @Deprecated
  public static final k a = new k();
  public static final k b = new k();
  
  public static String a(ak paramak, v paramv)
  {
    if (paramv != null) {}
    for (;;)
    {
      return paramv.a(null, paramak).toString();
      paramv = b;
    }
  }
  
  public static String a(am paramam, v paramv)
  {
    if (paramv != null) {}
    for (;;)
    {
      return paramv.a(null, paramam).toString();
      paramv = b;
    }
  }
  
  public static String a(an paraman, v paramv)
  {
    if (paramv != null) {}
    for (;;)
    {
      return paramv.a(null, paraman).toString();
      paramv = b;
    }
  }
  
  public static String a(f paramf, v paramv)
  {
    if (paramv != null) {}
    for (;;)
    {
      return paramv.a(null, paramf).toString();
      paramv = b;
    }
  }
  
  protected int a(ak paramak)
  {
    return paramak.a().length() + 4;
  }
  
  protected d a(d paramd)
  {
    if (paramd != null)
    {
      paramd.a();
      return paramd;
    }
    return new d(64);
  }
  
  public d a(d paramd, ak paramak)
  {
    a.a(paramak, "Protocol version");
    int i = a(paramak);
    if (paramd == null) {
      paramd = new d(i);
    }
    for (;;)
    {
      paramd.a(paramak.a());
      paramd.a('/');
      paramd.a(Integer.toString(paramak.b()));
      paramd.a('.');
      paramd.a(Integer.toString(paramak.c()));
      return paramd;
      paramd.b(i);
    }
  }
  
  public d a(d paramd, am paramam)
  {
    a.a(paramam, "Request line");
    paramd = a(paramd);
    b(paramd, paramam);
    return paramd;
  }
  
  public d a(d paramd, an paraman)
  {
    a.a(paraman, "Status line");
    paramd = a(paramd);
    b(paramd, paraman);
    return paramd;
  }
  
  public d a(d paramd, f paramf)
  {
    a.a(paramf, "Header");
    if ((paramf instanceof e)) {
      return ((e)paramf).a();
    }
    paramd = a(paramd);
    b(paramd, paramf);
    return paramd;
  }
  
  protected void b(d paramd, am paramam)
  {
    String str1 = paramam.a();
    String str2 = paramam.c();
    paramd.b(str1.length() + 1 + str2.length() + 1 + a(paramam.b()));
    paramd.a(str1);
    paramd.a(' ');
    paramd.a(str2);
    paramd.a(' ');
    a(paramd, paramam.b());
  }
  
  protected void b(d paramd, an paraman)
  {
    int j = a(paraman.a()) + 1 + 3 + 1;
    String str = paraman.c();
    int i = j;
    if (str != null) {
      i = j + str.length();
    }
    paramd.b(i);
    a(paramd, paraman.a());
    paramd.a(' ');
    paramd.a(Integer.toString(paraman.b()));
    paramd.a(' ');
    if (str != null) {
      paramd.a(str);
    }
  }
  
  protected void b(d paramd, f paramf)
  {
    String str = paramf.c();
    paramf = paramf.d();
    int j = str.length() + 2;
    int i = j;
    if (paramf != null) {
      i = j + paramf.length();
    }
    paramd.b(i);
    paramd.a(str);
    paramd.a(": ");
    if (paramf != null) {
      paramd.a(paramf);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/k/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */