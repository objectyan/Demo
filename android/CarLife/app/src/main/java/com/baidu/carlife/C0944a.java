package com.baidu.carlife;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.ItsMapObj;
import com.baidu.platform.comapi.map.MapObj;
import com.baidu.platform.comapi.map.MapViewListener;
import java.util.List;

/* compiled from: BaseMapViewListener */
/* renamed from: com.baidu.carlife.a */
public abstract class C0944a implements MapViewListener {
    /* renamed from: a */
    public static final String f2399a = C0944a.class.getSimpleName();

    /* renamed from: a */
    protected abstract void mo1357a(MapObj mapObj);

    /* renamed from: b */
    protected abstract void mo1358b(MapObj mapObj);

    /* renamed from: c */
    protected abstract void mo1359c(MapObj mapObj);

    /* renamed from: d */
    protected abstract void mo1360d(MapObj mapObj);

    public void onClickedMapObj(List<MapObj> mapObjArray) {
        if (mapObjArray != null && mapObjArray.size() != 0) {
            MapObj obj = (MapObj) mapObjArray.get(0);
            if (obj.nType != 17 || !TextUtils.isEmpty(obj.strText)) {
                switch (obj.nType) {
                    case 6:
                    case 18:
                    case 19:
                        return;
                    default:
                        mo1360d(obj);
                        return;
                }
            }
        }
    }

    public void onClickedPoiObj(List<MapObj> list) {
    }

    public void onClickedRouteObj(List<MapObj> list) {
    }

    public void onClickedItsMapObj(List<ItsMapObj> list) {
    }

    public void onMapAnimationFinish() {
        Log.d(f2399a, "onMapAnimationFinish");
    }

    public void onClickedItem(int index, GeoPoint point, int layerId) {
    }

    public void onClickedItem(int index, int clickIndex, GeoPoint point, int layerId) {
    }

    public void onClickedPopup(int index) {
    }

    public void onClickedStreetPopup(String b) {
    }

    public void onClickedBackground(int x, int y) {
    }

    public void onClickedStreetIndoorPoi(MapObj mapObj) {
    }

    public void onClickStreetArrow(MapObj mapObj) {
    }

    public void onClickedRouteLabelObj(List<MapObj> list) {
    }

    public void onClickStreetSurface(MapObj mapObj) {
    }

    public void onClickedOPPoiEventMapObj(MapObj mapObj) {
    }

    public void onClickedParticleEventMapObj(List<MapObj> list) {
    }

    public void onClickedTrafficUgcEventMapObj(MapObj mapObj, boolean bchecked) {
    }
}
