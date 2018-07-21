package com.baidu.navisdk.ui.search;

import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import java.util.ArrayList;

public abstract interface IBNSearchResultListener
{
  public abstract void asynSearchCityList(SearchPoiPager paramSearchPoiPager, SearchPoi paramSearchPoi);
  
  public abstract String getDistance(SearchPoi paramSearchPoi);
  
  public abstract void goChildPoiDetailFragment(boolean paramBoolean1, int paramInt1, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3);
  
  public abstract void goPoiDetailFragment(boolean paramBoolean1, int paramInt, boolean paramBoolean2, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3);
  
  public abstract void onCountrywideOnlineSearch();
  
  public abstract void onLoadMore();
  
  public abstract void onNormalOnlineSearch();
  
  public abstract void onRefresh();
  
  public abstract void pressleftTitleBack();
  
  public abstract void setFocusMadianIndex(SearchPoi paramSearchPoi, boolean paramBoolean, int paramInt);
  
  public abstract void startGoNavi(boolean paramBoolean, SearchPoi paramSearchPoi);
  
  public abstract void updateAppMapView(int paramInt1, int paramInt2);
  
  public abstract void updateResultPoiBkgLayer(ArrayList<SearchPoi> paramArrayList);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/search/IBNSearchResultListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */