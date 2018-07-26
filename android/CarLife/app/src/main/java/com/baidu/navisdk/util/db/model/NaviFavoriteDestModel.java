package com.baidu.navisdk.util.db.model;

import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.db.object.BaseDBObject;
import com.baidu.navisdk.util.db.object.RoutePlanNodeDBObject;
import com.baidu.navisdk.util.db.table.BaseDBTable;
import com.baidu.navisdk.util.db.table.FavoriteRoutePlanNodeDBTable;
import java.util.ArrayList;
import java.util.List;

public class NaviFavoriteDestModel {
    private static final int SIZE_LIMIT = 50;
    private static final int mArg1 = 2;
    private boolean mIsQueryDatabase;
    private List<RoutePlanNodeDBObject> mRoutePlanNodes;
    private FavoriteRoutePlanNodeDBTable mTable;

    static class InnerHolder {
        static NaviFavoriteDestModel mInstance = new NaviFavoriteDestModel();

        InnerHolder() {
        }
    }

    private NaviFavoriteDestModel() {
        this.mRoutePlanNodes = null;
        this.mIsQueryDatabase = false;
        this.mTable = new FavoriteRoutePlanNodeDBTable();
    }

    public static NaviFavoriteDestModel getInstance() {
        return InnerHolder.mInstance;
    }

    public ArrayList<RoutePlanNode> getRoutePlanNode() {
        return RoutePlanNodeDBObject.convertToRoutePlanNodeList(this.mRoutePlanNodes);
    }

    public boolean checkIsQueryDB() {
        return this.mIsQueryDatabase;
    }

    public void getAllHistoryDestPoints() {
        if (this.mRoutePlanNodes == null) {
            String[] whereArgs = new String[]{"2"};
            String orderBy = BaseDBTable.ORDERBY_DOWN;
            this.mRoutePlanNodes = this.mTable.queryMulti("arg1=?", whereArgs, "routeplan_id", orderBy);
            if (this.mRoutePlanNodes == null) {
                this.mRoutePlanNodes = new ArrayList(0);
            }
            consumeSize();
            this.mIsQueryDatabase = true;
        }
    }

    public void clear() {
        if (!this.mIsQueryDatabase) {
            getAllHistoryDestPoints();
        }
        String[] whereArgs = new String[]{"2"};
        this.mTable.delete("arg1=?", whereArgs);
        this.mRoutePlanNodes.clear();
    }

    public void removeNaviDest(RoutePlanNode node) {
        if (node != null) {
            if (!this.mIsQueryDatabase) {
                getAllHistoryDestPoints();
            }
            for (int i = 0; i < this.mRoutePlanNodes.size(); i++) {
                RoutePlanNodeDBObject tempNode = (RoutePlanNodeDBObject) this.mRoutePlanNodes.get(i);
                if (RoutePlanNodeDBObject.compare(tempNode, node)) {
                    this.mTable.delete(tempNode.getId());
                    this.mRoutePlanNodes.remove(i);
                    return;
                }
            }
        }
    }

    public void addNaviDest(RoutePlanNode node) {
        if (node != null && node.isNodeIntegrated()) {
            if (!this.mIsQueryDatabase) {
                getAllHistoryDestPoints();
            }
            this.mTable.beginTransaction();
            removeNaviDest(node);
            RoutePlanNodeDBObject obj = new RoutePlanNodeDBObject();
            obj.copy(node);
            obj.setArg1(2);
            this.mTable.insert((BaseDBObject) obj);
            this.mTable.endTransaction();
            this.mRoutePlanNodes.add(0, obj);
            consumeSize();
        }
    }

    private void consumeSize() {
        if (this.mRoutePlanNodes.size() > 50) {
            RoutePlanNodeDBObject obj = (RoutePlanNodeDBObject) this.mRoutePlanNodes.get(this.mRoutePlanNodes.size() - 1);
            if (obj != null) {
                this.mTable.delete(obj.getId());
            }
            this.mRoutePlanNodes.remove(this.mRoutePlanNodes.size() - 1);
        }
    }
}
