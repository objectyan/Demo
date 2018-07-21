package com.baidu.navisdk.module.routereport;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

public class RouteReportTextListAdapter
  extends BaseAdapter
{
  private static final String TAG = RouteReportImgListAdapter.class.getSimpleName();
  private GridView mBindedView;
  private GridViewCallback mCallback;
  private Activity mContext;
  private int mCurrentSelectedItem = -1;
  private ArrayList<BNRouteReportModel.RouteReportItem> mRouteReportItemsList;
  
  public RouteReportTextListAdapter(Activity paramActivity, ArrayList<BNRouteReportModel.RouteReportItem> paramArrayList, GridViewCallback paramGridViewCallback)
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
    Object localObject;
    if (paramView == null)
    {
      paramView = JarUtils.inflate(this.mContext, 1711472746, null);
      if (paramView == null) {
        return null;
      }
      paramViewGroup = new ViewHolder();
      paramViewGroup.mGridContainer = paramView.findViewById(1711867011);
      paramViewGroup.mTextView = ((TextView)paramView.findViewById(1711867010));
      paramViewGroup.mSuperscript = ((ImageView)paramView.findViewById(1711867012));
      paramView.setTag(paramViewGroup);
      paramViewGroup.position = paramInt;
      if ((this.mRouteReportItemsList != null) && (this.mRouteReportItemsList.size() > paramInt))
      {
        localObject = (BNRouteReportModel.RouteReportItem)this.mRouteReportItemsList.get(paramInt);
        if (localObject != null)
        {
          TextView localTextView = paramViewGroup.mTextView;
          if (((BNRouteReportModel.RouteReportItem)localObject).mTitle != null) {
            break label198;
          }
          localObject = "";
          label129:
          localTextView.setText((CharSequence)localObject);
        }
      }
      if (paramInt != this.mCurrentSelectedItem) {
        break label208;
      }
      paramViewGroup.setSuperscriptShow(true);
      paramViewGroup.mTextView.setTextColor(Color.parseColor("#3385ff"));
      paramViewGroup.mGridContainer.setBackgroundDrawable(BNStyleManager.getDrawable(1711408085));
    }
    for (;;)
    {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          paramAnonymousView = (RouteReportTextListAdapter.ViewHolder)paramAnonymousView.getTag();
          LogUtil.e(RouteReportTextListAdapter.TAG, "onClick: item --> " + paramAnonymousView.position + ", mCurrentSelectedItem = " + RouteReportTextListAdapter.this.mCurrentSelectedItem);
          if ((paramAnonymousView.position >= 0) && (paramAnonymousView.position < RouteReportTextListAdapter.this.mRouteReportItemsList.size()))
          {
            Object localObject = (BNRouteReportModel.RouteReportItem)RouteReportTextListAdapter.this.mRouteReportItemsList.get(paramAnonymousView.position);
            if (RouteReportTextListAdapter.this.mCallback != null) {
              RouteReportTextListAdapter.this.mCallback.onItemClick(paramAnonymousView.position, (BNRouteReportModel.RouteReportItem)localObject);
            }
            if ((((BNRouteReportModel.RouteReportItem)localObject).mIsSubType) && (paramAnonymousView.position != RouteReportTextListAdapter.this.mCurrentSelectedItem))
            {
              if ((RouteReportTextListAdapter.this.mBindedView != null) && (RouteReportTextListAdapter.this.mCurrentSelectedItem >= 0) && (RouteReportTextListAdapter.this.mCurrentSelectedItem < RouteReportTextListAdapter.this.mRouteReportItemsList.size()))
              {
                localObject = (RouteReportTextListAdapter.ViewHolder)RouteReportTextListAdapter.this.mBindedView.getChildAt(RouteReportTextListAdapter.this.mCurrentSelectedItem).getTag();
                ((RouteReportTextListAdapter.ViewHolder)localObject).setSuperscriptShow(false);
                ((RouteReportTextListAdapter.ViewHolder)localObject).mTextView.setTextColor(Color.parseColor("#333333"));
                ((RouteReportTextListAdapter.ViewHolder)localObject).mGridContainer.setBackgroundDrawable(BNStyleManager.getDrawable(1711408084));
              }
              paramAnonymousView.setSuperscriptShow(true);
              paramAnonymousView.mTextView.setTextColor(Color.parseColor("#3385ff"));
              paramAnonymousView.mGridContainer.setBackgroundDrawable(BNStyleManager.getDrawable(1711408085));
            }
            RouteReportTextListAdapter.access$102(RouteReportTextListAdapter.this, paramAnonymousView.position);
          }
        }
      });
      return paramView;
      paramViewGroup = (ViewHolder)paramView.getTag();
      break;
      label198:
      localObject = ((BNRouteReportModel.RouteReportItem)localObject).mTitle;
      break label129;
      label208:
      paramViewGroup.setSuperscriptShow(false);
      paramViewGroup.mTextView.setTextColor(Color.parseColor("#333333"));
      paramViewGroup.mGridContainer.setBackgroundDrawable(BNStyleManager.getDrawable(1711408084));
    }
  }
  
  public void setBindedView(GridView paramGridView)
  {
    this.mBindedView = paramGridView;
  }
  
  public void setCurrentSelectedItem(String paramString)
  {
    if (paramString == null) {
      this.mCurrentSelectedItem = -1;
    }
    for (;;)
    {
      return;
      if ((this.mRouteReportItemsList != null) && (this.mRouteReportItemsList.size() > 0))
      {
        int i = 0;
        while (i < this.mRouteReportItemsList.size())
        {
          BNRouteReportModel.RouteReportItem localRouteReportItem = (BNRouteReportModel.RouteReportItem)this.mRouteReportItemsList.get(i);
          if ((localRouteReportItem != null) && (paramString.equals("" + localRouteReportItem.mType))) {
            this.mCurrentSelectedItem = i;
          }
          i += 1;
        }
      }
    }
  }
  
  public static abstract interface GridViewCallback
  {
    public abstract void onItemClick(int paramInt, BNRouteReportModel.RouteReportItem paramRouteReportItem);
  }
  
  public static class ViewHolder
  {
    public View mGridContainer;
    public ImageView mSuperscript;
    public TextView mTextView;
    public int position;
    
    public void setSuperscriptShow(boolean paramBoolean)
    {
      ImageView localImageView;
      if (this.mSuperscript != null)
      {
        localImageView = this.mSuperscript;
        if (!paramBoolean) {
          break label24;
        }
      }
      label24:
      for (int i = 0;; i = 8)
      {
        localImageView.setVisibility(i);
        return;
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/routereport/RouteReportTextListAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */