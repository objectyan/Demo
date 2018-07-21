package com.baidu.carlife.c;

public class f
{
  private g a = g.a();
  
  public static f a()
  {
    return a.a();
  }
  
  public <R> void a(d.a<R> parama)
  {
    this.a.a(parama);
  }
  
  public <T, R> void a(final d<T, R> paramd, final T paramT, d.a<R> parama)
  {
    paramd.a(new b(parama, this));
    this.a.a(new Runnable()
    {
      public void run()
      {
        paramd.a(paramT);
      }
    });
  }
  
  public <R> void a(R paramR, d.a<R> parama)
  {
    this.a.a(paramR, parama);
  }
  
  public <R> void b(d.a<R> parama)
  {
    this.a.b(parama);
  }
  
  private static final class a
  {
    private static final f a = new f(null);
  }
  
  private static final class b<R>
    implements d.a<R>
  {
    private d.a a;
    private f b;
    
    public b(d.a<R> parama, f paramf)
    {
      this.a = parama;
      this.b = paramf;
    }
    
    public void a()
    {
      this.b.a(this.a);
    }
    
    public void a(R paramR)
    {
      this.b.a(paramR, this.a);
    }
    
    public void b()
    {
      this.b.b(this.a);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/c/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */