package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.b.a.d;
import cz.msebera.android.httpclient.b.a.h;
import cz.msebera.android.httpclient.b.a.i;
import cz.msebera.android.httpclient.b.a.l;
import cz.msebera.android.httpclient.o.a;
import java.io.Closeable;
import java.io.IOException;
import java.lang.ref.ReferenceQueue;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

@ThreadSafe
public class ah
  implements h, Closeable
{
  private final k a;
  private final ReferenceQueue<d> b;
  private final Set<am> c;
  private final AtomicBoolean d;
  
  public ah(f paramf)
  {
    this.a = new k(paramf.d());
    this.b = new ReferenceQueue();
    this.c = new HashSet();
    this.d = new AtomicBoolean(true);
  }
  
  private void a(d paramd)
  {
    if (paramd.i() != null)
    {
      paramd = new am(paramd, this.b);
      this.c.add(paramd);
    }
  }
  
  private void c()
    throws IllegalStateException
  {
    if (!this.d.get()) {
      throw new IllegalStateException("Cache has been shut down");
    }
  }
  
  public d a(String paramString)
    throws IOException
  {
    a.a(paramString, "URL");
    c();
    try
    {
      paramString = (d)this.a.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  public void a()
  {
    if (this.d.get()) {
      for (;;)
      {
        am localam = (am)this.b.poll();
        if (localam != null) {
          try
          {
            this.c.remove(localam);
            localam.a().c();
          }
          finally {}
        }
      }
    }
  }
  
  public void a(String paramString, d paramd)
    throws IOException
  {
    a.a(paramString, "URL");
    a.a(paramd, "Cache entry");
    c();
    try
    {
      this.a.put(paramString, paramd);
      a(paramd);
      return;
    }
    finally {}
  }
  
  public void a(String paramString, i parami)
    throws IOException
  {
    a.a(paramString, "URL");
    a.a(parami, "Callback");
    c();
    try
    {
      d locald = (d)this.a.get(paramString);
      parami = parami.a(locald);
      this.a.put(paramString, parami);
      if (locald != parami) {
        a(parami);
      }
      return;
    }
    finally {}
  }
  
  public void b()
  {
    if (this.d.compareAndSet(true, false))
    {
      try
      {
        this.a.clear();
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext()) {
          ((am)localIterator.next()).a().c();
        }
        this.c.clear();
      }
      finally {}
      while (this.b.poll() != null) {}
    }
  }
  
  public void b(String paramString)
    throws IOException
  {
    a.a(paramString, "URL");
    c();
    try
    {
      this.a.remove(paramString);
      return;
    }
    finally {}
  }
  
  public void close()
  {
    b();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/ah.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */