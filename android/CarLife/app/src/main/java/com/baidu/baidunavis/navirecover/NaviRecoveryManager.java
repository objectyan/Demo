package com.baidu.baidunavis.navirecover;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.Html;
import com.baidu.baidunavis.BaiduNaviManager;
import com.baidu.baidunavis.NavMapAdapter;
import com.baidu.baidunavis.ui.widget.NavTipTool;
import com.baidu.mapframework.nirvana.looper.MainLooperHandler;
import com.baidu.mapframework.nirvana.module.Module;
import com.baidu.mapframework.nirvana.schedule.ScheduleConfig;
import com.baidu.mapframework.widget.BMAlertDialog;
import com.baidu.mapframework.widget.BMAlertDialog.Builder;
import com.baidu.navisdk.util.worker.BNWorkerCenter;
import com.baidu.navisdk.util.worker.BNWorkerConfig;
import com.baidu.navisdk.util.worker.BNWorkerNormalTask;
import com.baidu.platform.comapi.C2907c;
import java.io.File;
import java.io.FilenameFilter;

public class NaviRecoveryManager {
    private static final int CRASH_STANDARD_TIME = 300;
    public static final String DUMP_FILE_SUFFIX = ".dmp";
    public static final String NAVI_RECO_DIALOG = "navi_reco_dialog";
    public static final String NAVI_RECO_NEG_CLICK = "navi_reco_neg_click";
    public static final String NAVI_RECO_POS_CLICK = "navi_reco_pos_click";
    public static final String NAVI_RECO_SUCCESS = "navi_reco_success";
    public static final String NAVI_RECO_TAG = "naviRecovery";
    private static final int RECOVER_STANDARD_TIME = 900;
    private static final int SLEEP_TIME = 500;
    private static NaviRecoveryManager sInstance = null;
    private BMAlertDialog naviRecoverDialog;

    public static NaviRecoveryManager getInstance() {
        if (sInstance == null) {
            synchronized (NaviRecoveryManager.class) {
                if (sInstance == null) {
                    sInstance = new NaviRecoveryManager();
                }
            }
        }
        return sInstance;
    }

    public void markCrashTime() {
        NaviRecoveryModel.getInstance().markCrashTime(System.currentTimeMillis() / 1000);
    }

    private boolean hasCrashed() {
        if ((System.currentTimeMillis() / 1000) - NaviRecoveryModel.getInstance().getCrashTime() >= 300) {
            return hasNaCrashed();
        }
        NaviRecoveryModel.getInstance().markCrashTime(0);
        return true;
    }

    private boolean hasKilled(Context context) {
        if ((System.currentTimeMillis() / 1000) - BaiduNaviManager.getInstance().getKilledTime(context) >= 300 || !BaiduNaviManager.getInstance().isLastNaviUnfinished(context)) {
            return false;
        }
        BaiduNaviManager.getInstance().setKilledTime(context, 0);
        return true;
    }

    private boolean hasNaCrashed() {
        File dumpDir = new File(C2907c.m10977f().getCacheDir(), "dump");
        if (!dumpDir.exists()) {
            return false;
        }
        File lastestDumpFiles = getLastModifiedFile(dumpDir.getAbsolutePath(), DUMP_FILE_SUFFIX);
        if (lastestDumpFiles == null) {
            return false;
        }
        long lastNaCrashTime = lastestDumpFiles.lastModified();
        if (lastNaCrashTime == NaviRecoveryModel.getInstance().getNaCrashTime() || (System.currentTimeMillis() / 1000) - (lastNaCrashTime / 1000) >= 300) {
            return false;
        }
        NaviRecoveryModel.getInstance().markNaCrashTime(lastNaCrashTime);
        return true;
    }

    public static File getLastModifiedFile(String dir, final String suffix) {
        File[] files = new File(dir).listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename) {
                return filename.endsWith(suffix);
            }
        });
        if (files == null || files.length <= 0) {
            return null;
        }
        File lastFile = files[0];
        for (int i = 1; i < files.length; i++) {
            if (files[i].lastModified() > lastFile.lastModified()) {
                lastFile = files[i];
            }
        }
        return lastFile;
    }

    private boolean hasRecovered() {
        return (System.currentTimeMillis() / 1000) - NaviRecoveryModel.getInstance().getRecoverTime() < 900;
    }

    private void clearLastNaviRoutelnfo(Handler handler) {
        BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("CarNavi-clearLastNaviRoutelnfo", null) {
            protected String execute() {
                while (!BaiduNaviManager.sIsEngineInitialFailed && !BaiduNaviManager.sIsBaseEngineInitialized) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("CarNavi-clearLastNaviRoutelnfo2", null) {
                    protected String execute() {
                        BaiduNaviManager.getInstance().clearLastNaviRoutelnfo();
                        return null;
                    }
                }, new BNWorkerConfig(100, 0));
                return null;
            }
        }, new BNWorkerConfig(100, 0));
    }

    public void recoverNavi(final Activity activity) {
        if (activity != null) {
            final Handler handler = new MainLooperHandler(Module.NAV_MODULE, ScheduleConfig.forData()) {
                public void onMessage(Message msg) {
                    NavMapAdapter.getInstance().dismissMProgressDialog();
                    switch (msg.arg1) {
                        case 0:
                            NavTipTool.onCreateToastDialog(activity, "导航恢复失败，请重新发起！");
                            return;
                        case 1:
                            BaiduNaviManager.getInstance().continueLastNavi();
                            NavMapAdapter.getInstance().addLog("naviRecovery.navi_reco_success");
                            return;
                        default:
                            return;
                    }
                }
            };
            boolean isCrashed = hasCrashed();
            boolean isKilled = hasKilled(activity);
            if (!isCrashed && !isKilled) {
                clearLastNaviRoutelnfo(handler);
            } else if (!BaiduNaviManager.getInstance().isLastNaviUnfinished(activity)) {
            } else {
                if (hasRecovered()) {
                    showNaviRecoverDialog(activity, handler);
                } else if (isCrashed) {
                    NavTipTool.onCreateToastDialog((Context) activity, "正在恢复上次导航...");
                    NavMapAdapter.getInstance().showMProgressDialog((FragmentActivity) activity, "正在恢复上次导航...", "", new OnCancelListener() {
                        public void onCancel(DialogInterface dialog) {
                            NaviRecoveryManager.this.clearLastNaviRoutelnfo(handler);
                        }
                    });
                    recoverNaviData(handler);
                } else if (isKilled) {
                    showNaviRecoverDialog(activity, handler);
                }
            }
        }
    }

    private void showNaviRecoverDialog(Activity activity, Handler handler) {
        final Activity activity2 = activity;
        final Handler handler2 = handler;
        BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("calcRouteForPBData", null) {

            /* renamed from: com.baidu.baidunavis.navirecover.NaviRecoveryManager$5$1 */
            class C08591 implements OnClickListener {
                C08591() {
                }

                public void onClick(DialogInterface dialog, int which) {
                    NavMapAdapter.getInstance().addLog("naviRecovery.navi_reco_neg_click");
                    NaviRecoveryManager.this.clearLastNaviRoutelnfo(handler2);
                }
            }

            /* renamed from: com.baidu.baidunavis.navirecover.NaviRecoveryManager$5$2 */
            class C08602 implements OnClickListener {
                C08602() {
                }

                public void onClick(DialogInterface dialog, int which) {
                    NavMapAdapter.getInstance().addLog("naviRecovery.navi_reco_pos_click");
                    NaviRecoveryManager.this.recoverNaviData(handler2);
                }
            }

            /* renamed from: com.baidu.baidunavis.navirecover.NaviRecoveryManager$5$3 */
            class C08613 implements OnCancelListener {
                C08613() {
                }

                public void onCancel(DialogInterface dialog) {
                    NavMapAdapter.getInstance().addLog("naviRecovery.navi_reco_neg_click");
                    NaviRecoveryManager.this.clearLastNaviRoutelnfo(handler2);
                }
            }

            protected String execute() {
                if (activity2 != null) {
                    NavMapAdapter.getInstance().addLog("naviRecovery.navi_reco_dialog");
                    try {
                        NaviRecoveryManager.this.naviRecoverDialog = new Builder(activity2).setTitle(Html.fromHtml("是否恢复上次的<font color='#3385ff'>导航</font><br>?")).setPositiveButton("恢复", new C08602()).setNegativeButton("放弃", new C08591()).create();
                        NaviRecoveryManager.this.naviRecoverDialog.setOnCancelListener(new C08613());
                        NaviRecoveryManager.this.naviRecoverDialog.show();
                    } catch (Exception e) {
                    }
                }
                return null;
            }
        }, new BNWorkerConfig(100, 0));
    }

    private void recoverNaviData(final Handler handler) {
        NaviRecoveryModel.getInstance().markRecoverTime(System.currentTimeMillis() / 1000);
        BNWorkerCenter.getInstance().submitNormalTask(new BNWorkerNormalTask<String, String>("CarNavi-recoverNaviData", null) {
            protected String execute() {
                while (!BaiduNaviManager.sIsEngineInitialFailed && !BaiduNaviManager.sIsBaseEngineInitialized) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                BNWorkerCenter.getInstance().submitMainThreadTask(new BNWorkerNormalTask<String, String>("CarNavi-recoverNaviData2", null) {
                    protected String execute() {
                        BaiduNaviManager.getInstance().checkLastNaviStatus(handler);
                        return null;
                    }
                }, new BNWorkerConfig(100, 0));
                return null;
            }
        }, new BNWorkerConfig(100, 0));
    }

    public void resetCrashAndKillTime(Context context) {
        hasCrashed();
        hasKilled(context);
    }

    public void cancelDialog() {
        if (this.naviRecoverDialog != null && this.naviRecoverDialog.isShowing()) {
            try {
                this.naviRecoverDialog.cancel();
            } catch (Exception e) {
            }
        }
    }
}
