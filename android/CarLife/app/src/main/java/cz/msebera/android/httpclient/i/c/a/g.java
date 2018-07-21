package cz.msebera.android.httpclient.i.c.a;

import cz.msebera.android.httpclient.e.a.f;
import cz.msebera.android.httpclient.e.w;
import cz.msebera.android.httpclient.o.a;
import java.io.IOException;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

@Deprecated
public class g
{
  public cz.msebera.android.httpclient.h.b a = new cz.msebera.android.httpclient.h.b(getClass());
  protected final cz.msebera.android.httpclient.e.b.b b;
  protected final int c;
  protected final f d;
  protected final LinkedList<b> e;
  protected final Queue<i> f;
  protected int g;
  
  @Deprecated
  public g(cz.msebera.android.httpclient.e.b.b paramb, int paramInt)
  {
    this.b = paramb;
    this.c = paramInt;
    this.d = new g.1(this);
    this.e = new LinkedList();
    this.f = new LinkedList();
    this.g = 0;
  }
  
  public g(cz.msebera.android.httpclient.e.b.b paramb, f paramf)
  {
    this.b = paramb;
    this.d = paramf;
    this.c = paramf.a(paramb);
    this.e = new LinkedList();
    this.f = new LinkedList();
    this.g = 0;
  }
  
  public final cz.msebera.android.httpclient.e.b.b a()
  {
    return this.b;
  }
  
  public b a(Object paramObject)
  {
    Object localObject;
    if (!this.e.isEmpty())
    {
      localObject = this.e.listIterator(this.e.size());
      while (((ListIterator)localObject).hasPrevious())
      {
        b localb = (b)((ListIterator)localObject).previous();
        if ((localb.a() == null) || (cz.msebera.android.httpclient.o.i.a(paramObject, localb.a())))
        {
          ((ListIterator)localObject).remove();
          return localb;
        }
      }
    }
    if ((d() == 0) && (!this.e.isEmpty()))
    {
      paramObject = (b)this.e.remove();
      ((b)paramObject).b();
      localObject = ((b)paramObject).c();
      try
      {
        ((w)localObject).close();
        return (b)paramObject;
      }
      catch (IOException localIOException)
      {
        this.a.a("I/O error closing connection", localIOException);
        return (b)paramObject;
      }
    }
    return null;
  }
  
  public void a(b paramb)
  {
    if (this.g < 1) {
      throw new IllegalStateException("No entry created for this pool. " + this.b);
    }
    if (this.g <= this.e.size()) {
      throw new IllegalStateException("No entry allocated from this pool. " + this.b);
    }
    this.e.add(paramb);
  }
  
  public void a(i parami)
  {
    a.a(parami, "Waiting thread");
    this.f.add(parami);
  }
  
  public final int b()
  {
    return this.c;
  }
  
  public void b(b paramb)
  {
    a.a(this.b.equals(paramb.d()), "Entry not planned for this pool");
    this.g += 1;
  }
  
  public void b(i parami)
  {
    if (parami == null) {
      return;
    }
    this.f.remove(parami);
  }
  
  public boolean c()
  {
    return (this.g < 1) && (this.f.isEmpty());
  }
  
  public boolean c(b paramb)
  {
    boolean bool = this.e.remove(paramb);
    if (bool) {
      this.g -= 1;
    }
    return bool;
  }
  
  public int d()
  {
    return this.d.a(this.b) - this.g;
  }
  
  public final int e()
  {
    return this.g;
  }
  
  public void f()
  {
    if (this.g > 0) {}
    for (boolean bool = true;; bool = false)
    {
      cz.msebera.android.httpclient.o.b.a(bool, "There is no entry that could be dropped");
      this.g -= 1;
      return;
    }
  }
  
  public boolean g()
  {
    return !this.f.isEmpty();
  }
  
  public i h()
  {
    return (i)this.f.peek();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/c/a/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */