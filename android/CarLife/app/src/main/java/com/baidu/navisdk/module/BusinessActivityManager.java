package com.baidu.navisdk.module;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.lightnavi.controller.BNLightNaviManager;
import com.baidu.navisdk.lightnavi.viewhelp.LightNaviDialogHelper;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpPostFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpPostFunc.Callback;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc.Callback;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.RoadConditionItem;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.BusinessActivityModel;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.module.business.BusinessActivityPlayerManager;
import com.baidu.navisdk.module.business.BusinessActivityViewManager;
import com.baidu.navisdk.module.business.FileCache;
import com.baidu.navisdk.module.cloudconfig.CloudConfigObtainManager;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel;
import com.baidu.navisdk.module.cloudconfig.CloudlConfigDataModel.CommonConfig;
import com.baidu.navisdk.naviresult.BNNaviResultController;
import com.baidu.navisdk.naviresult.BNNaviResultController.DataDownloadState;
import com.baidu.navisdk.naviresult.BNNaviResultController.DataDownloadType;
import com.baidu.navisdk.naviresult.BNNaviResultModel;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGAssistGuideModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.voice.controller.VoiceHelper;
import com.baidu.navisdk.ui.widget.BNCommonProgressDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.MD5;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.HttpURLManager.ULRParam;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import com.baidu.navisdk.util.http.center.IBNHttpCenter;
import com.baidu.navisdk.util.logic.BNExtGPSLocationManager;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import com.baidu.navisdk.vi.VDeviceAPI;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

public class BusinessActivityManager
{
  public static final String AUDIO_DIR = "activity";
  public static final String AUDIO_END_NAVI_NAME = "en.mp3";
  public static final String AUDIO_ENVELOPO_EFFECT_NAME = "evelopo.mp3";
  public static final String AUDIO_SHOW_ACTIVITY_NAME = "sa.mp3";
  public static final String AUDIO_START_NAVI_NAME = "sn.mp3";
  public static final String GET_ACT_OFFLINE_URL = "http://cp01-navi-server-1.epc.baidu.com:8080/mop/getacts";
  public static final String GET_ACT_ONLINE_URL = HttpURLManager.getInstance().getScheme() + "appnavi.baidu.com/mop/getacts";
  public static final int MSG_BUSINESSACTIVITY_REQUEST_RET = 1500;
  public static final int MSG_BUSINESSACTIVITY_UPLOAD_REQUEST_FOR_NAVING = 1505;
  public static final int MSG_BUSINESSACTIVITY_UPLOAD_RET = 1501;
  public static final int MSG_BUSINESSACTIVITY_UPLOAD_RET_FOR_NAVING = 1502;
  public static final int MSG_NAV_END_GET_SHARE_CONTENT_RET = 1503;
  public static final int MSG_NAV_END_MARK_TRAJECTORY_RET = 1504;
  private static final int MSG_NAV_SAFETY_SHARE_CHANGE = 1702;
  private static final int MSG_NAV_SAFETY_SHARE_END = 1701;
  private static final int MSG_NAV_SAFETY_SHARE_START = 1700;
  private static final int MSG_REQUEST_AUDIO_END_NAVI = 1515;
  private static final int MSG_REQUEST_AUDIO_SHOW_ACTIVITY = 1516;
  private static final int MSG_REQUEST_AUDIO_START_NAVI = 1514;
  private static final int MSG_REQUEST_BITMAP_BANNER = 1511;
  private static final int MSG_REQUEST_BITMAP_ENVELOPE_BTN_CLICKED = 1531;
  private static final int MSG_REQUEST_BITMAP_ENVELOPE_BTN_NORMAL = 1530;
  private static final int MSG_REQUEST_BITMAP_ENVELOPE_MID = 1532;
  private static final int MSG_REQUEST_BITMAP_ENVELOPE_PLUS = 1533;
  private static final int MSG_REQUEST_BITMAP_ENVELOPE_SOUND_EFFECT = 1535;
  private static final int MSG_REQUEST_BITMAP_ENVELOPE_WINDOW_BG = 1534;
  private static final int MSG_REQUEST_BITMAP_LOGO = 1510;
  private static final int MSG_REQUEST_BITMAP_NAVIENDPIC = 1513;
  private static final int MSG_REQUEST_BITMAP_OPERATION_ACTIVITY_PICTURE = 1538;
  private static final int MSG_REQUEST_BITMAP_RICON = 1512;
  private static final int MSG_REQUEST_BITMAP_USER_RIGHT_CAR_ICON = 1536;
  public static final int MSG_REQUEST_BITMAP_USER_RIGHT_ICON_END = 1539;
  private static final int MSG_TEST_SAVE_BITMAP = 1620;
  private static final int MSG_TEST_SHOW_BUSINESS_VIEW = 1621;
  public static final String TAG = BusinessActivityManager.class.getSimpleName();
  public static final String UPLOAD_OFFLINE_URL = "http://cp01-navi-server-1.epc.baidu.com:8080/mop/naviend/upload";
  public static final String UPLOAD_ONLINE_URL = HttpURLManager.getInstance().getScheme() + "appnavi.baidu.com/mop/naviend/upload";
  private static Object mSyncObj = new Object();
  private static BusinessActivityManager sInstance = null;
  public boolean isCancelShareSafe = false;
  private boolean isOrientationUser = false;
  public boolean isShareSuc = false;
  private BusinessActivityModel mBusinessActivityModel = null;
  private Handler mHD = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (1500 == paramAnonymousMessage.what) {
        if (paramAnonymousMessage.arg1 == 0)
        {
          LogUtil.e(BusinessActivityManager.TAG, "handleMessage()");
          if (BusinessActivityManager.this.mOuterHandler != null) {
            BusinessActivityManager.this.mOuterHandler.sendEmptyMessage(BusinessActivityManager.this.mOuterMsgWhat);
          }
        }
      }
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                if (1620 != paramAnonymousMessage.what) {
                  break;
                }
              } while (BusinessActivityManager.this.mBusinessActivityModel == null);
              BusinessActivityManager.this.mBusinessActivityModel.testSaveBitmap();
              return;
              if (1621 == paramAnonymousMessage.what)
              {
                BusinessActivityViewManager.getInstance().showViews(BNavigator.getInstance().getActivity(), false);
                TipTool.onCreateToastDialog(BNavigator.getInstance().getActivity(), "测试超时触发商业水滴显示");
                return;
              }
              if (1510 == paramAnonymousMessage.what)
              {
                BusinessActivityManager.this.requestBitmap(1511);
                return;
              }
              if (1511 == paramAnonymousMessage.what)
              {
                BusinessActivityManager.this.requestBitmap(1512);
                return;
              }
              if (1512 == paramAnonymousMessage.what)
              {
                BusinessActivityManager.this.requestBitmap(1513);
                return;
              }
              if (1513 == paramAnonymousMessage.what)
              {
                BusinessActivityManager.this.requestAudio(1516);
                return;
              }
              if (1514 == paramAnonymousMessage.what)
              {
                BusinessActivityManager.this.requestBitmap(1510);
                BusinessActivityPlayerManager.getInstance().playNaviStartContent();
                return;
              }
              if (1515 == paramAnonymousMessage.what)
              {
                BusinessActivityManager.this.requestBitmap(1530);
                return;
              }
              if (1516 == paramAnonymousMessage.what)
              {
                BusinessActivityManager.this.requestAudio(1515);
                return;
              }
              if (1530 == paramAnonymousMessage.what)
              {
                BusinessActivityManager.this.requestBitmap(1531);
                return;
              }
              if (1531 == paramAnonymousMessage.what)
              {
                BusinessActivityManager.this.requestBitmap(1532);
                return;
              }
              if (1532 == paramAnonymousMessage.what)
              {
                BusinessActivityManager.this.requestBitmap(1533);
                return;
              }
              if (1533 == paramAnonymousMessage.what)
              {
                BusinessActivityManager.this.requestBitmap(1534);
                return;
              }
              if (1534 == paramAnonymousMessage.what)
              {
                BusinessActivityManager.this.requestAudio(1535);
                return;
              }
              if (1535 == paramAnonymousMessage.what)
              {
                BusinessActivityManager.this.requestBitmap(1536);
                return;
              }
              if (1536 == paramAnonymousMessage.what)
              {
                BusinessActivityManager.this.requestBitmap(1538);
                if (BusinessActivityManager.this.mBusinessActivityModel.userPerCarLogoBitmap != null)
                {
                  BNRouteGuider.getInstance().setCarImageToMap(FileCache.getCacheFilePath(BusinessActivityManager.this.mBusinessActivityModel.userPerCarLogoLink, ""));
                  return;
                }
                BNRouteGuider.getInstance().clearCarImage();
                return;
              }
              if (1538 == paramAnonymousMessage.what)
              {
                LogUtil.e(BusinessActivityManager.TAG, "reuqest completed.");
                return;
              }
              if (1539 == paramAnonymousMessage.what)
              {
                BNNaviResultController.getInstance().notifyServerDataDownloadState(BNNaviResultController.DataDownloadType.IMG_DATA, BNNaviResultController.DataDownloadState.DOWNLOAD_FINISH);
                return;
              }
              if (1501 == paramAnonymousMessage.what)
              {
                if (paramAnonymousMessage.arg1 == 0)
                {
                  LogUtil.e(BusinessActivityManager.TAG, "Navi End Upload --> SUCCESS, Now Notify NaviPage Update UI");
                  BNNaviResultController.getInstance().notifyServerDataDownloadState(BNNaviResultController.DataDownloadType.TXT_DATA, BNNaviResultController.DataDownloadState.DOWNLOAD_FINISH);
                  BusinessActivityManager.this.requestBitmap(1539);
                  return;
                }
                LogUtil.e(BusinessActivityManager.TAG, "Navi End Upload --> FAILED!!");
                BNNaviResultController.getInstance().notifyServerDataDownloadState(BNNaviResultController.DataDownloadType.TXT_DATA, BNNaviResultController.DataDownloadState.DOWNLOAD_FINISH);
                BNNaviResultController.getInstance().notifyServerDataDownloadState(BNNaviResultController.DataDownloadType.IMG_DATA, BNNaviResultController.DataDownloadState.DOWNLOAD_CANCEL);
                return;
              }
              if (1502 != paramAnonymousMessage.what) {
                break;
              }
            } while (BusinessActivityManager.this.mOuterUploadHandlerForNaving == null);
            BusinessActivityManager.this.mOuterUploadHandlerForNaving.obtainMessage(BusinessActivityManager.this.mOuterUploadMsgWhatForNaving).sendToTarget();
            return;
            if (1505 == paramAnonymousMessage.what)
            {
              BNWorkerCenter.getInstance().submitMainThreadTask(BusinessActivityManager.this.mUploadMileaTask, new BNWorkerConfig(100, 0));
              return;
            }
            if (1503 != paramAnonymousMessage.what) {
              break;
            }
          } while (BusinessActivityManager.this.mOutShareHandler == null);
          BusinessActivityManager.this.mOutShareHandler.obtainMessage(BusinessActivityManager.this.mOutShareMsgWhat).sendToTarget();
          return;
          if (1700 != paramAnonymousMessage.what) {
            break;
          }
          LogUtil.e(BusinessActivityManager.TAG, "safety MSG_NAV_SAFETY_SHARE_START  --> msg.arg1: " + paramAnonymousMessage.arg1);
          RGViewController.getInstance().hideSafetyShareLoading();
          LightNaviDialogHelper.getInstance(BNaviModuleManager.getContext()).dismissSafetyShareDialog();
          if (paramAnonymousMessage.arg1 == 0) {
            try
            {
              RspData localRspData = (RspData)paramAnonymousMessage.obj;
              if (localRspData != null)
              {
                JSONObject localJSONObject = (JSONObject)localRspData.mData;
                if (localJSONObject != null)
                {
                  int i = ((JSONObject)localRspData.mData).getInt("errno");
                  String str3 = ((JSONObject)localRspData.mData).getString("share_url");
                  paramAnonymousMessage = null;
                  String str1 = null;
                  String str2 = null;
                  if (localJSONObject.has("share_icon")) {
                    paramAnonymousMessage = ((JSONObject)localRspData.mData).getString("share_icon");
                  }
                  if (localJSONObject.has("share_title")) {
                    str1 = ((JSONObject)localRspData.mData).getString("share_title");
                  }
                  if (localJSONObject.has("share_desc")) {
                    str2 = ((JSONObject)localRspData.mData).getString("share_desc");
                  }
                  LogUtil.e(BusinessActivityManager.TAG, "safety  --> jSONObject: " + localJSONObject.toString());
                  if ((i == 0) && (!StringUtils.isEmpty(str3)))
                  {
                    BusinessActivityManager.getInstance().shareSafety(str3, paramAnonymousMessage, str1, str2);
                    return;
                  }
                }
              }
            }
            catch (Exception paramAnonymousMessage) {}
          }
        } while (BusinessActivityManager.this.isCancelShareSafe);
        TipTool.onCreateToastDialog(BNavigator.getInstance().getActivity(), "分享请求失败,请稍后重试");
        return;
        if (1701 == paramAnonymousMessage.what)
        {
          LogUtil.e(BusinessActivityManager.TAG, "safety MSG_NAV_SAFETY_SHARE_END  --> msg.arg1: " + paramAnonymousMessage.arg1);
          return;
        }
      } while (1702 != paramAnonymousMessage.what);
      LogUtil.e(BusinessActivityManager.TAG, "safety MSG_NAV_SAFETY_SHARE_CHANGE  --> msg.arg1: " + paramAnonymousMessage.arg1);
    }
  };
  private long mLastMilea;
  private Handler mOutShareHandler = null;
  private int mOutShareMsgWhat = -1;
  private Handler mOuterHandler = null;
  private int mOuterMsgWhat = -1;
  private Handler mOuterUploadHandler = null;
  private Handler mOuterUploadHandlerForNaving = null;
  private int mOuterUploadMsgWhat = -1;
  private int mOuterUploadMsgWhatForNaving = -1;
  private BNWorkerNormalTask<String, String> mUploadMileaTask = new BNWorkerNormalTask("mUploadMileaTask-" + getClass().getSimpleName(), null)
  {
    protected String execute()
    {
      String str = JNITrajectoryControl.sInstance.getCurrentUUID();
      if ((str != null) && (str.length() > 0))
      {
        long l = JNITrajectoryControl.sInstance.getTrajectoryLength(str);
        if (l - BusinessActivityManager.this.mLastMilea >= BusinessActivityManager.this.mBusinessActivityModel.uploadMileageInter)
        {
          Bundle localBundle = new Bundle();
          if (JNITrajectoryControl.sInstance.getPostParamsForNavingUpload(str, localBundle) != -1)
          {
            BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving = localBundle;
            BusinessActivityManager.this.uploadDataForNaving(BusinessActivityManager.this.mHD, 100);
            BusinessActivityManager.access$1502(BusinessActivityManager.this, l);
          }
        }
      }
      return null;
    }
  };
  private RoutePlanModel rpModel = null;
  
  private int checkParking(int paramInt1, int paramInt2)
  {
    if (!this.mBusinessActivityModel.isParkingEnabled())
    {
      LogUtil.e(TAG, "checkParking() check failed for disable");
      return 0;
    }
    if ((paramInt1 >= 3) || (paramInt2 < 200))
    {
      this.mBusinessActivityModel.resetParking();
      LogUtil.e(TAG, "checkParking() check failed. speed=" + paramInt1 + ", naviDis=" + paramInt2);
      return 0;
    }
    if ((RGSimpleGuideModel.getInstance().getNextGuideInfo() != null) && (RGSimpleGuideModel.getInstance().getNextGuideInfo().containsKey("remain_dist")) && (50 < RGSimpleGuideModel.getInstance().getNextGuideInfo().getInt("remain_dist")))
    {
      this.mBusinessActivityModel.resetParking();
      LogUtil.e(TAG, "checkParking() check failed. nextTurnDist=" + RGSimpleGuideModel.getInstance().getNextGuideInfo().getInt("remain_dist"));
      return 0;
    }
    if (this.mBusinessActivityModel.parkingStartTime <= 0L)
    {
      this.mBusinessActivityModel.parkingStartTime = SystemClock.elapsedRealtime();
      LogUtil.e(TAG, "checkParking() check time 1 ");
      return 1;
    }
    if (SystemClock.elapsedRealtime() - this.mBusinessActivityModel.parkingStartTime > 5000L)
    {
      this.mBusinessActivityModel.isParking = true;
      LogUtil.e(TAG, "checkParking() check ok speed=" + paramInt1);
      if (LogUtil.LOGGABLE) {
        TipTool.onCreateToastDialog(BNavigator.getInstance().getActivity(), "停车触发商业水滴显示");
      }
      return 2;
    }
    LogUtil.e(TAG, "checkParking() check time 2 ");
    return 1;
  }
  
  public static BusinessActivityManager getInstance()
  {
    if (sInstance == null) {}
    synchronized (mSyncObj)
    {
      if (sInstance == null) {
        sInstance = new BusinessActivityManager();
      }
      return sInstance;
    }
  }
  
  private int getObstructionIndexCount(List<RoadConditionItem> paramList, int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < paramList.size()) && (((RoadConditionItem)paramList.get(paramInt)).roadConditionType >= 3))
    {
      if (paramInt == 0) {}
      for (int i = ((RoadConditionItem)paramList.get(paramInt)).curItemEndIndex;; i = ((RoadConditionItem)paramList.get(paramInt)).curItemEndIndex - ((RoadConditionItem)paramList.get(paramInt - 1)).curItemEndIndex)
      {
        LogUtil.e(TAG, "getObstructionIndexCount() itemIndex=" + paramInt + ", roadConditionType=" + ((RoadConditionItem)paramList.get(paramInt)).roadConditionType + ", count=" + i);
        return i;
      }
    }
    return 0;
  }
  
  /* Error */
  private boolean parseBusinessActivityJSON(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +5 -> 6
    //   4: iconst_0
    //   5: ireturn
    //   6: getstatic 141	com/baidu/navisdk/module/BusinessActivityManager:TAG	Ljava/lang/String;
    //   9: new 148	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 405
    //   19: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: aload_1
    //   23: invokevirtual 408	org/json/JSONObject:toString	()Ljava/lang/String;
    //   26: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 298	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   39: ifnonnull +247 -> 286
    //   42: aload_0
    //   43: new 286	com/baidu/navisdk/model/modelfactory/BusinessActivityModel
    //   46: dup
    //   47: invokespecial 409	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:<init>	()V
    //   50: putfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   53: aload_0
    //   54: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   57: aload_1
    //   58: ldc_w 411
    //   61: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   64: putfield 414	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:errno	I
    //   67: aload_0
    //   68: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   71: aload_1
    //   72: ldc_w 416
    //   75: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   78: putfield 422	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:errmsg	Ljava/lang/String;
    //   81: aload_0
    //   82: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   85: getfield 414	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:errno	I
    //   88: ifne +277 -> 365
    //   91: aload_1
    //   92: ldc_w 424
    //   95: invokevirtual 428	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   98: astore_1
    //   99: aload_1
    //   100: ifnull +265 -> 365
    //   103: aload_1
    //   104: ldc_w 430
    //   107: invokevirtual 428	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   110: astore 4
    //   112: aload_0
    //   113: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   116: aload 4
    //   118: ldc_w 432
    //   121: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   124: putfield 435	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:compensationTitle	Ljava/lang/String;
    //   127: aload_0
    //   128: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   131: aload 4
    //   133: ldc_w 437
    //   136: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   139: putfield 440	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:compensationLink	Ljava/lang/String;
    //   142: aload_0
    //   143: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   146: aload_1
    //   147: ldc_w 442
    //   150: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   153: putfield 444	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:atype	I
    //   156: aload_0
    //   157: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   160: aload_1
    //   161: ldc_w 446
    //   164: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   167: putfield 448	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:timestamp	I
    //   170: aload_1
    //   171: ldc_w 450
    //   174: invokevirtual 454	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   177: astore 4
    //   179: aload 4
    //   181: ifnull +186 -> 367
    //   184: iconst_0
    //   185: istore_2
    //   186: iload_2
    //   187: aload 4
    //   189: invokevirtual 459	org/json/JSONArray:length	()I
    //   192: if_icmpge +175 -> 367
    //   195: aload 4
    //   197: iload_2
    //   198: invokevirtual 462	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   201: astore 5
    //   203: aload 5
    //   205: ifnull +74 -> 279
    //   208: aload 5
    //   210: ldc_w 464
    //   213: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   216: astore 6
    //   218: aload 6
    //   220: ifnull +76 -> 296
    //   223: aload 6
    //   225: ldc_w 466
    //   228: invokevirtual 472	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   231: ifeq +65 -> 296
    //   234: aload_0
    //   235: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   238: aload 5
    //   240: ldc_w 474
    //   243: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   246: putfield 477	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:voiceTextOnStartNavi	Ljava/lang/String;
    //   249: aload_0
    //   250: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   253: aload 5
    //   255: ldc_w 479
    //   258: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   261: putfield 482	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:voiceLinkOnStartNavi	Ljava/lang/String;
    //   264: aload_0
    //   265: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   268: aload 5
    //   270: ldc_w 484
    //   273: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   276: putfield 487	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:voicePriorityOnStartNavi	I
    //   279: iload_2
    //   280: iconst_1
    //   281: iadd
    //   282: istore_2
    //   283: goto -97 -> 186
    //   286: aload_0
    //   287: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   290: invokevirtual 490	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:clear	()V
    //   293: goto -240 -> 53
    //   296: aload 6
    //   298: ifnull -19 -> 279
    //   301: aload 6
    //   303: ldc_w 492
    //   306: invokevirtual 472	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   309: ifeq -30 -> 279
    //   312: aload_0
    //   313: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   316: aload 5
    //   318: ldc_w 474
    //   321: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   324: putfield 495	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:voiceTextOnEndNavi	Ljava/lang/String;
    //   327: aload_0
    //   328: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   331: aload 5
    //   333: ldc_w 479
    //   336: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   339: putfield 498	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:voiceLinkOnEndNavi	Ljava/lang/String;
    //   342: aload_0
    //   343: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   346: aload 5
    //   348: ldc_w 484
    //   351: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   354: putfield 501	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:voicePriorityOnEndNavi	I
    //   357: goto -78 -> 279
    //   360: astore_1
    //   361: aload_1
    //   362: invokevirtual 504	java/lang/Exception:printStackTrace	()V
    //   365: iconst_1
    //   366: ireturn
    //   367: aload_1
    //   368: ldc 28
    //   370: invokevirtual 428	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   373: astore 4
    //   375: aload 4
    //   377: ifnull +298 -> 675
    //   380: aload_0
    //   381: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   384: astore 5
    //   386: aload 4
    //   388: ldc_w 506
    //   391: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   394: ifne +1124 -> 1518
    //   397: iconst_0
    //   398: istore_3
    //   399: aload 5
    //   401: iload_3
    //   402: putfield 509	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:isOpen	Z
    //   405: aload_0
    //   406: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   409: aload 4
    //   411: ldc_w 511
    //   414: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   417: putfield 513	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:aid	I
    //   420: aload_0
    //   421: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   424: aload 4
    //   426: ldc_w 515
    //   429: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   432: putfield 517	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:title	Ljava/lang/String;
    //   435: aload_0
    //   436: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   439: aload 4
    //   441: ldc_w 519
    //   444: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   447: putfield 522	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:logoLink	Ljava/lang/String;
    //   450: aload_0
    //   451: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   454: aload 4
    //   456: ldc_w 524
    //   459: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   462: putfield 527	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:bannerLink	Ljava/lang/String;
    //   465: aload_0
    //   466: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   469: aload 4
    //   471: ldc_w 529
    //   474: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   477: putfield 532	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:detailsLink	Ljava/lang/String;
    //   480: aload_0
    //   481: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   484: aload 4
    //   486: ldc_w 534
    //   489: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   492: putfield 536	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:showType	I
    //   495: aload_0
    //   496: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   499: aload 4
    //   501: ldc_w 538
    //   504: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   507: putfield 541	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:showTime	I
    //   510: aload 4
    //   512: ldc_w 543
    //   515: invokevirtual 428	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   518: astore 5
    //   520: aload 5
    //   522: ifnull +33 -> 555
    //   525: aload_0
    //   526: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   529: aload 5
    //   531: ldc_w 474
    //   534: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   537: putfield 546	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:showVoiceText	Ljava/lang/String;
    //   540: aload_0
    //   541: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   544: aload 5
    //   546: ldc_w 479
    //   549: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   552: putfield 549	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:showVoiceLink	Ljava/lang/String;
    //   555: aload_0
    //   556: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   559: aload 4
    //   561: ldc_w 551
    //   564: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   567: putfield 553	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:session	Ljava/lang/String;
    //   570: aload_0
    //   571: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   574: aload 4
    //   576: ldc_w 555
    //   579: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   582: putfield 557	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:ruid	Ljava/lang/String;
    //   585: aload_0
    //   586: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   589: aload 4
    //   591: ldc_w 559
    //   594: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   597: putfield 561	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:rtitle	Ljava/lang/String;
    //   600: aload_0
    //   601: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   604: aload 4
    //   606: ldc_w 563
    //   609: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   612: putfield 566	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:riconLink	Ljava/lang/String;
    //   615: aload_0
    //   616: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   619: aload 4
    //   621: ldc_w 568
    //   624: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   627: putfield 570	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:rtips	Ljava/lang/String;
    //   630: aload_0
    //   631: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   634: aload 4
    //   636: ldc_w 572
    //   639: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   642: putfield 575	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:rtime	I
    //   645: aload_0
    //   646: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   649: aload 4
    //   651: ldc_w 577
    //   654: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   657: putfield 579	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:anum	I
    //   660: aload_0
    //   661: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   664: aload 4
    //   666: ldc_w 581
    //   669: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   672: putfield 583	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:rnum	I
    //   675: aload_1
    //   676: ldc_w 585
    //   679: invokevirtual 428	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   682: astore 4
    //   684: aload_0
    //   685: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   688: aload 4
    //   690: ldc_w 587
    //   693: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   696: putfield 590	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:naviendID	I
    //   699: aload_0
    //   700: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   703: astore 5
    //   705: aload 4
    //   707: ldc_w 506
    //   710: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   713: ifne +810 -> 1523
    //   716: iconst_0
    //   717: istore_3
    //   718: aload 5
    //   720: iload_3
    //   721: putfield 593	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:naviendOpen	Z
    //   724: aload_0
    //   725: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   728: aload 4
    //   730: ldc_w 595
    //   733: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   736: putfield 598	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:naviendNeedUpload	I
    //   739: aload_0
    //   740: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   743: aload 4
    //   745: ldc_w 600
    //   748: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   751: putfield 603	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:naviendPicLink	Ljava/lang/String;
    //   754: aload_0
    //   755: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   758: aload 4
    //   760: ldc_w 605
    //   763: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   766: putfield 608	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:naviendTips	Ljava/lang/String;
    //   769: aload_0
    //   770: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   773: aload 4
    //   775: ldc_w 610
    //   778: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   781: putfield 613	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:naviendClickTips	Ljava/lang/String;
    //   784: aload_0
    //   785: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   788: aload 4
    //   790: ldc_w 615
    //   793: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   796: putfield 618	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:naviendClickTipsColor	Ljava/lang/String;
    //   799: aload_0
    //   800: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   803: aload 4
    //   805: ldc_w 437
    //   808: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   811: putfield 621	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:naviendLink	Ljava/lang/String;
    //   814: aload_1
    //   815: ldc_w 623
    //   818: invokevirtual 428	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   821: astore 4
    //   823: aload_0
    //   824: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   827: aload 4
    //   829: ldc_w 587
    //   832: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   835: putfield 626	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:envelopeId	I
    //   838: aload 4
    //   840: ldc_w 628
    //   843: invokevirtual 428	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   846: astore 5
    //   848: aload 5
    //   850: ifnull +78 -> 928
    //   853: aload_0
    //   854: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   857: aload 5
    //   859: ldc_w 630
    //   862: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   865: putfield 633	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:envelopePicBtnNormal	Ljava/lang/String;
    //   868: aload_0
    //   869: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   872: aload 5
    //   874: ldc_w 635
    //   877: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   880: putfield 638	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:envelopePicBtnClicked	Ljava/lang/String;
    //   883: aload_0
    //   884: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   887: aload 5
    //   889: ldc_w 640
    //   892: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   895: putfield 643	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:envelopePicMid	Ljava/lang/String;
    //   898: aload_0
    //   899: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   902: aload 5
    //   904: ldc_w 645
    //   907: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   910: putfield 648	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:envelopePicWindowBG	Ljava/lang/String;
    //   913: aload_0
    //   914: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   917: aload 5
    //   919: ldc_w 650
    //   922: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   925: putfield 653	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:envelopePicPlus	Ljava/lang/String;
    //   928: aload 4
    //   930: ldc_w 655
    //   933: invokevirtual 428	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   936: astore 5
    //   938: aload 5
    //   940: ifnull +33 -> 973
    //   943: aload_0
    //   944: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   947: aload 5
    //   949: ldc_w 657
    //   952: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   955: putfield 660	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:envelopeWindowBtnColor	Ljava/lang/String;
    //   958: aload_0
    //   959: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   962: aload 5
    //   964: ldc_w 662
    //   967: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   970: putfield 665	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:envelopeWindowBtnTextColor	Ljava/lang/String;
    //   973: aload_0
    //   974: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   977: aload 4
    //   979: ldc_w 667
    //   982: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   985: putfield 670	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:envelopeShowTimes	I
    //   988: aload_0
    //   989: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   992: aload 4
    //   994: ldc_w 672
    //   997: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1000: putfield 675	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:envelopeSoundEffectLink	Ljava/lang/String;
    //   1003: aload_0
    //   1004: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1007: aload 4
    //   1009: ldc_w 677
    //   1012: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1015: putfield 680	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:envelopeDist	I
    //   1018: aload_0
    //   1019: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1022: aload 4
    //   1024: ldc_w 682
    //   1027: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1030: putfield 685	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:envelopeAnim	I
    //   1033: aload_0
    //   1034: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1037: aload 4
    //   1039: ldc_w 687
    //   1042: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1045: putfield 690	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:envelopeSNum	I
    //   1048: aload_0
    //   1049: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1052: aload 4
    //   1054: ldc_w 692
    //   1057: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1060: putfield 695	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:envelopeUnit	Ljava/lang/String;
    //   1063: aload_1
    //   1064: ldc_w 697
    //   1067: invokevirtual 428	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1070: astore 4
    //   1072: aload 4
    //   1074: ifnull +93 -> 1167
    //   1077: aload_0
    //   1078: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1081: aload 4
    //   1083: ldc_w 699
    //   1086: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1089: putfield 702	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:userPerCarLogoLink	Ljava/lang/String;
    //   1092: aload_0
    //   1093: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1096: aload 4
    //   1098: ldc_w 704
    //   1101: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1104: putfield 707	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:userHistoryMileas	I
    //   1107: aload_0
    //   1108: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1111: aload 4
    //   1113: ldc_w 709
    //   1116: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1119: putfield 712	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:userDisTips	Ljava/lang/String;
    //   1122: aload_0
    //   1123: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1126: aload 4
    //   1128: ldc_w 714
    //   1131: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1134: putfield 717	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:userRightUpgradeTips	Ljava/lang/String;
    //   1137: aload_0
    //   1138: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1141: aload 4
    //   1143: ldc_w 719
    //   1146: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1149: putfield 722	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:uploadMileageInter	I
    //   1152: aload_0
    //   1153: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1156: aload 4
    //   1158: ldc_w 724
    //   1161: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1164: putfield 727	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:isShowUserRight	I
    //   1167: aload_1
    //   1168: ldc_w 729
    //   1171: invokevirtual 428	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1174: astore 4
    //   1176: aload 4
    //   1178: ifnull +63 -> 1241
    //   1181: aload_0
    //   1182: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1185: aload 4
    //   1187: ldc_w 587
    //   1190: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1193: putfield 732	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:operationActivityId	I
    //   1196: aload_0
    //   1197: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1200: aload 4
    //   1202: ldc_w 600
    //   1205: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1208: putfield 735	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:operationActivityLogoLink	Ljava/lang/String;
    //   1211: aload_0
    //   1212: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1215: aload 4
    //   1217: ldc_w 437
    //   1220: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1223: putfield 738	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:operationActivityLink	Ljava/lang/String;
    //   1226: aload_0
    //   1227: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1230: aload 4
    //   1232: ldc_w 740
    //   1235: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1238: putfield 743	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:operationActivityTime	I
    //   1241: aload_1
    //   1242: ldc_w 745
    //   1245: invokevirtual 428	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1248: astore 4
    //   1250: aload 4
    //   1252: ifnull +48 -> 1300
    //   1255: aload 4
    //   1257: ldc_w 747
    //   1260: invokevirtual 428	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1263: astore 4
    //   1265: aload 4
    //   1267: ifnull +33 -> 1300
    //   1270: aload_0
    //   1271: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1274: aload 4
    //   1276: ldc_w 749
    //   1279: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1282: putfield 752	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:mCastrolFastRouteIconURL	Ljava/lang/String;
    //   1285: aload_0
    //   1286: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1289: aload 4
    //   1291: ldc_w 754
    //   1294: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1297: putfield 757	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:mCastrolFastRouteText	Ljava/lang/String;
    //   1300: aload_1
    //   1301: ldc_w 745
    //   1304: invokevirtual 428	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1307: astore_1
    //   1308: aload_1
    //   1309: ifnull -944 -> 365
    //   1312: aload_1
    //   1313: ldc_w 759
    //   1316: invokevirtual 428	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   1319: astore_1
    //   1320: aload_1
    //   1321: ifnull -956 -> 365
    //   1324: aload_0
    //   1325: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1328: astore 4
    //   1330: aload_1
    //   1331: ldc_w 506
    //   1334: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1337: iconst_1
    //   1338: if_icmpne +145 -> 1483
    //   1341: iconst_1
    //   1342: istore_3
    //   1343: aload 4
    //   1345: iload_3
    //   1346: putfield 762	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:mIsShowVoiceNotificaiton	Z
    //   1349: aload_0
    //   1350: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1353: aload_1
    //   1354: ldc_w 764
    //   1357: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1360: putfield 767	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:mVoiceDetailURL	Ljava/lang/String;
    //   1363: aload_0
    //   1364: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1367: aload_1
    //   1368: ldc_w 749
    //   1371: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1374: putfield 770	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:mVoiceIconURL	Ljava/lang/String;
    //   1377: aload_0
    //   1378: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1381: aload_1
    //   1382: ldc_w 432
    //   1385: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1388: putfield 773	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:mVoiceMainTitle	Ljava/lang/String;
    //   1391: aload_0
    //   1392: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1395: aload_1
    //   1396: ldc_w 775
    //   1399: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1402: putfield 778	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:mVoiceSubTitle	Ljava/lang/String;
    //   1405: aload_0
    //   1406: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1409: aload_1
    //   1410: ldc_w 780
    //   1413: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1416: putfield 783	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:mVoiceTaskId	Ljava/lang/String;
    //   1419: aload_0
    //   1420: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1423: aload_1
    //   1424: ldc_w 785
    //   1427: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1430: putfield 788	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:mVoiceAutoHideTime	I
    //   1433: aload_0
    //   1434: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1437: aload_1
    //   1438: ldc_w 790
    //   1441: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   1444: putfield 793	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:mVoiceShowTime	I
    //   1447: goto -1082 -> 365
    //   1450: astore_1
    //   1451: aload_0
    //   1452: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1455: iconst_0
    //   1456: putfield 762	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:mIsShowVoiceNotificaiton	Z
    //   1459: goto -1094 -> 365
    //   1462: astore 4
    //   1464: aload_0
    //   1465: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1468: aconst_null
    //   1469: putfield 752	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:mCastrolFastRouteIconURL	Ljava/lang/String;
    //   1472: aload_0
    //   1473: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   1476: aconst_null
    //   1477: putfield 757	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:mCastrolFastRouteText	Ljava/lang/String;
    //   1480: goto -180 -> 1300
    //   1483: iconst_0
    //   1484: istore_3
    //   1485: goto -142 -> 1343
    //   1488: astore 4
    //   1490: goto -249 -> 1241
    //   1493: astore 4
    //   1495: goto -328 -> 1167
    //   1498: astore 4
    //   1500: goto -437 -> 1063
    //   1503: astore 4
    //   1505: goto -691 -> 814
    //   1508: astore 4
    //   1510: goto -835 -> 675
    //   1513: astore 4
    //   1515: goto -1373 -> 142
    //   1518: iconst_1
    //   1519: istore_3
    //   1520: goto -1121 -> 399
    //   1523: iconst_1
    //   1524: istore_3
    //   1525: goto -807 -> 718
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1528	0	this	BusinessActivityManager
    //   0	1528	1	paramJSONObject	JSONObject
    //   185	98	2	i	int
    //   398	1127	3	bool	boolean
    //   110	1234	4	localObject1	Object
    //   1462	1	4	localException1	Exception
    //   1488	1	4	localException2	Exception
    //   1493	1	4	localException3	Exception
    //   1498	1	4	localException4	Exception
    //   1503	1	4	localException5	Exception
    //   1508	1	4	localException6	Exception
    //   1513	1	4	localException7	Exception
    //   201	762	5	localObject2	Object
    //   216	86	6	str	String
    // Exception table:
    //   from	to	target	type
    //   53	99	360	java/lang/Exception
    //   142	179	360	java/lang/Exception
    //   186	203	360	java/lang/Exception
    //   208	218	360	java/lang/Exception
    //   223	279	360	java/lang/Exception
    //   301	357	360	java/lang/Exception
    //   1451	1459	360	java/lang/Exception
    //   1464	1480	360	java/lang/Exception
    //   1300	1308	1450	java/lang/Exception
    //   1312	1320	1450	java/lang/Exception
    //   1324	1341	1450	java/lang/Exception
    //   1343	1447	1450	java/lang/Exception
    //   1241	1250	1462	java/lang/Exception
    //   1255	1265	1462	java/lang/Exception
    //   1270	1300	1462	java/lang/Exception
    //   1167	1176	1488	java/lang/Exception
    //   1181	1241	1488	java/lang/Exception
    //   1063	1072	1493	java/lang/Exception
    //   1077	1167	1493	java/lang/Exception
    //   814	848	1498	java/lang/Exception
    //   853	928	1498	java/lang/Exception
    //   928	938	1498	java/lang/Exception
    //   943	973	1498	java/lang/Exception
    //   973	1063	1498	java/lang/Exception
    //   675	716	1503	java/lang/Exception
    //   718	814	1503	java/lang/Exception
    //   367	375	1508	java/lang/Exception
    //   380	397	1508	java/lang/Exception
    //   399	520	1508	java/lang/Exception
    //   525	555	1508	java/lang/Exception
    //   555	675	1508	java/lang/Exception
    //   103	142	1513	java/lang/Exception
  }
  
  private boolean parseShareJSON(JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (this.mBusinessActivityModel == null)) {
      return false;
    }
    try
    {
      this.mBusinessActivityModel.shareRespErrNo = paramJSONObject.getInt("errno");
      this.mBusinessActivityModel.shareRespMsg = paramJSONObject.getString("errmsg");
      paramJSONObject = paramJSONObject.getJSONObject("data");
      if (paramJSONObject != null)
      {
        this.mBusinessActivityModel.shareTitle = paramJSONObject.getString("title");
        this.mBusinessActivityModel.sharePicLink = paramJSONObject.getString("pic");
        this.mBusinessActivityModel.shareContentLink = paramJSONObject.getString("link");
        this.mBusinessActivityModel.shareDesc = paramJSONObject.getString("desc");
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;) {}
    }
    return true;
  }
  
  /* Error */
  private boolean parseUploadJSON(JSONObject paramJSONObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_0
    //   5: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   8: ifnonnull +5 -> 13
    //   11: iconst_0
    //   12: ireturn
    //   13: getstatic 141	com/baidu/navisdk/module/BusinessActivityManager:TAG	Ljava/lang/String;
    //   16: new 148	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 149	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 815
    //   26: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: aload_1
    //   30: invokevirtual 408	org/json/JSONObject:toString	()Ljava/lang/String;
    //   33: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   39: invokestatic 298	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   42: aload_0
    //   43: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   46: aload_1
    //   47: ldc_w 411
    //   50: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   53: putfield 818	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:uploadRespErrNo	I
    //   56: aload_0
    //   57: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   60: aload_1
    //   61: ldc_w 416
    //   64: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   67: putfield 821	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:uploadRespMsg	Ljava/lang/String;
    //   70: aload_1
    //   71: ldc_w 424
    //   74: invokevirtual 428	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   77: astore_1
    //   78: aload_1
    //   79: ifnull +31 -> 110
    //   82: aload_0
    //   83: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   86: aload_1
    //   87: ldc_w 605
    //   90: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   93: putfield 824	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:uploadRespTips	Ljava/lang/String;
    //   96: aload_0
    //   97: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   100: aload_1
    //   101: ldc_w 610
    //   104: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   107: putfield 827	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:uploadRespClickTips	Ljava/lang/String;
    //   110: aload_1
    //   111: ifnull +53 -> 164
    //   114: aload_1
    //   115: ldc_w 829
    //   118: invokevirtual 832	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   121: ifeq +43 -> 164
    //   124: aload_1
    //   125: ldc_w 829
    //   128: invokevirtual 428	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   131: astore 6
    //   133: aload 6
    //   135: ifnull +29 -> 164
    //   138: aload 6
    //   140: ldc_w 834
    //   143: invokevirtual 832	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   146: ifeq +18 -> 164
    //   149: aload_0
    //   150: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   153: aload 6
    //   155: ldc_w 834
    //   158: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   161: putfield 837	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:yellowBanner	I
    //   164: aload_1
    //   165: ldc_w 839
    //   168: invokevirtual 428	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   171: astore_1
    //   172: aload_1
    //   173: ifnull +421 -> 594
    //   176: aload_1
    //   177: ldc_w 432
    //   180: invokevirtual 832	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   183: ifeq +17 -> 200
    //   186: aload_0
    //   187: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   190: aload_1
    //   191: ldc_w 432
    //   194: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   197: putfield 842	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:userRightTitleEnd	Ljava/lang/String;
    //   200: aload_1
    //   201: ldc_w 749
    //   204: invokevirtual 832	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   207: ifeq +17 -> 224
    //   210: aload_0
    //   211: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   214: aload_1
    //   215: ldc_w 749
    //   218: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   221: putfield 845	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:userRightIconLinkEnd	Ljava/lang/String;
    //   224: aload_1
    //   225: ldc_w 605
    //   228: invokevirtual 832	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   231: ifeq +17 -> 248
    //   234: aload_0
    //   235: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   238: aload_1
    //   239: ldc_w 605
    //   242: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   245: putfield 848	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:userRightTipsEnd	Ljava/lang/String;
    //   248: aload_1
    //   249: ldc_w 850
    //   252: invokevirtual 832	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   255: ifeq +17 -> 272
    //   258: aload_0
    //   259: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   262: aload_1
    //   263: ldc_w 850
    //   266: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   269: putfield 853	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:userRightEnterTips	Ljava/lang/String;
    //   272: aload_1
    //   273: ldc_w 855
    //   276: invokevirtual 832	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   279: ifeq +17 -> 296
    //   282: aload_0
    //   283: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   286: aload_1
    //   287: ldc_w 855
    //   290: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   293: putfield 858	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:userRightEnterLink	Ljava/lang/String;
    //   296: aload_1
    //   297: ldc_w 860
    //   300: invokevirtual 832	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   303: ifeq +17 -> 320
    //   306: aload_0
    //   307: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   310: aload_1
    //   311: ldc_w 860
    //   314: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   317: putfield 863	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:userRightUpgradeFrom	I
    //   320: aload_1
    //   321: ldc_w 865
    //   324: invokevirtual 832	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   327: ifeq +17 -> 344
    //   330: aload_0
    //   331: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   334: aload_1
    //   335: ldc_w 865
    //   338: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   341: putfield 868	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:userRightUpgradeTo	I
    //   344: aload_1
    //   345: ldc_w 870
    //   348: invokevirtual 832	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   351: ifeq +243 -> 594
    //   354: aload_1
    //   355: ldc_w 870
    //   358: invokevirtual 454	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   361: astore_1
    //   362: aload_1
    //   363: ifnull +231 -> 594
    //   366: aload_1
    //   367: invokevirtual 459	org/json/JSONArray:length	()I
    //   370: istore 4
    //   372: iconst_0
    //   373: istore_2
    //   374: iload_2
    //   375: iload 4
    //   377: if_icmpge +217 -> 594
    //   380: aload_1
    //   381: iload_2
    //   382: invokevirtual 462	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   385: astore 7
    //   387: new 872	com/baidu/navisdk/model/modelfactory/BusinessActivityModel$NaviEndPrivilege
    //   390: dup
    //   391: invokespecial 873	com/baidu/navisdk/model/modelfactory/BusinessActivityModel$NaviEndPrivilege:<init>	()V
    //   394: astore 6
    //   396: aload 6
    //   398: aload 7
    //   400: ldc_w 875
    //   403: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   406: putfield 878	com/baidu/navisdk/model/modelfactory/BusinessActivityModel$NaviEndPrivilege:cardType	Ljava/lang/String;
    //   409: aload 6
    //   411: aload 7
    //   413: ldc_w 880
    //   416: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   419: putfield 882	com/baidu/navisdk/model/modelfactory/BusinessActivityModel$NaviEndPrivilege:hint	Ljava/lang/String;
    //   422: aload 6
    //   424: aload 7
    //   426: ldc_w 884
    //   429: invokevirtual 412	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   432: putfield 886	com/baidu/navisdk/model/modelfactory/BusinessActivityModel$NaviEndPrivilege:unlock	I
    //   435: aload 6
    //   437: aload 7
    //   439: ldc_w 888
    //   442: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   445: putfield 890	com/baidu/navisdk/model/modelfactory/BusinessActivityModel$NaviEndPrivilege:tip	Ljava/lang/String;
    //   448: aload 7
    //   450: ldc_w 855
    //   453: invokevirtual 832	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   456: ifeq +16 -> 472
    //   459: aload 6
    //   461: aload 7
    //   463: ldc_w 855
    //   466: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   469: putfield 892	com/baidu/navisdk/model/modelfactory/BusinessActivityModel$NaviEndPrivilege:hlink	Ljava/lang/String;
    //   472: aload 7
    //   474: ldc_w 894
    //   477: invokevirtual 832	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   480: ifeq +16 -> 496
    //   483: aload 6
    //   485: aload 7
    //   487: ldc_w 894
    //   490: invokevirtual 420	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   493: putfield 896	com/baidu/navisdk/model/modelfactory/BusinessActivityModel$NaviEndPrivilege:hicon	Ljava/lang/String;
    //   496: aload 7
    //   498: ldc_w 898
    //   501: invokevirtual 832	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   504: ifeq +92 -> 596
    //   507: aload 7
    //   509: ldc_w 898
    //   512: invokevirtual 454	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   515: astore 7
    //   517: aload 7
    //   519: ifnull +77 -> 596
    //   522: aload 7
    //   524: invokevirtual 459	org/json/JSONArray:length	()I
    //   527: istore 5
    //   529: aload 6
    //   531: iload 5
    //   533: anewarray 468	java/lang/String
    //   536: putfield 901	com/baidu/navisdk/model/modelfactory/BusinessActivityModel$NaviEndPrivilege:list	[Ljava/lang/String;
    //   539: iconst_0
    //   540: istore_3
    //   541: iload_3
    //   542: iload 5
    //   544: if_icmpge +52 -> 596
    //   547: aload 6
    //   549: getfield 901	com/baidu/navisdk/model/modelfactory/BusinessActivityModel$NaviEndPrivilege:list	[Ljava/lang/String;
    //   552: iload_3
    //   553: aload 7
    //   555: iload_3
    //   556: invokevirtual 904	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   559: aastore
    //   560: iload_3
    //   561: iconst_1
    //   562: iadd
    //   563: istore_3
    //   564: goto -23 -> 541
    //   567: astore 6
    //   569: getstatic 352	com/baidu/navisdk/util/common/LogUtil:LOGGABLE	Z
    //   572: ifeq -462 -> 110
    //   575: aload 6
    //   577: invokevirtual 504	java/lang/Exception:printStackTrace	()V
    //   580: goto -470 -> 110
    //   583: astore_1
    //   584: getstatic 352	com/baidu/navisdk/util/common/LogUtil:LOGGABLE	Z
    //   587: ifeq +7 -> 594
    //   590: aload_1
    //   591: invokevirtual 504	java/lang/Exception:printStackTrace	()V
    //   594: iconst_1
    //   595: ireturn
    //   596: aload_0
    //   597: getfield 194	com/baidu/navisdk/module/BusinessActivityManager:mBusinessActivityModel	Lcom/baidu/navisdk/model/modelfactory/BusinessActivityModel;
    //   600: getfield 908	com/baidu/navisdk/model/modelfactory/BusinessActivityModel:naviEndPrivilegesList	Ljava/util/ArrayList;
    //   603: aload 6
    //   605: invokevirtual 913	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   608: pop
    //   609: iload_2
    //   610: iconst_1
    //   611: iadd
    //   612: istore_2
    //   613: goto -239 -> 374
    //   616: astore_1
    //   617: getstatic 352	com/baidu/navisdk/util/common/LogUtil:LOGGABLE	Z
    //   620: ifeq -26 -> 594
    //   623: aload_1
    //   624: invokevirtual 504	java/lang/Exception:printStackTrace	()V
    //   627: goto -33 -> 594
    //   630: astore 6
    //   632: goto -23 -> 609
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	635	0	this	BusinessActivityManager
    //   0	635	1	paramJSONObject	JSONObject
    //   373	240	2	i	int
    //   540	24	3	j	int
    //   370	8	4	k	int
    //   527	18	5	m	int
    //   131	417	6	localObject1	Object
    //   567	37	6	localException1	Exception
    //   630	1	6	localException2	Exception
    //   385	169	7	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   82	110	567	java/lang/Exception
    //   13	78	583	java/lang/Exception
    //   569	580	583	java/lang/Exception
    //   617	627	583	java/lang/Exception
    //   114	133	616	java/lang/Exception
    //   138	164	616	java/lang/Exception
    //   164	172	616	java/lang/Exception
    //   176	200	616	java/lang/Exception
    //   200	224	616	java/lang/Exception
    //   224	248	616	java/lang/Exception
    //   248	272	616	java/lang/Exception
    //   272	296	616	java/lang/Exception
    //   296	320	616	java/lang/Exception
    //   320	344	616	java/lang/Exception
    //   344	362	616	java/lang/Exception
    //   366	372	616	java/lang/Exception
    //   380	396	616	java/lang/Exception
    //   396	472	630	java/lang/Exception
    //   472	496	630	java/lang/Exception
    //   496	517	630	java/lang/Exception
    //   522	539	630	java/lang/Exception
    //   547	560	630	java/lang/Exception
    //   596	609	630	java/lang/Exception
  }
  
  private boolean parseUploadJSONForNaving(JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (this.mBusinessActivityModel == null)) {
      return false;
    }
    try
    {
      LogUtil.e(TAG, "parseUploadJSONForNaving() json --> " + paramJSONObject.toString());
      this.mBusinessActivityModel.uploadRespErrNoForNaving = paramJSONObject.getInt("errno");
      this.mBusinessActivityModel.uploadRespMsgForNaving = paramJSONObject.getString("errmsg");
      return true;
    }
    catch (Exception paramJSONObject)
    {
      for (;;) {}
    }
  }
  
  private void requestAll()
  {
    requestAudio(1514);
    if ((this.mHD == null) || (this.mHD != null)) {}
  }
  
  private void saveFile(byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    if ((paramArrayOfByte == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return;
    }
    File localFile = new File(paramString1);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    paramString1 = new File(paramString1 + paramString2);
    paramString1.deleteOnExit();
    try
    {
      paramString1.createNewFile();
      paramString1 = new FileOutputStream(paramString1);
      paramString1.write(paramArrayOfByte);
      paramString1.flush();
      paramString1.close();
      return;
    }
    catch (Exception paramArrayOfByte) {}
  }
  
  private void shareSafety(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (this.isCancelShareSafe)
    {
      LogUtil.e(TAG, "safety shareSafety  --> isCancelShareSafe: " + this.isCancelShareSafe);
      return;
    }
    getInstance().isShareSuc = true;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("OrientationUser", this.isOrientationUser);
    localBundle.putString("LinkUrl", paramString1);
    localBundle.putString("ImgUrl", paramString2);
    localBundle.putString("Title", paramString3);
    localBundle.putString("Desc", paramString4);
    BNaviModuleManager.shareSafety(localBundle);
    RGSimpleGuideModel.mIsSafetyShareGuideShow = true;
    if (RGMapModeViewController.getInstance().getSafetyViewContails() != null) {
      RGMapModeViewController.getInstance().getSafetyViewContails().setVisibility(0);
    }
    BNLightNaviManager.getInstance().showSafetyGuide(true);
  }
  
  public boolean checkTrafficJam(int paramInt1, int paramInt2)
  {
    if (!this.mBusinessActivityModel.isTrafficJamEnabled())
    {
      LogUtil.e(TAG, "checkTrafficJam() check failed for disable");
      return false;
    }
    if ((paramInt1 >= 20) || (paramInt2 < 200))
    {
      this.mBusinessActivityModel.resetTrafficJam();
      LogUtil.e(TAG, "checkTrafficJam() check failed for speed=" + paramInt1 + ", naviDis=" + paramInt2);
      return false;
    }
    Object localObject = RGSimpleGuideModel.getInstance().getTotalInfo();
    if ((localObject == null) || (!((Bundle)localObject).containsKey("totaldist")))
    {
      this.mBusinessActivityModel.resetTrafficJam();
      LogUtil.e(TAG, "checkTrafficJam() check failed for total guide info not exists");
      return false;
    }
    int k = ((Bundle)localObject).getInt("totaldist");
    if (k <= 0)
    {
      this.mBusinessActivityModel.resetTrafficJam();
      LogUtil.e(TAG, "checkTrafficJam() check failed for remainTotalDist=" + k);
      return false;
    }
    localObject = RGAssistGuideModel.getInstance().getRoadConditionData();
    if (localObject == null)
    {
      LogUtil.e(TAG, "checkTrafficJam() check failed for road condition is null");
      return false;
    }
    int m = (int)(RGAssistGuideModel.getInstance().getCarProgress() * ((RoadConditionItem)((List)localObject).get(((List)localObject).size() - 1)).curItemEndIndex);
    int j = -1;
    paramInt2 = 0;
    int i;
    for (;;)
    {
      i = j;
      if (paramInt2 < ((List)localObject).size())
      {
        if (m < ((RoadConditionItem)((List)localObject).get(paramInt2)).curItemEndIndex) {
          i = paramInt2;
        }
      }
      else
      {
        if (m >= 0) {
          break;
        }
        LogUtil.e(TAG, "checkTrafficJam() check failed for road condition item index < 0.");
        return false;
      }
      paramInt2 += 1;
    }
    if (this.mBusinessActivityModel.lastRoadConditionItemIndex == i)
    {
      LogUtil.e(TAG, "checkTrafficJam() check failed for road condition item index is same. itemIndex=" + i);
      return false;
    }
    if (RGAssistGuideModel.getInstance().getCarProgress() <= 0.0D) {}
    for (paramInt2 = k;; paramInt2 = (int)(k / (1.0D - RGAssistGuideModel.getInstance().getCarProgress())))
    {
      m = getObstructionIndexCount((List)localObject, i);
      j = m;
      if (m > 0) {
        j = m + getObstructionIndexCount((List)localObject, i + 1);
      }
      if (j != 0) {
        break;
      }
      LogUtil.e(TAG, "checkTrafficJam() check failed for rcIndexCount=0");
      return false;
    }
    m = (int)(paramInt2 * j / ((RoadConditionItem)((List)localObject).get(((List)localObject).size() - 1)).curItemEndIndex);
    LogUtil.e(TAG, "checkTrafficJam() remainDist=" + k + ", totalDist=" + paramInt2 + ", itemIndex=" + i + ", rcIndexCount=" + j + ", obsDist=" + m);
    if (m >= 10)
    {
      this.mBusinessActivityModel.isTrafficJam = true;
      this.mBusinessActivityModel.lastRoadConditionItemIndex = i;
      LogUtil.e(TAG, "checkTrafficJam() check ok  speed=" + paramInt1);
      if (LogUtil.LOGGABLE) {
        TipTool.onCreateToastDialog(BNavigator.getInstance().getActivity(), "拥堵触发商业水滴显示, obsDist=" + m);
      }
      return true;
    }
    LogUtil.e(TAG, "checkTrafficJam() check failed for obsDist=" + m);
    this.mBusinessActivityModel.resetTrafficJam();
    return false;
  }
  
  public CookieStore getCookieStore()
  {
    if (BNaviModuleManager.getBduss() == null) {
      return null;
    }
    BasicClientCookie localBasicClientCookie = new BasicClientCookie("BDUSS", BNaviModuleManager.getBduss());
    BasicCookieStore localBasicCookieStore = new BasicCookieStore();
    localBasicClientCookie.setDomain(".baidu.com");
    localBasicClientCookie.setPath("/");
    localBasicClientCookie.setVersion(0);
    localBasicCookieStore.addCookie(localBasicClientCookie);
    return localBasicCookieStore;
  }
  
  public BusinessActivityModel getModel()
  {
    if (this.mBusinessActivityModel == null) {
      this.mBusinessActivityModel = new BusinessActivityModel();
    }
    return this.mBusinessActivityModel;
  }
  
  public void getShareData(Handler paramHandler, int paramInt)
  {
    if (this.mBusinessActivityModel == null) {
      return;
    }
    this.mOutShareHandler = paramHandler;
    this.mOutShareMsgWhat = paramInt;
    Object localObject;
    if ((!this.mBusinessActivityModel.isUploadDataContainsValidBduss()) && (!TextUtils.isEmpty(BNaviModuleManager.getBduss())))
    {
      paramHandler = BNaviModuleManager.getBduss();
      localObject = new Bundle();
      JNITrajectoryControl.sInstance.getPostParamsForBdussUpdated((Bundle)localObject, paramHandler);
      LogUtil.e(TAG, "reload upload Data. uploadData=" + ((Bundle)localObject).toString());
      this.mBusinessActivityModel.uploadBundleData = ((Bundle)localObject);
    }
    if (this.mBusinessActivityModel.uploadBundleData == null)
    {
      paramHandler = new Bundle();
      JNITrajectoryControl.sInstance.getPostParams(this.mBusinessActivityModel.atype, paramHandler);
      this.mBusinessActivityModel.uploadBundleData = paramHandler;
    }
    BNHttpParams localBNHttpParams = new BNHttpParams();
    localBNHttpParams.isAsync = true;
    paramHandler = JNITrajectoryControl.sInstance.getCurrentUUID();
    paramHandler = JNITrajectoryControl.sInstance.getTrajecotryFilePath(paramHandler);
    if (paramHandler != null)
    {
      localBNHttpParams.fileKey = "datafile";
      localBNHttpParams.file = new File(paramHandler);
    }
    HashMap localHashMap = new HashMap();
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      try
      {
        if (this.mBusinessActivityModel.uploadBundleData.containsKey("pcBduss"))
        {
          paramHandler = this.mBusinessActivityModel.uploadBundleData.getString("pcBduss");
          localHashMap.put("bduss", paramHandler);
          localStringBuffer.append("bduss=" + URLEncoder.encode(paramHandler, "utf-8"));
          if (!this.mBusinessActivityModel.uploadBundleData.containsKey("pcCuid")) {
            break label746;
          }
          paramHandler = this.mBusinessActivityModel.uploadBundleData.getString("pcCuid");
          localHashMap.put("cuid", paramHandler);
          localStringBuffer.append("&cuid=" + URLEncoder.encode(paramHandler, "utf-8"));
          if (!this.mBusinessActivityModel.uploadBundleData.containsKey("pcGuid")) {
            break label753;
          }
          paramHandler = this.mBusinessActivityModel.uploadBundleData.getString("pcGuid");
          localHashMap.put("guid", paramHandler);
          localStringBuffer.append("&guid=" + URLEncoder.encode(paramHandler, "utf-8"));
          if (this.mBusinessActivityModel.uploadBundleData.containsKey("pcNaviActInfo"))
          {
            paramHandler = this.mBusinessActivityModel.uploadBundleData.getString("pcNaviActInfo");
            localHashMap.put("navi_info", paramHandler);
            localStringBuffer.append("&navi_info=" + URLEncoder.encode(paramHandler, "utf-8"));
            localHashMap.put("st", "" + this.mBusinessActivityModel.timestamp);
            localStringBuffer.append("&st=" + URLEncoder.encode(new StringBuilder().append("").append(this.mBusinessActivityModel.timestamp).toString(), "utf-8"));
            localHashMap.put("sv", PackageUtil.getVersionName());
            localStringBuffer.append("&sv=" + URLEncoder.encode(PackageUtil.getVersionName(), "utf-8"));
            localObject = JNITrajectoryControl.sInstance.getUrlParamsSign(localStringBuffer.toString());
            paramHandler = (Handler)localObject;
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              paramHandler = "";
            }
            localHashMap.put("sign", paramHandler);
            localStringBuffer.append("&sign=" + URLEncoder.encode(paramHandler, "utf-8"));
            BNHttpCenter.getInstance().post(HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_NAV_END_SHARE), localHashMap, new BNHttpTextResponseHandler()
            {
              public void onFailure(int paramAnonymousInt, String paramAnonymousString, Throwable paramAnonymousThrowable)
              {
                if (BusinessActivityManager.this.mOutShareHandler != null) {
                  BusinessActivityManager.this.mOutShareHandler.obtainMessage(BusinessActivityManager.this.mOutShareMsgWhat).sendToTarget();
                }
              }
              
              public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
              {
                try
                {
                  BusinessActivityManager.this.parseShareJSON(new JSONObject(paramAnonymousString));
                  if (BusinessActivityManager.this.mOutShareHandler != null) {
                    BusinessActivityManager.this.mOutShareHandler.obtainMessage(BusinessActivityManager.this.mOutShareMsgWhat).sendToTarget();
                  }
                  return;
                }
                catch (JSONException paramAnonymousString)
                {
                  for (;;) {}
                }
              }
            }, localBNHttpParams);
            return;
          }
          paramHandler = "";
          continue;
        }
        paramHandler = "";
      }
      catch (Exception paramHandler)
      {
        return;
      }
      continue;
      label746:
      paramHandler = "";
      continue;
      label753:
      paramHandler = "";
    }
  }
  
  public boolean isNeedUploadData()
  {
    boolean bool = false;
    if (Build.VERSION.SDK_INT >= 23) {
      if (!BNSysLocationManager.getInstance().isMock()) {
        bool = true;
      }
    }
    while (getModel() == null) {
      return bool;
    }
    return getModel().isNeedUploadDataFromLocal;
  }
  
  public void onYawing()
  {
    if (this.mBusinessActivityModel == null) {
      return;
    }
    getInstance().getModel().resetTrafficJam();
    getInstance().getModel().resetParking();
    getInstance().getModel().lastRoadConditionItemIndex = -1;
    BusinessActivityViewManager.getInstance().hideViews();
  }
  
  public void releaseAllRes()
  {
    BusinessActivityPlayerManager.getInstance().cancelPlayAudioAndPlayMsg();
    if (this.mBusinessActivityModel != null) {
      this.mBusinessActivityModel.clear();
    }
    if (this.mHD != null)
    {
      if (this.mHD.hasMessages(1505)) {
        this.mHD.removeMessages(1505);
      }
      BNWorkerCenter.getInstance().cancelTask(this.mUploadMileaTask, false);
    }
    this.mOuterHandler = null;
    this.mOuterUploadHandler = null;
    this.mOuterUploadHandlerForNaving = null;
    this.mOutShareHandler = null;
    this.mLastMilea = 0L;
  }
  
  public void requestAudio(final int paramInt)
  {
    if (this.mBusinessActivityModel == null) {}
    do
    {
      return;
      switch (paramInt)
      {
      default: 
        return;
      case 1514: 
        if (TextUtils.isEmpty(this.mBusinessActivityModel.voiceLinkOnStartNavi))
        {
          requestBitmap(1510);
          BusinessActivityPlayerManager.getInstance().playNaviStartContent();
          return;
        }
        this.mBusinessActivityModel.voicePathOnStartNavi = FileCache.getCacheFilePath(this.mBusinessActivityModel.voiceLinkOnStartNavi, "");
        if (!TextUtils.isEmpty(this.mBusinessActivityModel.voicePathOnStartNavi))
        {
          requestBitmap(1510);
          BusinessActivityPlayerManager.getInstance().playNaviStartContent();
          return;
        }
        break;
      case 1515: 
        if (TextUtils.isEmpty(this.mBusinessActivityModel.voiceLinkOnEndNavi))
        {
          requestBitmap(1530);
          return;
        }
        this.mBusinessActivityModel.voicePathOnEndNavi = FileCache.getCacheFilePath(this.mBusinessActivityModel.voiceLinkOnEndNavi, "");
        if (!TextUtils.isEmpty(this.mBusinessActivityModel.voicePathOnEndNavi))
        {
          requestBitmap(1530);
          return;
        }
        break;
      case 1516: 
        if (TextUtils.isEmpty(this.mBusinessActivityModel.showVoiceLink))
        {
          requestAudio(1515);
          return;
        }
        this.mBusinessActivityModel.showVoicePath = FileCache.getCacheFilePath(this.mBusinessActivityModel.showVoiceLink, "");
        if (!TextUtils.isEmpty(this.mBusinessActivityModel.showVoicePath))
        {
          requestAudio(1515);
          return;
        }
        break;
      case 1535: 
        if (TextUtils.isEmpty(this.mBusinessActivityModel.envelopeSoundEffectLink))
        {
          requestBitmap(1536);
          return;
        }
        this.mBusinessActivityModel.envelopeSoundEffectPath = FileCache.getCacheFilePath(this.mBusinessActivityModel.envelopeSoundEffectLink, "");
        if (!TextUtils.isEmpty(this.mBusinessActivityModel.envelopeSoundEffectPath))
        {
          requestBitmap(1536);
          return;
        }
        break;
      }
    } while (this.mBusinessActivityModel == null);
    ReqData localReqData = new ReqData("cmd.general.httprequest.func", 7, this.mHD, paramInt, 10000);
    CmdGeneralHttpRequestFunc.addFunc(localReqData, new CmdGeneralHttpRequestFunc.Callback()
    {
      public List<NameValuePair> getRequestParams()
      {
        return null;
      }
      
      public int getRequestType()
      {
        return 2;
      }
      
      public String getUrl()
      {
        if (BusinessActivityManager.this.mBusinessActivityModel != null) {}
        switch (paramInt)
        {
        default: 
          return null;
        case 1514: 
          return BusinessActivityManager.this.mBusinessActivityModel.voiceLinkOnStartNavi;
        case 1515: 
          return BusinessActivityManager.this.mBusinessActivityModel.voiceLinkOnEndNavi;
        case 1516: 
          return BusinessActivityManager.this.mBusinessActivityModel.showVoiceLink;
        }
        return BusinessActivityManager.this.mBusinessActivityModel.envelopeSoundEffectLink;
      }
      
      public boolean parseResponseJSON(JSONObject paramAnonymousJSONObject)
      {
        return true;
      }
      
      public void responseImage(byte[] paramAnonymousArrayOfByte)
      {
        if (paramAnonymousArrayOfByte != null) {
          LogUtil.e(BusinessActivityManager.TAG, "responseImage() audio. what=" + paramInt);
        }
        switch (paramInt)
        {
        default: 
          return;
        case 1514: 
          BusinessActivityManager.this.mBusinessActivityModel.voicePathOnStartNavi = FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.voiceLinkOnStartNavi, "", paramAnonymousArrayOfByte);
          return;
        case 1515: 
          BusinessActivityManager.this.mBusinessActivityModel.voicePathOnEndNavi = FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.voiceLinkOnEndNavi, "", paramAnonymousArrayOfByte);
          return;
        case 1516: 
          BusinessActivityManager.this.mBusinessActivityModel.showVoicePath = FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.showVoiceLink, "", paramAnonymousArrayOfByte);
          return;
        }
        BusinessActivityManager.this.mBusinessActivityModel.envelopeSoundEffectPath = FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.envelopeSoundEffectLink, "", paramAnonymousArrayOfByte);
      }
    });
    CommandCenter.getInstance().sendRequest(localReqData);
  }
  
  public void requestBitmap(final int paramInt)
  {
    if (this.mBusinessActivityModel == null) {}
    do
    {
      do
      {
        return;
        switch (paramInt)
        {
        default: 
          return;
        case 1510: 
          if (TextUtils.isEmpty(this.mBusinessActivityModel.logoLink))
          {
            requestBitmap(1511);
            return;
          }
          this.mBusinessActivityModel.logoBitmap = FileCache.loadBitmapCache(this.mBusinessActivityModel.logoLink, "");
          if (this.mBusinessActivityModel.logoBitmap == null) {
            break;
          }
          requestBitmap(1511);
          return;
        case 1511: 
          if (TextUtils.isEmpty(this.mBusinessActivityModel.bannerLink))
          {
            requestBitmap(1512);
            return;
          }
          this.mBusinessActivityModel.bannerBitmap = FileCache.loadBitmapCache(this.mBusinessActivityModel.bannerLink, "");
          if (this.mBusinessActivityModel.bannerBitmap == null) {
            break;
          }
          requestBitmap(1512);
          return;
        case 1512: 
          if (TextUtils.isEmpty(this.mBusinessActivityModel.riconLink))
          {
            requestBitmap(1513);
            return;
          }
          this.mBusinessActivityModel.riconBitmap = FileCache.loadBitmapCache(this.mBusinessActivityModel.riconLink, "");
          if (this.mBusinessActivityModel.riconBitmap == null) {
            break;
          }
          requestBitmap(1513);
          return;
        case 1513: 
          if (TextUtils.isEmpty(this.mBusinessActivityModel.naviendPicLink))
          {
            requestAudio(1516);
            return;
          }
          this.mBusinessActivityModel.naviendPicBitmap = FileCache.loadBitmapCache(this.mBusinessActivityModel.naviendPicLink, "");
          if (this.mBusinessActivityModel.naviendPicBitmap == null) {
            break;
          }
          requestAudio(1516);
          return;
        case 1530: 
          if (TextUtils.isEmpty(this.mBusinessActivityModel.envelopePicBtnNormal))
          {
            requestBitmap(1531);
            return;
          }
          this.mBusinessActivityModel.envelopePicBtnNormalBitmap = FileCache.loadBitmapCache(this.mBusinessActivityModel.envelopePicBtnNormal, "");
          if (this.mBusinessActivityModel.envelopePicBtnNormalBitmap == null) {
            break;
          }
          requestBitmap(1531);
          return;
        case 1531: 
          if (TextUtils.isEmpty(this.mBusinessActivityModel.envelopePicBtnClicked))
          {
            requestBitmap(1532);
            return;
          }
          this.mBusinessActivityModel.envelopePicBtnClickedBitmap = FileCache.loadBitmapCache(this.mBusinessActivityModel.envelopePicBtnClicked, "");
          if (this.mBusinessActivityModel.envelopePicBtnClickedBitmap == null) {
            break;
          }
          requestBitmap(1532);
          return;
        case 1532: 
          if (TextUtils.isEmpty(this.mBusinessActivityModel.envelopePicMid))
          {
            requestBitmap(1533);
            return;
          }
          this.mBusinessActivityModel.envelopePicMidBitmap = FileCache.loadBitmapCache(this.mBusinessActivityModel.envelopePicMid, "");
          if (this.mBusinessActivityModel.envelopePicMidBitmap == null) {
            break;
          }
          requestBitmap(1533);
          return;
        case 1533: 
          if (TextUtils.isEmpty(this.mBusinessActivityModel.envelopePicPlus))
          {
            requestBitmap(1534);
            return;
          }
          this.mBusinessActivityModel.envelopePicPlusBitmap = FileCache.loadBitmapCache(this.mBusinessActivityModel.envelopePicPlus, "");
          if (this.mBusinessActivityModel.envelopePicPlusBitmap == null) {
            break;
          }
          requestBitmap(1534);
          return;
        case 1534: 
          if (TextUtils.isEmpty(this.mBusinessActivityModel.envelopePicWindowBG))
          {
            requestAudio(1535);
            return;
          }
          this.mBusinessActivityModel.envelopePicWindowBGBitmap = FileCache.loadBitmapCache(this.mBusinessActivityModel.envelopePicWindowBG, "");
          if (this.mBusinessActivityModel.envelopePicWindowBGBitmap == null) {
            break;
          }
          requestAudio(1535);
          return;
        case 1536: 
          if (TextUtils.isEmpty(this.mBusinessActivityModel.userPerCarLogoLink))
          {
            BNRouteGuider.getInstance().clearCarImage();
            requestBitmap(1538);
            return;
          }
          this.mBusinessActivityModel.userPerCarLogoBitmap = FileCache.loadBitmapCache(this.mBusinessActivityModel.userPerCarLogoLink, "");
          if (this.mBusinessActivityModel.userPerCarLogoBitmap == null) {
            break;
          }
          requestBitmap(1538);
          if (this.mBusinessActivityModel.userPerCarLogoBitmap != null)
          {
            BNRouteGuider.getInstance().setCarImageToMap(FileCache.getCacheFilePath(this.mBusinessActivityModel.userPerCarLogoLink, ""));
            return;
          }
          BNRouteGuider.getInstance().clearCarImage();
          return;
        }
      } while (TextUtils.isEmpty(this.mBusinessActivityModel.operationActivityLogoLink));
      this.mBusinessActivityModel.operationActivityLogoBitmap = FileCache.loadBitmapCache(this.mBusinessActivityModel.operationActivityLogoLink, "");
    } while (this.mBusinessActivityModel.operationActivityLogoBitmap != null);
    do
    {
      if (this.mBusinessActivityModel == null) {
        break;
      }
      ReqData localReqData = new ReqData("cmd.general.httprequest.func", 7, this.mHD, paramInt, 10000);
      CmdGeneralHttpRequestFunc.addFunc(localReqData, new CmdGeneralHttpRequestFunc.Callback()
      {
        public List<NameValuePair> getRequestParams()
        {
          return null;
        }
        
        public int getRequestType()
        {
          return 2;
        }
        
        public String getUrl()
        {
          if (BusinessActivityManager.this.mBusinessActivityModel != null) {}
          switch (paramInt)
          {
          default: 
            return null;
          case 1510: 
            return BusinessActivityManager.this.mBusinessActivityModel.logoLink;
          case 1511: 
            return BusinessActivityManager.this.mBusinessActivityModel.bannerLink;
          case 1512: 
            return BusinessActivityManager.this.mBusinessActivityModel.riconLink;
          case 1513: 
            return BusinessActivityManager.this.mBusinessActivityModel.naviendPicLink;
          case 1530: 
            return BusinessActivityManager.this.mBusinessActivityModel.envelopePicBtnNormal;
          case 1531: 
            return BusinessActivityManager.this.mBusinessActivityModel.envelopePicBtnClicked;
          case 1532: 
            return BusinessActivityManager.this.mBusinessActivityModel.envelopePicMid;
          case 1533: 
            return BusinessActivityManager.this.mBusinessActivityModel.envelopePicPlus;
          case 1534: 
            return BusinessActivityManager.this.mBusinessActivityModel.envelopePicWindowBG;
          case 1536: 
            return BusinessActivityManager.this.mBusinessActivityModel.userPerCarLogoLink;
          case 1538: 
            return BusinessActivityManager.this.mBusinessActivityModel.operationActivityLogoLink;
          }
          return BusinessActivityManager.this.mBusinessActivityModel.userRightIconLinkEnd;
        }
        
        public boolean parseResponseJSON(JSONObject paramAnonymousJSONObject)
        {
          return true;
        }
        
        public void responseImage(byte[] paramAnonymousArrayOfByte)
        {
          if (paramAnonymousArrayOfByte != null) {
            LogUtil.e(BusinessActivityManager.TAG, "responseImage() what=" + paramInt);
          }
          switch (paramInt)
          {
          default: 
            return;
          case 1510: 
            BusinessActivityManager.this.mBusinessActivityModel.logoBitmap = BitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
            FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.logoLink, "", paramAnonymousArrayOfByte);
            return;
          case 1511: 
            BusinessActivityManager.this.mBusinessActivityModel.bannerBitmap = BitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
            FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.bannerLink, "", paramAnonymousArrayOfByte);
            return;
          case 1512: 
            BusinessActivityManager.this.mBusinessActivityModel.riconBitmap = BitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
            FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.riconLink, "", paramAnonymousArrayOfByte);
            return;
          case 1513: 
            BusinessActivityManager.this.mBusinessActivityModel.naviendPicBitmap = BitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
            FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.naviendPicLink, "", paramAnonymousArrayOfByte);
            return;
          case 1530: 
            BusinessActivityManager.this.mBusinessActivityModel.envelopePicBtnNormalBitmap = BitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
            FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.envelopePicBtnNormal, "", paramAnonymousArrayOfByte);
            return;
          case 1531: 
            BusinessActivityManager.this.mBusinessActivityModel.envelopePicBtnClickedBitmap = BitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
            FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.envelopePicBtnClicked, "", paramAnonymousArrayOfByte);
            return;
          case 1532: 
            BusinessActivityManager.this.mBusinessActivityModel.envelopePicMidBitmap = BitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
            FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.envelopePicMid, "", paramAnonymousArrayOfByte);
            return;
          case 1533: 
            BusinessActivityManager.this.mBusinessActivityModel.envelopePicPlusBitmap = BitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
            FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.envelopePicPlus, "", paramAnonymousArrayOfByte);
            return;
          case 1534: 
            BusinessActivityManager.this.mBusinessActivityModel.envelopePicWindowBGBitmap = BitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
            FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.envelopePicWindowBG, "", paramAnonymousArrayOfByte);
            return;
          case 1536: 
            BusinessActivityManager.this.mBusinessActivityModel.userPerCarLogoBitmap = BitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
            FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.userPerCarLogoLink, "", paramAnonymousArrayOfByte);
            return;
          case 1538: 
            BusinessActivityManager.this.mBusinessActivityModel.operationActivityLogoBitmap = BitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
            FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.operationActivityLogoLink, "", paramAnonymousArrayOfByte);
            return;
          }
          BusinessActivityManager.this.mBusinessActivityModel.userRightIconBitmapEnd = BitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
          FileCache.cacheFile(BusinessActivityManager.this.mBusinessActivityModel.userRightIconLinkEnd, "", paramAnonymousArrayOfByte);
        }
      });
      CommandCenter.getInstance().sendRequest(localReqData);
      return;
      if (TextUtils.isEmpty(this.mBusinessActivityModel.userRightIconLinkEnd)) {
        break;
      }
      this.mBusinessActivityModel.userRightIconBitmapEnd = FileCache.loadBitmapCache(this.mBusinessActivityModel.userRightIconLinkEnd, "");
    } while (this.mBusinessActivityModel.userRightIconBitmapEnd == null);
    BNNaviResultController.getInstance().notifyServerDataDownloadState(BNNaviResultController.DataDownloadType.IMG_DATA, BNNaviResultController.DataDownloadState.DOWNLOAD_FINISH);
  }
  
  public boolean requestNavigatorBusinessActivity(Context paramContext, Handler paramHandler, final int paramInt)
  {
    releaseAllRes();
    this.mOuterHandler = paramHandler;
    this.mOuterMsgWhat = paramInt;
    FileCache.clearCache(paramContext, false);
    if (this.mBusinessActivityModel == null) {
      this.mBusinessActivityModel = new BusinessActivityModel();
    }
    for (;;)
    {
      try
      {
        StringBuffer localStringBuffer = new StringBuffer();
        HashMap localHashMap = new HashMap();
        localHashMap.put("bduss", "");
        localStringBuffer.append("bduss=");
        localStringBuffer.append(URLEncoder.encode("", "utf-8"));
        int i = 0;
        if (GeoLocateModel.getInstance().getCurrentDistrict() != null) {
          i = GeoLocateModel.getInstance().getCurrentDistrict().mId;
        }
        localHashMap.put("cityCode", "" + i);
        localStringBuffer.append("&cityCode=");
        localStringBuffer.append(URLEncoder.encode("" + i, "utf-8"));
        localHashMap.put("cuid", PackageUtil.getCuid());
        localStringBuffer.append("&cuid=");
        localStringBuffer.append(URLEncoder.encode(PackageUtil.getCuid(), "utf-8"));
        localHashMap.put("mb", VDeviceAPI.getPhoneType());
        localStringBuffer.append("&mb=");
        localStringBuffer.append(URLEncoder.encode(VDeviceAPI.getPhoneType(), "utf-8"));
        localHashMap.put("os", "0");
        localStringBuffer.append("&os=");
        localStringBuffer.append(URLEncoder.encode("0", "utf-8"));
        localHashMap.put("osv", VDeviceAPI.getOsVersion());
        localStringBuffer.append("&osv=");
        localStringBuffer.append(URLEncoder.encode(VDeviceAPI.getOsVersion(), "utf-8"));
        localHashMap.put("qtv", "2");
        localStringBuffer.append("&qtv=");
        localStringBuffer.append(URLEncoder.encode("2", "utf-8"));
        localHashMap.put("sid", "1");
        localStringBuffer.append("&sid=");
        localStringBuffer.append(URLEncoder.encode("1", "utf-8"));
        localHashMap.put("sv", "10.1.0");
        localStringBuffer.append("&sv=");
        localStringBuffer.append(URLEncoder.encode("10.1.0", "utf-8"));
        paramHandler = VoiceHelper.getInstance().getCurrentUsedTTSId();
        paramContext = paramHandler;
        if (TextUtils.isEmpty(paramHandler)) {
          paramContext = "0";
        }
        localHashMap.put("tts_id", paramContext);
        localStringBuffer.append("&tts_id=");
        localStringBuffer.append(URLEncoder.encode(paramContext, "utf-8"));
        LogUtil.e(TAG, "getRequestParams() getActs --> " + localStringBuffer.toString());
        localHashMap.put("sign", MD5.toMD5("mop" + localStringBuffer.toString() + "6456bc093ca827bf3db43fb106fb2624").toLowerCase());
        BNHttpCenter.getInstance().get(HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_BUSINESS_GET_ACT), localHashMap, new BNHttpTextResponseHandler()
        {
          public void onFailure(int paramAnonymousInt, String paramAnonymousString, Throwable paramAnonymousThrowable)
          {
            LogUtil.e(BusinessActivityManager.TAG, "requestNavigatorBusinessActivity().err statusCode=" + paramAnonymousInt + ", s=" + paramAnonymousString);
            if (BusinessActivityManager.this.mHD != null)
            {
              paramAnonymousString = BusinessActivityManager.this.mHD.obtainMessage();
              paramAnonymousString.what = paramInt;
              paramAnonymousString.arg1 = 55537;
              paramAnonymousString.sendToTarget();
            }
          }
          
          public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
          {
            LogUtil.e(BusinessActivityManager.TAG, "requestNavigatorBusinessActivity().ok statusCode=" + paramAnonymousInt + ", s=" + paramAnonymousString);
            if ((paramAnonymousString != null) && (paramAnonymousString.length() > 0)) {}
            try
            {
              BusinessActivityManager.this.parseBusinessActivityJSON(new JSONObject(paramAnonymousString));
              if (BusinessActivityManager.this.mHD != null)
              {
                paramAnonymousString = BusinessActivityManager.this.mHD.obtainMessage();
                paramAnonymousString.what = paramInt;
                paramAnonymousString.arg1 = 0;
                paramAnonymousString.sendToTarget();
              }
              BusinessActivityManager.this.mBusinessActivityModel.userPerCarLogoBitmap = FileCache.loadBitmapCache(BusinessActivityManager.this.mBusinessActivityModel.userPerCarLogoLink, "");
              if (BusinessActivityManager.this.mBusinessActivityModel.userPerCarLogoBitmap != null)
              {
                if (BusinessActivityManager.this.mBusinessActivityModel.userPerCarLogoBitmap != null) {
                  BNRouteGuider.getInstance().setCarImageToMap(FileCache.getCacheFilePath(BusinessActivityManager.this.mBusinessActivityModel.userPerCarLogoLink, ""));
                }
              }
              else {
                return;
              }
            }
            catch (JSONException paramAnonymousString)
            {
              for (;;)
              {
                paramAnonymousString.printStackTrace();
              }
              BNRouteGuider.getInstance().clearCarImage();
            }
          }
        }, null);
      }
      catch (Exception paramContext)
      {
        continue;
      }
      return true;
      this.mBusinessActivityModel.clear();
    }
  }
  
  public void safetyUpload(final int paramInt, boolean paramBoolean)
  {
    LogUtil.e(TAG, "safety safetyUpload  --> action: " + paramInt + "  isShareSuc: " + this.isShareSuc);
    if (((paramInt == 1) || (paramInt == 2)) && (!this.isShareSuc)) {}
    do
    {
      return;
      if (!CloudlConfigDataModel.getInstance().mCommonConfig.safetyShow)
      {
        TipTool.onCreateToastDialog(BNavigator.getInstance().getActivity(), "行程分享敬请期待...");
        return;
      }
      if (NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
        break;
      }
    } while (paramInt != 0);
    TipTool.onCreateToastDialog(BNavigator.getInstance().getActivity(), "无网或离线导航不能分享");
    return;
    if ((paramInt == 0) && (!BNRouteGuider.getInstance().isCurDriveRouteOnline()))
    {
      TipTool.onCreateToastDialog(BNavigator.getInstance().getActivity(), "无网或离线导航不能分享");
      return;
    }
    this.isOrientationUser = paramBoolean;
    int i = 1701;
    if (paramInt == 0)
    {
      this.isCancelShareSafe = false;
      if (paramBoolean)
      {
        RGViewController.getInstance().showSafetyShareLoading();
        i = 1700;
      }
    }
    for (;;)
    {
      ReqData localReqData = new ReqData("cmd.general.http.post.func", 7, this.mHD, i, 10000);
      localReqData.mCookieStore = getCookieStore();
      CmdGeneralHttpPostFunc.addFunc(localReqData, new CmdGeneralHttpPostFunc.Callback()
      {
        public List<NameValuePair> getRequestParams()
        {
          try
          {
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
            localArrayList.add(new BasicNameValuePair("os", "0"));
            Object localObject2;
            Object localObject3;
            if ((paramInt == 0) || (paramInt == 2))
            {
              localObject1 = BusinessActivityManager.this.rpModel.getStartNode();
              localObject2 = BusinessActivityManager.this.rpModel.getEndNode();
              d1 = -1.0D;
              d2 = -1.0D;
              double d3 = -1.0D;
              double d4 = -1.0D;
              if (localObject1 != null)
              {
                d1 = ((RoutePlanNode)localObject1).mGeoPoint.getLongitudeE6() / 100000.0D;
                d2 = ((RoutePlanNode)localObject1).mGeoPoint.getLatitudeE6() / 100000.0D;
              }
              if (localObject2 != null)
              {
                d3 = ((RoutePlanNode)localObject2).mGeoPoint.getLongitudeE6() / 100000.0D;
                d4 = ((RoutePlanNode)localObject2).mGeoPoint.getLatitudeE6() / 100000.0D;
              }
              localObject1 = d1 + "," + d2;
              localObject2 = d3 + "," + d4;
              localArrayList.add(new BasicNameValuePair("from_point", (String)localObject1));
              localArrayList.add(new BasicNameValuePair("to_point", (String)localObject2));
              localObject3 = new Bundle();
              localObject2 = "";
              localObject1 = "";
              BNRoutePlaner.getInstance().getRoutePlanSessionIDAndMrsl((Bundle)localObject3);
              if (localObject3 != null)
              {
                localObject2 = ((Bundle)localObject3).getString("session");
                localObject1 = ((Bundle)localObject3).getString("mrsl");
              }
              localArrayList.add(new BasicNameValuePair("session_id", (String)localObject2));
              localArrayList.add(new BasicNameValuePair("mrsl", (String)localObject1));
            }
            localArrayList.add(new BasicNameValuePair("osv", "" + PackageUtil.getSystemVersion()));
            localArrayList.add(new BasicNameValuePair("sv", PackageUtil.getVersionName()));
            localArrayList.add(new BasicNameValuePair("action", "" + paramInt));
            double d1 = -1.0D;
            double d2 = -1.0D;
            if (BNSysLocationManager.getInstance().isSysLocationValid()) {}
            for (Object localObject1 = BNSysLocationManager.getInstance().getCurLocation();; localObject1 = BNExtGPSLocationManager.getInstance().getCurLocation())
            {
              if (localObject1 != null)
              {
                d1 = ((LocData)localObject1).longitude;
                d2 = ((LocData)localObject1).latitude;
              }
              localArrayList.add(new BasicNameValuePair("current_point", d1 + "," + d2));
              localObject3 = CloudConfigObtainManager.SortSequenceWithAscendingOder(localArrayList);
              localObject2 = JNITrajectoryControl.sInstance.getUrlParamsSign((String)localObject3);
              localObject1 = localObject2;
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                localObject1 = "";
              }
              localArrayList.add(new BasicNameValuePair("sign", (String)localObject1));
              LogUtil.e(BusinessActivityManager.TAG, "safetyUpload() uploadPs=" + (String)localObject3);
              return localArrayList;
            }
            return null;
          }
          catch (Exception localException) {}
        }
        
        public int getRequestType()
        {
          return 1;
        }
        
        public String getUrl()
        {
          return HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_SAFETY_SHARE);
        }
        
        public boolean parseResponseJSON(JSONObject paramAnonymousJSONObject)
        {
          return true;
        }
        
        public void responseImage(byte[] paramAnonymousArrayOfByte) {}
      });
      CommandCenter.getInstance().sendRequest(localReqData);
      return;
      LightNaviDialogHelper.getInstance(BNaviModuleManager.getContext()).showSafetyShareDialog().setOnCancelListener(new DialogInterface.OnCancelListener()
      {
        public void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          BusinessActivityManager.this.isCancelShareSafe = true;
        }
      });
      break;
      if (paramInt == 1) {
        i = 1701;
      } else if (paramInt == 2) {
        i = 1702;
      }
    }
  }
  
  public void updateGPSFixed(boolean paramBoolean)
  {
    if ((!paramBoolean) && (this.mBusinessActivityModel != null))
    {
      this.mBusinessActivityModel.resetTrafficJam();
      this.mBusinessActivityModel.resetParking();
      BusinessActivityViewManager.getInstance().hideViews();
    }
  }
  
  public void updateGPSSpeed(double paramDouble)
  {
    if (this.mBusinessActivityModel == null) {}
    int i;
    do
    {
      return;
      if (!this.mBusinessActivityModel.isOpen)
      {
        LogUtil.e(TAG, "updateGPSSpeed() return for activity is not open.");
        return;
      }
      if (BusinessActivityViewManager.getInstance().isShowing())
      {
        LogUtil.e(TAG, "updateGPSSpeed() return for activity is showing.");
        return;
      }
      if ((this.mBusinessActivityModel.isTrafficJam) || (this.mBusinessActivityModel.isParking))
      {
        LogUtil.e(TAG, "updateGPSSpeed() return for isTrafficJam=" + this.mBusinessActivityModel.isTrafficJam + ", isParking=" + this.mBusinessActivityModel.isParking);
        return;
      }
      i = (int)(3.6D * paramDouble + 0.5D);
      if (i > 20)
      {
        LogUtil.e(TAG, "updateGPSSpeed() return for speed over and hide views.");
        return;
      }
      if ((!BusinessActivityViewManager.getInstance().isShowing()) && ((getInstance().getModel().hasShowActivityCount >= getInstance().getModel().anum) || (getInstance().getModel().hasClickActivityCount >= getInstance().getModel().rnum)))
      {
        LogUtil.e(TAG, "updateGPSSpeed() return . received=" + getInstance().getModel().isPrizeReceived + ", hasShowCount=" + getInstance().getModel().hasShowActivityCount);
        return;
      }
      String str = JNITrajectoryControl.sInstance.getCurrentUUID();
      int j = (int)JNITrajectoryControl.sInstance.getTrajectoryLength(str);
      LogUtil.e(TAG, "updateGPSSpeed() navidist=" + j);
      if (checkTrafficJam(i, j)) {
        break;
      }
      i = checkParking(i, j);
      if ((i == 0) || (i == 1))
      {
        BusinessActivityViewManager.getInstance().hideViews();
        return;
      }
    } while (i != 2);
    BusinessActivityViewManager.getInstance().showViews(BNavigator.getInstance().getActivity(), false);
    return;
    BusinessActivityViewManager.getInstance().showViews(BNavigator.getInstance().getActivity(), false);
  }
  
  public void uploadData(Handler paramHandler, int paramInt)
  {
    if (!isNeedUploadData())
    {
      UserOPController.getInstance().add("7.3");
      LogUtil.e(TAG, "uploadData() return for not.");
    }
    Object localObject;
    do
    {
      return;
      localObject = JNITrajectoryControl.sInstance.getCurrentUUID();
    } while ((JNITrajectoryControl.sInstance.getTrajectoryLength((String)localObject) == 0L) || (this.mBusinessActivityModel == null));
    this.mOuterUploadHandler = paramHandler;
    this.mOuterUploadMsgWhat = paramInt;
    paramHandler = new Bundle();
    JNITrajectoryControl.sInstance.getPostParams(this.mBusinessActivityModel.atype, paramHandler);
    this.mBusinessActivityModel.uploadBundleData = paramHandler;
    BNNaviResultController.getInstance().notifyServerDataDownloadState(BNNaviResultController.DataDownloadType.TXT_DATA, BNNaviResultController.DataDownloadState.DOWNLOADING);
    BNNaviResultController.getInstance().notifyServerDataDownloadState(BNNaviResultController.DataDownloadType.IMG_DATA, BNNaviResultController.DataDownloadState.DOWNLOADING);
    if ((!this.mBusinessActivityModel.isUploadDataContainsValidBduss()) && (!TextUtils.isEmpty(BNaviModuleManager.getBduss())))
    {
      paramHandler = BNaviModuleManager.getBduss();
      localObject = new Bundle();
      JNITrajectoryControl.sInstance.getPostParamsForBdussUpdated((Bundle)localObject, paramHandler);
      LogUtil.e(TAG, "reload upload Data. uploadData=" + ((Bundle)localObject).toString());
      getInstance().getModel().uploadBundleData = ((Bundle)localObject);
    }
    paramHandler = new ReqData("cmd.general.http.post.func", 7, this.mHD, 1501, 5000);
    paramHandler.mCookieStore = getCookieStore();
    CmdGeneralHttpPostFunc.addFunc(paramHandler, new CmdGeneralHttpPostFunc.Callback()
    {
      public List<NameValuePair> getRequestParams()
      {
        if (BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData == null) {
          return null;
        }
        for (;;)
        {
          try
          {
            ArrayList localArrayList = new ArrayList();
            StringBuffer localStringBuffer = new StringBuffer();
            Object localObject1 = BusinessActivityManager.this.rpModel.getStartNode();
            Object localObject2 = BusinessActivityManager.this.rpModel.getEndNode();
            double d1 = -1.0D;
            double d2 = -1.0D;
            double d3 = -1.0D;
            double d4 = -1.0D;
            if (localObject1 != null)
            {
              d1 = ((RoutePlanNode)localObject1).mGeoPoint.getLongitudeE6() / 100000.0D;
              d2 = ((RoutePlanNode)localObject1).mGeoPoint.getLatitudeE6() / 100000.0D;
            }
            if (localObject2 != null)
            {
              d3 = ((RoutePlanNode)localObject2).mGeoPoint.getLongitudeE6() / 100000.0D;
              d4 = ((RoutePlanNode)localObject2).mGeoPoint.getLatitudeE6() / 100000.0D;
            }
            localObject2 = d1 + "," + d2;
            String str2 = d3 + "," + d4;
            localArrayList.add(new BasicNameValuePair("aid", "0"));
            localStringBuffer.append("&aid=" + URLEncoder.encode("0", "utf-8"));
            if (BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.containsKey("pcDataSign"))
            {
              localObject1 = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.getString("pcDataSign");
              localArrayList.add(new BasicNameValuePair("as", (String)localObject1));
              localStringBuffer.append("&as=" + URLEncoder.encode((String)localObject1, "utf-8"));
              localArrayList.add(new BasicNameValuePair("atype", "" + BusinessActivityManager.this.mBusinessActivityModel.atype));
              localStringBuffer.append("&atype=" + URLEncoder.encode(new StringBuilder().append("").append(BusinessActivityManager.this.mBusinessActivityModel.atype).toString(), "utf-8"));
              localObject1 = "0";
              if (GeoLocateModel.getInstance().getCurrentDistrict() != null) {
                localObject1 = "" + GeoLocateModel.getInstance().getCurrentDistrict().mId;
              }
              localArrayList.add(new BasicNameValuePair("cityid", (String)localObject1));
              localStringBuffer.append("&cityid=" + URLEncoder.encode((String)localObject1, "utf-8"));
              if (!BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.containsKey("ulCreateTime")) {
                break label2172;
              }
              localObject1 = "" + BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.getLong("ulCreateTime");
              localArrayList.add(new BasicNameValuePair("ct", (String)localObject1));
              localStringBuffer.append("&ct=" + URLEncoder.encode((String)localObject1, "utf-8"));
              if (!BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.containsKey("pcCuid")) {
                break label2179;
              }
              localObject1 = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.getString("pcCuid");
              localArrayList.add(new BasicNameValuePair("cuid", (String)localObject1));
              localStringBuffer.append("&cuid=" + URLEncoder.encode((String)localObject1, "utf-8"));
              localArrayList.add(new BasicNameValuePair("data_type", "2"));
              localStringBuffer.append("&data_type=" + URLEncoder.encode("2", "utf-8"));
              localArrayList.add(new BasicNameValuePair("end_position", str2));
              localStringBuffer.append("&end_position=" + URLEncoder.encode(str2, "utf-8"));
              if (!BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.containsKey("pcFrom")) {
                break label2186;
              }
              localObject1 = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.getString("pcFrom");
              localArrayList.add(new BasicNameValuePair("from", (String)localObject1));
              localStringBuffer.append("&from=" + URLEncoder.encode((String)localObject1, "utf-8"));
              if (!BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.containsKey("pcGuid")) {
                break label2193;
              }
              localObject1 = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.getString("pcGuid");
              localArrayList.add(new BasicNameValuePair("guid", (String)localObject1));
              localStringBuffer.append("&guid=" + URLEncoder.encode((String)localObject1, "utf-8"));
              if (!BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.containsKey("pcNaviActInfo")) {
                break label2200;
              }
              localObject1 = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.getString("pcNaviActInfo");
              localArrayList.add(new BasicNameValuePair("navi_act_info", (String)localObject1));
              localStringBuffer.append("&navi_act_info=" + URLEncoder.encode((String)localObject1, "utf-8"));
              if (!BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.containsKey("bIsChangedKey")) {
                break label2213;
              }
              localObject1 = new StringBuilder().append("");
              if (!BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.getBoolean("bIsChangedKey")) {
                break label2207;
              }
              i = 1;
              localObject1 = i;
              localArrayList.add(new BasicNameValuePair("pek", (String)localObject1));
              localStringBuffer.append("&pek=" + URLEncoder.encode((String)localObject1, "utf-8"));
              if (!BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.containsKey("unKeyVesion")) {
                break label2220;
              }
              localObject1 = "" + BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.getInt("unKeyVesion");
              localArrayList.add(new BasicNameValuePair("pv", (String)localObject1));
              localStringBuffer.append("&pv=" + URLEncoder.encode((String)localObject1, "utf-8"));
              localArrayList.add(new BasicNameValuePair("qtv", "2"));
              localStringBuffer.append("&qtv=" + URLEncoder.encode("2", "utf-8"));
              if (TextUtils.isEmpty(BusinessActivityManager.this.mBusinessActivityModel.session))
              {
                localObject1 = "";
                localArrayList.add(new BasicNameValuePair("session", (String)localObject1));
                localStringBuffer.append("&session=" + URLEncoder.encode((String)localObject1, "utf-8"));
                if (!BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.containsKey("pcSessionID")) {
                  break label2227;
                }
                localObject1 = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.getString("pcSessionID");
                localArrayList.add(new BasicNameValuePair("sid", (String)localObject1));
                localStringBuffer.append("&sid=" + URLEncoder.encode((String)localObject1, "utf-8"));
                localArrayList.add(new BasicNameValuePair("st", "" + BusinessActivityManager.this.mBusinessActivityModel.timestamp));
                localStringBuffer.append("&st=" + URLEncoder.encode(new StringBuilder().append("").append(BusinessActivityManager.this.mBusinessActivityModel.timestamp).toString(), "utf-8"));
                localArrayList.add(new BasicNameValuePair("start_position", (String)localObject2));
                localStringBuffer.append("&start_position=" + URLEncoder.encode((String)localObject2, "utf-8"));
                if (!BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.containsKey("pcSoftVersion")) {
                  break label2234;
                }
                localObject1 = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.getString("pcSoftVersion");
                localArrayList.add(new BasicNameValuePair("sv", (String)localObject1));
                localStringBuffer.append("&sv=" + URLEncoder.encode((String)localObject1, "utf-8"));
                if (BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.containsKey("pcPoiID"))
                {
                  localObject1 = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleData.getString("pcPoiID");
                  localArrayList.add(new BasicNameValuePair("uid", (String)localObject1));
                  localStringBuffer.append("&uid=" + URLEncoder.encode((String)localObject1, "utf-8"));
                  localArrayList.add(new BasicNameValuePair("yaw_num", String.valueOf(BNNaviResultModel.getInstance().yawNum)));
                  localStringBuffer.append("&yaw_num=" + URLEncoder.encode(String.valueOf(BNNaviResultModel.getInstance().yawNum), "utf-8"));
                  localArrayList.add(new BasicNameValuePair("mainside_num", String.valueOf(BNNaviResultModel.getInstance().instantNum)));
                  localStringBuffer.append("&mainside_num=" + URLEncoder.encode(String.valueOf(BNNaviResultModel.getInstance().instantNum), "utf-8"));
                  localArrayList.add(new BasicNameValuePair("is_switch", String.valueOf(BNNaviResultModel.getInstance().isSwitch)));
                  localStringBuffer.append("&is_switch=" + URLEncoder.encode(String.valueOf(BNNaviResultModel.getInstance().isSwitch), "utf-8"));
                  localObject1 = CloudConfigObtainManager.SortSequenceWithAscendingOder(localArrayList);
                  localObject2 = JNITrajectoryControl.sInstance.getUrlParamsSign((String)localObject1);
                  localObject1 = localObject2;
                  if (TextUtils.isEmpty((CharSequence)localObject2)) {
                    localObject1 = "";
                  }
                  localArrayList.add(new BasicNameValuePair("sign", (String)localObject1));
                  localStringBuffer.append("&sign=" + URLEncoder.encode((String)localObject1, "utf-8"));
                  LogUtil.e(BusinessActivityManager.TAG, "getRequestParams() uploadData --> " + localStringBuffer.toString());
                  return localArrayList;
                }
              }
              else
              {
                localObject1 = BusinessActivityManager.this.mBusinessActivityModel.session;
                continue;
              }
              localObject1 = "";
              continue;
            }
            str1 = "";
          }
          catch (Exception localException)
          {
            return null;
          }
          continue;
          label2172:
          String str1 = "";
          continue;
          label2179:
          str1 = "";
          continue;
          label2186:
          str1 = "";
          continue;
          label2193:
          str1 = "";
          continue;
          label2200:
          str1 = "";
          continue;
          label2207:
          int i = 0;
          continue;
          label2213:
          str1 = "";
          continue;
          label2220:
          str1 = "";
          continue;
          label2227:
          str1 = "";
          continue;
          label2234:
          str1 = "";
        }
      }
      
      public int getRequestType()
      {
        return 1;
      }
      
      public String getUrl()
      {
        return HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_BUSINESS_UPLOAD);
      }
      
      public boolean parseResponseJSON(JSONObject paramAnonymousJSONObject)
      {
        return BusinessActivityManager.this.parseUploadJSON(paramAnonymousJSONObject);
      }
      
      public void responseImage(byte[] paramAnonymousArrayOfByte) {}
    });
    CommandCenter.getInstance().sendRequest(paramHandler);
  }
  
  public void uploadDataForNaving(Handler paramHandler, int paramInt)
  {
    if (!isNeedUploadData()) {
      LogUtil.e(TAG, "uploadDataForNaving() return for not.");
    }
    while (this.mBusinessActivityModel == null) {
      return;
    }
    this.mOuterUploadHandlerForNaving = paramHandler;
    this.mOuterUploadMsgWhatForNaving = paramInt;
    if ((!this.mBusinessActivityModel.isUploadDataContainsValidBdussoForNaving()) && (!TextUtils.isEmpty(BNaviModuleManager.getBduss())))
    {
      paramHandler = BNaviModuleManager.getBduss();
      Bundle localBundle = new Bundle();
      JNITrajectoryControl.sInstance.getPostParamsForBdussUpdated(localBundle, paramHandler);
      LogUtil.e(TAG, "reload upload Data. uploadData=" + localBundle.toString());
      this.mBusinessActivityModel.uploadBundleDataForNaving = localBundle;
    }
    paramHandler = new ReqData("cmd.general.http.post.func", 7, this.mHD, 1502, 10000);
    paramHandler.mCookieStore = getCookieStore();
    CmdGeneralHttpPostFunc.addFunc(paramHandler, new CmdGeneralHttpPostFunc.Callback()
    {
      public List<NameValuePair> getRequestParams()
      {
        if (BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving == null) {
          return null;
        }
        for (;;)
        {
          try
          {
            ArrayList localArrayList = new ArrayList();
            StringBuffer localStringBuffer = new StringBuffer();
            Object localObject1 = BusinessActivityManager.this.rpModel.getStartNode();
            Object localObject2 = BusinessActivityManager.this.rpModel.getEndNode();
            double d1 = -1.0D;
            double d2 = -1.0D;
            double d3 = -1.0D;
            double d4 = -1.0D;
            if (localObject1 != null)
            {
              d1 = ((RoutePlanNode)localObject1).mGeoPoint.getLongitudeE6() / 100000.0D;
              d2 = ((RoutePlanNode)localObject1).mGeoPoint.getLatitudeE6() / 100000.0D;
            }
            if (localObject2 != null)
            {
              d3 = ((RoutePlanNode)localObject2).mGeoPoint.getLongitudeE6() / 100000.0D;
              d4 = ((RoutePlanNode)localObject2).mGeoPoint.getLatitudeE6() / 100000.0D;
            }
            localObject2 = d1 + "," + d2;
            String str2 = d3 + "," + d4;
            localArrayList.add(new BasicNameValuePair("aid", "0"));
            localStringBuffer.append("&aid=" + URLEncoder.encode("0", "utf-8"));
            if (BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.containsKey("pcDataSign"))
            {
              localObject1 = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.getString("pcDataSign");
              localArrayList.add(new BasicNameValuePair("as", (String)localObject1));
              localStringBuffer.append("&as=" + URLEncoder.encode((String)localObject1, "utf-8"));
              localArrayList.add(new BasicNameValuePair("atype", "0"));
              localStringBuffer.append("&atype=" + URLEncoder.encode("0", "utf-8"));
              localObject1 = "0";
              if (GeoLocateModel.getInstance().getCurrentDistrict() != null) {
                localObject1 = "" + GeoLocateModel.getInstance().getCurrentDistrict().mId;
              }
              localArrayList.add(new BasicNameValuePair("cityid", (String)localObject1));
              localStringBuffer.append("&cityid=" + URLEncoder.encode((String)localObject1, "utf-8"));
              if (!BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.containsKey("ulCreateTime")) {
                break label1922;
              }
              localObject1 = "" + BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.getLong("ulCreateTime");
              localArrayList.add(new BasicNameValuePair("ct", (String)localObject1));
              localStringBuffer.append("&ct=" + URLEncoder.encode((String)localObject1, "utf-8"));
              if (!BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.containsKey("pcCuid")) {
                break label1929;
              }
              localObject1 = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.getString("pcCuid");
              localArrayList.add(new BasicNameValuePair("cuid", (String)localObject1));
              localStringBuffer.append("&cuid=" + URLEncoder.encode((String)localObject1, "utf-8"));
              localArrayList.add(new BasicNameValuePair("data_type", "1"));
              localStringBuffer.append("&data_type=" + URLEncoder.encode("1", "utf-8"));
              localArrayList.add(new BasicNameValuePair("end_position", str2));
              localStringBuffer.append("&end_position=" + URLEncoder.encode(str2, "utf-8"));
              if (!BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.containsKey("pcFrom")) {
                break label1936;
              }
              localObject1 = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.getString("pcFrom");
              localArrayList.add(new BasicNameValuePair("from", (String)localObject1));
              localStringBuffer.append("&from=" + URLEncoder.encode((String)localObject1, "utf-8"));
              if (!BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.containsKey("pcGuid")) {
                break label1943;
              }
              localObject1 = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.getString("pcGuid");
              localArrayList.add(new BasicNameValuePair("guid", (String)localObject1));
              localStringBuffer.append("&guid=" + URLEncoder.encode((String)localObject1, "utf-8"));
              if (!BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.containsKey("pcNaviActInfo")) {
                break label1950;
              }
              localObject1 = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.getString("pcNaviActInfo");
              localArrayList.add(new BasicNameValuePair("navi_act_info", (String)localObject1));
              localStringBuffer.append("&navi_act_info=" + URLEncoder.encode((String)localObject1, "utf-8"));
              if (!BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.containsKey("bIsChangedKey")) {
                break label1963;
              }
              localObject1 = new StringBuilder().append("");
              if (!BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.getBoolean("bIsChangedKey")) {
                break label1957;
              }
              i = 1;
              localObject1 = i;
              localArrayList.add(new BasicNameValuePair("pek", (String)localObject1));
              localStringBuffer.append("&pek=" + URLEncoder.encode((String)localObject1, "utf-8"));
              if (!BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.containsKey("unKeyVesion")) {
                break label1970;
              }
              localObject1 = "" + BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.getInt("unKeyVesion");
              localArrayList.add(new BasicNameValuePair("pv", (String)localObject1));
              localStringBuffer.append("&pv=" + URLEncoder.encode((String)localObject1, "utf-8"));
              localArrayList.add(new BasicNameValuePair("qtv", "2"));
              localStringBuffer.append("&qtv=" + URLEncoder.encode("2", "utf-8"));
              if (TextUtils.isEmpty(BusinessActivityManager.this.mBusinessActivityModel.session))
              {
                localObject1 = "";
                localArrayList.add(new BasicNameValuePair("session", (String)localObject1));
                localStringBuffer.append("&session=" + URLEncoder.encode((String)localObject1, "utf-8"));
                if (!BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.containsKey("pcSessionID")) {
                  break label1977;
                }
                localObject1 = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.getString("pcSessionID");
                localArrayList.add(new BasicNameValuePair("sid", (String)localObject1));
                localStringBuffer.append("&sid=" + URLEncoder.encode((String)localObject1, "utf-8"));
                localArrayList.add(new BasicNameValuePair("st", "" + BusinessActivityManager.this.mBusinessActivityModel.timestamp));
                localStringBuffer.append("&st=" + URLEncoder.encode(new StringBuilder().append("").append(BusinessActivityManager.this.mBusinessActivityModel.timestamp).toString(), "utf-8"));
                localArrayList.add(new BasicNameValuePair("start_position", (String)localObject2));
                localStringBuffer.append("&start_position=" + URLEncoder.encode((String)localObject2, "utf-8"));
                if (!BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.containsKey("pcSoftVersion")) {
                  break label1984;
                }
                localObject1 = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.getString("pcSoftVersion");
                localArrayList.add(new BasicNameValuePair("sv", (String)localObject1));
                localStringBuffer.append("&sv=" + URLEncoder.encode((String)localObject1, "utf-8"));
                if (BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.containsKey("pcPoiID"))
                {
                  localObject1 = BusinessActivityManager.this.mBusinessActivityModel.uploadBundleDataForNaving.getString("pcPoiID");
                  localArrayList.add(new BasicNameValuePair("uid", (String)localObject1));
                  localStringBuffer.append("&uid=" + URLEncoder.encode((String)localObject1, "utf-8"));
                  localObject1 = CloudConfigObtainManager.SortSequenceWithAscendingOder(localArrayList);
                  localObject2 = JNITrajectoryControl.sInstance.getUrlParamsSign((String)localObject1);
                  localObject1 = localObject2;
                  if (TextUtils.isEmpty((CharSequence)localObject2)) {
                    localObject1 = "";
                  }
                  localArrayList.add(new BasicNameValuePair("sign", (String)localObject1));
                  localStringBuffer.append("&sign=" + URLEncoder.encode((String)localObject1, "utf-8"));
                  LogUtil.e(BusinessActivityManager.TAG, "uploadData() uploadPs=" + localStringBuffer.toString());
                  return localArrayList;
                }
              }
              else
              {
                localObject1 = BusinessActivityManager.this.mBusinessActivityModel.session;
                continue;
              }
              localObject1 = "";
              continue;
            }
            str1 = "";
          }
          catch (Exception localException)
          {
            return null;
          }
          continue;
          label1922:
          String str1 = "";
          continue;
          label1929:
          str1 = "";
          continue;
          label1936:
          str1 = "";
          continue;
          label1943:
          str1 = "";
          continue;
          label1950:
          str1 = "";
          continue;
          label1957:
          int i = 0;
          continue;
          label1963:
          str1 = "";
          continue;
          label1970:
          str1 = "";
          continue;
          label1977:
          str1 = "";
          continue;
          label1984:
          str1 = "";
        }
      }
      
      public int getRequestType()
      {
        return 1;
      }
      
      public String getUrl()
      {
        return HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_BUSINESS_UPLOAD);
      }
      
      public boolean parseResponseJSON(JSONObject paramAnonymousJSONObject)
      {
        return BusinessActivityManager.this.parseUploadJSONForNaving(paramAnonymousJSONObject);
      }
      
      public void responseImage(byte[] paramAnonymousArrayOfByte) {}
    });
    CommandCenter.getInstance().sendRequest(paramHandler);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/BusinessActivityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */