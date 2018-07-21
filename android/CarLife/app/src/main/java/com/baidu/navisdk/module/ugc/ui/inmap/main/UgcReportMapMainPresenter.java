package com.baidu.navisdk.module.ugc.ui.inmap.main;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider.UgcLayout;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataRepository;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataRepository.UgcBaseDataModel;
import com.baidu.navisdk.module.ugc.https.UgcHttps;
import com.baidu.navisdk.module.ugc.https.UgcHttps.UgcHttpsResultCallBack;
import com.baidu.navisdk.module.ugc.utils.UgcImageLoaderUtils;
import com.baidu.navisdk.ui.ugc.control.UgcOperationActController;
import com.baidu.navisdk.ui.ugc.model.UgcOperationalActModel.UgcBaseDataModel;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONObject;

public class UgcReportMapMainPresenter
  implements UgcReportMapMainContract.Presenter, Serializable
{
  private static final long serialVersionUID = -4117642688886118172L;
  private UgcImageLoaderUtils imageLoaderUtils = null;
  public ArrayList<UgcOperationalActModel.UgcBaseDataModel> mMapUgcDataList = null;
  private UgcReportMapMainContract.View mRootView = null;
  private UgcDataProvider.UgcLayout mUgcLayout = null;
  private UgcReportCallback mUgcReportCallback = null;
  
  public UgcReportMapMainPresenter(UgcReportMapMainContract.View paramView, UgcDataProvider.UgcLayout paramUgcLayout, UgcReportCallback paramUgcReportCallback)
  {
    this.mRootView = paramView;
    this.mUgcReportCallback = paramUgcReportCallback;
    this.mUgcLayout = paramUgcLayout;
    this.imageLoaderUtils = new UgcImageLoaderUtils();
    paramView.setPresenter(this);
  }
  
  private void getUserInfoFromNet()
  {
    new UgcHttps().getUgcUserInfo(new UgcHttps.UgcHttpsResultCallBack()
    {
      public void onUgcInfoReportUpLoadFail(String paramAnonymousString)
      {
        UgcReportMapMainPresenter.this.mRootView.showUserUnRegister();
      }
      
      public void onUgcInfoReportUpLoadSuccess(JSONObject paramAnonymousJSONObject)
      {
        try
        {
          int i = paramAnonymousJSONObject.getInt("count");
          if ((i >= 0) && (UgcReportMapMainPresenter.this.mRootView != null)) {
            UgcReportMapMainPresenter.this.mRootView.showUserUploadCounts(i);
          }
          return;
        }
        catch (Exception paramAnonymousJSONObject) {}
      }
    });
  }
  
  public String getParentItemsGvTextTile(int paramInt)
  {
    if (this.mUgcLayout != null) {
      return this.mUgcLayout.getMainItemsTitle(paramInt);
    }
    return null;
  }
  
  public void gotoMapSubDetailView(int paramInt)
  {
    if (this.mUgcReportCallback != null) {
      this.mUgcReportCallback.onGotoMapSubDetailView(paramInt);
    }
  }
  
  public void gotoUgcMapApi(String paramString)
  {
    if (this.mUgcReportCallback != null) {
      this.mUgcReportCallback.onOpenApi(paramString);
    }
  }
  
  public void gotoUgcMapH5Page(int paramInt)
  {
    try
    {
      gotoUgcMapH5Page(((UgcDataRepository.UgcBaseDataModel)UgcDataRepository.getInstance().obtainMapFeedBackDataList().get(paramInt)).iconUrl);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void gotoUgcMapH5Page(String paramString)
  {
    if (this.mUgcReportCallback != null) {
      this.mUgcReportCallback.onShowH5Page(paramString);
    }
  }
  
  public void informUserToRegister()
  {
    if (this.mUgcReportCallback != null) {
      this.mUgcReportCallback.onUgcBtnClick(6);
    }
  }
  
  public void initUserInfo(TextView paramTextView)
  {
    if (!TextUtils.isEmpty(BNaviModuleManager.getBduss()))
    {
      getUserInfoFromNet();
      return;
    }
    this.mRootView.showUserUnRegister();
  }
  
  public void loginStatusChange()
  {
    if (!TextUtils.isEmpty(BNaviModuleManager.getBduss()))
    {
      LogUtil.e("loginStatusChange:", "has login");
      getUserInfoFromNet();
      return;
    }
    LogUtil.e("loginStatusChange:", "no login");
  }
  
  public boolean onBackPressed()
  {
    return false;
  }
  
  public void onCreate(Bundle paramBundle) {}
  
  public void onDestroy() {}
  
  public void onResume() {}
  
  public void onUgcBackPressed()
  {
    if (this.mUgcReportCallback != null) {
      this.mUgcReportCallback.onUgcFinish();
    }
  }
  
  public void parentItemsGvImageLoader(int paramInt, ImageView paramImageView)
  {
    if ((this.imageLoaderUtils != null) && (this.mUgcLayout != null)) {
      this.imageLoaderUtils.updateUgcViewOnLine(true, this.mUgcLayout.getMainItemsType(paramInt), paramImageView);
    }
  }
  
  public int parentItemsGvSize()
  {
    if (this.mUgcLayout != null) {
      return this.mUgcLayout.getMainItemsSize();
    }
    return 0;
  }
  
  public void performCheckDetailBtn()
  {
    if (this.mUgcReportCallback != null)
    {
      gotoUgcMapH5Page(UgcOperationActController.getInstance().getShowRCEventListUrl());
      UserOPController.getInstance().add("3.u.4", "1", "94", null);
    }
  }
  
  public void setOnlineImageLoader(int paramInt, ImageView paramImageView, String paramString)
  {
    if ((this.imageLoaderUtils != null) && (this.mUgcLayout != null)) {
      this.imageLoaderUtils.updateUgcViewOnLine(paramInt, paramImageView, paramString);
    }
  }
  
  public void start()
  {
    if (this.mRootView != null) {
      this.mRootView.initPresenterView();
    }
  }
  
  public static abstract interface UgcReportCallback
  {
    public abstract void onGotoMapSubDetailView(int paramInt);
    
    public abstract void onOpenApi(String paramString);
    
    public abstract void onShowH5Page(String paramString);
    
    public abstract void onUgcBtnClick(int paramInt);
    
    public abstract void onUgcFinish();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/ui/inmap/main/UgcReportMapMainPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */