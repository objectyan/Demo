package com.baidu.navi.view;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.CarlifeActivity;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.controller.PoiDetailViewController;
import com.baidu.navi.controller.PoiDetailViewController.IPoiDetailViewCallBack;
import com.baidu.navi.cruise.control.EnterQuitLogicManager;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.fragment.carmode.CarModeMapFragment;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class HomePoiSimpleView
  extends HomePoiBasicView
{
  private boolean isPickPoi = false;
  private CarlifeActivity mActivity;
  private TextView mAddrTextView;
  private PoiDetailViewController.IPoiDetailViewCallBack mCallBack = new PoiDetailViewController.IPoiDetailViewCallBack()
  {
    public void onFavSyncDone(String paramAnonymousString)
    {
      HomePoiSimpleView.this.updateFavBtnBackground();
    }
  };
  private SearchPoi mCurrentPoi;
  private View mDistanceLayout;
  private TextView mDistanceTextView;
  private ImageView mFavBtn;
  private boolean mIsMyPosition;
  private View mNameAddrLayout;
  private TextView mNameTextView;
  CarModeMapFragment mParentFragment;
  private View mPhoneLayout;
  private TextView mPhoneNumberTextView;
  private PoiController mPoiController;
  private PoiDetailViewController mPoiDetailViewController = new PoiDetailViewController();
  private View mPoiPanelView;
  private Handler mUIHandler = new Handler(Looper.getMainLooper())
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      switch (paramAnonymousMessage.what)
      {
      default: 
        return;
      }
      if (paramAnonymousMessage.arg1 == 0)
      {
        paramAnonymousMessage = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getAntiGeoPoi();
        if (!HomePoiSimpleView.this.isPickPoi)
        {
          HomePoiSimpleView.this.mNameTextView.setVisibility(0);
          HomePoiSimpleView.this.mAddrTextView.setVisibility(0);
          HomePoiSimpleView.this.mNameAddrLayout.setVisibility(0);
          HomePoiSimpleView.this.mPhoneLayout.setVisibility(0);
          HomePoiSimpleView.this.mDistanceLayout.setVisibility(0);
          if ((paramAnonymousMessage != null) && (paramAnonymousMessage.mType == 0)) {
            paramAnonymousMessage.mName = String.format(StyleManager.getString(2131298912), new Object[] { paramAnonymousMessage.mName });
          }
          HomePoiSimpleView.this.initPoiDetailPanel(paramAnonymousMessage);
          return;
        }
        if ((HomePoiSimpleView.this.mCurrentPoi != null) && (paramAnonymousMessage != null))
        {
          paramAnonymousMessage.mName = HomePoiSimpleView.this.mCurrentPoi.mName;
          paramAnonymousMessage.mOriginUID = HomePoiSimpleView.this.mCurrentPoi.mOriginUID;
        }
        HomePoiSimpleView.this.initPoiDetailPanel(paramAnonymousMessage);
        return;
      }
      HomePoiSimpleView.this.setAntiGeoFailedViews();
    }
  };
  
  public HomePoiSimpleView(CarlifeActivity paramCarlifeActivity, View paramView, NaviFragmentManager paramNaviFragmentManager, CarModeMapFragment paramCarModeMapFragment)
  {
    this.mActivity = paramCarlifeActivity;
    this.mPoiController = PoiController.getInstance();
    this.mPoiPanelView = paramView.findViewById(2131624534);
    this.mParentFragment = paramCarModeMapFragment;
    initView(this.mPoiPanelView);
    hide();
  }
  
  private void initPoiDetailPanel(SearchPoi paramSearchPoi)
  {
    if (this.mCurrentPoi != null)
    {
      this.mCurrentPoi = paramSearchPoi;
      updatePoiPanelView(this.mCurrentPoi);
      show();
    }
  }
  
  private void initView(View paramView)
  {
    if (paramView != null)
    {
      this.mNameTextView = ((TextView)paramView.findViewById(2131624538));
      this.mAddrTextView = ((TextView)paramView.findViewById(2131624539));
      this.mPhoneNumberTextView = ((TextView)paramView.findViewById(2131624542));
      this.mDistanceTextView = ((TextView)paramView.findViewById(2131624544));
      this.mNameAddrLayout = paramView.findViewById(2131624537);
      this.mPhoneLayout = paramView.findViewById(2131624541);
      this.mDistanceLayout = paramView.findViewById(2131624543);
      this.mFavBtn = ((ImageView)paramView.findViewById(2131624540));
      this.mPhoneLayout.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          HomePoiSimpleView.this.startPhoneCall();
        }
      });
      this.mDistanceLayout.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          HomePoiSimpleView.this.startCalcRoute();
        }
      });
      this.mNameAddrLayout.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          HomePoiSimpleView.this.clickFavBtn();
        }
      });
    }
  }
  
  private void poiDetailViewControllerInit()
  {
    this.mPoiDetailViewController.init(this.mCurrentPoi);
    this.mPoiDetailViewController.setCallBack(this.mCallBack);
  }
  
  private void setAntiGeoFailedViews()
  {
    if (!this.isPickPoi)
    {
      this.mNameAddrLayout.setVisibility(0);
      this.mNameTextView.setVisibility(0);
      this.mAddrTextView.setVisibility(8);
      this.mNameTextView.setText(2131296852);
      this.mPhoneLayout.setVisibility(8);
      this.mDistanceLayout.setVisibility(8);
    }
  }
  
  private void show()
  {
    if (this.mPoiPanelView != null) {
      this.mPoiPanelView.setVisibility(0);
    }
    if (this.mParentFragment != null) {
      this.mParentFragment.hideTopbarView();
    }
    EnterQuitLogicManager.getmInstance().quitCruiseFollowMode();
  }
  
  private void startAntiGeo()
  {
    show();
  }
  
  private void startPhoneCall()
  {
    if (ForbidDaulClickUtils.isFastDoubleClick()) {}
    while ((this.mPoiController == null) || (this.mCurrentPoi == null)) {
      return;
    }
    this.mPoiController.callPhone(this.mCurrentPoi);
  }
  
  private void updateFavBtn(boolean paramBoolean)
  {
    if (this.mFavBtn == null) {
      return;
    }
    if (paramBoolean)
    {
      this.mFavBtn.setImageDrawable(StyleManager.getDrawable(2130838866));
      return;
    }
    this.mFavBtn.setImageDrawable(StyleManager.getDrawable(2130838865));
  }
  
  private void updateFavBtnBackground()
  {
    new HaveFavTask(null).execute(new Void[0]);
  }
  
  private void updatePoiPanelView(SearchPoi paramSearchPoi)
  {
    poiDetailViewControllerInit();
    if (paramSearchPoi == null) {
      return;
    }
    this.mPoiPanelView.setBackgroundColor(StyleManager.getColor(2131558420));
    this.mNameTextView.setText(paramSearchPoi.mName);
    label93:
    Object localObject;
    int i;
    if (paramSearchPoi.mAddress == null)
    {
      this.mAddrTextView.setVisibility(4);
      if ((this.mCurrentPoi != null) && (!TextUtils.isEmpty(this.mCurrentPoi.mName)) && (!StyleManager.getString(2131296852).equals(this.mCurrentPoi.mName))) {
        break label229;
      }
      this.mNameAddrLayout.setClickable(false);
      this.mPhoneLayout.setVisibility(0);
      localObject = this.mDistanceLayout;
      if (!this.mIsMyPosition) {
        break label240;
      }
      i = 8;
      label116:
      ((View)localObject).setVisibility(i);
      if ((paramSearchPoi.mPhone != null) && (!paramSearchPoi.mPhone.isEmpty())) {
        break label245;
      }
      this.mPhoneNumberTextView.setText(2131296726);
      this.mPhoneLayout.setClickable(false);
    }
    for (;;)
    {
      paramSearchPoi = this.mDistanceTextView;
      localObject = new StringBuilder().append("距离");
      PoiController localPoiController = this.mPoiController;
      paramSearchPoi.setText(PoiController.getInstance().getDistance2CurrentPoint(this.mCurrentPoi));
      updateFavBtnBackground();
      return;
      this.mAddrTextView.setVisibility(0);
      this.mAddrTextView.setText(paramSearchPoi.mAddress);
      break;
      label229:
      this.mNameAddrLayout.setClickable(true);
      break label93;
      label240:
      i = 0;
      break label116;
      label245:
      this.mPhoneNumberTextView.setText(paramSearchPoi.mPhone + "　");
      this.mPhoneLayout.setClickable(true);
    }
  }
  
  public void clickFavBtn()
  {
    if (ForbidDaulClickUtils.isFastDoubleClick()) {
      return;
    }
    poiDetailViewControllerInit();
    this.mPoiDetailViewController.addOrDelFav();
  }
  
  public void hide()
  {
    if (this.mPoiPanelView != null) {
      this.mPoiPanelView.setVisibility(8);
    }
    if (this.mParentFragment != null) {
      this.mParentFragment.showTopbarView();
    }
    this.mPoiController.clearPoiCache();
  }
  
  public boolean isVisible()
  {
    return (this.mPoiPanelView != null) && (this.mPoiPanelView.getVisibility() == 0);
  }
  
  public void loadPoint(GeoPoint paramGeoPoint)
  {
    if ((paramGeoPoint == null) || (!paramGeoPoint.isValid())) {}
    int i;
    do
    {
      return;
      SearchPoi localSearchPoi = new SearchPoi();
      localSearchPoi.mViewPoint = paramGeoPoint;
      localSearchPoi.mGuidePoint = paramGeoPoint;
      this.mCurrentPoi = localSearchPoi;
      poiDetailViewControllerInit();
      if (!this.mIsMyPosition) {
        this.mPoiController.focusPoi(localSearchPoi);
      }
      for (;;)
      {
        long l1 = ScreenUtil.getInstance().dip2px(65286) / 2;
        long l2 = ScreenUtil.getInstance().dip2px(0) / 2;
        this.mPoiController.animationTo(paramGeoPoint, l1, l2);
        i = this.mPoiController.getAntiPoiNetMode(paramGeoPoint);
        if (i != -1) {
          break;
        }
        this.mCurrentPoi.mName = StyleManager.getString(2131296852);
        show();
        updatePoiPanelView(this.mCurrentPoi);
        return;
        this.mPoiController.clearPoiCache();
      }
    } while (!this.mPoiController.antiGeo(this.mCurrentPoi, i, this.mUIHandler));
    startAntiGeo();
  }
  
  public View onCreateView()
  {
    View localView = LayoutInflater.from(this.mActivity).inflate(2130968672, null);
    initView(localView);
    return localView;
  }
  
  public void onPause() {}
  
  public void onResume()
  {
    if (!isVisible()) {
      return;
    }
    if (!this.mIsMyPosition) {
      this.mPoiController.focusPoi(this.mCurrentPoi);
    }
    for (;;)
    {
      long l1 = ScreenUtil.getInstance().dip2px(65286) / 2;
      long l2 = ScreenUtil.getInstance().dip2px(0) / 2;
      this.mPoiController.animationTo(this.mCurrentPoi, l1, l2);
      updatePoiPanelView(this.mCurrentPoi);
      return;
      this.mPoiController.clearPoiCache();
    }
  }
  
  public void onUpdateOrientation(int paramInt) {}
  
  public void show(GeoPoint paramGeoPoint, boolean paramBoolean)
  {
    this.isPickPoi = false;
    this.mIsMyPosition = paramBoolean;
    loadPoint(paramGeoPoint);
  }
  
  public void show(boolean paramBoolean) {}
  
  public void showFavPoi()
  {
    this.isPickPoi = true;
    this.mIsMyPosition = false;
    this.mCurrentPoi = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getMapSearchPoi();
    this.mPoiController.focusPoi(this.mCurrentPoi);
    long l1 = ScreenUtil.getInstance().dip2px(65286) / 2;
    long l2 = ScreenUtil.getInstance().dip2px(0) / 2;
    this.mPoiController.animationTo(this.mCurrentPoi, l1, l2);
    initPoiDetailPanel(this.mCurrentPoi);
  }
  
  public void showMapPoi()
  {
    this.isPickPoi = true;
    this.mIsMyPosition = false;
    this.mCurrentPoi = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getMapSearchPoi();
    this.mPoiController.focusPoi(this.mCurrentPoi);
    long l1 = ScreenUtil.getInstance().dip2px(65286) / 2;
    long l2 = ScreenUtil.getInstance().dip2px(0) / 2;
    this.mPoiController.animationTo(this.mCurrentPoi, l1, l2);
    initPoiDetailPanel(this.mCurrentPoi);
    int i = this.mPoiController.getAntiPoiNetMode(this.mCurrentPoi.mViewPoint);
    if ((i != -1) && (this.mPoiController.antiGeo(this.mCurrentPoi, i, this.mUIHandler))) {
      startAntiGeo();
    }
  }
  
  public void startCalcRoute()
  {
    if (ForbidDaulClickUtils.isFastDoubleClick()) {}
    while ((this.mPoiController == null) || (this.mCurrentPoi == null)) {
      return;
    }
    this.mPoiController.startCalcRoute(this.mCurrentPoi, this.mParentFragment);
  }
  
  public void updateStyle() {}
  
  private class HaveFavTask
    extends AsyncTask<Void, Void, Boolean>
  {
    private HaveFavTask() {}
    
    protected Boolean doInBackground(Void... paramVarArgs)
    {
      return Boolean.valueOf(HomePoiSimpleView.this.mPoiDetailViewController.isHaveFav());
    }
    
    protected void onPostExecute(Boolean paramBoolean)
    {
      HomePoiSimpleView.this.updateFavBtn(paramBoolean.booleanValue());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/HomePoiSimpleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */