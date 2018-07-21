package com.baidu.navisdk.module.ugc.ui;

import android.content.Context;
import android.graphics.Bitmap;
import com.baidu.navisdk.module.ugc.BasePresenter;
import com.baidu.navisdk.module.ugc.BaseView;

public abstract interface SubContentContract
{
  public static abstract interface Presenter
    extends BasePresenter
  {
    public abstract void deletSoundShow();
    
    public abstract void deletePhotoShow();
    
    public abstract int getDetailGvSize();
    
    public abstract String getDetailGvTextTile(int paramInt);
    
    public abstract int getLaneInfoGvSize();
    
    public abstract String getLaneInfoGvTextTile(int paramInt);
    
    public abstract int getPositionInfoGvSize();
    
    public abstract String getPositionInfoGvTextTile(int paramInt);
    
    public abstract String getSubTitleText();
    
    public abstract int getSubType();
    
    public abstract void gotoPhotoCapture();
    
    public abstract void gotoSelectorPointPage();
    
    public abstract void gotoSoundsRecordDialog();
    
    public abstract boolean onBackPress();
    
    public abstract void onDestroy();
    
    public abstract void recordContentChange(String paramString);
    
    public abstract void recordDetailSelected(int paramInt);
    
    public abstract void recordLaneSelected(int paramInt);
    
    public abstract void recordPositionSelected(int paramInt);
    
    public abstract void ugcUpLoad();
  }
  
  public static abstract interface View
    extends BaseView<SubContentContract.Presenter>
  {
    public abstract Context getContext();
    
    public abstract void setDescriEditHintText(String paramString);
    
    public abstract void setDescriEditText(String paramString);
    
    public abstract void setDetailFlagVisibility(boolean paramBoolean);
    
    public abstract void setPositionLayout(boolean paramBoolean);
    
    public abstract void setUploadBtnClickable(boolean paramBoolean);
    
    public abstract void showAddrInfoUpdate(String paramString1, String paramString2);
    
    public abstract void showPhotoBitmap(Bitmap paramBitmap);
    
    public abstract void showPhotoCancle();
    
    public abstract void showPhotoGraph(Bitmap paramBitmap);
    
    public abstract void showRecordResult(int paramInt);
    
    public abstract void showSoundCancle();
    
    public abstract void updateSubContainerStatus(int paramInt1, int paramInt2);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/ui/SubContentContract.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */