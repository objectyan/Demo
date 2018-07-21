package cz.msebera.android.httpclient.a;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.o.a;
import java.util.Queue;

@NotThreadSafe
public class i
{
  private c a = c.a;
  private d b;
  private h c;
  private n d;
  private Queue<b> e;
  
  public void a()
  {
    this.a = c.a;
    this.e = null;
    this.b = null;
    this.c = null;
    this.d = null;
  }
  
  public void a(c paramc)
  {
    if (paramc != null) {}
    for (;;)
    {
      this.a = paramc;
      return;
      paramc = c.a;
    }
  }
  
  @Deprecated
  public void a(d paramd)
  {
    if (paramd == null)
    {
      a();
      return;
    }
    this.b = paramd;
  }
  
  public void a(d paramd, n paramn)
  {
    a.a(paramd, "Auth scheme");
    a.a(paramn, "Credentials");
    this.b = paramd;
    this.d = paramn;
    this.e = null;
  }
  
  @Deprecated
  public void a(h paramh)
  {
    this.c = paramh;
  }
  
  @Deprecated
  public void a(n paramn)
  {
    this.d = paramn;
  }
  
  public void a(Queue<b> paramQueue)
  {
    a.a(paramQueue, "Queue of auth options");
    this.e = paramQueue;
    this.b = null;
    this.d = null;
  }
  
  public c b()
  {
    return this.a;
  }
  
  public d c()
  {
    return this.b;
  }
  
  public n d()
  {
    return this.d;
  }
  
  public Queue<b> e()
  {
    return this.e;
  }
  
  public boolean f()
  {
    return (this.e != null) && (!this.e.isEmpty());
  }
  
  @Deprecated
  public void g()
  {
    a();
  }
  
  @Deprecated
  public boolean h()
  {
    return this.b != null;
  }
  
  @Deprecated
  public h i()
  {
    return this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("state:").append(this.a).append(";");
    if (this.b != null) {
      localStringBuilder.append("auth scheme:").append(this.b.a()).append(";");
    }
    if (this.d != null) {
      localStringBuilder.append("credentials present");
    }
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */