package com.baidu.navisdk.util.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.telephony.TelephonyManager;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;
import com.baidu.navisdk.BNaviModuleManager;
import com.baidu.navisdk.vi.VNetworkInfo;
import org.apache.http.HttpHost;
import org.apache.http.params.HttpParams;

public class NetworkUtils {
    private static final String NET = "net";
    public static final int NETWORK_TYPE_BLUETOOTH = 4;
    public static final int NETWORK_TYPE_EXT_BASE = 1000;
    public static final int NETWORK_TYPE_MOBILE = 3;
    public static final int NETWORK_TYPE_NONE = 0;
    public static final int NETWORK_TYPE_UNKNOWN = 1;
    public static final int NETWORK_TYPE_WIFI = 2;
    private static final String PROXY_IP = "10.0.0.172";
    public static final int STATE_NO = 0;
    public static final int STATE_OK = 1;
    private static final String TAG = "NetworkUtils";
    private static final String WAP = "wap";
    private static final int WIFI_TYPE = 88;
    public static int mConnectState;
    public static String mProxyHost = "";
    public static int mProxyPort = 0;
    public static boolean mUseProxy = false;
    public static int mWifiState = -1;

    public static void ChangeGprsConnect(Context context) {
        if (context != null) {
            NetworkInfo info = null;
            try {
                ConnectivityManager cManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (cManager != null) {
                    info = cManager.getActiveNetworkInfo();
                }
            } catch (Exception e) {
            }
            if (info != null && info.isAvailable()) {
                String typeName = info.getTypeName().toLowerCase();
                if (typeName.equals(C1981b.f6365e) && 1 == mWifiState) {
                    mUseProxy = false;
                } else if (typeName.equals("mobile") || (typeName.equals(C1981b.f6365e) && mWifiState == 0)) {
                    String extraInfo = info.getExtraInfo();
                    mUseProxy = false;
                    if (extraInfo != null) {
                        String extraInfoName = extraInfo.toLowerCase();
                        if (extraInfoName.startsWith("cmwap") || extraInfoName.startsWith("uniwap") || extraInfoName.startsWith("3gwap")) {
                            mProxyHost = PROXY_IP;
                            mProxyPort = 80;
                            mUseProxy = true;
                            return;
                        } else if (extraInfoName.startsWith("ctwap")) {
                            mProxyHost = "10.0.0.200";
                            mProxyPort = 80;
                            mUseProxy = true;
                            return;
                        } else if (extraInfoName.startsWith("cmnet") || extraInfoName.startsWith("uninet") || extraInfoName.startsWith("ctnet") || extraInfoName.startsWith("3gnet")) {
                            mUseProxy = false;
                            return;
                        } else {
                            return;
                        }
                    }
                    String defaultProxyHost = Proxy.getDefaultHost();
                    int defaultProxyPort = Proxy.getDefaultPort();
                    if (defaultProxyHost != null && defaultProxyHost.length() > 0) {
                        if (PROXY_IP.equals(defaultProxyHost.trim())) {
                            mProxyHost = PROXY_IP;
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
    }

    public static String getCurrentNetMode(Context context) {
        if (context == null) {
            return Integer.toString(1);
        }
        int netype = 1;
        NetworkInfo info = null;
        try {
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService("connectivity");
            if (manager != null) {
                info = manager.getActiveNetworkInfo();
            }
        } catch (Exception e) {
        }
        if (info != null) {
            if (info.getType() == 1) {
                netype = 2;
            } else if (SystemAuth.checkAuth(SystemAuth.READ_PHONE_STATE_AUTH)) {
                int type = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                switch (type) {
                    case 1:
                    case 2:
                        netype = type + 1000;
                        break;
                    case 3:
                    case 9:
                    case 10:
                        netype = type + 1000;
                        break;
                    case 4:
                        netype = type + 1000;
                        break;
                    case 5:
                    case 6:
                    case 7:
                        netype = type + 1000;
                        break;
                    case 8:
                        netype = type + 1000;
                        break;
                    case 11:
                        netype = type + 1000;
                        break;
                    default:
                        netype = type + 1000;
                        break;
                }
            } else {
                netype = 1000;
            }
        }
        return Integer.toString(netype);
    }

    public static boolean isWifi(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo activeNetInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetInfo == null || activeNetInfo.getType() != 1) {
            return false;
        }
        return true;
    }

    public static boolean isWap(Context context) {
        if (context == null) {
            return false;
        }
        NetworkInfo info = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (info == null || info.getExtraInfo() == null) {
            return false;
        }
        return info.getExtraInfo().endsWith(WAP);
    }

    public static int getNetStatus() {
        if (BNaviModuleManager.getContext() == null) {
            return 1;
        }
        NetworkInfo activeNetInfo = ((ConnectivityManager) BNaviModuleManager.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetInfo == null) {
            return 1;
        }
        int NetworkType = activeNetInfo.getType();
        if (!activeNetInfo.isConnected()) {
            return 1;
        }
        switch (NetworkType) {
            case 0:
                return 3;
            case 1:
                return 2;
            default:
                return 1;
        }
    }

    public static int getActiveNetworkSubtype() {
        Context context = BNaviModuleManager.getContext();
        if (context == null) {
            return -100;
        }
        NetworkInfo activeNetInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetInfo == null) {
            return -100;
        }
        if (activeNetInfo.getType() == 1) {
            return 88;
        }
        return activeNetInfo.getSubtype();
    }

    public static void fillProxy(Context context, HttpParams httpParams) {
        if (context != null) {
            NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (networkInfo != null && networkInfo.getExtraInfo() != null) {
                String info = networkInfo.getExtraInfo().toLowerCase();
                if (info != null) {
                    if (info.startsWith("cmwap") || info.startsWith("uniwap") || info.startsWith("3gwap")) {
                        httpParams.setParameter("http.route.default-proxy", new HttpHost(PROXY_IP, 80));
                        return;
                    } else if (info.startsWith("ctwap")) {
                        httpParams.setParameter("http.route.default-proxy", new HttpHost("10.0.0.200", 80));
                        return;
                    } else if (info.startsWith("cmnet") || info.startsWith("uninet") || info.startsWith("ctnet") || info.startsWith("3gnet")) {
                        return;
                    }
                }
                String defaultProxyHost = Proxy.getDefaultHost();
                int defaultProxyPort = Proxy.getDefaultPort();
                if (defaultProxyHost != null && defaultProxyHost.length() > 0) {
                    if (PROXY_IP.equals(defaultProxyHost.trim())) {
                        httpParams.setParameter("http.route.default-proxy", new HttpHost(PROXY_IP, defaultProxyPort));
                    } else if ("10.0.0.200".equals(defaultProxyHost.trim())) {
                        httpParams.setParameter("http.route.default-proxy", new HttpHost("10.0.0.200", 80));
                    }
                }
            }
        }
    }

    public static int getCurrentNetworkType() {
        if (BNaviModuleManager.getContext() == null) {
            return 0;
        }
        try {
            ConnectivityManager cm = (ConnectivityManager) BNaviModuleManager.getContext().getSystemService("connectivity");
            if (cm.getActiveNetworkInfo() == null) {
                return 0;
            }
            switch (cm.getActiveNetworkInfo().getType()) {
                case 0:
                    return 3;
                case 1:
                    return 2;
                default:
                    return 1;
            }
        } catch (Exception e) {
            return 1;
        }
    }

    public static boolean isWifiConnected() {
        boolean z = false;
        if (BNaviModuleManager.getContext() != null) {
            try {
                NetworkInfo info = ((ConnectivityManager) BNaviModuleManager.getContext().getSystemService("connectivity")).getNetworkInfo(1);
                if (info != null) {
                    z = info.isConnected();
                }
            } catch (Throwable th) {
            }
        }
        return z;
    }

    public static VNetworkInfo getNetworkInfo(int type) {
        if (BNaviModuleManager.getContext() == null) {
            return null;
        }
        ConnectivityManager cm = (ConnectivityManager) BNaviModuleManager.getContext().getSystemService("connectivity");
        NetworkInfo info = null;
        switch (type) {
            case 2:
                info = cm.getNetworkInfo(1);
                break;
            case 3:
                info = cm.getNetworkInfo(0);
                break;
        }
        return new VNetworkInfo(info);
    }

    public static boolean isNetworkAvailable(Context context) {
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivity == null) {
                LogUtil.m15791e(TAG, "ConnectivityManager is null");
                return false;
            }
            NetworkInfo activeInfo = connectivity.getActiveNetworkInfo();
            if (activeInfo != null) {
                return activeInfo.isConnected();
            }
            LogUtil.m15791e(TAG, "No Connected！");
            return false;
        } catch (Exception e) {
        }
    }

    public static boolean isTypeNetworkAvailable(Context context, int networkType) {
        if (context == null) {
            return false;
        }
        try {
            ConnectivityManager conMgr = (ConnectivityManager) context.getSystemService("connectivity");
            if (conMgr == null) {
                LogUtil.m15791e(TAG, "ConnectivityManager is null");
                return false;
            }
            NetworkInfo info = conMgr.getNetworkInfo(networkType);
            if (info != null) {
                State state = info.getState();
                if (state == State.CONNECTED || state == State.CONNECTING) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
        }
    }

    public static boolean getConnectStatus() {
        return mConnectState == 1;
    }
}
