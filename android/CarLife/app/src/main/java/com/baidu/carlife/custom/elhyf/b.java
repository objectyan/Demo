package com.baidu.carlife.custom.elhyf;

import android.content.Context;
import android.os.Message;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.screen.presentation.a.f;
import com.baidu.carlife.core.screen.presentation.a.g;
import com.baidu.carlife.custom.elhyf.b.a.a;
import com.baidu.carlife.custom.elhyf.c.d;
import com.baidu.carlife.custom.elhyf.c.d.a;
import com.baidu.carlife.protobuf.CarlifeASRVersionMatchProto.CarlifeASRVersionMatch;
import com.baidu.carlife.protobuf.CarlifeASRVersionMatchProto.CarlifeASRVersionMatch.Builder;
import com.baidu.carlife.protobuf.CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync;
import com.baidu.carlife.protobuf.CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync.Builder;
import com.baidu.carlife.protobuf.CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType;
import com.baidu.carlife.util.w;
import java.util.TimeZone;

public class b
  implements a.a
{
  static b k;
  String a;
  String b;
  com.baidu.carlife.custom.elhyf.b.a c;
  com.baidu.carlife.view.dialog.c d;
  com.baidu.carlife.view.dialog.c e;
  com.baidu.carlife.view.dialog.c f;
  com.baidu.carlife.view.dialog.c g;
  com.baidu.carlife.custom.elhyf.a.a h;
  com.baidu.carlife.custom.elhyf.a.a i;
  Context j;
  
  public static b a()
  {
    if (k == null) {
      k = new b();
    }
    return k;
  }
  
  private void a(String paramString)
  {
    d.a().a(paramString, CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType.Photo, new d.a()
    {
      public void a()
      {
        w.a("Photo TransferData start!", 1);
      }
      
      public void a(int paramAnonymousInt)
      {
        w.a("Photo TransferData  " + paramAnonymousInt + "%", 1);
      }
      
      public void b()
      {
        w.a("Photo TransferData success!", 1);
      }
      
      public void c()
      {
        w.a("Photo TransferData failed!", 1);
      }
    });
  }
  
  public static void b()
  {
    if (com.baidu.carlife.l.a.a().N())
    {
      int m = (int)((System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) / 1000L);
      Object localObject = CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync.newBuilder();
      ((CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync.Builder)localObject).setTimeStamp(m);
      localObject = ((CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync.Builder)localObject).build();
      com.baidu.carlife.core.connect.c localc = new com.baidu.carlife.core.connect.c(true);
      localc.b(((CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync)localObject).toByteArray());
      localc.d(((CarlifeConnectTimeSyncProto.CarlifeConnectTimeSync)localObject).getSerializedSize());
      localc.c(65632);
      localObject = Message.obtain(null, localc.d(), 1001, 0, localc);
      com.baidu.carlife.l.a.a().a((Message)localObject);
    }
  }
  
  private void b(String paramString, long paramLong)
  {
    int m = 1;
    if (this.d == null)
    {
      this.d = new com.baidu.carlife.view.dialog.c(this.j).c(this.j.getString(2131298886, new Object[] { Float.valueOf((float)(paramLong / 1024L) / 1024.0F) })).g(17).d(this.j.getString(2131296264)).q().d(2131298683);
      this.d.a(new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          b.this.c.b();
          if (b.this.h == null) {
            b.this.h = new com.baidu.carlife.custom.elhyf.a.a(b.this.j);
          }
          b.this.h.setProgress(0);
          b.this.h.setTitle(b.this.j.getString(2131298895));
          g.a().showDialog(b.this.h);
        }
      });
      this.d.b(new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          b.this.c.c();
        }
      });
    }
    if (this.d.isShown()) {
      this.d.d();
    }
    if (e.s() == 1) {
      if (m == 0) {
        break label240;
      }
    }
    label240:
    for (String str = "\n（" + this.j.getString(2131296609) + ")";; str = "")
    {
      this.d.b(paramString + "\n" + this.j.getString(2131298887) + str);
      g.a().b().showDialog(this.d);
      return;
      m = 0;
      break;
    }
  }
  
  private void b(final String paramString1, final String paramString2, final String paramString3)
  {
    if (this.e == null)
    {
      this.e = new com.baidu.carlife.view.dialog.c(this.j).b(2131298890).g(17).c(2131296264).q().d(2131298683);
      this.e.a(new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          b.a(b.this, paramString1, paramString2, paramString3);
        }
      });
      this.e.b(new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          b.this.c.c();
        }
      });
    }
    if (this.e.isShown()) {
      this.e.d();
    }
    this.e.b(this.j.getString(2131298879));
    g.a().showDialog(this.e);
  }
  
  public static void c()
  {
    if (com.baidu.carlife.l.a.a().N())
    {
      Object localObject = CarlifeASRVersionMatchProto.CarlifeASRVersionMatch.newBuilder();
      ((CarlifeASRVersionMatchProto.CarlifeASRVersionMatch.Builder)localObject).setAsrName("UscAsr");
      ((CarlifeASRVersionMatchProto.CarlifeASRVersionMatch.Builder)localObject).setVersionCode(1);
      localObject = ((CarlifeASRVersionMatchProto.CarlifeASRVersionMatch.Builder)localObject).build();
      com.baidu.carlife.core.connect.c localc = new com.baidu.carlife.core.connect.c(true);
      localc.b(((CarlifeASRVersionMatchProto.CarlifeASRVersionMatch)localObject).toByteArray());
      localc.d(((CarlifeASRVersionMatchProto.CarlifeASRVersionMatch)localObject).getSerializedSize());
      localc.c(65634);
      localObject = Message.obtain(null, localc.d(), 1001, 0, localc);
      com.baidu.carlife.l.a.a().a((Message)localObject);
    }
  }
  
  private void c(String paramString1, String paramString2, String paramString3)
  {
    if (!com.baidu.carlife.l.a.a().N()) {
      w.a(2131297192, 1);
    }
    long l1;
    long l2;
    do
    {
      return;
      if ((this.b == null) || (this.b.isEmpty()))
      {
        w.a(2131298888, 1);
        return;
      }
      l1 = Integer.parseInt(this.b);
      l2 = Integer.parseInt(paramString3);
    } while ((!this.a.equals(paramString2)) || (l1 >= l2));
    if (this.i == null) {
      this.i = new com.baidu.carlife.custom.elhyf.a.a(this.j);
    }
    this.i.setProgress(0);
    this.i.setTitle(this.j.getString(2131298897));
    g.a().showDialog(this.i);
    d.a().a(paramString1, CarlifeTransferDataStartProto.CarlifeTransferDataStart.DataType.Firmware, new d.a()
    {
      public void a() {}
      
      public void a(int paramAnonymousInt)
      {
        b.this.i.setProgress(paramAnonymousInt);
      }
      
      public void b()
      {
        w.a(2131298893, 1);
        b.this.i.d();
      }
      
      public void c()
      {
        w.a(2131298892, 1);
        b.this.i.d();
      }
    });
  }
  
  private void i()
  {
    if (this.f == null) {
      this.f = new com.baidu.carlife.view.dialog.c(this.j).b(2131298896).g(17);
    }
    if (this.f.isShown()) {
      this.f.d();
    }
    this.f.a(2131298884);
    g.a().showDialog(this.f);
  }
  
  private void j()
  {
    if (this.g == null)
    {
      this.g = new com.baidu.carlife.view.dialog.c(this.j).b(2131298896).g(17).c(2131298885).d(2131296259);
      this.g.a(new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          b.this.g.d();
          b.this.c.b();
          if (b.this.h == null) {
            b.this.h = new com.baidu.carlife.custom.elhyf.a.a(b.this.j);
          }
          b.this.h.setProgress(0);
          b.this.h.setTitle(b.this.j.getString(2131298895));
          g.a().b().showDialog(b.this.h);
        }
      });
      this.g.b(new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          b.this.g.d();
        }
      });
    }
    if (this.g.isShown()) {
      this.g.d();
    }
    this.g.a(2131298883);
    g.a().showDialog(this.g);
  }
  
  public void a(int paramInt)
  {
    this.h.d();
    w.a(2131298880);
  }
  
  public void a(Context paramContext)
  {
    this.j = paramContext;
    d.a().a(paramContext);
    com.baidu.carlife.custom.elhyf.c.b.a().a(paramContext.getApplicationContext());
    com.baidu.carlife.custom.elhyf.mydvr.a.a().a(paramContext.getApplicationContext());
    com.baidu.carlife.custom.elhyf.mydvr.c.a().a(paramContext.getApplicationContext());
  }
  
  public void a(String paramString, long paramLong)
  {
    b(paramString, paramLong);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.c == null) {
      this.c = new com.baidu.carlife.custom.elhyf.b.a(this);
    }
    this.a = paramString1;
    this.b = paramString2;
    this.c.a(this.a, this.b, false);
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    if (this.h != null) {
      this.h.d();
    }
    if (this.f != null) {
      this.f.d();
    }
    b(paramString1, paramString2, paramString3);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      w.a(2131298889);
    }
  }
  
  public void b(int paramInt)
  {
    this.h.setProgress(paramInt);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      w.a(2131298891);
    }
  }
  
  public void d()
  {
    if (this.c == null) {
      this.c = new com.baidu.carlife.custom.elhyf.b.a(this);
    }
    this.c.a();
  }
  
  public void e()
  {
    if ((com.baidu.carlife.l.a.a().N()) && ((this.b == null) || ("".equals(this.b))))
    {
      w.a(2131298888, 0);
      return;
    }
    this.c.a();
  }
  
  public boolean f()
  {
    return this.c.d();
  }
  
  public void g()
  {
    if (this.h != null) {
      this.h.d();
    }
    i();
  }
  
  public void h()
  {
    if (this.h != null) {
      this.h.d();
    }
    this.f.d();
    j();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/custom/elhyf/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */