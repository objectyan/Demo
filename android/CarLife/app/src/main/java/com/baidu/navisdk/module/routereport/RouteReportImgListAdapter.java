package com.baidu.navisdk.module.routereport;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.ui.util.UIUtils;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

public class RouteReportImgListAdapter
  extends BaseAdapter
{
  private static final String TAG = RouteReportImgListAdapter.class.getSimpleName();
  private GridView mBindedView;
  private GridViewCallback mCallback;
  private Activity mContext;
  private int mCurrentSelectedItem = -1;
  private ArrayList<BNRouteReportModel.RouteReportItem> mRouteReportItemsList;
  View.OnClickListener onClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if ((paramAnonymousView == null) || (paramAnonymousView.getTag() == null)) {}
      do
      {
        do
        {
          return;
          paramAnonymousView = (RouteReportImgListAdapter.ViewHolder)paramAnonymousView.getTag();
        } while (paramAnonymousView.mImgView == null);
        LogUtil.e(RouteReportImgListAdapter.TAG, "onClick: item --> " + paramAnonymousView.position + ", mCurrentSelectedItem = " + RouteReportImgListAdapter.this.mCurrentSelectedItem);
      } while ((paramAnonymousView.position < 0) || (paramAnonymousView.position >= RouteReportImgListAdapter.this.mRouteReportItemsList.size()));
      BNRouteReportModel.RouteReportItem localRouteReportItem = (BNRouteReportModel.RouteReportItem)RouteReportImgListAdapter.this.mRouteReportItemsList.get(paramAnonymousView.position);
      if (RouteReportImgListAdapter.this.mCallback != null) {
        RouteReportImgListAdapter.this.mCallback.onItemClick(paramAnonymousView.position, localRouteReportItem);
      }
      RouteReportImgListAdapter.access$102(RouteReportImgListAdapter.this, paramAnonymousView.position);
    }
  };
  
  public RouteReportImgListAdapter(Activity paramActivity, ArrayList<BNRouteReportModel.RouteReportItem> paramArrayList, GridViewCallback paramGridViewCallback)
  {
    this.mContext = paramActivity;
    this.mRouteReportItemsList = paramArrayList;
    this.mCallback = paramGridViewCallback;
  }
  
  public int getCount()
  {
    return this.mRouteReportItemsList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.mRouteReportItemsList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    BNRouteReportModel.RouteReportItem localRouteReportItem;
    TextView localTextView;
    if (paramView == null)
    {
      paramView = JarUtils.inflate(this.mContext, 1711472745, null);
      if (paramView == null) {
        return null;
      }
      paramViewGroup = new ViewHolder();
      paramViewGroup.mImgView = ((ImageView)paramView.findViewById(1711867009));
      paramViewGroup.mTextView = ((TextView)paramView.findViewById(1711867010));
      paramView.setTag(paramViewGroup);
      paramViewGroup.position = paramInt;
      if (paramView != null) {
        paramView.setOnClickListener(this.onClickListener);
      }
      if ((this.mRouteReportItemsList != null) && (this.mRouteReportItemsList.size() > paramInt))
      {
        localRouteReportItem = (BNRouteReportModel.RouteReportItem)this.mRouteReportItemsList.get(paramInt);
        if (localRouteReportItem != null)
        {
          localTextView = paramViewGroup.mTextView;
          if (localRouteReportItem.mTitle != null) {
            break label174;
          }
        }
      }
    }
    label174:
    for (String str = "";; str = localRouteReportItem.mTitle)
    {
      localTextView.setText(str);
      BNRouteReportController.setupUrlDrawable(paramViewGroup.mImgView, BNRouteReportModel.getInstance().getDefaultResId(localRouteReportItem.mType), localRouteReportItem.mIconUrl);
      return paramView;
      paramViewGroup = (ViewHolder)paramView.getTag();
      break;
    }
  }
  
  public void releaseBitmapRes()
  {
    if (this.mBindedView != null)
    {
      LogUtil.e(TAG, "releaseBitmapRes:  --> ");
      int i = 0;
      while (i < this.mRouteReportItemsList.size())
      {
        View localView = this.mBindedView.getChildAt(i);
        if (localView != null) {
          UIUtils.releaseImageViewWithoutNull(((ViewHolder)localView.getTag()).mImgView);
        }
        i += 1;
      }
    }
  }
  
  public void setBindedView(GridView paramGridView)
  {
    this.mBindedView = paramGridView;
  }
  
  public static abstract interface GridViewCallback
  {
    public abstract void onItemClick(int paramInt, BNRouteReportModel.RouteReportItem paramRouteReportItem);
  }
  
  public static class ViewHolder
  {
    public ImageView mImgView;
    public TextView mTextView;
    public int position;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/routereport/RouteReportImgListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */