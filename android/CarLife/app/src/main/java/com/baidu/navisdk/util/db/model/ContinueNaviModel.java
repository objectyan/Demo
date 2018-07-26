package com.baidu.navisdk.util.db.model;

import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.db.object.BaseDBObject;
import com.baidu.navisdk.util.db.object.RoutePlanNodeDBObject;
import com.baidu.navisdk.util.db.table.BaseDBTable;
import com.baidu.navisdk.util.db.table.RoutePlanNodeDBTable;
import java.util.List;

public class ContinueNaviModel {
    private static final int mArg1 = 1;
    private List<RoutePlanNodeDBObject> mRoutePlanNodes;
    private RoutePlanNodeDBTable mTable;

    static class InnerHolder {
        static ContinueNaviModel mInstance = new ContinueNaviModel();

        InnerHolder() {
        }
    }

    private ContinueNaviModel() {
        this.mTable = new RoutePlanNodeDBTable();
        String[] whereArgs = new String[]{"1"};
        String orderBy = BaseDBTable.ORDERBY_UP;
        this.mRoutePlanNodes = this.mTable.queryMulti("arg1=?", whereArgs, "routeplan_id", orderBy);
    }

    public static ContinueNaviModel getInstance() {
        return InnerHolder.mInstance;
    }

    public List<RoutePlanNode> getContinueNaviNodes() {
        return RoutePlanNodeDBObject.convertToRoutePlanNodeList(this.mRoutePlanNodes);
    }

    public boolean hasContinueNaviNode() {
        return (this.mRoutePlanNodes == null || this.mRoutePlanNodes.size() == 0) ? false : true;
    }

    public void clear() {
        String[] whereArgs = new String[]{"1"};
        this.mTable.delete("arg1=?", whereArgs);
        this.mRoutePlanNodes = null;
    }

    public void addContinueNaviNodes(List<RoutePlanNode> nodes) {
        if (nodes != null && nodes.size() != 0) {
            if (!(this.mRoutePlanNodes == null || this.mRoutePlanNodes.size() == 0)) {
                clear();
            }
            this.mTable.beginTransaction();
            for (int i = 0; i < nodes.size(); i++) {
                RoutePlanNodeDBObject obj = new RoutePlanNodeDBObject();
                obj.setArg1(1);
                obj.copy((RoutePlanNode) nodes.get(i));
                this.mTable.insert((BaseDBObject) obj);
                this.mRoutePlanNodes.add(obj);
            }
            this.mTable.endTransaction();
        }
    }
}
