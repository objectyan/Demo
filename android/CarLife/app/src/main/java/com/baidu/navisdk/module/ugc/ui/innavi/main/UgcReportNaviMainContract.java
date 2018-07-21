package com.baidu.navisdk.module.ugc.ui.innavi.main;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.navisdk.module.ugc.BasePresenter;
import com.baidu.navisdk.module.ugc.BaseView;

public abstract interface UgcReportNaviMainContract
{
  public static abstract interface Presenter
    extends BasePresenter
  {
    public abstract boolean checkBaseRequire();
    
    public abstract void finish();
    
    public abstract int getDynamicItemsSize();
    
    public abstract String getDynamicItemsTextTitle(int paramInt);
    
    public abstract boolean getIsTipsDynamic();
    
    public abstract String getParentItemsGvTextTile(int paramInt);
    
    public abstract String getUploadTipsTextTitle();
    
    public abstract void gotoNaviSubDetailView(boolean paramBoolean);
    
    public abstract void gotoUploadView(int paramInt, boolean paramBoolean);
    
    public abstract void parentDynamicItemsGvImageLoader(int paramInt, ImageView paramImageView);
    
    public abstract void parentItemsGvImageLoader(int paramInt, ImageView paramImageView);
    
    public abstract int parentItemsGvSize();
    
    public abstract void parentTipsItemsGvImageLoader(ImageView paramImageView);
    
    public abstract void simpleUpload();
  }
  
  public static abstract interface View
    extends BaseView<UgcReportNaviMainContract.Presenter>
  {
    public abstract Context getContext();
    
    public abstract int getOrientation();
    
    public abstract ViewGroup getParentContainer();
    
    public abstract View getParentView();
    
    public abstract void hideTipItemIv();
    
    public abstract void initUploadView();
    
    public abstract void showCurTimes(int paramInt);
    
    public abstract void showIpoView();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/ui/innavi/main/UgcReportNaviMainContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */