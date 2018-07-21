package com.baidu.navi.fragment.carmode;

import android.content.res.Resources;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.carlife.core.e;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.carlife.f.c;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;
import com.baidu.carlife.util.w;
import com.baidu.carlife.view.CommonTipView;
import com.baidu.carlife.view.LoadMoreFooter;
import com.baidu.navi.adapter.FavoritePoisListAdapter;
import com.baidu.navi.controller.AccountController;
import com.baidu.navi.controller.AccountController.IAccountListener;
import com.baidu.navi.favorite.FavoriteConfig;
import com.baidu.navi.favorite.FavoritePois;
import com.baidu.navi.favorite.sync.FavoriteDataSync;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.interfaces.IFavoriteFragStatusListener;
import com.baidu.navi.interfaces.IFavoriteFragUiUpdateHandler;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.util.common.NetworkUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CarModeFavoriteFragment
  extends ContentFragment
  implements View.OnClickListener
{
  private boolean isLoadMore = false;
  private int lastIndex = 0;
  private ImageButton mBtnBack;
  private ImageButton mEditBtn;
  private FavoritePoisListAdapter mFavoritesRecordListAdapter;
  private TextView mFinishBtn;
  private c mFocusListView;
  private g mFocusTitlebar;
  private boolean mIsEditable = false;
  private boolean mIsFocusable = false;
  private LoadMoreFooter mListFooter;
  private ListView mListView;
  private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener()
  {
    public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      if (CarModeFavoriteFragment.this.mFavoritesRecordListAdapter != null)
      {
        if (CarModeFavoriteFragment.this.mIsEditable) {
          break label32;
        }
        CarModeFavoriteFragment.this.mFavoritesRecordListAdapter.startCalcRoute(paramAnonymousInt);
      }
      label32:
      while ((!CarModeFavoriteFragment.this.mIsFocusable) || (paramAnonymousLong != 100L)) {
        return;
      }
      CarModeFavoriteFragment.this.mFavoritesRecordListAdapter.deleteFavItemBackgroud(paramAnonymousInt);
    }
  };
  private ImageButton mSyncBtn;
  private j mSyncHandler;
  private CommonTipView mTipView;
  private TextView mTitleDescTv;
  private String mUpdateTime = "";
  private ViewGroup mViewGroup;
  
  private void autoSyncFavData()
  {
    if (FavoriteConfig.getInstance().isSynced()) {}
    while ((!NaviAccountUtils.getInstance().isLogin()) || (!NetworkUtils.isNetworkAvailable(com.baidu.carlife.core.a.a())) || (FavoritePois.getPoiInstance().isBackGetFavInfoTaskIsRun()) || (FavoriteDataSync.getInstance().isSyncing())) {
      return;
    }
    FavoriteConfig.getInstance().setIsSynced(true);
    this.mFavoritesRecordListAdapter.getFavoriteFragStatusListener().clearListViewData();
    FavoriteDataSync.getInstance().manualSync();
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
  
  private String getManualSyncTime()
  {
    long l = FavoriteConfig.getInstance().getLastSyncTime();
    if (l == 0L) {
      return this.mUpdateTime;
    }
    this.mUpdateTime = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss").format(new Date(l));
    return this.mUpdateTime;
  }
  
  private void initView(ViewGroup paramViewGroup)
  {
    String str = getResources().getString(2131296325);
    setCommonTitleBar(this.mViewGroup, str);
    this.mBtnBack = ((ImageButton)paramViewGroup.findViewById(2131624258));
    this.mBtnBack.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (CarModeFavoriteFragment.this.mIsEditable)
        {
          CarModeFavoriteFragment.this.quiteEditMode();
          return;
        }
        CarModeFavoriteFragment.this.back();
      }
    });
    this.mTitleDescTv = ((TextView)paramViewGroup.findViewById(2131624262));
    this.mTitleDescTv.setVisibility(0);
    this.mListView = ((ListView)paramViewGroup.findViewById(2131625018));
    this.mListView.setOverScrollMode(2);
    this.mSyncBtn = ((ImageButton)paramViewGroup.findViewById(2131624263));
    this.mSyncBtn.setImageResource(2130838332);
    this.mSyncBtn.setBackground(com.baidu.carlife.view.a.b.a(mActivity));
    this.mSyncBtn.setVisibility(0);
    this.mSyncBtn.setOnClickListener(this);
    this.mEditBtn = ((ImageButton)paramViewGroup.findViewById(2131624264));
    this.mEditBtn.setImageResource(2130838279);
    this.mEditBtn.setVisibility(0);
    this.mEditBtn.setBackground(com.baidu.carlife.view.a.b.a(mActivity));
    this.mEditBtn.setOnClickListener(this);
    this.mFinishBtn = ((TextView)paramViewGroup.findViewById(2131624265));
    this.mFinishBtn.setText(2131296346);
    this.mFinishBtn.setBackground(com.baidu.carlife.view.a.b.a(mActivity));
    this.mFinishBtn.setOnClickListener(this);
    this.mFavoritesRecordListAdapter = new FavoritePoisListAdapter(getContext(), this);
    this.mListView.setAdapter(this.mFavoritesRecordListAdapter);
    this.mListView.setOnItemClickListener(this.mOnItemClickListener);
    this.mListView.setDivider(null);
    this.mTipView = ((CommonTipView)paramViewGroup.findViewById(2131623981));
    this.mTipView.a(2131296455, 2130838281);
    this.mTipView.a(0);
    this.mListView.setEmptyView(this.mTipView);
    this.mListFooter = new LoadMoreFooter(getContext());
    this.mListFooter.setStatus(1);
    this.mListFooter.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CarModeFavoriteFragment.access$302(CarModeFavoriteFragment.this, true);
        CarModeFavoriteFragment.access$402(CarModeFavoriteFragment.this, CarModeFavoriteFragment.this.mFavoritesRecordListAdapter.getCount() - 1);
        CarModeFavoriteFragment.this.mFavoritesRecordListAdapter.updateData();
      }
    });
    this.mListView.addFooterView(this.mListFooter);
    this.mFavoritesRecordListAdapter.setFavoriteFragUiUpdateHandler(new IFavoriteFragUiUpdateHandler()
    {
      public void footerShowLoadMore()
      {
        CarModeFavoriteFragment.this.mListFooter.setTextContent(com.baidu.carlife.core.a.a().getResources().getString(2131296915));
      }
      
      public void footerShowNoMore()
      {
        CarModeFavoriteFragment.this.mListFooter.setTextContent(com.baidu.carlife.core.a.a().getString(2131296916));
      }
      
      public void hideEditBtn()
      {
        CarModeFavoriteFragment.this.mEditBtn.setVisibility(8);
      }
      
      public void hideLoadMoreFooter()
      {
        if (CarModeFavoriteFragment.this.mIsEditable) {
          return;
        }
        CarModeFavoriteFragment.this.mListFooter.setVisibility(8);
      }
      
      public void showEditBtn()
      {
        CarModeFavoriteFragment.this.updateEditBtn();
      }
      
      public void showLoadMoreFooter()
      {
        CarModeFavoriteFragment.this.mListFooter.setVisibility(0);
      }
      
      public void syncEnd()
      {
        if (CarModeFavoriteFragment.this.isLoadMore) {
          if ((CarModeFavoriteFragment.this.mFavoritesRecordListAdapter.getCount() > 0) && (CarModeFavoriteFragment.this.lastIndex < CarModeFavoriteFragment.this.mFavoritesRecordListAdapter.getCount())) {
            CarModeFavoriteFragment.this.mListView.setSelection(CarModeFavoriteFragment.this.lastIndex);
          }
        }
        for (;;)
        {
          CarModeFavoriteFragment.access$302(CarModeFavoriteFragment.this, false);
          return;
          if (CarModeFavoriteFragment.this.mFavoritesRecordListAdapter.getCount() > 0) {
            CarModeFavoriteFragment.this.mListView.setSelection(0);
          }
        }
      }
    });
    this.mFavoritesRecordListAdapter.updateData();
  }
  
  private boolean isConnectedwithVehicle()
  {
    e.a();
    return e.y();
  }
  
  private boolean isLogin()
  {
    return NaviAccountUtils.getInstance().isLogin();
  }
  
  private void quiteEditMode()
  {
    this.mIsEditable = false;
    updateEditBtn();
    this.mFavoritesRecordListAdapter.getFavoriteFragStatusListener().editDisable();
    updateData();
  }
  
  private void setFocusListener(View paramView)
  {
    paramView.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          CarModeFavoriteFragment.access$1002(CarModeFavoriteFragment.this, true);
        }
      }
    });
  }
  
  private void toLoginWebView()
  {
    StatisticManager.onEvent("HOME_MINE_0001", "收藏夹页面点击刷新按钮登录的用户数");
    AccountController.getInstance().loginIn(new AccountController.IAccountListener()
    {
      public void onLogResult(boolean paramAnonymousBoolean)
      {
        StatisticManager.onEvent("NAVI_0029");
        FavoriteDataSync.getInstance().manualSync();
      }
    });
  }
  
  private void updateData()
  {
    if (this.mFavoritesRecordListAdapter != null) {
      this.mFavoritesRecordListAdapter.updateData();
    }
  }
  
  private void updateEditBtn()
  {
    if (this.mIsEditable)
    {
      this.mEditBtn.setVisibility(8);
      this.mFinishBtn.setVisibility(0);
    }
    for (;;)
    {
      if (this.mFavoritesRecordListAdapter.getCount() <= 0)
      {
        this.mIsEditable = false;
        this.mEditBtn.setVisibility(8);
      }
      updateSyncBtn();
      return;
      this.mEditBtn.setVisibility(0);
      this.mFinishBtn.setVisibility(8);
    }
  }
  
  private void updateSyncBtn()
  {
    if (this.mIsEditable)
    {
      this.mSyncBtn.setVisibility(8);
      return;
    }
    this.mSyncBtn.setVisibility(0);
    if ((isConnectedwithVehicle()) && (!isLogin()))
    {
      this.mSyncBtn.setAlpha(102);
      this.mSyncBtn.setVisibility(8);
      return;
    }
    this.mSyncBtn.setAlpha(255);
  }
  
  private void updateTitleUpdateTime()
  {
    if (isLogin())
    {
      String str = getManualSyncTime();
      if ((str != null) && (str.length() != 0)) {
        this.mTitleDescTv.setText(str + " " + getResources().getString(2131296742));
      }
      return;
    }
    this.mTitleDescTv.setText(2131296693);
  }
  
  public void driving()
  {
    i.b("yftech", "RouteRecordFragment driving");
    drivingDisableClick();
    if (com.baidu.carlife.custom.b.a().b()) {
      backTo(17, null);
    }
  }
  
  public boolean onBackPressed()
  {
    if (this.mIsEditable)
    {
      quiteEditMode();
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
      if ((isConnectedwithVehicle()) && (!isLogin()))
      {
        w.a(getResources().getString(2131296694));
        return;
      }
      if (!isLogin())
      {
        toLoginWebView();
        return;
      }
      FavoriteDataSync.getInstance().manualSync();
      return;
    case 2131624264: 
      this.mListView.setEmptyView(null);
      this.mIsEditable = true;
      updateEditBtn();
      this.mFavoritesRecordListAdapter.getFavoriteFragStatusListener().editEnable();
      return;
    }
    this.mListView.setEmptyView(this.mTipView);
    quiteEditMode();
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2130968786, null));
    initView(this.mViewGroup);
    this.mSyncHandler = new SyncHandler(null);
    k.a(this.mSyncHandler);
    return this.mViewGroup;
  }
  
  public void onDestroy()
  {
    k.b(this.mSyncHandler);
    super.onDestroy();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if ((this.mEditBtn != null) && (this.mSyncBtn != null))
    {
      updateEditBtn();
      updateSyncBtn();
    }
  }
  
  public void onInitFocusAreas()
  {
    if (this.mFocusTitlebar == null)
    {
      this.mFocusTitlebar = new g(this.mContentView.findViewById(2131624146), 2);
      g localg = this.mFocusTitlebar.d(this.mContentView.findViewById(2131624258));
      localg.d(this.mSyncBtn);
      localg.d(this.mEditBtn);
      localg.d(this.mFinishBtn);
    }
    if (this.mFocusListView == null) {
      this.mFocusListView = new c(this.mListView, 4);
    }
    setFocusListener(this.mContentView.findViewById(2131624258));
    setFocusListener(this.mSyncBtn);
    setFocusListener(this.mEditBtn);
    setFocusListener(this.mFinishBtn);
    setFocusListener(this.mListView);
    d.a().b(new com.baidu.carlife.f.a[] { this.mFocusTitlebar, this.mFocusListView });
    if ((this.mFavoritesRecordListAdapter != null) && (this.mFavoritesRecordListAdapter.getCount() > 0))
    {
      d.a().h(this.mFocusListView);
      this.mFocusListView.e();
      return;
    }
    d.a().h(this.mFocusTitlebar);
  }
  
  protected void onInitView()
  {
    updateTitleUpdateTime();
    updateSyncBtn();
    updateEditBtn();
  }
  
  public void onResume()
  {
    super.onResume();
    autoSyncFavData();
    if (getNaviFragmentManager().isDriving())
    {
      i.b("yftech", "CarModeFavoriteFragment onResume driving");
      drivingDisableClick();
    }
    for (;;)
    {
      if (NavMapManager.getInstance().getNaviMapMode() == 5)
      {
        com.baidu.baidumaps.f.a.a.a.a().e();
        com.baidu.baidumaps.f.a.a.a.a().g();
        NavMapManager.getInstance().handleMapOverlays(0);
        NavMapManager.getInstance().setNaviMapMode(0);
        NavMapManager.getInstance().showCarResultLayer(false);
      }
      return;
      i.b("yftech", "CarModeFavoriteFragment onResume stopDriving");
      drivingEnabledClick();
    }
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public void stopDriving()
  {
    i.b("yftech", "RouteRecordFragment stopDriving");
    drivingEnabledClick();
  }
  
  private class SyncHandler
    extends j
  {
    private SyncHandler() {}
    
    public void careAbout()
    {
      addMsg(720);
      addMsg(1004);
      addMsg(1002);
    }
    
    public void handleMessage(Message paramMessage)
    {
      if (paramMessage.what == 720)
      {
        FavoriteConfig.getInstance().setIsSynced(true);
        CarModeFavoriteFragment.this.updateTitleUpdateTime();
        CarModeFavoriteFragment.this.mFavoritesRecordListAdapter.getFavoriteFragStatusListener().clearListViewData();
        CarModeFavoriteFragment.this.updateData();
      }
      if (paramMessage.what == 1004) {
        CarModeFavoriteFragment.this.updateEditBtn();
      }
      if (paramMessage.what == 1002) {
        CarModeFavoriteFragment.this.updateEditBtn();
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/carmode/CarModeFavoriteFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */