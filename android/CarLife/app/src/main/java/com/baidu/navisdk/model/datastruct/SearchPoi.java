package com.baidu.navisdk.model.datastruct;

import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class SearchPoi
{
  public static final int POI_TYPE_CHILD = 1;
  public static final int POI_TYPE_CITY_LIST = 1;
  public static final int POI_TYPE_NORMAL = 0;
  public static final int POI_TYPE_PARENT = 0;
  public String mAddress;
  public String mAliasName;
  public int mChildCnt;
  public int mDistrictId;
  public int mFCType;
  public GeoPoint mGuidePoint;
  public int mId;
  public String mName;
  public String mOriginUID = null;
  public String mPhone;
  public int mPoiCount;
  public int mShowCatalog;
  public String mStreetId;
  public int mType;
  public String mUid = null;
  public GeoPoint mViewPoint;
  public int mWanda;
  public int mWeight;
  
  public SearchPoi() {}
  
  public SearchPoi(SearchPoi paramSearchPoi)
  {
    copy(paramSearchPoi);
  }
  
  public void copy(SearchPoi paramSearchPoi)
  {
    if (paramSearchPoi == null) {
      return;
    }
    if (paramSearchPoi.mName != null)
    {
      this.mName = new String(paramSearchPoi.mName);
      if (paramSearchPoi.mAddress == null) {
        break label213;
      }
      this.mAddress = new String(paramSearchPoi.mAddress);
      label49:
      if (paramSearchPoi.mPhone == null) {
        break label222;
      }
      this.mPhone = new String(paramSearchPoi.mPhone);
      label71:
      if (paramSearchPoi.mGuidePoint == null) {
        break label231;
      }
      this.mGuidePoint = new GeoPoint(paramSearchPoi.mGuidePoint.getLongitudeE6(), paramSearchPoi.mGuidePoint.getLatitudeE6());
      label103:
      if (paramSearchPoi.mViewPoint == null) {
        break label245;
      }
      this.mViewPoint = new GeoPoint(paramSearchPoi.mViewPoint.getLongitudeE6(), paramSearchPoi.mViewPoint.getLatitudeE6());
      label135:
      this.mDistrictId = paramSearchPoi.mDistrictId;
      this.mType = paramSearchPoi.mType;
      if (paramSearchPoi.mStreetId == null) {
        break label259;
      }
      this.mStreetId = new String(paramSearchPoi.mStreetId);
      label173:
      if (paramSearchPoi.mOriginUID == null) {
        break label267;
      }
    }
    label213:
    label222:
    label231:
    label245:
    label259:
    label267:
    for (this.mOriginUID = new String(paramSearchPoi.mOriginUID);; this.mOriginUID = null)
    {
      this.mId = paramSearchPoi.mId;
      return;
      this.mName = "";
      break;
      this.mAddress = "";
      break label49;
      this.mPhone = "";
      break label71;
      this.mGuidePoint = new GeoPoint();
      break label103;
      this.mViewPoint = new GeoPoint();
      break label135;
      this.mStreetId = null;
      break label173;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/model/datastruct/SearchPoi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */