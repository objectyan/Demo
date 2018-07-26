package com.baidu.navisdk.lightnavi.view;

import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviSwitchManager;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

public class RGSlightGuideView extends RGSlightBaseView {
    private BNWorkerNormalTask<String, String> mCancelNotifyTask = new BNWorkerNormalTask<String, String>("mCancelNotify-" + getClass().getSimpleName(), null) {
        protected String execute() {
            try {
                if (RGSlightGuideView.this.mNotificationManager != null) {
                    RGSlightGuideView.this.mNotificationManager.cancel(RGSlightGuideView.this.notification_id);
                }
            } catch (Exception e) {
            }
            return null;
        }
    };
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private LinearLayout mLLGuideBtn;
    private NotificationManager mNotificationManager;
    private RelativeLayout mRLGuideParent;
    private int notification_id = 1212;

    /* renamed from: com.baidu.navisdk.lightnavi.view.RGSlightGuideView$1 */
    class C41181 implements OnClickListener {
        C41181() {
        }

        public void onClick(View v) {
            RGSlightGuideView.this.mRLGuideParent.setVisibility(0);
        }
    }

    /* renamed from: com.baidu.navisdk.lightnavi.view.RGSlightGuideView$2 */
    class C41192 implements OnClickListener {
        C41192() {
        }

        public void onClick(View v) {
            RGSlightGuideView.this.mRLGuideParent.setVisibility(8);
        }
    }

    public RGSlightGuideView(Context c, ViewGroup p) {
        super(c, p);
        initView();
        initListener();
        try {
            this.mNotificationManager = (NotificationManager) this.mContext.getSystemService("notification");
        } catch (Exception e) {
        }
    }

    public void initView() {
        this.mRLGuideParent = (RelativeLayout) this.mRootViewGroup.findViewById(C4048R.id.bnav_lv_rg_ipo_guide_parent);
        this.mLLGuideBtn = (LinearLayout) this.mRootViewGroup.findViewById(C4048R.id.bnav_lv_rg_ll_ipo_guide);
    }

    public void initListener() {
        this.mLLGuideBtn.setOnClickListener(new C41181());
        this.mRLGuideParent.setOnClickListener(new C41192());
    }

    public boolean quitGuide() {
        if (this.mRLGuideParent.getVisibility() != 0) {
            return false;
        }
        this.mRLGuideParent.setVisibility(8);
        return true;
    }

    private void showNotify(long delayMillis) {
        try {
            Builder builder4 = new Builder(this.mContext);
            builder4.setSmallIcon(BNaviModuleManager.getAppIconId());
            builder4.setContentIntent(PendingIntent.getActivity(this.mContext, this.notification_id, new Intent(), 134217728));
            if (BNRoutePlaner.getInstance().getEntry() == 16) {
                builder4.setTicker("发现您正在行驶，已经进入路线雷达");
                UserOPController.getInstance().add(UserOPParams.LIGHTGUIDE_4_1, "", null, null);
            } else {
                builder4.setTicker("已经进入路线雷达");
                UserOPController.getInstance().add(UserOPParams.LIGHTGUIDE_4_1, null, "", null);
            }
            builder4.setAutoCancel(true);
            if (this.mNotificationManager != null) {
                this.mNotificationManager.notify(this.notification_id, builder4.build());
                BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mCancelNotifyTask, new BNWorkerConfig(9, 0), delayMillis);
            }
        } catch (Throwable th) {
        }
    }

    public void showNotify() {
        if (!BNLightNaviSwitchManager.getInstance().getHaveSwitched()) {
            showNotify(2500);
        }
    }

    public void quit() {
        if (this.mNotificationManager != null) {
            this.mNotificationManager.cancel(this.notification_id);
        }
        BNWorkerCenter.getInstance().cancelTask(this.mCancelNotifyTask, false);
    }
}
