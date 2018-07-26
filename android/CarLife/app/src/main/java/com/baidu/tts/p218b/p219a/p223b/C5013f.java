package com.baidu.tts.p218b.p219a.p223b;

import com.baidu.carlife.core.C1253f;
import com.baidu.platform.comapi.map.Geometry;
import com.baidu.speechsynthesizer.utility.SpeechDecoder;
import com.baidu.speechsynthesizer.utility.SpeechDecoder.OnDecodedDataListener;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.auth.C4974a;
import com.baidu.tts.auth.C4981c.C4980a;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.loopj.ResponseHandlerInterface;
import com.baidu.tts.loopj.SyncHttpClient;
import com.baidu.tts.p225m.C5005d;
import com.baidu.tts.p225m.C5142e;
import com.baidu.tts.p225m.C5143f;
import com.baidu.tts.p225m.C5144g;
import com.baidu.tts.p225m.C5145h;
import com.baidu.tts.p225m.C5146i;
import com.baidu.tts.p233f.C5080a;
import com.baidu.tts.p233f.C5081b;
import com.baidu.tts.p233f.C5085c;
import com.baidu.tts.p233f.C5089g;
import com.baidu.tts.p233f.C5094l;
import com.baidu.tts.p233f.C5097n;
import com.baidu.tts.p233f.C5098o;
import com.baidu.tts.p236h.p237a.C5105c;
import com.baidu.tts.p236h.p238b.C5107b;
import com.baidu.tts.p246q.C5160a;
import com.baidu.tts.tools.CommonUtility;
import com.baidu.tts.tools.StringTool;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.message.BasicNameValuePair;

/* compiled from: OnlineSynthesizer */
/* renamed from: com.baidu.tts.b.a.b.f */
public class C5013f extends C4996a {
    /* renamed from: b */
    private C5010b f20778b;
    /* renamed from: c */
    private double f20779c;

    /* compiled from: OnlineSynthesizer */
    /* renamed from: com.baidu.tts.b.a.b.f$a */
    private class C5009a implements Callable<C5145h> {
        /* renamed from: a */
        final /* synthetic */ C5013f f20744a;
        /* renamed from: b */
        private int f20745b;
        /* renamed from: c */
        private C5011c f20746c;
        /* renamed from: d */
        private C5146i f20747d;
        /* renamed from: e */
        private C5010b f20748e;
        /* renamed from: f */
        private C5145h f20749f;
        /* renamed from: g */
        private SyncHttpClient f20750g;

        public /* synthetic */ Object call() throws Exception {
            return m16814a();
        }

        public C5009a(C5013f c5013f, int i, C5011c c5011c, C5146i c5146i, C5010b c5010b, C5145h c5145h) {
            this.f20744a = c5013f;
            this.f20745b = i;
            this.f20746c = c5011c;
            this.f20747d = c5146i;
            this.f20748e = c5010b;
            this.f20749f = c5145h;
        }

        /* renamed from: a */
        public C5145h m16814a() throws Exception {
            try {
                HttpEntity a = this.f20744a.m16853a(this.f20745b, this.f20746c.f20767a, this.f20747d, this.f20748e);
                this.f20750g = new SyncHttpClient(true, 80, 443);
                this.f20750g.setMaxRetriesAndTimeout(this.f20748e.m16842n(), this.f20748e.m16843o());
                int p = this.f20748e.m16844p();
                LoggerProxy.m17001d("OnlineSynthesizer", "timeout=" + p);
                this.f20750g.setTimeout(p);
                ResponseHandlerInterface c5015h = new C5015h(this.f20749f);
                c5015h.m16869a(this.f20748e);
                if (this.f20745b == 1) {
                    this.f20746c.f20768b = C5098o.TTS_SERVER.mo3881b();
                    LoggerProxy.m17001d("OnlineSynthesizer", "serverIp=" + this.f20746c.f20768b);
                }
                if (this.f20746c.f20768b == null) {
                    this.f20749f.m17419a(C5105c.m17295a().m17302b(C5097n.ONLINE_ENGINE_SERVER_IP_IS_NULL));
                } else if (!Thread.currentThread().isInterrupted()) {
                    LoggerProxy.m17001d("OnlineSynthesizer", "before post");
                    this.f20750g.post(null, this.f20746c.f20768b, a, null, c5015h);
                    LoggerProxy.m17001d("OnlineSynthesizer", "after post");
                }
                return this.f20749f;
            } catch (C5160a e) {
                this.f20749f.m17419a(C5105c.m17295a().m17302b(C5097n.ONLINE_TOKEN_IS_NULL));
                return this.f20749f;
            }
        }

        /* renamed from: b */
        public void m16815b() {
            if (this.f20750g != null) {
                this.f20750g.stop();
            }
        }
    }

    /* compiled from: OnlineSynthesizer */
    /* renamed from: com.baidu.tts.b.a.b.f$b */
    public static class C5010b extends C5005d<C5010b> {
        /* renamed from: p */
        private static Set<String> f20751p = new HashSet();
        /* renamed from: a */
        private String f20752a;
        /* renamed from: b */
        private C5081b f20753b = C5081b.AMR;
        /* renamed from: c */
        private C5085c f20754c = C5085c.AMR_15K85;
        /* renamed from: d */
        private String f20755d = "0";
        /* renamed from: e */
        private String f20756e;
        /* renamed from: f */
        private String f20757f;
        /* renamed from: g */
        private String f20758g;
        /* renamed from: h */
        private String f20759h;
        /* renamed from: i */
        private String f20760i;
        /* renamed from: j */
        private String f20761j;
        /* renamed from: k */
        private String f20762k;
        /* renamed from: l */
        private String f20763l;
        /* renamed from: m */
        private int f20764m = 5;
        /* renamed from: n */
        private int f20765n = 1000;
        /* renamed from: o */
        private int f20766o = C5094l.DEFAULT.m17280b();

        /* renamed from: a */
        public String m16817a() {
            return this.f20762k;
        }

        /* renamed from: a */
        public void m16820a(String str) {
            this.f20762k = str;
        }

        /* renamed from: b */
        public String m16821b() {
            return this.f20763l;
        }

        /* renamed from: b */
        public void m16823b(String str) {
            this.f20763l = str;
        }

        /* renamed from: c */
        public C5081b m16824c() {
            return this.f20753b;
        }

        /* renamed from: d */
        public String m16827d() {
            return this.f20753b.m17257a();
        }

        /* renamed from: a */
        public int m16816a(C5081b c5081b) {
            if (c5081b == null) {
                return C5097n.TTS_PARAMETER_INVALID.m17284b();
            }
            this.f20753b = c5081b;
            return 0;
        }

        /* renamed from: e */
        public String m16829e() {
            return this.f20752a;
        }

        /* renamed from: c */
        public void m16826c(String str) {
            this.f20752a = str;
        }

        /* renamed from: f */
        public String m16831f() {
            return this.f20754c.m17266a();
        }

        /* renamed from: a */
        public void m16819a(C5085c c5085c) {
            this.f20754c = c5085c;
        }

        /* renamed from: g */
        public String m16833g() {
            return this.f20755d;
        }

        /* renamed from: d */
        public void m16828d(String str) {
            this.f20755d = str;
        }

        /* renamed from: h */
        public String m16835h() {
            return this.f20756e;
        }

        /* renamed from: i */
        public String m16837i() {
            return this.f20757f;
        }

        /* renamed from: j */
        public String m16838j() {
            return this.f20758g;
        }

        /* renamed from: e */
        public void m16830e(String str) {
            this.f20758g = str;
        }

        /* renamed from: k */
        public String m16839k() {
            return this.f20759h;
        }

        /* renamed from: f */
        public void m16832f(String str) {
            this.f20759h = str;
        }

        /* renamed from: l */
        public String m16840l() {
            return this.f20760i;
        }

        /* renamed from: g */
        public void m16834g(String str) {
            this.f20760i = str;
        }

        /* renamed from: m */
        public String m16841m() {
            return this.f20761j;
        }

        /* renamed from: h */
        public void m16836h(String str) {
            this.f20761j = str;
        }

        /* renamed from: n */
        public int m16842n() {
            return this.f20764m;
        }

        /* renamed from: a */
        public void m16818a(int i) {
            this.f20764m = i;
        }

        /* renamed from: o */
        public int m16843o() {
            return this.f20765n;
        }

        /* renamed from: b */
        public void m16822b(int i) {
            this.f20765n = i;
        }

        /* renamed from: p */
        public int m16844p() {
            return this.f20766o;
        }

        /* renamed from: c */
        public void m16825c(int i) {
            this.f20766o = i;
        }

        static {
            f20751p.add(C5089g.SPEED.m17274b());
        }
    }

    /* compiled from: OnlineSynthesizer */
    /* renamed from: com.baidu.tts.b.a.b.f$c */
    private class C5011c {
        /* renamed from: a */
        String f20767a = CommonUtility.generateSerialNumber();
        /* renamed from: b */
        String f20768b;
        /* renamed from: c */
        final /* synthetic */ C5013f f20769c;

        public C5011c(C5013f c5013f) {
            this.f20769c = c5013f;
        }
    }

    /* compiled from: OnlineSynthesizer */
    /* renamed from: com.baidu.tts.b.a.b.f$d */
    private class C5012d implements OnDecodedDataListener, Callable<TtsError> {
        /* renamed from: a */
        byte[] f20770a = new byte[0];
        /* renamed from: b */
        final /* synthetic */ C5013f f20771b;
        /* renamed from: c */
        private C5146i f20772c;
        /* renamed from: d */
        private C5011c f20773d;
        /* renamed from: e */
        private SpeechDecoder f20774e;
        /* renamed from: f */
        private C5145h f20775f;
        /* renamed from: g */
        private int f20776g = 0;
        /* renamed from: h */
        private int f20777h = 1;

        public /* synthetic */ Object call() throws Exception {
            return m16849a();
        }

        public C5012d(C5013f c5013f, C5146i c5146i) {
            this.f20771b = c5013f;
            this.f20772c = c5146i;
            this.f20773d = new C5011c(c5013f);
            this.f20774e = new SpeechDecoder();
        }

        /* renamed from: a */
        public TtsError m16849a() throws Exception {
            int i = 0;
            SpeechDecoder.setOnDecodedDataListener(this);
            C5145h a;
            do {
                i++;
                LoggerProxy.m17001d("OnlineSynthesizer", "count=" + i);
                a = this.f20771b.m16851a(i, this.f20773d, this.f20772c);
                if (m16846a(a)) {
                    this.f20775f = a;
                    this.f20774e.decodeWithCallback(a.m17430d());
                }
            } while (!m16848b(a));
            if (a == null) {
                return C5105c.m17295a().m17302b(C5097n.ONLINE_ENGINE_CALL_EXCEPTION);
            }
            return a.m17433f();
        }

        /* renamed from: a */
        private boolean m16846a(C5145h c5145h) {
            if (c5145h != null && c5145h.m17433f() == null && c5145h.m17417a() == 0) {
                return true;
            }
            return false;
        }

        /* renamed from: b */
        private boolean m16848b(C5145h c5145h) {
            if (!m16846a(c5145h) || c5145h.m17425b() < 0) {
                return true;
            }
            return false;
        }

        public void onDecodedData(byte[] audioData) {
            this.f20770a = m16847a(this.f20770a, audioData);
            int length = this.f20770a.length;
            if (length >= Geometry.TY_MASK) {
                int length2 = this.f20775f.m17430d().length;
                double a = ((double) length) / (((double) length2) * this.f20771b.f20779c);
                double d = (double) this.f20776g;
                m16845a((int) (((((double) (this.f20775f.m17427c() - this.f20776g)) * a) * ((double) this.f20777h)) + d));
            }
            if (audioData.length == 0) {
                if (length < Geometry.TY_MASK) {
                    m16845a(this.f20775f.m17427c());
                }
                this.f20776g = this.f20775f.m17427c();
                this.f20777h = 1;
                if (this.f20775f.m17425b() < 0) {
                    this.f20776g = 0;
                }
            }
        }

        /* renamed from: a */
        private void m16845a(int i) {
            LoggerProxy.m17001d("OnlineSynthesizer", "mindex=" + this.f20777h + " progress=" + i);
            C5145h c5145h = (C5145h) this.f20775f.m16770B();
            c5145h.m17424a(this.f20770a);
            c5145h.m17420a(C5080a.PCM);
            c5145h.m17428c(this.f20777h);
            c5145h.m17429d(i);
            this.f20771b.m16738a(c5145h);
            this.f20777h++;
            this.f20770a = new byte[0];
        }

        /* renamed from: a */
        private byte[] m16847a(byte[] bArr, byte[] bArr2) {
            Object obj = new byte[(bArr.length + bArr2.length)];
            System.arraycopy(bArr, 0, obj, 0, bArr.length);
            System.arraycopy(bArr2, 0, obj, bArr.length, bArr2.length);
            return obj;
        }
    }

    /* renamed from: a */
    public <OnlineSynthesizerParams> void mo3846a(OnlineSynthesizerParams onlineSynthesizerParams) {
        this.f20778b = (C5010b) onlineSynthesizerParams;
    }

    /* renamed from: a */
    public TtsError mo3844a(C5146i c5146i) throws InterruptedException {
        try {
            return new C5012d(this, c5146i).m16849a();
        } catch (InterruptedException e) {
            throw e;
        } catch (Throwable e2) {
            return C5105c.m17295a().m17300a(C5097n.ONLINE_ENGINE_CALL_EXCEPTION, e2);
        }
    }

    /* renamed from: a */
    private C5145h m16851a(int i, C5011c c5011c, C5146i c5146i) throws InterruptedException {
        C5145h b = C5145h.m17416b(c5146i);
        C5010b c5010b = (C5010b) this.f20778b.m16770B();
        C5009a c5009a = new C5009a(this, i, c5011c, c5146i, c5010b, b);
        FutureTask futureTask = new FutureTask(c5009a);
        new Thread(futureTask).start();
        try {
            return (C5145h) futureTask.get((long) c5010b.m16844p(), TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            futureTask.cancel(true);
            c5009a.m16815b();
            throw e;
        } catch (ExecutionException e2) {
            b.m17419a(C5105c.m17295a().m17300a(C5097n.ONLINE_ENGINE_GET_EXECUTION_EXCEPTION, e2.getCause()));
            return b;
        } catch (Throwable e3) {
            LoggerProxy.m17001d("OnlineSynthesizer", "startOnceHttpRequest timeout");
            futureTask.cancel(true);
            c5009a.m16815b();
            b.m17419a(C5105c.m17295a().m17300a(C5097n.ONLINE_ENGINE_GET_TIMEOUT, e3));
            return b;
        }
    }

    /* renamed from: a */
    private HttpEntity m16853a(int i, String str, C5146i c5146i, C5010b c5010b) throws C5160a {
        if (c5010b == null) {
            return null;
        }
        UrlEncodedFormEntity urlEncodedFormEntity;
        List<NameValuePair> arrayList = new ArrayList();
        arrayList.add(new BasicNameValuePair(C5089g.INDEX.m17273a(), String.valueOf(i)));
        arrayList.add(new BasicNameValuePair(C5089g.SERIAL_NUMBER.m17273a(), str));
        arrayList.add(new BasicNameValuePair(C5089g.PLATFORM.m17274b(), C1253f.jb));
        C5107b a = C5107b.m17306a();
        arrayList.add(new BasicNameValuePair(C5089g.VERSION.m17273a(), a.m17318j()));
        String e = c5010b.m16829e();
        if (!StringTool.isEmpty(e)) {
            arrayList.add(new BasicNameValuePair(C5089g.PRODUCT_ID.m17273a(), e));
        }
        c5146i.m17441c(c5010b.m16778q());
        String d = c5146i.m17442d();
        if (i == 1) {
            try {
                arrayList.add(new BasicNameValuePair(C5089g.TEXT.m17273a(), URLEncoder.encode(c5146i.m17440c(), d)));
                arrayList.add(new BasicNameValuePair(C5089g.CTP.m17273a(), a.m17308a(C5089g.CTP.m17273a())));
                String i2 = a.m17317i();
                if (i2 != null) {
                    arrayList.add(new BasicNameValuePair(C5089g.CUID.m17273a(), i2));
                }
                if (StringTool.isEmpty(e)) {
                    LoggerProxy.m17001d("OnlineSynthesizer", "before online auth");
                    C4980a a2 = C4974a.m16566a().m16574a(c5010b);
                    LoggerProxy.m17001d("OnlineSynthesizer", "after online auth");
                    if (a2.mo3801g()) {
                        arrayList.add(new BasicNameValuePair(C5089g.TOKEN.m17273a(), a2.m16594a()));
                    } else {
                        throw new C5160a();
                    }
                }
                arrayList.add(new BasicNameValuePair(C5089g.TEXT_ENCODE.m17273a(), c5010b.m16779r()));
                arrayList.add(new BasicNameValuePair(C5089g.AUDIO_ENCODE.m17273a(), c5010b.m16827d()));
                arrayList.add(new BasicNameValuePair(C5089g.BITRATE.m17273a(), c5010b.m16831f()));
                this.f20779c = c5010b.m16824c().mo3880b()[Integer.parseInt(c5010b.m16831f())].m17267b();
                arrayList.add(new BasicNameValuePair(C5089g.SPEAKER.m17273a(), c5010b.m16833g()));
                arrayList.add(new BasicNameValuePair(C5089g.NUMBER.m17273a(), c5010b.m16835h()));
                arrayList.add(new BasicNameValuePair(C5089g.ENGINE.m17273a(), c5010b.m16837i()));
                arrayList.add(new BasicNameValuePair(C5089g.STYLE.m17273a(), c5010b.m16838j()));
                arrayList.add(new BasicNameValuePair(C5089g.BACKGROUND.m17273a(), c5010b.m16839k()));
                arrayList.add(new BasicNameValuePair(C5089g.TERRITORY.m17273a(), c5010b.m16840l()));
                arrayList.add(new BasicNameValuePair(C5089g.PUNCTUATION.m17273a(), c5010b.m16841m()));
                arrayList.add(new BasicNameValuePair(C5089g.LANGUAGE.m17273a(), c5010b.m16780s()));
                arrayList.add(new BasicNameValuePair(C5089g.SPEED.m17273a(), c5010b.m16783v()));
                arrayList.add(new BasicNameValuePair(C5089g.PITCH.m17273a(), c5010b.m16784w()));
                arrayList.add(new BasicNameValuePair(C5089g.VOLUME.m17273a(), c5010b.m16785x()));
                arrayList.add(new BasicNameValuePair(C5089g.OPEN_XML.m17273a(), c5010b.m16781t()));
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            for (NameValuePair nameValuePair : arrayList) {
                stringBuffer.append(nameValuePair.getName());
                stringBuffer.append("=");
                stringBuffer.append(nameValuePair.getValue());
                stringBuffer.append(",");
            }
            LoggerProxy.m17001d("OnlineSynthesizer", "request params: " + stringBuffer);
            urlEncodedFormEntity = new UrlEncodedFormEntity(arrayList, d);
        } catch (UnsupportedEncodingException e22) {
            e22.printStackTrace();
            urlEncodedFormEntity = null;
        }
        return urlEncodedFormEntity;
    }

    /* renamed from: a */
    public int mo3841a(C5142e c5142e) {
        return C5097n.ONLINE_UNSUPPORTED_OPERATION.m17284b();
    }

    /* renamed from: b */
    public int mo3847b(C5142e c5142e) {
        return C5097n.ONLINE_UNSUPPORTED_OPERATION.m17284b();
    }

    /* renamed from: a */
    public int mo3842a(C5144g c5144g) {
        return C5097n.ONLINE_UNSUPPORTED_OPERATION.m17284b();
    }

    /* renamed from: a */
    public int mo3849a(C5143f c5143f) {
        return C5097n.ONLINE_UNSUPPORTED_OPERATION.m17284b();
    }
}
