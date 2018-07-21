package cz.msebera.android.httpclient.i.a;

import cz.msebera.android.httpclient.a.n;
import cz.msebera.android.httpclient.a.o;
import cz.msebera.android.httpclient.a.p;
import cz.msebera.android.httpclient.a.q;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.k.r;
import cz.msebera.android.httpclient.o.d;
import cz.msebera.android.httpclient.u;

@NotThreadSafe
public class k
  extends a
{
  private final h a;
  private a b;
  private String c;
  
  public k()
  {
    this(new j());
  }
  
  public k(h paramh)
  {
    cz.msebera.android.httpclient.o.a.a(paramh, "NTLM engine");
    this.a = paramh;
    this.b = a.a;
    this.c = null;
  }
  
  public f a(n paramn, u paramu)
    throws cz.msebera.android.httpclient.a.j
  {
    try
    {
      paramu = (q)paramn;
      if (this.b == a.f) {
        throw new cz.msebera.android.httpclient.a.j("NTLM authentication failed");
      }
    }
    catch (ClassCastException paramu)
    {
      throw new o("Credentials cannot be used for NTLM authentication: " + paramn.getClass().getName());
    }
    if (this.b == a.b)
    {
      paramn = this.a.a(paramu.d(), paramu.e());
      this.b = a.c;
      paramu = new d(32);
      if (!e()) {
        break label217;
      }
      paramu.a("Proxy-Authorization");
    }
    for (;;)
    {
      paramu.a(": NTLM ");
      paramu.a(paramn);
      return new r(paramu);
      if (this.b == a.d)
      {
        paramn = this.a.a(paramu.c(), paramu.b(), paramu.d(), paramu.e(), this.c);
        this.b = a.e;
        break;
      }
      throw new cz.msebera.android.httpclient.a.j("Unexpected state: " + this.b);
      label217:
      paramu.a("Authorization");
    }
  }
  
  public String a()
  {
    return "ntlm";
  }
  
  public String a(String paramString)
  {
    return null;
  }
  
  protected void a(d paramd, int paramInt1, int paramInt2)
    throws p
  {
    this.c = paramd.b(paramInt1, paramInt2);
    if (this.c.length() == 0) {
      if (this.b == a.a) {
        this.b = a.b;
      }
    }
    do
    {
      return;
      this.b = a.f;
      return;
      if (this.b.compareTo(a.c) < 0)
      {
        this.b = a.f;
        throw new p("Out of sequence NTLM response message");
      }
    } while (this.b != a.c);
    this.b = a.d;
  }
  
  public String b()
  {
    return null;
  }
  
  public boolean c()
  {
    return true;
  }
  
  public boolean d()
  {
    return (this.b == a.e) || (this.b == a.f);
  }
  
  static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/a/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */