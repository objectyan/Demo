package com.baidu.platform.comapi.search;

import java.util.ArrayList;

public class CityListResult
{
  private ArrayList<Citys> mCities;
  private int mCityCount;
  private CityInfo mCityInfo;
  public boolean mCurrent_null;
  public int mResultType;
  private ArrayList<String> mSuggestQueries;
  
  public int getCityCount()
  {
    return this.mCityCount;
  }
  
  public CityInfo getCityInfo()
  {
    return this.mCityInfo;
  }
  
  public ArrayList<Citys> getCitys()
  {
    return this.mCities;
  }
  
  public ArrayList<String> getSuggestQueries()
  {
    return this.mSuggestQueries;
  }
  
  public void setCityCount(int paramInt)
  {
    this.mCityCount = paramInt;
  }
  
  public void setCityinfo(CityInfo paramCityInfo)
  {
    this.mCityInfo = paramCityInfo;
  }
  
  public void setCitys(ArrayList<Citys> paramArrayList)
  {
    this.mCities = paramArrayList;
  }
  
  public void setSuggestQueries(ArrayList<String> paramArrayList)
  {
    this.mSuggestQueries = paramArrayList;
  }
  
  public class Citys
  {
    public String extinfo;
    public int mCode;
    public String mName;
    public int mNum;
    public ArrayList<CityListResult.Pois> poiList;
    public int poiNum;
    public String searchquery;
    public int type;
    public String viewName;
    
    public Citys() {}
  }
  
  public class Pois
  {
    public String addr;
    public String bid;
    public int citycode;
    public String name;
    public String searchpoi;
    public String stdtag;
    
    public Pois() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/search/CityListResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */