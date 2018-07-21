package com.baidu.navi.view;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
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
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.util.common.ScreenUtil;
import java.util.ArrayList;

public class CarmodePoiListView
  extends FrameLayout
{
  private TextView mAddrTextView;
  private ImageView mBtnDown;
  private ImageView mBtnUp;
  private PoiDetailViewController.IPoiDetailViewCallBack mCallBack = new PoiDetailViewController.IPoiDetailViewCallBack()
  {
    public void onFavSyncDone(String paramAnonymousString)
    {
      CarmodePoiListView.this.updateFavBtnBackground();
    }
  };
  private int[] mChildCnt = new int['È'];
  private int[] mChildIndex = new int['È'];
  private int mComeFrom;
  private View mContentLayout;
  private int mCurrentId = 0;
  private int mCurrentIndex = 0;
  private SearchPoi mCurrentPoi;
  private View mDistanceLayout;
  private TextView mDistanceTextView;
  private ImageView mFavBtn;
  private View mNameAddrLayout;
  private TextView mNameTextView;
  private e mOnDialogListener;
  private ArrayList<SearchPoi> mParPoiList;
  private View mPhoneLayout;
  private TextView mPhoneNumberTextView;
  private PoiController mPoiController;
  private PoiDetailViewController mPoiDetailViewController = new PoiDetailViewController();
  private ArrayList<SearchPoi> mPoiList;
  private Handler mUIHandler;
  private long xOffset = ScreenUtil.getInstance().dip2px(65286) / 2;
  private long yOffset = ScreenUtil.getInstance().dip2px(0) / 2;
  
  public CarmodePoiListView(Context paramContext)
  {
    super(paramContext);
    findViews(paramContext);
    initSkins();
    this.mUIHandler = new Handler(Looper.getMainLooper());
  }
  
  public CarmodePoiListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    findViews(paramContext);
    initSkins();
    this.mUIHandler = new Handler(Looper.getMainLooper());
  }
  
  public CarmodePoiListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    findViews(paramContext);
    initSkins();
    this.mUIHandler = new Handler(Looper.getMainLooper());
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
    this.mBtnDown = ((ImageView)this.mContentLayout.findViewById(2131624547));
    this.mBtnUp = ((ImageView)this.mContentLayout.findViewById(2131624546));
    this.mBtnUp.setVisibility(4);
    this.mFavBtn = ((ImageView)this.mContentLayout.findViewById(2131624540));
    this.mPhoneLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CarmodePoiListView.this.startPhoneCall();
      }
    });
    this.mDistanceLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CarmodePoiListView.this.startCalcRoute();
      }
    });
    this.mNameAddrLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        CarmodePoiListView.this.clickFavBtn();
      }
    });
  }
  
  private void initContents()
  {
    if ((this.mPoiList == null) || (this.mPoiList.size() == 0)) {
      return;
    }
    if (this.mPoiList.size() > 1)
    {
      this.mBtnUp.setVisibility(0);
      this.mBtnDown.setVisibility(0);
    }
    this.mBtnUp.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ForbidDaulClickUtils.isFastDoubleClick()) {}
        while (CarmodePoiListView.this.mCurrentIndex <= 0) {
          return;
        }
        CarmodePoiListView.access$210(CarmodePoiListView.this);
        CarmodePoiListView.access$502(CarmodePoiListView.this, (SearchPoi)CarmodePoiListView.this.mPoiList.get(CarmodePoiListView.this.mCurrentIndex));
        CarmodePoiListView.this.updateUpDownBtn();
        CarmodePoiListView.this.updatePoiInfo(CarmodePoiListView.this.mCurrentPoi);
        if ((CarmodePoiListView.this.mChildCnt != null) && (CarmodePoiListView.this.mChildCnt[CarmodePoiListView.this.mCurrentIndex] > 0))
        {
          paramAnonymousView = new ArrayList(CarmodePoiListView.this.mChildCnt[CarmodePoiListView.this.mCurrentIndex] + 1);
          ArrayList localArrayList = (ArrayList)((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getPoiList();
          paramAnonymousView.add(localArrayList.get(CarmodePoiListView.this.mCurrentIndex));
          int i = 0;
          while (i < CarmodePoiListView.this.mChildCnt[CarmodePoiListView.this.mCurrentIndex])
          {
            paramAnonymousView.add(localArrayList.get(CarmodePoiListView.this.mChildIndex[CarmodePoiListView.this.mCurrentIndex] + i));
            i += 1;
          }
          CarmodePoiListView.access$902(CarmodePoiListView.this, 0);
          CarmodePoiListView.access$1002(CarmodePoiListView.this, paramAnonymousView);
          CarmodePoiListView.this.mPoiController.focusPoi(CarmodePoiListView.this.mParPoiList, CarmodePoiListView.this.mCurrentId);
        }
        for (;;)
        {
          CarmodePoiListView.this.mPoiController.animationByFrogleap(CarmodePoiListView.this.mCurrentPoi);
          return;
          if (CarmodePoiListView.this.mCurrentPoi.mFCType == 1)
          {
            CarmodePoiListView.access$902(CarmodePoiListView.this, CarmodePoiListView.this.mCurrentIndex + 1);
            CarmodePoiListView.this.mPoiController.focusPoi(CarmodePoiListView.this.mParPoiList, CarmodePoiListView.this.mCurrentId);
          }
          else
          {
            CarmodePoiListView.access$902(CarmodePoiListView.this, 0);
            CarmodePoiListView.this.mPoiController.focusPoi(CarmodePoiListView.this.mCurrentPoi);
          }
        }
      }
    });
    this.mBtnDown.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ForbidDaulClickUtils.isFastDoubleClick()) {}
        do
        {
          return;
          if (CarmodePoiListView.this.mCurrentIndex < 0) {
            CarmodePoiListView.access$202(CarmodePoiListView.this, 0);
          }
        } while (CarmodePoiListView.this.mCurrentIndex >= CarmodePoiListView.this.mPoiList.size() - 1);
        CarmodePoiListView.access$208(CarmodePoiListView.this);
        CarmodePoiListView.access$502(CarmodePoiListView.this, (SearchPoi)CarmodePoiListView.this.mPoiList.get(CarmodePoiListView.this.mCurrentIndex));
        CarmodePoiListView.this.updateUpDownBtn();
        CarmodePoiListView.this.updatePoiInfo(CarmodePoiListView.this.mCurrentPoi);
        if ((CarmodePoiListView.this.mChildCnt != null) && (CarmodePoiListView.this.mChildCnt[CarmodePoiListView.this.mCurrentIndex] > 0))
        {
          paramAnonymousView = new ArrayList(CarmodePoiListView.this.mChildCnt[CarmodePoiListView.this.mCurrentIndex] + 1);
          ArrayList localArrayList = (ArrayList)((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getPoiList();
          paramAnonymousView.add(localArrayList.get(CarmodePoiListView.this.mCurrentIndex));
          int i = 0;
          while (i < CarmodePoiListView.this.mChildCnt[CarmodePoiListView.this.mCurrentIndex])
          {
            paramAnonymousView.add(localArrayList.get(CarmodePoiListView.this.mChildIndex[CarmodePoiListView.this.mCurrentIndex] + i));
            i += 1;
          }
          CarmodePoiListView.access$902(CarmodePoiListView.this, 0);
          CarmodePoiListView.access$1002(CarmodePoiListView.this, paramAnonymousView);
          CarmodePoiListView.this.mPoiController.focusPoi(CarmodePoiListView.this.mParPoiList, CarmodePoiListView.this.mCurrentId);
        }
        for (;;)
        {
          CarmodePoiListView.this.mPoiController.animationByFrogleap(CarmodePoiListView.this.mCurrentPoi);
          CarmodePoiListView.this.mPoiController.animationTo(CarmodePoiListView.this.mCurrentPoi, CarmodePoiListView.this.xOffset, CarmodePoiListView.this.yOffset);
          return;
          if (CarmodePoiListView.this.mCurrentPoi.mFCType == 1)
          {
            CarmodePoiListView.access$902(CarmodePoiListView.this, CarmodePoiListView.this.mCurrentIndex + 1);
            CarmodePoiListView.this.mPoiController.focusPoi(CarmodePoiListView.this.mParPoiList, CarmodePoiListView.this.mCurrentId);
          }
          else
          {
            CarmodePoiListView.access$902(CarmodePoiListView.this, 0);
            CarmodePoiListView.this.mPoiController.focusPoi(CarmodePoiListView.this.mCurrentPoi);
          }
        }
      }
    });
  }
  
  private void initSkins() {}
  
  private void poiDetailViewControllerInit()
  {
    this.mPoiDetailViewController.init(this.mCurrentPoi);
    this.mPoiDetailViewController.setCallBack(this.mCallBack);
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
    new HaveFavTask(this.mCurrentIndex).execute(new Void[0]);
  }
  
  public void clickFavBtn()
  {
    if (ForbidDaulClickUtils.isFastDoubleClick()) {
      return;
    }
    poiDetailViewControllerInit();
    this.mPoiDetailViewController.addOrDelFav();
  }
  
  public ArrayList<SearchPoi> getCurrentPoiList()
  {
    return this.mParPoiList;
  }
  
  public SearchPoi getCurrentSearchPoi()
  {
    return this.mCurrentPoi;
  }
  
  public int getCurretnId()
  {
    return this.mCurrentId;
  }
  
  public int getCurretnIndex()
  {
    return this.mCurrentIndex;
  }
  
  public void setChildCnt(int[] paramArrayOfInt)
  {
    this.mChildCnt = paramArrayOfInt;
  }
  
  public void setChildIndex(int[] paramArrayOfInt)
  {
    this.mChildIndex = paramArrayOfInt;
  }
  
  public void setComeFrom(int paramInt)
  {
    this.mComeFrom = paramInt;
  }
  
  public void setController(PoiController paramPoiController)
  {
    this.mPoiController = paramPoiController;
  }
  
  public void setCurrentIndex(int paramInt)
  {
    if ((paramInt < 0) || (this.mPoiList == null) || (paramInt >= this.mPoiList.size())) {
      return;
    }
    this.mCurrentIndex = paramInt;
    this.mCurrentPoi = ((SearchPoi)this.mPoiList.get(paramInt));
    this.mPoiController.focusPoi(this.mCurrentPoi);
    this.mPoiController.animationTo(this.mCurrentPoi);
    updatePoiInfo(this.mCurrentPoi);
    updateUpDownBtn();
  }
  
  public void setCurrentIndex(int paramInt1, ArrayList<SearchPoi> paramArrayList, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramArrayList == null) || (paramInt2 >= paramArrayList.size())) {
      return;
    }
    this.mCurrentIndex = paramInt1;
    this.mCurrentId = paramInt2;
    this.mCurrentPoi = ((SearchPoi)paramArrayList.get(paramInt2));
    this.mParPoiList = paramArrayList;
    this.mPoiController.animationTo(this.mCurrentPoi);
    updatePoiInfo(this.mCurrentPoi);
    if (paramArrayList.size() > 1) {
      this.mPoiController.focusPoi(paramArrayList, paramInt2);
    }
    for (;;)
    {
      updateUpDownBtn();
      return;
      this.mPoiController.focusPoi(this.mCurrentPoi);
    }
  }
  
  public void setOnDialogListener(e parame)
  {
    this.mOnDialogListener = parame;
  }
  
  public void setSearchPoiList(ArrayList<SearchPoi> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    this.mPoiList = paramArrayList;
    initContents();
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
  
  public void updatePoiInfo(SearchPoi paramSearchPoi)
  {
    poiDetailViewControllerInit();
    this.mNameTextView.setText(paramSearchPoi.mName);
    if (paramSearchPoi.mAddress == null)
    {
      this.mAddrTextView.setVisibility(4);
      if (!this.mCurrentPoi.mName.equals(StyleManager.getString(2131296852))) {
        break label172;
      }
      this.mNameAddrLayout.setClickable(false);
      label57:
      this.mPhoneLayout.setVisibility(0);
      this.mDistanceLayout.setVisibility(0);
      if ((paramSearchPoi.mPhone != null) && (!paramSearchPoi.mPhone.isEmpty())) {
        break label183;
      }
      this.mPhoneNumberTextView.setText(2131296726);
    }
    for (;;)
    {
      paramSearchPoi = this.mDistanceTextView;
      StringBuilder localStringBuilder = new StringBuilder().append("距离");
      PoiController localPoiController = this.mPoiController;
      paramSearchPoi.setText(PoiController.getInstance().getDistance2CurrentPoint(this.mCurrentPoi));
      updateFavBtnBackground();
      return;
      this.mAddrTextView.setVisibility(0);
      this.mAddrTextView.setText(paramSearchPoi.mAddress);
      break;
      label172:
      this.mNameAddrLayout.setClickable(true);
      break label57;
      label183:
      this.mPhoneNumberTextView.setText(paramSearchPoi.mPhone + "　");
    }
  }
  
  public void updateStyle()
  {
    initSkins();
  }
  
  public void updateUpDownBtn()
  {
    if (this.mPoiList == null) {
      return;
    }
    if (this.mCurrentIndex == 0)
    {
      this.mBtnUp.setImageDrawable(StyleManager.getDrawable(2130838918));
      this.mBtnUp.setEnabled(false);
    }
    while (this.mCurrentIndex == this.mPoiList.size() - 1)
    {
      this.mBtnDown.setImageDrawable(StyleManager.getDrawable(2130838916));
      this.mBtnDown.setEnabled(false);
      return;
      this.mBtnUp.setImageDrawable(StyleManager.getDrawable(2130838917));
      this.mBtnUp.setEnabled(true);
    }
    this.mBtnDown.setImageDrawable(StyleManager.getDrawable(2130838915));
    this.mBtnDown.setEnabled(true);
  }
  
  private class HaveFavTask
    extends AsyncTask<Void, Void, Boolean>
  {
    private int index;
    
    public HaveFavTask(int paramInt)
    {
      this.index = paramInt;
    }
    
    protected Boolean doInBackground(Void... paramVarArgs)
    {
      return Boolean.valueOf(CarmodePoiListView.this.mPoiDetailViewController.isHaveFav());
    }
    
    protected void onPostExecute(Boolean paramBoolean)
    {
      if (this.index == CarmodePoiListView.this.mCurrentIndex) {
        CarmodePoiListView.this.updateFavBtn(paramBoolean.booleanValue());
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/CarmodePoiListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */