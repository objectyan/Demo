package com.baidu.navisdk.module.ugc.ui.inmap.sub;

import android.content.Context;
import android.text.TextUtils;
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

public class UgcReportMapSubDetailView
  extends UgcReportMapSubDetailContract.View
{
  private View.OnClickListener clickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      switch (paramAnonymousView.getId())
      {
      }
      do
      {
        do
        {
          return;
        } while (UgcReportMapSubDetailView.this.mPresenter == null);
        UgcReportMapSubDetailView.this.mPresenter.showSelectorPointStatus();
        return;
      } while (UgcReportMapSubDetailView.this.mPresenter == null);
      UgcReportMapSubDetailView.this.mPresenter.ugcUpLoad();
    }
  };
  private int curState = 0;
  private View gobackView = null;
  private UgcReportMapSubDetailContract.Presenter mPresenter = null;
  private UgcCustomLinearScrollView mainContentLayout = null;
  private ViewGroup mapComContainer = null;
  private ViewGroup mapFullScreenContainer = null;
  private View positionChangeLayout = null;
  private TextView positionInfoTv = null;
  private View scrollLayout = null;
  private View selectPositionInfoTv = null;
  private Button uploadBtn = null;
  
  public UgcReportMapSubDetailView(Context paramContext)
  {
    super(paramContext);
    initView();
    initListener();
  }
  
  private void initListener()
  {
    if (this.positionChangeLayout != null) {
      this.positionChangeLayout.setOnClickListener(this.clickListener);
    }
    if (this.uploadBtn != null) {
      this.uploadBtn.setOnClickListener(this.clickListener);
    }
    if (this.mainContentLayout != null)
    {
      this.mainContentLayout.setScrollSupport(true);
      this.mainContentLayout.setOnStatusChangeListener(new UgcCustomLinearScrollView.OnStatusChangeListener()
      {
        public void onStatusChange(int paramAnonymousInt)
        {
          UgcReportMapSubDetailView.access$102(UgcReportMapSubDetailView.this, paramAnonymousInt);
          if (UgcReportMapSubDetailView.this.curState == 1)
          {
            UgcReportMapSubDetailView.this.showScrollDismissLayout();
            if (UgcReportMapSubDetailView.this.mPresenter != null) {
              UgcReportMapSubDetailView.this.mPresenter.hasShowSelectorPointStatus();
            }
          }
          do
          {
            return;
            UgcReportMapSubDetailView.this.showScrollShowLayout();
          } while (UgcReportMapSubDetailView.this.mPresenter == null);
          UgcReportMapSubDetailView.this.mPresenter.hasShowOriginPage();
        }
      });
    }
    if (this.mapComContainer != null) {
      this.mapComContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public void onGlobalLayout()
        {
          if (UgcReportMapSubDetailView.this.mPresenter != null) {
            UgcReportMapSubDetailView.this.mPresenter.informComHeight();
          }
        }
      });
    }
    this.mapComContainer.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        if ((paramAnonymousMotionEvent.getAction() != 0) || (UgcReportMapSubDetailView.this.isSelectPointViewShowing())) {
          return false;
        }
        if (UgcReportMapSubDetailView.this.mPresenter != null) {
          UgcReportMapSubDetailView.this.mPresenter.showSelectorPointStatus();
        }
        return true;
      }
    });
    if (this.gobackView != null) {
      this.gobackView.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          if ((paramAnonymousMotionEvent.getAction() == 0) && (UgcReportMapSubDetailView.this.mPresenter != null) && (!UgcReportMapSubDetailView.this.mPresenter.onBackPress())) {
            UgcReportMapSubDetailView.this.mPresenter.goback();
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
      this.mainContentLayout = ((UgcCustomLinearScrollView)this.rootView.findViewById(1711867138));
      this.positionChangeLayout = this.rootView.findViewById(1711867145);
      this.scrollLayout = this.rootView.findViewById(1711866994);
      this.positionInfoTv = ((TextView)this.rootView.findViewById(1711867143));
      this.mapComContainer = ((ViewGroup)this.rootView.findViewById(1711866985));
      this.mapFullScreenContainer = ((ViewGroup)this.rootView.findViewById(1711867136));
      this.uploadBtn = ((Button)this.rootView.findViewById(1711867191));
      this.gobackView = this.rootView.findViewById(1711867196);
      this.selectPositionInfoTv = this.rootView.findViewById(1711867144);
      if (this.positionChangeLayout != null) {
        this.positionChangeLayout.setVisibility(0);
      }
      if (this.mapComContainer != null) {
        this.mapComContainer.setVisibility(0);
      }
      if (this.uploadBtn != null) {
        this.uploadBtn.setVisibility(0);
      }
      if (this.gobackView != null) {
        this.gobackView.setVisibility(0);
      }
    } while (this.mapFullScreenContainer == null);
    this.mapFullScreenContainer.setVisibility(4);
  }
  
  private void showScrollDismissLayout()
  {
    if (this.positionChangeLayout != null) {
      this.positionChangeLayout.setVisibility(8);
    }
    if ((this.selectPositionInfoTv != null) && (this.positionInfoTv != null))
    {
      this.selectPositionInfoTv.setVisibility(0);
      this.positionInfoTv.setVisibility(8);
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
    if (this.selectPositionInfoTv != null)
    {
      this.selectPositionInfoTv.setVisibility(8);
      this.positionInfoTv.setVisibility(0);
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
    if ((this.laneLayout != null) && (this.mPresenter != null) && (this.mPresenter.isRoadBuild())) {
      this.laneLayout.setVisibility(8);
    }
  }
  
  public boolean isSelectPointViewShowing()
  {
    if (this.mainContentLayout != null) {
      return this.mainContentLayout.getCurStatus() == 1;
    }
    return false;
  }
  
  public void setPresenter(SubContentContract.Presenter paramPresenter)
  {
    super.setPresenter(paramPresenter);
    this.mPresenter = ((UgcReportMapSubDetailContract.Presenter)paramPresenter);
  }
  
  public void showAddrInfoUpdate(String paramString1, String paramString2)
  {
    if (this.positionInfoTv != null)
    {
      TextView localTextView = this.positionInfoTv;
      paramString2 = paramString1;
      if (TextUtils.isEmpty(paramString1)) {
        paramString2 = "地图上的点";
      }
      localTextView.setText(paramString2);
    }
  }
  
  public void showOriginPage()
  {
    if ((this.mainContentLayout != null) && (this.mainContentLayout.gotoTop()))
    {
      showScrollShowLayout();
      if (this.mPresenter != null) {
        this.mPresenter.hasShowOriginPage();
      }
    }
  }
  
  public void showSelectorPointStatus()
  {
    hideInputMethod();
    if ((this.mainContentLayout != null) && (this.mainContentLayout.gotoBottom()))
    {
      showScrollDismissLayout();
      if (this.mPresenter != null) {
        this.mPresenter.hasShowSelectorPointStatus();
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/ui/inmap/sub/UgcReportMapSubDetailView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */