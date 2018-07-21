package com.baidu.carlife.core;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;

public class e
  implements h
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final String d = "unknow";
  public static boolean e = false;
  private static final String f = e.class.getSimpleName();
  private static e g;
  private static String h;
  private static String i;
  private static int j = -1;
  private static int k;
  private static int l;
  private static String m;
  private static int n = 0;
  private Context o = a.a();
  
  public e()
  {
    A();
  }
  
  private void A()
  {
    try
    {
      Object localObject = this.o.getPackageManager().getPackageInfo(this.o.getPackageName(), 0);
      h = ((PackageInfo)localObject).packageName;
      i = ((PackageInfo)localObject).versionName;
      j = ((PackageInfo)localObject).versionCode;
      localObject = new DisplayMetrics();
      ((WindowManager)this.o.getSystemService("window")).getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
      k = ((DisplayMetrics)localObject).widthPixels;
      l = ((DisplayMetrics)localObject).heightPixels;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static Bitmap a(String paramString)
  {
    InputStream localInputStream = null;
    try
    {
      paramString = (HttpURLConnection)new URL(paramString).openConnection();
      paramString.setConnectTimeout(5000);
      paramString.setReadTimeout(3000);
      paramString.setRequestMethod("GET");
      if (paramString.getResponseCode() == 200)
      {
        i.b(f, "-------getImage OK-------");
        localInputStream = paramString.getInputStream();
        paramString = new BitmapFactory.Options();
        paramString.outHeight = 200;
        paramString.outWidth = 200;
        paramString = BitmapFactory.decodeStream(localInputStream, null, paramString);
        localInputStream.close();
      }
      else
      {
        i.e(f, "------get data Failed!!!---------");
        paramString = localInputStream;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    return paramString;
  }
  
  public static e a()
  {
    if (g == null) {}
    try
    {
      if (g == null) {
        g = new e();
      }
      return g;
    }
    finally {}
  }
  
  public static String b()
  {
    String str2 = ((TelephonyManager)a.a().getSystemService("phone")).getDeviceId();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "unknow";
    }
    return str1;
  }
  
  public static void b(int paramInt)
  {
    n = paramInt;
  }
  
  public static void b(String paramString)
  {
    f.jx = f.a.aj;
    if (!TextUtils.isEmpty(paramString))
    {
      int i2 = 1;
      Iterator localIterator = EnumSet.allOf(f.a.class).iterator();
      f.a locala;
      do
      {
        i1 = i2;
        if (!localIterator.hasNext()) {
          break;
        }
        locala = (f.a)localIterator.next();
      } while (!locala.a().equals(paramString));
      int i1 = 0;
      f.jx = locala;
      if (i1 != 0)
      {
        f.a.ag.a(paramString);
        f.jx = f.a.ag;
      }
    }
    h(paramString);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    File localFile = new File(paramString1);
    if (!localFile.exists()) {}
    String[] arrayOfString;
    do
    {
      do
      {
        return;
      } while ((!localFile.isDirectory()) || (TextUtils.isEmpty(paramString2)));
      arrayOfString = localFile.list();
    } while (arrayOfString == null);
    int i1 = 0;
    label44:
    if (i1 < arrayOfString.length) {
      if (!paramString1.endsWith(File.separator)) {
        break label120;
      }
    }
    label120:
    for (localFile = new File(paramString1 + arrayOfString[i1]);; localFile = new File(paramString1 + File.separator + arrayOfString[i1]))
    {
      if ((localFile.isFile()) && (arrayOfString[i1].endsWith(paramString2))) {
        localFile.delete();
      }
      i1 += 1;
      break label44;
      break;
    }
  }
  
  public static String c()
  {
    return k + "*" + l;
  }
  
  public static void c(String paramString)
  {
    f.jy = paramString;
  }
  
  public static void c(String paramString1, String paramString2)
  {
    Object localObject2 = a.a();
    ((Context)localObject2).deleteFile(paramString1);
    localObject1 = null;
    String str = null;
    try
    {
      paramString1 = ((Context)localObject2).openFileOutput(paramString1, 0);
      str = paramString1;
      localObject1 = paramString1;
      localObject2 = new PrintStream(paramString1);
      str = paramString1;
      localObject1 = paramString1;
      ((PrintStream)localObject2).print(paramString2);
      str = paramString1;
      localObject1 = paramString1;
      ((PrintStream)localObject2).close();
      try
      {
        paramString1.close();
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      try
      {
        ((FileOutputStream)localObject1).close();
        throw paramString1;
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          paramString2.printStackTrace();
        }
      }
    }
    catch (FileNotFoundException paramString1)
    {
      paramString1 = paramString1;
      localObject1 = str;
      i.e(f, "---writeData--FileNotFoundException----");
      try
      {
        str.close();
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
    finally {}
  }
  
  public static void c(boolean paramBoolean)
  {
    e = paramBoolean;
  }
  
  public static int d()
  {
    return k;
  }
  
  public static void d(String paramString)
  {
    f.jz = paramString;
  }
  
  public static int e()
  {
    return l;
  }
  
  public static boolean e(String paramString)
  {
    return (TextUtils.isEmpty(paramString)) || ("null".equals(paramString));
  }
  
  public static String f()
  {
    if (TextUtils.isEmpty(h)) {
      return "unknow";
    }
    return h;
  }
  
  public static String f(String paramString)
  {
    Object localObject = g.a().a(paramString);
    paramString = new StringBuilder();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        g.a locala = (g.a)((Iterator)localObject).next();
        if (2 == locala.e) {
          paramString.append(locala.g);
        } else {
          paramString.append(locala.f);
        }
      }
    }
    return paramString.toString().toUpperCase();
  }
  
  public static String g()
  {
    if (TextUtils.isEmpty(i)) {
      return "unknow";
    }
    return i;
  }
  
  public static String g(String paramString)
  {
    Object localObject = a.a();
    try
    {
      paramString = ((Context)localObject).openFileInput(paramString);
      localObject = new byte['Ā'];
      StringBuilder localStringBuilder = new StringBuilder();
      for (;;)
      {
        int i1 = paramString.read((byte[])localObject);
        if (i1 <= 0) {
          break;
        }
        localStringBuilder.append(new String((byte[])localObject, 0, i1));
      }
      return null;
    }
    catch (FileNotFoundException paramString)
    {
      i.e(f, "---getData--FileNotFoundException----");
      return null;
      paramString.close();
      paramString = localStringBuilder.toString();
      return paramString;
    }
    catch (IOException paramString)
    {
      i.e(f, "---getData--IOException----");
    }
  }
  
  public static int h()
  {
    return j;
  }
  
  private static void h(String paramString)
  {
    k.a(16875523, paramString);
  }
  
  public static String i()
  {
    return Build.VERSION.RELEASE;
  }
  
  public static String j()
  {
    return Build.MODEL;
  }
  
  public static String k()
  {
    if (TextUtils.isEmpty(m)) {
      return "unknown";
    }
    if ((m.startsWith("46000")) || (m.startsWith("46002"))) {
      return "CMCC";
    }
    if (m.startsWith("46001")) {
      return "Unicom";
    }
    if (m.startsWith("46003")) {
      return "Telecom";
    }
    return "unknown";
  }
  
  public static void l()
  {
    b(f.jm, ".mp3");
    b(f.jm, ".aac");
    b(f.jm, ".m3u8");
  }
  
  public static int s()
  {
    Object localObject = ((ConnectivityManager)a.a().getSystemService("connectivity")).getActiveNetworkInfo();
    if ((localObject != null) && (((NetworkInfo)localObject).isConnected()))
    {
      localObject = ((NetworkInfo)localObject).getTypeName();
      if (((String)localObject).equalsIgnoreCase("WIFI")) {
        return 2;
      }
      if (((String)localObject).equalsIgnoreCase("MOBILE")) {
        return 1;
      }
    }
    return 0;
  }
  
  public static boolean t()
  {
    return f.jp < 6;
  }
  
  public static void u()
  {
    ((InputMethodManager)a.a().getSystemService("input_method")).toggleSoftInput(0, 2);
  }
  
  public static void v()
  {
    new Thread()
    {
      public void run()
      {
        try
        {
          if (new File("/data/local/tmp/bdim.jar").exists()) {
            e.a().a("bdim.jar", "/data/local/tmp/bdim.jar");
          }
          int i = Build.VERSION.SDK_INT;
          if ((i >= 16) && (i <= 18))
          {
            if (new File("/data/local/tmp/bdsc").exists()) {
              e.a().a("bdsc" + Integer.toString(i), "/data/local/tmp/bdsc");
            }
            String str = "/data/local/tmp/bdsc" + Integer.toString(i);
            if (!new File(str).exists()) {
              return;
            }
            e.a().a("bdsc" + Integer.toString(i), str);
            return;
          }
          if (i != 19) {
            return;
          }
          if (Build.VERSION.RELEASE.equals("4.4.2"))
          {
            if (new File("/data/local/tmp/bdsc").exists()) {
              e.a().a("bdsc19", "/data/local/tmp/bdsc");
            }
            if (!new File("/data/local/tmp/bdsc19").exists()) {
              return;
            }
            e.a().a("bdsc19", "/data/local/tmp/bdsc19");
            return;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        if (new File("/data/local/tmp/bdsc").exists()) {
          e.a().a("bdsc19_01", "/data/local/tmp/bdsc");
        }
        if (new File("/data/local/tmp/bdsc19_01").exists()) {
          e.a().a("bdsc19_01", "/data/local/tmp/bdsc19_01");
        }
      }
    }.start();
  }
  
  /* Error */
  public static void w()
  {
    // Byte code:
    //   0: invokestatic 58	com/baidu/carlife/core/a:a	()Lcom/baidu/carlife/core/a;
    //   3: astore_0
    //   4: aload_0
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: aconst_null
    //   10: astore_3
    //   11: aconst_null
    //   12: astore_2
    //   13: aconst_null
    //   14: astore 7
    //   16: aconst_null
    //   17: astore 8
    //   19: aconst_null
    //   20: astore 5
    //   22: aconst_null
    //   23: astore 6
    //   25: aconst_null
    //   26: astore 4
    //   28: aload_0
    //   29: invokevirtual 468	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   32: invokevirtual 474	android/content/res/Resources:getAssets	()Landroid/content/res/AssetManager;
    //   35: ldc_w 476
    //   38: invokevirtual 482	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   41: astore_0
    //   42: aload_0
    //   43: astore_2
    //   44: aload_0
    //   45: astore_3
    //   46: new 484	java/io/InputStreamReader
    //   49: dup
    //   50: aload_0
    //   51: invokespecial 487	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   54: astore_1
    //   55: new 489	java/io/BufferedReader
    //   58: dup
    //   59: aload_1
    //   60: invokespecial 492	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   63: astore_2
    //   64: aload_2
    //   65: invokevirtual 495	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   68: astore_3
    //   69: aload_2
    //   70: ifnull +7 -> 77
    //   73: aload_2
    //   74: invokevirtual 496	java/io/BufferedReader:close	()V
    //   77: aload_1
    //   78: ifnull +7 -> 85
    //   81: aload_1
    //   82: invokevirtual 497	java/io/InputStreamReader:close	()V
    //   85: aload_0
    //   86: ifnull +7 -> 93
    //   89: aload_0
    //   90: invokevirtual 188	java/io/InputStream:close	()V
    //   93: aload_3
    //   94: invokestatic 210	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   97: ifne -89 -> 8
    //   100: aload_3
    //   101: invokevirtual 500	java/lang/String:trim	()Ljava/lang/String;
    //   104: putstatic 503	com/baidu/carlife/core/f:jt	Ljava/lang/String;
    //   107: getstatic 43	com/baidu/carlife/core/e:f	Ljava/lang/String;
    //   110: new 278	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 279	java/lang/StringBuilder:<init>	()V
    //   117: ldc_w 505
    //   120: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: getstatic 503	com/baidu/carlife/core/f:jt	Ljava/lang/String;
    //   126: invokevirtual 283	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 286	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 164	com/baidu/carlife/core/i:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: return
    //   136: astore_0
    //   137: goto -44 -> 93
    //   140: astore_0
    //   141: aload 8
    //   143: astore_0
    //   144: aload 6
    //   146: astore_1
    //   147: aload_1
    //   148: ifnull +7 -> 155
    //   151: aload_1
    //   152: invokevirtual 496	java/io/BufferedReader:close	()V
    //   155: aload_0
    //   156: ifnull +7 -> 163
    //   159: aload_0
    //   160: invokevirtual 497	java/io/InputStreamReader:close	()V
    //   163: aload 4
    //   165: astore_3
    //   166: aload_2
    //   167: ifnull -74 -> 93
    //   170: aload_2
    //   171: invokevirtual 188	java/io/InputStream:close	()V
    //   174: aload 4
    //   176: astore_3
    //   177: goto -84 -> 93
    //   180: astore_0
    //   181: aload 4
    //   183: astore_3
    //   184: goto -91 -> 93
    //   187: astore_1
    //   188: aload 7
    //   190: astore_0
    //   191: aload 5
    //   193: astore_2
    //   194: aload_2
    //   195: ifnull +7 -> 202
    //   198: aload_2
    //   199: invokevirtual 496	java/io/BufferedReader:close	()V
    //   202: aload_0
    //   203: ifnull +7 -> 210
    //   206: aload_0
    //   207: invokevirtual 497	java/io/InputStreamReader:close	()V
    //   210: aload_3
    //   211: ifnull +7 -> 218
    //   214: aload_3
    //   215: invokevirtual 188	java/io/InputStream:close	()V
    //   218: aload_1
    //   219: athrow
    //   220: astore_0
    //   221: goto -3 -> 218
    //   224: astore 4
    //   226: aload 5
    //   228: astore_2
    //   229: aload_0
    //   230: astore_3
    //   231: aload_1
    //   232: astore_0
    //   233: aload 4
    //   235: astore_1
    //   236: goto -42 -> 194
    //   239: astore 4
    //   241: aload_0
    //   242: astore_3
    //   243: aload_1
    //   244: astore_0
    //   245: aload 4
    //   247: astore_1
    //   248: goto -54 -> 194
    //   251: astore_2
    //   252: aload_1
    //   253: astore_3
    //   254: aload 6
    //   256: astore_1
    //   257: aload_0
    //   258: astore_2
    //   259: aload_3
    //   260: astore_0
    //   261: goto -114 -> 147
    //   264: astore_3
    //   265: aload_1
    //   266: astore_3
    //   267: aload_2
    //   268: astore_1
    //   269: aload_0
    //   270: astore_2
    //   271: aload_3
    //   272: astore_0
    //   273: goto -126 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	87	0	localObject1	Object
    //   136	1	0	localIOException1	IOException
    //   140	1	0	localIOException2	IOException
    //   143	17	0	localObject2	Object
    //   180	1	0	localIOException3	IOException
    //   190	17	0	localObject3	Object
    //   220	10	0	localIOException4	IOException
    //   232	41	0	localObject4	Object
    //   54	98	1	localObject5	Object
    //   187	45	1	localObject6	Object
    //   235	34	1	localObject7	Object
    //   12	217	2	localObject8	Object
    //   251	1	2	localIOException5	IOException
    //   258	13	2	localObject9	Object
    //   10	250	3	localObject10	Object
    //   264	1	3	localIOException6	IOException
    //   266	6	3	localObject11	Object
    //   26	156	4	localObject12	Object
    //   224	10	4	localObject13	Object
    //   239	7	4	localObject14	Object
    //   20	207	5	localObject15	Object
    //   23	232	6	localObject16	Object
    //   14	175	7	localObject17	Object
    //   17	125	8	localObject18	Object
    // Exception table:
    //   from	to	target	type
    //   73	77	136	java/io/IOException
    //   81	85	136	java/io/IOException
    //   89	93	136	java/io/IOException
    //   28	42	140	java/io/IOException
    //   46	55	140	java/io/IOException
    //   151	155	180	java/io/IOException
    //   159	163	180	java/io/IOException
    //   170	174	180	java/io/IOException
    //   28	42	187	finally
    //   46	55	187	finally
    //   198	202	220	java/io/IOException
    //   206	210	220	java/io/IOException
    //   214	218	220	java/io/IOException
    //   55	64	224	finally
    //   64	69	239	finally
    //   55	64	251	java/io/IOException
    //   64	69	264	java/io/IOException
  }
  
  public static boolean y()
  {
    return e;
  }
  
  public static int z()
  {
    return n;
  }
  
  public Bitmap a(Bitmap paramBitmap, float paramFloat)
  {
    Bitmap localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    Paint localPaint = new Paint();
    Rect localRect = new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight());
    RectF localRectF = new RectF(localRect);
    localPaint.setAntiAlias(true);
    localCanvas.drawARGB(0, 0, 0, 0);
    localPaint.setColor(-12434878);
    localCanvas.drawRoundRect(localRectF, paramFloat, paramFloat, localPaint);
    localPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    localCanvas.drawBitmap(paramBitmap, localRect, localRect, localPaint);
    return localBitmap;
  }
  
  public String a(int paramInt)
  {
    int i1 = paramInt;
    int i2 = i1 / 3600;
    paramInt = i1;
    if (i2 > 0) {
      paramInt = i1 - i2 * 3600;
    }
    i1 = paramInt / 60;
    paramInt %= 60;
    String str1;
    if (i1 > 9)
    {
      str1 = i1 + "";
      if (paramInt <= 9) {
        break label140;
      }
    }
    label140:
    for (String str2 = paramInt + "";; str2 = "0" + paramInt)
    {
      return str1 + ":" + str2;
      str1 = "0" + i1;
      break;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = a.a().getSharedPreferences("CarLife_Temp", 0).edit();
    localEditor.putBoolean("WakeUpFlag", paramBoolean);
    localEditor.commit();
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (this.o == null) {
      return false;
    }
    if ((paramString1 == null) || (paramString2 == null))
    {
      i.e(f, "from or to is null");
      return false;
    }
    int i1 = 0;
    try
    {
      new File(paramString1);
      InputStream localInputStream = this.o.getResources().getAssets().open(paramString1);
      Object localObject2 = new File(paramString2);
      Object localObject1 = localObject2;
      if (((File)localObject2).isDirectory()) {
        localObject1 = new File(paramString2 + "/" + paramString1);
      }
      if (!((File)localObject1).exists()) {
        ((File)localObject1).createNewFile();
      }
      localObject1 = new BufferedOutputStream(new FileOutputStream((File)localObject1));
      localObject2 = new byte['Ѐ'];
      for (;;)
      {
        int i2 = localInputStream.read((byte[])localObject2);
        if (i2 == -1) {
          break;
        }
        i1 += i2;
        ((BufferedOutputStream)localObject1).write((byte[])localObject2, 0, i2);
      }
      localInputStream.close();
    }
    catch (Exception localException)
    {
      i.e(f, "Dump [" + paramString1 + "] to [" + paramString2 + "] Failed");
      localException.printStackTrace();
      return false;
    }
    localException.close();
    i.b(f, "Dump [" + paramString1 + "] to [" + paramString2 + "] Success");
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3)
  {
    if (this.o == null) {
      return false;
    }
    String str = paramString1 + "/" + paramString2;
    if ((str == null) || (paramString3 == null))
    {
      i.e(f, "from or to is null");
      return false;
    }
    int i1 = 0;
    try
    {
      new File(str);
      InputStream localInputStream = this.o.getResources().getAssets().open(str);
      File localFile = new File(paramString3);
      paramString2 = localFile;
      if (localFile.isDirectory()) {
        paramString2 = new File(paramString3 + "/" + str);
      }
      if (!paramString2.exists())
      {
        paramString1 = new File(paramString3 + "/" + paramString1);
        if (!paramString1.exists()) {
          paramString1.mkdirs();
        }
        paramString2.createNewFile();
      }
      paramString1 = new BufferedOutputStream(new FileOutputStream(paramString2));
      paramString2 = new byte['Ѐ'];
      for (;;)
      {
        int i2 = localInputStream.read(paramString2);
        if (i2 == -1) {
          break;
        }
        i1 += i2;
        paramString1.write(paramString2, 0, i2);
      }
      localInputStream.close();
    }
    catch (Exception paramString1)
    {
      i.e(f, "Dump [" + str + "] to [" + paramString3 + "] Failed");
      paramString1.printStackTrace();
      return false;
    }
    paramString1.close();
    i.e(f, "Dump [" + str + "] to [" + paramString3 + "] Success");
    return true;
  }
  
  public byte[] a(Bitmap paramBitmap)
  {
    return a(paramBitmap, 100);
  }
  
  public byte[] a(Bitmap paramBitmap, int paramInt)
  {
    if (paramBitmap != null)
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, paramInt, localByteArrayOutputStream);
      try
      {
        paramBitmap = localByteArrayOutputStream.toByteArray();
        localByteArrayOutputStream.close();
        return paramBitmap;
      }
      catch (Exception paramBitmap)
      {
        paramBitmap.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  public void b(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = a.a().getSharedPreferences("CarLife_Temp", 0).edit();
    localEditor.putBoolean("OnceWakeUpFlag", paramBoolean);
    localEditor.commit();
  }
  
  public String m()
  {
    String str = null;
    try
    {
      if (Environment.getExternalStorageState().equals("mounted")) {}
      for (str = Environment.getExternalStorageDirectory().toString();; str = this.o.getFilesDir().toString())
      {
        i.b(f, "SD Path: " + str);
        do
        {
          return str;
        } while (this.o == null);
      }
      return null;
    }
    catch (Exception localException)
    {
      i.e(f, "Get SD Path Failed");
    }
  }
  
  public int n()
  {
    WindowManager localWindowManager = (WindowManager)a.a().getSystemService("window");
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localWindowManager.getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i1 = localDisplayMetrics.widthPixels;
    int i2 = localDisplayMetrics.heightPixels;
    if (i2 == 1080) {
      return Math.abs(1920 - i1);
    }
    if (i2 == 720) {
      return Math.abs(1280 - i1);
    }
    return 0;
  }
  
  public boolean o()
  {
    return a.a().getSharedPreferences("CarLife_Temp", 0).getBoolean("WakeUpFlag", false);
  }
  
  public boolean p()
  {
    return a.a().getSharedPreferences("CarLife_Temp", 0).getBoolean("OnceWakeUpFlag", false);
  }
  
  public int q()
  {
    if (this.o == null) {
      i1 = -1;
    }
    TypedValue localTypedValue;
    do
    {
      return i1;
      localTypedValue = new TypedValue();
      i1 = 0;
    } while (!this.o.getTheme().resolveAttribute(16843499, localTypedValue, true));
    int i1 = TypedValue.complexToDimensionPixelSize(localTypedValue.data, this.o.getResources().getDisplayMetrics());
    i.b("ouyang", "----actionBar--height:" + i1);
    return i1;
  }
  
  public boolean r()
  {
    if (this.o == null) {
      return false;
    }
    try
    {
      Object localObject = (ConnectivityManager)this.o.getSystemService("connectivity");
      if (localObject == null) {
        return false;
      }
      localObject = ((ConnectivityManager)localObject).getActiveNetworkInfo();
      if (localObject != null)
      {
        boolean bool = ((NetworkInfo)localObject).isConnected();
        return bool;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public boolean x()
  {
    for (;;)
    {
      try
      {
        if (Build.VERSION.SDK_INT < 17)
        {
          if (Settings.Secure.getInt(this.o.getContentResolver(), "adb_enabled", -10) == 1)
          {
            i.b(f, "usb debug: on");
            return true;
          }
          i.b(f, "usb debug: off");
          return false;
        }
      }
      catch (Exception localException)
      {
        i.e(f, "usb debug get exception");
        localException.printStackTrace();
        return false;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/core/e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */