package com.baidu.navi.routedetails;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.routeguide.control.RGRouteSortController;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSortModel;
import java.util.ArrayList;

public class RoutePlanPreferenceDialogAdapter
  extends BaseAdapter
{
  private static final String TAG = "RoutePlanPreferenceDialogAdapter";
  private Context mContext;
  private AdapterView.OnItemClickListener mOnItemClickListener = new AdapterView.OnItemClickListener()
  {
    public void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
    {
      if ((RoutePlanPreferenceDialogAdapter.this.routeSortList == null) || (RoutePlanPreferenceDialogAdapter.this.routeSortList.size() <= paramAnonymousInt) || (RoutePlanPreferenceDialogAdapter.this.routeSortList.size() < 0)) {}
      do
      {
        return;
        paramAnonymousAdapterView = (RGRouteSortModel)RoutePlanPreferenceDialogAdapter.this.routeSortList.get(paramAnonymousInt);
      } while (paramAnonymousAdapterView == null);
      if ((RGRouteSortController.getInstance().getPreferValue() & 0x20) != 0)
      {
        paramAnonymousInt = paramAnonymousAdapterView.mPreferValue | 0x20;
        label77:
        if (paramAnonymousInt == RGRouteSortController.getInstance().getPreferValue()) {
          break label153;
        }
      }
      label153:
      for (int i = 1;; i = 0)
      {
        BNaviModuleManager.setLastPreferValue(paramAnonymousInt);
        BNSettingManager.setDefaultRouteSort(paramAnonymousInt);
        RGRouteSortController.getInstance().setPreferValue(paramAnonymousInt);
        BNRoutePlaner.getInstance().setCalcPrference(paramAnonymousInt);
        if ((i == 0) || (RoutePlanPreferenceDialogAdapter.this.mRoutePlanModel == null)) {
          break;
        }
        BNRoutePlaner.getInstance().setPointsToCalcRoute(RoutePlanPreferenceDialogAdapter.this.mRoutePlanModel.getRouteInput(), 0);
        return;
        paramAnonymousInt = paramAnonymousAdapterView.mPreferValue;
        break label77;
      }
    }
  };
  private RoutePlanModel mRoutePlanModel = null;
  private ArrayList<RGRouteSortModel> routeSortList;
  
  public RoutePlanPreferenceDialogAdapter(Context paramContext)
  {
    this.mContext = paramContext;
    this.routeSortList = RGRouteSortController.getInstance().getRouteSortList();
    this.mRoutePlanModel = ((RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel"));
  }
  
  public int getCount()
  {
    this.routeSortList = RGRouteSortController.getInstance().getRouteSortList();
    if (this.routeSortList == null) {
      return 0;
    }
    return this.routeSortList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.routeSortList != null) && (this.routeSortList.size() > paramInt)) {
      return this.routeSortList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public AdapterView.OnItemClickListener getOnItemClickListener()
  {
    return this.mOnItemClickListener;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = new ViewHolder(null);
    paramViewGroup = LayoutInflater.from(this.mContext).inflate(2130969003, null);
    paramView.tvItemName = ((TextView)paramViewGroup.findViewById(2131624662));
    paramView.line = paramViewGroup.findViewById(2131624067);
    paramView.ivItemCheck = ((ImageView)paramViewGroup.findViewById(2131626030));
    if (this.routeSortList == null) {}
    RGRouteSortModel localRGRouteSortModel;
    do
    {
      do
      {
        return paramViewGroup;
      } while ((paramInt < 0) || (paramInt >= this.routeSortList.size()));
      localRGRouteSortModel = (RGRouteSortModel)this.routeSortList.get(paramInt);
    } while (localRGRouteSortModel == null);
    paramView.tvItemName.setText(localRGRouteSortModel.mItemName);
    if ((localRGRouteSortModel.mPreferValue & RGRouteSortController.getInstance().getPreferValue()) != 0) {}
    for (paramInt = 0;; paramInt = 8)
    {
      paramView.ivItemCheck.setVisibility(paramInt);
      return paramViewGroup;
    }
  }
  
  private static class ViewHolder
  {
    ImageView ivItemCheck;
    View line;
    TextView tvItemName;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/routedetails/RoutePlanPreferenceDialogAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */