package com.baidu.navisdk.model.datastruct;

import com.baidu.navi.style.StyleManager;
import com.baidu.nplatform.comapi.basestruct.Point;

public class FavoritePoiInfo
{
  public String mFavAddTime = "";
  public String mFavAddr = StyleManager.getString(2131296851);
  public String mFavAlias = "";
  public int mFavCityId = -1;
  public String mFavCityName = "";
  public boolean mFavHasSync = false;
  public String mFavKey = "";
  public String mFavName = StyleManager.getString(2131296852);
  public String mPhone = "";
  public String mPoiDesc;
  public String mPoiId = "";
  public int mPoiType;
  public Point mViewPoint = new Point();
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof FavoritePoiInfo))
    {
      paramObject = (FavoritePoiInfo)paramObject;
      if (this.mFavKey.equals(((FavoritePoiInfo)paramObject).mFavKey)) {
        return true;
      }
    }
    return false;
  }
  
  public void setValue(FavoritePoiInfo paramFavoritePoiInfo)
  {
    this.mPoiId = paramFavoritePoiInfo.mPoiId;
    this.mPoiType = paramFavoritePoiInfo.mPoiType;
    this.mFavCityId = paramFavoritePoiInfo.mFavCityId;
    this.mFavKey = paramFavoritePoiInfo.mFavKey;
    this.mFavName = paramFavoritePoiInfo.mFavName;
    this.mFavAlias = paramFavoritePoiInfo.mFavAlias;
    this.mFavAddr = paramFavoritePoiInfo.mFavAddr;
    this.mFavCityName = paramFavoritePoiInfo.mFavCityName;
    this.mPhone = paramFavoritePoiInfo.mPhone;
    this.mViewPoint.setmPtx(paramFavoritePoiInfo.mViewPoint.x);
    this.mViewPoint.setmPty(paramFavoritePoiInfo.mViewPoint.y);
    this.mFavAddTime = paramFavoritePoiInfo.mFavAddTime;
    this.mFavHasSync = paramFavoritePoiInfo.mFavHasSync;
  }
  
  public String toString()
  {
    return "mFavKey=" + this.mFavKey + ", mFavName=" + this.mFavName + ", mFavAddr=" + this.mFavAddr + ", mFavCityName=" + this.mFavCityName + "mViewPoint.lon=" + this.mViewPoint.x + "mViewPoint.lat=" + this.mViewPoint.y;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/datastruct/FavoritePoiInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */