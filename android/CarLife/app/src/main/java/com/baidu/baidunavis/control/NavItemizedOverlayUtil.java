package com.baidu.baidunavis.control;

import android.os.Bundle;
import android.view.MotionEvent;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.mapframework.common.mapview.BaiduMapItemizedOverlay;
import com.baidu.mapframework.common.mapview.BaseMapViewListener;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.map.BNMapManager;
import com.baidu.nplatform.comapi.map.ItemizedOverlayUtil.MapWrapper;
import com.baidu.nplatform.comapi.map.ItemizedOverlayUtil.OnTapListener;
import com.baidu.nplatform.comapi.map.OverlayItem;
import com.baidu.nplatform.comapi.map.OverlayItem.CoordType;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapGLSurfaceView;
import com.baidu.platform.comapi.map.MapObj;

public class NavItemizedOverlayUtil {
    private static final String TAG = NavItemizedOverlayUtil.class.getSimpleName();
    private OnTapListener navOnTapListener;

    /* renamed from: com.baidu.baidunavis.control.NavItemizedOverlayUtil$2 */
    class C08022 implements MapWrapper {

        /* renamed from: com.baidu.baidunavis.control.NavItemizedOverlayUtil$2$1 */
        class C08011 implements BaiduMapItemizedOverlay.OnTapListener {
            C08011() {
            }

            public boolean onTap(int index) {
                return NavItemizedOverlayUtil.this.navOnTapListener.onTap(index);
            }

            public boolean onTap(GeoPoint p, MapGLSurfaceView mapView) {
                com.baidu.nplatform.comapi.basestruct.GeoPoint navPoint = null;
                if (p != null) {
                    navPoint = new com.baidu.nplatform.comapi.basestruct.GeoPoint(p.getLongitudeE6(), p.getLatitudeE6());
                }
                return NavItemizedOverlayUtil.this.navOnTapListener.onTap(navPoint);
            }

            public boolean onTap(int index, int clickIndex, GeoPoint p) {
                com.baidu.nplatform.comapi.basestruct.GeoPoint navPoint = null;
                if (p != null) {
                    navPoint = new com.baidu.nplatform.comapi.basestruct.GeoPoint(p.getLongitudeE6(), p.getLatitudeE6());
                }
                return NavItemizedOverlayUtil.this.navOnTapListener.onTap(index, clickIndex, navPoint);
            }
        }

        C08022() {
        }

        public void showItemizedOverlay(boolean show) {
            NavLogUtils.m3003e(NavItemizedOverlayUtil.TAG, "showItemizedOverlay: show --> " + show);
            if (show) {
                BaiduMapItemizedOverlay.getInstance().show();
            } else {
                BaiduMapItemizedOverlay.getInstance().hide();
            }
        }

        public void addMapItem(OverlayItem navItem) {
            NavLogUtils.m3003e(NavItemizedOverlayUtil.TAG, "addMapItem: --> " + navItem);
            if (navItem != null) {
                BaiduMapItemizedOverlay.getInstance().addItem(NavItemizedOverlayUtil.this.convert2MapOverlayItem(navItem));
            }
        }

        public void removeMapItem(OverlayItem navItem) {
            NavLogUtils.m3003e(NavItemizedOverlayUtil.TAG, "removeMapItem: --> " + navItem);
            if (navItem != null) {
                BaiduMapItemizedOverlay.getInstance().removeItem(NavItemizedOverlayUtil.this.convert2MapOverlayItem(navItem));
            }
        }

        public void removeAllItems() {
            NavLogUtils.m3003e(NavItemizedOverlayUtil.TAG, "removeAllItems: --> ");
            BaiduMapItemizedOverlay.getInstance().removeAll();
        }

        public void refresh() {
            NavLogUtils.m3003e(NavItemizedOverlayUtil.TAG, "refresh: --> ");
            MapViewFactory.getInstance().getMapView().refresh(BaiduMapItemizedOverlay.getInstance());
        }

        public void setOnTapListener(OnTapListener onTapListener) {
            NavLogUtils.m3003e(NavItemizedOverlayUtil.TAG, "setOnTapListener: onTapListener --> " + onTapListener);
            NavItemizedOverlayUtil.this.navOnTapListener = onTapListener;
            if (NavItemizedOverlayUtil.this.navOnTapListener == null) {
                BaiduMapItemizedOverlay.getInstance().setOnTapListener(null);
            } else {
                BaiduMapItemizedOverlay.getInstance().setOnTapListener(new C08011());
            }
        }

        public OnTapListener getOnTapListener() {
            return NavItemizedOverlayUtil.this.navOnTapListener;
        }
    }

    private static class Holder {
        static final NavItemizedOverlayUtil OVERLAY = new NavItemizedOverlayUtil();

        private Holder() {
        }
    }

    public interface ItemClickListener {
        void ugcItemClick(MapObj mapObj, boolean z);
    }

    public static NavItemizedOverlayUtil getInstance() {
        return Holder.OVERLAY;
    }

    private NavItemizedOverlayUtil() {
    }

    public void initWrapper(final boolean isIpoNavi, final ItemClickListener listener) {
        NavLogUtils.m3003e(TAG, "initWrapper: --> ");
        NavMapManager.getInstance().setBaseMapViewListener(new BaseMapViewListener() {
            protected void onCompassClick(MapObj mapObj) {
            }

            protected void onLocationPointClick(MapObj mapObj) {
            }

            protected void onFavouritePoiClick(MapObj mapObj) {
            }

            protected void onPoiMarkerClick(MapObj mapObj) {
                if (mapObj != null && mapObj.geoPt != null) {
                    mapObj.strText = mapObj.strText.replaceAll("\\\\", "");
                    Bundle b = NavMapAdapter.MC2LLE6(mapObj.geoPt.getIntX(), mapObj.geoPt.getIntY());
                    if (b != null && !b.isEmpty()) {
                        com.baidu.nplatform.comapi.basestruct.GeoPoint geoPoint = new com.baidu.nplatform.comapi.basestruct.GeoPoint(b.getInt("LLx"), b.getInt("LLy"));
                        MapItem item = new MapItem();
                        item.mTitle = mapObj.strText;
                        item.mLongitude = geoPoint.getLongitudeE6();
                        item.mLatitude = geoPoint.getLatitudeE6();
                        item.mUid = mapObj.strUid;
                        BNMapController.getInstance().notifyMapObservers(1, 264, item);
                    }
                }
            }

            public void onLongPress(MotionEvent motionEvent) {
                super.onLongPress(motionEvent);
                BNMapController.getInstance().notifyMapObservers(2, 517, motionEvent);
            }

            public void onClickedBackground(int i, int i2) {
                super.onClickedBackground(i, i2);
                BNMapController.getInstance().notifyMapObservers(2, 514, MotionEvent.obtain(System.currentTimeMillis(), System.currentTimeMillis(), 0, (float) i, (float) i2, 0));
            }

            public void onClickedTrafficUgcEventMapObj(MapObj mapObj, boolean bchecked) {
                if (mapObj == null) {
                    return;
                }
                if (!isIpoNavi) {
                    BNavigator.getInstance().showUgcDetailView(mapObj.strUid, bchecked);
                } else if (listener != null) {
                    listener.ugcItemClick(mapObj, bchecked);
                }
            }
        });
        BNMapManager.getInstance().setItemizedOverlayMapWrapper(new C08022());
    }

    public void unInitWrapper() {
        NavLogUtils.m3003e(TAG, "unInitWrapper: --> ");
        NavMapManager.getInstance().resetBaseMapViewListener();
    }

    public OnTapListener getNavOnTapListener() {
        return this.navOnTapListener;
    }

    public void setNavOnTapListener(OnTapListener navOnTapListener) {
        this.navOnTapListener = navOnTapListener;
    }

    private com.baidu.platform.comapi.map.OverlayItem convert2MapOverlayItem(OverlayItem navItem) {
        if (navItem == null) {
            return null;
        }
        com.baidu.nplatform.comapi.basestruct.GeoPoint navPoint = navItem.getPoint();
        com.baidu.platform.comapi.map.OverlayItem mapItem = new com.baidu.platform.comapi.map.OverlayItem(new GeoPoint(navPoint.getLatitudeE6(), navPoint.getLongitudeE6()), navItem.getTitle(), navItem.getSnippet());
        if (navItem.getClickRect() != null && navItem.getClickRect().size() > 0) {
            mapItem.setClickRect(navItem.getClickRect());
        }
        mapItem.setMarker(navItem.getMarker());
        mapItem.setAnchor(navItem.getAnchorX(), navItem.getAnchorY());
        mapItem.setAnimate(navItem.getAnimate());
        mapItem.setCoordType(navItem.getCoordType() == CoordType.CoordType_BD09LL ? com.baidu.platform.comapi.map.OverlayItem.CoordType.CoordType_BD09LL : com.baidu.platform.comapi.map.OverlayItem.CoordType.CoordType_BD09);
        mapItem.setLevel(navItem.getLevel());
        mapItem.setMask(navItem.getMask());
        return mapItem;
    }
}
