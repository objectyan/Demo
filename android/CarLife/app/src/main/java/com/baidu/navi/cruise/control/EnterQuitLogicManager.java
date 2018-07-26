package com.baidu.navi.cruise.control;

import android.app.Activity;
import android.os.Handler;
import android.widget.Toast;
import com.baidu.carlife.C0965R;
import com.baidu.carlife.core.screen.presentation.C1328h;
import com.baidu.carlife.p085i.C1609a;
import com.baidu.carlife.util.C2201w;
import com.baidu.navi.cruise.BCruiser;
import com.baidu.navi.fragment.NaviFragmentManager;
import com.baidu.navi.style.StyleManager;
import com.baidu.navi.util.StatisticConstants;
import com.baidu.navi.util.StatisticManager;
import com.baidu.navisdk.comapi.geolocate.ILocationListener;
import com.baidu.navisdk.model.datastruct.LocData;
import com.baidu.navisdk.ui.cruise.IBCruiserListener;
import com.baidu.navisdk.ui.cruise.model.CruiseUIModel;
import com.baidu.navisdk.util.common.NetworkUtils;
import com.baidu.navisdk.util.logic.BNExtGPSLocationManager;
import com.baidu.navisdk.util.logic.BNLocationManager;
import com.baidu.navisdk.util.logic.BNSysLocationManager;
import java.util.Timer;
import java.util.TimerTask;

public class EnterQuitLogicManager {
    private static final float ENTER_CRUISE_COND_SPEED = 10.0f;
    private static int FIRST_DETECT_TIMER_DELAY = 20000;
    public static final int GPS_NETWORK_DETECT_DELAY_TIME = 10000;
    private static final int REPEAT_DETECT_TIMER_DELAY = 1000;
    private static EnterQuitLogicManager mInstance;
    private Activity mActivity;
    private IBCruiserListener mBCruiserListener;
    private NaviFragmentManager mFragmentManager;
    private ILocationListener mLocationListener = new C37523();
    private BNLocationManager mLocationManager;
    private float mMaxSpeed = 0.0f;
    private Timer mTimer;
    private TimerTask mTimerTask;

    /* renamed from: com.baidu.navi.cruise.control.EnterQuitLogicManager$1 */
    class C37501 extends TimerTask {
        C37501() {
        }

        public void run() {
            if (EnterQuitLogicManager.this.isEnterCriseFollowMode()) {
                EnterQuitLogicManager.this.stopTimer();
                EnterQuitLogicManager.this.enterCruiseFollowFragment();
                return;
            }
            EnterQuitLogicManager.this.startTimer(1000);
        }
    }

    /* renamed from: com.baidu.navi.cruise.control.EnterQuitLogicManager$2 */
    class C37512 implements Runnable {
        C37512() {
        }

        public void run() {
            C2201w.a(StyleManager.getString(C0965R.string.cruise_follow_enter_prompt_content), 0);
            StatisticManager.onEvent(StatisticConstants.NAVI_0007);
            EnterQuitLogicManager.this.mFragmentManager.showFragment(116, null);
        }
    }

    /* renamed from: com.baidu.navi.cruise.control.EnterQuitLogicManager$3 */
    class C37523 implements ILocationListener {
        C37523() {
        }

        public void onLocationChange(LocData locData) {
            if (locData != null && locData.isValid()) {
                float kmPerHour = (locData.speed * 3600.0f) / 1000.0f;
                if (kmPerHour > EnterQuitLogicManager.this.mMaxSpeed) {
                    EnterQuitLogicManager.this.mMaxSpeed = kmPerHour;
                }
            }
        }

        public void onGpsStatusChange(boolean enabled, boolean available) {
        }

        public void onWGS84LocationChange(LocData arg0, LocData arg1) {
        }
    }

    public static EnterQuitLogicManager getmInstance() {
        if (mInstance == null) {
            mInstance = new EnterQuitLogicManager();
        }
        return mInstance;
    }

    public void setActivity(Activity activity) {
        this.mActivity = activity;
    }

    public void setNaviFragmentManager(NaviFragmentManager fragmentManager) {
        this.mFragmentManager = fragmentManager;
    }

    public void setListener(IBCruiserListener listener) {
        this.mBCruiserListener = listener;
    }

    public synchronized void enterCruiseFollowModeDetect() {
        startTimer(FIRST_DETECT_TIMER_DELAY);
    }

    public synchronized void quitCruiseFollowMode() {
        stopTimer();
        quitCruiseFollowFragment();
    }

    public String cruiseEnterPromptTransfer(String content) {
        if (C1328h.a().getCurrentFragmentType() == 116 && content.equals(StyleManager.getString(C0965R.string.cruise_follow_enter_cruise_prompt_cotent))) {
            return "";
        }
        return content;
    }

    private EnterQuitLogicManager() {
    }

    private void startTimer(int duration) {
        clearSpeed();
        stopTimer();
        reInitLocationService();
        try {
            this.mTimer = new Timer();
            this.mTimerTask = new C37501();
            this.mTimer.schedule(this.mTimerTask, (long) duration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public synchronized void stopTimer() {
        if (this.mTimer != null) {
            this.mTimer.cancel();
            this.mTimer = null;
        }
        if (this.mTimerTask != null) {
            this.mTimerTask.cancel();
            this.mTimerTask = null;
        }
    }

    private boolean isEnterCriseFollowMode() {
        if (!isGPSDectectingSucess() || !isCarMoving()) {
            return false;
        }
        if (isNetworkAvailable() || isOffLineDataAvailable()) {
            return true;
        }
        return false;
    }

    public boolean isGPSDectectingSucess() {
        if (C1609a.a().b() && BNExtGPSLocationManager.getInstance().isGpsEnabled() && BNExtGPSLocationManager.getInstance().isGpsAvailable()) {
            return true;
        }
        return BNSysLocationManager.getInstance().isGpsAvailable();
    }

    public boolean isOffLineDataAvailable() {
        BCruiser.getInstance().checkCurrentProvinceDataDownloaded();
        return CruiseUIModel.getInstance().isProvinceDataDownloaded();
    }

    public boolean isNetworkAvailable() {
        return NetworkUtils.isNetworkAvailable(this.mActivity);
    }

    private void enterCruiseFollowFragment() {
        if (this.mFragmentManager != null && this.mFragmentManager.getCurrentFragmentType() == 17 && this.mActivity != null) {
            new Handler(this.mActivity.getMainLooper()).post(new C37512());
        }
    }

    private void quitCruiseFollowFragment() {
        if (C1328h.a().getCurrentFragmentType() == 116) {
            abandonGPS();
            if (this.mBCruiserListener != null) {
                this.mBCruiserListener.onPageJump(1, Integer.valueOf(0));
            }
        }
    }

    private boolean isCarMoving() {
        if (this.mMaxSpeed >= ENTER_CRUISE_COND_SPEED) {
            return true;
        }
        return false;
    }

    private void clearSpeed() {
        this.mMaxSpeed = 0.0f;
    }

    public void showTost(String content, int duration) {
        if (this.mActivity != null) {
            Toast.makeText(this.mActivity, content, duration).show();
        }
    }

    public void reInitLocationService() {
        abandonGPS();
        if (C1609a.a().b() && BNExtGPSLocationManager.getInstance().isGpsEnabled() && BNExtGPSLocationManager.getInstance().isGpsAvailable()) {
            this.mLocationManager = BNExtGPSLocationManager.getInstance();
        } else {
            this.mLocationManager = BNSysLocationManager.getInstance();
        }
        this.mMaxSpeed = 0.0f;
        this.mLocationManager.addLocationListener(this.mLocationListener);
    }

    private void abandonGPS() {
        if (this.mLocationManager != null && this.mLocationListener != null) {
            this.mLocationManager.removeLocationListener(this.mLocationListener);
        }
    }
}
