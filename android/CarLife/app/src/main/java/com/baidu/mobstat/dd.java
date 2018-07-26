package com.baidu.mobstat;

import android.net.LocalServerSocket;
import java.io.IOException;

public final class dd {
    /* renamed from: a */
    private LocalServerSocket f19629a;

    /* renamed from: a */
    public final synchronized boolean m15671a() {
        boolean z;
        try {
            if (this.f19629a == null) {
                this.f19629a = new LocalServerSocket("com.baidu.mobstat.bplus");
                z = true;
            }
        } catch (IOException e) {
        }
        z = false;
        return z;
    }

    /* renamed from: b */
    public final synchronized void m15672b() {
        if (this.f19629a != null) {
            try {
                this.f19629a.close();
                this.f19629a = null;
            } catch (IOException e) {
            }
        }
    }
}
