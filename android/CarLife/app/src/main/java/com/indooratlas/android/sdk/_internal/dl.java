package com.indooratlas.android.sdk._internal;

import android.os.ParcelUuid;
import android.os.SystemClock;
import android.util.SparseArray;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public final class dl
{
  private static final ParcelUuid a = ParcelUuid.fromString("00000000-0000-1000-8000-00805F9B34FB");
  private static final byte[] b = { 76, 0, 2, 21 };
  
  private static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, List<ParcelUuid> paramList)
  {
    while (paramInt2 > 0)
    {
      paramList.add(a(a(paramArrayOfByte, paramInt1, paramInt3)));
      paramInt2 -= paramInt3;
      paramInt1 += paramInt3;
    }
    return paramInt1;
  }
  
  private static ParcelUuid a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      throw new IllegalArgumentException("uuidBytes cannot be null");
    }
    int i = paramArrayOfByte.length;
    if ((i != 2) && (i != 4) && (i != 16)) {
      throw new IllegalArgumentException("uuidBytes length invalid - " + i);
    }
    if (i == 16)
    {
      paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN);
      return new ParcelUuid(new UUID(paramArrayOfByte.getLong(8), paramArrayOfByte.getLong(0)));
    }
    if (i == 2) {}
    for (long l = (paramArrayOfByte[0] & 0xFF) + ((paramArrayOfByte[1] & 0xFF) << 8);; l = (paramArrayOfByte[0] & 0xFF) + ((paramArrayOfByte[1] & 0xFF) << 8) + ((paramArrayOfByte[2] & 0xFF) << 16) + ((paramArrayOfByte[3] & 0xFF) << 24)) {
      return new ParcelUuid(new UUID(a.getUuid().getMostSignificantBits() + (l << 32), a.getUuid().getLeastSignificantBits()));
    }
  }
  
  public static dh a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramString2 == null)) {
      paramString1 = null;
    }
    int k;
    int j;
    Object localObject;
    int i;
    int m;
    label383:
    do
    {
      return paramString1;
      k = 0;
      j = -1;
      ArrayList localArrayList2 = new ArrayList();
      localObject = null;
      i = Integer.MIN_VALUE;
      SparseArray localSparseArray = new SparseArray();
      HashMap localHashMap = new HashMap();
      try
      {
        if (k >= paramArrayOfByte.length) {
          break label383;
        }
        int n = k + 1;
        k = paramArrayOfByte[k] & 0xFF;
        if (k == 0) {
          break label383;
        }
        k -= 1;
        m = n + 1;
        switch (paramArrayOfByte[n] & 0xFF)
        {
        case 2: 
        case 3: 
          a(paramArrayOfByte, m, k, 2, localArrayList2);
        }
      }
      catch (Exception paramString1)
      {
        ee.a(cz.a, "unable to parse scan record: " + Arrays.toString(paramArrayOfByte), new Object[0]);
        return null;
      }
      a(paramArrayOfByte, m, k, 4, localArrayList2);
      break;
      a(paramArrayOfByte, m, k, 16, localArrayList2);
      break;
      localObject = new String(a(paramArrayOfByte, m, k), "UTF-8");
      break;
      localHashMap.put(a(a(paramArrayOfByte, m, 2)), a(paramArrayOfByte, m + 2, k - 2));
      break;
      localSparseArray.put(((paramArrayOfByte[(m + 1)] & 0xFF) << 8) + (paramArrayOfByte[m] & 0xFF), a(paramArrayOfByte, m + 2, k - 2));
      break;
      ArrayList localArrayList1 = localArrayList2;
      if (localArrayList2.isEmpty()) {
        localArrayList1 = null;
      }
      paramString2 = new dh(paramString2, paramString1, SystemClock.elapsedRealtime() * 1000L, paramInt, localArrayList1, localSparseArray, localHashMap, j, i, (String)localObject);
      localObject = a(paramArrayOfByte, paramInt);
      paramString1 = paramString2;
    } while (localObject == null);
    paramString2.h = ((di)localObject).e;
    paramString2.k = ((di)localObject);
    return paramString2;
    for (;;)
    {
      k += m;
      break;
      j = paramArrayOfByte[m] & 0xFF;
      continue;
      i = paramArrayOfByte[m];
    }
  }
  
  public static di a(byte[] paramArrayOfByte, int paramInt)
  {
    Object localObject2;
    if (paramArrayOfByte == null)
    {
      localObject2 = null;
      return (di)localObject2;
    }
    int i = 0;
    label13:
    int j;
    int k;
    Object localObject1;
    if (i < paramArrayOfByte.length)
    {
      j = paramArrayOfByte[i] & 0xFF;
      k = i + 1;
      if (j != 0)
      {
        i = paramArrayOfByte[k] & 0xFF;
        k += 1;
        if (i != 0) {
          if (i == 255)
          {
            localObject1 = Arrays.copyOfRange(paramArrayOfByte, k, k + j - 1);
            if (localObject1.length >= 25) {
              break label117;
            }
            localObject1 = null;
          }
        }
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      i = j - 1 + k;
      break label13;
      label117:
      localObject2 = b;
      StringBuilder localStringBuilder;
      if (localObject1.length < localObject2.length)
      {
        i = 0;
        if (i == 0) {
          break label445;
        }
        localObject2 = Arrays.copyOfRange((byte[])localObject1, 4, 20);
        localStringBuilder = new StringBuilder();
        i = 0;
        label161:
        if (i >= localObject2.length) {
          break label314;
        }
        switch (i)
        {
        }
      }
      int m;
      for (;;)
      {
        m = localObject2[i] & 0xFF;
        if (m <= 15) {
          localStringBuilder.append('0');
        }
        localStringBuilder.append(Integer.toHexString(m));
        i += 1;
        break label161;
        i = 0;
        for (;;)
        {
          if (i >= localObject2.length) {
            break label297;
          }
          if (localObject1[i] != localObject2[i])
          {
            i = 0;
            break;
          }
          i += 1;
        }
        label297:
        i = 1;
        break;
        localStringBuilder.append('-');
      }
      label314:
      localObject2 = localStringBuilder.toString();
      if (!ei.a((CharSequence)localObject2))
      {
        i = b(Arrays.copyOfRange((byte[])localObject1, 20, 22));
        m = b(Arrays.copyOfRange((byte[])localObject1, 22, 24));
        int n = localObject1[24];
        double d = paramInt;
        if (d == 0.0D) {
          d = -1.0D;
        }
        for (;;)
        {
          localObject1 = new di((String)localObject2, i, m, paramInt, n, d);
          break;
          d = d * 1.0D / n;
          if (d < 1.0D) {
            d = Math.pow(d, 10.0D);
          } else {
            d = Math.pow(d, 7.7095D) * 0.89976D + 0.111D;
          }
        }
        return null;
      }
      label445:
      localObject1 = null;
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  private static int b(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(new byte[] { 0, 0, paramArrayOfByte[0], paramArrayOfByte[1] }).getInt();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/dl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */