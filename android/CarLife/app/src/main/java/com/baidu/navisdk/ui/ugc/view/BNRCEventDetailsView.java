package com.baidu.navisdk.ui.ugc.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.navisdk.module.ugc.ui.widget.TwoStateScrollView.DragState;
import com.baidu.navisdk.module.ugc.ui.widget.TwoStateScrollView.OnStatusChangeListener;
import com.baidu.navisdk.module.ugc.utils.UgcImageLoaderUtils;
import com.baidu.navisdk.ui.ugc.adapter.UgcDetailsAdapter;
import com.baidu.navisdk.ui.ugc.adapter.UgcDetailsAdapter.CommentsLoadingState;
import com.baidu.navisdk.ui.ugc.adapter.UgcDetailsAdapter.ImgDisplay;
import com.baidu.navisdk.ui.ugc.control.BNRCEventDetailsViewController;
import com.baidu.navisdk.ui.ugc.model.BNRCEventDetailsModel;
import com.baidu.navisdk.ui.ugc.model.BNRCEventDetailsModel.OutlineDataBuild;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.ui.util.UIUtils;
import com.baidu.navisdk.ui.widget.BNLoadingViewProxy.LoadingProxy;
import com.baidu.navisdk.ui.widget.BNLoadingViewProxy.ViewActionListener;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.PullToRefreshRecyclerView;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.PullToRefreshRecyclerView.PagingableListener;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.footer.loadmore.BaseLoadMoreView;
import com.baidu.navisdk.ui.widget.ptrrecyclerview.footer.loadmore.BaseLoadMoreView.OnDrawListener;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.drawable.UrlDrawableContainIView;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;

public class BNRCEventDetailsView
  implements View.OnClickListener
{
  private static final String TAG = "BNRCEventDetailsView";
  private View awayFromSpacing = null;
  private TextView awayFromTv = null;
  private View backContainer;
  private View bgContainer;
  private Bitmap bitmap;
  private boolean commentsPtrListInited = false;
  private View contentView = null;
  private View eventDescriptionLayout = null;
  private TextView eventPortraitIV = null;
  private TextView eventReporterCountsTV = null;
  private TextView eventReporterLevelTV = null;
  private View eventSubLayout = null;
  private View eventSubLayoutDivider = null;
  private TextView eventSubTv1 = null;
  private TextView eventSubTv2 = null;
  private ImageView icEventType;
  private ImageView imgThumbnail;
  private ImageView imgZoomIv;
  private View imgZoomViewContainer;
  private ViewGroup mCommentsLoadingFooterContainer;
  private BNLoadingViewProxy.ViewActionListener mCommentsLoadingListener = new BNLoadingViewProxy.ViewActionListener()
  {
    public void onAction(int paramAnonymousInt)
    {
      switch (paramAnonymousInt)
      {
      default: 
        return;
      }
      LogUtil.e("BNRCEventDetailsView", "mCommentsLoadingListener: --> ACTION_RETRY");
      BNRCEventDetailsView.this.initCommentsData();
    }
  };
  private View mCommentsPtrBg;
  private PullToRefreshRecyclerView mCommentsPtrList = null;
  private BNRCEventDetailsViewController mController = BNRCEventDetailsViewController.getInstance();
  private TwoStateScrollView.DragState mCurState = TwoStateScrollView.DragState.BOTTOM;
  private BNWorkerNormalTask<String, String> mEnablePullRunnable = new BNWorkerNormalTask("BNRCEventDetailsView-EnablePullTask", null)
  {
    protected String execute()
    {
      if (BNRCEventDetailsView.this.mCommentsPtrList != null)
      {
        BNRCEventDetailsView.this.mCommentsPtrList.setScrollSupport(true);
        BNRCEventDetailsView.this.mCommentsPtrList.onFinishLoading(true, false);
      }
      return null;
    }
  };
  private int mOrientation = 2;
  private BNLoadingViewProxy.ViewActionListener mOutlineLoadingListener = new BNLoadingViewProxy.ViewActionListener()
  {
    public void onAction(int paramAnonymousInt)
    {
      switch (paramAnonymousInt)
      {
      default: 
        return;
      }
      LogUtil.e("BNRCEventDetailsView", "mOutlineLoadingListener: --> ACTION_RETRY");
      BNRCEventDetailsView.this.initOutlineData();
    }
  };
  private UgcDetailsAdapter mUgcDetailsAdapter;
  private UgcRCEventCallback mUgcRCEventCallback = null;
  private ViewGroup outlineLoadingContainer;
  private View outlineViewContainer;
  private ViewGroup outlineViewContainerOuter;
  private TextView roadNameTv = null;
  private View rootView = null;
  private boolean scrollViewInited = false;
  private TextView timeIntervalTv = null;
  private View titleContainer;
  private TextView tvEventDescription;
  private TextView tvEventReporter;
  private TextView tvEventTimeStamp;
  private TextView tvEventType;
  private TextView tvUseful;
  private TextView tvUseless;
  private View userInfoLayout = null;
  private View vAvoidCongestion = null;
  private View vAvoidCongestionDivider;
  private View vUseful;
  private View vUseless;
  
  public BNRCEventDetailsView(Context paramContext, UgcRCEventCallback paramUgcRCEventCallback)
  {
    this(paramContext, paramUgcRCEventCallback, 1);
  }
  
  public BNRCEventDetailsView(Context paramContext, UgcRCEventCallback paramUgcRCEventCallback, int paramInt)
  {
    this.mOrientation = paramInt;
    this.mUgcRCEventCallback = paramUgcRCEventCallback;
    initViews(paramContext);
  }
  
  private void imgThumbnailButtonClick()
  {
    if (this.imgThumbnail != null) {
      this.imgThumbnail.performClick();
    }
  }
  
  private void initCommentsData()
  {
    if ((!this.commentsPtrListInited) && (!this.mController.asyncGetCommentsData()))
    {
      this.commentsPtrListInited = true;
      loadingStart(3);
      this.mController.initCommentsDataBuild();
    }
  }
  
  private void initCommentsList()
  {
    int i;
    if (this.mUgcDetailsAdapter == null)
    {
      this.mCommentsPtrList.setNeedStatusChangeAlways(true);
      this.mCommentsPtrList.setScrollSupport(true);
      switch (this.mController.getSource())
      {
      default: 
        this.titleContainer.setVisibility(0);
        i = JarUtils.getResources().getDimensionPixelOffset(1711734913);
        this.mCommentsPtrList.setTopMargin(i);
        i = (int)(ScreenUtil.getInstance().getHeightPixels() / 3.0D);
        this.mCommentsPtrList.setTitleContainer(this.titleContainer, i);
        this.mCommentsPtrList.setTitleAnimEnabled(true);
      }
    }
    for (;;)
    {
      this.mCommentsPtrList.setViewBg(this.mCommentsPtrBg);
      this.mCommentsPtrList.setEnableBg(true);
      this.mCommentsPtrList.setSwipeEnable(true);
      this.mCommentsPtrList.setLayoutManager(new LinearLayoutManager(this.mController.getContext()));
      this.mCommentsPtrList.setPagingableListener(new PullToRefreshRecyclerView.PagingableListener()
      {
        public void onLoadMoreItems()
        {
          LogUtil.e("BNRCEventDetailsView", "onLoadMoreItems:  --> ");
          if (LogUtil.LOGGABLE) {
            Toast.makeText(BNRCEventDetailsView.this.mController.getContext(), "onLoadMoreItems", 0).show();
          }
          UserOPController.getInstance().add("3.u.2.2", null, null, null);
          BNRCEventDetailsView.this.mController.asyncGetCommentsData();
        }
      });
      BaseLoadMoreView localBaseLoadMoreView = new BaseLoadMoreView(this.mController.getContext(), this.mCommentsPtrList.getRecyclerView());
      localBaseLoadMoreView.setLoadMorePadding(JarUtils.getResources().getDimensionPixelOffset(1711734916));
      this.mCommentsPtrList.setLoadMoreFooter(localBaseLoadMoreView);
      this.mCommentsPtrList.getLoadMoreFooter().setOnDrawListener(new BaseLoadMoreView.OnDrawListener()
      {
        public boolean onDrawLoadMore(Canvas paramAnonymousCanvas, RecyclerView paramAnonymousRecyclerView)
        {
          if (BNRCEventDetailsView.this.mCommentsLoadingFooterContainer.getChildCount() == 0)
          {
            paramAnonymousCanvas = null;
            if (BNRCEventDetailsViewController.getInstance().getLoadingProxy() != null) {
              paramAnonymousCanvas = BNRCEventDetailsViewController.getInstance().getLoadingProxy().getLoadingView();
            }
            if (paramAnonymousCanvas != null)
            {
              if ((paramAnonymousCanvas.getParent() != null) && ((paramAnonymousCanvas.getParent() instanceof ViewGroup))) {
                ((ViewGroup)paramAnonymousCanvas.getParent()).removeView(paramAnonymousCanvas);
              }
              paramAnonymousRecyclerView = new ViewGroup.LayoutParams(-1, -1);
              BNRCEventDetailsView.this.mCommentsLoadingFooterContainer.addView(paramAnonymousCanvas, paramAnonymousRecyclerView);
            }
          }
          BNRCEventDetailsView.this.mCommentsLoadingFooterContainer.setVisibility(0);
          return false;
        }
      });
      this.mUgcDetailsAdapter = new UgcDetailsAdapter(this.mController.getContext());
      this.mUgcDetailsAdapter.setImgDisplay(new UgcDetailsAdapter.ImgDisplay()
      {
        public void showZoomedOutImg(boolean paramAnonymousBoolean, String paramAnonymousString)
        {
          BNRCEventDetailsView.this.showImgZoomView(paramAnonymousBoolean, paramAnonymousString);
        }
      });
      this.mUgcDetailsAdapter.setShowNoMoreCommentsFooter(false);
      if ((this.outlineViewContainer.getParent() != null) && ((this.outlineViewContainer.getParent() instanceof ViewGroup))) {
        ((ViewGroup)this.outlineViewContainer.getParent()).removeView(this.outlineViewContainer);
      }
      this.mUgcDetailsAdapter.setOutlineView(this.outlineViewContainer);
      this.mCommentsPtrList.setAdapter(this.mUgcDetailsAdapter);
      this.mCommentsPtrList.setVisibility(0);
      return;
      this.mCommentsPtrList.setTitleContainer(null, 0);
      this.mCommentsPtrList.setTitleAnimEnabled(false);
      this.mCommentsPtrList.setTopMargin(0);
      continue;
      this.mCommentsPtrList.setTitleContainer(null, 0);
      this.mCommentsPtrList.setTitleAnimEnabled(false);
      if (this.mOrientation == 1)
      {
        i = JarUtils.getResources().getDimensionPixelOffset(1711734797);
        this.mCommentsPtrList.setTopMargin(i);
      }
      else
      {
        this.mCommentsPtrList.setTopMargin(0);
      }
    }
  }
  
  private void initListeners()
  {
    if (this.bgContainer != null) {
      this.bgContainer.setOnClickListener(this);
    }
    if (this.backContainer != null) {
      this.backContainer.setOnClickListener(this);
    }
    if (this.titleContainer != null) {
      this.titleContainer.setOnClickListener(this);
    }
    if (this.outlineLoadingContainer != null) {
      this.outlineLoadingContainer.setOnClickListener(this);
    }
    if (this.outlineViewContainerOuter != null) {
      this.outlineViewContainerOuter.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public void onGlobalLayout()
        {
          LogUtil.e("BNRCEventDetailsView", "onGlobalLayout: outlineViewContainer --> " + BNRCEventDetailsView.this.outlineViewContainer + ", scrollViewInited: " + BNRCEventDetailsView.this.scrollViewInited);
          if (BNRCEventDetailsView.this.outlineViewContainer == null) {
            break label55;
          }
          label55:
          while (BNRCEventDetailsView.this.scrollViewInited) {
            return;
          }
          int i = BNRCEventDetailsView.this.outlineViewContainer.getMeasuredHeight();
          BNRCEventDetailsView.this.initCommentsList();
          UgcDetailsAdapter localUgcDetailsAdapter;
          if (BNRCEventDetailsView.this.mCommentsPtrList != null)
          {
            int j = BNRCEventDetailsView.this.bgContainer.getMeasuredHeight() - BNRCEventDetailsView.this.mCommentsPtrList.getTopMargin();
            BNRCEventDetailsView.this.mCommentsPtrList.setHeights(i, j);
            i = j - i;
            j = ScreenUtil.getInstance().dip2px(161);
            localUgcDetailsAdapter = BNRCEventDetailsView.this.mUgcDetailsAdapter;
            if (i >= j) {
              break label277;
            }
            i = j;
          }
          label277:
          for (;;)
          {
            localUgcDetailsAdapter.setLoadingStateHeight(i);
            BNRCEventDetailsView.this.mUgcDetailsAdapter.setData(BNRCEventDetailsView.this.mController.getModel().getComments());
            BNRCEventDetailsView.this.mUgcDetailsAdapter.notifyDataSetChanged();
            BNRCEventDetailsView.access$402(BNRCEventDetailsView.this, BNRCEventDetailsView.this.mCommentsPtrList.goToBottom(2));
            LogUtil.e("BNRCEventDetailsView", "onGlobalLayout: mTwoStateScrollView initiated --> " + BNRCEventDetailsView.this.scrollViewInited);
            if ((BNRCEventDetailsView.this.outlineViewContainerOuter == null) || (Build.VERSION.SDK_INT < 16)) {
              break;
            }
            BNRCEventDetailsView.this.outlineViewContainerOuter.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            return;
          }
        }
      });
    }
    if (this.mCommentsPtrList != null) {
      this.mCommentsPtrList.setOnStatusChangeListener(new TwoStateScrollView.OnStatusChangeListener()
      {
        public void onStatusChange(TwoStateScrollView.DragState paramAnonymousDragState)
        {
          LogUtil.e("BNRCEventDetailsView", "onStatusChange: --> mCurState: " + BNRCEventDetailsView.this.mCurState + ", state: " + paramAnonymousDragState);
          if (BNRCEventDetailsView.this.mCurState != paramAnonymousDragState)
          {
            BNRCEventDetailsView.access$1002(BNRCEventDetailsView.this, paramAnonymousDragState);
            if (paramAnonymousDragState != TwoStateScrollView.DragState.BOTTOM) {}
          }
          else
          {
            return;
          }
          BNRCEventDetailsView.this.loadComments();
        }
      });
    }
  }
  
  private void initOutlineData()
  {
    if (!this.mController.asyncGetRCEventDetailsData())
    {
      loadingStart(1);
      this.mController.initOutlineDataBuild();
    }
  }
  
  private void initViewShowByData()
  {
    if ((this.mController.getModel() != null) && (this.mController.getModel().getOutlineDataBuild() != null))
    {
      if (this.mController.getModel().getOutlineDataBuild().getIsShowZoomView()) {
        imgThumbnailButtonClick();
      }
      if (this.mController.getModel().getOutlineDataBuild().getVotedIndex() != 0)
      {
        if (this.mController.getModel().getOutlineDataBuild().getVotedIndex() != 1) {
          break label115;
        }
        this.mController.getModel().setVoted(1);
        this.mController.getModel().setUseful(this.mController.getModel().getUseful() + 1);
        updateUsefulOrUselessView(true);
      }
    }
    return;
    label115:
    this.mController.getModel().setVoted(2);
    this.mController.getModel().setUseless(this.mController.getModel().getUseless() + 1);
    updateUsefulOrUselessView(false);
  }
  
  private void initViews(Context paramContext)
  {
    if (paramContext == null) {}
    for (;;)
    {
      return;
      try
      {
        this.rootView = JarUtils.inflate((Activity)paramContext, 1711472756, null);
        if (this.rootView != null)
        {
          this.titleContainer = this.rootView.findViewById(1711866246);
          this.backContainer = this.rootView.findViewById(1711866247);
          this.bgContainer = this.rootView.findViewById(1711867083);
          this.outlineLoadingContainer = ((ViewGroup)this.rootView.findViewById(1711867086));
          this.imgZoomViewContainer = this.rootView.findViewById(1711867090);
          this.outlineViewContainerOuter = ((ViewGroup)this.rootView.findViewById(1711867085));
          this.mCommentsPtrBg = this.rootView.findViewById(1711867087);
          this.mCommentsLoadingFooterContainer = ((ViewGroup)this.rootView.findViewById(1711867088));
          this.imgZoomIv = ((ImageView)this.rootView.findViewById(1711867091));
          this.mCommentsPtrList = ((PullToRefreshRecyclerView)this.rootView.findViewById(1711867089));
          this.titleContainer.setVisibility(8);
          initListeners();
          initOutlineData();
          return;
        }
      }
      catch (Throwable paramContext)
      {
        this.rootView = null;
      }
    }
  }
  
  private void loadComments()
  {
    int i = 1;
    if (this.mController.getSource() == 1) {
      i = 2;
    }
    for (;;)
    {
      UserOPController.getInstance().add("3.u.2.1", "" + i, null, null);
      this.mController.stopTimer();
      initCommentsData();
      if (this.mCommentsPtrList != null) {
        this.mCommentsPtrList.setSwipeEnable(true);
      }
      return;
      if (this.mController.getSource() == 2) {
        i = 3;
      }
    }
  }
  
  private void loadingStart(int paramInt)
  {
    LogUtil.e("BNRCEventDetailsView", "loadingStart: type --> " + paramInt);
    switch (paramInt)
    {
    case 2: 
    default: 
      if (this.mController.getLoadingProxy() != null) {
        this.mController.getLoadingProxy().onLoadingStart(1, null);
      }
      break;
    }
    do
    {
      do
      {
        return;
        if (this.outlineLoadingContainer != null) {
          this.outlineLoadingContainer.setVisibility(0);
        }
      } while (this.mController.getLoadingProxy() == null);
      this.mController.getLoadingProxy().onLoadingStart(2, this.outlineLoadingContainer);
      return;
    } while (this.mUgcDetailsAdapter == null);
    this.mUgcDetailsAdapter.setCommentsLoadingState(UgcDetailsAdapter.CommentsLoadingState.LOADING);
    this.mUgcDetailsAdapter.notifyDataSetChanged();
  }
  
  private void onClickShade()
  {
    if ((this.imgZoomViewContainer != null) && (this.imgZoomViewContainer.isShown())) {
      showImgZoomView(false, null);
    }
    do
    {
      return;
      if (this.mController != null) {
        this.mController.onDestroy();
      }
    } while (this.rootView == null);
    this.rootView.setVisibility(8);
  }
  
  private void usefulOrUselessClicked(boolean paramBoolean)
  {
    if (!NetworkUtils.getConnectStatus())
    {
      TipTool.onCreateToastDialog(this.mController.getContext(), JarUtils.getResources().getString(1711669655));
      return;
    }
    UserOPController localUserOPController = UserOPController.getInstance();
    if (paramBoolean) {}
    for (String str = "1";; str = "2")
    {
      localUserOPController.add("3.u.3", str, null, null);
      if ((this.mController == null) || (this.mController.isVotedUpdated())) {
        break;
      }
      if (this.mController.getModel().getVoted() != 0) {
        break label107;
      }
      this.mController.setVotedUpdated(paramBoolean);
      this.mController.asyncRCEventFeedbackData(paramBoolean);
      loadingStart(2);
      return;
    }
    label107:
    TipTool.onCreateToastDialog(this.mController.getContext(), "您已经评价过了");
  }
  
  public View getRootView()
  {
    return this.rootView;
  }
  
  public void initOutlineView()
  {
    if (this.outlineViewContainerOuter == null) {
      LogUtil.e("BNRCEventDetailsView", "initOutlineView: --> outlineViewContainerOuter = null");
    }
    do
    {
      return;
      this.outlineViewContainer = JarUtils.inflate((Activity)this.mController.getContext(), 1711472755, null);
      if (this.outlineViewContainer != null) {
        break;
      }
      LogUtil.e("BNRCEventDetailsView", "initOutlineView: --> inflate fail");
      if (this.mController != null) {
        this.mController.onDestroy();
      }
    } while (this.rootView == null);
    this.rootView.setVisibility(8);
    return;
    this.imgThumbnail = ((ImageView)this.outlineViewContainer.findViewById(1711867061));
    this.icEventType = ((ImageView)this.outlineViewContainer.findViewById(1711867054));
    this.tvEventType = ((TextView)this.outlineViewContainer.findViewById(1711867055));
    this.tvEventTimeStamp = ((TextView)this.outlineViewContainer.findViewById(1711867056));
    this.tvEventDescription = ((TextView)this.outlineViewContainer.findViewById(1711867067));
    this.tvEventReporter = ((TextView)this.outlineViewContainer.findViewById(1711867071));
    this.vUseful = this.outlineViewContainer.findViewById(1711867076);
    this.tvUseful = ((TextView)this.outlineViewContainer.findViewById(1711867077));
    this.vUseless = this.outlineViewContainer.findViewById(1711867078);
    this.tvUseless = ((TextView)this.outlineViewContainer.findViewById(1711867079));
    this.vAvoidCongestion = this.outlineViewContainer.findViewById(1711867081);
    this.vAvoidCongestionDivider = this.outlineViewContainer.findViewById(1711867080);
    this.userInfoLayout = this.outlineViewContainer.findViewById(1711867069);
    this.eventPortraitIV = ((TextView)this.outlineViewContainer.findViewById(1711867070));
    this.eventReporterLevelTV = ((TextView)this.outlineViewContainer.findViewById(1711867072));
    this.eventReporterCountsTV = ((TextView)this.outlineViewContainer.findViewById(1711867073));
    this.awayFromSpacing = this.outlineViewContainer.findViewById(1711867058);
    this.eventSubLayout = this.outlineViewContainer.findViewById(1711867063);
    this.eventSubLayoutDivider = this.outlineViewContainer.findViewById(1711867066);
    this.eventSubTv1 = ((TextView)this.outlineViewContainer.findViewById(1711867064));
    this.eventSubTv2 = ((TextView)this.outlineViewContainer.findViewById(1711867065));
    this.roadNameTv = ((TextView)this.outlineViewContainer.findViewById(1711867057));
    this.awayFromTv = ((TextView)this.outlineViewContainer.findViewById(1711867059));
    this.timeIntervalTv = ((TextView)this.outlineViewContainer.findViewById(1711867068));
    this.contentView = this.outlineViewContainer.findViewById(1711867060);
    this.eventDescriptionLayout = this.outlineViewContainer.findViewById(1711867062);
    this.outlineViewContainerOuter.addView(this.outlineViewContainer, new ViewGroup.LayoutParams(-1, -2));
    this.outlineViewContainerOuter.setVisibility(0);
    if (this.imgThumbnail != null) {
      this.imgThumbnail.setClickable(false);
    }
    if ((this.vAvoidCongestion != null) && (this.vAvoidCongestionDivider != null)) {
      switch (BNRCEventDetailsViewController.getInstance().getSource())
      {
      default: 
        this.vAvoidCongestion.setVisibility(8);
        this.vAvoidCongestionDivider.setVisibility(8);
      }
    }
    for (;;)
    {
      if (this.imgThumbnail != null) {
        this.imgThumbnail.setOnClickListener(this);
      }
      if (this.vUseful != null) {
        this.vUseful.setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            LogUtil.e("BNRCEventDetailsView", "onTouch: action --> " + paramAnonymousMotionEvent.getAction());
            if (paramAnonymousMotionEvent.getAction() == 1) {
              BNRCEventDetailsView.this.usefulOrUselessClicked(true);
            }
            return (paramAnonymousMotionEvent.getAction() == 1) || (paramAnonymousMotionEvent.getAction() == 0);
          }
        });
      }
      if (this.vUseless != null) {
        this.vUseless.setOnTouchListener(new View.OnTouchListener()
        {
          public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
          {
            boolean bool = false;
            LogUtil.e("BNRCEventDetailsView", "onTouch: action --> " + paramAnonymousMotionEvent.getAction());
            if (paramAnonymousMotionEvent.getAction() == 1) {
              BNRCEventDetailsView.this.usefulOrUselessClicked(false);
            }
            if ((paramAnonymousMotionEvent.getAction() == 1) || (paramAnonymousMotionEvent.getAction() == 0)) {
              bool = true;
            }
            return bool;
          }
        });
      }
      if (this.userInfoLayout != null) {
        this.userInfoLayout.setOnClickListener(this);
      }
      if (this.vAvoidCongestion != null) {
        this.vAvoidCongestion.setOnClickListener(this);
      }
      if (this.outlineViewContainer == null) {
        break;
      }
      this.outlineViewContainer.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (BNRCEventDetailsView.this.mCommentsPtrList != null)
          {
            BNRCEventDetailsView.this.mCommentsPtrList.goToTop();
            BNRCEventDetailsView.this.loadComments();
          }
        }
      });
      return;
      this.vAvoidCongestion.setVisibility(0);
      this.vAvoidCongestionDivider.setVisibility(0);
    }
  }
  
  public void loadingEnd(int paramInt, String paramString, boolean paramBoolean)
  {
    LogUtil.e("BNRCEventDetailsView", "loadingEnd: --> type: " + paramInt + ", suc: " + paramBoolean + ", err: " + paramString);
    switch (paramInt)
    {
    case 2: 
    default: 
      if (this.mController.getLoadingProxy() != null) {
        this.mController.getLoadingProxy().onLoadingEnd(1, paramBoolean, null, null);
      }
      TipTool.onCreateToastDialog(this.mController.getContext(), paramString);
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (paramBoolean) {
              break;
            }
          } while (this.mController.getLoadingProxy() == null);
          this.mController.getLoadingProxy().onLoadingEnd(2, paramBoolean, this.outlineLoadingContainer, this.mOutlineLoadingListener);
          return;
          if (this.mController.getLoadingProxy() != null) {
            this.mController.getLoadingProxy().onLoadingEnd(2, paramBoolean, this.outlineLoadingContainer, null);
          }
        } while (this.outlineLoadingContainer == null);
        this.outlineLoadingContainer.setVisibility(8);
        return;
      } while (paramBoolean);
      if (this.mController.getModel().getCommentsLength() != 0) {
        break;
      }
      this.commentsPtrListInited = false;
      this.mUgcDetailsAdapter.setCommentsLoadingState(UgcDetailsAdapter.CommentsLoadingState.LOADING);
      this.mUgcDetailsAdapter.notifyDataSetChanged();
    } while (this.mController.getLoadingProxy() == null);
    this.mController.getLoadingProxy().onLoadingEnd(2, paramBoolean, null, this.mCommentsLoadingListener);
    return;
    TipTool.onCreateToastDialog(this.mController.getContext(), paramString);
    if (this.mCommentsPtrList != null)
    {
      this.mCommentsPtrList.onFinishLoading(false, false);
      this.mCommentsPtrList.setScrollSupport(false);
    }
    BNWorkerCenter.getInstance().cancelTask(this.mEnablePullRunnable, false);
    BNWorkerCenter.getInstance().submitMainThreadTaskDelay(this.mEnablePullRunnable, new BNWorkerConfig(2, 0), 500L);
  }
  
  public boolean onBackPressed()
  {
    boolean bool = false;
    if ((this.imgZoomViewContainer != null) && (this.imgZoomViewContainer.isShown()))
    {
      showImgZoomView(false, null);
      bool = true;
    }
    while (this.mController == null) {
      return bool;
    }
    this.mController.onDestroy();
    return false;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i == 1711867076) {}
    label12:
    do
    {
      do
      {
        do
        {
          do
          {
            break label12;
            break label12;
            do
            {
              return;
            } while (i == 1711867078);
            if (i == 1711867061)
            {
              showImgZoomView(true, this.mController.getModel().getEventPic());
              return;
            }
            if (i == 1711867083)
            {
              onClickShade();
              return;
            }
            if (i != 1711867069) {
              break;
            }
          } while (this.mCommentsPtrList == null);
          this.mCommentsPtrList.goToTop();
          loadComments();
          return;
          if (i != 1711866247) {
            break;
          }
          if (this.mController != null) {
            this.mController.onDestroy();
          }
        } while (this.rootView == null);
        this.rootView.setVisibility(8);
        return;
        if (i != 1711867081) {
          break;
        }
        if (BNRCEventDetailsViewController.getInstance().getSource() == 3) {
          UserOPController.getInstance().add("3.u.2.3", null, null, null);
        }
      } while (this.mController == null);
      this.mController.doReCalcRoute();
      return;
    } while ((i == 1711867086) || (i != 1711866246));
  }
  
  public void onCommentsDataSetChanged()
  {
    if ((this.mUgcDetailsAdapter == null) || (this.mCommentsLoadingFooterContainer == null)) {
      return;
    }
    boolean bool = this.mController.isMoreCommentsPending();
    int i = this.mController.getModel().getCommentsLength();
    LogUtil.e("BNRCEventDetailsView", "onCommentsDataSetChanged: --> moreCommentsPending: " + bool + ", dataCount: " + i);
    if (i == 0)
    {
      this.mUgcDetailsAdapter.setCommentsLoadingState(UgcDetailsAdapter.CommentsLoadingState.LOADED_NO_DATA);
      this.mUgcDetailsAdapter.notifyDataSetChanged();
      return;
    }
    initCommentsList();
    this.mUgcDetailsAdapter.setCommentsLoadingState(UgcDetailsAdapter.CommentsLoadingState.LOADED_HAS_DATA);
    this.mUgcDetailsAdapter.setData(this.mController.getModel().getComments());
    this.mUgcDetailsAdapter.notifyDataSetChanged();
    if (!bool)
    {
      this.mUgcDetailsAdapter.setShowNoMoreCommentsFooter(true);
      this.mCommentsLoadingFooterContainer.setVisibility(8);
      this.mUgcDetailsAdapter.notifyDataSetChanged();
      this.mCommentsPtrList.onFinishLoading(false, false);
      return;
    }
    this.mCommentsPtrList.onFinishLoading(true, false);
  }
  
  public void onDestroy()
  {
    this.commentsPtrListInited = false;
    if (this.mUgcRCEventCallback != null) {
      this.mUgcRCEventCallback.onFinish();
    }
    UIUtils.releaseImageViewWithoutNull(this.imgThumbnail);
    UIUtils.releaseImageViewWithoutNull(this.icEventType);
    UIUtils.releaseImageViewWithoutNull(this.imgZoomIv);
    if (this.bitmap != null)
    {
      this.bitmap.recycle();
      this.bitmap = null;
    }
    this.outlineViewContainer = null;
  }
  
  public void onOutlineDataSetChanged()
  {
    LogUtil.e("BNRCEventDetailsView", "onOutlineDataSetChanged: --> start");
    initOutlineView();
    updateOutlineView();
    LogUtil.e("BNRCEventDetailsView", "onOutlineDataSetChanged: --> end");
  }
  
  public void showImgZoomView(boolean paramBoolean, String paramString)
  {
    if ((this.imgZoomViewContainer == null) || (this.imgZoomIv == null)) {
      return;
    }
    if (!TextUtils.isEmpty(paramString)) {
      UrlDrawableContainIView.getDrawable(paramString, 1711408007, this.imgZoomIv, new Handler(Looper.getMainLooper())
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          super.handleMessage(paramAnonymousMessage);
          if ((paramAnonymousMessage.what != 8192) || (paramAnonymousMessage.arg1 == 0)) {
            return;
          }
          LogUtil.e("BNRCEventDetailsView", "handleMessage: zoom img load fail --> ");
        }
      }, true);
    }
    paramString = this.imgZoomViewContainer;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      paramString.setVisibility(i);
      this.mController.setIsShowZoomView(paramBoolean);
      if (!paramBoolean) {
        break;
      }
      this.mController.stopTimer();
      this.imgZoomViewContainer.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BNRCEventDetailsView.this.showImgZoomView(false, null);
        }
      });
      return;
    }
  }
  
  public void updateOutlineView()
  {
    if (this.imgThumbnail != null)
    {
      if (TextUtils.isEmpty(this.mController.getModel().getEventPic())) {
        break label528;
      }
      this.imgThumbnail.setClickable(false);
      UrlDrawableContainIView.getDrawable(this.mController.getModel().getEventPic(), 1711408007, this.imgThumbnail, new Handler(Looper.getMainLooper())
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          super.handleMessage(paramAnonymousMessage);
          if (paramAnonymousMessage.what == 8192)
          {
            if (paramAnonymousMessage.arg1 == 0) {
              BNRCEventDetailsView.this.imgThumbnail.setClickable(true);
            }
          }
          else {
            return;
          }
          BNRCEventDetailsView.this.imgThumbnail.setClickable(false);
        }
      });
    }
    for (;;)
    {
      if ((this.icEventType != null) && (!TextUtils.isEmpty(this.mController.getModel().geteIcon()))) {}
      try
      {
        new UgcImageLoaderUtils().updateUgcViewOnLine(this.mController.getModel().geteType(), this.icEventType, this.mController.getModel().geteIcon());
        if (this.tvEventType != null) {
          this.tvEventType.setText(this.mController.getModel().geteTitle());
        }
        if (this.tvEventTimeStamp != null) {
          this.tvEventTimeStamp.setText(this.mController.getModel().getShowTime());
        }
        if (this.tvEventDescription != null)
        {
          if (TextUtils.isEmpty(this.mController.getModel().getContent())) {
            this.tvEventDescription.setVisibility(8);
          }
        }
        else
        {
          if (this.tvEventReporter != null)
          {
            if (!TextUtils.isEmpty(this.mController.getModel().getUser())) {
              break label568;
            }
            this.tvEventReporter.setText("百度热心用户");
          }
          if ((this.mController.getModel().getLabel() != null) && (this.mController.getModel().getLabel().length != 0)) {
            break label591;
          }
          j = 0;
          i = j;
          if (this.eventSubLayout != null)
          {
            this.eventSubLayout.setVisibility(8);
            i = j;
          }
          if (this.roadNameTv != null) {
            this.roadNameTv.setText(this.mController.getModel().getRoadName());
          }
          if (this.awayFromTv != null)
          {
            this.awayFromTv.setText(this.mController.getModel().getAwayFrom());
            if ((TextUtils.isEmpty(this.mController.getModel().getAwayFrom())) && (this.awayFromSpacing != null)) {
              this.awayFromSpacing.setVisibility(8);
            }
          }
          if (this.timeIntervalTv != null)
          {
            if (!TextUtils.isEmpty(this.mController.getModel().getTimeInterval())) {
              break label761;
            }
            this.timeIntervalTv.setVisibility(8);
          }
          if ((this.tvEventDescription != null) && (this.eventSubLayout != null) && (this.timeIntervalTv != null) && (this.imgThumbnail != null))
          {
            if ((this.tvEventDescription.getVisibility() != 8) || (this.eventSubLayout.getVisibility() != 8) || (this.timeIntervalTv.getVisibility() != 8) || (this.imgThumbnail.getVisibility() != 8)) {
              break label781;
            }
            this.contentView.setVisibility(8);
          }
          if (this.eventSubLayoutDivider != null)
          {
            if ((TextUtils.isEmpty(this.mController.getModel().getContent())) || (i == 0)) {
              break label792;
            }
            this.eventSubLayoutDivider.setVisibility(0);
          }
          updateUsefulOrUselessView(true);
          updateUsefulOrUselessView(false);
          initViewShowByData();
          return;
          label528:
          this.imgThumbnail.setVisibility(8);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          int i;
          localException.printStackTrace();
          continue;
          this.tvEventDescription.setText(this.mController.getModel().getContent());
          continue;
          label568:
          this.tvEventReporter.setText(Html.fromHtml(this.mController.getModel().getUser()));
          continue;
          label591:
          int j = 1;
          if (this.mController.getModel().getLabel().length == 1)
          {
            i = j;
            if (this.eventSubTv1 != null)
            {
              i = j;
              if (this.eventSubTv2 != null)
              {
                this.eventSubTv1.setText(this.mController.getModel().getLabel()[0]);
                this.eventSubTv2.setVisibility(8);
                this.eventSubTv1.setVisibility(0);
                i = j;
              }
            }
          }
          else
          {
            i = j;
            if (this.mController.getModel().getLabel().length == 2)
            {
              i = j;
              if (this.eventSubTv1 != null)
              {
                i = j;
                if (this.eventSubTv2 != null)
                {
                  this.eventSubTv1.setText(this.mController.getModel().getLabel()[0]);
                  this.eventSubTv2.setText(this.mController.getModel().getLabel()[1]);
                  this.eventSubTv2.setVisibility(0);
                  this.eventSubTv1.setVisibility(0);
                  i = j;
                  continue;
                  label761:
                  this.timeIntervalTv.setText(this.mController.getModel().getTimeInterval());
                  continue;
                  label781:
                  this.contentView.setVisibility(0);
                  continue;
                  label792:
                  this.eventSubLayoutDivider.setVisibility(8);
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void updateUsefulOrUseless(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mController.getModel().setVoted(1);
      this.mController.getModel().setUseful(this.mController.getModel().getUseful() + 1);
      this.mController.getModel().getOutlineDataBuild().setVotedIndex(1);
    }
    for (;;)
    {
      updateUsefulOrUselessView(paramBoolean);
      return;
      this.mController.getModel().setVoted(2);
      this.mController.getModel().setUseless(this.mController.getModel().getUseless() + 1);
      this.mController.getModel().getOutlineDataBuild().setVotedIndex(2);
    }
  }
  
  public void updateUsefulOrUselessView(boolean paramBoolean)
  {
    int k = this.mController.getModel().getVoted();
    int i = JarUtils.getResources().getColor(1711800739);
    int j = JarUtils.getResources().getColor(1711800737);
    TextView localTextView;
    if (paramBoolean)
    {
      if (k != 1)
      {
        k = 0;
        if (this.tvUseful != null)
        {
          this.tvUseful.setText("有用(" + this.mController.getModel().getUseful() + ")");
          localTextView = this.tvUseful;
          if (k == 0) {
            break label118;
          }
        }
      }
      for (;;)
      {
        localTextView.setTextColor(j);
        return;
        k = 1;
        break;
        label118:
        j = i;
      }
    }
    if (k != 2)
    {
      k = 0;
      label132:
      if (this.tvUseless == null) {
        break label203;
      }
      this.tvUseless.setText("没用(" + this.mController.getModel().getUseless() + ")");
      localTextView = this.tvUseless;
      if (k == 0) {
        break label205;
      }
    }
    for (;;)
    {
      localTextView.setTextColor(j);
      return;
      k = 1;
      break label132;
      label203:
      break;
      label205:
      j = i;
    }
  }
  
  public static abstract interface UgcRCEventCallback
  {
    public abstract void onFinish();
    
    public abstract void onShowUserINfo(String paramString);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/ugc/view/BNRCEventDetailsView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */