package com.baidu.carlife.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.carlife.core.screen.presentation.h;
import com.baidu.carlife.l.a;
import com.baidu.carlife.logic.o;
import com.baidu.carlife.util.r;
import com.baidu.carlife.view.PressTextView;
import com.baidu.navi.fragment.NaviFragmentManager;

public class d
  extends BaseAdapter
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  public static final int d = 3;
  private Context e;
  private String[] f;
  private int[] g;
  private int h;
  
  public d(Context paramContext, int paramInt)
  {
    this.e = paramContext;
    this.h = paramInt;
  }
  
  public d(Context paramContext, String[] paramArrayOfString, int[] paramArrayOfInt, int paramInt)
  {
    this.e = paramContext;
    this.f = paramArrayOfString;
    this.g = paramArrayOfInt;
    this.h = paramInt;
  }
  
  private boolean a(int paramInt)
  {
    if (h.a().getNaviFragmentManager().isDriving())
    {
      if (this.h == 0) {}
      while ((this.h == 1) && ((paramInt == 1) || (paramInt == 2) || (paramInt == 3))) {
        return false;
      }
    }
    return true;
  }
  
  public void a(PressTextView paramPressTextView, boolean paramBoolean)
  {
    paramPressTextView.setNeedRedPoint(paramBoolean);
    paramPressTextView.setPageType(2);
    paramPressTextView.requestLayout();
  }
  
  public void a(int[] paramArrayOfInt)
  {
    this.g = paramArrayOfInt;
  }
  
  public void a(String[] paramArrayOfString)
  {
    this.f = paramArrayOfString;
  }
  
  public int getCount()
  {
    if ((this.f == null) || (this.g == null)) {
      return 0;
    }
    if (this.f.length <= this.g.length) {
      return this.f.length;
    }
    return this.g.length;
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.e).inflate(2130968838, paramViewGroup, false);
      paramViewGroup = (PressTextView)paramView.findViewById(2131625260);
      paramView.setTag(paramViewGroup);
      paramViewGroup.setText(this.f[paramInt]);
      paramView.setBackground(r.b(2130838563));
      paramViewGroup.setTextColor(r.a(2131558701));
      paramViewGroup.setCompoundDrawablesWithIntrinsicBounds(null, r.b(this.g[paramInt]), null, null);
      if (a(paramInt)) {
        break label147;
      }
      paramView.setAlpha(0.5F);
      paramViewGroup.setAlpha(0.5F);
    }
    for (;;)
    {
      if (this.h == 2)
      {
        if ((a.a().N()) || (!o.a().b()) || (paramInt != 0)) {
          break label160;
        }
        a(paramViewGroup, true);
      }
      return paramView;
      paramViewGroup = (PressTextView)paramView.getTag();
      break;
      label147:
      paramView.setAlpha(1.0F);
      paramViewGroup.setAlpha(1.0F);
    }
    label160:
    a(paramViewGroup, false);
    return paramView;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return a(paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/adpter/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */