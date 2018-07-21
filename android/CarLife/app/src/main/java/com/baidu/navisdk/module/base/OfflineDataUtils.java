package com.baidu.navisdk.module.base;

import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;

public class OfflineDataUtils
{
  public static boolean checkRouteOfflineData()
  {
    if (BNOfflineDataManager.getInstance().isProvinceDataDownload(0))
    {
      Object localObject = ((RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel")).getRouteInput();
      boolean bool2 = true;
      Iterator localIterator = ((ArrayList)localObject).iterator();
      do
      {
        do
        {
          do
          {
            bool1 = bool2;
            if (!localIterator.hasNext()) {
              break;
            }
            localObject = (RoutePlanNode)localIterator.next();
          } while ((localObject == null) || (!((RoutePlanNode)localObject).isNodeSettedData()));
          localObject = ((RoutePlanNode)localObject).getGeoPoint();
        } while ((localObject == null) || (!((GeoPoint)localObject).isValid()));
        for (localObject = BNPoiSearcher.getInstance().getDistrictByPoint((GeoPoint)localObject, 0); (localObject != null) && (((DistrictInfo)localObject).mType > 2); localObject = BNPoiSearcher.getInstance().getParentDistrict(((DistrictInfo)localObject).mId)) {}
      } while ((localObject == null) || (BNOfflineDataManager.getInstance().isProvinceDataDownload(((DistrictInfo)localObject).mId)));
      boolean bool1 = false;
      return bool1;
    }
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/base/OfflineDataUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */