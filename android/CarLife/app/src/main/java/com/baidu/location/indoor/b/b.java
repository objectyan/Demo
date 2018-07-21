package com.baidu.location.indoor.b;

import com.baidu.location.BDLocation;
import com.baidu.location.h.g;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;

public final class b
{
  private static volatile b q = null;
  private HashMap<String, HashMap<Integer, c>> a = null;
  private HashMap<String, HashMap<Integer, Vector<Integer>>> b = null;
  private HashMap<String, ArrayList<ArrayList<Integer>>> c = null;
  private HashMap<String, ArrayList<ArrayList<Integer>>> d = null;
  private ArrayList<BDLocation> e = null;
  private ArrayList<BDLocation> f = null;
  private c g = null;
  private String h = null;
  private String i = null;
  private boolean j = false;
  private boolean k = true;
  private boolean l = false;
  private boolean m = false;
  private b n = null;
  private boolean o = false;
  private String p = null;
  
  private double a(BDLocation paramBDLocation, ArrayList<c> paramArrayList)
  {
    c localc1 = (c)paramArrayList.get(paramArrayList.size() - 1);
    c localc2 = new c();
    localc2.a = paramBDLocation.getLatitude();
    localc2.b = paramBDLocation.getLongitude();
    double d1 = localc1.a(localc2);
    paramBDLocation = c.c(this.g).iterator();
    while (paramBDLocation.hasNext()) {
      d1 = a((b)paramBDLocation.next(), paramArrayList) + d1;
    }
    return d1;
  }
  
  private double a(b paramb, ArrayList<c> paramArrayList)
  {
    int i1 = 0;
    c localc1 = new c();
    localc1.a = b.a(paramb);
    localc1.b = b.b(paramb);
    if (paramArrayList.size() < 2) {
      return Double.MAX_VALUE;
    }
    c localc4 = (c)paramArrayList.get(0);
    c localc2 = (c)paramArrayList.get(paramArrayList.size() - 1);
    c localc3;
    if ((localc4.d != Integer.MAX_VALUE) && (localc4.e != Integer.MAX_VALUE))
    {
      localc3 = (c)((HashMap)this.a.get(this.h)).get(Integer.valueOf(localc4.d));
      localc4 = (c)((HashMap)this.a.get(this.h)).get(Integer.valueOf(localc4.e));
      c localc5 = c(localc1, localc3, localc4);
      if (d(localc5, localc3, localc4)) {
        return localc1.a(localc5);
      }
    }
    if ((localc2.d != Integer.MAX_VALUE) && (localc2.e != Integer.MAX_VALUE))
    {
      localc3 = (c)((HashMap)this.a.get(this.h)).get(Integer.valueOf(localc2.d));
      localc2 = (c)((HashMap)this.a.get(this.h)).get(Integer.valueOf(localc2.e));
      localc4 = c(localc1, localc3, localc2);
      if (d(localc4, localc3, localc2)) {
        return localc1.a(localc4);
      }
    }
    if (b.h(paramb))
    {
      paramArrayList = new c();
      paramArrayList.a = b.f(paramb);
      paramArrayList.b = b.e(paramb);
      return localc1.a(paramArrayList);
    }
    double d1 = Double.MAX_VALUE;
    if (i1 < paramArrayList.size() - 1)
    {
      paramb = (c)paramArrayList.get(i1);
      localc2 = (c)paramArrayList.get(i1 + 1);
      localc3 = c(localc1, paramb, localc2);
      if (!d(localc3, paramb, localc2)) {
        break label422;
      }
      double d2 = localc1.a(localc3);
      if (d2 >= d1) {
        break label422;
      }
      d1 = d2;
    }
    label422:
    for (;;)
    {
      i1 += 1;
      break;
      return d1;
    }
  }
  
  private double a(c paramc1, c paramc2, ArrayList<c> paramArrayList)
  {
    int i1 = 0;
    double d1 = 0.0D;
    while ((paramArrayList.size() >= 2) && (i1 < paramArrayList.size() - 1))
    {
      d1 += ((c)paramArrayList.get(i1)).a((c)paramArrayList.get(i1 + 1));
      i1 += 1;
    }
    double d2 = paramc1.a((c)paramArrayList.get(0));
    return paramc1.a((c)paramArrayList.get(paramArrayList.size() - 1)) + (d1 + d2);
  }
  
  private double a(List<c> paramList)
  {
    double d2;
    if (paramList.size() < 2)
    {
      d2 = Double.MAX_VALUE;
      return d2;
    }
    double d1 = 0.0D;
    int i1 = 0;
    for (;;)
    {
      d2 = d1;
      if (i1 >= paramList.size() - 1) {
        break;
      }
      d1 += ((c)paramList.get(i1)).a((c)paramList.get(i1 + 1));
      i1 += 1;
    }
  }
  
  public static b a()
  {
    if (q == null) {}
    try
    {
      if (q == null) {
        q = new b();
      }
      return q;
    }
    finally {}
  }
  
  private c a(c paramc1, c paramc2, c paramc3)
  {
    c localc = new c();
    double d5 = paramc2.a;
    double d6 = paramc2.b;
    double d2 = paramc3.a;
    double d7 = paramc3.b;
    double d1 = paramc1.a;
    double d3 = paramc1.b;
    d3 = Math.sqrt((d1 - d2) * (d1 - d2) + (d3 - d7) * (d3 - d7));
    if (Math.abs((d6 - d7) / (d5 - d2)) > 10.0D)
    {
      d1 = d7 + d3;
      if ((d2 - d2) * (d2 - d5) + (d1 - d7) * (d7 - d6) <= 0.0D) {}
    }
    for (;;)
    {
      localc.a = d2;
      localc.b = d1;
      return localc;
      d1 = d7 - d3;
      continue;
      double d8 = (d7 - d6) / (d2 - d5);
      double d9 = (d5 * d7 - d2 * d6) / (d5 - d2);
      double d4 = d8 * d8 + 1.0D;
      double d10 = 2.0D * d8 * (d9 - d7) - 2.0D * d2;
      double d11 = d2 * d2 + (d9 - d7) * (d9 - d7) - d3 * d3;
      if (d10 * d10 - 4.0D * d4 * d11 < 0.0D)
      {
        localc.a = Double.MAX_VALUE;
        localc.b = Double.MAX_VALUE;
        return localc;
      }
      d3 = (-1.0D * d10 + Math.sqrt(d10 * d10 - 4.0D * d4 * d11)) / (2.0D * d4);
      d1 = d8 * d3 + d9;
      d4 = (-1.0D * d10 - Math.sqrt(d10 * d10 - d11 * (4.0D * d4))) / (d4 * 2.0D);
      if ((d2 - d5) * (d3 - d2) + (d1 - d7) * (d7 - d6) > 0.0D)
      {
        d2 = d3;
      }
      else
      {
        d1 = d8 * d4 + d9;
        d2 = d4;
      }
    }
  }
  
  private ArrayList<c> a(e parame1, e parame2)
  {
    parame1.c.d = parame1.a();
    parame1.c.e = parame1.b();
    parame2.c.d = parame2.a();
    parame2.c.e = parame2.b();
    double d2 = Double.MAX_VALUE;
    Object localObject = new ArrayList();
    if ((parame1.a() == parame2.a()) && (parame1.b() == parame2.b()))
    {
      ((ArrayList)localObject).add(parame1.c);
      ((ArrayList)localObject).add(parame2.c);
    }
    do
    {
      return (ArrayList<c>)localObject;
      HashSet localHashSet = new HashSet();
      localHashSet.add(Integer.valueOf(parame1.b()));
      localHashSet.add(Integer.valueOf(parame2.b()));
      ArrayList localArrayList = a(this.h, parame1.a(), parame2.a(), parame1.c, parame2.c, localHashSet);
      double d1 = a(localArrayList);
      if (d1 < Double.MAX_VALUE)
      {
        localObject = localArrayList;
        d2 = d1;
      }
      localHashSet.clear();
      localHashSet.add(Integer.valueOf(parame1.a()));
      localHashSet.add(Integer.valueOf(parame2.b()));
      localArrayList = a(this.h, parame1.b(), parame2.a(), parame1.c, parame2.c, localHashSet);
      double d3 = a(localArrayList);
      d1 = d2;
      if (d3 < d2)
      {
        localObject = localArrayList;
        d1 = d3;
      }
      localHashSet.clear();
      localHashSet.add(Integer.valueOf(parame1.b()));
      localHashSet.add(Integer.valueOf(parame2.a()));
      localArrayList = a(this.h, parame1.a(), parame2.b(), parame1.c, parame2.c, localHashSet);
      d3 = a(localArrayList);
      d2 = d1;
      if (d3 < d1)
      {
        localObject = localArrayList;
        d2 = d3;
      }
      localHashSet.clear();
      localHashSet.add(Integer.valueOf(parame1.a()));
      localHashSet.add(Integer.valueOf(parame2.a()));
      parame1 = a(this.h, parame1.b(), parame2.b(), parame1.c, parame2.c, localHashSet);
    } while (a(parame1) >= d2);
    return parame1;
  }
  
  private ArrayList<c> a(String paramString, int paramInt1, int paramInt2, c paramc1, c paramc2, Set<Integer> paramSet)
  {
    paramString = (HashMap)this.b.get(paramString);
    ArrayList localArrayList = new ArrayList();
    Object localObject = new LinkedList();
    ((Queue)localObject).add(new a(null, paramInt1, 0, null));
    while (!((Queue)localObject).isEmpty())
    {
      a locala = (a)((Queue)localObject).poll();
      if ((!paramSet.contains(Integer.valueOf(a.a(locala)))) && (a.b(locala) <= 4)) {
        if (a.a(locala) != paramInt2)
        {
          paramSet.add(Integer.valueOf(a.a(locala)));
          if (a.b(locala) < 4)
          {
            Vector localVector = (Vector)paramString.get(Integer.valueOf(a.a(locala)));
            paramInt1 = 0;
            while ((localVector != null) && (paramInt1 < localVector.size()))
            {
              ((Queue)localObject).offer(new a(locala, ((Integer)localVector.get(paramInt1)).intValue(), a.b(locala) + 1, null));
              paramInt1 += 1;
            }
          }
        }
        else
        {
          localArrayList.add(locala);
        }
      }
    }
    paramSet = new ArrayList();
    paramInt1 = 0;
    while (paramInt1 < localArrayList.size())
    {
      localObject = new ArrayList();
      for (paramString = (a)localArrayList.get(paramInt1); paramString != null; paramString = a.c(paramString)) {
        ((ArrayList)localObject).add((c)((HashMap)this.a.get(this.h)).get(Integer.valueOf(a.a(paramString))));
      }
      paramString = new ArrayList();
      paramInt2 = ((ArrayList)localObject).size() - 1;
      while (paramInt2 >= 0)
      {
        paramString.add(((ArrayList)localObject).get(paramInt2));
        paramInt2 -= 1;
      }
      if (a(paramc1, paramc2, (ArrayList)localObject) < Float.MAX_VALUE)
      {
        paramSet.clear();
        paramSet.add(paramc1);
        paramSet.addAll(paramString);
        paramSet.add(paramc2);
      }
      paramInt1 += 1;
    }
    return paramSet;
  }
  
  private boolean a(String paramString)
  {
    paramString = new File(paramString);
    int i1;
    for (;;)
    {
      try
      {
        localBufferedReader = new BufferedReader(new FileReader(paramString));
        paramString = null;
        localArrayList = null;
        localHashMap1 = null;
        localHashMap2 = null;
      }
      catch (FileNotFoundException paramString)
      {
        HashMap localHashMap1;
        HashMap localHashMap2;
        paramString.printStackTrace();
        return false;
        localObject3 = new Vector();
        i2 = Integer.valueOf(localObject2[1]).intValue();
        ((Vector)localObject3).add(Integer.valueOf(localObject2[0]));
        localHashMap1.put(Integer.valueOf(i2), localObject3);
      }
      catch (Exception paramString)
      {
        BufferedReader localBufferedReader;
        ArrayList localArrayList;
        paramString.printStackTrace();
        continue;
        if (!localObject1[0].equals("2")) {
          continue;
        }
        Object localObject2 = localObject1[1].split("-");
        localObject3 = new ArrayList();
        i1 = 0;
        if (i1 >= localObject2.length) {
          continue;
        }
        ((ArrayList)localObject3).add(Integer.valueOf(localObject2[i1]));
        i1 += 1;
        continue;
        localArrayList.add(localObject3);
        if (!localObject1[0].equals("3")) {
          continue;
        }
        Object localObject1 = localObject1[1].split("-");
        localObject2 = new ArrayList();
        i1 = 0;
        if (i1 >= localObject1.length) {
          continue;
        }
        ((ArrayList)localObject2).add(Integer.valueOf(localObject1[i1]));
        i1 += 1;
        continue;
        paramString.add(localObject2);
        continue;
        localBufferedReader.close();
        paramString = (HashMap)this.a.get(this.h);
        paramString = (HashMap)this.b.get(this.h);
        return true;
      }
      localObject1 = localBufferedReader.readLine();
      if (localObject1 != null)
      {
        if (((String)localObject1).contains("Floor"))
        {
          localHashMap2 = new HashMap();
          localHashMap1 = new HashMap();
          localArrayList = new ArrayList();
          paramString = new ArrayList();
          localObject1 = localObject1.split(":")[1];
          this.a.put(localObject1, localHashMap2);
          this.b.put(localObject1, localHashMap1);
          this.c.put(localObject1, localArrayList);
          this.d.put(localObject1, paramString);
          continue;
        }
        localObject1 = ((String)localObject1).split(",");
        if (localObject1[0].equals("0"))
        {
          i1 = Integer.valueOf(localObject1[2]).intValue();
          localObject2 = new c();
          ((c)localObject2).a = Double.valueOf(localObject1[4]).doubleValue();
          ((c)localObject2).b = Double.valueOf(localObject1[3]).doubleValue();
          ((c)localObject2).c = i1;
          localHashMap2.put(Integer.valueOf(i1), localObject2);
        }
        if (localObject1[0].equals("1")) {
          i1 = 1;
        }
      }
    }
    for (;;)
    {
      Object localObject3;
      int i2;
      if (i1 < localObject1.length)
      {
        localObject2 = localObject1[i1].split("-");
        if (localHashMap1.keySet().contains(Integer.valueOf(localObject2[0])))
        {
          localObject3 = (Vector)localHashMap1.get(Integer.valueOf(localObject2[0]));
          if (!((Vector)localObject3).contains(Integer.valueOf(localObject2[1])))
          {
            ((Vector)localObject3).add(Integer.valueOf(localObject2[1]));
            Collections.sort((List)localObject3);
          }
        }
        while (localHashMap1.keySet().contains(Integer.valueOf(localObject2[1])))
        {
          localObject3 = (Vector)localHashMap1.get(Integer.valueOf(localObject2[1]));
          if (((Vector)localObject3).contains(Integer.valueOf(localObject2[0]))) {
            break label717;
          }
          ((Vector)localObject3).add(Integer.valueOf(localObject2[0]));
          Collections.sort((List)localObject3);
          break label717;
          localObject3 = new Vector();
          i2 = Integer.valueOf(localObject2[0]).intValue();
          ((Vector)localObject3).add(Integer.valueOf(localObject2[1]));
          localHashMap1.put(Integer.valueOf(i2), localObject3);
        }
      }
      label717:
      i1 += 1;
    }
  }
  
  private c b(c paramc1, c paramc2, c paramc3)
  {
    c localc = new c();
    double d2 = paramc2.a;
    double d5 = paramc2.b;
    double d6 = paramc3.a;
    double d7 = paramc3.b;
    double d1 = paramc1.a;
    double d3 = paramc1.b;
    d3 = Math.sqrt((d1 - d2) * (d1 - d2) + (d3 - d5) * (d3 - d5));
    if (Math.abs((d5 - d7) / (d2 - d6)) > 200.0D)
    {
      d1 = d5 + d3;
      if ((d2 - d2) * (d6 - d2) + (d1 - d5) * (d7 - d5) <= 0.0D) {}
    }
    for (;;)
    {
      localc.a = d2;
      localc.b = d1;
      return localc;
      d1 = d5 - d3;
      continue;
      double d8 = (d7 - d5) / (d6 - d2);
      double d9 = (d2 * d7 - d6 * d5) / (d2 - d6);
      double d4 = d8 * d8 + 1.0D;
      double d10 = 2.0D * d8 * (d9 - d5) - 2.0D * d2;
      double d11 = d2 * d2 + (d9 - d5) * (d9 - d5) - d3 * d3;
      if (d10 * d10 - 4.0D * d4 * d11 < 0.0D)
      {
        localc.a = Double.MAX_VALUE;
        localc.b = Double.MAX_VALUE;
        return localc;
      }
      d3 = (-1.0D * d10 + Math.sqrt(d10 * d10 - 4.0D * d4 * d11)) / (2.0D * d4);
      d1 = d8 * d3 + d9;
      d4 = (-1.0D * d10 - Math.sqrt(d10 * d10 - d11 * (4.0D * d4))) / (d4 * 2.0D);
      if ((d6 - d2) * (d3 - d2) + (d7 - d5) * (d1 - d5) > 0.0D)
      {
        d2 = d3;
      }
      else
      {
        d1 = d8 * d4 + d9;
        d2 = d4;
      }
    }
  }
  
  private boolean b(b paramb, ArrayList<c> paramArrayList)
  {
    boolean bool3 = true;
    boolean bool4 = false;
    c localc1 = new c();
    localc1.a = b.a(paramb);
    localc1.b = b.b(paramb);
    boolean bool1;
    if (paramArrayList.size() < 2) {
      bool1 = false;
    }
    c localc2;
    c localc3;
    do
    {
      c localc4;
      do
      {
        return bool1;
        localc4 = (c)paramArrayList.get(0);
        localc2 = (c)paramArrayList.get(paramArrayList.size() - 1);
        if ((localc4.d == Integer.MAX_VALUE) || (localc4.e == Integer.MAX_VALUE)) {
          break;
        }
        localc3 = (c)((HashMap)this.a.get(this.h)).get(Integer.valueOf(localc4.d));
        localc4 = (c)((HashMap)this.a.get(this.h)).get(Integer.valueOf(localc4.e));
        bool1 = bool3;
      } while (d(c(localc1, localc3, localc4), localc3, localc4));
      if ((localc2.d == Integer.MAX_VALUE) || (localc2.e == Integer.MAX_VALUE)) {
        break;
      }
      localc3 = (c)((HashMap)this.a.get(this.h)).get(Integer.valueOf(localc2.d));
      localc2 = (c)((HashMap)this.a.get(this.h)).get(Integer.valueOf(localc2.e));
      bool1 = bool3;
    } while (d(c(localc1, localc3, localc2), localc3, localc2));
    int i1 = 0;
    for (;;)
    {
      boolean bool2 = bool4;
      if (i1 < paramArrayList.size() - 1)
      {
        localc2 = (c)paramArrayList.get(i1);
        localc3 = (c)paramArrayList.get(i1 + 1);
        if (d(c(localc1, localc2, localc3), localc2, localc3)) {
          bool2 = true;
        }
      }
      else
      {
        bool1 = bool3;
        if (b.h(paramb)) {
          break;
        }
        return bool2;
      }
      i1 += 1;
    }
  }
  
  private c c(c paramc1, c paramc2, c paramc3)
  {
    c localc = new c();
    double d1 = paramc1.a;
    double d2 = paramc1.b;
    double d3 = paramc2.a;
    double d4 = paramc2.b;
    double d5 = paramc3.a;
    double d6 = paramc3.b;
    if (Math.abs((d4 - d6) / (d3 - d5)) > 20000.0D)
    {
      localc.a = d3;
      localc.b = d2;
      return localc;
    }
    d5 = (d4 - d6) / (d3 - d5);
    d6 = d5 / (d5 * d5 + 1.0D);
    localc.a = ((d1 / d5 + (d2 - d4 + d5 * d3)) * d6);
    localc.b = ((localc.a - d3) * d5 + d4);
    return localc;
  }
  
  private boolean c(BDLocation paramBDLocation)
  {
    this.o = false;
    Object localObject = paramBDLocation.getBuildingName();
    if (!this.k)
    {
      if (!((String)localObject).equals(this.p))
      {
        this.l = false;
        this.m = false;
        a.b().a((String)localObject);
      }
      this.p = ((String)localObject);
    }
    this.h = paramBDLocation.getFloor();
    if (paramBDLocation.getNetworkLocationType().equals("wf"))
    {
      if (this.k)
      {
        this.p = ((String)localObject);
        a.b().a((String)localObject);
      }
      this.k = false;
    }
    if (!this.m)
    {
      if (!this.l) {
        break label217;
      }
      if (a(g.l() + File.separator + "indoorinfo" + File.separator + (String)localObject + File.separator + (String)localObject + ".txt")) {
        this.m = true;
      }
    }
    else
    {
      if (this.a.get(this.h) != null) {
        break label219;
      }
      return false;
    }
    this.m = false;
    this.l = false;
    a.b().c();
    return false;
    label217:
    return false;
    label219:
    HashMap localHashMap;
    if (paramBDLocation.getNetworkLocationType().equals("wf"))
    {
      this.i = this.h;
      this.n = new b(paramBDLocation.getLongitude(), paramBDLocation.getLatitude(), null);
      b.a(this.n, b.a(this.n));
      b.b(this.n, b.b(this.n));
      this.e = new ArrayList();
      this.f = new ArrayList();
      if (b(paramBDLocation))
      {
        c.a(this.g);
        this.n = null;
        this.j = false;
        return true;
      }
      if (!this.h.equals(this.i))
      {
        c.a(this.g);
        if (this.j) {
          this.j = false;
        }
        this.i = this.h;
        return true;
      }
      localHashMap = e(paramBDLocation);
      if (localHashMap.size() > 0)
      {
        if (c.b(this.g))
        {
          b.a(this.n, localHashMap);
          if (!this.o)
          {
            d(paramBDLocation);
            this.j = true;
            c.a(this.g, this.n);
          }
          return true;
        }
        if (!this.o)
        {
          double d1 = -1.0D;
          Iterator localIterator = localHashMap.entrySet().iterator();
          localObject = null;
          if (localIterator.hasNext())
          {
            e locale = (e)((Map.Entry)localIterator.next()).getValue();
            if (locale.e <= d1) {
              break label829;
            }
            d1 = locale.e;
            localObject = locale;
          }
        }
      }
    }
    label829:
    for (;;)
    {
      break;
      if ((localObject != null) && (((e)localObject).e > 0.5D))
      {
        paramBDLocation.setLatitude(((e)localObject).c.a);
        paramBDLocation.setLongitude(((e)localObject).c.b);
        b.a(this.n, ((e)localObject).c.a);
        b.b(this.n, ((e)localObject).c.b);
        paramBDLocation.setNetworkLocationType("wf2");
        this.j = true;
        b.a(this.n, false);
        b.a(this.n, new c());
        b.c(this.n).a = ((e)localObject).a.a;
        b.c(this.n).b = ((e)localObject).a.b;
        b.b(this.n, new c());
        b.d(this.n).a = ((e)localObject).b.a;
        b.d(this.n).b = ((e)localObject).b.b;
        if (!c.b(this.g))
        {
          b.a(this.n, localHashMap);
          c.a(this.g, this.n);
        }
        return true;
      }
      c.a(this.g);
      this.j = false;
      return true;
      return true;
      return true;
      if (paramBDLocation.getNetworkLocationType().equals("dr"))
      {
        localObject = new BDLocation(paramBDLocation);
        this.e.add(localObject);
        if (this.j)
        {
          d(paramBDLocation);
          this.f.add(paramBDLocation);
        }
        return true;
      }
      return true;
    }
  }
  
  private void d(BDLocation paramBDLocation)
  {
    double d1;
    double d2;
    Object localObject3;
    Object localObject1;
    if (paramBDLocation.getNetworkLocationType().equals("dr"))
    {
      d1 = b.e(this.n);
      d2 = b.f(this.n);
      double d3 = b.b(this.n);
      double d4 = b.a(this.n);
      paramBDLocation.setLongitude(d1 + paramBDLocation.getLongitude() - d3);
      paramBDLocation.setLatitude(paramBDLocation.getLatitude() + d2 - d4);
      localObject3 = new c();
      ((c)localObject3).a = paramBDLocation.getLatitude();
      ((c)localObject3).b = paramBDLocation.getLongitude();
      if ((b.c(this.n) != null) && (b.d(this.n) != null))
      {
        if (b.g(this.n)) {
          break label180;
        }
        localObject1 = c((c)localObject3, b.c(this.n), b.d(this.n));
      }
    }
    label180:
    label824:
    label1049:
    label2492:
    for (;;)
    {
      paramBDLocation.setLongitude(((c)localObject1).b);
      paramBDLocation.setLatitude(((c)localObject1).a);
      paramBDLocation.setNetworkLocationType("dr2");
      int i2;
      do
      {
        Object localObject4;
        Object localObject5;
        Object localObject6;
        do
        {
          return;
          if (b.h(this.n))
          {
            localObject1 = b((c)localObject3, b.c(this.n), b.d(this.n));
            if ((((c)localObject1).a == Double.MAX_VALUE) && (((c)localObject1).b == Double.MAX_VALUE))
            {
              localObject1 = c((c)localObject3, b.c(this.n), b.d(this.n));
              paramBDLocation.setLongitude(((c)localObject1).b);
              paramBDLocation.setLatitude(((c)localObject1).a);
              paramBDLocation.setNetworkLocationType("dr2");
              return;
            }
            paramBDLocation.setLongitude(((c)localObject1).b);
            paramBDLocation.setLatitude(((c)localObject1).a);
            paramBDLocation.setNetworkLocationType("dr2");
            return;
          }
          localObject1 = a((c)localObject3, b.c(this.n), b.d(this.n));
          if ((((c)localObject1).a == Double.MAX_VALUE) && (((c)localObject1).b == Double.MAX_VALUE))
          {
            localObject1 = c((c)localObject3, b.c(this.n), b.d(this.n));
            paramBDLocation.setLongitude(((c)localObject1).b);
            paramBDLocation.setLatitude(((c)localObject1).a);
            paramBDLocation.setNetworkLocationType("dr2");
            return;
          }
          if (b.d(this.n).d == Integer.MAX_VALUE) {
            break label2492;
          }
          i1 = b.d(this.n).d;
          i2 = b.d(this.n).e;
          localObject4 = (c)((HashMap)this.a.get(this.h)).get(Integer.valueOf(i1));
          localObject5 = (c)((HashMap)this.a.get(this.h)).get(Integer.valueOf(i2));
          if (d((c)localObject1, (c)localObject4, (c)localObject5)) {
            break label2492;
          }
          localObject2 = new c();
          i1 = 0;
          if (b.c(this.n).c == Integer.MAX_VALUE)
          {
            localObject6 = new c();
            ((c)localObject6).a = b.c(this.n).a;
            ((c)localObject6).b = b.c(this.n).b;
            c localc = new c();
            localc.a = b.d(this.n).a;
            localc.b = b.d(this.n).b;
            if (((c)localObject4).a((c)localObject6) > ((c)localObject4).a(localc))
            {
              ((c)localObject2).c = ((c)localObject4).c;
              ((c)localObject2).a = ((c)localObject4).a;
              ((c)localObject2).b = ((c)localObject4).b;
              i1 = ((c)localObject5).c;
            }
            if (((c)localObject4).a((c)localObject6) < ((c)localObject4).a(localc))
            {
              ((c)localObject2).c = ((c)localObject5).c;
              ((c)localObject2).a = ((c)localObject5).a;
              ((c)localObject2).b = ((c)localObject5).b;
              i1 = ((c)localObject4).c;
            }
            if (((c)localObject4).a((c)localObject6) == ((c)localObject4).a(localc))
            {
              paramBDLocation.setLongitude(((c)localObject1).b);
              paramBDLocation.setLatitude(((c)localObject1).a);
              paramBDLocation.setNetworkLocationType("dr2");
            }
          }
          else
          {
            if (((c)localObject4).c != b.c(this.n).c) {
              break label1049;
            }
            ((c)localObject2).a = ((c)localObject5).a;
            ((c)localObject2).b = ((c)localObject5).b;
            ((c)localObject2).c = ((c)localObject5).c;
            i1 = ((c)localObject4).c;
          }
          localObject4 = (Vector)((HashMap)this.b.get(this.h)).get(Integer.valueOf(((c)localObject2).c));
          localObject5 = new c();
          if (((Vector)localObject4).size() != 2) {
            break label2492;
          }
          if (((Integer)((Vector)localObject4).get(0)).intValue() != i1) {
            ((c)localObject5).a = ((c)((HashMap)this.a.get(this.h)).get(((Vector)localObject4).get(0))).a;
          }
          for (((c)localObject5).b = ((c)((HashMap)this.a.get(this.h)).get(((Vector)localObject4).get(0))).b;; ((c)localObject5).b = ((c)((HashMap)this.a.get(this.h)).get(((Vector)localObject4).get(1))).b)
          {
            localObject2 = b((c)localObject3, (c)localObject2, (c)localObject5);
            localObject1 = localObject2;
            if (((c)localObject2).a != Double.MAX_VALUE) {
              break;
            }
            localObject1 = localObject2;
            if (((c)localObject2).b != Double.MAX_VALUE) {
              break;
            }
            localObject1 = c((c)localObject3, b.c(this.n), b.d(this.n));
            paramBDLocation.setLongitude(((c)localObject1).b);
            paramBDLocation.setLatitude(((c)localObject1).a);
            paramBDLocation.setNetworkLocationType("dr2");
            return;
            ((c)localObject2).a = ((c)localObject4).a;
            ((c)localObject2).b = ((c)localObject4).b;
            ((c)localObject2).c = ((c)localObject4).c;
            i1 = ((c)localObject5).c;
            break label824;
            ((c)localObject5).a = ((c)((HashMap)this.a.get(this.h)).get(((Vector)localObject4).get(1))).a;
          }
          localObject1 = new ArrayList();
        } while (!paramBDLocation.getNetworkLocationType().equals("wf"));
        localObject2 = (b)c.c(this.g).getFirst();
        localObject3 = b.i(this.n);
        localObject2 = b.i((b)localObject2);
        localObject3 = ((HashMap)localObject3).entrySet().iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (e)((Map.Entry)((Iterator)localObject3).next()).getValue();
          localObject5 = ((HashMap)localObject2).entrySet().iterator();
          while (((Iterator)localObject5).hasNext())
          {
            localObject6 = a((e)((Map.Entry)((Iterator)localObject5).next()).getValue(), (e)localObject4);
            if ((localObject6 != null) && (((ArrayList)localObject6).size() > 0)) {
              ((ArrayList)localObject1).add(localObject6);
            }
          }
        }
        if (((ArrayList)localObject1).size() == 0)
        {
          b.a(this.n, paramBDLocation.getLatitude());
          b.b(this.n, paramBDLocation.getLongitude());
          paramBDLocation.setNetworkLocationType("wf2");
          return;
        }
        i1 = 0;
        while (i1 < ((ArrayList)localObject1).size())
        {
          localObject2 = (ArrayList)((ArrayList)localObject1).get(i1);
          localObject3 = c.c(this.g).iterator();
          i2 = 0;
          int i3 = 0;
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (b)((Iterator)localObject3).next();
            if (i3 == 0)
            {
              i3 += 1;
            }
            else
            {
              if (!b((b)localObject4, (ArrayList)localObject2)) {
                break;
              }
              i2 += 1;
            }
          }
          if (i2 < c.d(this.g) - 1) {
            ((ArrayList)localObject1).remove(i1);
          }
          i1 += 1;
        }
        if (((ArrayList)localObject1).size() == 0)
        {
          b.a(this.n, paramBDLocation.getLatitude());
          b.b(this.n, paramBDLocation.getLongitude());
          paramBDLocation.setNetworkLocationType("wf2");
          return;
        }
        new c();
        if (((ArrayList)localObject1).size() == 1)
        {
          localObject2 = (c)((ArrayList)((ArrayList)localObject1).get(0)).get(((ArrayList)((ArrayList)localObject1).get(0)).size() - 1);
          paramBDLocation.setLatitude(((c)localObject2).a);
          paramBDLocation.setLongitude(((c)localObject2).b);
          b.a(this.n, ((c)localObject2).a);
          b.b(this.n, ((c)localObject2).b);
          paramBDLocation.setNetworkLocationType("wf2");
          b.a(this.n, true);
          b.a(this.n, new c());
          b.c(this.n).a = ((c)((ArrayList)((ArrayList)localObject1).get(0)).get(((ArrayList)((ArrayList)localObject1).get(0)).size() - 2)).a;
          b.c(this.n).b = ((c)((ArrayList)((ArrayList)localObject1).get(0)).get(((ArrayList)((ArrayList)localObject1).get(0)).size() - 2)).b;
          b.c(this.n).c = ((c)((ArrayList)((ArrayList)localObject1).get(0)).get(((ArrayList)((ArrayList)localObject1).get(0)).size() - 2)).c;
          b.b(this.n, new c());
          b.d(this.n).a = ((c)((ArrayList)((ArrayList)localObject1).get(0)).get(((ArrayList)((ArrayList)localObject1).get(0)).size() - 1)).a;
          b.d(this.n).b = ((c)((ArrayList)((ArrayList)localObject1).get(0)).get(((ArrayList)((ArrayList)localObject1).get(0)).size() - 1)).b;
          b.d(this.n).d = ((c)((ArrayList)((ArrayList)localObject1).get(0)).get(((ArrayList)((ArrayList)localObject1).get(0)).size() - 1)).d;
          b.d(this.n).e = ((c)((ArrayList)((ArrayList)localObject1).get(0)).get(((ArrayList)((ArrayList)localObject1).get(0)).size() - 1)).e;
          b.d(this.n).c = ((c)((ArrayList)((ArrayList)localObject1).get(0)).get(((ArrayList)((ArrayList)localObject1).get(0)).size() - 1)).c;
          return;
        }
        i2 = 0;
      } while (((ArrayList)localObject1).size() < 2);
      Object localObject2 = new ArrayList();
      int i1 = 0;
      while (i1 < ((ArrayList)localObject1).size())
      {
        ((ArrayList)localObject2).add(Double.valueOf(a(paramBDLocation, (ArrayList)((ArrayList)localObject1).get(i1))));
        i1 += 1;
      }
      d1 = Double.MAX_VALUE;
      i1 = 0;
      while (i1 < ((ArrayList)localObject2).size())
      {
        d2 = d1;
        if (((Double)((ArrayList)localObject2).get(i1)).doubleValue() < d1)
        {
          d2 = ((Double)((ArrayList)localObject2).get(i1)).doubleValue();
          i2 = i1;
        }
        i1 += 1;
        d1 = d2;
      }
      localObject1 = (ArrayList)((ArrayList)localObject1).get(i2);
      localObject2 = (c)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1);
      paramBDLocation.setLatitude(((c)localObject2).a);
      paramBDLocation.setLongitude(((c)localObject2).b);
      b.a(this.n, ((c)localObject2).a);
      b.b(this.n, ((c)localObject2).b);
      b.a(this.n, true);
      b.a(this.n, new c());
      b.c(this.n).a = ((c)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 2)).a;
      b.c(this.n).b = ((c)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 2)).b;
      b.c(this.n).c = ((c)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 2)).c;
      b.b(this.n, new c());
      b.d(this.n).a = ((c)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1)).a;
      b.d(this.n).b = ((c)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1)).b;
      b.d(this.n).d = ((c)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1)).d;
      b.d(this.n).e = ((c)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1)).e;
      b.d(this.n).c = ((c)((ArrayList)localObject1).get(((ArrayList)localObject1).size() - 1)).c;
      paramBDLocation.setNetworkLocationType("wf2");
      return;
    }
  }
  
  private boolean d(c paramc1, c paramc2, c paramc3)
  {
    double d1 = paramc1.a;
    double d2 = paramc1.b;
    double d3 = paramc2.a;
    double d4 = paramc2.b;
    return (paramc3.a - d1) * (d3 - d1) + (paramc3.b - d2) * (d4 - d2) <= 0.0D;
  }
  
  private double e(c paramc1, c paramc2, c paramc3)
  {
    c localc1 = new c();
    c localc2 = new c();
    paramc2.a -= paramc1.a;
    paramc2.b -= paramc1.b;
    paramc3.a -= paramc1.a;
    paramc3.b -= paramc1.b;
    double d1 = localc1.a;
    double d2 = localc2.a;
    double d3 = localc1.b;
    double d4 = localc2.b;
    double d5 = localc1.a();
    return Math.acos((d1 * d2 + d3 * d4) / (localc2.a() * d5));
  }
  
  private HashMap<String, e> e(BDLocation paramBDLocation)
  {
    HashMap localHashMap = new HashMap();
    double d1 = paramBDLocation.getLatitude();
    double d2 = paramBDLocation.getLongitude();
    c localc1 = new c();
    localc1.a = d1;
    localc1.b = d2;
    Object localObject2 = (HashMap)this.b.get(this.h);
    Object localObject1;
    Object localObject4;
    int i1;
    Object localObject3;
    int i2;
    if (localObject2 != null)
    {
      localObject1 = new HashMap();
      localObject2 = ((HashMap)localObject2).entrySet().iterator();
      if (((Iterator)localObject2).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject2).next();
        i1 = ((Integer)((Map.Entry)localObject4).getKey()).intValue();
        localObject3 = (c)((HashMap)this.a.get(this.h)).get(Integer.valueOf(i1));
        localObject4 = (Vector)((Map.Entry)localObject4).getValue();
        i2 = 0;
        label163:
        int i3;
        int i4;
        label199:
        int i5;
        label210:
        String str;
        if (i2 < ((Vector)localObject4).size())
        {
          i3 = ((Integer)((Vector)localObject4).get(i2)).intValue();
          if (i1 <= i3) {
            break label263;
          }
          i4 = i3;
          if (i1 >= i3) {
            break label270;
          }
          i5 = i3;
          str = String.valueOf(i4) + "_" + String.valueOf(i5);
          if (!((HashMap)localObject1).containsKey(str)) {
            break label277;
          }
        }
        for (;;)
        {
          i2 += 1;
          break label163;
          break;
          label263:
          i4 = i1;
          break label199;
          label270:
          i5 = i1;
          break label210;
          label277:
          ((HashMap)localObject1).put(str, Integer.valueOf(1));
          c localc2 = (c)((HashMap)this.a.get(this.h)).get(Integer.valueOf(i3));
          c localc3 = c(localc1, (c)localObject3, localc2);
          if (d(localc3, (c)localObject3, localc2))
          {
            e locale = new e();
            locale.c = localc3;
            locale.d = localc1.a(localc3);
            locale.a = ((c)localObject3);
            locale.b = localc2;
            if (locale.d < 2.0E-4D) {
              localHashMap.put(str, locale);
            }
          }
        }
      }
    }
    if (localHashMap.size() > 0)
    {
      localObject1 = localHashMap.entrySet().iterator();
      for (d1 = 0.0D; ((Iterator)localObject1).hasNext(); d1 = 1.0D / (((e)((Map.Entry)((Iterator)localObject1).next()).getValue()).d + 1.0E-6D) + d1) {}
      localObject1 = new ArrayList();
      localObject2 = localHashMap.entrySet().iterator();
      label597:
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject2).next();
        localObject3 = (e)((Map.Entry)localObject4).getValue();
        localObject4 = (String)((Map.Entry)localObject4).getKey();
        if (localHashMap.size() == 1) {}
        for (((e)localObject3).e = 1.0D;; ((e)localObject3).e = (1.0D / (1.0E-6D + ((e)localObject3).d) / d1))
        {
          if (((e)localObject3).e >= 0.1D) {
            break label597;
          }
          ((ArrayList)localObject1).add(localObject4);
          break;
        }
      }
      i1 = 0;
      while (i1 < ((ArrayList)localObject1).size())
      {
        localHashMap.remove((String)((ArrayList)localObject1).get(i1));
        i1 += 1;
      }
    }
    if (localHashMap.size() >= 0)
    {
      localObject1 = null;
      d1 = 999999.0D;
      i1 = 0;
      localObject3 = ((HashMap)this.a.get(this.h)).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject3).next();
        i2 = ((Integer)((Map.Entry)localObject2).getKey()).intValue();
        localObject2 = (c)((Map.Entry)localObject2).getValue();
        if ((Math.abs(((c)localObject2).a - localc1.a) <= 5.0E-4D) && (Math.abs(((c)localObject2).b - localc1.b) <= 5.0E-4D))
        {
          d2 = ((c)localObject2).a(localc1);
          if (d1 <= d2) {
            break label1692;
          }
          d1 = d2;
          localObject1 = localObject2;
          i1 = i2;
        }
      }
    }
    label1683:
    label1689:
    label1692:
    for (;;)
    {
      break;
      localObject2 = localHashMap.entrySet().iterator();
      i2 = 1;
      if (((Iterator)localObject2).hasNext())
      {
        if (((e)((Map.Entry)((Iterator)localObject2).next()).getValue()).d > d1) {
          break label1689;
        }
        i2 = 0;
      }
      for (;;)
      {
        break;
        if (i2 == 0) {
          return localHashMap;
        }
        localHashMap.clear();
        localObject2 = (Vector)((HashMap)this.b.get(this.h)).get(Integer.valueOf(i1));
        if (localObject2 == null) {
          return localHashMap;
        }
        i2 = ((Integer)((Vector)localObject2).get(0)).intValue();
        localObject2 = new e();
        ((e)localObject2).c = ((c)localObject1);
        ((e)localObject2).d = 0.0D;
        ((e)localObject2).a = ((c)((HashMap)this.a.get(this.h)).get(Integer.valueOf(i1)));
        ((e)localObject2).b = ((c)((HashMap)this.a.get(this.h)).get(Integer.valueOf(i2)));
        localHashMap.put(String.valueOf(i1) + "_" + String.valueOf(i2), localObject2);
        b.c(this.n, paramBDLocation.getLatitude());
        b.d(this.n, paramBDLocation.getLongitude());
        paramBDLocation.setLatitude(((c)localObject1).a);
        paramBDLocation.setLongitude(((c)localObject1).b);
        paramBDLocation.setNetworkLocationType("wf2");
        this.o = true;
        b.a(this.n, new c());
        b.c(this.n).a = ((e)localObject2).b.a;
        b.c(this.n).b = ((e)localObject2).b.b;
        b.b(this.n, new c());
        b.d(this.n).a = ((c)localObject1).a;
        b.d(this.n).b = ((c)localObject1).b;
        b.a(this.n, ((c)localObject1).a);
        b.b(this.n, ((c)localObject1).b);
        b.a(this.n, localHashMap);
        b.b(this.n, true);
        b.a(this.n, false);
        if (c.b(this.g))
        {
          paramBDLocation = (b)c.c(this.g).getLast();
          if ((b.d(paramBDLocation) != null) && ((b.d(paramBDLocation).d == i1) || (b.d(paramBDLocation).e == i1)))
          {
            ((e)localObject2).a = ((c)((HashMap)this.a.get(this.h)).get(Integer.valueOf(i1)));
            b.a(this.n, true);
            if (b.d(paramBDLocation).d != i1) {
              break label1683;
            }
          }
        }
        for (i2 = b.d(paramBDLocation).e;; i2 = 0)
        {
          if (b.d(paramBDLocation).e == i1) {
            i2 = b.d(paramBDLocation).d;
          }
          for (;;)
          {
            ((e)localObject2).b = ((c)((HashMap)this.a.get(this.h)).get(Integer.valueOf(i2)));
            paramBDLocation = (Vector)((HashMap)this.b.get(this.h)).get(Integer.valueOf(i1));
            localObject2 = new c();
            if (paramBDLocation.size() == 2)
            {
              if (((Integer)paramBDLocation.get(0)).intValue() != i2)
              {
                ((c)localObject2).a = ((c)((HashMap)this.a.get(this.h)).get(paramBDLocation.get(0))).a;
                ((c)localObject2).b = ((c)((HashMap)this.a.get(this.h)).get(paramBDLocation.get(0))).b;
              }
            }
            else
            {
              b.b(this.n, (c)localObject2);
              b.a(this.n, (c)localObject1);
              b.d(this.n).d = Integer.MAX_VALUE;
              b.b(this.n, true);
              c.e(this.g);
              c.a(this.g, this.n);
            }
            for (;;)
            {
              return localHashMap;
              ((c)localObject2).a = ((c)((HashMap)this.a.get(this.h)).get(paramBDLocation.get(1))).a;
              ((c)localObject2).b = ((c)((HashMap)this.a.get(this.h)).get(paramBDLocation.get(1))).b;
              break;
              c.a(this.g, this.n);
            }
          }
        }
      }
    }
  }
  
  public boolean a(BDLocation paramBDLocation)
  {
    return false;
  }
  
  void b()
  {
    this.l = true;
  }
  
  boolean b(BDLocation paramBDLocation)
  {
    boolean bool2 = false;
    ArrayList localArrayList2 = (ArrayList)this.c.get(this.h);
    ArrayList localArrayList1 = (ArrayList)this.d.get(this.h);
    c localc = new c();
    localc.a = paramBDLocation.getLatitude();
    localc.b = paramBDLocation.getLongitude();
    int i1 = 0;
    boolean bool1 = bool2;
    double d1;
    int i2;
    if (localArrayList2 != null)
    {
      bool1 = bool2;
      if (i1 < localArrayList2.size())
      {
        paramBDLocation = (ArrayList)localArrayList2.get(i1);
        d1 = 0.0D;
        i2 = 0;
        while (i2 < paramBDLocation.size() - 1)
        {
          d1 += e(localc, (c)((HashMap)this.a.get(this.h)).get(paramBDLocation.get(i2)), (c)((HashMap)this.a.get(this.h)).get(paramBDLocation.get(i2 + 1)));
          i2 += 1;
        }
        if (Math.abs(e(localc, (c)((HashMap)this.a.get(this.h)).get(paramBDLocation.get(0)), (c)((HashMap)this.a.get(this.h)).get(paramBDLocation.get(paramBDLocation.size() - 1))) + d1 - 360.0D) >= 0.1D) {
          break label389;
        }
        bool1 = true;
      }
    }
    if (!bool1)
    {
      i1 = 0;
      for (;;)
      {
        if ((localArrayList1 == null) || (i1 >= localArrayList1.size())) {
          break label486;
        }
        paramBDLocation = (ArrayList)localArrayList1.get(i1);
        d1 = 0.0D;
        i2 = 0;
        for (;;)
        {
          if (i2 < paramBDLocation.size() - 1)
          {
            d1 += e(localc, (c)((HashMap)this.a.get(this.h)).get(paramBDLocation.get(i2)), (c)((HashMap)this.a.get(this.h)).get(paramBDLocation.get(i2 + 1)));
            i2 += 1;
            continue;
            label389:
            i1 += 1;
            break;
          }
        }
        if (Math.abs(e(localc, (c)((HashMap)this.a.get(this.h)).get(paramBDLocation.get(0)), (c)((HashMap)this.a.get(this.h)).get(paramBDLocation.get(paramBDLocation.size() - 1))) + d1 - 360.0D) < 0.1D) {
          return true;
        }
        i1 += 1;
      }
    }
    label486:
    return bool1;
  }
  
  private static class a
  {
    private final a a;
    private final int b;
    private final int c;
    
    private a(a parama, int paramInt1, int paramInt2)
    {
      this.a = parama;
      this.b = paramInt1;
      this.c = paramInt2;
    }
  }
  
  private static class b
  {
    private double a;
    private double b;
    private HashMap<String, e> c = null;
    private double d;
    private double e;
    private boolean f = false;
    private c g;
    private c h;
    private boolean i = false;
    
    private b(double paramDouble1, double paramDouble2)
    {
      this.a = paramDouble1;
      this.b = paramDouble2;
    }
    
    private HashMap<String, e> a()
    {
      return this.c;
    }
    
    private void a(HashMap<String, e> paramHashMap)
    {
      this.c = paramHashMap;
    }
  }
  
  private static class c
  {
    private final ArrayDeque<b.b> a = new ArrayDeque();
    
    private void a()
    {
      if (this.a.size() > 0) {
        this.a.removeFirst();
      }
    }
    
    private void a(b.b paramb)
    {
      if (this.a.size() >= 3) {
        this.a.removeFirst();
      }
      this.a.addLast(paramb);
    }
    
    private void b()
    {
      this.a.clear();
    }
    
    private boolean c()
    {
      return this.a.size() == 3;
    }
    
    private int d()
    {
      return this.a.size();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/indoor/b/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */