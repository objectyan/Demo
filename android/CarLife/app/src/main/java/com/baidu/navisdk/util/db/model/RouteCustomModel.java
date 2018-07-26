package com.baidu.navisdk.util.db.model;

import android.content.Context;
import android.os.Bundle;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.geolocate.BNGeoLocateManager;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.db.object.BaseDBObject;
import com.baidu.navisdk.util.db.object.RouteCustomDBObject;
import com.baidu.navisdk.util.db.object.RoutePlanNodeDBObject;
import com.baidu.navisdk.util.db.table.BaseDBTable;
import com.baidu.navisdk.util.db.table.RouteCustomDBTable;
import com.baidu.navisdk.util.db.table.RoutePlanNodeDBTable;
import java.util.ArrayList;
import java.util.Iterator;

public class RouteCustomModel {
    public static final int ERROR_CUSTOM_NEW_ROUTE_MAX_SUM = -2;
    public static final int ERROR_PARAM = -1;
    public static final int ROUTE_CUSTOM_ACTION_EDIT = 2;
    public static final int ROUTE_CUSTOM_ACTION__CREATE = 1;
    public static final int ROUTE_CUSTOM_AWAKE_CLOSE = 0;
    public static final int ROUTE_CUSTOM_AWAKE_OPEN = 1;
    public static final int ROUTE_CUSTOM_MAX_SUM = 10;
    public static final int ROUTE_CUSTOM_NOT_REPEAT = 0;
    public static final int ROUTE_CUSTOM_REPEAT = 1;
    public static final int ROUTE_DEST_TYPE_COMPANY = 2;
    public static final int ROUTE_DEST_TYPE_HOME = 1;
    public static final int ROUTE_DEST_TYPE_OTHER = 3;
    private static final int mArg1 = 4;
    private Context mContext;
    private RouteCustomDBTable mRouteCustomDBTable;
    private ArrayList<RouteCustomDBObject> mRouteCustomObjList;
    private RoutePlanNodeDBTable mRoutePlanNodeDBTable;

    static class InnerHolder {
        static RouteCustomModel mInstance = new RouteCustomModel();

        InnerHolder() {
        }
    }

    public static RouteCustomModel getInstance() {
        return InnerHolder.mInstance;
    }

    private RouteCustomModel() {
        this.mRoutePlanNodeDBTable = new RoutePlanNodeDBTable();
        this.mRouteCustomDBTable = new RouteCustomDBTable();
        this.mContext = BNaviModuleManager.getContext();
        this.mRouteCustomDBTable.beginTransaction();
        this.mRouteCustomObjList = this.mRouteCustomDBTable.queryMulti(null, null, RouteCustomDBTable.ID, BaseDBTable.ORDERBY_DOWN);
        if (this.mRouteCustomObjList == null) {
            this.mRouteCustomObjList = new ArrayList(0);
        }
        for (int i = 0; i < this.mRouteCustomObjList.size(); i++) {
            RouteCustomDBObject rcDBObj = (RouteCustomDBObject) this.mRouteCustomObjList.get(i);
            String[] whereArgs = new String[]{"4", rcDBObj.getId() + ""};
            String orderBy = BaseDBTable.ORDERBY_UP;
            rcDBObj.setRoutePlanNodes(this.mRoutePlanNodeDBTable.queryMulti("arg1=?and arg2=?", whereArgs, "routeplan_id", orderBy));
            checkRouteCustomDestType(rcDBObj);
        }
        this.mRouteCustomDBTable.endTransaction();
    }

    public ArrayList<RouteCustomDBObject> getRouteCustomList() {
        return this.mRouteCustomObjList;
    }

    public int getRouteCustomSize() {
        return this.mRouteCustomObjList.size();
    }

    public int addNewCustomRoute(int hisRouteDBId, ArrayList<RoutePlanNode> nodesList, int type) {
        if (nodesList == null && type == 3) {
            return -1;
        }
        if (this.mRouteCustomObjList.size() == 10) {
            return -2;
        }
        RouteCustomDBObject obj = new RouteCustomDBObject();
        this.mRoutePlanNodeDBTable.beginTransaction();
        long customTime = System.currentTimeMillis();
        obj.setCustomTime(customTime);
        obj.setModifiedTime(customTime);
        obj.setHisRouteId(hisRouteDBId);
        obj.setName("");
        obj.setIsRepeat(0);
        obj.setRepeatDate("");
        obj.setOpen(1);
        obj.setPushTimeHour(-1);
        obj.setPushTimeMinute(-1);
        obj.setPushTimeMills(-1);
        obj.setDestType(type);
        this.mRouteCustomDBTable.insert((BaseDBObject) obj);
        if (type == 3) {
            ArrayList<RoutePlanNodeDBObject> nodeDBObjects = new ArrayList(nodesList.size());
            obj.setRoutePlanNodes(nodeDBObjects);
            int arg2 = obj.getId();
            for (int i = 0; i < nodesList.size(); i++) {
                RoutePlanNodeDBObject rpNodeObj = new RoutePlanNodeDBObject();
                rpNodeObj.copy((RoutePlanNode) nodesList.get(i));
                rpNodeObj.setArg2(arg2);
                rpNodeObj.setArg1(4);
                this.mRoutePlanNodeDBTable.insert((BaseDBObject) rpNodeObj);
                nodeDBObjects.add(rpNodeObj);
            }
        }
        this.mRoutePlanNodeDBTable.endTransaction();
        checkRouteCustomDestType(obj);
        this.mRouteCustomObjList.add(0, obj);
        return 0;
    }

    private int getExistRouteIndexByRouteList(ArrayList<RoutePlanNode> nodesList) {
        boolean isSame = false;
        int index = 0;
        while (index < this.mRouteCustomObjList.size()) {
            ArrayList<RoutePlanNodeDBObject> rpNodeDBobjList = ((RouteCustomDBObject) this.mRouteCustomObjList.get(index)).getRoutePlanDBNodes();
            if (nodesList.size() == rpNodeDBobjList.size()) {
                boolean bIsNotSame = false;
                for (int i = 0; i < nodesList.size(); i++) {
                    if (!RoutePlanNodeDBObject.compare((RoutePlanNode) nodesList.get(i), (RoutePlanNodeDBObject) rpNodeDBobjList.get(i))) {
                        bIsNotSame = true;
                        break;
                    }
                }
                if (!bIsNotSame) {
                    isSame = true;
                    break;
                }
            }
            index++;
        }
        return isSame ? index : -1;
    }

    public int getExistRouteIndexByHisRouteDBId(int hisRoutDBId) {
        if (this.mRouteCustomObjList == null || this.mRouteCustomObjList.size() == 0) {
            return -1;
        }
        int size = this.mRouteCustomObjList.size();
        for (int position = 0; position < size; position++) {
            if (((RouteCustomDBObject) this.mRouteCustomObjList.get(position)).getHisRouteId() == hisRoutDBId) {
                return position;
            }
        }
        return -1;
    }

    public int getCurRouteIndex(int type, int hisRouteDBId, ArrayList<RoutePlanNode> nodesList) {
        int index;
        if (type != 3) {
            for (index = 0; index < this.mRouteCustomObjList.size(); index++) {
                if (type == ((RouteCustomDBObject) this.mRouteCustomObjList.get(index)).getDestType()) {
                    return index;
                }
            }
            return -1;
        }
        index = getExistRouteIndexByHisRouteDBId(hisRouteDBId);
        if (index >= 0) {
            return index;
        }
        index = getExistRouteIndexByRouteList(nodesList);
        if (index >= 0) {
            RouteCustomDBObject obj = (RouteCustomDBObject) this.mRouteCustomObjList.get(index);
            if (obj != null) {
                obj.setHisRouteId(hisRouteDBId);
                updateRouteCustomInfo(index);
            }
        }
        return index;
    }

    private void checkRouteCustomDestType(RouteCustomDBObject obj) {
        RoutePlanNode destNode = null;
        ArrayList<RoutePlanNodeDBObject> nodeDBObjects = obj.getRoutePlanDBNodes();
        if (nodeDBObjects == null) {
            nodeDBObjects = new ArrayList(0);
            obj.setRoutePlanNodes(nodeDBObjects);
        }
        if (obj.getDestType() == 1) {
            destNode = AddressSettingModel.getHomeAddrNode(this.mContext);
        } else if (obj.getDestType() == 2) {
            destNode = AddressSettingModel.getCompAddrNode(this.mContext);
        }
        if (destNode != null) {
            RoutePlanNodeDBObject destDBNodeObj = new RoutePlanNodeDBObject();
            destDBNodeObj.copy(destNode);
            nodeDBObjects.add(destDBNodeObj);
        }
    }

    public void removeRouteCustomByPos(int position) {
        if (this.mRouteCustomObjList != null) {
            RouteCustomDBObject routeCustomDBObj = null;
            if (position >= 0 && position < this.mRouteCustomObjList.size()) {
                routeCustomDBObj = (RouteCustomDBObject) this.mRouteCustomObjList.get(position);
            }
            if (routeCustomDBObj != null) {
                deleteCustomRoute(routeCustomDBObj.getId());
                this.mRouteCustomObjList.remove(position);
            }
        }
    }

    public void deleteCustomRoute(int id) {
        this.mRouteCustomDBTable.delete(id);
        String[] whereArgs = new String[]{"4", id + ""};
        this.mRoutePlanNodeDBTable.delete("arg1=? and arg2=?", whereArgs);
    }

    public void clear() {
        this.mRouteCustomDBTable.beginTransaction();
        this.mRouteCustomDBTable.deleteAll();
        String[] whereArgs = new String[]{"4"};
        this.mRoutePlanNodeDBTable.delete("arg1=?", whereArgs);
        this.mRouteCustomDBTable.endTransaction();
        this.mRouteCustomObjList.clear();
    }

    public void updateRouteCustomInfo(int position) {
        RouteCustomDBObject routeCustomDBObj = null;
        if (position >= 0 && position < this.mRouteCustomObjList.size()) {
            routeCustomDBObj = (RouteCustomDBObject) this.mRouteCustomObjList.get(position);
        }
        if (routeCustomDBObj != null) {
            routeCustomDBObj.setModifiedTime(System.currentTimeMillis());
            this.mRouteCustomDBTable.beginTransaction();
            this.mRouteCustomDBTable.update(routeCustomDBObj);
            this.mRouteCustomDBTable.endTransaction();
        }
    }

    public void updateRouteCustomInfo(RouteCustomDBObject obj) {
        if (obj != null) {
            obj.setModifiedTime(System.currentTimeMillis());
            this.mRouteCustomDBTable.beginTransaction();
            this.mRouteCustomDBTable.update(obj);
            this.mRouteCustomDBTable.endTransaction();
        }
    }

    public RouteCustomDBObject getRouteCustomInfoById(int id) {
        if (this.mRouteCustomObjList == null) {
            return null;
        }
        Iterator<RouteCustomDBObject> iterator = this.mRouteCustomObjList.iterator();
        while (iterator.hasNext()) {
            RouteCustomDBObject obj = (RouteCustomDBObject) iterator.next();
            if (obj.getId() == id) {
                return obj;
            }
        }
        return null;
    }

    public RouteCustomDBObject getRouteCustomInfoByPos(int position) {
        if (this.mRouteCustomObjList == null) {
            return null;
        }
        if (position < 0 || position >= this.mRouteCustomObjList.size()) {
            return null;
        }
        return (RouteCustomDBObject) this.mRouteCustomObjList.get(position);
    }

    public ArrayList<RoutePlanNode> getRouteNodesListById(int id) {
        RouteCustomDBObject obj = getRouteCustomInfoById(id);
        if (obj == null) {
            return null;
        }
        ArrayList<RoutePlanNode> nodesList = obj.getRoutePlanNodes();
        if (nodesList == null) {
            return nodesList;
        }
        if (obj.getDestType() == 3 && nodesList.size() != 1) {
            return nodesList;
        }
        nodesList.add(0, BNGeoLocateManager.getInstance().getCurLocationNode());
        return nodesList;
    }

    public ArrayList<RoutePlanNode> getRouteNodesListByPos(int position) {
        RouteCustomDBObject obj = getRouteCustomInfoByPos(position);
        if (obj == null) {
            return null;
        }
        ArrayList<RoutePlanNode> nodesList = obj.getRoutePlanNodes();
        if (nodesList == null) {
            return nodesList;
        }
        if (obj.getDestType() == 3 && nodesList.size() != 1) {
            return nodesList;
        }
        nodesList.add(0, BNGeoLocateManager.getInstance().getCurLocationNode());
        return nodesList;
    }

    public Bundle getNodesListBundle(int position) {
        RouteCustomDBObject obj = getRouteCustomInfoByPos(position);
        if (obj == null) {
            return null;
        }
        ArrayList<RoutePlanNode> nodesList = obj.getRoutePlanNodes();
        Bundle bundle = new Bundle();
        if (nodesList != null && (obj.getDestType() != 3 || nodesList.size() == 1)) {
            nodesList.add(0, BNGeoLocateManager.getInstance().getCurLocationNode());
        }
        if (nodesList.size() != 2) {
            return null;
        }
        ArrayList bundleList = new ArrayList();
        bundleList.add(nodesList);
        bundle.putParcelableArrayList("nodesList", bundleList);
        bundle.putInt("type", obj.getId());
        return bundle;
    }
}
