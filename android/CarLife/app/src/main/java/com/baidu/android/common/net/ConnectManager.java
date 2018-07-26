package com.baidu.android.common.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.baidu.che.codriver.sdk.p081a.C2602k.C1981b;

public class ConnectManager {
    private static final boolean DEBUG = false;
    private static final String TAG = ConnectManager.class.getSimpleName();
    private String mApn;
    private String mNetType;
    private String mPort;
    private String mProxy;
    private int mSubType;
    private String mSubTypeName;
    private boolean mUseWap;

    public ConnectManager(Context context) {
        checkNetworkType(context);
    }

    private void checkApn(Context context, NetworkInfo networkInfo) {
        String toLowerCase;
        if (networkInfo.getExtraInfo() != null) {
            toLowerCase = networkInfo.getExtraInfo().toLowerCase();
            if (toLowerCase != null) {
                if (toLowerCase.startsWith("cmwap") || toLowerCase.startsWith("uniwap") || toLowerCase.startsWith("3gwap")) {
                    this.mUseWap = true;
                    this.mApn = toLowerCase;
                    this.mProxy = "10.0.0.172";
                    this.mPort = "80";
                    return;
                } else if (toLowerCase.startsWith("ctwap")) {
                    this.mUseWap = true;
                    this.mApn = toLowerCase;
                    this.mProxy = "10.0.0.200";
                    this.mPort = "80";
                    return;
                } else if (toLowerCase.startsWith("cmnet") || toLowerCase.startsWith("uninet") || toLowerCase.startsWith("ctnet") || toLowerCase.startsWith("3gnet")) {
                    this.mUseWap = false;
                    this.mApn = toLowerCase;
                    return;
                }
            }
        }
        toLowerCase = Proxy.getDefaultHost();
        int defaultPort = Proxy.getDefaultPort();
        if (toLowerCase == null || toLowerCase.length() <= 0) {
            this.mUseWap = false;
            return;
        }
        this.mProxy = toLowerCase;
        if ("10.0.0.172".equals(this.mProxy.trim())) {
            this.mUseWap = true;
            this.mPort = "80";
        } else if ("10.0.0.200".equals(this.mProxy.trim())) {
            this.mUseWap = true;
            this.mPort = "80";
        } else {
            this.mUseWap = false;
            this.mPort = Integer.toString(defaultPort);
        }
    }

    private void checkNetworkType(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (NullPointerException e) {
            activeNetworkInfo = null;
        }
        if (activeNetworkInfo != null) {
            if (C1981b.f6365e.equals(activeNetworkInfo.getTypeName().toLowerCase())) {
                this.mNetType = C1981b.f6365e;
                this.mUseWap = false;
            } else {
                checkApn(context, activeNetworkInfo);
                this.mNetType = this.mApn;
            }
            this.mSubType = activeNetworkInfo.getSubtype();
            this.mSubTypeName = activeNetworkInfo.getSubtypeName();
        }
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getApplicationContext().getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null ? activeNetworkInfo.isConnectedOrConnecting() : false;
    }

    public String getApn() {
        return this.mApn;
    }

    public String getNetType() {
        return this.mNetType;
    }

    public String getProxy() {
        return this.mProxy;
    }

    public String getProxyPort() {
        return this.mPort;
    }

    public int getSubType() {
        return this.mSubType;
    }

    public String getSubTypeName() {
        return this.mSubTypeName;
    }

    public boolean isWapNetwork() {
        return this.mUseWap;
    }
}
