package com.baidu.tts.client.model;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.p229d.C5055a;
import com.baidu.tts.p229d.C5061b;
import com.baidu.tts.p229d.p231b.C5056a;
import com.baidu.tts.p229d.p231b.C5059d;
import com.baidu.tts.p241l.C5120a;
import java.util.UUID;
import java.util.concurrent.Future;

public class DownloadHandler {
    public static final int DOWNLOAD_SUCCESS = 0;
    /* renamed from: a */
    private C5061b f20850a;
    /* renamed from: b */
    private Future<C5055a> f20851b;
    /* renamed from: c */
    private TtsError f20852c;
    /* renamed from: d */
    private C5056a f20853d = C5056a.m17101a();
    /* renamed from: e */
    private volatile boolean f20854e = false;
    /* renamed from: f */
    private C5120a f20855f;
    /* renamed from: g */
    private RecordData f20856g = null;
    /* renamed from: h */
    private String f20857h = UUID.randomUUID().toString();

    public DownloadHandler(C5120a modelMediator) {
        this.f20855f = modelMediator;
    }

    public String getModelId() {
        return this.f20850a.m17165a();
    }

    /* renamed from: a */
    private OnDownloadListener m17036a() {
        return this.f20850a.m17169c();
    }

    public void setCheckFuture(Future<C5055a> checkFuture) {
        this.f20851b = checkFuture;
    }

    public void setTtsError(TtsError ttsError) {
        this.f20852c = ttsError;
    }

    public TtsError getTtsError() {
        return this.f20852c;
    }

    public int getErrorCode() {
        return getErrorCode(this.f20852c);
    }

    public int getErrorCode(TtsError ttsError) {
        return ttsError != null ? ttsError.getDetailCode() : 0;
    }

    public String getErrorMessage() {
        return getErrorMessage(this.f20852c);
    }

    public String getErrorMessage(TtsError ttsError) {
        return ttsError != null ? ttsError.getDetailMessage() : null;
    }

    public C5061b getDownloadParams() {
        return this.f20850a;
    }

    public void setDownloadParams(C5061b downloadParams) {
        this.f20850a = downloadParams;
    }

    public void reset(C5061b params) {
        setDownloadParams(params);
        reset();
    }

    public synchronized void reset() {
        LoggerProxy.m17001d("DownloadHandler", "reset");
        this.f20854e = false;
    }

    public synchronized void stop() {
        LoggerProxy.m17001d("DownloadHandler", "stop");
        this.f20854e = true;
        if (this.f20851b != null) {
            this.f20851b.cancel(true);
            this.f20851b = null;
        }
        this.f20853d.m17103a(this);
        this.f20850a.m17166a(null);
    }

    public void updateStart(C5059d model) {
        m17037a(model.m17152g());
    }

    public void updateProgress(C5059d model) {
        m17039a(model.m17152g(), model.m17153h(), model.m17147c());
    }

    public void updateFinish(C5059d model, TtsError ttsError) {
        updateFinish(model.m17152g(), ttsError);
    }

    public void updateFinish(String modelId, TtsError ttsError) {
        setTtsError(ttsError);
        m17038a(modelId, getErrorCode());
    }

    /* renamed from: a */
    private void m17037a(String str) {
        this.f20856g = new RecordData(this.f20855f);
        synchronized (this) {
            if (Statistics.isStatistics) {
                this.f20856g.setStartInfo(this.f20857h, str, System.currentTimeMillis() + "");
            }
        }
        OnDownloadListener a = m17036a();
        if (a != null) {
            synchronized (this) {
                if (!this.f20854e) {
                    a.onStart(str);
                }
            }
        }
    }

    /* renamed from: a */
    private void m17039a(String str, long j, long j2) {
        OnDownloadListener a = m17036a();
        if (a != null) {
            synchronized (this) {
                if (!this.f20854e) {
                    a.onProgress(str, j, j2);
                }
            }
        }
    }

    /* renamed from: a */
    private void m17038a(String str, int i) {
        if (Statistics.isStatistics) {
            this.f20856g.setEndInfo(this.f20857h, str, i, System.currentTimeMillis() + "");
        }
        OnDownloadListener a = m17036a();
        if (a != null) {
            synchronized (this) {
                if (!this.f20854e) {
                    a.onFinish(str, i);
                    this.f20850a.m17166a(null);
                }
            }
        }
        synchronized (this) {
            if (Statistics.isStatistics) {
                this.f20856g.setEndInfo(this.f20857h, str, i, System.currentTimeMillis() + "");
            }
            if (Statistics.isStatistics) {
                LoggerProxy.m17001d("DownloadHandler", " statistics ret=" + new Statistics(this.f20855f.m17371d()).start());
            }
        }
    }
}
