package cz.msebera.android.httpclient.i.g;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.j.e;
import cz.msebera.android.httpclient.k.k;
import cz.msebera.android.httpclient.k.v;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.d;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.t;
import java.io.IOException;

@NotThreadSafe
public abstract class b<T extends t>
  implements e<T>
{
  protected final cz.msebera.android.httpclient.j.i a;
  protected final d b;
  protected final v c;
  
  public b(cz.msebera.android.httpclient.j.i parami, v paramv)
  {
    this.a = ((cz.msebera.android.httpclient.j.i)a.a(parami, "Session input buffer"));
    if (paramv != null) {}
    for (;;)
    {
      this.c = paramv;
      this.b = new d(128);
      return;
      paramv = k.b;
    }
  }
  
  @Deprecated
  public b(cz.msebera.android.httpclient.j.i parami, v paramv, j paramj)
  {
    a.a(parami, "Session input buffer");
    this.a = parami;
    this.b = new d(128);
    if (paramv != null) {}
    for (;;)
    {
      this.c = paramv;
      return;
      paramv = k.b;
    }
  }
  
  protected abstract void a(T paramT)
    throws IOException;
  
  public void b(T paramT)
    throws IOException, p
  {
    a.a(paramT, "HTTP message");
    a(paramT);
    paramT = paramT.headerIterator();
    while (paramT.hasNext())
    {
      f localf = paramT.a();
      this.a.a(this.c.a(this.b, localf));
    }
    this.b.a();
    this.a.a(this.b);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/g/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */