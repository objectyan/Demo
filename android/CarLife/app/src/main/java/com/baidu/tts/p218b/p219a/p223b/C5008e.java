package com.baidu.tts.p218b.p219a.p223b;

import android.text.TextUtils;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.auth.C4974a;
import com.baidu.tts.auth.C4978b.C4976a;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine.OnNewDataListener;
import com.baidu.tts.p225m.C5005d;
import com.baidu.tts.p225m.C5142e;
import com.baidu.tts.p225m.C5143f;
import com.baidu.tts.p225m.C5144g;
import com.baidu.tts.p225m.C5145h;
import com.baidu.tts.p225m.C5146i;
import com.baidu.tts.p232e.C5078c;
import com.baidu.tts.p233f.C5080a;
import com.baidu.tts.p233f.C5086d;
import com.baidu.tts.p233f.C5088f;
import com.baidu.tts.p233f.C5097n;
import com.baidu.tts.p236h.p237a.C5105c;
import com.baidu.tts.p236h.p238b.C5107b;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.ResourceTools;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: OfflineSynthesizer */
/* renamed from: com.baidu.tts.b.a.b.e */
public class C5008e extends C4996a {
    /* renamed from: b */
    private C5006b f20741b;
    /* renamed from: c */
    private long[] f20742c = new long[1];
    /* renamed from: d */
    private C5078c f20743d;

    /* compiled from: OfflineSynthesizer */
    /* renamed from: com.baidu.tts.b.a.b.e$a */
    private class C5002a implements Runnable {
        /* renamed from: a */
        final /* synthetic */ C5008e f20722a;
        /* renamed from: b */
        private int f20723b;

        public C5002a(C5008e c5008e, int i) {
            this.f20722a = c5008e;
            this.f20723b = i;
        }

        public void run() {
            try {
                synchronized (this.f20722a.f20743d) {
                    if (this.f20722a.f20743d != null) {
                        this.f20722a.f20743d.m17236a(System.currentTimeMillis(), this.f20723b, 0, 0, "");
                    }
                }
            } catch (Exception e) {
                LoggerProxy.m17001d("OfflineSynthesizer", "AddPVResultsToDB exception=" + e.toString());
            }
        }
    }

    /* compiled from: OfflineSynthesizer */
    /* renamed from: com.baidu.tts.b.a.b.e$b */
    public static class C5006b extends C5005d<C5006b> {
        /* renamed from: a */
        private String f20730a = "0";
        /* renamed from: b */
        private String f20731b = "0";
        /* renamed from: c */
        private String f20732c = "0";
        /* renamed from: d */
        private String f20733d;
        /* renamed from: e */
        private String f20734e;
        /* renamed from: f */
        private String f20735f;
        /* renamed from: g */
        private String f20736g;

        /* renamed from: a */
        public int m16788a(String str) {
            if (!DataTool.isLong(str)) {
                return C5097n.TTS_PARAMETER_INVALID.m17284b();
            }
            this.f20730a = str;
            return 0;
        }

        /* renamed from: b */
        public void m16791b(String str) {
            this.f20731b = str;
        }

        /* renamed from: c */
        public int m16792c(String str) {
            if (!DataTool.isLong(str)) {
                return C5097n.TTS_PARAMETER_INVALID.m17284b();
            }
            this.f20732c = str;
            return 0;
        }

        /* renamed from: a */
        public long m16789a() {
            long j = 0;
            try {
                j = Long.parseLong(this.f20730a);
            } catch (Exception e) {
            }
            return j;
        }

        /* renamed from: b */
        public long m16790b() {
            long j = 0;
            try {
                j = Long.parseLong(this.f20731b);
            } catch (Exception e) {
            }
            return j;
        }

        /* renamed from: c */
        public long m16793c() {
            long j = 0;
            try {
                j = Long.parseLong(this.f20732c);
            } catch (Exception e) {
            }
            return j;
        }

        /* renamed from: d */
        public String m16794d() {
            return this.f20733d;
        }

        /* renamed from: d */
        public void m16795d(String str) {
            this.f20733d = str;
        }

        /* renamed from: e */
        public String m16796e() {
            return this.f20734e;
        }

        /* renamed from: e */
        public void m16797e(String str) {
            this.f20734e = str;
        }

        /* renamed from: f */
        public String m16798f() {
            return this.f20735f;
        }

        /* renamed from: f */
        public void m16799f(String str) {
            this.f20735f = str;
        }

        /* renamed from: g */
        public String m16800g() {
            return this.f20736g;
        }

        /* renamed from: g */
        public void m16801g(String str) {
            this.f20736g = str;
        }
    }

    /* compiled from: OfflineSynthesizer */
    /* renamed from: com.baidu.tts.b.a.b.e$c */
    private class C5007c implements OnNewDataListener, Callable<TtsError> {
        /* renamed from: a */
        ExecutorService f20737a = Executors.newCachedThreadPool();
        /* renamed from: b */
        final /* synthetic */ C5008e f20738b;
        /* renamed from: c */
        private C5146i f20739c;
        /* renamed from: d */
        private int f20740d = 0;

        public /* synthetic */ Object call() throws Exception {
            return m16802a();
        }

        public C5007c(C5008e c5008e, C5146i c5146i) {
            this.f20738b = c5008e;
            this.f20739c = c5146i;
        }

        public int onNewData(byte[] audioData, int progress) {
            C5145h b = C5145h.m17416b(this.f20739c);
            b.m17432e(C5088f.OFFLINE.m17271a());
            b.m17420a(C5080a.PCM);
            b.m17424a(audioData);
            b.m17429d(progress);
            this.f20740d++;
            b.m17426b(this.f20740d);
            this.f20738b.m16738a(b);
            if (!Thread.currentThread().isInterrupted()) {
                return 0;
            }
            LoggerProxy.m17001d("OfflineSynthesizer", "interrupted to interrupt syn");
            return -1;
        }

        /* renamed from: a */
        public TtsError m16802a() throws Exception {
            C4976a a = C4974a.m16566a().m16573a(this.f20738b.f20741b);
            if (a == null) {
                return C5105c.m17295a().m17302b(C5097n.OFFLINE_ENGINE_AUTH_NULL);
            }
            if (!a.mo3801g()) {
                return a.m16581b();
            }
            LoggerProxy.m17001d("OfflineSynthesizer", "engineResult = " + EmbeddedSynthesizerEngine.bdTTSSetParam(this.f20738b.f20742c[0], 0, 0));
            EmbeddedSynthesizerEngine.bdTTSSetParam(this.f20738b.f20742c[0], 5, this.f20738b.f20741b.m16786y());
            EmbeddedSynthesizerEngine.bdTTSSetParam(this.f20738b.f20742c[0], 6, this.f20738b.f20741b.m16787z());
            EmbeddedSynthesizerEngine.bdTTSSetParam(this.f20738b.f20742c[0], 7, this.f20738b.f20741b.m16771A());
            EmbeddedSynthesizerEngine.bdTTSSetParam(this.f20738b.f20742c[0], 18, this.f20738b.f20741b.m16789a());
            EmbeddedSynthesizerEngine.bdTTSSetParam(this.f20738b.f20742c[0], 19, this.f20738b.f20741b.m16790b());
            EmbeddedSynthesizerEngine.bdTTSSetParam(this.f20738b.f20742c[0], 20, this.f20738b.f20741b.m16793c());
            EmbeddedSynthesizerEngine.bdTTSSetParam(this.f20738b.f20742c[0], 10, this.f20738b.f20741b.m16782u());
            EmbeddedSynthesizerEngine.setOnNewDataListener(this);
            this.f20739c.m17441c(C5086d.GBK.m17269a());
            byte[] e = this.f20739c.m17444e();
            LoggerProxy.m17001d("OfflineSynthesizer", "before bdttssynthesis");
            int bdTTSSynthesis = EmbeddedSynthesizerEngine.bdTTSSynthesis(this.f20738b.f20742c[0], e, e.length);
            LoggerProxy.m17001d("OfflineSynthesizer", "after bdttssynthesis result = " + bdTTSSynthesis);
            try {
                this.f20737a.execute(new C5002a(this.f20738b, bdTTSSynthesis));
            } catch (Exception e2) {
                LoggerProxy.m17001d("OfflineSynthesizer", "AddPVResultsToDB start exception=" + e2.toString());
            }
            if (bdTTSSynthesis == 0) {
                return null;
            }
            return C5105c.m17295a().m17296a(C5097n.OFFLINE_ENGINE_SYNTHESIZE_ERROR, bdTTSSynthesis);
        }
    }

    /* renamed from: a */
    public <OfflineSynthesizerParams> void mo3846a(OfflineSynthesizerParams offlineSynthesizerParams) {
        this.f20741b = (C5006b) offlineSynthesizerParams;
    }

    /* renamed from: a */
    public TtsError mo3843a() {
        try {
            this.f20743d = C5078c.m17232a(C5107b.m17306a().m17316h());
        } catch (Exception e) {
            LoggerProxy.m17001d("OfflineSynthesizer", "embedded statistics open exception=" + e.toString());
        }
        if (this.f20741b == null) {
            this.f20741b = new C5006b();
        }
        C4976a a = C4974a.m16566a().m16573a(this.f20741b);
        if (!a.mo3801g()) {
            return a.m16581b();
        }
        String d = this.f20741b.m16794d();
        String e2 = this.f20741b.m16796e();
        byte[] stringToByteArrayAddNull = ResourceTools.stringToByteArrayAddNull(d);
        byte[] stringToByteArrayAddNull2 = ResourceTools.stringToByteArrayAddNull(e2);
        LoggerProxy.m17001d("OfflineSynthesizer", "before bdTTSEngineInit");
        int bdTTSEngineInit = EmbeddedSynthesizerEngine.bdTTSEngineInit(stringToByteArrayAddNull, stringToByteArrayAddNull2, this.f20742c);
        LoggerProxy.m17001d("OfflineSynthesizer", "engine init ret = " + bdTTSEngineInit);
        if (bdTTSEngineInit == 0) {
            return null;
        }
        return C5105c.m17295a().m17297a(C5097n.OFFLINE_ENGINE_INIT_FAILED, bdTTSEngineInit, "bdTTSEngineInit result not 0");
    }

    /* renamed from: b */
    public TtsError mo3848b() {
        EmbeddedSynthesizerEngine.bdTTSEngineUninit(this.f20742c[0]);
        return null;
    }

    /* renamed from: a */
    public TtsError mo3844a(C5146i c5146i) throws InterruptedException {
        try {
            return new C5007c(this, c5146i).m16802a();
        } catch (InterruptedException e) {
            throw e;
        } catch (Throwable e2) {
            return C5105c.m17295a().m17300a(C5097n.OFFLINE_ENGINE_CALL_EXCEPTION, e2);
        }
    }

    /* renamed from: a */
    public int mo3841a(C5142e c5142e) {
        return EmbeddedSynthesizerEngine.bdTTSDomainDataInit(ResourceTools.stringToByteArrayAddNull(c5142e.m17404a()), this.f20742c[0]);
    }

    /* renamed from: b */
    public int mo3847b(C5142e c5142e) {
        return EmbeddedSynthesizerEngine.bdTTSDomainDataUninit(this.f20742c[0]);
    }

    /* renamed from: a */
    public int mo3842a(C5144g c5144g) {
        int i = 0;
        Object b = c5144g.m17412b();
        Object a = c5144g.m17410a();
        boolean isEmpty = TextUtils.isEmpty(b);
        boolean isEmpty2 = TextUtils.isEmpty(a);
        if (isEmpty && isEmpty2) {
            return C5097n.TTS_PARAMETER_INVALID.m17284b();
        }
        int i2;
        if (isEmpty2) {
            i2 = 0;
        } else {
            i2 = EmbeddedSynthesizerEngine.bdTTSReInitData(ResourceTools.stringToByteArrayAddNull(a), this.f20742c[0]);
        }
        if (!isEmpty) {
            i = EmbeddedSynthesizerEngine.bdTTSReInitData(ResourceTools.stringToByteArrayAddNull(b), this.f20742c[0]);
        }
        return i + i2;
    }

    /* renamed from: a */
    public int mo3849a(C5143f c5143f) {
        Object b = c5143f.m17408b();
        Object a = c5143f.m17406a();
        boolean isEmpty = TextUtils.isEmpty(b);
        if (TextUtils.isEmpty(a) || isEmpty) {
            return C5097n.TTS_PARAMETER_INVALID.m17284b();
        }
        int loadEnglishEngine = EmbeddedSynthesizerEngine.loadEnglishEngine(ResourceTools.stringToByteArrayAddNull(a), ResourceTools.stringToByteArrayAddNull(b), this.f20742c[0]);
        LoggerProxy.m17001d("OfflineSynthesizer", "loadEnglishModel ret=" + loadEnglishEngine);
        return loadEnglishEngine;
    }
}
