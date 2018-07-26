package com.baidu.platform.comapi.p134f;

import com.baidu.mapframework.nirvana.concurrent.ConcurrentTask;
import com.baidu.platform.comapi.util.JsonBuilder;

/* compiled from: VersionUpdater */
/* renamed from: com.baidu.platform.comapi.f.f$2 */
class f$2 extends ConcurrentTask {
    /* renamed from: a */
    final /* synthetic */ String f19839a;
    /* renamed from: b */
    final /* synthetic */ JsonBuilder f19840b;
    /* renamed from: c */
    final /* synthetic */ C2910f f19841c;

    f$2(C2910f this$0, String str, JsonBuilder jsonBuilder) {
        this.f19841c = this$0;
        this.f19839a = str;
        this.f19840b = jsonBuilder;
    }

    public void run() {
        C2910f.a(this.f19841c).setVerUpdateParams(this.f19839a, this.f19840b.getJson());
    }
}
