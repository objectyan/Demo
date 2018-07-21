package com.baidu.navisdk.ui.routeguide.adapter;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.ui.routeguide.asr.xdvoice.XDVoiceInstructManager;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGRouteSortController;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSortModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.navisdk.util.statistic.userop.UserOPController;
import java.util.ArrayList;

public class RGRouteSortAdapter
  extends BaseAdapter
{
  private static final int NUM_COLUMNS = 3;
  private static final String TAG = RGRouteSortAdapter.class.getSimpleName();
  private int mPageFromType = 1;
  
  private int getColor(int paramInt)
  {
    if (this.mPageFromType == 1) {
      return BNStyleManager.getColor(paramInt, true);
    }
    return BNStyleManager.getColor(paramInt);
  }
  
  private Drawable getDrawable(int paramInt)
  {
    if (this.mPageFromType == 1) {
      return BNStyleManager.getDrawable(paramInt, true);
    }
    return BNStyleManager.getDrawable(paramInt);
  }
  
  public int getCount()
  {
    ArrayList localArrayList = RGRouteSortController.getInstance().getRouteSortList();
    if (localArrayList == null) {
      return 0;
    }
    return localArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    LogUtil.e(TAG, "getView position = " + paramInt);
    if (paramView == null)
    {
      paramView = JarUtils.inflate(BNaviModuleManager.getActivity(), 1711472747, null);
      if (paramView == null) {
        return paramView;
      }
      paramViewGroup = new ViewHolder();
      paramViewGroup.mItemName = ((TextView)paramView.findViewById(1711867015));
      paramViewGroup.mItemLayout = paramView;
      paramViewGroup.mItemDefaultTipsLayout = ((RelativeLayout)paramView.findViewById(1711867013));
      paramViewGroup.mItemDefaultSettingLayout = ((RelativeLayout)paramView.findViewById(1711867017));
      paramViewGroup.mVerticalDivider = paramView.findViewById(1711867016);
      paramViewGroup.mHorizontalDivider = paramView.findViewById(1711867018);
      paramView.setTag(paramViewGroup);
    }
    while ((paramViewGroup == null) || (paramViewGroup.mItemLayout == null) || (paramViewGroup.mItemName == null) || (paramViewGroup.mItemDefaultTipsLayout == null) || (paramViewGroup.mItemDefaultSettingLayout == null))
    {
      return paramView;
      paramViewGroup = (ViewHolder)paramView.getTag();
    }
    paramViewGroup.mItemLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (paramAnonymousView == null) {}
        do
        {
          do
          {
            return;
            paramAnonymousView = RGRouteSortController.getInstance().getRouteSortList();
          } while (paramAnonymousView == null);
          paramAnonymousView = (RGRouteSortModel)paramAnonymousView.get(paramInt);
        } while (paramAnonymousView == null);
        int i;
        boolean bool;
        if ((RGRouteSortController.getInstance().getPreferValue() & 0x20) != 0)
        {
          i = paramAnonymousView.mPreferValue | 0x20;
          if (i == RGRouteSortController.getInstance().getPreferValue()) {
            break label222;
          }
          bool = true;
          label64:
          if (RGRouteSortController.getInstance().mIsShowDefaultSettingBtn)
          {
            BNaviModuleManager.setLastPreferValue(i);
            BNSettingManager.setDefaultRouteSort(i);
            UserOPController.getInstance().add("2.i.3", i + "", null, null);
          }
          RGRouteSortController.getInstance().setPreferValue(i);
          BNRoutePlaner.getInstance().setCalcPrference(i);
          if (RGRouteSortAdapter.this.mPageFromType != 2) {
            break label227;
          }
          if (!RGRouteSortController.getInstance().mIsShowDefaultSettingBtn) {
            UserOPController.getInstance().add("2.i.1", i + "", "3", null);
          }
          RGViewController.getInstance().hideRouteSortView();
          if (bool)
          {
            XDVoiceInstructManager.getInstance().setWakeupEnable(false);
            RGSimpleGuideModel.getInstance();
            RGSimpleGuideModel.mCalcRouteType = 2;
            RGEngineControl.getInstance().reCalcRoute();
          }
        }
        label222:
        label227:
        while (RGRouteSortAdapter.this.mPageFromType != 1)
        {
          RGRouteSortAdapter.this.notifyDataSetChanged();
          return;
          i = paramAnonymousView.mPreferValue;
          break;
          bool = false;
          break label64;
        }
        if (!RGRouteSortController.getInstance().mIsShowDefaultSettingBtn) {
          UserOPController.getInstance().add("2.i.1", i + "", "2", null);
        }
        if (RGRouteSortController.getInstance().mIsShowDefaultSettingBtn)
        {
          BNSettingManager.setSelectedRouteSortValue(paramAnonymousView.mPreferValue);
          BNSettingManager.setSelectedRouteSortCount(0);
        }
        for (;;)
        {
          RGRouteSortController.getInstance().onClickItemAction(bool);
          break;
          if ((!BNSettingManager.hasShowRouteSortSettingGuide()) && (bool) && ((BNaviModuleManager.getLastPreferValue() & 0x1) != 0)) {
            if ((paramAnonymousView.mPreferValue & 0x1) == 0)
            {
              if (BNSettingManager.getSelectedRouteSortValue() == paramAnonymousView.mPreferValue)
              {
                BNSettingManager.setSelectedRouteSortCount(BNSettingManager.getSelectedRouteSortCount() + 1);
              }
              else
              {
                BNSettingManager.setSelectedRouteSortValue(paramAnonymousView.mPreferValue);
                BNSettingManager.setSelectedRouteSortCount(1);
              }
            }
            else
            {
              BNSettingManager.setSelectedRouteSortValue(paramAnonymousView.mPreferValue);
              BNSettingManager.setSelectedRouteSortCount(0);
            }
          }
        }
      }
    });
    paramViewGroup.mItemDefaultSettingLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (paramAnonymousView == null) {}
        do
        {
          do
          {
            return;
            paramAnonymousView = RGRouteSortController.getInstance().getRouteSortList();
          } while (paramAnonymousView == null);
          paramAnonymousView = (RGRouteSortModel)paramAnonymousView.get(paramInt);
        } while (paramAnonymousView == null);
        int i;
        if ((RGRouteSortController.getInstance().getPreferValue() & 0x20) != 0)
        {
          i = paramAnonymousView.mPreferValue | 0x20;
          BNaviModuleManager.setLastPreferValue(i);
          BNSettingManager.setDefaultRouteSort(i);
          RGRouteSortController.getInstance().setPreferValue(i);
          BNRoutePlaner.getInstance().setCalcPrference(i);
          UserOPController.getInstance().add("2.i.3", i + "", null, null);
          if (RGRouteSortAdapter.this.mPageFromType != 2) {
            break label143;
          }
          RGViewController.getInstance().hideRouteSortView();
          RGEngineControl.getInstance().reCalcRoute();
        }
        for (;;)
        {
          RGRouteSortAdapter.this.notifyDataSetChanged();
          return;
          i = paramAnonymousView.mPreferValue;
          break;
          label143:
          if (RGRouteSortAdapter.this.mPageFromType == 1)
          {
            BNSettingManager.setSelectedRouteSortValue(paramAnonymousView.mPreferValue);
            BNSettingManager.setSelectedRouteSortCount(0);
            RGRouteSortController.getInstance().onSettingDefaultAction();
          }
        }
      }
    });
    paramViewGroup.mPosition = paramInt;
    if ((paramInt + 1) % 3 == 0)
    {
      paramViewGroup.mVerticalDivider.setVisibility(4);
      if (paramInt < 3) {
        break label299;
      }
      paramViewGroup.mHorizontalDivider.setVisibility(4);
    }
    Object localObject;
    for (;;)
    {
      paramViewGroup.mVerticalDivider.setBackgroundColor(getColor(1711800789));
      paramViewGroup.mHorizontalDivider.setBackgroundColor(getColor(1711800789));
      paramViewGroup.mItemLayout.setBackgroundDrawable(getDrawable(1711407444));
      localObject = RGRouteSortController.getInstance().getRouteSortList();
      if (localObject != null) {
        break label310;
      }
      return paramView;
      paramViewGroup.mVerticalDivider.setVisibility(0);
      break;
      label299:
      paramViewGroup.mHorizontalDivider.setVisibility(0);
    }
    label310:
    Drawable localDrawable;
    if ((paramInt >= 0) && (paramInt < ((ArrayList)localObject).size()))
    {
      localObject = (RGRouteSortModel)((ArrayList)localObject).get(paramInt);
      if (localObject == null) {
        return paramView;
      }
      paramViewGroup.mItemName.setText(((RGRouteSortModel)localObject).mItemName);
      if ((RGRouteSortController.getInstance().mIsShowDefaultSettingBtn) || ((((RGRouteSortModel)localObject).mPreferValue & RGRouteSortController.getInstance().getPreferValue()) == 0)) {
        break label471;
      }
      paramViewGroup.mItemName.setTextColor(getColor(1711800777));
      localDrawable = getDrawable(RGRouteSortController.getInstance().getmPreferIconId(((RGRouteSortModel)localObject).mPreferValue, true));
      paramViewGroup.mItemName.setCompoundDrawablesWithIntrinsicBounds(null, localDrawable, null, null);
      if ((((RGRouteSortModel)localObject).mPreferValue & BNaviModuleManager.getLastPreferValue()) == 0) {
        break label517;
      }
      paramViewGroup.mItemDefaultTipsLayout.setVisibility(0);
      label440:
      if (!RGRouteSortController.getInstance().mIsShowDefaultSettingBtn) {
        break label539;
      }
      if ((((RGRouteSortModel)localObject).mPreferValue & BNaviModuleManager.getLastPreferValue()) == 0) {
        break label528;
      }
      paramViewGroup.mItemDefaultSettingLayout.setVisibility(4);
    }
    for (;;)
    {
      return paramView;
      label471:
      paramViewGroup.mItemName.setTextColor(getColor(1711800772));
      localDrawable = getDrawable(RGRouteSortController.getInstance().getmPreferIconId(((RGRouteSortModel)localObject).mPreferValue, false));
      paramViewGroup.mItemName.setCompoundDrawablesWithIntrinsicBounds(null, localDrawable, null, null);
      break;
      label517:
      paramViewGroup.mItemDefaultTipsLayout.setVisibility(4);
      break label440;
      label528:
      paramViewGroup.mItemDefaultSettingLayout.setVisibility(0);
      continue;
      label539:
      paramViewGroup.mItemDefaultSettingLayout.setVisibility(4);
    }
  }
  
  public void setPageFromType(int paramInt)
  {
    this.mPageFromType = paramInt;
  }
  
  public class ViewHolder
  {
    public View mHorizontalDivider;
    public RelativeLayout mItemDefaultSettingLayout;
    public RelativeLayout mItemDefaultTipsLayout;
    public View mItemLayout;
    public TextView mItemName;
    public int mPosition;
    public View mVerticalDivider;
    
    public ViewHolder() {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/adapter/RGRouteSortAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */