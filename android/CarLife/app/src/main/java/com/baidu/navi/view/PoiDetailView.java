package com.baidu.navi.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.controller.PoiController.FavoriteResultCallBack;
import com.baidu.navi.controller.PoiController.ShareEventCallBack;
import com.baidu.navi.controller.PoiController.StreetSearchCallBack;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.CommonParams.NL_Net_Mode;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.logic.CommandResult;
import com.baidu.navisdk.logic.RspData;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.util.BNStyleManager;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.ui.util.TipTool;
import com.baidu.navisdk.util.common.CoordinateTransformUtil;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import com.baidu.nplatform.comapi.basestruct.Point;

public class PoiDetailView
  extends FrameLayout
{
  public static int OUT_CAP;
  public static boolean isPanelOut = true;
  private int VIEW_HEIGHT = 0;
  private boolean isAnimationing = false;
  private boolean isFavorite = false;
  private boolean isMyPosition = false;
  private boolean isOut = false;
  private boolean isPickPoi = false;
  private boolean isSetStreetId = false;
  private boolean isSupportDragon = false;
  private View.OnClickListener mBtnClickListener = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (ForbidDaulClickUtils.isFastDoubleClick()) {}
      int i;
      do
      {
        return;
        i = paramAnonymousView.getId();
        if (i == 2131624203)
        {
          PoiDetailView.this.mPoiController.viewStreet(PoiDetailView.this.mCurrentPoi, PoiDetailView.this.getContext(), PoiDetailView.this.mOnDialogListener);
          return;
        }
        if (i == 2131624207)
        {
          StatisticManager.onEvent("410146", "410146");
          PoiDetailView.this.mPoiController.callPhone(PoiDetailView.this.mCurrentPoi);
          return;
        }
        if (i == 2131624210)
        {
          StatisticManager.onEvent("410147", "410147");
          PoiDetailView.this.mPoiController.startRef(PoiDetailView.this.mCurrentPoi);
          return;
        }
        if (i == 2131625981)
        {
          StatisticManager.onEvent("410155", "410155");
          PoiDetailView.this.mPoiController.setStart(PoiDetailView.this.mCurrentPoi);
          return;
        }
        if (i == 2131625984)
        {
          StatisticManager.onEvent("410157", "410157");
          PoiDetailView.this.mPoiController.setEnd(PoiDetailView.this.mCurrentPoi);
          return;
        }
        if (i == 2131625987)
        {
          StatisticManager.onEvent("410156", "410156");
          PoiDetailView.this.mPoiController.setVia(PoiDetailView.this.mCurrentPoi);
          return;
        }
        if (i == 2131624213)
        {
          StatisticManager.onEvent("410148", "410148");
          PoiDetailView.this.mPoiController.searchSpace(PoiDetailView.this.mCurrentPoi);
          return;
        }
        if (i == 2131624216)
        {
          StatisticManager.onEvent("410154", "410154");
          PoiDetailView.access$802(PoiDetailView.this, true);
          if (PoiDetailView.this.isFavorite)
          {
            PoiDetailView.this.mPoiController.removeFavorite(PoiDetailView.this.mCurrentPoi, PoiDetailView.this.mFavoriteResultCallBack);
            return;
          }
          PoiDetailView.this.mPoiController.addFavorite(PoiDetailView.this.mCurrentPoi, PoiDetailView.this.mFavoriteResultCallBack);
          return;
        }
        if (i == 2131624220)
        {
          com.baidu.carlife.core.screen.presentation.a.e.a().b("分享中，请稍等...");
          PoiDetailView.this.mPoiController.sharePoiGetShortUrl(PoiDetailView.this.mCurrentPoi, PoiDetailView.this.mUIHandler);
          return;
        }
      } while (i != 2131624190);
      StatisticManager.onEvent("410143", "410143");
      PoiDetailView.this.mPoiController.startCalcRoute(PoiDetailView.this.mCurrentPoi, PoiDetailView.this.mOnDialogListener);
    }
  };
  private View mBtnFaverite;
  private View mBtnGooutPref;
  private View mBtnNameAddr;
  private View mBtnPhoneCall;
  private View mBtnSetEnd;
  private View mBtnSetStart;
  private View mBtnSetVia;
  private View mBtnShare;
  private View mBtnSpace;
  private View mBtnStartNavi;
  private View mBtnStreet;
  private View mContentLayout;
  private Context mContext;
  private SearchPoi mCurrentPoi;
  private View.OnClickListener mDragonOnClickListener;
  private View.OnTouchListener mDragonOnTouchListener;
  private int mDuration;
  private PoiController.FavoriteResultCallBack mFavoriteResultCallBack = new PoiController.FavoriteResultCallBack()
  {
    public void onAddResult(boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean) {
        PoiDetailView.access$002(PoiDetailView.this, true);
      }
      PoiDetailView.this.mPbFaverite.setVisibility(8);
      PoiDetailView.this.mTvFaverite.setVisibility(0);
      PoiDetailView.this.mBtnFaverite.setClickable(true);
      PoiDetailView.this.updateFavoriteIcon();
    }
    
    public void onCheckResult(boolean paramAnonymousBoolean)
    {
      PoiDetailView.access$002(PoiDetailView.this, paramAnonymousBoolean);
      PoiDetailView.this.mPbFaverite.setVisibility(8);
      PoiDetailView.this.mTvFaverite.setVisibility(0);
      PoiDetailView.this.mBtnFaverite.setClickable(true);
      PoiDetailView.this.updateFavoriteIcon();
    }
    
    public void onFavoritEventStart()
    {
      PoiDetailView.this.mPbFaverite.setVisibility(0);
      PoiDetailView.this.mTvFaverite.setVisibility(8);
      PoiDetailView.this.mBtnFaverite.setClickable(false);
    }
    
    public void onRemoveResult(boolean paramAnonymousBoolean)
    {
      if (paramAnonymousBoolean) {
        PoiDetailView.access$002(PoiDetailView.this, false);
      }
      PoiDetailView.this.updateFavoriteIcon();
      PoiDetailView.this.mPbFaverite.setVisibility(8);
      PoiDetailView.this.mTvFaverite.setVisibility(0);
      PoiDetailView.this.mBtnFaverite.setClickable(true);
    }
  };
  private View mHorDiverderA;
  private View mHorDiverderB;
  private View mHorDiverderC;
  private View mHorDiverderD;
  private int mIndex;
  private boolean mIsFavOperate = false;
  private ImageView mIvDragon;
  private View mLayoutPanel2;
  private View mLayoutPanel3;
  private ViewGroup.LayoutParams mLayoutParams;
  private CommonParams.NL_Net_Mode mNetMode;
  private com.baidu.carlife.core.screen.e mOnDialogListener;
  private ProgressBar mPbAntiGeo;
  private ProgressBar mPbFaverite;
  private ProgressBar mPbStreet;
  private PoiController mPoiController;
  private PoiController.ShareEventCallBack mShareEventCallBack = new PoiController.ShareEventCallBack()
  {
    public void onEnd() {}
    
    public void onStart() {}
  };
  private PoiController.StreetSearchCallBack mStreetSearchCallBack = new PoiController.StreetSearchCallBack()
  {
    public void onFail()
    {
      PoiDetailView.this.mPbStreet.setVisibility(8);
      PoiDetailView.this.mTvStreet.setVisibility(0);
      PoiDetailView.this.updateStreetIcon();
    }
    
    public void onRevStreetId(String paramAnonymousString)
    {
      PoiDetailView.this.mCurrentPoi.mStreetId = paramAnonymousString;
      PoiDetailView.access$1402(PoiDetailView.this, true);
      PoiDetailView.this.mPbStreet.setVisibility(8);
      PoiDetailView.this.mTvStreet.setVisibility(0);
      PoiDetailView.this.updateStreetIcon();
      if (!TextUtils.isEmpty(paramAnonymousString)) {
        PoiDetailView.this.mBtnStreet.setClickable(true);
      }
    }
    
    public void onStart()
    {
      PoiDetailView.this.mPbStreet.setVisibility(0);
      PoiDetailView.this.mTvStreet.setVisibility(8);
      PoiDetailView.this.mBtnStreet.setClickable(false);
    }
  };
  private TextView mTvAddr;
  private TextView mTvDistance;
  private TextView mTvFaverite;
  private TextView mTvGoouPref;
  private TextView mTvName;
  private TextView mTvNum;
  private TextView mTvPhoneCall;
  private TextView mTvSetEnd;
  private TextView mTvSetStart;
  private TextView mTvSetVia;
  private TextView mTvShare;
  private TextView mTvSpace;
  private TextView mTvStartNavi;
  private TextView mTvStreet;
  private Handler mUIHandler;
  private View mVerDiverder1A;
  private View mVerDiverder1B;
  private View mVerDiverder2A;
  private View mVerDiverder2B;
  private View mVerDiverder3A;
  private View mVerDiverder3B;
  private View mVerDiverderA;
  
  public PoiDetailView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    findViews(paramContext);
    OUT_CAP = getCap();
    this.mDuration = (OUT_CAP / 5);
    initHandler();
  }
  
  public PoiDetailView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
    findViews(paramContext);
    OUT_CAP = getCap();
    this.mDuration = (OUT_CAP / 5);
    initHandler();
  }
  
  public PoiDetailView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    findViews(paramContext);
    OUT_CAP = getCap();
    this.mDuration = (OUT_CAP / 5);
    initHandler();
  }
  
  private void findViews(Context paramContext)
  {
    this.mContentLayout = LayoutInflater.from(paramContext).inflate(2130968990, null);
    setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    this.mHorDiverderA = this.mContentLayout.findViewById(2131624199);
    this.mHorDiverderB = this.mContentLayout.findViewById(2131624604);
    this.mHorDiverderC = this.mContentLayout.findViewById(2131624201);
    this.mHorDiverderD = this.mContentLayout.findViewById(2131624222);
    this.mVerDiverderA = this.mContentLayout.findViewById(2131624189);
    this.mVerDiverder1A = this.mContentLayout.findViewById(2131624206);
    this.mVerDiverder1B = this.mContentLayout.findViewById(2131624209);
    this.mVerDiverder2A = this.mContentLayout.findViewById(2131625983);
    this.mVerDiverder2B = this.mContentLayout.findViewById(2131625986);
    this.mVerDiverder3A = this.mContentLayout.findViewById(2131624215);
    this.mVerDiverder3B = this.mContentLayout.findViewById(2131624219);
    this.mBtnStreet = this.mContentLayout.findViewById(2131624203);
    this.mBtnPhoneCall = this.mContentLayout.findViewById(2131624207);
    this.mBtnGooutPref = this.mContentLayout.findViewById(2131624210);
    this.mBtnSetStart = this.mContentLayout.findViewById(2131625981);
    this.mBtnSetEnd = this.mContentLayout.findViewById(2131625984);
    this.mBtnSetVia = this.mContentLayout.findViewById(2131625987);
    this.mBtnSpace = this.mContentLayout.findViewById(2131624213);
    this.mBtnFaverite = this.mContentLayout.findViewById(2131624216);
    this.mBtnShare = this.mContentLayout.findViewById(2131624220);
    this.mBtnStartNavi = this.mContentLayout.findViewById(2131624190);
    this.mBtnNameAddr = this.mContentLayout.findViewById(2131624193);
    this.mBtnStreet.setOnClickListener(this.mBtnClickListener);
    this.mBtnPhoneCall.setOnClickListener(this.mBtnClickListener);
    this.mBtnGooutPref.setOnClickListener(this.mBtnClickListener);
    this.mBtnSetStart.setOnClickListener(this.mBtnClickListener);
    this.mBtnSetEnd.setOnClickListener(this.mBtnClickListener);
    this.mBtnSetVia.setOnClickListener(this.mBtnClickListener);
    this.mBtnSpace.setOnClickListener(this.mBtnClickListener);
    this.mBtnFaverite.setOnClickListener(this.mBtnClickListener);
    this.mBtnShare.setOnClickListener(this.mBtnClickListener);
    this.mBtnStartNavi.setOnClickListener(this.mBtnClickListener);
    this.mBtnNameAddr.setOnClickListener(this.mBtnClickListener);
    this.mTvName = ((TextView)this.mContentLayout.findViewById(2131624196));
    this.mTvAddr = ((TextView)this.mContentLayout.findViewById(2131624197));
    this.mTvStartNavi = ((TextView)this.mContentLayout.findViewById(2131624191));
    this.mTvDistance = ((TextView)this.mContentLayout.findViewById(2131624192));
    this.mTvStreet = ((TextView)this.mContentLayout.findViewById(2131624205));
    this.mTvPhoneCall = ((TextView)this.mContentLayout.findViewById(2131624208));
    this.mTvGoouPref = ((TextView)this.mContentLayout.findViewById(2131624211));
    this.mTvSetStart = ((TextView)this.mContentLayout.findViewById(2131625982));
    this.mTvSetEnd = ((TextView)this.mContentLayout.findViewById(2131625985));
    this.mTvSetVia = ((TextView)this.mContentLayout.findViewById(2131625988));
    this.mTvFaverite = ((TextView)this.mContentLayout.findViewById(2131624218));
    this.mTvShare = ((TextView)this.mContentLayout.findViewById(2131624221));
    this.mTvSpace = ((TextView)this.mContentLayout.findViewById(2131624214));
    this.mTvNum = ((TextView)this.mContentLayout.findViewById(2131624187));
    this.mPbStreet = ((ProgressBar)this.mContentLayout.findViewById(2131624204));
    this.mPbFaverite = ((ProgressBar)this.mContentLayout.findViewById(2131624217));
    this.mPbAntiGeo = ((ProgressBar)this.mContentLayout.findViewById(2131624198));
    this.mIvDragon = ((ImageView)this.mContentLayout.findViewById(2131625979));
    this.mIvDragon.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        PoiDetailView.this.onClickDragon();
      }
    });
    this.mBtnNameAddr.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        PoiDetailView.this.onClickDragon();
      }
    });
    this.mIvDragon.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return false;
      }
    });
    this.mLayoutPanel2 = this.mContentLayout.findViewById(2131625980);
    this.mLayoutPanel3 = this.mContentLayout.findViewById(2131624212);
    updatePanelVisibility();
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    addView(this.mContentLayout, paramContext);
    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        if ((PoiDetailView.this.VIEW_HEIGHT == 0) || (PoiDetailView.this.mLayoutParams == null))
        {
          PoiDetailView.access$2402(PoiDetailView.this, PoiDetailView.this.getHeight());
          PoiDetailView.access$2502(PoiDetailView.this, PoiDetailView.this.getLayoutParams());
          if ((PoiDetailView.this.isSupportDragon) && (PoiDetailView.this.VIEW_HEIGHT != 0) && (PoiDetailView.this.mLayoutParams != null))
          {
            PoiDetailView.this.mLayoutParams.height = (PoiDetailView.this.VIEW_HEIGHT - PoiDetailView.getCap());
            PoiDetailView.this.setLayoutParams(PoiDetailView.this.mLayoutParams);
            PoiDetailView.access$2702(PoiDetailView.this, false);
            PoiDetailView.this.updateDragonView();
            PoiDetailView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
          }
        }
      }
    });
  }
  
  public static int getCap()
  {
    if (OUT_CAP == 0) {
      OUT_CAP = ScreenUtil.getInstance().dip2px(161);
    }
    return OUT_CAP;
  }
  
  private void inAnimation()
  {
    this.mLayoutParams.height = (this.VIEW_HEIGHT - OUT_CAP);
    this.isOut = false;
    updateDragonView();
    long l1 = BNMapController.getInstance().getMapStatus()._Yoffset;
    long l2 = OUT_CAP / 2;
    this.mPoiController.setMapffset(0L, l1 - l2);
    setLayoutParams(this.mLayoutParams);
  }
  
  private void initContents()
  {
    if (this.mCurrentPoi == null) {
      return;
    }
    this.mTvName.setText(this.mCurrentPoi.mName);
    this.mTvAddr.setText(this.mCurrentPoi.mAddress);
    if ((TextUtils.isEmpty(this.mCurrentPoi.mPhone)) || (this.mCurrentPoi.mPhone.equals("null")))
    {
      localObject = StyleManager.getDrawable(2130837902);
      this.mTvPhoneCall.setCompoundDrawablesWithIntrinsicBounds(null, (Drawable)localObject, null, null);
      this.mBtnPhoneCall.setClickable(false);
    }
    if (!NetworkUtils.getConnectStatus())
    {
      localObject = StyleManager.getDrawable(2130837900);
      this.mTvGoouPref.setCompoundDrawablesWithIntrinsicBounds(null, (Drawable)localObject, null, null);
      this.mBtnGooutPref.setClickable(false);
    }
    Object localObject = this.mTvDistance;
    PoiController localPoiController = this.mPoiController;
    ((TextView)localObject).setText(PoiController.getInstance().getDistance2CurrentPoint(this.mCurrentPoi));
    this.mPoiController.checkFavorite(this.mCurrentPoi, this.mFavoriteResultCallBack);
    updateStreetIcon();
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
            do
            {
              return;
              com.baidu.carlife.core.screen.presentation.a.e.a().c();
              if (CommandResult.isNetworkErr(paramAnonymousMessage.arg1))
              {
                TipTool.onCreateToastDialog(PoiDetailView.this.mContext, "网络错误，请稍后尝试...");
                return;
              }
              if (paramAnonymousMessage.arg1 == 0)
              {
                paramAnonymousMessage = (String)((RspData)paramAnonymousMessage.obj).mData;
                PoiDetailView.this.mPoiController.sharePoi(PoiDetailView.this.mCurrentPoi, paramAnonymousMessage, BNaviModuleManager.getActivity(), PoiDetailView.this.mShareEventCallBack);
                return;
              }
              TipTool.onCreateToastDialog(PoiDetailView.this.mContext, "未知错误，请稍后尝试...");
              return;
              com.baidu.carlife.core.screen.presentation.a.e.a().c();
            } while (paramAnonymousMessage.arg1 != 0);
            Point localPoint = (Point)((RspData)paramAnonymousMessage.obj).mData;
            Object localObject = CoordinateTransformUtil.MC2LLE6(localPoint.x, localPoint.y);
            localObject = new GeoPoint(((Bundle)localObject).getInt("LLx"), ((Bundle)localObject).getInt("LLy"));
            LogUtil.e("", "K_MSG_SHARE_PARSESHORTURL " + paramAnonymousMessage.arg1 + " mPoint " + localPoint + "  mPoint.x " + localPoint.x + " mPoint.y " + localPoint.y + " getLatitudeE6 " + ((GeoPoint)localObject).getLatitudeE6() + " getLongitudeE6 " + ((GeoPoint)localObject).getLongitudeE6());
            PoiDetailView.this.setMyPositionMode(false);
            PoiDetailView.this.antiPoi((GeoPoint)localObject, 0, PoiDetailView.this.getHeight() / 2);
            PoiDetailView.this.setVisibility(0);
            return;
            if (paramAnonymousMessage.arg1 == 0)
            {
              paramAnonymousMessage = ((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getAntiGeoPoi();
              PoiDetailView.this.mPbAntiGeo.setVisibility(8);
              if (!PoiDetailView.this.isPickPoi)
              {
                PoiDetailView.this.mTvName.setVisibility(0);
                PoiDetailView.this.mTvAddr.setVisibility(0);
              }
              PoiDetailView.access$1402(PoiDetailView.this, true);
              PoiDetailView.this.updatePoiByAntiPoi(paramAnonymousMessage);
              return;
            }
            PoiDetailView.this.mPbAntiGeo.setVisibility(8);
          } while (PoiDetailView.this.isPickPoi);
          PoiDetailView.this.mTvName.setVisibility(0);
          PoiDetailView.this.mTvAddr.setVisibility(8);
          PoiDetailView.this.mTvName.setText(2131296852);
        } while (PoiDetailView.this.mCurrentPoi == null);
        PoiDetailView.this.mCurrentPoi.mName = BNStyleManager.getString(1711670052);
      }
    };
  }
  
  private void initSkins()
  {
    this.mHorDiverderA.setBackgroundColor(StyleManager.getColor(2131559139));
    this.mHorDiverderA.setBackgroundColor(StyleManager.getColor(2131559139));
    this.mHorDiverderB.setBackgroundColor(StyleManager.getColor(2131559139));
    this.mHorDiverderC.setBackgroundColor(StyleManager.getColor(2131559139));
    this.mHorDiverderD.setBackgroundColor(StyleManager.getColor(2131559139));
    this.mVerDiverderA.setBackgroundColor(StyleManager.getColor(2131559139));
    this.mVerDiverder1A.setBackgroundColor(StyleManager.getColor(2131559139));
    this.mVerDiverder1B.setBackgroundColor(StyleManager.getColor(2131559139));
    this.mVerDiverder2A.setBackgroundColor(StyleManager.getColor(2131559139));
    this.mVerDiverder2B.setBackgroundColor(StyleManager.getColor(2131559139));
    this.mVerDiverder3A.setBackgroundColor(StyleManager.getColor(2131559139));
    this.mVerDiverder3B.setBackgroundColor(StyleManager.getColor(2131559139));
    this.mBtnStreet.setBackgroundDrawable(StyleManager.getDrawable(2130837694));
    this.mBtnPhoneCall.setBackgroundDrawable(StyleManager.getDrawable(2130837694));
    this.mBtnGooutPref.setBackgroundDrawable(StyleManager.getDrawable(2130837694));
    this.mBtnSetStart.setBackgroundDrawable(StyleManager.getDrawable(2130837694));
    this.mBtnSetEnd.setBackgroundDrawable(StyleManager.getDrawable(2130837694));
    this.mBtnSetVia.setBackgroundDrawable(StyleManager.getDrawable(2130837694));
    this.mBtnSpace.setBackgroundDrawable(StyleManager.getDrawable(2130837694));
    this.mBtnFaverite.setBackgroundDrawable(StyleManager.getDrawable(2130837694));
    this.mBtnShare.setBackgroundDrawable(StyleManager.getDrawable(2130837694));
    this.mBtnStartNavi.setBackgroundDrawable(StyleManager.getDrawable(2130837694));
    this.mBtnNameAddr.setBackgroundDrawable(StyleManager.getDrawable(2130837694));
    this.mTvName.setTextColor(StyleManager.getColor(2131559141));
    this.mTvAddr.setTextColor(StyleManager.getColor(2131559128));
    this.mTvStartNavi.setTextColor(StyleManager.getColor(2131559135));
    this.mTvDistance.setTextColor(StyleManager.getColor(2131559133));
    this.mTvStreet.setTextColor(StyleManager.getColor(2131559137));
    this.mTvPhoneCall.setTextColor(StyleManager.getColor(2131559137));
    this.mTvGoouPref.setTextColor(StyleManager.getColor(2131559137));
    this.mTvSetStart.setTextColor(StyleManager.getColor(2131559137));
    this.mTvSetEnd.setTextColor(StyleManager.getColor(2131559137));
    this.mTvSetVia.setTextColor(StyleManager.getColor(2131559137));
    this.mTvFaverite.setTextColor(StyleManager.getColor(2131559137));
    this.mTvShare.setTextColor(StyleManager.getColor(2131559137));
    this.mTvSpace.setTextColor(StyleManager.getColor(2131559137));
    this.mIvDragon.setImageDrawable(StyleManager.getDrawable(2130837799));
    this.mIvDragon.setBackgroundDrawable(StyleManager.getDrawable(2130837738));
    this.mContentLayout.setBackgroundColor(StyleManager.getColor(2131558420));
  }
  
  private void onClickDragon()
  {
    if (this.mDragonOnClickListener != null)
    {
      this.mDragonOnClickListener.onClick(null);
      return;
    }
    if (this.isOut)
    {
      inAnimation();
      return;
    }
    outAnimation();
  }
  
  private void outAnimation()
  {
    this.mLayoutParams.height = this.VIEW_HEIGHT;
    this.isAnimationing = false;
    this.isOut = true;
    updateDragonView();
    long l1 = BNMapController.getInstance().getMapStatus()._Yoffset;
    long l2 = OUT_CAP / 2;
    this.mPoiController.setMapffset(0L, l1 + l2);
    setLayoutParams(this.mLayoutParams);
  }
  
  private void startAntiGeo()
  {
    if (!this.isPickPoi)
    {
      this.mPbAntiGeo.setVisibility(0);
      this.mTvName.setVisibility(8);
      this.mTvAddr.setVisibility(8);
    }
  }
  
  private void updateDragonView()
  {
    if (this.isOut)
    {
      this.mIvDragon.setImageDrawable(StyleManager.getDrawable(2130837794));
      return;
    }
    this.mIvDragon.setImageDrawable(StyleManager.getDrawable(2130837799));
  }
  
  private void updateFavoriteIcon()
  {
    Drawable localDrawable;
    if (this.isFavorite)
    {
      localDrawable = StyleManager.getDrawable(2130837898);
      this.mTvFaverite.setText(2131296424);
    }
    for (;;)
    {
      this.mTvFaverite.setCompoundDrawablesWithIntrinsicBounds(null, localDrawable, null, null);
      return;
      localDrawable = StyleManager.getDrawable(2130837904);
      this.mTvFaverite.setText(2131296436);
    }
  }
  
  private void updatePanel() {}
  
  private void updatePanelVisibility()
  {
    this.mLayoutPanel3.setVisibility(0);
    this.mLayoutPanel2.setVisibility(0);
    this.mHorDiverderC.setVisibility(0);
    this.mHorDiverderD.setVisibility(0);
  }
  
  private void updatePoiByAntiPoi(SearchPoi paramSearchPoi)
  {
    if ((paramSearchPoi == null) || (this.mCurrentPoi == null)) {
      return;
    }
    if (this.isPickPoi)
    {
      String str = this.mCurrentPoi.mName;
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
  
  private void updateStreetIcon()
  {
    Drawable localDrawable;
    if (!TextUtils.isEmpty(this.mCurrentPoi.mStreetId))
    {
      localDrawable = StyleManager.getDrawable(2130837907);
      this.mBtnStreet.setClickable(true);
    }
    for (;;)
    {
      this.mTvStreet.setCompoundDrawablesWithIntrinsicBounds(null, localDrawable, null, null);
      return;
      localDrawable = StyleManager.getDrawable(2130837908);
      this.mBtnStreet.setClickable(false);
    }
  }
  
  public void antiPoi(GeoPoint paramGeoPoint, int paramInt1, int paramInt2)
  {
    if ((paramGeoPoint == null) || (!paramGeoPoint.isValid())) {
      return;
    }
    this.isPickPoi = false;
    SearchPoi localSearchPoi = new SearchPoi();
    localSearchPoi.mViewPoint = paramGeoPoint;
    localSearchPoi.mGuidePoint = paramGeoPoint;
    if (!this.isMyPosition)
    {
      this.mPoiController.focusPoi(localSearchPoi);
      this.mPoiController.animationTo(paramGeoPoint, paramInt1, paramInt2);
      paramInt1 = this.mPoiController.getAntiPoiNetMode(paramGeoPoint);
      if (paramInt1 != -1) {
        break label108;
      }
      localSearchPoi.mName = StyleManager.getString(2131296852);
    }
    for (;;)
    {
      setSearchPoi(localSearchPoi);
      return;
      this.mPoiController.clearPoiCache();
      break;
      label108:
      if (this.mPoiController.antiGeo(localSearchPoi, paramInt1, this.mUIHandler)) {
        startAntiGeo();
      }
    }
  }
  
  public boolean checkIsReGetAllFavPois()
  {
    return (this.isFavorite) && (this.mIsFavOperate);
  }
  
  public void checkStreetId() {}
  
  public int getIndex()
  {
    return this.mIndex;
  }
  
  public SearchPoi getSearchPoi()
  {
    return this.mCurrentPoi;
  }
  
  public int getViewHeight()
  {
    if (this.isOut) {
      return ScreenUtil.getInstance().dip2px(329);
    }
    return ScreenUtil.getInstance().dip2px(169);
  }
  
  public void handleShortUri(String paramString)
  {
    com.baidu.carlife.core.screen.presentation.a.e.a().b("分享中，请稍等...");
    this.mPoiController.sharePoiParseShortUrl(paramString, this.mUIHandler);
  }
  
  public void hide()
  {
    setVisibility(8);
    this.mCurrentPoi = null;
    this.mPoiController.clearPoiCache();
  }
  
  public boolean isOut()
  {
    return this.isOut;
  }
  
  public boolean isVisible()
  {
    return getVisibility() == 0;
  }
  
  public void onResume()
  {
    if ((this.mPoiController != null) && (isVisible()) && (!this.isMyPosition))
    {
      this.mPoiController.focusPoi(this.mCurrentPoi);
      int i = (getHeight() - ScreenUtil.getInstance().dip2px(60) - ScreenUtil.getInstance().getStatusBarHeight()) / 2;
      if (this.mCurrentPoi != null) {
        this.mPoiController.animationTo(this.mCurrentPoi.mViewPoint, 0L, i, -1, false);
      }
    }
  }
  
  public void pickPoi(SearchPoi paramSearchPoi, int paramInt1, int paramInt2)
  {
    if ((paramSearchPoi == null) || (paramSearchPoi.mViewPoint == null) || (!paramSearchPoi.mViewPoint.isValid())) {
      return;
    }
    this.isPickPoi = true;
    if (!this.isMyPosition)
    {
      this.mPoiController.focusPoi(paramSearchPoi);
      this.mPoiController.animationTo(paramSearchPoi, paramInt1, paramInt2);
    }
    for (;;)
    {
      paramInt1 = this.mPoiController.getAntiPoiNetMode(paramSearchPoi.mViewPoint);
      if ((paramInt1 != -1) && (this.mPoiController.antiGeo(paramSearchPoi, paramInt1, this.mUIHandler))) {
        startAntiGeo();
      }
      setSearchPoi(paramSearchPoi);
      return;
      this.mPoiController.clearPoiCache();
    }
  }
  
  public void setController(PoiController paramPoiController)
  {
    this.mPoiController = paramPoiController;
  }
  
  public void setDragonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mDragonOnClickListener = paramOnClickListener;
  }
  
  public void setDragonOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.mDragonOnTouchListener = paramOnTouchListener;
  }
  
  public void setFavSearchPoi(SearchPoi paramSearchPoi)
  {
    if (paramSearchPoi == null) {
      return;
    }
    this.isFavorite = true;
    this.mIsFavOperate = false;
    this.mCurrentPoi = paramSearchPoi;
    initContents();
    updateFavoriteIcon();
  }
  
  public void setIsGragonOut(boolean paramBoolean)
  {
    this.isOut = paramBoolean;
    updateDragonView();
  }
  
  public void setMyPositionMode(boolean paramBoolean)
  {
    int j = 8;
    boolean bool2 = true;
    this.isMyPosition = paramBoolean;
    Object localObject = this.mBtnStartNavi;
    int i;
    label42:
    boolean bool1;
    if (paramBoolean)
    {
      i = 8;
      ((View)localObject).setVisibility(i);
      localObject = this.mVerDiverderA;
      if (!paramBoolean) {
        break label119;
      }
      i = j;
      ((View)localObject).setVisibility(i);
      localObject = this.mBtnGooutPref;
      if (paramBoolean) {
        break label124;
      }
      bool1 = true;
      label61:
      ((View)localObject).setClickable(bool1);
      localObject = this.mBtnStartNavi;
      if (paramBoolean) {
        break label130;
      }
      bool1 = bool2;
      label82:
      ((View)localObject).setClickable(bool1);
      if (!paramBoolean) {
        break label136;
      }
    }
    label119:
    label124:
    label130:
    label136:
    for (localObject = StyleManager.getDrawable(2130837900);; localObject = StyleManager.getDrawable(2130837899))
    {
      this.mTvGoouPref.setCompoundDrawablesWithIntrinsicBounds(null, (Drawable)localObject, null, null);
      return;
      i = 0;
      break;
      i = 0;
      break label42;
      bool1 = false;
      break label61;
      bool1 = false;
      break label82;
    }
  }
  
  public void setOnDialogListener(com.baidu.carlife.core.screen.e parame)
  {
    this.mOnDialogListener = parame;
  }
  
  public void setPanelIn()
  {
    isPanelOut = false;
    this.mLayoutPanel3.setVisibility(8);
    this.mLayoutPanel2.setVisibility(8);
  }
  
  public void setPanelOut()
  {
    isPanelOut = true;
    this.mLayoutPanel3.setVisibility(0);
    this.mLayoutPanel2.setVisibility(0);
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
    if ((paramInt1 >= 0) && (paramInt2 == 0))
    {
      this.mTvNum.setVisibility(0);
      this.mTvNum.setText(paramInt1 + 1 + ".");
      this.mTvNum.setTextColor(StyleManager.getColor(2131559143));
    }
    for (;;)
    {
      this.mIndex = paramInt1;
      return;
      if ((paramInt1 >= 0) && (paramInt2 == 1))
      {
        this.mTvNum.setVisibility(0);
        this.mTvNum.setText(paramInt1 + 1 + "");
        this.mTvNum.setTextColor(StyleManager.getColor(0));
      }
      else
      {
        this.mTvNum.setVisibility(8);
      }
    }
  }
  
  public void setSupportDragon(boolean paramBoolean)
  {
    this.isSupportDragon = paramBoolean;
  }
  
  public void show()
  {
    if (this.VIEW_HEIGHT == 0)
    {
      this.VIEW_HEIGHT = ScreenUtil.getInstance().dip2px(327);
      this.mLayoutParams = new RelativeLayout.LayoutParams(-1, ScreenUtil.getInstance().dip2px(166));
      setLayoutParams(this.mLayoutParams);
      this.isOut = false;
      updateDragonView();
    }
    for (;;)
    {
      setVisibility(0);
      return;
      if (!isVisible())
      {
        int i = ScreenUtil.getInstance().dip2px(166);
        this.mLayoutParams.height = i;
        setLayoutParams(this.mLayoutParams);
        this.isOut = false;
        updateDragonView();
      }
    }
  }
  
  public void trigglePanel()
  {
    if (!isPanelOut) {}
    for (boolean bool = true;; bool = false)
    {
      isPanelOut = bool;
      updatePanel();
      return;
    }
  }
  
  public void updateContent()
  {
    initContents();
  }
  
  public void updateLayoutParams()
  {
    if (this.VIEW_HEIGHT != 0) {
      return;
    }
    this.VIEW_HEIGHT = getHeight();
    this.mLayoutParams.height = (this.VIEW_HEIGHT - getCap());
    setLayoutParams(this.mLayoutParams);
    this.isOut = false;
    updateDragonView();
  }
  
  public void updateStyle()
  {
    initSkins();
    updateDragonView();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/PoiDetailView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */