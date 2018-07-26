package com.baidu.navisdk.ui.routeguide.model;

import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMNotificationBaseView.NotificationDisplayListener;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOperableNotificationView.NotificationClickListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;

public class RGJamReportModel {
    private static final String TAG = RGJamReportModel.class.getSimpleName();
    public static final int TIME_AUTO_HIDE = 10000;
    private boolean hasJamReportShown;
    private boolean isJamming;
    public boolean isViewCanShow;

    /* renamed from: com.baidu.navisdk.ui.routeguide.model.RGJamReportModel$1 */
    class C44461 implements NotificationDisplayListener {
        C44461() {
        }

        public void onShowWithAnim() {
            RGViewController.getInstance().hideHighWayServiceView();
        }

        public void onShowWithOutAnim() {
            RGViewController.getInstance().hideHighWayServiceView();
        }

        public void onHideWithAnim() {
            if (RGHighwayModel.getInstance().isSimpleBoardCanShow()) {
                RGViewController.getInstance().showHighWayServiceView();
            }
        }

        public void onHideWithOutAnim() {
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.model.RGJamReportModel$2 */
    class C44472 implements NotificationClickListener {
        C44472() {
        }

        public void onConfirmBtnClick() {
            RGJamReportModel.this.isViewCanShow = false;
            RGJamReportModel.this.onConfirmClick(true);
        }

        public void onCancelBtnClick() {
            RGJamReportModel.this.isViewCanShow = false;
            RGJamReportModel.this.onConfirmClick(false);
        }

        public void onAutoHideWithoutClick() {
            RGJamReportModel.this.isViewCanShow = false;
            RGJamReportModel.this.onConfirmClick(false);
        }
    }

    private static class LazyLoader {
        private static final RGJamReportModel sInstance = new RGJamReportModel();

        private LazyLoader() {
        }
    }

    private RGJamReportModel() {
        this.isViewCanShow = false;
        this.isJamming = false;
        this.hasJamReportShown = false;
    }

    public static RGJamReportModel getInstance() {
        return LazyLoader.sInstance;
    }

    public boolean speedCheck(float speed) {
        LogUtil.m15791e(TAG, "speedCheck: speed --> " + (((double) speed) * 3.6d));
        return ((double) speed) * 3.6d < 20.0d;
    }

    public RGMMOperableNotificationView getNotificationView() {
        RGMMOperableNotificationView view = RGViewController.getInstance().newOperableNotification(108).setPriority(100).setAutoHideTime(10000).setMainTitleText("路况异常拥堵,上报原因").setSubTitleText("上报帮助其他车友提前避让").setConfirmText("上报").setCancelText("关闭").setShowMasking(true).setOnClick(new C44472()).setDisplayListener(new C44461());
        view.setNotificationIcon(BNStyleManager.getDrawable(C4048R.drawable.type_default_trafic_jam));
        return view;
    }

    private void onConfirmClick(boolean ok) {
        if (ok) {
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_u, "4", null, null);
            BNavigator.getInstance().onUGCMenuActionOuter();
            return;
        }
        BNavigator.getInstance().hideJamReport();
    }

    public boolean isJamming() {
        return this.isJamming;
    }

    public void setJamming(boolean jamming) {
        this.isJamming = jamming;
    }

    public boolean isHasJamReportShown() {
        return this.hasJamReportShown;
    }

    public void setHasJamReportShown(boolean hasJamReportShown) {
        this.hasJamReportShown = hasJamReportShown;
    }
}
