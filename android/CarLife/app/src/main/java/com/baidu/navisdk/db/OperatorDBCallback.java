package com.baidu.navisdk.db;

import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import java.util.ArrayList;

public interface OperatorDBCallback {

    public interface CalcRouteHistoryCallback {
        void onAddDest(RoutePlanNode routePlanNode);

        void onAddRoute(ArrayList<RoutePlanNode> arrayList);

        void onAddViaRoute(ArrayList<RoutePlanNode> arrayList);
    }

    public interface CurRoutePoiDBCallback {
        void onClear();

        void onRemoveVia(RoutePlanNode routePlanNode);
    }
}
