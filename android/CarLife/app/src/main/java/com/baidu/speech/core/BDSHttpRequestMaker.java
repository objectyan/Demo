package com.baidu.speech.core;

import android.os.Build.VERSION;
import android.util.Log;
import com.baidu.speech.utils.CommonParam;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;

public class BDSHttpRequestMaker
{
  private static final String BACKUP_URL_NORTH = "119.75.222.172";
  private static final String BACKUP_URL_SOUTH = "182.61.62.25";
  private static final int CONNECTION_TIMEOUT = 3;
  private static final Boolean DEBUG = Boolean.valueOf(true);
  static final HostnameVerifier DO_NOT_VERIFY = new HostnameVerifier()
  {
    public boolean verify(String paramAnonymousString, SSLSession paramAnonymousSSLSession)
    {
      paramAnonymousSSLSession = BDSHttpRequestMaker.convertHostname(paramAnonymousString);
      if ((Log.isLoggable("BDSHttpRequestMaker", 3)) || (BDSHttpRequestMaker.DEBUG.booleanValue())) {
        Log.d("BDSHttpRequestMaker", "hostname : " + paramAnonymousString + " verifyUrl : " + paramAnonymousSSLSession);
      }
      if ((paramAnonymousSSLSession.equals("vse.baidu.com")) || (paramAnonymousSSLSession.equals("vop.baidu.com")) || (paramAnonymousSSLSession.equals("openapi.baidu.com")) || (paramAnonymousSSLSession.equals("audiotest.baidu.com")) || (paramAnonymousSSLSession.equals("119.75.222.172")) || (paramAnonymousSSLSession.equals("182.61.62.25")) || (paramAnonymousSSLSession.equals("httpsdns.baidu.com"))) {}
      while (paramAnonymousSSLSession.contains(".baidu.")) {
        return true;
      }
      return false;
    }
  };
  private static final String TAG = "BDSHttpRequestMaker";
  private static final int TIMEOUT_DURATION = 10;
  private static final int TYPE_DOWNLOAD_FINAL = 241;
  private static final int TYPE_DOWNLOAD_FINISH = 243;
  private static final int TYPE_DOWNLOAD_HEART_BEAT = 244;
  private static final int TYPE_DOWNLOAD_PARTIAL = 240;
  private static final int TYPE_DOWNLOAD_THIRD_DATA = 242;
  private static final int TYPE_UPLOAD_AUDIO = 1;
  private static final int TYPE_UPLOAD_CANCEL = 4;
  private static final int TYPE_UPLOAD_FINISH = 3;
  private static final int TYPE_UPLOAD_HEART_BEAT = 9;
  private static final int TYPE_UPLOAD_PARAM = 0;
  private static final int TYPE_UPLOAD_THIRD_DATA = 2;
  private static SSLSocketFactory defaultSslFactory;
  private static HostnameVerifier defaulthostVerifier;
  private static String mHostIp;
  private static SSLContext sSSLContext = null;
  private final int CONNECTION_STATUS_CLOSE = 2;
  private final int CONNECTION_STATUS_INIT = 0;
  private final int CONNECTION_STATUS_WORKING = 1;
  private boolean mAgentDownload = false;
  private boolean mAgentUpload = false;
  private HttpURLConnection mDownloadConnection = null;
  private int mDownloadConnectionStatus = 0;
  private DataInputStream mDownloadInputStream = null;
  private ArrayList<BDSHTTPResponse> mErrorArray = new ArrayList();
  private String mNorthDownUrl;
  private String mNorthUpUrl;
  private boolean mRetriedNorth = true;
  private boolean mRetriedSouth = true;
  private String mSouthDownUrl;
  private String mSouthUpUrl;
  private int mUploadConnctionStatus = 0;
  private HttpURLConnection mUploadConnection = null;
  private OutputStream mUploadOutputStream = null;
  private MyUploadThread mUploadThread = new MyUploadThread(null);
  private ScheduledExecutorService mUploadThreadService = Executors.newSingleThreadScheduledExecutor();
  private boolean mUploadedData = false;
  
  static
  {
    mHostIp = "";
    defaultSslFactory = HttpsURLConnection.getDefaultSSLSocketFactory();
    defaulthostVerifier = HttpsURLConnection.getDefaultHostnameVerifier();
  }
  
  private static String convertHostname(String paramString)
  {
    if ((paramString.equals("vse.baidu.com")) || (paramString.equals("vop.baidu.com")) || (paramString.equals("openapi.baidu.com"))) {}
    while (!paramString.equals(mHostIp)) {
      return paramString;
    }
    return CommonParam.REQUEST_URL;
  }
  
  private void generateBackupUrls(String paramString, int paramInt)
  {
    if (1 == paramInt)
    {
      this.mNorthUpUrl = paramString.replace(mHostIp, "119.75.222.172");
      this.mSouthUpUrl = paramString.replace(mHostIp, "182.61.62.25");
    }
    while (2 != paramInt) {
      return;
    }
    this.mNorthDownUrl = paramString.replace(mHostIp, "119.75.222.172");
    this.mSouthDownUrl = paramString.replace(mHostIp, "182.61.62.25");
  }
  
  public static BDSHttpRequestMaker newRequestMaker()
  {
    if (sSSLContext == null) {}
    try
    {
      sSSLContext = SSLContext.getInstance("TLS");
      sSSLContext.init(null, null, null);
      return new BDSHttpRequestMaker();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private Proxy setAgent()
  {
    Object localObject = CommonParam.AGENT_URL;
    if (localObject != "") {
      try
      {
        localObject = new URL((String)localObject);
        String str = InetAddress.getByName(((URL)localObject).getHost()).getHostAddress();
        Log.e("BDSHttpRequestMaker", "ip: " + str + " port: " + ((URL)localObject).getPort());
        localObject = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(((URL)localObject).getHost(), ((URL)localObject).getPort()));
        return (Proxy)localObject;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    }
    return null;
  }
  
  public void cancelRequest()
  {
    Log.i("BDSHttpRequestMaker", "cancelRequest");
    try
    {
      this.mAgentDownload = false;
      this.mAgentUpload = false;
      if (this.mUploadConnection != null)
      {
        this.mUploadConnection.disconnect();
        this.mUploadConnection = null;
      }
      if (this.mDownloadConnection != null)
      {
        this.mDownloadConnection.disconnect();
        this.mDownloadConnection = null;
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Log.e("BDSHttpRequestMaker", "BDSHttpRequestMaker cancelRequest exception");
    }
  }
  
  /* Error */
  public BDSHTTPResponse makeRequest(String paramString, byte[] paramArrayOfByte, String[] paramArrayOfString, float paramFloat, int paramInt)
  {
    // Byte code:
    //   0: new 242	java/net/URL
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 245	java/net/URL:<init>	(Ljava/lang/String;)V
    //   8: invokevirtual 249	java/net/URL:getHost	()Ljava/lang/String;
    //   11: putstatic 108	com/baidu/speech/core/BDSHttpRequestMaker:mHostIp	Ljava/lang/String;
    //   14: new 319	com/baidu/speech/core/BDSHTTPResponse
    //   17: dup
    //   18: invokespecial 320	com/baidu/speech/core/BDSHTTPResponse:<init>	()V
    //   21: astore 24
    //   23: invokestatic 326	java/lang/System:currentTimeMillis	()J
    //   26: lstore 9
    //   28: iconst_0
    //   29: istore 6
    //   31: ldc 34
    //   33: iconst_3
    //   34: invokestatic 330	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   37: ifne +12 -> 49
    //   40: getstatic 102	com/baidu/speech/core/BDSHttpRequestMaker:DEBUG	Ljava/lang/Boolean;
    //   43: invokevirtual 334	java/lang/Boolean:booleanValue	()Z
    //   46: ifeq +29 -> 75
    //   49: ldc 34
    //   51: new 260	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   58: ldc_w 336
    //   61: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: aload_1
    //   65: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 339	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   74: pop
    //   75: aconst_null
    //   76: astore 20
    //   78: aconst_null
    //   79: astore 19
    //   81: aconst_null
    //   82: astore 18
    //   84: invokestatic 326	java/lang/System:currentTimeMillis	()J
    //   87: lload 9
    //   89: lsub
    //   90: ldc2_w 340
    //   93: lcmp
    //   94: ifle +75 -> 169
    //   97: new 317	java/net/SocketTimeoutException
    //   100: dup
    //   101: invokespecial 342	java/net/SocketTimeoutException:<init>	()V
    //   104: athrow
    //   105: astore 17
    //   107: aconst_null
    //   108: astore_3
    //   109: aconst_null
    //   110: astore_1
    //   111: aconst_null
    //   112: astore_2
    //   113: aload 17
    //   115: invokevirtual 343	java/net/SocketTimeoutException:printStackTrace	()V
    //   118: aload 24
    //   120: sipush 2005
    //   123: putfield 346	com/baidu/speech/core/BDSHTTPResponse:m_http_status	I
    //   126: aload 24
    //   128: iconst_0
    //   129: putfield 349	com/baidu/speech/core/BDSHTTPResponse:m_request_status	I
    //   132: aload_3
    //   133: ifnull +7 -> 140
    //   136: aload_3
    //   137: invokevirtual 311	java/net/HttpURLConnection:disconnect	()V
    //   140: aload_2
    //   141: ifnull +7 -> 148
    //   144: aload_2
    //   145: invokevirtual 354	java/io/BufferedInputStream:close	()V
    //   148: aload_1
    //   149: ifnull +7 -> 156
    //   152: aload_1
    //   153: invokevirtual 357	java/io/ByteArrayOutputStream:close	()V
    //   156: aload 24
    //   158: areturn
    //   159: astore 17
    //   161: aload 17
    //   163: invokevirtual 233	java/lang/Exception:printStackTrace	()V
    //   166: goto -152 -> 14
    //   169: new 242	java/net/URL
    //   172: dup
    //   173: aload_1
    //   174: invokespecial 245	java/net/URL:<init>	(Ljava/lang/String;)V
    //   177: astore 17
    //   179: invokestatic 326	java/lang/System:currentTimeMillis	()J
    //   182: lstore 11
    //   184: aload 17
    //   186: invokevirtual 361	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   189: checkcast 308	java/net/HttpURLConnection
    //   192: astore 17
    //   194: invokestatic 326	java/lang/System:currentTimeMillis	()J
    //   197: lstore 13
    //   199: aload 17
    //   201: instanceof 110
    //   204: ifeq +1410 -> 1614
    //   207: aload 17
    //   209: checkcast 110	javax/net/ssl/HttpsURLConnection
    //   212: getstatic 127	com/baidu/speech/core/BDSHttpRequestMaker:DO_NOT_VERIFY	Ljavax/net/ssl/HostnameVerifier;
    //   215: invokevirtual 365	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   218: goto +1396 -> 1614
    //   221: aload_3
    //   222: ifnull +36 -> 258
    //   225: iload 7
    //   227: aload_3
    //   228: arraylength
    //   229: iconst_1
    //   230: isub
    //   231: if_icmpge +27 -> 258
    //   234: aload 17
    //   236: aload_3
    //   237: iload 7
    //   239: aaload
    //   240: aload_3
    //   241: iload 7
    //   243: iconst_1
    //   244: iadd
    //   245: aaload
    //   246: invokevirtual 369	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   249: iload 7
    //   251: iconst_2
    //   252: iadd
    //   253: istore 7
    //   255: goto -34 -> 221
    //   258: aload 17
    //   260: iconst_1
    //   261: invokevirtual 373	java/net/HttpURLConnection:setDoInput	(Z)V
    //   264: iload 5
    //   266: iconst_1
    //   267: if_icmpne +176 -> 443
    //   270: aload_2
    //   271: ifnull +172 -> 443
    //   274: aload 17
    //   276: iconst_1
    //   277: invokevirtual 376	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   280: aload 17
    //   282: aload_2
    //   283: arraylength
    //   284: invokevirtual 380	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   287: aload 17
    //   289: sipush 10000
    //   292: invokevirtual 383	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   295: aload 17
    //   297: sipush 8000
    //   300: invokevirtual 386	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   303: invokestatic 390	java/util/concurrent/Executors:newSingleThreadExecutor	()Ljava/util/concurrent/ExecutorService;
    //   306: new 8	com/baidu/speech/core/BDSHttpRequestMaker$2
    //   309: dup
    //   310: aload_0
    //   311: iconst_1
    //   312: anewarray 392	java/net/URLConnection
    //   315: dup
    //   316: iconst_0
    //   317: aload 17
    //   319: aastore
    //   320: invokespecial 395	com/baidu/speech/core/BDSHttpRequestMaker$2:<init>	(Lcom/baidu/speech/core/BDSHttpRequestMaker;[Ljava/net/URLConnection;)V
    //   323: invokeinterface 401 2 0
    //   328: ldc2_w 402
    //   331: getstatic 409	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   334: invokeinterface 415 4 0
    //   339: pop
    //   340: new 417	java/io/BufferedOutputStream
    //   343: dup
    //   344: aload 17
    //   346: invokevirtual 421	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   349: invokespecial 424	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   352: astore 18
    //   354: aload 18
    //   356: aload_2
    //   357: invokevirtual 428	java/io/BufferedOutputStream:write	([B)V
    //   360: aload 18
    //   362: invokevirtual 429	java/io/BufferedOutputStream:close	()V
    //   365: new 351	java/io/BufferedInputStream
    //   368: dup
    //   369: aload 17
    //   371: invokevirtual 433	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   374: invokespecial 436	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   377: astore 18
    //   379: new 356	java/io/ByteArrayOutputStream
    //   382: dup
    //   383: invokespecial 437	java/io/ByteArrayOutputStream:<init>	()V
    //   386: astore 19
    //   388: sipush 16384
    //   391: newarray <illegal type>
    //   393: astore 20
    //   395: aload 18
    //   397: aload 20
    //   399: iconst_0
    //   400: aload 20
    //   402: arraylength
    //   403: invokevirtual 441	java/io/BufferedInputStream:read	([BII)I
    //   406: istore 7
    //   408: iload 7
    //   410: iconst_m1
    //   411: if_icmpeq +77 -> 488
    //   414: aload 19
    //   416: aload 20
    //   418: iconst_0
    //   419: iload 7
    //   421: invokevirtual 444	java/io/ByteArrayOutputStream:write	([BII)V
    //   424: goto -29 -> 395
    //   427: astore_1
    //   428: aload 18
    //   430: astore_2
    //   431: aload 17
    //   433: astore_3
    //   434: aload_1
    //   435: astore 17
    //   437: aload 19
    //   439: astore_1
    //   440: goto -327 -> 113
    //   443: ldc_w 445
    //   446: fload 4
    //   448: fmul
    //   449: f2i
    //   450: istore 7
    //   452: aload 17
    //   454: iload 7
    //   456: invokevirtual 386	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   459: aload 17
    //   461: ldc_w 445
    //   464: fload 4
    //   466: fmul
    //   467: f2i
    //   468: invokevirtual 383	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   471: goto -106 -> 365
    //   474: astore_1
    //   475: aload 17
    //   477: astore_3
    //   478: aload_1
    //   479: astore 17
    //   481: aconst_null
    //   482: astore_1
    //   483: aconst_null
    //   484: astore_2
    //   485: goto -372 -> 113
    //   488: aload 19
    //   490: invokevirtual 448	java/io/ByteArrayOutputStream:flush	()V
    //   493: invokestatic 326	java/lang/System:currentTimeMillis	()J
    //   496: lstore 15
    //   498: new 260	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   505: ldc_w 450
    //   508: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_1
    //   512: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   518: invokestatic 455	com/baidu/speech/core/LogUtil:log_d	(Ljava/lang/String;)V
    //   521: new 260	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   528: ldc_w 457
    //   531: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload_1
    //   535: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: invokestatic 455	com/baidu/speech/core/LogUtil:log_d	(Ljava/lang/String;)V
    //   544: aload 24
    //   546: aload 19
    //   548: invokevirtual 461	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   551: putfield 465	com/baidu/speech/core/BDSHTTPResponse:m_response_data	[B
    //   554: aload 24
    //   556: aload 17
    //   558: invokevirtual 468	java/net/HttpURLConnection:getResponseCode	()I
    //   561: putfield 346	com/baidu/speech/core/BDSHTTPResponse:m_http_status	I
    //   564: aload 24
    //   566: iconst_0
    //   567: putfield 349	com/baidu/speech/core/BDSHTTPResponse:m_request_status	I
    //   570: aload 24
    //   572: new 260	java/lang/StringBuilder
    //   575: dup
    //   576: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   579: ldc_w 470
    //   582: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: lload 13
    //   587: lload 11
    //   589: lsub
    //   590: invokevirtual 473	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   593: ldc_w 475
    //   596: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: lload 15
    //   601: lload 13
    //   603: lsub
    //   604: invokevirtual 473	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   607: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: putfield 478	com/baidu/speech/core/BDSHTTPResponse:m_log	Ljava/lang/String;
    //   613: ldc 34
    //   615: iconst_3
    //   616: invokestatic 330	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   619: ifne +12 -> 631
    //   622: getstatic 102	com/baidu/speech/core/BDSHttpRequestMaker:DEBUG	Ljava/lang/Boolean;
    //   625: invokevirtual 334	java/lang/Boolean:booleanValue	()Z
    //   628: ifeq +54 -> 682
    //   631: ldc 34
    //   633: new 260	java/lang/StringBuilder
    //   636: dup
    //   637: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   640: ldc_w 480
    //   643: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: new 186	java/lang/String
    //   649: dup
    //   650: aload 24
    //   652: getfield 465	com/baidu/speech/core/BDSHTTPResponse:m_response_data	[B
    //   655: invokespecial 482	java/lang/String:<init>	([B)V
    //   658: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: ldc_w 484
    //   664: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: aload 24
    //   669: getfield 346	com/baidu/speech/core/BDSHTTPResponse:m_http_status	I
    //   672: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   675: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   678: invokestatic 339	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   681: pop
    //   682: new 186	java/lang/String
    //   685: dup
    //   686: aload 24
    //   688: getfield 465	com/baidu/speech/core/BDSHTTPResponse:m_response_data	[B
    //   691: invokespecial 482	java/lang/String:<init>	([B)V
    //   694: astore 20
    //   696: aload 20
    //   698: ldc_w 486
    //   701: invokevirtual 490	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   704: ifne +13 -> 717
    //   707: new 492	org/json/JSONObject
    //   710: dup
    //   711: aload 20
    //   713: invokespecial 493	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   716: pop
    //   717: aload 17
    //   719: invokevirtual 497	java/net/HttpURLConnection:getHeaderFields	()Ljava/util/Map;
    //   722: astore 20
    //   724: aload 20
    //   726: invokeinterface 503 1 0
    //   731: invokeinterface 508 1 0
    //   736: ifle +683 -> 1419
    //   739: aload 24
    //   741: aload 20
    //   743: invokeinterface 503 1 0
    //   748: invokeinterface 508 1 0
    //   753: iconst_2
    //   754: imul
    //   755: anewarray 186	java/lang/String
    //   758: putfield 512	com/baidu/speech/core/BDSHTTPResponse:m_response_headers	[Ljava/lang/String;
    //   761: aload 20
    //   763: invokeinterface 503 1 0
    //   768: invokeinterface 516 1 0
    //   773: astore 21
    //   775: iconst_0
    //   776: istore 7
    //   778: aload 21
    //   780: invokeinterface 521 1 0
    //   785: ifeq +634 -> 1419
    //   788: aload 21
    //   790: invokeinterface 525 1 0
    //   795: checkcast 527	java/util/Map$Entry
    //   798: astore 22
    //   800: aload 24
    //   802: getfield 512	com/baidu/speech/core/BDSHTTPResponse:m_response_headers	[Ljava/lang/String;
    //   805: astore 23
    //   807: iload 7
    //   809: iconst_1
    //   810: iadd
    //   811: istore 8
    //   813: aload 22
    //   815: invokeinterface 530 1 0
    //   820: ifnull +350 -> 1170
    //   823: aload 22
    //   825: invokeinterface 530 1 0
    //   830: checkcast 186	java/lang/String
    //   833: astore 20
    //   835: aload 23
    //   837: iload 7
    //   839: aload 20
    //   841: aastore
    //   842: aload 24
    //   844: getfield 512	com/baidu/speech/core/BDSHTTPResponse:m_response_headers	[Ljava/lang/String;
    //   847: astore 23
    //   849: iload 8
    //   851: iconst_1
    //   852: iadd
    //   853: istore 7
    //   855: aload 22
    //   857: invokeinterface 533 1 0
    //   862: checkcast 535	java/util/List
    //   865: iconst_0
    //   866: invokeinterface 538 2 0
    //   871: ifnull +306 -> 1177
    //   874: aload 22
    //   876: invokeinterface 533 1 0
    //   881: checkcast 535	java/util/List
    //   884: iconst_0
    //   885: invokeinterface 538 2 0
    //   890: checkcast 186	java/lang/String
    //   893: astore 20
    //   895: aload 23
    //   897: iload 8
    //   899: aload 20
    //   901: aastore
    //   902: goto -124 -> 778
    //   905: astore 20
    //   907: aload 17
    //   909: astore 23
    //   911: aload 19
    //   913: astore 22
    //   915: aload 18
    //   917: astore 21
    //   919: aload 20
    //   921: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   924: iload 6
    //   926: bipush 30
    //   928: if_icmpge +256 -> 1184
    //   931: aload 17
    //   933: astore 23
    //   935: aload 19
    //   937: astore 22
    //   939: aload 18
    //   941: astore 21
    //   943: ldc_w 540
    //   946: invokestatic 455	com/baidu/speech/core/LogUtil:log_d	(Ljava/lang/String;)V
    //   949: aload 17
    //   951: ifnull +20 -> 971
    //   954: aload 17
    //   956: astore 23
    //   958: aload 19
    //   960: astore 22
    //   962: aload 18
    //   964: astore 21
    //   966: aload 17
    //   968: invokevirtual 311	java/net/HttpURLConnection:disconnect	()V
    //   971: aload 17
    //   973: ifnull +8 -> 981
    //   976: aload 17
    //   978: invokevirtual 311	java/net/HttpURLConnection:disconnect	()V
    //   981: aload 18
    //   983: ifnull +8 -> 991
    //   986: aload 18
    //   988: invokevirtual 354	java/io/BufferedInputStream:close	()V
    //   991: aload 19
    //   993: ifnull +8 -> 1001
    //   996: aload 19
    //   998: invokevirtual 357	java/io/ByteArrayOutputStream:close	()V
    //   1001: iload 6
    //   1003: iconst_1
    //   1004: iadd
    //   1005: istore 6
    //   1007: goto -976 -> 31
    //   1010: astore 20
    //   1012: aload 20
    //   1014: invokevirtual 233	java/lang/Exception:printStackTrace	()V
    //   1017: aload 24
    //   1019: sipush 2006
    //   1022: putfield 346	com/baidu/speech/core/BDSHTTPResponse:m_http_status	I
    //   1025: aload 24
    //   1027: aconst_null
    //   1028: putfield 465	com/baidu/speech/core/BDSHTTPResponse:m_response_data	[B
    //   1031: aload 24
    //   1033: iconst_0
    //   1034: putfield 349	com/baidu/speech/core/BDSHTTPResponse:m_request_status	I
    //   1037: goto -320 -> 717
    //   1040: astore_3
    //   1041: aload 17
    //   1043: astore_1
    //   1044: aload 19
    //   1046: astore_2
    //   1047: aload_1
    //   1048: astore 23
    //   1050: aload_2
    //   1051: astore 22
    //   1053: aload 18
    //   1055: astore 21
    //   1057: aload_3
    //   1058: invokevirtual 233	java/lang/Exception:printStackTrace	()V
    //   1061: aload_1
    //   1062: astore 23
    //   1064: aload_2
    //   1065: astore 22
    //   1067: aload 18
    //   1069: astore 21
    //   1071: aload 24
    //   1073: sipush 2000
    //   1076: putfield 346	com/baidu/speech/core/BDSHTTPResponse:m_http_status	I
    //   1079: aload_1
    //   1080: astore 23
    //   1082: aload_2
    //   1083: astore 22
    //   1085: aload 18
    //   1087: astore 21
    //   1089: aload 24
    //   1091: iconst_2
    //   1092: putfield 349	com/baidu/speech/core/BDSHTTPResponse:m_request_status	I
    //   1095: aload_1
    //   1096: astore 23
    //   1098: aload_2
    //   1099: astore 22
    //   1101: aload 18
    //   1103: astore 21
    //   1105: aload 24
    //   1107: new 260	java/lang/StringBuilder
    //   1110: dup
    //   1111: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   1114: ldc_w 542
    //   1117: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1120: aload_3
    //   1121: invokevirtual 545	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1124: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1130: putfield 478	com/baidu/speech/core/BDSHTTPResponse:m_log	Ljava/lang/String;
    //   1133: aload_1
    //   1134: ifnull +7 -> 1141
    //   1137: aload_1
    //   1138: invokevirtual 311	java/net/HttpURLConnection:disconnect	()V
    //   1141: aload 18
    //   1143: ifnull +8 -> 1151
    //   1146: aload 18
    //   1148: invokevirtual 354	java/io/BufferedInputStream:close	()V
    //   1151: aload_2
    //   1152: ifnull -996 -> 156
    //   1155: aload_2
    //   1156: invokevirtual 357	java/io/ByteArrayOutputStream:close	()V
    //   1159: aload 24
    //   1161: areturn
    //   1162: astore_1
    //   1163: aload_1
    //   1164: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   1167: aload 24
    //   1169: areturn
    //   1170: ldc 106
    //   1172: astore 20
    //   1174: goto -339 -> 835
    //   1177: ldc 106
    //   1179: astore 20
    //   1181: goto -286 -> 895
    //   1184: aload 17
    //   1186: astore 23
    //   1188: aload 19
    //   1190: astore 22
    //   1192: aload 18
    //   1194: astore 21
    //   1196: ldc_w 547
    //   1199: invokestatic 455	com/baidu/speech/core/LogUtil:log_d	(Ljava/lang/String;)V
    //   1202: aload 17
    //   1204: astore 23
    //   1206: aload 19
    //   1208: astore 22
    //   1210: aload 18
    //   1212: astore 21
    //   1214: aload 24
    //   1216: iconst_2
    //   1217: putfield 349	com/baidu/speech/core/BDSHTTPResponse:m_request_status	I
    //   1220: aload 17
    //   1222: astore 23
    //   1224: aload 19
    //   1226: astore 22
    //   1228: aload 18
    //   1230: astore 21
    //   1232: aload 24
    //   1234: sipush 2000
    //   1237: putfield 346	com/baidu/speech/core/BDSHTTPResponse:m_http_status	I
    //   1240: aload 17
    //   1242: astore 23
    //   1244: aload 19
    //   1246: astore 22
    //   1248: aload 18
    //   1250: astore 21
    //   1252: aload 24
    //   1254: new 260	java/lang/StringBuilder
    //   1257: dup
    //   1258: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   1261: ldc_w 542
    //   1264: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1267: aload 20
    //   1269: invokevirtual 548	java/io/IOException:getMessage	()Ljava/lang/String;
    //   1272: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1275: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1278: putfield 478	com/baidu/speech/core/BDSHTTPResponse:m_log	Ljava/lang/String;
    //   1281: aload 17
    //   1283: ifnull +8 -> 1291
    //   1286: aload 17
    //   1288: invokevirtual 311	java/net/HttpURLConnection:disconnect	()V
    //   1291: aload 18
    //   1293: ifnull +8 -> 1301
    //   1296: aload 18
    //   1298: invokevirtual 354	java/io/BufferedInputStream:close	()V
    //   1301: aload 19
    //   1303: ifnull -1147 -> 156
    //   1306: aload 19
    //   1308: invokevirtual 357	java/io/ByteArrayOutputStream:close	()V
    //   1311: aload 24
    //   1313: areturn
    //   1314: astore_1
    //   1315: goto -152 -> 1163
    //   1318: astore_1
    //   1319: aconst_null
    //   1320: astore 18
    //   1322: aconst_null
    //   1323: astore_3
    //   1324: aload 19
    //   1326: astore_2
    //   1327: aload_2
    //   1328: ifnull +7 -> 1335
    //   1331: aload_2
    //   1332: invokevirtual 311	java/net/HttpURLConnection:disconnect	()V
    //   1335: aload 18
    //   1337: ifnull +8 -> 1345
    //   1340: aload 18
    //   1342: invokevirtual 354	java/io/BufferedInputStream:close	()V
    //   1345: aload_3
    //   1346: ifnull +7 -> 1353
    //   1349: aload_3
    //   1350: invokevirtual 357	java/io/ByteArrayOutputStream:close	()V
    //   1353: aload_1
    //   1354: athrow
    //   1355: astore_2
    //   1356: aload_2
    //   1357: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   1360: goto -15 -> 1345
    //   1363: astore_2
    //   1364: aload_2
    //   1365: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   1368: goto -15 -> 1353
    //   1371: astore_2
    //   1372: aload_2
    //   1373: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   1376: goto -1228 -> 148
    //   1379: astore_1
    //   1380: goto -217 -> 1163
    //   1383: astore 17
    //   1385: aload 17
    //   1387: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   1390: goto -399 -> 991
    //   1393: astore 17
    //   1395: aload 17
    //   1397: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   1400: goto -399 -> 1001
    //   1403: astore_1
    //   1404: aload_1
    //   1405: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   1408: goto -107 -> 1301
    //   1411: astore_1
    //   1412: aload_1
    //   1413: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   1416: goto -265 -> 1151
    //   1419: aload 17
    //   1421: ifnull +8 -> 1429
    //   1424: aload 17
    //   1426: invokevirtual 311	java/net/HttpURLConnection:disconnect	()V
    //   1429: aload 18
    //   1431: ifnull +8 -> 1439
    //   1434: aload 18
    //   1436: invokevirtual 354	java/io/BufferedInputStream:close	()V
    //   1439: aload 19
    //   1441: ifnull -1285 -> 156
    //   1444: aload 19
    //   1446: invokevirtual 357	java/io/ByteArrayOutputStream:close	()V
    //   1449: aload 24
    //   1451: areturn
    //   1452: astore_1
    //   1453: goto -290 -> 1163
    //   1456: astore_1
    //   1457: aload_1
    //   1458: invokevirtual 301	java/io/IOException:printStackTrace	()V
    //   1461: goto -22 -> 1439
    //   1464: astore_1
    //   1465: aconst_null
    //   1466: astore 18
    //   1468: aconst_null
    //   1469: astore_3
    //   1470: aload 17
    //   1472: astore_2
    //   1473: goto -146 -> 1327
    //   1476: astore_1
    //   1477: aconst_null
    //   1478: astore_3
    //   1479: aload 17
    //   1481: astore_2
    //   1482: goto -155 -> 1327
    //   1485: astore_1
    //   1486: aload 17
    //   1488: astore_2
    //   1489: aload 19
    //   1491: astore_3
    //   1492: goto -165 -> 1327
    //   1495: astore 19
    //   1497: aload_1
    //   1498: astore 17
    //   1500: aload_2
    //   1501: astore 18
    //   1503: aload_3
    //   1504: astore_2
    //   1505: aload 19
    //   1507: astore_1
    //   1508: aload 17
    //   1510: astore_3
    //   1511: goto -184 -> 1327
    //   1514: astore_1
    //   1515: aload 23
    //   1517: astore_2
    //   1518: aload 22
    //   1520: astore_3
    //   1521: aload 21
    //   1523: astore 18
    //   1525: goto -198 -> 1327
    //   1528: astore_3
    //   1529: aconst_null
    //   1530: astore 18
    //   1532: aconst_null
    //   1533: astore_2
    //   1534: aload 20
    //   1536: astore_1
    //   1537: goto -490 -> 1047
    //   1540: astore_3
    //   1541: aconst_null
    //   1542: astore 18
    //   1544: aconst_null
    //   1545: astore_2
    //   1546: aload 17
    //   1548: astore_1
    //   1549: goto -502 -> 1047
    //   1552: astore_3
    //   1553: aconst_null
    //   1554: astore_2
    //   1555: aload 17
    //   1557: astore_1
    //   1558: goto -511 -> 1047
    //   1561: astore 20
    //   1563: aconst_null
    //   1564: astore 21
    //   1566: aconst_null
    //   1567: astore 19
    //   1569: aload 18
    //   1571: astore 17
    //   1573: aload 21
    //   1575: astore 18
    //   1577: goto -670 -> 907
    //   1580: astore 20
    //   1582: aconst_null
    //   1583: astore 18
    //   1585: aconst_null
    //   1586: astore 19
    //   1588: goto -681 -> 907
    //   1591: astore 20
    //   1593: aconst_null
    //   1594: astore 19
    //   1596: goto -689 -> 907
    //   1599: astore_1
    //   1600: aload 17
    //   1602: astore_3
    //   1603: aload_1
    //   1604: astore 17
    //   1606: aconst_null
    //   1607: astore_1
    //   1608: aload 18
    //   1610: astore_2
    //   1611: goto -1498 -> 113
    //   1614: iconst_0
    //   1615: istore 7
    //   1617: goto -1396 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1620	0	this	BDSHttpRequestMaker
    //   0	1620	1	paramString	String
    //   0	1620	2	paramArrayOfByte	byte[]
    //   0	1620	3	paramArrayOfString	String[]
    //   0	1620	4	paramFloat	float
    //   0	1620	5	paramInt	int
    //   29	977	6	i	int
    //   225	1391	7	j	int
    //   811	87	8	k	int
    //   26	62	9	l1	long
    //   182	406	11	l2	long
    //   197	405	13	l3	long
    //   496	104	15	l4	long
    //   105	9	17	localSocketTimeoutException	SocketTimeoutException
    //   159	3	17	localException1	Exception
    //   177	1110	17	localObject1	Object
    //   1383	3	17	localIOException1	IOException
    //   1393	94	17	localIOException2	IOException
    //   1498	107	17	localObject2	Object
    //   82	1527	18	localObject3	Object
    //   79	1411	19	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   1495	11	19	localObject4	Object
    //   1567	28	19	localObject5	Object
    //   76	824	20	localObject6	Object
    //   905	15	20	localIOException3	IOException
    //   1010	3	20	localException2	Exception
    //   1172	363	20	str	String
    //   1561	1	20	localIOException4	IOException
    //   1580	1	20	localIOException5	IOException
    //   1591	1	20	localIOException6	IOException
    //   773	801	21	localObject7	Object
    //   798	721	22	localObject8	Object
    //   805	711	23	localObject9	Object
    //   21	1429	24	localBDSHTTPResponse	BDSHTTPResponse
    // Exception table:
    //   from	to	target	type
    //   84	105	105	java/net/SocketTimeoutException
    //   169	194	105	java/net/SocketTimeoutException
    //   0	14	159	java/lang/Exception
    //   388	395	427	java/net/SocketTimeoutException
    //   395	408	427	java/net/SocketTimeoutException
    //   414	424	427	java/net/SocketTimeoutException
    //   488	631	427	java/net/SocketTimeoutException
    //   631	682	427	java/net/SocketTimeoutException
    //   682	717	427	java/net/SocketTimeoutException
    //   717	775	427	java/net/SocketTimeoutException
    //   778	807	427	java/net/SocketTimeoutException
    //   813	835	427	java/net/SocketTimeoutException
    //   842	849	427	java/net/SocketTimeoutException
    //   855	895	427	java/net/SocketTimeoutException
    //   1012	1037	427	java/net/SocketTimeoutException
    //   194	218	474	java/net/SocketTimeoutException
    //   225	249	474	java/net/SocketTimeoutException
    //   258	264	474	java/net/SocketTimeoutException
    //   274	365	474	java/net/SocketTimeoutException
    //   365	379	474	java/net/SocketTimeoutException
    //   452	471	474	java/net/SocketTimeoutException
    //   388	395	905	java/io/IOException
    //   395	408	905	java/io/IOException
    //   414	424	905	java/io/IOException
    //   488	631	905	java/io/IOException
    //   631	682	905	java/io/IOException
    //   682	717	905	java/io/IOException
    //   717	775	905	java/io/IOException
    //   778	807	905	java/io/IOException
    //   813	835	905	java/io/IOException
    //   842	849	905	java/io/IOException
    //   855	895	905	java/io/IOException
    //   1012	1037	905	java/io/IOException
    //   682	717	1010	java/lang/Exception
    //   388	395	1040	java/lang/Exception
    //   395	408	1040	java/lang/Exception
    //   414	424	1040	java/lang/Exception
    //   488	631	1040	java/lang/Exception
    //   631	682	1040	java/lang/Exception
    //   717	775	1040	java/lang/Exception
    //   778	807	1040	java/lang/Exception
    //   813	835	1040	java/lang/Exception
    //   842	849	1040	java/lang/Exception
    //   855	895	1040	java/lang/Exception
    //   1012	1037	1040	java/lang/Exception
    //   1155	1159	1162	java/io/IOException
    //   1306	1311	1314	java/io/IOException
    //   84	105	1318	finally
    //   169	194	1318	finally
    //   1340	1345	1355	java/io/IOException
    //   1349	1353	1363	java/io/IOException
    //   144	148	1371	java/io/IOException
    //   152	156	1379	java/io/IOException
    //   986	991	1383	java/io/IOException
    //   996	1001	1393	java/io/IOException
    //   1296	1301	1403	java/io/IOException
    //   1146	1151	1411	java/io/IOException
    //   1444	1449	1452	java/io/IOException
    //   1434	1439	1456	java/io/IOException
    //   194	218	1464	finally
    //   225	249	1464	finally
    //   258	264	1464	finally
    //   274	365	1464	finally
    //   365	379	1464	finally
    //   452	471	1464	finally
    //   379	388	1476	finally
    //   388	395	1485	finally
    //   395	408	1485	finally
    //   414	424	1485	finally
    //   488	631	1485	finally
    //   631	682	1485	finally
    //   682	717	1485	finally
    //   717	775	1485	finally
    //   778	807	1485	finally
    //   813	835	1485	finally
    //   842	849	1485	finally
    //   855	895	1485	finally
    //   1012	1037	1485	finally
    //   113	132	1495	finally
    //   919	924	1514	finally
    //   943	949	1514	finally
    //   966	971	1514	finally
    //   1057	1061	1514	finally
    //   1071	1079	1514	finally
    //   1089	1095	1514	finally
    //   1105	1133	1514	finally
    //   1196	1202	1514	finally
    //   1214	1220	1514	finally
    //   1232	1240	1514	finally
    //   1252	1281	1514	finally
    //   84	105	1528	java/lang/Exception
    //   169	194	1528	java/lang/Exception
    //   194	218	1540	java/lang/Exception
    //   225	249	1540	java/lang/Exception
    //   258	264	1540	java/lang/Exception
    //   274	365	1540	java/lang/Exception
    //   365	379	1540	java/lang/Exception
    //   452	471	1540	java/lang/Exception
    //   379	388	1552	java/lang/Exception
    //   84	105	1561	java/io/IOException
    //   169	194	1561	java/io/IOException
    //   194	218	1580	java/io/IOException
    //   225	249	1580	java/io/IOException
    //   258	264	1580	java/io/IOException
    //   274	365	1580	java/io/IOException
    //   365	379	1580	java/io/IOException
    //   452	471	1580	java/io/IOException
    //   379	388	1591	java/io/IOException
    //   379	388	1599	java/net/SocketTimeoutException
  }
  
  /* Error */
  public BDSHTTPResponse readData()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 151	com/baidu/speech/core/BDSHttpRequestMaker:mDownloadConnectionStatus	I
    //   4: iconst_2
    //   5: if_icmpne +18 -> 23
    //   8: ldc 34
    //   10: ldc_w 554
    //   13: invokestatic 557	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   16: pop
    //   17: aconst_null
    //   18: astore 5
    //   20: aload 5
    //   22: areturn
    //   23: aload_0
    //   24: getfield 161	com/baidu/speech/core/BDSHttpRequestMaker:mErrorArray	Ljava/util/ArrayList;
    //   27: invokevirtual 558	java/util/ArrayList:size	()I
    //   30: ifle +26 -> 56
    //   33: aload_0
    //   34: getfield 161	com/baidu/speech/core/BDSHttpRequestMaker:mErrorArray	Ljava/util/ArrayList;
    //   37: iconst_0
    //   38: invokevirtual 559	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   41: checkcast 319	com/baidu/speech/core/BDSHTTPResponse
    //   44: astore 5
    //   46: aload_0
    //   47: getfield 161	com/baidu/speech/core/BDSHttpRequestMaker:mErrorArray	Ljava/util/ArrayList;
    //   50: invokevirtual 562	java/util/ArrayList:clear	()V
    //   53: aload 5
    //   55: areturn
    //   56: aload_0
    //   57: getfield 147	com/baidu/speech/core/BDSHttpRequestMaker:mDownloadInputStream	Ljava/io/DataInputStream;
    //   60: ifnonnull +21 -> 81
    //   63: aload_0
    //   64: new 564	java/io/DataInputStream
    //   67: dup
    //   68: aload_0
    //   69: getfield 143	com/baidu/speech/core/BDSHttpRequestMaker:mDownloadConnection	Ljava/net/HttpURLConnection;
    //   72: invokevirtual 433	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   75: invokespecial 565	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   78: putfield 147	com/baidu/speech/core/BDSHttpRequestMaker:mDownloadInputStream	Ljava/io/DataInputStream;
    //   81: iconst_4
    //   82: newarray <illegal type>
    //   84: astore 5
    //   86: aload_0
    //   87: getfield 147	com/baidu/speech/core/BDSHttpRequestMaker:mDownloadInputStream	Ljava/io/DataInputStream;
    //   90: aload 5
    //   92: iconst_0
    //   93: iconst_4
    //   94: invokevirtual 568	java/io/DataInputStream:readFully	([BII)V
    //   97: aload 5
    //   99: iconst_0
    //   100: baload
    //   101: istore_2
    //   102: aload 5
    //   104: iconst_1
    //   105: baload
    //   106: istore_3
    //   107: aload 5
    //   109: iconst_2
    //   110: baload
    //   111: istore 4
    //   113: aload 5
    //   115: iconst_3
    //   116: baload
    //   117: bipush 24
    //   119: ishl
    //   120: iload_2
    //   121: sipush 255
    //   124: iand
    //   125: iload_3
    //   126: bipush 8
    //   128: ishl
    //   129: ldc_w 569
    //   132: iand
    //   133: ior
    //   134: iload 4
    //   136: bipush 24
    //   138: ishl
    //   139: bipush 8
    //   141: iushr
    //   142: ior
    //   143: ior
    //   144: istore_3
    //   145: aload_0
    //   146: getfield 147	com/baidu/speech/core/BDSHttpRequestMaker:mDownloadInputStream	Ljava/io/DataInputStream;
    //   149: invokevirtual 573	java/io/DataInputStream:readByte	()B
    //   152: istore_1
    //   153: iload_1
    //   154: sipush 255
    //   157: iand
    //   158: istore_2
    //   159: sipush 243
    //   162: iload_2
    //   163: if_icmpne +13 -> 176
    //   166: aload_0
    //   167: iconst_2
    //   168: putfield 149	com/baidu/speech/core/BDSHttpRequestMaker:mUploadConnctionStatus	I
    //   171: aload_0
    //   172: iconst_2
    //   173: putfield 151	com/baidu/speech/core/BDSHttpRequestMaker:mDownloadConnectionStatus	I
    //   176: ldc 34
    //   178: iconst_3
    //   179: invokestatic 330	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   182: ifne +12 -> 194
    //   185: getstatic 102	com/baidu/speech/core/BDSHttpRequestMaker:DEBUG	Ljava/lang/Boolean;
    //   188: invokevirtual 334	java/lang/Boolean:booleanValue	()Z
    //   191: ifeq +29 -> 220
    //   194: ldc 34
    //   196: new 260	java/lang/StringBuilder
    //   199: dup
    //   200: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   203: ldc_w 575
    //   206: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   209: iload_2
    //   210: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   213: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 306	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   219: pop
    //   220: iload_3
    //   221: iconst_1
    //   222: if_icmple +352 -> 574
    //   225: iload_3
    //   226: ldc_w 576
    //   229: if_icmple +134 -> 363
    //   232: new 319	com/baidu/speech/core/BDSHTTPResponse
    //   235: dup
    //   236: invokespecial 320	com/baidu/speech/core/BDSHTTPResponse:<init>	()V
    //   239: astore 5
    //   241: aload 5
    //   243: sipush 2006
    //   246: putfield 346	com/baidu/speech/core/BDSHTTPResponse:m_http_status	I
    //   249: aload 5
    //   251: aconst_null
    //   252: putfield 465	com/baidu/speech/core/BDSHTTPResponse:m_response_data	[B
    //   255: aload 5
    //   257: iconst_0
    //   258: putfield 349	com/baidu/speech/core/BDSHTTPResponse:m_request_status	I
    //   261: aload_0
    //   262: getfield 161	com/baidu/speech/core/BDSHttpRequestMaker:mErrorArray	Ljava/util/ArrayList;
    //   265: aload 5
    //   267: invokevirtual 579	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   270: pop
    //   271: aload 5
    //   273: areturn
    //   274: astore 5
    //   276: aconst_null
    //   277: astore 5
    //   279: new 319	com/baidu/speech/core/BDSHTTPResponse
    //   282: dup
    //   283: invokespecial 320	com/baidu/speech/core/BDSHTTPResponse:<init>	()V
    //   286: astore 6
    //   288: aload_0
    //   289: getfield 175	com/baidu/speech/core/BDSHttpRequestMaker:mAgentDownload	Z
    //   292: ifeq +428 -> 720
    //   295: aload 6
    //   297: sipush 2104
    //   300: putfield 346	com/baidu/speech/core/BDSHTTPResponse:m_http_status	I
    //   303: aload 6
    //   305: aconst_null
    //   306: putfield 465	com/baidu/speech/core/BDSHTTPResponse:m_response_data	[B
    //   309: aload 6
    //   311: iconst_0
    //   312: putfield 349	com/baidu/speech/core/BDSHTTPResponse:m_request_status	I
    //   315: aload_0
    //   316: iconst_0
    //   317: putfield 175	com/baidu/speech/core/BDSHttpRequestMaker:mAgentDownload	Z
    //   320: aload_0
    //   321: getfield 161	com/baidu/speech/core/BDSHttpRequestMaker:mErrorArray	Ljava/util/ArrayList;
    //   324: aload 6
    //   326: invokevirtual 579	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   329: pop
    //   330: aload_0
    //   331: getfield 161	com/baidu/speech/core/BDSHttpRequestMaker:mErrorArray	Ljava/util/ArrayList;
    //   334: invokevirtual 558	java/util/ArrayList:size	()I
    //   337: ifle -317 -> 20
    //   340: aload_0
    //   341: getfield 161	com/baidu/speech/core/BDSHttpRequestMaker:mErrorArray	Ljava/util/ArrayList;
    //   344: iconst_0
    //   345: invokevirtual 559	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   348: checkcast 319	com/baidu/speech/core/BDSHTTPResponse
    //   351: astore 5
    //   353: aload_0
    //   354: getfield 161	com/baidu/speech/core/BDSHttpRequestMaker:mErrorArray	Ljava/util/ArrayList;
    //   357: invokevirtual 562	java/util/ArrayList:clear	()V
    //   360: aload 5
    //   362: areturn
    //   363: iload_3
    //   364: iconst_1
    //   365: isub
    //   366: newarray <illegal type>
    //   368: astore 6
    //   370: iconst_0
    //   371: istore_2
    //   372: iload_2
    //   373: iload_3
    //   374: iconst_1
    //   375: isub
    //   376: if_icmpge +24 -> 400
    //   379: iload_2
    //   380: aload_0
    //   381: getfield 147	com/baidu/speech/core/BDSHttpRequestMaker:mDownloadInputStream	Ljava/io/DataInputStream;
    //   384: aload 6
    //   386: iload_2
    //   387: iload_3
    //   388: iconst_1
    //   389: isub
    //   390: iload_2
    //   391: isub
    //   392: invokevirtual 580	java/io/DataInputStream:read	([BII)I
    //   395: iadd
    //   396: istore_2
    //   397: goto -25 -> 372
    //   400: new 186	java/lang/String
    //   403: dup
    //   404: aload 6
    //   406: invokespecial 482	java/lang/String:<init>	([B)V
    //   409: astore 7
    //   411: ldc 34
    //   413: iconst_3
    //   414: invokestatic 330	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   417: ifne +12 -> 429
    //   420: getstatic 102	com/baidu/speech/core/BDSHttpRequestMaker:DEBUG	Ljava/lang/Boolean;
    //   423: invokevirtual 334	java/lang/Boolean:booleanValue	()Z
    //   426: ifeq +30 -> 456
    //   429: ldc 34
    //   431: new 260	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   438: ldc_w 582
    //   441: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: aload 7
    //   446: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokestatic 306	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   455: pop
    //   456: iload_3
    //   457: iconst_4
    //   458: iadd
    //   459: newarray <illegal type>
    //   461: astore 9
    //   463: aload 5
    //   465: iconst_0
    //   466: aload 9
    //   468: iconst_0
    //   469: iconst_4
    //   470: invokestatic 586	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   473: aload 9
    //   475: iconst_4
    //   476: iload_1
    //   477: bastore
    //   478: iload_3
    //   479: iconst_1
    //   480: isub
    //   481: ifle +15 -> 496
    //   484: aload 6
    //   486: iconst_0
    //   487: aload 9
    //   489: iconst_5
    //   490: iload_3
    //   491: iconst_1
    //   492: isub
    //   493: invokestatic 586	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   496: new 319	com/baidu/speech/core/BDSHTTPResponse
    //   499: dup
    //   500: invokespecial 320	com/baidu/speech/core/BDSHTTPResponse:<init>	()V
    //   503: astore 5
    //   505: aload 5
    //   507: astore 6
    //   509: aload 5
    //   511: astore 7
    //   513: aload 5
    //   515: astore 8
    //   517: aload 5
    //   519: sipush 200
    //   522: putfield 346	com/baidu/speech/core/BDSHTTPResponse:m_http_status	I
    //   525: aload 5
    //   527: astore 6
    //   529: aload 5
    //   531: astore 7
    //   533: aload 5
    //   535: astore 8
    //   537: aload 5
    //   539: aload 9
    //   541: putfield 465	com/baidu/speech/core/BDSHTTPResponse:m_response_data	[B
    //   544: aload 5
    //   546: astore 6
    //   548: aload 5
    //   550: astore 7
    //   552: aload 5
    //   554: astore 8
    //   556: aload 5
    //   558: iconst_0
    //   559: putfield 349	com/baidu/speech/core/BDSHTTPResponse:m_request_status	I
    //   562: goto -232 -> 330
    //   565: astore 5
    //   567: aload 6
    //   569: astore 5
    //   571: goto -292 -> 279
    //   574: iconst_5
    //   575: newarray <illegal type>
    //   577: astore 9
    //   579: aload 5
    //   581: iconst_0
    //   582: aload 9
    //   584: iconst_0
    //   585: iconst_4
    //   586: invokestatic 586	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   589: aload 9
    //   591: iconst_4
    //   592: iload_1
    //   593: bastore
    //   594: new 319	com/baidu/speech/core/BDSHTTPResponse
    //   597: dup
    //   598: invokespecial 320	com/baidu/speech/core/BDSHTTPResponse:<init>	()V
    //   601: astore 5
    //   603: aload 5
    //   605: astore 6
    //   607: aload 5
    //   609: astore 7
    //   611: aload 5
    //   613: astore 8
    //   615: aload 5
    //   617: sipush 200
    //   620: putfield 346	com/baidu/speech/core/BDSHTTPResponse:m_http_status	I
    //   623: aload 5
    //   625: astore 6
    //   627: aload 5
    //   629: astore 7
    //   631: aload 5
    //   633: astore 8
    //   635: aload 5
    //   637: aload 9
    //   639: putfield 465	com/baidu/speech/core/BDSHTTPResponse:m_response_data	[B
    //   642: aload 5
    //   644: astore 6
    //   646: aload 5
    //   648: astore 7
    //   650: aload 5
    //   652: astore 8
    //   654: aload 5
    //   656: iconst_0
    //   657: putfield 349	com/baidu/speech/core/BDSHTTPResponse:m_request_status	I
    //   660: goto -330 -> 330
    //   663: astore 5
    //   665: aload 7
    //   667: astore 5
    //   669: new 319	com/baidu/speech/core/BDSHTTPResponse
    //   672: dup
    //   673: invokespecial 320	com/baidu/speech/core/BDSHTTPResponse:<init>	()V
    //   676: astore 6
    //   678: ldc 34
    //   680: ldc_w 588
    //   683: invokestatic 306	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   686: pop
    //   687: aload 6
    //   689: sipush 2100
    //   692: putfield 346	com/baidu/speech/core/BDSHTTPResponse:m_http_status	I
    //   695: aload 6
    //   697: aconst_null
    //   698: putfield 465	com/baidu/speech/core/BDSHTTPResponse:m_response_data	[B
    //   701: aload 6
    //   703: iconst_0
    //   704: putfield 349	com/baidu/speech/core/BDSHTTPResponse:m_request_status	I
    //   707: aload_0
    //   708: getfield 161	com/baidu/speech/core/BDSHttpRequestMaker:mErrorArray	Ljava/util/ArrayList;
    //   711: aload 6
    //   713: invokevirtual 579	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   716: pop
    //   717: goto -387 -> 330
    //   720: aload 6
    //   722: sipush 2005
    //   725: putfield 346	com/baidu/speech/core/BDSHTTPResponse:m_http_status	I
    //   728: goto -425 -> 303
    //   731: astore 6
    //   733: aconst_null
    //   734: astore 5
    //   736: ldc 34
    //   738: ldc_w 590
    //   741: invokestatic 306	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   744: pop
    //   745: aload 6
    //   747: invokevirtual 233	java/lang/Exception:printStackTrace	()V
    //   750: new 319	com/baidu/speech/core/BDSHTTPResponse
    //   753: dup
    //   754: invokespecial 320	com/baidu/speech/core/BDSHTTPResponse:<init>	()V
    //   757: astore 6
    //   759: aload 6
    //   761: sipush 2100
    //   764: putfield 346	com/baidu/speech/core/BDSHTTPResponse:m_http_status	I
    //   767: aload 6
    //   769: aconst_null
    //   770: putfield 465	com/baidu/speech/core/BDSHTTPResponse:m_response_data	[B
    //   773: aload 6
    //   775: iconst_0
    //   776: putfield 349	com/baidu/speech/core/BDSHTTPResponse:m_request_status	I
    //   779: aload_0
    //   780: getfield 161	com/baidu/speech/core/BDSHttpRequestMaker:mErrorArray	Ljava/util/ArrayList;
    //   783: aload 6
    //   785: invokevirtual 579	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   788: pop
    //   789: goto -459 -> 330
    //   792: astore 6
    //   794: aload 8
    //   796: astore 5
    //   798: goto -62 -> 736
    //   801: astore 5
    //   803: aconst_null
    //   804: astore 5
    //   806: goto -137 -> 669
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	809	0	this	BDSHttpRequestMaker
    //   152	441	1	i	int
    //   101	296	2	j	int
    //   106	387	3	k	int
    //   111	28	4	m	int
    //   18	254	5	localObject1	Object
    //   274	1	5	localSocketTimeoutException1	SocketTimeoutException
    //   277	280	5	localBDSHTTPResponse1	BDSHTTPResponse
    //   565	1	5	localSocketTimeoutException2	SocketTimeoutException
    //   569	86	5	localObject2	Object
    //   663	1	5	localSSLException1	javax.net.ssl.SSLException
    //   667	130	5	localObject3	Object
    //   801	1	5	localSSLException2	javax.net.ssl.SSLException
    //   804	1	5	localObject4	Object
    //   286	435	6	localObject5	Object
    //   731	15	6	localException1	Exception
    //   757	27	6	localBDSHTTPResponse2	BDSHTTPResponse
    //   792	1	6	localException2	Exception
    //   409	257	7	localObject6	Object
    //   515	280	8	localObject7	Object
    //   461	177	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   56	81	274	java/net/SocketTimeoutException
    //   81	97	274	java/net/SocketTimeoutException
    //   145	153	274	java/net/SocketTimeoutException
    //   166	176	274	java/net/SocketTimeoutException
    //   176	194	274	java/net/SocketTimeoutException
    //   194	220	274	java/net/SocketTimeoutException
    //   232	271	274	java/net/SocketTimeoutException
    //   363	370	274	java/net/SocketTimeoutException
    //   379	397	274	java/net/SocketTimeoutException
    //   400	429	274	java/net/SocketTimeoutException
    //   429	456	274	java/net/SocketTimeoutException
    //   456	473	274	java/net/SocketTimeoutException
    //   484	496	274	java/net/SocketTimeoutException
    //   496	505	274	java/net/SocketTimeoutException
    //   574	589	274	java/net/SocketTimeoutException
    //   594	603	274	java/net/SocketTimeoutException
    //   517	525	565	java/net/SocketTimeoutException
    //   537	544	565	java/net/SocketTimeoutException
    //   556	562	565	java/net/SocketTimeoutException
    //   615	623	565	java/net/SocketTimeoutException
    //   635	642	565	java/net/SocketTimeoutException
    //   654	660	565	java/net/SocketTimeoutException
    //   517	525	663	javax/net/ssl/SSLException
    //   537	544	663	javax/net/ssl/SSLException
    //   556	562	663	javax/net/ssl/SSLException
    //   615	623	663	javax/net/ssl/SSLException
    //   635	642	663	javax/net/ssl/SSLException
    //   654	660	663	javax/net/ssl/SSLException
    //   56	81	731	java/lang/Exception
    //   81	97	731	java/lang/Exception
    //   145	153	731	java/lang/Exception
    //   166	176	731	java/lang/Exception
    //   176	194	731	java/lang/Exception
    //   194	220	731	java/lang/Exception
    //   232	271	731	java/lang/Exception
    //   363	370	731	java/lang/Exception
    //   379	397	731	java/lang/Exception
    //   400	429	731	java/lang/Exception
    //   429	456	731	java/lang/Exception
    //   456	473	731	java/lang/Exception
    //   484	496	731	java/lang/Exception
    //   496	505	731	java/lang/Exception
    //   574	589	731	java/lang/Exception
    //   594	603	731	java/lang/Exception
    //   517	525	792	java/lang/Exception
    //   537	544	792	java/lang/Exception
    //   556	562	792	java/lang/Exception
    //   615	623	792	java/lang/Exception
    //   635	642	792	java/lang/Exception
    //   654	660	792	java/lang/Exception
    //   56	81	801	javax/net/ssl/SSLException
    //   81	97	801	javax/net/ssl/SSLException
    //   145	153	801	javax/net/ssl/SSLException
    //   166	176	801	javax/net/ssl/SSLException
    //   176	194	801	javax/net/ssl/SSLException
    //   194	220	801	javax/net/ssl/SSLException
    //   232	271	801	javax/net/ssl/SSLException
    //   363	370	801	javax/net/ssl/SSLException
    //   379	397	801	javax/net/ssl/SSLException
    //   400	429	801	javax/net/ssl/SSLException
    //   429	456	801	javax/net/ssl/SSLException
    //   456	473	801	javax/net/ssl/SSLException
    //   484	496	801	javax/net/ssl/SSLException
    //   496	505	801	javax/net/ssl/SSLException
    //   574	589	801	javax/net/ssl/SSLException
    //   594	603	801	javax/net/ssl/SSLException
  }
  
  /* Error */
  public int sendData(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 149	com/baidu/speech/core/BDSHttpRequestMaker:mUploadConnctionStatus	I
    //   6: iconst_2
    //   7: if_icmpne +16 -> 23
    //   10: ldc 34
    //   12: ldc_w 596
    //   15: invokestatic 557	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   18: pop
    //   19: aload_0
    //   20: monitorexit
    //   21: iconst_0
    //   22: ireturn
    //   23: aload_1
    //   24: iconst_4
    //   25: baload
    //   26: istore_3
    //   27: ldc 34
    //   29: iconst_3
    //   30: invokestatic 330	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   33: ifne +12 -> 45
    //   36: getstatic 102	com/baidu/speech/core/BDSHttpRequestMaker:DEBUG	Ljava/lang/Boolean;
    //   39: invokevirtual 334	java/lang/Boolean:booleanValue	()Z
    //   42: ifeq +33 -> 75
    //   45: ldc 34
    //   47: new 260	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   54: ldc_w 598
    //   57: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: iload_3
    //   61: sipush 255
    //   64: iand
    //   65: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   71: invokestatic 306	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   74: pop
    //   75: aload_0
    //   76: getfield 141	com/baidu/speech/core/BDSHttpRequestMaker:mUploadConnection	Ljava/net/HttpURLConnection;
    //   79: ifnonnull +16 -> 95
    //   82: ldc 34
    //   84: ldc_w 600
    //   87: invokestatic 285	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   90: pop
    //   91: aload_0
    //   92: monitorexit
    //   93: iconst_m1
    //   94: ireturn
    //   95: aload_0
    //   96: getfield 145	com/baidu/speech/core/BDSHttpRequestMaker:mUploadOutputStream	Ljava/io/OutputStream;
    //   99: ifnonnull +14 -> 113
    //   102: aload_0
    //   103: aload_0
    //   104: getfield 141	com/baidu/speech/core/BDSHttpRequestMaker:mUploadConnection	Ljava/net/HttpURLConnection;
    //   107: invokevirtual 421	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   110: putfield 145	com/baidu/speech/core/BDSHttpRequestMaker:mUploadOutputStream	Ljava/io/OutputStream;
    //   113: aload_0
    //   114: getfield 145	com/baidu/speech/core/BDSHttpRequestMaker:mUploadOutputStream	Ljava/io/OutputStream;
    //   117: aload_1
    //   118: invokevirtual 603	java/io/OutputStream:write	([B)V
    //   121: aload_0
    //   122: getfield 145	com/baidu/speech/core/BDSHttpRequestMaker:mUploadOutputStream	Ljava/io/OutputStream;
    //   125: invokevirtual 604	java/io/OutputStream:flush	()V
    //   128: iload_2
    //   129: ifeq +27 -> 156
    //   132: aload_0
    //   133: getfield 145	com/baidu/speech/core/BDSHttpRequestMaker:mUploadOutputStream	Ljava/io/OutputStream;
    //   136: invokevirtual 605	java/io/OutputStream:close	()V
    //   139: aload_0
    //   140: getfield 141	com/baidu/speech/core/BDSHttpRequestMaker:mUploadConnection	Ljava/net/HttpURLConnection;
    //   143: invokevirtual 433	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   146: invokevirtual 608	java/io/InputStream:close	()V
    //   149: aload_0
    //   150: getfield 141	com/baidu/speech/core/BDSHttpRequestMaker:mUploadConnection	Ljava/net/HttpURLConnection;
    //   153: invokevirtual 311	java/net/HttpURLConnection:disconnect	()V
    //   156: aload_0
    //   157: monitorexit
    //   158: iconst_0
    //   159: ireturn
    //   160: astore_1
    //   161: aload_0
    //   162: monitorexit
    //   163: aload_1
    //   164: athrow
    //   165: astore_1
    //   166: aload_1
    //   167: invokevirtual 609	java/io/EOFException:printStackTrace	()V
    //   170: goto -21 -> 149
    //   173: astore_1
    //   174: ldc 34
    //   176: ldc_w 611
    //   179: invokestatic 557	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   182: pop
    //   183: new 319	com/baidu/speech/core/BDSHTTPResponse
    //   186: dup
    //   187: invokespecial 320	com/baidu/speech/core/BDSHTTPResponse:<init>	()V
    //   190: astore_1
    //   191: aload_1
    //   192: sipush 2100
    //   195: putfield 346	com/baidu/speech/core/BDSHTTPResponse:m_http_status	I
    //   198: aload_1
    //   199: aconst_null
    //   200: putfield 465	com/baidu/speech/core/BDSHTTPResponse:m_response_data	[B
    //   203: aload_1
    //   204: iconst_0
    //   205: putfield 349	com/baidu/speech/core/BDSHTTPResponse:m_request_status	I
    //   208: aload_0
    //   209: getfield 161	com/baidu/speech/core/BDSHttpRequestMaker:mErrorArray	Ljava/util/ArrayList;
    //   212: aload_1
    //   213: invokevirtual 579	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   216: pop
    //   217: aload_0
    //   218: monitorexit
    //   219: iconst_m1
    //   220: ireturn
    //   221: astore_1
    //   222: aload_1
    //   223: invokevirtual 233	java/lang/Exception:printStackTrace	()V
    //   226: new 319	com/baidu/speech/core/BDSHTTPResponse
    //   229: dup
    //   230: invokespecial 320	com/baidu/speech/core/BDSHTTPResponse:<init>	()V
    //   233: astore_1
    //   234: aload_0
    //   235: getfield 173	com/baidu/speech/core/BDSHttpRequestMaker:mAgentUpload	Z
    //   238: ifeq +37 -> 275
    //   241: aload_1
    //   242: sipush 2102
    //   245: putfield 346	com/baidu/speech/core/BDSHTTPResponse:m_http_status	I
    //   248: aload_1
    //   249: aconst_null
    //   250: putfield 465	com/baidu/speech/core/BDSHTTPResponse:m_response_data	[B
    //   253: aload_1
    //   254: iconst_0
    //   255: putfield 349	com/baidu/speech/core/BDSHTTPResponse:m_request_status	I
    //   258: aload_0
    //   259: getfield 161	com/baidu/speech/core/BDSHttpRequestMaker:mErrorArray	Ljava/util/ArrayList;
    //   262: aload_1
    //   263: invokevirtual 579	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   266: pop
    //   267: aload_0
    //   268: iconst_0
    //   269: putfield 173	com/baidu/speech/core/BDSHttpRequestMaker:mAgentUpload	Z
    //   272: goto -116 -> 156
    //   275: aload_1
    //   276: sipush 2003
    //   279: putfield 346	com/baidu/speech/core/BDSHTTPResponse:m_http_status	I
    //   282: goto -34 -> 248
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	285	0	this	BDSHttpRequestMaker
    //   0	285	1	paramArrayOfByte	byte[]
    //   0	285	2	paramBoolean	boolean
    //   26	39	3	i	int
    // Exception table:
    //   from	to	target	type
    //   2	21	160	finally
    //   27	45	160	finally
    //   45	75	160	finally
    //   75	91	160	finally
    //   91	93	160	finally
    //   95	113	160	finally
    //   113	128	160	finally
    //   132	139	160	finally
    //   139	149	160	finally
    //   149	156	160	finally
    //   156	158	160	finally
    //   161	163	160	finally
    //   166	170	160	finally
    //   174	219	160	finally
    //   222	248	160	finally
    //   248	272	160	finally
    //   275	282	160	finally
    //   139	149	165	java/io/EOFException
    //   75	91	173	java/io/EOFException
    //   95	113	173	java/io/EOFException
    //   113	128	173	java/io/EOFException
    //   132	139	173	java/io/EOFException
    //   149	156	173	java/io/EOFException
    //   166	170	173	java/io/EOFException
    //   75	91	221	java/lang/Exception
    //   95	113	221	java/lang/Exception
    //   113	128	221	java/lang/Exception
    //   132	139	221	java/lang/Exception
    //   139	149	221	java/lang/Exception
    //   149	156	221	java/lang/Exception
    //   166	170	221	java/lang/Exception
  }
  
  public int setupConnection(String paramString, String[] paramArrayOfString, float paramFloat, int paramInt)
  {
    if ((Log.isLoggable("BDSHttpRequestMaker", 3)) || (DEBUG.booleanValue())) {
      Log.i("BDSHttpRequestMaker", "url = " + paramString);
    }
    this.mErrorArray.clear();
    try
    {
      mHostIp = new URL(paramString).getHost();
      if ((Log.isLoggable("BDSHttpRequestMaker", 3)) || (DEBUG.booleanValue())) {
        Log.d("BDSHttpRequestMaker", "url: " + paramString + " mHostIp: " + mHostIp);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
      if (!paramString.contains("down")) {
        break label183;
      }
      generateBackupUrls(paramString, 2);
      return setupDownloadConnection(paramString, paramArrayOfString, paramFloat, paramInt);
      label183:
      Log.e("BDSHttpRequestMaker", "Error url : " + paramString);
    }
    if (paramString.contains("up"))
    {
      generateBackupUrls(paramString, 1);
      return setupUploadConnection(paramString, paramArrayOfString, paramFloat, paramInt);
    }
    return -1;
  }
  
  /* Error */
  public int setupDownloadConnection(String paramString, String[] paramArrayOfString, float paramFloat, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 641	com/baidu/speech/core/BDSHttpRequestMaker:setAgent	()Ljava/net/Proxy;
    //   4: astore 6
    //   6: aload 6
    //   8: ifnull +123 -> 131
    //   11: aload_0
    //   12: new 242	java/net/URL
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 245	java/net/URL:<init>	(Ljava/lang/String;)V
    //   20: aload 6
    //   22: invokevirtual 644	java/net/URL:openConnection	(Ljava/net/Proxy;)Ljava/net/URLConnection;
    //   25: checkcast 308	java/net/HttpURLConnection
    //   28: putfield 143	com/baidu/speech/core/BDSHttpRequestMaker:mDownloadConnection	Ljava/net/HttpURLConnection;
    //   31: aload_0
    //   32: iconst_1
    //   33: putfield 175	com/baidu/speech/core/BDSHttpRequestMaker:mAgentDownload	Z
    //   36: aload_0
    //   37: getfield 143	com/baidu/speech/core/BDSHttpRequestMaker:mDownloadConnection	Ljava/net/HttpURLConnection;
    //   40: instanceof 110
    //   43: ifeq +16 -> 59
    //   46: aload_0
    //   47: getfield 143	com/baidu/speech/core/BDSHttpRequestMaker:mDownloadConnection	Ljava/net/HttpURLConnection;
    //   50: checkcast 110	javax/net/ssl/HttpsURLConnection
    //   53: getstatic 127	com/baidu/speech/core/BDSHttpRequestMaker:DO_NOT_VERIFY	Ljavax/net/ssl/HostnameVerifier;
    //   56: invokevirtual 365	javax/net/ssl/HttpsURLConnection:setHostnameVerifier	(Ljavax/net/ssl/HostnameVerifier;)V
    //   59: aload_0
    //   60: getfield 143	com/baidu/speech/core/BDSHttpRequestMaker:mDownloadConnection	Ljava/net/HttpURLConnection;
    //   63: sipush 3000
    //   66: invokevirtual 386	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   69: aload_0
    //   70: getfield 143	com/baidu/speech/core/BDSHttpRequestMaker:mDownloadConnection	Ljava/net/HttpURLConnection;
    //   73: sipush 10000
    //   76: invokevirtual 383	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   79: aload_0
    //   80: getfield 143	com/baidu/speech/core/BDSHttpRequestMaker:mDownloadConnection	Ljava/net/HttpURLConnection;
    //   83: ldc_w 646
    //   86: invokevirtual 649	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   89: iconst_0
    //   90: istore 5
    //   92: aload_2
    //   93: ifnull +137 -> 230
    //   96: iload 5
    //   98: aload_2
    //   99: arraylength
    //   100: iconst_1
    //   101: isub
    //   102: if_icmpge +128 -> 230
    //   105: aload_0
    //   106: getfield 143	com/baidu/speech/core/BDSHttpRequestMaker:mDownloadConnection	Ljava/net/HttpURLConnection;
    //   109: aload_2
    //   110: iload 5
    //   112: aaload
    //   113: aload_2
    //   114: iload 5
    //   116: iconst_1
    //   117: iadd
    //   118: aaload
    //   119: invokevirtual 369	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: iload 5
    //   124: iconst_2
    //   125: iadd
    //   126: istore 5
    //   128: goto -36 -> 92
    //   131: aload_0
    //   132: new 242	java/net/URL
    //   135: dup
    //   136: aload_1
    //   137: invokespecial 245	java/net/URL:<init>	(Ljava/lang/String;)V
    //   140: invokevirtual 361	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   143: checkcast 308	java/net/HttpURLConnection
    //   146: putfield 143	com/baidu/speech/core/BDSHttpRequestMaker:mDownloadConnection	Ljava/net/HttpURLConnection;
    //   149: goto -113 -> 36
    //   152: astore_1
    //   153: aload_1
    //   154: invokevirtual 233	java/lang/Exception:printStackTrace	()V
    //   157: aload_0
    //   158: getfield 131	com/baidu/speech/core/BDSHttpRequestMaker:mRetriedNorth	Z
    //   161: ifne +245 -> 406
    //   164: aload_0
    //   165: iconst_1
    //   166: putfield 131	com/baidu/speech/core/BDSHttpRequestMaker:mRetriedNorth	Z
    //   169: aload_0
    //   170: aload_0
    //   171: getfield 211	com/baidu/speech/core/BDSHttpRequestMaker:mNorthDownUrl	Ljava/lang/String;
    //   174: aload_2
    //   175: fload_3
    //   176: iload 4
    //   178: invokevirtual 635	com/baidu/speech/core/BDSHttpRequestMaker:setupDownloadConnection	(Ljava/lang/String;[Ljava/lang/String;FI)I
    //   181: pop
    //   182: new 319	com/baidu/speech/core/BDSHTTPResponse
    //   185: dup
    //   186: invokespecial 320	com/baidu/speech/core/BDSHTTPResponse:<init>	()V
    //   189: astore_2
    //   190: aload_1
    //   191: instanceof 317
    //   194: ifeq +240 -> 434
    //   197: aload_2
    //   198: sipush 1005
    //   201: putfield 346	com/baidu/speech/core/BDSHTTPResponse:m_http_status	I
    //   204: aload_2
    //   205: aconst_null
    //   206: putfield 465	com/baidu/speech/core/BDSHTTPResponse:m_response_data	[B
    //   209: aload_2
    //   210: iconst_0
    //   211: putfield 349	com/baidu/speech/core/BDSHTTPResponse:m_request_status	I
    //   214: aload_0
    //   215: getfield 161	com/baidu/speech/core/BDSHttpRequestMaker:mErrorArray	Ljava/util/ArrayList;
    //   218: aload_2
    //   219: invokevirtual 579	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   222: pop
    //   223: aload_0
    //   224: iconst_0
    //   225: putfield 175	com/baidu/speech/core/BDSHttpRequestMaker:mAgentDownload	Z
    //   228: iconst_0
    //   229: ireturn
    //   230: getstatic 654	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   233: invokestatic 660	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   236: bipush 21
    //   238: if_icmpge +16 -> 254
    //   241: aload_0
    //   242: getfield 143	com/baidu/speech/core/BDSHttpRequestMaker:mDownloadConnection	Ljava/net/HttpURLConnection;
    //   245: ldc_w 662
    //   248: ldc_w 663
    //   251: invokevirtual 369	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: aload_0
    //   255: getfield 143	com/baidu/speech/core/BDSHttpRequestMaker:mDownloadConnection	Ljava/net/HttpURLConnection;
    //   258: iconst_0
    //   259: invokevirtual 666	java/net/HttpURLConnection:setChunkedStreamingMode	(I)V
    //   262: aload_0
    //   263: getfield 143	com/baidu/speech/core/BDSHttpRequestMaker:mDownloadConnection	Ljava/net/HttpURLConnection;
    //   266: invokevirtual 669	java/net/HttpURLConnection:connect	()V
    //   269: aload_0
    //   270: iconst_1
    //   271: putfield 151	com/baidu/speech/core/BDSHttpRequestMaker:mDownloadConnectionStatus	I
    //   274: new 10	com/baidu/speech/core/BDSHttpRequestMaker$AudioData
    //   277: dup
    //   278: aload_0
    //   279: iconst_3
    //   280: iconst_0
    //   281: newarray <illegal type>
    //   283: iconst_1
    //   284: invokespecial 672	com/baidu/speech/core/BDSHttpRequestMaker$AudioData:<init>	(Lcom/baidu/speech/core/BDSHttpRequestMaker;I[BZ)V
    //   287: astore_1
    //   288: aload_0
    //   289: getfield 143	com/baidu/speech/core/BDSHttpRequestMaker:mDownloadConnection	Ljava/net/HttpURLConnection;
    //   292: invokevirtual 421	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   295: astore 6
    //   297: aload 6
    //   299: aload_1
    //   300: getfield 675	com/baidu/speech/core/BDSHttpRequestMaker$AudioData:mData	[B
    //   303: invokevirtual 603	java/io/OutputStream:write	([B)V
    //   306: aload 6
    //   308: invokevirtual 604	java/io/OutputStream:flush	()V
    //   311: aload 6
    //   313: invokevirtual 605	java/io/OutputStream:close	()V
    //   316: ldc 34
    //   318: iconst_3
    //   319: invokestatic 330	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   322: ifne +255 -> 577
    //   325: getstatic 102	com/baidu/speech/core/BDSHttpRequestMaker:DEBUG	Ljava/lang/Boolean;
    //   328: invokevirtual 334	java/lang/Boolean:booleanValue	()Z
    //   331: ifeq -103 -> 228
    //   334: goto +243 -> 577
    //   337: iload 5
    //   339: aload_1
    //   340: getfield 675	com/baidu/speech/core/BDSHttpRequestMaker$AudioData:mData	[B
    //   343: arraylength
    //   344: if_icmpge -116 -> 228
    //   347: ldc 34
    //   349: new 260	java/lang/StringBuilder
    //   352: dup
    //   353: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   356: ldc_w 677
    //   359: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: iload 5
    //   364: invokevirtual 276	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   367: ldc_w 679
    //   370: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload_1
    //   374: getfield 675	com/baidu/speech/core/BDSHttpRequestMaker$AudioData:mData	[B
    //   377: iload 5
    //   379: baload
    //   380: sipush 255
    //   383: iand
    //   384: invokestatic 683	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   387: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: invokevirtual 279	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokestatic 306	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   396: pop
    //   397: iload 5
    //   399: iconst_1
    //   400: iadd
    //   401: istore 5
    //   403: goto -66 -> 337
    //   406: aload_0
    //   407: getfield 133	com/baidu/speech/core/BDSHttpRequestMaker:mRetriedSouth	Z
    //   410: ifne -228 -> 182
    //   413: aload_0
    //   414: iconst_1
    //   415: putfield 133	com/baidu/speech/core/BDSHttpRequestMaker:mRetriedSouth	Z
    //   418: aload_0
    //   419: aload_0
    //   420: getfield 213	com/baidu/speech/core/BDSHttpRequestMaker:mSouthDownUrl	Ljava/lang/String;
    //   423: aload_2
    //   424: fload_3
    //   425: iload 4
    //   427: invokevirtual 635	com/baidu/speech/core/BDSHttpRequestMaker:setupDownloadConnection	(Ljava/lang/String;[Ljava/lang/String;FI)I
    //   430: pop
    //   431: goto -249 -> 182
    //   434: aload_0
    //   435: getfield 175	com/baidu/speech/core/BDSHttpRequestMaker:mAgentDownload	Z
    //   438: ifeq +13 -> 451
    //   441: aload_2
    //   442: sipush 2103
    //   445: putfield 346	com/baidu/speech/core/BDSHTTPResponse:m_http_status	I
    //   448: goto -244 -> 204
    //   451: aload_2
    //   452: sipush 2004
    //   455: putfield 346	com/baidu/speech/core/BDSHTTPResponse:m_http_status	I
    //   458: goto -254 -> 204
    //   461: astore_1
    //   462: aload_1
    //   463: invokevirtual 684	java/lang/AssertionError:printStackTrace	()V
    //   466: aload_0
    //   467: getfield 131	com/baidu/speech/core/BDSHttpRequestMaker:mRetriedNorth	Z
    //   470: ifne +69 -> 539
    //   473: aload_0
    //   474: iconst_1
    //   475: putfield 131	com/baidu/speech/core/BDSHttpRequestMaker:mRetriedNorth	Z
    //   478: aload_0
    //   479: aload_0
    //   480: getfield 211	com/baidu/speech/core/BDSHttpRequestMaker:mNorthDownUrl	Ljava/lang/String;
    //   483: aload_2
    //   484: fload_3
    //   485: iload 4
    //   487: invokevirtual 635	com/baidu/speech/core/BDSHttpRequestMaker:setupDownloadConnection	(Ljava/lang/String;[Ljava/lang/String;FI)I
    //   490: pop
    //   491: new 319	com/baidu/speech/core/BDSHTTPResponse
    //   494: dup
    //   495: invokespecial 320	com/baidu/speech/core/BDSHTTPResponse:<init>	()V
    //   498: astore_1
    //   499: aload_0
    //   500: getfield 175	com/baidu/speech/core/BDSHttpRequestMaker:mAgentDownload	Z
    //   503: ifeq +64 -> 567
    //   506: aload_1
    //   507: sipush 2103
    //   510: putfield 346	com/baidu/speech/core/BDSHTTPResponse:m_http_status	I
    //   513: aload_1
    //   514: aconst_null
    //   515: putfield 465	com/baidu/speech/core/BDSHTTPResponse:m_response_data	[B
    //   518: aload_1
    //   519: iconst_0
    //   520: putfield 349	com/baidu/speech/core/BDSHTTPResponse:m_request_status	I
    //   523: aload_0
    //   524: getfield 161	com/baidu/speech/core/BDSHttpRequestMaker:mErrorArray	Ljava/util/ArrayList;
    //   527: aload_1
    //   528: invokevirtual 579	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   531: pop
    //   532: aload_0
    //   533: iconst_0
    //   534: putfield 175	com/baidu/speech/core/BDSHttpRequestMaker:mAgentDownload	Z
    //   537: iconst_0
    //   538: ireturn
    //   539: aload_0
    //   540: getfield 133	com/baidu/speech/core/BDSHttpRequestMaker:mRetriedSouth	Z
    //   543: ifne -52 -> 491
    //   546: aload_0
    //   547: iconst_1
    //   548: putfield 133	com/baidu/speech/core/BDSHttpRequestMaker:mRetriedSouth	Z
    //   551: aload_0
    //   552: aload_0
    //   553: getfield 213	com/baidu/speech/core/BDSHttpRequestMaker:mSouthDownUrl	Ljava/lang/String;
    //   556: aload_2
    //   557: fload_3
    //   558: iload 4
    //   560: invokevirtual 635	com/baidu/speech/core/BDSHttpRequestMaker:setupDownloadConnection	(Ljava/lang/String;[Ljava/lang/String;FI)I
    //   563: pop
    //   564: goto -73 -> 491
    //   567: aload_1
    //   568: sipush 2004
    //   571: putfield 346	com/baidu/speech/core/BDSHTTPResponse:m_http_status	I
    //   574: goto -61 -> 513
    //   577: iconst_0
    //   578: istore 5
    //   580: goto -243 -> 337
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	583	0	this	BDSHttpRequestMaker
    //   0	583	1	paramString	String
    //   0	583	2	paramArrayOfString	String[]
    //   0	583	3	paramFloat	float
    //   0	583	4	paramInt	int
    //   90	489	5	i	int
    //   4	308	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	6	152	java/lang/Exception
    //   11	36	152	java/lang/Exception
    //   36	59	152	java/lang/Exception
    //   59	89	152	java/lang/Exception
    //   96	122	152	java/lang/Exception
    //   131	149	152	java/lang/Exception
    //   230	254	152	java/lang/Exception
    //   254	334	152	java/lang/Exception
    //   337	397	152	java/lang/Exception
    //   0	6	461	java/lang/AssertionError
    //   11	36	461	java/lang/AssertionError
    //   36	59	461	java/lang/AssertionError
    //   59	89	461	java/lang/AssertionError
    //   96	122	461	java/lang/AssertionError
    //   131	149	461	java/lang/AssertionError
    //   230	254	461	java/lang/AssertionError
    //   254	334	461	java/lang/AssertionError
    //   337	397	461	java/lang/AssertionError
  }
  
  public int setupUploadConnection(String paramString, String[] paramArrayOfString, float paramFloat, int paramInt)
  {
    try
    {
      Proxy localProxy = setAgent();
      if (localProxy != null)
      {
        this.mUploadConnection = ((HttpURLConnection)new URL(paramString).openConnection(localProxy));
        this.mAgentUpload = true;
      }
      for (;;)
      {
        if ((this.mUploadConnection instanceof HttpsURLConnection)) {
          ((HttpsURLConnection)this.mUploadConnection).setHostnameVerifier(DO_NOT_VERIFY);
        }
        this.mUploadConnection.setConnectTimeout(3000);
        this.mUploadConnection.setReadTimeout(10000);
        this.mUploadConnection.setRequestMethod("POST");
        int i = 0;
        while ((paramArrayOfString != null) && (i < paramArrayOfString.length - 1))
        {
          this.mUploadConnection.setRequestProperty(paramArrayOfString[i], paramArrayOfString[(i + 1)]);
          i += 2;
        }
        this.mUploadConnection = ((HttpURLConnection)new URL(paramString).openConnection());
      }
      label204:
      this.mRetriedNorth = true;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      if (this.mRetriedNorth) {
        break label354;
      }
      this.mRetriedNorth = true;
      setupUploadConnection(this.mNorthUpUrl, paramArrayOfString, paramFloat, paramInt);
      paramArrayOfString = new BDSHTTPResponse();
      if (!(paramString instanceof SocketTimeoutException)) {
        break label382;
      }
      paramArrayOfString.m_http_status = 1003;
      this.mAgentUpload = false;
      paramArrayOfString.m_response_data = null;
      paramArrayOfString.m_request_status = 0;
      this.mErrorArray.add(paramArrayOfString);
      return 0;
      if (Integer.parseInt(Build.VERSION.SDK) < 21) {
        this.mUploadConnection.setRequestProperty("connection", "close");
      }
      this.mUploadConnection.setChunkedStreamingMode(0);
      this.mUploadConnection.connect();
      this.mUploadConnctionStatus = 1;
      return 0;
    }
    catch (AssertionError paramString)
    {
      paramString.printStackTrace();
      if (this.mRetriedNorth) {
        break label409;
      }
    }
    setupUploadConnection(this.mNorthUpUrl, paramArrayOfString, paramFloat, paramInt);
    label306:
    paramString = new BDSHTTPResponse();
    if (this.mAgentUpload) {
      paramString.m_http_status = 2002;
    }
    for (;;)
    {
      this.mAgentUpload = false;
      paramString.m_response_data = null;
      paramString.m_request_status = 0;
      this.mErrorArray.add(paramString);
      return 0;
      label354:
      if (this.mRetriedSouth) {
        break;
      }
      this.mRetriedSouth = true;
      setupUploadConnection(this.mSouthUpUrl, paramArrayOfString, paramFloat, paramInt);
      break;
      label382:
      if (this.mAgentUpload)
      {
        paramArrayOfString.m_http_status = 2002;
        break label204;
      }
      paramArrayOfString.m_request_status = 2106;
      break label204;
      label409:
      if (this.mRetriedSouth) {
        break label306;
      }
      this.mRetriedSouth = true;
      setupUploadConnection(this.mSouthUpUrl, paramArrayOfString, paramFloat, paramInt);
      break label306;
      paramString.m_request_status = 2106;
    }
  }
  
  private class AudioData
  {
    public byte[] mData;
    public boolean mIsLast;
    public int mType;
    
    public AudioData(int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      this.mType = paramInt;
      this.mIsLast = paramBoolean;
      int i1 = paramArrayOfByte.length + 1;
      int i = (byte)(i1 & 0xFF);
      int j = (byte)(i1 >> 8 & 0xFF);
      int k = (byte)(i1 >> 16 & 0xFF);
      int m = (byte)(i1 >> 24);
      int n = (byte)paramInt;
      this.mData = new byte[i1 + 4];
      this$1 = this.mData;
      System.arraycopy(new byte[] { i, j, k, m }, 0, BDSHttpRequestMaker.this, 0, 4);
      this$1 = this.mData;
      System.arraycopy(new byte[] { n }, 0, BDSHttpRequestMaker.this, 4, 1);
      System.arraycopy(paramArrayOfByte, 0, this.mData, 5, paramArrayOfByte.length);
      if ((Log.isLoggable("BDSHttpRequestMaker", 3)) || (BDSHttpRequestMaker.DEBUG.booleanValue())) {
        Log.i("BDSHttpRequestMaker", "AudioData : mType = " + this.mType + " | mIsLast = " + this.mIsLast + " | mData = " + this.mData.length);
      }
    }
  }
  
  private class MyDownloadThread
    extends Thread
  {
    private MyDownloadThread() {}
    
    public void run() {}
  }
  
  private class MyUploadThread
    extends Thread
  {
    BDSHttpRequestMaker.AudioData ad = new BDSHttpRequestMaker.AudioData(BDSHttpRequestMaker.this, 9, new byte[0], true);
    
    private MyUploadThread() {}
    
    public void run()
    {
      BDSHttpRequestMaker.this.sendData(this.ad.mData, false);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/speech/core/BDSHttpRequestMaker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */