package cz.msebera.android.httpclient.i.d;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.f.o;
import java.util.Date;

@NotThreadSafe
public class d
  extends c
  implements o
{
  private static final long k = -7744598295706617057L;
  private String l;
  private int[] m;
  private boolean n;
  
  public d(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void a(int[] paramArrayOfInt)
  {
    this.m = paramArrayOfInt;
  }
  
  public boolean a(Date paramDate)
  {
    return (this.n) || (super.a(paramDate));
  }
  
  public void a_(String paramString)
  {
    this.l = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    d locald = (d)super.clone();
    if (this.m != null) {
      locald.m = ((int[])this.m.clone());
    }
    return locald;
  }
  
  public String d()
  {
    return this.l;
  }
  
  public boolean f()
  {
    return (!this.n) && (super.f());
  }
  
  public int[] i()
  {
    return this.m;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/d/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */