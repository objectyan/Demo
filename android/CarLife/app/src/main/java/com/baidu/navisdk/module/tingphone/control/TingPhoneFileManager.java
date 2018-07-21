package com.baidu.navisdk.module.tingphone.control;

import android.content.Context;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.common.CommonHandlerThread;
import com.baidu.navisdk.util.common.CommonHandlerThread.Callback;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.common.SysOSAPI;
import java.io.File;

public class TingPhoneFileManager
{
  public static final String TAG = TingPhoneFileManager.class.getSimpleName();
  
  private static boolean cleanModulePath()
  {
    Object localObject = getModuleFilePath();
    LogUtil.e(TAG, "module path = " + (String)localObject);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      LogUtil.e(TAG, "module path is null or empty");
      return false;
    }
    localObject = new File((String)localObject);
    if ((localObject == null) || (!((File)localObject).exists()))
    {
      LogUtil.e(TAG, "module path tingphone floder no exist");
      return false;
    }
    return deleteDir((File)localObject);
  }
  
  public static void cleanPathFileAndConfig()
  {
    CommonHandlerThread.getInstance().registerCallback(new CommonHandlerThread.Callback()
    {
      public void careAbouts()
      {
        careAbout(20);
      }
      
      public void execute(Message paramAnonymousMessage)
      {
        if (paramAnonymousMessage.what == 20) {}
        try
        {
          TingPhoneFileManager.access$000();
          TingPhoneFileManager.access$100();
          return;
        }
        catch (Throwable paramAnonymousMessage) {}
      }
      
      public String getName()
      {
        return "TingPhone";
      }
    });
    CommonHandlerThread.getInstance().sendMessage(20, 0, 0, null, 3000L);
  }
  
  private static boolean cleanSDCard()
  {
    Object localObject = getSDCardFirstDirPath();
    LogUtil.e(TAG, "sdcard path = " + (String)localObject);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      LogUtil.e(TAG, "sdcard path is null or empty");
      return false;
    }
    localObject = new File((String)localObject);
    if ((localObject == null) || (!((File)localObject).exists()))
    {
      LogUtil.e(TAG, "sdcard tingphone floder no exist");
      return false;
    }
    return deleteDir((File)localObject);
  }
  
  private static boolean deleteDir(File paramFile)
  {
    if (paramFile == null) {}
    String[] arrayOfString;
    do
    {
      return false;
      if (!paramFile.isDirectory()) {
        break;
      }
      arrayOfString = paramFile.list();
    } while (arrayOfString == null);
    int i = 0;
    for (;;)
    {
      if (i >= arrayOfString.length) {
        break label54;
      }
      if (!deleteDir(new File(paramFile, arrayOfString[i]))) {
        break;
      }
      i += 1;
    }
    label54:
    return paramFile.delete();
  }
  
  private static String getModuleFilePath()
  {
    Object localObject = BNaviModuleManager.getContext();
    if (localObject == null) {}
    do
    {
      do
      {
        return null;
        localObject = ((Context)localObject).getExternalFilesDir("BaiduMap");
      } while (localObject == null);
      localObject = ((File)localObject).getAbsolutePath();
    } while (TextUtils.isEmpty((CharSequence)localObject));
    return (String)localObject + File.separator + "bnav" + File.separator + "tingphone";
  }
  
  private static String getSDCardFirstDirPath()
  {
    String str = SysOSAPI.getInstance().GetSDCardPath();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return str + File.separator + "tingphone";
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes2-dex2jar.jar!/com/baidu/navisdk/module/tingphone/control/TingPhoneFileManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */