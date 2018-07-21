package cz.msebera.android.httpclient.n;

import cz.msebera.android.httpclient.w;
import cz.msebera.android.httpclient.z;
import java.util.LinkedList;

public class l
{
  private c<w> a;
  private c<z> b;
  
  public static l a()
  {
    return new l();
  }
  
  private c<w> c()
  {
    if (this.a == null) {
      this.a = new c();
    }
    return this.a;
  }
  
  private c<z> d()
  {
    if (this.b == null) {
      this.b = new c();
    }
    return this.b;
  }
  
  public l a(w paramw)
  {
    if (paramw == null) {
      return this;
    }
    c().a(paramw);
    return this;
  }
  
  public l a(z paramz)
  {
    if (paramz == null) {
      return this;
    }
    d().a(paramz);
    return this;
  }
  
  public l a(w... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return this;
    }
    c().a(paramVarArgs);
    return this;
  }
  
  public l a(z... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return this;
    }
    d().a(paramVarArgs);
    return this;
  }
  
  public k b()
  {
    LinkedList localLinkedList2 = null;
    if (this.a != null) {}
    for (LinkedList localLinkedList1 = this.a.a();; localLinkedList1 = null)
    {
      if (this.b != null) {
        localLinkedList2 = this.b.a();
      }
      return new u(localLinkedList1, localLinkedList2);
    }
  }
  
  public l b(w paramw)
  {
    if (paramw == null) {
      return this;
    }
    c().b(paramw);
    return this;
  }
  
  public l b(z paramz)
  {
    if (paramz == null) {
      return this;
    }
    d().b(paramz);
    return this;
  }
  
  public l b(w... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return this;
    }
    c().b(paramVarArgs);
    return this;
  }
  
  public l b(z... paramVarArgs)
  {
    if (paramVarArgs == null) {
      return this;
    }
    d().b(paramVarArgs);
    return this;
  }
  
  public l c(w paramw)
  {
    return b(paramw);
  }
  
  public l c(z paramz)
  {
    return b(paramz);
  }
  
  public l c(w... paramVarArgs)
  {
    return b(paramVarArgs);
  }
  
  public l c(z... paramVarArgs)
  {
    return b(paramVarArgs);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/n/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */