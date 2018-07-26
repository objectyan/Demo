package com.baidu.navisdk.module.base;

import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.Iterator;

public class OfflineDataUtils {
    public static boolean checkRouteOfflineData() {
        if (!BNOfflineDataManager.getInstance().isProvinceDataDownload(0)) {
            return false;
        }
        Iterator it = ((RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN)).getRouteInput().iterator();
        while (it.hasNext()) {
            RoutePlanNode node = (RoutePlanNode) it.next();
            if (node != null && node.isNodeSettedData()) {
                GeoPoint point = node.getGeoPoint();
                if (point != null && point.isValid()) {
                    DistrictInfo districtInfo = BNPoiSearcher.getInstance().getDistrictByPoint(point, 0);
                    while (districtInfo != null && districtInfo.mType > 2) {
                        districtInfo = BNPoiSearcher.getInstance().getParentDistrict(districtInfo.mId);
                    }
                    if (!(districtInfo == null || BNOfflineDataManager.getInstance().isProvinceDataDownload(districtInfo.mId))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
