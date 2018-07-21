package com.baidu.navisdk.logic.commandparser;

import android.os.Handler;
import android.os.Message;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.HttpGetBase;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.util.common.LogUtil;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.json.JSONObject;

public class CmdGeneralHttpRequestDataFunc
  extends HttpGetBase
{
  public static final int K_TIMEOUT = 500000;
  public static final String TAG = CmdGeneralHttpRequestDataFunc.class.getSimpleName();
  private static HashMap<ReqData, Callback> sCallbackMaps = new HashMap();
  private Callback mCallback = null;
  
  public static void addFunc(ReqData paramReqData, Callback paramCallback)
  {
    sCallbackMaps.put(paramReqData, paramCallback);
  }
  
  /* Error */
  private CommandResult requestFile()
  {
    // Byte code:
    //   0: getstatic 27	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:TAG	Ljava/lang/String;
    //   3: ldc 49
    //   5: invokestatic 55	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   8: invokestatic 61	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   11: invokestatic 67	com/baidu/navisdk/util/common/NetworkUtils:isNetworkAvailable	(Landroid/content/Context;)Z
    //   14: ifne +23 -> 37
    //   17: aload_0
    //   18: getfield 71	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:mRet	Lcom/baidu/navisdk/logic/CommandResult;
    //   21: iconst_1
    //   22: invokestatic 77	com/baidu/navisdk/logic/NaviErrCode:getSDKError	(I)I
    //   25: invokevirtual 83	com/baidu/navisdk/logic/CommandResult:set	(I)V
    //   28: aload_0
    //   29: getfield 71	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:mRet	Lcom/baidu/navisdk/logic/CommandResult;
    //   32: astore 6
    //   34: aload 6
    //   36: areturn
    //   37: aload_0
    //   38: invokevirtual 86	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:getUrl	()Ljava/lang/String;
    //   41: astore 15
    //   43: aload 15
    //   45: ifnull +11 -> 56
    //   48: aload 15
    //   50: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   53: ifeq +20 -> 73
    //   56: aload_0
    //   57: getfield 71	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:mRet	Lcom/baidu/navisdk/logic/CommandResult;
    //   60: bipush 6
    //   62: invokestatic 95	com/baidu/navisdk/logic/NaviErrCode:getAppError	(I)I
    //   65: invokevirtual 83	com/baidu/navisdk/logic/CommandResult:set	(I)V
    //   68: aload_0
    //   69: getfield 71	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:mRet	Lcom/baidu/navisdk/logic/CommandResult;
    //   72: areturn
    //   73: aload 15
    //   75: bipush 46
    //   77: invokevirtual 100	java/lang/String:lastIndexOf	(I)I
    //   80: istore_1
    //   81: iload_1
    //   82: iflt +14 -> 96
    //   85: iload_1
    //   86: aload 15
    //   88: invokevirtual 104	java/lang/String:length	()I
    //   91: iconst_1
    //   92: isub
    //   93: if_icmplt +20 -> 113
    //   96: aload_0
    //   97: getfield 71	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:mRet	Lcom/baidu/navisdk/logic/CommandResult;
    //   100: bipush 6
    //   102: invokestatic 95	com/baidu/navisdk/logic/NaviErrCode:getAppError	(I)I
    //   105: invokevirtual 83	com/baidu/navisdk/logic/CommandResult:set	(I)V
    //   108: aload_0
    //   109: getfield 71	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:mRet	Lcom/baidu/navisdk/logic/CommandResult;
    //   112: areturn
    //   113: aload 15
    //   115: iload_1
    //   116: aload 15
    //   118: invokevirtual 104	java/lang/String:length	()I
    //   121: invokevirtual 108	java/lang/String:substring	(II)Ljava/lang/String;
    //   124: astore 8
    //   126: aload 8
    //   128: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   131: ifeq +20 -> 151
    //   134: aload_0
    //   135: getfield 71	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:mRet	Lcom/baidu/navisdk/logic/CommandResult;
    //   138: bipush 6
    //   140: invokestatic 95	com/baidu/navisdk/logic/NaviErrCode:getAppError	(I)I
    //   143: invokevirtual 83	com/baidu/navisdk/logic/CommandResult:set	(I)V
    //   146: aload_0
    //   147: getfield 71	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:mRet	Lcom/baidu/navisdk/logic/CommandResult;
    //   150: areturn
    //   151: aload 15
    //   153: invokestatic 114	com/baidu/navisdk/util/common/MD5:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   156: astore 10
    //   158: aload_0
    //   159: invokevirtual 117	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:getSDCardFilePath	()Ljava/lang/String;
    //   162: astore 16
    //   164: aload 16
    //   166: ifnull +11 -> 177
    //   169: aload 16
    //   171: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   174: ifeq +20 -> 194
    //   177: aload_0
    //   178: getfield 71	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:mRet	Lcom/baidu/navisdk/logic/CommandResult;
    //   181: bipush 21
    //   183: invokestatic 95	com/baidu/navisdk/logic/NaviErrCode:getAppError	(I)I
    //   186: invokevirtual 83	com/baidu/navisdk/logic/CommandResult:set	(I)V
    //   189: aload_0
    //   190: getfield 71	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:mRet	Lcom/baidu/navisdk/logic/CommandResult;
    //   193: areturn
    //   194: aload_0
    //   195: invokevirtual 120	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:getFilePrefix	()Ljava/lang/String;
    //   198: astore 7
    //   200: new 122	java/lang/StringBuilder
    //   203: dup
    //   204: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   207: astore 9
    //   209: aload 7
    //   211: ifnull +15 -> 226
    //   214: aload 7
    //   216: astore 6
    //   218: aload 7
    //   220: invokestatic 92	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   223: ifeq +7 -> 230
    //   226: ldc 125
    //   228: astore 6
    //   230: aload 9
    //   232: aload 6
    //   234: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: aload 10
    //   239: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: aload 8
    //   244: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: astore 18
    //   252: new 122	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   259: aload_0
    //   260: invokevirtual 117	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:getSDCardFilePath	()Ljava/lang/String;
    //   263: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: getstatic 137	java/io/File:separator	Ljava/lang/String;
    //   269: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: aload 18
    //   274: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   280: astore 6
    //   282: getstatic 27	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:TAG	Ljava/lang/String;
    //   285: new 122	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   292: ldc -117
    //   294: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload 6
    //   299: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   302: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   305: invokestatic 55	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   308: aload_0
    //   309: aload 6
    //   311: invokevirtual 143	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:responseAudioFilePath	(Ljava/lang/String;)V
    //   314: aload_0
    //   315: invokevirtual 147	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:getFileDownloadPos	()J
    //   318: lstore_2
    //   319: aload_0
    //   320: invokevirtual 150	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:getFileSize	()J
    //   323: lstore 4
    //   325: lload_2
    //   326: lconst_0
    //   327: lcmp
    //   328: ifge +20 -> 348
    //   331: aload_0
    //   332: getfield 71	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:mRet	Lcom/baidu/navisdk/logic/CommandResult;
    //   335: bipush 22
    //   337: invokestatic 95	com/baidu/navisdk/logic/NaviErrCode:getAppError	(I)I
    //   340: invokevirtual 83	com/baidu/navisdk/logic/CommandResult:set	(I)V
    //   343: aload_0
    //   344: getfield 71	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:mRet	Lcom/baidu/navisdk/logic/CommandResult;
    //   347: areturn
    //   348: lload 4
    //   350: lconst_0
    //   351: lcmp
    //   352: ifge +20 -> 372
    //   355: aload_0
    //   356: getfield 71	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:mRet	Lcom/baidu/navisdk/logic/CommandResult;
    //   359: bipush 22
    //   361: invokestatic 95	com/baidu/navisdk/logic/NaviErrCode:getAppError	(I)I
    //   364: invokevirtual 83	com/baidu/navisdk/logic/CommandResult:set	(I)V
    //   367: aload_0
    //   368: getfield 71	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:mRet	Lcom/baidu/navisdk/logic/CommandResult;
    //   371: areturn
    //   372: lload 4
    //   374: lload_2
    //   375: lcmp
    //   376: ifge +20 -> 396
    //   379: aload_0
    //   380: getfield 71	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:mRet	Lcom/baidu/navisdk/logic/CommandResult;
    //   383: bipush 22
    //   385: invokestatic 95	com/baidu/navisdk/logic/NaviErrCode:getAppError	(I)I
    //   388: invokevirtual 83	com/baidu/navisdk/logic/CommandResult:set	(I)V
    //   391: aload_0
    //   392: getfield 71	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:mRet	Lcom/baidu/navisdk/logic/CommandResult;
    //   395: areturn
    //   396: aconst_null
    //   397: astore 14
    //   399: aconst_null
    //   400: astore 13
    //   402: aconst_null
    //   403: astore 10
    //   405: aconst_null
    //   406: astore 6
    //   408: aconst_null
    //   409: astore 12
    //   411: aconst_null
    //   412: astore 11
    //   414: aload 12
    //   416: astore 8
    //   418: aload 14
    //   420: astore 7
    //   422: aload 13
    //   424: astore 9
    //   426: new 152	java/net/URL
    //   429: dup
    //   430: aload 15
    //   432: invokespecial 154	java/net/URL:<init>	(Ljava/lang/String;)V
    //   435: invokevirtual 158	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   438: checkcast 160	java/net/HttpURLConnection
    //   441: astore 17
    //   443: aload 12
    //   445: astore 8
    //   447: aload 14
    //   449: astore 7
    //   451: aload 13
    //   453: astore 9
    //   455: aload 17
    //   457: ldc -94
    //   459: invokevirtual 165	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   462: lload_2
    //   463: lconst_0
    //   464: lcmp
    //   465: ifle +51 -> 516
    //   468: aload 12
    //   470: astore 8
    //   472: aload 14
    //   474: astore 7
    //   476: aload 13
    //   478: astore 9
    //   480: aload 17
    //   482: ldc -89
    //   484: new 122	java/lang/StringBuilder
    //   487: dup
    //   488: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   491: ldc -87
    //   493: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: lload_2
    //   497: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   500: ldc -82
    //   502: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: lload 4
    //   507: invokevirtual 172	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   510: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: invokevirtual 177	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   516: aload 12
    //   518: astore 8
    //   520: aload 14
    //   522: astore 7
    //   524: aload 13
    //   526: astore 9
    //   528: aload 17
    //   530: invokevirtual 180	java/net/HttpURLConnection:connect	()V
    //   533: aload 12
    //   535: astore 8
    //   537: aload 14
    //   539: astore 7
    //   541: aload 13
    //   543: astore 9
    //   545: aload 17
    //   547: invokevirtual 183	java/net/HttpURLConnection:getResponseCode	()I
    //   550: istore_1
    //   551: iload_1
    //   552: sipush 200
    //   555: if_icmpeq +79 -> 634
    //   558: iload_1
    //   559: sipush 206
    //   562: if_icmpeq +72 -> 634
    //   565: aload 12
    //   567: astore 8
    //   569: aload 14
    //   571: astore 7
    //   573: aload 13
    //   575: astore 9
    //   577: aload_0
    //   578: getfield 71	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:mRet	Lcom/baidu/navisdk/logic/CommandResult;
    //   581: iconst_5
    //   582: invokestatic 95	com/baidu/navisdk/logic/NaviErrCode:getAppError	(I)I
    //   585: invokevirtual 83	com/baidu/navisdk/logic/CommandResult:set	(I)V
    //   588: aload 12
    //   590: astore 8
    //   592: aload 14
    //   594: astore 7
    //   596: aload 13
    //   598: astore 9
    //   600: aload_0
    //   601: getfield 71	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:mRet	Lcom/baidu/navisdk/logic/CommandResult;
    //   604: astore 10
    //   606: iconst_0
    //   607: ifeq +11 -> 618
    //   610: new 185	java/lang/NullPointerException
    //   613: dup
    //   614: invokespecial 186	java/lang/NullPointerException:<init>	()V
    //   617: athrow
    //   618: aload 10
    //   620: astore 6
    //   622: iconst_0
    //   623: ifeq -589 -> 34
    //   626: new 185	java/lang/NullPointerException
    //   629: dup
    //   630: invokespecial 186	java/lang/NullPointerException:<init>	()V
    //   633: athrow
    //   634: aload 12
    //   636: astore 8
    //   638: aload 14
    //   640: astore 7
    //   642: aload 13
    //   644: astore 9
    //   646: aload 17
    //   648: invokevirtual 189	java/net/HttpURLConnection:getContentLength	()I
    //   651: ifle +516 -> 1167
    //   654: aload 12
    //   656: astore 8
    //   658: aload 14
    //   660: astore 7
    //   662: aload 13
    //   664: astore 9
    //   666: new 134	java/io/File
    //   669: dup
    //   670: aload 16
    //   672: invokespecial 190	java/io/File:<init>	(Ljava/lang/String;)V
    //   675: astore 6
    //   677: aload 12
    //   679: astore 8
    //   681: aload 14
    //   683: astore 7
    //   685: aload 13
    //   687: astore 9
    //   689: aload 6
    //   691: invokevirtual 194	java/io/File:exists	()Z
    //   694: ifne +21 -> 715
    //   697: aload 12
    //   699: astore 8
    //   701: aload 14
    //   703: astore 7
    //   705: aload 13
    //   707: astore 9
    //   709: aload 6
    //   711: invokevirtual 197	java/io/File:mkdirs	()Z
    //   714: pop
    //   715: aload 12
    //   717: astore 8
    //   719: aload 14
    //   721: astore 7
    //   723: aload 13
    //   725: astore 9
    //   727: new 134	java/io/File
    //   730: dup
    //   731: aload 16
    //   733: aload 18
    //   735: invokespecial 199	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   738: astore 10
    //   740: aload 12
    //   742: astore 8
    //   744: aload 14
    //   746: astore 7
    //   748: aload 13
    //   750: astore 9
    //   752: getstatic 27	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:TAG	Ljava/lang/String;
    //   755: new 122	java/lang/StringBuilder
    //   758: dup
    //   759: invokespecial 123	java/lang/StringBuilder:<init>	()V
    //   762: ldc -55
    //   764: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: aload 16
    //   769: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: ldc -53
    //   774: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: aload 15
    //   779: invokevirtual 129	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   785: invokestatic 55	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   788: aload 12
    //   790: astore 8
    //   792: aload 14
    //   794: astore 7
    //   796: aload 13
    //   798: astore 9
    //   800: aload 17
    //   802: invokevirtual 207	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   805: astore 6
    //   807: aload 12
    //   809: astore 8
    //   811: aload 6
    //   813: astore 7
    //   815: aload 6
    //   817: astore 9
    //   819: sipush 1024
    //   822: newarray <illegal type>
    //   824: astore 13
    //   826: aload 12
    //   828: astore 8
    //   830: aload 6
    //   832: astore 7
    //   834: aload 6
    //   836: astore 9
    //   838: new 209	java/io/RandomAccessFile
    //   841: dup
    //   842: aload 10
    //   844: ldc -45
    //   846: invokespecial 214	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   849: astore 10
    //   851: aload 10
    //   853: lload_2
    //   854: invokevirtual 218	java/io/RandomAccessFile:seek	(J)V
    //   857: aload 6
    //   859: aload 13
    //   861: iconst_0
    //   862: sipush 1024
    //   865: invokevirtual 224	java/io/InputStream:read	([BII)I
    //   868: istore_1
    //   869: iload_1
    //   870: iconst_m1
    //   871: if_icmpeq +261 -> 1132
    //   874: aload_0
    //   875: invokevirtual 227	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:isPauseStatus	()Z
    //   878: ifeq +58 -> 936
    //   881: getstatic 27	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:TAG	Ljava/lang/String;
    //   884: ldc -28
    //   886: invokestatic 55	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   889: aload_0
    //   890: getfield 71	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:mRet	Lcom/baidu/navisdk/logic/CommandResult;
    //   893: bipush -4
    //   895: invokevirtual 83	com/baidu/navisdk/logic/CommandResult:set	(I)V
    //   898: aload_0
    //   899: getfield 71	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:mRet	Lcom/baidu/navisdk/logic/CommandResult;
    //   902: astore 7
    //   904: aload 6
    //   906: ifnull +8 -> 914
    //   909: aload 6
    //   911: invokevirtual 231	java/io/InputStream:close	()V
    //   914: aload 7
    //   916: astore 6
    //   918: aload 10
    //   920: ifnull +348 -> 1268
    //   923: aload 10
    //   925: invokevirtual 232	java/io/RandomAccessFile:close	()V
    //   928: aload 7
    //   930: areturn
    //   931: astore 6
    //   933: aload 7
    //   935: areturn
    //   936: aload_0
    //   937: invokevirtual 235	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:isCancelStatus	()Z
    //   940: ifeq +58 -> 998
    //   943: getstatic 27	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:TAG	Ljava/lang/String;
    //   946: ldc -20
    //   948: invokestatic 55	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   951: aload_0
    //   952: getfield 71	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:mRet	Lcom/baidu/navisdk/logic/CommandResult;
    //   955: bipush -3
    //   957: invokevirtual 83	com/baidu/navisdk/logic/CommandResult:set	(I)V
    //   960: aload_0
    //   961: getfield 71	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:mRet	Lcom/baidu/navisdk/logic/CommandResult;
    //   964: astore 7
    //   966: aload 6
    //   968: ifnull +8 -> 976
    //   971: aload 6
    //   973: invokevirtual 231	java/io/InputStream:close	()V
    //   976: aload 7
    //   978: astore 6
    //   980: aload 10
    //   982: ifnull +286 -> 1268
    //   985: aload 10
    //   987: invokevirtual 232	java/io/RandomAccessFile:close	()V
    //   990: aload 7
    //   992: areturn
    //   993: astore 6
    //   995: aload 7
    //   997: areturn
    //   998: aload 10
    //   1000: aload 13
    //   1002: iconst_0
    //   1003: iload_1
    //   1004: invokevirtual 240	java/io/RandomAccessFile:write	([BII)V
    //   1007: lload_2
    //   1008: iload_1
    //   1009: i2l
    //   1010: ladd
    //   1011: lstore_2
    //   1012: aload_0
    //   1013: lload_2
    //   1014: invokevirtual 243	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:responseFileDownloadPos	(J)V
    //   1017: goto -160 -> 857
    //   1020: astore 7
    //   1022: aload 6
    //   1024: astore 9
    //   1026: aload 10
    //   1028: astore 6
    //   1030: aload 7
    //   1032: astore 10
    //   1034: aload 6
    //   1036: astore 8
    //   1038: aload 9
    //   1040: astore 7
    //   1042: getstatic 27	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:TAG	Ljava/lang/String;
    //   1045: ldc -11
    //   1047: invokestatic 55	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1050: aload 6
    //   1052: astore 8
    //   1054: aload 9
    //   1056: astore 7
    //   1058: getstatic 249	com/baidu/navisdk/util/common/LogUtil:LOGGABLE	Z
    //   1061: ifeq +16 -> 1077
    //   1064: aload 6
    //   1066: astore 8
    //   1068: aload 9
    //   1070: astore 7
    //   1072: aload 10
    //   1074: invokevirtual 252	java/lang/Exception:printStackTrace	()V
    //   1077: aload 6
    //   1079: astore 8
    //   1081: aload 9
    //   1083: astore 7
    //   1085: getstatic 27	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:TAG	Ljava/lang/String;
    //   1088: ldc -2
    //   1090: invokestatic 55	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1093: aload 9
    //   1095: ifnull +8 -> 1103
    //   1098: aload 9
    //   1100: invokevirtual 231	java/io/InputStream:close	()V
    //   1103: aload 6
    //   1105: ifnull +8 -> 1113
    //   1108: aload 6
    //   1110: invokevirtual 232	java/io/RandomAccessFile:close	()V
    //   1113: aload_0
    //   1114: getfield 71	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:mRet	Lcom/baidu/navisdk/logic/CommandResult;
    //   1117: invokevirtual 257	com/baidu/navisdk/logic/CommandResult:isSuccess	()Z
    //   1120: ifeq +95 -> 1215
    //   1123: aload_0
    //   1124: invokevirtual 260	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:handleSuccess	()V
    //   1127: aload_0
    //   1128: getfield 71	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:mRet	Lcom/baidu/navisdk/logic/CommandResult;
    //   1131: areturn
    //   1132: lload_2
    //   1133: lload 4
    //   1135: lcmp
    //   1136: iflt +19 -> 1155
    //   1139: getstatic 27	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:TAG	Ljava/lang/String;
    //   1142: ldc_w 262
    //   1145: invokestatic 55	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   1148: aload_0
    //   1149: getfield 71	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:mRet	Lcom/baidu/navisdk/logic/CommandResult;
    //   1152: invokevirtual 265	com/baidu/navisdk/logic/CommandResult:setSuccess	()V
    //   1155: aload 10
    //   1157: astore 7
    //   1159: aload 6
    //   1161: astore 10
    //   1163: aload 7
    //   1165: astore 6
    //   1167: aload 10
    //   1169: ifnull +8 -> 1177
    //   1172: aload 10
    //   1174: invokevirtual 231	java/io/InputStream:close	()V
    //   1177: aload 6
    //   1179: ifnull -66 -> 1113
    //   1182: aload 6
    //   1184: invokevirtual 232	java/io/RandomAccessFile:close	()V
    //   1187: goto -74 -> 1113
    //   1190: astore 6
    //   1192: aload 7
    //   1194: ifnull +8 -> 1202
    //   1197: aload 7
    //   1199: invokevirtual 231	java/io/InputStream:close	()V
    //   1202: aload 8
    //   1204: ifnull +8 -> 1212
    //   1207: aload 8
    //   1209: invokevirtual 232	java/io/RandomAccessFile:close	()V
    //   1212: aload 6
    //   1214: athrow
    //   1215: aload_0
    //   1216: invokevirtual 268	com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc:handleError	()V
    //   1219: goto -92 -> 1127
    //   1222: astore 7
    //   1224: goto -12 -> 1212
    //   1227: astore 9
    //   1229: aload 10
    //   1231: astore 8
    //   1233: aload 6
    //   1235: astore 7
    //   1237: aload 9
    //   1239: astore 6
    //   1241: goto -49 -> 1192
    //   1244: astore 6
    //   1246: goto -133 -> 1113
    //   1249: astore 10
    //   1251: aload 11
    //   1253: astore 6
    //   1255: goto -221 -> 1034
    //   1258: astore 6
    //   1260: goto -147 -> 1113
    //   1263: astore 6
    //   1265: aload 10
    //   1267: areturn
    //   1268: aload 6
    //   1270: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1271	0	this	CmdGeneralHttpRequestDataFunc
    //   80	929	1	i	int
    //   318	815	2	l1	long
    //   323	811	4	l2	long
    //   32	885	6	localObject1	Object
    //   931	41	6	localException1	Exception
    //   978	1	6	localObject2	Object
    //   993	30	6	localException2	Exception
    //   1028	155	6	localObject3	Object
    //   1190	44	6	localObject4	Object
    //   1239	1	6	localObject5	Object
    //   1244	1	6	localException3	Exception
    //   1253	1	6	localObject6	Object
    //   1258	1	6	localException4	Exception
    //   1263	6	6	localException5	Exception
    //   198	798	7	localObject7	Object
    //   1020	11	7	localException6	Exception
    //   1040	158	7	localObject8	Object
    //   1222	1	7	localException7	Exception
    //   1235	1	7	localObject9	Object
    //   124	1108	8	localObject10	Object
    //   207	892	9	localObject11	Object
    //   1227	11	9	localObject12	Object
    //   156	1074	10	localObject13	Object
    //   1249	17	10	localException8	Exception
    //   412	840	11	localObject14	Object
    //   409	418	12	localObject15	Object
    //   400	601	13	arrayOfByte	byte[]
    //   397	396	14	localObject16	Object
    //   41	737	15	str1	String
    //   162	606	16	str2	String
    //   441	360	17	localHttpURLConnection	java.net.HttpURLConnection
    //   250	484	18	str3	String
    // Exception table:
    //   from	to	target	type
    //   909	914	931	java/lang/Exception
    //   923	928	931	java/lang/Exception
    //   971	976	993	java/lang/Exception
    //   985	990	993	java/lang/Exception
    //   851	857	1020	java/lang/Exception
    //   857	869	1020	java/lang/Exception
    //   874	904	1020	java/lang/Exception
    //   936	966	1020	java/lang/Exception
    //   998	1007	1020	java/lang/Exception
    //   1012	1017	1020	java/lang/Exception
    //   1139	1155	1020	java/lang/Exception
    //   426	443	1190	finally
    //   455	462	1190	finally
    //   480	516	1190	finally
    //   528	533	1190	finally
    //   545	551	1190	finally
    //   577	588	1190	finally
    //   600	606	1190	finally
    //   646	654	1190	finally
    //   666	677	1190	finally
    //   689	697	1190	finally
    //   709	715	1190	finally
    //   727	740	1190	finally
    //   752	788	1190	finally
    //   800	807	1190	finally
    //   819	826	1190	finally
    //   838	851	1190	finally
    //   1042	1050	1190	finally
    //   1058	1064	1190	finally
    //   1072	1077	1190	finally
    //   1085	1093	1190	finally
    //   1197	1202	1222	java/lang/Exception
    //   1207	1212	1222	java/lang/Exception
    //   851	857	1227	finally
    //   857	869	1227	finally
    //   874	904	1227	finally
    //   936	966	1227	finally
    //   998	1007	1227	finally
    //   1012	1017	1227	finally
    //   1139	1155	1227	finally
    //   1098	1103	1244	java/lang/Exception
    //   1108	1113	1244	java/lang/Exception
    //   426	443	1249	java/lang/Exception
    //   455	462	1249	java/lang/Exception
    //   480	516	1249	java/lang/Exception
    //   528	533	1249	java/lang/Exception
    //   545	551	1249	java/lang/Exception
    //   577	588	1249	java/lang/Exception
    //   600	606	1249	java/lang/Exception
    //   646	654	1249	java/lang/Exception
    //   666	677	1249	java/lang/Exception
    //   689	697	1249	java/lang/Exception
    //   709	715	1249	java/lang/Exception
    //   727	740	1249	java/lang/Exception
    //   752	788	1249	java/lang/Exception
    //   800	807	1249	java/lang/Exception
    //   819	826	1249	java/lang/Exception
    //   838	851	1249	java/lang/Exception
    //   1172	1177	1258	java/lang/Exception
    //   1182	1187	1258	java/lang/Exception
    //   610	618	1263	java/lang/Exception
    //   626	634	1263	java/lang/Exception
  }
  
  protected CommandResult exec()
  {
    if ((this.mCallback == null) || (this.mCallback.getRequestType() == 1)) {
      return super.exec();
    }
    if (2 == this.mCallback.getRequestType()) {
      return requestFile();
    }
    return null;
  }
  
  protected String generateParams()
  {
    if (this.mCallback != null) {
      return formatNameValuePair(this.mCallback.getRequestParams());
    }
    return null;
  }
  
  protected long getFileDownloadPos()
  {
    if (this.mCallback != null) {
      return this.mCallback.getFileDownloadPos();
    }
    return 0L;
  }
  
  protected String getFilePrefix()
  {
    if (this.mCallback != null) {
      return this.mCallback.getFilePrefix();
    }
    return null;
  }
  
  protected long getFileSize()
  {
    if (this.mCallback != null) {
      return this.mCallback.getFileSize();
    }
    return 0L;
  }
  
  protected List<NameValuePair> getRequestParams()
  {
    if (this.mCallback != null) {
      return this.mCallback.getRequestParams();
    }
    return null;
  }
  
  protected String getSDCardFilePath()
  {
    if (this.mCallback != null) {
      return this.mCallback.getSDCardFilePath();
    }
    return null;
  }
  
  protected String getUrl()
  {
    if (this.mCallback != null) {
      return this.mCallback.getUrl();
    }
    return null;
  }
  
  protected void handleError()
  {
    if (!this.mReqData.mHasMsgSent)
    {
      Message localMessage = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
      localMessage.arg1 = this.mRet.mErrCode;
      localMessage.sendToTarget();
      this.mReqData.mHasMsgSent = true;
    }
  }
  
  protected void handleSuccess()
  {
    if (!this.mReqData.mHasMsgSent)
    {
      LogUtil.e(TAG, "exec() handleSuccess");
      Message localMessage = this.mReqData.mHandler.obtainMessage(this.mReqData.mHandlerMsgWhat);
      localMessage.arg1 = 0;
      localMessage.obj = new RspData(this.mReqData, this.mJson);
      localMessage.sendToTarget();
      this.mReqData.mHasMsgSent = true;
    }
  }
  
  protected boolean isCancelStatus()
  {
    if (this.mCallback != null) {
      return this.mCallback.isCancelStatus();
    }
    return true;
  }
  
  protected boolean isPauseStatus()
  {
    if (this.mCallback != null) {
      return this.mCallback.isPauseStatus();
    }
    return true;
  }
  
  protected void parseJson()
  {
    if (this.mCallback != null) {
      this.mCallback.parseResponseJSON(this.mJson);
    }
  }
  
  protected void responseAudioFilePath(String paramString)
  {
    if (this.mCallback != null) {
      this.mCallback.responseAudioFilePath(paramString);
    }
  }
  
  protected void responseFileDownloadPos(long paramLong)
  {
    if (this.mCallback != null) {
      this.mCallback.responseFileDownloadPos(paramLong);
    }
  }
  
  protected void unpacketParams(ReqData paramReqData)
  {
    this.mCallback = ((Callback)sCallbackMaps.remove(paramReqData));
  }
  
  public static abstract interface Callback
  {
    public static final int REQUEST_TYPE_FILE = 2;
    public static final int REQUEST_TYPE_JSON = 1;
    
    public abstract long getFileDownloadPos();
    
    public abstract String getFilePrefix();
    
    public abstract long getFileSize();
    
    public abstract List<NameValuePair> getRequestParams();
    
    public abstract int getRequestType();
    
    public abstract String getSDCardFilePath();
    
    public abstract String getUrl();
    
    public abstract boolean isCancelStatus();
    
    public abstract boolean isPauseStatus();
    
    public abstract boolean parseResponseJSON(JSONObject paramJSONObject);
    
    public abstract void responseAudioFilePath(String paramString);
    
    public abstract void responseFileDownloadPos(long paramLong);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/logic/commandparser/CmdGeneralHttpRequestDataFunc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */