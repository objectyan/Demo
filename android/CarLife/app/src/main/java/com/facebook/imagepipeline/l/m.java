package com.facebook.imagepipeline.l;

public abstract class m<I, O>
  extends b<I>
{
  private final j<O> a;
  
  public m(j<O> paramj)
  {
    this.a = paramj;
  }
  
  protected void a()
  {
    this.a.b();
  }
  
  protected void a(float paramFloat)
  {
    this.a.b(paramFloat);
  }
  
  protected void a(Throwable paramThrowable)
  {
    this.a.b(paramThrowable);
  }
  
  public j<O> d()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/facebook/imagepipeline/l/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */