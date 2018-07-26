package com.baidu.sapi2.utils.enums;

public enum BindWidgetAction {
    BIND_MOBILE("/wp/bindwidget-bindmobile", "绑定手机"),
    BIND_EMAIL("/wp/bindwidget-bindemail", "绑定邮箱"),
    REBIND_MOBILE("/wp/bindwidget-rebindmobile", "换绑手机"),
    REBIND_EMAIL("/wp/bindwidget-rebindemail", "换绑邮箱"),
    UNBIND_MOBILE("/wp/bindwidget-unbindmobile", "解绑手机"),
    UNBIND_EMAIL("/wp/bindwidget-unbindemail", "解绑邮箱");
    
    /* renamed from: a */
    private String f20557a;
    /* renamed from: b */
    private String f20558b;

    private BindWidgetAction(String uri, String name) {
        this.f20557a = uri;
        this.f20558b = name;
    }

    public String getUri() {
        return this.f20557a;
    }

    public String getName() {
        return this.f20558b;
    }
}
