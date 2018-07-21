package com.baidu.platform.comapi.search;

import com.baidu.platform.comapi.basestruct.Point;

public class PoiRGCDetailResult
  implements ResultBase
{
  public String mAddress = null;
  public Point mLocation = null;
  public String mName = null;
  public int mResultType = -1;
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/search/PoiRGCDetailResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */