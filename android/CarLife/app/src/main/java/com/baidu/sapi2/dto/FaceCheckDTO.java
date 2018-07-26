package com.baidu.sapi2.dto;

public class FaceCheckDTO extends SapiDTO {
    public String account;
    public AccountType accountType = AccountType.MERGE;
    public String bduss;

    public enum AccountType {
        MERGE,
        USERNAME,
        PHONE
    }
}
