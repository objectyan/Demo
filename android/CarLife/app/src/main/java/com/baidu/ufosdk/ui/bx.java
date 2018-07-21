package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.baidu.ufosdk.a;
import com.baidu.ufosdk.util.h;

final class bx
  implements View.OnClickListener
{
  bx(br parambr) {}
  
  public final void onClick(View paramView)
  {
    paramView = ((TextView)paramView).getText().toString();
    if ((!h.a()) && (br.a(this.a).d) && (paramView.contains("我的反馈")))
    {
      br.a(this.a).c = true;
      paramView = new Intent(br.a(this.a), FeedbackListActivity.class);
      paramView.putExtra("feedback_channel", a.h);
      br.a(this.a).startActivity(paramView);
      br.a(this.a).finish();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/bx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */