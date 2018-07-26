package com.indooratlas.android.sdk._internal;

import android.bluetooth.BluetoothManager;
import java.util.Iterator;

abstract class df {
    /* renamed from: a */
    protected boolean f23382a;
    /* renamed from: b */
    final BluetoothManager f23383b;
    /* renamed from: c */
    private final dg f23384c;

    /* renamed from: a */
    abstract boolean mo4666a();

    /* renamed from: b */
    abstract boolean mo4667b();

    protected df(BluetoothManager bluetoothManager, dg dgVar) {
        this.f23383b = bluetoothManager;
        this.f23384c = dgVar;
    }

    /* renamed from: a */
    final void m20307a(dh dhVar) {
        dg dgVar = this.f23384c;
        synchronized (dgVar.f23389d) {
            Iterator it = dgVar.f23389d.iterator();
            while (it.hasNext()) {
                dh dhVar2 = (dh) it.next();
                if (dhVar2.f23394a != null && dhVar2.f23394a.equals(dhVar.f23394a)) {
                    it.remove();
                    break;
                }
            }
            dgVar.f23389d.add(dhVar);
        }
        if (dgVar.f23386a == null || dgVar.f23388c <= 100) {
            dgVar.m20320c();
        }
    }
}
