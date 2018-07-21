package com.baidu.navisdk.module.ugc.ui.inmap.main;

import android.app.Activity;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataRepository;
import com.baidu.navisdk.module.ugc.data.datarepository.UgcDataRepository.UgcBaseDataModel;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import java.util.ArrayList;
import java.util.List;

public class UgcReportMapMainView
  implements View.OnClickListener, UgcReportMapMainContract.View
{
  private static final int SUBTIME_ADDRESS_TYPE = 1;
  private static final int SUBTIME_ROAD_TYPE = 2;
  private TextView checkDetailTv = null;
  private ImageView errPositionIV = null;
  private ImageView errPositionIVBg = null;
  private LinearLayout errPositionLayout = null;
  private TextView errPositionTV = null;
  private ArrayList<UgcDataRepository.UgcBaseDataModel> feedBackList = new ArrayList();
  private TextView hasHelpTv = null;
  private ArrayList listItem = new ArrayList();
  private Context mContext = null;
  private UgcReportMapMainContract.Presenter mPresenter = null;
  private View mRootView = null;
  private View mSubItemFrame = null;
  private ListView mSubItemLv = null;
  private ImageView moreFeedbackIV = null;
  private ImageView moreFeedbackIVBg = null;
  private LinearLayout moreFeedbackLayout = null;
  private TextView moreFeedbackTV = null;
  private ImageView newPositionIV = null;
  private ImageView newPositionIVBg = null;
  private LinearLayout newPositionLayout = null;
  private TextView newPositionTV = null;
  private GridView parentItemsGv = null;
  private SubItemAdapter subItemAdapter = null;
  private ViewGroup titleBar = null;
  private View userInfoLayout = null;
  
  public UgcReportMapMainView(Context paramContext)
  {
    initVariable(paramContext);
    initView();
    initListener();
  }
  
  private ArrayList<UgcDataRepository.UgcBaseDataModel> createSubItemString(int paramInt)
  {
    if ((this.feedBackList != null) && (this.feedBackList.size() > 0))
    {
      this.listItem.clear();
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      return this.listItem;
      ArrayList localArrayList = ((UgcDataRepository.UgcBaseDataModel)this.feedBackList.get(0)).ugcSubDataSec;
      this.listItem.addAll(localArrayList);
      continue;
      localArrayList = ((UgcDataRepository.UgcBaseDataModel)this.feedBackList.get(1)).ugcSubDataSec;
      this.listItem.addAll(localArrayList);
    }
  }
  
  private int getFeedBackType(int paramInt)
  {
    int j = -1;
    int i = j;
    if (this.feedBackList != null)
    {
      i = j;
      if (paramInt < this.feedBackList.size()) {
        i = ((UgcDataRepository.UgcBaseDataModel)this.feedBackList.get(paramInt)).type;
      }
    }
    return i;
  }
  
  private int getLocalType(int paramInt)
  {
    return 61440 + paramInt;
  }
  
  private void initListener()
  {
    if (this.checkDetailTv != null) {
      this.checkDetailTv.setOnClickListener(this);
    }
    if (this.newPositionIV != null) {
      this.newPositionIV.setOnClickListener(this);
    }
    if (this.errPositionIV != null) {
      this.errPositionIV.setOnClickListener(this);
    }
    if (this.moreFeedbackIV != null) {
      this.moreFeedbackIV.setOnClickListener(this);
    }
    if (this.moreFeedbackIVBg != null) {
      this.moreFeedbackIVBg.setOnClickListener(this);
    }
    if (this.newPositionIVBg != null) {
      this.newPositionIVBg.setOnClickListener(this);
    }
    if (this.errPositionIVBg != null) {
      this.errPositionIVBg.setOnClickListener(this);
    }
  }
  
  private void initVariable(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  private void initView()
  {
    if (this.mContext == null) {}
    do
    {
      return;
      this.mRootView = JarUtils.inflate((Activity)this.mContext, 1711472761, null);
    } while (this.mRootView == null);
    this.parentItemsGv = ((GridView)this.mRootView.findViewById(1711867099));
    this.titleBar = ((ViewGroup)this.mRootView.findViewById(1711867097));
    this.checkDetailTv = ((TextView)this.mRootView.findViewById(1711867116));
    this.hasHelpTv = ((TextView)this.mRootView.findViewById(1711867117));
    this.userInfoLayout = this.mRootView.findViewById(1711867115);
    this.newPositionLayout = ((LinearLayout)this.mRootView.findViewById(1711867103));
    this.errPositionLayout = ((LinearLayout)this.mRootView.findViewById(1711867107));
    this.moreFeedbackLayout = ((LinearLayout)this.mRootView.findViewById(1711867111));
    this.newPositionIV = ((ImageView)this.mRootView.findViewById(1711867104));
    this.errPositionIV = ((ImageView)this.mRootView.findViewById(1711867108));
    this.moreFeedbackIV = ((ImageView)this.mRootView.findViewById(1711867112));
    this.moreFeedbackIVBg = ((ImageView)this.mRootView.findViewById(1711867113));
    this.newPositionIVBg = ((ImageView)this.mRootView.findViewById(1711867105));
    this.errPositionIVBg = ((ImageView)this.mRootView.findViewById(1711867109));
    this.newPositionTV = ((TextView)this.mRootView.findViewById(1711867106));
    this.errPositionTV = ((TextView)this.mRootView.findViewById(1711867110));
    this.moreFeedbackTV = ((TextView)this.mRootView.findViewById(1711867114));
    this.mSubItemFrame = this.mRootView.findViewById(1711867118);
    this.mSubItemFrame.setOnClickListener(this);
    this.mSubItemLv = ((ListView)this.mRootView.findViewById(1711867119));
    ((TextView)this.mRootView.findViewById(1711867121)).setOnClickListener(this);
    this.mSubItemLv.setDivider(null);
    this.mSubItemLv.setDividerHeight(0);
    this.subItemAdapter = new SubItemAdapter(this.mContext, createSubItemString(1));
    this.mSubItemLv.setAdapter(this.subItemAdapter);
    this.mSubItemLv.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if ((UgcReportMapMainView.this.mPresenter != null) && (paramAnonymousInt >= 0))
        {
          paramAnonymousAdapterView = (UgcReportMapMainView.SubItemAdapter.MyViewHolder)paramAnonymousView.getTag();
          if (Build.VERSION.SDK_INT >= 15) {
            paramAnonymousAdapterView.mTxtView.callOnClick();
          }
          paramAnonymousAdapterView = paramAnonymousAdapterView.data;
          UgcReportMapMainView.this.mPresenter.gotoUgcMapH5Page(paramAnonymousAdapterView.iconUrl);
          UserOPController.getInstance().add("3.u.4.1", "1", UgcReportMapMainView.this.subItemAdapter.itemType + "", paramAnonymousAdapterView.type + "");
        }
      }
    });
  }
  
  public View getParentView()
  {
    return this.mRootView;
  }
  
  public ViewGroup getTitleContainer()
  {
    return this.titleBar;
  }
  
  public void initPresenterView()
  {
    if (this.parentItemsGv != null) {
      this.parentItemsGv.setAdapter(new MapMainGvAdapter(this.mPresenter, (Activity)this.mContext));
    }
    setUserInfoLayoutvisibile(false);
    if (this.mPresenter != null) {
      this.mPresenter.initUserInfo(this.hasHelpTv);
    }
    if ((this.newPositionLayout != null) && (this.errPositionLayout != null) && (this.moreFeedbackLayout != null) && (this.newPositionTV != null) && (this.errPositionTV != null) && (this.moreFeedbackTV != null))
    {
      this.feedBackList = UgcDataRepository.getInstance().obtainMapFeedBackDataList();
      if ((this.feedBackList != null) && (this.feedBackList.size() > 0)) {
        break label155;
      }
      this.newPositionLayout.setVisibility(8);
      this.errPositionLayout.setVisibility(8);
      this.moreFeedbackLayout.setVisibility(8);
    }
    label155:
    do
    {
      return;
      if (this.feedBackList.size() == 1)
      {
        this.errPositionLayout.setVisibility(8);
        this.moreFeedbackLayout.setVisibility(8);
        this.newPositionTV.setText(((UgcDataRepository.UgcBaseDataModel)this.feedBackList.get(0)).title);
        this.mPresenter.setOnlineImageLoader(getLocalType(((UgcDataRepository.UgcBaseDataModel)this.feedBackList.get(0)).type), this.newPositionIV, ((UgcDataRepository.UgcBaseDataModel)this.feedBackList.get(0)).iconUrl);
        this.newPositionLayout.setGravity(1);
        return;
      }
      if (this.feedBackList.size() == 2)
      {
        this.moreFeedbackLayout.setVisibility(8);
        this.newPositionTV.setText(((UgcDataRepository.UgcBaseDataModel)this.feedBackList.get(0)).title);
        this.errPositionTV.setText(((UgcDataRepository.UgcBaseDataModel)this.feedBackList.get(1)).title);
        this.mPresenter.setOnlineImageLoader(getLocalType(((UgcDataRepository.UgcBaseDataModel)this.feedBackList.get(0)).type), this.newPositionIV, ((UgcDataRepository.UgcBaseDataModel)this.feedBackList.get(0)).iconUrl);
        this.mPresenter.setOnlineImageLoader(getLocalType(((UgcDataRepository.UgcBaseDataModel)this.feedBackList.get(1)).type), this.errPositionIV, ((UgcDataRepository.UgcBaseDataModel)this.feedBackList.get(1)).iconUrl);
        this.newPositionLayout.setGravity(1);
        this.errPositionLayout.setGravity(1);
        return;
      }
    } while (this.feedBackList.size() != 3);
    this.newPositionTV.setText(((UgcDataRepository.UgcBaseDataModel)this.feedBackList.get(0)).title);
    this.errPositionTV.setText(((UgcDataRepository.UgcBaseDataModel)this.feedBackList.get(1)).title);
    this.moreFeedbackTV.setText(((UgcDataRepository.UgcBaseDataModel)this.feedBackList.get(2)).title);
    this.mPresenter.setOnlineImageLoader(getLocalType(((UgcDataRepository.UgcBaseDataModel)this.feedBackList.get(0)).type), this.newPositionIV, ((UgcDataRepository.UgcBaseDataModel)this.feedBackList.get(0)).iconUrl);
    this.mPresenter.setOnlineImageLoader(getLocalType(((UgcDataRepository.UgcBaseDataModel)this.feedBackList.get(1)).type), this.errPositionIV, ((UgcDataRepository.UgcBaseDataModel)this.feedBackList.get(1)).iconUrl);
    this.mPresenter.setOnlineImageLoader(getLocalType(((UgcDataRepository.UgcBaseDataModel)this.feedBackList.get(2)).type), this.moreFeedbackIV, ((UgcDataRepository.UgcBaseDataModel)this.feedBackList.get(2)).iconUrl);
    this.moreFeedbackIV.setTag(this.feedBackList.get(2));
    this.moreFeedbackIVBg.setTag(this.feedBackList.get(2));
    this.newPositionLayout.setGravity(3);
    this.errPositionLayout.setGravity(1);
    this.moreFeedbackLayout.setGravity(5);
  }
  
  public boolean onBackPress()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (this.mPresenter == null) {}
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
              switch (paramView.getId())
              {
              case 1711867106: 
              case 1711867107: 
              case 1711867110: 
              case 1711867111: 
              case 1711867114: 
              case 1711867115: 
              case 1711867117: 
              case 1711867119: 
              case 1711867120: 
              default: 
                return;
              }
            } while (this.mSubItemFrame == null);
            i = getFeedBackType(0);
            createSubItemString(i);
            this.subItemAdapter.setItemType(i);
            this.subItemAdapter.notifyDataSetChanged();
            this.mSubItemFrame.setVisibility(0);
            UserOPController.getInstance().add("3.u.4.1", "1", i + "", null);
            return;
          } while (this.mPresenter == null);
          if (this.hasHelpTv.getVisibility() == 0)
          {
            this.mPresenter.performCheckDetailBtn();
            return;
          }
          this.mPresenter.informUserToRegister();
          return;
        } while (this.mSubItemFrame == null);
        int i = getFeedBackType(1);
        createSubItemString(i);
        this.subItemAdapter.setItemType(i);
        this.subItemAdapter.notifyDataSetChanged();
        this.mSubItemFrame.setVisibility(0);
        UserOPController.getInstance().add("3.u.4.1", "1", i + "", null);
        return;
        paramView = (UgcDataRepository.UgcBaseDataModel)paramView.getTag();
      } while (paramView == null);
      this.mPresenter.gotoUgcMapApi(paramView.link);
      UserOPController.getInstance().add("3.u.4.1", "1", getFeedBackType(2) + "", null);
      return;
    } while (this.mSubItemFrame == null);
    this.mSubItemFrame.setVisibility(8);
  }
  
  public void onDestroy() {}
  
  public void reMeasureLayout() {}
  
  public void setPresenter(UgcReportMapMainContract.Presenter paramPresenter)
  {
    this.mPresenter = paramPresenter;
  }
  
  public void setUserInfoLayoutvisibile(boolean paramBoolean)
  {
    if (this.userInfoLayout == null) {
      return;
    }
    if (paramBoolean)
    {
      this.userInfoLayout.setVisibility(0);
      return;
    }
    this.userInfoLayout.setVisibility(8);
  }
  
  public void showUserUnRegister()
  {
    setUserInfoLayoutvisibile(true);
    if (this.checkDetailTv != null)
    {
      this.checkDetailTv.setVisibility(0);
      this.checkDetailTv.setText("登录查看上报");
    }
    if (this.hasHelpTv != null) {
      this.hasHelpTv.setVisibility(8);
    }
  }
  
  public void showUserUploadCounts(int paramInt)
  {
    setUserInfoLayoutvisibile(true);
    if ((this.checkDetailTv != null) && (this.hasHelpTv != null))
    {
      this.hasHelpTv.setVisibility(0);
      this.checkDetailTv.setVisibility(0);
      this.checkDetailTv.setText("点击查看详情>");
      this.hasHelpTv.setText(Html.fromHtml("您已上报<font color=\"#3385ff\"> " + paramInt + " </font>次"));
    }
  }
  
  class MapMainGvAdapter
    extends BaseAdapter
    implements View.OnClickListener
  {
    private int leftSpacing = 0;
    private Activity mContext;
    private UgcReportMapMainContract.Presenter mPresenter;
    View.OnTouchListener onTouchListener = new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        paramAnonymousView = ((UgcReportMapMainView.MapMainGvAdapter.ViewHolder)paramAnonymousView.getTag()).mChildIView;
        if (paramAnonymousView == null) {}
        do
        {
          do
          {
            do
            {
              return false;
              if (paramAnonymousMotionEvent.getAction() != 0) {
                break;
              }
              paramAnonymousView = paramAnonymousView.getBackground();
            } while (paramAnonymousView == null);
            paramAnonymousView.setColorFilter(-7829368, PorterDuff.Mode.MULTIPLY);
            return false;
          } while ((paramAnonymousMotionEvent.getAction() != 1) && (paramAnonymousMotionEvent.getAction() != 3));
          paramAnonymousView = paramAnonymousView.getBackground();
        } while (paramAnonymousView == null);
        paramAnonymousView.clearColorFilter();
        return false;
      }
    };
    private int rightSpacing = 0;
    
    public MapMainGvAdapter(UgcReportMapMainContract.Presenter paramPresenter, Activity paramActivity)
    {
      this.mContext = paramActivity;
      this.mPresenter = paramPresenter;
    }
    
    public int getCount()
    {
      if (this.mPresenter == null) {
        return 0;
      }
      return this.mPresenter.parentItemsGvSize();
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public int getLeftSpacing()
    {
      return this.leftSpacing;
    }
    
    public int getRightSpacing()
    {
      return this.rightSpacing;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = JarUtils.inflate(this.mContext, 1711472759, null);
        if (paramView == null) {
          return null;
        }
        paramViewGroup = new ViewHolder();
        paramViewGroup.mChildIViewBg = ((ImageView)paramView.findViewById(1711867094));
        paramViewGroup.mChildIView = ((ImageView)paramView.findViewById(1711867092));
        paramViewGroup.mChildName = ((TextView)paramView.findViewById(1711867093));
        paramView.setTag(paramViewGroup);
      }
      for (;;)
      {
        paramViewGroup.position = paramInt;
        if (paramView != null) {
          paramView.setOnTouchListener(this.onTouchListener);
        }
        paramView.setOnClickListener(this);
        this.mPresenter.parentItemsGvImageLoader(paramInt, paramViewGroup.mChildIView);
        paramViewGroup.mChildName.setText(this.mPresenter.getParentItemsGvTextTile(paramInt));
        return paramView;
        paramViewGroup = (ViewHolder)paramView.getTag();
      }
    }
    
    public void onClick(View paramView)
    {
      try
      {
        paramView = (ViewHolder)paramView.getTag();
        if (this.mPresenter != null) {
          this.mPresenter.gotoMapSubDetailView(paramView.position);
        }
        return;
      }
      catch (Exception paramView) {}
    }
    
    class ViewHolder
    {
      public ImageView mChildIView;
      public ImageView mChildIViewBg;
      public TextView mChildName;
      public int position;
      
      ViewHolder() {}
    }
  }
  
  private class SubItemAdapter<T>
    extends ArrayAdapter<T>
  {
    public int itemType = 1;
    
    SubItemAdapter(List<T> paramList)
    {
      super(-1, -1, localList);
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (getContext() == null) {}
      while ((LayoutInflater)getContext().getSystemService("layout_inflater") == null) {
        return null;
      }
      paramView = new MyViewHolder();
      paramViewGroup = JarUtils.inflate((Activity)UgcReportMapMainView.this.mContext, 1711472762, null);
      TextView localTextView = (TextView)paramViewGroup.findViewById(1711866331);
      UgcDataRepository.UgcBaseDataModel localUgcBaseDataModel = (UgcDataRepository.UgcBaseDataModel)getItem(paramInt);
      localTextView.setText(localUgcBaseDataModel.title);
      paramView.itemView = paramViewGroup;
      paramView.mTxtView = localTextView;
      paramView.data = localUgcBaseDataModel;
      paramViewGroup.setTag(paramView);
      return paramViewGroup;
    }
    
    public void setItemType(int paramInt)
    {
      this.itemType = paramInt;
    }
    
    class MyViewHolder
    {
      public UgcDataRepository.UgcBaseDataModel data;
      public View itemView;
      public TextView mTxtView;
      
      MyViewHolder() {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/ugc/ui/inmap/main/UgcReportMapMainView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */