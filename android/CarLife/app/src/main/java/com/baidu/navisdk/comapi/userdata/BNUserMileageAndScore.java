package com.baidu.navisdk.comapi.userdata;

import android.os.Bundle;
import com.baidu.navisdk.comapi.base.BNLogicController;
import com.baidu.navisdk.jni.nativeif.JNITrajectoryControl;
import java.util.ArrayList;

public class BNUserMileageAndScore extends BNLogicController {
    public static int getNotSynchMileageFromEngine(String bduss, String uid, ArrayList<Bundle> resultList) {
        return JNITrajectoryControl.sInstance.getNotSyncMileageByUser(bduss, uid, resultList);
    }

    public static void updateUserInfo(String bduss, String uid, int isLogin) {
        JNITrajectoryControl.sInstance.updateUserInfo(bduss, uid, isLogin);
    }
}
