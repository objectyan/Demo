package com.baidu.platform.comapi.map.provider;

import com.baidu.entity.pb.WalkPlan;
import com.baidu.entity.pb.WalkPlan.Routes.Legs;
import com.baidu.entity.pb.WalkPlan.Routes.Legs.Steps;
import com.baidu.platform.comapi.basestruct.ComplexPt;
import com.baidu.platform.comapi.map.provider.EngineConst.OVERLAY_KEY;
import com.baidu.platform.comapi.util.C2911f;
import com.baidu.platform.comapi.util.JsonBuilder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class RouteBookRouteProvider implements RenderProvider {
    public static final int ARR_MAXL = 22;
    public static final int ARR_MINL = 13;
    public static final int BD09MC = 1;
    public static final int END_NODE_STYLE = 18;
    public static final int FOOT_LINE_ARR_FOCUS_STYLE = 157;
    public static final int FOOT_LINE_ARR_NORMAL_STYLE = 156;
    public static final int FOOT_LINE_FOCUS_STYLE = 124;
    public static final int FOOT_LINE_NORMAL_STYLE = 123;
    public static final int GCJ02 = 0;
    public static final int MAXL = 12;
    public static final int MINL = 3;
    public static final int START_NODE_STYLE = 17;
    public static final int STEP_OFFSET = 8;
    public static final int STEP_STYLE = 37;
    private static final String TAG = RouteBookRouteProvider.class.getSimpleName();
    private static ArrayList<WalkPlan> mWalkPlanList;
    private static Legs routeBookLegs;
    List<Integer> curMc = null;
    private JsonBuilder mJsonBuilder;
    private int mNodeCount;
    private int mSpathType = 0;
    List<Integer> preMc = null;

    public RouteBookRouteProvider(ArrayList<WalkPlan> walkPlanList) {
        WalkPlan walkPlan = null;
        mWalkPlanList = walkPlanList;
        if (!(mWalkPlanList == null || mWalkPlanList.size() == 0)) {
            walkPlan = (WalkPlan) mWalkPlanList.get(0);
        }
        if (walkPlan != null && walkPlan.hasOption() && walkPlan.getOption().hasSpathType()) {
            this.mSpathType = walkPlan.getOption().getSpathType();
        } else {
            this.mSpathType = 0;
        }
    }

    public String getRenderData() {
        resetTemporaryField();
        try {
            Legs legs = mergeRouteBookLegs();
            this.mJsonBuilder.object().key("dataset").arrayValue();
            addRoutePaths(legs);
            this.mJsonBuilder.endArrayValue().endObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        C2911f.e(TAG, "walk render json:" + this.mJsonBuilder.getJson());
        return this.mJsonBuilder.getJson();
    }

    private Legs mergeRouteBookLegs() {
        routeBookLegs = new Legs();
        for (int i = 0; i < mWalkPlanList.size(); i++) {
            if (((WalkPlan) mWalkPlanList.get(i)).getRoutesCount() > 0) {
                for (Legs leg : ((WalkPlan) mWalkPlanList.get(i)).getRoutes(0).getLegsList()) {
                    List<Steps> stepsList = leg.getStepsList();
                    if (stepsList != null) {
                        for (Steps steps : stepsList) {
                            routeBookLegs.addSteps(steps);
                        }
                    }
                }
            }
        }
        C2911f.e(TAG, "mergeLegs:" + routeBookLegs.getStepsCount());
        return routeBookLegs;
    }

    private void resetTemporaryField() {
        this.mJsonBuilder = new JsonBuilder();
        this.mNodeCount = 0;
    }

    private void addRoutePaths(Legs legs) {
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
            addLineArrowStyle(123, 124, 156, 157);
            this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(ProviderUtils.connectPath(this.preMc, this.curMc)));
            this.mJsonBuilder.endObject();
            this.preMc = this.curMc;
        }
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

    private int getCurrentIndex() {
        int i = this.mNodeCount;
        this.mNodeCount = i + 1;
        return i;
    }
}
