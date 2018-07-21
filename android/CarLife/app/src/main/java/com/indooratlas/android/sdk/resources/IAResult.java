package com.indooratlas.android.sdk.resources;

public class IAResult<R>
{
  private final R b;
  private final Error c;
  private final boolean d;
  
  static
  {
    if (!IAResult.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  private IAResult(boolean paramBoolean, Error paramError, R paramR)
  {
    this.d = paramBoolean;
    this.b = paramR;
    this.c = paramError;
  }
  
  public static <R> IAResult<R> failure(Error paramError)
  {
    if ((!a) && (paramError == null)) {
      throw new AssertionError("errorInfo cannot be null for failure");
    }
    return new IAResult(false, paramError, null);
  }
  
  public static <R> IAResult<R> success(R paramR)
  {
    if ((!a) && (paramR == null)) {
      throw new AssertionError("result cannot be null for success");
    }
    return new IAResult(true, null, paramR);
  }
  
  public Error getError()
  {
    return this.c;
  }
  
  public R getResult()
  {
    return (R)this.b;
  }
  
  public boolean isSuccess()
  {
    return this.d;
  }
  
  public String toString()
  {
    return "IAResult{mResult=" + this.b + ", mError=" + this.c + '}';
  }
  
  public static class Error
  {
    public final Category category;
    public final Throwable cause;
    public final int code;
    public final String message;
    
    private Error(Category paramCategory, int paramInt, String paramString, Throwable paramThrowable)
    {
      this.category = paramCategory;
      this.code = paramInt;
      this.cause = paramThrowable;
      this.message = paramString;
    }
    
    public static Error conversionError(Throwable paramThrowable)
    {
      return new Error(Category.CONVERSION, -1, paramThrowable.getMessage(), paramThrowable);
    }
    
    public static Error httpError(int paramInt, String paramString)
    {
      return new Error(Category.HTTP, paramInt, paramString, null);
    }
    
    public static Error networkError(Throwable paramThrowable)
    {
      return new Error(Category.NETWORK, -1, paramThrowable.getMessage(), paramThrowable);
    }
    
    public String toString()
    {
      return "Error{code=" + this.code + ", cause=" + this.cause + ", category=" + this.category + ", message='" + this.message + '\'' + '}';
    }
    
    public static enum Category
    {
      static
      {
        HTTP = new Category("HTTP", 1);
      }
      
      private Category() {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/resources/IAResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */