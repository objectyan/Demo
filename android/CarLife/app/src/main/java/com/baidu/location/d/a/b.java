package com.baidu.location.d.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class b
{
  private static b b = null;
  private static Context c = null;
  private static a d = null;
  private static SensorManager e;
  private static Sensor f;
  private static List<Float> g = new ArrayList();
  private static List<Long> h = new ArrayList();
  private static int i = -1;
  SensorEventListener a = new SensorEventListener()
  {
    public void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt) {}
    
    public void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
    {
      if (paramAnonymousSensorEvent.sensor.getType() == 6)
      {
        b.c().add(Float.valueOf(paramAnonymousSensorEvent.values[0]));
        b.d().add(Long.valueOf(paramAnonymousSensorEvent.timestamp));
        int i = (int)((((Long)b.d().get(b.d().size() - 1)).longValue() - ((Long)b.d().get(0)).longValue()) / 1000000000L);
        if (b.e() >= 1)
        {
          b.c().remove(0);
          b.d().remove(0);
        }
        if ((i >= 6) && (b.f() <= 0))
        {
          if (Math.abs(b.a(b.this, b.c(), 0, b.c().size() / 2) - b.a(b.this, b.c(), b.c().size() / 2, b.c().size() - 1)) <= 0.04D) {
            break label211;
          }
          b.g().a(100);
        }
      }
      for (;;)
      {
        b.a(50);
        return;
        label211:
        b.g().a(111);
      }
    }
  };
  
  private float a(List<Float> paramList, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramInt1 <= paramInt2)
    {
      localArrayList.add(paramList.get(paramInt1));
      paramInt1 += 1;
    }
    Collections.sort(localArrayList);
    return ((Float)localArrayList.get(localArrayList.size() / 2)).floatValue();
  }
  
  public static b a(Context paramContext, a parama)
  {
    if (b == null)
    {
      b = new b();
      c = paramContext;
      if (e == null) {
        e = (SensorManager)c.getSystemService("sensor");
      }
      if (f == null) {
        f = e.getDefaultSensor(6);
      }
      i = -1;
      d = parama;
    }
    return b;
  }
  
  public void a()
  {
    try
    {
      e.registerListener(this.a, f, 1);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void b()
  {
    try
    {
      e.unregisterListener(this.a, f);
      g.clear();
      h.clear();
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/d/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */