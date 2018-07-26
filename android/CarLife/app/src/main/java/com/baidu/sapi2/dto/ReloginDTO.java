package com.baidu.sapi2.dto;

public class ReloginDTO extends SapiDTO {
    /* renamed from: a */
    private PasswordType f20450a;
    public String bduss;
    public String password;

    public enum PasswordType {
        PLAIN,
        CIPHER;

        public static PasswordType getDefault() {
            return CIPHER;
        }
    }

    public ReloginDTO() {
        this(PasswordType.getDefault());
    }

    public ReloginDTO(PasswordType passwordType) {
        this.f20450a = passwordType;
    }

    public PasswordType getPasswordType() {
        return this.f20450a != null ? this.f20450a : PasswordType.getDefault();
    }
}
