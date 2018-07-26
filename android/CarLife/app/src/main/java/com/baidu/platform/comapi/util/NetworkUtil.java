package com.baidu.platform.comapi.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.mobstat.Config;
import com.baidu.platform.comjni.engine.NAEngine;

public class NetworkUtil {
    public static final int NETYPE_2G = 2;
    public static final int NETYPE_3G = 3;
    public static final int NETYPE_4G = 4;
    public static final int NETYPE_4G_UNKNOWN = 10;
    public static final int NETYPE_MOBILE_3G = 8;
    public static final int NETYPE_MOBILE_UNICOM_2G = 6;
    public static final int NETYPE_NOCON = -1;
    public static final int NETYPE_TELECOM_2G = 5;
    public static final int NETYPE_TELECOM_3G = 7;
    public static final int NETYPE_UNICOM_3G = 9;
    public static final int NETYPE_UNKNOWN = 0;
    public static final int NETYPE_WIFI = 1;
    public static String mProxyHost = "";
    public static int mProxyPort = 0;
    public static boolean mUseProxy = false;

    public static void updateNetworkProxy(Context context) {
        mUseProxy = false;
        NetworkInfo info = getActiveNetworkInfo(context);
        if (info != null && info.isAvailable()) {
            String typeName = info.getTypeName().toLowerCase();
            if (typeName.equals(C1981b.f6365e) && info.isConnected()) {
                NAEngine.setProxyInfo(null, 0);
                return;
            } else if (typeName.equals("mobile") || (typeName.equals(C1981b.f6365e) && !m15879a(info))) {
                String extraInfo = info.getExtraInfo();
                if (extraInfo != null) {
                    String extraInfoName = extraInfo.toLowerCase();
                    if (extraInfoName.startsWith("cmwap") || extraInfoName.startsWith("uniwap") || extraInfoName.startsWith("3gwap") || extraInfoName.startsWith("cuwap")) {
                        mProxyHost = "10.0.0.172";
                        mProxyPort = 80;
                        mUseProxy = true;
                    } else if (extraInfoName.startsWith("ctwap")) {
                        mProxyHost = "10.0.0.200";
                        mProxyPort = 80;
                        mUseProxy = true;
                    } else if (extraInfoName.startsWith("cmnet") || extraInfoName.startsWith("uninet") || extraInfoName.startsWith("ctnet") || extraInfoName.startsWith("3gnet")) {
                        mUseProxy = false;
                    }
                } else {
                    String defaultProxyHost = Proxy.getDefaultHost();
                    int defaultProxyPort = Proxy.getDefaultPort();
                    if (defaultProxyHost != null && defaultProxyHost.length() > 0) {
                        if ("10.0.0.172".equals(defaultProxyHost.trim())) {
                            mProxyHost = "10.0.0.172";
                            mProxyPort = defaultProxyPort;
                            mUseProxy = true;
                        } else if ("10.0.0.200".equals(defaultProxyHost.trim())) {
                            mProxyHost = "10.0.0.200";
                            mProxyPort = 80;
                            mUseProxy = true;
                        }
                    }
                }
            }
        }
        if (mUseProxy) {
            NAEngine.setProxyInfo(mProxyHost, mProxyPort);
        } else {
            NAEngine.setProxyInfo(null, 0);
        }
    }

    public static boolean initConnectState() {
        return true;
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        if (context == null) {
            return null;
        }
        NetworkInfo networkInfo = null;
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (Exception e) {
            return networkInfo;
        }
    }

    public static NetworkInfo[] getAllNetworkInfo(Context context) {
        if (context == null) {
            return null;
        }
        NetworkInfo[] networkInfoArr = null;
        try {
            return ((ConnectivityManager) context.getSystemService("connectivity")).getAllNetworkInfo();
        } catch (Exception e) {
            return networkInfoArr;
        }
    }

    public static String getCurrentNetMode(Context context) {
        int netype;
        NetworkInfo info = getActiveNetworkInfo(context);
        if (info != null) {
            if (info.getType() != 1) {
                switch (((TelephonyManager) context.getSystemService("phone")).getNetworkType()) {
                    case 1:
                    case 2:
                        netype = 6;
                        break;
                    case 3:
                    case 9:
                    case 10:
                    case 15:
                        netype = 9;
                        break;
                    case 4:
                        netype = 5;
                        break;
                    case 5:
                    case 6:
                    case 12:
                        netype = 7;
                        break;
                    case 7:
                    case 11:
                        netype = 2;
                        break;
                    case 8:
                        netype = 8;
                        break;
                    case 13:
                        netype = 4;
                        break;
                    case 14:
                        netype = 3;
                        break;
                    default:
                        netype = 0;
                        break;
                }
            }
            netype = 1;
        } else {
            netype = -1;
        }
        return Integer.toString(netype);
    }

    public static boolean isNetworkAvailable(Context context) {
        try {
            if (isWifiConnected(context)) {
                return true;
            }
            NetworkInfo info = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (info == null || !info.isConnectedOrConnecting()) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        if (context == null) {
            return false;
        }
        boolean isWifiConnected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                NetworkInfo activeNetInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetInfo != null) {
                    isWifiConnected = 1 == activeNetInfo.getType() && activeNetInfo.isConnected();
                }
            } catch (Exception e) {
            }
        }
        return isWifiConnected;
    }

    @SuppressLint({"MissingPermission"})
    public static boolean isWifiState(Context context) {
        if (context == null) {
            return false;
        }
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService(C1981b.f6365e);
        int wifiState = 1;
        try {
            if (VERSION.SDK_INT < 23) {
                wifiState = wifiManager.getWifiState();
            } else if (context.checkSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
                wifiState = wifiManager.getWifiState();
            }
        } catch (Exception e) {
        }
        if (wifiState == 3) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m15879a(NetworkInfo activeNetInfo) {
        if (activeNetInfo == null) {
            return false;
        }
        try {
            return 1 == activeNetInfo.getType() && activeNetInfo.isConnected();
        } catch (Exception e) {
            return false;
        }
    }

    public static String getNetworkOperatorInfo(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            String mccmnc = telephonyManager.getNetworkOperator();
            if (!TextUtils.isEmpty(mccmnc)) {
                try {
                    StringBuilder stringBuilder = new StringBuilder(mccmnc);
                    stringBuilder.insert(3, Config.TRACE_TODAY_VISIT_SPLIT);
                    return stringBuilder.toString();
                } catch (Exception e) {
                    return "";
                }
            }
        }
        return "";
    }

    public static int getNetworkOperatorType(Context context) {
        String mccMnc = getNetworkOperatorInfo(context);
        if (!TextUtils.isEmpty(mccMnc)) {
            if (mccMnc.startsWith("460:00") || mccMnc.startsWith("460:02")) {
                return 0;
            }
            if (mccMnc.startsWith("460:01")) {
                return 1;
            }
            if (mccMnc.startsWith("460:03")) {
                return 2;
            }
        }
        return -1;
    }
}
