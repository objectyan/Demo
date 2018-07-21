package com.baidu.mapframework.common.util;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import com.baidu.platform.comapi.util.f;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public final class StorageSettings
{
  public static final String CACHE_FOLDER_NAME = "cache";
  public static final String DATA_FOLDER_NAME = "BaiduCarlife";
  private static volatile StorageSettings instance = null;
  private final List<StorageInformation> allStorages = new ArrayList();
  private StorageInformation currentStorage = new StorageInformation();
  private String deprecatedDataPath;
  private boolean hasExternalStoragePermission = true;
  private boolean initialized = false;
  private boolean isExternalStorageEnabled = true;
  
  @SuppressLint({"NewApi"})
  @TargetApi(14)
  private void getAllStoragesV14(Context paramContext)
  {
    Object localObject2;
    Object localObject1;
    Object localObject3;
    int k;
    int i;
    Object localObject5;
    int j;
    label199:
    Object localObject6;
    boolean bool;
    try
    {
      localObject2 = (StorageManager)paramContext.getSystemService("storage");
      localObject1 = localObject2.getClass().getMethod("getVolumeList", new Class[0]);
      localObject3 = localObject2.getClass().getMethod("getVolumeState", new Class[] { String.class });
      Object localObject4 = Class.forName("android.os.storage.StorageVolume");
      Method localMethod = ((Class)localObject4).getMethod("isRemovable", new Class[0]);
      localObject4 = ((Class)localObject4).getMethod("getPath", new Class[0]);
      Object[] arrayOfObject = (Object[])((Method)localObject1).invoke(localObject2, new Object[0]);
      if (arrayOfObject != null)
      {
        k = arrayOfObject.length;
        i = 0;
        if (i >= k) {
          break label448;
        }
        localObject1 = arrayOfObject[i];
        localObject5 = (String)((Method)localObject4).invoke(localObject1, new Object[0]);
        if ((localObject5 == null) || (((String)localObject5).length() <= 0)) {
          break label630;
        }
        if (!"mounted".equals(((Method)localObject3).invoke(localObject2, new Object[] { localObject5 }))) {
          break label630;
        }
        if (((Boolean)localMethod.invoke(localObject1, new Object[0])).booleanValue()) {
          break label637;
        }
        j = 1;
        if (((Build.VERSION.SDK_INT <= 19) || (j != 0)) && (isWritable((String)localObject5)))
        {
          localObject6 = this.allStorages;
          if (j != 0) {
            break label642;
          }
          bool = true;
          break label619;
          label236:
          ((List)localObject6).add(new StorageInformation((String)localObject5, bool, (String)localObject1));
          break label630;
        }
        if (Build.VERSION.SDK_INT < 19) {
          break label630;
        }
        localObject6 = (String)localObject5 + "/Android/data/com.baidu.carlife/files";
        if ((!new File((String)localObject5 + File.separator + "BaiduCarlife").exists()) || (!((String)localObject5).equals(paramContext.getSharedPreferences("map_pref", 0).getString("PREFFERED_SD_CARD", "")))) {
          break label399;
        }
        this.deprecatedDataPath = ((String)localObject5 + File.separator + "BaiduCarlife");
      }
    }
    catch (Exception paramContext)
    {
      f.a(StorageSettings.class.getSimpleName(), "exception", paramContext);
    }
    label398:
    return;
    label399:
    if (isWritable((String)localObject6))
    {
      localObject5 = this.allStorages;
      if (j != 0) {
        break label666;
      }
      bool = true;
    }
    for (;;)
    {
      ((List)localObject5).add(new StorageInformation((String)localObject6, bool, (String)localObject1));
      break label630;
      label448:
      if (Build.VERSION.SDK_INT < 19) {
        break label398;
      }
      paramContext = paramContext.getExternalFilesDirs(null);
      localObject1 = new ArrayList();
      ((List)localObject1).addAll(this.allStorages);
      i = 0;
      for (;;)
      {
        if ((i >= paramContext.length) || (paramContext[i] == null))
        {
          this.allStorages.clear();
          this.allStorages.addAll((Collection)localObject1);
          return;
        }
        localObject2 = paramContext[i].getAbsolutePath();
        k = 0;
        localObject3 = this.allStorages.iterator();
        do
        {
          j = k;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
        } while (!((String)localObject2).startsWith(((StorageInformation)((Iterator)localObject3).next()).getRootPath()));
        j = 1;
        if ((j == 0) && (((String)localObject2).indexOf("com.baidu.carlife") != -1)) {
          ((List)localObject1).add(new StorageInformation((String)localObject2, true, "外置存储卡"));
        }
        i += 1;
      }
      for (;;)
      {
        label619:
        if (j == 0) {
          break label648;
        }
        localObject1 = "内置存储卡";
        break label236;
        label630:
        i += 1;
        break;
        label637:
        j = 0;
        break label199;
        label642:
        bool = false;
      }
      label648:
      localObject1 = "外置存储卡";
      break label236;
      for (;;)
      {
        if (j == 0) {
          break label672;
        }
        localObject1 = "内置存储卡";
        break;
        label666:
        bool = false;
      }
      label672:
      localObject1 = "外置存储卡";
    }
  }
  
  /* Error */
  private void getAllStoragesV7(Context paramContext)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: new 44	java/util/ArrayList
    //   8: dup
    //   9: invokespecial 45	java/util/ArrayList:<init>	()V
    //   12: astore 7
    //   14: new 44	java/util/ArrayList
    //   17: dup
    //   18: invokespecial 45	java/util/ArrayList:<init>	()V
    //   21: astore 6
    //   23: aload_3
    //   24: astore_1
    //   25: aload 4
    //   27: astore_2
    //   28: new 156	java/io/File
    //   31: dup
    //   32: ldc -15
    //   34: invokespecial 162	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore 5
    //   39: aload_3
    //   40: astore_1
    //   41: aload 4
    //   43: astore_2
    //   44: aload 5
    //   46: invokevirtual 165	java/io/File:exists	()Z
    //   49: ifeq +561 -> 610
    //   52: aload_3
    //   53: astore_1
    //   54: aload 4
    //   56: astore_2
    //   57: new 243	java/util/Scanner
    //   60: dup
    //   61: aload 5
    //   63: invokespecial 246	java/util/Scanner:<init>	(Ljava/io/File;)V
    //   66: astore_3
    //   67: aload_3
    //   68: astore_1
    //   69: aload_3
    //   70: astore_2
    //   71: aload_3
    //   72: invokevirtual 247	java/util/Scanner:hasNext	()Z
    //   75: ifeq +107 -> 182
    //   78: aload_3
    //   79: astore_1
    //   80: aload_3
    //   81: astore_2
    //   82: aload_3
    //   83: invokevirtual 250	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   86: astore 4
    //   88: aload_3
    //   89: astore_1
    //   90: aload_3
    //   91: astore_2
    //   92: aload 4
    //   94: ldc -4
    //   96: invokevirtual 227	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   99: ifeq -32 -> 67
    //   102: aload_3
    //   103: astore_1
    //   104: aload_3
    //   105: astore_2
    //   106: aload 4
    //   108: bipush 9
    //   110: bipush 32
    //   112: invokevirtual 256	java/lang/String:replace	(CC)Ljava/lang/String;
    //   115: ldc_w 258
    //   118: invokevirtual 262	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   121: astore 4
    //   123: aload 4
    //   125: ifnull -58 -> 67
    //   128: aload_3
    //   129: astore_1
    //   130: aload_3
    //   131: astore_2
    //   132: aload 4
    //   134: arraylength
    //   135: ifle -68 -> 67
    //   138: aload_3
    //   139: astore_1
    //   140: aload_3
    //   141: astore_2
    //   142: aload 7
    //   144: aload 4
    //   146: iconst_1
    //   147: aaload
    //   148: invokeinterface 141 2 0
    //   153: pop
    //   154: goto -87 -> 67
    //   157: astore_3
    //   158: aload_1
    //   159: astore_2
    //   160: aload_2
    //   161: astore_1
    //   162: ldc 2
    //   164: invokevirtual 186	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   167: ldc -68
    //   169: aload_3
    //   170: invokestatic 194	com/baidu/platform/comapi/util/f:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   173: aload_2
    //   174: ifnull +7 -> 181
    //   177: aload_2
    //   178: invokevirtual 265	java/util/Scanner:close	()V
    //   181: return
    //   182: aload_3
    //   183: astore_1
    //   184: aload_3
    //   185: astore_2
    //   186: aload_3
    //   187: invokevirtual 265	java/util/Scanner:close	()V
    //   190: aconst_null
    //   191: astore 4
    //   193: aconst_null
    //   194: astore_3
    //   195: aload_3
    //   196: astore_1
    //   197: aload 4
    //   199: astore_2
    //   200: new 156	java/io/File
    //   203: dup
    //   204: ldc_w 267
    //   207: invokespecial 162	java/io/File:<init>	(Ljava/lang/String;)V
    //   210: astore 5
    //   212: aload_3
    //   213: astore_1
    //   214: aload 4
    //   216: astore_2
    //   217: aload 5
    //   219: invokevirtual 165	java/io/File:exists	()Z
    //   222: ifeq +383 -> 605
    //   225: aload_3
    //   226: astore_1
    //   227: aload 4
    //   229: astore_2
    //   230: new 243	java/util/Scanner
    //   233: dup
    //   234: aload 5
    //   236: invokespecial 246	java/util/Scanner:<init>	(Ljava/io/File;)V
    //   239: astore_3
    //   240: aload_3
    //   241: astore_1
    //   242: aload_3
    //   243: astore_2
    //   244: aload_3
    //   245: invokevirtual 247	java/util/Scanner:hasNext	()Z
    //   248: ifeq +126 -> 374
    //   251: aload_3
    //   252: astore_1
    //   253: aload_3
    //   254: astore_2
    //   255: aload_3
    //   256: invokevirtual 250	java/util/Scanner:nextLine	()Ljava/lang/String;
    //   259: astore 4
    //   261: aload_3
    //   262: astore_1
    //   263: aload_3
    //   264: astore_2
    //   265: aload 4
    //   267: ldc_w 269
    //   270: invokevirtual 227	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   273: ifeq -33 -> 240
    //   276: aload_3
    //   277: astore_1
    //   278: aload_3
    //   279: astore_2
    //   280: aload 4
    //   282: bipush 9
    //   284: bipush 32
    //   286: invokevirtual 256	java/lang/String:replace	(CC)Ljava/lang/String;
    //   289: ldc_w 258
    //   292: invokevirtual 262	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   295: astore 4
    //   297: aload 4
    //   299: ifnull -59 -> 240
    //   302: aload_3
    //   303: astore_1
    //   304: aload_3
    //   305: astore_2
    //   306: aload 4
    //   308: arraylength
    //   309: ifle -69 -> 240
    //   312: aload 4
    //   314: iconst_2
    //   315: aaload
    //   316: astore 5
    //   318: aload 5
    //   320: astore 4
    //   322: aload_3
    //   323: astore_1
    //   324: aload_3
    //   325: astore_2
    //   326: aload 5
    //   328: ldc_w 271
    //   331: invokevirtual 275	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   334: ifeq +23 -> 357
    //   337: aload_3
    //   338: astore_1
    //   339: aload_3
    //   340: astore_2
    //   341: aload 5
    //   343: iconst_0
    //   344: aload 5
    //   346: ldc_w 271
    //   349: invokevirtual 233	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   352: invokevirtual 279	java/lang/String:substring	(II)Ljava/lang/String;
    //   355: astore 4
    //   357: aload_3
    //   358: astore_1
    //   359: aload_3
    //   360: astore_2
    //   361: aload 6
    //   363: aload 4
    //   365: invokeinterface 141 2 0
    //   370: pop
    //   371: goto -131 -> 240
    //   374: aload_3
    //   375: astore_1
    //   376: aload_3
    //   377: astore_2
    //   378: aload_3
    //   379: invokevirtual 265	java/util/Scanner:close	()V
    //   382: aconst_null
    //   383: astore_3
    //   384: aload_3
    //   385: astore_1
    //   386: aload_3
    //   387: astore_2
    //   388: invokestatic 285	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   391: invokevirtual 208	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   394: astore 4
    //   396: aload_3
    //   397: astore_1
    //   398: aload_3
    //   399: astore_2
    //   400: aload_0
    //   401: getfield 47	com/baidu/mapframework/common/util/StorageSettings:allStorages	Ljava/util/List;
    //   404: new 49	com/baidu/mapframework/common/util/StorageInformation
    //   407: dup
    //   408: aload 4
    //   410: iconst_0
    //   411: ldc_w 287
    //   414: invokespecial 136	com/baidu/mapframework/common/util/StorageInformation:<init>	(Ljava/lang/String;ZLjava/lang/String;)V
    //   417: invokeinterface 141 2 0
    //   422: pop
    //   423: aload_3
    //   424: astore_1
    //   425: aload_3
    //   426: astore_2
    //   427: aload 7
    //   429: invokeinterface 212 1 0
    //   434: astore 5
    //   436: aload_3
    //   437: astore_1
    //   438: aload_3
    //   439: astore_2
    //   440: aload 5
    //   442: invokeinterface 217 1 0
    //   447: ifeq +141 -> 588
    //   450: aload_3
    //   451: astore_1
    //   452: aload_3
    //   453: astore_2
    //   454: aload 5
    //   456: invokeinterface 221 1 0
    //   461: checkcast 89	java/lang/String
    //   464: astore 7
    //   466: aload_3
    //   467: astore_1
    //   468: aload_3
    //   469: astore_2
    //   470: aload 6
    //   472: aload 7
    //   474: invokeinterface 289 2 0
    //   479: ifeq -43 -> 436
    //   482: aload_3
    //   483: astore_1
    //   484: aload_3
    //   485: astore_2
    //   486: aload 7
    //   488: aload 4
    //   490: invokevirtual 117	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   493: ifne -57 -> 436
    //   496: aload_3
    //   497: astore_1
    //   498: aload_3
    //   499: astore_2
    //   500: new 156	java/io/File
    //   503: dup
    //   504: aload 7
    //   506: invokespecial 162	java/io/File:<init>	(Ljava/lang/String;)V
    //   509: astore 8
    //   511: aload_3
    //   512: astore_1
    //   513: aload_3
    //   514: astore_2
    //   515: aload 8
    //   517: invokevirtual 165	java/io/File:exists	()Z
    //   520: ifeq -84 -> 436
    //   523: aload_3
    //   524: astore_1
    //   525: aload_3
    //   526: astore_2
    //   527: aload 8
    //   529: invokevirtual 292	java/io/File:isDirectory	()Z
    //   532: ifeq -96 -> 436
    //   535: aload_3
    //   536: astore_1
    //   537: aload_3
    //   538: astore_2
    //   539: aload 8
    //   541: invokevirtual 295	java/io/File:canWrite	()Z
    //   544: ifeq -108 -> 436
    //   547: aload_3
    //   548: astore_1
    //   549: aload_3
    //   550: astore_2
    //   551: aload_0
    //   552: getfield 47	com/baidu/mapframework/common/util/StorageSettings:allStorages	Ljava/util/List;
    //   555: new 49	com/baidu/mapframework/common/util/StorageInformation
    //   558: dup
    //   559: aload 7
    //   561: iconst_0
    //   562: ldc_w 287
    //   565: invokespecial 136	com/baidu/mapframework/common/util/StorageInformation:<init>	(Ljava/lang/String;ZLjava/lang/String;)V
    //   568: invokeinterface 141 2 0
    //   573: pop
    //   574: goto -138 -> 436
    //   577: astore_2
    //   578: aload_1
    //   579: ifnull +7 -> 586
    //   582: aload_1
    //   583: invokevirtual 265	java/util/Scanner:close	()V
    //   586: aload_2
    //   587: athrow
    //   588: aload_3
    //   589: ifnull -408 -> 181
    //   592: aload_3
    //   593: invokevirtual 265	java/util/Scanner:close	()V
    //   596: return
    //   597: astore_3
    //   598: aload_2
    //   599: astore_1
    //   600: aload_3
    //   601: astore_2
    //   602: goto -24 -> 578
    //   605: aconst_null
    //   606: astore_3
    //   607: goto -223 -> 384
    //   610: goto -420 -> 190
    //   613: astore_3
    //   614: goto -454 -> 160
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	617	0	this	StorageSettings
    //   0	617	1	paramContext	Context
    //   27	524	2	localObject1	Object
    //   577	22	2	localObject2	Object
    //   601	1	2	localObject3	Object
    //   4	137	3	localScanner1	java.util.Scanner
    //   157	30	3	localException1	Exception
    //   194	399	3	localScanner2	java.util.Scanner
    //   597	4	3	localObject4	Object
    //   606	1	3	localObject5	Object
    //   613	1	3	localException2	Exception
    //   1	488	4	localObject6	Object
    //   37	418	5	localObject7	Object
    //   21	450	6	localArrayList	ArrayList
    //   12	548	7	localObject8	Object
    //   509	31	8	localFile	File
    // Exception table:
    //   from	to	target	type
    //   71	78	157	java/lang/Exception
    //   82	88	157	java/lang/Exception
    //   92	102	157	java/lang/Exception
    //   106	123	157	java/lang/Exception
    //   132	138	157	java/lang/Exception
    //   142	154	157	java/lang/Exception
    //   186	190	157	java/lang/Exception
    //   200	212	157	java/lang/Exception
    //   217	225	157	java/lang/Exception
    //   230	240	157	java/lang/Exception
    //   28	39	577	finally
    //   44	52	577	finally
    //   57	67	577	finally
    //   162	173	577	finally
    //   244	251	577	finally
    //   255	261	577	finally
    //   265	276	577	finally
    //   280	297	577	finally
    //   306	312	577	finally
    //   326	337	577	finally
    //   341	357	577	finally
    //   361	371	577	finally
    //   378	382	577	finally
    //   388	396	577	finally
    //   400	423	577	finally
    //   427	436	577	finally
    //   440	450	577	finally
    //   454	466	577	finally
    //   470	482	577	finally
    //   486	496	577	finally
    //   500	511	577	finally
    //   515	523	577	finally
    //   527	535	577	finally
    //   539	547	577	finally
    //   551	574	577	finally
    //   71	78	597	finally
    //   82	88	597	finally
    //   92	102	597	finally
    //   106	123	597	finally
    //   132	138	597	finally
    //   142	154	597	finally
    //   186	190	597	finally
    //   200	212	597	finally
    //   217	225	597	finally
    //   230	240	597	finally
    //   28	39	613	java/lang/Exception
    //   44	52	613	java/lang/Exception
    //   57	67	613	java/lang/Exception
    //   244	251	613	java/lang/Exception
    //   255	261	613	java/lang/Exception
    //   265	276	613	java/lang/Exception
    //   280	297	613	java/lang/Exception
    //   306	312	613	java/lang/Exception
    //   326	337	613	java/lang/Exception
    //   341	357	613	java/lang/Exception
    //   361	371	613	java/lang/Exception
    //   378	382	613	java/lang/Exception
    //   388	396	613	java/lang/Exception
    //   400	423	613	java/lang/Exception
    //   427	436	613	java/lang/Exception
    //   440	450	613	java/lang/Exception
    //   454	466	613	java/lang/Exception
    //   470	482	613	java/lang/Exception
    //   486	496	613	java/lang/Exception
    //   500	511	613	java/lang/Exception
    //   515	523	613	java/lang/Exception
    //   527	535	613	java/lang/Exception
    //   539	547	613	java/lang/Exception
    //   551	574	613	java/lang/Exception
  }
  
  public static StorageSettings getInstance()
  {
    return Holder.SETTING;
  }
  
  private boolean isWritable(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      File localFile = new File(paramString);
      bool1 = bool2;
      if (!localFile.exists())
      {
        bool1 = bool2;
        localFile.mkdirs();
      }
      bool1 = bool2;
      paramString = new File(paramString + "/test.0");
      bool1 = bool2;
      if (paramString.exists())
      {
        bool1 = bool2;
        paramString.delete();
      }
      bool1 = bool2;
      bool2 = paramString.createNewFile();
      bool1 = bool2;
      if (paramString.exists())
      {
        bool1 = bool2;
        paramString.delete();
      }
      return bool2;
    }
    catch (Exception paramString)
    {
      f.a(StorageSettings.class.getSimpleName(), "exception", paramString);
    }
    return bool1;
  }
  
  public List<StorageInformation> getAllStorages()
  {
    return this.allStorages;
  }
  
  public StorageInformation getCurrentStorage()
  {
    return this.currentStorage;
  }
  
  public String getDeprecatedDataPath()
  {
    return this.deprecatedDataPath;
  }
  
  public int getDomTmpStgMax()
  {
    return 52428800;
  }
  
  public int getItsTmpStgMax()
  {
    return 5242880;
  }
  
  public int getMapTmpStgMax()
  {
    return 20971520;
  }
  
  public StorageInformation getPreferredStorage(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("map_pref", 0).getString("PREFFERED_SD_CARD", "");
    if (!TextUtils.isEmpty(paramContext))
    {
      Iterator localIterator = this.allStorages.iterator();
      while (localIterator.hasNext())
      {
        StorageInformation localStorageInformation = (StorageInformation)localIterator.next();
        if (localStorageInformation.getRootPath().equals(paramContext)) {
          return localStorageInformation;
        }
        if ((paramContext.indexOf("com.baidu.carlife") != -1) && (localStorageInformation.getRootPath().equals(paramContext.replace("/files", "")))) {
          return new StorageInformation(true, paramContext);
        }
      }
      return new StorageInformation(false, paramContext);
    }
    return null;
  }
  
  public int getSsgTmpStgMax()
  {
    return 52428800;
  }
  
  /* Error */
  public void initialize(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/baidu/mapframework/common/util/StorageSettings:initialized	Z
    //   6: istore 4
    //   8: iload 4
    //   10: ifeq +6 -> 16
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: aload_0
    //   17: iconst_1
    //   18: putfield 38	com/baidu/mapframework/common/util/StorageSettings:initialized	Z
    //   21: getstatic 129	android/os/Build$VERSION:SDK_INT	I
    //   24: bipush 14
    //   26: if_icmplt +91 -> 117
    //   29: aload_0
    //   30: aload_1
    //   31: invokespecial 343	com/baidu/mapframework/common/util/StorageSettings:getAllStoragesV14	(Landroid/content/Context;)V
    //   34: aload_0
    //   35: getfield 47	com/baidu/mapframework/common/util/StorageSettings:allStorages	Ljava/util/List;
    //   38: invokeinterface 346 1 0
    //   43: ifle +255 -> 298
    //   46: aconst_null
    //   47: astore 5
    //   49: iconst_0
    //   50: istore_2
    //   51: aload_0
    //   52: getfield 47	com/baidu/mapframework/common/util/StorageSettings:allStorages	Ljava/util/List;
    //   55: invokeinterface 212 1 0
    //   60: astore 7
    //   62: aload 7
    //   64: invokeinterface 217 1 0
    //   69: ifeq +78 -> 147
    //   72: aload 7
    //   74: invokeinterface 221 1 0
    //   79: checkcast 49	com/baidu/mapframework/common/util/StorageInformation
    //   82: astore 6
    //   84: new 156	java/io/File
    //   87: dup
    //   88: aload 6
    //   90: invokevirtual 349	com/baidu/mapframework/common/util/StorageInformation:getDataPath	()Ljava/lang/String;
    //   93: invokespecial 162	java/io/File:<init>	(Ljava/lang/String;)V
    //   96: invokevirtual 165	java/io/File:exists	()Z
    //   99: istore 4
    //   101: iload 4
    //   103: ifeq -41 -> 62
    //   106: iload_2
    //   107: iconst_1
    //   108: iadd
    //   109: istore_2
    //   110: aload 6
    //   112: astore 5
    //   114: goto -52 -> 62
    //   117: aload_0
    //   118: aload_1
    //   119: invokespecial 351	com/baidu/mapframework/common/util/StorageSettings:getAllStoragesV7	(Landroid/content/Context;)V
    //   122: goto -88 -> 34
    //   125: astore 5
    //   127: ldc 2
    //   129: invokevirtual 186	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   132: ldc -68
    //   134: aload 5
    //   136: invokestatic 194	com/baidu/platform/comapi/util/f:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   139: goto -105 -> 34
    //   142: astore_1
    //   143: aload_0
    //   144: monitorexit
    //   145: aload_1
    //   146: athrow
    //   147: iconst_0
    //   148: istore_3
    //   149: aload_0
    //   150: aload_0
    //   151: aload_1
    //   152: invokevirtual 353	com/baidu/mapframework/common/util/StorageSettings:getPreferredStorage	(Landroid/content/Context;)Lcom/baidu/mapframework/common/util/StorageInformation;
    //   155: putfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   158: aload_0
    //   159: getfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   162: ifnonnull +5 -> 167
    //   165: iconst_1
    //   166: istore_3
    //   167: iload_2
    //   168: ifne +309 -> 477
    //   171: aload_0
    //   172: getfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   175: ifnull +13 -> 188
    //   178: aload_0
    //   179: getfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   182: invokevirtual 356	com/baidu/mapframework/common/util/StorageInformation:isEnable	()Z
    //   185: ifne +51 -> 236
    //   188: aload_0
    //   189: getfield 47	com/baidu/mapframework/common/util/StorageSettings:allStorages	Ljava/util/List;
    //   192: invokeinterface 212 1 0
    //   197: astore_1
    //   198: aload_1
    //   199: invokeinterface 217 1 0
    //   204: ifeq +32 -> 236
    //   207: aload_1
    //   208: invokeinterface 221 1 0
    //   213: checkcast 49	com/baidu/mapframework/common/util/StorageInformation
    //   216: astore 5
    //   218: aload_0
    //   219: aload 5
    //   221: invokevirtual 224	com/baidu/mapframework/common/util/StorageInformation:getRootPath	()Ljava/lang/String;
    //   224: invokespecial 133	com/baidu/mapframework/common/util/StorageSettings:isWritable	(Ljava/lang/String;)Z
    //   227: ifeq -29 -> 198
    //   230: aload_0
    //   231: aload 5
    //   233: putfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   236: aload_0
    //   237: getfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   240: ifnull +13 -> 253
    //   243: aload_0
    //   244: getfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   247: invokevirtual 356	com/baidu/mapframework/common/util/StorageInformation:isEnable	()Z
    //   250: ifne +20 -> 270
    //   253: aload_0
    //   254: aload_0
    //   255: getfield 47	com/baidu/mapframework/common/util/StorageSettings:allStorages	Ljava/util/List;
    //   258: iconst_0
    //   259: invokeinterface 360 2 0
    //   264: checkcast 49	com/baidu/mapframework/common/util/StorageInformation
    //   267: putfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   270: iload_3
    //   271: ifeq +27 -> 298
    //   274: aload_0
    //   275: getfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   278: ifnull +20 -> 298
    //   281: iload_2
    //   282: iconst_2
    //   283: if_icmpge +15 -> 298
    //   286: aload_0
    //   287: invokestatic 366	com/baidu/platform/comapi/c:f	()Landroid/content/Context;
    //   290: aload_0
    //   291: getfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   294: invokevirtual 370	com/baidu/mapframework/common/util/StorageSettings:setPreferredStorage	(Landroid/content/Context;Lcom/baidu/mapframework/common/util/StorageInformation;)Z
    //   297: pop
    //   298: aload_0
    //   299: getfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   302: ifnull +221 -> 523
    //   305: aload_0
    //   306: getfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   309: invokevirtual 356	com/baidu/mapframework/common/util/StorageInformation:isEnable	()Z
    //   312: ifeq +211 -> 523
    //   315: aload_0
    //   316: aload_0
    //   317: getfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   320: invokevirtual 224	com/baidu/mapframework/common/util/StorageInformation:getRootPath	()Ljava/lang/String;
    //   323: invokespecial 133	com/baidu/mapframework/common/util/StorageSettings:isWritable	(Ljava/lang/String;)Z
    //   326: ifeq +197 -> 523
    //   329: new 156	java/io/File
    //   332: dup
    //   333: aload_0
    //   334: getfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   337: invokevirtual 349	com/baidu/mapframework/common/util/StorageInformation:getDataPath	()Ljava/lang/String;
    //   340: invokespecial 162	java/io/File:<init>	(Ljava/lang/String;)V
    //   343: astore_1
    //   344: aload_1
    //   345: invokevirtual 165	java/io/File:exists	()Z
    //   348: ifne +8 -> 356
    //   351: aload_1
    //   352: invokevirtual 303	java/io/File:mkdirs	()Z
    //   355: pop
    //   356: new 156	java/io/File
    //   359: dup
    //   360: aload_0
    //   361: getfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   364: invokevirtual 373	com/baidu/mapframework/common/util/StorageInformation:getPrimaryCachePath	()Ljava/lang/String;
    //   367: invokespecial 162	java/io/File:<init>	(Ljava/lang/String;)V
    //   370: astore_1
    //   371: aload_1
    //   372: invokevirtual 165	java/io/File:exists	()Z
    //   375: ifne +8 -> 383
    //   378: aload_1
    //   379: invokevirtual 303	java/io/File:mkdirs	()Z
    //   382: pop
    //   383: new 156	java/io/File
    //   386: dup
    //   387: aload_1
    //   388: ldc_w 375
    //   391: invokespecial 378	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   394: astore_1
    //   395: aload_1
    //   396: invokevirtual 165	java/io/File:exists	()Z
    //   399: ifne +8 -> 407
    //   402: aload_1
    //   403: invokevirtual 311	java/io/File:createNewFile	()Z
    //   406: pop
    //   407: invokestatic 383	com/baidu/platform/comapi/util/SysOSAPIv2:getInstance	()Lcom/baidu/platform/comapi/util/SysOSAPIv2;
    //   410: aload_0
    //   411: getfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   414: invokevirtual 224	com/baidu/mapframework/common/util/StorageInformation:getRootPath	()Ljava/lang/String;
    //   417: invokevirtual 386	com/baidu/platform/comapi/util/SysOSAPIv2:setSdcardPath	(Ljava/lang/String;)V
    //   420: invokestatic 383	com/baidu/platform/comapi/util/SysOSAPIv2:getInstance	()Lcom/baidu/platform/comapi/util/SysOSAPIv2;
    //   423: aload_0
    //   424: getfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   427: invokevirtual 349	com/baidu/mapframework/common/util/StorageInformation:getDataPath	()Ljava/lang/String;
    //   430: invokevirtual 389	com/baidu/platform/comapi/util/SysOSAPIv2:setSdcardDataPath	(Ljava/lang/String;)V
    //   433: invokestatic 383	com/baidu/platform/comapi/util/SysOSAPIv2:getInstance	()Lcom/baidu/platform/comapi/util/SysOSAPIv2;
    //   436: aload_0
    //   437: getfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   440: invokevirtual 373	com/baidu/mapframework/common/util/StorageInformation:getPrimaryCachePath	()Ljava/lang/String;
    //   443: invokevirtual 392	com/baidu/platform/comapi/util/SysOSAPIv2:setOutputCache	(Ljava/lang/String;)V
    //   446: invokestatic 383	com/baidu/platform/comapi/util/SysOSAPIv2:getInstance	()Lcom/baidu/platform/comapi/util/SysOSAPIv2;
    //   449: aload_0
    //   450: getfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   453: invokevirtual 395	com/baidu/mapframework/common/util/StorageInformation:getSecondaryCachePath	()Ljava/lang/String;
    //   456: invokevirtual 398	com/baidu/platform/comapi/util/SysOSAPIv2:setOutputSecondCache	(Ljava/lang/String;)V
    //   459: goto -446 -> 13
    //   462: astore_1
    //   463: ldc 2
    //   465: invokevirtual 186	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   468: ldc -68
    //   470: aload_1
    //   471: invokestatic 194	com/baidu/platform/comapi/util/f:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   474: goto -461 -> 13
    //   477: iload_2
    //   478: iconst_1
    //   479: if_icmpne -243 -> 236
    //   482: aload_0
    //   483: getfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   486: ifnull +13 -> 499
    //   489: aload_0
    //   490: getfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   493: invokevirtual 356	com/baidu/mapframework/common/util/StorageInformation:isEnable	()Z
    //   496: ifne -260 -> 236
    //   499: aload_0
    //   500: aload 5
    //   502: putfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   505: goto -269 -> 236
    //   508: astore_1
    //   509: ldc 2
    //   511: invokevirtual 186	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   514: ldc -68
    //   516: aload_1
    //   517: invokestatic 194	com/baidu/platform/comapi/util/f:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   520: goto -222 -> 298
    //   523: aload_0
    //   524: iconst_0
    //   525: putfield 42	com/baidu/mapframework/common/util/StorageSettings:isExternalStorageEnabled	Z
    //   528: aload_0
    //   529: new 49	com/baidu/mapframework/common/util/StorageInformation
    //   532: dup
    //   533: invokespecial 50	com/baidu/mapframework/common/util/StorageInformation:<init>	()V
    //   536: putfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   539: aload_0
    //   540: getfield 47	com/baidu/mapframework/common/util/StorageSettings:allStorages	Ljava/util/List;
    //   543: invokeinterface 205 1 0
    //   548: aload_0
    //   549: getfield 47	com/baidu/mapframework/common/util/StorageSettings:allStorages	Ljava/util/List;
    //   552: aload_0
    //   553: getfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   556: invokeinterface 141 2 0
    //   561: pop
    //   562: invokestatic 383	com/baidu/platform/comapi/util/SysOSAPIv2:getInstance	()Lcom/baidu/platform/comapi/util/SysOSAPIv2;
    //   565: aload_0
    //   566: getfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   569: invokevirtual 224	com/baidu/mapframework/common/util/StorageInformation:getRootPath	()Ljava/lang/String;
    //   572: invokevirtual 386	com/baidu/platform/comapi/util/SysOSAPIv2:setSdcardPath	(Ljava/lang/String;)V
    //   575: invokestatic 383	com/baidu/platform/comapi/util/SysOSAPIv2:getInstance	()Lcom/baidu/platform/comapi/util/SysOSAPIv2;
    //   578: aload_0
    //   579: getfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   582: invokevirtual 349	com/baidu/mapframework/common/util/StorageInformation:getDataPath	()Ljava/lang/String;
    //   585: invokevirtual 389	com/baidu/platform/comapi/util/SysOSAPIv2:setSdcardDataPath	(Ljava/lang/String;)V
    //   588: invokestatic 383	com/baidu/platform/comapi/util/SysOSAPIv2:getInstance	()Lcom/baidu/platform/comapi/util/SysOSAPIv2;
    //   591: aload_0
    //   592: getfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   595: invokevirtual 373	com/baidu/mapframework/common/util/StorageInformation:getPrimaryCachePath	()Ljava/lang/String;
    //   598: invokevirtual 392	com/baidu/platform/comapi/util/SysOSAPIv2:setOutputCache	(Ljava/lang/String;)V
    //   601: invokestatic 383	com/baidu/platform/comapi/util/SysOSAPIv2:getInstance	()Lcom/baidu/platform/comapi/util/SysOSAPIv2;
    //   604: aload_0
    //   605: getfield 52	com/baidu/mapframework/common/util/StorageSettings:currentStorage	Lcom/baidu/mapframework/common/util/StorageInformation;
    //   608: invokevirtual 395	com/baidu/mapframework/common/util/StorageInformation:getSecondaryCachePath	()Ljava/lang/String;
    //   611: invokevirtual 398	com/baidu/platform/comapi/util/SysOSAPIv2:setOutputSecondCache	(Ljava/lang/String;)V
    //   614: goto -601 -> 13
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	617	0	this	StorageSettings
    //   0	617	1	paramContext	Context
    //   50	430	2	i	int
    //   148	123	3	j	int
    //   6	96	4	bool	boolean
    //   47	66	5	localObject	Object
    //   125	10	5	localException	Exception
    //   216	285	5	localStorageInformation1	StorageInformation
    //   82	29	6	localStorageInformation2	StorageInformation
    //   60	13	7	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   21	34	125	java/lang/Exception
    //   117	122	125	java/lang/Exception
    //   2	8	142	finally
    //   16	21	142	finally
    //   21	34	142	finally
    //   34	46	142	finally
    //   51	62	142	finally
    //   62	101	142	finally
    //   117	122	142	finally
    //   127	139	142	finally
    //   149	158	142	finally
    //   158	165	142	finally
    //   171	188	142	finally
    //   188	198	142	finally
    //   198	236	142	finally
    //   236	253	142	finally
    //   253	270	142	finally
    //   274	281	142	finally
    //   286	298	142	finally
    //   298	356	142	finally
    //   356	383	142	finally
    //   383	407	142	finally
    //   407	459	142	finally
    //   463	474	142	finally
    //   482	499	142	finally
    //   499	505	142	finally
    //   509	520	142	finally
    //   523	614	142	finally
    //   298	356	462	java/lang/Exception
    //   356	383	462	java/lang/Exception
    //   383	407	462	java/lang/Exception
    //   407	459	462	java/lang/Exception
    //   523	614	462	java/lang/Exception
    //   34	46	508	java/lang/Exception
    //   51	62	508	java/lang/Exception
    //   62	101	508	java/lang/Exception
    //   149	158	508	java/lang/Exception
    //   158	165	508	java/lang/Exception
    //   171	188	508	java/lang/Exception
    //   188	198	508	java/lang/Exception
    //   198	236	508	java/lang/Exception
    //   236	253	508	java/lang/Exception
    //   253	270	508	java/lang/Exception
    //   274	281	508	java/lang/Exception
    //   286	298	508	java/lang/Exception
    //   482	499	508	java/lang/Exception
    //   499	505	508	java/lang/Exception
  }
  
  public boolean isExternalStorageEnabled()
  {
    return this.isExternalStorageEnabled;
  }
  
  public boolean isHasExternalStoragePermission()
  {
    return this.hasExternalStoragePermission;
  }
  
  public void reInitialize(Context paramContext)
  {
    try
    {
      this.initialized = false;
      this.currentStorage = new StorageInformation();
      this.allStorages.clear();
      initialize(paramContext);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void setHasExternalStoragePermission(boolean paramBoolean)
  {
    this.hasExternalStoragePermission = paramBoolean;
  }
  
  public boolean setPreferredStorage(Context paramContext, StorageInformation paramStorageInformation)
  {
    paramStorageInformation = paramStorageInformation.getRootPath();
    if (!isWritable(paramStorageInformation)) {
      return false;
    }
    paramContext = paramContext.getSharedPreferences("map_pref", 0).edit();
    paramContext.putString("PREFFERED_SD_CARD", paramStorageInformation);
    return paramContext.commit();
  }
  
  private static class Holder
  {
    private static final StorageSettings SETTING = new StorageSettings(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/mapframework/common/util/StorageSettings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */