package com.baidu.carlife.j;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.carlife.core.connect.c;
import com.baidu.carlife.core.i;
import com.baidu.carlife.protobuf.CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo;
import com.baidu.carlife.protobuf.CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.Builder;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider.OnRGSubStatusListener;
import com.baidu.navisdk.comapi.routeguide.OnRGInfoListener;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.google.protobuf.ByteString;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class a
{
  private static final String c = a.class.getSimpleName();
  private static a i;
  HashMap<String, Integer> a = new HashMap();
  HashMap<String, Integer> b = new HashMap();
  private boolean d = false;
  private boolean e = false;
  private boolean f = false;
  private boolean g = false;
  private boolean h = false;
  private BNRouteGuider.OnRGSubStatusListener j = new BNRouteGuider.OnRGSubStatusListener()
  {
    public void onArriveDest(Message paramAnonymousMessage)
    {
      i.b(a.e(), "onArriveDest " + paramAnonymousMessage.toString());
      a.this.d();
    }
    
    public void onArriveDestNear(Message paramAnonymousMessage) {}
    
    public void onReRouteCarFree(Message paramAnonymousMessage) {}
    
    public void onReRouteComplete(Message paramAnonymousMessage) {}
    
    public void onRoutePlanYawing(Message paramAnonymousMessage) {}
  };
  private OnRGInfoListener k = new OnRGInfoListener()
  {
    public void onAssistInfoHide(Message paramAnonymousMessage) {}
    
    public void onAssistInfoShow(Message paramAnonymousMessage) {}
    
    public void onAssistInfoUpdate(Message paramAnonymousMessage) {}
    
    public void onCurRoadNameUpdate(Message paramAnonymousMessage) {}
    
    public void onDestStreetViewDownloadSuccess(Message paramAnonymousMessage) {}
    
    public void onDestStreetViewHide(Message paramAnonymousMessage) {}
    
    public void onDestStreetViewShow(Message paramAnonymousMessage) {}
    
    public void onDestStreetViewStartDownload(Message paramAnonymousMessage) {}
    
    public void onDestStreetViewUpdate(Message paramAnonymousMessage) {}
    
    public void onDirectBoardHide(Message paramAnonymousMessage) {}
    
    public void onDirectBoardShow(Message paramAnonymousMessage) {}
    
    public void onDirectBoardUpdate(Message paramAnonymousMessage) {}
    
    public void onGPSWeak(Message paramAnonymousMessage) {}
    
    public void onHUDUpdate(Message paramAnonymousMessage) {}
    
    public void onHighwayInfoHide(Message paramAnonymousMessage) {}
    
    public void onHighwayInfoShow(Message paramAnonymousMessage) {}
    
    public void onHighwayInfoUpdate(Message paramAnonymousMessage) {}
    
    public void onOtherRGInfo(Message paramAnonymousMessage) {}
    
    public void onRGSyncOperation(Message paramAnonymousMessage) {}
    
    public void onRasterExpandMapHide(Message paramAnonymousMessage) {}
    
    public void onRasterExpandMapShow(Message paramAnonymousMessage) {}
    
    public void onRasterExpandMapUpdate(Message paramAnonymousMessage) {}
    
    public void onSimpleBoardHide(Message paramAnonymousMessage) {}
    
    public void onSimpleBoardShow(Message paramAnonymousMessage) {}
    
    public void onSimpleBoardUpdate(Message paramAnonymousMessage) {}
    
    public void onSimpleGuideInfoHide(Message paramAnonymousMessage) {}
    
    public void onSimpleGuideInfoShow(Message paramAnonymousMessage) {}
    
    public void onSimpleGuideInfoUpdate(Message paramAnonymousMessage)
    {
      a.a(a.this);
    }
    
    public void onTotalRemainDistTimeUpdate(Message paramAnonymousMessage) {}
    
    public void onUGCEventTipsHide() {}
    
    public void onUGCEventTipsShow() {}
    
    public void onVectorExpandMapHide(Message paramAnonymousMessage) {}
    
    public void onVectorExpandMapShow(Message paramAnonymousMessage) {}
    
    public void onVectorExpandMapUpdate(Message paramAnonymousMessage) {}
  };
  
  private a()
  {
    int m = 0;
    while (m < b.b.length)
    {
      this.a.put(b.b[m], Integer.valueOf(com.baidu.navisdk.ui.routeguide.subview.BNavR.gTurnIconID[(m + 1)]));
      this.b.put(b.b[m], Integer.valueOf(b.a[m]));
      m += 1;
    }
  }
  
  private Bitmap a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
      return BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    return null;
  }
  
  public static a a()
  {
    if (i == null) {
      i = new a();
    }
    return i;
  }
  
  private void a(CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo paramCarlifeNaviNextTurnInfo)
  {
    if (paramCarlifeNaviNextTurnInfo == null) {
      return;
    }
    c localc = new c(true);
    localc.c(65584);
    localc.b(paramCarlifeNaviNextTurnInfo.toByteArray());
    localc.d(paramCarlifeNaviNextTurnInfo.getSerializedSize());
    paramCarlifeNaviNextTurnInfo = Message.obtain(null, localc.d(), 1001, 0, localc);
    com.baidu.carlife.l.a.a().a(paramCarlifeNaviNextTurnInfo);
  }
  
  private byte[] a(Bitmap paramBitmap)
  {
    return a(paramBitmap, 100);
  }
  
  private byte[] a(Bitmap paramBitmap, int paramInt)
  {
    ByteArrayOutputStream localByteArrayOutputStream;
    if (paramBitmap != null)
    {
      localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.PNG, paramInt, localByteArrayOutputStream);
      paramBitmap = localByteArrayOutputStream.toByteArray();
    }
    try
    {
      localByteArrayOutputStream.close();
      return paramBitmap;
    }
    catch (IOException localIOException) {}
    return null;
    return paramBitmap;
  }
  
  private void f()
  {
    if (this.f) {}
    CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.Builder localBuilder;
    Object localObject2;
    int m;
    for (;;)
    {
      return;
      localBuilder = CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.newBuilder();
      if (localBuilder != null)
      {
        Object localObject1;
        if (this.e)
        {
          localBuilder.setAction(2);
          if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey("icon_name")) {
            localObject1 = RGSimpleGuideModel.sSimpleGuideBundle.getString("icon_name");
          }
        }
        else
        {
          try
          {
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (this.b.containsKey(localObject1)))
            {
              localBuilder.setNextTurn(((Integer)this.b.get(localObject1)).intValue());
              if (this.a.containsKey(localObject1))
              {
                localObject1 = BNStyleManager.getDrawable(((Integer)this.a.get(localObject1)).intValue());
                if (localObject1 != null)
                {
                  Bitmap localBitmap = ((BitmapDrawable)localObject1).getBitmap();
                  localObject1 = a(localBitmap);
                  localObject2 = localObject1;
                  if (localObject1.length > 30720)
                  {
                    localObject2 = Bitmap.createScaledBitmap(localBitmap, 160, 160, true);
                    localObject1 = a((Bitmap)localObject2);
                    m = 100;
                    for (;;)
                    {
                      if ((localObject1.length >= 30720) && (m >= 10))
                      {
                        localObject1 = a((Bitmap)localObject2, m);
                        m -= 10;
                        continue;
                        localBuilder.setAction(1);
                        this.e = true;
                        break;
                      }
                    }
                    localObject2 = localObject1;
                    if (localObject1.length > 30720)
                    {
                      i.b(c, "bitmap is too large");
                      return;
                    }
                  }
                }
              }
            }
          }
          catch (Exception localException)
          {
            i.b(c, localException.toString());
            return;
          }
        }
      }
    }
    localBuilder.setTurnIconData(ByteString.copyFrom((byte[])localObject2));
    if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey("straight"))
    {
      if (RGSimpleGuideModel.sSimpleGuideBundle.getInt("straight", 0) <= 0) {
        break label394;
      }
      m = 1;
      if (m != 0) {
        localBuilder.setNextTurn(1);
      }
    }
    if (RGSimpleGuideModel.sSimpleGuideBundle.containsKey("road_name"))
    {
      String str = RGSimpleGuideModel.sSimpleGuideBundle.getString("road_name");
      if (!TextUtils.isEmpty(str))
      {
        localBuilder.setRoadName(str);
        label330:
        if (!RGSimpleGuideModel.sSimpleGuideBundle.containsKey("start_dist")) {
          break label423;
        }
        localBuilder.setTotalDistance(RGSimpleGuideModel.sSimpleGuideBundle.getInt("start_dist"));
        label357:
        if (!RGSimpleGuideModel.sSimpleGuideBundle.containsKey("remain_dist")) {
          break label433;
        }
        localBuilder.setRemainDistance(RGSimpleGuideModel.sSimpleGuideBundle.getInt("remain_dist"));
      }
    }
    for (;;)
    {
      a(localBuilder.build());
      return;
      label394:
      m = 0;
      break;
      localBuilder.setRoadName("无名路");
      break label330;
      localBuilder.setRoadName("无名路");
      break label330;
      label423:
      localBuilder.setTotalDistance(0);
      break label357;
      label433:
      localBuilder.setRemainDistance(0);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    i.b(c, "onNaviBegin isNaviBegin:" + paramBoolean);
    if ((paramBoolean) && (this.h))
    {
      b();
      return;
    }
    d();
    c();
  }
  
  public void b()
  {
    if (this.d) {
      return;
    }
    this.d = true;
    this.e = false;
    if (BNavigator.getInstance().isNaviBegin()) {
      this.g = true;
    }
    for (this.f = false;; this.f = true)
    {
      BNRouteGuider.getInstance().addRGInfoListeners(this.k);
      BNRouteGuider.getInstance().addRGSubStatusListener(this.j);
      i.b(c, "init isInit:" + this.d + " isSendActionShow:" + this.e + " isNaviBegin:" + this.g + " isArriveDest:" + this.f);
      return;
      this.g = false;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    i.b(c, "setConnected isConnected:" + paramBoolean);
    this.h = paramBoolean;
    if ((paramBoolean) && (BNavigator.getInstance().isNaviBegin()))
    {
      b();
      return;
    }
    c();
  }
  
  public void c()
  {
    if (!this.d) {
      return;
    }
    BNRouteGuider.getInstance().removeRGInfoListeners(this.k);
    BNRouteGuider.getInstance().removeRGSubStatusListener(this.j);
    this.d = false;
    this.e = false;
    this.g = false;
    this.f = true;
    i.b(c, "unInit isInit:" + this.d + " isSendActionShow:" + this.e + " isNaviBegin:" + this.g + " isArriveDest:" + this.f);
  }
  
  public void d()
  {
    if (!this.e) {}
    CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.Builder localBuilder;
    do
    {
      return;
      this.f = true;
      this.e = false;
      localBuilder = CarlifeNaviNextTurnInfoProto.CarlifeNaviNextTurnInfo.newBuilder();
    } while (localBuilder == null);
    localBuilder.setAction(3);
    localBuilder.setRemainDistance(0);
    localBuilder.setTotalDistance(0);
    localBuilder.setNextTurn(24);
    localBuilder.setRoadName("目的地");
    localBuilder.setTurnIconData(ByteString.copyFrom(new byte[0]));
    a(localBuilder.build());
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/j/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */