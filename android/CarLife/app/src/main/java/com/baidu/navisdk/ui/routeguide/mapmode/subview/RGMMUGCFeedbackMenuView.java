package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.AnimationUtil;
import com.baidu.navisdk.util.common.AnimationUtil.AnimationType;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGMMUGCFeedbackMenuView extends BNBaseView {
    private int[] hDivider = new int[]{C4048R.id.bnav_rg_menu_h_divider_0, C4048R.id.bnav_rg_menu_h_divider_1, C4048R.id.bnav_rg_menu_h_divider_2, C4048R.id.bnav_rg_menu_h_divider_3, C4048R.id.bnav_rg_menu_h_divider_4};
    private Button mMenuCloseButton = null;
    private View mMenuClosePanel = null;
    private View mMenuContentPanel = null;
    private ViewGroup mMenuViewContainer = null;
    private View mMenuViewLandscape = null;
    private View mMenuViewPanel = null;
    private View mMenuViewPortrait = null;
    private OnClickListener mOnClickListener = null;
    private View mPartTransBground = null;
    private View mRouteAddedItemView = null;
    private View mRouteBadItemView = null;
    private View mRouteBlockItemView = null;
    private int[] mTextViewId = new int[]{C4048R.id.bnav_rg_menu_route_block_item_tv, C4048R.id.bnav_rg_menu_trafic_flag_error_item_tv, C4048R.id.bnav_rg_menu_route_bad_item_tv, C4048R.id.bnav_rg_menu_route_added_item_tv, C4048R.id.bnav_rg_menu_close_tv};
    private View mTraficFlagErrorItemView = null;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMUGCFeedbackMenuView$1 */
    class C44341 implements OnTouchListener {
        C44341() {
        }

        public boolean onTouch(View arg0, MotionEvent arg1) {
            return true;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMUGCFeedbackMenuView$2 */
    class C44352 implements OnTouchListener {
        C44352() {
        }

        public boolean onTouch(View arg0, MotionEvent arg1) {
            return true;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMUGCFeedbackMenuView$3 */
    class C44363 implements OnClickListener {
        C44363() {
        }

        public void onClick(View view) {
            if (RGMMUGCFeedbackMenuView.this.mMenuCloseButton == null || RGMMUGCFeedbackMenuView.this.mMenuCloseButton != view) {
                if (RGMMUGCFeedbackMenuView.this.mRouteBlockItemView == null || RGMMUGCFeedbackMenuView.this.mRouteBlockItemView != view) {
                    if (RGMMUGCFeedbackMenuView.this.mTraficFlagErrorItemView == null || RGMMUGCFeedbackMenuView.this.mTraficFlagErrorItemView != view) {
                        if (RGMMUGCFeedbackMenuView.this.mRouteBadItemView == null || RGMMUGCFeedbackMenuView.this.mRouteBadItemView != view) {
                            if (RGMMUGCFeedbackMenuView.this.mRouteAddedItemView != null && RGMMUGCFeedbackMenuView.this.mRouteAddedItemView == view && RGMMUGCFeedbackMenuView.this.mSubViewListener != null) {
                                RGMMUGCFeedbackMenuView.this.mSubViewListener.onOtherAction(12, 3, 0, null);
                            }
                        } else if (RGMMUGCFeedbackMenuView.this.mSubViewListener != null) {
                            RGMMUGCFeedbackMenuView.this.mSubViewListener.onOtherAction(12, 2, 0, null);
                        }
                    } else if (RGMMUGCFeedbackMenuView.this.mSubViewListener != null) {
                        RGMMUGCFeedbackMenuView.this.mSubViewListener.onOtherAction(12, 1, 0, null);
                    }
                } else if (RGMMUGCFeedbackMenuView.this.mSubViewListener != null) {
                    RGMMUGCFeedbackMenuView.this.mSubViewListener.onOtherAction(12, 0, 0, null);
                }
            } else if (RGMMUGCFeedbackMenuView.this.mSubViewListener != null) {
                RGMMUGCFeedbackMenuView.this.mSubViewListener.onUGCMenuAction();
            }
        }
    }

    public RGMMUGCFeedbackMenuView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
        initViews();
        initViewsSetting();
        updateStyle(BNStyleManager.getDayStyle());
        initListener();
    }

    private void initViewsSetting() {
        if (VERSION.SDK_INT >= 11) {
            this.mPartTransBground.setAlpha(0.7f);
        }
    }

    private void initViews() {
        if (this.mRootViewGroup != null) {
            View mMenuView;
            this.mMenuViewPanel = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_ugc_menu_panel);
            this.mMenuViewContainer = (ViewGroup) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_ugc_menu_container);
            if (this.mMenuViewContainer != null) {
                this.mMenuViewContainer.removeAllViews();
            }
            if (1 == RGViewController.getInstance().getOrientation()) {
                this.mCurOrientation = 1;
                if (this.mMenuViewPortrait == null) {
                    this.mMenuViewPortrait = JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_rg_ugc_menu, null);
                }
                mMenuView = this.mMenuViewPortrait;
            } else {
                this.mCurOrientation = 2;
                if (this.mMenuViewLandscape == null) {
                    this.mMenuViewLandscape = JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_rg_ugc_menu_land, null);
                }
                mMenuView = this.mMenuViewLandscape;
            }
            if (this.mMenuViewContainer != null && mMenuView != null) {
                this.mMenuViewContainer.addView(mMenuView, new LayoutParams(-1, -1));
                this.mPartTransBground = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_part_trans_bground);
                this.mMenuContentPanel = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_ugc_func_panel);
                this.mRouteBlockItemView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_route_block_item);
                this.mTraficFlagErrorItemView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_trafic_flag_error_item);
                this.mRouteBadItemView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_route_bad_item);
                this.mRouteAddedItemView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_route_added_item);
                this.mMenuCloseButton = (Button) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_ugc_close);
                this.mMenuClosePanel = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_close_content_panel);
            }
        }
    }

    public void updateStyle(boolean day) {
        super.updateStyle(day);
        if (this.mMenuContentPanel != null) {
            this.mMenuContentPanel.setBackgroundColor(BNStyleManager.getColor(C4048R.color.cl_bg_d));
        }
        if (this.mMenuClosePanel == null) {
            this.mMenuClosePanel = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_close_content_panel);
        }
        if (this.mMenuCloseButton == null) {
            this.mMenuCloseButton = (Button) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_menu_ugc_close);
        }
        if (this.mMenuClosePanel != null) {
            this.mMenuClosePanel.setBackgroundColor(BNStyleManager.getColor(C4048R.color.cl_bg_d));
        }
        if (this.mRootViewGroup != null) {
            for (int findViewById : this.mTextViewId) {
                TextView text = (TextView) this.mRootViewGroup.findViewById(findViewById);
                if (text != null) {
                    text.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_a));
                }
            }
            for (int findViewById2 : this.hDivider) {
                View v = this.mRootViewGroup.findViewById(findViewById2);
                if (v != null) {
                    v.setBackgroundColor(BNStyleManager.getColor(C4048R.color.cl_bg_b));
                }
            }
        }
        if (this.mMenuCloseButton != null) {
            this.mMenuCloseButton.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_lineframe_button_selector));
        }
    }

    private void initListener() {
        initOnClickListener();
        if (this.mMenuViewPanel != null) {
            this.mMenuViewPanel.setOnTouchListener(new C44341());
        } else if (this.mMenuViewContainer != null) {
            this.mMenuViewContainer.setOnTouchListener(new C44352());
        }
        if (this.mRouteBlockItemView != null) {
            this.mRouteBlockItemView.setOnClickListener(this.mOnClickListener);
        }
        if (this.mTraficFlagErrorItemView != null) {
            this.mTraficFlagErrorItemView.setOnClickListener(this.mOnClickListener);
        }
        if (this.mRouteBadItemView != null) {
            this.mRouteBadItemView.setOnClickListener(this.mOnClickListener);
        }
        if (this.mRouteAddedItemView != null) {
            this.mRouteAddedItemView.setOnClickListener(this.mOnClickListener);
        }
        if (this.mMenuCloseButton != null) {
            this.mMenuCloseButton.setOnClickListener(this.mOnClickListener);
        }
    }

    private void initOnClickListener() {
        this.mOnClickListener = new C44363();
    }

    public void show() {
        super.show();
        if (this.mMenuViewPanel != null) {
            this.mMenuViewPanel.setVisibility(0);
        }
        if (this.mMenuViewContainer != null) {
            this.mMenuViewContainer.startAnimation(AnimationUtil.getAnimation(AnimationType.ANIM_DOWN_IN, 0, 300));
            this.mMenuViewContainer.setVisibility(0);
        }
    }

    public void hide() {
        super.hide();
        if (this.mMenuViewContainer != null) {
            this.mMenuViewContainer.setVisibility(8);
        }
        if (this.mMenuViewPanel != null) {
            this.mMenuViewPanel.setVisibility(8);
        }
    }
}
