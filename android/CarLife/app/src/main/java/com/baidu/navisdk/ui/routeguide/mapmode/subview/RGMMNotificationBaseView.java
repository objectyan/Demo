package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

public class RGMMNotificationBaseView extends BNBaseView {
    private static final String TAG = RGMMNotificationBaseView.class.getCanonicalName();
    protected AnimListener mAnimListener = null;
    protected int mAutoHideTime = 0;
    protected NotificationDisplayListener mDisplayListener = null;
    private AnimationListener mInAminListener = new C43961();
    public Animation mInAnimation = null;
    protected int mNotificationType = 0;
    protected View mNotificationView = null;
    private View mNotificationViewPanel = null;
    private AnimationListener mOutAminListener = new C43972();
    public Animation mOutAnimation = null;
    protected int mPriority = 0;
    protected ViewGroup mViewContainer = null;

    public interface NotificationDisplayListener {
        void onHideWithAnim();

        void onHideWithOutAnim();

        void onShowWithAnim();

        void onShowWithOutAnim();
    }

    protected interface AnimListener {
        void onHide();

        void onHideAnimEnd();

        void onShow();

        void onShowAnimEnd();
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMNotificationBaseView$1 */
    class C43961 implements AnimationListener {
        C43961() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            LogUtil.m15791e(RGMMNotificationBaseView.TAG, "show onAnimationEnd");
            if (RGMMNotificationBaseView.this.mAnimListener != null) {
                RGMMNotificationBaseView.this.mAnimListener.onShowAnimEnd();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMNotificationBaseView$2 */
    class C43972 implements AnimationListener {
        C43972() {
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            LogUtil.m15791e(RGMMNotificationBaseView.TAG, "hide onAnimationEnd");
            if (RGMMNotificationBaseView.this.mAnimListener != null) {
                RGMMNotificationBaseView.this.mAnimListener.onHideAnimEnd();
            }
            RGMMNotificationBaseView.this.dispose();
        }
    }

    public RGMMNotificationBaseView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
        initViews();
    }

    public RGMMNotificationBaseView(Context c, ViewGroup p) {
        super(c, p);
        initViews();
    }

    private void initViews() {
        if (this.mRootViewGroup != null && this.mContext != null) {
            this.mNotificationViewPanel = RGViewController.getInstance().getViewContails(C4048R.id.bnav_rg_notification_panel);
            this.mViewContainer = RGViewController.getInstance().getViewContails(C4048R.id.bnav_rg_notification_container);
            if (this.mNotificationViewPanel != null && this.mViewContainer != null) {
                this.mInAnimation = JarUtils.loadAnimation(this.mContext, C4048R.anim.nsdk_anim_rg_slide_in_bottom);
                this.mOutAnimation = JarUtils.loadAnimation(this.mContext, C4048R.anim.nsdk_anim_rg_slide_out_bottom);
            }
        }
    }

    public void show() {
        LogUtil.m15791e(TAG, "show");
        super.show();
        showWithAnim();
    }

    public void hide() {
        LogUtil.m15791e(TAG, "hide");
        super.hide();
        hideWithAnim();
    }

    public void recoveryView() {
        super.show();
        showWithoutAnim();
    }

    public void updateStyle(boolean day) {
        super.updateStyle(day);
    }

    public void dispose() {
        if (this.mNotificationView != null) {
            this.mNotificationView.clearAnimation();
            this.mNotificationView.setVisibility(8);
        }
        if (this.mViewContainer != null) {
            this.mViewContainer.removeView(this.mNotificationView);
        }
        ArrayList<RGMMCommonNotificationView> commonList = RGNotificationController.getInstance().getCommonViewList();
        ArrayList<RGMMOperableNotificationView> operableList = RGNotificationController.getInstance().getOperableViewList();
        if ((commonList == null || commonList.isEmpty()) && (operableList == null || operableList.isEmpty())) {
            if (this.mViewContainer != null) {
                this.mViewContainer.setVisibility(8);
            }
            if (this.mNotificationViewPanel != null) {
                this.mNotificationViewPanel.setVisibility(8);
            }
        }
        this.mNotificationView = null;
        this.mViewContainer = null;
        this.mNotificationViewPanel = null;
        this.mRootViewGroup = null;
        this.mSubViewListener = null;
        this.mContext = null;
        if (this.mInAnimation != null) {
            this.mInAnimation.reset();
        }
        this.mInAnimation = null;
        if (this.mOutAnimation != null) {
            this.mOutAnimation.reset();
        }
        this.mOutAnimation = null;
    }

    private void showWithAnim() {
        LogUtil.m15791e(TAG, "showWithAnim");
        if (this.mNotificationViewPanel != null && this.mViewContainer != null && this.mNotificationView != null && this.mInAnimation != null) {
            if (!this.mInAnimation.hasStarted() || this.mInAnimation.hasEnded()) {
                this.mNotificationViewPanel.setVisibility(0);
                this.mViewContainer.setVisibility(0);
                this.mNotificationView.setVisibility(0);
                this.mInAnimation.setAnimationListener(this.mInAminListener);
                this.mNotificationView.startAnimation(this.mInAnimation);
                if (this.mAnimListener != null) {
                    this.mAnimListener.onShow();
                }
                if (this.mDisplayListener != null) {
                    this.mDisplayListener.onShowWithAnim();
                    return;
                }
                return;
            }
            LogUtil.m15791e(TAG, "show anim runing");
        }
    }

    private void hideWithAnim() {
        LogUtil.m15791e(TAG, "hideWithAnim");
        if (this.mAnimListener != null) {
            this.mAnimListener.onHide();
        }
        if (this.mDisplayListener != null) {
            this.mDisplayListener.onHideWithAnim();
        }
        if (this.mNotificationView != null && this.mOutAnimation != null && this.mInAnimation != null) {
            if (this.mInAnimation.hasStarted() && !this.mInAnimation.hasEnded()) {
                LogUtil.m15791e(TAG, "show anim runing");
                this.mNotificationView.clearAnimation();
                if (this.mAnimListener != null) {
                    this.mAnimListener.onShowAnimEnd();
                }
                if (this.mAnimListener != null) {
                    this.mAnimListener.onHideAnimEnd();
                }
                dispose();
            } else if (!this.mOutAnimation.hasStarted() || this.mOutAnimation.hasEnded()) {
                this.mOutAnimation.setAnimationListener(this.mOutAminListener);
                this.mNotificationView.startAnimation(this.mOutAnimation);
            } else {
                LogUtil.m15791e(TAG, "hide anim runing");
            }
        }
    }

    private void showWithoutAnim() {
        LogUtil.m15791e(TAG, "showWithoutAnim");
        if (this.mNotificationViewPanel != null && this.mViewContainer != null && this.mNotificationView != null) {
            this.mNotificationViewPanel.setVisibility(0);
            this.mViewContainer.setVisibility(0);
            this.mNotificationView.setVisibility(0);
            if (this.mAnimListener != null) {
                this.mAnimListener.onShow();
            }
            if (this.mDisplayListener != null) {
                this.mDisplayListener.onShowWithOutAnim();
            }
        }
    }

    protected void hideWithoutAnim() {
        LogUtil.m15791e(TAG, "hideWithoutAnim");
        super.hide();
        if (this.mAnimListener != null) {
            this.mAnimListener.onHide();
        }
        if (this.mDisplayListener != null) {
            this.mDisplayListener.onHideWithOutAnim();
        }
        if (this.mNotificationView != null) {
            this.mNotificationView.clearAnimation();
            this.mNotificationView.setVisibility(8);
        }
    }
}
