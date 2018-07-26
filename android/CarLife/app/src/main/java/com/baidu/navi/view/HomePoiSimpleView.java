package com.baidu.navi.view;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.controller.PoiDetailViewController;
import com.baidu.navi.controller.PoiDetailViewController.IPoiDetailViewCallBack;
import com.baidu.navi.cruise.control.EnterQuitLogicManager;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.fragment.carmode.CarModeMapFragment;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class HomePoiSimpleView extends HomePoiBasicView {
    private boolean isPickPoi = false;
    private CarlifeActivity mActivity;
    private TextView mAddrTextView;
    private IPoiDetailViewCallBack mCallBack = new C39991();
    private SearchPoi mCurrentPoi;
    private View mDistanceLayout;
    private TextView mDistanceTextView;
    private ImageView mFavBtn;
    private boolean mIsMyPosition;
    private View mNameAddrLayout;
    private TextView mNameTextView;
    CarModeMapFragment mParentFragment;
    private View mPhoneLayout;
    private TextView mPhoneNumberTextView;
    private PoiController mPoiController;
    private PoiDetailViewController mPoiDetailViewController = new PoiDetailViewController();
    private View mPoiPanelView;
    private Handler mUIHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1003:
                    if (msg.arg1 == 0) {
                        SearchPoi poi = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getAntiGeoPoi();
                        if (HomePoiSimpleView.this.isPickPoi) {
                            if (!(HomePoiSimpleView.this.mCurrentPoi == null || poi == null)) {
                                poi.mName = HomePoiSimpleView.this.mCurrentPoi.mName;
                                poi.mOriginUID = HomePoiSimpleView.this.mCurrentPoi.mOriginUID;
                            }
                            HomePoiSimpleView.this.initPoiDetailPanel(poi);
                            return;
                        }
                        HomePoiSimpleView.this.mNameTextView.setVisibility(0);
                        HomePoiSimpleView.this.mAddrTextView.setVisibility(0);
                        HomePoiSimpleView.this.mNameAddrLayout.setVisibility(0);
                        HomePoiSimpleView.this.mPhoneLayout.setVisibility(0);
                        HomePoiSimpleView.this.mDistanceLayout.setVisibility(0);
                        if (poi != null && poi.mType == 0) {
                            poi.mName = String.format(StyleManager.getString(C0965R.string.search_poi_fix), new Object[]{poi.mName});
                        }
                        HomePoiSimpleView.this.initPoiDetailPanel(poi);
                        return;
                    }
                    HomePoiSimpleView.this.setAntiGeoFailedViews();
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: com.baidu.navi.view.HomePoiSimpleView$1 */
    class C39991 implements IPoiDetailViewCallBack {
        C39991() {
        }

        public void onFavSyncDone(String msg) {
            HomePoiSimpleView.this.updateFavBtnBackground();
        }
    }

    /* renamed from: com.baidu.navi.view.HomePoiSimpleView$3 */
    class C40013 implements OnClickListener {
        C40013() {
        }

        public void onClick(View v) {
            HomePoiSimpleView.this.startPhoneCall();
        }
    }

    /* renamed from: com.baidu.navi.view.HomePoiSimpleView$4 */
    class C40024 implements OnClickListener {
        C40024() {
        }

        public void onClick(View v) {
            HomePoiSimpleView.this.startCalcRoute();
        }
    }

    /* renamed from: com.baidu.navi.view.HomePoiSimpleView$5 */
    class C40035 implements OnClickListener {
        C40035() {
        }

        public void onClick(View v) {
            HomePoiSimpleView.this.clickFavBtn();
        }
    }

    private class HaveFavTask extends AsyncTask<Void, Void, Boolean> {
        private HaveFavTask() {
        }

        protected Boolean doInBackground(Void... params) {
            return Boolean.valueOf(HomePoiSimpleView.this.mPoiDetailViewController.isHaveFav());
        }

        protected void onPostExecute(Boolean result) {
            HomePoiSimpleView.this.updateFavBtn(result.booleanValue());
        }
    }

    private void poiDetailViewControllerInit() {
        this.mPoiDetailViewController.init(this.mCurrentPoi);
        this.mPoiDetailViewController.setCallBack(this.mCallBack);
    }

    public HomePoiSimpleView(CarlifeActivity activity, View rootView, NaviFragmentManager fragManager, CarModeMapFragment parentFragment) {
        this.mActivity = activity;
        this.mPoiController = PoiController.getInstance();
        this.mPoiPanelView = rootView.findViewById(C0965R.id.layout_poi_panel);
        this.mParentFragment = parentFragment;
        initView(this.mPoiPanelView);
        hide();
    }

    public void show(boolean pickPoi) {
    }

    public void show(GeoPoint geo, boolean isMyPositionMode) {
        this.isPickPoi = false;
        this.mIsMyPosition = isMyPositionMode;
        loadPoint(geo);
    }

    public void showMapPoi() {
        this.isPickPoi = true;
        this.mIsMyPosition = false;
        this.mCurrentPoi = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getMapSearchPoi();
        this.mPoiController.focusPoi(this.mCurrentPoi);
        this.mPoiController.animationTo(this.mCurrentPoi, (long) (ScreenUtil.getInstance().dip2px(-250) / 2), (long) (ScreenUtil.getInstance().dip2px(0) / 2));
        initPoiDetailPanel(this.mCurrentPoi);
        int netMode = this.mPoiController.getAntiPoiNetMode(this.mCurrentPoi.mViewPoint);
        if (netMode != -1 && this.mPoiController.antiGeo(this.mCurrentPoi, netMode, this.mUIHandler)) {
            startAntiGeo();
        }
    }

    public void showFavPoi() {
        this.isPickPoi = true;
        this.mIsMyPosition = false;
        this.mCurrentPoi = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getMapSearchPoi();
        this.mPoiController.focusPoi(this.mCurrentPoi);
        this.mPoiController.animationTo(this.mCurrentPoi, (long) (ScreenUtil.getInstance().dip2px(-250) / 2), (long) (ScreenUtil.getInstance().dip2px(0) / 2));
        initPoiDetailPanel(this.mCurrentPoi);
    }

    public void hide() {
        if (this.mPoiPanelView != null) {
            this.mPoiPanelView.setVisibility(8);
        }
        if (this.mParentFragment != null) {
            this.mParentFragment.showTopbarView();
        }
        this.mPoiController.clearPoiCache();
    }

    private void show() {
        if (this.mPoiPanelView != null) {
            this.mPoiPanelView.setVisibility(0);
        }
        if (this.mParentFragment != null) {
            this.mParentFragment.hideTopbarView();
        }
        EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
    }

    public boolean isVisible() {
        if (this.mPoiPanelView == null || this.mPoiPanelView.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void updateStyle() {
    }

    public void onResume() {
        if (isVisible()) {
            if (this.mIsMyPosition) {
                this.mPoiController.clearPoiCache();
            } else {
                this.mPoiController.focusPoi(this.mCurrentPoi);
            }
            this.mPoiController.animationTo(this.mCurrentPoi, (long) (ScreenUtil.getInstance().dip2px(-250) / 2), (long) (ScreenUtil.getInstance().dip2px(0) / 2));
            updatePoiPanelView(this.mCurrentPoi);
        }
    }

    public void onPause() {
    }

    public void onUpdateOrientation(int orientation) {
    }

    private void initPoiDetailPanel(SearchPoi antiPoi) {
        if (this.mCurrentPoi != null) {
            this.mCurrentPoi = antiPoi;
            updatePoiPanelView(this.mCurrentPoi);
            show();
        }
    }

    public View onCreateView() {
        View view = LayoutInflater.from(this.mActivity).inflate(C0965R.layout.carmode_map_poi_panel_right, null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        if (view != null) {
            this.mNameTextView = (TextView) view.findViewById(C0965R.id.carmode_map_poi_panel_right_place);
            this.mAddrTextView = (TextView) view.findViewById(C0965R.id.carmode_map_poi_panel_right_addr);
            this.mPhoneNumberTextView = (TextView) view.findViewById(C0965R.id.carmode_map_poi_panel_right_phone);
            this.mDistanceTextView = (TextView) view.findViewById(C0965R.id.carmode_map_poi_panel_right_distance);
            this.mNameAddrLayout = view.findViewById(C0965R.id.carmode_map_poi_panel_right_place_layout);
            this.mPhoneLayout = view.findViewById(C0965R.id.carmode_map_poi_panel_right_phone_layout);
            this.mDistanceLayout = view.findViewById(C0965R.id.carmode_map_poi_panel_right_distance_layout);
            this.mFavBtn = (ImageView) view.findViewById(C0965R.id.carmode_map_poi_panel_right_fav_btn);
            this.mPhoneLayout.setOnClickListener(new C40013());
            this.mDistanceLayout.setOnClickListener(new C40024());
            this.mNameAddrLayout.setOnClickListener(new C40035());
        }
    }

    private void updateFavBtnBackground() {
        new HaveFavTask().execute(new Void[0]);
    }

    private void updateFavBtn(boolean isFav) {
        if (this.mFavBtn != null) {
            if (isFav) {
                this.mFavBtn.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.map_ic_address_collect_on));
            } else {
                this.mFavBtn.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.map_ic_address_collect_off));
            }
        }
    }

    private void updatePoiPanelView(SearchPoi poi) {
        poiDetailViewControllerInit();
        if (poi != null) {
            int i;
            this.mPoiPanelView.setBackgroundColor(StyleManager.getColor(C0965R.color.bnav_common_bg));
            this.mNameTextView.setText(poi.mName);
            if (poi.mAddress == null) {
                this.mAddrTextView.setVisibility(4);
            } else {
                this.mAddrTextView.setVisibility(0);
                this.mAddrTextView.setText(poi.mAddress);
            }
            if (this.mCurrentPoi == null || TextUtils.isEmpty(this.mCurrentPoi.mName) || StyleManager.getString(C0965R.string.poi_on_map).equals(this.mCurrentPoi.mName)) {
                this.mNameAddrLayout.setClickable(false);
            } else {
                this.mNameAddrLayout.setClickable(true);
            }
            this.mPhoneLayout.setVisibility(0);
            View view = this.mDistanceLayout;
            if (this.mIsMyPosition) {
                i = 8;
            } else {
                i = 0;
            }
            view.setVisibility(i);
            if (poi.mPhone == null || poi.mPhone.isEmpty()) {
                this.mPhoneNumberTextView.setText(C0965R.string.no_phone);
                this.mPhoneLayout.setClickable(false);
            } else {
                this.mPhoneNumberTextView.setText(poi.mPhone + "　");
                this.mPhoneLayout.setClickable(true);
            }
            TextView textView = this.mDistanceTextView;
            StringBuilder append = new StringBuilder().append("距离");
            PoiController poiController = this.mPoiController;
            textView.setText(append.append(PoiController.getInstance().getDistance2CurrentPoint(this.mCurrentPoi)).toString());
            updateFavBtnBackground();
        }
    }

    public void loadPoint(GeoPoint geopoint) {
        if (geopoint != null && geopoint.isValid()) {
            SearchPoi poi = new SearchPoi();
            poi.mViewPoint = geopoint;
            poi.mGuidePoint = geopoint;
            this.mCurrentPoi = poi;
            poiDetailViewControllerInit();
            if (this.mIsMyPosition) {
                this.mPoiController.clearPoiCache();
            } else {
                this.mPoiController.focusPoi(poi);
            }
            this.mPoiController.animationTo(geopoint, (long) (ScreenUtil.getInstance().dip2px(-250) / 2), (long) (ScreenUtil.getInstance().dip2px(0) / 2));
            int netMode = this.mPoiController.getAntiPoiNetMode(geopoint);
            if (netMode == -1) {
                this.mCurrentPoi.mName = StyleManager.getString(C0965R.string.poi_on_map);
                show();
                updatePoiPanelView(this.mCurrentPoi);
            } else if (this.mPoiController.antiGeo(this.mCurrentPoi, netMode, this.mUIHandler)) {
                startAntiGeo();
            }
        }
    }

    private void startAntiGeo() {
        show();
    }

    private void setAntiGeoFailedViews() {
        if (!this.isPickPoi) {
            this.mNameAddrLayout.setVisibility(0);
            this.mNameTextView.setVisibility(0);
            this.mAddrTextView.setVisibility(8);
            this.mNameTextView.setText(C0965R.string.poi_on_map);
            this.mPhoneLayout.setVisibility(8);
            this.mDistanceLayout.setVisibility(8);
        }
    }

    public void clickFavBtn() {
        if (!ForbidDaulClickUtils.isFastDoubleClick()) {
            poiDetailViewControllerInit();
            this.mPoiDetailViewController.addOrDelFav();
        }
    }

    public void startCalcRoute() {
        if (!ForbidDaulClickUtils.isFastDoubleClick() && this.mPoiController != null && this.mCurrentPoi != null) {
            this.mPoiController.startCalcRoute(this.mCurrentPoi, this.mParentFragment);
        }
    }

    private void startPhoneCall() {
        if (!ForbidDaulClickUtils.isFastDoubleClick() && this.mPoiController != null && this.mCurrentPoi != null) {
            this.mPoiController.callPhone(this.mCurrentPoi);
        }
    }
}
