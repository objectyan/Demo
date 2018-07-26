package com.baidu.navisdk.util.db;

import com.baidu.navisdk.db.OperatorDBCallback.CurRoutePoiDBCallback;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;

class DBManager$3 implements CurRoutePoiDBCallback {
    DBManager$3() {
    }

    public void onRemoveVia(RoutePlanNode viaNode) {
        DBManager.removeLastNaviViaPointFromDB(viaNode);
    }

    public void onClear() {
        DBManager.clearLastnaviPoints();
    }
}
