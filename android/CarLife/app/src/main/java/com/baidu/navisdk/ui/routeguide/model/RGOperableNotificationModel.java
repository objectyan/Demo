package com.baidu.navisdk.ui.routeguide.model;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMNotificationBaseView.NotificationDisplayListener;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView.NotificationClickListener;
import com.baidu.navisdk.util.navimageloader.BNDisplayImageOptions;
import com.baidu.navisdk.util.navimageloader.BNImageLoadingListener;

public class RGOperableNotificationModel {
    private static final String TAG = RGCommonNotificationModel.class.getSimpleName();
    public int mAutoHideTime = 0;
    public Drawable mCancelBackground = null;
    public int mCancelColor = 0;
    public String mCancelText = null;
    public Drawable mConfirmBackground = null;
    public int mConfirmColor = 0;
    public String mConfirmText = null;
    public int mCountingSecs = 0;
    public NotificationDisplayListener mDisplayListener = null;
    public Handler mHandler = null;
    public String mID = null;
    public BNImageLoadingListener mIconListener = null;
    public BNDisplayImageOptions mIconOptions = null;
    public String mIconUrl = null;
    public boolean mIsShowMasking = false;
    public int mMainTitleColor = 0;
    public String mMainTitleText = null;
    public int mNotificationColor = 0;
    public Drawable mNotificationIcon = null;
    public int mNotificationType = 0;
    public NotificationClickListener mOnBtnClickListener = null;
    public int mPriority = 0;
    public int mSubTitleColor = 0;
    public String mSubTitleText = null;
    public RGMMOperableNotificationView mView = null;

    public RGOperableNotificationModel(RGMMOperableNotificationView view, String id, int priority, int autoHideTime, String mainTitleText, String subTitleText, int mainTitleColor, int subTitleColor, String confirmText, String cancelText, int confirmColor, int cancelColor, Drawable notificationIcon, int notificationColor, Drawable confirmBackground, Drawable cancelBackground, NotificationClickListener onBtnClickListener, NotificationDisplayListener displayListener, String iconUrl, BNDisplayImageOptions iconOptions, BNImageLoadingListener iconListener, int notificationType, boolean isShowMasking) {
        this.mView = view;
        this.mID = id;
        this.mPriority = priority;
        this.mAutoHideTime = autoHideTime;
        this.mMainTitleText = mainTitleText;
        this.mSubTitleText = subTitleText;
        this.mMainTitleColor = mainTitleColor;
        this.mSubTitleColor = subTitleColor;
        this.mConfirmText = confirmText;
        this.mCancelText = cancelText;
        this.mConfirmColor = confirmColor;
        this.mCancelColor = cancelColor;
        this.mNotificationIcon = notificationIcon;
        this.mNotificationColor = notificationColor;
        this.mConfirmBackground = confirmBackground;
        this.mCancelBackground = cancelBackground;
        this.mOnBtnClickListener = onBtnClickListener;
        this.mDisplayListener = displayListener;
        this.mIconUrl = iconUrl;
        this.mIconOptions = iconOptions;
        this.mIconListener = iconListener;
        this.mNotificationType = notificationType;
        this.mIsShowMasking = isShowMasking;
        this.mHandler = new Handler(Looper.myLooper()) {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1000:
                        RGNotificationController.getInstance().hideOperableViewByHandler(RGOperableNotificationModel.this.mView);
                        return;
                    case 1001:
                        RGOperableNotificationModel rGOperableNotificationModel = RGOperableNotificationModel.this;
                        rGOperableNotificationModel.mCountingSecs--;
                        RGNotificationController.getInstance().updateOperableViewCountingByHandler(RGOperableNotificationModel.this.mView);
                        removeMessages(1001);
                        if (RGOperableNotificationModel.this.mCountingSecs > 0) {
                            sendEmptyMessageDelayed(1001, 1000);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public RGOperableNotificationModel(String id) {
        this.mID = id;
    }

    public void reset() {
        this.mView = null;
        this.mID = null;
        this.mPriority = 0;
        this.mAutoHideTime = 0;
        this.mMainTitleText = null;
        this.mSubTitleText = null;
        this.mMainTitleColor = 0;
        this.mSubTitleColor = 0;
        this.mConfirmText = null;
        this.mCancelText = null;
        this.mConfirmColor = 0;
        this.mCancelColor = 0;
        this.mNotificationIcon = null;
        this.mNotificationColor = 0;
        this.mConfirmBackground = null;
        this.mCancelBackground = null;
        this.mOnBtnClickListener = null;
        this.mDisplayListener = null;
        this.mIconUrl = null;
        this.mIconOptions = null;
        this.mIconListener = null;
        this.mNotificationType = 0;
        this.mIsShowMasking = false;
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1000);
        }
        this.mHandler = null;
        this.mCountingSecs = 0;
    }

    public boolean equals(Object o) {
        if (o instanceof RGCommonNotificationModel) {
            RGCommonNotificationModel other = (RGCommonNotificationModel) o;
            if (!(TextUtils.isEmpty(this.mID) || TextUtils.isEmpty(other.mID))) {
                return this.mID.equals(other.mID);
            }
        }
        return super.equals(o);
    }
}
