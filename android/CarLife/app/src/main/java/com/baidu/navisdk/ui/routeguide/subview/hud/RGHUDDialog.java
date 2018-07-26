package com.baidu.navisdk.ui.routeguide.subview.hud;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.baidu.mobstat.Config;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.navisdk.ui.routeguide.fsm.RGFSMTable.FsmEvent;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.subview.util.RGAnimUtil;
import com.baidu.navisdk.ui.routeguide.subview.util.RGAnimUtil.IAnimationLister;
import com.baidu.navisdk.ui.widget.BNVolumeKeyDownDialog;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import java.lang.ref.WeakReference;

public class RGHUDDialog extends BNVolumeKeyDownDialog implements OnClickListener {
    private static final int HUD_MODEL_MIRROR = 1;
    private static final int HUD_MODEL_NOT_MIRROR = 3;
    private AnimationListener animListener;
    private boolean isAnimShowing = false;
    private Activity mActivity;
    private TextView mHudBack;
    private TextView mHudBtn;
    private TextView mHudDirection;
    private TextView mHudMirror;
    private RGHUDView mHudView;
    private boolean mIsMirror = false;
    private TextView mMapBack;
    private FadeHandler mPopupFader = null;

    /* renamed from: com.baidu.navisdk.ui.routeguide.subview.hud.RGHUDDialog$1 */
    class C44581 implements OnTouchListener {
        C44581() {
        }

        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() != 0 || RGHUDDialog.this.mIsMirror) {
                if (event.getAction() == 0 && RGHUDDialog.this.mIsMirror) {
                    if (RGHUDDialog.this.isAnimShowing) {
                        return true;
                    }
                    if (RGHUDDialog.this.mHudBack.getVisibility() == 0) {
                        RGHUDDialog.this.hideMirrorBackBtn();
                    } else {
                        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.HUD_TAP_SHOW, NaviStatConstants.HUD_TAP_SHOW);
                        RGHUDDialog.this.showMirrorBackBtn();
                        RGHUDDialog.this.mPopupFader.sendEmptyMessage(1);
                    }
                }
                return false;
            } else if (RGHUDDialog.this.isAnimShowing) {
                return true;
            } else {
                if (RGHUDDialog.this.mHudBtn.getVisibility() == 0) {
                    RGHUDDialog.this.hideBtns();
                    return true;
                }
                BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.HUD_TAP_SHOW, NaviStatConstants.HUD_TAP_SHOW);
                RGHUDDialog.this.showBtns();
                RGHUDDialog.this.mPopupFader.sendEmptyMessage(3);
                return true;
            }
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.subview.hud.RGHUDDialog$2 */
    class C44592 implements AnimationListener {
        C44592() {
        }

        public void onAnimationStart(Animation animation) {
            RGHUDDialog.this.isAnimShowing = true;
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            RGHUDDialog.this.isAnimShowing = false;
        }
    }

    /* renamed from: com.baidu.navisdk.ui.routeguide.subview.hud.RGHUDDialog$3 */
    class C44603 implements IAnimationLister {
        C44603() {
        }

        public void onEnd2() {
            RGHUDDialog.this.onBackPressed();
        }

        public void onEnd1() {
        }
    }

    private static class FadeHandler extends Handler {
        private final BNWorkerNormalTask<String, String> mFadeTask = new BNWorkerNormalTask<String, String>("FadeTask", null) {
            protected String execute() {
                RGHUDDialog outter = (RGHUDDialog) FadeHandler.this.outterCxt.get();
                if (outter != null) {
                    if (FadeHandler.this.mHudState == 1) {
                        outter.hideMirrorBackBtn();
                    } else {
                        outter.hideBtns();
                    }
                }
                return null;
            }
        };
        private int mHudState;
        private WeakReference<RGHUDDialog> outterCxt;

        public FadeHandler(RGHUDDialog widget) {
            this.outterCxt = new WeakReference(widget);
        }

        public void handleMessage(Message msg) {
            if (((RGHUDDialog) this.outterCxt.get()) != null) {
                this.mHudState = msg.what;
                BNWorkerCenter.getInstance().cancelTask(this.mFadeTask, false);
                BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mFadeTask, new BNWorkerConfig(2, 0), Config.BPLUS_DELAY_TIME);
            }
        }
    }

    private void initView() {
        setContentView(JarUtils.inflate(this.mActivity, C4048R.layout.nsdk_layout_rg_hud_dialog, null));
        this.mHudView = (RGHUDView) findViewById(C4048R.id.bnav_rg_hud_dialog_main);
        this.mHudBtn = (TextView) findViewById(C4048R.id.bnav_rg_btn_hud);
        this.mHudMirror = (TextView) findViewById(C4048R.id.bnav_rg_btn_hud_mirror);
        this.mHudBack = (TextView) findViewById(C4048R.id.bnav_rg_btn_hud_mirror_back);
        this.mMapBack = (TextView) findViewById(C4048R.id.bnav_rg_btn_hud_back);
        this.mHudMirror.setOnClickListener(this);
        this.mHudBack.setOnClickListener(this);
        this.mMapBack.setOnClickListener(this);
        this.mHudBtn.setOnClickListener(this);
        this.mHudView.setOnTouchListener(new C44581());
    }

    public void onOrientationChanged() {
        if (this.mHudView != null) {
            this.mHudView.onOrientationChanged();
        }
    }

    private void showBtns() {
        Animation showAni = JarUtils.loadAnimation(BNaviModuleManager.getContext(), C4048R.anim.nsdk_anim_fade_in);
        showAni.setAnimationListener(this.animListener);
        this.mHudBtn.setAnimation(showAni);
        this.mMapBack.setAnimation(showAni);
        this.mHudBtn.setVisibility(0);
        this.mMapBack.setVisibility(0);
        this.mMapBack.setClickable(true);
        this.mHudBtn.setClickable(true);
    }

    private void hideBtns() {
        Animation hideAni = JarUtils.loadAnimation(BNaviModuleManager.getContext(), C4048R.anim.nsdk_anim_fade_out);
        hideAni.setAnimationListener(this.animListener);
        this.mHudBtn.setAnimation(hideAni);
        this.mMapBack.setAnimation(hideAni);
        this.mHudBtn.setVisibility(4);
        this.mMapBack.setVisibility(4);
        this.mMapBack.setClickable(false);
        this.mHudBtn.setClickable(false);
    }

    private void showMirrorBackBtn() {
        this.mHudMirror.setVisibility(0);
        this.mHudMirror.setClickable(true);
        this.mHudBack.setVisibility(0);
        this.mHudBack.setClickable(true);
    }

    private void hideMirrorBackBtn() {
        this.mHudMirror.setVisibility(8);
        this.mHudMirror.setClickable(false);
        this.mHudBack.setVisibility(8);
        this.mHudBack.setClickable(false);
    }

    public RGHUDDialog(Activity activity, int theme, boolean isMirror) {
        super(activity, theme);
        this.mActivity = activity;
        requestWindowFeature(1);
        initView();
        this.mPopupFader = new FadeHandler(this);
        this.animListener = new C44592();
        setIsMirror(isMirror);
    }

    public void setMirrorFlagBeforeShow(boolean isMirror) {
        this.mIsMirror = isMirror;
    }

    public void show() {
        super.show();
        setIsMirror(this.mIsMirror);
        if (this.mIsMirror) {
            this.mPopupFader.sendEmptyMessage(1);
        } else {
            this.mPopupFader.sendEmptyMessage(3);
        }
        onOrientationChanged();
    }

    public void setDirection(String direction) {
        this.mHudView.setDirection(direction);
    }

    public void setRemainDistance(String distance) {
    }

    public void setNormalGoMeters(String distance) {
        this.mHudView.setNormalGoMeters(distance);
    }

    public void setRoadName(String name) {
        this.mHudView.setNormalCurrentRoad(name);
    }

    public void setTurnIcon(int resId) {
        this.mHudView.setNormalTurnIcon(resId);
    }

    public void setDirectRemainDistance(String distance) {
        this.mHudView.setDirectDistance(distance);
    }

    public void setDirectRoadName(String name) {
        this.mHudView.setDirectCurrentRoad(name);
    }

    public void setHighWayExitRoad(String roads) {
        this.mHudView.setHighWayExitRoad(roads);
    }

    public void setHighWayExitCode(String exitCode) {
        this.mHudView.setHighWayExitCode(exitCode);
    }

    public void setHighWayRemainDistance(String distance) {
        this.mHudView.setHighWayRemainDistance(distance);
    }

    public void setHighWayTurnIcon(int resId) {
        this.mHudView.setHighWayTurnIcon(resId);
    }

    public void justSetNormalRoadInfoVisibility(boolean show) {
        this.mHudView.updateNormalRoadInfoVisibility(show);
    }

    public void justSetDirectRoadInfoVisibility(boolean show) {
        this.mHudView.updateDirectRoadInfoVisibility(show);
    }

    public void justSetHighWayVisibility(boolean show) {
        this.mHudView.updateHighWayVisibility(show);
    }

    public void updateHighWayAlongVisibility(boolean show) {
        this.mHudView.updateHighWayAlongVisibility(show);
    }

    public void lostGPSSignal() {
        this.mHudView.lostGPSSignal();
    }

    public void gpsSignalRecover() {
        this.mHudView.gpsSignalRecover();
    }

    private void setIsMirror(boolean isMirror) {
        if (isMirror) {
            this.mHudView.setMirror(true);
            this.mHudView.invalidate();
            hideBtns();
            showMirrorBackBtn();
            return;
        }
        this.mHudView.setMirror(false);
        this.mHudView.invalidate();
        showBtns();
        hideMirrorBackBtn();
    }

    public void updateHudYaw(boolean isYaw) {
        this.mHudView.updateHudYaw(isYaw);
    }

    public void updateHudLocate(boolean isLocating) {
        this.mHudView.updateHudView(isLocating);
    }

    public void updateTotalRemainInfo() {
        this.mHudView.updateTotalRemainInfo();
    }

    public void updateCurrentCarSpeed() {
        this.mHudView.updateCurrentCarSpeed();
    }

    public void onClick(View v) {
        if (v.getId() == C4048R.id.bnav_rg_btn_hud_back) {
            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.HUD_BACKTOMAPNAVIGATION, NaviStatConstants.HUD_BACKTOMAPNAVIGATION);
            RouteGuideFSM.getInstance().run(FsmEvent.BTN_CLICK_BACK);
            Bundle nextInfo = RGSimpleGuideModel.getInstance().getNextGuideInfo();
            if (nextInfo == null || nextInfo.getInt("resid", 0) > 0) {
                RGAnimUtil.setAnimationListener(new C44603());
            } else {
                RGAnimUtil.setAnimationListener(new C44603());
            }
        } else if (v.getId() == C4048R.id.bnav_rg_btn_hud) {
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_8_1);
            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.HUD_DURATION_HUD, NaviStatConstants.HUD_DURATION_HUD);
            RouteGuideFSM.getInstance().run(FsmEvent.MSG_HUD_GOTO_MIRROR);
        } else if (v.getId() == C4048R.id.bnav_rg_btn_hud_mirror) {
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_8_1);
            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.HUD_DURATION_HUD, NaviStatConstants.HUD_DURATION_HUD);
            RouteGuideFSM.getInstance().run(FsmEvent.MSG_MIRROR_GOTO_HUD);
        } else if (v.getId() == C4048R.id.bnav_rg_btn_hud_mirror_back && this.mIsMirror) {
            BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), NaviStatConstants.HUD_BACKTOMAPNAVIGATION, NaviStatConstants.HUD_BACKTOMAPNAVIGATION);
            RouteGuideFSM.getInstance().run(FsmEvent.BTN_CLICK_BACK);
        }
    }

    public void onBackPressed() {
        dismiss();
        RouteGuideFSM.getInstance().run(FsmEvent.BTN_CLICK_BACK);
        super.onBackPressed();
    }
}
