package com.baidu.navisdk.ui.download;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataObserver;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataObserver.DownloadArg;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;

public class BNDownloadNotifyManager {
    public static final int MERGE_NOTIFY_NO_PROGRESS = -1;
    private static final int REQ_CODE = 10;
    private static final String TAG = "!#BNDownloadNotifyManager";
    private static BNDownloadNotifyManager mInstance;
    private BNOfflineDataObserver mDataObserver = new C42961();
    private Intent mIntent;
    private boolean mIsNotificationShown = false;
    private boolean mIsObserving = false;
    private Notification mNotification;
    private NotificationManager mNotifyManager;
    private int mProgressBarResId;
    private int mProgressTxtResId;
    private int mTitleTxtResId;
    private OnUpdateListener mUpdateListener;
    private int mWaitingTaskCount;

    /* renamed from: com.baidu.navisdk.ui.download.BNDownloadNotifyManager$1 */
    class C42961 implements BNOfflineDataObserver {
        C42961() {
        }

        public void update(BNSubject o, int type, int event, Object obj) {
            switch (type) {
                case 2:
                    String log = "Observer recved: TYPE_DOWNLOAD_INFOR, event " + event;
                    switch (event) {
                        case 258:
                        case 259:
                        case 262:
                        case 263:
                        case BNOfflineDataObserver.EVENT_UPDATE_FINISH /*267*/:
                        case BNOfflineDataObserver.EVENT_UPDATE_SUSPEND /*268*/:
                            BNDownloadNotifyManager.this.mWaitingTaskCount = BNDownloadNotifyManager.this.mWaitingTaskCount - 1;
                            break;
                        case 264:
                            BNDownloadNotifyManager.this.mWaitingTaskCount = 0;
                            BNDownloadNotifyManager.this.clearNotification();
                            return;
                    }
                    if (obj != null && (obj instanceof DownloadArg)) {
                        DownloadArg arg = (DownloadArg) obj;
                        log = log + ", " + arg.mName + Config.TRACE_TODAY_VISIT_SPLIT + arg.mProgress;
                        BNDownloadNotifyManager.this.updateNotificationByName(arg.mName, arg.mProgress);
                    }
                    LogUtil.m15791e(BNDownloadNotifyManager.TAG, log);
                    return;
                case 3:
                    switch (event) {
                        case 270:
                        case BNOfflineDataObserver.EVENT_ERROR_SD_FULL /*271*/:
                            BNDownloadNotifyManager.this.clearNotification();
                            return;
                        default:
                            return;
                    }
                default:
                    return;
            }
        }
    }

    public interface OnUpdateListener {
        void onUpdate(RemoteViews remoteViews, String str, int i);
    }

    public static BNDownloadNotifyManager getInstance() {
        if (mInstance == null) {
            synchronized (BNDownloadNotifyManager.class) {
                if (mInstance == null) {
                    mInstance = new BNDownloadNotifyManager();
                }
            }
        }
        return mInstance;
    }

    private BNDownloadNotifyManager() {
    }

    public void startObserving() {
        if (!this.mIsObserving) {
            BNOfflineDataManager.getInstance().addObserver(this.mDataObserver);
            this.mIsObserving = true;
        }
    }

    public void stopObserving() {
        if (this.mIsObserving) {
            BNOfflineDataManager.getInstance().deleteObserver(this.mDataObserver);
            this.mIsObserving = false;
        }
    }

    public void init(Context context, Intent intent, int icon, RemoteViews contentView, OnUpdateListener listener) {
        if (context != null && intent != null && contentView != null) {
            this.mNotifyManager = (NotificationManager) context.getSystemService("notification");
            this.mNotification = new Notification();
            this.mNotification.icon = icon;
            this.mNotification.contentView = contentView;
            this.mNotification.flags = 16;
            this.mNotification.contentIntent = PendingIntent.getActivity(context, 10, intent, 0);
            this.mUpdateListener = listener;
        }
    }

    public void init(Context context, Intent intent, int icon, RemoteViews contentView, int titleTxtResId, int progressBarResId, int progressTxtResId) {
        if (context != null && intent != null && contentView != null) {
            this.mNotifyManager = (NotificationManager) context.getSystemService("notification");
            this.mNotification = new Notification();
            this.mNotification.icon = icon;
            this.mNotification.contentView = contentView;
            this.mNotification.flags = 16;
            this.mNotification.contentIntent = PendingIntent.getActivity(context, 10, intent, 0);
            this.mTitleTxtResId = titleTxtResId;
            this.mProgressBarResId = progressBarResId;
            this.mProgressTxtResId = progressTxtResId;
        }
    }

    public void updateNotification(String title, int progress) {
        LogUtil.m15791e(TAG, "updateNotification: " + title + ", progress " + progress);
        if (this.mNotifyManager != null && this.mNotification != null) {
            if (this.mUpdateListener != null) {
                this.mUpdateListener.onUpdate(this.mNotification.contentView, title, progress);
            }
            if (progress == -1) {
                this.mNotification.contentView.setViewVisibility(this.mProgressBarResId, 8);
                this.mNotification.contentView.setViewVisibility(this.mProgressTxtResId, 8);
                this.mNotification.contentView.setTextViewText(this.mTitleTxtResId, title);
            } else {
                this.mNotification.contentView.setViewVisibility(this.mProgressBarResId, 0);
                this.mNotification.contentView.setViewVisibility(this.mProgressTxtResId, 0);
                this.mNotification.contentView.setProgressBar(this.mProgressBarResId, 100, progress, false);
                this.mNotification.contentView.setTextViewText(this.mTitleTxtResId, title);
                this.mNotification.contentView.setTextViewText(this.mProgressTxtResId, progress + "%");
            }
            try {
                this.mNotifyManager.notify(10, this.mNotification);
                this.mIsNotificationShown = true;
            } catch (Exception e) {
            }
        }
    }

    public void clearNotification() {
        if (this.mNotifyManager != null) {
            this.mNotifyManager.cancel(10);
        }
        this.mIsNotificationShown = false;
    }

    public boolean isNotificationShown() {
        return this.mIsNotificationShown;
    }

    private void updateNotificationByName(String name, int progress) {
        if (this.mWaitingTaskCount + 1 > 0) {
            updateNotification(JarUtils.getResources().getString(C4048R.string.nsdk_string_dl_notify_title, new Object[]{name, Integer.valueOf(this.mWaitingTaskCount + 1)}), progress);
        }
    }
}
