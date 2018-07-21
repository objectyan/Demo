package com.baidu.navisdk.module.business;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.text.TextUtils;
import com.baidu.navisdk.util.common.BitmapLoadUtils;
import com.baidu.navisdk.util.common.FileUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.MD5;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.SysOSAPI;
import java.io.File;
import java.io.IOException;

public class FileCache
{
  private static final String DATA_CACHE_DIR_NAME = "navi_activity";
  private static final String KEY_LAST_CLEAR_CACHE_TIME = "key_last_clear_cache_time";
  private static final String TAG = FileCache.class.getSimpleName();
  
  /* Error */
  public static String cacheFile(String paramString1, String paramString2, byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: getstatic 22	com/baidu/navisdk/module/business/FileCache:TAG	Ljava/lang/String;
    //   3: new 32	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   10: ldc 35
    //   12: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: invokestatic 48	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: invokestatic 52	com/baidu/navisdk/module/business/FileCache:checkCacheDir	()Z
    //   28: ifne +12 -> 40
    //   31: aload_0
    //   32: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: ifeq +5 -> 40
    //   38: aconst_null
    //   39: areturn
    //   40: invokestatic 61	com/baidu/navisdk/module/business/FileCache:getCacheDirPath	()Ljava/lang/String;
    //   43: astore 10
    //   45: aload 10
    //   47: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   50: ifeq +5 -> 55
    //   53: aconst_null
    //   54: areturn
    //   55: aload_0
    //   56: bipush 46
    //   58: invokevirtual 67	java/lang/String:lastIndexOf	(I)I
    //   61: istore_3
    //   62: iload_3
    //   63: iflt +13 -> 76
    //   66: iload_3
    //   67: aload_0
    //   68: invokevirtual 71	java/lang/String:length	()I
    //   71: iconst_1
    //   72: isub
    //   73: if_icmplt +5 -> 78
    //   76: aconst_null
    //   77: areturn
    //   78: aconst_null
    //   79: astore 7
    //   81: aconst_null
    //   82: astore 6
    //   84: aload 7
    //   86: astore 5
    //   88: aload_0
    //   89: iload_3
    //   90: aload_0
    //   91: invokevirtual 71	java/lang/String:length	()I
    //   94: invokevirtual 75	java/lang/String:substring	(II)Ljava/lang/String;
    //   97: astore 8
    //   99: aload 7
    //   101: astore 5
    //   103: aload 8
    //   105: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   108: istore 4
    //   110: iload 4
    //   112: ifeq +17 -> 129
    //   115: iconst_0
    //   116: ifeq +11 -> 127
    //   119: new 77	java/lang/NullPointerException
    //   122: dup
    //   123: invokespecial 78	java/lang/NullPointerException:<init>	()V
    //   126: athrow
    //   127: aconst_null
    //   128: areturn
    //   129: aload 7
    //   131: astore 5
    //   133: aload_0
    //   134: invokestatic 84	com/baidu/navisdk/util/common/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   137: astore 9
    //   139: aload 7
    //   141: astore 5
    //   143: aload 9
    //   145: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   148: istore 4
    //   150: iload 4
    //   152: ifeq +17 -> 169
    //   155: iconst_0
    //   156: ifeq +11 -> 167
    //   159: new 77	java/lang/NullPointerException
    //   162: dup
    //   163: invokespecial 78	java/lang/NullPointerException:<init>	()V
    //   166: athrow
    //   167: aconst_null
    //   168: areturn
    //   169: aload 7
    //   171: astore 5
    //   173: new 32	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   180: aload 10
    //   182: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: getstatic 89	java/io/File:separator	Ljava/lang/String;
    //   188: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: astore 10
    //   193: aload_1
    //   194: astore_0
    //   195: aload 7
    //   197: astore 5
    //   199: aload_1
    //   200: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   203: ifeq +6 -> 209
    //   206: ldc 91
    //   208: astore_0
    //   209: aload 7
    //   211: astore 5
    //   213: aload 10
    //   215: aload_0
    //   216: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload 9
    //   221: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: aload 8
    //   226: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   229: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: astore_1
    //   233: aload 7
    //   235: astore 5
    //   237: getstatic 22	com/baidu/navisdk/module/business/FileCache:TAG	Ljava/lang/String;
    //   240: new 32	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   247: ldc 93
    //   249: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload_1
    //   253: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   256: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   259: invokestatic 48	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload 7
    //   264: astore 5
    //   266: new 95	java/io/FileOutputStream
    //   269: dup
    //   270: aload_1
    //   271: invokespecial 98	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   274: astore_0
    //   275: aload_0
    //   276: ifnull +22 -> 298
    //   279: aload_0
    //   280: aload_2
    //   281: invokevirtual 102	java/io/FileOutputStream:write	([B)V
    //   284: aload_0
    //   285: invokevirtual 105	java/io/FileOutputStream:flush	()V
    //   288: aload_0
    //   289: ifnull +7 -> 296
    //   292: aload_0
    //   293: invokevirtual 108	java/io/FileOutputStream:close	()V
    //   296: aload_1
    //   297: areturn
    //   298: aload_0
    //   299: ifnull +7 -> 306
    //   302: aload_0
    //   303: invokevirtual 108	java/io/FileOutputStream:close	()V
    //   306: aconst_null
    //   307: areturn
    //   308: astore_1
    //   309: aload 6
    //   311: astore_0
    //   312: aload_0
    //   313: astore 5
    //   315: getstatic 112	com/baidu/navisdk/util/common/LogUtil:LOGGABLE	Z
    //   318: ifeq +10 -> 328
    //   321: aload_0
    //   322: astore 5
    //   324: aload_1
    //   325: invokevirtual 115	java/lang/Exception:printStackTrace	()V
    //   328: aload_0
    //   329: ifnull +7 -> 336
    //   332: aload_0
    //   333: invokevirtual 108	java/io/FileOutputStream:close	()V
    //   336: goto -30 -> 306
    //   339: astore_0
    //   340: aload 5
    //   342: ifnull +8 -> 350
    //   345: aload 5
    //   347: invokevirtual 108	java/io/FileOutputStream:close	()V
    //   350: aload_0
    //   351: athrow
    //   352: astore_0
    //   353: goto -226 -> 127
    //   356: astore_0
    //   357: goto -190 -> 167
    //   360: astore_0
    //   361: goto -65 -> 296
    //   364: astore_0
    //   365: goto -59 -> 306
    //   368: astore_0
    //   369: goto -33 -> 336
    //   372: astore_1
    //   373: goto -23 -> 350
    //   376: astore_1
    //   377: aload_0
    //   378: astore 5
    //   380: aload_1
    //   381: astore_0
    //   382: goto -42 -> 340
    //   385: astore_1
    //   386: goto -74 -> 312
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	paramString1	String
    //   0	389	1	paramString2	String
    //   0	389	2	paramArrayOfByte	byte[]
    //   61	29	3	i	int
    //   108	43	4	bool	boolean
    //   86	293	5	localObject1	Object
    //   82	228	6	localObject2	Object
    //   79	184	7	localObject3	Object
    //   97	128	8	str1	String
    //   137	83	9	str2	String
    //   43	171	10	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   88	99	308	java/lang/Exception
    //   103	110	308	java/lang/Exception
    //   133	139	308	java/lang/Exception
    //   143	150	308	java/lang/Exception
    //   173	193	308	java/lang/Exception
    //   199	206	308	java/lang/Exception
    //   213	233	308	java/lang/Exception
    //   237	262	308	java/lang/Exception
    //   266	275	308	java/lang/Exception
    //   88	99	339	finally
    //   103	110	339	finally
    //   133	139	339	finally
    //   143	150	339	finally
    //   173	193	339	finally
    //   199	206	339	finally
    //   213	233	339	finally
    //   237	262	339	finally
    //   266	275	339	finally
    //   315	321	339	finally
    //   324	328	339	finally
    //   119	127	352	java/lang/Exception
    //   159	167	356	java/lang/Exception
    //   292	296	360	java/lang/Exception
    //   302	306	364	java/lang/Exception
    //   332	336	368	java/lang/Exception
    //   345	350	372	java/lang/Exception
    //   279	288	376	finally
    //   279	288	385	java/lang/Exception
  }
  
  public static boolean checkCacheDir()
  {
    Object localObject = SysOSAPI.getInstance().getSecondCachePath();
    if (TextUtils.isEmpty((CharSequence)localObject)) {}
    do
    {
      for (;;)
      {
        return false;
        localObject = (String)localObject + File.separator + "navi_activity";
        try
        {
          localObject = new File((String)localObject);
          if (localObject != null)
          {
            if (((File)localObject).exists()) {
              return true;
            }
            boolean bool = ((File)localObject).mkdirs();
            return bool;
          }
        }
        catch (Exception localException) {}
      }
    } while (!LogUtil.LOGGABLE);
    localException.printStackTrace();
    return false;
  }
  
  public static void clearCache(Context paramContext, boolean paramBoolean)
  {
    Object localObject;
    long l;
    if ((!paramBoolean) && (paramContext != null))
    {
      localObject = PreferenceHelper.getInstance(paramContext.getApplicationContext());
      if (localObject != null)
      {
        l = ((PreferenceHelper)localObject).getLong("key_last_clear_cache_time", -1L);
        if (l > 0L) {
          break label53;
        }
      }
    }
    label53:
    do
    {
      do
      {
        localObject = getCacheDirPath();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        return;
      } while (SystemClock.elapsedRealtime() - l >= 1296000000L);
      LogUtil.e(TAG, "clearCache() return for is not time.");
      return;
      try
      {
        LogUtil.e(TAG, "clearCache()");
        if (paramContext != null)
        {
          paramContext = PreferenceHelper.getInstance(paramContext.getApplicationContext());
          if (paramContext != null) {
            paramContext.putLong("key_last_clear_cache_time", SystemClock.elapsedRealtime());
          }
        }
        FileUtils.del((String)localObject);
        return;
      }
      catch (IOException paramContext) {}
    } while (!LogUtil.LOGGABLE);
    paramContext.printStackTrace();
  }
  
  public static String getCacheDirPath()
  {
    String str = SysOSAPI.getInstance().getSecondCachePath();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return str + File.separator + "navi_activity";
  }
  
  public static String getCacheFilePath(String paramString1, String paramString2)
  {
    LogUtil.e(TAG, "getCacheFilePath() url=" + paramString1);
    if ((!checkCacheDir()) && (TextUtils.isEmpty(paramString1))) {
      return null;
    }
    Object localObject = getCacheDirPath();
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    int i = paramString1.lastIndexOf('.');
    if ((i < 0) || (i >= paramString1.length() - 1)) {
      return null;
    }
    try
    {
      String str1 = paramString1.substring(i, paramString1.length());
      if (TextUtils.isEmpty(str1)) {
        return null;
      }
      String str2 = MD5.toMD5(paramString1);
      if (TextUtils.isEmpty(str2)) {
        return null;
      }
      localObject = new StringBuilder().append((String)localObject).append(File.separator);
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = "";
      }
      paramString1 = paramString1 + str2 + str1;
      LogUtil.e(TAG, "getCacheFilePath() fp=" + paramString1);
      paramString2 = new File(paramString1);
      if ((paramString2 != null) && (paramString2.exists()))
      {
        LogUtil.e(TAG, "getCacheFilePath() got it.");
        return paramString1;
      }
    }
    catch (Exception paramString1)
    {
      if (LogUtil.LOGGABLE) {
        paramString1.printStackTrace();
      }
    }
    return null;
  }
  
  public static Bitmap loadBitmapCache(String paramString1, String paramString2)
  {
    LogUtil.e(TAG, "loadBitmapCache() url=" + paramString1);
    if ((!checkCacheDir()) && (TextUtils.isEmpty(paramString1))) {}
    do
    {
      for (;;)
      {
        return null;
        Object localObject = getCacheDirPath();
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          int i = paramString1.lastIndexOf('.');
          if ((i >= 0) && (i < paramString1.length() - 1)) {
            try
            {
              String str1 = paramString1.substring(i, paramString1.length());
              if (!TextUtils.isEmpty(str1))
              {
                String str2 = MD5.toMD5(paramString1);
                if (!TextUtils.isEmpty(str2))
                {
                  localObject = new StringBuilder().append((String)localObject).append(File.separator);
                  paramString1 = paramString2;
                  if (TextUtils.isEmpty(paramString2)) {
                    paramString1 = "";
                  }
                  paramString1 = paramString1 + str2 + str1;
                  LogUtil.e(TAG, "loadBitmapCache() fp=" + paramString1);
                  paramString2 = new File(paramString1);
                  if ((paramString2 != null) && (paramString2.exists()))
                  {
                    LogUtil.e(TAG, "loadBitmapCache() got it.");
                    paramString1 = BitmapLoadUtils.getBitmapFromPath(paramString1);
                    return paramString1;
                  }
                }
              }
            }
            catch (Exception paramString1) {}
          }
        }
      }
    } while (!LogUtil.LOGGABLE);
    paramString1.printStackTrace();
    return null;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/business/FileCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */