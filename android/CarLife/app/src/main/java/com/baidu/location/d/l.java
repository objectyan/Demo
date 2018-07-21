package com.baidu.location.d;

import android.os.Looper;
import com.samsung.android.sdk.motion.Smotion;
import com.samsung.android.sdk.motion.SmotionActivityNotification;
import com.samsung.android.sdk.motion.SmotionActivityNotification.ChangeListener;
import com.samsung.android.sdk.motion.SmotionActivityNotification.Info;
import com.samsung.android.sdk.motion.SmotionActivityNotification.InfoFilter;
import java.util.ArrayList;
import java.util.List;

public class l
{
  private static Object a = new Object();
  private static l b = null;
  private boolean c = false;
  private boolean d = false;
  private int e = 0;
  private Smotion f;
  private SmotionActivityNotification g;
  private SmotionActivityNotification.InfoFilter h;
  private SmotionActivityNotification.Info i;
  private Looper j;
  private List<a> k;
  private SmotionActivityNotification.ChangeListener l = new SmotionActivityNotification.ChangeListener()
  {
    public void onChanged(SmotionActivityNotification.Info paramAnonymousInfo)
    {
      if (!l.a(l.this)) {}
      do
      {
        return;
        if (l.b(l.this) == null) {
          l.a(l.this, new ArrayList());
        }
      } while (paramAnonymousInfo == null);
      l.a(l.this, paramAnonymousInfo);
      l.b(l.this).add(new l.a(l.this, paramAnonymousInfo, (int)(System.currentTimeMillis() / 1000L)));
    }
  };
  
  public static l a()
  {
    synchronized (a)
    {
      if (b == null) {
        b = new l();
      }
      l locall = b;
      return locall;
    }
  }
  
  public void a(Looper paramLooper)
  {
    if (paramLooper == null) {}
    do
    {
      return;
      this.j = paramLooper;
    } while (!this.c);
    this.g = new SmotionActivityNotification(paramLooper, this.f);
    if (!this.g.isActivitySupported(4)) {
      this.c = false;
    }
    while (this.c)
    {
      if (this.h == null) {
        this.h = new SmotionActivityNotification.InfoFilter();
      }
      this.h.addActivity(4);
      this.h.addActivity(2);
      this.h.addActivity(1);
      this.h.addActivity(3);
      return;
      if (!this.g.isActivitySupported(3)) {
        this.c = false;
      } else if (!this.g.isActivitySupported(1)) {
        this.c = false;
      } else if (!this.g.isActivitySupported(2)) {
        this.c = false;
      }
    }
    i.a().b("support", 2);
  }
  
  public void b()
  {
    if (!this.c) {}
    while (this.d) {
      return;
    }
    if (this.h != null) {
      this.g.start(this.h, this.l);
    }
    this.d = true;
  }
  
  public void c()
  {
    if (!this.c) {}
    while (!this.d) {
      return;
    }
    if (this.h != null) {
      this.g.stop();
    }
    this.k.clear();
    this.k = null;
    this.i = null;
    this.d = false;
  }
  
  public List<Byte> d()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i2;
    if (this.k != null)
    {
      localObject1 = localObject2;
      if (this.k.size() > 0)
      {
        i2 = this.k.size();
        if (0 != 0) {
          break label458;
        }
      }
    }
    label120:
    label145:
    label340:
    label453:
    label458:
    for (localObject1 = new ArrayList();; localObject1 = null)
    {
      ((List)localObject1).add(Byte.valueOf((byte)82));
      ((List)localObject1).add(Byte.valueOf((byte)(i2 & 0xFF)));
      int i1 = 0;
      int m;
      int n;
      if (i1 < i2)
      {
        m = 0;
        if (((a)this.k.get(i1)).a.getStatus() == 1)
        {
          m = 0;
          if (((a)this.k.get(i1)).a.getAccuracy() != 2) {
            break label340;
          }
          n = 0;
        }
      }
      for (;;)
      {
        m = (byte)((byte)(m & 0xF) << 4);
        ((List)localObject1).add(Byte.valueOf((byte)((byte)(n & 0xF) | m)));
        if (i1 == i2 - 1) {
          ((List)localObject1).add(Byte.valueOf((byte)(int)(System.currentTimeMillis() / 1000L - ((a)this.k.get(i1)).b & 0xFF)));
        }
        for (;;)
        {
          i1 += 1;
          break;
          if (((a)this.k.get(i1)).a.getStatus() == 3)
          {
            m = 2;
            break label120;
          }
          if (((a)this.k.get(i1)).a.getStatus() == 2)
          {
            m = 1;
            break label120;
          }
          if (((a)this.k.get(i1)).a.getStatus() == 4)
          {
            m = 3;
            break label120;
          }
          if (((a)this.k.get(i1)).a.getStatus() != 0) {
            break label120;
          }
          m = 5;
          break label120;
          if (((a)this.k.get(i1)).a.getAccuracy() == 1)
          {
            n = 1;
            break label145;
          }
          if (((a)this.k.get(i1)).a.getAccuracy() != 0) {
            break label453;
          }
          n = 2;
          break label145;
          ((List)localObject1).add(Byte.valueOf((byte)(int)(((a)this.k.get(i1 + 1)).b - ((a)this.k.get(i1)).b & 0xFF)));
        }
        return (List<Byte>)localObject1;
        n = 0;
      }
    }
  }
  
  public void e()
  {
    if ((this.k != null) && (this.i != null))
    {
      this.k.clear();
      this.k.add(new a(this.i, (int)(System.currentTimeMillis() / 1000L)));
    }
  }
  
  private class a
  {
    public SmotionActivityNotification.Info a;
    public long b;
    
    a(SmotionActivityNotification.Info paramInfo, long paramLong)
    {
      this.a = paramInfo;
      this.b = paramLong;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/d/l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */