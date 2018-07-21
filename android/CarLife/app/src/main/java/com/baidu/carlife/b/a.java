package com.baidu.carlife.b;

import android.os.Message;
import com.baidu.carlife.core.connect.c;
import com.baidu.carlife.core.i;
import com.baidu.carlife.protobuf.CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList;
import com.baidu.carlife.protobuf.CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList.Builder;
import com.baidu.carlife.protobuf.CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo;
import com.baidu.carlife.protobuf.CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.Builder;
import com.baidu.carlife.protobuf.CarlifeVehicleInfoListProto.CarlifeVehicleInfoList;
import com.baidu.carlife.protobuf.CarlifeVehicleInfoProto.CarlifeVehicleInfo;
import com.baidu.carlife.protobuf.CarlifeVehicleInfoProto.CarlifeVehicleInfo.Builder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
{
  private static final String a = a.class.getSimpleName();
  private static a b;
  private List<a> c = new ArrayList();
  
  public static a a()
  {
    if (b == null) {
      b = new a();
    }
    return b;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    i.b(a, "sendCarDataControlMsgToHU moduleId:" + paramInt1 + " frequency:" + paramInt3 + " isStart:" + paramBoolean);
    Object localObject1 = CarlifeVehicleInfoProto.CarlifeVehicleInfo.newBuilder();
    if (localObject1 == null) {
      return;
    }
    ((CarlifeVehicleInfoProto.CarlifeVehicleInfo.Builder)localObject1).setModuleID(paramInt1);
    ((CarlifeVehicleInfoProto.CarlifeVehicleInfo.Builder)localObject1).setFrequency(paramInt3);
    ((CarlifeVehicleInfoProto.CarlifeVehicleInfo.Builder)localObject1).setFlag(paramInt2);
    localObject1 = ((CarlifeVehicleInfoProto.CarlifeVehicleInfo.Builder)localObject1).build();
    Object localObject2 = new c(true);
    ((c)localObject2).b(((CarlifeVehicleInfoProto.CarlifeVehicleInfo)localObject1).toByteArray());
    ((c)localObject2).d(((CarlifeVehicleInfoProto.CarlifeVehicleInfo)localObject1).getSerializedSize());
    if (paramBoolean) {
      ((c)localObject2).c(65587);
    }
    for (;;)
    {
      localObject2 = Message.obtain(null, ((c)localObject2).d(), 1001, 0, localObject2);
      com.baidu.carlife.l.a.a().a((Message)localObject2);
      i.b(a, ((CarlifeVehicleInfoProto.CarlifeVehicleInfo)localObject1).toString());
      return;
      ((c)localObject2).c(65588);
    }
  }
  
  public static void a(Object paramObject)
  {
    paramObject = (c)paramObject;
    int j;
    CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList.Builder localBuilder;
    for (;;)
    {
      CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.Builder localBuilder1;
      try
      {
        localCarlifeSubscribeMobileCarLifeInfoList = CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList.parseFrom(((c)paramObject).f());
        j = localCarlifeSubscribeMobileCarLifeInfoList.getSubscribemobileCarLifeInfoList().size();
        if (j != localCarlifeSubscribeMobileCarLifeInfoList.getCnt()) {
          i.e(a, "SubscribemobileCarLifeInfoList().size() != Cnt");
        }
        paramObject = new c(true);
        ((c)paramObject).c(65604);
        localBuilder = CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList.newBuilder();
        int i = 0;
        if (i >= j) {
          break;
        }
        int k = localCarlifeSubscribeMobileCarLifeInfoList.getSubscribemobileCarLifeInfo(i).getModuleID();
        localBuilder1 = CarlifeSubscribeMobileCarLifeInfoProto.CarlifeSubscribeMobileCarLifeInfo.newBuilder();
        localBuilder1.setModuleID(k);
        switch (k)
        {
        default: 
          localBuilder1.setSupportFlag(false);
          localBuilder.addSubscribemobileCarLifeInfo(localBuilder1);
          i += 1;
          break;
        case 0: 
          localBuilder1.setSupportFlag(true);
        }
      }
      catch (Exception paramObject)
      {
        ((Exception)paramObject).printStackTrace();
        return;
      }
      continue;
      localBuilder1.setSupportFlag(false);
    }
    localBuilder.setCnt(j);
    CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList localCarlifeSubscribeMobileCarLifeInfoList = localBuilder.build();
    ((c)paramObject).b(localCarlifeSubscribeMobileCarLifeInfoList.toByteArray());
    ((c)paramObject).d(localCarlifeSubscribeMobileCarLifeInfoList.getSerializedSize());
    paramObject = Message.obtain(null, ((c)paramObject).d(), 1001, 0, paramObject);
    com.baidu.carlife.l.a.a().a((Message)paramObject);
  }
  
  public static void a(Object paramObject, boolean paramBoolean)
  {
    paramObject = (c)paramObject;
    for (;;)
    {
      try
      {
        paramObject = CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList.parseFrom(((c)paramObject).f());
        int j = ((CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList)paramObject).getSubscribemobileCarLifeInfoList().size();
        if (j != ((CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList)paramObject).getCnt()) {
          i.e(a, "start SubscribemobileCarLifeInfoList().size() != Cnt");
        }
        int i = 0;
        if (i < j) {}
        switch (((CarlifeSubscribeMobileCarLifeInfoListProto.CarlifeSubscribeMobileCarLifeInfoList)paramObject).getSubscribemobileCarLifeInfo(i).getModuleID())
        {
        case 1: 
        default: 
          i += 1;
          continue;
          return;
        }
      }
      catch (Exception paramObject)
      {
        ((Exception)paramObject).printStackTrace();
      }
      if (paramBoolean) {
        com.baidu.carlife.j.a.a().b(true);
      } else {
        com.baidu.carlife.j.a.a().b(false);
      }
    }
  }
  
  public void a(CarlifeVehicleInfoListProto.CarlifeVehicleInfoList paramCarlifeVehicleInfoList)
  {
    i.b(a, "parseFromRspMsgInfo");
    if (paramCarlifeVehicleInfoList == null) {}
    for (;;)
    {
      return;
      this.c.clear();
      paramCarlifeVehicleInfoList = paramCarlifeVehicleInfoList.getVehicleInfoList().iterator();
      while (paramCarlifeVehicleInfoList.hasNext())
      {
        CarlifeVehicleInfoProto.CarlifeVehicleInfo localCarlifeVehicleInfo = (CarlifeVehicleInfoProto.CarlifeVehicleInfo)paramCarlifeVehicleInfoList.next();
        if (localCarlifeVehicleInfo.getModuleID() == a.a.ordinal())
        {
          if ((localCarlifeVehicleInfo.getFlag() == 1) || (localCarlifeVehicleInfo.getFlag() == 2))
          {
            this.c.add(a.values()[localCarlifeVehicleInfo.getModuleID()]);
            com.baidu.carlife.i.a.a();
            com.baidu.carlife.i.a.a = localCarlifeVehicleInfo.getFlag();
            a(a.a.ordinal(), localCarlifeVehicleInfo.getFlag(), 0, true);
          }
        }
        else {
          this.c.add(a.values()[localCarlifeVehicleInfo.getModuleID()]);
        }
      }
    }
  }
  
  public void b()
  {
    d();
  }
  
  public void c()
  {
    com.baidu.carlife.i.a.a();
    com.baidu.carlife.i.a.a = 1;
    this.c.clear();
  }
  
  public void d()
  {
    i.b(a, "carDataSubscribe");
    Object localObject = new c(true);
    ((c)localObject).c(65585);
    localObject = Message.obtain(null, ((c)localObject).d(), 1001, 0, localObject);
    com.baidu.carlife.l.a.a().a((Message)localObject);
    i.b(a, "sendMsgToService MSG_CMD_CAR_DATA_SUBSCRIBE_REQ");
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/b/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */