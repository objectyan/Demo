package com.baidu.mobstat;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ServiceInfo;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class de
{
  private static String a = null;
  private static String b = null;
  private static String c = null;
  private static final Pattern d = Pattern.compile("\\s*|\t|\r|\n");
  
  /* Error */
  public static String a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: new 36	java/lang/StringBuffer
    //   6: dup
    //   7: invokespecial 39	java/lang/StringBuffer:<init>	()V
    //   10: astore 4
    //   12: bipush 20
    //   14: newarray <illegal type>
    //   16: astore 6
    //   18: new 41	java/io/InputStreamReader
    //   21: dup
    //   22: new 43	java/io/FileInputStream
    //   25: dup
    //   26: ldc 45
    //   28: invokespecial 48	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   31: invokespecial 51	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   34: astore_3
    //   35: aload_3
    //   36: astore_2
    //   37: aload_3
    //   38: aload 6
    //   40: invokevirtual 57	java/io/Reader:read	([C)I
    //   43: istore_1
    //   44: iload_1
    //   45: iconst_m1
    //   46: if_icmpeq +96 -> 142
    //   49: aload_3
    //   50: astore_2
    //   51: iload_1
    //   52: aload 6
    //   54: arraylength
    //   55: if_icmpne +56 -> 111
    //   58: aload_3
    //   59: astore_2
    //   60: aload 6
    //   62: aload 6
    //   64: arraylength
    //   65: iconst_1
    //   66: isub
    //   67: caload
    //   68: bipush 13
    //   70: if_icmpeq +41 -> 111
    //   73: aload_3
    //   74: astore_2
    //   75: getstatic 63	java/lang/System:out	Ljava/io/PrintStream;
    //   78: aload 6
    //   80: invokevirtual 69	java/io/PrintStream:print	([C)V
    //   83: goto -48 -> 35
    //   86: astore 4
    //   88: aload_3
    //   89: astore_2
    //   90: aload 4
    //   92: invokestatic 74	com/baidu/mobstat/db:a	(Ljava/lang/Throwable;)V
    //   95: aload 5
    //   97: astore_2
    //   98: aload_3
    //   99: ifnull +10 -> 109
    //   102: aload_3
    //   103: invokevirtual 77	java/io/Reader:close	()V
    //   106: aload 5
    //   108: astore_2
    //   109: aload_2
    //   110: areturn
    //   111: iconst_0
    //   112: istore_0
    //   113: iload_0
    //   114: iload_1
    //   115: if_icmpge -80 -> 35
    //   118: aload 6
    //   120: iload_0
    //   121: caload
    //   122: bipush 13
    //   124: if_icmpeq +98 -> 222
    //   127: aload_3
    //   128: astore_2
    //   129: aload 4
    //   131: aload 6
    //   133: iload_0
    //   134: caload
    //   135: invokevirtual 81	java/lang/StringBuffer:append	(C)Ljava/lang/StringBuffer;
    //   138: pop
    //   139: goto +83 -> 222
    //   142: aload_3
    //   143: astore_2
    //   144: aload 4
    //   146: invokevirtual 84	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   149: invokevirtual 89	java/lang/String:trim	()Ljava/lang/String;
    //   152: ldc 91
    //   154: ldc 93
    //   156: invokevirtual 97	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   159: astore 4
    //   161: aload 4
    //   163: astore_2
    //   164: aload_3
    //   165: ifnull -56 -> 109
    //   168: aload_3
    //   169: invokevirtual 77	java/io/Reader:close	()V
    //   172: aload 4
    //   174: areturn
    //   175: astore_2
    //   176: aload_2
    //   177: invokestatic 74	com/baidu/mobstat/db:a	(Ljava/lang/Throwable;)V
    //   180: aload 4
    //   182: areturn
    //   183: astore_2
    //   184: aload_2
    //   185: invokestatic 74	com/baidu/mobstat/db:a	(Ljava/lang/Throwable;)V
    //   188: aconst_null
    //   189: areturn
    //   190: astore_3
    //   191: aconst_null
    //   192: astore_2
    //   193: aload_2
    //   194: ifnull +7 -> 201
    //   197: aload_2
    //   198: invokevirtual 77	java/io/Reader:close	()V
    //   201: aload_3
    //   202: athrow
    //   203: astore_2
    //   204: aload_2
    //   205: invokestatic 74	com/baidu/mobstat/db:a	(Ljava/lang/Throwable;)V
    //   208: goto -7 -> 201
    //   211: astore_3
    //   212: goto -19 -> 193
    //   215: astore 4
    //   217: aconst_null
    //   218: astore_3
    //   219: goto -131 -> 88
    //   222: iload_0
    //   223: iconst_1
    //   224: iadd
    //   225: istore_0
    //   226: goto -113 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   112	114	0	i	int
    //   43	73	1	j	int
    //   36	128	2	localObject1	Object
    //   175	2	2	localIOException1	java.io.IOException
    //   183	2	2	localIOException2	java.io.IOException
    //   192	6	2	localObject2	Object
    //   203	2	2	localIOException3	java.io.IOException
    //   34	135	3	localInputStreamReader	java.io.InputStreamReader
    //   190	12	3	localObject3	Object
    //   211	1	3	localObject4	Object
    //   218	1	3	localObject5	Object
    //   10	1	4	localStringBuffer	StringBuffer
    //   86	59	4	localException1	Exception
    //   159	22	4	str	String
    //   215	1	4	localException2	Exception
    //   1	106	5	localObject6	Object
    //   16	116	6	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   37	44	86	java/lang/Exception
    //   51	58	86	java/lang/Exception
    //   60	73	86	java/lang/Exception
    //   75	83	86	java/lang/Exception
    //   129	139	86	java/lang/Exception
    //   144	161	86	java/lang/Exception
    //   168	172	175	java/io/IOException
    //   102	106	183	java/io/IOException
    //   12	35	190	finally
    //   197	201	203	java/io/IOException
    //   37	44	211	finally
    //   51	58	211	finally
    //   60	73	211	finally
    //   75	83	211	finally
    //   90	95	211	finally
    //   129	139	211	finally
    //   144	161	211	finally
    //   12	35	215	java/lang/Exception
  }
  
  private static String a(byte paramByte)
  {
    String str = "00" + Integer.toHexString(paramByte) + ":";
    return str.substring(str.length() - 3);
  }
  
  public static String a(int paramInt, Context paramContext)
  {
    try
    {
      paramContext = ct.c(paramInt, a(paramContext).getBytes());
      return paramContext;
    }
    catch (Exception paramContext)
    {
      db.a(paramContext);
    }
    return "";
  }
  
  public static String a(Context paramContext)
  {
    paramContext = dg.a(paramContext);
    return d.matcher(paramContext).replaceAll("");
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    paramContext = u(paramContext);
    if (TextUtils.isEmpty(paramContext)) {
      return "";
    }
    return ct.c(paramInt, paramContext.getBytes());
  }
  
  public static String a(Context paramContext, String paramString)
  {
    Object localObject = paramContext.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getApplicationInfo(paramContext.getPackageName(), 128);
      if (localObject != null)
      {
        paramContext = null;
        if (((ApplicationInfo)localObject).metaData != null) {
          paramContext = ((ApplicationInfo)localObject).metaData.get(paramString);
        }
        if (paramContext == null) {
          db.a("null,can't find information for key:" + paramString);
        }
      }
      else
      {
        return "";
      }
      return paramContext.toString();
    }
    catch (Exception paramContext) {}
    return "";
  }
  
  /* Error */
  private static String a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: invokestatic 194	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   5: new 100	java/lang/StringBuilder
    //   8: dup
    //   9: invokespecial 101	java/lang/StringBuilder:<init>	()V
    //   12: ldc -60
    //   14: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: aload_0
    //   18: invokevirtual 106	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: invokevirtual 200	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   27: astore_0
    //   28: new 202	java/io/BufferedReader
    //   31: dup
    //   32: new 41	java/io/InputStreamReader
    //   35: dup
    //   36: aload_0
    //   37: invokevirtual 208	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   40: invokespecial 51	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   43: sipush 1024
    //   46: invokespecial 211	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   49: astore_2
    //   50: aload_2
    //   51: invokevirtual 214	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   54: astore_1
    //   55: aload_2
    //   56: ifnull +7 -> 63
    //   59: aload_2
    //   60: invokevirtual 215	java/io/BufferedReader:close	()V
    //   63: aload_1
    //   64: astore_2
    //   65: aload_0
    //   66: ifnull +9 -> 75
    //   69: aload_0
    //   70: invokevirtual 218	java/lang/Process:destroy	()V
    //   73: aload_1
    //   74: astore_2
    //   75: aload_2
    //   76: areturn
    //   77: astore_0
    //   78: aconst_null
    //   79: astore_1
    //   80: aconst_null
    //   81: astore_0
    //   82: aload_0
    //   83: ifnull +7 -> 90
    //   86: aload_0
    //   87: invokevirtual 215	java/io/BufferedReader:close	()V
    //   90: aload_3
    //   91: astore_2
    //   92: aload_1
    //   93: ifnull -18 -> 75
    //   96: aload_1
    //   97: invokevirtual 218	java/lang/Process:destroy	()V
    //   100: aconst_null
    //   101: areturn
    //   102: astore_1
    //   103: aconst_null
    //   104: astore_0
    //   105: aconst_null
    //   106: astore_3
    //   107: aload_0
    //   108: ifnull +7 -> 115
    //   111: aload_0
    //   112: invokevirtual 215	java/io/BufferedReader:close	()V
    //   115: aload_3
    //   116: ifnull +7 -> 123
    //   119: aload_3
    //   120: invokevirtual 218	java/lang/Process:destroy	()V
    //   123: aload_1
    //   124: athrow
    //   125: astore_2
    //   126: goto -63 -> 63
    //   129: astore_0
    //   130: goto -40 -> 90
    //   133: astore_0
    //   134: goto -19 -> 115
    //   137: astore_1
    //   138: aconst_null
    //   139: astore_2
    //   140: aload_0
    //   141: astore_3
    //   142: aload_2
    //   143: astore_0
    //   144: goto -37 -> 107
    //   147: astore_1
    //   148: aload_0
    //   149: astore_3
    //   150: aload_2
    //   151: astore_0
    //   152: goto -45 -> 107
    //   155: astore_1
    //   156: aconst_null
    //   157: astore_2
    //   158: aload_0
    //   159: astore_1
    //   160: aload_2
    //   161: astore_0
    //   162: goto -80 -> 82
    //   165: astore_1
    //   166: aload_0
    //   167: astore_1
    //   168: aload_2
    //   169: astore_0
    //   170: goto -88 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	173	0	paramString	String
    //   54	43	1	str1	String
    //   102	22	1	localObject1	Object
    //   137	1	1	localObject2	Object
    //   147	1	1	localObject3	Object
    //   155	1	1	localException1	Exception
    //   159	1	1	str2	String
    //   165	1	1	localException2	Exception
    //   167	1	1	str3	String
    //   49	43	2	localObject4	Object
    //   125	1	2	localException3	Exception
    //   139	30	2	localObject5	Object
    //   1	149	3	str4	String
    // Exception table:
    //   from	to	target	type
    //   2	28	77	java/lang/Exception
    //   2	28	102	finally
    //   59	63	125	java/lang/Exception
    //   86	90	129	java/lang/Exception
    //   111	115	133	java/lang/Exception
    //   28	50	137	finally
    //   50	55	147	finally
    //   28	50	155	java/lang/Exception
    //   50	55	165	java/lang/Exception
  }
  
  public static int b(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    try
    {
      paramContext = d(paramContext);
      return paramContext.widthPixels;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        db.a(paramContext);
        paramContext = localDisplayMetrics;
      }
    }
  }
  
  public static String b()
  {
    if (c != null) {
      return c;
    }
    String str1 = "";
    if (!TextUtils.isEmpty(a("ro.miui.ui.version.name"))) {
      str1 = "miui";
    }
    for (;;)
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1))
      {
        String str3 = a("ro.build.display.id");
        str2 = str1;
        if (!TextUtils.isEmpty(str3))
        {
          str2 = str1;
          if (str3.contains("Flyme")) {
            str2 = "flyme";
          }
        }
      }
      c = str2;
      return c;
      if (!TextUtils.isEmpty(a("ro.build.version.opporom"))) {
        str1 = "coloros";
      } else if (!TextUtils.isEmpty(a("ro.build.version.emui"))) {
        str1 = "emui";
      } else if (!TextUtils.isEmpty(a("ro.vivo.os.version"))) {
        str1 = "funtouch";
      } else if (!TextUtils.isEmpty(a("ro.smartisan.version"))) {
        str1 = "smartisan";
      }
    }
  }
  
  public static String b(int paramInt, Context paramContext)
  {
    paramContext = j(paramContext);
    if (TextUtils.isEmpty(paramContext)) {
      return "";
    }
    return ct.c(paramInt, paramContext.getBytes());
  }
  
  private static String b(Context paramContext, String paramString)
  {
    if (paramString == null) {}
    int i;
    do
    {
      return null;
      i = paramString.lastIndexOf(':');
    } while ((i <= 0) || (i + 1 >= paramString.length()));
    return paramString.substring(i + 1);
  }
  
  public static int c(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    try
    {
      paramContext = d(paramContext);
      return paramContext.heightPixels;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        db.a(paramContext);
        paramContext = localDisplayMetrics;
      }
    }
  }
  
  @TargetApi(9)
  private static String c()
  {
    if (Build.VERSION.SDK_INT < 9) {
      return "";
    }
    try
    {
      Object localObject1 = Collections.list(NetworkInterface.getNetworkInterfaces()).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (NetworkInterface)((Iterator)localObject1).next();
        if (((NetworkInterface)localObject2).getName().equalsIgnoreCase("wlan0"))
        {
          localObject1 = ((NetworkInterface)localObject2).getHardwareAddress();
          if (localObject1 == null) {
            return "";
          }
          localObject2 = new StringBuilder();
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            ((StringBuilder)localObject2).append(String.format("%02x:", new Object[] { Byte.valueOf(localObject1[i]) }));
            i += 1;
          }
          if (((StringBuilder)localObject2).length() > 0) {
            ((StringBuilder)localObject2).deleteCharAt(((StringBuilder)localObject2).length() - 1);
          }
          localObject1 = ((StringBuilder)localObject2).toString();
          return (String)localObject1;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      db.b(localThrowable);
    }
    return "";
  }
  
  public static String c(int paramInt, Context paramContext)
  {
    Object localObject = d(paramInt, paramContext);
    paramContext = null;
    if (!TextUtils.isEmpty((CharSequence)localObject)) {
      paramContext = ct.c(paramInt, ((String)localObject).getBytes());
    }
    localObject = paramContext;
    if (TextUtils.isEmpty(paramContext)) {
      localObject = "";
    }
    return (String)localObject;
  }
  
  private static String c(Context paramContext, String paramString)
  {
    paramContext = paramContext.getApplicationInfo();
    if (paramContext == null) {
      return null;
    }
    paramContext = paramContext.processName;
    if ((paramContext != null) && (!paramContext.equals(paramString))) {}
    for (;;)
    {
      return paramString;
      paramString = null;
    }
  }
  
  public static DisplayMetrics d(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)paramContext.getApplicationContext().getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public static String d(int paramInt, Context paramContext)
  {
    String str2 = a();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = e(paramInt, paramContext);
    }
    paramContext = str1;
    if (TextUtils.isEmpty(str1)) {
      paramContext = "";
    }
    return paramContext;
  }
  
  public static int e(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramContext = paramContext.getPackageName();
    try
    {
      int i = localPackageManager.getPackageInfo(paramContext, 0).versionCode;
      return i;
    }
    catch (Exception paramContext)
    {
      db.b("Get app version code exception");
    }
    return 1;
  }
  
  @SuppressLint({"NewApi"})
  public static String e(int paramInt, Context paramContext)
  {
    Object localObject3 = null;
    Object localObject1 = null;
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      Object localObject2;
      try
      {
        Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
        localObject3 = localObject1;
        localObject4 = localObject1;
        if (localEnumeration1.hasMoreElements())
        {
          localObject3 = localObject1;
          NetworkInterface localNetworkInterface = (NetworkInterface)localEnumeration1.nextElement();
          localObject3 = localObject1;
          Enumeration localEnumeration2 = localNetworkInterface.getInetAddresses();
          localObject4 = localObject1;
          localObject1 = localObject4;
          localObject3 = localObject4;
          if (!localEnumeration2.hasMoreElements()) {
            continue;
          }
          localObject3 = localObject4;
          localObject1 = (InetAddress)localEnumeration2.nextElement();
          localObject3 = localObject4;
          if (((InetAddress)localObject1).isAnyLocalAddress()) {
            continue;
          }
          localObject3 = localObject4;
          if (!(localObject1 instanceof Inet4Address)) {
            continue;
          }
          localObject3 = localObject4;
          if (((InetAddress)localObject1).isLoopbackAddress()) {
            continue;
          }
          localObject3 = localObject4;
          if (((InetAddress)localObject1).isSiteLocalAddress())
          {
            localObject3 = localObject4;
            localObject1 = localNetworkInterface.getHardwareAddress();
            break label252;
          }
          localObject3 = localObject4;
          if (((InetAddress)localObject1).isLinkLocalAddress()) {
            break label249;
          }
          localObject3 = localObject4;
          localObject1 = localNetworkInterface.getHardwareAddress();
        }
        localObject2 = localObject4;
      }
      catch (Exception localException)
      {
        db.a(localException);
        localObject4 = localObject3;
        if (localObject4 != null)
        {
          paramInt = 0;
          if (paramInt < localObject4.length)
          {
            localStringBuffer.append(a(localObject4[paramInt]));
            paramInt += 1;
            continue;
          }
          paramContext = localStringBuffer.substring(0, localStringBuffer.length() - 1).replaceAll(":", "");
          return paramContext;
        }
        localObject2 = b(paramInt, paramContext);
        paramContext = (Context)localObject2;
        if (localObject2 == null) {
          continue;
        }
        return ((String)localObject2).replaceAll(":", "");
      }
      label249:
      label252:
      Object localObject4 = localObject2;
    }
  }
  
  public static String f(int paramInt, Context paramContext)
  {
    paramContext = k(paramContext);
    if (TextUtils.isEmpty(paramContext)) {
      return "";
    }
    return ct.c(paramInt, paramContext.getBytes());
  }
  
  public static String f(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    paramContext = paramContext.getPackageName();
    try
    {
      paramContext = localPackageManager.getPackageInfo(paramContext, 0).versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      db.b("get app version name exception");
    }
    return "";
  }
  
  public static String g(int paramInt, Context paramContext)
  {
    paramContext = m(paramContext);
    if (TextUtils.isEmpty(paramContext)) {
      return "";
    }
    return ct.d(paramInt, paramContext.getBytes());
  }
  
  public static String g(Context paramContext)
  {
    String str = String.format("%s_%s_%s", new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
    try
    {
      if ((cu.e(paramContext, "android.permission.ACCESS_FINE_LOCATION")) || (cu.e(paramContext, "android.permission.ACCESS_COARSE_LOCATION")))
      {
        paramContext = ((TelephonyManager)paramContext.getSystemService("phone")).getCellLocation();
        db.a(paramContext + "");
        if (paramContext == null) {
          return str;
        }
        if ((paramContext instanceof GsmCellLocation))
        {
          paramContext = (GsmCellLocation)paramContext;
          return String.format("%s_%s_%s", new Object[] { String.format("%d", new Object[] { Integer.valueOf(paramContext.getCid()) }), String.format("%d", new Object[] { Integer.valueOf(paramContext.getLac()) }), Integer.valueOf(0) });
        }
        paramContext = paramContext.toString().replace("[", "").replace("]", "").split(",");
        paramContext = String.format("%s_%s_%s", new Object[] { paramContext[0], paramContext[3], paramContext[4] });
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      db.a("Get Location", paramContext);
    }
    return str;
  }
  
  public static String h(int paramInt, Context paramContext)
  {
    paramContext = p(paramContext);
    if (!TextUtils.isEmpty(paramContext)) {
      try
      {
        paramContext = ct.c(paramInt, paramContext.getBytes());
        return paramContext;
      }
      catch (Exception paramContext)
      {
        db.b(paramContext);
      }
    }
    return "";
  }
  
  public static String h(Context paramContext)
  {
    try
    {
      if (cu.e(paramContext, "android.permission.ACCESS_FINE_LOCATION"))
      {
        paramContext = ((LocationManager)paramContext.getSystemService("location")).getLastKnownLocation("gps");
        db.b("location: " + paramContext);
        if (paramContext != null)
        {
          paramContext = String.format("%s_%s_%s", new Object[] { Long.valueOf(paramContext.getTime()), Double.valueOf(paramContext.getLongitude()), Double.valueOf(paramContext.getLatitude()) });
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      db.b(paramContext);
    }
    return "";
  }
  
  public static String i(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return j(paramContext);
    }
    return c();
  }
  
  public static String j(Context paramContext)
  {
    try
    {
      if (cu.e(paramContext, "android.permission.ACCESS_WIFI_STATE"))
      {
        paramContext = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo();
        if (paramContext != null)
        {
          paramContext = paramContext.getMacAddress();
          if (!TextUtils.isEmpty(paramContext)) {
            return paramContext;
          }
        }
      }
      else
      {
        db.c("You need the android.Manifest.permission.ACCESS_WIFI_STATE permission. Open AndroidManifest.xml and just before the final </manifest> tag add: android.permission.ACCESS_WIFI_STATE");
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        db.b(paramContext);
      }
    }
    return "";
  }
  
  @SuppressLint({"NewApi"})
  public static String k(Context paramContext)
  {
    String str = Build.BRAND;
    if (("4.1.1".equals(Build.VERSION.RELEASE)) && ("TCT".equals(str))) {
      paramContext = "";
    }
    for (;;)
    {
      return paramContext;
      try
      {
        if (cu.e(paramContext, "android.permission.BLUETOOTH"))
        {
          paramContext = BluetoothAdapter.getDefaultAdapter();
          if (paramContext != null)
          {
            str = paramContext.getAddress();
            paramContext = str;
            if (str != null) {
              continue;
            }
          }
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          db.b(paramContext);
        }
      }
    }
    return "";
  }
  
  public static String l(Context paramContext)
  {
    paramContext = m(paramContext);
    if (TextUtils.isEmpty(paramContext)) {
      return "";
    }
    return cs.a(paramContext.getBytes());
  }
  
  public static String m(Context paramContext)
  {
    int k = 0;
    if (paramContext == null) {
      return "";
    }
    if (!cu.e(paramContext, "android.permission.ACCESS_WIFI_STATE")) {
      return "";
    }
    try
    {
      if (cu.e(paramContext, "android.permission.ACCESS_FINE_LOCATION"))
      {
        bool = ((LocationManager)paramContext.getSystemService("location")).isProviderEnabled("gps");
        for (;;)
        {
          try
          {
            localObject3 = (WifiManager)paramContext.getSystemService("wifi");
            localObject1 = ((WifiManager)localObject3).getConnectionInfo();
          }
          catch (Throwable localThrowable1)
          {
            Object localObject3;
            Object localObject1;
            ScanResult localScanResult;
            StringBuilder localStringBuilder;
            String str;
            localObject2 = null;
          }
          try
          {
            localObject5 = ((WifiManager)localObject3).getScanResults();
            localObject3 = localObject1;
            localObject1 = localObject5;
            if ((localObject1 != null) && (((List)localObject1).size() != 0)) {
              Collections.sort((List)localObject1, new df());
            }
            localJSONArray = new JSONArray();
            i = 0;
            if ((localObject1 == null) || (i >= ((List)localObject1).size()) || (i >= 30)) {
              break label362;
            }
          }
          catch (Throwable localThrowable2)
          {
            Object localObject4;
            for (;;) {}
          }
          try
          {
            localScanResult = (ScanResult)((List)localObject1).get(i);
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(localScanResult.BSSID);
            localStringBuilder.append("|");
            str = localScanResult.SSID.replaceAll("\\|", "");
            localObject5 = str;
            if (str.length() > 30) {
              localObject5 = str.substring(0, 30);
            }
            localStringBuilder.append((String)localObject5);
            localStringBuilder.append("|");
            localStringBuilder.append(localScanResult.level);
            localStringBuilder.append("|");
            if ((localObject3 == null) || (!localScanResult.BSSID.equals(((WifiInfo)localObject3).getBSSID()))) {
              break label347;
            }
            j = 1;
            localStringBuilder.append(j);
            localJSONArray.put(localStringBuilder.toString());
          }
          catch (Exception localException2)
          {
            db.a(localException2);
            continue;
          }
          i += 1;
        }
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        JSONArray localJSONArray;
        int i;
        db.a(localException1);
        boolean bool = false;
        continue;
        db.a(localThrowable1);
        Object localObject5 = null;
        localObject4 = localObject2;
        Object localObject2 = localObject5;
        continue;
        label347:
        int j = 0;
        continue;
        label362:
        if (localJSONArray.length() == 0) {
          return null;
        }
        localObject2 = new JSONObject();
        try
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(System.currentTimeMillis());
          ((StringBuilder)localObject4).append("|");
          i = k;
          if (bool) {
            i = 1;
          }
          ((StringBuilder)localObject4).append(i);
          ((StringBuilder)localObject4).append("|");
          ((StringBuilder)localObject4).append(h(paramContext));
          ((JSONObject)localObject2).put("ap-list", localJSONArray);
          ((JSONObject)localObject2).put("meta-data", ((StringBuilder)localObject4).toString());
          paramContext = ((JSONObject)localObject2).toString();
          return paramContext;
        }
        catch (Exception paramContext)
        {
          db.a(paramContext);
          return "";
        }
        bool = false;
      }
    }
  }
  
  public static boolean n(Context paramContext)
  {
    boolean bool = false;
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getNetworkInfo(1);
        if ((paramContext != null) && (paramContext.isAvailable()))
        {
          bool = paramContext.isConnected();
          if (bool)
          {
            bool = true;
            return bool;
          }
        }
      }
      catch (Exception paramContext)
      {
        db.a(paramContext);
        return false;
      }
      bool = false;
    }
  }
  
  /* Error */
  public static String o(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 664
    //   4: invokevirtual 361	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   7: checkcast 666	android/net/ConnectivityManager
    //   10: invokevirtual 683	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   13: astore_2
    //   14: aload_2
    //   15: ifnull +50 -> 65
    //   18: aload_2
    //   19: invokevirtual 686	android/net/NetworkInfo:getTypeName	()Ljava/lang/String;
    //   22: astore_0
    //   23: aload_0
    //   24: astore_1
    //   25: aload_0
    //   26: ldc_w 688
    //   29: invokevirtual 352	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   32: ifne +17 -> 49
    //   35: aload_0
    //   36: astore_1
    //   37: aload_2
    //   38: invokevirtual 691	android/net/NetworkInfo:getSubtypeName	()Ljava/lang/String;
    //   41: ifnull +8 -> 49
    //   44: aload_2
    //   45: invokevirtual 691	android/net/NetworkInfo:getSubtypeName	()Ljava/lang/String;
    //   48: astore_1
    //   49: aload_1
    //   50: areturn
    //   51: astore_1
    //   52: ldc 93
    //   54: astore_0
    //   55: aload_1
    //   56: invokestatic 74	com/baidu/mobstat/db:a	(Ljava/lang/Throwable;)V
    //   59: aload_0
    //   60: areturn
    //   61: astore_1
    //   62: goto -7 -> 55
    //   65: ldc 93
    //   67: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	68	0	paramContext	Context
    //   24	26	1	localObject	Object
    //   51	5	1	localException1	Exception
    //   61	1	1	localException2	Exception
    //   13	32	2	localNetworkInfo	NetworkInfo
    // Exception table:
    //   from	to	target	type
    //   0	14	51	java/lang/Exception
    //   18	23	51	java/lang/Exception
    //   25	35	61	java/lang/Exception
    //   37	49	61	java/lang/Exception
  }
  
  public static String p(Context paramContext)
  {
    if (paramContext != null) {
      return paramContext.getPackageName();
    }
    return "";
  }
  
  public static String q(Context paramContext)
  {
    String str1 = b;
    Object localObject = str1;
    if (str1 == null)
    {
      String str2 = v(paramContext);
      str1 = b(paramContext, str2);
      localObject = str1;
      if (TextUtils.isEmpty(str1)) {
        localObject = c(paramContext, str2);
      }
      paramContext = (Context)localObject;
      if (localObject == null) {
        paramContext = "";
      }
      b = paramContext;
      localObject = paramContext;
    }
    return (String)localObject;
  }
  
  public static String r(Context paramContext)
  {
    String str1 = "";
    String str2 = v(paramContext);
    Object localObject1;
    if (str2 == null) {
      localObject1 = str1;
    }
    for (;;)
    {
      return (String)localObject1;
      Object localObject2 = paramContext.getPackageManager();
      localObject1 = null;
      try
      {
        paramContext = ((PackageManager)localObject2).getPackageInfo(paramContext.getPackageName(), 4);
        localObject1 = str1;
        if (paramContext == null) {
          continue;
        }
        localObject2 = paramContext.services;
        localObject1 = str1;
        if (localObject2 == null) {
          continue;
        }
        int j = localObject2.length;
        int i = 0;
        for (;;)
        {
          paramContext = str1;
          if (i < j)
          {
            paramContext = localObject2[i];
            if (str2.equals(paramContext.processName)) {
              paramContext = paramContext.name;
            }
          }
          else
          {
            localObject1 = paramContext;
            if (paramContext != null) {
              break;
            }
            return "";
          }
          i += 1;
        }
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        for (;;)
        {
          paramContext = (Context)localObject1;
        }
      }
    }
  }
  
  public static boolean s(Context paramContext)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramContext != null) {}
    try
    {
      boolean bool3 = paramContext.getPackageManager().hasSystemFeature("android.hardware.type.watch");
      bool1 = bool2;
      if (bool3) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramContext)
    {
      db.b(paramContext);
    }
    return false;
  }
  
  public static String t(Context paramContext)
  {
    try
    {
      Object localObject = (ActivityManager)paramContext.getSystemService("activity");
      paramContext = new ActivityManager.MemoryInfo();
      ((ActivityManager)localObject).getMemoryInfo(paramContext);
      localObject = new JSONObject();
      ((JSONObject)localObject).put("m", paramContext.availMem);
      ((JSONObject)localObject).put("l", paramContext.lowMemory);
      ((JSONObject)localObject).put("t", paramContext.threshold);
      paramContext = new JSONArray();
      paramContext.put(localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("app_mem", paramContext);
      localJSONObject.put("meta-data", ((StringBuilder)localObject).toString());
      paramContext = cs.a(localJSONObject.toString().getBytes());
      return paramContext;
    }
    catch (Exception paramContext)
    {
      db.a(paramContext);
    }
    return "";
  }
  
  private static String u(Context paramContext)
  {
    try
    {
      paramContext = BluetoothAdapter.getDefaultAdapter();
      if (paramContext != null)
      {
        paramContext = paramContext.getName();
        if (paramContext != null) {
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      db.b(paramContext);
    }
    return "";
  }
  
  private static String v(Context paramContext)
  {
    Object localObject = a;
    if (localObject == null) {
      for (;;)
      {
        try
        {
          paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningAppProcesses();
          i = 0;
          if ((paramContext == null) || (i >= paramContext.size())) {
            continue;
          }
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.get(i);
          if ((localRunningAppProcessInfo == null) || (localRunningAppProcessInfo.pid != Process.myPid())) {
            continue;
          }
          paramContext = localRunningAppProcessInfo.processName;
        }
        catch (Exception paramContext)
        {
          int i;
          db.b(paramContext);
          paramContext = (Context)localObject;
          continue;
        }
        localObject = paramContext;
        if (paramContext == null) {
          localObject = "";
        }
        a = (String)localObject;
        return (String)localObject;
        i += 1;
      }
    }
    return (String)localObject;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mobstat/de.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */