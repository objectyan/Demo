package com.baidu.navi.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.carlife.adpter.p;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.j;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;
import com.baidu.carlife.util.w;
import com.baidu.carlife.view.LoadMoreFooter;
import com.baidu.carlife.view.SwitchButton;
import com.baidu.carlife.view.routerecordprocessview.CycleProcessBar;
import com.baidu.navi.controller.AccountController;
import com.baidu.navi.controller.AccountController.IAccountListener;
import com.baidu.navi.controller.UserCenterController;
import com.baidu.navi.track.common.TrackConfig;
import com.baidu.navi.track.common.TrackConfigUtil;
import com.baidu.navi.track.database.DataBaseConstants.TrackQueryType;
import com.baidu.navi.track.datashop.TrackDataShop;
import com.baidu.navi.track.datashop.TrackShopEvent;
import com.baidu.navi.track.model.CarNavi;
import com.baidu.navi.track.model.CarNaviModel;
import com.baidu.navi.track.model.NaviPoint;
import com.baidu.navi.track.model.TrackAcmp;
import com.baidu.navi.track.sync.TrackDataSync;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navi.util.StatisticManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class RouteRecordFragment
  extends ContentFragment
  implements View.OnClickListener, com.baidu.carlife.h.b
{
  public static final int MSG_DELAY_HIDE_PROGRESS = 9797979;
  private final int ALL_ROUTE_MILEAGE_MAX = 5000;
  private final int LONGEST_STRING = 7;
  private final int MAX_RECORD_NUM = 20;
  private final int SINGLE_LONGEST_TIME_MAX = 1440;
  private final int WEEK_ROUTE_MILEAGE_MAX = 3000;
  private boolean isEditable = false;
  private SwitchButton journeyRecord;
  private int mAllRouteMileage = 0;
  private CycleProcessBar mAllRouteMileagePV;
  private TextView mAllRouteMileageTV;
  ImageButton mBtnBack;
  private com.baidu.carlife.view.dialog.e mCommonProgressDialog;
  private ImageButton mEditBtn;
  private TextView mFinishBtn;
  private com.baidu.carlife.f.c mFocusListView;
  private g mFocusTitlebar;
  private LinearLayout mHeaderLayout;
  private View mInpageProcessDialog;
  private boolean mIsFocusable = false;
  private boolean mIsHeaderSyncFinish = true;
  private boolean mIsListItemSyncFinish = true;
  private boolean mIsNoMoreData = false;
  private boolean mIsTriggerLoadMore = false;
  private int mLastRecordTimeStamp = 0;
  private LoadMoreFooter mListFooter;
  private ListView mListView;
  private View mListViewHeader;
  private MsgManualSyncHandler mMsgManualSyncHandler;
  private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener()
  {
    public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      boolean bool2 = true;
      boolean bool1;
      if ((paramAnonymousInt == 0) && (RouteRecordFragment.this.recordHeader.getVisibility() == 0))
      {
        boolean bool3 = TrackConfigUtil.getInstance().getRouteRecordFlag();
        paramAnonymousAdapterView = TrackConfigUtil.getInstance();
        if (!bool3)
        {
          bool1 = true;
          paramAnonymousAdapterView.setRouteRecordFlag(bool1);
          paramAnonymousAdapterView = RouteRecordFragment.this.journeyRecord;
          if (bool3) {
            break label76;
          }
          bool1 = bool2;
          label63:
          paramAnonymousAdapterView.setChecked(bool1);
        }
      }
      label76:
      label120:
      do
      {
        do
        {
          return;
          bool1 = false;
          break;
          bool1 = false;
          break label63;
          if (paramAnonymousLong < 0L) {
            break label120;
          }
        } while ((!RouteRecordFragment.this.isEditable) || (!RouteRecordFragment.this.mIsFocusable));
        RouteRecordFragment.this.deleteRecordItem((int)paramAnonymousLong);
        return;
      } while (RouteRecordFragment.this.mIsNoMoreData);
      RouteRecordFragment.access$702(RouteRecordFragment.this, true);
      RouteRecordFragment.this.mListFooter.a();
      RouteRecordFragment.this.getStatisticsInfo();
      RouteRecordFragment.this.getRouteRecord();
    }
  };
  private List<com.baidu.carlife.model.k> mRouteRecordList;
  private p mRouteRecordListAdapter;
  private com.baidu.carlife.view.dialog.c mSettingPromptDialog;
  private boolean mShowDialoged = false;
  private int mSingleLongestTime = 0;
  private CycleProcessBar mSingleLongestTimePV;
  private TextView mSingleLongestTimeTV;
  private ImageButton mSyncBtn;
  private Object mSyncStatusLock = new Object();
  private TextView mTitleDescTV;
  private TextView mUnitMinuteTV;
  private int mWeekRouteMileage = 0;
  private CycleProcessBar mWeekRouteMileagePV;
  private TextView mWeekRouteMileageTV;
  private RelativeLayout recordHeader;
  
  private void addRouteRecordModel(CarNaviModel paramCarNaviModel)
  {
    com.baidu.carlife.model.k localk = new com.baidu.carlife.model.k();
    localk.b = stringCut(paramCarNaviModel.getPBData().getStartPoint().getAddr());
    localk.c = stringCut(paramCarNaviModel.getPBData().getEndPoint().getAddr());
    double d = 1.0D * paramCarNaviModel.getPBData().getDistance() / 1000.0D;
    localk.d = (String.format("%.2f", new Object[] { Double.valueOf(d) }) + "km");
    int i = paramCarNaviModel.getPBData().getDuration() / 60;
    localk.e = ("" + i + getResources().getString(2131296596));
    i = (int)(paramCarNaviModel.getPBData().getAvgSpeed() / 1000.0D * 3600.0D);
    localk.f = ("" + i + "km/h");
    String[] arrayOfString = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date(1L * paramCarNaviModel.getPBData().getCtime() * 1000L)).trim().split(" ");
    if (arrayOfString.length > 0) {
      localk.g = arrayOfString[0];
    }
    if (arrayOfString.length > 1) {
      localk.h = arrayOfString[1];
    }
    localk.i = paramCarNaviModel;
    localk.k = this;
    routeRecordListAddItem(localk);
  }
  
  private void afterSyncProcess()
  {
    if (isSyncFinished())
    {
      showUpdateWidget();
      hideInPageProcessDialog();
    }
  }
  
  private void beforeSyncProcess()
  {
    hideUpdateWidget();
    showInPageProcessDialog();
  }
  
  private void clearRouteRecordList()
  {
    this.mLastRecordTimeStamp = 0;
    this.mRouteRecordListAdapter.notifyDataSetInvalidated();
    this.mRouteRecordList.clear();
  }
  
  private void disableEdit()
  {
    showEditIcon();
    if ((com.baidu.carlife.l.a.a().N()) && (!isLogin())) {
      this.mSyncBtn.setVisibility(8);
    }
    for (;;)
    {
      this.mHeaderLayout.setVisibility(0);
      this.recordHeader.setVisibility(8);
      Iterator localIterator = this.mRouteRecordList.iterator();
      while (localIterator.hasNext()) {
        ((com.baidu.carlife.model.k)localIterator.next()).a = false;
      }
      this.mSyncBtn.setVisibility(0);
    }
    getStatisticsInfo();
    this.mRouteRecordListAdapter.notifyDataSetChanged();
  }
  
  private void drivingDisableClick()
  {
    this.mEditBtn.setAlpha(0.2F);
    this.mEditBtn.setEnabled(false);
    if (isLogin())
    {
      this.mSyncBtn.setAlpha(1.0F);
      this.mSyncBtn.setEnabled(true);
      return;
    }
    this.mSyncBtn.setAlpha(0.2F);
    this.mSyncBtn.setEnabled(false);
  }
  
  private void drivingEnabledClick()
  {
    this.mEditBtn.setAlpha(1.0F);
    this.mEditBtn.setEnabled(true);
    this.mSyncBtn.setAlpha(1.0F);
    this.mSyncBtn.setEnabled(true);
  }
  
  private void enableEdit()
  {
    showFinishIcon();
    this.mSyncBtn.setVisibility(8);
    this.mHeaderLayout.getVisibility();
    this.mHeaderLayout.setVisibility(8);
    this.recordHeader.setVisibility(0);
    this.recordHeader.setEnabled(true);
    Iterator localIterator = this.mRouteRecordList.iterator();
    while (localIterator.hasNext())
    {
      com.baidu.carlife.model.k localk = (com.baidu.carlife.model.k)localIterator.next();
      localk.a = true;
      if (this.mIsFocusable) {
        localk.j = true;
      } else {
        localk.j = false;
      }
    }
    this.mRouteRecordListAdapter.notifyDataSetChanged();
    if (this.mListView.getFirstVisiblePosition() <= 0) {
      this.mListView.smoothScrollToPosition(0);
    }
  }
  
  private String getCurrentDateTime()
  {
    return new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date(TrackConfig.getInstance().getLastSyncTime()));
  }
  
  private String getManualSyncTime()
  {
    return getContext().getSharedPreferences("CarLife_Temp", 0).getString("RouteRecordManualSyncTimeFlag", null);
  }
  
  private void getRouteRecord()
  {
    setmIsListItemSyncStatus(false);
    beforeSyncProcess();
    Handler local4 = new Handler(Looper.getMainLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        default: 
          return;
        }
        TrackShopEvent localTrackShopEvent = (TrackShopEvent)paramAnonymousMessage.obj;
        if (localTrackShopEvent.status == 0)
        {
          RouteRecordFragment.this.setmIsListItemSyncStatus(true);
          RouteRecordFragment.this.afterSyncProcess();
          paramAnonymousMessage = null;
          Iterator localIterator = localTrackShopEvent.list.iterator();
          while (localIterator.hasNext())
          {
            paramAnonymousMessage = (CarNaviModel)localIterator.next();
            RouteRecordFragment.this.addRouteRecordModel(paramAnonymousMessage);
          }
          RouteRecordFragment.this.updateRouteRecordModelList();
          if (paramAnonymousMessage != null) {
            RouteRecordFragment.access$2302(RouteRecordFragment.this, paramAnonymousMessage.getPBData().getCtime());
          }
        }
        while ((localTrackShopEvent.status == 0) && (localTrackShopEvent.list.size() < 20))
        {
          RouteRecordFragment.this.mListFooter.setTextContent(com.baidu.carlife.core.a.a().getString(2131296916));
          RouteRecordFragment.access$602(RouteRecordFragment.this, true);
          return;
          RouteRecordFragment.this.syncFailedPrompt();
        }
        RouteRecordFragment.this.mListFooter.setTextContent(RouteRecordFragment.this.getResources().getString(2131296915));
        RouteRecordFragment.access$602(RouteRecordFragment.this, false);
      }
    };
    TrackDataShop.getInstance().fetchTrackList(local4, NaviAccountUtils.getInstance().getUid(), this.mLastRecordTimeStamp, DataBaseConstants.TrackQueryType.CAR);
  }
  
  private void getStatisticsInfo()
  {
    setHeaderSyncStatus(false);
    beforeSyncProcess();
    Handler local3 = new Handler(Looper.getMainLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        default: 
          return;
        }
        paramAnonymousMessage = (TrackShopEvent)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.status == 0)
        {
          RouteRecordFragment.this.setHeaderSyncStatus(true);
          RouteRecordFragment.this.afterSyncProcess();
          RouteRecordFragment.access$1302(RouteRecordFragment.this, paramAnonymousMessage.statistic.getCarNintaviDistance() / 1000);
          RouteRecordFragment.access$1402(RouteRecordFragment.this, paramAnonymousMessage.statistic.getCarWeekMileage() / 1000);
          RouteRecordFragment.access$1502(RouteRecordFragment.this, paramAnonymousMessage.statistic.getCarMaxDuration() / 60);
          RouteRecordFragment.this.setAllRouteMileage(RouteRecordFragment.this.mAllRouteMileage);
          RouteRecordFragment.this.setWeekRouteMileage(RouteRecordFragment.this.mWeekRouteMileage);
          RouteRecordFragment.this.setSingleLogestTime(RouteRecordFragment.this.mSingleLongestTime);
          return;
        }
        RouteRecordFragment.this.syncFailedPrompt();
      }
    };
    TrackDataShop.getInstance().fetchStatistics(local3, 0);
  }
  
  private void hideEditFinishIcon()
  {
    this.mEditBtn.setVisibility(8);
    this.mFinishBtn.setVisibility(8);
  }
  
  private void hideInPageProcessDialog()
  {
    this.mMsgManualSyncHandler.sendEmptyMessageDelayed(9797979, 500L);
  }
  
  private void hideUpdateWidget()
  {
    this.mSyncBtn.setVisibility(8);
    this.mFinishBtn.setVisibility(8);
    this.mEditBtn.setVisibility(8);
    this.mListFooter.setStatus(0);
  }
  
  private void init(View paramView)
  {
    setCommonTitleBar(paramView, getResources().getStringArray(2131230728)[0]);
    this.mBtnBack = ((ImageButton)paramView.findViewById(2131624258));
    this.mBtnBack.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (RouteRecordFragment.this.isEditable)
        {
          RouteRecordFragment.this.quitEdit();
          return;
        }
        RouteRecordFragment.this.back();
      }
    });
    this.mTitleDescTV = ((TextView)paramView.findViewById(2131624262));
    this.mTitleDescTV.setVisibility(0);
    this.mListView = ((ListView)paramView.findViewById(2131624353));
    this.mListView.setOverScrollMode(2);
    this.mListView.setFooterDividersEnabled(false);
    this.mListViewHeader = LayoutInflater.from(mActivity).inflate(2130969055, this.mListView, false);
    this.mHeaderLayout = ((LinearLayout)this.mListViewHeader.findViewById(2131626171));
    this.mAllRouteMileagePV = ((CycleProcessBar)this.mListViewHeader.findViewById(2131626172).findViewById(2131626168));
    this.mWeekRouteMileagePV = ((CycleProcessBar)this.mListViewHeader.findViewById(2131626173).findViewById(2131626168));
    this.mSingleLongestTimePV = ((CycleProcessBar)this.mListViewHeader.findViewById(2131626174).findViewById(2131626168));
    this.mAllRouteMileageTV = ((TextView)this.mListViewHeader.findViewById(2131626172).findViewById(2131626169));
    this.mWeekRouteMileageTV = ((TextView)this.mListViewHeader.findViewById(2131626173).findViewById(2131626169));
    this.mSingleLongestTimeTV = ((TextView)this.mListViewHeader.findViewById(2131626174).findViewById(2131626169));
    this.mUnitMinuteTV = ((TextView)this.mListViewHeader.findViewById(2131626174).findViewById(2131626170));
    this.mUnitMinuteTV.setText(getResources().getString(2131296596));
    this.mUnitMinuteTV.setTextSize(12.0F);
    setAllRouteMileage(this.mAllRouteMileage);
    setWeekRouteMileage(this.mWeekRouteMileage);
    setSingleLogestTime(this.mSingleLongestTime);
    View localView = LayoutInflater.from(getActivity()).inflate(2130969002, this.mListView, false);
    this.recordHeader = ((RelativeLayout)localView.findViewById(2131626029));
    ((TextView)this.recordHeader.findViewById(2131624662)).setText(getText(2131296543));
    this.journeyRecord = ((SwitchButton)this.recordHeader.findViewById(2131625241));
    this.journeyRecord.setChecked(TrackConfigUtil.getInstance().getRouteRecordFlag());
    this.journeyRecord.setClickable(false);
    this.recordHeader.setVisibility(8);
    this.recordHeader.setEnabled(false);
    this.mListView.addHeaderView(localView, null, true);
    this.mListView.addHeaderView(this.mListViewHeader, null, false);
    this.mListFooter = new LoadMoreFooter(getContext());
    this.mListFooter.setStatus(1);
    this.mListView.addFooterView(this.mListFooter);
    this.mRouteRecordListAdapter = new p(getContext());
    this.mRouteRecordList = new ArrayList();
    this.mRouteRecordListAdapter.a(this.mRouteRecordList);
    this.mListView.setAdapter(this.mRouteRecordListAdapter);
    this.mListView.setOnItemClickListener(this.mOnItemClickListener);
    this.mSyncBtn = ((ImageButton)paramView.findViewById(2131624263));
    this.mSyncBtn.setImageResource(2130838332);
    this.mSyncBtn.setBackground(com.baidu.carlife.view.a.b.a(mActivity));
    this.mSyncBtn.setVisibility(0);
    this.mSyncBtn.setOnClickListener(this);
    this.mEditBtn = ((ImageButton)paramView.findViewById(2131624264));
    this.mEditBtn.setImageResource(2130838294);
    this.mEditBtn.setBackground(com.baidu.carlife.view.a.b.a(mActivity));
    this.mEditBtn.setOnClickListener(this);
    this.mFinishBtn = ((TextView)paramView.findViewById(2131624265));
    this.mFinishBtn.setBackground(com.baidu.carlife.view.a.b.a(mActivity));
    this.mFinishBtn.setOnClickListener(this);
    this.mInpageProcessDialog = paramView.findViewById(2131625165);
    this.mInpageProcessDialog.setBackgroundColor(getResources().getColor(2131558605));
    ((TextView)this.mInpageProcessDialog.findViewById(2131624648)).setTextColor(getResources().getColor(2131558706));
    this.mMsgManualSyncHandler = new MsgManualSyncHandler(null);
    com.baidu.carlife.core.k.a(this.mMsgManualSyncHandler);
  }
  
  private boolean isLastTimeSyncFinished()
  {
    return !TrackDataSync.getInstance().isSyncing();
  }
  
  private boolean isLogin()
  {
    return NaviAccountUtils.getInstance().isLogin();
  }
  
  private boolean isNetworkAvailable()
  {
    return com.baidu.carlife.core.e.a().r();
  }
  
  private boolean isSyncFinished()
  {
    synchronized (this.mSyncStatusLock)
    {
      return (this.mIsHeaderSyncFinish) && (this.mIsListItemSyncFinish);
    }
  }
  
  private void manualSync()
  {
    if (TrackDataSync.getInstance().manualSync())
    {
      hideUpdateWidget();
      showInPageProcessDialog();
    }
  }
  
  private void quitEdit()
  {
    if (!this.isEditable) {}
    for (boolean bool = true;; bool = false)
    {
      this.isEditable = bool;
      disableEdit();
      return;
    }
  }
  
  private void routeRecordListAddItem(com.baidu.carlife.model.k paramk)
  {
    paramk.a = this.isEditable;
    this.mRouteRecordList.add(paramk);
  }
  
  private void setAllRouteMileage(float paramFloat)
  {
    this.mAllRouteMileageTV.setText("" + (int)paramFloat);
    this.mAllRouteMileagePV.setmPercent(paramFloat / 5000.0F);
  }
  
  private void setFocusListener(View paramView)
  {
    paramView.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          RouteRecordFragment.access$502(RouteRecordFragment.this, true);
        }
      }
    });
  }
  
  private void setHeaderSyncStatus(boolean paramBoolean)
  {
    synchronized (this.mSyncStatusLock)
    {
      this.mIsHeaderSyncFinish = paramBoolean;
      return;
    }
  }
  
  private void setManualSyncTime(String paramString)
  {
    SharedPreferences.Editor localEditor = getContext().getSharedPreferences("CarLife_Temp", 0).edit();
    localEditor.putString("RouteRecordManualSyncTimeFlag", paramString);
    localEditor.commit();
  }
  
  private void setSingleLogestTime(float paramFloat)
  {
    this.mSingleLongestTimeTV.setText("" + (int)paramFloat);
    this.mSingleLongestTimePV.setmPercent(paramFloat / 1440.0F);
  }
  
  private void setWeekRouteMileage(float paramFloat)
  {
    this.mWeekRouteMileageTV.setText("" + (int)paramFloat);
    this.mWeekRouteMileagePV.setmPercent(paramFloat / 3000.0F);
  }
  
  private void setmIsListItemSyncStatus(boolean paramBoolean)
  {
    synchronized (this.mSyncStatusLock)
    {
      this.mIsListItemSyncFinish = paramBoolean;
      return;
    }
  }
  
  private void showEditIcon()
  {
    this.mFinishBtn.setVisibility(8);
    this.mEditBtn.setVisibility(0);
  }
  
  private void showFinishIcon()
  {
    this.mEditBtn.setVisibility(8);
    this.mFinishBtn.setVisibility(0);
  }
  
  private void showInPageProcessDialog()
  {
    if (!this.mIsTriggerLoadMore)
    {
      this.mMsgManualSyncHandler.removeMessages(9797979);
      this.mInpageProcessDialog.setVisibility(0);
    }
  }
  
  private void showSettingPromptDialog(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    this.mSettingPromptDialog = new com.baidu.carlife.view.dialog.c(paramContext);
    this.mSettingPromptDialog.c(2131296913);
    this.mSettingPromptDialog.a(2131296914);
    this.mSettingPromptDialog.a(new com.baidu.carlife.core.screen.b()
    {
      public void onClick()
      {
        RouteRecordFragment.this.dismissDialog(RouteRecordFragment.this.mSettingPromptDialog);
      }
    });
    showDialog(this.mSettingPromptDialog);
  }
  
  private void showUpdateWidget()
  {
    if (((com.baidu.carlife.l.a.a().N()) && (!isLogin())) || (this.isEditable))
    {
      this.mSyncBtn.setVisibility(8);
      if (!this.isEditable) {
        break label67;
      }
      this.mFinishBtn.setVisibility(0);
    }
    for (;;)
    {
      this.mListFooter.setStatus(1);
      return;
      this.mSyncBtn.setVisibility(0);
      break;
      label67:
      this.mEditBtn.setVisibility(0);
    }
  }
  
  private String stringCut(String paramString)
  {
    String str = paramString;
    if (paramString.length() > 7) {
      str = paramString.substring(0, 7) + "...";
    }
    return str;
  }
  
  private void syncFailedPrompt()
  {
    w.a(getString(2131296918), 0);
  }
  
  private void toLoginWebView()
  {
    StatisticManager.onEvent("HOME_MINE_0001", "行程信息页面点击刷新按钮登录的用户数");
    AccountController.getInstance().loginIn(new AccountController.IAccountListener()
    {
      public void onLogResult(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean)
        {
          StatisticManager.onEvent("HOME_MINE_0006");
          UserCenterController.getInstance().startUpdateUserInfo(1, null);
          RouteRecordFragment.this.manualSync();
        }
      }
    });
  }
  
  private void updateRouteRecordModelList()
  {
    this.mRouteRecordListAdapter.notifyDataSetChanged();
  }
  
  private void updateTitleUpdateTime()
  {
    if (isLogin())
    {
      String str = getManualSyncTime();
      if (str != null) {
        this.mTitleDescTV.setText(str + " " + getResources().getString(2131296742));
      }
      return;
    }
    this.mTitleDescTV.setText(2131296917);
  }
  
  public void deleteRecordItem(int paramInt)
  {
    try
    {
      if ((this.mRouteRecordList != null) && (paramInt >= 0) && (paramInt < this.mRouteRecordList.size()))
      {
        CarNaviModel localCarNaviModel = ((com.baidu.carlife.model.k)this.mRouteRecordList.get(paramInt)).i;
        this.mRouteRecordList.remove(paramInt);
        this.mRouteRecordListAdapter.notifyDataSetChanged();
        TrackDataShop.getInstance().deleteRecord(null, localCarNaviModel);
      }
      return;
    }
    finally {}
  }
  
  public void driving()
  {
    i.b("yftech", "RouteRecordFragment driving");
    drivingDisableClick();
  }
  
  public boolean onBackPressed()
  {
    if (this.isEditable)
    {
      quitEdit();
      return true;
    }
    return false;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131624263: 
      if (isNetworkAvailable())
      {
        if (isLogin())
        {
          manualSync();
          return;
        }
        toLoginWebView();
        return;
      }
      syncFailedPrompt();
      return;
    case 2131624264: 
      if (!this.isEditable) {}
      for (boolean bool = true;; bool = false)
      {
        this.isEditable = bool;
        enableEdit();
        return;
      }
    }
    quitEdit();
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2130968804, null);
    init(paramLayoutInflater);
    this.mIsTriggerLoadMore = false;
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    com.baidu.carlife.core.k.b(this.mMsgManualSyncHandler);
    super.onDestroy();
  }
  
  public void onDestroyView()
  {
    if (this.mSettingPromptDialog != null) {
      dismissDialog(this.mSettingPromptDialog);
    }
    super.onDestroyView();
  }
  
  protected void onInit()
  {
    super.onInit();
    if ((!TrackConfigUtil.getInstance().getRouteRecordFlag()) && (!this.mShowDialoged))
    {
      this.mShowDialoged = true;
      showSettingPromptDialog(com.baidu.carlife.core.a.a());
    }
  }
  
  public void onInitFocusAreas()
  {
    if (this.fragmentType != getCurrentFragmentType()) {
      return;
    }
    if (this.mFocusTitlebar == null)
    {
      this.mFocusTitlebar = new g(this.mContentView.findViewById(2131624146), 2);
      g localg = this.mFocusTitlebar.d(this.mContentView.findViewById(2131624258));
      localg.d(this.mSyncBtn);
      localg.d(this.mEditBtn);
      localg.d(this.mFinishBtn);
    }
    if (this.mFocusListView == null) {
      this.mFocusListView = new com.baidu.carlife.f.c(this.mListView, 6);
    }
    setFocusListener(this.mContentView.findViewById(2131624258));
    setFocusListener(this.mSyncBtn);
    setFocusListener(this.mEditBtn);
    setFocusListener(this.mFinishBtn);
    setFocusListener(this.mListView);
    d.a().b(new com.baidu.carlife.f.a[] { this.mFocusTitlebar, this.mFocusListView });
    if ((this.mRouteRecordListAdapter != null) && (this.mRouteRecordListAdapter.getCount() > 0))
    {
      d.a().h(this.mFocusListView);
      return;
    }
    d.a().h(this.mFocusTitlebar);
  }
  
  protected void onInitView()
  {
    if ((com.baidu.carlife.l.a.a().N()) && (!isLogin())) {
      this.mSyncBtn.setVisibility(8);
    }
    this.mIsNoMoreData = false;
    this.mIsFocusable = false;
    if (!isLastTimeSyncFinished()) {
      showInPageProcessDialog();
    }
    updateTitleUpdateTime();
    clearRouteRecordList();
    getStatisticsInfo();
    getRouteRecord();
  }
  
  public void onResume()
  {
    super.onResume();
    if (getNaviFragmentManager().isDriving())
    {
      i.b("yftech", "RouteRecordFragment onResume driving");
      drivingDisableClick();
      return;
    }
    i.b("yftech", "RouteRecordFragment onResume stopDriving");
    drivingEnabledClick();
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin()
  {
    super.onUpdateSkin();
    updateCommonSkin();
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public void stopDriving()
  {
    i.b("yftech", "RouteRecordFragment stopDriving");
    drivingEnabledClick();
  }
  
  private class MsgManualSyncHandler
    extends j
  {
    private MsgManualSyncHandler() {}
    
    public void careAbout()
    {
      addMsg(700);
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        return;
      case 700: 
        if (((TrackShopEvent)paramMessage.obj).status != 0)
        {
          RouteRecordFragment.this.hideInPageProcessDialog();
          RouteRecordFragment.this.syncFailedPrompt();
        }
        RouteRecordFragment.this.setManualSyncTime(RouteRecordFragment.access$2500(RouteRecordFragment.this));
        RouteRecordFragment.this.updateTitleUpdateTime();
        RouteRecordFragment.access$702(RouteRecordFragment.this, false);
        RouteRecordFragment.this.clearRouteRecordList();
        RouteRecordFragment.this.getStatisticsInfo();
        RouteRecordFragment.this.getRouteRecord();
        return;
      }
      RouteRecordFragment.this.mInpageProcessDialog.setVisibility(8);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/RouteRecordFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */