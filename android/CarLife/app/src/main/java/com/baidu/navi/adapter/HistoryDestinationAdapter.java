package com.baidu.navi.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.carlife.BaiduNaviApplication;
import com.baidu.carlife.core.screen.b;
import com.baidu.carlife.core.screen.e;
import com.baidu.carlife.view.dialog.c;
import com.baidu.navi.controller.QuickRoutePlanController;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navi.view.TravelRefListener;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.db.DBManager;
import com.baidu.navisdk.util.db.DBManager.DBOperateResultCallback;
import com.baidu.navisdk.util.db.model.NaviDestHistroyModel;
import java.util.ArrayList;
import java.util.List;

public class HistoryDestinationAdapter
  extends BaseAdapter
{
  private int MAX_HISTORY_NUM = 10;
  private DBManager.DBOperateResultCallback callback = new DBManager.DBOperateResultCallback()
  {
    public void onAddOrDeleteSuccess()
    {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          HistoryDestinationAdapter.this.notifyHistoryDataSetChanged();
          if ((HistoryDestinationAdapter.this.mTravelRefListener != null) && (HistoryDestinationAdapter.this.getCount() == 0)) {
            HistoryDestinationAdapter.this.mTravelRefListener.onAddOrDeleteSuccess();
          }
        }
      });
    }
    
    public void onQuerySuccess()
    {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          HistoryDestinationAdapter.this.notifyHistoryDataSetChanged();
        }
      });
    }
  };
  private boolean hideRefLayout = false;
  ViewHolder holder;
  private View mCleanHistoryLayout;
  private Context mContext;
  private QuickRoutePlanController mFragControl;
  private List<RoutePlanNode> mHistoryList = new ArrayList();
  private LayoutInflater mInflater;
  private boolean mIsCarMode = false;
  private boolean mIsQuickNaviFragment = false;
  private boolean mIsRoutePlanNodeFragment = false;
  private ListView mListView;
  private NaviDestHistroyModel mNaviDestHistory;
  private e mOnDialogListener;
  private int mOrientation;
  private String mPackageName;
  private Resources mResources;
  private RoutePlanNode mRoutePlanNode;
  private TravelRefListener mTravelRefListener;
  
  public HistoryDestinationAdapter(Context paramContext, boolean paramBoolean)
  {
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.mContext = paramContext;
    this.mIsQuickNaviFragment = paramBoolean;
    this.mNaviDestHistory = NaviDestHistroyModel.getInstance();
  }
  
  public HistoryDestinationAdapter(Context paramContext, boolean paramBoolean, TravelRefListener paramTravelRefListener)
  {
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.mContext = paramContext;
    this.mIsQuickNaviFragment = paramBoolean;
    this.mNaviDestHistory = NaviDestHistroyModel.getInstance();
    if (!this.mNaviDestHistory.checkIsQueryDB()) {
      DBManager.getAllHistoryDestPoints(this.callback);
    }
    this.mTravelRefListener = paramTravelRefListener;
  }
  
  public HistoryDestinationAdapter(Context paramContext, boolean paramBoolean, TravelRefListener paramTravelRefListener, QuickRoutePlanController paramQuickRoutePlanController)
  {
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    this.mContext = paramContext;
    this.mIsQuickNaviFragment = paramBoolean;
    this.mNaviDestHistory = NaviDestHistroyModel.getInstance();
    if (!this.mNaviDestHistory.checkIsQueryDB()) {
      DBManager.getAllHistoryDestPoints(this.callback);
    }
    this.mTravelRefListener = paramTravelRefListener;
    this.mFragControl = paramQuickRoutePlanController;
  }
  
  private View getItemView(View paramView, final int paramInt)
  {
    if (paramView == null)
    {
      this.holder = new ViewHolder();
      paramView = this.mInflater.inflate(2130968950, null);
      this.holder.infoLayout = ((LinearLayout)paramView.findViewById(2131625821));
      this.holder.poiInfoLayout = ((LinearLayout)paramView.findViewById(2131625823));
      this.holder.pointName = ((TextView)paramView.findViewById(2131625825));
      this.holder.pointDescription = ((TextView)paramView.findViewById(2131625826));
      this.holder.pointIcon = ((ImageView)paramView.findViewById(2131625822));
      this.holder.travelRef = ((ImageView)paramView.findViewById(2131625827));
      this.holder.travelRefLayout = ((LinearLayout)paramView.findViewById(2131625824));
      paramView.setTag(this.holder);
    }
    for (;;)
    {
      updateStyle(paramInt);
      this.holder.travelRefLayout.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (ForbidDaulClickUtils.isFastDoubleClick()) {
            return;
          }
          if (HistoryDestinationAdapter.this.mTravelRefListener != null) {
            HistoryDestinationAdapter.this.mTravelRefListener.onEnterTravelRefFragment(paramInt, false);
          }
          StatisticManager.onEvent("410041", "410041");
        }
      });
      return paramView;
      this.holder = ((ViewHolder)paramView.getTag());
    }
  }
  
  private String getResourceNameById(int paramInt)
  {
    String str = "";
    if (this.mResources != null) {}
    try
    {
      str = this.mResources.getResourceEntryName(paramInt);
      return str;
    }
    catch (Resources.NotFoundException localNotFoundException) {}
    return "";
  }
  
  private void setItemContent(int paramInt)
  {
    if ((this.mHistoryList == null) || (paramInt >= this.mHistoryList.size())) {
      return;
    }
    this.mRoutePlanNode = ((RoutePlanNode)this.mHistoryList.get(paramInt));
    if (this.mRoutePlanNode != null)
    {
      String str2 = this.mRoutePlanNode.getName();
      String str3 = this.mRoutePlanNode.getDescription();
      String str1 = str2;
      if (StringUtils.isEmpty(str2)) {
        str1 = this.mContext.getString(2131296411);
      }
      if (this.holder.pointName != null) {
        this.holder.pointName.setText(str1);
      }
      if (this.holder.pointDescription != null)
      {
        if ((str3 == null) || (str3.length() <= 0)) {
          break label202;
        }
        this.holder.pointDescription.setText(str3);
        this.holder.pointDescription.setVisibility(0);
      }
    }
    while (((this.mIsQuickNaviFragment) || (this.mIsCarMode)) && (!this.hideRefLayout) && (NetworkUtils.isNetworkAvailable(this.mContext)))
    {
      this.holder.travelRefLayout.setVisibility(0);
      this.holder.travelRef.setVisibility(0);
      return;
      label202:
      this.holder.pointDescription.setText(null);
      this.holder.pointDescription.setVisibility(8);
    }
    this.holder.travelRefLayout.setVisibility(8);
    this.holder.travelRef.setVisibility(8);
  }
  
  private void updateStyle(int paramInt)
  {
    Drawable localDrawable;
    if (this.mIsCarMode)
    {
      if (this.holder.pointName != null) {
        this.holder.pointName.setTextColor(StyleManager.getColor(2131558554));
      }
      if (this.holder.pointDescription != null) {
        this.holder.pointDescription.setTextColor(StyleManager.getColor(2131558556));
      }
      if ((this.mPackageName != null) && (this.mResources != null))
      {
        paramInt = getHistoryIcon(paramInt);
        if (paramInt > 0)
        {
          localDrawable = this.mResources.getDrawable(paramInt);
          this.holder.pointIcon.setBackgroundDrawable(localDrawable);
          if (this.holder.travelRef != null) {
            this.holder.travelRef.setBackgroundDrawable(StyleManager.getDrawable(2130837659));
          }
        }
      }
    }
    for (;;)
    {
      if (this.holder.infoLayout != null) {}
      return;
      this.holder.pointIcon.setBackgroundDrawable(StyleManager.getDrawable(2130837977));
      break;
      this.holder.pointIcon.setBackgroundDrawable(StyleManager.getDrawable(2130837977));
      break;
      if (this.holder.pointIcon != null) {
        this.holder.pointIcon.setBackgroundDrawable(StyleManager.getDrawable(2130837977));
      }
      if (this.holder.pointName != null) {
        this.holder.pointName.setTextColor(StyleManager.getColor(2131558501));
      }
      if (this.holder.pointDescription != null) {
        this.holder.pointDescription.setTextColor(StyleManager.getColor(2131558499));
      }
      if (this.holder.travelRef != null)
      {
        localDrawable = StyleManager.getDrawable(2130837968);
        this.holder.travelRef.setBackgroundDrawable(localDrawable);
      }
    }
  }
  
  public void cleanAllHistoryDesPoi()
  {
    DBManager.clearHistoryDestFromDB(this.callback);
  }
  
  public void delRoutePlanHistoryItem(int paramInt)
  {
    if (this.mHistoryList == null) {
      return;
    }
    DBManager.deleteHistoryDestFromDB((RoutePlanNode)this.mHistoryList.get(paramInt), this.callback);
  }
  
  public int getCount()
  {
    if (this.mHistoryList == null) {
      return 0;
    }
    int i = this.mHistoryList.size();
    if (i > this.MAX_HISTORY_NUM) {
      i = this.MAX_HISTORY_NUM;
    }
    for (;;)
    {
      return i;
    }
  }
  
  public RoutePlanNode getDate(int paramInt)
  {
    LogUtil.e("navi_history", paramInt + " position:  " + paramInt);
    if ((paramInt < 0) || (paramInt >= this.mHistoryList.size())) {
      return null;
    }
    return (RoutePlanNode)this.mHistoryList.get(paramInt);
  }
  
  public int getHistoryIcon(int paramInt)
  {
    if (paramInt < 0) {
      return -1;
    }
    String str = getResourceNameById(2130838123);
    str = str + "_" + (paramInt + 1);
    return this.mResources.getIdentifier(str, "drawable", this.mPackageName);
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt > 0) && (paramInt < this.mHistoryList.size())) {
      return this.mHistoryList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = getItemView(paramView, paramInt);
    setItemContent(paramInt);
    return paramView;
  }
  
  public void hidleRefLayout()
  {
    this.hideRefLayout = true;
  }
  
  public void notifyHistoryDataSetChanged()
  {
    this.mHistoryList = this.mNaviDestHistory.getRoutePlanNode();
    refreshListViewData();
  }
  
  public void refreshListViewData()
  {
    if (this.mCleanHistoryLayout != null)
    {
      if (getCount() != 0) {
        break label50;
      }
      this.mCleanHistoryLayout.setVisibility(8);
      if (this.mListView != null) {
        this.mListView.setVisibility(4);
      }
    }
    for (;;)
    {
      notifyDataSetChanged();
      if (this.mListView != null) {}
      return;
      label50:
      if (this.mListView != null) {
        this.mListView.setVisibility(0);
      }
    }
  }
  
  public void setCarMode(boolean paramBoolean)
  {
    this.mIsCarMode = paramBoolean;
    this.mPackageName = BaiduNaviApplication.getInstance().getPackageName();
    this.mResources = BaiduNaviApplication.getInstance().getResources();
  }
  
  public void setCleanHistoryLayout(View paramView)
  {
    this.mCleanHistoryLayout = paramView;
  }
  
  public void setListView(ListView paramListView)
  {
    this.mListView = paramListView;
  }
  
  public void setOnDialogListener(e parame)
  {
    this.mOnDialogListener = parame;
  }
  
  public void setOrientation(int paramInt)
  {
    this.mOrientation = paramInt;
  }
  
  public void showCleanAllHistoryDialog()
  {
    c localc = new c(this.mContext).a(2131296261).g(17).c(2131296260).q().d(2131296259);
    localc.a(new b()
    {
      public void onClick()
      {
        HistoryDestinationAdapter.this.cleanAllHistoryDesPoi();
      }
    });
    this.mOnDialogListener.showDialog(localc);
  }
  
  public void showDelHistoryItemDialog(final int paramInt)
  {
    c localc = new c(this.mContext).a(2131296267).g(17).c(2131296264).q().d(2131296259);
    localc.a(new b()
    {
      public void onClick()
      {
        HistoryDestinationAdapter.this.delRoutePlanHistoryItem(paramInt);
      }
    });
    this.mOnDialogListener.showDialog(localc);
  }
  
  public static class ViewHolder
  {
    public LinearLayout infoLayout;
    public LinearLayout poiInfoLayout;
    public TextView pointDescription;
    public ImageView pointIcon;
    public TextView pointName;
    public ImageView travelRef;
    public LinearLayout travelRefLayout;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/adapter/HistoryDestinationAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */