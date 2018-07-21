package com.baidu.navi.fragment.carmode;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.baidunavis.control.NavPoiController;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.i;
import com.baidu.carlife.f.c;
import com.baidu.carlife.f.g;
import com.baidu.carlife.k.a.e.a;
import com.baidu.carlife.util.r;
import com.baidu.carlife.util.w;
import com.baidu.navi.adapter.FavoriteDestinationAdapter;
import com.baidu.navi.controller.AccountController;
import com.baidu.navi.controller.AccountController.IAccountListener;
import com.baidu.navi.favorite.http.AuthTokenSyncRequest;
import com.baidu.navi.favorite.sync.FamilyAndCompanySyncManager;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.logic.model.UIModel;
import com.baidu.navi.util.NaviAccountUtils;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;

public class CarModeFavoriteDestFragment
  extends ContentFragment
{
  private AuthTokenSyncRequest authTokenSyncRequest;
  private ImageButton mBtnAdd;
  private ImageButton mBtnBack;
  private ImageButton mBtnSync;
  private FavoriteDestinationAdapter mFavoriteDestAdapter;
  private g mFocusAreaUp;
  private c mFocusList;
  private ListView mListView;
  private Handler mSyncHomeHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      com.baidu.carlife.core.screen.presentation.a.e.a().c();
      FamilyAndCompanySyncManager.getInstance().setSyncing(false);
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      case 0: 
        CarModeFavoriteDestFragment.this.mFavoriteDestAdapter.notifyHistoryDataSetChanged();
        TipTool.onCreateToastDialog(BaseFragment.getNaviActivity(), CarModeFavoriteDestFragment.this.getResources().getString(2131297168));
        return;
      case 1: 
        TipTool.onCreateToastDialog(BaseFragment.getNaviActivity(), CarModeFavoriteDestFragment.this.getResources().getString(2131297165));
        return;
      }
      TipTool.onCreateToastDialog(BaseFragment.getNaviActivity(), CarModeFavoriteDestFragment.this.getResources().getString(2131297166));
    }
  };
  private ViewGroup mViewGroup;
  
  private void autoSyncFamilyAndCompanyData()
  {
    if (PreferenceHelper.getInstance(getNaviActivity()).getBoolean("family_has_synced_after_login", false)) {}
    while ((!NaviAccountUtils.getInstance().isLogin()) || (!NetworkUtils.isNetworkAvailable(getNaviActivity())) || (FamilyAndCompanySyncManager.getInstance().isSyncing())) {
      return;
    }
    FamilyAndCompanySyncManager.getInstance().setSyncing(true);
    PreferenceHelper.getInstance(getNaviActivity()).putBoolean("family_has_synced_after_login", true);
    sendFamilyAndCompanyRequest();
  }
  
  private void sendFamilyAndCompanyRequest()
  {
    String str1 = PreferenceHelper.getInstance(getNaviActivity()).getString("sync_auth_id", "");
    String str2 = PreferenceHelper.getInstance(getNaviActivity()).getString("sync_auth_token", "");
    if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
    {
      this.authTokenSyncRequest = new AuthTokenSyncRequest();
      this.authTokenSyncRequest.toGetRequest();
      this.authTokenSyncRequest.registerResponseListener(new e.a()
      {
        public void onNetWorkResponse(int paramAnonymousInt)
        {
          FamilyAndCompanySyncManager.getInstance().setSyncing(false);
          if (!CarModeFavoriteDestFragment.this.isAdded()) {}
          while ((paramAnonymousInt != -4) && (paramAnonymousInt != -2)) {
            return;
          }
          com.baidu.carlife.core.screen.presentation.a.e.a().c();
          TipTool.onCreateToastDialog(BaseFragment.getNaviActivity(), CarModeFavoriteDestFragment.this.getResources().getString(2131297166));
        }
      });
      return;
    }
    new Thread(new Runnable()
    {
      public void run()
      {
        FamilyAndCompanySyncManager.getInstance().startSync();
      }
    }).start();
  }
  
  private void syncFamilyAndCompanyData()
  {
    if (!NetworkUtils.isNetworkAvailable(getNaviActivity()))
    {
      TipTool.onCreateToastDialog(getNaviActivity(), getResources().getString(2131297166));
      return;
    }
    if (FamilyAndCompanySyncManager.getInstance().isSyncing())
    {
      TipTool.onCreateToastDialog(getNaviActivity(), getResources().getString(2131297164));
      return;
    }
    PreferenceHelper.getInstance(getNaviActivity()).putBoolean("family_has_synced_after_login", true);
    FamilyAndCompanySyncManager.getInstance().setmSyncHandler(this.mSyncHomeHandler);
    com.baidu.carlife.core.screen.presentation.a.e.a().a(getResources().getString(2131296859), new com.baidu.carlife.core.screen.b()new com.baidu.carlife.core.screen.d
    {
      public void onClick()
      {
        CarModeFavoriteDestFragment.this.stopSync();
      }
    }, new com.baidu.carlife.core.screen.d()
    {
      public void onCancel()
      {
        CarModeFavoriteDestFragment.this.stopSync();
      }
    });
    sendFamilyAndCompanyRequest();
  }
  
  private void toLoginWebView()
  {
    AccountController.getInstance().loginIn(new AccountController.IAccountListener()
    {
      public void onLogResult(boolean paramAnonymousBoolean)
      {
        CarModeFavoriteDestFragment.this.autoSyncFamilyAndCompanyData();
      }
    });
  }
  
  public void driving()
  {
    i.b("yftech", "CarModeFavoriteDestFragment driving");
    this.mBtnAdd.setAlpha(0.2F);
    this.mBtnAdd.setEnabled(false);
    new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
    {
      public void run()
      {
        if (CarModeFavoriteDestFragment.this.mFavoriteDestAdapter != null) {
          CarModeFavoriteDestFragment.this.mFavoriteDestAdapter.notifyHistoryDataSetChanged();
        }
      }
    }, 100L);
    if (isBack()) {
      getNaviFragmentManager().back();
    }
    com.baidu.carlife.custom.a.a().d();
  }
  
  public void findViews()
  {
    this.mListView = ((ListView)this.mViewGroup.findViewById(2131624353));
    this.mBtnBack = ((ImageButton)this.mViewGroup.findViewById(2131624258));
    this.mBtnAdd = ((ImageButton)this.mViewGroup.findViewById(2131624264));
    this.mBtnSync = ((ImageButton)this.mViewGroup.findViewById(2131624263));
    this.mBtnAdd.setVisibility(0);
    this.mBtnSync.setVisibility(0);
    this.mBtnAdd.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        StatisticManager.onEvent("1047", "1047");
        CarModeFavoriteDestFragment.this.goSearchFragment();
      }
    });
    this.mBtnBack.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CarModeFavoriteDestFragment.this.pageBack(CarModeFavoriteDestFragment.this.mModuleFrom);
      }
    });
    this.mBtnSync.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        com.baidu.carlife.core.e.a();
        if ((com.baidu.carlife.core.e.y()) && (!NaviAccountUtils.getInstance().isLogin()))
        {
          w.a(CarModeFavoriteDestFragment.this.getResources().getString(2131296694));
          return;
        }
        if (!NaviAccountUtils.getInstance().isLogin())
        {
          CarModeFavoriteDestFragment.this.toLoginWebView();
          return;
        }
        CarModeFavoriteDestFragment.this.syncFamilyAndCompanyData();
      }
    });
  }
  
  public void goSearchFragment()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("from_Fragment", 304);
    localBundle.putInt("select_point_action", 1);
    if ((mActivity != null) && (!mActivity.isFinishing())) {
      showFragment(49, localBundle);
    }
  }
  
  public boolean isBack()
  {
    boolean bool = true;
    i.b("yftech", "mFavoriteDestAdapter.getCount() == " + this.mFavoriteDestAdapter.getCount());
    if (this.mFavoriteDestAdapter.getCount() > 2) {
      bool = false;
    }
    if (!this.mFavoriteDestAdapter.isBack())
    {
      i.b("yftech", " mFavoriteDestAdapter.isBack() == " + this.mFavoriteDestAdapter.isBack());
      bool = false;
    }
    return bool;
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.mFavoriteDestAdapter = new FavoriteDestinationAdapter(paramContext, this);
  }
  
  public boolean onBackPressed()
  {
    pageBack(this.mModuleFrom);
    return true;
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2130968652, null));
    setCommonTitleBar(this.mViewGroup, getResources().getString(2131296577));
    findViews();
    return this.mViewGroup;
  }
  
  public void onInitFocusAreas()
  {
    if ((this.mViewGroup == null) || (this.mBtnAdd == null) || (this.mBtnBack == null) || (this.mListView == null)) {
      return;
    }
    if ((this.mFocusAreaUp == null) && (this.mViewGroup.findViewById(2131624135) != null))
    {
      this.mBtnBack.setFocusable(true);
      this.mBtnSync.setFocusable(true);
      this.mBtnAdd.setFocusable(true);
      this.mFocusAreaUp = new g(this.mViewGroup.findViewById(2131624135), 2);
      this.mFocusAreaUp.d(this.mBtnBack).d(this.mBtnSync).d(this.mBtnAdd);
    }
    if (this.mFocusList == null) {
      this.mFocusList = new c(this.mListView, 6);
    }
    com.baidu.carlife.f.d.a().b(new com.baidu.carlife.f.a[] { this.mFocusAreaUp, this.mFocusList });
    com.baidu.carlife.f.d.a().h(this.mFocusList);
  }
  
  protected void onInitView()
  {
    setupViews();
  }
  
  public void onResume()
  {
    super.onResume();
    autoSyncFamilyAndCompanyData();
    new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
    {
      public void run()
      {
        if (CarModeFavoriteDestFragment.this.mFavoriteDestAdapter != null) {
          CarModeFavoriteDestFragment.this.mFavoriteDestAdapter.notifyHistoryDataSetChanged();
        }
      }
    }, 100L);
    if ((this.mViewGroup != null) && (getCurrentFragmentType() == 304)) {
      onInitFocusAreas();
    }
    if (getNaviFragmentManager().isDriving())
    {
      this.mBtnAdd.setAlpha(0.2F);
      this.mBtnAdd.setEnabled(false);
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
      this.mBtnAdd.setAlpha(1.0F);
      this.mBtnAdd.setEnabled(true);
    }
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateSkin()
  {
    this.mBtnAdd.setBackground(com.baidu.carlife.view.a.b.a(mActivity));
    this.mBtnSync.setBackground(com.baidu.carlife.view.a.b.a(mActivity));
    this.mBtnAdd.setImageDrawable(r.b(2130838254));
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public void setupViews()
  {
    this.mListView.setAdapter(this.mFavoriteDestAdapter);
    this.mListView.setItemsCanFocus(true);
    this.mListView.setDivider(null);
    this.mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if ((CarModeFavoriteDestFragment.this.mFavoriteDestAdapter == null) || (ForbidDaulClickUtils.isFastDoubleClick())) {
          return;
        }
        if ((paramAnonymousInt == 0) && (!AddressSettingModel.hasSetHomeAddr(BaseFragment.mActivity)))
        {
          UIModel.getInstance().goSettingFragment(4, CarModeFavoriteDestFragment.this.getNaviFragmentManager());
          StatisticManager.onEvent("1049", "家");
          return;
        }
        if ((paramAnonymousInt == 1) && (!AddressSettingModel.hasSetCompAddr(BaseFragment.mActivity)))
        {
          UIModel.getInstance().goSettingFragment(5, CarModeFavoriteDestFragment.this.getNaviFragmentManager());
          StatisticManager.onEvent("1049", "公司");
          return;
        }
        StatisticManager.onEvent("NAVI_0020", "NAVI_0020");
        paramAnonymousAdapterView = CarModeFavoriteDestFragment.this.mFavoriteDestAdapter.getDate(paramAnonymousInt);
        NavPoiController.getInstance().startCalcRoute(paramAnonymousAdapterView);
      }
    });
  }
  
  public void stopDriving()
  {
    this.mBtnAdd.setAlpha(1.0F);
    this.mBtnAdd.setEnabled(true);
    new Handler(Looper.getMainLooper()).postDelayed(new Runnable()
    {
      public void run()
      {
        if (CarModeFavoriteDestFragment.this.mFavoriteDestAdapter != null) {
          CarModeFavoriteDestFragment.this.mFavoriteDestAdapter.notifyHistoryDataSetChanged();
        }
      }
    }, 100L);
  }
  
  public void stopSync()
  {
    try
    {
      if (this.authTokenSyncRequest != null)
      {
        this.authTokenSyncRequest.cancel();
        FamilyAndCompanySyncManager.getInstance().setSyncing(false);
      }
      FamilyAndCompanySyncManager.getInstance().stopSync();
      return;
    }
    finally {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/carmode/CarModeFavoriteDestFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */