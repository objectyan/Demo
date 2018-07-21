package com.baidu.navisdk.module.ugc.ui.inmap.main;

import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.module.ugc.BasePresenter;
import com.baidu.navisdk.module.ugc.BaseView;

public abstract interface UgcReportMapMainContract
{
  public static abstract interface Presenter
    extends BasePresenter
  {
    public abstract String getParentItemsGvTextTile(int paramInt);
    
    public abstract void gotoMapSubDetailView(int paramInt);
    
    public abstract void gotoUgcMapApi(String paramString);
    
    public abstract void gotoUgcMapH5Page(int paramInt);
    
    public abstract void gotoUgcMapH5Page(String paramString);
    
    public abstract void informUserToRegister();
    
    public abstract void initUserInfo(TextView paramTextView);
    
    public abstract void onUgcBackPressed();
    
    public abstract void parentItemsGvImageLoader(int paramInt, ImageView paramImageView);
    
    public abstract int parentItemsGvSize();
    
    public abstract void performCheckDetailBtn();
    
    public abstract void setOnlineImageLoader(int paramInt, ImageView paramImageView, String paramString);
  }
  
  public static abstract interface View
    extends BaseView<UgcReportMapMainContract.Presenter>
  {
    public abstract void setUserInfoLayoutvisibile(boolean paramBoolean);
    
    public abstract void showUserUnRegister();
    
    public abstract void showUserUploadCounts(int paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/ui/inmap/main/UgcReportMapMainContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */