package com.baidu.navisdk.util.db.object;

import android.text.format.DateFormat;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import java.util.ArrayList;
import java.util.List;

public class NaviRouteDBObject implements BaseDBObject {
    private int mId;
    private ArrayList<RoutePlanNodeDBObject> mRoutePlanNodes;
    private long mTime;

    public NaviRouteDBObject(ArrayList<RoutePlanNodeDBObject> nodes, long time) {
        this.mRoutePlanNodes = nodes;
        this.mTime = time;
    }

    public int getId() {
        return this.mId;
    }

    public void setId(int id) {
        this.mId = id;
    }

    public void setTime(long time) {
        this.mTime = time;
    }

    public CharSequence getTimeAsStr() {
        return DateFormat.format("yyyy-MM-dd kk:mm", this.mTime);
    }

    public long getTime() {
        return this.mTime;
    }

    public void setRoutePlanNodes(ArrayList<RoutePlanNodeDBObject> nodes) {
        this.mRoutePlanNodes = nodes;
    }

    public ArrayList<RoutePlanNodeDBObject> getRoutePlanDBNodes() {
        return this.mRoutePlanNodes;
    }

    public ArrayList<RoutePlanNode> getRoutePlanNodes() {
        return RoutePlanNodeDBObject.convertToRoutePlanNodeList(this.mRoutePlanNodes);
    }

    public boolean compareRoute(List<RoutePlanNode> otherNodes) {
        if (this.mRoutePlanNodes == null || otherNodes == null || this.mRoutePlanNodes.size() != otherNodes.size()) {
            return false;
        }
        for (int i = 0; i < this.mRoutePlanNodes.size(); i++) {
            RoutePlanNode node = (RoutePlanNode) this.mRoutePlanNodes.get(i);
            RoutePlanNodeDBObject otherNode = (RoutePlanNodeDBObject) this.mRoutePlanNodes.get(i);
            if (node.getLatitudeE6() != otherNode.getLatitudeE6()) {
                return false;
            }
            if (node.getLongitudeE6() != otherNode.getLongitudeE6()) {
                return false;
            }
        }
        return true;
    }
}
