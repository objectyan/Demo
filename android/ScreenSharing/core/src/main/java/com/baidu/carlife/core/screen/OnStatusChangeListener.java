package com.baidu.carlife.core.screen;

import android.content.Intent;
import com.baidu.carlife.core.KeepClass;

/* compiled from: OnStatusChangeListener */
/* renamed from: com.baidu.carlife.core.screen.j */
public interface OnStatusChangeListener extends KeepClass {
    /* renamed from: a */
    void mo1346a(int i, int i2);

    /* renamed from: a */
    void startActivity(Intent intent, int i);

    /* renamed from: o */
    void onVehicleConnected();

    /* renamed from: p */
    void onVehicleDisconnect();

    /* renamed from: q */
    boolean mo1356q();
}
