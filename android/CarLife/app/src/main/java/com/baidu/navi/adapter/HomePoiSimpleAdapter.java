package com.baidu.navi.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.style.StyleManager;
import com.baidu.navisdk.comapi.mapcontrol.BNMapController;
import com.baidu.navisdk.comapi.userdata.BNFavoriteManager;
import com.baidu.navisdk.model.datastruct.SearchPoi;
import com.baidu.navisdk.ui.util.TipTool;
import java.util.ArrayList;

public class HomePoiSimpleAdapter
  extends PagerAdapter
{
  private static final String TAG = "PoiSearch";
  private Context mContext;
  private View mCurrentView;
  private NaviFragmentManager mNaviFragmentManager;
  private ArrayList<SearchPoi> mPoiList;
  
  public HomePoiSimpleAdapter(Activity paramActivity, ArrayList<SearchPoi> paramArrayList, NaviFragmentManager paramNaviFragmentManager)
  {
    this.mPoiList = paramArrayList;
    this.mContext = paramActivity;
    this.mNaviFragmentManager = paramNaviFragmentManager;
  }
  
  private void initPoiPanelView(View paramView, SearchPoi paramSearchPoi)
  {
    if ((paramView == null) || (paramSearchPoi == null)) {
      return;
    }
    paramView.setBackgroundColor(StyleManager.getColor(2131558420));
    TextView localTextView1 = (TextView)paramView.findViewById(2131624196);
    TextView localTextView2 = (TextView)paramView.findViewById(2131624197);
    TextView localTextView3 = (TextView)paramView.findViewById(2131624218);
    TextView localTextView4 = (TextView)paramView.findViewById(2131624536);
    paramView = (LinearLayout)paramView.findViewById(2131624216);
    localTextView1.setText(paramSearchPoi.mName);
    if (paramSearchPoi.mAddress == null)
    {
      localTextView2.setVisibility(4);
      if (!BNFavoriteManager.getInstance().isPoiExistInFavByPoint(paramSearchPoi)) {
        break label150;
      }
      localTextView3.setText(2131296424);
    }
    for (;;)
    {
      paramView.setOnClickListener(new OnFavBtnClickListener(paramSearchPoi, localTextView3));
      localTextView4.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView) {}
      });
      return;
      localTextView2.setText(paramSearchPoi.mAddress);
      break;
      label150:
      localTextView3.setText(2131296418);
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    if (this.mPoiList == null) {
      return 0;
    }
    return this.mPoiList.size();
  }
  
  public View getPrimaryItem()
  {
    return this.mCurrentView;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt >= this.mPoiList.size()) {
      return null;
    }
    View localView = LayoutInflater.from(this.mContext).inflate(2130968671, null);
    initPoiPanelView(localView, (SearchPoi)this.mPoiList.get(paramInt));
    localView.setTag(Integer.valueOf(paramInt));
    paramViewGroup.addView(localView);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    this.mCurrentView = ((View)paramObject);
  }
  
  private class OnFavBtnClickListener
    implements View.OnClickListener
  {
    private TextView mFavTV;
    private SearchPoi mPoi;
    
    public OnFavBtnClickListener(SearchPoi paramSearchPoi, TextView paramTextView)
    {
      this.mPoi = paramSearchPoi;
      this.mFavTV = paramTextView;
    }
    
    public void onClick(View paramView)
    {
      if (!BNFavoriteManager.getInstance().isPoiExistInFavByPoint(this.mPoi))
      {
        switch (BNFavoriteManager.getInstance().addNewPoiToFavorite(this.mPoi))
        {
        default: 
          return;
        case 1: 
          this.mFavTV.setText(2131296424);
          BNMapController.getInstance().updateLayer(16);
          TipTool.onCreateToastDialog(HomePoiSimpleAdapter.this.mContext, HomePoiSimpleAdapter.this.mContext.getString(2131296424));
          return;
        case -1: 
          TipTool.onCreateToastDialog(HomePoiSimpleAdapter.this.mContext, HomePoiSimpleAdapter.this.mContext.getString(2131296419));
          return;
        case 0: 
          TipTool.onCreateToastDialog(HomePoiSimpleAdapter.this.mContext, HomePoiSimpleAdapter.this.mContext.getString(2131296422));
          return;
        }
        TipTool.onCreateToastDialog(HomePoiSimpleAdapter.this.mContext, HomePoiSimpleAdapter.this.mContext.getString(2131296423));
        return;
      }
      if (BNFavoriteManager.getInstance().removePoiFromFavorite(this.mPoi))
      {
        BNMapController.getInstance().updateLayer(16);
        this.mFavTV.setText(2131296418);
        TipTool.onCreateToastDialog(HomePoiSimpleAdapter.this.mContext, HomePoiSimpleAdapter.this.mContext.getString(2131296420));
        return;
      }
      TipTool.onCreateToastDialog(HomePoiSimpleAdapter.this.mContext, HomePoiSimpleAdapter.this.mContext.getString(2131296421));
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/adapter/HomePoiSimpleAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */