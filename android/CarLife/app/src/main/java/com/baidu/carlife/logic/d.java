package com.baidu.carlife.logic;

import android.os.Message;
import com.baidu.carlife.core.connect.c;
import com.baidu.carlife.core.i;
import com.baidu.carlife.l.a;
import com.baidu.carlife.protobuf.CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus;
import com.baidu.carlife.protobuf.CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus.Builder;
import com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion;
import com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion.Builder;
import java.util.ArrayList;
import java.util.List;

public class d
{
  public static final String a = "CarlifeProtocolInfoManager";
  private static d b = null;
  private static CarlifeProtocolVersionProto.CarlifeProtocolVersion c = null;
  private static CarlifeProtocolVersionProto.CarlifeProtocolVersion d = null;
  private static CarlifeProtocolVersionProto.CarlifeProtocolVersion e = null;
  private static CarlifeProtocolVersionProto.CarlifeProtocolVersion f = null;
  private static CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus g = null;
  private static List<CarlifeProtocolVersionProto.CarlifeProtocolVersion> h = new ArrayList();
  
  public static d a()
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new d();
      }
      return b;
    }
    finally {}
  }
  
  public void a(CarlifeProtocolVersionProto.CarlifeProtocolVersion paramCarlifeProtocolVersion)
  {
    f = paramCarlifeProtocolVersion;
  }
  
  public void b()
  {
    CarlifeProtocolVersionProto.CarlifeProtocolVersion.Builder localBuilder = CarlifeProtocolVersionProto.CarlifeProtocolVersion.newBuilder();
    localBuilder.setMajorVersion(1);
    localBuilder.setMinorVersion(0);
    d = localBuilder.build();
    localBuilder = CarlifeProtocolVersionProto.CarlifeProtocolVersion.newBuilder();
    localBuilder.setMajorVersion(2);
    localBuilder.setMinorVersion(0);
    e = localBuilder.build();
    c = e;
    h.add(d);
    h.add(e);
  }
  
  public CarlifeProtocolVersionProto.CarlifeProtocolVersion c()
  {
    return c;
  }
  
  public CarlifeProtocolVersionProto.CarlifeProtocolVersion d()
  {
    return f;
  }
  
  public boolean e()
  {
    for (;;)
    {
      int i;
      try
      {
        if (h.isEmpty()) {
          break label87;
        }
        if (f != null) {
          break label89;
        }
      }
      catch (Exception localException)
      {
        int j;
        int k;
        i.e("CarlifeProtocolInfoManager", "computerProtocolMatchStatus fail");
        localException.printStackTrace();
        return false;
      }
      if (i < h.size())
      {
        j = ((CarlifeProtocolVersionProto.CarlifeProtocolVersion)h.get(i)).getMajorVersion();
        k = f.getMajorVersion();
        if (j == k) {
          return true;
        }
        i += 1;
      }
      else
      {
        return false;
        label87:
        return false;
        label89:
        i = 0;
      }
    }
  }
  
  public void f()
  {
    boolean bool = e();
    CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus.Builder localBuilder = CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus.newBuilder();
    if (bool) {}
    for (int i = 1;; i = 2)
    {
      localBuilder.setMatchStatus(i);
      g = localBuilder.build();
      return;
    }
  }
  
  public CarlifeProtocolVersionMatchStatusProto.CarlifeProtocolVersionMatchStatus g()
  {
    return g;
  }
  
  public void h()
  {
    try
    {
      Object localObject = new c(true);
      ((c)localObject).c(65538);
      ((c)localObject).b(g.toByteArray());
      ((c)localObject).d(g.getSerializedSize());
      localObject = Message.obtain(null, ((c)localObject).d(), 1001, 0, localObject);
      a.a().a((Message)localObject);
      return;
    }
    catch (Exception localException)
    {
      i.e("CarlifeProtocolInfoManager", "sendProtocolMatchStatus fail");
      localException.printStackTrace();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */