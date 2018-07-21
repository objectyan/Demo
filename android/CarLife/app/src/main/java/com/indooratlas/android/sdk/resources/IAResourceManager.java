package com.indooratlas.android.sdk.resources;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.indooratlas.android.sdk._internal.ba;

public abstract class IAResourceManager
{
  public static IAResourceManager create(@NonNull Context paramContext)
  {
    return new ba(paramContext, null);
  }
  
  public static IAResourceManager create(@NonNull Context paramContext, @Nullable Bundle paramBundle)
  {
    return new ba(paramContext, paramBundle);
  }
  
  public abstract IATask<IAFloorPlan> fetchFloorPlanWithId(@NonNull String paramString);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/indooratlas/android/sdk/resources/IAResourceManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */