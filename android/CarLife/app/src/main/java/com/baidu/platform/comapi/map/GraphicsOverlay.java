package com.baidu.platform.comapi.map;

import com.baidu.platform.comapi.util.JsonBuilder;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import java.util.ArrayList;
import java.util.List;

public class GraphicsOverlay extends InnerOverlay {
    private final List<Geometry> geometryList = new ArrayList();
    private boolean isNeedUpdate = true;

    public GraphicsOverlay() {
        super(36);
    }

    public GraphicsOverlay(AppBaseMap baseMap) {
        super(36, baseMap);
    }

    public boolean addGeometry(Geometry geometry) {
        synchronized (this.geometryList) {
            if (this.geometryList.contains(geometry)) {
                return false;
            }
            this.isNeedUpdate = this.geometryList.add(geometry);
            return this.isNeedUpdate;
        }
    }

    public boolean removeGeometry(Geometry geometry) {
        boolean z;
        synchronized (this.geometryList) {
            this.isNeedUpdate = this.geometryList.remove(geometry);
            z = this.isNeedUpdate;
        }
        return z;
    }

    public void setData(String strJson) {
        super.setData(strJson);
        this.isNeedUpdate = true;
    }

    public String getData() {
        if (this.isNeedUpdate) {
            synchronized (this.geometryList) {
                JsonBuilder builder = new JsonBuilder();
                builder.object();
                builder.key("dataset").arrayValue();
                for (Geometry g : this.geometryList) {
                    builder.objectValue(g.getData());
                }
                builder.endArrayValue();
                builder.endObject();
                setData(builder.getJson());
                this.isNeedUpdate = false;
            }
        }
        return super.getData();
    }

    public void clear() {
        synchronized (this.geometryList) {
            this.geometryList.clear();
        }
        super.clear();
    }

    public void forceUpdate() {
        this.isNeedUpdate = true;
        UpdateOverlay();
    }

    public boolean switchLayer(int iLayerSrc) {
        return this.mBaseMap.SwitchLayer(iLayerSrc, this.mLayerID);
    }
}
