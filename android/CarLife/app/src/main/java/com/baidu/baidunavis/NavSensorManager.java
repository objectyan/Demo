package com.baidu.baidunavis;

import com.baidu.navisdk.comapi.geolocate.ISensorChangeListener;
import com.baidu.navisdk.util.logic.BNSysSensorManager;

public class NavSensorManager {
    private ISensorChangeListener mSensorChangeListener;

    /* renamed from: com.baidu.baidunavis.NavSensorManager$1 */
    class C07581 implements ISensorChangeListener {
        C07581() {
        }

        public void onSensorChange(int angleX) {
            BaiduNaviManager.getInstance().setSensor(angleX);
        }
    }

    private static class LazyHolder {
        private static NavSensorManager sSensorManager = new NavSensorManager();

        private LazyHolder() {
        }
    }

    private NavSensorManager() {
        this.mSensorChangeListener = new C07581();
    }

    public static NavSensorManager getInstence() {
        return LazyHolder.sSensorManager;
    }

    public void addSensorChangeListener() {
        BNSysSensorManager.getInstance().addSensorChangeListener(this.mSensorChangeListener);
    }

    public void removeSensorChangeListener() {
        BNSysSensorManager.getInstance().removeSensorChangeListener(this.mSensorChangeListener);
    }
}
