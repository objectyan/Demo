package com.baidu.navisdk.lightnavi.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.lightnavi.LightNaviParams;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.lightnavi.model.YellowBarMessage;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;

public class RGSlightYellowBannerView extends RGSlightBaseView {
    private static final String TAG = RGSlightYellowBannerView.class.getSimpleName();
    private boolean isShowYellowBanner = false;
    private ConditionMassageUpdateBean mCMUBean;
    private ImageView mIVGuideColse;
    private ImageView mIVGuideJam;
    private boolean mIsShow;
    private int mPriority;
    private TextView mRoadCondition;
    private RelativeLayout mRoadConditionClose;
    private TextView mRoadConditionLock;
    private RelativeLayout mRoadConditionParent;
    private int mRouteIndex;

    /* renamed from: com.baidu.navisdk.lightnavi.view.RGSlightYellowBannerView$1 */
    class C41211 implements OnClickListener {
        C41211() {
        }

        public void onClick(View v) {
            if (RGSlightYellowBannerView.this.mPriority == 2) {
                LightNaviParams.mGpsInfoHasBeenClosed = true;
            }
            RGSlightYellowBannerView.this.hideGuideText(5);
            RGSlightYellowBannerView.this.updateYellowBanner(false);
            LightNaviParams.isGuideHasBeanClose = true;
            if (RGSlightYellowBannerView.this.mCMUBean != null) {
                RGSlightYellowBannerView.this.mCMUBean.hasClosed = true;
            }
            if (RGSlightYellowBannerView.this.mPriority == 4) {
                BNSettingManager.setIPOGuideShowTime(0);
            }
        }
    }

    public class ConditionMassageUpdateBean {
        public boolean hasClosed = false;
        public int mAddDist;
        public String mGuideMsg;
        public int mGuideType;
        public int mObstructionLength;

        public ConditionMassageUpdateBean copy(ConditionMassageUpdateBean mBean) {
            if (mBean == null) {
                mBean = new ConditionMassageUpdateBean();
            }
            mBean.mGuideMsg = this.mGuideMsg;
            mBean.mGuideType = this.mGuideType;
            mBean.mAddDist = this.mAddDist;
            mBean.mObstructionLength = this.mObstructionLength;
            return mBean;
        }
    }

    public RGSlightYellowBannerView(Context c, ViewGroup p) {
        super(c, p);
        initView();
        initListener();
    }

    public RGSlightYellowBannerView(Context c, ViewGroup p, Handler handler) {
        super(c, p, handler);
        initView();
        initListener();
    }

    public void initView() {
        this.mRoadCondition = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_lv_rg_road_condition);
        this.mRoadConditionClose = (RelativeLayout) this.mRootViewGroup.findViewById(C4048R.id.bnav_lv_rg_road_condition_close);
        this.mRoadConditionParent = (RelativeLayout) this.mRootViewGroup.findViewById(C4048R.id.bnav_lv_rg_road_condition_parent);
        this.mRoadConditionLock = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_lv_rg_road_condition_lock);
        this.mIVGuideJam = (ImageView) this.mRootViewGroup.findViewById(C4048R.id.bnav_iv_rg_road_jam);
    }

    public void initListener() {
        this.mRoadConditionClose.setOnClickListener(new C41211());
    }

    public void showGuideText(YellowBarMessage msg) {
        LogUtil.m15791e(TAG, "showGuideText: --> mPriority = " + this.mPriority + ", msg.mPriority=" + msg.mPriority);
        if (msg.mPriority == 4) {
            LogUtil.m15791e(TAG, "showGuideText: --> SLIGHT_GUIDE ");
            this.mPriority = msg.mPriority;
            if (!(this.mRoadCondition == null || this.mRoadConditionParent == null)) {
                this.mRoadCondition.setText(msg.mMsgContent);
                this.mRoadConditionParent.setVisibility(0);
                updateYellowBanner(true);
            }
            if (this.mIVGuideJam != null) {
                this.mIVGuideJam.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_ipo_route_guide));
            }
        } else if (msg.mPriority >= this.mPriority) {
            this.mPriority = msg.mPriority;
            if (msg.mPriority == 3) {
                LogUtil.m15791e(TAG, "showGuideText: --> SLIGHT_SWITCH ");
                this.mRouteIndex = msg.mRouteIndex;
                if (this.mRoadConditionLock != null) {
                    this.mRoadConditionLock.setText(Html.fromHtml(msg.mMsgContent));
                    this.mRoadConditionLock.setVisibility(0);
                }
                if (!(this.mRoadCondition == null || this.mRoadConditionParent == null)) {
                    this.mRoadCondition.setText(Html.fromHtml(msg.mMsgContent));
                    this.mRoadConditionParent.setVisibility(0);
                    updateYellowBanner(true);
                }
                if (this.mIVGuideJam != null) {
                    this.mIVGuideJam.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_ipo_route_guide));
                }
            } else if (msg.mPriority == 2) {
                LogUtil.m15791e(TAG, "showGuideText: --> SLIGHT_GPS ");
                if (this.mRoadConditionLock != null) {
                    this.mRoadConditionLock.setText(msg.mMsgContent);
                    this.mRoadConditionLock.setVisibility(0);
                }
                if (!(this.mRoadCondition == null || this.mRoadConditionParent == null)) {
                    this.mRoadCondition.setText(msg.mMsgContent);
                    this.mRoadConditionParent.setVisibility(0);
                    updateYellowBanner(true);
                }
                if (this.mIVGuideJam != null) {
                    this.mIVGuideJam.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_ipo_route_gps_lost));
                }
            } else if (msg.mPriority == 1) {
                LogUtil.m15791e(TAG, "showGuideText: --> SLIGHT_JAM ");
                if (this.mRoadConditionLock != null) {
                    this.mRoadConditionLock.setText(msg.mMsgContent);
                    this.mRoadConditionLock.setVisibility(0);
                }
                if (!(this.mRoadCondition == null || this.mRoadConditionParent == null)) {
                    this.mRoadCondition.setText(msg.mMsgContent);
                    this.mRoadConditionParent.setVisibility(0);
                    updateYellowBanner(true);
                }
                if (this.mIVGuideJam != null) {
                    this.mIVGuideJam.setImageDrawable(JarUtils.getResources().getDrawable(C4048R.drawable.nsdk_ipo_route_jam));
                }
            }
        }
    }

    public void hideGuideText(int priority) {
        LogUtil.m15791e(TAG, "hideGuideText: priority --> " + priority);
        if (priority >= this.mPriority) {
            boolean gpsMsgIsShowing = false;
            if (this.mPriority == 2 && priority != 5 && priority > this.mPriority) {
                gpsMsgIsShowing = true;
            }
            LogUtil.m15791e(TAG, "hideGuideText: gpsMsgIsShowing --> " + gpsMsgIsShowing);
            if (!gpsMsgIsShowing) {
                this.mPriority = 0;
                this.mHandler.sendEmptyMessage(3001);
                if (this.mRoadConditionParent != null && this.mRoadConditionLock != null) {
                    updateYellowBanner(false);
                    this.mRoadConditionParent.setVisibility(8);
                    this.mRoadConditionLock.setVisibility(8);
                }
            }
        }
    }

    public void onRoadConditionUpdate() {
        Bundle bundle = BNRouteGuider.getInstance().getRoadConditionText4LightGuide();
        ConditionMassageUpdateBean tmpCMUBean = new ConditionMassageUpdateBean();
        tmpCMUBean.mGuideMsg = bundle.getString("guideStr");
        tmpCMUBean.mGuideType = bundle.getInt("nRoadConditionTextType");
        tmpCMUBean.mAddDist = bundle.getInt("nGPAddDist");
        tmpCMUBean.mObstructionLength = bundle.getInt("nObstructionLengthPara");
        if (this.mCMUBean != null) {
            LogUtil.m15791e("wangyang", "showGuideText_onIPORoadConditionUpdate txt =" + this.mCMUBean.mGuideMsg + " type= ," + tmpCMUBean.mGuideType + " addDis= " + this.mCMUBean.mAddDist + "," + tmpCMUBean.mAddDist + " olength= " + this.mCMUBean.mObstructionLength + "," + tmpCMUBean.mObstructionLength);
        }
        if (this.mCMUBean == null || !this.mCMUBean.hasClosed || ((this.mCMUBean.mGuideType != tmpCMUBean.mGuideType || this.mCMUBean.mAddDist - tmpCMUBean.mAddDist >= this.mCMUBean.mObstructionLength) && !tmpCMUBean.mGuideMsg.equals(this.mCMUBean.mGuideMsg))) {
            LogUtil.m15791e(TAG, "wy--SLIGHT_JAM show ");
            this.mCMUBean = tmpCMUBean.copy(this.mCMUBean);
            YellowBarMessage yMsg = new YellowBarMessage();
            yMsg.mPriority = 1;
            yMsg.mMsgContent = this.mCMUBean.mGuideMsg;
            yMsg.mRouteIndex = -1;
            showGuideText(yMsg);
            if (BNLightNaviManager.getInstance().getType() == 2) {
                this.mRoadCondition.setFocusable(true);
            } else {
                this.mRoadConditionLock.setFocusable(true);
            }
        }
    }

    public void focusBright() {
        if (this.mRoadConditionParent.getVisibility() == 0) {
            this.mRoadCondition.setFocusable(true);
        }
    }

    public void focusLock() {
        if (this.mRoadConditionLock.getVisibility() == 0) {
            this.mRoadConditionLock.setFocusable(true);
        }
    }

    public boolean isBrightConditionShow() {
        if (this.mRoadConditionParent == null || this.mRoadConditionParent.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public boolean isLockConditionShow() {
        if (this.mRoadConditionLock == null || this.mRoadConditionLock.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void showOnlyBrightCondition() {
        if (this.mRoadConditionParent != null) {
            this.mRoadConditionLock.setVisibility(8);
            this.mRoadConditionParent.setVisibility(0);
        }
    }

    private void updateYellowBanner(boolean isShowOrHideYellowBanner) {
        if (this.isShowYellowBanner != isShowOrHideYellowBanner && isShowOrHideYellowBanner) {
            LogUtil.m15791e(TAG, "updateYellowBanner: update show yellow banner bar; \npreview yellow banner status: " + (this.isShowYellowBanner ? "show; " : "hide; ") + "\nnow yellow banner status: " + (isShowOrHideYellowBanner ? "show" : "hide"));
            this.isShowYellowBanner = isShowOrHideYellowBanner;
            UserOPController.getInstance().add(UserOPParams.LIGHTGUIDE_4_k, "", null, null);
        } else if (this.isShowYellowBanner != isShowOrHideYellowBanner && !isShowOrHideYellowBanner) {
            LogUtil.m15791e(TAG, "updateYellowBanner: update hide yellow banner bar; \npreview yellow banner status: " + (this.isShowYellowBanner ? "show; " : "hide; ") + "\nnow yellow banner status: " + (isShowOrHideYellowBanner ? "show" : "hide"));
            this.isShowYellowBanner = isShowOrHideYellowBanner;
            UserOPController.getInstance().add(UserOPParams.LIGHTGUIDE_4_k, null, "", null);
        }
    }
}
