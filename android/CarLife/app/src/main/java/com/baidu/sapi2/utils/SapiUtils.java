package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.android.common.util.DeviceId;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.b;
import com.baidu.sapi2.utils.enums.Domain;
import java.io.File;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SimpleTimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class SapiUtils
{
  public static final String KEY_QR_LOGIN_LP = "lp";
  public static final String KEY_QR_LOGIN_SIGN = "sign";
  public static final int MAX_WIFI_LIST = 10;
  public static final int NETWORK_TYPE_1XRTT = 7;
  public static final int NETWORK_TYPE_CDMA = 4;
  public static final int NETWORK_TYPE_EDGE = 2;
  public static final int NETWORK_TYPE_EHRPD = 14;
  public static final int NETWORK_TYPE_EVDO_0 = 5;
  public static final int NETWORK_TYPE_EVDO_A = 6;
  public static final int NETWORK_TYPE_EVDO_B = 12;
  public static final int NETWORK_TYPE_GPRS = 1;
  public static final int NETWORK_TYPE_HSDPA = 8;
  public static final int NETWORK_TYPE_HSPA = 10;
  public static final int NETWORK_TYPE_HSPAP = 15;
  public static final int NETWORK_TYPE_HSUPA = 9;
  public static final int NETWORK_TYPE_IDEN = 11;
  public static final int NETWORK_TYPE_LTE = 13;
  public static final int NETWORK_TYPE_UMTS = 3;
  public static final int NETWORK_TYPE_UNKNOWN = 0;
  public static final String QR_LOGIN_LP_APP = "app";
  public static final String QR_LOGIN_LP_PC = "pc";
  static final String a = "cmd";
  static final String b = "error";
  static final String c = "EEE, dd-MMM-yyyy HH:mm:ss 'GMT'";
  static final String d = "http://www.";
  
  static String a(String paramString1, String paramString2)
  {
    return buildBDUSSCookie(paramString1, "BDUSS", paramString2);
  }
  
  /* Error */
  private static boolean a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore 6
    //   11: aload 5
    //   13: astore_3
    //   14: invokestatic 86	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   17: new 88	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   24: ldc 91
    //   26: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_0
    //   30: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 99	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: invokevirtual 103	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   39: astore_0
    //   40: aload_0
    //   41: astore 4
    //   43: aload 5
    //   45: astore_3
    //   46: aload_0
    //   47: astore_2
    //   48: new 105	java/io/BufferedReader
    //   51: dup
    //   52: new 107	java/io/InputStreamReader
    //   55: dup
    //   56: aload_0
    //   57: invokevirtual 113	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   60: invokespecial 116	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   63: invokespecial 119	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   66: astore 5
    //   68: aload 5
    //   70: invokevirtual 122	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   73: astore_2
    //   74: aload_2
    //   75: ifnull +57 -> 132
    //   78: aload_2
    //   79: invokevirtual 128	java/lang/String:length	()I
    //   82: iconst_4
    //   83: if_icmplt +49 -> 132
    //   86: aload_2
    //   87: iconst_3
    //   88: invokevirtual 132	java/lang/String:charAt	(I)C
    //   91: istore_1
    //   92: iload_1
    //   93: bipush 115
    //   95: if_icmpeq +9 -> 104
    //   98: iload_1
    //   99: bipush 120
    //   101: if_icmpne +31 -> 132
    //   104: aload 5
    //   106: ifnull +8 -> 114
    //   109: aload 5
    //   111: invokevirtual 135	java/io/BufferedReader:close	()V
    //   114: aload_0
    //   115: ifnull +7 -> 122
    //   118: aload_0
    //   119: invokevirtual 138	java/lang/Process:destroy	()V
    //   122: iconst_1
    //   123: ireturn
    //   124: astore_2
    //   125: aload_2
    //   126: invokestatic 144	com/baidu/sapi2/utils/L:e	(Ljava/lang/Throwable;)V
    //   129: goto -15 -> 114
    //   132: aload 5
    //   134: ifnull +8 -> 142
    //   137: aload 5
    //   139: invokevirtual 135	java/io/BufferedReader:close	()V
    //   142: aload_0
    //   143: ifnull +115 -> 258
    //   146: aload_0
    //   147: invokevirtual 138	java/lang/Process:destroy	()V
    //   150: iconst_0
    //   151: ireturn
    //   152: astore_2
    //   153: aload_2
    //   154: invokestatic 144	com/baidu/sapi2/utils/L:e	(Ljava/lang/Throwable;)V
    //   157: goto -15 -> 142
    //   160: astore 5
    //   162: aload 4
    //   164: astore_0
    //   165: aload 6
    //   167: astore 4
    //   169: aload 4
    //   171: astore_3
    //   172: aload_0
    //   173: astore_2
    //   174: aload 5
    //   176: invokestatic 144	com/baidu/sapi2/utils/L:e	(Ljava/lang/Throwable;)V
    //   179: aload 4
    //   181: ifnull +8 -> 189
    //   184: aload 4
    //   186: invokevirtual 135	java/io/BufferedReader:close	()V
    //   189: aload_0
    //   190: ifnull -40 -> 150
    //   193: aload_0
    //   194: invokevirtual 138	java/lang/Process:destroy	()V
    //   197: goto -47 -> 150
    //   200: astore_2
    //   201: aload_2
    //   202: invokestatic 144	com/baidu/sapi2/utils/L:e	(Ljava/lang/Throwable;)V
    //   205: goto -16 -> 189
    //   208: astore 4
    //   210: aload_2
    //   211: astore_0
    //   212: aload_3
    //   213: ifnull +7 -> 220
    //   216: aload_3
    //   217: invokevirtual 135	java/io/BufferedReader:close	()V
    //   220: aload_0
    //   221: ifnull +7 -> 228
    //   224: aload_0
    //   225: invokevirtual 138	java/lang/Process:destroy	()V
    //   228: aload 4
    //   230: athrow
    //   231: astore_2
    //   232: aload_2
    //   233: invokestatic 144	com/baidu/sapi2/utils/L:e	(Ljava/lang/Throwable;)V
    //   236: goto -16 -> 220
    //   239: astore 4
    //   241: aload 5
    //   243: astore_3
    //   244: goto -32 -> 212
    //   247: astore_2
    //   248: aload 5
    //   250: astore 4
    //   252: aload_2
    //   253: astore 5
    //   255: goto -86 -> 169
    //   258: goto -108 -> 150
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	paramString	String
    //   91	11	1	i	int
    //   1	86	2	str1	String
    //   124	2	2	localException1	Exception
    //   152	2	2	localException2	Exception
    //   173	1	2	str2	String
    //   200	11	2	localException3	Exception
    //   231	2	2	localException4	Exception
    //   247	6	2	localIOException1	java.io.IOException
    //   13	231	3	localObject1	Object
    //   3	182	4	localObject2	Object
    //   208	21	4	localObject3	Object
    //   239	1	4	localObject4	Object
    //   250	1	4	localObject5	Object
    //   6	132	5	localBufferedReader	java.io.BufferedReader
    //   160	89	5	localIOException2	java.io.IOException
    //   253	1	5	localIOException3	java.io.IOException
    //   9	157	6	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   109	114	124	java/lang/Exception
    //   137	142	152	java/lang/Exception
    //   14	40	160	java/io/IOException
    //   48	68	160	java/io/IOException
    //   184	189	200	java/lang/Exception
    //   14	40	208	finally
    //   48	68	208	finally
    //   174	179	208	finally
    //   216	220	231	java/lang/Exception
    //   68	74	239	finally
    //   78	92	239	finally
    //   68	74	247	java/io/IOException
    //   78	92	247	java/io/IOException
  }
  
  public static String buildBDUSSCookie(String paramString1, String paramString2, String paramString3)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date());
    if (TextUtils.isEmpty(paramString3)) {}
    for (int i = -8;; i = 8)
    {
      localCalendar.add(1, i);
      return buildCookie(paramString1, paramString2, paramString3, localCalendar.getTime());
    }
  }
  
  public static String buildCookie(String paramString1, String paramString2, String paramString3, Date paramDate)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.US);
    localSimpleDateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
    return paramString2 + "=" + paramString3 + ";domain=" + paramString1 + ";path=/;expires=" + localSimpleDateFormat.format(paramDate);
  }
  
  public static String buildIqiyiCookie(String paramString1, String paramString2, String paramString3)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(new Date());
    if (TextUtils.isEmpty(paramString3)) {}
    for (int i = -2;; i = 2)
    {
      localCalendar.add(5, i);
      return buildCookie(paramString1, paramString2, paramString3, localCalendar.getTime());
    }
  }
  
  public static boolean checkRequestPermission(String paramString, Context paramContext)
  {
    return (Build.VERSION.SDK_INT < 23) || (paramContext.checkSelfPermission(paramString) == 0);
  }
  
  public static String createRequestParams(List<NameValuePair> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        NameValuePair localNameValuePair = (NameValuePair)paramList.next();
        if ((!TextUtils.isEmpty(localNameValuePair.getName())) && (!TextUtils.isEmpty(localNameValuePair.getValue()))) {
          if (TextUtils.isEmpty(localStringBuilder.toString())) {
            localStringBuilder.append(localNameValuePair.getName()).append("=").append(localNameValuePair.getValue());
          } else {
            localStringBuilder.append("&").append(localNameValuePair.getName()).append("=").append(localNameValuePair.getValue());
          }
        }
      }
    }
    return localStringBuilder.toString();
  }
  
  public static int dip2px(Context paramContext, float paramFloat)
  {
    if (paramContext == null) {
      throw new IllegalArgumentException("Context can't be null");
    }
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static String getAppName(Context paramContext)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      paramContext = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).applicationInfo.loadLabel(localPackageManager).toString();
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return null;
  }
  
  public static List<String> getAuthorizedDomains(Context paramContext)
  {
    if (paramContext == null) {
      return Collections.emptyList();
    }
    return b.a(paramContext).l();
  }
  
  public static String getClientId(Context paramContext)
  {
    try
    {
      paramContext = DeviceId.getDeviceID(paramContext);
      return paramContext;
    }
    catch (Throwable paramContext) {}
    return "123456789";
  }
  
  public static String getCookieBduss()
  {
    String str = "";
    Object localObject2 = CookieManager.getInstance().getCookie("http://www.baidu.com");
    Object localObject1 = str;
    int j;
    int i;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = ((String)localObject2).split(";");
      j = localObject2.length;
      i = 0;
    }
    for (;;)
    {
      localObject1 = str;
      if (i < j)
      {
        localObject1 = localObject2[i].trim();
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject1 = ((String)localObject1).split("=");
          if ((localObject1.length == 2) && (localObject1[0].equals("BDUSS"))) {
            localObject1 = localObject1[1];
          }
        }
      }
      else
      {
        return (String)localObject1;
      }
      i += 1;
    }
  }
  
  public static String getFastRegChannel(Context paramContext)
  {
    if (paramContext != null)
    {
      paramContext = b.a(paramContext).m();
      if (!TextUtils.isEmpty(paramContext)) {
        return paramContext;
      }
    }
    return "10698000036592";
  }
  
  public static String getLocalIpAddress()
  {
    try
    {
      label26:
      Object localObject;
      int i;
      do
      {
        do
        {
          do
          {
            Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
            break label26;
            Enumeration localEnumeration2;
            while (!localEnumeration2.hasMoreElements())
            {
              if (!localEnumeration1.hasMoreElements()) {
                break;
              }
              localEnumeration2 = ((NetworkInterface)localEnumeration1.nextElement()).getInetAddresses();
            }
            localObject = (InetAddress)localEnumeration2.nextElement();
          } while (((InetAddress)localObject).isLoopbackAddress());
          localObject = ((InetAddress)localObject).getHostAddress();
        } while (localObject == null);
        i = ((String)localObject).length();
      } while (i <= 0);
      return (String)localObject;
    }
    catch (Throwable localThrowable)
    {
      L.e(localThrowable);
    }
    return null;
  }
  
  @TargetApi(3)
  public static String getNetworkClass(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if ((paramContext == null) || (!paramContext.isConnected())) {
        break label137;
      }
      if (paramContext.getType() == 1) {
        return "WIFI";
      }
      if (paramContext.getType() == 0) {
        switch (paramContext.getSubtype())
        {
        case 13: 
          return "4G";
        }
      }
    }
    catch (Throwable paramContext)
    {
      L.e(paramContext);
    }
    return "UNKNOWN";
    label137:
    return "UNCNCT";
    return "UNKNOWN";
    return "2G";
    return "3G";
  }
  
  public static int getVersionCode(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    try
    {
      int i = localPackageManager.getPackageInfo(paramContext.getPackageName(), 0).versionCode;
      return i;
    }
    catch (Exception paramContext) {}
    return 0;
  }
  
  public static String getVersionName(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (Throwable paramContext)
    {
      L.e(paramContext);
    }
    return "0";
  }
  
  public static String getWifiInfo(Context paramContext)
  {
    Object localObject3 = (WifiManager)paramContext.getSystemService("wifi");
    Object localObject2 = ((WifiManager)localObject3).getConnectionInfo();
    Object localObject1 = "";
    int i = 0;
    if (localObject2 != null)
    {
      j = StrictMath.abs(((WifiInfo)localObject2).getRssi());
      localObject2 = ((WifiInfo)localObject2).getBSSID();
      localObject1 = localObject2;
      i = j;
      if (localObject2 != null)
      {
        localObject1 = ((String)localObject2).replace(":", "");
        i = j;
      }
    }
    localObject2 = null;
    if (checkRequestPermission("android.permission.ACCESS_COARSE_LOCATION", paramContext)) {
      localObject2 = ((WifiManager)localObject3).getScanResults();
    }
    int j = 0;
    localObject3 = new StringBuffer();
    if (localObject2 != null)
    {
      paramContext = ((List)localObject2).iterator();
      while (paramContext.hasNext())
      {
        localObject2 = (ScanResult)paramContext.next();
        String str = ((ScanResult)localObject2).BSSID;
        int k = StrictMath.abs(((ScanResult)localObject2).level);
        localObject2 = str.replace(":", "");
        if ((!((String)localObject1).equals(localObject2)) && (k != 0))
        {
          if (j >= 10) {
            break;
          }
          ((StringBuffer)localObject3).append("h").append((String)localObject2).append("m").append(k);
          j += 1;
        }
      }
    }
    paramContext = "";
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      paramContext = "h" + (String)localObject1 + "km" + i;
    }
    return paramContext + ((StringBuffer)localObject3).toString();
  }
  
  public static boolean hasActiveNetwork(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return false;
      try
      {
        paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
        if (paramContext != null) {
          return true;
        }
      }
      catch (Throwable paramContext)
      {
        L.e(paramContext);
      }
    }
    return false;
  }
  
  public static boolean isQrLoginSchema(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (!paramString.contains("error")) || (!paramString.contains("sign")) || (!paramString.contains("cmd")) || (!paramString.contains("lp"))) {
      return false;
    }
    HashMap localHashMap = new HashMap();
    paramString = paramString.split("&");
    int j = paramString.length;
    int i = 0;
    if (i < j)
    {
      String[] arrayOfString = paramString[i].split("=");
      if (arrayOfString.length > 1) {
        localHashMap.put(arrayOfString[0], arrayOfString[1]);
      }
      for (;;)
      {
        i += 1;
        break;
        if (arrayOfString.length == 1) {
          localHashMap.put(arrayOfString[0], "");
        }
      }
    }
    return (!TextUtils.isEmpty((CharSequence)localHashMap.get("error"))) && (!TextUtils.isEmpty((CharSequence)localHashMap.get("sign"))) && (!TextUtils.isEmpty((CharSequence)localHashMap.get("cmd"))) && (!TextUtils.isEmpty((CharSequence)localHashMap.get("lp")));
  }
  
  public static boolean isRoot()
  {
    return ((new File("/system/bin/su").exists()) && (a("/system/bin/su"))) || ((new File("/system/xbin/su").exists()) && (a("/system/xbin/su")));
  }
  
  public static boolean isSimReady(Context paramContext)
  {
    if ((paramContext == null) || (paramContext.checkCallingOrSelfPermission("android.permission.SEND_SMS") != 0)) {
      return false;
    }
    switch (((TelephonyManager)paramContext.getSystemService("phone")).getSimState())
    {
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    default: 
      return false;
    }
    return true;
  }
  
  public static boolean isValidAccount(SapiAccount paramSapiAccount)
  {
    return (paramSapiAccount != null) && (!TextUtils.isEmpty(paramSapiAccount.bduss)) && (!TextUtils.isEmpty(paramSapiAccount.uid)) && (!TextUtils.isEmpty(paramSapiAccount.displayname));
  }
  
  public static boolean isValidPhoneNumber(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return Pattern.compile("^(1)\\d{10}$").matcher(paramString).matches();
  }
  
  public static boolean isValidUsername(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (paramString.length() <= 14) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static Map<String, String> parseQrLoginSchema(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (!isQrLoginSchema(paramString)) {
      return localHashMap;
    }
    paramString = paramString.split("&");
    int j = paramString.length;
    int i = 0;
    label29:
    String[] arrayOfString;
    if (i < j)
    {
      arrayOfString = paramString[i].split("=");
      if (arrayOfString.length <= 1) {
        break label73;
      }
      localHashMap.put(arrayOfString[0], arrayOfString[1]);
    }
    for (;;)
    {
      i += 1;
      break label29;
      break;
      label73:
      if (arrayOfString.length == 1) {
        localHashMap.put(arrayOfString[0], "");
      }
    }
  }
  
  public static void resetSilentShareStatus(Context paramContext)
  {
    if ((paramContext != null) && (b.a(paramContext).d() == null)) {
      b.a(paramContext).i();
    }
  }
  
  @TargetApi(4)
  public static boolean sendSms(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    try
    {
      SmsManager.getDefault().sendTextMessage(paramString2, null, paramString1, null, null);
      return true;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public static void syncCookies(Context paramContext, List<NameValuePair> paramList)
  {
    CookieSyncManager.createInstance(paramContext);
    CookieManager localCookieManager = CookieManager.getInstance();
    localCookieManager.setAcceptCookie(true);
    SapiConfiguration localSapiConfiguration = SapiAccountManager.getInstance().getSapiConfiguration();
    if (TextUtils.isEmpty(localSapiConfiguration.clientId)) {
      localSapiConfiguration.clientId = getClientId(paramContext);
    }
    paramContext = "cuid=" + localSapiConfiguration.clientId + ";domain=" + localSapiConfiguration.environment.getWap().replace("http://", "").replaceAll("(:[0-9]{1,4})?", "") + ";path=/";
    localCookieManager.setCookie(localSapiConfiguration.environment.getWap(), paramContext);
    if (paramList != null)
    {
      paramContext = paramList.iterator();
      while (paramContext.hasNext())
      {
        paramList = (NameValuePair)paramContext.next();
        if ((!TextUtils.isEmpty(paramList.getName())) && (!TextUtils.isEmpty(paramList.getValue()))) {
          localCookieManager.setCookie(paramList.getName(), paramList.getValue());
        }
      }
    }
    CookieSyncManager.getInstance().sync();
  }
  
  public static boolean webLogin(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return false;
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = getAuthorizedDomains(paramContext).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localArrayList.add(new BasicNameValuePair("http://www." + str, a(str, paramString)));
      }
      syncCookies(paramContext, localArrayList);
      return true;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public static boolean webLogout(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = getAuthorizedDomains(paramContext).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localArrayList.add(new BasicNameValuePair("http://www." + str, a(str, "")));
      }
      syncCookies(paramContext, localArrayList);
      return true;
    }
    catch (Throwable paramContext) {}
    return false;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/sapi2/utils/SapiUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */