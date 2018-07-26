package com.baidu.navi.fragment;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.baidu.carlife.C0965R;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.cruise.control.EnterQuitLogicManager;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.view.MapTitleBar;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.userdata.BNFavoriteManager;
import com.baidu.navisdk.model.datastruct.FavoritePoiInfo;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.map.MapController;

public class BrowseMapFragment extends MapContentFragment implements OnClickListener {
    private static final String TAG = "Map";
    private boolean isShowUgc = false;
    private BNMapObserver mBNMapObserver = new C37841();
    private MapTitleBar mTitleBar;
    private ViewGroup mViewGroup;

    /* renamed from: com.baidu.navi.fragment.BrowseMapFragment$1 */
    class C37841 implements BNMapObserver {
        C37841() {
        }

        public void update(BNSubject o, int type, int event, Object arg) {
            BrowseMapFragment.this.bnMapObserverUpdate(o, type, event, arg);
            if (2 == type) {
                switch (event) {
                    case 514:
                        BrowseMapFragment.this.handleSingleTap((MotionEvent) arg);
                        return;
                    case 517:
                        BrowseMapFragment.this.handleLongPress((MotionEvent) arg);
                        return;
                    default:
                        return;
                }
            } else if (1 == type) {
                switch (event) {
                    case 257:
                        break;
                    case 264:
                        BrowseMapFragment.this.handleClickBasePoiLayer((MapItem) arg);
                        return;
                    case 276:
                        BrowseMapFragment.this.handleClickFavPoiLayer((MapItem) arg);
                        break;
                    default:
                        return;
                }
                PoiController.getInstance().focusItem(true);
            }
        }
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.mViewGroup = (ViewGroup) LayoutInflater.from(mActivity).inflate(C0965R.layout.frag_browse_map, null);
        loadMapCtrlPanel(true);
        this.mbMoveToLocationPoint = true;
        this.mTitleBar = (MapTitleBar) this.mViewGroup.findViewById(C0965R.id.title_bar);
        if (this.mTitleBar != null) {
            this.mTitleBar.setRightButtonBackground(StyleManager.getDrawable(C0965R.drawable.bnav_common_ic_search));
            this.mTitleBar.setMiddleTextVisible(false);
            this.mTitleBar.setLeftOnClickedListener(this);
            this.mTitleBar.setRightOnClickedListener(this);
        }
        return this.mViewGroup;
    }

    protected void onInitView() {
    }

    protected void onInitMap() {
        LogUtil.m15791e("", "  onInitMap =======MAP_LAYER_MODE_BROWSE_MAP");
        if (BaseFragment.mResumeMapView) {
            setMapLayerMode(0);
        }
        NMapControlProxy.getInstance().updateLayer(14);
    }

    protected void onUpdateOrientation(int orientation) {
    }

    protected void onUpdateStyle(boolean dayStyle) {
        super.onUpdateStyle(dayStyle);
        if (this.mTitleBar != null) {
            this.mTitleBar.onUpdateStyle(dayStyle);
        }
    }

    public void onClick(View v) {
        int id = v.getId();
        if (id == C0965R.id.left_imageview) {
            back(null);
        } else if (id == C0965R.id.right_content) {
            showFragment(49, null);
        }
    }

    public void onResume() {
        BNMapController.getInstance().addObserver(this.mBNMapObserver);
        super.onResume();
    }

    public void onPause() {
        BNMapController.getInstance().deleteObserver(this.mBNMapObserver);
        PoiController.getInstance().focusItem(false);
        super.onPause();
    }

    public void bnMapObserverUpdate(BNSubject o, int type, int event, Object arg) {
    }

    protected void handleLongPress(MotionEvent e) {
        GeoPoint geoPt = BNMapController.getInstance().getGeoPosByScreenPos((int) e.getX(), (int) e.getY());
        EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
        onShowMapGeoPoint(geoPt);
    }

    protected void handleSingleTap(MotionEvent e) {
    }

    private void handleClickBasePoiLayer(MapItem item) {
        if (!MapController.mMultiTouch.mTwoTouch) {
            initFocusChain(this.mViewGroup);
            GeoPoint point = new GeoPoint(item.mLongitude, item.mLatitude);
            SearchPoi poi = new SearchPoi();
            if (item.mTitle != null) {
                poi.mName = item.mTitle.replace("\\", "");
            }
            poi.mViewPoint = point;
            poi.mGuidePoint = point;
            poi.mOriginUID = item.mUid;
            onShowMapPoi(poi);
        }
    }

    private void handleClickFavPoiLayer(MapItem item) {
        if (!MapController.mMultiTouch.mTwoTouch) {
            initFocusChain(this.mViewGroup);
            GeoPoint favGeoPoint = new GeoPoint(item.mLongitude, item.mLatitude);
            FavoritePoiInfo favData = BNFavoriteManager.getInstance().getFavPoiInfoByGeoPoint(favGeoPoint);
            SearchPoi poi = new SearchPoi();
            if (favData != null) {
                poi.mName = favData.mFavName;
                poi.mAddress = favData.mFavAddr;
            }
            poi.mViewPoint = favGeoPoint;
            poi.mGuidePoint = favGeoPoint;
            onShowFavPoi(poi);
        }
    }

    protected void onShowFavPoi(SearchPoi poi) {
    }

    protected void onShowMapPoi(SearchPoi poi) {
    }

    protected void onShowMapGeoPoint(GeoPoint geoPt) {
    }

    private boolean disableAnitiGeo() {
        return false;
    }
}
