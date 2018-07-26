package com.baidu.che.codriver.vr;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.baidu.che.codriver.p123i.C2546c;
import com.baidu.che.codriver.p123i.C2547d;
import com.baidu.che.codriver.util.C2725h;
import com.baidu.che.codriver.util.C2731l;
import com.baidu.che.codriver.util.C2736p;
import com.baidu.che.codriver.vr.C2835k.C2831k;
import com.baidu.che.codriver.vr.record.C1749d;
import com.baidu.che.codriver.vr.record.aec.RecordHelper;
import com.baidu.che.codriver.vr.record.aec.RecordHelper.C2740c;
import com.baidu.che.codriver.vr.record.aec.RecordHelper.C2855a;
import com.baidu.che.codriver.vr.record.aec.RecordHelper.C2856b;
import com.baidu.speech.EventListener;
import com.baidu.speech.EventManager;
import com.baidu.speech.EventManagerFactory;
import com.baidu.speech.asr.SpeechConstant;
import com.baidu.speech.utils.LogUtil;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VoiceService extends Service {
    /* renamed from: a */
    private static final String f9003a = "CoDriverVoice-Service";
    /* renamed from: b */
    private static String f9004b;
    /* renamed from: c */
    private EventListener f9005c = null;
    /* renamed from: d */
    private EventManager f9006d = null;
    /* renamed from: e */
    private EventManager f9007e = null;
    /* renamed from: f */
    private EventManager f9008f = null;
    /* renamed from: g */
    private String f9009g = null;
    /* renamed from: h */
    private String f9010h = null;
    /* renamed from: i */
    private String f9011i = null;
    /* renamed from: j */
    private HashMap<String, Object> f9012j = null;
    /* renamed from: k */
    private HashMap<String, Object> f9013k = null;
    /* renamed from: l */
    private RecordHelper f9014l = null;
    /* renamed from: m */
    private boolean f9015m = false;
    /* renamed from: n */
    private boolean f9016n = false;
    /* renamed from: o */
    private boolean f9017o = true;
    /* renamed from: p */
    private boolean f9018p = false;
    /* renamed from: q */
    private boolean f9019q = false;
    /* renamed from: r */
    private boolean f9020r = true;
    /* renamed from: s */
    private boolean f9021s = false;
    /* renamed from: t */
    private boolean f9022t = false;
    /* renamed from: u */
    private String[] f9023u = null;
    /* renamed from: v */
    private String f9024v;
    /* renamed from: w */
    private int f9025w = C2546c.f8444n;
    /* renamed from: x */
    private String f9026x = "com.baidu.carlife";
    /* renamed from: y */
    private C2745b f9027y = new C2745b(this);

    /* renamed from: com.baidu.che.codriver.vr.VoiceService$1 */
    class C27391 implements EventListener {
        /* renamed from: a */
        final /* synthetic */ VoiceService f8997a;

        C27391(VoiceService this$0) {
            this.f8997a = this$0;
        }

        public void onEvent(String event, String param, byte[] arg2, int arg3, int arg4) {
            C2725h.m10207b(VoiceService.f9003a, "event:" + event + ", param:" + param);
        }
    }

    /* renamed from: com.baidu.che.codriver.vr.VoiceService$2 */
    class C27412 implements C2740c {
        /* renamed from: a */
        final /* synthetic */ VoiceService f8998a;

        C27412(VoiceService this$0) {
            this.f8998a = this$0;
        }

        /* renamed from: a */
        public void mo1951a(int newVolume) {
            Map config = new HashMap();
            config.put(C2546c.aC, Integer.valueOf(newVolume));
            this.f8998a.f9007e.send(C2546c.an, new JSONObject(config).toString(), null, 0, 0);
            C2725h.m10207b(VoiceService.f9003a, "---kwd.config----");
        }
    }

    /* renamed from: com.baidu.che.codriver.vr.VoiceService$a */
    public interface C2743a {
        /* renamed from: a */
        void mo1977a();
    }

    /* renamed from: com.baidu.che.codriver.vr.VoiceService$b */
    public class C2745b extends Binder {
        /* renamed from: a */
        final /* synthetic */ VoiceService f9002a;

        public C2745b(VoiceService this$0) {
            this.f9002a = this$0;
        }

        /* renamed from: a */
        public void m10274a(final C2743a listener) {
            new Thread(new Runnable(this) {
                /* renamed from: b */
                final /* synthetic */ C2745b f9001b;

                public void run() {
                    this.f9001b.f9002a.m10341c();
                    this.f9001b.f9002a.m10347e();
                    this.f9001b.f9002a.m10350f();
                    this.f9001b.f9002a.m10324a();
                    this.f9001b.f9002a.m10379s();
                    this.f9001b.f9002a.m10344d();
                    this.f9001b.f9002a.f9022t = true;
                    listener.mo1977a();
                }
            }).start();
        }

        /* renamed from: a */
        public int m10268a(EventListener listener) {
            if (this.f9002a.f9006d == null || this.f9002a.f9007e == null) {
                return -1;
            }
            this.f9002a.f9006d.registerListener(listener);
            this.f9002a.f9007e.registerListener(listener);
            this.f9002a.f9005c = listener;
            return 0;
        }

        /* renamed from: b */
        public int m10281b(EventListener listener) {
            this.f9002a.f9006d.unregisterListener(listener);
            return 0;
        }

        /* renamed from: a */
        public int m10266a() {
            return this.f9002a.m10361j();
        }

        /* renamed from: b */
        public int m10279b() {
            return this.f9002a.m10363k();
        }

        /* renamed from: c */
        public int m10285c() {
            return this.f9002a.m10365l();
        }

        /* renamed from: d */
        public int m10289d() {
            return this.f9002a.m10367m();
        }

        /* renamed from: e */
        public int m10293e() {
            return this.f9002a.m10369n();
        }

        /* renamed from: f */
        public void m10296f() {
            this.f9002a.m10373p();
        }

        @Deprecated
        /* renamed from: a */
        public int m10270a(String kwsFilePath, String resFilePath) {
            return -1;
        }

        /* renamed from: a */
        public int m10269a(String wakeupWord) {
            if (wakeupWord == null || (!wakeupWord.equals(C2546c.f8452v) && !wakeupWord.equals(C2546c.f8453w) && !wakeupWord.equals(C2546c.f8454x))) {
                return -1;
            }
            this.f9002a.f9023u = new String[1];
            this.f9002a.f9023u[0] = wakeupWord;
            return 0;
        }

        /* renamed from: a */
        public int m10271a(String[] wakeupWord) {
            if (wakeupWord == null || wakeupWord.length == 0 || wakeupWord.length > 3) {
                return -1;
            }
            int i = 0;
            while (i < wakeupWord.length) {
                if (!wakeupWord[i].equals(C2546c.f8452v) && !wakeupWord[i].equals(C2546c.f8453w) && !wakeupWord[i].equals(C2546c.f8454x)) {
                    return -1;
                }
                i++;
            }
            this.f9002a.f9023u = wakeupWord;
            return 0;
        }

        /* renamed from: g */
        public String m10298g() {
            String wpWords = "" + "小度小度";
            if (this.f9002a.f9023u != null) {
                for (String str : this.f9002a.f9023u) {
                    wpWords = wpWords + "," + str;
                }
            }
            return wpWords;
        }

        /* renamed from: a */
        public void m10276a(boolean useNLU) {
            this.f9002a.f9021s = useNLU;
            C2731l.m10231b(this.f9002a, C2546c.aB, useNLU);
            if (this.f9002a.f9022t) {
                this.f9002a.f9012j.put(C2546c.aB, Integer.valueOf(this.f9002a.f9021s ? 306 : 0));
            } else {
                this.f9002a.m10350f();
            }
        }

        /* renamed from: b */
        public void m10284b(boolean isOpen) {
            if (this.f9002a.f9017o != isOpen) {
                this.f9002a.f9017o = isOpen;
                C2731l.m10231b(this.f9002a, "wake_up", isOpen);
                C2725h.m10207b(VoiceService.f9003a, "command:setWakeUpFlag-isOpen:" + isOpen);
            }
        }

        /* renamed from: a */
        public void m10275a(JSONArray contact) {
            this.f9002a.m10330a(contact);
        }

        /* renamed from: b */
        public void m10283b(String singers, String songs) {
            this.f9002a.m10329a(singers, songs);
        }

        /* renamed from: c */
        public void m10288c(boolean flag) {
            m10292d(flag);
            m10295e(flag);
        }

        /* renamed from: d */
        public void m10292d(boolean flag) {
            this.f9002a.f9016n = flag;
            C2731l.m10231b(this.f9002a, C2546c.f8436f, flag);
        }

        /* renamed from: e */
        public void m10295e(boolean flag) {
            this.f9002a.f9015m = flag;
            C2731l.m10231b(this.f9002a, C2546c.f8437g, flag);
        }

        /* renamed from: b */
        public void m10282b(String path) {
            this.f9002a.f9024v = path;
            C2725h.m10207b(VoiceService.f9003a, "setPcmDataPath mSavePcmDataPath = " + this.f9002a.f9024v);
            C2731l.m10230b(this.f9002a, C2546c.f8438h, this.f9002a.m10377r());
        }

        @Deprecated
        /* renamed from: c */
        public void m10287c(String words) {
        }

        @Deprecated
        /* renamed from: h */
        public void m10300h() {
        }

        /* renamed from: a */
        public void m10272a(int scene) {
            this.f9002a.m10333b(scene);
        }

        /* renamed from: i */
        public void m10302i() {
            this.f9002a.m10371o();
        }

        /* renamed from: b */
        public int m10280b(int scene) {
            return this.f9002a.m10319a(scene);
        }

        /* renamed from: a */
        public int m10267a(C2855a type, C1749d tool) {
            switch (type) {
                case INSIDE_AEC_MIC_LEFT:
                case INSIDE_AEC_MIC_RIGHT:
                case INSIDE_RAW:
                case INSIDE_DSP_RAW:
                case OUTSIDE_RAW:
                case OUTSIDE_AEC_MIC_LEFT:
                case OUTSIDE_AEC_MIC_RIGHT:
                    this.f9002a.m10336b();
                    this.f9002a.f9014l.setRecordType(type, tool);
                    return 0;
                default:
                    return -1;
            }
        }

        /* renamed from: a */
        public void m10278a(byte[] micData, byte[] spkData) {
            if (this.f9002a.f9014l != null) {
                this.f9002a.f9014l.feedAudioBuffer(micData, spkData);
            }
        }

        /* renamed from: a */
        public void m10277a(byte[] rawData) {
            if (this.f9002a.f9014l != null) {
                this.f9002a.f9014l.feedAudioBuffer(rawData);
            }
        }

        /* renamed from: j */
        public void m10304j() {
            if (this.f9002a.f9014l != null) {
                this.f9002a.f9014l.startRecord();
            }
        }

        /* renamed from: c */
        public void m10286c(int type) {
            if (!this.f9002a.f9022t) {
                this.f9002a.m10350f();
            }
            this.f9002a.f9012j.put("audio.stream-type", Integer.valueOf(type));
        }

        /* renamed from: f */
        public void m10297f(boolean isSupport) {
            C2725h.m10207b(VoiceService.f9003a, "setSupportFullBargin : " + isSupport);
            this.f9002a.f9019q = isSupport;
            C2731l.m10231b(this.f9002a, "support_full_bargin", isSupport);
            if (this.f9002a.f9022t) {
                this.f9002a.m10354g();
            } else {
                this.f9002a.m10350f();
            }
        }

        /* renamed from: g */
        public void m10299g(boolean isEnable) {
            this.f9002a.f9018p = isEnable;
            Map oneshotMap = new HashMap();
            oneshotMap.put(SpeechConstant.WP_ONESHOT_ENABLE, Boolean.valueOf(isEnable));
            C2725h.m10207b(VoiceService.f9003a, "new setOneshotEnable mIsOneshotEnable = " + this.f9002a.f9018p);
            this.f9002a.f9007e.send(C2546c.an, new JSONObject(oneshotMap).toString(), null, 0, 0);
        }

        /* renamed from: h */
        public void m10301h(boolean isEnable) {
            this.f9002a.f9020r = isEnable;
            C2731l.m10231b(this.f9002a, "scene_command_key", isEnable);
            C2725h.m10207b(VoiceService.f9003a, "setSceneCmdEnable sceneCmdFlag = " + this.f9002a.f9020r);
        }

        /* renamed from: a */
        public void m10273a(long wakeupTime, String wpWords, int isOneShot, int wpBacktrackFrameLen) {
            C2725h.m10210c(VoiceService.f9003a, "isOneShot = " + isOneShot + ", wpBacktrackFrameLen=" + wpBacktrackFrameLen);
            if (isOneShot == 1) {
                this.f9002a.f9012j.put(SpeechConstant.ASR_PARAM_WAKEUP_STATUS, Integer.valueOf(1));
                this.f9002a.f9012j.put(SpeechConstant.ASR_PARAM_WAKEUP_WORDS, wpWords);
                this.f9002a.f9012j.put(SpeechConstant.ASR_PARAM_IS_ONESHOT, Integer.valueOf(isOneShot));
                this.f9002a.f9012j.put(SpeechConstant.ASR_PARAM_WAKEUP_BACKTRACKTIME, Integer.valueOf(wpBacktrackFrameLen));
                long backMillis = ((((wakeupTime - ((long) (wpBacktrackFrameLen * 10))) - 300) - 150) - 100) - 100;
                if (backMillis > 0) {
                    this.f9002a.f9012j.put("audio.mills", Long.valueOf(backMillis));
                }
            } else if (isOneShot == 0) {
                this.f9002a.f9012j.remove("audio.mills");
                this.f9002a.f9012j.put(SpeechConstant.ASR_PARAM_IS_ONESHOT, Integer.valueOf(0));
                this.f9002a.f9012j.put(SpeechConstant.ASR_PARAM_WAKEUP_STATUS, Integer.valueOf(0));
            }
        }

        /* renamed from: k */
        public void m10305k() {
            this.f9002a.f9012j.remove("audio.mills");
            this.f9002a.f9012j.put(SpeechConstant.ASR_PARAM_IS_ONESHOT, Integer.valueOf(0));
            this.f9002a.f9012j.put(SpeechConstant.ASR_PARAM_WAKEUP_STATUS, Integer.valueOf(0));
        }

        /* renamed from: l */
        public boolean m10306l() {
            return this.f9002a.f9017o;
        }

        /* renamed from: m */
        public boolean m10307m() {
            return this.f9002a.f9018p;
        }

        /* renamed from: n */
        public boolean m10308n() {
            return this.f9002a.f9015m;
        }

        /* renamed from: o */
        public boolean m10309o() {
            return this.f9002a.f9019q;
        }

        /* renamed from: p */
        public boolean m10310p() {
            return this.f9002a.f9016n;
        }

        /* renamed from: q */
        public boolean m10311q() {
            return this.f9002a.f9022t;
        }

        /* renamed from: r */
        public boolean m10312r() {
            return this.f9002a.f9020r;
        }

        /* renamed from: d */
        public void m10290d(int echoEnergy) {
            if (this.f9002a.f9014l != null) {
                this.f9002a.f9014l.setDspEchoEnergy(echoEnergy);
            }
        }

        /* renamed from: i */
        public void m10303i(boolean flag) {
            if (flag) {
                this.f9002a.f9012j.put(SpeechConstant.LOG_LEVEL, Integer.valueOf(6));
                LogUtil.setLogLevel(0);
                return;
            }
            this.f9002a.f9012j.put(SpeechConstant.LOG_LEVEL, Integer.valueOf(0));
            LogUtil.setLogLevel(7);
        }

        /* renamed from: e */
        public void m10294e(int pid) {
            this.f9002a.f9025w = pid;
            this.f9002a.f9012j.put("pid", Integer.valueOf(this.f9002a.f9025w));
        }

        /* renamed from: d */
        public void m10291d(String onlineKey) {
            this.f9002a.f9026x = onlineKey;
            this.f9002a.f9012j.put("key", this.f9002a.f9026x);
        }
    }

    public int onStartCommand(Intent intent, int flags, int startId) {
        C2725h.m10207b(f9003a, "-----onStartCommand-----");
        return 2;
    }

    public void onCreate() {
        super.onCreate();
        C2725h.m10207b(f9003a, "-----onCreate-----");
        startForeground(8888, new Notification());
        f9004b = getApplicationContext().getFilesDir().getAbsolutePath() + "/";
        C2725h.m10207b(f9003a, "mResDir : " + f9004b);
    }

    public IBinder onBind(Intent intent) {
        C2725h.m10214e(f9003a, "-----onBind------");
        return this.f9027y;
    }

    public void onDestroy() {
        super.onDestroy();
        C2725h.m10207b(f9003a, "-----onDestroy------");
    }

    /* renamed from: a */
    private void m10324a() {
        this.f9008f = EventManagerFactory.create(getApplicationContext(), C2546c.al);
        this.f9008f.registerListener(new C27391(this));
    }

    /* renamed from: b */
    private void m10336b() {
        if (this.f9014l == null) {
            this.f9014l = new RecordHelper();
            this.f9014l.init(this, new C27412(this));
        }
    }

    /* renamed from: c */
    private void m10341c() {
        C2725h.m10207b(f9003a, "---RESOURCES---START COPY-----");
        String sourceFileName = C2546c.f8424T;
        C2547d.m9652a(f9004b + sourceFileName);
        C2547d.m9650a(getApplicationContext(), sourceFileName, f9004b + sourceFileName);
        sourceFileName = C2546c.f8426V;
        C2547d.m9652a(f9004b + sourceFileName);
        C2547d.m9650a(getApplicationContext(), sourceFileName, f9004b + sourceFileName);
        sourceFileName = C2546c.f8427W;
        C2547d.m9652a(f9004b + sourceFileName);
        C2547d.m9650a(getApplicationContext(), sourceFileName, f9004b + sourceFileName);
        sourceFileName = C2546c.f8428X;
        C2547d.m9652a(f9004b + sourceFileName);
        C2547d.m9650a(getApplicationContext(), sourceFileName, f9004b + sourceFileName);
        sourceFileName = "WakeUp_Xiaodu.bin";
        C2547d.m9652a(f9004b + sourceFileName);
        C2547d.m9650a(getApplicationContext(), sourceFileName, f9004b + sourceFileName);
        sourceFileName = C2546c.f8429Y;
        C2547d.m9652a(f9004b + sourceFileName);
        C2547d.m9650a(getApplicationContext(), sourceFileName, f9004b + sourceFileName);
        C2725h.m10207b(f9003a, "---RESOURCES---END COPY-----");
    }

    /* renamed from: d */
    private void m10344d() {
        this.f9024v = C2731l.m10227a(getApplicationContext(), C2546c.f8438h, m10377r());
        if (TextUtils.isEmpty(this.f9024v)) {
            this.f9024v = m10377r();
        }
        C2725h.m10207b(f9003a, "initSaveDataParams mSavePcmDataPath = " + this.f9024v);
    }

    /* renamed from: e */
    private void m10347e() {
        if (this.f9007e == null) {
            this.f9007e = EventManagerFactory.create(getApplicationContext(), C2546c.am);
        }
        if (this.f9013k == null) {
            this.f9013k = new HashMap();
        }
        this.f9016n = C2731l.m10228a(getApplication(), C2546c.f8436f, false);
        this.f9020r = C2731l.m10228a(getApplication(), "scene_command_key", true);
        this.f9013k.put(SpeechConstant.SAMPLE_RATE, Integer.valueOf(16000));
        this.f9013k.put(C2546c.au, f9004b + C2546c.f8424T);
        this.f9013k.put(C2546c.av, f9004b + C2546c.f8428X);
        this.f9013k.put(SpeechConstant.WP_WORDS_FILE, f9004b + "WakeUp_Xiaodu.bin");
        this.f9013k.put(SpeechConstant.ACCEPT_AUDIO_VOLUME, Boolean.valueOf(false));
        this.f9013k.put(C2546c.aw, Integer.valueOf(3));
        this.f9013k.put(SpeechConstant.WP_KWD_ENABLE, Boolean.valueOf(true));
        this.f9013k.put(SpeechConstant.ASR_VAD_RES_FILE_PATH, f9004b + C2546c.f8429Y);
        this.f9017o = C2731l.m10228a(getApplication(), "wake_up", true);
        C2725h.m10207b(f9003a, "initWakeUpConfig mIsWakeUpEnable = " + this.f9017o);
    }

    /* renamed from: f */
    private void m10350f() {
        if (this.f9006d == null) {
            this.f9006d = EventManagerFactory.create(getApplicationContext(), C2546c.ak);
        }
        if (this.f9012j == null) {
            this.f9012j = new HashMap();
        } else {
            this.f9012j.clear();
        }
        this.f9012j.put(SpeechConstant.SLOT_DATA, new JSONObject());
        this.f9015m = C2731l.m10228a(getApplication(), C2546c.f8437g, false);
        this.f9019q = C2731l.m10228a(getApplicationContext(), "support_full_bargin", false);
        this.f9021s = C2731l.m10228a(getApplicationContext(), C2546c.aB, false);
        this.f9012j.put("pid", Integer.valueOf(this.f9025w));
        this.f9012j.put("key", this.f9026x);
        this.f9012j.put("url", C2546c.f8449s);
        this.f9012j.put(C2546c.ax, C2546c.f8445o);
        this.f9012j.put(SpeechConstant.NLU, "enable");
        this.f9012j.put(C2546c.aB, Integer.valueOf(this.f9021s ? 306 : 0));
        this.f9012j.put(SpeechConstant.VAD, "dnn");
        this.f9012j.put(C2546c.au, f9004b + C2546c.f8424T);
        this.f9012j.put(SpeechConstant.SOUND_SUCCESS, Integer.valueOf(C2831k.bdspeech_recognition_success));
        this.f9012j.put(SpeechConstant.ACCEPT_AUDIO_VOLUME, Boolean.valueOf(false));
        this.f9012j.put(SpeechConstant.VAD_SPEECH_THRESHOLD, Float.valueOf(0.25f));
        this.f9012j.put(SpeechConstant.VAD_MIN_SPEECH_THRESHOLD, Integer.valueOf(40));
        m10354g();
        this.f9012j.put(SpeechConstant.DECODER, Integer.valueOf(2));
        this.f9012j.put(SpeechConstant.VAD_SIL_THRESHOLD, Float.valueOf(0.15f));
        this.f9012j.put(C2546c.aG, Integer.valueOf(400));
        this.f9012j.put(SpeechConstant.ENABLE_EARLY_RETURN, Boolean.valueOf(true));
        this.f9012j.put(SpeechConstant.ASR_VAD_RES_FILE_PATH, f9004b + C2546c.f8429Y);
        this.f9012j.put(SpeechConstant.DEC_TYPE, Integer.valueOf(1));
        this.f9012j.put(C2546c.az, Boolean.valueOf(true));
        this.f9012j.put(SpeechConstant.SAMPLE_RATE, Integer.valueOf(16000));
        this.f9012j.put(C2546c.as, Boolean.valueOf(false));
        m10357h();
    }

    /* renamed from: g */
    private void m10354g() {
        if (this.f9019q) {
            this.f9012j.put(SpeechConstant.VAD_ENDPOINT_TIMEOUT, Integer.valueOf(0));
            this.f9012j.put(SpeechConstant.DECODER, Integer.valueOf(0));
            return;
        }
        this.f9012j.put(SpeechConstant.VAD_ENDPOINT_TIMEOUT, Integer.valueOf(C2546c.f8411G));
        this.f9012j.put(C2546c.aF, Integer.valueOf(50));
        this.f9012j.put(SpeechConstant.DECODER, Integer.valueOf(2));
    }

    /* renamed from: h */
    private void m10357h() {
        this.f9012j.put(SpeechConstant.ASR_OFFLINE_ENGINE_DAT_FILE_PATH, f9004b + C2546c.f8427W);
        this.f9012j.put(SpeechConstant.ASR_OFFLINE_ENGINE_GRAMMER_FILE_PATH, f9004b + C2546c.f8426V);
        this.f9012j.put(C2546c.aJ, Boolean.valueOf(false));
    }

    /* renamed from: i */
    private void m10360i() {
        if (this.f9012j != null) {
            try {
                JSONObject jsonObject = (JSONObject) this.f9012j.get(SpeechConstant.SLOT_DATA);
                if (jsonObject != null) {
                    jsonObject.put("words", new JSONArray());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Deprecated
    /* renamed from: a */
    private void m10328a(String words) {
        if (this.f9012j != null) {
            try {
                JSONObject jsonObject = (JSONObject) this.f9012j.get(SpeechConstant.SLOT_DATA);
                if (jsonObject.isNull("words")) {
                    jsonObject.put("words", new JSONArray());
                }
                JSONArray wordArray = jsonObject.getJSONArray("words");
                boolean isChanged = false;
                for (String tmp : words.split(",")) {
                    boolean isNeedAdd = true;
                    for (int i = 0; i < wordArray.length(); i++) {
                        if (tmp.equals(wordArray.getString(i))) {
                            isNeedAdd = false;
                            break;
                        }
                    }
                    if (isNeedAdd) {
                        wordArray.put(tmp);
                        isChanged = true;
                    }
                }
                if (isChanged) {
                    m10382t();
                    m10379s();
                }
                C2725h.m10207b(f9003a, "------------regCustomCmd:" + this.f9012j.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private void m10330a(JSONArray contact) {
        HashMap map = new HashMap();
        map.put("name", C2736p.f8992v);
        map.put("pid", "809");
        map.put("url", "http://upl.baidu.com/words/add");
        map.put("words", contact);
        C2725h.m10207b(f9003a, "upload contacts : contact = " + contact.toString());
        this.f9008f.send(SpeechConstant.UPLOADER_START, new JSONObject(map).toString(), null, 0, 0);
    }

    @Deprecated
    /* renamed from: a */
    private void m10329a(String singers, String songs) {
        this.f9010h = singers;
        this.f9011i = songs;
        HashMap<String, String> map = new HashMap();
        map.put("name", "songs");
        map.put("words", this.f9011i);
        this.f9008f.send(C2546c.ao, new JSONObject(map).toString(), null, 0, 0);
        m10375q();
    }

    /* renamed from: j */
    private int m10361j() {
        C2725h.m10207b(f9003a, "----startVrEngine-------mIsOneshotEnable = " + this.f9018p);
        if (!this.f9022t) {
            return -1;
        }
        if (this.f9014l == null || TextUtils.isEmpty(this.f9014l.getInfile())) {
            this.f9012j.remove(SpeechConstant.IN_FILE);
        } else {
            this.f9012j.put(SpeechConstant.IN_FILE, this.f9014l.getInfile());
            this.f9014l.reset();
            this.f9014l.setState(C2856b.STATE_BUSY_NORMAL);
        }
        if (this.f9015m) {
            C2725h.m10207b(f9003a, "startAsr mSavePcmDataPath = " + this.f9024v);
            if (TextUtils.isEmpty(this.f9024v)) {
                Toast.makeText(getApplicationContext(), "无法生成保存路径", 0).show();
            } else {
                this.f9012j.put(SpeechConstant.OUT_FILE, this.f9024v + "/" + new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + "#recog.pcm");
            }
        } else {
            this.f9012j.remove(SpeechConstant.OUT_FILE);
        }
        this.f9012j.put(SpeechConstant.ACCEPT_AUDIO_DATA, Boolean.valueOf(this.f9015m));
        long start = SystemClock.elapsedRealtime();
        this.f9006d.send(SpeechConstant.ASR_START, new JSONObject(this.f9012j).toString(), null, 0, 0);
        C2725h.m10207b(f9003a, "command:asr.start-The Time of loading VR DB :" + (SystemClock.elapsedRealtime() - start) + "ms");
        C2725h.m10207b(f9003a, "asr.start--config:" + this.f9012j.toString());
        return 0;
    }

    /* renamed from: k */
    private int m10363k() {
        if (this.f9006d == null) {
            return -1;
        }
        this.f9006d.send(SpeechConstant.ASR_STOP, null, null, 0, 0);
        C2725h.m10207b(f9003a, "command:asr.stop");
        return 0;
    }

    /* renamed from: l */
    private int m10365l() {
        if (this.f9006d == null) {
            return -1;
        }
        this.f9006d.send("asr.cancel", null, null, 0, 0);
        C2725h.m10207b(f9003a, "command:asr.cancel");
        return 0;
    }

    /* renamed from: m */
    private int m10367m() {
        if (this.f9017o && this.f9022t) {
            if (this.f9014l == null || TextUtils.isEmpty(this.f9014l.getInfile())) {
                this.f9013k.remove(SpeechConstant.IN_FILE);
            } else {
                this.f9013k.put(SpeechConstant.IN_FILE, this.f9014l.getInfile());
                this.f9014l.reset();
                this.f9014l.setState(C2856b.STATE_BUSY_WAKEUP);
                this.f9014l.startRecord();
            }
            if (this.f9016n) {
                C2725h.m10207b(f9003a, "startWp mSavePcmDataPath = " + this.f9024v);
                if (TextUtils.isEmpty(this.f9024v)) {
                    Toast.makeText(getApplicationContext(), "无法生成保存路径", 0).show();
                } else {
                    this.f9013k.put(SpeechConstant.OUT_FILE, this.f9024v + "/" + new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()) + "#wakeup.pcm");
                }
            } else {
                this.f9013k.remove(SpeechConstant.OUT_FILE);
            }
            this.f9013k.put(SpeechConstant.ACCEPT_AUDIO_DATA, Boolean.valueOf(this.f9016n));
            this.f9007e.send(SpeechConstant.WAKEUP_START, new JSONObject(this.f9013k).toString(), null, 0, 0);
            C2725h.m10207b(f9003a, "command:wp.start--config:" + this.f9013k.toString());
            return 0;
        }
        C2725h.m10214e(f9003a, "startWp wakeUpFlag = " + this.f9017o + " , initFlag = " + this.f9022t);
        return -1;
    }

    /* renamed from: a */
    private int m10319a(int sceneCmdType) {
        if (m10367m() == -1) {
            return -1;
        }
        return m10333b(sceneCmdType);
    }

    /* renamed from: n */
    private int m10369n() {
        if (this.f9007e == null) {
            return -1;
        }
        this.f9007e.send(SpeechConstant.WAKEUP_STOP, null, null, 0, 0);
        C2725h.m10207b(f9003a, "command:wp.stop");
        return 0;
    }

    /* renamed from: b */
    private int m10333b(int scene) {
        C2725h.m10207b(f9003a, "command:openSceneCmdInWaking type = " + scene);
        if (this.f9007e == null) {
            C2725h.m10207b(f9003a, "command:openSceneCmdInWaking wakeupManager is null");
            return -1;
        } else if (!this.f9020r) {
            C2725h.m10207b(f9003a, "command:openSceneCmdInWaking sceneCmdFlag is false");
            return -1;
        } else if ((scene & 3) == 0) {
            C2725h.m10207b(f9003a, "command:openSceneCmdInWaking. unknown type " + scene);
            return -1;
        } else {
            Map kwdMap = new HashMap();
            kwdMap.put(C2546c.aD, Integer.valueOf(0));
            JSONArray enableJsonArray = new JSONArray();
            m10338b(enableJsonArray);
            if ((scene & 1) != 0) {
                for (String cmd : C2546c.bn) {
                    enableJsonArray.put(cmd);
                }
            }
            if ((scene & 2) != 0) {
                for (String cmd2 : C2546c.bo) {
                    enableJsonArray.put(cmd2);
                }
            }
            Log.i(f9003a, "command:openSceneCmdInWaking type = " + scene + " , kwd array : " + enableJsonArray.toString());
            kwdMap.put(C2546c.aE, enableJsonArray);
            this.f9007e.send(C2546c.an, new JSONObject(kwdMap).toString(), null, 0, 0);
            return 0;
        }
    }

    /* renamed from: o */
    private int m10371o() {
        C2725h.m10207b(f9003a, "command:closeSceneCmd");
        if (this.f9007e == null) {
            C2725h.m10207b(f9003a, "command:closeSceneCmd wakeupManager is null");
            return -1;
        }
        Map kwdMap = new HashMap();
        kwdMap.put(C2546c.aD, Integer.valueOf(0));
        JSONArray enableJsonArray = new JSONArray();
        m10338b(enableJsonArray);
        kwdMap.put(C2546c.aE, enableJsonArray);
        this.f9007e.send(C2546c.an, new JSONObject(kwdMap).toString(), null, 0, 0);
        return 1;
    }

    /* renamed from: b */
    private void m10338b(JSONArray enableJsonArray) {
        enableJsonArray.put("小度小度");
        if (this.f9023u != null) {
            for (Object put : this.f9023u) {
                enableJsonArray.put(put);
            }
        }
    }

    /* renamed from: p */
    private void m10373p() {
        if (this.f9014l != null) {
            this.f9014l.release();
            this.f9014l = null;
        }
        this.f9022t = false;
    }

    /* renamed from: q */
    private void m10375q() {
        int i = 0;
        if (this.f9012j != null) {
            String strNames = this.f9009g + " ";
            String strSongs = this.f9010h + " ";
            String strSingers = this.f9010h + " ";
            JSONArray names = new JSONArray();
            for (String s : strNames.split(",")) {
                names.put(s.trim());
            }
            JSONArray singer = new JSONArray();
            for (String s2 : strSingers.split(",")) {
                singer.put(s2.trim());
            }
            JSONArray songs = new JSONArray();
            String[] split = strSongs.split(",");
            int length = split.length;
            while (i < length) {
                songs.put(split[i].trim());
                i++;
            }
            try {
                JSONObject jsonObject = (JSONObject) this.f9012j.get(SpeechConstant.SLOT_DATA);
                if (jsonObject != null) {
                    jsonObject.put("name", names).put("song", songs).put("singer", singer);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: r */
    private String m10377r() {
        File file = getExternalFilesDir("RecordData");
        if (file == null) {
            return null;
        }
        return file.getPath();
    }

    /* renamed from: s */
    private void m10379s() {
        if (m10383u() > 0) {
            C2725h.m10207b(f9003a, "--asr.kws.load-----start");
            this.f9006d.send(SpeechConstant.ASR_KWS_LOAD_ENGINE, new JSONObject(this.f9012j).toString(), null, 0, 0);
            C2725h.m10207b(f9003a, "--asr.kws.load-----end");
            C2725h.m10207b(f9003a, "--asr.kws.load-----config:" + this.f9012j.toString());
        }
    }

    /* renamed from: t */
    private void m10382t() {
        if (m10383u() > 0) {
            C2725h.m10207b(f9003a, "--asr.kws.unload-----start");
            this.f9006d.send(SpeechConstant.ASR_KWS_UNLOAD_ENGINE, null, null, 0, 0);
            C2725h.m10207b(f9003a, "--asr.kws.unload-----end");
        }
    }

    /* renamed from: u */
    private int m10383u() {
        return m10321a(C2546c.ay, m10321a(SpeechConstant.DECODER, -1));
    }

    /* renamed from: a */
    private int m10321a(String name, int defaultValue) {
        Object value = this.f9012j.get(name);
        return (value != null && (value instanceof Integer)) ? ((Integer) value).intValue() : defaultValue;
    }
}
