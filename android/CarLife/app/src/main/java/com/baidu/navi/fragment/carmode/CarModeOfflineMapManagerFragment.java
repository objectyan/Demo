package com.baidu.navi.fragment.carmode;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseExpandableListAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.baidumaps.base.localmap.f;
import com.baidu.carlife.core.i;
import com.baidu.carlife.f.a;
import com.baidu.carlife.view.SwitchButton;
import com.baidu.mapframework.common.config.GlobalConfig;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.view.RoundProgressBar;
import com.baidu.platform.comapi.map.LocalMapResource;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class CarModeOfflineMapManagerFragment
  extends ContentFragment
  implements Observer
{
  private ImageButton mBtnBack;
  private ImageButton mBtnEdit;
  private SwitchButton mBtnSwitch;
  private CityListAdapter mCityListAdapter;
  private ExpandableListView mElvOfflineMapData;
  private TextView mFinish;
  private com.baidu.carlife.f.c mFocusListView;
  private com.baidu.carlife.f.g mFocusUp;
  private View mFooterView;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private View mHeaderView;
  private boolean mIsEditable = false;
  private View.OnKeyListener mOnKeyListener = new View.OnKeyListener()
  {
    public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 0))
      {
        if ((CarModeOfflineMapManagerFragment.CityListAdapter.access$1000(CarModeOfflineMapManagerFragment.this.mCityListAdapter) != null) && (CarModeOfflineMapManagerFragment.CityListAdapter.access$1000(CarModeOfflineMapManagerFragment.this.mCityListAdapter).size() > 0) && (CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.getSelectedItemPosition() == -1L))
        {
          CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.setSelection(0);
          return true;
        }
        switch (paramAnonymousInt)
        {
        }
      }
      long l;
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
                  return false;
                } while ((CarModeOfflineMapManagerFragment.CityListAdapter.access$1000(CarModeOfflineMapManagerFragment.this.mCityListAdapter) == null) || (CarModeOfflineMapManagerFragment.CityListAdapter.access$1000(CarModeOfflineMapManagerFragment.this.mCityListAdapter).size() <= 0));
                l = CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.getSelectedItemPosition();
                if (CarModeOfflineMapManagerFragment.CityListAdapter.access$1100(CarModeOfflineMapManagerFragment.this.mCityListAdapter) == null) {
                  break;
                }
              } while (l != CarModeOfflineMapManagerFragment.CityListAdapter.access$1100(CarModeOfflineMapManagerFragment.this.mCityListAdapter).size() + 2);
              CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.onKeyDown(19, paramAnonymousKeyEvent);
              CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.onKeyDown(19, paramAnonymousKeyEvent);
              return true;
            } while (l != 2L);
            CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.onKeyDown(19, paramAnonymousKeyEvent);
            CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.onKeyDown(19, paramAnonymousKeyEvent);
            return true;
          } while ((CarModeOfflineMapManagerFragment.CityListAdapter.access$1000(CarModeOfflineMapManagerFragment.this.mCityListAdapter) == null) || (CarModeOfflineMapManagerFragment.CityListAdapter.access$1000(CarModeOfflineMapManagerFragment.this.mCityListAdapter).size() <= 0));
          l = CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.getSelectedItemPosition();
          if (CarModeOfflineMapManagerFragment.CityListAdapter.access$1100(CarModeOfflineMapManagerFragment.this.mCityListAdapter) == null) {
            break;
          }
        } while (l != CarModeOfflineMapManagerFragment.CityListAdapter.access$1100(CarModeOfflineMapManagerFragment.this.mCityListAdapter).size());
        CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.onKeyDown(20, paramAnonymousKeyEvent);
        CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.onKeyDown(20, paramAnonymousKeyEvent);
        return true;
      } while (l != 0L);
      CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.onKeyDown(20, paramAnonymousKeyEvent);
      CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.onKeyDown(20, paramAnonymousKeyEvent);
      return true;
    }
  };
  private View.OnKeyListener mUpKeyListener = new View.OnKeyListener()
  {
    public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 0)) {}
      switch (paramAnonymousInt)
      {
      default: 
        return false;
      }
      CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.requestFocus();
      CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.setSelection(0);
      return true;
    }
  };
  private ViewGroup mViewGroup;
  private Object sync = new Object();
  
  private void bindEvents()
  {
    this.mBtnBack.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (CarModeOfflineMapManagerFragment.this.mIsEditable)
        {
          CarModeOfflineMapManagerFragment.this.quiteEditMode();
          return;
        }
        CarModeOfflineMapManagerFragment.this.pageBack(CarModeOfflineMapManagerFragment.this.mModuleFrom);
      }
    });
    this.mBtnEdit.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CarModeOfflineMapManagerFragment.access$102(CarModeOfflineMapManagerFragment.this, true);
        CarModeOfflineMapManagerFragment.this.updateEditBtn();
      }
    });
    this.mFinish.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CarModeOfflineMapManagerFragment.this.quiteEditMode();
      }
    });
    this.mElvOfflineMapData.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if ((CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.getHeaderViewsCount() == 1) && (paramAnonymousInt == 0)) {
          CarModeOfflineMapManagerFragment.this.showFragment(555, null);
        }
        while (CarModeOfflineMapManagerFragment.this.mElvOfflineMapData.getFooterViewsCount() != 1) {
          return;
        }
        CarModeOfflineMapManagerFragment.this.mBtnSwitch.toggle();
      }
    });
    this.mBtnSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        if (!paramAnonymousBoolean)
        {
          GlobalConfig.getInstance().setIsAutoDownload(false);
          return;
        }
        GlobalConfig.getInstance().setIsAutoDownload(true);
      }
    });
    if (GlobalConfig.getInstance().isAutoDownload()) {
      this.mBtnSwitch.setChecked(true);
    }
    for (;;)
    {
      this.mElvOfflineMapData.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
      {
        public boolean onGroupClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
        {
          paramAnonymousExpandableListView = paramAnonymousView.getTag(2131623940);
          if (LocalMapResource.class.isInstance(paramAnonymousExpandableListView))
          {
            paramAnonymousExpandableListView = (LocalMapResource)paramAnonymousExpandableListView;
            if (paramAnonymousExpandableListView != null)
            {
              if (!CarModeOfflineMapManagerFragment.this.mIsEditable) {
                break label48;
              }
              CarModeOfflineMapManagerFragment.CityListAdapter.access$800(CarModeOfflineMapManagerFragment.this.mCityListAdapter, paramAnonymousExpandableListView);
            }
          }
          for (;;)
          {
            return false;
            label48:
            CarModeOfflineMapManagerFragment.CityListAdapter.access$900(CarModeOfflineMapManagerFragment.this.mCityListAdapter, paramAnonymousExpandableListView);
          }
        }
      });
      return;
      this.mBtnSwitch.setChecked(false);
    }
  }
  
  private void initData()
  {
    f.a().addObserver(this);
  }
  
  private void initview()
  {
    this.mBtnBack = ((ImageButton)this.mViewGroup.findViewById(2131624258));
    setCommonTitleBar(this.mViewGroup, StyleManager.getString(2131296343));
    this.mBtnEdit = ((ImageButton)this.mViewGroup.findViewById(2131624264));
    this.mBtnEdit.setBackground(com.baidu.carlife.view.a.b.a(mActivity));
    this.mBtnEdit.setVisibility(0);
    this.mFinish = ((TextView)this.mViewGroup.findViewById(2131624265));
    this.mFinish.setBackground(com.baidu.carlife.view.a.b.a(mActivity));
    this.mFinish.setTextColor(StyleManager.getColor(2131558646));
    this.mElvOfflineMapData = ((ExpandableListView)this.mViewGroup.findViewById(2131624134));
    this.mCityListAdapter = new CityListAdapter(getNaviActivity(), null);
    this.mElvOfflineMapData.addHeaderView(this.mHeaderView);
    this.mElvOfflineMapData.addFooterView(this.mFooterView);
    this.mElvOfflineMapData.setAdapter(this.mCityListAdapter);
    this.mBtnSwitch = ((SwitchButton)this.mFooterView.findViewById(2131624581));
  }
  
  private void quiteEditMode()
  {
    this.mIsEditable = false;
    updateEditBtn();
  }
  
  private void updateEditBtn()
  {
    if (this.mIsEditable)
    {
      this.mFinish.setVisibility(0);
      this.mBtnEdit.setVisibility(8);
    }
    for (;;)
    {
      this.mCityListAdapter.notifyDataSetChanged();
      return;
      this.mBtnEdit.setVisibility(0);
      this.mFinish.setVisibility(8);
    }
  }
  
  public void driving()
  {
    i.b("yftech", "CarModeOfflineMapManagerFragment driving");
    if (com.baidu.carlife.custom.b.a().b())
    {
      back();
      back();
    }
  }
  
  public boolean onBackPressed()
  {
    if (this.mIsEditable) {
      quiteEditMode();
    }
    for (;;)
    {
      return true;
      pageBack(this.mModuleFrom);
    }
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2130968613, null));
    this.mHeaderView = paramLayoutInflater.inflate(2130968681, null);
    this.mFooterView = paramLayoutInflater.inflate(2130968682, null);
    initview();
    bindEvents();
    initData();
    return this.mViewGroup;
  }
  
  public void onDestroy()
  {
    try
    {
      if (this.mHandler != null)
      {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
      }
      f.a().deleteObserver(this);
      return;
    }
    finally
    {
      super.onDestroy();
    }
  }
  
  public void onInitFocusAreas()
  {
    super.onInitFocusAreas();
    if (this.mFocusUp == null)
    {
      this.mFocusUp = new com.baidu.carlife.f.g(this.mViewGroup.findViewById(2131624135), 2);
      this.mFocusUp.d(this.mViewGroup.findViewById(2131624258)).d(this.mViewGroup.findViewById(2131624264)).d(this.mViewGroup.findViewById(2131624265));
      this.mFocusUp.a(this.mUpKeyListener);
    }
    if (this.mFocusListView == null)
    {
      this.mFocusListView = new com.baidu.carlife.f.c(this.mElvOfflineMapData, 4);
      this.mFocusListView.a(this.mOnKeyListener);
    }
    com.baidu.carlife.f.d.a().b(new a[] { this.mFocusUp, this.mFocusListView });
    com.baidu.carlife.f.d.a().h(this.mFocusUp);
  }
  
  protected void onInitView() {}
  
  public void onPause()
  {
    super.onPause();
    com.baidu.baidumaps.base.localmap.d.a(getView());
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (this.mHandler != null) {
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          if (CarModeOfflineMapManagerFragment.this.mCityListAdapter != null)
          {
            CarModeOfflineMapManagerFragment.CityListAdapter.access$1200(CarModeOfflineMapManagerFragment.this.mCityListAdapter);
            CarModeOfflineMapManagerFragment.this.mCityListAdapter.notifyDataSetChanged();
          }
        }
      });
    }
  }
  
  private class CityListAdapter
    extends BaseExpandableListAdapter
    implements View.OnClickListener
  {
    private static final int CHILD_TYPE_CITY = 0;
    private static final int CHILD_TYPE_EXPAND_CITY = 1;
    private static final int GROUP_TYPE_CITY = 2;
    private static final int GROUP_TYPE_PROVINCE = 1;
    private static final int GROUP_TYPE_TITLE = 0;
    private List currentData;
    private List<LocalMapResource> downloadResources;
    private List<LocalMapResource> finishedResources;
    private final LayoutInflater inflater;
    
    private CityListAdapter(Activity paramActivity)
    {
      this.inflater = paramActivity.getLayoutInflater();
      reloadData();
    }
    
    private void delete(final LocalMapResource paramLocalMapResource)
    {
      FragmentActivity localFragmentActivity = CarModeOfflineMapManagerFragment.this.getActivity();
      if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {
        return;
      }
      paramLocalMapResource = new com.baidu.carlife.view.dialog.c(localFragmentActivity).b(StyleManager.getString(2131296338)).d(StyleManager.getString(2131296337)).e(StyleManager.getString(2131296331)).r().a(new com.baidu.carlife.core.screen.b()
      {
        public void onClick()
        {
          f.a().f(paramLocalMapResource.id);
          CarModeOfflineMapManagerFragment.CityListAdapter.this.reloadData();
          CarModeOfflineMapManagerFragment.CityListAdapter.this.notifyDataSetChanged();
        }
      });
      com.baidu.carlife.core.screen.presentation.a.g.a().showDialog(paramLocalMapResource);
    }
    
    private void download(final LocalMapResource paramLocalMapResource)
    {
      if ((com.baidu.baidumaps.base.localmap.d.a(paramLocalMapResource)) || (com.baidu.baidumaps.base.localmap.d.b(paramLocalMapResource))) {
        if (paramLocalMapResource.downloadStatus != 10) {}
      }
      while ((com.baidu.baidumaps.base.localmap.d.d(paramLocalMapResource)) && (!com.baidu.baidumaps.base.localmap.d.g(paramLocalMapResource)))
      {
        return;
        f.a().d(paramLocalMapResource.id);
        return;
      }
      com.baidu.baidumaps.base.localmap.d.a(CarModeOfflineMapManagerFragment.this.getActivity(), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          if ((com.baidu.baidumaps.base.localmap.d.g(paramLocalMapResource)) || (com.baidu.baidumaps.base.localmap.d.f(paramLocalMapResource))) {
            f.a().g(paramLocalMapResource.id);
          }
          do
          {
            return;
            if (com.baidu.baidumaps.base.localmap.d.c(paramLocalMapResource))
            {
              f.a().b(paramLocalMapResource.id);
              return;
            }
            if (com.baidu.baidumaps.base.localmap.d.e(paramLocalMapResource))
            {
              f.a().g(paramLocalMapResource.id);
              return;
            }
          } while (!com.baidu.baidumaps.base.localmap.d.h(paramLocalMapResource));
          f.a().a(paramLocalMapResource.id);
        }
      }, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
    }
    
    /* Error */
    private View getCityView(View paramView, ViewGroup paramViewGroup, LocalMapResource paramLocalMapResource, boolean paramBoolean)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 40	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter:this$0	Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment;
      //   4: invokestatic 168	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment:access$1800	(Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment;)Ljava/lang/Object;
      //   7: astore 11
      //   9: aload 11
      //   11: monitorenter
      //   12: aload_1
      //   13: ifnonnull +507 -> 520
      //   16: new 17	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder
      //   19: dup
      //   20: aload_0
      //   21: aconst_null
      //   22: invokespecial 171	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:<init>	(Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter;Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$1;)V
      //   25: astore_2
      //   26: aload_0
      //   27: getfield 51	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter:inflater	Landroid/view/LayoutInflater;
      //   30: ldc -84
      //   32: aconst_null
      //   33: invokevirtual 178	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
      //   36: astore_1
      //   37: aload_2
      //   38: aload_1
      //   39: ldc -77
      //   41: invokevirtual 185	android/view/View:findViewById	(I)Landroid/view/View;
      //   44: checkcast 187	android/widget/RelativeLayout
      //   47: putfield 191	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoLayout	Landroid/widget/RelativeLayout;
      //   50: aload_2
      //   51: aload_1
      //   52: ldc -64
      //   54: invokevirtual 185	android/view/View:findViewById	(I)Landroid/view/View;
      //   57: checkcast 187	android/widget/RelativeLayout
      //   60: putfield 195	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mStatusLayout	Landroid/widget/RelativeLayout;
      //   63: aload_2
      //   64: aload_1
      //   65: ldc -60
      //   67: invokevirtual 185	android/view/View:findViewById	(I)Landroid/view/View;
      //   70: checkcast 198	android/widget/TextView
      //   73: putfield 202	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mNameTV	Landroid/widget/TextView;
      //   76: aload_2
      //   77: aload_1
      //   78: ldc -53
      //   80: invokevirtual 185	android/view/View:findViewById	(I)Landroid/view/View;
      //   83: checkcast 198	android/widget/TextView
      //   86: putfield 206	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   89: aload_2
      //   90: aload_1
      //   91: ldc -49
      //   93: invokevirtual 185	android/view/View:findViewById	(I)Landroid/view/View;
      //   96: checkcast 198	android/widget/TextView
      //   99: putfield 210	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoHint	Landroid/widget/TextView;
      //   102: aload_2
      //   103: aload_1
      //   104: ldc -45
      //   106: invokevirtual 185	android/view/View:findViewById	(I)Landroid/view/View;
      //   109: checkcast 213	android/widget/ImageView
      //   112: putfield 217	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mTaskStatusIV	Landroid/widget/ImageView;
      //   115: aload_2
      //   116: aload_1
      //   117: ldc -38
      //   119: invokevirtual 185	android/view/View:findViewById	(I)Landroid/view/View;
      //   122: checkcast 213	android/widget/ImageView
      //   125: putfield 221	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mTaskDelete	Landroid/widget/ImageView;
      //   128: aload_2
      //   129: aload_1
      //   130: ldc -34
      //   132: invokevirtual 185	android/view/View:findViewById	(I)Landroid/view/View;
      //   135: putfield 226	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mListDivider	Landroid/view/View;
      //   138: aload_2
      //   139: aload_1
      //   140: ldc -29
      //   142: invokevirtual 185	android/view/View:findViewById	(I)Landroid/view/View;
      //   145: checkcast 229	com/baidu/navi/view/RoundProgressBar
      //   148: putfield 233	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mRoundProgressBarDownloading	Lcom/baidu/navi/view/RoundProgressBar;
      //   151: aload_1
      //   152: aload_2
      //   153: invokevirtual 237	android/view/View:setTag	(Ljava/lang/Object;)V
      //   156: aload_3
      //   157: ifnull +1198 -> 1355
      //   160: aload_2
      //   161: ifnull +1194 -> 1355
      //   164: aload_2
      //   165: getfield 202	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mNameTV	Landroid/widget/TextView;
      //   168: aload_3
      //   169: getfield 241	com/baidu/platform/comapi/map/LocalMapResource:name	Ljava/lang/String;
      //   172: invokevirtual 245	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   175: aload_2
      //   176: getfield 226	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mListDivider	Landroid/view/View;
      //   179: bipush 8
      //   181: invokevirtual 249	android/view/View:setVisibility	(I)V
      //   184: aload_2
      //   185: getfield 233	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mRoundProgressBarDownloading	Lcom/baidu/navi/view/RoundProgressBar;
      //   188: bipush 8
      //   190: invokevirtual 250	com/baidu/navi/view/RoundProgressBar:setVisibility	(I)V
      //   193: aload_2
      //   194: getfield 217	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mTaskStatusIV	Landroid/widget/ImageView;
      //   197: bipush 8
      //   199: invokevirtual 251	android/widget/ImageView:setVisibility	(I)V
      //   202: aload_2
      //   203: getfield 195	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mStatusLayout	Landroid/widget/RelativeLayout;
      //   206: bipush 8
      //   208: invokevirtual 252	android/widget/RelativeLayout:setVisibility	(I)V
      //   211: aload_2
      //   212: aload_3
      //   213: invokestatic 256	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:access$1702	(Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder;Lcom/baidu/platform/comapi/map/LocalMapResource;)Lcom/baidu/platform/comapi/map/LocalMapResource;
      //   216: pop
      //   217: aload_3
      //   218: getfield 148	com/baidu/platform/comapi/map/LocalMapResource:id	I
      //   221: iconst_1
      //   222: if_icmpne +309 -> 531
      //   225: aload_2
      //   226: getfield 210	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoHint	Landroid/widget/TextView;
      //   229: ldc_w 257
      //   232: invokestatic 97	com/baidu/navi/style/StyleManager:getString	(I)Ljava/lang/String;
      //   235: invokevirtual 245	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   238: aload_2
      //   239: getfield 210	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoHint	Landroid/widget/TextView;
      //   242: iconst_0
      //   243: invokevirtual 258	android/widget/TextView:setVisibility	(I)V
      //   246: aload_2
      //   247: getfield 206	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   250: ldc_w 259
      //   253: invokestatic 263	com/baidu/navi/style/StyleManager:getColor	(I)I
      //   256: invokevirtual 266	android/widget/TextView:setTextColor	(I)V
      //   259: aload_3
      //   260: astore 10
      //   262: aload_3
      //   263: getfield 269	com/baidu/platform/comapi/map/LocalMapResource:type	I
      //   266: iconst_1
      //   267: if_icmpeq +15 -> 282
      //   270: invokestatic 145	com/baidu/baidumaps/base/localmap/f:a	()Lcom/baidu/baidumaps/base/localmap/f;
      //   273: aload_3
      //   274: getfield 148	com/baidu/platform/comapi/map/LocalMapResource:id	I
      //   277: invokevirtual 273	com/baidu/baidumaps/base/localmap/f:h	(I)Lcom/baidu/platform/comapi/map/LocalMapResource;
      //   280: astore 10
      //   282: aload 10
      //   284: ifnull +1009 -> 1293
      //   287: aload 10
      //   289: getfield 276	com/baidu/platform/comapi/map/LocalMapResource:downloadProgress	I
      //   292: i2f
      //   293: ldc_w 277
      //   296: fdiv
      //   297: fstore 5
      //   299: aload_2
      //   300: invokestatic 281	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:access$1700	(Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder;)Lcom/baidu/platform/comapi/map/LocalMapResource;
      //   303: getfield 285	com/baidu/platform/comapi/map/LocalMapResource:mapsize	J
      //   306: aload_2
      //   307: invokestatic 281	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:access$1700	(Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder;)Lcom/baidu/platform/comapi/map/LocalMapResource;
      //   310: getfield 288	com/baidu/platform/comapi/map/LocalMapResource:searchsize	J
      //   313: ladd
      //   314: lstore 6
      //   316: lload 6
      //   318: l2f
      //   319: fconst_1
      //   320: fload 5
      //   322: fsub
      //   323: fmul
      //   324: f2l
      //   325: lstore 8
      //   327: aload 10
      //   329: invokestatic 133	com/baidu/baidumaps/base/localmap/d:a	(Lcom/baidu/platform/comapi/map/LocalMapResource;)Z
      //   332: ifeq +259 -> 591
      //   335: aload 10
      //   337: getfield 291	com/baidu/platform/comapi/map/LocalMapResource:version	I
      //   340: ifeq +208 -> 548
      //   343: aload_2
      //   344: getfield 206	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   347: new 293	java/lang/StringBuilder
      //   350: dup
      //   351: invokespecial 294	java/lang/StringBuilder:<init>	()V
      //   354: ldc_w 295
      //   357: invokestatic 97	com/baidu/navi/style/StyleManager:getString	(I)Ljava/lang/String;
      //   360: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   363: ldc_w 301
      //   366: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   369: lload 8
      //   371: invokestatic 304	com/baidu/baidumaps/base/localmap/d:a	(J)Ljava/lang/String;
      //   374: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   377: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   380: invokevirtual 245	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   383: aload_2
      //   384: getfield 217	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mTaskStatusIV	Landroid/widget/ImageView;
      //   387: ldc_w 309
      //   390: invokevirtual 312	android/widget/ImageView:setImageResource	(I)V
      //   393: aload_2
      //   394: getfield 217	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mTaskStatusIV	Landroid/widget/ImageView;
      //   397: iconst_0
      //   398: invokevirtual 251	android/widget/ImageView:setVisibility	(I)V
      //   401: aload_2
      //   402: getfield 233	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mRoundProgressBarDownloading	Lcom/baidu/navi/view/RoundProgressBar;
      //   405: aload 10
      //   407: getfield 276	com/baidu/platform/comapi/map/LocalMapResource:downloadProgress	I
      //   410: invokevirtual 315	com/baidu/navi/view/RoundProgressBar:setProgress	(I)V
      //   413: aload_2
      //   414: getfield 233	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mRoundProgressBarDownloading	Lcom/baidu/navi/view/RoundProgressBar;
      //   417: iconst_0
      //   418: invokevirtual 250	com/baidu/navi/view/RoundProgressBar:setVisibility	(I)V
      //   421: aload_2
      //   422: getfield 195	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mStatusLayout	Landroid/widget/RelativeLayout;
      //   425: iconst_0
      //   426: invokevirtual 252	android/widget/RelativeLayout:setVisibility	(I)V
      //   429: aload_2
      //   430: getfield 206	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   433: ldc_w 259
      //   436: invokestatic 263	com/baidu/navi/style/StyleManager:getColor	(I)I
      //   439: invokevirtual 266	android/widget/TextView:setTextColor	(I)V
      //   442: aload_2
      //   443: getfield 191	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoLayout	Landroid/widget/RelativeLayout;
      //   446: aload 10
      //   448: invokevirtual 316	android/widget/RelativeLayout:setTag	(Ljava/lang/Object;)V
      //   451: aload_1
      //   452: ldc_w 317
      //   455: aload 10
      //   457: invokevirtual 320	android/view/View:setTag	(ILjava/lang/Object;)V
      //   460: aload_0
      //   461: getfield 40	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter:this$0	Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment;
      //   464: invokestatic 324	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment:access$100	(Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment;)Z
      //   467: ifeq +876 -> 1343
      //   470: aload_2
      //   471: getfield 221	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mTaskDelete	Landroid/widget/ImageView;
      //   474: iconst_0
      //   475: invokevirtual 251	android/widget/ImageView:setVisibility	(I)V
      //   478: aload_2
      //   479: getfield 233	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mRoundProgressBarDownloading	Lcom/baidu/navi/view/RoundProgressBar;
      //   482: bipush 8
      //   484: invokevirtual 250	com/baidu/navi/view/RoundProgressBar:setVisibility	(I)V
      //   487: aload_2
      //   488: getfield 195	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mStatusLayout	Landroid/widget/RelativeLayout;
      //   491: bipush 8
      //   493: invokevirtual 252	android/widget/RelativeLayout:setVisibility	(I)V
      //   496: aload_2
      //   497: getfield 217	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mTaskStatusIV	Landroid/widget/ImageView;
      //   500: bipush 8
      //   502: invokevirtual 251	android/widget/ImageView:setVisibility	(I)V
      //   505: aload_2
      //   506: getfield 206	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   509: ldc_w 326
      //   512: invokevirtual 245	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   515: aload 11
      //   517: monitorexit
      //   518: aload_1
      //   519: areturn
      //   520: aload_1
      //   521: invokevirtual 330	android/view/View:getTag	()Ljava/lang/Object;
      //   524: checkcast 17	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder
      //   527: astore_2
      //   528: goto -372 -> 156
      //   531: aload_2
      //   532: getfield 210	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoHint	Landroid/widget/TextView;
      //   535: bipush 8
      //   537: invokevirtual 258	android/widget/TextView:setVisibility	(I)V
      //   540: goto -294 -> 246
      //   543: aload 11
      //   545: monitorexit
      //   546: aload_1
      //   547: athrow
      //   548: aload_2
      //   549: getfield 206	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   552: new 293	java/lang/StringBuilder
      //   555: dup
      //   556: invokespecial 294	java/lang/StringBuilder:<init>	()V
      //   559: ldc_w 331
      //   562: invokestatic 97	com/baidu/navi/style/StyleManager:getString	(I)Ljava/lang/String;
      //   565: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   568: ldc_w 301
      //   571: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   574: lload 8
      //   576: invokestatic 304	com/baidu/baidumaps/base/localmap/d:a	(J)Ljava/lang/String;
      //   579: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   582: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   585: invokevirtual 245	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   588: goto -205 -> 383
      //   591: aload 10
      //   593: invokestatic 135	com/baidu/baidumaps/base/localmap/d:b	(Lcom/baidu/platform/comapi/map/LocalMapResource;)Z
      //   596: ifeq +206 -> 802
      //   599: aload 10
      //   601: getfield 291	com/baidu/platform/comapi/map/LocalMapResource:version	I
      //   604: ifeq +155 -> 759
      //   607: aload_2
      //   608: getfield 206	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   611: new 293	java/lang/StringBuilder
      //   614: dup
      //   615: invokespecial 294	java/lang/StringBuilder:<init>	()V
      //   618: ldc_w 332
      //   621: invokestatic 97	com/baidu/navi/style/StyleManager:getString	(I)Ljava/lang/String;
      //   624: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   627: ldc_w 301
      //   630: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   633: lload 8
      //   635: invokestatic 304	com/baidu/baidumaps/base/localmap/d:a	(J)Ljava/lang/String;
      //   638: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   641: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   644: invokevirtual 245	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   647: aload_2
      //   648: getfield 217	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mTaskStatusIV	Landroid/widget/ImageView;
      //   651: ldc_w 309
      //   654: invokevirtual 312	android/widget/ImageView:setImageResource	(I)V
      //   657: aload_2
      //   658: getfield 217	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mTaskStatusIV	Landroid/widget/ImageView;
      //   661: iconst_0
      //   662: invokevirtual 251	android/widget/ImageView:setVisibility	(I)V
      //   665: aload_2
      //   666: getfield 206	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   669: ldc_w 333
      //   672: invokestatic 263	com/baidu/navi/style/StyleManager:getColor	(I)I
      //   675: invokevirtual 266	android/widget/TextView:setTextColor	(I)V
      //   678: aload_2
      //   679: getfield 233	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mRoundProgressBarDownloading	Lcom/baidu/navi/view/RoundProgressBar;
      //   682: aload 10
      //   684: getfield 276	com/baidu/platform/comapi/map/LocalMapResource:downloadProgress	I
      //   687: invokevirtual 315	com/baidu/navi/view/RoundProgressBar:setProgress	(I)V
      //   690: aload_2
      //   691: getfield 233	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mRoundProgressBarDownloading	Lcom/baidu/navi/view/RoundProgressBar;
      //   694: iconst_0
      //   695: invokevirtual 250	com/baidu/navi/view/RoundProgressBar:setVisibility	(I)V
      //   698: aload_2
      //   699: getfield 195	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mStatusLayout	Landroid/widget/RelativeLayout;
      //   702: iconst_0
      //   703: invokevirtual 252	android/widget/RelativeLayout:setVisibility	(I)V
      //   706: aload 10
      //   708: getfield 140	com/baidu/platform/comapi/map/LocalMapResource:downloadStatus	I
      //   711: bipush 10
      //   713: if_icmpne -271 -> 442
      //   716: aload_2
      //   717: getfield 206	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   720: ldc_w 334
      //   723: invokestatic 97	com/baidu/navi/style/StyleManager:getString	(I)Ljava/lang/String;
      //   726: invokevirtual 245	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   729: aload_2
      //   730: getfield 217	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mTaskStatusIV	Landroid/widget/ImageView;
      //   733: bipush 8
      //   735: invokevirtual 251	android/widget/ImageView:setVisibility	(I)V
      //   738: aload_2
      //   739: getfield 233	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mRoundProgressBarDownloading	Lcom/baidu/navi/view/RoundProgressBar;
      //   742: bipush 8
      //   744: invokevirtual 250	com/baidu/navi/view/RoundProgressBar:setVisibility	(I)V
      //   747: aload_2
      //   748: getfield 195	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mStatusLayout	Landroid/widget/RelativeLayout;
      //   751: bipush 8
      //   753: invokevirtual 252	android/widget/RelativeLayout:setVisibility	(I)V
      //   756: goto -314 -> 442
      //   759: aload_2
      //   760: getfield 206	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   763: new 293	java/lang/StringBuilder
      //   766: dup
      //   767: invokespecial 294	java/lang/StringBuilder:<init>	()V
      //   770: ldc_w 335
      //   773: invokestatic 97	com/baidu/navi/style/StyleManager:getString	(I)Ljava/lang/String;
      //   776: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   779: ldc_w 301
      //   782: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   785: lload 8
      //   787: invokestatic 304	com/baidu/baidumaps/base/localmap/d:a	(J)Ljava/lang/String;
      //   790: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   793: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   796: invokevirtual 245	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   799: goto -152 -> 647
      //   802: aload 10
      //   804: invokestatic 338	com/baidu/baidumaps/base/localmap/d:c	(Lcom/baidu/platform/comapi/map/LocalMapResource;)Z
      //   807: ifeq +176 -> 983
      //   810: aload 10
      //   812: getfield 140	com/baidu/platform/comapi/map/LocalMapResource:downloadStatus	I
      //   815: bipush 8
      //   817: if_icmpne +70 -> 887
      //   820: aload_0
      //   821: getfield 40	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter:this$0	Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment;
      //   824: invokevirtual 81	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
      //   827: invokestatic 344	com/baidu/platform/comapi/util/NetworkUtil:isWifiConnected	(Landroid/content/Context;)Z
      //   830: pop
      //   831: aload_2
      //   832: getfield 206	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   835: new 293	java/lang/StringBuilder
      //   838: dup
      //   839: invokespecial 294	java/lang/StringBuilder:<init>	()V
      //   842: ldc_w 345
      //   845: invokestatic 97	com/baidu/navi/style/StyleManager:getString	(I)Ljava/lang/String;
      //   848: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   851: ldc_w 301
      //   854: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   857: lload 8
      //   859: invokestatic 304	com/baidu/baidumaps/base/localmap/d:a	(J)Ljava/lang/String;
      //   862: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   865: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   868: invokevirtual 245	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   871: aload_2
      //   872: getfield 206	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   875: ldc_w 346
      //   878: invokestatic 263	com/baidu/navi/style/StyleManager:getColor	(I)I
      //   881: invokevirtual 266	android/widget/TextView:setTextColor	(I)V
      //   884: goto -442 -> 442
      //   887: aload 10
      //   889: getfield 140	com/baidu/platform/comapi/map/LocalMapResource:downloadStatus	I
      //   892: bipush 6
      //   894: if_icmpne +46 -> 940
      //   897: aload_2
      //   898: getfield 206	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   901: new 293	java/lang/StringBuilder
      //   904: dup
      //   905: invokespecial 294	java/lang/StringBuilder:<init>	()V
      //   908: ldc_w 347
      //   911: invokestatic 97	com/baidu/navi/style/StyleManager:getString	(I)Ljava/lang/String;
      //   914: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   917: ldc_w 301
      //   920: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   923: lload 8
      //   925: invokestatic 304	com/baidu/baidumaps/base/localmap/d:a	(J)Ljava/lang/String;
      //   928: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   931: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   934: invokevirtual 245	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   937: goto -66 -> 871
      //   940: aload_2
      //   941: getfield 206	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   944: new 293	java/lang/StringBuilder
      //   947: dup
      //   948: invokespecial 294	java/lang/StringBuilder:<init>	()V
      //   951: ldc_w 348
      //   954: invokestatic 97	com/baidu/navi/style/StyleManager:getString	(I)Ljava/lang/String;
      //   957: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   960: ldc_w 301
      //   963: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   966: lload 8
      //   968: invokestatic 304	com/baidu/baidumaps/base/localmap/d:a	(J)Ljava/lang/String;
      //   971: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   974: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   977: invokevirtual 245	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   980: goto -109 -> 871
      //   983: aload 10
      //   985: invokestatic 156	com/baidu/baidumaps/base/localmap/d:g	(Lcom/baidu/platform/comapi/map/LocalMapResource;)Z
      //   988: ifeq +220 -> 1208
      //   991: aload 10
      //   993: getfield 351	com/baidu/platform/comapi/map/LocalMapResource:mapoldsize	J
      //   996: aload 10
      //   998: getfield 354	com/baidu/platform/comapi/map/LocalMapResource:searcholdsize	J
      //   1001: ladd
      //   1002: invokestatic 304	com/baidu/baidumaps/base/localmap/d:a	(J)Ljava/lang/String;
      //   1005: pop
      //   1006: aload 10
      //   1008: getfield 357	com/baidu/platform/comapi/map/LocalMapResource:mappatchsize	J
      //   1011: aload 10
      //   1013: getfield 360	com/baidu/platform/comapi/map/LocalMapResource:searchpatchsize	J
      //   1016: ladd
      //   1017: invokestatic 304	com/baidu/baidumaps/base/localmap/d:a	(J)Ljava/lang/String;
      //   1020: astore_3
      //   1021: aload 10
      //   1023: invokestatic 363	com/baidu/baidumaps/base/localmap/d:j	(Lcom/baidu/platform/comapi/map/LocalMapResource;)Z
      //   1026: ifne +117 -> 1143
      //   1029: aload 10
      //   1031: getfield 140	com/baidu/platform/comapi/map/LocalMapResource:downloadStatus	I
      //   1034: bipush 9
      //   1036: if_icmpeq +66 -> 1102
      //   1039: aload 10
      //   1041: getfield 366	com/baidu/platform/comapi/map/LocalMapResource:updateStatus	I
      //   1044: iconst_4
      //   1045: if_icmpeq +57 -> 1102
      //   1048: new 293	java/lang/StringBuilder
      //   1051: dup
      //   1052: invokespecial 294	java/lang/StringBuilder:<init>	()V
      //   1055: ldc_w 367
      //   1058: invokestatic 97	com/baidu/navi/style/StyleManager:getString	(I)Ljava/lang/String;
      //   1061: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1064: ldc_w 301
      //   1067: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1070: aload_3
      //   1071: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1074: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1077: astore_3
      //   1078: aload_2
      //   1079: getfield 206	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   1082: aload_3
      //   1083: invokevirtual 245	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1086: aload_2
      //   1087: getfield 206	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   1090: ldc_w 333
      //   1093: invokestatic 263	com/baidu/navi/style/StyleManager:getColor	(I)I
      //   1096: invokevirtual 266	android/widget/TextView:setTextColor	(I)V
      //   1099: goto -657 -> 442
      //   1102: new 293	java/lang/StringBuilder
      //   1105: dup
      //   1106: invokespecial 294	java/lang/StringBuilder:<init>	()V
      //   1109: ldc_w 367
      //   1112: invokestatic 97	com/baidu/navi/style/StyleManager:getString	(I)Ljava/lang/String;
      //   1115: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1118: ldc_w 301
      //   1121: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1124: aload_3
      //   1125: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1128: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1131: astore_3
      //   1132: aload_2
      //   1133: getfield 206	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   1136: aload_3
      //   1137: invokevirtual 245	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1140: goto -54 -> 1086
      //   1143: aload 10
      //   1145: getfield 366	com/baidu/platform/comapi/map/LocalMapResource:updateStatus	I
      //   1148: iconst_4
      //   1149: if_icmpne +18 -> 1167
      //   1152: aload_2
      //   1153: getfield 206	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   1156: lload 6
      //   1158: invokestatic 304	com/baidu/baidumaps/base/localmap/d:a	(J)Ljava/lang/String;
      //   1161: invokevirtual 245	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1164: goto -78 -> 1086
      //   1167: new 293	java/lang/StringBuilder
      //   1170: dup
      //   1171: invokespecial 294	java/lang/StringBuilder:<init>	()V
      //   1174: ldc_w 367
      //   1177: invokestatic 97	com/baidu/navi/style/StyleManager:getString	(I)Ljava/lang/String;
      //   1180: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1183: ldc_w 301
      //   1186: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1189: aload_3
      //   1190: invokevirtual 299	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1193: invokevirtual 308	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1196: astore_3
      //   1197: aload_2
      //   1198: getfield 206	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   1201: aload_3
      //   1202: invokevirtual 245	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1205: goto -119 -> 1086
      //   1208: aload 10
      //   1210: invokestatic 370	com/baidu/baidumaps/base/localmap/d:f	(Lcom/baidu/platform/comapi/map/LocalMapResource;)Z
      //   1213: ifeq +44 -> 1257
      //   1216: aload_2
      //   1217: getfield 206	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   1220: lload 6
      //   1222: invokestatic 304	com/baidu/baidumaps/base/localmap/d:a	(J)Ljava/lang/String;
      //   1225: invokevirtual 245	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1228: aload_2
      //   1229: getfield 217	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mTaskStatusIV	Landroid/widget/ImageView;
      //   1232: ldc_w 371
      //   1235: invokevirtual 312	android/widget/ImageView:setImageResource	(I)V
      //   1238: aload_2
      //   1239: getfield 217	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mTaskStatusIV	Landroid/widget/ImageView;
      //   1242: iconst_0
      //   1243: invokevirtual 251	android/widget/ImageView:setVisibility	(I)V
      //   1246: aload_2
      //   1247: getfield 195	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mStatusLayout	Landroid/widget/RelativeLayout;
      //   1250: iconst_0
      //   1251: invokevirtual 252	android/widget/RelativeLayout:setVisibility	(I)V
      //   1254: goto -812 -> 442
      //   1257: aload 10
      //   1259: invokestatic 153	com/baidu/baidumaps/base/localmap/d:d	(Lcom/baidu/platform/comapi/map/LocalMapResource;)Z
      //   1262: ifeq +16 -> 1278
      //   1265: aload_2
      //   1266: getfield 206	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   1269: ldc_w 326
      //   1272: invokevirtual 245	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1275: goto -833 -> 442
      //   1278: aload_2
      //   1279: getfield 206	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   1282: lload 6
      //   1284: invokestatic 304	com/baidu/baidumaps/base/localmap/d:a	(J)Ljava/lang/String;
      //   1287: invokevirtual 245	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1290: goto -848 -> 442
      //   1293: aload_2
      //   1294: getfield 206	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   1297: aload_2
      //   1298: invokestatic 281	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:access$1700	(Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder;)Lcom/baidu/platform/comapi/map/LocalMapResource;
      //   1301: getfield 285	com/baidu/platform/comapi/map/LocalMapResource:mapsize	J
      //   1304: aload_2
      //   1305: invokestatic 281	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:access$1700	(Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder;)Lcom/baidu/platform/comapi/map/LocalMapResource;
      //   1308: getfield 288	com/baidu/platform/comapi/map/LocalMapResource:searchsize	J
      //   1311: ladd
      //   1312: invokestatic 304	com/baidu/baidumaps/base/localmap/d:a	(J)Ljava/lang/String;
      //   1315: invokevirtual 245	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1318: aload_2
      //   1319: getfield 191	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoLayout	Landroid/widget/RelativeLayout;
      //   1322: aload_2
      //   1323: invokestatic 281	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:access$1700	(Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder;)Lcom/baidu/platform/comapi/map/LocalMapResource;
      //   1326: invokevirtual 316	android/widget/RelativeLayout:setTag	(Ljava/lang/Object;)V
      //   1329: aload_1
      //   1330: ldc_w 317
      //   1333: aload_2
      //   1334: invokestatic 281	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:access$1700	(Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder;)Lcom/baidu/platform/comapi/map/LocalMapResource;
      //   1337: invokevirtual 320	android/view/View:setTag	(ILjava/lang/Object;)V
      //   1340: goto -880 -> 460
      //   1343: aload_2
      //   1344: getfield 221	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mTaskDelete	Landroid/widget/ImageView;
      //   1347: bipush 8
      //   1349: invokevirtual 251	android/widget/ImageView:setVisibility	(I)V
      //   1352: goto -837 -> 515
      //   1355: aload_2
      //   1356: getfield 226	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mListDivider	Landroid/view/View;
      //   1359: bipush 8
      //   1361: invokevirtual 249	android/view/View:setVisibility	(I)V
      //   1364: aload_2
      //   1365: getfield 191	com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment$CityListAdapter$Holder:mInfoLayout	Landroid/widget/RelativeLayout;
      //   1368: bipush 8
      //   1370: invokevirtual 252	android/widget/RelativeLayout:setVisibility	(I)V
      //   1373: goto -858 -> 515
      //   1376: astore_1
      //   1377: goto -834 -> 543
      //   1380: astore_1
      //   1381: goto -838 -> 543
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1384	0	this	CityListAdapter
      //   0	1384	1	paramView	View
      //   0	1384	2	paramViewGroup	ViewGroup
      //   0	1384	3	paramLocalMapResource	LocalMapResource
      //   0	1384	4	paramBoolean	boolean
      //   297	24	5	f	float
      //   314	969	6	l1	long
      //   325	642	8	l2	long
      //   260	998	10	localLocalMapResource	LocalMapResource
      //   7	537	11	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   26	156	1376	finally
      //   16	26	1380	finally
      //   164	246	1380	finally
      //   246	259	1380	finally
      //   262	282	1380	finally
      //   287	316	1380	finally
      //   327	383	1380	finally
      //   383	442	1380	finally
      //   442	460	1380	finally
      //   460	515	1380	finally
      //   515	518	1380	finally
      //   520	528	1380	finally
      //   531	540	1380	finally
      //   543	546	1380	finally
      //   548	588	1380	finally
      //   591	647	1380	finally
      //   647	756	1380	finally
      //   759	799	1380	finally
      //   802	871	1380	finally
      //   871	884	1380	finally
      //   887	937	1380	finally
      //   940	980	1380	finally
      //   983	1086	1380	finally
      //   1086	1099	1380	finally
      //   1102	1140	1380	finally
      //   1143	1164	1380	finally
      //   1167	1205	1380	finally
      //   1208	1254	1380	finally
      //   1257	1275	1380	finally
      //   1278	1290	1380	finally
      //   1293	1340	1380	finally
      //   1343	1352	1380	finally
      //   1355	1373	1380	finally
    }
    
    private View getGroupTitleView(View paramView, ViewGroup paramViewGroup, String paramString)
    {
      Holder localHolder;
      if (paramView == null)
      {
        localHolder = new Holder(null);
        paramView = this.inflater.inflate(2130968670, paramViewGroup, false);
        Holder.access$1402(localHolder, (TextView)paramView.findViewById(2131624533));
        localHolder.mListDivider = paramView.findViewById(2131624532);
        paramView.setTag(localHolder);
      }
      for (paramViewGroup = localHolder;; paramViewGroup = (Holder)paramView.getTag())
      {
        paramViewGroup.mListDivider.setVisibility(0);
        paramViewGroup.cityNameText.setText(paramString);
        return paramView;
      }
    }
    
    private View getProvinceView(View paramView, ViewGroup paramViewGroup, LocalMapResource paramLocalMapResource, boolean paramBoolean)
    {
      View localView = paramView;
      if (paramView == null)
      {
        localView = this.inflater.inflate(2130968981, paramViewGroup, false);
        paramView = new Holder(null);
        Holder.access$1402(paramView, (TextView)localView.findViewById(2131625558));
        Holder.access$1502(paramView, (TextView)localView.findViewById(2131625559));
        Holder.access$1602(paramView, (ImageView)localView.findViewById(2131625565));
        localView.setTag(paramView);
      }
      paramView = (Holder)localView.getTag();
      Holder.access$1702(paramView, paramLocalMapResource);
      paramView.cityNameText.setText(paramLocalMapResource.name);
      paramView = paramView.expandButton;
      if (paramBoolean) {}
      for (int i = 2130838724;; i = 2130839440)
      {
        paramView.setImageResource(i);
        com.baidu.baidumaps.base.localmap.d.k(paramLocalMapResource);
        return localView;
      }
    }
    
    private void reloadData()
    {
      ArrayList localArrayList = new ArrayList();
      this.downloadResources = f.a().f();
      this.finishedResources = f.a().h();
      if (this.downloadResources.size() > 0) {
        localArrayList.addAll(this.downloadResources);
      }
      if (this.finishedResources.size() > 0)
      {
        localArrayList.add(StyleManager.getString(2131296341));
        localArrayList.addAll(this.finishedResources);
      }
      this.currentData = localArrayList;
    }
    
    public Object getChild(int paramInt1, int paramInt2)
    {
      return ((LocalMapResource)getGroup(paramInt1)).children.get(paramInt2);
    }
    
    public long getChildId(int paramInt1, int paramInt2)
    {
      return paramInt2;
    }
    
    public int getChildType(int paramInt1, int paramInt2)
    {
      switch (getGroupType(paramInt1))
      {
      default: 
        return 0;
      }
      return 1;
    }
    
    public int getChildTypeCount()
    {
      return 2;
    }
    
    public View getChildView(int paramInt1, int paramInt2, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
    {
      switch (getChildType(paramInt1, paramInt2))
      {
      default: 
        throw new IllegalArgumentException();
      case 0: 
        return getCityView(paramView, paramViewGroup, (LocalMapResource)getChild(paramInt1, paramInt2), false);
      }
      return getCityView(paramView, paramViewGroup, (LocalMapResource)getChild(paramInt1, paramInt2), true);
    }
    
    public int getChildrenCount(int paramInt)
    {
      Object localObject = getGroup(paramInt);
      if (!LocalMapResource.class.isInstance(localObject)) {}
      do
      {
        return 0;
        localObject = (LocalMapResource)localObject;
      } while (!com.baidu.baidumaps.base.localmap.d.i((LocalMapResource)localObject));
      return ((LocalMapResource)localObject).children.size();
    }
    
    public Object getGroup(int paramInt)
    {
      return this.currentData.get(paramInt);
    }
    
    public int getGroupCount()
    {
      if (this.currentData != null) {
        return this.currentData.size();
      }
      return 0;
    }
    
    public long getGroupId(int paramInt)
    {
      return paramInt;
    }
    
    public int getGroupType(int paramInt)
    {
      Object localObject = getGroup(paramInt);
      if (!LocalMapResource.class.isInstance(localObject)) {
        return 0;
      }
      if (com.baidu.baidumaps.base.localmap.d.i((LocalMapResource)localObject)) {
        return 1;
      }
      return 2;
    }
    
    public int getGroupTypeCount()
    {
      return 3;
    }
    
    public View getGroupView(int paramInt, boolean paramBoolean, View paramView, ViewGroup paramViewGroup)
    {
      switch (getGroupType(paramInt))
      {
      default: 
        throw new IllegalStateException();
      case 0: 
        return getGroupTitleView(paramView, paramViewGroup, (String)getGroup(paramInt));
      case 1: 
        return getProvinceView(paramView, paramViewGroup, (LocalMapResource)getGroup(paramInt), paramBoolean);
      }
      return getCityView(paramView, paramViewGroup, (LocalMapResource)getGroup(paramInt), false);
    }
    
    public boolean hasStableIds()
    {
      return true;
    }
    
    public boolean isChildSelectable(int paramInt1, int paramInt2)
    {
      return true;
    }
    
    public void onClick(View paramView)
    {
      switch (paramView.getId())
      {
      }
      do
      {
        return;
        paramView = (LocalMapResource)paramView.getTag();
      } while (paramView == null);
      if (CarModeOfflineMapManagerFragment.this.mIsEditable)
      {
        delete(paramView);
        return;
      }
      download(paramView);
    }
    
    private class Holder
    {
      private LocalMapResource city;
      private TextView cityNameText;
      private ImageView expandButton;
      TextView mInfoHint;
      RelativeLayout mInfoLayout;
      TextView mInfoTV;
      View mListDivider;
      TextView mNameTV;
      RoundProgressBar mRoundProgressBarDownloading;
      RelativeLayout mStatusLayout;
      ImageView mTaskDelete;
      ImageView mTaskStatusIV;
      private TextView statusText;
      
      private Holder() {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/carmode/CarModeOfflineMapManagerFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */