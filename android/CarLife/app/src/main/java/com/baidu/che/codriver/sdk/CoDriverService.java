package com.baidu.che.codriver.sdk;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.baidu.che.codriver.sdk.p081a.C2606l;
import com.baidu.che.codriver.util.C2725h;

public class CoDriverService extends Service {
    /* renamed from: a */
    private static final String f8535a = "[sdk_server] CoDriverService";
    /* renamed from: b */
    private C2618b f8536b;

    public void onCreate() {
        super.onCreate();
        C2725h.m10207b(f8535a, "onCreate");
        this.f8536b = new C2618b();
        C2606l.m9828a().m9830a(this.f8536b);
    }

    public IBinder onBind(Intent intent) {
        C2725h.m10207b(f8535a, "onBind");
        return this.f8536b;
    }
}
