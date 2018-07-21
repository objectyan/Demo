package com.baidu.navisdk.ui.routeguide.mapmode.subview;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.comapi.routeplan.BNRoutePlaner;
import com.baidu.navisdk.comapi.statistics.BNStatisticsManager;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.ui.routeguide.control.RGEngineControl;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.ui.routeguide.mapmode.RGMapModeViewController;
import com.baidu.navisdk.ui.routeguide.model.RGPickPointModel;
import com.baidu.navisdk.ui.routeguide.model.RGRouteSearchModel;
import com.baidu.navisdk.ui.routeguide.subview.OnRGSubViewListener;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.widget.BNBaseView;
import com.baidu.navisdk.ui.widget.BNDialog;
import com.baidu.navisdk.ui.widget.BNDialog.OnNaviClickListener;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.navisdk.util.drawable.DrawableUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.ItemizedOverlayUtil;
import com.baidu.nplatform.comapi.map.ItemizedOverlayUtil.OnTapListener;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import com.baidu.nplatform.comapi.map.OverlayItem;

public class RGMMPickPointView
  extends BNBaseView
{
  public static final int POINT_VIEW_OFFSET = 20;
  private static final int POPUP_LEFT_AREA = 0;
  private static final int POPUP_RIGHT_AREA = 1;
  public static final int SCREEN_Y_OFFSET = 58;
  private TextView mPickPointAddr = null;
  private View mPickPointLayout = null;
  private View mPickPointMainText = null;
  private TextView mPickPointName = null;
  private View mPickPointPanel = null;
  private ImageView mPointIV = null;
  private View mSetViaView = null;
  private BNDialog mViaComfirmDialog = null;
  
  public RGMMPickPointView(Context paramContext, ViewGroup paramViewGroup, OnRGSubViewListener paramOnRGSubViewListener)
  {
    super(paramContext, paramViewGroup, paramOnRGSubViewListener);
    initViews();
    updateDataByLastest();
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
    if (this.mPickPointMainText == null) {
      return 0;
    }
    return this.mPickPointMainText.getMeasuredHeight();
  }
  
  private int getLeftWidth()
  {
    if (this.mPickPointMainText == null) {
      return 0;
    }
    return this.mPickPointMainText.getMeasuredWidth();
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
    if (this.mSetViaView == null) {
      return 0;
    }
    return this.mSetViaView.getMeasuredHeight();
  }
  
  private int getRightWidth()
  {
    if (this.mSetViaView == null) {
      return 0;
    }
    return this.mSetViaView.getMeasuredWidth();
  }
  
  private void initViews()
  {
    if (this.mRootViewGroup == null) {
      return;
    }
    if (this.mPickPointLayout == null) {
      this.mPickPointLayout = ((ViewStub)this.mRootViewGroup.findViewById(1711866519)).inflate();
    }
    this.mPickPointPanel = this.mRootViewGroup.findViewById(1711866638);
    this.mPickPointName = ((TextView)this.mRootViewGroup.findViewById(1711866640));
    this.mPickPointAddr = ((TextView)this.mRootViewGroup.findViewById(1711866641));
    this.mSetViaView = this.mRootViewGroup.findViewById(1711866642);
    this.mPickPointMainText = this.mRootViewGroup.findViewById(1711866639);
    this.mPointIV = ((ImageView)this.mRootViewGroup.findViewById(1711866643));
  }
  
  public void hide()
  {
    super.hide();
    RGPickPointModel.getInstance().updateAntiSearchPoi(null);
    ItemizedOverlayUtil.getInstance().removeAllItems();
    ItemizedOverlayUtil.getInstance().hide();
    ItemizedOverlayUtil.getInstance().setOnTapListener(null);
  }
  
  public void hideViaComfirmDialog()
  {
    if ((this.mViaComfirmDialog != null) && (this.mContext != null) && (!((Activity)this.mContext).isFinishing()))
    {
      if (this.mViaComfirmDialog.isShowing()) {
        this.mViaComfirmDialog.dismiss();
      }
      this.mViaComfirmDialog = null;
    }
  }
  
  public void show()
  {
    super.show();
  }
  
  public void showViaComfirmDialog()
  {
    if (this.mContext == null) {}
    for (;;)
    {
      return;
      hideViaComfirmDialog();
      try
      {
        this.mViaComfirmDialog = new BNDialog((Activity)this.mContext).enableBackKey(true).setTitleText(BNStyleManager.getString(1711669372)).setContentMessage(BNStyleManager.getString(1711670029)).setSecondBtnText(BNStyleManager.getString(1711669367)).setSecondBtnTextColorHighLight().setOnSecondBtnClickListener(new BNDialog.OnNaviClickListener()
        {
          public void onClick()
          {
            BNRoutePlaner.getInstance().setGuideEndType(1);
            if (RGRouteSearchModel.getInstance().isRouteSearchMode())
            {
              RGRouteSearchModel.getInstance().setRouteSearchMode(false);
              BNPoiSearcher.getInstance().clearBkgCache();
              BNMapController.getInstance().updateLayer(4);
              BNMapController.getInstance().showLayer(4, false);
              BNStatisticsManager.getInstance().onEvent(BNaviModuleManager.getContext(), "410310", "410310");
            }
            RGEngineControl localRGEngineControl = RGEngineControl.getInstance();
            GeoPoint localGeoPoint = RGPickPointModel.getInstance().getPickPoint();
            if (RGPickPointModel.getInstance().getAntiSearchPoi() != null) {}
            for (String str = RGPickPointModel.getInstance().getAntiSearchPoi().mName;; str = "")
            {
              localRGEngineControl.addViaPtToCalcRoute(localGeoPoint, str);
              return;
            }
          }
        }).setFirstBtnText(BNStyleManager.getString(1711669373)).setOnFirstBtnClickListener(new BNDialog.OnNaviClickListener()
        {
          public void onClick() {}
        });
        if ((!this.mViaComfirmDialog.isShowing()) && (this.mContext != null) && (!((Activity)this.mContext).isFinishing()))
        {
          this.mViaComfirmDialog.show();
          return;
        }
      }
      catch (Exception localException) {}
    }
  }
  
  public void updateData(Bundle paramBundle)
  {
    SearchPoi localSearchPoi = RGPickPointModel.getInstance().getAntiSearchPoi();
    if ((localSearchPoi != null) && (localSearchPoi.mName.length() > 0) && (this.mPickPointName != null) && (this.mPickPointAddr != null) && (this.mPickPointLayout != null) && (this.mPickPointPanel != null))
    {
      ItemizedOverlayUtil.getInstance().removeAllItems();
      Bundle localBundle = CoordinateTransformUtil.LL2MC(localSearchPoi.mViewPoint.getLongitudeE6() / 100000.0D, localSearchPoi.mViewPoint.getLatitudeE6() / 100000.0D);
      Drawable localDrawable = null;
      MapStatus localMapStatus = BNMapController.getInstance().getMapStatus();
      paramBundle = localDrawable;
      if (localBundle != null)
      {
        paramBundle = localDrawable;
        if (localMapStatus != null)
        {
          paramBundle = new GeoPoint(localBundle.getInt("MCx"), localBundle.getInt("MCy"));
          localMapStatus._Level = -1.0F;
          localMapStatus._CenterPtX = paramBundle.getLongitudeE6();
          localMapStatus._CenterPtY = paramBundle.getLatitudeE6();
        }
      }
      BNMapController.getInstance().setMapStatus(localMapStatus, MapController.AnimationType.eAnimationAll);
      this.mPickPointName.setText(localSearchPoi.mName);
      this.mPickPointAddr.setText(localSearchPoi.mAddress);
      if (this.mPointIV != null)
      {
        if (!RGViewController.getInstance().mIsPickPointDripShow) {
          break label282;
        }
        this.mPointIV.setVisibility(0);
      }
      for (;;)
      {
        localDrawable = DrawableUtils.getDrawableFromView(this.mPickPointLayout);
        paramBundle = ItemizedOverlayUtil.getInstance().getOverlayItem(paramBundle, localDrawable);
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
              RGMMPickPointView.this.showViaComfirmDialog();
            }
          }
          
          public boolean onTap(GeoPoint paramAnonymousGeoPoint)
          {
            return false;
          }
        });
        return;
        label282:
        this.mPointIV.setVisibility(4);
      }
    }
    hide();
  }
  
  public void updateDataByLastest()
  {
    updateData(null);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/routeguide/mapmode/subview/RGMMPickPointView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */