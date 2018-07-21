package com.baidu.navisdk.logic;

public class RspData
{
  public Object mData;
  public ReqData mReq;
  
  public RspData() {}
  
  public RspData(ReqData paramReqData, Object paramObject)
  {
    this.mReq = paramReqData;
    this.mData = paramObject;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/RspData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */