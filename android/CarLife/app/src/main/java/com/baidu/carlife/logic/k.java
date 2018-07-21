package com.baidu.carlife.logic;

import android.os.Message;
import com.baidu.carlife.core.connect.c;
import com.baidu.carlife.core.f;
import com.baidu.carlife.core.f.a;
import com.baidu.carlife.core.i;
import com.baidu.carlife.l.a;
import com.baidu.carlife.model.h;
import com.baidu.carlife.protobuf.CarlifeModuleStatusListProto.CarlifeModuleStatusList;
import com.baidu.carlife.protobuf.CarlifeModuleStatusListProto.CarlifeModuleStatusList.Builder;
import com.baidu.carlife.protobuf.CarlifeModuleStatusProto.CarlifeModuleStatus;
import com.baidu.carlife.protobuf.CarlifeModuleStatusProto.CarlifeModuleStatus.Builder;
import com.baidu.carlife.protobuf.CarlifeProtocolVersionProto.CarlifeProtocolVersion;
import com.baidu.navi.BaiduNaviSDKManager;
import com.baidu.navi.cruise.BCruiser;
import com.baidu.navisdk.ui.routeguide.BNavigator;

public class k
{
  private static final String a = "ModuleStatusManage";
  private static k b;
  private h c;
  private h d;
  private h e;
  private h f;
  private h g;
  private h h;
  private h i;
  
  public k()
  {
    if (this.c == null) {
      this.c = new h(1, 0);
    }
    if (this.d == null) {
      this.d = new h(2, 0);
    }
    if (this.e == null) {
      this.e = new h(3, 0);
    }
    if (this.f == null) {
      this.f = new h(4, 0);
    }
    if (this.g == null) {
      this.g = new h(6, 0);
    }
    if (this.h == null) {
      this.h = new h(8, 0);
    }
    if (this.i == null) {
      this.i = new h(9, 0);
    }
  }
  
  /* Error */
  public static k a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 45	com/baidu/carlife/logic/k:b	Lcom/baidu/carlife/logic/k;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 45	com/baidu/carlife/logic/k:b	Lcom/baidu/carlife/logic/k;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	com/baidu/carlife/logic/k
    //   21: dup
    //   22: invokespecial 46	com/baidu/carlife/logic/k:<init>	()V
    //   25: putstatic 45	com/baidu/carlife/logic/k:b	Lcom/baidu/carlife/logic/k;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 45	com/baidu/carlife/logic/k:b	Lcom/baidu/carlife/logic/k;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localk	k
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
  }
  
  private CarlifeModuleStatusProto.CarlifeModuleStatus a(h paramh)
  {
    if (paramh == null) {
      return null;
    }
    CarlifeModuleStatusProto.CarlifeModuleStatus.Builder localBuilder = CarlifeModuleStatusProto.CarlifeModuleStatus.newBuilder();
    localBuilder.setModuleID(paramh.a());
    localBuilder.setStatusID(paramh.b());
    return localBuilder.build();
  }
  
  private void a(CarlifeModuleStatusListProto.CarlifeModuleStatusList paramCarlifeModuleStatusList)
  {
    if (paramCarlifeModuleStatusList == null) {}
    while (!a.a().N()) {
      return;
    }
    c localc = new c(true);
    localc.c(65574);
    localc.b(paramCarlifeModuleStatusList.toByteArray());
    localc.d(paramCarlifeModuleStatusList.getSerializedSize());
    paramCarlifeModuleStatusList = Message.obtain(null, localc.d(), 1001, 0, localc);
    a.a().a(paramCarlifeModuleStatusList);
  }
  
  private void b(h paramh)
  {
    if (paramh == null) {}
    do
    {
      return;
      i.b("ModuleStatusManage", "--sendCarlifeModuleStatus--moduleId:" + paramh.a() + "--statusId:" + paramh.b());
      CarlifeModuleStatusListProto.CarlifeModuleStatusList.Builder localBuilder = CarlifeModuleStatusListProto.CarlifeModuleStatusList.newBuilder();
      localBuilder.addModuleStatus(a(paramh));
      localBuilder.setCnt(localBuilder.getModuleStatusCount());
      paramh = localBuilder.build();
    } while ((paramh == null) || (paramh.getModuleStatusCount() <= 0));
    a(paramh);
  }
  
  public void a(int paramInt)
  {
    if (f.jx.a().length() < 4) {}
    do
    {
      do
      {
        return;
        localObject1 = f.jx.a().substring(0, 4);
      } while ((!"2006".equals(localObject1)) && (!"2019".equals(localObject1)) && (!"2020".equals(localObject1)) && (!a(f.jx.a())));
      localObject1 = new h(4, paramInt);
      localObject2 = CarlifeModuleStatusListProto.CarlifeModuleStatusList.newBuilder();
      ((CarlifeModuleStatusListProto.CarlifeModuleStatusList.Builder)localObject2).addModuleStatus(a((h)localObject1));
      ((CarlifeModuleStatusListProto.CarlifeModuleStatusList.Builder)localObject2).setCnt(((CarlifeModuleStatusListProto.CarlifeModuleStatusList.Builder)localObject2).getModuleStatusCount());
      localObject1 = ((CarlifeModuleStatusListProto.CarlifeModuleStatusList.Builder)localObject2).build();
    } while ((localObject1 == null) || (((CarlifeModuleStatusListProto.CarlifeModuleStatusList)localObject1).getModuleStatusCount() <= 0));
    Object localObject2 = ((CarlifeModuleStatusListProto.CarlifeModuleStatusList)localObject1).toByteArray();
    int j = ((CarlifeModuleStatusListProto.CarlifeModuleStatusList)localObject1).getSerializedSize();
    Object localObject1 = localObject2;
    paramInt = j;
    if (a.a().V())
    {
      localObject1 = localObject2;
      paramInt = j;
      if (j > 0)
      {
        localObject1 = a.a().f((byte[])localObject2, j);
        if (localObject1 == null)
        {
          i.e("ModuleStatusManage", "encrypt failed!");
          return;
        }
        paramInt = localObject1.length;
      }
    }
    localObject2 = new p();
    ((p)localObject2).c(327685);
    ((p)localObject2).c();
    ((p)localObject2).a(paramInt);
    a.a().d(((p)localObject2).a(), ((p)localObject2).b());
    a.a().d((byte[])localObject1, paramInt);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 5: 
    case 7: 
    default: 
      return;
    case 1: 
      if (this.c == null) {
        this.c = new h(paramInt1, paramInt2);
      }
      for (;;)
      {
        b(this.c);
        return;
        this.c.b(paramInt2);
      }
    case 2: 
      if (this.d == null) {
        this.d = new h(paramInt1, paramInt2);
      }
      for (;;)
      {
        b(this.d);
        return;
        this.d.b(paramInt2);
      }
    case 3: 
      if (this.e == null) {
        this.e = new h(paramInt1, paramInt2);
      }
      for (;;)
      {
        b(this.e);
        return;
        this.e.b(paramInt2);
      }
    case 4: 
      if (this.f == null) {
        this.f = new h(paramInt1, paramInt2);
      }
      for (;;)
      {
        b(this.f);
        return;
        this.f.b(paramInt2);
      }
    case 6: 
      if (this.g == null) {
        this.g = new h(paramInt1, paramInt2);
      }
      for (;;)
      {
        b(this.g);
        return;
        this.g.b(paramInt2);
      }
    case 8: 
      if (this.h == null) {
        this.h = new h(paramInt1, paramInt2);
      }
      for (;;)
      {
        b(this.h);
        return;
        this.h.b(paramInt2);
      }
    }
    if (this.i == null) {
      this.i = new h(paramInt1, paramInt2);
    }
    for (;;)
    {
      b(this.i);
      return;
      this.i.b(paramInt2);
    }
  }
  
  public boolean a(String paramString)
  {
    String[] arrayOfString = new String[12];
    arrayOfString[0] = "20262119";
    arrayOfString[1] = "20262120";
    arrayOfString[2] = "20262121";
    arrayOfString[3] = "20262122";
    arrayOfString[4] = "20262123";
    arrayOfString[5] = "20262124";
    arrayOfString[6] = "20262125";
    arrayOfString[7] = "20262126";
    arrayOfString[8] = "20262127";
    arrayOfString[9] = "20262128";
    arrayOfString[10] = "20262108";
    arrayOfString[11] = "20632103";
    int j = 0;
    while (j < arrayOfString.length)
    {
      if (arrayOfString[j].equals(paramString))
      {
        i.b("ModuleStatusManage", "is boshi channel : " + paramString);
        return true;
      }
      j += 1;
    }
    return false;
  }
  
  public void b()
  {
    Object localObject = CarlifeModuleStatusListProto.CarlifeModuleStatusList.newBuilder();
    if (this.c != null)
    {
      ((CarlifeModuleStatusListProto.CarlifeModuleStatusList.Builder)localObject).addModuleStatus(a(this.c));
      i.b("ModuleStatusManage", "sendCarlifeModuleListStatus moduleId:" + this.c.a() + " statusId" + this.c.b());
    }
    if (this.d != null)
    {
      if (d.a().d().getMajorVersion() < 2) {
        break label636;
      }
      if (BaiduNaviSDKManager.getInstance().isNaviBegin())
      {
        this.d.b(1);
        if (!b(f.jx.a()))
        {
          if (!BNavigator.getInstance().isNaviBegin()) {
            break label685;
          }
          this.d.b(1);
        }
        label136:
        ((CarlifeModuleStatusListProto.CarlifeModuleStatusList.Builder)localObject).addModuleStatus(a(this.d));
        i.b("ModuleStatusManage", "sendCarlifeModuleListStatus moduleId:" + this.d.a() + " statusId" + this.d.b());
      }
    }
    else
    {
      if (this.e != null)
      {
        ((CarlifeModuleStatusListProto.CarlifeModuleStatusList.Builder)localObject).addModuleStatus(a(this.e));
        i.b("ModuleStatusManage", "sendCarlifeModuleListStatus moduleId:" + this.e.a() + " statusId" + this.e.b());
      }
      if (this.f != null)
      {
        ((CarlifeModuleStatusListProto.CarlifeModuleStatusList.Builder)localObject).addModuleStatus(a(this.f));
        i.b("ModuleStatusManage", "sendCarlifeModuleListStatus moduleId:" + this.f.a() + " statusId" + this.f.b());
      }
      if (this.g != null)
      {
        ((CarlifeModuleStatusListProto.CarlifeModuleStatusList.Builder)localObject).addModuleStatus(a(this.g));
        i.b("ModuleStatusManage", "sendCarlifeModuleListStatus moduleId:" + this.g.a() + " statusId" + this.g.b());
      }
      if (d.a().d().getMajorVersion() >= 2)
      {
        if (this.h != null)
        {
          if (!BaiduNaviSDKManager.getInstance().isCruiseBegin()) {
            break label696;
          }
          this.h.b(1);
          label426:
          ((CarlifeModuleStatusListProto.CarlifeModuleStatusList.Builder)localObject).addModuleStatus(a(this.h));
          i.b("ModuleStatusManage", "sendCarlifeModuleListStatus moduleId:" + this.h.a() + " statusId" + this.h.b());
        }
        if (this.i != null)
        {
          if (!BCruiser.getInstance().isCruiseBegin()) {
            break label707;
          }
          this.i.b(1);
        }
      }
    }
    for (;;)
    {
      ((CarlifeModuleStatusListProto.CarlifeModuleStatusList.Builder)localObject).addModuleStatus(a(this.i));
      i.b("ModuleStatusManage", "sendCarlifeModuleListStatus moduleId:" + this.i.a() + " statusId" + this.i.b());
      ((CarlifeModuleStatusListProto.CarlifeModuleStatusList.Builder)localObject).setCnt(((CarlifeModuleStatusListProto.CarlifeModuleStatusList.Builder)localObject).getModuleStatusCount());
      localObject = ((CarlifeModuleStatusListProto.CarlifeModuleStatusList.Builder)localObject).build();
      i.b("ModuleStatusManage", "sendCarlifeModuleListStatus carlifeModuleStatusList.size : " + ((CarlifeModuleStatusListProto.CarlifeModuleStatusList)localObject).getCnt());
      if ((localObject != null) && (((CarlifeModuleStatusListProto.CarlifeModuleStatusList)localObject).getModuleStatusCount() > 0)) {
        a((CarlifeModuleStatusListProto.CarlifeModuleStatusList)localObject);
      }
      return;
      this.d.b(0);
      break;
      label636:
      if ((BaiduNaviSDKManager.getInstance().isNaviBegin()) || (BaiduNaviSDKManager.getInstance().isCruiseBegin()) || (BCruiser.getInstance().isCruiseBegin()))
      {
        this.d.b(1);
        break;
      }
      this.d.b(0);
      break;
      label685:
      this.d.b(0);
      break label136;
      label696:
      this.h.b(0);
      break label426;
      label707:
      this.i.b(0);
    }
  }
  
  public boolean b(String paramString)
  {
    String[] arrayOfString = new String[10];
    arrayOfString[0] = "20022100";
    arrayOfString[1] = "20022106";
    arrayOfString[2] = "20032101";
    arrayOfString[3] = "20022107";
    arrayOfString[4] = "20022108";
    arrayOfString[5] = "20022109";
    arrayOfString[6] = "20022110";
    arrayOfString[7] = "20032103";
    arrayOfString[8] = "20041100";
    arrayOfString[9] = "20042100";
    int j = 0;
    while (j < arrayOfString.length)
    {
      if (paramString.equalsIgnoreCase(arrayOfString[j])) {
        return false;
      }
      j += 1;
    }
    return true;
  }
  
  public int c()
  {
    if (this.c == null) {
      return 0;
    }
    return this.c.b();
  }
  
  public int d()
  {
    if (this.g == null) {
      return 0;
    }
    return this.g.b();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/logic/k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */