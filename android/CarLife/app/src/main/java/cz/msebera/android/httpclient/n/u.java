package cz.msebera.android.httpclient.n;

import cz.msebera.android.httpclient.annotation.ThreadSafe;
import cz.msebera.android.httpclient.p;
import cz.msebera.android.httpclient.w;
import cz.msebera.android.httpclient.x;
import cz.msebera.android.httpclient.z;
import java.io.IOException;
import java.util.List;

@ThreadSafe
public final class u
  implements k
{
  private final w[] a;
  private final z[] b;
  
  @Deprecated
  public u(r paramr, s params)
  {
    int j;
    int i;
    if (paramr != null)
    {
      j = paramr.a();
      this.a = new w[j];
      i = 0;
      while (i < j)
      {
        this.a[i] = paramr.a(i);
        i += 1;
      }
    }
    this.a = new w[0];
    if (params != null)
    {
      j = params.c();
      this.b = new z[j];
      i = 0;
      while (i < j)
      {
        this.b[i] = params.b(i);
        i += 1;
      }
    }
    this.b = new z[0];
  }
  
  public u(List<w> paramList, List<z> paramList1)
  {
    if (paramList != null) {}
    for (this.a = ((w[])paramList.toArray(new w[paramList.size()])); paramList1 != null; this.a = new w[0])
    {
      this.b = ((z[])paramList1.toArray(new z[paramList1.size()]));
      return;
    }
    this.b = new z[0];
  }
  
  public u(w... paramVarArgs)
  {
    this(paramVarArgs, null);
  }
  
  public u(w[] paramArrayOfw, z[] paramArrayOfz)
  {
    int i;
    if (paramArrayOfw != null)
    {
      i = paramArrayOfw.length;
      this.a = new w[i];
      System.arraycopy(paramArrayOfw, 0, this.a, 0, i);
    }
    while (paramArrayOfz != null)
    {
      i = paramArrayOfz.length;
      this.b = new z[i];
      System.arraycopy(paramArrayOfz, 0, this.b, 0, i);
      return;
      this.a = new w[0];
    }
    this.b = new z[0];
  }
  
  public u(z... paramVarArgs)
  {
    this(null, paramVarArgs);
  }
  
  public void process(cz.msebera.android.httpclient.u paramu, g paramg)
    throws IOException, p
  {
    w[] arrayOfw = this.a;
    int j = arrayOfw.length;
    int i = 0;
    while (i < j)
    {
      arrayOfw[i].process(paramu, paramg);
      i += 1;
    }
  }
  
  public void process(x paramx, g paramg)
    throws IOException, p
  {
    z[] arrayOfz = this.b;
    int j = arrayOfz.length;
    int i = 0;
    while (i < j)
    {
      arrayOfz[i].process(paramx, paramg);
      i += 1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/cz/msebera/android/httpclient/n/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */