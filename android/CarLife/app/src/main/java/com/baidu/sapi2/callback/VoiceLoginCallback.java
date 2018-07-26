package com.baidu.sapi2.callback;

import com.baidu.sapi2.result.VoiceLoginResult;

public abstract class VoiceLoginCallback implements SapiCallback<VoiceLoginResult> {
    public abstract void onPwdVerifyFailure(VoiceLoginResult voiceLoginResult);
}
