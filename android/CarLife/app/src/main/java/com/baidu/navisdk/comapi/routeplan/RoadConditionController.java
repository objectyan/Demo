package com.baidu.navisdk.comapi.routeplan;

import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RoadConditionController
{
  private static final String CHAR_SET = "utf-8";
  public static final int DEFAULT_CITY_LIST_VERSION = 0;
  public static final int DELAY_WAIT_TIME = 5000;
  private static final int K_CITYUPDATE_TIMEOUT = 50000;
  private static final String REQ_CONNECT_SYMBOL = "&";
  private static final String ROAD_CONDITON_CITY = "RoadConditionCity.txt";
  private static final String TAG = "RoadConditionController";
  private static boolean isListPullSuccess = false;
  private static volatile RoadConditionController sInstance = null;
  public List<Integer> mCityList = new ArrayList();
  public int mCityListVersion = 0;
  
  public static RoadConditionController getInstance()
  {
    if (sInstance == null) {}
    try
    {
      if (sInstance == null) {
        sInstance = new RoadConditionController();
      }
      return sInstance;
    }
    finally {}
  }
  
  private byte[] getLineBytes()
  {
    Object localObject = System.getProperty("line.separator");
    try
    {
      localObject = ((String)localObject).getBytes("utf-8");
      return (byte[])localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return new byte[0];
  }
  
  private File getLocalFile()
  {
    return new File(SysOSAPI.getInstance().GetSDCardPath() + "/" + "RoadConditionCity.txt");
  }
  
  private boolean isCityListInitial()
  {
    return this.mCityListVersion != 0;
  }
  
  private void pullFailOperation()
  {
    if (!isCityListInitial()) {
      updateCityListByLocal();
    }
  }
  
  /* Error */
  private void updateCityListByLocal()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 117	com/baidu/navisdk/comapi/routeplan/RoadConditionController:getLocalFile	()Ljava/io/File;
    //   4: astore_1
    //   5: aload_1
    //   6: invokevirtual 120	java/io/File:exists	()Z
    //   9: ifne +4 -> 13
    //   12: return
    //   13: aconst_null
    //   14: astore_3
    //   15: aconst_null
    //   16: astore 6
    //   18: aconst_null
    //   19: astore_2
    //   20: aconst_null
    //   21: astore 5
    //   23: aconst_null
    //   24: astore 4
    //   26: new 122	java/io/FileReader
    //   29: dup
    //   30: aload_1
    //   31: invokespecial 125	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   34: astore_1
    //   35: new 127	java/io/BufferedReader
    //   38: dup
    //   39: aload_1
    //   40: invokespecial 130	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   43: astore_2
    //   44: aload_2
    //   45: invokevirtual 133	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   48: astore_3
    //   49: aload_3
    //   50: invokestatic 139	com/baidu/navisdk/util/common/StringUtils:isEmpty	(Ljava/lang/String;)Z
    //   53: ifne +14 -> 67
    //   56: aload_0
    //   57: aload_3
    //   58: invokestatic 145	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   61: invokevirtual 149	java/lang/Integer:intValue	()I
    //   64: putfield 44	com/baidu/navisdk/comapi/routeplan/RoadConditionController:mCityListVersion	I
    //   67: aload_0
    //   68: getfield 49	com/baidu/navisdk/comapi/routeplan/RoadConditionController:mCityList	Ljava/util/List;
    //   71: invokeinterface 154 1 0
    //   76: aload_2
    //   77: invokevirtual 133	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   80: astore_3
    //   81: aload_3
    //   82: ifnull +70 -> 152
    //   85: aload_3
    //   86: invokestatic 139	com/baidu/navisdk/util/common/StringUtils:isEmpty	(Ljava/lang/String;)Z
    //   89: ifne -13 -> 76
    //   92: aload_0
    //   93: getfield 49	com/baidu/navisdk/comapi/routeplan/RoadConditionController:mCityList	Ljava/util/List;
    //   96: aload_3
    //   97: invokestatic 158	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   100: invokestatic 161	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   103: invokeinterface 165 2 0
    //   108: pop
    //   109: goto -33 -> 76
    //   112: astore 5
    //   114: aload_2
    //   115: astore 4
    //   117: aload 4
    //   119: astore_2
    //   120: aload_1
    //   121: astore_3
    //   122: aload 5
    //   124: invokevirtual 166	java/lang/Exception:printStackTrace	()V
    //   127: aload 4
    //   129: ifnull +8 -> 137
    //   132: aload 4
    //   134: invokevirtual 169	java/io/BufferedReader:close	()V
    //   137: aload_1
    //   138: ifnull -126 -> 12
    //   141: aload_1
    //   142: invokevirtual 170	java/io/FileReader:close	()V
    //   145: return
    //   146: astore_1
    //   147: aload_1
    //   148: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   151: return
    //   152: aload_2
    //   153: ifnull +7 -> 160
    //   156: aload_2
    //   157: invokevirtual 169	java/io/BufferedReader:close	()V
    //   160: aload_1
    //   161: ifnull +101 -> 262
    //   164: aload_1
    //   165: invokevirtual 170	java/io/FileReader:close	()V
    //   168: return
    //   169: astore_2
    //   170: aload_2
    //   171: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   174: goto -14 -> 160
    //   177: astore_1
    //   178: aload_1
    //   179: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   182: return
    //   183: astore_2
    //   184: aload_2
    //   185: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   188: goto -51 -> 137
    //   191: astore_1
    //   192: aload_2
    //   193: ifnull +7 -> 200
    //   196: aload_2
    //   197: invokevirtual 169	java/io/BufferedReader:close	()V
    //   200: aload_3
    //   201: ifnull +7 -> 208
    //   204: aload_3
    //   205: invokevirtual 170	java/io/FileReader:close	()V
    //   208: aload_1
    //   209: athrow
    //   210: astore_2
    //   211: aload_2
    //   212: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   215: goto -15 -> 200
    //   218: astore_2
    //   219: aload_2
    //   220: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   223: goto -15 -> 208
    //   226: astore 4
    //   228: aload 5
    //   230: astore_2
    //   231: aload_1
    //   232: astore_3
    //   233: aload 4
    //   235: astore_1
    //   236: goto -44 -> 192
    //   239: astore 4
    //   241: aload_1
    //   242: astore_3
    //   243: aload 4
    //   245: astore_1
    //   246: goto -54 -> 192
    //   249: astore 5
    //   251: aload 6
    //   253: astore_1
    //   254: goto -137 -> 117
    //   257: astore 5
    //   259: goto -142 -> 117
    //   262: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	RoadConditionController
    //   4	138	1	localObject1	Object
    //   146	19	1	localIOException1	java.io.IOException
    //   177	2	1	localIOException2	java.io.IOException
    //   191	41	1	localObject2	Object
    //   235	19	1	localObject3	Object
    //   19	138	2	localObject4	Object
    //   169	2	2	localIOException3	java.io.IOException
    //   183	14	2	localIOException4	java.io.IOException
    //   210	2	2	localIOException5	java.io.IOException
    //   218	2	2	localIOException6	java.io.IOException
    //   230	1	2	localObject5	Object
    //   14	229	3	localObject6	Object
    //   24	109	4	localObject7	Object
    //   226	8	4	localObject8	Object
    //   239	5	4	localObject9	Object
    //   21	1	5	localObject10	Object
    //   112	117	5	localException1	Exception
    //   249	1	5	localException2	Exception
    //   257	1	5	localException3	Exception
    //   16	236	6	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   44	67	112	java/lang/Exception
    //   67	76	112	java/lang/Exception
    //   76	81	112	java/lang/Exception
    //   85	109	112	java/lang/Exception
    //   141	145	146	java/io/IOException
    //   156	160	169	java/io/IOException
    //   164	168	177	java/io/IOException
    //   132	137	183	java/io/IOException
    //   26	35	191	finally
    //   122	127	191	finally
    //   196	200	210	java/io/IOException
    //   204	208	218	java/io/IOException
    //   35	44	226	finally
    //   44	67	239	finally
    //   67	76	239	finally
    //   76	81	239	finally
    //   85	109	239	finally
    //   26	35	249	java/lang/Exception
    //   35	44	257	java/lang/Exception
  }
  
  /* Error */
  private void updateCityListVersion()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 117	com/baidu/navisdk/comapi/routeplan/RoadConditionController:getLocalFile	()Ljava/io/File;
    //   4: astore_2
    //   5: aload_2
    //   6: invokevirtual 120	java/io/File:exists	()Z
    //   9: ifeq +8 -> 17
    //   12: aload_2
    //   13: invokevirtual 175	java/io/File:delete	()Z
    //   16: pop
    //   17: aconst_null
    //   18: astore_1
    //   19: aconst_null
    //   20: astore 4
    //   22: new 177	java/io/FileOutputStream
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 178	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   30: astore_2
    //   31: aload_2
    //   32: aload_0
    //   33: getfield 44	com/baidu/navisdk/comapi/routeplan/RoadConditionController:mCityListVersion	I
    //   36: invokestatic 181	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   39: ldc 8
    //   41: invokevirtual 72	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   44: invokevirtual 185	java/io/FileOutputStream:write	([B)V
    //   47: aload_2
    //   48: aload_0
    //   49: invokespecial 187	com/baidu/navisdk/comapi/routeplan/RoadConditionController:getLineBytes	()[B
    //   52: invokevirtual 185	java/io/FileOutputStream:write	([B)V
    //   55: aload_0
    //   56: getfield 49	com/baidu/navisdk/comapi/routeplan/RoadConditionController:mCityList	Ljava/util/List;
    //   59: invokeinterface 191 1 0
    //   64: astore_1
    //   65: aload_1
    //   66: invokeinterface 196 1 0
    //   71: ifeq +51 -> 122
    //   74: aload_2
    //   75: aload_1
    //   76: invokeinterface 200 1 0
    //   81: checkcast 141	java/lang/Integer
    //   84: invokevirtual 201	java/lang/Integer:toString	()Ljava/lang/String;
    //   87: ldc 8
    //   89: invokevirtual 72	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   92: invokevirtual 185	java/io/FileOutputStream:write	([B)V
    //   95: aload_2
    //   96: aload_0
    //   97: invokespecial 187	com/baidu/navisdk/comapi/routeplan/RoadConditionController:getLineBytes	()[B
    //   100: invokevirtual 185	java/io/FileOutputStream:write	([B)V
    //   103: goto -38 -> 65
    //   106: astore_3
    //   107: aload_2
    //   108: astore_1
    //   109: aload_3
    //   110: invokevirtual 166	java/lang/Exception:printStackTrace	()V
    //   113: aload_2
    //   114: ifnull +7 -> 121
    //   117: aload_2
    //   118: invokevirtual 202	java/io/FileOutputStream:close	()V
    //   121: return
    //   122: aload_2
    //   123: invokevirtual 205	java/io/FileOutputStream:flush	()V
    //   126: aload_2
    //   127: ifnull +54 -> 181
    //   130: aload_2
    //   131: invokevirtual 202	java/io/FileOutputStream:close	()V
    //   134: return
    //   135: astore_1
    //   136: aload_1
    //   137: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   140: return
    //   141: astore_1
    //   142: aload_1
    //   143: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   146: return
    //   147: astore_2
    //   148: aload_1
    //   149: ifnull +7 -> 156
    //   152: aload_1
    //   153: invokevirtual 202	java/io/FileOutputStream:close	()V
    //   156: aload_2
    //   157: athrow
    //   158: astore_1
    //   159: aload_1
    //   160: invokevirtual 171	java/io/IOException:printStackTrace	()V
    //   163: goto -7 -> 156
    //   166: astore_3
    //   167: aload_2
    //   168: astore_1
    //   169: aload_3
    //   170: astore_2
    //   171: goto -23 -> 148
    //   174: astore_3
    //   175: aload 4
    //   177: astore_2
    //   178: goto -71 -> 107
    //   181: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	RoadConditionController
    //   18	91	1	localObject1	Object
    //   135	2	1	localIOException1	java.io.IOException
    //   141	12	1	localIOException2	java.io.IOException
    //   158	2	1	localIOException3	java.io.IOException
    //   168	1	1	localObject2	Object
    //   4	127	2	localObject3	Object
    //   147	21	2	localObject4	Object
    //   170	8	2	localObject5	Object
    //   106	4	3	localException1	Exception
    //   166	4	3	localObject6	Object
    //   174	1	3	localException2	Exception
    //   20	156	4	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   31	65	106	java/lang/Exception
    //   65	103	106	java/lang/Exception
    //   122	126	106	java/lang/Exception
    //   130	134	135	java/io/IOException
    //   117	121	141	java/io/IOException
    //   22	31	147	finally
    //   109	113	147	finally
    //   152	156	158	java/io/IOException
    //   31	65	166	finally
    //   65	103	166	finally
    //   122	126	166	finally
    //   22	31	174	java/lang/Exception
  }
  
  public void addToCityList(int paramInt)
  {
    this.mCityList.add(Integer.valueOf(paramInt));
  }
  
  public boolean checkRoadCondtionSupport(int paramInt)
  {
    if ((!isListPullSuccess) || (!getLocalFile().exists())) {
      LogUtil.e("RoadConditionController", "checkRoadCondtionSupport last pull failed.");
    }
    if (!isCityListInitial()) {
      updateCityListByLocal();
    }
    LogUtil.e("RoadConditonController", "dingbin " + paramInt + " " + this.mCityList.toString());
    Iterator localIterator = this.mCityList.iterator();
    while (localIterator.hasNext()) {
      if (((Integer)localIterator.next()).intValue() == paramInt) {
        return true;
      }
    }
    return false;
  }
  
  public List<Integer> getCityList()
  {
    return this.mCityList;
  }
  
  public int getCityListVersion()
  {
    return this.mCityListVersion;
  }
  
  public int getLocaCityListlVersion()
  {
    if (this.mCityListVersion == 0) {
      updateCityListByLocal();
    }
    return this.mCityListVersion;
  }
  
  public String getPullParams()
  {
    int i = getLocaCityListlVersion();
    String str = "version=" + String.valueOf(i);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("qt=city_list");
    localStringBuffer.append("&");
    localStringBuffer.append(str);
    localStringBuffer.append("&");
    localStringBuffer.append("cuid=" + PackageUtil.getCuid());
    LogUtil.e("RoadConditionController", "request parm are " + localStringBuffer.toString());
    return localStringBuffer.toString().replace("|", "%124");
  }
  
  public void setCityList(List<Integer> paramList)
  {
    this.mCityList = paramList;
  }
  
  public void setCityListVersion(int paramInt)
  {
    this.mCityListVersion = paramInt;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/routeplan/RoadConditionController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */