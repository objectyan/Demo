package cz.msebera.android.httpclient.k;

import cz.msebera.android.httpclient.ai;
import cz.msebera.android.httpclient.annotation.NotThreadSafe;
import cz.msebera.android.httpclient.ao;
import cz.msebera.android.httpclient.f;
import cz.msebera.android.httpclient.i;
import cz.msebera.android.httpclient.o.a;
import java.util.NoSuchElementException;

@NotThreadSafe
public class q
  implements ao
{
  public static final String a = " ,;=()<>@:\\\"/[]?{}\t";
  protected final i b;
  protected String c;
  protected String d;
  protected int e;
  
  public q(i parami)
  {
    this.b = ((i)a.a(parami, "Header iterator"));
    this.e = a(-1);
  }
  
  protected int a(int paramInt)
    throws ai
  {
    if (paramInt < 0)
    {
      if (!this.b.hasNext()) {
        return -1;
      }
      this.c = this.b.a().d();
    }
    for (paramInt = 0;; paramInt = c(paramInt))
    {
      paramInt = b(paramInt);
      if (paramInt >= 0) {
        break;
      }
      this.d = null;
      return -1;
    }
    int i = d(paramInt);
    this.d = a(this.c, paramInt, i);
    return i;
  }
  
  public String a()
    throws NoSuchElementException, ai
  {
    if (this.d == null) {
      throw new NoSuchElementException("Iteration already finished.");
    }
    String str = this.d;
    this.e = a(this.e);
    return str;
  }
  
  protected String a(String paramString, int paramInt1, int paramInt2)
  {
    return paramString.substring(paramInt1, paramInt2);
  }
  
  protected boolean a(char paramChar)
  {
    return paramChar == ',';
  }
  
  protected int b(int paramInt)
  {
    paramInt = a.b(paramInt, "Search position");
    int j = 0;
    while ((j == 0) && (this.c != null))
    {
      int m = this.c.length();
      int k = paramInt;
      int i = j;
      while ((i == 0) && (k < m))
      {
        char c1 = this.c.charAt(k);
        if ((a(c1)) || (b(c1))) {
          k += 1;
        } else if (c(this.c.charAt(k))) {
          i = 1;
        } else {
          throw new ai("Invalid character before token (pos " + k + "): " + this.c);
        }
      }
      j = i;
      paramInt = k;
      if (i == 0) {
        if (this.b.hasNext())
        {
          this.c = this.b.a().d();
          paramInt = 0;
          j = i;
        }
        else
        {
          this.c = null;
          j = i;
          paramInt = k;
        }
      }
    }
    if (j != 0) {
      return paramInt;
    }
    return -1;
  }
  
  protected boolean b(char paramChar)
  {
    return (paramChar == '\t') || (Character.isSpaceChar(paramChar));
  }
  
  protected int c(int paramInt)
  {
    paramInt = a.b(paramInt, "Search position");
    int i = 0;
    int j = this.c.length();
    while ((i == 0) && (paramInt < j))
    {
      char c1 = this.c.charAt(paramInt);
      if (a(c1))
      {
        i = 1;
      }
      else if (b(c1))
      {
        paramInt += 1;
      }
      else
      {
        if (c(c1)) {
          throw new ai("Tokens without separator (pos " + paramInt + "): " + this.c);
        }
        throw new ai("Invalid character after token (pos " + paramInt + "): " + this.c);
      }
    }
    return paramInt;
  }
  
  protected boolean c(char paramChar)
  {
    if (Character.isLetterOrDigit(paramChar)) {}
    do
    {
      return true;
      if (Character.isISOControl(paramChar)) {
        return false;
      }
    } while (!d(paramChar));
    return false;
  }
  
  protected int d(int paramInt)
  {
    a.b(paramInt, "Search position");
    int i = this.c.length();
    paramInt += 1;
    while ((paramInt < i) && (c(this.c.charAt(paramInt)))) {
      paramInt += 1;
    }
    return paramInt;
  }
  
  protected boolean d(char paramChar)
  {
    return " ,;=()<>@:\\\"/[]?{}\t".indexOf(paramChar) >= 0;
  }
  
  public boolean hasNext()
  {
    return this.d != null;
  }
  
  public final Object next()
    throws NoSuchElementException, ai
  {
    return a();
  }
  
  public final void remove()
    throws UnsupportedOperationException
  {
    throw new UnsupportedOperationException("Removing tokens is not supported.");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/k/q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */