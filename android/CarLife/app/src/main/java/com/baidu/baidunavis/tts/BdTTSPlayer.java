package com.baidu.baidunavis.tts;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.control.NavLogUtils;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.stat.NavUserBehaviourDef;
import com.baidu.baidunavis.ui.widget.NavTipTool;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.util.C2198u;
import com.baidu.che.codriver.sdk.p081a.C2578b;
import com.baidu.mapframework.common.util.StorageSettings;
import com.baidu.mapframework.nirvana.assets.AssetsManager;
import com.baidu.mapframework.nirvana.assets.AssetsTask;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.DataTaskType;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.mapframework.nirvana.schedule.ScheduleTag;
import com.baidu.mapframework.tts.OnTTSStateChangedListener;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.IBNTTSPlayerListener.AudioPlayerListener;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.debug.SDKDebugFileUtil;
import com.baidu.navisdk.debug.SDKDebugFileUtil.CoreLogModule;
import com.baidu.navisdk.module.offscreen.BNOffScreenParams;
import com.baidu.navisdk.ui.voice.BNVoiceParams;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.loop.BNMainLooperHandler;
import com.baidu.platform.comapi.C2907c;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.SpeechError;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.SpeechSynthesizerListener;
import com.baidu.tts.client.SynthesizerTool;
import com.baidu.tts.client.TtsMode;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class BdTTSPlayer {
    private static final int DEFAULT_SPEED_5 = 5;
    private static final int DEFAULT_SPEED_6 = 6;
    private static final int DEFAULT_SPEED_7 = 7;
    public static final int INIT_STATE_INITING = 1;
    public static final int INIT_STATE_NO = 0;
    public static final int INIT_STATE_OK = 2;
    public static final String K_TTS_DATA_FILE = "bd_etts_common_speech_f7_mand_eng_high_am-mix_v3.0.0_20170512.dat";
    public static final String K_TTS_DATA_TAIWAN_FILE = "bd_etts_common_speech_taiwan_mand_eng_high_am-mgc_v3.0.0_20170807.dat";
    private static final String K_TTS_LICENCE_FILE = "baidu_tts_licence.dat";
    private static final String K_TTS_ROBIN_FILE = "1-00001.dat";
    private static final String K_TTS_TEXT_DATA_FILE = "bd_etts_common_text_txt_all_mand_eng_middle_mix_v3.1.0_20170525.dat";
    private static final int MAX_SPEED = 9;
    private static final int MIN_SPEED = 0;
    private static final int MSG_FREE_CUSTOM_TTS_VOICE = 6;
    private static final int MSG_INIT_FAILED = 4;
    private static final int MSG_INIT_FINISHED = 2;
    private static final int MSG_LOAD_CUSTOM_TTS_VOICE = 7;
    private static final int MSG_REQUEST_INIT = 1;
    private static final int MSG_REQUEST_SWITCH_VOICE_DATA = 3;
    private static final int MSG_RESET_TTS_FOR_TIMEOUT = 5;
    private static final String OLD_MAP_MENGMENGDA_PATH = "/BaiduCarlife/tts/";
    private static final String TAG = "BdTTSPlayer";
    private boolean isNeedSaveConfig = true;
    private boolean isTimeOutEnable = false;
    private Context mContext;
    private int mCurrentProgress = 0;
    private String mCurrentSelectPath = K_TTS_DATA_FILE;
    private String mCurrentTTSTextPath = null;
    private String mCurrentTTSVoiceDataPath = null;
    private int mCurrentVolume = 7;
    private Editor mEditor;
    private Handler mHandler = new C08771();
    private IBNTTSPlayerPCMListener mIBNTTSPlayerPCMListener;
    private IBNTTSPlayerWeChatListener mIBNTTSPlayerWeChatListener;
    private IBNTTSVoiceHintListener mIBNTTSVoiceHintListener;
    private int mInitState = 0;
    private boolean mIsAudioPlaying = false;
    private boolean mIsNaviMute = false;
    private boolean mIsPausing = false;
    private boolean mIsSwitching = false;
    private boolean mIsTTSPlaying = false;
    private MediaPlayer mMediaPlayer = null;
    private String mNormalVoicePath = null;
    private OnTTSStateChangedListener mOnTTSStateChangedListener;
    private OnTTSVoiceDataSwitchListener mOnTTSVoiceDataSwitchListener = null;
    private boolean mPhoneIn = false;
    private Object mPlayStateLock = new Object();
    private SharedPreferences mPreferences;
    private String mRequestSwitchPath = null;
    private String mRequestSwitchTextPath = null;
    private String mSDCardAPPBasePath = null;
    private SpeechSynthesizerListener mSpeechSynthesizerListener = new C08782();
    private Object mSyncObj = new Object();
    private String mTtsJinShaVoiceDataPath = (NavMapAdapter.getInstance().getDataPath() + File.separator + "baiduvoicedata" + File.separator + BNVoiceParams.JIN_SHA + File.separator + BNVoiceParams.JIN_SHA + ".dat");
    private String mTtsRobinVoiceDataPath = (NavMapAdapter.getInstance().getDataPath() + File.separator + "baiduvoicedata" + File.separator + BNVoiceParams.ROBIN + File.separator + BNVoiceParams.ROBIN + ".dat");
    private boolean mVoiceing = false;
    private String ttsPath;
    private SpeechSynthesizer ttsplayer;

    /* renamed from: com.baidu.baidunavis.tts.BdTTSPlayer$1 */
    class C08771 extends BNMainLooperHandler {
        C08771() {
        }

        public void onMessage(Message msg) {
            if (msg.what != 1 && msg.what != 2) {
                if (msg.what == 3) {
                    BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("AudioUtils", null) {
                        protected String execute() {
                            BdTTSPlayer.this.switchTTSVoiceDataInner(BdTTSPlayer.this.mRequestSwitchPath, BdTTSPlayer.this.mRequestSwitchTextPath, BdTTSPlayer.this.isNeedSaveConfig);
                            return null;
                        }
                    }, new BNWorkerConfig(100, 0));
                } else if (msg.what == 4) {
                    if (BdTTSPlayer.this.mContext != null) {
                        try {
                            NavTipTool.onCreateToastDialog(BdTTSPlayer.this.mContext, (int) C0965R.string.car_navi_failed_to_init_tts);
                        } catch (Exception e) {
                        }
                    }
                } else if (5 == msg.what) {
                    BdTTSPlayer.this.resetTTSForTimeout();
                } else if (6 == msg.what) {
                    BdTTSPlayer.loge(BdTTSPlayer.TAG, "MSG_FREE_CUSTOM_TTS_VOICE mInitState:" + BdTTSPlayer.this.mInitState);
                    if (BdTTSPlayer.this.mInitState == 1) {
                        Log.e(BdTTSPlayer.TAG, "freeCustomTTSVoice waiting");
                        BdTTSPlayer.this.mHandler.sendEmptyMessageDelayed(6, 1000);
                        return;
                    }
                    BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("TTS", null) {
                        protected String execute() {
                            BdTTSPlayer.this.freeCustomTTSVoiceDataInner();
                            return null;
                        }
                    }, new BNWorkerConfig(100, 0));
                } else if (7 == msg.what) {
                    BdTTSPlayer.loge(BdTTSPlayer.TAG, "MSG_LOAD_CUSTOM_TTS_VOICE mInitState:" + BdTTSPlayer.this.mInitState);
                    if (BdTTSPlayer.this.mInitState == 1) {
                        Log.e(BdTTSPlayer.TAG, "loadCustomTTSVoice waiting");
                        BdTTSPlayer.this.mHandler.sendEmptyMessageDelayed(7, 1000);
                        return;
                    }
                    BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("TTS", null) {
                        protected String execute() {
                            BdTTSPlayer.this.loadCustomTTSVoiceDataInner();
                            return null;
                        }
                    }, new BNWorkerConfig(100, 0));
                }
            }
        }
    }

    /* renamed from: com.baidu.baidunavis.tts.BdTTSPlayer$2 */
    class C08782 implements SpeechSynthesizerListener {
        C08782() {
        }

        public void onSpeechStart(String arg0) {
            BdTTSPlayer.loge(BdTTSPlayer.TAG, "onSpeechStart() arg0=" + arg0);
            BdTTSPlayer.this.mCurrentProgress = 0;
            if (BdTTSPlayer.this.mOnTTSStateChangedListener != null) {
                BdTTSPlayer.this.mOnTTSStateChangedListener.onPlayStart();
            }
            if (BdTTSPlayer.this.mIBNTTSVoiceHintListener != null) {
                BdTTSPlayer.this.mIBNTTSVoiceHintListener.notifyTTSStart();
            }
            if (BdTTSPlayer.this.mIBNTTSPlayerWeChatListener != null) {
                BdTTSPlayer.this.mIBNTTSPlayerWeChatListener.notifyTTSStart();
            }
            synchronized (BdTTSPlayer.this.mPlayStateLock) {
                BdTTSPlayer.this.mIsTTSPlaying = true;
            }
        }

        public void onSynthesizeFinish(String arg0) {
        }

        public void onSynthesizeStart(String arg0) {
            BdTTSPlayer.loge(BdTTSPlayer.TAG, "onSynthesizeStart() arg0=" + arg0);
            if (BdTTSPlayer.this.mIBNTTSPlayerPCMListener != null) {
                BdTTSPlayer.this.mIBNTTSPlayerPCMListener.notifyTTSStart();
            }
        }

        public void onSpeechFinish(String arg0) {
            BdTTSPlayer.loge(BdTTSPlayer.TAG, "onSpeechFinish() arg0=" + arg0);
            synchronized (BdTTSPlayer.this.mPlayStateLock) {
                BdTTSPlayer.this.mIsTTSPlaying = false;
                if (BdTTSPlayer.this.mHandler != null && BdTTSPlayer.this.mHandler.hasMessages(5)) {
                    BdTTSPlayer.this.mHandler.removeMessages(5);
                }
            }
            synchronized (BdTTSPlayer.this.mSyncObj) {
                if (BdTTSPlayer.this.mIsSwitching) {
                    synchronized (BdTTSPlayer.this.mPlayStateLock) {
                        BdTTSPlayer.this.mPlayStateLock.notifyAll();
                    }
                }
            }
            if (BdTTSPlayer.this.mOnTTSStateChangedListener != null) {
                BdTTSPlayer.this.mOnTTSStateChangedListener.onPlayEnd();
            }
            if (BdTTSPlayer.this.mIBNTTSPlayerPCMListener != null) {
                BdTTSPlayer.this.mIBNTTSPlayerPCMListener.notifyTTSEnd();
            }
            if (BdTTSPlayer.this.mIBNTTSVoiceHintListener != null) {
                BdTTSPlayer.this.mIBNTTSVoiceHintListener.notifyTTSEnd();
            }
            if (BdTTSPlayer.this.mIBNTTSPlayerWeChatListener != null) {
                BdTTSPlayer.this.mIBNTTSPlayerWeChatListener.notifyTTSEnd();
            }
        }

        public void onError(String arg0, SpeechError arg1) {
            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BdTTSPlayer onSpeechFinish onError() arg1=" + arg1.toString());
            SDKDebugFileUtil.getInstance().uploadLogFile(1, true, true, 2000);
            BdTTSPlayer.loge(BdTTSPlayer.TAG, "onError() arg1=" + arg1.toString());
            if (BdTTSPlayer.this.mOnTTSStateChangedListener != null) {
                BdTTSPlayer.this.mOnTTSStateChangedListener.onPlayError(arg1.code, arg1.description);
            }
        }

        public void onSpeechProgressChanged(String arg0, int arg1) {
            BdTTSPlayer.loge(BdTTSPlayer.TAG, "onSpeechProgressChanged arg0=" + arg0 + " arg1=" + arg1);
            BdTTSPlayer.this.mCurrentProgress = arg1;
        }

        public void onSynthesizeDataArrived(String arg0, byte[] arg1, int arg2) {
            if (!BaseTTSPlayer.getInstance().mIsCarlifeConnected) {
                BdTTSPlayer.loge(BdTTSPlayer.TAG, "it is not conectted!");
            } else if (BdTTSPlayer.this.mIBNTTSPlayerPCMListener != null) {
                BdTTSPlayer.loge("jason", "into there and call handlePCMStream, data length = " + arg1.length);
                BdTTSPlayer.this.mIBNTTSPlayerPCMListener.handlePCMStream(arg1, false);
            } else {
                BdTTSPlayer.loge(BdTTSPlayer.TAG, "the listener is null");
            }
        }
    }

    /* renamed from: com.baidu.baidunavis.tts.BdTTSPlayer$3 */
    class C08793 implements OnPreparedListener {
        C08793() {
        }

        public void onPrepared(MediaPlayer mp) {
            BdTTSPlayer.this.mMediaPlayer.start();
        }
    }

    public void setCurrentSelectPath(String path) {
        this.mCurrentSelectPath = path;
    }

    public int getCurrentVolume() {
        return this.mCurrentVolume;
    }

    public void setCurrentVolume(int mCurrentVolume) {
        this.mCurrentVolume = mCurrentVolume;
        if (this.ttsplayer != null) {
            this.ttsplayer.setParam(SpeechSynthesizer.PARAM_VOLUME, String.valueOf(mCurrentVolume));
        }
    }

    public void initPlayer(Context context, String sdcardPath) {
        if (context == null || sdcardPath == null || sdcardPath.length() == 0 || this.mInitState != 0 || !NavCommonFuncModel.isNeonCpuFeature()) {
            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BdTTSPlayer initPlayer 1111: ");
            return;
        }
        this.mInitState = 1;
        this.mContext = context.getApplicationContext();
        this.mSDCardAPPBasePath = sdcardPath;
        this.mNormalVoicePath = context.getDir("tts", 0).getPath();
        makesureDirs();
        if (copyRes()) {
            initPlayerInner(getLastTTSVoiceDataPath());
            return;
        }
        SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BdTTSPlayer initPlayer 2222: ");
        this.mInitState = 0;
    }

    private void resetTTSForTimeout() {
        SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BdTTSPlayer resetTTSForTimeout 111: ");
        if (this.ttsplayer != null && this.mInitState == 2) {
            loge(TAG, "resetTTSForTimeout() ");
            stopTTS();
        }
    }

    public int getInitState() {
        return this.mInitState;
    }

    private void makesureDirs() {
        File f = new File(this.mSDCardAPPBasePath + File.separator + "tts");
        if (!(f == null || f.exists())) {
            f.mkdir();
        }
        File normalFile = new File(this.mNormalVoicePath);
        if (normalFile != null && !normalFile.exists()) {
            normalFile.mkdir();
        }
    }

    private synchronized boolean initPlayerInner(String ttsPath) {
        boolean z;
        if (this.mContext == null || this.mSDCardAPPBasePath == null || this.mSDCardAPPBasePath.length() == 0) {
            this.mInitState = 0;
            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BdTTSPlayer initPlayerInner 1111: ");
            z = false;
        } else {
            long startTime = SystemClock.elapsedRealtime();
            String ttsVoiceDataPath = ttsPath;
            boolean isDefault = false;
            if (ttsVoiceDataPath != null) {
                try {
                    if (ttsVoiceDataPath.length() > 0) {
                        if (!new File(ttsVoiceDataPath).exists()) {
                            BNSettingManager.setVoicePersonality(0);
                            ttsVoiceDataPath = null;
                        } else if (!SynthesizerTool.verifyModelFile(ttsVoiceDataPath)) {
                            BNSettingManager.setVoicePersonality(0);
                            ttsVoiceDataPath = null;
                        }
                    }
                } catch (Throwable t) {
                    SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BdTTSPlayer initPlayerInner 3333: " + t.toString());
                    this.ttsplayer = null;
                    this.mInitState = 0;
                    if (this.mHandler != null) {
                        this.mHandler.sendEmptyMessage(4);
                    }
                    NavMapAdapter.getInstance().exceptionLog(t);
                    z = false;
                }
            }
            this.mPreferences = this.mContext.getSharedPreferences("map_asr_pre", 0);
            this.mEditor = this.mPreferences.edit();
            if (ttsVoiceDataPath == null || ttsVoiceDataPath.length() == 0) {
                ttsVoiceDataPath = this.mNormalVoicePath + File.separator + this.mCurrentSelectPath;
                isDefault = true;
                this.mEditor.putInt(NavUserBehaviourDef.BEHAVIOUR_NAVI_ACTION_ASR_NORMAL, this.mPreferences.getInt(NavUserBehaviourDef.BEHAVIOUR_NAVI_ACTION_ASR_NORMAL, 0) + 1);
                this.mEditor.commit();
            } else {
                this.mEditor.putInt(NavUserBehaviourDef.BEHAVIOUR_NAVI_ACTION_ASR_MAIDOU, this.mPreferences.getInt(NavUserBehaviourDef.BEHAVIOUR_NAVI_ACTION_ASR_MAIDOU, 0) + 1);
                this.mEditor.commit();
            }
            if (BNSettingManager.getHasDownloadJinShaTTS() && BNSettingManager.getAutoSwitchJinShaTTS() && new File(this.mTtsJinShaVoiceDataPath).exists() && SynthesizerTool.verifyModelFile(this.mTtsJinShaVoiceDataPath)) {
                isDefault = false;
                ttsVoiceDataPath = this.mTtsJinShaVoiceDataPath;
                saveCustomVoiceDataPath(this.mTtsJinShaVoiceDataPath);
                BNSettingManager.setVoicePersonality(3);
                BNSettingManager.setVoiceTaskId(BNVoiceParams.JIN_SHA);
                BNSettingManager.setAutoSwitchJinShaTTS(false);
            }
            if (ttsVoiceDataPath == null || ttsVoiceDataPath.length() <= 0 || new File(ttsVoiceDataPath).exists()) {
                if (this.ttsplayer == null) {
                    loge(TAG, "initPlayer() start");
                    if (NavLogUtils.LOGGABLE) {
                        LoggerProxy.printable(true);
                    }
                    NavLogUtils.m3003e("BdTTSPlayer SynthesizerTool.getEngineVersion() = ", SynthesizerTool.getEngineVersion() + "");
                    NavLogUtils.m3003e("BdTTSPlayer SynthesizerTool.getEngineInfo() = ", SynthesizerTool.getEngineInfo());
                    this.ttsplayer = SpeechSynthesizer.getInstance();
                    this.ttsplayer.setContext(this.mContext);
                    this.ttsplayer.setSpeechSynthesizerListener(this.mSpeechSynthesizerListener);
                    this.ttsplayer.setApiKey("sQ7RFHINisS0HdnZfITNlT1p", "azrqa6WpOzQ37cbO9Cnb10M7MRojPKG3");
                    this.ttsplayer.setAppId("7789047");
                    String speed = getInitPlaySpeed(isDefault);
                    this.ttsplayer.setParam(SpeechSynthesizer.PARAM_SPEED, speed);
                    NavLogUtils.m3003e(TAG, "initPlayerInner() set1.speed=" + speed);
                    this.ttsplayer.setParam(SpeechSynthesizer.PARAM_VOCODER_OPTIM_LEVEL, BNSettingManager.getTTSVocoderParam());
                    if (ttsVoiceDataPath != null && ttsVoiceDataPath.equals(this.mTtsJinShaVoiceDataPath)) {
                        this.ttsplayer.setParam(SpeechSynthesizer.PARAM_SPEED, C2578b.f8568g);
                        setCurrentVolume(8);
                    } else if (ttsVoiceDataPath == null || !ttsVoiceDataPath.contains(K_TTS_DATA_TAIWAN_FILE)) {
                        if (ttsVoiceDataPath != null) {
                            if (ttsVoiceDataPath.contains(K_TTS_DATA_FILE)) {
                                this.ttsplayer.setParam(SpeechSynthesizer.PARAM_SPEED, "7");
                                setCurrentVolume(7);
                            }
                        }
                        this.ttsplayer.setParam(SpeechSynthesizer.PARAM_SPEED, getInitPlaySpeed(isDefault));
                        setCurrentVolume(7);
                    } else {
                        this.ttsplayer.setParam(SpeechSynthesizer.PARAM_SPEED, "4");
                        setCurrentVolume(8);
                    }
                    loge(TAG, "initPlayer() tts data path=" + ttsVoiceDataPath + ", time=" + (SystemClock.elapsedRealtime() - startTime) + "/ms");
                    this.ttsplayer.setParam(SpeechSynthesizer.PARAM_TTS_TEXT_MODEL_FILE, this.mNormalVoicePath + File.separator + K_TTS_TEXT_DATA_FILE);
                    this.ttsplayer.setParam(SpeechSynthesizer.PARAM_TTS_SPEECH_MODEL_FILE, ttsVoiceDataPath);
                    if (isDefault) {
                        boolean verifyRet = SynthesizerTool.verifyModelFile(ttsVoiceDataPath);
                        loge(TAG, "initPlayer() verifyRet=" + verifyRet + ", time=" + (SystemClock.elapsedRealtime() - startTime) + "/ms");
                        if (!verifyRet) {
                            loge(TAG, "initPlayer() failed to verify tts. path=" + ttsVoiceDataPath);
                            this.ttsplayer = null;
                            this.mInitState = 0;
                            z = false;
                        }
                    }
                    String licensepath = this.mNormalVoicePath + File.separator + K_TTS_LICENCE_FILE;
                    this.ttsplayer.setParam(SpeechSynthesizer.PARAM_TTS_LICENCE_FILE, licensepath);
                    this.ttsplayer.initTts(TtsMode.OFFLINE);
                    this.ttsplayer.setParam(SpeechSynthesizer.PARAM_OPEN_XML, "1");
                    this.ttsplayer.setParam(SpeechSynthesizer.PARAM_CUSTOM_SYNTH, "1");
                    boolean custom = getTTSVoiceDataCustom();
                    String customResPath = getCustomVoiceDataPath();
                    loge(TAG, "initPlayerInner custom = " + custom + " path = " + customResPath);
                    if (custom && customResPath != null && customResPath.length() > 0) {
                        File file = new File(customResPath);
                        if ((file == null || !file.exists()) && ttsVoiceDataPath != null && ttsVoiceDataPath.equals(this.mTtsRobinVoiceDataPath)) {
                            file = new File(this.mNormalVoicePath + File.separator + K_TTS_ROBIN_FILE);
                        }
                        if (file != null && file.exists()) {
                            this.ttsplayer.loadCustomResource(file.getPath());
                        } else if (isDefault) {
                            saveTTSVoiceDataCustom(false);
                            setTTSVoiceDataPath(null);
                            BNSettingManager.setVoicePersonality(0);
                        }
                    }
                    this.mCurrentTTSTextPath = null;
                    if (isDefault) {
                        this.mCurrentTTSVoiceDataPath = null;
                        saveTTSVoiceDataPath(this.mNormalVoicePath + File.separator + this.mCurrentSelectPath);
                    } else {
                        this.mCurrentTTSVoiceDataPath = ttsVoiceDataPath;
                        saveTTSVoiceDataPath(ttsVoiceDataPath);
                    }
                    loge(TAG, "initPlayer() end, initTime=" + (SystemClock.elapsedRealtime() - startTime) + "/ms");
                }
                this.mInitState = 2;
                z = true;
            } else {
                this.mInitState = 0;
                SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BdTTSPlayer initPlayerInner 2222: ");
                z = false;
            }
        }
        return z;
    }

    private String getInitPlaySpeed(boolean isDefault) {
        return isDefault ? String.valueOf(7) : String.valueOf(BNSettingManager.getTTSSpeedParam());
    }

    private boolean copyRes() {
        if (this.mContext == null) {
            return false;
        }
        boolean ret = copyAssetsFile(K_TTS_DATA_FILE, this.mNormalVoicePath, K_TTS_DATA_FILE);
        loge(TAG, "initPlayer() copy, ret=" + ret + ", path=" + this.mNormalVoicePath + "/" + K_TTS_DATA_FILE);
        ret &= copyAssetsFile(K_TTS_TEXT_DATA_FILE, this.mNormalVoicePath, K_TTS_TEXT_DATA_FILE);
        loge(TAG, "initPlayer() copy text, ret=" + ret + ", path=" + this.mNormalVoicePath + "/" + K_TTS_TEXT_DATA_FILE);
        ret &= copyAssetsFile(K_TTS_DATA_TAIWAN_FILE, this.mNormalVoicePath, K_TTS_DATA_TAIWAN_FILE);
        loge(TAG, "initPlayer() copy text, ret=" + ret + ", path=" + this.mNormalVoicePath + "/" + K_TTS_DATA_TAIWAN_FILE);
        if (ret) {
            return copyAssetsFile(K_TTS_LICENCE_FILE, this.mNormalVoicePath, K_TTS_LICENCE_FILE);
        }
        return ret;
    }

    public boolean setTTSVoiceDataPath(String newTTSPath) {
        if (this.mContext == null) {
            return false;
        }
        String ttsPath = newTTSPath;
        boolean isDefault = false;
        try {
            this.mPreferences = this.mContext.getSharedPreferences("map_asr_pre", 0);
            this.mEditor = this.mPreferences.edit();
            if (newTTSPath == null || newTTSPath.length() == 0) {
                isDefault = true;
                this.mEditor.putInt(NavUserBehaviourDef.BEHAVIOUR_NAVI_ACTION_ASR_NORMAL, this.mPreferences.getInt(NavUserBehaviourDef.BEHAVIOUR_NAVI_ACTION_ASR_NORMAL, 0) + 1);
                this.mEditor.commit();
            } else {
                this.mEditor.putInt(NavUserBehaviourDef.BEHAVIOUR_NAVI_ACTION_ASR_MAIDOU, this.mPreferences.getInt(NavUserBehaviourDef.BEHAVIOUR_NAVI_ACTION_ASR_MAIDOU, 0) + 1);
                this.mEditor.commit();
            }
            if (isDefault) {
                saveTTSVoiceDataPath("");
            } else {
                saveTTSVoiceDataPath(ttsPath);
            }
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public boolean setCustomParams(boolean custom) {
        if (this.mContext == null) {
            return false;
        }
        saveTTSVoiceDataCustom(custom);
        return true;
    }

    public boolean loadCustomResource(String path) {
        if (this.mContext == null) {
            return false;
        }
        saveCustomVoiceDataPath(path);
        return true;
    }

    public boolean recoveryToNavVoice() {
        loge(TAG, "recoveryToNavVoice state:" + this.mInitState);
        if (this.mInitState != 2) {
            return false;
        }
        boolean voiceNeedRecovery;
        String lastVoice = getLastTTSVoiceDataPath();
        if (TextUtils.isEmpty(this.mCurrentTTSVoiceDataPath)) {
            if (TextUtils.isEmpty(lastVoice)) {
                voiceNeedRecovery = false;
            } else {
                voiceNeedRecovery = true;
            }
        } else if (this.mCurrentTTSVoiceDataPath.equals(lastVoice)) {
            voiceNeedRecovery = false;
        } else {
            voiceNeedRecovery = true;
        }
        boolean textNeedRecovery;
        if (TextUtils.isEmpty(this.mCurrentTTSTextPath)) {
            textNeedRecovery = false;
        } else {
            textNeedRecovery = true;
        }
        if (voiceNeedRecovery || textNeedRecovery) {
            return switchTTSVoiceDataAsync(lastVoice, null, true, null);
        }
        if (TextUtils.isEmpty(lastVoice) || lastVoice.equals(this.mTtsJinShaVoiceDataPath)) {
            loge(TAG, "recover speed = 6");
            setPlaySpeed(6);
        } else {
            int speed = BNSettingManager.getTTSSpeedParam();
            loge(TAG, "recover speed = " + speed);
            setPlaySpeed(speed);
        }
        loge(TAG, "recoveryToNavVoice no need");
        return true;
    }

    public boolean canSwitchVoice() {
        boolean z = false;
        if (!(this.mHandler == null || this.mContext == null)) {
            synchronized (this.mSyncObj) {
                if (this.mIsSwitching) {
                } else {
                    z = true;
                }
            }
        }
        return z;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean switchTTSVoiceData(java.lang.String r6, java.lang.String r7, boolean r8, com.baidu.baidunavis.tts.OnTTSVoiceDataSwitchListener r9, boolean r10) {
        /*
        r5 = this;
        r2 = 1;
        r1 = 0;
        r3 = r5.mHandler;
        if (r3 != 0) goto L_0x0007;
    L_0x0006:
        return r1;
    L_0x0007:
        r3 = r5.mSyncObj;
        monitor-enter(r3);
        r4 = r5.mIsSwitching;	 Catch:{ all -> 0x0010 }
        if (r4 == 0) goto L_0x0013;
    L_0x000e:
        monitor-exit(r3);	 Catch:{ all -> 0x0010 }
        goto L_0x0006;
    L_0x0010:
        r1 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0010 }
        throw r1;
    L_0x0013:
        r1 = 1;
        r5.mIsSwitching = r1;	 Catch:{ all -> 0x0010 }
        monitor-exit(r3);	 Catch:{ all -> 0x0010 }
        r5.mRequestSwitchPath = r6;
        r5.mRequestSwitchTextPath = r7;
        r5.isNeedSaveConfig = r8;
        r5.mOnTTSVoiceDataSwitchListener = r9;
        if (r10 == 0) goto L_0x002d;
    L_0x0021:
        r1 = r5.mHandler;
        r3 = 3;
        r0 = r1.obtainMessage(r3);
        r0.sendToTarget();
        r1 = r2;
        goto L_0x0006;
    L_0x002d:
        r1 = r5.switchTTSVoiceDataInner(r6, r7, r8);
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.baidunavis.tts.BdTTSPlayer.switchTTSVoiceData(java.lang.String, java.lang.String, boolean, com.baidu.baidunavis.tts.OnTTSVoiceDataSwitchListener, boolean):boolean");
    }

    public boolean switchTTSVoiceDataSync(String newTTSPath, String textPath, boolean saveConfig) {
        return switchTTSVoiceData(newTTSPath, textPath, saveConfig, null, false);
    }

    public boolean switchTTSVoiceDataAsync(String newTTSPath, String textPath, boolean saveConfig, OnTTSVoiceDataSwitchListener lis) {
        return switchTTSVoiceData(newTTSPath, textPath, saveConfig, lis, true);
    }

    public boolean freeCustomTTSVoice(String ttsPath, OnTTSVoiceDataSwitchListener lis) {
        if (this.mInitState == 0) {
            Log.e(TAG, "freeCustomTTSVoice fail state:" + this.mInitState);
            return false;
        } else if (this.mHandler == null) {
            return false;
        } else {
            this.mHandler.obtainMessage(6).sendToTarget();
            return true;
        }
    }

    public boolean loadCustomTTSVoice(String ttsPath, OnTTSVoiceDataSwitchListener lis) {
        if (this.mInitState == 0) {
            Log.e(TAG, "loadCustomTTSVoice fail state:" + this.mInitState);
            return false;
        } else if (this.mHandler == null) {
            return false;
        } else {
            this.mHandler.obtainMessage(7).sendToTarget();
            return true;
        }
    }

    private boolean switchTTSVoiceDataInner(String newTTSPath, String textPath, boolean saveConfig) {
        if (this.mContext == null) {
            return false;
        }
        this.ttsPath = newTTSPath;
        boolean isDefault = false;
        this.mPreferences = this.mContext.getSharedPreferences("map_asr_pre", 0);
        this.mEditor = this.mPreferences.edit();
        if (newTTSPath == null || newTTSPath.length() == 0) {
            this.ttsPath = this.mNormalVoicePath + File.separator + this.mCurrentSelectPath;
            isDefault = true;
            this.mEditor.putInt(NavUserBehaviourDef.BEHAVIOUR_NAVI_ACTION_ASR_NORMAL, this.mPreferences.getInt(NavUserBehaviourDef.BEHAVIOUR_NAVI_ACTION_ASR_NORMAL, 0) + 1);
            this.mEditor.commit();
        } else {
            this.mEditor.putInt(NavUserBehaviourDef.BEHAVIOUR_NAVI_ACTION_ASR_MAIDOU, this.mPreferences.getInt(NavUserBehaviourDef.BEHAVIOUR_NAVI_ACTION_ASR_MAIDOU, 0) + 1);
            this.mEditor.commit();
        }
        if (this.ttsplayer == null) {
            boolean tmpRet = initPlayerInner(this.ttsPath);
            synchronized (this.mSyncObj) {
                this.mIsSwitching = false;
            }
            if (this.mOnTTSVoiceDataSwitchListener == null) {
                return tmpRet;
            }
            this.mOnTTSVoiceDataSwitchListener.onTTSVoiceDataSwitched(tmpRet);
            return tmpRet;
        }
        try {
            synchronized (this.mPlayStateLock) {
                if (this.mIsTTSPlaying) {
                    try {
                        this.mPlayStateLock.wait(BNOffScreenParams.MIN_ENTER_INTERVAL);
                    } catch (Exception e) {
                    }
                }
            }
            this.ttsplayer.stop();
            boolean verifyRet = SynthesizerTool.verifyModelFile(this.ttsPath);
            loge(TAG, "switchTTSVoiceData() verifyRet=" + verifyRet);
            if (verifyRet) {
                if (this.ttsPath != null && this.ttsPath.equals(this.mTtsJinShaVoiceDataPath)) {
                    this.ttsplayer.setParam(SpeechSynthesizer.PARAM_SPEED, C2578b.f8568g);
                    setCurrentVolume(8);
                } else if (this.ttsPath != null && this.ttsPath.contains(K_TTS_DATA_TAIWAN_FILE)) {
                    this.ttsplayer.setParam(SpeechSynthesizer.PARAM_SPEED, "4");
                    setCurrentVolume(8);
                } else if (this.ttsPath == null || !this.ttsPath.contains(K_TTS_DATA_FILE)) {
                    this.ttsplayer.setParam(SpeechSynthesizer.PARAM_SPEED, getInitPlaySpeed(isDefault));
                    setCurrentVolume(7);
                } else {
                    this.ttsplayer.setParam(SpeechSynthesizer.PARAM_SPEED, "7");
                    setCurrentVolume(7);
                }
                this.ttsplayer.freeCustomResource();
                SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BdTTSPlayer switchTTSVoiceDataInner loadModel() ret= " + this.ttsplayer.loadModel(this.ttsPath, textPath) + " ttsPath " + this.ttsPath + " textPath " + textPath);
                boolean custom = getTTSVoiceDataCustom();
                String customResPath = getCustomVoiceDataPath();
                loge(TAG, "switchTTSVoiceData custom = " + custom + " customPath = " + customResPath);
                if (custom && customResPath != null && customResPath.length() > 0) {
                    File file = new File(customResPath);
                    if ((file == null || !file.exists()) && this.ttsPath != null && this.ttsPath.equals(this.mTtsRobinVoiceDataPath)) {
                        file = new File(this.mNormalVoicePath + File.separator + K_TTS_ROBIN_FILE);
                    }
                    if (file != null && file.exists()) {
                        this.ttsplayer.freeCustomResource();
                        this.ttsplayer.loadCustomResource(file.getPath());
                    }
                }
                this.mCurrentTTSTextPath = textPath;
                if (isDefault) {
                    this.mCurrentTTSVoiceDataPath = null;
                } else {
                    this.mCurrentTTSVoiceDataPath = this.ttsPath;
                }
                if (saveConfig) {
                    saveTTSVoiceDataPath(isDefault ? this.mNormalVoicePath + File.separator + this.mCurrentSelectPath : this.ttsPath);
                }
                synchronized (this.mSyncObj) {
                    this.mIsSwitching = false;
                }
                if (this.mOnTTSVoiceDataSwitchListener != null) {
                    this.mOnTTSVoiceDataSwitchListener.onTTSVoiceDataSwitched(true);
                }
                return true;
            }
            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BdTTSPlayer switchTTSVoiceDataInner 111: ");
            loge(TAG, "switchTTSVoiceData() failed to verify tts. path=" + this.ttsPath);
            synchronized (this.mSyncObj) {
                this.mIsSwitching = false;
            }
            if (this.mOnTTSVoiceDataSwitchListener != null) {
                this.mOnTTSVoiceDataSwitchListener.onTTSVoiceDataSwitched(false);
            }
            return false;
        } catch (Throwable t) {
            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BdTTSPlayer switchTTSVoiceDataInner 222: " + t.toString());
            this.ttsplayer = null;
            this.mInitState = 0;
            synchronized (this.mSyncObj) {
                this.mIsSwitching = false;
                NavMapAdapter.getInstance().exceptionLog(t);
                return false;
            }
        }
    }

    private boolean freeCustomTTSVoiceDataInner() {
        if (this.mContext == null) {
            return false;
        }
        try {
            synchronized (this.mPlayStateLock) {
                if (this.mIsTTSPlaying) {
                    try {
                        this.mPlayStateLock.wait(BNOffScreenParams.MIN_ENTER_INTERVAL);
                    } catch (Exception e) {
                    }
                }
            }
            this.ttsplayer.stop();
            this.ttsplayer.freeCustomResource();
            loge(TAG, "freeCustomTTSVoiceDataInner");
            return true;
        } catch (Throwable t) {
            this.ttsplayer = null;
            this.mInitState = 0;
            NavMapAdapter.getInstance().exceptionLog(t);
            return false;
        }
    }

    private boolean loadCustomTTSVoiceDataInner() {
        if (this.mContext == null) {
            return false;
        }
        try {
            synchronized (this.mPlayStateLock) {
                if (this.mIsTTSPlaying) {
                    try {
                        this.mPlayStateLock.wait(BNOffScreenParams.MIN_ENTER_INTERVAL);
                    } catch (Exception e) {
                    }
                }
            }
            this.ttsplayer.stop();
            boolean custom = getTTSVoiceDataCustom();
            String customResPath = getCustomVoiceDataPath();
            loge(TAG, "load custom = " + custom + " customPath = " + customResPath);
            if (custom && customResPath != null && customResPath.length() > 0) {
                File file = new File(customResPath);
                if (file != null && file.exists()) {
                    this.ttsplayer.freeCustomResource();
                    this.ttsplayer.loadCustomResource(customResPath);
                }
            }
            return true;
        } catch (Throwable t) {
            this.ttsplayer = null;
            this.mInitState = 0;
            NavMapAdapter.getInstance().exceptionLog(t);
            return false;
        }
    }

    public String getCurrentTTSVoiceDataPath() {
        return this.mCurrentTTSVoiceDataPath;
    }

    public void setEnableTimeOut(boolean enable) {
        this.isTimeOutEnable = enable;
        if (!this.isTimeOutEnable && this.mHandler != null && this.mHandler.hasMessages(5)) {
            this.mHandler.removeMessages(5);
        }
    }

    public int getTTSState() {
        int i = 0;
        if (this.ttsplayer == null) {
            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BdTTSPlayer getTTSState !is");
        } else {
            synchronized (this.mPlayStateLock) {
                if (this.isTimeOutEnable) {
                    if (!this.mIsTTSPlaying || this.mIsPausing) {
                        if (this.mHandler.hasMessages(5)) {
                            this.mHandler.removeMessages(5);
                        }
                    } else if (!this.mHandler.hasMessages(5)) {
                        this.mHandler.sendEmptyMessageDelayed(5, 20000);
                    }
                }
                if (this.mIsPausing) {
                    i = 3;
                } else if (this.mIsTTSPlaying || this.mIsAudioPlaying) {
                    i = 2;
                } else {
                    i = 1;
                }
                if (SDKDebugFileUtil.getInstance().isShowCoreLog(3, 0, i, null, null)) {
                    SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BaseTTSPlayer getTTSState mTmpTTSState: " + i + ", mIsTTSPlaying: " + this.mIsTTSPlaying + ", mIsAudioPlaying: " + this.mIsAudioPlaying + ", mIsPausing: " + this.mIsPausing + ", isTimeOutEnable: " + this.isTimeOutEnable);
                }
                loge(TAG, "TTSState: " + i + ", mIsTTSPlaying: " + this.mIsTTSPlaying + ", mIsAudioPlaying: " + this.mIsAudioPlaying + ", mIsPausing: " + this.mIsPausing + ", isTimeOutEnable: " + this.isTimeOutEnable);
            }
        }
        return i;
    }

    public int playTTSText(String speech, int bPreempt) {
        return playTTSText(speech, null, bPreempt);
    }

    public int playTTSText(String speech, String pStrTag, int bPreempt) {
        if (this.mVoiceing || this.mIsNaviMute) {
            return 0;
        }
        return playTTSTextImp(speech, pStrTag, bPreempt);
    }

    public void stopTTS() {
        loge(TAG, "stopTTS");
        if (this.mVoiceing) {
            loge(TAG, "stopTTS fail voiceing");
            return;
        }
        try {
            if (this.ttsplayer != null) {
                synchronized (this.mPlayStateLock) {
                    this.mIsTTSPlaying = false;
                    this.mIsPausing = false;
                }
                Context ctx = NavCommonFuncModel.getInstance().getContext();
                if (ctx != null) {
                    AudioUtils.releaseAudioFocus(ctx);
                }
                this.ttsplayer.stop();
                C2198u.m8354a().m8365c();
                if (this.mIBNTTSPlayerWeChatListener != null) {
                    this.mIBNTTSPlayerWeChatListener.notifyTTSInterrupt();
                }
            }
        } catch (Throwable th) {
        }
    }

    public int pauseTTS() {
        loge(TAG, "pauseTTS");
        if (this.ttsplayer == null) {
            return -1;
        }
        synchronized (this.mPlayStateLock) {
            this.mIsPausing = true;
        }
        return this.ttsplayer.pause();
    }

    public int resumeTTS() {
        loge(TAG, "resumeTTS");
        if (this.ttsplayer == null) {
            return -1;
        }
        synchronized (this.mPlayStateLock) {
            this.mIsPausing = false;
        }
        return this.ttsplayer.resume();
    }

    public void releaseTTSPlayer() {
        loge(TAG, "releaseTTSPlayer");
        stopTTS();
    }

    public void setPhoneIn(boolean bCalling) {
        this.mPhoneIn = bCalling;
    }

    public int setPlaySpeed(int speed) {
        NavLogUtils.m3003e(TAG, "setPlaySpeed() set7.speed=" + speed);
        try {
            if (this.ttsplayer != null) {
                String param = getInitPlaySpeed(true);
                if (speed < 0 || speed > 9) {
                    NavLogUtils.m3003e(TAG, "setPlaySpeed() set8.speed=" + param);
                    return this.ttsplayer.setParam(SpeechSynthesizer.PARAM_SPEED, param);
                }
                NavLogUtils.m3003e(TAG, "setPlaySpeed() set9.speed=" + String.valueOf(speed));
                return this.ttsplayer.setParam(SpeechSynthesizer.PARAM_SPEED, String.valueOf(speed));
            }
        } catch (Exception e) {
        }
        return -1;
    }

    public void setOnTTSStateChangedListener(OnTTSStateChangedListener listener) {
        this.mOnTTSStateChangedListener = listener;
    }

    public int getCurrentProgress() {
        return this.mCurrentProgress;
    }

    public void dospeak(String speech) {
        dospeak(speech, null);
    }

    public void dospeak(String speech, String pStrTag) {
        if (this.ttsplayer == null) {
            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BdTTSPlayer dospeak ttsplayer == null ");
            return;
        }
        synchronized (this.mPlayStateLock) {
            this.mIsTTSPlaying = true;
        }
        try {
            int ret = this.ttsplayer.speak(speech);
            TTSPlayerControl.setTTSTextPlayResult(pStrTag);
            loge(TAG, "dospeak() ret=" + ret + ", speech=" + speech);
            if (ret != 0) {
                SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BdTTSPlayer dospeak ret=" + ret + ", speech=" + speech);
            }
        } catch (Throwable e) {
            SDKDebugFileUtil.getInstance().addCoreLog(CoreLogModule.CoreLog_TTS, " BdTTSPlayer dospeak Throwable " + e.getMessage());
            Log.e(TAG, "dospeak Exception:" + e.getMessage());
            synchronized (this.mPlayStateLock) {
                this.mIsTTSPlaying = false;
            }
        }
    }

    private void saveCustomVoiceDataPath(String path) {
        if (this.mContext != null && path != null) {
            SharedPreferences mSettings = this.mContext.getSharedPreferences("_navi_sdk_tts_custom_path_", 0);
            if (mSettings != null) {
                Editor mEditor = mSettings.edit();
                if (mEditor != null) {
                    mEditor.putString("_navi_sdk_tts_custom_path_", path);
                    mEditor.commit();
                }
            }
        }
    }

    public String getCustomVoiceDataPath() {
        if (this.mContext == null) {
            return null;
        }
        SharedPreferences mSettings = this.mContext.getSharedPreferences("_navi_sdk_tts_custom_path_", 0);
        if (mSettings == null) {
            return null;
        }
        String path = mSettings.getString("_navi_sdk_tts_custom_path_", "");
        if (path == null || path.length() == 0) {
            return null;
        }
        try {
            String sdcardrRootPath = StorageSettings.getInstance().getCurrentStorage().getRootPath();
            if (path.startsWith(sdcardrRootPath)) {
                return path;
            }
            return sdcardrRootPath + path.substring(path.indexOf(File.separator + "BaiduCarlife"));
        } catch (Exception e) {
            e.printStackTrace();
            return path;
        }
    }

    private void saveTTSVoiceDataCustom(boolean custom) {
        if (this.mContext != null) {
            SharedPreferences mSettings = this.mContext.getSharedPreferences("_navi_sdk_tts_custom_", 0);
            if (mSettings != null) {
                Editor mEditor = mSettings.edit();
                if (mEditor != null) {
                    mEditor.putBoolean("_navi_sdk_tts_custom_", custom);
                    mEditor.commit();
                }
            }
        }
    }

    public boolean getTTSVoiceDataCustom() {
        if (this.mContext == null) {
            return false;
        }
        SharedPreferences mSettings = this.mContext.getSharedPreferences("_navi_sdk_tts_custom_", 0);
        if (mSettings != null) {
            return mSettings.getBoolean("_navi_sdk_tts_custom_", false);
        }
        return false;
    }

    public String getLastTTSVoiceDataPath() {
        if (this.mContext == null) {
            return null;
        }
        SharedPreferences mSettings = this.mContext.getSharedPreferences("_navi_sdk_pres_", 0);
        if (mSettings == null) {
            return null;
        }
        String path = mSettings.getString("tts_voice_data_path", "");
        if (path == null || path.length() == 0) {
            return null;
        }
        try {
            String sdcardrRootPath = StorageSettings.getInstance().getCurrentStorage().getRootPath();
            NavLogUtils.m3003e(TAG, "getLastTTSVoiceDataPath() path:" + path + ", sdcardrRootPath:" + sdcardrRootPath);
            if (!path.startsWith(sdcardrRootPath)) {
                path = sdcardrRootPath + path.substring(path.indexOf(File.separator + "BaiduCarlife"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (path.contains(OLD_MAP_MENGMENGDA_PATH)) {
            NavLogUtils.m3003e(TAG, "getLastTTSVoiceDataPath() contains old map mengmengda");
            Editor mEditor = mSettings.edit();
            if (mEditor == null) {
                return null;
            }
            mEditor.putString("tts_voice_data_path", "");
            mEditor.commit();
            return null;
        } else if (path.contains(K_TTS_DATA_FILE) || path.contains(K_TTS_DATA_TAIWAN_FILE)) {
            return path;
        } else {
            return null;
        }
    }

    public void saveTTSVoiceDataPath(String path) {
        if (this.mContext != null && path != null) {
            SharedPreferences mSettings = this.mContext.getSharedPreferences("_navi_sdk_pres_", 0);
            if (mSettings != null) {
                Editor mEditor = mSettings.edit();
                if (mEditor != null) {
                    mEditor.putString("tts_voice_data_path", path);
                    mEditor.commit();
                }
            }
        }
    }

    public static boolean isCalling(Context context) {
        if (context == null) {
            return false;
        }
        switch (((TelephonyManager) context.getSystemService("phone")).getCallState()) {
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    public boolean isJinshaTTS() {
        return this.ttsPath != null && this.ttsPath.equals(this.mTtsJinShaVoiceDataPath);
    }

    private static boolean copyAssetsFile(String assetPath, String destPath, String desFileName) {
        Exception e;
        Throwable th;
        InputStream is = null;
        OutputStream outputStream = null;
        try {
            ScheduleConfig config = new ScheduleConfig(DataTaskType.forUpdateData(), ScheduleTag.NULL);
            AssetsTask task = new AssetsTask(C2907c.m10977f(), assetPath);
            AssetsManager.open(Module.NAV_MODULE, task, config);
            is = task.getInputStream();
            if (is == null) {
                NavMapAdapter.getInstance().close(is);
                NavMapAdapter.getInstance().close(null);
                return false;
            }
            File file = new File(destPath);
            long fileLen = file.length();
            int assetLen = is.available();
            if (file.exists() && fileLen == ((long) assetLen)) {
                NavMapAdapter.getInstance().close(is);
                NavMapAdapter.getInstance().close(null);
                return true;
            }
            File out = new File(destPath);
            if (!out.exists()) {
                out.mkdirs();
            }
            File outFile = new File(destPath + "/" + desFileName);
            loge(TAG, "copyAssetsFile path = " + destPath + "/" + desFileName);
            if (outFile.exists()) {
                outFile.delete();
                loge(TAG, "copyAssetsFile file exists -> delete");
            }
            OutputStream os = new FileOutputStream(outFile);
            try {
                byte[] buf = new byte[1024];
                while (true) {
                    int len = is.read(buf);
                    if (len > 0) {
                        os.write(buf, 0, len);
                    } else {
                        NavMapAdapter.getInstance().close(is);
                        NavMapAdapter.getInstance().close(os);
                        outputStream = os;
                        return true;
                    }
                }
            } catch (Exception e2) {
                e = e2;
                outputStream = os;
                try {
                    loge("", e.toString());
                    NavMapAdapter.getInstance().close(is);
                    NavMapAdapter.getInstance().close(outputStream);
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    NavMapAdapter.getInstance().close(is);
                    NavMapAdapter.getInstance().close(outputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStream = os;
                NavMapAdapter.getInstance().close(is);
                NavMapAdapter.getInstance().close(outputStream);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            loge("", e.toString());
            NavMapAdapter.getInstance().close(is);
            NavMapAdapter.getInstance().close(outputStream);
            return false;
        }
    }

    private static void loge(String tag, String info) {
        NavLogUtils.m3003e(tag, info);
    }

    public int playAudio(String audioPath, final AudioPlayerListener lis) {
        loge(TAG, "playAudio");
        if (BNSettingManager.getVoiceMode() == 2) {
            loge(TAG, "voice mode is Quite, return");
            return 0;
        } else if (audioPath == null || TextUtils.isEmpty(audioPath)) {
            loge(TAG, "audioPath is null or empty");
            return -1;
        } else {
            synchronized (this.mPlayStateLock) {
                this.mIsAudioPlaying = true;
            }
            try {
                if (this.mMediaPlayer == null) {
                    this.mMediaPlayer = new MediaPlayer();
                }
                this.mMediaPlayer.setOnPreparedListener(new C08793());
                this.mMediaPlayer.setOnCompletionListener(new OnCompletionListener() {
                    public void onCompletion(MediaPlayer mp) {
                        if (lis != null) {
                            lis.playCompletion();
                        }
                    }
                });
                this.mMediaPlayer.setDataSource(audioPath);
                this.mMediaPlayer.prepareAsync();
                return 0;
            } catch (Exception e) {
                loge(TAG, "playAudio exception");
                cancelAudio();
                return -1;
            }
        }
    }

    public int cancelAudio() {
        loge(TAG, "cancelAudio");
        int ret = -1;
        if (this.mMediaPlayer != null) {
            try {
                if (this.mMediaPlayer.isPlaying()) {
                    this.mMediaPlayer.stop();
                }
                this.mMediaPlayer.release();
                this.mMediaPlayer = null;
                ret = 0;
            } catch (Exception e) {
                loge(TAG, "cancelAudio exception");
            }
        }
        synchronized (this.mPlayStateLock) {
            this.mIsAudioPlaying = false;
        }
        return ret;
    }

    public void setTTSStreamType(int streamType) {
        if (this.ttsplayer != null) {
            this.ttsplayer.setAudioStreamType(streamType);
        }
    }

    public void setIBNTTSPlayerPCMListener(IBNTTSPlayerPCMListener listener) {
        this.mIBNTTSPlayerPCMListener = listener;
    }

    public void setIBNTTSVoiceHintListener(IBNTTSVoiceHintListener listener) {
        this.mIBNTTSVoiceHintListener = listener;
    }

    public void setBNTTSPlayerStatusChangedWeChat(IBNTTSPlayerWeChatListener listener) {
        this.mIBNTTSPlayerWeChatListener = listener;
    }

    public int playVoiceTTSText(String tmpSpeech, int bPreempt) {
        return playTTSTextImp(tmpSpeech, null, bPreempt);
    }

    public int playWeChatTTSText(String speech, int bPreempt) {
        if (this.mVoiceing) {
            return 0;
        }
        return playTTSTextImp(speech, null, bPreempt);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int playTTSTextImp(java.lang.String r8, java.lang.String r9, int r10) {
        /*
        r7 = this;
        r5 = 2;
        r2 = 1;
        r1 = 0;
        r3 = r7.ttsplayer;
        if (r3 == 0) goto L_0x000b;
    L_0x0007:
        r3 = r7.mInitState;
        if (r3 == r5) goto L_0x0019;
    L_0x000b:
        r2 = com.baidu.navisdk.debug.SDKDebugFileUtil.getInstance();
        r3 = "CoreLog_TTS: ";
        r4 = " BdTTSPlayer playTTSText ttsplayer == null || mInitState != INIT_STATE_OK ";
        r2.addCoreLog(r3, r4);
    L_0x0018:
        return r1;
    L_0x0019:
        r3 = r7.mPhoneIn;
        if (r3 == 0) goto L_0x003e;
    L_0x001d:
        r2 = com.baidu.navisdk.debug.SDKDebugFileUtil.getInstance();
        r3 = "CoreLog_TTS: ";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = " BdTTSPlayer playTTSText mPhoneIn ";
        r4 = r4.append(r5);
        r5 = r7.mPhoneIn;
        r4 = r4.append(r5);
        r4 = r4.toString();
        r2.addCoreLog(r3, r4);
        goto L_0x0018;
    L_0x003e:
        r3 = r7.mSyncObj;
        monitor-enter(r3);
        r4 = r7.mIsSwitching;	 Catch:{ all -> 0x0067 }
        if (r4 == 0) goto L_0x006a;
    L_0x0045:
        r2 = com.baidu.navisdk.debug.SDKDebugFileUtil.getInstance();	 Catch:{ all -> 0x0067 }
        r4 = "CoreLog_TTS: ";
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0067 }
        r5.<init>();	 Catch:{ all -> 0x0067 }
        r6 = " BdTTSPlayer playTTSText mIsSwitching ";
        r5 = r5.append(r6);	 Catch:{ all -> 0x0067 }
        r6 = r7.mIsSwitching;	 Catch:{ all -> 0x0067 }
        r5 = r5.append(r6);	 Catch:{ all -> 0x0067 }
        r5 = r5.toString();	 Catch:{ all -> 0x0067 }
        r2.addCoreLog(r4, r5);	 Catch:{ all -> 0x0067 }
        monitor-exit(r3);	 Catch:{ all -> 0x0067 }
        goto L_0x0018;
    L_0x0067:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0067 }
        throw r2;
    L_0x006a:
        monitor-exit(r3);	 Catch:{ all -> 0x0067 }
        r3 = r7.mContext;	 Catch:{ Exception -> 0x00ab }
        r3 = isCalling(r3);	 Catch:{ Exception -> 0x00ab }
        if (r3 != 0) goto L_0x0083;
    L_0x0073:
        if (r10 != r2) goto L_0x007e;
    L_0x0075:
        r3 = r7.getTTSState();	 Catch:{ Exception -> 0x00ab }
        if (r3 != r5) goto L_0x007e;
    L_0x007b:
        r7.stopTTS();	 Catch:{ Exception -> 0x00ab }
    L_0x007e:
        r7.dospeak(r8, r9);	 Catch:{ Exception -> 0x00ab }
    L_0x0081:
        r1 = r2;
        goto L_0x0018;
    L_0x0083:
        r4 = com.baidu.navisdk.debug.SDKDebugFileUtil.getInstance();	 Catch:{ Exception -> 0x00ab }
        r5 = "CoreLog_TTS: ";
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ab }
        r3.<init>();	 Catch:{ Exception -> 0x00ab }
        r6 = " BdTTSPlayer playTTSText !isCalling(mContext) ";
        r6 = r3.append(r6);	 Catch:{ Exception -> 0x00ab }
        r3 = r7.mContext;	 Catch:{ Exception -> 0x00ab }
        r3 = isCalling(r3);	 Catch:{ Exception -> 0x00ab }
        if (r3 != 0) goto L_0x00d9;
    L_0x009e:
        r3 = r2;
    L_0x009f:
        r3 = r6.append(r3);	 Catch:{ Exception -> 0x00ab }
        r3 = r3.toString();	 Catch:{ Exception -> 0x00ab }
        r4.addCoreLog(r5, r3);	 Catch:{ Exception -> 0x00ab }
        goto L_0x0081;
    L_0x00ab:
        r0 = move-exception;
        r3 = com.baidu.navisdk.debug.SDKDebugFileUtil.getInstance();
        r4 = "CoreLog_TTS: ";
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = " BdTTSPlayer playTTSText Exception ";
        r5 = r5.append(r6);
        r6 = r0.toString();
        r5 = r5.append(r6);
        r5 = r5.toString();
        r3.addCoreLog(r4, r5);
        r3 = "";
        r4 = r0.toString();
        loge(r3, r4);
        goto L_0x0081;
    L_0x00d9:
        r3 = 0;
        goto L_0x009f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.baidunavis.tts.BdTTSPlayer.playTTSTextImp(java.lang.String, java.lang.String, int):int");
    }

    public void stopTTSWX() {
        loge(TAG, "stopTTSWX");
        try {
            if (this.ttsplayer != null) {
                synchronized (this.mPlayStateLock) {
                    this.mIsTTSPlaying = false;
                    this.mIsPausing = false;
                }
                this.ttsplayer.stop();
                C2198u.m8354a().m8365c();
            }
        } catch (Throwable th) {
        }
    }

    public void stopTTSVR() {
        loge(TAG, "stopTTSVR");
        try {
            if (this.ttsplayer != null) {
                synchronized (this.mPlayStateLock) {
                    this.mIsTTSPlaying = false;
                    this.mIsPausing = false;
                }
                Context ctx = NavCommonFuncModel.getInstance().getContext();
                if (ctx != null) {
                    AudioUtils.releaseAudioFocus(ctx);
                }
                this.ttsplayer.stop();
                C2198u.m8354a().m8366d();
                if (this.mIBNTTSPlayerWeChatListener != null) {
                    this.mIBNTTSPlayerWeChatListener.notifyTTSInterrupt();
                }
            }
        } catch (Throwable th) {
        }
    }

    public void setNaviMute(boolean isNaviMute) {
        boolean z = false;
        if (isNaviMute) {
            if (!this.mIsNaviMute) {
                z = true;
            }
            this.mIsNaviMute = z;
        } else {
            this.mIsNaviMute = false;
        }
        if (this.mIsNaviMute && !this.mVoiceing) {
            stopTTS();
        }
    }

    public boolean isNaviMute() {
        return this.mIsNaviMute;
    }

    public void setVoiceState(boolean bVoice) {
        this.mVoiceing = bVoice;
    }

    public boolean getVoiceState() {
        return this.mVoiceing;
    }

    public int setStereoVolume(float leftVolume, float rightVolume) {
        if (this.ttsplayer == null) {
            return 0;
        }
        return this.ttsplayer.setStereoVolume(leftVolume, rightVolume);
    }
}
