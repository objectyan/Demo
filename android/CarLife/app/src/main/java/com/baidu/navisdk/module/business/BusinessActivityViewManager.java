package com.baidu.navisdk.module.business;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.model.modelfactory.BusinessActivityModel;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmState;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.UIUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;

public class BusinessActivityViewManager {
    private static final int MSG_AUTO_HIDE_BANNER_WINDOW = 2;
    private static final int MSG_AUTO_HIDE_POP_WINDOW = 1;
    private static final String TAG = BusinessActivityViewManager.class.getSimpleName();
    private static Object mSyncObj = new Object();
    private static BusinessActivityViewManager sInstance = null;
    private View mBusiBannerArea = null;
    private TextView mBusiBannerContent = null;
    private ImageView mBusiBannerImageView = null;
    private TextView mBusiBannerTips = null;
    private View mBusiLogoArea = null;
    private ImageView mBusiLogoImageView = null;
    private TextView mBusiLogoText = null;
    private View mBusiRootView = null;
    private boolean mDayStyle = true;
    private Handler mHD = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    BusinessActivityViewManager.this.hidePop();
                    BusinessActivityManager.getInstance().getModel().resetTrafficJam();
                    BusinessActivityManager.getInstance().getModel().resetParking();
                    BusinessActivityViewManager.this.mIsShowing = false;
                    return;
                case 2:
                    BusinessActivityViewManager.this.hideBanner();
                    BusinessActivityManager.getInstance().getModel().resetTrafficJam();
                    BusinessActivityManager.getInstance().getModel().resetParking();
                    BusinessActivityViewManager.this.mIsShowing = false;
                    return;
                default:
                    return;
            }
        }
    };
    private boolean mIsBannerShowing = false;
    private boolean mIsPopShowing = false;
    private boolean mIsShowing = false;

    /* renamed from: com.baidu.navisdk.module.business.BusinessActivityViewManager$1 */
    class C41591 implements OnClickListener {
        C41591() {
        }

        public void onClick(View v) {
            BusinessActivityViewManager.this.showBanner(false);
            BusinessActivityManager.getInstance().getModel().isPrizeReceived = true;
            BusinessActivityModel model = BusinessActivityManager.getInstance().getModel();
            model.hasClickActivityCount++;
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_n, null, null, "" + BusinessActivityManager.getInstance().getModel().aid);
            LogUtil.m15791e(BusinessActivityViewManager.TAG, "pop.onClick() receive prize.");
        }
    }

    /* renamed from: com.baidu.navisdk.module.business.BusinessActivityViewManager$2 */
    class C41602 implements OnClickListener {
        C41602() {
        }

        public void onClick(View v) {
            BusinessActivityViewManager.this.hideViews();
        }
    }

    private BusinessActivityViewManager() {
    }

    public static BusinessActivityViewManager getInstance() {
        if (sInstance == null) {
            synchronized (mSyncObj) {
                if (sInstance == null) {
                    sInstance = new BusinessActivityViewManager();
                }
            }
        }
        return sInstance;
    }

    public boolean isShowing() {
        return this.mIsShowing;
    }

    public void showViews(Activity act, boolean reShowForOrientaionChanged) {
        if ((this.mIsShowing && !reShowForOrientaionChanged) || act == null) {
            return;
        }
        if (BusinessActivityManager.getInstance().getModel() == null || !BusinessActivityManager.getInstance().getModel().isOpen) {
            LogUtil.m15791e(TAG, "showViews() no show for activity is not open.");
        } else if (reShowForOrientaionChanged || (BusinessActivityManager.getInstance().getModel().hasShowActivityCount < BusinessActivityManager.getInstance().getModel().anum && BusinessActivityManager.getInstance().getModel().hasClickActivityCount < BusinessActivityManager.getInstance().getModel().rnum)) {
            LogUtil.m15791e(TAG, "showViews() reShowForOrientaionChanged=" + reShowForOrientaionChanged + ", mIsPopShowing=" + this.mIsPopShowing + ", mIsBannerShowing=" + this.mIsBannerShowing);
            releaseViews();
            if (!loadView(act)) {
                return;
            }
            if (!reShowForOrientaionChanged || this.mIsPopShowing) {
                showPop(reShowForOrientaionChanged);
            } else if (this.mIsBannerShowing) {
                showBanner(reShowForOrientaionChanged);
            }
        } else {
            LogUtil.m15791e(TAG, "showViews() no show for max. hasShowCount=" + BusinessActivityManager.getInstance().getModel().hasShowActivityCount);
        }
    }

    private boolean loadView(Activity a) {
        if (a == null) {
            return false;
        }
        try {
            this.mBusiRootView = JarUtils.inflate(a, C4048R.layout.nsdk_layout_rg_mapmode_business, null);
            if (this.mBusiRootView == null) {
                return false;
            }
            this.mBusiLogoArea = this.mBusiRootView.findViewById(C4048R.id.nsdk_layout_rg_busi_logo_area);
            this.mBusiLogoImageView = (ImageView) this.mBusiRootView.findViewById(C4048R.id.nsdk_layout_rg_busi_logo_image);
            this.mBusiLogoText = (TextView) this.mBusiRootView.findViewById(C4048R.id.nsdk_layout_rg_busi_logo_text);
            this.mBusiBannerArea = this.mBusiRootView.findViewById(C4048R.id.nsdk_layout_rg_busi_banner_area);
            this.mBusiBannerContent = (TextView) this.mBusiRootView.findViewById(C4048R.id.nsdk_layout_rg_busi_banner_content);
            this.mBusiBannerImageView = (ImageView) this.mBusiRootView.findViewById(C4048R.id.nsdk_layout_rg_busi_banner_image);
            this.mBusiBannerTips = (TextView) this.mBusiRootView.findViewById(C4048R.id.nsdk_layout_rg_busi_banner_tips);
            if (this.mBusiLogoArea == null || this.mBusiLogoImageView == null || this.mBusiBannerArea == null || this.mBusiBannerContent == null || this.mBusiBannerImageView == null || this.mBusiBannerTips == null) {
                return false;
            }
            this.mBusiLogoArea.setOnClickListener(new C41591());
            this.mBusiBannerArea.setOnClickListener(new C41602());
            ViewGroup containsView = RGMapModeViewController.getInstance().getModuleContails();
            if (containsView == null) {
                return false;
            }
            containsView.removeAllViews();
            LayoutParams lp = new LayoutParams(-1, -1);
            containsView.setPadding(getMarginLeft(), 0, 0, getMarginBottom());
            containsView.addView(this.mBusiRootView, lp);
            if (!this.mDayStyle) {
                onUpdateStyle(this.mDayStyle, true);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void showPop(boolean reShowForOrientaionChanged) {
        if (this.mBusiBannerArea != null) {
            this.mBusiBannerArea.setVisibility(8);
        }
        if (BusinessActivityManager.getInstance().getModel().logoBitmap != null) {
            this.mBusiLogoImageView.setImageBitmap(BusinessActivityManager.getInstance().getModel().logoBitmap);
            this.mBusiLogoArea.setVisibility(0);
            ViewGroup containsView = RGMapModeViewController.getInstance().getModuleContails();
            if (containsView != null) {
                containsView.setVisibility(0);
                if (!reShowForOrientaionChanged) {
                    BusinessActivityModel model = BusinessActivityManager.getInstance().getModel();
                    model.hasShowActivityCount++;
                    BusinessActivityPlayerManager.getInstance().playContentWhenShowActivity();
                    UserOPController.getInstance().add(UserOPParams.GUIDE_3_m, null, null, "" + BusinessActivityManager.getInstance().getModel().aid);
                    this.mHD.sendEmptyMessageDelayed(1, (long) (BusinessActivityManager.getInstance().getModel().showTime * 1000));
                }
                this.mIsShowing = true;
                this.mIsPopShowing = true;
                this.mIsBannerShowing = false;
            }
        }
    }

    private int getMarginLeft() {
        if (1 == RGViewController.getInstance().getOrientation()) {
            return 0;
        }
        return ScreenUtil.getInstance().getHeightPixels() / 3;
    }

    private int getMarginBottom() {
        String mapState = RouteGuideFSM.getInstance().getLastestMap2DOr3DState();
        if (TextUtils.isEmpty(mapState)) {
            mapState = FsmState.Car3D;
        }
        if (1 == RGViewController.getInstance().getOrientation()) {
            if (FsmState.Car3D.equals(mapState)) {
                return ((ScreenUtil.getInstance().getHeightPixels() / 2) - ((int) (((double) ScreenUtil.getInstance().getHeightPixels()) * 0.25d))) + 80;
            }
            return ((ScreenUtil.getInstance().getHeightPixels() / 2) - ScreenUtil.getInstance().dip2px(64)) + 80;
        } else if (FsmState.Car3D.equals(mapState)) {
            return ((ScreenUtil.getInstance().getWidthPixels() / 2) - ((int) (((double) ScreenUtil.getInstance().getWidthPixels()) * 0.25d))) + 80;
        } else {
            return ((ScreenUtil.getInstance().getWidthPixels() / 2) - ((int) (((double) ScreenUtil.getInstance().getWidthPixels()) * 0.1d))) + 80;
        }
    }

    private void hidePop() {
        this.mIsPopShowing = false;
        if (this.mHD.hasMessages(1)) {
            this.mHD.removeMessages(1);
        }
        if (this.mBusiLogoArea != null) {
            this.mBusiLogoArea.setVisibility(8);
        }
        LogUtil.m15791e(BusinessActivityManager.TAG, "view.hidePop() ");
    }

    private void showBanner(boolean reShowForOrientaionChanged) {
        this.mIsBannerShowing = true;
        this.mIsPopShowing = false;
        if (this.mBusiLogoArea != null) {
            this.mBusiLogoArea.setVisibility(8);
        }
        if (this.mBusiBannerArea != null) {
            this.mBusiBannerContent.setText(BusinessActivityManager.getInstance().getModel().title);
            this.mBusiBannerImageView.setImageBitmap(BusinessActivityManager.getInstance().getModel().bannerBitmap);
            this.mBusiBannerArea.setVisibility(0);
            this.mBusiBannerImageView.setVisibility(0);
            ViewGroup containsView = RGMapModeViewController.getInstance().getModuleContails();
            if (containsView != null) {
                containsView.setVisibility(0);
                if (!reShowForOrientaionChanged) {
                    this.mHD.sendEmptyMessageDelayed(2, (long) (BusinessActivityManager.getInstance().getModel().rtime * 1000));
                }
            }
        }
    }

    private void hideBanner() {
        this.mIsBannerShowing = false;
        this.mIsShowing = false;
        if (this.mHD.hasMessages(2)) {
            this.mHD.removeMessages(2);
        }
        if (this.mBusiBannerArea != null) {
            this.mBusiBannerArea.setVisibility(8);
        }
        LogUtil.m15791e(BusinessActivityManager.TAG, "view.hideBanner() ");
    }

    public void onUpdateStyle(boolean dayStyle, boolean force) {
        if (force || this.mDayStyle != dayStyle) {
            this.mDayStyle = dayStyle;
            if (this.mBusiLogoArea != null && this.mBusiLogoImageView != null && this.mBusiLogoText != null && this.mBusiBannerArea != null && this.mBusiBannerContent != null && this.mBusiBannerImageView != null) {
                this.mBusiLogoArea.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_rg_other_gift_popup_big));
                this.mBusiLogoText.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_a));
                this.mBusiBannerArea.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_rg_other_gift_popup_big));
                this.mBusiBannerTips.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_c));
            }
        }
    }

    public void hideViews() {
        if (this.mHD.hasMessages(1)) {
            this.mHD.removeMessages(1);
        }
        if (this.mHD.hasMessages(2)) {
            this.mHD.removeMessages(2);
        }
        ViewGroup vg = RGMapModeViewController.getInstance().getModuleContails();
        if (vg != null) {
            vg.removeAllViews();
            vg.setVisibility(8);
        }
        if (this.mBusiRootView != null) {
            this.mBusiRootView.setVisibility(0);
        }
        if (this.mBusiLogoImageView != null) {
            UIUtils.releaseImageView(this.mBusiLogoImageView);
            this.mBusiLogoImageView = null;
        }
        if (this.mBusiBannerImageView != null) {
            UIUtils.releaseImageView(this.mBusiBannerImageView);
            this.mBusiBannerImageView = null;
        }
        this.mBusiRootView = null;
        this.mIsShowing = false;
        this.mIsPopShowing = false;
        this.mIsBannerShowing = false;
        LogUtil.m15791e(BusinessActivityManager.TAG, "view.hideViews() ");
    }

    private void releaseViews() {
        if (this.mBusiRootView != null) {
            this.mBusiRootView.setVisibility(0);
        }
        if (this.mBusiLogoImageView != null) {
            UIUtils.releaseImageView(this.mBusiLogoImageView);
            this.mBusiLogoImageView = null;
        }
        if (this.mBusiBannerImageView != null) {
            UIUtils.releaseImageView(this.mBusiBannerImageView);
            this.mBusiBannerImageView = null;
        }
        this.mBusiRootView = null;
    }
}
