package com.baidu.sapi2.utils.enums;

public enum BindType
{
  private String a = "";
  private String b;
  private String c;
  
  private BindType(String paramString1, String paramString2, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramString3;
  }
  
  public String getCallbackPage()
  {
    return this.b;
  }
  
  public String getFinishBindPage()
  {
    return this.c;
  }
  
  public String getName()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/utils/enums/BindType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */