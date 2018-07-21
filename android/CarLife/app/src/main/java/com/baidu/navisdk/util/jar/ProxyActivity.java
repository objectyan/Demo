package com.baidu.navisdk.util.jar;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.util.common.LogUtil;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ProxyActivity
  extends Activity
{
  private static final String TAG = "ProxyActivity";
  private static AssetManager naviSdkAm;
  private static Resources naviSdkRes;
  private static Resources.Theme naviSdkTheme;
  private String comPackageName;
  private LayoutInflater mInflater;
  private Activity originActivity = null;
  
  public ProxyActivity(Activity paramActivity)
  {
    if ((paramActivity == null) || (naviSdkRes == null) || (naviSdkTheme == null)) {
      LogUtil.e("ProxyActivity", "exception:originActivity = " + paramActivity + ";naviSdkRes=" + naviSdkRes + ";naviSdkTheme=" + naviSdkTheme);
    }
    this.originActivity = paramActivity;
    if (getBaseContext() == null) {
      attachBaseContext(getOriginalActivity().getBaseContext());
    }
  }
  
  public static void setAssetManager(AssetManager paramAssetManager)
  {
    naviSdkAm = paramAssetManager;
  }
  
  public static void setResource(Resources paramResources)
  {
    naviSdkRes = paramResources;
  }
  
  public static void setResourcesTheme(Resources.Theme paramTheme)
  {
    naviSdkTheme = paramTheme;
  }
  
  public boolean bindService(Intent paramIntent, ServiceConnection paramServiceConnection, int paramInt)
  {
    return getOriginalActivity().bindService(paramIntent, paramServiceConnection, paramInt);
  }
  
  public int checkCallingOrSelfPermission(String paramString)
  {
    return getOriginalActivity().checkCallingOrSelfPermission(paramString);
  }
  
  public int checkCallingOrSelfUriPermission(Uri paramUri, int paramInt)
  {
    return getOriginalActivity().checkCallingOrSelfUriPermission(paramUri, paramInt);
  }
  
  public int checkCallingPermission(String paramString)
  {
    return getOriginalActivity().checkCallingPermission(paramString);
  }
  
  public int checkCallingUriPermission(Uri paramUri, int paramInt)
  {
    return getOriginalActivity().checkCallingUriPermission(paramUri, paramInt);
  }
  
  public int checkPermission(String paramString, int paramInt1, int paramInt2)
  {
    return getOriginalActivity().checkPermission(paramString, paramInt1, paramInt2);
  }
  
  public int checkUriPermission(Uri paramUri, int paramInt1, int paramInt2, int paramInt3)
  {
    return getOriginalActivity().checkUriPermission(paramUri, paramInt1, paramInt2, paramInt3);
  }
  
  public int checkUriPermission(Uri paramUri, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    return getOriginalActivity().checkUriPermission(paramUri, paramString1, paramString2, paramInt1, paramInt2, paramInt3);
  }
  
  @Deprecated
  public void clearWallpaper()
    throws IOException
  {
    getOriginalActivity().clearWallpaper();
  }
  
  public Context createPackageContext(String paramString, int paramInt)
    throws PackageManager.NameNotFoundException
  {
    return getOriginalActivity().createPackageContext(paramString, paramInt);
  }
  
  public String[] databaseList()
  {
    return getOriginalActivity().databaseList();
  }
  
  public boolean deleteDatabase(String paramString)
  {
    return getOriginalActivity().deleteDatabase(paramString);
  }
  
  public boolean deleteFile(String paramString)
  {
    return getOriginalActivity().deleteFile(paramString);
  }
  
  public void destory()
  {
    this.originActivity = null;
  }
  
  public void enforceCallingOrSelfPermission(String paramString1, String paramString2)
  {
    getOriginalActivity().enforceCallingOrSelfPermission(paramString1, paramString2);
  }
  
  public void enforceCallingOrSelfUriPermission(Uri paramUri, int paramInt, String paramString)
  {
    getOriginalActivity().enforceCallingOrSelfUriPermission(paramUri, paramInt, paramString);
  }
  
  public void enforceCallingPermission(String paramString1, String paramString2)
  {
    getOriginalActivity().enforceCallingPermission(paramString1, paramString2);
  }
  
  public void enforceCallingUriPermission(Uri paramUri, int paramInt, String paramString)
  {
    getOriginalActivity().enforceCallingUriPermission(paramUri, paramInt, paramString);
  }
  
  public void enforcePermission(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    getOriginalActivity().enforcePermission(paramString1, paramInt1, paramInt2, paramString2);
  }
  
  public void enforceUriPermission(Uri paramUri, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    getOriginalActivity().enforceUriPermission(paramUri, paramInt1, paramInt2, paramInt3, paramString);
  }
  
  public void enforceUriPermission(Uri paramUri, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, String paramString3)
  {
    getOriginalActivity().enforceUriPermission(paramUri, paramString1, paramString2, paramInt1, paramInt2, paramInt3, paramString3);
  }
  
  public String[] fileList()
  {
    return getOriginalActivity().fileList();
  }
  
  public Context getApplicationContext()
  {
    return getOriginalActivity().getApplicationContext();
  }
  
  public ApplicationInfo getApplicationInfo()
  {
    return getOriginalActivity().getApplicationInfo();
  }
  
  public AssetManager getAssets()
  {
    return naviSdkAm;
  }
  
  public File getCacheDir()
  {
    return getOriginalActivity().getCacheDir();
  }
  
  public ClassLoader getClassLoader()
  {
    return getOriginalActivity().getClassLoader();
  }
  
  public ContentResolver getContentResolver()
  {
    return getOriginalActivity().getContentResolver();
  }
  
  public File getDatabasePath(String paramString)
  {
    return getOriginalActivity().getDatabasePath(paramString);
  }
  
  public File getDir(String paramString, int paramInt)
  {
    return getOriginalActivity().getDir(paramString, paramInt);
  }
  
  public File getExternalCacheDir()
  {
    return getOriginalActivity().getExternalCacheDir();
  }
  
  public File getExternalFilesDir(String paramString)
  {
    return getOriginalActivity().getExternalFilesDir(paramString);
  }
  
  public File getFileStreamPath(String paramString)
  {
    return getOriginalActivity().getFileStreamPath(paramString);
  }
  
  public File getFilesDir()
  {
    return getOriginalActivity().getFilesDir();
  }
  
  public LayoutInflater getLayoutInflater()
  {
    return getOriginalActivity().getLayoutInflater();
  }
  
  public Looper getMainLooper()
  {
    return getOriginalActivity().getMainLooper();
  }
  
  public File getObbDir()
  {
    return getOriginalActivity().getObbDir();
  }
  
  public Activity getOriginActivity()
  {
    return this.originActivity;
  }
  
  public Activity getOriginalActivity()
  {
    if (this.originActivity == null) {
      return BNaviModuleManager.getActivity();
    }
    return this.originActivity;
  }
  
  public String getPackageCodePath()
  {
    return getOriginalActivity().getPackageCodePath();
  }
  
  public PackageManager getPackageManager()
  {
    return getOriginalActivity().getPackageManager();
  }
  
  public String getPackageName()
  {
    return getOriginalActivity().getPackageName();
  }
  
  public String getPackageResourcePath()
  {
    return getOriginalActivity().getPackageResourcePath();
  }
  
  public Resources getResources()
  {
    return naviSdkRes;
  }
  
  public SharedPreferences getSharedPreferences(String paramString, int paramInt)
  {
    return getOriginalActivity().getSharedPreferences(paramString, paramInt);
  }
  
  public Object getSystemService(String paramString)
  {
    if ((TextUtils.equals(paramString, "layout_inflater")) && (Build.VERSION.SDK_INT <= 15))
    {
      if (this.mInflater == null) {
        this.mInflater = ((LayoutInflater)super.getSystemService(paramString)).cloneInContext(this);
      }
      return this.mInflater;
    }
    return getOriginalActivity().getSystemService(paramString);
  }
  
  public Resources.Theme getTheme()
  {
    return naviSdkTheme;
  }
  
  @Deprecated
  public Drawable getWallpaper()
  {
    return getOriginalActivity().getWallpaper();
  }
  
  @Deprecated
  public int getWallpaperDesiredMinimumHeight()
  {
    return getOriginalActivity().getWallpaperDesiredMinimumHeight();
  }
  
  @Deprecated
  public int getWallpaperDesiredMinimumWidth()
  {
    return getOriginalActivity().getWallpaperDesiredMinimumWidth();
  }
  
  public Window getWindow()
  {
    return getOriginalActivity().getWindow();
  }
  
  public WindowManager getWindowManager()
  {
    return getOriginalActivity().getWindowManager();
  }
  
  public void grantUriPermission(String paramString, Uri paramUri, int paramInt)
  {
    getOriginalActivity().grantUriPermission(paramString, paramUri, paramInt);
  }
  
  public boolean isFinishing()
  {
    return getOriginalActivity().isFinishing();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public FileInputStream openFileInput(String paramString)
    throws FileNotFoundException
  {
    return getOriginalActivity().openFileInput(paramString);
  }
  
  public FileOutputStream openFileOutput(String paramString, int paramInt)
    throws FileNotFoundException
  {
    return getOriginalActivity().openFileOutput(paramString, paramInt);
  }
  
  public SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory)
  {
    return getOriginalActivity().openOrCreateDatabase(paramString, paramInt, paramCursorFactory);
  }
  
  public SQLiteDatabase openOrCreateDatabase(String paramString, int paramInt, SQLiteDatabase.CursorFactory paramCursorFactory, DatabaseErrorHandler paramDatabaseErrorHandler)
  {
    return getOriginalActivity().openOrCreateDatabase(paramString, paramInt, paramCursorFactory, paramDatabaseErrorHandler);
  }
  
  @Deprecated
  public Drawable peekWallpaper()
  {
    return getOriginalActivity().peekWallpaper();
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter)
  {
    return getOriginalActivity().registerReceiver(paramBroadcastReceiver, paramIntentFilter);
  }
  
  public Intent registerReceiver(BroadcastReceiver paramBroadcastReceiver, IntentFilter paramIntentFilter, String paramString, Handler paramHandler)
  {
    return getOriginalActivity().registerReceiver(paramBroadcastReceiver, paramIntentFilter, paramString, paramHandler);
  }
  
  public void removeStickyBroadcast(Intent paramIntent)
  {
    getOriginalActivity().removeStickyBroadcast(paramIntent);
  }
  
  public void revokeUriPermission(Uri paramUri, int paramInt)
  {
    getOriginalActivity().revokeUriPermission(paramUri, paramInt);
  }
  
  public void sendBroadcast(Intent paramIntent)
  {
    getOriginalActivity().sendBroadcast(paramIntent);
  }
  
  public void sendBroadcast(Intent paramIntent, String paramString)
  {
    getOriginalActivity().sendBroadcast(paramIntent, paramString);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString)
  {
    getOriginalActivity().sendBroadcast(paramIntent, paramString);
  }
  
  public void sendOrderedBroadcast(Intent paramIntent, String paramString1, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString2, Bundle paramBundle)
  {
    getOriginalActivity().sendOrderedBroadcast(paramIntent, paramString1, paramBroadcastReceiver, paramHandler, paramInt, paramString2, paramBundle);
  }
  
  public void sendStickyBroadcast(Intent paramIntent)
  {
    getOriginalActivity().sendStickyBroadcast(paramIntent);
  }
  
  public void sendStickyOrderedBroadcast(Intent paramIntent, BroadcastReceiver paramBroadcastReceiver, Handler paramHandler, int paramInt, String paramString, Bundle paramBundle)
  {
    getOriginalActivity().sendStickyOrderedBroadcast(paramIntent, paramBroadcastReceiver, paramHandler, paramInt, paramString, paramBundle);
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    getOriginalActivity().setRequestedOrientation(paramInt);
  }
  
  public void setTheme(int paramInt)
  {
    getOriginalActivity().setTheme(paramInt);
  }
  
  @Deprecated
  public void setWallpaper(Bitmap paramBitmap)
    throws IOException
  {
    getOriginalActivity().setWallpaper(paramBitmap);
  }
  
  @Deprecated
  public void setWallpaper(InputStream paramInputStream)
    throws IOException
  {
    getOriginalActivity().setWallpaper(paramInputStream);
  }
  
  public void startActivities(Intent[] paramArrayOfIntent)
  {
    getOriginalActivity().startActivities(paramArrayOfIntent);
  }
  
  public void startActivity(Intent paramIntent)
  {
    getOriginalActivity().startActivity(paramIntent);
  }
  
  public boolean startInstrumentation(ComponentName paramComponentName, String paramString, Bundle paramBundle)
  {
    return getOriginalActivity().startInstrumentation(paramComponentName, paramString, paramBundle);
  }
  
  public void startIntentSender(IntentSender paramIntentSender, Intent paramIntent, int paramInt1, int paramInt2, int paramInt3)
    throws IntentSender.SendIntentException
  {
    getOriginalActivity().startIntentSender(paramIntentSender, paramIntent, paramInt1, paramInt2, paramInt3);
  }
  
  public ComponentName startService(Intent paramIntent)
  {
    return getOriginalActivity().startService(paramIntent);
  }
  
  public boolean stopService(Intent paramIntent)
  {
    return getOriginalActivity().stopService(paramIntent);
  }
  
  public void unbindService(ServiceConnection paramServiceConnection)
  {
    try
    {
      getOriginalActivity().unbindService(paramServiceConnection);
      return;
    }
    catch (Exception paramServiceConnection)
    {
      paramServiceConnection.printStackTrace();
    }
  }
  
  public void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    try
    {
      getOriginalActivity().unregisterReceiver(paramBroadcastReceiver);
      return;
    }
    catch (Exception paramBroadcastReceiver)
    {
      paramBroadcastReceiver.printStackTrace();
    }
  }
}


/* Location:              /Users/objectyan/Documents/OY/baiduCarLife_40/dist/classes-dex2jar.jar!/com/baidu/navisdk/util/jar/ProxyActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */