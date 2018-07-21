package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.a;
import com.baidu.ufosdk.b.c;
import com.baidu.ufosdk.util.h;
import com.baidu.ufosdk.util.i;
import com.baidu.ufosdk.util.u;

final class p
  implements View.OnClickListener
{
  p(FeedbackFacePageActivity paramFeedbackFacePageActivity) {}
  
  public final void onClick(View paramView)
  {
    if (UfoSDK.clientid.length() == 0)
    {
      Toast.makeText(this.a.getApplicationContext(), u.a("18"), 1).show();
      if ((!c.b(this.a.getApplicationContext()).contains("UNKNOWN")) && (!c.b(this.a.getApplicationContext()).contains("NONE"))) {
        new Thread(new q(this)).start();
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
        paramView.putExtra("feedback_channel", a.h);
        String str = FeedbackFacePageActivity.a(this.a).getText().toString();
        if (str == null) {
          paramView.putExtra("no_result", "");
        }
        for (;;)
        {
          this.a.startActivity(paramView);
          try
          {
            this.a.overridePendingTransition(i.a(this.a.getApplicationContext(), "ufo_slide_in_from_right"), 0);
            return;
          }
          catch (Exception paramView)
          {
            return;
          }
          paramView.putExtra("no_result", str);
        }
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */