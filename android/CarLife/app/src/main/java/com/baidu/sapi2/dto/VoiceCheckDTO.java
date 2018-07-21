package com.baidu.sapi2.dto;

public class VoiceCheckDTO
  extends SapiDTO
{
  public String account;
  public AccountType accountType = AccountType.MERGE;
  
  public static enum AccountType
  {
    private AccountType() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/dto/VoiceCheckDTO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */