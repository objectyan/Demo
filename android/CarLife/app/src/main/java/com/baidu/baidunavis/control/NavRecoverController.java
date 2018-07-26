package com.baidu.baidunavis.control;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.model.NavCommonFuncModel;
import com.baidu.baidunavis.ui.widget.NavTipTool;
import com.baidu.baidunavis.wrapper.LogUtil;
import com.baidu.baidunavis.wrapper.NaviEngineInitListener;
import com.baidu.carlife.C0965R;
import com.baidu.navisdk.comapi.commontool.BNRecoverNaviHelper;
import com.baidu.navisdk.comapi.commontool.BNRecoverNaviHelper.LastNaviStatusListener;
import com.baidu.navisdk.model.datastruct.RoutePlanNode;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.platform.comapi.C2907c;
import java.util.ArrayList;

public class NavRecoverController {
    private static final String NAVI_FLAG_PREF = "pref_navi_flag";
    private static final String NAVI_KILL_TIME_PREF = "navi_kill_time_pref";
    private static final String TAG = "NavRecoverController";
    private static NavRecoverController sInstance = null;
    private ArrayList<RoutePlanNode> mLastRoutePlanNodes = new ArrayList();

    /* renamed from: com.baidu.baidunavis.control.NavRecoverController$3 */
    class C08183 implements NaviEngineInitListener {
        C08183() {
        }

        public void engineInitSuccess() {
            LogUtil.m3004e("SDKHelper", "engineInitSuccess");
            BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("InitBESuc-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    NavMapAdapter.getInstance().dismissMProgressDialog();
                    NavRoutePlanController.getInstance().continueLastNavi(NavRecoverController.this.mLastRoutePlanNodes);
                    return null;
                }
            }, new BNWorkerConfig(100, 0));
        }

        public void engineInitStart() {
            BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("InitBEStart-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    return null;
                }
            }, new BNWorkerConfig(100, 0));
        }

        public void engineInitFail() {
            BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("InitBEFail-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    NavMapAdapter.getInstance().showMToast(C2907c.m10977f(), (int) C0965R.string.nav_can_not_use);
                    NavMapAdapter.getInstance().dismissMProgressDialog();
                    return null;
                }
            }, new BNWorkerConfig(100, 0));
        }
    }

    /* renamed from: com.baidu.baidunavis.control.NavRecoverController$4 */
    class C08224 implements NaviEngineInitListener {
        C08224() {
        }

        public void engineInitSuccess() {
            LogUtil.m3004e("SDKHelper", "engineInitSuccess");
            BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("InitBaseEngSuc-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    NavMapAdapter.getInstance().dismissMProgressDialog();
                    NavLogUtils.m3003e(TAG, "clearLastNaviRoutelnfo");
                    NavRecoverController.this.mLastRoutePlanNodes.clear();
                    BNRecoverNaviHelper.getInstance().clearLastNaviInfo();
                    return null;
                }
            }, new BNWorkerConfig(100, 0));
        }

        public void engineInitStart() {
            BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("InitBaseEngStart-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    return null;
                }
            }, new BNWorkerConfig(100, 0));
        }

        public void engineInitFail() {
            BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("InitBaseEngFail-" + getClass().getSimpleName(), null) {
                protected String execute() {
                    NavMapAdapter.getInstance().showMToast(C2907c.m10977f(), (int) C0965R.string.nav_can_not_use);
                    NavMapAdapter.getInstance().dismissMProgressDialog();
                    return null;
                }
            }, new BNWorkerConfig(100, 0));
        }
    }

    public static NavRecoverController getInstance() {
        if (sInstance == null) {
            sInstance = new NavRecoverController();
        }
        return sInstance;
    }

    public boolean isLastNaviUnfinished(Context context) {
        if (context == null) {
            return false;
        }
        boolean finished = context.getSharedPreferences("navi", 0).getBoolean(NAVI_FLAG_PREF, false);
        NavLogUtils.m3003e(TAG, "isLastNaviUnfinished state : " + finished);
        return finished;
    }

    public long getKilledTime(Context context) {
        if (context == null) {
            return 0;
        }
        return context.getSharedPreferences("navi", 0).getLong(NAVI_KILL_TIME_PREF, 0);
    }

    public boolean checkLastNaviStatus(final Handler handler) {
        NavLogUtils.m3003e(TAG, "checkLastnaviStatus() ");
        BaiduNaviManager.getInstance();
        if (!BaiduNaviManager.isNaviSoLoadSuccess()) {
            return false;
        }
        Context activity = NavCommonFuncModel.getInstance().getActivity();
        if (activity == null || NavMapAdapter.getInstance().isExternalStorageEnabled()) {
            if (BaiduNaviManager.sIsBaseEngineInitialized) {
                checkLastNaviStatusInner(handler);
            } else if (activity == null) {
                return false;
            } else {
                BaiduNaviManager.getInstance().initBaseEngine(activity, new NaviEngineInitListener() {
                    public void engineInitSuccess() {
                        LogUtil.m3004e("SDKHelper", "engineInitSuccess");
                        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("RecoverEngSuc-" + getClass().getSimpleName(), null) {
                            protected String execute() {
                                NavMapAdapter.getInstance().dismissMProgressDialog();
                                NavRecoverController.this.checkLastNaviStatusInner(handler);
                                return null;
                            }
                        }, new BNWorkerConfig(100, 0));
                    }

                    public void engineInitStart() {
                        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("RecoverEngStart-" + getClass().getSimpleName(), null) {
                            protected String execute() {
                                return null;
                            }
                        }, new BNWorkerConfig(100, 0));
                    }

                    public void engineInitFail() {
                        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("RecoverEngFail-" + getClass().getSimpleName(), null) {
                            protected String execute() {
                                NavMapAdapter.getInstance().showMToast(C2907c.m10977f(), (int) C0965R.string.nav_can_not_use);
                                NavMapAdapter.getInstance().dismissMProgressDialog();
                                return null;
                            }
                        }, new BNWorkerConfig(100, 0));
                    }
                });
            }
            return true;
        }
        NavTipTool.onCreateToastDialog(activity, (int) C0965R.string.nav_no_sdcard);
        return false;
    }

    private void checkLastNaviStatusInner(final Handler handler) {
        BNRecoverNaviHelper.getInstance().checkLastNaviStatus(new LastNaviStatusListener() {
            public void onGetNodeList(ArrayList<RoutePlanNode> routePlanNodes) {
                int i = 0;
                NavRecoverController.this.mLastRoutePlanNodes.clear();
                if (!(routePlanNodes == null || routePlanNodes.isEmpty())) {
                    NavRecoverController.this.mLastRoutePlanNodes.addAll(routePlanNodes);
                }
                if (handler != null) {
                    Message msg = handler.obtainMessage(0);
                    if (!NavRecoverController.this.mLastRoutePlanNodes.isEmpty()) {
                        i = 1;
                    }
                    msg.arg1 = i;
                    NavLogUtils.m3003e(NavRecoverController.TAG, "checkLastNaviStatusInner result : " + msg.arg1);
                    msg.sendToTarget();
                }
            }
        });
    }

    public boolean continueLastNavi() {
        if (!BaiduNaviManager.isNaviSoLoadSuccess()) {
            return false;
        }
        Context activity = NavCommonFuncModel.getInstance().getActivity();
        if (activity == null || NavMapAdapter.getInstance().isExternalStorageEnabled()) {
            if (BaiduNaviManager.sIsBaseEngineInitialized) {
                NavLogUtils.m3003e(TAG, "continueLastNavi nodes size : " + this.mLastRoutePlanNodes.size());
                if (NavLogUtils.LOGGABLE && this.mLastRoutePlanNodes.size() > 0) {
                    for (int i = 0; i < this.mLastRoutePlanNodes.size(); i++) {
                        NavLogUtils.m3003e(TAG, " node " + i + " is : " + ((RoutePlanNode) this.mLastRoutePlanNodes.get(i)).toString());
                    }
                }
                NavRoutePlanController.getInstance().continueLastNavi(this.mLastRoutePlanNodes);
            } else if (activity == null) {
                return false;
            } else {
                BaiduNaviManager.getInstance().initBaseEngine(activity, new C08183());
            }
            return true;
        }
        NavTipTool.onCreateToastDialog(activity, (int) C0965R.string.nav_no_sdcard);
        return false;
    }

    public boolean clearLastNaviRoutelnfo() {
        BaiduNaviManager.getInstance();
        if (!BaiduNaviManager.isNaviSoLoadSuccess()) {
            return false;
        }
        Context activity = NavCommonFuncModel.getInstance().getActivity();
        if (activity == null || NavMapAdapter.getInstance().isExternalStorageEnabled()) {
            if (BaiduNaviManager.sIsBaseEngineInitialized) {
                NavLogUtils.m3003e(TAG, "clearLastNaviRoutelnfo");
                this.mLastRoutePlanNodes.clear();
                BNRecoverNaviHelper.getInstance().clearLastNaviInfo();
                BNRecoverNaviHelper.getInstance().setNaviFlag(activity.getApplicationContext(), false);
            } else if (activity == null) {
                return false;
            } else {
                BaiduNaviManager.getInstance().initBaseEngine(activity, new C08224());
            }
            return true;
        }
        NavTipTool.onCreateToastDialog(activity, (int) C0965R.string.nav_no_sdcard);
        return false;
    }

    public ArrayList<RoutePlanNode> getLastRoutePlanNoes() {
        return this.mLastRoutePlanNodes;
    }
}
