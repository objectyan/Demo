package com.tencent.mm.sdk.diffdev;

import android.util.Log;
import com.tencent.mm.sdk.diffdev.a.a;

public class DiffDevOAuthFactory
{
  public static final int MAX_SUPPORTED_VERSION = 1;
  private static final String TAG = "MicroMsg.SDK.DiffDevOAuthFactory";
  public static final int VERSION_1 = 1;
  private static IDiffDevOAuth v1Instance = null;
  
  public static IDiffDevOAuth getDiffDevOAuth()
  {
    return getDiffDevOAuth(1);
  }
  
  public static IDiffDevOAuth getDiffDevOAuth(int paramInt)
  {
    Log.v("MicroMsg.SDK.DiffDevOAuthFactory", "getDiffDevOAuth, version = " + paramInt);
    if (paramInt > 1)
    {
      Log.e("MicroMsg.SDK.DiffDevOAuthFactory", "getDiffDevOAuth fail, unsupported version = " + paramInt);
      return null;
    }
    switch (paramInt)
    {
    default: 
      return null;
    }
    if (v1Instance == null) {
      v1Instance = new a();
    }
    return v1Instance;
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes3-dex2jar.jar!/com/tencent/mm/sdk/diffdev/DiffDevOAuthFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */