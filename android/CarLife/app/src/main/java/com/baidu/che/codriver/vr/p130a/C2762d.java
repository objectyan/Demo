package com.baidu.che.codriver.vr.p130a;

import android.content.Context;
import com.baidu.carlife.C0965R;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.C2848p;
import com.baidu.speech.utils.AsrError;
import org.json.JSONObject;

/* compiled from: ErrorCommand */
/* renamed from: com.baidu.che.codriver.vr.a.d */
public class C2762d extends C2747a {
    public C2762d(C2848p data, C2673m callback, Context context) {
        super(data, callback, context);
    }

    /* renamed from: h */
    public void mo1957h() {
        C2549b model = new C2549b();
        model.f8464f = C2695a.TYPE_NORMAL_REQ;
        model.f8467i = this.b.m10781a();
        model.f8468j = 2;
        this.c.mo1928a(model);
    }

    /* renamed from: a */
    public void mo1959a(C2747a cmd) {
    }

    /* renamed from: i */
    protected void mo1960i() {
    }

    /* renamed from: j */
    protected void mo1958j() {
    }

    /* renamed from: k */
    protected JSONObject mo1961k() {
        return null;
    }

    /* renamed from: a */
    private void m10484a(C2549b model) {
        switch (this.b.m10781a()) {
            case 1:
            case 2:
                model.f8465g = this.d.getString(C0965R.string.nlp_server_exception);
                return;
            case 3:
                model.f8465g = this.d.getString(C0965R.string.network_unavailble);
                return;
            case 1001:
            case 1002:
            case 1003:
            case 1004:
            case 1005:
            case 1006:
                model.f8465g = this.d.getString(C0965R.string.network_unavailble);
                return;
            case 2000:
            case 2001:
            case 2002:
            case 2003:
            case 2004:
            case 2005:
            case 2006:
            case 2100:
            case AsrError.ERROR_NETWORK_NOT_GRANTED /*2101*/:
                model.f8465g = this.d.getString(C0965R.string.network_unavailble);
                return;
            case 3000:
            case 3001:
            case 3002:
            case 3003:
            case AsrError.ERROR_AUDIO_RECORDER_READ /*3006*/:
            case 3007:
            case 3008:
            case 3009:
            case 3010:
            case 3011:
            case 3100:
                model.f8465g = this.d.getString(C0965R.string.microphone_using_by_other);
                return;
            case AsrError.ERROR_AUDIO_VAD_NO_SPEECH /*3101*/:
                model.f8465g = this.d.getString(C0965R.string.no_hear_and_exit);
                return;
            case AsrError.ERROR_AUDIO_VAD_SPEAK_TOO_SHORT /*3102*/:
                model.f8465g = this.d.getString(C0965R.string.recorder_error);
                return;
            case 4001:
            case 4002:
            case 4004:
                model.f8465g = this.d.getString(C0965R.string.no_understand_quit);
                return;
            case 5001:
            case 5002:
            case 5003:
            case AsrError.ERROR_CLIENT_RESOLVE_URL /*5004*/:
            case AsrError.ERROR_CLIENT_NEED_HTTPS_URL /*5005*/:
                model.f8465g = this.d.getString(C0965R.string.xiaodu_is_uncomfortable);
                return;
            case 6001:
                model.f8465g = this.d.getString(C0965R.string.talk_too_long);
                return;
            case AsrError.ERROR_NO_MATCH_RESULT /*7001*/:
                model.f8465g = this.d.getString(C0965R.string.no_understand_quit);
                return;
            case AsrError.ERROR_ASR_ENGINE_BUSY /*8001*/:
                model.f8465g = this.d.getString(C0965R.string.xiaodu_is_busy_now);
                return;
            case 9001:
                model.f8465g = this.d.getString(C0965R.string.microphone_unavailable);
                return;
            case 10001:
            case 10002:
            case AsrError.ERROR_OFFLINE_INVALID_LICENSE /*10003*/:
            case AsrError.ERROR_OFFLINE_PARAM /*10004*/:
            case AsrError.ERROR_OFFLINE_NOT_INITIAL /*10005*/:
            case AsrError.ERROR_OFFLINE_INVALID_MODEL /*10006*/:
            case AsrError.ERROR_OFFLINE_INVALID_GRAMMAR /*10007*/:
            case AsrError.ERROR_OFFLINE_ENGINE_RESET_FAIL /*10008*/:
            case AsrError.ERROR_OFFLINE_ENGINE_INITIAL_FAIL /*10009*/:
            case AsrError.ERROR_OFFLINE_ENGINE_FREE_FAIL /*10010*/:
            case AsrError.ERROR_OFFLINE_ENGINE_NOT_SUPPORT /*10011*/:
            case AsrError.ERROR_OFFLINE_RECOGNIZE_FAIL /*10012*/:
                model.f8465g = this.d.getString(C0965R.string.offline_engine_fail);
                return;
            default:
                model.f8465g = this.d.getString(C0965R.string.no_understand_quit);
                return;
        }
    }
}
