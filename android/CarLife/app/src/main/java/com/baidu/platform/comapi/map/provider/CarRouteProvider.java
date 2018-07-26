package com.baidu.platform.comapi.map.provider;

import android.support.v4.media.TransportMediator;
import com.baidu.entity.pb.Car;
import com.baidu.entity.pb.Car.Routes.Legs;
import com.baidu.entity.pb.Car.Routes.Legs.Steps;
import com.baidu.entity.pb.Car.Traffic.Routes;
import com.baidu.platform.comapi.map.MapBundleKey.MapObjKey;
import com.baidu.platform.comapi.map.provider.EngineConst.OVERLAY_KEY;
import com.baidu.platform.comapi.map.provider.ProviderUtils.RouteState;
import com.baidu.platform.comapi.util.C2911f;
import com.baidu.platform.comapi.util.JsonBuilder;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class CarRouteProvider implements RenderProvider {
    public static final int END_NODE_STYLE = 18;
    public static final int NO_SHOW_ARROR_LINE_MAX_LEVEL = 12;
    public static final int NO_SHOW_ARROR_LINE_MIN_LEVEL = 3;
    public static final int SHOW_ARROR_LINE_MIN_LEVEL = 13;
    public static final int SHOW_ARROW_LINE_MAX_LEVEL = 22;
    public static final int START_NODE_STYLE = 17;
    public static final int STEP_NODE_OFFSET = 8;
    public static final int STEP_NODE_STYLE = 37;
    private static final String TAG = CarRouteProvider.class.getSimpleName();
    public static final int THROUGH_NODE_STYLE = 244;
    public static final int WALK_START_STYLE = 332;
    private Steps endSteps;
    private boolean isFocus;
    private boolean isMultipleRoutes;
    private boolean isNodeShow;
    private boolean isShowITS;
    private Car mCarRoute;
    private int mId;
    private JsonBuilder mJsonBuilder;
    private int mNodeCount;
    private List<List<Integer>> mRoadTypeList;
    private CarRouteCache mRouteCache;
    private RouteState mState;
    private List<Integer> mWalkSpathList;

    public CarRouteProvider(Car carRoute) {
        this.isNodeShow = true;
        this.mCarRoute = carRoute;
        this.mRouteCache = new CarRouteCache();
        this.mState = RouteState.ENTIRE;
        this.isFocus = true;
        this.isShowITS = false;
        this.isMultipleRoutes = false;
        this.mWalkSpathList = new ArrayList();
        this.mRoadTypeList = new ArrayList();
    }

    public CarRouteProvider(Car mCarRoute, int id) {
        this(mCarRoute);
        this.mId = id;
        this.isMultipleRoutes = true;
    }

    public void clearWalkPath() {
        this.mWalkSpathList.clear();
    }

    public void setWalkPath(List<Integer> walk) {
        clearWalkPath();
        this.mWalkSpathList.addAll(walk);
    }

    public void setRoadTypeList(List<List<Integer>> roadTypes) {
        this.mRoadTypeList.clear();
        this.mRoadTypeList.addAll(roadTypes);
    }

    public void openITS() {
        this.isShowITS = true;
    }

    public void closeITS() {
        this.isShowITS = false;
    }

    public void showNode(boolean isNodeShow) {
        this.isNodeShow = isNodeShow;
    }

    public void setFocus() {
        this.isFocus = true;
    }

    public void cleanFocus() {
        this.isFocus = false;
    }

    public void setRouteState(RouteState state) {
        this.mState = state;
    }

    public void updateRoute(Car carRoute) {
        this.mCarRoute = carRoute;
    }

    private void resetTemporaryField() {
        this.mJsonBuilder = new JsonBuilder();
        this.mNodeCount = 0;
    }

    public String getRenderData() {
        C2911f.b("BUILD_JSON" + System.currentTimeMillis());
        resetTemporaryField();
        try {
            this.mJsonBuilder.object();
            addRenderNodes();
            addRouteLegData();
            addMultiRouteInfo();
            this.mJsonBuilder.endObject();
            C2911f.b("BUILD_JSON" + System.currentTimeMillis());
            return this.mJsonBuilder.getJson();
        } catch (Exception e) {
            return "";
        }
    }

    private void addRenderNodes() {
        this.mJsonBuilder.key("dataset").arrayValue();
        for (RouteData dataSet : this.mRouteCache.updateCacheAndGetResult(this.mCarRoute)) {
            addRoutePaths(dataSet);
            if (this.isNodeShow) {
                addNodes(dataSet);
            }
        }
        this.mJsonBuilder.endArrayValue();
    }

    private void addRouteLegData() {
        if (this.isFocus) {
            this.mJsonBuilder.key("labelset").arrayValue();
            for (RouteData dataSet : this.mRouteCache.updateCacheAndGetResult(this.mCarRoute)) {
                for (int j = 0; j < dataSet.routeLegs.size(); j++) {
                    for (int i = 0; i < ((Legs) dataSet.routeLegs.get(j)).getStepsCount(); i++) {
                        this.mJsonBuilder.object();
                        this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(((Legs) dataSet.routeLegs.get(j)).getSteps(i).getSpathList()));
                        this.mJsonBuilder.key("tx").value(((Legs) dataSet.routeLegs.get(j)).getSteps(i).getUsroadname());
                        this.mJsonBuilder.key("level").value(((Legs) dataSet.routeLegs.get(j)).getSteps(i).getLevel());
                        this.mJsonBuilder.endObject();
                    }
                }
            }
            this.mJsonBuilder.endArrayValue();
        }
    }

    public String getProjectionPaths() {
        JsonBuilder jsonBuilder = new JsonBuilder();
        for (RouteData dataSet : this.mRouteCache.updateCacheAndGetResult(this.mCarRoute)) {
            for (int j = 0; j < dataSet.routeLegs.size(); j++) {
                for (int i = 0; i < ((Legs) dataSet.routeLegs.get(j)).getStepsCount(); i++) {
                    jsonBuilder.object();
                    jsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(((Legs) dataSet.routeLegs.get(j)).getSteps(i).getSpathList()));
                    jsonBuilder.endObject();
                }
            }
        }
        return jsonBuilder.getJson();
    }

    private void addMultiRouteInfo() {
        if (this.isMultipleRoutes) {
            this.mJsonBuilder.key(MapObjKey.OBJ_MCAR).object();
            this.mJsonBuilder.key("id").value(this.mId);
            this.mJsonBuilder.key("status").value(this.mState.getNativeValue());
            this.mJsonBuilder.endObject();
        }
    }

    private void addRoutePaths(RouteData dataSet) {
        for (int j = 0; j < dataSet.routeLegs.size(); j++) {
            for (int i = 0; i < ((Legs) dataSet.routeLegs.get(j)).getStepsCount(); i++) {
                if (this.isFocus) {
                    addFocusPath(dataSet, j, i);
                } else if (hasITS(dataSet, j)) {
                    addUnFocusITSPath(dataSet, j, i);
                } else {
                    addUnFocusPath(dataSet, j, i);
                }
                this.endSteps = ((Legs) dataSet.routeLegs.get(j)).getSteps(i);
                this.mNodeCount++;
            }
        }
        if (this.mWalkSpathList.size() > 0) {
            addWalkSPath(this.mWalkSpathList);
        }
    }

    private void addUnFocusITSPath(RouteData dataSet, int legIndex, int index) {
        List<Integer> path = ((Legs) dataSet.routeLegs.get(legIndex)).getSteps(index).getSpathList();
        List<Integer> endList = ((Routes.Legs) dataSet.trafficLegs.get(legIndex)).getSteps(index).getEndList();
        List<Integer> statusList = ((Routes.Legs) dataSet.trafficLegs.get(legIndex)).getSteps(index).getStatusList();
        if ((((Integer) ((List) this.mRoadTypeList.get(legIndex)).get(index)).intValue() & 1) == 0) {
            List<List<Integer>> paths = ProviderUtils.splitPath(path, endList);
            if (paths.size() == statusList.size()) {
                for (int i = 0; i < paths.size(); i++) {
                    addUnFocusITSStyle((List) paths.get(i), ((Integer) statusList.get(i)).intValue());
                }
                return;
            }
            return;
        }
        addInternalRoadPath(((Legs) dataSet.routeLegs.get(legIndex)).getSteps(index).getSpathList(), false);
    }

    private void addFocusPath(RouteData dataSet, int legIndex, int index) {
        if (hasITS(dataSet, legIndex)) {
            addITSPath(dataSet, legIndex, index);
        } else if ((((Integer) ((List) this.mRoadTypeList.get(legIndex)).get(index)).intValue() & 1) == 0) {
            addNoITSPath(dataSet, legIndex, index);
        } else {
            addInternalRoadPath(((Legs) dataSet.routeLegs.get(legIndex)).getSteps(index).getSpathList(), true);
        }
    }

    private void addUnFocusPath(RouteData dataSet, int legIndex, int index) {
        if ((((Integer) ((List) this.mRoadTypeList.get(legIndex)).get(index)).intValue() & 1) == 0) {
            addOnePath(((Legs) dataSet.routeLegs.get(legIndex)).getSteps(index).getSpathList(), TransportMediator.KEYCODE_MEDIA_PAUSE, TransportMediator.KEYCODE_MEDIA_PAUSE, TransportMediator.KEYCODE_MEDIA_PAUSE, TransportMediator.KEYCODE_MEDIA_PAUSE);
            return;
        }
        addInternalRoadPath(((Legs) dataSet.routeLegs.get(legIndex)).getSteps(index).getSpathList(), false);
    }

    private void addITSPath(RouteData dataSet, int legIndex, int index) {
        List<Integer> path = ((Legs) dataSet.routeLegs.get(legIndex)).getSteps(index).getSpathList();
        List<Integer> endList = ((Routes.Legs) dataSet.trafficLegs.get(legIndex)).getSteps(index).getEndList();
        List<Integer> statusList = ((Routes.Legs) dataSet.trafficLegs.get(legIndex)).getSteps(index).getStatusList();
        List<List<Integer>> paths = ProviderUtils.splitPath(path, endList);
        if ((((Integer) ((List) this.mRoadTypeList.get(legIndex)).get(index)).intValue() & 1) != 0) {
            addInternalRoadPath(((Legs) dataSet.routeLegs.get(legIndex)).getSteps(index).getSpathList(), true);
        } else if (paths.size() == statusList.size()) {
            for (int i = 0; i < paths.size(); i++) {
                addITSStyle((List) paths.get(i), ((Integer) statusList.get(i)).intValue());
            }
        }
    }

    private void addUnFocusITSStyle(List<Integer> path, int status) {
        switch (status) {
            case 1:
                addOnePath(path, RouteLineResConst.LINE_GREEN_GREY, RouteLineResConst.LINE_GREEN_GREY, RouteLineResConst.LINE_GREEN_GREY, RouteLineResConst.LINE_GREEN_GREY);
                return;
            case 2:
                addOnePath(path, RouteLineResConst.LINE_YELLOW_GREY, RouteLineResConst.LINE_YELLOW_GREY, RouteLineResConst.LINE_YELLOW_GREY, RouteLineResConst.LINE_YELLOW_GREY);
                return;
            case 3:
                addOnePath(path, 192, 192, 192, 192);
                return;
            case 4:
                addOnePath(path, RouteLineResConst.LINE_DARK_RED_GREY, RouteLineResConst.LINE_DARK_RED_GREY, RouteLineResConst.LINE_DARK_RED_GREY, RouteLineResConst.LINE_DARK_RED_GREY);
                return;
            default:
                addOnePath(path, RouteLineResConst.LINE_BLUE_GREY, RouteLineResConst.LINE_BLUE_GREY, RouteLineResConst.LINE_BLUE_GREY, RouteLineResConst.LINE_BLUE_GREY);
                return;
        }
    }

    private void addITSStyle(List<Integer> path, int status) {
        switch (status) {
            case 1:
                addOnePath(path, 73, 77, 160, 161);
                return;
            case 2:
                addOnePath(path, 74, 78, RouteLineResConst.LINE_ARR_YELLOW_NORMAL, RouteLineResConst.LINE_ARR_YELLOW_FOCUS);
                return;
            case 3:
                addOnePath(path, 75, 79, 162, RouteLineResConst.LINE_ARR_RED_FOCUS);
                return;
            case 4:
                addOnePath(path, RouteLineResConst.LINE_DARK_RED_NORMAL, RouteLineResConst.LINE_DARK_RED_FOCUS, RouteLineResConst.LINE_ARR_DARK_RED_NORMAL, RouteLineResConst.LINE_ARR_DARK_RED_FOCUS);
                return;
            default:
                addOnePath(path, 123, 124, 156, 157);
                return;
        }
    }

    private void addNoITSPath(RouteData dataSet, int legIndex, int index) {
        addOnePath(((Legs) dataSet.routeLegs.get(legIndex)).getSteps(index).getSpathList(), 123, 124, 156, 157);
    }

    private void addWalkSPath(List<Integer> path) {
        this.mJsonBuilder.object();
        this.mJsonBuilder.key("ty").value(2);
        this.mJsonBuilder.key("in").value(this.mNodeCount);
        this.mJsonBuilder.key(OVERLAY_KEY.DASH_STYLE).value(1);
        this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(path));
        addLineArrowStyle(RouteLineResConst.LINE_FOOT_NORMAL, RouteLineResConst.LINE_FOOT_NORMAL, RouteLineResConst.LINE_FOOT_NORMAL, RouteLineResConst.LINE_FOOT_NORMAL);
        this.mJsonBuilder.endObject();
    }

    private void addInternalRoadPath(List<Integer> path, boolean isFocus) {
        this.mJsonBuilder.object();
        this.mJsonBuilder.key("ty").value(2);
        this.mJsonBuilder.key("in").value(this.mNodeCount);
        this.mJsonBuilder.key(OVERLAY_KEY.DASH_STYLE).value(1);
        this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(path));
        if (isFocus) {
            addLineArrowStyle(RouteLineResConst.LINE_INTERNAL_NORMAL, RouteLineResConst.LINE_INTERNAL_NORMAL, RouteLineResConst.LINE_ARR_INTERNAL_NORMAL, RouteLineResConst.LINE_ARR_INTERNAL_NORMAL);
        } else {
            addLineArrowStyle(RouteLineResConst.LINE_INTERNAL_GREY, RouteLineResConst.LINE_INTERNAL_GREY, RouteLineResConst.LINE_INTERNAL_GREY, RouteLineResConst.LINE_INTERNAL_GREY);
        }
        this.mJsonBuilder.endObject();
    }

    private void addOnePath(List<Integer> path, int normalStyle, int focusStyle, int arrNormalStyle, int arrFocusStyle) {
        this.mJsonBuilder.object();
        this.mJsonBuilder.key("ty").value(2);
        this.mJsonBuilder.key("in").value(this.mNodeCount);
        this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(path));
        addLineArrowStyle(normalStyle, focusStyle, arrNormalStyle, arrFocusStyle);
        this.mJsonBuilder.endObject();
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

    private boolean hasITS(RouteData dataSet, int legIndex) {
        Routes.Legs trafficLegs = (Routes.Legs) dataSet.trafficLegs.get(legIndex);
        return this.isShowITS && trafficLegs != null && trafficLegs.getStepsCount() > 0;
    }

    private void addNodes(RouteData dataSet) {
        if (this.isFocus) {
            this.mNodeCount = 1;
            addRouteStepNodes(dataSet);
            addRouteStartNode(dataSet);
            addRouteEndNode();
            addWalkStartNode();
        }
    }

    private void addWalkStartNode() {
        if (this.mWalkSpathList.size() > 7) {
            this.mJsonBuilder.object();
            this.mJsonBuilder.key("ud").value("");
            this.mJsonBuilder.key("ty").value(8);
            this.mJsonBuilder.key("nst").value((int) WALK_START_STYLE);
            this.mJsonBuilder.key("fst").value((int) WALK_START_STYLE);
            this.mJsonBuilder.key("tx").value("步行起点");
            this.mJsonBuilder.key("in").value(this.mNodeCount);
            this.mJsonBuilder.key(OVERLAY_KEY.ALIGN).value(2);
            List<Integer> walkStartPoint = new ArrayList();
            walkStartPoint.add(this.mWalkSpathList.get(5));
            walkStartPoint.add(this.mWalkSpathList.get(6));
            this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(walkStartPoint));
            this.mJsonBuilder.endObject();
        }
    }

    private void addRouteStartNode(RouteData dataSet) {
        if (dataSet != null && dataSet.routeLegs != null && ((Legs) dataSet.routeLegs.get(0)).getStepsCount() > 0) {
            Steps startStep = ((Legs) dataSet.routeLegs.get(0)).getSteps(0);
            if (startStep != null) {
                this.mJsonBuilder.object();
                this.mJsonBuilder.key("ud").value("");
                this.mJsonBuilder.key("ty").value(1);
                this.mJsonBuilder.key("nst").value(17);
                this.mJsonBuilder.key("fst").value(17);
                this.mJsonBuilder.key("tx").value("起点");
                this.mJsonBuilder.key("in").value(0);
                this.mJsonBuilder.key(OVERLAY_KEY.ALIGN).value(2);
                this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(startStep.getSstartLocationList()));
                this.mJsonBuilder.endObject();
            }
        }
    }

    private void addRouteEndNode() {
        if (this.endSteps != null) {
            this.mJsonBuilder.object();
            this.mJsonBuilder.key("ud").value("");
            this.mJsonBuilder.key("ty").value(2);
            this.mJsonBuilder.key("nst").value(18);
            this.mJsonBuilder.key("fst").value(18);
            this.mJsonBuilder.key("tx").value("终点");
            this.mJsonBuilder.key("in").value(this.mNodeCount + this.mWalkSpathList.size());
            this.mJsonBuilder.key(OVERLAY_KEY.ALIGN).value(2);
            if (this.mWalkSpathList.size() > 7) {
                List<Integer> walkEndPoint = new ArrayList();
                int endPointLon = ((Integer) this.mWalkSpathList.get(5)).intValue();
                int endPointLat = ((Integer) this.mWalkSpathList.get(6)).intValue();
                for (int index = 7; index < this.mWalkSpathList.size() - 1; index += 2) {
                    endPointLon += ((Integer) this.mWalkSpathList.get(index)).intValue();
                    endPointLat += ((Integer) this.mWalkSpathList.get(index + 1)).intValue();
                }
                walkEndPoint.add(Integer.valueOf(endPointLon));
                walkEndPoint.add(Integer.valueOf(endPointLat));
                this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(walkEndPoint));
            } else {
                this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(this.endSteps.getSendLocationList()));
            }
            this.mJsonBuilder.endObject();
            this.mNodeCount++;
        }
    }

    private void addRouteStepNodes(RouteData dataSet) {
        for (int j = 0; j < dataSet.routeLegs.size(); j++) {
            List<Steps> stepsList = ((Legs) dataSet.routeLegs.get(j)).getStepsList();
            addHeadStepNode(stepsList);
            for (int i = 0; i < stepsList.size(); i++) {
                Steps steps = (Steps) stepsList.get(i);
                addOneRouteStop(steps.getSendLocationList(), steps.getEndInstructions(), getStepDirection(stepsList, i));
            }
        }
    }

    private void addHeadStepNode(List<Steps> stepsList) {
        if (!stepsList.isEmpty()) {
            Steps steps = (Steps) stepsList.get(0);
            addOneRouteStop(steps.getSstartLocationList(), steps.getStartInstructions(), steps.getDirection());
        }
    }

    private void addOneRouteStop(List<Integer> path, String description, int direction) {
        this.mJsonBuilder.object();
        this.mJsonBuilder.key("ty").value(8);
        this.mJsonBuilder.key("nst").value(37);
        this.mJsonBuilder.key("fst").value(37);
        this.mJsonBuilder.key("in").value(this.mNodeCount);
        this.mJsonBuilder.key("of").value(8);
        if (direction != 0) {
            this.mJsonBuilder.key("dir").value(direction * 30);
        }
        this.mJsonBuilder.key("tx").value(description);
        this.mJsonBuilder.key("path").objectValue(ProviderUtils.pathToJson(path));
        this.mJsonBuilder.endObject();
        this.mNodeCount++;
    }

    private int getStepDirection(List<Steps> stepsList, int i) {
        return i < stepsList.size() + -1 ? ((Steps) stepsList.get(i + 1)).getDirection() : 0;
    }
}
