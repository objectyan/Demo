package com.baidu.tts.auth;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.auth.C4978b.C4976a;
import com.baidu.tts.auth.C4981c.C4980a;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p233f.C5095m;
import com.baidu.tts.p233f.C5097n;
import com.baidu.tts.p236h.p237a.C5105c;

public class AuthInfo {
    /* renamed from: a */
    private C5095m f20659a;
    /* renamed from: b */
    private C4980a f20660b;
    /* renamed from: c */
    private C4976a f20661c;
    /* renamed from: d */
    private TtsError f20662d;

    public C5095m getTtsEnum() {
        return this.f20659a;
    }

    public void setTtsEnum(C5095m ttsEnum) {
        this.f20659a = ttsEnum;
    }

    public C4980a getOnlineResult() {
        return this.f20660b;
    }

    public void setOnlineResult(C4980a onlineResult) {
        this.f20660b = onlineResult;
    }

    public C4976a getOfflineResult() {
        return this.f20661c;
    }

    public void setOfflineResult(C4976a offlineResult) {
        this.f20661c = offlineResult;
    }

    public TtsError getTtsError() {
        if (this.f20662d != null) {
            return this.f20662d;
        }
        switch (this.f20659a) {
            case ONLINE:
                return this.f20660b.m16598b();
            case OFFLINE:
                return this.f20661c.m16581b();
            case MIX:
                return getMixTtsError();
            default:
                return null;
        }
    }

    public void setTtsError(TtsError ttsError) {
        this.f20662d = ttsError;
    }

    public String getNotifyMessage() {
        return this.f20661c.m16583c();
    }

    public int getLeftValidDays() {
        return this.f20661c.m16577a();
    }

    public TtsError getOnlineTtsError() {
        return this.f20660b != null ? this.f20660b.m16598b() : this.f20662d;
    }

    public TtsError getOfflineTtsError() {
        return this.f20661c != null ? this.f20661c.m16581b() : this.f20662d;
    }

    public TtsError getMixTtsError() {
        TtsError onlineTtsError = getOnlineTtsError();
        TtsError offlineTtsError = getOfflineTtsError();
        TtsError ttsError = null;
        if (onlineTtsError != null && offlineTtsError != null) {
            ttsError = C5105c.m17295a().m17302b(C5097n.MIX_ENGINE_AUTH_FAILURE);
        } else if (onlineTtsError == null && offlineTtsError != null) {
            ttsError = C5105c.m17295a().m17302b(C5097n.OFFLINE_ENGINE_AUTH_FAILURE);
        } else if (onlineTtsError != null && offlineTtsError == null) {
            ttsError = C5105c.m17295a().m17302b(C5097n.ONLINE_ENGINE_AUTH_FAILURE);
        }
        if (ttsError != null) {
            return ttsError;
        }
        return this.f20662d;
    }

    public boolean isSuccess() {
        if (this.f20662d != null) {
            LoggerProxy.m17001d("AuthInfo", "cause=" + this.f20662d.getThrowable().getMessage());
            return false;
        } else if (this.f20659a == null) {
            return false;
        } else {
            switch (this.f20659a) {
                case ONLINE:
                    return isOnlineSuccess();
                case OFFLINE:
                    return isOfflineSuccess();
                case MIX:
                    return isMixSuccess();
                default:
                    return false;
            }
        }
    }

    public boolean isOnlineSuccess() {
        return this.f20660b != null ? this.f20660b.mo3801g() : false;
    }

    public boolean isOfflineSuccess() {
        return this.f20661c != null ? this.f20661c.mo3801g() : false;
    }

    public boolean isMixSuccess() {
        return isOnlineSuccess() || isOfflineSuccess();
    }
}
