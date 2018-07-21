package com.baidu.carlife.core.screen.video;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.Message;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.k;
import com.baidu.carlife.core.screen.presentation.AbsCarlifeActivityService;
import com.baidu.carlife.core.screen.presentation.a.b;
import com.baidu.carlife.protobuf.CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo;
import com.baidu.carlife.protobuf.CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.Builder;
import com.baidu.carlife.protobuf.CarlifeVideoFrameRateProto.CarlifeVideoFrameRate;
import com.baidu.carlife.protobuf.CarlifeVideoFrameRateProto.CarlifeVideoFrameRate.Builder;
import com.google.protobuf.InvalidProtocolBufferException;

public class f
{
  private static final String a = "Recorder_MsgHandler";
  private com.baidu.carlife.core.screen.j b;
  private a c = new a(Looper.getMainLooper());
  
  public f()
  {
    k.a(this.c);
  }
  
  private void a()
  {
    com.baidu.carlife.l.a.a().c(65623);
  }
  
  private void a(int paramInt)
  {
    Object localObject1 = new com.baidu.carlife.core.connect.c(true);
    ((com.baidu.carlife.core.connect.c)localObject1).c(65549);
    Object localObject2 = CarlifeVideoFrameRateProto.CarlifeVideoFrameRate.newBuilder();
    ((CarlifeVideoFrameRateProto.CarlifeVideoFrameRate.Builder)localObject2).setFrameRate(paramInt);
    localObject2 = ((CarlifeVideoFrameRateProto.CarlifeVideoFrameRate.Builder)localObject2).build();
    ((com.baidu.carlife.core.connect.c)localObject1).b(((CarlifeVideoFrameRateProto.CarlifeVideoFrameRate)localObject2).toByteArray());
    ((com.baidu.carlife.core.connect.c)localObject1).d(((CarlifeVideoFrameRateProto.CarlifeVideoFrameRate)localObject2).getSerializedSize());
    localObject1 = Message.obtain(null, ((com.baidu.carlife.core.connect.c)localObject1).d(), 1001, 0, localObject1);
    com.baidu.carlife.core.connect.d.a().a((Message)localObject1);
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    i.b("#######", "sendVideoSize: [" + paramInt2 + " : " + paramInt1 + " ]");
    Object localObject1 = new com.baidu.carlife.core.connect.c(true);
    ((com.baidu.carlife.core.connect.c)localObject1).c(65544);
    Object localObject2 = CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.newBuilder();
    ((CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.Builder)localObject2).setWidth(paramInt1);
    ((CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.Builder)localObject2).setHeight(paramInt2);
    ((CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.Builder)localObject2).setFrameRate(paramInt3);
    localObject2 = ((CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.Builder)localObject2).build();
    ((com.baidu.carlife.core.connect.c)localObject1).b(((CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo)localObject2).toByteArray());
    ((com.baidu.carlife.core.connect.c)localObject1).d(((CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo)localObject2).getSerializedSize());
    localObject1 = Message.obtain(null, ((com.baidu.carlife.core.connect.c)localObject1).d(), 1001, 0, localObject1);
    com.baidu.carlife.core.connect.d.a().a((Message)localObject1);
  }
  
  private void a(Message paramMessage)
  {
    if (this.b == null)
    {
      i.e("Recorder_MsgHandler", "mOnStatusChangeListener == null");
      return;
    }
    paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
    for (;;)
    {
      int i;
      int j;
      int k;
      try
      {
        paramMessage = CarlifeVideoEncoderInfoProto.CarlifeVideoEncoderInfo.parseFrom(paramMessage.f());
        i = paramMessage.getWidth();
        j = paramMessage.getHeight();
        k = paramMessage.getFrameRate();
        i.b("Recorder_MsgHandler", "VIDEO_ENCODER_INIT_INFO: [" + i + " , " + j + "]");
        if (!e.b().j()) {
          break label167;
        }
        if (com.baidu.carlife.core.b.a.a())
        {
          bool = e.b().c(i, j, k);
          this.b.o();
          if (!bool) {
            break;
          }
          a(e.c(), e.d(), k);
          return;
        }
      }
      catch (InvalidProtocolBufferException paramMessage)
      {
        i.e("Recorder_MsgHandler", "Get VIDEO_ENCODER_INIT_INFO Error");
        paramMessage.printStackTrace();
        return;
      }
      boolean bool = e.b().a(i, j, k);
      continue;
      label167:
      if (com.baidu.carlife.core.b.a.a())
      {
        if (AbsCarlifeActivityService.a())
        {
          i.b("Recorder_MsgHandler", "####### initMediaCodec50: " + i + " , " + j);
          bool = e.b().a(i, j);
          this.b.o();
        }
        else
        {
          a(e.c(), e.d(), k);
        }
      }
      else if (e.b().N())
      {
        bool = e.b().a(i, j);
        if (this.b.q())
        {
          e.b().i(true);
          paramMessage = new com.baidu.carlife.core.connect.c(true);
          paramMessage.c(65564);
          paramMessage = Message.obtain(null, paramMessage.d(), 1001, 0, paramMessage);
          com.baidu.carlife.core.connect.d.a().a(paramMessage);
        }
        else
        {
          e.b().P();
        }
      }
      else
      {
        bool = e.b().b(i, j, k);
      }
    }
    e.b().a(1);
  }
  
  private void a(boolean paramBoolean)
  {
    if (!com.baidu.carlife.l.d.a().m()) {
      return;
    }
    Object localObject = new com.baidu.carlife.core.connect.c(true);
    if (paramBoolean)
    {
      i.b("Recorder_MsgHandler", "send foreground message");
      ((com.baidu.carlife.core.connect.c)localObject).c(65563);
    }
    for (;;)
    {
      localObject = Message.obtain(null, ((com.baidu.carlife.core.connect.c)localObject).d(), 1001, 0, localObject);
      com.baidu.carlife.l.a.a().a((Message)localObject);
      return;
      i.b("Recorder_MsgHandler", "send background message");
      ((com.baidu.carlife.core.connect.c)localObject).c(65564);
    }
  }
  
  private void b()
  {
    e.b().K();
  }
  
  private void b(Message paramMessage)
  {
    paramMessage = (com.baidu.carlife.core.connect.c)paramMessage.obj;
    int i;
    try
    {
      paramMessage = CarlifeVideoFrameRateProto.CarlifeVideoFrameRate.parseFrom(paramMessage.f());
      i = paramMessage.getFrameRate();
      if ((i < 3) || (i > 30)) {
        return;
      }
    }
    catch (InvalidProtocolBufferException paramMessage)
    {
      i.e("Recorder_MsgHandler", "Get VIDEO_ENCODER_FRAME_RATE_CHANGE Error");
      paramMessage.printStackTrace();
      return;
    }
    e.b().b(i);
    a(i);
  }
  
  private void c()
  {
    e.b().F();
  }
  
  public void a(com.baidu.carlife.core.screen.j paramj)
  {
    this.b = paramj;
  }
  
  private class a
    extends com.baidu.carlife.core.j
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void careAbout()
    {
      addMsg(98390);
      addMsg(98311);
      addMsg(98313);
      addMsg(98314);
      addMsg(98315);
      addMsg(98316);
      addMsg(4009);
      addMsg(1002);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
      case 98390: 
      case 98311: 
        do
        {
          return;
          e.b().b(true);
          f.a(f.this);
          return;
          com.baidu.carlife.core.d.a().a(paramMessage);
          k.a(1040, paramMessage.obj);
          f.a(f.this, paramMessage);
          if (f.b(f.this) != null) {
            f.b(f.this).a(e.c(), e.d());
          }
          k.a(4009, 2000);
          if ((com.baidu.carlife.core.connect.e.a().b() == 2) && (Build.VERSION.SDK_INT < 21))
          {
            com.baidu.carlife.core.connect.d.a().a(false);
            return;
          }
        } while (!com.baidu.carlife.l.d.a().h());
        f.a(f.this, com.baidu.carlife.core.c.a().m());
        return;
      case 98313: 
        e.b().g();
        f.c(f.this);
        return;
      case 98315: 
        f.d(f.this);
        return;
      case 98314: 
        e.b().f();
        return;
      case 98316: 
        f.b(f.this, paramMessage);
        return;
      case 4009: 
        com.baidu.carlife.core.screen.b.f.a().c();
        com.baidu.carlife.core.screen.b.f.a().b();
        return;
      }
      if (com.baidu.carlife.core.b.a.a())
      {
        b.b().p();
        i.e("Recorder_MsgHandler", "---------end internal screen capture.---------");
      }
      e.b().b(false);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/screen/video/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */