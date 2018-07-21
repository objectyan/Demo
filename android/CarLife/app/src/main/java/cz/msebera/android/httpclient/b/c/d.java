package cz.msebera.android.httpclient.b.c;

import cz.msebera.android.httpclient.ag;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.g.a;
import cz.msebera.android.httpclient.g.b;
import cz.msebera.android.httpclient.g.g;
import cz.msebera.android.httpclient.g.i;
import cz.msebera.android.httpclient.g.k;
import cz.msebera.android.httpclient.g.l;
import cz.msebera.android.httpclient.g.m;
import cz.msebera.android.httpclient.n;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;

@NotThreadSafe
public class d
{
  private String a;
  private byte[] b;
  private InputStream c;
  private List<ag> d;
  private Serializable e;
  private File f;
  private g g;
  private String h;
  private boolean i;
  private boolean j;
  
  public static d a()
  {
    return new d();
  }
  
  private g b(g paramg)
  {
    if (this.g != null) {
      paramg = this.g;
    }
    return paramg;
  }
  
  private void o()
  {
    this.a = null;
    this.b = null;
    this.c = null;
    this.d = null;
    this.e = null;
    this.f = null;
  }
  
  public d a(g paramg)
  {
    this.g = paramg;
    return this;
  }
  
  public d a(File paramFile)
  {
    o();
    this.f = paramFile;
    return this;
  }
  
  public d a(InputStream paramInputStream)
  {
    o();
    this.c = paramInputStream;
    return this;
  }
  
  public d a(Serializable paramSerializable)
  {
    o();
    this.e = paramSerializable;
    return this;
  }
  
  public d a(String paramString)
  {
    o();
    this.a = paramString;
    return this;
  }
  
  public d a(List<ag> paramList)
  {
    o();
    this.d = paramList;
    return this;
  }
  
  public d a(byte[] paramArrayOfByte)
  {
    o();
    this.b = paramArrayOfByte;
    return this;
  }
  
  public d a(ag... paramVarArgs)
  {
    return a(Arrays.asList(paramVarArgs));
  }
  
  public d b(String paramString)
  {
    this.h = paramString;
    return this;
  }
  
  public String b()
  {
    return this.a;
  }
  
  public byte[] c()
  {
    return this.b;
  }
  
  public InputStream d()
  {
    return this.c;
  }
  
  public List<ag> e()
  {
    return this.d;
  }
  
  public Serializable f()
  {
    return this.e;
  }
  
  public File g()
  {
    return this.f;
  }
  
  public g h()
  {
    return this.g;
  }
  
  public String i()
  {
    return this.h;
  }
  
  public boolean j()
  {
    return this.i;
  }
  
  public d k()
  {
    this.i = true;
    return this;
  }
  
  public boolean l()
  {
    return this.j;
  }
  
  public d m()
  {
    this.j = true;
    return this;
  }
  
  public n n()
  {
    Object localObject1;
    if (this.a != null) {
      localObject1 = new m(this.a, b(g.m));
    }
    for (;;)
    {
      if ((((a)localObject1).getContentType() != null) && (this.g != null)) {
        ((a)localObject1).a(this.g.toString());
      }
      ((a)localObject1).b(this.h);
      ((a)localObject1).a(this.i);
      Object localObject2 = localObject1;
      if (this.j) {
        localObject2 = new e((n)localObject1);
      }
      return (n)localObject2;
      if (this.b != null)
      {
        localObject1 = new cz.msebera.android.httpclient.g.d(this.b, b(g.n));
      }
      else if (this.c != null)
      {
        localObject1 = new k(this.c, 1L, b(g.n));
      }
      else
      {
        if (this.d != null)
        {
          localObject2 = this.d;
          if (this.g != null) {}
          for (localObject1 = this.g.b();; localObject1 = null)
          {
            localObject1 = new h((Iterable)localObject2, (Charset)localObject1);
            break;
          }
        }
        if (this.e != null)
        {
          localObject1 = new l(this.e);
          ((a)localObject1).a(g.n.toString());
        }
        else if (this.f != null)
        {
          localObject1 = new i(this.f, b(g.n));
        }
        else
        {
          localObject1 = new b();
        }
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/b/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */