package com.baidu.navisdk.module.ugc.ui.naviresult;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider.UgcLayout;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcNaviDynamicMarkRespository;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcNaviDynamicMarkRespository.NaviDynamicMark;
import com.baidu.navisdk.module.ugc.data.datastatus.UgcReportInfoUploadPackage;
import com.baidu.navisdk.module.ugc.https.UgcHttps;
import com.baidu.navisdk.module.ugc.https.UgcHttps.UgcHttpsResultCallBack;
import com.baidu.navisdk.module.ugc.https.UgcHttpsUtils;
import com.baidu.navisdk.module.ugc.ui.SubContentContract.View;
import com.baidu.navisdk.module.ugc.utils.UgcImageLoaderUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.FileUtils;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import java.io.IOException;
import org.json.JSONObject;

public class UgcRportNaviResultPresenter
  extends UgcRportNaviResultContract.Presenter
{
  private boolean hasInformComHeight = false;
  private UgcImageLoaderUtils imageLoaderUtils;
  private boolean isInNewRoad = false;
  private Context mContext;
  private Handler mHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if ((paramAnonymousMessage != null) && (paramAnonymousMessage.what == 1003) && (paramAnonymousMessage.arg1 == 0))
      {
        paramAnonymousMessage = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getAntiGeoPoi();
        if ((paramAnonymousMessage != null) && (paramAnonymousMessage.mAddress.length() > 0) && (UgcRportNaviResultPresenter.this.mRootView != null) && (UgcRportNaviResultPresenter.this.infoPackage != null)) {
          UgcRportNaviResultPresenter.this.mRootView.showAddrInfoUpdate(paramAnonymousMessage.mAddress, null);
        }
      }
    }
  };
  private UgcRportNaviResultContract.View mRootView;
  private UgcDataProvider.UgcLayout mUgcLayout;
  private UgcSubDetailCallback mUgcReportCallback;
  private UgcNaviDynamicMarkRespository.NaviDynamicMark naviDynamicMark;
  
  public UgcRportNaviResultPresenter(Context paramContext, SubContentContract.View paramView, UgcDataProvider.UgcLayout paramUgcLayout, UgcSubDetailCallback paramUgcSubDetailCallback, UgcNaviDynamicMarkRespository.NaviDynamicMark paramNaviDynamicMark)
  {
    super(paramContext, paramView, paramUgcLayout);
    this.mRootView = ((UgcRportNaviResultContract.View)paramView);
    this.mContext = paramContext;
    this.mUgcReportCallback = paramUgcSubDetailCallback;
    this.imageLoaderUtils = new UgcImageLoaderUtils();
    this.naviDynamicMark = paramNaviDynamicMark;
    this.mUgcLayout = paramUgcLayout;
    recordUploadInfo(paramNaviDynamicMark);
    paramView.setPresenter(this);
  }
  
  private static UgcDataProvider.UgcLayout getLayout(UgcNaviDynamicMarkRespository.NaviDynamicMark paramNaviDynamicMark)
  {
    if (paramNaviDynamicMark == null) {
      return null;
    }
    return UgcDataProvider.obtainDynamicUgcNaviSubLayout(paramNaviDynamicMark.type);
  }
  
  private void recordUploadInfo(UgcNaviDynamicMarkRespository.NaviDynamicMark paramNaviDynamicMark)
  {
    if ((this.infoPackage != null) && (paramNaviDynamicMark != null))
    {
      this.infoPackage.parentType = paramNaviDynamicMark.type;
      this.infoPackage.id = paramNaviDynamicMark.id;
      this.infoPackage.userPoint = (paramNaviDynamicMark.x + "," + paramNaviDynamicMark.y);
      this.infoPackage.mGeoPoint = paramNaviDynamicMark.mGeoPoint;
    }
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
      this.mUgcReportCallback.onUpLoadCompleted();
    }
  }
  
  public void gotoDtailView()
  {
    this.mUgcReportCallback.onBackDetailView();
  }
  
  public void hasShowOriginPage()
  {
    if (this.mUgcReportCallback != null) {}
  }
  
  public void hasShowSelectorPointStatus()
  {
    if (this.mUgcReportCallback != null) {
      this.mUgcReportCallback.onBackDetailView();
    }
  }
  
  public void informComHeight()
  {
    if (this.hasInformComHeight) {}
    do
    {
      return;
      this.hasInformComHeight = true;
    } while (!this.isInNewRoad);
    showSelectorPointStatus();
  }
  
  public void informRubPointAdsorb(String paramString1, String paramString2) {}
  
  public boolean isInNewRoad()
  {
    return this.isInNewRoad;
  }
  
  public void onAddrInfoUpdate(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
  }
  
  public boolean onBackPress()
  {
    if ((!this.mRootView.isSelectPointViewShowing()) && (this.isInNewRoad))
    {
      gotoDtailView();
      return true;
    }
    return false;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onPointSelected(double paramDouble1, double paramDouble2) {}
  
  public void secondUpload()
  {
    if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext()))
    {
      TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), JarUtils.getResources().getString(1711670288));
      return;
    }
    if ((this.isInNewRoad) && ((TextUtils.isEmpty(this.infoPackage.startPoint)) || (TextUtils.isEmpty(this.infoPackage.endPoint))))
    {
      TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "请选择起点和终点");
      return;
    }
    new UgcHttpsUtils().addNaviResultInfoToPackge(this.infoPackage);
    new UgcHttps().ugcReportInfoUpLoad(this.infoPackage, new UgcHttps.UgcHttpsResultCallBack()
    {
      public void onUgcInfoReportUpLoadFail(String paramAnonymousString)
      {
        if (paramAnonymousString != null) {
          TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), paramAnonymousString);
        }
        for (;;)
        {
          UgcNaviDynamicMarkRespository.getInstance().removeUploadingId(UgcRportNaviResultPresenter.this.infoPackage.id);
          if (UgcRportNaviResultPresenter.this.mUgcReportCallback != null) {
            UgcRportNaviResultPresenter.this.mUgcReportCallback.onUpLoadMsgCallBack(false);
          }
          try
          {
            if (UgcRportNaviResultPresenter.this.infoPackage.voicePath != null) {
              FileUtils.del(UgcRportNaviResultPresenter.this.infoPackage.voicePath);
            }
            if (UgcRportNaviResultPresenter.this.infoPackage.photoPicPath != null) {
              FileUtils.del(UgcRportNaviResultPresenter.this.infoPackage.photoPicPath);
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
        String str2 = "上报成功！";
        String str1 = str2;
        if (paramAnonymousJSONObject != null) {}
        try
        {
          str1 = paramAnonymousJSONObject.getString("tips");
          TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), str1);
          UgcNaviDynamicMarkRespository.getInstance().removeId(UgcRportNaviResultPresenter.this.infoPackage.id);
          UgcNaviDynamicMarkRespository.getInstance().removeUploadingId(UgcRportNaviResultPresenter.this.infoPackage.id);
          if (UgcRportNaviResultPresenter.this.mUgcReportCallback != null) {
            UgcRportNaviResultPresenter.this.mUgcReportCallback.onUpLoadMsgCallBack(true);
          }
        }
        catch (Exception paramAnonymousJSONObject)
        {
          for (;;)
          {
            try
            {
              if (UgcRportNaviResultPresenter.this.infoPackage.voicePath != null) {
                FileUtils.del(UgcRportNaviResultPresenter.this.infoPackage.voicePath);
              }
              if (UgcRportNaviResultPresenter.this.infoPackage.photoPicPath != null) {
                FileUtils.del(UgcRportNaviResultPresenter.this.infoPackage.photoPicPath);
              }
              return;
            }
            catch (IOException paramAnonymousJSONObject)
            {
              paramAnonymousJSONObject.printStackTrace();
            }
            paramAnonymousJSONObject = paramAnonymousJSONObject;
            paramAnonymousJSONObject.printStackTrace();
            str1 = str2;
          }
        }
      }
    });
    UgcNaviDynamicMarkRespository.getInstance().addUploadingDynamicMark(this.naviDynamicMark);
    finish();
  }
  
  public void setNewRoadSelectStatus(int paramInt, double paramDouble1, double paramDouble2, String paramString)
  {
    if (this.infoPackage == null) {
      return;
    }
    if (this.mRootView != null) {
      this.mRootView.setNewRoadSelectStatus(paramInt);
    }
    switch (paramInt)
    {
    case 0: 
    default: 
      return;
    case 1: 
      this.infoPackage.startPoint = (paramDouble1 + "," + paramDouble2);
      this.infoPackage.startName = paramString;
      return;
    }
    this.infoPackage.endPoint = (paramDouble1 + "," + paramDouble2);
    this.infoPackage.endName = paramString;
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
    boolean bool;
    if (this.infoPackage.parentType == 1)
    {
      bool = true;
      this.isInNewRoad = bool;
      if (this.mRootView != null)
      {
        this.mRootView.initPresenterView();
        if (!this.isInNewRoad) {
          break label126;
        }
        this.mRootView.supportScrollView();
        this.mRootView.showNewRoadLayoutView(true);
      }
    }
    for (;;)
    {
      if ((this.infoPackage != null) && (this.infoPackage.mGeoPoint != null))
      {
        int j = 1;
        int i = j;
        if (BNaviModuleManager.getActivity() != null)
        {
          i = j;
          if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getActivity())) {
            i = 0;
          }
        }
        BNPoiSearcher.getInstance().asynGetPoiByPoint(this.infoPackage.mGeoPoint, i, 3000, this.mHandler);
      }
      return;
      bool = false;
      break;
      label126:
      this.mRootView.showNewRoadLayoutView(false);
    }
  }
  
  public static abstract interface UgcSubDetailCallback
  {
    public abstract void onBackBtnPress();
    
    public abstract void onBackDetailView();
    
    public abstract void onUpLoadCompleted();
    
    public abstract void onUpLoadMsgCallBack(boolean paramBoolean);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/ui/naviresult/UgcRportNaviResultPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */