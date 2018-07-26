package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMNotificationBaseView.NotificationDisplayListener;
import com.baidu.navisdk.ui.routeguide.model.RGOperableNotificationModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.navimageloader.BNDisplayImageOptions;
import com.baidu.navisdk.util.navimageloader.BNImageLoader;
import com.baidu.navisdk.util.navimageloader.BNImageLoadingListener;

public class RGMMOperableNotificationView extends RGMMNotificationBaseView {
    private static final String TAG = RGMMOperableNotificationView.class.getSimpleName();
    private Drawable mCancelBackground = null;
    private int mCancelColor = 0;
    private RelativeLayout mCancelLayout = null;
    private RelativeLayout mCancelRelative = null;
    private TextView mCancelTV = null;
    private String mCancelText = null;
    private Drawable mConfirmBackground = null;
    private int mConfirmColor = 0;
    private RelativeLayout mConfirmLayout = null;
    private RelativeLayout mConfirmRelative = null;
    private TextView mConfirmTV = null;
    private String mConfirmText = null;
    private BNImageLoadingListener mIconListener = null;
    private BNDisplayImageOptions mIconOptions = null;
    private String mIconUrl = null;
    private boolean mIsShowMasking = false;
    private int mMainTitleColor = 0;
    private TextView mMainTitleTV = null;
    private String mMainTitleText = null;
    private RGOperableNotificationModel mModel = null;
    private Drawable mNotificationBackgroud = null;
    private int mNotificationColor = 0;
    private Drawable mNotificationIcon = null;
    private ImageView mNotificationIconIV = null;
    private LinearLayout mNotificationLayout = null;
    private NotificationClickListener mOnBtnClickListener = null;
    private boolean mShowCountingDown = false;
    private int mSubTitleColor = 0;
    private TextView mSubTitleTV = null;
    private String mSubTitleText = null;
    private String mViewID = null;

    public interface NotificationClickListener {
        void onAutoHideWithoutClick();

        void onCancelBtnClick();

        void onConfirmBtnClick();
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView$1 */
    class C44071 implements AnimListener {
        C44071() {
        }

        public void onShow() {
            if (RGMMOperableNotificationView.this.mIsShowMasking) {
                RGViewController.getInstance().showInterveneMasking();
            }
            RGViewController.getInstance().hideControlPanel();
        }

        public void onHide() {
            if (!RGNotificationController.getInstance().hasOtherOperableModelShowMasking(RGMMOperableNotificationView.this.mModel)) {
                RGViewController.getInstance().hideInterveneMasking();
            }
        }

        public void onShowAnimEnd() {
            RGMMOperableNotificationView.this.addClickListener();
            if (RGNotificationController.getInstance().getNotificationShowFocusListener() != null) {
                RGNotificationController.getInstance().getNotificationShowFocusListener().show();
            }
        }

        public void onHideAnimEnd() {
            RGMMOperableNotificationView.this.removeView();
            RGMMOperableNotificationView.this.removeClickListener();
            if (RGNotificationController.getInstance().getNotificationShowFocusListener() != null) {
                RGNotificationController.getInstance().getNotificationShowFocusListener().hide();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView$2 */
    class C44082 implements OnClickListener {
        C44082() {
        }

        public void onClick(View v) {
            RGMMOperableNotificationView.this.hide();
            if (RGMMOperableNotificationView.this.mOnBtnClickListener != null) {
                RGMMOperableNotificationView.this.mOnBtnClickListener.onConfirmBtnClick();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView$3 */
    class C44093 implements OnClickListener {
        C44093() {
        }

        public void onClick(View v) {
            RGMMOperableNotificationView.this.hide();
            if (RGMMOperableNotificationView.this.mOnBtnClickListener != null) {
                RGMMOperableNotificationView.this.mOnBtnClickListener.onConfirmBtnClick();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView$4 */
    class C44104 implements OnClickListener {
        C44104() {
        }

        public void onClick(View v) {
            RGMMOperableNotificationView.this.hide();
            if (RGMMOperableNotificationView.this.mOnBtnClickListener != null) {
                RGMMOperableNotificationView.this.mOnBtnClickListener.onCancelBtnClick();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView$5 */
    class C44115 implements OnClickListener {
        C44115() {
        }

        public void onClick(View v) {
            RGMMOperableNotificationView.this.hide();
            if (RGMMOperableNotificationView.this.mOnBtnClickListener != null) {
                RGMMOperableNotificationView.this.mOnBtnClickListener.onCancelBtnClick();
            }
        }
    }

    public interface NotificationShowFocusListener {
        void hide();

        void show();
    }

    public RGMMOperableNotificationView(Context c, ViewGroup p, int notificationType) {
        super(c, p);
        this.mNotificationType = notificationType;
        this.mViewID = String.valueOf(hashCode());
        initViews();
    }

    private void initViews() {
        if (this.mViewContainer != null && this.mContext != null) {
            this.mNotificationView = JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_rg_mapmode_operable_notification, null);
            if (this.mNotificationView != null) {
                LayoutParams lp = new LayoutParams(-1, -2);
                if (lp != null) {
                    lp.addRule(12);
                    this.mViewContainer.addView(this.mNotificationView, lp);
                    this.mNotificationIconIV = (ImageView) this.mNotificationView.findViewById(C4048R.id.bnav_rg_operable_notification_icon);
                    this.mMainTitleTV = (TextView) this.mNotificationView.findViewById(C4048R.id.bnav_rg_operable_notification_maintitle_text);
                    this.mSubTitleTV = (TextView) this.mNotificationView.findViewById(C4048R.id.bnav_rg_operable_notification_subtitle_text);
                    this.mConfirmLayout = (RelativeLayout) this.mNotificationView.findViewById(C4048R.id.bnav_rg_operable_notification_confirm_btn_layout);
                    this.mCancelLayout = (RelativeLayout) this.mNotificationView.findViewById(C4048R.id.bnav_rg_operable_notification_cancel_btn_layout);
                    this.mConfirmTV = (TextView) this.mNotificationView.findViewById(C4048R.id.bnav_rg_operable_notification_confirm_text);
                    this.mCancelTV = (TextView) this.mNotificationView.findViewById(C4048R.id.bnav_rg_operable_notification_cancel_text);
                    this.mNotificationLayout = (LinearLayout) this.mNotificationView.findViewById(C4048R.id.bnav_rg_operable_notification_layout);
                    this.mConfirmRelative = (RelativeLayout) this.mNotificationView.findViewById(C4048R.id.bnav_rg_operable_notification_confirm_relative);
                    this.mCancelRelative = (RelativeLayout) this.mNotificationView.findViewById(C4048R.id.bnav_rg_operable_notification_cancel_relative);
                    removeClickListener();
                    this.mAnimListener = new C44071();
                    setPriority(this.mPriority);
                    updateDataByLastest();
                }
            }
        }
    }

    private void removeView() {
        RGNotificationController.getInstance().removeOperableView(this);
    }

    private void addClickListener() {
        if (this.mConfirmLayout != null && this.mCancelLayout != null) {
            this.mConfirmLayout.setClickable(true);
            this.mConfirmLayout.setOnClickListener(new C44082());
            this.mConfirmRelative.setOnClickListener(new C44093());
            this.mCancelLayout.setClickable(true);
            this.mCancelLayout.setOnClickListener(new C44104());
            this.mCancelRelative.setOnClickListener(new C44115());
        }
    }

    private void removeClickListener() {
        if (this.mConfirmLayout != null && this.mCancelLayout != null) {
            this.mConfirmLayout.setClickable(false);
            this.mCancelLayout.setClickable(false);
        }
    }

    private void updateNotificaitonView() {
        setMainTitleText(this.mMainTitleText);
        setSubTitleText(this.mSubTitleText);
        setMainTitleColor(this.mMainTitleColor);
        setSubTitleColor(this.mSubTitleColor);
        setNotificationIcon(this.mNotificationIcon);
        setNotificationIcon(this.mIconUrl, this.mIconOptions, this.mIconListener);
        setNotificationColor(this.mNotificationColor);
        setConfirmText(this.mConfirmText);
        setCancelText(this.mCancelText);
        setConfirmBackground(this.mConfirmBackground);
        setCancelBackground(this.mCancelBackground);
        setConfirmTextColor(this.mConfirmColor);
        setCancelTextColor(this.mCancelColor);
    }

    public void updateData(Bundle b) {
        updateNotificaitonView();
    }

    public void updateDataByLastest() {
        updateData(null);
    }

    public void show() {
        RGNotificationController.getInstance().hideAllCommonView();
        RGNotificationController.getInstance().hideRepeatedOperableView(this.mNotificationType);
        if (this.mModel == null) {
            this.mModel = new RGOperableNotificationModel(this, this.mViewID, this.mPriority, this.mAutoHideTime, this.mMainTitleText, this.mSubTitleText, this.mMainTitleColor, this.mSubTitleColor, this.mConfirmText, this.mCancelText, this.mConfirmColor, this.mCancelColor, this.mNotificationIcon, this.mNotificationColor, this.mConfirmBackground, this.mCancelBackground, this.mOnBtnClickListener, this.mDisplayListener, this.mIconUrl, this.mIconOptions, this.mIconListener, this.mNotificationType, this.mIsShowMasking);
        }
        if (!RGNotificationController.getInstance().isContainsOperableModel(this.mModel)) {
            RGNotificationController.getInstance().addOperableModel(this.mModel);
            if (RGNotificationController.getInstance().allowNotificationShow(true, this.mNotificationType)) {
                super.show();
            } else {
                LogUtil.m15791e(TAG, "not allow show");
                hideWithoutAnim();
            }
        }
        if (!(this.mModel == null || this.mModel.mHandler == null)) {
            this.mModel.mHandler.removeMessages(1000);
            if (this.mAutoHideTime >= 0) {
                this.mModel.mHandler.sendEmptyMessageDelayed(1000, (long) this.mAutoHideTime);
            }
        }
        if (this.mShowCountingDown) {
            this.mModel.mCountingSecs = (int) Math.ceil(((double) this.mAutoHideTime) / 1000.0d);
            if (this.mModel != null && this.mModel.mHandler != null) {
                this.mModel.mHandler.removeMessages(1001);
                if (this.mAutoHideTime >= 0 && this.mModel.mCountingSecs > 0) {
                    this.mModel.mHandler.sendEmptyMessageDelayed(1001, 1000);
                }
            }
        }
    }

    public void clickCancelBtn() {
        if (this.mOnBtnClickListener != null) {
            this.mOnBtnClickListener.onCancelBtnClick();
        }
    }

    public void autoHideWithoutClick() {
        if (this.mOnBtnClickListener != null) {
            this.mOnBtnClickListener.onAutoHideWithoutClick();
        }
    }

    public void hide() {
        super.hide();
        removeClickListener();
        RGNotificationController.getInstance().removeOperableModel(this.mModel);
        if (this.mModel != null) {
            this.mModel.reset();
            this.mModel = null;
        }
    }

    public void hideWithoutRemoveModel() {
        super.hide();
        removeClickListener();
    }

    public void hideWithoutAnim() {
        super.hideWithoutAnim();
        removeClickListener();
    }

    public void updateStyle(boolean day) {
        super.updateStyle(day);
    }

    public void recoveryView() {
        if (RGNotificationController.getInstance().allowNotificationShow(true, this.mNotificationType)) {
            super.recoveryView();
            addClickListener();
            return;
        }
        hideWithoutAnim();
    }

    public RGMMOperableNotificationView setPriority(int priority) {
        this.mPriority = priority;
        GradientDrawable confirmDrawable;
        GradientDrawable cancelDrawable;
        if (priority == 100) {
            setNotificationColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_operable_notification_background));
            setMainTitleColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_operable_notification_maintitle));
            setSubTitleColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_operable_notification_subtitle));
            confirmDrawable = new GradientDrawable();
            confirmDrawable.setColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_operable_notification_low_priority_confirm_background));
            confirmDrawable.setCornerRadius((float) ScreenUtil.getInstance().dip2px(50));
            setConfirmBackground(confirmDrawable);
            cancelDrawable = new GradientDrawable();
            cancelDrawable.setStroke(ScreenUtil.getInstance().dip2px(1), BNStyleManager.getColor(C4048R.color.cl_bg_a));
            cancelDrawable.setColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_operable_notification_background));
            cancelDrawable.setCornerRadius((float) ScreenUtil.getInstance().dip2px(50));
            setCancelBackground(cancelDrawable);
            setConfirmTextColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_operable_notification_low_priority_confirm_text));
            setCancelTextColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_operable_notification_low_priority_cancel_text));
            this.mAutoHideTime = 10000;
        } else if (priority == 200) {
            setNotificationColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_operable_notification_background));
            setMainTitleColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_operable_notification_maintitle));
            setSubTitleColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_operable_notification_subtitle));
            confirmDrawable = new GradientDrawable();
            confirmDrawable.setColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_operable_notification_middle_priority_confirm_background));
            confirmDrawable.setCornerRadius((float) ScreenUtil.getInstance().dip2px(30));
            setConfirmBackground(confirmDrawable);
            cancelDrawable = new GradientDrawable();
            cancelDrawable.setStroke(ScreenUtil.getInstance().dip2px(1), BNStyleManager.getColor(C4048R.color.cl_bg_a));
            cancelDrawable.setColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_operable_notification_background));
            cancelDrawable.setCornerRadius((float) ScreenUtil.getInstance().dip2px(30));
            setCancelBackground(cancelDrawable);
            setConfirmTextColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_operable_notification_middle_priority_confirm_text));
            setCancelTextColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_operable_notification_middle_priority_cancel_text));
            this.mAutoHideTime = 15000;
        } else if (priority == 300) {
            setNotificationColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_operable_notification_background));
            setMainTitleColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_operable_notification_maintitle));
            setSubTitleColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_operable_notification_subtitle));
            confirmDrawable = new GradientDrawable();
            confirmDrawable.setColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_operable_notification_high_priority_confirm_background));
            confirmDrawable.setCornerRadius((float) ScreenUtil.getInstance().dip2px(30));
            setConfirmBackground(confirmDrawable);
            cancelDrawable = new GradientDrawable();
            cancelDrawable.setStroke(ScreenUtil.getInstance().dip2px(1), BNStyleManager.getColor(C4048R.color.cl_bg_a));
            cancelDrawable.setColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_operable_notification_background));
            cancelDrawable.setCornerRadius((float) ScreenUtil.getInstance().dip2px(30));
            setCancelBackground(cancelDrawable);
            setConfirmTextColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_operable_notification_high_priority_confirm_text));
            setCancelTextColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_operable_notification_high_priority_cancel_text));
            this.mAutoHideTime = 20000;
        }
        return this;
    }

    public RGMMOperableNotificationView setMainTitleText(String str) {
        if (!(this.mMainTitleTV == null || TextUtils.isEmpty(str))) {
            this.mMainTitleText = str;
            this.mMainTitleTV.setText(str);
            this.mMainTitleTV.setVisibility(0);
        }
        return this;
    }

    public RGMMOperableNotificationView setMainTitleLine(int maxLines) {
        if (this.mMainTitleTV != null && maxLines > 0) {
            this.mMainTitleTV.setMaxLines(maxLines);
        }
        return this;
    }

    public RGMMOperableNotificationView setSubTitleText(String str) {
        if (!(this.mSubTitleTV == null || TextUtils.isEmpty(str))) {
            this.mSubTitleText = str;
            this.mSubTitleTV.setText(str);
            this.mSubTitleTV.setVisibility(0);
        }
        return this;
    }

    public RGMMOperableNotificationView setMainTitleColor(int color) {
        if (this.mMainTitleTV != null) {
            this.mMainTitleColor = color;
            this.mMainTitleTV.setTextColor(color);
        }
        return this;
    }

    public RGMMOperableNotificationView setSubTitleColor(int color) {
        if (this.mSubTitleTV != null) {
            this.mSubTitleColor = color;
            this.mSubTitleTV.setTextColor(color);
        }
        return this;
    }

    public RGMMOperableNotificationView setConfirmText(String str) {
        if (!(this.mConfirmTV == null || TextUtils.isEmpty(str))) {
            this.mConfirmText = str;
            this.mConfirmTV.setText(str);
            this.mConfirmTV.setVisibility(0);
        }
        return this;
    }

    public RGMMOperableNotificationView setCancelText(String str) {
        if (!(this.mCancelTV == null || TextUtils.isEmpty(str))) {
            this.mCancelText = str;
            if (!this.mShowCountingDown || this.mModel == null || this.mModel.mCountingSecs <= 0) {
                this.mCancelTV.setText(str);
            } else {
                this.mCancelTV.setText(str + " (" + this.mModel.mCountingSecs + "s)");
            }
            this.mCancelTV.setVisibility(0);
        }
        return this;
    }

    public RGMMOperableNotificationView updateCancelTextCounting() {
        if (!(this.mCancelTV == null || TextUtils.isEmpty(this.mCancelText))) {
            if (!this.mShowCountingDown || this.mModel == null || this.mModel.mCountingSecs <= 0) {
                this.mCancelTV.setText(this.mCancelText);
            } else {
                this.mCancelTV.setText(this.mCancelText + " (" + this.mModel.mCountingSecs + "s)");
            }
            this.mCancelTV.setVisibility(0);
        }
        return this;
    }

    public RGMMOperableNotificationView setConfirmTextColor(int color) {
        if (this.mConfirmTV != null) {
            this.mConfirmColor = color;
            this.mConfirmTV.setTextColor(color);
        }
        return this;
    }

    public RGMMOperableNotificationView setCancelTextColor(int color) {
        if (this.mCancelTV != null) {
            this.mCancelColor = color;
            this.mCancelTV.setTextColor(color);
        }
        return this;
    }

    public RGMMOperableNotificationView setNotificationBackground(Drawable drawable) {
        if (!(this.mNotificationIconIV == null || drawable == null)) {
            this.mNotificationBackgroud = drawable;
            this.mNotificationIconIV.setBackgroundDrawable(drawable);
            this.mNotificationIconIV.setVisibility(0);
        }
        return this;
    }

    public RGMMOperableNotificationView setNotificationIcon(Drawable drawable) {
        if (!(this.mNotificationIconIV == null || drawable == null)) {
            this.mNotificationIcon = drawable;
            this.mNotificationIconIV.setImageDrawable(drawable);
            this.mNotificationIconIV.setVisibility(0);
        }
        return this;
    }

    public RGMMOperableNotificationView showNotificationIcon(boolean show) {
        if (this.mNotificationIconIV != null) {
            this.mNotificationIconIV.setVisibility(show ? 0 : 8);
        }
        return this;
    }

    public RGMMOperableNotificationView setNotificationIcon(String url, BNDisplayImageOptions options, BNImageLoadingListener listener) {
        if (this.mNotificationIconIV != null) {
            this.mIconUrl = url;
            this.mIconOptions = options;
            this.mIconListener = listener;
            BNImageLoader.getInstance().displayImage(url, this.mNotificationIconIV, options, listener);
            this.mNotificationIconIV.setVisibility(0);
        }
        return this;
    }

    public RGMMOperableNotificationView setNotificationColor(int color) {
        if (this.mNotificationLayout != null) {
            this.mNotificationColor = color;
            this.mNotificationLayout.setBackgroundColor(color);
        }
        return this;
    }

    public RGMMOperableNotificationView setConfirmBackground(Drawable drawable) {
        if (!(this.mConfirmLayout == null || drawable == null)) {
            this.mConfirmBackground = drawable;
            this.mConfirmLayout.setBackgroundDrawable(drawable);
            this.mConfirmLayout.setVisibility(0);
        }
        return this;
    }

    public RGMMOperableNotificationView setCancelBackground(Drawable drawable) {
        if (!(this.mCancelLayout == null || drawable == null)) {
            this.mCancelBackground = drawable;
            this.mCancelLayout.setBackgroundDrawable(drawable);
            this.mCancelLayout.setVisibility(0);
        }
        return this;
    }

    public RGMMOperableNotificationView setAutoHideTime(int time) {
        this.mAutoHideTime = time;
        return this;
    }

    public RGMMOperableNotificationView setModel(RGOperableNotificationModel model) {
        if (model != null) {
            this.mModel = model;
        }
        return this;
    }

    public RGMMOperableNotificationView setOnClick(NotificationClickListener listener) {
        this.mOnBtnClickListener = listener;
        return this;
    }

    public RGMMOperableNotificationView setDisplayListener(NotificationDisplayListener listener) {
        this.mDisplayListener = listener;
        return this;
    }

    public RGMMOperableNotificationView setShowMasking(boolean isShowMasking) {
        this.mIsShowMasking = isShowMasking;
        return this;
    }

    public Drawable getIconDrawable() {
        return this.mNotificationIconIV.getDrawable();
    }

    public ImageView getNotificationIcon() {
        return this.mNotificationIconIV;
    }

    public void setCountingDown(boolean mCountingDown) {
        this.mShowCountingDown = mCountingDown;
    }
}
