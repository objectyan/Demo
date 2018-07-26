package com.baidu.navi.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.screen.C1277e;
import com.baidu.navi.adapter.PoiListPagerAdapter;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.CommonParams.Const.ModelName;
import com.baidu.navisdk.CommonParams.NL_Net_Mode;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.util.common.ScreenUtil;
import java.util.ArrayList;

public class PoiListView extends FrameLayout {
    private int VIEW_HEIGHT;
    private boolean isAnimationing;
    private boolean isFirstTime;
    private boolean isOut;
    private PoiListPagerAdapter mAdapter;
    private ImageView mBtnDown;
    private ImageView mBtnUp;
    private int[] mChildCnt;
    private int[] mChildIndex;
    private View mContentLayout;
    private int mCurrentId;
    private int mCurrentIndex;
    private SearchPoi mCurrentPoi;
    private int mDuration;
    private NL_Net_Mode mNetMode;
    private C1277e mOnDialogListener;
    private OnPageChangeListener mOnPageChangeListener;
    private ArrayList<SearchPoi> mParPoiList;
    private PoiController mPoiController;
    private ArrayList<SearchPoi> mPoiList;
    private LinearLayout mTagLayout;
    private ImageView[] mTagViews;
    private Handler mUIHandler;
    private HeightWrapableViewPager mViewPager;
    private LayoutParams mViewPagerLayoutParams;

    /* renamed from: com.baidu.navi.view.PoiListView$1 */
    class C40191 implements OnClickListener {
        C40191() {
        }

        public void onClick(View v) {
            if (PoiListView.this.isOut) {
                PoiListView.this.inAnimation();
            } else {
                PoiListView.this.outAnimation();
            }
        }
    }

    /* renamed from: com.baidu.navi.view.PoiListView$2 */
    class C40202 implements OnPageChangeListener {
        C40202() {
        }

        public void onPageSelected(int arg0) {
            if (PoiListView.this.mCurrentIndex == -1) {
                PoiListView.this.mCurrentIndex = 0;
            }
            if (PoiListView.this.mCurrentIndex < arg0) {
                StatisticManager.onEvent(StatisticConstants.POIDETAIL_SLIPLEFT, StatisticConstants.POIDETAIL_SLIPLEFT);
            } else if (PoiListView.this.mCurrentIndex > arg0) {
                StatisticManager.onEvent(StatisticConstants.POIDETAIL_SLIPRIGHT, StatisticConstants.POIDETAIL_SLIPRIGHT);
            }
            PoiListView.this.mTagViews[PoiListView.this.mCurrentIndex].setImageDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_poi_detail_ic_tag_normal));
            PoiListView.this.mCurrentIndex = arg0;
            PoiListView.this.mCurrentPoi = (SearchPoi) PoiListView.this.mPoiList.get(PoiListView.this.mCurrentIndex);
            PoiListView.this.mTagViews[PoiListView.this.mCurrentIndex].setImageDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_poi_detail_ic_tag_select));
            if (PoiListView.this.mCurrentIndex == 0) {
                PoiListView.this.mBtnUp.setVisibility(4);
            } else {
                PoiListView.this.mBtnUp.setVisibility(0);
            }
            if (PoiListView.this.mCurrentIndex == PoiListView.this.mTagViews.length - 1) {
                PoiListView.this.mBtnDown.setVisibility(4);
            } else {
                PoiListView.this.mBtnDown.setVisibility(0);
            }
            if (PoiListView.this.mChildCnt != null && PoiListView.this.mChildCnt[PoiListView.this.mCurrentIndex] > 0) {
                ArrayList<SearchPoi> mCurrentPoiList = new ArrayList(PoiListView.this.mChildCnt[PoiListView.this.mCurrentIndex] + 1);
                ArrayList<SearchPoi> poiList = (ArrayList) ((PoiSearchModel) NaviDataEngine.getInstance().getModel(ModelName.POI_SEARCH)).getPoiList();
                mCurrentPoiList.add(poiList.get(PoiListView.this.mCurrentIndex));
                for (int i = 0; i < PoiListView.this.mChildCnt[PoiListView.this.mCurrentIndex]; i++) {
                    mCurrentPoiList.add(poiList.get(PoiListView.this.mChildIndex[PoiListView.this.mCurrentIndex] + i));
                }
                PoiListView.this.mCurrentId = 0;
                PoiListView.this.mParPoiList = mCurrentPoiList;
                PoiListView.this.mPoiController.focusPoi(PoiListView.this.mParPoiList, PoiListView.this.mCurrentId);
            } else if (PoiListView.this.mCurrentPoi.mFCType == 1) {
                PoiListView.this.mCurrentId = PoiListView.this.mCurrentIndex + 1;
                PoiListView.this.mPoiController.focusPoi(PoiListView.this.mParPoiList, PoiListView.this.mCurrentId);
            } else {
                PoiListView.this.mCurrentId = 0;
                PoiListView.this.mPoiController.focusPoi(PoiListView.this.mCurrentPoi);
            }
            PoiListView.this.mPoiController.animationByFrogleap(PoiListView.this.mCurrentPoi);
            PoiListView.this.mAdapter.selectIndex(PoiListView.this.mCurrentIndex);
        }

        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        public void onPageScrollStateChanged(int arg0) {
        }
    }

    /* renamed from: com.baidu.navi.view.PoiListView$3 */
    class C40213 implements OnGlobalLayoutListener {
        C40213() {
        }

        public void onGlobalLayout() {
            if (PoiListView.this.VIEW_HEIGHT == 0 || PoiListView.this.mViewPagerLayoutParams == null) {
                PoiListView.this.VIEW_HEIGHT = PoiListView.this.mViewPager.getHeight();
                PoiListView.this.mViewPagerLayoutParams = PoiListView.this.mViewPager.getLayoutParams();
                if (PoiListView.this.VIEW_HEIGHT != 0 && PoiListView.this.mViewPagerLayoutParams != null) {
                    PoiListView.this.mViewPagerLayoutParams.height = PoiListView.this.VIEW_HEIGHT - PoiDetailView.getCap();
                    PoiListView.this.mViewPager.setLayoutParams(PoiListView.this.mViewPagerLayoutParams);
                    PoiListView.this.isOut = false;
                    PoiListView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            }
        }
    }

    /* renamed from: com.baidu.navi.view.PoiListView$4 */
    class C40224 implements OnClickListener {
        C40224() {
        }

        public void onClick(View v) {
            if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                StatisticManager.onEvent(StatisticConstants.POIDETAIL_CLICKLEFT, StatisticConstants.POIDETAIL_CLICKLEFT);
                if (PoiListView.this.mCurrentIndex > 0) {
                    PoiListView.this.mViewPager.setCurrentItem(PoiListView.this.mCurrentIndex - 1, true);
                }
            }
        }
    }

    /* renamed from: com.baidu.navi.view.PoiListView$5 */
    class C40235 implements OnClickListener {
        C40235() {
        }

        public void onClick(View v) {
            if (!ForbidDaulClickUtils.isFastDoubleClick()) {
                StatisticManager.onEvent(StatisticConstants.POIDETAIL_CLICKRIGHT, StatisticConstants.POIDETAIL_CLICKRIGHT);
                if (PoiListView.this.mCurrentIndex < 0) {
                    PoiListView.this.mCurrentIndex = 0;
                }
                if (PoiListView.this.mCurrentIndex < PoiListView.this.mPoiList.size() - 1) {
                    PoiListView.this.mViewPager.setCurrentItem(PoiListView.this.mCurrentIndex + 1, true);
                }
            }
        }
    }

    public PoiListView(Context context) {
        super(context);
        this.mCurrentIndex = -1;
        this.mCurrentId = 0;
        this.isFirstTime = true;
        this.VIEW_HEIGHT = 0;
        this.isOut = false;
        this.isAnimationing = false;
        this.mChildIndex = new int[200];
        this.mChildCnt = new int[200];
        this.mOnPageChangeListener = new C40202();
        PoiDetailView.isPanelOut = false;
        findViews(context);
        initSkins();
        this.mUIHandler = new Handler(Looper.getMainLooper());
        this.mDuration = PoiDetailView.getCap() / 10;
    }

    public PoiListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mCurrentIndex = -1;
        this.mCurrentId = 0;
        this.isFirstTime = true;
        this.VIEW_HEIGHT = 0;
        this.isOut = false;
        this.isAnimationing = false;
        this.mChildIndex = new int[200];
        this.mChildCnt = new int[200];
        this.mOnPageChangeListener = new C40202();
        PoiDetailView.isPanelOut = false;
        findViews(context);
        initSkins();
        this.mUIHandler = new Handler(Looper.getMainLooper());
        this.mDuration = PoiDetailView.getCap() / 10;
    }

    public PoiListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mCurrentIndex = -1;
        this.mCurrentId = 0;
        this.isFirstTime = true;
        this.VIEW_HEIGHT = 0;
        this.isOut = false;
        this.isAnimationing = false;
        this.mChildIndex = new int[200];
        this.mChildCnt = new int[200];
        this.mOnPageChangeListener = new C40202();
        PoiDetailView.isPanelOut = false;
        findViews(context);
        initSkins();
        this.mUIHandler = new Handler(Looper.getMainLooper());
        this.mDuration = PoiDetailView.getCap() / 10;
    }

    public void setSearchPoiList(ArrayList<SearchPoi> poiList) {
        if (poiList != null) {
            this.mPoiList = poiList;
            this.mAdapter = new PoiListPagerAdapter(getContext(), this.mPoiList, this.mPoiController, this.mOnDialogListener);
            this.mViewPager.setAdapter(this.mAdapter);
            this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
            initContents();
            this.mAdapter.setDragonOnClickListener(new C40191());
        }
    }

    public void setChildIndex(int[] ChildIndex) {
        this.mChildIndex = ChildIndex;
    }

    public void setChildCnt(int[] ChildCnt) {
        this.mChildCnt = ChildCnt;
    }

    public void setCurrentIndex(int index, ArrayList<SearchPoi> PoiList, int id) {
        if (index >= 0 && PoiList != null && id < PoiList.size()) {
            this.mCurrentPoi = (SearchPoi) PoiList.get(id);
            this.mParPoiList = PoiList;
            this.mCurrentId = id;
            if (this.mCurrentIndex == index) {
                this.mPoiController.animationTo(this.mCurrentPoi);
            } else {
                this.mViewPager.setCurrentItem(index);
            }
            if (PoiList.size() > 1) {
                this.mPoiController.focusPoi(PoiList, id);
            } else {
                this.mPoiController.focusPoi(this.mCurrentPoi);
            }
        }
    }

    public ArrayList<SearchPoi> getCurrentPoiList() {
        return this.mParPoiList;
    }

    public void setCurrentIndex(int index) {
        if (index >= 0 && this.mPoiList != null && index < this.mPoiList.size()) {
            this.mCurrentPoi = (SearchPoi) this.mPoiList.get(index);
            if (this.mCurrentIndex == index) {
                this.mPoiController.animationTo(this.mCurrentPoi);
            } else {
                this.mViewPager.setCurrentItem(index);
            }
            this.mPoiController.focusPoi(this.mCurrentPoi);
        }
    }

    public boolean isOut() {
        return this.isOut;
    }

    public int getViewHeight() {
        if (this.isOut) {
            return ScreenUtil.getInstance().dip2px(369);
        }
        return ScreenUtil.getInstance().dip2px(C1253f.dq);
    }

    public void setController(PoiController controller) {
        this.mPoiController = controller;
    }

    public int getCurretnIndex() {
        if (this.mCurrentIndex == -1) {
            this.mCurrentIndex = 0;
        }
        return this.mCurrentIndex;
    }

    public int getCurretnId() {
        return this.mCurrentId;
    }

    public SearchPoi getCurrentSearchPoi() {
        return this.mCurrentPoi;
    }

    private void findViews(Context context) {
        this.mContentLayout = LayoutInflater.from(context).inflate(C0965R.layout.poi_list_panel, null);
        addView(this.mContentLayout);
        this.mBtnDown = (ImageView) this.mContentLayout.findViewById(C0965R.id.pager_down);
        this.mBtnUp = (ImageView) this.mContentLayout.findViewById(C0965R.id.pager_up);
        this.mViewPager = (HeightWrapableViewPager) this.mContentLayout.findViewById(C0965R.id.vp_poi_switch);
        this.mTagLayout = (LinearLayout) this.mContentLayout.findViewById(C0965R.id.tag_layout);
        this.mBtnUp.setVisibility(4);
        getViewTreeObserver().addOnGlobalLayoutListener(new C40213());
    }

    private void outAnimation() {
        this.mViewPagerLayoutParams.height = this.VIEW_HEIGHT;
        this.isOut = true;
        this.mAdapter.setIsDragonOut(this.isOut);
        this.mPoiController.setMapffset(0, BNMapController.getInstance().getMapStatus()._Yoffset + ((long) (PoiDetailView.getCap() / 2)));
        this.mViewPager.setLayoutParams(this.mViewPagerLayoutParams);
    }

    private void inAnimation() {
        this.mViewPagerLayoutParams.height = this.VIEW_HEIGHT - PoiDetailView.getCap();
        this.isOut = false;
        this.mAdapter.setIsDragonOut(this.isOut);
        this.mPoiController.setMapffset(0, BNMapController.getInstance().getMapStatus()._Yoffset - ((long) (PoiDetailView.getCap() / 2)));
        this.mViewPager.setLayoutParams(this.mViewPagerLayoutParams);
    }

    private void initSkins() {
        this.mBtnDown.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_poi_detail_ic_down_selector));
        this.mBtnUp.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_poi_detail_ic_up_selector));
        this.mBtnDown.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_bg_pressed_mask_selector));
        this.mBtnUp.setBackgroundDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_common_bg_pressed_mask_selector));
        this.mContentLayout.setBackgroundColor(StyleManager.getColor(C0965R.color.bnav_common_bg));
        if (this.mTagViews != null) {
            for (ImageView imageDrawable : this.mTagViews) {
                imageDrawable.setImageDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_poi_detail_ic_tag_normal));
            }
            if (this.mCurrentIndex >= 0 && this.mCurrentIndex < this.mTagViews.length) {
                this.mTagViews[this.mCurrentIndex].setImageDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_poi_detail_ic_tag_select));
            }
        }
    }

    public void updateStyle() {
        initSkins();
        if (this.mAdapter != null) {
            this.mAdapter.updateStyle();
        }
    }

    public void updateContent() {
        initContents();
    }

    private void initContents() {
        if (this.mPoiList != null && this.mPoiList.size() != 0) {
            this.mTagViews = new ImageView[this.mPoiList.size()];
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-2, -2);
            lp.gravity = 17;
            lp.leftMargin = ScreenUtil.getInstance().dip2px(5);
            lp.rightMargin = ScreenUtil.getInstance().dip2px(5);
            for (int i = 0; i < this.mPoiList.size(); i++) {
                this.mTagViews[i] = new ImageView(getContext());
                this.mTagViews[i].setImageDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_poi_detail_ic_tag_normal));
                this.mTagLayout.addView(this.mTagViews[i], lp);
            }
            this.mTagViews[0].setImageDrawable(StyleManager.getDrawable(C0965R.drawable.bnav_poi_detail_ic_tag_select));
            this.mBtnUp.setOnClickListener(new C40224());
            this.mBtnDown.setOnClickListener(new C40235());
        }
    }

    public void setOnDialogListener(C1277e listner) {
        this.mOnDialogListener = listner;
    }
}
