package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.b.a.d;
import cz.msebera.android.httpclient.b.d.c;
import cz.msebera.android.httpclient.r;
import cz.msebera.android.httpclient.u;
import cz.msebera.android.httpclient.x;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

abstract interface ad
{
  public abstract d a(r paramr, u paramu, d paramd, x paramx, Date paramDate1, Date paramDate2)
    throws IOException;
  
  public abstract d a(r paramr, u paramu, d paramd, x paramx, Date paramDate1, Date paramDate2, String paramString)
    throws IOException;
  
  public abstract c a(r paramr, u paramu, c paramc, Date paramDate1, Date paramDate2)
    throws IOException;
  
  public abstract x a(r paramr, u paramu, x paramx, Date paramDate1, Date paramDate2)
    throws IOException;
  
  public abstract void a(r paramr, u paramu)
    throws IOException;
  
  public abstract void a(r paramr, u paramu, as paramas)
    throws IOException;
  
  public abstract void a(r paramr, u paramu, x paramx);
  
  public abstract d b(r paramr, u paramu)
    throws IOException;
  
  public abstract void c(r paramr, u paramu)
    throws IOException;
  
  public abstract Map<String, as> d(r paramr, u paramu)
    throws IOException;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */