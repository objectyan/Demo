package com.baidu.platform.comapi;

import android.content.Context;
import android.os.Bundle;
import com.baidu.platform.comjni.engine.MessageProxy;
import com.baidu.platform.comjni.engine.NAEngine;
import com.baidu.vi.VMsg;

/* compiled from: EngineManager */
/* renamed from: com.baidu.platform.comapi.b */
class C2906b {
    /* renamed from: a */
    static boolean f12693a = false;
    /* renamed from: b */
    private NAEngine f12694b;

    /* renamed from: a */
    public boolean m10966a(Context context) {
        f12693a = false;
        VMsg.init();
        this.f12694b = new NAEngine();
        if (NAEngine.initEngine(context, null) && NAEngine.initLongLinkClient()) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public boolean m10965a() {
        if (!f12693a) {
            f12693a = true;
        }
        return true;
    }

    /* renamed from: b */
    public boolean m10967b() {
        f12693a = false;
        return true;
    }

    /* renamed from: c */
    public Bundle m10968c() {
        Bundle b = new Bundle();
        NAEngine.getFlaxLength(b);
        return b;
    }

    /* renamed from: d */
    public void m10969d() {
        if (f12693a) {
            m10967b();
        }
        VMsg.destroy();
        MessageProxy.destroy();
        NAEngine.unInitEngine();
    }
}
