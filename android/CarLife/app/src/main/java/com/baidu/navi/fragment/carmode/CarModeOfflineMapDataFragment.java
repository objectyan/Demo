package com.baidu.navi.fragment.carmode;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.baidu.baidumaps.base.localmap.f;
import com.baidu.carlife.core.j;
import com.baidu.carlife.core.k;
import com.baidu.carlife.f.c;
import com.baidu.carlife.f.g;
import com.baidu.carlife.view.KeyboardEditText;
import com.baidu.carlife.view.a.a;
import com.baidu.carlife.view.a.c;
import com.baidu.carlife.view.a.d;
import com.baidu.carlife.view.a.b;
import com.baidu.navi.fragment.BaseFragment;
import com.baidu.navi.fragment.ContentFragment;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.view.RoundProgressBar;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.platform.comapi.map.LocalMapResource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class CarModeOfflineMapDataFragment
  extends ContentFragment
  implements a.c, Observer
{
  private boolean canSugShow;
  private boolean isSearchEnable = false;
  private ImageButton mBtnBack;
  private CityListAdapter mCityListAdapter;
  private boolean mEdViewHasFocus = false;
  private View mEditLine;
  private LinearLayout mEditTextContentLayout;
  private ExpandableListView mElvOfflineMapData;
  private g mFocusAreaUp;
  private c mFocusListView;
  private j mHandler = new j(Looper.getMainLooper())
  {
    public void careAbout()
    {
      addMsg(1002);
    }
    
    public void handleMessage(Message paramAnonymousMessage)
    {
      if (paramAnonymousMessage.what == 1002) {
        CarModeOfflineMapDataFragment.this.reAddEditTextView();
      }
    }
  };
  private View.OnKeyListener mOnKeyListener = new View.OnKeyListener()
  {
    public boolean onKey(View paramAnonymousView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
    {
      if ((paramAnonymousKeyEvent != null) && (paramAnonymousKeyEvent.getAction() == 0) && (!CarModeOfflineMapDataFragment.this.canSugShow)) {
        switch (paramAnonymousInt)
        {
        }
      }
      do
      {
        do
        {
          return false;
          if ((CarModeOfflineMapDataFragment.CityListAdapter.access$1100(CarModeOfflineMapDataFragment.this.mCityListAdapter) != null) && (CarModeOfflineMapDataFragment.this.mElvOfflineMapData.getSelectedItemPosition() == CarModeOfflineMapDataFragment.CityListAdapter.access$1200(CarModeOfflineMapDataFragment.this.mCityListAdapter).size() + 2))
          {
            CarModeOfflineMapDataFragment.this.mElvOfflineMapData.onKeyDown(19, paramAnonymousKeyEvent);
            CarModeOfflineMapDataFragment.this.mElvOfflineMapData.onKeyDown(19, paramAnonymousKeyEvent);
            return true;
          }
        } while (CarModeOfflineMapDataFragment.this.mElvOfflineMapData.getSelectedItemPosition() != 1L);
        return true;
      } while ((CarModeOfflineMapDataFragment.CityListAdapter.access$1100(CarModeOfflineMapDataFragment.this.mCityListAdapter) == null) || (CarModeOfflineMapDataFragment.this.mElvOfflineMapData.getSelectedItemPosition() != CarModeOfflineMapDataFragment.CityListAdapter.access$1200(CarModeOfflineMapDataFragment.this.mCityListAdapter).size()));
      CarModeOfflineMapDataFragment.this.mElvOfflineMapData.onKeyDown(20, paramAnonymousKeyEvent);
      CarModeOfflineMapDataFragment.this.mElvOfflineMapData.onKeyDown(20, paramAnonymousKeyEvent);
      return true;
    }
  };
  private KeyboardEditText mSearchEditText;
  private String mSearchKey = "";
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
      if (!CarModeOfflineMapDataFragment.this.canSugShow)
      {
        CarModeOfflineMapDataFragment.this.mElvOfflineMapData.requestFocus();
        CarModeOfflineMapDataFragment.this.mElvOfflineMapData.setSelection(1);
        return true;
      }
      CarModeOfflineMapDataFragment.this.mElvOfflineMapData.requestFocus();
      CarModeOfflineMapDataFragment.this.mElvOfflineMapData.setSelection(0);
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
        CarModeOfflineMapDataFragment.this.pageBack(CarModeOfflineMapDataFragment.this.mModuleFrom);
      }
    });
    this.mSearchEditText.addTextChangedListener(getTextChangedListener());
    KeyboardEditText localKeyboardEditText = this.mSearchEditText;
    com.baidu.carlife.view.a locala = com.baidu.carlife.view.a.a();
    locala.getClass();
    localKeyboardEditText.setOnTouchListener(new a.a(locala, this.mSearchEditText, 6, this, getFocusChangeListener()));
    this.mElvOfflineMapData.setOnScrollListener(getOnScrollListener());
    this.mElvOfflineMapData.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        boolean bool = com.baidu.carlife.view.a.a().b();
        if ((paramAnonymousBoolean) && (bool)) {
          com.baidu.carlife.view.a.a().d();
        }
      }
    });
    this.mElvOfflineMapData.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener()
    {
      public boolean onGroupClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        paramAnonymousExpandableListView = paramAnonymousView.getTag(2131623941);
        if (LocalMapResource.class.isInstance(paramAnonymousExpandableListView))
        {
          paramAnonymousExpandableListView = (LocalMapResource)paramAnonymousExpandableListView;
          if (paramAnonymousExpandableListView != null) {
            CarModeOfflineMapDataFragment.CityListAdapter.access$300(CarModeOfflineMapDataFragment.this.mCityListAdapter, paramAnonymousExpandableListView);
          }
        }
        return false;
      }
    });
    this.mElvOfflineMapData.setOnChildClickListener(new ExpandableListView.OnChildClickListener()
    {
      public boolean onChildClick(ExpandableListView paramAnonymousExpandableListView, View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, long paramAnonymousLong)
      {
        paramAnonymousExpandableListView = paramAnonymousView.getTag(2131623941);
        if (LocalMapResource.class.isInstance(paramAnonymousExpandableListView))
        {
          paramAnonymousExpandableListView = (LocalMapResource)paramAnonymousExpandableListView;
          if (paramAnonymousExpandableListView != null) {
            CarModeOfflineMapDataFragment.CityListAdapter.access$300(CarModeOfflineMapDataFragment.this.mCityListAdapter, paramAnonymousExpandableListView);
          }
        }
        return false;
      }
    });
    k.a(this.mHandler);
  }
  
  private a.d getFocusChangeListener()
  {
    new a.d()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          CarModeOfflineMapDataFragment.this.mEditLine.setBackgroundColor(CarModeOfflineMapDataFragment.this.getResources().getColor(2131558646));
        }
        for (;;)
        {
          CarModeOfflineMapDataFragment.access$502(CarModeOfflineMapDataFragment.this, paramAnonymousBoolean);
          return;
          CarModeOfflineMapDataFragment.this.mEditLine.setBackgroundColor(CarModeOfflineMapDataFragment.this.getResources().getColor(2131558628));
          com.baidu.baidumaps.base.localmap.d.a(CarModeOfflineMapDataFragment.this.getView());
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
          CarModeOfflineMapDataFragment.this.onClickFinish();
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
        TipTool.onCreateDebugToast(BaseFragment.getNaviActivity(), "item" + paramAnonymousInt);
        paramAnonymousAdapterView = CarModeOfflineMapDataFragment.this.mCityListAdapter.getGroup(paramAnonymousInt);
        if ((paramAnonymousAdapterView != null) && ((paramAnonymousAdapterView instanceof LocalMapResource))) {
          CarModeOfflineMapDataFragment.CityListAdapter.access$300(CarModeOfflineMapDataFragment.this.mCityListAdapter, (LocalMapResource)paramAnonymousAdapterView);
        }
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
        com.baidu.baidumaps.base.localmap.d.a(CarModeOfflineMapDataFragment.this.getView());
      }
    };
  }
  
  private TextWatcher getTextChangedListener()
  {
    new TextWatcher()
    {
      public void afterTextChanged(Editable paramAnonymousEditable)
      {
        CarModeOfflineMapDataFragment.access$602(CarModeOfflineMapDataFragment.this, CarModeOfflineMapDataFragment.this.mSearchEditText.getText().toString().trim());
        if (TextUtils.isEmpty(CarModeOfflineMapDataFragment.this.mSearchKey)) {
          CarModeOfflineMapDataFragment.access$802(CarModeOfflineMapDataFragment.this, false);
        }
        for (;;)
        {
          CarModeOfflineMapDataFragment.CityListAdapter.access$900(CarModeOfflineMapDataFragment.this.mCityListAdapter);
          CarModeOfflineMapDataFragment.this.mCityListAdapter.notifyDataSetChanged();
          return;
          CarModeOfflineMapDataFragment.access$802(CarModeOfflineMapDataFragment.this, true);
        }
      }
      
      public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
      
      public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3) {}
    };
  }
  
  private void initData()
  {
    f.a().addObserver(this);
  }
  
  private void initview()
  {
    this.mBtnBack = ((ImageButton)this.mViewGroup.findViewById(2131624130));
    this.mBtnBack.setBackground(b.a(mActivity));
    this.mElvOfflineMapData = ((ExpandableListView)this.mViewGroup.findViewById(2131624134));
    this.mCityListAdapter = new CityListAdapter(getNaviActivity(), null);
    this.mElvOfflineMapData.setAdapter(this.mCityListAdapter);
    this.mSearchEditText = ((KeyboardEditText)this.mViewGroup.findViewById(2131624531));
    this.mEditTextContentLayout = ((LinearLayout)this.mViewGroup.findViewById(2131624132));
    this.mEditLine = this.mViewGroup.findViewById(2131624133);
  }
  
  public boolean onBackPressed()
  {
    pageBack(this.mModuleFrom);
    return true;
  }
  
  public void onClickFinish()
  {
    if (this.isSearchEnable) {}
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    this.mViewGroup = ((ViewGroup)paramLayoutInflater.inflate(2130968612, null));
    initview();
    bindEvents();
    initData();
    return this.mViewGroup;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    try
    {
      f.a().deleteObserver(this);
      if (this.mHandler != null)
      {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
      }
      k.b(this.mHandler);
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void onInitFocusAreas()
  {
    super.onInitFocusAreas();
    if (this.mFocusAreaUp == null)
    {
      this.mFocusAreaUp = new g(this.mViewGroup.findViewById(2131624129), 2);
      this.mFocusAreaUp.d(this.mViewGroup.findViewById(2131624130)).d(this.mViewGroup.findViewById(2131624531));
      this.mFocusAreaUp.a(this.mUpKeyListener);
    }
    if (this.mFocusListView == null)
    {
      this.mFocusListView = new c(this.mElvOfflineMapData, 6);
      this.mFocusListView.a(this.mOnKeyListener);
    }
    com.baidu.carlife.f.d.a().b(new com.baidu.carlife.f.a[] { this.mFocusAreaUp, this.mFocusListView });
    com.baidu.carlife.f.d.a().h(this.mFocusAreaUp);
  }
  
  protected void onInitView() {}
  
  public void onPause()
  {
    super.onPause();
    com.baidu.baidumaps.base.localmap.d.a(getView());
    com.baidu.carlife.view.a.a().d();
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean) {}
  
  public void reAddEditTextView()
  {
    if (!com.baidu.carlife.core.b.a.a()) {}
    do
    {
      do
      {
        return;
      } while ((this.mEditTextContentLayout == null) || (this.mSearchEditText == null) || (this.mSearchKey == null));
      localObject1 = LayoutInflater.from(mActivity).inflate(2130968669, null);
      localObject2 = new LinearLayout.LayoutParams(-1, ScreenUtil.getInstance().dip2px(48));
      this.mEditTextContentLayout.removeAllViews();
      this.mEditTextContentLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    } while (this.mSearchEditText == null);
    this.mSearchEditText.setEnabled(false);
    this.mSearchEditText = ((KeyboardEditText)((View)localObject1).findViewById(2131624531));
    this.mSearchEditText.setEnabled(true);
    this.mSearchEditText.addTextChangedListener(getTextChangedListener());
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
      this.mFocusAreaUp = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    if (this.mHandler != null) {
      this.mHandler.post(new Runnable()
      {
        public void run()
        {
          if (CarModeOfflineMapDataFragment.this.mCityListAdapter != null)
          {
            CarModeOfflineMapDataFragment.CityListAdapter.access$900(CarModeOfflineMapDataFragment.this.mCityListAdapter);
            CarModeOfflineMapDataFragment.this.mCityListAdapter.notifyDataSetChanged();
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
    private static final int COLOR_BLUE = -16739346;
    private static final int COLOR_GRAY = -12895429;
    private static final int COLOR_RED = -983040;
    private static final int GROUP_TYPE_CITY = 2;
    private static final int GROUP_TYPE_PROVINCE = 1;
    private static final int GROUP_TYPE_TITLE = 0;
    private static final String LOG_KEY = "com.baidu.baidumaps.base.localmap.LocalMapCityListFragment";
    private List baseCities;
    private List currentData;
    private LocalMapResource currentyCity;
    private final LayoutInflater inflater;
    private List mDomesticData;
    
    private CityListAdapter(Activity paramActivity)
    {
      this.inflater = paramActivity.getLayoutInflater();
      reloadData();
    }
    
    private void delete(final LocalMapResource paramLocalMapResource)
    {
      FragmentActivity localFragmentActivity = CarModeOfflineMapDataFragment.this.getActivity();
      if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing())) {
        return;
      }
      new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          f.a().f(paramLocalMapResource.id);
          CarModeOfflineMapDataFragment.CityListAdapter.this.reloadData();
          CarModeOfflineMapDataFragment.CityListAdapter.this.notifyDataSetChanged();
          if (!com.baidu.baidumaps.base.localmap.d.d(paramLocalMapResource)) {}
        }
      };
    }
    
    private void download(final LocalMapResource paramLocalMapResource)
    {
      if (com.baidu.baidumaps.base.localmap.d.b(paramLocalMapResource)) {
        TipTool.onCreateToastDialog(BaseFragment.getNaviActivity(), StyleManager.getString(2131296340));
      }
      do
      {
        return;
        if (com.baidu.baidumaps.base.localmap.d.d(paramLocalMapResource))
        {
          TipTool.onCreateToastDialog(BaseFragment.getNaviActivity(), StyleManager.getString(2131296335));
          return;
        }
      } while ((com.baidu.baidumaps.base.localmap.d.g(paramLocalMapResource)) || (com.baidu.baidumaps.base.localmap.d.f(paramLocalMapResource)) || (com.baidu.baidumaps.base.localmap.d.c(paramLocalMapResource)) || (com.baidu.baidumaps.base.localmap.d.e(paramLocalMapResource)) || (com.baidu.baidumaps.base.localmap.d.a(paramLocalMapResource)) || (!com.baidu.baidumaps.base.localmap.d.h(paramLocalMapResource)));
      com.baidu.baidumaps.base.localmap.d.a(CarModeOfflineMapDataFragment.this.getActivity(), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
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
      //   1: getfield 51	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter:this$0	Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment;
      //   4: invokestatic 155	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment:access$1800	(Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment;)Ljava/lang/Object;
      //   7: astore 11
      //   9: aload 11
      //   11: monitorenter
      //   12: aload_1
      //   13: ifnonnull +460 -> 473
      //   16: new 17	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder
      //   19: dup
      //   20: aload_0
      //   21: aconst_null
      //   22: invokespecial 158	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:<init>	(Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter;Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$1;)V
      //   25: astore_2
      //   26: aload_0
      //   27: getfield 62	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter:inflater	Landroid/view/LayoutInflater;
      //   30: ldc -97
      //   32: aconst_null
      //   33: invokevirtual 165	android/view/LayoutInflater:inflate	(ILandroid/view/ViewGroup;)Landroid/view/View;
      //   36: astore_1
      //   37: aload_2
      //   38: aload_1
      //   39: ldc -90
      //   41: invokevirtual 172	android/view/View:findViewById	(I)Landroid/view/View;
      //   44: checkcast 174	android/widget/RelativeLayout
      //   47: putfield 178	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mInfoLayout	Landroid/widget/RelativeLayout;
      //   50: aload_2
      //   51: aload_1
      //   52: ldc -77
      //   54: invokevirtual 172	android/view/View:findViewById	(I)Landroid/view/View;
      //   57: checkcast 174	android/widget/RelativeLayout
      //   60: putfield 182	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mStatusLayout	Landroid/widget/RelativeLayout;
      //   63: aload_2
      //   64: aload_1
      //   65: ldc -73
      //   67: invokevirtual 172	android/view/View:findViewById	(I)Landroid/view/View;
      //   70: checkcast 185	android/widget/TextView
      //   73: putfield 189	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mNameTV	Landroid/widget/TextView;
      //   76: aload_2
      //   77: aload_1
      //   78: ldc -66
      //   80: invokevirtual 172	android/view/View:findViewById	(I)Landroid/view/View;
      //   83: checkcast 185	android/widget/TextView
      //   86: putfield 193	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   89: aload_2
      //   90: aload_1
      //   91: ldc -62
      //   93: invokevirtual 172	android/view/View:findViewById	(I)Landroid/view/View;
      //   96: checkcast 185	android/widget/TextView
      //   99: putfield 197	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mInfoHint	Landroid/widget/TextView;
      //   102: aload_2
      //   103: aload_1
      //   104: ldc -58
      //   106: invokevirtual 172	android/view/View:findViewById	(I)Landroid/view/View;
      //   109: checkcast 200	android/widget/ImageView
      //   112: putfield 204	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mTaskStatusIV	Landroid/widget/ImageView;
      //   115: aload_2
      //   116: aload_1
      //   117: ldc -51
      //   119: invokevirtual 172	android/view/View:findViewById	(I)Landroid/view/View;
      //   122: putfield 209	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mListDivider	Landroid/view/View;
      //   125: aload_2
      //   126: aload_1
      //   127: ldc -46
      //   129: invokevirtual 172	android/view/View:findViewById	(I)Landroid/view/View;
      //   132: checkcast 212	com/baidu/navi/view/RoundProgressBar
      //   135: putfield 216	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mRoundProgressBarDownloading	Lcom/baidu/navi/view/RoundProgressBar;
      //   138: aload_1
      //   139: aload_2
      //   140: invokevirtual 220	android/view/View:setTag	(Ljava/lang/Object;)V
      //   143: aload_3
      //   144: ifnull +974 -> 1118
      //   147: aload_2
      //   148: ifnull +970 -> 1118
      //   151: aload_2
      //   152: getfield 189	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mNameTV	Landroid/widget/TextView;
      //   155: aload_3
      //   156: getfield 225	com/baidu/platform/comapi/map/LocalMapResource:name	Ljava/lang/String;
      //   159: invokevirtual 229	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   162: aload_2
      //   163: getfield 216	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mRoundProgressBarDownloading	Lcom/baidu/navi/view/RoundProgressBar;
      //   166: bipush 8
      //   168: invokevirtual 233	com/baidu/navi/view/RoundProgressBar:setVisibility	(I)V
      //   171: aload_2
      //   172: getfield 204	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mTaskStatusIV	Landroid/widget/ImageView;
      //   175: ldc -22
      //   177: invokevirtual 237	android/widget/ImageView:setImageResource	(I)V
      //   180: aload_2
      //   181: getfield 204	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mTaskStatusIV	Landroid/widget/ImageView;
      //   184: bipush 8
      //   186: invokevirtual 238	android/widget/ImageView:setVisibility	(I)V
      //   189: aload_2
      //   190: getfield 197	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mInfoHint	Landroid/widget/TextView;
      //   193: bipush 8
      //   195: invokevirtual 239	android/widget/TextView:setVisibility	(I)V
      //   198: aload_2
      //   199: getfield 182	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mStatusLayout	Landroid/widget/RelativeLayout;
      //   202: bipush 8
      //   204: invokevirtual 240	android/widget/RelativeLayout:setVisibility	(I)V
      //   207: aload_2
      //   208: aload_3
      //   209: invokestatic 244	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:access$1702	(Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder;Lcom/baidu/platform/comapi/map/LocalMapResource;)Lcom/baidu/platform/comapi/map/LocalMapResource;
      //   212: pop
      //   213: aload_0
      //   214: getfield 51	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter:this$0	Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment;
      //   217: invokestatic 248	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment:access$800	(Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment;)Z
      //   220: ifeq +264 -> 484
      //   223: aload_2
      //   224: getfield 209	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mListDivider	Landroid/view/View;
      //   227: iconst_0
      //   228: invokevirtual 249	android/view/View:setVisibility	(I)V
      //   231: aload_3
      //   232: getfield 252	com/baidu/platform/comapi/map/LocalMapResource:id	I
      //   235: iconst_1
      //   236: if_icmpne +265 -> 501
      //   239: aload_2
      //   240: getfield 197	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mInfoHint	Landroid/widget/TextView;
      //   243: ldc -3
      //   245: invokestatic 115	com/baidu/navi/style/StyleManager:getString	(I)Ljava/lang/String;
      //   248: invokevirtual 229	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   251: aload_2
      //   252: getfield 197	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mInfoHint	Landroid/widget/TextView;
      //   255: iconst_0
      //   256: invokevirtual 239	android/widget/TextView:setVisibility	(I)V
      //   259: aload_2
      //   260: getfield 209	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mListDivider	Landroid/view/View;
      //   263: iconst_0
      //   264: invokevirtual 249	android/view/View:setVisibility	(I)V
      //   267: iload 4
      //   269: ifeq +244 -> 513
      //   272: aload_2
      //   273: getfield 189	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mNameTV	Landroid/widget/TextView;
      //   276: ldc -2
      //   278: invokestatic 258	com/baidu/navi/style/StyleManager:getColor	(I)I
      //   281: invokevirtual 261	android/widget/TextView:setTextColor	(I)V
      //   284: aload_2
      //   285: getfield 193	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   288: ldc_w 262
      //   291: invokestatic 258	com/baidu/navi/style/StyleManager:getColor	(I)I
      //   294: invokevirtual 261	android/widget/TextView:setTextColor	(I)V
      //   297: aload_3
      //   298: astore 10
      //   300: aload_3
      //   301: getfield 265	com/baidu/platform/comapi/map/LocalMapResource:type	I
      //   304: iconst_1
      //   305: if_icmpeq +15 -> 320
      //   308: invokestatic 270	com/baidu/baidumaps/base/localmap/f:a	()Lcom/baidu/baidumaps/base/localmap/f;
      //   311: aload_3
      //   312: getfield 252	com/baidu/platform/comapi/map/LocalMapResource:id	I
      //   315: invokevirtual 273	com/baidu/baidumaps/base/localmap/f:h	(I)Lcom/baidu/platform/comapi/map/LocalMapResource;
      //   318: astore 10
      //   320: aload 10
      //   322: ifnull +730 -> 1052
      //   325: aload 10
      //   327: getfield 276	com/baidu/platform/comapi/map/LocalMapResource:downloadProgress	I
      //   330: i2f
      //   331: ldc_w 277
      //   334: fdiv
      //   335: fstore 5
      //   337: aload_2
      //   338: invokestatic 281	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:access$1700	(Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder;)Lcom/baidu/platform/comapi/map/LocalMapResource;
      //   341: getfield 285	com/baidu/platform/comapi/map/LocalMapResource:mapsize	J
      //   344: aload_2
      //   345: invokestatic 281	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:access$1700	(Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder;)Lcom/baidu/platform/comapi/map/LocalMapResource;
      //   348: getfield 288	com/baidu/platform/comapi/map/LocalMapResource:searchsize	J
      //   351: ladd
      //   352: lstore 8
      //   354: lload 8
      //   356: l2f
      //   357: fconst_1
      //   358: fload 5
      //   360: fsub
      //   361: fmul
      //   362: f2l
      //   363: lstore 6
      //   365: aload 10
      //   367: getfield 265	com/baidu/platform/comapi/map/LocalMapResource:type	I
      //   370: iconst_1
      //   371: if_icmpne +10 -> 381
      //   374: aload 10
      //   376: getfield 291	com/baidu/platform/comapi/map/LocalMapResource:remainSize	J
      //   379: lstore 6
      //   381: aload 10
      //   383: invokestatic 140	com/baidu/baidumaps/base/localmap/d:a	(Lcom/baidu/platform/comapi/map/LocalMapResource;)Z
      //   386: ifeq +143 -> 529
      //   389: aload 10
      //   391: getfield 294	com/baidu/platform/comapi/map/LocalMapResource:version	I
      //   394: ifeq +3 -> 397
      //   397: aload_2
      //   398: getfield 193	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   401: new 296	java/lang/StringBuilder
      //   404: dup
      //   405: invokespecial 297	java/lang/StringBuilder:<init>	()V
      //   408: ldc_w 298
      //   411: invokestatic 115	com/baidu/navi/style/StyleManager:getString	(I)Ljava/lang/String;
      //   414: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   417: ldc_w 304
      //   420: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   423: lload 6
      //   425: invokestatic 307	com/baidu/baidumaps/base/localmap/d:a	(J)Ljava/lang/String;
      //   428: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   431: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   434: invokevirtual 229	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   437: aload_2
      //   438: getfield 193	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   441: ldc_w 312
      //   444: invokestatic 258	com/baidu/navi/style/StyleManager:getColor	(I)I
      //   447: invokevirtual 261	android/widget/TextView:setTextColor	(I)V
      //   450: aload_2
      //   451: getfield 178	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mInfoLayout	Landroid/widget/RelativeLayout;
      //   454: aload 10
      //   456: invokevirtual 313	android/widget/RelativeLayout:setTag	(Ljava/lang/Object;)V
      //   459: aload_1
      //   460: ldc_w 314
      //   463: aload 10
      //   465: invokevirtual 317	android/view/View:setTag	(ILjava/lang/Object;)V
      //   468: aload 11
      //   470: monitorexit
      //   471: aload_1
      //   472: areturn
      //   473: aload_1
      //   474: invokevirtual 321	android/view/View:getTag	()Ljava/lang/Object;
      //   477: checkcast 17	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder
      //   480: astore_2
      //   481: goto -338 -> 143
      //   484: aload_2
      //   485: getfield 209	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mListDivider	Landroid/view/View;
      //   488: bipush 8
      //   490: invokevirtual 249	android/view/View:setVisibility	(I)V
      //   493: goto -262 -> 231
      //   496: aload 11
      //   498: monitorexit
      //   499: aload_1
      //   500: athrow
      //   501: aload_2
      //   502: getfield 197	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mInfoHint	Landroid/widget/TextView;
      //   505: bipush 8
      //   507: invokevirtual 239	android/widget/TextView:setVisibility	(I)V
      //   510: goto -243 -> 267
      //   513: aload_2
      //   514: getfield 189	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mNameTV	Landroid/widget/TextView;
      //   517: ldc_w 262
      //   520: invokestatic 258	com/baidu/navi/style/StyleManager:getColor	(I)I
      //   523: invokevirtual 261	android/widget/TextView:setTextColor	(I)V
      //   526: goto -242 -> 284
      //   529: aload 10
      //   531: invokestatic 102	com/baidu/baidumaps/base/localmap/d:b	(Lcom/baidu/platform/comapi/map/LocalMapResource;)Z
      //   534: ifeq +77 -> 611
      //   537: aload 10
      //   539: getfield 294	com/baidu/platform/comapi/map/LocalMapResource:version	I
      //   542: ifeq +3 -> 545
      //   545: aload 10
      //   547: getfield 324	com/baidu/platform/comapi/map/LocalMapResource:downloadStatus	I
      //   550: bipush 10
      //   552: if_icmpne +3 -> 555
      //   555: aload_2
      //   556: getfield 193	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   559: new 296	java/lang/StringBuilder
      //   562: dup
      //   563: invokespecial 297	java/lang/StringBuilder:<init>	()V
      //   566: ldc_w 325
      //   569: invokestatic 115	com/baidu/navi/style/StyleManager:getString	(I)Ljava/lang/String;
      //   572: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   575: ldc_w 304
      //   578: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   581: lload 6
      //   583: invokestatic 307	com/baidu/baidumaps/base/localmap/d:a	(J)Ljava/lang/String;
      //   586: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   589: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   592: invokevirtual 229	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   595: aload_2
      //   596: getfield 193	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   599: ldc_w 312
      //   602: invokestatic 258	com/baidu/navi/style/StyleManager:getColor	(I)I
      //   605: invokevirtual 261	android/widget/TextView:setTextColor	(I)V
      //   608: goto -158 -> 450
      //   611: aload 10
      //   613: invokestatic 134	com/baidu/baidumaps/base/localmap/d:c	(Lcom/baidu/platform/comapi/map/LocalMapResource;)Z
      //   616: ifeq +93 -> 709
      //   619: aload 10
      //   621: getfield 324	com/baidu/platform/comapi/map/LocalMapResource:downloadStatus	I
      //   624: bipush 8
      //   626: if_icmpne +70 -> 696
      //   629: aload_0
      //   630: getfield 51	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter:this$0	Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment;
      //   633: invokevirtual 90	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment:getActivity	()Landroid/support/v4/app/FragmentActivity;
      //   636: invokestatic 331	com/baidu/platform/comapi/util/NetworkUtil:isWifiConnected	(Landroid/content/Context;)Z
      //   639: pop
      //   640: aload_2
      //   641: getfield 193	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   644: new 296	java/lang/StringBuilder
      //   647: dup
      //   648: invokespecial 297	java/lang/StringBuilder:<init>	()V
      //   651: ldc_w 332
      //   654: invokestatic 115	com/baidu/navi/style/StyleManager:getString	(I)Ljava/lang/String;
      //   657: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   660: ldc_w 304
      //   663: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   666: lload 6
      //   668: invokestatic 307	com/baidu/baidumaps/base/localmap/d:a	(J)Ljava/lang/String;
      //   671: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   674: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   677: invokevirtual 229	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   680: aload_2
      //   681: getfield 193	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   684: ldc_w 333
      //   687: invokestatic 258	com/baidu/navi/style/StyleManager:getColor	(I)I
      //   690: invokevirtual 261	android/widget/TextView:setTextColor	(I)V
      //   693: goto -243 -> 450
      //   696: aload 10
      //   698: getfield 324	com/baidu/platform/comapi/map/LocalMapResource:downloadStatus	I
      //   701: bipush 6
      //   703: if_icmpne -63 -> 640
      //   706: goto -66 -> 640
      //   709: aload 10
      //   711: invokestatic 128	com/baidu/baidumaps/base/localmap/d:g	(Lcom/baidu/platform/comapi/map/LocalMapResource;)Z
      //   714: ifne +11 -> 725
      //   717: aload 10
      //   719: invokestatic 131	com/baidu/baidumaps/base/localmap/d:f	(Lcom/baidu/platform/comapi/map/LocalMapResource;)Z
      //   722: ifeq +248 -> 970
      //   725: aload 10
      //   727: getfield 336	com/baidu/platform/comapi/map/LocalMapResource:mapoldsize	J
      //   730: aload 10
      //   732: getfield 339	com/baidu/platform/comapi/map/LocalMapResource:searcholdsize	J
      //   735: ladd
      //   736: invokestatic 307	com/baidu/baidumaps/base/localmap/d:a	(J)Ljava/lang/String;
      //   739: pop
      //   740: aload 10
      //   742: getfield 342	com/baidu/platform/comapi/map/LocalMapResource:mappatchsize	J
      //   745: aload 10
      //   747: getfield 345	com/baidu/platform/comapi/map/LocalMapResource:searchpatchsize	J
      //   750: ladd
      //   751: invokestatic 307	com/baidu/baidumaps/base/localmap/d:a	(J)Ljava/lang/String;
      //   754: astore_3
      //   755: aload 10
      //   757: invokestatic 348	com/baidu/baidumaps/base/localmap/d:j	(Lcom/baidu/platform/comapi/map/LocalMapResource;)Z
      //   760: ifne +117 -> 877
      //   763: aload 10
      //   765: getfield 324	com/baidu/platform/comapi/map/LocalMapResource:downloadStatus	I
      //   768: bipush 9
      //   770: if_icmpeq +66 -> 836
      //   773: aload 10
      //   775: getfield 351	com/baidu/platform/comapi/map/LocalMapResource:updateStatus	I
      //   778: iconst_4
      //   779: if_icmpeq +57 -> 836
      //   782: new 296	java/lang/StringBuilder
      //   785: dup
      //   786: invokespecial 297	java/lang/StringBuilder:<init>	()V
      //   789: ldc_w 352
      //   792: invokestatic 115	com/baidu/navi/style/StyleManager:getString	(I)Ljava/lang/String;
      //   795: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   798: ldc_w 304
      //   801: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   804: aload_3
      //   805: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   808: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   811: astore_3
      //   812: aload_2
      //   813: getfield 193	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   816: aload_3
      //   817: invokevirtual 229	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   820: aload_2
      //   821: getfield 193	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   824: ldc_w 312
      //   827: invokestatic 258	com/baidu/navi/style/StyleManager:getColor	(I)I
      //   830: invokevirtual 261	android/widget/TextView:setTextColor	(I)V
      //   833: goto -383 -> 450
      //   836: new 296	java/lang/StringBuilder
      //   839: dup
      //   840: invokespecial 297	java/lang/StringBuilder:<init>	()V
      //   843: ldc_w 352
      //   846: invokestatic 115	com/baidu/navi/style/StyleManager:getString	(I)Ljava/lang/String;
      //   849: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   852: ldc_w 304
      //   855: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   858: aload_3
      //   859: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   862: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   865: astore_3
      //   866: aload_2
      //   867: getfield 193	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   870: aload_3
      //   871: invokevirtual 229	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   874: goto -54 -> 820
      //   877: aload 10
      //   879: getfield 351	com/baidu/platform/comapi/map/LocalMapResource:updateStatus	I
      //   882: iconst_4
      //   883: if_icmpne +46 -> 929
      //   886: aload_2
      //   887: getfield 193	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   890: new 296	java/lang/StringBuilder
      //   893: dup
      //   894: invokespecial 297	java/lang/StringBuilder:<init>	()V
      //   897: ldc_w 352
      //   900: invokestatic 115	com/baidu/navi/style/StyleManager:getString	(I)Ljava/lang/String;
      //   903: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   906: ldc_w 304
      //   909: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   912: lload 8
      //   914: invokestatic 307	com/baidu/baidumaps/base/localmap/d:a	(J)Ljava/lang/String;
      //   917: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   920: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   923: invokevirtual 229	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   926: goto -106 -> 820
      //   929: new 296	java/lang/StringBuilder
      //   932: dup
      //   933: invokespecial 297	java/lang/StringBuilder:<init>	()V
      //   936: ldc_w 352
      //   939: invokestatic 115	com/baidu/navi/style/StyleManager:getString	(I)Ljava/lang/String;
      //   942: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   945: ldc_w 304
      //   948: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   951: aload_3
      //   952: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   955: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   958: astore_3
      //   959: aload_2
      //   960: getfield 193	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   963: aload_3
      //   964: invokevirtual 229	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   967: goto -147 -> 820
      //   970: aload 10
      //   972: invokestatic 124	com/baidu/baidumaps/base/localmap/d:d	(Lcom/baidu/platform/comapi/map/LocalMapResource;)Z
      //   975: ifeq +46 -> 1021
      //   978: aload_2
      //   979: getfield 193	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   982: new 296	java/lang/StringBuilder
      //   985: dup
      //   986: invokespecial 297	java/lang/StringBuilder:<init>	()V
      //   989: ldc_w 353
      //   992: invokestatic 115	com/baidu/navi/style/StyleManager:getString	(I)Ljava/lang/String;
      //   995: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   998: ldc_w 304
      //   1001: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1004: lload 8
      //   1006: invokestatic 307	com/baidu/baidumaps/base/localmap/d:a	(J)Ljava/lang/String;
      //   1009: invokevirtual 302	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1012: invokevirtual 311	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1015: invokevirtual 229	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1018: goto -568 -> 450
      //   1021: aload_2
      //   1022: getfield 193	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   1025: lload 8
      //   1027: invokestatic 307	com/baidu/baidumaps/base/localmap/d:a	(J)Ljava/lang/String;
      //   1030: invokevirtual 229	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1033: aload_2
      //   1034: getfield 204	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mTaskStatusIV	Landroid/widget/ImageView;
      //   1037: iconst_0
      //   1038: invokevirtual 238	android/widget/ImageView:setVisibility	(I)V
      //   1041: aload_2
      //   1042: getfield 182	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mStatusLayout	Landroid/widget/RelativeLayout;
      //   1045: iconst_0
      //   1046: invokevirtual 240	android/widget/RelativeLayout:setVisibility	(I)V
      //   1049: goto -599 -> 450
      //   1052: aload_2
      //   1053: getfield 193	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mInfoTV	Landroid/widget/TextView;
      //   1056: aload_2
      //   1057: invokestatic 281	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:access$1700	(Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder;)Lcom/baidu/platform/comapi/map/LocalMapResource;
      //   1060: getfield 285	com/baidu/platform/comapi/map/LocalMapResource:mapsize	J
      //   1063: aload_2
      //   1064: invokestatic 281	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:access$1700	(Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder;)Lcom/baidu/platform/comapi/map/LocalMapResource;
      //   1067: getfield 288	com/baidu/platform/comapi/map/LocalMapResource:searchsize	J
      //   1070: ladd
      //   1071: invokestatic 307	com/baidu/baidumaps/base/localmap/d:a	(J)Ljava/lang/String;
      //   1074: invokevirtual 229	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1077: aload_2
      //   1078: getfield 204	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mTaskStatusIV	Landroid/widget/ImageView;
      //   1081: iconst_0
      //   1082: invokevirtual 238	android/widget/ImageView:setVisibility	(I)V
      //   1085: aload_2
      //   1086: getfield 182	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mStatusLayout	Landroid/widget/RelativeLayout;
      //   1089: iconst_0
      //   1090: invokevirtual 240	android/widget/RelativeLayout:setVisibility	(I)V
      //   1093: aload_2
      //   1094: getfield 178	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mInfoLayout	Landroid/widget/RelativeLayout;
      //   1097: aload_2
      //   1098: invokestatic 281	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:access$1700	(Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder;)Lcom/baidu/platform/comapi/map/LocalMapResource;
      //   1101: invokevirtual 313	android/widget/RelativeLayout:setTag	(Ljava/lang/Object;)V
      //   1104: aload_1
      //   1105: ldc_w 314
      //   1108: aload_2
      //   1109: invokestatic 281	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:access$1700	(Lcom/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder;)Lcom/baidu/platform/comapi/map/LocalMapResource;
      //   1112: invokevirtual 317	android/view/View:setTag	(ILjava/lang/Object;)V
      //   1115: goto -647 -> 468
      //   1118: aload_2
      //   1119: getfield 209	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mListDivider	Landroid/view/View;
      //   1122: bipush 8
      //   1124: invokevirtual 249	android/view/View:setVisibility	(I)V
      //   1127: aload_2
      //   1128: getfield 178	com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment$CityListAdapter$Holder:mInfoLayout	Landroid/widget/RelativeLayout;
      //   1131: bipush 8
      //   1133: invokevirtual 240	android/widget/RelativeLayout:setVisibility	(I)V
      //   1136: goto -668 -> 468
      //   1139: astore_1
      //   1140: goto -644 -> 496
      //   1143: astore_1
      //   1144: goto -648 -> 496
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1147	0	this	CityListAdapter
      //   0	1147	1	paramView	View
      //   0	1147	2	paramViewGroup	ViewGroup
      //   0	1147	3	paramLocalMapResource	LocalMapResource
      //   0	1147	4	paramBoolean	boolean
      //   335	24	5	f	float
      //   363	304	6	l1	long
      //   352	674	8	l2	long
      //   298	673	10	localLocalMapResource	LocalMapResource
      //   7	490	11	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   26	143	1139	finally
      //   16	26	1143	finally
      //   151	231	1143	finally
      //   231	267	1143	finally
      //   272	284	1143	finally
      //   284	297	1143	finally
      //   300	320	1143	finally
      //   325	354	1143	finally
      //   365	381	1143	finally
      //   381	397	1143	finally
      //   397	450	1143	finally
      //   450	468	1143	finally
      //   468	471	1143	finally
      //   473	481	1143	finally
      //   484	493	1143	finally
      //   496	499	1143	finally
      //   501	510	1143	finally
      //   513	526	1143	finally
      //   529	545	1143	finally
      //   545	555	1143	finally
      //   555	608	1143	finally
      //   611	640	1143	finally
      //   640	693	1143	finally
      //   696	706	1143	finally
      //   709	725	1143	finally
      //   725	820	1143	finally
      //   820	833	1143	finally
      //   836	874	1143	finally
      //   877	926	1143	finally
      //   929	967	1143	finally
      //   970	1018	1143	finally
      //   1021	1049	1143	finally
      //   1052	1115	1143	finally
      //   1118	1136	1143	finally
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
      for (int i = 2130838335;; i = 2130838276)
      {
        paramView.setImageResource(i);
        com.baidu.baidumaps.base.localmap.d.k(paramLocalMapResource);
        return localView;
      }
    }
    
    private void reloadData()
    {
      int i;
      if (this.mDomesticData == null)
      {
        this.mDomesticData = new ArrayList();
        this.baseCities = new ArrayList();
        this.currentyCity = f.a().k();
        if (this.currentyCity != null)
        {
          this.baseCities.add(this.currentyCity);
          localObject1 = f.a().m().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (LocalMapResource)((Iterator)localObject1).next();
            if ((((LocalMapResource)localObject2).id == 1) && (((LocalMapResource)localObject2).frc == 1))
            {
              ((LocalMapResource)localObject2).name = "全国基础包";
              this.baseCities.add(localObject2);
            }
          }
          if ((this.baseCities != null) && (this.baseCities.size() > 0))
          {
            this.mDomesticData.add(StyleManager.getString(2131296334));
            this.mDomesticData.addAll(this.baseCities);
          }
        }
        localObject1 = new ArrayList();
        localObject2 = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        List localList = f.a().m();
        if ((localList != null) && (localList.size() > 0))
        {
          i = 0;
          if (i < localList.size())
          {
            if (((LocalMapResource)localList.get(i)).frc == 1) {
              if ((((LocalMapResource)localList.get(i)).id == 131) || (((LocalMapResource)localList.get(i)).id == 289) || (((LocalMapResource)localList.get(i)).id == 332) || (((LocalMapResource)localList.get(i)).id == 132)) {
                ((List)localObject2).add(localList.get(i));
              }
            }
            for (;;)
            {
              i += 1;
              break;
              if (this.currentyCity == null)
              {
                ((List)localObject1).add(localList.get(i));
              }
              else if (((LocalMapResource)localList.get(i)).id != 1)
              {
                ((List)localObject1).add(localList.get(i));
                continue;
                if ((((LocalMapResource)localList.get(i)).frc == 2) && ((((LocalMapResource)localList.get(i)).id == 2912) || (((LocalMapResource)localList.get(i)).id == 9000) || (((LocalMapResource)localList.get(i)).id == 2911))) {
                  localArrayList.add(localList.get(i));
                }
              }
            }
          }
          this.mDomesticData.add(StyleManager.getString(2131296336));
          this.mDomesticData.addAll((Collection)localObject2);
          this.mDomesticData.addAll(localArrayList);
          this.mDomesticData.addAll((Collection)localObject1);
        }
      }
      if ((CarModeOfflineMapDataFragment.this.mSearchKey == null) || (CarModeOfflineMapDataFragment.this.mSearchKey.length() == 0))
      {
        this.currentData = this.mDomesticData;
        return;
      }
      Object localObject1 = f.a().a(CarModeOfflineMapDataFragment.this.mSearchKey);
      Object localObject2 = new ArrayList();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        i = 0;
        if (i < ((List)localObject1).size())
        {
          if (((LocalMapResource)((List)localObject1).get(i)).type != 1)
          {
            if (((LocalMapResource)((List)localObject1).get(i)).frc != 1) {
              break label700;
            }
            ((List)localObject2).add(((List)localObject1).get(i));
          }
          for (;;)
          {
            i += 1;
            break;
            label700:
            if ((((LocalMapResource)((List)localObject1).get(i)).frc == 2) && ((((LocalMapResource)((List)localObject1).get(i)).id == 2912) || (((LocalMapResource)((List)localObject1).get(i)).id == 9000) || (((LocalMapResource)((List)localObject1).get(i)).id == 2911))) {
              ((List)localObject2).add(((List)localObject1).get(i));
            }
          }
        }
      }
      this.currentData = ((List)localObject2);
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
        return getCityView(paramView, paramViewGroup, (LocalMapResource)getChild(paramInt1, paramInt2), true);
      }
      return getCityView(paramView, paramViewGroup, (LocalMapResource)getChild(paramInt1, paramInt2), false);
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
      return getCityView(paramView, paramViewGroup, (LocalMapResource)getGroup(paramInt), true);
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
      ImageView mTaskStatusIV;
      private TextView statusText;
      
      private Holder() {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/carmode/CarModeOfflineMapDataFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */