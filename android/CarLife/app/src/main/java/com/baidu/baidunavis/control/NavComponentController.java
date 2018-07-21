package com.baidu.baidunavis.control;

import android.app.Application;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.navisdk.jni.nativeif.JNIBaseMap;
import java.io.File;

public class NavComponentController
{
  private static final String COM_COLLADA_NAME = "map.android.baidu.collada";
  public static final String TAG = NavComponentController.class.getSimpleName();
  private static NavComponentController sInstance = null;
  public boolean isColladaInit = false;
  
  public static NavComponentController getInstance()
  {
    if (sInstance == null) {
      sInstance = new NavComponentController();
    }
    return sInstance;
  }
  
  public void addColladaUserOP() {}
  
  public boolean dispatchCollada(boolean paramBoolean)
  {
    NavLogUtils.e(TAG, " dispatchCollada  isColladaInit " + this.isColladaInit + " isDownload " + paramBoolean);
    if (this.isColladaInit) {}
    return false;
  }
  
  public boolean invokeCollada()
  {
    NavLogUtils.e(TAG, " invokeCollada  isColladaInit " + this.isColladaInit);
    return this.isColladaInit;
  }
  
  public void loadColladaSo(boolean paramBoolean)
  {
    NavLogUtils.e(TAG, " loadColladaSo  isDownload " + paramBoolean);
    try
    {
      NavLogUtils.e(TAG, " loadColladaSo  isColladaInit " + this.isColladaInit);
      String str = NavMapAdapter.getInstance().getBaiduMapApplicationInstance().getFilesDir().getParentFile().getAbsolutePath() + File.separator + "lib" + File.separator + "libapp_colladalib.so";
      NavLogUtils.e(TAG, "getFilesDir " + str);
      if (new File(str).exists())
      {
        NavLogUtils.e(TAG, "getFilesDir " + str);
        this.isColladaInit = JNIBaseMap.ColladaModuleInit(str);
        JNIBaseMap.ColladaEnable(true);
      }
      for (;;)
      {
        NavLogUtils.e(TAG, " loadColladaSo  isColladaInit " + this.isColladaInit);
        return;
        NavLogUtils.e(TAG, "getFilesDir ");
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        this.isColladaInit = false;
      }
    }
  }
  
  public void requestCollada()
  {
    NavLogUtils.e(TAG, " requestCollada  isColladaInit " + this.isColladaInit);
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/baidunavis/control/NavComponentController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */