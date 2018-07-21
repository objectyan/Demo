package com.baidu.sapi2.dto;

public class ReloginDTO
  extends SapiDTO
{
  private PasswordType a;
  public String bduss;
  public String password;
  
  public ReloginDTO()
  {
    this(PasswordType.getDefault());
  }
  
  public ReloginDTO(PasswordType paramPasswordType)
  {
    this.a = paramPasswordType;
  }
  
  public PasswordType getPasswordType()
  {
    if (this.a != null) {
      return this.a;
    }
    return PasswordType.getDefault();
  }
  
  public static enum PasswordType
  {
    private PasswordType() {}
    
    public static PasswordType getDefault()
    {
      return CIPHER;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/dto/ReloginDTO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */