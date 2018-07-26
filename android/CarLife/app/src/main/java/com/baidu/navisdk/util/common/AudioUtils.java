package com.baidu.navisdk.util.common;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Build;
import android.os.Handler;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.listener.BlueToothListener;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.statistic.userop.UserOPParams;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;

public class AudioUtils {
    public static final int CLOSE_SCO_FROM_AUDIO_DISCONNECTED = 15;
    public static final int CLOSE_SCO_FROM_BT_DISCONNECT = 12;
    public static final int CLOSE_SCO_FROM_CALL_STATE_RINGING_OR_OFFHOOK = 13;
    public static final int CLOSE_SCO_FROM_CLICK_DIALOG = 11;
    public static final int CLOSE_SCO_FROM_QUIT_NAVI = 14;
    public static final int MSG_TYPE_CLOSE_BT_SCO = 1002;
    public static final int MSG_TYPE_OPEN_BT_SCO = 1001;
    public static final int OPEN_SCO_FROM_AUTO_CONNECT = 2;
    public static final int OPEN_SCO_FROM_CALL_STATE_IDLE = 3;
    public static final int OPEN_SCO_FROM_CLICK_DIALOG = 1;
    public static final String TAG = AudioUtils.class.getSimpleName();
    public static boolean sIsBTCloseFromPhone = false;
    public static boolean sIsPaused;
    public static boolean sIsPhoneUsing = false;
    public static OnAudioFocusChangeListener sOnAudioFocusChange = new AudioUtils$1();
    public static int sVolumeBeforePause = 0;
    public boolean hasInited;
    private boolean isSCOConnect = false;
    private AudioManager mAudioManager;
    private Context mContext;
    private Handler mHander;
    private AudioUtils$OnPhoneStateListener mOnPhoneStateListener = null;
    private TelephonyManager telephony;

    public synchronized boolean isSCOConnect() {
        return this.isSCOConnect;
    }

    public synchronized void setSCOConnect(boolean isSCOConnect) {
        this.isSCOConnect = isSCOConnect;
    }

    public AudioUtils(Context context) {
        initAudioUtils(context);
    }

    public void createPhoneListener() {
        this.telephony = (TelephonyManager) this.mContext.getSystemService("phone");
        this.mOnPhoneStateListener = new AudioUtils$OnPhoneStateListener(this);
        this.telephony.listen(this.mOnPhoneStateListener, 32);
    }

    public void initAudioUtils(Context context) {
        this.mAudioManager = (AudioManager) context.getSystemService("audio");
        this.mContext = context;
        LogUtil.e(TAG, "initAudioUtils mAudioManager = " + this.mAudioManager + ", mContext = " + this.mContext + ", sIsPhoneUsing = " + sIsPhoneUsing);
        this.hasInited = true;
    }

    public static AudioManager getAudioManager(Context context) {
        return (AudioManager) context.getSystemService("audio");
    }

    public static int getCurrentVolume(Context context) {
        int i = 11;
        if (context != null) {
            try {
                i = getAudioManager(context).getStreamVolume(3);
            } catch (Exception e) {
            }
        }
        return i;
    }

    public static void setVolume(Context context, int volume) {
        if (context != null) {
            try {
                LogUtil.e(TAG, "setVolume() volume=" + volume);
                getAudioManager(context).setStreamVolume(3, volume, 0);
            } catch (Exception e) {
            }
        }
    }

    public static boolean requestAudioFocus(Context context) {
        AudioManager am = getAudioManager(context);
        if (am != null && am.requestAudioFocus(sOnAudioFocusChange, 3, 2) == 1) {
            return true;
        }
        return false;
    }

    public static boolean releaseAudioFocus(Context context) {
        AudioManager am = getAudioManager(context);
        if (am == null) {
            return false;
        }
        am.abandonAudioFocus(sOnAudioFocusChange);
        return true;
    }

    public static void volumeUp(Context context) {
        if (context != null) {
            try {
                AudioManager am = getAudioManager(context);
                int maxVolume = am.getStreamMaxVolume(3);
                int curVolume = am.getStreamVolume(3);
                if (curVolume < maxVolume) {
                    setVolume(context, curVolume + 1);
                }
            } catch (Exception e) {
            }
        }
    }

    public static void volumeDown(Context context) {
        if (context != null) {
            try {
                int curVolume = getCurrentVolume(context);
                if (curVolume > 0) {
                    setVolume(context, curVolume - 1);
                }
            } catch (Exception e) {
            }
        }
    }

    public static void pauseTTS(Context context) {
        int curVolume = getCurrentVolume(context);
        LogUtil.e(TAG, "pauseTTS() sIsPaused=" + sIsPaused + ", sVolumeBeforePause=" + sVolumeBeforePause + ", curVolume=" + curVolume);
        if (curVolume != 0) {
            sVolumeBeforePause = curVolume;
            sIsPaused = true;
            setVolume(context, 0);
        }
    }

    public static void resumeTTS(Context context) {
        LogUtil.e(TAG, "resumeTTS() sIsPaused=" + sIsPaused + ", sVolumeBeforePause=" + sVolumeBeforePause + ", context=" + context);
        if (sIsPaused) {
            sIsPaused = false;
            BNWorkerCenter.getInstance().submitMainThreadTaskDelay(new AudioUtils$2("notifyDayNightObservers-" + AudioUtils.class.getSimpleName(), null, context), new BNWorkerConfig(100, 0), 2000);
        }
    }

    public static void init() {
        TTSPlayerControl.init();
    }

    public static void unInit() {
        TTSPlayerControl.unInit();
    }

    public static void setPhoneIn(boolean bCalling) {
        TTSPlayerControl.setPhoneIn(bCalling);
        XDVoiceInstructManager.getInstance().setPhoneIn(bCalling);
    }

    public void openSCO(int fromType) {
        LogUtil.e(TAG, "openSCO fromType = " + fromType);
        sIsBTCloseFromPhone = false;
        if (this.mAudioManager == null || this.mContext == null || sIsPhoneUsing) {
            handleOpenSCOFail();
        } else if (!BlueToothListener.isBTConnect) {
            LogUtil.e(TAG, "!BlueToothListener.isBTConnect");
        } else if (isSCOConnect() && this.mAudioManager.isBluetoothScoOn()) {
            LogUtil.e(TAG, "openSCO sco is already connect");
        } else {
            try {
                if (this.mAudioManager.isBluetoothScoAvailableOffCall()) {
                    LogUtil.e(TAG, "openSCO startBluetoothSco");
                    if (Build.MODEL.equals("e1809c_v75_gwdz1")) {
                        this.mAudioManager.setMode(2);
                    } else {
                        this.mAudioManager.setMode(3);
                    }
                    BNaviModuleManager.setTTSStreamType(0);
                    this.mAudioManager.startBluetoothSco();
                    this.mContext.registerReceiver(new AudioUtils$3(this, fromType), new IntentFilter("android.media.SCO_AUDIO_STATE_CHANGED"));
                    return;
                }
                LogUtil.e(TAG, "openSCO not support BluetoothScoAvailableOffCall");
                handleOpenSCOFail();
            } catch (Exception e) {
                LogUtil.e(TAG, "openSCO Exception");
                resetAudio();
                handleOpenSCOFail();
            }
        }
    }

    public void closeSCO(int fromType) {
        LogUtil.e(TAG, "closeSCO fromType = " + fromType);
        if (fromType != 13) {
            sIsBTCloseFromPhone = false;
        }
        BNavigator.getInstance().removeOpenBTSCOMessages();
        if (this.mAudioManager != null && this.mContext != null && isSCOConnect()) {
            try {
                LogUtil.e(TAG, "closeSCO stopBluetoothSco");
                BNaviModuleManager.setTTSStreamType(3);
                this.mAudioManager.stopBluetoothSco();
                this.mAudioManager.setMode(0);
                this.mContext.registerReceiver(new AudioUtils$4(this, fromType), new IntentFilter("android.media.SCO_AUDIO_STATE_CHANGED"));
            } catch (Exception e) {
                LogUtil.e(TAG, "closeSCO Exception");
            }
        }
    }

    public void resetAudio() {
        LogUtil.e(TAG, "resetAudio");
        if (this.mHander != null) {
            this.mHander.removeMessages(1001);
            this.mHander.removeMessages(1002);
        }
        BNaviModuleManager.setTTSStreamType(3);
        if (this.mAudioManager != null) {
            try {
                this.mAudioManager.setMode(0);
            } catch (Exception e) {
                LogUtil.e(TAG, "resetAudio setMode Exception:" + e.getMessage());
            }
            this.mAudioManager.setBluetoothScoOn(false);
        }
        setSCOConnect(false);
        BlueToothListener.sIsOpenBTChannel = false;
        sIsBTCloseFromPhone = false;
        RGMapModeViewController.getInstance().updateMenuMoreBlueToothView(false);
    }

    public void setBluetoothScoOn(boolean flag) {
        if (this.mAudioManager != null) {
            this.mAudioManager.setBluetoothScoOn(flag);
        }
    }

    public void uninit() {
        LogUtil.e(TAG, "uninit");
        if (this.mHander != null) {
            this.mHander.removeMessages(1001);
            this.mHander.removeMessages(1002);
        }
        this.mAudioManager = null;
        this.mContext = null;
        this.mHander = null;
        this.telephony = null;
        this.mOnPhoneStateListener = null;
        this.hasInited = false;
    }

    private void handleOpenSCOSuccess(int fromType) {
        if (fromType == 1) {
            LogUtil.e(TAG, "handleOpenSCOSuccess OPEN_SCO_FROM_CLICK_DIALOG");
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_9, "1", null, null);
            BlueToothListener.sIsOpenBTChannel = true;
            BNSettingManager.setBlueToothPhoneChannel(true);
            BNSettingManager.setBlueToothName(BlueToothListener.deviceName);
            RGViewController.getInstance().updateMenuMoreBlueToothView(true);
        } else if (fromType == 2) {
            LogUtil.e(TAG, "handleOpenSCOSuccess OPEN_SCO_FROM_AUTO_CONNECT");
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_9, "2", null, null);
            BlueToothListener.sIsOpenBTChannel = true;
            RGViewController.getInstance().updateMenuMoreBlueToothView(true);
        } else if (fromType == 3) {
            LogUtil.e(TAG, "handleOpenSCOSuccess OPEN_SCO_FROM_CALL_STATE_IDLE");
            UserOPController.getInstance().add(UserOPParams.GUIDE_3_5_9, "3", null, null);
            BlueToothListener.sIsOpenBTChannel = true;
            RGViewController.getInstance().updateMenuMoreBlueToothView(true);
        }
    }

    private void handleOpenSCOFail() {
        LogUtil.e(TAG, "handleOpenSCOFail");
        TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_blue_tooth_open_sco_fail));
    }

    private void handleCloseSCOSuccess(int fromType) {
        if (fromType == 11) {
            LogUtil.e(TAG, "handleCloseSCOSuccess CLOSE_SCO_FROM_CLICK_DIALOG");
            BlueToothListener.sIsOpenBTChannel = false;
            RGViewController.getInstance().updateMenuMoreBlueToothView(false);
        } else if (fromType == 12) {
            LogUtil.e(TAG, "handleCloseSCOSuccess CLOSE_SCO_FROM_BT_DISCONNECT");
            BlueToothListener.sIsOpenBTChannel = false;
            RGMapModeViewController.getInstance().updateMenuMoreBlueToothView(false);
        } else if (fromType == 15) {
            LogUtil.e(TAG, "handleCloseSCOSuccess CLOSE_SCO_FROM_AUDIO_DISCONNECTED");
            BlueToothListener.sIsOpenBTChannel = false;
            RGMapModeViewController.getInstance().updateMenuMoreBlueToothView(false);
        } else if (fromType == 13) {
            LogUtil.e(TAG, "handleCloseSCOSuccess CLOSE_SCO_FROM_CALL_STATE_RINGING_OR_OFFHOOK");
            BlueToothListener.sIsOpenBTChannel = false;
            RGViewController.getInstance().updateMenuMoreBlueToothView(false);
        } else if (fromType == 14) {
            LogUtil.e(TAG, "handleCloseSCOSuccess CLOSE_SCO_FROM_QUIT_NAVI");
        }
    }

    private void handleCloseSCOFail() {
        LogUtil.e(TAG, "handleCloseSCOFail");
        TipTool.onCreateToastDialog(this.mContext, JarUtils.getResources().getString(C4048R.string.nsdk_string_blue_tooth_close_sco_fail));
    }

    public void removeSCOMsg() {
        if (this.mHander != null) {
            this.mHander.removeMessages(1002);
            this.mHander.removeMessages(1001);
        }
    }

    public static boolean isSmartisanPanelMute() {
        if (!PackageUtil.isSmartisanPhone()) {
            return false;
        }
        try {
            if (System.getInt(BNaviModuleManager.getContext().getContentResolver(), "volume_panel_mute_enable") == 1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            LogUtil.e(TAG, "isSmartisanPanelMute exception:" + e.getMessage());
            return false;
        }
    }
}
