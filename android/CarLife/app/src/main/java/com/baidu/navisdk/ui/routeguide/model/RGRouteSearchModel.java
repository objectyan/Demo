package com.baidu.navisdk.ui.routeguide.model;

import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.util.common.LogUtil;

public class RGRouteSearchModel
{
  public static final int Control_Route_Search_Auto_Exit_Timeout = 60000;
  private static final String TAG = "RGRouteSearchModel";
  private static RGRouteSearchModel mInstance = null;
  public boolean isSearching = false;
  private int mLastBkgItemId = -1;
  private String mLastKey = "";
  private boolean mRouteSearchMode = false;
  public SearchPoiPager mSearchPoiPager;
  
  public static RGRouteSearchModel getInstance()
  {
    if (mInstance == null) {
      mInstance = new RGRouteSearchModel();
    }
    return mInstance;
  }
  
  public int getLastBkgItemId()
  {
    return this.mLastBkgItemId;
  }
  
  public String getmLastKey()
  {
    return this.mLastKey;
  }
  
  public boolean isRouteSearchMode()
  {
    return this.mRouteSearchMode;
  }
  
  public void reset()
  {
    LogUtil.e("RGRouteSearchModel", "reset");
    this.mRouteSearchMode = false;
    this.isSearching = false;
    this.mLastBkgItemId = -1;
    this.mLastKey = "";
  }
  
  public void resetLastBkgItemId()
  {
    this.mLastBkgItemId = -1;
  }
  
  public void setLastBkgItemId(int paramInt)
  {
    this.mLastBkgItemId = paramInt;
  }
  
  public void setRouteSearchMode(boolean paramBoolean)
  {
    this.mRouteSearchMode = paramBoolean;
  }
  
  public void setmLastKey(String paramString)
  {
    this.mLastKey = paramString;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/model/RGRouteSearchModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */