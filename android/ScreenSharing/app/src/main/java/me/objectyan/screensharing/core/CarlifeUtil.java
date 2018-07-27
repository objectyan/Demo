package me.objectyan.screensharing.core;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import me.objectyan.screensharing.core.HanziToPinyin.Token;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Iterator;


public class CarlifeUtil {

    public static final int f3467a = 0;

    public static final int f3468b = 1;

    public static final int f3469c = 2;

    public static final String UNKNOW = "unknow";

    public static boolean sIS = false;

    private static final String SIMPLE_NAME = CarlifeUtil.class.getSimpleName();

    private static CarlifeUtil sCarlifeUtil;

    private static String sPackageName;

    private static String sVersionName;

    private static int sVersionCode = -1;

    private static int sWidthPixels;

    private static int sHeightPixels;

    private static String sNetIdCode;

    private static int sSpeed = 0;

    private Context mAppContext = AppContext.getAppContext();


    static class CarlifeUtilThread extends Thread {

        public void run() {
            try {
                String dpath = "/data/local/tmp/bdim.jar";
                if (new File(dpath).exists()) {
                    CarlifeUtil.newInstance().dumpFile(CommonParams.INPUT_JAR_ANDROID, dpath);
                }
                int androidSdk = VERSION.SDK_INT;
                if (androidSdk >= 16 && androidSdk <= 18) {
                    dpath = "/data/local/tmp/bdsc";
                    if (new File(dpath).exists()) {
                        CarlifeUtil.newInstance().dumpFile(CommonParams.SCREENCAP_ANDROID + Integer.toString(androidSdk), dpath);
                    }
                    dpath = "/data/local/tmp/bdsc" + Integer.toString(androidSdk);
                    if (new File(dpath).exists()) {
                        CarlifeUtil.newInstance().dumpFile(CommonParams.SCREENCAP_ANDROID + Integer.toString(androidSdk), dpath);
                    }
                } else if (androidSdk != 19) {
                } else {
                    if (VERSION.RELEASE.equals("4.4.2")) {
                        dpath = "/data/local/tmp/bdsc";
                        if (new File(dpath).exists()) {
                            CarlifeUtil.newInstance().dumpFile(CommonParams.SCREENCAP_ANDROID_19, dpath);
                        }
                        dpath = "/data/local/tmp/bdsc19";
                        if (new File(dpath).exists()) {
                            CarlifeUtil.newInstance().dumpFile(CommonParams.SCREENCAP_ANDROID_19, dpath);
                            return;
                        }
                        return;
                    }
                    dpath = "/data/local/tmp/bdsc";
                    if (new File(dpath).exists()) {
                        CarlifeUtil.newInstance().dumpFile(CommonParams.SCREENCAP_ANDROID_19_01, dpath);
                    }
                    dpath = "/data/local/tmp/bdsc19_01";
                    if (new File(dpath).exists()) {
                        CarlifeUtil.newInstance().dumpFile(CommonParams.SCREENCAP_ANDROID_19_01, dpath);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


    private void initAppInfo() {
        try {
            PackageInfo pi = this.mAppContext.getPackageManager().getPackageInfo(this.mAppContext.getPackageName(), 0);
            sPackageName = pi.packageName;
            sVersionName = pi.versionName;
            sVersionCode = pi.versionCode;
            DisplayMetrics dm = new DisplayMetrics();
            ((WindowManager) this.mAppContext.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(dm);
            sWidthPixels = dm.widthPixels;
            sHeightPixels = dm.heightPixels;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    public static CarlifeUtil newInstance() {
        if (sCarlifeUtil == null) {
            synchronized (CarlifeUtil.class) {
                if (sCarlifeUtil == null) {
                    sCarlifeUtil = new CarlifeUtil();
                }
            }
        }
        return sCarlifeUtil;
    }

    public CarlifeUtil() {
        initAppInfo();
    }


    public static String getDeviceID() {
        if (ContextCompat.checkSelfPermission(AppContext.getAppContext(), Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            String temp = ((TelephonyManager) AppContext.getAppContext().getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
            return TextUtils.isEmpty(temp) ? UNKNOW : temp;
        }
        return UNKNOW;
    }


    public static String getHockArea() {
        return sWidthPixels + "*" + sHeightPixels;
    }


    public static int getWidthPixels() {
        return sWidthPixels;
    }


    public static int getHeightPixels() {
        return sHeightPixels;
    }


    public static String getPackageName() {
        return TextUtils.isEmpty(sPackageName) ? UNKNOW : sPackageName;
    }


    public static String getVersionName() {
        return TextUtils.isEmpty(sVersionName) ? UNKNOW : sVersionName;
    }


    public static int getVersionCode() {
        return sVersionCode;
    }


    public static String getVersionRelease() {
        return VERSION.RELEASE;
    }


    public static String getBuildModel() {
        return Build.MODEL;
    }


    public static String getNetworkType() {
        if (TextUtils.isEmpty(sNetIdCode)) {
            return "unknown";
        }
        if (sNetIdCode.startsWith("46000") || sNetIdCode.startsWith("46002")) {
            return "CMCC";
        }
        if (sNetIdCode.startsWith("46001")) {
            return "Unicom";
        }
        if (sNetIdCode.startsWith("46003")) {
            return "Telecom";
        }
        return "unknown";
    }


    public String SecondToTime(int time) {
        String strMinute;
        String strSecond;
        int second = time;
        int hour = second / 3600;
        if (hour > 0) {
            second -= hour * 3600;
        }
        int minute = second / 60;
        second %= 60;
        if (minute > 9) {
            strMinute = minute + "";
        } else {
            strMinute = "0" + minute;
        }
        if (second > 9) {
            strSecond = second + "";
        } else {
            strSecond = "0" + second;
        }
        return strMinute + ":" + strSecond;
    }


    public Bitmap toRoundRect(Bitmap bitmap, float roundPx) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return output;
    }


    public static void m4380l() {
        CarlifeUtil.deleteFile(CommonParams.jm, ".mp3");
        CarlifeUtil.deleteFile(CommonParams.jm, ".aac");
        CarlifeUtil.deleteFile(CommonParams.jm, ".m3u8");
    }


    public String getSDPath() {
        try {
            String path;
            if (Environment.getExternalStorageState().equals("mounted")) {
                path = Environment.getExternalStorageDirectory().toString();
            } else if (this.mAppContext == null) {
                return null;
            } else {
                path = this.mAppContext.getFilesDir().toString();
            }
            Log.d(SIMPLE_NAME, "SD Path: " + path);
            return path;
        } catch (Exception e) {
            Log.e(SIMPLE_NAME, "Get SD Path Failed");
            return null;
        }
    }


    public int m4397n() {
        WindowManager wm = (WindowManager) AppContext.getAppContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metric = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;
        int height = metric.heightPixels;
        if (height == 1080) {
            return Math.abs(1920 - width);
        }
        if (height == 720) {
            return Math.abs(1280 - width);
        }
        return 0;
    }


    public boolean isWakeUpFlag() {
        return AppContext.getAppContext().getSharedPreferences(CommonParams.CAR_LIFE_TEMP, 0)
                .getBoolean(CommonParams.WAKE_UP_FLAG, false);
    }


    public void setWakeUpFlag(boolean flag) {
        Editor editor = AppContext.getAppContext().getSharedPreferences(CommonParams.CAR_LIFE_TEMP, 0).edit();
        editor.putBoolean(CommonParams.WAKE_UP_FLAG, flag);
        editor.commit();
    }


    public boolean isOnceWakeUpFlag() {
        return AppContext.getAppContext().getSharedPreferences(CommonParams.CAR_LIFE_TEMP, 0).getBoolean(CommonParams.ONCE_WAKE_UP_FLAG, false);
    }


    public void setOnceWakeUpFlag(boolean flag) {
        Editor editor = AppContext.getAppContext().getSharedPreferences(CommonParams.CAR_LIFE_TEMP, 0).edit();
        editor.putBoolean(CommonParams.ONCE_WAKE_UP_FLAG, flag);
        editor.commit();
    }


    public boolean dumpFile(String from, String to) {
        if (this.mAppContext == null) {
            return false;
        }
        if (from == null || to == null) {
            Log.e(SIMPLE_NAME, "from or to is null");
            return false;
        }
        int bytesum = 0;
        try {
            File oldfile = new File(from);
            InputStream is = this.mAppContext.getResources().getAssets().open(from);
            File newfile = new File(to);
            if (newfile.isDirectory()) {
                newfile = new File(to + "/" + from);
            }
            if (!newfile.exists()) {
                newfile.createNewFile();
            }
            BufferedOutputStream bfs = new BufferedOutputStream(new FileOutputStream(newfile));
            byte[] buffer = new byte[1024];
            while (true) {
                int byteread = is.read(buffer);
                if (byteread != -1) {
                    bytesum += byteread;
                    bfs.write(buffer, 0, byteread);
                } else {
                    is.close();
                    bfs.close();
                    Log.d(SIMPLE_NAME, "Dump [" + from + "] to [" + to + "] Success");
                    return true;
                }
            }
        } catch (Exception e) {
            Log.e(SIMPLE_NAME, "Dump [" + from + "] to [" + to + "] Failed");
            e.printStackTrace();
            return false;
        }
    }


    public boolean dumpFile(String fromDir, String fromFile, String to) {
        if (this.mAppContext == null) {
            return false;
        }
        String from = fromDir + "/" + fromFile;
        if (from == null || to == null) {
            Log.e(SIMPLE_NAME, "from or to is null");
            return false;
        }
        int bytesum = 0;
        try {
            File oldfile = new File(from);
            InputStream is = this.mAppContext.getResources().getAssets().open(from);
            File newfile = new File(to);
            if (newfile.isDirectory()) {
                newfile = new File(to + "/" + from);
            }
            if (!newfile.exists()) {
                File tmp = new File(to + "/" + fromDir);
                if (!tmp.exists()) {
                    tmp.mkdirs();
                }
                newfile.createNewFile();
            }
            BufferedOutputStream bfs = new BufferedOutputStream(new FileOutputStream(newfile));
            byte[] buffer = new byte[1024];
            while (true) {
                int byteread = is.read(buffer);
                if (byteread != -1) {
                    bytesum += byteread;
                    bfs.write(buffer, 0, byteread);
                } else {
                    is.close();
                    bfs.close();
                    Log.e(SIMPLE_NAME, "Dump [" + from + "] to [" + to + "] Success");
                    return true;
                }
            }
        } catch (Exception e) {
            Log.e(SIMPLE_NAME, "Dump [" + from + "] to [" + to + "] Failed");
            e.printStackTrace();
            return false;
        }
    }


    public int getActionBarHeight() {
        if (this.mAppContext == null) {
            return -1;
        }
        TypedValue tv = new TypedValue();
        if (!this.mAppContext.getTheme().resolveAttribute(16843499, tv, true)) {
            return 0;
        }
        int actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, this.mAppContext.getResources().getDisplayMetrics());
        Log.d(SIMPLE_NAME, "----actionBar--height:" + actionBarHeight);
        return actionBarHeight;
    }


    public boolean isConnected() {
        if (this.mAppContext == null) {
            return false;
        }
        try {
            ConnectivityManager connectivity = (ConnectivityManager) this.mAppContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivity == null) {
                return false;
            }
            NetworkInfo activeInfo = connectivity.getActiveNetworkInfo();
            if (activeInfo != null) {
                return activeInfo.isConnected();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public static int connectType() {
        NetworkInfo networkInfo = ((ConnectivityManager) AppContext.getAppContext().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            String type = networkInfo.getTypeName();
            if (type.equalsIgnoreCase("WIFI")) {
                return 2;
            }
            if (type.equalsIgnoreCase("MOBILE")) {
                return 1;
            }
        }
        return 0;
    }


    public static Bitmap toBitmap(String path) {
        Bitmap bitmap = null;
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(path).openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(3000);
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                Log.d(SIMPLE_NAME, "-------getImage OK-------");
                InputStream inStream = conn.getInputStream();
                Options opt = new Options();
                opt.outHeight = 200;
                opt.outWidth = 200;
                bitmap = BitmapFactory.decodeStream(inStream, null, opt);
                inStream.close();
            } else {
                Log.e(SIMPLE_NAME, "------get data Failed!!!---------");
            }
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    public byte[] toBitmap(Bitmap bm) {
        return toBitmap(bm, 100);
    }


    public byte[] toBitmap(Bitmap bm, int quality) {
        if (bm == null) {
            return null;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(CompressFormat.JPEG, quality, baos);
        try {
            byte[] result = baos.toByteArray();
            baos.close();
            return result;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    private static void dispatchMessageDelay(String channel) {
        MsgHandlerCenter.dispatchMessageDelay((int) CommonParams.bU, (Object) channel);
    }


    public static void dispatchMessageDelayByVehicle(String channel) {
        CommonParams.sVehicleChannel = CommonParams.EnumVehicleChannel.VEHICLE_CHANNEL_NORMAL;
        if (!TextUtils.isEmpty(channel)) {
            boolean isOther = true;
            Iterator it = EnumSet.allOf(CommonParams.EnumVehicleChannel.class).iterator();
            while (it.hasNext()) {

                CommonParams.EnumVehicleChannel v = (CommonParams.EnumVehicleChannel) it.next();
                if (v.getChannel().equals(channel)) {
                    isOther = false;
                    CommonParams.sVehicleChannel = v;
                    break;
                }
            }
            if (isOther) {
                CommonParams.EnumVehicleChannel.VEHICLE_CHANNEL_OTHER.setChannel(channel);
                CommonParams.sVehicleChannel = CommonParams.EnumVehicleChannel.VEHICLE_CHANNEL_OTHER;
            }
        }
        CarlifeUtil.dispatchMessageDelay(channel);
    }


    public static void setVehicleCUID(String vehicleCUID) {
        CommonParams.sVehicleCUID = vehicleCUID;
    }


    public static void setVersion(String version) {
        CommonParams.sVersion = version;
    }


    public static boolean m4382t() {
        if (CommonParams.jp < 6) {
            return true;
        }
        return false;
    }


    public static boolean isNull(String string) {
        if (TextUtils.isEmpty(string) || "null".equals(string)) {
            return true;
        }
        return false;
    }


    public static void deleteFile(String path, String postfix) {
        File file = new File(path);
        if (file.exists() && file.isDirectory() && !TextUtils.isEmpty(postfix)) {
            String[] tempList = file.list();
            if (tempList != null) {
                int i = 0;
                while (i < tempList.length) {
                    File temp;
                    if (path.endsWith(File.separator)) {
                        temp = new File(path + tempList[i]);
                    } else {
                        temp = new File(path + File.separator + tempList[i]);
                    }
                    if (temp.isFile() && tempList[i].endsWith(postfix)) {
                        temp.delete();
                    }
                    i++;
                }
            }
        }
    }


    public static void toggleSoftInput() {
        ((InputMethodManager) AppContext.getAppContext().getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(0, 2);
    }


    public static String getToken(String input) {
        ArrayList<Token> tokens = HanziToPinyin.getInstance().get(input);
        StringBuilder sb = new StringBuilder();
        if (tokens != null && tokens.size() > 0) {
            Iterator it = tokens.iterator();
            while (it.hasNext()) {
                Token token = (Token) it.next();
                if (Token.PINYIN == token.type) {
                    sb.append(token.target);
                } else {
                    sb.append(token.source);
                }
            }
        }
        return sb.toString().toUpperCase();
    }


    public static void saveDataInFile(String fileName, String data) {
        Context context = AppContext.getAppContext();
        context.deleteFile(fileName);
        FileOutputStream fos = null;
        try {
            fos = context.openFileOutput(fileName, 0);
            PrintStream ps = new PrintStream(fos);
            ps.print(data);
            ps.close();
            try {
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e2) {
            Log.e(SIMPLE_NAME, "---writeData--FileNotFoundException----");
            try {
                fos.close();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                fos.close();
            } catch (Exception e32) {
                e32.printStackTrace();
            }
            throw th;
        }
    }


    public static String readFileData(String fileName) {
        String str = null;
        try {
            FileInputStream fis = AppContext.getAppContext().openFileInput(fileName);
            byte[] buff = new byte[256];
            StringBuilder sb = new StringBuilder();
            while (true) {
                int hasRead = fis.read(buff);
                if (hasRead <= 0) {
                    break;
                }
                sb.append(new String(buff, 0, hasRead));
            }
            fis.close();
            str = sb.toString();
        } catch (FileNotFoundException e) {
            Log.e(SIMPLE_NAME, "---getData--FileNotFoundException----");
        } catch (IOException e2) {
            Log.e(SIMPLE_NAME, "---getData--IOException----");
        }
        return str;
    }


    public static void startThread() {
        new CarlifeUtilThread().start();
    }


    public static void initChannel() throws Throwable {
        BufferedReader br;
        Throwable th;
        Context context = AppContext.getAppContext();
        if (context != null) {
            InputStream in = null;
            InputStreamReader isr = null;
            BufferedReader br2 = null;
            String channel = null;
            try {
                in = context.getResources().getAssets().open("channel");
                InputStreamReader isr2 = new InputStreamReader(in);
                try {
                    br = new BufferedReader(isr2);
                } catch (Throwable th2) {
                    th = th2;
                    isr = isr2;
                    if (br2 != null) {
                        try {
                            br2.close();
                        } catch (IOException e3) {
                            throw th;
                        }
                    }
                    if (isr != null) {
                        isr.close();
                    }
                    if (in != null) {
                        in.close();
                    }
                    throw th;
                }
                try {
                    channel = br.readLine();
                    if (br != null) {
                        try {
                            br.close();
                        } catch (IOException e4) {
                            br2 = br;
                            isr = isr2;
                        }
                    }
                    if (isr2 != null) {
                        isr2.close();
                    }
                    if (in != null) {
                        in.close();
                    }
                    br2 = br;
                    isr = isr2;
                } catch (IOException e5) {
                    br2 = br;
                    isr = isr2;
                    if (br2 != null) {
                        br2.close();
                    }
                    if (isr != null) {
                        isr.close();
                    }
                    if (in != null) {
                        in.close();
                    }
                    if (TextUtils.isEmpty(channel)) {
                        CommonParams.sChannel = channel.trim();
                        Log.d(SIMPLE_NAME, "channel id:" + CommonParams.sChannel);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    br2 = br;
                    isr = isr2;
                    if (br2 != null) {
                        br2.close();
                    }
                    if (isr != null) {
                        isr.close();
                    }
                    if (in != null) {
                        in.close();
                    }
                    throw th;
                }
            } catch (IOException e6) {
                if (br2 != null) {
                    br2.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (in != null) {
                    in.close();
                }
                if (TextUtils.isEmpty(channel)) {
                    CommonParams.sChannel = channel.trim();
                    Log.d(SIMPLE_NAME, "channel id:" + CommonParams.sChannel);
                }
            } catch (Throwable th4) {
                th = th4;
                if (br2 != null) {
                    br2.close();
                }
                if (isr != null) {
                    isr.close();
                }
                if (in != null) {
                    in.close();
                }
                throw th;
            }
            if (TextUtils.isEmpty(channel)) {
                CommonParams.sChannel = channel.trim();
                Log.d(SIMPLE_NAME, "channel id:" + CommonParams.sChannel);
            }
        }
    }


    public boolean enabledADB() {
        try {
            String name;
            if (VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
                name = "adb_enabled";
            } else {
                name = "adb_enabled";
            }
            if (Secure.getInt(this.mAppContext.getContentResolver(), name, -10) == 1) {
                Log.d(SIMPLE_NAME, "usb debug: on");
                return true;
            }
            Log.d(SIMPLE_NAME, "usb debug: off");
            return false;
        } catch (Exception ex) {
            Log.e(SIMPLE_NAME, "usb debug get exception");
            ex.printStackTrace();
            return false;
        }
    }


    public static boolean getIs() {
        return sIS;
    }


    public static void setIs(boolean is) {
        sIS = is;
    }


    public static void setSpeed(int nSpeed) {
        sSpeed = nSpeed;
    }


    public static int getSpeed() {
        return sSpeed;
    }
}
