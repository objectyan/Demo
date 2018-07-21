package com.baidu.navi.adapter;

import android.app.Activity;
import android.content.Context;
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
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.view.dialog.m.a;
import com.baidu.carlife.view.dialog.o;
import com.baidu.navi.controller.RouteCustomController;
import com.baidu.navi.fragment.RoutePlanFragment;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.ListViewUtils;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.db.DBManager;
import com.baidu.navisdk.util.db.DBManager.DBOperateResultCallback;
import com.baidu.navisdk.util.db.model.NaviRouteHistoryModel;
import com.baidu.navisdk.util.db.model.RouteCustomModel;
import com.baidu.navisdk.util.db.object.NaviRouteDBObject;
import com.baidu.navisdk.util.db.object.RouteCustomDBObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistoryRouteAdapter
  extends BaseAdapter
{
  private static final String TAG = "HistoryRouteAdapter";
  private DBManager.DBOperateResultCallback callback = new DBManager.DBOperateResultCallback()
  {
    public void onAddOrDeleteSuccess()
    {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          HistoryRouteAdapter.this.notifyHistoryDataSetChanged();
        }
      });
    }
    
    public void onQuerySuccess()
    {
      new Handler(Looper.getMainLooper()).post(new Runnable()
      {
        public void run()
        {
          HistoryRouteAdapter.this.notifyHistoryDataSetChanged();
        }
      });
    }
  };
  ViewHolder holder;
  private View mCleanHistoryLayout;
  private Context mContext;
  RoutePlanFragment mFragment;
  private ArrayList<NaviRouteDBObject> mHistoryList;
  private LayoutInflater mInflater;
  private ListView mListView;
  private NaviRouteHistoryModel mNaviRouteHistory;
  private int mOrientation;
  private NaviRouteDBObject mRoutePlanNode;
  
  public HistoryRouteAdapter(CarlifeActivity paramCarlifeActivity, RoutePlanFragment paramRoutePlanFragment)
  {
    this.mContext = paramCarlifeActivity;
    this.mFragment = paramRoutePlanFragment;
    this.mInflater = ((LayoutInflater)this.mContext.getSystemService("layout_inflater"));
    this.mNaviRouteHistory = NaviRouteHistoryModel.getInstance();
    this.mHistoryList = new ArrayList();
    if (this.mNaviRouteHistory.getNaviRouteList() == null) {
      DBManager.getAllHistoryRoutes(this.callback);
    }
  }
  
  private View getItemView(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      this.holder = new ViewHolder();
      paramView = this.mInflater.inflate(2130968957, null);
      this.holder.infoLayout = ((LinearLayout)paramView.findViewById(2131624558));
      this.holder.routeInfo = ((TextView)paramView.findViewById(2131624561));
      this.holder.routeTimeInfo = ((TextView)paramView.findViewById(2131624562));
      this.holder.routeTimeIcon = ((ImageView)paramView.findViewById(2131625843));
      this.holder.routeCustomEnterLayout = ((LinearLayout)paramView.findViewById(2131624559));
      this.holder.routeCustomEnterIcon = ((ImageView)paramView.findViewById(2131624560));
      paramView.setTag(this.holder);
    }
    for (;;)
    {
      this.holder.routeCustomEnterLayout.setTag(Integer.valueOf(paramInt));
      this.holder.routeCustomEnterLayout.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          int i = ((Integer)paramAnonymousView.getTag()).intValue();
          if ((HistoryRouteAdapter.this.mHistoryList == null) || (HistoryRouteAdapter.this.mHistoryList.size() == 0)) {}
          while ((i >= HistoryRouteAdapter.this.mHistoryList.size()) || (i < 0)) {
            return;
          }
          RouteCustomController.getInstance().setCurRouteInfoByRouteSubcribeResult(((NaviRouteDBObject)HistoryRouteAdapter.this.mHistoryList.get(i)).getRoutePlanNodes(), 3, ((NaviRouteDBObject)HistoryRouteAdapter.this.mHistoryList.get(i)).getId());
          HistoryRouteAdapter.this.mFragment.jumpRouteCustomDetail(i);
        }
      });
      updateStyle();
      return paramView;
      this.holder = ((ViewHolder)paramView.getTag());
    }
  }
  
  private String getRoutePlanNodeName(RoutePlanNode paramRoutePlanNode)
  {
    String str = "";
    if (paramRoutePlanNode == null) {
      str = StyleManager.getString(2131296709);
    }
    if (paramRoutePlanNode.isNodeSettedData())
    {
      if (StringUtils.isEmpty(paramRoutePlanNode.mName)) {
        str = StyleManager.getString(2131296709);
      }
    }
    else {
      return str;
    }
    return paramRoutePlanNode.mName;
  }
  
  private void setItemContent(int paramInt)
  {
    if ((this.mHistoryList == null) || (paramInt >= this.mHistoryList.size())) {
      LogUtil.e("HistoryRouteAdapter", "setItemContent()..................mHistoryList is null");
    }
    do
    {
      return;
      this.mRoutePlanNode = ((NaviRouteDBObject)this.mHistoryList.get(paramInt));
    } while (this.mRoutePlanNode == null);
    Object localObject = this.mRoutePlanNode.getRoutePlanNodes();
    long l = this.mRoutePlanNode.getTime();
    String str1 = getHistoryRouteDetailInfo((List)localObject);
    String str2 = getHistoryRouteTimeStr(l);
    localObject = str1;
    if (StringUtils.isEmpty(str1)) {
      localObject = this.mContext.getString(2131296411);
    }
    if (this.holder.routeInfo != null) {
      this.holder.routeInfo.setText((CharSequence)localObject);
    }
    if (this.holder.routeTimeInfo != null)
    {
      if ((str2 == null) || (str2.length() <= 0)) {
        break label235;
      }
      this.holder.routeTimeInfo.setText(str2);
      this.holder.routeTimeInfo.setVisibility(0);
    }
    for (;;)
    {
      paramInt = this.mRoutePlanNode.getId();
      int i = RouteCustomModel.getInstance().getExistRouteIndexByHisRouteDBId(paramInt);
      if (i < 0) {
        break label278;
      }
      paramInt = 0;
      localObject = RouteCustomModel.getInstance().getRouteCustomInfoByPos(i);
      if (localObject != null) {
        paramInt = ((RouteCustomDBObject)localObject).getOpen();
      }
      if (paramInt != 1) {
        break;
      }
      this.holder.routeCustomEnterIcon.setBackgroundDrawable(StyleManager.getDrawable(2130837873));
      return;
      label235:
      this.holder.routeTimeInfo.setText(null);
      this.holder.routeTimeInfo.setVisibility(8);
    }
    this.holder.routeCustomEnterIcon.setBackgroundDrawable(StyleManager.getDrawable(2130837934));
    return;
    label278:
    this.holder.routeCustomEnterIcon.setBackgroundDrawable(StyleManager.getDrawable(2130837934));
  }
  
  private void updateStyle()
  {
    if (this.holder.infoLayout != null) {
      this.holder.infoLayout.setBackgroundDrawable(StyleManager.getDrawable(2130838558));
    }
    if (this.holder.routeInfo != null) {
      this.holder.routeInfo.setTextColor(StyleManager.getColor(2131558501));
    }
    if (this.holder.routeTimeInfo != null) {
      this.holder.routeTimeInfo.setTextColor(StyleManager.getColor(2131558499));
    }
    Drawable localDrawable;
    if (this.holder.routeTimeIcon != null)
    {
      localDrawable = StyleManager.getDrawable(2130838556);
      this.holder.routeTimeIcon.setBackgroundDrawable(localDrawable);
    }
    if (this.holder.routeCustomEnterIcon != null)
    {
      localDrawable = StyleManager.getDrawable(2130837934);
      this.holder.routeCustomEnterIcon.setBackgroundDrawable(localDrawable);
    }
  }
  
  public void clearHistoryRouteAndNotifyChanged()
  {
    DBManager.clearAllHistoryRoutesFromDB(this.callback);
  }
  
  public int getCount()
  {
    if (this.mHistoryList == null) {
      return 0;
    }
    return this.mHistoryList.size();
  }
  
  public NaviRouteDBObject getDate(int paramInt)
  {
    LogUtil.e("navi_history", paramInt + " position:  " + paramInt);
    if ((paramInt < 0) || (paramInt >= this.mHistoryList.size())) {
      return null;
    }
    return (NaviRouteDBObject)this.mHistoryList.get(paramInt);
  }
  
  public String getHistoryRouteDetailInfo(List<RoutePlanNode> paramList)
  {
    String str = "";
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    int j = paramList.size();
    int i = 0;
    while (i < j - 1)
    {
      str = str + getRoutePlanNodeName((RoutePlanNode)paramList.get(i)) + " - ";
      i += 1;
    }
    return str + getRoutePlanNodeName((RoutePlanNode)paramList.get(j - 1));
  }
  
  public String getHistoryRouteTimeStr(long paramLong)
  {
    long l = System.currentTimeMillis();
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    Date localDate1 = new Date(l);
    Date localDate2 = new Date(paramLong);
    if (localSimpleDateFormat.format(localDate1).equalsIgnoreCase(localSimpleDateFormat.format(localDate2))) {}
    for (localSimpleDateFormat = new SimpleDateFormat("HH:mm");; localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm")) {
      return localSimpleDateFormat.format(new Date(paramLong));
    }
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public ArrayList<RoutePlanNode> getRoutePoiInfo(int paramInt)
  {
    NaviRouteDBObject localNaviRouteDBObject = getDate(paramInt);
    if (localNaviRouteDBObject == null) {
      return null;
    }
    return localNaviRouteDBObject.getRoutePlanNodes();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = getItemView(paramView, paramInt);
    setItemContent(paramInt);
    return paramView;
  }
  
  public void notifyHistoryDataSetChanged()
  {
    this.mHistoryList = this.mNaviRouteHistory.getNaviRouteList();
    refreshListViewData();
  }
  
  public void refreshListViewData()
  {
    if (this.mCleanHistoryLayout != null)
    {
      int i = getCount();
      LogUtil.e("HistoryRouteAdapter", "refreshListViewData()..........count = " + i);
      if (i != 0) {
        break label69;
      }
      this.mCleanHistoryLayout.setVisibility(8);
    }
    for (;;)
    {
      notifyDataSetChanged();
      if (this.mListView != null) {
        ListViewUtils.setListViewHeightBasedOnChildren(this.mListView);
      }
      return;
      label69:
      this.mCleanHistoryLayout.setVisibility(0);
    }
  }
  
  public void removeRoutePoiInfoPosition(int paramInt)
  {
    DBManager.deleteHistoryRouteFromDB(paramInt, this.callback);
  }
  
  public void setCleanHistoryLayout(View paramView)
  {
    this.mCleanHistoryLayout = paramView;
  }
  
  public void setListView(ListView paramListView)
  {
    this.mListView = paramListView;
  }
  
  public void setOrientation(int paramInt)
  {
    this.mOrientation = paramInt;
  }
  
  public void showCleanAllHistoryDialog()
  {
    o localo = new o((Activity)this.mContext).f(2131296267).j(2131296259).k(2131296264).d(new m.a()
    {
      public void onClick()
      {
        HistoryRouteAdapter.this.clearHistoryRouteAndNotifyChanged();
      }
    });
    this.mFragment.showDialog(localo);
  }
  
  public void showDelHistoryItemDialog(final int paramInt)
  {
    o localo = new o((Activity)this.mContext).f(2131296267).j(2131296259).k(2131296264).d(new m.a()
    {
      public void onClick()
      {
        HistoryRouteAdapter.this.removeRoutePoiInfoPosition(paramInt);
      }
    });
    this.mFragment.showDialog(localo);
  }
  
  public static class ViewHolder
  {
    public LinearLayout infoLayout;
    public ImageView routeCustomEnterIcon;
    public LinearLayout routeCustomEnterLayout;
    public TextView routeInfo;
    public ImageView routeTimeIcon;
    public TextView routeTimeInfo;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/adapter/HistoryRouteAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */