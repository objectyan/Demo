package com.baidu.navisdk.module.ugc.ui.inmap.sub;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider.UgcLayout;
import com.baidu.navisdk.module.ugc.data.datastatus.UgcReportInfoUploadPackage;
import com.baidu.navisdk.module.ugc.https.UgcHttps;
import com.baidu.navisdk.module.ugc.https.UgcHttps.UgcHttpsResultCallBack;
import com.baidu.navisdk.module.ugc.https.UgcHttpsUtils;
import com.baidu.navisdk.module.ugc.ui.SubContentContract.View;
import com.baidu.navisdk.module.ugc.utils.UgcImageLoaderUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.FileUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import java.io.IOException;
import java.text.NumberFormat;
import org.json.JSONArray;
import org.json.JSONObject;

public class UgcReportMapSubDetailPresenter
  extends UgcReportMapSubDetailContract.Presenter
{
  private static final int BNUGCUploadTypeDanger = 7;
  private static final int BNUGCUploadTypeElectronicEye = 6;
  private static final int BNUGCUploadTypeJam = 0;
  private static final int BNUGCUploadTypePoliceman = 8;
  private static final int BNUGCUploadTypeRoadAdd = 3;
  private static final int BNUGCUploadTypeRoadClosure = 4;
  private static final int BNUGCUploadTypeRoadConstruction = 2;
  private static final int BNUGCUploadTypeTrafficAccident = 1;
  private static final int BNUGCUploadTypeTrafficRegulations = 5;
  public static final int TYPE_GO_BACK = 2;
  public static final int TYPE_SET_HEIGHT = 1;
  private boolean hasInformComHeight = false;
  private boolean hasOnResume = false;
  private UgcImageLoaderUtils imageLoaderUtils;
  private Context mContext;
  private UgcReportMapSubDetailContract.View mRootView;
  private UgcDataProvider.UgcLayout mUgcLayout;
  private UgcSubDetailCallback mUgcReportCallback;
  private long st;
  
  public UgcReportMapSubDetailPresenter(Context paramContext, SubContentContract.View paramView, UgcDataProvider.UgcLayout paramUgcLayout, UgcSubDetailCallback paramUgcSubDetailCallback)
  {
    super(paramContext, paramView, paramUgcLayout);
    this.mRootView = ((UgcReportMapSubDetailContract.View)paramView);
    this.mContext = paramContext;
    this.mUgcReportCallback = paramUgcSubDetailCallback;
    this.imageLoaderUtils = new UgcImageLoaderUtils();
    this.mUgcLayout = paramUgcLayout;
    paramView.setPresenter(this);
    this.st = System.currentTimeMillis();
    if (this.infoPackage != null) {
      this.infoPackage.parentType = paramUgcLayout.getSubType();
    }
    UserOPController.getInstance().add("3.u.2", "1", null, null);
  }
  
  private void callbackMapInfo(UgcReportInfoUploadPackage paramUgcReportInfoUploadPackage, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      do
      {
        String str;
        try
        {
          localObject = Long.valueOf(paramJSONObject.getLong("event_id"));
          str = paramJSONObject.getString("tips");
          m = (int)(((Long)localObject).longValue() & 0xFFFFFFFFFFFFFFFF);
          n = (int)(((Long)localObject).longValue() >>> 32 & 0xFFFFFFFFFFFFFFFF);
          localJSONObject1 = new JSONObject();
          localJSONObject2 = new JSONObject();
          localJSONArray = new JSONArray();
          localObject = paramUgcReportInfoUploadPackage.point;
          paramJSONObject = (JSONObject)localObject;
          if (localObject != null) {
            continue;
          }
          paramJSONObject = paramUgcReportInfoUploadPackage.userPoint;
        }
        catch (Exception paramUgcReportInfoUploadPackage)
        {
          Object localObject;
          int m;
          int n;
          JSONObject localJSONObject1;
          JSONObject localJSONObject2;
          JSONArray localJSONArray;
          int i;
          int k;
          int j;
          paramUgcReportInfoUploadPackage.printStackTrace();
          return;
        }
        i = 0;
        k = 0;
        j = paramJSONObject.indexOf(",");
        if ((j <= 0) || (j >= paramJSONObject.length() - 1)) {
          break;
        }
        localObject = paramJSONObject.substring(0, j);
        paramJSONObject = paramJSONObject.substring(j + 1, paramJSONObject.length());
        try
        {
          j = (int)Double.parseDouble((String)localObject);
          i = j;
          double d = Double.parseDouble(paramJSONObject);
          k = (int)d;
          i = j;
        }
        catch (Exception paramJSONObject)
        {
          for (;;) {}
        }
        localJSONObject2.put("ptx", i);
        localJSONObject2.put("pty", k);
        localJSONObject2.put("st", this.st / 1000L);
        localJSONObject2.put("et", this.st / 1000L + 180L);
        localJSONObject2.put("huid", n);
        localJSONObject2.put("luid", m);
        localJSONObject2.put("type", convertNaviTypeToUploadType(paramUgcReportInfoUploadPackage.parentType));
        localJSONArray.put(localJSONObject2);
        localJSONObject1.put("content", localJSONArray);
        if ((str == null) || (str.trim().equals(""))) {
          TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "上报成功！");
        }
        for (;;)
        {
          LogUtil.e("callbackMapInfo:", localJSONObject1.toString());
          if (this.mUgcReportCallback == null) {
            break;
          }
          this.mUgcReportCallback.onUpLoadCompleted(localJSONObject1);
          return;
          TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), str);
        }
      } while (paramJSONObject != null);
    }
  }
  
  private int convertNaviTypeToUploadType(int paramInt)
  {
    switch (paramInt)
    {
    case 8: 
    default: 
      return 0;
    case 4: 
      return 0;
    case 5: 
      return 1;
    case 6: 
      return 2;
    case 1: 
      return 3;
    case 7: 
      return 4;
    case 2: 
      return 5;
    case 3: 
      return 6;
    case 10: 
      return 7;
    }
    return 8;
  }
  
  private String getCurrentLocationPoint()
  {
    Object localObject = BNLocationManagerProxy.getInstance().getCurLocation();
    String str2 = "";
    String str1 = str2;
    if (localObject != null)
    {
      ((LocData)localObject).toGeoPoint();
      localObject = CoordinateTransformUtil.LL2MC(((LocData)localObject).longitude, ((LocData)localObject).latitude);
      str1 = str2;
      if (localObject != null) {
        str1 = ((Bundle)localObject).getInt("MCx") + "," + ((Bundle)localObject).getInt("MCy");
      }
    }
    return str1;
  }
  
  private String getFormatDouble(Double paramDouble)
  {
    NumberFormat localNumberFormat = NumberFormat.getInstance();
    localNumberFormat.setGroupingUsed(false);
    return localNumberFormat.format(paramDouble);
  }
  
  private void showOriginPage()
  {
    if (this.mRootView != null) {
      this.mRootView.showOriginPage();
    }
  }
  
  public void finish()
  {
    if (this.mUgcReportCallback != null) {
      this.mUgcReportCallback.onBackBtnPress();
    }
  }
  
  public void getRubPointAdsorbInfo(double paramDouble1, double paramDouble2, UgcHttps.UgcHttpsResultCallBack paramUgcHttpsResultCallBack)
  {
    new UgcHttps().getRubPointAdsorbInfo(null, getFormatDouble(Double.valueOf(paramDouble1)) + "," + getFormatDouble(Double.valueOf(paramDouble2)), paramUgcHttpsResultCallBack, 0);
  }
  
  public void goback()
  {
    if (this.mUgcReportCallback != null) {
      this.mUgcReportCallback.commonCallback(2, null, null);
    }
  }
  
  public void gotoSelectorPointPage() {}
  
  public void hasShowOriginPage()
  {
    if (this.mUgcReportCallback != null) {
      this.mUgcReportCallback.gotoSubView();
    }
  }
  
  public void hasShowSelectorPointStatus()
  {
    if (this.mUgcReportCallback != null) {
      this.mUgcReportCallback.maxMapLevel();
    }
  }
  
  public void informComHeight()
  {
    if (this.hasInformComHeight) {}
    do
    {
      return;
      if ((this.mRootView != null) && (this.mRootView.getMapComPanelContainer() != null))
      {
        int i = this.mRootView.getMapComPanelContainer().getHeight();
        if (i != 0)
        {
          if (this.mUgcReportCallback != null) {
            this.mUgcReportCallback.commonCallback(1, Integer.valueOf(i), null);
          }
          this.hasInformComHeight = true;
        }
      }
    } while ((this.infoPackage == null) || ((this.infoPackage.parentType != 6) && (this.infoPackage.parentType != 7)));
    showSelectorPointStatus();
  }
  
  public void informRubPointAdsorb(String paramString1, final String paramString2)
  {
    new UgcHttps().getRubPointAdsorbInfo(null, paramString1, new UgcHttps.UgcHttpsResultCallBack()
    {
      public void onUgcInfoReportUpLoadFail(String paramAnonymousString)
      {
        UgcReportMapSubDetailPresenter.this.mRootView.showAddrInfoUpdate(paramString2, null);
      }
      
      public void onUgcInfoReportUpLoadSuccess(JSONObject paramAnonymousJSONObject)
      {
        try
        {
          String str1 = paramAnonymousJSONObject.getString("new_point");
          String str2 = paramAnonymousJSONObject.getString("address");
          paramAnonymousJSONObject = paramAnonymousJSONObject.getString("linkid");
          UgcReportMapSubDetailPresenter.this.infoPackage.point = str1;
          UgcReportMapSubDetailPresenter.this.infoPackage.linkid = paramAnonymousJSONObject;
          UgcReportMapSubDetailPresenter.this.mRootView.showAddrInfoUpdate(str2, null);
          return;
        }
        catch (Exception paramAnonymousJSONObject) {}
      }
    }, 0);
  }
  
  public boolean isRoadBuild()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.infoPackage != null) {
      if (this.infoPackage.parentType != 6)
      {
        bool1 = bool2;
        if (this.infoPackage.parentType != 7) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void onAddrInfoUpdate(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = "无名路";
    }
    if ((this.mRootView != null) && (this.mRootView.isSelectPointViewShowing())) {
      this.mRootView.showAddrInfoUpdate(str, paramString2);
    }
  }
  
  public boolean onBackPress()
  {
    if ((this.infoPackage != null) && ((this.infoPackage.parentType == 6) || (this.infoPackage.parentType == 7))) {}
    while (!this.mRootView.isSelectPointViewShowing()) {
      return false;
    }
    showOriginPage();
    return true;
  }
  
  public void onConfirm(int paramInt, String paramString1, Double paramDouble1, Double paramDouble2, String paramString2)
  {
    if (this.infoPackage != null)
    {
      this.infoPackage.point = (paramDouble1 + "," + paramDouble2);
      this.infoPackage.name = paramString2;
      this.infoPackage.cityId = paramInt;
      this.infoPackage.cityName = paramString1;
    }
    if (this.mRootView != null)
    {
      this.mRootView.showAddrInfoUpdate(paramString2, null);
      showOriginPage();
    }
  }
  
  public void onDestroy() {}
  
  public void onPinUp(boolean paramBoolean)
  {
    showSelectorPointStatus();
  }
  
  public void onResume()
  {
    if (this.hasOnResume) {
      return;
    }
    this.hasOnResume = true;
  }
  
  public void setLinkid(String paramString)
  {
    this.infoPackage.linkid = paramString;
  }
  
  public void showSelectorPointStatus()
  {
    if ((this.mRootView != null) && (!this.mRootView.isSelectPointViewShowing())) {
      this.mRootView.showSelectorPointStatus();
    }
  }
  
  public void start()
  {
    super.start();
    if (this.mRootView != null) {
      this.mRootView.initPresenterView();
    }
    if (this.infoPackage != null) {
      UserOPController.getInstance().add("3.u.4", "1", this.infoPackage.parentType + "", null);
    }
  }
  
  public void ugcUpLoad()
  {
    if (this.infoPackage == null) {
      return;
    }
    if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext()))
    {
      TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), JarUtils.getResources().getString(1711670288));
      return;
    }
    if ((this.infoPackage.parentType == 6) && (this.infoPackage.detailType == -1))
    {
      TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "信息不完整，请勾选事件详情");
      return;
    }
    if (TextUtils.isEmpty(this.infoPackage.userPoint))
    {
      this.infoPackage.userPoint = getCurrentLocationPoint();
      if (TextUtils.isEmpty(this.infoPackage.userPoint)) {
        this.infoPackage.userPoint = this.infoPackage.point;
      }
    }
    new UgcHttpsUtils().addMapInfoTopackage(this.infoPackage);
    this.infoPackage.showLog("map_upload1");
    UserOPController.getInstance().add("3.u.1", "1", this.infoPackage.parentType + "", null);
    new UgcHttps().ugcReportInfoUpLoad(this.infoPackage, new UgcHttps.UgcHttpsResultCallBack()
    {
      public void onUgcInfoReportUpLoadFail(String paramAnonymousString)
      {
        if (paramAnonymousString != null) {
          TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), paramAnonymousString);
        }
        for (;;)
        {
          try
          {
            if (UgcReportMapSubDetailPresenter.this.infoPackage.voicePath != null) {
              FileUtils.del(UgcReportMapSubDetailPresenter.this.infoPackage.voicePath);
            }
            if (UgcReportMapSubDetailPresenter.this.infoPackage.photoPicPath != null) {
              FileUtils.del(UgcReportMapSubDetailPresenter.this.infoPackage.photoPicPath);
            }
            return;
          }
          catch (IOException paramAnonymousString)
          {
            paramAnonymousString.printStackTrace();
          }
          TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), JarUtils.getResources().getString(1711670287));
        }
      }
      
      public void onUgcInfoReportUpLoadSuccess(JSONObject paramAnonymousJSONObject)
      {
        Object localObject3 = null;
        Object localObject1 = localObject3;
        if (paramAnonymousJSONObject != null) {}
        try
        {
          localObject1 = paramAnonymousJSONObject.getString("tips");
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "上报成功！");
            UgcReportMapSubDetailPresenter.this.callbackMapInfo(UgcReportMapSubDetailPresenter.this.infoPackage, paramAnonymousJSONObject);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            try
            {
              if (UgcReportMapSubDetailPresenter.this.infoPackage.voicePath != null) {
                FileUtils.del(UgcReportMapSubDetailPresenter.this.infoPackage.voicePath);
              }
              if (UgcReportMapSubDetailPresenter.this.infoPackage.photoPicPath != null) {
                FileUtils.del(UgcReportMapSubDetailPresenter.this.infoPackage.photoPicPath);
              }
              return;
            }
            catch (IOException paramAnonymousJSONObject)
            {
              Object localObject2;
              paramAnonymousJSONObject.printStackTrace();
            }
            localException = localException;
            localException.printStackTrace();
            localObject2 = localObject3;
            continue;
            TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), (String)localObject2);
          }
        }
      }
    });
    finish();
  }
  
  public static abstract interface UgcSubDetailCallback
  {
    public abstract void commonCallback(int paramInt, Object paramObject1, Object paramObject2);
    
    public abstract void gotoSubView();
    
    public abstract void maxMapLevel();
    
    public abstract void onBackBtnPress();
    
    public abstract void onUpLoadCompleted(JSONObject paramJSONObject);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/ui/inmap/sub/UgcReportMapSubDetailPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */