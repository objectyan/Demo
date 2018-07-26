package com.baidu.platform.comapi.p208c;

import com.baidu.mapframework.nirvana.concurrent.ConcurrentManager;
import com.baidu.mapframework.nirvana.concurrent.ConcurrentTask;
import com.baidu.mapframework.nirvana.concurrent.QueueToken;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.platform.comapi.C2907c;
import com.baidu.platform.comapi.util.C2911f;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.baidu.platform.comapi.util.NetworkUtil;
import com.baidu.platform.comapi.util.SysOSAPIv2;
import com.baidu.platform.comjni.base.networkdetect.NANetworkDetect;
import com.baidu.platform.comjni.engine.NAEngine;

/* compiled from: NetworkLogic */
/* renamed from: com.baidu.platform.comapi.c.b */
public class C4766b {
    /* renamed from: a */
    private static final String f19796a = "triggerType";
    /* renamed from: b */
    private static final String f19797b = "foreground";
    /* renamed from: c */
    private static final String f19798c = "netchanged";
    /* renamed from: d */
    private static final String f19799d = "nettype";
    /* renamed from: e */
    private static final String f19800e = "telecomtype";
    /* renamed from: f */
    private static QueueToken f19801f = ConcurrentManager.obtainTaskQueue(Module.NETWORK_DETECT);
    /* renamed from: g */
    private NANetworkDetect f19802g;

    /* compiled from: NetworkLogic */
    /* renamed from: com.baidu.platform.comapi.c.b$1 */
    class C47631 extends ConcurrentTask {
        /* renamed from: a */
        final /* synthetic */ C4766b f19793a;

        C47631(C4766b this$0) {
            this.f19793a = this$0;
        }

        public void run() {
            this.f19793a.m15832b(C4766b.f19797b);
        }
    }

    /* compiled from: NetworkLogic */
    /* renamed from: com.baidu.platform.comapi.c.b$2 */
    class C47642 extends ConcurrentTask {
        /* renamed from: a */
        final /* synthetic */ C4766b f19794a;

        C47642(C4766b this$0) {
            this.f19794a = this$0;
        }

        public void run() {
            this.f19794a.m15832b(C4766b.f19798c);
        }
    }

    /* compiled from: NetworkLogic */
    /* renamed from: com.baidu.platform.comapi.c.b$a */
    private static final class C4765a {
        /* renamed from: a */
        private static final C4766b f19795a = new C4766b();

        private C4765a() {
        }
    }

    private C4766b() {
    }

    /* renamed from: a */
    public static C4766b m15829a() {
        return C4765a.f19795a;
    }

    /* renamed from: b */
    public void m15834b() {
        C2911f.b("NetworkLogic", "onStartup");
        NAEngine.startSocketProc();
    }

    /* renamed from: c */
    public void m15835c() {
        C2911f.b("NetworkLogic", "onForeground");
        C4766b.m15830a(new C47631(this));
        NAEngine.restartLongLink();
    }

    /* renamed from: d */
    public void m15836d() {
        C2911f.b("NetworkLogic", "onBackground,stopLongLink");
        NAEngine.stopLongLink();
    }

    /* renamed from: a */
    public void m15833a(String curNetType) {
        C2911f.b("NetworkLogic", "onNetWorkChanged-" + curNetType);
        if (curNetType != null && !curNetType.equals(SysOSAPIv2.getInstance().getNetType())) {
            C4766b.m15830a(new C47642(this));
        }
    }

    /* renamed from: b */
    private void m15832b(String triggerType) {
        C2911f.b("NetworkLogic", "NetworkDetect");
        if (this.f19802g == null) {
            this.f19802g = new NANetworkDetect();
            this.f19802g.create();
        }
        String type = NetworkUtil.getCurrentNetMode(C2907c.f());
        NetworkUtil.updateNetworkProxy(C2907c.f());
        SysOSAPIv2.getInstance().updateNetType(type);
        if (this.f19802g != null) {
            try {
                JsonBuilder jsonBuilder = new JsonBuilder();
                jsonBuilder.object();
                try {
                    jsonBuilder.key(f19799d).value(Integer.parseInt(type));
                } catch (NumberFormatException e) {
                    jsonBuilder.key(f19799d).value(-1);
                }
                jsonBuilder.key(f19800e).value(NetworkUtil.getNetworkOperatorType(C2907c.f()));
                jsonBuilder.key(f19796a).value(triggerType);
                jsonBuilder.endObject();
                this.f19802g.networkDetect(jsonBuilder.toString());
            } catch (Exception e2) {
            }
        }
    }

    /* renamed from: e */
    public void m15837e() {
        C2911f.b("NetworkLogic", "onExit");
        if (this.f19802g != null) {
            this.f19802g = null;
        }
    }

    /* renamed from: a */
    private static synchronized void m15830a(ConcurrentTask task) {
        synchronized (C4766b.class) {
            task.setQueueToken(f19801f);
            ConcurrentManager.executeTask(Module.NETWORK_DETECT, task, ScheduleConfig.forData());
        }
    }
}
