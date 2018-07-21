package com.indooratlas.android.sdk._internal;

import android.util.Pair;
import com.indooratlas.android.sdk.IALocation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class cc
{
  public eo<String, a> a = new eo();
  public IALocation b = null;
  private ArrayList<aw> c = new ArrayList();
  private long d = -1L;
  private HashMap<aw, Long> e = new HashMap();
  
  private ArrayList<Pair<Integer, aw>> a(long paramLong, double paramDouble1, double paramDouble2, Integer paramInteger)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new HashMap();
    ((HashMap)localObject1).putAll(this.e);
    if (this.d >= 0L) {}
    for (long l = paramLong - this.d;; l = 0L)
    {
      this.d = paramLong;
      this.e.clear();
      Object localObject2 = this.a;
      paramInteger = new ep(paramDouble1, paramDouble2, paramInteger);
      paramInteger = ((eo)localObject2).a.a(paramInteger).iterator();
      while (paramInteger.hasNext())
      {
        localObject2 = (a)paramInteger.next();
        aw localaw = ((a)localObject2).b;
        if ((localaw.e()) && (paramLong - ((a)localObject2).a > localaw.f().longValue())) {
          this.a.a.a(localaw.a());
        } else if (!((HashMap)localObject1).containsKey(localaw)) {
          this.e.put(localaw, Long.valueOf(0L));
        } else {
          this.e.put(localaw, Long.valueOf(((Long)((HashMap)localObject1).get(localaw)).longValue() + l));
        }
      }
      paramInteger = this.e.keySet().iterator();
      while (paramInteger.hasNext())
      {
        localObject2 = (aw)paramInteger.next();
        paramDouble1 = ((Long)this.e.get(localObject2)).longValue();
        if ((paramDouble1 == 0.0D) && ((((aw)localObject2).b() & 0x1) > 0))
        {
          localArrayList.add(new Pair(Integer.valueOf(1), localObject2));
        }
        else if ((((aw)localObject2).d()) && (paramDouble1 > ((aw)localObject2).c().longValue()) && (!this.c.contains(localObject2)) && ((((aw)localObject2).b() & 0x100) > 0))
        {
          localArrayList.add(new Pair(Integer.valueOf(256), localObject2));
          this.c.add(localObject2);
        }
      }
      paramInteger = ((HashMap)localObject1).keySet().iterator();
      while (paramInteger.hasNext())
      {
        localObject1 = (aw)paramInteger.next();
        if (!this.e.containsKey(localObject1))
        {
          if ((((aw)localObject1).b() & 0x10) > 0) {
            localArrayList.add(new Pair(Integer.valueOf(16), localObject1));
          }
          if (this.c.contains(localObject1)) {
            this.c.remove(localObject1);
          }
        }
      }
      return localArrayList;
    }
  }
  
  public final ArrayList<ax> a(long paramLong, IALocation paramIALocation)
  {
    this.b = paramIALocation;
    ArrayList localArrayList1 = new ArrayList();
    double d1 = paramIALocation.getLatitude();
    double d2 = paramIALocation.getLongitude();
    Object localObject1;
    Object localObject2;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    if (paramIALocation.hasFloorLevel())
    {
      localObject1 = Integer.valueOf(paramIALocation.getFloorLevel());
      localObject2 = a(paramLong, d1, d2, (Integer)localObject1);
      localObject1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList3 = new ArrayList();
      localObject2 = ((ArrayList)localObject2).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label207;
      }
      Pair localPair = (Pair)((Iterator)localObject2).next();
      switch (((Integer)localPair.first).intValue())
      {
      default: 
        break;
      case 1: 
        ((ArrayList)localObject1).add(localPair.second);
        continue;
        localObject1 = null;
        break;
      case 16: 
        localArrayList2.add(localPair.second);
        break;
      case 256: 
        localArrayList3.add(localPair.second);
      }
    }
    label207:
    localArrayList1.add(new ax((ArrayList)localObject1, 1, paramIALocation));
    localArrayList1.add(new ax(localArrayList2, 16, paramIALocation));
    localArrayList1.add(new ax(localArrayList3, 256, paramIALocation));
    return localArrayList1;
  }
  
  public final void a(String paramString)
  {
    this.a.a.a(paramString);
  }
  
  public static final class a
  {
    long a;
    aw b;
    
    public a(long paramLong, aw paramaw)
    {
      this.a = paramLong;
      this.b = paramaw;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/cc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */