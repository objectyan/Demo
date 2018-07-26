package com.baidu.navisdk.util.db.model;

import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.db.object.BaseDBObject;
import com.baidu.navisdk.util.db.object.RoutePlanNodeDBObject;
import com.baidu.navisdk.util.db.table.BaseDBTable;
import com.baidu.navisdk.util.db.table.RoutePlanNodeDBTable;
import java.util.ArrayList;
import java.util.List;

public class NaviCurRoutePoiModel {
    private static final int ARG = 5;
    private List<RoutePlanNodeDBObject> mRoutePlanDBNodes;
    private RoutePlanNodeDBTable mRoutePlanNodeDBTable;

    static class InnerHolder {
        static NaviCurRoutePoiModel mInstance = new NaviCurRoutePoiModel();

        InnerHolder() {
        }
    }

    private NaviCurRoutePoiModel() {
        this.mRoutePlanNodeDBTable = new RoutePlanNodeDBTable();
    }

    public static NaviCurRoutePoiModel getInstance() {
        return InnerHolder.mInstance;
    }

    public ArrayList<RoutePlanNode> getLastNaviNodesList() {
        return RoutePlanNodeDBObject.convertToRoutePlanNodeList(this.mRoutePlanDBNodes);
    }

    public void getLastNaviPointsFromDB() {
        if (this.mRoutePlanDBNodes == null) {
            String[] whereArgs = new String[]{"5"};
            String orderBy = BaseDBTable.ORDERBY_UP;
            this.mRoutePlanDBNodes = this.mRoutePlanNodeDBTable.queryMulti("arg1=?", whereArgs, "routeplan_id", orderBy);
            if (this.mRoutePlanDBNodes == null) {
                this.mRoutePlanDBNodes = new ArrayList(0);
            }
        }
    }

    public void clear() {
        getLastNaviPointsFromDB();
        String[] whereArgs = new String[]{"5"};
        this.mRoutePlanNodeDBTable.delete("arg1=?", whereArgs);
        this.mRoutePlanDBNodes.clear();
    }

    public void removeCurNaviViaNode(RoutePlanNode node) {
        if (node != null) {
            getLastNaviPointsFromDB();
            for (int i = 0; i < this.mRoutePlanDBNodes.size(); i++) {
                RoutePlanNodeDBObject tempNode = (RoutePlanNodeDBObject) this.mRoutePlanDBNodes.get(i);
                if (RoutePlanNodeDBObject.compare(tempNode, node)) {
                    this.mRoutePlanNodeDBTable.delete(tempNode.getId());
                    this.mRoutePlanDBNodes.remove(i);
                    return;
                }
            }
        }
    }

    public void addCurNaviNodes(ArrayList<RoutePlanNode> nodesList) {
        if (nodesList != null && nodesList.size() != 0) {
            getLastNaviPointsFromDB();
            clear();
            this.mRoutePlanNodeDBTable.beginTransaction();
            int index = 1;
            while (index < nodesList.size()) {
                RoutePlanNode node = (RoutePlanNode) nodesList.get(index);
                if (node != null && node.getLatitudeE6() != Integer.MIN_VALUE && node.getLongitudeE6() != Integer.MIN_VALUE) {
                    RoutePlanNodeDBObject obj = new RoutePlanNodeDBObject();
                    obj.copy(node);
                    obj.setArg1(5);
                    this.mRoutePlanNodeDBTable.insert((BaseDBObject) obj);
                    this.mRoutePlanDBNodes.add(obj);
                    index++;
                } else {
                    return;
                }
            }
            this.mRoutePlanNodeDBTable.endTransaction();
        }
    }
}
