package com.baidu.sapi2.dto;

public class LoginDTO
  extends SapiDTO
{
  public String account;
  public String captcha;
  public LoginType loginType = LoginType.MERGE;
  public String password;
  
  public static enum LoginType
  {
    private LoginType() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/dto/LoginDTO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */