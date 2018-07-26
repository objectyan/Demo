package com.baidu.platform.comapi.dataengine;

import android.os.Bundle;
import com.baidu.mapframework.nirvana.looper.MainLooperHandler;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.platform.comapi.UIMsg.m_AppUI;
import com.baidu.platform.comjni.engine.MessageProxy;
import com.baidu.platform.comjni.map.dataengine.NADataEngine;

public class MapDataEngine {
    /* renamed from: b */
    private static MapDataEngine f12703b = null;
    /* renamed from: d */
    private static MainLooperHandler f12704d = null;
    /* renamed from: a */
    private NADataEngine f12705a = null;
    /* renamed from: c */
    private C4769a f12706c = null;

    public static MapDataEngine getInstance() {
        if (f12703b == null) {
            f12703b = new MapDataEngine();
            if (!f12703b.m10988a()) {
                f12703b = null;
                return null;
            }
        }
        return f12703b;
    }

    private MapDataEngine() {
    }

    /* renamed from: a */
    boolean m10988a() {
        if (this.f12705a == null) {
            this.f12705a = new NADataEngine();
            if (this.f12705a.create() == 0) {
                this.f12705a = null;
                return false;
            }
            this.f12706c = new C4769a();
            f12704d = new MapDataEngine$1(this, Module.MAP_ENGINE, ScheduleConfig.forData());
            MessageProxy.registerMessageHandler(m_AppUI.V_WM_VDATAENGINE, f12704d);
        }
        return true;
    }

    public static void destroy() {
        if (f12703b != null) {
            if (f12703b.f12705a != null) {
                f12703b.f12705a.release();
                f12703b.f12705a = null;
                MessageProxy.unRegisterMessageHandler(m_AppUI.V_WM_VDATAENGINE, f12704d);
                f12704d = null;
                f12703b.f12706c = null;
            }
            f12703b = null;
        }
    }

    public void registDataEngineListener(MapDataEngineListener listener) {
        this.f12706c.a(listener);
    }

    public void removeDataEngineListener(MapDataEngineListener listener) {
        this.f12706c.b(listener);
    }

    public boolean getHotMapCityInfo() {
        return this.f12705a.getHotMapCityInfo(new Bundle());
    }

    public boolean getStreetCityInfo() {
        return this.f12705a.getStreetCityInfo(new Bundle());
    }

    public boolean setStreetSwitchToId(String switchId, int type) {
        return this.f12705a.streetSwitchToId(switchId, type);
    }

    public boolean setStreetSwitchToId(String switchId, String name, long geoX, long geoY) {
        return this.f12705a.streetSwitchToId(switchId, name, geoX, geoY);
    }

    public boolean setStreetSwitchByUID(String uid, String type) {
        return this.f12705a.streetSwitchByUID(uid, type);
    }

    public boolean setStreetSwitchToIID(String iid, String pid, boolean refreshMap) {
        return this.f12705a.streetSwitchToIID(iid, pid, refreshMap);
    }

    public String getCurrentStreetInfo(Bundle b) {
        return this.f12705a.getCurrentStreetInfo(b);
    }

    public String getCurrentStreetId() {
        return this.f12705a.getCurrentStreetId();
    }

    public boolean queryThumbImage(String panoId) {
        return this.f12705a.queryThumbImage(panoId);
    }

    public void cancelThumbImageRequest() {
        this.f12705a.cancelThumbImageRequest();
    }

    public void setStreetPOIUID(String strPoiUid) {
        this.f12705a.setStreetPOIUID(strPoiUid);
    }
}
