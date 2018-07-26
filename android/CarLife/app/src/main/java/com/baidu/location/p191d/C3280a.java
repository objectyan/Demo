package com.baidu.location.p191d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.os.Build.VERSION;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.location.C3377f;

/* renamed from: com.baidu.location.d.a */
public class C3280a {
    /* renamed from: a */
    private static C3280a f17789a = null;
    /* renamed from: b */
    private BluetoothAdapter f17790b;

    C3280a() {
        if (this.f17790b != null) {
            return;
        }
        if (VERSION.SDK_INT > 17) {
            this.f17790b = ((BluetoothManager) C3377f.getServiceContext().getSystemService(C1981b.f6363c)).getAdapter();
        } else {
            this.f17790b = BluetoothAdapter.getDefaultAdapter();
        }
    }

    /* renamed from: a */
    public static C3280a m13723a() {
        if (f17789a == null) {
            f17789a = new C3280a();
        }
        return f17789a;
    }

    /* renamed from: b */
    public String m13724b() {
        return this.f17790b != null ? "" + this.f17790b.getState() + "|" + this.f17790b.getScanMode() : "-1|-1";
    }
}
