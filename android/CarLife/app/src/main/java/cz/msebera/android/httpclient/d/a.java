package cz.msebera.android.httpclient.d;

import cz.msebera.android.httpclient.annotation.Immutable;
import java.nio.charset.Charset;
import java.nio.charset.CodingErrorAction;

@Immutable
public class a
  implements Cloneable
{
  public static final a a = new a().a();
  private final int b;
  private final int c;
  private final Charset d;
  private final CodingErrorAction e;
  private final CodingErrorAction f;
  private final c g;
  
  a(int paramInt1, int paramInt2, Charset paramCharset, CodingErrorAction paramCodingErrorAction1, CodingErrorAction paramCodingErrorAction2, c paramc)
  {
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramCharset;
    this.e = paramCodingErrorAction1;
    this.f = paramCodingErrorAction2;
    this.g = paramc;
  }
  
  public static a a(a parama)
  {
    cz.msebera.android.httpclient.o.a.a(parama, "Connection config");
    return new a().a(parama.c()).a(parama.d()).b(parama.e()).a(parama.f());
  }
  
  public static a h()
  {
    return new a();
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public Charset c()
  {
    return this.d;
  }
  
  public CodingErrorAction d()
  {
    return this.e;
  }
  
  public CodingErrorAction e()
  {
    return this.f;
  }
  
  public c f()
  {
    return this.g;
  }
  
  protected a g()
    throws CloneNotSupportedException
  {
    return (a)super.clone();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[bufferSize=").append(this.b).append(", fragmentSizeHint=").append(this.c).append(", charset=").append(this.d).append(", malformedInputAction=").append(this.e).append(", unmappableInputAction=").append(this.f).append(", messageConstraints=").append(this.g).append("]");
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    private int a;
    private int b = -1;
    private Charset c;
    private CodingErrorAction d;
    private CodingErrorAction e;
    private c f;
    
    public a a(int paramInt)
    {
      this.a = paramInt;
      return this;
    }
    
    public a a(c paramc)
    {
      this.f = paramc;
      return this;
    }
    
    public a a(Charset paramCharset)
    {
      this.c = paramCharset;
      return this;
    }
    
    public a a(CodingErrorAction paramCodingErrorAction)
    {
      this.d = paramCodingErrorAction;
      if ((paramCodingErrorAction != null) && (this.c == null)) {
        this.c = cz.msebera.android.httpclient.c.f;
      }
      return this;
    }
    
    public a a()
    {
      Charset localCharset2 = this.c;
      Charset localCharset1 = localCharset2;
      if (localCharset2 == null) {
        if (this.d == null)
        {
          localCharset1 = localCharset2;
          if (this.e == null) {}
        }
        else
        {
          localCharset1 = cz.msebera.android.httpclient.c.f;
        }
      }
      int i;
      if (this.a > 0)
      {
        i = this.a;
        if (this.b < 0) {
          break label89;
        }
      }
      label89:
      for (int j = this.b;; j = i)
      {
        return new a(i, j, localCharset1, this.d, this.e, this.f);
        i = 8192;
        break;
      }
    }
    
    public a b(int paramInt)
    {
      this.b = paramInt;
      return this;
    }
    
    public a b(CodingErrorAction paramCodingErrorAction)
    {
      this.e = paramCodingErrorAction;
      if ((paramCodingErrorAction != null) && (this.c == null)) {
        this.c = cz.msebera.android.httpclient.c.f;
      }
      return this;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */