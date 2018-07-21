package cz.msebera.android.httpclient.k;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.e;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.h;
import cz.msebera.android.httpclient.i;
import cz.msebera.android.httpclient.o.a;
import java.util.NoSuchElementException;

@NotThreadSafe
public class d
  implements h
{
  private final i a;
  private final u b;
  private cz.msebera.android.httpclient.g c = null;
  private cz.msebera.android.httpclient.o.d d = null;
  private x e = null;
  
  public d(i parami)
  {
    this(parami, g.b);
  }
  
  public d(i parami, u paramu)
  {
    this.a = ((i)a.a(parami, "Header iterator"));
    this.b = ((u)a.a(paramu, "Parser"));
  }
  
  private void b()
  {
    this.e = null;
    this.d = null;
    Object localObject;
    do
    {
      if (this.a.hasNext())
      {
        localObject = this.a.a();
        if ((localObject instanceof e))
        {
          this.d = ((e)localObject).a();
          this.e = new x(0, this.d.e());
          this.e.a(((e)localObject).b());
        }
      }
      else
      {
        return;
      }
      localObject = ((f)localObject).d();
    } while (localObject == null);
    this.d = new cz.msebera.android.httpclient.o.d(((String)localObject).length());
    this.d.a((String)localObject);
    this.e = new x(0, this.d.e());
  }
  
  private void c()
  {
    for (;;)
    {
      if ((this.a.hasNext()) || (this.e != null))
      {
        if ((this.e == null) || (this.e.d())) {
          b();
        }
        if (this.e == null) {}
      }
      else
      {
        while (!this.e.d())
        {
          cz.msebera.android.httpclient.g localg = this.b.b(this.d, this.e);
          if ((localg.a().length() != 0) || (localg.b() != null))
          {
            this.c = localg;
            return;
          }
        }
        if (this.e.d())
        {
          this.e = null;
          this.d = null;
        }
      }
    }
  }
  
  public cz.msebera.android.httpclient.g a()
    throws NoSuchElementException
  {
    if (this.c == null) {
      c();
    }
    if (this.c == null) {
      throw new NoSuchElementException("No more header elements available");
    }
    cz.msebera.android.httpclient.g localg = this.c;
    this.c = null;
    return localg;
  }
  
  public boolean hasNext()
  {
    if (this.c == null) {
      c();
    }
    return this.c != null;
  }
  
  public final Object next()
    throws NoSuchElementException
  {
    return a();
  }
  
  public void remove()
    throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException("Remove not supported");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/k/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */