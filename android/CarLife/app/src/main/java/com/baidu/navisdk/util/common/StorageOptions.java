package com.baidu.navisdk.util.common;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

@TargetApi(9)
public class StorageOptions
{
  private static final String DEV_BLOCK_VOLD = "/dev/block/vold/";
  private static final String DEV_MOUNT = "dev_mount";
  public static final String EXTERNAL_SD_CARD = "外置存储卡";
  public static final String INTERNAL_STORAGE = "内置存储卡";
  private static String MNT_SDCARD = "";
  private static final String PROC_MOUNTS = "/proc/mounts";
  private static final String SYSTEM_ETC_VOLD_FSTAB = "/system/etc/vold.fstab";
  public static int count = 0;
  public static String[] labels;
  private static ArrayList<String> mMounts = new ArrayList();
  private static ArrayList<String> mVold = new ArrayList();
  public static String[] paths;
  public static String[] sizes;
  
  private static void compareMountsWithVold()
  {
    int j;
    for (int i = 0; i < mMounts.size(); i = j + 1)
    {
      String str = (String)mMounts.get(i);
      j = i;
      if (!mVold.contains(str))
      {
        mMounts.remove(i);
        j = i - 1;
      }
    }
    mVold.clear();
  }
  
  public static void determineStorageOptions(Context paramContext)
  {
    MNT_SDCARD = Environment.getExternalStorageDirectory().getAbsolutePath();
    boolean bool = false;
    if (Build.VERSION.SDK_INT >= 14) {
      bool = getStoragePaths(paramContext);
    }
    if (!bool)
    {
      readMountsFile();
      readVoldFile();
      compareMountsWithVold();
      testAndCleanMountsList();
      setProperties();
    }
  }
  
  private static String getAvailaleSize(String paramString)
  {
    try
    {
      paramString = new StatFs(paramString);
      long l = paramString.getBlockSize();
      l = paramString.getAvailableBlocks() * l;
      paramString = new DecimalFormat();
      if (l < 1024L) {
        return l + "B";
      }
      if (l < 1048576L)
      {
        paramString.applyPattern("0");
        d = l / 1024.0D;
        return paramString.format(d) + "K";
      }
      if (l < 1073741824L)
      {
        paramString.applyPattern("0.0");
        d = l / 1048576.0D;
        return paramString.format(d) + "M";
      }
      paramString.applyPattern("0.0");
      double d = l / 1.073741824E9D;
      paramString = paramString.format(d) + "G";
      return paramString;
    }
    catch (IllegalArgumentException paramString)
    {
      LogUtil.e("", paramString.toString());
    }
    return "未知大小";
  }
  
  private static boolean getStoragePaths(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (Build.VERSION.SDK_INT < 9) {
      return getStoragePathsV1(paramContext);
    }
    if (Build.VERSION.SDK_INT < 19) {
      return getStoragePathsV2(paramContext);
    }
    return getStoragePathsV3(paramContext);
  }
  
  private static boolean getStoragePathsV1(Context paramContext)
  {
    paths = new String[1];
    paths[0] = Environment.getExternalStorageDirectory().getAbsolutePath();
    return true;
  }
  
  private static boolean getStoragePathsV2(Context paramContext)
  {
    Object localObject1 = paramContext.getSystemService("storage");
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    ArrayList localArrayList3;
    if (localObject1 != null)
    {
      paramContext = new ArrayList();
      localArrayList1 = new ArrayList();
      localArrayList2 = new ArrayList();
      localArrayList3 = new ArrayList();
    }
    for (;;)
    {
      try
      {
        Object localObject2 = Class.forName("android.os.storage.StorageVolume");
        Object localObject3 = localObject1.getClass().getMethod("getVolumeList", new Class[0]);
        Method localMethod1 = localObject1.getClass().getMethod("getVolumeState", new Class[] { String.class });
        Method localMethod2 = ((Class)localObject2).getMethod("isRemovable", new Class[0]);
        localObject2 = ((Class)localObject2).getMethod("getPath", new Class[0]);
        localObject3 = (Object[])((Method)localObject3).invoke(localObject1, new Object[0]);
        i = 0;
        if (i < localObject3.length)
        {
          String str1 = (String)((Method)localObject2).invoke(localObject3[i], new Object[0]);
          boolean bool = ((Boolean)localMethod2.invoke(localObject3[i], new Object[0])).booleanValue();
          if ((str1 == null) || (StringUtils.isEmpty(str1))) {
            break label516;
          }
          String str2 = (String)localMethod1.invoke(localObject1, new Object[] { str1 });
          if ((str2 == null) || (!str2.equals("mounted"))) {
            break label516;
          }
          if (bool) {
            localArrayList1.add(str1);
          } else {
            paramContext.add(str1);
          }
        }
      }
      catch (ClassNotFoundException paramContext)
      {
        LogUtil.e("", paramContext.toString());
        return false;
        i = 0;
        if (i >= paramContext.size()) {
          break label523;
        }
        mMounts.add(paramContext.get(i));
        localArrayList2.add("内置存储卡");
        localArrayList3.add(getAvailaleSize((String)paramContext.get(i)));
        i += 1;
        continue;
        if (i < localArrayList1.size())
        {
          mMounts.add(localArrayList1.get(i));
          localArrayList2.add("外置存储卡");
          localArrayList3.add(getAvailaleSize((String)localArrayList1.get(i)));
          i += 1;
          continue;
        }
        labels = new String[localArrayList2.size()];
        localArrayList2.toArray(labels);
        paths = new String[mMounts.size()];
        mMounts.toArray(paths);
        sizes = new String[mMounts.size()];
        localArrayList3.toArray(sizes);
        count = Math.min(labels.length, paths.length);
        mMounts.clear();
        return true;
      }
      catch (NoSuchMethodException paramContext)
      {
        LogUtil.e("", paramContext.toString());
        continue;
      }
      catch (IllegalArgumentException paramContext)
      {
        LogUtil.e("", paramContext.toString());
        continue;
      }
      catch (IllegalAccessException paramContext)
      {
        LogUtil.e("", paramContext.toString());
        continue;
      }
      catch (InvocationTargetException paramContext)
      {
        LogUtil.e("", paramContext.toString());
        continue;
      }
      return getStoragePathsV1(paramContext);
      label516:
      i += 1;
      continue;
      label523:
      int i = 0;
    }
  }
  
  /* Error */
  private static boolean getStoragePathsV3(Context paramContext)
  {
    // Byte code:
    //   0: new 45	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 48	java/util/ArrayList:<init>	()V
    //   7: astore 5
    //   9: new 45	java/util/ArrayList
    //   12: dup
    //   13: invokespecial 48	java/util/ArrayList:<init>	()V
    //   16: astore 6
    //   18: new 45	java/util/ArrayList
    //   21: dup
    //   22: invokespecial 48	java/util/ArrayList:<init>	()V
    //   25: astore 7
    //   27: new 45	java/util/ArrayList
    //   30: dup
    //   31: invokespecial 48	java/util/ArrayList:<init>	()V
    //   34: astore 8
    //   36: aload_0
    //   37: ldc -50
    //   39: invokevirtual 212	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   42: astore 9
    //   44: aload 9
    //   46: ifnull +222 -> 268
    //   49: ldc -42
    //   51: invokestatic 220	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   54: astore 12
    //   56: aload 9
    //   58: invokevirtual 224	java/lang/Object:getClass	()Ljava/lang/Class;
    //   61: ldc -30
    //   63: iconst_0
    //   64: anewarray 216	java/lang/Class
    //   67: invokevirtual 230	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   70: astore 13
    //   72: aload 9
    //   74: invokevirtual 224	java/lang/Object:getClass	()Ljava/lang/Class;
    //   77: ldc -24
    //   79: iconst_1
    //   80: anewarray 216	java/lang/Class
    //   83: dup
    //   84: iconst_0
    //   85: ldc 67
    //   87: aastore
    //   88: invokevirtual 230	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   91: astore 10
    //   93: aload 12
    //   95: ldc -22
    //   97: iconst_0
    //   98: anewarray 216	java/lang/Class
    //   101: invokevirtual 230	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   104: astore 11
    //   106: aload 12
    //   108: ldc -20
    //   110: iconst_0
    //   111: anewarray 216	java/lang/Class
    //   114: invokevirtual 230	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   117: astore 12
    //   119: aload 13
    //   121: aload 9
    //   123: iconst_0
    //   124: anewarray 4	java/lang/Object
    //   127: invokevirtual 242	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   130: checkcast 244	[Ljava/lang/Object;
    //   133: checkcast 244	[Ljava/lang/Object;
    //   136: astore 13
    //   138: iconst_0
    //   139: istore_1
    //   140: iload_1
    //   141: aload 13
    //   143: arraylength
    //   144: if_icmpge +124 -> 268
    //   147: aload 12
    //   149: aload 13
    //   151: iload_1
    //   152: aaload
    //   153: iconst_0
    //   154: anewarray 4	java/lang/Object
    //   157: invokevirtual 242	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   160: checkcast 67	java/lang/String
    //   163: astore 14
    //   165: aload 11
    //   167: aload 13
    //   169: iload_1
    //   170: aaload
    //   171: iconst_0
    //   172: anewarray 4	java/lang/Object
    //   175: invokevirtual 242	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   178: checkcast 246	java/lang/Boolean
    //   181: invokevirtual 250	java/lang/Boolean:booleanValue	()Z
    //   184: istore 4
    //   186: aload 14
    //   188: ifnull +61 -> 249
    //   191: aload 14
    //   193: invokestatic 256	com/baidu/navisdk/util/common/StringUtils:isEmpty	(Ljava/lang/String;)Z
    //   196: ifne +53 -> 249
    //   199: aload 10
    //   201: aload 9
    //   203: iconst_1
    //   204: anewarray 4	java/lang/Object
    //   207: dup
    //   208: iconst_0
    //   209: aload 14
    //   211: aastore
    //   212: invokevirtual 242	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   215: checkcast 67	java/lang/String
    //   218: astore 15
    //   220: aload 15
    //   222: ifnull +27 -> 249
    //   225: aload 15
    //   227: ldc_w 258
    //   230: invokevirtual 261	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   233: ifeq +16 -> 249
    //   236: iload 4
    //   238: ifne +11 -> 249
    //   241: aload 5
    //   243: aload 14
    //   245: invokevirtual 264	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   248: pop
    //   249: iload_1
    //   250: iconst_1
    //   251: iadd
    //   252: istore_1
    //   253: goto -113 -> 140
    //   256: astore 9
    //   258: ldc 41
    //   260: aload 9
    //   262: invokevirtual 265	java/lang/ClassNotFoundException:toString	()Ljava/lang/String;
    //   265: invokestatic 183	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   268: ldc -48
    //   270: ldc_w 288
    //   273: iconst_1
    //   274: anewarray 216	java/lang/Class
    //   277: dup
    //   278: iconst_0
    //   279: ldc 67
    //   281: aastore
    //   282: invokevirtual 230	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   285: astore 9
    //   287: aload 9
    //   289: ifnonnull +65 -> 354
    //   292: iconst_0
    //   293: ireturn
    //   294: astore 9
    //   296: ldc 41
    //   298: aload 9
    //   300: invokevirtual 282	java/lang/NoSuchMethodException:toString	()Ljava/lang/String;
    //   303: invokestatic 183	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: goto -38 -> 268
    //   309: astore 9
    //   311: ldc 41
    //   313: aload 9
    //   315: invokevirtual 177	java/lang/IllegalArgumentException:toString	()Ljava/lang/String;
    //   318: invokestatic 183	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   321: goto -53 -> 268
    //   324: astore 9
    //   326: ldc 41
    //   328: aload 9
    //   330: invokevirtual 283	java/lang/IllegalAccessException:toString	()Ljava/lang/String;
    //   333: invokestatic 183	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   336: goto -68 -> 268
    //   339: astore 9
    //   341: ldc 41
    //   343: aload 9
    //   345: invokevirtual 284	java/lang/reflect/InvocationTargetException:toString	()Ljava/lang/String;
    //   348: invokestatic 183	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: goto -83 -> 268
    //   354: aload 9
    //   356: aload_0
    //   357: iconst_1
    //   358: anewarray 4	java/lang/Object
    //   361: dup
    //   362: iconst_0
    //   363: ldc 41
    //   365: aastore
    //   366: invokevirtual 242	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   369: checkcast 290	[Ljava/io/File;
    //   372: checkcast 290	[Ljava/io/File;
    //   375: astore 9
    //   377: aload 9
    //   379: ifnonnull +12 -> 391
    //   382: iconst_0
    //   383: ireturn
    //   384: astore_0
    //   385: aload_0
    //   386: invokevirtual 293	java/lang/Exception:printStackTrace	()V
    //   389: iconst_0
    //   390: ireturn
    //   391: aload 9
    //   393: ifnonnull +5 -> 398
    //   396: iconst_1
    //   397: ireturn
    //   398: iconst_0
    //   399: istore_1
    //   400: iload_1
    //   401: aload 9
    //   403: arraylength
    //   404: if_icmpge +100 -> 504
    //   407: aload 9
    //   409: iload_1
    //   410: aaload
    //   411: ifnull +93 -> 504
    //   414: aload 9
    //   416: iload_1
    //   417: aaload
    //   418: invokevirtual 91	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   421: astore 10
    //   423: aload 10
    //   425: ifnonnull +10 -> 435
    //   428: iload_1
    //   429: iconst_1
    //   430: iadd
    //   431: istore_1
    //   432: goto -32 -> 400
    //   435: iconst_0
    //   436: istore_3
    //   437: aload 5
    //   439: invokevirtual 297	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   442: astore 11
    //   444: iload_3
    //   445: istore_2
    //   446: aload 11
    //   448: invokeinterface 302 1 0
    //   453: ifeq +23 -> 476
    //   456: aload 10
    //   458: aload 11
    //   460: invokeinterface 306 1 0
    //   465: checkcast 67	java/lang/String
    //   468: invokevirtual 309	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   471: ifeq -27 -> 444
    //   474: iconst_1
    //   475: istore_2
    //   476: iload_2
    //   477: ifne -49 -> 428
    //   480: aload 10
    //   482: aload_0
    //   483: invokevirtual 312	android/content/Context:getPackageName	()Ljava/lang/String;
    //   486: invokevirtual 316	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   489: iconst_m1
    //   490: if_icmpeq -62 -> 428
    //   493: aload 6
    //   495: aload 10
    //   497: invokevirtual 264	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   500: pop
    //   501: goto -73 -> 428
    //   504: iconst_0
    //   505: istore_1
    //   506: iload_1
    //   507: aload 5
    //   509: invokevirtual 61	java/util/ArrayList:size	()I
    //   512: if_icmpge +49 -> 561
    //   515: getstatic 50	com/baidu/navisdk/util/common/StorageOptions:mMounts	Ljava/util/ArrayList;
    //   518: aload 5
    //   520: iload_1
    //   521: invokevirtual 65	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   524: invokevirtual 264	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   527: pop
    //   528: aload 7
    //   530: ldc 20
    //   532: invokevirtual 264	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   535: pop
    //   536: aload 8
    //   538: aload 5
    //   540: iload_1
    //   541: invokevirtual 65	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   544: checkcast 67	java/lang/String
    //   547: invokestatic 267	com/baidu/navisdk/util/common/StorageOptions:getAvailaleSize	(Ljava/lang/String;)Ljava/lang/String;
    //   550: invokevirtual 264	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   553: pop
    //   554: iload_1
    //   555: iconst_1
    //   556: iadd
    //   557: istore_1
    //   558: goto -52 -> 506
    //   561: iconst_0
    //   562: istore_1
    //   563: iload_1
    //   564: aload 6
    //   566: invokevirtual 61	java/util/ArrayList:size	()I
    //   569: if_icmpge +49 -> 618
    //   572: getstatic 50	com/baidu/navisdk/util/common/StorageOptions:mMounts	Ljava/util/ArrayList;
    //   575: aload 6
    //   577: iload_1
    //   578: invokevirtual 65	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   581: invokevirtual 264	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   584: pop
    //   585: aload 7
    //   587: ldc 17
    //   589: invokevirtual 264	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   592: pop
    //   593: aload 8
    //   595: aload 6
    //   597: iload_1
    //   598: invokevirtual 65	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   601: checkcast 67	java/lang/String
    //   604: invokestatic 267	com/baidu/navisdk/util/common/StorageOptions:getAvailaleSize	(Ljava/lang/String;)Ljava/lang/String;
    //   607: invokevirtual 264	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   610: pop
    //   611: iload_1
    //   612: iconst_1
    //   613: iadd
    //   614: istore_1
    //   615: goto -52 -> 563
    //   618: aload 7
    //   620: invokevirtual 61	java/util/ArrayList:size	()I
    //   623: anewarray 67	java/lang/String
    //   626: putstatic 269	com/baidu/navisdk/util/common/StorageOptions:labels	[Ljava/lang/String;
    //   629: aload 7
    //   631: getstatic 269	com/baidu/navisdk/util/common/StorageOptions:labels	[Ljava/lang/String;
    //   634: invokevirtual 273	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   637: pop
    //   638: getstatic 50	com/baidu/navisdk/util/common/StorageOptions:mMounts	Ljava/util/ArrayList;
    //   641: invokevirtual 61	java/util/ArrayList:size	()I
    //   644: anewarray 67	java/lang/String
    //   647: putstatic 196	com/baidu/navisdk/util/common/StorageOptions:paths	[Ljava/lang/String;
    //   650: getstatic 50	com/baidu/navisdk/util/common/StorageOptions:mMounts	Ljava/util/ArrayList;
    //   653: getstatic 196	com/baidu/navisdk/util/common/StorageOptions:paths	[Ljava/lang/String;
    //   656: invokevirtual 273	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   659: pop
    //   660: getstatic 50	com/baidu/navisdk/util/common/StorageOptions:mMounts	Ljava/util/ArrayList;
    //   663: invokevirtual 61	java/util/ArrayList:size	()I
    //   666: anewarray 67	java/lang/String
    //   669: putstatic 275	com/baidu/navisdk/util/common/StorageOptions:sizes	[Ljava/lang/String;
    //   672: aload 8
    //   674: getstatic 275	com/baidu/navisdk/util/common/StorageOptions:sizes	[Ljava/lang/String;
    //   677: invokevirtual 273	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   680: pop
    //   681: getstatic 269	com/baidu/navisdk/util/common/StorageOptions:labels	[Ljava/lang/String;
    //   684: arraylength
    //   685: getstatic 196	com/baidu/navisdk/util/common/StorageOptions:paths	[Ljava/lang/String;
    //   688: arraylength
    //   689: invokestatic 281	java/lang/Math:min	(II)I
    //   692: putstatic 54	com/baidu/navisdk/util/common/StorageOptions:count	I
    //   695: getstatic 50	com/baidu/navisdk/util/common/StorageOptions:mMounts	Ljava/util/ArrayList;
    //   698: invokevirtual 77	java/util/ArrayList:clear	()V
    //   701: iconst_1
    //   702: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	703	0	paramContext	Context
    //   139	476	1	i	int
    //   445	32	2	j	int
    //   436	9	3	k	int
    //   184	53	4	bool	boolean
    //   7	532	5	localArrayList1	ArrayList
    //   16	580	6	localArrayList2	ArrayList
    //   25	605	7	localArrayList3	ArrayList
    //   34	639	8	localArrayList4	ArrayList
    //   42	160	9	localObject1	Object
    //   256	5	9	localClassNotFoundException	ClassNotFoundException
    //   285	3	9	localMethod	Method
    //   294	5	9	localNoSuchMethodException	NoSuchMethodException
    //   309	5	9	localIllegalArgumentException	IllegalArgumentException
    //   324	5	9	localIllegalAccessException	IllegalAccessException
    //   339	16	9	localInvocationTargetException	InvocationTargetException
    //   375	40	9	arrayOfFile	File[]
    //   91	405	10	localObject2	Object
    //   104	355	11	localObject3	Object
    //   54	94	12	localObject4	Object
    //   70	98	13	localObject5	Object
    //   163	81	14	str1	String
    //   218	8	15	str2	String
    // Exception table:
    //   from	to	target	type
    //   49	138	256	java/lang/ClassNotFoundException
    //   140	186	256	java/lang/ClassNotFoundException
    //   191	220	256	java/lang/ClassNotFoundException
    //   225	236	256	java/lang/ClassNotFoundException
    //   241	249	256	java/lang/ClassNotFoundException
    //   49	138	294	java/lang/NoSuchMethodException
    //   140	186	294	java/lang/NoSuchMethodException
    //   191	220	294	java/lang/NoSuchMethodException
    //   225	236	294	java/lang/NoSuchMethodException
    //   241	249	294	java/lang/NoSuchMethodException
    //   49	138	309	java/lang/IllegalArgumentException
    //   140	186	309	java/lang/IllegalArgumentException
    //   191	220	309	java/lang/IllegalArgumentException
    //   225	236	309	java/lang/IllegalArgumentException
    //   241	249	309	java/lang/IllegalArgumentException
    //   49	138	324	java/lang/IllegalAccessException
    //   140	186	324	java/lang/IllegalAccessException
    //   191	220	324	java/lang/IllegalAccessException
    //   225	236	324	java/lang/IllegalAccessException
    //   241	249	324	java/lang/IllegalAccessException
    //   49	138	339	java/lang/reflect/InvocationTargetException
    //   140	186	339	java/lang/reflect/InvocationTargetException
    //   191	220	339	java/lang/reflect/InvocationTargetException
    //   225	236	339	java/lang/reflect/InvocationTargetException
    //   241	249	339	java/lang/reflect/InvocationTargetException
    //   268	287	384	java/lang/Exception
    //   354	377	384	java/lang/Exception
  }
  
  private static void readMountsFile()
  {
    mMounts.add(MNT_SDCARD);
    try
    {
      Scanner localScanner = new Scanner(new File("/proc/mounts"), "UTF-8");
      while (localScanner.hasNext())
      {
        Object localObject = localScanner.nextLine();
        if (((String)localObject).startsWith("/dev/block/vold/"))
        {
          localObject = ((String)localObject).replace('\t', ' ').split(" ");
          if ((localObject != null) && (1 < localObject.length))
          {
            localObject = localObject[1];
            if (!((String)localObject).equals(MNT_SDCARD)) {
              mMounts.add(localObject);
            }
          }
        }
      }
      return;
    }
    catch (Exception localException)
    {
      LogUtil.e("", localException.toString());
    }
  }
  
  private static void readVoldFile()
  {
    mVold.add(MNT_SDCARD);
    Object localObject1 = new File("/system/etc/vold.fstab");
    if (!((File)localObject1).exists()) {}
    for (;;)
    {
      return;
      try
      {
        Scanner localScanner = new Scanner((File)localObject1, "UTF-8");
        while (localScanner.hasNext())
        {
          localObject1 = localScanner.nextLine();
          if (((String)localObject1).startsWith("dev_mount"))
          {
            localObject1 = ((String)localObject1).replace('\t', ' ').split(" ");
            if ((localObject1 != null) && (2 < localObject1.length))
            {
              Object localObject2 = localObject1[2];
              localObject1 = localObject2;
              if (((String)localObject2).contains(":")) {
                localObject1 = ((String)localObject2).substring(0, ((String)localObject2).indexOf(":"));
              }
              if (!((String)localObject1).equals(MNT_SDCARD)) {
                mVold.add(localObject1);
              }
            }
          }
        }
        return;
      }
      catch (Exception localException)
      {
        LogUtil.e("", localException.toString());
      }
    }
  }
  
  @TargetApi(9)
  private static void setProperties()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (mMounts.size() > 0)
    {
      if (Build.VERSION.SDK_INT < 9) {
        localArrayList1.add("Auto");
      }
      localArrayList1.add("内置存储卡");
      localArrayList2.add(getAvailaleSize((String)mMounts.get(0)));
      if (mMounts.size() > 1)
      {
        int i = 1;
        while (i < mMounts.size())
        {
          localArrayList1.add("外置存储卡");
          localArrayList2.add(getAvailaleSize((String)mMounts.get(i)));
          i += 1;
        }
      }
    }
    labels = new String[localArrayList1.size()];
    localArrayList1.toArray(labels);
    paths = new String[mMounts.size()];
    mMounts.toArray(paths);
    sizes = new String[mMounts.size()];
    localArrayList2.toArray(sizes);
    count = Math.min(labels.length, paths.length);
    mMounts.clear();
  }
  
  private static void testAndCleanMountsList()
  {
    int j;
    for (int i = 0; i < mMounts.size(); i = j + 1)
    {
      File localFile = new File((String)mMounts.get(i));
      if ((localFile.exists()) && (localFile.isDirectory()))
      {
        j = i;
        if (localFile.canWrite()) {}
      }
      else
      {
        mMounts.remove(i);
        j = i - 1;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/StorageOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */