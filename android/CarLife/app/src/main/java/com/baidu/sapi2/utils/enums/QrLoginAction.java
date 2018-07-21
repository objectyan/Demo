package com.baidu.sapi2.utils.enums;

public enum QrLoginAction
{
  private String a;
  
  static
  {
    LOGIN = new QrLoginAction("LOGIN", 1, "login");
  }
  
  private QrLoginAction(String paramString)
  {
    this.a = paramString;
  }
  
  public String getName()
  {
    return this.a;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/utils/enums/QrLoginAction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */