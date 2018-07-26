package com.indooratlas.android.sdk._internal;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings.Builder;
import java.util.List;

@TargetApi(21)
final class dj extends df {
    /* renamed from: c */
    private ScanCallback f23412c = new C58491(this);

    /* renamed from: com.indooratlas.android.sdk._internal.dj$1 */
    class C58491 extends ScanCallback {
        /* renamed from: a */
        final /* synthetic */ dj f23411a;

        C58491(dj djVar) {
            this.f23411a = djVar;
        }

        public final void onScanResult(int callbackType, ScanResult result) {
            super.onScanResult(callbackType, result);
            ScanRecord scanRecord = result.getScanRecord();
            BluetoothDevice device = result.getDevice();
            String address = device != null ? device.getAddress() : null;
            if (scanRecord != null && address != null) {
                dh dhVar = new dh(address, device.getName(), result.getTimestampNanos() / 1000, result.getRssi(), scanRecord.getServiceUuids(), scanRecord.getManufacturerSpecificData(), scanRecord.getServiceData(), scanRecord.getAdvertiseFlags(), scanRecord.getTxPowerLevel(), scanRecord.getDeviceName());
                di a = dl.m20331a(scanRecord.getBytes(), result.getRssi());
                if (a != null) {
                    dhVar.f23401h = a.f23409e;
                    dhVar.f23404k = a;
                }
                this.f23411a.m20307a(dhVar);
            }
        }

        public final void onBatchScanResults(List<ScanResult> results) {
            super.onBatchScanResults(results);
        }

        public final void onScanFailed(int errorCode) {
            super.onScanFailed(errorCode);
        }
    }

    dj(BluetoothManager bluetoothManager, dg dgVar) {
        super(bluetoothManager, dgVar);
    }

    /* renamed from: a */
    final boolean mo4666a() {
        if (this.a) {
            return false;
        }
        BluetoothLeScanner c = m20323c();
        if (c != null) {
            c.startScan(null, new Builder().setScanMode(2).build(), this.f23412c);
            this.a = true;
            c.flushPendingScanResults(this.f23412c);
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
        BluetoothLeScanner c = m20323c();
        if (c != null) {
            c.stopScan(this.f23412c);
        }
        this.a = false;
        String str = cz.f23362a;
        return true;
    }

    /* renamed from: c */
    private BluetoothLeScanner m20323c() {
        BluetoothAdapter adapter = this.b.getAdapter();
        if (adapter == null || (adapter.getState() != 12 && adapter.getState() != 11)) {
            return null;
        }
        return adapter.getBluetoothLeScanner();
    }
}
