package com.baidu.location.indoor;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.Handler;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class c
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static c b = null;
  private Context c;
  private boolean d = false;
  private boolean e = false;
  private BluetoothAdapter f;
  private boolean g = false;
  private a h;
  private HashMap<String, ScanResult> i = new HashMap();
  private Handler j = new Handler();
  private Runnable k = new Runnable()
  {
    public void run()
    {
      try
      {
        c.a(c.this, c.a(c.this));
        if ((c.b(c.this) != null) && (c.b(c.this).isEnabled())) {
          c.this.a(false);
        }
        c.a(c.this).clear();
        return;
      }
      catch (Exception localException)
      {
        for (;;) {}
      }
    }
  };
  private Object l = null;
  
  private c(Context paramContext)
  {
    this.c = paramContext;
    if (this.f == null)
    {
      if (Build.VERSION.SDK_INT > 18)
      {
        this.f = ((BluetoothManager)paramContext.getSystemService("bluetooth")).getAdapter();
        this.g = this.c.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
      }
    }
    else {
      return;
    }
    this.f = BluetoothAdapter.getDefaultAdapter();
  }
  
  public static c a(Context paramContext)
  {
    if (b == null) {
      b = new c(paramContext);
    }
    return b;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int m = 0;
    while (m < paramArrayOfByte.length)
    {
      int n = paramArrayOfByte[m] & 0xFF;
      arrayOfChar[(m * 2)] = a[(n >>> 4)];
      arrayOfChar[(m * 2 + 1)] = a[(n & 0xF)];
      m += 1;
    }
    return new String(arrayOfChar);
  }
  
  private void a(HashMap<String, ScanResult> paramHashMap)
  {
    boolean bool = false;
    Object localObject1 = new ArrayList(paramHashMap.values());
    paramHashMap = new ArrayList();
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (ScanResult)((Iterator)localObject1).next();
      ((ScanResult)localObject2).getScanRecord().getAdvertiseFlags();
      byte[] arrayOfByte = ((ScanResult)localObject2).getScanRecord().getBytes();
      if (arrayOfByte.length >= 26)
      {
        String str = a(Arrays.copyOfRange(arrayOfByte, 9, 25));
        paramHashMap.add(str);
        localHashMap1.put(str, ((ScanResult)localObject2).getDevice().getName());
        localHashMap2.put(str, a(Arrays.copyOfRange(arrayOfByte, 0, 9)));
        if (localHashMap3.get(str) == null) {
          localHashMap3.put(str, Integer.valueOf(0));
        }
        localHashMap3.put(str, Integer.valueOf(((Integer)localHashMap3.get(str)).intValue() + 1));
      }
    }
    paramHashMap = null;
    Object localObject2 = localHashMap3.keySet().iterator();
    int m = 0;
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = (String)((Iterator)localObject2).next();
      if (((Integer)localHashMap3.get(localObject1)).intValue() <= m) {
        break label336;
      }
      m = ((Integer)localHashMap3.get(localObject1)).intValue();
      paramHashMap = (HashMap<String, ScanResult>)localObject1;
    }
    label336:
    for (;;)
    {
      break;
      if (m > 3) {
        bool = true;
      }
      if (this.h != null) {
        this.h.a(bool, paramHashMap, (String)localHashMap1.get(paramHashMap), (String)localHashMap2.get(paramHashMap));
      }
      return;
    }
  }
  
  /* Error */
  private boolean c()
  {
    // Byte code:
    //   0: new 238	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: getfield 85	com/baidu/location/indoor/c:c	Landroid/content/Context;
    //   8: invokevirtual 242	android/content/Context:getCacheDir	()Ljava/io/File;
    //   11: ldc -12
    //   13: invokespecial 247	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   16: astore 6
    //   18: aload 6
    //   20: invokevirtual 250	java/io/File:exists	()Z
    //   23: ifne +5 -> 28
    //   26: iconst_0
    //   27: ireturn
    //   28: aconst_null
    //   29: astore 5
    //   31: aconst_null
    //   32: astore 7
    //   34: new 252	java/io/BufferedReader
    //   37: dup
    //   38: new 254	java/io/FileReader
    //   41: dup
    //   42: aload 6
    //   44: invokespecial 257	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   47: invokespecial 260	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   50: astore 8
    //   52: ldc_w 262
    //   55: astore 6
    //   57: aload 7
    //   59: astore 5
    //   61: aload 8
    //   63: invokevirtual 265	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   66: astore 7
    //   68: aload 7
    //   70: ifnull +36 -> 106
    //   73: aload 7
    //   75: astore 5
    //   77: new 267	java/lang/StringBuilder
    //   80: dup
    //   81: invokespecial 268	java/lang/StringBuilder:<init>	()V
    //   84: aload 6
    //   86: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload 7
    //   91: invokevirtual 272	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 275	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: astore 6
    //   99: aload 7
    //   101: astore 5
    //   103: goto -42 -> 61
    //   106: aload 8
    //   108: invokevirtual 278	java/io/BufferedReader:close	()V
    //   111: aload 6
    //   113: ifnull -87 -> 26
    //   116: aload 6
    //   118: invokevirtual 281	java/lang/String:trim	()Ljava/lang/String;
    //   121: ldc_w 262
    //   124: invokevirtual 284	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   127: ifne -101 -> 26
    //   130: aload 6
    //   132: invokestatic 289	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   135: invokevirtual 293	java/lang/Long:longValue	()J
    //   138: lstore_1
    //   139: invokestatic 298	java/lang/System:currentTimeMillis	()J
    //   142: lstore_3
    //   143: lload_3
    //   144: lload_1
    //   145: lsub
    //   146: ldc2_w 299
    //   149: lcmp
    //   150: ifge -124 -> 26
    //   153: iconst_1
    //   154: ireturn
    //   155: astore 6
    //   157: aload 6
    //   159: invokevirtual 303	java/lang/Exception:printStackTrace	()V
    //   162: aload 5
    //   164: astore 6
    //   166: goto -55 -> 111
    //   169: astore 5
    //   171: iconst_0
    //   172: ireturn
    //   173: astore 7
    //   175: aload 6
    //   177: astore 5
    //   179: aload 7
    //   181: astore 6
    //   183: goto -26 -> 157
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	this	c
    //   138	7	1	l1	long
    //   142	2	3	l2	long
    //   29	134	5	localObject1	Object
    //   169	1	5	localException1	Exception
    //   177	1	5	localObject2	Object
    //   16	115	6	localObject3	Object
    //   155	3	6	localException2	Exception
    //   164	18	6	localObject4	Object
    //   32	68	7	str	String
    //   173	7	7	localException3	Exception
    //   50	57	8	localBufferedReader	java.io.BufferedReader
    // Exception table:
    //   from	to	target	type
    //   34	52	155	java/lang/Exception
    //   61	68	155	java/lang/Exception
    //   77	99	155	java/lang/Exception
    //   130	143	169	java/lang/Exception
    //   106	111	173	java/lang/Exception
  }
  
  private void d()
  {
    Object localObject = new File(this.c.getCacheDir(), "ibct");
    try
    {
      localObject = new FileWriter((File)localObject);
      ((FileWriter)localObject).write(System.currentTimeMillis() + "");
      ((FileWriter)localObject).flush();
      ((FileWriter)localObject).close();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.f == null) {}
    for (;;)
    {
      return;
      try
      {
        if (Build.VERSION.SDK_INT >= 21)
        {
          if (paramBoolean)
          {
            this.l = new ScanCallback()
            {
              public void onScanResult(int paramAnonymousInt, ScanResult paramAnonymousScanResult)
              {
                if (c.a(c.this) != null) {
                  c.a(c.this).put(paramAnonymousScanResult.getDevice().getAddress(), paramAnonymousScanResult);
                }
              }
            };
            this.f.getBluetoothLeScanner().startScan((ScanCallback)this.l);
            this.j.postDelayed(this.k, 5000L);
            this.d = true;
            return;
          }
          if (this.h != null) {
            this.f.getBluetoothLeScanner().stopScan((ScanCallback)this.l);
          }
          this.d = false;
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
  
  public boolean a()
  {
    if ((this.f == null) || (!this.g)) {
      return false;
    }
    return this.f.isEnabled();
  }
  
  public boolean a(a parama)
  {
    if (this.d) {}
    do
    {
      do
      {
        return false;
      } while (this.e);
      this.e = true;
    } while ((!a()) || (c()));
    d();
    this.h = parama;
    a(true);
    return true;
  }
  
  public void b()
  {
    this.e = false;
    this.d = false;
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, String paramString1, String paramString2, String paramString3);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/indoor/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */