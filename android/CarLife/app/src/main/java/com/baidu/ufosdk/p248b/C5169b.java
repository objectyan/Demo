package com.baidu.ufosdk.p248b;

import java.io.IOException;

/* compiled from: LogcatCollector */
/* renamed from: com.baidu.ufosdk.b.b */
final class C5169b implements Runnable {
    /* renamed from: a */
    private final /* synthetic */ Process f21381a;

    C5169b(Process process) {
        this.f21381a = process;
    }

    public final void run() {
        try {
            do {
            } while (this.f21381a.getErrorStream().read(new byte[8192]) >= 0);
        } catch (IOException e) {
        }
    }
}
