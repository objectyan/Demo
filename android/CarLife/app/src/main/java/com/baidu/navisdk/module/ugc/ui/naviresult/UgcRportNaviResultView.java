package com.baidu.navisdk.module.ugc.ui.naviresult;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.navisdk.module.ugc.ui.SubContentContract.Presenter;
import com.baidu.navisdk.module.ugc.ui.widget.UgcCustomLinearScrollView;
import com.baidu.navisdk.module.ugc.ui.widget.UgcCustomLinearScrollView.OnStatusChangeListener;
import com.baidu.navisdk.ui.widget.BNDialog;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;

public class UgcRportNaviResultView
  extends UgcRportNaviResultContract.View
{
  private static BNDialog mQuitReportDialog;
  private View.OnClickListener clickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (UgcRportNaviResultView.this.mPresenter == null) {
        return;
      }
      switch (paramAnonymousView.getId())
      {
      default: 
        return;
      case 1711867145: 
        UgcRportNaviResultView.this.mPresenter.gotoDtailView();
        return;
      }
      UgcRportNaviResultView.this.mPresenter.secondUpload();
    }
  };
  private int curState = 0;
  private View gobackView = null;
  private UgcRportNaviResultContract.Presenter mPresenter;
  private UgcCustomLinearScrollView mainContentLayout = null;
  private ViewGroup mapComContainer = null;
  private boolean mapComContainerReady = false;
  private ViewGroup mapFullScreenContainer = null;
  private TextView newRoadtipsTv;
  private View positionChangeLayout = null;
  private TextView positionInfoTv = null;
  private View scrollLayout = null;
  private Button uploadBtn = null;
  
  public UgcRportNaviResultView(Context paramContext)
  {
    super(paramContext);
    initView();
    initListener();
  }
  
  /* Error */
  public static void dismissQuitReportDialog(Activity paramActivity)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 104	com/baidu/navisdk/module/ugc/ui/naviresult/UgcRportNaviResultView:mQuitReportDialog	Lcom/baidu/navisdk/ui/widget/BNDialog;
    //   6: ifnull +37 -> 43
    //   9: aload_0
    //   10: ifnull +33 -> 43
    //   13: aload_0
    //   14: invokevirtual 110	android/app/Activity:isFinishing	()Z
    //   17: ifne +26 -> 43
    //   20: getstatic 104	com/baidu/navisdk/module/ugc/ui/naviresult/UgcRportNaviResultView:mQuitReportDialog	Lcom/baidu/navisdk/ui/widget/BNDialog;
    //   23: invokevirtual 115	com/baidu/navisdk/ui/widget/BNDialog:isShowing	()Z
    //   26: ifeq +9 -> 35
    //   29: getstatic 104	com/baidu/navisdk/module/ugc/ui/naviresult/UgcRportNaviResultView:mQuitReportDialog	Lcom/baidu/navisdk/ui/widget/BNDialog;
    //   32: invokevirtual 118	com/baidu/navisdk/ui/widget/BNDialog:dismiss	()V
    //   35: aconst_null
    //   36: putstatic 104	com/baidu/navisdk/module/ugc/ui/naviresult/UgcRportNaviResultView:mQuitReportDialog	Lcom/baidu/navisdk/ui/widget/BNDialog;
    //   39: ldc 2
    //   41: monitorexit
    //   42: return
    //   43: aconst_null
    //   44: putstatic 104	com/baidu/navisdk/module/ugc/ui/naviresult/UgcRportNaviResultView:mQuitReportDialog	Lcom/baidu/navisdk/ui/widget/BNDialog;
    //   47: goto -8 -> 39
    //   50: astore_0
    //   51: ldc 2
    //   53: monitorexit
    //   54: aload_0
    //   55: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	56	0	paramActivity	Activity
    // Exception table:
    //   from	to	target	type
    //   3	9	50	finally
    //   13	35	50	finally
    //   35	39	50	finally
    //   43	47	50	finally
  }
  
  private void initListener()
  {
    if (this.positionChangeLayout != null)
    {
      View localView = this.positionChangeLayout;
      this.positionChangeLayout.setOnClickListener(this.clickListener);
    }
    if (this.uploadBtn != null) {
      this.uploadBtn.setOnClickListener(this.clickListener);
    }
    if (this.mapComContainer != null) {
      this.mapComContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public void onGlobalLayout()
        {
          if (UgcRportNaviResultView.this.mPresenter != null)
          {
            UgcRportNaviResultView.access$402(UgcRportNaviResultView.this, true);
            UgcRportNaviResultView.this.mPresenter.informComHeight();
          }
        }
      });
    }
    this.mapComContainer.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if ((paramAnonymousMotionEvent.getAction() != 0) || (UgcRportNaviResultView.this.isSelectPointViewShowing())) {
          return false;
        }
        if ((UgcRportNaviResultView.this.mPresenter != null) && (UgcRportNaviResultView.this.mPresenter.isInNewRoad()))
        {
          UgcRportNaviResultView.this.mPresenter.gotoDtailView();
          return true;
        }
        if (UgcRportNaviResultView.this.mPresenter != null) {
          UgcRportNaviResultView.this.mPresenter.finish();
        }
        return true;
      }
    });
    if (this.gobackView != null) {
      this.gobackView.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          if ((paramAnonymousMotionEvent.getAction() == 0) && (UgcRportNaviResultView.this.mPresenter != null) && (!UgcRportNaviResultView.this.mPresenter.onBackPress())) {
            UgcRportNaviResultView.this.mPresenter.finish();
          }
          return true;
        }
      });
    }
  }
  
  private void initView()
  {
    if (this.rootView == null) {}
    do
    {
      return;
      this.scrollLayout = this.rootView.findViewById(1711866994);
      this.mainContentLayout = ((UgcCustomLinearScrollView)this.rootView.findViewById(1711867138));
      this.positionInfoTv = ((TextView)this.rootView.findViewById(1711867143));
      this.mapComContainer = ((ViewGroup)this.rootView.findViewById(1711866985));
      this.mapFullScreenContainer = ((ViewGroup)this.rootView.findViewById(1711867136));
      this.uploadBtn = ((Button)this.rootView.findViewById(1711867191));
      this.positionChangeLayout = this.rootView.findViewById(1711867145);
      this.rootView.findViewById(1711867140).setVisibility(8);
      this.newRoadtipsTv = ((TextView)this.rootView.findViewById(1711867142));
      this.gobackView = this.rootView.findViewById(1711867196);
      if (this.mapComContainer != null) {
        this.mapComContainer.setVisibility(0);
      }
      if (this.mapComContainer != null)
      {
        this.mapComContainer.setBackgroundColor(-16777216);
        this.mapComContainer.getBackground().setAlpha(66);
      }
    } while (this.uploadBtn == null);
    this.uploadBtn.setVisibility(0);
  }
  
  public static void showQuitReportDialog(Activity paramActivity, final CallBack paramCallBack)
  {
    if (paramActivity != null) {}
    try
    {
      if (!paramActivity.isFinishing())
      {
        if (mQuitReportDialog == null) {
          mQuitReportDialog = new BNDialog(paramActivity).setTitleText(null).setContentMessage("您有未补充的上报\n是否放弃?").setContentCenter().setFirstBtnText(Html.fromHtml("<font color=\"#333333\">放弃补充</font>")).setOnFirstBtnClickListener(new BNDialog.OnNaviClickListener()
          {
            public void onClick()
            {
              UgcRportNaviResultView.dismissQuitReportDialog(this.val$activity);
              if (paramCallBack != null) {
                paramCallBack.quitUgcPage();
              }
            }
          }).setSecondBtnText(Html.fromHtml("<font color=\"#333333\">取消</font>")).setOnSecondBtnClickListener(new BNDialog.OnNaviClickListener()
          {
            public void onClick()
            {
              UgcRportNaviResultView.dismissQuitReportDialog(this.val$activity);
            }
          });
        }
        mQuitReportDialog.show();
      }
      return;
    }
    finally {}
  }
  
  private void showScrollDismissLayout()
  {
    if (this.positionChangeLayout != null) {
      this.positionChangeLayout.setVisibility(8);
    }
    if (this.mapFullScreenContainer != null) {
      this.mapFullScreenContainer.setVisibility(0);
    }
  }
  
  private void showScrollShowLayout()
  {
    if (this.positionChangeLayout != null) {
      this.positionChangeLayout.setVisibility(0);
    }
    if (this.mapFullScreenContainer != null) {
      this.mapFullScreenContainer.setVisibility(4);
    }
  }
  
  public ViewGroup getMapComPanelContainer()
  {
    return this.mapComContainer;
  }
  
  public ViewGroup getMapFullScreenContainer()
  {
    return this.mapFullScreenContainer;
  }
  
  public void initPresenterView()
  {
    super.initPresenterView();
  }
  
  public boolean isSelectPointViewShowing()
  {
    if (this.mainContentLayout != null) {
      return this.mainContentLayout.getCurStatus() == 1;
    }
    return false;
  }
  
  public void setNewRoadSelectStatus(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
    case 1: 
      do
      {
        do
        {
          return;
          if (this.mapComContainer != null) {
            this.mapComContainer.getBackground().setAlpha(0);
          }
          showSelectorPointStatus();
          if (this.mapFullScreenContainer != null) {
            this.mapFullScreenContainer.setVisibility(0);
          }
          if (this.newRoadtipsTv != null)
          {
            this.newRoadtipsTv.setVisibility(0);
            this.newRoadtipsTv.setText("在图区确定新路起点");
          }
        } while (this.positionInfoTv == null);
        this.positionInfoTv.setVisibility(8);
        return;
      } while (this.newRoadtipsTv == null);
      this.newRoadtipsTv.setVisibility(0);
      this.newRoadtipsTv.setText("在图区确定新路终点");
      return;
    }
    if (this.mapFullScreenContainer != null) {
      this.mapFullScreenContainer.setVisibility(8);
    }
    if (this.newRoadtipsTv != null) {
      this.newRoadtipsTv.setVisibility(8);
    }
    if (this.positionInfoTv != null) {
      this.positionInfoTv.setVisibility(0);
    }
    showOriginPage();
  }
  
  public void setPresenter(SubContentContract.Presenter paramPresenter)
  {
    super.setPresenter(paramPresenter);
    this.mPresenter = ((UgcRportNaviResultContract.Presenter)paramPresenter);
  }
  
  public void showAddrInfoUpdate(String paramString1, String paramString2)
  {
    if (this.positionInfoTv != null) {
      this.positionInfoTv.setText(paramString1);
    }
  }
  
  public void showNewRoadLayoutView(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      showPositionChangeLayout(true);
      this.gobackView.setVisibility(0);
      return;
    }
    showPositionChangeLayout(false);
  }
  
  public void showOriginPage()
  {
    if (!this.mapComContainerReady) {}
    while (this.mainContentLayout == null) {
      return;
    }
    if (this.mainContentLayout.gotoTop())
    {
      this.curState = 0;
      showScrollShowLayout();
      return;
    }
    this.curState = 1;
  }
  
  public void showPositionChangeLayout(boolean paramBoolean)
  {
    if (this.positionChangeLayout != null)
    {
      if (paramBoolean) {
        this.positionChangeLayout.setVisibility(0);
      }
    }
    else {
      return;
    }
    this.positionChangeLayout.setVisibility(8);
  }
  
  public void showSelectorPointStatus()
  {
    if (!this.mapComContainerReady) {}
    while (this.mainContentLayout == null) {
      return;
    }
    if (this.mainContentLayout.gotoBottom())
    {
      this.curState = 1;
      showScrollDismissLayout();
      return;
    }
    this.curState = 0;
  }
  
  public void supportScrollView()
  {
    if (this.mainContentLayout != null)
    {
      this.mainContentLayout.setScrollSupport(true);
      this.mainContentLayout.setOnStatusChangeListener(new UgcCustomLinearScrollView.OnStatusChangeListener()
      {
        public void onStatusChange(int paramAnonymousInt)
        {
          UgcRportNaviResultView.access$102(UgcRportNaviResultView.this, paramAnonymousInt);
          if (UgcRportNaviResultView.this.curState == 1)
          {
            UgcRportNaviResultView.this.showScrollDismissLayout();
            if (UgcRportNaviResultView.this.mPresenter != null) {
              UgcRportNaviResultView.this.mPresenter.hasShowSelectorPointStatus();
            }
          }
          do
          {
            return;
            UgcRportNaviResultView.this.showScrollShowLayout();
          } while (UgcRportNaviResultView.this.mPresenter == null);
          UgcRportNaviResultView.this.mPresenter.hasShowOriginPage();
        }
      });
    }
  }
  
  public static abstract interface CallBack
  {
    public abstract void quitUgcPage();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/ui/naviresult/UgcRportNaviResultView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */