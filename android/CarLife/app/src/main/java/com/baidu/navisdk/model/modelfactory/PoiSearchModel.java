package com.baidu.navisdk.model.modelfactory;

import com.baidu.navisdk.model.datastruct.SearchParkPoi;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.model.datastruct.SearchSugData;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.List;

public class PoiSearchModel
  extends BaseModel
{
  private SearchPoi mAntiGeoPoi = new SearchPoi();
  private GeoPoint mAntiGeoPoint;
  private SearchPoi mMapSearchPoi;
  private ArrayList<SearchParkPoi> mParkPoiList = new ArrayList(0);
  private ArrayList<SearchPoi> mPoiList = new ArrayList();
  private byte[] mSearchPBData = null;
  private List<SearchPoiPager> mSearchPoiPageraList = new ArrayList();
  private SearchPoi mSpaceSearchPoi;
  private ArrayList<SearchSugData> mSugList = new ArrayList();
  private GeoPoint myPositionPoint;
  
  public void addSearchPoiPager(SearchPoiPager paramSearchPoiPager)
  {
    if (paramSearchPoiPager == null) {
      return;
    }
    SearchPoiPager localSearchPoiPager = paramSearchPoiPager.getPrevPager();
    if (localSearchPoiPager == null) {
      this.mSearchPoiPageraList.clear();
    }
    for (;;)
    {
      this.mSearchPoiPageraList.add(paramSearchPoiPager);
      return;
      if ((this.mSearchPoiPageraList.size() > 0) && (!localSearchPoiPager.equals((SearchPoiPager)this.mSearchPoiPageraList.get(this.mSearchPoiPageraList.size() - 1)))) {
        this.mSearchPoiPageraList.clear();
      }
    }
  }
  
  public void clearSearchParkPoi()
  {
    if (this.mParkPoiList != null) {}
    try
    {
      this.mParkPoiList.clear();
      return;
    }
    catch (Exception localException) {}
  }
  
  public SearchPoi getAntiGeoPoi()
  {
    return this.mAntiGeoPoi;
  }
  
  public GeoPoint getAntiGeoPoint()
  {
    return this.mAntiGeoPoint;
  }
  
  public SearchPoi getMapSearchPoi()
  {
    return this.mMapSearchPoi;
  }
  
  public GeoPoint getMyPositionGeo()
  {
    return this.myPositionPoint;
  }
  
  public List<SearchPoi> getPoiList()
  {
    return this.mPoiList;
  }
  
  public byte[] getSearchPBData()
  {
    return this.mSearchPBData;
  }
  
  public ArrayList<SearchParkPoi> getSearchParkPoi()
  {
    return this.mParkPoiList;
  }
  
  public List<SearchPoiPager> getSearchPoiPagerList()
  {
    return this.mSearchPoiPageraList;
  }
  
  public SearchPoi getSpaceSearchPoi()
  {
    return this.mSpaceSearchPoi;
  }
  
  public ArrayList<SearchSugData> getSugList()
  {
    return this.mSugList;
  }
  
  public void setAntiGeoPoi(SearchPoi paramSearchPoi)
  {
    if (paramSearchPoi == null) {
      return;
    }
    this.mAntiGeoPoi = new SearchPoi();
    this.mAntiGeoPoi.copy(paramSearchPoi);
  }
  
  public void setAntiGeoPoint(GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint == null) {
      return;
    }
    this.mAntiGeoPoint = paramGeoPoint;
  }
  
  public void setMapSearchPoi(SearchPoi paramSearchPoi)
  {
    this.mMapSearchPoi = paramSearchPoi;
  }
  
  public void setMyPositionGeo(GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint != null) {
      this.myPositionPoint = paramGeoPoint;
    }
  }
  
  public void setPoiList(List<SearchPoi> paramList)
  {
    this.mPoiList.clear();
    if (paramList == null) {
      return;
    }
    this.mPoiList.addAll(paramList);
  }
  
  public void setSearchPBData(byte[] paramArrayOfByte)
  {
    this.mSearchPBData = paramArrayOfByte;
  }
  
  public void setSearchParkPoi(ArrayList<SearchParkPoi> paramArrayList)
  {
    this.mParkPoiList.clear();
    if (paramArrayList != null) {
      this.mParkPoiList.addAll(paramArrayList);
    }
  }
  
  public void setSpaceSearchPoi(SearchPoi paramSearchPoi)
  {
    if (paramSearchPoi == null) {
      return;
    }
    this.mSpaceSearchPoi = paramSearchPoi;
  }
  
  public void setSugList(ArrayList<SearchSugData> paramArrayList)
  {
    this.mSugList.clear();
    if (paramArrayList == null) {
      return;
    }
    this.mSugList.addAll(paramArrayList);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/modelfactory/PoiSearchModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */