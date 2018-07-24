package com.baidu.carlife.core;

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
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import com.baidu.carlife.core.CommonParams;
import com.baidu.carlife.core.HanziToPinyin.C1254a;
import com.baidu.mobstat.Config;

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

/* compiled from: CarlifeUtil */
/* renamed from: com.baidu.carlife.core.e */
public class CarlifeUtil implements KeepClass {
    /* renamed from: a */
    public static final int f3467a = 0;
    /* renamed from: b */
    public static final int f3468b = 1;
    /* renamed from: c */
    public static final int f3469c = 2;
    /* renamed from: d */
    public static final String f3470d = "unknow";
    /* renamed from: e */
    public static boolean f3471e = false;
    /* renamed from: f */
    private static final String f3472f = CarlifeUtil.class.getSimpleName();
    /* renamed from: g */
    private static CarlifeUtil f3473g;
    /* renamed from: h */
    private static String f3474h;
    /* renamed from: i */
    private static String f3475i;
    /* renamed from: j */
    private static int f3476j = -1;
    /* renamed from: k */
    private static int f3477k;
    /* renamed from: l */
    private static int f3478l;
    /* renamed from: m */
    private static String f3479m;
    /* renamed from: n */
    private static int f3480n = 0;
    /* renamed from: o */
    private Context f3481o = AppContext.m3876a();

    /* compiled from: CarlifeUtil */
    /* renamed from: com.baidu.carlife.core.e$1 */
    static class C12501 extends Thread {
        C12501() {
        }

        public void run() {
            try {
                String dpath = "/data/local/tmp/bdim.jar";
                if (new File(dpath).exists()) {
                    CarlifeUtil.m4358a().m4391a(CommonParams.hZ, dpath);
                }
                int androidSdk = VERSION.SDK_INT;
                if (androidSdk >= 16 && androidSdk <= 18) {
                    dpath = "/data/local/tmp/bdsc";
                    if (new File(dpath).exists()) {
                        CarlifeUtil.m4358a().m4391a(CommonParams.hS + Integer.toString(androidSdk), dpath);
                    }
                    dpath = "/data/local/tmp/bdsc" + Integer.toString(androidSdk);
                    if (new File(dpath).exists()) {
                        CarlifeUtil.m4358a().m4391a(CommonParams.hS + Integer.toString(androidSdk), dpath);
                    }
                } else if (androidSdk != 19) {
                } else {
                    if (VERSION.RELEASE.equals("4.4.2")) {
                        dpath = "/data/local/tmp/bdsc";
                        if (new File(dpath).exists()) {
                            CarlifeUtil.m4358a().m4391a(CommonParams.hX, dpath);
                        }
                        dpath = "/data/local/tmp/bdsc19";
                        if (new File(dpath).exists()) {
                            CarlifeUtil.m4358a().m4391a(CommonParams.hX, dpath);
                            return;
                        }
                        return;
                    }
                    dpath = "/data/local/tmp/bdsc";
                    if (new File(dpath).exists()) {
                        CarlifeUtil.m4358a().m4391a(CommonParams.hY, dpath);
                    }
                    dpath = "/data/local/tmp/bdsc19_01";
                    if (new File(dpath).exists()) {
                        CarlifeUtil.m4358a().m4391a(CommonParams.hY, dpath);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    /* renamed from: A */
    private void m4356A() {
        try {
            PackageInfo pi = this.f3481o.getPackageManager().getPackageInfo(this.f3481o.getPackageName(), 0);
            f3474h = pi.packageName;
            f3475i = pi.versionName;
            f3476j = pi.versionCode;
            DisplayMetrics dm = new DisplayMetrics();
            ((WindowManager) this.f3481o.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(dm);
            f3477k = dm.widthPixels;
            f3478l = dm.heightPixels;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /* renamed from: a */
    public static CarlifeUtil m4358a() {
        if (f3473g == null) {
            synchronized (CarlifeUtil.class) {
                if (f3473g == null) {
                    f3473g = new CarlifeUtil();
                }
            }
        }
        return f3473g;
    }

    public CarlifeUtil() {
        m4356A();
    }

    /* renamed from: b */
    public static String m4359b() {
        if (ActivityCompat.checkSelfPermission(AppContext.m3876a(), Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            String temp = ((TelephonyManager) AppContext.m3876a().getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
            return TextUtils.isEmpty(temp) ? "unknow" : temp;
        }
        return "unknow";
    }

    /* renamed from: c */
    public static String m4363c() {
        return f3477k + "*" + f3478l;
    }

    /* renamed from: d */
    public static int m4367d() {
        return f3477k;
    }

    /* renamed from: e */
    public static int m4369e() {
        return f3478l;
    }

    /* renamed from: f */
    public static String m4371f() {
        return TextUtils.isEmpty(f3474h) ? "unknow" : f3474h;
    }

    /* renamed from: g */
    public static String m4373g() {
        return TextUtils.isEmpty(f3475i) ? "unknow" : f3475i;
    }

    /* renamed from: h */
    public static int m4375h() {
        return f3476j;
    }

    /* renamed from: i */
    public static String m4377i() {
        return VERSION.RELEASE;
    }

    /* renamed from: j */
    public static String m4378j() {
        return Build.MODEL;
    }

    /* renamed from: k */
    public static String m4379k() {
        if (TextUtils.isEmpty(f3479m)) {
            return "unknown";
        }
        if (f3479m.startsWith("46000") || f3479m.startsWith("46002")) {
            return "CMCC";
        }
        if (f3479m.startsWith("46001")) {
            return "Unicom";
        }
        if (f3479m.startsWith("46003")) {
            return "Telecom";
        }
        return "unknown";
    }

    /* renamed from: a */
    public String m4389a(int time) {
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
        return strMinute + Config.TRACE_TODAY_VISIT_SPLIT + strSecond;
    }

    /* renamed from: a */
    public Bitmap m4388a(Bitmap bitmap, float roundPx) {
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

    /* renamed from: l */
    public static void m4380l() {
        CarlifeUtil.m4362b(CommonParams.jm, ".mp3");
        CarlifeUtil.m4362b(CommonParams.jm, ".aac");
        CarlifeUtil.m4362b(CommonParams.jm, ".m3u8");
    }

    /* renamed from: m */
    public String m4396m() {
        try {
            String path;
            if (Environment.getExternalStorageState().equals("mounted")) {
                path = Environment.getExternalStorageDirectory().toString();
            } else if (this.f3481o == null) {
                return null;
            } else {
                path = this.f3481o.getFilesDir().toString();
            }
            LogUtil.d(f3472f, "SD Path: " + path);
            return path;
        } catch (Exception e) {
            LogUtil.m4445e(f3472f, "Get SD Path Failed");
            return null;
        }
    }

    /* renamed from: n */
    public int m4397n() {
        WindowManager wm = (WindowManager) AppContext.m3876a().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metric = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metric);
        int width = metric.widthPixels;
        int height = metric.heightPixels;
        if (height == 1080) {
            return Math.abs(1920 - width);
        }
        if (height == CommonParams.eK) {
            return Math.abs(1280 - width);
        }
        return 0;
    }

    /* renamed from: o */
    public boolean m4398o() {
        return AppContext.m3876a().getSharedPreferences(CommonParams.ia, 0).getBoolean(CommonParams.ib, false);
    }

    /* renamed from: a */
    public void m4390a(boolean flag) {
        Editor editor = AppContext.m3876a().getSharedPreferences(CommonParams.ia, 0).edit();
        editor.putBoolean(CommonParams.ib, flag);
        editor.commit();
    }

    /* renamed from: p */
    public boolean m4399p() {
        return AppContext.m3876a().getSharedPreferences(CommonParams.ia, 0).getBoolean(CommonParams.id, false);
    }

    /* renamed from: b */
    public void m4395b(boolean flag) {
        Editor editor = AppContext.m3876a().getSharedPreferences(CommonParams.ia, 0).edit();
        editor.putBoolean(CommonParams.id, flag);
        editor.commit();
    }

    /* renamed from: a */
    public boolean m4391a(String from, String to) {
        if (this.f3481o == null) {
            return false;
        }
        if (from == null || to == null) {
            LogUtil.m4445e(f3472f, "from or to is null");
            return false;
        }
        int bytesum = 0;
        try {
            File oldfile = new File(from);
            InputStream is = this.f3481o.getResources().getAssets().open(from);
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
                    LogUtil.d(f3472f, "Dump [" + from + "] to [" + to + "] Success");
                    return true;
                }
            }
        } catch (Exception e) {
            LogUtil.m4445e(f3472f, "Dump [" + from + "] to [" + to + "] Failed");
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    public boolean m4392a(String fromDir, String fromFile, String to) {
        if (this.f3481o == null) {
            return false;
        }
        String from = fromDir + "/" + fromFile;
        if (from == null || to == null) {
            LogUtil.m4445e(f3472f, "from or to is null");
            return false;
        }
        int bytesum = 0;
        try {
            File oldfile = new File(from);
            InputStream is = this.f3481o.getResources().getAssets().open(from);
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
                    LogUtil.m4445e(f3472f, "Dump [" + from + "] to [" + to + "] Success");
                    return true;
                }
            }
        } catch (Exception e) {
            LogUtil.m4445e(f3472f, "Dump [" + from + "] to [" + to + "] Failed");
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: q */
    public int m4400q() {
        if (this.f3481o == null) {
            return -1;
        }
        TypedValue tv = new TypedValue();
        if (!this.f3481o.getTheme().resolveAttribute(16843499, tv, true)) {
            return 0;
        }
        int actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, this.f3481o.getResources().getDisplayMetrics());
        LogUtil.d("ouyang", "----actionBar--height:" + actionBarHeight);
        return actionBarHeight;
    }

    /* renamed from: r */
    public boolean m4401r() {
        if (this.f3481o == null) {
            return false;
        }
        try {
            ConnectivityManager connectivity = (ConnectivityManager) this.f3481o.getSystemService(Context.CONNECTIVITY_SERVICE);
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

    /* renamed from: s */
    public static int m4381s() {
        NetworkInfo networkInfo = ((ConnectivityManager) AppContext.m3876a().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
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

    /* renamed from: a */
    public static Bitmap m4357a(String path) {
        Bitmap bitmap = null;
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(path).openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(3000);
            conn.setRequestMethod("GET");
            if (conn.getResponseCode() == 200) {
                LogUtil.d(f3472f, "-------getImage OK-------");
                InputStream inStream = conn.getInputStream();
                Options opt = new Options();
                opt.outHeight = 200;
                opt.outWidth = 200;
                bitmap = BitmapFactory.decodeStream(inStream, null, opt);
                inStream.close();
            } else {
                LogUtil.m4445e(f3472f, "------get data Failed!!!---------");
            }
            return bitmap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public byte[] m4393a(Bitmap bm) {
        return m4394a(bm, 100);
    }

    /* renamed from: a */
    public byte[] m4394a(Bitmap bm, int quality) {
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

    /* renamed from: h */
    private static void m4376h(String channel) {
        MsgHandlerCenter.m4459a((int) CommonParams.bU, (Object) channel);
    }

    /* renamed from: b */
    public static void m4361b(String channel) {
//        CommonParams.sVehicleChannel = CommonParams.VEHICLE_CHANNEL_NORMAL;
//        if (!TextUtils.isEmpty(channel)) {
//            boolean isOther = true;
//            Iterator it = EnumSet.allOf(EnumVehicleChannel.class).iterator();
//            while (it.hasNext()) {
//                EnumVehicleChannel v = (EnumVehicleChannel) it.next();
//                if (v.getChannel().equals(channel)) {
//                    isOther = false;
//                    CommonParams.sVehicleChannel = v;
//                    break;
//                }
//            }
//            if (isOther) {
//                EnumVehicleChannel.VEHICLE_CHANNEL_OTHER.setChannel(channel);
//                CommonParams.sVehicleChannel = EnumVehicleChannel.VEHICLE_CHANNEL_OTHER;
//            }
//        }
//        CarlifeUtil.m4376h(channel);
    }

    /* renamed from: c */
    public static void m4364c(String vehicleCUID) {
        CommonParams.jy = vehicleCUID;
    }

    /* renamed from: d */
    public static void m4368d(String version) {
        CommonParams.jz = version;
    }

    /* renamed from: t */
    public static boolean m4382t() {
        if (CommonParams.jp < 6) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    public static boolean m4370e(String string) {
        if (TextUtils.isEmpty(string) || "null".equals(string)) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public static void m4362b(String path, String postfix) {
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

    /* renamed from: u */
    public static void m4383u() {
        ((InputMethodManager) AppContext.m3876a().getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(0, 2);
    }

    /* renamed from: f */
    public static String m4372f(String input) {
        ArrayList<C1254a> tokens = HanziToPinyin.m4408a().m4411a(input);
        StringBuilder sb = new StringBuilder();
        if (tokens != null && tokens.size() > 0) {
            Iterator it = tokens.iterator();
            while (it.hasNext()) {
                C1254a token = (C1254a) it.next();
                if (2 == token.f3592e) {
                    sb.append(token.f3594g);
                } else {
                    sb.append(token.f3593f);
                }
            }
        }
        return sb.toString().toUpperCase();
    }

    /* renamed from: c */
    public static void m4365c(String fileName, String data) {
        Context context = AppContext.m3876a();
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
            LogUtil.m4445e(f3472f, "---writeData--FileNotFoundException----");
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

    /* renamed from: g */
    public static String m4374g(String fileName) {
        String str = null;
        try {
            FileInputStream fis = AppContext.m3876a().openFileInput(fileName);
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
            LogUtil.m4445e(f3472f, "---getData--FileNotFoundException----");
        } catch (IOException e2) {
            LogUtil.m4445e(f3472f, "---getData--IOException----");
        }
        return str;
    }

    /* renamed from: v */
    public static void m4384v() {
        new C12501().start();
    }

    /* renamed from: w */
    public static void m4385w() throws Throwable {
        BufferedReader br;
        Throwable th;
        Context context = AppContext.m3876a();
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
                        CommonParams.jt = channel.trim();
                        LogUtil.d(f3472f, "channel id:" + CommonParams.jt);
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
                    CommonParams.jt = channel.trim();
                    LogUtil.d(f3472f, "channel id:" + CommonParams.jt);
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
                CommonParams.jt = channel.trim();
                LogUtil.d(f3472f, "channel id:" + CommonParams.jt);
            }
        }
    }

    /* renamed from: x */
    public boolean m4402x() {
        try {
            String name;
            if (VERSION.SDK_INT < 17) {
                name = "adb_enabled";
            } else {
                name = "adb_enabled";
            }
            if (Secure.getInt(this.f3481o.getContentResolver(), name, -10) == 1) {
                LogUtil.d(f3472f, "usb debug: on");
                return true;
            }
            LogUtil.d(f3472f, "usb debug: off");
            return false;
        } catch (Exception ex) {
            LogUtil.m4445e(f3472f, "usb debug get exception");
            ex.printStackTrace();
            return false;
        }
    }

    /* renamed from: y */
    public static boolean m4386y() {
        return f3471e;
    }

    /* renamed from: c */
    public static void m4366c(boolean is) {
        f3471e = is;
    }

    /* renamed from: b */
    public static void m4360b(int nSpeed) {
        f3480n = nSpeed;
    }

    /* renamed from: z */
    public static int m4387z() {
        return f3480n;
    }
}
