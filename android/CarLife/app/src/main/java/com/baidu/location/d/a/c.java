package com.baidu.location.d.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.Timer;
import java.util.TimerTask;

public class c
{
  private static boolean A = false;
  private static a e = null;
  private static int z = 0;
  Timer a;
  public SensorEventListener b = new SensorEventListener()
  {
    public void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt) {}
    
    public void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
    {
      switch (paramAnonymousSensorEvent.sensor.getType())
      {
      }
      double d;
      do
      {
        do
        {
          do
          {
            return;
            if (c.this.c < 65536)
            {
              c localc = c.this;
              localc.c += 1;
            }
            paramAnonymousSensorEvent = (float[])paramAnonymousSensorEvent.values.clone();
            c.a(c.this, (float[])paramAnonymousSensorEvent.clone());
            paramAnonymousSensorEvent = c.a(c.this, paramAnonymousSensorEvent[0], paramAnonymousSensorEvent[1], paramAnonymousSensorEvent[2]);
          } while (c.a(c.this) < 20);
          float f1 = paramAnonymousSensorEvent[0];
          float f2 = paramAnonymousSensorEvent[0];
          float f3 = paramAnonymousSensorEvent[1];
          float f4 = paramAnonymousSensorEvent[1];
          float f5 = paramAnonymousSensorEvent[2];
          d = paramAnonymousSensorEvent[2] * f5 + (f1 * f2 + f3 * f4);
          if (c.b(c.this) != 0) {
            break;
          }
        } while (d <= 4.0D);
        c.a(c.this, 1);
        return;
      } while (d >= 0.009999999776482582D);
      c.a(c.this, 0);
    }
  };
  int c = 0;
  long d = 0L;
  private SensorManager f;
  private boolean g;
  private int h;
  private Sensor i;
  private final long j = 30L;
  private volatile int k = 0;
  private int l = 1;
  private float[] m = new float[3];
  private float[] n = { 0.0F, 0.0F, 0.0F };
  private int o = 31;
  private double[] p = new double[this.o];
  private int q = 0;
  private int r;
  private double[] s = new double[6];
  private int t = 0;
  private double u = 1.6D;
  private int v = 440;
  private long w = 0L;
  private int x = 0;
  private int y = 480;
  
  private c(Context paramContext, int paramInt, a parama)
  {
    e = parama;
    try
    {
      this.f = ((SensorManager)paramContext.getSystemService("sensor"));
      this.h = paramInt;
      this.i = this.f.getDefaultSensor(1);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public c(Context paramContext, a parama)
  {
    this(paramContext, 0, parama);
  }
  
  private double a(double[] paramArrayOfDouble)
  {
    int i2 = 0;
    double d2 = 0.0D;
    int i3 = paramArrayOfDouble.length;
    int i1 = 0;
    double d1 = 0.0D;
    while (i1 < i3)
    {
      d1 += paramArrayOfDouble[i1];
      i1 += 1;
    }
    double d3 = d1 / i3;
    d1 = d2;
    i1 = i2;
    while (i1 < i3)
    {
      d1 += (paramArrayOfDouble[i1] - d3) * (paramArrayOfDouble[i1] - d3);
      i1 += 1;
    }
    return d1 / (i3 - 1);
  }
  
  private void a(double paramDouble)
  {
    this.s[(this.t % 6)] = paramDouble;
    this.t += 1;
    this.t %= 6;
  }
  
  private float[] a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.m[0] = (this.m[0] * 0.8F + 0.19999999F * paramFloat1);
    this.m[1] = (this.m[1] * 0.8F + 0.19999999F * paramFloat2);
    this.m[2] = (this.m[2] * 0.8F + 0.19999999F * paramFloat3);
    return new float[] { paramFloat1 - this.m[0], paramFloat2 - this.m[1], paramFloat3 - this.m[2] };
  }
  
  private void b(int paramInt)
  {
    try
    {
      this.l |= paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private boolean b(double paramDouble)
  {
    int i1 = 1;
    while (i1 <= 5)
    {
      if (this.s[((this.t - 1 - i1 + 6 + 6) % 6)] - this.s[((this.t - 1 + 6) % 6)] > paramDouble) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private void e()
  {
    int i1 = 0;
    z += 1;
    if ((A) && (z >= this.y)) {
      e.a(999);
    }
    do
    {
      return;
      if ((!A) && (z == 120))
      {
        e.a(888);
        return;
      }
    } while (this.r < 20);
    long l1 = System.currentTimeMillis();
    float[] arrayOfFloat = new float[3];
    System.arraycopy(this.n, 0, arrayOfFloat, 0, 3);
    float f1 = arrayOfFloat[0];
    float f2 = arrayOfFloat[0];
    float f3 = arrayOfFloat[1];
    float f4 = arrayOfFloat[1];
    float f5 = arrayOfFloat[2];
    double d1 = Math.sqrt(arrayOfFloat[2] * f5 + (f1 * f2 + f3 * f4));
    this.p[this.q] = d1;
    a(d1);
    this.q += 1;
    if (this.q == this.o)
    {
      this.q = 0;
      d1 = a(this.p);
      if ((this.k != 0) || (d1 >= 0.3D)) {
        break label333;
      }
      b(0);
    }
    for (this.k = 0;; this.k = 1)
    {
      e.a(this.k);
      i1 = 1;
      if ((l1 - this.w <= this.v) || (!b(this.u)) || (z >= 120)) {
        break;
      }
      if (i1 == 0)
      {
        b(1);
        this.k = 1;
        e.a(this.k);
      }
      this.x += 1;
      this.w = l1;
      e.a(this.x * 1000);
      return;
      label333:
      b(1);
    }
  }
  
  public void a()
  {
    a(this.y);
  }
  
  public void a(int paramInt)
  {
    this.y = paramInt;
    if (!this.g)
    {
      this.c = 0;
      this.d = System.currentTimeMillis();
      z = 0;
      A = false;
      if (this.i == null) {}
    }
    try
    {
      this.f.registerListener(this.b, this.i, this.h);
      this.a = new Timer("UpdateData", false);
      TimerTask local2 = new TimerTask()
      {
        public void run()
        {
          c.c(c.this);
        }
      };
      this.a.schedule(local2, 500L, 30L);
      this.g = true;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void b()
  {
    if (this.g == true) {}
    try
    {
      this.f.unregisterListener(this.b);
      this.a.cancel();
      this.a.purge();
      this.a = null;
      this.g = false;
      z = 0;
      A = false;
      if (this.c < 14) {
        a.a = false;
      }
      this.c = 0;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public boolean c()
  {
    return this.g;
  }
  
  public void d()
  {
    A = true;
    z = 0;
  }
  
  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/d/a/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */