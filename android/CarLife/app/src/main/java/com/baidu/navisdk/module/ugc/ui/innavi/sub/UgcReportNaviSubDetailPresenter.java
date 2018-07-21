package com.baidu.navisdk.module.ugc.ui.innavi.sub;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataProvider.UgcLayout;
import com.baidu.navisdk.module.ugc.data.datastatus.UgcReportInfoUploadPackage;
import com.baidu.navisdk.module.ugc.https.UgcHttps;
import com.baidu.navisdk.module.ugc.https.UgcHttps.UgcHttpsResultCallBack;
import com.baidu.navisdk.module.ugc.https.UgcHttpsUtils;
import com.baidu.navisdk.module.ugc.https.UgcHttpsUtils.ScreenShotCallBack;
import com.baidu.navisdk.module.ugc.ui.innavi.main.UgcReportNaviMainPresenter;
import com.baidu.navisdk.module.ugc.utils.UgcImageLoaderUtils;
import com.baidu.navisdk.ui.routeguide.control.RGNotificationController;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.FileUtils;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import java.io.IOException;
import org.json.JSONObject;

public class UgcReportNaviSubDetailPresenter
  extends UgcReportNaviSubDetailContract.Presenter
{
  private static final int MAX_TIME_COUNT = 10;
  private static final int MSG_TIMES_COUNT_WAHT = 256;
  private Handler coutTimesHandler = null;
  private boolean hasStopCount = false;
  private UgcImageLoaderUtils imageLoaderUtils;
  private UgcReportNaviSubDetailContract.View mRootView;
  private UgcReportNaviMainPresenter parPresenter;
  
  public UgcReportNaviSubDetailPresenter(Context paramContext, UgcDataProvider.UgcLayout paramUgcLayout, UgcReportNaviSubDetailContract.View paramView, UgcReportNaviMainPresenter paramUgcReportNaviMainPresenter, UgcReportInfoUploadPackage paramUgcReportInfoUploadPackage)
  {
    super(paramContext, paramView, paramUgcLayout);
    this.mRootView = paramView;
    this.parPresenter = paramUgcReportNaviMainPresenter;
    this.imageLoaderUtils = new UgcImageLoaderUtils();
    this.mRootView.setPresenter(this);
    if ((paramUgcReportInfoUploadPackage != null) && (this.infoPackage != null))
    {
      this.infoPackage.parentType = paramUgcReportInfoUploadPackage.parentType;
      this.infoPackage.mark = paramUgcReportInfoUploadPackage.mark;
      this.infoPackage.userPoint = paramUgcReportInfoUploadPackage.userPoint;
      this.infoPackage.point = paramUgcReportInfoUploadPackage.point;
    }
    if (this.infoPackage.mark == 1) {
      this.mRootView.hideSubTitleIv();
    }
  }
  
  private void realComUpload()
  {
    boolean bool = true;
    UgcHttpsUtils localUgcHttpsUtils = new UgcHttpsUtils();
    UgcReportInfoUploadPackage localUgcReportInfoUploadPackage = this.infoPackage;
    if (this.infoPackage.mark == 1) {}
    for (;;)
    {
      localUgcHttpsUtils.addNaviInfoToPackage(localUgcReportInfoUploadPackage, bool);
      this.infoPackage.mark = 0;
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
              if (UgcReportNaviSubDetailPresenter.this.infoPackage.voicePath != null) {
                FileUtils.del(UgcReportNaviSubDetailPresenter.this.infoPackage.voicePath);
              }
              if (UgcReportNaviSubDetailPresenter.this.infoPackage.photoPicPath != null) {
                FileUtils.del(UgcReportNaviSubDetailPresenter.this.infoPackage.photoPicPath);
              }
              if (UgcReportNaviSubDetailPresenter.this.infoPackage.screenshotPicPath != null) {
                FileUtils.del(UgcReportNaviSubDetailPresenter.this.infoPackage.screenshotPicPath);
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
          Object localObject2 = null;
          Object localObject1 = localObject2;
          if (paramAnonymousJSONObject != null) {}
          try
          {
            localObject1 = paramAnonymousJSONObject.getString("tips");
            if ((UgcReportNaviSubDetailPresenter.this.parPresenter != null) && (!UgcReportNaviSubDetailPresenter.this.parPresenter.getIsIpoNavi()))
            {
              RouteGuideFSM.getInstance().run(RouteGuideFSM.getInstance().getEventToLastestMapState());
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                RGNotificationController.getInstance().showUgcReportSuccess((String)localObject1);
              }
            }
          }
          catch (Exception paramAnonymousJSONObject)
          {
            for (;;)
            {
              try
              {
                if (UgcReportNaviSubDetailPresenter.this.infoPackage.voicePath != null) {
                  FileUtils.del(UgcReportNaviSubDetailPresenter.this.infoPackage.voicePath);
                }
                if (UgcReportNaviSubDetailPresenter.this.infoPackage.photoPicPath != null) {
                  FileUtils.del(UgcReportNaviSubDetailPresenter.this.infoPackage.photoPicPath);
                }
                if (UgcReportNaviSubDetailPresenter.this.infoPackage.screenshotPicPath != null) {
                  FileUtils.del(UgcReportNaviSubDetailPresenter.this.infoPackage.screenshotPicPath);
                }
                return;
              }
              catch (IOException paramAnonymousJSONObject)
              {
                paramAnonymousJSONObject.printStackTrace();
              }
              paramAnonymousJSONObject = paramAnonymousJSONObject;
              paramAnonymousJSONObject.printStackTrace();
              localObject1 = localObject2;
              continue;
              RGNotificationController.getInstance().showUgcReportSuccess("上报成功！");
              continue;
              if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "上报成功！");
              } else {
                TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), "上报成功！");
              }
            }
          }
        }
      });
      return;
      bool = false;
    }
  }
  
  private void startTimesCounts()
  {
    if ((this.coutTimesHandler != null) || (this.hasStopCount)) {
      return;
    }
    if (this.coutTimesHandler == null) {
      this.coutTimesHandler = new Handler(Looper.getMainLooper())
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          if (UgcReportNaviSubDetailPresenter.this.coutTimesHandler == null) {
            return;
          }
          UgcReportNaviSubDetailPresenter.this.coutTimesHandler.removeMessages(256);
          int i = paramAnonymousMessage.arg1 - 1;
          if (i <= 0)
          {
            UgcReportNaviSubDetailPresenter.this.mRootView.showCurTimes(i);
            UgcReportNaviSubDetailPresenter.this.simpleUpload();
            return;
          }
          UgcReportNaviSubDetailPresenter.this.mRootView.showCurTimes(i);
          UgcReportNaviSubDetailPresenter.this.coutTimesHandler.sendMessageDelayed(UgcReportNaviSubDetailPresenter.this.coutTimesHandler.obtainMessage(256, i, 0), 1000L);
        }
      };
    }
    this.mRootView.showCurTimes(10);
    this.coutTimesHandler.sendMessageDelayed(this.coutTimesHandler.obtainMessage(256, 10, 0), 1000L);
  }
  
  private void stopTimesCounts()
  {
    if (this.coutTimesHandler != null)
    {
      this.coutTimesHandler.removeMessages(256);
      this.coutTimesHandler = null;
    }
    this.hasStopCount = true;
  }
  
  public void comUpload()
  {
    if ((this.mRootView == null) || (this.infoPackage == null)) {}
    for (;;)
    {
      return;
      if (!NetworkUtils.isNetworkAvailable(BNaviModuleManager.getContext()))
      {
        TipTool.onCreateToastDialog(BNaviModuleManager.getContext(), JarUtils.getResources().getString(1711670288));
        return;
      }
      stopTimesCounts();
      if (this.infoPackage.mark != 1) {
        realComUpload();
      }
      while (this.parPresenter != null)
      {
        this.parPresenter.finish();
        return;
        new UgcHttpsUtils().setScreenShotParam(this.mRootView.getOrientation(), new UgcHttpsUtils.ScreenShotCallBack()
        {
          public void onScreenShotCompleted(String paramAnonymousString)
          {
            UgcReportNaviSubDetailPresenter.this.infoPackage.screenshotPicPath = paramAnonymousString;
            UgcReportNaviSubDetailPresenter.this.realComUpload();
          }
        });
      }
    }
  }
  
  public void informRubPointAdsorb(String paramString1, String paramString2)
  {
    this.mRootView.showAddrInfoUpdate(paramString2, null);
    if (UgcReportNaviMainPresenter.statusPackage != null) {
      UgcReportNaviMainPresenter.statusPackage.name = paramString2;
    }
  }
  
  public void mainContentOnTouch(MotionEvent paramMotionEvent)
  {
    stopTimesCounts();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public boolean onBackPress()
  {
    simpleUpload();
    return true;
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if ((this.infoPackage.mark == 1) && (this.mRootView != null)) {
      this.mRootView.hideSubTitleIv();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void setRootView(UgcReportNaviSubDetailContract.View paramView)
  {
    super.setRootView(paramView);
    this.mRootView = paramView;
  }
  
  public void simpleUpload()
  {
    stopTimesCounts();
    if (this.parPresenter != null) {
      this.parPresenter.simpleUpload();
    }
  }
  
  public void start()
  {
    super.start();
    if (this.mRootView != null) {
      this.mRootView.initPresenterView();
    }
    startTimesCounts();
    if ((this.parPresenter != null) && (this.mRootView != null) && (this.parPresenter.getIsIpoNavi())) {
      this.mRootView.showIpoNaviView();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/ui/innavi/sub/UgcReportNaviSubDetailPresenter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */