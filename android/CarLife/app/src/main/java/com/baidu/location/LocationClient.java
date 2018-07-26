package com.baidu.location;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.location.Location;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.carlife.core.C1253f;
import com.baidu.location.p187a.C3189c;
import com.baidu.navisdk.lightnavi.LightNaviParams;
import com.baidu.navisdk.module.BusinessActivityManager;
import com.baidu.navisdk.ui.ugc.model.BNRCEventDetailsModel;
import com.baidu.platform.comapi.UIMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.apache.commons.logging.LogFactory;

public final class LocationClient {
    public static final int CONNECT_HOT_SPOT_FALSE = 0;
    public static final int CONNECT_HOT_SPOT_TRUE = 1;
    public static final int CONNECT_HOT_SPOT_UNKNOWN = -1;
    private static final int LOCATION_PROCESS_CHECK_DELAY_TIME = 1000;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_GPS = 1;
    public static final int LOC_DIAGNOSTIC_TYPE_BETTER_OPEN_WIFI = 2;
    public static final int LOC_DIAGNOSTIC_TYPE_FAIL_UNKNOWN = 9;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_LOC_PERMISSION = 4;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CHECK_NET = 3;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_CLOSE_FLYMODE = 7;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_INSERT_SIMCARD_OR_OPEN_WIFI = 6;
    public static final int LOC_DIAGNOSTIC_TYPE_NEED_OPEN_PHONE_LOC_SWITCH = 5;
    public static final int LOC_DIAGNOSTIC_TYPE_SERVER_FAIL = 8;
    private static final int MIN_REQUEST_SPAN = 1000;
    private static final int MSG_REG_LISTENER = 5;
    private static final int MSG_REG_NOTIFY_LISTENER = 8;
    private static final int MSG_REMOVE_NOTIFY = 10;
    private static final int MSG_REQ_LOC = 4;
    private static final int MSG_REQ_NOTIFY_LOC = 11;
    private static final int MSG_REQ_OFFLINE_LOC = 12;
    private static final int MSG_REQ_POI = 7;
    private static final int MSG_RIGSTER_NOTIFY = 9;
    private static final int MSG_SET_OPT = 3;
    private static final int MSG_START = 1;
    private static final int MSG_STOP = 2;
    private static final int MSG_UNREG_LISTENER = 6;
    public static String PREF_FILE_NAME = "pref_key";
    public static String PREF_KEY_NAME = "access_key";
    private static final String mTAG = "baidu_location_Client";
    private BDLocationListener NotifyLocationListenner = null;
    private Boolean firstConnected = Boolean.valueOf(true);
    private boolean inBLEDoorState = false;
    private boolean inDoorState = false;
    private boolean isScheduled = false;
    private boolean isWaitingForLocation = false;
    private boolean isWaitingLocTag = false;
    private long lastReceiveGpsTime = 0;
    private long lastReceiveLocationTime = 0;
    private Boolean mConfig_map = Boolean.valueOf(false);
    private Boolean mConfig_preimport = Boolean.valueOf(false);
    private ServiceConnection mConnection = new C31711(this);
    private Context mContext = null;
    private boolean mGpsStatus = false;
    private C3175a mHandler = new C3175a();
    private boolean mIsServiceBinded = false;
    private boolean mIsStarted = false;
    private String mKey;
    private BDLocation mLastLocation = null;
    private long mLastRequestTime = 0;
    private ArrayList<BDLocationListener> mLocationListeners = null;
    private final Object mLock = new Object();
    private final Messenger mMessenger = new Messenger(this.mHandler);
    private LocationClientOption mOption = new LocationClientOption();
    private String mPackName = null;
    private C3176b mScheduledRequest = null;
    private Messenger mServer = null;
    private String serviceName = null;

    /* renamed from: com.baidu.location.LocationClient$1 */
    class C31711 implements ServiceConnection {
        /* renamed from: a */
        final /* synthetic */ LocationClient f17251a;

        C31711(LocationClient locationClient) {
            this.f17251a = locationClient;
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            this.f17251a.mServer = new Messenger(iBinder);
            if (this.f17251a.mServer != null) {
                this.f17251a.mIsStarted = true;
                try {
                    Message obtain = Message.obtain(null, 11);
                    obtain.replyTo = this.f17251a.mMessenger;
                    obtain.setData(this.f17251a.getOptionBundle());
                    this.f17251a.mServer.send(obtain);
                    this.f17251a.mIsStarted = true;
                    if (this.f17251a.mOption != null) {
                        if (this.f17251a.firstConnected.booleanValue()) {
                            this.f17251a.firstConnected = Boolean.valueOf(false);
                            this.f17251a.requestOfflineLocation();
                        }
                        this.f17251a.mHandler.obtainMessage(4).sendToTarget();
                    }
                } catch (Exception e) {
                }
                this.f17251a.mIsServiceBinded = true;
            }
        }

        public void onServiceDisconnected(ComponentName componentName) {
            this.f17251a.mServer = null;
            this.f17251a.mIsStarted = false;
            this.f17251a.stop();
            this.f17251a.restartService3();
            Log.d(LocationClient.mTAG, "unbindservice...");
        }
    }

    /* renamed from: com.baidu.location.LocationClient$2 */
    class C31722 extends Thread {
        /* renamed from: a */
        final /* synthetic */ LocationClient f17252a;

        C31722(LocationClient locationClient) {
            this.f17252a = locationClient;
        }

        public void run() {
            try {
                C31722.sleep(1000);
            } catch (InterruptedException e) {
            }
            if (!this.f17252a.mIsServiceBinded) {
                this.f17252a.getRunningServiceInfo();
            }
        }
    }

    /* renamed from: com.baidu.location.LocationClient$3 */
    class C31733 implements Runnable {
        /* renamed from: a */
        final /* synthetic */ LocationClient f17253a;

        C31733(LocationClient locationClient) {
            this.f17253a = locationClient;
        }

        public void run() {
            this.f17253a.restartService2();
        }
    }

    /* renamed from: com.baidu.location.LocationClient$a */
    private class C3175a extends Handler {
        /* renamed from: a */
        final /* synthetic */ LocationClient f17255a;

        /* renamed from: com.baidu.location.LocationClient$a$1 */
        class C31741 implements Runnable {
            /* renamed from: a */
            final /* synthetic */ C3175a f17254a;

            C31741(C3175a c3175a) {
                this.f17254a = c3175a;
            }

            public void run() {
                this.f17254a.f17255a.restartService3();
            }
        }

        private C3175a(LocationClient locationClient) {
            this.f17255a = locationClient;
        }

        public void handleMessage(Message message) {
            Bundle data;
            int i;
            switch (message.what) {
                case 1:
                    this.f17255a.onStart();
                    return;
                case 2:
                    this.f17255a.onStop();
                    return;
                case 3:
                    this.f17255a.onSetOption(message);
                    return;
                case 4:
                    this.f17255a.onRequestLocation();
                    return;
                case 5:
                    this.f17255a.onRegisterListener(message);
                    return;
                case 6:
                    this.f17255a.onUnRegisterListener(message);
                    return;
                case 8:
                    this.f17255a.onRegisterNotifyLocationListener(message);
                    return;
                case 11:
                    this.f17255a.onRequestNotifyLocation();
                    return;
                case 12:
                    this.f17255a.onRequestOffLineLocation();
                    return;
                case 21:
                    this.f17255a.onNewLocation(message, 21);
                    return;
                case 26:
                    this.f17255a.onNewLocation(message, 26);
                    return;
                case 27:
                    this.f17255a.onNewNotifyLocation(message);
                    return;
                case 54:
                    if (this.f17255a.mOption.location_change_notify) {
                        this.f17255a.mGpsStatus = true;
                        return;
                    }
                    return;
                case 55:
                    if (this.f17255a.mOption.location_change_notify) {
                        this.f17255a.mGpsStatus = false;
                        return;
                    }
                    return;
                case 111:
                    this.f17255a.inBLEDoorState = false;
                    this.f17255a.inDoorState = false;
                    return;
                case 301:
                    this.f17255a.onNewCalibration(message);
                    return;
                case 303:
                    try {
                        data = message.getData();
                        int i2 = data.getInt("loctype");
                        i = data.getInt("diagtype");
                        byte[] byteArray = data.getByteArray("diagmessage");
                        if (i2 > 0 && i > 0 && byteArray != null && this.f17255a.mLocationListeners != null) {
                            Iterator it = this.f17255a.mLocationListeners.iterator();
                            while (it.hasNext()) {
                                ((BDLocationListener) it.next()).onLocDiagnosticMessage(i2, i, new String(byteArray, "UTF-8"));
                            }
                            return;
                        }
                        return;
                    } catch (Exception e) {
                        return;
                    }
                case 404:
                    try {
                        data = message.getData();
                        data.setClassLoader(BDLocation.class.getClassLoader());
                        this.f17255a.onNewNaviModeWifiLocation((BDLocation) data.getParcelable("navimodelocation"));
                        return;
                    } catch (Exception e2) {
                        return;
                    }
                case 406:
                    try {
                        Bundle data2 = message.getData();
                        byte[] byteArray2 = data2.getByteArray("mac");
                        String str = byteArray2 != null ? new String(byteArray2, "UTF-8") : null;
                        i = data2.getInt("hotspot", -1);
                        if (this.f17255a.mLocationListeners != null) {
                            Iterator it2 = this.f17255a.mLocationListeners.iterator();
                            while (it2.hasNext()) {
                                ((BDLocationListener) it2.next()).onConnectHotSpotMessage(str, i);
                            }
                            return;
                        }
                        return;
                    } catch (Exception e3) {
                        return;
                    }
                case 501:
                    this.f17255a.onNewUGCData(message);
                    return;
                case 502:
                    if (this.f17255a.mHandler != null) {
                        this.f17255a.mHandler.postDelayed(new C31741(this), 1000);
                        return;
                    }
                    return;
                case UIMsg.MSG_MAP_PANO_ROUTE_DATA /*601*/:
                    this.f17255a.onNewLocationTag(message);
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    /* renamed from: com.baidu.location.LocationClient$b */
    private class C3176b implements Runnable {
        /* renamed from: a */
        final /* synthetic */ LocationClient f17256a;

        private C3176b(LocationClient locationClient) {
            this.f17256a = locationClient;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            r3 = this;
            r0 = r3.f17256a;
            r1 = r0.mLock;
            monitor-enter(r1);
            r0 = r3.f17256a;	 Catch:{ all -> 0x0036 }
            r2 = 0;
            r0.isScheduled = r2;	 Catch:{ all -> 0x0036 }
            r0 = r3.f17256a;	 Catch:{ all -> 0x0036 }
            r0 = r0.mServer;	 Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x001d;
        L_0x0015:
            r0 = r3.f17256a;	 Catch:{ all -> 0x0036 }
            r0 = r0.mMessenger;	 Catch:{ all -> 0x0036 }
            if (r0 != 0) goto L_0x001f;
        L_0x001d:
            monitor-exit(r1);	 Catch:{ all -> 0x0036 }
        L_0x001e:
            return;
        L_0x001f:
            r0 = r3.f17256a;	 Catch:{ all -> 0x0036 }
            r0 = r0.mLocationListeners;	 Catch:{ all -> 0x0036 }
            if (r0 == 0) goto L_0x0034;
        L_0x0027:
            r0 = r3.f17256a;	 Catch:{ all -> 0x0036 }
            r0 = r0.mLocationListeners;	 Catch:{ all -> 0x0036 }
            r0 = r0.size();	 Catch:{ all -> 0x0036 }
            r2 = 1;
            if (r0 >= r2) goto L_0x0039;
        L_0x0034:
            monitor-exit(r1);	 Catch:{ all -> 0x0036 }
            goto L_0x001e;
        L_0x0036:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0036 }
            throw r0;
        L_0x0039:
            r0 = r3.f17256a;	 Catch:{ all -> 0x0036 }
            r0 = r0.mHandler;	 Catch:{ all -> 0x0036 }
            r2 = 4;
            r0 = r0.obtainMessage(r2);	 Catch:{ all -> 0x0036 }
            r0.sendToTarget();	 Catch:{ all -> 0x0036 }
            monitor-exit(r1);	 Catch:{ all -> 0x0036 }
            goto L_0x001e;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.location.LocationClient.b.run():void");
        }
    }

    public LocationClient(Context context) {
        this.mContext = context;
        this.mOption = new LocationClientOption();
    }

    public LocationClient(Context context, LocationClientOption locationClientOption) {
        this.mContext = context;
        this.mOption = locationClientOption;
    }

    private void callListeners(int i) {
        if (this.mLastLocation.getCoorType() == null) {
            this.mLastLocation.setCoorType(this.mOption.coorType);
        }
        if (this.isWaitingForLocation || ((this.mOption.location_change_notify && this.mLastLocation.getLocType() == 61) || this.mLastLocation.getLocType() == 66 || this.mLastLocation.getLocType() == 67 || this.inDoorState || this.mLastLocation.getLocType() == 161)) {
            if (this.mLocationListeners != null) {
                Iterator it = this.mLocationListeners.iterator();
                while (it.hasNext()) {
                    ((BDLocationListener) it.next()).onReceiveLocation(this.mLastLocation);
                }
            }
            if (this.mLastLocation.getLocType() != 66 && this.mLastLocation.getLocType() != 67) {
                this.isWaitingForLocation = false;
                this.lastReceiveLocationTime = System.currentTimeMillis();
            }
        }
    }

    private void checkLocationService() {
        String packageName;
        try {
            packageName = this.mContext.getPackageName();
        } catch (Exception e) {
            packageName = null;
        }
        if (packageName != null && packageName.equals(LightNaviParams.DEFAULT_PACKAGE_NAME)) {
            try {
                Object obj;
                for (RunningServiceInfo runningServiceInfo : ((ActivityManager) this.mContext.getSystemService(BusinessActivityManager.AUDIO_DIR)).getRunningServices(Integer.MAX_VALUE)) {
                    int i = runningServiceInfo.pid;
                    String str = runningServiceInfo.process;
                    packageName = runningServiceInfo.service.getShortClassName();
                    if ("com.baidu.BaiduMap:MapCoreService".equals(str) && "com.baidu.location.f".equals(packageName)) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    this.mHandler.postDelayed(new C31733(this), 1000);
                }
            } catch (Exception e2) {
            }
        }
    }

    public static BDLocation getBDLocationInCoorType(BDLocation bDLocation, String str) {
        BDLocation bDLocation2 = new BDLocation(bDLocation);
        double[] coorEncrypt = Jni.coorEncrypt(bDLocation.getLongitude(), bDLocation.getLatitude(), str);
        bDLocation2.setLatitude(coorEncrypt[1]);
        bDLocation2.setLongitude(coorEncrypt[0]);
        return bDLocation2;
    }

    private Bundle getOptionBundle() {
        if (this.mOption == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("packName", this.mPackName);
        bundle.putString("prodName", this.mOption.prodName);
        bundle.putString("coorType", this.mOption.coorType);
        bundle.putString("addrType", this.mOption.addrType);
        bundle.putBoolean("openGPS", this.mOption.openGps);
        bundle.putBoolean("location_change_notify", this.mOption.location_change_notify);
        bundle.putInt("scanSpan", this.mOption.scanSpan);
        bundle.putInt("timeOut", this.mOption.timeOut);
        bundle.putInt(LogFactory.PRIORITY_KEY, this.mOption.priority);
        bundle.putBoolean("enableSimulateGps", this.mOption.enableSimulateGps);
        bundle.putBoolean("needDirect", this.mOption.mIsNeedDeviceDirect);
        bundle.putBoolean("isneedaptag", this.mOption.isNeedAptag);
        bundle.putBoolean("isneedpoiregion", this.mOption.isNeedPoiRegion);
        bundle.putBoolean("isneedregular", this.mOption.isNeedRegular);
        bundle.putBoolean("isneedaptagd", this.mOption.isNeedAptagd);
        bundle.putBoolean("isneedaltitude", this.mOption.isNeedAltitude);
        bundle.putInt("autoNotifyMaxInterval", this.mOption.getAutoNotifyMaxInterval());
        bundle.putInt("autoNotifyMinTimeInterval", this.mOption.getAutoNotifyMinTimeInterval());
        bundle.putInt("autoNotifyMinDistance", this.mOption.getAutoNotifyMinDistance());
        bundle.putFloat("autoNotifyLocSensitivity", this.mOption.getAutoNotifyLocSensitivity());
        bundle.putInt("wifitimeout", this.mOption.wifiCacheTimeOut);
        return bundle;
    }

    private void getRunningServiceInfo() {
        try {
            for (RunningServiceInfo runningServiceInfo : ((ActivityManager) this.mContext.getSystemService(BusinessActivityManager.AUDIO_DIR)).getRunningServices(Integer.MAX_VALUE)) {
                int i = runningServiceInfo.pid;
                String str = runningServiceInfo.process;
                String shortClassName = runningServiceInfo.service.getShortClassName();
                if ("com.baidu.BaiduMap:MapCoreService".equals(str) && "com.baidu.location.f".equals(shortClassName)) {
                    if (i == 0) {
                        restartService();
                        return;
                    }
                    return;
                }
            }
        } catch (Exception e) {
        }
    }

    private void onNewCalibration(Message message) {
    }

    private void onNewLocation(Message message, int i) {
        try {
            Bundle data = message.getData();
            data.setClassLoader(BDLocation.class.getClassLoader());
            this.mLastLocation = (BDLocation) data.getParcelable("locStr");
            if (this.mLastLocation.getLocType() == 61 || this.mLastLocation.getGpsCheckStatus() == 1 || this.mLastLocation.getGpsCheckStatus() == 2) {
                this.lastReceiveGpsTime = System.currentTimeMillis();
            }
            callListeners(i);
        } catch (Exception e) {
        }
    }

    private void onNewLocationTag(Message message) {
        this.isWaitingLocTag = false;
        byte[] byteArray = message.getData().getByteArray("locationtag");
        String str = byteArray != null ? new String(byteArray) : null;
        if (this.mLocationListeners != null) {
            Iterator it = this.mLocationListeners.iterator();
            while (it.hasNext()) {
                ((BDLocationListener) it.next()).onReceiveLocationTag(str);
            }
        }
    }

    private void onNewNaviModeWifiLocation(BDLocation bDLocation) {
        if (this.mLocationListeners != null) {
            Iterator it = this.mLocationListeners.iterator();
            while (it.hasNext()) {
                ((BDLocationListener) it.next()).onReceiveNaviModeWifiLocation(bDLocation);
            }
        }
    }

    private void onNewNotifyLocation(Message message) {
        try {
            Bundle data = message.getData();
            data.setClassLoader(BDLocation.class.getClassLoader());
            BDLocation bDLocation = (BDLocation) data.getParcelable("locStr");
            if (this.NotifyLocationListenner == null) {
                return;
            }
            if (this.mOption == null || !this.mOption.isDisableCache() || bDLocation.getLocType() != 65) {
                this.NotifyLocationListenner.onReceiveLocation(bDLocation);
            }
        } catch (Exception e) {
        }
    }

    private void onNewUGCData(Message message) {
        byte[] byteArray = message.getData().getByteArray("gpsintimedata");
        if (byteArray != null && this.mLocationListeners != null) {
            Iterator it = this.mLocationListeners.iterator();
            while (it.hasNext()) {
                ((BDLocationListener) it.next()).onGPSLongLinkPushData(byteArray, 6);
            }
        }
    }

    private void onRegisterListener(Message message) {
        if (message != null && message.obj != null) {
            BDLocationListener bDLocationListener = (BDLocationListener) message.obj;
            if (this.mLocationListeners == null) {
                this.mLocationListeners = new ArrayList();
            }
            if (!this.mLocationListeners.contains(bDLocationListener)) {
                this.mLocationListeners.add(bDLocationListener);
            }
        }
    }

    private void onRegisterNotifyLocationListener(Message message) {
        if (message != null && message.obj != null) {
            this.NotifyLocationListenner = (BDLocationListener) message.obj;
        }
    }

    private void onRequestLocation() {
        if (this.mServer != null) {
            if ((System.currentTimeMillis() - this.lastReceiveGpsTime > 3000 || !this.mOption.location_change_notify || this.isWaitingLocTag) && (!this.inDoorState || System.currentTimeMillis() - this.lastReceiveLocationTime > 20000 || this.isWaitingLocTag)) {
                Message obtain = Message.obtain(null, 22);
                if (this.isWaitingLocTag) {
                    Bundle bundle = new Bundle();
                    bundle.putBoolean("isWaitingLocTag", this.isWaitingLocTag);
                    obtain.setData(bundle);
                }
                try {
                    obtain.replyTo = this.mMessenger;
                    this.mServer.send(obtain);
                    this.mLastRequestTime = System.currentTimeMillis();
                    this.isWaitingForLocation = true;
                } catch (Exception e) {
                    restartService3();
                }
            }
            synchronized (this.mLock) {
                if (!(this.mOption == null || this.mOption.scanSpan < 1000 || this.isScheduled)) {
                    if (this.mScheduledRequest == null) {
                        this.mScheduledRequest = new C3176b();
                    }
                    this.mHandler.postDelayed(this.mScheduledRequest, (long) this.mOption.scanSpan);
                    this.isScheduled = true;
                }
            }
        }
    }

    private void onRequestNotifyLocation() {
        if (this.mServer != null) {
            Message obtain = Message.obtain(null, 22);
            try {
                obtain.replyTo = this.mMessenger;
                this.mServer.send(obtain);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void onRequestOffLineLocation() {
        Message obtain = Message.obtain(null, 28);
        try {
            obtain.replyTo = this.mMessenger;
            this.mServer.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void onSetOption(Message message) {
        this.isWaitingLocTag = false;
        if (message != null && message.obj != null) {
            LocationClientOption locationClientOption = (LocationClientOption) message.obj;
            if (!this.mOption.optionEquals(locationClientOption)) {
                if (this.mOption.scanSpan != locationClientOption.scanSpan) {
                    try {
                        synchronized (this.mLock) {
                            if (this.isScheduled) {
                                this.mHandler.removeCallbacks(this.mScheduledRequest);
                                this.isScheduled = false;
                            }
                            if (locationClientOption.scanSpan >= 1000 && !this.isScheduled) {
                                if (this.mScheduledRequest == null) {
                                    this.mScheduledRequest = new C3176b();
                                }
                                this.mHandler.postDelayed(this.mScheduledRequest, (long) locationClientOption.scanSpan);
                                this.isScheduled = true;
                            }
                        }
                    } catch (Exception e) {
                    }
                }
                this.mOption = new LocationClientOption(locationClientOption);
                if (this.mServer != null) {
                    try {
                        Message obtain = Message.obtain(null, 15);
                        obtain.replyTo = this.mMessenger;
                        obtain.setData(getOptionBundle());
                        this.mServer.send(obtain);
                    } catch (Exception e2) {
                        restartService3();
                    }
                }
            }
        }
    }

    private void onStart() {
        if (!this.mIsStarted) {
            this.mPackName = this.mContext.getPackageName();
            this.serviceName = this.mPackName + "_bdls_v2.9";
            Intent intent = new Intent(this.mContext, C3377f.class);
            if (this.mOption == null) {
                this.mOption = new LocationClientOption();
            }
            intent.putExtra("cache_exception", this.mOption.isIgnoreCacheException);
            intent.putExtra("kill_process", this.mOption.isIgnoreKillProcess);
            try {
                this.mIsServiceBinded = false;
                this.mContext.bindService(intent, this.mConnection, 1);
                new C31722(this).start();
            } catch (Exception e) {
                e.printStackTrace();
                this.mIsStarted = false;
            }
        }
    }

    private void onStop() {
        if (this.mIsStarted && this.mServer != null) {
            Message obtain = Message.obtain(null, 12);
            obtain.replyTo = this.mMessenger;
            try {
                this.mServer.send(obtain);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                this.mContext.unbindService(this.mConnection);
            } catch (Exception e2) {
            }
            synchronized (this.mLock) {
                try {
                    if (this.isScheduled) {
                        this.mHandler.removeCallbacks(this.mScheduledRequest);
                        this.isScheduled = false;
                    }
                } catch (Exception e3) {
                }
            }
            this.mServer = null;
            this.isWaitingLocTag = false;
            this.inDoorState = false;
            this.inBLEDoorState = false;
            this.mIsStarted = false;
        }
    }

    private void onUnRegisterListener(Message message) {
        if (message != null && message.obj != null) {
            BDLocationListener bDLocationListener = (BDLocationListener) message.obj;
            if (this.mLocationListeners != null && this.mLocationListeners.contains(bDLocationListener)) {
                this.mLocationListeners.remove(bDLocationListener);
            }
        }
    }

    private int requestLocationtag() {
        if (this.mServer == null || this.mMessenger == null) {
            return 1;
        }
        if (this.mLocationListeners == null || this.mLocationListeners.size() < 1) {
            return 2;
        }
        this.isWaitingLocTag = true;
        this.mHandler.obtainMessage(4).sendToTarget();
        return 0;
    }

    private void restartService2() {
        try {
            this.mContext.bindService(new Intent(this.mContext, C3377f.class), this.mConnection, 1);
            this.mContext.startService(new Intent(this.mContext, C3377f.class));
        } catch (Exception e) {
        }
    }

    private void restartService3() {
    }

    private boolean sendServerMessage(int i) {
        if (this.mServer == null || !this.mIsStarted) {
            return false;
        }
        try {
            this.mServer.send(Message.obtain(null, i));
            return true;
        } catch (Exception e) {
            restartService3();
            return false;
        }
    }

    public boolean IBeaconValiable() {
        return VERSION.SDK_INT > 17 && this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
    }

    public void baiduMapSendChangeFloorMessage() {
        sendServerMessage(112);
    }

    public boolean baiduMapStartIndoorBleMode() {
        boolean sendServerMessage = sendServerMessage(121);
        if (sendServerMessage) {
            this.inDoorState = true;
            this.inBLEDoorState = true;
        }
        return sendServerMessage;
    }

    public boolean baiduMapStartIndoorMode() {
        boolean sendServerMessage = sendServerMessage(110);
        if (sendServerMessage) {
            this.inDoorState = true;
        }
        return sendServerMessage;
    }

    public boolean baiduMapStopCalibrationWhileIndoorMode() {
        return true;
    }

    public boolean baiduMapStopIndoorBleMode() {
        boolean sendServerMessage = sendServerMessage(C1253f.df);
        if (sendServerMessage) {
            this.inBLEDoorState = false;
        }
        return sendServerMessage;
    }

    public boolean baiduMapStopIndoorMode() {
        boolean sendServerMessage = sendServerMessage(111);
        if (sendServerMessage) {
            this.inDoorState = false;
        }
        return sendServerMessage;
    }

    public BDLocation getLastKnownLocation() {
        return this.mLastLocation;
    }

    public String getLocInfo() {
        try {
            String a = new C3189c(this.mContext).m13314a();
            return a != null ? Jni.encode(a) : a;
        } catch (Throwable th) {
            return null;
        }
    }

    public LocationClientOption getLocOption() {
        return this.mOption;
    }

    public String getVersion() {
        return "7.3.2";
    }

    public boolean isBLEIndoorMode() {
        return this.inBLEDoorState;
    }

    public boolean isIndoorMode() {
        return this.inDoorState;
    }

    public boolean isStarted() {
        return this.mIsStarted;
    }

    public void registerLocationListener(BDLocationListener bDLocationListener) {
        Message obtainMessage = this.mHandler.obtainMessage(5);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public void registerNotifyLocationListener(BDLocationListener bDLocationListener) {
        Message obtainMessage = this.mHandler.obtainMessage(8);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public boolean requestHotSpotState() {
        if (this.mServer == null || !this.mIsStarted) {
            return false;
        }
        try {
            this.mServer.send(Message.obtain(null, 406));
            return true;
        } catch (Exception e) {
            restartService3();
            return false;
        }
    }

    public int requestLocation() {
        if (this.mServer == null || this.mMessenger == null) {
            return 1;
        }
        if (this.mLocationListeners == null || this.mLocationListeners.size() < 1) {
            return 2;
        }
        if (System.currentTimeMillis() - this.mLastRequestTime < 1000) {
            return 6;
        }
        checkLocationService();
        this.mHandler.obtainMessage(4).sendToTarget();
        return 0;
    }

    public boolean requestLocationTag() {
        return requestLocationtag() == 0;
    }

    public void requestNotifyLocation() {
        this.mHandler.obtainMessage(11).sendToTarget();
    }

    public int requestOfflineLocation() {
        if (this.mServer == null || this.mMessenger == null) {
            return 1;
        }
        if (this.mLocationListeners == null || this.mLocationListeners.size() < 1) {
            return 2;
        }
        this.mHandler.obtainMessage(12).sendToTarget();
        return 0;
    }

    public void restartService() {
        try {
            this.mContext.unbindService(this.mConnection);
        } catch (Exception e) {
        }
        try {
            this.mContext.stopService(new Intent(this.mContext, C3377f.class));
        } catch (Exception e2) {
        }
        try {
            this.mContext.bindService(new Intent(this.mContext, C3377f.class), this.mConnection, 1);
            this.mContext.startService(new Intent(this.mContext, C3377f.class));
        } catch (Exception e3) {
        }
    }

    public void setAccessKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = Pattern.compile("[&=]").matcher(str).replaceAll("");
        }
        this.mKey = str;
        this.mContext.getSharedPreferences(PREF_FILE_NAME, 0).edit().putString(PREF_KEY_NAME, this.mKey).commit();
    }

    public void setForBaiduMap(boolean z) {
        this.mConfig_map = Boolean.valueOf(z);
    }

    public boolean setHotSpotUserCallbackInfo(boolean z) {
        if (this.mServer == null || !this.mIsStarted) {
            return false;
        }
        try {
            Message obtain = Message.obtain(null, 407);
            Bundle bundle = new Bundle();
            bundle.putBoolean(BNRCEventDetailsModel.BN_RC_KEY_USER, z);
            obtain.setData(bundle);
            this.mServer.send(obtain);
            return true;
        } catch (Exception e) {
            restartService3();
            return false;
        }
    }

    public void setLocOption(LocationClientOption locationClientOption) {
        if (locationClientOption == null) {
            locationClientOption = new LocationClientOption();
        }
        if (locationClientOption.getAutoNotifyMaxInterval() > 0) {
            locationClientOption.setScanSpan(0);
            locationClientOption.setLocationNotify(true);
        }
        Message obtainMessage = this.mHandler.obtainMessage(3);
        obtainMessage.obj = locationClientOption;
        obtainMessage.sendToTarget();
    }

    public boolean setNaviModeStatus(int i, int i2) {
        if (this.mServer == null || !this.mIsStarted) {
            return false;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt("source", i);
            bundle.putInt("status", i2);
            Message obtain = Message.obtain(null, 403);
            obtain.setData(bundle);
            this.mServer.send(obtain);
            return true;
        } catch (Exception e) {
            restartService3();
            return false;
        }
    }

    public boolean setRealTimeBusStationInfo(Bundle bundle) {
        if (this.mServer == null || !this.mIsStarted) {
            return false;
        }
        try {
            Message obtain = Message.obtain(null, 402);
            obtain.setData(bundle);
            this.mServer.send(obtain);
            return true;
        } catch (Exception e) {
            restartService3();
            return false;
        }
    }

    public boolean setUgcInfo(String str) {
        if (this.mServer == null || !this.mIsStarted) {
            return false;
        }
        try {
            Message obtain = Message.obtain(null, 401);
            Bundle bundle = new Bundle();
            bundle.putString("ugcInfo", str);
            obtain.setData(bundle);
            this.mServer.send(obtain);
            return true;
        } catch (Exception e) {
            restartService3();
            return false;
        }
    }

    public void start() {
        this.mHandler.obtainMessage(1).sendToTarget();
    }

    public void stop() {
        onStop();
    }

    public boolean triggerErrorReport(String str) {
        if (this.mServer == null || !this.mIsStarted) {
            return false;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putByteArray("errorid", str.getBytes());
            Message obtain = Message.obtain(null, 405);
            obtain.setData(bundle);
            this.mServer.send(obtain);
            return true;
        } catch (Exception e) {
            restartService3();
            return false;
        }
    }

    public void unRegisterLocationListener(BDLocationListener bDLocationListener) {
        Message obtainMessage = this.mHandler.obtainMessage(6);
        obtainMessage.obj = bDLocationListener;
        obtainMessage.sendToTarget();
    }

    public boolean updateLocation(Location location) {
        if (this.mServer == null || this.mMessenger == null || location == null) {
            return false;
        }
        try {
            Message obtain = Message.obtain(null, 57);
            obtain.obj = location;
            this.mServer.send(obtain);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
