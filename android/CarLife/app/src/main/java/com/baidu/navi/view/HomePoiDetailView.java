package com.baidu.navi.view;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.widget.ProgressBar;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.carlife.view.dialog.o;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.ArrayList;

public class HomePoiDetailView
  extends HomePoiBasicView
{
  private static final String TAG = "HomePoiDetailView";
  private CarlifeActivity mActivity;
  private ProgressBar mAntiGeoPB;
  private ArrayList<SearchPoi> mAntiPoiList;
  private boolean mCanPanelShow = true;
  private Context mContext;
  private SearchPoi mCurrentPoi;
  private int mCurrentPoiIndex;
  private View mGroupView;
  private boolean mIfAntiGeoing = false;
  private boolean mIfNeedAntiGeoForStreetId = false;
  private boolean mIsAntiGeoOnlyForStreetId = false;
  private boolean mIsAntiGeoReady = false;
  private boolean mIsPanelShow = false;
  private boolean mIsPoiMode = false;
  private int mLastOrientation = 0;
  private NaviFragmentManager mNaviFragmentManager;
  private PoiDetailView mPoiPanel;
  private HeightWrapableViewPager mPoiSwitchVP;
  private o mStreetscapeLoadAlertDialog;
  private PagerAdapter poiAdapter;
  
  public HomePoiDetailView(CarlifeActivity paramCarlifeActivity, View paramView, NaviFragmentManager paramNaviFragmentManager)
  {
    this.mGroupView = paramView;
    this.mPoiPanel = ((PoiDetailView)this.mGroupView.findViewById(2131624534));
    this.mPoiPanel.setController(PoiController.getInstance());
  }
  
  public void hide()
  {
    LogUtil.e("HomePoiDetailView", "-----> hide ");
    this.mIsPanelShow = false;
    this.mPoiPanel.hide();
  }
  
  public boolean isVisible()
  {
    return this.mPoiPanel.getVisibility() == 0;
  }
  
  public void onPause() {}
  
  public void onResume()
  {
    if (this.mPoiPanel != null) {
      this.mPoiPanel.onResume();
    }
  }
  
  public void onUpdateOrientation(int paramInt)
  {
    if (paramInt != this.mLastOrientation) {
      this.mLastOrientation = paramInt;
    }
  }
  
  public void show(GeoPoint paramGeoPoint, boolean paramBoolean) {}
  
  public void showFavPoi() {}
  
  public void showMapPoi() {}
  
  public void updateStyle()
  {
    if (this.mPoiPanel != null) {
      this.mPoiPanel.updateStyle();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/HomePoiDetailView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */