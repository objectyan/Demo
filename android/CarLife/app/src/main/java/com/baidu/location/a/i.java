package com.baidu.location.a;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.baidu.location.f;
import com.baidu.location.g.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class i
  implements SensorEventListener
{
  private static i d;
  private float[] a;
  private float[] b;
  private SensorManager c;
  private float e;
  private double f = Double.MIN_VALUE;
  private boolean g = false;
  private boolean h = false;
  private boolean i = false;
  private boolean j = false;
  private float k = 0.0F;
  private long l = 0L;
  private Map<Integer, List<Float>> m = new ConcurrentHashMap();
  private boolean n = false;
  private long o = 0L;
  private boolean p = false;
  
  private i()
  {
    try
    {
      if (this.c == null) {
        this.c = ((SensorManager)f.getServiceContext().getSystemService("sensor"));
      }
      if (this.c.getDefaultSensor(6) != null) {
        this.j = true;
      }
      return;
    }
    catch (Exception localException)
    {
      this.j = false;
    }
  }
  
  public static i a()
  {
    try
    {
      if (d == null) {
        d = new i();
      }
      i locali = d;
      return locali;
    }
    finally {}
  }
  
  private void l()
  {
    if (this.c != null)
    {
      Sensor localSensor = this.c.getDefaultSensor(6);
      if ((localSensor != null) && (!this.p))
      {
        this.c.registerListener(d, localSensor, 3);
        this.p = true;
      }
      if (!this.h) {
        a.a().postDelayed(new Runnable()
        {
          public void run()
          {
            if ((i.a(i.this) != null) && (!i.b(i.this)))
            {
              Sensor localSensor = i.a(i.this).getDefaultSensor(6);
              i.a(i.this).unregisterListener(i.k(), localSensor);
              i.a(i.this, false);
            }
          }
        }, 2000L);
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	com/baidu/location/a/i:n	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 45	com/baidu/location/a/i:g	Z
    //   18: ifne +10 -> 28
    //   21: aload_0
    //   22: getfield 49	com/baidu/location/a/i:i	Z
    //   25: ifeq -14 -> 11
    //   28: aload_0
    //   29: getfield 68	com/baidu/location/a/i:c	Landroid/hardware/SensorManager;
    //   32: ifnonnull +18 -> 50
    //   35: aload_0
    //   36: invokestatic 74	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   39: ldc 76
    //   41: invokevirtual 82	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   44: checkcast 84	android/hardware/SensorManager
    //   47: putfield 68	com/baidu/location/a/i:c	Landroid/hardware/SensorManager;
    //   50: aload_0
    //   51: getfield 68	com/baidu/location/a/i:c	Landroid/hardware/SensorManager;
    //   54: ifnull +72 -> 126
    //   57: aload_0
    //   58: getfield 68	com/baidu/location/a/i:c	Landroid/hardware/SensorManager;
    //   61: bipush 11
    //   63: invokevirtual 88	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   66: astore_2
    //   67: aload_2
    //   68: ifnull +21 -> 89
    //   71: aload_0
    //   72: getfield 45	com/baidu/location/a/i:g	Z
    //   75: ifeq +14 -> 89
    //   78: aload_0
    //   79: getfield 68	com/baidu/location/a/i:c	Landroid/hardware/SensorManager;
    //   82: aload_0
    //   83: aload_2
    //   84: iconst_3
    //   85: invokevirtual 100	android/hardware/SensorManager:registerListener	(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z
    //   88: pop
    //   89: aload_0
    //   90: getfield 68	com/baidu/location/a/i:c	Landroid/hardware/SensorManager;
    //   93: bipush 6
    //   95: invokevirtual 88	android/hardware/SensorManager:getDefaultSensor	(I)Landroid/hardware/Sensor;
    //   98: astore_2
    //   99: aload_2
    //   100: ifnull +26 -> 126
    //   103: aload_0
    //   104: getfield 49	com/baidu/location/a/i:i	Z
    //   107: ifeq +19 -> 126
    //   110: aload_0
    //   111: getfield 68	com/baidu/location/a/i:c	Landroid/hardware/SensorManager;
    //   114: aload_0
    //   115: aload_2
    //   116: iconst_3
    //   117: invokevirtual 100	android/hardware/SensorManager:registerListener	(Landroid/hardware/SensorEventListener;Landroid/hardware/Sensor;I)Z
    //   120: pop
    //   121: aload_0
    //   122: iconst_1
    //   123: putfield 66	com/baidu/location/a/i:p	Z
    //   126: aload_0
    //   127: iconst_1
    //   128: putfield 62	com/baidu/location/a/i:n	Z
    //   131: goto -120 -> 11
    //   134: astore_2
    //   135: aload_0
    //   136: monitorexit
    //   137: aload_2
    //   138: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	139	0	this	i
    //   6	2	1	bool	boolean
    //   66	50	2	localSensor	Sensor
    //   134	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	134	finally
    //   14	28	134	finally
    //   28	50	134	finally
    //   50	67	134	finally
    //   71	89	134	finally
    //   89	99	134	finally
    //   103	126	134	finally
    //   126	131	134	finally
  }
  
  public void b(boolean paramBoolean) {}
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	com/baidu/location/a/i:n	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 68	com/baidu/location/a/i:c	Landroid/hardware/SensorManager;
    //   18: ifnull +21 -> 39
    //   21: aload_0
    //   22: getfield 68	com/baidu/location/a/i:c	Landroid/hardware/SensorManager;
    //   25: aload_0
    //   26: invokevirtual 121	android/hardware/SensorManager:unregisterListener	(Landroid/hardware/SensorEventListener;)V
    //   29: aload_0
    //   30: aconst_null
    //   31: putfield 68	com/baidu/location/a/i:c	Landroid/hardware/SensorManager;
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield 66	com/baidu/location/a/i:p	Z
    //   39: aload_0
    //   40: iconst_0
    //   41: putfield 62	com/baidu/location/a/i:n	Z
    //   44: aload_0
    //   45: fconst_0
    //   46: putfield 53	com/baidu/location/a/i:k	F
    //   49: aload_0
    //   50: getfield 60	com/baidu/location/a/i:m	Ljava/util/Map;
    //   53: invokeinterface 126 1 0
    //   58: goto -47 -> 11
    //   61: astore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_2
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	i
    //   6	2	1	bool	boolean
    //   61	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	61	finally
    //   14	39	61	finally
    //   39	58	61	finally
  }
  
  public void c(boolean paramBoolean)
  {
    this.h = paramBoolean;
    if (!paramBoolean)
    {
      if (this.c != null)
      {
        Sensor localSensor = this.c.getDefaultSensor(6);
        this.c.unregisterListener(d, localSensor);
        this.p = false;
      }
      this.m.clear();
    }
  }
  
  public void d()
  {
    if ((!this.i) && (this.j) && ((this.h) || (System.currentTimeMillis() - this.o > 60000L)))
    {
      this.o = System.currentTimeMillis();
      l();
    }
  }
  
  public float e()
  {
    float f2 = 0.0F;
    float f1 = f2;
    if (this.j)
    {
      f1 = f2;
      if (this.l > 0L)
      {
        if (!this.h) {
          break label36;
        }
        f1 = f();
      }
    }
    label36:
    do
    {
      return f1;
      f1 = f2;
    } while (this.k <= 0.0F);
    return this.k;
  }
  
  /* Error */
  public float f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 51	com/baidu/location/a/i:j	Z
    //   6: ifeq +197 -> 203
    //   9: aload_0
    //   10: getfield 55	com/baidu/location/a/i:l	J
    //   13: lconst_0
    //   14: lcmp
    //   15: ifle +188 -> 203
    //   18: aload_0
    //   19: getfield 60	com/baidu/location/a/i:m	Ljava/util/Map;
    //   22: invokeinterface 146 1 0
    //   27: ifle +176 -> 203
    //   30: iconst_0
    //   31: istore_2
    //   32: aload_0
    //   33: getfield 60	com/baidu/location/a/i:m	Ljava/util/Map;
    //   36: invokeinterface 150 1 0
    //   41: invokeinterface 156 1 0
    //   46: astore_3
    //   47: aload_3
    //   48: invokeinterface 162 1 0
    //   53: ifeq +32 -> 85
    //   56: aload_3
    //   57: invokeinterface 166 1 0
    //   62: checkcast 168	java/lang/Integer
    //   65: astore 4
    //   67: aload 4
    //   69: invokevirtual 171	java/lang/Integer:intValue	()I
    //   72: iload_2
    //   73: if_icmple +135 -> 208
    //   76: aload 4
    //   78: invokevirtual 171	java/lang/Integer:intValue	()I
    //   81: istore_2
    //   82: goto +126 -> 208
    //   85: aload_0
    //   86: getfield 60	com/baidu/location/a/i:m	Ljava/util/Map;
    //   89: iload_2
    //   90: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   93: invokeinterface 179 2 0
    //   98: ifnull +105 -> 203
    //   101: aload_0
    //   102: getfield 60	com/baidu/location/a/i:m	Ljava/util/Map;
    //   105: iload_2
    //   106: invokestatic 175	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   109: invokeinterface 179 2 0
    //   114: checkcast 181	java/util/List
    //   117: astore_3
    //   118: aload_3
    //   119: invokeinterface 182 1 0
    //   124: astore 4
    //   126: fconst_0
    //   127: fstore_1
    //   128: aload 4
    //   130: invokeinterface 162 1 0
    //   135: ifeq +22 -> 157
    //   138: aload 4
    //   140: invokeinterface 166 1 0
    //   145: checkcast 184	java/lang/Float
    //   148: invokevirtual 187	java/lang/Float:floatValue	()F
    //   151: fload_1
    //   152: fadd
    //   153: fstore_1
    //   154: goto -26 -> 128
    //   157: aload_3
    //   158: invokeinterface 188 1 0
    //   163: istore_2
    //   164: fload_1
    //   165: iload_2
    //   166: i2f
    //   167: fdiv
    //   168: fstore_1
    //   169: aload_0
    //   170: getfield 60	com/baidu/location/a/i:m	Ljava/util/Map;
    //   173: invokeinterface 126 1 0
    //   178: aload_0
    //   179: monitorexit
    //   180: fload_1
    //   181: freturn
    //   182: astore_3
    //   183: fconst_0
    //   184: fstore_1
    //   185: aload_0
    //   186: monitorexit
    //   187: aload_3
    //   188: athrow
    //   189: astore_3
    //   190: fload_1
    //   191: freturn
    //   192: astore_3
    //   193: fconst_0
    //   194: freturn
    //   195: astore_3
    //   196: goto -11 -> 185
    //   199: astore_3
    //   200: goto -15 -> 185
    //   203: fconst_0
    //   204: fstore_1
    //   205: goto -36 -> 169
    //   208: goto -161 -> 47
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	i
    //   127	78	1	f1	float
    //   31	135	2	i1	int
    //   46	112	3	localObject1	Object
    //   182	6	3	localObject2	Object
    //   189	1	3	localException1	Exception
    //   192	1	3	localException2	Exception
    //   195	1	3	localObject3	Object
    //   199	1	3	localObject4	Object
    //   65	74	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   2	30	182	finally
    //   32	47	182	finally
    //   47	82	182	finally
    //   85	126	182	finally
    //   128	154	182	finally
    //   157	164	182	finally
    //   187	189	189	java/lang/Exception
    //   0	2	192	java/lang/Exception
    //   169	180	195	finally
    //   185	187	199	finally
  }
  
  public boolean g()
  {
    return this.g;
  }
  
  public boolean h()
  {
    return this.i;
  }
  
  public float i()
  {
    return this.e;
  }
  
  public double j()
  {
    return this.f;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    switch (paramSensorEvent.sensor.getType())
    {
    default: 
    case 11: 
      do
      {
        return;
        this.a = ((float[])paramSensorEvent.values.clone());
      } while (this.a == null);
      paramSensorEvent = new float[9];
      for (;;)
      {
        try
        {
          SensorManager.getRotationMatrixFromVector(paramSensorEvent, this.a);
          float[] arrayOfFloat = new float[3];
          SensorManager.getOrientation(paramSensorEvent, arrayOfFloat);
          this.e = ((float)Math.toDegrees(arrayOfFloat[0]));
          if (this.e >= 0.0F)
          {
            d1 = this.e;
            this.e = ((float)Math.floor(d1));
            return;
          }
        }
        catch (Exception paramSensorEvent)
        {
          this.e = 0.0F;
          return;
        }
        float f1 = this.e;
        double d1 = f1 + 360.0F;
      }
    }
    try
    {
      this.b = ((float[])paramSensorEvent.values.clone());
      this.k = this.b[0];
      this.l = System.currentTimeMillis();
      if (this.h)
      {
        int i1 = (int)(this.l / 1000L);
        if (this.m.get(Integer.valueOf(i1)) == null) {
          this.m.put(Integer.valueOf(i1), new ArrayList());
        }
        ((List)this.m.get(Integer.valueOf(i1))).add(Float.valueOf(this.k));
      }
      this.f = SensorManager.getAltitude(1013.25F, this.b[0]);
      return;
    }
    catch (Exception paramSensorEvent) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/a/i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */