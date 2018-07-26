package com.baidu.sapi2.dto;

public class VoiceCheckDTO extends SapiDTO {
    public String account;
    public AccountType accountType = AccountType.MERGE;

    public enum AccountType {
        MERGE,
        USERNAME,
        PHONE
    }
}
