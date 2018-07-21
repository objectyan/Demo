package com.baidu.ufosdk.ui;

import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.PopupWindow;
import com.baidu.ufosdk.util.i;
import com.baidu.ufosdk.util.u;
import java.util.List;
import java.util.Map;

final class cs
  implements AdapterView.OnItemLongClickListener
{
  cs(FeedbackListActivity paramFeedbackListActivity) {}
  
  public final boolean onItemLongClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (String)((Map)FeedbackListActivity.b(this.a).get(paramInt)).get("id");
    paramAdapterView = FeedbackListActivity.a(this.a, this.a.getApplicationContext(), u.a("3"), paramAdapterView);
    FeedbackListActivity.a(this.a, new PopupWindow(paramAdapterView, i.a(this.a.getApplicationContext(), 79.0F), i.a(this.a.getApplicationContext(), 68.0F)));
    FeedbackListActivity.n(this.a).setFocusable(false);
    FeedbackListActivity.n(this.a).setOutsideTouchable(true);
    FeedbackListActivity.n(this.a).setBackgroundDrawable(new BitmapDrawable());
    paramAdapterView.getLocationOnScreen(new int[2]);
    FeedbackListActivity.n(this.a).showAtLocation(FeedbackListActivity.o(this.a), 17, 0, 0);
    return true;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/cs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */