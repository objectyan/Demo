package com.baidu.platform.comapi.longlink;

public enum ELongLinkStatus {
    OK(0),
    SendFormatError(OK.getStatusCode() + 1),
    SendUnRegistered(OK.getStatusCode() + 2),
    SendLimited(OK.getStatusCode() + 3),
    SendDataLenLimited(OK.getStatusCode() + 4),
    SendInvalidReqID(OK.getStatusCode() + 5),
    ResultConnectError(OK.getStatusCode() + 6),
    ResultSendError(OK.getStatusCode() + 7),
    ResultTimeout(OK.getStatusCode() + 8),
    ResultServerError(OK.getStatusCode() + 9),
    CloudStop(OK.getStatusCode() + 10),
    CloudRestart(OK.getStatusCode() + 11);
    
    /* renamed from: a */
    private int f19843a;
    /* renamed from: b */
    private int f19844b;

    private ELongLinkStatus(int code) {
        this.f19843a = code;
    }

    public void setRequestId(int id) {
        this.f19844b = id;
    }

    public int getStatusCode() {
        return this.f19843a;
    }

    public int getRequestId() {
        return this.f19844b;
    }
}
