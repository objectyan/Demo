package com.baidu.navisdk.comapi.statistics;

import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpCenterHelper;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import com.baidu.navisdk.util.http.center.IBNHttpCenter;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class NaviStatSessionHelper
{
  private static final String DOCUMENTS_TEST_FILE = "testLog";
  private static final String JSONKEY_TM = "\"tm\":";
  private static final int MAX_SESSION_SIZE = 6144;
  private static final String STAT_COMSESSION_LOG_FILE = "statComSessionLog.txt";
  private static final String STAT_SESSION_LOG_FILE = "statSessionLog.txt";
  private static final String TEST_STAT_LOG_FILE = "testLogFile";
  private static final Long TIME_OUT;
  private static boolean hasTestIninted;
  private static Session mSession;
  private static int maxSessionSize;
  private static long preActionTime;
  private static int preEventID;
  private static int pushNaviSessionStatisticsRet = 0;
  private static List<NameValuePair> sGlobalStatParamsPrefixs;
  private static ArrayList<String> sStatCacheContent = new ArrayList();
  private static List<NameValuePair> sStatParamsPrefixs;
  private static int testCount = 0;
  private static int testSessionCount = 0;
  private static String testSessionFileName;
  private long preIDTime = 0L;
  
  static
  {
    TIME_OUT = Long.valueOf(21600L);
    mSession = null;
    preActionTime = -1L;
    preEventID = -1;
    maxSessionSize = 8192;
    sStatParamsPrefixs = new ArrayList();
    sGlobalStatParamsPrefixs = new ArrayList();
    hasTestIninted = false;
    testSessionFileName = null;
  }
  
  /* Error */
  private static void clearTxtFile(String paramString)
  {
    // Byte code:
    //   0: new 107	java/io/File
    //   3: dup
    //   4: new 109	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   11: invokestatic 116	com/baidu/navisdk/util/common/SysOSAPI:getInstance	()Lcom/baidu/navisdk/util/common/SysOSAPI;
    //   14: invokevirtual 120	com/baidu/navisdk/util/common/SysOSAPI:GetSDCardCachePath	()Ljava/lang/String;
    //   17: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 126
    //   22: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_0
    //   26: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokespecial 131	java/io/File:<init>	(Ljava/lang/String;)V
    //   35: astore_1
    //   36: aload_1
    //   37: ifnull +45 -> 82
    //   40: aload_1
    //   41: invokevirtual 135	java/io/File:exists	()Z
    //   44: ifeq +38 -> 82
    //   47: aconst_null
    //   48: astore_0
    //   49: aconst_null
    //   50: astore_2
    //   51: new 137	java/io/FileOutputStream
    //   54: dup
    //   55: aload_1
    //   56: iconst_0
    //   57: invokespecial 140	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   60: astore_1
    //   61: aload_1
    //   62: ldc -114
    //   64: invokevirtual 148	java/lang/String:getBytes	()[B
    //   67: invokevirtual 152	java/io/FileOutputStream:write	([B)V
    //   70: aload_1
    //   71: invokevirtual 155	java/io/FileOutputStream:flush	()V
    //   74: aload_1
    //   75: ifnull +7 -> 82
    //   78: aload_1
    //   79: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   82: return
    //   83: astore_0
    //   84: ldc -96
    //   86: aload_0
    //   87: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   90: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   93: goto -11 -> 82
    //   96: astore_0
    //   97: aload_2
    //   98: astore_1
    //   99: aload_0
    //   100: astore_2
    //   101: aload_1
    //   102: astore_0
    //   103: ldc -96
    //   105: aload_2
    //   106: invokevirtual 170	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   109: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: aload_1
    //   113: ifnull -31 -> 82
    //   116: aload_1
    //   117: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   120: return
    //   121: astore_0
    //   122: ldc -96
    //   124: aload_0
    //   125: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   128: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: goto -11 -> 120
    //   134: astore_1
    //   135: aload_0
    //   136: ifnull +7 -> 143
    //   139: aload_0
    //   140: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   143: aload_1
    //   144: athrow
    //   145: astore_0
    //   146: ldc -96
    //   148: aload_0
    //   149: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   152: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: goto -12 -> 143
    //   158: astore_2
    //   159: aload_1
    //   160: astore_0
    //   161: aload_2
    //   162: astore_1
    //   163: goto -28 -> 135
    //   166: astore_2
    //   167: goto -66 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	paramString	String
    //   35	82	1	localObject1	Object
    //   134	26	1	localObject2	Object
    //   162	1	1	localObject3	Object
    //   50	56	2	str	String
    //   158	4	2	localObject4	Object
    //   166	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   78	82	83	java/io/IOException
    //   51	61	96	java/lang/Exception
    //   116	120	121	java/io/IOException
    //   51	61	134	finally
    //   103	112	134	finally
    //   139	143	145	java/io/IOException
    //   61	74	158	finally
    //   61	74	166	java/lang/Exception
  }
  
  private static long getEventTimeFromFile(String paramString)
  {
    try
    {
      int i = paramString.indexOf("tm\":");
      String str = paramString;
      if (i >= 0) {
        str = paramString.substring("tm\":".length() + i);
      }
      long l = Long.parseLong(str.substring(0, str.indexOf(",")));
      return l;
    }
    catch (Exception paramString) {}
    return -1L;
  }
  
  public static List<Session> getListSessionFromFile()
  {
    return getOfflineStateFromComSessionFile();
  }
  
  private static File getOfflineSessionStatLogFile(String paramString)
  {
    paramString = new File(SysOSAPI.getInstance().GetSDCardCachePath() + "/" + paramString);
    if (paramString.exists()) {
      return paramString;
    }
    try
    {
      paramString.createNewFile();
      return paramString;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return paramString;
  }
  
  /* Error */
  private static List<Session> getOfflineStateFromComSessionFile()
  {
    // Byte code:
    //   0: new 213	java/util/LinkedList
    //   3: dup
    //   4: invokespecial 214	java/util/LinkedList:<init>	()V
    //   7: astore 6
    //   9: new 107	java/io/File
    //   12: dup
    //   13: new 109	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   20: invokestatic 116	com/baidu/navisdk/util/common/SysOSAPI:getInstance	()Lcom/baidu/navisdk/util/common/SysOSAPI;
    //   23: invokevirtual 120	com/baidu/navisdk/util/common/SysOSAPI:GetSDCardCachePath	()Ljava/lang/String;
    //   26: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 126
    //   31: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc 22
    //   36: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: invokespecial 131	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore_2
    //   46: aload_2
    //   47: invokevirtual 135	java/io/File:exists	()Z
    //   50: ifne +5 -> 55
    //   53: aconst_null
    //   54: areturn
    //   55: aconst_null
    //   56: astore 5
    //   58: aconst_null
    //   59: astore_3
    //   60: aconst_null
    //   61: astore 4
    //   63: new 216	java/io/BufferedReader
    //   66: dup
    //   67: new 218	java/io/FileReader
    //   70: dup
    //   71: aload_2
    //   72: invokespecial 221	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   75: invokespecial 224	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   78: astore_2
    //   79: aconst_null
    //   80: astore_3
    //   81: aload_2
    //   82: invokevirtual 227	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   85: astore_3
    //   86: aload_3
    //   87: ifnull +18 -> 105
    //   90: aload_3
    //   91: ifnull +14 -> 105
    //   94: aload_3
    //   95: ldc -114
    //   97: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   100: istore_1
    //   101: iload_1
    //   102: ifeq +19 -> 121
    //   105: aload_2
    //   106: ifnull +244 -> 350
    //   109: aload_2
    //   110: invokevirtual 232	java/io/BufferedReader:close	()V
    //   113: ldc 22
    //   115: invokestatic 234	com/baidu/navisdk/comapi/statistics/NaviStatSessionHelper:clearTxtFile	(Ljava/lang/String;)V
    //   118: aload 6
    //   120: areturn
    //   121: aload_3
    //   122: ldc -20
    //   124: invokevirtual 240	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   127: astore 4
    //   129: new 8	com/baidu/navisdk/comapi/statistics/NaviStatSessionHelper$Session
    //   132: dup
    //   133: aconst_null
    //   134: invokespecial 243	com/baidu/navisdk/comapi/statistics/NaviStatSessionHelper$Session:<init>	(Lcom/baidu/navisdk/comapi/statistics/NaviStatSessionHelper$1;)V
    //   137: astore_3
    //   138: iconst_0
    //   139: istore_0
    //   140: iload_0
    //   141: aload 4
    //   143: arraylength
    //   144: if_icmpge +33 -> 177
    //   147: aload 4
    //   149: iload_0
    //   150: aaload
    //   151: ifnull +202 -> 353
    //   154: ldc -114
    //   156: aload 4
    //   158: iload_0
    //   159: aaload
    //   160: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   163: ifne +190 -> 353
    //   166: aload_3
    //   167: aload 4
    //   169: iload_0
    //   170: aaload
    //   171: invokestatic 247	com/baidu/navisdk/comapi/statistics/NaviStatSessionHelper$Session:access$400	(Lcom/baidu/navisdk/comapi/statistics/NaviStatSessionHelper$Session;Ljava/lang/String;)V
    //   174: goto +179 -> 353
    //   177: aload 6
    //   179: aload_3
    //   180: invokeinterface 252 2 0
    //   185: pop
    //   186: goto -105 -> 81
    //   189: astore_2
    //   190: ldc -96
    //   192: aload_2
    //   193: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   196: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   199: goto -86 -> 113
    //   202: astore_3
    //   203: aload 4
    //   205: astore_2
    //   206: aload_3
    //   207: astore 4
    //   209: aload_2
    //   210: astore_3
    //   211: ldc -96
    //   213: aload 4
    //   215: invokevirtual 253	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   218: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   221: aload_2
    //   222: ifnull -109 -> 113
    //   225: aload_2
    //   226: invokevirtual 232	java/io/BufferedReader:close	()V
    //   229: goto -116 -> 113
    //   232: astore_2
    //   233: ldc -96
    //   235: aload_2
    //   236: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   239: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   242: goto -13 -> 229
    //   245: astore 4
    //   247: aload 5
    //   249: astore_2
    //   250: aload_2
    //   251: astore_3
    //   252: ldc -96
    //   254: aload 4
    //   256: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   259: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   262: aload_2
    //   263: ifnull -150 -> 113
    //   266: aload_2
    //   267: invokevirtual 232	java/io/BufferedReader:close	()V
    //   270: goto -157 -> 113
    //   273: astore_2
    //   274: ldc -96
    //   276: aload_2
    //   277: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   280: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: goto -13 -> 270
    //   286: astore_2
    //   287: aload_3
    //   288: ifnull +7 -> 295
    //   291: aload_3
    //   292: invokevirtual 232	java/io/BufferedReader:close	()V
    //   295: aload_2
    //   296: athrow
    //   297: astore_3
    //   298: ldc -96
    //   300: aload_3
    //   301: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   304: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: goto -12 -> 295
    //   310: astore 4
    //   312: aload_2
    //   313: astore_3
    //   314: aload 4
    //   316: astore_2
    //   317: goto -30 -> 287
    //   320: astore 4
    //   322: aload_2
    //   323: astore_3
    //   324: aload 4
    //   326: astore_2
    //   327: goto -40 -> 287
    //   330: astore 4
    //   332: goto -82 -> 250
    //   335: astore 4
    //   337: goto -87 -> 250
    //   340: astore 4
    //   342: goto -133 -> 209
    //   345: astore 4
    //   347: goto -138 -> 209
    //   350: goto -237 -> 113
    //   353: iload_0
    //   354: iconst_1
    //   355: iadd
    //   356: istore_0
    //   357: goto -217 -> 140
    // Local variable table:
    //   start	length	slot	name	signature
    //   139	218	0	i	int
    //   100	2	1	bool	boolean
    //   45	65	2	localObject1	Object
    //   189	4	2	localIOException1	IOException
    //   205	21	2	localObject2	Object
    //   232	4	2	localIOException2	IOException
    //   249	18	2	localObject3	Object
    //   273	4	2	localIOException3	IOException
    //   286	27	2	localObject4	Object
    //   316	11	2	localObject5	Object
    //   59	121	3	localObject6	Object
    //   202	5	3	localFileNotFoundException1	java.io.FileNotFoundException
    //   210	82	3	localObject7	Object
    //   297	4	3	localIOException4	IOException
    //   313	11	3	localObject8	Object
    //   61	153	4	localObject9	Object
    //   245	10	4	localIOException5	IOException
    //   310	5	4	localObject10	Object
    //   320	5	4	localObject11	Object
    //   330	1	4	localIOException6	IOException
    //   335	1	4	localIOException7	IOException
    //   340	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   345	1	4	localFileNotFoundException3	java.io.FileNotFoundException
    //   56	192	5	localObject12	Object
    //   7	171	6	localLinkedList	java.util.LinkedList
    // Exception table:
    //   from	to	target	type
    //   109	113	189	java/io/IOException
    //   63	79	202	java/io/FileNotFoundException
    //   225	229	232	java/io/IOException
    //   63	79	245	java/io/IOException
    //   266	270	273	java/io/IOException
    //   63	79	286	finally
    //   211	221	286	finally
    //   252	262	286	finally
    //   291	295	297	java/io/IOException
    //   140	147	310	finally
    //   154	174	310	finally
    //   177	186	310	finally
    //   81	86	320	finally
    //   94	101	320	finally
    //   121	138	320	finally
    //   140	147	330	java/io/IOException
    //   154	174	330	java/io/IOException
    //   177	186	330	java/io/IOException
    //   81	86	335	java/io/IOException
    //   94	101	335	java/io/IOException
    //   121	138	335	java/io/IOException
    //   140	147	340	java/io/FileNotFoundException
    //   154	174	340	java/io/FileNotFoundException
    //   177	186	340	java/io/FileNotFoundException
    //   81	86	345	java/io/FileNotFoundException
    //   94	101	345	java/io/FileNotFoundException
    //   121	138	345	java/io/FileNotFoundException
  }
  
  /* Error */
  private static Session getOfflineStateFromSessionFile()
  {
    // Byte code:
    //   0: new 107	java/io/File
    //   3: dup
    //   4: new 109	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   11: invokestatic 116	com/baidu/navisdk/util/common/SysOSAPI:getInstance	()Lcom/baidu/navisdk/util/common/SysOSAPI;
    //   14: invokevirtual 120	com/baidu/navisdk/util/common/SysOSAPI:GetSDCardCachePath	()Ljava/lang/String;
    //   17: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: ldc 126
    //   22: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 25
    //   27: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokespecial 131	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore_3
    //   37: aload_3
    //   38: invokevirtual 135	java/io/File:exists	()Z
    //   41: ifne +7 -> 48
    //   44: aconst_null
    //   45: astore_2
    //   46: aload_2
    //   47: areturn
    //   48: aconst_null
    //   49: astore 6
    //   51: aconst_null
    //   52: astore_2
    //   53: aconst_null
    //   54: astore 4
    //   56: new 8	com/baidu/navisdk/comapi/statistics/NaviStatSessionHelper$Session
    //   59: dup
    //   60: aconst_null
    //   61: invokespecial 243	com/baidu/navisdk/comapi/statistics/NaviStatSessionHelper$Session:<init>	(Lcom/baidu/navisdk/comapi/statistics/NaviStatSessionHelper$1;)V
    //   64: astore 5
    //   66: new 216	java/io/BufferedReader
    //   69: dup
    //   70: new 218	java/io/FileReader
    //   73: dup
    //   74: aload_3
    //   75: invokespecial 221	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   78: invokespecial 224	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   81: astore_3
    //   82: aload_3
    //   83: invokevirtual 227	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   86: astore_2
    //   87: aload_2
    //   88: ifnull +18 -> 106
    //   91: aload_2
    //   92: ifnull +14 -> 106
    //   95: aload_2
    //   96: ldc -114
    //   98: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   101: istore_1
    //   102: iload_1
    //   103: ifeq +14 -> 117
    //   106: aload_3
    //   107: ifnull +221 -> 328
    //   110: aload_3
    //   111: invokevirtual 232	java/io/BufferedReader:close	()V
    //   114: aload 5
    //   116: areturn
    //   117: aload_2
    //   118: ldc -20
    //   120: invokevirtual 240	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   123: astore_2
    //   124: iconst_0
    //   125: istore_0
    //   126: iload_0
    //   127: aload_2
    //   128: arraylength
    //   129: if_icmpge -47 -> 82
    //   132: aload_2
    //   133: iload_0
    //   134: aaload
    //   135: ifnull +39 -> 174
    //   138: ldc -114
    //   140: aload_2
    //   141: iload_0
    //   142: aaload
    //   143: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   146: ifne +28 -> 174
    //   149: aload 5
    //   151: aload_2
    //   152: iload_0
    //   153: aaload
    //   154: invokestatic 247	com/baidu/navisdk/comapi/statistics/NaviStatSessionHelper$Session:access$400	(Lcom/baidu/navisdk/comapi/statistics/NaviStatSessionHelper$Session;Ljava/lang/String;)V
    //   157: iload_0
    //   158: aload_2
    //   159: arraylength
    //   160: iconst_1
    //   161: isub
    //   162: if_icmpne +12 -> 174
    //   165: aload_2
    //   166: iload_0
    //   167: aaload
    //   168: invokestatic 257	com/baidu/navisdk/comapi/statistics/NaviStatSessionHelper:getEventTimeFromFile	(Ljava/lang/String;)J
    //   171: putstatic 75	com/baidu/navisdk/comapi/statistics/NaviStatSessionHelper:preActionTime	J
    //   174: iload_0
    //   175: iconst_1
    //   176: iadd
    //   177: istore_0
    //   178: goto -52 -> 126
    //   181: astore_2
    //   182: ldc -96
    //   184: aload_2
    //   185: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   188: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: goto -77 -> 114
    //   194: astore_2
    //   195: aload 4
    //   197: astore_3
    //   198: aload_2
    //   199: astore 4
    //   201: aload_3
    //   202: astore_2
    //   203: ldc -96
    //   205: aload 4
    //   207: invokevirtual 253	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   210: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload 5
    //   215: astore_2
    //   216: aload_3
    //   217: ifnull -171 -> 46
    //   220: aload_3
    //   221: invokevirtual 232	java/io/BufferedReader:close	()V
    //   224: aload 5
    //   226: areturn
    //   227: astore_2
    //   228: ldc -96
    //   230: aload_2
    //   231: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   234: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: goto -13 -> 224
    //   240: astore 4
    //   242: aload 6
    //   244: astore_3
    //   245: aload_3
    //   246: astore_2
    //   247: ldc -96
    //   249: aload 4
    //   251: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   254: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload 5
    //   259: astore_2
    //   260: aload_3
    //   261: ifnull -215 -> 46
    //   264: aload_3
    //   265: invokevirtual 232	java/io/BufferedReader:close	()V
    //   268: aload 5
    //   270: areturn
    //   271: astore_2
    //   272: ldc -96
    //   274: aload_2
    //   275: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   278: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   281: goto -13 -> 268
    //   284: astore_3
    //   285: aload_2
    //   286: ifnull +7 -> 293
    //   289: aload_2
    //   290: invokevirtual 232	java/io/BufferedReader:close	()V
    //   293: aload_3
    //   294: athrow
    //   295: astore_2
    //   296: ldc -96
    //   298: aload_2
    //   299: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   302: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   305: goto -12 -> 293
    //   308: astore 4
    //   310: aload_3
    //   311: astore_2
    //   312: aload 4
    //   314: astore_3
    //   315: goto -30 -> 285
    //   318: astore 4
    //   320: goto -75 -> 245
    //   323: astore 4
    //   325: goto -124 -> 201
    //   328: aload 5
    //   330: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   125	53	0	i	int
    //   101	2	1	bool	boolean
    //   45	121	2	localObject1	Object
    //   181	4	2	localIOException1	IOException
    //   194	5	2	localFileNotFoundException1	java.io.FileNotFoundException
    //   202	14	2	localObject2	Object
    //   227	4	2	localIOException2	IOException
    //   246	14	2	localObject3	Object
    //   271	19	2	localIOException3	IOException
    //   295	4	2	localIOException4	IOException
    //   311	1	2	localObject4	Object
    //   36	229	3	localObject5	Object
    //   284	27	3	localObject6	Object
    //   314	1	3	localObject7	Object
    //   54	152	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   240	10	4	localIOException5	IOException
    //   308	5	4	localObject8	Object
    //   318	1	4	localIOException6	IOException
    //   323	1	4	localFileNotFoundException3	java.io.FileNotFoundException
    //   64	265	5	localSession	Session
    //   49	194	6	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   110	114	181	java/io/IOException
    //   66	82	194	java/io/FileNotFoundException
    //   220	224	227	java/io/IOException
    //   66	82	240	java/io/IOException
    //   264	268	271	java/io/IOException
    //   66	82	284	finally
    //   203	213	284	finally
    //   247	257	284	finally
    //   289	293	295	java/io/IOException
    //   82	87	308	finally
    //   95	102	308	finally
    //   117	124	308	finally
    //   126	132	308	finally
    //   138	174	308	finally
    //   82	87	318	java/io/IOException
    //   95	102	318	java/io/IOException
    //   117	124	318	java/io/IOException
    //   126	132	318	java/io/IOException
    //   138	174	318	java/io/IOException
    //   82	87	323	java/io/FileNotFoundException
    //   95	102	323	java/io/FileNotFoundException
    //   117	124	323	java/io/FileNotFoundException
    //   126	132	323	java/io/FileNotFoundException
    //   138	174	323	java/io/FileNotFoundException
  }
  
  private static File getTestSessionFile()
  {
    if (testSessionFileName == null)
    {
      long l = Long.parseLong(new SimpleDateFormat("yyyyMMdd").format(new Date()) + "");
      testSessionFileName = l + "testLogFile";
    }
    File localFile = new File(SysOSAPI.getInstance().GetSDCardCachePath() + "/" + "testLog" + "/" + testSessionFileName);
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      return localFile;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
    return localFile;
  }
  
  public static void initSession()
  {
    preActionTime = System.currentTimeMillis() / 1000L;
    mSession = getOfflineStateFromSessionFile();
    if (mSession == null) {
      mSession = new Session(null);
    }
  }
  
  private static boolean needDelete(String paramString, long paramLong)
  {
    try
    {
      if (paramString.length() <= 7) {
        return true;
      }
      long l = Long.parseLong(paramString.substring(0, 7));
      if (paramLong - l <= 100L) {
        return false;
      }
    }
    catch (Exception paramString) {}
    return true;
  }
  
  private static boolean needUploadAtOnce()
  {
    long l = System.currentTimeMillis() / 1000L;
    if (l - preActionTime >= TIME_OUT.longValue())
    {
      preActionTime = l;
      return true;
    }
    preActionTime = l;
    return false;
  }
  
  public static boolean pushNaviSessionStatistics(Session paramSession)
  {
    if ((paramSession == null) || (paramSession.size() == 0)) {
      LogUtil.e("NaviStatSessionHelper", "push params is null");
    }
    for (;;)
    {
      return false;
      pushNaviSessionStatisticsRet = 0;
      NaviStatHelper.NAVI_URL = NaviStatHelper.NAVI_URL_ONLINE;
      Object localObject1 = new ArrayList();
      if (sStatParamsPrefixs.isEmpty())
      {
        NaviStatHelper.initStatParamsPrefix(sStatParamsPrefixs);
        sStatParamsPrefixs.add(new BasicNameValuePair("isSession", "1"));
      }
      NaviStatHelper.initGlobalStatParams(sGlobalStatParamsPrefixs);
      if (sGlobalStatParamsPrefixs != null) {
        ((List)localObject1).addAll(sGlobalStatParamsPrefixs);
      }
      ((List)localObject1).addAll(sStatParamsPrefixs);
      ((List)localObject1).addAll(paramSession.getSStatCacheContent());
      Object localObject2 = new BNHttpParams();
      ((BNHttpParams)localObject2).isAsync = false;
      HashMap localHashMap = BNHttpCenterHelper.formatParams((List)localObject1);
      BNHttpCenter.getInstance().post(NaviStatHelper.NAVI_URL, localHashMap, new BNHttpTextResponseHandler()
      {
        public void onFailure(int paramAnonymousInt, String paramAnonymousString, Throwable paramAnonymousThrowable)
        {
          LogUtil.e("NaviStatSessionHelper", "onFailure().statusCode=" + paramAnonymousInt);
          NaviStatSessionHelper.access$602(paramAnonymousInt);
        }
        
        public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
        {
          LogUtil.e("NaviStatSessionHelper", "onSuccess().statusCode=" + paramAnonymousInt);
          NaviStatSessionHelper.access$602(paramAnonymousInt);
        }
      }, (BNHttpParams)localObject2);
      if (((pushNaviSessionStatisticsRet == 200) || (pushNaviSessionStatisticsRet == -1)) && (LogUtil.LOGGABLE))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (NameValuePair)((Iterator)localObject1).next();
          LogUtil.e("NaviStatHelper", "push pair name = " + ((NameValuePair)localObject2).getName() + " value = " + ((NameValuePair)localObject2).getValue());
        }
      }
      if ((pushNaviSessionStatisticsRet == 200) || (pushNaviSessionStatisticsRet == -1)) {
        statisticsSessionTest(paramSession, null);
      }
      while ((pushNaviSessionStatisticsRet == 200) || (pushNaviSessionStatisticsRet == -1))
      {
        return true;
        statisticsSessionTest(paramSession, Integer.valueOf(pushNaviSessionStatisticsRet));
      }
    }
  }
  
  public static void pushNaviStatistics(int paramInt1, int paramInt2, String paramString)
  {
    if (mSession == null) {
      mSession = new Session(null);
    }
    statisticsTest(paramString);
    int j = 0;
    int k = mSession.size();
    Object localObject1;
    if ((paramInt1 != 50003) && (needUploadAtOnce()))
    {
      localObject1 = mSession.copy();
      mSession.clear();
      uploadAComSession((Session)localObject1);
    }
    Object localObject2 = null;
    int i;
    if (paramInt1 == 50003)
    {
      localObject1 = mSession.copy();
      ((Session)localObject1).add(new BasicNameValuePair("item" + k, paramString));
      mSession.clear();
      i = 1;
    }
    for (;;)
    {
      if (i == 0)
      {
        mSession.add(new BasicNameValuePair("item" + k, paramString));
        writeSynSessionStatLogToFile(paramString);
      }
      preActionTime = paramInt2;
      preEventID = paramInt1;
      uploadAComSession((Session)localObject1);
      return;
      localObject1 = localObject2;
      i = j;
      if (preEventID != -1) {
        if (preEventID != 50002)
        {
          localObject1 = localObject2;
          i = j;
          if (preEventID != 50001) {}
        }
        else
        {
          localObject1 = localObject2;
          i = j;
          if (preActionTime != -1L)
          {
            localObject1 = localObject2;
            i = j;
            if (paramInt2 - preActionTime >= TIME_OUT.longValue())
            {
              localObject1 = mSession.copy();
              mSession.clear();
              mSession.add(new BasicNameValuePair("item" + k, paramString));
              writeSynSessionStatLogToFile(paramString);
              i = 1;
            }
          }
        }
      }
    }
  }
  
  public static void saveSessionCacheInNaviCrash(String paramString)
  {
    if (mSession == null) {
      return;
    }
    int i = mSession.size();
    Session localSession = mSession.copy();
    localSession.add(new BasicNameValuePair("item" + i, paramString));
    mSession.clear();
    clearTxtFile("statSessionLog.txt");
    writeOfflineComSessionStatLogToFile(localSession);
  }
  
  /* Error */
  private static void statisticsSessionTest(Session paramSession, Integer paramInteger)
  {
    // Byte code:
    //   0: getstatic 361	com/baidu/navisdk/util/common/LogUtil:LOGGABLE	Z
    //   3: ifne +4 -> 7
    //   6: return
    //   7: getstatic 85	com/baidu/navisdk/comapi/statistics/NaviStatSessionHelper:hasTestIninted	Z
    //   10: ifne +10 -> 20
    //   13: invokestatic 437	com/baidu/navisdk/comapi/statistics/NaviStatSessionHelper:testSessionInit	()V
    //   16: iconst_1
    //   17: putstatic 85	com/baidu/navisdk/comapi/statistics/NaviStatSessionHelper:hasTestIninted	Z
    //   20: invokestatic 439	com/baidu/navisdk/comapi/statistics/NaviStatSessionHelper:getTestSessionFile	()Ljava/io/File;
    //   23: astore_3
    //   24: aload_3
    //   25: invokevirtual 135	java/io/File:exists	()Z
    //   28: ifne +8 -> 36
    //   31: aload_3
    //   32: invokevirtual 206	java/io/File:createNewFile	()Z
    //   35: pop
    //   36: aconst_null
    //   37: astore_2
    //   38: aconst_null
    //   39: astore 4
    //   41: new 137	java/io/FileOutputStream
    //   44: dup
    //   45: aload_3
    //   46: iconst_1
    //   47: invokespecial 140	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   50: astore_3
    //   51: ldc_w 441
    //   54: invokestatic 445	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   57: astore_2
    //   58: aload_0
    //   59: invokestatic 334	com/baidu/navisdk/comapi/statistics/NaviStatSessionHelper$Session:access$500	(Lcom/baidu/navisdk/comapi/statistics/NaviStatSessionHelper$Session;)Ljava/util/ArrayList;
    //   62: invokevirtual 446	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   65: astore_0
    //   66: aload_0
    //   67: invokeinterface 370 1 0
    //   72: ifeq +176 -> 248
    //   75: aload_0
    //   76: invokeinterface 374 1 0
    //   81: checkcast 376	org/apache/http/NameValuePair
    //   84: astore 4
    //   86: aload_1
    //   87: ifnull +39 -> 126
    //   90: aload_3
    //   91: new 109	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 448
    //   101: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_1
    //   105: invokevirtual 451	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   108: ldc_w 453
    //   111: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: ldc_w 455
    //   120: invokevirtual 458	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   123: invokevirtual 152	java/io/FileOutputStream:write	([B)V
    //   126: aload_3
    //   127: new 109	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   134: getstatic 93	com/baidu/navisdk/comapi/statistics/NaviStatSessionHelper:testSessionCount	I
    //   137: invokevirtual 421	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   140: ldc_w 453
    //   143: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: new 261	java/text/SimpleDateFormat
    //   149: dup
    //   150: ldc_w 460
    //   153: invokespecial 264	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
    //   156: new 266	java/util/Date
    //   159: dup
    //   160: invokespecial 267	java/util/Date:<init>	()V
    //   163: invokevirtual 271	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   166: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: ldc_w 453
    //   172: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: aload 4
    //   177: invokeinterface 388 1 0
    //   182: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: ldc_w 455
    //   191: invokevirtual 458	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   194: invokevirtual 152	java/io/FileOutputStream:write	([B)V
    //   197: aload_3
    //   198: aload_2
    //   199: invokevirtual 148	java/lang/String:getBytes	()[B
    //   202: invokevirtual 152	java/io/FileOutputStream:write	([B)V
    //   205: goto -139 -> 66
    //   208: astore_1
    //   209: aload_3
    //   210: astore_0
    //   211: aload_0
    //   212: astore_2
    //   213: ldc_w 462
    //   216: aload_1
    //   217: invokevirtual 170	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   220: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: aload_0
    //   224: ifnull +7 -> 231
    //   227: aload_0
    //   228: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   231: getstatic 93	com/baidu/navisdk/comapi/statistics/NaviStatSessionHelper:testSessionCount	I
    //   234: iconst_1
    //   235: iadd
    //   236: putstatic 93	com/baidu/navisdk/comapi/statistics/NaviStatSessionHelper:testSessionCount	I
    //   239: return
    //   240: astore_2
    //   241: aload_2
    //   242: invokevirtual 209	java/io/IOException:printStackTrace	()V
    //   245: goto -209 -> 36
    //   248: aload_3
    //   249: invokevirtual 155	java/io/FileOutputStream:flush	()V
    //   252: ldc_w 378
    //   255: ldc_w 463
    //   258: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   261: aload_3
    //   262: ifnull +76 -> 338
    //   265: aload_3
    //   266: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   269: goto -38 -> 231
    //   272: astore_0
    //   273: ldc_w 378
    //   276: aload_0
    //   277: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   280: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: goto -14 -> 269
    //   286: astore_0
    //   287: ldc_w 378
    //   290: aload_0
    //   291: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   294: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: goto -66 -> 231
    //   300: astore_0
    //   301: aload_2
    //   302: ifnull +7 -> 309
    //   305: aload_2
    //   306: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   309: aload_0
    //   310: athrow
    //   311: astore_1
    //   312: ldc_w 378
    //   315: aload_1
    //   316: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   319: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   322: goto -13 -> 309
    //   325: astore_0
    //   326: aload_3
    //   327: astore_2
    //   328: goto -27 -> 301
    //   331: astore_1
    //   332: aload 4
    //   334: astore_0
    //   335: goto -124 -> 211
    //   338: goto -107 -> 231
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	341	0	paramSession	Session
    //   0	341	1	paramInteger	Integer
    //   37	176	2	localObject1	Object
    //   240	66	2	localIOException	IOException
    //   327	1	2	localObject2	Object
    //   23	304	3	localObject3	Object
    //   39	294	4	localNameValuePair	NameValuePair
    // Exception table:
    //   from	to	target	type
    //   51	66	208	java/lang/Exception
    //   66	86	208	java/lang/Exception
    //   90	126	208	java/lang/Exception
    //   126	205	208	java/lang/Exception
    //   248	261	208	java/lang/Exception
    //   31	36	240	java/io/IOException
    //   265	269	272	java/io/IOException
    //   227	231	286	java/io/IOException
    //   41	51	300	finally
    //   213	223	300	finally
    //   305	309	311	java/io/IOException
    //   51	66	325	finally
    //   66	86	325	finally
    //   90	126	325	finally
    //   126	205	325	finally
    //   248	261	325	finally
    //   41	51	331	java/lang/Exception
  }
  
  private static void statisticsTest(String paramString)
  {
    if (!LogUtil.LOGGABLE) {}
  }
  
  private static void testSessionInit()
  {
    long l = Long.parseLong(new SimpleDateFormat("yyyyMMdd").format(new Date()) + "");
    Object localObject1 = new File(SysOSAPI.getInstance().GetSDCardCachePath() + "/" + "testLog");
    if (((File)localObject1).exists())
    {
      if (((File)localObject1).isDirectory())
      {
        localObject1 = ((File)localObject1).listFiles();
        if ((localObject1 != null) && (localObject1.length > 0))
        {
          int j = localObject1.length;
          int i = 0;
          while (i < j)
          {
            Object localObject2 = localObject1[i];
            if (needDelete(((File)localObject2).getName(), l)) {
              ((File)localObject2).delete();
            }
            i += 1;
          }
        }
      }
    }
    else {
      ((File)localObject1).mkdirs();
    }
    localObject1 = new File(SysOSAPI.getInstance().GetSDCardCachePath() + "/" + "testLog" + "/" + l + "testLogFile");
    if (!((File)localObject1).exists()) {}
    try
    {
      ((File)localObject1).createNewFile();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  private static void uploadAComSession(Session paramSession)
  {
    if (paramSession != null)
    {
      clearTxtFile("statSessionLog.txt");
      if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
        break label58;
      }
      boolean bool = pushNaviSessionStatistics(paramSession);
      LogUtil.e("NaviStatHelper", "Send Statistics result : " + bool);
      if (!bool) {
        writeOfflineComSessionStatLogToFile(paramSession);
      }
    }
    return;
    label58:
    writeOfflineComSessionStatLogToFile(paramSession);
  }
  
  public static void writeCacheToFile() {}
  
  /* Error */
  public static void writeOfflineComSessionStatLogToFile(Session paramSession)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 298	com/baidu/navisdk/comapi/statistics/NaviStatSessionHelper$Session:size	()I
    //   8: ifgt +4 -> 12
    //   11: return
    //   12: aload_0
    //   13: invokestatic 334	com/baidu/navisdk/comapi/statistics/NaviStatSessionHelper$Session:access$500	(Lcom/baidu/navisdk/comapi/statistics/NaviStatSessionHelper$Session;)Ljava/util/ArrayList;
    //   16: astore_3
    //   17: aconst_null
    //   18: astore_0
    //   19: aconst_null
    //   20: astore_2
    //   21: ldc 22
    //   23: invokestatic 501	com/baidu/navisdk/comapi/statistics/NaviStatSessionHelper:getOfflineSessionStatLogFile	(Ljava/lang/String;)Ljava/io/File;
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull -17 -> 11
    //   31: new 137	java/io/FileOutputStream
    //   34: dup
    //   35: aload_1
    //   36: iconst_1
    //   37: invokespecial 140	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   40: astore_1
    //   41: ldc -114
    //   43: astore_0
    //   44: ldc_w 441
    //   47: invokestatic 445	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   50: astore_2
    //   51: aload_3
    //   52: invokevirtual 446	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   55: astore_3
    //   56: aload_3
    //   57: invokeinterface 370 1 0
    //   62: ifeq +62 -> 124
    //   65: aload_3
    //   66: invokeinterface 374 1 0
    //   71: checkcast 376	org/apache/http/NameValuePair
    //   74: invokeinterface 388 1 0
    //   79: astore 4
    //   81: aload 4
    //   83: ifnull -27 -> 56
    //   86: ldc -114
    //   88: aload 4
    //   90: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   93: ifne -37 -> 56
    //   96: new 109	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   103: aload_0
    //   104: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: aload 4
    //   109: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: ldc -20
    //   114: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: astore_0
    //   121: goto -65 -> 56
    //   124: aload_1
    //   125: aload_0
    //   126: ldc_w 455
    //   129: invokevirtual 458	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   132: invokevirtual 152	java/io/FileOutputStream:write	([B)V
    //   135: aload_1
    //   136: aload_2
    //   137: invokevirtual 148	java/lang/String:getBytes	()[B
    //   140: invokevirtual 152	java/io/FileOutputStream:write	([B)V
    //   143: aload_1
    //   144: invokevirtual 155	java/io/FileOutputStream:flush	()V
    //   147: ldc -96
    //   149: ldc_w 503
    //   152: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: aload_1
    //   156: ifnull +95 -> 251
    //   159: aload_1
    //   160: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   163: return
    //   164: astore_0
    //   165: ldc -96
    //   167: aload_0
    //   168: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   171: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: goto -11 -> 163
    //   177: astore_0
    //   178: aload_2
    //   179: astore_1
    //   180: aload_0
    //   181: astore_2
    //   182: aload_1
    //   183: astore_0
    //   184: ldc -96
    //   186: aload_2
    //   187: invokevirtual 170	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   190: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: aload_1
    //   194: ifnull -183 -> 11
    //   197: aload_1
    //   198: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   201: return
    //   202: astore_0
    //   203: ldc -96
    //   205: aload_0
    //   206: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   209: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   212: goto -11 -> 201
    //   215: astore_1
    //   216: aload_0
    //   217: ifnull +7 -> 224
    //   220: aload_0
    //   221: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   224: aload_1
    //   225: athrow
    //   226: astore_0
    //   227: ldc -96
    //   229: aload_0
    //   230: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   233: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   236: goto -12 -> 224
    //   239: astore_2
    //   240: aload_1
    //   241: astore_0
    //   242: aload_2
    //   243: astore_1
    //   244: goto -28 -> 216
    //   247: astore_2
    //   248: goto -66 -> 182
    //   251: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	paramSession	Session
    //   26	172	1	localObject1	Object
    //   215	26	1	localObject2	Object
    //   243	1	1	localObject3	Object
    //   20	167	2	localObject4	Object
    //   239	4	2	localObject5	Object
    //   247	1	2	localException	Exception
    //   16	50	3	localObject6	Object
    //   79	29	4	str	String
    // Exception table:
    //   from	to	target	type
    //   159	163	164	java/io/IOException
    //   31	41	177	java/lang/Exception
    //   197	201	202	java/io/IOException
    //   31	41	215	finally
    //   184	193	215	finally
    //   220	224	226	java/io/IOException
    //   44	56	239	finally
    //   56	81	239	finally
    //   86	121	239	finally
    //   124	155	239	finally
    //   44	56	247	java/lang/Exception
    //   56	81	247	java/lang/Exception
    //   86	121	247	java/lang/Exception
    //   124	155	247	java/lang/Exception
  }
  
  /* Error */
  private static void writeOfflineSessionStatLogToFile(Session paramSession)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: invokevirtual 298	com/baidu/navisdk/comapi/statistics/NaviStatSessionHelper$Session:size	()I
    //   8: ifgt +4 -> 12
    //   11: return
    //   12: aload_0
    //   13: invokestatic 334	com/baidu/navisdk/comapi/statistics/NaviStatSessionHelper$Session:access$500	(Lcom/baidu/navisdk/comapi/statistics/NaviStatSessionHelper$Session;)Ljava/util/ArrayList;
    //   16: astore_3
    //   17: aconst_null
    //   18: astore_0
    //   19: aconst_null
    //   20: astore_2
    //   21: ldc 25
    //   23: invokestatic 501	com/baidu/navisdk/comapi/statistics/NaviStatSessionHelper:getOfflineSessionStatLogFile	(Ljava/lang/String;)Ljava/io/File;
    //   26: astore_1
    //   27: aload_1
    //   28: ifnull -17 -> 11
    //   31: new 137	java/io/FileOutputStream
    //   34: dup
    //   35: aload_1
    //   36: iconst_0
    //   37: invokespecial 140	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   40: astore_1
    //   41: ldc -114
    //   43: astore_0
    //   44: aload_3
    //   45: invokevirtual 446	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   48: astore_2
    //   49: aload_2
    //   50: invokeinterface 370 1 0
    //   55: ifeq +58 -> 113
    //   58: aload_2
    //   59: invokeinterface 374 1 0
    //   64: checkcast 376	org/apache/http/NameValuePair
    //   67: invokeinterface 388 1 0
    //   72: astore_3
    //   73: aload_3
    //   74: ifnull -25 -> 49
    //   77: ldc -114
    //   79: aload_3
    //   80: invokevirtual 231	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   83: ifne -34 -> 49
    //   86: new 109	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   93: aload_0
    //   94: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: aload_3
    //   98: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: ldc -20
    //   103: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: astore_0
    //   110: goto -61 -> 49
    //   113: aload_1
    //   114: aload_0
    //   115: ldc_w 455
    //   118: invokevirtual 458	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   121: invokevirtual 152	java/io/FileOutputStream:write	([B)V
    //   124: aload_1
    //   125: invokevirtual 155	java/io/FileOutputStream:flush	()V
    //   128: ldc -96
    //   130: ldc_w 503
    //   133: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_1
    //   137: ifnull +95 -> 232
    //   140: aload_1
    //   141: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   144: return
    //   145: astore_0
    //   146: ldc -96
    //   148: aload_0
    //   149: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   152: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   155: goto -11 -> 144
    //   158: astore_0
    //   159: aload_2
    //   160: astore_1
    //   161: aload_0
    //   162: astore_2
    //   163: aload_1
    //   164: astore_0
    //   165: ldc -96
    //   167: aload_2
    //   168: invokevirtual 170	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   171: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: aload_1
    //   175: ifnull -164 -> 11
    //   178: aload_1
    //   179: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   182: return
    //   183: astore_0
    //   184: ldc -96
    //   186: aload_0
    //   187: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   190: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: goto -11 -> 182
    //   196: astore_1
    //   197: aload_0
    //   198: ifnull +7 -> 205
    //   201: aload_0
    //   202: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   205: aload_1
    //   206: athrow
    //   207: astore_0
    //   208: ldc -96
    //   210: aload_0
    //   211: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   214: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: goto -12 -> 205
    //   220: astore_2
    //   221: aload_1
    //   222: astore_0
    //   223: aload_2
    //   224: astore_1
    //   225: goto -28 -> 197
    //   228: astore_2
    //   229: goto -66 -> 163
    //   232: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	paramSession	Session
    //   26	153	1	localObject1	Object
    //   196	26	1	localObject2	Object
    //   224	1	1	localObject3	Object
    //   20	148	2	localObject4	Object
    //   220	4	2	localObject5	Object
    //   228	1	2	localException	Exception
    //   16	82	3	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   140	144	145	java/io/IOException
    //   31	41	158	java/lang/Exception
    //   178	182	183	java/io/IOException
    //   31	41	196	finally
    //   165	174	196	finally
    //   201	205	207	java/io/IOException
    //   44	49	220	finally
    //   49	73	220	finally
    //   77	110	220	finally
    //   113	136	220	finally
    //   44	49	228	java/lang/Exception
    //   49	73	228	java/lang/Exception
    //   77	110	228	java/lang/Exception
    //   113	136	228	java/lang/Exception
  }
  
  /* Error */
  private static void writeSynSessionStatLogToFile(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: ldc 25
    //   7: invokestatic 501	com/baidu/navisdk/comapi/statistics/NaviStatSessionHelper:getOfflineSessionStatLogFile	(Ljava/lang/String;)Ljava/io/File;
    //   10: astore_2
    //   11: aconst_null
    //   12: astore_1
    //   13: aconst_null
    //   14: astore_3
    //   15: aload_2
    //   16: ifnull -12 -> 4
    //   19: new 137	java/io/FileOutputStream
    //   22: dup
    //   23: aload_2
    //   24: iconst_1
    //   25: invokespecial 140	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   28: astore_2
    //   29: new 109	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   36: aload_0
    //   37: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc -20
    //   42: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: astore_0
    //   49: aload_2
    //   50: aload_0
    //   51: ldc_w 455
    //   54: invokevirtual 458	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   57: invokevirtual 152	java/io/FileOutputStream:write	([B)V
    //   60: aload_2
    //   61: invokevirtual 155	java/io/FileOutputStream:flush	()V
    //   64: ldc -96
    //   66: new 109	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 110	java/lang/StringBuilder:<init>	()V
    //   73: ldc_w 506
    //   76: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_0
    //   80: invokevirtual 124	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: invokevirtual 129	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: aload_2
    //   90: ifnull +95 -> 185
    //   93: aload_2
    //   94: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   97: return
    //   98: astore_0
    //   99: ldc -96
    //   101: aload_0
    //   102: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   105: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   108: goto -11 -> 97
    //   111: astore_2
    //   112: aload_3
    //   113: astore_0
    //   114: aload_0
    //   115: astore_1
    //   116: ldc -96
    //   118: aload_2
    //   119: invokevirtual 170	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   122: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload_0
    //   126: ifnull -122 -> 4
    //   129: aload_0
    //   130: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   133: return
    //   134: astore_0
    //   135: ldc -96
    //   137: aload_0
    //   138: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   141: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   144: goto -11 -> 133
    //   147: astore_0
    //   148: aload_1
    //   149: ifnull +7 -> 156
    //   152: aload_1
    //   153: invokevirtual 158	java/io/FileOutputStream:close	()V
    //   156: aload_0
    //   157: athrow
    //   158: astore_1
    //   159: ldc -96
    //   161: aload_1
    //   162: invokevirtual 163	java/io/IOException:getMessage	()Ljava/lang/String;
    //   165: invokestatic 169	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: goto -12 -> 156
    //   171: astore_0
    //   172: aload_2
    //   173: astore_1
    //   174: goto -26 -> 148
    //   177: astore_1
    //   178: aload_2
    //   179: astore_0
    //   180: aload_1
    //   181: astore_2
    //   182: goto -68 -> 114
    //   185: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	186	0	paramString	String
    //   12	141	1	str	String
    //   158	4	1	localIOException	IOException
    //   173	1	1	localException1	Exception
    //   177	4	1	localException2	Exception
    //   10	84	2	localObject1	Object
    //   111	68	2	localException3	Exception
    //   181	1	2	localObject2	Object
    //   14	99	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   93	97	98	java/io/IOException
    //   19	29	111	java/lang/Exception
    //   129	133	134	java/io/IOException
    //   19	29	147	finally
    //   116	125	147	finally
    //   152	156	158	java/io/IOException
    //   29	89	171	finally
    //   29	89	177	java/lang/Exception
  }
  
  public static class Session
  {
    private ArrayList<NameValuePair> sStatCacheContent = null;
    
    private void add(String paramString)
    {
      if (this.sStatCacheContent == null) {
        this.sStatCacheContent = new ArrayList();
      }
      this.sStatCacheContent.add(new BasicNameValuePair("item" + size(), paramString));
    }
    
    private void add(NameValuePair paramNameValuePair)
    {
      if (this.sStatCacheContent == null) {
        this.sStatCacheContent = new ArrayList();
      }
      this.sStatCacheContent.add(paramNameValuePair);
    }
    
    private void clear()
    {
      if (this.sStatCacheContent == null) {
        this.sStatCacheContent = new ArrayList();
      }
      this.sStatCacheContent.clear();
    }
    
    private Session copy()
    {
      if (this.sStatCacheContent == null) {
        this.sStatCacheContent = new ArrayList();
      }
      Session localSession = new Session();
      localSession.sStatCacheContent.addAll(this.sStatCacheContent);
      return localSession;
    }
    
    private ArrayList<NameValuePair> getSStatCacheContent()
    {
      return this.sStatCacheContent;
    }
    
    public int size()
    {
      if (this.sStatCacheContent == null)
      {
        this.sStatCacheContent = new ArrayList();
        return 0;
      }
      return this.sStatCacheContent.size();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/statistics/NaviStatSessionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */