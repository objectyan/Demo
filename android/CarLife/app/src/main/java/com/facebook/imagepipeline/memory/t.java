package com.facebook.imagepipeline.memory;

import com.facebook.common.g.c;
import com.facebook.common.g.f;
import com.facebook.common.internal.k;
import javax.annotation.concurrent.Immutable;

@Immutable
public class t
{
  private final v a;
  private final w b;
  private final v c;
  private final c d;
  private final v e;
  private final w f;
  private final v g;
  private final w h;
  
  private t(a parama)
  {
    Object localObject;
    if (a.a(parama) == null)
    {
      localObject = g.a();
      this.a = ((v)localObject);
      if (a.b(parama) != null) {
        break label141;
      }
      localObject = q.a();
      label31:
      this.b = ((w)localObject);
      if (a.c(parama) != null) {
        break label149;
      }
      localObject = i.a();
      label47:
      this.c = ((v)localObject);
      if (a.d(parama) != null) {
        break label157;
      }
      localObject = f.a();
      label63:
      this.d = ((c)localObject);
      if (a.e(parama) != null) {
        break label165;
      }
      localObject = j.a();
      label79:
      this.e = ((v)localObject);
      if (a.f(parama) != null) {
        break label173;
      }
      localObject = q.a();
      label95:
      this.f = ((w)localObject);
      if (a.g(parama) != null) {
        break label181;
      }
      localObject = h.a();
      label111:
      this.g = ((v)localObject);
      if (a.h(parama) != null) {
        break label189;
      }
    }
    label141:
    label149:
    label157:
    label165:
    label173:
    label181:
    label189:
    for (parama = q.a();; parama = a.h(parama))
    {
      this.h = parama;
      return;
      localObject = a.a(parama);
      break;
      localObject = a.b(parama);
      break label31;
      localObject = a.c(parama);
      break label47;
      localObject = a.d(parama);
      break label63;
      localObject = a.e(parama);
      break label79;
      localObject = a.f(parama);
      break label95;
      localObject = a.g(parama);
      break label111;
    }
  }
  
  public static a i()
  {
    return new a(null);
  }
  
  public v a()
  {
    return this.a;
  }
  
  public w b()
  {
    return this.b;
  }
  
  public c c()
  {
    return this.d;
  }
  
  public v d()
  {
    return this.e;
  }
  
  public w e()
  {
    return this.f;
  }
  
  public v f()
  {
    return this.c;
  }
  
  public v g()
  {
    return this.g;
  }
  
  public w h()
  {
    return this.h;
  }
  
  public static class a
  {
    private v a;
    private w b;
    private v c;
    private c d;
    private v e;
    private w f;
    private v g;
    private w h;
    
    public a a(c paramc)
    {
      this.d = paramc;
      return this;
    }
    
    public a a(v paramv)
    {
      this.a = ((v)k.a(paramv));
      return this;
    }
    
    public a a(w paramw)
    {
      this.b = ((w)k.a(paramw));
      return this;
    }
    
    public t a()
    {
      return new t(this, null);
    }
    
    public a b(v paramv)
    {
      this.c = paramv;
      return this;
    }
    
    public a b(w paramw)
    {
      this.f = ((w)k.a(paramw));
      return this;
    }
    
    public a c(v paramv)
    {
      this.e = ((v)k.a(paramv));
      return this;
    }
    
    public a c(w paramw)
    {
      this.h = ((w)k.a(paramw));
      return this;
    }
    
    public a d(v paramv)
    {
      this.g = ((v)k.a(paramv));
      return this;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/memory/t.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */