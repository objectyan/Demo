package com.indooratlas.android.sdk._internal;

import android.os.ParcelUuid;
import android.util.SparseArray;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class dh
{
  public String a;
  public String b;
  public int c;
  public List<ParcelUuid> d;
  public SparseArray<byte[]> e;
  public Map<ParcelUuid, byte[]> f;
  public int g;
  public int h;
  public String i;
  public long j;
  public di k;
  
  public dh() {}
  
  public dh(String paramString1, String paramString2, long paramLong, int paramInt1, List<ParcelUuid> paramList, SparseArray<byte[]> paramSparseArray, Map<ParcelUuid, byte[]> paramMap, int paramInt2, int paramInt3, String paramString3)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.j = paramLong;
    this.c = paramInt1;
    this.d = paramList;
    this.e = paramSparseArray;
    this.f = paramMap;
    this.g = paramInt2;
    this.h = paramInt3;
    this.i = paramString3;
  }
  
  private static String a(SparseArray<byte[]> paramSparseArray)
  {
    if (paramSparseArray == null) {
      return "null";
    }
    if (paramSparseArray.size() == 0) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('{');
    int m = 0;
    while (m < paramSparseArray.size())
    {
      localStringBuilder.append(paramSparseArray.keyAt(m)).append('=').append(Arrays.toString((byte[])paramSparseArray.valueAt(m)));
      m += 1;
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  private static <T> String a(Map<T, byte[]> paramMap)
  {
    if (paramMap == null) {
      return "null";
    }
    if (paramMap.isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('{');
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = ((Map.Entry)localIterator.next()).getKey();
      localStringBuilder.append(localObject).append('=').append(Arrays.toString((byte[])paramMap.get(localObject)));
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public final String toString()
  {
    return "IABleEvent [device address=" + this.a + ", device name=" + this.b + ", rssi=" + this.c + ", timestamp=" + this.j + ", txPowerLevel=" + this.h + ", advertiseFlags=" + this.g + ", serviceUuids=" + this.d + ", manufacturerSpecificData=" + a(this.e) + ", serviceData=" + a(this.f) + ", localName=" + this.i + ", iBeaconData=" + this.k + "]";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/dh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */