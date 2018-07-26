package com.baidu.navisdk.ui.util;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.C4048R;
import com.baidu.navisdk.ui.widget.BNTiptoolDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DialogReplaceToastUtils {
    private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
    public static final int LONG_TIME = 3500;
    private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
    public static final int SHORT_TIME = 2000;
    public static final String TAG = DialogReplaceToastUtils.class.getName();
    private static BNTiptoolDialog mShowDialog = null;

    public static void showToastMessage(final Context ctx, final String msg) {
        if (ctx != null && !TextUtils.isEmpty(msg)) {
            BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("", null) {
                protected String execute() {
                    try {
                        DialogReplaceToastUtils.showToastMessage(ctx, msg, 0);
                    } catch (Exception e) {
                    }
                    return null;
                }
            }, new BNWorkerConfig(100, 0));
        }
    }

    private static void showToastMessage(Context ctx, String msg, int num) {
        int durationTime = 0;
        if (msg.length() > 15) {
            durationTime = 1;
        }
        LogUtil.m15791e(TAG, "showToastMessage1 " + msg + ", dialog= " + mShowDialog);
        int time = getLastTime(durationTime);
        if (mShowDialog == null) {
            createDialog(msg);
            mShowDialog.showToastMsg(msg, time);
            return;
        }
        mShowDialog.release();
        try {
            mShowDialog.dismiss();
        } catch (Exception e) {
        }
        mShowDialog = null;
        createDialog(msg);
        mShowDialog.showToastMsg(msg, time);
    }

    private static int getLastTime(int duration) {
        if (1 == duration) {
            return LONG_TIME;
        }
        return duration == 0 ? 2000 : 2000;
    }

    private static void createDialog(String msg) {
        mShowDialog = new BNTiptoolDialog(BNaviModuleManager.getContext(), C4048R.style.TiptoolDialog, msg);
        mShowDialog.setCanceledOnTouchOutside(false);
        mShowDialog.getWindow().setFlags(8, 8);
    }

    public static boolean hasNotifiyAuth() {
        if (VERSION.SDK_INT < 19) {
            return true;
        }
        Context ctx = BNaviModuleManager.getContext();
        if (ctx == null) {
            return true;
        }
        AppOpsManager mAppOps = (AppOpsManager) ctx.getSystemService("appops");
        ApplicationInfo appInfo = ctx.getApplicationInfo();
        String pkg = ctx.getApplicationContext().getPackageName();
        int uid = appInfo.uid;
        try {
            Class appOpsClass = Class.forName(AppOpsManager.class.getName());
            Method checkOpNoThrowMethod = appOpsClass.getMethod(CHECK_OP_NO_THROW, new Class[]{Integer.TYPE, Integer.TYPE, String.class});
            int value = ((Integer) appOpsClass.getDeclaredField(OP_POST_NOTIFICATION).get(Integer.class)).intValue();
            return ((Integer) checkOpNoThrowMethod.invoke(mAppOps, new Object[]{Integer.valueOf(value), Integer.valueOf(uid), pkg})).intValue() == 0;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return true;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return true;
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
            return true;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return true;
        } catch (IllegalAccessException e5) {
            e5.printStackTrace();
            return true;
        }
    }
}
