package com.baidu.android.pushservice.c;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.android.pushservice.PushSettings;
import com.baidu.android.pushservice.h;
import com.baidu.android.pushservice.j.m;
import com.baidu.android.pushservice.j.p;
import com.coloros.mcssdk.PushManager;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class d
  extends b
{
  private static int f = 259200000;
  private static boolean g = false;
  private static d h;
  private static String[] n = { "/default.prop", "/system/build.prop", "/system/default.prop", "/data/local.prop" };
  public HashMap<String, c> d;
  private String e = "https://api.tuisong.baidu.com/rest/3.0/clientfile/updatesdkconfig";
  private int i;
  private c j;
  private int k = 0;
  private int l = com.baidu.android.pushservice.a.a();
  private String m = null;
  
  protected d(Context paramContext)
  {
    super(paramContext);
    this.c = ("/data/data/" + this.a.getPackageName() + "/files/bdpush_modeconfig.json");
    f();
  }
  
  public static d a(Context paramContext)
  {
    if (h != null) {
      return h;
    }
    h = new d(paramContext);
    return h;
  }
  
  private String a(HashMap<String, String> paramHashMap)
  {
    Object localObject;
    int i1;
    if (h.f())
    {
      localObject = h.a();
      if (((!p.a()) || (!PushSettings.m(this.a))) && ((!p.c()) || (!PushSettings.p(this.a))) && ((!p.b()) || (!PushSettings.n(this.a))) && ((!p.d()) || (!PushSettings.o(this.a)))) {
        break label154;
      }
      this.e = ((String)localObject + "/rest/3.0/clientfile/updateconf");
      i1 = 2;
    }
    int i2;
    label154:
    label183:
    do
    {
      for (;;)
      {
        localObject = com.baidu.android.pushservice.f.b.a(this.e, "POST", paramHashMap, "BCCS_SDK/3.0");
        if (localObject == null) {
          break label183;
        }
        i2 = ((com.baidu.android.pushservice.f.a)localObject).b();
        localObject = com.baidu.android.pushservice.h.a.b.a(((com.baidu.android.pushservice.f.a)localObject).a());
        if (i2 != 200) {
          break label183;
        }
        return (String)localObject;
        localObject = h.b();
        break;
        this.e = ((String)localObject + "/rest/3.0/clientfile/updatesdkconfig");
        i1 = 2;
      }
      i2 = i1 - 1;
      i1 = i2;
    } while (i2 > 0);
    return null;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
    int i1 = 0;
    while (i1 < paramArrayOfByte.length)
    {
      Object localObject2 = Integer.toHexString(paramArrayOfByte[i1]);
      int i2 = ((String)localObject2).length();
      Object localObject1 = localObject2;
      if (i2 == 1) {
        localObject1 = "0" + (String)localObject2;
      }
      localObject2 = localObject1;
      if (i2 > 2) {
        localObject2 = ((String)localObject1).substring(i2 - 2, i2);
      }
      localStringBuffer.append(((String)localObject2).toUpperCase(Locale.ENGLISH));
      i1 += 1;
    }
    return localStringBuffer.toString();
  }
  
  private void a(c paramc)
  {
    String str = "CONFIG_MANUFACTURER_DEFAULT";
    if (paramc != null) {
      str = paramc.toString();
    }
    m.a(this.a, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE", str);
    m.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", this.i);
    k();
  }
  
  private boolean a(c paramc, String paramString)
  {
    int i2;
    if ((paramc != null) && (paramc.d() != null) && (paramc.d().size() > 0)) {
      i2 = 0;
    }
    for (;;)
    {
      e locale;
      if (i2 < paramc.d().size()) {
        locale = (e)paramc.d().get(i2);
      }
      try
      {
        localObject2 = com.baidu.android.pushservice.j.a.a().a(locale.a(), "");
        localObject3 = locale.b();
        boolean bool;
        double d1;
        if (locale.c() == 0)
        {
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label697;
          }
          bool = TextUtils.isEmpty((CharSequence)localObject2);
          if (bool) {
            break label697;
          }
          d1 = 0.0D;
          try
          {
            d2 = Double.parseDouble((String)localObject3);
            d1 = d2;
            double d3 = Double.parseDouble((String)localObject2);
            d1 = d3;
          }
          catch (NumberFormatException localNumberFormatException1)
          {
            for (;;)
            {
              double d2 = d1;
              d1 = 0.0D;
            }
            com.baidu.android.pushservice.g.a.a("ModeConfig", "manufaturer can not Matched, osversion is not ABOVE ", this.a);
          }
          if (d1 >= d2) {
            return true;
          }
        }
        if (localNumberFormatException1.c() == 1)
        {
          if (TextUtils.isEmpty((CharSequence)localObject3)) {
            break label697;
          }
          bool = TextUtils.isEmpty((CharSequence)localObject2);
          if (bool) {
            break label697;
          }
          i1 = 0;
          try
          {
            i3 = Integer.parseInt((String)localObject3);
            i1 = i3;
            int i4 = Integer.parseInt((String)localObject2);
            i1 = i4;
          }
          catch (NumberFormatException localNumberFormatException2)
          {
            for (;;)
            {
              i3 = i1;
              i1 = 0;
            }
            com.baidu.android.pushservice.g.a.a("ModeConfig", "manufaturer can not Matched, osversion is not EQUAL ", this.a);
          }
          if (i1 == i3) {
            return true;
          }
        }
        if (localNumberFormatException2.c() != 2) {
          break label697;
        }
        if (Pattern.matches((String)localObject3, (CharSequence)localObject2)) {
          return true;
        }
        com.baidu.android.pushservice.g.a.a("ModeConfig", "manufaturer can not Matched, osversion is not REGULAR ", this.a);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Object localObject2;
          Object localObject3;
          int i1;
          int i3;
          label656:
          label697:
          continue;
          i1 += 1;
        }
      }
      if ((paramc.e() != null) && (paramc.e().size() > 0))
      {
        i1 = 0;
        if (i1 < paramc.e().size())
        {
          localObject3 = (f)paramc.e().get(i1);
          try
          {
            Object localObject1 = Class.forName("android.os.SystemProperties");
            localObject2 = (String)((Class)localObject1).getDeclaredMethod("get", new Class[] { String.class }).invoke(localObject1, new Object[] { ((f)localObject3).a() });
            localObject1 = Build.MODEL.toLowerCase();
            i3 = 0;
            i2 = i3;
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              i2 = i3;
              if (((String)localObject1).contains("nexus"))
              {
                i2 = 1;
                com.baidu.android.pushservice.g.a.a("ModeConfig", "manufaturer  is Nexus ", this.a);
              }
            }
            localObject1 = localObject2;
            if (paramString.equalsIgnoreCase("HUAWEI"))
            {
              localObject1 = localObject2;
              if (i2 == 0)
              {
                localObject1 = localObject2;
                if (!((String)localObject2).matches("\\d+\\.\\d+$"))
                {
                  localObject1 = localObject2;
                  if (Build.VERSION.SDK_INT >= 21)
                  {
                    localObject1 = localObject2;
                    if (PushSettings.p(this.a)) {
                      localObject1 = "3.1";
                    }
                  }
                }
              }
            }
            localObject2 = localObject1;
            if (paramString.equalsIgnoreCase("OPPO"))
            {
              localObject2 = localObject1;
              if (PushSettings.o(this.a))
              {
                localObject2 = localObject1;
                if (!h(this.a)) {
                  localObject2 = "V1.0";
                }
              }
            }
            localObject1 = Pattern.compile(((f)localObject3).c()).matcher((CharSequence)localObject2);
            if (!((Matcher)localObject1).find()) {
              break;
            }
            if (paramString.equalsIgnoreCase("OPPO")) {}
            for (localObject1 = ((Matcher)localObject1).group(1);; localObject1 = ((Matcher)localObject1).group())
            {
              localObject1 = Double.valueOf((String)localObject1);
              localObject2 = Double.valueOf(((f)localObject3).b());
              if (((f)localObject3).d() != 0) {
                break label656;
              }
              if (((Double)localObject1).doubleValue() < ((Double)localObject2).doubleValue()) {
                break;
              }
              return true;
            }
            com.baidu.android.pushservice.g.a.a("ModeConfig", "versioncode < configversioncode, manufaturer can not Matched, osversion is not ABOVE ", this.a);
            break;
            if (((f)localObject3).d() != 1) {
              break;
            }
            if (localObject1 == localObject2) {
              return true;
            }
            com.baidu.android.pushservice.g.a.a("ModeConfig", "versioncode != configversioncode, manufaturer can not Matched, osversion is not EQUAL ", this.a);
          }
          catch (Exception localException1) {}
        }
      }
      return false;
      i2 += 1;
    }
  }
  
  private c b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    paramString = paramString.toUpperCase();
    if ((Build.MANUFACTURER.toUpperCase().equalsIgnoreCase("unknown")) && (this.d != null)) {
      paramString = this.d.entrySet().iterator();
    }
    while (paramString.hasNext())
    {
      String str = (String)((Map.Entry)paramString.next()).getKey();
      if (a((c)this.d.get(str), str))
      {
        return (c)this.d.get(str);
        if ((this.d != null) && (this.d.containsKey(paramString)) && (a((c)this.d.get(paramString), paramString))) {
          return (c)this.d.get(paramString);
        }
      }
    }
    return null;
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool2 = false;
    try
    {
      Class.forName("com.meizu.cloud.pushsdk.PushManager");
      boolean bool1 = bool2;
      if (a(paramContext).b() == 7)
      {
        boolean bool3 = PushSettings.n(paramContext);
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (ClassNotFoundException paramContext) {}
    return false;
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool2 = false;
    try
    {
      Class.forName("com.xiaomi.mipush.sdk.MiPushClient");
      boolean bool1 = bool2;
      if (a(paramContext).b() == 6)
      {
        boolean bool3 = PushSettings.m(paramContext);
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Throwable paramContext) {}
    return false;
  }
  
  public static boolean d(Context paramContext)
  {
    return (a(paramContext).b() == 5) && (PushSettings.p(paramContext));
  }
  
  public static boolean e(Context paramContext)
  {
    boolean bool2 = false;
    try
    {
      Class.forName("com.coloros.mcssdk.PushManager");
      boolean bool1 = bool2;
      if (a(paramContext).b() == 8)
      {
        boolean bool3 = PushSettings.o(paramContext);
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static boolean f(Context paramContext)
  {
    return (p.d()) && (h(paramContext));
  }
  
  public static boolean g(Context paramContext)
  {
    return (d(paramContext)) || (c(paramContext)) || (b(paramContext)) || (e(paramContext));
  }
  
  private boolean h()
  {
    try
    {
      Object localObject = new JSONObject(this.b);
      this.i = ((JSONObject)localObject).getInt("version");
      this.d = new HashMap();
      localObject = ((JSONObject)localObject).getJSONArray("modeconfig");
      int i1 = 0;
      while (i1 < ((JSONArray)localObject).length())
      {
        c localc = new c(((JSONArray)localObject).getString(i1));
        this.d.put(localc.b(), localc);
        i1 += 1;
      }
      this.j = b(Build.MANUFACTURER.toUpperCase());
      a(this.j);
      return true;
    }
    catch (JSONException localJSONException) {}
    return false;
  }
  
  private static boolean h(Context paramContext)
  {
    try
    {
      boolean bool = PushManager.isSupportPush(paramContext);
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  private boolean i()
  {
    this.i = m.b(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_VERSION", -1);
    if (this.i == -1) {}
    String str;
    do
    {
      return false;
      str = m.a(this.a, "com.baidu.android.pushservice.config.MODE_MANUFACTURER_CACHE");
    } while (TextUtils.isEmpty(str));
    if (!str.equals("CONFIG_MANUFACTURER_DEFAULT")) {
      this.j = new c(str);
    }
    return true;
  }
  
  private boolean j()
  {
    long l1 = 0L;
    long l2 = m.c(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE");
    if (System.currentTimeMillis() - l2 > 604800000L) {
      return true;
    }
    l2 = m.c(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED");
    Object localObject = new File(this.c);
    if (!((File)localObject).exists()) {
      return true;
    }
    if ((l2 <= 0L) || (l2 != ((File)localObject).lastModified())) {
      return true;
    }
    long l3 = m.c(this.a, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED");
    localObject = n;
    int i2 = localObject.length;
    int i1 = 0;
    while (i1 < i2)
    {
      File localFile = new File(localObject[i1]);
      l2 = l1;
      if (localFile.exists()) {
        l2 = l1 + localFile.lastModified() / 10L;
      }
      i1 += 1;
      l1 = l2;
    }
    return l3 != l1;
  }
  
  private void k()
  {
    Object localObject = new File(this.c);
    if (!((File)localObject).exists()) {
      return;
    }
    long l1 = ((File)localObject).lastModified();
    m.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_MODIFIED", l1);
    localObject = n;
    int i2 = localObject.length;
    l1 = 0L;
    int i1 = 0;
    while (i1 < i2)
    {
      File localFile = new File(localObject[i1]);
      long l2 = l1;
      if (localFile.exists()) {
        l2 = l1 + localFile.lastModified() / 10L;
      }
      i1 += 1;
      l1 = l2;
    }
    m.a(this.a, "com.baidu.android.pushservice.config.BUILD_LAST_MODIFIED", l1);
    m.a(this.a, "com.baidu.android.pushservice.config.MODE_CONFIG_LAST_CACHE", System.currentTimeMillis());
  }
  
  /* Error */
  public void a(a parama)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: putstatic 35	com/baidu/android/pushservice/c/d:g	Z
    //   6: invokestatic 118	com/baidu/android/pushservice/j/p:a	()Z
    //   9: ifeq +106 -> 115
    //   12: aload_0
    //   13: getfield 80	com/baidu/android/pushservice/c/d:a	Landroid/content/Context;
    //   16: invokestatic 123	com/baidu/android/pushservice/PushSettings:m	(Landroid/content/Context;)Z
    //   19: ifeq +96 -> 115
    //   22: aload_0
    //   23: getfield 80	com/baidu/android/pushservice/c/d:a	Landroid/content/Context;
    //   26: invokestatic 452	com/baidu/android/pushservice/c/d:c	(Landroid/content/Context;)Z
    //   29: istore_2
    //   30: iload_2
    //   31: ifne +84 -> 115
    //   34: aload_0
    //   35: getfield 80	com/baidu/android/pushservice/c/d:a	Landroid/content/Context;
    //   38: invokestatic 545	com/baidu/android/pushservice/j/p:D	(Landroid/content/Context;)Ljava/lang/String;
    //   41: astore 7
    //   43: aload 7
    //   45: invokestatic 262	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   48: ifne +20 -> 68
    //   51: aload 7
    //   53: invokestatic 551	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   56: f2d
    //   57: ldc2_w 552
    //   60: dcmpl
    //   61: iflt +7 -> 68
    //   64: iconst_0
    //   65: putstatic 33	com/baidu/android/pushservice/c/d:f	I
    //   68: aload_0
    //   69: getfield 80	com/baidu/android/pushservice/c/d:a	Landroid/content/Context;
    //   72: ldc_w 555
    //   75: invokestatic 514	com/baidu/android/pushservice/j/m:c	(Landroid/content/Context;Ljava/lang/String;)J
    //   78: lstore_3
    //   79: invokestatic 520	java/lang/System:currentTimeMillis	()J
    //   82: lstore 5
    //   84: lload 5
    //   86: lload_3
    //   87: lsub
    //   88: getstatic 33	com/baidu/android/pushservice/c/d:f	I
    //   91: i2l
    //   92: lcmp
    //   93: ifgt +259 -> 352
    //   96: aload_1
    //   97: ifnull +15 -> 112
    //   100: getstatic 35	com/baidu/android/pushservice/c/d:g	Z
    //   103: ifne +9 -> 112
    //   106: aload_1
    //   107: invokeinterface 557 1 0
    //   112: aload_0
    //   113: monitorexit
    //   114: return
    //   115: invokestatic 125	com/baidu/android/pushservice/j/p:c	()Z
    //   118: ifeq +67 -> 185
    //   121: aload_0
    //   122: getfield 80	com/baidu/android/pushservice/c/d:a	Landroid/content/Context;
    //   125: invokestatic 128	com/baidu/android/pushservice/PushSettings:p	(Landroid/content/Context;)Z
    //   128: ifeq +57 -> 185
    //   131: aload_0
    //   132: getfield 80	com/baidu/android/pushservice/c/d:a	Landroid/content/Context;
    //   135: invokestatic 450	com/baidu/android/pushservice/c/d:d	(Landroid/content/Context;)Z
    //   138: istore_2
    //   139: iload_2
    //   140: ifne +45 -> 185
    //   143: aload_0
    //   144: getfield 80	com/baidu/android/pushservice/c/d:a	Landroid/content/Context;
    //   147: invokestatic 545	com/baidu/android/pushservice/j/p:D	(Landroid/content/Context;)Ljava/lang/String;
    //   150: astore 7
    //   152: aload 7
    //   154: invokestatic 262	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   157: ifne -89 -> 68
    //   160: aload 7
    //   162: invokestatic 551	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   165: f2d
    //   166: ldc2_w 558
    //   169: dcmpl
    //   170: iflt -102 -> 68
    //   173: iconst_0
    //   174: putstatic 33	com/baidu/android/pushservice/c/d:f	I
    //   177: goto -109 -> 68
    //   180: astore 7
    //   182: goto -114 -> 68
    //   185: invokestatic 131	com/baidu/android/pushservice/j/p:b	()Z
    //   188: ifeq +67 -> 255
    //   191: aload_0
    //   192: getfield 80	com/baidu/android/pushservice/c/d:a	Landroid/content/Context;
    //   195: invokestatic 133	com/baidu/android/pushservice/PushSettings:n	(Landroid/content/Context;)Z
    //   198: ifeq +57 -> 255
    //   201: aload_0
    //   202: getfield 80	com/baidu/android/pushservice/c/d:a	Landroid/content/Context;
    //   205: invokestatic 454	com/baidu/android/pushservice/c/d:b	(Landroid/content/Context;)Z
    //   208: istore_2
    //   209: iload_2
    //   210: ifne +45 -> 255
    //   213: aload_0
    //   214: getfield 80	com/baidu/android/pushservice/c/d:a	Landroid/content/Context;
    //   217: invokestatic 545	com/baidu/android/pushservice/j/p:D	(Landroid/content/Context;)Ljava/lang/String;
    //   220: astore 7
    //   222: aload 7
    //   224: invokestatic 262	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   227: ifne -159 -> 68
    //   230: aload 7
    //   232: invokestatic 551	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   235: f2d
    //   236: ldc2_w 560
    //   239: dcmpl
    //   240: iflt -172 -> 68
    //   243: iconst_0
    //   244: putstatic 33	com/baidu/android/pushservice/c/d:f	I
    //   247: goto -179 -> 68
    //   250: astore 7
    //   252: goto -184 -> 68
    //   255: invokestatic 135	com/baidu/android/pushservice/j/p:d	()Z
    //   258: ifeq +67 -> 325
    //   261: aload_0
    //   262: getfield 80	com/baidu/android/pushservice/c/d:a	Landroid/content/Context;
    //   265: invokestatic 138	com/baidu/android/pushservice/PushSettings:o	(Landroid/content/Context;)Z
    //   268: ifeq +57 -> 325
    //   271: aload_0
    //   272: getfield 80	com/baidu/android/pushservice/c/d:a	Landroid/content/Context;
    //   275: invokestatic 456	com/baidu/android/pushservice/c/d:e	(Landroid/content/Context;)Z
    //   278: istore_2
    //   279: iload_2
    //   280: ifne +45 -> 325
    //   283: aload_0
    //   284: getfield 80	com/baidu/android/pushservice/c/d:a	Landroid/content/Context;
    //   287: invokestatic 545	com/baidu/android/pushservice/j/p:D	(Landroid/content/Context;)Ljava/lang/String;
    //   290: astore 7
    //   292: aload 7
    //   294: invokestatic 262	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   297: ifne -229 -> 68
    //   300: aload 7
    //   302: invokestatic 551	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   305: f2d
    //   306: ldc2_w 562
    //   309: dcmpl
    //   310: iflt -242 -> 68
    //   313: iconst_0
    //   314: putstatic 33	com/baidu/android/pushservice/c/d:f	I
    //   317: goto -249 -> 68
    //   320: astore 7
    //   322: goto -254 -> 68
    //   325: ldc 31
    //   327: putstatic 33	com/baidu/android/pushservice/c/d:f	I
    //   330: aload_1
    //   331: ifnull -263 -> 68
    //   334: iconst_1
    //   335: putstatic 35	com/baidu/android/pushservice/c/d:g	Z
    //   338: aload_1
    //   339: invokeinterface 557 1 0
    //   344: goto -276 -> 68
    //   347: astore_1
    //   348: aload_0
    //   349: monitorexit
    //   350: aload_1
    //   351: athrow
    //   352: invokestatic 568	com/baidu/android/pushservice/i/d:a	()Lcom/baidu/android/pushservice/i/d;
    //   355: new 6	com/baidu/android/pushservice/c/d$1
    //   358: dup
    //   359: aload_0
    //   360: ldc_w 570
    //   363: bipush 100
    //   365: lload 5
    //   367: aload_1
    //   368: invokespecial 573	com/baidu/android/pushservice/c/d$1:<init>	(Lcom/baidu/android/pushservice/c/d;Ljava/lang/String;SJLcom/baidu/android/pushservice/c/d$a;)V
    //   371: invokevirtual 576	com/baidu/android/pushservice/i/d:a	(Lcom/baidu/android/pushservice/i/c;)Z
    //   374: pop
    //   375: goto -263 -> 112
    //   378: astore 7
    //   380: goto -312 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	383	0	this	d
    //   0	383	1	parama	a
    //   29	251	2	bool	boolean
    //   78	9	3	l1	long
    //   82	284	5	l2	long
    //   41	120	7	str1	String
    //   180	1	7	localException1	Exception
    //   220	11	7	str2	String
    //   250	1	7	localException2	Exception
    //   290	11	7	str3	String
    //   320	1	7	localException3	Exception
    //   378	1	7	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   143	177	180	java/lang/Exception
    //   213	247	250	java/lang/Exception
    //   283	317	320	java/lang/Exception
    //   2	30	347	finally
    //   34	68	347	finally
    //   68	96	347	finally
    //   100	112	347	finally
    //   115	139	347	finally
    //   143	177	347	finally
    //   185	209	347	finally
    //   213	247	347	finally
    //   255	279	347	finally
    //   283	317	347	finally
    //   325	330	347	finally
    //   334	344	347	finally
    //   352	375	347	finally
    //   34	68	378	java/lang/Exception
  }
  
  public int b()
  {
    return this.k;
  }
  
  public String c()
  {
    return this.m;
  }
  
  public int d()
  {
    return this.l;
  }
  
  /* Error */
  public boolean e()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload_0
    //   4: getfield 493	com/baidu/android/pushservice/c/d:j	Lcom/baidu/android/pushservice/c/c;
    //   7: ifnonnull +5 -> 12
    //   10: iconst_1
    //   11: ireturn
    //   12: aload_0
    //   13: getfield 493	com/baidu/android/pushservice/c/d:j	Lcom/baidu/android/pushservice/c/c;
    //   16: invokevirtual 581	com/baidu/android/pushservice/c/c:c	()I
    //   19: iconst_5
    //   20: if_icmpne +10 -> 30
    //   23: aload_0
    //   24: iconst_5
    //   25: putfield 58	com/baidu/android/pushservice/c/d:k	I
    //   28: iconst_1
    //   29: ireturn
    //   30: aload_0
    //   31: getfield 493	com/baidu/android/pushservice/c/d:j	Lcom/baidu/android/pushservice/c/c;
    //   34: invokevirtual 581	com/baidu/android/pushservice/c/c:c	()I
    //   37: bipush 6
    //   39: if_icmpne +11 -> 50
    //   42: aload_0
    //   43: bipush 6
    //   45: putfield 58	com/baidu/android/pushservice/c/d:k	I
    //   48: iconst_1
    //   49: ireturn
    //   50: aload_0
    //   51: getfield 493	com/baidu/android/pushservice/c/d:j	Lcom/baidu/android/pushservice/c/c;
    //   54: invokevirtual 581	com/baidu/android/pushservice/c/c:c	()I
    //   57: bipush 7
    //   59: if_icmpne +11 -> 70
    //   62: aload_0
    //   63: bipush 7
    //   65: putfield 58	com/baidu/android/pushservice/c/d:k	I
    //   68: iconst_1
    //   69: ireturn
    //   70: aload_0
    //   71: getfield 493	com/baidu/android/pushservice/c/d:j	Lcom/baidu/android/pushservice/c/c;
    //   74: invokevirtual 581	com/baidu/android/pushservice/c/c:c	()I
    //   77: bipush 8
    //   79: if_icmpne +11 -> 90
    //   82: aload_0
    //   83: bipush 8
    //   85: putfield 58	com/baidu/android/pushservice/c/d:k	I
    //   88: iconst_1
    //   89: ireturn
    //   90: aload_0
    //   91: getfield 493	com/baidu/android/pushservice/c/d:j	Lcom/baidu/android/pushservice/c/c;
    //   94: invokevirtual 581	com/baidu/android/pushservice/c/c:c	()I
    //   97: iconst_2
    //   98: if_icmpne +279 -> 377
    //   101: aload_0
    //   102: getfield 493	com/baidu/android/pushservice/c/d:j	Lcom/baidu/android/pushservice/c/c;
    //   105: invokevirtual 583	com/baidu/android/pushservice/c/c:f	()Ljava/lang/String;
    //   108: invokestatic 262	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   111: ifne +266 -> 377
    //   114: aload_0
    //   115: getfield 80	com/baidu/android/pushservice/c/d:a	Landroid/content/Context;
    //   118: invokevirtual 587	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   121: aload_0
    //   122: getfield 493	com/baidu/android/pushservice/c/d:j	Lcom/baidu/android/pushservice/c/c;
    //   125: invokevirtual 583	com/baidu/android/pushservice/c/c:f	()Ljava/lang/String;
    //   128: sipush 16448
    //   131: invokevirtual 593	android/content/pm/PackageManager:getPackageInfo	(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    //   134: astore_3
    //   135: aload_3
    //   136: ifnull +241 -> 377
    //   139: aload_3
    //   140: getfield 598	android/content/pm/PackageInfo:versionCode	I
    //   143: istore_2
    //   144: aload_0
    //   145: getfield 493	com/baidu/android/pushservice/c/d:j	Lcom/baidu/android/pushservice/c/c;
    //   148: invokevirtual 601	com/baidu/android/pushservice/c/c:a	()Lcom/baidu/android/pushservice/c/c$a;
    //   151: ifnull +268 -> 419
    //   154: aload_0
    //   155: getfield 493	com/baidu/android/pushservice/c/d:j	Lcom/baidu/android/pushservice/c/c;
    //   158: invokevirtual 601	com/baidu/android/pushservice/c/c:a	()Lcom/baidu/android/pushservice/c/c$a;
    //   161: getfield 605	com/baidu/android/pushservice/c/c$a:b	I
    //   164: iconst_m1
    //   165: if_icmpne +144 -> 309
    //   168: iload_2
    //   169: aload_0
    //   170: getfield 493	com/baidu/android/pushservice/c/d:j	Lcom/baidu/android/pushservice/c/c;
    //   173: invokevirtual 601	com/baidu/android/pushservice/c/c:a	()Lcom/baidu/android/pushservice/c/c$a;
    //   176: getfield 607	com/baidu/android/pushservice/c/c$a:a	I
    //   179: if_icmplt +125 -> 304
    //   182: iconst_1
    //   183: istore_1
    //   184: iload_1
    //   185: ifeq +192 -> 377
    //   188: new 609	java/io/ByteArrayInputStream
    //   191: dup
    //   192: aload_3
    //   193: getfield 613	android/content/pm/PackageInfo:signatures	[Landroid/content/pm/Signature;
    //   196: iconst_0
    //   197: aaload
    //   198: invokevirtual 619	android/content/pm/Signature:toByteArray	()[B
    //   201: invokespecial 622	java/io/ByteArrayInputStream:<init>	([B)V
    //   204: astore 5
    //   206: ldc_w 624
    //   209: invokestatic 630	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
    //   212: astore_3
    //   213: aload_3
    //   214: aload 5
    //   216: invokevirtual 634	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
    //   219: checkcast 636	java/security/cert/X509Certificate
    //   222: astore_3
    //   223: aload_3
    //   224: invokevirtual 639	java/security/cert/X509Certificate:getEncoded	()[B
    //   227: invokestatic 644	com/baidu/android/pushservice/k/h:a	([B)[B
    //   230: astore_3
    //   231: aload_3
    //   232: invokestatic 646	com/baidu/android/pushservice/c/d:a	([B)Ljava/lang/String;
    //   235: aload_0
    //   236: getfield 493	com/baidu/android/pushservice/c/d:j	Lcom/baidu/android/pushservice/c/c;
    //   239: invokevirtual 648	com/baidu/android/pushservice/c/c:g	()Ljava/lang/String;
    //   242: invokevirtual 338	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   245: ifeq +132 -> 377
    //   248: aload_0
    //   249: aload_0
    //   250: getfield 493	com/baidu/android/pushservice/c/d:j	Lcom/baidu/android/pushservice/c/c;
    //   253: invokevirtual 583	com/baidu/android/pushservice/c/c:f	()Ljava/lang/String;
    //   256: putfield 67	com/baidu/android/pushservice/c/d:m	Ljava/lang/String;
    //   259: aload_0
    //   260: aload_0
    //   261: getfield 80	com/baidu/android/pushservice/c/d:a	Landroid/content/Context;
    //   264: aload_0
    //   265: getfield 67	com/baidu/android/pushservice/c/d:m	Ljava/lang/String;
    //   268: invokestatic 651	com/baidu/android/pushservice/j/p:m	(Landroid/content/Context;Ljava/lang/String;)I
    //   271: putfield 65	com/baidu/android/pushservice/c/d:l	I
    //   274: aload_0
    //   275: getfield 80	com/baidu/android/pushservice/c/d:a	Landroid/content/Context;
    //   278: invokevirtual 86	android/content/Context:getPackageName	()Ljava/lang/String;
    //   281: aload_0
    //   282: getfield 493	com/baidu/android/pushservice/c/d:j	Lcom/baidu/android/pushservice/c/c;
    //   285: invokevirtual 583	com/baidu/android/pushservice/c/c:f	()Ljava/lang/String;
    //   288: invokevirtual 338	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   291: ifeq +79 -> 370
    //   294: aload_0
    //   295: iconst_3
    //   296: putfield 58	com/baidu/android/pushservice/c/d:k	I
    //   299: iconst_1
    //   300: ireturn
    //   301: astore_3
    //   302: iconst_0
    //   303: ireturn
    //   304: iconst_0
    //   305: istore_1
    //   306: goto -122 -> 184
    //   309: iload_2
    //   310: aload_0
    //   311: getfield 493	com/baidu/android/pushservice/c/d:j	Lcom/baidu/android/pushservice/c/c;
    //   314: invokevirtual 601	com/baidu/android/pushservice/c/c:a	()Lcom/baidu/android/pushservice/c/c$a;
    //   317: getfield 607	com/baidu/android/pushservice/c/c$a:a	I
    //   320: if_icmplt +28 -> 348
    //   323: iconst_1
    //   324: istore_1
    //   325: iload_2
    //   326: aload_0
    //   327: getfield 493	com/baidu/android/pushservice/c/d:j	Lcom/baidu/android/pushservice/c/c;
    //   330: invokevirtual 601	com/baidu/android/pushservice/c/c:a	()Lcom/baidu/android/pushservice/c/c$a;
    //   333: getfield 605	com/baidu/android/pushservice/c/c$a:b	I
    //   336: if_icmpgt +17 -> 353
    //   339: iconst_1
    //   340: istore_2
    //   341: iload_1
    //   342: iload_2
    //   343: iand
    //   344: istore_1
    //   345: goto -161 -> 184
    //   348: iconst_0
    //   349: istore_1
    //   350: goto -25 -> 325
    //   353: iconst_0
    //   354: istore_2
    //   355: goto -14 -> 341
    //   358: astore_3
    //   359: aconst_null
    //   360: astore_3
    //   361: goto -148 -> 213
    //   364: astore_3
    //   365: aconst_null
    //   366: astore_3
    //   367: goto -144 -> 223
    //   370: aload_0
    //   371: iconst_4
    //   372: putfield 58	com/baidu/android/pushservice/c/d:k	I
    //   375: iconst_1
    //   376: ireturn
    //   377: ldc_w 270
    //   380: new 69	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 71	java/lang/StringBuilder:<init>	()V
    //   387: ldc_w 653
    //   390: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_0
    //   394: getfield 58	com/baidu/android/pushservice/c/d:k	I
    //   397: invokevirtual 656	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   400: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: aload_0
    //   404: getfield 80	com/baidu/android/pushservice/c/d:a	Landroid/content/Context;
    //   407: invokestatic 277	com/baidu/android/pushservice/g/a:a	(Ljava/lang/String;Ljava/lang/String;Landroid/content/Context;)V
    //   410: iconst_0
    //   411: ireturn
    //   412: astore_3
    //   413: aload 4
    //   415: astore_3
    //   416: goto -185 -> 231
    //   419: iconst_0
    //   420: istore_1
    //   421: goto -237 -> 184
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	424	0	this	d
    //   183	238	1	i1	int
    //   143	212	2	i2	int
    //   134	98	3	localObject1	Object
    //   301	1	3	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   358	1	3	localCertificateException1	java.security.cert.CertificateException
    //   360	1	3	localObject2	Object
    //   364	1	3	localCertificateException2	java.security.cert.CertificateException
    //   366	1	3	localObject3	Object
    //   412	1	3	localException	Exception
    //   415	1	3	localObject4	Object
    //   1	413	4	localObject5	Object
    //   204	11	5	localByteArrayInputStream	java.io.ByteArrayInputStream
    // Exception table:
    //   from	to	target	type
    //   114	135	301	android/content/pm/PackageManager$NameNotFoundException
    //   206	213	358	java/security/cert/CertificateException
    //   213	223	364	java/security/cert/CertificateException
    //   223	231	412	java/lang/Exception
  }
  
  public void f()
  {
    boolean bool1 = j();
    boolean bool2 = i();
    if (((bool1) || (!bool2)) && (a())) {
      h();
    }
    if (this.j != null)
    {
      e();
      return;
    }
    com.baidu.android.pushservice.g.a.a("ModeConfig", "Config File Not Matched", this.a);
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/c/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */