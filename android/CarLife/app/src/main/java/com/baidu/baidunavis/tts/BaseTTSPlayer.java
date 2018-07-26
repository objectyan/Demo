package com.baidu.baidunavis.tts;

import android.content.Context;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.wrapper.LogUtil;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.p052m.C1915a.C0917b;
import com.baidu.mapframework.nirvana.looper.MainLooperHandler;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.mapframework.tts.OnTTSStateChangedListener;
import com.baidu.navi.cruise.control.EnterQuitLogicManager;
import com.baidu.navisdk.CommonParams.Const.ModuleName;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener.AudioPlayerListener;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl.OnTTSPlayStateListener;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.debug.SDKDebugFileUtil.CoreLogModule;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.platform.p206a.C4747b;
import com.baidu.tts.client.SpeechSynthesizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class BaseTTSPlayer {
    private static final String CRUISERVOICEPREFIX = "嗒嗒嗒";
    private static final String DINGVOICEBUFFER = "叮";
    private static final String HIGHTWAYVOICEPREFIX = "嘀嘀嘀";
    public static final int MSG_REINIT_TTS = 6;
    public static final int MSG_RELOAD_SO = 5;
    public static final int PLAYER_STATE_ERROR = 4;
    public static final int PLAYER_STATE_IDLE = 1;
    public static final int PLAYER_STATE_NOT_INIT = 0;
    public static final int PLAYER_STATE_PAUSE = 3;
    public static final int PLAYER_STATE_PLAYING = 2;
    private static final int RELOAD_MAX_TIME = 5;
    private static final int SO_LOAD_MAX_TIME = 2;
    private static final String TAG = "TTS-BaseTTSPlayer";
    private static boolean bStopVoiceOutput = false;
    private static SoundUtils mCruiserPassSound = null;
    private static SoundUtils mDingSound = null;
    private static SoundUtils mHighwayDididiSound = null;
    private static BaseTTSPlayer mInstance;
    private static boolean sIsTTSSoLoadSuccess = false;
    private static int sReloadCnt = 0;
    private OnTTSStateChangedListener mBNTTSPlayerStatusChanged;
    private ConditionVariable mCV = new ConditionVariable();
    private Handler mHandler;
    private C0917b mIBNTTSBtStatusInterface;
    private IBNTTSVoiceHintListener mIBNTTSVoiceHintListener;
    private IBNTTSPlayerPCMListener mIBNttsPlayerPCMListener;
    private Handler mInitHandler = new MainLooperHandler(Module.NAV_MODULE, ScheduleConfig.forData()) {
        public void onMessage(Message msg) {
            switch (msg.what) {
                case 5:
                    try {
                        if (C4747b.a().a("BDSpeechDecoder_V1") && C4747b.a().a("bd_etts") && C4747b.a().a("bdtts")) {
                            BaseTTSPlayer.sIsTTSSoLoadSuccess = true;
                            if (BaseTTSPlayer.this.mInitHandler.hasMessages(5)) {
                                BaseTTSPlayer.this.mInitHandler.removeMessages(5);
                            }
                            BaseTTSPlayer.this.mInitHandler.sendEmptyMessage(6);
                            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BaseTTSPlayer mInitHandler MSG_RELOAD_SO sIsTTSSoLoadSuccess : " + BaseTTSPlayer.sIsTTSSoLoadSuccess + ", sReloadCnt: " + BaseTTSPlayer.sReloadCnt);
                            return;
                        }
                        BaseTTSPlayer.sIsTTSSoLoadSuccess = false;
                        BaseTTSPlayer.access$208();
                        SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BaseTTSPlayer mInitHandler MSG_RELOAD_SO sIsTTSSoLoadSuccess : " + BaseTTSPlayer.sIsTTSSoLoadSuccess + ", sReloadCnt: " + BaseTTSPlayer.sReloadCnt);
                        return;
                    } catch (Throwable th) {
                        BaseTTSPlayer.sIsTTSSoLoadSuccess = false;
                        BaseTTSPlayer.access$208();
                    }
                    break;
                case 6:
                    BaiduNaviManager.getInstance().initTTSModule(NavMapAdapter.getInstance().getJNIInitializerContext());
                    if (BaseTTSPlayer.this.mInitHandler.hasMessages(6)) {
                        BaseTTSPlayer.this.mInitHandler.removeMessages(6);
                    }
                    BaseTTSPlayer.access$208();
                    SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BaseTTSPlayer mInitHandler MSG_REINIT_TTS : , sReloadCnt: " + BaseTTSPlayer.sReloadCnt);
                    return;
                default:
                    return;
            }
        }
    };
    public boolean mIsCarlifeConnected = false;
    private boolean mIsUseBt = false;
    private OnTTSStateChangedListener mTTSListener = new C08712();
    private BdTTSPlayer mTTSPlayer = null;
    private HandlerThread mTTSPlayerThread;
    private List<OnTTSStateChangedListener> mTTSStateChangedListenerList = Collections.synchronizedList(new ArrayList());
    private int mTmpTTSState = -99;
    private boolean needSwitch = false;

    /* renamed from: com.baidu.baidunavis.tts.BaseTTSPlayer$2 */
    class C08712 implements OnTTSStateChangedListener {
        C08712() {
        }

        public void onPlayEnd() {
            if (BaseTTSPlayer.this.mBNTTSPlayerStatusChanged != null) {
                BaseTTSPlayer.this.mBNTTSPlayerStatusChanged.onPlayEnd();
            }
            for (int index = BaseTTSPlayer.this.mTTSStateChangedListenerList.size() - 1; index >= 0; index--) {
                try {
                    OnTTSStateChangedListener playEndlistener = (OnTTSStateChangedListener) BaseTTSPlayer.this.mTTSStateChangedListenerList.get(index);
                    if (playEndlistener != null) {
                        playEndlistener.onPlayEnd();
                    }
                } catch (Exception e) {
                    LogUtil.m3004e(BaseTTSPlayer.TAG, "onPlayEnd Exception:" + e.getMessage());
                }
            }
            ArrayList<OnTTSPlayStateListener> naviSDKTTSStateListenerList = TTSPlayerControl.getTTSPlayStateListener();
            ArrayList<OnTTSPlayStateListener> tmpListenerList = new ArrayList();
            if (naviSDKTTSStateListenerList != null && naviSDKTTSStateListenerList.size() > 0) {
                tmpListenerList.addAll(naviSDKTTSStateListenerList);
                Iterator it = tmpListenerList.iterator();
                while (it.hasNext()) {
                    ((OnTTSPlayStateListener) it.next()).onPlayEnd();
                }
            }
            Context ctx = NavCommonFuncModel.getInstance().getContext();
            if (ctx != null) {
                AudioUtils.releaseAudioFocus(ctx);
            }
        }

        public void onPlayStart() {
            if (BaseTTSPlayer.this.mBNTTSPlayerStatusChanged != null) {
                BaseTTSPlayer.this.mBNTTSPlayerStatusChanged.onPlayStart();
            }
            for (int index = BaseTTSPlayer.this.mTTSStateChangedListenerList.size() - 1; index >= 0; index--) {
                try {
                    OnTTSStateChangedListener playStartlistener = (OnTTSStateChangedListener) BaseTTSPlayer.this.mTTSStateChangedListenerList.get(index);
                    if (playStartlistener != null) {
                        playStartlistener.onPlayStart();
                    }
                } catch (Exception e) {
                    LogUtil.m3004e(BaseTTSPlayer.TAG, "onPlayStart Exception:" + e.getMessage());
                }
            }
            ArrayList<OnTTSPlayStateListener> naviSDKTTSStateListenerList = TTSPlayerControl.getTTSPlayStateListener();
            ArrayList<OnTTSPlayStateListener> tmpListenerList = new ArrayList();
            if (naviSDKTTSStateListenerList != null && naviSDKTTSStateListenerList.size() > 0) {
                tmpListenerList.addAll(naviSDKTTSStateListenerList);
                Iterator it = tmpListenerList.iterator();
                while (it.hasNext()) {
                    ((OnTTSPlayStateListener) it.next()).onPlayStart();
                }
            }
            Context ctx = NavCommonFuncModel.getInstance().getContext();
            if (ctx != null) {
                AudioUtils.requestAudioFocus(ctx);
            }
        }

        public void onPlayError(int code, String message) {
            if (BaseTTSPlayer.this.mBNTTSPlayerStatusChanged != null) {
                BaseTTSPlayer.this.mBNTTSPlayerStatusChanged.onPlayError(code, message);
            }
            for (int index = BaseTTSPlayer.this.mTTSStateChangedListenerList.size() - 1; index >= 0; index--) {
                try {
                    OnTTSStateChangedListener playErrorlistener = (OnTTSStateChangedListener) BaseTTSPlayer.this.mTTSStateChangedListenerList.get(index);
                    if (playErrorlistener != null) {
                        playErrorlistener.onPlayError(code, message);
                    }
                } catch (Exception e) {
                    LogUtil.m3004e(BaseTTSPlayer.TAG, "onPlayError Exception:" + e.getMessage());
                }
            }
        }
    }

    /* renamed from: com.baidu.baidunavis.tts.BaseTTSPlayer$3 */
    class C08723 implements Runnable {
        C08723() {
        }

        public void run() {
            if (BaseTTSPlayer.this.mTTSPlayer != null) {
                BaseTTSPlayer.this.mTmpTTSState = BaseTTSPlayer.this.mTTSPlayer.getTTSState();
                com.baidu.navisdk.util.common.LogUtil.e(BaseTTSPlayer.TAG, "BaseTTSPlayer getTTSState in Handler -->mTmpTTSState = " + BaseTTSPlayer.this.mTmpTTSState);
            }
            BaseTTSPlayer.this.mCV.open();
        }
    }

    static /* synthetic */ int access$208() {
        int i = sReloadCnt;
        sReloadCnt = i + 1;
        return i;
    }

    public static void loadTTSSO() {
        LogUtil.m3004e("test", "loadSO!!!!!");
        int i = 0;
        while (i < 2) {
            try {
                if (C4747b.a().a("BDSpeechDecoder_V1") && C4747b.a().a("bd_etts") && C4747b.a().a("bdtts")) {
                    sIsTTSSoLoadSuccess = true;
                    return;
                }
                sIsTTSSoLoadSuccess = false;
                UserOPController.getInstance().add(UserOPParams.EXCEPTION_7_2, "2", null, null);
                i++;
            } catch (Throwable th) {
                sIsTTSSoLoadSuccess = false;
                UserOPController.getInstance().add(UserOPParams.EXCEPTION_7_2, "2", null, null);
            }
        }
    }

    public static BaseTTSPlayer getInstance() {
        if (mInstance == null) {
            synchronized (BaseTTSPlayer.class) {
                if (mInstance == null) {
                    mInstance = new BaseTTSPlayer();
                }
            }
        }
        return mInstance;
    }

    public static boolean isTTSSoLoadSuccess() {
        return sIsTTSSoLoadSuccess;
    }

    public static void destory() {
        if (mInstance != null && isTTSSoLoadSuccess()) {
            synchronized (BaseTTSPlayer.class) {
                if (mInstance != null) {
                    mInstance.dispose();
                }
            }
        }
        mInstance = null;
    }

    private void dispose() {
        if (isTTSSoLoadSuccess()) {
            if (mDingSound != null) {
                mDingSound.release();
            }
            if (mHighwayDididiSound != null) {
                mHighwayDididiSound.release();
            }
            if (mCruiserPassSound != null) {
                mCruiserPassSound.release();
            }
            if (this.mTTSPlayer != null) {
                this.mTTSPlayer.releaseTTSPlayer();
            }
        }
    }

    public void stopSound() {
        if (mDingSound != null) {
            mDingSound.stop();
        }
        if (mHighwayDididiSound != null) {
            mHighwayDididiSound.stop();
        }
        if (mCruiserPassSound != null) {
            mCruiserPassSound.stop();
        }
    }

    public void initPlayer(Context context, String sdcardAPPPath) {
        try {
            BNSettingManager.init(context);
        } catch (Exception e) {
        }
        if (context != null) {
            try {
                if (isTTSSoLoadSuccess() && sdcardAPPPath != null && sdcardAPPPath.length() > 0 && getInitState() == 0) {
                    mDingSound = new SoundUtils(C0965R.raw.ding);
                    mHighwayDididiSound = new SoundUtils(C0965R.raw.dididi);
                    mCruiserPassSound = new SoundUtils(C0965R.raw.cruiser_pass);
                    if (this.mTTSPlayer == null && getInitState() == 0) {
                        this.mTTSPlayer = new BdTTSPlayer();
                        this.mTTSPlayerThread = new HandlerThread("BNTTSPlayer");
                        this.mTTSPlayerThread.start();
                        this.mHandler = new Handler(this.mTTSPlayerThread.getLooper());
                        this.mTTSPlayer.initPlayer(context, sdcardAPPPath);
                        this.mTTSPlayer.setOnTTSStateChangedListener(this.mTTSListener);
                        this.mTTSPlayer.setIBNTTSPlayerPCMListener(this.mIBNttsPlayerPCMListener);
                        this.mTTSPlayer.setIBNTTSVoiceHintListener(this.mIBNTTSVoiceHintListener);
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    public void setCurrentSelectPath(String path) {
        if (this.mTTSPlayer != null) {
            this.mTTSPlayer.setCurrentSelectPath(path);
        }
    }

    public String getLastTTSVoiceDataPath() {
        if (this.mTTSPlayer != null) {
            return this.mTTSPlayer.getLastTTSVoiceDataPath();
        }
        return BdTTSPlayer.K_TTS_DATA_FILE;
    }

    public int getInitState() {
        if (this.mTTSPlayer == null) {
            return 0;
        }
        return this.mTTSPlayer.getInitState();
    }

    public void setOnTTSStateChangedListener(OnTTSStateChangedListener listener) {
        this.mBNTTSPlayerStatusChanged = listener;
    }

    public void addOnTTSStateChangedListener(OnTTSStateChangedListener listener) {
        if (!this.mTTSStateChangedListenerList.contains(listener)) {
            this.mTTSStateChangedListenerList.add(listener);
        }
    }

    public void removeOnTTSStateChangedListener(OnTTSStateChangedListener listener) {
        if (this.mTTSStateChangedListenerList.contains(listener)) {
            this.mTTSStateChangedListenerList.remove(listener);
        }
    }

    public boolean setTTSVoiceDataPath(String newTTSPath) {
        if (isTTSSoLoadSuccess() && this.mTTSPlayer != null) {
            return this.mTTSPlayer.setTTSVoiceDataPath(newTTSPath);
        }
        return false;
    }

    public boolean switchTTSVoiceData(String newTTSPath, OnTTSVoiceDataSwitchListener lis) {
        if (isTTSSoLoadSuccess() && this.mTTSPlayer != null) {
            return this.mTTSPlayer.switchTTSVoiceDataAsync(newTTSPath, null, true, lis);
        }
        return false;
    }

    public boolean switchTTSVoiceDataSync(String newTTSPath, String textPath, boolean saveConfig) {
        if (isTTSSoLoadSuccess() && this.mTTSPlayer != null) {
            return this.mTTSPlayer.switchTTSVoiceDataSync(newTTSPath, textPath, saveConfig);
        }
        return false;
    }

    public boolean recoveryToNavVoice() {
        if (isTTSSoLoadSuccess() && this.mTTSPlayer != null) {
            return this.mTTSPlayer.recoveryToNavVoice();
        }
        return false;
    }

    public boolean loadCustomTTSVoiceData(String newTTSPath, OnTTSVoiceDataSwitchListener lis) {
        if (isTTSSoLoadSuccess() && this.mTTSPlayer != null) {
            return this.mTTSPlayer.loadCustomTTSVoice(newTTSPath, lis);
        }
        return false;
    }

    public boolean freeCustomTTSVoiceData(String newTTSPath, OnTTSVoiceDataSwitchListener lis) {
        if (isTTSSoLoadSuccess() && this.mTTSPlayer != null) {
            return this.mTTSPlayer.freeCustomTTSVoice(newTTSPath, lis);
        }
        return false;
    }

    public boolean setCustomParams(boolean custom) {
        if (isTTSSoLoadSuccess() && this.mTTSPlayer != null) {
            return this.mTTSPlayer.setCustomParams(custom);
        }
        return false;
    }

    public boolean getTTSVoiceDataCustom() {
        if (isTTSSoLoadSuccess() && this.mTTSPlayer != null) {
            return this.mTTSPlayer.getTTSVoiceDataCustom();
        }
        return false;
    }

    public String getCustomVoiceDataPath() {
        if (!isTTSSoLoadSuccess()) {
            return "";
        }
        if (this.mTTSPlayer == null) {
            return "";
        }
        return this.mTTSPlayer.getCustomVoiceDataPath();
    }

    public boolean loadCustomResource(String path) {
        if (!isTTSSoLoadSuccess() || path == null || this.mTTSPlayer == null) {
            return false;
        }
        return this.mTTSPlayer.loadCustomResource(path);
    }

    public String getCurrentTTSVoiceDataPath() {
        if (this.mTTSPlayer != null) {
            return this.mTTSPlayer.getCurrentTTSVoiceDataPath();
        }
        return null;
    }

    public void changeTTSPlayerVolume(boolean isMax) {
    }

    public synchronized int getTTSState() {
        boolean z = true;
        int i = 0;
        synchronized (this) {
            if (!isTTSSoLoadSuccess()) {
                SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BaseTTSPlayer getTTSState !isTTSSoLoadSuccess(): " + (!isTTSSoLoadSuccess()));
                String str = TAG;
                StringBuilder append = new StringBuilder().append(" BaseTTSPlayer getTTSState !isTTSSoLoadSuccess(): ");
                if (isTTSSoLoadSuccess()) {
                    z = false;
                }
                com.baidu.navisdk.util.common.LogUtil.e(str, append.append(z).toString());
            } else if (this.mTTSPlayer == null || this.mHandler == null) {
                SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BaseTTSPlayer getTTSState mTTSPlayer: " + this.mTTSPlayer + " mHandler: " + this.mHandler);
                com.baidu.navisdk.util.common.LogUtil.e(TAG, "BaseTTSPlayer getTTSState mTTSPlayer: " + this.mTTSPlayer + " mHandler: " + this.mHandler);
            } else {
                this.mTmpTTSState = -99;
                this.mHandler.post(new C08723());
                this.mCV.block(1000);
                this.mCV.close();
                com.baidu.navisdk.util.common.LogUtil.e(TAG, "BaseTTSPlayer mCV.close() --> mTmpTTSState = " + this.mTmpTTSState);
                if (this.mTmpTTSState != -99) {
                    i = this.mTmpTTSState;
                }
            }
        }
        return i;
    }

    public int playTTSText(String speech, boolean bPreempt) {
        return playTTSText(speech, null, bPreempt);
    }

    public int playTTSText(String speech, final String pStrTag, final boolean bPreempt) {
        if ((BNSettingManager.getVoiceMode() == 2 && BNavigator.getInstance().isNaviBegin()) || this.mTTSPlayer == null || this.mTTSPlayer.isNaviMute()) {
            NavLogUtils.m3003e("BaseTTSPlayer", "voice mode is Quite, return");
            com.baidu.navisdk.util.common.LogUtil.e(TAG, "voice mode is Quite, return");
            return 0;
        } else if (!checkTTSInitStatu()) {
            return 0;
        } else {
            speech = EnterQuitLogicManager.getmInstance().cruiseEnterPromptTransfer(speech);
            switchTTSVolume();
            if (this.mTTSPlayer == null || this.mTTSPlayer.getVoiceState() || this.mTTSPlayer.isNaviMute()) {
                return 0;
            }
            if (speech == null || speech.length() == 0) {
                SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BaseTTSPlayer playTTSText speech == null || speech.length() == 0");
                com.baidu.navisdk.util.common.LogUtil.e(TAG, " BaseTTSPlayer playTTSText speech == null || speech.length() == 0");
                return 0;
            } else if (bStopVoiceOutput) {
                SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BaseTTSPlayer playTTSText bStopVoiceOutput " + bStopVoiceOutput);
                com.baidu.navisdk.util.common.LogUtil.e(TAG, " BaseTTSPlayer playTTSText bStopVoiceOutput " + bStopVoiceOutput);
                return 0;
            } else if (speech.startsWith(DINGVOICEBUFFER)) {
                if (mDingSound != null) {
                    mDingSound.play();
                }
                return 1;
            } else if (speech.startsWith(CRUISERVOICEPREFIX)) {
                if (mCruiserPassSound != null) {
                    mCruiserPassSound.play();
                }
                com.baidu.navisdk.util.common.LogUtil.e(TAG, "speech.startsWith(CRUISERVOICEPREFIX)");
                return 1;
            } else {
                if (speech.startsWith(HIGHTWAYVOICEPREFIX)) {
                    if (mHighwayDididiSound != null) {
                        mHighwayDididiSound.play();
                    }
                    speech = speech.substring(HIGHTWAYVOICEPREFIX.length());
                }
                if (this.mTTSPlayer == null || this.mHandler == null) {
                    SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BaseTTSPlayer playTTSText mTTSPlayer == null || mHandler == null");
                    com.baidu.navisdk.util.common.LogUtil.e(TAG, " BaseTTSPlayer playTTSText mTTSPlayer == null || mHandler == null");
                    return 0;
                }
                final String tmpSpeech = speech;
                this.mHandler.postDelayed(new Runnable() {
                    public void run() {
                        NavLogUtils.m3003e(ModuleName.XDVoice, "playTTSText > " + tmpSpeech);
                        BaseTTSPlayer.this.mTTSPlayer.playTTSText(tmpSpeech, pStrTag, bPreempt ? 1 : 0);
                    }
                }, 200);
                return 1;
            }
        }
    }

    public void setPlayModeAsync() {
    }

    public void setPlayModeSync() {
    }

    public void stopTTS() {
        if (getTTSState() == 2 && isTTSSoLoadSuccess() && this.mTTSPlayer != null) {
            this.mTTSPlayer.stopTTS();
        }
    }

    public void releaseTTSPlayer() {
        bStopVoiceOutput = false;
        if (isTTSSoLoadSuccess() && this.mTTSPlayer != null) {
            this.mTTSPlayer.releaseTTSPlayer();
        }
    }

    public int pauseTTS() {
        bStopVoiceOutput = true;
        if (!isTTSSoLoadSuccess() || this.mTTSPlayer == null) {
            return -1;
        }
        return this.mTTSPlayer.pauseTTS();
    }

    public int resumeTTS() {
        bStopVoiceOutput = false;
        if (!isTTSSoLoadSuccess() || this.mTTSPlayer == null) {
            return -1;
        }
        return this.mTTSPlayer.resumeTTS();
    }

    public void setEnableTimeOut(boolean enable) {
        if (this.mTTSPlayer != null) {
            this.mTTSPlayer.setEnableTimeOut(enable);
        }
    }

    public void setPhoneIn(boolean bCalling) {
        if (this.mTTSPlayer != null) {
            this.mTTSPlayer.setPhoneIn(bCalling);
        }
    }

    public int setPlaySpeed(int speed) {
        if (this.mTTSPlayer != null) {
            return this.mTTSPlayer.setPlaySpeed(speed);
        }
        return -1;
    }

    public int getCurrentVolume() {
        if (this.mTTSPlayer != null) {
            return this.mTTSPlayer.getCurrentVolume();
        }
        return 1;
    }

    public void setCurrentVolume(int volume) {
        if (this.mTTSPlayer != null) {
            if (volume > 15) {
                volume = 15;
            }
            if (volume < 0) {
                volume = 0;
            }
            LogUtil.m3004e("navSDK", "setCurrentVolume = " + volume);
            this.mTTSPlayer.setCurrentVolume(volume);
        }
    }

    public boolean isJinshaTTS() {
        if (this.mTTSPlayer == null) {
            return false;
        }
        return this.mTTSPlayer.isJinshaTTS();
    }

    public int playAudio(String audioPath, AudioPlayerListener lis) {
        if (this.mTTSPlayer == null) {
            return -1;
        }
        return this.mTTSPlayer.playAudio(audioPath, lis);
    }

    public int cancelAudio() {
        if (this.mTTSPlayer == null) {
            return -1;
        }
        return this.mTTSPlayer.cancelAudio();
    }

    public void setTTSStreamType(int streamType) {
        if (this.mTTSPlayer != null) {
            this.mTTSPlayer.setTTSStreamType(streamType);
        }
    }

    public void setTTSVocoderParam() {
        SpeechSynthesizer.getInstance().setParam(SpeechSynthesizer.PARAM_VOCODER_OPTIM_LEVEL, BNSettingManager.getTTSVocoderParam());
    }

    public int getCurrentProgress() {
        if (this.mTTSPlayer != null) {
            return this.mTTSPlayer.getCurrentProgress();
        }
        return -1;
    }

    public boolean canSwitchVoice() {
        if (isTTSSoLoadSuccess() && this.mTTSPlayer != null) {
            return this.mTTSPlayer.canSwitchVoice();
        }
        return false;
    }

    public void setCarLifeConnected(boolean isCarlifeConnected) {
        this.mIsCarlifeConnected = isCarlifeConnected;
        if (this.mIBNTTSBtStatusInterface != null) {
            this.mIsUseBt = this.mIBNTTSBtStatusInterface.mo1338a();
        }
        if (!this.mIsCarlifeConnected || this.mIsUseBt) {
            setStereoVolume(1.0f, 1.0f);
        } else {
            setStereoVolume(0.0f, 0.0f);
        }
    }

    public void switchTTSVolume() {
        if (!(this.mIBNTTSBtStatusInterface == null || this.mIBNTTSBtStatusInterface.mo1338a() == this.mIsUseBt)) {
            this.mIsUseBt = this.mIBNTTSBtStatusInterface.mo1338a();
            this.needSwitch = true;
        }
        if (this.needSwitch) {
            if (!this.mIsCarlifeConnected || this.mIsUseBt) {
                setStereoVolume(1.0f, 1.0f);
            } else {
                setStereoVolume(0.0f, 0.0f);
            }
            this.needSwitch = false;
        }
    }

    public void setIBNTTSBtStatusInterface(C0917b listener) {
        this.mIBNTTSBtStatusInterface = listener;
    }

    public void setIBNTTSPlayerPCMListener(IBNTTSPlayerPCMListener listener) {
        this.mIBNttsPlayerPCMListener = listener;
        if (this.mTTSPlayer != null) {
            this.mTTSPlayer.setIBNTTSPlayerPCMListener(listener);
        }
    }

    public IBNTTSPlayerPCMListener getIBNttsPlayerPCMListener() {
        return this.mIBNttsPlayerPCMListener;
    }

    public void setIBNTTSVoiceHintListener(IBNTTSVoiceHintListener listener) {
        this.mIBNTTSVoiceHintListener = listener;
        if (this.mTTSPlayer != null) {
            this.mTTSPlayer.setIBNTTSVoiceHintListener(listener);
        }
    }

    public void setBNTTSPlayerStatusChangedWeChat(IBNTTSPlayerWeChatListener listener) {
        if (this.mTTSPlayer != null) {
            this.mTTSPlayer.setBNTTSPlayerStatusChangedWeChat(listener);
        }
    }

    public int playVoiceTTSText(String speech, int bPreempt) {
        if (checkTTSInitStatu()) {
            switchTTSVolume();
            if (speech == null || speech.length() == 0) {
                SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BaseTTSPlayer playTTSText speech == null || speech.length() == 0");
                return 0;
            } else if (bStopVoiceOutput) {
                SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BaseTTSPlayer playTTSText bStopVoiceOutput " + bStopVoiceOutput);
                return 0;
            } else if (this.mTTSPlayer == null || this.mHandler == null) {
                SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BaseTTSPlayer playTTSText mTTSPlayer == null || mHandler == null");
                return 0;
            } else {
                return this.mTTSPlayer.playVoiceTTSText(speech, bPreempt);
            }
        }
        LogUtil.m3004e("test", "TTS init error !!!!!");
        return 0;
    }

    public int playWeChatTTSText(String speech, int bPreempt) {
        if (!checkTTSInitStatu()) {
            return 0;
        }
        switchTTSVolume();
        if (this.mTTSPlayer == null || this.mTTSPlayer.getVoiceState()) {
            return 0;
        }
        if (speech == null || speech.length() == 0) {
            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BaseTTSPlayer playTTSText speech == null || speech.length() == 0");
            return 0;
        } else if (bStopVoiceOutput) {
            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BaseTTSPlayer playTTSText bStopVoiceOutput " + bStopVoiceOutput);
            return 0;
        } else if (this.mTTSPlayer == null || this.mHandler == null) {
            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BaseTTSPlayer playTTSText mTTSPlayer == null || mHandler == null");
            return 0;
        } else {
            return this.mTTSPlayer.playWeChatTTSText(speech, bPreempt);
        }
    }

    public void stopTTSWX() {
        if (getTTSState() == 2 && isTTSSoLoadSuccess() && this.mTTSPlayer != null) {
            this.mTTSPlayer.stopTTSWX();
        }
    }

    public void stopTTSVR() {
        if (getTTSState() == 2 && isTTSSoLoadSuccess() && this.mTTSPlayer != null) {
            this.mTTSPlayer.stopTTSVR();
        }
    }

    public void setVoiceState(boolean bVoice) {
        if (this.mTTSPlayer != null) {
            this.mTTSPlayer.setVoiceState(bVoice);
        }
    }

    public boolean getVoiceState() {
        if (this.mTTSPlayer != null) {
            return this.mTTSPlayer.getVoiceState();
        }
        return false;
    }

    public void setNaviMuteState(boolean isNaviMute) {
        if (this.mTTSPlayer != null) {
            this.mTTSPlayer.setNaviMute(isNaviMute);
        }
    }

    public boolean isNaviMuteState() {
        return this.mTTSPlayer != null ? this.mTTSPlayer.isNaviMute() : false;
    }

    public int setStereoVolume(float leftVolume, float rightVolume) {
        if (this.mTTSPlayer == null) {
            return 0;
        }
        return this.mTTSPlayer.setStereoVolume(leftVolume, rightVolume);
    }

    private boolean checkTTSInitStatu() {
        boolean z = true;
        if (!isTTSSoLoadSuccess()) {
            SDKDebugFileUtil instance = SDKDebugFileUtil.getInstance();
            String str = CoreLogModule.CoreLog_TTS;
            StringBuilder append = new StringBuilder().append(" BaseTTSPlayer playTTSText !isTTSSoLoadSuccess(): ");
            if (isTTSSoLoadSuccess()) {
                z = false;
            }
            instance.addCoreLog(str, append.append(z).append(", sReloadCnt: ").append(sReloadCnt).toString());
            if (sReloadCnt >= 5) {
                return false;
            }
            this.mInitHandler.sendEmptyMessage(5);
            return false;
        } else if (!isTTSSoLoadSuccess() || getInitState() != 0) {
            return true;
        } else {
            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BaseTTSPlayer playTTSText getInitState() == BdTTSPlayer.INIT_STATE_NO , sReloadCnt: " + sReloadCnt);
            if (sReloadCnt >= 5) {
                return false;
            }
            this.mInitHandler.sendEmptyMessage(6);
            return false;
        }
    }
}
