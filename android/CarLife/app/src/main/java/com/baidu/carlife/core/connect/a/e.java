package com.baidu.carlife.core.connect.a;

import android.os.Message;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.carlife.protobuf.CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse;
import com.baidu.carlife.protobuf.CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest;
import com.baidu.carlife.protobuf.CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest.Builder;
import com.google.protobuf.InvalidProtocolBufferException;
import java.security.PublicKey;
import java.util.Timer;
import java.util.TimerTask;

public class e
{
  private static e h;
  private boolean a = false;
  private boolean b = false;
  private a c = new a(null);
  private boolean d = false;
  private Object e = new Object();
  private Timer f;
  private f g = new f();
  private String i;
  
  private e()
  {
    k.a(this.c);
  }
  
  public static e a()
  {
    if (h == null) {
      h = new e();
    }
    return h;
  }
  
  private boolean f()
  {
    g();
    c.a().a("[send] MSG_CMD_MD_RSA_PUBLIC_KEY_REQUEST");
    com.baidu.carlife.l.a.a().c(65642);
    synchronized (this.e)
    {
      try
      {
        this.e.wait();
        return this.d;
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
  
  private void g()
  {
    this.f = new Timer();
    this.f.schedule(new TimerTask()
    {
      public void run()
      {
        synchronized (e.b(e.this))
        {
          e.b(e.this).notifyAll();
          return;
        }
      }
    }, d.c);
  }
  
  private void h()
  {
    if (this.f == null) {
      return;
    }
    this.f.cancel();
  }
  
  private int i()
  {
    Object localObject1 = this.g.a(a().d());
    if (localObject1 == null) {
      return -1;
    }
    localObject1 = this.g.a(d.a().b(), (PublicKey)localObject1);
    Object localObject2 = CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest.newBuilder();
    ((CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest.Builder)localObject2).setAesKey((String)localObject1);
    localObject1 = ((CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest.Builder)localObject2).build();
    localObject2 = new com.baidu.carlife.core.connect.c(true);
    ((com.baidu.carlife.core.connect.c)localObject2).c(65644);
    ((com.baidu.carlife.core.connect.c)localObject2).b(((CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest)localObject1).toByteArray());
    ((com.baidu.carlife.core.connect.c)localObject2).d(((CarlifeMdAesKeyRequestProto.CarlifeMdAesKeyRequest)localObject1).getSerializedSize());
    localObject1 = Message.obtain(null, ((com.baidu.carlife.core.connect.c)localObject2).d(), 1001, 0, localObject2);
    com.baidu.carlife.core.connect.d.a().a((Message)localObject1);
    return 0;
  }
  
  public void a(final a parama)
  {
    if (parama == null) {
      return;
    }
    new Thread()
    {
      public void run()
      {
        if (e.a(e.this))
        {
          parama.a(true);
          return;
        }
        parama.a(false);
      }
    }.start();
  }
  
  public void a(String paramString)
  {
    this.i = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void b(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean b()
  {
    return this.a;
  }
  
  public boolean c()
  {
    return this.b;
  }
  
  public String d()
  {
    return this.i;
  }
  
  public void e()
  {
    a(false);
    b(false);
  }
  
  private class a
    extends j
  {
    private a() {}
    
    public void careAbout()
    {
      addMsg(98411);
      addMsg(98413);
    }
    
    public void handleMessage(Message arg1)
    {
      switch (???.what)
      {
      case 98412: 
      default: 
        return;
      case 98411: 
        c.a().a("[receive] MSG_CMD_HU_RSA_PUBLIC_KEY_RESPONSE");
        Object localObject1 = (com.baidu.carlife.core.connect.c)???.obj;
        ??? = null;
        try
        {
          localObject1 = CarlifeHuRsaPublicKeyResponseProto.CarlifeHuRsaPublicKeyResponse.parseFrom(((com.baidu.carlife.core.connect.c)localObject1).f());
          ??? = (Message)localObject1;
        }
        catch (InvalidProtocolBufferException localInvalidProtocolBufferException)
        {
          for (;;)
          {
            localInvalidProtocolBufferException.printStackTrace();
          }
          e.this.a(???.getRsaPublicKey());
          c.a().a("[send] MSG_CMD_MD_AES_KEY_SEND_REQUEST");
          e.c(e.this);
          return;
        }
        if (??? == null) {
          synchronized (e.b(e.this))
          {
            e.b(e.this).notifyAll();
            return;
          }
        }
        break;
      }
      c.a().a("[receive] MSG_CMD_HU_AES_REC_RESPONSE");
      e.d(e.this);
      e.a().b(e.this.b());
      e.a(e.this, true);
      synchronized (e.b(e.this))
      {
        e.b(e.this).notifyAll();
        return;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/connect/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */