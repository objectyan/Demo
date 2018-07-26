package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.ui.routeguide.BNavConfig;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

public class RGUserRightView extends BNBaseView {
    private LinearLayout mUserCurMileaLL;
    private TextView mUserCurMileaTv;
    private LinearLayout mUserRightLL;
    private LinearLayout mUserRightUpgradeTipsLL;
    private TextView mUserRightUpgradeTipsTv;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGUserRightView$1 */
    class C44431 implements OnClickListener {
        C44431() {
        }

        public void onClick(View arg0) {
            if (RGUserRightView.this.mUserRightUpgradeTipsLL.getVisibility() != 0 && !StringUtils.isEmpty(BusinessActivityManager.getInstance().getModel().userRightUpgradeTips)) {
                if (RGUserRightView.this.mUserRightUpgradeTipsTv != null) {
                    RGUserRightView.this.mUserRightUpgradeTipsTv.setText(BusinessActivityManager.getInstance().getModel().userRightUpgradeTips);
                }
                RGUserRightView.this.mUserRightUpgradeTipsLL.setVisibility(0);
                BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("initViews-" + getClass().getSimpleName(), null) {
                    protected String execute() {
                        RGUserRightView.this.mUserRightUpgradeTipsLL.setVisibility(8);
                        return null;
                    }
                }, new BNWorkerConfig(2, 0), 3000);
            }
        }
    }

    public RGUserRightView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
        initViews();
    }

    public void orientationChanged(ViewGroup view, int orien) {
        super.orientationChanged(view, orien);
        initViews();
    }

    private void initViews() {
        if (this.mRootViewGroup != null) {
            this.mUserRightLL = (LinearLayout) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_user_right_rl);
            this.mUserCurMileaLL = (LinearLayout) this.mRootViewGroup.findViewById(C4048R.id.user_cur_milea_ll);
            this.mUserCurMileaTv = (TextView) this.mRootViewGroup.findViewById(C4048R.id.user_current_milea_tv);
            this.mUserRightUpgradeTipsLL = (LinearLayout) this.mRootViewGroup.findViewById(C4048R.id.user_right_upgrade_tips_ll);
            this.mUserRightUpgradeTipsTv = (TextView) this.mRootViewGroup.findViewById(C4048R.id.user_right_upgrade_tips_tv);
            this.mUserRightLL.setVisibility(8);
            this.mUserRightUpgradeTipsLL.setVisibility(8);
            this.mUserCurMileaLL.setOnClickListener(new C44431());
        }
    }

    public void updateCurMileaInfo() {
        String uuid = JNITrajectoryControl.sInstance.getCurrentUUID();
        if (uuid != null) {
            long totalMilea = (JNITrajectoryControl.sInstance.getTrajectoryLength(uuid) / 1000) + ((long) BusinessActivityManager.getInstance().getModel().userHistoryMileas);
            if (this.mUserCurMileaTv != null) {
                String totalMileaStr = String.valueOf(totalMilea);
                if (totalMileaStr.length() < 4) {
                    this.mUserCurMileaTv.setTextSize(20.0f);
                } else if (totalMileaStr.length() == 4) {
                    this.mUserCurMileaTv.setTextSize(16.0f);
                } else {
                    this.mUserCurMileaTv.setTextSize(13.0f);
                    totalMileaStr = "9999+";
                }
                this.mUserCurMileaTv.setText(totalMileaStr);
            }
        }
    }

    public void show() {
        if (NetworkUtils.isNetworkAvailable(this.mContext) && BNavConfig.pRGLocateMode != 2 && BusinessActivityManager.getInstance().getModel().isShowUserRight == 1 && !StringUtils.isEmpty(BusinessActivityManager.getInstance().getModel().userRightUpgradeTips)) {
            updateCurMileaInfo();
        }
    }

    public void hide() {
        if (this.mUserRightLL != null) {
            this.mUserRightLL.setVisibility(8);
        }
    }

    public void hideUserRightTipsView() {
        if (this.mUserRightUpgradeTipsLL != null) {
            this.mUserRightUpgradeTipsLL.setVisibility(8);
        }
    }
}
