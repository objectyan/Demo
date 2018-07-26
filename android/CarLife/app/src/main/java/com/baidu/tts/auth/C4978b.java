package com.baidu.tts.auth;

import android.content.Context;
import android.net.http.EventHandler;
import com.baidu.tts.aop.tts.TtsError;
import com.baidu.tts.chainofresponsibility.logger.LoggerProxy;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.p221k.C4975a;
import com.baidu.tts.p221k.C4977b;
import com.baidu.tts.p232e.C5076b;
import com.baidu.tts.p233f.C5097n;
import com.baidu.tts.p236h.p237a.C5105c;
import com.baidu.tts.p236h.p238b.C5107b;
import com.baidu.tts.tools.StringTool;
import java.io.File;

/* compiled from: OfflineAuth */
/* renamed from: com.baidu.tts.auth.b */
public class C4978b implements C4977b<C4978b, C4976a> {
    /* renamed from: a */
    private String f20682a;
    /* renamed from: b */
    private String f20683b;

    /* compiled from: OfflineAuth */
    /* renamed from: com.baidu.tts.auth.b$a */
    public static class C4976a implements C4975a {
        /* renamed from: a */
        private int f20677a;
        /* renamed from: b */
        private int f20678b = -1;
        /* renamed from: c */
        private String f20679c;
        /* renamed from: d */
        private String f20680d;
        /* renamed from: e */
        private TtsError f20681e;

        /* renamed from: a */
        public int m16577a() {
            return this.f20677a >= 1000 ? this.f20677a - 1000 : 0;
        }

        /* renamed from: a */
        public void m16578a(int i) {
            this.f20678b = i;
        }

        /* renamed from: a */
        public void m16580a(String str) {
            this.f20679c = str;
        }

        /* renamed from: b */
        public void m16582b(String str) {
            this.f20680d = str;
        }

        /* renamed from: b */
        public TtsError m16581b() {
            return this.f20681e;
        }

        /* renamed from: a */
        public void m16579a(TtsError ttsError) {
            if (ttsError != null) {
                LoggerProxy.m17001d("OfflineAuth", "this=" + this + "--error=" + ttsError.getDetailMessage());
            }
            this.f20681e = ttsError;
        }

        /* renamed from: c */
        public String m16583c() {
            if (m16585e()) {
                return "valid official";
            }
            if (m16584d()) {
                return "valid temp";
            }
            switch (this.f20677a) {
                case EventHandler.ERROR_UNSUPPORTED_SCHEME /*-10*/:
                    return "temp license expired";
                case EventHandler.ERROR_TIMEOUT /*-8*/:
                    return "license not exist or invalid license";
                case -7:
                    return "platform unmatched";
                case -6:
                    return "will expire after a month";
                case -5:
                    return "official license expired";
                case -4:
                    return "cuid unmatched";
                case -3:
                    return "sign or appcode unmatched";
                case -2:
                    return "package name unmatched";
                default:
                    return "not a valid result";
            }
        }

        /* renamed from: d */
        public boolean m16584d() {
            return this.f20677a >= 1000;
        }

        /* renamed from: e */
        public boolean m16585e() {
            return this.f20677a >= 0 && this.f20677a < 1000;
        }

        /* renamed from: f */
        public boolean m16586f() {
            return this.f20677a == -5 || this.f20677a == -6;
        }

        /* renamed from: g */
        public boolean mo3801g() {
            if (StringTool.isEmpty(this.f20679c)) {
                return false;
            }
            File file = new File(this.f20679c);
            if (!file.exists()) {
                return false;
            }
            C5107b a = C5107b.m17306a();
            Context h = a.m17316h();
            byte[] bArr = new byte[32];
            this.f20677a = EmbeddedSynthesizerEngine.bdTTSVerifyLicense(h, this.f20680d, a.m17317i(), this.f20679c, bArr);
            LoggerProxy.m17001d("OfflineAuth", "verify result=" + this.f20677a);
            if (bArr != null) {
                String str = new String(bArr);
                LoggerProxy.m17001d("OfflineAuth", "get appIdStr=" + str);
                try {
                    int indexOf = str.indexOf("end");
                    if (indexOf != -1) {
                        new C5076b(h, str.substring(0, indexOf)).start();
                    }
                } catch (Exception e) {
                    LoggerProxy.m17001d("OfflineAuth", "embedded statistics start exception=" + e.toString());
                }
            }
            if (this.f20677a >= 0) {
                return true;
            }
            LoggerProxy.m17001d("OfflineAuth", "isDelete=" + file.delete());
            return false;
        }
    }

    public /* synthetic */ Object call() throws Exception {
        return m16593c();
    }

    public /* synthetic */ int compareTo(Object x0) {
        return m16588a((C4978b) x0);
    }

    /* renamed from: a */
    public String m16589a() {
        return this.f20682a;
    }

    /* renamed from: a */
    public void m16590a(String str) {
        this.f20682a = str;
    }

    /* renamed from: b */
    public String m16591b() {
        return this.f20683b;
    }

    /* renamed from: b */
    public void m16592b(String str) {
        this.f20683b = str;
    }

    /* renamed from: a */
    public int m16588a(C4978b c4978b) {
        return (StringTool.isEqual(this.f20682a, c4978b.m16589a()) && StringTool.isEqual(this.f20683b, c4978b.m16591b())) ? 0 : 1;
    }

    /* renamed from: c */
    public C4976a m16593c() throws Exception {
        C4976a c4976a = new C4976a();
        c4976a.m16580a(this.f20683b);
        c4976a.m16582b(this.f20682a);
        if (!c4976a.mo3801g()) {
            C5107b a = C5107b.m17306a();
            Context h = a.m17316h();
            String i = a.m17317i();
            LoggerProxy.m17001d("OfflineAuth", "+ downloadLicense");
            int bdTTSGetLicense = EmbeddedSynthesizerEngine.bdTTSGetLicense(h, this.f20682a, i, "0", "", this.f20683b);
            LoggerProxy.m17001d("OfflineAuth", "- downloadLicense ret = " + bdTTSGetLicense);
            c4976a.m16578a(bdTTSGetLicense);
            if (bdTTSGetLicense < 0) {
                c4976a.m16579a(C5105c.m17295a().m17297a(C5097n.OFFLINE_ENGINE_DOWNLOAD_LICENSE_FAILED, bdTTSGetLicense, "appCode=" + this.f20682a + "--licensePath=" + this.f20683b));
            } else {
                c4976a.mo3801g();
            }
        }
        return c4976a;
    }
}
