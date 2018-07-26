package com.baidu.navisdk.ui.routeguide.model;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMCommonNotificationView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMNotificationBaseView.NotificationDisplayListener;
import com.baidu.navisdk.util.navimageloader.BNDisplayImageOptions;
import com.baidu.navisdk.util.navimageloader.BNImageLoadingListener;

public class RGCommonNotificationModel {
    private static final String TAG = RGCommonNotificationModel.class.getSimpleName();
    public int mAutoHideTime = 0;
    public NotificationDisplayListener mDisplayListener = null;
    public Handler mHandler = null;
    public String mID = null;
    public BNImageLoadingListener mIconListener = null;
    public BNDisplayImageOptions mIconOptions = null;
    public String mIconUrl = null;
    public int mMainTitleColor = 0;
    public String mMainTitleText = null;
    public int mNotificationColor = 0;
    public Drawable mNotificationIcon = null;
    public int mNotificationType = 0;
    public int mPriority = 0;
    public int mSubTitleColor = 0;
    public String mSubTitleText = null;
    public int mThirdTitleColor = 0;
    public String mThirdTitleText = null;
    public RGMMCommonNotificationView mView = null;

    public RGCommonNotificationModel(RGMMCommonNotificationView view, String id, int priority, int autoHideTime, String mainTitleText, String subTitleText, String thirdTitleText, int mainTitleColor, int subTitleColor, int thirdTitleColor, Drawable notificationIcon, int notificationColor, NotificationDisplayListener displayListener, String iconUrl, BNDisplayImageOptions iconOptions, BNImageLoadingListener iconListener, int notificationType) {
        this.mView = view;
        this.mID = id;
        this.mPriority = priority;
        this.mAutoHideTime = autoHideTime;
        this.mMainTitleText = mainTitleText;
        this.mSubTitleText = subTitleText;
        this.mThirdTitleText = thirdTitleText;
        this.mMainTitleColor = mainTitleColor;
        this.mSubTitleColor = subTitleColor;
        this.mThirdTitleColor = thirdTitleColor;
        this.mNotificationIcon = notificationIcon;
        this.mNotificationColor = notificationColor;
        this.mDisplayListener = displayListener;
        this.mIconUrl = iconUrl;
        this.mIconOptions = iconOptions;
        this.mIconListener = iconListener;
        this.mNotificationType = notificationType;
        this.mHandler = new Handler(Looper.myLooper()) {
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1000:
                        RGNotificationController.getInstance().hideCommonViewByHandler(RGCommonNotificationModel.this.mView);
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public RGCommonNotificationModel(String id) {
        this.mID = id;
    }

    public void reset() {
        this.mView = null;
        this.mID = null;
        this.mPriority = 0;
        this.mAutoHideTime = 0;
        this.mMainTitleText = null;
        this.mSubTitleText = null;
        this.mThirdTitleText = null;
        this.mMainTitleColor = 0;
        this.mSubTitleColor = 0;
        this.mThirdTitleColor = 0;
        this.mNotificationIcon = null;
        this.mNotificationColor = 0;
        this.mDisplayListener = null;
        this.mIconUrl = null;
        this.mIconOptions = null;
        this.mIconListener = null;
        this.mNotificationType = 0;
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1000);
        }
        this.mHandler = null;
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
