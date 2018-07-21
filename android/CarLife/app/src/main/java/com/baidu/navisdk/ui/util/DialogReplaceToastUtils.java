package com.baidu.navisdk.ui.util;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.Window;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.ui.widget.BNTiptoolDialog;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.navisdk.util.worker.IBNWorkerCenter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DialogReplaceToastUtils
{
  private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
  public static final int LONG_TIME = 3500;
  private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
  public static final int SHORT_TIME = 2000;
  public static final String TAG = DialogReplaceToastUtils.class.getName();
  private static BNTiptoolDialog mShowDialog = null;
  
  private static void createDialog(String paramString)
  {
    mShowDialog = new BNTiptoolDialog(BNaviModuleManager.getContext(), 1711996966, paramString);
    mShowDialog.setCanceledOnTouchOutside(false);
    mShowDialog.getWindow().setFlags(8, 8);
  }
  
  private static int getLastTime(int paramInt)
  {
    int i = 2000;
    if (1 == paramInt) {
      i = 3500;
    }
    while (paramInt != 0) {
      return i;
    }
    return 2000;
  }
  
  public static boolean hasNotifiyAuth()
  {
    if (Build.VERSION.SDK_INT < 19) {}
    do
    {
      return true;
      localObject2 = BNaviModuleManager.getContext();
    } while (localObject2 == null);
    AppOpsManager localAppOpsManager = (AppOpsManager)((Context)localObject2).getSystemService("appops");
    Object localObject1 = ((Context)localObject2).getApplicationInfo();
    Object localObject2 = ((Context)localObject2).getApplicationContext().getPackageName();
    int i = ((ApplicationInfo)localObject1).uid;
    try
    {
      localObject1 = Class.forName(AppOpsManager.class.getName());
      i = ((Integer)((Class)localObject1).getMethod("checkOpNoThrow", new Class[] { Integer.TYPE, Integer.TYPE, String.class }).invoke(localAppOpsManager, new Object[] { Integer.valueOf(((Integer)((Class)localObject1).getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), localObject2 })).intValue();
      if (i == 0) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
      return true;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
      return true;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
      return true;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localInvocationTargetException.printStackTrace();
      return true;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
  }
  
  public static void showToastMessage(final Context paramContext, final String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask("", null)new BNWorkerConfig
    {
      protected String execute()
      {
        try
        {
          DialogReplaceToastUtils.showToastMessage(paramContext, paramString, 0);
          return null;
        }
        catch (Exception localException)
        {
          for (;;) {}
        }
      }
    }, new BNWorkerConfig(100, 0));
  }
  
  private static void showToastMessage(Context paramContext, String paramString, int paramInt)
  {
    paramInt = 0;
    if (paramString.length() > 15) {
      paramInt = 1;
    }
    LogUtil.e(TAG, "showToastMessage1 " + paramString + ", dialog= " + mShowDialog);
    paramInt = getLastTime(paramInt);
    if (mShowDialog == null)
    {
      createDialog(paramString);
      mShowDialog.showToastMsg(paramString, paramInt);
      return;
    }
    mShowDialog.release();
    try
    {
      mShowDialog.dismiss();
      mShowDialog = null;
      createDialog(paramString);
      mShowDialog.showToastMsg(paramString, paramInt);
      return;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/ui/util/DialogReplaceToastUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */