package com.baidu.navi.view;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
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
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.util.common.ScreenUtil;
import java.util.ArrayList;

public class CarmodePoiListView extends FrameLayout {
    private TextView mAddrTextView;
    private ImageView mBtnDown;
    private ImageView mBtnUp;
    private IPoiDetailViewCallBack mCallBack;
    private int[] mChildCnt;
    private int[] mChildIndex;
    private int mComeFrom;
    private View mContentLayout;
    private int mCurrentId;
    private int mCurrentIndex;
    private SearchPoi mCurrentPoi;
    private View mDistanceLayout;
    private TextView mDistanceTextView;
    private ImageView mFavBtn;
    private View mNameAddrLayout;
    private TextView mNameTextView;
    private C1277e mOnDialogListener;
    private ArrayList<SearchPoi> mParPoiList;
    private View mPhoneLayout;
    private TextView mPhoneNumberTextView;
    private PoiController mPoiController;
    private PoiDetailViewController mPoiDetailViewController;
    private ArrayList<SearchPoi> mPoiList;
    private Handler mUIHandler;
    private long xOffset;
    private long yOffset;

    /* renamed from: com.baidu.navi.view.CarmodePoiListView$1 */
    class C39931 implements IPoiDetailViewCallBack {
        C39931() {
        }

        public void onFavSyncDone(String msg) {
            CarmodePoiListView.this.updateFavBtnBackground();
        }
    }

    /* renamed from: com.baidu.navi.view.CarmodePoiListView$2 */
    class C39942 implements OnClickListener {
        C39942() {
        }

        public void onClick(View v) {
            CarmodePoiListView.this.startPhoneCall();
        }
    }

    /* renamed from: com.baidu.navi.view.CarmodePoiListView$3 */
    class C39953 implements OnClickListener {
        C39953() {
        }

        public void onClick(View v) {
            CarmodePoiListView.this.startCalcRoute();
        }
    }

    /* renamed from: com.baidu.navi.view.CarmodePoiListView$4 */
    class C39964 implements OnClickListener {
        C39964() {
        }

        public void onClick(View v) {
            CarmodePoiListView.this.clickFavBtn();
        }
    }

    /* renamed from: com.baidu.navi.view.CarmodePoiListView$5 */
    class C39975 implements OnClickListener {
        C39975() {
        }

        public void onClick(View v) {
            if (!ForbidDaulClickUtils.isFastDoubleClick() && CarmodePoiListView.this.mCurrentIndex > 0) {
                CarmodePoiListView.this.mCurrentIndex = CarmodePoiListView.this.mCurrentIndex - 1;
                CarmodePoiListView.this.mCurrentPoi = (SearchPoi) CarmodePoiListView.this.mPoiList.get(CarmodePoiListView.this.mCurrentIndex);
                CarmodePoiListView.this.updateUpDownBtn();
                CarmodePoiListView.this.updatePoiInfo(CarmodePoiListView.this.mCurrentPoi);
                if (CarmodePoiListView.this.mChildCnt != null && CarmodePoiListView.this.mChildCnt[CarmodePoiListView.this.mCurrentIndex] > 0) {
                    ArrayList<SearchPoi> mCurrentPoiList = new ArrayList(CarmodePoiListView.this.mChildCnt[CarmodePoiListView.this.mCurrentIndex] + 1);
                    ArrayList<SearchPoi> poiList = (ArrayList) ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getPoiList();
                    mCurrentPoiList.add(poiList.get(CarmodePoiListView.this.mCurrentIndex));
                    for (int i = 0; i < CarmodePoiListView.this.mChildCnt[CarmodePoiListView.this.mCurrentIndex]; i++) {
                        mCurrentPoiList.add(poiList.get(CarmodePoiListView.this.mChildIndex[CarmodePoiListView.this.mCurrentIndex] + i));
                    }
                    CarmodePoiListView.this.mCurrentId = 0;
                    CarmodePoiListView.this.mParPoiList = mCurrentPoiList;
                    CarmodePoiListView.this.mPoiController.focusPoi(CarmodePoiListView.this.mParPoiList, CarmodePoiListView.this.mCurrentId);
                } else if (CarmodePoiListView.this.mCurrentPoi.mFCType == 1) {
                    CarmodePoiListView.this.mCurrentId = CarmodePoiListView.this.mCurrentIndex + 1;
                    CarmodePoiListView.this.mPoiController.focusPoi(CarmodePoiListView.this.mParPoiList, CarmodePoiListView.this.mCurrentId);
                } else {
                    CarmodePoiListView.this.mCurrentId = 0;
                    CarmodePoiListView.this.mPoiController.focusPoi(CarmodePoiListView.this.mCurrentPoi);
                }
                CarmodePoiListView.this.mPoiController.animationByFrogleap(CarmodePoiListView.this.mCurrentPoi);
            }
        }
    }

    /* renamed from: com.baidu.navi.view.CarmodePoiListView$6 */
    class C39986 implements OnClickListener {
        C39986() {
        }

        public void onClick(View v) {
            if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                if (CarmodePoiListView.this.mCurrentIndex < 0) {
                    CarmodePoiListView.this.mCurrentIndex = 0;
                }
                if (CarmodePoiListView.this.mCurrentIndex < CarmodePoiListView.this.mPoiList.size() - 1) {
                    CarmodePoiListView.this.mCurrentIndex = CarmodePoiListView.this.mCurrentIndex + 1;
                    CarmodePoiListView.this.mCurrentPoi = (SearchPoi) CarmodePoiListView.this.mPoiList.get(CarmodePoiListView.this.mCurrentIndex);
                    CarmodePoiListView.this.updateUpDownBtn();
                    CarmodePoiListView.this.updatePoiInfo(CarmodePoiListView.this.mCurrentPoi);
                    if (CarmodePoiListView.this.mChildCnt != null && CarmodePoiListView.this.mChildCnt[CarmodePoiListView.this.mCurrentIndex] > 0) {
                        ArrayList<SearchPoi> mCurrentPoiList = new ArrayList(CarmodePoiListView.this.mChildCnt[CarmodePoiListView.this.mCurrentIndex] + 1);
                        ArrayList<SearchPoi> poiList = (ArrayList) ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getPoiList();
                        mCurrentPoiList.add(poiList.get(CarmodePoiListView.this.mCurrentIndex));
                        for (int i = 0; i < CarmodePoiListView.this.mChildCnt[CarmodePoiListView.this.mCurrentIndex]; i++) {
                            mCurrentPoiList.add(poiList.get(CarmodePoiListView.this.mChildIndex[CarmodePoiListView.this.mCurrentIndex] + i));
                        }
                        CarmodePoiListView.this.mCurrentId = 0;
                        CarmodePoiListView.this.mParPoiList = mCurrentPoiList;
                        CarmodePoiListView.this.mPoiController.focusPoi(CarmodePoiListView.this.mParPoiList, CarmodePoiListView.this.mCurrentId);
                    } else if (CarmodePoiListView.this.mCurrentPoi.mFCType == 1) {
                        CarmodePoiListView.this.mCurrentId = CarmodePoiListView.this.mCurrentIndex + 1;
                        CarmodePoiListView.this.mPoiController.focusPoi(CarmodePoiListView.this.mParPoiList, CarmodePoiListView.this.mCurrentId);
                    } else {
                        CarmodePoiListView.this.mCurrentId = 0;
                        CarmodePoiListView.this.mPoiController.focusPoi(CarmodePoiListView.this.mCurrentPoi);
                    }
                    CarmodePoiListView.this.mPoiController.animationByFrogleap(CarmodePoiListView.this.mCurrentPoi);
                    CarmodePoiListView.this.mPoiController.animationTo(CarmodePoiListView.this.mCurrentPoi, CarmodePoiListView.this.xOffset, CarmodePoiListView.this.yOffset);
                }
            }
        }
    }

    private class HaveFavTask extends AsyncTask<Void, Void, Boolean> {
        private int index;

        public HaveFavTask(int currentIndex) {
            this.index = currentIndex;
        }

        protected Boolean doInBackground(Void... params) {
            return Boolean.valueOf(CarmodePoiListView.this.mPoiDetailViewController.isHaveFav());
        }

        protected void onPostExecute(Boolean result) {
            if (this.index == CarmodePoiListView.this.mCurrentIndex) {
                CarmodePoiListView.this.updateFavBtn(result.booleanValue());
            }
        }
    }

    private void poiDetailViewControllerInit() {
        this.mPoiDetailViewController.init(this.mCurrentPoi);
        this.mPoiDetailViewController.setCallBack(this.mCallBack);
    }

    public CarmodePoiListView(Context context) {
        super(context);
        this.mCurrentIndex = 0;
        this.mCurrentId = 0;
        this.mPoiDetailViewController = new PoiDetailViewController();
        this.mChildIndex = new int[200];
        this.mChildCnt = new int[200];
        this.xOffset = (long) (ScreenUtil.getInstance().dip2px(-250) / 2);
        this.yOffset = (long) (ScreenUtil.getInstance().dip2px(0) / 2);
        this.mCallBack = new C39931();
        findViews(context);
        initSkins();
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    public CarmodePoiListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mCurrentIndex = 0;
        this.mCurrentId = 0;
        this.mPoiDetailViewController = new PoiDetailViewController();
        this.mChildIndex = new int[200];
        this.mChildCnt = new int[200];
        this.xOffset = (long) (ScreenUtil.getInstance().dip2px(-250) / 2);
        this.yOffset = (long) (ScreenUtil.getInstance().dip2px(0) / 2);
        this.mCallBack = new C39931();
        findViews(context);
        initSkins();
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    public CarmodePoiListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mCurrentIndex = 0;
        this.mCurrentId = 0;
        this.mPoiDetailViewController = new PoiDetailViewController();
        this.mChildIndex = new int[200];
        this.mChildCnt = new int[200];
        this.xOffset = (long) (ScreenUtil.getInstance().dip2px(-250) / 2);
        this.yOffset = (long) (ScreenUtil.getInstance().dip2px(0) / 2);
        this.mCallBack = new C39931();
        findViews(context);
        initSkins();
        this.mUIHandler = new Handler(Looper.getMainLooper());
    }

    public void setComeFrom(int comeFrom) {
        this.mComeFrom = comeFrom;
    }

    public void setSearchPoiList(ArrayList<SearchPoi> poiList) {
        if (poiList != null) {
            this.mPoiList = poiList;
            initContents();
        }
    }

    public void setChildIndex(int[] childIndex) {
        this.mChildIndex = childIndex;
    }

    public void setChildCnt(int[] childCnt) {
        this.mChildCnt = childCnt;
    }

    public void updatePoiInfo(SearchPoi poi) {
        poiDetailViewControllerInit();
        this.mNameTextView.setText(poi.mName);
        if (poi.mAddress == null) {
            this.mAddrTextView.setVisibility(4);
        } else {
            this.mAddrTextView.setVisibility(0);
            this.mAddrTextView.setText(poi.mAddress);
        }
        if (this.mCurrentPoi.mName.equals(StyleManager.getString(C0965R.string.poi_on_map))) {
            this.mNameAddrLayout.setClickable(false);
        } else {
            this.mNameAddrLayout.setClickable(true);
        }
        this.mPhoneLayout.setVisibility(0);
        this.mDistanceLayout.setVisibility(0);
        if (poi.mPhone == null || poi.mPhone.isEmpty()) {
            this.mPhoneNumberTextView.setText(C0965R.string.no_phone);
        } else {
            this.mPhoneNumberTextView.setText(poi.mPhone + "　");
        }
        TextView textView = this.mDistanceTextView;
        StringBuilder append = new StringBuilder().append("距离");
        PoiController poiController = this.mPoiController;
        textView.setText(append.append(PoiController.getInstance().getDistance2CurrentPoint(this.mCurrentPoi)).toString());
        updateFavBtnBackground();
    }

    public void updateUpDownBtn() {
        if (this.mPoiList != null) {
            if (this.mCurrentIndex == 0) {
                this.mBtnUp.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.map_ic_poi_details_prev_disabled));
                this.mBtnUp.setEnabled(false);
            } else {
                this.mBtnUp.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.map_ic_poi_details_prev));
                this.mBtnUp.setEnabled(true);
            }
            if (this.mCurrentIndex == this.mPoiList.size() - 1) {
                this.mBtnDown.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.map_ic_poi_details_next_disabled));
                this.mBtnDown.setEnabled(false);
                return;
            }
            this.mBtnDown.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.map_ic_poi_details_next));
            this.mBtnDown.setEnabled(true);
        }
    }

    public void setCurrentIndex(int index, ArrayList<SearchPoi> poiList, int id) {
        if (index >= 0 && poiList != null && id < poiList.size()) {
            this.mCurrentIndex = index;
            this.mCurrentId = id;
            this.mCurrentPoi = (SearchPoi) poiList.get(id);
            this.mParPoiList = poiList;
            this.mPoiController.animationTo(this.mCurrentPoi);
            updatePoiInfo(this.mCurrentPoi);
            if (poiList.size() > 1) {
                this.mPoiController.focusPoi(poiList, id);
            } else {
                this.mPoiController.focusPoi(this.mCurrentPoi);
            }
            updateUpDownBtn();
        }
    }

    public ArrayList<SearchPoi> getCurrentPoiList() {
        return this.mParPoiList;
    }

    public void setCurrentIndex(int index) {
        if (index >= 0 && this.mPoiList != null && index < this.mPoiList.size()) {
            this.mCurrentIndex = index;
            this.mCurrentPoi = (SearchPoi) this.mPoiList.get(index);
            this.mPoiController.focusPoi(this.mCurrentPoi);
            this.mPoiController.animationTo(this.mCurrentPoi);
            updatePoiInfo(this.mCurrentPoi);
            updateUpDownBtn();
        }
    }

    public void setController(PoiController controller) {
        this.mPoiController = controller;
    }

    public int getCurretnIndex() {
        return this.mCurrentIndex;
    }

    public int getCurretnId() {
        return this.mCurrentId;
    }

    public SearchPoi getCurrentSearchPoi() {
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
        this.mBtnDown = (ImageView) this.mContentLayout.findViewById(C0965R.id.carmode_map_poi_panel_right_down);
        this.mBtnUp = (ImageView) this.mContentLayout.findViewById(C0965R.id.carmode_map_poi_panel_right_up);
        this.mBtnUp.setVisibility(4);
        this.mFavBtn = (ImageView) this.mContentLayout.findViewById(C0965R.id.carmode_map_poi_panel_right_fav_btn);
        this.mPhoneLayout.setOnClickListener(new C39942());
        this.mDistanceLayout.setOnClickListener(new C39953());
        this.mNameAddrLayout.setOnClickListener(new C39964());
    }

    private void initSkins() {
    }

    public void updateStyle() {
        initSkins();
    }

    public void updateContent() {
        initContents();
    }

    private void updateFavBtnBackground() {
        new HaveFavTask(this.mCurrentIndex).execute(new Void[0]);
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
        if (this.mPoiList != null && this.mPoiList.size() != 0) {
            if (this.mPoiList.size() > 1) {
                this.mBtnUp.setVisibility(0);
                this.mBtnDown.setVisibility(0);
            }
            this.mBtnUp.setOnClickListener(new C39975());
            this.mBtnDown.setOnClickListener(new C39986());
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
