package cz.msebera.android.httpclient.m;

import cz.msebera.android.httpclient.annotation.Immutable;

@Immutable
public class h
{
  private final int a;
  private final int b;
  private final int c;
  private final int d;
  
  public h(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
  
  public int a()
  {
    return this.a;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[leased: ");
    localStringBuilder.append(this.a);
    localStringBuilder.append("; pending: ");
    localStringBuilder.append(this.b);
    localStringBuilder.append("; available: ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("; max: ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/cz/msebera/android/httpclient/m/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */