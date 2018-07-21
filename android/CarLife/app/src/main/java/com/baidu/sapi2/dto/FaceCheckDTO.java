package com.baidu.sapi2.dto;

public class FaceCheckDTO
  extends SapiDTO
{
  public String account;
  public AccountType accountType = AccountType.MERGE;
  public String bduss;
  
  public static enum AccountType
  {
    private AccountType() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/dto/FaceCheckDTO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */