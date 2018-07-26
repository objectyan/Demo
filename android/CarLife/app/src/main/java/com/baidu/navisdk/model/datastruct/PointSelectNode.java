package com.baidu.navisdk.model.datastruct;

import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

public class PointSelectNode extends RoutePlanNode {
    private static final long serialVersionUID = 5728445424643930964L;
    public String mPointDescription;
    int mPointIndex = -1;

    public PointSelectNode(int pointIndex, RoutePlanNode node) {
        this.mPointIndex = pointIndex;
        setRoutePlanNode(node);
    }

    public PointSelectNode(RoutePlanNode node) {
        setRoutePlanNode(node);
    }

    public String getPointDescription() {
        return this.mPointDescription;
    }

    public void setPointDescription(String mPointDescription) {
        this.mPointDescription = mPointDescription;
    }

    public int getPointIndex() {
        return this.mPointIndex;
    }

    public void setPointIndex(int mPointIndex) {
        this.mPointIndex = mPointIndex;
    }

    public RoutePlanNode getRoutePlanNode() {
        RoutePlanNode node = new RoutePlanNode(this.mGeoPoint, this.mViewPoint, this.mFrom, this.mName, this.mDescription, this.mUID);
        node.setSubPosList(getSubPosList());
        return node;
    }

    public void setRoutePlanNode(RoutePlanNode node) {
        copy(node);
    }

    public void setRoutePlanNode(GeoPoint mGeoPoint) {
        setGeoPoint(mGeoPoint);
    }

    public void setRoutePlanNode(int latitude, int longitude, int from, String name, String description) {
        setRoutePlanNode(new GeoPoint(longitude, latitude), from, name, description);
    }

    public void setRoutePlanNode(GeoPoint geoPoint, int from, String name, String description) {
        setGeoPoint(geoPoint);
        setFrom(from);
        setName(name);
        setDescription(description);
    }

    public void setRoutePlanNode(GeoPoint geoPoint, GeoPoint viewPoint, int from, String name, String description) {
        setGeoPoint(geoPoint);
        setFrom(from);
        setName(name);
        setDescription(description);
        setViewPoint(viewPoint);
    }

    public void setRoutePlanNode(GeoPoint geoPoint, GeoPoint viewPoint, int from, String name, String description, String uid) {
        setGeoPoint(geoPoint);
        setFrom(from);
        setName(name);
        setDescription(description);
        setViewPoint(viewPoint);
        setUID(uid);
    }

    public void setRoutePlanNode(SearchPoi node) {
        setRoutePlanNode(node.mGuidePoint, node.mViewPoint, 8, node.mName, node.mAddress, node.mOriginUID);
    }

    public void setRoutePlanNode(int index, SearchPoi node) {
        setRoutePlanNode(node.mGuidePoint, node.mViewPoint, 8, node.mName, node.mAddress, node.mOriginUID);
        setPointIndex(index);
    }

    public void setRoutePlanNode(int index, SearchPoi node, ArrayList<SearchPoi> list) {
        setRoutePlanNode(node.mGuidePoint, node.mViewPoint, 8, node.mName, node.mAddress, node.mOriginUID);
        ArrayList<GeoPoint> subPosList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                subPosList.add(((SearchPoi) list.get(i)).mGuidePoint);
            }
            setSubPosList(subPosList);
        }
        setPointIndex(index);
    }

    public void setRoutePlanNode(SearchPoi node, ArrayList<SearchPoi> list) {
        setRoutePlanNode(node.mGuidePoint, node.mViewPoint, 8, node.mName, node.mAddress, node.mOriginUID);
        ArrayList<GeoPoint> subPosList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (int index = 0; index < list.size(); index++) {
                subPosList.add(((SearchPoi) list.get(index)).mGuidePoint);
            }
            setSubPosList(subPosList);
        }
    }

    public void clearSelectNode() {
        this.mPointIndex = -1;
        this.mName = "";
        this.mDescription = "";
        this.mGeoPoint = new GeoPoint();
        this.mFrom = 0;
        this.mViewPoint = null;
        clearSubPoiList();
    }
}
