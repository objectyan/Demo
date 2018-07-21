package com.baidu.navisdk.ui.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.media.AudioManager;
import android.view.KeyEvent;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController.VolumeChangeListener;
import com.baidu.navisdk.util.statistic.userop.UserOPController;

public abstract class BNVolumeKeyDownDialog
  extends Dialog
{
  Activity mActivity;
  
  public BNVolumeKeyDownDialog(Context paramContext)
  {
    super(paramContext);
    this.mActivity = ((Activity)paramContext);
  }
  
  public BNVolumeKeyDownDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.mActivity = ((Activity)paramContext);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    AudioManager localAudioManager = (AudioManager)this.mActivity.getSystemService("audio");
    int i = localAudioManager.getStreamVolume(3);
    int j = localAudioManager.getStreamMaxVolume(3);
    switch (paramInt)
    {
    default: 
      bool = false;
    case 24: 
    case 25: 
      do
      {
        do
        {
          return bool;
          if (RGMapModeViewController.getInstance().getVolumeChangeListener() != null) {
            i = RGMapModeViewController.getInstance().getVolumeChangeListener().onVolumeUpKeyDown(localAudioManager, j);
          }
          UserOPController.getInstance().appendContinuousOP("3.ka");
        } while (i <= 0);
        RGMapModeViewController.getInstance().updateLowVolumeView(false);
        return true;
        if (RGMapModeViewController.getInstance().getVolumeChangeListener() != null) {
          i = RGMapModeViewController.getInstance().getVolumeChangeListener().onVolumeDownKeyDown(localAudioManager, j);
        }
        UserOPController.getInstance().appendContinuousOP("3.kb");
      } while (i != 0);
      RGMapModeViewController.getInstance().updateLowVolumeView(true);
      return true;
    }
    super.onKeyDown(paramInt, paramKeyEvent);
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/widget/BNVolumeKeyDownDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */