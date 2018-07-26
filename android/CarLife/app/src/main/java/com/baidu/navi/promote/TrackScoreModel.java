package com.baidu.navi.promote;

public class TrackScoreModel {
    private String mContent;
    private String mErrorMsg;
    private int mErrorNo;
    private int mReqId;

    public int getReqId() {
        return this.mReqId;
    }

    public void setReqId(int reqId) {
        this.mReqId = reqId;
    }

    public int getErrorNo() {
        return this.mErrorNo;
    }

    public void setErrorNo(int mErrorNo) {
        this.mErrorNo = mErrorNo;
    }

    public String getErrorMsg() {
        return this.mErrorMsg;
    }

    public void setErrorMsg(String mErrorMsg) {
        this.mErrorMsg = mErrorMsg;
    }

    public String getContent() {
        return this.mContent;
    }

    public void setContent(String mContent) {
        this.mContent = mContent;
    }
}
