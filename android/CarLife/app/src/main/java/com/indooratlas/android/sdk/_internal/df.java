package com.indooratlas.android.sdk._internal;

import android.bluetooth.BluetoothManager;
import java.util.Iterator;
import java.util.List;

abstract class df
{
  protected boolean a;
  final BluetoothManager b;
  private final dg c;
  
  protected df(BluetoothManager paramBluetoothManager, dg paramdg)
  {
    this.b = paramBluetoothManager;
    this.c = paramdg;
  }
  
  final void a(dh paramdh)
  {
    dg localdg = this.c;
    synchronized (localdg.d)
    {
      Iterator localIterator = localdg.d.iterator();
      while (localIterator.hasNext())
      {
        dh localdh = (dh)localIterator.next();
        if ((localdh.a != null) && (localdh.a.equals(paramdh.a))) {
          localIterator.remove();
        }
      }
      localdg.d.add(paramdh);
      if ((localdg.a == null) || (localdg.c <= 100L)) {
        localdg.c();
      }
      return;
    }
  }
  
  abstract boolean a();
  
  abstract boolean b();
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/df.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */