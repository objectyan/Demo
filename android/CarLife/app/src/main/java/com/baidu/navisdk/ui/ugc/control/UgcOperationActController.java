package com.baidu.navisdk.ui.ugc.control;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.base.MsgHandler;
import com.baidu.navisdk.jni.nativeif.JNIBaseMap;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import com.baidu.navisdk.logic.CommandCenter;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc;
import com.baidu.navisdk.logic.commandparser.CmdGeneralHttpRequestFunc.Callback;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.module.cloudconfig.CloudConfigObtainManager;
import com.baidu.navisdk.ui.ugc.model.UgcOperationalActModel;
import com.baidu.navisdk.ui.ugc.model.UgcOperationalActModel.UgcReportSerInfoPackage;
import com.baidu.navisdk.ui.ugc.util.PhotoCaptureUtils;
import com.baidu.navisdk.util.cache.ImageTools;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PackageUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import com.baidu.navisdk.util.drawable.UrlDrawableContainIView;
import com.baidu.navisdk.util.http.HttpURLManager;
import com.baidu.navisdk.util.http.HttpURLManager.ULRParam;
import com.baidu.navisdk.util.http.center.BNHttpCenter;
import com.baidu.navisdk.util.http.center.BNHttpCenterHelper;
import com.baidu.navisdk.util.http.center.BNHttpParams;
import com.baidu.navisdk.util.http.center.BNHttpTextResponseHandler;
import com.baidu.navisdk.util.http.center.IBNHttpCenter;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.vi.VMsgDispatcher;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;

public class UgcOperationActController
{
  public static final int MSG_UGCOPERATIONACT_DATA_REPORT_RET = 1501;
  public static final int MSG_UGCOPERATIONACT_DATA_REQUEST_RET = 1500;
  private static final int MSG_UGC_EVENT_COUNTS_RET = 1502;
  private static final int SCREEN_SHOT_HEIGH = 150;
  public static final String SCREEN_SHOT_TEMP_FILE_PATH = SysOSAPI.getInstance().GetSDCardCachePath() + "/ugc_navi_screen_shot_temp.jpg";
  private static final int SCREEN_SHOT_WIDTH = 200;
  private static final String TAG = UgcOperationActController.class.getName();
  public static UgcOperationActController instance;
  private LinkedList<IViewPackage> CacheIamgeList = new LinkedList();
  public boolean isUgcUploading = false;
  private Handler mImageHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage == null) {}
      while (paramAnonymousMessage.arg1 != 0) {
        return;
      }
      try
      {
        Bitmap localBitmap = (Bitmap)((RspData)paramAnonymousMessage.obj).mReq.getObj();
        UgcOperationActController.this.updateUgcImageView(paramAnonymousMessage.what, localBitmap);
        UgcOperationalActModel.getInstance().setUgcBitMapWithType(paramAnonymousMessage.what, localBitmap);
        return;
      }
      catch (Exception paramAnonymousMessage)
      {
        LogUtil.e(UgcOperationActController.TAG, paramAnonymousMessage.toString());
      }
    }
  };
  private JNIBaseMap mJniBaseMap = null;
  private MsgHandler mMsgHandler = new MsgHandler(Looper.getMainLooper())
  {
    public void careAbout()
    {
      observe(4616);
    }
    
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 4616) {}
      try
      {
        if (UgcOperationActController.this.mJniBaseMap != null)
        {
          paramAnonymousMessage = new Bundle();
          UgcOperationActController.this.mJniBaseMap.getScreenShotImage(paramAnonymousMessage);
          int i = paramAnonymousMessage.getInt("unImageWidth");
          int j = paramAnonymousMessage.getInt("unImageHeight");
          paramAnonymousMessage = Bitmap.createBitmap(paramAnonymousMessage.getIntArray("pbtImageData"), i, j, Bitmap.Config.ARGB_8888);
          if (paramAnonymousMessage != null)
          {
            paramAnonymousMessage = PhotoCaptureUtils.compress(paramAnonymousMessage, 600, 800);
            if ((paramAnonymousMessage != null) && (PhotoCaptureUtils.getInstance().setBitmapToFile(UgcOperationActController.SCREEN_SHOT_TEMP_FILE_PATH, paramAnonymousMessage)))
            {
              UgcOperationalActModel.getInstance().mUgcReportSerInfoPackage.screenshotPicPath = UgcOperationActController.SCREEN_SHOT_TEMP_FILE_PATH;
              LogUtil.e(UgcOperationActController.TAG + "msg", "has map bitmap");
            }
          }
        }
      }
      catch (Exception paramAnonymousMessage)
      {
        for (;;)
        {
          paramAnonymousMessage.printStackTrace();
        }
      }
      UgcOperationActController.getInstance().ugcInfoReportUpLoad();
      if (UgcOperationActController.this.mUgcInfoReportUpLoadResultCallBack != null) {
        UgcOperationActController.this.mUgcInfoReportUpLoadResultCallBack.onUgcFinish();
      }
    }
  };
  private UgcInfoReportUpLoadResultCallBack mUgcInfoReportUpLoadResultCallBack = null;
  
  private UgcOperationActController()
  {
    VMsgDispatcher.registerMsgHandler(this.mMsgHandler);
  }
  
  private CookieStore getCookieStore()
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
  
  private int getCurrentCityId()
  {
    int i = -1;
    DistrictInfo localDistrictInfo = GeoLocateModel.getInstance().getCurrentDistrict();
    if (localDistrictInfo != null) {
      i = localDistrictInfo.mId;
    }
    return i;
  }
  
  public static UgcOperationActController getInstance()
  {
    if (instance == null) {
      instance = new UgcOperationActController();
    }
    return instance;
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
  
  private List<NameValuePair> getUgcReportCountsReqParam()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      StringBuffer localStringBuffer;
      String str;
      localException1.printStackTrace();
    }
    catch (Exception localException1)
    {
      try
      {
        localStringBuffer = new StringBuffer();
        str = PackageUtil.getCuid() + "";
        localArrayList.add(new BasicNameValuePair("cuid", str));
        localStringBuffer.append("cuid=" + URLEncoder.encode(str, "utf-8"));
        str = PackageUtil.getVersionName() + "";
        localArrayList.add(new BasicNameValuePair("sv", str));
        localStringBuffer.append("&sv=" + URLEncoder.encode(str, "utf-8"));
        str = PackageUtil.strOSVersion + "";
        localArrayList.add(new BasicNameValuePair("osv", str));
        localStringBuffer.append("&osv=" + URLEncoder.encode(str, "utf-8"));
        str = CloudConfigObtainManager.SortSequenceWithAscendingOder(localArrayList);
        LogUtil.e(TAG + "unsign str:", str);
        str = JNITrajectoryControl.sInstance.getUrlParamsSign(str) + "";
        LogUtil.e(TAG + "hassign sign:", str);
        localArrayList.add(new BasicNameValuePair("sign", str));
        localStringBuffer.append("&sign=" + URLEncoder.encode(str, "utf-8"));
        LogUtil.e(TAG + "params:", localStringBuffer.toString());
        return localArrayList;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      localException1 = localException1;
    }
    return null;
  }
  
  public String convertStreamToString(InputStream paramInputStream)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str + "/n");
      }
      try
      {
        paramInputStream.close();
        throw ((Throwable)localObject);
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          paramInputStream.printStackTrace();
        }
      }
    }
    catch (IOException localIOException)
    {
      localIOException = localIOException;
      localIOException.printStackTrace();
      try
      {
        paramInputStream.close();
        for (;;)
        {
          return localStringBuilder.toString();
          try
          {
            paramInputStream.close();
          }
          catch (IOException paramInputStream)
          {
            paramInputStream.printStackTrace();
          }
        }
      }
      catch (IOException paramInputStream)
      {
        for (;;)
        {
          paramInputStream.printStackTrace();
        }
      }
    }
    finally {}
  }
  
  public void destroy()
  {
    instance = null;
    this.mJniBaseMap = null;
    VMsgDispatcher.unregisterMsgHandler(this.mMsgHandler);
  }
  
  public String getShowRCEventListUrl()
  {
    String str1 = PackageUtil.getCuid();
    String str2 = PackageUtil.strOSVersion;
    Object localObject = PackageUtil.strSoftWareVer;
    localObject = new ArrayList();
    StringBuffer localStringBuffer = new StringBuffer();
    try
    {
      ((List)localObject).add(new BasicNameValuePair("cuid", str1));
      localStringBuffer.append("cuid=" + URLEncoder.encode(str1, "utf-8"));
      ((List)localObject).add(new BasicNameValuePair("os", "0"));
      localStringBuffer.append("&os=" + URLEncoder.encode("0", "utf-8"));
      ((List)localObject).add(new BasicNameValuePair("osv", str2));
      localStringBuffer.append("&osv=" + URLEncoder.encode(str2, "utf-8"));
      ((List)localObject).add(new BasicNameValuePair("sv", str2));
      localStringBuffer.append("&sv=" + URLEncoder.encode(str2, "utf-8"));
      str1 = JNITrajectoryControl.sInstance.getUrlParamsSign(CloudConfigObtainManager.SortSequenceWithAscendingOder((List)localObject)) + "";
      ((List)localObject).add(new BasicNameValuePair("sign", str1));
      localStringBuffer.append("&sign=" + URLEncoder.encode(str1, "utf-8"));
      str1 = HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_UGC_RCEVENT_LIST_SHOW) + "?" + localStringBuffer.toString();
      LogUtil.e(TAG + "getShowRCEventListUrl:", str1);
      return str1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public void getUgcReportCounts(Handler paramHandler, int paramInt)
  {
    if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext())) {
      return;
    }
    paramHandler = new ReqData("cmd.general.httprequest.func", 7, paramHandler, paramInt, 10000);
    paramHandler.mCookieStore = getCookieStore();
    CmdGeneralHttpRequestFunc.addFunc(paramHandler, new CmdGeneralHttpRequestFunc.Callback()
    {
      public List<NameValuePair> getRequestParams()
      {
        return UgcOperationActController.this.getUgcReportCountsReqParam();
      }
      
      public int getRequestType()
      {
        return 1;
      }
      
      public String getUrl()
      {
        return HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_UGC_RCEVENT_COUNTS);
      }
      
      public boolean parseResponseJSON(JSONObject paramAnonymousJSONObject)
      {
        return true;
      }
      
      public void responseImage(byte[] paramAnonymousArrayOfByte) {}
    });
    CommandCenter.getInstance().sendRequest(paramHandler);
  }
  
  public void registerUgcImageView(int paramInt, ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    if (this.CacheIamgeList == null) {
      this.CacheIamgeList = new LinkedList();
    }
    this.CacheIamgeList.add(new IViewPackage(paramInt, paramImageView));
  }
  
  public void requestBitMapFromHttp(int paramInt)
  {
    final String str = UgcOperationalActModel.getInstance().getUrlByType(paramInt);
    if (str == null) {
      return;
    }
    final ReqData localReqData = new ReqData("cmd.general.httprequest.func", 7, this.mImageHandler, paramInt, 10000);
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
        return str;
      }
      
      public boolean parseResponseJSON(JSONObject paramAnonymousJSONObject)
      {
        return true;
      }
      
      public void responseImage(byte[] paramAnonymousArrayOfByte)
      {
        if (paramAnonymousArrayOfByte != null)
        {
          paramAnonymousArrayOfByte = BitmapFactory.decodeByteArray(paramAnonymousArrayOfByte, 0, paramAnonymousArrayOfByte.length);
          localReqData.setObj(paramAnonymousArrayOfByte);
        }
      }
    });
    CommandCenter.getInstance().sendRequest(localReqData);
  }
  
  public boolean setScreenShotParam(int paramInt)
  {
    if (this.mJniBaseMap == null) {
      this.mJniBaseMap = new JNIBaseMap();
    }
    ScreenUtil localScreenUtil = ScreenUtil.getInstance();
    if (paramInt == 1) {
      paramInt = localScreenUtil.getWidthPixels();
    }
    for (int i = localScreenUtil.getHeightPixels() - ScreenUtil.getInstance().dip2px(120);; i = localScreenUtil.getHeightPixels())
    {
      return new JNIBaseMap().setScreenShotParam(4, paramInt, i, 0L, 0L, 0);
      paramInt = localScreenUtil.getWidthPixels() * 2 / 3;
    }
  }
  
  public void setUgcInfoReportUpLoadResultCallBack(UgcInfoReportUpLoadResultCallBack paramUgcInfoReportUpLoadResultCallBack)
  {
    this.mUgcInfoReportUpLoadResultCallBack = paramUgcInfoReportUpLoadResultCallBack;
  }
  
  public boolean ugcInfoReportUpLoad()
  {
    boolean bool = true;
    if (this.isUgcUploading) {
      bool = false;
    }
    BNHttpParams localBNHttpParams;
    Object localObject;
    do
    {
      return bool;
      this.isUgcUploading = true;
      localBNHttpParams = new BNHttpParams();
      localBNHttpParams.isAsync = true;
      localBNHttpParams.postFileMap = new HashMap();
      localObject = UgcOperationalActModel.getInstance().mUgcReportSerInfoPackage;
    } while (localObject == null);
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(new BasicNameValuePair("cuid", PackageUtil.getCuid()));
      localArrayList.add(new BasicNameValuePair("upload_type", ((UgcOperationalActModel.UgcReportSerInfoPackage)localObject).uploadType));
      localArrayList.add(new BasicNameValuePair("sid", "1"));
      localArrayList.add(new BasicNameValuePair("os", "0"));
      localArrayList.add(new BasicNameValuePair("osv", PackageUtil.strOSVersion));
      localArrayList.add(new BasicNameValuePair("sv", PackageUtil.strSoftWareVer));
      localArrayList.add(new BasicNameValuePair("cityCode", getCurrentCityId() + ""));
      localArrayList.add(new BasicNameValuePair("cityName", getUTF8Encode(GeoLocateModel.getInstance().getCurCityName())));
      localArrayList.add(new BasicNameValuePair("from_point", ((UgcOperationalActModel.UgcReportSerInfoPackage)localObject).fromPoint));
      localArrayList.add(new BasicNameValuePair("from_uid", ((UgcOperationalActModel.UgcReportSerInfoPackage)localObject).fromUid));
      localArrayList.add(new BasicNameValuePair("from_name", getUTF8Encode(((UgcOperationalActModel.UgcReportSerInfoPackage)localObject).fromName)));
      localArrayList.add(new BasicNameValuePair("to_point", ((UgcOperationalActModel.UgcReportSerInfoPackage)localObject).toPoint));
      localArrayList.add(new BasicNameValuePair("to_uid", ((UgcOperationalActModel.UgcReportSerInfoPackage)localObject).toUid));
      localArrayList.add(new BasicNameValuePair("to_name", getUTF8Encode(((UgcOperationalActModel.UgcReportSerInfoPackage)localObject).toName)));
      localArrayList.add(new BasicNameValuePair("business_trigger", ((UgcOperationalActModel.UgcReportSerInfoPackage)localObject).business_trigger));
      localArrayList.add(new BasicNameValuePair("name", getUTF8Encode(((UgcOperationalActModel.UgcReportSerInfoPackage)localObject).Name)));
      localArrayList.add(new BasicNameValuePair("parent_type", ((UgcOperationalActModel.UgcReportSerInfoPackage)localObject).parentType));
      localArrayList.add(new BasicNameValuePair("sub_type", ((UgcOperationalActModel.UgcReportSerInfoPackage)localObject).subType));
      localArrayList.add(new BasicNameValuePair("content", getUTF8Encode(((UgcOperationalActModel.UgcReportSerInfoPackage)localObject).content)));
      if ((((UgcOperationalActModel.UgcReportSerInfoPackage)localObject).screenshotPicPath != null) && (!((UgcOperationalActModel.UgcReportSerInfoPackage)localObject).screenshotPicPath.trim().equals(""))) {
        localBNHttpParams.postFileMap.put("screenshot_pic", new File(((UgcOperationalActModel.UgcReportSerInfoPackage)localObject).screenshotPicPath));
      }
      if ((((UgcOperationalActModel.UgcReportSerInfoPackage)localObject).photoPicPath != null) && (!((UgcOperationalActModel.UgcReportSerInfoPackage)localObject).photoPicPath.trim().equals(""))) {
        localBNHttpParams.postFileMap.put("pic", new File(((UgcOperationalActModel.UgcReportSerInfoPackage)localObject).photoPicPath));
      }
      if ((((UgcOperationalActModel.UgcReportSerInfoPackage)localObject).voicePath != null) && (!((UgcOperationalActModel.UgcReportSerInfoPackage)localObject).voicePath.trim().equals(""))) {
        localBNHttpParams.postFileMap.put("voice", new File(((UgcOperationalActModel.UgcReportSerInfoPackage)localObject).voicePath));
      }
      localArrayList.add(new BasicNameValuePair("point", ((UgcOperationalActModel.UgcReportSerInfoPackage)localObject).point));
      localArrayList.add(new BasicNameValuePair("photo_point", ((UgcOperationalActModel.UgcReportSerInfoPackage)localObject).photoPoint));
      localArrayList.add(new BasicNameValuePair("user_point", ((UgcOperationalActModel.UgcReportSerInfoPackage)localObject).userPoint));
      localArrayList.add(new BasicNameValuePair("session_id", ((UgcOperationalActModel.UgcReportSerInfoPackage)localObject).sessionId));
      localObject = CloudConfigObtainManager.SortSequenceWithAscendingOder(localArrayList);
      LogUtil.e(TAG + "unsign str:", (String)localObject);
      localObject = JNITrajectoryControl.sInstance.getUrlParamsSign((String)localObject) + "";
      LogUtil.e(TAG + "hassign sign:", (String)localObject);
      localArrayList.add(new BasicNameValuePair("sign", (String)localObject));
      localObject = BNHttpCenterHelper.formatParams(localArrayList);
      BNHttpCenter.getInstance().post(HttpURLManager.getInstance().getUsedUrl(HttpURLManager.ULRParam.URL_UGC_OPER_INFO_REPORT), (HashMap)localObject, new BNHttpTextResponseHandler()
      {
        public void onFailure(int paramAnonymousInt, String paramAnonymousString, Throwable paramAnonymousThrowable)
        {
          if (UgcOperationActController.this.mUgcInfoReportUpLoadResultCallBack != null) {
            UgcOperationActController.this.mUgcInfoReportUpLoadResultCallBack.onUgcInfoReportUpLoadFail(JarUtils.getResources().getString(1711670288));
          }
          UgcOperationActController.this.isUgcUploading = false;
        }
        
        public void onSuccess(int paramAnonymousInt, String paramAnonymousString)
        {
          LogUtil.e(UgcOperationActController.TAG + "mUgcRportHandler msg:", paramAnonymousString);
          try
          {
            paramAnonymousString = new JSONObject(paramAnonymousString);
            if (paramAnonymousString.getInt("errno") == 0)
            {
              paramAnonymousString = paramAnonymousString.getJSONObject("data");
              if (UgcOperationActController.this.mUgcInfoReportUpLoadResultCallBack != null) {
                UgcOperationActController.this.mUgcInfoReportUpLoadResultCallBack.onUgcInfoReportUpLoadSuccess(paramAnonymousString);
              }
            }
            for (;;)
            {
              UgcOperationActController.this.isUgcUploading = false;
              return;
              if (UgcOperationActController.this.mUgcInfoReportUpLoadResultCallBack != null) {
                UgcOperationActController.this.mUgcInfoReportUpLoadResultCallBack.onUgcInfoReportUpLoadFail(JarUtils.getResources().getString(1711670287));
              }
            }
          }
          catch (Exception paramAnonymousString)
          {
            for (;;)
            {
              paramAnonymousString.printStackTrace();
              if (UgcOperationActController.this.mUgcInfoReportUpLoadResultCallBack != null) {
                UgcOperationActController.this.mUgcInfoReportUpLoadResultCallBack.onUgcInfoReportUpLoadFail(JarUtils.getResources().getString(1711670287));
              }
            }
          }
        }
      }, localBNHttpParams);
      LogUtil.e(TAG + "_getMultipartEntity():", localArrayList.toString());
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return true;
  }
  
  public void unRegisterAllUgcImageView()
  {
    if (this.CacheIamgeList != null) {
      this.CacheIamgeList.clear();
    }
  }
  
  public void unRegisterUgcImageView(int paramInt, ImageView paramImageView)
  {
    if (this.CacheIamgeList == null) {}
    for (;;)
    {
      return;
      int j;
      for (int i = 0; i < this.CacheIamgeList.size(); i = j + 1)
      {
        j = i;
        if (((IViewPackage)this.CacheIamgeList.get(i)).equals(paramInt, paramImageView))
        {
          this.CacheIamgeList.remove(i);
          j = i - 1;
        }
      }
    }
  }
  
  public void updateImageViewBGroundSrc(int paramInt, ImageView paramImageView)
  {
    updateImageViewBGroundSrc(paramInt, paramImageView, null);
  }
  
  public void updateImageViewBGroundSrc(int paramInt, ImageView paramImageView, Handler paramHandler)
  {
    if (paramImageView == null) {
      return;
    }
    LogUtil.e("caizhirui:bitmap_type", paramInt + "");
    if (UgcOperationalActModel.getInstance().getUgcBitMapByType(paramInt) != null)
    {
      paramImageView.setBackgroundDrawable(new BitmapDrawable(ImageTools.getBitmapFromResId(1711408123)));
      return;
    }
    UrlDrawableContainIView.getDrawable(UgcOperationalActModel.getInstance().getUrlByType(paramInt), UgcOperationalActModel.getInstance().getUgcDrawableIdByType(paramInt), paramImageView, paramHandler);
  }
  
  public void updateUgcImageView(int paramInt, Bitmap paramBitmap)
  {
    if ((paramBitmap == null) || (this.CacheIamgeList == null)) {}
    for (;;)
    {
      return;
      int j;
      for (int i = 0; i < this.CacheIamgeList.size(); i = j + 1)
      {
        j = i;
        if (((IViewPackage)this.CacheIamgeList.get(i)).update(paramInt, paramBitmap))
        {
          this.CacheIamgeList.remove(i);
          j = i - 1;
        }
      }
    }
  }
  
  public static class IViewPackage
  {
    ImageView mImageView;
    int type;
    
    public IViewPackage(int paramInt, ImageView paramImageView)
    {
      this.type = paramInt;
      this.mImageView = paramImageView;
    }
    
    public boolean equals(int paramInt, ImageView paramImageView)
    {
      return (this.type == paramInt) && (this.mImageView == paramImageView);
    }
    
    public boolean update(int paramInt, Bitmap paramBitmap)
    {
      if (this.type != paramInt) {
        return false;
      }
      if ((this.mImageView != null) && (paramBitmap != null))
      {
        this.mImageView.setBackgroundDrawable(null);
        this.mImageView.setImageBitmap(paramBitmap);
      }
      return true;
    }
  }
  
  public static abstract interface UgcInfoReportUpLoadResultCallBack
  {
    public abstract void onUgcFinish();
    
    public abstract void onUgcInfoReportUpLoadFail(String paramString);
    
    public abstract void onUgcInfoReportUpLoadSuccess(JSONObject paramJSONObject);
  }
  
  private static abstract interface UgcPostHttpConstans
  {
    public static final String UGC_POST_HTTP_PARAM_BDUSS = "bduss";
    public static final String UGC_POST_HTTP_PARAM_BUSINESS_TRIGGER = "business_trigger";
    public static final String UGC_POST_HTTP_PARAM_CITYCODE = "cityCode";
    public static final String UGC_POST_HTTP_PARAM_CITYNAME = "cityName";
    public static final String UGC_POST_HTTP_PARAM_CONTENT = "content";
    public static final String UGC_POST_HTTP_PARAM_CUID = "cuid";
    public static final String UGC_POST_HTTP_PARAM_FROM_NAME = "from_name";
    public static final String UGC_POST_HTTP_PARAM_FROM_POINT = "from_point";
    public static final String UGC_POST_HTTP_PARAM_FROM_UID = "from_uid";
    public static final String UGC_POST_HTTP_PARAM_NAME = "name";
    public static final String UGC_POST_HTTP_PARAM_OS = "os";
    public static final String UGC_POST_HTTP_PARAM_OSV = "osv";
    public static final String UGC_POST_HTTP_PARAM_PARENT_TYPE = "parent_type";
    public static final String UGC_POST_HTTP_PARAM_PHOTO_POINT = "photo_point";
    public static final String UGC_POST_HTTP_PARAM_PIC = "pic";
    public static final String UGC_POST_HTTP_PARAM_POINT = "point";
    public static final String UGC_POST_HTTP_PARAM_SCREENSHOT_PIC = "screenshot_pic";
    public static final String UGC_POST_HTTP_PARAM_SESSION_ID = "session_id";
    public static final String UGC_POST_HTTP_PARAM_SID = "sid";
    public static final String UGC_POST_HTTP_PARAM_SIGN = "sign";
    public static final String UGC_POST_HTTP_PARAM_SUB_TYPE = "sub_type";
    public static final String UGC_POST_HTTP_PARAM_SV = "sv";
    public static final String UGC_POST_HTTP_PARAM_TO_NAME = "to_name";
    public static final String UGC_POST_HTTP_PARAM_TO_POINT = "to_point";
    public static final String UGC_POST_HTTP_PARAM_TO_UID = "to_uid";
    public static final String UGC_POST_HTTP_PARAM_UPLOAD_TYPE = "upload_type";
    public static final String UGC_POST_HTTP_PARAM_USER_POINT = "user_point";
    public static final String UGC_POST_HTTP_PARAM_VOICE = "voice";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/ugc/control/UgcOperationActController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */