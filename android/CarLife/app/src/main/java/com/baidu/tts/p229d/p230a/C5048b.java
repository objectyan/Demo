package com.baidu.tts.p229d.p230a;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.client.model.ModelFileBags;
import com.baidu.tts.loopj.ResponseHandlerInterface;
import com.baidu.tts.loopj.SyncHttpClient;
import com.baidu.tts.p216j.C4983a;
import com.baidu.tts.p233f.C5094l;
import com.baidu.tts.p233f.C5097n;
import com.baidu.tts.p234g.p235a.C5102a;
import com.baidu.tts.p236h.p237a.C5105c;
import com.baidu.tts.p241l.C5120a;
import com.baidu.tts.tools.FileTools;
import com.baidu.tts.tools.StringTool;
import com.facebook.common.p141m.C2924g;
import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.http.Header;

/* compiled from: DownloadEngine */
/* renamed from: com.baidu.tts.d.a.b */
public class C5048b extends C4983a {
    /* renamed from: a */
    private volatile C5044a f20899a = this.f20900b;
    /* renamed from: b */
    private C5054i f20900b = new C5054i(this);
    /* renamed from: c */
    private C5052f f20901c = new C5052f(this);
    /* renamed from: f */
    private C5050d f20902f = new C5050d(this);
    /* renamed from: g */
    private C5053h f20903g = new C5053h(this);
    /* renamed from: h */
    private ThreadPoolExecutor f20904h;
    /* renamed from: i */
    private C5120a f20905i;

    /* compiled from: DownloadEngine */
    /* renamed from: com.baidu.tts.d.a.b$a */
    public class C5047a implements Callable<Void> {
        /* renamed from: a */
        final /* synthetic */ C5048b f20896a;
        /* renamed from: b */
        private C5049c f20897b;
        /* renamed from: c */
        private SyncHttpClient f20898c;

        public /* synthetic */ Object call() throws Exception {
            return m17051a();
        }

        public C5047a(C5048b c5048b, C5049c c5049c) {
            this.f20896a = c5048b;
            this.f20897b = c5049c;
        }

        /* renamed from: a */
        public Void m17051a() throws Exception {
            this.f20897b.m17080d();
            final String a = this.f20897b.m17074a();
            LoggerProxy.m17001d("DownloadEngine", "DownloadWork start fileId=" + a);
            if (StringTool.isEmpty(a)) {
                this.f20897b.m17076a(C5105c.m17295a().m17299a(C5097n.MODEL_REQUEST_ERROR, "fileId is null"));
            } else {
                Set hashSet = new HashSet();
                hashSet.add(a);
                ModelFileBags modelFileBags = (ModelFileBags) this.f20896a.f20905i.m17360a(hashSet).get();
                if (modelFileBags != null) {
                    String url = modelFileBags.getUrl(0);
                    if (url != null) {
                        if (url.startsWith(C2924g.f12888b)) {
                            this.f20898c = new SyncHttpClient(true, 80, 443);
                        } else {
                            this.f20898c = new SyncHttpClient();
                        }
                        this.f20898c.setURLEncodingEnabled(false);
                        this.f20898c.setTimeout(C5094l.DEFAULT.m17280b());
                        this.f20898c.setMaxRetriesAndTimeout(5, 1500);
                        ResponseHandlerInterface c50461 = new C5045g(this, FileTools.getFile(this.f20897b.m17078b()), this.f20897b) {
                            /* renamed from: b */
                            final /* synthetic */ C5047a f20895b;

                            public void onFailure(int statusCode, Header[] headers, Throwable throwable, File file) {
                                LoggerProxy.m17001d("DownloadEngine", "1isInterrupted=" + Thread.currentThread().isInterrupted());
                                if (this.f20895b.f20896a.m16613C()) {
                                    super.onFailure(statusCode, headers, throwable, file);
                                }
                            }

                            public void onSuccess(int statusCode, Header[] headers, File file) {
                                LoggerProxy.m17001d("DownloadEngine", "2isInterrupted=" + Thread.currentThread().isInterrupted() + "--fileId=" + a);
                                if (this.f20895b.f20896a.m16613C()) {
                                    super.onSuccess(statusCode, headers, file);
                                }
                            }

                            public void onProgress(long bytesWritten, long totalSize) {
                                if (this.f20895b.f20896a.m16613C()) {
                                    super.onProgress(bytesWritten, totalSize);
                                }
                            }
                        };
                        c50461.setUseSynchronousMode(true);
                        LoggerProxy.m17001d("DownloadEngine", "before get fileId=" + a);
                        this.f20898c.get(url, c50461);
                    } else {
                        this.f20897b.m17076a(C5105c.m17295a().m17299a(C5097n.MODEL_REQUEST_ERROR, "url is null"));
                    }
                } else {
                    this.f20897b.m17076a(C5105c.m17295a().m17299a(C5097n.MODEL_REQUEST_ERROR, "urlbags is null"));
                }
            }
            LoggerProxy.m17001d("DownloadEngine", "DownloadWork end");
            return null;
        }

        /* renamed from: b */
        public void m17052b() {
            if (this.f20898c != null) {
                this.f20898c.stop();
            }
        }

        /* renamed from: c */
        public C5049c m17053c() {
            return this.f20897b;
        }
    }

    public C5048b() {
        mo3782b();
    }

    /* renamed from: a */
    public void m17058a(C5120a c5120a) {
        this.f20905i = c5120a;
    }

    /* renamed from: a */
    public C5044a m17055a() {
        return this.f20899a;
    }

    /* renamed from: a */
    public void m17057a(C5044a c5044a) {
        this.f20899a = c5044a;
    }

    /* renamed from: o */
    public C5054i m17068o() {
        return this.f20900b;
    }

    /* renamed from: p */
    public C5052f m17069p() {
        return this.f20901c;
    }

    /* renamed from: q */
    public C5050d m17070q() {
        return this.f20902f;
    }

    /* renamed from: r */
    public C5053h m17071r() {
        return this.f20903g;
    }

    /* renamed from: g */
    protected TtsError mo3832g() {
        return this.f20899a.mo3782b();
    }

    /* renamed from: h */
    protected void mo3833h() {
        this.f20899a.mo3878a();
    }

    /* renamed from: i */
    protected void mo3834i() {
        this.f20899a.mo3784c();
    }

    /* renamed from: j */
    protected void mo3835j() {
        this.f20899a.mo3785d();
    }

    /* renamed from: k */
    protected void mo3836k() {
        this.f20899a.mo3786e();
    }

    /* renamed from: l */
    protected void mo3837l() {
        this.f20899a.mo3787f();
    }

    /* renamed from: m */
    public boolean mo3838m() {
        return this.f20899a == this.f20903g;
    }

    /* renamed from: n */
    public boolean mo3839n() {
        return Thread.currentThread().isInterrupted() || this.f20899a == this.f20901c;
    }

    /* renamed from: a */
    public C5051e m17056a(C5049c c5049c) {
        return this.f20899a.mo3877a(c5049c);
    }

    /* renamed from: s */
    void m17072s() {
        this.f20904h = (ThreadPoolExecutor) Executors.newFixedThreadPool(5, new C5102a("downloadPoolThread"));
    }

    /* renamed from: t */
    void m17073t() {
        LoggerProxy.m17001d("DownloadEngine", "enter stop");
        if (this.f20904h != null) {
            if (!this.f20904h.isShutdown()) {
                this.f20904h.shutdownNow();
            }
            try {
                LoggerProxy.m17001d("DownloadEngine", "before awaitTermination");
                LoggerProxy.m17001d("DownloadEngine", "after awaitTermination isTermination=" + this.f20904h.awaitTermination(C5094l.DEFAULT.m17279a(), TimeUnit.MILLISECONDS));
            } catch (InterruptedException e) {
            }
            this.f20904h = null;
        }
        LoggerProxy.m17001d("DownloadEngine", "end stop");
    }

    /* renamed from: b */
    C5051e m17059b(C5049c c5049c) {
        C5047a c5047a = new C5047a(this, c5049c);
        c5049c.m17079c();
        LoggerProxy.m17001d("DownloadEngine", "before submit");
        Future future = null;
        try {
            future = this.f20904h.submit(c5047a);
        } catch (Throwable e) {
            LoggerProxy.m17001d("DownloadEngine", "submit exception");
            c5049c.m17076a(C5105c.m17295a().m17300a(C5097n.MODEL_FILE_DOWNLOAD_EXCEPTION, e));
        }
        C5051e c5051e = new C5051e();
        c5051e.m17088a(future);
        c5051e.m17087a(c5047a);
        return c5051e;
    }
}
