package a;

class l
{
  private j<?> a;
  
  public l(j<?> paramj)
  {
    this.a = paramj;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  protected void finalize()
    throws Throwable
  {
    try
    {
      j localj = this.a;
      if (localj != null)
      {
        j.b localb = j.a();
        if (localb != null) {
          localb.a(localj, new m(localj.g()));
        }
      }
      return;
    }
    finally
    {
      super.finalize();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/a/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */