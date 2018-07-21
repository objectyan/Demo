package com.baidu.navi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.navi.style.StyleManager;

public class NaviRouteSearchAdapter
  extends BaseAdapter
{
  private int[] icons = { 2130838902, 2130838903, 2130838904, 2130838900, 2130838901, 2130838899 };
  private String[] items;
  private Context mContext;
  
  public NaviRouteSearchAdapter(Context paramContext)
  {
    this.mContext = paramContext;
    this.items = StyleManager.getStringArray(2131230731);
  }
  
  public int getCount()
  {
    return this.items.length;
  }
  
  public String getItem(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.items.length)) {
      return "";
    }
    return this.items[paramInt];
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public String getSearchKey(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.items.length))
    {
      if (paramInt == 0) {
        return "加油站";
      }
      if (paramInt == 1) {
        return "停车场";
      }
      if (paramInt == 2) {
        return "厕所";
      }
      if (paramInt == 3) {
        return "餐饮";
      }
      if (paramInt == 4) {
        return "酒店";
      }
      if (paramInt == 5) {
        return "银行";
      }
    }
    return "";
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = LayoutInflater.from(this.mContext).inflate(2130968842, paramViewGroup, false);
    paramViewGroup = (ImageView)paramView.findViewById(2131625272);
    TextView localTextView = (TextView)paramView.findViewById(2131625273);
    paramViewGroup.setImageDrawable(StyleManager.getDrawable(this.icons[paramInt]));
    localTextView.setText(getItem(paramInt));
    if (paramInt + 1 == getCount()) {
      paramView.findViewById(2131625274).setVisibility(8);
    }
    return paramView;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/adapter/NaviRouteSearchAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */