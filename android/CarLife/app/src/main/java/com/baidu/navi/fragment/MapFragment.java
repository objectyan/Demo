package com.baidu.navi.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.carlife.C0965R;
import com.baidu.mapframework.common.mapview.MapViewFactory;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapGLSurfaceView;

public class MapFragment extends BaseFragment {
    private static final String TAG = "Map";
    private boolean isFirstLoad = true;
    private boolean isForeground = true;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(C0965R.layout.frag_map, null);
        MapViewFactory.getInstance().relayoutMapView(viewGroup, 0);
        this.mViewCreated = true;
        return viewGroup;
    }

    public void onResume() {
        this.isForeground = true;
        MapGLSurfaceView bnMapView = MapViewFactory.getInstance().getMapView();
        if (bnMapView != null) {
            bnMapView.onResume();
            bnMapView.onForeground();
            if (this.isFirstLoad) {
                this.isFirstLoad = false;
                updateMapTheme(StyleManager.getRealDayStyle());
            }
        }
        super.onResume();
    }

    public void onPause() {
        MapGLSurfaceView bnMapView = MapViewFactory.getInstance().getMapView();
        if (bnMapView != null) {
            bnMapView.onPause();
            bnMapView.onBackground();
            this.isForeground = false;
        }
        super.onPause();
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
        updateMapTheme(dayStyle);
    }

    private void updateMapTheme(boolean dayStyle) {
        if (NavMapManager.getInstance().getNaviMapMode() == 0) {
            int sceneId;
            MapController mapController = MapViewFactory.getInstance().getMapView().getController();
            int mapTheme = 10;
            if (BNSettingManager.isRoadCondOnOrOff()) {
                sceneId = 5;
            } else {
                sceneId = 0;
            }
            if (!dayStyle) {
                if (NavMapManager.getInstance().isChangedMapMode()) {
                    mapTheme = 11;
                    sceneId = BNSettingManager.isRoadCondOnOrOff() ? 13 : 9;
                } else {
                    mapTheme = 12;
                    sceneId = BNSettingManager.isRoadCondOnOrOff() ? 5 : 0;
                }
            }
            mapController.setMapThemeScene(mapTheme, sceneId, new Bundle());
        }
    }

    public void onDestroyView() {
        this.mViewCreated = false;
        super.onDestroyView();
    }
}
