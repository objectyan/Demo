package com.baidu.tts.p;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.baidu.tts.h.b.b;
import com.baidu.tts.jni.EmbeddedSynthesizerEngine;
import com.baidu.tts.tools.CommonUtility;
import com.baidu.tts.tools.GetCUID;
import org.json.JSONException;
import org.json.JSONObject;

public class a
{
  public static String a(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("System", Build.VERSION.RELEASE);
      localJSONObject.put("SystemVersion", Build.VERSION.SDK + "");
      localJSONObject.put("PhoneModel", Build.MODEL);
      localJSONObject.put("CPU", Build.CPU_ABI);
      localJSONObject.put("NetworkType", CommonUtility.getNetworkInfo(paramContext));
      return localJSONObject.toString();
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static String b(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("Cuid", GetCUID.getCUID(paramContext));
      localJSONObject.put("AppPackageName", paramContext.getPackageName());
      localJSONObject.put("SDKVersion", b.a().j());
      localJSONObject.put("soInfo", EmbeddedSynthesizerEngine.bdTTSGetEngineParam());
      return localJSONObject.toString();
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/tts/p/a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */