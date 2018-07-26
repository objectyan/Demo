package com.baidu.sapi2.dto;

public class LoginDTO extends SapiDTO {
    public String account;
    public String captcha;
    public LoginType loginType = LoginType.MERGE;
    public String password;

    public enum LoginType {
        MERGE,
        USERNAME,
        PHONE
    }
}
