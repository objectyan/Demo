package com.baidu.navi.favorite.sync;

import android.os.Handler;
import android.util.Base64;
import com.baidu.carlife.k.a.e.a;
import com.baidu.navi.favorite.http.FamilyAndCompanySyncRequest;
import com.baidu.navi.favorite.model.FamilyAndCompanyRequestModel;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.common.PreferenceHelper;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class FamilyAndCompanySyncManager
{
  public static final int SYNC_FAIL = 1;
  public static final int SYNC_NETWORK_FAIL = 2;
  public static final int SYNC_SUCCESS = 0;
  public static final String TAG = FamilyAndCompanySyncManager.class.getSimpleName();
  private static FamilyAndCompanySyncManager mInstance;
  private String authId;
  private String authToken;
  private boolean isSyncing = false;
  private FamilyAndCompanyRequestModel mSyncData;
  private Handler mSyncHandler;
  private FamilyAndCompanySyncRequest mSyncRequest;
  e.a mSyncResponseListener = new e.a()
  {
    public void onNetWorkResponse(int paramAnonymousInt)
    {
      switch (paramAnonymousInt)
      {
      case -3: 
      default: 
        FamilyAndCompanySyncManager.access$002(FamilyAndCompanySyncManager.this, false);
        if (FamilyAndCompanySyncManager.this.mSyncHandler != null) {
          FamilyAndCompanySyncManager.this.mSyncHandler.sendEmptyMessage(1);
        }
        break;
      }
      do
      {
        do
        {
          do
          {
            return;
            FamilyAndCompanySyncManager.access$002(FamilyAndCompanySyncManager.this, false);
          } while (FamilyAndCompanySyncManager.this.mSyncHandler == null);
          FamilyAndCompanySyncManager.this.mSyncHandler.sendEmptyMessage(0);
          return;
          FamilyAndCompanySyncManager.access$002(FamilyAndCompanySyncManager.this, false);
        } while (FamilyAndCompanySyncManager.this.mSyncHandler == null);
        FamilyAndCompanySyncManager.this.mSyncHandler.sendEmptyMessage(1);
        return;
        FamilyAndCompanySyncManager.access$002(FamilyAndCompanySyncManager.this, false);
      } while (FamilyAndCompanySyncManager.this.mSyncHandler == null);
      FamilyAndCompanySyncManager.this.mSyncHandler.sendEmptyMessage(2);
    }
  };
  
  public static String byte2hex(byte[] paramArrayOfByte)
  {
    String str1 = "";
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      String str2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str2.length() == 1) {}
      for (str1 = str1 + "0" + str2;; str1 = str1 + str2)
      {
        i += 1;
        break;
      }
    }
    return str1.toUpperCase();
  }
  
  private FamilyAndCompanyRequestModel getFamilyAndCompanyParams()
  {
    FamilyAndCompanyRequestModel localFamilyAndCompanyRequestModel = new FamilyAndCompanyRequestModel();
    localFamilyAndCompanyRequestModel.setBduss(NaviAccountUtils.getInstance().syncGetBduss());
    String str = getFamilyAndCompanyData();
    long l = System.currentTimeMillis();
    this.authId = PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getString("sync_auth_id", "");
    this.authToken = PreferenceHelper.getInstance(BNaviModuleManager.getContext()).getString("sync_auth_token", "");
    localFamilyAndCompanyRequestModel.setCtime(l + "");
    localFamilyAndCompanyRequestModel.setData(str);
    localFamilyAndCompanyRequestModel.setSign(getSign(str, l));
    localFamilyAndCompanyRequestModel.setAuthId(this.authId);
    return localFamilyAndCompanyRequestModel;
  }
  
  public static FamilyAndCompanySyncManager getInstance()
  {
    if (mInstance == null) {}
    try
    {
      if (mInstance == null)
      {
        mInstance = new FamilyAndCompanySyncManager();
        mInstance.init();
      }
      return mInstance;
    }
    finally {}
  }
  
  private void init()
  {
    this.mSyncRequest = new FamilyAndCompanySyncRequest();
    this.mSyncRequest.registerResponseListener(this.mSyncResponseListener);
  }
  
  private void sendSyncRequest()
  {
    if (this.mSyncData != null)
    {
      this.isSyncing = true;
      if (this.mSyncRequest == null)
      {
        this.mSyncRequest = new FamilyAndCompanySyncRequest();
        this.mSyncRequest.registerResponseListener(this.mSyncResponseListener);
      }
      this.mSyncRequest.setParamsModel(this.mSyncData);
      this.mSyncRequest.toPostRequest();
    }
    do
    {
      return;
      this.isSyncing = false;
    } while (this.mSyncHandler == null);
    this.mSyncHandler.sendEmptyMessage(1);
  }
  
  /* Error */
  public String getFamilyAndCompanyData()
  {
    // Byte code:
    //   0: new 192	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 193	org/json/JSONObject:<init>	()V
    //   7: astore 8
    //   9: new 195	org/json/JSONArray
    //   12: dup
    //   13: invokespecial 196	org/json/JSONArray:<init>	()V
    //   16: astore 9
    //   18: invokestatic 120	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   21: invokestatic 125	com/baidu/navisdk/util/common/PreferenceHelper:getInstance	(Landroid/content/Context;)Lcom/baidu/navisdk/util/common/PreferenceHelper;
    //   24: ldc -58
    //   26: iconst_0
    //   27: invokevirtual 202	com/baidu/navisdk/util/common/PreferenceHelper:getBoolean	(Ljava/lang/String;Z)Z
    //   30: istore_3
    //   31: invokestatic 120	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   34: invokestatic 125	com/baidu/navisdk/util/common/PreferenceHelper:getInstance	(Landroid/content/Context;)Lcom/baidu/navisdk/util/common/PreferenceHelper;
    //   37: ldc -52
    //   39: iconst_0
    //   40: invokevirtual 202	com/baidu/navisdk/util/common/PreferenceHelper:getBoolean	(Ljava/lang/String;Z)Z
    //   43: istore 4
    //   45: iload_3
    //   46: ifeq +272 -> 318
    //   49: iload 4
    //   51: ifne +267 -> 318
    //   54: invokestatic 120	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   57: invokestatic 210	com/baidu/navisdk/model/AddressSettingModel:hasSetHomeAddr	(Landroid/content/Context;)Z
    //   60: ifeq +218 -> 278
    //   63: invokestatic 120	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   66: invokestatic 214	com/baidu/navisdk/model/AddressSettingModel:getHomeLon	(Landroid/content/Context;)I
    //   69: i2d
    //   70: ldc2_w 215
    //   73: ddiv
    //   74: invokestatic 120	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   77: invokestatic 219	com/baidu/navisdk/model/AddressSettingModel:getHomeLat	(Landroid/content/Context;)I
    //   80: i2d
    //   81: ldc2_w 215
    //   84: ddiv
    //   85: invokestatic 225	com/baidu/navisdk/util/common/CoordinateTransformUtil:LL2MC	(DD)Landroid/os/Bundle;
    //   88: astore 5
    //   90: iconst_0
    //   91: istore_1
    //   92: iconst_0
    //   93: istore_2
    //   94: aload 5
    //   96: ifnull +19 -> 115
    //   99: aload 5
    //   101: ldc -29
    //   103: invokevirtual 233	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   106: istore_1
    //   107: aload 5
    //   109: ldc -21
    //   111: invokevirtual 233	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   114: istore_2
    //   115: new 192	org/json/JSONObject
    //   118: dup
    //   119: invokespecial 193	org/json/JSONObject:<init>	()V
    //   122: astore 6
    //   124: aload 6
    //   126: astore 5
    //   128: aload 6
    //   130: ldc -19
    //   132: ldc -17
    //   134: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   137: pop
    //   138: aload 6
    //   140: astore 5
    //   142: aload 6
    //   144: ldc -11
    //   146: invokestatic 120	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   149: invokestatic 249	com/baidu/navisdk/model/AddressSettingModel:getHomeName	(Landroid/content/Context;)Ljava/lang/String;
    //   152: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   155: pop
    //   156: aload 6
    //   158: astore 5
    //   160: aload 6
    //   162: ldc -5
    //   164: iload_1
    //   165: invokevirtual 254	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   168: pop
    //   169: aload 6
    //   171: astore 5
    //   173: aload 6
    //   175: ldc_w 256
    //   178: iload_2
    //   179: invokevirtual 254	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   182: pop
    //   183: aload 6
    //   185: astore 5
    //   187: aload 6
    //   189: ldc_w 258
    //   192: invokestatic 120	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   195: invokestatic 261	com/baidu/navisdk/model/AddressSettingModel:getHomePoiOriginUID	(Landroid/content/Context;)Ljava/lang/String;
    //   198: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   201: pop
    //   202: aload 9
    //   204: aload 6
    //   206: invokevirtual 264	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   209: pop
    //   210: aload 8
    //   212: ldc_w 266
    //   215: aload 9
    //   217: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   220: pop
    //   221: aload 8
    //   223: ldc_w 268
    //   226: invokestatic 273	com/baidu/navisdk/util/common/PackageUtil:getCuid	()Ljava/lang/String;
    //   229: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   232: pop
    //   233: ldc_w 275
    //   236: new 74	java/lang/StringBuilder
    //   239: dup
    //   240: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   243: ldc_w 277
    //   246: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: aload 8
    //   251: invokevirtual 280	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   254: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: invokestatic 286	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   260: ldc_w 288
    //   263: aload 8
    //   265: invokevirtual 289	org/json/JSONObject:toString	()Ljava/lang/String;
    //   268: invokevirtual 293	java/lang/String:getBytes	()[B
    //   271: invokestatic 299	com/baidu/platform/comapi/util/a:a	(Ljava/lang/String;[B)[B
    //   274: invokestatic 301	com/baidu/navi/favorite/sync/FamilyAndCompanySyncManager:byte2hex	([B)Ljava/lang/String;
    //   277: areturn
    //   278: new 192	org/json/JSONObject
    //   281: dup
    //   282: invokespecial 193	org/json/JSONObject:<init>	()V
    //   285: astore 6
    //   287: aload 6
    //   289: astore 5
    //   291: aload 6
    //   293: ldc -19
    //   295: ldc -17
    //   297: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   300: pop
    //   301: aload 6
    //   303: astore 5
    //   305: aload 6
    //   307: ldc -11
    //   309: ldc 60
    //   311: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   314: pop
    //   315: goto -113 -> 202
    //   318: iload_3
    //   319: ifne +218 -> 537
    //   322: iload 4
    //   324: ifeq +213 -> 537
    //   327: invokestatic 120	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   330: invokestatic 304	com/baidu/navisdk/model/AddressSettingModel:hasSetCompAddr	(Landroid/content/Context;)Z
    //   333: ifeq +163 -> 496
    //   336: invokestatic 120	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   339: invokestatic 307	com/baidu/navisdk/model/AddressSettingModel:getCompLon	(Landroid/content/Context;)I
    //   342: i2d
    //   343: ldc2_w 215
    //   346: ddiv
    //   347: invokestatic 120	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   350: invokestatic 310	com/baidu/navisdk/model/AddressSettingModel:getCompLat	(Landroid/content/Context;)I
    //   353: i2d
    //   354: ldc2_w 215
    //   357: ddiv
    //   358: invokestatic 225	com/baidu/navisdk/util/common/CoordinateTransformUtil:LL2MC	(DD)Landroid/os/Bundle;
    //   361: astore 5
    //   363: iconst_0
    //   364: istore_1
    //   365: iconst_0
    //   366: istore_2
    //   367: aload 5
    //   369: ifnull +19 -> 388
    //   372: aload 5
    //   374: ldc -29
    //   376: invokevirtual 233	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   379: istore_1
    //   380: aload 5
    //   382: ldc -21
    //   384: invokevirtual 233	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   387: istore_2
    //   388: new 192	org/json/JSONObject
    //   391: dup
    //   392: invokespecial 193	org/json/JSONObject:<init>	()V
    //   395: astore 6
    //   397: aload 6
    //   399: astore 5
    //   401: aload 6
    //   403: ldc -19
    //   405: ldc_w 312
    //   408: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   411: pop
    //   412: aload 6
    //   414: astore 5
    //   416: aload 6
    //   418: ldc -11
    //   420: invokestatic 120	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   423: invokestatic 315	com/baidu/navisdk/model/AddressSettingModel:getCompName	(Landroid/content/Context;)Ljava/lang/String;
    //   426: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   429: pop
    //   430: aload 6
    //   432: astore 5
    //   434: aload 6
    //   436: ldc -5
    //   438: iload_1
    //   439: invokevirtual 254	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   442: pop
    //   443: aload 6
    //   445: astore 5
    //   447: aload 6
    //   449: ldc_w 256
    //   452: iload_2
    //   453: invokevirtual 254	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   456: pop
    //   457: aload 6
    //   459: astore 5
    //   461: aload 6
    //   463: ldc_w 258
    //   466: invokestatic 120	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   469: invokestatic 318	com/baidu/navisdk/model/AddressSettingModel:getCompPoiOriginUID	(Landroid/content/Context;)Ljava/lang/String;
    //   472: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   475: pop
    //   476: aload 9
    //   478: aload 6
    //   480: invokevirtual 264	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   483: pop
    //   484: goto -274 -> 210
    //   487: astore 5
    //   489: aload 5
    //   491: invokevirtual 321	java/lang/Exception:printStackTrace	()V
    //   494: aconst_null
    //   495: areturn
    //   496: new 192	org/json/JSONObject
    //   499: dup
    //   500: invokespecial 193	org/json/JSONObject:<init>	()V
    //   503: astore 6
    //   505: aload 6
    //   507: astore 5
    //   509: aload 6
    //   511: ldc -19
    //   513: ldc_w 312
    //   516: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   519: pop
    //   520: aload 6
    //   522: astore 5
    //   524: aload 6
    //   526: ldc -11
    //   528: ldc 60
    //   530: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   533: pop
    //   534: goto -58 -> 476
    //   537: iload_3
    //   538: ifeq -328 -> 210
    //   541: iload 4
    //   543: ifeq -333 -> 210
    //   546: invokestatic 120	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   549: invokestatic 210	com/baidu/navisdk/model/AddressSettingModel:hasSetHomeAddr	(Landroid/content/Context;)Z
    //   552: ifeq +334 -> 886
    //   555: new 192	org/json/JSONObject
    //   558: dup
    //   559: invokespecial 193	org/json/JSONObject:<init>	()V
    //   562: astore 6
    //   564: aload 6
    //   566: astore 5
    //   568: invokestatic 120	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   571: invokestatic 214	com/baidu/navisdk/model/AddressSettingModel:getHomeLon	(Landroid/content/Context;)I
    //   574: i2d
    //   575: ldc2_w 215
    //   578: ddiv
    //   579: invokestatic 120	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   582: invokestatic 219	com/baidu/navisdk/model/AddressSettingModel:getHomeLat	(Landroid/content/Context;)I
    //   585: i2d
    //   586: ldc2_w 215
    //   589: ddiv
    //   590: invokestatic 225	com/baidu/navisdk/util/common/CoordinateTransformUtil:LL2MC	(DD)Landroid/os/Bundle;
    //   593: astore 7
    //   595: iconst_0
    //   596: istore_1
    //   597: iconst_0
    //   598: istore_2
    //   599: aload 7
    //   601: ifnull +27 -> 628
    //   604: aload 6
    //   606: astore 5
    //   608: aload 7
    //   610: ldc -29
    //   612: invokevirtual 233	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   615: istore_1
    //   616: aload 6
    //   618: astore 5
    //   620: aload 7
    //   622: ldc -21
    //   624: invokevirtual 233	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   627: istore_2
    //   628: aload 6
    //   630: astore 5
    //   632: aload 6
    //   634: ldc -19
    //   636: ldc -17
    //   638: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   641: pop
    //   642: aload 6
    //   644: astore 5
    //   646: aload 6
    //   648: ldc -11
    //   650: invokestatic 120	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   653: invokestatic 249	com/baidu/navisdk/model/AddressSettingModel:getHomeName	(Landroid/content/Context;)Ljava/lang/String;
    //   656: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   659: pop
    //   660: aload 6
    //   662: astore 5
    //   664: aload 6
    //   666: ldc -5
    //   668: iload_1
    //   669: invokevirtual 254	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   672: pop
    //   673: aload 6
    //   675: astore 5
    //   677: aload 6
    //   679: ldc_w 256
    //   682: iload_2
    //   683: invokevirtual 254	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   686: pop
    //   687: aload 6
    //   689: astore 5
    //   691: aload 6
    //   693: ldc_w 258
    //   696: invokestatic 120	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   699: invokestatic 261	com/baidu/navisdk/model/AddressSettingModel:getHomePoiOriginUID	(Landroid/content/Context;)Ljava/lang/String;
    //   702: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   705: pop
    //   706: invokestatic 120	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   709: invokestatic 304	com/baidu/navisdk/model/AddressSettingModel:hasSetCompAddr	(Landroid/content/Context;)Z
    //   712: ifeq +214 -> 926
    //   715: new 192	org/json/JSONObject
    //   718: dup
    //   719: invokespecial 193	org/json/JSONObject:<init>	()V
    //   722: astore 7
    //   724: aload 7
    //   726: astore 5
    //   728: invokestatic 120	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   731: invokestatic 307	com/baidu/navisdk/model/AddressSettingModel:getCompLon	(Landroid/content/Context;)I
    //   734: i2d
    //   735: ldc2_w 215
    //   738: ddiv
    //   739: invokestatic 120	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   742: invokestatic 310	com/baidu/navisdk/model/AddressSettingModel:getCompLat	(Landroid/content/Context;)I
    //   745: i2d
    //   746: ldc2_w 215
    //   749: ddiv
    //   750: invokestatic 225	com/baidu/navisdk/util/common/CoordinateTransformUtil:LL2MC	(DD)Landroid/os/Bundle;
    //   753: astore 10
    //   755: iconst_0
    //   756: istore_1
    //   757: iconst_0
    //   758: istore_2
    //   759: aload 10
    //   761: ifnull +27 -> 788
    //   764: aload 7
    //   766: astore 5
    //   768: aload 10
    //   770: ldc -29
    //   772: invokevirtual 233	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   775: istore_1
    //   776: aload 7
    //   778: astore 5
    //   780: aload 10
    //   782: ldc -21
    //   784: invokevirtual 233	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   787: istore_2
    //   788: aload 7
    //   790: astore 5
    //   792: aload 7
    //   794: ldc -19
    //   796: ldc_w 312
    //   799: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   802: pop
    //   803: aload 7
    //   805: astore 5
    //   807: aload 7
    //   809: ldc -11
    //   811: invokestatic 120	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   814: invokestatic 315	com/baidu/navisdk/model/AddressSettingModel:getCompName	(Landroid/content/Context;)Ljava/lang/String;
    //   817: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   820: pop
    //   821: aload 7
    //   823: astore 5
    //   825: aload 7
    //   827: ldc -5
    //   829: iload_1
    //   830: invokevirtual 254	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   833: pop
    //   834: aload 7
    //   836: astore 5
    //   838: aload 7
    //   840: ldc_w 256
    //   843: iload_2
    //   844: invokevirtual 254	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   847: pop
    //   848: aload 7
    //   850: astore 5
    //   852: aload 7
    //   854: ldc_w 258
    //   857: invokestatic 120	com/baidu/navisdk/BNaviModuleManager:getContext	()Landroid/content/Context;
    //   860: invokestatic 318	com/baidu/navisdk/model/AddressSettingModel:getCompPoiOriginUID	(Landroid/content/Context;)Ljava/lang/String;
    //   863: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   866: pop
    //   867: aload 9
    //   869: aload 6
    //   871: invokevirtual 264	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   874: pop
    //   875: aload 9
    //   877: aload 7
    //   879: invokevirtual 264	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   882: pop
    //   883: goto -673 -> 210
    //   886: new 192	org/json/JSONObject
    //   889: dup
    //   890: invokespecial 193	org/json/JSONObject:<init>	()V
    //   893: astore 6
    //   895: aload 6
    //   897: astore 5
    //   899: aload 6
    //   901: ldc -19
    //   903: ldc -17
    //   905: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   908: pop
    //   909: aload 6
    //   911: astore 5
    //   913: aload 6
    //   915: ldc -11
    //   917: ldc 60
    //   919: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   922: pop
    //   923: goto -217 -> 706
    //   926: new 192	org/json/JSONObject
    //   929: dup
    //   930: invokespecial 193	org/json/JSONObject:<init>	()V
    //   933: astore 7
    //   935: aload 7
    //   937: astore 5
    //   939: aload 7
    //   941: ldc -19
    //   943: ldc_w 312
    //   946: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   949: pop
    //   950: aload 7
    //   952: astore 5
    //   954: aload 7
    //   956: ldc -11
    //   958: ldc 60
    //   960: invokevirtual 243	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   963: pop
    //   964: goto -97 -> 867
    //   967: astore 5
    //   969: goto -480 -> 489
    //   972: astore 5
    //   974: goto -485 -> 489
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	977	0	this	FamilyAndCompanySyncManager
    //   91	739	1	i	int
    //   93	751	2	j	int
    //   30	508	3	bool1	boolean
    //   43	499	4	bool2	boolean
    //   88	372	5	localObject1	Object
    //   487	3	5	localException1	Exception
    //   507	446	5	localObject2	Object
    //   967	1	5	localException2	Exception
    //   972	1	5	localException3	Exception
    //   122	792	6	localJSONObject1	org.json.JSONObject
    //   593	362	7	localObject3	Object
    //   7	257	8	localJSONObject2	org.json.JSONObject
    //   16	860	9	localJSONArray	org.json.JSONArray
    //   753	28	10	localBundle	android.os.Bundle
    // Exception table:
    //   from	to	target	type
    //   18	45	487	java/lang/Exception
    //   54	90	487	java/lang/Exception
    //   99	115	487	java/lang/Exception
    //   115	124	487	java/lang/Exception
    //   202	210	487	java/lang/Exception
    //   210	278	487	java/lang/Exception
    //   278	287	487	java/lang/Exception
    //   327	363	487	java/lang/Exception
    //   372	388	487	java/lang/Exception
    //   388	397	487	java/lang/Exception
    //   476	484	487	java/lang/Exception
    //   496	505	487	java/lang/Exception
    //   546	564	487	java/lang/Exception
    //   706	724	487	java/lang/Exception
    //   867	883	487	java/lang/Exception
    //   886	895	487	java/lang/Exception
    //   926	935	487	java/lang/Exception
    //   128	138	967	java/lang/Exception
    //   142	156	967	java/lang/Exception
    //   160	169	967	java/lang/Exception
    //   173	183	967	java/lang/Exception
    //   187	202	967	java/lang/Exception
    //   291	301	967	java/lang/Exception
    //   305	315	967	java/lang/Exception
    //   568	595	967	java/lang/Exception
    //   608	616	967	java/lang/Exception
    //   620	628	967	java/lang/Exception
    //   632	642	967	java/lang/Exception
    //   646	660	967	java/lang/Exception
    //   664	673	967	java/lang/Exception
    //   677	687	967	java/lang/Exception
    //   691	706	967	java/lang/Exception
    //   899	909	967	java/lang/Exception
    //   913	923	967	java/lang/Exception
    //   401	412	972	java/lang/Exception
    //   416	430	972	java/lang/Exception
    //   434	443	972	java/lang/Exception
    //   447	457	972	java/lang/Exception
    //   461	476	972	java/lang/Exception
    //   509	520	972	java/lang/Exception
    //   524	534	972	java/lang/Exception
    //   728	755	972	java/lang/Exception
    //   768	776	972	java/lang/Exception
    //   780	788	972	java/lang/Exception
    //   792	803	972	java/lang/Exception
    //   807	821	972	java/lang/Exception
    //   825	834	972	java/lang/Exception
    //   838	848	972	java/lang/Exception
    //   852	867	972	java/lang/Exception
    //   939	950	972	java/lang/Exception
    //   954	964	972	java/lang/Exception
  }
  
  public String getSign(String paramString, long paramLong)
  {
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      paramString = URLEncoder.encode(getSign(this.authId, this.authToken, paramString, Long.valueOf(paramLong)), "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
      return null;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public String getSign(String paramString1, String paramString2, String paramString3, Long paramLong)
  {
    return hmacSha1(paramString2, paramString1 + paramLong + paramString3);
  }
  
  public String hmacSha1(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new SecretKeySpec(paramString1.getBytes("UTF-8"), "HmacSHA1");
      Mac localMac = Mac.getInstance("HmacSHA1");
      localMac.init(paramString1);
      paramString1 = Base64.encodeToString(localMac.doFinal(paramString2.getBytes("UTF-8")), 0).trim();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
    }
    return "";
  }
  
  public boolean isSyncing()
  {
    return this.isSyncing;
  }
  
  public void setAuthId(String paramString)
  {
    this.authId = paramString;
  }
  
  public void setAuthToken(String paramString)
  {
    this.authToken = paramString;
  }
  
  public void setSyncing(boolean paramBoolean)
  {
    this.isSyncing = paramBoolean;
  }
  
  public void setmSyncHandler(Handler paramHandler)
  {
    this.mSyncHandler = paramHandler;
  }
  
  public void startSync()
  {
    try
    {
      this.isSyncing = true;
      this.mSyncData = getFamilyAndCompanyParams();
      sendSyncRequest();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void stopSync()
  {
    try
    {
      if (this.mSyncRequest != null)
      {
        this.mSyncRequest.cancel();
        this.isSyncing = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/favorite/sync/FamilyAndCompanySyncManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */