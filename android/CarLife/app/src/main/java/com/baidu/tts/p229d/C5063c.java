package com.baidu.tts.p229d;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.Conditions;
import com.baidu.tts.client.model.DownloadHandler;
import com.baidu.tts.client.model.ModelBags;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.database.C5068a;
import com.baidu.tts.p216j.C4958b;
import com.baidu.tts.p229d.p230a.C5048b;
import com.baidu.tts.p229d.p230a.C5049c;
import com.baidu.tts.p229d.p231b.C5056a;
import com.baidu.tts.p229d.p231b.C5057b;
import com.baidu.tts.p229d.p231b.C5058c;
import com.baidu.tts.p229d.p231b.C5059d;
import com.baidu.tts.p233f.C5094l;
import com.baidu.tts.p233f.C5097n;
import com.baidu.tts.p236h.p237a.C5105c;
import com.baidu.tts.p241l.C5120a;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.StringTool;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* compiled from: Downloader */
/* renamed from: com.baidu.tts.d.c */
public class C5063c implements C4958b {
    /* renamed from: a */
    private static volatile C5063c f20938a = null;
    /* renamed from: b */
    private C5120a f20939b;
    /* renamed from: c */
    private C5056a f20940c = C5056a.m17101a();
    /* renamed from: d */
    private C5048b f20941d = new C5048b();
    /* renamed from: e */
    private ExecutorService f20942e;

    /* compiled from: Downloader */
    /* renamed from: com.baidu.tts.d.c$a */
    public class C5062a implements Callable<C5055a> {
        /* renamed from: a */
        final /* synthetic */ C5063c f20936a;
        /* renamed from: b */
        private DownloadHandler f20937b;

        public /* synthetic */ Object call() throws Exception {
            return m17170a();
        }

        public C5062a(C5063c c5063c, DownloadHandler downloadHandler) {
            this.f20936a = c5063c;
            this.f20937b = downloadHandler;
        }

        /* renamed from: a */
        public C5055a m17170a() throws Exception {
            C5055a c5055a = new C5055a();
            C5068a e = this.f20936a.f20939b.m17372e();
            String modelId = this.f20937b.getModelId();
            C5059d b = this.f20936a.f20940c.m17106b(modelId);
            try {
                b.m17148c(this.f20937b);
                if (!b.m17143a(e)) {
                    Conditions conditions = new Conditions();
                    conditions.appendId(modelId);
                    ModelBags modelBags = (ModelBags) this.f20936a.f20939b.m17358a(conditions).get();
                    if (modelBags == null || modelBags.isEmpty()) {
                        b.m17139a(this.f20937b, C5105c.m17295a().m17299a(C5097n.MODEL_BAGS_EMPTY, "modelId=" + modelId));
                        return c5055a;
                    }
                    b.m17140a(modelBags, e);
                }
                Set<String> f = b.m17151f();
                if (DataTool.isSetEmpty(f)) {
                    b.m17139a(this.f20937b, C5105c.m17295a().m17299a(C5097n.MODEL_DB_MODEL_INVALID, "modelId=" + modelId));
                    return c5055a;
                }
                for (String str : f) {
                    C5058c c = this.f20936a.f20940c.m17108c(str);
                    if (!c.m17133a(e)) {
                        Set hashSet = new HashSet();
                        hashSet.add(str);
                        ModelFileBags modelFileBags = (ModelFileBags) this.f20936a.f20939b.m17360a(hashSet).get();
                        if (modelFileBags == null || modelFileBags.isEmpty()) {
                            b.m17139a(this.f20937b, C5105c.m17295a().m17299a(C5097n.MODEL_FILE_BAG_EMPTY, "fileId=" + str));
                            return c5055a;
                        }
                        modelFileBags.generateAbsPath(this.f20936a.f20939b.m17371d());
                        c.m17132a(modelFileBags, e);
                    }
                }
                b.m17149d();
                f = b.m17144b();
                if (DataTool.isSetEmpty(f)) {
                    b.m17139a(this.f20937b, C5105c.m17295a().m17299a(C5097n.MODEL_DB_MODEL_FILE_PATHS_INVALID, "modelId=" + modelId));
                    return c5055a;
                }
                for (String str2 : f) {
                    if (!StringTool.isEmpty(str2)) {
                        C5057b a = this.f20936a.f20940c.m17102a(str2);
                        a.m17118a(modelId);
                        boolean a2 = a.m17119a(e);
                        String c2 = a.m17123c();
                        LoggerProxy.m17001d("Downloader", "isNeedDownload=" + a2 + "--fileId=" + c2);
                        if (a2) {
                            if (a.m17126e()) {
                                a.m17127f();
                            }
                            C5049c c5049c = new C5049c();
                            c5049c.m17077a(a);
                            if (Thread.currentThread().isInterrupted()) {
                                return null;
                            }
                            LoggerProxy.m17001d("Downloader", "before download fileId=" + c2);
                            a.m17117a(this.f20936a.f20941d.m17056a(c5049c));
                            c5055a.m17098a(true);
                        } else {
                            c5055a.m17097a(str2, a.m17125d());
                        }
                    }
                }
                if (!c5055a.m17099a() && c5055a.m17100b()) {
                    this.f20937b.updateProgress(b);
                    b.m17139a(this.f20937b, C5105c.m17295a().m17299a(C5097n.MODEL_EXISTS, "modelId=" + modelId));
                }
                return c5055a;
            } catch (Exception e2) {
                LoggerProxy.m17001d("Downloader", "exception=" + e2.toString());
                b.m17139a(this.f20937b, C5105c.m17295a().m17299a(C5097n.MODEL_CHECK_EXCEPTION, "modelId=" + modelId));
                return c5055a;
            }
        }
    }

    private C5063c() {
    }

    /* renamed from: a */
    public static C5063c m17171a() {
        if (f20938a == null) {
            synchronized (C5063c.class) {
                if (f20938a == null) {
                    f20938a = new C5063c();
                }
            }
        }
        return f20938a;
    }

    /* renamed from: h */
    private synchronized ExecutorService m17175h() {
        if (this.f20942e == null) {
            this.f20942e = Executors.newSingleThreadExecutor();
        }
        return this.f20942e;
    }

    /* renamed from: b */
    public synchronized TtsError mo3782b() {
        return null;
    }

    /* renamed from: g */
    public synchronized void m17183g() {
        m17175h();
        this.f20941d.m16611A();
    }

    /* renamed from: c */
    public synchronized void mo3784c() {
        this.f20941d.mo3784c();
    }

    /* renamed from: d */
    public synchronized void mo3785d() {
        this.f20941d.mo3785d();
    }

    /* renamed from: e */
    public synchronized void mo3786e() {
        LoggerProxy.m17001d("Downloader", "enter stop");
        this.f20940c.m17109c();
        if (this.f20942e != null) {
            if (!this.f20942e.isShutdown()) {
                this.f20942e.shutdownNow();
                this.f20941d.mo3786e();
                LoggerProxy.m17001d("Downloader", "after engine stop");
            }
            try {
                LoggerProxy.m17001d("Downloader", "before awaitTermination");
                LoggerProxy.m17001d("Downloader", "after awaitTermination isTermination=" + this.f20942e.awaitTermination(C5094l.DEFAULT.m17279a(), TimeUnit.MILLISECONDS));
            } catch (InterruptedException e) {
            }
            this.f20942e = null;
        }
        LoggerProxy.m17001d("Downloader", "end stop");
    }

    /* renamed from: f */
    public synchronized void mo3787f() {
    }

    /* renamed from: a */
    public void m17177a(C5120a c5120a) {
        this.f20939b = c5120a;
        this.f20940c.m17104a(this.f20939b.m17372e());
        this.f20941d.m17058a(this.f20939b);
    }

    /* renamed from: a */
    public synchronized DownloadHandler m17176a(DownloadHandler downloadHandler) {
        LoggerProxy.m17001d("Downloader", "download handler=" + downloadHandler);
        downloadHandler.setCheckFuture(m17175h().submit(new C5062a(this, downloadHandler)));
        return downloadHandler;
    }
}
