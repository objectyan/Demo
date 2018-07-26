package com.baidu.navisdk.debug.commonui;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.baidu.carlife.core.C1253f;
import com.baidu.navisdk.ui.routeguide.control.RGViewController;
import com.baidu.navisdk.util.common.ScreenUtil;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DebugCommonUIController {
    public static final String DEBUG_MODULE_LOCATION = "debug_module_location";
    private static final int MSG_TIMER = 1;
    private static DebugCommonUIController sInstance = null;
    private DebugCommonUIView mCurCommonUIView = null;
    private ConcurrentMap<String, DebugCommonUIView> mDebugModuleViews = new ConcurrentHashMap();
    private Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                if (DebugCommonUIController.this.mCurCommonUIView != null) {
                    DebugCommonUIController.this.mCurCommonUIView.refresh();
                }
                DebugCommonUIController.this.mHandler.removeMessages(1);
                DebugCommonUIController.this.mHandler.sendEmptyMessageDelayed(1, 1000);
            }
        }
    };
    private boolean mTimerInited = false;

    private DebugCommonUIController() {
    }

    public static DebugCommonUIController getInstance() {
        if (sInstance == null) {
            synchronized (DebugCommonUIController.class) {
                if (sInstance == null) {
                    sInstance = new DebugCommonUIController();
                }
            }
        }
        return sInstance;
    }

    public ViewGroup getContainer() {
        return (ViewGroup) RGViewController.getInstance().getView();
    }

    public void showUI(String debugModuleName, DebugCommonUICallback callback) {
        if (debugModuleName != null && debugModuleName.length() != 0) {
            try {
                DebugCommonUIView debugView;
                ViewGroup rg = getContainer();
                if (this.mDebugModuleViews.containsKey(debugModuleName)) {
                    debugView = (DebugCommonUIView) this.mDebugModuleViews.get(debugModuleName);
                } else {
                    DebugCommonUIView debugView2 = new DebugCommonUIView(callback);
                    try {
                        this.mDebugModuleViews.put(debugModuleName, debugView2);
                        debugView = debugView2;
                    } catch (Exception e) {
                        debugView = debugView2;
                        return;
                    }
                }
                if (debugView != null) {
                    if (this.mCurCommonUIView != null) {
                        this.mCurCommonUIView.hide();
                        if (rg != null) {
                            rg.removeView(this.mCurCommonUIView.getView());
                        }
                    }
                    this.mCurCommonUIView = debugView;
                    if (debugView.getView().getParent() != null) {
                        ((ViewGroup) debugView.getView().getParent()).removeView(debugView.getView());
                    }
                    debugView.show();
                    if (rg != null) {
                        rg.addView(debugView.getView(), new LayoutParams(ScreenUtil.getInstance().dip2px(400), ScreenUtil.getInstance().dip2px(C1253f.eJ)));
                        rg.setVisibility(0);
                    }
                }
                initTimer();
            } catch (Exception e2) {
            }
        }
    }

    public void hideUI(String debugModuleName) {
        if (debugModuleName != null && debugModuleName.length() != 0) {
            try {
                if (this.mDebugModuleViews.containsKey(debugModuleName)) {
                    DebugCommonUIView debugView = (DebugCommonUIView) this.mDebugModuleViews.get(debugModuleName);
                    debugView.hide();
                    ViewGroup rg = getContainer();
                    if (rg != null) {
                        rg.removeView(debugView.getView());
                    }
                    if (this.mCurCommonUIView == debugView) {
                        this.mCurCommonUIView = null;
                    }
                }
            } catch (Exception e) {
            }
        }
    }

    public void updateUIInfo(String debugModuleName, String info) {
        if (debugModuleName != null && debugModuleName.length() != 0 && this.mDebugModuleViews.containsKey(debugModuleName)) {
            ((DebugCommonUIView) this.mDebugModuleViews.get(debugModuleName)).updateInfo(info, false);
        }
    }

    private void initTimer() {
        if (!this.mTimerInited) {
            synchronized (DebugCommonUIController.class) {
                if (!this.mTimerInited) {
                    this.mTimerInited = true;
                    this.mHandler.removeMessages(1);
                    this.mHandler.sendEmptyMessageDelayed(1, 1000);
                }
            }
        }
    }
}
