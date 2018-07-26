package com.baidu.baidunavis.control;

import android.os.Message;
import com.baidu.mapframework.nirvana.looper.MainLooperHandler;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.navisdk.comapi.base.BNSubject;
import com.baidu.navisdk.comapi.commontool.BNAutoDayNightHelper;
import com.baidu.navisdk.comapi.commontool.BNDayNightChangedObserver;
import com.baidu.navisdk.ui.util.BNStyleManager;
import java.util.ArrayList;
import java.util.List;

public class NavDayNightController {
    private static final int MSG_Day = 1;
    private static final int MSG_Night = 2;
    private static NavDayNightController sInstance = null;
    private BNDayNightChangedObserver mDayNightChangedObserver = new C07831();
    private boolean mDayStyle = true;
    private MainLooperHandler mHandler = new MainLooperHandler(Module.NAV_MODULE, ScheduleConfig.forData()) {
        public void onMessage(Message msg) {
            if (msg.what == 1) {
                NavDayNightController.this.notifyDayNightChanged(true);
            } else if (msg.what == 2) {
                NavDayNightController.this.notifyDayNightChanged(false);
            }
        }
    };
    private List<OnDayNightChangedListener> mListeners = new ArrayList();

    /* renamed from: com.baidu.baidunavis.control.NavDayNightController$1 */
    class C07831 implements BNDayNightChangedObserver {
        C07831() {
        }

        public void update(BNSubject o, int type, int event, Object arg) {
            if (type == 1) {
                switch (event) {
                    case 2:
                    case 4:
                        NavDayNightController.this.setStyle(true);
                        return;
                    case 3:
                    case 5:
                        NavDayNightController.this.setStyle(false);
                        return;
                    default:
                        return;
                }
            }
        }
    }

    public interface OnDayNightChangedListener {
        void onDayNightChanged(boolean z);
    }

    private NavDayNightController() {
    }

    public static NavDayNightController getInstance() {
        if (sInstance == null) {
            sInstance = new NavDayNightController();
        }
        return sInstance;
    }

    public void init() {
        BNAutoDayNightHelper.getInstance().addObserver(this.mDayNightChangedObserver);
        BNAutoDayNightHelper.getInstance().updateDayNightMode();
    }

    public boolean isDay() {
        return this.mDayStyle;
    }

    public void registerDayNightListener(OnDayNightChangedListener hd) {
        if (hd != null && !this.mListeners.contains(hd)) {
            this.mListeners.add(hd);
        }
    }

    public void unregisterDayNightListener(OnDayNightChangedListener hd) {
        if (hd != null && this.mListeners.contains(hd)) {
            this.mListeners.remove(hd);
        }
    }

    private void notifyDayNightChanged(boolean isDay) {
        for (int i = 0; i < this.mListeners.size(); i++) {
            if (this.mListeners.get(i) != null) {
                ((OnDayNightChangedListener) this.mListeners.get(i)).onDayNightChanged(isDay);
            }
        }
    }

    public void setStyle(boolean dayStyle) {
        try {
            BNStyleManager.setDayStyle(dayStyle);
        } catch (Throwable th) {
        }
        this.mDayStyle = dayStyle;
        this.mHandler.sendEmptyMessage(this.mDayStyle ? 1 : 2);
    }
}
