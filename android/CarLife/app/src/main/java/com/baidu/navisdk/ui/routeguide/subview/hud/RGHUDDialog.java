package com.baidu.navisdk.ui.routeguide.subview.hud;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.ui.routeguide.fsm.RouteGuideFSM;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.subview.util.RGAnimUtil;
import com.baidu.navisdk.ui.routeguide.subview.util.RGAnimUtil.IAnimationLister;
import com.baidu.navisdk.ui.widget.BNVolumeKeyDownDialog;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import java.lang.ref.WeakReference;

public class RGHUDDialog
  extends BNVolumeKeyDownDialog
  implements View.OnClickListener
{
  private static final int HUD_MODEL_MIRROR = 1;
  private static final int HUD_MODEL_NOT_MIRROR = 3;
  private Animation.AnimationListener animListener;
  private boolean isAnimShowing = false;
  private Activity mActivity;
  private TextView mHudBack;
  private TextView mHudBtn;
  private TextView mHudDirection;
  private TextView mHudMirror;
  private RGHUDView mHudView;
  private boolean mIsMirror = false;
  private TextView mMapBack;
  private FadeHandler mPopupFader = null;
  
  public RGHUDDialog(Activity paramActivity, int paramInt, boolean paramBoolean)
  {
    super(paramActivity, paramInt);
    this.mActivity = paramActivity;
    requestWindowFeature(1);
    initView();
    this.mPopupFader = new FadeHandler(this);
    this.animListener = new Animation.AnimationListener()
    {
      public void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        RGHUDDialog.access$502(RGHUDDialog.this, false);
      }
      
      public void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public void onAnimationStart(Animation paramAnonymousAnimation)
      {
        RGHUDDialog.access$502(RGHUDDialog.this, true);
      }
    };
    setIsMirror(paramBoolean);
  }
  
  private void hideBtns()
  {
    Animation localAnimation = JarUtils.loadAnimation(BNaviModuleManager.getContext(), 1711538180);
    localAnimation.setAnimationListener(this.animListener);
    this.mHudBtn.setAnimation(localAnimation);
    this.mMapBack.setAnimation(localAnimation);
    this.mHudBtn.setVisibility(4);
    this.mMapBack.setVisibility(4);
    this.mMapBack.setClickable(false);
    this.mHudBtn.setClickable(false);
  }
  
  private void hideMirrorBackBtn()
  {
    this.mHudMirror.setVisibility(8);
    this.mHudMirror.setClickable(false);
    this.mHudBack.setVisibility(8);
    this.mHudBack.setClickable(false);
  }
  
  private void initView()
  {
    setContentView(JarUtils.inflate(this.mActivity, 1711472700, null));
    this.mHudView = ((RGHUDView)findViewById(1711866377));
    this.mHudBtn = ((TextView)findViewById(1711866381));
    this.mHudMirror = ((TextView)findViewById(1711866382));
    this.mHudBack = ((TextView)findViewById(1711866380));
    this.mMapBack = ((TextView)findViewById(1711866379));
    this.mHudMirror.setOnClickListener(this);
    this.mHudBack.setOnClickListener(this);
    this.mMapBack.setOnClickListener(this);
    this.mHudBtn.setOnClickListener(this);
    this.mHudView.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if ((paramAnonymousMotionEvent.getAction() == 0) && (!RGHUDDialog.this.mIsMirror)) {
          if (!RGHUDDialog.this.isAnimShowing) {}
        }
        do
        {
          return true;
          if (RGHUDDialog.this.mHudBtn.getVisibility() == 0)
          {
            RGHUDDialog.this.hideBtns();
            return true;
          }
          BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410287", "410287");
          RGHUDDialog.this.showBtns();
          RGHUDDialog.this.mPopupFader.sendEmptyMessage(3);
          return true;
          if ((paramAnonymousMotionEvent.getAction() != 0) || (!RGHUDDialog.this.mIsMirror)) {
            break;
          }
        } while (RGHUDDialog.this.isAnimShowing);
        if (RGHUDDialog.this.mHudBack.getVisibility() == 0) {
          RGHUDDialog.this.hideMirrorBackBtn();
        }
        for (;;)
        {
          return false;
          BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410287", "410287");
          RGHUDDialog.this.showMirrorBackBtn();
          RGHUDDialog.this.mPopupFader.sendEmptyMessage(1);
        }
      }
    });
  }
  
  private void setIsMirror(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mHudView.setMirror(true);
      this.mHudView.invalidate();
      hideBtns();
      showMirrorBackBtn();
      return;
    }
    this.mHudView.setMirror(false);
    this.mHudView.invalidate();
    showBtns();
    hideMirrorBackBtn();
  }
  
  private void showBtns()
  {
    Animation localAnimation = JarUtils.loadAnimation(BNaviModuleManager.getContext(), 1711538179);
    localAnimation.setAnimationListener(this.animListener);
    this.mHudBtn.setAnimation(localAnimation);
    this.mMapBack.setAnimation(localAnimation);
    this.mHudBtn.setVisibility(0);
    this.mMapBack.setVisibility(0);
    this.mMapBack.setClickable(true);
    this.mHudBtn.setClickable(true);
  }
  
  private void showMirrorBackBtn()
  {
    this.mHudMirror.setVisibility(0);
    this.mHudMirror.setClickable(true);
    this.mHudBack.setVisibility(0);
    this.mHudBack.setClickable(true);
  }
  
  public void gpsSignalRecover()
  {
    this.mHudView.gpsSignalRecover();
  }
  
  public void justSetDirectRoadInfoVisibility(boolean paramBoolean)
  {
    this.mHudView.updateDirectRoadInfoVisibility(paramBoolean);
  }
  
  public void justSetHighWayVisibility(boolean paramBoolean)
  {
    this.mHudView.updateHighWayVisibility(paramBoolean);
  }
  
  public void justSetNormalRoadInfoVisibility(boolean paramBoolean)
  {
    this.mHudView.updateNormalRoadInfoVisibility(paramBoolean);
  }
  
  public void lostGPSSignal()
  {
    this.mHudView.lostGPSSignal();
  }
  
  public void onBackPressed()
  {
    dismiss();
    RouteGuideFSM.getInstance().run("[返回]按钮点击");
    super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 1711866379)
    {
      BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410289", "410289");
      RouteGuideFSM.getInstance().run("[返回]按钮点击");
      paramView = RGSimpleGuideModel.getInstance().getNextGuideInfo();
      if ((paramView != null) && (paramView.getInt("resid", 0) > 0)) {}
      RGAnimUtil.setAnimationListener(new RGAnimUtil.IAnimationLister()
      {
        public void onEnd1() {}
        
        public void onEnd2()
        {
          RGHUDDialog.this.onBackPressed();
        }
      });
    }
    do
    {
      return;
      if (paramView.getId() == 1711866381)
      {
        UserOPController.getInstance().add("3.8.1");
        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410291", "410291");
        RouteGuideFSM.getInstance().run("从HUD去HUD镜像页");
        return;
      }
      if (paramView.getId() == 1711866382)
      {
        UserOPController.getInstance().add("3.8.1");
        BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410291", "410291");
        RouteGuideFSM.getInstance().run("从HUD镜像页回到HUD");
        return;
      }
    } while ((paramView.getId() != 1711866380) || (!this.mIsMirror));
    BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410289", "410289");
    RouteGuideFSM.getInstance().run("[返回]按钮点击");
  }
  
  public void onOrientationChanged()
  {
    if (this.mHudView != null) {
      this.mHudView.onOrientationChanged();
    }
  }
  
  public void setDirectRemainDistance(String paramString)
  {
    this.mHudView.setDirectDistance(paramString);
  }
  
  public void setDirectRoadName(String paramString)
  {
    this.mHudView.setDirectCurrentRoad(paramString);
  }
  
  public void setDirection(String paramString)
  {
    this.mHudView.setDirection(paramString);
  }
  
  public void setHighWayExitCode(String paramString)
  {
    this.mHudView.setHighWayExitCode(paramString);
  }
  
  public void setHighWayExitRoad(String paramString)
  {
    this.mHudView.setHighWayExitRoad(paramString);
  }
  
  public void setHighWayRemainDistance(String paramString)
  {
    this.mHudView.setHighWayRemainDistance(paramString);
  }
  
  public void setHighWayTurnIcon(int paramInt)
  {
    this.mHudView.setHighWayTurnIcon(paramInt);
  }
  
  public void setMirrorFlagBeforeShow(boolean paramBoolean)
  {
    this.mIsMirror = paramBoolean;
  }
  
  public void setNormalGoMeters(String paramString)
  {
    this.mHudView.setNormalGoMeters(paramString);
  }
  
  public void setRemainDistance(String paramString) {}
  
  public void setRoadName(String paramString)
  {
    this.mHudView.setNormalCurrentRoad(paramString);
  }
  
  public void setTurnIcon(int paramInt)
  {
    this.mHudView.setNormalTurnIcon(paramInt);
  }
  
  public void show()
  {
    super.show();
    setIsMirror(this.mIsMirror);
    if (this.mIsMirror) {
      this.mPopupFader.sendEmptyMessage(1);
    }
    for (;;)
    {
      onOrientationChanged();
      return;
      this.mPopupFader.sendEmptyMessage(3);
    }
  }
  
  public void updateCurrentCarSpeed()
  {
    this.mHudView.updateCurrentCarSpeed();
  }
  
  public void updateHighWayAlongVisibility(boolean paramBoolean)
  {
    this.mHudView.updateHighWayAlongVisibility(paramBoolean);
  }
  
  public void updateHudLocate(boolean paramBoolean)
  {
    this.mHudView.updateHudView(paramBoolean);
  }
  
  public void updateHudYaw(boolean paramBoolean)
  {
    this.mHudView.updateHudYaw(paramBoolean);
  }
  
  public void updateTotalRemainInfo()
  {
    this.mHudView.updateTotalRemainInfo();
  }
  
  private static class FadeHandler
    extends Handler
  {
    private final BNWorkerNormalTask<String, String> mFadeTask = new BNWorkerNormalTask("FadeTask", null)
    {
      protected String execute()
      {
        RGHUDDialog localRGHUDDialog = (RGHUDDialog)RGHUDDialog.FadeHandler.this.outterCxt.get();
        if (localRGHUDDialog == null) {
          return null;
        }
        if (RGHUDDialog.FadeHandler.this.mHudState == 1)
        {
          localRGHUDDialog.hideMirrorBackBtn();
          return null;
        }
        localRGHUDDialog.hideBtns();
        return null;
      }
    };
    private int mHudState;
    private WeakReference<RGHUDDialog> outterCxt;
    
    public FadeHandler(RGHUDDialog paramRGHUDDialog)
    {
      this.outterCxt = new WeakReference(paramRGHUDDialog);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if ((RGHUDDialog)this.outterCxt.get() == null) {
        return;
      }
      this.mHudState = paramMessage.what;
      BNWorkerCenter.getInstance().cancelTask(this.mFadeTask, false);
      BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mFadeTask, new BNWorkerConfig(2, 0), 5000L);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/subview/hud/RGHUDDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */