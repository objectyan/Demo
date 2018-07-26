package com.baidu.baidunavis.wrapper;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.Intent.ShortcutIconResource;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.navisdk.jni.nativeif.JNISearchConst;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.UUID;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.util.EncodingUtils;
import org.apache.http.util.EntityUtils;

public class Utils {
    private static final String TAG = "Common";
    public static final int TITLE_HEIGHT = 25;
    public static String mUUID = "";

    public static final String getIMEI(Context context) {
        return ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
    }

    public static boolean writePrivateFile(Context context, String filename, String content) {
        return writePrivateFile(context, filename, content, "UTF-8");
    }

    public static boolean writePrivateFile(Context context, String filename, String content, String charset) {
        if (content == null) {
            return false;
        }
        try {
            FileOutputStream fout = context.openFileOutput(filename, 0);
            fout.write(content.getBytes("UTF-8"));
            fout.close();
            return true;
        } catch (Exception e) {
            LogUtil.m3004e("", e.toString());
            return false;
        }
    }

    public static String readPrivateFileData(Context context, String fileName) {
        return readPrivateFileData(context, fileName, "UTF-8");
    }

    public static String readPrivateFileData(Context context, String fileName, String charset) {
        String content = "";
        try {
            FileInputStream fin = context.openFileInput(fileName);
            byte[] buffer = new byte[fin.available()];
            fin.read(buffer);
            content = EncodingUtils.getString(buffer, charset);
            fin.close();
        } catch (IOException e) {
            LogUtil.m3004e("", e.toString());
        }
        LogUtil.m3004e("Common", "readPrivateFileData: " + content);
        return content;
    }

    public static boolean writeSDFile(String filePath, String content) {
        return writeSDFile(filePath, content, "UTF-8");
    }

    public static boolean writeSDFile(String filePath, String content, String charset) {
        if (!Environment.getExternalStorageState().equals("mounted") || content == null) {
            return false;
        }
        try {
            File file = new File(filePath);
            if (file.isDirectory()) {
                deleteDir(file);
            }
            FileOutputStream outs = new FileOutputStream(file);
            outs.write(content.getBytes(charset));
            outs.close();
            return true;
        } catch (IOException e) {
            LogUtil.m3004e("", e.toString());
            return false;
        }
    }

    public static String readSDFileData(String filePath) {
        return readSDFileData(filePath, "UTF-8");
    }

    public static String readSDFileData(String filePath, String charset) {
        String str = "";
        File file = new File(filePath);
        if (!Environment.getExternalStorageState().equals("mounted") || !file.exists() || file.isDirectory()) {
            return str;
        }
        try {
            FileInputStream fin = new FileInputStream(file);
            byte[] buffer = new byte[fin.available()];
            fin.read(buffer);
            str = EncodingUtils.getString(buffer, charset);
            fin.close();
        } catch (IOException e) {
            LogUtil.m3004e("", e.toString());
        }
        LogUtil.m3004e("Common", "sdFilePath: " + filePath);
        LogUtil.m3004e("Common", "readSDFileData: " + str);
        return str;
    }

    public static boolean deleteDir(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    return deleteDir(file);
                }
                file.delete();
            }
        }
        dir.delete();
        return true;
    }

    public static String md5Encode(String str) {
        StringBuffer buf = new StringBuffer();
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes("UTF-8"));
            byte[] bytes = md5.digest();
            for (byte b : bytes) {
                String s = Integer.toHexString(b & 255);
                if (s.length() == 1) {
                    buf.append("0");
                }
                buf.append(s);
            }
        } catch (Exception e) {
        }
        return buf.toString();
    }

    public static boolean isVoid(String str) {
        return str == null || str.length() == 0;
    }

    public static String toGbk(String string) {
        String gbk = null;
        try {
            gbk = URLEncoder.encode(string, "GBK");
        } catch (UnsupportedEncodingException e) {
        } catch (Exception e2) {
        }
        return gbk;
    }

    public static String utf8Togb2312(String str) {
        StringBuffer sb = new StringBuffer();
        int i = 0;
        while (i < str.length()) {
            char c = str.charAt(i);
            switch (c) {
                case '%':
                    try {
                        sb.append((char) Integer.parseInt(str.substring(i + 1, i + 3), 16));
                        i += 2;
                        break;
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException();
                    }
                case '+':
                    sb.append(' ');
                    break;
                default:
                    sb.append(c);
                    break;
            }
            i++;
        }
        try {
            return new String(sb.toString().getBytes("8859_1"), "UTF-8");
        } catch (Exception e2) {
            LogUtil.m3004e("", e2.toString());
            return null;
        }
    }

    public static String getUniqueCode(Context context) {
        if (context == null) {
            return null;
        }
        String mUniqueCode = getIMEI(context) + JNISearchConst.LAYER_ID_DIVIDER + ((WifiManager) context.getSystemService(C1981b.f6365e)).getConnectionInfo().getMacAddress();
        LogUtil.m3004e("Common", "mUniqueCode: " + mUniqueCode);
        return mUniqueCode;
    }

    public static boolean isWifi(Context context) {
        boolean z = true;
        if (context == null) {
            return false;
        }
        NetworkInfo activeNetInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetInfo == null || activeNetInfo.getType() != 1) {
            z = false;
        }
        return z;
    }

    public static Proxy getDefaultProxy() {
        if (android.net.Proxy.getDefaultHost() != null) {
            return new Proxy(Type.HTTP, new InetSocketAddress(android.net.Proxy.getDefaultHost(), android.net.Proxy.getDefaultPort()));
        }
        return null;
    }

    public static String getSystemVersion(Context context) {
        return VERSION.RELEASE;
    }

    public static String getModel(Context context) {
        return Build.MODEL != null ? Build.MODEL.replace(" ", "") : "unknown";
    }

    public static void setHasTitle(Activity activity, boolean hasTitle) {
        if (hasTitle) {
            activity.requestWindowFeature(7);
        } else {
            activity.requestWindowFeature(1);
        }
    }

    public static boolean getIsFullScreen(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) != 0;
    }

    public static void setFullScreen(Activity activity, boolean isFullScreen) {
        if (isFullScreen) {
            LayoutParams attrs = activity.getWindow().getAttributes();
            attrs.flags |= 1024;
            activity.getWindow().setAttributes(attrs);
            return;
        }
        attrs = activity.getWindow().getAttributes();
        attrs.flags &= -1025;
        activity.getWindow().setAttributes(attrs);
    }

    public static void expendNotification(Activity activity) throws Exception {
        Object service = activity.getSystemService("statusbar");
        if (service != null) {
            service.getClass().getMethod("expand", new Class[0]).invoke(service, new Object[0]);
        }
    }

    public static void setScreenAutoLock(Activity activity, boolean isLock) {
        if (activity != null) {
            Window window = activity.getWindow();
            if (isLock) {
                window.setFlags(128, 128);
            } else {
                window.setFlags(0, 128);
            }
        }
    }

    public static void blurWindow(Activity activity, boolean isBlur) {
        Window window = activity.getWindow();
        if (isBlur) {
            window.setFlags(4, 4);
        } else {
            window.setFlags(0, 4);
        }
    }

    public static boolean getScreenAutoLock(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 128) > 0;
    }

    public static void setRequestedOrientation(Activity activity, int orietation) {
        if (activity != null) {
            activity.setRequestedOrientation(orietation);
        }
    }

    public static int getRequestedOrientation(Activity activity) {
        return activity.getRequestedOrientation();
    }

    public static void setScreenBrightness(Activity activity, float brightness) {
        if (activity != null) {
            Window window = activity.getWindow();
            window.getAttributes().screenBrightness = brightness;
            window.setAttributes(window.getAttributes());
        }
    }

    public static float getScreenBrightness(Activity activity) {
        if (activity == null) {
            return 1.0f;
        }
        return activity.getWindow().getAttributes().screenBrightness;
    }

    public static float getDensity(Activity activity) {
        DisplayMetrics metrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
        return metrics.density;
    }

    public static boolean isMediaMounted() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static void setLayoutFlag(Activity activity, int flag) {
        activity.getWindow().clearFlags(512);
        activity.getWindow().addFlags(flag);
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (NameNotFoundException e) {
            return "";
        }
    }

    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode;
        } catch (NameNotFoundException e) {
            return 1;
        }
    }

    public static void openAppInMarket(Context context) {
        if (context != null) {
            boolean success = true;
            String packageName = context.getPackageName();
            String marketAppUrl = "market://details?id=" + packageName;
            String marketHttpUrl = "http://market.android.com/details?id=" + packageName;
            try {
                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(marketAppUrl)));
            } catch (Exception e) {
                success = false;
            }
            if (!success) {
                try {
                    context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(marketHttpUrl)));
                } catch (Exception e2) {
                }
            }
        }
    }

    public static void showInputMethod(Activity activity) {
        if (activity != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            if (activity.getCurrentFocus() != null) {
                inputMethodManager.showSoftInput(activity.getCurrentFocus(), 0);
            }
        }
    }

    public static void hideInputMethod(Activity activity) {
        if (activity != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
            if (activity.getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
            }
        }
    }

    public static boolean isShowInputMethod(Activity activity) {
        if (activity == null) {
            return false;
        }
        return ((InputMethodManager) activity.getSystemService("input_method")).isActive();
    }

    public static boolean startWap(String url, Context context) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void copyFile(File fromFile, File toFile, boolean rewrite) {
        if (fromFile.exists() && fromFile.isFile() && fromFile.canRead()) {
            if (!toFile.getParentFile().exists()) {
                toFile.getParentFile().mkdirs();
            }
            if (toFile.exists() && rewrite) {
                toFile.delete();
            }
            try {
                FileInputStream fosfrom = new FileInputStream(fromFile);
                FileOutputStream fosto = new FileOutputStream(toFile);
                byte[] bt = new byte[1024];
                while (true) {
                    int c = fosfrom.read(bt);
                    if (c > 0) {
                        fosto.write(bt, 0, c);
                    } else {
                        fosfrom.close();
                        fosto.close();
                        return;
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public static void copyStream(InputStream is, OutputStream os) {
        try {
            byte[] bytes = new byte[1024];
            while (true) {
                int count = is.read(bytes, 0, 1024);
                if (count != -1) {
                    os.write(bytes, 0, count);
                } else {
                    return;
                }
            }
        } catch (Exception e) {
        }
    }

    public static String getContent(HttpResponse response) throws IOException {
        if (response == null) {
            return null;
        }
        boolean isGzip = false;
        Header[] headers = response.getHeaders("Content-Encoding");
        if (headers != null && headers.length > 0) {
            for (Header header : headers) {
                if (header.getValue().toLowerCase().indexOf("gzip") > -1) {
                    isGzip = true;
                    break;
                }
            }
            if (isGzip) {
                InputStream is = response.getEntity().getContent();
                GZIPInputStream gis = new GZIPInputStream(is);
                BufferedReader br = new BufferedReader(new InputStreamReader(gis, "UTF-8"));
                StringBuffer sb = new StringBuffer();
                while (true) {
                    String line = br.readLine();
                    if (line != null) {
                        sb.append(line);
                    } else {
                        gis.close();
                        is.close();
                        return sb.toString();
                    }
                }
            }
        }
        return EntityUtils.toString(response.getEntity());
    }

    public static void disableOverScroll(View listView) {
    }

    public static void createShortcut(Activity context, int icon, String appname) {
        if (context != null && !isVoid(appname)) {
            try {
                Intent shortcut = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
                shortcut.putExtra("android.intent.extra.shortcut.NAME", appname);
                shortcut.putExtra("duplicate", false);
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.addCategory("android.intent.category.LAUNCHER");
                intent2.setComponent(new ComponentName(context.getPackageName(), context.getClass().getName()));
                shortcut.putExtra("android.intent.extra.shortcut.INTENT", intent2);
                shortcut.putExtra("android.intent.extra.shortcut.ICON_RESOURCE", ShortcutIconResource.fromContext(context, icon));
                context.sendBroadcast(shortcut);
            } catch (Exception e) {
            }
        }
    }

    public static int getCpuMaxFreq() {
        String result = "";
        int maxCpuFreq = 0;
        try {
            InputStream in = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).start().getInputStream();
            byte[] re = new byte[24];
            while (in.read(re) != -1) {
                result = result + new String(re);
            }
            in.close();
        } catch (IOException ex) {
            LogUtil.m3004e("", ex.toString());
            result = "1008000";
        }
        String strMaxFreq = result.trim();
        if (!(strMaxFreq == null || TextUtils.isEmpty(strMaxFreq))) {
            try {
                maxCpuFreq = Integer.valueOf(strMaxFreq).intValue();
            } catch (Exception e) {
            }
        }
        return maxCpuFreq;
    }

    public static int getTotalMemory() {
        try {
            FileReader localFileReader = new FileReader("/proc/meminfo");
            BufferedReader localBufferedReader = new BufferedReader(localFileReader, 8192);
            String str2 = localBufferedReader.readLine();
            String[] arrayOfString = str2.split("\\s+");
            for (String num : arrayOfString) {
                LogUtil.m3004e(str2, num + "\t");
            }
            int initialMemory = Integer.valueOf(arrayOfString[1]).intValue();
            localBufferedReader.close();
            localFileReader.close();
            return initialMemory;
        } catch (IOException e) {
            return 0;
        }
    }

    public static boolean isFileExist(String path) {
        return new File(path).exists();
    }

    public static String getChangeableUUID() {
        return UUID.randomUUID().toString();
    }
}
