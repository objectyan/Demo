package com.baidu.navi.view;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.controller.PoiDetailViewController;
import com.baidu.navi.controller.PoiDetailViewController.IPoiDetailViewCallBack;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class CarmodePoiDetailView extends FrameLayout {
    private boolean isMyPosition = false;
    private boolean isPickPoi = false;
    private TextView mAddrTextView;
    private OnClickListener mBtnClickListener = new C39926();
    private IPoiDetailViewCallBack mCallBack = new C39871();
    private int mComeFrom;
    private View mContentLayout;
    private Context mContext;
    private SearchPoi mCurrentPoi;
    private View mDistanceLayout;
    private TextView mDistanceTextView;
    private ImageView mFavBtn;
    private int mIndex;
    private View mNameAddrLayout;
    private TextView mNameTextView;
    private C1277e mOnDialogListener;
    private View mPhoneLayout;
    private TextView mPhoneNumberTextView;
    private PoiController mPoiController;
    private PoiDetailViewController mPoiDetailViewController = new PoiDetailViewController();
    private Handler mUIHandler;

    /* renamed from: com.baidu.navi.view.CarmodePoiDetailView$1 */
    class C39871 implements IPoiDetailViewCallBack {
        C39871() {
        }

        public void onFavSyncDone(String msg) {
            CarmodePoiDetailView.this.updateFavBtnBackground();
        }
    }

    /* renamed from: com.baidu.navi.view.CarmodePoiDetailView$3 */
    class C39893 implements OnClickListener {
        C39893() {
        }

        public void onClick(View v) {
            CarmodePoiDetailView.this.startPhoneCall();
        }
    }

    /* renamed from: com.baidu.navi.view.CarmodePoiDetailView$4 */
    class C39904 implements OnClickListener {
        C39904() {
        }

        public void onClick(View v) {
            CarmodePoiDetailView.this.startCalcRoute();
        }
    }

    /* renamed from: com.baidu.navi.view.CarmodePoiDetailView$5 */
    class C39915 implements OnClickListener {
        C39915() {
        }

        public void onClick(View v) {
            CarmodePoiDetailView.this.clickFavBtn();
        }
    }

    /* renamed from: com.baidu.navi.view.CarmodePoiDetailView$6 */
    class C39926 implements OnClickListener {
        C39926() {
        }

        public void onClick(View v) {
            if (!ForbidDaulClickUtils.isFastDoubleClick() && v.getId() == C0965R.id.info_layout) {
                CarmodePoiDetailView.this.mPoiController.startCalcRoute(CarmodePoiDetailView.this.mCurrentPoi, CarmodePoiDetailView.this.mOnDialogListener);
            }
        }
    }

    private class HaveFavTask extends AsyncTask<Void, Void, Boolean> {
        private HaveFavTask() {
        }

        protected Boolean doInBackground(Void... params) {
            return Boolean.valueOf(CarmodePoiDetailView.this.mPoiDetailViewController.isHaveFav());
        }

        protected void onPostExecute(Boolean result) {
            CarmodePoiDetailView.this.updateFavBtn(result.booleanValue());
        }
    }

    private void poiDetailViewControllerInit() {
        this.mPoiDetailViewController.init(this.mCurrentPoi);
        this.mPoiDetailViewController.setCallBack(this.mCallBack);
    }

    public CarmodePoiDetailView(Context context) {
        super(context);
        this.mContext = context;
        findViews(context);
        initSkins();
        initHandler();
    }

    public CarmodePoiDetailView(Context context, AttributeSet attrs) {
        super(context, attrs);
        findViews(context);
        initSkins();
        initHandler();
    }

    public CarmodePoiDetailView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        findViews(context);
        initSkins();
        initHandler();
    }

    public void setComeFrom(int comeFrom) {
        this.mComeFrom = comeFrom;
    }

    private void initHandler() {
        this.mUIHandler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1003:
                        if (msg.arg1 == 0) {
                            SearchPoi poi = ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getAntiGeoPoi();
                            CarmodePoiDetailView.this.mNameAddrLayout.setVisibility(0);
                            CarmodePoiDetailView.this.updatePoiByAntiPoi(poi);
                            return;
                        } else if (!CarmodePoiDetailView.this.isPickPoi) {
                            CarmodePoiDetailView.this.mNameTextView.setVisibility(0);
                            CarmodePoiDetailView.this.mAddrTextView.setVisibility(8);
                            CarmodePoiDetailView.this.mNameTextView.setText(C0965R.string.poi_on_map);
                            if (CarmodePoiDetailView.this.mCurrentPoi != null) {
                                CarmodePoiDetailView.this.mCurrentPoi.mName = StyleManager.getString(C0965R.string.poi_on_map);
                                return;
                            }
                            return;
                        } else {
                            return;
                        }
                    default:
                        return;
                }
            }
        };
    }

    public void setController(PoiController controller) {
        this.mPoiController = controller;
    }

    public void setSearchPoi(SearchPoi poi) {
        if (poi != null) {
            this.mCurrentPoi = poi;
            initContents();
        }
    }

    public void setFromBrowseMapFragment(boolean isFromBrowseMapFragment, NaviFragmentManager naviFragmentManager) {
    }

    public void setFavSearchPoi(SearchPoi poi) {
        if (poi != null) {
            this.mCurrentPoi = poi;
            initContents();
        }
    }

    private void updatePoiByAntiPoi(SearchPoi poi) {
        if (poi != null && this.mCurrentPoi != null) {
            if (this.isPickPoi) {
                String orgpoiName = this.mCurrentPoi.mName;
                poi.mOriginUID = this.mCurrentPoi.mOriginUID;
                this.mCurrentPoi = poi;
                this.mCurrentPoi.mName = orgpoiName;
            } else {
                this.mCurrentPoi = poi;
                if (poi.mType == 0) {
                    this.mCurrentPoi.mName = String.format(StyleManager.getString(C0965R.string.search_poi_fix), new Object[]{this.mCurrentPoi.mName});
                }
            }
            initContents();
        }
    }

    public void setSearchPoiIndex(int index, int FcType) {
        this.mIndex = index;
    }

    public int getIndex() {
        return this.mIndex;
    }

    public SearchPoi getSearchPoi() {
        return this.mCurrentPoi;
    }

    private void findViews(Context context) {
        this.mContentLayout = LayoutInflater.from(context).inflate(C0965R.layout.carmode_map_poi_panel_right, null);
        addView(this.mContentLayout);
        this.mNameTextView = (TextView) this.mContentLayout.findViewById(C0965R.id.carmode_map_poi_panel_right_place);
        this.mAddrTextView = (TextView) this.mContentLayout.findViewById(C0965R.id.carmode_map_poi_panel_right_addr);
        this.mPhoneNumberTextView = (TextView) this.mContentLayout.findViewById(C0965R.id.carmode_map_poi_panel_right_phone);
        this.mDistanceTextView = (TextView) this.mContentLayout.findViewById(C0965R.id.carmode_map_poi_panel_right_distance);
        this.mNameAddrLayout = this.mContentLayout.findViewById(C0965R.id.carmode_map_poi_panel_right_place_layout);
        this.mPhoneLayout = this.mContentLayout.findViewById(C0965R.id.carmode_map_poi_panel_right_phone_layout);
        this.mDistanceLayout = this.mContentLayout.findViewById(C0965R.id.carmode_map_poi_panel_right_distance_layout);
        this.mFavBtn = (ImageView) this.mContentLayout.findViewById(C0965R.id.carmode_map_poi_panel_right_fav_btn);
        this.mPhoneLayout.setOnClickListener(new C39893());
        this.mDistanceLayout.setOnClickListener(new C39904());
        this.mNameAddrLayout.setOnClickListener(new C39915());
    }

    private void initSkins() {
    }

    public void updateStyle() {
    }

    public void updateContent() {
        initContents();
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

    private void initContents() {
        poiDetailViewControllerInit();
        if (this.mCurrentPoi != null && this.mCurrentPoi.mName != null && !this.mCurrentPoi.mName.isEmpty()) {
            int i;
            this.mNameTextView.setText(this.mCurrentPoi.mName);
            this.mAddrTextView.setText(this.mCurrentPoi.mAddress);
            if (TextUtils.isEmpty(this.mCurrentPoi.mPhone) || this.mCurrentPoi.mPhone.equals("null")) {
                this.mPhoneNumberTextView.setText(C0965R.string.no_phone);
                this.mPhoneLayout.setClickable(false);
            } else {
                this.mPhoneNumberTextView.setText(this.mCurrentPoi.mPhone + "　");
                this.mPhoneLayout.setClickable(true);
            }
            View view = this.mDistanceLayout;
            if (this.isMyPosition) {
                i = 8;
            } else {
                i = 0;
            }
            view.setVisibility(i);
            TextView textView = this.mDistanceTextView;
            StringBuilder append = new StringBuilder().append("距离");
            PoiController poiController = this.mPoiController;
            textView.setText(append.append(PoiController.getInstance().getDistance2CurrentPoint(this.mCurrentPoi)).toString());
            if (this.mCurrentPoi.mName.equals(StyleManager.getString(C0965R.string.poi_on_map))) {
                this.mNameAddrLayout.setClickable(false);
            } else {
                this.mNameAddrLayout.setClickable(true);
            }
            if (this.mCurrentPoi.mName.equals(StyleManager.getString(C0965R.string.poi_on_map))) {
                this.mNameAddrLayout.setClickable(false);
            } else {
                this.mNameAddrLayout.setClickable(true);
            }
            updateFavBtnBackground();
        }
    }

    public void antiPoi(GeoPoint geopoint, long xOffset, long yOffset) {
        if (geopoint != null && geopoint.isValid()) {
            this.isPickPoi = false;
            SearchPoi poi = new SearchPoi();
            poi.mViewPoint = geopoint;
            poi.mGuidePoint = geopoint;
            if (this.isMyPosition) {
                this.mPoiController.clearPoiCache();
            } else {
                this.mPoiController.focusPoi(poi);
            }
            int netMode = this.mPoiController.getAntiPoiNetMode(geopoint);
            if (netMode == -1) {
                poi.mName = StyleManager.getString(C0965R.string.poi_on_map);
            } else {
                if (this.mPoiController.antiGeo(poi, netMode, this.mUIHandler)) {
                    startAntiGeo();
                }
                this.mPoiController.animationTo(geopoint, xOffset, yOffset);
            }
            setSearchPoi(poi);
        }
    }

    public void pickPoi(SearchPoi searchPoi, long xOffset, long yOffset) {
        if (searchPoi != null && searchPoi.mViewPoint != null && searchPoi.mViewPoint.isValid()) {
            this.isPickPoi = true;
            if (this.isMyPosition) {
                this.mPoiController.clearPoiCache();
            } else {
                this.mPoiController.focusPoi(searchPoi);
                this.mPoiController.animationTo(searchPoi, xOffset, yOffset);
            }
            int netMode = this.mPoiController.getAntiPoiNetMode(searchPoi.mViewPoint);
            if (netMode != -1 && this.mPoiController.antiGeo(searchPoi, netMode, this.mUIHandler)) {
                startAntiGeo();
            }
            setSearchPoi(searchPoi);
        }
    }

    private void startAntiGeo() {
    }

    public void setMyPositionMode(boolean isMyPosition) {
        this.isMyPosition = isMyPosition;
        this.mDistanceLayout.setVisibility(isMyPosition ? 8 : 0);
    }

    public boolean isVisible() {
        return getVisibility() == 0;
    }

    public void hide() {
        setVisibility(8);
    }

    public void show() {
        setVisibility(0);
    }

    public void handleShortUri(String shortUri) {
        if (this.mContext != null) {
            this.mPoiController.sharePoiParseShortUrl(shortUri, this.mUIHandler);
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
            if (this.mComeFrom == 8) {
                StatisticManager.onEvent(StatisticConstants.DISCOVER_QJY_0002, StatisticConstants.DISCOVER_QJY_0002);
            }
            this.mPoiController.startCalcRoute(this.mCurrentPoi, this.mOnDialogListener);
        }
    }

    private void startPhoneCall() {
        if (!ForbidDaulClickUtils.isFastDoubleClick() && this.mPoiController != null && this.mCurrentPoi != null) {
            this.mPoiController.callPhone(this.mCurrentPoi);
        }
    }

    public void setOnDialogListener(C1277e listener) {
        this.mOnDialogListener = listener;
    }
}
