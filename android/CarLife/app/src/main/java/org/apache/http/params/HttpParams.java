package org.apache.http.params;

public abstract interface HttpParams
{
  public abstract HttpParams copy();
  
  public abstract boolean getBooleanParameter(String paramString, boolean paramBoolean);
  
  public abstract double getDoubleParameter(String paramString, double paramDouble);
  
  public abstract int getIntParameter(String paramString, int paramInt);
  
  public abstract long getLongParameter(String paramString, long paramLong);
  
  public abstract Object getParameter(String paramString);
  
  public abstract boolean isParameterFalse(String paramString);
  
  public abstract boolean isParameterTrue(String paramString);
  
  public abstract boolean removeParameter(String paramString);
  
  public abstract HttpParams setBooleanParameter(String paramString, boolean paramBoolean);
  
  public abstract HttpParams setDoubleParameter(String paramString, double paramDouble);
  
  public abstract HttpParams setIntParameter(String paramString, int paramInt);
  
  public abstract HttpParams setLongParameter(String paramString, long paramLong);
  
  public abstract HttpParams setParameter(String paramString, Object paramObject);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/org/apache/http/params/HttpParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */