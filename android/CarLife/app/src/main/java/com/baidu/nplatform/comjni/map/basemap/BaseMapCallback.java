package com.baidu.nplatform.comjni.map.basemap;

import android.os.Bundle;
import android.util.SparseArray;
import com.baidu.navisdk.util.common.LogUtil;

public class BaseMapCallback
{
  private static SparseArray<MapLayerDataInterface> mCallbacks = new SparseArray(2);
  
  public static int ReqLayerData(Bundle paramBundle, int paramInt1, int paramInt2)
  {
    LogUtil.e("layer", "ReqLayerData layerID = " + paramInt1);
    int j = mCallbacks.size();
    if (j == 0) {}
    for (;;)
    {
      return 0;
      int i = 0;
      while (i < j)
      {
        MapLayerDataInterface localMapLayerDataInterface = (MapLayerDataInterface)mCallbacks.valueAt(i);
        if ((localMapLayerDataInterface != null) && (localMapLayerDataInterface.hasLayer(paramInt1))) {
          return localMapLayerDataInterface.mapLayerDataReq(paramBundle, paramInt1, paramInt2);
        }
        i += 1;
      }
    }
  }
  
  public boolean SetMapCallback(MapLayerDataInterface paramMapLayerDataInterface)
  {
    if (paramMapLayerDataInterface == null) {
      return false;
    }
    mCallbacks.put(0, paramMapLayerDataInterface);
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/nplatform/comjni/map/basemap/BaseMapCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */