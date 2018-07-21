package com.baidu.ufosdk.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.ufosdk.a;
import com.baidu.ufosdk.util.i;
import com.baidu.ufosdk.util.p;
import java.util.ArrayList;

public final class x
  extends BaseAdapter
{
  private Context b;
  
  public x(FeedbackFacePageActivity paramFeedbackFacePageActivity, Context paramContext)
  {
    this.b = paramContext;
  }
  
  public final int getCount()
  {
    return FeedbackFacePageActivity.b(this.a).size();
  }
  
  public final Object getItem(int paramInt)
  {
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (paramView == null)
    {
      paramViewGroup = new y(this);
      paramView = new RelativeLayout(this.b);
      paramView.setBackgroundColor(-723724);
      paramView.setLayoutParams(new AbsListView.LayoutParams(-1, i.a(this.a.getApplicationContext(), 40.0F)));
      localObject = new TextView(this.b);
      ((TextView)localObject).setId(2131296277);
      ((TextView)localObject).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject).setSingleLine(true);
      ((TextView)localObject).setTextColor(a.J);
      ((TextView)localObject).setTextSize(a.ad);
      ((TextView)localObject).setPadding(0, 0, 0, 0);
      ((TextView)localObject).setGravity(16);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.setMargins(i.a(this.a.getApplicationContext(), 7.0F), i.a(this.a.getApplicationContext(), 5.0F), i.a(this.a.getApplicationContext(), 7.0F), i.a(this.a.getApplicationContext(), 5.0F));
      localLayoutParams.addRule(13);
      localLayoutParams.addRule(9);
      paramView.addView((View)localObject, localLayoutParams);
      paramView.setBackgroundDrawable(p.a(this.a.getApplicationContext(), a.z, "ufo_list_press.png"));
      paramViewGroup.a = ((TextView)localObject);
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      paramViewGroup.a.setText(((dc)FeedbackFacePageActivity.b(this.a).get(paramInt)).b);
      localObject = new BitmapDrawable(p.a(this.a.getApplicationContext(), "ufo_search_icon.png"));
      ((Drawable)localObject).setBounds(0, 0, i.a(this.a.getApplicationContext(), 12.0F), i.a(this.a.getApplicationContext(), 12.0F));
      paramViewGroup.a.setCompoundDrawables((Drawable)localObject, null, null, null);
      paramViewGroup.a.setCompoundDrawablePadding(5);
      return paramView;
      paramViewGroup = (y)paramView.getTag();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/x.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */