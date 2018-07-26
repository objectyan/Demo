package com.baidu.baidumaps.p042f.p046b;

import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.mapframework.common.mapview.BaiduMapItemizedOverlay;
import com.baidu.mapframework.common.mapview.BaiduMapItemizedOverlay.OnTapListener;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.platform.comapi.map.InnerOverlay;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.map.OverlayItem;
import java.util.ArrayList;

/* compiled from: DrawRouteUtil */
/* renamed from: com.baidu.baidumaps.f.b.a */
public class C0710a {
    /* renamed from: a */
    private MapGLSurfaceView f2308a;
    /* renamed from: b */
    private BaiduMapItemizedOverlay f2309b;

    /* compiled from: DrawRouteUtil */
    /* renamed from: com.baidu.baidumaps.f.b.a$a */
    private static class C0709a {
        /* renamed from: a */
        private static final C0710a f2307a = new C0710a();

        private C0709a() {
        }
    }

    /* renamed from: a */
    public static C0710a m2996a() {
        return C0709a.f2307a;
    }

    private C0710a() {
        this.f2308a = null;
        this.f2308a = MapViewFactory.getInstance().getMapView();
    }

    /* renamed from: c */
    private InnerOverlay m2997c(int mapOverlayId) {
        try {
            return (InnerOverlay) MapViewFactory.getInstance().getMapView().getOverlay(mapOverlayId);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public boolean m3000a(int mapOverlayId) {
        InnerOverlay overlay = m2997c(mapOverlayId);
        if (overlay != null) {
            boolean showing = overlay.IsOverlayShow();
            NavLogUtils.m3003e("DrawRouteUtil", "isOverlayShowing: --> showing: " + showing + ", overlay: " + overlay);
            return showing;
        }
        NavLogUtils.m3003e("DrawRouteUtil", "isOverlayShowing: --> showing: false, mapOverlayId: " + mapOverlayId);
        return false;
    }

    /* renamed from: a */
    public void m2998a(int mapOverlayId, boolean show) {
        InnerOverlay overlay = m2997c(mapOverlayId);
        if (overlay != null) {
            overlay.SetOverlayShow(show);
            overlay.UpdateOverlay();
        }
    }

    /* renamed from: b */
    public void m3002b() {
        if (this.f2309b != null) {
            this.f2309b.hide();
            this.f2309b.removeAll();
        }
    }

    /* renamed from: b */
    public OverlayItem m3001b(int index) {
        if (this.f2309b != null) {
            return this.f2309b.getItem(index);
        }
        return null;
    }

    /* renamed from: a */
    public void m2999a(ArrayList<OverlayItem> items, OnTapListener onTapListener) {
        if (this.f2309b == null) {
            this.f2309b = BaiduMapItemizedOverlay.getInstance();
            this.f2308a.addOverlay(this.f2309b);
        }
        if (this.f2308a.getOverlays().contains(this.f2309b)) {
            this.f2308a.removeOverlay(this.f2309b);
        }
        this.f2309b.removeAll();
        this.f2309b.addItem(items);
        if (onTapListener != null) {
            this.f2309b.setOnTapListener(onTapListener);
        } else {
            this.f2309b.setOnTapListener(null);
        }
        this.f2308a.addOverlay(this.f2309b);
    }
}
