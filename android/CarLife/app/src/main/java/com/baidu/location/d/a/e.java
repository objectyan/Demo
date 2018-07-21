package com.baidu.location.d.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import java.io.File;

public class e
  implements SensorEventListener
{
  public boolean a = false;
  public long b = 0L;
  long c = 0L;
  private SensorManager d;
  private a e;
  private a f;
  private a g;
  private a h;
  private a i;
  private Handler j;
  private HandlerThread k;
  private StringBuffer l = null;
  private Runnable m = null;
  private boolean n = false;
  private int o = 1;
  
  private e()
  {
    try
    {
      this.d = ((SensorManager)com.baidu.location.f.getServiceContext().getSystemService("sensor"));
      this.e = new a(1);
      this.f = new a(2);
      this.h = new a(4);
      this.i = new a(6);
      this.g = new a(9);
      return;
    }
    catch (Exception localException) {}
  }
  
  public static e a()
  {
    return b.a;
  }
  
  public void a(long paramLong)
  {
    if (this.a) {}
    while (!d.a(2)) {
      return;
    }
    if (this.k == null)
    {
      this.k = new HandlerThread("map-slam-collector");
      this.k.start();
    }
    if (this.j == null) {
      this.j = new Handler(this.k.getLooper());
    }
    this.a = true;
    this.b = System.currentTimeMillis();
    this.l = new StringBuffer(8192);
    StringBuffer localStringBuffer = new StringBuffer(128);
    localStringBuffer.append("Tc");
    localStringBuffer.append("\t");
    localStringBuffer.append(System.currentTimeMillis());
    localStringBuffer.append("\n");
    b(localStringBuffer);
    com.baidu.location.f.f.a().s();
    this.e.a();
    this.f.a();
    this.g.a();
    this.h.a();
    this.i.a();
    this.m = new Runnable()
    {
      public void run()
      {
        a.a().d();
        e.this.b();
      }
    };
    this.j.postDelayed(this.m, paramLong);
  }
  
  public void a(StringBuffer paramStringBuffer)
  {
    b(paramStringBuffer);
    this.c = System.currentTimeMillis();
  }
  
  public void b()
  {
    if (!this.a) {
      return;
    }
    this.j.removeCallbacks(this.m);
    this.e.b();
    this.f.b();
    this.g.b();
    this.h.b();
    this.i.b();
    Object localObject = new StringBuffer(128);
    ((StringBuffer)localObject).append("Te");
    ((StringBuffer)localObject).append("\t");
    ((StringBuffer)localObject).append(System.currentTimeMillis());
    ((StringBuffer)localObject).append("\n");
    b((StringBuffer)localObject);
    if (((this.l != null) && (this.l.length() > 200)) || (this.n))
    {
      localObject = new File(d.c(2));
      d.a(this.l, (File)localObject);
      this.n = false;
    }
    this.l = null;
    this.a = false;
    try
    {
      if (this.j != null) {
        this.j.removeCallbacksAndMessages(null);
      }
      this.j = null;
      try
      {
        if (this.k != null)
        {
          this.k.quit();
          this.k.interrupt();
        }
        this.k = null;
        return;
      }
      catch (Exception localException1)
      {
        for (;;) {}
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public void b(StringBuffer paramStringBuffer)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	com/baidu/location/d/a/e:a	Z
    //   6: ifeq +12 -> 18
    //   9: aload_0
    //   10: getfield 44	com/baidu/location/d/a/e:l	Ljava/lang/StringBuffer;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnonnull +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: getfield 44	com/baidu/location/d/a/e:l	Ljava/lang/StringBuffer;
    //   25: aload_1
    //   26: iconst_2
    //   27: invokestatic 187	com/baidu/location/d/a/d:c	(I)Ljava/lang/String;
    //   30: invokestatic 205	com/baidu/location/d/a/d:a	(Ljava/lang/StringBuffer;Ljava/lang/StringBuffer;Ljava/lang/String;)V
    //   33: goto -15 -> 18
    //   36: astore_1
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_1
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	e
    //   0	41	1	paramStringBuffer	StringBuffer
    //   13	2	2	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   2	14	36	finally
    //   21	33	36	finally
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    int i1 = paramSensorEvent.sensor.getType();
    StringBuffer localStringBuffer = new StringBuffer(256);
    a locala;
    if (i1 == 1)
    {
      locala = this.e;
      locala.d += 1;
      localStringBuffer.append("A");
      localStringBuffer.append("\t");
      localStringBuffer.append(paramSensorEvent.values[0]);
      localStringBuffer.append("\t");
      localStringBuffer.append(paramSensorEvent.values[1]);
      localStringBuffer.append("\t");
      localStringBuffer.append(paramSensorEvent.values[2]);
      if (this.e.d == 1)
      {
        localStringBuffer.append("\t");
        localStringBuffer.append(paramSensorEvent.timestamp);
        this.e.e = paramSensorEvent.timestamp;
        if (this.e.d > 13) {
          this.e.d = 0;
        }
        localStringBuffer.append("\n");
        b(localStringBuffer);
      }
    }
    else
    {
      if (i1 == 2)
      {
        locala = this.f;
        locala.d += 1;
        localStringBuffer.append("M");
        localStringBuffer.append("\t");
        localStringBuffer.append(paramSensorEvent.values[0]);
        localStringBuffer.append("\t");
        localStringBuffer.append(paramSensorEvent.values[1]);
        localStringBuffer.append("\t");
        localStringBuffer.append(paramSensorEvent.values[2]);
        if (this.f.d != 1) {
          break label783;
        }
        localStringBuffer.append("\t");
        localStringBuffer.append(paramSensorEvent.timestamp);
        this.f.e = paramSensorEvent.timestamp;
        label295:
        if (this.f.d > 13) {
          this.f.d = 0;
        }
        localStringBuffer.append("\n");
        b(localStringBuffer);
      }
      if (i1 == 9)
      {
        locala = this.g;
        locala.d += 1;
        localStringBuffer.append("G");
        localStringBuffer.append("\t");
        localStringBuffer.append(paramSensorEvent.values[0]);
        localStringBuffer.append("\t");
        localStringBuffer.append(paramSensorEvent.values[1]);
        localStringBuffer.append("\t");
        localStringBuffer.append(paramSensorEvent.values[2]);
        if (this.g.d != 1) {
          break label810;
        }
        localStringBuffer.append("\t");
        localStringBuffer.append(paramSensorEvent.timestamp);
        this.g.e = paramSensorEvent.timestamp;
        label450:
        if (this.g.d > 13) {
          this.g.d = 0;
        }
        localStringBuffer.append("\n");
        b(localStringBuffer);
      }
      if (i1 == 4)
      {
        locala = this.h;
        locala.d += 1;
        localStringBuffer.append("X");
        localStringBuffer.append("\t");
        localStringBuffer.append(paramSensorEvent.values[0]);
        localStringBuffer.append("\t");
        localStringBuffer.append(paramSensorEvent.values[1]);
        localStringBuffer.append("\t");
        localStringBuffer.append(paramSensorEvent.values[2]);
        if (this.h.d != 1) {
          break label837;
        }
        localStringBuffer.append("\t");
        localStringBuffer.append(paramSensorEvent.timestamp);
        this.h.e = paramSensorEvent.timestamp;
        label604:
        if (this.h.d > 13) {
          this.h.d = 0;
        }
        localStringBuffer.append("\n");
        b(localStringBuffer);
      }
      if (i1 == 6)
      {
        locala = this.i;
        locala.d += 1;
        localStringBuffer.append("P");
        localStringBuffer.append("\t");
        localStringBuffer.append(paramSensorEvent.values[0]);
        if (this.i.d != 1) {
          break label864;
        }
        localStringBuffer.append("\t");
        localStringBuffer.append(paramSensorEvent.timestamp);
        this.i.e = paramSensorEvent.timestamp;
      }
    }
    for (;;)
    {
      if (this.i.d > 13) {
        this.i.d = 0;
      }
      localStringBuffer.append("\n");
      b(localStringBuffer);
      return;
      localStringBuffer.append("\t");
      localStringBuffer.append(paramSensorEvent.timestamp - this.e.e);
      break;
      label783:
      localStringBuffer.append("\t");
      localStringBuffer.append(paramSensorEvent.timestamp - this.f.e);
      break label295;
      label810:
      localStringBuffer.append("\t");
      localStringBuffer.append(paramSensorEvent.timestamp - this.g.e);
      break label450;
      label837:
      localStringBuffer.append("\t");
      localStringBuffer.append(paramSensorEvent.timestamp - this.h.e);
      break label604;
      label864:
      localStringBuffer.append("\t");
      localStringBuffer.append(paramSensorEvent.timestamp - this.i.e);
    }
  }
  
  class a
  {
    public boolean a = false;
    Sensor b;
    StringBuffer c = null;
    int d = 0;
    long e = 0L;
    
    public a(int paramInt)
    {
      try
      {
        this.b = e.a(e.this).getDefaultSensor(paramInt);
        if ((this.b == null) && ((paramInt == 1) || (paramInt == 2) || (paramInt == 9))) {
          a.a = false;
        }
        return;
      }
      catch (Exception this$1)
      {
        for (;;)
        {
          this.b = null;
        }
      }
    }
    
    public void a()
    {
      if ((e.a(e.this) == null) || (this.b == null)) {}
      while (this.a) {
        return;
      }
      try
      {
        e.a(e.this).registerListener(e.this, this.b, e.b(e.this), e.c(e.this));
        this.a = true;
        this.d = 0;
        this.e = 0L;
        return;
      }
      catch (Exception localException) {}
    }
    
    public void b()
    {
      if (this.a) {}
      try
      {
        e.a(e.this).unregisterListener(e.this);
        this.a = false;
        return;
      }
      catch (Exception localException) {}
    }
  }
  
  private static class b
  {
    public static final e a = new e(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/d/a/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */