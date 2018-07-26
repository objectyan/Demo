package com.baidu.location.wifihistory;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.wifi.ScanResult;
import android.os.IBinder;
import com.baidu.location.C3377f;
import com.baidu.location.wifihistory.ISManager.Stub;
import com.baidu.navisdk.lightnavi.LightNaviParams;
import java.util.List;

public class SClient {
    ISManager mShare = null;
    private WifiHistory mWHistory = null;

    /* renamed from: com.baidu.location.wifihistory.SClient$1 */
    class C34591 implements ServiceConnection {
        /* renamed from: a */
        final /* synthetic */ SClient f18731a;

        C34591(SClient sClient) {
            this.f18731a = sClient;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f18731a.mShare = Stub.asInterface(iBinder);
            this.f18731a.mWHistory = SClient.getInstance().getRemoteObject();
            if (this.f18731a.mWHistory == null) {
                this.f18731a.mWHistory = new WifiHistory();
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.f18731a.mShare = null;
        }
    }

    /* renamed from: com.baidu.location.wifihistory.SClient$a */
    static class C3460a {
        /* renamed from: a */
        static SClient f18732a = new SClient();
    }

    public static SClient getInstance() {
        return C3460a.f18732a;
    }

    public WifiHistory getRemoteObject() {
        WifiHistory wifiHistory = null;
        if (this.mShare != null) {
            try {
                wifiHistory = this.mShare.getInfo2();
            } catch (Exception e) {
            }
        }
        return wifiHistory;
    }

    public WifiHistory getWifiHistory() {
        return this.mWHistory;
    }

    public String getWifiHistoryString() {
        return this.mWHistory != null ? this.mWHistory.getWifiHistory() : null;
    }

    public void start() {
        Intent intent = new Intent("com.baidu.location.locSManager");
        intent.setPackage(LightNaviParams.DEFAULT_PACKAGE_NAME);
        try {
            C3377f.getServiceContext().bindService(intent, new C34591(this), 1);
        } catch (Exception e) {
        }
    }

    public void updateWifiHistory(List<ScanResult> list) {
        if (list != null && this.mWHistory != null) {
            this.mWHistory.updateWifi(list);
        }
    }
}
