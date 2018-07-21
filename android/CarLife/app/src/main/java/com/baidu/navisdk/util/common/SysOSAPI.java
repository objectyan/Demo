package com.baidu.navisdk.util.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.jar.JarUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Arrays;
import org.json.JSONObject;

@SuppressLint({"NewApi"})
public class SysOSAPI
{
  public static final String CFG_FOLDER = "/nmap";
  private static final int K_MAP_RES_CONFIG_NORMAL = 1;
  private static final int K_MAP_RES_CONFIG_SIMPLE = 2;
  public static String ROOT_FOLDER = "BaiduNavi";
  private static String mAppFolderName = null;
  private boolean inited = false;
  private String mAppCacheDir;
  private String mAppFilesDir;
  private String mAppResouceDir;
  private String mOfflineDataPath;
  private String mSDCardCachePath;
  private String mSDCardDataPath;
  private String mSDCardRootPath;
  String strGLRenderer = "";
  String strGLVersion = "";
  
  private SysOSAPI()
  {
    init();
  }
  
  private void ensureNoMediaFile(String paramString)
  {
    try
    {
      if (new File(paramString).exists())
      {
        paramString = new File(paramString + File.separator + ".nomedia");
        if (!paramString.exists()) {
          paramString.createNewFile();
        }
      }
      return;
    }
    catch (Throwable paramString) {}
  }
  
  private void ensureStorage(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  private static String[] getCopyFilelist()
  {
    if (getMapResConfig() == 2) {
      return new String[] { "cfg/MapRes.cfg" };
    }
    return new String[] { "cfg/MapRes.cfg", "cfg/h/DVDirectory.cfg", "cfg/h/DVHotcity.cfg", "cfg/h/DVVersion.cfg", "cfg/l/DVDirectory.cfg", "cfg/l/DVHotcity.cfg", "cfg/l/DVVersion.cfg", "cfg/h/DVStreet.cfg", "cfg/l/DVStreet.cfg", "cfg/a/navicfgversion.cfg" };
  }
  
  public static SysOSAPI getInstance()
  {
    return LazyHolder.sInstance;
  }
  
  private static int getMapResConfig()
  {
    Object localObject = JarUtils.getResources().getAssets();
    try
    {
      localObject = ((AssetManager)localObject).open("cfg/MapRes.cfg");
      byte[] arrayOfByte = new byte[((InputStream)localObject).available()];
      ((InputStream)localObject).read(arrayOfByte);
      ((InputStream)localObject).close();
      int i = new JSONObject(new String(arrayOfByte)).getInt("type");
      return i;
    }
    catch (Exception localException)
    {
      LogUtil.e("", localException.toString());
    }
    return 1;
  }
  
  private void readAndCopyData(AssetManager paramAssetManager)
    throws Exception
  {
    Object localObject1 = new File(GetSDCardPath());
    if (!((File)localObject1).exists())
    {
      ((File)localObject1).mkdirs();
      LogUtil.e("SysOSAPI", " init root path");
    }
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new File(GetSDCardPath() + "/navi/pub");
        if (!((File)localObject1).exists()) {
          ((File)localObject1).mkdirs();
        }
        localObject1 = new String[4];
        localObject1[0] = "catalog.dat";
        localObject1[1] = "district.dat";
        localObject1[2] = "guidance_polyphone.dat";
        localObject1[3] = "rg.tpl";
        long l1 = PackageUtil.getApkUpdateTime();
        i = 0;
        if (i < localObject1.length)
        {
          Object localObject2 = paramAssetManager.open(localObject1[i]);
          long l2 = ((InputStream)localObject2).available();
          File localFile = new File(GetSDCardPath() + new String[] { "/navi/pub/catalog.dat", "/navi/pub/district.dat", "/navi/pub/guidance_polyphone.dat", "/navi/pub/rg.tpl" }[i]);
          if ((localFile.exists()) && (localFile.lastModified() > l1) && (l2 == localFile.length()))
          {
            ((InputStream)localObject2).close();
          }
          else
          {
            byte[] arrayOfByte = new byte[(int)l2];
            ((InputStream)localObject2).read(arrayOfByte);
            ((InputStream)localObject2).close();
            if (localFile.exists()) {
              localFile.delete();
            }
            localFile.createNewFile();
            localObject2 = new FileOutputStream(localFile);
            ((FileOutputStream)localObject2).write(arrayOfByte);
            ((FileOutputStream)localObject2).close();
          }
        }
      }
      catch (Exception paramAssetManager)
      {
        LogUtil.e("", paramAssetManager.toString());
      }
      return;
      i += 1;
    }
  }
  
  /* Error */
  private void readAndCopyDataCfg(AssetManager paramAssetManager)
    throws Exception
  {
    // Byte code:
    //   0: new 73	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   7: aload_0
    //   8: getfield 233	com/baidu/navisdk/util/common/SysOSAPI:mOfflineDataPath	Ljava/lang/String;
    //   11: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   14: ldc -21
    //   16: invokevirtual 78	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: invokevirtual 87	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   22: astore 11
    //   24: new 65	java/io/File
    //   27: dup
    //   28: aload 11
    //   30: invokespecial 67	java/io/File:<init>	(Ljava/lang/String;)V
    //   33: astore 16
    //   35: aconst_null
    //   36: astore 10
    //   38: aconst_null
    //   39: astore 12
    //   41: aconst_null
    //   42: astore 9
    //   44: aconst_null
    //   45: astore 13
    //   47: aconst_null
    //   48: astore 14
    //   50: aconst_null
    //   51: astore 15
    //   53: iconst_1
    //   54: istore 8
    //   56: iconst_1
    //   57: istore 4
    //   59: iconst_1
    //   60: istore 6
    //   62: iconst_0
    //   63: istore_3
    //   64: iconst_0
    //   65: istore 5
    //   67: iconst_0
    //   68: istore 7
    //   70: aload 16
    //   72: invokevirtual 71	java/io/File:exists	()Z
    //   75: ifeq +383 -> 458
    //   78: new 237	java/io/RandomAccessFile
    //   81: dup
    //   82: aload 11
    //   84: ldc -17
    //   86: invokespecial 241	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: astore 11
    //   91: aload 13
    //   93: astore 9
    //   95: aload 14
    //   97: astore 10
    //   99: bipush 24
    //   101: newarray <illegal type>
    //   103: astore 12
    //   105: aload 13
    //   107: astore 9
    //   109: aload 14
    //   111: astore 10
    //   113: aload 11
    //   115: aload 12
    //   117: iconst_0
    //   118: bipush 24
    //   120: invokevirtual 244	java/io/RandomAccessFile:read	([BII)I
    //   123: pop
    //   124: aload 13
    //   126: astore 9
    //   128: aload 14
    //   130: astore 10
    //   132: new 102	java/lang/String
    //   135: dup
    //   136: aload 12
    //   138: ldc -10
    //   140: invokespecial 249	java/lang/String:<init>	([BLjava/lang/String;)V
    //   143: astore 15
    //   145: aload 13
    //   147: astore 9
    //   149: aload 14
    //   151: astore 10
    //   153: aload 15
    //   155: ldc -5
    //   157: invokevirtual 254	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   160: istore_2
    //   161: aload 13
    //   163: astore 9
    //   165: aload 14
    //   167: astore 10
    //   169: aload 15
    //   171: ldc_w 256
    //   174: invokevirtual 254	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   177: istore 4
    //   179: aconst_null
    //   180: astore 12
    //   182: aload 13
    //   184: astore 9
    //   186: aload 14
    //   188: astore 10
    //   190: aload 15
    //   192: invokestatic 262	com/baidu/navisdk/util/common/StringUtils:isEmpty	(Ljava/lang/String;)Z
    //   195: ifne +23 -> 218
    //   198: aload 13
    //   200: astore 9
    //   202: aload 14
    //   204: astore 10
    //   206: aload 15
    //   208: iload_2
    //   209: iconst_1
    //   210: iadd
    //   211: iload 4
    //   213: invokevirtual 266	java/lang/String:substring	(II)Ljava/lang/String;
    //   216: astore 12
    //   218: iconst_m1
    //   219: istore_2
    //   220: aload 13
    //   222: astore 9
    //   224: aload 12
    //   226: invokestatic 262	com/baidu/navisdk/util/common/StringUtils:isEmpty	(Ljava/lang/String;)Z
    //   229: ifne +13 -> 242
    //   232: aload 13
    //   234: astore 9
    //   236: aload 12
    //   238: invokestatic 271	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   241: istore_2
    //   242: aload 13
    //   244: astore 9
    //   246: aload 14
    //   248: astore 10
    //   250: aload_1
    //   251: ldc_w 273
    //   254: invokevirtual 147	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   257: astore 12
    //   259: aload 12
    //   261: astore 9
    //   263: aload 12
    //   265: astore 10
    //   267: bipush 24
    //   269: newarray <illegal type>
    //   271: astore 13
    //   273: aload 12
    //   275: astore 9
    //   277: aload 12
    //   279: astore 10
    //   281: aload 12
    //   283: aload 13
    //   285: iconst_0
    //   286: bipush 24
    //   288: invokevirtual 274	java/io/InputStream:read	([BII)I
    //   291: pop
    //   292: aload 12
    //   294: astore 9
    //   296: aload 12
    //   298: astore 10
    //   300: new 102	java/lang/String
    //   303: dup
    //   304: aload 13
    //   306: ldc -10
    //   308: invokespecial 249	java/lang/String:<init>	([BLjava/lang/String;)V
    //   311: astore 14
    //   313: aload 12
    //   315: astore 9
    //   317: aload 12
    //   319: astore 10
    //   321: aload 14
    //   323: ldc -5
    //   325: invokevirtual 254	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   328: istore 4
    //   330: aload 12
    //   332: astore 9
    //   334: aload 12
    //   336: astore 10
    //   338: aload 14
    //   340: ldc_w 256
    //   343: invokevirtual 254	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   346: istore 5
    //   348: aconst_null
    //   349: astore 9
    //   351: aload 9
    //   353: astore 13
    //   355: aload 14
    //   357: ifnull +44 -> 401
    //   360: aload 9
    //   362: astore 13
    //   364: aload 12
    //   366: astore 9
    //   368: aload 12
    //   370: astore 10
    //   372: aload 14
    //   374: invokevirtual 276	java/lang/String:length	()I
    //   377: ifle +24 -> 401
    //   380: aload 12
    //   382: astore 9
    //   384: aload 12
    //   386: astore 10
    //   388: aload 14
    //   390: iload 4
    //   392: iconst_1
    //   393: iadd
    //   394: iload 5
    //   396: invokevirtual 266	java/lang/String:substring	(II)Ljava/lang/String;
    //   399: astore 13
    //   401: aload 12
    //   403: astore 9
    //   405: aload 13
    //   407: invokestatic 271	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   410: istore_3
    //   411: iload_2
    //   412: iload_3
    //   413: if_icmpne +120 -> 533
    //   416: iconst_0
    //   417: istore_2
    //   418: iload 7
    //   420: istore_3
    //   421: aload 11
    //   423: invokevirtual 277	java/io/RandomAccessFile:close	()V
    //   426: aload 12
    //   428: ifnull +8 -> 436
    //   431: aload 12
    //   433: invokevirtual 159	java/io/InputStream:close	()V
    //   436: iload_2
    //   437: istore 4
    //   439: iload_3
    //   440: istore 5
    //   442: iload_2
    //   443: ifeq +15 -> 458
    //   446: aload 16
    //   448: invokevirtual 220	java/io/File:delete	()Z
    //   451: pop
    //   452: iload_3
    //   453: istore 5
    //   455: iload_2
    //   456: istore 4
    //   458: iload 4
    //   460: ifeq +164 -> 624
    //   463: aload 16
    //   465: invokevirtual 90	java/io/File:createNewFile	()Z
    //   468: pop
    //   469: aload_1
    //   470: ldc_w 273
    //   473: invokevirtual 147	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   476: astore_1
    //   477: new 222	java/io/FileOutputStream
    //   480: dup
    //   481: aload 16
    //   483: invokespecial 225	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   486: astore 9
    //   488: sipush 10240
    //   491: newarray <illegal type>
    //   493: astore 10
    //   495: aload_1
    //   496: aload 10
    //   498: invokevirtual 156	java/io/InputStream:read	([B)I
    //   501: istore_2
    //   502: iload_2
    //   503: ifle +101 -> 604
    //   506: aload 9
    //   508: aload 10
    //   510: iconst_0
    //   511: iload_2
    //   512: invokevirtual 282	java/io/OutputStream:write	([BII)V
    //   515: goto -20 -> 495
    //   518: astore 9
    //   520: iconst_m1
    //   521: istore_2
    //   522: goto -280 -> 242
    //   525: astore 9
    //   527: bipush -2
    //   529: istore_3
    //   530: goto -119 -> 411
    //   533: iconst_1
    //   534: istore_3
    //   535: iload 6
    //   537: istore_2
    //   538: goto -117 -> 421
    //   541: astore 13
    //   543: aload 15
    //   545: astore 11
    //   547: aload 11
    //   549: astore 9
    //   551: aload 12
    //   553: astore 10
    //   555: ldc 48
    //   557: aload 13
    //   559: invokevirtual 172	java/lang/Exception:toString	()Ljava/lang/String;
    //   562: invokestatic 178	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   565: aload 12
    //   567: invokevirtual 277	java/io/RandomAccessFile:close	()V
    //   570: aload 11
    //   572: ifnull +8 -> 580
    //   575: aload 11
    //   577: invokevirtual 159	java/io/InputStream:close	()V
    //   580: iload 8
    //   582: istore_2
    //   583: goto -147 -> 436
    //   586: astore_1
    //   587: aload 10
    //   589: invokevirtual 277	java/io/RandomAccessFile:close	()V
    //   592: aload 9
    //   594: ifnull +8 -> 602
    //   597: aload 9
    //   599: invokevirtual 159	java/io/InputStream:close	()V
    //   602: aload_1
    //   603: athrow
    //   604: aload_1
    //   605: invokevirtual 159	java/io/InputStream:close	()V
    //   608: aload 9
    //   610: invokevirtual 283	java/io/OutputStream:close	()V
    //   613: iload 5
    //   615: ifeq +9 -> 624
    //   618: invokestatic 288	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:getInstance	()Lcom/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager;
    //   621: invokevirtual 291	com/baidu/navisdk/comapi/offlinedata/BNOfflineDataManager:checkDataVerNotMatch	()V
    //   624: return
    //   625: astore_1
    //   626: aload 11
    //   628: astore 10
    //   630: goto -43 -> 587
    //   633: astore 13
    //   635: aload 11
    //   637: astore 12
    //   639: aload 10
    //   641: astore 11
    //   643: goto -96 -> 547
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	646	0	this	SysOSAPI
    //   0	646	1	paramAssetManager	AssetManager
    //   160	423	2	i	int
    //   63	472	3	j	int
    //   57	402	4	k	int
    //   65	549	5	m	int
    //   60	476	6	n	int
    //   68	351	7	i1	int
    //   54	527	8	i2	int
    //   42	465	9	localObject1	Object
    //   518	1	9	localException1	Exception
    //   525	1	9	localException2	Exception
    //   549	60	9	localObject2	Object
    //   36	604	10	localObject3	Object
    //   22	620	11	localObject4	Object
    //   39	599	12	localObject5	Object
    //   45	361	13	localObject6	Object
    //   541	17	13	localException3	Exception
    //   633	1	13	localException4	Exception
    //   48	341	14	str1	String
    //   51	493	15	str2	String
    //   33	449	16	localFile	File
    // Exception table:
    //   from	to	target	type
    //   224	232	518	java/lang/Exception
    //   236	242	518	java/lang/Exception
    //   405	411	525	java/lang/Exception
    //   78	91	541	java/lang/Exception
    //   78	91	586	finally
    //   555	565	586	finally
    //   99	105	625	finally
    //   113	124	625	finally
    //   132	145	625	finally
    //   153	161	625	finally
    //   169	179	625	finally
    //   190	198	625	finally
    //   206	218	625	finally
    //   224	232	625	finally
    //   236	242	625	finally
    //   250	259	625	finally
    //   267	273	625	finally
    //   281	292	625	finally
    //   300	313	625	finally
    //   321	330	625	finally
    //   338	348	625	finally
    //   372	380	625	finally
    //   388	401	625	finally
    //   405	411	625	finally
    //   99	105	633	java/lang/Exception
    //   113	124	633	java/lang/Exception
    //   132	145	633	java/lang/Exception
    //   153	161	633	java/lang/Exception
    //   169	179	633	java/lang/Exception
    //   190	198	633	java/lang/Exception
    //   206	218	633	java/lang/Exception
    //   250	259	633	java/lang/Exception
    //   267	273	633	java/lang/Exception
    //   281	292	633	java/lang/Exception
    //   300	313	633	java/lang/Exception
    //   321	330	633	java/lang/Exception
    //   338	348	633	java/lang/Exception
    //   372	380	633	java/lang/Exception
    //   388	401	633	java/lang/Exception
  }
  
  private void readAndCopyLargeData(AssetManager paramAssetManager)
  {
    Object localObject1 = new File(this.mOfflineDataPath);
    if (!((File)localObject1).exists())
    {
      ((File)localObject1).mkdirs();
      LogUtil.e("SysOSAPI", " init root path");
    }
    for (;;)
    {
      int i;
      Object localObject2;
      InputStream localInputStream;
      try
      {
        localObject1 = new File(this.mOfflineDataPath + "/navi/pub");
        if (!((File)localObject1).exists()) {
          ((File)localObject1).mkdirs();
        }
        localObject1 = new String[1];
        localObject1[0] = "s_3.png";
        i = 0;
        if (i < localObject1.length)
        {
          localObject2 = new File(this.mOfflineDataPath + new String[] { "/navi/pub/s_3" }[i]);
          if (((File)localObject2).exists()) {
            ((File)localObject2).delete();
          }
          ((File)localObject2).createNewFile();
          localObject2 = new FileOutputStream((File)localObject2);
          localInputStream = paramAssetManager.open(localObject1[i]);
          byte[] arrayOfByte = new byte['Ѐ'];
          int j = localInputStream.read(arrayOfByte, 0, 1024);
          if (j != -1)
          {
            ((FileOutputStream)localObject2).write(arrayOfByte, 0, j);
            ((FileOutputStream)localObject2).flush();
            continue;
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable paramAssetManager)
      {
        LogUtil.e("", paramAssetManager.toString());
      }
      localInputStream.close();
      ((FileOutputStream)localObject2).close();
      i += 1;
    }
  }
  
  private void readAndCopyResource(File paramFile, byte[] paramArrayOfByte, AssetManager paramAssetManager)
    throws Exception
  {
    if (paramFile.exists()) {
      paramFile.delete();
    }
    paramFile.createNewFile();
    paramFile = new FileOutputStream(paramFile);
    paramFile.write(paramArrayOfByte);
    paramFile.close();
    paramFile = new File(this.mAppResouceDir + "/cfg/a");
    if (!paramFile.exists()) {
      paramFile.mkdirs();
    }
    paramFile = new File(this.mAppResouceDir + "/cfg/h");
    if (!paramFile.exists()) {
      paramFile.mkdirs();
    }
    paramFile = new File(this.mAppResouceDir + "/cfg/l");
    if (!paramFile.exists()) {
      paramFile.mkdirs();
    }
    paramFile = new File(this.mAppResouceDir + "/HciCloud");
    if (!paramFile.exists()) {
      paramFile.mkdirs();
    }
    paramFile = getCopyFilelist();
    int i = 0;
    Object localObject;
    long l;
    File localFile;
    if (i < paramFile.length)
    {
      localObject = paramAssetManager.open(paramFile[i]);
      l = ((InputStream)localObject).available();
      localFile = new File(this.mAppResouceDir + "/" + paramFile[i]);
      if ((localFile.exists()) && (localFile.lastModified() > PackageUtil.getApkUpdateTime()) && (l == localFile.length())) {
        ((InputStream)localObject).close();
      }
    }
    for (;;)
    {
      i += 1;
      break;
      int j = (int)l;
      try
      {
        paramArrayOfByte = new byte[j];
        ((InputStream)localObject).read(paramArrayOfByte);
        ((InputStream)localObject).close();
        if (localFile.exists()) {
          localFile.delete();
        }
        localFile.createNewFile();
        localObject = new FileOutputStream(localFile);
      }
      catch (OutOfMemoryError paramArrayOfByte) {}
      try
      {
        ((FileOutputStream)localObject).write(paramArrayOfByte);
        ((FileOutputStream)localObject).close();
      }
      catch (OutOfMemoryError paramArrayOfByte) {}
      return;
    }
  }
  
  private void setGLRenderer(String paramString) {}
  
  private void setGLVersion(String paramString) {}
  
  public String GetModuleFileName()
  {
    return this.mAppFilesDir;
  }
  
  public String GetSDCardCachePath()
  {
    return this.mSDCardCachePath;
  }
  
  public String GetSDCardPath()
  {
    return this.mSDCardDataPath;
  }
  
  public String getGLRenderer()
  {
    return this.strGLRenderer;
  }
  
  public String getGLVersion()
  {
    return this.strGLVersion;
  }
  
  public String getOfflineDataPath()
  {
    return this.mOfflineDataPath;
  }
  
  public String getSDcardRootPath()
  {
    return this.mSDCardRootPath;
  }
  
  public String getSecondCachePath()
  {
    return this.mAppCacheDir;
  }
  
  public void init()
  {
    if ((this.inited) || (BNaviModuleManager.getContext() == null)) {
      return;
    }
    this.inited = true;
    this.mAppResouceDir = (BNaviModuleManager.getContext().getFilesDir().getAbsolutePath() + "/nmap");
    this.mAppFilesDir = BNaviModuleManager.getContext().getFilesDir().getAbsolutePath();
    this.mAppCacheDir = BNaviModuleManager.getContext().getCacheDir().getAbsolutePath();
    ensureStorage(this.mAppResouceDir);
    ensureStorage(this.mAppFilesDir);
    ensureStorage(this.mAppCacheDir);
  }
  
  public void initEngineRes(Context paramContext)
  {
    try
    {
      paramContext = new File(this.mAppResouceDir + "/ver.dat");
      int j = 1;
      byte[] arrayOfByte1 = new byte[6];
      byte[] tmp41_39 = arrayOfByte1;
      tmp41_39[0] = 2;
      byte[] tmp46_41 = tmp41_39;
      tmp46_41[1] = 0;
      byte[] tmp52_46 = tmp46_41;
      tmp52_46[2] = 0;
      byte[] tmp58_52 = tmp52_46;
      tmp58_52[3] = 0;
      byte[] tmp64_58 = tmp58_52;
      tmp64_58[4] = 0;
      byte[] tmp70_64 = tmp64_58;
      tmp70_64[5] = 9;
      tmp70_64;
      int i = j;
      if (paramContext.exists())
      {
        localObject = new FileInputStream(paramContext);
        byte[] arrayOfByte2 = new byte[((FileInputStream)localObject).available()];
        ((FileInputStream)localObject).read(arrayOfByte2);
        ((FileInputStream)localObject).close();
        i = j;
        if (Arrays.equals(arrayOfByte2, arrayOfByte1)) {
          i = 0;
        }
      }
      Object localObject = JarUtils.getResources().getAssets();
      readAndCopyDataCfg((AssetManager)localObject);
      readAndCopyData((AssetManager)localObject);
      if (i != 0) {
        readAndCopyResource(paramContext, arrayOfByte1, (AssetManager)localObject);
      }
      return;
    }
    catch (Exception paramContext)
    {
      LogUtil.e("", paramContext.toString());
    }
  }
  
  public Bundle initPhoneInfo()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("cpu", "");
    localBundle.putString("resid", "01");
    localBundle.putString("channel", PackageUtil.strChannel);
    localBundle.putString("glr", this.strGLRenderer);
    localBundle.putString("glv", this.strGLVersion);
    localBundle.putString("mb", PackageUtil.strPhoneType);
    localBundle.putString("sv", PackageUtil.strSoftWareVer);
    localBundle.putString("os", PackageUtil.strOSVersion);
    localBundle.putInt("dpi_x", ScreenUtil.getInstance().getDPI());
    localBundle.putInt("dpi_y", ScreenUtil.getInstance().getDPI());
    localBundle.putString("net", NetworkUtils.getCurrentNetMode(BNaviModuleManager.getContext()));
    localBundle.putString("im", PackageUtil.getImeiNum());
    localBundle.putString("imrand", PackageUtil.getImeiRand());
    localBundle.putByteArray("signature", PackageUtil.getPackageSignature());
    localBundle.putString("deviceid", PackageUtil.getImeiNum());
    return localBundle;
  }
  
  public void initSDcardPath(String paramString)
  {
    this.mSDCardRootPath = paramString;
    paramString = this.mSDCardRootPath;
    if ((mAppFolderName != null) && (!TextUtils.isEmpty(mAppFolderName))) {
      ROOT_FOLDER = mAppFolderName + "/bnav";
    }
    paramString = paramString + "/" + ROOT_FOLDER;
    ensureStorage(paramString);
    ensureNoMediaFile(paramString);
    this.mSDCardDataPath = paramString;
    this.mSDCardCachePath = (this.mSDCardDataPath + "/cache");
    ensureStorage(this.mSDCardCachePath);
  }
  
  public void setAppFolderName(String paramString)
  {
    mAppFolderName = paramString;
  }
  
  public void setOfflineDataPath(String paramString)
  {
    this.mOfflineDataPath = paramString;
  }
  
  public void updateGLinfo(String paramString1, String paramString2)
  {
    setGLVersion(paramString1);
    setGLRenderer(paramString2);
  }
  
  private static class LazyHolder
  {
    private static SysOSAPI sInstance = new SysOSAPI(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/SysOSAPI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */