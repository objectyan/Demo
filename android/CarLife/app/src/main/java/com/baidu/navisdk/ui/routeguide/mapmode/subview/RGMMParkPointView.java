package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.model.datastruct.SearchParkPoi;
import com.baidu.navisdk.model.datastruct.SearchParkPoi.SearchParkKindEnum;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.model.RGParkPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGSimpleGuideModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.common.StringUtils;
import com.baidu.navisdk.util.drawable.DrawableUtils;
import com.baidu.navisdk.util.jar.JarUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.ItemizedOverlayUtil;
import com.baidu.nplatform.comapi.map.ItemizedOverlayUtil.OnTapListener;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import com.baidu.nplatform.comapi.map.OverlayItem;

public class RGMMParkPointView
  extends BNBaseView
{
  public static final int POINT_VIEW_OFFSET = 20;
  private static final int POPUP_LEFT_AREA = 0;
  private static final int POPUP_RIGHT_AREA = 1;
  public static final int SCREEN_Y_OFFSET = 58;
  private static String TAG = RGMMParkPointView.class.getName();
  private LinearLayout mParkInfoLL = null;
  private TextView mPickPointAddr = null;
  private View mPickPointLayout = null;
  private TextView mPickPointName = null;
  private View mPickPointPanel = null;
  private TextView mSetParkView = null;
  
  public RGMMParkPointView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initViews();
    updateStyle(BNStyleManager.getDayStyle());
  }
  
  private boolean getHasDetailInfo(SearchParkPoi paramSearchParkPoi)
  {
    if (paramSearchParkPoi == null) {}
    do
    {
      return false;
      if (paramSearchParkPoi.mLeftCnt > 0) {
        return true;
      }
      if (paramSearchParkPoi.mParkKind != SearchParkPoi.SearchParkKindEnum.Search_ParkKind_Unknown) {
        return true;
      }
    } while (StringUtils.isEmpty(paramSearchParkPoi.mOpenTime));
    return true;
  }
  
  private Bundle getLeftContentSizeBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("l", 0);
    localBundle.putInt("r", getLeftWidth());
    localBundle.putInt("t", getLeftHeight() + ScreenUtil.getInstance().dip2px(40));
    localBundle.putInt("b", ScreenUtil.getInstance().dip2px(40));
    return localBundle;
  }
  
  private int getLeftHeight()
  {
    if (this.mParkInfoLL == null) {
      return 0;
    }
    return this.mParkInfoLL.getMeasuredHeight();
  }
  
  private int getLeftWidth()
  {
    if (this.mParkInfoLL == null) {
      return 0;
    }
    return this.mParkInfoLL.getMeasuredWidth();
  }
  
  private Bundle getRightContentSizeBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("l", getLeftWidth());
    localBundle.putInt("r", getLeftWidth() + getRightWidth());
    localBundle.putInt("t", getRightHeight() + ScreenUtil.getInstance().dip2px(40));
    localBundle.putInt("b", ScreenUtil.getInstance().dip2px(40));
    return localBundle;
  }
  
  private int getRightHeight()
  {
    if (this.mSetParkView == null) {
      return 0;
    }
    return this.mSetParkView.getMeasuredHeight();
  }
  
  private int getRightWidth()
  {
    if (this.mSetParkView == null) {
      return 0;
    }
    return this.mSetParkView.getMeasuredWidth();
  }
  
  private void initViews()
  {
    if (this.mRootViewGroup == null) {
      return;
    }
    ViewStub localViewStub = (ViewStub)this.mRootViewGroup.findViewById(1711866520);
    if (localViewStub != null) {
      localViewStub.inflate();
    }
    this.mPickPointLayout = this.mRootViewGroup.findViewById(1711866631);
    this.mPickPointPanel = this.mRootViewGroup.findViewById(1711866632);
    this.mParkInfoLL = ((LinearLayout)this.mRootViewGroup.findViewById(1711866633));
    this.mPickPointName = ((TextView)this.mRootViewGroup.findViewById(1711866635));
    this.mPickPointAddr = ((TextView)this.mRootViewGroup.findViewById(1711866636));
    this.mSetParkView = ((TextView)this.mRootViewGroup.findViewById(1711866634));
  }
  
  public void hide()
  {
    super.hide();
    RGParkPointModel.getInstance().updateParkPoi(null);
    ItemizedOverlayUtil.getInstance().removeAllItems();
    ItemizedOverlayUtil.getInstance().hide();
    ItemizedOverlayUtil.getInstance().setOnTapListener(null);
  }
  
  public void orientationChanged(ViewGroup paramViewGroup, int paramInt)
  {
    super.orientationChanged(paramViewGroup, paramInt);
    initViews();
    updateStyle(BNStyleManager.getDayStyle());
  }
  
  public void show()
  {
    super.show();
  }
  
  public void updateData(Bundle paramBundle)
  {
    LogUtil.e(TAG, "updateData()");
    Object localObject = RGParkPointModel.getInstance().getParkPoi();
    if ((localObject != null) && (((SearchParkPoi)localObject).mName.length() > 0) && (this.mPickPointName != null) && (this.mPickPointAddr != null) && (this.mPickPointLayout != null))
    {
      this.mPickPointName.setText(((SearchParkPoi)localObject).mName);
      TextView localTextView = this.mPickPointAddr;
      if (((SearchParkPoi)localObject).mLeftCnt > 0) {}
      for (paramBundle = JarUtils.getResources().getString(1711670053, new Object[] { Integer.valueOf(((SearchParkPoi)localObject).mLeftCnt), Integer.valueOf(((SearchParkPoi)localObject).mDistance) });; paramBundle = JarUtils.getResources().getString(1711670054, new Object[] { Integer.valueOf(((SearchParkPoi)localObject).mDistance) }))
      {
        localTextView.setText(paramBundle);
        LogUtil.e("parkpoiinformation", "poi.mName = " + ((SearchParkPoi)localObject).mName + " || poi.mDistance = " + ((SearchParkPoi)localObject).mDistance + " || lat = " + ((SearchParkPoi)localObject).mViewPoint.getLatitudeE6() + "long = " + ((SearchParkPoi)localObject).mViewPoint.getLongitudeE6());
        paramBundle = BNMapController.getInstance().getMapStatus();
        localObject = CoordinateTransformUtil.LL2MC(((SearchParkPoi)localObject).mViewPoint.getLongitudeE6() / 100000.0D, ((SearchParkPoi)localObject).mViewPoint.getLatitudeE6() / 100000.0D);
        paramBundle._CenterPtX = ((Bundle)localObject).getInt("MCx");
        paramBundle._CenterPtY = ((Bundle)localObject).getInt("MCy");
        localObject = new GeoPoint(paramBundle._CenterPtX, paramBundle._CenterPtY);
        paramBundle._Level = 18.0F;
        BNMapController.getInstance().setMapStatus(paramBundle, MapController.AnimationType.eAnimationAll);
        ItemizedOverlayUtil.getInstance().removeAllItems();
        paramBundle = DrawableUtils.getDrawableFromView(this.mPickPointLayout);
        paramBundle = ItemizedOverlayUtil.getInstance().getOverlayItem((GeoPoint)localObject, paramBundle);
        paramBundle.addClickRect(getLeftContentSizeBundle());
        paramBundle.addClickRect(getRightContentSizeBundle());
        ItemizedOverlayUtil.getInstance().addMapItem(paramBundle);
        ItemizedOverlayUtil.getInstance().show();
        ItemizedOverlayUtil.getInstance().refresh();
        ItemizedOverlayUtil.getInstance().setOnTapListener(new ItemizedOverlayUtil.OnTapListener()
        {
          public boolean onTap(int paramAnonymousInt)
          {
            return false;
          }
          
          public boolean onTap(int paramAnonymousInt1, int paramAnonymousInt2, GeoPoint paramAnonymousGeoPoint)
          {
            switch (paramAnonymousInt2)
            {
            }
            for (;;)
            {
              return false;
              BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410298", "410298");
              paramAnonymousGeoPoint = RGParkPointModel.getInstance().getParkPoi();
              if (paramAnonymousGeoPoint != null)
              {
                paramAnonymousGeoPoint = paramAnonymousGeoPoint.mGuidePoint;
                BNRoutePlaner.getInstance().setGuideSceneType(4);
                RGSimpleGuideModel.getInstance();
                RGSimpleGuideModel.mCalcRouteType = 4;
                RGEngineControl.getInstance().setEndPtToCalcRoute(paramAnonymousGeoPoint);
              }
            }
          }
          
          public boolean onTap(GeoPoint paramAnonymousGeoPoint)
          {
            return false;
          }
        });
        return;
      }
    }
    hide();
  }
  
  public void updateDataByLastest()
  {
    updateData(null);
  }
  
  public void updateStyle(boolean paramBoolean)
  {
    super.updateStyle(paramBoolean);
    if (this.mPickPointPanel != null) {
      this.mPickPointPanel.setBackgroundDrawable(BNStyleManager.getDrawable(1711407766));
    }
    if (this.mPickPointName != null) {
      this.mPickPointName.setTextColor(BNStyleManager.getColor(1711800674));
    }
    if (this.mPickPointAddr != null) {
      this.mPickPointAddr.setTextColor(BNStyleManager.getColor(1711800698));
    }
    if (this.mSetParkView != null)
    {
      this.mSetParkView.setTextColor(BNStyleManager.getColor(1711800682));
      this.mSetParkView.setBackgroundDrawable(BNStyleManager.getDrawable(1711407768));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMParkPointView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */