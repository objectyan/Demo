package com.baidu.navi.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.widget.ProgressBar;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.view.dialog.C2304o;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

public class HomePoiDetailView extends HomePoiBasicView {
    private static final String TAG = "HomePoiDetailView";
    private CarlifeActivity mActivity;
    private ProgressBar mAntiGeoPB;
    private ArrayList<SearchPoi> mAntiPoiList;
    private boolean mCanPanelShow = true;
    private Context mContext;
    private SearchPoi mCurrentPoi;
    private int mCurrentPoiIndex;
    private View mGroupView;
    private boolean mIfAntiGeoing = false;
    private boolean mIfNeedAntiGeoForStreetId = false;
    private boolean mIsAntiGeoOnlyForStreetId = false;
    private boolean mIsAntiGeoReady = false;
    private boolean mIsPanelShow = false;
    private boolean mIsPoiMode = false;
    private int mLastOrientation = 0;
    private NaviFragmentManager mNaviFragmentManager;
    private PoiDetailView mPoiPanel;
    private HeightWrapableViewPager mPoiSwitchVP;
    private C2304o mStreetscapeLoadAlertDialog;
    private PagerAdapter poiAdapter;

    public HomePoiDetailView(CarlifeActivity activity, View rootView, NaviFragmentManager fragManager) {
        this.mGroupView = rootView;
        this.mPoiPanel = (PoiDetailView) this.mGroupView.findViewById(C0965R.id.layout_poi_panel);
        this.mPoiPanel.setController(PoiController.getInstance());
    }

    public void updateStyle() {
        if (this.mPoiPanel != null) {
            this.mPoiPanel.updateStyle();
        }
    }

    public void show(GeoPoint geo, boolean isMyPositionMode) {
    }

    public void showMapPoi() {
    }

    public void showFavPoi() {
    }

    public void hide() {
        LogUtil.m15791e(TAG, "-----> hide ");
        this.mIsPanelShow = false;
        this.mPoiPanel.hide();
    }

    public boolean isVisible() {
        return this.mPoiPanel.getVisibility() == 0;
    }

    public void onResume() {
        if (this.mPoiPanel != null) {
            this.mPoiPanel.onResume();
        }
    }

    public void onPause() {
    }

    public void onUpdateOrientation(int orientation) {
        if (orientation != this.mLastOrientation) {
            this.mLastOrientation = orientation;
        }
    }
}
