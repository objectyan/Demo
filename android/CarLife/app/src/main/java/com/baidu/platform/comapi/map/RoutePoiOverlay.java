package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.entity.pb.PoiResult;
import com.baidu.platform.comapi.map.provider.RoutePoiListProvider;
import com.baidu.platform.comapi.search.convert.ResultCache;
import com.baidu.platform.comapi.search.convert.ResultCache.Item;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;

public class RoutePoiOverlay
  extends InnerOverlay
{
  byte[] pbData = null;
  
  public RoutePoiOverlay()
  {
    super(38);
  }
  
  public RoutePoiOverlay(AppBaseMap paramAppBaseMap)
  {
    super(38, paramAppBaseMap);
  }
  
  private String handlePBResult(PoiResult paramPoiResult)
  {
    return new RoutePoiListProvider(paramPoiResult).getRenderData();
  }
  
  public String getData()
  {
    if (this.pbData != null) {
      localObject = null;
    }
    try
    {
      PoiResult localPoiResult = PoiResult.parseFrom(this.pbData);
      localObject = localPoiResult;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;) {}
    }
    if (localObject != null)
    {
      setType(-1);
      return handlePBResult((PoiResult)localObject);
    }
    return null;
    Object localObject = ResultCache.getInstance().get(this.strJsonData);
    if ((localObject != null) && ((((ResultCache.Item)localObject).messageLite instanceof PoiResult)))
    {
      setType(-1);
      return handlePBResult((PoiResult)((ResultCache.Item)localObject).messageLite);
    }
    setType(38);
    return this.strJsonData;
  }
  
  public Bundle getParam()
  {
    return null;
  }
  
  public void setPbData(byte[] paramArrayOfByte)
  {
    this.pbData = paramArrayOfByte;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/RoutePoiOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */