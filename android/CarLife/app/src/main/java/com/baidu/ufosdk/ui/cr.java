package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.baidu.ufosdk.a;
import com.baidu.ufosdk.util.h;
import com.baidu.ufosdk.util.i;
import java.util.List;
import java.util.Map;

final class cr
  implements AdapterView.OnItemClickListener
{
  cr(FeedbackListActivity paramFeedbackListActivity) {}
  
  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    ((Map)FeedbackListActivity.b(this.a).get(paramInt)).put("newmsg", "0");
    FeedbackListActivity.e(this.a).notifyDataSetChanged();
    paramAdapterView = new Intent();
    paramAdapterView.setClass(this.a, FeedbackInputActivity.class);
    paramAdapterView.putExtra("msgid", (String)((Map)FeedbackListActivity.b(this.a).get(paramInt)).get("id"));
    paramAdapterView.putExtra("feedback_channel", a.h);
    if (!h.a())
    {
      this.a.startActivity(paramAdapterView);
      this.a.finish();
    }
    try
    {
      this.a.overridePendingTransition(i.a(this.a.getApplicationContext(), "ufo_slide_in_from_right"), i.a(this.a.getApplicationContext(), "ufo_slide_out_to_left"));
      return;
    }
    catch (Exception paramAdapterView) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/cr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */