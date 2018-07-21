package com.baidu.navi.fragment.carmode;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.baidu.baidunavis.control.NavMapManager;
import com.baidu.baidunavis.control.NavPoiController;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.carlife.core.screen.presentation.a.e;
import com.baidu.carlife.core.screen.presentation.a.h;
import com.baidu.carlife.f.d;
import com.baidu.carlife.logic.voice.n;
import com.baidu.carlife.view.KeyboardEditText;
import com.baidu.carlife.view.a.a;
import com.baidu.carlife.view.a.c;
import com.baidu.carlife.view.a.d;
import com.baidu.navi.FavoritePoiManager;
import com.baidu.navi.FavoritePoiManager.FavCallBack;
import com.baidu.navi.FavoritePoiManager.FavorItem;
import com.baidu.navi.adapter.NameSearchAdapter;
import com.baidu.navi.adapter.NameSearchAdapter.NameSearchEntity;
import com.baidu.navi.adapter.NameSearchAdapter.NameSearchEntity.Type;
import com.baidu.navi.cache.RouteInfoCache;
import com.baidu.navi.controller.FavoriteDestinationController;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.controller.QuickRoutePlanController;
import com.baidu.navi.controller.SearchStrategyHelper;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.logic.model.UIModel;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.comapi.voicecommand.BNVoiceCommandController;
import com.baidu.navisdk.logic.ReqData;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.AddressSettingModel;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.datastruct.DistrictInfo;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.SearchCircle;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.datastruct.SearchPoiPager;
import com.baidu.navisdk.model.datastruct.SearchSugData;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.db.model.SearchNameHistroyModel;
import com.baidu.navisdk.util.db.object.SearchNameDBObject;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class CarModeQuickRoutePlanFragment
  extends ContentFragment
  implements View.OnClickListener, a.c
{
  public static final String INCOMING_TYPE = "incoming_type";
  private static final int K_TIMEOUT_SUG = 3000;
  private static final int OVER_TIME_LONG = 30000;
  private static final int OVER_TIME_SHORT = 5000;
  private static final String TAG = "CarModeQuickRoutePlanFragment";
  private boolean canSugShow = false;
  private int cityId = 0;
  private View companyView;
  private View favoriteView;
  private boolean hasData = false;
  private View homeView;
  private boolean isFromVoice = false;
  private boolean isPoiSearchMod = false;
  private boolean isSearchEnable = false;
  private boolean isShowHeader = false;
  private boolean isSpaceSearchMode = false;
  private com.baidu.carlife.view.dialog.c mAlertDlg;
  private ImageButton mBackBtn;
  private GeoPoint mCurrentGeoPoint;
  private SearchPoi mCurrentPoi;
  private NameSearchAdapter mDataAdapter;
  private List<NameSearchAdapter.NameSearchEntity> mDataList;
  private DistrictInfo mDistrictInfo;
  private boolean mEdViewHasFocus = false;
  private View mEditLine;
  private LinearLayout mEditTextContentLayout;
  private com.baidu.carlife.f.g mFocusAreaTop;
  private com.baidu.carlife.f.g mFocusAreaUp;
  private com.baidu.carlife.f.g mFocusDownArea;
  private com.baidu.carlife.f.c mFocusList;
  private View mFooterView;
  private j mHandler = new j()
  {
    public void careAbout()
    {
      addMsg(1002);
      addMsg(5151);
    }
    
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 1002) {
        CarModeQuickRoutePlanFragment.this.reAddEditTextView();
      }
      do
      {
        do
        {
          for (;;)
          {
            return;
            if (CarModeQuickRoutePlanFragment.this.canProcessUI())
            {
              RspData localRspData = (RspData)paramAnonymousMessage.obj;
              if (paramAnonymousMessage.what != 1005) {
                break;
              }
              e.a().c();
              SearchPoiPager localSearchPoiPager = (SearchPoiPager)localRspData.mData;
              if (localSearchPoiPager == null)
              {
                if ((CarModeQuickRoutePlanFragment.this.netMode == 1) && (CarModeQuickRoutePlanFragment.this.hasData))
                {
                  paramAnonymousMessage = (SearchPoiPager)localRspData.mReq.mParams.get("param.search.pager");
                  CarModeQuickRoutePlanFragment.this.handleTimeout(paramAnonymousMessage);
                  CarModeQuickRoutePlanFragment.access$1702(CarModeQuickRoutePlanFragment.this, false);
                  return;
                }
                i.e("CarModeQuickRoutePlanFragment", "search with pager fail");
                if (CarModeQuickRoutePlanFragment.this.isFromVoice == true) {
                  BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
                }
                TipTool.onCreateToastDialog(CarModeQuickRoutePlanFragment.this.getContext(), 2131298915);
                return;
              }
              localSearchPoiPager.setNetMode(BNPoiSearcher.getInstance().getNetModeOfLastResult());
              switch (localSearchPoiPager.getSearchType())
              {
              }
              while ((CarModeQuickRoutePlanFragment.this.isFromVoice == true) && (paramAnonymousMessage.arg1 != 0))
              {
                BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
                return;
                if (paramAnonymousMessage.arg1 == 0)
                {
                  i.e("CarModeQuickRoutePlanFragment", "onSearchCatalogSucc()");
                  CarModeQuickRoutePlanFragment.this.handleSpaceCatalogSearchSuc(localSearchPoiPager);
                }
                else
                {
                  i.e("CarModeQuickRoutePlanFragment", "Space Search fail");
                  TipTool.onCreateToastDialog(CarModeQuickRoutePlanFragment.this.getContext(), 2131298918);
                  continue;
                  if (paramAnonymousMessage.arg1 == 0)
                  {
                    CarModeQuickRoutePlanFragment.this.handleNameSearchSuc(localSearchPoiPager);
                  }
                  else
                  {
                    i.e("CarModeQuickRoutePlanFragment", "Name Search fail");
                    TipTool.onCreateToastDialog(CarModeQuickRoutePlanFragment.this.getContext(), 2131298915);
                    continue;
                    if (paramAnonymousMessage.arg1 == 0)
                    {
                      i.e("CarModeQuickRoutePlanFragment", "onSearchCatalogSucc()");
                      CarModeQuickRoutePlanFragment.this.handleSpaceKeySearchSuc(localSearchPoiPager);
                      return;
                    }
                    i.e("CarModeQuickRoutePlanFragment", "Space Search fail");
                    TipTool.onCreateToastDialog(CarModeQuickRoutePlanFragment.this.getContext(), 2131298915);
                  }
                }
              }
            }
          }
        } while (paramAnonymousMessage.what != 1004);
        if (paramAnonymousMessage.arg1 == 0)
        {
          i.e("CarModeQuickRoutePlanFragment", "Sug sucess!!!");
          CarModeQuickRoutePlanFragment.access$1502(CarModeQuickRoutePlanFragment.this, true);
          CarModeQuickRoutePlanFragment.this.updateListView();
          return;
        }
      } while (paramAnonymousMessage.arg1 == -2);
      i.e("CarModeQuickRoutePlanFragment", "Sug fail!!!");
    }
  };
  private View mHeaderView;
  private ListView mListView;
  private QuickRoutePlanController mQuickRoutePlanController;
  private ImageButton mRightImageButton;
  private com.baidu.carlife.core.screen.b mSearchDialogCancelListener = new com.baidu.carlife.core.screen.b()
  {
    public void onClick()
    {
      BNPoiSearcher.getInstance().cancelQuery();
    }
  };
  private KeyboardEditText mSearchEditText;
  private String mSearchKey = "";
  private ArrayList<SearchSugData> mSugDataList;
  private Handler mUIHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      if (paramAnonymousMessage.arg1 == 0)
      {
        paramAnonymousMessage = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getAntiGeoPoi();
        if (CarModeQuickRoutePlanFragment.this.mShowBundle.getInt("select_point_action") == 1)
        {
          paramAnonymousMessage = new RoutePlanNode(paramAnonymousMessage.mGuidePoint, paramAnonymousMessage.mViewPoint, 8, paramAnonymousMessage.mName, paramAnonymousMessage.mAddress, paramAnonymousMessage.mOriginUID);
          FavoriteDestinationController.getInstance().addFavoriteDestFromDB(paramAnonymousMessage, null);
        }
        for (;;)
        {
          CarModeQuickRoutePlanFragment.this.backTo(CarModeQuickRoutePlanFragment.this.mShowBundle.getInt("from_Fragment"), null);
          if (CarModeQuickRoutePlanFragment.this.newBundle == null) {
            break;
          }
          CarModeQuickRoutePlanFragment.access$2502(CarModeQuickRoutePlanFragment.this, null);
          CarModeQuickRoutePlanFragment.this.mShowBundle = CarModeQuickRoutePlanFragment.this.oldBundle;
          CarModeQuickRoutePlanFragment.this.updateHeadView();
          CarModeQuickRoutePlanFragment.this.searchHeadItemView.setVisibility(0);
          CarModeQuickRoutePlanFragment.this.getBundle();
          CarModeQuickRoutePlanFragment.this.updateListView();
          return;
          Bundle localBundle = new Bundle();
          localBundle.putInt("select_point_action", CarModeQuickRoutePlanFragment.this.mShowBundle.getInt("select_point_action"));
          UIModel.settingAddress(paramAnonymousMessage, com.baidu.carlife.core.a.a(), localBundle);
        }
      }
      TipTool.onCreateToastDialog(com.baidu.carlife.core.a.a(), 2131296558);
    }
  };
  private ViewGroup mViewGroup;
  private int netMode = 3;
  private Bundle newBundle;
  private Bundle oldBundle;
  private RoutePlanNode oldNode;
  private int overTime = 0;
  private View searchHeadItemView;
  private View searchNearView;
  private int sugNetMode = 3;
  private TextView tvCompanySetting;
  private TextView tvHomeSetting;
  
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
  
  private void getBundle()
  {
    this.isShowHeader = false;
    if ((this.mShowBundle != null) && (this.mShowBundle.containsKey("from_Fragment")) && ((this.mShowBundle.getInt("from_Fragment") == 304) || (this.mShowBundle.getInt("from_Fragment") == 49))) {
      this.isShowHeader = true;
    }
    if (this.isShowHeader)
    {
      this.mListView.setAdapter(null);
      this.mListView.addHeaderView(this.mHeaderView);
      this.mListView.setAdapter(this.mDataAdapter);
    }
  }
  
  private ArrayList<NameSearchAdapter.NameSearchEntity> getFavDataFromDB(String paramString)
  {
    Object localObject = FavoritePoiManager.getInstance().dbFavorItems;
    ArrayList localArrayList = new ArrayList();
    if (((List)localObject).size() > 0)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        FavoritePoiManager.FavorItem localFavorItem = (FavoritePoiManager.FavorItem)((Iterator)localObject).next();
        if (localFavorItem.name.contains(paramString)) {
          localArrayList.add(new NameSearchAdapter.NameSearchEntity(localFavorItem.name + " " + localFavorItem.address, NameSearchAdapter.NameSearchEntity.Type.FAVORITE));
        }
      }
    }
    return localArrayList;
  }
  
  private int getFinalNetMode(int paramInt)
  {
    int i = BNSettingManager.getPrefSearchMode();
    if (paramInt == 0)
    {
      this.hasData = true;
      if (i != 2) {
        break label61;
      }
      if (!this.hasData) {
        break label56;
      }
      paramInt = 0;
    }
    for (;;)
    {
      if ((this.hasData) || (paramInt != 1)) {
        break label88;
      }
      this.overTime = 30000;
      return paramInt;
      this.hasData = false;
      break;
      label56:
      paramInt = 1;
      continue;
      label61:
      if ((!NetworkUtils.isNetworkAvailable(getContext())) && (this.hasData)) {
        paramInt = 0;
      } else {
        paramInt = 1;
      }
    }
    label88:
    this.overTime = 5000;
    return paramInt;
  }
  
  private a.d getFocusChangeListener()
  {
    new a.d()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          CarModeQuickRoutePlanFragment.this.mEditLine.setBackgroundColor(CarModeQuickRoutePlanFragment.this.getResources().getColor(2131558646));
        }
        for (;;)
        {
          CarModeQuickRoutePlanFragment.access$802(CarModeQuickRoutePlanFragment.this, paramAnonymousBoolean);
          return;
          CarModeQuickRoutePlanFragment.this.mEditLine.setBackgroundColor(CarModeQuickRoutePlanFragment.this.getResources().getColor(2131558628));
          CarModeQuickRoutePlanFragment.this.hideSoftInputMethod();
        }
      }
    };
  }
  
  private TextView.OnEditorActionListener getOnEditorActionListener()
  {
    new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if (paramAnonymousInt == 3) {
          CarModeQuickRoutePlanFragment.this.onClickFinish();
        }
        return false;
      }
    };
  }
  
  private AdapterView.OnItemClickListener getOnItemClickListener()
  {
    new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        int i = CarModeQuickRoutePlanFragment.this.mListView.getHeaderViewsCount();
        if ((i == 1) && (paramAnonymousInt == 0)) {
          CarModeQuickRoutePlanFragment.this.setPointSelectNode();
        }
        do
        {
          return;
          paramAnonymousInt -= i;
          if ((CarModeQuickRoutePlanFragment.this.mListView.getFooterViewsCount() == 1) && (paramAnonymousInt == CarModeQuickRoutePlanFragment.this.mDataAdapter.getCount()))
          {
            CarModeQuickRoutePlanFragment.this.showTwoBtnDialog(2131297123, new com.baidu.carlife.core.screen.b()new com.baidu.carlife.core.screen.b
            {
              public void onClick()
              {
                SearchNameHistroyModel.getInstance().clear();
                CarModeQuickRoutePlanFragment.this.updateListView();
              }
            }, new com.baidu.carlife.core.screen.b()
            {
              public void onClick()
              {
                CarModeQuickRoutePlanFragment.this.dismissTwoBtnDialog();
              }
            });
            return;
          }
          paramAnonymousAdapterView = CarModeQuickRoutePlanFragment.this.mDataAdapter.getItem(paramAnonymousInt);
        } while (paramAnonymousAdapterView == null);
        if (((paramAnonymousAdapterView.getType() == NameSearchAdapter.NameSearchEntity.Type.HOME) || (paramAnonymousAdapterView.getType() == NameSearchAdapter.NameSearchEntity.Type.COMPANY)) && (paramAnonymousAdapterView.getNode() != null))
        {
          CarModeQuickRoutePlanFragment.this.mQuickRoutePlanController.startRoutePlan(paramAnonymousAdapterView.getNode());
          return;
        }
        paramAnonymousView = paramAnonymousAdapterView.getName();
        String str = CarModeQuickRoutePlanFragment.this.mDataAdapter.getItem(paramAnonymousInt).getAddress();
        paramAnonymousAdapterView = paramAnonymousView;
        if (!TextUtils.isEmpty(str)) {
          paramAnonymousAdapterView = paramAnonymousView + " " + str;
        }
        if (CarModeQuickRoutePlanFragment.this.isSpaceSearchMode)
        {
          CarModeQuickRoutePlanFragment.this.trySearchSpace(paramAnonymousAdapterView);
          return;
        }
        CarModeQuickRoutePlanFragment.this.trySearch(paramAnonymousAdapterView);
      }
    };
  }
  
  private AbsListView.OnScrollListener getOnScrollListener()
  {
    new AbsListView.OnScrollListener()
    {
      public void onScroll(AbsListView paramAnonymousAbsListView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onScrollStateChanged(AbsListView paramAnonymousAbsListView, int paramAnonymousInt)
      {
        CarModeQuickRoutePlanFragment.this.hideSoftInputMethod();
      }
    };
  }
  
  private TextWatcher getTextChangedListener()
  {
    new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        CarModeQuickRoutePlanFragment.access$902(CarModeQuickRoutePlanFragment.this, CarModeQuickRoutePlanFragment.this.mSearchEditText.getText().toString().trim());
        if (!StringUtils.isEmpty(CarModeQuickRoutePlanFragment.this.mSearchKey))
        {
          CarModeQuickRoutePlanFragment.this.mRightImageButton.setImageResource(2130838287);
          CarModeQuickRoutePlanFragment.this.mRightImageButton.setTag("delete");
          CarModeQuickRoutePlanFragment.this.mRightImageButton.setVisibility(0);
          if (!CarModeQuickRoutePlanFragment.this.isSearchEnable) {
            CarModeQuickRoutePlanFragment.access$1202(CarModeQuickRoutePlanFragment.this, true);
          }
          FavoritePoiManager.getInstance().startGetTask(CarModeQuickRoutePlanFragment.this.mSearchKey, new FavoritePoiManager.FavCallBack()
          {
            public void callUpdate()
            {
              CarModeQuickRoutePlanFragment.this.updateListView();
            }
          });
          BNPoiSearcher.getInstance().asynGetInputSug(CarModeQuickRoutePlanFragment.this.mSearchKey, CarModeQuickRoutePlanFragment.this.sugNetMode, 3000, CarModeQuickRoutePlanFragment.this.mHandler);
          i.e("CarModeQuickRoutePlanFragment", "asynGetInputSug key = " + CarModeQuickRoutePlanFragment.this.mSearchKey);
        }
        for (;;)
        {
          CarModeQuickRoutePlanFragment.this.updateListView();
          return;
          CarModeQuickRoutePlanFragment.this.mRightImageButton.setTag("");
          CarModeQuickRoutePlanFragment.this.mRightImageButton.setVisibility(8);
          if (CarModeQuickRoutePlanFragment.this.isSearchEnable)
          {
            CarModeQuickRoutePlanFragment.access$1202(CarModeQuickRoutePlanFragment.this, false);
            CarModeQuickRoutePlanFragment.access$1502(CarModeQuickRoutePlanFragment.this, false);
          }
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
  }
  
  private void handleNameSearchSuc(SearchPoiPager paramSearchPoiPager)
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
      }
    } while ((mActivity == null) || (mActivity.isFinishing()));
    showFragment(35, (Bundle)localObject);
  }
  
  private void handleSpaceCatalogSearchSuc(SearchPoiPager paramSearchPoiPager)
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
      localObject = this.mShowBundle;
      paramSearchPoiPager = (SearchPoiPager)localObject;
      if (localObject == null) {
        paramSearchPoiPager = new Bundle();
      }
      if (this.isPoiSearchMod) {
        paramSearchPoiPager.putBoolean("poi_center_mode", true);
      }
      paramSearchPoiPager.putString("search_key", this.mSearchKey);
      paramSearchPoiPager.putInt("search_mode", this.netMode);
      paramSearchPoiPager.putInt("incoming_type", 33);
      paramSearchPoiPager.putInt("search_type", 19);
      paramSearchPoiPager.putInt("district_id", this.mDistrictInfo.mId);
    } while ((mActivity == null) || (mActivity.isFinishing()));
    showFragment(35, paramSearchPoiPager);
  }
  
  private void handleSpaceKeySearchSuc(SearchPoiPager paramSearchPoiPager)
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
      Bundle localBundle = this.mShowBundle;
      localObject = localBundle;
      if (localBundle == null) {
        localObject = new Bundle();
      }
      ((Bundle)localObject).putString("search_key", paramSearchPoiPager.getSearchKey());
      ((Bundle)localObject).putInt("district_id", this.cityId);
      ((Bundle)localObject).putInt("search_mode", this.netMode);
      ((Bundle)localObject).putInt("search_type", 18);
    } while ((mActivity == null) || (mActivity.isFinishing()));
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
        BNPoiSearcher.getInstance().asynSearchWithPager(paramSearchPoiPager, this.overTime, this.mHandler);
        e.a().a(getResources().getString(2131296861), this.mSearchDialogCancelListener);
      }
      return;
    }
    if (this.isFromVoice == true) {
      BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
    }
    TipTool.onCreateToastDialog(getContext(), 2131298915);
  }
  
  private boolean resultEmpty(final SearchPoiPager paramSearchPoiPager)
  {
    if ((this.netMode == 0) && (this.hasData))
    {
      showTwoBtnDialog(2131298914, new com.baidu.carlife.core.screen.b()new com.baidu.carlife.core.screen.b
      {
        public void onClick()
        {
          CarModeQuickRoutePlanFragment.this.dismissTwoBtnDialog();
          CarModeQuickRoutePlanFragment.access$1602(CarModeQuickRoutePlanFragment.this, 1);
          if (SearchStrategyHelper.getInstance(CarModeQuickRoutePlanFragment.this.getContext()).checkCanSearchByNetMode(CarModeQuickRoutePlanFragment.this.netMode))
          {
            paramSearchPoiPager.setNetMode(CarModeQuickRoutePlanFragment.this.netMode);
            BNPoiSearcher.getInstance().asynSearchWithPager(paramSearchPoiPager, CarModeQuickRoutePlanFragment.this.overTime, CarModeQuickRoutePlanFragment.this.mHandler);
            e.a().a(CarModeQuickRoutePlanFragment.this.getResources().getString(2131296861), CarModeQuickRoutePlanFragment.this.mSearchDialogCancelListener);
          }
        }
      }, new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          CarModeQuickRoutePlanFragment.this.dismissTwoBtnDialog();
        }
      });
      return true;
    }
    if (this.netMode == 1)
    {
      if (this.hasData)
      {
        this.hasData = false;
        this.netMode = 0;
        paramSearchPoiPager.setNetMode(this.netMode);
        BNPoiSearcher.getInstance().asynSearchWithPager(paramSearchPoiPager, this.overTime, this.mHandler);
      }
      for (;;)
      {
        return false;
        if (this.isFromVoice == true) {
          BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
        }
        if (NetworkUtils.isNetworkAvailable(getContext())) {
          TipTool.onCreateToastDialog(getContext(), 2131298915);
        } else {
          TipTool.onCreateToastDialog(getContext(), 2131298924);
        }
      }
    }
    if (this.isFromVoice == true) {
      BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
    }
    TipTool.onCreateToastDialog(getContext(), 2131298915);
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
    SearchStrategyHelper.getInstance(getContext()).reloadSearchEngine();
    Object localObject = new SearchCircle(this.mCurrentGeoPoint, 5000);
    if (SearchStrategyHelper.getInstance(mActivity).checkCanSearchByNetMode(this.netMode))
    {
      localObject = new SearchPoiPager(paramInt, this.mDistrictInfo, (SearchCircle)localObject, 10, this.netMode);
      if (BNPoiSearcher.getInstance().asynSearchWithPager((SearchPoiPager)localObject, this.mHandler)) {
        e.a().a(getResources().getString(2131296861), this.mSearchDialogCancelListener);
      }
    }
    while (this.isFromVoice != true) {
      return;
    }
    BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
  }
  
  private void searchSpace(String paramString)
  {
    SearchStrategyHelper.getInstance(getContext()).reloadSearchEngine();
    SearchCircle localSearchCircle = new SearchCircle(this.mCurrentGeoPoint, 5000);
    if (SearchStrategyHelper.getInstance(getContext()).checkCanSearchByNetMode(this.netMode))
    {
      paramString = new SearchPoiPager(paramString, this.mDistrictInfo, localSearchCircle, 10, this.netMode);
      if (BNPoiSearcher.getInstance().asynSearchWithPager(paramString, this.mHandler)) {
        e.a().a(getResources().getString(2131296861), this.mSearchDialogCancelListener);
      }
    }
    while (this.isFromVoice != true) {
      return;
    }
    BNVoiceCommandController.getInstance().commonVoiceCommandResponse(BNVoiceCommandController.getInstance().getLastestVCTopType(), 2);
  }
  
  private void setPointSelectNode()
  {
    GeoPoint localGeoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
    if ((localGeoPoint == null) || (!localGeoPoint.isValid()))
    {
      TipTool.onCreateToastDialog(getContext(), 2131296908);
      return;
    }
    Object localObject = new SearchPoi();
    ((SearchPoi)localObject).mViewPoint = localGeoPoint;
    ((SearchPoi)localObject).mGuidePoint = localGeoPoint;
    this.mCurrentPoi = ((SearchPoi)localObject);
    localObject = PoiController.getInstance();
    ((PoiController)localObject).clearPoiCache();
    int i = ((PoiController)localObject).getAntiPoiNetMode(localGeoPoint);
    if (i == -1)
    {
      TipTool.onCreateToastDialog(getContext(), 2131297178);
      return;
    }
    ((PoiController)localObject).antiGeo(this.mCurrentPoi, i, this.mUIHandler);
  }
  
  private void trySearch(String paramString)
  {
    if ("加油站".equals(paramString))
    {
      trySearchSpace(31552);
      return;
    }
    if (("厕所".equals(paramString)) || ("洗手间".equals(paramString)))
    {
      trySearchSpace(11392);
      return;
    }
    if ("停车场".equals(paramString))
    {
      trySearchSpace(31488);
      return;
    }
    if (("ATM".equals(paramString.toUpperCase())) || ("银行".equals(paramString)))
    {
      trySearchSpace(16448);
      return;
    }
    this.mCurrentGeoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
    NavPoiController.getInstance().setMyPositionGeo(this.mCurrentGeoPoint);
    this.netMode = SearchStrategyHelper.getInstance(getContext()).getNetModeBySet(this.mDistrictInfo);
    BNSettingManager.getPrefSearchMode();
    this.netMode = getFinalNetMode(this.netMode);
    search(paramString);
  }
  
  private void trySearchSpace(int paramInt)
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
    NavPoiController.getInstance().setMyPositionGeo(this.mCurrentGeoPoint);
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
    NavPoiController.getInstance().setMyPositionGeo(this.mCurrentGeoPoint);
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
  
  private void updateHeadView()
  {
    RoutePlanNode localRoutePlanNode1 = getHomeAddress();
    RoutePlanNode localRoutePlanNode2 = getCompanyAddress();
    this.tvHomeSetting.setVisibility(8);
    this.tvCompanySetting.setVisibility(8);
    if (localRoutePlanNode1 == null) {
      this.tvHomeSetting.setVisibility(0);
    }
    if (localRoutePlanNode2 == null) {
      this.tvCompanySetting.setVisibility(0);
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
    i.b("yftech", "CarModeQuickRoutePlanFragment driving " + this.mModuleFrom);
    dismissAllDialog();
    backTo(17, null);
    com.baidu.carlife.custom.a.a().d();
  }
  
  public RoutePlanNode getCompanyAddress()
  {
    RoutePlanNode localRoutePlanNode = null;
    if (AddressSettingModel.hasSetCompAddr(BNaviModuleManager.getContext())) {
      localRoutePlanNode = AddressSettingModel.getCompAddrNode(BNaviModuleManager.getContext());
    }
    return localRoutePlanNode;
  }
  
  public RoutePlanNode getHomeAddress()
  {
    RoutePlanNode localRoutePlanNode = null;
    if (AddressSettingModel.hasSetHomeAddr(BNaviModuleManager.getContext())) {
      localRoutePlanNode = AddressSettingModel.getHomeAddrNode(BNaviModuleManager.getContext());
    }
    return localRoutePlanNode;
  }
  
  protected void hideSoftInputMethod()
  {
    ((InputMethodManager)mActivity.getSystemService("input_method")).hideSoftInputFromWindow(this.mSearchEditText.getWindowToken(), 0);
  }
  
  public void initFocusChain(View paramView)
  {
    if (getCurrentFragmentType() != 49) {
      return;
    }
    if (this.mFocusAreaTop == null)
    {
      this.mFocusAreaTop = new com.baidu.carlife.f.g(paramView, 0);
      this.mFocusAreaTop.d(this.mBackBtn).d(this.mSearchEditText).d(this.mRightImageButton);
      this.mFocusAreaTop.b(this.mSearchEditText);
      d.a().b(this.mFocusAreaTop);
    }
    if (this.mFocusAreaUp == null)
    {
      this.mFocusAreaUp = new com.baidu.carlife.f.g(this.searchHeadItemView, 2);
      this.mFocusAreaUp.d(this.homeView).d(this.companyView).d(this.favoriteView).d(this.searchNearView);
      this.mFocusAreaUp.b(this.homeView);
      label147:
      if (com.baidu.carlife.view.a.a().b()) {
        break label380;
      }
      paramView = mActivity.u().g();
      if (this.mFocusDownArea == null)
      {
        this.mFocusDownArea = new com.baidu.carlife.f.g(paramView, 6);
        this.mFocusDownArea.d(paramView.findViewById(2131623991)).d(paramView.findViewById(2131623992)).d(paramView.findViewById(2131623993)).d(paramView.findViewById(2131623994)).d(paramView.findViewById(2131623995));
      }
      this.mFocusDownArea.b(true);
      this.mFocusDownArea.b(paramView.findViewById(2131623993));
      if (this.mFocusList == null) {
        this.mFocusList = new com.baidu.carlife.f.c(this.mListView, 4);
      }
      if ((this.mListView.getAdapter() == null) || (this.mListView.getAdapter().getCount() <= 0)) {
        break label382;
      }
      d.a().b(new com.baidu.carlife.f.a[] { this.mFocusAreaTop, this.mFocusAreaUp, this.mFocusList, this.mFocusDownArea });
    }
    for (;;)
    {
      d.a().h(this.mFocusDownArea);
      return;
      if (this.searchHeadItemView.getVisibility() == 0) {
        break label147;
      }
      this.mFocusAreaUp = null;
      break label147;
      label380:
      break;
      label382:
      d.a().b(new com.baidu.carlife.f.a[] { this.mFocusAreaTop, this.mFocusAreaUp, this.mFocusDownArea });
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
  }
  
  public boolean onBackPressed()
  {
    if (this.newBundle != null)
    {
      this.newBundle = null;
      this.mShowBundle = this.oldBundle;
      updateHeadView();
      this.searchHeadItemView.setVisibility(0);
      getBundle();
      updateListView();
      return true;
    }
    pageBack(this.mModuleFrom);
    return true;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131624130: 
    case 2131624131: 
      do
      {
        return;
        if (this.newBundle != null)
        {
          this.newBundle = null;
          this.mShowBundle = this.oldBundle;
          updateHeadView();
          this.searchHeadItemView.setVisibility(0);
          getBundle();
          updateListView();
          return;
        }
        pageBack(this.mModuleFrom);
        return;
      } while (!TextUtils.equals((String)paramView.getTag(), "delete"));
      this.mSearchEditText.setText("");
      return;
    case 2131625383: 
      this.oldNode = getHomeAddress();
      if (this.oldNode != null)
      {
        this.mQuickRoutePlanController.startRoutePlan(this.oldNode);
        return;
      }
      this.mShowBundle = new Bundle();
      this.mShowBundle.putInt("from_Fragment", 49);
      this.mShowBundle.putInt("select_point_action", 4);
      this.newBundle = this.mShowBundle;
      getBundle();
      updateListView();
      return;
    case 2131625385: 
      this.oldNode = getCompanyAddress();
      if (this.oldNode != null)
      {
        this.mQuickRoutePlanController.startRoutePlan(this.oldNode);
        return;
      }
      this.mShowBundle = new Bundle();
      this.mShowBundle.putInt("from_Fragment", 49);
      this.mShowBundle.putInt("select_point_action", 5);
      this.newBundle = this.mShowBundle;
      getBundle();
      updateListView();
      return;
    case 2131625387: 
      showFragment(306, null);
      return;
    }
    showFragment(34, null);
  }
  
  public void onClickFinish()
  {
    String str;
    if (this.isSearchEnable)
    {
      str = this.mSearchEditText.getText().toString().trim();
      i.e("CarModeQuickRoutePlanFragment", "mSearchKey:" + str);
      if (!this.isSpaceSearchMode) {
        break label59;
      }
      trySearchSpace(str);
    }
    label59:
    do
    {
      return;
      trySearch(str);
      if ("openlog".equals(str))
      {
        com.baidu.carlife.core.f.jp = 3;
        n.a().d(true);
        return;
      }
    } while (!"openlogfile".equals(str));
    com.baidu.carlife.core.f.jp = 3;
    com.baidu.carlife.core.f.ju = true;
    i.a().b();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mQuickRoutePlanController = new QuickRoutePlanController(mActivity, null, getNaviFragmentManager(), this);
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2130968662, null));
    this.mEditTextContentLayout = ((LinearLayout)this.mViewGroup.findViewById(2131624132));
    this.mBackBtn = ((ImageButton)this.mViewGroup.findViewById(2131624130));
    this.mBackBtn.setOnClickListener(this);
    this.searchHeadItemView = this.mViewGroup.findViewById(2131624426);
    this.homeView = this.mViewGroup.findViewById(2131625383);
    this.companyView = this.mViewGroup.findViewById(2131625385);
    this.favoriteView = this.mViewGroup.findViewById(2131625387);
    this.searchNearView = this.mViewGroup.findViewById(2131625388);
    this.tvHomeSetting = ((TextView)this.mViewGroup.findViewById(2131625384));
    this.tvCompanySetting = ((TextView)this.mViewGroup.findViewById(2131625386));
    this.homeView.setOnClickListener(this);
    this.companyView.setOnClickListener(this);
    this.favoriteView.setOnClickListener(this);
    this.searchNearView.setOnClickListener(this);
    this.mSearchEditText = ((KeyboardEditText)this.mViewGroup.findViewById(2131624531));
    this.mSearchEditText.addTextChangedListener(getTextChangedListener());
    this.mSearchEditText.setOnEditorActionListener(getOnEditorActionListener());
    KeyboardEditText localKeyboardEditText = this.mSearchEditText;
    com.baidu.carlife.view.a locala = com.baidu.carlife.view.a.a();
    locala.getClass();
    localKeyboardEditText.setOnTouchListener(new a.a(locala, this.mSearchEditText, 3, this, getFocusChangeListener()));
    this.mEditLine = this.mViewGroup.findViewById(2131624133);
    this.mRightImageButton = ((ImageButton)this.mViewGroup.findViewById(2131624131));
    this.mRightImageButton.setTag("");
    this.mRightImageButton.setOnClickListener(this);
    this.mListView = ((ListView)this.mViewGroup.findViewById(2131624428));
    this.mListView.setOnItemClickListener(getOnItemClickListener());
    this.mListView.setOnScrollListener(getOnScrollListener());
    this.mHeaderView = paramLayoutInflater.inflate(2130968674, this.mListView, false);
    this.mFooterView = paramLayoutInflater.inflate(2130968673, this.mListView, false);
    this.mDataList = new ArrayList();
    this.mSugDataList = new ArrayList();
    k.a(this.mHandler);
    this.mListView.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        boolean bool = com.baidu.carlife.view.a.a().b();
        if ((paramAnonymousBoolean) && (bool)) {
          com.baidu.carlife.view.a.a().d();
        }
      }
    });
    if (!PreferenceHelper.getInstance(getNaviActivity()).getBoolean("home_search_tip", false))
    {
      getNaviActivity().u().a(getStringUtil(2131296534));
      PreferenceHelper.getInstance(getNaviActivity()).putBoolean("home_search_tip", true);
      this.mHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          if ((BaseFragment.getNaviActivity() != null) && (BaseFragment.getNaviActivity().u() != null)) {
            BaseFragment.getNaviActivity().u().a();
          }
        }
      }, 8000L);
    }
    return this.mViewGroup;
  }
  
  public void onDestroy()
  {
    k.b(this.mHandler);
    RouteInfoCache.getInstance().setCallback(null);
    FavoritePoiManager.getInstance().cancelTask();
    super.onDestroy();
  }
  
  public void onHiddenChanged(boolean paramBoolean)
  {
    super.onHiddenChanged(paramBoolean);
    if (!paramBoolean)
    {
      BNPoiSearcher.getInstance().setNetMode(BNSettingManager.getPrefSearchMode());
      if (getNaviFragmentManager().isDriving())
      {
        dismissAllDialog();
        pageBack(this.mModuleFrom);
        i.b("yftech", "CarModeQuickRoutePlanFragment onHiddenChanged " + this.mModuleFrom);
        com.baidu.carlife.custom.a.a().d();
      }
      return;
    }
    getNaviActivity().u().a();
  }
  
  public void onInitFocusAreas()
  {
    super.onInitFocusAreas();
    initFocusChain(this.mViewGroup);
  }
  
  protected void onInitView()
  {
    this.oldBundle = this.mShowBundle;
    getBundle();
  }
  
  public void onPause()
  {
    super.onPause();
    getNaviActivity().u().a();
    e.a().c();
    BNPoiSearcher.getInstance().setNetMode(BNSettingManager.getPrefSearchMode());
    BNPoiSearcher.getInstance().releaseInputSug(this.sugNetMode);
    hideSoftInputMethod();
    com.baidu.carlife.view.a.a().d();
  }
  
  public void onResume()
  {
    super.onResume();
    updateHeadView();
    updateDistrict();
    if (BNLocationManagerProxy.getInstance().isLocationValid()) {}
    clearLastResult();
    boolean bool;
    if (this.isSpaceSearchMode)
    {
      this.mCurrentGeoPoint = BNLocationManagerProxy.getInstance().getLastValidLocation();
      bool = SearchStrategyHelper.getInstance(getContext()).hasDataDownloadedByPoint(this.mCurrentGeoPoint);
      if (!bool) {
        break label241;
      }
      this.sugNetMode = 0;
      label66:
      this.sugNetMode = getFinalNetMode(this.sugNetMode);
      BNPoiSearcher.getInstance().setNetMode(BNSettingManager.getPrefSearchMode());
      BNPoiSearcher.getInstance().initInputSug(this.mDistrictInfo);
      if (NavMapManager.getInstance().getNaviMapMode() == 5)
      {
        com.baidu.baidumaps.f.a.a.a.a().e();
        com.baidu.baidumaps.f.a.a.a.a().g();
        NavMapManager.getInstance().handleMapOverlays(0);
        NavMapManager.getInstance().setNaviMapMode(0);
        NavMapManager.getInstance().showCarResultLayer(false);
      }
      if ((this.oldNode == null) && ((getHomeAddress() != null) || (getCompanyAddress() != null)) && (this.newBundle != null) && (this.newBundle.getInt("from_Fragment") == 49))
      {
        this.newBundle = null;
        this.mShowBundle = this.oldBundle;
        getBundle();
      }
      if (!TextUtils.isEmpty(this.mSearchKey)) {
        break label249;
      }
    }
    label241:
    label249:
    for (this.canSugShow = false;; this.canSugShow = true)
    {
      updateListView();
      i.b("CarModeQuickRoutePlanFragment");
      return;
      bool = SearchStrategyHelper.getInstance(getContext()).hasDataDownloadedBySet();
      break;
      this.sugNetMode = 1;
      break label66;
    }
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean)
  {
    if (this.mBackBtn != null) {
      this.mBackBtn.setBackground(com.baidu.carlife.view.a.b.a(getContext()));
    }
  }
  
  public void reAddEditTextView()
  {
    if (!com.baidu.carlife.core.b.a.a()) {}
    do
    {
      do
      {
        return;
      } while ((this.mEditTextContentLayout == null) || (this.mSearchEditText == null) || (this.mSearchKey == null));
      localObject1 = LayoutInflater.from(mActivity).inflate(2130968994, null);
      localObject2 = new LinearLayout.LayoutParams(-1, ScreenUtil.getInstance().dip2px(48));
      this.mEditTextContentLayout.removeAllViews();
      this.mEditTextContentLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    } while (this.mSearchEditText == null);
    this.mSearchEditText.setEnabled(false);
    this.mSearchEditText = ((KeyboardEditText)((View)localObject1).findViewById(2131624531));
    this.mSearchEditText.setEnabled(true);
    this.mSearchEditText.addTextChangedListener(getTextChangedListener());
    this.mSearchEditText.setOnEditorActionListener(getOnEditorActionListener());
    Object localObject1 = this.mSearchEditText;
    Object localObject2 = com.baidu.carlife.view.a.a();
    localObject2.getClass();
    ((KeyboardEditText)localObject1).setOnTouchListener(new a.a((com.baidu.carlife.view.a)localObject2, this.mSearchEditText, 3, this, getFocusChangeListener()));
    try
    {
      if (!this.mSearchKey.isEmpty()) {
        this.mSearchEditText.getEditableText().append(this.mSearchKey);
      }
      com.baidu.carlife.view.a.a().a(this.mSearchEditText);
      this.mFocusAreaTop = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  protected void showSoftInputMethod()
  {
    ((InputMethodManager)mActivity.getSystemService("input_method")).toggleSoftInput(0, 2);
  }
  
  public void showToast(int paramInt)
  {
    TipTool.onCreateToastDialog(getContext(), StyleManager.getString(paramInt));
  }
  
  public void showTwoBtnDialog(int paramInt, com.baidu.carlife.core.screen.b paramb1, com.baidu.carlife.core.screen.b paramb2)
  {
    dismissTwoBtnDialog();
    if (this.mAlertDlg == null)
    {
      this.mAlertDlg = new com.baidu.carlife.view.dialog.g(mActivity).a(paramInt).g(17).c(2131296259).r().d(2131296733);
      this.mAlertDlg.a(paramb2);
      this.mAlertDlg.b(paramb1);
    }
    showDialog(this.mAlertDlg);
  }
  
  public void speedOverForbidSoftKeyboardInput()
  {
    if (!com.baidu.carlife.logic.g.a().c()) {}
    while (this.mFocusAreaTop == null) {
      return;
    }
    d.a().b(new com.baidu.carlife.f.a[] { this.mFocusAreaTop, this.mFocusList });
    this.mFocusAreaTop.c(this.mBackBtn);
    d.a().h(this.mFocusAreaTop);
  }
  
  public void stopDriving() {}
  
  public void updateListView()
  {
    this.searchHeadItemView.setVisibility(0);
    if ((!this.isShowHeader) || (this.canSugShow)) {
      this.mListView.removeHeaderView(this.mHeaderView);
    }
    if ((this.isShowHeader) && (this.mListView.getHeaderViewsCount() == 0) && (!this.canSugShow)) {
      this.mListView.addHeaderView(this.mHeaderView);
    }
    if (this.isShowHeader) {
      this.searchHeadItemView.setVisibility(8);
    }
    if ((this.mListView.getAdapter() instanceof HeaderViewListAdapter)) {
      this.mListView.removeFooterView(this.mFooterView);
    }
    this.mDataList.clear();
    if (TextUtils.isEmpty(this.mSearchKey)) {}
    Object localObject1;
    int i;
    Object localObject2;
    for (String str1 = "";; str1 = this.mSearchKey.replaceAll("\\s*", ""))
    {
      localObject1 = SearchNameHistroyModel.getInstance().mSearchNameDBObjects;
      if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
        break label281;
      }
      i = 0;
      while ((i < 10) && (i < ((List)localObject1).size()))
      {
        localObject2 = (SearchNameDBObject)((List)localObject1).get(i);
        if ((TextUtils.isEmpty(str1)) || ((!TextUtils.isEmpty(str1)) && (((SearchNameDBObject)localObject2).getName().contains(str1)))) {
          this.mDataList.add(new NameSearchAdapter.NameSearchEntity(((SearchNameDBObject)localObject2).getName(), "", NameSearchAdapter.NameSearchEntity.Type.HISTORY, ((SearchNameDBObject)localObject2).getId()));
        }
        i += 1;
      }
    }
    if (!this.canSugShow) {
      this.mListView.addFooterView(this.mFooterView);
    }
    label281:
    if (this.canSugShow)
    {
      this.searchHeadItemView.setVisibility(8);
      localObject2 = (PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel");
      localObject1 = this.mSugDataList;
      if (localObject2 == null) {
        break label516;
      }
    }
    for (;;)
    {
      try
      {
        this.mSugDataList.clear();
        this.mSugDataList.addAll(((PoiSearchModel)localObject2).getSugList());
      }
      finally {}
      if (i < this.mSugDataList.size())
      {
        if (this.mSugDataList.get(i) != null) {
          this.mDataList.add(new NameSearchAdapter.NameSearchEntity(((SearchSugData)this.mSugDataList.get(i)).getName(), ((SearchSugData)this.mSugDataList.get(i)).getAddress(), NameSearchAdapter.NameSearchEntity.Type.SUG));
        }
      }
      else
      {
        this.mDataList.addAll(getFavDataFromDB(this.mSearchKey));
        if (this.mDataAdapter == null)
        {
          this.mDataAdapter = new NameSearchAdapter(getContext(), this.mDataList, str2);
          this.mListView.setAdapter(this.mDataAdapter);
        }
        for (;;)
        {
          initFocusChain(this.mViewGroup);
          return;
          this.mDataAdapter.setData(this.mDataList, str2);
          this.mDataAdapter.notifyDataSetChanged();
        }
        label516:
        i = 0;
        continue;
      }
      i += 1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/carmode/CarModeQuickRoutePlanFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */