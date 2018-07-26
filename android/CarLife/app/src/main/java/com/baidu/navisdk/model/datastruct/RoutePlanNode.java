package com.baidu.navisdk.model.datastruct;

import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class RoutePlanNode implements Serializable {
    public static final int FROM_COMPANY = 5;
    public static final int FROM_FAVORITE = 6;
    public static final int FROM_HOME = 4;
    public static final int FROM_MAP_KEYWORD = 2;
    public static final int FROM_MAP_POINT = 1;
    public static final int FROM_MY_POSITION = 3;
    public static final int FROM_NAVI_NEARBY_SEARCH = 7;
    public static final int FROM_POI = 8;
    public static final int FROM_UNKNOWN = 0;
    public static final int SUB_TYPE_KEYWORD = 2;
    public static final int SUB_TYPE_MYLOC = 3;
    public static final int SUB_TYPE_POS = 1;
    public static final int SUB_TYPE_SUG = 4;
    public static final int SUB_TYPE_UID = 0;
    private static final long serialVersionUID = -1928773235463634709L;
    public float mAltitude;
    public long mBottom;
    public int mBusinessPoi;
    public String mDescription;
    public int mDistrictID;
    public int mFrom;
    public float mGPSAccuracy;
    public float mGPSAngle;
    public float mGPSSpeed;
    public transient GeoPoint mGeoPoint;
    public long mLeft;
    public float mLevel;
    public int mLocType;
    public String mName;
    public int mNodeType;
    public long mRight;
    public float mSensorAngle;
    protected ArrayList<GeoPoint> mSubPosList;
    public long mTop;
    public String mUID;
    public transient GeoPoint mViewPoint;

    public String getDescription() {
        return this.mDescription;
    }

    public float getAltitude() {
        return this.mAltitude;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public String getUID() {
        return this.mUID;
    }

    public void setUID(String uid) {
        this.mUID = uid;
    }

    public void setNodeType(int nodeType) {
        this.mNodeType = nodeType;
    }

    public int getNodeType() {
        return this.mNodeType;
    }

    public void setDistrictID(int id) {
        this.mDistrictID = id;
    }

    public int getDistrictID() {
        return this.mDistrictID;
    }

    public GeoPoint getGeoPoint() {
        return new GeoPoint(this.mGeoPoint);
    }

    public void setGeoPoint(GeoPoint geoPoint) {
        this.mGeoPoint = new GeoPoint(geoPoint);
    }

    public GeoPoint getViewPoint() {
        if (this.mViewPoint != null) {
            return new GeoPoint(this.mViewPoint);
        }
        return new GeoPoint(this.mGeoPoint);
    }

    public int getViewtLatitudeE6() {
        GeoPoint geoPos;
        if (this.mViewPoint != null) {
            geoPos = this.mViewPoint;
        } else {
            geoPos = this.mGeoPoint;
        }
        return geoPos.getLatitudeE6();
    }

    public int getViewtLongitudeE6() {
        GeoPoint geoPos;
        if (this.mViewPoint != null) {
            geoPos = this.mViewPoint;
        } else {
            geoPos = this.mGeoPoint;
        }
        return geoPos.getLongitudeE6();
    }

    public void setViewPoint(GeoPoint geoPoint) {
        this.mViewPoint = new GeoPoint(geoPoint);
    }

    public RoutePlanNode() {
        this.mUID = null;
        this.mDistrictID = 0;
        this.mLevel = -1.0f;
        this.mTop = -1;
        this.mRight = -1;
        this.mBottom = -1;
        this.mLeft = -1;
        this.mGPSAngle = -2.0f;
        this.mGPSAccuracy = -2.0f;
        this.mGPSSpeed = -2.0f;
        this.mNodeType = -1;
        this.mAltitude = -1.0f;
        this.mBusinessPoi = -1;
        this.mSensorAngle = -1.0f;
        this.mLocType = -1;
        this.mName = "";
        this.mDescription = "";
        this.mGeoPoint = new GeoPoint();
        this.mFrom = 0;
    }

    public RoutePlanNode(RoutePlanNode node) {
        this();
        copy(node);
    }

    public RoutePlanNode(int latitude, int longitude, int from, String name, String description) {
        this(latitude, longitude, from, name, description, null);
    }

    public RoutePlanNode(int latitude, int longitude, int from, String name, String description, String uid) {
        this.mUID = null;
        this.mDistrictID = 0;
        this.mLevel = -1.0f;
        this.mTop = -1;
        this.mRight = -1;
        this.mBottom = -1;
        this.mLeft = -1;
        this.mGPSAngle = -2.0f;
        this.mGPSAccuracy = -2.0f;
        this.mGPSSpeed = -2.0f;
        this.mNodeType = -1;
        this.mAltitude = -1.0f;
        this.mBusinessPoi = -1;
        this.mSensorAngle = -1.0f;
        this.mLocType = -1;
        if (longitude < 0 || latitude < 0) {
            this.mGeoPoint = new GeoPoint();
        } else {
            this.mGeoPoint = new GeoPoint(longitude, latitude);
        }
        if (from == 3 || from == 4 || from == 5 || from == 1 || from == 8 || from == 6 || from == 7) {
            this.mFrom = from;
        } else {
            this.mFrom = 0;
        }
        if (name == null) {
            this.mName = "";
        } else {
            this.mName = new String(name);
        }
        if (description == null) {
            this.mDescription = "";
        } else {
            this.mDescription = new String(description);
        }
        this.mUID = uid;
    }

    public RoutePlanNode(GeoPoint geoPoint, int from, String name, String description) {
        this(geoPoint, from, name, description, null);
    }

    public RoutePlanNode(GeoPoint geoPoint, int from, String name, String description, String uid) {
        this.mUID = null;
        this.mDistrictID = 0;
        this.mLevel = -1.0f;
        this.mTop = -1;
        this.mRight = -1;
        this.mBottom = -1;
        this.mLeft = -1;
        this.mGPSAngle = -2.0f;
        this.mGPSAccuracy = -2.0f;
        this.mGPSSpeed = -2.0f;
        this.mNodeType = -1;
        this.mAltitude = -1.0f;
        this.mBusinessPoi = -1;
        this.mSensorAngle = -1.0f;
        this.mLocType = -1;
        if (geoPoint == null) {
            this.mGeoPoint = new GeoPoint();
        } else {
            this.mGeoPoint = new GeoPoint(geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6());
        }
        if (from == 3 || from == 4 || from == 5 || from == 1 || from == 8 || from == 6 || from == 7) {
            this.mFrom = from;
        } else {
            this.mFrom = 0;
        }
        if (name == null) {
            this.mName = "";
        } else {
            this.mName = new String(name);
        }
        if (description == null) {
            this.mDescription = "";
        } else {
            this.mDescription = new String(description);
        }
        this.mUID = uid;
    }

    public RoutePlanNode(GeoPoint geoPoint, GeoPoint viewPoint, int from, String name, String description) {
        this(geoPoint, viewPoint, from, name, description, null);
    }

    public RoutePlanNode(GeoPoint geoPoint, GeoPoint viewPoint, int from, String name, String description, String uid) {
        this.mUID = null;
        this.mDistrictID = 0;
        this.mLevel = -1.0f;
        this.mTop = -1;
        this.mRight = -1;
        this.mBottom = -1;
        this.mLeft = -1;
        this.mGPSAngle = -2.0f;
        this.mGPSAccuracy = -2.0f;
        this.mGPSSpeed = -2.0f;
        this.mNodeType = -1;
        this.mAltitude = -1.0f;
        this.mBusinessPoi = -1;
        this.mSensorAngle = -1.0f;
        this.mLocType = -1;
        if (geoPoint == null) {
            this.mGeoPoint = new GeoPoint();
        } else {
            this.mGeoPoint = new GeoPoint(geoPoint.getLongitudeE6(), geoPoint.getLatitudeE6());
        }
        if (viewPoint != null) {
            this.mViewPoint = new GeoPoint(viewPoint);
        }
        if (from == 3 || from == 4 || from == 5 || from == 1 || from == 8 || from == 6 || from == 7) {
            this.mFrom = from;
        } else {
            this.mFrom = 0;
        }
        if (name == null) {
            this.mName = "";
        } else {
            this.mName = new String(name);
        }
        if (description == null) {
            this.mDescription = "";
        } else {
            this.mDescription = new String(description);
        }
        this.mUID = uid;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public void copy(RoutePlanNode node) {
        if (node != null) {
            if (node.mName != null) {
                this.mName = new String(node.mName);
            } else {
                this.mName = "";
            }
            if (node.mUID != null) {
                this.mUID = new String(node.mUID);
            } else {
                this.mUID = null;
            }
            if (node.mDescription != null) {
                this.mDescription = new String(node.mDescription);
            } else {
                this.mDescription = "";
            }
            this.mGeoPoint.setLongitudeE6(node.mGeoPoint.getLongitudeE6());
            this.mGeoPoint.setLatitudeE6(node.mGeoPoint.getLatitudeE6());
            this.mViewPoint = node.mViewPoint;
            this.mFrom = node.mFrom;
            setSubPosList(node.mSubPosList);
        }
    }

    public boolean isNodeSettedData() {
        if (this.mGeoPoint.getLatitudeE6() == Integer.MIN_VALUE || this.mGeoPoint.getLongitudeE6() == Integer.MIN_VALUE) {
            return false;
        }
        return true;
    }

    public boolean isNodeIntegrated() {
        if (this.mGeoPoint.getLatitudeE6() == Integer.MIN_VALUE || this.mGeoPoint.getLongitudeE6() == Integer.MIN_VALUE || ("".equals(this.mName) && "".equals(this.mDescription))) {
            return false;
        }
        return true;
    }

    public int getLatitudeE6() {
        return this.mGeoPoint.getLatitudeE6();
    }

    public int getLongitudeE6() {
        return this.mGeoPoint.getLongitudeE6();
    }

    public String getName() {
        return this.mName;
    }

    public int getFrom() {
        return this.mFrom;
    }

    public void setFrom(int from) {
        this.mFrom = from;
    }

    public String toString() {
        String str = new String();
        if (this.mViewPoint != null) {
            str = "{Name:" + this.mName + " From:" + this.mFrom + " Loc:" + this.mGeoPoint.toString() + " ViewPos:" + this.mViewPoint.toString();
        } else {
            str = "{Name:" + this.mName + " From:" + this.mFrom + " Loc:" + this.mGeoPoint.toString();
        }
        if (this.mSubPosList != null && this.mSubPosList.size() > 0) {
            StringBuffer sb = new StringBuffer();
            sb.append(" SubPosList:");
            Iterator it = this.mSubPosList.iterator();
            while (it.hasNext()) {
                sb.append(((GeoPoint) it.next()).toString());
            }
            str = str + sb.toString();
        }
        return str + "}";
    }

    public void setSubPosList(ArrayList<GeoPoint> subPosList) {
        if (subPosList != null) {
            if (this.mSubPosList == null) {
                this.mSubPosList = new ArrayList();
            }
            if (this.mSubPosList != null) {
                this.mSubPosList.clear();
                Iterator it = subPosList.iterator();
                while (it.hasNext()) {
                    this.mSubPosList.add((GeoPoint) it.next());
                }
                return;
            }
            return;
        }
        clearSubPoiList();
    }

    public ArrayList<GeoPoint> getSubPosList() {
        if (this.mSubPosList != null) {
            return (ArrayList) this.mSubPosList.clone();
        }
        return null;
    }

    public void clearSubPoiList() {
        if (this.mSubPosList != null) {
            this.mSubPosList.clear();
        }
        this.mSubPosList = null;
    }
}
