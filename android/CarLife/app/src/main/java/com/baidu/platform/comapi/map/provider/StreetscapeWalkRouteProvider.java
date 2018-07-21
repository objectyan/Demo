package com.baidu.platform.comapi.map.provider;

import android.os.Bundle;
import com.baidu.platform.comapi.util.JsonBuilder;
import com.baidu.platform.comapi.util.f;

public class StreetscapeWalkRouteProvider
  implements RenderProvider
{
  private static final String TAG = StreetscapeWalkRouteProvider.class.getSimpleName();
  private JsonBuilder mJsonBuilder;
  private int mNodeCount;
  private Bundle walkPosBundle;
  
  public StreetscapeWalkRouteProvider(Bundle paramBundle)
  {
    this.walkPosBundle = paramBundle;
  }
  
  private void addPath()
  {
    this.mJsonBuilder.object();
    double[] arrayOfDouble1 = this.walkPosBundle.getDoubleArray("x");
    double[] arrayOfDouble2 = this.walkPosBundle.getDoubleArray("y");
    JsonBuilder localJsonBuilder = new JsonBuilder();
    localJsonBuilder.arrayValue();
    int i = 0;
    while (i < arrayOfDouble1.length)
    {
      localJsonBuilder.value(arrayOfDouble1[i]);
      localJsonBuilder.value(arrayOfDouble2[i]);
      localJsonBuilder.value(-2);
      i += 1;
    }
    localJsonBuilder.endArrayValue();
    this.mJsonBuilder.key("path").objectValue(localJsonBuilder.getJson());
    this.mJsonBuilder.endObject();
  }
  
  private void resetTemporaryField()
  {
    this.mJsonBuilder = new JsonBuilder();
    this.mNodeCount = 0;
  }
  
  public String getRenderData()
  {
    resetTemporaryField();
    try
    {
      this.mJsonBuilder.object().key("dataset").arrayValue();
      addPath();
      this.mJsonBuilder.endArrayValue().endObject();
      return this.mJsonBuilder.getJson();
    }
    catch (Exception localException)
    {
      f.a(TAG, "getRenderData error", localException);
    }
    return "";
  }
  
  public Bundle getWalkPosBundle()
  {
    return this.walkPosBundle;
  }
  
  public void setWalkPosBundle(Bundle paramBundle)
  {
    this.walkPosBundle = paramBundle;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/platform/comapi/map/provider/StreetscapeWalkRouteProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */