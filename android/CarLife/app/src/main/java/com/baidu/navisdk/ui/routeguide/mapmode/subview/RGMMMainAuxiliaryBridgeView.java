package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;

public class RGMMMainAuxiliaryBridgeView extends BNBaseView {
    public static final int MAB_VIEW_TYPE_ALL_DISMISS = 0;
    public static final int MAB_VIEW_TYPE_AUXILIARY_ROAD = 2;
    public static final int MAB_VIEW_TYPE_MAIN_ROAD = 1;
    public static final int MAB_VIEW_TYPE_ON_BRIDGE = 4;
    public static final int MAB_VIEW_TYPE_ON_BRIDGE_AUXILIARY_ROAD = 6;
    public static final int MAB_VIEW_TYPE_ON_BRIDGE_MAIN_ROAD = 5;
    public static final int MAB_VIEW_TYPE_UNDER_BRIDGE = 8;
    public static final int MAB_VIEW_TYPE_UNDER_BRIDGE_AUXILIARY_ROAD = 10;
    private static final String TAG = "RGMMMainAuxiliaryBridgeView";
    private boolean isBothShow = false;
    private boolean isBtnClicked = false;
    private View mBridgeRoadLinear = null;
    private int mCurrentType = -1;
    private ImageView mIVBridgeSwitch = null;
    private ImageView mIVMASwitch = null;
    private View mMainRoadViewLinear = null;
    private RelativeLayout mRLBridgeSwitch = null;
    private RelativeLayout mRLMASwitch = null;
    private TextView mTVBridgeSwitch = null;
    private TextView mTVMASwitch = null;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMMainAuxiliaryBridgeView$1 */
    class C43811 implements OnClickListener {
        C43811() {
        }

        public void onClick(View v) {
            if (RGMMMainAuxiliaryBridgeView.this.mSubViewListener == null) {
                LogUtil.m15791e(RGMMMainAuxiliaryBridgeView.TAG, "mRLMASwitch mSubViewListener == null");
            } else if (ForbidDaulClickUtils.isFastDoubleClick()) {
                LogUtil.m15791e(RGMMMainAuxiliaryBridgeView.TAG, "mRLMASwitch isFastDoubleClick");
            } else {
                if (RGMMMainAuxiliaryBridgeView.this.isBothShow) {
                    int clickedType = RGMMMainAuxiliaryBridgeView.this.getClickedTypeByShowType(RGMMMainAuxiliaryBridgeView.this.mCurrentType, RGMMMainAuxiliaryBridgeView.this.mRLMASwitch.getId());
                    LogUtil.m15791e(RGMMMainAuxiliaryBridgeView.TAG, "mRLMASwitch isBothShow clickedType = " + clickedType + ", mCurrentType = " + RGMMMainAuxiliaryBridgeView.this.mCurrentType);
                    if (clickedType == 1) {
                        UserOPController.getInstance().add(UserOPParams.GUIDE_3_v_1, "2", null, null);
                    } else if (clickedType == 2) {
                        UserOPController.getInstance().add(UserOPParams.GUIDE_3_v_2, "2", null, null);
                    }
                    if (!(RGMMMainAuxiliaryBridgeView.this.mSubViewListener == null || clickedType == -1)) {
                        RGMMMainAuxiliaryBridgeView.this.mSubViewListener.onOnlineMainAuxiliarySwitch(clickedType);
                    }
                } else {
                    LogUtil.m15791e(RGMMMainAuxiliaryBridgeView.TAG, "mRLMASwitch NotBothShow mCurrentType = " + RGMMMainAuxiliaryBridgeView.this.mCurrentType);
                    if (RGMMMainAuxiliaryBridgeView.this.mCurrentType == 1) {
                        UserOPController.getInstance().add(UserOPParams.GUIDE_3_v_1, "2", null, null);
                    } else if (RGMMMainAuxiliaryBridgeView.this.mCurrentType == 2) {
                        UserOPController.getInstance().add(UserOPParams.GUIDE_3_v_2, "2", null, null);
                    }
                    if (RGMMMainAuxiliaryBridgeView.this.mSubViewListener != null) {
                        RGMMMainAuxiliaryBridgeView.this.mSubViewListener.onOnlineMainAuxiliarySwitch(RGMMMainAuxiliaryBridgeView.this.mCurrentType);
                    }
                }
                RGMMMainAuxiliaryBridgeView.this.isBtnClicked = true;
                RGMMMainAuxiliaryBridgeView.this.hide();
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMMainAuxiliaryBridgeView$2 */
    class C43822 implements OnClickListener {
        C43822() {
        }

        public void onClick(View v) {
            if (RGMMMainAuxiliaryBridgeView.this.mSubViewListener == null) {
                LogUtil.m15791e(RGMMMainAuxiliaryBridgeView.TAG, "mRLBridgeSwitch mSubViewListener == null");
            } else if (ForbidDaulClickUtils.isFastDoubleClick()) {
                LogUtil.m15791e(RGMMMainAuxiliaryBridgeView.TAG, "mRLBridgeSwitch isFastDoubleClick");
            } else {
                if (RGMMMainAuxiliaryBridgeView.this.isBothShow) {
                    int clickedType = RGMMMainAuxiliaryBridgeView.this.getClickedTypeByShowType(RGMMMainAuxiliaryBridgeView.this.mCurrentType, RGMMMainAuxiliaryBridgeView.this.mRLBridgeSwitch.getId());
                    LogUtil.m15791e(RGMMMainAuxiliaryBridgeView.TAG, "mRLBridgeSwitch isBothShow clickedType = " + clickedType + ", mCurrentType = " + RGMMMainAuxiliaryBridgeView.this.mCurrentType);
                    if (clickedType == 4) {
                        UserOPController.getInstance().add(UserOPParams.GUIDE_3_v_3, "2", null, null);
                    } else if (clickedType == 8) {
                        UserOPController.getInstance().add(UserOPParams.GUIDE_3_v_4, "2", null, null);
                    }
                    if (!(RGMMMainAuxiliaryBridgeView.this.mSubViewListener == null || clickedType == -1)) {
                        RGMMMainAuxiliaryBridgeView.this.mSubViewListener.onOnlineMainAuxiliarySwitch(clickedType);
                    }
                } else {
                    LogUtil.m15791e(RGMMMainAuxiliaryBridgeView.TAG, "mRLBridgeSwitch NotBothShow mCurrentType = " + RGMMMainAuxiliaryBridgeView.this.mCurrentType);
                    if (RGMMMainAuxiliaryBridgeView.this.mCurrentType == 4) {
                        UserOPController.getInstance().add(UserOPParams.GUIDE_3_v_3, "2", null, null);
                    } else if (RGMMMainAuxiliaryBridgeView.this.mCurrentType == 8) {
                        UserOPController.getInstance().add(UserOPParams.GUIDE_3_v_4, "2", null, null);
                    }
                    if (RGMMMainAuxiliaryBridgeView.this.mSubViewListener != null) {
                        RGMMMainAuxiliaryBridgeView.this.mSubViewListener.onOnlineMainAuxiliarySwitch(RGMMMainAuxiliaryBridgeView.this.mCurrentType);
                    }
                }
                RGMMMainAuxiliaryBridgeView.this.isBtnClicked = true;
                RGMMMainAuxiliaryBridgeView.this.hide();
            }
        }
    }

    public RGMMMainAuxiliaryBridgeView(Context c, ViewGroup v, OnRGSubViewListener lis) {
        super(c, v, lis);
        initView();
        updateStyle(BNStyleManager.getDayStyle());
        initListener();
    }

    public void orientationChanged(ViewGroup p, int orien) {
        super.orientationChanged(p, orien);
        initView();
        updateStyle(BNStyleManager.getDayStyle());
        initListener();
        updateMainAuxiliaryBridgeView(this.mCurrentType);
    }

    public boolean isBtnClicked() {
        return this.isBtnClicked;
    }

    public void resetBtnClicked() {
        this.isBtnClicked = false;
    }

    public void updateStyle(boolean day) {
        super.updateStyle(day);
        if (this.mBridgeRoadLinear != null) {
            this.mBridgeRoadLinear.setBackgroundDrawable(BNStyleManager.getRealDrawable(C4048R.drawable.map_bg_selector));
        }
        if (this.mMainRoadViewLinear != null) {
            this.mMainRoadViewLinear.setBackgroundDrawable(BNStyleManager.getRealDrawable(C4048R.drawable.map_bg_selector));
        }
        if (this.mTVBridgeSwitch != null) {
            this.mTVBridgeSwitch.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_h));
        }
        if (this.mTVMASwitch != null) {
            this.mTVMASwitch.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_h));
        }
        updateMainAuxiliaryBridgeView(this.mCurrentType);
    }

    private void initListener() {
        if (this.mRLMASwitch == null || this.mRLBridgeSwitch == null) {
            LogUtil.m15791e(TAG, "initListener mRLMASwitch mRLBridgeSwitch is null");
            return;
        }
        this.mRLMASwitch.setOnClickListener(new C43811());
        this.mRLBridgeSwitch.setOnClickListener(new C43822());
    }

    private void initView() {
        if (this.mRootViewGroup != null) {
            if (1 == RGViewController.getInstance().getOrientation()) {
                this.mCurOrientation = 1;
            } else {
                this.mCurOrientation = 2;
            }
            this.mRLMASwitch = (RelativeLayout) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_rl_main_auxiliary_switch);
            this.mIVMASwitch = (ImageView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_iv_main_auxiliary_switch);
            this.mTVMASwitch = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_tv_main_auxiliary_switch);
            this.mRLBridgeSwitch = (RelativeLayout) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_rl_bridge_switch);
            this.mIVBridgeSwitch = (ImageView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_iv_bridge_switch);
            this.mTVBridgeSwitch = (TextView) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_tv_bridge_switch);
            this.mMainRoadViewLinear = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_rl_main_auxiliary_switch2);
            this.mBridgeRoadLinear = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_rl_bridge_switch2);
        }
    }

    public void updateMainAuxiliaryBridgeView(int type) {
        LogUtil.m15791e(TAG, "peng updateMABView type = " + type);
        this.mCurrentType = type;
        switch (type) {
            case 0:
                hide();
                this.isBothShow = false;
                return;
            case 1:
                hide();
                showMainRoad();
                this.isBothShow = false;
                return;
            case 2:
                hide();
                showAuxiliaryRoad();
                this.isBothShow = false;
                return;
            case 4:
                hide();
                showOnBridge();
                this.isBothShow = false;
                return;
            case 5:
                hide();
                showOnBridge();
                showMainRoad();
                this.isBothShow = true;
                return;
            case 6:
                hide();
                showOnBridge();
                showAuxiliaryRoad();
                this.isBothShow = true;
                return;
            case 8:
                hide();
                showUnderBridge();
                this.isBothShow = false;
                return;
            case 10:
                hide();
                showUnderBridge();
                showAuxiliaryRoad();
                this.isBothShow = true;
                return;
            default:
                hide();
                this.isBothShow = false;
                LogUtil.m15791e(TAG, "peng enter default hide");
                return;
        }
    }

    public void onOrientationChange(int type) {
        hide();
        updateMainAuxiliaryBridgeView(type);
    }

    public void show() {
        hide();
        super.show();
        showMASwitch(true);
        showBridgeSwitch(true);
    }

    public void hide() {
        super.hide();
        showMASwitch(false);
        showBridgeSwitch(false);
    }

    private void showMainRoad() {
        UserOPController.getInstance().add(UserOPParams.GUIDE_3_v_1, "1", null, null);
        if (this.mTVMASwitch != null) {
            this.mTVMASwitch.setText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_in_main_road));
        }
        if (this.mIVMASwitch != null) {
            this.mIVMASwitch.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_switch_main_road));
        }
        showMASwitch(true);
    }

    private void showAuxiliaryRoad() {
        UserOPController.getInstance().add(UserOPParams.GUIDE_3_v_2, "1", null, null);
        if (this.mTVMASwitch != null) {
            this.mTVMASwitch.setText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_in_auxiliary_road));
        }
        if (this.mIVMASwitch != null) {
            this.mIVMASwitch.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_switch_auxiliary_road));
        }
        showMASwitch(true);
    }

    private void showOnBridge() {
        UserOPController.getInstance().add(UserOPParams.GUIDE_3_v_3, "1", null, null);
        if (this.mTVBridgeSwitch != null) {
            this.mTVBridgeSwitch.setText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_on_bridge));
        }
        if (this.mIVBridgeSwitch != null) {
            this.mIVBridgeSwitch.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_switch_on_bridge));
        }
        showBridgeSwitch(true);
    }

    private void showUnderBridge() {
        UserOPController.getInstance().add(UserOPParams.GUIDE_3_v_4, "1", null, null);
        if (this.mTVBridgeSwitch != null) {
            this.mTVBridgeSwitch.setText(BNStyleManager.getString(C4048R.string.nsdk_string_rg_under_bridge));
        }
        if (this.mIVBridgeSwitch != null) {
            this.mIVBridgeSwitch.setImageDrawable(BNStyleManager.getDrawable(C4048R.drawable.nsdk_drawable_switch_under_bridge));
        }
        showBridgeSwitch(true);
    }

    private int getClickedTypeByShowType(int showType, int viewId) {
        int clickedType = -1;
        if (viewId == this.mRLMASwitch.getId()) {
            switch (showType) {
                case 5:
                    clickedType = 1;
                    break;
                case 6:
                    clickedType = 2;
                    break;
                case 10:
                    clickedType = 2;
                    break;
            }
        }
        if (viewId != this.mRLBridgeSwitch.getId()) {
            return clickedType;
        }
        switch (showType) {
            case 5:
                return 4;
            case 6:
                return 4;
            case 10:
                return 8;
            default:
                return clickedType;
        }
    }

    public void dispose() {
        super.dispose();
        hide();
        this.isBothShow = false;
        this.mCurrentType = -1;
        resetBtnClicked();
    }

    private void showMASwitch(boolean show) {
        if (this.mRLMASwitch != null) {
            this.mRLMASwitch.setVisibility(show ? 0 : 8);
        }
    }

    private void showBridgeSwitch(boolean show) {
        if (this.mRLBridgeSwitch != null) {
            this.mRLBridgeSwitch.setVisibility(show ? 0 : 8);
        }
    }
}
