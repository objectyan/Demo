package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.util.h;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

final class cn
  implements View.OnClickListener
{
  cn(FeedbackListActivity paramFeedbackListActivity) {}
  
  public final void onClick(View paramView)
  {
    if (!h.a()) {
      try
      {
        FeedbackListActivity.g(this.a).setVisibility(8);
        FeedbackListActivity.h(this.a).setVisibility(0);
        if (UfoSDK.clientid.length() == 0)
        {
          new Thread(new co(this)).start();
          return;
        }
        FeedbackListActivity.a(this.a, Executors.newSingleThreadExecutor());
        FeedbackListActivity.l(this.a).execute(new cp(this));
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/cn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */