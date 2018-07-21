package com.baidu.nplatform.comjni.map.basemap;

import android.os.Bundle;
import com.baidu.navisdk.util.common.StringUtils;

public class LocationCallback
{
  private static String strJsonData = null;
  
  public static boolean GetLocationLayerData(Bundle paramBundle)
  {
    if (StringUtils.isEmpty(strJsonData)) {
      return false;
    }
    if (paramBundle != null) {
      paramBundle.putString("jsondata", strJsonData);
    }
    return true;
  }
  
  public static void setData(String paramString)
  {
    if (StringUtils.isNotEmpty(paramString)) {
      strJsonData = paramString;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/nplatform/comjni/map/basemap/LocationCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */