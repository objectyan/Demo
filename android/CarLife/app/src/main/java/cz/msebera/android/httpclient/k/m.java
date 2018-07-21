package cz.msebera.android.httpclient.k;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.i;
import cz.msebera.android.httpclient.o.a;
import cz.msebera.android.httpclient.o.b;
import java.util.List;
import java.util.NoSuchElementException;

@NotThreadSafe
public class m
  implements i
{
  protected final List<f> a;
  protected int b;
  protected int c;
  protected String d;
  
  public m(List<f> paramList, String paramString)
  {
    this.a = ((List)a.a(paramList, "Header list"));
    this.d = paramString;
    this.b = a(-1);
    this.c = -1;
  }
  
  protected int a(int paramInt)
  {
    if (paramInt < -1) {}
    boolean bool;
    do
    {
      return -1;
      int i = this.a.size();
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
    this.c = i;
    this.b = a(i);
    return (f)this.a.get(i);
  }
  
  protected boolean b(int paramInt)
  {
    if (this.d == null) {
      return true;
    }
    String str = ((f)this.a.get(paramInt)).c();
    return this.d.equalsIgnoreCase(str);
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
    if (this.c >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      b.a(bool, "No header to remove");
      this.a.remove(this.c);
      this.c = -1;
      this.b -= 1;
      return;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/k/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */