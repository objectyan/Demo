package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.ufosdk.a;

final class bp
  implements View.OnClickListener
{
  bp(FeedbackInputActivity paramFeedbackInputActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, FeedbackListActivity.class);
    paramView.putExtra("feedback_channel", a.h);
    this.a.startActivity(paramView);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/bp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */