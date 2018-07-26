package com.tencent.wxop.stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* renamed from: com.tencent.wxop.stat.b */
class C6152b extends BroadcastReceiver {
    /* renamed from: a */
    final /* synthetic */ C6162l f24967a;

    C6152b(C6162l c6162l) {
        this.f24967a = c6162l;
    }

    public void onReceive(Context context, Intent intent) {
        if (this.f24967a.f25118e != null) {
            this.f24967a.f25118e.m21844a(new aq(this));
        }
    }
}
