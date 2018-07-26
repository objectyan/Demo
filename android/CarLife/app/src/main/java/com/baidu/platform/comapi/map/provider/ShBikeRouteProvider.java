package com.baidu.platform.comapi.map.provider;

import com.baidu.entity.pb.WalkPlan;
import com.baidu.entity.pb.WalkPlan.Option.Start;
import com.baidu.entity.pb.WalkPlan.Routes.Legs;
import com.baidu.entity.pb.WalkPlan.Routes.Legs.ConnectedPois;
import com.baidu.entity.pb.WalkPlan.Routes.Legs.Steps;
import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.baidu.platform.comapi.basestruct.Point;
import com.baidu.platform.comapi.map.provider.EngineConst.OVERLAY_KEY;
import com.baidu.platform.comapi.search.convert.PBConvertUtil;
import com.baidu.platform.comapi.util.C2911f;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.baidu.platform.comjni.tools.AppTools;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class ShBikeRouteProvider implements RenderProvider {
    public static final int ARR_MAXL = 22;
    public static final int ARR_MINL = 13;
    public static final int BD09MC = 1;
    public static final int END_NODE_STYLE = 18;
    public static final int FOOT_LINE_ARR_FOCUS_STYLE = 175;
    public static final int FOOT_LINE_ARR_NORMAL_STYLE = 171;
    public static final int FOOT_LINE_FOCUS_STYLE = 175;
    public static final int FOOT_LINE_NORMAL_STYLE = 171;
    public static final int GCJ02 = 0;
    public static final int MAXL = 12;
    public static final int MINL = 3;
    public static final int START_NODE_STYLE = 17;
    public static final int STEP_OFFSET = 8;
    public static final int STEP_STYLE = 37;
    private static final String TAG = ShBikeRouteProvider.class.getSimpleName();
    public static final int TEN_THOUSAND = 100000;
    List<Integer> curMc = null;
    public boolean mHasIndoor = false;
    private JsonBuilder mJsonBuilder;
    private int mNodeCount;
    private int mSpathType = 0;
    private WalkPlan mWalkRoute;
    List<Integer> preMc = null;

    public ShBikeRouteProvider(WalkPlan walkRoute) {
        this.mWalkRoute = walkRoute;
        if (walkRoute != null && walkRoute.hasOption() && walkRoute.getOption().hasSpathType()) {
            this.mSpathType = walkRoute.getOption().getSpathType();
        } else {
            this.mSpathType = 0;
        }
    }

    public String getRenderData() {
        resetTemporaryField();
        try {
            Legs legs = mergeLegs();
            this.mJsonBuilder.object().key("dataset").arrayValue();
            addRoutePaths(legs);
            if (!this.mHasIndoor) {
                addRouteStartNode();
            }
            this.mJsonBuilder.endArrayValue().endObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        C2911f.e(TAG, "walk render json:" + this.mJsonBuilder.getJson());
        return this.mJsonBuilder.getJson();
    }

    private void addRouteStartNode() {
        Start startNode = this.mWalkRoute.getOption().getStart();
        if (startNode != null) {
            this.mJsonBuilder.object();
            this.mJsonBuilder.key("ud").value(startNode.hasUid() ? startNode.getUid() : "");
            this.mJsonBuilder.key("ty").value(1);
            this.mJsonBuilder.key("nst").value(17);
            this.mJsonBuilder.key("fst").value(17);
            this.mJsonBuilder.key("tx").value(startNode.hasWd() ? startNode.getWd() : "起点");
            this.mJsonBuilder.key("in").value(getCurrentIndex());
            this.mJsonBuilder.key(OVERLAY_KEY.ALIGN).value(2);
            this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(startNode.getSptList()));
            this.mJsonBuilder.endObject();
        }
    }

    private void resetTemporaryField() {
        this.mJsonBuilder = new JsonBuilder();
        this.mNodeCount = 0;
    }

    private Legs mergeLegs() {
        Legs legs = new Legs();
        if (this.mWalkRoute.getRoutesCount() > 0) {
            for (Legs leg : this.mWalkRoute.getRoutes(0).getLegsList()) {
                List<Steps> stepsList = leg.getStepsList();
                if (stepsList != null) {
                    for (Steps steps : stepsList) {
                        legs.addSteps(steps);
                    }
                }
            }
        }
        return legs;
    }

    private void addRoutePaths(Legs legs) {
        if (!addStartDashRoutes4Indoor()) {
            addStartDashRoutes();
        }
        for (int i = 0; i < legs.getStepsCount(); i++) {
            List<Integer> cur = ((Steps) legs.getStepsList().get(i)).getSpathList();
            if (cur != null) {
                ComplexPt complexPre = null;
                if (this.mSpathType == 0) {
                    complexPre = ComplexPt.createComplexPt(cur).toComplexPtGCJ2MC();
                } else if (this.mSpathType == 1) {
                    complexPre = ComplexPt.createComplexPt(cur);
                }
                this.curMc = complexPre.toIntArray();
            }
            this.mJsonBuilder.object();
            this.mJsonBuilder.key("ty").value(2);
            this.mJsonBuilder.key("in").value(getCurrentIndex());
            addLineArrowStyle(171, 175, 171, 175);
            this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(ProviderUtils.connectPath(this.preMc, this.curMc)));
            this.mJsonBuilder.endObject();
            this.preMc = this.curMc;
        }
        if (!addEndDashRoutes4Indoor()) {
            addEndDashRoutes();
        }
    }

    private Point getFirstRouteLoc() {
        if (this.mWalkRoute == null || this.mWalkRoute.getRoutesCount() <= 0 || this.mWalkRoute.getRoutes(0).getLegsCount() <= 0 || this.mWalkRoute.getRoutes(0).getLegs(0).getStepsCount() <= 0) {
            return null;
        }
        Steps steps = this.mWalkRoute.getRoutes(0).getLegs(0).getSteps(0);
        return new Point((double) ((Integer) steps.getSpathList().get(5)).intValue(), (double) ((Integer) steps.getSpathList().get(6)).intValue());
    }

    private void addStartDashRoutes() {
        Point startPt = getWalkPlanStartPoint(this.mWalkRoute);
        if (startPt != null) {
            int x = startPt.getIntX();
            int y = startPt.getIntY();
            if (x != 0 && y != 0) {
                Point firstRoutePoint = getFirstRouteLoc();
                if (firstRoutePoint != null && AppTools.getDistanceByMc(new Point((double) x, (double) y), firstRoutePoint) >= 2.0d) {
                    List<Integer> cur = new ArrayList();
                    int x1 = firstRoutePoint.getIntX();
                    int y1 = firstRoutePoint.getIntY();
                    cur.add(Integer.valueOf(x));
                    cur.add(Integer.valueOf(y));
                    cur.add(Integer.valueOf(x));
                    cur.add(Integer.valueOf(y));
                    cur.add(Integer.valueOf(2));
                    cur.add(Integer.valueOf(x));
                    cur.add(Integer.valueOf(y));
                    cur.add(Integer.valueOf(x1 - x));
                    cur.add(Integer.valueOf(y1 - y));
                    this.mJsonBuilder.object();
                    this.mJsonBuilder.key("ty").value(2);
                    this.mJsonBuilder.key("in").value(this.mNodeCount);
                    this.mJsonBuilder.key("nst").value(208);
                    this.mJsonBuilder.key("fst").value(208);
                    this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(cur));
                    this.mJsonBuilder.endObject();
                }
            }
        }
    }

    private boolean addStartDashRoutes4Indoor() {
        List<Integer> loclist = getDoorLoc(1);
        if (loclist == null) {
            return false;
        }
        int x = ((Integer) loclist.get(0)).intValue();
        int y = ((Integer) loclist.get(1)).intValue();
        if (x == 0 || y == 0) {
            return false;
        }
        Point firstRoutePoint = getFirstRouteLoc();
        if (firstRoutePoint == null) {
            return false;
        }
        if (AppTools.getDistanceByMc(new Point((double) x, (double) y), firstRoutePoint) < 2.0d) {
            return false;
        }
        List<Integer> cur = new ArrayList();
        int x1 = firstRoutePoint.getIntX();
        int y1 = firstRoutePoint.getIntY();
        cur.add(Integer.valueOf(x));
        cur.add(Integer.valueOf(y));
        cur.add(Integer.valueOf(x));
        cur.add(Integer.valueOf(y));
        cur.add(Integer.valueOf(2));
        cur.add(Integer.valueOf(x));
        cur.add(Integer.valueOf(y));
        cur.add(Integer.valueOf(x1 - x));
        cur.add(Integer.valueOf(y1 - y));
        this.curMc = cur;
        this.mJsonBuilder.object();
        this.mJsonBuilder.key("ty").value(2);
        this.mJsonBuilder.key("in").value(this.mNodeCount);
        this.mJsonBuilder.key("nst").value(208);
        this.mJsonBuilder.key("fst").value(208);
        this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(this.curMc));
        this.mJsonBuilder.endObject();
        return true;
    }

    public static List<ConnectedPois> getConnectedPoisList(WalkPlan walkPlan) {
        List<ConnectedPois> list = new ArrayList();
        if (walkPlan.getRoutesCount() > 0) {
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

    private void addEndDashRoutes() {
        C2911f.e("tag", "addEndDashRoutes");
        Point endPt = getWalkPlanEndPoint(this.mWalkRoute);
        if (endPt != null) {
            int x = endPt.getIntX();
            int y = endPt.getIntY();
            if (x != 0 && y != 0) {
                ComplexPt preComplexPt = ComplexPt.createComplexPt(this.preMc);
                if (preComplexPt != null && !preComplexPt.isEmpty()) {
                    ArrayList<Point> lastPart = (ArrayList) preComplexPt.mGeoPt.get(preComplexPt.mGeoPt.size() - 1);
                    if (AppTools.getDistanceByMc((Point) lastPart.get(lastPart.size() - 1), new Point((double) x, (double) y)) >= 2.0d) {
                        List<Integer> cur = new ArrayList();
                        cur.add(Integer.valueOf(x));
                        cur.add(Integer.valueOf(y));
                        cur.add(Integer.valueOf(x));
                        cur.add(Integer.valueOf(y));
                        cur.add(Integer.valueOf(2));
                        cur.add(Integer.valueOf(x));
                        cur.add(Integer.valueOf(y));
                        this.curMc = cur;
                        this.mJsonBuilder.object();
                        this.mJsonBuilder.key("ty").value(2);
                        this.mJsonBuilder.key("in").value(this.mNodeCount);
                        this.mJsonBuilder.key("nst").value(208);
                        this.mJsonBuilder.key("fst").value(208);
                        this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(ProviderUtils.connectPath(this.preMc, this.curMc)));
                        this.mJsonBuilder.endObject();
                    }
                }
            }
        }
    }

    public List<Integer> getDoorLoc(int type) {
        List<Integer> locList = null;
        List<ConnectedPois> connectedPoisList = getConnectedPoisList(this.mWalkRoute);
        if (!(connectedPoisList == null || connectedPoisList.size() == 0)) {
            int i = 0;
            while (i < connectedPoisList.size()) {
                if (((ConnectedPois) connectedPoisList.get(i)).getType() == 1 && ((ConnectedPois) connectedPoisList.get(i)).getTypeDir() == type) {
                    locList = ((ConnectedPois) connectedPoisList.get(i)).getLocationList();
                }
                i++;
            }
        }
        return locList;
    }

    private boolean addEndDashRoutes4Indoor() {
        C2911f.e("tag", "addEndDashRoutes4Indoor");
        List<Integer> loclist = getDoorLoc(2);
        if (loclist == null) {
            return false;
        }
        int x = ((Integer) loclist.get(0)).intValue();
        int y = ((Integer) loclist.get(1)).intValue();
        if (x == 0 || y == 0) {
            return false;
        }
        ComplexPt preComplexPt = ComplexPt.createComplexPt(this.preMc);
        if (preComplexPt == null || preComplexPt.isEmpty()) {
            return false;
        }
        ArrayList<Point> lastPart = (ArrayList) preComplexPt.mGeoPt.get(preComplexPt.mGeoPt.size() - 1);
        if (AppTools.getDistanceByMc((Point) lastPart.get(lastPart.size() - 1), new Point((double) x, (double) y)) < 2.0d) {
            return false;
        }
        List<Integer> cur = new ArrayList();
        cur.add(Integer.valueOf(x));
        cur.add(Integer.valueOf(y));
        cur.add(Integer.valueOf(x));
        cur.add(Integer.valueOf(y));
        cur.add(Integer.valueOf(2));
        cur.add(Integer.valueOf(x));
        cur.add(Integer.valueOf(y));
        this.curMc = cur;
        this.mJsonBuilder.object();
        this.mJsonBuilder.key("ty").value(2);
        this.mJsonBuilder.key("in").value(this.mNodeCount);
        this.mJsonBuilder.key("nst").value(208);
        this.mJsonBuilder.key("fst").value(208);
        this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(ProviderUtils.connectPath(this.preMc, this.curMc)));
        this.mJsonBuilder.endObject();
        return true;
    }

    private void addLineArrowStyle(int normalStyle, int focusStyle, int arrNormalStyle, int arrFocusStyle) {
        try {
            JsonBuilder builder = new JsonBuilder();
            builder.arrayValue();
            JSONObject difflevelShowArrowObj = new JSONObject();
            difflevelShowArrowObj.put("maxl", 22);
            difflevelShowArrowObj.put("minl", 13);
            difflevelShowArrowObj.put("fst", arrFocusStyle);
            difflevelShowArrowObj.put("nst", arrNormalStyle);
            builder.objectValue(difflevelShowArrowObj.toString());
            JSONObject difflevelNoArrowObj = new JSONObject();
            difflevelNoArrowObj.put("maxl", 12);
            difflevelNoArrowObj.put("minl", 3);
            difflevelNoArrowObj.put("fst", focusStyle);
            difflevelNoArrowObj.put("nst", normalStyle);
            builder.objectValue(difflevelNoArrowObj.toString());
            builder.endArrayValue();
            this.mJsonBuilder.key(OVERLAY_KEY.SGEO_DIFF_LEVEL).objectValue(builder.getJson());
        } catch (Exception e) {
        }
    }

    public Point getWalkPlanStartPoint(WalkPlan walkPlan) {
        Point startGeoPT = new Point(0.0d, 0.0d);
        if (walkPlan != null && walkPlan.hasOption() && walkPlan.getOption().hasStart()) {
            return PBConvertUtil.decryptPointFromArray(walkPlan.getOption().getStart().getSptList());
        }
        return startGeoPT;
    }

    public Point getWalkPlanEndPoint(WalkPlan walkPlan) {
        Point endGeoPT = new Point(0.0d, 0.0d);
        if (walkPlan == null || !walkPlan.hasOption() || walkPlan.getOption().getEndCount() <= 0 || walkPlan.getOption().getEnd(walkPlan.getOption().getEndCount() - 1) == null) {
            return endGeoPT;
        }
        return PBConvertUtil.decryptPointFromArray(walkPlan.getOption().getEnd(walkPlan.getOption().getEndCount() - 1).getSptList());
    }

    private int getCurrentIndex() {
        int i = this.mNodeCount;
        this.mNodeCount = i + 1;
        return i;
    }
}
