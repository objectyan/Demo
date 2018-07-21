package com.baidu.navi.fragment;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.k;
import com.baidu.carlife.core.screen.presentation.a.e;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;
import com.baidu.carlife.logic.voice.n;
import com.baidu.carlife.view.dialog.c;
import com.baidu.navi.common.util.FileUtils;
import com.baidu.navi.controller.NameSearchHelper;
import com.baidu.navi.controller.SearchStrategyHelper;
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
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.db.model.SearchNameHistroyModel;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class NameSearchFragment
  extends ContentFragment
  implements View.OnClickListener
{
  public static final String COME_FROM = "come_from";
  public static final int COME_FROM_DISCOVER_OIL = 8;
  public static final int INCOMING_CARLIFE_MAP_PAGE = 6;
  public static final int INCOMING_INTENT_API_COMMAND = 4;
  public static final int INCOMING_MORE_CATALOG_SEARCH = 1;
  public static final int INCOMING_NAME_SEARCH = 2;
  public static final int INCOMING_REMAIN_OIL_COMMAND = 5;
  public static final int INCOMING_ROUTE_PLAN_NODE_PAGE = 7;
  public static final String INCOMING_TYPE = "incoming_type";
  public static final int INCOMING_VOICE_COMMAND = 3;
  public static final String INTENT_API_POI_POINT = "intent_api_point";
  public static final String INTENT_API_POI_RADIUS = "intent_api_radius";
  public static final String POI_CENTER_MODE = "poi_center_mode";
  private static final String TAG = "PoiSearch";
  public static final String VOICE_SEARCH_KEY = "voice_key";
  private int cityId = 0;
  private boolean hasData = false;
  private GeoPoint intentApiPoint;
  private int intentApiRadius = 0;
  private boolean isFromIntentApi = false;
  private boolean isFromVoice = false;
  private boolean isPoiSearchMod = false;
  private boolean isSpaceSearchMode = false;
  private GridViewAdapter mAdapter;
  private c mAlertDlg = null;
  private ImageButton mBackBtn;
  private GeoPoint mCurrentGeoPoint;
  private SearchPoi mCurrentPoi;
  private DistrictInfo mDistrictInfo;
  private g mFocusAreaUp;
  private com.baidu.carlife.f.b mFocusGridView;
  private GridView mGridView;
  private ViewGroup mGroupView;
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (!NameSearchFragment.this.canProcessUI()) {}
      for (;;)
      {
        return;
        RspData localRspData = (RspData)paramAnonymousMessage.obj;
        if (paramAnonymousMessage.what == 1005)
        {
          e.a().c();
          SearchPoiPager localSearchPoiPager = (SearchPoiPager)localRspData.mData;
          if (localSearchPoiPager == null)
          {
            if ((NameSearchFragment.this.netMode == 1) && (NameSearchFragment.this.hasData))
            {
              paramAnonymousMessage = (SearchPoiPager)localRspData.mReq.mParams.get("param.search.pager");
              NameSearchFragment.this.handleTimeout(paramAnonymousMessage);
              NameSearchFragment.access$202(NameSearchFragment.this, false);
              return;
            }
            i.e("PoiSearch", "search with pager fail");
            if (NameSearchFragment.this.isFromVoice == true) {
              BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
            }
            TipTool.onCreateToastDialog(NameSearchFragment.this.getContext(), 2131298915);
            if (n.a().l()) {
              k.b(4162);
            }
          }
          else
          {
            localSearchPoiPager.setNetMode(BNPoiSearcher.getInstance().getNetModeOfLastResult());
            switch (localSearchPoiPager.getSearchType())
            {
            }
            while ((NameSearchFragment.this.isFromVoice == true) && (paramAnonymousMessage.arg1 != 0))
            {
              BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
              return;
              if (paramAnonymousMessage.arg1 == 0)
              {
                i.e("PoiSearch", "onSearchCatalogSucc()");
                NameSearchFragment.this.handleSpaceCatalogSearchSuc(localSearchPoiPager);
                k.b(4160);
              }
              else
              {
                i.e("PoiSearch", "Space Search fail");
                TipTool.onCreateToastDialog(NameSearchFragment.this.getContext(), 2131298918);
                continue;
                if (paramAnonymousMessage.arg1 == 0)
                {
                  NameSearchFragment.this.handleNameSearchSuc(localSearchPoiPager);
                  k.b(4160);
                }
                else
                {
                  i.e("PoiSearch", "Name Search fail");
                  TipTool.onCreateToastDialog(NameSearchFragment.this.getContext(), 2131298915);
                  if (n.a().l())
                  {
                    k.b(4162);
                    continue;
                    if (paramAnonymousMessage.arg1 == 0)
                    {
                      i.e("PoiSearch", "onSearchCatalogSucc()");
                      NameSearchFragment.this.handleSpaceKeySearchSuc(localSearchPoiPager);
                      k.b(4160);
                      return;
                    }
                    i.e("PoiSearch", "Space Search fail");
                    TipTool.onCreateToastDialog(NameSearchFragment.this.getContext(), 2131298915);
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
    }
  };
  private int mLastOrientation = 0;
  private com.baidu.carlife.core.screen.b mSearchDialogCancelListener = new com.baidu.carlife.core.screen.b()
  {
    public void onClick()
    {
      BNPoiSearcher.getInstance().cancelQuery();
      k.b(4165);
    }
  };
  private int mSearchId;
  private String mSearchKey;
  private ImageButton mVoiceBtn;
  private int netMode = 3;
  
  private void clearLastResult()
  {
    ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getSearchPoiPagerList().clear();
  }
  
  private void dismissAllDialog()
  {
    if ((mActivity != null) && (!mActivity.isFinishing())) {
      e.a().c();
    }
    dismissTwoBtnDialog();
  }
  
  private void findViews()
  {
    this.mBackBtn = ((ImageButton)this.mGroupView.findViewById(2131624412));
    this.mBackBtn.setOnClickListener(this);
    this.mVoiceBtn = ((ImageButton)this.mGroupView.findViewById(2131624413));
    this.mGridView = ((GridView)this.mGroupView.findViewById(2131624414));
    this.mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousAdapterView = NameSearchFragment.this.mAdapter.getItem(paramAnonymousInt);
        if (paramAnonymousAdapterView.type == 2) {
          return;
        }
        paramAnonymousView = paramAnonymousAdapterView.name;
        paramAnonymousInt = Long.decode("0x" + paramAnonymousAdapterView.id).intValue();
        NameSearchHelper.getInstance().search(BaseFragment.mActivity, NameSearchFragment.this, paramAnonymousView, paramAnonymousInt, 3, false, false);
      }
    });
  }
  
  private void getBundle()
  {
    int i = 0;
    if (this.mShowBundle != null) {
      i = this.mShowBundle.getInt("incoming_type");
    }
    switch (i)
    {
    default: 
    case 2: 
    case 1: 
    case 6: 
    case 3: 
    case 4: 
      String str;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  return;
                  this.isSpaceSearchMode = true;
                  if (this.mShowBundle.containsKey("poi_center_mode"))
                  {
                    this.isPoiSearchMod = this.mShowBundle.getBoolean("poi_center_mode");
                    if (this.isPoiSearchMod) {
                      this.mCurrentPoi = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getSpaceSearchPoi();
                    }
                  }
                  initFocusChain(this.mGroupView);
                  return;
                  i.e("PoiSearch", "catalog in space search");
                  this.isSpaceSearchMode = true;
                } while (!this.mShowBundle.containsKey("poi_center_mode"));
                this.isPoiSearchMod = this.mShowBundle.getBoolean("poi_center_mode");
              } while (!this.isPoiSearchMod);
              this.mCurrentPoi = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getSpaceSearchPoi();
              return;
              this.isSpaceSearchMode = true;
            } while (!this.mShowBundle.containsKey("poi_center_mode"));
            this.isPoiSearchMod = this.mShowBundle.getBoolean("poi_center_mode");
          } while (!this.isPoiSearchMod);
          this.mCurrentPoi = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getSpaceSearchPoi();
          return;
          str = null;
          this.isFromVoice = true;
          if (this.mShowBundle.containsKey("voice_key")) {
            str = this.mShowBundle.getString("voice_key");
          }
        } while (!this.mShowBundle.containsKey("poi_center_mode"));
        this.isSpaceSearchMode = this.mShowBundle.getBoolean("poi_center_mode");
        if (this.isSpaceSearchMode)
        {
          trySearchSpace(str);
          return;
        }
        trySearch(str);
        return;
        str = null;
        if (this.mShowBundle.containsKey("voice_key")) {
          str = this.mShowBundle.getString("voice_key");
        }
      } while (!this.mShowBundle.containsKey("poi_center_mode"));
      this.isSpaceSearchMode = this.mShowBundle.getBoolean("poi_center_mode");
      if (this.isSpaceSearchMode)
      {
        this.isFromIntentApi = true;
        if (this.mShowBundle.containsKey("intent_api_point")) {
          this.intentApiPoint = parseGeoPointFromString(this.mShowBundle.getString("intent_api_point"));
        }
        if (this.mShowBundle.containsKey("intent_api_radius")) {
          this.intentApiRadius = this.mShowBundle.getInt("intent_api_radius");
        }
        SearchStrategyHelper.getInstance(getContext()).hasDataDownloadedBySet();
        trySearchSpace(Long.decode("0x" + str).intValue());
        return;
      }
      trySearch(str);
      return;
    }
    this.mSearchKey = "加油站";
    this.mSearchId = Long.decode("0x7b40").intValue();
    trySearchSpace(this.mSearchId);
  }
  
  private int getFinalNetMode(int paramInt)
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
    if ((!NetworkUtils.isNetworkAvailable(getContext())) && (this.hasData)) {
      return 0;
    }
    return 1;
  }
  
  private void handleNameSearchSuc(SearchPoiPager paramSearchPoiPager)
  {
    Object localObject = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getSearchPoiPagerList();
    if (((List)localObject).size() != 1)
    {
      resultEmpty(paramSearchPoiPager);
      return;
    }
    localObject = ((SearchPoiPager)((List)localObject).get(0)).getPoiList();
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      resultEmpty(paramSearchPoiPager);
      return;
    }
    SearchNameHistroyModel.getInstance().addSearchName(paramSearchPoiPager.getSearchKey());
    Bundle localBundle = this.mShowBundle;
    localObject = localBundle;
    if (localBundle == null) {
      localObject = new Bundle();
    }
    ((Bundle)localObject).putString("search_key", paramSearchPoiPager.getSearchKey());
    ((Bundle)localObject).putInt("search_mode", this.netMode);
    ((Bundle)localObject).putInt("search_type", 17);
    ((Bundle)localObject).putInt("district_id", this.mDistrictInfo.mId);
    ((Bundle)localObject).putInt("module_from", this.mModuleFrom);
    if (this.isFromVoice)
    {
      ((Bundle)localObject).putInt("incoming_type", 35);
      ((Bundle)localObject).putInt("Key_Bundle_VC_Top_Type", this.mShowBundle.getInt("Key_Bundle_VC_Top_Type", -1));
      ((Bundle)localObject).putInt("Key_Bundle_VC_Sub_Type", this.mShowBundle.getInt("Key_Bundle_VC_Sub_Type", -1));
      ((Bundle)localObject).putInt("module_from", this.mShowBundle.getInt("module_from", 3));
    }
    showFragment(35, (Bundle)localObject);
  }
  
  private void handleSpaceCatalogSearchSuc(SearchPoiPager paramSearchPoiPager)
  {
    Object localObject = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getSearchPoiPagerList();
    if (((List)localObject).size() != 1)
    {
      resultEmpty(paramSearchPoiPager);
      return;
    }
    localObject = ((SearchPoiPager)((List)localObject).get(0)).getPoiList();
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      resultEmpty(paramSearchPoiPager);
      return;
    }
    SearchNameHistroyModel.getInstance().addSearchName(paramSearchPoiPager.getSearchKey());
    localObject = this.mShowBundle;
    if (((Bundle)localObject).containsKey("incoming_type"))
    {
      loge("contains incoming key");
      if (((Bundle)localObject).getInt("incoming_type") == 5) {
        loge("来自一键加油");
      }
    }
    else
    {
      paramSearchPoiPager = (SearchPoiPager)localObject;
      if (localObject == null)
      {
        loge("bundle is null");
        paramSearchPoiPager = new Bundle();
      }
      if (this.isPoiSearchMod) {
        paramSearchPoiPager.putBoolean("poi_center_mode", true);
      }
      paramSearchPoiPager.putString("search_key", this.mSearchKey);
      paramSearchPoiPager.putInt("search_mode", this.netMode);
      if (paramSearchPoiPager.getInt("incoming_type") != 5) {
        break label240;
      }
      loge("来自一键加油，不用重新设置来源");
    }
    for (;;)
    {
      paramSearchPoiPager.putInt("incoming_type", 33);
      paramSearchPoiPager.putInt("search_type", 19);
      paramSearchPoiPager.putInt("district_id", new DistrictInfo().mId);
      showFragment(35, paramSearchPoiPager);
      return;
      loge("不是来自一键加油");
      break;
      label240:
      paramSearchPoiPager.putInt("incoming_type", 33);
    }
  }
  
  private void handleSpaceKeySearchSuc(SearchPoiPager paramSearchPoiPager)
  {
    Object localObject = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getSearchPoiPagerList();
    if (((List)localObject).size() != 1)
    {
      resultEmpty(paramSearchPoiPager);
      return;
    }
    localObject = ((SearchPoiPager)((List)localObject).get(0)).getPoiList();
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      resultEmpty(paramSearchPoiPager);
      return;
    }
    SearchNameHistroyModel.getInstance().addSearchName(paramSearchPoiPager.getSearchKey());
    Bundle localBundle = this.mShowBundle;
    localObject = localBundle;
    if (localBundle == null) {
      localObject = new Bundle();
    }
    ((Bundle)localObject).putString("search_key", paramSearchPoiPager.getSearchKey());
    ((Bundle)localObject).putInt("district_id", this.cityId);
    ((Bundle)localObject).putInt("search_mode", this.netMode);
    ((Bundle)localObject).putInt("search_type", 18);
    if (this.isPoiSearchMod) {
      ((Bundle)localObject).putBoolean("poi_center_mode", true);
    }
    if (this.isFromVoice)
    {
      ((Bundle)localObject).putInt("incoming_type", 35);
      ((Bundle)localObject).putInt("Key_Bundle_VC_Top_Type", this.mShowBundle.getInt("Key_Bundle_VC_Top_Type", -1));
      ((Bundle)localObject).putInt("Key_Bundle_VC_Sub_Type", this.mShowBundle.getInt("Key_Bundle_VC_Sub_Type", -1));
      ((Bundle)localObject).putInt("module_from", this.mShowBundle.getInt("module_from", 3));
    }
    showFragment(35, (Bundle)localObject);
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
        e.a().a(getResources().getString(2131296861), this.mSearchDialogCancelListener);
      }
    }
    do
    {
      return;
      if (this.isFromVoice == true) {
        BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
      }
      TipTool.onCreateToastDialog(getContext(), 2131298915);
    } while (!n.a().l());
    k.b(4162);
  }
  
  private GeoPoint parseGeoPointFromString(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = paramString.split(",");
    } while ((paramString == null) || (paramString.length != 2) || (TextUtils.isEmpty(paramString[0])) || (TextUtils.isEmpty(paramString[0])));
    try
    {
      double d = Double.valueOf(paramString[0]).doubleValue();
      paramString = new GeoPoint((int)(Double.valueOf(paramString[1]).doubleValue() * 100000.0D), (int)(100000.0D * d));
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  private boolean resultEmpty(final SearchPoiPager paramSearchPoiPager)
  {
    if ((this.netMode == 0) && (this.hasData)) {
      showTwoBtnDialog(2131298914, new com.baidu.carlife.core.screen.b()new com.baidu.carlife.core.screen.b
      {
        public void onClick()
        {
          NameSearchFragment.this.dismissTwoBtnDialog();
          NameSearchFragment.access$102(NameSearchFragment.this, 1);
          if (SearchStrategyHelper.getInstance(NameSearchFragment.this.getContext()).checkCanSearchByNetMode(NameSearchFragment.this.netMode))
          {
            paramSearchPoiPager.setNetMode(NameSearchFragment.this.netMode);
            BNPoiSearcher.getInstance().asynSearchWithPager(paramSearchPoiPager, NameSearchFragment.this.mHandler);
            e.a().a(NameSearchFragment.this.getResources().getString(2131296861), NameSearchFragment.this.mSearchDialogCancelListener);
          }
        }
      }, new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          NameSearchFragment.this.dismissTwoBtnDialog();
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
          if (this.isFromVoice == true) {
            BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
          }
          if (NetworkUtils.isNetworkAvailable(getContext()))
          {
            TipTool.onCreateToastDialog(getContext(), 2131298915);
            if (n.a().l()) {
              k.b(4162);
            }
          }
          else
          {
            TipTool.onCreateToastDialog(getContext(), 2131298924);
            if (n.a().l()) {
              k.b(4162);
            }
          }
        }
      }
      if (this.isFromVoice == true) {
        BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
      }
      TipTool.onCreateToastDialog(getContext(), 2131298915);
    } while (!n.a().l());
    k.b(4162);
    return true;
  }
  
  private void search(String paramString)
  {
    SearchStrategyHelper.getInstance(getContext()).reloadSearchEngine();
    if (SearchStrategyHelper.getInstance(getContext()).checkCanSearchByNetMode(this.netMode))
    {
      paramString = new SearchPoiPager(paramString, this.mDistrictInfo, 10, this.netMode);
      if (BNPoiSearcher.getInstance().asynSearchWithPager(paramString, this.mHandler)) {
        e.a().a(getResources().getString(2131296861), this.mSearchDialogCancelListener);
      }
    }
    while (this.isFromVoice != true) {
      return;
    }
    BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
  }
  
  private void searchSpace(int paramInt)
  {
    int i = 5000;
    SearchStrategyHelper.getInstance(getContext()).reloadSearchEngine();
    Object localObject = new SearchCircle(this.mCurrentGeoPoint, 5000);
    if (this.isFromIntentApi)
    {
      this.isFromIntentApi = false;
      localObject = this.mCurrentGeoPoint;
      if (this.intentApiRadius == 0) {
        localObject = new SearchCircle((GeoPoint)localObject, i);
      }
    }
    else
    {
      DistrictInfo localDistrictInfo = null;
      if (0 == 0) {
        localDistrictInfo = GeoLocateModel.getInstance().getCurrentDistrict();
      }
      if (!SearchStrategyHelper.getInstance(getContext()).checkCanSearchByNetMode(this.netMode)) {
        break label154;
      }
      localObject = new SearchPoiPager(paramInt, localDistrictInfo, (SearchCircle)localObject, 10, this.netMode);
      BNPoiSearcher.getInstance().asynSearchWithPager((SearchPoiPager)localObject, this.mHandler);
      e.a().a(getResources().getString(2131296861), this.mSearchDialogCancelListener);
    }
    label154:
    while (this.isFromVoice != true)
    {
      return;
      i = this.intentApiRadius;
      break;
    }
    BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
  }
  
  private void searchSpace(String paramString)
  {
    SearchStrategyHelper.getInstance(getContext()).reloadSearchEngine();
    SearchCircle localSearchCircle = new SearchCircle(this.mCurrentGeoPoint, 5000);
    DistrictInfo localDistrictInfo = null;
    if (0 == 0) {
      localDistrictInfo = GeoLocateModel.getInstance().getCurrentDistrict();
    }
    if (SearchStrategyHelper.getInstance(getContext()).checkCanSearchByNetMode(this.netMode))
    {
      paramString = new SearchPoiPager(paramString, localDistrictInfo, localSearchCircle, 10, this.netMode);
      BNPoiSearcher.getInstance().asynSearchWithPager(paramString, this.mHandler);
      e.a().a(getResources().getString(2131296861), this.mSearchDialogCancelListener);
    }
    while (this.isFromVoice != true) {
      return;
    }
    BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
  }
  
  private void trySearch(String paramString)
  {
    this.netMode = SearchStrategyHelper.getInstance(getContext()).getNetModeBySet(this.mDistrictInfo);
    BNSettingManager.getPrefSearchMode();
    this.netMode = getFinalNetMode(this.netMode);
    search(paramString);
  }
  
  private void trySearchSpace(int paramInt)
  {
    if ((this.isFromIntentApi) && (this.intentApiPoint != null) && (this.intentApiPoint.isValid())) {}
    for (this.mCurrentGeoPoint = this.intentApiPoint; (!BNLocationManagerProxy.getInstance().isLocationValid()) && (!this.isPoiSearchMod); this.mCurrentGeoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation())
    {
      if (this.isFromVoice == true) {
        BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
      }
      TipTool.onCreateToastDialog(getContext(), 2131298923);
      return;
    }
    if ((this.isPoiSearchMod) && (this.mCurrentPoi != null)) {
      this.mCurrentGeoPoint = this.mCurrentPoi.mViewPoint;
    }
    this.netMode = SearchStrategyHelper.getInstance(getContext()).getNetModeByPoint(this.mCurrentGeoPoint);
    BNSettingManager.getPrefSearchMode();
    this.netMode = getFinalNetMode(this.netMode);
    searchSpace(paramInt);
  }
  
  private void trySearchSpace(String paramString)
  {
    this.mCurrentGeoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
    if ((!BNLocationManagerProxy.getInstance().isLocationValid()) && (!this.isPoiSearchMod))
    {
      if (this.isFromVoice == true) {
        BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
      }
      TipTool.onCreateToastDialog(getContext(), 2131298923);
      return;
    }
    if ((this.isPoiSearchMod) && (this.mCurrentPoi != null)) {
      this.mCurrentGeoPoint = this.mCurrentPoi.mViewPoint;
    }
    this.netMode = SearchStrategyHelper.getInstance(getContext()).getNetModeByPoint(this.mCurrentGeoPoint);
    BNSettingManager.getPrefSearchMode();
    this.netMode = getFinalNetMode(this.netMode);
    searchSpace(paramString);
  }
  
  private void updateDistrict()
  {
    SearchStrategyHelper.getInstance(getContext()).hasDataDownloadedBySet();
    this.mDistrictInfo = GeoLocateModel.getInstance().getDistrictByManMade();
    if (this.mDistrictInfo == null) {
      this.mDistrictInfo = GeoLocateModel.getInstance().getCurrentDistrict();
    }
  }
  
  public boolean dismissTwoBtnDialog()
  {
    dismissDialog(this.mAlertDlg);
    this.mAlertDlg = null;
    return true;
  }
  
  public void driving()
  {
    i.b("yftech", "NameSearchFragment driving");
    dismissAllDialog();
    if (com.baidu.carlife.custom.b.a().b())
    {
      int i = 0;
      if (this.mShowBundle != null) {
        i = this.mShowBundle.getInt("incoming_type");
      }
      i.b("yftech", "NameSearchFragment driving from:" + i);
      if ((i == 8) || (i == 3)) {
        pageBack(this.mModuleFrom);
      }
    }
    for (;;)
    {
      com.baidu.carlife.custom.a.a().d();
      return;
      backTo(17, null);
      continue;
      backTo(17, null);
    }
  }
  
  public void initFocusChain(View paramView)
  {
    if (getCurrentFragmentType() != 34) {
      return;
    }
    if (this.mFocusAreaUp == null)
    {
      this.mFocusAreaUp = new g(paramView.findViewById(2131624411), 2);
      this.mFocusAreaUp.d(this.mBackBtn);
    }
    if (this.mFocusGridView == null) {
      this.mFocusGridView = new com.baidu.carlife.f.b(this.mGridView, 6);
    }
    d.a().b(new com.baidu.carlife.f.a[] { this.mFocusAreaUp, this.mFocusGridView });
    d.a().h(this.mFocusGridView);
  }
  
  public boolean onBackPressed()
  {
    e.a().c();
    pageBack(this.mModuleFrom);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131624412: 
      onBackPressed();
      return;
    }
    n.a().f();
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mLastOrientation = getResources().getConfiguration().orientation;
    this.mGroupView = ((ViewGroup)paramLayoutInflater.inflate(2130968659, null));
    findViews();
    updateDistrict();
    return this.mGroupView;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onInitFocusAreas()
  {
    super.onInitFocusAreas();
    initFocusChain(this.mGroupView);
  }
  
  protected void onInitView()
  {
    i.e("PoiSearch", "onInitView()");
    getBundle();
  }
  
  public void onPause()
  {
    BNPoiSearcher.getInstance().cancelQuery();
    e.a().c();
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    updateDistrict();
    clearLastResult();
    if (this.mAdapter == null)
    {
      this.mAdapter = new GridViewAdapter();
      this.mGridView.setAdapter(this.mAdapter);
      if (!this.isSpaceSearchMode) {
        break label100;
      }
      this.mCurrentGeoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
      SearchStrategyHelper.getInstance(getContext()).hasDataDownloadedByPoint(this.mCurrentGeoPoint);
      label74:
      if (this.mDistrictInfo != null) {
        break label114;
      }
      i.b("PoiSearch", "mDistrictInfo null");
    }
    label100:
    label114:
    do
    {
      return;
      this.mAdapter.notifyDataSetChanged();
      break;
      SearchStrategyHelper.getInstance(getContext()).hasDataDownloadedBySet();
      break label74;
      i.b("PoiSearch", "mDistrictInfo " + this.mDistrictInfo);
    } while (NavMapManager.getInstance().getNaviMapMode() != 5);
    com.baidu.baidumaps.f.a.a.a.a().e();
    com.baidu.baidumaps.f.a.a.a.a().g();
    NavMapManager.getInstance().handleMapOverlays(0);
    NavMapManager.getInstance().setNaviMapMode(0);
  }
  
  protected void onUpdateOrientation(int paramInt)
  {
    if (paramInt != this.mLastOrientation) {
      this.mLastOrientation = paramInt;
    }
  }
  
  protected void onUpdateSkin()
  {
    if (this.mBackBtn != null) {
      this.mBackBtn.setBackground(com.baidu.carlife.view.a.b.a(getContext()));
    }
    if (this.mVoiceBtn != null) {
      this.mVoiceBtn.setBackground(com.baidu.carlife.view.a.b.a(getContext()));
    }
  }
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public void showTwoBtnDialog(int paramInt, com.baidu.carlife.core.screen.b paramb1, com.baidu.carlife.core.screen.b paramb2)
  {
    dismissTwoBtnDialog();
    if (this.mAlertDlg == null)
    {
      this.mAlertDlg = new c(mActivity).a(paramInt).g(17).c(2131296264).q().d(2131296259);
      this.mAlertDlg.b(paramb1);
      this.mAlertDlg.a(paramb2);
    }
    showDialog(this.mAlertDlg);
  }
  
  public void stopDriving() {}
  
  private class GridViewAdapter
    extends BaseAdapter
  {
    private List<Item> datas = new ArrayList();
    
    public GridViewAdapter()
    {
      initData();
    }
    
    private void initData()
    {
      Object localObject = FileUtils.getStringFromAssertFile(NameSearchFragment.this.getContext(), "name_search_item.json");
      for (;;)
      {
        int i;
        try
        {
          localObject = new JSONArray((String)localObject);
          i = 0;
          int j = ((JSONArray)localObject).length();
          if (i < j)
          {
            JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(i);
            int k = localJSONObject.getInt("type");
            if (k == 1) {
              this.datas.add(new Item(k, localJSONObject.getString("name"), localJSONObject.getString("id"), localJSONObject.getString("icon")));
            } else {
              this.datas.add(new Item(k, localJSONObject.getString("name"), localJSONObject.getString("id")));
            }
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
        return;
        i += 1;
      }
    }
    
    public int getCount()
    {
      return this.datas.size();
    }
    
    public Item getItem(int paramInt)
    {
      return (Item)this.datas.get(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public int getItemViewType(int paramInt)
    {
      int i = 1;
      if (getItem(paramInt).type == 1) {
        i = 0;
      }
      return i;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject;
      label72:
      Item localItem;
      if (paramView == null)
      {
        localObject = new ViewHolder(null);
        int i = 2130968941;
        if (getItemViewType(paramInt) == 0) {
          i = 2130968940;
        }
        paramView = LayoutInflater.from(NameSearchFragment.this.getContext()).inflate(i, paramViewGroup, false);
        ((ViewHolder)localObject).textView = ((TextView)paramView.findViewById(2131625682));
        paramView.setTag(localObject);
        paramViewGroup = (ViewGroup)localObject;
        localItem = getItem(paramInt);
        paramViewGroup.textView.setText(localItem.name);
        if (getItemViewType(paramInt) != 0) {
          break label244;
        }
        localObject = NameSearchFragment.this.getContext().getResources();
        paramInt = ((Resources)localObject).getIdentifier(NameSearchFragment.this.getContext().getPackageName() + ":drawable/" + localItem.icon, null, null);
        if (paramInt > 0)
        {
          if (Build.VERSION.SDK_INT < 21) {
            break label233;
          }
          localObject = ((Resources)localObject).getDrawable(paramInt, null);
          label176:
          paramViewGroup.textView.setCompoundDrawablesWithIntrinsicBounds(null, (Drawable)localObject, null, null);
        }
      }
      for (;;)
      {
        switch (localItem.type)
        {
        default: 
          return paramView;
          paramViewGroup = (ViewHolder)paramView.getTag();
          break label72;
          label233:
          localObject = ((Resources)localObject).getDrawable(paramInt);
          break label176;
          label244:
          paramViewGroup.textView.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }
      }
      paramViewGroup.textView.setTextColor(NameSearchFragment.this.getResources().getColor(2131558702));
      return paramView;
      paramViewGroup.textView.setTextColor(NameSearchFragment.this.getResources().getColor(2131558687));
      return paramView;
      paramViewGroup.textView.setTextColor(NameSearchFragment.this.getResources().getColor(2131558692));
      return paramView;
    }
    
    public int getViewTypeCount()
    {
      return 2;
    }
    
    class Item
    {
      String icon = "";
      String id = "";
      String name = "";
      int type = 0;
      
      Item(int paramInt, String paramString1, String paramString2)
      {
        this(paramInt, paramString1, paramString2, "");
      }
      
      Item(int paramInt, String paramString1, String paramString2, String paramString3)
      {
        this.type = paramInt;
        this.name = paramString1;
        this.id = paramString2;
        this.icon = paramString3;
      }
    }
    
    private class ViewHolder
    {
      TextView textView;
      
      private ViewHolder() {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/NameSearchFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */