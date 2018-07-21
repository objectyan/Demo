package com.indooratlas.android.sdk._internal;

import android.text.TextUtils;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class ai
  extends z<JSONObject>
{
  private static final String b = ee.a(ai.class);
  private static final JSONObject c = new JSONObject();
  
  private static JSONObject c(x paramx)
    throws IOException
  {
    paramx = paramx.d();
    try
    {
      if (TextUtils.isEmpty(paramx)) {
        return c;
      }
      paramx = new JSONObject(paramx);
      return paramx;
    }
    catch (JSONException paramx)
    {
      throw new IOException("error parsing response body to JSON", paramx);
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */