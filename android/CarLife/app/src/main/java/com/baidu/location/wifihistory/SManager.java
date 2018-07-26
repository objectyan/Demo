package com.baidu.location.wifihistory;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.location.wifihistory.ISManager.Stub;

public class SManager extends Service {
    private Stub mProvider = new C34611(this);
    private String testStr = "test 00";

    /* renamed from: com.baidu.location.wifihistory.SManager$1 */
    class C34611 extends Stub {
        /* renamed from: a */
        final /* synthetic */ SManager f18733a;

        C34611(SManager sManager) {
            this.f18733a = sManager;
        }

        public WifiHistory getInfo2() throws RemoteException {
            return SClient.getInstance().getWifiHistory();
        }

        public String getShareString01() throws RemoteException {
            return this.f18733a.testStr;
        }

        public boolean setShareString01(String str) throws RemoteException {
            this.f18733a.testStr = str;
            return false;
        }
    }

    public IBinder onBind(Intent intent) {
        return this.mProvider;
    }
}
