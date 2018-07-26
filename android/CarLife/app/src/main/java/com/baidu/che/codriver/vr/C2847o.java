package com.baidu.che.codriver.vr;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.Toast;
import com.baidu.che.codriver.p116b.C2519a;
import com.baidu.che.codriver.p123i.C2545b;
import com.baidu.che.codriver.p123i.C2546c;
import com.baidu.che.codriver.protocol.data.nlp.NLPResponseData;
import com.baidu.che.codriver.util.C2716c;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.util.C2727j;
import com.baidu.che.codriver.vr.C2820j.C2758a;
import com.baidu.che.codriver.vr.C2820j.C2819b;
import com.baidu.che.codriver.vr.C2851q.C2850a;
import com.baidu.che.codriver.vr.VoiceService.C2743a;
import com.baidu.che.codriver.vr.VoiceService.C2745b;
import com.baidu.che.codriver.vr.record.C1749d;
import com.baidu.che.codriver.vr.record.aec.RecordHelper.C2855a;
import com.baidu.speech.EventListener;
import com.baidu.speech.asr.SpeechConstant;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: VrManager */
/* renamed from: com.baidu.che.codriver.vr.o */
public class C2847o {
    /* renamed from: a */
    public static final String f9248a = "CoDriverVoice-Manager";
    /* renamed from: b */
    public static final int f9249b = 0;
    /* renamed from: c */
    public static final int f9250c = -1;
    /* renamed from: d */
    private static C2847o f9251d;
    /* renamed from: e */
    private static final Object f9252e = new Object();
    /* renamed from: f */
    private Context f9253f;
    /* renamed from: g */
    private C2745b f9254g;
    /* renamed from: h */
    private ServiceConnection f9255h;
    /* renamed from: i */
    private C2672h f9256i;
    /* renamed from: j */
    private HashMap<String, C2815d> f9257j;
    /* renamed from: k */
    private HashMap<String, Set<String>> f9258k;
    /* renamed from: l */
    private C2820j f9259l;
    /* renamed from: m */
    private C2758a f9260m;
    /* renamed from: n */
    private EventListener f9261n;
    /* renamed from: o */
    private int f9262o;
    /* renamed from: p */
    private C2851q f9263p;
    /* renamed from: q */
    private long f9264q;
    /* renamed from: r */
    private long f9265r;
    /* renamed from: s */
    private long f9266s;
    /* renamed from: t */
    private long f9267t;
    /* renamed from: u */
    private int f9268u;
    /* renamed from: v */
    private boolean f9269v;
    /* renamed from: w */
    private boolean f9270w;
    /* renamed from: x */
    private int f9271x;
    /* renamed from: y */
    private C2836l f9272y;
    /* renamed from: z */
    private Handler f9273z;

    /* compiled from: VrManager */
    /* renamed from: com.baidu.che.codriver.vr.o$a */
    public interface C1905a {
        /* renamed from: a */
        void mo1712a();
    }

    /* compiled from: VrManager */
    /* renamed from: com.baidu.che.codriver.vr.o$1 */
    class C28411 implements C2758a {
        /* renamed from: a */
        final /* synthetic */ C2847o f9240a;

        C28411(C2847o this$0) {
            this.f9240a = this$0;
        }

        /* renamed from: a */
        public void mo1968a(String rawText) {
            C2519a.m9554c(rawText);
            this.f9240a.f9256i.mo1934b(rawText);
        }

        /* renamed from: a */
        public void mo1967a(C2848p resultModel) {
            C2519a.m9547a(resultModel);
            this.f9240a.f9256i.mo1931a(resultModel);
        }

        /* renamed from: a */
        public void mo1966a(NLPResponseData nlpResponseData) {
            this.f9240a.f9256i.mo1927a(nlpResponseData);
        }
    }

    /* compiled from: VrManager */
    /* renamed from: com.baidu.che.codriver.vr.o$2 */
    class C28422 implements EventListener {
        /* renamed from: a */
        final /* synthetic */ C2847o f9241a;

        C28422(C2847o this$0) {
            this.f9241a = this$0;
        }

        public void onEvent(String event, String params, byte[] data, int offset, int length) {
            C2725h.m10207b(C2847o.f9248a, "-----asrListener---event:" + event + "---params:" + params);
            if ("wp.ready".equals(event)) {
                this.f9241a.m10700g(params);
            } else if ("wp.enter".equals(event)) {
                this.f9241a.m10702h(params);
            } else if ("wp.data".equals(event)) {
                this.f9241a.m10698f(params);
            } else if ("wp.error".equals(event)) {
                this.f9241a.m10704i(params);
            } else if ("wp.exit".equals(event)) {
                this.f9241a.m10708k(params);
            } else if (SpeechConstant.CALLBACK_EVENT_WAKEUP_ONESHOT.equals(event)) {
                this.f9241a.m10706j(params);
            } else if ("asr.ready".equals(event)) {
                this.f9241a.m10710l(params);
            } else if ("asr.begin".equals(event)) {
                this.f9241a.m10711m(params);
            } else if (!"asr.end".equals(event)) {
                if ("asr.partial".equals(event)) {
                    this.f9241a.m10713o(params);
                } else if ("asr.finish".equals(event)) {
                    this.f9241a.m10715q(params);
                } else if ("asr.exit".equals(event)) {
                    this.f9241a.m10716r(params);
                } else if ("asr.loaded".equals(event)) {
                    this.f9241a.m10717s(params);
                }
            }
        }
    }

    /* compiled from: VrManager */
    /* renamed from: com.baidu.che.codriver.vr.o$4 */
    class C28454 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C2847o f9245a;

        C28454(C2847o this$0) {
            this.f9245a = this$0;
        }

        public void run() {
            this.f9245a.m10725z();
        }
    }

    private C2847o() {
        this.f9253f = null;
        this.f9254g = null;
        this.f9255h = null;
        this.f9256i = null;
        this.f9257j = new HashMap();
        this.f9258k = new HashMap();
        this.f9259l = new C2820j(this.f9257j);
        this.f9260m = null;
        this.f9261n = null;
        this.f9262o = 0;
        this.f9263p = null;
        this.f9264q = 0;
        this.f9265r = 0;
        this.f9266s = 0;
        this.f9267t = 0;
        this.f9268u = -1;
        this.f9269v = false;
        this.f9270w = false;
        this.f9271x = 0;
        this.f9273z = new Handler();
        this.f9260m = new C28411(this);
        this.f9263p = new C2851q(this);
        this.f9261n = new C28422(this);
    }

    /* renamed from: a */
    public static C2847o m10687a() {
        if (f9251d == null) {
            synchronized (f9252e) {
                if (f9251d == null) {
                    f9251d = new C2847o();
                }
            }
        }
        return f9251d;
    }

    /* renamed from: a */
    public void m10730a(Context context, C2672h statusListener, final C1905a initVrEngineListener) {
        if (context == null) {
            C2725h.m10214e(f9248a, "--VR init failed---");
            return;
        }
        C2725h.m10207b(f9248a, "vr-sdk versionName = 1.1.1");
        this.f9253f = context;
        this.f9256i = statusListener;
        this.f9255h = new ServiceConnection(this) {
            /* renamed from: b */
            final /* synthetic */ C2847o f9244b;

            /* compiled from: VrManager */
            /* renamed from: com.baidu.che.codriver.vr.o$3$1 */
            class C28431 implements C2743a {
                /* renamed from: a */
                final /* synthetic */ C28443 f9242a;

                C28431(C28443 this$1) {
                    this.f9242a = this$1;
                }

                /* renamed from: a */
                public void mo1977a() {
                    this.f9242a.f9244b.f9254g.m10268a(this.f9242a.f9244b.f9261n);
                    initVrEngineListener.mo1712a();
                }
            }

            public void onServiceDisconnected(ComponentName name) {
            }

            public void onServiceConnected(ComponentName name, IBinder service) {
                C2725h.m10207b(C2847o.f9248a, "---onServiceConnected----name:" + name);
                this.f9244b.f9254g = (C2745b) service;
                this.f9244b.f9254g.m10274a(new C28431(this));
            }
        };
        this.f9253f.bindService(new Intent(this.f9253f, VoiceService.class), this.f9255h, 1);
        new Thread(new C28454(this)).start();
    }

    /* renamed from: a */
    public synchronized void m10732a(C2836l cmd) {
        if (this.f9254g != null) {
            this.f9254g.m10287c(cmd.m10666a());
            this.f9272y = cmd;
            C2725h.m10207b(f9248a, "--addCustomCmd-" + cmd.m10666a());
        }
    }

    /* renamed from: b */
    public synchronized void m10742b() {
        if (this.f9254g != null) {
            this.f9254g.m10300h();
            C2725h.m10207b(f9248a, "--clearCustomCmd-");
        }
    }

    /* renamed from: a */
    public synchronized boolean m10740a(String word) {
        boolean z;
        if (TextUtils.isEmpty(word)) {
            z = false;
        } else {
            z = false;
            if (this.f9272y != null && this.f9272y.m10667a(word)) {
                this.f9272y.m10668b(word);
                z = true;
            }
        }
        return z;
    }

    /* renamed from: a */
    public synchronized void m10735a(String pkg, String type, String words) {
        words = words.toLowerCase(Locale.ENGLISH);
        C2815d grammarModel = new C2815d();
        grammarModel.f9194a = C2848p.f9315p;
        grammarModel.f9195b = C2848p.f9298Y;
        if (type != null) {
            grammarModel.f9196c = pkg + "-" + type;
        } else {
            grammarModel.f9196c = pkg;
        }
        String[] keyWords = words.split(",");
        for (String keyWord : keyWords) {
            this.f9257j.put(keyWord, grammarModel);
        }
        if (this.f9258k.containsKey(pkg)) {
            ((Set) this.f9258k.get(pkg)).addAll(Arrays.asList(keyWords));
        } else {
            Set<String> wordSet = new HashSet();
            wordSet.addAll(Arrays.asList(keyWords));
            this.f9258k.put(pkg, wordSet);
        }
    }

    /* renamed from: a */
    public synchronized void m10734a(String pkg, String words) {
        synchronized (this) {
            for (String keyWord : words.toLowerCase(Locale.ENGLISH).split(",")) {
                C2815d grammarModel = (C2815d) this.f9257j.get(keyWord);
                if (grammarModel != null) {
                    String params = grammarModel.f9196c;
                    if (params != null && grammarModel.f9195b.equals(C2848p.f9298Y)) {
                        String[] pkgAndType = params.split("-");
                        if (pkgAndType != null && pkgAndType.length > 0 && pkg.equals(pkgAndType[0])) {
                            this.f9257j.remove(keyWord);
                            if (this.f9258k.containsKey(pkg)) {
                                ((Set) this.f9258k.get(pkg)).remove(keyWord);
                            }
                        }
                    }
                }
            }
        }
    }

    /* renamed from: b */
    public synchronized void m10743b(String pkg) {
        synchronized (this) {
            if (this.f9258k.containsKey(pkg)) {
                Set<String> wordSet = (Set) this.f9258k.get(pkg);
                if (wordSet != null) {
                    for (String keyWord : (String[]) wordSet.toArray(new String[0])) {
                        wordSet.remove(keyWord);
                        C2815d grammarModel = (C2815d) this.f9257j.get(keyWord);
                        if (grammarModel != null) {
                            String params = grammarModel.f9196c;
                            if (params != null && grammarModel.f9195b.equals(C2848p.f9298Y)) {
                                String[] pkgAndType = params.split("-");
                                if (pkgAndType != null && pkgAndType.length > 0 && pkg.equals(pkgAndType[0])) {
                                    this.f9257j.remove(keyWord);
                                }
                            }
                        }
                    }
                    this.f9258k.remove(pkg);
                }
            }
        }
    }

    /* renamed from: a */
    public int m10727a(C2855a type, C1749d tool) {
        C2725h.m10207b(f9248a, "--setRecordType-" + type.name());
        if (this.f9254g == null || !m10779s() || this.f9254g.m10267a(type, tool) == -1) {
            return -1;
        }
        this.f9263p.m10808g();
        return 0;
    }

    /* renamed from: a */
    public void m10739a(byte[] micData, byte[] spkData) {
        if (this.f9254g != null) {
            this.f9254g.m10278a(micData, spkData);
        }
    }

    /* renamed from: a */
    public void m10738a(byte[] rawData) {
        if (this.f9254g != null) {
            this.f9254g.m10277a(rawData);
        }
    }

    /* renamed from: c */
    public void m10749c() {
        if (this.f9254g != null) {
            this.f9254g.m10281b(this.f9261n);
        }
        if (!(this.f9253f == null || this.f9255h == null)) {
            this.f9253f.unbindService(this.f9255h);
        }
        this.f9254g = null;
        this.f9253f = null;
        f9251d = null;
    }

    /* renamed from: d */
    public boolean m10754d() {
        if (this.f9254g == null) {
            return false;
        }
        return this.f9254g.m10307m();
    }

    /* renamed from: f */
    private void m10698f(String params) {
        try {
            JSONObject wpResult = new JSONObject(params);
            if (wpResult.optInt("errorCode") == 0) {
                String word = wpResult.optString("word");
                if (!TextUtils.isEmpty(word) && m10719u().contains(word)) {
                    C2725h.m10207b(f9248a, "--------wp.data---------word:" + word);
                    this.f9271x = 0;
                    this.f9256i.mo1932a(word);
                    if (m10780t() == C2850a.VRSTATE_BUSY_ASR_WAKEUP && !this.f9269v) {
                        this.f9269v = true;
                        this.f9256i.mo1935c("");
                    }
                } else if (!TextUtils.isEmpty(word) && C2546c.bp.contains(word)) {
                    C2725h.m10207b(f9248a, "--------wp.data---------scene word:" + word);
                    if (m10780t() == C2850a.VRSTATE_BUSY_WAKEUP_SCENE_ALL || m10780t() == C2850a.VRSTATE_BUSY_WAKEUP_SCENE_MUSIC || m10780t() == C2850a.VRSTATE_BUSY_WAKEUP_SCENE_NAVI) {
                        m10740a(word);
                    } else {
                        return;
                    }
                }
                this.f9262o = wpResult.optInt("frameLen", -1);
                return;
            }
            Toast.makeText(this.f9253f, "唤醒出错了！", 0).show();
            C2725h.m10214e(f9248a, "----wp.data---errorCode:" + wpResult.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: g */
    private void m10700g(String params) {
        C2725h.m10207b(f9248a, "------wp.ready-------");
        this.f9267t = 0;
    }

    /* renamed from: h */
    private void m10702h(String params) {
        C2725h.m10207b(f9248a, "------wp.started-------");
        this.f9267t = 0;
    }

    /* renamed from: i */
    private void m10704i(final String params) {
        this.f9267t++;
        if (this.f9267t > 3) {
            Toast.makeText(this.f9253f, "唤醒出错了！", 0).show();
        } else {
            this.f9273z.postDelayed(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ C2847o f9247b;

                public void run() {
                    if (params.contains("Recorder open failed")) {
                        this.f9247b.f9263p.m10809h();
                        this.f9247b.m10763h();
                        return;
                    }
                    this.f9247b.m10763h();
                }
            }, 1000);
        }
    }

    /* renamed from: j */
    private void m10706j(String params) {
        try {
            this.f9268u = new JSONObject(params).optInt("oneshot", 0);
            C2725h.m10207b(f9248a, "oneshotState=" + this.f9268u);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (m10754d()) {
            this.f9254g.m10273a(System.currentTimeMillis(), "小度小度", this.f9268u, this.f9262o);
            if (this.f9268u == 1) {
                m10773m();
                m10721v();
            } else if (this.f9268u == 0) {
                this.f9256i.mo1933b(this.f9268u);
            }
        }
    }

    /* renamed from: k */
    private void m10708k(String params) {
        this.f9263p.m10803b();
    }

    /* renamed from: l */
    private void m10710l(String params) {
        C2725h.m10207b(f9248a, "--------asr.ready---------");
        this.f9256i.mo1941j();
        C2519a.m9551b();
        m10722w();
        this.f9269v = false;
    }

    /* renamed from: m */
    private void m10711m(String params) {
        C2725h.m10207b(f9248a, "---------asr.begin--------");
        C2519a.m9557e();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f9266s = elapsedRealtime;
        this.f9264q = elapsedRealtime;
        this.f9256i.mo1942k();
    }

    /* renamed from: n */
    private void m10712n(String params) {
        C2519a.m9553c();
        this.f9256i.mo1943l();
        this.f9266s = SystemClock.elapsedRealtime();
        C2725h.m10207b(f9248a, "----asr.end-time:" + (this.f9265r - this.f9264q) + "ms");
    }

    /* renamed from: o */
    private void m10713o(String params) {
        this.f9265r = SystemClock.elapsedRealtime();
        C2725h.m10207b(f9248a, "---asr.partial-time:" + (this.f9265r - this.f9264q) + "ms----result:" + params + "---asr.partial-time:  isAsrResultDealed = " + this.f9269v);
        if (this.f9269v) {
            C2725h.m10207b(f9248a, "onAsrPartial - isAsrResultDealed is true, do nothing");
            return;
        }
        try {
            JSONObject json = new JSONObject(params);
            JSONArray results;
            if (json.getString("result_type").equals("final_result")) {
                results = new JSONObject(params).optJSONArray("results_recognition");
                if (results != null && results.length() > 0) {
                    this.f9271x = 0;
                    C2519a.m9548a(params);
                    this.f9269v = true;
                    if (!m10714p(json.optString("best_result"))) {
                        C2819b c2819b;
                        params = C2545b.m9647a(params, results.getString(0));
                        C2820j c2820j = this.f9259l;
                        if (this.f9270w) {
                            c2819b = C2819b.ONLINE_MODE;
                        } else {
                            c2819b = C2819b.ONLINE_AND_OFFLINE_MODE;
                        }
                        c2820j.m10664a(params, c2819b, this.f9260m);
                    }
                }
            } else if (json.getString("result_type").equals("partial_result")) {
                results = new JSONObject(params).optJSONArray("results_recognition");
                String query = results.getString(0);
                if (results != null && results.length() > 0) {
                    this.f9256i.mo1935c(query);
                }
            }
            this.f9265r = SystemClock.elapsedRealtime();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: p */
    private boolean m10714p(String result) {
        if (this.f9263p.m10802a() != C2850a.VRSTATE_BUSY_ASR_WAKEUP || !"小度小度".equals(result)) {
            return false;
        }
        C2725h.m10207b(f9248a, "--recognization contains wakeup words--");
        return true;
    }

    /* renamed from: q */
    private void m10715q(String params) {
        this.f9265r = SystemClock.elapsedRealtime();
        C2725h.m10207b(f9248a, "----------asr.finish-time:" + (this.f9265r - this.f9264q) + "ms-----result:" + params + " , isSupportFullBargin = " + m10776p() + " , isAsrResultDealed = " + this.f9269v);
        if (m10718t(params)) {
            C2725h.m10207b(f9248a, "------asr.finish , VRTestUtils.onVrFinish");
            C2519a.m9548a(params);
            C2725h.m10207b(f9248a, "1Offline engine recognize fail restartAsr mRestartVrTime = " + this.f9271x);
            if (params.contains("Offline engine recognize fail") && C2727j.m10218a(this.f9253f)) {
                int i = this.f9271x;
                this.f9271x = i + 1;
                if (i < 1) {
                    m10773m();
                    return;
                }
            }
            this.f9271x = 0;
            m10712n(null);
            this.f9259l.m10664a(params, this.f9270w ? C2819b.ONLINE_MODE : C2819b.ONLINE_AND_OFFLINE_MODE, this.f9260m);
            this.f9269v = true;
            if (params.contains("Recorder open failed")) {
                this.f9263p.m10810i();
            }
        } else if (this.f9269v) {
            this.f9271x = 0;
            m10712n(null);
            C2725h.m10207b(f9248a, "---------asr.finish , do nothing");
        } else {
            this.f9271x = 0;
            m10712n(null);
            C2725h.m10207b(f9248a, "---------asr.finish , full bargin start record animation.");
            m10773m();
        }
    }

    /* renamed from: r */
    private void m10716r(String params) {
        C2725h.m10207b(f9248a, "------asr.exit-------");
        this.f9263p.m10804c();
        this.f9269v = false;
    }

    /* renamed from: s */
    private void m10717s(String params) {
        C2725h.m10207b(f9248a, "------asr.loaded-------");
    }

    /* renamed from: t */
    private boolean m10718t(String params) {
        if (this.f9269v || params.contains("\"error\":0,")) {
            return false;
        }
        if (m10776p()) {
            if (params.contains("\"sub_error\":3101") || params.contains("\"error\":7,") || params.contains("\"error\":7}") || params.contains("\"error\":8,")) {
                return false;
            }
            if (params.contains("\"error\":10,") && C2727j.m10218a(this.f9253f)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: e */
    protected int m10755e() {
        if (m10779s()) {
            return this.f9254g.m10266a();
        }
        return -1;
    }

    /* renamed from: a */
    public int m10728a(boolean isNeedRestart) {
        if (!m10779s()) {
            return -1;
        }
        if (!isNeedRestart) {
            this.f9271x = 1;
        }
        return this.f9254g.m10279b();
    }

    /* renamed from: f */
    protected int m10759f() {
        if (m10779s()) {
            return this.f9254g.m10285c();
        }
        return -1;
    }

    /* renamed from: a */
    protected int m10726a(int scene) {
        if (m10779s()) {
            return this.f9254g.m10280b(scene);
        }
        return -1;
    }

    /* renamed from: b */
    protected int m10741b(int scene) {
        if (!m10779s()) {
            return -1;
        }
        this.f9254g.m10272a(scene);
        return 0;
    }

    /* renamed from: g */
    protected int m10761g() {
        if (!m10779s()) {
            return -1;
        }
        this.f9254g.m10302i();
        return 0;
    }

    /* renamed from: h */
    protected int m10763h() {
        if (m10779s()) {
            return this.f9254g.m10289d();
        }
        return -1;
    }

    /* renamed from: i */
    protected int m10765i() {
        if (m10779s()) {
            return this.f9254g.m10293e();
        }
        return -1;
    }

    /* renamed from: u */
    private String m10719u() {
        if (m10779s()) {
            return this.f9254g.m10298g();
        }
        return "小度小度";
    }

    /* renamed from: v */
    private int m10721v() {
        if (!m10779s() || !m10754d()) {
            return -1;
        }
        this.f9254g.m10305k();
        return 0;
    }

    /* renamed from: w */
    private int m10722w() {
        if (!m10779s()) {
            return -1;
        }
        this.f9254g.m10304j();
        return 0;
    }

    /* renamed from: j */
    public boolean m10768j() {
        return m10779s();
    }

    /* renamed from: k */
    public int m10769k() {
        return this.f9263p.m10805d();
    }

    /* renamed from: l */
    public int m10771l() {
        return this.f9263p.m10806e();
    }

    /* renamed from: m */
    public int m10773m() {
        return this.f9263p.m10807f();
    }

    /* renamed from: n */
    public int m10774n() {
        return this.f9263p.m10801a(3);
    }

    /* renamed from: o */
    public int m10775o() {
        if (!m10779s()) {
            return -1;
        }
        if (this.f9254g.m10312r() && this.f9254g.m10306l()) {
            return this.f9263p.m10801a(3);
        }
        if (this.f9254g.m10306l()) {
            return this.f9263p.m10806e();
        }
        return this.f9263p.m10805d();
    }

    /* renamed from: x */
    private int m10723x() {
        return this.f9263p.m10801a(1);
    }

    /* renamed from: y */
    private int m10724y() {
        return this.f9263p.m10801a(2);
    }

    /* renamed from: a */
    public void m10733a(String query, C2758a callback) {
        m10736a(null, query, callback);
    }

    /* renamed from: a */
    public void m10736a(Map<String, Map> map, String query, C2758a callback) {
        this.f9259l.m10665a((Map) map, query, callback);
    }

    /* renamed from: a */
    public void m10731a(C2813i interceptor) {
        this.f9259l.m10662a(interceptor);
    }

    /* renamed from: b */
    public void m10744b(String kwsFilePath, String resFilePath) {
    }

    /* renamed from: c */
    public int m10747c(String wakeUpWord) {
        if (!m10779s()) {
            return -1;
        }
        C2725h.m10207b(f9248a, "----openWakeupWord----" + wakeUpWord.toString());
        if (this.f9254g.m10269a(wakeUpWord) == -1) {
            return -1;
        }
        this.f9263p.m10808g();
        return 0;
    }

    /* renamed from: a */
    public int m10729a(String[] wakeUpWords) {
        if (!m10779s()) {
            return -1;
        }
        C2725h.m10207b(f9248a, "----openWakeupWord----" + wakeUpWords.toString());
        if (this.f9254g.m10271a(wakeUpWords) == -1) {
            return -1;
        }
        this.f9263p.m10808g();
        return 0;
    }

    /* renamed from: b */
    public void m10745b(boolean useNLU) {
        if (m10779s()) {
            C2725h.m10207b(f9248a, "--setUseNLU----" + useNLU);
            this.f9254g.m10276a(useNLU);
        }
    }

    /* renamed from: a */
    public void m10737a(JSONArray contact) {
        if (m10779s()) {
            this.f9254g.m10275a(contact);
        }
    }

    /* renamed from: c */
    public void m10750c(String singers, String songs) {
        if (m10779s()) {
            this.f9254g.m10283b(singers, songs);
        }
    }

    /* renamed from: c */
    public int m10748c(boolean isEnable) {
        if (isEnable) {
            return m10775o();
        }
        return m10769k();
    }

    /* renamed from: d */
    public int m10752d(boolean isOpen) {
        if (!m10779s()) {
            return -1;
        }
        this.f9254g.m10284b(isOpen);
        if (isOpen) {
            m10775o();
        } else {
            m10769k();
        }
        return 0;
    }

    /* renamed from: e */
    public void m10758e(boolean flag) {
        this.f9270w = flag;
    }

    /* renamed from: f */
    public int m10760f(boolean flag) {
        if (!m10779s()) {
            return -1;
        }
        this.f9254g.m10288c(flag);
        return 0;
    }

    /* renamed from: g */
    public int m10762g(boolean flag) {
        if (!m10779s()) {
            return -1;
        }
        this.f9254g.m10292d(flag);
        return 0;
    }

    /* renamed from: h */
    public int m10764h(boolean flag) {
        if (!m10779s()) {
            return -1;
        }
        this.f9254g.m10295e(flag);
        return 0;
    }

    /* renamed from: i */
    public int m10766i(boolean flag) {
        if (!m10779s()) {
            return -1;
        }
        this.f9254g.m10303i(flag);
        return 0;
    }

    /* renamed from: c */
    public int m10746c(int type) {
        if (!m10779s()) {
            return -1;
        }
        this.f9254g.m10286c(type);
        return 0;
    }

    /* renamed from: j */
    public int m10767j(boolean isSupport) {
        if (!m10779s()) {
            return -1;
        }
        this.f9254g.m10297f(isSupport);
        return 0;
    }

    /* renamed from: p */
    public boolean m10776p() {
        if (m10779s()) {
            return this.f9254g.m10309o();
        }
        return false;
    }

    /* renamed from: k */
    public int m10770k(boolean isEnable) {
        if (!m10779s()) {
            return -1;
        }
        this.f9254g.m10299g(isEnable);
        return 0;
    }

    /* renamed from: q */
    public boolean m10777q() {
        if (m10779s()) {
            return this.f9254g.m10306l();
        }
        return false;
    }

    /* renamed from: l */
    public int m10772l(boolean isSupport) {
        if (!m10779s()) {
            return -1;
        }
        this.f9254g.m10301h(isSupport);
        return 0;
    }

    /* renamed from: r */
    public boolean m10778r() {
        if (m10779s()) {
            return this.f9254g.m10312r();
        }
        return false;
    }

    /* renamed from: s */
    public boolean m10779s() {
        if (this.f9254g == null) {
            C2725h.m10214e(f9248a, "isWakeUpEnable mBinder = null");
            return false;
        } else if (this.f9254g.m10311q()) {
            return true;
        } else {
            C2725h.m10214e(f9248a, "vrEngine has not inited yet.");
            return false;
        }
    }

    /* renamed from: t */
    public C2850a m10780t() {
        return this.f9263p.m10802a();
    }

    /* renamed from: z */
    private void m10725z() {
        C2725h.m10207b(f9248a, "--readGrammarFile-START-----");
        InputStream inputStream = C2716c.m10141a().getResources().getAssets().open("libgram_codriver");
        BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            String line = bfr.readLine();
            if (line == null) {
                break;
            }
            line = line.replace(" ", "");
            int index = line.indexOf(".");
            if (index < 0) {
                C2725h.m10214e(f9248a, "--readGrammarFile-not match grammar1-----");
            } else {
                String domain = line.substring(0, index);
                String[] strings2 = line.substring(index + 1).split("=");
                if (strings2 == null || strings2.length != 2) {
                    C2725h.m10214e(f9248a, "--readGrammarFile-not match grammar2-----");
                } else {
                    String[] strings3 = strings2[0].split("__");
                    if (strings3 != null && strings3.length > 0) {
                        JSONObject json = new JSONObject();
                        String intent = strings3[0];
                        if (strings3.length == 3) {
                            try {
                                json.put(strings3[1], strings3[2]);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        try {
                            String params = json.toString();
                            String[] keyWords = strings2[1].split(",");
                            C2815d grammar = new C2815d();
                            grammar.f9194a = domain;
                            grammar.f9195b = intent;
                            grammar.f9196c = params;
                            for (String keyWord : keyWords) {
                                this.f9257j.put(keyWord, grammar);
                            }
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        return;
                    }
                }
            }
        }
        bfr.close();
        inputStream.close();
        C2725h.m10207b(f9248a, "--readGrammarFile-END-----");
    }

    /* renamed from: d */
    public void m10753d(int echoEnergy) {
        if (this.f9254g != null) {
            this.f9254g.m10290d(echoEnergy);
        }
    }

    /* renamed from: d */
    public int m10751d(String path) {
        C2725h.m10207b(f9248a, "setPcmDataPath path = " + path);
        if (!m10779s() || TextUtils.isEmpty(path) || !m10720u(path)) {
            return -1;
        }
        this.f9254g.m10282b(path);
        return 0;
    }

    /* renamed from: u */
    private boolean m10720u(String strFolder) {
        File file = new File(strFolder);
        if (file.exists() || file.mkdirs()) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public void m10756e(int pid) {
        if (this.f9254g != null) {
            this.f9254g.m10294e(pid);
        }
    }

    /* renamed from: e */
    public void m10757e(String key) {
        if (this.f9254g != null) {
            this.f9254g.m10291d(key);
        }
    }
}
