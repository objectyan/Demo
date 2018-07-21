package com.baidu.navisdk.module.base;

import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;

public class LocationUtils
{
  public static int getCurrentCityId()
  {
    int i = -1;
    DistrictInfo localDistrictInfo = GeoLocateModel.getInstance().getCurrentDistrict();
    if (localDistrictInfo != null) {
      i = localDistrictInfo.mId;
    }
    return i;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/base/LocationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */