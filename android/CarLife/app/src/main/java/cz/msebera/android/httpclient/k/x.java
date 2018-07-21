package cz.msebera.android.httpclient.k;

import cz.msebera.android.httpclient.annotation.NotThreadSafe;

@NotThreadSafe
public class x
{
  private final int a;
  private final int b;
  private int c;
  
  public x(int paramInt1, int paramInt2)
  {
    if (paramInt1 < 0) {
      throw new IndexOutOfBoundsException("Lower bound cannot be negative");
    }
    if (paramInt1 > paramInt2) {
      throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
    }
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt1;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public void a(int paramInt)
  {
    if (paramInt < this.a) {
      throw new IndexOutOfBoundsException("pos: " + paramInt + " < lowerBound: " + this.a);
    }
    if (paramInt > this.b) {
      throw new IndexOutOfBoundsException("pos: " + paramInt + " > upperBound: " + this.b);
    }
    this.c = paramInt;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public boolean d()
  {
    return this.c >= this.b;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    localStringBuilder.append(Integer.toString(this.a));
    localStringBuilder.append('>');
    localStringBuilder.append(Integer.toString(this.c));
    localStringBuilder.append('>');
    localStringBuilder.append(Integer.toString(this.b));
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/k/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */