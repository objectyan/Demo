package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.module.offscreen.BNOffScreenManager;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.model.RGOffScreenModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.jar.JarUtils;

public class RGMMOffScreenView extends BNBaseView {
    private View bgView;
    private View dividerView;
    private Handler mHandler = null;
    private TextView mOffScreenCancelView = null;
    private ViewGroup mOffScreenContainer = null;
    private TextView mOffScreenGuideTipView = null;
    private TextView mOffScreenTipView = null;
    private View mOffScreenView = null;

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOffScreenView$1 */
    class C44021 implements OnClickListener {
        C44021() {
        }

        public void onClick(View v) {
            RGMMOffScreenView.this.clearMessage();
            RGMMOffScreenView.this.mHandler = null;
            RGOffScreenModel.getInstance().isInCounting = false;
            BNOffScreenManager.getInstance().offScreenAction();
            RGViewController.getInstance().requestShowExpendView(1, false);
            BNOffScreenManager.getInstance().isEnterOffScreen = true;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMOffScreenView$2 */
    class C44032 implements OnClickListener {
        C44032() {
        }

        public void onClick(View v) {
            RGMMOffScreenView.this.clearMessage();
            RGMMOffScreenView.this.mHandler = null;
            BNOffScreenManager.sIsBrightOffEffect = false;
            BNOffScreenManager.testPrint(BNOffScreenManager.MODULE_NAME, "click canele");
            BNOffScreenManager.test();
            RGOffScreenModel.getInstance().isInCounting = false;
            RGViewController.getInstance().requestShowExpendView(1, false);
        }
    }

    public RGMMOffScreenView(Context c, ViewGroup p, OnRGSubViewListener lis) {
        super(c, p, lis);
        initView();
        updateStyle(BNStyleManager.getDayStyle());
        initListener();
        createHandler();
    }

    private void initView() {
        if (this.mRootViewGroup != null) {
            this.mOffScreenContainer = (ViewGroup) this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_off_screen_container);
            if (this.mOffScreenContainer != null) {
                this.mOffScreenContainer.removeAllViews();
                this.mOffScreenView = JarUtils.inflate((Activity) this.mContext, C4048R.layout.nsdk_layout_rg_off_screen_view, null);
                if (this.mOffScreenContainer != null && this.mOffScreenView != null) {
                    this.mOffScreenContainer.addView(this.mOffScreenView, new LayoutParams(-1, -1));
                    this.bgView = this.mRootViewGroup.findViewById(C4048R.id.ll_off_screen_item);
                    this.dividerView = this.mRootViewGroup.findViewById(C4048R.id.bnav_rg_common_divider_off_screen);
                    this.mOffScreenTipView = (TextView) this.mRootViewGroup.findViewById(C4048R.id.nsdk_rg_off_screen_tip_tx);
                    this.mOffScreenGuideTipView = (TextView) this.mRootViewGroup.findViewById(C4048R.id.nsdk_rg_off_screen_enter_tx);
                    this.mOffScreenCancelView = (TextView) this.mRootViewGroup.findViewById(C4048R.id.nsdk_rg_off_screen_cancel);
                }
            }
        }
    }

    private void clearMessage() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(2);
            this.mHandler.removeMessages(1);
        }
    }

    private void initListener() {
        if (this.mOffScreenGuideTipView != null) {
            this.mOffScreenGuideTipView.setOnClickListener(new C44021());
        }
        if (this.mOffScreenCancelView != null) {
            this.mOffScreenCancelView.setOnClickListener(new C44032());
        }
    }

    private void createHandler() {
        this.mHandler = null;
        this.mHandler = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:
                        if (RGOffScreenModel.getInstance().mOffScreenCount <= 0) {
                            if (RGMMOffScreenView.this.mHandler != null) {
                                RGMMOffScreenView.this.mHandler.sendEmptyMessage(2);
                                return;
                            }
                            return;
                        } else if (RGMMOffScreenView.this.mHandler != null) {
                            RGMMOffScreenView.this.mHandler.sendEmptyMessageDelayed(1, 1000);
                            RGOffScreenModel instance = RGOffScreenModel.getInstance();
                            instance.mOffScreenCount--;
                            return;
                        } else {
                            return;
                        }
                    case 2:
                        if (BNOffScreenManager.sIsInOffScreenMode) {
                            BNOffScreenManager.testPrint(BNOffScreenManager.MODULE_NAME, "MSG_STOP_COUNT, return not legal");
                            return;
                        }
                        BNOffScreenManager.sIsBrightOffEffect = false;
                        BNOffScreenManager.testPrint(BNOffScreenManager.MODULE_NAME, "MSG_STOP_COUNT");
                        RGOffScreenModel.getInstance().isInCounting = false;
                        RGViewController.getInstance().requestShowExpendView(1, false);
                        return;
                    case 3:
                        RGOffScreenModel.getInstance().isInCounting = false;
                        return;
                    default:
                        return;
                }
            }
        };
    }

    public void show() {
        if (RGOffScreenModel.getInstance().isCurrentLocationActive) {
            BNOffScreenManager.testPrint(BNOffScreenManager.MODULE_NAME, " rgmmoffscreen view show");
            super.show();
            if (this.mOffScreenContainer != null) {
                this.mOffScreenContainer.setVisibility(0);
            }
            if (this.mOffScreenView != null) {
                this.mOffScreenView.setVisibility(0);
            }
            startCountDown();
        }
    }

    public void hide() {
        super.hide();
        if (this.mOffScreenView != null) {
            this.mOffScreenContainer.setVisibility(8);
            this.mOffScreenView.setVisibility(8);
        }
    }

    public boolean isVisible() {
        if (this.mOffScreenContainer == null || this.mOffScreenContainer.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void forceShow() {
        BNOffScreenManager.testPrint(BNOffScreenManager.MODULE_NAME, "force show");
        if (this.mOffScreenContainer != null) {
            this.mOffScreenContainer.setVisibility(0);
        }
        if (this.mOffScreenView != null) {
            this.mOffScreenView.setVisibility(0);
        }
    }

    private void startCountDown() {
        if (RGOffScreenModel.getInstance().isCurrentLocationActive) {
            RGOffScreenModel.getInstance().isCurrentLocationActive = false;
            if (!RGOffScreenModel.getInstance().isInCounting) {
                cancelCountDown();
                RGOffScreenModel.getInstance().mOffScreenCount = 5;
                createHandler();
                BNOffScreenManager.testPrint(BNOffScreenManager.MODULE_NAME, "start count down");
                RGOffScreenModel.getInstance().isInCounting = true;
                this.mHandler.sendEmptyMessage(1);
            }
        }
    }

    private void cancelCountDown() {
        if (this.mHandler != null) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(2);
        }
    }

    public void updateStyle(boolean day) {
        super.updateStyle(day);
        if (this.bgView != null) {
            this.bgView.setBackgroundColor(BNStyleManager.getColor(C4048R.color.cl_bg_d));
        }
        if (this.dividerView != null) {
            this.dividerView.setBackgroundColor(BNStyleManager.getColor(C4048R.color.cl_bg_b));
        }
        if (this.mOffScreenTipView != null) {
            this.mOffScreenTipView.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_a));
        }
        if (this.mOffScreenGuideTipView != null) {
            this.mOffScreenGuideTipView.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_e));
            this.mOffScreenGuideTipView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_common_button_selector));
        }
        if (this.mOffScreenCancelView != null) {
            this.mOffScreenCancelView.setTextColor(BNStyleManager.getColor(C4048R.color.cl_text_a));
            this.mOffScreenCancelView.setBackgroundDrawable(BNStyleManager.getDrawable(C4048R.drawable.bnav_lineframe_button_selector));
        }
    }

    public void cleanHandler() {
        cancelCountDown();
        this.mHandler = null;
    }
}
