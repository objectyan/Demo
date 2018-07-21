package com.baidu.sapi2.shell.response;

import com.baidu.sapi2.utils.enums.SocialType;

public class SocialResponse
  extends SapiAccountResponse
{
  public String baiduUname = "";
  public boolean bindGuide = false;
  public boolean isBinded = false;
  public boolean offlineNotice = false;
  public String socialPortraitUrl = "";
  public SocialType socialType = SocialType.UNKNOWN;
  public String socialUname = "";
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/shell/response/SocialResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */