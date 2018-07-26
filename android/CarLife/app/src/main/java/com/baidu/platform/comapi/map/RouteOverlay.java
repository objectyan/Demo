package com.baidu.platform.comapi.map;

import android.os.Bundle;
import com.baidu.entity.pb.Bus;
import com.baidu.entity.pb.WalkPlan;
import com.baidu.platform.comapi.map.provider.BikeRouteProvider;
import com.baidu.platform.comapi.map.provider.BusRouteProvider;
import com.baidu.platform.comapi.map.provider.RouteBookRouteProvider;
import com.baidu.platform.comapi.map.provider.ShBikeRouteProvider;
import com.baidu.platform.comapi.map.provider.WalkRouteProvider;
import com.baidu.platform.comapi.search.convert.ResultCache;
import com.baidu.platform.comapi.search.convert.ResultCache$Item;
import com.baidu.platform.comjni.map.basemap.AppBaseMap;
import com.google.protobuf.micro.MessageMicro;
import java.util.ArrayList;

public class RouteOverlay extends InnerOverlay {
    private boolean mHasIndoor = false;
    private ArrayList<WalkPlan> mWalkList = new ArrayList();
    public MessageMicro messageLite = null;
    int routeIndex;
    private WalkPlanTag walkPlanTag = WalkPlanTag.none;

    public enum WalkPlanTag {
        none,
        walk,
        bike,
        routebook,
        sharedbike
    }

    public RouteOverlay() {
        super(12);
    }

    public RouteOverlay(AppBaseMap baseMap) {
        super(12, baseMap);
    }

    public boolean addedToMapView() {
        if (this.mBaseMap == null) {
            return false;
        }
        this.mLayerID = this.mBaseMap.AddLayer(2, 0, "itsroute");
        if (this.mLayerID == 0) {
            return false;
        }
        this.mBaseMap.SetLayersClickable(this.mLayerID, true);
        this.mBaseMap.ShowLayers(this.mLayerID, false);
        return true;
    }

    public void setBusRouteIndex(int index) {
        this.routeIndex = index;
    }

    public void setBikeTag(WalkPlanTag tag) {
        this.walkPlanTag = tag;
    }

    public void setWalkTag(WalkPlanTag tag, boolean hasIndoor) {
        this.walkPlanTag = tag;
        this.mHasIndoor = hasIndoor;
    }

    public void setRouteBookTag(ArrayList<WalkPlan> walkPlanList, WalkPlanTag tag) {
        this.walkPlanTag = tag;
        this.mWalkList = walkPlanList;
        if (walkPlanList != null && walkPlanList.size() != 0) {
            this.messageLite = (MessageMicro) walkPlanList.get(0);
        }
    }

    public void setShBikeTag(WalkPlanTag tag) {
        this.walkPlanTag = tag;
    }

    public Bundle getParam() {
        Bundle param = new Bundle();
        param.putInt("routeIndex", this.routeIndex);
        return param;
    }

    public int getType() {
        return -1;
    }

    public String getData() {
        String json = super.getData();
        if (this.messageLite == null) {
            ResultCache$Item cache = ResultCache.getInstance().get(json);
            if (cache != null) {
                this.messageLite = cache.messageLite;
            }
        }
        if (this.messageLite != null) {
            if (this.messageLite instanceof WalkPlan) {
                if (this.walkPlanTag == WalkPlanTag.walk) {
                    return getWalk((WalkPlan) this.messageLite);
                }
                if (this.walkPlanTag == WalkPlanTag.bike) {
                    return getBike((WalkPlan) this.messageLite);
                }
                if (this.walkPlanTag == WalkPlanTag.routebook) {
                    return getRouteBook(this.mWalkList);
                }
                if (this.walkPlanTag == WalkPlanTag.sharedbike) {
                    return getShBike((WalkPlan) this.messageLite);
                }
                this.messageLite = null;
                this.walkPlanTag = WalkPlanTag.none;
            } else if (this.messageLite instanceof Bus) {
                return getBus((Bus) this.messageLite);
            }
        }
        return super.getData();
    }

    private String getWalk(WalkPlan message) {
        WalkRouteProvider provider = new WalkRouteProvider(message, this.mHasIndoor);
        this.messageLite = null;
        this.walkPlanTag = WalkPlanTag.none;
        this.mHasIndoor = false;
        return provider.getRenderData();
    }

    private String getShBike(WalkPlan message) {
        ShBikeRouteProvider provider = new ShBikeRouteProvider(message);
        this.messageLite = null;
        this.walkPlanTag = WalkPlanTag.none;
        this.mHasIndoor = false;
        return provider.getRenderData();
    }

    private String getBike(WalkPlan message) {
        BikeRouteProvider provider = new BikeRouteProvider(message);
        this.messageLite = null;
        this.walkPlanTag = WalkPlanTag.none;
        return provider.getRenderData();
    }

    private String getRouteBook(ArrayList<WalkPlan> walkPlanList) {
        RouteBookRouteProvider provider = new RouteBookRouteProvider(walkPlanList);
        this.messageLite = null;
        this.walkPlanTag = WalkPlanTag.none;
        this.mWalkList = null;
        return provider.getRenderData();
    }

    private String getBus(Bus message) {
        BusRouteProvider provider = new BusRouteProvider(message, this.routeIndex);
        this.messageLite = null;
        return provider.getRenderData();
    }

    public void setPbData(MessageMicro messageLite) {
        this.messageLite = messageLite;
    }

    public boolean switchLayer(int iLayerSrc) {
        return this.mBaseMap.SwitchLayer(iLayerSrc, this.mLayerID);
    }
}
