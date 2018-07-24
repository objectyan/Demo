package com.baidu.carlife.platform.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.baidu.carlife.core.LogUtil;
import com.baidu.carlife.platform.communication.C2006c;
import com.baidu.carlife.platform.service.C2010i.C2011a;
import java.util.List;

public class CLPlatformService extends Service {
    /* renamed from: a */
    private C2011a f6512a = new C20121(this);

    /* renamed from: com.baidu.carlife.platform.service.CLPlatformService$1 */
    class C20121 extends C2011a {
        /* renamed from: a */
        final /* synthetic */ CLPlatformService f6511a;

        C20121(CLPlatformService this$0) {
            this.f6511a = this$0;
        }

        /* renamed from: a */
        public int mo1742a(String appName, String sdkVersion, String secretKey, C2016h callback) throws RemoteException {
            LogUtil.d("CarLifePlatform", "CLPlatformService.register appName=" + appName + " sdkVersion=" + sdkVersion + " secretKey=" + secretKey);
            try {
                if (Integer.parseInt(sdkVersion) < 1) {
                    return 8;
                }
                if (C2013a.m7695a().m7698b(appName).m7722a(callback)) {
                    return 0;
                }
                return 4;
            } catch (Throwable e) {
                LogUtil.m4432a("PlatformManager", e);
                return 8;
            }
        }

        /* renamed from: a */
        public String mo1743a(String appName) throws RemoteException {
            LogUtil.d("CarLifePlatform", "CLPlatformService.startServer appName=" + appName);
            C2013a.m7695a().m7701d();
            return C2006c.f6490a;
        }

        /* renamed from: a */
        public void mo1746a(String appName, int errorNo, String errorMsg) throws RemoteException {
            LogUtil.d("CarLifePlatform", "CLPlatformService.onSDKClientError appName=" + appName + " errorNo=" + errorNo + " errorMsg=" + errorMsg);
            C2017c clsdkClient = C2013a.m7695a().m7699c(appName);
            if (clsdkClient != null && errorNo == 7) {
                clsdkClient.m7725d();
            }
        }

        /* renamed from: b */
        public void mo1750b(String name) throws RemoteException {
            LogUtil.d("CarLifePlatform", "CLPlatformService.stopDownloadSong appName=" + name);
            C2017c client = C2013a.m7695a().m7699c(name);
            if (client != null) {
                client.m7724c();
            }
        }

        /* renamed from: a */
        public boolean mo1749a(C1991f callback) throws RemoteException {
            LogUtil.d("CarLifePlatform", "CLPlatformService.registerLocalCallback");
            return C2013a.m7695a().m7697b().m7708a(callback);
        }

        /* renamed from: a */
        public void mo1745a(int errorNo, String errorMsg) throws RemoteException {
        }

        /* renamed from: a */
        public void mo1747a(String name, String songListId, int pn, int rn) throws RemoteException {
            LogUtil.d("CarLifePlatform", "CLPlatformService.getSongList appName=" + name + " songListId=" + songListId);
            C2017c client = C2013a.m7695a().m7699c(name);
            if (client != null) {
                try {
                    client.m7719a(songListId, pn, rn);
                } catch (Throwable e) {
                    LogUtil.m4432a("PlatformManager", e);
                }
            }
        }

        /* renamed from: a */
        public void mo1748a(String name, String songId, long size) throws RemoteException {
            LogUtil.d("CarLifePlatform", "CLPlatformService.getSong appName=" + name + " songId=" + songId);
            C2017c client = C2013a.m7695a().m7699c(name);
            if (client != null) {
                try {
                    client.m7720a(songId, size);
                } catch (Throwable e) {
                    LogUtil.m4432a("PlatformManager", e);
                }
            }
        }

        /* renamed from: a */
        public List<String> mo1744a() throws RemoteException {
            LogUtil.d("CarLifePlatform", "CLPlatformService.getRemoteClients");
            return C2013a.m7695a().m7700c();
        }

        /* renamed from: c */
        public void mo1751c(String name) throws RemoteException {
            LogUtil.d("CarLifePlatform", "CLPlatformService.getAlbumList");
            C2017c client = C2013a.m7695a().m7699c(name);
            if (client != null) {
                try {
                    client.m7723b();
                } catch (Throwable e) {
                    LogUtil.m4432a("PlatformManager", e);
                }
            }
        }

        /* renamed from: d */
        public void mo1752d(String name) throws RemoteException {
            LogUtil.d("CarLifePlatform", "CLPlatformService.disconnectApp");
            C2017c client = C2013a.m7695a().m7699c(name);
            if (client != null) {
                client.m7725d();
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return this.f6512a;
    }
}
