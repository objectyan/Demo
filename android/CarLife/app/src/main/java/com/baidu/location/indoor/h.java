package com.baidu.location.indoor;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.Timer;
import java.util.TimerTask;

public class h
{
  private double A = 0.0D;
  private double B = 0.0D;
  private double C = 100.0D;
  private double D = 0.5D;
  private double E = this.D;
  private double F = 0.85D;
  private double G = 0.42D;
  private int H = -1;
  private float I = 0.0F;
  private int J = 20;
  private int K = 0;
  private double[] L = new double[this.J];
  private boolean M = false;
  Timer a;
  public SensorEventListener b = new SensorEventListener()
  {
    public void onAccuracyChanged(Sensor paramAnonymousSensor, int paramAnonymousInt) {}
    
    public void onSensorChanged(SensorEvent paramAnonymousSensorEvent)
    {
      switch (paramAnonymousSensorEvent.sensor.getType())
      {
      }
      do
      {
        double d;
        do
        {
          do
          {
            do
            {
              return;
              paramAnonymousSensorEvent = (float[])paramAnonymousSensorEvent.values.clone();
              h.a(h.this, (float[])paramAnonymousSensorEvent.clone());
              paramAnonymousSensorEvent = h.a(h.this, paramAnonymousSensorEvent[0], paramAnonymousSensorEvent[1], paramAnonymousSensorEvent[2]);
            } while (h.a(h.this) < 20);
            float f1 = paramAnonymousSensorEvent[0];
            float f2 = paramAnonymousSensorEvent[0];
            float f3 = paramAnonymousSensorEvent[1];
            float f4 = paramAnonymousSensorEvent[1];
            float f5 = paramAnonymousSensorEvent[2];
            d = paramAnonymousSensorEvent[2] * f5 + (f1 * f2 + f3 * f4);
            if (h.b(h.this) != 0) {
              break;
            }
          } while (d <= 4.0D);
          h.a(h.this, 1);
          return;
        } while (d >= 0.009999999776482582D);
        h.a(h.this, 0);
        return;
        paramAnonymousSensorEvent = (float[])paramAnonymousSensorEvent.values.clone();
        h.c(h.this)[h.d(h.this)] = paramAnonymousSensorEvent[0];
        h.e(h.this);
        if (h.d(h.this) == h.f(h.this)) {
          h.b(h.this, 0);
        }
      } while (h.g(h.this) < 20);
      h.a(h.this, h.h(h.this));
      if (!h.i(h.this)) {
        h.k(h.this).unregisterListener(h.this.b, h.j(h.this));
      }
      h.l(h.this)[0] = h.a(h.this, h.l(h.this)[0], paramAnonymousSensorEvent[0], 0.7D);
      h.l(h.this)[1] = paramAnonymousSensorEvent[1];
      h.l(h.this)[2] = paramAnonymousSensorEvent[2];
    }
  };
  private a c;
  private SensorManager d;
  private boolean e;
  private int f;
  private Sensor g;
  private Sensor h;
  private final long i = 30L;
  private volatile int j = 1;
  private int k = 1;
  private float[] l = new float[3];
  private float[] m = { 0.0F, 0.0F, 0.0F };
  private double[] n = { 0.0D, 0.0D, 0.0D };
  private int o = 31;
  private double[] p = new double[this.o];
  private int q = 0;
  private int r;
  private int s;
  private double[] t = new double[6];
  private int u = 0;
  private double v = 1.6D;
  private int w = 440;
  private long x = 0L;
  private int y = 0;
  private int z = 0;
  
  private h(Context paramContext, int paramInt)
  {
    try
    {
      this.d = ((SensorManager)paramContext.getSystemService("sensor"));
      this.f = paramInt;
      this.g = this.d.getDefaultSensor(1);
      this.h = this.d.getDefaultSensor(3);
      return;
    }
    catch (Exception paramContext) {}
  }
  
  public h(Context paramContext, a parama)
  {
    this(paramContext, 1);
    this.c = parama;
  }
  
  private double a(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    double d1 = paramDouble2 - paramDouble1;
    if (d1 < -180.0D) {
      paramDouble2 = d1 + 360.0D;
    }
    for (;;)
    {
      return paramDouble2 * paramDouble3 + paramDouble1;
      paramDouble2 = d1;
      if (d1 > 180.0D) {
        paramDouble2 = d1 - 360.0D;
      }
    }
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
    this.t[(this.u % 6)] = paramDouble;
    this.u += 1;
    this.u %= 6;
  }
  
  private void a(int paramInt)
  {
    try
    {
      this.k |= paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private float[] a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.l[0] = (this.l[0] * 0.8F + 0.19999999F * paramFloat1);
    this.l[1] = (this.l[1] * 0.8F + 0.19999999F * paramFloat2);
    this.l[2] = (this.l[2] * 0.8F + 0.19999999F * paramFloat3);
    return new float[] { paramFloat1 - this.l[0], paramFloat2 - this.l[1], paramFloat3 - this.l[2] };
  }
  
  private boolean b(double paramDouble)
  {
    int i1 = 1;
    while (i1 <= 5)
    {
      if (this.t[((this.u - 1 - i1 + 6 + 6) % 6)] - this.t[((this.u - 1 + 6) % 6)] > paramDouble) {
        return true;
      }
      i1 += 1;
    }
    return false;
  }
  
  private boolean f()
  {
    boolean bool2 = false;
    int i1 = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i1 < this.J)
      {
        if (this.L[i1] > 1.0E-7D) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  private void g()
  {
    if (this.r < 20) {
      return;
    }
    long l1 = System.currentTimeMillis();
    float[] arrayOfFloat = new float[3];
    System.arraycopy(this.m, 0, arrayOfFloat, 0, 3);
    double[] arrayOfDouble = new double[3];
    System.arraycopy(this.n, 0, arrayOfDouble, 0, 3);
    float f1 = arrayOfFloat[0];
    float f2 = arrayOfFloat[0];
    float f3 = arrayOfFloat[1];
    float f4 = arrayOfFloat[1];
    float f5 = arrayOfFloat[2];
    double d3 = Math.sqrt(arrayOfFloat[2] * f5 + (f1 * f2 + f3 * f4));
    this.p[this.q] = d3;
    a(d3);
    this.z += 1;
    label147:
    double d1;
    if (d3 > this.B)
    {
      this.B = d3;
      this.q += 1;
      if (this.q == this.o)
      {
        this.q = 0;
        d1 = a(this.p);
        if ((this.j != 0) || (d1 >= 0.3D)) {
          break label411;
        }
        a(0);
        this.j = 0;
      }
      label207:
      if ((l1 - this.x <= this.w) || (!b(this.v))) {
        break label422;
      }
      this.y += 1;
      this.x = l1;
      d1 = arrayOfDouble[0];
      if ((this.z >= 40) || (this.z <= 0)) {
        break label447;
      }
      this.E = (Math.sqrt(Math.sqrt(this.B - this.C)) * this.G);
      if (this.E <= this.F) {
        break label424;
      }
      this.E = this.F;
    }
    for (;;)
    {
      double d2 = d1 + this.I;
      d1 = d2;
      if (d2 > 360.0D) {
        d1 = d2 - 360.0D;
      }
      d2 = d1;
      if (d1 < 0.0D) {
        d2 = d1 + 360.0D;
      }
      this.z = 1;
      this.B = d3;
      this.C = d3;
      if (!this.M) {
        break;
      }
      this.c.a(this.E, d2);
      return;
      if (d3 >= this.C) {
        break label147;
      }
      this.C = d3;
      break label147;
      label411:
      a(1);
      this.j = 1;
      break label207;
      label422:
      break;
      label424:
      if (this.E < this.D)
      {
        this.E = this.D;
        continue;
        label447:
        this.E = this.D;
      }
    }
  }
  
  public void a()
  {
    if ((this.e) || (this.g != null)) {}
    try
    {
      this.d.registerListener(this.b, this.g, this.f);
      this.a = new Timer("UpdateData", false);
      TimerTask local2 = new TimerTask()
      {
        public void run()
        {
          try
          {
            h.m(h.this);
            return;
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      };
      this.a.schedule(local2, 500L, 30L);
      this.e = true;
      if (this.h != null) {}
      try
      {
        this.d.registerListener(this.b, this.h, this.f);
        return;
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  public void b()
  {
    if (this.e == true) {}
    try
    {
      this.d.unregisterListener(this.b);
      this.a.cancel();
      this.a.purge();
      this.a = null;
      this.e = false;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  /* Error */
  public int c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 181	com/baidu/location/indoor/h:r	I
    //   6: istore_1
    //   7: iload_1
    //   8: bipush 20
    //   10: if_icmpge +9 -> 19
    //   13: iconst_1
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 72	com/baidu/location/indoor/h:k	I
    //   23: istore_1
    //   24: goto -9 -> 15
    //   27: astore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_2
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	h
    //   6	18	1	i1	int
    //   27	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	27	finally
    //   19	24	27	finally
  }
  
  /* Error */
  public int d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 181	com/baidu/location/indoor/h:r	I
    //   6: istore_1
    //   7: iload_1
    //   8: bipush 20
    //   10: if_icmpge +9 -> 19
    //   13: iconst_m1
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: getfield 92	com/baidu/location/indoor/h:y	I
    //   23: istore_1
    //   24: goto -9 -> 15
    //   27: astore_2
    //   28: aload_0
    //   29: monitorexit
    //   30: aload_2
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	32	0	this	h
    //   6	18	1	i1	int
    //   27	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	27	finally
    //   19	24	27	finally
  }
  
  public void e()
  {
    try
    {
      this.k = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(double paramDouble1, double paramDouble2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/indoor/h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */