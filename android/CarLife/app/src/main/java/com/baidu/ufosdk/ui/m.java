package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.a;
import com.baidu.ufosdk.b.d;
import com.baidu.ufosdk.util.i;

final class m
  extends Handler
{
  m(FeedbackFacePageActivity paramFeedbackFacePageActivity) {}
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    Object localObject;
    if (paramMessage.what == 0)
    {
      if (Integer.parseInt((String)paramMessage.obj) > 0) {
        FeedbackFacePageActivity.f(this.a).setVisibility(0);
      }
    }
    else
    {
      if (paramMessage.what == 1) {
        FeedbackFacePageActivity.g(this.a);
      }
      if (paramMessage.what == 2)
      {
        localObject = String.format("os=android&appid=%s&devid=%s&clientid=%s&appvn=%s&sdkvn=%s" + "&baiducuid=%s&nettype=%s&model=%s&osvn=%s&channel_id=%s", new Object[] { UfoSDK.appid, UfoSDK.devid, UfoSDK.clientid, d.c(), "1.7.13", a.c, com.baidu.ufosdk.b.c.a(this.a.getApplicationContext()), Build.MODEL, Build.VERSION.RELEASE, String.valueOf(a.i) });
        localObject = a.al + "&" + (String)localObject;
        com.baidu.ufosdk.util.c.c("webview postString is " + (String)localObject);
        FeedbackFacePageActivity.e(this.a).loadUrl((String)localObject);
        FeedbackFacePageActivity.a(this.a, false);
      }
      if (paramMessage.what == 5)
      {
        localObject = String.format("os=android&appid=%s&devid=%s&clientid=%s&appvn=%s&sdkvn=%s" + "&baiducuid=%s&nettype=%s&model=%s&osvn=%s&channel_id=%s", new Object[] { UfoSDK.appid, UfoSDK.devid, UfoSDK.clientid, d.c(), "1.7.13", a.c, com.baidu.ufosdk.b.c.a(this.a.getApplicationContext()), Build.MODEL, Build.VERSION.RELEASE, Integer.valueOf(a.h) });
        localObject = a.al + "&" + (String)localObject;
        com.baidu.ufosdk.util.c.c("webview postString is " + (String)localObject);
        FeedbackFacePageActivity.e(this.a).loadUrl((String)localObject);
        com.baidu.ufosdk.util.c.b("**********-->webView 全部问题： " + (String)localObject);
        FeedbackFacePageActivity.a(this.a, true);
      }
      if ((paramMessage.what == 3) && (FeedbackFacePageActivity.e(this.a).getProgress() < 100))
      {
        FeedbackFacePageActivity.e(this.a).stopLoading();
        FeedbackFacePageActivity.h(this.a).setVisibility(8);
        i.a(this.a.getApplicationContext(), FeedbackFacePageActivity.i(this.a));
        FeedbackFacePageActivity.j(this.a).setVisibility(0);
        FeedbackFacePageActivity.e(this.a).setVisibility(8);
      }
      if (paramMessage.what != 4) {
        break label582;
      }
      FeedbackFacePageActivity.h(this.a).setVisibility(8);
      i.a(this.a.getApplicationContext(), FeedbackFacePageActivity.i(this.a));
      FeedbackFacePageActivity.j(this.a).setVisibility(0);
      FeedbackFacePageActivity.e(this.a).setVisibility(8);
    }
    label582:
    label960:
    do
    {
      do
      {
        return;
        FeedbackFacePageActivity.f(this.a).setVisibility(8);
        break;
        if (paramMessage.what == 12)
        {
          if (FeedbackFacePageActivity.k(this.a))
          {
            FeedbackFacePageActivity.b(this.a, false);
            return;
          }
          if ((!TextUtils.isEmpty(FeedbackFacePageActivity.l(this.a))) && (TextUtils.isEmpty(FeedbackFacePageActivity.m(this.a)))) {
            FeedbackFacePageActivity.n(this.a).putString(FeedbackFacePageActivity.l(this.a), "");
          }
          if (!TextUtils.isEmpty(FeedbackFacePageActivity.m(this.a))) {
            FeedbackFacePageActivity.n(this.a).putString(FeedbackFacePageActivity.m(this.a), "");
          }
          FeedbackFacePageActivity.n(this.a).commit();
          return;
        }
        if (paramMessage.what == 14)
        {
          if (FeedbackFacePageActivity.k(this.a))
          {
            FeedbackFacePageActivity.b(this.a, false);
            return;
          }
          if ((!TextUtils.isEmpty(FeedbackFacePageActivity.l(this.a))) && (TextUtils.isEmpty(FeedbackFacePageActivity.m(this.a)))) {
            FeedbackFacePageActivity.n(this.a).putString(FeedbackFacePageActivity.l(this.a), "");
          }
          if (!TextUtils.isEmpty(FeedbackFacePageActivity.m(this.a))) {
            FeedbackFacePageActivity.n(this.a).putString(FeedbackFacePageActivity.m(this.a), "");
          }
          FeedbackFacePageActivity.n(this.a).commit();
          localObject = new Intent();
          ((Intent)localObject).setClass(this.a, FeedbackInputActivity.class);
          ((Intent)localObject).putExtra("msgid", (String)paramMessage.obj);
          ((Intent)localObject).putExtra("feedback_channel", a.h);
          this.a.startActivity((Intent)localObject);
          return;
        }
        if (paramMessage.what == 15)
        {
          com.baidu.ufosdk.util.c.b("msg.what== 15");
          return;
        }
        if (paramMessage.what != 16) {
          break label960;
        }
      } while ((this.a.getCurrentFocus() == null) || (this.a.getCurrentFocus().getWindowToken() == null));
      ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(this.a.getCurrentFocus().getWindowToken(), 2);
      return;
    } while (paramMessage.what != 17);
    FeedbackFacePageActivity.c(this.a).notifyDataSetChanged();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */