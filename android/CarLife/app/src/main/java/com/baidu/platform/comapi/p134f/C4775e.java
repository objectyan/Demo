package com.baidu.platform.comapi.p134f;

import android.os.Message;
import com.baidu.platform.comapi.UIMsg.d_ResultType;

/* compiled from: VerUpNotifier */
/* renamed from: com.baidu.platform.comapi.f.e */
class C4775e {
    /* renamed from: a */
    private C4773c f19838a = null;

    C4775e() {
    }

    /* renamed from: a */
    void m15864a(C4773c mListener) {
        this.f19838a = mListener;
    }

    /* renamed from: a */
    void m15862a() {
        this.f19838a = null;
    }

    /* renamed from: a */
    public void m15863a(Message msg) {
        if (msg.what == 2000 || msg.what == 2004 || msg.what == 2005 || msg.what == 2006 || msg.what == 2009) {
            switch (msg.arg1) {
                case 501:
                    if (this.f19838a == null) {
                        return;
                    }
                    if (msg.what == 2000) {
                        this.f19838a.m15858a(msg.arg2);
                        return;
                    } else {
                        this.f19838a.m15859a(msg.what, msg.arg2);
                        return;
                    }
                case 502:
                    if (this.f19838a == null) {
                        return;
                    }
                    if (msg.arg2 == 255 || msg.arg2 == 256) {
                        this.f19838a.m15860a(msg.what, msg.arg2, 0);
                        return;
                    } else if (msg.arg2 == 4 && msg.what == 2000) {
                        this.f19838a.m15860a(msg.what, msg.arg2, 0);
                        return;
                    } else if (msg.what == 2000) {
                        this.f19838a.m15858a(msg.arg2);
                        return;
                    } else if (msg.arg2 == 405) {
                        this.f19838a.m15858a(msg.arg2);
                        return;
                    } else {
                        this.f19838a.m15860a(msg.what, 0, msg.arg2);
                        return;
                    }
                case d_ResultType.NEWVERSION_DOWNLOAD_FOR_ANDROID_MODEL /*502502*/:
                    if (this.f19838a == null) {
                        return;
                    }
                    if (msg.arg2 == 255 || msg.arg2 == 256) {
                        this.f19838a.m15860a(msg.what, msg.arg2, 0);
                        return;
                    } else if (msg.arg2 == C4771a.f19816h && msg.what == 2004) {
                        this.f19838a.m15860a(msg.what, msg.arg2, 0);
                        return;
                    } else if (msg.arg2 == C4771a.f19815g && msg.what == 2004) {
                        this.f19838a.m15861b(msg.what, msg.arg2);
                        return;
                    } else if (msg.arg2 == 801 && msg.what == 2004) {
                        this.f19838a.m15861b(msg.what, msg.arg2);
                        return;
                    } else if (msg.arg2 == 405 || msg.arg2 == C4771a.f19815g) {
                        this.f19838a.m15858a(msg.arg2);
                        return;
                    } else {
                        this.f19838a.m15860a(msg.what, 0, msg.arg2);
                        return;
                    }
                default:
                    return;
            }
        }
    }
}
