package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.a;
import com.baidu.ufosdk.b.d;
import java.util.ArrayList;

final class r
  implements AdapterView.OnItemClickListener
{
  r(FeedbackFacePageActivity paramFeedbackFacePageActivity) {}
  
  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = a.ak + "?m=Web&a=getnfaqa&faq_id=" + ((dc)FeedbackFacePageActivity.b(this.a).get(paramInt)).a + "&appid=" + UfoSDK.appid + "devid=" + UfoSDK.devid + "clientid=" + UfoSDK.clientid + "&os=android&uid=" + a.c + "&channel_id=" + ((dc)FeedbackFacePageActivity.b(this.a).get(paramInt)).c + "appvn=" + d.c();
    paramView = new Intent();
    paramView.setClass(this.a, FeedbackHotActivity.class);
    paramView.putExtra("hoturl", paramAdapterView);
    this.a.startActivity(paramView);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */