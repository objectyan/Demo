package com.baidu.navi.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.navi.location.LocationChangeListener;
import com.baidu.navi.location.LocationChangeListener.CoordType;
import com.baidu.navi.location.LocationManager;
import com.baidu.navi.location.LocationManager.LocData;
import com.baidu.navi.logic.model.UIModel;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.view.MapControlPanel;
import com.baidu.navi.view.MapTitleBar;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.mapcontrol.BNMapObserver;
import com.baidu.navisdk.comapi.poisearch.BNPoiSearcher;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.model.MainMapModel;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.RoutePlanModel;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.PreferenceHelper;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.map.MapController.AnimationType;
import java.util.HashMap;

public class PickPointOnMapFragment
  extends MapContentFragment
  implements View.OnClickListener
{
  private static final int MAP_SCALE_DEFAULT = 14;
  private static final String TAG = "RoutePlan";
  private static final int mTimeout = 30000;
  private boolean isCarMode = false;
  private SearchPoi mAntiGeoPoi;
  private RoutePlanNode mAntiRPNode;
  private BNMapObserver mBNMapObserver = new BNMapObserver()
  {
    public void update(BNSubject paramAnonymousBNSubject, int paramAnonymousInt1, int paramAnonymousInt2, Object paramAnonymousObject)
    {
      if (2 == paramAnonymousInt1) {
        switch (paramAnonymousInt2)
        {
        }
      }
      if (1 == paramAnonymousInt1) {}
      switch (paramAnonymousInt2)
      {
      case 263: 
      default: 
        return;
      }
      LogUtil.e("RoutePlan", "---------------------------x = " + PickPointOnMapFragment.this.mCenterPointLocation[0] + ", y = " + PickPointOnMapFragment.this.mCenterPointLocation[1]);
      paramAnonymousBNSubject = BNMapController.getInstance().getGeoPosByScreenPos(PickPointOnMapFragment.this.mCenterPointLocation[0], PickPointOnMapFragment.this.mCenterPointLocation[1]);
      PickPointOnMapFragment.this.antiGeo(paramAnonymousBNSubject);
      PickPointOnMapFragment.this.resetSelectPoint(paramAnonymousBNSubject);
      PickPointOnMapFragment.this.mPoiName.setText(2131296560);
      PickPointOnMapFragment.this.mPoiDescription.setVisibility(8);
    }
  };
  private int mCarModeHomeSideBarWidth = 0;
  private int[] mCenterPointLocation;
  private ImageView mCenterPointView;
  private LinearLayout mConfirmLayout;
  private TextView mConfirmText;
  private ImageView mDivider;
  private HashMap<String, String> mGeoMap = new HashMap();
  private Handler mHander = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      }
      for (;;)
      {
        return;
        if (paramAnonymousMessage.arg1 != 0) {
          break;
        }
        paramAnonymousMessage = (RspData)paramAnonymousMessage.obj;
        PickPointOnMapFragment.access$002(PickPointOnMapFragment.this, (SearchPoi)paramAnonymousMessage.mData);
        if (PickPointOnMapFragment.this.mAntiGeoPoi != null)
        {
          if (!PickPointOnMapFragment.this.mGeoMap.containsKey(PickPointOnMapFragment.this.mAntiGeoPoi.mViewPoint.toString())) {
            continue;
          }
          PickPointOnMapFragment.this.mGeoMap.remove(PickPointOnMapFragment.this.mAntiGeoPoi.mViewPoint.toString());
          if ((PickPointOnMapFragment.this.mAntiGeoPoi.mType == 0) && (PickPointOnMapFragment.this.mAntiGeoPoi.mName != null)) {
            PickPointOnMapFragment.this.mAntiGeoPoi.mName = String.format(StyleManager.getString(2131298912), new Object[] { PickPointOnMapFragment.this.mAntiGeoPoi.mName });
          }
        }
        PickPointOnMapFragment.access$202(PickPointOnMapFragment.this, RoutePlanModel.changeToRoutePlanNode(PickPointOnMapFragment.this.mAntiGeoPoi));
        LogUtil.e("RoutePlan", "--------------------name = " + PickPointOnMapFragment.this.mAntiRPNode.mName + ", address = " + PickPointOnMapFragment.this.mAntiRPNode.mDescription + ", LatitudeE6 = " + PickPointOnMapFragment.this.mAntiRPNode.getLatitudeE6() + ", LongitudeE6 = " + PickPointOnMapFragment.this.mAntiRPNode.getLongitudeE6());
        if (!PickPointOnMapFragment.this.mAntiRPNode.isNodeIntegrated())
        {
          PickPointOnMapFragment.this.mPoiName.setText(2131296474);
          PickPointOnMapFragment.this.mPoiDescription.setVisibility(8);
          return;
        }
        PickPointOnMapFragment.this.mSelectPoint.copy(PickPointOnMapFragment.this.mAntiRPNode);
        if ((PickPointOnMapFragment.this.mSelectPoint.mName != null) && (PickPointOnMapFragment.this.mSelectPoint.mName.length() != 0)) {
          PickPointOnMapFragment.this.mPoiName.setText(PickPointOnMapFragment.this.mSelectPoint.mName);
        }
        while ((PickPointOnMapFragment.this.mSelectPoint.mDescription != null) && (PickPointOnMapFragment.this.mSelectPoint.mDescription.length() != 0))
        {
          PickPointOnMapFragment.this.mPoiDescription.setVisibility(0);
          PickPointOnMapFragment.this.mPoiDescription.setText(PickPointOnMapFragment.this.mSelectPoint.mDescription);
          return;
          PickPointOnMapFragment.this.mPoiName.setText(2131296724);
        }
      }
      PickPointOnMapFragment.this.mPoiName.setText(2131297184);
      PickPointOnMapFragment.this.mPoiDescription.setVisibility(8);
    }
  };
  private Handler mHandler;
  private boolean mHasInitCenterView = false;
  private boolean mHasPickPoint = false;
  private boolean mIsMapLocated = false;
  private LocationChangeListener mLocationChangeListener = new LocationChangeListener()
  {
    public LocationChangeListener.CoordType onGetCoordType()
    {
      return LocationChangeListener.CoordType.CoordType_GCJ02;
    }
    
    public void onLocationChange(LocationManager.LocData paramAnonymousLocData)
    {
      if ((paramAnonymousLocData != null) && (LocationManager.getInstance().isLocationValid()))
      {
        TipTool.onCreateDebugToast(PickPointOnMapFragment.this.getContext(), "LocSDK: Got " + paramAnonymousLocData);
        if (!PickPointOnMapFragment.this.mIsMapLocated) {
          PickPointOnMapFragment.this.initMapStatus();
        }
        if (PickPointOnMapFragment.this.mIsMapLocated) {
          PickPointOnMapFragment.this.mHandler.post(new Runnable()
          {
            public void run()
            {
              LocationManager.getInstance().removeLocationChangeLister(PickPointOnMapFragment.this.mLocationChangeListener);
            }
          });
        }
      }
    }
  };
  private TextView mPoiDescription;
  private RelativeLayout mPoiDetailInfoLayout;
  private TextView mPoiName;
  private RoutePlanNode mSelectPoint;
  private MapTitleBar mTitleBar;
  private ViewGroup mViewGroup = null;
  private String type = "PickPointOnMapFragment";
  
  private void antiGeo(GeoPoint paramGeoPoint)
  {
    BNPoiSearcher.getInstance().asynGetPoiByPoint(paramGeoPoint, 30000, this.mHander);
    this.mGeoMap.put(paramGeoPoint.toString(), this.type);
  }
  
  private void initMapStatus()
  {
    if (!MainMapModel.getInstance().bFirstLoc)
    {
      this.mIsMapLocated = true;
      return;
    }
    MapStatus localMapStatus = BNMapController.getInstance().getMapStatus();
    int i = PreferenceHelper.getInstance(getContext()).getInt("sp_last_scale", 14);
    LogUtil.e("RoutePlan", "initMapScale: savedLevel " + i);
    if (i > 14)
    {
      localMapStatus._Level = i;
      label73:
      Object localObject = GeoLocateModel.getInstance().getLastLocation();
      if ((localObject == null) || (!((LocData)localObject).isValid())) {
        break label172;
      }
      this.mIsMapLocated = true;
      MainMapModel.getInstance().bFirstLoc = false;
      localObject = CoordinateTransformUtil.LL2MC(((LocData)localObject).longitude, ((LocData)localObject).latitude);
      localMapStatus._CenterPtX = ((Bundle)localObject).getInt("MCx");
      localMapStatus._CenterPtY = ((Bundle)localObject).getInt("MCy");
    }
    for (;;)
    {
      BNMapController.getInstance().setMapStatus(localMapStatus, MapController.AnimationType.eAnimationNone);
      if (this.mMapControlPanel == null) {
        break;
      }
      this.mMapControlPanel.updateView();
      return;
      localMapStatus._Level = 14.0F;
      break label73;
      label172:
      this.mIsMapLocated = false;
      LogUtil.e("RoutePlan", "initMapScale: null location data...");
      localMapStatus._Level = 3.0F;
    }
  }
  
  private void resetSelectPoint(GeoPoint paramGeoPoint)
  {
    this.mSelectPoint.mName = StyleManager.getString(2131296305);
    this.mSelectPoint.mDescription = "";
    this.mSelectPoint.mFrom = 1;
    this.mSelectPoint.setGeoPoint(paramGeoPoint);
  }
  
  private void setupCenterView()
  {
    GeoPoint localGeoPoint;
    if (this.isCarMode)
    {
      this.mCenterPointLocation[0] = (this.mCenterPointView.getLeft() + this.mCenterPointView.getWidth() / 2 + this.mCarModeHomeSideBarWidth);
      this.mCenterPointLocation[1] = (this.mCenterPointView.getTop() + this.mCenterPointView.getHeight());
      localGeoPoint = BNMapController.getInstance().getGeoPosByScreenPos(this.mCenterPointLocation[0], this.mCenterPointLocation[1]);
      if (localGeoPoint != null)
      {
        if ((localGeoPoint.getLatitudeE6() <= 0) || (localGeoPoint.getLongitudeE6() <= 0)) {
          break label151;
        }
        antiGeo(localGeoPoint);
      }
    }
    for (;;)
    {
      resetSelectPoint(localGeoPoint);
      return;
      this.mCenterPointLocation[0] = (this.mCenterPointView.getLeft() + this.mCenterPointView.getWidth() / 2);
      this.mCenterPointLocation[1] = (this.mCenterPointView.getTop() + this.mCenterPointView.getHeight());
      break;
      label151:
      this.mHandler.postDelayed(new Runnable()
      {
        public void run()
        {
          GeoPoint localGeoPoint = BNMapController.getInstance().getGeoPosByScreenPos(PickPointOnMapFragment.this.mCenterPointLocation[0], PickPointOnMapFragment.this.mCenterPointLocation[1]);
          if ((localGeoPoint.getLatitudeE6() > 0) && (localGeoPoint.getLongitudeE6() > 0)) {
            PickPointOnMapFragment.this.antiGeo(localGeoPoint);
          }
        }
      }, 1000L);
    }
  }
  
  public void findViews()
  {
    this.mCenterPointView = ((ImageView)this.mViewGroup.findViewById(2131624423));
    this.mPoiDetailInfoLayout = ((RelativeLayout)this.mViewGroup.findViewById(2131624416));
    this.mPoiName = ((TextView)this.mViewGroup.findViewById(2131624421));
    this.mPoiDescription = ((TextView)this.mViewGroup.findViewById(2131624422));
    this.mConfirmLayout = ((LinearLayout)this.mViewGroup.findViewById(2131624417));
    this.mConfirmText = ((TextView)this.mViewGroup.findViewById(2131624418));
    this.mDivider = ((ImageView)this.mViewGroup.findViewById(2131624419));
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131624137) {
      back(null);
    }
  }
  
  protected View onCreateContentView(LayoutInflater paramLayoutInflater)
  {
    boolean bool;
    if (!NaviFragmentManager.isUsingMapMode())
    {
      bool = true;
      this.isCarMode = bool;
      if (!this.isCarMode) {
        break label117;
      }
    }
    label117:
    for (int i = 2130968660;; i = 2130968793)
    {
      this.mViewGroup = ((ViewGroup)paramLayoutInflater.inflate(i, null));
      this.mTitleBar = ((MapTitleBar)this.mViewGroup.findViewById(2131624146));
      this.mTitleBar.setLeftOnClickedListener(this);
      loadMapCtrlPanel(true);
      this.mCenterPointLocation = new int[2];
      this.mSelectPoint = new RoutePlanNode();
      findViews();
      this.mHandler = new Handler(Looper.getMainLooper());
      setupViews();
      return this.mViewGroup;
      bool = false;
      break;
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  protected void onInitMap()
  {
    LogUtil.e("RoutePlan", "addObserver");
    setMapLayerMode(4);
  }
  
  protected void onInitView() {}
  
  public void onPause()
  {
    super.onPause();
    BNMapController.getInstance().deleteObserver(this.mBNMapObserver);
    LocationManager.getInstance().removeLocationChangeLister(this.mLocationChangeListener);
  }
  
  public void onResume()
  {
    super.onResume();
    BNMapController.getInstance().addObserver(this.mBNMapObserver);
    LocationManager.getInstance().addLocationChangeLister(this.mLocationChangeListener);
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  protected void onUpdateOrientation(int paramInt) {}
  
  protected void onUpdateStyle(boolean paramBoolean)
  {
    super.onUpdateStyle(paramBoolean);
    if (!this.isCarMode)
    {
      this.mTitleBar.onUpdateStyle(paramBoolean);
      int i = StyleManager.getColor(2131559150);
      this.mPoiDetailInfoLayout.setBackgroundColor(i);
      this.mPoiName.setTextColor(StyleManager.getColor(2131558501));
      this.mPoiDescription.setTextColor(StyleManager.getColor(2131558499));
      this.mDivider.setBackgroundColor(StyleManager.getColor(2131559213));
      return;
    }
    this.mPoiDetailInfoLayout.setBackgroundColor(StyleManager.getColor(2131558552));
    this.mPoiName.setTextColor(StyleManager.getColor(2131558554));
    this.mPoiDescription.setTextColor(StyleManager.getColor(2131558556));
    this.mDivider.setBackgroundColor(StyleManager.getColor(2131558559));
    this.mConfirmLayout.setBackgroundDrawable(StyleManager.getDrawable(2130838145));
    this.mConfirmText.setTextColor(StyleManager.getColor(2131558549));
  }
  
  public void setupViews()
  {
    this.mConfirmLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (!PickPointOnMapFragment.this.mSelectPoint.isNodeSettedData()) {
          return;
        }
        paramAnonymousView = PickPointOnMapFragment.this.mSelectPoint.mGeoPoint;
        switch (PickPointOnMapFragment.this.mShowBundle.getInt("select_point_action"))
        {
        case 2: 
        case 3: 
        default: 
          return;
        case 1: 
          ((RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel")).setPointSelectNode(paramAnonymousView);
          PickPointOnMapFragment.this.mSelectPoint.setFrom(1);
          ((RoutePlanModel)NaviDataEngine.getInstance().getModel("RoutePlanModel")).setPointSelectNode(PickPointOnMapFragment.this.mSelectPoint);
          LogUtil.e("Map", "BNPoiSearcherObserver");
          PickPointOnMapFragment.this.backTo(50, null);
          return;
        }
        paramAnonymousView = new RoutePlanNode();
        paramAnonymousView.copy(PickPointOnMapFragment.this.mSelectPoint);
        UIModel.settingAddress(paramAnonymousView, BaseFragment.mActivity, PickPointOnMapFragment.this.mShowBundle);
        int i = PickPointOnMapFragment.this.mShowBundle.getInt("from_Fragment", -1);
        if (i == 49)
        {
          PickPointOnMapFragment.this.backTo(49, null);
          return;
        }
        if (i == 81)
        {
          PickPointOnMapFragment.this.backTo(81, null);
          return;
        }
        if (i == 89)
        {
          PickPointOnMapFragment.this.backTo(89, null);
          return;
        }
        PickPointOnMapFragment.this.back(null);
      }
    });
    initMapStatus();
    int i = this.mShowBundle.getInt("select_point_action", -1);
    int j = this.mShowBundle.getInt("from_Fragment", -1);
    if ((i == 1) && (j == 50))
    {
      i = this.mShowBundle.getInt("set_poi_type", -1);
      if (i != 0) {
        break label102;
      }
      this.mConfirmText.setText(StyleManager.getString(2131297142));
    }
    for (;;)
    {
      this.mCenterPointView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
      {
        public void onGlobalLayout()
        {
          if (PickPointOnMapFragment.this.mHasInitCenterView) {
            return;
          }
          PickPointOnMapFragment.access$602(PickPointOnMapFragment.this, true);
          PickPointOnMapFragment.this.setupCenterView();
          PickPointOnMapFragment.this.mCenterPointView.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
      });
      return;
      label102:
      if (i == 1) {
        this.mConfirmText.setText(StyleManager.getString(2131297143));
      } else if (i == 2) {
        this.mConfirmText.setText(StyleManager.getString(2131297140));
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/fragment/PickPointOnMapFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */