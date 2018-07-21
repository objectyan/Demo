package com.baidu.ufosdk.ui;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.ufosdk.UfoSDK;

final class b
  implements View.OnClickListener
{
  b(FeedbackFacePageActivity paramFeedbackFacePageActivity) {}
  
  public final void onClick(View paramView)
  {
    if (UfoSDK.clientid.length() != 0)
    {
      FeedbackFacePageActivity.o(this.a).obtainMessage(5, null).sendToTarget();
      FeedbackFacePageActivity.u(this.a).setVisibility(8);
      FeedbackFacePageActivity.v(this.a).setText("全部问题");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */