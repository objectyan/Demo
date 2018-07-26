package com.baidu.platform.comapi.search;

public class ShareUrlResult implements ResultBase {
    public int mResultType = -1;
    public String mUrl = null;
    private int requestId;

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getRequestId() {
        return this.requestId;
    }
}
