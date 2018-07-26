package com.baidu.mobstat;

import android.content.Context;
import java.io.File;
import java.util.Arrays;

class cc implements Runnable {
    /* renamed from: a */
    final /* synthetic */ Context f19551a;
    /* renamed from: b */
    final /* synthetic */ by f19552b;

    cc(by byVar, Context context) {
        this.f19552b = byVar;
        this.f19551a = context;
    }

    public void run() {
        File filesDir = this.f19551a.getFilesDir();
        if (filesDir != null && filesDir.exists()) {
            String[] list = filesDir.list(new cd(this));
            if (list != null && list.length != 0) {
                try {
                    Arrays.sort(list, new ce(this));
                } catch (Throwable e) {
                    db.m15662b(e);
                }
                try {
                    int i = 0;
                    for (String str : list) {
                        String a = cu.m15628a(this.f19551a, str);
                        if (this.f19552b.m15533b(this.f19551a, a)) {
                            cu.m15634b(this.f19551a, str);
                            i = 0;
                        } else {
                            by.m15532b(this.f19551a, str, a);
                            i++;
                            if (i >= 5) {
                                return;
                            }
                        }
                    }
                } catch (Throwable e2) {
                    db.m15662b(e2);
                }
            }
        }
    }
}
