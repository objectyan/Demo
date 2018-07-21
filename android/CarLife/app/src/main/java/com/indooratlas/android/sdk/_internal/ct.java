package com.indooratlas.android.sdk._internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.hardware.Sensor;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import com.indooratlas.android.sdk.IALocation;
import com.indooratlas.android.sdk.IALocation.Builder;
import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ct
{
  public static int a(Cursor paramCursor, Writer paramWriter)
    throws IOException
  {
    int i = paramCursor.getCount();
    if ((i > 0) && (paramCursor.moveToFirst()))
    {
      paramWriter.write(91);
      do
      {
        paramWriter.write(paramCursor.getString(0));
        if (!paramCursor.isLast()) {
          paramWriter.write(",");
        }
      } while (paramCursor.moveToNext());
      paramWriter.write(93);
    }
    return i;
  }
  
  public static int a(int[] paramArrayOfInt)
  {
    int i = 0;
    while (i < 4)
    {
      int j = paramArrayOfInt[i];
      if (j != -1) {
        return j;
      }
      i += 1;
    }
    return -1;
  }
  
  public static IALocation a(cx paramcx)
  {
    if ((paramcx == null) || (!paramcx.b())) {
      return null;
    }
    dq localdq = (dq)paramcx.c;
    if (localdq.a == 65236) {
      paramcx = "gps";
    }
    for (;;)
    {
      return new IALocation.Builder(paramcx).withLatitude(localdq.c).withLongitude(localdq.d).withAccuracy(localdq.e).withAltitude(localdq.f).withBearing(localdq.g).withTime(localdq.i).build();
      if (localdq.a == 65235) {
        paramcx = "network";
      } else {
        paramcx = "passive";
      }
    }
  }
  
  public static String a()
  {
    return String.format(Locale.US, "%s; %s-%d; %s; Android %d", new Object[] { "indooratlas-android-sdk", "2.4.2", Integer.valueOf(743), "release", Integer.valueOf(Build.VERSION.SDK_INT) });
  }
  
  private static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "unknown";
    case 0: 
      return "unknown";
    case -1: 
      return "all";
    case 1: 
      return "acc";
    case 2: 
      return "magn_calib";
    case 3: 
      return "orientation";
    case 4: 
      return "gyro_calib";
    case 5: 
      return "light";
    case 6: 
      return "pressure";
    case 8: 
      return "proximity";
    case 9: 
      return "gravity";
    case 10: 
      return "linear_acc";
    case 11: 
      return "rot_vec";
    case 12: 
      return "humidity";
    case 13: 
      return "temp";
    case 14: 
      return "magn_uncalib";
    case 15: 
      return "game_rot_vec";
    case 16: 
      return "gyro_uncalib";
    case 17: 
      return "significant_motion";
    case 18: 
      return "step_detector";
    case 19: 
      return "step_counter";
    case 20: 
      return "geomagn_rot_vec";
    case 21: 
      return "hearth_rate";
    case 22: 
      return "tilt_detector";
    case 23: 
      return "wake_gesture";
    case 24: 
      return "glance_gesture";
    case 25: 
      return "pick_up_gesture";
    case 26: 
      return "wrist_tilt_gesture";
    case -100: 
      return "wifi";
    case -101: 
      return "wifi_passive";
    case -200: 
      return "ble";
    case -300: 
      return "gps_location";
    }
    return "network_location";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = a(a(paramString1 + "_" + paramString2));
      return paramString1;
    }
    catch (NoSuchAlgorithmException paramString1)
    {
      throw new IllegalStateException(paramString1);
    }
    catch (UnsupportedEncodingException paramString1)
    {
      throw new IllegalStateException(paramString1);
    }
  }
  
  public static String a(String paramString, Object... paramVarArgs)
  {
    try
    {
      String str = String.format(Locale.US, paramString, paramVarArgs);
      return str;
    }
    catch (IllegalFormatException localIllegalFormatException)
    {
      ee.a("IACore", "bad string format: " + paramString + ", args: " + Arrays.toString(paramVarArgs), new Object[0]);
    }
    return paramString;
  }
  
  public static String a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return "null response";
    }
    if (paramJSONObject.length() == 0) {
      return "no keys in response";
    }
    if (TextUtils.isEmpty(paramJSONObject.optString("key"))) {
      return "missing mandatory key: 'key'";
    }
    paramJSONObject = paramJSONObject.optString("url");
    if (TextUtils.isEmpty(paramJSONObject)) {
      return "missing mandatory key: 'url'";
    }
    try
    {
      new URI(paramJSONObject);
      return null;
    }
    catch (URISyntaxException localURISyntaxException) {}
    return "malformed url: " + paramJSONObject;
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(Integer.toString((paramArrayOfByte[i] & 0xFF) + 256, 16).substring(1));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static String a(String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      if (!ei.a(str)) {
        return str;
      }
      i += 1;
    }
    return null;
  }
  
  public static ArrayList<String> a(Context paramContext, String... paramVarArgs)
  {
    ArrayList localArrayList = new ArrayList(0);
    paramContext = paramContext.getPackageManager();
    int i = 0;
    while (i <= 0)
    {
      String str = paramVarArgs[0];
      if (!paramContext.hasSystemFeature(str)) {
        localArrayList.add(str);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public static JSONObject a(Context paramContext, String paramString, JSONObject paramJSONObject)
  {
    try
    {
      paramString = new JSONObject().put("idauuid", paramString);
      Object localObject = ck.a(paramContext);
      localObject = paramString.put("bundle", new JSONObject().put("id", ((ck)localObject).a).put("version", ((ck)localObject).b));
      if (TextUtils.isEmpty("")) {}
      for (paramString = "release";; paramString = ",release")
      {
        paramString = ((JSONObject)localObject).put("sdk", new JSONObject().put("id", "indooratlas-android-sdk").put("version", "2.4.2").put("build", "743").put("variant", paramString).put("apiLevel", 4));
        localObject = ar.a();
        paramContext = paramString.put("platform", new JSONObject().put("os", "Android").put("osVersion", ((ar)localObject).a(ar.c.m)).put("manufacturer", ((ar)localObject).a(ar.c.f)).put("device", ((ar)localObject).a(ar.c.d)).put("product", ((ar)localObject).a(ar.c.c)).put("model", ((ar)localObject).a(ar.c.h)).put("board", ((ar)localObject).a(ar.c.e)).put("hardware", ((ar)localObject).a(ar.c.j)).put("apiLevel", String.valueOf(((ar)localObject).a(ar.b.a))).put("sensors", c(paramContext)));
        if (paramJSONObject == null) {
          break;
        }
        paramContext.put("androidNativeSensors", paramJSONObject);
        return paramContext;
      }
      return paramContext;
    }
    catch (JSONException paramContext)
    {
      throw new IllegalStateException("failure creating init sdk json", paramContext);
    }
  }
  
  public static JSONObject a(List<cw> paramList)
  {
    if (paramList == null) {
      throw new IllegalArgumentException("sensor list cannot be null");
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Object localObject = (cw)paramList.next();
        if (((cw)localObject).b() != null)
        {
          String str = a(((cw)localObject).a());
          localObject = ((cw)localObject).b();
          JSONObject localJSONObject2 = new JSONObject();
          if (Build.VERSION.SDK_INT >= 19)
          {
            localJSONObject2.put("fifoMaxEventCount", ((Sensor)localObject).getFifoMaxEventCount());
            localJSONObject2.put("fifoReservedEventCount", ((Sensor)localObject).getFifoReservedEventCount());
          }
          if (Build.VERSION.SDK_INT >= 21) {
            localJSONObject2.put("maxDelay", ((Sensor)localObject).getMaxDelay());
          }
          a(localJSONObject2, "maximumRange", ((Sensor)localObject).getMaximumRange());
          localJSONObject2.put("minDelay", ((Sensor)localObject).getMinDelay());
          localJSONObject2.put("name", ((Sensor)localObject).getName());
          a(localJSONObject2, "power", ((Sensor)localObject).getPower());
          if (Build.VERSION.SDK_INT >= 21) {
            localJSONObject2.put("reportingMode", ((Sensor)localObject).getReportingMode());
          }
          a(localJSONObject2, "resolution", ((Sensor)localObject).getResolution());
          if (Build.VERSION.SDK_INT >= 20) {
            localJSONObject2.put("stringType", ((Sensor)localObject).getStringType());
          }
          localJSONObject2.put("type", ((Sensor)localObject).getType());
          localJSONObject2.put("vendor", ((Sensor)localObject).getVendor());
          localJSONObject2.put("version", ((Sensor)localObject).getVersion());
          localJSONObject1.put(str, localJSONObject2);
        }
      }
      return localJSONObject1;
    }
    catch (JSONException paramList)
    {
      ee.a("IACore", "Failed to create json array with all sensors", new Object[] { paramList });
      return null;
    }
  }
  
  public static void a(Cursor paramCursor)
  {
    try
    {
      paramCursor.close();
      return;
    }
    catch (Throwable paramCursor) {}
  }
  
  private static void a(JSONObject paramJSONObject, String paramString, float paramFloat)
    throws JSONException
  {
    if ((!Float.isNaN(paramFloat)) && (!Float.isInfinite(paramFloat))) {
      paramJSONObject.put(paramString, paramFloat);
    }
  }
  
  public static boolean a(Context paramContext)
  {
    return (a(paramContext, "android.permission.BLUETOOTH")) && (a(paramContext, "android.permission.BLUETOOTH_ADMIN")) && (a(paramContext, "android.permission.ACCESS_COARSE_LOCATION"));
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    return paramContext.checkPermission(paramString, Process.myPid(), Process.myUid()) == 0;
  }
  
  public static byte[] a(String paramString)
    throws NoSuchAlgorithmException, UnsupportedEncodingException
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("SHA-256");
    localMessageDigest.reset();
    localMessageDigest.update(paramString.getBytes("UTF-8"));
    return localMessageDigest.digest();
  }
  
  public static String b(String paramString)
  {
    try
    {
      String str = System.getProperty(paramString);
      return str;
    }
    catch (Exception localException)
    {
      ee.a("IACore", "Unable to read property: %s", new Object[] { paramString });
    }
    return null;
  }
  
  @TargetApi(18)
  public static boolean b(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 18) {
      return paramContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }
    return false;
  }
  
  public static int c(String paramString)
  {
    int i = -1;
    String str = b(paramString);
    if (str != null) {}
    try
    {
      i = Integer.parseInt(str);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      ee.a("IACore", "Unable to read property int: %s", new Object[] { paramString });
    }
    return -1;
  }
  
  private static JSONArray c(Context paramContext)
    throws JSONException
  {
    paramContext = cz.a(paramContext);
    Object localObject = new ArrayList(6);
    ((ArrayList)localObject).add(paramContext.a(1));
    ((ArrayList)localObject).add(paramContext.a(4));
    ((ArrayList)localObject).add(paramContext.a(16));
    ((ArrayList)localObject).add(paramContext.a(2));
    ((ArrayList)localObject).add(paramContext.a(14));
    ((ArrayList)localObject).add(paramContext.a(6));
    paramContext = new JSONArray();
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      cw localcw = (cw)((Iterator)localObject).next();
      if (localcw != null) {
        paramContext.put(a(localcw.a()));
      }
    }
    return paramContext;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ct.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */