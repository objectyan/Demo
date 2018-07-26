package com.indooratlas.android.sdk._internal;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;

@TargetApi(18)
final class dk extends df implements LeScanCallback {
    dk(BluetoothManager bluetoothManager, dg dgVar) {
        super(bluetoothManager, dgVar);
    }

    /* renamed from: a */
    final boolean mo4666a() {
        if (this.a) {
            return false;
        }
        BluetoothAdapter adapter = this.b.getAdapter();
        if (adapter != null && (adapter.getState() == 12 || adapter.getState() == 11)) {
            adapter.startLeScan(this);
            this.a = true;
        }
        String str = cz.f23362a;
        new StringBuilder("BLE scan started: ").append(this.a);
        return this.a;
    }

    /* renamed from: b */
    final boolean mo4667b() {
        if (!this.a) {
            return false;
        }
        BluetoothAdapter adapter = this.b.getAdapter();
        if (adapter != null) {
            adapter.stopLeScan(this);
        }
        this.a = false;
        return true;
    }

    public final void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
        String str = null;
        String name = device != null ? device.getName() : null;
        if (device != null) {
            str = device.getAddress();
        }
        dh a = dl.m20330a(name, str, rssi, scanRecord);
        if (a != null) {
            super.m20307a(a);
        }
    }
}
