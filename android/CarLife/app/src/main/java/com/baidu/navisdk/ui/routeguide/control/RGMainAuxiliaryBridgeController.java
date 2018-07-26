package com.baidu.navisdk.ui.routeguide.control;

import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.tts.TTSPlayerControl;
import com.baidu.navisdk.ui.util.BNStyleManager;

public class RGMainAuxiliaryBridgeController {
    private static final String TAG = RGMainAuxiliaryBridgeController.class.getSimpleName();
    private static final String TEXT_TYPE_SWITCH_TO_GROUND = "已为您切换至高架下";
    private static final String TEXT_TYPE_SWITCH_TO_MAIN_ROUTE = "已为您切换至主路";
    private static final String TEXT_TYPE_SWITCH_TO_SLAVE_ROUTE = "已为您切换至辅路";
    private static final String TEXT_TYPE_SWITCH_TO_VIADUCT = "已为您切换至高架上";
    public static final int TTS_TYPE_SWITCH_TO_GROUND = 4;
    public static final int TTS_TYPE_SWITCH_TO_MAIN_ROUTE = 1;
    public static final int TTS_TYPE_SWITCH_TO_SLAVE_ROUTE = 2;
    public static final int TTS_TYPE_SWITCH_TO_VIADUCT = 3;
    private static Object mSyncObj = new Object();
    private static RGMainAuxiliaryBridgeController sInstance = null;

    public static RGMainAuxiliaryBridgeController getInstance() {
        if (sInstance == null) {
            synchronized (mSyncObj) {
                if (sInstance == null) {
                    sInstance = new RGMainAuxiliaryBridgeController();
                }
            }
        }
        return sInstance;
    }

    public void playMainAuxiliaryBridgeText(int type) {
        if (2 == BNSettingManager.getVoiceMode()) {
            return;
        }
        if (type == 1) {
            TTSPlayerControl.playTTS(TEXT_TYPE_SWITCH_TO_MAIN_ROUTE, 1);
        } else if (type == 2) {
            TTSPlayerControl.playTTS(TEXT_TYPE_SWITCH_TO_SLAVE_ROUTE, 1);
        } else if (type == 3) {
            TTSPlayerControl.playTTS(TEXT_TYPE_SWITCH_TO_VIADUCT, 1);
        } else if (type == 4) {
            TTSPlayerControl.playTTS(TEXT_TYPE_SWITCH_TO_GROUND, 1);
        }
    }

    public void onRoutePlanFail() {
        RGNotificationController.getInstance().showCommonResultMsg(BNStyleManager.getString(C4048R.string.nsdk_string_rg_rp_build_fail), false);
    }
}
