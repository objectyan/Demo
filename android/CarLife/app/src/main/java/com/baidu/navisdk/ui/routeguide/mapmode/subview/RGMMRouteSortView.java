package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.GridView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.routeguide.adapter.RGRouteSortAdapter;
import com.baidu.navisdk.ui.routeguide.control.RGRouteSortController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.AnimationUtil;
import com.baidu.navisdk.util.common.AnimationUtil.AnimationType;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;

public class RGMMRouteSortView extends BNBaseView {
    private static final int[] ROUTE_SORTE_DIVIDER_H = new int[]{C4048R.id.nsdk_route_sort_h1};
    private static final String TAG = RGMMRouteSortView.class.getSimpleName();
    private RGRouteSortAdapter mAdapter = null;
    private GridView mRouteSortGV = null;
    private TextView mSettingDefaultTV = null;
    private TextView mTitleTV = null;
    private View mView = null;
    private ViewGroup mViewContainer = null;
    private View mViewPanel = null;
    public int sPageFromType = 1;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMRouteSortView$1 */
    class C44271 implements OnClickListener {
        C44271() {
        }

        public void onClick(View v) {
            UserOPController.getInstance().add(UserOPParams.ROUTE_2_i_2, null, null, null);
            RGRouteSortController.getInstance().mIsShowDefaultSettingBtn = true;
            if (RGMMRouteSortView.this.mSettingDefaultTV != null) {
                RGMMRouteSortView.this.mSettingDefaultTV.setVisibility(8);
            }
            if (RGMMRouteSortView.this.mTitleTV != null) {
                try {
                    RGMMRouteSortView.this.mTitleTV.setText(JarUtils.getResources().getString(C4048R.string.nsdk_string_route_sort_default_setting_title));
                } catch (Exception e) {
                }
            }
            if (RGMMRouteSortView.this.mAdapter != null) {
                RGMMRouteSortView.this.mAdapter.notifyDataSetChanged();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMRouteSortView$2 */
    class C44282 implements OnClickListener {
        C44282() {
        }

        public void onClick(View v) {
            RGMMRouteSortView.this.onClickCloseBtnOrMasking();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMRouteSortView$3 */
    class C44293 implements AnimationListener {
        C44293() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            RGMMRouteSortView.this.onHide();
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    public RGMMRouteSortView(Context cxt, ViewGroup parent, View view, View containerView, int fromType) {
        super(cxt, parent);
        this.mViewPanel = view;
        if (containerView != null && (containerView instanceof ViewGroup)) {
            this.mViewContainer = (ViewGroup) containerView;
        }
        this.sPageFromType = fromType;
        initViews();
        initListener();
        updateStyle(BNStyleManager.getDayStyle());
    }

    private void initViews() {
        if (this.mRootViewGroup != null && this.mContext != null && this.mViewPanel != null && this.mViewContainer != null) {
            try {
                this.mView = JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_route_sort_main_view, null);
            } catch (Exception e) {
                this.mView = null;
            }
            if (this.mView != null) {
                LayoutParams lp = new LayoutParams(-1, -2);
                if (lp != null) {
                    lp.addRule(15);
                    this.mViewContainer.addView(this.mView, lp);
                    this.mRouteSortGV = (GridView) this.mView.findViewById(C4048R.id.nsdk_route_sort_gv);
                    this.mSettingDefaultTV = (TextView) this.mView.findViewById(C4048R.id.nsdk_route_sort_default_setting_tv);
                    this.mTitleTV = (TextView) this.mView.findViewById(C4048R.id.nsdk_route_sort_title_tv);
                    if (this.mRouteSortGV != null) {
                        if (this.mAdapter == null) {
                            this.mAdapter = new RGRouteSortAdapter();
                            this.mAdapter.setPageFromType(this.sPageFromType);
                        }
                        this.mRouteSortGV.setAdapter(this.mAdapter);
                    }
                }
            }
        }
    }

    private void initListener() {
        if (this.mSettingDefaultTV != null) {
            this.mSettingDefaultTV.setOnClickListener(new C44271());
        }
        if (this.mViewPanel != null) {
            this.mViewPanel.setOnClickListener(new C44282());
        }
    }

    public void show() {
        super.show();
        startAutoHide(10000);
        if (this.mViewPanel != null && this.mViewContainer != null && this.mView != null) {
            this.mViewPanel.setVisibility(0);
            this.mViewContainer.setVisibility(0);
            this.mView.startAnimation(AnimationUtil.getAnimation(AnimationType.ANIM_DOWN_IN, 0, 300));
            this.mView.setVisibility(0);
            updateDataByLastest();
        }
    }

    protected void hiedByTimeOut() {
        RGViewController.getInstance().hideRouteSortView();
    }

    public void hide() {
        super.hide();
        cancelAutoHide();
        if (this.mViewPanel != null && this.mViewContainer != null && this.mView != null) {
            Animation animOut = AnimationUtil.getAnimation(AnimationType.ANIM_DOWN_OUT, 0, 300);
            animOut.setFillAfter(true);
            animOut.setAnimationListener(new C44293());
            this.mView.startAnimation(animOut);
        }
    }

    protected void onHide() {
        RGRouteSortController.getInstance().mIsShowDefaultSettingBtn = false;
        this.mViewPanel.setVisibility(8);
        this.mViewContainer.setVisibility(8);
        this.mView.setVisibility(8);
        if (this.mAdapter != null) {
            this.mAdapter.notifyDataSetChanged();
        }
    }

    public void updateStyle(boolean day) {
        super.updateStyle(day);
        if ((this.sPageFromType != 1 || day) && this.mView != null) {
            this.mView.setBackgroundColor(getColor(C4048R.color.cl_bg_d));
            if (this.mTitleTV != null) {
                this.mTitleTV.setTextColor(getColor(C4048R.color.nsdk_route_sort_title));
                this.mTitleTV.setCompoundDrawablesWithIntrinsicBounds(getDrawable(C4048R.drawable.nsdk_route_sort_setting_title_icon), null, null, null);
            }
            for (int id : ROUTE_SORTE_DIVIDER_H) {
                View v = this.mView.findViewById(id);
                if (v != null) {
                    v.setBackgroundColor(getColor(C4048R.color.cl_bg_d_mm));
                }
            }
            super.updateStyle(day);
        }
    }

    protected Drawable getDrawable(int resId) {
        if (this.sPageFromType == 1) {
            return BNStyleManager.getDrawable(resId, true);
        }
        return super.getDrawable(resId);
    }

    protected int getColor(int resId) {
        if (this.sPageFromType == 1) {
            return BNStyleManager.getColor(resId, true);
        }
        return super.getColor(resId);
    }

    public void updateData(Bundle b) {
        updateView();
    }

    public void updateDataByLastest() {
        updateData(null);
    }

    public void dispose() {
        if (this.sPageFromType == 2) {
            super.dispose();
        }
    }

    private void updateView() {
        if (this.sPageFromType == 1) {
            if (this.mSettingDefaultTV != null) {
                this.mSettingDefaultTV.setVisibility(0);
            }
        } else if (this.sPageFromType == 2 && this.mSettingDefaultTV != null) {
            this.mSettingDefaultTV.setVisibility(8);
        }
        if (this.mTitleTV != null) {
            try {
                this.mTitleTV.setText(JarUtils.getResources().getString(C4048R.string.nsdk_string_route_sort_title));
            } catch (Exception e) {
            }
        }
    }

    private void onClickCloseBtnOrMasking() {
        if (this.sPageFromType == 1) {
            if (RGRouteSortController.getInstance().mIsShowDefaultSettingBtn) {
                UserOPController.getInstance().add(UserOPParams.ROUTE_2_i_3, "0", "2", null);
            } else {
                UserOPController.getInstance().add(UserOPParams.ROUTE_2_i_1, "0", "2", null);
            }
            RGRouteSortController.getInstance().onCloseAction();
        } else if (this.sPageFromType == 2) {
            if (RGRouteSortController.getInstance().mIsShowDefaultSettingBtn) {
                UserOPController.getInstance().add(UserOPParams.ROUTE_2_i_3, "0", "3", null);
            } else {
                UserOPController.getInstance().add(UserOPParams.ROUTE_2_i_1, "0", "3", null);
            }
            RGViewController.getInstance().hideRouteSortView();
        }
        if (this.mAdapter != null) {
            this.mAdapter.notifyDataSetChanged();
        }
    }
}
