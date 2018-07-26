package com.baidu.mapframework.nirvana;

/* compiled from: NirvanaTask */
/* renamed from: com.baidu.mapframework.nirvana.g */
public class C3480g {
    private String description = "";
    private C3534b exceptionCallback;

    public C3534b getExceptionCallback() {
        return this.exceptionCallback;
    }

    public void setExceptionCallback(C3534b exceptionCallback) {
        this.exceptionCallback = exceptionCallback;
    }

    public void appendDescription(String content) {
        this.description += " | " + content;
    }

    public String getDescription() {
        return this.description;
    }

    public String toString() {
        return "NirvanaTask{description='" + this.description + "}";
    }
}
