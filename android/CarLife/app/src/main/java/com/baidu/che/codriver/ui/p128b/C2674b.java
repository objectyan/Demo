package com.baidu.che.codriver.ui.p128b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.baidu.baidunavis.BaiduNaviParams.RoutePlanFailedSubType;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.C1253f;
import com.baidu.carlife.core.C1253f.C1252a;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.logic.voice.C1888b;
import com.baidu.carlife.logic.voice.C1889c;
import com.baidu.carlife.p087l.C1663a;
import com.baidu.che.codriver.C2510a;
import com.baidu.che.codriver.p121g.C2536a;
import com.baidu.che.codriver.p122h.C2537a;
import com.baidu.che.codriver.p122h.C2538b;
import com.baidu.che.codriver.p122h.C2539c;
import com.baidu.che.codriver.p122h.C2543d;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.sdk.p126b.C2617a;
import com.baidu.che.codriver.ui.BaseActivity;
import com.baidu.che.codriver.ui.C2660a;
import com.baidu.che.codriver.ui.C2675b;
import com.baidu.che.codriver.ui.p124d.C2549b;
import com.baidu.che.codriver.ui.p124d.C2549b.C2695a;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.util.C2727j;
import com.baidu.che.codriver.vr.C2672h;
import com.baidu.che.codriver.vr.C2673m;
import com.baidu.che.codriver.vr.C2673m.C2749b;
import com.baidu.che.codriver.vr.C2673m.C2752a;
import com.baidu.che.codriver.vr.C2673m.C2837c;
import com.baidu.che.codriver.vr.C2847o;
import com.baidu.che.codriver.vr.C2848p;
import com.baidu.che.codriver.vr.p130a.C2747a;
import com.baidu.che.codriver.vr.p130a.C2761c;
import com.baidu.navi.fragment.carmode.CarModeQuickRoutePlanFragment;
import com.baidu.navisdk.comapi.statistics.NaviStatConstants;
import com.baidu.speech.utils.AsrError;
import java.util.regex.Pattern;

/* compiled from: VoiceMainController */
/* renamed from: com.baidu.che.codriver.ui.b.b */
public class C2674b implements C2664a, C2672h, C2673m {
    /* renamed from: a */
    public static final int f8765a = 100;
    /* renamed from: b */
    public static final int f8766b = 101;
    /* renamed from: c */
    public static final int f8767c = 102;
    /* renamed from: d */
    public static final int f8768d = 103;
    /* renamed from: e */
    public static final int f8769e = 105;
    /* renamed from: f */
    public static final int f8770f = 106;
    /* renamed from: g */
    public static final int f8771g = 107;
    /* renamed from: h */
    public static final int f8772h = 1;
    /* renamed from: i */
    public static final int f8773i = 4;
    /* renamed from: j */
    public static final int f8774j = 3;
    /* renamed from: k */
    private static final String f8775k = "VoiceMainController";
    /* renamed from: l */
    private static C2674b f8776l = null;
    /* renamed from: m */
    private static final int f8777m = 60000;
    /* renamed from: n */
    private static final int f8778n = 1001;
    /* renamed from: o */
    private static final int f8779o = 1002;
    /* renamed from: p */
    private static final int f8780p = 1003;
    /* renamed from: q */
    private static final int f8781q = 1004;
    /* renamed from: A */
    private boolean f8782A = false;
    /* renamed from: B */
    private boolean f8783B = false;
    /* renamed from: C */
    private C2752a f8784C;
    /* renamed from: D */
    private C2749b f8785D;
    /* renamed from: E */
    private Handler f8786E = new C26651(this);
    /* renamed from: F */
    private C2538b f8787F = new C26705(this);
    /* renamed from: G */
    private C1889c f8788G;
    /* renamed from: H */
    private C2837c f8789H = C2837c.STATE_NORMAL;
    /* renamed from: r */
    private C2675b f8790r = new C2675b(this.f8792t, this);
    /* renamed from: s */
    private C2660a f8791s = new C2660a(this.f8792t);
    /* renamed from: t */
    private Context f8792t = C2716c.m10141a();
    /* renamed from: u */
    private int f8793u = 100;
    /* renamed from: v */
    private boolean f8794v = false;
    /* renamed from: w */
    private boolean f8795w = false;
    /* renamed from: x */
    private long f8796x = 0;
    /* renamed from: y */
    private boolean f8797y = false;
    /* renamed from: z */
    private int f8798z = 0;

    /* compiled from: VoiceMainController */
    /* renamed from: com.baidu.che.codriver.ui.b.b$1 */
    class C26651 extends Handler {
        /* renamed from: a */
        final /* synthetic */ C2674b f8758a;

        C26651(C2674b this$0) {
            this.f8758a = this$0;
        }

        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1001:
                    if (C2674b.f8776l != null && this.f8758a.f8790r.m6351l()) {
                        C2543d.m9631a().m9640d();
                        return;
                    }
                    return;
                case 1002:
                    if (this.f8758a.f8790r.m6351l()) {
                        C2716c.m10144a(this.f8758a.f8792t, C2536a.f8300a, C2536a.f8303d);
                        this.f8758a.m9997v();
                        return;
                    } else if (this.f8758a.f8782A) {
                        this.f8758a.m9997v();
                        return;
                    } else {
                        return;
                    }
                case 1003:
                    if (this.f8758a.f8798z == 3) {
                        C2716c.m10144a(this.f8758a.f8792t, C2536a.f8300a, C2536a.f8302c);
                    } else {
                        C2716c.m10144a(this.f8758a.f8792t, C2536a.f8300a, C2536a.f8301b);
                    }
                    this.f8758a.m9997v();
                    return;
                case 1004:
                    C2725h.m10207b(C2674b.f8775k, "ADD_CHAT_MODEL");
                    this.f8758a.mo1928a((C2549b) msg.obj);
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: VoiceMainController */
    /* renamed from: com.baidu.che.codriver.ui.b.b$2 */
    class C26662 extends C2538b {
        /* renamed from: a */
        final /* synthetic */ C2674b f8759a;

        C26662(C2674b this$0) {
            this.f8759a = this$0;
        }

        public void onSpeechFinish(String s) {
            this.f8759a.f8786E.obtainMessage(1002).sendToTarget();
        }
    }

    /* compiled from: VoiceMainController */
    /* renamed from: com.baidu.che.codriver.ui.b.b$3 */
    class C26673 extends C2538b {
        /* renamed from: a */
        final /* synthetic */ C2674b f8760a;

        C26673(C2674b this$0) {
            this.f8760a = this$0;
        }

        public void onSpeechFinish(String s) {
            this.f8760a.f8786E.obtainMessage(1002).sendToTarget();
        }
    }

    /* compiled from: VoiceMainController */
    /* renamed from: com.baidu.che.codriver.ui.b.b$4 */
    class C26684 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C2674b f8761a;

        C26684(C2674b this$0) {
            this.f8761a = this$0;
        }

        public void run() {
            this.f8761a.mo1925a();
        }
    }

    /* compiled from: VoiceMainController */
    /* renamed from: com.baidu.che.codriver.ui.b.b$5 */
    class C26705 extends C2538b {
        /* renamed from: a */
        final /* synthetic */ C2674b f8763a;

        /* compiled from: VoiceMainController */
        /* renamed from: com.baidu.che.codriver.ui.b.b$5$1 */
        class C26691 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C26705 f8762a;

            C26691(C26705 this$1) {
                this.f8762a = this$1;
            }

            public void run() {
                this.f8762a.f8763a.mo1925a();
            }
        }

        C26705(C2674b this$0) {
            this.f8763a = this$0;
        }

        public void onSpeechStart(String s) {
            this.f8763a.f8795w = true;
        }

        public void onSpeechFinish(String s) {
            int delay;
            if (C1253f.m4406a(C1252a.VEHICLE_CHANNEL_YUANFENG_YILI) && C1663a.m5979a().m5993N()) {
                delay = C1253f.eJ;
            } else {
                delay = 500;
            }
            this.f8763a.f8795w = false;
            if (this.f8763a.f8785D != null) {
                this.f8763a.f8785D.mo1962a();
                this.f8763a.f8785D = null;
            }
            C2725h.m10207b(C2674b.f8775k, "SpeechFinish VoiceMainController: " + this.b.f8468j);
            if (this.b.f8468j == 1 || this.b.f8468j == 0) {
                this.f8763a.f8786E.sendEmptyMessageDelayed(1002, (long) delay);
            } else if (this.b.f8468j == 2) {
                this.f8763a.f8786E.post(new C26691(this));
            }
        }
    }

    private C2674b() {
    }

    /* renamed from: b */
    public static C2674b m9985b() {
        if (f8776l == null) {
            synchronized (C2674b.class) {
                if (f8776l == null) {
                    f8776l = new C2674b();
                }
            }
        }
        return f8776l;
    }

    /* renamed from: v */
    private void m9997v() {
        if (this.f8788G != null) {
            this.f8788G.mo1719e();
        }
        C2847o.m10687a().m10773m();
        m10038o();
    }

    /* renamed from: c */
    public void m10023c() {
        C2725h.m10207b(f8775k, "stopVrEngine");
        if (this.f8788G != null) {
            this.f8788G.mo1721g();
        }
        C2847o.m10687a().m10728a(false);
    }

    /* renamed from: a */
    public void m10014a(boolean hasTryAgain) {
        this.f8794v = hasTryAgain;
    }

    /* renamed from: d */
    public void mo1936d() {
        m10036m();
        m10002a(101);
        C2847o.m10687a().m10771l();
    }

    /* renamed from: e */
    public void mo1938e() {
        String tts;
        C2725h.m10207b(f8775k, "switchToPrevPage()");
        mo1928a(null);
        if (!this.f8790r.m10063n()) {
            tts = "当前不支持翻页";
        } else if (this.f8790r.m10064o()) {
            tts = "上一页";
        } else {
            tts = "已经是最前一页";
        }
        C2543d.m9631a().m9634a(tts, new C26662(this));
    }

    /* renamed from: f */
    public void mo1939f() {
        String tts;
        C2725h.m10207b(f8775k, "switchToNextPage()");
        mo1928a(null);
        if (!this.f8790r.m10063n()) {
            tts = "当前不支持翻页";
        } else if (this.f8790r.m10065p()) {
            tts = "下一页";
        } else {
            tts = "已经是最后一页";
        }
        C2543d.m9631a().m9634a(tts, new C26673(this));
    }

    /* renamed from: a */
    public void m10002a(int status) {
        this.f8793u = status;
        switch (status) {
            case 100:
                C2725h.m10207b(f8775k, "state = STATE_INITING");
                this.f8790r.setStateIniting(this.f8792t.getString(C0965R.string.state_using_microphone));
                return;
            case 101:
                C2725h.m10207b(f8775k, "state = STATE_IDLE");
                this.f8790r.setStatePrepared();
                return;
            case 102:
                C2725h.m10207b(f8775k, "state = STATE_BEFORE_READY");
                return;
            case 103:
                C2725h.m10207b(f8775k, "state = STATE_LISTENING");
                this.f8790r.setStateRecording();
                return;
            case 105:
                C2725h.m10207b(f8775k, "state = STATE_RECOGNIZING");
                this.f8790r.setStatePrecessing();
                return;
            case 106:
                C2725h.m10207b(f8775k, "state = STATE_SEARCHING");
                return;
            case 107:
                C2725h.m10207b(f8775k, "state = STATE_READY");
                this.f8790r.setStateListening();
                return;
            default:
                return;
        }
    }

    /* renamed from: g */
    public boolean m10030g() {
        return this.f8793u != 101;
    }

    /* renamed from: h */
    public boolean m10031h() {
        C2725h.m10207b(f8775k, "Current state: " + this.f8793u);
        return this.f8793u == 107;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case C0965R.id.voice_shut_down_button:
                C2725h.m10207b(f8775k, "click voice recognition close button !");
                mo1925a();
                m10036m();
                return;
            case C0965R.id.voice_setting_button:
                C2725h.m10214e(f8775k, "####### show help dialog");
                this.f8786E.postDelayed(new C26684(this), 100);
                C2847o.m10687a().m10775o();
                this.f8791s.m9956a(true);
                return;
            case C0965R.id.v_BaiduMic:
                m9998w();
                return;
            default:
                return;
        }
    }

    /* renamed from: w */
    private void m9998w() {
        long current = System.currentTimeMillis();
        if (current - this.f8796x > 500) {
            this.f8796x = current;
            switch (this.f8793u) {
                case 101:
                    m10002a(102);
                    C2716c.m10144a(this.f8792t, C2536a.f8300a, C2536a.f8302c);
                    m10036m();
                    m9997v();
                    return;
                case 102:
                    return;
                case 103:
                case 107:
                    m10023c();
                    m10002a(105);
                    return;
                case 105:
                case 106:
                    m10002a(101);
                    C2847o.m10687a().m10771l();
                    this.f8790r.m10056b("");
                    m10037n();
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    public void mo1932a(String word) {
        m10015a(true, word);
        this.f8797y = true;
    }

    /* renamed from: i */
    public void mo1940i() {
    }

    /* renamed from: j */
    public void mo1941j() {
        if (this.f8788G != null) {
            this.f8788G.mo1720f();
        }
        if (this.f8790r.m6351l()) {
            m10002a(107);
        }
    }

    /* renamed from: k */
    public void mo1942k() {
        if (this.f8790r.m6351l()) {
            m10002a(103);
        }
    }

    /* renamed from: l */
    public void mo1943l() {
        if (this.f8788G != null) {
            this.f8788G.mo1721g();
        }
        if (this.f8790r.m6351l()) {
            m10002a(105);
        }
    }

    /* renamed from: b */
    public void mo1934b(String rawText) {
        C2725h.m10207b(f8775k, "onUpdateRawText rawText = " + rawText);
        if (!C2761c.m10463a().m10480e() || (!rawText.equals("上一页") && !rawText.equals("下一页") && !rawText.equals("上页") && !rawText.equals("下页") && !m10017a(rawText, "[一|二|三|四|五|六|七|八|九|十][个|项|张|页]"))) {
            mo1937d(rawText);
        }
    }

    /* renamed from: a */
    public boolean m10017a(String src, String regex) {
        if (TextUtils.isEmpty(regex) || TextUtils.isEmpty(src)) {
            return false;
        }
        return Pattern.compile(regex).matcher(src).find();
    }

    /* renamed from: c */
    public void mo1935c(String text) {
        if (this.f8790r.m6351l() && text != null && text.length() > 0) {
            this.f8790r.m10056b("\"" + text + "\"");
        }
    }

    /* renamed from: a */
    public void mo1931a(C2848p vrResultModel) {
        C2725h.m10207b(f8775k, "Vr onParseNormalResult: " + (vrResultModel != null ? vrResultModel.toString() : "null"));
        C2747a command = C2761c.m10463a().m10466a(vrResultModel, (C2673m) this, this.f8792t);
        command.mo1957h();
        C2761c.m10463a().m10467a(command);
    }

    /* renamed from: a */
    public void mo1927a(NLPResponseData nlpResponseData) {
        C2725h.m10207b(f8775k, "Vr onParseComplexResult: " + (nlpResponseData != null ? nlpResponseData.toString() : "null"));
        C2761c.m10463a().m10465a(nlpResponseData, (C2673m) this, this.f8792t).mo1957h();
    }

    /* renamed from: b */
    public void mo1933b(int i) {
    }

    /* renamed from: a */
    public void mo1926a(View view) {
        if (this.f8790r == null) {
        }
    }

    /* renamed from: m */
    public void m10036m() {
        C2543d.m9631a().m9639c();
        this.f8795w = false;
    }

    /* renamed from: n */
    public void m10037n() {
        C2725h.m10207b(f8775k, "sendTimeOutMsg");
        if (!this.f8795w && this.f8793u == 101) {
            this.f8786E.removeMessages(1001);
            this.f8786E.sendEmptyMessageDelayed(1001, 60000);
        }
    }

    /* renamed from: o */
    public void m10038o() {
        C2725h.m10207b(f8775k, "removeTimeOutMsg");
        this.f8786E.removeMessages(1001);
    }

    /* renamed from: a */
    public void mo1929a(C2549b result, C2752a listener, C2749b ttsFinishListener) {
        this.f8784C = listener;
        this.f8785D = ttsFinishListener;
        mo1928a(result);
    }

    /* renamed from: a */
    public void mo1928a(C2549b result) {
        if (this.f8788G != null) {
            this.f8788G.mo1722h();
        }
        C2725h.m10207b(f8775k, "####### onFinish: ");
        if (!(result == null || this.f8788G == null || result.f8467i != 0)) {
            this.f8788G.mo1714a(0);
        }
        if (!this.f8790r.m6351l()) {
            if (!this.f8782A) {
                return;
            }
            if (this.f8782A) {
                if (m9988c(result)) {
                    this.f8787F.f8332b.f8468j = 2;
                    return;
                }
                C2725h.m10207b(f8775k, "WakeUp need show dialog !");
                if (this.f8788G == null) {
                    this.f8790r.m10054a(false, null);
                } else if (this.f8788G.mo1716b()) {
                    this.f8790r.m10054a(false, null);
                }
            }
        }
        m10002a(101);
        C2847o.m10687a().m10775o();
        if (result == null) {
            m10037n();
            return;
        }
        C2725h.m10207b(f8775k, "onFinish type=" + result.f8464f.name());
        C2549b newResult = result;
        if (newResult.f8467i != 0) {
            m9989d(newResult);
        } else {
            this.f8794v = false;
        }
        this.f8790r.m10053a(newResult);
        m9992e(newResult);
    }

    /* renamed from: c */
    private boolean m9988c(C2549b result) {
        if (result == null) {
            C2725h.m10207b(f8775k, "####### onWakeUp Finish null ");
            return true;
        } else if (result.f8469k) {
            return false;
        } else {
            C2725h.m10207b(f8775k, "onWakeUp Finish: " + result.f8464f);
            switch (result.f8464f) {
                case TYPE_PHONE:
                case TYPE_IMAGE_SEARCH:
                case TYPE_NLP_MULTIMOVIE:
                case TYPE_NLP_WEATHER:
                case TYPE_NLP_STOCK:
                case TYPE_CARD_MOVIE:
                case TYPE_MUSIC:
                case TYPE_MUSIC_LIST:
                case TYPE_NEARBY:
                case TYPE_ROUTE:
                    return false;
                default:
                    m10002a(101);
                    C2847o.m10687a().m10771l();
                    if (result == null) {
                        m10037n();
                        return true;
                    }
                    C2549b newResult = result;
                    if (newResult.f8467i != 0) {
                        m9989d(newResult);
                    } else {
                        this.f8794v = false;
                    }
                    m9992e(newResult);
                    return true;
            }
        }
    }

    /* renamed from: d */
    private void m9989d(C2549b model) {
        C2725h.m10207b(f8775k, "processError: " + model.f8467i + ";mHasTryAgain:" + this.f8794v);
        switch (model.f8467i) {
            case 1:
            case 2:
            case 5001:
            case 5002:
            case 5003:
            case AsrError.ERROR_CLIENT_RESOLVE_URL /*5004*/:
            case AsrError.ERROR_CLIENT_NEED_HTTPS_URL /*5005*/:
                model.f8466h = C2539c.f8380v;
                model.f8465g = this.f8792t.getString(C0965R.string.xiaodu_is_uncomfortable);
                C2716c.m10144a(this.f8792t, C2536a.f8323x, "客户端错误");
                if (this.f8788G != null) {
                    this.f8788G.mo1714a(5);
                    break;
                }
                break;
            case 3:
            case 1001:
            case 1002:
            case 1003:
            case 1004:
            case 1005:
            case 1006:
            case 2000:
            case 2001:
            case 2002:
            case 2003:
            case 2004:
            case 2005:
            case 2006:
            case 2100:
            case AsrError.ERROR_NETWORK_NOT_GRANTED /*2101*/:
                model.f8466h = C2539c.f8374p;
                model.f8465g = this.f8792t.getString(C0965R.string.network_unavailble);
                C2716c.m10144a(this.f8792t, C2536a.f8323x, "网络错误");
                if (this.f8788G != null) {
                    this.f8788G.mo1714a(2);
                    break;
                }
                break;
            case 4:
            case 6:
            case AsrError.ERROR_AUDIO_VAD_NO_SPEECH /*3101*/:
            case 6001:
                if (!C2761c.m10463a().m10481f()) {
                    model.f8466h = C2539c.f8349Q;
                    model.f8465g = this.f8792t.getString(C0965R.string.no_hear_and_exit);
                    C2716c.m10144a(this.f8792t, C2536a.f8323x, "超时错误");
                    if (this.f8788G != null) {
                        this.f8788G.mo1714a(6);
                        break;
                    }
                }
                model.f8468j = 0;
                break;
                break;
            case 7:
                model.f8465g = "";
                model.f8468j = 1;
                C2725h.m10207b(f8775k, "--error 7---");
                C2716c.m10144a(this.f8792t, C2536a.f8323x, "无匹配错误");
                if (this.f8788G != null) {
                    this.f8788G.mo1714a(7);
                    break;
                }
                break;
            case 21:
                model.f8466h = C2539c.f8382x;
                model.f8465g = this.f8792t.getString(C0965R.string.error_no_position);
                C2716c.m10144a(this.f8792t, C2536a.f8323x, "定位错误");
                break;
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
                model.f8466h = C2539c.f8381w;
                model.f8465g = this.f8792t.getString(C0965R.string.microphone_using_by_other);
                model.f8468j = 2;
                C2716c.m10144a(this.f8792t, C2536a.f8323x, "麦克风错误");
                if (this.f8788G != null) {
                    this.f8788G.mo1714a(3);
                }
                this.f8794v = false;
                break;
            case 4001:
            case 4002:
            case 4004:
                if (this.f8794v) {
                    model.f8466h = C2539c.f8376r;
                    model.f8465g = this.f8792t.getString(C0965R.string.no_understand_quit);
                    model.f8468j = 2;
                    this.f8794v = false;
                } else {
                    model.f8466h = C2539c.f8375q;
                    model.f8465g = C1888b.m7226a();
                    model.f8468j = 2;
                    this.f8794v = false;
                }
                C2716c.m10144a(this.f8792t, C2536a.f8323x, "服务端错误");
                if (this.f8788G != null) {
                    this.f8788G.mo1714a(4);
                    break;
                }
                break;
            case AsrError.ERROR_ASR_ENGINE_BUSY /*8001*/:
                model.f8466h = C2539c.f8379u;
                model.f8465g = this.f8792t.getString(C0965R.string.xiaodu_is_busy_now);
                C2716c.m10144a(this.f8792t, C2536a.f8323x, "引擎忙错误");
                break;
            case 9001:
                model.f8466h = C2539c.f8378t;
                model.f8465g = this.f8792t.getString(C0965R.string.microphone_unavailable);
                C2716c.m10144a(this.f8792t, C2536a.f8323x, "无权限错误");
                if (this.f8788G != null) {
                    this.f8788G.mo1714a(9);
                    break;
                }
                break;
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
                if (this.f8794v) {
                    model.f8465g = this.f8792t.getString(C0965R.string.no_understand_quit);
                    model.f8466h = C2539c.f8376r;
                    model.f8468j = 2;
                    this.f8794v = false;
                } else {
                    model.f8466h = C2539c.f8375q;
                    if (C2727j.m10218a(this.f8792t)) {
                        model.f8465g = C1888b.m7226a();
                        model.f8468j = 1;
                        this.f8794v = true;
                        return;
                    }
                    model.f8465g = this.f8792t.getString(C0965R.string.network_unavailble);
                    model.f8468j = 2;
                    if (this.f8788G != null) {
                        this.f8788G.mo1714a(2);
                    }
                    this.f8794v = false;
                }
                C2716c.m10144a(this.f8792t, C2536a.f8323x, "服务端错误");
                break;
            default:
                model.f8466h = C2539c.f8375q;
                model.f8465g = C1888b.m7226a();
                break;
        }
        if (model.f8467i != 4 && model.f8467i != 7) {
            this.f8794v = false;
        }
    }

    /* renamed from: e */
    private void m9992e(C2549b model) {
        if (model.f8464f != C2695a.TYPE_NORMAL_ASK) {
            this.f8787F.m9629a(model);
            if (TextUtils.isEmpty(model.f8466h)) {
                C2543d.m9631a().m9634a(model.f8465g, this.f8787F);
            } else {
                C2543d.m9631a().m9637a(model, this.f8787F);
            }
        }
    }

    /* renamed from: d */
    public void mo1937d(String rawText) {
        if (this.f8790r.m6351l() && rawText != null && rawText.length() != 0) {
            this.f8797y = false;
            C2549b model = new C2549b();
            model.f8464f = C2695a.TYPE_NORMAL_ASK;
            model.f8465g = "\"" + rawText + "\"";
            this.f8790r.m10053a(model);
        }
    }

    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case 0:
            case 2:
                m10038o();
                break;
            case 1:
                m10037n();
                break;
        }
        return false;
    }

    /* renamed from: p */
    public void mo1944p() {
        if (this.f8790r == null) {
        }
    }

    /* renamed from: b */
    public void m10019b(C2549b model) {
        if (this.f8790r != null && this.f8790r.m6351l()) {
            this.f8790r.m10053a(model);
            m9992e(model);
        } else if (this.f8782A) {
            m9992e(model);
        }
    }

    /* renamed from: a */
    public void m10013a(String ttsContent, int state) {
        C2549b model = new C2549b();
        model.f8468j = state;
        model.f8465g = ttsContent;
        m10019b(model);
    }

    /* renamed from: q */
    public boolean m10040q() {
        return this.f8790r.m6351l();
    }

    /* renamed from: r */
    public boolean m10041r() {
        if (this.f8783B) {
            return this.f8795w;
        }
        return false;
    }

    /* renamed from: a */
    public void m10004a(C1889c carLifeControl) {
        this.f8788G = carLifeControl;
    }

    /* renamed from: a */
    public void m10006a(C2617a model) {
        if (model != null) {
            String param = String.format("{\"wechat_name\": \"%s\",\"wechat_id\": \"%s\"}", new Object[]{model.m9591a(), model.m9837c()});
            C2848p fakeWechatResult = new C2848p();
            fakeWechatResult.m10784a("wechat");
            fakeWechatResult.m10786b(C2848p.al);
            fakeWechatResult.m10788c(param);
            C2761c.m10463a().m10475b(C2761c.m10463a().m10466a(fakeWechatResult, (C2673m) this, this.f8792t));
            mo1930a(C2837c.STATE_WECHAT_RECEIVE_CONTENT);
            m10043t();
        }
    }

    /* renamed from: s */
    public C2837c mo1945s() {
        return this.f8789H;
    }

    /* renamed from: a */
    public void mo1930a(C2837c state) {
        this.f8789H = state;
    }

    /* renamed from: b */
    public void m10020b(C2837c state) {
        if (state == C2837c.STATE_SET_COMPANY || state == C2837c.STATE_SET_HOME || state == C2837c.STATE_WHERE_GOING) {
            mo1930a(state);
            m10043t();
        }
    }

    /* renamed from: b */
    private void m9986b(boolean wakeUp, String word, String mode) {
        C2725h.m10207b(f8775k, "showVrDialog: " + this.f8790r.m6351l());
        if (wakeUp) {
            C2725h.m10207b(f8775k, "wakeUp show: " + this.f8790r.m6351l());
            if (this.f8790r.m6351l()) {
                this.f8798z = 4;
                m10036m();
                C2549b modelWake = new C2549b();
                modelWake.f8465g = word;
                modelWake.f8464f = C2695a.TYPE_NORMAL_ASK;
                m10019b(modelWake);
            } else {
                this.f8798z = 1;
                if (this.f8788G != null) {
                    this.f8788G.mo1715a(word);
                }
            }
        } else if (this.f8790r.m6351l()) {
            return;
        }
        if (this.f8788G == null) {
            this.f8790r.m10054a(wakeUp, word);
        } else if (this.f8788G.mo1716b()) {
            this.f8790r.m10054a(wakeUp, word);
        }
        if ("weather".equals(mode)) {
            C2761c.m10463a().m10468a(this.f8792t.getString(C0965R.string.nlp_today_weather), (C2673m) this, this.f8792t);
        } else if ("music".equals(mode)) {
            C2761c.m10463a().m10468a("来首音乐", (C2673m) this, this.f8792t);
        } else if (mo1945s() == C2837c.STATE_WECHAT_RECEIVE_CONTENT) {
            m10013a(this.f8792t.getString(C0965R.string.wechat_command_please_say_content), 1);
        } else if (mo1945s() == C2837c.STATE_SET_COMPANY) {
            m10013a(this.f8792t.getString(C0965R.string.navi_command_set_company_address), 1);
        } else if (mo1945s() == C2837c.STATE_SET_HOME) {
            m10013a(this.f8792t.getString(C0965R.string.navi_command_set_home_address), 1);
        } else if (mo1945s() == C2837c.STATE_WHERE_GOING) {
            m10013a(this.f8792t.getString(C0965R.string.navi_command_set_where_going), 1);
        } else if (wakeUp || TextUtils.isEmpty(word)) {
            C2543d.m9631a().m9641e();
        } else {
            m10013a(word, 1);
        }
    }

    /* renamed from: x */
    private void m9999x() {
        if (this.f8788G != null) {
            C2847o.m10687a().m10775o();
            this.f8788G.mo1713a();
        }
        if (this.f8790r != null && this.f8790r.m6351l()) {
            this.f8790r.mo1526d();
            m10038o();
        }
        if (this.f8788G != null) {
            this.f8788G.mo1717c();
        } else {
            C2847o.m10687a().m10775o();
        }
        if (mo1945s() == C2837c.STATE_WECHAT_RECEIVE_CONTENT && this.f8788G != null) {
            this.f8788G.mo1718d();
        }
        mo1930a(C2837c.STATE_NORMAL);
        this.f8798z = 0;
        m10002a(101);
        if (this.f8784C != null) {
            this.f8784C.mo1964a();
            this.f8784C = null;
        }
        if (this.f8797y) {
            C2716c.m10143a(this.f8792t, C2536a.f8304e);
        }
    }

    /* renamed from: f */
    private void m9994f(String mode) {
        Intent intent = new Intent("com.baidu.codriver.action.START");
        intent.setData(Uri.parse("codriver://lanuch"));
        Bundle bundle = new Bundle();
        bundle.putString(NaviStatConstants.K_NSC_KEY_MODE_TYPE, mode);
        intent.putExtras(bundle);
        intent.setFlags(RoutePlanFailedSubType.ROUTEPLAN_RESULT_FAIL_PARSE_FAIL);
        this.f8792t.startActivity(intent);
    }

    /* renamed from: y */
    private void m10000y() {
        BaseActivity.m9906a(BaseActivity.m9907b());
    }

    /* renamed from: t */
    public void m10043t() {
        m10016a(false, null, null);
    }

    /* renamed from: a */
    public void m10015a(boolean wakeUp, String word) {
        m10016a(wakeUp, word, null);
    }

    /* renamed from: a */
    public void m10016a(boolean wakeUp, String word, String mode) {
        this.f8783B = true;
        if (!wakeUp || this.f8790r.m6351l()) {
            m9986b(wakeUp, word, mode);
            return;
        }
        this.f8782A = true;
        C2725h.m10207b(f8775k, "wake up no show dialog !");
        this.f8788G.mo1715a(word);
        C2537a.m9625a().m9627b();
        if (this.f8788G.mo1716b()) {
            C2543d.m9631a().m9641e();
        }
    }

    /* renamed from: a */
    public void mo1925a() {
        m10000y();
        m9999x();
        if (C1328h.m4757a().getNaviFragmentManager().getCurrentFragment() != null && (C1328h.m4757a().getNaviFragmentManager().getCurrentFragment() instanceof CarModeQuickRoutePlanFragment)) {
            ((CarModeQuickRoutePlanFragment) C1328h.m4757a().getNaviFragmentManager().getCurrentFragment()).updateListView();
        }
        if (this.f8782A) {
            if (this.f8788G != null) {
                C2847o.m10687a().m10775o();
                this.f8788G.mo1713a();
            }
            C2537a.m9625a().m9628c();
        }
        this.f8782A = false;
        this.f8783B = false;
    }

    /* renamed from: a */
    public void m10007a(BaseActivity activity) {
    }

    /* renamed from: e */
    public void m10028e(String mode) {
        m9986b(false, null, mode);
    }

    /* renamed from: b */
    public void m10022b(boolean bOpen) {
        if (bOpen) {
            C2510a.f8193j = 3;
        } else {
            C2510a.f8193j = 6;
        }
    }
}
