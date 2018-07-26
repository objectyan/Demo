package com.baidu.navisdk.comapi.commontool;

import android.os.Handler;
import android.os.Looper;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.commontool.sunrisedown.BNSunRiseDownTimeHelper;
import com.baidu.navisdk.comapi.commontool.sunrisedown.BNSunRiseDownTimeHelper.SunRiseDownHM;
import com.baidu.navisdk.comapi.setting.BNSettingManager;
import com.baidu.navisdk.model.GeoLocateModel;
import com.baidu.navisdk.naviresult.BNNaviResultController;
import com.baidu.navisdk.ui.routeguide.BNavigator;
import com.baidu.navisdk.ui.routeguide.subview.util.RightHandResourcesProvider;
import com.baidu.navisdk.util.common.LogUtil;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.nplatform.comapi.basestruct.GeoPoint;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class BNAutoDayNightHelper extends BNSubject {
    private static Timer mDayNightTimer = null;
    private static BNAutoDayNightHelper mInstance;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private boolean mIsTimerStart;
    private Object mRunLock = new Object();

    /* renamed from: com.baidu.navisdk.comapi.commontool.BNAutoDayNightHelper$1 */
    class C40491 extends TimerTask {
        C40491() {
        }

        public void run() {
            LogUtil.m15791e("TIMER", "Timer task get time to set navi mode");
            BNAutoDayNightHelper.this.switchDayNightMode();
        }
    }

    private BNAutoDayNightHelper() {
    }

    public static BNAutoDayNightHelper getInstance() {
        if (mInstance == null) {
            mInstance = new BNAutoDayNightHelper();
        }
        return mInstance;
    }

    public void startDayNightTimer() {
        if (mDayNightTimer == null) {
            try {
                mDayNightTimer = new Timer(getClass().getSimpleName() + "_daynight", true);
                mDayNightTimer.schedule(new C40491(), 0, 600000);
                this.mIsTimerStart = true;
            } catch (Throwable th) {
                mDayNightTimer = null;
            }
        }
    }

    public void stopDayNightTimer() {
        if (mDayNightTimer != null) {
            mDayNightTimer.cancel();
            mDayNightTimer = null;
            this.mIsTimerStart = false;
        }
    }

    public boolean isTimerStart() {
        return this.mIsTimerStart;
    }

    public void switchDayNightMode() {
        SunRiseDownHM riseDown = BNSunRiseDownTimeHelper.getIntanse().calulatetm(39.92d, 116.46d);
        GeoPoint geoPt = GeoLocateModel.getInstance().getLastGeoPoint();
        if (RightHandResourcesProvider.getEnNaviType() == 1) {
            if (geoPt != null) {
                riseDown = BNSunRiseDownTimeHelper.getIntanse().calulatetm((double) (geoPt.getLatitudeE6() / 100000), (double) (geoPt.getLongitudeE6() / 100000));
                BNSunRiseDownTimeHelper.getIntanse().updateInternationalTimeZone(riseDown);
            }
        } else if (geoPt != null && geoPt.getLatitudeE6() > 0 && geoPt.getLongitudeE6() > 0) {
            riseDown = BNSunRiseDownTimeHelper.getIntanse().calulatetm((double) (geoPt.getLatitudeE6() / 100000), (double) (geoPt.getLongitudeE6() / 100000));
        }
        long curtime = System.currentTimeMillis();
        Calendar c = Calendar.getInstance();
        c.set(11, riseDown.getDownHour());
        c.set(12, riseDown.getDownMin());
        long downtime = c.getTimeInMillis();
        c.set(11, riseDown.getRiseHour());
        c.set(12, riseDown.getRiseMin());
        int i;
        if (curtime <= c.getTimeInMillis() || curtime >= downtime) {
            i = 3;
            if (BNavigator.getInstance().isNaviBegin()) {
                i = 5;
            }
            if (BNNaviResultController.getInstance().isNaviResultShowing()) {
                i = 2;
            }
            notifyDayNightObservers(1, i, null);
            return;
        }
        i = 2;
        if (BNavigator.getInstance().isNaviBegin()) {
            i = 4;
        }
        try {
            if (BNNaviResultController.getInstance().isNaviResultShowing()) {
                i = 2;
            }
        } catch (Throwable th) {
        }
        notifyDayNightObservers(1, i, null);
    }

    private boolean getDayNightMode() {
        SunRiseDownHM riseDown = BNSunRiseDownTimeHelper.getIntanse().calulatetm(39.92d, 116.46d);
        GeoPoint geoPt = GeoLocateModel.getInstance().getLastGeoPoint();
        if (RightHandResourcesProvider.getEnNaviType() == 1) {
            if (geoPt != null) {
                riseDown = BNSunRiseDownTimeHelper.getIntanse().calulatetm((double) (geoPt.getLatitudeE6() / 100000), (double) (geoPt.getLongitudeE6() / 100000));
                BNSunRiseDownTimeHelper.getIntanse().updateInternationalTimeZone(riseDown);
            }
        } else if (geoPt != null && geoPt.getLatitudeE6() > 0 && geoPt.getLongitudeE6() > 0) {
            riseDown = BNSunRiseDownTimeHelper.getIntanse().calulatetm((double) (geoPt.getLatitudeE6() / 100000), (double) (geoPt.getLongitudeE6() / 100000));
        }
        long curtime = System.currentTimeMillis();
        Calendar c = Calendar.getInstance();
        c.set(11, riseDown.getDownHour());
        c.set(12, riseDown.getDownMin());
        long downtime = c.getTimeInMillis();
        c.set(11, riseDown.getRiseHour());
        c.set(12, riseDown.getRiseMin());
        if (curtime <= c.getTimeInMillis() || curtime >= downtime) {
            return false;
        }
        return true;
    }

    private boolean getDayNightModeFinal() {
        int dayNightMode = BNSettingManager.getNaviDayAndNightMode();
        if (dayNightMode == 2 || dayNightMode == 4) {
            if (!isTimerStart()) {
                return true;
            }
            stopDayNightTimer();
            return true;
        } else if (dayNightMode == 3 || dayNightMode == 5) {
            if (isTimerStart()) {
                stopDayNightTimer();
            }
            return false;
        } else if (dayNightMode != 1) {
            return true;
        } else {
            if (!isTimerStart()) {
                startDayNightTimer();
            }
            return getDayNightMode();
        }
    }

    public void updateDayNightMode() {
        int style;
        if (getDayNightModeFinal()) {
            style = 2;
            if (BNavigator.getInstance().isNaviBegin()) {
                style = 4;
            }
            if (BNNaviResultController.getInstance().isNaviResultShowing()) {
                style = 2;
            }
            notifyDayNightObservers(1, style, null);
            return;
        }
        style = 3;
        if (BNavigator.getInstance().isNaviBegin()) {
            style = 5;
        }
        if (BNNaviResultController.getInstance().isNaviResultShowing()) {
            style = 2;
        }
        notifyDayNightObservers(1, style, null);
    }

    private void notifyDayNightObservers(int type, int event, Object arg) {
        synchronized (this.mRunLock) {
            this.mRunLock.notifyAll();
            final int i = type;
            final int i2 = event;
            final Object obj = arg;
            BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("notifyDayNightObservers-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    BNAutoDayNightHelper.this.notifyObservers(i, i2, obj);
                    return null;
                }
            }, new BNWorkerConfig(100, 0));
        }
    }
}
