package com.baidu.ufosdk.ui;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.b.c;
import com.baidu.ufosdk.util.u;

final class g
  implements View.OnClickListener
{
  g(FeedbackFacePageActivity paramFeedbackFacePageActivity) {}
  
  public final void onClick(View paramView)
  {
    if (!com.baidu.ufosdk.util.h.a())
    {
      try
      {
        FeedbackFacePageActivity.h(this.a).setVisibility(0);
        FeedbackFacePageActivity.j(this.a).setVisibility(8);
        FeedbackFacePageActivity.e(this.a).setVisibility(0);
        paramView = c.b(this.a.getApplicationContext());
        boolean bool1 = paramView.contains("UNKNOWN");
        boolean bool2 = paramView.contains("NONE");
        if ((bool1) || (bool2))
        {
          FeedbackFacePageActivity.e(this.a).setVisibility(8);
          FeedbackFacePageActivity.h(this.a).setVisibility(8);
          com.baidu.ufosdk.util.i.a(this.a.getApplicationContext(), FeedbackFacePageActivity.i(this.a));
          FeedbackFacePageActivity.j(this.a).setVisibility(0);
          Toast.makeText(this.a, u.a("18"), 1).show();
          return;
        }
        if (UfoSDK.clientid.length() == 0)
        {
          new Thread(new h(this)).start();
          return;
        }
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      FeedbackFacePageActivity.e(this.a).loadDataWithBaseURL(null, null, "text/html", "utf-8", null);
      FeedbackFacePageActivity.j(this.a).setVisibility(8);
      FeedbackFacePageActivity.e(this.a).setVisibility(0);
      FeedbackFacePageActivity.o(this.a).obtainMessage(1, null).sendToTarget();
      new Thread(new i(this)).start();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */