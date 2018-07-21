package com.indooratlas.android.sdk._internal;

public final class bh
{
  int a;
  String b;
  private Throwable c;
  
  private bh(int paramInt, String paramString, Throwable paramThrowable)
  {
    this.a = paramInt;
    this.b = paramString;
    this.c = paramThrowable;
  }
  
  public static bh a(int paramInt, Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    return new bh(paramInt, ct.a(paramString, paramVarArgs), paramThrowable);
  }
  
  public final String toString()
  {
    return "IAManagerStatus{mErrorCode=" + this.a + ", mErrorMessage='" + this.b + '\'' + '}';
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/bh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */