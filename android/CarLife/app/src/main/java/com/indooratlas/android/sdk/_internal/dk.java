package com.indooratlas.android.sdk._internal;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;

@TargetApi(18)
final class dk
  extends df
  implements BluetoothAdapter.LeScanCallback
{
  dk(BluetoothManager paramBluetoothManager, dg paramdg)
  {
    super(paramBluetoothManager, paramdg);
  }
  
  final boolean a()
  {
    if (this.a) {
      return false;
    }
    Object localObject = this.b.getAdapter();
    if ((localObject != null) && ((((BluetoothAdapter)localObject).getState() == 12) || (((BluetoothAdapter)localObject).getState() == 11)))
    {
      ((BluetoothAdapter)localObject).startLeScan(this);
      this.a = true;
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
    BluetoothAdapter localBluetoothAdapter = this.b.getAdapter();
    if (localBluetoothAdapter != null) {
      localBluetoothAdapter.stopLeScan(this);
    }
    this.a = false;
    return true;
  }
  
  public final void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    String str2 = null;
    if (paramBluetoothDevice != null) {}
    for (String str1 = paramBluetoothDevice.getName();; str1 = null)
    {
      if (paramBluetoothDevice != null) {
        str2 = paramBluetoothDevice.getAddress();
      }
      paramBluetoothDevice = dl.a(str1, str2, paramInt, paramArrayOfByte);
      if (paramBluetoothDevice != null) {
        super.a(paramBluetoothDevice);
      }
      return;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/dk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */