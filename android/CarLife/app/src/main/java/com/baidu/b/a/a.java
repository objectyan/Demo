package com.baidu.b.a;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class a
{
  private static Method e = null;
  private static Method f = null;
  private static Method g = null;
  private static Class<?> h = null;
  private static char[] r = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();
  private final long a = 5000L;
  private Context b = null;
  private TelephonyManager c = null;
  private b d = new b(null);
  private WifiManager i = null;
  private a j = null;
  private Object k = null;
  private Method l = null;
  private boolean m = true;
  private long n = 0L;
  private String o = null;
  private int p = 0;
  private String q = null;
  
  public a(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    String str = this.b.getPackageName();
    try
    {
      this.c = ((TelephonyManager)this.b.getSystemService("phone"));
      paramContext = this.c.getDeviceId();
      this.q = ("&" + str + "&" + paramContext);
      this.i = ((WifiManager)this.b.getSystemService("wifi"));
      try
      {
        paramContext = Class.forName("android.net.wifi.WifiManager").getDeclaredField("mService");
        if (paramContext == null) {
          return;
        }
        paramContext.setAccessible(true);
        this.k = paramContext.get(this.i);
        this.l = this.k.getClass().getDeclaredMethod("startScan", new Class[] { Boolean.TYPE });
        if (this.l != null)
        {
          this.l.setAccessible(true);
          return;
        }
      }
      catch (Exception paramContext) {}
      return;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext = null;
      }
    }
  }
  
  private static String a(String paramString)
  {
    int i4 = 0;
    if (paramString == null) {
      return null;
    }
    paramString = paramString.getBytes();
    int i1 = (byte)new Random().nextInt(255);
    int i2 = (byte)new Random().nextInt(255);
    byte[] arrayOfByte = new byte[paramString.length + 2];
    int i5 = paramString.length;
    int i3 = 0;
    while (i4 < i5)
    {
      arrayOfByte[i3] = ((byte)(paramString[i4] ^ i1));
      i4 += 1;
      i3 += 1;
    }
    i4 = i3 + 1;
    arrayOfByte[i3] = i1;
    arrayOfByte[i4] = i2;
    return a(arrayOfByte);
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar1 = new char[(paramArrayOfByte.length + 2) / 3 * 4];
    int i1 = 0;
    int i2 = 0;
    int i4;
    if (i2 < paramArrayOfByte.length)
    {
      i4 = (paramArrayOfByte[i2] & 0xFF) << 8;
      if (i2 + 1 >= paramArrayOfByte.length) {
        break label239;
      }
      i4 |= paramArrayOfByte[(i2 + 1)] & 0xFF;
    }
    label110:
    label217:
    label239:
    for (int i3 = 1;; i3 = 0)
    {
      i4 <<= 8;
      if (i2 + 2 < paramArrayOfByte.length) {
        i4 |= paramArrayOfByte[(i2 + 2)] & 0xFF;
      }
      for (int i5 = 1;; i5 = 0)
      {
        char[] arrayOfChar2 = r;
        if (i5 != 0)
        {
          i5 = 63 - (i4 & 0x3F);
          arrayOfChar1[(i1 + 3)] = arrayOfChar2[i5];
          i4 >>= 6;
          arrayOfChar2 = r;
          if (i3 == 0) {
            break label217;
          }
        }
        for (i3 = 63 - (i4 & 0x3F);; i3 = 64)
        {
          arrayOfChar1[(i1 + 2)] = arrayOfChar2[i3];
          i3 = i4 >> 6;
          arrayOfChar1[(i1 + 1)] = r[(63 - (i3 & 0x3F))];
          arrayOfChar1[(i1 + 0)] = r[(63 - (i3 >> 6 & 0x3F))];
          i2 += 3;
          i1 += 4;
          break;
          i5 = 64;
          break label110;
        }
        return new String(arrayOfChar1);
      }
    }
  }
  
  /* Error */
  private void a(android.telephony.CellLocation paramCellLocation)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 4
    //   5: aload_1
    //   6: ifnull +10 -> 16
    //   9: aload_0
    //   10: getfield 77	com/baidu/b/a/a:c	Landroid/telephony/TelephonyManager;
    //   13: ifnonnull +4 -> 17
    //   16: return
    //   17: new 11	com/baidu/b/a/a$b
    //   20: dup
    //   21: aload_0
    //   22: aconst_null
    //   23: invokespecial 80	com/baidu/b/a/a$b:<init>	(Lcom/baidu/b/a/a;Lcom/baidu/b/a/a$1;)V
    //   26: astore 6
    //   28: aload_0
    //   29: getfield 77	com/baidu/b/a/a:c	Landroid/telephony/TelephonyManager;
    //   32: invokevirtual 202	android/telephony/TelephonyManager:getNetworkOperator	()Ljava/lang/String;
    //   35: astore 7
    //   37: aload 7
    //   39: ifnull +135 -> 174
    //   42: aload 7
    //   44: invokevirtual 206	java/lang/String:length	()I
    //   47: ifle +127 -> 174
    //   50: aload 7
    //   52: invokevirtual 206	java/lang/String:length	()I
    //   55: iconst_3
    //   56: if_icmplt +40 -> 96
    //   59: aload 7
    //   61: iconst_0
    //   62: iconst_3
    //   63: invokevirtual 210	java/lang/String:substring	(II)Ljava/lang/String;
    //   66: invokestatic 216	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   69: invokevirtual 219	java/lang/Integer:intValue	()I
    //   72: istore 5
    //   74: iload 5
    //   76: istore_2
    //   77: iload 5
    //   79: ifge +11 -> 90
    //   82: aload_0
    //   83: getfield 82	com/baidu/b/a/a:d	Lcom/baidu/b/a/a$b;
    //   86: getfield 221	com/baidu/b/a/a$b:c	I
    //   89: istore_2
    //   90: aload 6
    //   92: iload_2
    //   93: putfield 221	com/baidu/b/a/a$b:c	I
    //   96: aload 7
    //   98: iconst_3
    //   99: invokevirtual 224	java/lang/String:substring	(I)Ljava/lang/String;
    //   102: astore 7
    //   104: aload 7
    //   106: ifnull +34 -> 140
    //   109: aload 7
    //   111: invokevirtual 60	java/lang/String:toCharArray	()[C
    //   114: astore 8
    //   116: iload 4
    //   118: istore_2
    //   119: iload_2
    //   120: istore_3
    //   121: iload_2
    //   122: aload 8
    //   124: arraylength
    //   125: if_icmpge +15 -> 140
    //   128: aload 8
    //   130: iload_2
    //   131: caload
    //   132: invokestatic 230	java/lang/Character:isDigit	(C)Z
    //   135: ifne +92 -> 227
    //   138: iload_2
    //   139: istore_3
    //   140: aload 7
    //   142: iconst_0
    //   143: iload_3
    //   144: invokevirtual 210	java/lang/String:substring	(II)Ljava/lang/String;
    //   147: invokestatic 216	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   150: invokevirtual 219	java/lang/Integer:intValue	()I
    //   153: istore_3
    //   154: iload_3
    //   155: istore_2
    //   156: iload_3
    //   157: ifge +11 -> 168
    //   160: aload_0
    //   161: getfield 82	com/baidu/b/a/a:d	Lcom/baidu/b/a/a$b;
    //   164: getfield 232	com/baidu/b/a/a$b:d	I
    //   167: istore_2
    //   168: aload 6
    //   170: iload_2
    //   171: putfield 232	com/baidu/b/a/a$b:d	I
    //   174: aload_1
    //   175: instanceof 234
    //   178: ifeq +56 -> 234
    //   181: aload 6
    //   183: aload_1
    //   184: checkcast 234	android/telephony/gsm/GsmCellLocation
    //   187: invokevirtual 237	android/telephony/gsm/GsmCellLocation:getLac	()I
    //   190: putfield 239	com/baidu/b/a/a$b:a	I
    //   193: aload 6
    //   195: aload_1
    //   196: checkcast 234	android/telephony/gsm/GsmCellLocation
    //   199: invokevirtual 242	android/telephony/gsm/GsmCellLocation:getCid	()I
    //   202: putfield 244	com/baidu/b/a/a$b:b	I
    //   205: aload 6
    //   207: bipush 103
    //   209: putfield 247	com/baidu/b/a/a$b:e	C
    //   212: aload 6
    //   214: invokestatic 250	com/baidu/b/a/a$b:a	(Lcom/baidu/b/a/a$b;)Z
    //   217: ifeq -201 -> 16
    //   220: aload_0
    //   221: aload 6
    //   223: putfield 82	com/baidu/b/a/a:d	Lcom/baidu/b/a/a$b;
    //   226: return
    //   227: iload_2
    //   228: iconst_1
    //   229: iadd
    //   230: istore_2
    //   231: goto -112 -> 119
    //   234: aload_1
    //   235: instanceof 252
    //   238: ifeq -26 -> 212
    //   241: aload 6
    //   243: bipush 119
    //   245: putfield 247	com/baidu/b/a/a$b:e	C
    //   248: getstatic 52	com/baidu/b/a/a:h	Ljava/lang/Class;
    //   251: ifnonnull +59 -> 310
    //   254: ldc -2
    //   256: invokestatic 145	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   259: putstatic 52	com/baidu/b/a/a:h	Ljava/lang/Class;
    //   262: getstatic 52	com/baidu/b/a/a:h	Ljava/lang/Class;
    //   265: ldc_w 256
    //   268: iconst_0
    //   269: anewarray 141	java/lang/Class
    //   272: invokevirtual 259	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   275: putstatic 46	com/baidu/b/a/a:e	Ljava/lang/reflect/Method;
    //   278: getstatic 52	com/baidu/b/a/a:h	Ljava/lang/Class;
    //   281: ldc_w 261
    //   284: iconst_0
    //   285: anewarray 141	java/lang/Class
    //   288: invokevirtual 259	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   291: putstatic 48	com/baidu/b/a/a:f	Ljava/lang/reflect/Method;
    //   294: getstatic 52	com/baidu/b/a/a:h	Ljava/lang/Class;
    //   297: ldc_w 263
    //   300: iconst_0
    //   301: anewarray 141	java/lang/Class
    //   304: invokevirtual 259	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   307: putstatic 50	com/baidu/b/a/a:g	Ljava/lang/reflect/Method;
    //   310: getstatic 52	com/baidu/b/a/a:h	Ljava/lang/Class;
    //   313: ifnull -101 -> 212
    //   316: getstatic 52	com/baidu/b/a/a:h	Ljava/lang/Class;
    //   319: aload_1
    //   320: invokevirtual 267	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   323: ifeq -111 -> 212
    //   326: getstatic 50	com/baidu/b/a/a:g	Ljava/lang/reflect/Method;
    //   329: aload_1
    //   330: iconst_0
    //   331: anewarray 4	java/lang/Object
    //   334: invokevirtual 271	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   337: checkcast 212	java/lang/Integer
    //   340: invokevirtual 219	java/lang/Integer:intValue	()I
    //   343: istore_3
    //   344: iload_3
    //   345: istore_2
    //   346: iload_3
    //   347: ifge +11 -> 358
    //   350: aload_0
    //   351: getfield 82	com/baidu/b/a/a:d	Lcom/baidu/b/a/a$b;
    //   354: getfield 232	com/baidu/b/a/a$b:d	I
    //   357: istore_2
    //   358: aload 6
    //   360: iload_2
    //   361: putfield 232	com/baidu/b/a/a$b:d	I
    //   364: aload 6
    //   366: getstatic 46	com/baidu/b/a/a:e	Ljava/lang/reflect/Method;
    //   369: aload_1
    //   370: iconst_0
    //   371: anewarray 4	java/lang/Object
    //   374: invokevirtual 271	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   377: checkcast 212	java/lang/Integer
    //   380: invokevirtual 219	java/lang/Integer:intValue	()I
    //   383: putfield 244	com/baidu/b/a/a$b:b	I
    //   386: aload 6
    //   388: getstatic 48	com/baidu/b/a/a:f	Ljava/lang/reflect/Method;
    //   391: aload_1
    //   392: iconst_0
    //   393: anewarray 4	java/lang/Object
    //   396: invokevirtual 271	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   399: checkcast 212	java/lang/Integer
    //   402: invokevirtual 219	java/lang/Integer:intValue	()I
    //   405: putfield 239	com/baidu/b/a/a$b:a	I
    //   408: goto -196 -> 212
    //   411: astore_1
    //   412: return
    //   413: astore_1
    //   414: aconst_null
    //   415: putstatic 52	com/baidu/b/a/a:h	Ljava/lang/Class;
    //   418: return
    //   419: astore 7
    //   421: goto -247 -> 174
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	424	0	this	a
    //   0	424	1	paramCellLocation	android.telephony.CellLocation
    //   76	285	2	i1	int
    //   1	346	3	i2	int
    //   3	114	4	i3	int
    //   72	6	5	i4	int
    //   26	361	6	localb	b
    //   35	106	7	str	String
    //   419	1	7	localException	Exception
    //   114	15	8	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   326	344	411	java/lang/Exception
    //   350	358	411	java/lang/Exception
    //   358	408	411	java/lang/Exception
    //   254	310	413	java/lang/Exception
    //   50	74	419	java/lang/Exception
    //   82	90	419	java/lang/Exception
    //   90	96	419	java/lang/Exception
    //   96	104	419	java/lang/Exception
    //   109	116	419	java/lang/Exception
    //   121	138	419	java/lang/Exception
    //   140	154	419	java/lang/Exception
    //   160	168	419	java/lang/Exception
    //   168	174	419	java/lang/Exception
  }
  
  private String b(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 3) {
      i1 = 3;
    }
    String str3;
    try
    {
      a(this.c.getCellLocation());
      str2 = this.d.toString();
      String str1 = str2;
      if (str2 == null) {
        str1 = "Z";
      }
      try
      {
        if ((this.j == null) || (a.a(this.j))) {
          this.j = new a(this.i.getScanResults());
        }
        str2 = this.j.a(i1);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject = null;
        }
      }
      str3 = str1;
      if (str2 != null) {
        str3 = str1 + str2;
      }
      if (str3.equals("Z")) {
        return null;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        String str2 = null;
      }
    }
    return a(str3 + "t" + System.currentTimeMillis() + this.q);
  }
  
  private boolean c()
  {
    String str = null;
    this.o = null;
    this.p = 0;
    Object localObject = this.i.getConnectionInfo();
    if (localObject == null) {}
    for (;;)
    {
      return false;
      try
      {
        localObject = ((WifiInfo)localObject).getBSSID();
        if (localObject != null) {
          str = ((String)localObject).replace(":", "");
        }
        if (str.length() == 12)
        {
          this.o = new String(str);
          return true;
        }
      }
      catch (Exception localException) {}
    }
    return false;
  }
  
  public String a()
  {
    try
    {
      String str = b(3);
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public String a(int paramInt)
  {
    try
    {
      String str = b(paramInt);
      return str;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public boolean b()
  {
    if (this.i == null) {}
    long l1;
    do
    {
      return false;
      l1 = System.currentTimeMillis() - this.n;
    } while ((l1 <= 5000L) && (l1 >= 0L));
    if (this.i.isWifiEnabled())
    {
      if ((this.l != null) && (this.k != null)) {}
      for (;;)
      {
        try
        {
          this.l.invoke(this.k, new Object[] { Boolean.valueOf(this.m) });
          this.n = System.currentTimeMillis();
          return true;
        }
        catch (Exception localException)
        {
          this.i.startScan();
          continue;
        }
        this.i.startScan();
      }
    }
    this.n = 0L;
    return false;
  }
  
  protected class a
  {
    public List<ScanResult> a = null;
    private long c = 0L;
    
    public a()
    {
      List localList;
      this.a = localList;
      this.c = System.currentTimeMillis();
      b();
    }
    
    private void b()
    {
      if (a() < 1) {
        return;
      }
      int j = this.a.size() - 1;
      int i = 1;
      label23:
      int k;
      if ((j >= 1) && (i != 0))
      {
        k = 0;
        i = 0;
        label36:
        if (k < j)
        {
          if (((ScanResult)this.a.get(k)).level >= ((ScanResult)this.a.get(k + 1)).level) {
            break label147;
          }
          ScanResult localScanResult = (ScanResult)this.a.get(k + 1);
          this.a.set(k + 1, this.a.get(k));
          this.a.set(k, localScanResult);
          i = 1;
        }
      }
      label147:
      for (;;)
      {
        k += 1;
        break label36;
        j -= 1;
        break label23;
        break;
      }
    }
    
    private boolean c()
    {
      long l = System.currentTimeMillis() - this.c;
      return (l < 0L) || (l > 500L);
    }
    
    public int a()
    {
      if (this.a == null) {
        return 0;
      }
      return this.a.size();
    }
    
    public String a(int paramInt)
    {
      Object localObject;
      if (a() < 1)
      {
        localObject = null;
        return (String)localObject;
      }
      boolean bool = a.a(a.this);
      int k;
      int i;
      if (bool)
      {
        k = paramInt - 1;
        i = 0;
      }
      for (;;)
      {
        StringBuffer localStringBuffer = new StringBuffer(512);
        int i1 = this.a.size();
        int m = 0;
        int n = 0;
        paramInt = 1;
        int j = i;
        i = n;
        label106:
        String str;
        if (m < i1)
        {
          if (((ScanResult)this.a.get(m)).level == 0)
          {
            n = i;
            i = paramInt;
            paramInt = n;
          }
          for (;;)
          {
            n = m + 1;
            m = i;
            i = paramInt;
            paramInt = m;
            m = n;
            break;
            str = ((ScanResult)this.a.get(m)).BSSID;
            n = ((ScanResult)this.a.get(m)).level;
            str = str.replace(":", "");
            if ((a.b(a.this) == null) || (!str.equals(a.b(a.this)))) {
              break label229;
            }
            a.a(a.this, StrictMath.abs(n));
            j = paramInt;
            n = 1;
            paramInt = i;
            i = j;
            j = n;
          }
          label229:
          if (i < k)
          {
            localStringBuffer.append("h");
            localStringBuffer.append(str);
            localStringBuffer.append("m");
            localStringBuffer.append(StrictMath.abs(n));
            paramInt = i + 1;
            i = 0;
            label276:
            if ((paramInt <= k) || (j == 0)) {}
          }
        }
        for (;;)
        {
          if (bool) {}
          for (str = "h" + a.b(a.this) + "km" + a.c(a.this);; str = null)
          {
            localObject = str;
            if (i != 0) {
              break;
            }
            return str + localStringBuffer.toString();
          }
          break label106;
          n = paramInt;
          paramInt = i;
          i = n;
          break label276;
          i = paramInt;
        }
        i = 1;
        k = paramInt;
      }
    }
  }
  
  private class b
  {
    public int a = -1;
    public int b = -1;
    public int c = -1;
    public int d = -1;
    public char e = '\000';
    
    private b() {}
    
    private boolean a()
    {
      return (this.a > -1) && (this.b > 0);
    }
    
    public String toString()
    {
      if (!a()) {
        return null;
      }
      StringBuffer localStringBuffer = new StringBuffer(128);
      localStringBuffer.append(this.e);
      localStringBuffer.append("h");
      if (this.c != 460) {
        localStringBuffer.append(this.c);
      }
      localStringBuffer.append(String.format(Locale.CHINA, "h%xh%xh%x", new Object[] { Integer.valueOf(this.d), Integer.valueOf(this.a), Integer.valueOf(this.b) }));
      return localStringBuffer.toString();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/b/a/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */