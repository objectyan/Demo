package com.indooratlas.android.sdk._internal;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import com.indooratlas.android.sdk.resources.IAFloorPlan;
import com.indooratlas.android.sdk.resources.IAResourceManager;
import com.indooratlas.android.sdk.resources.IATask;
import java.io.IOException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ba
  extends IAResourceManager
{
  private ac a;
  private bg b;
  
  public ba(@NonNull Context paramContext, Bundle paramBundle)
    throws IllegalStateException
  {
    try
    {
      paramContext = new bg.a(paramContext);
      paramContext.a = paramBundle;
      this.b = paramContext.a();
      return;
    }
    catch (bc paramContext)
    {
      ee.a("IASDK", paramContext.getMessage(), new Object[0]);
      throw new IllegalStateException(paramContext);
    }
  }
  
  public final IATask<IAFloorPlan> fetchFloorPlanWithId(@NonNull String paramString)
  {
    if (this.a == null)
    {
      bg localbg = this.b;
      ao localao = new ao(localbg.a, ct.a());
      localao.a(localbg.b, localbg.c);
      localao.a("IAWire");
      this.a = localao;
    }
    return new cm(this.a.a(new a(), paramString));
  }
  
  static final class a
    extends z<IAFloorPlan>
  {
    private static IAFloorPlan c(x paramx)
      throws IOException
    {
      for (;;)
      {
        try
        {
          localJSONArray = new JSONArray(paramx.d());
        }
        catch (JSONException paramx)
        {
          int j;
          JSONObject localJSONObject1;
          JSONObject localJSONObject2;
          String str1;
          String str2;
          int k;
          JSONArray localJSONArray = null;
          continue;
          int i = 0;
          continue;
        }
        try
        {
          j = localJSONArray.length();
          if (j > 0) {
            continue;
          }
          return null;
        }
        catch (JSONException paramx)
        {
          throw new IOException(paramx);
        }
        if (i >= j) {
          continue;
        }
        localJSONObject1 = localJSONArray.getJSONObject(i);
        if (localJSONObject1.has("idaFloorPlan"))
        {
          i = localJSONObject1.getInt("width");
          j = localJSONObject1.getInt("height");
          paramx = localJSONObject1.optString("url");
          localJSONObject2 = localJSONObject1.getJSONObject("idaFloorPlan");
          str1 = localJSONObject2.getString("id");
          str2 = localJSONObject2.getString("name");
          k = localJSONObject2.getInt("floorLevel");
          localJSONObject1 = localJSONObject1.getJSONObject("transformations");
          paramx = new IAFloorPlan(str1, str2, paramx, i, j, k, cn.a(localJSONObject1.getJSONArray("pixelToWgs")), cn.a(localJSONObject1.getJSONArray("wgsToPixel")));
          return paramx;
        }
        i += 1;
      }
      return null;
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/_internal/ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */