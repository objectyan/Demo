package com.baidu.tts.p213a.p215b;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.tts.aop.tts.ITts;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.aop.tts.TtsFactory;
import com.baidu.tts.aop.ttslistener.TtsListener;
import com.baidu.tts.auth.AuthInfo;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.SpeechError;
import com.baidu.tts.client.SpeechSynthesizeBag;
import com.baidu.tts.client.SpeechSynthesizer;
import com.baidu.tts.client.SpeechSynthesizerListener;
import com.baidu.tts.client.TtsMode;
import com.baidu.tts.p225m.C5142e;
import com.baidu.tts.p225m.C5143f;
import com.baidu.tts.p225m.C5144g;
import com.baidu.tts.p225m.C5145h;
import com.baidu.tts.p225m.C5146i;
import com.baidu.tts.p228c.C5033a;
import com.baidu.tts.p233f.C5089g;
import com.baidu.tts.p233f.C5091i;
import com.baidu.tts.p233f.C5094l;
import com.baidu.tts.p233f.C5097n;
import com.baidu.tts.p236h.p238b.C5107b;
import com.baidu.tts.tools.ResourceTools;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.AbortPolicy;
import java.util.concurrent.TimeUnit;

/* compiled from: SpeechSynthesizerAdapter */
/* renamed from: com.baidu.tts.a.b.a */
public class C4957a {
    /* renamed from: a */
    private ITts f20633a = m16450g();
    /* renamed from: b */
    private SpeechSynthesizerListener f20634b;
    /* renamed from: c */
    private ThreadPoolExecutor f20635c;
    /* renamed from: d */
    private TtsListener f20636d = new C49521(this);

    /* compiled from: SpeechSynthesizerAdapter */
    /* renamed from: com.baidu.tts.a.b.a$1 */
    class C49521 implements TtsListener {
        /* renamed from: a */
        final /* synthetic */ C4957a f20623a;

        C49521(C4957a c4957a) {
            this.f20623a = c4957a;
        }

        public void onSynthesizeStart(C5145h responseBag) {
            if (this.f20623a.f20634b != null) {
                this.f20623a.f20634b.onSynthesizeStart(this.f20623a.m16446a(responseBag));
            }
        }

        public void onSynthesizeDataArrived(C5145h responseBag) {
            if (this.f20623a.f20634b != null) {
                this.f20623a.f20634b.onSynthesizeDataArrived(this.f20623a.m16446a(responseBag), responseBag.m17430d(), responseBag.m17427c());
            }
        }

        public void onSynthesizeFinished(C5145h responseBag) {
            if (this.f20623a.f20634b != null) {
                this.f20623a.f20634b.onSynthesizeFinish(this.f20623a.m16446a(responseBag));
            }
        }

        public void onPlayStart(C5145h responseBag) {
            if (this.f20623a.f20634b != null) {
                this.f20623a.f20634b.onSpeechStart(this.f20623a.m16446a(responseBag));
            }
        }

        public void onPlayProgressUpdate(C5145h responseBag) {
            if (this.f20623a.f20634b != null) {
                this.f20623a.f20634b.onSpeechProgressChanged(this.f20623a.m16446a(responseBag), responseBag.m17427c());
            }
        }

        public void onPlayFinished(C5145h responseBag) {
            if (this.f20623a.f20634b != null) {
                this.f20623a.f20634b.onSpeechFinish(this.f20623a.m16446a(responseBag));
            }
        }

        public void onError(C5145h responseBag) {
            if (this.f20623a.f20634b != null && !m16438a(responseBag)) {
                this.f20623a.f20634b.onError(this.f20623a.m16446a(responseBag), this.f20623a.m16448b(responseBag));
            }
        }

        /* renamed from: a */
        private boolean m16438a(C5145h c5145h) {
            try {
                switch (c5145h.m17433f().getTtsErrorFlyweight().m17292a()) {
                    case MIX_AUTH_INTERRUPTED_EXCEPTION:
                    case OFFLINE_AUTH_INTERRUPTED_EXCEPTION:
                    case ONLINE_AUTH_INTERRUPTED_EXCEPTION:
                        return true;
                    default:
                        return false;
                }
            } catch (Exception e) {
                LoggerProxy.m17001d("SpeechSynthesizerAdapter", "isStopped exception=" + e.toString());
                return false;
            }
        }
    }

    /* compiled from: SpeechSynthesizerAdapter */
    /* renamed from: com.baidu.tts.a.b.a$a */
    private class C4954a implements Callable<Void> {
        /* renamed from: a */
        List<SpeechSynthesizeBag> f20625a;
        /* renamed from: b */
        final /* synthetic */ C4957a f20626b;

