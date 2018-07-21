package cz.msebera.android.httpclient.b;

import cz.msebera.android.httpclient.b.d.q;
import cz.msebera.android.httpclient.e.c;
import cz.msebera.android.httpclient.n.g;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;
import java.io.IOException;

public abstract interface j
{
  @Deprecated
  public abstract cz.msebera.android.httpclient.l.j a();
  
  public abstract x a(q paramq)
    throws IOException, f;
  
  public abstract x a(q paramq, g paramg)
    throws IOException, f;
  
  public abstract x a(cz.msebera.android.httpclient.r paramr, u paramu)
    throws IOException, f;
  
  public abstract x a(cz.msebera.android.httpclient.r paramr, u paramu, g paramg)
    throws IOException, f;
  
  public abstract <T> T a(q paramq, r<? extends T> paramr)
    throws IOException, f;
  
  public abstract <T> T a(q paramq, r<? extends T> paramr, g paramg)
    throws IOException, f;
  
  public abstract <T> T a(cz.msebera.android.httpclient.r paramr, u paramu, r<? extends T> paramr1)
    throws IOException, f;
  
  public abstract <T> T a(cz.msebera.android.httpclient.r paramr, u paramu, r<? extends T> paramr1, g paramg)
    throws IOException, f;
  
  @Deprecated
  public abstract c b();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/b/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */