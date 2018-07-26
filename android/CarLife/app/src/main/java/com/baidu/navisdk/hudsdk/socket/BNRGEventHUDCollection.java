package com.baidu.navisdk.hudsdk.socket;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.comapi.geolocate.ILocationChangeListener;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider$OnRGSubStatusListener;
import com.baidu.navisdk.comapi.routeguide.OnRGInfoListener;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.MessageType;
import com.baidu.navisdk.hudsdk.BNRemoteConstants.ParamKey;
import com.baidu.navisdk.jni.nativeif.JNIGuidanceControl;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.model.params.MsgDefine;
import com.baidu.navisdk.ui.cruise.BCruiser;
import com.baidu.navisdk.ui.cruise.BCruiser.OnCruiseBeginListener;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.BNavigator$OnHUDSDKNavStatusCallback;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import org.json.JSONException;
import org.json.JSONObject;

public class BNRGEventHUDCollection {
    private static final int ROUTE_ID_DEFAULT_VALUE = 100;
    private static BNRGEventHUDCollection mInstance;
    private boolean isInit = false;
    private SendAllClientCallback mBroadcast;
    private ILocationChangeListener mLocationChangeListener = new C40943();
    private OnCruiseBeginListener mOnCruiseBeginListener = new C40965();
    private BNavigator$OnHUDSDKNavStatusCallback mOnHUDSDKNavStatusCallback = new C40954();
    private OnRGInfoListener mOnRGInfoListener = new C40921();
    private BNRouteGuider$OnRGSubStatusListener mOnRGSubStatusListener = new C40932();
    private int mRouteID = 100;

    /* renamed from: com.baidu.navisdk.hudsdk.socket.BNRGEventHUDCollection$1 */
    class C40921 implements OnRGInfoListener {
        C40921() {
        }

        public void onSimpleGuideInfoShow(Message msg) {
            BNRGEventHUDCollection.this.updateSimpleGuideData();
        }

        public void onSimpleGuideInfoUpdate(Message msg) {
            BNRGEventHUDCollection.this.updateSimpleGuideData();
        }

        public void onSimpleGuideInfoHide(Message msg) {
        }

        public void onTotalRemainDistTimeUpdate(Message msg) {
            BNRGEventHUDCollection.this.updateTotalDistAndTime();
        }

        public void onAssistInfoShow(Message msg) {
            BNRGEventHUDCollection.this.updateAssistInfo();
        }

        public void onAssistInfoUpdate(Message msg) {
            BNRGEventHUDCollection.this.updateAssistInfo();
        }

        public void onAssistInfoHide(Message msg) {
            BNRGEventHUDCollection.this.updateAssistInfo();
        }

        public void onRasterExpandMapShow(Message msg) {
            BNRGEventHUDCollection.this.sendExpandMapData(0, 0);
        }

        public void onRasterExpandMapUpdate(Message msg) {
            BNRGEventHUDCollection.this.sendExpandMapData(0, 1);
        }

        public void onRasterExpandMapHide(Message msg) {
            BNRGEventHUDCollection.this.sendExpandMapData(0, 2);
        }

        public void onDirectBoardShow(Message msg) {
            BNRGEventHUDCollection.this.sendExpandMapData(2, 0);
        }

        public void onDirectBoardUpdate(Message msg) {
            BNRGEventHUDCollection.this.sendExpandMapData(2, 1);
        }

        public void onDirectBoardHide(Message msg) {
            BNRGEventHUDCollection.this.sendExpandMapData(2, 2);
        }

        public void onVectorExpandMapShow(Message msg) {
            BNRGEventHUDCollection.this.sendExpandMapData(1, 0);
        }

        public void onVectorExpandMapUpdate(Message msg) {
            BNRGEventHUDCollection.this.sendExpandMapData(1, 1);
        }

        public void onVectorExpandMapHide(Message msg) {
            BNRGEventHUDCollection.this.sendExpandMapData(1, 2);
        }

        public void onCurRoadNameUpdate(Message msg) {
            BNRGEventHUDCollection.this.updateCurRoadName();
        }

        public void onHUDUpdate(Message msg) {
        }

        public void onRGSyncOperation(Message msg) {
        }

        public void onHighwayInfoShow(Message msg) {
            BNRGEventHUDCollection.this.updateServiceAreaInfo();
        }

        public void onHighwayInfoUpdate(Message msg) {
            BNRGEventHUDCollection.this.updateServiceAreaInfo();
        }

        public void onHighwayInfoHide(Message msg) {
            BNRGEventHUDCollection.this.updateServiceAreaInfo();
        }

        public void onSimpleBoardShow(Message msg) {
        }

        public void onSimpleBoardHide(Message msg) {
        }

        public void onSimpleBoardUpdate(Message msg) {
        }

        public void onDestStreetViewShow(Message msg) {
            BNRGEventHUDCollection.this.sendExpandMapData(3, 0);
        }

        public void onDestStreetViewUpdate(Message msg) {
            BNRGEventHUDCollection.this.sendExpandMapData(3, 1);
        }

        public void onDestStreetViewHide(Message msg) {
            BNRGEventHUDCollection.this.sendExpandMapData(3, 2);
        }

        public void onDestStreetViewStartDownload(Message msg) {
        }

        public void onDestStreetViewDownloadSuccess(Message msg) {
        }

        public void onOtherRGInfo(Message msg) {
            switch (msg.what) {
                case MsgDefine.MSG_NAVI_TYPE_HUD_GetRouteInfo /*4396*/:
                    BNRGEventHUDCollection.this.updateRouteInfo();
                    return;
                case MsgDefine.MSG_NAVI_TYPE_HUD_Tunnel_Update /*4397*/:
                    int isTunnel = msg.arg1;
                    Bundle tunnelInfo = new Bundle();
                    tunnelInfo.putInt("isTunnel", isTunnel);
                    try {
                        JSONObject hudTunnelUpdateJson = PacketJSONData.packetJSONData(MessageType.BNMessageTypeTunnelUpdate, tunnelInfo);
                        if (BNRGEventHUDCollection.this.mBroadcast != null) {
                            BNRGEventHUDCollection.this.mBroadcast.onBroadcast(hudTunnelUpdateJson);
                            return;
                        }
                        return;
                    } catch (JSONException e) {
                        e.printStackTrace();
                        return;
                    }
                case MsgDefine.MSG_NAVI_TYPE_HUD_ForwardCameras_Update /*4398*/:
                    BNRGEventHUDCollection.this.updateNearbyCameraInfo();
                    return;
                case MsgDefine.MSG_NAVI_TYPE_HUD_ShapeIdx_Update /*4399*/:
                    int curLocIndex = msg.arg1;
                    int fromStartDist = msg.arg2;
                    Bundle shapeIndexUpdate = new Bundle();
                    shapeIndexUpdate.putInt("curLocIndex", curLocIndex);
                    shapeIndexUpdate.putInt(ParamKey.KEY_FROM_START_DIST, fromStartDist);
                    try {
                        JSONObject shapeIndexUpdateJson = PacketJSONData.packetJSONData(119, shapeIndexUpdate);
                        if (BNRGEventHUDCollection.this.mBroadcast != null) {
                            BNRGEventHUDCollection.this.mBroadcast.onBroadcast(shapeIndexUpdateJson);
                            return;
                        }
                        return;
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        return;
                    }
                default:
                    return;
            }
        }

        public void onUGCEventTipsShow() {
        }

        public void onUGCEventTipsHide() {
        }

        public void onGPSWeak(Message msg) {
        }
    }

    /* renamed from: com.baidu.navisdk.hudsdk.socket.BNRGEventHUDCollection$2 */
    class C40932 implements BNRouteGuider$OnRGSubStatusListener {
        C40932() {
        }

        public void onRoutePlanYawing(Message arg0) {
            try {
                JSONObject rpYawingJson = PacketJSONData.packetJSONData(112, null);
                if (BNRGEventHUDCollection.this.mBroadcast != null) {
                    BNRGEventHUDCollection.this.mBroadcast.onBroadcast(rpYawingJson);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public void onReRouteComplete(Message arg0) {
            try {
                JSONObject rpYawCompleteJson = PacketJSONData.packetJSONData(113, null);
                if (BNRGEventHUDCollection.this.mBroadcast != null) {
                    BNRGEventHUDCollection.this.mBroadcast.onBroadcast(rpYawCompleteJson);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            BNRGEventHUDCollection.this.notifyCarFree();
            BNRGEventHUDCollection.this.updateDestInfo();
            BNRGEventHUDCollection.this.updateSimpleGuideData();
            BNRGEventHUDCollection.this.updateTotalDistAndTime();
        }

        public void onReRouteCarFree(Message msg) {
            BNRGEventHUDCollection.this.notifyCarFree();
        }

        public void onArriveDestNear(Message arg0) {
        }

        public void onArriveDest(Message arg0) {
        }
    }

    /* renamed from: com.baidu.navisdk.hudsdk.socket.BNRGEventHUDCollection$3 */
    class C40943 extends ILocationChangeListener {
        C40943() {
        }

        public void onLocationChange(LocData locData) {
            try {
                double engineLon;
                double engineLat;
                Bundle carPointInfo = new Bundle();
                GeoPoint carPt = RGEngineControl.getInstance().getCarGeoPoint();
                if (carPt != null) {
                    engineLon = ((double) carPt.getLongitudeE6()) / 100000.0d;
                    engineLat = ((double) carPt.getLatitudeE6()) / 100000.0d;
                } else {
                    engineLon = locData.longitude;
                    engineLat = locData.latitude;
                }
                Bundle engineCarLocation = CoordinateTransformUtil.transferGCJ02ToWGS84(engineLon, engineLat);
                carPointInfo.putDouble("direction", (double) locData.direction);
                carPointInfo.putDouble("longitude", engineCarLocation.getDouble("LLx"));
                carPointInfo.putDouble("latitude", engineCarLocation.getDouble("LLy"));
                JSONObject carSpeedJson = PacketJSONData.packetJSONData(116, carPointInfo);
                if (BNRGEventHUDCollection.this.mBroadcast != null) {
                    BNRGEventHUDCollection.this.mBroadcast.onBroadcast(carSpeedJson);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        public void onGpsStatusChange(boolean enabled, boolean available) {
            BNRGEventHUDCollection.this.handleGpsStatusChange(enabled, available);
        }

        public void onWGS84LocationChange(LocData wgs84Data, LocData gcj02LocData) {
        }
    }

    /* renamed from: com.baidu.navisdk.hudsdk.socket.BNRGEventHUDCollection$4 */
    class C40954 implements BNavigator$OnHUDSDKNavStatusCallback {
        C40954() {
        }

        public void onNaviStatus(boolean isStart) {
            if (isStart) {
                try {
                    JSONObject naviStartJson = PacketJSONData.packetJSONData(108, null);
                    if (BNRGEventHUDCollection.this.mBroadcast != null) {
                        BNRGEventHUDCollection.this.mBroadcast.onBroadcast(naviStartJson);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                BNRGEventHUDCollection.this.updateDestInfo();
                BNRGEventHUDCollection.this.updateSimpleGuideData();
                BNRGEventHUDCollection.this.updateTotalDistAndTime();
                return;
            }
            try {
                JSONObject naviEndJson = PacketJSONData.packetJSONData(109, null);
                if (BNRGEventHUDCollection.this.mBroadcast != null) {
                    BNRGEventHUDCollection.this.mBroadcast.onBroadcast(naviEndJson);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.hudsdk.socket.BNRGEventHUDCollection$5 */
    class C40965 implements OnCruiseBeginListener {
        C40965() {
        }

        public void onCruiseBegin(boolean isCruiseBegin) {
            if (isCruiseBegin) {
                try {
                    JSONObject cruiseStartJson = PacketJSONData.packetJSONData(110, null);
                    if (BNRGEventHUDCollection.this.mBroadcast != null) {
                        BNRGEventHUDCollection.this.mBroadcast.onBroadcast(cruiseStartJson);
                        return;
                    }
                    return;
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
            try {
                JSONObject cruiseEndJson = PacketJSONData.packetJSONData(111, null);
                if (BNRGEventHUDCollection.this.mBroadcast != null) {
                    BNRGEventHUDCollection.this.mBroadcast.onBroadcast(cruiseEndJson);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public interface SendAllClientCallback {
        void onBroadcast(JSONObject jSONObject);
    }

    private BNRGEventHUDCollection() {
    }

    public static BNRGEventHUDCollection getInstance() {
        if (mInstance == null) {
            mInstance = new BNRGEventHUDCollection();
        }
        return mInstance;
    }

    public int updateRouteID() {
        this.mRouteID++;
        if (this.mRouteID <= 0) {
            this.mRouteID = 100;
        }
        return this.mRouteID;
    }

    public void unInit() {
        if (this.isInit) {
            BNRouteGuider.getInstance().removeRGSubStatusListener(this.mOnRGSubStatusListener);
            BNRouteGuider.getInstance().removeRGInfoListeners(this.mOnRGInfoListener);
            BNSysLocationManager.getInstance().removeLocationListener(this.mLocationChangeListener);
            BCruiser.getInstance().removeRGInfoListeners(this.mOnRGInfoListener);
            BNavigator.getInstance().setOnHUDSDKnavStatusCallback(null);
            BCruiser.getInstance().removeOnCruiseBeginListener(this.mOnCruiseBeginListener);
            this.isInit = false;
            JNIGuidanceControl.getInstance().SetHUDRouteGuideType(0);
        }
    }

    public void init(Context context, SendAllClientCallback callback) {
        if (!this.isInit) {
            this.isInit = true;
            this.mBroadcast = callback;
            BNRouteGuider.getInstance().addRGInfoListeners(this.mOnRGInfoListener);
            BNRouteGuider.getInstance().addRGSubStatusListener(this.mOnRGSubStatusListener);
            BCruiser.getInstance().addRGInfoListeners(this.mOnRGInfoListener);
            BNSysLocationManager.getInstance().startNaviLocate(context);
            BNSysLocationManager.getInstance().addLocationListener(this.mLocationChangeListener);
            BNavigator.getInstance().setOnHUDSDKnavStatusCallback(this.mOnHUDSDKNavStatusCallback);
            BCruiser.getInstance().addOnCruiseBeginListener(this.mOnCruiseBeginListener);
            JNIGuidanceControl.getInstance().SetHUDRouteGuideType(8191);
        }
    }

    private void sendExpandMapData(int type, int showState) {
        try {
            JSONObject enlargeRoadJson = PacketJSONData.packetEnlargeRoad(type, showState);
            if (this.mBroadcast != null) {
                this.mBroadcast.onBroadcast(enlargeRoadJson);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void updateSimpleGuideData() {
        try {
            JSONObject maneuverJson = PacketJSONData.packetJSONData(100, null);
            if (this.mBroadcast != null) {
                this.mBroadcast.onBroadcast(maneuverJson);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            JSONObject curRoadJson = PacketJSONData.packetJSONData(104, null);
            if (this.mBroadcast != null) {
                this.mBroadcast.onBroadcast(curRoadJson);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void updateTotalDistAndTime() {
        try {
            JSONObject remainJson = PacketJSONData.packetJSONData(103, null);
            if (this.mBroadcast != null) {
                this.mBroadcast.onBroadcast(remainJson);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void updateAssistInfo() {
        try {
            JSONObject assistantJson = PacketJSONData.packetJSONData(102, null);
            if (this.mBroadcast != null) {
                this.mBroadcast.onBroadcast(assistantJson);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void updateCurRoadName() {
        try {
            JSONObject currentRoadJson = PacketJSONData.packetJSONData(104, null);
            if (this.mBroadcast != null) {
                this.mBroadcast.onBroadcast(currentRoadJson);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void updateServiceAreaInfo() {
        try {
            JSONObject serviceAreaJson = PacketJSONData.packetJSONData(101, null);
            if (this.mBroadcast != null) {
                this.mBroadcast.onBroadcast(serviceAreaJson);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void handleGpsStatusChange(boolean enabled, boolean available) {
        if (enabled && available) {
            try {
                JSONObject gpsNormalJson = PacketJSONData.packetJSONData(107, null);
                if (this.mBroadcast != null) {
                    this.mBroadcast.onBroadcast(gpsNormalJson);
                    return;
                }
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        try {
            JSONObject gpsLostJson = PacketJSONData.packetJSONData(106, null);
            if (this.mBroadcast != null) {
                this.mBroadcast.onBroadcast(gpsLostJson);
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private void updateRouteInfo() {
        updateRouteID();
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("routeId", this.mRouteID);
            JSONObject routeInfoJson = PacketJSONData.packetJSONData(120, bundle);
            if (this.mBroadcast != null) {
                this.mBroadcast.onBroadcast(routeInfoJson);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void updateNearbyCameraInfo() {
        try {
            JSONObject cameraJson = PacketJSONData.packetJSONData(121, null);
            if (this.mBroadcast != null) {
                this.mBroadcast.onBroadcast(cameraJson);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void updateDestInfo() {
        RoutePlanModel routePlanModel = (RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN);
        if (routePlanModel != null) {
            RoutePlanNode endNode = routePlanModel.getEndNode();
            int distance = routePlanModel.getTotalDistanceInt();
            Bundle destInfoBundle = new Bundle();
            Bundle endPointBundle = CoordinateTransformUtil.transferGCJ02ToWGS84(((double) endNode.getLongitudeE6()) / 100000.0d, ((double) endNode.getLatitudeE6()) / 100000.0d);
            destInfoBundle.putInt("totalDist", distance);
            destInfoBundle.putDouble("longitude", endPointBundle.getDouble("LLx"));
            destInfoBundle.putDouble("latitude", endPointBundle.getDouble("LLy"));
            try {
                JSONObject destInfoJson = PacketJSONData.packetJSONData(115, destInfoBundle);
                if (this.mBroadcast != null) {
                    this.mBroadcast.onBroadcast(destInfoJson);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void notifyCarFree() {
        try {
            JSONObject carFreeStatusJson = PacketJSONData.packetJSONData(MessageType.BNMessageTypeCarFreeStatus, null);
            if (this.mBroadcast != null) {
                this.mBroadcast.onBroadcast(carFreeStatusJson);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
