package com.baidu.mobstat;

import android.content.Context;
import android.content.Intent;
import com.baidu.bottom.service.BottomReceiver;
import com.baidu.navisdk.util.common.HttpsClient;

public class at extends Thread {
    /* renamed from: a */
    final /* synthetic */ Context f19398a;
    /* renamed from: b */
    final /* synthetic */ Intent f19399b;
    /* renamed from: c */
    final /* synthetic */ dd f19400c;
    /* renamed from: d */
    final /* synthetic */ BottomReceiver f19401d;

    public at(BottomReceiver bottomReceiver, Context context, Intent intent, dd ddVar) {
        this.f19401d = bottomReceiver;
        this.f19398a = context;
        this.f19399b = intent;
        this.f19400c = ddVar;
    }

    public void run() {
        try {
            BottomReceiver.a(this.f19401d, this.f19398a, this.f19399b);
            BottomReceiver.b(this.f19401d, this.f19398a, this.f19399b);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - BottomReceiver.a() < HttpsClient.CONN_MGR_TIMEOUT) {
                bd.m15428a("No need to handle receiver due to time strategy");
                return;
            }
            BottomReceiver.a(currentTimeMillis);
            ao.RECEIVER.mo2725a(this.f19398a);
            this.f19400c.m15672b();
            BottomReceiver.a(null);
        } catch (Throwable th) {
        } finally {
            this.f19400c.m15672b();
            BottomReceiver.a(null);
        }
    }
}
