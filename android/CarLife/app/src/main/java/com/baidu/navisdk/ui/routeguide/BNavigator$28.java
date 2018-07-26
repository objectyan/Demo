package com.baidu.navisdk.ui.routeguide;

import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.model.datastruct.SearchParkPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;

class BNavigator$28 extends BNWorkerNormalTask<String, String> {
    final /* synthetic */ BNavigator this$0;

    BNavigator$28(BNavigator this$0, String taskName, String pInData) {
        this.this$0 = this$0;
        super(taskName, pInData);
    }

    protected String execute() {
        ArrayList<SearchParkPoi> list = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getSearchParkPoi();
        if (!(list == null || list.size() == 0)) {
            BNMapController.getInstance().showLayer(4, true);
            ArrayList<GeoPoint> geoPoints = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                SearchParkPoi poi = (SearchParkPoi) it.next();
                geoPoints.add(poi.mGuidePoint);
                LogUtil.m15791e(TAG, "updateParkPointOnMap geoPoints = " + poi.mName);
            }
            BNPoiSearcher.getInstance().clearBkgCache();
            BNPoiSearcher.getInstance().updateBkgCache(geoPoints, 2);
            BNMapController.getInstance().updateLayer(4);
            BNMapController.getInstance().showLayer(4, true);
        }
        return null;
    }
}
