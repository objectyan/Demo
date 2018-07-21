package com.baidu.navisdk.ui.routeguide.model;

import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class RGPickPointModel
{
  private static final String TAG = "RGPickPointModel";
  private static RGPickPointModel sInstance = null;
  private boolean isPickPointShow = false;
  private SearchPoi mAntiSearchPoi = null;
  private GeoPoint mPickPointGeo = null;
  
  public static RGPickPointModel getInstance()
  {
    if (sInstance == null) {
      sInstance = new RGPickPointModel();
    }
    return sInstance;
  }
  
  public SearchPoi getAntiSearchPoi()
  {
    return this.mAntiSearchPoi;
  }
  
  public GeoPoint getPickPoint()
  {
    return this.mPickPointGeo;
  }
  
  public boolean isPickPointShow()
  {
    return this.isPickPointShow;
  }
  
  public void reset()
  {
    LogUtil.e("RGPickPointModel", "reset");
    this.mAntiSearchPoi = null;
    this.mPickPointGeo = null;
    this.isPickPointShow = false;
  }
  
  public void setPickPointShow(boolean paramBoolean)
  {
    this.isPickPointShow = paramBoolean;
  }
  
  public void updateAntiSearchPoi(SearchPoi paramSearchPoi)
  {
    this.mAntiSearchPoi = paramSearchPoi;
  }
  
  public void updatePickPoint(GeoPoint paramGeoPoint)
  {
    this.mPickPointGeo = paramGeoPoint;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGPickPointModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */