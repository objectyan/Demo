package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.FrameLayout.LayoutParams;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider;
import com.baidu.navisdk.module.ugc.ui.innavi.main.UgcReportNaviMainPresenter;
import com.baidu.navisdk.module.ugc.ui.innavi.main.UgcReportNaviMainPresenter.CallBackListener;
import com.baidu.navisdk.module.ugc.ui.innavi.main.UgcReportNaviMainView;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.AnimationUtil;
import com.baidu.navisdk.util.common.AnimationUtil.AnimationType;

public class RGMMUGCOperationActMenuView extends BNBaseView {
    public static boolean isViewShow = false;
    private ViewGroup mMenuViewContainer = null;
    private View mMenuViewLandscape = null;
    private View mMenuViewPanel = null;
    private View mMenuViewPortrait = null;
    private UgcReportNaviMainPresenter mPrensenter;
    private UgcReportNaviMainView mUgcReportMapMainView;
    private CallBackListener mUgcResportCallback = new C44382();

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMUGCOperationActMenuView$1 */
    class C44371 implements OnClickListener {
        C44371() {
        }

        public void onClick(View v) {
            RGViewController.getInstance().onUgcDestroy();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMUGCOperationActMenuView$2 */
    class C44382 implements CallBackListener {
        C44382() {
        }

        public void onUgcFinish() {
            RGMapModeViewController.getInstance().onUgcDestroy();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMUGCOperationActMenuView$3 */
    class C44393 implements AnimationListener {
        C44393() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            RGMMUGCOperationActMenuView.this.onHide();
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMUGCOperationActMenuView$4 */
    class C44404 implements OnClickListener {
        C44404() {
        }

        public void onClick(View v) {
            RGViewController.getInstance().onUgcDestroy();
        }
    }

    public RGMMUGCOperationActMenuView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
        initViews(c);
        updateStyle(BNStyleManager.getDayStyle());
    }

    private void initViews(Context mContext) {
        if (this.mRootViewGroup != null) {
            this.mMenuViewPanel = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_ugc_menu_panel);
            this.mMenuViewContainer = (ViewGroup) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_ugc_menu_container);
            if (this.mMenuViewContainer != null) {
                this.mMenuViewContainer.removeAllViews();
            }
            if (this.mMenuViewPanel != null) {
                this.mMenuViewPanel.setOnClickListener(new C44371());
            }
            this.mUgcReportMapMainView = new UgcReportNaviMainView(mContext, RGViewController.getInstance().getOrientation());
            this.mPrensenter = new UgcReportNaviMainPresenter(this.mUgcReportMapMainView, UgcDataProvider.obtainUgcNaviLayout(), this.mUgcResportCallback);
            this.mUgcReportMapMainView.setPresenter(this.mPrensenter);
            View mMenuView = this.mUgcReportMapMainView.getParentView();
            if (this.mMenuViewContainer != null && mMenuView != null) {
                this.mMenuViewContainer.removeAllViews();
                this.mMenuViewContainer.addView(mMenuView, new LayoutParams(-1, -1));
                this.mPrensenter.start();
            }
        }
    }

    public void updateStyle(boolean day) {
        super.updateStyle(day);
    }

    public void show() {
        super.show();
        isViewShow = true;
        if (this.mMenuViewPanel != null) {
            this.mMenuViewPanel.setVisibility(0);
        }
        if (this.mMenuViewContainer != null) {
            this.mMenuViewContainer.startAnimation(AnimationUtil.getAnimation(AnimationType.ANIM_DOWN_IN, 0, 300));
            this.mMenuViewContainer.setVisibility(0);
        }
    }

    protected void hiedByTimeOut() {
        RGViewController.getInstance().onUgcDestroy();
    }

    public void hide() {
        super.hide();
        Animation animOut = AnimationUtil.getAnimation(AnimationType.ANIM_DOWN_OUT, 0, 300);
        animOut.setFillAfter(true);
        animOut.setAnimationListener(new C44393());
        if (this.mMenuViewContainer != null) {
            this.mMenuViewContainer.startAnimation(animOut);
        }
    }

    protected void onHide() {
        isViewShow = false;
        if (this.mMenuViewContainer != null) {
            this.mMenuViewContainer.setVisibility(8);
        }
        if (this.mMenuViewPanel != null) {
            this.mMenuViewPanel.setVisibility(8);
        }
    }

    public void showAftInited() {
        show();
    }

    public void onBackPress() {
        if (!this.mPrensenter.onBackPress()) {
            RGMapModeViewController.getInstance().onUgcDestroy();
        }
    }

    public void onDestroy() {
        if (this.mPrensenter != null) {
            this.mPrensenter.onDestroy();
        }
        hide();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (this.mPrensenter != null) {
            this.mPrensenter.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void orientationChanged(ViewGroup rootView, int orien) {
        super.orientationChanged(rootView, orien);
        if (this.mRootViewGroup != null) {
            this.mMenuViewPanel = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_ugc_menu_panel);
            this.mMenuViewContainer = (ViewGroup) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_ugc_menu_container);
            if (this.mMenuViewContainer != null) {
                this.mMenuViewContainer.removeAllViews();
            }
            if (this.mMenuViewPanel != null) {
                this.mMenuViewPanel.setOnClickListener(new C44404());
            }
            this.mUgcReportMapMainView = new UgcReportNaviMainView(this.mContext, RGViewController.getInstance().getOrientation());
            this.mPrensenter.setRootView(this.mUgcReportMapMainView);
            this.mUgcReportMapMainView.setPresenter(this.mPrensenter);
            View mMenuView = this.mUgcReportMapMainView.getParentView();
            if (this.mMenuViewContainer != null && mMenuView != null) {
                this.mMenuViewContainer.removeAllViews();
                this.mMenuViewContainer.addView(mMenuView, new LayoutParams(-1, -1));
                if (this.mPrensenter != null) {
                    this.mPrensenter.orientationChanged(orien);
                }
                show();
            }
        }
    }
}
