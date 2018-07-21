package com.baidu.navi.adapter.carmode;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.carlife.core.screen.e;
import com.baidu.navi.controller.PoiController;
import com.baidu.navi.view.CarmodePoiDetailView;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import java.util.List;

public class CarmodePoiListPagerAdapter
  extends PagerAdapter
{
  private static final String TAG = "PoiSearch";
  private boolean isOut;
  private Context mContext;
  private View mCurrentView;
  private e mOnDialogListener;
  private PoiController mPoiController;
  private CarmodePoiDetailView[] mPoiDetailViews;
  private List<SearchPoi> mPoiList;
  private int mSelectIndex = -1;
  
  public CarmodePoiListPagerAdapter(Context paramContext, List<SearchPoi> paramList, PoiController paramPoiController, e parame)
  {
    this.mPoiList = paramList;
    this.mContext = paramContext;
    this.mPoiController = paramPoiController;
    this.mPoiDetailViews = new CarmodePoiDetailView[getCount()];
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
    CarmodePoiDetailView localCarmodePoiDetailView2 = this.mPoiDetailViews[paramInt];
    CarmodePoiDetailView localCarmodePoiDetailView1 = localCarmodePoiDetailView2;
    if (localCarmodePoiDetailView2 == null)
    {
      localCarmodePoiDetailView1 = new CarmodePoiDetailView(this.mContext);
      localCarmodePoiDetailView1.setOnDialogListener(this.mOnDialogListener);
      localCarmodePoiDetailView1.setController(this.mPoiController);
      localCarmodePoiDetailView1.setSearchPoi((SearchPoi)this.mPoiList.get(paramInt));
      localCarmodePoiDetailView1.setSearchPoiIndex(paramInt, ((SearchPoi)this.mPoiList.get(paramInt)).mFCType);
      localCarmodePoiDetailView1.setTag(Integer.valueOf(paramInt));
      localCarmodePoiDetailView1.setId(paramInt);
      this.mPoiDetailViews[paramInt] = localCarmodePoiDetailView1;
      if (this.mSelectIndex != paramInt) {}
    }
    paramViewGroup.addView(localCarmodePoiDetailView1);
    return localCarmodePoiDetailView1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void selectIndex(int paramInt)
  {
    this.mSelectIndex = paramInt;
    if ((this.mSelectIndex >= 0) && (this.mSelectIndex < this.mPoiDetailViews.length) && (this.mPoiDetailViews[this.mSelectIndex] != null)) {}
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    this.mCurrentView = ((View)paramObject);
  }
  
  public void toggle(boolean paramBoolean)
  {
    this.isOut = paramBoolean;
    int i = 0;
    while (i < this.mPoiDetailViews.length)
    {
      if (this.mPoiDetailViews[i] != null) {}
      i += 1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/adapter/carmode/CarmodePoiListPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */