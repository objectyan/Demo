package com.baidu.platform.comapi.search;

public class ShareUrlResult
  implements ResultBase
{
  public int mResultType = -1;
  public String mUrl = null;
  private int requestId;
  
  public int getRequestId()
  {
    return this.requestId;
  }
  
  public void setRequestId(int paramInt)
  {
    this.requestId = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/search/ShareUrlResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */