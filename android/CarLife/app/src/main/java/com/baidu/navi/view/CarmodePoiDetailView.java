package com.baidu.navi.view;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.carlife.core.screen.e;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.controller.PoiDetailViewController;
import com.baidu.navi.controller.PoiDetailViewController.IPoiDetailViewCallBack;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;

public class CarmodePoiDetailView
  extends FrameLayout
{
  private boolean isMyPosition = false;
  private boolean isPickPoi = false;
  private TextView mAddrTextView;
  private View.OnClickListener mBtnClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (ForbidDaulClickUtils.isFastDoubleClick()) {}
      while (paramAnonymousView.getId() != 2131624069) {
        return;
      }
      CarmodePoiDetailView.this.mPoiController.startCalcRoute(CarmodePoiDetailView.this.mCurrentPoi, CarmodePoiDetailView.this.mOnDialogListener);
    }
  };
  private PoiDetailViewController.IPoiDetailViewCallBack mCallBack = new PoiDetailViewController.IPoiDetailViewCallBack()
  {
    public void onFavSyncDone(String paramAnonymousString)
    {
      CarmodePoiDetailView.this.updateFavBtnBackground();
    }
  };
  private int mComeFrom;
  private View mContentLayout;
  private Context mContext;
  private SearchPoi mCurrentPoi;
  private View mDistanceLayout;
  private TextView mDistanceTextView;
  private ImageView mFavBtn;
  private int mIndex;
  private View mNameAddrLayout;
  private TextView mNameTextView;
  private e mOnDialogListener;
  private View mPhoneLayout;
  private TextView mPhoneNumberTextView;
  private PoiController mPoiController;
  private PoiDetailViewController mPoiDetailViewController = new PoiDetailViewController();
  private Handler mUIHandler;
  
  public CarmodePoiDetailView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    findViews(paramContext);
    initSkins();
    initHandler();
  }
  
  public CarmodePoiDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    findViews(paramContext);
    initSkins();
    initHandler();
  }
  
  public CarmodePoiDetailView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    findViews(paramContext);
    initSkins();
    initHandler();
  }
  
  private void findViews(Context paramContext)
  {
    this.mContentLayout = LayoutInflater.from(paramContext).inflate(2130968672, null);
    addView(this.mContentLayout);
    this.mNameTextView = ((TextView)this.mContentLayout.findViewById(2131624538));
    this.mAddrTextView = ((TextView)this.mContentLayout.findViewById(2131624539));
    this.mPhoneNumberTextView = ((TextView)this.mContentLayout.findViewById(2131624542));
    this.mDistanceTextView = ((TextView)this.mContentLayout.findViewById(2131624544));
    this.mNameAddrLayout = this.mContentLayout.findViewById(2131624537);
    this.mPhoneLayout = this.mContentLayout.findViewById(2131624541);
    this.mDistanceLayout = this.mContentLayout.findViewById(2131624543);
    this.mFavBtn = ((ImageView)this.mContentLayout.findViewById(2131624540));
    this.mPhoneLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CarmodePoiDetailView.this.startPhoneCall();
      }
    });
    this.mDistanceLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CarmodePoiDetailView.this.startCalcRoute();
      }
    });
    this.mNameAddrLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CarmodePoiDetailView.this.clickFavBtn();
      }
    });
  }
  
  private void initContents()
  {
    poiDetailViewControllerInit();
    if ((this.mCurrentPoi == null) || (this.mCurrentPoi.mName == null) || (this.mCurrentPoi.mName.isEmpty())) {
      return;
    }
    this.mNameTextView.setText(this.mCurrentPoi.mName);
    this.mAddrTextView.setText(this.mCurrentPoi.mAddress);
    int i;
    if ((TextUtils.isEmpty(this.mCurrentPoi.mPhone)) || (this.mCurrentPoi.mPhone.equals("null")))
    {
      this.mPhoneNumberTextView.setText(2131296726);
      this.mPhoneLayout.setClickable(false);
      Object localObject = this.mDistanceLayout;
      if (!this.isMyPosition) {
        break label276;
      }
      i = 8;
      label123:
      ((View)localObject).setVisibility(i);
      localObject = this.mDistanceTextView;
      StringBuilder localStringBuilder = new StringBuilder().append("距离");
      PoiController localPoiController = this.mPoiController;
      ((TextView)localObject).setText(PoiController.getInstance().getDistance2CurrentPoint(this.mCurrentPoi));
      if (!this.mCurrentPoi.mName.equals(StyleManager.getString(2131296852))) {
        break label281;
      }
      this.mNameAddrLayout.setClickable(false);
      label200:
      if (!this.mCurrentPoi.mName.equals(StyleManager.getString(2131296852))) {
        break label292;
      }
      this.mNameAddrLayout.setClickable(false);
    }
    for (;;)
    {
      updateFavBtnBackground();
      return;
      this.mPhoneNumberTextView.setText(this.mCurrentPoi.mPhone + "　");
      this.mPhoneLayout.setClickable(true);
      break;
      label276:
      i = 0;
      break label123;
      label281:
      this.mNameAddrLayout.setClickable(true);
      break label200;
      label292:
      this.mNameAddrLayout.setClickable(true);
    }
  }
  
  private void initHandler()
  {
    this.mUIHandler = new Handler(Looper.getMainLooper())
    {
      public void handleMessage(Message paramAnonymousMessage)
      {
        switch (paramAnonymousMessage.what)
        {
        }
        do
        {
          do
          {
            return;
            if (paramAnonymousMessage.arg1 == 0)
            {
              paramAnonymousMessage = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getAntiGeoPoi();
              CarmodePoiDetailView.this.mNameAddrLayout.setVisibility(0);
              CarmodePoiDetailView.this.updatePoiByAntiPoi(paramAnonymousMessage);
              return;
            }
          } while (CarmodePoiDetailView.this.isPickPoi);
          CarmodePoiDetailView.this.mNameTextView.setVisibility(0);
          CarmodePoiDetailView.this.mAddrTextView.setVisibility(8);
          CarmodePoiDetailView.this.mNameTextView.setText(2131296852);
        } while (CarmodePoiDetailView.this.mCurrentPoi == null);
        CarmodePoiDetailView.this.mCurrentPoi.mName = StyleManager.getString(2131296852);
      }
    };
  }
  
  private void initSkins() {}
  
  private void poiDetailViewControllerInit()
  {
    this.mPoiDetailViewController.init(this.mCurrentPoi);
    this.mPoiDetailViewController.setCallBack(this.mCallBack);
  }
  
  private void startAntiGeo() {}
  
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
  
  private void updatePoiByAntiPoi(SearchPoi paramSearchPoi)
  {
    if ((paramSearchPoi == null) || (this.mCurrentPoi == null)) {
      return;
    }
    if (this.isPickPoi)
    {
      String str = this.mCurrentPoi.mName;
      paramSearchPoi.mOriginUID = this.mCurrentPoi.mOriginUID;
      this.mCurrentPoi = paramSearchPoi;
      this.mCurrentPoi.mName = str;
    }
    for (;;)
    {
      initContents();
      return;
      this.mCurrentPoi = paramSearchPoi;
      if (paramSearchPoi.mType == 0) {
        this.mCurrentPoi.mName = String.format(StyleManager.getString(2131298912), new Object[] { this.mCurrentPoi.mName });
      }
    }
  }
  
  public void antiPoi(GeoPoint paramGeoPoint, long paramLong1, long paramLong2)
  {
    if ((paramGeoPoint == null) || (!paramGeoPoint.isValid())) {
      return;
    }
    this.isPickPoi = false;
    SearchPoi localSearchPoi = new SearchPoi();
    localSearchPoi.mViewPoint = paramGeoPoint;
    localSearchPoi.mGuidePoint = paramGeoPoint;
    int i;
    if (!this.isMyPosition)
    {
      this.mPoiController.focusPoi(localSearchPoi);
      i = this.mPoiController.getAntiPoiNetMode(paramGeoPoint);
      if (i != -1) {
        break label98;
      }
      localSearchPoi.mName = StyleManager.getString(2131296852);
    }
    for (;;)
    {
      setSearchPoi(localSearchPoi);
      return;
      this.mPoiController.clearPoiCache();
      break;
      label98:
      if (this.mPoiController.antiGeo(localSearchPoi, i, this.mUIHandler)) {
        startAntiGeo();
      }
      this.mPoiController.animationTo(paramGeoPoint, paramLong1, paramLong2);
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
  
  public int getIndex()
  {
    return this.mIndex;
  }
  
  public SearchPoi getSearchPoi()
  {
    return this.mCurrentPoi;
  }
  
  public void handleShortUri(String paramString)
  {
    if (this.mContext == null) {
      return;
    }
    this.mPoiController.sharePoiParseShortUrl(paramString, this.mUIHandler);
  }
  
  public void hide()
  {
    setVisibility(8);
  }
  
  public boolean isVisible()
  {
    return getVisibility() == 0;
  }
  
  public void pickPoi(SearchPoi paramSearchPoi, long paramLong1, long paramLong2)
  {
    if ((paramSearchPoi == null) || (paramSearchPoi.mViewPoint == null) || (!paramSearchPoi.mViewPoint.isValid())) {
      return;
    }
    this.isPickPoi = true;
    if (!this.isMyPosition)
    {
      this.mPoiController.focusPoi(paramSearchPoi);
      this.mPoiController.animationTo(paramSearchPoi, paramLong1, paramLong2);
    }
    for (;;)
    {
      int i = this.mPoiController.getAntiPoiNetMode(paramSearchPoi.mViewPoint);
      if ((i != -1) && (this.mPoiController.antiGeo(paramSearchPoi, i, this.mUIHandler))) {
        startAntiGeo();
      }
      setSearchPoi(paramSearchPoi);
      return;
      this.mPoiController.clearPoiCache();
    }
  }
  
  public void setComeFrom(int paramInt)
  {
    this.mComeFrom = paramInt;
  }
  
  public void setController(PoiController paramPoiController)
  {
    this.mPoiController = paramPoiController;
  }
  
  public void setFavSearchPoi(SearchPoi paramSearchPoi)
  {
    if (paramSearchPoi == null) {
      return;
    }
    this.mCurrentPoi = paramSearchPoi;
    initContents();
  }
  
  public void setFromBrowseMapFragment(boolean paramBoolean, NaviFragmentManager paramNaviFragmentManager) {}
  
  public void setMyPositionMode(boolean paramBoolean)
  {
    this.isMyPosition = paramBoolean;
    View localView = this.mDistanceLayout;
    if (paramBoolean) {}
    for (int i = 8;; i = 0)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void setOnDialogListener(e parame)
  {
    this.mOnDialogListener = parame;
  }
  
  public void setSearchPoi(SearchPoi paramSearchPoi)
  {
    if (paramSearchPoi == null) {
      return;
    }
    this.mCurrentPoi = paramSearchPoi;
    initContents();
  }
  
  public void setSearchPoiIndex(int paramInt1, int paramInt2)
  {
    this.mIndex = paramInt1;
  }
  
  public void show()
  {
    setVisibility(0);
  }
  
  public void startCalcRoute()
  {
    if (ForbidDaulClickUtils.isFastDoubleClick()) {}
    while ((this.mPoiController == null) || (this.mCurrentPoi == null)) {
      return;
    }
    if (this.mComeFrom == 8) {
      StatisticManager.onEvent("DISCOVER_QJY_0002", "DISCOVER_QJY_0002");
    }
    this.mPoiController.startCalcRoute(this.mCurrentPoi, this.mOnDialogListener);
  }
  
  public void updateContent()
  {
    initContents();
  }
  
  public void updateStyle() {}
  
  private class HaveFavTask
    extends AsyncTask<Void, Void, Boolean>
  {
    private HaveFavTask() {}
    
    protected Boolean doInBackground(Void... paramVarArgs)
    {
      return Boolean.valueOf(CarmodePoiDetailView.this.mPoiDetailViewController.isHaveFav());
    }
    
    protected void onPostExecute(Boolean paramBoolean)
    {
      CarmodePoiDetailView.this.updateFavBtn(paramBoolean.booleanValue());
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/CarmodePoiDetailView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */