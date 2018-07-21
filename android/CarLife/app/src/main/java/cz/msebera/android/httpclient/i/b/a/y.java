package cz.msebera.android.httpclient.i.b.a;

import cz.msebera.android.httpclient.annotation.Immutable;

@Immutable
public class y
{
  private final long a = System.nanoTime();
  private final String b;
  private final int c;
  
  public y(String paramString, int paramInt)
  {
    this.b = paramString;
    this.c = paramInt;
  }
  
  public long a()
  {
    return this.a;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public String toString()
  {
    return "[entry creationTimeInNanos=" + this.a + "; " + "key=" + this.b + "; errorCount=" + this.c + ']';
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/i/b/a/y.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */