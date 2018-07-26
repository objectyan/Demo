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

public class ProxyActivity extends Activity {
    private static final String TAG = "ProxyActivity";
    private static AssetManager naviSdkAm;
    private static Resources naviSdkRes;
    private static Theme naviSdkTheme;
    private String comPackageName;
    private LayoutInflater mInflater;
    private Activity originActivity = null;

    public ProxyActivity(Activity originActivity) {
        if (originActivity == null || naviSdkRes == null || naviSdkTheme == null) {
            LogUtil.e(TAG, "exception:originActivity = " + originActivity + ";naviSdkRes=" + naviSdkRes + ";naviSdkTheme=" + naviSdkTheme);
        }
        this.originActivity = originActivity;
        if (getBaseContext() == null) {
            attachBaseContext(getOriginalActivity().getBaseContext());
        }
    }

    public void destory() {
        this.originActivity = null;
    }

    public static void setAssetManager(AssetManager am) {
        naviSdkAm = am;
    }

    public static void setResource(Resources res) {
        naviSdkRes = res;
    }

    public static void setResourcesTheme(Theme theme) {
        naviSdkTheme = theme;
    }

    public Activity getOriginalActivity() {
        if (this.originActivity == null) {
            return BNaviModuleManager.getActivity();
        }
        return this.originActivity;
    }

    public Window getWindow() {
        return getOriginalActivity().getWindow();
    }

    public WindowManager getWindowManager() {
        return getOriginalActivity().getWindowManager();
    }

    public void setRequestedOrientation(int requestedOrientation) {
        getOriginalActivity().setRequestedOrientation(requestedOrientation);
    }

    public boolean isFinishing() {
        return getOriginalActivity().isFinishing();
    }

    public AssetManager getAssets() {
        return naviSdkAm;
    }

    public Resources getResources() {
        return naviSdkRes;
    }

    public LayoutInflater getLayoutInflater() {
        return getOriginalActivity().getLayoutInflater();
    }

    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
    }

    public PackageManager getPackageManager() {
        return getOriginalActivity().getPackageManager();
    }

    public ContentResolver getContentResolver() {
        return getOriginalActivity().getContentResolver();
    }

    public Looper getMainLooper() {
        return getOriginalActivity().getMainLooper();
    }

    public Context getApplicationContext() {
        return getOriginalActivity().getApplicationContext();
    }

    public Activity getOriginActivity() {
        return this.originActivity;
    }

    public Theme getTheme() {
        return naviSdkTheme;
    }

    public ClassLoader getClassLoader() {
        return getOriginalActivity().getClassLoader();
    }

    public String getPackageName() {
        return getOriginalActivity().getPackageName();
    }

    public ApplicationInfo getApplicationInfo() {
        return getOriginalActivity().getApplicationInfo();
    }

    public String getPackageResourcePath() {
        return getOriginalActivity().getPackageResourcePath();
    }

    public String getPackageCodePath() {
        return getOriginalActivity().getPackageCodePath();
    }

    public SharedPreferences getSharedPreferences(String name, int mode) {
        return getOriginalActivity().getSharedPreferences(name, mode);
    }

    public FileInputStream openFileInput(String name) throws FileNotFoundException {
        return getOriginalActivity().openFileInput(name);
    }

    public FileOutputStream openFileOutput(String name, int mode) throws FileNotFoundException {
        return getOriginalActivity().openFileOutput(name, mode);
    }

    public File getFileStreamPath(String name) {
        return getOriginalActivity().getFileStreamPath(name);
    }

    public File getFilesDir() {
        return getOriginalActivity().getFilesDir();
    }

    public File getExternalFilesDir(String type) {
        return getOriginalActivity().getExternalFilesDir(type);
    }

    public File getObbDir() {
        return getOriginalActivity().getObbDir();
    }

    public File getCacheDir() {
        return getOriginalActivity().getCacheDir();
    }

    public File getExternalCacheDir() {
        return getOriginalActivity().getExternalCacheDir();
    }

    public String[] fileList() {
        return getOriginalActivity().fileList();
    }

    public File getDir(String name, int mode) {
        return getOriginalActivity().getDir(name, mode);
    }

    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory) {
        return getOriginalActivity().openOrCreateDatabase(name, mode, factory);
    }

    public SQLiteDatabase openOrCreateDatabase(String name, int mode, CursorFactory factory, DatabaseErrorHandler errorHandler) {
        return getOriginalActivity().openOrCreateDatabase(name, mode, factory, errorHandler);
    }

    public File getDatabasePath(String name) {
        return getOriginalActivity().getDatabasePath(name);
    }

    @Deprecated
    public Drawable getWallpaper() {
        return getOriginalActivity().getWallpaper();
    }

    @Deprecated
    public Drawable peekWallpaper() {
        return getOriginalActivity().peekWallpaper();
    }

    @Deprecated
    public int getWallpaperDesiredMinimumWidth() {
        return getOriginalActivity().getWallpaperDesiredMinimumWidth();
    }

    @Deprecated
    public int getWallpaperDesiredMinimumHeight() {
        return getOriginalActivity().getWallpaperDesiredMinimumHeight();
    }

    @Deprecated
    public void clearWallpaper() throws IOException {
        getOriginalActivity().clearWallpaper();
    }

    public void removeStickyBroadcast(Intent intent) {
        getOriginalActivity().removeStickyBroadcast(intent);
    }

    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter) {
        return getOriginalActivity().registerReceiver(receiver, filter);
    }

    public Intent registerReceiver(BroadcastReceiver receiver, IntentFilter filter, String broadcastPermission, Handler scheduler) {
        return getOriginalActivity().registerReceiver(receiver, filter, broadcastPermission, scheduler);
    }

    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        return getOriginalActivity().bindService(service, conn, flags);
    }

    public Object getSystemService(String name) {
        if (!TextUtils.equals(name, "layout_inflater") || VERSION.SDK_INT > 15) {
            return getOriginalActivity().getSystemService(name);
        }
        if (this.mInflater == null) {
            this.mInflater = ((LayoutInflater) super.getSystemService(name)).cloneInContext(this);
        }
        return this.mInflater;
    }

    public int checkPermission(String permission, int pid, int uid) {
        return getOriginalActivity().checkPermission(permission, pid, uid);
    }

    public int checkCallingPermission(String permission) {
        return getOriginalActivity().checkCallingPermission(permission);
    }

    public int checkCallingOrSelfPermission(String permission) {
        return getOriginalActivity().checkCallingOrSelfPermission(permission);
    }

    public void grantUriPermission(String toPackage, Uri uri, int modeFlags) {
        getOriginalActivity().grantUriPermission(toPackage, uri, modeFlags);
    }

    public int checkUriPermission(Uri uri, int pid, int uid, int modeFlags) {
        return getOriginalActivity().checkUriPermission(uri, pid, uid, modeFlags);
    }

    public int checkCallingUriPermission(Uri uri, int modeFlags) {
        return getOriginalActivity().checkCallingUriPermission(uri, modeFlags);
    }

    public int checkCallingOrSelfUriPermission(Uri uri, int modeFlags) {
        return getOriginalActivity().checkCallingOrSelfUriPermission(uri, modeFlags);
    }

    public int checkUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags) {
        return getOriginalActivity().checkUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags);
    }

    public boolean deleteFile(String name) {
        return getOriginalActivity().deleteFile(name);
    }

    public boolean deleteDatabase(String name) {
        return getOriginalActivity().deleteDatabase(name);
    }

    public String[] databaseList() {
        return getOriginalActivity().databaseList();
    }

    public void enforcePermission(String permission, int pid, int uid, String message) {
        getOriginalActivity().enforcePermission(permission, pid, uid, message);
    }

    public void enforceCallingPermission(String permission, String message) {
        getOriginalActivity().enforceCallingPermission(permission, message);
    }

    public void enforceCallingOrSelfPermission(String permission, String message) {
        getOriginalActivity().enforceCallingOrSelfPermission(permission, message);
    }

    public void enforceUriPermission(Uri uri, int pid, int uid, int modeFlags, String message) {
        getOriginalActivity().enforceUriPermission(uri, pid, uid, modeFlags, message);
    }

    public void enforceCallingUriPermission(Uri uri, int modeFlags, String message) {
        getOriginalActivity().enforceCallingUriPermission(uri, modeFlags, message);
    }

    public void enforceCallingOrSelfUriPermission(Uri uri, int modeFlags, String message) {
        getOriginalActivity().enforceCallingOrSelfUriPermission(uri, modeFlags, message);
    }

    public void enforceUriPermission(Uri uri, String readPermission, String writePermission, int pid, int uid, int modeFlags, String message) {
        getOriginalActivity().enforceUriPermission(uri, readPermission, writePermission, pid, uid, modeFlags, message);
    }

    public Context createPackageContext(String packageName, int flags) throws NameNotFoundException {
        return getOriginalActivity().createPackageContext(packageName, flags);
    }

    public void sendBroadcast(Intent intent) {
        getOriginalActivity().sendBroadcast(intent);
    }

    public void sendBroadcast(Intent intent, String receiverPermission) {
        getOriginalActivity().sendBroadcast(intent, receiverPermission);
    }

    public void revokeUriPermission(Uri uri, int modeFlags) {
        getOriginalActivity().revokeUriPermission(uri, modeFlags);
    }

    public void sendOrderedBroadcast(Intent intent, String receiverPermission) {
        getOriginalActivity().sendBroadcast(intent, receiverPermission);
    }

    public void sendOrderedBroadcast(Intent intent, String receiverPermission, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        getOriginalActivity().sendOrderedBroadcast(intent, receiverPermission, resultReceiver, scheduler, initialCode, initialData, initialExtras);
    }

    public void sendStickyBroadcast(Intent intent) {
        getOriginalActivity().sendStickyBroadcast(intent);
    }

    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver resultReceiver, Handler scheduler, int initialCode, String initialData, Bundle initialExtras) {
        getOriginalActivity().sendStickyOrderedBroadcast(intent, resultReceiver, scheduler, initialCode, initialData, initialExtras);
    }

    public void setTheme(int resid) {
        getOriginalActivity().setTheme(resid);
    }

    @Deprecated
    public void setWallpaper(Bitmap bitmap) throws IOException {
        getOriginalActivity().setWallpaper(bitmap);
    }

    @Deprecated
    public void setWallpaper(InputStream data) throws IOException {
        getOriginalActivity().setWallpaper(data);
    }

    public void startActivities(Intent[] intents) {
        getOriginalActivity().startActivities(intents);
    }

    public void startActivity(Intent intent) {
        getOriginalActivity().startActivity(intent);
    }

    public void startIntentSender(IntentSender intent, Intent fillInIntent, int flagsMask, int flagsValues, int extraFlags) throws SendIntentException {
        getOriginalActivity().startIntentSender(intent, fillInIntent, flagsMask, flagsValues, extraFlags);
    }

    public boolean startInstrumentation(ComponentName className, String profileFile, Bundle arguments) {
        return getOriginalActivity().startInstrumentation(className, profileFile, arguments);
    }

    public void unregisterReceiver(BroadcastReceiver receiver) {
        try {
            getOriginalActivity().unregisterReceiver(receiver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ComponentName startService(Intent service) {
        return getOriginalActivity().startService(service);
    }

    public boolean stopService(Intent service) {
        return getOriginalActivity().stopService(service);
    }

    public void unbindService(ServiceConnection conn) {
        try {
            getOriginalActivity().unbindService(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
