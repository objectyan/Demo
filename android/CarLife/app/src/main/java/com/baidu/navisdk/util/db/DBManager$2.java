package com.baidu.navisdk.util.db;

import com.baidu.navisdk.db.OperatorDBCallback.CalcRouteHistoryCallback;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import java.util.ArrayList;

class DBManager$2 implements CalcRouteHistoryCallback {
    DBManager$2() {
    }

    public void onAddDest(RoutePlanNode node) {
        DBManager.addHistoryDestPointToDB(node);
    }

    public void onAddRoute(ArrayList<RoutePlanNode> nodesList) {
        DBManager.addHistoryRouteToDB(nodesList);
    }

    public void onAddViaRoute(ArrayList<RoutePlanNode> nodesList) {
        DBManager.addLastNaviPointsToDB(nodesList);
    }
}
