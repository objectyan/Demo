package com.baidu.android.pushservice.h.a;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.baidu.android.pushservice.j.k;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import org.json.JSONException;
import org.json.JSONObject;

public class b
{
  /* Error */
  public static a a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: sipush 1024
    //   5: newarray <illegal type>
    //   7: astore_3
    //   8: new 12	java/io/RandomAccessFile
    //   11: dup
    //   12: ldc 14
    //   14: ldc 16
    //   16: invokespecial 20	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: astore_2
    //   20: aload_2
    //   21: aload_3
    //   22: invokevirtual 24	java/io/RandomAccessFile:read	([B)I
    //   25: pop
    //   26: new 26	java/lang/String
    //   29: dup
    //   30: aload_3
    //   31: invokespecial 29	java/lang/String:<init>	([B)V
    //   34: astore_3
    //   35: aload_3
    //   36: iconst_0
    //   37: invokevirtual 33	java/lang/String:indexOf	(I)I
    //   40: istore_0
    //   41: aload_3
    //   42: astore_1
    //   43: iload_0
    //   44: iconst_m1
    //   45: if_icmpeq +10 -> 55
    //   48: aload_3
    //   49: iconst_0
    //   50: iload_0
    //   51: invokevirtual 37	java/lang/String:substring	(II)Ljava/lang/String;
    //   54: astore_1
    //   55: iconst_1
    //   56: anewarray 39	java/io/Closeable
    //   59: dup
    //   60: iconst_0
    //   61: aload_2
    //   62: aastore
    //   63: invokestatic 44	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   66: aload_1
    //   67: invokestatic 47	com/baidu/android/pushservice/h/a/b:a	(Ljava/lang/String;)Lcom/baidu/android/pushservice/h/a/b$a;
    //   70: astore_1
    //   71: aload_1
    //   72: ifnull +11 -> 83
    //   75: aload_1
    //   76: invokestatic 51	com/baidu/android/pushservice/h/a/b:f	()I
    //   79: i2l
    //   80: putfield 55	com/baidu/android/pushservice/h/a/b$a:e	J
    //   83: aload_1
    //   84: areturn
    //   85: astore_2
    //   86: iconst_1
    //   87: anewarray 39	java/io/Closeable
    //   90: dup
    //   91: iconst_0
    //   92: aload_1
    //   93: aastore
    //   94: invokestatic 44	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   97: ldc 57
    //   99: astore_1
    //   100: goto -34 -> 66
    //   103: astore_1
    //   104: aconst_null
    //   105: astore_2
    //   106: iconst_1
    //   107: anewarray 39	java/io/Closeable
    //   110: dup
    //   111: iconst_0
    //   112: aload_2
    //   113: aastore
    //   114: invokestatic 44	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   117: aload_1
    //   118: athrow
    //   119: astore_1
    //   120: goto -14 -> 106
    //   123: astore_1
    //   124: aload_2
    //   125: astore_1
    //   126: goto -40 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   40	11	0	i	int
    //   1	99	1	localObject1	Object
    //   103	15	1	localObject2	Object
    //   119	1	1	localObject3	Object
    //   123	1	1	localException1	Exception
    //   125	1	1	localObject4	Object
    //   19	43	2	localRandomAccessFile	java.io.RandomAccessFile
    //   85	1	2	localException2	Exception
    //   105	20	2	localObject5	Object
    //   7	42	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   2	20	85	java/lang/Exception
    //   2	20	103	finally
    //   20	41	119	finally
    //   48	55	119	finally
    //   20	41	123	java/lang/Exception
    //   48	55	123	java/lang/Exception
  }
  
  private static a a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    a locala;
    String[] arrayOfString;
    int k;
    int i;
    label148:
    do
    {
      do
      {
        return paramString;
        locala = new a();
        locala.a = 0;
        locala.c = 0;
        locala.b = 1;
        locala.d = 0.0D;
        if (!paramString.contains("ARMv5")) {
          break;
        }
        locala.a = 1;
        if (paramString.contains("neon")) {
          locala.c |= 0x100;
        }
        if (paramString.contains("vfpv3")) {
          locala.c |= 0x10;
        }
        if (paramString.contains(" vfp")) {
          locala.c |= 0x1;
        }
        arrayOfString = paramString.split("\n");
        paramString = locala;
      } while (arrayOfString.length <= 0);
      k = arrayOfString.length;
      i = 0;
      paramString = locala;
    } while (i >= k);
    paramString = arrayOfString[i];
    int j;
    if (paramString.contains("CPU variant"))
    {
      j = paramString.indexOf(": ");
      if (j >= 0) {
        paramString = paramString.substring(j + 2);
      }
    }
    for (;;)
    {
      try
      {
        locala.b = Integer.decode(paramString).intValue();
        if (locala.b != 0) {
          continue;
        }
        j = 1;
        locala.b = j;
      }
      catch (NumberFormatException paramString)
      {
        locala.b = 1;
        continue;
      }
      i += 1;
      break label148;
      if (paramString.contains("ARMv6"))
      {
        locala.a = 16;
        break;
      }
      if (!paramString.contains("ARMv7")) {
        break;
      }
      locala.a = 256;
      break;
      j = locala.b;
      continue;
      if (paramString.contains("BogoMIPS"))
      {
        j = paramString.indexOf(": ");
        if (j >= 0)
        {
          paramString = paramString.substring(j + 2);
          try
          {
            locala.d = Double.parseDouble(paramString);
          }
          catch (NumberFormatException paramString)
          {
            locala.d = 0.0D;
          }
        }
      }
    }
  }
  
  /* Error */
  public static String a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 135	java/io/InputStreamReader
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 138	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   14: astore_1
    //   15: new 140	java/io/BufferedReader
    //   18: dup
    //   19: aload_1
    //   20: invokespecial 143	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   23: astore_2
    //   24: new 145	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 146	java/lang/StringBuilder:<init>	()V
    //   31: astore_3
    //   32: aload_2
    //   33: invokevirtual 150	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   36: astore 4
    //   38: aload 4
    //   40: ifnull +39 -> 79
    //   43: aload_3
    //   44: aload 4
    //   46: invokevirtual 154	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: goto -18 -> 32
    //   53: astore 4
    //   55: iconst_3
    //   56: anewarray 39	java/io/Closeable
    //   59: dup
    //   60: iconst_0
    //   61: aload_0
    //   62: aastore
    //   63: dup
    //   64: iconst_1
    //   65: aload_1
    //   66: aastore
    //   67: dup
    //   68: iconst_2
    //   69: aload_2
    //   70: aastore
    //   71: invokestatic 44	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   74: aload_3
    //   75: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   78: areturn
    //   79: iconst_3
    //   80: anewarray 39	java/io/Closeable
    //   83: dup
    //   84: iconst_0
    //   85: aload_0
    //   86: aastore
    //   87: dup
    //   88: iconst_1
    //   89: aload_1
    //   90: aastore
    //   91: dup
    //   92: iconst_2
    //   93: aload_2
    //   94: aastore
    //   95: invokestatic 44	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   98: goto -24 -> 74
    //   101: astore_3
    //   102: iconst_3
    //   103: anewarray 39	java/io/Closeable
    //   106: dup
    //   107: iconst_0
    //   108: aload_0
    //   109: aastore
    //   110: dup
    //   111: iconst_1
    //   112: aload_1
    //   113: aastore
    //   114: dup
    //   115: iconst_2
    //   116: aload_2
    //   117: aastore
    //   118: invokestatic 44	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   121: aload_3
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramInputStream	java.io.InputStream
    //   14	99	1	localInputStreamReader	java.io.InputStreamReader
    //   23	94	2	localBufferedReader	java.io.BufferedReader
    //   31	44	3	localStringBuilder	StringBuilder
    //   101	21	3	localObject	Object
    //   36	9	4	str	String
    //   53	1	4	localIOException	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   32	38	53	java/io/IOException
    //   43	50	53	java/io/IOException
    //   32	38	101	finally
    //   43	50	101	finally
  }
  
  public static int[] a(Context paramContext)
  {
    int[] arrayOfInt = new int[3];
    paramContext = (WindowManager)paramContext.getSystemService("window");
    if (paramContext == null)
    {
      arrayOfInt[0] = 0;
      arrayOfInt[1] = 0;
      arrayOfInt[2] = 0;
      return arrayOfInt;
    }
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    paramContext.getDefaultDisplay().getMetrics(localDisplayMetrics);
    if (localDisplayMetrics.widthPixels > localDisplayMetrics.heightPixels)
    {
      arrayOfInt[0] = localDisplayMetrics.widthPixels;
      arrayOfInt[1] = localDisplayMetrics.heightPixels;
    }
    for (;;)
    {
      arrayOfInt[2] = localDisplayMetrics.densityDpi;
      return arrayOfInt;
      arrayOfInt[1] = localDisplayMetrics.widthPixels;
      arrayOfInt[0] = localDisplayMetrics.heightPixels;
    }
  }
  
  /* Error */
  public static long b()
  {
    // Byte code:
    //   0: new 193	java/io/FileReader
    //   3: dup
    //   4: ldc -61
    //   6: invokespecial 198	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   9: astore_2
    //   10: new 140	java/io/BufferedReader
    //   13: dup
    //   14: aload_2
    //   15: sipush 8192
    //   18: invokespecial 201	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   21: astore_3
    //   22: aload_3
    //   23: invokevirtual 150	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   26: astore 4
    //   28: aload 4
    //   30: ifnull +90 -> 120
    //   33: aload 4
    //   35: ldc -53
    //   37: invokevirtual 99	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   40: iconst_1
    //   41: aaload
    //   42: invokestatic 206	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   45: invokevirtual 118	java/lang/Integer:intValue	()I
    //   48: sipush 1024
    //   51: idiv
    //   52: i2l
    //   53: lstore_0
    //   54: aload_3
    //   55: invokevirtual 209	java/io/BufferedReader:close	()V
    //   58: iconst_1
    //   59: anewarray 39	java/io/Closeable
    //   62: dup
    //   63: iconst_0
    //   64: aload_2
    //   65: aastore
    //   66: invokestatic 44	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   69: lload_0
    //   70: lreturn
    //   71: astore_2
    //   72: aconst_null
    //   73: astore_2
    //   74: iconst_1
    //   75: anewarray 39	java/io/Closeable
    //   78: dup
    //   79: iconst_0
    //   80: aload_2
    //   81: aastore
    //   82: invokestatic 44	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   85: ldc2_w 210
    //   88: lreturn
    //   89: astore_2
    //   90: aconst_null
    //   91: astore 4
    //   93: aload_2
    //   94: astore_3
    //   95: iconst_1
    //   96: anewarray 39	java/io/Closeable
    //   99: dup
    //   100: iconst_0
    //   101: aload 4
    //   103: aastore
    //   104: invokestatic 44	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   107: aload_3
    //   108: athrow
    //   109: astore_3
    //   110: aload_2
    //   111: astore 4
    //   113: goto -18 -> 95
    //   116: astore_3
    //   117: goto -43 -> 74
    //   120: lconst_0
    //   121: lstore_0
    //   122: goto -68 -> 54
    // Local variable table:
    //   start	length	slot	name	signature
    //   53	69	0	l	long
    //   9	56	2	localFileReader	java.io.FileReader
    //   71	1	2	localIOException1	java.io.IOException
    //   73	8	2	localObject1	Object
    //   89	22	2	localObject2	Object
    //   21	87	3	localObject3	Object
    //   109	1	3	localObject4	Object
    //   116	1	3	localIOException2	java.io.IOException
    //   26	86	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   0	10	71	java/io/IOException
    //   0	10	89	finally
    //   10	28	109	finally
    //   33	54	109	finally
    //   54	58	109	finally
    //   10	28	116	java/io/IOException
    //   33	54	116	java/io/IOException
    //   54	58	116	java/io/IOException
  }
  
  public static String b(Context paramContext)
  {
    return k.d(paramContext);
  }
  
  public static String c()
  {
    String str = "";
    a locala = a();
    if (locala != null)
    {
      if ((locala.a & 0x1) == 1) {
        str = "armv5";
      }
    }
    else {
      return str;
    }
    if ((locala.a & 0x10) == 16) {
      return "armv6";
    }
    if ((locala.a & 0x100) == 256) {
      return "armv7";
    }
    return "unknown";
  }
  
  public static boolean c(Context paramContext)
  {
    return k.a(paramContext);
  }
  
  public static String d()
  {
    String str = "";
    a locala = a();
    if (locala != null)
    {
      if ((locala.c & 0x100) == 256) {
        str = "neon";
      }
    }
    else {
      return str;
    }
    if ((locala.c & 0x1) == 1) {
      return "vfp";
    }
    if ((locala.c & 0x10) == 16) {
      return "vfpv3";
    }
    return "unknown";
  }
  
  public static JSONObject d(Context paramContext)
  {
    localJSONObject = new JSONObject();
    try
    {
      TelephonyManager localTelephonyManager = (TelephonyManager)paramContext.getSystemService("phone");
      if (localTelephonyManager != null)
      {
        localJSONObject.put("type", localTelephonyManager.getNetworkType());
        localJSONObject.put("operator", localTelephonyManager.getNetworkOperatorName());
      }
      localJSONObject.put("access_type", b(paramContext));
      if (localTelephonyManager != null)
      {
        paramContext = localTelephonyManager.getNetworkOperator();
        if ((!TextUtils.isEmpty(paramContext)) && (paramContext.length() >= 4)) {
          break label111;
        }
        localJSONObject.put("mcc", -1);
        localJSONObject.put("mnc", -1);
      }
      for (;;)
      {
        localJSONObject.put("user_ip", e());
        return localJSONObject;
        try
        {
          label111:
          localJSONObject.put("mcc", Integer.parseInt(paramContext.substring(0, 3)));
          localJSONObject.put("mnc", Integer.parseInt(paramContext.substring(3)));
        }
        catch (NumberFormatException paramContext)
        {
          localJSONObject.put("mcc", -1);
          localJSONObject.put("mnc", -1);
        }
      }
      return localJSONObject;
    }
    catch (JSONException paramContext) {}
  }
  
  public static String e()
  {
    for (;;)
    {
      try
      {
        Enumeration localEnumeration1 = NetworkInterface.getNetworkInterfaces();
        if (localEnumeration1 == null) {
          break;
        }
        Object localObject2 = null;
        if (localEnumeration1.hasMoreElements())
        {
          Enumeration localEnumeration2 = ((NetworkInterface)localEnumeration1.nextElement()).getInetAddresses();
          Object localObject1 = localObject2;
          localObject2 = localObject1;
          if (localEnumeration2.hasMoreElements())
          {
            localObject2 = (InetAddress)localEnumeration2.nextElement();
            if (!((InetAddress)localObject2).isLoopbackAddress()) {
              localObject1 = ((InetAddress)localObject2).getHostAddress().toString();
            }
          }
        }
        else
        {
          return (String)localObject2;
        }
      }
      catch (Exception localException)
      {
        return null;
      }
    }
    return null;
  }
  
  /* Error */
  public static JSONObject e(Context paramContext)
  {
    // Byte code:
    //   0: new 236	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 237	org/json/JSONObject:<init>	()V
    //   7: astore 4
    //   9: aload 4
    //   11: ldc_w 309
    //   14: ldc_w 311
    //   17: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   20: pop
    //   21: aload 4
    //   23: ldc_w 313
    //   26: getstatic 319	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   29: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   32: pop
    //   33: aload 4
    //   35: ldc_w 321
    //   38: getstatic 326	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   41: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   44: pop
    //   45: aload 4
    //   47: ldc_w 328
    //   50: getstatic 331	android/os/Build:MODEL	Ljava/lang/String;
    //   53: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   56: pop
    //   57: aload 4
    //   59: ldc_w 333
    //   62: getstatic 336	android/os/Build:FINGERPRINT	Ljava/lang/String;
    //   65: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   68: pop
    //   69: aload 4
    //   71: ldc_w 338
    //   74: invokestatic 340	com/baidu/android/pushservice/h/a/b:b	()J
    //   77: invokestatic 343	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   80: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   83: pop
    //   84: aload_0
    //   85: invokestatic 345	com/baidu/android/pushservice/h/a/b:a	(Landroid/content/Context;)[I
    //   88: astore_2
    //   89: aload 4
    //   91: ldc_w 347
    //   94: aload_2
    //   95: iconst_0
    //   96: iaload
    //   97: invokestatic 349	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   100: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   103: pop
    //   104: aload 4
    //   106: ldc_w 351
    //   109: aload_2
    //   110: iconst_1
    //   111: iaload
    //   112: invokestatic 349	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   115: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   118: pop
    //   119: aload 4
    //   121: ldc_w 353
    //   124: invokestatic 355	com/baidu/android/pushservice/h/a/b:c	()Ljava/lang/String;
    //   127: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   130: pop
    //   131: aload 4
    //   133: ldc_w 357
    //   136: invokestatic 359	com/baidu/android/pushservice/h/a/b:d	()Ljava/lang/String;
    //   139: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   142: pop
    //   143: aload 4
    //   145: ldc_w 361
    //   148: aload_2
    //   149: iconst_2
    //   150: iaload
    //   151: invokestatic 349	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   154: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   157: pop
    //   158: aload 4
    //   160: ldc_w 363
    //   163: getstatic 366	android/os/Build$VERSION:SDK_INT	I
    //   166: invokestatic 349	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   169: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   172: pop
    //   173: aload_0
    //   174: ldc -17
    //   176: invokevirtual 166	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   179: checkcast 241	android/telephony/TelephonyManager
    //   182: ifnull +16 -> 198
    //   185: aload 4
    //   187: ldc_w 368
    //   190: aload_0
    //   191: invokestatic 372	com/baidu/android/pushservice/k/e:a	(Landroid/content/Context;)Ljava/lang/String;
    //   194: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   197: pop
    //   198: aload_0
    //   199: ldc_w 374
    //   202: iconst_0
    //   203: invokevirtual 378	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   206: ldc_w 380
    //   209: aconst_null
    //   210: invokeinterface 386 3 0
    //   215: astore_2
    //   216: aload_2
    //   217: ifnull +12 -> 229
    //   220: aload_2
    //   221: invokevirtual 268	java/lang/String:length	()I
    //   224: istore_1
    //   225: iload_1
    //   226: ifne +105 -> 331
    //   229: aload_0
    //   230: invokevirtual 390	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   233: ldc_w 392
    //   236: invokevirtual 166	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   239: checkcast 394	android/net/wifi/WifiManager
    //   242: invokevirtual 398	android/net/wifi/WifiManager:getConnectionInfo	()Landroid/net/wifi/WifiInfo;
    //   245: invokevirtual 403	android/net/wifi/WifiInfo:getMacAddress	()Ljava/lang/String;
    //   248: astore_3
    //   249: aload_3
    //   250: astore_2
    //   251: aload_3
    //   252: ifnull +41 -> 293
    //   255: aload_3
    //   256: astore_2
    //   257: aload_3
    //   258: invokevirtual 268	java/lang/String:length	()I
    //   261: ifle +32 -> 293
    //   264: aload_0
    //   265: ldc_w 374
    //   268: iconst_0
    //   269: invokevirtual 378	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   272: invokeinterface 407 1 0
    //   277: ldc_w 380
    //   280: aload_3
    //   281: invokeinterface 413 3 0
    //   286: invokeinterface 416 1 0
    //   291: aload_3
    //   292: astore_2
    //   293: aload_2
    //   294: ifnull +20 -> 314
    //   297: aload_2
    //   298: invokevirtual 268	java/lang/String:length	()I
    //   301: ifle +13 -> 314
    //   304: aload 4
    //   306: ldc_w 418
    //   309: aload_2
    //   310: invokevirtual 258	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   313: pop
    //   314: aload 4
    //   316: areturn
    //   317: astore_0
    //   318: aload 4
    //   320: areturn
    //   321: astore_0
    //   322: goto -29 -> 293
    //   325: astore_0
    //   326: aload_3
    //   327: astore_2
    //   328: goto -35 -> 293
    //   331: goto -38 -> 293
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	paramContext	Context
    //   224	2	1	i	int
    //   88	240	2	localObject	Object
    //   248	79	3	str	String
    //   7	312	4	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   9	198	317	org/json/JSONException
    //   198	216	317	org/json/JSONException
    //   220	225	317	org/json/JSONException
    //   229	249	317	org/json/JSONException
    //   257	291	317	org/json/JSONException
    //   297	314	317	org/json/JSONException
    //   229	249	321	java/lang/Exception
    //   257	291	325	java/lang/Exception
  }
  
  /* Error */
  private static int f()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 193	java/io/FileReader
    //   5: dup
    //   6: ldc_w 420
    //   9: invokespecial 198	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   12: astore_1
    //   13: new 140	java/io/BufferedReader
    //   16: dup
    //   17: aload_1
    //   18: invokespecial 143	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   21: astore_3
    //   22: aload_3
    //   23: invokevirtual 150	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   26: astore_2
    //   27: aload_2
    //   28: ifnull +90 -> 118
    //   31: aload_2
    //   32: invokevirtual 423	java/lang/String:trim	()Ljava/lang/String;
    //   35: invokestatic 279	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   38: istore_0
    //   39: iconst_2
    //   40: anewarray 39	java/io/Closeable
    //   43: dup
    //   44: iconst_0
    //   45: aload_1
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: aload_3
    //   50: aastore
    //   51: invokestatic 44	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   54: iload_0
    //   55: ireturn
    //   56: astore_1
    //   57: aconst_null
    //   58: astore_1
    //   59: iconst_2
    //   60: anewarray 39	java/io/Closeable
    //   63: dup
    //   64: iconst_0
    //   65: aload_1
    //   66: aastore
    //   67: dup
    //   68: iconst_1
    //   69: aload_2
    //   70: aastore
    //   71: invokestatic 44	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   74: iconst_0
    //   75: ireturn
    //   76: astore_2
    //   77: aconst_null
    //   78: astore_1
    //   79: aconst_null
    //   80: astore_3
    //   81: iconst_2
    //   82: anewarray 39	java/io/Closeable
    //   85: dup
    //   86: iconst_0
    //   87: aload_1
    //   88: aastore
    //   89: dup
    //   90: iconst_1
    //   91: aload_3
    //   92: aastore
    //   93: invokestatic 44	com/baidu/android/pushservice/f/b:a	([Ljava/io/Closeable;)V
    //   96: aload_2
    //   97: athrow
    //   98: astore_2
    //   99: aconst_null
    //   100: astore_3
    //   101: goto -20 -> 81
    //   104: astore_2
    //   105: goto -24 -> 81
    //   108: astore_3
    //   109: goto -50 -> 59
    //   112: astore_2
    //   113: aload_3
    //   114: astore_2
    //   115: goto -56 -> 59
    //   118: iconst_0
    //   119: istore_0
    //   120: goto -81 -> 39
    // Local variable table:
    //   start	length	slot	name	signature
    //   38	82	0	i	int
    //   12	34	1	localFileReader	java.io.FileReader
    //   56	1	1	localException1	Exception
    //   58	30	1	localObject1	Object
    //   1	69	2	str	String
    //   76	21	2	localObject2	Object
    //   98	1	2	localObject3	Object
    //   104	1	2	localObject4	Object
    //   112	1	2	localException2	Exception
    //   114	1	2	localObject5	Object
    //   21	80	3	localBufferedReader	java.io.BufferedReader
    //   108	6	3	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   2	13	56	java/lang/Exception
    //   2	13	76	finally
    //   13	22	98	finally
    //   22	27	104	finally
    //   31	39	104	finally
    //   13	22	108	java/lang/Exception
    //   22	27	112	java/lang/Exception
    //   31	39	112	java/lang/Exception
  }
  
  public static class a
  {
    public int a;
    public int b;
    public int c;
    public double d;
    public long e;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/h/a/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */