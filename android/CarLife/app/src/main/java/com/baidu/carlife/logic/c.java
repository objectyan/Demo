package com.baidu.carlife.logic;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Message;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.f.a;
import com.baidu.carlife.l.a;
import com.baidu.carlife.protobuf.CarlifeDeviceInfoProto.CarlifeDeviceInfo;
import com.baidu.carlife.protobuf.CarlifeDeviceInfoProto.CarlifeDeviceInfo.Builder;
import com.baidu.carlife.util.p;

public class c
{
  public static final String a = "CarlifeDeviceInfoManager";
  private static c b = null;
  private static CarlifeDeviceInfoProto.CarlifeDeviceInfo c = null;
  private static CarlifeDeviceInfoProto.CarlifeDeviceInfo d = null;
  
  public static c a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new c();
      }
      return b;
    }
    finally {}
  }
  
  public void a(CarlifeDeviceInfoProto.CarlifeDeviceInfo paramCarlifeDeviceInfo)
  {
    d = paramCarlifeDeviceInfo;
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        CarlifeDeviceInfoProto.CarlifeDeviceInfo.Builder localBuilder = CarlifeDeviceInfoProto.CarlifeDeviceInfo.newBuilder();
        localBuilder.setOs("Android");
        localBuilder.setBoard(Build.BOARD);
        localBuilder.setBootloader(Build.BOOTLOADER);
        localBuilder.setBrand(Build.BRAND);
        localBuilder.setCpuAbi(Build.CPU_ABI);
        localBuilder.setCpuAbi2(Build.CPU_ABI2);
        localBuilder.setDevice(Build.DEVICE);
        localBuilder.setDisplay(Build.DISPLAY);
        localBuilder.setFingerprint(Build.FINGERPRINT);
        localBuilder.setHardware(Build.HARDWARE);
        localBuilder.setHost(Build.HOST);
        localBuilder.setCid(Build.ID);
        localBuilder.setManufacturer(Build.MANUFACTURER);
        localBuilder.setModel(Build.MODEL);
        localBuilder.setProduct(Build.PRODUCT);
        localBuilder.setSerial(Build.SERIAL);
        localBuilder.setCodename(Build.VERSION.CODENAME);
        localBuilder.setIncremental(Build.VERSION.INCREMENTAL);
        localBuilder.setSdk(Build.VERSION.SDK);
        localBuilder.setSdkInt(Build.VERSION.SDK_INT);
        String str = p.a().a("carlifevehicle_channel", "");
        if ((f.a.ab.a().equals(str)) || (f.a.aa.a().equals(str)))
        {
          localBuilder.setRelease("CarLifePhoneVesion:" + e.g());
          localBuilder.setCarlifeversion(e.g());
          str = com.baidu.carlife.bluetooth.i.a();
          if (str == "")
          {
            localBuilder.setBtaddress("unknow");
            c = localBuilder.build();
          }
        }
        else
        {
          localBuilder.setRelease(Build.VERSION.RELEASE);
          continue;
        }
        localException.setBtaddress(str);
      }
      catch (Exception localException)
      {
        com.baidu.carlife.core.i.e("CarlifeDeviceInfoManager", "init error");
        localException.printStackTrace();
        return;
      }
    }
  }
  
  public CarlifeDeviceInfoProto.CarlifeDeviceInfo c()
  {
    return c;
  }
  
  public CarlifeDeviceInfoProto.CarlifeDeviceInfo d()
  {
    return d;
  }
  
  public void e()
  {
    try
    {
      Object localObject = new com.baidu.carlife.core.connect.c(true);
      ((com.baidu.carlife.core.connect.c)localObject).c(65540);
      ((com.baidu.carlife.core.connect.c)localObject).b(c.toByteArray());
      ((com.baidu.carlife.core.connect.c)localObject).d(c.getSerializedSize());
      localObject = Message.obtain(null, ((com.baidu.carlife.core.connect.c)localObject).d(), 1001, 0, localObject);
      a.a().a((Message)localObject);
      return;
    }
    catch (Exception localException)
    {
      com.baidu.carlife.core.i.e("CarlifeDeviceInfoManager", "send md info error");
      localException.printStackTrace();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */