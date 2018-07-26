package com.baidu.vi;

import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class VGps {
    private static int GPS_VALID_SAT_QUANTITY = 3;
    private static final int MSG_INIT_GPS = 2;
    private static final int MSG_INVALID_GPS = 1;
    private static final int MSG_UNINIT_GPS = 3;
    private static Handler mHandler = new C52383();
    private int mGpsSatellitesNum = 0;
    private GpsStatus mGpsStatus = null;
    private int mJniData = 0;
    private LocationListener mLocationListener = new C52372(this);
    private LocationManager mLocationManager = null;
    private Listener mStatusListener = new C52361(this);

    /* renamed from: com.baidu.vi.VGps$1 */
    class C52361 implements Listener {
        /* renamed from: a */
        final /* synthetic */ VGps f21733a;

        C52361(VGps this$0) {
            this.f21733a = this$0;
        }

        public void onGpsStatusChanged(int event) {
            switch (event) {
                case 2:
                    this.f21733a.updateGps(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
                    return;
                case 4:
                    if (this.f21733a.mLocationManager != null) {
                        if (this.f21733a.mGpsStatus == null) {
                            this.f21733a.mGpsStatus = this.f21733a.mLocationManager.getGpsStatus(null);
                        } else {
                            this.f21733a.mLocationManager.getGpsStatus(this.f21733a.mGpsStatus);
                        }
                    }
                    int i = 0;
                    for (GpsSatellite satellite : this.f21733a.mGpsStatus.getSatellites()) {
                        if (satellite.usedInFix()) {
                            i++;
                        }
                    }
                    if (i < VGps.GPS_VALID_SAT_QUANTITY && this.f21733a.mGpsSatellitesNum >= VGps.GPS_VALID_SAT_QUANTITY) {
                        this.f21733a.delayInvalidGPS();
                    }
                    this.f21733a.mGpsSatellitesNum = i;
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.vi.VGps$2 */
    class C52372 implements LocationListener {
        /* renamed from: a */
        final /* synthetic */ VGps f21734a;

        C52372(VGps this$0) {
            this.f21734a = this$0;
        }

        public void onLocationChanged(Location location) {
            if (location != null) {
                float Accuracy = 0.0f;
                if (location.hasAccuracy()) {
                    Accuracy = location.getAccuracy();
                }
                if (this.f21734a.mGpsSatellitesNum >= VGps.GPS_VALID_SAT_QUANTITY) {
                    this.f21734a.updateGps(location.getLongitude(), location.getLatitude(), (float) (((double) location.getSpeed()) * 3.6d), location.getBearing(), Accuracy, this.f21734a.mGpsSatellitesNum);
                } else {
                    this.f21734a.delayInvalidGPS();
                }
            }
        }

        public void onProviderDisabled(String provider) {
            this.f21734a.updateGps(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
        }

        public void onProviderEnabled(String provider) {
        }

        public void onStatusChanged(String provider, int status, Bundle extras) {
            switch (status) {
                case 0:
                case 1:
                    this.f21734a.updateGps(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: com.baidu.vi.VGps$3 */
    static class C52383 extends Handler {
        C52383() {
        }

        public void handleMessage(Message msg) {
            VGps vgps = msg.obj;
            if (vgps != null) {
                switch (msg.what) {
                    case 1:
                        if (vgps.mGpsSatellitesNum < VGps.GPS_VALID_SAT_QUANTITY) {
                            vgps.updateGps(0.0d, 0.0d, 0.0f, 0.0f, 0.0f, 0);
                            return;
                        }
                        return;
                    case 2:
                        if (VIContext.getContext() != null) {
                            vgps.mLocationManager = (LocationManager) VIContext.getContext().getSystemService("location");
                            vgps.mLocationManager.addGpsStatusListener(vgps.mStatusListener);
                            return;
                        }
                        return;
                    case 3:
                        if (vgps.mLocationManager != null) {
                            vgps.mLocationManager.removeGpsStatusListener(vgps.mStatusListener);
                            vgps.mLocationManager.removeUpdates(vgps.mLocationListener);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public native void updateGps(double d, double d2, float f, float f2, float f3, int i);

    public int getGpsSatellitesNum() {
        return this.mGpsSatellitesNum;
    }

    private synchronized void delayInvalidGPS() {
        if (!mHandler.hasMessages(1)) {
            mHandler.sendMessageDelayed(mHandler.obtainMessage(1, this), 3000);
        }
    }

    public boolean init() {
        mHandler.removeMessages(2);
        mHandler.sendMessage(mHandler.obtainMessage(2, this));
        return true;
    }

    public boolean unInit() {
        mHandler.removeMessages(1);
        mHandler.removeMessages(3);
        mHandler.sendMessage(mHandler.obtainMessage(3, this));
        return true;
    }
}
