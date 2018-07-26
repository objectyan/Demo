package com.baidu.sapi2.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.android.common.util.DeviceId;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.mobstat.Config;
import com.baidu.sapi2.C4891b;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SimpleTimeZone;
import java.util.regex.Pattern;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class SapiUtils {
    public static final String KEY_QR_LOGIN_LP = "lp";
    public static final String KEY_QR_LOGIN_SIGN = "sign";
    public static final int MAX_WIFI_LIST = 10;
    public static final int NETWORK_TYPE_1XRTT = 7;
    public static final int NETWORK_TYPE_CDMA = 4;
    public static final int NETWORK_TYPE_EDGE = 2;
    public static final int NETWORK_TYPE_EHRPD = 14;
    public static final int NETWORK_TYPE_EVDO_0 = 5;
    public static final int NETWORK_TYPE_EVDO_A = 6;
    public static final int NETWORK_TYPE_EVDO_B = 12;
    public static final int NETWORK_TYPE_GPRS = 1;
    public static final int NETWORK_TYPE_HSDPA = 8;
    public static final int NETWORK_TYPE_HSPA = 10;
    public static final int NETWORK_TYPE_HSPAP = 15;
    public static final int NETWORK_TYPE_HSUPA = 9;
    public static final int NETWORK_TYPE_IDEN = 11;
    public static final int NETWORK_TYPE_LTE = 13;
    public static final int NETWORK_TYPE_UMTS = 3;
    public static final int NETWORK_TYPE_UNKNOWN = 0;
    public static final String QR_LOGIN_LP_APP = "app";
    public static final String QR_LOGIN_LP_PC = "pc";
    /* renamed from: a */
    static final String f20522a = "cmd";
    /* renamed from: b */
    static final String f20523b = "error";
    /* renamed from: c */
    static final String f20524c = "EEE, dd-MMM-yyyy HH:mm:ss 'GMT'";
    /* renamed from: d */
    static final String f20525d = "http://www.";

    public static boolean isValidAccount(SapiAccount account) {
        return (account == null || TextUtils.isEmpty(account.bduss) || TextUtils.isEmpty(account.uid) || TextUtils.isEmpty(account.displayname)) ? false : true;
    }

    public static boolean isValidUsername(String username) {
        if (TextUtils.isEmpty(username) || username.length() > 14) {
            return false;
        }
        return true;
    }

    public static String getClientId(Context context) {
        try {
            return DeviceId.getDeviceID(context);
        } catch (Throwable th) {
            return "123456789";
        }
    }

    public static String getLocalIpAddress() {
        try {
            Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
            while (en.hasMoreElements()) {
                Enumeration<InetAddress> enumIpAddr = ((NetworkInterface) en.nextElement()).getInetAddresses();
                while (enumIpAddr.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        String mClientIp = inetAddress.getHostAddress();
                        if (mClientIp != null && mClientIp.length() > 0) {
                            return mClientIp;
                        }
                    }
                }
            }
        } catch (Throwable ex) {
            C4913L.m16374e(ex);
        }
        return null;
    }

    public static String createRequestParams(List<NameValuePair> list) {
        StringBuilder paramListBuffer = new StringBuilder();
        if (list != null) {
            for (NameValuePair pair : list) {
                if (!(TextUtils.isEmpty(pair.getName()) || TextUtils.isEmpty(pair.getValue()))) {
                    if (TextUtils.isEmpty(paramListBuffer.toString())) {
                        paramListBuffer.append(pair.getName()).append("=").append(pair.getValue());
                    } else {
                        paramListBuffer.append("&").append(pair.getName()).append("=").append(pair.getValue());
                    }
                }
            }
        }
        return paramListBuffer.toString();
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (TextUtils.isEmpty(phoneNumber)) {
            return false;
        }
        return Pattern.compile("^(1)\\d{10}$").matcher(phoneNumber).matches();
    }

    public static boolean isSimReady(Context context) {
        if (context == null || context.checkCallingOrSelfPermission("android.permission.SEND_SMS") != 0) {
            return false;
        }
        switch (((TelephonyManager) context.getSystemService("phone")).getSimState()) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                return false;
            case 5:
                return true;
            default:
                return false;
        }
    }

    public static boolean hasActiveNetwork(Context context) {
        if (context == null) {
            return false;
        }
        try {
            if (((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null) {
                return true;
            }
            return false;
        } catch (Throwable e) {
            C4913L.m16374e(e);
            return false;
        }
    }

    @TargetApi(3)
    public static String getNetworkClass(Context context) {
        try {
            NetworkInfo info = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (info == null || !info.isConnected()) {
                return "UNCNCT";
            }
            if (info.getType() == 1) {
                return "WIFI";
            }
            if (info.getType() == 0) {
                switch (info.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return "2G";
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return "3G";
                    case 13:
                        return "4G";
                    default:
                        return "UNKNOWN";
                }
            }
            return "UNKNOWN";
        } catch (Throwable e) {
            C4913L.m16374e(e);
        }
    }

    public static boolean isRoot() {
        String binPath = "/system/bin/su";
        String xBinPath = "/system/xbin/su";
        return (new File(binPath).exists() && m16388a(binPath)) || (new File(xBinPath).exists() && m16388a(xBinPath));
    }

    /* renamed from: a */
    private static boolean m16388a(String filePath) {
        IOException e;
        Throwable th;
        Process p = null;
        BufferedReader in = null;
        try {
            p = Runtime.getRuntime().exec("ls -l " + filePath);
            BufferedReader in2 = new BufferedReader(new InputStreamReader(p.getInputStream()));
            try {
                String str = in2.readLine();
                if (str != null && str.length() >= 4) {
                    char flag = str.charAt(3);
                    if (flag == 's' || flag == 'x') {
                        if (in2 != null) {
                            try {
                                in2.close();
                            } catch (Exception e2) {
                                C4913L.m16374e(e2);
                            }
                        }
                        if (p != null) {
                            p.destroy();
                        }
                        in = in2;
                        return true;
                    }
                }
                if (in2 != null) {
                    try {
                        in2.close();
                    } catch (Exception e22) {
                        C4913L.m16374e(e22);
                    }
                }
                if (p != null) {
                    p.destroy();
                    in = in2;
                }
            } catch (IOException e3) {
                e = e3;
                in = in2;
                try {
                    C4913L.m16374e(e);
                    if (in != null) {
                        try {
                            in.close();
                        } catch (Exception e222) {
                            C4913L.m16374e(e222);
                        }
                    }
                    if (p != null) {
                        p.destroy();
                    }
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (in != null) {
                        try {
                            in.close();
                        } catch (Exception e2222) {
                            C4913L.m16374e(e2222);
                        }
                    }
                    if (p != null) {
                        p.destroy();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                in = in2;
                if (in != null) {
                    in.close();
                }
                if (p != null) {
                    p.destroy();
                }
                throw th;
            }
        } catch (IOException e4) {
            e = e4;
            C4913L.m16374e(e);
            if (in != null) {
                in.close();
            }
            if (p != null) {
                p.destroy();
            }
            return false;
        }
        return false;
    }

    public static String getWifiInfo(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(C1981b.f6365e);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        String cBssid = "";
        int cLevel = 0;
        if (wifiInfo != null) {
            cLevel = StrictMath.abs(wifiInfo.getRssi());
            cBssid = wifiInfo.getBSSID();
            if (cBssid != null) {
                cBssid = cBssid.replace(Config.TRACE_TODAY_VISIT_SPLIT, "");
            }
        }
        List<ScanResult> scanResults = null;
        if (checkRequestPermission("android.permission.ACCESS_COARSE_LOCATION", context)) {
            scanResults = wifiManager.getScanResults();
        }
        int count = 0;
        StringBuffer sb = new StringBuffer();
        if (scanResults != null) {
            for (ScanResult scanResult : scanResults) {
                String bssid = scanResult.BSSID;
                int level = StrictMath.abs(scanResult.level);
                bssid = bssid.replace(Config.TRACE_TODAY_VISIT_SPLIT, "");
                if (!(cBssid.equals(bssid) || level == 0)) {
                    if (count >= 10) {
                        break;
                    }
                    sb.append("h").append(bssid).append(Config.MODEL).append(level);
                    count++;
                }
            }
        }
        String strWifi = "";
        if (!TextUtils.isEmpty(cBssid)) {
            strWifi = "h" + cBssid + "km" + cLevel;
        }
        return strWifi + sb.toString();
    }

    public static String getCookieBduss() {
        String value = "";
        String allCookies = CookieManager.getInstance().getCookie("http://www.baidu.com");
        if (TextUtils.isEmpty(allCookies)) {
            return value;
        }
        for (String cookie : allCookies.split(";")) {
            String cookie2 = cookie2.trim();
            if (!TextUtils.isEmpty(cookie2)) {
                String[] pair = cookie2.split("=");
                if (pair.length == 2 && pair[0].equals("BDUSS")) {
                    return pair[1];
                }
            }
        }
        return value;
    }

    public static boolean webLogin(Context context, String bduss) {
        if (context == null || TextUtils.isEmpty(bduss)) {
            return false;
        }
        try {
            List<NameValuePair> cookies = new ArrayList();
            for (String domain : getAuthorizedDomains(context)) {
                cookies.add(new BasicNameValuePair(f20525d + domain, m16387a(domain, bduss)));
            }
            syncCookies(context, cookies);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean webLogout(Context context) {
        if (context == null) {
            return false;
        }
        try {
            List<NameValuePair> cookies = new ArrayList();
            for (String domain : getAuthorizedDomains(context)) {
                cookies.add(new BasicNameValuePair(f20525d + domain, m16387a(domain, "")));
            }
            syncCookies(context, cookies);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static String buildCookie(String domain, String key, String value, Date time) {
        DateFormat dateFormat = new SimpleDateFormat(f20524c, Locale.US);
        dateFormat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        return key + "=" + value + ";domain=" + domain + ";path=/;expires=" + dateFormat.format(time);
    }

    public static String buildIqiyiCookie(String domain, String key, String value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(5, TextUtils.isEmpty(value) ? -2 : 2);
        return buildCookie(domain, key, value, calendar.getTime());
    }

    public static String buildBDUSSCookie(String domain, String key, String value) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(1, TextUtils.isEmpty(value) ? -8 : 8);
        return buildCookie(domain, key, value, calendar.getTime());
    }

    /* renamed from: a */
    static String m16387a(String domain, String bduss) {
        return buildBDUSSCookie(domain, "BDUSS", bduss);
    }

    public static void syncCookies(Context context, List<NameValuePair> cookies) {
        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        SapiConfiguration configuration = SapiAccountManager.getInstance().getSapiConfiguration();
        if (TextUtils.isEmpty(configuration.clientId)) {
            configuration.clientId = getClientId(context);
        }
        cookieManager.setCookie(configuration.environment.getWap(), "cuid=" + configuration.clientId + ";domain=" + configuration.environment.getWap().replace("http://", "").replaceAll("(:[0-9]{1,4})?", "") + ";path=/");
        if (cookies != null) {
            for (NameValuePair cookie : cookies) {
                if (!(TextUtils.isEmpty(cookie.getName()) || TextUtils.isEmpty(cookie.getValue()))) {
                    cookieManager.setCookie(cookie.getName(), cookie.getValue());
                }
            }
        }
        CookieSyncManager.getInstance().sync();
    }

    public static List<String> getAuthorizedDomains(Context context) {
        if (context == null) {
            return Collections.emptyList();
        }
        return C4891b.m16250a(context).m16290l();
    }

    public static String getAppName(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            return manager.getPackageInfo(context.getPackageName(), 0).applicationInfo.loadLabel(manager).toString();
        } catch (Throwable th) {
            return null;
        }
    }

    public static String getVersionName(Context context) {
        String versionName = "0";
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable e) {
            C4913L.m16374e(e);
            return versionName;
        }
    }

    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
            return 0;
        }
    }

    public static int dip2px(Context context, float dpValue) {
        if (context != null) {
            return (int) ((dpValue * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        throw new IllegalArgumentException("Context can't be null");
    }

    public static boolean isQrLoginSchema(String resultText) {
        if (TextUtils.isEmpty(resultText) || !resultText.contains("error") || !resultText.contains("sign") || !resultText.contains(f20522a) || !resultText.contains(KEY_QR_LOGIN_LP)) {
            return false;
        }
        Map<String, String> params = new HashMap();
        for (String paramPair : resultText.split("&")) {
            String[] param = paramPair.split("=");
            if (param.length > 1) {
                params.put(param[0], param[1]);
            } else if (param.length == 1) {
                params.put(param[0], "");
            }
        }
        return (TextUtils.isEmpty((CharSequence) params.get("error")) || TextUtils.isEmpty((CharSequence) params.get("sign")) || TextUtils.isEmpty((CharSequence) params.get(f20522a)) || TextUtils.isEmpty((CharSequence) params.get(KEY_QR_LOGIN_LP))) ? false : true;
    }

    public static Map<String, String> parseQrLoginSchema(String resultText) {
        Map<String, String> params = new HashMap();
        if (isQrLoginSchema(resultText)) {
            for (String paramPair : resultText.split("&")) {
                String[] param = paramPair.split("=");
                if (param.length > 1) {
                    params.put(param[0], param[1]);
                } else if (param.length == 1) {
                    params.put(param[0], "");
                }
            }
        }
        return params;
    }

    @TargetApi(4)
    public static boolean sendSms(Context context, String sms, String destination) {
        if (context == null || TextUtils.isEmpty(sms) || TextUtils.isEmpty(destination)) {
            return false;
        }
        try {
            SmsManager.getDefault().sendTextMessage(destination, null, sms, null, null);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static void resetSilentShareStatus(Context context) {
        if (context != null && C4891b.m16250a(context).m16278d() == null) {
            C4891b.m16250a(context).m16287i();
        }
    }

    public static String getFastRegChannel(Context context) {
        if (context != null) {
            String num = C4891b.m16250a(context).m16291m();
            if (!TextUtils.isEmpty(num)) {
                return num;
            }
        }
        return C4923f.f20615t;
    }

    public static boolean checkRequestPermission(String permission, Context context) {
        return VERSION.SDK_INT < 23 || context.checkSelfPermission(permission) == 0;
    }
}
