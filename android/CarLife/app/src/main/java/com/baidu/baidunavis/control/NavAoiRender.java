package com.baidu.baidunavis.control;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.entity.pb.RoutePoiRec;
import com.baidu.mapframework.common.mapview.MapInfoProvider;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.util.http.center.BNHttpBinaryResponseHandler;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.platform.comapi.map.MapStatus;
import com.baidu.platform.comapi.map.PoiDynamicMapOverlay;
import com.baidu.platform.comapi.util.SysOSAPIv2;

public enum NavAoiRender {
    INSTANCE;
    
    private static final String E_NODE_NAME = "enodename";
    private static final String E_NODE_UID = "enodeuid";
    private static final String HOST = "ps.map.baidu.com";
    private static final String HTTP_QT_KEY = "qt";
    private static final String HTTP_QT_VALUE = "navrec";
    private static final String PATH = "/orc/";
    private static final int PB_LENGTH_SIGN = 32;
    private static final String SCHEME = "http";
    private static final String SESSION_ID_KEY = "sessid";
    private static final String S_NODE_NAME = "snodename";
    private static final String S_NODE_UID = "snodeuid";
    private static final String TAG = "NavAoiRender";
    private String mBid;
    private PoiDynamicMapOverlay mOverlay;

    /* renamed from: com.baidu.baidunavis.control.NavAoiRender$1 */
    class C07791 extends BNHttpBinaryResponseHandler {
        C07791() {
        }

        public void onSuccess(int i, byte[] bytes) {
            try {
                NavLogUtils.m3003e(NavAoiRender.TAG, "query success, bytes length = " + bytes.length);
                NavAoiRender.this.updateMapLayer(RoutePoiRec.parseFrom(NavAoiRender.this.getExtData(bytes)).getRecommdata(0).getRecomdata().toByteArray());
            } catch (Exception e) {
                NavLogUtils.m3003e(NavAoiRender.TAG, "aoi info parsing error, not a RoutePoiRec");
            }
        }

        public void onFailure(int i, byte[] bytes, Throwable throwable) {
            NavLogUtils.m3003e(NavAoiRender.TAG, "request mz poi render date onFailure " + throwable.getMessage());
        }
    }

    public void renderAoi(String bid) {
        NavLogUtils.m3003e(TAG, "render " + bid);
        if (TextUtils.equals(bid, this.mBid)) {
            NavLogUtils.m3003e(TAG, "bid is already rendering, return");
            return;
        }
        this.mBid = bid;
        BNHttpCenter.getInstance().get(buildUrl(), null, new C07791(), new BNHttpParams());
    }

    public void renderAoiByStartBid() {
        Bundle bundle = new Bundle();
        if (BNRouteGuider.getInstance().getRouteInfoInUniform(2, bundle)) {
            String bid = bundle.getString("usStartBid");
            if (TextUtils.isEmpty(bid)) {
                NavLogUtils.m3003e(TAG, "usStartBid is empty");
                clear();
                return;
            }
            renderAoi(bid);
            return;
        }
        NavLogUtils.m3003e(TAG, "get bid return false");
    }

    private byte[] getExtData(byte[] data) {
        byte[] bArr = null;
        if (data != null && data.length >= 32) {
            int sign = ((((data[0] & 255) << 24) | ((data[1] & 255) << 16)) | ((data[2] & 255) << 8)) | (data[3] & 255);
            int len = data.length;
            if (sign == len - 32) {
                bArr = new byte[(len - 32)];
                for (int i = 0; i < bArr.length; i++) {
                    bArr[i] = data[i + 32];
                }
            }
        }
        return bArr;
    }

    private void updateMapLayer(byte[] data) {
        NavLogUtils.m3003e(TAG, "update Layer begin");
        if (BNavigator.getInstance().isNaviBegin()) {
            this.mOverlay = (PoiDynamicMapOverlay) MapViewFactory.getInstance().getMapView().getOverlay(PoiDynamicMapOverlay.class);
            if (this.mOverlay != null) {
                this.mOverlay.setRouteExtData(data);
                MapStatus st = MapInfoProvider.getMapInfo().getMapStatus();
                this.mOverlay.setLevel(st.level);
                this.mOverlay.setX(st.centerPtX);
                this.mOverlay.setY(st.centerPtY);
                this.mOverlay.setPoiUid("");
                this.mOverlay.setScene(3);
                this.mOverlay.setIsAccShow(true);
                this.mOverlay.SetOverlayShow(true);
                this.mOverlay.UpdateOverlay();
                NavLogUtils.m3003e(TAG, "update Layer end");
                return;
            }
            return;
        }
        NavLogUtils.m3003e(TAG, "aoi render not in navi, and return");
    }

    private String buildUrl() {
        Builder builder = new Builder();
        builder.scheme("http");
        builder.encodedAuthority(HOST);
        builder.encodedPath(PATH);
        builder.appendQueryParameter(HTTP_QT_KEY, HTTP_QT_VALUE);
        builder.appendQueryParameter(SESSION_ID_KEY, BNRoutePlaner.getInstance().getRoutePlanSessionIDAndMrsl("", ""));
        builder.appendQueryParameter(S_NODE_UID, this.mBid);
        builder.appendQueryParameter(S_NODE_NAME, null);
        builder.appendQueryParameter(E_NODE_UID, null);
        builder.appendQueryParameter(E_NODE_NAME, null);
        return Uri.parse(builder.build().toString() + SysOSAPIv2.getInstance().getPhoneInfoUrl()).buildUpon().build().toString();
    }

    public void clear() {
        if (!TextUtils.isEmpty(this.mBid)) {
            this.mBid = null;
            clearLayer();
        }
    }

    private void clearLayer() {
        if (this.mOverlay != null) {
            this.mOverlay.clear();
            this.mOverlay.SetOverlayShow(false);
            this.mOverlay.UpdateOverlay();
            this.mOverlay = null;
        }
    }
}
