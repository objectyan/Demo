package com.baidu.navi.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.baidu.carlife.core.screen.e;
import com.baidu.navi.adapter.PoiListPagerAdapter;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.CommonParams.NL_Net_Mode;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.model.modelfactory.NaviDataEngine;
import com.baidu.navisdk.model.modelfactory.PoiSearchModel;
import com.baidu.navisdk.ui.util.ForbidDaulClickUtils;
import com.baidu.navisdk.util.common.ScreenUtil;
import com.baidu.nplatform.comapi.basestruct.MapStatus;
import java.util.ArrayList;

public class PoiListView
  extends FrameLayout
{
  private int VIEW_HEIGHT = 0;
  private boolean isAnimationing = false;
  private boolean isFirstTime = true;
  private boolean isOut = false;
  private PoiListPagerAdapter mAdapter;
  private ImageView mBtnDown;
  private ImageView mBtnUp;
  private int[] mChildCnt = new int['È'];
  private int[] mChildIndex = new int['È'];
  private View mContentLayout;
  private int mCurrentId = 0;
  private int mCurrentIndex = -1;
  private SearchPoi mCurrentPoi;
  private int mDuration;
  private CommonParams.NL_Net_Mode mNetMode;
  private e mOnDialogListener;
  private ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener()
  {
    public void onPageScrollStateChanged(int paramAnonymousInt) {}
    
    public void onPageScrolled(int paramAnonymousInt1, float paramAnonymousFloat, int paramAnonymousInt2) {}
    
    public void onPageSelected(int paramAnonymousInt)
    {
      if (PoiListView.this.mCurrentIndex == -1) {
        PoiListView.access$302(PoiListView.this, 0);
      }
      if (PoiListView.this.mCurrentIndex < paramAnonymousInt)
      {
        StatisticManager.onEvent("410139", "410139");
        PoiListView.this.mTagViews[PoiListView.this.mCurrentIndex].setImageDrawable(StyleManager.getDrawable(2130837909));
        PoiListView.access$302(PoiListView.this, paramAnonymousInt);
        PoiListView.access$502(PoiListView.this, (SearchPoi)PoiListView.this.mPoiList.get(PoiListView.this.mCurrentIndex));
        PoiListView.this.mTagViews[PoiListView.this.mCurrentIndex].setImageDrawable(StyleManager.getDrawable(2130837911));
        if (PoiListView.this.mCurrentIndex != 0) {
          break label335;
        }
        PoiListView.this.mBtnUp.setVisibility(4);
        label142:
        if (PoiListView.this.mCurrentIndex != PoiListView.this.mTagViews.length - 1) {
          break label349;
        }
        PoiListView.this.mBtnDown.setVisibility(4);
      }
      for (;;)
      {
        label173:
        if ((PoiListView.this.mChildCnt != null) && (PoiListView.this.mChildCnt[PoiListView.this.mCurrentIndex] > 0))
        {
          ArrayList localArrayList1 = new ArrayList(PoiListView.this.mChildCnt[PoiListView.this.mCurrentIndex] + 1);
          ArrayList localArrayList2 = (ArrayList)((PoiSearchModel)NaviDataEngine.getInstance().getModel("PoiSearchModel")).getPoiList();
          localArrayList1.add(localArrayList2.get(PoiListView.this.mCurrentIndex));
          paramAnonymousInt = 0;
          for (;;)
          {
            if (paramAnonymousInt < PoiListView.this.mChildCnt[PoiListView.this.mCurrentIndex])
            {
              localArrayList1.add(localArrayList2.get(PoiListView.this.mChildIndex[PoiListView.this.mCurrentIndex] + paramAnonymousInt));
              paramAnonymousInt += 1;
              continue;
              if (PoiListView.this.mCurrentIndex <= paramAnonymousInt) {
                break;
              }
              StatisticManager.onEvent("410140", "410140");
              break;
              label335:
              PoiListView.this.mBtnUp.setVisibility(0);
              break label142;
              label349:
              PoiListView.this.mBtnDown.setVisibility(0);
              break label173;
            }
          }
          PoiListView.access$1102(PoiListView.this, 0);
          PoiListView.access$1202(PoiListView.this, localArrayList1);
          PoiListView.this.mPoiController.focusPoi(PoiListView.this.mParPoiList, PoiListView.this.mCurrentId);
        }
      }
      for (;;)
      {
        PoiListView.this.mPoiController.animationByFrogleap(PoiListView.this.mCurrentPoi);
        PoiListView.this.mAdapter.selectIndex(PoiListView.this.mCurrentIndex);
        return;
        if (PoiListView.this.mCurrentPoi.mFCType == 1)
        {
          PoiListView.access$1102(PoiListView.this, PoiListView.this.mCurrentIndex + 1);
          PoiListView.this.mPoiController.focusPoi(PoiListView.this.mParPoiList, PoiListView.this.mCurrentId);
        }
        else
        {
          PoiListView.access$1102(PoiListView.this, 0);
          PoiListView.this.mPoiController.focusPoi(PoiListView.this.mCurrentPoi);
        }
      }
    }
  };
  private ArrayList<SearchPoi> mParPoiList;
  private PoiController mPoiController;
  private ArrayList<SearchPoi> mPoiList;
  private LinearLayout mTagLayout;
  private ImageView[] mTagViews;
  private Handler mUIHandler;
  private HeightWrapableViewPager mViewPager;
  private ViewGroup.LayoutParams mViewPagerLayoutParams;
  
  public PoiListView(Context paramContext)
  {
    super(paramContext);
    PoiDetailView.isPanelOut = false;
    findViews(paramContext);
    initSkins();
    this.mUIHandler = new Handler(Looper.getMainLooper());
    this.mDuration = (PoiDetailView.getCap() / 10);
  }
  
  public PoiListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    PoiDetailView.isPanelOut = false;
    findViews(paramContext);
    initSkins();
    this.mUIHandler = new Handler(Looper.getMainLooper());
    this.mDuration = (PoiDetailView.getCap() / 10);
  }
  
  public PoiListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    PoiDetailView.isPanelOut = false;
    findViews(paramContext);
    initSkins();
    this.mUIHandler = new Handler(Looper.getMainLooper());
    this.mDuration = (PoiDetailView.getCap() / 10);
  }
  
  private void findViews(Context paramContext)
  {
    this.mContentLayout = LayoutInflater.from(paramContext).inflate(2130968991, null);
    addView(this.mContentLayout);
    this.mBtnDown = ((ImageView)this.mContentLayout.findViewById(2131624225));
    this.mBtnUp = ((ImageView)this.mContentLayout.findViewById(2131624224));
    this.mViewPager = ((HeightWrapableViewPager)this.mContentLayout.findViewById(2131624227));
    this.mTagLayout = ((LinearLayout)this.mContentLayout.findViewById(2131624226));
    this.mBtnUp.setVisibility(4);
    getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        if ((PoiListView.this.VIEW_HEIGHT == 0) || (PoiListView.this.mViewPagerLayoutParams == null))
        {
          PoiListView.access$1502(PoiListView.this, PoiListView.this.mViewPager.getHeight());
          PoiListView.access$1602(PoiListView.this, PoiListView.this.mViewPager.getLayoutParams());
          if ((PoiListView.this.VIEW_HEIGHT != 0) && (PoiListView.this.mViewPagerLayoutParams != null))
          {
            PoiListView.this.mViewPagerLayoutParams.height = (PoiListView.this.VIEW_HEIGHT - PoiDetailView.getCap());
            PoiListView.this.mViewPager.setLayoutParams(PoiListView.this.mViewPagerLayoutParams);
            PoiListView.access$002(PoiListView.this, false);
            PoiListView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
          }
        }
      }
    });
  }
  
  private void inAnimation()
  {
    this.mViewPagerLayoutParams.height = (this.VIEW_HEIGHT - PoiDetailView.getCap());
    this.isOut = false;
    this.mAdapter.setIsDragonOut(this.isOut);
    long l1 = BNMapController.getInstance().getMapStatus()._Yoffset;
    long l2 = PoiDetailView.getCap() / 2;
    this.mPoiController.setMapffset(0L, l1 - l2);
    this.mViewPager.setLayoutParams(this.mViewPagerLayoutParams);
  }
  
  private void initContents()
  {
    if ((this.mPoiList == null) || (this.mPoiList.size() == 0)) {
      return;
    }
    this.mTagViews = new ImageView[this.mPoiList.size()];
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    localLayoutParams.leftMargin = ScreenUtil.getInstance().dip2px(5);
    localLayoutParams.rightMargin = ScreenUtil.getInstance().dip2px(5);
    int i = 0;
    while (i < this.mPoiList.size())
    {
      this.mTagViews[i] = new ImageView(getContext());
      this.mTagViews[i].setImageDrawable(StyleManager.getDrawable(2130837909));
      this.mTagLayout.addView(this.mTagViews[i], localLayoutParams);
      i += 1;
    }
    this.mTagViews[0].setImageDrawable(StyleManager.getDrawable(2130837911));
    this.mBtnUp.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (ForbidDaulClickUtils.isFastDoubleClick()) {}
        do
        {
          return;
          StatisticManager.onEvent("410141", "410141");
        } while (PoiListView.this.mCurrentIndex <= 0);
        PoiListView.this.mViewPager.setCurrentItem(PoiListView.this.mCurrentIndex - 1, true);
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
          StatisticManager.onEvent("410142", "410142");
          if (PoiListView.this.mCurrentIndex < 0) {
            PoiListView.access$302(PoiListView.this, 0);
          }
        } while (PoiListView.this.mCurrentIndex >= PoiListView.this.mPoiList.size() - 1);
        PoiListView.this.mViewPager.setCurrentItem(PoiListView.this.mCurrentIndex + 1, true);
      }
    });
  }
  
  private void initSkins()
  {
    this.mBtnDown.setImageDrawable(StyleManager.getDrawable(2130837895));
    this.mBtnUp.setImageDrawable(StyleManager.getDrawable(2130837917));
    this.mBtnDown.setBackgroundDrawable(StyleManager.getDrawable(2130837694));
    this.mBtnUp.setBackgroundDrawable(StyleManager.getDrawable(2130837694));
    this.mContentLayout.setBackgroundColor(StyleManager.getColor(2131558420));
    if (this.mTagViews != null)
    {
      int i = 0;
      while (i < this.mTagViews.length)
      {
        this.mTagViews[i].setImageDrawable(StyleManager.getDrawable(2130837909));
        i += 1;
      }
      if ((this.mCurrentIndex >= 0) && (this.mCurrentIndex < this.mTagViews.length)) {
        this.mTagViews[this.mCurrentIndex].setImageDrawable(StyleManager.getDrawable(2130837911));
      }
    }
  }
  
  private void outAnimation()
  {
    this.mViewPagerLayoutParams.height = this.VIEW_HEIGHT;
    this.isOut = true;
    this.mAdapter.setIsDragonOut(this.isOut);
    long l1 = BNMapController.getInstance().getMapStatus()._Yoffset;
    long l2 = PoiDetailView.getCap() / 2;
    this.mPoiController.setMapffset(0L, l1 + l2);
    this.mViewPager.setLayoutParams(this.mViewPagerLayoutParams);
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
    if (this.mCurrentIndex == -1) {
      this.mCurrentIndex = 0;
    }
    return this.mCurrentIndex;
  }
  
  public int getViewHeight()
  {
    if (this.isOut) {
      return ScreenUtil.getInstance().dip2px(369);
    }
    return ScreenUtil.getInstance().dip2px(209);
  }
  
  public boolean isOut()
  {
    return this.isOut;
  }
  
  public void setChildCnt(int[] paramArrayOfInt)
  {
    this.mChildCnt = paramArrayOfInt;
  }
  
  public void setChildIndex(int[] paramArrayOfInt)
  {
    this.mChildIndex = paramArrayOfInt;
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
    this.mCurrentPoi = ((SearchPoi)this.mPoiList.get(paramInt));
    if (this.mCurrentIndex == paramInt) {
      this.mPoiController.animationTo(this.mCurrentPoi);
    }
    for (;;)
    {
      this.mPoiController.focusPoi(this.mCurrentPoi);
      return;
      this.mViewPager.setCurrentItem(paramInt);
    }
  }
  
  public void setCurrentIndex(int paramInt1, ArrayList<SearchPoi> paramArrayList, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramArrayList == null) || (paramInt2 >= paramArrayList.size())) {
      return;
    }
    this.mCurrentPoi = ((SearchPoi)paramArrayList.get(paramInt2));
    this.mParPoiList = paramArrayList;
    this.mCurrentId = paramInt2;
    if (this.mCurrentIndex == paramInt1) {
      this.mPoiController.animationTo(this.mCurrentPoi);
    }
    while (paramArrayList.size() > 1)
    {
      this.mPoiController.focusPoi(paramArrayList, paramInt2);
      return;
      this.mViewPager.setCurrentItem(paramInt1);
    }
    this.mPoiController.focusPoi(this.mCurrentPoi);
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
    this.mAdapter = new PoiListPagerAdapter(getContext(), this.mPoiList, this.mPoiController, this.mOnDialogListener);
    this.mViewPager.setAdapter(this.mAdapter);
    this.mViewPager.setOnPageChangeListener(this.mOnPageChangeListener);
    initContents();
    this.mAdapter.setDragonOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (PoiListView.this.isOut)
        {
          PoiListView.this.inAnimation();
          return;
        }
        PoiListView.this.outAnimation();
      }
    });
  }
  
  public void updateContent()
  {
    initContents();
  }
  
  public void updateStyle()
  {
    initSkins();
    if (this.mAdapter != null) {
      this.mAdapter.updateStyle();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/PoiListView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */