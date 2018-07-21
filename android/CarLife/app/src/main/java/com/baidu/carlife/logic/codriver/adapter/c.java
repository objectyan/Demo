package com.baidu.carlife.logic.codriver.adapter;

import android.os.Handler;
import android.os.Looper;
import com.baidu.carlife.core.i;
import com.baidu.carlife.l.a;
import com.baidu.carlife.util.w;
import com.baidu.che.codriver.sdk.a.o;
import com.baidu.che.codriver.sdk.a.o.a;
import com.baidu.che.codriver.vr.record.outside.OutsideRecordHelper;

public class c
  implements o
{
  private static final String c = "NormalVehicleRecord";
  private static final int e = 1024;
  private static final int f = 16;
  private static final int g = 1040;
  private byte[] d = new byte['ᎈ'];
  private OutsideRecordHelper h = new OutsideRecordHelper();
  
  public int a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      i = -1;
    }
    int j;
    do
    {
      do
      {
        return i;
        i = a.a().e(paramArrayOfByte, 12);
        if ((i == -1) || (i != 12))
        {
          i.e("NormalVehicleRecord", "-- get data length failed");
          return -1;
        }
        j = (paramArrayOfByte[0] << 24 & 0xFF000000) + (paramArrayOfByte[1] << 16 & 0xFF0000) + (paramArrayOfByte[2] << 8 & 0xFF00) + (paramArrayOfByte[3] << 0 & 0xFF);
        if (j > paramArrayOfByte.length)
        {
          i.e("NormalVehicleRecord", "---- get data too long!!!-len:" + j);
          return -1;
        }
        if (a.a().e(paramArrayOfByte, j) < 0)
        {
          i.e("NormalVehicleRecord", "-- get data failed---");
          return -1;
        }
        i = j;
      } while (!a.a().V());
      i = j;
    } while (j <= 0);
    byte[] arrayOfByte = a.a().g(paramArrayOfByte, j);
    if (arrayOfByte == null)
    {
      i.e("NormalVehicleRecord", "decrypt failed!");
      return -1;
    }
    int i = arrayOfByte.length;
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, i);
    return i;
  }
  
  public void a()
  {
    i.b("NormalVehicleRecord", "startRecord");
    this.h.startRecordForAsr(this);
  }
  
  public void a(o.a parama)
  {
    i.b("NormalVehicleRecord", "record InputData");
    if ((this.d == null) || (this.d.length == 0))
    {
      parama.a = null;
      return;
    }
    int i = a.a().e(this.d, 12);
    if ((i == -1) || (i != 12))
    {
      i.e("NormalVehicleRecord", "-- get data length failed");
      parama.a = null;
      parama.b = -1;
      return;
    }
    i = (this.d[0] << 24 & 0xFF000000) + (this.d[1] << 16 & 0xFF0000) + (this.d[2] << 8 & 0xFF00) + (this.d[3] << 0 & 0xFF);
    if (i > this.d.length)
    {
      i.e("NormalVehicleRecord", "---- get data too long!!!-len:" + i);
      parama.a = null;
      parama.b = -1;
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          w.a("---- get data too long!!!-");
        }
      });
      return;
    }
    if (a.a().e(this.d, i) < 0)
    {
      i.e("NormalVehicleRecord", "-- get data failed---");
      parama.a = null;
      parama.b = -1;
      return;
    }
    if (a.a().V())
    {
      parama.a = a.a().g(this.d, i);
      if (parama.a == null)
      {
        parama.b = -1;
        return;
      }
      parama.b = parama.a.length;
      return;
    }
    parama.a = this.d;
    parama.b = i;
  }
  
  public void b()
  {
    i.b("NormalVehicleRecord", "endRecord");
    this.h.release();
  }
  
  public void c()
  {
    i.b("NormalVehicleRecord", "initRecorder");
    this.h.reset();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/codriver/adapter/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */