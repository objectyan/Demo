package com.baidu.navi.controller;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.a;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.k;
import com.baidu.carlife.core.screen.BaseDialog.a;
import com.baidu.carlife.core.screen.b;
import com.baidu.carlife.core.screen.presentation.a.e;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.carlife.logic.voice.n;
import com.baidu.carlife.view.dialog.c;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.SearchCircle;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.db.model.SearchNameHistroyModel;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.HashMap;
import java.util.List;

public final class NameSearchHelper
{
  public static final String BUNDLE_KEY_INCOMING_TYPE = "incoming_type";
  public static final String BUNDLE_KEY_POI_CENTER_MODE = "poi_center_mode";
  public static final int INCOMING_CARLIFE_MAP_PAGE = 6;
  public static final int INCOMING_INTENT_API_COMMAND = 4;
  public static final int INCOMING_MORE_CATALOG_SEARCH = 1;
  public static final int INCOMING_NAME_SEARCH = 2;
  public static final int INCOMING_REMAIN_OIL_COMMAND = 5;
  public static final int INCOMING_ROUTE_PLAN_NODE_PAGE = 7;
  public static final int INCOMING_VOICE_COMMAND = 3;
  private static final NameSearchHelper INSTANCE = new NameSearchHelper();
  private static final String TAG = "PoiSearch";
  private h fragmentManagerCallbackProxy;
  private boolean hasData = false;
  private CarlifeActivity mActivity;
  private BaseFragment mBaseFragment;
  private GeoPoint mCurrentGeoPoint;
  private SearchPoi mCurrentPoi;
  private c mDeleteAlertDlg = null;
  private DistrictInfo mDistrictInfo;
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      RspData localRspData = (RspData)paramAnonymousMessage.obj;
      SearchPoiPager localSearchPoiPager;
      if (paramAnonymousMessage.what == 1005)
      {
        e.a().c();
        localSearchPoiPager = (SearchPoiPager)localRspData.mData;
        if (localSearchPoiPager != null) {
          break label151;
        }
        if ((NameSearchHelper.this.netMode != 1) || (!NameSearchHelper.this.hasData)) {
          break label91;
        }
        paramAnonymousMessage = (SearchPoiPager)localRspData.mReq.mParams.get("param.search.pager");
        NameSearchHelper.this.handleTimeout(paramAnonymousMessage);
        NameSearchHelper.access$102(NameSearchHelper.this, false);
      }
      for (;;)
      {
        return;
        label91:
        LogUtil.e("PoiSearch", "search with pager fail");
        if (NameSearchHelper.this.mIsFromVoice == true) {
          BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
        }
        TipTool.onCreateToastDialog(NameSearchHelper.this.mActivity, 2131298915);
        if (n.a().l())
        {
          k.b(4162);
          return;
          label151:
          localSearchPoiPager.setNetMode(BNPoiSearcher.getInstance().getNetModeOfLastResult());
          switch (localSearchPoiPager.getSearchType())
          {
          }
          while ((NameSearchHelper.this.mIsFromVoice == true) && (paramAnonymousMessage.arg1 != 0))
          {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
            return;
            if (paramAnonymousMessage.arg1 == 0)
            {
              LogUtil.e("PoiSearch", "onSearchCatalogSucc()");
              NameSearchHelper.this.handleSpaceCatalogSearchSuc(localSearchPoiPager);
              k.b(4160);
            }
            else
            {
              LogUtil.e("PoiSearch", "Space Search fail");
              TipTool.onCreateToastDialog(NameSearchHelper.this.mActivity, 2131298918);
              continue;
              if (paramAnonymousMessage.arg1 == 0)
              {
                NameSearchHelper.this.handleNameSearchSuc(localSearchPoiPager);
                k.b(4160);
              }
              else
              {
                LogUtil.e("PoiSearch", "Name Search fail");
                TipTool.onCreateToastDialog(NameSearchHelper.this.mActivity, 2131298915);
                if (n.a().l())
                {
                  k.b(4162);
                  continue;
                  if (paramAnonymousMessage.arg1 == 0)
                  {
                    LogUtil.e("PoiSearch", "onSearchCatalogSucc()");
                    NameSearchHelper.this.handleSpaceKeySearchSuc(localSearchPoiPager);
                    k.b(4160);
                    return;
                  }
                  LogUtil.e("PoiSearch", "Space Search fail");
                  TipTool.onCreateToastDialog(NameSearchHelper.this.mActivity, 2131298915);
                  if (n.a().l()) {
                    k.b(4162);
                  }
                }
              }
            }
          }
        }
      }
    }
  };
  private boolean mIsFromVoice;
  private boolean mIsPoiSearchMod = false;
  private int mModuleFrom;
  private b mSearchDialogCancelListener = new b()
  {
    public void onClick()
    {
      BNPoiSearcher.getInstance().cancelQuery();
      k.b(4165);
    }
  };
  private String mSearchKey;
  private int netMode = 3;
  
  public static NameSearchHelper getInstance()
  {
    return INSTANCE;
  }
  
  private void handleNameSearchSuc(SearchPoiPager paramSearchPoiPager)
  {
    i.b("PoiSearch", "handleNameSearchSuc");
    Bundle localBundle = new Bundle();
    localBundle.putInt("search_type", 17);
    handleSearchSuc(paramSearchPoiPager, localBundle);
  }
  
  private void handleSearchSuc(SearchPoiPager paramSearchPoiPager, Bundle paramBundle)
  {
    Object localObject = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getSearchPoiPagerList();
    if (((List)localObject).size() != 1) {
      resultEmpty(paramSearchPoiPager);
    }
    do
    {
      return;
      localObject = ((SearchPoiPager)((List)localObject).get(0)).getPoiList();
      if ((localObject == null) || (((List)localObject).size() == 0))
      {
        resultEmpty(paramSearchPoiPager);
        return;
      }
      SearchNameHistroyModel.getInstance().addSearchName(paramSearchPoiPager.getSearchKey());
      paramBundle.putString("search_key", paramSearchPoiPager.getSearchKey());
      paramBundle.putInt("district_id", this.mDistrictInfo.mId);
      paramBundle.putInt("search_mode", this.netMode);
      paramBundle.putInt("module_from", this.mModuleFrom);
      if (this.mIsPoiSearchMod) {
        paramBundle.putBoolean("poi_center_mode", true);
      }
      if (this.mIsFromVoice) {
        paramBundle.putInt("incoming_type", 35);
      }
    } while (!isActivityEnable());
    this.fragmentManagerCallbackProxy.showFragment(35, paramBundle);
  }
  
  private void handleSpaceCatalogSearchSuc(SearchPoiPager paramSearchPoiPager)
  {
    i.b("PoiSearch", "handleSpaceCatalogSearchSuc");
    Object localObject = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getSearchPoiPagerList();
    if (((List)localObject).size() != 1) {
      resultEmpty(paramSearchPoiPager);
    }
    do
    {
      return;
      localObject = ((SearchPoiPager)((List)localObject).get(0)).getPoiList();
      if ((localObject == null) || (((List)localObject).size() == 0))
      {
        resultEmpty(paramSearchPoiPager);
        return;
      }
      SearchNameHistroyModel.getInstance().addSearchName(paramSearchPoiPager.getSearchKey());
      paramSearchPoiPager = null;
      if (0 == 0) {
        paramSearchPoiPager = new Bundle();
      }
      if (this.mIsPoiSearchMod) {
        paramSearchPoiPager.putBoolean("poi_center_mode", true);
      }
      paramSearchPoiPager.putString("search_key", this.mSearchKey);
      paramSearchPoiPager.putInt("search_mode", this.netMode);
      if (paramSearchPoiPager.getInt("incoming_type") != 5) {
        paramSearchPoiPager.putInt("incoming_type", 33);
      }
      paramSearchPoiPager.putInt("incoming_type", 33);
      paramSearchPoiPager.putInt("search_type", 19);
      paramSearchPoiPager.putInt("district_id", this.mDistrictInfo.mId);
    } while (!isActivityEnable());
    this.fragmentManagerCallbackProxy.showFragment(35, paramSearchPoiPager);
  }
  
  private void handleSpaceKeySearchSuc(SearchPoiPager paramSearchPoiPager)
  {
    i.b("PoiSearch", "handleSpaceKeySearchSuc");
    Bundle localBundle = new Bundle();
    localBundle.putInt("search_type", 18);
    handleSearchSuc(paramSearchPoiPager, localBundle);
  }
  
  private void handleTimeout(SearchPoiPager paramSearchPoiPager)
  {
    if ((this.hasData) && (this.netMode == 1))
    {
      this.netMode = 0;
      if (paramSearchPoiPager != null)
      {
        paramSearchPoiPager.setNetMode(this.netMode);
        BNPoiSearcher.getInstance().asynSearchWithPager(paramSearchPoiPager, this.mHandler);
        e.a().a(a.a().getString(2131296861), this.mSearchDialogCancelListener);
      }
    }
    do
    {
      return;
      if (this.mIsFromVoice == true) {
        BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
      }
      TipTool.onCreateToastDialog(this.mActivity, 2131298915);
    } while (!n.a().l());
    k.b(4162);
  }
  
  private void init(CarlifeActivity paramCarlifeActivity, BaseFragment paramBaseFragment, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mActivity = paramCarlifeActivity;
    this.mBaseFragment = paramBaseFragment;
    this.mSearchKey = paramString;
    this.mModuleFrom = paramInt;
    this.mIsFromVoice = paramBoolean1;
    this.mIsPoiSearchMod = paramBoolean2;
    this.netMode = 3;
    this.hasData = false;
    this.mCurrentGeoPoint = null;
    this.fragmentManagerCallbackProxy = h.a();
    if (paramBoolean2) {}
    for (this.mCurrentPoi = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getSpaceSearchPoi();; this.mCurrentPoi = null)
    {
      this.mDistrictInfo = GeoLocateModel.getInstance().getDistrictByManMade();
      if (this.mDistrictInfo == null) {
        this.mDistrictInfo = GeoLocateModel.getInstance().getCurrentDistrict();
      }
      SearchStrategyHelper.getInstance(paramCarlifeActivity.getBaseContext()).reloadSearchEngine();
      return;
    }
  }
  
  private boolean isActivityEnable()
  {
    return (this.mActivity != null) && (!this.mActivity.isFinishing());
  }
  
  private void nameSearch(String paramString)
  {
    if (SearchStrategyHelper.getInstance(this.mActivity).checkCanSearchByNetMode(this.netMode))
    {
      paramString = new SearchPoiPager(paramString, this.mDistrictInfo, 10, this.netMode);
      e.a().a(a.a().getString(2131296861), this.mSearchDialogCancelListener);
      BNPoiSearcher.getInstance().asynSearchWithPager(paramString, this.mHandler);
    }
    while (this.mIsFromVoice != true) {
      return;
    }
    BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
  }
  
  private boolean resultEmpty(final SearchPoiPager paramSearchPoiPager)
  {
    if ((this.netMode == 0) && (this.hasData)) {
      showTwoBtnDialog(2131298914, new b()new b
      {
        public void onClick()
        {
          NameSearchHelper.this.dismissTwoBtnDialog();
          NameSearchHelper.access$002(NameSearchHelper.this, 1);
          if (SearchStrategyHelper.getInstance(NameSearchHelper.this.mActivity).checkCanSearchByNetMode(NameSearchHelper.this.netMode))
          {
            paramSearchPoiPager.setNetMode(NameSearchHelper.this.netMode);
            BNPoiSearcher.getInstance().asynSearchWithPager(paramSearchPoiPager, NameSearchHelper.this.mHandler);
            e.a().a(a.a().getString(2131296861), NameSearchHelper.this.mSearchDialogCancelListener);
          }
        }
      }, new b()
      {
        public void onClick()
        {
          NameSearchHelper.this.dismissTwoBtnDialog();
        }
      });
    }
    do
    {
      return true;
      if (this.netMode == 1)
      {
        if (this.hasData)
        {
          this.hasData = false;
          this.netMode = 0;
          paramSearchPoiPager.setNetMode(this.netMode);
          BNPoiSearcher.getInstance().asynSearchWithPager(paramSearchPoiPager, this.mHandler);
        }
        for (;;)
        {
          return false;
          if (this.mIsFromVoice == true) {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
          }
          if (NetworkUtils.isNetworkAvailable(this.mActivity))
          {
            TipTool.onCreateToastDialog(this.mActivity, 2131298915);
            if (n.a().l()) {
              k.b(4162);
            }
          }
          else
          {
            TipTool.onCreateToastDialog(this.mActivity, 2131298924);
            if (n.a().l()) {
              k.b(4162);
            }
          }
        }
      }
      if (this.mIsFromVoice == true) {
        BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
      }
      TipTool.onCreateToastDialog(this.mActivity, 2131298915);
    } while (!n.a().l());
    k.b(4162);
    return true;
  }
  
  private void searchSpace(int paramInt)
  {
    Object localObject = new SearchCircle(this.mCurrentGeoPoint, 5000);
    if (SearchStrategyHelper.getInstance(this.mActivity).checkCanSearchByNetMode(this.netMode))
    {
      localObject = new SearchPoiPager(paramInt, this.mDistrictInfo, (SearchCircle)localObject, 10, this.netMode);
      e.a().a(a.a().getString(2131296861), this.mSearchDialogCancelListener);
      BNPoiSearcher.getInstance().asynSearchWithPager((SearchPoiPager)localObject, this.mHandler);
    }
    while (this.mIsFromVoice != true) {
      return;
    }
    BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
  }
  
  private void searchSpace(String paramString)
  {
    SearchCircle localSearchCircle = new SearchCircle(this.mCurrentGeoPoint, 5000);
    if (SearchStrategyHelper.getInstance(this.mActivity).checkCanSearchByNetMode(this.netMode))
    {
      paramString = new SearchPoiPager(paramString, this.mDistrictInfo, localSearchCircle, 10, this.netMode);
      e.a().a(a.a().getString(2131296861), this.mSearchDialogCancelListener);
      BNPoiSearcher.getInstance().asynSearchWithPager(paramString, this.mHandler);
    }
    while (this.mIsFromVoice != true) {
      return;
    }
    BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
  }
  
  private void trySearchId(int paramInt)
  {
    this.mCurrentGeoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
    if ((!BNLocationManagerProxy.getInstance().isLocationValid()) && (!this.mIsPoiSearchMod))
    {
      if (this.mIsFromVoice == true) {
        BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
      }
      TipTool.onCreateToastDialog(this.mActivity, 2131298923);
      return;
    }
    if ((this.mIsPoiSearchMod) && (this.mCurrentPoi != null)) {
      this.mCurrentGeoPoint = this.mCurrentPoi.mViewPoint;
    }
    this.netMode = SearchStrategyHelper.getInstance(this.mActivity).getNetModeByPoint(this.mCurrentGeoPoint);
    BNSettingManager.getPrefSearchMode();
    this.netMode = getFinalNetMode(this.netMode);
    searchSpace(paramInt);
  }
  
  private void trySearchKey(String paramString)
  {
    this.mCurrentGeoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
    if ((!BNLocationManagerProxy.getInstance().isLocationValid()) && (!this.mIsPoiSearchMod))
    {
      if (this.mIsFromVoice == true) {
        BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
      }
      TipTool.onCreateToastDialog(this.mActivity, 2131298923);
      return;
    }
    if ((this.mIsPoiSearchMod) && (this.mCurrentPoi != null)) {
      this.mCurrentGeoPoint = this.mCurrentPoi.mViewPoint;
    }
    this.netMode = SearchStrategyHelper.getInstance(this.mActivity).getNetModeByPoint(this.mCurrentGeoPoint);
    BNSettingManager.getPrefSearchMode();
    this.netMode = getFinalNetMode(this.netMode);
    if (this.mIsPoiSearchMod)
    {
      searchSpace(paramString);
      return;
    }
    nameSearch(paramString);
  }
  
  public boolean dismissTwoBtnDialog()
  {
    this.mBaseFragment.dismissDialog(this.mDeleteAlertDlg);
    this.mDeleteAlertDlg = null;
    return true;
  }
  
  public int getFinalNetMode(int paramInt)
  {
    int i = BNSettingManager.getPrefSearchMode();
    if (paramInt == 0) {
      this.hasData = true;
    }
    while (i == 2) {
      if (this.hasData)
      {
        return 0;
        this.hasData = false;
      }
      else
      {
        return 1;
      }
    }
    if ((!NetworkUtils.isNetworkAvailable(this.mActivity)) && (this.hasData)) {
      return 0;
    }
    return 1;
  }
  
  public void search(CarlifeActivity paramCarlifeActivity, BaseFragment paramBaseFragment, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    init(paramCarlifeActivity, paramBaseFragment, paramString, paramInt2, paramBoolean1, paramBoolean2);
    trySearchId(paramInt1);
  }
  
  public void search(CarlifeActivity paramCarlifeActivity, BaseFragment paramBaseFragment, String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    init(paramCarlifeActivity, paramBaseFragment, paramString, paramInt, paramBoolean1, paramBoolean2);
    trySearchKey(paramString);
  }
  
  public void showTwoBtnDialog(int paramInt, b paramb1, b paramb2)
  {
    dismissTwoBtnDialog();
    if (this.mDeleteAlertDlg == null)
    {
      this.mDeleteAlertDlg = new c(this.mActivity).a(paramInt).g(17).c(2131296264).q().d(2131296259);
      this.mDeleteAlertDlg.b(paramb1);
      this.mDeleteAlertDlg.a(paramb2);
    }
    this.mBaseFragment.showDialog(this.mDeleteAlertDlg, BaseDialog.a.a);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/controller/NameSearchHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */