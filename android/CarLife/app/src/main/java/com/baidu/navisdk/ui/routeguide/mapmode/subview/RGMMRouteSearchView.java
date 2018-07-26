package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.model.RGControlPanelModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener.ActionTypeSearchParams;
import com.baidu.navisdk.ui.routeguide.subview.util.RightHandResourcesProvider;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.AnimationUtil;
import com.baidu.navisdk.util.common.AnimationUtil.AnimationType;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGMMRouteSearchView extends BNBaseView {
    private static final int MSG_COUNT_DOWN_DELAY_MILLIS = 1000;
    private static final int MSG_WHAT_COUNT_DOWN = 1;
    private View mBankView;
    private final int[] mDrawableResId = new int[]{C4048R.drawable.nsdk_drawable_rg_route_search_gas_station, C4048R.drawable.nsdk_drawable_rg_route_search_bank, C4048R.drawable.nsdk_drawable_rg_route_search_toilet, C4048R.drawable.nsdk_drawable_rg_route_search_spots, C4048R.drawable.nsdk_drawable_rg_route_search_restaurant, C4048R.drawable.nsdk_drawable_rg_route_search_hotel};
    private View mGasStationView;
    private final int[] mHLineViewId = new int[]{C4048R.id.iv_h_divider_1, C4048R.id.iv_h_divider_2};
    private View mHotelView;
    private final int[] mImgViewId = new int[]{C4048R.id.bnav_rs_gas_station_iv, C4048R.id.bnav_rs_bank_iv, C4048R.id.bnav_rs_toilet_iv, C4048R.id.bnav_rs_spots_iv, C4048R.id.bnav_rs_restaurant_iv, C4048R.id.bnav_rs_hotel_iv};
    private View mMenuClosePanel = null;
    private final int[] mNameResId = new int[]{C4048R.string.nsdk_string_rg_as_gas_station, C4048R.string.nsdk_string_rg_as_bank, C4048R.string.nsdk_string_rg_as_toilet, C4048R.string.nsdk_string_rg_as_spots, C4048R.string.nsdk_string_rg_as_restaurant, C4048R.string.nsdk_string_rg_as_hotel, C4048R.string.nsdk_string_rg_as_car_service, C4048R.string.nsdk_string_rg_as_park, C4048R.string.nsdk_string_close};
    private View mRestaurantView;
    private ViewGroup mRouteSearchContainer;
    private ViewGroup mRouteSearchInnerPanel;
    private ViewGroup mRouteSearchPanel;
    private ViewGroup mRouteSearchView;
    private View mSpotsView;
    private final int[] mTextViewId = new int[]{C4048R.id.bnav_rs_gas_station_tv, C4048R.id.bnav_rs_bank_tv, C4048R.id.bnav_rs_toilet_tv, C4048R.id.bnav_rs_spots_tv, C4048R.id.bnav_rs_restaurant_tv, C4048R.id.bnav_rs_hotel_tv};
    private View mToiletView;
    private TextView mTvTitle;
    private final int[] mVLineViewId = new int[]{C4048R.id.iv_v_divider_1, C4048R.id.iv_v_divider_2, C4048R.id.iv_v_divider_3, C4048R.id.iv_v_divider_4};

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMRouteSearchView$1 */
    class C44251 implements OnClickListener {
        C44251() {
        }

        public void onClick(View v) {
            if (RGMMRouteSearchView.this.mSubViewListener != null && v != null) {
                if (v == RGMMRouteSearchView.this.mRouteSearchPanel) {
                    RGViewController.getInstance().hideRouteSearchView();
                    return;
                }
                if (!RightHandResourcesProvider.isInternationalWithToast(RGMMRouteSearchView.this.mContext)) {
                    if (v == RGMMRouteSearchView.this.mGasStationView) {
                        RGMMRouteSearchView.this.mSubViewListener.onOtherAction(9, 0, 0, ActionTypeSearchParams.Gas_Station);
                    } else if (v == RGMMRouteSearchView.this.mToiletView) {
                        RGMMRouteSearchView.this.mSubViewListener.onOtherAction(9, 0, 0, ActionTypeSearchParams.Toilet);
                    } else if (v == RGMMRouteSearchView.this.mBankView) {
                        RGMMRouteSearchView.this.mSubViewListener.onOtherAction(9, 0, 0, ActionTypeSearchParams.Bank);
                    } else if (v == RGMMRouteSearchView.this.mSpotsView) {
                        RGMMRouteSearchView.this.mSubViewListener.onOtherAction(9, 0, 0, ActionTypeSearchParams.Spots);
                    } else if (v == RGMMRouteSearchView.this.mRestaurantView) {
                        RGMMRouteSearchView.this.mSubViewListener.onOtherAction(9, 0, 0, ActionTypeSearchParams.Restaurant);
                    } else if (v == RGMMRouteSearchView.this.mHotelView) {
                        RGMMRouteSearchView.this.mSubViewListener.onOtherAction(9, 0, 0, ActionTypeSearchParams.Hotel);
                    }
                }
                RGControlPanelModel.mIsRouteSearchVisible = false;
                RGMMRouteSearchView.this.hide();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMRouteSearchView$2 */
    class C44262 implements AnimationListener {
        C44262() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            RGMMRouteSearchView.this.onHide();
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    public RGMMRouteSearchView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
        initViews();
        updateStyle(BNStyleManager.getDayStyle());
        initListener();
    }

    private void initViews() {
        if (this.mRootViewGroup != null) {
            this.mRouteSearchPanel = (ViewGroup) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_route_search_panel);
            this.mRouteSearchContainer = (ViewGroup) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_route_search_container);
            if (this.mRouteSearchContainer != null) {
                this.mRouteSearchContainer.removeAllViews();
            }
            this.mRouteSearchView = (ViewGroup) JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_rg_mapmode_route_search, null);
            if (this.mRouteSearchContainer != null && this.mRouteSearchView != null) {
                this.mRouteSearchContainer.addView(this.mRouteSearchView);
                this.mRouteSearchInnerPanel = (ViewGroup) this.mRouteSearchView.findViewById(C4048R.id.route_search_inner_panel);
                this.mTvTitle = (TextView) this.mRouteSearchView.findViewById(C4048R.id.tv_route_search_title);
                this.mGasStationView = this.mRouteSearchView.findViewById(C4048R.id.bnav_rs_gas_station);
                this.mToiletView = this.mRouteSearchView.findViewById(C4048R.id.bnav_rs_toilet);
                this.mBankView = this.mRouteSearchView.findViewById(C4048R.id.bnav_rs_bank);
                this.mSpotsView = this.mRouteSearchView.findViewById(C4048R.id.bnav_rs_spots);
                this.mRestaurantView = this.mRouteSearchView.findViewById(C4048R.id.bnav_rs_restaurant);
                this.mHotelView = this.mRouteSearchView.findViewById(C4048R.id.bnav_rs_hotel);
                this.mMenuClosePanel = this.mRouteSearchView.findViewById(C4048R.id.bnav_rg_close_content_panel);
            }
        }
    }

    private void initListener() {
        OnClickListener onClickListener = new C44251();
        this.mGasStationView.setOnClickListener(onClickListener);
        this.mToiletView.setOnClickListener(onClickListener);
        this.mBankView.setOnClickListener(onClickListener);
        this.mSpotsView.setOnClickListener(onClickListener);
        this.mRestaurantView.setOnClickListener(onClickListener);
        this.mHotelView.setOnClickListener(onClickListener);
        this.mRouteSearchPanel.setOnClickListener(onClickListener);
    }

    public void updateStyle(boolean day) {
        super.updateStyle(day);
        if (this.mTvTitle != null) {
            this.mTvTitle.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_b_mm));
            this.mTvTitle.setCompoundDrawablesWithIntrinsicBounds(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_rg_route_search_title_icon), null, null, null);
        }
        if (this.mRouteSearchInnerPanel != null) {
            this.mRouteSearchInnerPanel.setBackgroundColor(BNStyleManager.getColor(C4048R.color.cl_bg_d));
        }
        if (this.mMenuClosePanel != null) {
            this.mMenuClosePanel.setBackgroundColor(BNStyleManager.getColor(C4048R.color.cl_bg_d));
        }
        if (this.mRouteSearchView != null) {
            int i;
            View hl;
            for (int findViewById : this.mHLineViewId) {
                hl = this.mRouteSearchView.findViewById(findViewById);
                if (hl != null) {
                    hl.setBackgroundColor(BNStyleManager.getColor(C4048R.color.cl_bg_d_mm));
                }
            }
            for (int findViewById2 : this.mVLineViewId) {
                hl = this.mRouteSearchView.findViewById(findViewById2);
                if (hl != null) {
                    hl.setBackgroundColor(BNStyleManager.getColor(C4048R.color.cl_bg_d_mm));
                }
            }
            for (i = 0; i < this.mTextViewId.length; i++) {
                TextView text = (TextView) this.mRouteSearchView.findViewById(this.mTextViewId[i]);
                if (text != null) {
                    text.setText(BNStyleManager.getString(this.mNameResId[i]));
                    text.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_b_mm));
                }
            }
            for (i = 0; i < this.mImgViewId.length; i++) {
                ImageView imageView = (ImageView) this.mRouteSearchView.findViewById(this.mImgViewId[i]);
                if (imageView != null) {
                    imageView.setImageDrawable(BNStyleManager.getDrawable(this.mDrawableResId[i]));
                }
            }
        }
        if (this.mGasStationView != null) {
            this.mGasStationView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
        }
        if (this.mToiletView != null) {
            this.mToiletView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
        }
        if (this.mBankView != null) {
            this.mBankView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
        }
        if (this.mSpotsView != null) {
            this.mSpotsView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
        }
        if (this.mRestaurantView != null) {
            this.mRestaurantView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
        }
        if (this.mHotelView != null) {
            this.mHotelView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_common_bg_pressed_mask_selector));
        }
    }

    protected void hiedByTimeOut() {
        RGViewController.getInstance().hideRouteSearchView();
    }

    public void hide() {
        super.hide();
        cancelAutoHide();
        Animation animOut = AnimationUtil.getAnimation(AnimationType.ANIM_DOWN_OUT, 0, 300);
        animOut.setFillAfter(true);
        animOut.setAnimationListener(new C44262());
        this.mRouteSearchInnerPanel.startAnimation(animOut);
    }

    protected void onHide() {
        if (this.mRouteSearchInnerPanel != null) {
            this.mRouteSearchInnerPanel.setVisibility(8);
        }
        if (this.mRouteSearchPanel != null) {
            this.mRouteSearchPanel.setVisibility(8);
        }
        if (this.mRouteSearchContainer != null) {
            this.mRouteSearchContainer.setVisibility(8);
        }
    }

    public void show() {
        super.show();
        startAutoHide(10000);
        if (this.mRouteSearchContainer != null) {
            this.mRouteSearchContainer.setVisibility(0);
        }
        if (this.mRouteSearchPanel != null) {
            this.mRouteSearchPanel.setVisibility(0);
        }
        if (this.mRouteSearchInnerPanel != null) {
            this.mRouteSearchInnerPanel.startAnimation(AnimationUtil.getAnimation(AnimationType.ANIM_DOWN_IN, 0, 300));
            this.mRouteSearchInnerPanel.setVisibility(0);
        }
    }
}
