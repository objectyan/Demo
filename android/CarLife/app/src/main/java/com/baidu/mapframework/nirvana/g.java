package com.baidu.mapframework.nirvana;

public class g
{
  private String description = "";
  private b exceptionCallback;
  
  public void appendDescription(String paramString)
  {
    this.description = (this.description + " | " + paramString);
  }
  
  public String getDescription()
  {
    return this.description;
  }
  
  public b getExceptionCallback()
  {
    return this.exceptionCallback;
  }
  
  public void setExceptionCallback(b paramb)
  {
    this.exceptionCallback = paramb;
  }
  
  public String toString()
  {
    return "NirvanaTask{description='" + this.description + "}";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/nirvana/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */