package com.baidu.navi.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.navi.location.LocationChangeListener;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.location.LocationManager.LocData;
import com.baidu.navi.logic.model.UIModel;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.view.MapTitleBar;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeplan.RoutePlanParams.BundleKey;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.MainMapModel;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.PreferenceHelperConst;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import java.util.HashMap;

public class PickPointOnMapFragment extends MapContentFragment implements OnClickListener {
    private static final int MAP_SCALE_DEFAULT = 14;
    private static final String TAG = "RoutePlan";
    private static final int mTimeout = 30000;
    private boolean isCarMode = false;
    private SearchPoi mAntiGeoPoi;
    private RoutePlanNode mAntiRPNode;
    private BNMapObserver mBNMapObserver = new C38154();
    private int mCarModeHomeSideBarWidth = 0;
    private int[] mCenterPointLocation;
    private ImageView mCenterPointView;
    private LinearLayout mConfirmLayout;
    private TextView mConfirmText;
    private ImageView mDivider;
    private HashMap<String, String> mGeoMap = new HashMap();
    private Handler mHander = new C38121();
    private Handler mHandler;
    private boolean mHasInitCenterView = false;
    private boolean mHasPickPoint = false;
    private boolean mIsMapLocated = false;
    private LocationChangeListener mLocationChangeListener = new C38186();
    private TextView mPoiDescription;
    private RelativeLayout mPoiDetailInfoLayout;
    private TextView mPoiName;
    private RoutePlanNode mSelectPoint;
    private MapTitleBar mTitleBar;
    private ViewGroup mViewGroup = null;
    private String type = "PickPointOnMapFragment";

    /* renamed from: com.baidu.navi.fragment.PickPointOnMapFragment$1 */
    class C38121 extends Handler {
        C38121() {
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1003:
                    if (msg.arg1 == 0) {
                        PickPointOnMapFragment.this.mAntiGeoPoi = (SearchPoi) msg.obj.mData;
                        if (PickPointOnMapFragment.this.mAntiGeoPoi != null) {
                            if (PickPointOnMapFragment.this.mGeoMap.containsKey(PickPointOnMapFragment.this.mAntiGeoPoi.mViewPoint.toString())) {
                                PickPointOnMapFragment.this.mGeoMap.remove(PickPointOnMapFragment.this.mAntiGeoPoi.mViewPoint.toString());
                                if (PickPointOnMapFragment.this.mAntiGeoPoi.mType == 0 && PickPointOnMapFragment.this.mAntiGeoPoi.mName != null) {
                                    PickPointOnMapFragment.this.mAntiGeoPoi.mName = String.format(StyleManager.getString(C0965R.string.search_poi_fix), new Object[]{PickPointOnMapFragment.this.mAntiGeoPoi.mName});
                                }
                            } else {
                                return;
                            }
                        }
                        PickPointOnMapFragment.this.mAntiRPNode = RoutePlanModel.changeToRoutePlanNode(PickPointOnMapFragment.this.mAntiGeoPoi);
                        LogUtil.m15791e("RoutePlan", "--------------------name = " + PickPointOnMapFragment.this.mAntiRPNode.mName + ", address = " + PickPointOnMapFragment.this.mAntiRPNode.mDescription + ", LatitudeE6 = " + PickPointOnMapFragment.this.mAntiRPNode.getLatitudeE6() + ", LongitudeE6 = " + PickPointOnMapFragment.this.mAntiRPNode.getLongitudeE6());
                        if (PickPointOnMapFragment.this.mAntiRPNode.isNodeIntegrated()) {
                            PickPointOnMapFragment.this.mSelectPoint.copy(PickPointOnMapFragment.this.mAntiRPNode);
                            if (PickPointOnMapFragment.this.mSelectPoint.mName == null || PickPointOnMapFragment.this.mSelectPoint.mName.length() == 0) {
                                PickPointOnMapFragment.this.mPoiName.setText(C0965R.string.no_name_road);
                            } else {
                                PickPointOnMapFragment.this.mPoiName.setText(PickPointOnMapFragment.this.mSelectPoint.mName);
                            }
                            if (PickPointOnMapFragment.this.mSelectPoint.mDescription != null && PickPointOnMapFragment.this.mSelectPoint.mDescription.length() != 0) {
                                PickPointOnMapFragment.this.mPoiDescription.setVisibility(0);
                                PickPointOnMapFragment.this.mPoiDescription.setText(PickPointOnMapFragment.this.mSelectPoint.mDescription);
                                return;
                            }
                            return;
                        }
                        PickPointOnMapFragment.this.mPoiName.setText(C0965R.string.get_current_location_fail);
                        PickPointOnMapFragment.this.mPoiDescription.setVisibility(8);
                        return;
                    }
                    PickPointOnMapFragment.this.mPoiName.setText(C0965R.string.unknown_road);
                    PickPointOnMapFragment.this.mPoiDescription.setVisibility(8);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.PickPointOnMapFragment$2 */
    class C38132 implements OnClickListener {
        C38132() {
        }

        public void onClick(View arg0) {
            if (PickPointOnMapFragment.this.mSelectPoint.isNodeSettedData()) {
                GeoPoint geoPt = PickPointOnMapFragment.this.mSelectPoint.mGeoPoint;
                switch (PickPointOnMapFragment.this.mShowBundle.getInt(BundleKey.SELECT_POINT_ACTION)) {
                    case 1:
                        ((RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN)).setPointSelectNode(geoPt);
                        PickPointOnMapFragment.this.mSelectPoint.setFrom(1);
                        ((RoutePlanModel) NaviDataEngine.getInstance().getModel(ModelName.ROUTE_PLAN)).setPointSelectNode(PickPointOnMapFragment.this.mSelectPoint);
                        LogUtil.m15791e(ModuleName.MAP, "BNPoiSearcherObserver");
                        PickPointOnMapFragment.this.backTo(50, null);
                        return;
                    case 4:
                    case 5:
                        RoutePlanNode node = new RoutePlanNode();
                        node.copy(PickPointOnMapFragment.this.mSelectPoint);
                        UIModel.settingAddress(node, BaseFragment.mActivity, PickPointOnMapFragment.this.mShowBundle);
                        int from = PickPointOnMapFragment.this.mShowBundle.getInt(BundleKey.FROM_FRAGMENT, -1);
                        if (from == 49) {
                            PickPointOnMapFragment.this.backTo(49, null);
                            return;
                        } else if (from == 81) {
                            PickPointOnMapFragment.this.backTo(81, null);
                            return;
                        } else if (from == 89) {
                            PickPointOnMapFragment.this.backTo(89, null);
                            return;
                        } else {
                            PickPointOnMapFragment.this.back(null);
                            return;
                        }
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.PickPointOnMapFragment$3 */
    class C38143 implements OnGlobalLayoutListener {
        C38143() {
        }

        public void onGlobalLayout() {
            if (!PickPointOnMapFragment.this.mHasInitCenterView) {
                PickPointOnMapFragment.this.mHasInitCenterView = true;
                PickPointOnMapFragment.this.setupCenterView();
                PickPointOnMapFragment.this.mCenterPointView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.PickPointOnMapFragment$4 */
    class C38154 implements BNMapObserver {
        C38154() {
        }

        public void update(BNSubject o, int type, int event, Object arg) {
            if (2 == type) {
                switch (event) {
                }
            }
            if (1 == type) {
                switch (event) {
                    case 257:
                        LogUtil.m15791e("RoutePlan", "---------------------------x = " + PickPointOnMapFragment.this.mCenterPointLocation[0] + ", y = " + PickPointOnMapFragment.this.mCenterPointLocation[1]);
                        GeoPoint curGeoPoint = BNMapController.getInstance().getGeoPosByScreenPos(PickPointOnMapFragment.this.mCenterPointLocation[0], PickPointOnMapFragment.this.mCenterPointLocation[1]);
                        PickPointOnMapFragment.this.antiGeo(curGeoPoint);
                        PickPointOnMapFragment.this.resetSelectPoint(curGeoPoint);
                        PickPointOnMapFragment.this.mPoiName.setText(C0965R.string.locate_new_poi);
                        PickPointOnMapFragment.this.mPoiDescription.setVisibility(8);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.PickPointOnMapFragment$5 */
    class C38165 implements Runnable {
        C38165() {
        }

        public void run() {
            GeoPoint curGeoPoint = BNMapController.getInstance().getGeoPosByScreenPos(PickPointOnMapFragment.this.mCenterPointLocation[0], PickPointOnMapFragment.this.mCenterPointLocation[1]);
            if (curGeoPoint.getLatitudeE6() > 0 && curGeoPoint.getLongitudeE6() > 0) {
                PickPointOnMapFragment.this.antiGeo(curGeoPoint);
            }
        }
    }

    /* renamed from: com.baidu.navi.fragment.PickPointOnMapFragment$6 */
    class C38186 implements LocationChangeListener {

        /* renamed from: com.baidu.navi.fragment.PickPointOnMapFragment$6$1 */
        class C38171 implements Runnable {
            C38171() {
            }

            public void run() {
                LocationManager.getInstance().removeLocationChangeLister(PickPointOnMapFragment.this.mLocationChangeListener);
            }
        }

        C38186() {
        }

        public void onLocationChange(LocData locData) {
            if (locData != null && LocationManager.getInstance().isLocationValid()) {
                TipTool.onCreateDebugToast(PickPointOnMapFragment.this.getContext(), "LocSDK: Got " + locData);
                if (!PickPointOnMapFragment.this.mIsMapLocated) {
                    PickPointOnMapFragment.this.initMapStatus();
                }
                if (PickPointOnMapFragment.this.mIsMapLocated) {
                    PickPointOnMapFragment.this.mHandler.post(new C38171());
                }
            }
        }

        public CoordType onGetCoordType() {
            return CoordType.CoordType_GCJ02;
        }
    }

    protected void onInitMap() {
        LogUtil.m15791e("RoutePlan", "addObserver");
        setMapLayerMode(4);
    }

    protected View onCreateContentView(LayoutInflater inflater) {
        this.isCarMode = !NaviFragmentManager.isUsingMapMode();
        this.mViewGroup = (ViewGroup) inflater.inflate(this.isCarMode ? C0965R.layout.carmode_frag_pick_point_on_map : C0965R.layout.frag_pick_point_on_map, null);
        this.mTitleBar = (MapTitleBar) this.mViewGroup.findViewById(C0965R.id.title_bar);
        this.mTitleBar.setLeftOnClickedListener(this);
        loadMapCtrlPanel(true);
        this.mCenterPointLocation = new int[2];
        this.mSelectPoint = new RoutePlanNode();
        findViews();
        this.mHandler = new Handler(Looper.getMainLooper());
        setupViews();
        return this.mViewGroup;
    }

    protected void onInitView() {
    }

    protected void onUpdateOrientation(int orientation) {
    }

    public void findViews() {
        this.mCenterPointView = (ImageView) this.mViewGroup.findViewById(C0965R.id.center_point);
        this.mPoiDetailInfoLayout = (RelativeLayout) this.mViewGroup.findViewById(C0965R.id.poi_detail_layout);
        this.mPoiName = (TextView) this.mViewGroup.findViewById(C0965R.id.poi_name_text);
        this.mPoiDescription = (TextView) this.mViewGroup.findViewById(C0965R.id.poi_description_text);
        this.mConfirmLayout = (LinearLayout) this.mViewGroup.findViewById(C0965R.id.btn_confirm_layout);
        this.mConfirmText = (TextView) this.mViewGroup.findViewById(C0965R.id.btn_confirm);
        this.mDivider = (ImageView) this.mViewGroup.findViewById(C0965R.id.divider_vertical);
    }

    public void setupViews() {
        this.mConfirmLayout.setOnClickListener(new C38132());
        initMapStatus();
        int action = this.mShowBundle.getInt(BundleKey.SELECT_POINT_ACTION, -1);
        int from = this.mShowBundle.getInt(BundleKey.FROM_FRAGMENT, -1);
        if (action == 1 && from == 50) {
            int pickPointType = this.mShowBundle.getInt(RoutePlanFragment.KEY_SET_POI_TYPE, -1);
            if (pickPointType == 0) {
                this.mConfirmText.setText(StyleManager.getString(C0965R.string.set_start_point));
            } else if (pickPointType == 1) {
                this.mConfirmText.setText(StyleManager.getString(C0965R.string.set_via_point));
            } else if (pickPointType == 2) {
                this.mConfirmText.setText(StyleManager.getString(C0965R.string.set_end_point));
            }
        }
        this.mCenterPointView.getViewTreeObserver().addOnGlobalLayoutListener(new C38143());
    }

    protected void onUpdateStyle(boolean dayStyle) {
        super.onUpdateStyle(dayStyle);
        if (this.isCarMode) {
            this.mPoiDetailInfoLayout.setBackgroundColor(StyleManager.getColor(C0965R.color.carmode_common_bg));
            this.mPoiName.setTextColor(StyleManager.getColor(C0965R.color.carmode_common_main_text));
            this.mPoiDescription.setTextColor(StyleManager.getColor(C0965R.color.carmode_common_second_text));
            this.mDivider.setBackgroundColor(StyleManager.getColor(C0965R.color.carmode_line));
            this.mConfirmLayout.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.carmode_list_bg_selector));
            this.mConfirmText.setTextColor(StyleManager.getColor(C0965R.color.carmode_blue_text));
            return;
        }
        this.mTitleBar.onUpdateStyle(dayStyle);
        this.mPoiDetailInfoLayout.setBackgroundColor(StyleManager.getColor(C0965R.color.quick_route_background));
        this.mPoiName.setTextColor(StyleManager.getColor(C0965R.color.bnav_rp_point_text_color));
        this.mPoiDescription.setTextColor(StyleManager.getColor(C0965R.color.bnav_rp_point_secondText_color));
        this.mDivider.setBackgroundColor(StyleManager.getColor(C0965R.color.vertical_divider_color));
    }

    private void antiGeo(GeoPoint geoPt) {
        BNPoiSearcher.getInstance().asynGetPoiByPoint(geoPt, 30000, this.mHander);
        this.mGeoMap.put(geoPt.toString(), this.type);
    }

    private void resetSelectPoint(GeoPoint point) {
        this.mSelectPoint.mName = StyleManager.getString(C0965R.string.bnav_string_route_plan_map_point);
        this.mSelectPoint.mDescription = "";
        this.mSelectPoint.mFrom = 1;
        this.mSelectPoint.setGeoPoint(point);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public void onResume() {
        super.onResume();
        BNMapController.getInstance().addObserver(this.mBNMapObserver);
        LocationManager.getInstance().addLocationChangeLister(this.mLocationChangeListener);
    }

    private void setupCenterView() {
        if (this.isCarMode) {
            this.mCenterPointLocation[0] = (this.mCenterPointView.getLeft() + (this.mCenterPointView.getWidth() / 2)) + this.mCarModeHomeSideBarWidth;
            this.mCenterPointLocation[1] = this.mCenterPointView.getTop() + this.mCenterPointView.getHeight();
        } else {
            this.mCenterPointLocation[0] = this.mCenterPointView.getLeft() + (this.mCenterPointView.getWidth() / 2);
            this.mCenterPointLocation[1] = this.mCenterPointView.getTop() + this.mCenterPointView.getHeight();
        }
        GeoPoint curGeoPoint = BNMapController.getInstance().getGeoPosByScreenPos(this.mCenterPointLocation[0], this.mCenterPointLocation[1]);
        if (curGeoPoint != null) {
            if (curGeoPoint.getLatitudeE6() <= 0 || curGeoPoint.getLongitudeE6() <= 0) {
                this.mHandler.postDelayed(new C38165(), 1000);
            } else {
                antiGeo(curGeoPoint);
            }
            resetSelectPoint(curGeoPoint);
        }
    }

    public void onPause() {
        super.onPause();
        BNMapController.getInstance().deleteObserver(this.mBNMapObserver);
        LocationManager.getInstance().removeLocationChangeLister(this.mLocationChangeListener);
    }

    public void onStop() {
        super.onStop();
    }

    public void onDestroyView() {
        super.onDestroyView();
    }

    public void onClick(View v) {
        if (v.getId() == C0965R.id.left_imageview) {
            back(null);
        }
    }

    private void initMapStatus() {
        if (MainMapModel.getInstance().bFirstLoc) {
            MapStatus mapStatus = BNMapController.getInstance().getMapStatus();
            int savedLevel = PreferenceHelper.getInstance(getContext()).getInt(PreferenceHelperConst.SP_LAST_SCALE, 14);
            LogUtil.m15791e("RoutePlan", "initMapScale: savedLevel " + savedLevel);
            if (savedLevel > 14) {
                mapStatus._Level = (float) savedLevel;
            } else {
                mapStatus._Level = 14.0f;
            }
            com.baidu.navisdk.model.datastruct.LocData locData = GeoLocateModel.getInstance().getLastLocation();
            if (locData == null || !locData.isValid()) {
                this.mIsMapLocated = false;
                LogUtil.m15791e("RoutePlan", "initMapScale: null location data...");
                mapStatus._Level = 3.0f;
            } else {
                this.mIsMapLocated = true;
                MainMapModel.getInstance().bFirstLoc = false;
                Bundle b = CoordinateTransformUtil.LL2MC(locData.longitude, locData.latitude);
                mapStatus._CenterPtX = b.getInt("MCx");
                mapStatus._CenterPtY = b.getInt("MCy");
            }
            BNMapController.getInstance().setMapStatus(mapStatus, AnimationType.eAnimationNone);
            if (this.mMapControlPanel != null) {
                this.mMapControlPanel.updateView();
                return;
            }
            return;
        }
        this.mIsMapLocated = true;
    }
}
