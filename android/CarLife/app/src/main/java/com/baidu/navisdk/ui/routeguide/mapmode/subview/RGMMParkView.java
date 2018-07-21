package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.model.datastruct.SearchParkPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.jar.JarUtils;
import java.util.ArrayList;

public class RGMMParkView
  extends BNBaseView
{
  private static String TAG = RGMMParkView.class.getName();
  private View bgView;
  private TextView cancelBtn;
  private View dividerView;
  private TextView infoTv;
  private Handler mHandler = null;
  private ViewGroup mParkContainer = null;
  private SearchParkPoi nearPoi = null;
  private TextView stopBtn;
  private View view;
  
  public RGMMParkView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initViews();
    updateStyle(BNStyleManager.getDayStyle());
  }
  
  private SearchParkPoi getNearestParkPoi()
  {
    ArrayList localArrayList = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getSearchParkPoi();
    if ((localArrayList == null) || (localArrayList.size() == 0)) {}
    int j;
    do
    {
      return null;
      int m = 10000;
      j = 0;
      int i = 0;
      while (i < localArrayList.size())
      {
        SearchParkPoi localSearchParkPoi = (SearchParkPoi)localArrayList.get(i);
        int n = m;
        int k = j;
        if (localSearchParkPoi != null)
        {
          n = m;
          k = j;
          if (localSearchParkPoi.mDistance < m)
          {
            n = localSearchParkPoi.mDistance;
            k = i;
          }
        }
        i += 1;
        m = n;
        j = k;
      }
    } while (j >= localArrayList.size());
    return (SearchParkPoi)localArrayList.get(j);
  }
  
  private void initViews()
  {
    LogUtil.e(TAG, "initViews()");
    if (this.mRootViewGroup == null) {}
    do
    {
      do
      {
        return;
        this.mParkContainer = ((ViewGroup)this.mRootViewGroup.findViewById(1711866623));
      } while (this.mParkContainer == null);
      this.nearPoi = getNearestParkPoi();
    } while ((this.nearPoi == null) || (BNaviModuleManager.getActivity() == null) || (this.view != null));
    this.mParkContainer.removeAllViewsInLayout();
    this.view = JarUtils.inflate(BNaviModuleManager.getActivity(), 1711472733, null);
    Object localObject = new FrameLayout.LayoutParams(-1, -1);
    this.mParkContainer.addView(this.view, (ViewGroup.LayoutParams)localObject);
    this.bgView = this.view.findViewById(1711866906);
    this.dividerView = this.view.findViewById(1711866907);
    this.infoTv = ((TextView)this.view.findViewById(1711866908));
    if (this.nearPoi.mLeftCnt > 0) {}
    for (localObject = String.format("%1$d个空车位，距离终点%2$d米", new Object[] { Integer.valueOf(this.nearPoi.mLeftCnt), Integer.valueOf(this.nearPoi.mDistance) });; localObject = String.format("停车场距终点%1$d米", new Object[] { Integer.valueOf(this.nearPoi.mDistance) }))
    {
      this.infoTv.setText((CharSequence)localObject);
      this.stopBtn = ((TextView)this.view.findViewById(1711866909));
      this.stopBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410298", "410298");
          BNavigator.getInstance().setmCanParkShow(false);
          paramAnonymousView = RGMMParkView.this.nearPoi.mGuidePoint;
          BNRoutePlaner.getInstance().setGuideSceneType(4);
          RGSimpleGuideModel.getInstance();
          RGSimpleGuideModel.mCalcRouteType = 4;
          RGEngineControl.getInstance().setEndPtToCalcRoute(paramAnonymousView);
          LogUtil.e("asrpark", "stopBtn onClick");
        }
      });
      this.cancelBtn = ((TextView)this.view.findViewById(1711866910));
      this.cancelBtn.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          BNavigator.getInstance().setmCanParkShow(false);
          RGViewController.getInstance().requestShowExpendView(2, false);
          LogUtil.e("asrpark", "cancelBtn onClick");
        }
      });
      return;
    }
  }
  
  public void hide()
  {
    super.hide();
    LogUtil.e(TAG, "onHide()");
    if ((this.mParkContainer != null) && (this.view != null))
    {
      this.mParkContainer.setVisibility(8);
      this.view.setVisibility(8);
    }
  }
  
  public void show()
  {
    super.show();
    LogUtil.e(TAG, "onShow()");
    if ((this.mParkContainer != null) && (this.view != null)) {
      this.mParkContainer.setVisibility(0);
    }
    if (this.mHandler == null) {
      this.mHandler = new Handler();
    }
  }
  
  public void updateStyle(boolean paramBoolean)
  {
    super.updateStyle(paramBoolean);
    if (this.bgView != null) {
      this.bgView.setBackgroundColor(BNStyleManager.getColor(1711800694));
    }
    if (this.dividerView != null) {
      this.dividerView.setBackgroundColor(BNStyleManager.getColor(1711800690));
    }
    if (this.infoTv != null) {
      this.infoTv.setTextColor(BNStyleManager.getColor(1711800674));
    }
    if (this.stopBtn != null)
    {
      this.stopBtn.setTextColor(BNStyleManager.getColor(1711800682));
      this.stopBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407113));
    }
    if (this.cancelBtn != null)
    {
      this.cancelBtn.setTextColor(BNStyleManager.getColor(1711800674));
      this.cancelBtn.setBackgroundDrawable(BNStyleManager.getDrawable(1711407148));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMParkView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */