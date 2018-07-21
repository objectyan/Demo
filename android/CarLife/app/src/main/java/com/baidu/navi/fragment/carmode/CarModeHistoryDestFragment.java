package com.baidu.navi.fragment.carmode;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.f.a;
import com.baidu.carlife.f.c;
import com.baidu.carlife.f.d;
import com.baidu.carlife.f.g;
import com.baidu.navi.adapter.HistoryDestinationAdapter;
import com.baidu.navi.controller.QuickFragmentListener;
import com.baidu.navi.controller.QuickRoutePlanController;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.utils.StatisticUtils;
import com.baidu.navi.view.CommonTitleBar;
import com.baidu.navi.view.TravelRefListener;
import com.baidu.navi.view.pulltorefresh.PullToRefreshListView;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.logic.BNLocationManagerProxy;
import java.util.ArrayList;

public class CarModeHistoryDestFragment
  extends ContentFragment
{
  private ImageView mBackImg;
  private View mCleanHistoryLayout;
  private TextView mCleanText;
  private g mFocusAreaUp;
  private c mFocusList;
  private QuickRoutePlanController mFragControl;
  private QuickFragmentListener mFragListener = new QuickFragmentListener()
  {
    public void onRefreshHistoryList()
    {
      CarModeHistoryDestFragment.this.mHistoryAdapter.notifyHistoryDataSetChanged();
    }
    
    public void showSetCompAddrDialog() {}
    
    public void showSetHomeAddrDialog() {}
    
    public void showToast(int paramAnonymousInt) {}
  };
  private HistoryDestinationAdapter mHistoryAdapter;
  private View mHistoryListLayout;
  private ListView mHistoryListView;
  private PullToRefreshListView mPullToRefeshListView;
  private CommonTitleBar mTitleBar;
  private TravelRefListener mTravelListener = new TravelRefListener()
  {
    public void onAddOrDeleteSuccess()
    {
      if (CarModeHistoryDestFragment.this.mViewGroup != null) {
        CarModeHistoryDestFragment.this.initFocusChain(CarModeHistoryDestFragment.this.mViewGroup);
      }
    }
    
    public void onEnterTravelRefFragment(int paramAnonymousInt, boolean paramAnonymousBoolean)
    {
      RoutePlanNode localRoutePlanNode1 = BNLocationManagerProxy.getInstance().getCurLocationNode();
      if ((localRoutePlanNode1 == null) || (!localRoutePlanNode1.isNodeSettedData()))
      {
        TipTool.onCreateToastDialog(CarModeHistoryDestFragment.this.getContext(), StyleManager.getString(2131297228));
        return;
      }
      RoutePlanNode localRoutePlanNode2 = CarModeHistoryDestFragment.this.mHistoryAdapter.getDate(paramAnonymousInt);
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localRoutePlanNode1);
      localArrayList.add(localRoutePlanNode2);
      new Bundle().putInt("from_Fragment", 49);
    }
  };
  private ViewGroup mViewGroup;
  
  private View.OnClickListener getLeftOnClickListener()
  {
    new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CarModeHistoryDestFragment.this.back(null);
      }
    };
  }
  
  private void setTitleBarLeftBack(LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = (LinearLayout)paramLayoutInflater.inflate(2130968637, null);
    this.mBackImg = ((ImageView)paramLayoutInflater.findViewById(2131624118));
    this.mBackImg.setOnClickListener(getLeftOnClickListener());
    this.mTitleBar.findViewById(2131624283).setVisibility(0);
    this.mTitleBar.setRightContenVisible(false);
    this.mTitleBar.setLeftContent(paramLayoutInflater);
  }
  
  public void findViews()
  {
    this.mTitleBar = ((CommonTitleBar)this.mViewGroup.findViewById(2131624354));
    setTitleBarLeftBack(mActivity.getLayoutInflater());
    this.mPullToRefeshListView = ((PullToRefreshListView)this.mViewGroup.findViewById(2131624356));
    this.mHistoryListView = ((ListView)this.mPullToRefeshListView.getRefreshableView());
    this.mCleanText = ((TextView)this.mCleanHistoryLayout.findViewById(2131624297));
    this.mCleanText.setText(2131296896);
  }
  
  public void initFocusChain(View paramView)
  {
    if (this.mFocusAreaUp == null)
    {
      this.mFocusAreaUp = new g(paramView.findViewById(2131624354), 2);
      this.mFocusAreaUp.d(this.mBackImg);
    }
    if (this.mFocusList == null) {
      this.mFocusList = new c(this.mHistoryListView, 6);
    }
    if ((this.mHistoryAdapter != null) && (this.mHistoryAdapter.getCount() == 0))
    {
      d.a().b(new a[] { this.mFocusAreaUp });
      d.a().h(this.mFocusAreaUp);
    }
    do
    {
      return;
      d.a().b(new a[] { this.mFocusAreaUp, this.mFocusList });
    } while (this.mHistoryListView == null);
    this.mHistoryListView.requestFocus();
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.mFragControl = new QuickRoutePlanController(mActivity, this.mFragListener, getNaviFragmentManager(), this);
    this.mHistoryAdapter = new HistoryDestinationAdapter(mActivity, false, this.mTravelListener, this.mFragControl);
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2130968653, null));
    this.mCleanHistoryLayout = paramLayoutInflater.inflate(2130968642, null);
    findViews();
    return this.mViewGroup;
  }
  
  public void onInitFocusAreas()
  {
    super.onInitFocusAreas();
    initFocusChain(this.mViewGroup);
  }
  
  protected void onInitView()
  {
    setupViews();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.mHistoryAdapter.setCarMode(true);
    this.mHistoryAdapter.notifyHistoryDataSetChanged();
    if ((this.mViewGroup != null) && (getCurrentFragmentType() == 304)) {
      initFocusChain(this.mViewGroup);
    }
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public void setupViews()
  {
    this.mHistoryListView.addFooterView(this.mCleanHistoryLayout);
    this.mHistoryAdapter.setListView(this.mHistoryListView);
    this.mHistoryListView.setAdapter(this.mHistoryAdapter);
    this.mHistoryListView.setItemsCanFocus(true);
    this.mHistoryAdapter.setCleanHistoryLayout(this.mCleanHistoryLayout);
    this.mCleanHistoryLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CarModeHistoryDestFragment.this.mHistoryAdapter.showCleanAllHistoryDialog();
        StatisticManager.onEvent("410042", "410042");
      }
    });
    this.mHistoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (ForbidDaulClickUtils.isFastDoubleClick()) {
          return;
        }
        if (paramAnonymousView.findViewById(2131624297) != null)
        {
          CarModeHistoryDestFragment.this.mHistoryAdapter.showCleanAllHistoryDialog();
          StatisticManager.onEvent("410042", "410042");
          return;
        }
        paramAnonymousAdapterView = CarModeHistoryDestFragment.this.mHistoryAdapter.getDate(paramAnonymousInt - 1);
        CarModeHistoryDestFragment.this.mFragControl.startRoutePlan(paramAnonymousAdapterView);
        StatisticUtils.statSetDestFromHistory();
        StatisticManager.onEvent("410040", "410040");
      }
    });
    this.mHistoryListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener()
    {
      public boolean onItemLongClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (ForbidDaulClickUtils.isFastDoubleClick()) {
          return false;
        }
        if (paramAnonymousView.findViewById(2131624297) != null) {
          return true;
        }
        CarModeHistoryDestFragment.this.mHistoryAdapter.getDate(paramAnonymousInt - 1);
        CarModeHistoryDestFragment.this.mHistoryAdapter.showDelHistoryItemDialog(paramAnonymousInt - 1);
        return false;
      }
    });
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/carmode/CarModeHistoryDestFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */