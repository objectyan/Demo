package com.baidu.ufosdk.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Toast;
import com.baidu.ufosdk.a.a;
import com.baidu.ufosdk.util.u;

final class be
  extends BroadcastReceiver
{
  be(FeedbackInputActivity paramFeedbackInputActivity) {}
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("com.baidu.ufosdk.getchat"))
    {
      paramContext = paramIntent.getExtras().getParcelableArrayList("msgList");
      FeedbackInputActivity.H(this.a).obtainMessage(2, paramContext).sendToTarget();
    }
    if (paramIntent.getAction().equals("com.baidu.ufosdk.getmsgid"))
    {
      FeedbackInputActivity.b(this.a, paramIntent.getStringExtra("msgid"));
      if (FeedbackInputActivity.o(this.a) == null) {
        FeedbackInputActivity.a(this.a, new a(this.a.getApplicationContext(), FeedbackInputActivity.l(this.a)));
      }
      FeedbackInputActivity.o(this.a).b();
      if (!FeedbackInputActivity.o(this.a).isAlive()) {
        FeedbackInputActivity.o(this.a).start();
      }
    }
    if (paramIntent.getAction().equals("com.baidu.ufosdk.deletemsg_dialogdismiss")) {
      FeedbackInputActivity.E(this.a).setVisibility(8);
    }
    if (paramIntent.getAction().equals("com.baidu.ufosdk.reload")) {
      Toast.makeText(this.a.getApplicationContext(), u.a("18"), 1).show();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/be.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */