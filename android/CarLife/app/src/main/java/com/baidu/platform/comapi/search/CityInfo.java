package com.baidu.platform.comapi.search;

import com.baidu.entity.pb.CityResult.Content.Sgeo;
import com.baidu.platform.comapi.basestruct.Point;

public class CityInfo
{
  public static final CityInfo DEFAULT_CITYINFO = new CityInfo();
  public int mCityCode;
  public Point mCityGeo;
  public String mCityName;
  public int mCityType;
  public String mCityUid;
  public int mLevel;
  public int mPreCityCode;
  public String mPreCityName;
  public int mResultType;
  public CityResult.Content.Sgeo mSgeo;
  public boolean mSup_bus;
  public boolean mSup_lukuang;
  public boolean mSup_subway;
  public String mcName;
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/search/CityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */