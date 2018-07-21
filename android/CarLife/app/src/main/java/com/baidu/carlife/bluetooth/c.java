package com.baidu.carlife.bluetooth;

import android.os.Message;
import android.text.TextUtils;
import com.baidu.carlife.protobuf.CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection;
import com.baidu.carlife.protobuf.CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.Builder;
import com.baidu.carlife.protobuf.CarlifeBTHfpRequestProto.CarlifeBTHfpRequest;
import com.baidu.carlife.protobuf.CarlifeBTHfpRequestProto.CarlifeBTHfpRequest.Builder;
import com.baidu.carlife.protobuf.CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd;
import com.baidu.carlife.protobuf.CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd.Builder;
import com.baidu.carlife.protobuf.CarlifeBTPairInfoProto.CarlifeBTPairInfo;
import com.baidu.carlife.protobuf.CarlifeBTPairInfoProto.CarlifeBTPairInfo.Builder;
import com.baidu.carlife.protobuf.CarlifeBTStartPairReqProto.CarlifeBTStartPairReq;
import com.baidu.carlife.protobuf.CarlifeBTStartPairReqProto.CarlifeBTStartPairReq.Builder;

public class c
{
  private static final String a = "CarlifeActivity#BtHfpProtocolHelper";
  
  public static void a()
  {
    if (com.baidu.carlife.core.b.a.a())
    {
      Object localObject = new com.baidu.carlife.core.connect.c(true);
      com.baidu.carlife.core.i.b("CarlifeActivity#BtHfpProtocolHelper", "sent foreground message");
      ((com.baidu.carlife.core.connect.c)localObject).c(65563);
      localObject = Message.obtain(null, ((com.baidu.carlife.core.connect.c)localObject).d(), 1001, 0, localObject);
      com.baidu.carlife.l.a.a().a((Message)localObject);
    }
  }
  
  public static void a(int paramInt)
  {
    CarlifeBTPairInfoProto.CarlifeBTPairInfo localCarlifeBTPairInfo = b(paramInt);
    if (localCarlifeBTPairInfo != null)
    {
      a(localCarlifeBTPairInfo);
      com.baidu.carlife.core.i.b("CarlifeActivity#BtHfpProtocolHelper", "MD ---> HU: BT OOB Info,status = " + paramInt);
    }
  }
  
  public static void a(int paramInt1, int paramInt2)
  {
    CarlifeBTHfpRequestProto.CarlifeBTHfpRequest localCarlifeBTHfpRequest = b(paramInt1, paramInt2);
    if (localCarlifeBTHfpRequest != null)
    {
      a(localCarlifeBTHfpRequest);
      com.baidu.carlife.core.i.b("CarlifeActivity#BtHfpProtocolHelper", "MD --- >HU: DTMF_CODE, code =  " + paramInt2);
    }
  }
  
  public static void a(int paramInt, String paramString)
  {
    paramString = d(paramInt, paramString);
    if (paramString != null)
    {
      a(paramString);
      com.baidu.carlife.core.i.b("CarlifeActivity#BtHfpProtocolHelper", "MD ---> HU: HFP_REQUEST, cmd = " + paramInt);
    }
  }
  
  private static void a(CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection paramCarlifeBTHfpConnection)
  {
    if (paramCarlifeBTHfpConnection == null) {
      return;
    }
    com.baidu.carlife.core.connect.c localc = new com.baidu.carlife.core.connect.c(true);
    localc.c(98370);
    localc.b(paramCarlifeBTHfpConnection.toByteArray());
    localc.d(paramCarlifeBTHfpConnection.getSerializedSize());
    paramCarlifeBTHfpConnection = Message.obtain(null, localc.d(), 1001, 0, localc);
    com.baidu.carlife.l.a.a().a(paramCarlifeBTHfpConnection);
  }
  
  public static void a(CarlifeBTHfpRequestProto.CarlifeBTHfpRequest paramCarlifeBTHfpRequest)
  {
    com.baidu.carlife.core.i.b("CarlifeActivity#BtHfpProtocolHelper", "MD--->HU : Request");
    if (paramCarlifeBTHfpRequest == null) {}
    while (!com.baidu.carlife.l.a.a().N()) {
      return;
    }
    com.baidu.carlife.core.connect.c localc = new com.baidu.carlife.core.connect.c(true);
    localc.c(65600);
    localc.b(paramCarlifeBTHfpRequest.toByteArray());
    localc.d(paramCarlifeBTHfpRequest.getSerializedSize());
    paramCarlifeBTHfpRequest = Message.obtain(null, localc.d(), 1001, 0, localc);
    com.baidu.carlife.l.a.a().a(paramCarlifeBTHfpRequest);
  }
  
  private static void a(CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd paramCarlifeBTIdentifyResultInd)
  {
    if (paramCarlifeBTIdentifyResultInd == null) {
      return;
    }
    com.baidu.carlife.core.connect.c localc = new com.baidu.carlife.core.connect.c(true);
    localc.c(65620);
    localc.b(paramCarlifeBTIdentifyResultInd.toByteArray());
    localc.d(paramCarlifeBTIdentifyResultInd.getSerializedSize());
    paramCarlifeBTIdentifyResultInd = Message.obtain(null, localc.d(), 1001, 0, localc);
    com.baidu.carlife.l.a.a().a(paramCarlifeBTIdentifyResultInd);
  }
  
  public static void a(CarlifeBTPairInfoProto.CarlifeBTPairInfo paramCarlifeBTPairInfo)
  {
    if (paramCarlifeBTPairInfo == null) {
      return;
    }
    com.baidu.carlife.core.connect.c localc = new com.baidu.carlife.core.connect.c(true);
    localc.c(65542);
    localc.b(paramCarlifeBTPairInfo.toByteArray());
    localc.d(paramCarlifeBTPairInfo.getSerializedSize());
    paramCarlifeBTPairInfo = Message.obtain(null, localc.d(), 1001, 0, localc);
    com.baidu.carlife.l.a.a().a(paramCarlifeBTPairInfo);
  }
  
  public static void a(CarlifeBTStartPairReqProto.CarlifeBTStartPairReq paramCarlifeBTStartPairReq)
  {
    if (paramCarlifeBTStartPairReq == null) {
      return;
    }
    com.baidu.carlife.core.connect.c localc = new com.baidu.carlife.core.connect.c(true);
    localc.c(65613);
    localc.b(paramCarlifeBTStartPairReq.toByteArray());
    localc.d(paramCarlifeBTStartPairReq.getSerializedSize());
    paramCarlifeBTStartPairReq = Message.obtain(null, localc.d(), 1001, 0, localc);
    com.baidu.carlife.l.a.a().a(paramCarlifeBTStartPairReq);
  }
  
  public static void a(String paramString)
  {
    CarlifeBTStartPairReqProto.CarlifeBTStartPairReq localCarlifeBTStartPairReq = b(paramString);
    if (localCarlifeBTStartPairReq != null)
    {
      a(localCarlifeBTStartPairReq);
      com.baidu.carlife.core.i.b("CarlifeActivity#BtHfpProtocolHelper", "MD ---> HU: START_PAIR, addr = " + paramString);
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    a(com.baidu.carlife.core.b.a.a(), paramBoolean);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      com.baidu.carlife.core.i.b("CarlifeActivity#BtHfpProtocolHelper", "sendForegroundStatusMsg internal screen capture. ");
    }
    while (!com.baidu.carlife.l.a.a().m()) {
      return;
    }
    Object localObject = new com.baidu.carlife.core.connect.c(true);
    if (paramBoolean2)
    {
      com.baidu.carlife.core.i.b("CarlifeActivity#BtHfpProtocolHelper", "sent foreground message");
      ((com.baidu.carlife.core.connect.c)localObject).c(65563);
    }
    for (;;)
    {
      localObject = Message.obtain(null, ((com.baidu.carlife.core.connect.c)localObject).d(), 1001, 0, localObject);
      com.baidu.carlife.l.a.a().a((Message)localObject);
      return;
      com.baidu.carlife.core.i.b("CarlifeActivity#BtHfpProtocolHelper", "sent background message");
      ((com.baidu.carlife.core.connect.c)localObject).c(65564);
    }
  }
  
  public static CarlifeBTHfpRequestProto.CarlifeBTHfpRequest b(int paramInt1, int paramInt2)
  {
    CarlifeBTHfpRequestProto.CarlifeBTHfpRequest.Builder localBuilder = CarlifeBTHfpRequestProto.CarlifeBTHfpRequest.newBuilder();
    if (localBuilder == null) {
      return null;
    }
    localBuilder.setDtmfCode(paramInt2);
    localBuilder.setCommand(paramInt1);
    return localBuilder.build();
  }
  
  private static CarlifeBTPairInfoProto.CarlifeBTPairInfo b(int paramInt)
  {
    String str = i.a();
    if ((str == null) || (str == "")) {}
    CarlifeBTPairInfoProto.CarlifeBTPairInfo.Builder localBuilder;
    do
    {
      return null;
      localBuilder = CarlifeBTPairInfoProto.CarlifeBTPairInfo.newBuilder();
    } while (localBuilder == null);
    if (!TextUtils.isEmpty(str))
    {
      localBuilder.setAddress(str);
      str = i.b();
      if (TextUtils.isEmpty(str)) {
        break label96;
      }
      localBuilder.setName(str);
    }
    for (;;)
    {
      localBuilder.setStatus(paramInt);
      localBuilder.setUuid("00001101-0000-1000-8000-00805F9B34FB");
      localBuilder.setPassKey("1234");
      localBuilder.setRandomizer("1234");
      return localBuilder.build();
      localBuilder.setAddress("");
      break;
      label96:
      localBuilder.setName("");
    }
  }
  
  private static CarlifeBTStartPairReqProto.CarlifeBTStartPairReq b(String paramString)
  {
    CarlifeBTStartPairReqProto.CarlifeBTStartPairReq.Builder localBuilder = CarlifeBTStartPairReqProto.CarlifeBTStartPairReq.newBuilder();
    if (localBuilder == null) {
      return null;
    }
    if (!TextUtils.isEmpty(paramString)) {
      localBuilder.setAddress(paramString);
    }
    for (;;)
    {
      localBuilder.setOstype(0);
      return localBuilder.build();
      localBuilder.setAddress("");
    }
  }
  
  public static void b(int paramInt, String paramString)
  {
    paramString = e(paramInt, paramString);
    if (paramString != null)
    {
      a(paramString);
      com.baidu.carlife.core.i.b("CarlifeActivity#BtHfpProtocolHelper", "MD ---> HU: HFP Connection Status Indication : " + paramInt);
    }
  }
  
  public static void c(int paramInt, String paramString)
  {
    paramString = f(paramInt, paramString);
    if (paramString != null)
    {
      a(paramString);
      com.baidu.carlife.core.i.b("CarlifeActivity#BtHfpProtocolHelper", "MD ---> HU: Identify Result Indication : " + paramInt);
    }
  }
  
  public static CarlifeBTHfpRequestProto.CarlifeBTHfpRequest d(int paramInt, String paramString)
  {
    CarlifeBTHfpRequestProto.CarlifeBTHfpRequest.Builder localBuilder = CarlifeBTHfpRequestProto.CarlifeBTHfpRequest.newBuilder();
    if (localBuilder == null) {
      return null;
    }
    if (!TextUtils.isEmpty(paramString)) {
      localBuilder.setPhoneNum(paramString);
    }
    for (;;)
    {
      localBuilder.setCommand(paramInt);
      return localBuilder.build();
      localBuilder.setPhoneNum("");
    }
  }
  
  private static CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection e(int paramInt, String paramString)
  {
    CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.Builder localBuilder = CarlifeBTHfpConnectionProto.CarlifeBTHfpConnection.newBuilder();
    if (localBuilder == null) {
      return null;
    }
    if (!TextUtils.isEmpty(paramString)) {
      localBuilder.setAddress(paramString);
    }
    for (;;)
    {
      localBuilder.setState(paramInt);
      return localBuilder.build();
      localBuilder.setAddress("");
    }
  }
  
  private static CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd f(int paramInt, String paramString)
  {
    CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd.Builder localBuilder = CarlifeBTIdentifyResultIndProto.CarlifeBTIdentifyResultInd.newBuilder();
    if (localBuilder == null) {
      return null;
    }
    if (!TextUtils.isEmpty(paramString)) {
      localBuilder.setAddress(paramString);
    }
    for (;;)
    {
      localBuilder.setStatus(paramInt);
      return localBuilder.build();
      localBuilder.setAddress("");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/bluetooth/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */