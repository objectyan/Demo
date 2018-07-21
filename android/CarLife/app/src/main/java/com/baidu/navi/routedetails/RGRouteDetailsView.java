package com.baidu.navi.routedetails;

import android.app.Activity;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.core.screen.BaseDialog.a;
import com.baidu.carlife.core.screen.e;
import com.baidu.carlife.logic.voice.m;
import com.baidu.carlife.view.dialog.f;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.voice.NaviState;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeguide.BNRouteGuider;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.RoutePlanOutlineItem;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.routedetails.IBNRouteDetailsListener;
import com.baidu.navisdk.ui.routeguide.control.NMapControlProxy;
import com.baidu.navisdk.ui.routeguide.control.RGRouteSortController;
import com.baidu.navisdk.ui.routeguide.model.RGMultiRouteModel;
import com.baidu.navisdk.ui.routeguide.model.RGParkPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSortModel;
import com.baidu.navisdk.ui.routeguide.subview.RGBaseView;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtilsNonStatic;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.statistic.NaviStatItem;
import com.baidu.navisdk.util.statistic.RoutePlanStatItem;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import com.baidu.nplatform.comapi.MapItem;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import java.util.ArrayList;
import java.util.Iterator;

public class RGRouteDetailsView
  extends RGBaseView
{
  private static final int NAVI_COUNT_DOWN_TIME = 5;
  private static final String TAG = "RoutePlan";
  private final int ROUTES_SIZE = 3;
  TranslateAnimation anim;
  private Activity mActivity = null;
  private BNMapObserver mBNMapObserver = new BNMapObserver()
  {
    public void update(BNSubject paramAnonymousBNSubject, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
    {
      if (1 == paramAnonymousInt1) {
        switch (paramAnonymousInt2)
        {
        }
      }
      do
      {
        do
        {
          return;
        } while (RGRouteDetailsView.this.mForbidRouteMapClick == true);
        paramAnonymousBNSubject = (MapItem)paramAnonymousObject;
        paramAnonymousInt1 = paramAnonymousBNSubject.mItemID;
        RGRouteDetailsView.access$402(RGRouteDetailsView.this, paramAnonymousInt1);
        RGRouteDetailsView.this.mRoutePlanModel.setCurIndex(paramAnonymousInt1);
        RGRouteDetailsView.this.cancleCountDownTask();
        paramAnonymousObject = RGRouteDetailsView.this.mViewList.iterator();
        while (((Iterator)paramAnonymousObject).hasNext()) {
          ((RGRouteDetailsOutlineItemView)((Iterator)paramAnonymousObject).next()).unfocusItem();
        }
      } while ((RGRouteDetailsView.this.mViewList == null) || (paramAnonymousInt1 < 0) || (paramAnonymousInt1 >= RGRouteDetailsView.this.mViewList.size()));
      ((RGRouteDetailsOutlineItemView)RGRouteDetailsView.this.mViewList.get(paramAnonymousInt1)).focusItem();
      BNRoutePlaner.getInstance().selectRoute(paramAnonymousInt1);
      RGRouteDetailsView.this.selectRoute(paramAnonymousBNSubject.mItemID);
      RGRouteDetailsView.this.updateIndicator(RGRouteDetailsView.this.mCurrentRouteIndex);
    }
  };
  private IBNRouteDetailsListener mBNRouteDetailsListener = null;
  private View mBtnBack;
  private View mBtnOpenPreference;
  private NaviCountDownTask mCountDownTask;
  private int mCurrentRouteIndex = 0;
  private boolean mForbidRouteMapClick = false;
  private ViewGroup mGroupView;
  private boolean mIsCountDowning;
  private boolean mIsFisrtCountDown = true;
  private boolean mIsSeeOtherRoute = false;
  private ImageView mIvBack;
  private e mOnDialogListener;
  private Handler mRPHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
      case 4: 
        do
        {
          return;
          LogUtil.e("RoutePlan", "onRoutePlanSuccess");
          RGRouteDetailsView.access$802(RGRouteDetailsView.this, true);
          RGRouteDetailsView.access$902(RGRouteDetailsView.this, true);
          RGRouteDetailsView.this.clearParkDetailAfterReCalc();
          RGRouteDetailsView.this.startNaviCountDown(5);
          RGRouteDetailsView.access$402(RGRouteDetailsView.this, 0);
          RGRouteDetailsView.this.onUpdateOrientation();
        } while (RGRouteDetailsView.this.mBNRouteDetailsListener == null);
        RGRouteDetailsView.this.mBNRouteDetailsListener.onUpdate(2, 0, 0, null);
        return;
      case 7: 
        LogUtil.e("RoutePlan", "onRoutePlanFail");
        RGRouteDetailsView.this.backToHome(null);
        return;
      }
      LogUtil.e("RoutePlan", "onRoutePlanCanceled");
      RGRouteDetailsView.this.backToHome(null);
    }
  };
  private View mRlPreference;
  private RelativeLayout mRouteDetailLL;
  private LinearLayout mRouteOutlineLL;
  private RoutePlanModel mRoutePlanModel = null;
  private ArrayList<RoutePlanOutlineItem> mRoutePlanOutlineItemList;
  private f mRoutePlanPreferenceDialog = null;
  private RoutePlanPreferenceDialogAdapter mRoutePlanPreferenceDialogAdapter = null;
  private LinearLayout mStartNaviLL;
  private TextView mStartNaviTextView;
  private RoutePlanStatItem mStatItem;
  private TextView mTvPreference;
  ArrayList<RGRouteDetailsOutlineItemView> mViewList;
  private boolean needAnimForFullview = true;
  private ArrayList<RGRouteSortModel> routeSortList;
  private int[] routesSelected = new int[3];
  private Runnable runnable = new Runnable()
  {
    public void run()
    {
      LogUtil.e("WandaDebug", "BNMapObserver.EventMapView.EVENT_CLICKED_END_LAYER onResume");
      BNMapController.getInstance().onResume();
    }
  };
  
  public RGRouteDetailsView(Activity paramActivity, e parame)
  {
    this.mActivity = paramActivity;
    this.mOnDialogListener = parame;
    initData();
    BNMapController.getInstance().recoveryHighLightRoute();
    BNMapController.getInstance().setHighLightRoute(0);
    this.mGroupView = ((ViewGroup)this.mActivity.getLayoutInflater().inflate(2130968774, null));
    if (this.mRPHandler != null) {
      this.mRPHandler.postDelayed(this.runnable, 12000L);
    }
  }
  
  private void backToHome(Bundle paramBundle)
  {
    if (this.mBNRouteDetailsListener != null) {
      this.mBNRouteDetailsListener.onPageJump(2, paramBundle);
    }
  }
  
  private boolean chooseRoute(int paramInt)
  {
    if ((this.mViewList == null) && (paramInt > 2) && (paramInt < 0)) {}
    int i;
    RGRouteDetailsOutlineItemView localRGRouteDetailsOutlineItemView;
    do
    {
      return false;
      i = 0;
      if (i >= this.mViewList.size()) {
        break;
      }
      localRGRouteDetailsOutlineItemView = (RGRouteDetailsOutlineItemView)this.mViewList.get(i);
    } while (localRGRouteDetailsOutlineItemView == null);
    if (i == paramInt)
    {
      cancleCountDownTask();
      localRGRouteDetailsOutlineItemView.focusItem();
      BNRoutePlaner.getInstance().selectRoute(paramInt);
      selectRoute(paramInt);
      startRealNavi();
    }
    for (;;)
    {
      i += 1;
      break;
      localRGRouteDetailsOutlineItemView.unfocusItem();
    }
    return true;
  }
  
  private boolean chooseRouteIndex(int paramInt)
  {
    if ((this.mViewList == null) || (paramInt >= this.mViewList.size()) || (paramInt < 0)) {
      return false;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.mViewList.size()) {
        break label139;
      }
      RGRouteDetailsOutlineItemView localRGRouteDetailsOutlineItemView = (RGRouteDetailsOutlineItemView)this.mViewList.get(i);
      if (localRGRouteDetailsOutlineItemView == null) {
        break;
      }
      if (i == paramInt)
      {
        cancleCountDownTask();
        this.mCurrentRouteIndex = paramInt;
        this.mRoutePlanModel.setCurIndex(paramInt);
        Iterator localIterator = this.mViewList.iterator();
        while (localIterator.hasNext()) {
          ((RGRouteDetailsOutlineItemView)localIterator.next()).unfocusItem();
        }
        localRGRouteDetailsOutlineItemView.focusItem();
        BNRoutePlaner.getInstance().selectRoute(paramInt);
        selectRoute(paramInt);
        updateIndicator(paramInt);
      }
      i += 1;
    }
    label139:
    return true;
  }
  
  private void clearParkDetailAfterReCalc()
  {
    BNPoiSearcher.getInstance().clearBkgCache();
    BNMapController.getInstance().updateLayer(4);
    BNMapController.getInstance().showLayer(4, false);
  }
  
  private void findView()
  {
    if (this.mGroupView == null) {
      return;
    }
    this.mRouteDetailLL = ((RelativeLayout)this.mGroupView.findViewById(2131624942));
    this.mRouteOutlineLL = ((LinearLayout)this.mGroupView.findViewById(2131624962));
    this.mStartNaviLL = ((LinearLayout)this.mGroupView.findViewById(2131624772));
    this.mBtnBack = this.mGroupView.findViewById(2131624136);
    this.mIvBack = ((ImageView)this.mGroupView.findViewById(2131624137));
    this.mBtnOpenPreference = this.mGroupView.findViewById(2131624943);
    this.mRlPreference = this.mGroupView.findViewById(2131624944);
    this.mTvPreference = ((TextView)this.mGroupView.findViewById(2131624945));
    this.mStartNaviTextView = ((TextView)this.mGroupView.findViewById(2131624777));
  }
  
  private String getLabelName()
  {
    ArrayList localArrayList = RGRouteSortController.getInstance().getRouteSortList();
    if (localArrayList == null) {
      return "";
    }
    int i = 0;
    while (i < localArrayList.size())
    {
      RGRouteSortModel localRGRouteSortModel = (RGRouteSortModel)localArrayList.get(i);
      if (localRGRouteSortModel == null) {
        return "";
      }
      if ((localRGRouteSortModel.mPreferValue & RGRouteSortController.getInstance().getPreferValue()) != 0) {
        return localRGRouteSortModel.mItemName;
      }
      i += 1;
    }
    return "";
  }
  
  private int getRouteSelectedInt()
  {
    int n = 0;
    if (this.routesSelected == null) {
      return n;
    }
    if (this.mViewList == null) {}
    for (int i = 0;; i = this.mViewList.size())
    {
      int j = i;
      if (i > 3) {
        j = 3;
      }
      int m = 1;
      i = 1;
      int k = 1;
      for (;;)
      {
        n = i;
        if (k >= j) {
          break;
        }
        m <<= 1;
        i += this.routesSelected[k] * m;
        k += 1;
      }
    }
  }
  
  private void initData()
  {
    this.mRoutePlanModel = ((RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel"));
    this.mRoutePlanOutlineItemList = new ArrayList();
    this.mStatItem = RoutePlanStatItem.getInstance();
    this.mStatItem.mRouteSwitchStartTime = SystemClock.elapsedRealtime();
  }
  
  private void initMap()
  {
    int i = ScreenUtil.getInstance().getHeightPixels();
    int j = ScreenUtil.getInstance().getWidthPixels();
    Rect localRect = new Rect(0, 0, i - ScreenUtil.getInstance().dip2px(256), j - ScreenUtil.getInstance().dip2px(80));
    BNMapController.getInstance().setMapDrawScreenRect(localRect);
    if (this.mRoutePlanModel != null) {
      updateMapViewForRPNode(this.mRoutePlanModel.getRouteInput(), localRect);
    }
  }
  
  private View initViews()
  {
    if (this.mGroupView != null) {
      this.mGroupView.removeAllViews();
    }
    this.mActivity.getLayoutInflater().inflate(2130968774, this.mGroupView);
    findView();
    updatePreferenceView();
    onUpdateStyle(StyleManager.getDayStyle());
    setupRouteOutline();
    startNaviCountDown(5);
    return this.mGroupView;
  }
  
  private void selectRoute(int paramInt)
  {
    if (RGMultiRouteModel.getInstance().isAvoidTrafficStatus) {
      BNMapController.getInstance().setHighLightAvoidTrafficRoute(paramInt);
    }
    for (;;)
    {
      NMapControlProxy.getInstance().updateLayer(10);
      return;
      BNMapController.getInstance().setHighLightRoute(paramInt);
    }
  }
  
  private void setListner()
  {
    if (this.mRouteDetailLL != null) {
      this.mRouteDetailLL.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          RGRouteDetailsView.this.cancleCountDownTask();
          return true;
        }
      });
    }
    if (this.mStartNaviLL != null) {
      this.mStartNaviLL.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (ForbidDaulClickUtils.isFastDoubleClick()) {
            return;
          }
          RGRouteDetailsView.this.cancleCountDownTask();
          BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410272", "410272");
          UserOPController.getInstance().add("2.2");
          BNRouteGuider.getInstance().setUserChooseRouteBit(RGRouteDetailsView.this.getRouteSelectedInt());
          RGRouteDetailsView.this.startRealNavi();
        }
      });
    }
    if (this.mBtnBack != null) {
      this.mBtnBack.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (ForbidDaulClickUtils.isFastDoubleClick()) {
            return;
          }
          BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410268", "410268");
          UserOPController.getInstance().add("1.5", "2", null, null);
          RGRouteDetailsView.this.cancleCountDownTask();
          RGRouteDetailsView.this.onBackPressed();
        }
      });
    }
    if (this.mBtnOpenPreference != null) {
      this.mBtnOpenPreference.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410269", "410269");
          UserOPController.getInstance().add("2.5");
          RGRouteDetailsView.this.cancleCountDownTask();
          RGRouteDetailsView.this.showRoutePlanPreferenceDialog();
        }
      });
    }
    if (this.mGroupView != null) {
      this.mGroupView.setOnTouchListener(new View.OnTouchListener()
      {
        public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          RGRouteDetailsView.this.cancleCountDownTask();
          return false;
        }
      });
    }
  }
  
  private void setRouteSelected(int paramInt)
  {
    if (this.routesSelected == null) {}
    while ((paramInt < 0) || (paramInt >= 3)) {
      return;
    }
    this.routesSelected[paramInt] = 1;
  }
  
  private void setupRouteOutline()
  {
    if ((this.mRoutePlanModel == null) || (this.mRoutePlanOutlineItemList == null) || (this.mRouteOutlineLL == null)) {}
    final Object localObject1;
    final int i;
    Object localObject2;
    for (;;)
    {
      return;
      if (this.mViewList == null) {
        this.mViewList = new ArrayList();
      }
      for (;;)
      {
        LogUtil.e("wangyang", "before getRouteOutlineData()=" + this.mRoutePlanModel.getRouteOutlineData() + "getRouteOutlineData.size =" + this.mRoutePlanModel.getRouteOutlineData().size());
        if ((this.mRoutePlanModel.getRouteOutlineData() != null) && (this.mRoutePlanModel.getRouteOutlineData().size() != 0)) {
          break label238;
        }
        int j = BNRoutePlaner.getInstance().getRouteCnt();
        localObject1 = new ArrayList();
        i = 0;
        while (i < j)
        {
          localObject2 = new Bundle();
          BNRoutePlaner.getInstance().getRouteInfo(i, (Bundle)localObject2);
          ((ArrayList)localObject1).add(localObject2);
          i += 1;
        }
        this.mViewList.clear();
      }
      this.mRoutePlanModel.parseRouteResultOutline((ArrayList)localObject1);
      LogUtil.e("wangyang", "after getRouteOutlineData()=" + this.mRoutePlanModel.getRouteOutlineData() + "getRouteOutlineData.size =" + this.mRoutePlanModel.getRouteOutlineData().size());
      label238:
      this.mRoutePlanOutlineItemList.clear();
      this.mRoutePlanOutlineItemList.addAll(this.mRoutePlanModel.getRouteOutlineData());
      this.mRouteOutlineLL.removeAllViews();
      NaviState.getInstance().notifyRouteDetail(true, this.mRoutePlanOutlineItemList.size());
      i = 0;
      while (i < this.mRoutePlanOutlineItemList.size())
      {
        localObject2 = (RoutePlanOutlineItem)this.mRoutePlanOutlineItemList.get(i);
        localObject1 = new RGRouteDetailsOutlineItemView(this.mActivity);
        if (((RGRouteDetailsOutlineItemView)localObject1).isInitSucceeded()) {
          break label333;
        }
        i += 1;
      }
    }
    label333:
    this.mViewList.add(localObject1);
    ((RGRouteDetailsOutlineItemView)localObject1).setData(((RoutePlanOutlineItem)localObject2).getPassTimeStr(), ((RoutePlanOutlineItem)localObject2).getLengthStr(), getLabelName(), ((RoutePlanOutlineItem)localObject2).getLights(), i);
    if (this.mRoutePlanOutlineItemList.size() <= this.mCurrentRouteIndex) {
      if (i == 0)
      {
        this.mCurrentRouteIndex = i;
        ((RGRouteDetailsOutlineItemView)localObject1).focusItem();
        BNRoutePlaner.getInstance().selectRoute(i);
        selectRoute(i);
      }
    }
    for (;;)
    {
      ((RGRouteDetailsOutlineItemView)localObject1).setTragOpenListener(new RGRouteDetailsOutlineItemView.OnDragOpenListener()
      {
        public void onClick()
        {
          if (new ForbidDaulClickUtilsNonStatic().isFastDoubleClick()) {}
          do
          {
            return;
            localObject = RGRouteDetailsView.this.mStatItem;
            ((RoutePlanStatItem)localObject).mSwitchRouteCount += 1;
            RGRouteDetailsView.this.cancleCountDownTask();
          } while (RGRouteDetailsView.this.mCurrentRouteIndex == i);
          RGRouteDetailsView.access$402(RGRouteDetailsView.this, i);
          RGRouteDetailsView.this.mRoutePlanModel.setCurIndex(i);
          Object localObject = RGRouteDetailsView.this.mViewList.iterator();
          while (((Iterator)localObject).hasNext()) {
            ((RGRouteDetailsOutlineItemView)((Iterator)localObject).next()).unfocusItem();
          }
          localObject1.focusItem();
          BNRoutePlaner.getInstance().selectRoute(i);
          RGRouteDetailsView.this.selectRoute(i);
          RGRouteDetailsView.this.updateIndicator(i);
        }
        
        public void onOpen() {}
      });
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      this.mRouteOutlineLL.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      break;
      ((RGRouteDetailsOutlineItemView)localObject1).unfocusItem();
      continue;
      if (i == this.mCurrentRouteIndex)
      {
        ((RGRouteDetailsOutlineItemView)localObject1).focusItem();
        BNRoutePlaner.getInstance().selectRoute(i);
        selectRoute(i);
      }
      else
      {
        ((RGRouteDetailsOutlineItemView)localObject1).unfocusItem();
      }
    }
  }
  
  private void showRoutePlanPreferenceDialog()
  {
    if (this.mRoutePlanPreferenceDialogAdapter == null) {
      this.mRoutePlanPreferenceDialogAdapter = new RoutePlanPreferenceDialogAdapter(this.mActivity);
    }
    if (this.mRoutePlanPreferenceDialog == null)
    {
      this.mRoutePlanPreferenceDialog = new f(this.mActivity, this.mRoutePlanPreferenceDialogAdapter, new AdapterView.OnItemClickListener()
      {
        public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          RGRouteDetailsView.this.mOnDialogListener.dismissDialog(RGRouteDetailsView.this.mRoutePlanPreferenceDialog);
          AdapterView.OnItemClickListener localOnItemClickListener = RGRouteDetailsView.this.mRoutePlanPreferenceDialogAdapter.getOnItemClickListener();
          if (localOnItemClickListener != null) {
            localOnItemClickListener.onItemClick(paramAnonymousAdapterView, paramAnonymousView, paramAnonymousInt, paramAnonymousLong);
          }
        }
      });
      this.mRoutePlanPreferenceDialog.j();
    }
    for (;;)
    {
      this.mOnDialogListener.showDialog(this.mRoutePlanPreferenceDialog, BaseDialog.a.b);
      return;
      this.mOnDialogListener.dismissDialog(this.mRoutePlanPreferenceDialog);
    }
  }
  
  private void startNavi(final boolean paramBoolean)
  {
    Object localObject;
    int i;
    if (this.mBNRouteDetailsListener != null)
    {
      localObject = new Bundle();
      i = BNRoutePlaner.getInstance().getRouteInfo(this.mCurrentRouteIndex, (Bundle)localObject);
      if (i != 0) {
        break label40;
      }
      LogUtil.e("RoutePlan", "step route info: error");
    }
    label40:
    do
    {
      return;
      if (i == 1)
      {
        LogUtil.e("RoutePlan", "step route info: part");
        BNRoutePlaner.getInstance().notifyObservers(1, 1, null);
        BNRoutePlaner.getInstance().setRouteInfoHandler(new Handler(Looper.getMainLooper())
        {
          public void handleMessage(Message paramAnonymousMessage)
          {
            BNRoutePlaner.getInstance().clearRouteInfoHandler();
            if (paramAnonymousMessage.what == 4170) {
              RGRouteDetailsView.this.startNavi(paramBoolean);
            }
            while (paramAnonymousMessage.what != 4173) {
              return;
            }
          }
        });
        return;
      }
      if (i == 2) {
        LogUtil.e("RoutePlan", "step route info: all");
      }
      this.mBNRouteDetailsListener.onStartNavi(paramBoolean);
    } while (!paramBoolean);
    NaviStatItem.getInstance().setStartNaviFrom(9);
    if ((this.mRoutePlanOutlineItemList != null) && (this.mCurrentRouteIndex >= 0) && (this.mCurrentRouteIndex < this.mRoutePlanOutlineItemList.size()))
    {
      localObject = (RoutePlanOutlineItem)this.mRoutePlanOutlineItemList.get(this.mCurrentRouteIndex);
      if (localObject != null) {
        NaviStatItem.getInstance().setRoutePlanTimeAndDist(((RoutePlanOutlineItem)localObject).getPassTime(), ((RoutePlanOutlineItem)localObject).getLength());
      }
    }
    UserOPController.getInstance().add("2.3.3");
  }
  
  private void startRealNavi()
  {
    m.a().b();
    Bundle localBundle;
    int i;
    if (this.mBNRouteDetailsListener != null)
    {
      localBundle = new Bundle();
      i = BNRoutePlaner.getInstance().getRouteInfo(this.mCurrentRouteIndex, localBundle);
      if (i != 0) {
        break label81;
      }
      LogUtil.e("RoutePlan", "step route info: error");
      if ((this.mRoutePlanModel != null) && (this.mRoutePlanModel.getRouteInput().size() > 1)) {
        BNRoutePlaner.getInstance().setPointsToCalcRoute(this.mRoutePlanModel.getRouteInput(), 0);
      }
    }
    return;
    label81:
    if (i == 1)
    {
      LogUtil.e("RoutePlan", "step route info: part");
      BNRoutePlaner.getInstance().notifyObservers(1, 1, null);
      BNRoutePlaner.getInstance().setRouteInfoHandler(new Handler(Looper.getMainLooper())
      {
        public void handleMessage(Message paramAnonymousMessage)
        {
          BNRoutePlaner.getInstance().clearRouteInfoHandler();
          if (paramAnonymousMessage.what == 4170) {
            RGRouteDetailsView.this.startRealNavi();
          }
          while (paramAnonymousMessage.what != 4173) {
            return;
          }
        }
      });
      return;
    }
    if (i == 2) {
      LogUtil.e("RoutePlan", "step route info: all");
    }
    this.mRoutePlanModel.parseRouteResult(this.mActivity.getApplicationContext(), localBundle);
    if (this.mIsSeeOtherRoute) {
      this.mBNRouteDetailsListener.onSwitchOtherRoute(this.mCurrentRouteIndex);
    }
    for (;;)
    {
      statistics(true);
      return;
      this.mBNRouteDetailsListener.onStartRealNavi();
    }
  }
  
  private void statistics(boolean paramBoolean)
  {
    this.mStatItem.mStartNavi = paramBoolean;
    this.mStatItem.mRouteIndex = this.mCurrentRouteIndex;
    this.mStatItem.mRouteCount = BNRoutePlaner.getInstance().getRouteCnt();
    LogUtil.e("RoutePlan", "stat test route routecount = " + this.mStatItem.mRouteCount);
    this.mStatItem.mRouteSwitchEndTime = SystemClock.elapsedRealtime();
    NaviStatItem.getInstance().setStartNaviFrom(1);
    if ((this.mRoutePlanOutlineItemList != null) && (this.mCurrentRouteIndex >= 0) && (this.mCurrentRouteIndex < this.mRoutePlanOutlineItemList.size()))
    {
      RoutePlanOutlineItem localRoutePlanOutlineItem = (RoutePlanOutlineItem)this.mRoutePlanOutlineItemList.get(this.mCurrentRouteIndex);
      if (localRoutePlanOutlineItem != null)
      {
        NaviStatItem.getInstance().setRoutePlanTimeAndDist(localRoutePlanOutlineItem.getPassTime(), localRoutePlanOutlineItem.getLength());
        this.mStatItem.setRoutePlanTimeAndDist(localRoutePlanOutlineItem.getPassTime(), localRoutePlanOutlineItem.getLength());
      }
    }
    if (!paramBoolean) {
      NaviStatItem.getInstance().init();
    }
    this.mStatItem.onEvent();
  }
  
  private void updatePreferenceView()
  {
    this.routeSortList = RGRouteSortController.getInstance().getRouteSortList();
    String str = "智能推荐";
    int i = 0;
    for (;;)
    {
      Object localObject = str;
      if (i < this.routeSortList.size())
      {
        localObject = (RGRouteSortModel)this.routeSortList.get(i);
        if ((localObject != null) && ((((RGRouteSortModel)localObject).mPreferValue & RGRouteSortController.getInstance().getPreferValue()) != 0) && (!TextUtils.isEmpty(((RGRouteSortModel)localObject).mItemName))) {
          localObject = ((RGRouteSortModel)localObject).mItemName;
        }
      }
      else
      {
        if (this.mTvPreference != null) {
          this.mTvPreference.setText((CharSequence)localObject);
        }
        return;
      }
      i += 1;
    }
  }
  
  public void cancleCountDownTask()
  {
    if (this.mIsCountDowning)
    {
      if ((this.mCountDownTask != null) && (!this.mCountDownTask.isCancelled()))
      {
        this.mCountDownTask.cancelCountDown();
        this.mCountDownTask = null;
      }
      this.mIsCountDowning = false;
      if (this.mStartNaviTextView != null) {
        this.mStartNaviTextView.setVisibility(8);
      }
    }
  }
  
  public void destory()
  {
    LogUtil.e("RoutePlan", "destory======");
    if (this.mRPHandler != null) {
      this.mRPHandler.removeCallbacks(this.runnable);
    }
    cancleCountDownTask();
  }
  
  public View getBtnBack()
  {
    return this.mBtnBack;
  }
  
  public View getBtnOpenPreference()
  {
    return this.mBtnOpenPreference;
  }
  
  public View getRootView()
  {
    return this.mGroupView;
  }
  
  public View getStartNaviLL()
  {
    return this.mStartNaviLL;
  }
  
  public ArrayList<RGRouteDetailsOutlineItemView> getViewList()
  {
    return this.mViewList;
  }
  
  public boolean onBackPressed()
  {
    RGParkPointModel.getInstance().setCanParkPoiShow(true);
    RGParkPointModel.getInstance().setDoneWithParkSearch(false);
    if (this.mBNRouteDetailsListener != null) {
      this.mBNRouteDetailsListener.onPageJump(1, null);
    }
    return true;
  }
  
  public void onHide()
  {
    BNRoutePlaner.getInstance().removeRouteResultHandler(this.mRPHandler);
    BNMapController.getInstance().deleteObserver(this.mBNMapObserver);
    NaviState.getInstance().notifyRouteDetail(false, 0);
  }
  
  public void onShow()
  {
    if (this.mBNRouteDetailsListener != null) {
      this.mBNRouteDetailsListener.onShowSidePanel();
    }
    BNRoutePlaner.getInstance().addRouteResultHandler(this.mRPHandler);
    BNMapController.getInstance().addObserver(this.mBNMapObserver);
    if (this.mRoutePlanOutlineItemList != null) {
      NaviState.getInstance().notifyRouteDetail(true, this.mRoutePlanOutlineItemList.size());
    }
  }
  
  public void onUpdateOrientation()
  {
    this.mForbidRouteMapClick = false;
    initViews();
    setListner();
    if (this.mBNRouteDetailsListener != null) {
      this.mBNRouteDetailsListener.onResetMapCtrlPanel();
    }
    initMap();
  }
  
  public void onUpdateStyle(boolean paramBoolean)
  {
    if ((this.mRlPreference == null) || (this.mIvBack == null)) {
      return;
    }
    this.mRlPreference.setBackground(StyleManager.getDrawable(2130838852));
    this.mIvBack.setBackground(StyleManager.getDrawable(2130838852));
  }
  
  public boolean onVoiceCommand(int paramInt1, int paramInt2, int paramInt3, Object paramObject, boolean paramBoolean)
  {
    if ((paramInt1 == 3) && (paramInt2 == 3))
    {
      if (chooseRoute(paramInt3 - 21))
      {
        BNVoiceCommandController.getInstance().commonVoiceCommandResponse(paramInt1, 1);
        return true;
      }
      BNVoiceCommandController.getInstance().commonVoiceCommandResponse(paramInt1, 2);
      return true;
    }
    if (paramInt1 == 2) {}
    switch (paramInt2)
    {
    default: 
      return false;
    case 65: 
      cancleCountDownTask();
      BNRouteGuider.getInstance().setUserChooseRouteBit(getRouteSelectedInt());
      startRealNavi();
      BNVoiceCommandController.getInstance().commonVoiceCommandResponse(paramInt1, 1);
      return true;
    case 66: 
      if (chooseRoute(paramInt3))
      {
        BNVoiceCommandController.getInstance().commonVoiceCommandResponse(paramInt1, 1);
        return true;
      }
      BNVoiceCommandController.getInstance().commonVoiceCommandResponse(paramInt1, 2);
      return true;
    }
    if (chooseRouteIndex(paramInt3 - 1))
    {
      BNVoiceCommandController.getInstance().commonVoiceCommandResponse(paramInt1, 1);
      return true;
    }
    BNVoiceCommandController.getInstance().commonVoiceCommandResponse(paramInt1, 2);
    return true;
  }
  
  public void setBNRouteDetailsListener(IBNRouteDetailsListener paramIBNRouteDetailsListener)
  {
    this.mBNRouteDetailsListener = paramIBNRouteDetailsListener;
  }
  
  public void startNaviCountDown(int paramInt)
  {
    if (!this.mIsSeeOtherRoute)
    {
      this.mIsCountDowning = true;
      if ((this.mCountDownTask != null) && (!this.mCountDownTask.isCancelled())) {
        this.mCountDownTask.cancelCountDown();
      }
      if (this.mIsFisrtCountDown)
      {
        this.mCountDownTask = new NaviCountDownTask(null);
        this.mCountDownTask.execute(new Integer[] { Integer.valueOf(paramInt) });
        if (this.mStartNaviTextView != null) {
          this.mStartNaviTextView.setVisibility(0);
        }
      }
      this.mIsFisrtCountDown = false;
    }
    while (this.mStartNaviTextView == null) {
      return;
    }
    this.mStartNaviTextView.setVisibility(8);
  }
  
  public void updateData(Bundle paramBundle) {}
  
  public void updateIndicator(int paramInt)
  {
    if ((this.mViewList == null) || (paramInt < 0) || (paramInt >= this.mViewList.size())) {
      return;
    }
    setRouteSelected(paramInt);
    initMap();
  }
  
  public void updateMapViewForRPNode(ArrayList<RoutePlanNode> paramArrayList, Rect paramRect)
  {
    if (paramArrayList == null) {
      return;
    }
    int k = Integer.MAX_VALUE;
    int m = 0;
    int i1 = Integer.MAX_VALUE;
    int j = 0;
    int n = 0;
    label24:
    if (n < paramArrayList.size())
    {
      localObject = (RoutePlanNode)paramArrayList.get(n);
      int i4;
      if (localObject == null)
      {
        i2 = m;
        i4 = k;
        i3 = i1;
      }
      for (;;)
      {
        n += 1;
        i1 = i3;
        k = i4;
        m = i2;
        break label24;
        localObject = ((RoutePlanNode)localObject).getGeoPoint();
        if (!((GeoPoint)localObject).isValid()) {
          break;
        }
        i = k;
        if (k > ((GeoPoint)localObject).getLongitudeE6()) {
          i = ((GeoPoint)localObject).getLongitudeE6();
        }
        k = m;
        if (m < ((GeoPoint)localObject).getLongitudeE6()) {
          k = ((GeoPoint)localObject).getLongitudeE6();
        }
        m = j;
        if (j < ((GeoPoint)localObject).getLatitudeE6()) {
          m = ((GeoPoint)localObject).getLatitudeE6();
        }
        i3 = i1;
        i4 = i;
        i2 = k;
        j = m;
        if (i1 > ((GeoPoint)localObject).getLatitudeE6())
        {
          i3 = ((GeoPoint)localObject).getLatitudeE6();
          i4 = i;
          i2 = k;
          j = m;
        }
      }
    }
    paramArrayList = CoordinateTransformUtil.LLE62MC(m, i1);
    Object localObject = CoordinateTransformUtil.LLE62MC(k, j);
    int i2 = paramArrayList.getInt("MCx");
    n = paramArrayList.getInt("MCy");
    int i3 = ((Bundle)localObject).getInt("MCx");
    i1 = ((Bundle)localObject).getInt("MCy");
    paramArrayList = new Bundle();
    m = n;
    k = i3;
    j = i2;
    int i = i1;
    if (BNRouteGuider.getInstance().getSlightNaviRouteBound(paramArrayList))
    {
      k = paramArrayList.getInt("left", i3);
      j = paramArrayList.getInt("right", i2);
      i = paramArrayList.getInt("top", i1);
      m = paramArrayList.getInt("bottom", n);
    }
    paramArrayList.putLong("left", k);
    paramArrayList.putLong("right", j);
    paramArrayList.putLong("top", i);
    paramArrayList.putLong("bottom", m);
    float f1 = paramRect.right - paramRect.left;
    float f2 = paramRect.bottom - paramRect.top;
    f2 = BNMapController.getInstance().GetZoomToBound(paramArrayList, f1, f2);
    f1 = f2;
    if (f2 >= 18.0F) {
      f1 = 18.0F;
    }
    f2 = (j + k) / 2;
    float f3 = (i + m) / 2;
    paramArrayList = BNMapController.getInstance().getMapStatus();
    float f4 = ScreenUtil.getInstance().dip2px(40);
    float f5 = paramRect.left - (ScreenUtil.getInstance().getHeightPixels() - paramRect.right) >> 1;
    if (paramArrayList != null)
    {
      paramArrayList._Yoffset = (f4);
      paramArrayList._Xoffset = (f5);
      paramArrayList._CenterPtX = ((int)f2);
      paramArrayList._CenterPtY = ((int)f3);
      paramArrayList._Level = (f1 * 0.95F);
      paramArrayList._Overlooking = 0;
      paramArrayList._Rotation = 0;
    }
    BNMapController.getInstance().setMapStatus(paramArrayList, MapController.AnimationType.eAnimationAll);
  }
  
  private class NaviCountDownTask
    extends AsyncTask<Integer, Integer, Void>
  {
    private NaviCountDownTask() {}
    
    public void cancelCountDown()
    {
      if ((RGRouteDetailsView.this.mStartNaviTextView != null) && (RGRouteDetailsView.this.mActivity != null)) {
        RGRouteDetailsView.this.mStartNaviTextView.setText("");
      }
      cancel(true);
    }
    
    protected Void doInBackground(Integer... paramVarArgs)
    {
      int i = paramVarArgs[0].intValue();
      for (;;)
      {
        if ((i <= 0) || (isCancelled())) {
          return null;
        }
        publishProgress(new Integer[] { Integer.valueOf(i) });
        try
        {
          Thread.sleep(1000L);
          i -= 1;
        }
        catch (InterruptedException paramVarArgs)
        {
          for (;;) {}
        }
      }
    }
    
    protected void onPostExecute(Void paramVoid)
    {
      if (isCancelled()) {}
      while ((ForbidDaulClickUtils.isFastDoubleClick()) || (RGRouteDetailsView.this.mActivity == null)) {
        return;
      }
      UserOPController.getInstance().add("2.2");
      RGRouteDetailsView.this.startRealNavi();
    }
    
    protected void onProgressUpdate(Integer... paramVarArgs)
    {
      if ((RGRouteDetailsView.this.mStartNaviTextView != null) && (RGRouteDetailsView.this.mActivity != null)) {
        RGRouteDetailsView.this.mStartNaviTextView.setText(String.format("(%dS)", new Object[] { paramVarArgs[0] }));
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/routedetails/RGRouteDetailsView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */