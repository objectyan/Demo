package com.baidu.ufosdk.ui;

import android.text.ClipboardManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import android.widget.TextView;

final class bi
  implements View.OnClickListener
{
  bi(FeedbackInputActivity paramFeedbackInputActivity, View paramView, PopupWindow paramPopupWindow) {}
  
  public final void onClick(View paramView)
  {
    ((ClipboardManager)this.a.getSystemService("clipboard")).setText(((TextView)this.b).getText().toString());
    this.c.dismiss();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/bi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */