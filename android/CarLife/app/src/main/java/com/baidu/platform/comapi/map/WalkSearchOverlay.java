package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.entity.pb.WalkSearch;
import com.baidu.platform.comapi.map.provider.WalkSearchProvider;
import com.baidu.platform.comapi.search.convert.ResultCache;
import com.baidu.platform.comapi.search.convert.ResultCache.Item;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.google.protobuf.micro.InvalidProtocolBufferMicroException;

public class WalkSearchOverlay
  extends InnerOverlay
{
  byte[] pbData = null;
  
  public WalkSearchOverlay()
  {
    super(39);
  }
  
  public WalkSearchOverlay(AppBaseMap paramAppBaseMap)
  {
    super(39, paramAppBaseMap);
  }
  
  private String handlePBResult(WalkSearch paramWalkSearch)
  {
    return new WalkSearchProvider(paramWalkSearch).getRenderData();
  }
  
  public String getData()
  {
    if (this.pbData != null) {
      localObject = null;
    }
    try
    {
      WalkSearch localWalkSearch = WalkSearch.parseFrom(this.pbData);
      localObject = localWalkSearch;
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      for (;;) {}
    }
    if (localObject != null)
    {
      setType(-1);
      return handlePBResult((WalkSearch)localObject);
    }
    return null;
    Object localObject = ResultCache.getInstance().get(this.strJsonData);
    if ((localObject != null) && ((((ResultCache.Item)localObject).messageLite instanceof WalkSearch)))
    {
      setType(-1);
      return handlePBResult((WalkSearch)((ResultCache.Item)localObject).messageLite);
    }
    setType(39);
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


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/WalkSearchOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */