package com.baidu.platform.comapi.longlink;

public enum ELongLinkStatus
{
  private int a;
  private int b;
  
  static
  {
    SendLimited = new ELongLinkStatus("SendLimited", 3, OK.getStatusCode() + 3);
    SendDataLenLimited = new ELongLinkStatus("SendDataLenLimited", 4, OK.getStatusCode() + 4);
    SendInvalidReqID = new ELongLinkStatus("SendInvalidReqID", 5, OK.getStatusCode() + 5);
    ResultConnectError = new ELongLinkStatus("ResultConnectError", 6, OK.getStatusCode() + 6);
    ResultSendError = new ELongLinkStatus("ResultSendError", 7, OK.getStatusCode() + 7);
    ResultTimeout = new ELongLinkStatus("ResultTimeout", 8, OK.getStatusCode() + 8);
    ResultServerError = new ELongLinkStatus("ResultServerError", 9, OK.getStatusCode() + 9);
    CloudStop = new ELongLinkStatus("CloudStop", 10, OK.getStatusCode() + 10);
  }
  
  private ELongLinkStatus(int paramInt)
  {
    this.a = paramInt;
  }
  
  public int getRequestId()
  {
    return this.b;
  }
  
  public int getStatusCode()
  {
    return this.a;
  }
  
  public void setRequestId(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/longlink/ELongLinkStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */