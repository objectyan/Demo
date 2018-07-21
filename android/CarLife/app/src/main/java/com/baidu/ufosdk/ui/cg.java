package com.baidu.ufosdk.ui;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.ufosdk.util.d;
import com.baidu.ufosdk.util.i;
import java.util.List;
import java.util.Map;

final class cg
  extends Handler
{
  cg(FeedbackListActivity paramFeedbackListActivity) {}
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    int i;
    if (paramMessage.what == 0)
    {
      d locald = new d(this.a);
      locald.d(locald.d() + 1);
      FeedbackListActivity.a(this.a).setVisibility(0);
      FeedbackListActivity.a(this.a, (List)paramMessage.obj);
      i = 0;
      if (i < FeedbackListActivity.b(this.a).size()) {
        break label202;
      }
      label77:
      if (FeedbackListActivity.b(this.a).size() != 0) {
        break label264;
      }
      FeedbackListActivity.d(this.a).setVisibility(0);
    }
    for (;;)
    {
      FeedbackListActivity.e(this.a).notifyDataSetChanged();
      if (paramMessage.what == 1)
      {
        FeedbackListActivity.a(this.a).setVisibility(8);
        i.a(this.a.getApplicationContext(), FeedbackListActivity.f(this.a));
        FeedbackListActivity.g(this.a).setVisibility(0);
        FeedbackListActivity.h(this.a).setVisibility(8);
      }
      if (paramMessage.what == 2) {
        FeedbackListActivity.i(this.a).setSelection(Integer.parseInt(paramMessage.obj.toString()));
      }
      return;
      label202:
      if (!((String)((Map)FeedbackListActivity.b(this.a).get(i)).get("newmsg")).equals("0"))
      {
        FeedbackListActivity.c(this.a).obtainMessage(2, Integer.valueOf(i)).sendToTarget();
        break label77;
      }
      i += 1;
      break;
      label264:
      FeedbackListActivity.d(this.a).setVisibility(8);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/cg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */