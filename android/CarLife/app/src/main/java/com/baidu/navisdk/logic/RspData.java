package com.baidu.navisdk.logic;

public class RspData {
    public Object mData;
    public ReqData mReq;

    public RspData(ReqData req, Object data) {
        this.mReq = req;
        this.mData = data;
    }
}
