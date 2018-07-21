package cz.msebera.android.httpclient.i.b;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.d.q;
import cz.msebera.android.httpclient.b.f.c;
import cz.msebera.android.httpclient.b.k;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.o;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.u;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.net.ssl.SSLException;

@Immutable
public class t
  implements k
{
  public static final t a = new t();
  private final int b;
  private final boolean c;
  private final Set<Class<? extends IOException>> d;
  
  public t()
  {
    this(3, false);
  }
  
  public t(int paramInt, boolean paramBoolean)
  {
    this(paramInt, paramBoolean, Arrays.asList(new Class[] { InterruptedIOException.class, UnknownHostException.class, ConnectException.class, SSLException.class }));
  }
  
  protected t(int paramInt, boolean paramBoolean, Collection<Class<? extends IOException>> paramCollection)
  {
    this.b = paramInt;
    this.c = paramBoolean;
    this.d = new HashSet();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      Class localClass = (Class)paramCollection.next();
      this.d.add(localClass);
    }
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  protected boolean a(u paramu)
  {
    return !(paramu instanceof o);
  }
  
  public int b()
  {
    return this.b;
  }
  
  @Deprecated
  protected boolean b(u paramu)
  {
    u localu = paramu;
    if ((paramu instanceof as)) {
      localu = ((as)paramu).c();
    }
    return ((localu instanceof q)) && (((q)localu).isAborted());
  }
  
  public boolean retryRequest(IOException paramIOException, int paramInt, g paramg)
  {
    a.a(paramIOException, "Exception parameter");
    a.a(paramg, "HTTP context");
    if (paramInt > this.b) {}
    do
    {
      do
      {
        do
        {
          return false;
        } while (this.d.contains(paramIOException.getClass()));
        Iterator localIterator = this.d.iterator();
        while (localIterator.hasNext()) {
          if (((Class)localIterator.next()).isInstance(paramIOException)) {
            return false;
          }
        }
        paramIOException = c.b(paramg);
        paramg = paramIOException.s();
      } while (b(paramg));
      if (a(paramg)) {
        return true;
      }
    } while ((paramIOException.t()) && (!this.c));
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/b/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */