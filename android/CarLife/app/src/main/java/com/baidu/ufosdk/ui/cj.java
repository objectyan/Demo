package com.baidu.ufosdk.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

final class cj
  extends BroadcastReceiver
{
  cj(FeedbackListActivity paramFeedbackListActivity) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.baidu.ufosdk.gethistorylist"))
    {
      FeedbackListActivity.j(this.a).setVisibility(8);
      paramContext = (ArrayList)paramIntent.getSerializableExtra("msgList");
      FeedbackListActivity.c(this.a).obtainMessage(0, paramContext).sendToTarget();
      FeedbackListActivity.k(this.a);
    }
    if (paramIntent.getAction().equals("com.baidu.ufosdk.getnewhistoryflag")) {
      FeedbackListActivity.l(this.a).execute(new ck(this));
    }
    if (paramIntent.getAction().equals("com.baidu.ufosdk.getappkeysuccess_getnewhistoryflag")) {
      FeedbackListActivity.l(this.a).execute(new cl(this));
    }
    if (paramIntent.getAction().equals("com.baidu.ufosdk.deletemsg_dialogdismiss"))
    {
      FeedbackListActivity.h(this.a).setVisibility(8);
      FeedbackListActivity.j(this.a).setVisibility(8);
    }
    if (paramIntent.getAction().equals("com.baidu.ufosdk.reload")) {
      FeedbackListActivity.c(this.a).obtainMessage(1, null).sendToTarget();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/cj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */