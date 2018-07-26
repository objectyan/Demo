package com.baidu.navisdk.util.db.model;

import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.db.object.BaseDBObject;
import com.baidu.navisdk.util.db.object.NaviRouteDBObject;
import com.baidu.navisdk.util.db.object.RoutePlanNodeDBObject;
import com.baidu.navisdk.util.db.table.BaseDBTable;
import com.baidu.navisdk.util.db.table.NaviRouteDBTable;
import com.baidu.navisdk.util.db.table.RoutePlanNodeDBTable;
import java.util.ArrayList;
import java.util.List;

public class NaviRouteHistoryModel {
    private static final int SIZE_LIMIT = 50;
    private static final int mArg1 = 3;
    private NaviRouteDBTable mNaviRouteDBTable;
    private ArrayList<NaviRouteDBObject> mNaviRouteHistory;
    private RoutePlanNodeDBTable mRoutePlanNodeDBTable;

    static class InnerHolder {
        static NaviRouteHistoryModel mInstance = new NaviRouteHistoryModel();

        InnerHolder() {
        }
    }

    private NaviRouteHistoryModel() {
        this.mNaviRouteDBTable = new NaviRouteDBTable();
        this.mRoutePlanNodeDBTable = new RoutePlanNodeDBTable();
    }

    public static NaviRouteHistoryModel getInstance() {
        return InnerHolder.mInstance;
    }

    public int getSize() {
        return this.mNaviRouteHistory.size();
    }

    public ArrayList<NaviRouteDBObject> getNaviRouteList() {
        return this.mNaviRouteHistory;
    }

    public void getAllHistoryRoutes() {
        if (this.mNaviRouteHistory == null) {
            try {
                this.mNaviRouteDBTable.beginTransaction();
                this.mNaviRouteHistory = this.mNaviRouteDBTable.queryAll(NaviRouteDBTable.TIME, BaseDBTable.ORDERBY_DOWN);
                if (this.mNaviRouteHistory == null) {
                    this.mNaviRouteHistory = new ArrayList(0);
                }
                consumeSize();
                for (int i = 0; i < this.mNaviRouteHistory.size(); i++) {
                    NaviRouteDBObject naviRouteDBObject = (NaviRouteDBObject) this.mNaviRouteHistory.get(i);
                    if (naviRouteDBObject != null) {
                        String[] whereArgs = new String[]{"3", naviRouteDBObject.getId() + ""};
                        String orderBy = BaseDBTable.ORDERBY_UP;
                        naviRouteDBObject.setRoutePlanNodes(this.mRoutePlanNodeDBTable.queryMulti("arg1=? and arg2=?", whereArgs, "routeplan_id", orderBy));
                    }
                }
                this.mNaviRouteDBTable.endTransaction();
            } catch (Exception e) {
            }
        }
    }

    public void addNaviRoute(List<RoutePlanNode> nodes) {
        if (nodes != null && nodes.size() != 0) {
            getAllHistoryRoutes();
            this.mRoutePlanNodeDBTable.beginTransaction();
            NaviRouteDBObject existObject = getExistObject(nodes);
            if (existObject == null) {
                NaviRouteDBObject naviRouteObject = new NaviRouteDBObject();
                naviRouteObject.setTime(System.currentTimeMillis());
                this.mNaviRouteDBTable.insert((BaseDBObject) naviRouteObject);
                ArrayList<RoutePlanNodeDBObject> nodeDBObjects = new ArrayList(nodes.size());
                naviRouteObject.setRoutePlanNodes(nodeDBObjects);
                int arg2 = naviRouteObject.getId();
                for (int i = 0; i < nodes.size(); i++) {
                    RoutePlanNodeDBObject obj = new RoutePlanNodeDBObject();
                    obj.copy((RoutePlanNode) nodes.get(i));
                    obj.setArg1(3);
                    obj.setArg2(arg2);
                    this.mRoutePlanNodeDBTable.insert((BaseDBObject) obj);
                    nodeDBObjects.add(obj);
                }
                this.mNaviRouteHistory.add(0, naviRouteObject);
                consumeSize();
            } else {
                existObject.setTime(System.currentTimeMillis());
                this.mNaviRouteDBTable.update(existObject);
                this.mNaviRouteHistory.add(0, existObject);
            }
            this.mRoutePlanNodeDBTable.endTransaction();
        }
    }

    public void removeNaviRoute(List<RoutePlanNode> nodes) {
        if (nodes != null) {
            getAllHistoryRoutes();
            handleRepeatNaviRoute(nodes);
        }
    }

    private boolean compareRoute(List<RoutePlanNode> nodes, List<RoutePlanNodeDBObject> otherNodes) {
        boolean z = false;
        if (nodes != null && otherNodes != null && nodes.size() == otherNodes.size()) {
            z = true;
            for (int i = 0; i < nodes.size(); i++) {
                z = RoutePlanNodeDBObject.compare((RoutePlanNode) nodes.get(i), (RoutePlanNodeDBObject) otherNodes.get(i));
                if (!z) {
                    break;
                }
            }
        }
        return z;
    }

    private int handleRepeatNaviRoute(List<RoutePlanNode> nodes) {
        int i = 0;
        while (i < this.mNaviRouteHistory.size()) {
            NaviRouteDBObject tempNaviRouteDBObject = (NaviRouteDBObject) this.mNaviRouteHistory.get(i);
            if (tempNaviRouteDBObject == null || !compareRoute(nodes, tempNaviRouteDBObject.getRoutePlanDBNodes())) {
                i++;
            } else {
                this.mNaviRouteHistory.remove(i);
                delelteNaviRoute(tempNaviRouteDBObject.getId());
                return i;
            }
        }
        return -1;
    }

    private NaviRouteDBObject getExistObject(List<RoutePlanNode> nodes) {
        for (int i = 0; i < this.mNaviRouteHistory.size(); i++) {
            NaviRouteDBObject tempNaviRouteDBObject = (NaviRouteDBObject) this.mNaviRouteHistory.get(i);
            if (tempNaviRouteDBObject != null && compareRoute(nodes, tempNaviRouteDBObject.getRoutePlanDBNodes())) {
                return (NaviRouteDBObject) this.mNaviRouteHistory.remove(i);
            }
        }
        return null;
    }

    public void removeNaviRouteHistoryByPosition(int position) {
        if (this.mNaviRouteHistory != null) {
            getAllHistoryRoutes();
            NaviRouteDBObject routeDBObj = null;
            if (position >= 0) {
                try {
                    if (position < this.mNaviRouteHistory.size()) {
                        routeDBObj = (NaviRouteDBObject) this.mNaviRouteHistory.get(position);
                    }
                } catch (Exception e) {
                    return;
                }
            }
            if (routeDBObj != null) {
                delelteNaviRoute(routeDBObj.getId());
                this.mNaviRouteHistory.remove(position);
            }
        }
    }

    private void delelteNaviRoute(int id) {
        try {
            this.mNaviRouteDBTable.delete(id);
            String[] whereArgs = new String[]{"3", id + ""};
            this.mRoutePlanNodeDBTable.delete("arg1=? and arg2=?", whereArgs);
        } catch (Exception e) {
        }
    }

    public void clear() {
        getAllHistoryRoutes();
        this.mNaviRouteDBTable.beginTransaction();
        this.mNaviRouteDBTable.deleteAll();
        String[] whereArgs = new String[]{"3"};
        this.mRoutePlanNodeDBTable.delete("arg1=?", whereArgs);
        this.mNaviRouteDBTable.endTransaction();
        this.mNaviRouteHistory.clear();
    }

    private void consumeSize() {
        if (this.mNaviRouteHistory.size() > 50) {
            NaviRouteDBObject obj = (NaviRouteDBObject) this.mNaviRouteHistory.get(this.mNaviRouteHistory.size() - 1);
            if (obj != null) {
                delelteNaviRoute(obj.getId());
            }
            this.mNaviRouteHistory.remove(this.mNaviRouteHistory.size() - 1);
        }
    }
}
