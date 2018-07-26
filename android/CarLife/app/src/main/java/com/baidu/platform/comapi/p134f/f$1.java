package com.baidu.platform.comapi.p134f;

import com.baidu.mapframework.nirvana.concurrent.ConcurrentTask;

/* compiled from: VersionUpdater */
/* renamed from: com.baidu.platform.comapi.f.f$1 */
class f$1 extends ConcurrentTask {
    f$1() {
    }

    public void run() {
        if (C2910f.d() != null) {
            if (C2910f.a(C2910f.d()) != null) {
                C2910f.a(C2910f.d()).release();
                C2910f.a(C2910f.d(), null);
            }
            C2910f.b(null);
        }
    }
}
