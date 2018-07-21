package com.baidu.navi.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import com.baidu.carlife.core.screen.e;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.view.PoiDetailView;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import java.util.List;

public class PoiListPagerAdapter
  extends PagerAdapter
{
  private static final String TAG = "PoiSearch";
  private boolean isViewDragonOut = false;
  private Context mContext;
  private View mCurrentView;
  private View.OnClickListener mDragonOnClickListener;
  private View.OnTouchListener mDragonOnTouchListener;
  private e mOnDialogListener;
  private PoiController mPoiController;
  private PoiDetailView[] mPoiDetailViews;
  private List<SearchPoi> mPoiList;
  private int mSelectIndex = -1;
  
  public PoiListPagerAdapter(Context paramContext, List<SearchPoi> paramList, PoiController paramPoiController, e parame)
  {
    this.mPoiList = paramList;
    this.mContext = paramContext;
    this.mPoiController = paramPoiController;
    this.mPoiDetailViews = new PoiDetailView[getCount()];
    this.mOnDialogListener = parame;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    int i = 10;
    if (this.mPoiList == null) {
      i = 0;
    }
    while (this.mPoiList.size() > 10) {
      return i;
    }
    return this.mPoiList.size();
  }
  
  public View getPrimaryItem()
  {
    return this.mCurrentView;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt >= getCount()) {
      return null;
    }
    PoiDetailView localPoiDetailView2 = this.mPoiDetailViews[paramInt];
    PoiDetailView localPoiDetailView1 = localPoiDetailView2;
    if (localPoiDetailView2 == null)
    {
      localPoiDetailView1 = new PoiDetailView(this.mContext);
      localPoiDetailView1.setOnDialogListener(this.mOnDialogListener);
      localPoiDetailView1.setController(this.mPoiController);
      localPoiDetailView1.setSearchPoi((SearchPoi)this.mPoiList.get(paramInt));
      localPoiDetailView1.setSearchPoiIndex(paramInt, ((SearchPoi)this.mPoiList.get(paramInt)).mFCType);
      localPoiDetailView1.setTag(Integer.valueOf(paramInt));
      localPoiDetailView1.setId(paramInt);
      this.mPoiDetailViews[paramInt] = localPoiDetailView1;
      if (this.mSelectIndex == paramInt) {
        localPoiDetailView1.checkStreetId();
      }
      localPoiDetailView1.setIsGragonOut(this.isViewDragonOut);
      localPoiDetailView1.updateStyle();
    }
    localPoiDetailView1.setDragonOnClickListener(this.mDragonOnClickListener);
    localPoiDetailView1.setDragonOnTouchListener(this.mDragonOnTouchListener);
    paramViewGroup.addView(localPoiDetailView1);
    return localPoiDetailView1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void selectIndex(int paramInt)
  {
    this.mSelectIndex = paramInt;
    if ((this.mSelectIndex >= 0) && (this.mSelectIndex < this.mPoiDetailViews.length))
    {
      PoiDetailView localPoiDetailView = this.mPoiDetailViews[this.mSelectIndex];
      if (localPoiDetailView != null)
      {
        this.mSelectIndex = -1;
        localPoiDetailView.checkStreetId();
      }
    }
  }
  
  public void setDragonOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.mDragonOnClickListener = paramOnClickListener;
  }
  
  public void setDragonOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    this.mDragonOnTouchListener = paramOnTouchListener;
  }
  
  public void setIsDragonOut(boolean paramBoolean)
  {
    this.isViewDragonOut = paramBoolean;
    int i = 0;
    while (i < this.mPoiDetailViews.length)
    {
      PoiDetailView localPoiDetailView = this.mPoiDetailViews[i];
      if (localPoiDetailView != null) {
        localPoiDetailView.setIsGragonOut(this.isViewDragonOut);
      }
      i += 1;
    }
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    this.mCurrentView = ((View)paramObject);
  }
  
  public void updateStyle()
  {
    int i = 0;
    while (i < this.mPoiDetailViews.length)
    {
      if (this.mPoiDetailViews[i] != null) {
        this.mPoiDetailViews[i].updateStyle();
      }
      i += 1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/adapter/PoiListPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */