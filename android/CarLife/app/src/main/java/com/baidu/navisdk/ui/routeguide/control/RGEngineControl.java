package com.baidu.navisdk.ui.routeguide.control;

import android.content.Context;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.Iterator;

public class RGEngineControl {
    private static final String TAG = "RouteGuide";
    private static volatile RGEngineControl me = null;
    private boolean mManualSound;
    private boolean mbForbidManualSoundWhenSilence = false;

    public static RGEngineControl getInstance() {
        if (me == null) {
            synchronized (RGEngineControl.class) {
                if (me == null) {
                    me = new RGEngineControl();
                }
            }
        }
        return me;
    }

    public static void destory() {
        if (me != null) {
            synchronized (RGEngineControl.class) {
                if (me != null) {
                    me.dispose();
                }
            }
        }
        me = null;
    }

    private void dispose() {
    }

    public void setVoiceMode(int voiceMode) {
        if (voiceMode == 2) {
            this.mbForbidManualSoundWhenSilence = true;
        } else {
            this.mbForbidManualSoundWhenSilence = false;
        }
        BNRouteGuider.getInstance().setVoiceMode(voiceMode);
    }

    public int getNodeNum() {
        return ((RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN)).getNodeNum();
    }

    public int getTotalDistance() {
        return ((RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN)).getTotalDistanceInt();
    }

    public int getTotalTime() {
        return ((RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN)).getTotalTimeInt();
    }

    public int getFirstTurnType() {
        return ((RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN)).getFirstTurnType();
    }

    public int getFirstRemainDist() {
        return ((RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN)).getFirstRemainDist();
    }

    public String getFirstRoadName() {
        String roadName = ((RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN)).getFirstRoadName();
        if (roadName != null && !StringUtils.isEmpty(roadName)) {
            return roadName;
        }
        LogUtil.m15791e("RouteGuide", "ERROR: current RoadName = null");
        return JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_no_name_road);
    }

    public GeoPoint getCarGeoPoint() {
        GeoPoint carGeoPt = new GeoPoint();
        int[] outX = new int[]{0};
        int[] outY = new int[]{0};
        if (!BNRouteGuider.getInstance().getCarPoint(outX, outY) || outX[0] == 0 || outY[0] == 0) {
            LogUtil.m15791e("RouteGuide", "getCarGeoPoint. Engine(guidance_control) value is valid, set LastValidLocation as car point.");
            carGeoPt = BNSysLocationManager.getInstance().getLastValidLocation();
        } else {
            LogUtil.m15791e("RouteGuide", "getCarGeoPoint. Engine(guidance_control) value is valid");
            carGeoPt.setLongitudeE6(outX[0]);
            carGeoPt.setLatitudeE6(outY[0]);
        }
        if (carGeoPt == null || !carGeoPt.isValid()) {
            return BNLocationManagerProxy.getInstance().getLastValidLocation();
        }
        return carGeoPt;
    }

    public GeoPoint getCurrentGeoPoint() {
        GeoPoint carGeoPt = new GeoPoint();
        carGeoPt = BNSysLocationManager.getInstance().getLastValidLocation();
        if (carGeoPt == null || !carGeoPt.isValid()) {
            carGeoPt = BNLocationManagerProxy.getInstance().getLastValidLocation();
        }
        if (carGeoPt == null || !carGeoPt.isValid()) {
            int[] outX = new int[]{0};
            int[] outY = new int[]{0};
            if (!(!BNRouteGuider.getInstance().getCarPoint(outX, outY) || outX[0] == 0 || outY[0] == 0)) {
                LogUtil.m15791e("RouteGuide", "getCarGeoPoint. Engine(guidance_control) value is valid");
                if (carGeoPt == null) {
                    carGeoPt = new GeoPoint();
                }
                carGeoPt.setLongitudeE6(outX[0]);
                carGeoPt.setLatitudeE6(outY[0]);
            }
        }
        return carGeoPt;
    }

    public boolean manualPlaySound(Context context) {
        if (!this.mManualSound || this.mbForbidManualSoundWhenSilence) {
            return false;
        }
        LogUtil.m15791e("RouteGuide", "manualPlaySound");
        return BNRoutePlaner.getInstance().ManualPlaySound();
    }

    public void enableManualSound() {
        this.mManualSound = true;
    }

    public void disableManuSound() {
        this.mManualSound = false;
    }

    public boolean addViaPtToCalcRoute(GeoPoint geoPoint, String name) {
        GeoPoint carPt = getCurrentGeoPoint();
        if (carPt == null || !carPt.isValid()) {
            return false;
        }
        RoutePlanNode myPostionNode = new RoutePlanNode(carPt, 3, null, null);
        RoutePlanNode viaNode = new RoutePlanNode(geoPoint, 1, null, null);
        viaNode.mName = name;
        RoutePlanNode endNode = ((RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN)).getEndNode();
        ArrayList<RoutePlanNode> nodeList = new ArrayList();
        nodeList.add(myPostionNode);
        nodeList.add(viaNode);
        nodeList.add(endNode);
        myPostionNode.mNodeType = 3;
        viaNode.mNodeType = 1;
        if (endNode != null) {
            endNode.mNodeType = 1;
        }
        BNRoutePlaner.getInstance().setGuideEndType(1);
        BNRoutePlaner.getInstance().setComeFrom(2);
        BNRoutePlaner.getInstance().setEntry(2);
        BNRoutePlaner.getInstance().setPointsToCalcRoute(nodeList, 0);
        return true;
    }

    public boolean setEndPtToCalcRoute(GeoPoint geoPoint) {
        GeoPoint carPt = getCurrentGeoPoint();
        if (carPt == null || !carPt.isValid()) {
            return false;
        }
        RoutePlanNode myPostionNode = new RoutePlanNode(carPt, 3, null, null);
        myPostionNode.mNodeType = 3;
        RoutePlanNode endNode = new RoutePlanNode(geoPoint, 1, null, null);
        ArrayList<RoutePlanNode> nodeList = new ArrayList();
        endNode.mNodeType = 1;
        nodeList.add(myPostionNode);
        RoutePlanNode viaNode = null;
        if (RoutePlanModel.sNavNodeList.size() >= 3) {
            viaNode = (RoutePlanNode) RoutePlanModel.sNavNodeList.get(1);
        }
        if (viaNode != null) {
            nodeList.add(viaNode);
        }
        nodeList.add(endNode);
        BNRoutePlaner.getInstance().mEndNode = endNode;
        BNSettingManager.setEndNode(endNode);
        LogUtil.m15791e("RouteGuide", "endNode route " + BNRoutePlaner.getInstance().mEndNode.toString());
        if (BNRoutePlaner.getInstance().getGuideSceneType() != 4) {
            BNRoutePlaner.getInstance().setGuideSceneType(1);
            BNRoutePlaner.getInstance().setGuideEndType(0);
        } else {
            BNRoutePlaner.getInstance().setGuideSceneType(4);
            BNRoutePlaner.getInstance().setGuideEndType(2);
        }
        BNRoutePlaner.getInstance().setComeFrom(2);
        BNRoutePlaner.getInstance().setEntry(2);
        BNRoutePlaner.getInstance().setPointsToCalcRoute(nodeList, 0);
        return true;
    }

    public boolean reCalcRoute() {
        return reCalcRoute(0);
    }

    private boolean reCalcRoute(int source) {
        LogUtil.m15791e("RouteGuide", "reCalcRoute");
        BNavigator.getInstance().resetWithReCalcRoute();
        GeoPoint carPt = getCurrentGeoPoint();
        if (carPt == null || !carPt.isValid()) {
            return false;
        }
        RoutePlanNode myPostionNode = new RoutePlanNode(carPt, 3, null, null);
        myPostionNode.mNodeType = 3;
        ArrayList<RoutePlanNode> navNodeList = RoutePlanModel.sNavNodeList;
        RoutePlanNode endNode = ((RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN)).getEndNode();
        if (endNode == null) {
            return false;
        }
        endNode.mNodeType = 1;
        ArrayList<RoutePlanNode> nodeList = new ArrayList();
        nodeList.add(myPostionNode);
        if (navNodeList != null && navNodeList.size() >= 3) {
            for (int i = 1; i < navNodeList.size() - 1; i++) {
                RoutePlanNode viaNode = (RoutePlanNode) navNodeList.get(i);
                if (viaNode != null) {
                    nodeList.add(viaNode);
                }
            }
        }
        nodeList.add(endNode);
        BNRoutePlaner.getInstance().setComeFrom(2);
        BNRoutePlaner.getInstance().setEntry(2);
        BNRoutePlaner.getInstance().setGuideEndType(1);
        BNRoutePlaner.getInstance().setPointsToCalcRoute(nodeList, source);
        RGNotificationController.getInstance().hideAllView(false, false);
        return true;
    }

    public boolean reCalcRouteWhenFail() {
        LogUtil.m15791e("RouteGuide", "reCalcRouteWhenFail");
        BNavigator.getInstance().resetWithReCalcRoute();
        ArrayList<RoutePlanNode> navNodeList = RoutePlanModel.sNavNodeList;
        RoutePlanModel routePlanModel = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
        RoutePlanNode endNode = routePlanModel.getEndNode();
        RoutePlanNode myPostionNode = null;
        GeoPoint carPt = getCurrentGeoPoint();
        if (carPt != null && carPt.isValid()) {
            myPostionNode = new RoutePlanNode(carPt, 3, null, null);
        }
        if (myPostionNode == null) {
            myPostionNode = routePlanModel.getStartNode();
        }
        ArrayList<RoutePlanNode> nodeList = new ArrayList();
        nodeList.add(myPostionNode);
        if (navNodeList != null && navNodeList.size() >= 3) {
            for (int i = 1; i < navNodeList.size() - 1; i++) {
                RoutePlanNode viaNode = (RoutePlanNode) navNodeList.get(i);
                if (viaNode != null) {
                    nodeList.add(viaNode);
                }
            }
        }
        nodeList.add(endNode);
        BNRoutePlaner.getInstance().setComeFrom(2);
        BNRoutePlaner.getInstance().setEntry(2);
        BNRoutePlaner.getInstance().setGuideEndType(1);
        BNRoutePlaner.getInstance().setPointsToCalcRoute(nodeList, 0);
        RGNotificationController.getInstance().hideAllView(false, false);
        return true;
    }

    public boolean isViaPoint(GeoPoint geoPoint) {
        if (geoPoint == null) {
            return false;
        }
        ArrayList<RoutePlanNode> viaList = ((RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN)).getViaNodeList();
        if (viaList == null || viaList.size() < 1) {
            return false;
        }
        Iterator it = viaList.iterator();
        while (it.hasNext()) {
            RoutePlanNode node = (RoutePlanNode) it.next();
            if (node.mGeoPoint != null && node.mGeoPoint.equals(geoPoint)) {
                return true;
            }
        }
        return false;
    }
}
