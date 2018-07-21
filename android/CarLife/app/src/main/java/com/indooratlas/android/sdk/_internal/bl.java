package com.indooratlas.android.sdk._internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONObject;

final class bl
{
  SharedPreferences a;
  SharedPreferences.Editor b;
  
  @SuppressLint({"CommitPrefEdits"})
  bl(Context paramContext)
  {
    this.a = paramContext.getSharedPreferences("com.indooratlas.sdk.runtime", 0);
    this.b = this.a.edit();
  }
  
  static String a(JSONObject paramJSONObject)
  {
    try
    {
      paramJSONObject = ct.a(ct.a(paramJSONObject.toString()));
      return paramJSONObject;
    }
    catch (Exception paramJSONObject) {}
    return "";
  }
  
  public final String a()
  {
    String str = this.a.getString("idauuid", null);
    if (str == null) {
      throw new IllegalStateException("called getIdaUUID before api key is stored");
    }
    return str;
  }
  
  public final void b()
  {
    this.b.apply();
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/bl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */