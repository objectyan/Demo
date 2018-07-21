package a;

import java.util.Locale;
import java.util.concurrent.CancellationException;

public class d
{
  private final f a;
  
  d(f paramf)
  {
    this.a = paramf;
  }
  
  public e a(Runnable paramRunnable)
  {
    return this.a.a(paramRunnable);
  }
  
  public boolean a()
  {
    return this.a.a();
  }
  
  public void b()
    throws CancellationException
  {
    this.a.d();
  }
  
  public String toString()
  {
    return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[] { getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.a.a()) });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/a/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */