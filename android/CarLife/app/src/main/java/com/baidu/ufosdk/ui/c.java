package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.a;
import com.baidu.ufosdk.util.h;
import com.baidu.ufosdk.util.i;
import com.baidu.ufosdk.util.u;

final class c
  implements View.OnClickListener
{
  c(FeedbackFacePageActivity paramFeedbackFacePageActivity) {}
  
  public final void onClick(View paramView)
  {
    com.baidu.ufosdk.util.c.d("#######################");
    if (UfoSDK.clientid.length() == 0)
    {
      Toast.makeText(this.a.getApplicationContext(), u.a("18"), 1).show();
      if ((!com.baidu.ufosdk.b.c.b(this.a.getApplicationContext()).contains("UNKNOWN")) && (!com.baidu.ufosdk.b.c.b(this.a.getApplicationContext()).contains("NONE"))) {
        new Thread(new d(this)).start();
      }
    }
    for (;;)
    {
      return;
      try
      {
        if (h.a()) {
          continue;
        }
        paramView = new Intent();
        paramView.setClass(this.a, FeedbackInputActivity.class);
        paramView.putExtra("msgid", FeedbackFacePageActivity.l(this.a));
        paramView.putExtra("fromlist", "no");
        paramView.putExtra("feedback_channel", a.h);
        this.a.startActivity(paramView);
        try
        {
          this.a.overridePendingTransition(i.a(this.a.getApplicationContext(), "ufo_slide_in_from_right"), i.a(this.a.getApplicationContext(), "ufo_slide_out_to_left"));
          return;
        }
        catch (Exception paramView) {}
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */