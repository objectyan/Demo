package com.baidu.sapi2.utils.enums;

public enum BindType {
    EXPLICIT("explicit", "afterauth", "finishbind"),
    OPTIONAL("optional", "afterauth", "finishbind"),
    IMPLICIT("implicit", "afterauth", "afterauth"),
    SMS("sms", "afterauth", "finishbind");
    
    /* renamed from: a */
    private String f20553a;
    /* renamed from: b */
    private String f20554b;
    /* renamed from: c */
    private String f20555c;

    private BindType(String name, String callbackPage, String finishBindPage) {
        this.f20553a = "";
        this.f20553a = name;
        this.f20554b = callbackPage;
        this.f20555c = finishBindPage;
    }

    public String getName() {
        return this.f20553a;
    }

    public String getCallbackPage() {
        return this.f20554b;
    }

    public String getFinishBindPage() {
        return this.f20555c;
    }
}
