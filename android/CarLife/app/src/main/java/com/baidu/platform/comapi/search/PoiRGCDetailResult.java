package com.baidu.platform.comapi.search;

import com.baidu.platform.comapi.basestruct.Point;

public class PoiRGCDetailResult implements ResultBase {
    public String mAddress = null;
    public Point mLocation = null;
    public String mName = null;
    public int mResultType = -1;
    private int requestId;

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public int getRequestId() {
        return this.requestId;
    }
}
