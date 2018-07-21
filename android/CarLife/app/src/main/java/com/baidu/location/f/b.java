package com.baidu.location.f;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.baidu.location.f;
import com.baidu.location.h.g;
import java.io.File;
import java.io.RandomAccessFile;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.List<*>;
import java.util.Locale;

public class b
{
  public static int a = 0;
  public static int b = 0;
  private static b c = null;
  private static Method k = null;
  private static Method l = null;
  private static Method m = null;
  private static Method n = null;
  private static Method o = null;
  private static Class<?> p = null;
  private TelephonyManager d = null;
  private Object e = null;
  private a f = new a();
  private a g = null;
  private List<a> h = null;
  private a i = null;
  private boolean j = false;
  private boolean q = false;
  
  private int a(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt == Integer.MAX_VALUE) {
      i1 = -1;
    }
    return i1;
  }
  
  private CellLocation a(List<?> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      paramList = null;
      return paramList;
    }
    ClassLoader localClassLoader = ClassLoader.getSystemClassLoader();
    Object localObject4 = null;
    int i2 = 0;
    int i1 = 0;
    Object localObject1 = null;
    Object localObject7;
    for (;;)
    {
      if (i2 >= paramList.size()) {
        break label520;
      }
      localObject7 = paramList.get(i2);
      if (localObject7 != null) {
        break;
      }
      label56:
      i2 += 1;
    }
    for (;;)
    {
      Class localClass2;
      Class localClass3;
      Class localClass4;
      Class localClass1;
      boolean bool;
      int i5;
      int i6;
      try
      {
        localClass2 = localClassLoader.loadClass("android.telephony.CellInfoGsm");
        localClass3 = localClassLoader.loadClass("android.telephony.CellInfoWcdma");
        localClass4 = localClassLoader.loadClass("android.telephony.CellInfoLte");
        localClass1 = localClassLoader.loadClass("android.telephony.CellInfoCdma");
        bool = localClass2.isInstance(localObject7);
        if (bool)
        {
          i1 = 1;
          if (i1 <= 0) {
            continue;
          }
          localObject3 = null;
          if (i1 != 1) {
            continue;
          }
        }
      }
      catch (Exception localException2) {}
      try
      {
        localObject3 = localClass2.cast(localObject7);
        localObject7 = g.a(localObject3, "getCellIdentity", new Object[0]);
        if (localObject7 == null)
        {
          break label56;
          if (localClass3.isInstance(localObject7))
          {
            i1 = 2;
            continue;
          }
          if (localClass4.isInstance(localObject7))
          {
            i1 = 3;
            continue;
          }
          bool = localClass1.isInstance(localObject7);
          if (bool)
          {
            i1 = 4;
            continue;
          }
          i1 = 0;
          continue;
          if (i1 == 2)
          {
            localObject3 = localClass3.cast(localObject7);
            continue;
          }
          if (i1 == 3)
          {
            localObject3 = localClass4.cast(localObject7);
            continue;
          }
          if (i1 != 4) {
            continue;
          }
          localObject3 = localClass1.cast(localObject7);
          continue;
        }
        if (i1 == 4) {
          localObject3 = new CdmaCellLocation();
        }
      }
      catch (Exception localException3) {}
      try
      {
        i3 = g.b(localObject7, "getSystemId", new Object[0]);
        i4 = g.b(localObject7, "getNetworkId", new Object[0]);
        i5 = g.b(localObject7, "getBasestationId", new Object[0]);
        i6 = g.b(localObject7, "getLongitude", new Object[0]);
        ((CdmaCellLocation)localObject3).setCellLocationData(i5, g.b(localObject7, "getLatitude", new Object[0]), i6, i3, i4);
        localObject1 = localObject4;
        paramList = (List<?>)localObject3;
        if (i1 == 4) {
          break;
        }
        return (CellLocation)localObject1;
      }
      catch (Exception localException1)
      {
        localObject2 = localException3;
      }
      if (i1 == 3)
      {
        i3 = g.b(localObject7, "getTac", new Object[0]);
        i4 = g.b(localObject7, "getCi", new Object[0]);
        localObject3 = new GsmCellLocation();
      }
      try
      {
        ((GsmCellLocation)localObject3).setLacAndCid(i3, i4);
        paramList = (List<?>)localObject1;
        localObject1 = localObject3;
      }
      catch (Exception localException4)
      {
        localObject5 = localException3;
      }
      int i3 = g.b(localObject7, "getLac", new Object[0]);
      int i4 = g.b(localObject7, "getCid", new Object[0]);
      Object localObject3 = new GsmCellLocation();
      try
      {
        ((GsmCellLocation)localObject3).setLacAndCid(i3, i4);
        paramList = (List<?>)localObject1;
        localObject1 = localObject3;
      }
      catch (Exception localException5)
      {
        Object localObject5;
        localObject6 = localException3;
      }
      break label56;
      break label56;
      break label56;
      break label56;
      break label56;
      Object localObject6;
      break label56;
      label520:
      paramList = (List<?>)localObject2;
      Object localObject2 = localObject6;
    }
  }
  
  private a a(CellInfo paramCellInfo)
  {
    i1 = 0;
    i2 = -1;
    int i3 = Integer.valueOf(Build.VERSION.SDK_INT).intValue();
    if (i3 < 17) {
      return null;
    }
    a locala = new a();
    Object localObject;
    if ((paramCellInfo instanceof CellInfoGsm))
    {
      localObject = ((CellInfoGsm)paramCellInfo).getCellIdentity();
      locala.c = a(((CellIdentityGsm)localObject).getMcc());
      locala.d = a(((CellIdentityGsm)localObject).getMnc());
      locala.a = a(((CellIdentityGsm)localObject).getLac());
      locala.b = a(((CellIdentityGsm)localObject).getCid());
      locala.i = 'g';
      locala.h = ((CellInfoGsm)paramCellInfo).getCellSignalStrength().getAsuLevel();
      i1 = 1;
    }
    for (;;)
    {
      if ((i3 >= 18) && (i1 == 0)) {}
      try
      {
        if ((paramCellInfo instanceof CellInfoWcdma))
        {
          localObject = ((CellInfoWcdma)paramCellInfo).getCellIdentity();
          locala.c = a(((CellIdentityWcdma)localObject).getMcc());
          locala.d = a(((CellIdentityWcdma)localObject).getMnc());
          locala.a = a(((CellIdentityWcdma)localObject).getLac());
          locala.b = a(((CellIdentityWcdma)localObject).getCid());
          locala.i = 'g';
          locala.h = ((CellInfoWcdma)paramCellInfo).getCellSignalStrength().getAsuLevel();
        }
        try
        {
          long l1 = (SystemClock.elapsedRealtimeNanos() - paramCellInfo.getTimeStamp()) / 1000000L;
          locala.g = (System.currentTimeMillis() - l1);
          return locala;
          if ((paramCellInfo instanceof CellInfoCdma))
          {
            localObject = ((CellInfoCdma)paramCellInfo).getCellIdentity();
            locala.e = ((CellIdentityCdma)localObject).getLatitude();
            locala.f = ((CellIdentityCdma)localObject).getLongitude();
            locala.d = a(((CellIdentityCdma)localObject).getSystemId());
            locala.a = a(((CellIdentityCdma)localObject).getNetworkId());
            locala.b = a(((CellIdentityCdma)localObject).getBasestationId());
            locala.i = 'c';
            locala.h = ((CellInfoCdma)paramCellInfo).getCellSignalStrength().getCdmaDbm();
            if ((this.f != null) && (this.f.c > 0)) {
              locala.c = this.f.c;
            }
            for (;;)
            {
              i1 = 1;
              break;
              try
              {
                localObject = this.d.getNetworkOperator();
                i1 = i2;
                if (localObject != null)
                {
                  i1 = i2;
                  if (((String)localObject).length() > 0)
                  {
                    i1 = i2;
                    if (((String)localObject).length() >= 3)
                    {
                      i1 = Integer.valueOf(((String)localObject).substring(0, 3)).intValue();
                      i2 = i1;
                      i1 = i2;
                      if (i2 < 0) {
                        i1 = -1;
                      }
                    }
                  }
                }
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  i1 = i2;
                }
              }
              if (i1 > 0) {
                locala.c = i1;
              }
            }
          }
          if (!(paramCellInfo instanceof CellInfoLte)) {
            continue;
          }
          localObject = ((CellInfoLte)paramCellInfo).getCellIdentity();
          locala.c = a(((CellIdentityLte)localObject).getMcc());
          locala.d = a(((CellIdentityLte)localObject).getMnc());
          locala.a = a(((CellIdentityLte)localObject).getTac());
          locala.b = a(((CellIdentityLte)localObject).getCi());
          locala.i = 'g';
          locala.h = ((CellInfoLte)paramCellInfo).getCellSignalStrength().getAsuLevel();
          i1 = 1;
        }
        catch (Error paramCellInfo)
        {
          for (;;)
          {
            locala.g = System.currentTimeMillis();
          }
        }
      }
      catch (Exception localException1)
      {
        for (;;) {}
      }
    }
  }
  
  private a a(CellLocation paramCellLocation)
  {
    return a(paramCellLocation, false);
  }
  
  private a a(CellLocation paramCellLocation, boolean paramBoolean)
  {
    i2 = 0;
    int i3 = 0;
    if ((paramCellLocation == null) || (this.d == null)) {
      return null;
    }
    locala = new a();
    if (paramBoolean) {
      locala.f();
    }
    locala.g = System.currentTimeMillis();
    for (;;)
    {
      try
      {
        String str = this.d.getNetworkOperator();
        if ((str != null) && (str.length() > 0))
        {
          if (str.length() >= 3)
          {
            int i4 = Integer.valueOf(str.substring(0, 3)).intValue();
            i1 = i4;
            if (i4 < 0) {
              i1 = this.f.c;
            }
            locala.c = i1;
          }
          str = str.substring(3);
          if (str != null)
          {
            char[] arrayOfChar = str.toCharArray();
            i1 = i3;
            i2 = i1;
            if (i1 < arrayOfChar.length)
            {
              if (Character.isDigit(arrayOfChar[i1])) {
                continue;
              }
              i2 = i1;
            }
          }
          i2 = Integer.valueOf(str.substring(0, i2)).intValue();
          i1 = i2;
          if (i2 < 0) {
            i1 = this.f.d;
          }
          locala.d = i1;
        }
        a = this.d.getSimState();
      }
      catch (Exception localException)
      {
        int i1;
        b = 1;
        continue;
        if (!(paramCellLocation instanceof CdmaCellLocation)) {
          continue;
        }
        locala.i = 'c';
        if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() >= 5) {
          continue;
        }
        return locala;
        if (p != null) {
          continue;
        }
        try
        {
          p = Class.forName("android.telephony.cdma.CdmaCellLocation");
          k = p.getMethod("getBaseStationId", new Class[0]);
          l = p.getMethod("getNetworkId", new Class[0]);
          m = p.getMethod("getSystemId", new Class[0]);
          n = p.getMethod("getBaseStationLatitude", new Class[0]);
          o = p.getMethod("getBaseStationLongitude", new Class[0]);
          if ((p == null) || (!p.isInstance(paramCellLocation))) {
            continue;
          }
          try
          {
            i2 = ((Integer)m.invoke(paramCellLocation, new Object[0])).intValue();
            i1 = i2;
            if (i2 < 0) {
              i1 = this.f.d;
            }
            locala.d = i1;
            locala.b = ((Integer)k.invoke(paramCellLocation, new Object[0])).intValue();
            locala.a = ((Integer)l.invoke(paramCellLocation, new Object[0])).intValue();
            Object localObject = n.invoke(paramCellLocation, new Object[0]);
            if (((Integer)localObject).intValue() < Integer.MAX_VALUE) {
              locala.e = ((Integer)localObject).intValue();
            }
            paramCellLocation = o.invoke(paramCellLocation, new Object[0]);
            if (((Integer)paramCellLocation).intValue() >= Integer.MAX_VALUE) {
              continue;
            }
            locala.f = ((Integer)paramCellLocation).intValue();
          }
          catch (Exception paramCellLocation)
          {
            b = 3;
            return locala;
          }
          return locala;
        }
        catch (Exception paramCellLocation)
        {
          p = null;
          b = 2;
        }
      }
      if (!(paramCellLocation instanceof GsmCellLocation)) {
        continue;
      }
      locala.a = ((GsmCellLocation)paramCellLocation).getLac();
      locala.b = ((GsmCellLocation)paramCellLocation).getCid();
      locala.i = 'g';
      c(locala);
      return locala;
      i1 += 1;
    }
  }
  
  public static b a()
  {
    try
    {
      if (c == null) {
        c = new b();
      }
      b localb = c;
      return localb;
    }
    finally {}
  }
  
  private void c(a parama)
  {
    if ((parama.b()) && ((this.f == null) || (!this.f.a(parama))))
    {
      this.f = parama;
      if (!parama.b()) {
        break label152;
      }
      i1 = this.h.size();
      if (i1 != 0) {
        break label133;
      }
      parama = null;
      if ((parama == null) || (parama.b != this.f.b) || (parama.a != this.f.a))
      {
        this.h.add(this.f);
        if (this.h.size() > 3) {
          this.h.remove(0);
        }
        j();
        this.q = false;
      }
    }
    label133:
    label152:
    while (this.h == null) {
      for (;;)
      {
        int i1;
        return;
        parama = (a)this.h.get(i1 - 1);
      }
    }
    this.h.clear();
  }
  
  private String d(a parama)
  {
    localStringBuilder = new StringBuilder();
    if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() >= 17) {
      for (;;)
      {
        try
        {
          localObject1 = this.d.getAllCellInfo();
          if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
            continue;
          }
          localStringBuilder.append("&nc=");
          localObject1 = ((List)localObject1).iterator();
        }
        catch (Exception parama)
        {
          Object localObject1;
          Object localObject2;
          return localStringBuilder.toString();
          localStringBuilder.append("|" + ((a)localObject2).b + "|" + ((a)localObject2).h + ";");
          continue;
        }
        catch (NoSuchMethodError parama)
        {
          continue;
        }
        if (!((Iterator)localObject1).hasNext()) {
          continue;
        }
        localObject2 = (CellInfo)((Iterator)localObject1).next();
        if (!((CellInfo)localObject2).isRegistered())
        {
          localObject2 = a((CellInfo)localObject2);
          if ((localObject2 != null) && (((a)localObject2).a != -1) && (((a)localObject2).b != -1))
          {
            if (parama.a == ((a)localObject2).a) {
              continue;
            }
            localStringBuilder.append(((a)localObject2).a + "|" + ((a)localObject2).b + "|" + ((a)localObject2).h + ";");
          }
        }
      }
    }
  }
  
  private void i()
  {
    Object localObject = g.k();
    if (localObject == null) {}
    do
    {
      return;
      localObject = new File((String)localObject + File.separator + "lcvif.dat");
    } while (!((File)localObject).exists());
    long l1;
    try
    {
      RandomAccessFile localRandomAccessFile = new RandomAccessFile((File)localObject, "rw");
      localRandomAccessFile.seek(0L);
      l1 = localRandomAccessFile.readLong();
      if (System.currentTimeMillis() - l1 > 60000L)
      {
        localRandomAccessFile.close();
        ((File)localObject).delete();
        return;
      }
    }
    catch (Exception localException)
    {
      ((File)localObject).delete();
      return;
    }
    localException.readInt();
    int i1 = 0;
    for (;;)
    {
      int i2;
      int i3;
      int i4;
      int i5;
      int i6;
      char c1;
      if (i1 < 3)
      {
        l1 = localException.readLong();
        i2 = localException.readInt();
        i3 = localException.readInt();
        i4 = localException.readInt();
        i5 = localException.readInt();
        i6 = localException.readInt();
        c1 = '\000';
        if (i6 != 1) {
          break label243;
        }
        c1 = 'g';
      }
      label243:
      do
      {
        a locala = new a(i4, i5, i2, i3, 0, c1);
        locala.g = l1;
        if (!locala.b()) {
          break;
        }
        this.q = true;
        this.h.add(locala);
        break;
        localException.close();
        return;
        if (i6 == 2) {
          c1 = 'c';
        }
      } while (l1 != 0L);
      i1 += 1;
    }
  }
  
  private void j()
  {
    int i3 = 0;
    if ((this.h == null) && (this.g == null)) {}
    do
    {
      return;
      if ((this.h == null) && (this.g != null))
      {
        this.h = new LinkedList();
        this.h.add(this.g);
      }
      localObject = g.k();
    } while (localObject == null);
    Object localObject = new File((String)localObject + File.separator + "lcvif.dat");
    int i4 = this.h.size();
    try
    {
      if (((File)localObject).exists()) {
        ((File)localObject).delete();
      }
      ((File)localObject).createNewFile();
      localObject = new RandomAccessFile((File)localObject, "rw");
      ((RandomAccessFile)localObject).seek(0L);
      ((RandomAccessFile)localObject).writeLong(((a)this.h.get(i4 - 1)).g);
      ((RandomAccessFile)localObject).writeInt(i4);
      int i1 = 0;
      int i2;
      for (;;)
      {
        i2 = i3;
        if (i1 >= 3 - i4) {
          break;
        }
        ((RandomAccessFile)localObject).writeLong(0L);
        ((RandomAccessFile)localObject).writeInt(-1);
        ((RandomAccessFile)localObject).writeInt(-1);
        ((RandomAccessFile)localObject).writeInt(-1);
        ((RandomAccessFile)localObject).writeInt(-1);
        ((RandomAccessFile)localObject).writeInt(2);
        i1 += 1;
      }
      for (;;)
      {
        if (i2 < i4)
        {
          ((RandomAccessFile)localObject).writeLong(((a)this.h.get(i2)).g);
          ((RandomAccessFile)localObject).writeInt(((a)this.h.get(i2)).c);
          ((RandomAccessFile)localObject).writeInt(((a)this.h.get(i2)).d);
          ((RandomAccessFile)localObject).writeInt(((a)this.h.get(i2)).a);
          ((RandomAccessFile)localObject).writeInt(((a)this.h.get(i2)).b);
          if (((a)this.h.get(i2)).i == 'g') {
            ((RandomAccessFile)localObject).writeInt(1);
          } else if (((a)this.h.get(i2)).i == 'c') {
            ((RandomAccessFile)localObject).writeInt(2);
          } else {
            ((RandomAccessFile)localObject).writeInt(3);
          }
        }
        else
        {
          ((RandomAccessFile)localObject).close();
          return;
        }
        i2 += 1;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void k()
  {
    a locala = null;
    Object localObject1 = n();
    if (localObject1 != null) {
      c((a)localObject1);
    }
    if ((localObject1 == null) || (!((a)localObject1).b())) {}
    try
    {
      localObject1 = this.d.getCellLocation();
      if (localObject1 != null) {
        locala = a((CellLocation)localObject1);
      }
      if ((locala == null) || (!locala.b()))
      {
        localObject1 = l();
        if (localObject1 != null) {
          a((CellLocation)localObject1, true);
        }
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject2 = null;
      }
    }
  }
  
  /* Error */
  private CellLocation l()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 63	com/baidu/location/f/b:e	Ljava/lang/Object;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: aload_0
    //   12: invokespecial 518	com/baidu/location/f/b:m	()Ljava/lang/Class;
    //   15: astore_2
    //   16: aload_2
    //   17: aload_1
    //   18: invokevirtual 121	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   21: ifeq +174 -> 195
    //   24: aload_2
    //   25: aload_1
    //   26: invokevirtual 125	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   29: astore_3
    //   30: aload_3
    //   31: ldc_w 519
    //   34: iconst_0
    //   35: anewarray 4	java/lang/Object
    //   38: invokestatic 132	com/baidu/location/h/g:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   41: astore_1
    //   42: aload_1
    //   43: astore_2
    //   44: aload_1
    //   45: ifnonnull +22 -> 67
    //   48: aload_3
    //   49: ldc_w 519
    //   52: iconst_1
    //   53: anewarray 4	java/lang/Object
    //   56: dup
    //   57: iconst_0
    //   58: iconst_1
    //   59: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   62: aastore
    //   63: invokestatic 132	com/baidu/location/h/g:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   66: astore_2
    //   67: aload_2
    //   68: astore_1
    //   69: aload_2
    //   70: ifnonnull +22 -> 92
    //   73: aload_3
    //   74: ldc_w 521
    //   77: iconst_1
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: iconst_1
    //   84: invokestatic 183	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   87: aastore
    //   88: invokestatic 132	com/baidu/location/h/g:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   91: astore_1
    //   92: aload_1
    //   93: astore_2
    //   94: aload_1
    //   95: ifnonnull +30 -> 125
    //   98: aload_3
    //   99: ldc_w 522
    //   102: iconst_0
    //   103: anewarray 4	java/lang/Object
    //   106: invokestatic 132	com/baidu/location/h/g:a	(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;
    //   109: checkcast 85	java/util/List
    //   112: astore_1
    //   113: aload_0
    //   114: aload_1
    //   115: invokespecial 524	com/baidu/location/f/b:a	(Ljava/util/List;)Landroid/telephony/CellLocation;
    //   118: astore_1
    //   119: aload_1
    //   120: astore_2
    //   121: aload_1
    //   122: ifnull +3 -> 125
    //   125: aload_2
    //   126: ifnull +64 -> 190
    //   129: aload_2
    //   130: checkcast 526	android/telephony/CellLocation
    //   133: astore_1
    //   134: aload_1
    //   135: areturn
    //   136: astore_1
    //   137: aconst_null
    //   138: astore_1
    //   139: goto -97 -> 42
    //   142: astore_1
    //   143: aconst_null
    //   144: astore_1
    //   145: goto -103 -> 42
    //   148: astore_1
    //   149: aconst_null
    //   150: astore_1
    //   151: goto -38 -> 113
    //   154: astore_1
    //   155: aconst_null
    //   156: astore_1
    //   157: goto -44 -> 113
    //   160: astore_1
    //   161: aconst_null
    //   162: astore_1
    //   163: goto -29 -> 134
    //   166: astore_1
    //   167: aload_2
    //   168: astore_1
    //   169: goto -77 -> 92
    //   172: astore_1
    //   173: aload_2
    //   174: astore_1
    //   175: goto -83 -> 92
    //   178: astore_2
    //   179: aload_1
    //   180: astore_2
    //   181: goto -114 -> 67
    //   184: astore_2
    //   185: aload_1
    //   186: astore_2
    //   187: goto -120 -> 67
    //   190: aconst_null
    //   191: astore_1
    //   192: goto -58 -> 134
    //   195: aconst_null
    //   196: astore_2
    //   197: goto -72 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	b
    //   4	131	1	localObject1	Object
    //   136	1	1	localNoSuchMethodException1	NoSuchMethodException
    //   138	1	1	localObject2	Object
    //   142	1	1	localException1	Exception
    //   144	1	1	localObject3	Object
    //   148	1	1	localNoSuchMethodException2	NoSuchMethodException
    //   150	1	1	localObject4	Object
    //   154	1	1	localException2	Exception
    //   156	1	1	localObject5	Object
    //   160	1	1	localException3	Exception
    //   162	1	1	localObject6	Object
    //   166	1	1	localException4	Exception
    //   168	1	1	localObject7	Object
    //   172	1	1	localNoSuchMethodException3	NoSuchMethodException
    //   174	18	1	localObject8	Object
    //   15	159	2	localObject9	Object
    //   178	1	2	localException5	Exception
    //   180	1	2	localObject10	Object
    //   184	1	2	localNoSuchMethodException4	NoSuchMethodException
    //   186	11	2	localObject11	Object
    //   29	70	3	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   30	42	136	java/lang/NoSuchMethodException
    //   30	42	142	java/lang/Exception
    //   98	113	148	java/lang/NoSuchMethodException
    //   98	113	154	java/lang/Exception
    //   11	30	160	java/lang/Exception
    //   113	119	160	java/lang/Exception
    //   129	134	160	java/lang/Exception
    //   73	92	166	java/lang/Exception
    //   73	92	172	java/lang/NoSuchMethodException
    //   48	67	178	java/lang/Exception
    //   48	67	184	java/lang/NoSuchMethodException
  }
  
  private Class<?> m()
  {
    ClassLoader localClassLoader = ClassLoader.getSystemClassLoader();
    Object localObject;
    switch (o())
    {
    default: 
      localObject = null;
    }
    for (;;)
    {
      try
      {
        localObject = localClassLoader.loadClass((String)localObject);
        return (Class<?>)localObject;
      }
      catch (Exception localException) {}
      localObject = "android.telephony.MSimTelephonyManager";
      continue;
      localObject = "android.telephony.TelephonyManager2";
      continue;
      localObject = "android.telephony.TelephonyManager";
    }
    return null;
  }
  
  private a n()
  {
    if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() < 17) {
      return null;
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        List localList = this.d.getAllCellInfo();
        if ((localList != null) && (localList.size() > 0))
        {
          Iterator localIterator = localList.iterator();
          localList = null;
          localObject2 = localList;
          if (localIterator.hasNext())
          {
            localObject2 = (CellInfo)localIterator.next();
            if (!((CellInfo)localObject2).isRegistered()) {
              break label138;
            }
            int i1 = 0;
            if (localList != null) {
              i1 = 1;
            }
            a locala = a((CellInfo)localObject2);
            if (locala == null) {
              continue;
            }
            if (!locala.b())
            {
              localObject2 = null;
              break label143;
            }
            localObject2 = locala;
            if (i1 == 0) {
              break label143;
            }
            localList.j = locala.j();
            return localList;
          }
        }
        else
        {
          localObject2 = null;
        }
        return (a)localObject2;
      }
      catch (NoSuchMethodError localNoSuchMethodError)
      {
        return null;
      }
      catch (Exception localException)
      {
        return null;
      }
      label138:
      label143:
      do
      {
        localObject2 = localException;
        break;
      } while (localException != null);
      Object localObject1 = localObject2;
    }
  }
  
  private int o()
  {
    int i1 = 0;
    try
    {
      Class.forName("android.telephony.MSimTelephonyManager");
      i1 = 1;
    }
    catch (Exception localException2)
    {
      int i2;
      for (;;) {}
    }
    i2 = i1;
    if (i1 == 0) {}
    try
    {
      Class.forName("android.telephony.TelephonyManager2");
      i2 = 2;
      return i2;
    }
    catch (Exception localException1)
    {
      return i1;
    }
  }
  
  public String a(a parama)
  {
    Object localObject1;
    for (;;)
    {
      try
      {
        Object localObject2 = d(parama);
        if ((localObject2 != null) && (!((String)localObject2).equals("")) && (!((String)localObject2).equals("&nc="))) {
          return (String)localObject2;
        }
        localObject3 = this.d.getNeighboringCellInfo();
        localObject1 = localObject2;
        if (localObject3 == null) {
          continue;
        }
        localObject1 = localObject2;
        if (((List)localObject3).isEmpty()) {
          continue;
        }
        localObject1 = "&nc=";
        localObject2 = ((List)localObject3).iterator();
        i1 = 0;
        if (!((Iterator)localObject2).hasNext()) {
          continue;
        }
        localObject3 = (NeighboringCellInfo)((Iterator)localObject2).next();
        int i2 = ((NeighboringCellInfo)localObject3).getLac();
        if ((i2 == -1) || (((NeighboringCellInfo)localObject3).getCid() == -1)) {
          continue;
        }
        if (parama.a == i2) {
          continue;
        }
        localObject1 = (String)localObject1 + i2 + "|" + ((NeighboringCellInfo)localObject3).getCid() + "|" + ((NeighboringCellInfo)localObject3).getRssi() + ";";
      }
      catch (Exception parama)
      {
        Object localObject3;
        int i1;
        parama.printStackTrace();
        localObject1 = "";
        continue;
        continue;
        continue;
      }
      i1 += 1;
      if (i1 >= 8)
      {
        if ((localObject1 == null) || (!((String)localObject1).equals("&nc="))) {
          break label294;
        }
        return null;
        localObject1 = (String)localObject1 + "|" + ((NeighboringCellInfo)localObject3).getCid() + "|" + ((NeighboringCellInfo)localObject3).getRssi() + ";";
      }
    }
    label294:
    return (String)localObject1;
  }
  
  public String b(a parama)
  {
    StringBuffer localStringBuffer = new StringBuffer(128);
    localStringBuffer.append("&nw=");
    localStringBuffer.append(parama.i);
    localStringBuffer.append(String.format(Locale.CHINA, "&cl=%d|%d|%d|%d&cl_s=%d", new Object[] { Integer.valueOf(parama.c), Integer.valueOf(parama.d), Integer.valueOf(parama.a), Integer.valueOf(parama.b), Integer.valueOf(parama.h) }));
    if ((parama.e < Integer.MAX_VALUE) && (parama.f < Integer.MAX_VALUE)) {
      localStringBuffer.append(String.format(Locale.CHINA, "&cdmall=%.6f|%.6f", new Object[] { Double.valueOf(parama.f / 14400.0D), Double.valueOf(parama.e / 14400.0D) }));
    }
    localStringBuffer.append("&cl_t=");
    localStringBuffer.append(parama.g);
    if ((this.h != null) && (this.h.size() > 0))
    {
      i2 = this.h.size();
      localStringBuffer.append("&clt=");
      i1 = 0;
      while (i1 < i2)
      {
        a locala = (a)this.h.get(i1);
        if (locala.c != parama.c) {
          localStringBuffer.append(locala.c);
        }
        localStringBuffer.append("|");
        if (locala.d != parama.d) {
          localStringBuffer.append(locala.d);
        }
        localStringBuffer.append("|");
        if (locala.a != parama.a) {
          localStringBuffer.append(locala.a);
        }
        localStringBuffer.append("|");
        if (locala.b != parama.b) {
          localStringBuffer.append(locala.b);
        }
        localStringBuffer.append("|");
        localStringBuffer.append((System.currentTimeMillis() - locala.g) / 1000L);
        localStringBuffer.append(";");
        i1 += 1;
      }
    }
    if (a > 100) {
      a = 0;
    }
    int i1 = b;
    int i2 = a;
    localStringBuffer.append("&cs=" + ((i1 << 8) + i2));
    if (parama.j != null) {
      localStringBuffer.append(parama.j);
    }
    return localStringBuffer.toString();
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 76	com/baidu/location/f/b:j	Z
    //   6: istore_2
    //   7: iload_2
    //   8: iconst_1
    //   9: if_icmpne +6 -> 15
    //   12: aload_0
    //   13: monitorexit
    //   14: return
    //   15: getstatic 612	com/baidu/location/f:isServing	Z
    //   18: ifeq -6 -> 12
    //   21: aload_0
    //   22: invokestatic 616	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   25: ldc_w 618
    //   28: invokevirtual 624	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   31: checkcast 294	android/telephony/TelephonyManager
    //   34: putfield 61	com/baidu/location/f/b:d	Landroid/telephony/TelephonyManager;
    //   37: aload_0
    //   38: new 489	java/util/LinkedList
    //   41: dup
    //   42: invokespecial 490	java/util/LinkedList:<init>	()V
    //   45: putfield 72	com/baidu/location/f/b:h	Ljava/util/List;
    //   48: aload_0
    //   49: new 6	com/baidu/location/f/b$a
    //   52: dup
    //   53: aload_0
    //   54: invokespecial 626	com/baidu/location/f/b$a:<init>	(Lcom/baidu/location/f/b;)V
    //   57: putfield 74	com/baidu/location/f/b:i	Lcom/baidu/location/f/b$a;
    //   60: aload_0
    //   61: invokespecial 628	com/baidu/location/f/b:i	()V
    //   64: aload_0
    //   65: getfield 61	com/baidu/location/f/b:d	Landroid/telephony/TelephonyManager;
    //   68: ifnull -56 -> 12
    //   71: aload_0
    //   72: getfield 74	com/baidu/location/f/b:i	Lcom/baidu/location/f/b$a;
    //   75: astore_3
    //   76: aload_3
    //   77: ifnull -65 -> 12
    //   80: aload_0
    //   81: getfield 61	com/baidu/location/f/b:d	Landroid/telephony/TelephonyManager;
    //   84: aload_0
    //   85: getfield 74	com/baidu/location/f/b:i	Lcom/baidu/location/f/b$a;
    //   88: sipush 272
    //   91: invokevirtual 632	android/telephony/TelephonyManager:listen	(Landroid/telephony/PhoneStateListener;I)V
    //   94: aload_0
    //   95: invokespecial 528	com/baidu/location/f/b:o	()I
    //   98: istore_1
    //   99: iload_1
    //   100: tableswitch	default:+28->128, 0:+82->182, 1:+41->141, 2:+66->166
    //   128: aload_0
    //   129: iconst_1
    //   130: putfield 76	com/baidu/location/f/b:j	Z
    //   133: goto -121 -> 12
    //   136: astore_3
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_3
    //   140: athrow
    //   141: aload_0
    //   142: invokestatic 616	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   145: ldc_w 634
    //   148: invokestatic 637	com/baidu/location/h/g:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;
    //   151: putfield 63	com/baidu/location/f/b:e	Ljava/lang/Object;
    //   154: goto -26 -> 128
    //   157: astore_3
    //   158: aload_0
    //   159: aconst_null
    //   160: putfield 63	com/baidu/location/f/b:e	Ljava/lang/Object;
    //   163: goto -35 -> 128
    //   166: aload_0
    //   167: invokestatic 616	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   170: ldc_w 639
    //   173: invokestatic 637	com/baidu/location/h/g:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;
    //   176: putfield 63	com/baidu/location/f/b:e	Ljava/lang/Object;
    //   179: goto -51 -> 128
    //   182: aload_0
    //   183: invokestatic 616	com/baidu/location/f:getServiceContext	()Landroid/content/Context;
    //   186: ldc_w 639
    //   189: invokestatic 637	com/baidu/location/h/g:a	(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Object;
    //   192: putfield 63	com/baidu/location/f/b:e	Ljava/lang/Object;
    //   195: goto -67 -> 128
    //   198: astore_3
    //   199: goto -105 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	this	b
    //   98	2	1	i1	int
    //   6	4	2	bool	boolean
    //   75	2	3	locala	a
    //   136	4	3	localObject	Object
    //   157	1	3	localThrowable	Throwable
    //   198	1	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	7	136	finally
    //   15	76	136	finally
    //   80	94	136	finally
    //   94	99	136	finally
    //   128	133	136	finally
    //   141	154	136	finally
    //   158	163	136	finally
    //   166	179	136	finally
    //   182	195	136	finally
    //   94	99	157	java/lang/Throwable
    //   141	154	157	java/lang/Throwable
    //   166	179	157	java/lang/Throwable
    //   182	195	157	java/lang/Throwable
    //   80	94	198	java/lang/Exception
  }
  
  /* Error */
  public void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 76	com/baidu/location/f/b:j	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 74	com/baidu/location/f/b:i	Lcom/baidu/location/f/b$a;
    //   18: ifnull +22 -> 40
    //   21: aload_0
    //   22: getfield 61	com/baidu/location/f/b:d	Landroid/telephony/TelephonyManager;
    //   25: ifnull +15 -> 40
    //   28: aload_0
    //   29: getfield 61	com/baidu/location/f/b:d	Landroid/telephony/TelephonyManager;
    //   32: aload_0
    //   33: getfield 74	com/baidu/location/f/b:i	Lcom/baidu/location/f/b$a;
    //   36: iconst_0
    //   37: invokevirtual 632	android/telephony/TelephonyManager:listen	(Landroid/telephony/PhoneStateListener;I)V
    //   40: aload_0
    //   41: aconst_null
    //   42: putfield 74	com/baidu/location/f/b:i	Lcom/baidu/location/f/b$a;
    //   45: aload_0
    //   46: aconst_null
    //   47: putfield 61	com/baidu/location/f/b:d	Landroid/telephony/TelephonyManager;
    //   50: aload_0
    //   51: getfield 72	com/baidu/location/f/b:h	Ljava/util/List;
    //   54: invokeinterface 399 1 0
    //   59: aload_0
    //   60: aconst_null
    //   61: putfield 72	com/baidu/location/f/b:h	Ljava/util/List;
    //   64: aload_0
    //   65: invokespecial 396	com/baidu/location/f/b:j	()V
    //   68: aload_0
    //   69: iconst_0
    //   70: putfield 76	com/baidu/location/f/b:j	Z
    //   73: goto -62 -> 11
    //   76: astore_2
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_2
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	b
    //   6	2	1	bool	boolean
    //   76	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	76	finally
    //   14	40	76	finally
    //   40	73	76	finally
  }
  
  public boolean d()
  {
    return this.q;
  }
  
  public int e()
  {
    if (this.d == null) {
      return 0;
    }
    try
    {
      int i1 = this.d.getNetworkType();
      return i1;
    }
    catch (Exception localException) {}
    return 0;
  }
  
  public a f()
  {
    if (((this.f == null) || (!this.f.a()) || (!this.f.b())) && (this.d != null)) {}
    try
    {
      k();
      if (this.f.e())
      {
        this.g = null;
        this.g = new a(this.f.a, this.f.b, this.f.c, this.f.d, this.f.h, this.f.i);
      }
      if ((this.f.d()) && (this.g != null) && (this.f.i == 'g'))
      {
        this.f.d = this.g.d;
        this.f.c = this.g.c;
      }
      return this.f;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public String g()
  {
    int i2 = -1;
    int i1 = i2;
    try
    {
      if (this.d != null) {
        i1 = this.d.getSimState();
      }
      return "&sim=" + i1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        i1 = i2;
      }
    }
  }
  
  public int h()
  {
    Object localObject1 = (TelephonyManager)f.getServiceContext().getSystemService("phone");
    try
    {
      localObject1 = ((TelephonyManager)localObject1).getSubscriberId();
      if (localObject1 != null) {
        if ((((String)localObject1).startsWith("46000")) || (((String)localObject1).startsWith("46002")) || (((String)localObject1).startsWith("46007"))) {
          return 1;
        }
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      for (;;)
      {
        localObject2 = null;
      }
      if (((String)localObject2).startsWith("46001")) {
        return 2;
      }
      if (((String)localObject2).startsWith("46003")) {
        return 3;
      }
    }
    return 0;
  }
  
  private class a
    extends PhoneStateListener
  {
    public a() {}
    
    public void onCellLocationChanged(CellLocation paramCellLocation)
    {
      if (paramCellLocation == null) {
        return;
      }
      try
      {
        b.a(b.this);
        com.baidu.location.b.b.a().e();
        return;
      }
      catch (Exception paramCellLocation)
      {
        for (;;) {}
      }
    }
    
    public void onSignalStrengthsChanged(SignalStrength paramSignalStrength)
    {
      if (b.b(b.this) != null)
      {
        if (b.b(b.this).i != 'g') {
          break label40;
        }
        b.b(b.this).h = paramSignalStrength.getGsmSignalStrength();
      }
      label40:
      while (b.b(b.this).i != 'c') {
        return;
      }
      b.b(b.this).h = paramSignalStrength.getCdmaDbm();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/f/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */