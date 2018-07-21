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
final class dj
  extends df
{
  private ScanCallback c = new ScanCallback()
  {
    public final void onBatchScanResults(List<ScanResult> paramAnonymousList)
    {
      super.onBatchScanResults(paramAnonymousList);
    }
    
    public final void onScanFailed(int paramAnonymousInt)
    {
      super.onScanFailed(paramAnonymousInt);
    }
    
    public final void onScanResult(int paramAnonymousInt, ScanResult paramAnonymousScanResult)
    {
      super.onScanResult(paramAnonymousInt, paramAnonymousScanResult);
      ScanRecord localScanRecord = paramAnonymousScanResult.getScanRecord();
      BluetoothDevice localBluetoothDevice = paramAnonymousScanResult.getDevice();
      if (localBluetoothDevice != null) {}
      for (Object localObject = localBluetoothDevice.getAddress();; localObject = null)
      {
        if ((localScanRecord != null) && (localObject != null))
        {
          localObject = new dh((String)localObject, localBluetoothDevice.getName(), paramAnonymousScanResult.getTimestampNanos() / 1000L, paramAnonymousScanResult.getRssi(), localScanRecord.getServiceUuids(), localScanRecord.getManufacturerSpecificData(), localScanRecord.getServiceData(), localScanRecord.getAdvertiseFlags(), localScanRecord.getTxPowerLevel(), localScanRecord.getDeviceName());
          paramAnonymousScanResult = dl.a(localScanRecord.getBytes(), paramAnonymousScanResult.getRssi());
          if (paramAnonymousScanResult != null)
          {
            ((dh)localObject).h = paramAnonymousScanResult.e;
            ((dh)localObject).k = paramAnonymousScanResult;
          }
          dj.this.a((dh)localObject);
        }
        return;
      }
    }
  };
  
  dj(BluetoothManager paramBluetoothManager, dg paramdg)
  {
    super(paramBluetoothManager, paramdg);
  }
  
  private BluetoothLeScanner c()
  {
    BluetoothAdapter localBluetoothAdapter = this.b.getAdapter();
    if ((localBluetoothAdapter != null) && ((localBluetoothAdapter.getState() == 12) || (localBluetoothAdapter.getState() == 11))) {
      return localBluetoothAdapter.getBluetoothLeScanner();
    }
    return null;
  }
  
  final boolean a()
  {
    if (this.a) {
      return false;
    }
    Object localObject = c();
    if (localObject != null)
    {
      ((BluetoothLeScanner)localObject).startScan(null, new ScanSettings.Builder().setScanMode(2).build(), this.c);
      this.a = true;
      ((BluetoothLeScanner)localObject).flushPendingScanResults(this.c);
    }
    localObject = cz.a;
    new StringBuilder("BLE scan started: ").append(this.a);
    return this.a;
  }
  
  final boolean b()
  {
    if (!this.a) {
      return false;
    }
    Object localObject = c();
    if (localObject != null) {
      ((BluetoothLeScanner)localObject).stopScan(this.c);
    }
    this.a = false;
    localObject = cz.a;
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/dj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */