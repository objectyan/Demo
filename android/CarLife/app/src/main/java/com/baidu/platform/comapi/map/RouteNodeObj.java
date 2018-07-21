package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.basestruct.Point;

public class RouteNodeObj
{
  public Point geoPt;
  public int nIndex;
  public String strText;
  public String strUid;
  
  public RouteNodeObj()
  {
    this.strUid = "";
    this.nIndex = 0;
    this.strText = "";
    this.geoPt = new Point();
  }
  
  public RouteNodeObj(MapObj paramMapObj)
  {
    this.strUid = paramMapObj.strUid;
    this.nIndex = paramMapObj.nIndex;
    this.strText = paramMapObj.strText;
    this.geoPt = paramMapObj.geoPt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/RouteNodeObj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */