package com.baidu.navisdk.comapi.userdata;

import android.os.Bundle;
import com.baidu.navisdk.comapi.base.BNLogicController;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import java.util.ArrayList;

public class BNUserMileageAndScore
  extends BNLogicController
{
  public static int getNotSynchMileageFromEngine(String paramString1, String paramString2, ArrayList<Bundle> paramArrayList)
  {
    return JNITrajectoryControl.sInstance.getNotSyncMileageByUser(paramString1, paramString2, paramArrayList);
  }
  
  public static void updateUserInfo(String paramString1, String paramString2, int paramInt)
  {
    JNITrajectoryControl.sInstance.updateUserInfo(paramString1, paramString2, paramInt);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/comapi/userdata/BNUserMileageAndScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */