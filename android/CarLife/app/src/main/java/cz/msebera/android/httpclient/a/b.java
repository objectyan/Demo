package cz.msebera.android.httpclient.a;

import cz.msebera.android.httpclient.annotation.Immutable;
import cz.msebera.android.httpclient.o.a;

@Immutable
public final class b
{
  private final d a;
  private final n b;
  
  public b(d paramd, n paramn)
  {
    a.a(paramd, "Auth scheme");
    a.a(paramn, "User credentials");
    this.a = paramd;
    this.b = paramn;
  }
  
  public d a()
  {
    return this.a;
  }
  
  public n b()
  {
    return this.b;
  }
  
  public String toString()
  {
    return this.a.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */