package com.baidu.carlife.logic.codriver.adapter;

import com.baidu.carlife.core.i;
import com.baidu.che.codriver.sdk.a.o;
import com.baidu.che.codriver.sdk.a.o.a;

public class a
  implements o
{
  private static final String c = "AecVehicleRecord";
  private static final int d = 2560;
  private static final int e = 5120;
  private static final int f = 16;
  private static final int g = 5136;
  private boolean h;
  private byte[] i;
  
  public a(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (com.baidu.carlife.l.a.a().V()) {}
    for (this.i = new byte['ᐐ'];; this.i = new byte['᐀'])
    {
      com.baidu.che.codriver.vr.record.aec.a.a();
      return;
    }
  }
  
  public int a(byte[] paramArrayOfByte)
  {
    return 0;
  }
  
  public void a() {}
  
  public void a(o.a parama)
  {
    if ((this.i == null) || (this.i.length == 0))
    {
      parama.a = null;
      parama.b = -1;
      com.baidu.che.codriver.vr.record.aec.a.b();
      return;
    }
    int j = com.baidu.carlife.l.a.a().e(this.i, 12);
    if ((j == -1) || (j != 12))
    {
      i.e("AecVehicleRecord", "-- get data length failed");
      parama.a = null;
      parama.b = -1;
      com.baidu.che.codriver.vr.record.aec.a.b();
      return;
    }
    j = (this.i[0] << 24 & 0xFF000000) + (this.i[1] << 16 & 0xFF0000) + (this.i[2] << 8 & 0xFF00) + (this.i[3] << 0 & 0xFF);
    if (j != this.i.length)
    {
      i.e("AecVehicleRecord", "---- get data error!!!-len:" + j);
      parama.a = null;
      parama.b = -1;
      com.baidu.che.codriver.vr.record.aec.a.b();
      return;
    }
    if (com.baidu.carlife.l.a.a().e(this.i, j) < 0)
    {
      i.e("AecVehicleRecord", "-- get data failed---");
      parama.a = null;
      parama.b = -1;
      com.baidu.che.codriver.vr.record.aec.a.b();
      return;
    }
    i.b("AecVehicleRecord", "- get data OK!!-dataLength:" + j);
    if (com.baidu.carlife.l.a.a().V())
    {
      if (com.baidu.carlife.l.a.a().g(this.i, j) == null)
      {
        i.e("AecVehicleRecord", "decrypt failed!");
        parama.a = null;
        parama.b = -1;
        com.baidu.che.codriver.vr.record.aec.a.b();
      }
      parama.b = 2560;
      return;
    }
    parama.b = 2560;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/codriver/adapter/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */