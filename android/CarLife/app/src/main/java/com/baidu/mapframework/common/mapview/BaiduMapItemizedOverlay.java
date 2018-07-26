package com.baidu.mapframework.common.mapview;

import com.baidu.carlife.C0965R;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.ItemizedOverlay;
import com.baidu.platform.comapi.map.MapGLSurfaceView;

public class BaiduMapItemizedOverlay extends ItemizedOverlay {
    /* renamed from: a */
    private OnTapListener f18770a;
    /* renamed from: b */
    private MapGLSurfaceView f18771b;

    private static class Holder {
        /* renamed from: a */
        static final BaiduMapItemizedOverlay f18769a = new BaiduMapItemizedOverlay();

        private Holder() {
        }
    }

    public interface OnTapListener {
        boolean onTap(int i);

        boolean onTap(int i, int i2, GeoPoint geoPoint);

        boolean onTap(GeoPoint geoPoint, MapGLSurfaceView mapGLSurfaceView);
    }

    public static BaiduMapItemizedOverlay getInstance() {
        return Holder.f18769a;
    }

    private BaiduMapItemizedOverlay() {
        super(MapViewFactory.getInstance().getMapView().getContext().getResources().getDrawable(C0965R.drawable.icon_gcoding), MapViewFactory.getInstance().getMapView());
        this.f18771b = MapViewFactory.getInstance().getMapView();
    }

    public OnTapListener getOnTapListener() {
        return this.f18770a;
    }

    public void setOnTapListener(OnTapListener mOnTapListener) {
        this.f18770a = mOnTapListener;
    }

    public void show() {
        if (this.f18771b.getOverlays().contains(this)) {
            hide();
        }
        this.f18771b.addOverlay(this);
    }

    public void hide() {
        if (this.f18771b.getOverlays().contains(this)) {
            this.f18771b.removeOverlay(this);
        }
    }

    public final boolean onTap(int index) {
        if (this.f18770a == null || !this.f18770a.onTap(index)) {
            return super.onTap(index);
        }
        return true;
    }

    public final boolean onTap(GeoPoint p, MapGLSurfaceView mapView) {
        if (this.f18770a == null || !this.f18770a.onTap(p, mapView)) {
            return super.onTap(p, mapView);
        }
        return true;
    }

    public final boolean onTap(int index, int clickIndex, GeoPoint p) {
        if (this.f18770a == null || !this.f18770a.onTap(index, clickIndex, p)) {
            return super.onTap(index, clickIndex, p);
        }
        return true;
    }
}
