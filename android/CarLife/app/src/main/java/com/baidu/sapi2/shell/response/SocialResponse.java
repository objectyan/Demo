package com.baidu.sapi2.shell.response;

import com.baidu.sapi2.utils.enums.SocialType;

public class SocialResponse extends SapiAccountResponse {
    public String baiduUname = "";
    public boolean bindGuide = false;
    public boolean isBinded = false;
    public boolean offlineNotice = false;
    public String socialPortraitUrl = "";
    public SocialType socialType = SocialType.UNKNOWN;
    public String socialUname = "";
}
