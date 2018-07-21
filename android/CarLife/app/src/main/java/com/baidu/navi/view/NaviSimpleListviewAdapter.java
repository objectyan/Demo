package com.baidu.navi.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;
import com.baidu.navi.style.StyleManager;
import java.util.List;
import java.util.Map;

public class NaviSimpleListviewAdapter
  extends SimpleAdapter
{
  private Context mContext;
  
  public NaviSimpleListviewAdapter(Context paramContext, List<? extends Map<String, ?>> paramList, int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super(paramContext, paramList, paramInt, paramArrayOfString, paramArrayOfInt);
    this.mContext = paramContext;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    paramView.setBackgroundDrawable(StyleManager.getDrawable(2130838435));
    return paramView;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navi/view/NaviSimpleListviewAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */