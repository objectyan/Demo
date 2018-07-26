package com.baidu.platform.comapi.map.provider;

import android.graphics.Color;
import android.text.TextUtils;
import com.baidu.entity.pb.Bus;
import com.baidu.entity.pb.Bus.Routes.Legs;
import com.baidu.entity.pb.Bus.Routes.Legs.Steps;
import com.baidu.entity.pb.Bus.Routes.Legs.Steps.Step;
import com.baidu.entity.pb.Bus.Routes.Legs.Steps.Step.LinkColor;
import com.baidu.entity.pb.Bus.Routes.Legs.Steps.Step.LowerSteps;
import com.baidu.entity.pb.Bus.Routes.Legs.Steps.Step.LowerSteps.LowerStep;
import com.baidu.platform.comapi.map.provider.EngineConst.OVERLAY_KEY;
import com.baidu.platform.comapi.util.C2911f;
import com.baidu.platform.comapi.util.JsonBuilder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class BusRouteProvider implements RenderProvider {
    public static final int BIKE_LINE_FOCUS_STYLE = 175;
    public static final int BIKE_LINE_NORMAL_STYLE = 171;
    public static final int END_NODE_STYLE = 355;
    public static final int NO_SHOW_ARROR_LINE_MAX_LEVEL = 12;
    public static final int NO_SHOW_ARROR_LINE_MIN_LEVEL = 3;
    public static final int QIUYIN_DEFAULT_COLOR = -13400577;
    public static final int QIUYIN_DEFAULT_WIDTH = 10;
    public static final int SHOW_ARROR_LINE_MIN_LEVEL = 13;
    public static final int SHOW_ARROW_LINE_MAX_LEVEL = 22;
    public static final int START_NODE_STYLE = 354;
    public static final int STEP_NODE_AIR_STYLE = 119;
    public static final int STEP_NODE_COACH_STYLE = 345;
    public static final int STEP_NODE_STYLE_FOOT = 113;
    public static final int STEP_NODE_STYLE_PRE = 15;
    public static final int STEP_NODE_TRAIN_STYLE = 120;
    private static final String TAG = BusRouteProvider.class.getSimpleName();
    private Step endStep;
    private Bus mBusRoute;
    private JsonBuilder mJsonBuilder;
    private int mNodeCount;
    private int mRouteIndex;

    public BusRouteProvider(Bus busRoute) {
        this.mBusRoute = busRoute;
        this.mRouteIndex = 0;
    }

    public BusRouteProvider(Bus busRoute, int routeIndex) {
        this(busRoute);
        this.mRouteIndex = routeIndex;
    }

    public int getRouteIndex() {
        return this.mRouteIndex;
    }

    public void setRouteIndex(int routeIndex) {
        this.mRouteIndex = routeIndex;
    }

    public String getRenderData() {
        resetTemporaryField();
        Legs legs = mergeLegs();
        if (legs != null) {
            try {
                this.mJsonBuilder.object().key("dataset").arrayValue();
                addRoutePaths(legs);
                addRouteStartNode(legs);
                addRouteSteps(legs);
                addRouteEndNode();
                this.mJsonBuilder.endArrayValue().endObject();
            } catch (Exception e) {
                C2911f.a(TAG, "getRenderData error", e);
                return "";
            }
        }
        return this.mJsonBuilder.getJson();
    }

    private void resetTemporaryField() {
        this.mJsonBuilder = new JsonBuilder();
        this.mNodeCount = 0;
    }

    private Legs mergeLegs() {
        Legs legs = new Legs();
        if (this.mRouteIndex > -1 && this.mBusRoute != null && this.mBusRoute.getRoutesCount() > this.mRouteIndex && this.mBusRoute.getRoutes(this.mRouteIndex) != null) {
            for (Legs leg : this.mBusRoute.getRoutes(this.mRouteIndex).getLegsList()) {
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
        for (Steps steps : legs.getStepsList()) {
            Step step = steps.getStep(0);
            if (step.getLowerStepsCount() > 0) {
                for (LowerSteps lowerStep : step.getLowerStepsList()) {
                    addLowStepPath(lowerStep, step.getType());
                    this.mNodeCount++;
                }
            } else {
                addOneVehiclePath(step);
                this.mNodeCount++;
            }
        }
    }

    private void addLowStepPath(LowerSteps lowerSteps, int stepType) {
        LowerStep lowerStep = lowerSteps.getLowerStep(0);
        if (lowerStep.getSpathCount() >= 2) {
            if (isFootLine(stepType, lowerStep.getType())) {
                addOnePath(lowerStep.getInstructions(), lowerStep.getSpathList(), 10, QIUYIN_DEFAULT_COLOR, 1);
            } else {
                addOnePathImg(lowerStep.getInstructions(), lowerStep.getSpathList(), 123, 124, 156, 157);
            }
        }
    }

    private boolean isFootLine(int stepType, int lowStepType) {
        return stepType == 5 || (stepType == 3 && lowStepType == 5);
    }

    private void addOneVehiclePath(Step step) {
        if (step.getSpathCount() >= 2) {
            if (step.getType() == 5) {
                addOnePath(step.getInstructions(), step.getSpathList(), 10, QIUYIN_DEFAULT_COLOR, 1);
            } else if (step.getType() == 7) {
                addOnePathImg(step.getInstructions(), step.getSpathList(), 171, 175, 171, 175);
            } else if (step.getType() == 3 && step.hasVehicle() && step.getVehicle().getType() == 1) {
                addOnePath(step.getInstructions(), step.getSpathList(), 7, getRealColor(step.getVehicle().getLineColor()), 0);
            } else if (step.getType() == 1) {
                addOnePathImg(step.getInstructions(), step.getSpathList(), 207, 207, 207, 207);
            } else if (step.getType() == 2) {
                addOnePathImg(step.getInstructions(), step.getSpathList(), 205, 205, 205, 205);
            } else if (step.getType() == 6) {
                addOnePathImg(step.getInstructions(), step.getSpathList(), 206, 206, 206, 206);
            } else if (hasITS(step)) {
                addITSPath(step.getInstructions(), step.getSpathList(), step.getLinkColorList());
            } else {
                addOnePathImg(step.getInstructions(), step.getSpathList(), 123, 124, 123, 124);
            }
        }
    }

    private void addOnePath(String instructions, List<Integer> path, int width, int color, int dash) {
        this.mJsonBuilder.object();
        this.mJsonBuilder.key("ty").value(2);
        this.mJsonBuilder.key("in").value(this.mNodeCount);
        this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(path));
        this.mJsonBuilder.key("tx").value(ProviderUtils.escapeString(instructions));
        if (dash == 0) {
            this.mJsonBuilder.key(OVERLAY_KEY.DASH_STYLE).value(dash);
            this.mJsonBuilder.key(OVERLAY_KEY.AREA_STYLE).objectValue(getStyleJson(width, color, 1, 0, 100).toString());
            addLineArrowStyle(width, color);
        } else {
            this.mJsonBuilder.key(OVERLAY_KEY.DASH_STYLE).value(dash);
            this.mJsonBuilder.key(OVERLAY_KEY.AREA_STYLE).objectValue(getFootStyleJson().toString());
        }
        this.mJsonBuilder.endObject();
    }

    private void addLineArrowStyle(int width, int color) {
        try {
            JsonBuilder builder = new JsonBuilder();
            builder.arrayValue();
            builder.objectValue(getStyleJson(width, color, 1, 13, 22).toString());
            builder.objectValue(getStyleJson(width, color, 0, 3, 12).toString());
            builder.endArrayValue();
            this.mJsonBuilder.key(OVERLAY_KEY.SGEO_DIFF_LEVEL).objectValue(builder.getJson());
        } catch (Exception e) {
        }
    }

    private void addOnePathImg(String instructions, List<Integer> path, int normalStyle, int focusStyle, int arrNormalStyle, int arrFocusStyle) {
        this.mJsonBuilder.object();
        this.mJsonBuilder.key("ty").value(2);
        this.mJsonBuilder.key("in").value(this.mNodeCount);
        this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(path));
        this.mJsonBuilder.key("tx").value(ProviderUtils.escapeString(instructions));
        addLineArrowStyleImg(normalStyle, focusStyle, arrNormalStyle, arrFocusStyle);
        this.mJsonBuilder.endObject();
    }

    private void addLineArrowStyleImg(int normalStyle, int focusStyle, int arrNormalStyle, int arrFocusStyle) {
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

    private void addITSPath(String instructions, List<Integer> path, List<LinkColor> linkColorList) {
        if (path != null && linkColorList != null) {
            int i;
            List<Integer> statusList = new ArrayList();
            List<Integer> endList = new ArrayList();
            for (i = 0; i < linkColorList.size(); i++) {
                statusList.add(Integer.valueOf(((LinkColor) linkColorList.get(i)).getStatus()));
                endList.add(Integer.valueOf(((LinkColor) linkColorList.get(i)).getGeoCnt()));
            }
            List<List<Integer>> paths = ProviderUtils.splitPath(path, endList);
            if (paths.size() == statusList.size()) {
                for (i = 0; i < paths.size(); i++) {
                    addITSStyle(instructions, (List) paths.get(i), ((Integer) statusList.get(i)).intValue());
                }
            }
        }
    }

    private void addITSStyle(String instructions, List<Integer> path, int status) {
        switch (status) {
            case 1:
                addOnePathImg(instructions, path, 73, 77, 160, 161);
                return;
            case 2:
                addOnePathImg(instructions, path, 74, 78, RouteLineResConst.LINE_ARR_YELLOW_NORMAL, RouteLineResConst.LINE_ARR_YELLOW_FOCUS);
                return;
            case 3:
                addOnePathImg(instructions, path, 75, 79, 162, RouteLineResConst.LINE_ARR_RED_FOCUS);
                return;
            case 4:
                addOnePathImg(instructions, path, RouteLineResConst.LINE_DARK_RED_NORMAL, RouteLineResConst.LINE_DARK_RED_FOCUS, RouteLineResConst.LINE_ARR_DARK_RED_NORMAL, RouteLineResConst.LINE_ARR_DARK_RED_FOCUS);
                return;
            default:
                addOnePathImg(instructions, path, 123, 124, 156, 157);
                return;
        }
    }

    private void addRouteStartNode(Legs legs) {
        if (legs != null && legs.getStepsCount() > 0) {
            List<Steps> stepsList = legs.getStepsList();
            if (((Steps) stepsList.get(0)).getStepCount() > 0) {
                Step step = ((Steps) stepsList.get(0)).getStep(0);
                if (step != null) {
                    this.mJsonBuilder.object();
                    this.mJsonBuilder.key("ud").value("");
                    this.mJsonBuilder.key("ty").value(1);
                    this.mJsonBuilder.key("nst").value((int) START_NODE_STYLE);
                    this.mJsonBuilder.key("fst").value((int) START_NODE_STYLE);
                    this.mJsonBuilder.key("tx").value("起点");
                    this.mJsonBuilder.key("in").value(0);
                    this.mJsonBuilder.key(OVERLAY_KEY.ALIGN).value(2);
                    this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(step.getSstartLocationList()));
                    this.mJsonBuilder.endObject();
                }
            }
        }
    }

    private void addRouteEndNode() {
        if (this.endStep != null) {
            this.mJsonBuilder.object();
            this.mJsonBuilder.key("ud").value("");
            this.mJsonBuilder.key("ty").value(2);
            this.mJsonBuilder.key("nst").value((int) END_NODE_STYLE);
            this.mJsonBuilder.key("fst").value((int) END_NODE_STYLE);
            this.mJsonBuilder.key("tx").value("终点");
            this.mJsonBuilder.key("in").value(this.mNodeCount);
            this.mJsonBuilder.key(OVERLAY_KEY.ALIGN).value(2);
            this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(this.endStep.getSendLocationList()));
            this.mJsonBuilder.endObject();
        }
    }

    private void addRouteSteps(Legs legs) {
        for (Steps aStepsList : legs.getStepsList()) {
            Step step = aStepsList.getStep(0);
            this.endStep = step;
            if (step.getLowerStepsCount() > 0) {
                addLowSteps(step);
            } else {
                addOneVehicleSteps(step, step.getSstartLocationList());
                addOneVehicleSteps(step, step.getSendLocationList());
            }
            this.mNodeCount++;
        }
    }

    private void addLowSteps(Step step) {
        for (int i = 0; i < step.getLowerStepsCount(); i++) {
            LowerStep lowStep = step.getLowerSteps(i).getLowerStep(0);
            switch (step.getType()) {
                case 3:
                    addOneLowStep(lowStep, lowStep.getSstartLocationList());
                    addOneLowStep(lowStep, lowStep.getSendLocationList());
                    break;
                default:
                    break;
            }
            this.mNodeCount++;
        }
    }

    private void addOneVehicleSteps(Step step, List<Integer> location) {
        int i = 1;
        int style = 15;
        boolean isCrossCity = this.mBusRoute.getOption().hasCty();
        switch (step.getType()) {
            case 1:
                style = 120;
                break;
            case 2:
                style = 119;
                break;
            case 3:
                if (isCrossCity) {
                    if (step.getVehicle().getType() != 1) {
                        i = 0;
                    }
                    style = i + 15;
                    break;
                }
                return;
            case 5:
                if (isCrossCity) {
                    style = 113;
                    break;
                }
                return;
            case 6:
                style = STEP_NODE_COACH_STYLE;
                break;
            case 7:
                return;
        }
        addOneVehicleStep(step, location, style);
    }

    private void addOneVehicleStep(Step step, List<Integer> location, int style) {
        this.mJsonBuilder.object();
        this.mJsonBuilder.key("ty").value(3);
        this.mJsonBuilder.key("ud").value("");
        this.mJsonBuilder.key("nst").value(style);
        this.mJsonBuilder.key("fst").value(style);
        this.mJsonBuilder.key("in").value(this.mNodeCount);
        this.mJsonBuilder.key("of").value(11);
        this.mJsonBuilder.key("tx").value(ProviderUtils.escapeString(step.getInstructions()));
        this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(location));
        this.mJsonBuilder.endObject();
    }

    private void addOneLowStep(LowerStep lowerStep, List<Integer> location) {
        if (lowerStep.getType() == 3) {
            int style = lowerStep.getVehicle().getType() == 1 ? 16 : 15;
            this.mJsonBuilder.object();
            this.mJsonBuilder.key("ty").value(3);
            this.mJsonBuilder.key("ud").value("");
            this.mJsonBuilder.key("nst").value(style);
            this.mJsonBuilder.key("fst").value(style);
            this.mJsonBuilder.key("in").value(this.mNodeCount);
            this.mJsonBuilder.key("of").value(11);
            this.mJsonBuilder.key("tx").value(ProviderUtils.escapeString(lowerStep.getInstructions()));
            this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(location));
            this.mJsonBuilder.endObject();
        }
    }

    private boolean hasITS(Step step) {
        return step != null && step.getLinkColorCount() > 0;
    }

    public JSONObject getStyleJson(int width, int color, int hasArrow, int minl, int maxl) {
        JSONObject jo = new JSONObject();
        try {
            jo.put("width", width);
            jo.put(OVERLAY_KEY.SGEO_LEVEL_COLOR_LINE, color);
            jo.put("arrow", hasArrow);
            jo.put("smooth", 1);
            jo.put("minl", minl);
            jo.put("maxl", maxl);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jo;
    }

    public JSONObject getFootStyleJson() {
        JSONObject jo = new JSONObject();
        try {
            jo.put("dashsty", 1);
            jo.put("width", 10);
            jo.put("smooth", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jo;
    }

    private int getRealColor(String colorStr) {
        if (TextUtils.isEmpty(colorStr)) {
            return QIUYIN_DEFAULT_COLOR;
        }
        if (colorStr.startsWith("0x")) {
            return Color.parseColor(colorStr.replace("0x", "#"));
        }
        return rgbToAbgr(Color.parseColor(colorStr));
    }

    private int rgbToAbgr(int color) {
        return ((-16777216 | ((color & 255) << 16)) | (65280 & color)) | ((16711680 & color) >> 16);
    }
}
