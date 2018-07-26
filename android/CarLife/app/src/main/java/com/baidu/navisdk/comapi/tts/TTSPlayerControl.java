package com.baidu.navisdk.comapi.tts;

import com.baidu.mobstat.Config;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener.AudioPlayerListener;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.debug.SDKDebugFileUtil.CoreLogModule;
import com.baidu.navisdk.jni.nativeif.JNIStatisticsControl;
import com.baidu.navisdk.module.business.BusinessActivityPlayerManager;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SoundUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TTSPlayerControl {
    public static final int PER_TTS_DEFAULT_SPEED = 5;
    private static final String TTS_RES_FAIL = "Fail";
    private static final String TTS_RES_SUCCESS = "Success";
    private static boolean bStopVoiceOutput = false;
    private static SoundUtils mFastRouteSound = null;
    private static boolean mIsFellowSpeaking = false;
    private static boolean mIsTTSPlaying = false;
    private static ArrayList<OnTTSPlayStateListener> mOnTTSStateListenerList = new ArrayList();
    private static IBNTTSPlayerListener mTtsPlayerListener;
    private static LinkedList<String> stasStrTagList = null;

    public interface OnTTSPlayStateListener {
        void onPlayEnd();

        void onPlayStart();
    }

    public static void init() {
        if (mTtsPlayerListener != null) {
            mTtsPlayerListener.initTTSPlayer();
        }
        initFastRouteVoice();
    }

    private static void initFastRouteVoice() {
        mFastRouteSound = new SoundUtils(C4048R.raw.fast_route_ding);
    }

    public static void playFastRouteVoice() {
        LogUtil.m15791e("TTS", "TTSPlayerControl.playTTSText() play .");
        if (mFastRouteSound != null) {
            mFastRouteSound.play();
        }
    }

    public static void setFellowSpeakStatus(boolean isSpeaking) {
        mIsFellowSpeaking = isSpeaking;
    }

    public static boolean getFellowSpeakStatus() {
        return mIsFellowSpeaking;
    }

    public static void addTTSPlayStateListener(OnTTSPlayStateListener listener) {
        if (mOnTTSStateListenerList != null) {
            mOnTTSStateListenerList.add(listener);
        }
    }

    public static void removeTTSPlayStateListener(OnTTSPlayStateListener listener) {
        if (mOnTTSStateListenerList != null && listener != null) {
            mOnTTSStateListenerList.remove(listener);
        }
    }

    public static ArrayList<OnTTSPlayStateListener> getTTSPlayStateListener() {
        return mOnTTSStateListenerList;
    }

    public static boolean getTTSPlayStatus() {
        return mIsTTSPlaying;
    }

    public static boolean getMapTTSPlayStatus() {
        if (getTTSState() == 2) {
            return true;
        }
        return false;
    }

    public static void unInit() {
        if (mFastRouteSound != null) {
            mFastRouteSound.release();
        }
        if (mTtsPlayerListener != null) {
            mTtsPlayerListener.releaseTTSPlayer();
        }
    }

    public static void stopSound() {
        if (mFastRouteSound != null) {
            mFastRouteSound.stop();
        }
    }

    public static void setTTSPlayerListener(IBNTTSPlayerListener listener) {
        mTtsPlayerListener = listener;
    }

    public static void stopVoiceTTSOutput() {
        LogUtil.m15791e("TTSPlayerControl", "stopVoiceTTSOutput()");
        if (getTTSState() == 2 && mTtsPlayerListener != null) {
            mTtsPlayerListener.stopTTS();
        }
    }

    public static void pauseVoiceTTSOutput() {
        bStopVoiceOutput = true;
        if (mTtsPlayerListener != null) {
            mTtsPlayerListener.pauseTTS();
        }
    }

    public static void resumeVoiceTTSOutput() {
        bStopVoiceOutput = false;
        if (mTtsPlayerListener != null) {
            mTtsPlayerListener.resumeTTS();
        }
    }

    public static void setPhoneIn(boolean bCalling) {
        if (mTtsPlayerListener == null) {
            return;
        }
        if (bCalling) {
            mTtsPlayerListener.phoneCalling();
        } else {
            mTtsPlayerListener.phoneHangUp();
        }
    }

    public static int getTTSState() {
        if (mTtsPlayerListener == null) {
            return 1;
        }
        int originState = mTtsPlayerListener.getTTSState();
        LogUtil.m15791e("TTS", "getTTSState =  " + originState);
        return originState;
    }

    public static int playTTS(String speech, int bPreempt) {
        LogUtil.m15791e("TTS", "playTTSText from SDK. speech=" + speech + ", bPreempt=" + bPreempt + ", bStopVoiceOutput=" + bStopVoiceOutput + ", mTtsPlayerListener=" + mTtsPlayerListener);
        return commonPlayTTS(speech, null, bPreempt);
    }

    public static int playTTSText(String speech, int bPreempt) {
        LogUtil.m15791e("TTS", "playTTSText from JNI. speech=" + speech + ", bPreempt=" + bPreempt + ", bStopVoiceOutput=" + bStopVoiceOutput + ", mTtsPlayerListener=" + mTtsPlayerListener);
        return commonPlayTTS(speech, null, bPreempt);
    }

    public static int playTTSText(String speech, String pStrTag, int bPreempt) {
        LogUtil.m15791e("TTS", "playTTSText from JNI. speech=" + speech + ", bPreempt=" + bPreempt + ", bStopVoiceOutput=" + bStopVoiceOutput + ", mTtsPlayerListener=" + mTtsPlayerListener);
        return commonPlayTTS(speech, pStrTag, bPreempt);
    }

    private static int commonPlayTTS(String speech, String pStrTag, int bPreempt) {
        if (LogUtil.LOGGABLE) {
            LogUtil.m15791e("TTS", "TTSPlayerControl.playTTSText(). speech=" + speech + ", bPreempt=" + bPreempt + ", bStopVoiceOutput=" + bStopVoiceOutput + ", mTtsPlayerListener=" + mTtsPlayerListener + ",pStrTag" + pStrTag);
        }
        LogUtil.m15791e("TTS", "TTSPlayerControl.playTTSText(). speech=" + speech + ", bPreempt=" + bPreempt + ", bStopVoiceOutput=" + bStopVoiceOutput + ", mTtsPlayerListener=" + mTtsPlayerListener + ",pStrTag" + pStrTag);
        if (pStrTag != null && pStrTag.equals("")) {
            LogUtil.m15791e("playTTSText", "pStrTag is null");
        }
        if (!(pStrTag == null || pStrTag.equals(""))) {
            if (stasStrTagList == null) {
                stasStrTagList = new LinkedList();
            }
            stasStrTagList.add(pStrTag);
        }
        BusinessActivityPlayerManager.getInstance().cancelPlayAudio();
        RGSimpleGuideModel.getInstance().updateTTSText(speech);
        if (!bStopVoiceOutput && mTtsPlayerListener != null) {
            return mTtsPlayerListener.playTTSText(speech, pStrTag, bPreempt);
        }
        LogUtil.m15791e("playTTSText", "bStopVoiceOutput = " + bStopVoiceOutput + ",mTtsPlayerListener = " + mTtsPlayerListener);
        SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, "TTSPlayerControl end. speech=" + speech + ", bPreempt=" + bPreempt + ", bStopVoiceOutput=" + bStopVoiceOutput + ", mTtsPlayerListener=" + mTtsPlayerListener + ",pStrTag" + pStrTag);
        return 0;
    }

    public static int playXDTTSText(String speech, int bPreempt) {
        if (LogUtil.LOGGABLE) {
            LogUtil.m15791e("TTS", "TTSPlayerControl.playXDTTSText() from jni. speech=" + speech + ", bPreempt=" + bPreempt + ", bStopVoiceOutput=" + bStopVoiceOutput + ", mTtsPlayerListener=" + mTtsPlayerListener + ",pStrTagnull");
        }
        BusinessActivityPlayerManager.getInstance().cancelPlayAudio();
        RGSimpleGuideModel.getInstance().updateTTSText(speech);
        if (!bStopVoiceOutput && mTtsPlayerListener != null) {
            return mTtsPlayerListener.playXDTTSText(speech, null, bPreempt);
        }
        LogUtil.m15791e("playXDTTSText", "bStopVoiceOutput = " + bStopVoiceOutput + ",mTtsPlayerListener = " + mTtsPlayerListener);
        SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, "TTSPlayerControl end. speech=" + speech + ", bPreempt=" + bPreempt + ", bStopVoiceOutput=" + bStopVoiceOutput + ", mTtsPlayerListener=" + mTtsPlayerListener + ",pStrTagnull");
        return 0;
    }

    public static void setTTSTextPlayResult(String pStrTag) {
        if (LogUtil.LOGGABLE) {
            LogUtil.m15791e("setTTSTextPlayResult:", "pStrTag" + pStrTag);
            if (stasStrTagList != null) {
                Iterator it = stasStrTagList.iterator();
                while (it.hasNext()) {
                    LogUtil.m15791e("stasStrTagList:", (String) it.next());
                }
            }
        }
        if (stasStrTagList != null && pStrTag != null && !pStrTag.equals("")) {
            int index = stasStrTagList.indexOf(pStrTag);
            if (index >= 0 && index < stasStrTagList.size()) {
                for (int i = 0; i < index; i++) {
                    String pStrTagTemp = (String) stasStrTagList.remove();
                    if (pStrTagTemp != null) {
                        LogUtil.m15791e("setTTSTextPlayResult result:", pStrTagTemp + Config.TRACE_TODAY_VISIT_SPLIT + TTS_RES_FAIL);
                        JNIStatisticsControl.sInstance.setTTSTextPlayResult(pStrTagTemp, TTS_RES_FAIL);
                    }
                }
                stasStrTagList.remove();
                LogUtil.m15791e("setTTSTextPlayResult result:", pStrTag + Config.TRACE_TODAY_VISIT_SPLIT + TTS_RES_SUCCESS);
                JNIStatisticsControl.sInstance.setTTSTextPlayResult(pStrTag, TTS_RES_SUCCESS);
            }
        }
    }

    public static void clearTagList() {
        if (stasStrTagList != null) {
            stasStrTagList.clear();
        }
    }

    public static int playAudio(String audioPath, AudioPlayerListener lis) {
        if (mTtsPlayerListener != null) {
            return mTtsPlayerListener.playAudio(audioPath, lis);
        }
        return -1;
    }

    public static int cancelAudio() {
        if (getTTSState() != 2 || mTtsPlayerListener == null) {
            return -1;
        }
        return mTtsPlayerListener.cancelAudio();
    }

    public static void setNaviMuteState(boolean isNaviMute) {
        if (mTtsPlayerListener != null) {
            mTtsPlayerListener.setNaviMuteState(isNaviMute);
        }
    }

    public static boolean isNaviMuteState() {
        if (mTtsPlayerListener != null) {
            return mTtsPlayerListener.isNaviMuteState();
        }
        return false;
    }
}
