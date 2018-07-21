package cz.msebera.android.httpclient.i.c.a;

import cz.msebera.android.httpclient.o.a;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

@Deprecated
public class c
  extends WeakReference<b>
{
  private final cz.msebera.android.httpclient.e.b.b a;
  
  public c(b paramb, ReferenceQueue<Object> paramReferenceQueue)
  {
    super(paramb, paramReferenceQueue);
    a.a(paramb, "Pool entry");
    this.a = paramb.d();
  }
  
  public final cz.msebera.android.httpclient.e.b.b a()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/c/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */