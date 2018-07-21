package com.facebook.imagepipeline.g;

import com.facebook.common.internal.k;
import com.facebook.imagepipeline.j.c;
import com.facebook.imagepipeline.l.ai;
import com.facebook.imagepipeline.l.ao;
import com.facebook.imagepipeline.l.b;
import com.facebook.imagepipeline.l.j;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
public abstract class a<T>
  extends com.facebook.c.a<T>
{
  private final ao a;
  private final c b;
  
  protected a(ai<T> paramai, ao paramao, c paramc)
  {
    this.a = paramao;
    this.b = paramc;
    this.b.a(paramao.a(), this.a.d(), this.a.b(), this.a.f());
    paramai.a(j(), paramao);
  }
  
  private void b(Throwable paramThrowable)
  {
    if (super.a(paramThrowable)) {
      this.b.a(this.a.a(), this.a.b(), paramThrowable, this.a.f());
    }
  }
  
  private j<T> j()
  {
    new b()
    {
      protected void a()
      {
        a.a(a.this);
      }
      
      protected void a(float paramAnonymousFloat)
      {
        a.a(a.this, paramAnonymousFloat);
      }
      
      protected void a(@Nullable T paramAnonymousT, boolean paramAnonymousBoolean)
      {
        a.this.b(paramAnonymousT, paramAnonymousBoolean);
      }
      
      protected void a(Throwable paramAnonymousThrowable)
      {
        a.a(a.this, paramAnonymousThrowable);
      }
    };
  }
  
  private void k()
  {
    try
    {
      k.b(a());
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected void b(@Nullable T paramT, boolean paramBoolean)
  {
    if ((super.a(paramT, paramBoolean)) && (paramBoolean)) {
      this.b.a(this.a.a(), this.a.b(), this.a.f());
    }
  }
  
  public boolean h()
  {
    if (!super.h()) {
      return false;
    }
    if (!super.b())
    {
      this.b.a(this.a.b());
      this.a.j();
    }
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/g/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */