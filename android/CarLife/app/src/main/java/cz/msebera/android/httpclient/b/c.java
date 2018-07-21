package cz.msebera.android.httpclient.b;

import cz.msebera.android.httpclient.a.b;
import cz.msebera.android.httpclient.a.d;
import cz.msebera.android.httpclient.a.p;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.x;
import java.util.Map;
import java.util.Queue;

public abstract interface c
{
  public abstract Queue<b> a(Map<String, f> paramMap, r paramr, x paramx, g paramg)
    throws p;
  
  public abstract void a(r paramr, d paramd, g paramg);
  
  public abstract boolean a(r paramr, x paramx, g paramg);
  
  public abstract Map<String, f> b(r paramr, x paramx, g paramg)
    throws p;
  
  public abstract void b(r paramr, d paramd, g paramg);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */