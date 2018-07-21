package com.baidu.navisdk.module.cloudconfig;

import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import java.io.File;
import org.json.JSONObject;

public class DataCacheManager
{
  private static final String TAG = DataCacheManager.class.getName();
  private static String fileCloudConfigCachePath = SysOSAPI.getInstance().GetSDCardCachePath() + File.separator + "initConfig9_7_5";
  private JSONObject mCacheJSONObject = null;
  
  private File getConfigFile()
  {
    File localFile = new File(fileCloudConfigCachePath);
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      return localFile;
    }
    catch (Exception localException)
    {
      LogUtil.e(TAG, localException.toString());
    }
    return localFile;
  }
  
  private boolean isCecheConfigExists()
  {
    return new File(fileCloudConfigCachePath).exists();
  }
  
  /* Error */
  public void clearFileCache()
  {
    // Byte code:
    //   0: new 39	java/io/File
    //   3: dup
    //   4: getstatic 49	com/baidu/navisdk/module/cloudconfig/DataCacheManager:fileCloudConfigCachePath	Ljava/lang/String;
    //   7: invokespecial 60	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_2
    //   12: invokevirtual 64	java/io/File:exists	()Z
    //   15: ifeq +34 -> 49
    //   18: aconst_null
    //   19: astore_1
    //   20: aconst_null
    //   21: astore_3
    //   22: new 80	java/io/FileWriter
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 83	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   30: astore_2
    //   31: aload_2
    //   32: ldc 85
    //   34: invokevirtual 88	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   37: aload_2
    //   38: invokevirtual 91	java/io/FileWriter:close	()V
    //   41: aload_2
    //   42: ifnull +7 -> 49
    //   45: aload_2
    //   46: invokevirtual 91	java/io/FileWriter:close	()V
    //   49: return
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual 94	java/io/IOException:printStackTrace	()V
    //   55: return
    //   56: astore_1
    //   57: aload_3
    //   58: astore_2
    //   59: aload_1
    //   60: astore_3
    //   61: aload_2
    //   62: astore_1
    //   63: aload_3
    //   64: invokevirtual 95	java/lang/Exception:printStackTrace	()V
    //   67: aload_2
    //   68: ifnull -19 -> 49
    //   71: aload_2
    //   72: invokevirtual 91	java/io/FileWriter:close	()V
    //   75: return
    //   76: astore_1
    //   77: aload_1
    //   78: invokevirtual 94	java/io/IOException:printStackTrace	()V
    //   81: return
    //   82: astore_2
    //   83: aload_1
    //   84: ifnull +7 -> 91
    //   87: aload_1
    //   88: invokevirtual 91	java/io/FileWriter:close	()V
    //   91: aload_2
    //   92: athrow
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual 94	java/io/IOException:printStackTrace	()V
    //   98: goto -7 -> 91
    //   101: astore_3
    //   102: aload_2
    //   103: astore_1
    //   104: aload_3
    //   105: astore_2
    //   106: goto -23 -> 83
    //   109: astore_3
    //   110: goto -49 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	DataCacheManager
    //   19	1	1	localObject1	Object
    //   50	2	1	localIOException1	java.io.IOException
    //   56	4	1	localException1	Exception
    //   62	1	1	localObject2	Object
    //   76	12	1	localIOException2	java.io.IOException
    //   93	2	1	localIOException3	java.io.IOException
    //   103	1	1	localObject3	Object
    //   10	62	2	localObject4	Object
    //   82	21	2	localObject5	Object
    //   105	1	2	localObject6	Object
    //   21	43	3	localException2	Exception
    //   101	4	3	localObject7	Object
    //   109	1	3	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   45	49	50	java/io/IOException
    //   22	31	56	java/lang/Exception
    //   71	75	76	java/io/IOException
    //   22	31	82	finally
    //   63	67	82	finally
    //   87	91	93	java/io/IOException
    //   31	41	101	finally
    //   31	41	109	java/lang/Exception
  }
  
  public void destroy()
  {
    this.mCacheJSONObject = null;
  }
  
  public String getEtag()
  {
    JSONObject localJSONObject = getJSonObjectFromFile();
    if (localJSONObject == null)
    {
      clearFileCache();
      return "";
    }
    try
    {
      String str = localJSONObject.getJSONObject("data").getString("etag");
      if (str != null)
      {
        this.mCacheJSONObject = localJSONObject;
        return str;
      }
    }
    catch (Exception localException)
    {
      clearFileCache();
      return "";
    }
    clearFileCache();
    return "";
  }
  
  /* Error */
  public JSONObject getJSonObjectFromFile()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 53	com/baidu/navisdk/module/cloudconfig/DataCacheManager:mCacheJSONObject	Lorg/json/JSONObject;
    //   4: ifnull +10 -> 14
    //   7: aload_0
    //   8: getfield 53	com/baidu/navisdk/module/cloudconfig/DataCacheManager:mCacheJSONObject	Lorg/json/JSONObject;
    //   11: astore_2
    //   12: aload_2
    //   13: areturn
    //   14: aload_0
    //   15: invokespecial 119	com/baidu/navisdk/module/cloudconfig/DataCacheManager:isCecheConfigExists	()Z
    //   18: ifne +5 -> 23
    //   21: aconst_null
    //   22: areturn
    //   23: new 121	java/lang/StringBuffer
    //   26: dup
    //   27: invokespecial 122	java/lang/StringBuffer:<init>	()V
    //   30: astore 4
    //   32: aconst_null
    //   33: astore 5
    //   35: aload_0
    //   36: invokespecial 124	com/baidu/navisdk/module/cloudconfig/DataCacheManager:getConfigFile	()Ljava/io/File;
    //   39: astore_3
    //   40: sipush 1024
    //   43: newarray <illegal type>
    //   45: astore 7
    //   47: aconst_null
    //   48: astore_2
    //   49: aconst_null
    //   50: astore 6
    //   52: new 126	java/io/InputStreamReader
    //   55: dup
    //   56: new 128	java/io/FileInputStream
    //   59: dup
    //   60: aload_3
    //   61: invokespecial 129	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   64: invokespecial 132	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   67: astore_3
    //   68: aload_3
    //   69: aload 7
    //   71: invokevirtual 136	java/io/InputStreamReader:read	([C)I
    //   74: istore_1
    //   75: iload_1
    //   76: iconst_m1
    //   77: if_icmpeq +51 -> 128
    //   80: aload 4
    //   82: aload 7
    //   84: iconst_0
    //   85: iload_1
    //   86: invokevirtual 139	java/lang/StringBuffer:append	([CII)Ljava/lang/StringBuffer;
    //   89: pop
    //   90: goto -22 -> 68
    //   93: astore 4
    //   95: aload_3
    //   96: astore_2
    //   97: getstatic 19	com/baidu/navisdk/module/cloudconfig/DataCacheManager:TAG	Ljava/lang/String;
    //   100: aload 4
    //   102: invokevirtual 68	java/lang/Exception:toString	()Ljava/lang/String;
    //   105: invokestatic 74	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: aload 5
    //   110: astore_2
    //   111: aload_3
    //   112: ifnull -100 -> 12
    //   115: aload_3
    //   116: invokevirtual 140	java/io/InputStreamReader:close	()V
    //   119: aconst_null
    //   120: areturn
    //   121: astore_2
    //   122: aload_2
    //   123: invokevirtual 94	java/io/IOException:printStackTrace	()V
    //   126: aconst_null
    //   127: areturn
    //   128: new 107	org/json/JSONObject
    //   131: dup
    //   132: aload 4
    //   134: invokevirtual 141	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   137: invokespecial 142	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   140: astore_2
    //   141: aload_3
    //   142: ifnull +53 -> 195
    //   145: aload_3
    //   146: invokevirtual 140	java/io/InputStreamReader:close	()V
    //   149: aload_2
    //   150: areturn
    //   151: astore_3
    //   152: aload_3
    //   153: invokevirtual 94	java/io/IOException:printStackTrace	()V
    //   156: aload_2
    //   157: areturn
    //   158: astore_3
    //   159: aload_2
    //   160: ifnull +7 -> 167
    //   163: aload_2
    //   164: invokevirtual 140	java/io/InputStreamReader:close	()V
    //   167: aload_3
    //   168: athrow
    //   169: astore_2
    //   170: aload_2
    //   171: invokevirtual 94	java/io/IOException:printStackTrace	()V
    //   174: goto -7 -> 167
    //   177: astore 4
    //   179: aload_3
    //   180: astore_2
    //   181: aload 4
    //   183: astore_3
    //   184: goto -25 -> 159
    //   187: astore 4
    //   189: aload 6
    //   191: astore_3
    //   192: goto -97 -> 95
    //   195: aload_2
    //   196: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	197	0	this	DataCacheManager
    //   74	12	1	i	int
    //   11	100	2	localObject1	Object
    //   121	2	2	localIOException1	java.io.IOException
    //   140	24	2	localJSONObject	JSONObject
    //   169	2	2	localIOException2	java.io.IOException
    //   180	16	2	localObject2	Object
    //   39	107	3	localObject3	Object
    //   151	2	3	localIOException3	java.io.IOException
    //   158	22	3	localObject4	Object
    //   183	9	3	localObject5	Object
    //   30	51	4	localStringBuffer	StringBuffer
    //   93	40	4	localException1	Exception
    //   177	5	4	localObject6	Object
    //   187	1	4	localException2	Exception
    //   33	76	5	localObject7	Object
    //   50	140	6	localObject8	Object
    //   45	38	7	arrayOfChar	char[]
    // Exception table:
    //   from	to	target	type
    //   68	75	93	java/lang/Exception
    //   80	90	93	java/lang/Exception
    //   128	141	93	java/lang/Exception
    //   115	119	121	java/io/IOException
    //   145	149	151	java/io/IOException
    //   52	68	158	finally
    //   97	108	158	finally
    //   163	167	169	java/io/IOException
    //   68	75	177	finally
    //   80	90	177	finally
    //   128	141	177	finally
    //   52	68	187	java/lang/Exception
  }
  
  /* Error */
  public void saveJSonObjectToFile(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 145	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4: astore 4
    //   6: aload_0
    //   7: invokespecial 124	com/baidu/navisdk/module/cloudconfig/DataCacheManager:getConfigFile	()Ljava/io/File;
    //   10: astore_2
    //   11: aload_2
    //   12: invokevirtual 64	java/io/File:exists	()Z
    //   15: ifeq +34 -> 49
    //   18: aconst_null
    //   19: astore_1
    //   20: aconst_null
    //   21: astore_3
    //   22: new 80	java/io/FileWriter
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 83	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   30: astore_2
    //   31: aload_2
    //   32: aload 4
    //   34: invokevirtual 88	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   37: aload_2
    //   38: invokevirtual 91	java/io/FileWriter:close	()V
    //   41: aload_2
    //   42: ifnull +7 -> 49
    //   45: aload_2
    //   46: invokevirtual 91	java/io/FileWriter:close	()V
    //   49: return
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual 94	java/io/IOException:printStackTrace	()V
    //   55: return
    //   56: astore_1
    //   57: aload_3
    //   58: astore_2
    //   59: aload_1
    //   60: astore_3
    //   61: aload_2
    //   62: astore_1
    //   63: aload_3
    //   64: invokevirtual 95	java/lang/Exception:printStackTrace	()V
    //   67: aload_2
    //   68: ifnull -19 -> 49
    //   71: aload_2
    //   72: invokevirtual 91	java/io/FileWriter:close	()V
    //   75: return
    //   76: astore_1
    //   77: aload_1
    //   78: invokevirtual 94	java/io/IOException:printStackTrace	()V
    //   81: return
    //   82: astore_2
    //   83: aload_1
    //   84: ifnull +7 -> 91
    //   87: aload_1
    //   88: invokevirtual 91	java/io/FileWriter:close	()V
    //   91: aload_2
    //   92: athrow
    //   93: astore_1
    //   94: aload_1
    //   95: invokevirtual 94	java/io/IOException:printStackTrace	()V
    //   98: goto -7 -> 91
    //   101: astore_3
    //   102: aload_2
    //   103: astore_1
    //   104: aload_3
    //   105: astore_2
    //   106: goto -23 -> 83
    //   109: astore_3
    //   110: goto -49 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	DataCacheManager
    //   0	113	1	paramJSONObject	JSONObject
    //   10	62	2	localObject1	Object
    //   82	21	2	localObject2	Object
    //   105	1	2	localObject3	Object
    //   21	43	3	localJSONObject	JSONObject
    //   101	4	3	localObject4	Object
    //   109	1	3	localException	Exception
    //   4	29	4	str	String
    // Exception table:
    //   from	to	target	type
    //   45	49	50	java/io/IOException
    //   22	31	56	java/lang/Exception
    //   71	75	76	java/io/IOException
    //   22	31	82	finally
    //   63	67	82	finally
    //   87	91	93	java/io/IOException
    //   31	41	101	finally
    //   31	41	109	java/lang/Exception
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/cloudconfig/DataCacheManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */