package com.baidu.tts.p229d.p231b;

import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.database.C5068a;
import com.baidu.tts.p229d.p230a.C5051e;
import com.baidu.tts.p233f.C5089g;
import com.baidu.tts.tools.DataTool;
import com.baidu.tts.tools.MD5;
import com.baidu.tts.tools.StringTool;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: FsFileInfoFlyweight */
/* renamed from: com.baidu.tts.d.b.b */
public class C5057b {
    /* renamed from: a */
    private String f20914a;
    /* renamed from: b */
    private long f20915b;
    /* renamed from: c */
    private String f20916c;
    /* renamed from: d */
    private volatile int f20917d = 0;
    /* renamed from: e */
    private volatile int f20918e = 9;
    /* renamed from: f */
    private String f20919f;
    /* renamed from: g */
    private C5051e f20920g;
    /* renamed from: h */
    private CopyOnWriteArraySet<String> f20921h = new CopyOnWriteArraySet();

    public C5057b(String str) {
        this.f20914a = str;
    }

    /* renamed from: a */
    public void m17118a(String str) {
        if (this.f20921h != null) {
            this.f20921h.add(str);
        }
    }

    /* renamed from: b */
    public void m17122b(String str) {
        boolean isSetEmpty = DataTool.isSetEmpty(this.f20921h);
        LoggerProxy.m17001d("FsFileInfoFlyweight", "unregisterObserver 1isEmpty=" + isSetEmpty);
        if (!isSetEmpty) {
            this.f20921h.remove(str);
            isSetEmpty = DataTool.isSetEmpty(this.f20921h);
            LoggerProxy.m17001d("FsFileInfoFlyweight", "unregisterObserver 2isEmpty=" + isSetEmpty);
            if (isSetEmpty) {
                m17112j();
            }
        }
    }

    /* renamed from: j */
    private void m17112j() {
        if (this.f20920g != null) {
            LoggerProxy.m17001d("FsFileInfoFlyweight", "unregisterObserver stop");
            this.f20920g.m17086a();
            this.f20920g = null;
            if (this.f20917d == 4 || this.f20917d == 5) {
                this.f20917d = 8;
                this.f20918e = 8;
                C5056a.m17101a().m17107b().m17212a(this.f20914a, this.f20918e);
            }
        }
    }

    /* renamed from: a */
    public long m17114a() {
        return this.f20915b;
    }

    /* renamed from: a */
    public void m17117a(C5051e c5051e) {
        this.f20920g = c5051e;
    }

    /* renamed from: b */
    public String m17121b() {
        return this.f20914a;
    }

    /* renamed from: c */
    public String m17123c() {
        return this.f20919f;
    }

    /* renamed from: c */
    public void m17124c(String str) {
        this.f20919f = str;
    }

    /* renamed from: d */
    public int m17125d() {
        return this.f20917d;
    }

    /* renamed from: a */
    public boolean m17119a(C5068a c5068a) {
        C5058c b = C5060e.m17155a().m17159b(this.f20919f);
        if (this.f20917d == 0) {
            m17113a(b);
            m17120b(c5068a);
        } else if (this.f20917d == 8 || this.f20917d == 7) {
            m17113a(b);
        }
        if (this.f20917d == 7 && this.f20918e != 7) {
            this.f20918e = 7;
            c5068a.m17212a(this.f20914a, this.f20918e);
        }
        LoggerProxy.m17001d("FsFileInfoFlyweight", "fileId=" + this.f20919f + "--filestate=" + this.f20917d + "--dbstate=" + this.f20918e);
        if (this.f20917d == 4 || this.f20917d == 5 || this.f20917d == 7) {
            return false;
        }
        return true;
    }

    /* renamed from: e */
    public boolean m17126e() {
        if (this.f20917d == 7 || this.f20917d == 4 || this.f20917d == 5) {
            return false;
        }
        if (this.f20915b >= Long.parseLong(C5060e.m17155a().m17159b(this.f20919f).m17134b())) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    public boolean m17127f() {
        return new File(this.f20914a).delete();
    }

    /* renamed from: b */
    public int m17120b(C5068a c5068a) {
        String mapValue = DataTool.getMapValue(c5068a.m17215c(this.f20914a), C5089g.STATE.m17274b());
        if (StringTool.isEmpty(mapValue)) {
            this.f20918e = 9;
        } else {
            this.f20918e = Integer.parseInt(mapValue);
        }
        return this.f20918e;
    }

    /* renamed from: a */
    public int m17113a(C5058c c5058c) {
        File file = new File(this.f20914a);
        if (file.exists()) {
            this.f20915b = file.length();
            if (this.f20915b == Long.parseLong(c5058c.m17134b())) {
                this.f20916c = MD5.getInstance().getBigFileMd5(file);
                if (c5058c.m17135c().equalsIgnoreCase(this.f20916c)) {
                    this.f20917d = 7;
                } else {
                    this.f20917d = 3;
                }
            } else {
                this.f20917d = 2;
            }
        } else {
            this.f20917d = 1;
        }
        return this.f20917d;
    }

    /* renamed from: g */
    public void m17128g() {
        LoggerProxy.m17001d("FsFileInfoFlyweight", "queueForDownload fileId=" + this.f20919f + "--filestate=" + this.f20917d);
        this.f20917d = 4;
    }

    /* renamed from: h */
    public void m17129h() {
        this.f20917d = 5;
        this.f20918e = 6;
        C5056a.m17101a().m17107b().m17212a(this.f20914a, this.f20918e);
    }

    /* renamed from: a */
    public void m17115a(long j, long j2) {
        C5056a a = C5056a.m17101a();
        this.f20915b = j;
        if (this.f20921h != null) {
            Iterator it = this.f20921h.iterator();
            while (it.hasNext()) {
                a.m17106b((String) it.next()).m17141a(this);
            }
        }
    }

    /* renamed from: i */
    public void m17130i() {
        LoggerProxy.m17001d("FsFileInfoFlyweight", "onDownloadSuccess");
        this.f20917d = 7;
        this.f20918e = 7;
        C5056a a = C5056a.m17101a();
        a.m17107b().m17212a(this.f20914a, this.f20918e);
        if (this.f20921h != null) {
            Iterator it = this.f20921h.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                a.m17106b(str).m17146b(this);
                this.f20921h.remove(str);
            }
        }
    }

    /* renamed from: a */
    public void m17116a(TtsError ttsError) {
        LoggerProxy.m17001d("FsFileInfoFlyweight", "onDownloadFailure");
        this.f20917d = 8;
        this.f20918e = 8;
        C5056a a = C5056a.m17101a();
        a.m17107b().m17212a(this.f20914a, this.f20918e);
        if (this.f20921h != null) {
            Iterator it = this.f20921h.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                a.m17106b(str).m17142a(this, ttsError);
                this.f20921h.remove(str);
            }
        }
    }
}