        public /* synthetic */ Object call() throws Exception {
            return m16439a();
        }

        public C4954a(C4957a c4957a, List<SpeechSynthesizeBag> list) {
            this.f20626b = c4957a;
            this.f20625a = list;
        }

        /* renamed from: a */
        public Void m16439a() throws Exception {
            if (this.f20625a != null) {
                int size = this.f20625a.size();
                if (size > 0) {
                    for (int i = 0; i < size; i++) {
                        SpeechSynthesizeBag speechSynthesizeBag = (SpeechSynthesizeBag) this.f20625a.get(i);
                        if (speechSynthesizeBag != null) {
                            String text = speechSynthesizeBag.getText();
                            CharSequence utteranceId = speechSynthesizeBag.getUtteranceId();
                            if (TextUtils.isEmpty(utteranceId)) {
                                utteranceId = String.valueOf(i);
                                speechSynthesizeBag.setUtteranceId(utteranceId);
                            }
                            CharSequence charSequence = utteranceId;
                            if (Thread.currentThread().isInterrupted()) {
                                break;
                            }
                            C5146i c5146i = new C5146i(text, charSequence);
                            c5146i.m17436a(C5091i.SPEAK);
                            this.f20626b.f20633a.speak(c5146i);
                        }
                    }
                }
            }
            return null;
        }
    }

    /* compiled from: SpeechSynthesizerAdapter */
    /* renamed from: com.baidu.tts.a.b.a$b */
    private class C4955b implements Callable<Void> {
        /* renamed from: a */
        final /* synthetic */ C4957a f20627a;
        /* renamed from: b */
        private String f20628b;
        /* renamed from: c */
        private String f20629c;

        public /* synthetic */ Object call() throws Exception {
            return m16440a();
        }

        public C4955b(C4957a c4957a, String str, String str2) {
            this.f20627a = c4957a;
            this.f20628b = str;
            this.f20629c = str2;
        }

        /* renamed from: a */
        public Void m16440a() throws Exception {
            C5146i c5146i = new C5146i(this.f20628b, this.f20629c);
            c5146i.m17436a(C5091i.SPEAK);
            this.f20627a.f20633a.speak(c5146i);
            return null;
        }
    }

    /* compiled from: SpeechSynthesizerAdapter */
    /* renamed from: com.baidu.tts.a.b.a$c */
    private class C4956c implements Callable<Void> {
        /* renamed from: a */
        final /* synthetic */ C4957a f20630a;
        /* renamed from: b */
        private String f20631b;
        /* renamed from: c */
        private String f20632c;

        public /* synthetic */ Object call() throws Exception {
            return m16441a();
        }

        public C4956c(C4957a c4957a, String str, String str2) {
            this.f20630a = c4957a;
            this.f20631b = str;
            this.f20632c = str2;
        }

        /* renamed from: a */
        public Void m16441a() throws Exception {
            C5146i c5146i = new C5146i(this.f20631b, this.f20632c);
            c5146i.m17436a(C5091i.SYNTHESIZE);
            this.f20630a.f20633a.synthesize(c5146i);
            return null;
        }
    }

    public C4957a() {
        this.f20633a.setTtsListener(this.f20636d);
    }

    /* renamed from: g */
    private ITts m16450g() {
        return (ITts) new TtsFactory().makeProxy();
    }

    /* renamed from: a */
    public void m16462a(SpeechSynthesizerListener speechSynthesizerListener) {
        if (this.f20634b != speechSynthesizerListener) {
            this.f20634b = speechSynthesizerListener;
        }
    }

    /* renamed from: a */
    public void m16461a(Context context) {
        this.f20633a.setContext(context);
    }

    /* renamed from: a */
    public TtsError m16459a(TtsMode ttsMode) {
        this.f20633a.setMode(ttsMode.getTtsEnum());
        return this.f20633a.mo3782b();
    }

    /* renamed from: a */
    public String m16460a() {
        return C5107b.m17306a().m17318j();
    }

    /* renamed from: a */
    public int m16456a(String str, String str2) {
        try {
            return this.f20633a.setParam(C5089g.valueOf(str), str2);
        } catch (Exception e) {
            return C5097n.TTS_PARAMETER_INVALID.m17284b();
        }
    }

    /* renamed from: b */
    public int m16463b() {
        if (this.f20633a != null) {
            this.f20633a.mo3785d();
        }
        return 0;
    }

    /* renamed from: c */
    public int m16467c() {
        if (this.f20633a != null) {
            this.f20633a.mo3784c();
        }
        return 0;
    }

    /* renamed from: d */
    public int m16469d() {
        m16452i();
        if (this.f20633a != null) {
            this.f20633a.mo3786e();
        }
        return 0;
    }

    /* renamed from: e */
    public int m16470e() {
        m16452i();
        try {
            if (this.f20633a != null) {
                this.f20633a.mo3787f();
                this.f20633a = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /* renamed from: a */
    public int m16455a(String str) {
        C5142e c5142e = new C5142e();
        c5142e.m17405a(str);
        return this.f20633a.loadCustomResource(c5142e);
    }

    /* renamed from: f */
    public int m16471f() {
        return this.f20633a.freeCustomResource(null);
    }

    /* renamed from: b */
    public int m16464b(String str, String str2) {
        C5144g c5144g = new C5144g();
        c5144g.m17413b(str);
        c5144g.m17411a(str2);
        return this.f20633a.loadModel(c5144g);
    }

    /* renamed from: c */
    public int m16468c(String str, String str2) {
        C5143f c5143f = new C5143f();
        c5143f.m17407a(str);
        c5143f.m17409b(str2);
        return this.f20633a.loadEnglishModel(c5143f);
    }

    /* renamed from: a */
    public int m16457a(String str, String str2, Bundle bundle) {
        return m16442a(str, new C4955b(this, str, str2));
    }

    /* renamed from: b */
    public int m16465b(String str, String str2, Bundle bundle) {
        return m16442a(str, new C4956c(this, str, str2));
    }

    /* renamed from: a */
    public int m16458a(List<SpeechSynthesizeBag> list) {
        if (list.size() <= 100) {
            return m16443a(new C4954a(this, list));
        }
        return SpeechSynthesizer.ERROR_LIST_IS_TOO_LONG;
    }

    /* renamed from: b */
    public AuthInfo m16466b(TtsMode ttsMode) {
        return this.f20633a.auth(ttsMode.getTtsEnum());
    }

    /* renamed from: a */
    public int m16453a(float f, float f2) {
        return this.f20633a.setStereoVolume(f, f2);
    }

    /* renamed from: a */
    public int m16454a(int i) {
        return this.f20633a.setAudioStreamType(i);
    }

    /* renamed from: h */
    private synchronized ExecutorService m16451h() {
        if (this.f20635c == null) {
            this.f20635c = new C5033a(15000, "SpeechSynthesizerPoolThread", new AbortPolicy());
        }
        return this.f20635c;
    }

    /* renamed from: a */
    private int m16442a(String str, Callable<Void> callable) {
        C5097n isTextValid = ResourceTools.isTextValid(str);
        if (isTextValid == null) {
            return m16443a((Callable) callable);
        }
        return isTextValid.m17284b();
    }

    /* renamed from: a */
    private int m16443a(Callable<Void> callable) {
        try {
            m16451h().submit(callable);
            return 0;
        } catch (RejectedExecutionException e) {
            Log.e("bdtts-Queue", " count=" + ((ThreadPoolExecutor) m16451h()).getQueue().size());
            return SpeechSynthesizer.ERROR_QUEUE_IS_FULL;
        }
    }

    /* renamed from: i */
    private void m16452i() {
        if (this.f20635c != null) {
            if (!this.f20635c.isShutdown()) {
                this.f20635c.shutdownNow();
            }
            try {
                LoggerProxy.m17001d("SpeechSynthesizerAdapter", "isTerminated=" + this.f20635c.awaitTermination(C5094l.DEFAULT.m17279a(), TimeUnit.MILLISECONDS));
            } catch (InterruptedException e) {
                LoggerProxy.m17001d("SpeechSynthesizerAdapter", "InterruptedException");
            }
            this.f20635c = null;
        }
    }

    /* renamed from: a */
    private String m16446a(C5145h c5145h) {
        if (c5145h != null) {
            C5146i e = c5145h.m17431e();
            if (e != null) {
                return e.m17445f();
            }
        }
        LoggerProxy.m17001d("SpeechSynthesizerAdapter", "getUtteranceId null");
        return null;
    }

    /* renamed from: b */
    private SpeechError m16448b(C5145h c5145h) {
        SpeechError speechError;
        if (c5145h != null) {
            TtsError f = c5145h.m17433f();
            if (f != null) {
                int detailCode = f.getDetailCode();
                String detailMessage = f.getDetailMessage();
                speechError = new SpeechError();
                speechError.code = detailCode;
                speechError.description = detailMessage;
                return speechError;
            }
            LoggerProxy.m17001d("SpeechSynthesizerAdapter", "ttsError is null");
        }
        speechError = new SpeechError();
        speechError.code = C5097n.TTS_ERROR_UNKNOW.m17284b();
        speechError.description = C5097n.TTS_ERROR_UNKNOW.m17285c();
        return speechError;
    }
}
