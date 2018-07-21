package com.baidu.ufosdk.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.baidu.ufosdk.a;
import com.baidu.ufosdk.util.i;
import com.baidu.ufosdk.util.p;
import java.util.List;
import java.util.Map;

public final class cw
  extends BaseAdapter
{
  private Context b;
  
  public cw(FeedbackListActivity paramFeedbackListActivity, Context paramContext)
  {
    this.b = paramContext;
  }
  
  public final int getCount()
  {
    return FeedbackListActivity.b(this.a).size();
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
    Object localObject1;
    if (paramView == null)
    {
      paramView = new cv(this.a);
      localObject1 = new LinearLayout(this.b);
      ((LinearLayout)localObject1).setBackgroundColor(-1184275);
      ((LinearLayout)localObject1).setOrientation(1);
      ((LinearLayout)localObject1).setLayoutParams(new AbsListView.LayoutParams(-1, -2));
      paramViewGroup = new RelativeLayout(this.b);
      paramViewGroup.setBackgroundColor(-1);
      new RelativeLayout.LayoutParams(-2, -2);
      TextView localTextView = new TextView(this.b);
      localTextView.setId(2132344840);
      Object localObject2 = new RelativeLayout.LayoutParams(i.a(this.a.getApplicationContext(), 6.0F), i.a(this.a.getApplicationContext(), 6.0F));
      ((RelativeLayout.LayoutParams)localObject2).setMargins(i.a(this.a.getApplicationContext(), 8.0F), i.a(this.a.getApplicationContext(), 17.0F), 0, 0);
      ((RelativeLayout.LayoutParams)localObject2).addRule(10);
      ((RelativeLayout.LayoutParams)localObject2).addRule(9);
      paramViewGroup.addView(localTextView, (ViewGroup.LayoutParams)localObject2);
      localObject2 = new TextView(this.b);
      ((TextView)localObject2).setId(2132344842);
      ((TextView)localObject2).setTextColor(a.B);
      ((TextView)localObject2).setTextSize(15.0F);
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setPadding(0, 0, 0, 0);
      Object localObject3 = new RelativeLayout.LayoutParams(i.a(this.a.getApplicationContext(), 40.0F), -1);
      ((RelativeLayout.LayoutParams)localObject3).addRule(1, localTextView.getId());
      ((RelativeLayout.LayoutParams)localObject3).addRule(13);
      ((RelativeLayout.LayoutParams)localObject3).setMargins(0, 0, i.a(this.a.getApplicationContext(), 10.0F), 0);
      paramViewGroup.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new View(this.b);
      ((View)localObject3).setBackgroundColor(-1184275);
      ((View)localObject3).setId(2132344844);
      Object localObject4 = new RelativeLayout.LayoutParams(i.a(this.a.getApplicationContext(), 0.8F), -1);
      ((RelativeLayout.LayoutParams)localObject4).setMargins(0, i.a(this.a.getApplicationContext(), 5.0F), i.a(this.a.getApplicationContext(), 15.0F), i.a(this.a.getApplicationContext(), 5.0F));
      ((RelativeLayout.LayoutParams)localObject4).addRule(1, ((TextView)localObject2).getId());
      paramViewGroup.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      localObject4 = new ImageView(this.b);
      ((ImageView)localObject4).setId(2132344846);
      ((ImageView)localObject4).setBackgroundDrawable(new BitmapDrawable(p.a(this.a.getApplicationContext(), "ufo_next_icon.png")));
      Object localObject5 = new RelativeLayout.LayoutParams(i.a(this.a.getApplicationContext(), 9.0F), i.a(this.a.getApplicationContext(), 17.0F));
      ((RelativeLayout.LayoutParams)localObject5).addRule(11);
      ((RelativeLayout.LayoutParams)localObject5).addRule(13);
      paramViewGroup.addView((View)localObject4, (ViewGroup.LayoutParams)localObject5);
      localObject5 = new TextView(this.b);
      ((TextView)localObject5).setTextSize(a.aa);
      ((TextView)localObject5).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject5).setSingleLine(true);
      ((TextView)localObject5).setTextColor(a.A);
      ((TextView)localObject5).setId(2132344845);
      ((TextView)localObject5).setGravity(16);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      localLayoutParams.addRule(1, ((View)localObject3).getId());
      localLayoutParams.addRule(0, ((ImageView)localObject4).getId());
      paramViewGroup.addView((View)localObject5, localLayoutParams);
      paramViewGroup.setBackgroundDrawable(p.a(this.a.getApplicationContext(), a.z, "ufo_list_press.png"));
      localObject3 = new TextView(this.b);
      ((TextView)localObject3).setTextColor(a.B);
      ((TextView)localObject3).setBackgroundColor(-1184275);
      ((TextView)localObject3).setTextSize(a.Y);
      ((TextView)localObject3).setGravity(17);
      ((TextView)localObject3).setPadding(0, i.a(this.a.getApplicationContext(), 10.0F), 0, i.a(this.a.getApplicationContext(), 5.0F));
      ((LinearLayout)localObject1).addView((View)localObject3, new LinearLayout.LayoutParams(-1, -2));
      ((LinearLayout)localObject1).addView(paramViewGroup, new LinearLayout.LayoutParams(-1, i.a(this.a.getApplicationContext(), 50.0F)));
      paramViewGroup.setPadding(0, 0, i.a(this.a.getApplicationContext(), 15.0F), 0);
      paramView.a = ((TextView)localObject3);
      paramView.b = localTextView;
      paramView.c = ((TextView)localObject2);
      paramView.d = ((TextView)localObject5);
      paramView.e = ((ImageView)localObject4);
      ((View)localObject1).setTag(paramView);
      paramViewGroup = paramView;
      paramViewGroup.d.setText((String)((Map)FeedbackListActivity.b(this.a).get(paramInt)).get("content"));
      if ((paramInt == 0) || (!FeedbackListActivity.a((String)((Map)FeedbackListActivity.b(this.a).get(paramInt)).get("time"), (String)((Map)FeedbackListActivity.b(this.a).get(paramInt - 1)).get("time")))) {
        break label1025;
      }
      paramViewGroup.a.setVisibility(8);
    }
    for (;;)
    {
      paramViewGroup.c.setText(FeedbackListActivity.a((String)((Map)FeedbackListActivity.b(this.a).get(paramInt)).get("time")));
      if (((String)((Map)FeedbackListActivity.b(this.a).get(paramInt)).get("newmsg")).equals("0")) {
        break label1072;
      }
      paramViewGroup.b.setBackgroundDrawable(new BitmapDrawable(FeedbackListActivity.m(this.a)));
      return (View)localObject1;
      paramViewGroup = (cv)paramView.getTag();
      localObject1 = paramView;
      break;
      label1025:
      paramViewGroup.a.setVisibility(0);
      paramViewGroup.a.setText(FeedbackListActivity.b((String)((Map)FeedbackListActivity.b(this.a).get(paramInt)).get("time")));
    }
    label1072:
    paramViewGroup.b.setBackgroundDrawable(null);
    return (View)localObject1;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */