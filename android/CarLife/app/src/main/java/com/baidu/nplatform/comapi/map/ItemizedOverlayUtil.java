package com.baidu.nplatform.comapi.map;

import android.graphics.drawable.Drawable;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class ItemizedOverlayUtil {
    private MapWrapper mMapWrapper;

    public interface OnTapListener {
        boolean onTap(int i);

        boolean onTap(int i, int i2, GeoPoint geoPoint);

        boolean onTap(GeoPoint geoPoint);
    }

    private static class Holder {
        static final ItemizedOverlayUtil OVERLAY = new ItemizedOverlayUtil();

        private Holder() {
        }
    }

    public interface MapWrapper {
        void addMapItem(OverlayItem overlayItem);

        OnTapListener getOnTapListener();

        void refresh();

        void removeAllItems();

        void removeMapItem(OverlayItem overlayItem);

        void setOnTapListener(OnTapListener onTapListener);

        void showItemizedOverlay(boolean z);
    }

    public static ItemizedOverlayUtil getInstance() {
        return Holder.OVERLAY;
    }

    private ItemizedOverlayUtil() {
    }

    public void show() {
        if (getMapWrapper() != null) {
            getMapWrapper().showItemizedOverlay(true);
        }
    }

    public void hide() {
        if (getMapWrapper() != null) {
            getMapWrapper().showItemizedOverlay(false);
        }
    }

    public OverlayItem getOverlayItem(GeoPoint geoPoint, Drawable drawable) {
        OverlayItem navItem = new OverlayItem(geoPoint, "mItem", "");
        navItem.setMarker(drawable);
        return navItem;
    }

    public void addMapItem(OverlayItem item) {
        if (getMapWrapper() != null) {
            getMapWrapper().addMapItem(item);
        }
    }

    public void removeMapItem(OverlayItem item) {
        if (getMapWrapper() != null) {
            getMapWrapper().removeMapItem(item);
        }
    }

    public void removeAllItems() {
        if (getMapWrapper() != null) {
            getMapWrapper().removeAllItems();
        }
    }

    public void refresh() {
        if (getMapWrapper() != null) {
            getMapWrapper().refresh();
        }
    }

    public OnTapListener getOnTapListener() {
        if (getMapWrapper() != null) {
            return getMapWrapper().getOnTapListener();
        }
        return null;
    }

    public void setOnTapListener(OnTapListener mOnTapListener) {
        if (getMapWrapper() != null) {
            getMapWrapper().setOnTapListener(mOnTapListener);
        }
    }

    public MapWrapper getMapWrapper() {
        return this.mMapWrapper;
    }

    public void setMapWrapper(MapWrapper mMapWrapper) {
        this.mMapWrapper = mMapWrapper;
    }
}
