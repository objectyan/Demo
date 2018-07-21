package cz.msebera.android.httpclient.i.g;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.j.i;
import cz.msebera.android.httpclient.k.v;
import cz.msebera.android.httpclient.l.j;
import cz.msebera.android.httpclient.u;
import java.io.IOException;

@Deprecated
@NotThreadSafe
public class r
  extends b<u>
{
  public r(i parami, v paramv, j paramj)
  {
    super(parami, paramv, paramj);
  }
  
  protected void a(u paramu)
    throws IOException
  {
    this.c.a(this.b, paramu.getRequestLine());
    this.a.a(this.b);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/i/g/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */