package com.baidu.platform.comapi.search;

@Deprecated
public abstract interface SearchListener
{
  public abstract void onGetAddrListResult(String paramString);
  
  public abstract void onGetAddrResult(String paramString);
  
  public abstract void onGetBusDetailResult(String paramString);
  
  public abstract void onGetBusRouteResult(String paramString);
  
  public abstract void onGetCarRouteResult(String paramString);
  
  public abstract void onGetCityInfoResult(String paramString);
  
  public abstract void onGetCityListResult(String paramString);
  
  public abstract void onGetClientFuncResult(String paramString);
  
  public abstract void onGetErrorNoResult(int paramInt1, int paramInt2);
  
  public abstract void onGetFootRouteResult(String paramString);
  
  public abstract void onGetMCarRouteResult(String paramString);
  
  public abstract void onGetPoiBKGResult(String paramString);
  
  public abstract void onGetPoiDetailResult(String paramString);
  
  public abstract void onGetPoiRGCDetailResult(String paramString);
  
  public abstract void onGetPoiResult(String paramString);
  
  public abstract void onGetShareUrlResult(String paramString);
  
  public abstract void onGetSpecialQueryResult(String paramString);
  
  public abstract void onGetSuggestionResult(String paramString);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/platform/comapi/search/SearchListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */