package com.baidu.navisdk.module.routereport;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.module.cloudconfig.CloudConfigObtainManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.FileUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.drawable.UrlDrawableContainIView;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.HttpURLManager.ULRParam;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpCenterHelper;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import com.baidu.navisdk.util.http.center.IBNHttpCenter;
import com.baidu.navisdk.util.jar.JarUtils;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BNRouteReportController
{
  public static final int BUSINESS_TRIGGER_AFTER_NAVI = 4;
  public static final int BUSINESS_TRIGGER_BEFORE_NAVI = 7;
  public static final int MSG_ROUTE_REPORT_UPLOAD_RET = 257;
  public static final int ROUTE_REPORT_AFTER_NAVI = 2;
  public static final int ROUTE_REPORT_BEFORE_NAVI = 1;
  private static final String TAG = BNRouteReportController.class.getSimpleName();
  private static int logMsgCount = 0;
  private boolean isIntentBeforeNavi = true;
  private boolean isUploading = false;
  private WeakReference<Activity> mActivityRef = null;
  private int mIntentType;
  private Handler mReportHandler = new Handler(Looper.getMainLooper())
  {
    /* Error */
    public void handleMessage(Message paramAnonymousMessage)
    {
      // Byte code:
      //   0: aload_1
      //   1: ifnonnull +4 -> 5
      //   4: return
      //   5: aload_1
      //   6: getfield 28	android/os/Message:what	I
      //   9: sipush 257
      //   12: if_icmpne -8 -> 4
      //   15: aload_1
      //   16: getfield 31	android/os/Message:arg1	I
      //   19: ifne +241 -> 260
      //   22: aload_1
      //   23: getfield 35	android/os/Message:obj	Ljava/lang/Object;
      //   26: checkcast 37	com/baidu/navisdk/logic/RspData
      //   29: getfield 40	com/baidu/navisdk/logic/RspData:mData	Ljava/lang/Object;
      //   32: checkcast 42	org/json/JSONObject
      //   35: astore_1
      //   36: invokestatic 46	com/baidu/navisdk/module/routereport/BNRouteReportController:access$200	()Ljava/lang/String;
      //   39: new 48	java/lang/StringBuilder
      //   42: dup
      //   43: invokespecial 51	java/lang/StringBuilder:<init>	()V
      //   46: ldc 53
      //   48: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   51: aload_1
      //   52: invokevirtual 60	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   55: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   58: invokestatic 69	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   61: aload_1
      //   62: ldc 71
      //   64: invokevirtual 75	org/json/JSONObject:getInt	(Ljava/lang/String;)I
      //   67: ifne +122 -> 189
      //   70: aload_1
      //   71: ldc 77
      //   73: invokevirtual 81	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
      //   76: astore_1
      //   77: aload_0
      //   78: getfield 12	com/baidu/navisdk/module/routereport/BNRouteReportController$1:this$0	Lcom/baidu/navisdk/module/routereport/BNRouteReportController;
      //   81: invokevirtual 85	com/baidu/navisdk/module/routereport/BNRouteReportController:getActivity	()Landroid/app/Activity;
      //   84: ifnull +19 -> 103
      //   87: aload_0
      //   88: getfield 12	com/baidu/navisdk/module/routereport/BNRouteReportController$1:this$0	Lcom/baidu/navisdk/module/routereport/BNRouteReportController;
      //   91: invokevirtual 85	com/baidu/navisdk/module/routereport/BNRouteReportController:getActivity	()Landroid/app/Activity;
      //   94: aload_1
      //   95: ldc 87
      //   97: invokevirtual 91	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   100: invokestatic 97	com/baidu/navisdk/ui/util/TipTool:onCreateToastDialog	(Landroid/content/Context;Ljava/lang/String;)V
      //   103: aload_0
      //   104: getfield 12	com/baidu/navisdk/module/routereport/BNRouteReportController$1:this$0	Lcom/baidu/navisdk/module/routereport/BNRouteReportController;
      //   107: invokestatic 101	com/baidu/navisdk/module/routereport/BNRouteReportController:access$300	(Lcom/baidu/navisdk/module/routereport/BNRouteReportController;)Lcom/baidu/navisdk/module/routereport/BNRouteReportModel;
      //   110: invokevirtual 106	com/baidu/navisdk/module/routereport/BNRouteReportModel:getUploadingVoiceFilePath	()Ljava/lang/String;
      //   113: ifnull +28 -> 141
      //   116: aload_0
      //   117: getfield 12	com/baidu/navisdk/module/routereport/BNRouteReportController$1:this$0	Lcom/baidu/navisdk/module/routereport/BNRouteReportController;
      //   120: invokestatic 101	com/baidu/navisdk/module/routereport/BNRouteReportController:access$300	(Lcom/baidu/navisdk/module/routereport/BNRouteReportController;)Lcom/baidu/navisdk/module/routereport/BNRouteReportModel;
      //   123: invokevirtual 106	com/baidu/navisdk/module/routereport/BNRouteReportModel:getUploadingVoiceFilePath	()Ljava/lang/String;
      //   126: invokestatic 112	com/baidu/navisdk/util/common/FileUtils:del	(Ljava/lang/String;)Z
      //   129: pop
      //   130: aload_0
      //   131: getfield 12	com/baidu/navisdk/module/routereport/BNRouteReportController$1:this$0	Lcom/baidu/navisdk/module/routereport/BNRouteReportController;
      //   134: invokestatic 101	com/baidu/navisdk/module/routereport/BNRouteReportController:access$300	(Lcom/baidu/navisdk/module/routereport/BNRouteReportController;)Lcom/baidu/navisdk/module/routereport/BNRouteReportModel;
      //   137: aconst_null
      //   138: invokevirtual 116	com/baidu/navisdk/module/routereport/BNRouteReportModel:setUploadingVoiceFilePath	(Ljava/lang/String;)V
      //   141: aload_0
      //   142: getfield 12	com/baidu/navisdk/module/routereport/BNRouteReportController$1:this$0	Lcom/baidu/navisdk/module/routereport/BNRouteReportController;
      //   145: invokestatic 101	com/baidu/navisdk/module/routereport/BNRouteReportController:access$300	(Lcom/baidu/navisdk/module/routereport/BNRouteReportController;)Lcom/baidu/navisdk/module/routereport/BNRouteReportModel;
      //   148: invokevirtual 119	com/baidu/navisdk/module/routereport/BNRouteReportModel:getUploadingImgFilePath	()Ljava/lang/String;
      //   151: ifnull +28 -> 179
      //   154: aload_0
      //   155: getfield 12	com/baidu/navisdk/module/routereport/BNRouteReportController$1:this$0	Lcom/baidu/navisdk/module/routereport/BNRouteReportController;
      //   158: invokestatic 101	com/baidu/navisdk/module/routereport/BNRouteReportController:access$300	(Lcom/baidu/navisdk/module/routereport/BNRouteReportController;)Lcom/baidu/navisdk/module/routereport/BNRouteReportModel;
      //   161: invokevirtual 119	com/baidu/navisdk/module/routereport/BNRouteReportModel:getUploadingImgFilePath	()Ljava/lang/String;
      //   164: invokestatic 112	com/baidu/navisdk/util/common/FileUtils:del	(Ljava/lang/String;)Z
      //   167: pop
      //   168: aload_0
      //   169: getfield 12	com/baidu/navisdk/module/routereport/BNRouteReportController$1:this$0	Lcom/baidu/navisdk/module/routereport/BNRouteReportController;
      //   172: invokestatic 101	com/baidu/navisdk/module/routereport/BNRouteReportController:access$300	(Lcom/baidu/navisdk/module/routereport/BNRouteReportController;)Lcom/baidu/navisdk/module/routereport/BNRouteReportModel;
      //   175: aconst_null
      //   176: invokevirtual 122	com/baidu/navisdk/module/routereport/BNRouteReportModel:setUploadingImgFilePath	(Ljava/lang/String;)V
      //   179: aload_0
      //   180: getfield 12	com/baidu/navisdk/module/routereport/BNRouteReportController$1:this$0	Lcom/baidu/navisdk/module/routereport/BNRouteReportController;
      //   183: iconst_0
      //   184: invokestatic 126	com/baidu/navisdk/module/routereport/BNRouteReportController:access$402	(Lcom/baidu/navisdk/module/routereport/BNRouteReportController;Z)Z
      //   187: pop
      //   188: return
      //   189: aload_0
      //   190: getfield 12	com/baidu/navisdk/module/routereport/BNRouteReportController$1:this$0	Lcom/baidu/navisdk/module/routereport/BNRouteReportController;
      //   193: invokevirtual 85	com/baidu/navisdk/module/routereport/BNRouteReportController:getActivity	()Landroid/app/Activity;
      //   196: ifnull -93 -> 103
      //   199: aload_0
      //   200: getfield 12	com/baidu/navisdk/module/routereport/BNRouteReportController$1:this$0	Lcom/baidu/navisdk/module/routereport/BNRouteReportController;
      //   203: invokevirtual 85	com/baidu/navisdk/module/routereport/BNRouteReportController:getActivity	()Landroid/app/Activity;
      //   206: invokestatic 132	com/baidu/navisdk/util/jar/JarUtils:getResources	()Landroid/content/res/Resources;
      //   209: ldc -123
      //   211: invokevirtual 138	android/content/res/Resources:getString	(I)Ljava/lang/String;
      //   214: invokestatic 97	com/baidu/navisdk/ui/util/TipTool:onCreateToastDialog	(Landroid/content/Context;Ljava/lang/String;)V
      //   217: goto -114 -> 103
      //   220: astore_1
      //   221: invokestatic 46	com/baidu/navisdk/module/routereport/BNRouteReportController:access$200	()Ljava/lang/String;
      //   224: ldc -116
      //   226: invokestatic 69	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   229: aload_0
      //   230: getfield 12	com/baidu/navisdk/module/routereport/BNRouteReportController$1:this$0	Lcom/baidu/navisdk/module/routereport/BNRouteReportController;
      //   233: invokevirtual 85	com/baidu/navisdk/module/routereport/BNRouteReportController:getActivity	()Landroid/app/Activity;
      //   236: ifnull -133 -> 103
      //   239: aload_0
      //   240: getfield 12	com/baidu/navisdk/module/routereport/BNRouteReportController$1:this$0	Lcom/baidu/navisdk/module/routereport/BNRouteReportController;
      //   243: invokevirtual 85	com/baidu/navisdk/module/routereport/BNRouteReportController:getActivity	()Landroid/app/Activity;
      //   246: invokestatic 132	com/baidu/navisdk/util/jar/JarUtils:getResources	()Landroid/content/res/Resources;
      //   249: ldc -123
      //   251: invokevirtual 138	android/content/res/Resources:getString	(I)Ljava/lang/String;
      //   254: invokestatic 97	com/baidu/navisdk/ui/util/TipTool:onCreateToastDialog	(Landroid/content/Context;Ljava/lang/String;)V
      //   257: goto -154 -> 103
      //   260: invokestatic 46	com/baidu/navisdk/module/routereport/BNRouteReportController:access$200	()Ljava/lang/String;
      //   263: new 48	java/lang/StringBuilder
      //   266: dup
      //   267: invokespecial 51	java/lang/StringBuilder:<init>	()V
      //   270: ldc -114
      //   272: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   275: aload_1
      //   276: invokevirtual 143	android/os/Message:toString	()Ljava/lang/String;
      //   279: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   282: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   285: invokestatic 69	com/baidu/navisdk/util/common/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   288: aload_0
      //   289: getfield 12	com/baidu/navisdk/module/routereport/BNRouteReportController$1:this$0	Lcom/baidu/navisdk/module/routereport/BNRouteReportController;
      //   292: invokevirtual 85	com/baidu/navisdk/module/routereport/BNRouteReportController:getActivity	()Landroid/app/Activity;
      //   295: ifnull -192 -> 103
      //   298: aload_0
      //   299: getfield 12	com/baidu/navisdk/module/routereport/BNRouteReportController$1:this$0	Lcom/baidu/navisdk/module/routereport/BNRouteReportController;
      //   302: invokevirtual 85	com/baidu/navisdk/module/routereport/BNRouteReportController:getActivity	()Landroid/app/Activity;
      //   305: invokestatic 132	com/baidu/navisdk/util/jar/JarUtils:getResources	()Landroid/content/res/Resources;
      //   308: ldc -112
      //   310: invokevirtual 138	android/content/res/Resources:getString	(I)Ljava/lang/String;
      //   313: invokestatic 97	com/baidu/navisdk/ui/util/TipTool:onCreateToastDialog	(Landroid/content/Context;Ljava/lang/String;)V
      //   316: goto -213 -> 103
      //   319: astore_1
      //   320: goto -141 -> 179
      //   323: astore_1
      //   324: goto -183 -> 141
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	327	0	this	1
      //   0	327	1	paramAnonymousMessage	Message
      // Exception table:
      //   from	to	target	type
      //   22	103	220	org/json/JSONException
      //   189	217	220	org/json/JSONException
      //   141	179	319	java/lang/Throwable
      //   103	141	323	java/lang/Throwable
    }
  };
  private BNRouteReportModel model = null;
  private BNRouteReportUI view = null;
  private BNRouteReportCallback wrapperCallback = null;
  private boolean yellowBarClosedForThisLaunch = false;
  
  public static BNRouteReportController getInstance()
  {
    return LazyLoader.instance;
  }
  
  private String getUTF8Encode(String paramString)
  {
    String str = "";
    if (paramString != null) {}
    try
    {
      str = URLEncoder.encode(paramString, "utf-8");
      return str;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public static String ll2mcStr(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 == -2.147483648E9D) || (paramDouble2 == -2.147483648E9D)) {}
    Bundle localBundle;
    do
    {
      return null;
      localBundle = CoordinateTransformUtil.LL2MC(paramDouble1, paramDouble2);
    } while (localBundle == null);
    return localBundle.getInt("MCx") + "," + localBundle.getInt("MCy");
  }
  
  private void logLocalDataError(String paramString)
  {
    if (LogUtil.LOGGABLE)
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder().append("logLocalDataError: ");
      int i = logMsgCount;
      logMsgCount = i + 1;
      LogUtil.e(str, i + " --> " + paramString);
    }
  }
  
  public static void setupUrlDrawable(ImageView paramImageView, int paramInt, final String paramString)
  {
    if (paramImageView == null) {
      return;
    }
    int i = paramInt;
    if (paramInt < 0) {
      i = 1711407326;
    }
    UrlDrawableContainIView.getDrawable(paramString, i, paramImageView, new Handler(Looper.getMainLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        super.handleMessage(paramAnonymousMessage);
        if ((paramAnonymousMessage.what != 8192) || (paramAnonymousMessage.arg1 == 0)) {
          return;
        }
        LogUtil.e(BNRouteReportController.TAG, "setupUrlDrawable: Fail --> url: " + paramString);
      }
    });
  }
  
  public View creatUI(Activity paramActivity, int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    this.mIntentType = paramInt;
    if (paramInt == 1) {}
    for (;;)
    {
      this.isIntentBeforeNavi = bool;
      this.mActivityRef = new WeakReference(paramActivity);
      this.view = new BNRouteReportUI(paramActivity, paramBoolean);
      BNRouteReportModel.getInstance().resetCurrentReportModel();
      BNRouteReportModel.getInstance().getCurrentRouteReportModel().isIntentBeforeNavi = this.isIntentBeforeNavi;
      return this.view.getRootView();
      bool = false;
    }
  }
  
  public Activity getActivity()
  {
    return (Activity)this.mActivityRef.get();
  }
  
  public int getIntentType()
  {
    return this.mIntentType;
  }
  
  public RelativeLayout getMapPanelContainer()
  {
    if (this.view == null) {
      return null;
    }
    return this.view.getMapPanelContainer();
  }
  
  public ViewGroup getSelectionPointerContainer()
  {
    if (this.view == null) {
      return null;
    }
    return this.view.getSelectionPointerContainer();
  }
  
  public int[] getTopAndBottomHeightDp()
  {
    if (this.view == null) {
      return null;
    }
    return this.view.getTopAndBottomHeightDp();
  }
  
  public boolean isIntentBeforeNavi()
  {
    return this.isIntentBeforeNavi;
  }
  
  public boolean isUploading()
  {
    return this.isUploading;
  }
  
  public boolean isYellowBarClosedForThisLaunch()
  {
    return this.yellowBarClosedForThisLaunch;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.view.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackPressed()
  {
    if (this.view == null) {
      return false;
    }
    return this.view.onBackPressed();
  }
  
  public void onClickConfirm(Bundle paramBundle)
  {
    this.model.setAddrResult(paramBundle);
    this.view.nextState(true);
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.view == null) {
      return;
    }
    this.view.onConfigurationChanged(paramConfiguration);
  }
  
  public void onDestroy()
  {
    if (this.view == null) {
      return;
    }
    this.view.onDestroy();
    this.view = null;
  }
  
  public void onPause()
  {
    if (this.view == null) {
      return;
    }
    this.view.onPause();
  }
  
  public void onResume()
  {
    if (this.view == null) {
      return;
    }
    this.view.onResume();
  }
  
  public void onWrapperAction(int paramInt)
  {
    if (this.wrapperCallback == null) {
      return;
    }
    this.wrapperCallback.onAction(paramInt);
  }
  
  public void parseRouteReportItemJson(JSONArray paramJSONArray, int paramInt)
  {
    this.model.parseRouteReportItemJson(paramJSONArray, paramInt);
  }
  
  public void registerWrapperCallback(BNRouteReportCallback paramBNRouteReportCallback)
  {
    this.wrapperCallback = paramBNRouteReportCallback;
  }
  
  public void release()
  {
    this.model.reset();
    this.yellowBarClosedForThisLaunch = false;
  }
  
  public void reset()
  {
    LogUtil.e(TAG, "reset: -->> Data Reset!");
    if (this.view != null)
    {
      this.view.onDestroy();
      this.view = null;
    }
  }
  
  public void setUploading(boolean paramBoolean)
  {
    this.isUploading = paramBoolean;
  }
  
  public void setYellowBarClosedForThisLaunch(boolean paramBoolean)
  {
    this.yellowBarClosedForThisLaunch = paramBoolean;
  }
  
  public void updateYellowBarState(int paramInt)
  {
    if (this.view != null) {
      this.view.updateYellowBarState(paramInt);
    }
  }
  
  public boolean upload()
  {
    LogUtil.e(TAG, "upload: isUploading --> " + this.isUploading);
    if (this.isUploading) {
      return false;
    }
    this.isUploading = true;
    BNHttpParams localBNHttpParams = new BNHttpParams();
    localBNHttpParams.isAsync = true;
    localBNHttpParams.postFileMap = new HashMap();
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = this.model.getCurrentRouteReportModel();
    LogUtil.e(TAG, "getMultipartEntity: currentRouteReportModel --> " + localObject1);
    boolean bool = ((BNRouteReportModel.CurrentRouteReportModel)localObject1).isIntentBeforeNavi;
    for (;;)
    {
      try
      {
        localArrayList.add(new BasicNameValuePair("user_point", ((BNRouteReportModel.CurrentRouteReportModel)localObject1).userPoint));
        localArrayList.add(new BasicNameValuePair("point", ((BNRouteReportModel.CurrentRouteReportModel)localObject1).point));
        if (!bool) {
          break label1315;
        }
        i = 7;
        localArrayList.add(new BasicNameValuePair("business_trigger", "" + i));
        localArrayList.add(new BasicNameValuePair("parent_type", ((BNRouteReportModel.CurrentRouteReportModel)localObject1).parentType));
        if (((BNRouteReportModel.CurrentRouteReportModel)localObject1).subType != null) {
          localArrayList.add(new BasicNameValuePair("sub_type", ((BNRouteReportModel.CurrentRouteReportModel)localObject1).subType));
        }
        if (!bool)
        {
          localObject2 = JNITrajectoryControl.sInstance.getCurrentUUID();
          if (TextUtils.isEmpty((CharSequence)localObject2)) {
            continue;
          }
          localArrayList.add(new BasicNameValuePair("guid", (String)localObject2));
        }
        if (!TextUtils.isEmpty(((BNRouteReportModel.CurrentRouteReportModel)localObject1).content)) {
          localArrayList.add(new BasicNameValuePair("content", getUTF8Encode(((BNRouteReportModel.CurrentRouteReportModel)localObject1).content)));
        }
        if (!TextUtils.isEmpty(((BNRouteReportModel.CurrentRouteReportModel)localObject1).photoPicPath))
        {
          this.model.setUploadingImgFilePath(((BNRouteReportModel.CurrentRouteReportModel)localObject1).photoPicPath);
          localBNHttpParams.postFileMap.put("pic", new File(((BNRouteReportModel.CurrentRouteReportModel)localObject1).photoPicPath));
        }
        if (!TextUtils.isEmpty(((BNRouteReportModel.CurrentRouteReportModel)localObject1).voicePath))
        {
          this.model.setUploadingVoiceFilePath(((BNRouteReportModel.CurrentRouteReportModel)localObject1).voicePath);
          localBNHttpParams.postFileMap.put("voice", new File(((BNRouteReportModel.CurrentRouteReportModel)localObject1).voicePath));
        }
        localArrayList.add(new BasicNameValuePair("os", "0"));
        localArrayList.add(new BasicNameValuePair("osv", PackageUtil.strOSVersion));
        localArrayList.add(new BasicNameValuePair("sv", PackageUtil.strSoftWareVer));
        localArrayList.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
        localArrayList.add(new BasicNameValuePair("name", getUTF8Encode(((BNRouteReportModel.CurrentRouteReportModel)localObject1).roadName)));
        localObject1 = new Bundle();
        BNRoutePlaner.getInstance().getRoutePlanSessionIDAndMrsl((Bundle)localObject1);
        localObject2 = ((Bundle)localObject1).getString("session");
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          continue;
        }
        localArrayList.add(new BasicNameValuePair("session_id", (String)localObject2));
      }
      catch (Exception localException)
      {
        Object localObject2;
        String str;
        LogUtil.e(TAG, "getMultipartEntity: --> UnsupportedEncodingException");
        break label1313;
        logLocalDataError("sessionId: " + (String)localObject2);
        continue;
        logLocalDataError("mrsl: " + (String)localObject1);
        continue;
        logLocalDataError("startNode: lonE6: " + ((RoutePlanNode)localObject1).getLongitudeE6() + ", latE6: " + ((RoutePlanNode)localObject1).getLatitudeE6());
        continue;
        logLocalDataError("startNode: lonE6: " + ((RoutePlanNode)localObject1).getLongitudeE6() + ", latE6: " + ((RoutePlanNode)localObject1).getLatitudeE6());
        continue;
      }
      if (bool)
      {
        localObject1 = ((Bundle)localObject1).getString("mrsl");
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localArrayList.add(new BasicNameValuePair("mrsl", (String)localObject1));
        }
      }
      else
      {
        localObject2 = (RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel");
        localObject1 = ((RoutePlanModel)localObject2).getStartNode();
        if (localObject1 != null)
        {
          str = ll2mcStr(((RoutePlanNode)localObject1).getLongitudeE6() / 100000.0F, ((RoutePlanNode)localObject1).getLatitudeE6() / 100000.0F);
          if (str == null) {
            continue;
          }
          localArrayList.add(new BasicNameValuePair("from_point", str));
          str = ((RoutePlanNode)localObject1).getName();
          if (str != null) {
            localArrayList.add(new BasicNameValuePair("from_name", getUTF8Encode(str)));
          }
          str = ((RoutePlanNode)localObject1).getUID();
          if (str != null) {
            localArrayList.add(new BasicNameValuePair("from_uid", str));
          }
        }
        localObject2 = ((RoutePlanModel)localObject2).getEndNode();
        if (localObject2 != null)
        {
          str = ll2mcStr(((RoutePlanNode)localObject2).getLongitudeE6() / 100000.0F, ((RoutePlanNode)localObject2).getLatitudeE6() / 100000.0F);
          if (str == null) {
            continue;
          }
          localArrayList.add(new BasicNameValuePair("to_point", str));
          localObject1 = ((RoutePlanNode)localObject2).getName();
          if (localObject1 != null) {
            localArrayList.add(new BasicNameValuePair("to_name", getUTF8Encode((String)localObject1)));
          }
          localObject1 = ((RoutePlanNode)localObject2).getUID();
          if (localObject1 != null) {
            localArrayList.add(new BasicNameValuePair("to_uid", (String)localObject1));
          }
        }
        i = GeoLocateModel.getInstance().getCurrentCityId();
        if (i != Integer.MIN_VALUE) {
          localArrayList.add(new BasicNameValuePair("cityid", "" + i));
        }
        localObject1 = GeoLocateModel.getInstance().getCurCityName();
        if (localObject1 != null) {
          localArrayList.add(new BasicNameValuePair("city_name", getUTF8Encode((String)localObject1)));
        }
        localObject1 = CloudConfigObtainManager.SortSequenceWithAscendingOder(localArrayList);
        localArrayList.add(new BasicNameValuePair("sign", JNITrajectoryControl.sInstance.getUrlParamsSign((String)localObject1) + ""));
        localObject1 = BNHttpCenterHelper.formatParams(localArrayList);
        BNHttpCenter.getInstance().post(HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_ROUTE_REPORT_UPLOAD), (HashMap)localObject1, new BNHttpTextResponseHandler()
        {
          public void onFailure(int paramAnonymousInt, String paramAnonymousString, Throwable paramAnonymousThrowable)
          {
            LogUtil.e(BNRouteReportController.TAG, "handleMessage: Error --> " + paramAnonymousString);
            if (BNRouteReportController.this.getActivity() != null) {
              TipTool.onCreateToastDialog(BNRouteReportController.this.getActivity(), JarUtils.getResources().getString(1711670288));
            }
            try
            {
              if (BNRouteReportController.this.model.getUploadingVoiceFilePath() != null)
              {
                FileUtils.del(BNRouteReportController.this.model.getUploadingVoiceFilePath());
                BNRouteReportController.this.model.setUploadingVoiceFilePath(null);
              }
              try
              {
                if (BNRouteReportController.this.model.getUploadingImgFilePath() != null)
                {
                  FileUtils.del(BNRouteReportController.this.model.getUploadingImgFilePath());
                  BNRouteReportController.this.model.setUploadingImgFilePath(null);
                }
                BNRouteReportController.access$402(BNRouteReportController.this, false);
                return;
              }
              catch (Throwable paramAnonymousString)
              {
                for (;;) {}
              }
            }
            catch (Throwable paramAnonymousString)
            {
              for (;;) {}
            }
          }
          
          public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
          {
            try
            {
              paramAnonymousString = new JSONObject(paramAnonymousString);
              LogUtil.e(BNRouteReportController.TAG, "handleMessage: ret --> " + paramAnonymousString);
              if (paramAnonymousString.getInt("errno") == 0)
              {
                paramAnonymousString = paramAnonymousString.getJSONObject("data");
                if (BNRouteReportController.this.getActivity() != null) {
                  TipTool.onCreateToastDialog(BNRouteReportController.this.getActivity(), paramAnonymousString.getString("tips"));
                }
              }
            }
            catch (JSONException paramAnonymousString)
            {
              try
              {
                for (;;)
                {
                  if (BNRouteReportController.this.model.getUploadingVoiceFilePath() != null)
                  {
                    FileUtils.del(BNRouteReportController.this.model.getUploadingVoiceFilePath());
                    BNRouteReportController.this.model.setUploadingVoiceFilePath(null);
                  }
                  try
                  {
                    if (BNRouteReportController.this.model.getUploadingImgFilePath() != null)
                    {
                      FileUtils.del(BNRouteReportController.this.model.getUploadingImgFilePath());
                      BNRouteReportController.this.model.setUploadingImgFilePath(null);
                    }
                    BNRouteReportController.access$402(BNRouteReportController.this, false);
                    return;
                    if (BNRouteReportController.this.getActivity() == null) {
                      continue;
                    }
                    TipTool.onCreateToastDialog(BNRouteReportController.this.getActivity(), JarUtils.getResources().getString(1711670287));
                    continue;
                    paramAnonymousString = paramAnonymousString;
                    LogUtil.e(BNRouteReportController.TAG, "handleMessage: --> JSONException");
                    if (BNRouteReportController.this.getActivity() == null) {
                      continue;
                    }
                    TipTool.onCreateToastDialog(BNRouteReportController.this.getActivity(), JarUtils.getResources().getString(1711670287));
                  }
                  catch (Throwable paramAnonymousString)
                  {
                    for (;;) {}
                  }
                }
              }
              catch (Throwable paramAnonymousString)
              {
                for (;;) {}
              }
            }
          }
        }, localBNHttpParams);
        LogUtil.e(TAG, "getMultipartEntity: params --> " + localArrayList.toString());
        break label1313;
        logLocalDataError("guid: " + (String)localObject2);
        continue;
      }
      label1313:
      return true;
      label1315:
      int i = 4;
    }
  }
  
  public static abstract interface BNRouteReportCallback
  {
    public static final int TYPE_AUDIO_AUTH_REQUEST = 2;
    public static final int TYPE_BACK = 1;
    public static final int TYPE_HIDE_PROMPT_DIALOG = 5;
    public static final int TYPE_PIN_ANIM_DOWN = 10;
    public static final int TYPE_PIN_ANIM_UP = 9;
    public static final int TYPE_RESET_PROMPT_DIALOG = 8;
    public static final int TYPE_SCROLL_UP = 11;
    public static final int TYPE_SET_NEED_PROJECTION = 6;
    public static final int TYPE_SET_NO_PROJECTION = 7;
    public static final int TYPE_SET_PROMPT_DIALOG_STATE_ADDR = 12;
    public static final int TYPE_SHOW_PROMPT_DIALOG = 4;
    public static final int TYPE_SUBMIT = 3;
    
    public abstract void onAction(int paramInt);
  }
  
  private static class LazyLoader
  {
    private static BNRouteReportController instance = new BNRouteReportController(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/routereport/BNRouteReportController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */