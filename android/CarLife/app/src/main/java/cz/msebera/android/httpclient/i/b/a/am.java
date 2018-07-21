package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.b.a.d;
import cz.msebera.android.httpclient.b.a.l;
import cz.msebera.android.httpclient.o.a;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

@Immutable
class am
  extends PhantomReference<d>
{
  private final l a;
  
  public am(d paramd, ReferenceQueue<d> paramReferenceQueue)
  {
    super(paramd, paramReferenceQueue);
    a.a(paramd.i(), "Resource");
    this.a = paramd.i();
  }
  
  public l a()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    return this.a.equals(paramObject);
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/am.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */