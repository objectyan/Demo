package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.subview.RGMMBlueToothUSBGuideView;
import com.baidu.navisdk.ui.routeguide.model.RGCacheStatus;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;

public class BNVolumeAdjustDialog
  extends BNVolumeKeyDownDialog
{
  private static final String TAG = BNVolumeAdjustDialog.class.getSimpleName();
  private static volatile boolean runFlag = true;
  private Activity mActivity;
  private ImageView mBTUSBCarImageView = null;
  private TextView mBTUSBCarTextView = null;
  private TextView mBTUSBDescribeTextView = null;
  private ImageView mBTUSBImageView = null;
  private LinearLayout mBTUSBLayout = null;
  private View mBTUSBSplitView = null;
  private TextView mBTUSBTextView = null;
  private BNWorkerNormalTask<String, String> mDisapperVolumeTask = new BNWorkerNormalTask("mDisapperVolumeTask-" + getClass().getSimpleName(), null)
  {
    protected String execute()
    {
      BNVolumeAdjustDialog.this.dismiss();
      if (BNVolumeAdjustDialog.this.mRGRLVolume != null) {
        BNVolumeAdjustDialog.this.mRGRLVolume.setVisibility(8);
      }
      return null;
    }
  };
  private ImageView mRGIVVolume;
  private LinearLayout mRGLLVolume;
  private ProgressBar mRGPBVolume;
  private RelativeLayout mRGRLVolume;
  
  public BNVolumeAdjustDialog(Activity paramActivity)
  {
    super(paramActivity, 16973840);
    requestWindowFeature(1);
    Window localWindow = getWindow();
    localWindow.setBackgroundDrawableResource(17170445);
    localWindow.clearFlags(2);
    try
    {
      paramActivity = JarUtils.inflate(paramActivity, 1711472784, null);
      if (paramActivity == null) {
        return;
      }
    }
    catch (Exception paramActivity)
    {
      for (;;)
      {
        paramActivity = null;
      }
      setContentView(paramActivity);
      setCanceledOnTouchOutside(false);
      setCancelable(true);
      this.mRGRLVolume = ((RelativeLayout)findViewById(1711867317));
      this.mRGPBVolume = ((ProgressBar)findViewById(1711867320));
      this.mRGIVVolume = ((ImageView)findViewById(1711867319));
      this.mRGLLVolume = ((LinearLayout)findViewById(1711867318));
      this.mBTUSBLayout = ((LinearLayout)findViewById(1711867322));
      this.mBTUSBSplitView = findViewById(1711867321);
      this.mBTUSBImageView = ((ImageView)findViewById(1711867323));
      this.mBTUSBTextView = ((TextView)findViewById(1711867324));
      this.mBTUSBCarImageView = ((ImageView)findViewById(1711867325));
      this.mBTUSBCarTextView = ((TextView)findViewById(1711867326));
      this.mBTUSBDescribeTextView = ((TextView)findViewById(1711867327));
      initListener();
      onUpdateStyle(BNStyleManager.getDayStyle());
      this.mRGRLVolume.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BNWorkerCenter.getInstance().cancelTask(BNVolumeAdjustDialog.this.mDisapperVolumeTask, false);
          BNVolumeAdjustDialog.this.dismiss();
        }
      });
    }
  }
  
  private void initListener()
  {
    if (this.mBTUSBDescribeTextView == null) {
      return;
    }
    this.mBTUSBDescribeTextView.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (paramAnonymousView == null) {
          return;
        }
        BNWorkerCenter.getInstance().cancelTask(BNVolumeAdjustDialog.this.mDisapperVolumeTask, false);
        BNVolumeAdjustDialog.this.dismiss();
        BNVolumeAdjustDialog.this.gotoBTUSBGuidePage(RGMMBlueToothUSBGuideView.sPanelContentType);
      }
    });
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void gotoBTUSBGuidePage(int paramInt)
  {
    if (paramInt == 1)
    {
      UserOPController.getInstance().add("3.r.3", "1", null, null);
      RGViewController.getInstance().showBlueToothUSBGuide();
    }
    while (paramInt != 2) {
      return;
    }
    UserOPController.getInstance().add("3.r.3", "2", null, null);
    RGViewController.getInstance().showBlueToothUSBGuide();
  }
  
  public void onBackPressed()
  {
    dismiss();
    if (this.mRGRLVolume != null) {
      this.mRGRLVolume.setVisibility(8);
    }
  }
  
  public void onDestory()
  {
    BNWorkerCenter.getInstance().cancelTask(this.mDisapperVolumeTask, false);
  }
  
  public void onOrientationChange()
  {
    dismiss();
    if (this.mRGRLVolume != null) {
      this.mRGRLVolume.setVisibility(8);
    }
  }
  
  public void onUpdateStyle(boolean paramBoolean)
  {
    if (this.mRGLLVolume != null) {
      this.mRGLLVolume.setBackgroundDrawable(BNStyleManager.getDrawable(1711407125));
    }
    if (this.mBTUSBSplitView != null)
    {
      if (paramBoolean) {
        this.mBTUSBSplitView.setBackgroundColor(Color.parseColor("#d6d6d6"));
      }
    }
    else
    {
      if (this.mBTUSBTextView != null)
      {
        if (!paramBoolean) {
          break label127;
        }
        this.mBTUSBTextView.setTextColor(Color.parseColor("#333333"));
      }
      label66:
      if (this.mBTUSBCarTextView != null)
      {
        if (!paramBoolean) {
          break label143;
        }
        this.mBTUSBCarTextView.setTextColor(Color.parseColor("#999999"));
      }
    }
    for (;;)
    {
      if (this.mBTUSBCarImageView != null) {
        this.mBTUSBCarImageView.setImageDrawable(BNStyleManager.getDrawable(1711408060));
      }
      return;
      this.mBTUSBSplitView.setBackgroundColor(Color.parseColor("#2b2d31"));
      break;
      label127:
      this.mBTUSBTextView.setTextColor(Color.parseColor("#dedede"));
      break label66;
      label143:
      this.mBTUSBCarTextView.setTextColor(Color.parseColor("#6e6e6e"));
    }
  }
  
  public void setBTUSBContent(int paramInt)
  {
    if ((this.mBTUSBImageView == null) || (this.mBTUSBTextView == null)) {}
    do
    {
      return;
      if (paramInt == 1)
      {
        this.mBTUSBImageView.setImageDrawable(JarUtils.getResources().getDrawable(1711408059));
        this.mBTUSBTextView.setText(JarUtils.getResources().getString(1711669449));
        return;
      }
    } while (paramInt != 2);
    this.mBTUSBImageView.setImageDrawable(JarUtils.getResources().getDrawable(1711408062));
    this.mBTUSBTextView.setText(JarUtils.getResources().getString(1711669450));
  }
  
  public void showBTUSBPanel(boolean paramBoolean)
  {
    if ((this.mBTUSBLayout == null) || (this.mBTUSBSplitView == null)) {
      return;
    }
    if (paramBoolean)
    {
      this.mBTUSBLayout.setVisibility(0);
      this.mBTUSBSplitView.setVisibility(0);
      return;
    }
    this.mBTUSBLayout.setVisibility(8);
    this.mBTUSBSplitView.setVisibility(8);
  }
  
  public void showVolume(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5)
  {
    if ((this.mRGLLVolume == null) || (this.mRGIVVolume == null) || (this.mRGPBVolume == null)) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if (2 == RGCacheStatus.sOrientation)
    {
      localLayoutParams = (RelativeLayout.LayoutParams)this.mRGLLVolume.getLayoutParams();
      localLayoutParams.setMargins(ScreenUtil.getInstance().getHeightPixels() / 3 + ScreenUtil.getInstance().dip2px(58), ScreenUtil.getInstance().dip2px(8), ScreenUtil.getInstance().dip2px(58), 0);
      this.mRGLLVolume.setLayoutParams(localLayoutParams);
      BNWorkerCenter.getInstance().cancelTask(this.mDisapperVolumeTask, false);
      if (paramInt1 != 0) {
        break label310;
      }
      if (this.mRGIVVolume != null) {
        this.mRGIVVolume.setImageDrawable(BNStyleManager.getDrawable(1711407763));
      }
    }
    for (;;)
    {
      LogUtil.e(TAG, "curSystemVolume = " + paramInt1 + ", maxSystemVolume = " + paramInt2 + ", curSystemVolume * 100 / maxSystemVolume = " + paramInt1 * 100 / paramInt2);
      this.mRGPBVolume.setProgress(paramInt1 * 100 / paramInt2);
      this.mRGRLVolume.setVisibility(0);
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mDisapperVolumeTask, new BNWorkerConfig(100, 0), 3000L);
      return;
      localLayoutParams = (RelativeLayout.LayoutParams)this.mRGLLVolume.getLayoutParams();
      if ((paramInt4 > 0) && (paramInt5 > 0)) {}
      for (paramInt3 = ScreenUtil.getInstance().dip2px(8) + paramInt4 + paramInt5;; paramInt3 = ScreenUtil.getInstance().dip2px(160))
      {
        localLayoutParams.setMargins(ScreenUtil.getInstance().dip2px(58), paramInt3, ScreenUtil.getInstance().dip2px(58), 0);
        this.mRGLLVolume.setLayoutParams(localLayoutParams);
        break;
      }
      label310:
      if (this.mRGIVVolume != null) {
        this.mRGIVVolume.setImageDrawable(BNStyleManager.getDrawable(1711407821));
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNVolumeAdjustDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */