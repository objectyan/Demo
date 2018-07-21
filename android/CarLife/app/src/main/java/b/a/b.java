package b.a;

public abstract class b
  implements Runnable
{
  protected final String b;
  
  public b(String paramString, Object... paramVarArgs)
  {
    this.b = c.a(paramString, paramVarArgs);
  }
  
  protected abstract void d();
  
  public final void run()
  {
    String str = Thread.currentThread().getName();
    Thread.currentThread().setName(this.b);
    try
    {
      d();
      return;
    }
    finally
    {
      Thread.currentThread().setName(str);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/b/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */