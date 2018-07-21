package com.baidu.location.h;

import android.content.Context;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.text.TextUtils;
import com.baidu.android.bbalbs.common.security.Base64;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.b.c;
import com.baidu.location.f;
import com.baidu.location.f.a;
import com.baidu.location.f.d;
import com.baidu.location.f.e;
import com.baidu.location.wifihistory.SClient;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.Signature;
import java.security.spec.X509EncodedKeySpec;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;

public class g
{
  public static float A = 2.3F;
  public static float B = 3.8F;
  public static int C = 3;
  public static int D = 10;
  public static int E = 2;
  public static int F = 7;
  public static int G = 20;
  public static int H = 70;
  public static int I = 120;
  public static float J = 2.0F;
  public static float K = 10.0F;
  public static float L = 50.0F;
  public static float M = 200.0F;
  public static int N = 16;
  public static float O = 0.9F;
  public static int P = 10000;
  public static float Q = 0.5F;
  public static float R = 0.0F;
  public static float S = 0.1F;
  public static int T = 30;
  public static int U = 100;
  public static int V = 0;
  public static int W = 0;
  public static int X = 0;
  public static int Y = 420000;
  public static boolean Z = true;
  public static boolean a = false;
  private static String aA;
  private static String aB;
  public static boolean aa = true;
  public static int ab = 20;
  public static int ac = 300;
  public static int ad = 1000;
  public static int ae = Integer.MAX_VALUE;
  public static long af = 900000L;
  public static long ag = 420000L;
  public static long ah = 180000L;
  public static long ai = 0L;
  public static long aj = 15L;
  public static long ak = 300000L;
  public static int al = 1000;
  public static int am = 0;
  public static int an = 30000;
  public static int ao = 30000;
  public static float ap = 10.0F;
  public static float aq = 6.0F;
  public static float ar = 10.0F;
  public static int as = 60;
  public static int at = 70;
  public static int au = 6;
  private static String av;
  private static String aw;
  private static String ax;
  private static String ay;
  private static String az;
  public static boolean b = false;
  public static boolean c = false;
  public static int d = 0;
  public static String e;
  public static String f;
  public static String g;
  public static boolean h;
  public static boolean i;
  public static boolean j;
  public static boolean k;
  public static boolean l;
  public static String m;
  public static String n;
  public static boolean o;
  public static int p;
  public static double q;
  public static double r;
  public static double s;
  public static double t;
  public static int u;
  public static byte[] v;
  public static boolean w;
  public static int x;
  public static float y;
  public static float z;
  
  static
  {
    av = "http://loc.map.baidu.com/sdk.php";
    e = "http://loc.map.baidu.com/sdk_ep.php";
    aw = "http://loc.map.baidu.com/user_err.php";
    ax = "http://loc.map.baidu.com/oqur.php";
    ay = "http://loc.map.baidu.com/tcu.php";
    az = "http://loc.map.baidu.com/rtbu.php";
    aA = "http://loc.map.baidu.com/iofd.php";
    aB = "http://loc.map.baidu.com/wloc";
    f = "https://loc.map.baidu.com/sdk.php";
    g = "no";
    h = false;
    i = false;
    j = false;
    k = false;
    l = false;
    m = "gcj02";
    n = "";
    o = true;
    p = 3;
    q = 0.0D;
    r = 0.0D;
    s = 0.0D;
    t = 0.0D;
    u = 0;
    v = null;
    w = false;
    x = 0;
    y = 1.1F;
    z = 2.2F;
  }
  
  public static int a(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || (paramString1.equals(""))) {}
    int i1;
    do
    {
      int i2;
      do
      {
        do
        {
          return Integer.MIN_VALUE;
          i1 = paramString1.indexOf(paramString2);
        } while (i1 == -1);
        i1 += paramString2.length();
        i2 = paramString1.indexOf(paramString3, i1);
      } while (i2 == -1);
      paramString1 = paramString1.substring(i1, i2);
    } while ((paramString1 == null) || (paramString1.equals("")));
    try
    {
      i1 = Integer.parseInt(paramString1);
      return i1;
    }
    catch (NumberFormatException paramString1) {}
    return Integer.MIN_VALUE;
  }
  
  public static Object a(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return null;
    }
    try
    {
      paramContext = paramContext.getApplicationContext().getSystemService(paramString);
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static Object a(Object paramObject, String paramString, Object... paramVarArgs)
    throws Exception
  {
    Class localClass = paramObject.getClass();
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    int i1 = 0;
    int i2 = paramVarArgs.length;
    while (i1 < i2)
    {
      arrayOfClass[i1] = paramVarArgs[i1].getClass();
      if (arrayOfClass[i1] == Integer.class) {
        arrayOfClass[i1] = Integer.TYPE;
      }
      i1 += 1;
    }
    paramString = localClass.getDeclaredMethod(paramString, arrayOfClass);
    if (!paramString.isAccessible()) {
      paramString.setAccessible(true);
    }
    return paramString.invoke(paramObject, paramVarArgs);
  }
  
  public static String a()
  {
    Calendar localCalendar = Calendar.getInstance();
    int i1 = localCalendar.get(5);
    int i2 = localCalendar.get(1);
    int i3 = localCalendar.get(2);
    int i4 = localCalendar.get(11);
    int i5 = localCalendar.get(12);
    int i6 = localCalendar.get(13);
    return String.format(Locale.CHINA, "%d-%02d-%02d %02d:%02d:%02d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3 + 1), Integer.valueOf(i1), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6) });
  }
  
  public static String a(a parama, e parame, Location paramLocation, String paramString)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    if (parama != null)
    {
      String str = com.baidu.location.f.b.a().b(parama);
      if (str != null) {
        localStringBuffer.append(str);
      }
    }
    if (parame != null) {}
    try
    {
      parame = parame.a(15);
      if (parame != null) {
        localStringBuffer.append(parame);
      }
      if (paramLocation != null)
      {
        if (d == 0) {
          break label164;
        }
        parame = d.c(paramLocation);
        if (parame != null) {
          localStringBuffer.append(parame);
        }
      }
      parame = b.a().a(false);
      if (parame != null) {
        localStringBuffer.append(parame);
      }
      if (paramString != null) {
        localStringBuffer.append(paramString);
      }
      if (parama != null)
      {
        parama = com.baidu.location.f.b.a().a(parama);
        if ((parama != null) && (parama.length() + localStringBuffer.length() < 750)) {
          localStringBuffer.append(parama);
        }
      }
      return localStringBuffer.toString();
    }
    catch (Exception parame)
    {
      for (;;)
      {
        parame = null;
        continue;
        label164:
        parame = d.b(paramLocation);
      }
    }
  }
  
  public static String a(a parama, e parame, Location paramLocation, String paramString, int paramInt)
  {
    return a(parama, parame, paramLocation, paramString, paramInt, false);
  }
  
  public static String a(a parama, e parame, Location paramLocation, String paramString, int paramInt, boolean paramBoolean)
  {
    StringBuffer localStringBuffer = new StringBuffer(1024);
    String str;
    if (parama != null)
    {
      str = com.baidu.location.f.b.a().b(parama);
      if (str != null) {
        localStringBuffer.append(str);
      }
    }
    if (parame != null)
    {
      if (paramInt != 0) {
        break label331;
      }
      if (!paramBoolean) {
        break label322;
      }
      str = parame.b();
    }
    for (;;)
    {
      if (str != null) {
        localStringBuffer.append(str);
      }
      if (paramLocation != null)
      {
        if ((d == 0) || (paramInt == 0)) {
          break label340;
        }
        str = d.c(paramLocation);
        label92:
        if (str != null) {
          localStringBuffer.append(str);
        }
      }
      paramBoolean = false;
      if (paramInt == 0) {
        paramBoolean = true;
      }
      str = b.a().a(paramBoolean);
      if (str != null) {
        localStringBuffer.append(str);
      }
      if (paramString != null) {
        localStringBuffer.append(paramString);
      }
      paramString = c.a().d();
      if (!TextUtils.isEmpty(paramString)) {
        localStringBuffer.append("&bc=").append(paramString);
      }
      if (paramInt == 0)
      {
        paramString = SClient.getInstance().getWifiHistoryString();
        if (paramString != null) {
          localStringBuffer.append(paramString);
        }
      }
      if (parama != null)
      {
        parama = com.baidu.location.f.b.a().a(parama);
        if ((parama != null) && (parama.length() + localStringBuffer.length() < 750)) {
          localStringBuffer.append(parama);
        }
      }
      parama = localStringBuffer.toString();
      if ((paramLocation == null) || (parame == null)) {
        break label410;
      }
      try
      {
        float f1 = paramLocation.getSpeed();
        paramInt = d;
        int i1 = parame.j();
        int i2 = parame.a();
        paramBoolean = parame.k();
        if ((f1 < aq) && ((paramInt == 1) || (paramInt == 0)) && ((i1 < as) || (paramBoolean == true)))
        {
          p = 1;
          return parama;
          label322:
          str = parame.c();
          continue;
          label331:
          str = parame.d();
          continue;
          label340:
          str = d.b(paramLocation);
          break label92;
        }
        else if ((f1 < ar) && ((paramInt == 1) || (paramInt == 0) || (paramInt == 3)) && ((i1 < at) || (i2 > au)))
        {
          p = 2;
          return parama;
        }
      }
      catch (Exception parame)
      {
        p = 3;
        return parama;
      }
    }
    p = 3;
    return parama;
    label410:
    p = 3;
    return parama;
  }
  
  public static String a(File paramFile, String paramString)
  {
    if (!paramFile.isFile()) {
      return null;
    }
    byte[] arrayOfByte = new byte['Ѐ'];
    try
    {
      paramString = MessageDigest.getInstance(paramString);
      paramFile = new FileInputStream(paramFile);
      for (;;)
      {
        int i1 = paramFile.read(arrayOfByte, 0, 1024);
        if (i1 == -1) {
          break;
        }
        paramString.update(arrayOfByte, 0, i1);
      }
      paramFile.close();
    }
    catch (Exception paramFile)
    {
      paramFile.printStackTrace();
      return null;
    }
    return new BigInteger(1, paramString.digest()).toString(16);
  }
  
  public static String a(String paramString)
  {
    return Jni.en1(n + ";" + paramString);
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    boolean bool1 = bool2;
    int i1;
    if (paramContext != null)
    {
      paramContext = paramContext.getAllNetworkInfo();
      bool1 = bool2;
      if (paramContext != null) {
        i1 = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i1 < paramContext.length)
      {
        if (paramContext[i1].getState() == NetworkInfo.State.CONNECTED) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i1 += 1;
    }
  }
  
  public static boolean a(BDLocation paramBDLocation)
  {
    int i1 = paramBDLocation.getLocType();
    return ((i1 > 100) && (i1 < 200)) || (i1 == 62);
  }
  
  public static int b(Context paramContext)
  {
    try
    {
      int i1 = Settings.System.getInt(paramContext.getContentResolver(), "airplane_mode_on", 0);
      return i1;
    }
    catch (Exception paramContext) {}
    return 2;
  }
  
  private static int b(Context paramContext, String paramString)
  {
    for (;;)
    {
      try
      {
        i1 = paramContext.checkPermission(paramString, Process.myPid(), Process.myUid());
        if (i1 != 0) {
          continue;
        }
        i1 = 1;
      }
      catch (Exception paramContext)
      {
        int i1 = 1;
        continue;
      }
      if (i1 != 0) {
        break;
      }
      return 0;
      i1 = 0;
    }
    return 1;
  }
  
  public static int b(Object paramObject, String paramString, Object... paramVarArgs)
    throws Exception
  {
    Class localClass = paramObject.getClass();
    Class[] arrayOfClass = new Class[paramVarArgs.length];
    int i1 = 0;
    int i2 = paramVarArgs.length;
    while (i1 < i2)
    {
      arrayOfClass[i1] = paramVarArgs[i1].getClass();
      if (arrayOfClass[i1] == Integer.class) {
        arrayOfClass[i1] = Integer.TYPE;
      }
      i1 += 1;
    }
    paramString = localClass.getDeclaredMethod(paramString, arrayOfClass);
    if (!paramString.isAccessible()) {
      paramString.setAccessible(true);
    }
    return ((Integer)paramString.invoke(paramObject, paramVarArgs)).intValue();
  }
  
  public static String b()
  {
    Calendar localCalendar = Calendar.getInstance();
    int i1 = localCalendar.get(5);
    int i2 = localCalendar.get(1);
    int i3 = localCalendar.get(2);
    int i4 = localCalendar.get(11);
    int i5 = localCalendar.get(12);
    int i6 = localCalendar.get(13);
    int i7 = localCalendar.get(14);
    return String.format(Locale.CHINA, "%d-%02d-%02d_%02d:%02d:%02d.%d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3 + 1), Integer.valueOf(i1), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7) });
  }
  
  public static boolean b(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      paramString3 = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(paramString3.getBytes())));
      Signature localSignature = Signature.getInstance("SHA1WithRSA");
      localSignature.initVerify(paramString3);
      localSignature.update(paramString1.getBytes());
      boolean bool = localSignature.verify(Base64.decode(paramString2.getBytes()));
      return bool;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return false;
  }
  
  public static int c(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 19) {}
    try
    {
      int i1 = Settings.Secure.getInt(paramContext.getContentResolver(), "location_mode", -1);
      return i1;
    }
    catch (Exception paramContext) {}
    return -2;
    return -1;
  }
  
  public static String c()
  {
    Calendar localCalendar = Calendar.getInstance();
    int i1 = localCalendar.get(5);
    int i2 = localCalendar.get(1);
    int i3 = localCalendar.get(2);
    return String.format(Locale.CHINA, "%d-%02d-%02d", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3 + 1), Integer.valueOf(i1) });
  }
  
  public static String d()
  {
    try
    {
      Object localObject2;
      Object localObject3;
      do
      {
        localObject1 = NetworkInterface.getNetworkInterfaces();
        while (!((Enumeration)localObject2).hasMoreElements())
        {
          if (!((Enumeration)localObject1).hasMoreElements()) {
            break;
          }
          localObject2 = ((NetworkInterface)((Enumeration)localObject1).nextElement()).getInetAddresses();
        }
        localObject3 = (InetAddress)((Enumeration)localObject2).nextElement();
      } while ((((InetAddress)localObject3).isLoopbackAddress()) || (!(localObject3 instanceof Inet4Address)));
      byte[] arrayOfByte = ((InetAddress)localObject3).getAddress();
      int i1 = 0;
      Object localObject1 = "";
      for (;;)
      {
        localObject2 = localObject1;
        if (i1 >= arrayOfByte.length) {
          break;
        }
        localObject3 = Integer.toHexString(arrayOfByte[i1] & 0xFF);
        localObject2 = localObject3;
        if (((String)localObject3).length() == 1) {
          localObject2 = '0' + (String)localObject3;
        }
        localObject1 = (String)localObject1 + (String)localObject2;
        i1 += 1;
      }
      return (String)localObject2;
    }
    catch (Exception localException)
    {
      localObject2 = null;
    }
  }
  
  public static String d(Context paramContext)
  {
    int i1 = b(paramContext, "android.permission.ACCESS_COARSE_LOCATION");
    int i2 = b(paramContext, "android.permission.ACCESS_FINE_LOCATION");
    int i3 = b(paramContext, "android.permission.READ_PHONE_STATE");
    return "&per=" + i1 + "|" + i2 + "|" + i3;
  }
  
  public static String e()
  {
    return av;
  }
  
  public static String e(Context paramContext)
  {
    int i1 = -1;
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if ((paramContext == null) || (!paramContext.isAvailable())) {
          break label63;
        }
        int i2 = paramContext.getType();
        i1 = i2;
      }
      catch (Exception paramContext)
      {
        continue;
      }
      return "&netc=" + i1;
      label63:
      i1 = -1;
    }
  }
  
  public static String f()
  {
    return ay;
  }
  
  public static String g()
  {
    return az;
  }
  
  public static String h()
  {
    return ax;
  }
  
  public static String i()
  {
    return "https://daup.map.baidu.com/cltr/rcvr";
  }
  
  public static String j()
  {
    try
    {
      if (Environment.getExternalStorageState().equals("mounted"))
      {
        String str = Environment.getExternalStorageDirectory().getPath();
        File localFile = new File(str + "/baidu/tempdata");
        if (!localFile.exists()) {
          localFile.mkdirs();
        }
        return str;
      }
      return null;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String k()
  {
    String str = j();
    if (str == null) {
      return null;
    }
    return str + "/baidu/tempdata";
  }
  
  public static String l()
  {
    try
    {
      Object localObject = new File(f.getServiceContext().getFilesDir() + File.separator + "lldt");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = ((File)localObject).getAbsolutePath();
      return (String)localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String m()
  {
    try
    {
      Object localObject = new File(f.getServiceContext().getFilesDir() + File.separator + "/baidu/tempdata");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = f.getServiceContext().getFilesDir().getPath();
      return (String)localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public static String n()
  {
    try
    {
      Object localObject = new File(f.getServiceContext().getFilesDir() + File.separator + "iadt");
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      localObject = ((File)localObject).getAbsolutePath();
      return (String)localObject;
    }
    catch (Exception localException) {}
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/location/h/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */