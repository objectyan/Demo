package com.indooratlas.android.sdk._internal;

import android.os.ParcelUuid;
import android.support.annotation.NonNull;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;

public final class cl
{
  public HashMap<ParcelUuid, HashMap<Integer, ff.b>> a;
  public HashMap<String, HashMap<Integer, ff.d>> b;
  public eu.a c;
  public HashMap<ParcelUuid, eu.a.a> d;
  public cr e;
  public long f;
  public long g;
  
  public cl(@NonNull cr paramcr)
  {
    if (paramcr == null) {
      throw new IllegalArgumentException("clock cannot be null");
    }
    this.e = paramcr;
    this.a = new HashMap();
    this.b = new HashMap();
  }
  
  public static ff.e[] b(@NonNull HashMap<String, HashMap<Integer, ff.d>> paramHashMap)
  {
    ff.e[] arrayOfe = new ff.e[paramHashMap.size()];
    paramHashMap = paramHashMap.entrySet().iterator();
    int i = 0;
    while (paramHashMap.hasNext())
    {
      Object localObject1 = (Map.Entry)paramHashMap.next();
      arrayOfe[i] = new ff.e();
      arrayOfe[i].b = ((String)((Map.Entry)localObject1).getKey());
      ff.e locale = arrayOfe[i];
      Object localObject2 = (HashMap)((Map.Entry)localObject1).getValue();
      localObject1 = new ff.d[((HashMap)localObject2).size()];
      localObject2 = ((HashMap)localObject2).values().iterator();
      int j = 0;
      while (((Iterator)localObject2).hasNext())
      {
        localObject1[j] = ((ff.d)((Iterator)localObject2).next());
        j += 1;
      }
      locale.d = ((ff.d[])localObject1);
      i += 1;
    }
    return arrayOfe;
  }
  
  public final int a()
  {
    Iterator localIterator = this.a.values().iterator();
    for (int i = 0; localIterator.hasNext(); i = ((HashMap)localIterator.next()).size() + i) {}
    localIterator = this.b.values().iterator();
    while (localIterator.hasNext()) {
      i += ((HashMap)localIterator.next()).size();
    }
    return i;
  }
  
  public final boolean a(@NonNull dh paramdh)
  {
    long l1 = cv.a(paramdh.a);
    boolean bool;
    if (l1 == -1L)
    {
      bool = false;
      return bool;
    }
    int j = Math.abs(paramdh.c);
    long l2 = paramdh.j;
    l2 -= this.g * 1000L;
    l2 /= 1000L;
    int k = (int)l2;
    int m;
    Object localObject3;
    Object localObject4;
    int n;
    int i1;
    int i;
    if (paramdh.k != null)
    {
      m = Math.abs(paramdh.k.e);
      localObject3 = this.b;
      localObject4 = paramdh.k.a;
      n = paramdh.k.c;
      i1 = paramdh.k.b;
      if ((this.c != null) && (!this.c.e)) {}
      for (i = 0; i == 0; i = 1)
      {
        i = 0;
        label141:
        return i | 0x0;
      }
      i = (((int)(l1 >>> 32 ^ l1) + 31) * 31 + n) * 31 + i1;
      paramdh = (HashMap)((HashMap)localObject3).get(localObject4);
      if (paramdh != null) {
        break label682;
      }
      paramdh = new HashMap(1);
    }
    label532:
    label682:
    for (;;)
    {
      Object localObject2 = (ff.d)paramdh.get(Integer.valueOf(i));
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new ff.d();
      }
      ((ff.d)localObject1).h = l1;
      ((ff.d)localObject1).b = n;
      ((ff.d)localObject1).d = i1;
      ((ff.d)localObject1).e = m;
      ((ff.d)localObject1).g = ec.a(((ff.d)localObject1).g, j);
      ((ff.d)localObject1).f = ec.a(((ff.d)localObject1).f, k);
      paramdh.put(Integer.valueOf(i), localObject1);
      ((HashMap)localObject3).put(localObject4, paramdh);
      i = 1;
      break label141;
      if (paramdh.f != null)
      {
        localObject3 = paramdh.f.entrySet().iterator();
        int i2 = 0;
        bool = i2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        paramdh = (Map.Entry)((Iterator)localObject3).next();
        localObject4 = this.a;
        ParcelUuid localParcelUuid = (ParcelUuid)paramdh.getKey();
        byte[] arrayOfByte = (byte[])paramdh.getValue();
        if ((this.c == null) || (this.c.f)) {
          if ((arrayOfByte == null) || (arrayOfByte.length == 0)) {
            i = 0;
          }
        }
        for (;;)
        {
          if (i != 0) {
            break label532;
          }
          i = 0;
          i2 = i | i2;
          break;
          if (this.d == null)
          {
            i = 1;
          }
          else
          {
            paramdh = (eu.a.a)this.d.get(localParcelUuid);
            if (paramdh != null) {}
            switch (paramdh.d)
            {
            default: 
              i = 0;
              break;
            case 0: 
              i = 0;
              break;
            case 1: 
              i = 1;
              break;
            case 2: 
              if ((arrayOfByte[0] & 0xFF) == 0) {
                i = 1;
              } else {
                i = 0;
              }
              break;
            }
          }
        }
        i = ((int)(l1 >>> 32 ^ l1) + 31) * 31 + Arrays.hashCode(arrayOfByte);
        paramdh = (HashMap)((HashMap)localObject4).get(localParcelUuid);
        if (paramdh == null) {
          paramdh = new HashMap(1);
        }
        for (;;)
        {
          localObject2 = (ff.b)paramdh.get(Integer.valueOf(i));
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = new ff.b();
          }
          ((ff.b)localObject1).f = l1;
          ((ff.b)localObject1).b = arrayOfByte;
          ((ff.b)localObject1).e = ec.a(((ff.b)localObject1).e, j);
          ((ff.b)localObject1).d = ec.a(((ff.b)localObject1).d, k);
          paramdh.put(Integer.valueOf(i), localObject1);
          ((HashMap)localObject4).put(localParcelUuid, paramdh);
          i = 1;
          break;
        }
      }
      return false;
    }
  }
  
  public final ff.a[] a(@NonNull HashMap<ParcelUuid, HashMap<Integer, ff.b>> paramHashMap)
  {
    ff.a[] arrayOfa = new ff.a[paramHashMap.size()];
    Iterator localIterator = paramHashMap.entrySet().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject1 = (Map.Entry)localIterator.next();
      arrayOfa[i] = new ff.a();
      Object localObject2 = arrayOfa[i];
      paramHashMap = (ParcelUuid)((Map.Entry)localObject1).getKey();
      if ((this.d != null) && (this.d.containsKey(paramHashMap))) {}
      ByteBuffer localByteBuffer;
      for (paramHashMap = ((eu.a.a)this.d.get(paramHashMap)).b;; paramHashMap = localByteBuffer.array())
      {
        ((ff.a)localObject2).b = paramHashMap;
        paramHashMap = arrayOfa[i];
        localObject2 = (Map)((Map.Entry)localObject1).getValue();
        localObject1 = new ff.b[((Map)localObject2).size()];
        localObject2 = ((Map)localObject2).values().iterator();
        int j = 0;
        while (((Iterator)localObject2).hasNext())
        {
          localObject1[j] = ((ff.b)((Iterator)localObject2).next());
          j += 1;
        }
        localByteBuffer = ByteBuffer.wrap(new byte[16]);
        localByteBuffer.putLong(paramHashMap.getUuid().getMostSignificantBits());
        localByteBuffer.putLong(paramHashMap.getUuid().getLeastSignificantBits());
      }
      paramHashMap.d = ((ff.b[])localObject1);
      i += 1;
    }
    return arrayOfa;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/cl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */