package com.indooratlas.android.sdk._internal;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothManager;
import android.content.Context;

public final class aq
{
  @TargetApi(18)
  public static BluetoothManager a(Context paramContext)
  {
    return (BluetoothManager)paramContext.getSystemService("bluetooth");
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/aq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */