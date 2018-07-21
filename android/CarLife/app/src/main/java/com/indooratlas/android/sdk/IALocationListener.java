package com.indooratlas.android.sdk;

import android.os.Bundle;

public abstract interface IALocationListener
{
  public abstract void onLocationChanged(IALocation paramIALocation);
  
  public abstract void onStatusChanged(String paramString, int paramInt, Bundle paramBundle);
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/indooratlas/android/sdk/IALocationListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */