package com.baidu.platform.comapi.map.provider;

import android.text.TextUtils;
import com.baidu.entity.pb.IndoorNavi.Routes.Legs.Steps;
import com.baidu.entity.pb.WalkPlan;
import com.baidu.entity.pb.WalkPlan.Routes.Legs;
import com.baidu.entity.pb.WalkPlan.Routes.Legs.ConnectedPois;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.provider.EngineConst.OVERLAY_KEY;
import com.baidu.platform.comapi.search.convert.PBConvertUtil;
import com.baidu.platform.comapi.util.C2911f;
import com.baidu.platform.comapi.util.JsonBuilder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class WalkIndoorRouteProvider implements RenderProvider {
    public static final int ARR_MAXL = 22;
    public static final int ARR_MINL = 13;
    public static final int MAXL = 12;
    public static final int MINL = 3;
    private static final String TAG = WalkIndoorRouteProvider.class.getSimpleName();
    private JsonBuilder builder;
    private String mBuildingId = "";
    boolean mDashMode = false;
    private WalkPlan mWalkRoute;
    private int nodeIndex;
    private List<Steps> stepsList = new LinkedList();

    class DoorInfo {
        public int type;
        /* renamed from: x */
        public int f19865x;
        /* renamed from: y */
        public int f19866y;

        DoorInfo() {
        }
    }

    public WalkIndoorRouteProvider(Steps step) {
        this.stepsList.add(step);
        this.mDashMode = false;
    }

    public WalkIndoorRouteProvider(WalkPlan walkPlan, String buildingId) {
        this.mWalkRoute = walkPlan;
        this.mDashMode = true;
        this.mBuildingId = buildingId;
    }

    public synchronized String getRenderData() {
        this.nodeIndex = 0;
        this.builder = new JsonBuilder();
        this.builder.object().key("dataset").arrayValue();
        this.builder.object();
        this.builder.key(OVERLAY_KEY.INDOOR).value(true);
        this.builder.endObject();
        renderSteps();
        this.builder.endArrayValue().endObject();
        C2911f.e(TAG, "indoor render json:" + this.builder.getJson());
        return this.builder.getJson();
    }

    private void renderSteps() {
        if (this.mDashMode) {
            addDashRoutes();
            return;
        }
        for (Steps step : this.stepsList) {
            this.builder.object();
            this.builder.key("ty").value(2);
            JsonBuilder key = this.builder.key("in");
            int i = this.nodeIndex;
            this.nodeIndex = i + 1;
            key.value(i);
            this.builder.key("nst").value(198);
            this.builder.key("fst").value(198);
            this.builder.key("path").objectValue(ProviderUtils.pathToJson(step.getSpathList()));
            this.builder.endObject();
        }
    }

    private void addDashRoutes() {
        List<DoorInfo> doorInfoList = getDoorLoc();
        if (doorInfoList != null && doorInfoList.size() != 0) {
            for (int i = 0; i < doorInfoList.size(); i++) {
                int doorX = ((DoorInfo) doorInfoList.get(i)).f19865x;
                int doorY = ((DoorInfo) doorInfoList.get(i)).f19866y;
                int type = ((DoorInfo) doorInfoList.get(i)).type;
                if (type == 2) {
                    drawDashLine(new Point((double) doorX, (double) doorY), getDestLoc());
                } else if (type == 1) {
                    drawDashLine(getStartLoc(), new Point((double) doorX, (double) doorY));
                }
            }
        }
    }

    private void drawDashLine(Point startPt, Point endPt) {
        C2911f.e("tag", "drawDashLine:start:" + startPt.toString() + "end:" + endPt.toString());
        List<Integer> cur = new ArrayList();
        int startX = startPt.getIntX();
        int startY = startPt.getIntY();
        int endX = endPt.getIntX();
        int endY = endPt.getIntY();
        cur.add(Integer.valueOf(startX));
        cur.add(Integer.valueOf(startY));
        cur.add(Integer.valueOf(startX));
        cur.add(Integer.valueOf(startY));
        cur.add(Integer.valueOf(2));
        cur.add(Integer.valueOf(startX));
        cur.add(Integer.valueOf(startY));
        cur.add(Integer.valueOf(endX - startX));
        cur.add(Integer.valueOf(endY - startY));
        this.builder.object();
        this.builder.key("ty").value(2);
        this.builder.key("in").value(0);
        this.builder.key("nst").value(208);
        this.builder.key("fst").value(208);
        this.builder.key("path").objectValue(ProviderUtils.pathToJson(cur));
        this.builder.endObject();
    }

    public List<DoorInfo> getDoorLoc() {
        List<DoorInfo> locList = new ArrayList();
        List<ConnectedPois> connectedPoisList = getConnectedPoisList(this.mWalkRoute);
        if (!(connectedPoisList == null || connectedPoisList.size() == 0)) {
            int i = 0;
            while (i < connectedPoisList.size()) {
                if (((ConnectedPois) connectedPoisList.get(i)).getType() == 1 && TextUtils.equals(this.mBuildingId, ((ConnectedPois) connectedPoisList.get(i)).getBuilding())) {
                    DoorInfo info = new DoorInfo();
                    info.f19865x = ((Integer) ((ConnectedPois) connectedPoisList.get(i)).getLocationList().get(0)).intValue();
                    info.f19866y = ((Integer) ((ConnectedPois) connectedPoisList.get(i)).getLocationList().get(1)).intValue();
                    info.type = ((ConnectedPois) connectedPoisList.get(i)).getTypeDir();
                    locList.add(info);
                }
                i++;
            }
        }
        return locList;
    }

    public Point getStartLoc() {
        Point startGeoPT = new Point(0.0d, 0.0d);
        if (this.mWalkRoute != null && this.mWalkRoute.hasOption() && this.mWalkRoute.getOption().hasStart()) {
            return PBConvertUtil.decryptPointFromArray(this.mWalkRoute.getOption().getStart().getSptList());
        }
        return startGeoPT;
    }

    public Point getDestLoc() {
        Point endGeoPT = new Point(0.0d, 0.0d);
        if (this.mWalkRoute == null || !this.mWalkRoute.hasOption() || this.mWalkRoute.getOption().getEndCount() <= 0 || this.mWalkRoute.getOption().getEnd(this.mWalkRoute.getOption().getEndCount() - 1) == null) {
            return endGeoPT;
        }
        return PBConvertUtil.decryptPointFromArray(this.mWalkRoute.getOption().getEnd(this.mWalkRoute.getOption().getEndCount() - 1).getSptList());
    }

    public static List<ConnectedPois> getConnectedPoisList(WalkPlan walkPlan) {
        List<ConnectedPois> list = new ArrayList();
        if (walkPlan != null && walkPlan.getRoutesCount() > 0) {
            for (Legs leg : walkPlan.getRoutes(0).getLegsList()) {
                List<ConnectedPois> connectedList = leg.getConnectedPoisList();
                if (connectedList != null) {
                    for (ConnectedPois connectedPois : connectedList) {
                        list.add(connectedPois);
                    }
                }
            }
        }
        return list;
    }
}
