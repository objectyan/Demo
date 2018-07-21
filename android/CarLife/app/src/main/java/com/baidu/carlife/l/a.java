package com.baidu.carlife.l;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.hardware.usb.UsbAccessory;
import android.os.Message;
import com.baidu.carlife.core.connect.e;
import com.baidu.carlife.core.h;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.screen.j;
import java.util.ArrayList;

public class a
  implements h
{
  public static final String a = "CarlifeCoreSDK";
  public static final int b = 4353;
  public static final int c = 1;
  public static final int d = 2;
  public static final int e = 300;
  public static final int f = 301;
  public static final int g = 302;
  public static final int h = 303;
  public static final int i = 304;
  public static final int j = 305;
  public static final boolean k = true;
  public static final boolean l = false;
  private static a m;
  
  public static a a()
  {
    if (m == null) {
      m = new a();
    }
    return m;
  }
  
  public void A()
  {
    b.a().i();
  }
  
  public void B()
  {
    b.a().j();
  }
  
  public boolean C()
  {
    return b.a().k();
  }
  
  public boolean D()
  {
    return b.a().m();
  }
  
  public void E()
  {
    b.a().l();
  }
  
  public void F()
  {
    b.a().n();
  }
  
  public void G()
  {
    b.a().o();
  }
  
  public void H()
  {
    b.a().q();
  }
  
  public void I()
  {
    b.a().r();
  }
  
  public boolean J()
  {
    return b.a().s();
  }
  
  public boolean K()
  {
    return b.a().t();
  }
  
  public void L()
  {
    com.baidu.carlife.core.connect.d.a().b();
  }
  
  public void M()
  {
    com.baidu.carlife.core.connect.a.a().b();
  }
  
  public boolean N()
  {
    return com.baidu.carlife.core.connect.d.a().c();
  }
  
  public void O()
  {
    com.baidu.carlife.core.connect.d.a().a(false);
  }
  
  public void P()
  {
    e.a().i();
  }
  
  public void Q()
  {
    e.a().e();
  }
  
  public void R()
  {
    e.a().f();
  }
  
  public int S()
  {
    return e.a().b();
  }
  
  public void T()
  {
    c.a().b();
  }
  
  public boolean U()
  {
    return c.a().c();
  }
  
  public boolean V()
  {
    return c.a().d();
  }
  
  public void W()
  {
    c.a().e();
  }
  
  public int a(com.baidu.carlife.core.connect.c paramc)
  {
    if (paramc == null)
    {
      i.e("CarlifeCoreSDK", "write error: data buffer is null");
      return -1;
    }
    return e.a().b(paramc);
  }
  
  public void a(int paramInt)
  {
    b.a().a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    b.a().a(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    d.a().a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(int paramInt, com.baidu.carlife.core.screen.b.c paramc)
  {
    com.baidu.carlife.core.screen.b.f.a().a(paramInt, paramc);
  }
  
  public void a(Activity paramActivity, Class paramClass, j paramj, Drawable paramDrawable, int paramInt)
  {
    d.a().a(paramActivity, paramClass, paramj, paramDrawable, paramInt);
  }
  
  public void a(Context paramContext)
  {
    b.a().a(paramContext);
  }
  
  public void a(Context paramContext, UsbAccessory paramUsbAccessory)
  {
    com.baidu.carlife.core.connect.a.a().a(paramContext, paramUsbAccessory);
  }
  
  public void a(com.baidu.carlife.core.connect.a.a parama)
  {
    c.a().a(parama);
  }
  
  public void a(com.baidu.carlife.core.screen.b.c paramc)
  {
    com.baidu.carlife.core.screen.b.f.a().b(paramc);
  }
  
  public void a(String paramString)
  {
    b.a().a(paramString, null);
  }
  
  public void a(String paramString, ArrayList<String> paramArrayList)
  {
    b.a().a(paramString, paramArrayList);
  }
  
  public void a(boolean paramBoolean)
  {
    d.a().a(paramBoolean);
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt)
  {
    b.a().a(paramArrayOfByte, paramInt);
  }
  
  public boolean a(Message paramMessage)
  {
    if (paramMessage == null)
    {
      i.e("CarlifeCoreSDK", "send error: msg is null");
      return false;
    }
    return com.baidu.carlife.core.connect.d.a().a(paramMessage);
  }
  
  public byte[] a(int paramInt1, int paramInt2)
  {
    return b.a().a(paramInt1, paramInt2);
  }
  
  public int b()
  {
    return d.a().b();
  }
  
  public void b(int paramInt)
  {
    b.a().b(paramInt);
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    b.a().b(paramInt1, paramInt2, paramInt3);
  }
  
  public void b(Context paramContext)
  {
    com.baidu.carlife.core.connect.d.a().a(paramContext);
  }
  
  public void b(boolean paramBoolean)
  {
    d.a().b(paramBoolean);
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt)
  {
    b.a().b(paramArrayOfByte, paramInt);
  }
  
  public int c()
  {
    return d.a().c();
  }
  
  public void c(int paramInt)
  {
    if (!com.baidu.carlife.core.connect.d.a().c())
    {
      i.e("CarlifeCoreSDK", "--disconnected!!!---");
      return;
    }
    Object localObject = new com.baidu.carlife.core.connect.c(true);
    ((com.baidu.carlife.core.connect.c)localObject).c(paramInt);
    localObject = Message.obtain(null, ((com.baidu.carlife.core.connect.c)localObject).d(), 1001, 0, localObject);
    com.baidu.carlife.core.connect.d.a().a((Message)localObject);
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    b.a().c(paramInt1, paramInt2, paramInt3);
  }
  
  public void c(boolean paramBoolean)
  {
    d.a().c(paramBoolean);
  }
  
  public void c(byte[] paramArrayOfByte, int paramInt)
  {
    b.a().c(paramArrayOfByte, paramInt);
  }
  
  public int d(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null)
    {
      i.e("CarlifeCoreSDK", "write error: VR buffer is null");
      return -1;
    }
    return e.a().g(paramArrayOfByte, paramInt);
  }
  
  public Bitmap d()
  {
    return d.a().d();
  }
  
  public void d(boolean paramBoolean)
  {
    d.a().d(paramBoolean);
  }
  
  public int e(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null)
    {
      i.e("CarlifeCoreSDK", "read error: VR buffer is null");
      return -1;
    }
    return e.a().h(paramArrayOfByte, paramInt);
  }
  
  public void e(boolean paramBoolean)
  {
    e.a().a(paramBoolean);
  }
  
  public boolean e()
  {
    return d.a().e();
  }
  
  public void f()
  {
    d.a().f();
  }
  
  public void f(boolean paramBoolean)
  {
    c.a().a(paramBoolean);
  }
  
  public byte[] f(byte[] paramArrayOfByte, int paramInt)
  {
    return c.a().a(paramArrayOfByte, paramInt);
  }
  
  public void g()
  {
    d.a().g();
  }
  
  public byte[] g(byte[] paramArrayOfByte, int paramInt)
  {
    return c.a().b(paramArrayOfByte, paramInt);
  }
  
  public boolean h()
  {
    return d.a().h();
  }
  
  public boolean i()
  {
    return d.a().i();
  }
  
  public boolean j()
  {
    return d.a().j();
  }
  
  public void k()
  {
    d.a().k();
  }
  
  public void l()
  {
    d.a().l();
  }
  
  public boolean m()
  {
    return d.a().m();
  }
  
  public com.baidu.carlife.core.screen.presentation.f n()
  {
    return d.a().n();
  }
  
  public int o()
  {
    return com.baidu.carlife.core.screen.b.f.a().d();
  }
  
  public int p()
  {
    return com.baidu.carlife.core.screen.b.f.a().e();
  }
  
  public int q()
  {
    return com.baidu.carlife.core.screen.b.f.a().f();
  }
  
  public int r()
  {
    return com.baidu.carlife.core.screen.b.f.a().g();
  }
  
  public boolean s()
  {
    return b.a().b();
  }
  
  public boolean t()
  {
    return b.a().c();
  }
  
  public void u()
  {
    b.a().d();
  }
  
  public void v()
  {
    b.a().e();
  }
  
  public void w()
  {
    b.a().f();
  }
  
  public void x()
  {
    b.a().p();
  }
  
  public void y()
  {
    b.a().g();
  }
  
  public void z()
  {
    b.a().h();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/l/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */