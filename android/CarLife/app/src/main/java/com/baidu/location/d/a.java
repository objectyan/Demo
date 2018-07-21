package com.baidu.location.d;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Build.VERSION;
import com.baidu.location.f;

public class a
{
  private static a a = null;
  private BluetoothAdapter b;
  
  a()
  {
    if (this.b == null)
    {
      if (Build.VERSION.SDK_INT > 17) {
        this.b = ((BluetoothManager)f.getServiceContext().getSystemService("bluetooth")).getAdapter();
      }
    }
    else {
      return;
    }
    this.b = BluetoothAdapter.getDefaultAdapter();
  }
  
  public static a a()
  {
    if (a == null) {
      a = new a();
    }
    return a;
  }
  
  public String b()
  {
    if (this.b != null) {
      return "" + this.b.getState() + "|" + this.b.getScanMode();
    }
    return "-1|-1";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/d/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */