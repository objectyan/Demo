package com.baidu.carlife.adpter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.baidu.carlife.core.i;
import com.baidu.carlife.model.b;
import java.util.ArrayList;
import java.util.List;

public class CarlifeViewPagerAdapter
  extends PagerAdapter
{
  private static final String a = "CarLifeViewPagerAdapter";
  private static final int c = 4;
  private List<View> b = null;
  private Context d;
  
  public CarlifeViewPagerAdapter(Context paramContext, List<b> paramList)
  {
    this.d = paramContext;
    this.b = a(paramContext, paramList);
  }
  
  private View a()
  {
    View localView = LayoutInflater.from(this.d).inflate(2130968622, null);
    Button localButton = (Button)localView.findViewById(2131624242);
    localButton.setTextSize(20.0F);
    localButton.setText("待添加");
    return localView;
  }
  
  private List<View> a(Context paramContext, List<b> paramList)
  {
    Object localObject1 = b();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject2 = LayoutInflater.from(paramContext).inflate(2130968622, null);
      Button localButton = (Button)((View)localObject2).findViewById(2131624242);
      localButton.setTextSize(20.0F);
      localButton.setText(((b)paramList.get(i)).g);
      ((LinearLayout)localObject1).addView((View)localObject2);
      if (i % 4 != 3)
      {
        localObject2 = localObject1;
        if (i != paramList.size() - 1) {}
      }
      else
      {
        ((LinearLayout)localObject1).addView(a());
        localArrayList.add(localObject1);
        localObject2 = b();
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localArrayList;
  }
  
  private LinearLayout b()
  {
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    LinearLayout localLinearLayout = new LinearLayout(this.d);
    localLinearLayout.setOrientation(0);
    localLinearLayout.setLayoutParams(localLayoutParams);
    return localLinearLayout;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    ((ViewPager)paramViewGroup).removeView((View)this.b.get(paramInt));
  }
  
  public int getCount()
  {
    if (this.b == null) {
      return 0;
    }
    return this.b.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    i.e("CarLifeViewPagerAdapter", "-----------instantiateItem----------POS5:" + paramInt);
    ((ViewPager)paramViewGroup).addView((View)this.b.get(paramInt));
    return this.b.get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/adpter/CarlifeViewPagerAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */