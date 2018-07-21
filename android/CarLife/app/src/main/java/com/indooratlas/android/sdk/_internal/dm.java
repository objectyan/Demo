package com.indooratlas.android.sdk._internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class dm
  implements db
{
  private SensorManager b;
  private final HashMap<cy, a> c = new HashMap();
  
  static
  {
    if (!dm.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public dm(Context paramContext)
  {
    this((SensorManager)paramContext.getSystemService("sensor"));
  }
  
  private dm(SensorManager paramSensorManager)
  {
    this.b = paramSensorManager;
  }
  
  public static cx a(SensorEvent paramSensorEvent)
  {
    cx localcx = new cx();
    localcx.d = SystemClock.elapsedRealtime();
    localcx.b = paramSensorEvent.timestamp;
    localcx.a = dn.a(paramSensorEvent.sensor);
    do localdo = new do();
    localdo.a = paramSensorEvent.accuracy;
    localdo.b = paramSensorEvent.sensor.getType();
    localdo.c = paramSensorEvent.timestamp;
    localdo.d = new float[paramSensorEvent.values.length];
    System.arraycopy(paramSensorEvent.values, 0, localdo.d, 0, paramSensorEvent.values.length);
    localcx.c = localdo;
    return localcx;
  }
  
  public static int b(int paramInt)
  {
    int i = 14;
    switch (paramInt)
    {
    case 0: 
    case 7: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    default: 
      if (Build.VERSION.SDK_INT >= 14) {}
      switch (paramInt)
      {
      default: 
        if (Build.VERSION.SDK_INT >= 18) {}
        switch (paramInt)
        {
        default: 
          if (Build.VERSION.SDK_INT >= 19) {}
          switch (paramInt)
          {
          default: 
            if (Build.VERSION.SDK_INT >= 20) {}
            switch (paramInt)
            {
            default: 
              i = 0;
            }
            break;
          }
        case 14: 
          return i;
        }
        break;
      }
    case 1: 
      return 1;
    case -1: 
      return -1;
    case 4: 
      return 4;
    case 2: 
      return 2;
    case 9: 
      return 9;
    case 5: 
      return 5;
    case 3: 
      return 3;
    case 8: 
      return 8;
    case 11: 
      return 11;
    case 10: 
      return 10;
    case 6: 
      return 6;
    case 22: 
      return 22;
    case 23: 
      return 23;
    case 24: 
      return 24;
    case 25: 
      return 25;
    }
    return 26;
    return 13;
    return 12;
    return 15;
    return 16;
    return 17;
    return 18;
    return 19;
    return 20;
    return 21;
  }
  
  private a b(cy paramcy, cw paramcw)
  {
    a locala2 = (a)this.c.get(paramcy);
    if (locala2 != null)
    {
      Iterator localIterator = locala2.b.iterator();
      do
      {
        locala1 = locala2;
        if (!localIterator.hasNext()) {
          break;
        }
      } while (!paramcw.equals((cw)localIterator.next()));
      Log.i(cz.a, "already registered listener: " + paramcy + " for sensor: " + paramcw);
      return null;
    }
    a locala1 = new a();
    locala1.a = new b(paramcy, paramcw);
    this.c.put(paramcy, locala1);
    locala1.b.add(paramcw);
    return locala1;
  }
  
  @TargetApi(14)
  private static int c(int paramInt)
  {
    int i = 14;
    switch (paramInt)
    {
    case 0: 
    case 7: 
    default: 
      paramInt = 0;
    case 1: 
    case -1: 
    case 4: 
    case 3: 
    case 2: 
    case 10: 
    case 14: 
      do
      {
        return paramInt;
        return 1;
        return -1;
        return 4;
        return 3;
        return 2;
        return 10;
        paramInt = i;
      } while (Build.VERSION.SDK_INT >= 18);
      return 0;
    case 13: 
      if (Build.VERSION.SDK_INT >= 14) {
        return 13;
      }
      return 0;
    case 15: 
      if (Build.VERSION.SDK_INT >= 18) {
        return 15;
      }
      return 0;
    case 16: 
      if (Build.VERSION.SDK_INT >= 18) {
        return 16;
      }
      return 0;
    case 9: 
      return 9;
    case 21: 
      if (Build.VERSION.SDK_INT >= 20) {
        return 21;
      }
      return 0;
    case 5: 
      return 5;
    case 8: 
      return 8;
    case 6: 
      return 6;
    case 11: 
      return 11;
    case 12: 
      if (Build.VERSION.SDK_INT >= 14) {
        return 12;
      }
      return 0;
    case 17: 
      if (Build.VERSION.SDK_INT >= 18) {
        return 17;
      }
      return 0;
    case 18: 
      if (Build.VERSION.SDK_INT >= 19) {
        return 18;
      }
      return 0;
    case 19: 
      if (Build.VERSION.SDK_INT >= 19) {
        return 19;
      }
      return 0;
    case 20: 
      if (Build.VERSION.SDK_INT >= 19) {
        return 20;
      }
      return 0;
    case 22: 
      return 22;
    case 23: 
      return 23;
    case 24: 
      return 24;
    case 25: 
      return 25;
    }
    return 26;
  }
  
  public final cw a(int paramInt)
  {
    Sensor localSensor = this.b.getDefaultSensor(c(paramInt));
    if (localSensor != null) {
      return dn.a(localSensor);
    }
    return null;
  }
  
  public final List<cw> a()
  {
    Object localObject = this.b.getSensorList(c(-1));
    ArrayList localArrayList = new ArrayList(((List)localObject).size());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Sensor localSensor = (Sensor)((Iterator)localObject).next();
      if (b(localSensor.getType()) != 0) {
        localArrayList.add(new dn(localSensor));
      }
    }
    return localArrayList;
  }
  
  public final List<cx> a(cw paramcw)
  {
    return null;
  }
  
  public final void a(cy paramcy)
  {
    synchronized (this.c)
    {
      paramcy = (a)this.c.remove(paramcy);
      if (paramcy != null)
      {
        String str = cz.a;
        this.b.unregisterListener(paramcy.a);
        return;
      }
      paramcy = cz.a;
    }
  }
  
  public final void a(cy paramcy, cw paramcw)
  {
    a locala;
    synchronized (this.c)
    {
      locala = (a)this.c.get(paramcy);
      if (locala == null) {
        break label136;
      }
      Iterator localIterator = locala.b.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (cw)localIterator.next();
        if (paramcw.a() == ((cw)localObject).a())
        {
          localObject = ((dn)paramcw).a;
          String str = cz.a;
          this.b.unregisterListener(locala.a, (Sensor)localObject);
          localIterator.remove();
        }
      }
    }
    if (locala.b.isEmpty()) {
      this.c.remove(paramcy);
    }
    label136:
  }
  
  public final void a(cy paramcy, cw paramcw, da paramda)
  {
    if ((!a) && (paramcy == null)) {
      throw new AssertionError("listener must be non null");
    }
    if ((!a) && (paramcw == null)) {
      throw new AssertionError("sensor must be non null");
    }
    synchronized (this.c)
    {
      paramcy = b(paramcy, paramcw);
      int i;
      if (paramcy != null)
      {
        paramcw = ((dn)paramcw).a;
        i = paramda.c;
        if (paramda.a != null)
        {
          String str = cz.a;
          paramcw.getType();
          this.b.registerListener(paramcy.a, paramcw, i, paramda.a);
        }
      }
      else
      {
        return;
      }
      paramda = cz.a;
      paramcw.getType();
      this.b.registerListener(paramcy.a, paramcw, i);
    }
  }
  
  static final class a
  {
    SensorEventListener a;
    ArrayList<cw> b = new ArrayList();
    
    public final String toString()
    {
      return "ListenerEntry{listener=" + this.a + ", sensors=" + this.b + '}';
    }
  }
  
  static final class b
    implements SensorEventListener
  {
    cy a;
    cw b;
    
    b(cy paramcy, cw paramcw)
    {
      this.a = paramcy;
      this.b = paramcw;
    }
    
    public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
    
    public final void onSensorChanged(SensorEvent paramSensorEvent)
    {
      if (paramSensorEvent == null)
      {
        ee.a(cz.a, "received null hardware sensor event", new Object[0]);
        return;
      }
      this.a.a(dm.a(paramSensorEvent));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/dm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */