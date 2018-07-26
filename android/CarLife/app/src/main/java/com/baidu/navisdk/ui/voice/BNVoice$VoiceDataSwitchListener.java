package com.baidu.navisdk.ui.voice;

public interface BNVoice$VoiceDataSwitchListener {
    boolean isCanSwitchVoice();

    boolean onFreeCustom(BNVoice$VoiceSwitchData bNVoice$VoiceSwitchData);

    boolean onLoadCustom(BNVoice$VoiceSwitchData bNVoice$VoiceSwitchData);

    boolean onVoiceDataSwitch(BNVoice$VoiceSwitchData bNVoice$VoiceSwitchData);
}
