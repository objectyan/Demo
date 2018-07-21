package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.entity.pb.PoiResult;
import com.baidu.entity.pb.PoiResult.Contents;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.provider.PoiListProvider;
import com.baidu.platform.comapi.search.convert.ResultCache;
import com.baidu.platform.comapi.search.convert.ResultCache.Item;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.ArrayList;
import java.util.List;

public class PoiOverlay
  extends InnerOverlay
{
  int accFlag = 0;
  int centerFlag = 0;
  int centerPtX = 0;
  int centerPtY = 0;
  private boolean isSinglePoi;
  private int pageIndex;
  List<PoiResult> pbData = null;
  private int singleIndex;
  private List<PoiResult.Contents> uselessData;
  
  public PoiOverlay()
  {
    super(14);
  }
  
  public PoiOverlay(AppBaseMap paramAppBaseMap)
  {
    super(14, paramAppBaseMap);
  }
  
  private String handlePBResult(List<PoiResult> paramList)
  {
    paramList = new PoiListProvider(paramList, this.isSinglePoi, this.singleIndex, this.pageIndex);
    if (this.accFlag != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramList.setAccFlag(bool);
      if (hasCenterPoint()) {
        paramList.setCenterPoint(new Point(this.centerPtX, this.centerPtY));
      }
      paramList.setUseLessData(this.uselessData);
      return paramList.getRenderData();
    }
  }
  
  private boolean hasCenterPoint()
  {
    return this.centerFlag == 1;
  }
  
  public String getData()
  {
    if (this.pbData != null)
    {
      if (this.pbData.size() > 0)
      {
        setType(-1);
        return handlePBResult(this.pbData);
      }
      return null;
    }
    ResultCache.Item localItem = ResultCache.getInstance().get(this.strJsonData);
    if ((localItem != null) && ((localItem.messageLite instanceof PoiResult)))
    {
      setType(-1);
      this.pbData = new ArrayList();
      this.pbData.add((PoiResult)localItem.messageLite);
      return handlePBResult(this.pbData);
    }
    setType(14);
    return this.strJsonData;
  }
  
  public Bundle getParam()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("accFlag", this.accFlag);
    localBundle.putInt("centerFlag", this.centerFlag);
    if (hasCenterPoint())
    {
      localBundle.putInt("centerX", this.centerPtX);
      localBundle.putInt("centerY", this.centerPtY);
    }
    return localBundle;
  }
  
  public void setAccFlag(int paramInt)
  {
    this.accFlag = paramInt;
  }
  
  public void setCenterFlag(int paramInt)
  {
    this.centerFlag = paramInt;
  }
  
  public void setCenterPoint(Point paramPoint)
  {
    this.centerPtX = paramPoint.getIntX();
    this.centerPtY = paramPoint.getIntY();
  }
  
  public void setPageIndex(int paramInt)
  {
    this.pageIndex = paramInt;
  }
  
  public void setPbData(List<PoiResult> paramList)
  {
    this.pbData = paramList;
  }
  
  public void setSingPoi(boolean paramBoolean)
  {
    this.isSinglePoi = paramBoolean;
  }
  
  public void setSingPoiIndex(int paramInt)
  {
    this.singleIndex = paramInt;
  }
  
  public void setUselessData(List<PoiResult.Contents> paramList)
  {
    this.uselessData = paramList;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/PoiOverlay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */