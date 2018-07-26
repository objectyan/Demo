package com.baidu.navi.view;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.CarlifeActivity;

public class DownNotifManager {
    private static final int MERGE_ID = 15;
    private static final int PROGRESS_ID = 11;
    private static final int RESULT_ID = 13;
    private static final int SUSPEND_ID = 12;
    private static final int UPDATE_ID = 14;
    private static volatile DownNotifManager mInstance;
    private String mDownloadInfo;
    private Notification mMergeNotif;
    private NotificationManager mNotifManager;
    private int mProgress = 0;
    private Notification mProgressNotif;
    private Notification mResultNotif;
    private Notification mSuspendNotif;
    private Notification mUpdateNotif;
    private boolean mbProgressNotifShow = false;
    private boolean mbResultNotifShow = false;
    private String packageName;

    public static DownNotifManager getInstance(Context aContext) {
        if (mInstance == null) {
            synchronized (DownNotifManager.class) {
                if (mInstance == null) {
                    mInstance = new DownNotifManager(aContext);
                }
            }
        }
        return mInstance;
    }

    private DownNotifManager(Context aContext) {
        this.packageName = aContext.getPackageName();
        this.mNotifManager = (NotificationManager) aContext.getSystemService("notification");
        this.mProgressNotif = new Notification();
        this.mProgressNotif.icon = C0965R.drawable.ic_launcher;
        Intent progressIntent = new Intent(aContext, CarlifeActivity.class);
        progressIntent.setFlags(67108864);
        progressIntent.putExtra("OpenDownloadManager", "open");
        this.mProgressNotif.contentIntent = PendingIntent.getActivity(aContext, 11, progressIntent, 0);
        this.mProgressNotif.flags = 16;
        this.mSuspendNotif = new Notification();
        this.mSuspendNotif.icon = C0965R.drawable.ic_launcher;
        Intent pauseIntent = new Intent(aContext, CarlifeActivity.class);
        pauseIntent.setFlags(67108864);
        pauseIntent.putExtra("OpenDownloadManager", "open");
        this.mSuspendNotif.contentIntent = PendingIntent.getActivity(aContext, 12, pauseIntent, 0);
        this.mSuspendNotif.flags = 16;
        this.mResultNotif = new Notification();
        this.mResultNotif.icon = C0965R.drawable.ic_launcher;
        Intent delIntent = new Intent(aContext, CarlifeActivity.class);
        delIntent.setFlags(67108864);
        delIntent.putExtra("OpenDownloadManager", "open");
        this.mResultNotif.contentIntent = PendingIntent.getActivity(aContext, 13, pauseIntent, 0);
        this.mResultNotif.flags = 16;
        this.mUpdateNotif = new Notification();
        this.mUpdateNotif.icon = C0965R.drawable.ic_launcher;
        Intent updateIntent = new Intent(aContext, CarlifeActivity.class);
        updateIntent.setFlags(67108864);
        updateIntent.putExtra("OpenDownloadManager", "open");
        this.mUpdateNotif.contentIntent = PendingIntent.getActivity(aContext, 14, updateIntent, 0);
        this.mUpdateNotif.flags = 16;
        this.mMergeNotif = new Notification();
        this.mMergeNotif.icon = C0965R.drawable.ic_launcher;
        Intent mergeIntent = new Intent(aContext, CarlifeActivity.class);
        mergeIntent.setFlags(67108864);
        mergeIntent.putExtra("OpenDownloadManager", "open");
        this.mMergeNotif.contentIntent = PendingIntent.getActivity(aContext, 15, mergeIntent, 0);
        this.mMergeNotif.flags = 16;
    }

    public void updateDowningNotif(String notifTitle, int aProgress, String downloadInfo) {
        if (this.mNotifManager != null) {
            this.mNotifManager.cancel(12);
            this.mNotifManager.cancel(13);
            setIsResultNotifShow(false);
            this.mProgress = aProgress;
            this.mDownloadInfo = downloadInfo;
            this.mProgressNotif.contentView = new RemoteViews(this.packageName, C0965R.layout.status_bar_progress);
            this.mProgressNotif.contentView.setProgressBar(C0965R.id.progress_bar, 100, aProgress, false);
            this.mProgressNotif.contentView.setTextViewText(C0965R.id.title, notifTitle);
            this.mProgressNotif.contentView.setTextViewText(C0965R.id.progress_text, downloadInfo);
            try {
                this.mNotifManager.notify(11, this.mProgressNotif);
            } catch (Exception e) {
            }
            this.mbProgressNotifShow = true;
        }
    }

    public void updateSuspendingNotif(String notifTitle) {
        if (this.mNotifManager != null) {
            this.mNotifManager.cancel(13);
            this.mNotifManager.cancel(11);
            this.mSuspendNotif.contentView = new RemoteViews(this.packageName, C0965R.layout.status_bar_suspending);
            this.mSuspendNotif.contentView.setTextViewText(C0965R.id.title, notifTitle);
            this.mSuspendNotif.contentView.setProgressBar(C0965R.id.progress_bar, 100, this.mProgress, false);
            this.mSuspendNotif.contentView.setTextViewText(C0965R.id.progress_text, this.mDownloadInfo);
            try {
                this.mNotifManager.notify(12, this.mSuspendNotif);
            } catch (Exception e) {
            }
        }
    }

    public void showResultNotif(Context aContext, String notifTitle) {
        if (this.mNotifManager != null) {
            this.mNotifManager.cancel(11);
            this.mNotifManager.cancel(12);
            this.mResultNotif.contentView = new RemoteViews(this.packageName, C0965R.layout.status_bar_result);
            if (this.mbProgressNotifShow) {
                this.mResultNotif.contentView.setTextViewText(C0965R.id.title, notifTitle);
                try {
                    this.mNotifManager.notify(13, this.mResultNotif);
                } catch (Exception e) {
                }
                this.mbProgressNotifShow = false;
                setIsResultNotifShow(true);
            } else if (this.mbResultNotifShow) {
                this.mResultNotif.contentView.setTextViewText(C0965R.id.title, notifTitle);
                try {
                    this.mNotifManager.notify(13, this.mResultNotif);
                } catch (Exception e2) {
                }
            }
        }
    }

    public void showUpdateFinshedNotif(Context aContext, String notifTitle) {
        if (this.mNotifManager != null) {
            try {
                this.mNotifManager.cancel(13);
                this.mNotifManager.cancel(11);
                this.mNotifManager.cancel(12);
                this.mNotifManager.cancel(15);
            } catch (Exception e) {
            }
            setIsResultNotifShow(false);
            this.mUpdateNotif.tickerText = notifTitle;
            this.mUpdateNotif.contentView = new RemoteViews(this.packageName, C0965R.layout.status_bar_result);
            this.mUpdateNotif.contentView.setTextViewText(C0965R.id.title, notifTitle);
            try {
                this.mNotifManager.notify(14, this.mUpdateNotif);
            } catch (Exception e2) {
            }
        }
    }

    public void showUpdateMergeNotif(Context aContext, String notifTitle) {
        if (this.mNotifManager != null) {
            try {
                this.mNotifManager.cancel(12);
                this.mNotifManager.cancel(11);
            } catch (Exception e) {
            }
            setIsResultNotifShow(false);
            this.mMergeNotif.tickerText = notifTitle;
            this.mMergeNotif.contentView = new RemoteViews(this.packageName, C0965R.layout.status_bar_merge);
            this.mMergeNotif.contentView.setTextViewText(C0965R.id.title, notifTitle);
            try {
                this.mNotifManager.notify(15, this.mMergeNotif);
            } catch (Exception e2) {
            }
        }
    }

    public void clearAllNotifs() {
        if (this.mNotifManager != null) {
            try {
                this.mNotifManager.cancel(11);
                this.mNotifManager.cancel(12);
                this.mNotifManager.cancel(13);
                this.mNotifManager.cancel(14);
                setIsResultNotifShow(false);
                this.mbProgressNotifShow = false;
            } catch (Exception e) {
            }
        }
    }

    public void setIsResultNotifShow(boolean isShow) {
        this.mbResultNotifShow = isShow;
    }

    public boolean isProgressNotifShow() {
        return this.mbProgressNotifShow;
    }
}
