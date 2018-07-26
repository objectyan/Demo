package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
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
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMNotificationBaseView.NotificationDisplayListener;
import com.baidu.navisdk.ui.routeguide.model.RGCommonNotificationModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.navimageloader.BNDisplayImageOptions;
import com.baidu.navisdk.util.navimageloader.BNImageLoader;
import com.baidu.navisdk.util.navimageloader.BNImageLoadingListener;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

public class RGMMCommonNotificationView extends RGMMNotificationBaseView {
    private static final String TAG = RGMMCommonNotificationView.class.getSimpleName();
    private BNImageLoadingListener mIconListener = null;
    private BNDisplayImageOptions mIconOptions = null;
    private String mIconUrl = null;
    private int mMainTitleColor = 0;
    private TextView mMainTitleTV = null;
    private String mMainTitleText = null;
    private RGCommonNotificationModel mModel = null;
    private int mNotificationColor = 0;
    private Drawable mNotificationIcon = null;
    private ImageView mNotificationIconIV = null;
    private RelativeLayout mNotificationLayout = null;
    private LinearLayout mSubThirdTitleLayout = null;
    private int mSubTitleColor = 0;
    private TextView mSubTitleTV = null;
    private String mSubTitleText = null;
    private int mThirdTitleColor = 0;
    private TextView mThirdTitleTV = null;
    private String mThirdTitleText = null;
    protected String mViewID = null;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMCommonNotificationView$1 */
    class C43571 implements AnimListener {
        C43571() {
        }

        public void onShow() {
        }

        public void onHide() {
        }

        public void onShowAnimEnd() {
            RGNotificationController.getInstance().hideOtherCommonViewBeforeThis(RGMMCommonNotificationView.this.mModel);
            RGMMCommonNotificationView.this.addClickListener();
        }

        public void onHideAnimEnd() {
            RGMMCommonNotificationView.this.removeView();
            RGMMCommonNotificationView.this.removeClickListener();
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMCommonNotificationView$4 */
    class C43604 implements OnClickListener {
        C43604() {
        }

        public void onClick(View v) {
            RGMMCommonNotificationView.this.hide();
        }
    }

    public RGMMCommonNotificationView(Context c, ViewGroup p, int notificationType) {
        super(c, p);
        this.mNotificationType = notificationType;
        this.mViewID = String.valueOf(hashCode());
        initViews();
    }

    private void initViews() {
        if (this.mViewContainer != null && this.mContext != null) {
            this.mNotificationView = JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_rg_mapmode_common_notification, null);
            if (this.mNotificationView != null) {
                LayoutParams lp = new LayoutParams(-1, -2);
                if (lp != null) {
                    lp.addRule(12);
                    this.mViewContainer.addView(this.mNotificationView, lp);
                    this.mNotificationIconIV = (ImageView) this.mNotificationView.findViewById(C4048R.id.bnav_rg_common_notification_icon);
                    this.mMainTitleTV = (TextView) this.mNotificationView.findViewById(C4048R.id.bnav_rg_common_notification_maintitle_text);
                    this.mSubTitleTV = (TextView) this.mNotificationView.findViewById(C4048R.id.bnav_rg_common_notification_subtitle_text);
                    this.mThirdTitleTV = (TextView) this.mNotificationView.findViewById(C4048R.id.bnav_rg_common_notification_tips_text);
                    this.mNotificationLayout = (RelativeLayout) this.mNotificationView.findViewById(C4048R.id.bnav_rg_common_notification_layout);
                    this.mSubThirdTitleLayout = (LinearLayout) this.mNotificationView.findViewById(C4048R.id.bnav_rg_common_notification_sub_third_title_layout);
                    removeClickListener();
                    this.mAnimListener = new C43571();
                    setPriority(this.mPriority);
                    updateDataByLastest();
                }
            }
        }
    }

    private void removeView() {
        RGNotificationController.getInstance().removeCommonView(this);
    }

    private void updateNotificaitonView() {
        setMainTitleText(this.mMainTitleText);
        setSubTitleText(this.mSubTitleText);
        setThirdTitleText(this.mThirdTitleText);
        setMainTitleColor(this.mMainTitleColor);
        setSubTitleColor(this.mSubTitleColor);
        setThirdTitleColor(this.mThirdTitleColor);
        setNotificationIcon(this.mNotificationIcon);
        setNotificationIcon(this.mIconUrl, this.mIconOptions, this.mIconListener);
        setNotificationColor(this.mNotificationColor);
    }

    public void updateData(Bundle b) {
        updateNotificaitonView();
    }

    public void updateDataByLastest() {
        updateData(null);
    }

    public void show() {
        if (!RGNotificationController.getInstance().allowNotificationShow(false, this.mNotificationType) || RGNotificationController.getInstance().hasOperableNotification()) {
            LogUtil.m15791e(TAG, "not allow show or has operable notification showing");
            hideWithoutAnim();
            return;
        }
        if (this.mModel == null) {
            this.mModel = new RGCommonNotificationModel(this, this.mViewID, this.mPriority, this.mAutoHideTime, this.mMainTitleText, this.mSubTitleText, this.mThirdTitleText, this.mMainTitleColor, this.mSubTitleColor, this.mThirdTitleColor, this.mNotificationIcon, this.mNotificationColor, this.mDisplayListener, this.mIconUrl, this.mIconOptions, this.mIconListener, this.mNotificationType);
        }
        if (!RGNotificationController.getInstance().isContainsCommonModel(this.mModel)) {
            RGNotificationController.getInstance().addCommonModel(this.mModel);
            super.show();
        }
        if (this.mModel != null && this.mModel.mHandler != null) {
            this.mModel.mHandler.removeMessages(1000);
            this.mModel.mHandler.sendEmptyMessageDelayed(1000, (long) this.mAutoHideTime);
        }
    }

    public void hide() {
        super.hide();
        removeClickListener();
        RGNotificationController.getInstance().removeCommonModel(this.mModel);
        if (this.mModel != null) {
            this.mModel.reset();
            this.mModel = null;
        }
    }

    public void hideWithoutAnim() {
        super.hideWithoutAnim();
        removeClickListener();
        removeView();
        dispose();
    }

    public void hideWithoutRemoveModel() {
        super.hide();
        removeClickListener();
    }

    public void updateStyle(boolean day) {
        super.updateStyle(day);
    }

    public void recoveryView() {
        if (RGNotificationController.getInstance().allowNotificationShow(false, this.mNotificationType)) {
            super.recoveryView();
            addClickListener();
            return;
        }
        hideWithoutAnim();
    }

    public RGMMCommonNotificationView setMainTitleText(String str) {
        if (!(this.mMainTitleTV == null || this.mSubTitleTV == null || this.mThirdTitleTV == null || TextUtils.isEmpty(str))) {
            this.mMainTitleText = str;
            this.mMainTitleTV.setText(str);
            this.mMainTitleTV.setVisibility(0);
            if (this.mSubTitleTV.getVisibility() == 8 && this.mThirdTitleTV.getVisibility() == 8) {
                this.mMainTitleTV.setMaxLines(2);
            } else {
                this.mMainTitleTV.setMaxLines(1);
            }
        }
        return this;
    }

    public RGMMCommonNotificationView setSubTitleText(String str) {
        if (!(this.mSubTitleTV == null || TextUtils.isEmpty(str) || this.mMainTitleTV == null)) {
            this.mSubTitleText = str;
            this.mMainTitleTV.setMaxLines(1);
            this.mSubTitleTV.setText(str);
            this.mSubTitleTV.setVisibility(0);
        }
        return this;
    }

    public RGMMCommonNotificationView setThirdTitleText(String str) {
        if (!(this.mMainTitleTV == null || this.mThirdTitleTV == null || TextUtils.isEmpty(str))) {
            this.mThirdTitleText = str;
            this.mMainTitleTV.setMaxLines(1);
            this.mThirdTitleTV.setText(str);
            this.mThirdTitleTV.setVisibility(0);
            if (!(this.mSubTitleTV == null || this.mSubThirdTitleLayout == null)) {
                BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("setThirdTitleText1-" + getClass().getSimpleName(), null) {
                    protected String execute() {
                        if (!(RGMMCommonNotificationView.this.mSubTitleTV == null || RGMMCommonNotificationView.this.mSubThirdTitleLayout == null)) {
                            RGMMCommonNotificationView.this.mSubTitleTV.setMaxWidth((RGMMCommonNotificationView.this.mSubThirdTitleLayout.getWidth() / 3) * 2);
                        }
                        return null;
                    }
                }, new BNWorkerConfig(2, 0));
                BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("setThirdTitleText2-" + getClass().getSimpleName(), null) {
                    protected String execute() {
                        if (!(RGMMCommonNotificationView.this.mThirdTitleTV == null || RGMMCommonNotificationView.this.mSubThirdTitleLayout == null)) {
                            RGMMCommonNotificationView.this.mThirdTitleTV.setMaxWidth(RGMMCommonNotificationView.this.mSubThirdTitleLayout.getWidth() / 3);
                        }
                        return null;
                    }
                }, new BNWorkerConfig(2, 0));
            }
        }
        return this;
    }

    public RGMMCommonNotificationView setMainTitleColor(int color) {
        if (this.mMainTitleTV != null) {
            this.mMainTitleColor = color;
            this.mMainTitleTV.setTextColor(color);
        }
        return this;
    }

    public RGMMCommonNotificationView setSubTitleColor(int color) {
        if (this.mSubTitleTV != null) {
            this.mSubTitleColor = color;
            this.mSubTitleTV.setTextColor(color);
        }
        return this;
    }

    public RGMMCommonNotificationView setThirdTitleColor(int color) {
        if (this.mThirdTitleTV != null) {
            this.mThirdTitleColor = color;
            this.mThirdTitleTV.setTextColor(color);
        }
        return this;
    }

    public RGMMCommonNotificationView setAllTitleColor(int color) {
        setMainTitleColor(color);
        setSubTitleColor(color);
        setThirdTitleColor(color);
        return this;
    }

    public RGMMCommonNotificationView setNotificationIcon(Drawable drawable) {
        if (!(this.mNotificationIconIV == null || drawable == null)) {
            this.mNotificationIcon = drawable;
            this.mNotificationIconIV.setImageDrawable(drawable);
            this.mNotificationIconIV.setVisibility(0);
        }
        return this;
    }

    public RGMMCommonNotificationView setNotificationIcon(String url, BNDisplayImageOptions options, BNImageLoadingListener listener) {
        if (this.mNotificationIconIV != null) {
            this.mIconUrl = url;
            this.mIconOptions = options;
            this.mIconListener = listener;
            BNImageLoader.getInstance().displayImage(url, this.mNotificationIconIV, options, listener);
            this.mNotificationIconIV.setVisibility(0);
        }
        return this;
    }

    public RGMMCommonNotificationView setNotificationColor(int color) {
        if (this.mNotificationLayout != null) {
            this.mNotificationColor = color;
            this.mNotificationLayout.setBackgroundColor(color);
        }
        return this;
    }

    public RGMMCommonNotificationView setAutoHideTime(int time) {
        this.mAutoHideTime = time;
        return this;
    }

    public RGMMCommonNotificationView setModel(RGCommonNotificationModel model) {
        if (model != null) {
            this.mModel = model;
        }
        return this;
    }

    public RGMMCommonNotificationView setPriority(int priority) {
        this.mPriority = priority;
        if (priority == 100) {
            setNotificationColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_common_notification_low_priority));
            setMainTitleColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_common_notification_low_priority_main_text));
            setSubTitleColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_common_notification_low_priority_sub_text));
            setThirdTitleColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_common_notification_low_priority_third_text));
            this.mAutoHideTime = 3000;
        } else if (priority == 200) {
            setNotificationColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_common_notification_middle_priority));
            setMainTitleColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_common_notification_middle_priority_main_text));
            setSubTitleColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_common_notification_middle_priority_sub_text));
            setThirdTitleColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_common_notification_middle_priority_third_text));
            this.mAutoHideTime = 5000;
        } else if (priority == 300) {
            setNotificationColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_common_notification_high_priority));
            setMainTitleColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_common_notification_high_priority_main_text));
            setSubTitleColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_common_notification_high_priority_sub_text));
            setThirdTitleColor(BNStyleManager.getColor(C4048R.color.nsdk_rg_common_notification_high_priority_third_text));
            this.mAutoHideTime = 10000;
        }
        return this;
    }

    public RGMMCommonNotificationView setDisplayListener(NotificationDisplayListener listener) {
        this.mDisplayListener = listener;
        return this;
    }

    private void addClickListener() {
        if (this.mNotificationView != null) {
            this.mNotificationView.setClickable(true);
            this.mNotificationView.setOnClickListener(new C43604());
        }
    }

    private void removeClickListener() {
        if (this.mNotificationView != null) {
            this.mNotificationView.setClickable(false);
        }
    }
}
