package cz.msebera.android.httpclient.k;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.i;
import cz.msebera.android.httpclient.o.a;
import java.util.NoSuchElementException;

@NotThreadSafe
public class e
  implements i
{
  protected final f[] a;
  protected int b;
  protected String c;
  
  public e(f[] paramArrayOff, String paramString)
  {
    this.a = ((f[])a.a(paramArrayOff, "Header array"));
    this.c = paramString;
    this.b = a(-1);
  }
  
  protected int a(int paramInt)
  {
    if (paramInt < -1) {}
    boolean bool;
    do
    {
      return -1;
      int i = this.a.length;
      for (bool = false; (!bool) && (paramInt < i - 1); bool = b(paramInt)) {
        paramInt += 1;
      }
    } while (!bool);
    return paramInt;
  }
  
  public f a()
    throws NoSuchElementException
  {
    int i = this.b;
    if (i < 0) {
      throw new NoSuchElementException("Iteration already finished.");
    }
    this.b = a(i);
    return this.a[i];
  }
  
  protected boolean b(int paramInt)
  {
    return (this.c == null) || (this.c.equalsIgnoreCase(this.a[paramInt].c()));
  }
  
  public boolean hasNext()
  {
    return this.b >= 0;
  }
  
  public final Object next()
    throws NoSuchElementException
  {
    return a();
  }
  
  public void remove()
    throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException("Removing headers is not supported.");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/k/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */