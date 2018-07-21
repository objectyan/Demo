package com.baidu.navisdk.module.ugc.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider.UgcLayout;
import com.baidu.navisdk.module.ugc.data.datastatus.UgcReportInfoUploadPackage;
import com.baidu.navisdk.module.ugc.dialog.PicChooseDialog;
import com.baidu.navisdk.module.ugc.dialog.PicChooseDialog.PicProcessCallBack;
import com.baidu.navisdk.module.ugc.dialog.UgcSoundsRecordDialog;
import com.baidu.navisdk.module.ugc.dialog.UgcSoundsRecordDialog.OnUgcSoundsRecordCallback;
import com.baidu.navisdk.module.ugc.https.UgcHttpsUtils;
import com.baidu.navisdk.module.ugc.ui.inmap.sub.UgcReportMapSubDetailPresenter;
import com.baidu.navisdk.module.ugc.ui.innavi.main.UgcReportNaviMainPresenter;
import com.baidu.navisdk.module.ugc.ui.innavi.sub.UgcReportNaviSubDetailContract.View;
import com.baidu.navisdk.module.ugc.ui.innavi.sub.UgcReportNaviSubDetailView;
import com.baidu.navisdk.module.ugc.ui.naviresult.UgcRportNaviResultPresenter;
import com.baidu.navisdk.module.ugc.utils.PhotoProcessUtils.PicProcessResInfo;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public abstract class SubContentPrensenter
  implements SubContentContract.Presenter
{
  protected UgcReportInfoUploadPackage infoPackage;
  private boolean isFromNavi = false;
  private Context mContext;
  private Handler mHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      do
      {
        do
        {
          return;
        } while (paramAnonymousMessage.arg1 != 0);
        paramAnonymousMessage = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getAntiGeoPoi();
      } while ((paramAnonymousMessage == null) || (paramAnonymousMessage.mAddress.length() <= 0) || (SubContentPrensenter.this.mRootView == null) || (SubContentPrensenter.this.infoPackage == null) || (paramAnonymousMessage.mGuidePoint == null) || (paramAnonymousMessage.mAddress == null) || ((!TextUtils.isEmpty(SubContentPrensenter.this.infoPackage.point)) && (!TextUtils.isEmpty(SubContentPrensenter.this.infoPackage.name))));
      Bundle localBundle = CoordinateTransformUtil.LLE62MC(paramAnonymousMessage.mGuidePoint.getLongitudeE6(), paramAnonymousMessage.mGuidePoint.getLatitudeE6());
      localBundle.getInt("MCx");
      localBundle.getInt("MCy");
      if (SubContentPrensenter.this.infoPackage.point == null) {
        SubContentPrensenter.this.infoPackage.point = (localBundle.getInt("MCx") + "," + localBundle.getInt("MCy"));
      }
      if (SubContentPrensenter.this.infoPackage.userPoint == null) {
        SubContentPrensenter.this.infoPackage.userPoint = SubContentPrensenter.this.infoPackage.point;
      }
      SubContentPrensenter.this.infoPackage.name = paramAnonymousMessage.mAddress;
      SubContentPrensenter.this.informRubPointAdsorb(SubContentPrensenter.this.infoPackage.point, paramAnonymousMessage.mAddress);
    }
  };
  private PicChooseDialog.PicProcessCallBack mPicProcessLinsener = new PicChooseDialog.PicProcessCallBack()
  {
    public void onFail(String paramAnonymousString)
    {
      SubContentPrensenter.this.dimissPicDialog();
    }
    
    public void onSuccess(PhotoProcessUtils.PicProcessResInfo paramAnonymousPicProcessResInfo)
    {
      if ((SubContentPrensenter.this.mRootView == null) || (paramAnonymousPicProcessResInfo == null)) {
        return;
      }
      SubContentPrensenter.this.mRootView.showPhotoBitmap(paramAnonymousPicProcessResInfo.bitmap);
      if (SubContentPrensenter.this.infoPackage != null)
      {
        SubContentPrensenter.this.infoPackage.photoPicPath = paramAnonymousPicProcessResInfo.filePath;
        SubContentPrensenter.this.infoPackage.photoPoint = new UgcHttpsUtils().getCurrentLocationPoint();
      }
      if ((UgcReportNaviMainPresenter.statusPackage != null) && (SubContentPrensenter.this.isFromNavi))
      {
        UgcReportNaviMainPresenter.statusPackage.photoPicPath = SubContentPrensenter.this.infoPackage.photoPicPath;
        UgcReportNaviMainPresenter.statusPackage.photoPoint = SubContentPrensenter.this.infoPackage.photoPoint;
      }
      SubContentPrensenter.this.dimissPicDialog();
      SubContentPrensenter.this.upLoadBtnStatusChange();
    }
  };
  private SubContentContract.View mRootView;
  private UgcDataProvider.UgcLayout mUgcLayout;
  private PicChooseDialog picChooseDialog = null;
  private UgcSoundsRecordDialog soundsDialog = null;
  
  public SubContentPrensenter(Context paramContext, SubContentContract.View paramView, UgcDataProvider.UgcLayout paramUgcLayout)
  {
    this.mRootView = paramView;
    this.mContext = paramContext;
    this.mUgcLayout = paramUgcLayout;
    this.infoPackage = new UgcReportInfoUploadPackage();
    if ((paramView instanceof UgcReportNaviSubDetailView)) {
      this.isFromNavi = true;
    }
    paramView.setPresenter(this);
  }
  
  private void dimissPicDialog()
  {
    if (this.picChooseDialog != null)
    {
      this.picChooseDialog.dismiss();
      this.picChooseDialog = null;
    }
  }
  
  private void dismissSoundsDialog()
  {
    if (this.soundsDialog != null)
    {
      this.soundsDialog.dismiss();
      this.soundsDialog = null;
    }
  }
  
  private void getCurrentPositionInfo()
  {
    Object localObject = BNLocationManagerProxy.getInstance().getCurLocation();
    if (localObject != null)
    {
      localObject = ((LocData)localObject).toGeoPoint();
      if (localObject != null)
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
        BNPoiSearcher.getInstance().asynGetPoiByPoint((GeoPoint)localObject, i, 3000, this.mHandler);
      }
    }
  }
  
  private void openPicDialog()
  {
    if (this.mRootView == null) {
      return;
    }
    if (this.picChooseDialog == null) {
      this.picChooseDialog = new PicChooseDialog(this.mRootView.getContext());
    }
    this.picChooseDialog.setListener(this.mPicProcessLinsener);
    this.picChooseDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        if (SubContentPrensenter.this.picChooseDialog != null)
        {
          SubContentPrensenter.this.picChooseDialog.dismiss();
          SubContentPrensenter.access$402(SubContentPrensenter.this, null);
        }
      }
    });
    this.picChooseDialog.show();
  }
  
  private void openSoundsDialog()
  {
    if (this.mRootView == null) {}
    while (!UgcSoundsRecordDialog.checkAudioAuth()) {
      return;
    }
    if (this.soundsDialog == null) {
      this.soundsDialog = new UgcSoundsRecordDialog(this.mRootView.getContext());
    }
    this.soundsDialog.setOnUgcSoundsRecordCallback(new UgcSoundsRecordDialog.OnUgcSoundsRecordCallback()
    {
      public void onRecordFinish(int paramAnonymousInt, String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        if ((paramAnonymousBoolean) && (paramAnonymousInt >= 1)) {
          SubContentPrensenter.this.mRootView.showRecordResult(paramAnonymousInt);
        }
        if (SubContentPrensenter.this.infoPackage != null)
        {
          SubContentPrensenter.this.infoPackage.voicePath = paramAnonymousString;
          SubContentPrensenter.this.infoPackage.recordTime = paramAnonymousInt;
        }
        if ((UgcReportNaviMainPresenter.statusPackage != null) && (SubContentPrensenter.this.isFromNavi))
        {
          UgcReportNaviMainPresenter.statusPackage.voicePath = SubContentPrensenter.this.infoPackage.voicePath;
          UgcReportNaviMainPresenter.statusPackage.recordTime = SubContentPrensenter.this.infoPackage.recordTime;
        }
        SubContentPrensenter.this.dismissSoundsDialog();
        SubContentPrensenter.this.upLoadBtnStatusChange();
      }
    });
    this.soundsDialog.show();
  }
  
  private void upLoadBtnStatusChange()
  {
    if ((this.infoPackage == null) || (this.mRootView == null)) {}
    do
    {
      return;
      if ((this.infoPackage.parentType == 6) && ((this instanceof UgcReportMapSubDetailPresenter)))
      {
        if (this.infoPackage.detailType != -1)
        {
          this.mRootView.setUploadBtnClickable(true);
          return;
        }
        this.mRootView.setUploadBtnClickable(false);
        return;
      }
    } while ((this.infoPackage.parentType != 1) && (this.infoPackage.parentType != 2));
    if ((this.infoPackage.detailType != -1) || (this.infoPackage.laneType != -1) || (this.infoPackage.subType != -1) || (!TextUtils.isEmpty(this.infoPackage.content)) || (!TextUtils.isEmpty(this.infoPackage.voicePath)) || (!TextUtils.isEmpty(this.infoPackage.photoPicPath)))
    {
      this.mRootView.setUploadBtnClickable(true);
      return;
    }
    this.mRootView.setUploadBtnClickable(false);
  }
  
  public void deletSoundShow()
  {
    if (this.infoPackage != null) {
      this.infoPackage.voicePath = null;
    }
    if (this.mRootView != null) {
      this.mRootView.showSoundCancle();
    }
    upLoadBtnStatusChange();
  }
  
  public void deletePhotoShow()
  {
    if (this.infoPackage != null)
    {
      this.infoPackage.photoPicPath = null;
      this.infoPackage.photoPoint = null;
    }
    if (this.mRootView != null) {
      this.mRootView.showPhotoCancle();
    }
    upLoadBtnStatusChange();
  }
  
  public int getDetailGvSize()
  {
    if (this.mUgcLayout != null) {
      return this.mUgcLayout.getDetailSize();
    }
    return 0;
  }
  
  public String getDetailGvTextTile(int paramInt)
  {
    if (this.mUgcLayout != null) {
      return this.mUgcLayout.getDetailTitle(paramInt);
    }
    return null;
  }
  
  public int getLaneInfoGvSize()
  {
    if (this.mUgcLayout != null) {
      return this.mUgcLayout.getLaneSize();
    }
    return 0;
  }
  
  public String getLaneInfoGvTextTile(int paramInt)
  {
    if (this.mUgcLayout != null) {
      return this.mUgcLayout.getLaneTitle(paramInt);
    }
    return null;
  }
  
  public int getPositionInfoGvSize()
  {
    if (this.mUgcLayout != null) {
      return this.mUgcLayout.getPositionSize();
    }
    return 0;
  }
  
  public String getPositionInfoGvTextTile(int paramInt)
  {
    if (this.mUgcLayout != null) {
      return this.mUgcLayout.getPositionTitle(paramInt);
    }
    return null;
  }
  
  public String getSubTitleText()
  {
    if (this.mUgcLayout != null) {
      return this.mUgcLayout.getSubTitle();
    }
    return null;
  }
  
  public int getSubType()
  {
    if (this.mUgcLayout != null) {
      return this.mUgcLayout.getSubType();
    }
    return -1;
  }
  
  public void gotoPhotoCapture()
  {
    openPicDialog();
  }
  
  public void gotoSelectorPointPage() {}
  
  public void gotoSoundsRecordDialog()
  {
    openSoundsDialog();
  }
  
  public abstract void informRubPointAdsorb(String paramString1, String paramString2);
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.picChooseDialog != null) {
      this.picChooseDialog.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public boolean onBackPress()
  {
    return false;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    this.isFromNavi = true;
    start();
    if (UgcReportNaviMainPresenter.statusPackage != null)
    {
      if (UgcReportNaviMainPresenter.statusPackage.name != null) {
        informRubPointAdsorb(null, UgcReportNaviMainPresenter.statusPackage.name);
      }
      if (UgcReportNaviMainPresenter.statusPackage.content != null) {
        this.mRootView.setDescriEditText(UgcReportNaviMainPresenter.statusPackage.content);
      }
      if (UgcReportNaviMainPresenter.statusPackage.photoPicPath == null) {}
    }
    try
    {
      paramConfiguration = BitmapFactory.decodeFile(UgcReportNaviMainPresenter.statusPackage.photoPicPath);
      this.mRootView.showPhotoBitmap(paramConfiguration);
      this.infoPackage.photoPicPath = UgcReportNaviMainPresenter.statusPackage.photoPicPath;
      this.infoPackage.photoPoint = UgcReportNaviMainPresenter.statusPackage.photoPoint;
      if (UgcReportNaviMainPresenter.statusPackage.voicePath != null)
      {
        this.mRootView.showRecordResult(UgcReportNaviMainPresenter.statusPackage.recordTime);
        this.infoPackage.voicePath = UgcReportNaviMainPresenter.statusPackage.voicePath;
      }
      if (UgcReportNaviMainPresenter.statusPackage.detailPosition != -1) {
        this.mRootView.updateSubContainerStatus(UgcReportNaviMainPresenter.statusPackage.detailPosition, 2);
      }
      if (UgcReportNaviMainPresenter.statusPackage.lanePosition != -1) {
        this.mRootView.updateSubContainerStatus(UgcReportNaviMainPresenter.statusPackage.lanePosition, 0);
      }
      if (UgcReportNaviMainPresenter.statusPackage.subPosition != -1) {
        this.mRootView.updateSubContainerStatus(UgcReportNaviMainPresenter.statusPackage.subPosition, 1);
      }
      upLoadBtnStatusChange();
      return;
    }
    catch (Exception paramConfiguration)
    {
      for (;;) {}
    }
  }
  
  public void onDestroy()
  {
    dimissPicDialog();
    dismissSoundsDialog();
  }
  
  public void recordContentChange(String paramString)
  {
    if (this.infoPackage != null) {
      this.infoPackage.content = paramString;
    }
    if ((UgcReportNaviMainPresenter.statusPackage != null) && (this.isFromNavi)) {
      UgcReportNaviMainPresenter.statusPackage.content = this.infoPackage.content;
    }
    upLoadBtnStatusChange();
  }
  
  public void recordDetailSelected(int paramInt)
  {
    if ((this.mUgcLayout != null) && (this.infoPackage != null))
    {
      this.infoPackage.detailType = this.mUgcLayout.getDetailType(paramInt);
      this.infoPackage.showLog("detailType change" + this.infoPackage.detailType);
    }
    if ((UgcReportNaviMainPresenter.statusPackage != null) && (this.isFromNavi)) {
      UgcReportNaviMainPresenter.statusPackage.detailPosition = paramInt;
    }
    upLoadBtnStatusChange();
  }
  
  public void recordLaneSelected(int paramInt)
  {
    if ((this.mUgcLayout != null) && (this.infoPackage != null))
    {
      this.infoPackage.laneType = this.mUgcLayout.getLaneType(paramInt);
      this.infoPackage.showLog("laneType change" + this.infoPackage.laneType);
    }
    if ((UgcReportNaviMainPresenter.statusPackage != null) && (this.isFromNavi)) {
      UgcReportNaviMainPresenter.statusPackage.lanePosition = paramInt;
    }
    upLoadBtnStatusChange();
  }
  
  public void recordPositionSelected(int paramInt)
  {
    if ((this.mUgcLayout != null) && (this.infoPackage != null))
    {
      this.infoPackage.subType = this.mUgcLayout.getPositionType(paramInt);
      if (this.infoPackage.parentType == 15) {
        this.infoPackage.speedLimit = this.infoPackage.subType;
      }
    }
    if ((UgcReportNaviMainPresenter.statusPackage != null) && (this.isFromNavi)) {
      UgcReportNaviMainPresenter.statusPackage.subPosition = paramInt;
    }
    upLoadBtnStatusChange();
  }
  
  public void setRootView(UgcReportNaviSubDetailContract.View paramView)
  {
    this.mRootView = paramView;
  }
  
  public void start()
  {
    if (this.mRootView == null) {
      return;
    }
    this.mRootView.initPresenterView();
    getCurrentPositionInfo();
    if ((this.mUgcLayout.getSubType() == 6) && ((this instanceof UgcReportMapSubDetailPresenter))) {
      this.mRootView.setDetailFlagVisibility(true);
    }
    for (;;)
    {
      if (this.mUgcLayout.getSubType() == 15) {
        this.mRootView.setDescriEditHintText("以上选项说不清，可在这里吐槽...");
      }
      if ((this.mUgcLayout.getSubType() == 1) && ((this instanceof UgcRportNaviResultPresenter))) {
        this.mRootView.setPositionLayout(false);
      }
      upLoadBtnStatusChange();
      return;
      this.mRootView.setDetailFlagVisibility(false);
    }
  }
  
  public void ugcUpLoad() {}
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/ui/SubContentPrensenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */