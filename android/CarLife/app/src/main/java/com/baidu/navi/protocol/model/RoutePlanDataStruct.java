package com.baidu.navi.protocol.model;

import java.util.ArrayList;
import java.util.List;

public class RoutePlanDataStruct extends DataStruct {
    public static final int CAL_MODE_DEFAULT = 1;
    public static final int CAL_MODE_LESS_DISTANCE = 2;
    public static final int CAL_MODE_LESS_TIME = 3;
    public static final String KEY_ADD_HISTORY = "addHistory";
    public static final String KEY_CALMODE = "calMode";
    public static final String KEY_END = "end";
    public static final String KEY_START = "start";
    public static final String KEY_VIA = "via";
    public static final String KEY_X = "X";
    public static final String KEY_Y = "Y";
    public boolean addHistory;
    public int calMode;
    public GeoPointInfo endPoint;
    public List<GeoPointInfo> mViaPoints;
    public GeoPointInfo startPoint;

    public interface ResultKey {
        public static final String DISTANCE = "distance";
        public static final String TOTAL_TIME = "totalTime";
    }

    public RoutePlanDataStruct() {
        this.mCmd = "route";
    }

    public void setStartPoint(int x, int y, String name) {
        this.startPoint = new GeoPointInfo(x, y, name);
    }

    public void setEndPoint(int x, int y, String name) {
        this.endPoint = new GeoPointInfo(x, y, name);
    }

    public void addViaPoint(int x, int y, String name) {
        if (this.mViaPoints == null) {
            this.mViaPoints = new ArrayList();
        }
        this.mViaPoints.add(new GeoPointInfo(x, y, name));
    }

    public void setViaPoints(List<GeoPointInfo> viaPoints) {
        if (viaPoints != null && viaPoints.size() > 0) {
            if (this.mViaPoints == null) {
                this.mViaPoints = new ArrayList();
            }
            this.mViaPoints.clear();
            this.mViaPoints.addAll(viaPoints);
        }
    }

    public String toString() {
        String strStartPoint = "";
        String strEndPoint = "";
        String strViaPoint = "";
        if (this.startPoint != null) {
            strStartPoint = this.startPoint.toString();
        }
        if (this.endPoint != null) {
            strEndPoint = this.endPoint.toString();
        }
        if (this.mViaPoints != null) {
            strViaPoint = GeoPointInfo.listToString(this.mViaPoints);
        }
        return "cmd=" + this.mCmd + " startPoint=" + strStartPoint + " endPoint=" + strEndPoint + " via=" + strViaPoint + " calMode=" + this.calMode + " addHistory=" + this.addHistory;
    }
}
