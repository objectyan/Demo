package com.baidu.tts.p229d.p231b;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.DownloadHandler;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.database.C5068a;
import com.baidu.tts.p233f.C5089g;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.StringTool;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: ModelFlyweight */
/* renamed from: com.baidu.tts.d.b.d */
public class C5059d {
    /* renamed from: a */
    private String f20924a;
    /* renamed from: b */
    private String f20925b;
    /* renamed from: c */
    private String f20926c;
    /* renamed from: d */
    private long f20927d = 0;
    /* renamed from: e */
    private C5056a f20928e = C5056a.m17101a();
    /* renamed from: f */
    private CopyOnWriteArraySet<DownloadHandler> f20929f = new CopyOnWriteArraySet();

    public C5059d(String str) {
        this.f20924a = str;
    }

    /* renamed from: a */
    public void m17138a(DownloadHandler downloadHandler) {
        if (this.f20929f != null) {
            this.f20929f.add(downloadHandler);
        }
    }

    /* renamed from: b */
    public void m17145b(DownloadHandler downloadHandler) {
        boolean isSetEmpty = DataTool.isSetEmpty(this.f20929f);
        LoggerProxy.m17001d("ModelFlyweight", "unregisterListener 1isEmpty=" + isSetEmpty);
        if (!isSetEmpty) {
            this.f20929f.remove(downloadHandler);
            isSetEmpty = DataTool.isSetEmpty(this.f20929f);
            LoggerProxy.m17001d("ModelFlyweight", "unregisterListener 2isEmpty=" + isSetEmpty);
            if (isSetEmpty) {
                m17136j();
                return;
            }
            Iterator it = this.f20929f.iterator();
            while (it.hasNext()) {
                LoggerProxy.m17001d("ModelFlyweight", "unregisterListener item=" + ((DownloadHandler) it.next()));
            }
        }
    }

    /* renamed from: j */
    private void m17136j() {
        this.f20928e.m17105a(this.f20925b, this.f20924a);
        this.f20928e.m17105a(this.f20926c, this.f20924a);
    }

    /* renamed from: a */
    public void m17137a() {
        this.f20929f.clear();
        m17136j();
    }

    /* renamed from: b */
    public Set<String> m17144b() {
        Set<String> hashSet = new HashSet();
        C5060e a = C5060e.m17155a();
        C5058c b = a.m17159b(this.f20925b);
        C5058c b2 = a.m17159b(this.f20926c);
        String a2 = b.m17131a();
        String a3 = b2.m17131a();
        hashSet.add(a2);
        hashSet.add(a3);
        return hashSet;
    }

    /* renamed from: c */
    public long m17147c() {
        m17149d();
        return this.f20927d;
    }

    /* renamed from: d */
    public void m17149d() {
        if (this.f20927d == 0) {
            m17150e();
        }
    }

    /* renamed from: e */
    public void m17150e() {
        C5060e a = C5060e.m17155a();
        String b = a.m17159b(this.f20925b).m17134b();
        String b2 = a.m17159b(this.f20926c).m17134b();
        Long valueOf = Long.valueOf(Long.parseLong(b));
        Long valueOf2 = Long.valueOf(Long.parseLong(b2));
        this.f20927d = valueOf2.longValue() + valueOf.longValue();
    }

    /* renamed from: a */
    public boolean m17143a(C5068a c5068a) {
        Map e = c5068a.m17217e(this.f20924a);
        if (e == null || e.isEmpty()) {
            return false;
        }
        this.f20925b = DataTool.getMapValue(e, C5089g.TEXT_DATA_ID.m17274b());
        this.f20926c = DataTool.getMapValue(e, C5089g.SPEECH_DATA_ID.m17274b());
        boolean isEmpty = StringTool.isEmpty(this.f20925b);
        boolean isEmpty2 = StringTool.isEmpty(this.f20926c);
        if (!isEmpty && !isEmpty2) {
            return true;
        }
        c5068a.m17205a(this.f20924a);
        return false;
    }

    /* renamed from: a */
    public void m17140a(ModelBags modelBags, C5068a c5068a) {
        c5068a.m17210a(modelBags);
        m17143a(c5068a);
    }

    /* renamed from: f */
    public Set<String> m17151f() {
        Set<String> hashSet = new HashSet();
        hashSet.add(this.f20925b);
        hashSet.add(this.f20926c);
        return hashSet;
    }

    /* renamed from: g */
    public String m17152g() {
        return this.f20924a;
    }

    /* renamed from: h */
    public long m17153h() {
        return this.f20928e.m17110d(this.f20925b) + this.f20928e.m17110d(this.f20926c);
    }

    /* renamed from: c */
    public void m17148c(DownloadHandler downloadHandler) {
        m17138a(downloadHandler);
        downloadHandler.updateStart(this);
    }

    /* renamed from: a */
    public void m17139a(DownloadHandler downloadHandler, TtsError ttsError) {
        downloadHandler.updateFinish(this, ttsError);
        m17145b(downloadHandler);
    }

    /* renamed from: a */
    public void m17141a(C5057b c5057b) {
        if (this.f20929f != null) {
            Iterator it = this.f20929f.iterator();
            while (it.hasNext()) {
                ((DownloadHandler) it.next()).updateProgress(this);
            }
        }
    }

    /* renamed from: i */
    public boolean m17154i() {
        int e = this.f20928e.m17111e(this.f20925b);
        int e2 = this.f20928e.m17111e(this.f20926c);
        if (e == 7 && e2 == 7) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public void m17146b(C5057b c5057b) {
        boolean i = m17154i();
        LoggerProxy.m17001d("ModelFlyweight", "onFileDownloadSuccess isAllFileDownloadSuccess=" + i);
        if (i && this.f20929f != null) {
            Iterator it = this.f20929f.iterator();
            while (it.hasNext()) {
                m17139a((DownloadHandler) it.next(), null);
            }
        }
    }

    /* renamed from: a */
    public void m17142a(C5057b c5057b, TtsError ttsError) {
        LoggerProxy.m17001d("ModelFlyweight", "onFileDownloadFailure");
        if (this.f20929f != null) {
            Iterator it = this.f20929f.iterator();
            while (it.hasNext()) {
                m17139a((DownloadHandler) it.next(), ttsError);
            }
        }
    }
}
