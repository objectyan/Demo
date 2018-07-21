package com.baidu.ufosdk.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.baidu.ufosdk.util.i;

final class f
  implements View.OnClickListener
{
  f(FeedbackFacePageActivity paramFeedbackFacePageActivity) {}
  
  public final void onClick(View paramView)
  {
    this.a.a();
    try
    {
      this.a.overridePendingTransition(i.a(this.a.getApplicationContext(), "ufo_slide_in_from_right"), i.a(this.a.getApplicationContext(), "ufo_slide_out_to_left"));
      return;
    }
    catch (Exception paramView) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */