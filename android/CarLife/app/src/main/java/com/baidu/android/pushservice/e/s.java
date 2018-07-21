package com.baidu.android.pushservice.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.android.pushservice.j.p;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class s
  extends c
{
  private ArrayList<String> d = new ArrayList();
  
  public s(l paraml, Context paramContext)
  {
    super(paraml, paramContext);
  }
  
  protected void a(int paramInt, byte[] paramArrayOfByte)
  {
    Intent localIntent = new Intent();
    if (this.b.a.equals("method_list_lapp_tags")) {
      localIntent.setAction("com.baidu.android.pushservice.action.lapp.RECEIVE");
    }
    for (;;)
    {
      localIntent.putExtra("method", this.b.a);
      localIntent.putExtra("error_msg", paramInt);
      localIntent.putExtra("content", paramArrayOfByte);
      if (!this.d.isEmpty()) {
        localIntent.putStringArrayListExtra("tags_list", this.d);
      }
      localIntent.setFlags(32);
      a(localIntent);
      if (!TextUtils.isEmpty(this.b.e)) {
        break;
      }
      if ((this.b.a.equals("method_list_lapp_tags")) || (this.b.a.equals("method_list_sdk_tags"))) {
        break label214;
      }
      return;
      if (this.b.a.equals("method_list_sdk_tags")) {
        localIntent.setAction("com.baidu.android.pushservice.action.sdk.RECEIVE");
      } else {
        localIntent.setAction("com.baidu.android.pushservice.action.RECEIVE");
      }
    }
    if ((!this.b.a.equals("method_list_lapp_tags")) && (!this.b.a.equals("method_list_sdk_tags"))) {
      localIntent.setPackage(this.b.e);
    }
    label214:
    p.b(this.a, localIntent, localIntent.getAction(), localIntent.getPackage());
  }
  
  protected void a(HashMap<String, String> paramHashMap)
  {
    super.a(paramHashMap);
    paramHashMap.put("method", "glist");
  }
  
  protected String b(String paramString)
  {
    paramString = super.b(paramString);
    try
    {
      JSONArray localJSONArray = new JSONObject(paramString).getJSONObject("response_params").getJSONArray("groups");
      int i = 0;
      while (i < localJSONArray.length())
      {
        this.d.add(localJSONArray.getJSONObject(i).getString("name"));
        i += 1;
      }
      return paramString;
    }
    catch (JSONException localJSONException) {}
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/android/pushservice/e/s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */