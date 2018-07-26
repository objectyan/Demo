package com.baidu.navi.favorite.model;

import java.util.ArrayList;

public class FavoriteSyncRequestModel {
    public String bduid;
    public String bduss;
    public String datas;
    public String lastver;
    public String limit;
    private ArrayList<FavSyncPoi> syncPois = new ArrayList();

    public ArrayList<FavSyncPoi> getSyncPois() {
        return this.syncPois;
    }

    public void addSyncPoi(FavSyncPoi poi) {
        this.syncPois.add(poi);
    }

    public void clean() {
        this.syncPois.clear();
    }
}
