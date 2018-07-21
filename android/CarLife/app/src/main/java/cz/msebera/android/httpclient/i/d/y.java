package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.b.g.f;
import cz.msebera.android.httpclient.f.b;
import cz.msebera.android.httpclient.f.c;
import cz.msebera.android.httpclient.f.e;
import cz.msebera.android.httpclient.f.l;
import cz.msebera.android.httpclient.f.n;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class y
  implements c
{
  private final c a;
  private Set<String> b;
  private Set<String> c;
  
  public y(c paramc)
  {
    this.a = paramc;
  }
  
  private boolean a(b paramb)
  {
    Object localObject = paramb.g();
    paramb = (b)localObject;
    if (((String)localObject).startsWith(".")) {
      paramb = ((String)localObject).substring(1);
    }
    paramb = f.a(paramb);
    if ((this.b != null) && (this.b.contains(paramb))) {}
    while (this.c == null) {
      return false;
    }
    do
    {
      if (this.c.contains(paramb)) {
        return true;
      }
      localObject = paramb;
      if (paramb.startsWith("*.")) {
        localObject = paramb.substring(2);
      }
      int i = ((String)localObject).indexOf('.');
      if (i == -1) {
        break;
      }
      localObject = "*" + ((String)localObject).substring(i);
      paramb = (b)localObject;
    } while (((String)localObject).length() > 0);
    return false;
  }
  
  public void a(b paramb, e parame)
    throws l
  {
    this.a.a(paramb, parame);
  }
  
  public void a(n paramn, String paramString)
    throws l
  {
    this.a.a(paramn, paramString);
  }
  
  public void a(Collection<String> paramCollection)
  {
    this.c = new HashSet(paramCollection);
  }
  
  public void b(Collection<String> paramCollection)
  {
    this.b = new HashSet(paramCollection);
  }
  
  public boolean b(b paramb, e parame)
  {
    if (a(paramb)) {
      return false;
    }
    return this.a.b(paramb, parame);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */