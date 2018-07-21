package com.baidu.navi.controller;

import android.os.Handler;
import android.os.Looper;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.screen.b;
import com.baidu.carlife.core.screen.e;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.carlife.view.dialog.c;
import com.baidu.navisdk.comapi.offlinedata.BNOfflineDataManager;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.NetworkUtils;

public class CommonController
{
  private CarlifeActivity mActivity;
  private c mDataInfoDialog;
  private e mDialogListener;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  
  public CommonController(CarlifeActivity paramCarlifeActivity, e parame)
  {
    this.mActivity = paramCarlifeActivity;
    this.mDialogListener = parame;
  }
  
  public boolean checkOfflineDataOrNetwork()
  {
    if (isNeedShowDialog())
    {
      showNoNetAndOfflineDataDialog();
      return false;
    }
    return true;
  }
  
  public void dismissNoNetAndOfflineDataDialog()
  {
    if ((this.mActivity == null) || (this.mDataInfoDialog == null) || (this.mDialogListener == null) || (!this.mDialogListener.isDialogShown())) {
      return;
    }
    this.mDialogListener.dismissDialog(this.mDataInfoDialog);
  }
  
  public boolean isNeedShowDialog()
  {
    return (!BNOfflineDataManager.getInstance().haveValidData()) && (!NetworkUtils.isNetworkAvailable(this.mActivity));
  }
  
  public void showNoNetAndOfflineDataDialog()
  {
    if ((this.mActivity == null) || (this.mActivity.isFinishing())) {
      return;
    }
    if (this.mDataInfoDialog == null) {
      this.mDataInfoDialog = new c(this.mActivity).b(2131296284).b(this.mActivity.getString(2131296281)).g(17).c(2131296288).q().a(new b()
      {
        public void onClick()
        {
          CommonController.this.mDialogListener.dismissDialog(CommonController.this.mDataInfoDialog);
          if (NetworkUtils.isNetworkAvailable(CommonController.this.mActivity)) {
            return;
          }
          TipTool.onCreateToastDialog(CommonController.this.mActivity, CommonController.this.mActivity.getString(2131296716));
          CommonController.this.mHandler.post(new Runnable()
          {
            public void run()
            {
              CommonController.this.showNoNetAndOfflineDataDialog();
            }
          });
        }
      }).d(2131296259).r().b(new b()
      {
        public void onClick()
        {
          h.a().back();
        }
      });
    }
    this.mDialogListener.showDialog(this.mDataInfoDialog);
  }
  
  public static abstract interface IDialogControllerListener
  {
    public abstract void onShowHomePage();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/controller/CommonController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */