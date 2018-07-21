package com.baidu.carlife.push;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.pushservice.PushMessageReceiver;
import com.baidu.carlife.core.i;
import com.baidu.carlife.core.k;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class CarLifePushMessageReceiver
  extends PushMessageReceiver
{
  public static final String a = CarLifePushMessageReceiver.class.getSimpleName();
  
  public void onBind(Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    paramContext = "onBind errorCode=" + paramInt + " appid=" + paramString1 + " userId=" + paramString2 + " channelId=" + paramString3 + " requestId=" + paramString4;
    Log.d(a, paramContext);
    if (paramInt == 0) {
      Log.d(a, "绑定成功");
    }
  }
  
  public void onDelTags(Context paramContext, int paramInt, List<String> paramList1, List<String> paramList2, String paramString)
  {
    paramContext = "onDelTags errorCode=" + paramInt + " successTags=" + paramList1 + " failTags=" + paramList2 + " requestId=" + paramString;
    Log.d(a, paramContext);
  }
  
  public void onListTags(Context paramContext, int paramInt, List<String> paramList, String paramString)
  {
    paramContext = "onListTags errorCode=" + paramInt + " tags=" + paramList;
    Log.d(a, paramContext);
  }
  
  public void onMessage(Context paramContext, String paramString1, String paramString2)
  {
    paramContext = "透传消息 onMessage=\"" + paramString1 + "\" customContentString=" + paramString2;
    Log.d(a, paramContext);
    if (!TextUtils.isEmpty(paramString2)) {}
    try
    {
      paramContext = new JSONObject(paramString2);
      paramContext.printStackTrace();
    }
    catch (JSONException paramContext)
    {
      try
      {
        if (!paramContext.isNull("mykey")) {
          paramContext.getString("mykey");
        }
        return;
      }
      catch (JSONException paramContext)
      {
        for (;;) {}
      }
      paramContext = paramContext;
    }
  }
  
  public void onNotificationArrived(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = "通知到达 onNotificationArrived  title=\"" + paramString1 + "\" description=\"" + paramString2 + "\" customContent=" + paramString3;
    Log.d(a, paramContext);
    if (!TextUtils.isEmpty(paramString3)) {}
    try
    {
      paramContext = new JSONObject(paramString3);
      paramContext.printStackTrace();
    }
    catch (JSONException paramContext)
    {
      try
      {
        if (!paramContext.isNull("mykey")) {
          paramContext.getString("mykey");
        }
        return;
      }
      catch (JSONException paramContext)
      {
        for (;;) {}
      }
      paramContext = paramContext;
    }
  }
  
  public void onNotificationClicked(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = "通知点击 onNotificationClicked title=\"" + paramString1 + "\" description=\"" + paramString2 + "\" customContent=" + paramString3;
    Log.d(a, paramContext);
    if (!TextUtils.isEmpty(paramString3)) {}
    try
    {
      paramContext = new JSONObject(paramString3);
      paramContext.printStackTrace();
    }
    catch (JSONException paramContext)
    {
      try
      {
        if (!paramContext.isNull("urlkey"))
        {
          paramContext = paramContext.getString("urlkey");
          paramContext.replace("\\", "");
          if (!paramContext.isEmpty())
          {
            a.a(paramContext);
            k.a(1072, 0, 0, paramContext);
            i.b(a, "GetValue: " + paramContext);
          }
        }
        return;
      }
      catch (JSONException paramContext)
      {
        for (;;) {}
      }
      paramContext = paramContext;
    }
  }
  
  public void onSetTags(Context paramContext, int paramInt, List<String> paramList1, List<String> paramList2, String paramString)
  {
    paramContext = "onSetTags errorCode=" + paramInt + " successTags=" + paramList1 + " failTags=" + paramList2 + " requestId=" + paramString;
    Log.d(a, paramContext);
  }
  
  public void onUnbind(Context paramContext, int paramInt, String paramString)
  {
    paramContext = "onUnbind errorCode=" + paramInt + " requestId = " + paramString;
    Log.d(a, paramContext);
    if (paramInt == 0) {
      Log.d(a, "解绑成功");
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/carlife/push/CarLifePushMessageReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */