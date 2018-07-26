package com.baidu.navisdk.ui.routeguide.asr.xdvoice;

import android.util.SparseArray;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.module.business.BusinessActivityPlayerManager;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.asr.Utils;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructionParams.RoundInstructType;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructionResponse.RetState;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.executor.InstructionExecutor;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class XDVoiceInstructManager {
    private static XDVoiceInstructManager INSTANCE;
    private static String TAG = ModuleName.XDVoice;
    public static boolean XD_ROUSED = false;
    private SparseArray<InstructionExecutor> mInstructionExecutors = new SparseArray();
    public XDVoiceInstructionResponse mLastResponse;
    private XDVoiceTTSListener mXDTTSListener = null;
    private XDVoiceCallback mXDVoiceCallback;

    public static XDVoiceInstructManager getInstance() {
        if (INSTANCE == null) {
            synchronized (XDVoiceInstructManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new XDVoiceInstructManager();
                }
            }
        }
        return INSTANCE;
    }

    private XDVoiceInstructManager() {
    }

    public void setXDVoiceListener(XDVoiceTTSListener xdListener) {
        this.mXDTTSListener = xdListener;
    }

    public void registXDVoicePanelCallback(XDVoiceCallback callback) {
        LogUtil.m15791e(TAG, "registXDVoicePanelCallback() - callback > " + callback);
        this.mXDVoiceCallback = callback;
    }

    public void executInstruction(String instructionType) {
        XDVoiceInstructionRequest xdVoiceInstructionRequest = new XDVoiceInstructionRequest(instructionType);
        InstructionExecutor instructionExecutor = (InstructionExecutor) this.mInstructionExecutors.get(xdVoiceInstructionRequest.topType);
        if (instructionExecutor == null) {
            instructionExecutor = XDVoiceInstructionFactory.createInstructExecutor(xdVoiceInstructionRequest.topType);
            this.mInstructionExecutors.append(xdVoiceInstructionRequest.topType, instructionExecutor);
        }
        if (this.mXDTTSListener != null && instructionExecutor != null) {
            instructionExecutor.execute(xdVoiceInstructionRequest.subAction, this.mXDTTSListener);
        }
    }

    public boolean onStart() {
        if (Utils.checkAuthrity("android.permission.RECORD_AUDIO")) {
            if (!(XD_ROUSED || this.mXDTTSListener == null)) {
                LogUtil.m15791e(TAG, "onStart()");
                TTSPlayerControl.stopVoiceTTSOutput();
                BNavigator.getInstance().onXDVoiceStart();
                BusinessActivityPlayerManager.getInstance().cancelPlayAudio();
                XD_ROUSED = true;
            }
            return XD_ROUSED;
        }
        LogUtil.m15791e(TAG, "onStart() -- not RECORD_AUDIO_AUTH permission");
        return false;
    }

    public void onStop() {
        if (XD_ROUSED) {
            LogUtil.m15791e(TAG, "onStop()");
            XD_ROUSED = false;
            this.mInstructionExecutors.clear();
        }
    }

    public void release() {
        this.mXDTTSListener = null;
        this.mXDVoiceCallback = null;
        onStop();
    }

    public void setPhoneIn(boolean bCalling) {
        if (this.mXDVoiceCallback != null) {
            LogUtil.m15791e(TAG, "setPhoneIn > " + bCalling);
            if (bCalling) {
                this.mXDVoiceCallback.closePanel();
                this.mXDVoiceCallback.xdWakeEnable(false);
                return;
            }
            this.mXDVoiceCallback.xdWakeEnable(true);
        }
    }

    public void setWakeupEnable(boolean enable) {
        if (this.mXDVoiceCallback != null) {
            this.mXDVoiceCallback.xdWakeEnable(enable);
        }
    }

    public void closePanel() {
        if (this.mXDVoiceCallback != null) {
            this.mXDVoiceCallback.closePanel();
        }
    }

    public void setXDPlan(int windowOrientation, int width) {
        if (this.mXDVoiceCallback != null) {
            this.mXDVoiceCallback.voiceEnable(windowOrientation, width);
        }
    }

    public boolean xdIsWakeUpOn() {
        if (this.mXDVoiceCallback != null) {
            return this.mXDVoiceCallback.xdIsWakeUpOn();
        }
        return false;
    }

    public void askRouteRecommend(String tips) {
        LogUtil.m15791e(TAG, "askRouteRecommend() - tips: " + tips);
        if (!StringUtils.isEmpty(tips)) {
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_c_b);
            UserOPController.getInstance().add("aj");
            XDVoiceInstructionResponse response = new XDVoiceInstructionResponse(RetState.SUCCESS, Utils.getPushCommandSpeech(RoundInstructType.ROUTE_RECOMMEND, tips));
            response.setHasRound2(true);
            response.setErrorContent(JarUtils.getResources().getString(C4048R.string.nsdk_string_route_asr_fail));
            response.setRoundValue(RoundInstructType.ROUTE_RECOMMEND);
            this.mLastResponse = response;
            if (this.mXDTTSListener != null) {
                this.mXDTTSListener.onResponse(response);
            }
        }
    }

    public void askNaviToPark(String tips, GeoPoint park) {
        XDVoiceInstructionResponse response = new XDVoiceInstructionResponse(RetState.SUCCESS, Utils.getPushCommandSpeech(RoundInstructType.DEST_PARK, tips));
        response.setHasRound2(true);
        response.setRoundValue(RoundInstructType.DEST_PARK);
        response.setExtra(park);
        this.mLastResponse = response;
        if (this.mXDTTSListener != null) {
            this.mXDTTSListener.onResponse(response);
        }
    }

    public void startAsr() {
        if (this.mXDVoiceCallback != null) {
            this.mXDVoiceCallback.startAsr();
        }
    }

    public void cancelAsr() {
        if (this.mXDVoiceCallback != null) {
            this.mXDVoiceCallback.cancelAsr();
        }
    }

    public void resetLastInstrut() {
        BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new BNWorkerNormalTask<String, String>(getClass().getSimpleName() + " - resetLastInstrut", null) {
            protected String execute() {
                LogUtil.m15791e(XDVoiceInstructManager.TAG, "resetLastInstrut!");
                if (XDVoiceInstructManager.getInstance().mLastResponse != null) {
                    XDVoiceInstructManager.getInstance().mLastResponse = null;
                    XDVoiceInstructManager.this.cancelAsr();
                }
                return null;
            }
        }, new BNWorkerConfig(8, 0), 300);
    }
}
