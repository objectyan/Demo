package com.baidu.carlife.p052m;

import android.content.Context;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.tts.AudioUtils;
import com.baidu.baidunavis.tts.BaseTTSPlayer;
import com.baidu.baidunavis.tts.IBNTTSPlayerPCMListener;
import com.baidu.baidunavis.tts.IBNTTSPlayerWeChatListener;
import com.baidu.baidunavis.tts.IBNTTSVoiceHintListener;
import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.p087l.C1663a;

/* compiled from: BNTTSPlayer */
/* renamed from: com.baidu.carlife.m.a */
public class C1915a {

    /* compiled from: BNTTSPlayer */
    /* renamed from: com.baidu.carlife.m.a$b */
    public interface C0917b {
        /* renamed from: a */
        boolean mo1338a();
    }

    /* compiled from: BNTTSPlayer */
    /* renamed from: com.baidu.carlife.m.a$a */
    private static class C1914a {
        /* renamed from: a */
        private static C1915a f5907a = new C1915a();

        private C1914a() {
        }
    }

    /* renamed from: a */
    public static C1915a m7321a() {
        return C1914a.f5907a;
    }

    private C1915a() {
    }

    /* renamed from: a */
    public void m7327a(boolean isCarlifeConnected) {
        BaseTTSPlayer.getInstance().setCarLifeConnected(isCarlifeConnected);
    }

    /* renamed from: a */
    public void m7326a(C0917b listener) {
        BaseTTSPlayer.getInstance().setIBNTTSBtStatusInterface(listener);
    }

    /* renamed from: a */
    public void m7323a(IBNTTSPlayerPCMListener listener) {
        BaseTTSPlayer.getInstance().setIBNTTSPlayerPCMListener(listener);
    }

    /* renamed from: a */
    public void m7325a(IBNTTSVoiceHintListener listener) {
        BaseTTSPlayer.getInstance().setIBNTTSVoiceHintListener(listener);
    }

    /* renamed from: a */
    public void m7324a(IBNTTSPlayerWeChatListener listener) {
        BaseTTSPlayer.getInstance().setBNTTSPlayerStatusChangedWeChat(listener);
    }

    /* renamed from: a */
    public synchronized int m7322a(String speech, int bPreempt) {
        boolean z = true;
        int i = 0;
        synchronized (this) {
            BaseTTSPlayer instance = BaseTTSPlayer.getInstance();
            if (1 != bPreempt) {
                z = false;
            }
            if (instance.playTTSText(speech, z) == 0) {
                i = -1;
            }
        }
        return i;
    }

    /* renamed from: b */
    public synchronized int m7328b(String speech, int bPreempt) {
        m7327a(C1663a.m5979a().m5993N());
        LogUtil.d("BNTTSPlayer", "playVoiceTTSText " + speech);
        return BaseTTSPlayer.getInstance().playVoiceTTSText(speech, bPreempt) == 0 ? -1 : 0;
    }

    /* renamed from: c */
    public synchronized int m7331c(String speech, int bPreempt) {
        return BaseTTSPlayer.getInstance().playWeChatTTSText(speech, bPreempt) == 0 ? -1 : 0;
    }

    /* renamed from: b */
    public void m7329b() {
        BaseTTSPlayer.getInstance().stopTTS();
    }

    /* renamed from: c */
    public void m7332c() {
        BaseTTSPlayer.getInstance().stopTTSWX();
    }

    /* renamed from: d */
    public void m7334d() {
        BaseTTSPlayer.getInstance().stopTTSVR();
        m7338h();
    }

    /* renamed from: e */
    public void m7335e() {
        BaseTTSPlayer.getInstance().stopTTS();
        Context ctx = NavCommonFuncModel.getInstance().getContext();
        if (ctx != null) {
            AudioUtils.releaseAudioFocus(ctx);
        }
    }

    /* renamed from: b */
    public void m7330b(boolean bVoice) {
        BaseTTSPlayer.getInstance().setVoiceState(bVoice);
    }

    /* renamed from: f */
    public boolean m7336f() {
        return BaseTTSPlayer.getInstance().getVoiceState();
    }

    /* renamed from: c */
    public void m7333c(boolean isNaviMute) {
        BaseTTSPlayer.getInstance().setNaviMuteState(isNaviMute);
    }

    /* renamed from: g */
    public boolean m7337g() {
        return BaseTTSPlayer.getInstance().isNaviMuteState();
    }

    /* renamed from: h */
    public void m7338h() {
        byte[] vrTTsPackage = C1663a.m5979a().m6018a((int) CommonParams.bD, 0);
        C1663a.m5979a().m6030d(vrTTsPackage, vrTTsPackage.length);
    }
}
