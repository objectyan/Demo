package com.baidu.navisdk.ui.routeguide.model;

import com.baidu.navisdk.model.datastruct.SearchParkPoi;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class RGParkPointModel
{
  private static RGParkPointModel sInstance = null;
  private boolean mCanShow = true;
  private boolean mDoneWithParkSearch = false;
  private boolean mIsParkPointShow = false;
  private SearchParkPoi mNeareastSearchParkPoi = null;
  private int mParkPointIndex = -1;
  private GeoPoint mPickPointGeo = null;
  private SearchParkPoi mSearchParkPoi = null;
  
  public static RGParkPointModel getInstance()
  {
    if (sInstance == null) {
      sInstance = new RGParkPointModel();
    }
    return sInstance;
  }
  
  public boolean getCanParkPoiShow()
  {
    return this.mCanShow;
  }
  
  public boolean getDoneWithParkSearch()
  {
    return this.mDoneWithParkSearch;
  }
  
  public SearchParkPoi getNeareastParkPoi()
  {
    return this.mNeareastSearchParkPoi;
  }
  
  public SearchParkPoi getParkPoi()
  {
    return this.mSearchParkPoi;
  }
  
  public int getParkPoiIndex()
  {
    return this.mParkPointIndex;
  }
  
  public GeoPoint getParkPoint()
  {
    return this.mPickPointGeo;
  }
  
  public boolean ismIsParkPointShow()
  {
    return this.mIsParkPointShow;
  }
  
  public void reset()
  {
    this.mSearchParkPoi = null;
    this.mNeareastSearchParkPoi = null;
    this.mPickPointGeo = null;
    this.mParkPointIndex = -1;
    this.mIsParkPointShow = false;
  }
  
  public void setCanParkPoiShow(boolean paramBoolean)
  {
    this.mCanShow = paramBoolean;
  }
  
  public void setDoneWithParkSearch(boolean paramBoolean)
  {
    this.mDoneWithParkSearch = paramBoolean;
  }
  
  public void setmIsParkPointShow(boolean paramBoolean)
  {
    this.mIsParkPointShow = paramBoolean;
  }
  
  public void updateNeareastParkPoi(SearchParkPoi paramSearchParkPoi)
  {
    this.mNeareastSearchParkPoi = paramSearchParkPoi;
  }
  
  public void updateParkPoi(SearchParkPoi paramSearchParkPoi)
  {
    this.mSearchParkPoi = paramSearchParkPoi;
  }
  
  public void updateParkPoiIndex(int paramInt)
  {
    this.mParkPointIndex = paramInt;
  }
  
  public void updateParkPoint(GeoPoint paramGeoPoint)
  {
    this.mPickPointGeo = paramGeoPoint;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGParkPointModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */