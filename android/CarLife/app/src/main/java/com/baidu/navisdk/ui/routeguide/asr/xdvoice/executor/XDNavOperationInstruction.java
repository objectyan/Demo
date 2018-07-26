package com.baidu.navisdk.ui.routeguide.asr.xdvoice.executor;

import android.content.Context;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructionParams.VoiceContent;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructionParams.VoiceInstructionType;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructionResponse;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructionResponse.RetState;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceTTSListener;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;

public class XDNavOperationInstruction extends InstructionExecutorAbs {
    private String TAG = ModuleName.XDVoice;
    private XDVoiceTTSListener mXdListener;

    public void execute(String subType, XDVoiceTTSListener xdListener) {
        this.mXdListener = xdListener;
        if (VoiceInstructionType.EXIT_NAVIGATION.equals(subType)) {
            exitNav();
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_c_6);
        } else if (VoiceInstructionType.CHANGE_FASTER_ROUTE.equals(subType)) {
            changeFasterRoute();
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_c_g);
        } else if (VoiceInstructionType.AVOID_CONGESTION.equals(subType)) {
            avoidCongestion();
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_c_5);
        }
    }

    private void avoidCongestion() {
        if (BNavigator.getInstance().getContext() != null && NetworkUtils.isNetworkAvailable(BNavigator.getInstance().getContext()) && BNRouteGuider.getInstance().isCurDriveRouteOnline()) {
            LogUtil.m15791e(this.TAG, "excute - avoidCongestion()");
            refreshRoute(25);
            return;
        }
        LogUtil.m15791e(this.TAG, "avoidCongestion() -- offlineMode -- retuen");
        if (this.mXdListener != null) {
            this.mXdListener.onResponse(new XDVoiceInstructionResponse(RetState.SUCCESS, BNStyleManager.getString(C4048R.string.nsdk_string_rg_avoid_traffic_no_route)));
        }
    }

    private void changeFasterRoute() {
        if (BNavigator.getInstance().getContext() != null && NetworkUtils.isNetworkAvailable(BNavigator.getInstance().getContext()) && BNRouteGuider.getInstance().isCurDriveRouteOnline()) {
            LogUtil.m15791e(this.TAG, "excute - changeFasterRoute()");
            refreshRoute(26);
            return;
        }
        if (this.mXdListener != null) {
            this.mXdListener.onResponse(new XDVoiceInstructionResponse(RetState.SUCCESS, BNStyleManager.getString(C4048R.string.nsdk_string_rg_avoid_traffic_no_route)));
        }
        LogUtil.m15791e(this.TAG, "changeFasterRoute() -- offlineMode -- retuen");
    }

    private void refreshRoute(int comeFrom) {
        Context context = BNavigator.getInstance().getContext();
        if (context == null) {
            LogUtil.m15791e(this.TAG, "refreshRoute --> BNavigator.getInstance().getContext() == null!!");
        } else if (NetworkUtils.isNetworkAvailable(context)) {
            RGMapModeViewController.getInstance().showRefreshRoadProgess();
            BNRouteGuider.getInstance().calcOtherRoute("", 1, comeFrom);
        } else {
            LogUtil.m15791e(this.TAG, "excute refreshRoute() - not Network!  retuen");
            TipTool.onCreateToastDialog(context, JarUtils.getResources().getString(C4048R.string.nsdk_string_rg_avoid_traffic_network_failture));
        }
    }

    private void exitNav() {
        if (this.mXdListener != null) {
            this.mXdListener.onResponse(new XDVoiceInstructionResponse(RetState.SUCCESS, VoiceContent.ExitNav));
        }
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>("exitNav-" + getClass().getSimpleName(), null) {
            protected String execute() {
                BNavigator.getInstance().asrQuitNavi();
                return null;
            }
        }, new BNWorkerConfig(2, 0), 1500);
    }
}
