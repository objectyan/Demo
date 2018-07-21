package com.baidu.navisdk.util.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.ui.util.TipTool;

public class SystemAuth
{
  public static final String CALL_PHONE_AUTH = "android.permission.CALL_PHONE";
  public static final int NO_TRY_SOURCE = 1000;
  public static final String PHOTO_CAPTURE_AUTH = "android.permission.CAMERA";
  public static final String PHOTO_CAPTURE_MSG = "没有照相机权限，请打开后重试";
  public static final String PROCESS_OUTGOING_CALLS_AUTH = "android.permission.PROCESS_OUTGOING_CALLS";
  public static final String READ_PHONE_STATE_AUTH = "android.permission.READ_PHONE_STATE";
  public static final String RECORD_AUDIO_AUTH = "android.permission.RECORD_AUDIO";
  public static final String RECORD_AUDIO_MSG = "没有麦克风权限，请打开后重试";
  
  public static boolean checkAuth(String paramString)
  {
    return checkAuth(paramString, false, null);
  }
  
  public static boolean checkAuth(String paramString1, boolean paramBoolean, String paramString2)
  {
    Context localContext = BNaviModuleManager.getContext();
    boolean bool2;
    if (localContext == null)
    {
      bool2 = false;
      return bool2;
    }
    boolean bool3 = false;
    for (;;)
    {
      try
      {
        if (localContext.getPackageManager().checkPermission(paramString1, PackageUtil.getPackageName()) == 0)
        {
          bool1 = true;
          bool2 = bool1;
          if (bool1) {
            break;
          }
          bool2 = bool1;
          if (!paramBoolean) {
            break;
          }
          bool2 = bool1;
          bool3 = bool1;
          if (TextUtils.isEmpty(paramString2)) {
            break;
          }
          bool3 = bool1;
          TipTool.onCreateToastDialog(localContext, paramString2);
          return bool1;
        }
      }
      catch (Throwable paramString1)
      {
        return bool3;
      }
      boolean bool1 = false;
    }
  }
  
  public static abstract interface IOnRequestAuthrityListener
  {
    public abstract boolean onRequestAuthrity(String paramString, int paramInt, Bundle paramBundle);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/util/common/SystemAuth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */