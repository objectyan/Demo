package com.baidu.ufosdk.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.baidu.ufosdk.UfoSDK;
import com.baidu.ufosdk.util.c;
import com.baidu.ufosdk.util.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class aj
  extends Handler
{
  private String b;
  
  aj(FeedbackInputActivity paramFeedbackInputActivity) {}
  
  public final void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    Object localObject5;
    Object localObject6;
    label1135:
    do
    {
      for (;;)
      {
        try
        {
          if (paramMessage.what == 0) {
            c.c("msg.what==0");
          }
          if (paramMessage.what == 12)
          {
            FeedbackInputActivity.a(this.a);
            if (this.a.c)
            {
              this.a.c = false;
              return;
            }
            FeedbackInputActivity.b(this.a).setVisibility(8);
            FeedbackInputActivity.c(this.a);
            FeedbackInputActivity.d(this.a).setEnabled(true);
            FeedbackInputActivity.d(this.a).setText("");
            FeedbackInputActivity.e(this.a).setVisibility(8);
            FeedbackInputActivity.f(this.a).setVisibility(8);
            FeedbackInputActivity.a(this.a, (String)paramMessage.obj);
            FeedbackInputActivity.b(this.a, FeedbackInputActivity.g(this.a));
            if ((UfoSDK.robotAnswer) && (FeedbackInputActivity.h(this.a)) && (FeedbackInputActivity.g(this.a) != null) && (FeedbackInputActivity.g(this.a).length() > 0))
            {
              FeedbackInputActivity.a(this.a, Executors.newSingleThreadExecutor());
              FeedbackInputActivity.i(this.a).execute(new ak(this));
            }
            if (paramMessage.what != 1) {
              break;
            }
            c.b("1111111111111111111111111");
            localObject1 = new HashMap();
            ((Map)localObject1).put("from", Integer.valueOf(0));
            ((Map)localObject1).put("content", paramMessage.obj);
            ((Map)localObject1).put("contenttype", "0");
            ((Map)localObject1).put("time", String.valueOf(System.currentTimeMillis()));
            FeedbackInputActivity.p(this.a).add(localObject1);
            FeedbackInputActivity.q(this.a).notifyDataSetChanged();
            FeedbackInputActivity.r(this.a).setSelection(FeedbackInputActivity.r(this.a).getBottom());
            FeedbackInputActivity.b(this.a).setVisibility(8);
            if (paramMessage.what == 3)
            {
              this.a.d = false;
              localObject1 = (byte[])paramMessage.obj;
              if (localObject1 == null) {
                break label3364;
              }
            }
          }
        }
        catch (Exception paramMessage)
        {
          Object localObject1;
          paramMessage.printStackTrace();
          c.d("handleMessage error !!");
          return;
        }
        try
        {
          localObject1 = BitmapFactory.decodeByteArray((byte[])localObject1, 0, localObject1.length);
          FeedbackInputActivity.a.add(localObject1);
          if (localObject1 == null) {
            break label3364;
          }
          localObject3 = new HashMap();
          ((Map)localObject3).put("from", Integer.valueOf(0));
          ((Map)localObject3).put("content", localObject1);
          ((Map)localObject3).put("contenttype", "2");
          ((Map)localObject3).put("time", String.valueOf(System.currentTimeMillis()));
          FeedbackInputActivity.p(this.a).add(localObject3);
          FeedbackInputActivity.q(this.a).notifyDataSetChanged();
          FeedbackInputActivity.r(this.a).setSelection(FeedbackInputActivity.r(this.a).getBottom());
          if (paramMessage.what == 4)
          {
            FeedbackInputActivity.x(this.a).setVisibility(8);
            FeedbackInputActivity.A(this.a).setVisibility(8);
            FeedbackInputActivity.B(this.a).setVisibility(8);
            i.a(this.a.getApplicationContext(), FeedbackInputActivity.C(this.a));
            FeedbackInputActivity.D(this.a).setVisibility(0);
            FeedbackInputActivity.E(this.a).setVisibility(8);
            FeedbackInputActivity.z(this.a).setVisibility(8);
          }
          if (paramMessage.what == 5)
          {
            this.a.d = false;
            FeedbackInputActivity.p(this.a).clear();
            localObject5 = new HashMap();
            ((Map)localObject5).put("from", Integer.valueOf(1));
            ((Map)localObject5).put("content", UfoSDK.firstServerText);
            ((Map)localObject5).put("contenttype", "0");
            localObject6 = (String)paramMessage.obj;
            if ((localObject6 == null) || ((!((String)localObject6).equals("newMessage")) && (((String)localObject6).length() != 0))) {
              break label2635;
            }
            this.b = String.valueOf(System.currentTimeMillis());
            ((Map)localObject5).put("time", this.b);
            FeedbackInputActivity.p(this.a).add(localObject5);
            if (FeedbackInputActivity.q(this.a) != null) {
              FeedbackInputActivity.q(this.a).notifyDataSetChanged();
            }
          }
        }
        catch (OutOfMemoryError paramMessage)
        {
          System.gc();
          return;
        }
        try
        {
          localObject5 = new JSONArray((String)localObject6);
          i = 0;
          if (i < ((JSONArray)localObject5).length()) {
            break label2740;
          }
          FeedbackInputActivity.q(this.a).notifyDataSetChanged();
          FeedbackInputActivity.x(this.a).setVisibility(0);
          FeedbackInputActivity.A(this.a).setVisibility(0);
          FeedbackInputActivity.B(this.a).setVisibility(0);
          FeedbackInputActivity.D(this.a).setVisibility(8);
          FeedbackInputActivity.E(this.a).setVisibility(8);
          FeedbackInputActivity.r(this.a).setSelection(FeedbackInputActivity.r(this.a).getBottom());
          FeedbackInputActivity.b(this.a, true);
          new Handler().postDelayed(new an(this), 1500L);
        }
        catch (JSONException localJSONException1)
        {
          for (;;)
          {
            localJSONException1.printStackTrace();
            break;
            str = "";
            continue;
            ((Map)localObject6).put("content", str);
            continue;
            ((Map)localObject6).put("content", (String)((JSONArray)localObject5).getJSONObject(i).get("content"));
            continue;
            localObject4[j] = localObject4[j].replace("<a href= \"", "\n");
            k = localObject4[j].indexOf("target=\"_blank\">");
            localObject4[j] = localObject4[j].substring(0, k);
            localObject4[j] = localObject4[j].replace("\"", "\n");
            j += 1;
            continue;
            str = str + localObject4[j] + "\n";
            j += 1;
            continue;
            paramMessage.put("content", UfoSDK.notSolvedReplyText + "您可到我的反馈中查看。");
            break label1135;
          }
          break label2340;
          break label2272;
        }
        if ((paramMessage.what == 6) && (FeedbackInputActivity.G(this.a))) {
          FeedbackInputActivity.r(this.a).setSelection(FeedbackInputActivity.r(this.a).getBottom());
        }
        if (paramMessage.what == 7)
        {
          localObject1 = new HashMap();
          ((Map)localObject1).put("from", Integer.valueOf(1));
          ((Map)localObject1).put("content", UfoSDK.solvedReplyText);
          ((Map)localObject1).put("contenttype", "0");
          ((Map)localObject1).put("time", String.valueOf(System.currentTimeMillis()));
          this.a.d = false;
          FeedbackInputActivity.p(this.a).add(localObject1);
          FeedbackInputActivity.q(this.a).notifyDataSetChanged();
          FeedbackInputActivity.r(this.a).setSelection(FeedbackInputActivity.r(this.a).getBottom());
        }
        if (paramMessage.what != 8) {
          break label3364;
        }
        paramMessage = new HashMap();
        paramMessage.put("from", Integer.valueOf(1));
        if (!this.a.e) {
          break label3321;
        }
        paramMessage.put("content", UfoSDK.notSolvedReplyText);
        paramMessage.put("contenttype", "0");
        paramMessage.put("time", String.valueOf(System.currentTimeMillis()));
        this.a.d = true;
        FeedbackInputActivity.p(this.a).add(paramMessage);
        FeedbackInputActivity.q(this.a).notifyDataSetChanged();
        FeedbackInputActivity.r(this.a).setSelection(FeedbackInputActivity.r(this.a).getBottom());
        return;
        if (paramMessage.what == 13)
        {
          FeedbackInputActivity.c(this.a);
          FeedbackInputActivity.b(this.a).setVisibility(8);
          FeedbackInputActivity.d(this.a).setEnabled(true);
          FeedbackInputActivity.j(this.a).setTextColor(i.a(com.baidu.ufosdk.a.w, com.baidu.ufosdk.a.x, com.baidu.ufosdk.a.w, com.baidu.ufosdk.a.w));
        }
        else if (paramMessage.what == 14)
        {
          this.a.d = false;
          FeedbackInputActivity.a(this.a);
          if (this.a.c)
          {
            this.a.c = false;
            return;
          }
          FeedbackInputActivity.k(this.a);
          if ((!TextUtils.isEmpty(FeedbackInputActivity.l(this.a))) && (TextUtils.isEmpty(FeedbackInputActivity.m(this.a)))) {
            FeedbackInputActivity.n(this.a).putString(FeedbackInputActivity.l(this.a), "");
          }
          if (!TextUtils.isEmpty(FeedbackInputActivity.m(this.a))) {
            FeedbackInputActivity.n(this.a).putString(FeedbackInputActivity.m(this.a), "");
          }
          FeedbackInputActivity.b(this.a).setVisibility(8);
          FeedbackInputActivity.c(this.a);
          FeedbackInputActivity.d(this.a).setEnabled(true);
          FeedbackInputActivity.d(this.a).setText("");
          FeedbackInputActivity.e(this.a).setVisibility(8);
          FeedbackInputActivity.f(this.a).setVisibility(8);
          FeedbackInputActivity.a(this.a, (String)paramMessage.obj);
          FeedbackInputActivity.b(this.a, FeedbackInputActivity.g(this.a));
          if (FeedbackInputActivity.o(this.a) != null) {
            FeedbackInputActivity.o(this.a).a(FeedbackInputActivity.l(this.a));
          }
          FeedbackInputActivity.n(this.a).putString("first" + FeedbackInputActivity.g(this.a), this.b);
          FeedbackInputActivity.n(this.a).commit();
          if ((UfoSDK.robotAnswer) && (FeedbackInputActivity.h(this.a)) && (FeedbackInputActivity.g(this.a) != null) && (FeedbackInputActivity.g(this.a).length() > 0))
          {
            FeedbackInputActivity.a(this.a, Executors.newSingleThreadExecutor());
            FeedbackInputActivity.i(this.a).execute(new al(this));
          }
          else
          {
            FeedbackInputActivity.a(this.a, Executors.newSingleThreadExecutor());
            FeedbackInputActivity.i(this.a).execute(new am(this));
          }
        }
        else
        {
          i = paramMessage.what;
          if (i == 15) {
            try
            {
              ((InputMethodManager)FeedbackInputActivity.d(this.a).getContext().getSystemService("input_method")).showSoftInput(FeedbackInputActivity.d(this.a), 0);
            }
            catch (Exception localException) {}
          } else if ((paramMessage.what == 16) && (this.a.getCurrentFocus() != null) && (this.a.getCurrentFocus().getWindowToken() != null)) {
            ((InputMethodManager)this.a.getSystemService("input_method")).hideSoftInputFromWindow(this.a.getCurrentFocus().getWindowToken(), 2);
          }
        }
      }
    } while (paramMessage.what != 2);
    Object localObject2 = this.a;
    FeedbackInputActivity.a((FeedbackInputActivity)localObject2, FeedbackInputActivity.s((FeedbackInputActivity)localObject2) + 1);
    c.b("@@@@@@@@: 规定交互轮次：" + FeedbackInputActivity.t(this.a) + " ***当前交互次数" + FeedbackInputActivity.s(this.a));
    if ((FeedbackInputActivity.s(this.a) >= FeedbackInputActivity.t(this.a)) && (FeedbackInputActivity.h(this.a)))
    {
      if (!FeedbackInputActivity.u(this.a)) {
        com.baidu.ufosdk.e.a.a(FeedbackInputActivity.g(this.a), "-1");
      }
      FeedbackInputActivity.v(this.a);
    }
    if (FeedbackInputActivity.w(this.a)) {
      FeedbackInputActivity.a(this.a, FeedbackInputActivity.l(this.a));
    }
    this.a.d = false;
    FeedbackInputActivity.x(this.a).setVisibility(0);
    Object localObject3 = (ArrayList)paramMessage.obj;
    int i = 0;
    for (;;)
    {
      if (i >= ((ArrayList)localObject3).size())
      {
        if (!FeedbackInputActivity.y(this.a)) {
          break label2615;
        }
        FeedbackInputActivity.z(this.a).setVisibility(0);
        break;
      }
      localObject2 = (String)((Map)((ArrayList)localObject3).get(i)).get("id");
      if ((localObject2 != null) && (((String)localObject2).equals(FeedbackInputActivity.g(this.a))))
      {
        localObject5 = new HashMap();
        ((Map)localObject5).put("from", Integer.valueOf(1));
        ((Map)localObject5).put("content", (String)((Map)((ArrayList)localObject3).get(i)).get("content"));
        ((Map)localObject5).put("time", (String)((Map)((ArrayList)localObject3).get(i)).get("time"));
        ((Map)localObject5).put("contenttype", "0");
        localObject2 = (String)((Map)((ArrayList)localObject3).get(i)).get("toggle");
        if ((localObject2 != null) && (((String)localObject2).equals("yes")) && (!FeedbackInputActivity.u(this.a)))
        {
          FeedbackInputActivity.a(this.a, true);
          localObject2 = (String)((Map)localObject5).get("content");
          if (!((String)((Map)localObject5).get("content")).contains("</br>")) {
            break label3361;
          }
          localObject2 = ((String)localObject2).replace("</br>", "\n");
          label2272:
          if (!((String)((Map)localObject5).get("content")).contains("</a>")) {
            break label3358;
          }
          localObject6 = ((String)localObject2).split("</a>");
          j = 0;
          label2305:
          if (j < localObject6.length - 1) {
            break label2511;
          }
          localObject2 = "";
          j = 0;
        }
        label2340:
        label2511:
        int k;
        for (;;)
        {
          if (j >= localObject6.length)
          {
            localObject2 = ((String)localObject2).replace("\n\n", "\n");
            ((Map)localObject5).remove("content");
            ((Map)localObject5).put("content", localObject2);
            if ((((String)localObject2).contains(".jpg")) && (((String)localObject2).contains("http")))
            {
              ((Map)localObject5).remove("contenttype");
              ((Map)localObject5).put("contenttype", "1");
            }
            localObject2 = (String)((Map)((ArrayList)localObject3).get(i)).get("toggle");
            if ((localObject2 != null) && (((String)localObject2).equals("no"))) {
              FeedbackInputActivity.v(this.a);
            }
            FeedbackInputActivity.p(this.a).add(localObject5);
            FeedbackInputActivity.q(this.a).notifyDataSetChanged();
            FeedbackInputActivity.r(this.a).setSelection(FeedbackInputActivity.r(this.a).getBottom());
            break label3365;
            FeedbackInputActivity.a(this.a, false);
            break;
            localObject6[j] = localObject6[j].replace("<a href= \"", "\n");
            k = localObject6[j].indexOf("target=\"_blank\">");
            localObject6[j] = localObject6[j].substring(0, k);
            localObject6[j] = localObject6[j].replace("\"", "\n");
            j += 1;
            break label2305;
          }
          localObject2 = localObject2 + localObject6[j] + "\n";
          j += 1;
        }
        label2615:
        FeedbackInputActivity.z(this.a).setVisibility(8);
        break;
        label2635:
        localObject2 = FeedbackInputActivity.F(this.a).getString("first" + FeedbackInputActivity.l(this.a), "0");
        boolean bool = ((String)localObject2).equals("0");
        if (bool) {}
        for (;;)
        {
          try
          {
            localObject3 = (String)new JSONArray((String)localObject6).getJSONObject(0).get("time");
            localObject2 = localObject3;
            ((Map)localObject5).put("time", localObject2);
          }
          catch (JSONException localJSONException2)
          {
            localJSONException2.printStackTrace();
          }
        }
        label2740:
        localObject6 = new HashMap();
        int j = ((Integer)((JSONArray)localObject5).getJSONObject(i).get("from")).intValue();
        ((Map)localObject6).put("from", Integer.valueOf(j));
        localObject2 = (String)((JSONArray)localObject5).getJSONObject(i).get("contenttype");
        ((Map)localObject6).put("contenttype", localObject2);
        Object localObject4 = ((JSONArray)localObject5).getJSONObject(i).getString("extra");
        if ((((String)localObject4).length() == 0) || (localObject4 == null)) {
          ((Map)localObject6).put("content", (String)((JSONArray)localObject5).getJSONObject(i).get("content"));
        }
        for (;;)
        {
          localObject2 = (String)((Map)localObject6).get("content");
          if (!((String)((Map)localObject6).get("content")).contains("</br>")) {
            break label3355;
          }
          localObject2 = ((String)localObject2).replace("</br>", "\n");
          localObject4 = localObject2;
          if (((String)((Map)localObject6).get("content")).contains("</a>"))
          {
            localObject4 = ((String)localObject2).split("</a>");
            j = 0;
            if (j < localObject4.length - 1) {
              break label3217;
            }
            localObject2 = "";
            j = 0;
            if (j < localObject4.length) {
              break label3284;
            }
            localObject4 = ((String)localObject2).replace("\n\n", "\n");
          }
          ((Map)localObject6).remove("content");
          ((Map)localObject6).put("content", localObject4);
          ((Map)localObject6).put("time", (String)((JSONArray)localObject5).getJSONObject(i).get("time"));
          FeedbackInputActivity.p(this.a).add(localObject6);
          i += 1;
          break;
          localObject4 = new JSONObject((String)localObject4);
          if ((localObject2 == null) || (j != 1) || (!((String)localObject2).equals("0"))) {
            break label3190;
          }
          if (!((JSONObject)localObject4).has("answer")) {
            break label3168;
          }
          localObject2 = ((JSONObject)localObject4).getString("answer");
          if ((localObject2 != null) && (((String)localObject2).length() != 0) && (!((String)localObject2).equals("")) && (!((String)localObject2).equals("null"))) {
            break label3175;
          }
          ((Map)localObject6).put("content", ((JSONArray)localObject5).getJSONObject(i).getString("content"));
        }
        label3168:
        String str;
        label3175:
        label3190:
        label3217:
        label3284:
        label3321:
        label3355:
        label3358:
        label3361:
        label3364:
        return;
      }
      label3365:
      i += 1;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/ufosdk/ui/aj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */